package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class VectorDrawableCompat extends VectorDrawableCommon {
    private static final boolean DBG_VECTOR_DRAWABLE = false;
    static final PorterDuff.Mode DEFAULT_TINT_MODE = null;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    static final String LOGTAG = "VectorDrawableCompat";
    private static final int MAX_CACHED_BITMAP_SIZE = 2048;
    private static final String SHAPE_CLIP_PATH = "clip-path";
    private static final String SHAPE_GROUP = "group";
    private static final String SHAPE_PATH = "path";
    private static final String SHAPE_VECTOR = "vector";
    private boolean mAllowCaching;
    private Drawable.ConstantState mCachedConstantStateDelegate;
    private ColorFilter mColorFilter;
    private boolean mMutated;
    private PorterDuffColorFilter mTintFilter;
    private final Rect mTmpBounds;
    private final float[] mTmpFloats;
    private final Matrix mTmpMatrix;
    private VectorDrawableCompatState mVectorState;

    /* JADX INFO: renamed from: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class VClipPath extends VPath {
        VClipPath() {
        }

        VClipPath(VClipPath r10) {
            super(r10);
        }

        private void updateStateFromTypedArray(TypedArray r10, XmlPullParser r11) {
            String r12 = r10.getString(0);
            if (r12 == null) goto L5;
            this.mPathName = r12;
        L5:
            String r13 = r10.getString(1);
            if (r13 == null) goto L8;
            this.mNodes = PathParser.createNodesFromPathData(r13);
        L8:
            this.mFillRule = TypedArrayUtils.getNamedInt(r10, r11, "fillType", 2, 0);
        }

        public void inflate(Resources r10, AttributeSet r11, Resources.Theme r12, XmlPullParser r13) {
            if (TypedArrayUtils.hasAttribute(r13, "pathData") == true) goto L5;
            return;
        L5:
            TypedArray r14 = TypedArrayUtils.obtainAttributes(r10, r12, r11, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH);
            updateStateFromTypedArray(r14, r13);
            r14.recycle();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public boolean isClipPath() {
            return true;
        }
    }

    private static class VFullPath extends VPath {
        float mFillAlpha;
        ComplexColorCompat mFillColor;
        float mStrokeAlpha;
        ComplexColorCompat mStrokeColor;
        Paint.Cap mStrokeLineCap;
        Paint.Join mStrokeLineJoin;
        float mStrokeMiterlimit;
        float mStrokeWidth;
        private int[] mThemeAttrs;
        float mTrimPathEnd;
        float mTrimPathOffset;
        float mTrimPathStart;

        VFullPath() {
            this.mStrokeWidth = 0.0f;
            this.mStrokeAlpha = 1.0f;
            this.mFillAlpha = 1.0f;
            this.mTrimPathStart = 0.0f;
            this.mTrimPathEnd = 1.0f;
            this.mTrimPathOffset = 0.0f;
            this.mStrokeLineCap = Paint.Cap.BUTT;
            this.mStrokeLineJoin = Paint.Join.MITER;
            this.mStrokeMiterlimit = 4.0f;
        }

        VFullPath(VFullPath r10) {
            super(r10);
            this.mStrokeWidth = 0.0f;
            this.mStrokeAlpha = 1.0f;
            this.mFillAlpha = 1.0f;
            this.mTrimPathStart = 0.0f;
            this.mTrimPathEnd = 1.0f;
            this.mTrimPathOffset = 0.0f;
            this.mStrokeLineCap = Paint.Cap.BUTT;
            this.mStrokeLineJoin = Paint.Join.MITER;
            this.mStrokeMiterlimit = 4.0f;
            this.mThemeAttrs = r10.mThemeAttrs;
            this.mStrokeColor = r10.mStrokeColor;
            this.mStrokeWidth = r10.mStrokeWidth;
            this.mStrokeAlpha = r10.mStrokeAlpha;
            this.mFillColor = r10.mFillColor;
            this.mFillRule = r10.mFillRule;
            this.mFillAlpha = r10.mFillAlpha;
            this.mTrimPathStart = r10.mTrimPathStart;
            this.mTrimPathEnd = r10.mTrimPathEnd;
            this.mTrimPathOffset = r10.mTrimPathOffset;
            this.mStrokeLineCap = r10.mStrokeLineCap;
            this.mStrokeLineJoin = r10.mStrokeLineJoin;
            this.mStrokeMiterlimit = r10.mStrokeMiterlimit;
        }

        private Paint.Cap getStrokeLineCap(int r10, Paint.Cap r11) {
            if (r10 == 0) goto L13;
            if (r10 == 1) goto L11;
            if (r10 == 2) goto L9;
            return r11;
        L9:
            return Paint.Cap.SQUARE;
        L11:
            return Paint.Cap.ROUND;
        L13:
            return Paint.Cap.BUTT;
        }

        private Paint.Join getStrokeLineJoin(int r10, Paint.Join r11) {
            if (r10 == 0) goto L13;
            if (r10 == 1) goto L11;
            if (r10 == 2) goto L9;
            return r11;
        L9:
            return Paint.Join.BEVEL;
        L11:
            return Paint.Join.ROUND;
        L13:
            return Paint.Join.MITER;
        }

        private void updateStateFromTypedArray(TypedArray r10, XmlPullParser r11, Resources.Theme r12) {
            this.mThemeAttrs = null;
            if (TypedArrayUtils.hasAttribute(r11, "pathData") == true) goto L5;
            return;
        L5:
            String r13 = r10.getString(0);
            if (r13 == null) goto L8;
            this.mPathName = r13;
        L8:
            String r14 = r10.getString(2);
            if (r14 == null) goto L11;
            this.mNodes = PathParser.createNodesFromPathData(r14);
        L11:
            this.mFillColor = TypedArrayUtils.getNamedComplexColor(r10, r11, r12, "fillColor", 1, 0);
            this.mFillAlpha = TypedArrayUtils.getNamedFloat(r10, r11, "fillAlpha", 12, this.mFillAlpha);
            this.mStrokeLineCap = getStrokeLineCap(TypedArrayUtils.getNamedInt(r10, r11, "strokeLineCap", 8, -1), this.mStrokeLineCap);
            this.mStrokeLineJoin = getStrokeLineJoin(TypedArrayUtils.getNamedInt(r10, r11, "strokeLineJoin", 9, -1), this.mStrokeLineJoin);
            this.mStrokeMiterlimit = TypedArrayUtils.getNamedFloat(r10, r11, "strokeMiterLimit", 10, this.mStrokeMiterlimit);
            this.mStrokeColor = TypedArrayUtils.getNamedComplexColor(r10, r11, r12, "strokeColor", 3, 0);
            this.mStrokeAlpha = TypedArrayUtils.getNamedFloat(r10, r11, "strokeAlpha", 11, this.mStrokeAlpha);
            this.mStrokeWidth = TypedArrayUtils.getNamedFloat(r10, r11, "strokeWidth", 4, this.mStrokeWidth);
            this.mTrimPathEnd = TypedArrayUtils.getNamedFloat(r10, r11, "trimPathEnd", 6, this.mTrimPathEnd);
            this.mTrimPathOffset = TypedArrayUtils.getNamedFloat(r10, r11, "trimPathOffset", 7, this.mTrimPathOffset);
            this.mTrimPathStart = TypedArrayUtils.getNamedFloat(r10, r11, "trimPathStart", 5, this.mTrimPathStart);
            this.mFillRule = TypedArrayUtils.getNamedInt(r10, r11, "fillType", 13, this.mFillRule);
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public void applyTheme(Resources.Theme r10) {
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public boolean canApplyTheme() {
            if (this.mThemeAttrs == null) goto L5;
            return true;
        L5:
            return false;
        }

        float getFillAlpha() {
            return this.mFillAlpha;
        }

        @ColorInt
        int getFillColor() {
            return this.mFillColor.getColor();
        }

        float getStrokeAlpha() {
            return this.mStrokeAlpha;
        }

        @ColorInt
        int getStrokeColor() {
            return this.mStrokeColor.getColor();
        }

        float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        float getTrimPathEnd() {
            return this.mTrimPathEnd;
        }

        float getTrimPathOffset() {
            return this.mTrimPathOffset;
        }

        float getTrimPathStart() {
            return this.mTrimPathStart;
        }

        public void inflate(Resources r10, AttributeSet r11, Resources.Theme r12, XmlPullParser r13) {
            TypedArray r14 = TypedArrayUtils.obtainAttributes(r10, r12, r11, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_PATH);
            updateStateFromTypedArray(r14, r13, r12);
            r14.recycle();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean isStateful() {
            if (this.mFillColor.isStateful() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.mStrokeColor.isStateful() == true) goto L8;
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean onStateChanged(int[] r10) {
            boolean r11 = this.mFillColor.onStateChanged(r10);
            return this.mStrokeColor.onStateChanged(r10) | r11;
        }

        void setFillAlpha(float r10) {
            this.mFillAlpha = r10;
        }

        void setFillColor(int r10) {
            this.mFillColor.setColor(r10);
        }

        void setStrokeAlpha(float r10) {
            this.mStrokeAlpha = r10;
        }

        void setStrokeColor(int r10) {
            this.mStrokeColor.setColor(r10);
        }

        void setStrokeWidth(float r10) {
            this.mStrokeWidth = r10;
        }

        void setTrimPathEnd(float r10) {
            this.mTrimPathEnd = r10;
        }

        void setTrimPathOffset(float r10) {
            this.mTrimPathOffset = r10;
        }

        void setTrimPathStart(float r10) {
            this.mTrimPathStart = r10;
        }
    }

    private static class VGroup extends VObject {
        int mChangingConfigurations;
        final ArrayList<VObject> mChildren;
        private String mGroupName;
        final Matrix mLocalMatrix;
        private float mPivotX;
        private float mPivotY;
        float mRotate;
        private float mScaleX;
        private float mScaleY;
        final Matrix mStackedMatrix;
        private int[] mThemeAttrs;
        private float mTranslateX;
        private float mTranslateY;

        public VGroup() {
            super(null);
            this.mStackedMatrix = new Matrix();
            this.mChildren = new ArrayList();
            this.mRotate = 0.0f;
            this.mPivotX = 0.0f;
            this.mPivotY = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mTranslateX = 0.0f;
            this.mTranslateY = 0.0f;
            this.mLocalMatrix = new Matrix();
            this.mGroupName = null;
        }

        public VGroup(VGroup r10, ArrayMap<String, Object> r11) {
            super(null);
            this.mStackedMatrix = new Matrix();
            this.mChildren = new ArrayList();
            this.mRotate = 0.0f;
            this.mPivotX = 0.0f;
            this.mPivotY = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mTranslateX = 0.0f;
            this.mTranslateY = 0.0f;
            Matrix r12 = new Matrix();
            this.mLocalMatrix = r12;
            this.mGroupName = null;
            this.mRotate = r10.mRotate;
            this.mPivotX = r10.mPivotX;
            this.mPivotY = r10.mPivotY;
            this.mScaleX = r10.mScaleX;
            this.mScaleY = r10.mScaleY;
            this.mTranslateX = r10.mTranslateX;
            this.mTranslateY = r10.mTranslateY;
            this.mThemeAttrs = r10.mThemeAttrs;
            String r13 = r10.mGroupName;
            this.mGroupName = r13;
            this.mChangingConfigurations = r10.mChangingConfigurations;
            if (r13 == null) goto L5;
            r11.put(r13, this);
        L5:
            r12.set(r10.mLocalMatrix);
            ArrayList<VObject> r14 = r10.mChildren;
            int r15 = 0;
        L7:
            if (r15 >= r14.size()) goto L23;
            VObject r16 = r14.get(r15);
            if ((r16 instanceof VGroup) == false) goto L12;
            this.mChildren.add(new VGroup((VGroup) r16, r11));
        L20:
            r15 = r15 + 1;
            goto L7
        L12:
            if ((r16 instanceof VFullPath) == false) goto L15;
            VPath r17 = new VFullPath((VFullPath) r16);
        L17:
            this.mChildren.add(r17);
            String r18 = r17.mPathName;
            if (r18 == null) goto L20;
            r11.put(r18, r17);
            goto L20
        L15:
            if ((r16 instanceof VClipPath) == false) goto L22;
            r17 = new VClipPath((VClipPath) r16);
            goto L17
        L22:
            throw new IllegalStateException("Unknown object in the tree!");
        }

        private void updateLocalMatrix() {
            this.mLocalMatrix.reset();
            this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
            this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
            this.mLocalMatrix.postRotate(this.mRotate, 0.0f, 0.0f);
            this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
        }

        private void updateStateFromTypedArray(TypedArray r10, XmlPullParser r11) {
            this.mThemeAttrs = null;
            this.mRotate = TypedArrayUtils.getNamedFloat(r10, r11, Key.ROTATION, 5, this.mRotate);
            this.mPivotX = r10.getFloat(1, this.mPivotX);
            this.mPivotY = r10.getFloat(2, this.mPivotY);
            this.mScaleX = TypedArrayUtils.getNamedFloat(r10, r11, "scaleX", 3, this.mScaleX);
            this.mScaleY = TypedArrayUtils.getNamedFloat(r10, r11, "scaleY", 4, this.mScaleY);
            this.mTranslateX = TypedArrayUtils.getNamedFloat(r10, r11, "translateX", 6, this.mTranslateX);
            this.mTranslateY = TypedArrayUtils.getNamedFloat(r10, r11, "translateY", 7, this.mTranslateY);
            String r12 = r10.getString(0);
            if (r12 == null) goto L5;
            this.mGroupName = r12;
        L5:
            updateLocalMatrix();
        }

        public String getGroupName() {
            return this.mGroupName;
        }

        public Matrix getLocalMatrix() {
            return this.mLocalMatrix;
        }

        public float getPivotX() {
            return this.mPivotX;
        }

        public float getPivotY() {
            return this.mPivotY;
        }

        public float getRotation() {
            return this.mRotate;
        }

        public float getScaleX() {
            return this.mScaleX;
        }

        public float getScaleY() {
            return this.mScaleY;
        }

        public float getTranslateX() {
            return this.mTranslateX;
        }

        public float getTranslateY() {
            return this.mTranslateY;
        }

        public void inflate(Resources r10, AttributeSet r11, Resources.Theme r12, XmlPullParser r13) {
            TypedArray r14 = TypedArrayUtils.obtainAttributes(r10, r12, r11, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
            updateStateFromTypedArray(r14, r13);
            r14.recycle();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean isStateful() {
            int r10 = 0;
        L4:
            if (r10 >= this.mChildren.size()) goto L10;
            if (this.mChildren.get(r10).isStateful() == true) goto L7;
            r10 = r10 + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean onStateChanged(int[] r10) {
            int r11 = 0;
            boolean r12 = false;
        L4:
            if (r11 >= this.mChildren.size()) goto L6;
            r12 = r12 | this.mChildren.get(r11).onStateChanged(r10);
            r11 = r11 + 1;
            goto L4
        L6:
            return r12;
        }

        public void setPivotX(float r10) {
            if (r10 == this.mPivotX) goto L6;
            this.mPivotX = r10;
            updateLocalMatrix();
            return;
        }

        public void setPivotY(float r10) {
            if (r10 == this.mPivotY) goto L6;
            this.mPivotY = r10;
            updateLocalMatrix();
            return;
        }

        public void setRotation(float r10) {
            if (r10 == this.mRotate) goto L6;
            this.mRotate = r10;
            updateLocalMatrix();
            return;
        }

        public void setScaleX(float r10) {
            if (r10 == this.mScaleX) goto L6;
            this.mScaleX = r10;
            updateLocalMatrix();
            return;
        }

        public void setScaleY(float r10) {
            if (r10 == this.mScaleY) goto L6;
            this.mScaleY = r10;
            updateLocalMatrix();
            return;
        }

        public void setTranslateX(float r10) {
            if (r10 == this.mTranslateX) goto L6;
            this.mTranslateX = r10;
            updateLocalMatrix();
            return;
        }

        public void setTranslateY(float r10) {
            if (r10 == this.mTranslateY) goto L6;
            this.mTranslateY = r10;
            updateLocalMatrix();
            return;
        }
    }

    private static abstract class VObject {
        private VObject() {
        }

        /* synthetic */ VObject(AnonymousClass1 r10) {
            this();
        }

        public boolean isStateful() {
            return false;
        }

        public boolean onStateChanged(int[] r10) {
            return false;
        }
    }

    private static abstract class VPath extends VObject {
        protected static final int FILL_TYPE_WINDING = 0;
        int mChangingConfigurations;
        int mFillRule;
        protected PathParser.PathDataNode[] mNodes;
        String mPathName;

        public VPath() {
            super(null);
            this.mNodes = null;
            this.mFillRule = 0;
        }

        public VPath(VPath r10) {
            super(null);
            this.mNodes = null;
            this.mFillRule = 0;
            this.mPathName = r10.mPathName;
            this.mChangingConfigurations = r10.mChangingConfigurations;
            this.mNodes = PathParser.deepCopyNodes(r10.mNodes);
        }

        public void applyTheme(Resources.Theme r10) {
        }

        public boolean canApplyTheme() {
            return false;
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.mNodes;
        }

        public String getPathName() {
            return this.mPathName;
        }

        public boolean isClipPath() {
            return false;
        }

        public String nodesToString(PathParser.PathDataNode[] r10) {
            String r11 = " ";
            int r12 = 0;
        L4:
            if (r12 >= r10.length) goto L10;
            r11 = r11 + r10[r12].mType + ":";
            float[] r13 = r10[r12].mParams;
            int r14 = 0;
        L7:
            if (r14 >= r13.length) goto L9;
            r11 = r11 + r13[r14] + ",";
            r14 = r14 + 1;
            goto L7
        L9:
            r12 = r12 + 1;
            goto L4
        L10:
            return r11;
        }

        public void printVPath(int r10) {
            String r11 = "";
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L5;
            r11 = r11 + "    ";
            r12 = r12 + 1;
            goto L3
        L5:
            Log.v(VectorDrawableCompat.LOGTAG, r11 + "current path is :" + this.mPathName + " pathData is " + nodesToString(this.mNodes));
        }

        public void setPathData(PathParser.PathDataNode[] r10) {
            if (PathParser.canMorph(this.mNodes, r10) == true) goto L5;
            this.mNodes = PathParser.deepCopyNodes(r10);
            return;
        L5:
            PathParser.updateNodes(this.mNodes, r10);
        }

        public void toPath(Path r10) {
            r10.reset();
            PathParser.PathDataNode[] r11 = this.mNodes;
            if (r11 == null) goto L6;
            PathParser.PathDataNode.nodesToPath(r11, r10);
            return;
        }
    }

    private static class VPathRenderer {
        private static final Matrix IDENTITY_MATRIX = null;
        float mBaseHeight;
        float mBaseWidth;
        private int mChangingConfigurations;
        Paint mFillPaint;
        private final Matrix mFinalPathMatrix;
        Boolean mIsStateful;
        private final Path mPath;
        private PathMeasure mPathMeasure;
        private final Path mRenderPath;
        int mRootAlpha;
        final VGroup mRootGroup;
        String mRootName;
        Paint mStrokePaint;
        final ArrayMap<String, Object> mVGTargetsMap;
        float mViewportHeight;
        float mViewportWidth;

        static {
            IDENTITY_MATRIX = new Matrix();
        }

        public VPathRenderer() {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mIsStateful = null;
            this.mVGTargetsMap = new ArrayMap();
            this.mRootGroup = new VGroup();
            this.mPath = new Path();
            this.mRenderPath = new Path();
        }

        public VPathRenderer(VPathRenderer r10) {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mIsStateful = null;
            ArrayMap<String, Object> r11 = new ArrayMap();
            this.mVGTargetsMap = r11;
            this.mRootGroup = new VGroup(r10.mRootGroup, r11);
            this.mPath = new Path(r10.mPath);
            this.mRenderPath = new Path(r10.mRenderPath);
            this.mBaseWidth = r10.mBaseWidth;
            this.mBaseHeight = r10.mBaseHeight;
            this.mViewportWidth = r10.mViewportWidth;
            this.mViewportHeight = r10.mViewportHeight;
            this.mChangingConfigurations = r10.mChangingConfigurations;
            this.mRootAlpha = r10.mRootAlpha;
            this.mRootName = r10.mRootName;
            String r12 = r10.mRootName;
            if (r12 == null) goto L5;
            r11.put(r12, this);
        L5:
            this.mIsStateful = r10.mIsStateful;
        }

        private static float cross(float r10, float r11, float r12, float r13) {
            return (r10 * r13) - (r11 * r12);
        }

        private void drawGroupTree(VGroup r10, Matrix r11, Canvas r12, int r13, int r14, ColorFilter r15) {
            r10.mStackedMatrix.set(r11);
            r10.mStackedMatrix.preConcat(r10.mLocalMatrix);
            r12.save();
            int r16 = 0;
        L4:
            if (r16 >= r10.mChildren.size()) goto L12;
            VObject r17 = r10.mChildren.get(r16);
            if ((r17 instanceof VGroup) == false) goto L9;
            drawGroupTree((VGroup) r17, r10.mStackedMatrix, r12, r13, r14, r15);
        L11:
            r16 = r16 + 1;
            goto L4
        L9:
            if ((r17 instanceof VPath) == false) goto L11;
            drawPath(r10, (VPath) r17, r12, r13, r14, r15);
            goto L11
        L12:
            r12.restore();
        }

        private void drawPath(VGroup r10, VPath r11, Canvas r12, int r13, int r14, ColorFilter r15) {
            float r16 = r13 / this.mViewportWidth;
            float r17 = r14 / this.mViewportHeight;
            float r18 = Math.min(r16, r17);
            Matrix r19 = r10.mStackedMatrix;
            this.mFinalPathMatrix.set(r19);
            this.mFinalPathMatrix.postScale(r16, r17);
            float r20 = getMatrixScale(r19);
            if (r20 != 0.0f) goto L5;
            return;
        L5:
            r11.toPath(this.mPath);
            Path r110 = this.mPath;
            this.mRenderPath.reset();
            if (r11.isClipPath() == false) goto L12;
            Path r21 = this.mRenderPath;
            if (r11.mFillRule != 0) goto L10;
            Path.FillType r22 = Path.FillType.WINDING;
        L11:
            r21.setFillType(r22);
            this.mRenderPath.addPath(r110, this.mFinalPathMatrix);
            r12.clipPath(this.mRenderPath);
            return;
        L10:
            r22 = Path.FillType.EVEN_ODD;
            goto L11
        L12:
            VFullPath r23 = (VFullPath) r11;
            float r24 = r23.mTrimPathStart;
            if (r24 == 0.0f) goto L15;
        L16:
            float r25 = r23.mTrimPathOffset;
            float r26 = (r24 + r25) % 1.0f;
            float r27 = (r23.mTrimPathEnd + r25) % 1.0f;
            if (this.mPathMeasure != null) goto L19;
            this.mPathMeasure = new PathMeasure();
        L19:
            this.mPathMeasure.setPath(this.mPath, false);
            float r28 = this.mPathMeasure.getLength();
            float r29 = r26 * r28;
            float r30 = r27 * r28;
            r110.reset();
            if (r29 <= r30) goto L22;
            this.mPathMeasure.getSegment(r29, r28, r110, true);
            this.mPathMeasure.getSegment(0.0f, r30, r110, true);
        L23:
            r110.rLineTo(0.0f, 0.0f);
        L24:
            this.mRenderPath.addPath(r110, this.mFinalPathMatrix);
            if (r23.mFillColor.willDraw() == false) goto L39;
            ComplexColorCompat r111 = r23.mFillColor;
            if (this.mFillPaint != null) goto L29;
            Paint r31 = new Paint(1);
            this.mFillPaint = r31;
            r31.setStyle(Paint.Style.FILL);
        L29:
            Paint r32 = this.mFillPaint;
            if (r111.isGradient() == false) goto L32;
            Shader r112 = r111.getShader();
            r112.setLocalMatrix(this.mFinalPathMatrix);
            r32.setShader(r112);
            r32.setAlpha(Math.round(r23.mFillAlpha * 255.0f));
        L33:
            r32.setColorFilter(r15);
            Path r113 = this.mRenderPath;
            if (r23.mFillRule != 0) goto L36;
            Path.FillType r33 = Path.FillType.WINDING;
        L37:
            r113.setFillType(r33);
            r12.drawPath(this.mRenderPath, r32);
            goto L39
        L36:
            r33 = Path.FillType.EVEN_ODD;
            goto L37
        L32:
            r32.setShader(null);
            r32.setAlpha(255);
            r32.setColor(VectorDrawableCompat.applyAlpha(r111.getColor(), r23.mFillAlpha));
        L39:
            if (r23.mStrokeColor.willDraw() == false) goto L56;
            ComplexColorCompat r114 = r23.mStrokeColor;
            if (this.mStrokePaint != null) goto L43;
            Paint r34 = new Paint(1);
            this.mStrokePaint = r34;
            r34.setStyle(Paint.Style.STROKE);
        L43:
            Paint r35 = this.mStrokePaint;
            Paint.Join r36 = r23.mStrokeLineJoin;
            if (r36 == null) goto L46;
            r35.setStrokeJoin(r36);
        L46:
            Paint.Cap r37 = r23.mStrokeLineCap;
            if (r37 == null) goto L49;
            r35.setStrokeCap(r37);
        L49:
            r35.setStrokeMiter(r23.mStrokeMiterlimit);
            if (r114.isGradient() == false) goto L52;
            Shader r115 = r114.getShader();
            r115.setLocalMatrix(this.mFinalPathMatrix);
            r35.setShader(r115);
            r35.setAlpha(Math.round(r23.mStrokeAlpha * 255.0f));
        L53:
            r35.setColorFilter(r15);
            r35.setStrokeWidth(r23.mStrokeWidth * (r18 * r20));
            r12.drawPath(this.mRenderPath, r35);
            return;
        L52:
            r35.setShader(null);
            r35.setAlpha(255);
            r35.setColor(VectorDrawableCompat.applyAlpha(r114.getColor(), r23.mStrokeAlpha));
            goto L53
        L56:
            return;
        L22:
            this.mPathMeasure.getSegment(r29, r30, r110, true);
            goto L23
        L15:
            if (r23.mTrimPathEnd == 1.0f) goto L24;
            goto L16
        }

        private float getMatrixScale(Matrix r10) {
            float[] r11 = {0.0f, 1.0f, 1.0f, 0.0f};
            r10.mapVectors(r11);
            float r12 = (float) Math.hypot(r11[0], r11[1]);
            float r13 = (float) Math.hypot(r11[2], r11[3]);
            float r14 = cross(r11[0], r11[1], r11[2], r11[3]);
            float r15 = Math.max(r12, r13);
            if (r15 > 0.0f) goto L5;
            return 0.0f;
        L5:
            return Math.abs(r14) / r15;
        }

        public void draw(Canvas r10, int r11, int r12, ColorFilter r13) {
            drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, r10, r11, r12, r13);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.mRootAlpha;
        }

        public boolean isStateful() {
            if (this.mIsStateful != null) goto L6;
            this.mIsStateful = Boolean.valueOf(this.mRootGroup.isStateful());
        L6:
            return this.mIsStateful.booleanValue();
        }

        public boolean onStateChanged(int[] r10) {
            return this.mRootGroup.onStateChanged(r10);
        }

        public void setAlpha(float r10) {
            setRootAlpha((int) (r10 * 255.0f));
        }

        public void setRootAlpha(int r10) {
            this.mRootAlpha = r10;
        }
    }

    private static class VectorDrawableCompatState extends Drawable.ConstantState {
        boolean mAutoMirrored;
        boolean mCacheDirty;
        boolean mCachedAutoMirrored;
        Bitmap mCachedBitmap;
        int mCachedRootAlpha;
        int[] mCachedThemeAttrs;
        ColorStateList mCachedTint;
        PorterDuff.Mode mCachedTintMode;
        int mChangingConfigurations;
        Paint mTempPaint;
        ColorStateList mTint;
        PorterDuff.Mode mTintMode;
        VPathRenderer mVPathRenderer;

        public VectorDrawableCompatState() {
            this.mTint = null;
            this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
            this.mVPathRenderer = new VPathRenderer();
        }

        public VectorDrawableCompatState(VectorDrawableCompatState r10) {
            this.mTint = null;
            this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
            if (r10 == null) goto L12;
            this.mChangingConfigurations = r10.mChangingConfigurations;
            VPathRenderer r11 = new VPathRenderer(r10.mVPathRenderer);
            this.mVPathRenderer = r11;
            if (r10.mVPathRenderer.mFillPaint == null) goto L8;
            r11.mFillPaint = new Paint(r10.mVPathRenderer.mFillPaint);
        L8:
            if (r10.mVPathRenderer.mStrokePaint == null) goto L10;
            VPathRenderer r12 = this.mVPathRenderer;
            r12.mStrokePaint = new Paint(r10.mVPathRenderer.mStrokePaint);
        L10:
            this.mTint = r10.mTint;
            this.mTintMode = r10.mTintMode;
            this.mAutoMirrored = r10.mAutoMirrored;
            return;
        }

        public boolean canReuseBitmap(int r10, int r11) {
            if (r10 == this.mCachedBitmap.getWidth()) goto L5;
            return false;
        L5:
            if (r11 != this.mCachedBitmap.getHeight()) goto L10;
            return true;
        L10:
            return false;
        }

        public boolean canReuseCache() {
            if (this.mCacheDirty == false) goto L5;
            return false;
        L5:
            if (this.mCachedTint == this.mTint) goto L7;
            return false;
        L7:
            if (this.mCachedTintMode == this.mTintMode) goto L9;
            return false;
        L9:
            if (this.mCachedAutoMirrored == this.mAutoMirrored) goto L11;
            return false;
        L11:
            if (this.mCachedRootAlpha != this.mVPathRenderer.getRootAlpha()) goto L19;
            return true;
        L19:
            return false;
        }

        public void createCachedBitmapIfNeeded(int r10, int r11) {
            if (this.mCachedBitmap != null) goto L5;
        L6:
            this.mCachedBitmap = Bitmap.createBitmap(r10, r11, Bitmap.Config.ARGB_8888);
            this.mCacheDirty = true;
            return;
        L5:
            if (canReuseBitmap(r10, r11) == false) goto L6;
        }

        public void drawCachedBitmapWithRootAlpha(Canvas r10, ColorFilter r11, Rect r12) {
            Paint r13 = getPaint(r11);
            r10.drawBitmap(this.mCachedBitmap, null, r12, r13);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public Paint getPaint(ColorFilter r10) {
            if (hasTranslucentRoot() == true) goto L8;
            if (r10 != null) goto L8;
            return null;
        L8:
            if (this.mTempPaint != null) goto L10;
            Paint r11 = new Paint();
            this.mTempPaint = r11;
            r11.setFilterBitmap(true);
        L10:
            this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
            this.mTempPaint.setColorFilter(r10);
            return this.mTempPaint;
        }

        public boolean hasTranslucentRoot() {
            if (this.mVPathRenderer.getRootAlpha() >= 255) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isStateful() {
            return this.mVPathRenderer.isStateful();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources r10) {
            return new VectorDrawableCompat(this);
        }

        public boolean onStateChanged(int[] r10) {
            boolean r11 = this.mVPathRenderer.onStateChanged(r10);
            this.mCacheDirty |= r11;
            return r11;
        }

        public void updateCacheStates() {
            this.mCachedTint = this.mTint;
            this.mCachedTintMode = this.mTintMode;
            this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
            this.mCachedAutoMirrored = this.mAutoMirrored;
            this.mCacheDirty = false;
        }

        public void updateCachedBitmap(int r10, int r11) {
            this.mCachedBitmap.eraseColor(0);
            Canvas r12 = new Canvas(this.mCachedBitmap);
            this.mVPathRenderer.draw(r12, r10, r11, null);
        }
    }

    @RequiresApi(24)
    private static class VectorDrawableDelegateState extends Drawable.ConstantState {
        private final Drawable.ConstantState mDelegateState;

        public VectorDrawableDelegateState(Drawable.ConstantState r10) {
            this.mDelegateState = r10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            VectorDrawableCompat r10 = new VectorDrawableCompat();
            r10.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable();
            return r10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r10) {
            VectorDrawableCompat r11 = new VectorDrawableCompat();
            r11.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(r10);
            return r11;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r10, Resources.Theme r11) {
            VectorDrawableCompat r12 = new VectorDrawableCompat();
            r12.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(r10, r11);
            return r12;
        }
    }

    static {
        DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    }

    VectorDrawableCompat() {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = new VectorDrawableCompatState();
    }

    VectorDrawableCompat(@NonNull VectorDrawableCompatState r10) {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = r10;
        this.mTintFilter = updateTintFilter(this.mTintFilter, r10.mTint, r10.mTintMode);
    }

    static int applyAlpha(int r10, float r11) {
        return (r10 & ViewCompat.MEASURED_SIZE_MASK) | (((int) (Color.alpha(r10) * r11)) << 24);
    }

    @Nullable
    public static VectorDrawableCompat create(@NonNull Resources r10, @DrawableRes int r11, @Nullable Resources.Theme r12) {
        if (Build.VERSION.SDK_INT < 24) goto L20;
        VectorDrawableCompat r13 = new VectorDrawableCompat();
        r13.mDelegateDrawable = ResourcesCompat.getDrawable(r10, r11, r12);
        r13.mCachedConstantStateDelegate = new VectorDrawableDelegateState(r13.mDelegateDrawable.getConstantState());
        return r13;
    L20:
        XmlResourceParser r14 = r10.getXml(r11);     // Catch: Throwable -> L17
        AttributeSet r15 = Xml.asAttributeSet(r14);     // Catch: Throwable -> L17
    L7:
        int r16 = r14.next();     // Catch: Throwable -> L17
        if (r16 == 2) goto L12;
        if (r16 != 1) goto L7;
    L12:
        if (r16 != 2) goto L16;
        return createFromXmlInner(r10, r14, r15, r12);
    L16:
        throw new XmlPullParserException("No start tag found");     // Catch: Throwable -> L17
    L17:
        e = move-exception;
        Log.e(LOGTAG, "parser error", e);
        return null;
    }

    public static VectorDrawableCompat createFromXmlInner(Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) {
        VectorDrawableCompat r14 = new VectorDrawableCompat();
        r14.inflate(r10, r11, r12, r13);
        return r14;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void inflateInternal(Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) {
        VectorDrawableCompatState r14 = this.mVectorState;
        VPathRenderer r15 = r14.mVPathRenderer;
        ArrayDeque r16 = new ArrayDeque();
        r16.push(r15.mRootGroup);
        int r17 = r11.getEventType();
        int r18 = r11.getDepth() + 1;
        boolean r19 = true;
    L3:
        if (r17 == 1) goto L33;
        if (r11.getDepth() >= r18) goto L8;
        if (r17 == 3) goto L33;
    L8:
        if (r17 != 2) goto L28;
        String r20 = r11.getName();
        VGroup r21 = (VGroup) r16.peek();
        if (SHAPE_PATH.equals(r20) == false) goto L16;
        VFullPath r22 = new VFullPath();
        r22.inflate(r10, r12, r13, r11);
        r21.mChildren.add(r22);
        if (r22.getPathName() == null) goto L14;
        r15.mVGTargetsMap.put(r22.getPathName(), r22);
    L14:
        r19 = false;
        VPath r23 = r22;
    L20:
        int r24 = r14.mChangingConfigurations;
        int r25 = r23.mChangingConfigurations;
    L21:
        r14.mChangingConfigurations = r25 | r24;
    L32:
        r17 = r11.next();
        goto L3
    L16:
        if (SHAPE_CLIP_PATH.equals(r20) == false) goto L23;
        VClipPath r26 = new VClipPath();
        r26.inflate(r10, r12, r13, r11);
        r21.mChildren.add(r26);
        String r27 = r26.getPathName();
        r23 = r26;
        if (r27 == null) goto L20;
        r15.mVGTargetsMap.put(r26.getPathName(), r26);
        r23 = r26;
        goto L20
    L23:
        if (SHAPE_GROUP.equals(r20) == false) goto L32;
        VGroup r28 = new VGroup();
        r28.inflate(r10, r12, r13, r11);
        r21.mChildren.add(r28);
        r16.push(r28);
        if (r28.getGroupName() == null) goto L27;
        r15.mVGTargetsMap.put(r28.getGroupName(), r28);
    L27:
        r24 = r14.mChangingConfigurations;
        r25 = r28.mChangingConfigurations;
        goto L21
    L28:
        if (r17 != 3) goto L32;
        if (SHAPE_GROUP.equals(r11.getName()) == false) goto L32;
        r16.pop();
    L33:
        if (r19 == true) goto L36;
        return;
    L36:
        throw new XmlPullParserException("no path defined");
    }

    private boolean needMirroring() {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return false;
    L5:
        if (isAutoMirrored() == true) goto L7;
        return false;
    L7:
        if (DrawableCompat.getLayoutDirection(this) == 1) goto L9;
        return false;
    L9:
        return true;
    }

    private static PorterDuff.Mode parseTintModeCompat(int r10, PorterDuff.Mode r11) {
        if (r10 == 3) goto L21;
        if (r10 == 5) goto L19;
        if (r10 == 9) goto L17;
        switch(r10) {
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            default: goto L9;
        };
    L9:
        return r11;
    L11:
        return PorterDuff.Mode.ADD;
    L13:
        return PorterDuff.Mode.SCREEN;
    L15:
        return PorterDuff.Mode.MULTIPLY;
    L17:
        return PorterDuff.Mode.SRC_ATOP;
    L19:
        return PorterDuff.Mode.SRC_IN;
    L21:
        return PorterDuff.Mode.SRC_OVER;
    }

    private void printGroupTree(VGroup r10, int r11) {
        int r12 = 0;
        String r13 = "";
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L5;
        r13 = r13 + "    ";
        r14 = r14 + 1;
        goto L3
    L5:
        Log.v(LOGTAG, r13 + "current group is :" + r10.getGroupName() + " rotation is " + r10.mRotate);
        StringBuilder r15 = new StringBuilder();
        r15.append(r13);
        r15.append("matrix is :");
        r15.append(r10.getLocalMatrix().toString());
        Log.v(LOGTAG, r15.toString());
    L7:
        if (r12 >= r10.mChildren.size()) goto L13;
        VObject r16 = r10.mChildren.get(r12);
        if ((r16 instanceof VGroup) == false) goto L11;
        printGroupTree((VGroup) r16, r11 + 1);
    L12:
        r12 = r12 + 1;
        goto L7
    L11:
        ((VPath) r16).printVPath(r11 + 1);
        goto L12
    }

    private void updateStateFromTypedArray(TypedArray r10, XmlPullParser r11, Resources.Theme r12) {
        VectorDrawableCompatState r13 = this.mVectorState;
        VPathRenderer r14 = r13.mVPathRenderer;
        r13.mTintMode = parseTintModeCompat(TypedArrayUtils.getNamedInt(r10, r11, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList r15 = TypedArrayUtils.getNamedColorStateList(r10, r11, r12, "tint", 1);
        if (r15 == null) goto L5;
        r13.mTint = r15;
    L5:
        r13.mAutoMirrored = TypedArrayUtils.getNamedBoolean(r10, r11, "autoMirrored", 5, r13.mAutoMirrored);
        r14.mViewportWidth = TypedArrayUtils.getNamedFloat(r10, r11, "viewportWidth", 7, r14.mViewportWidth);
        float r16 = TypedArrayUtils.getNamedFloat(r10, r11, "viewportHeight", 8, r14.mViewportHeight);
        r14.mViewportHeight = r16;
        if (r14.mViewportWidth <= 0.0f) goto L24;
        if (r16 <= 0.0f) goto L22;
        r14.mBaseWidth = r10.getDimension(3, r14.mBaseWidth);
        float r17 = r10.getDimension(2, r14.mBaseHeight);
        r14.mBaseHeight = r17;
        if (r14.mBaseWidth <= 0.0f) goto L20;
        if (r17 <= 0.0f) goto L18;
        r14.setAlpha(TypedArrayUtils.getNamedFloat(r10, r11, "alpha", 4, r14.getAlpha()));
        String r18 = r10.getString(0);
        if (r18 == null) goto L25;
        r14.mRootName = r18;
        r14.mVGTargetsMap.put(r18, r14);
        return;
    L25:
        return;
    L18:
        throw new XmlPullParserException(r10.getPositionDescription() + "<vector> tag requires height > 0");
    L20:
        throw new XmlPullParserException(r10.getPositionDescription() + "<vector> tag requires width > 0");
    L22:
        throw new XmlPullParserException(r10.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    L24:
        throw new XmlPullParserException(r10.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme r10) {
        super.applyTheme(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        DrawableCompat.canApplyTheme(r10);
        return false;
    L7:
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        r11.draw(r10);
        return;
    L6:
        copyBounds(this.mTmpBounds);
        if (this.mTmpBounds.width() > 0) goto L9;
        return;
    L9:
        if (this.mTmpBounds.height() <= 0) goto L36;
        ColorFilter r12 = this.mColorFilter;
        if (r12 != null) goto L14;
        r12 = this.mTintFilter;
    L14:
        r10.getMatrix(this.mTmpMatrix);
        this.mTmpMatrix.getValues(this.mTmpFloats);
        float r13 = Math.abs(this.mTmpFloats[0]);
        float r14 = Math.abs(this.mTmpFloats[4]);
        float r15 = Math.abs(this.mTmpFloats[1]);
        float r16 = Math.abs(this.mTmpFloats[3]);
        if (r15 == 0.0f) goto L17;
    L18:
        r13 = 1.0f;
        r14 = 1.0f;
    L19:
        int r17 = (int) (this.mTmpBounds.width() * r13);
        int r18 = (int) (this.mTmpBounds.height() * r14);
        int r19 = Math.min(2048, r17);
        int r20 = Math.min(2048, r18);
        if (r19 <= 0) goto L35;
        if (r20 <= 0) goto L37;
        int r21 = r10.save();
        Rect r22 = this.mTmpBounds;
        r10.translate(r22.left, r22.top);
        if (needMirroring() == false) goto L26;
        r10.translate(this.mTmpBounds.width(), 0.0f);
        r10.scale(-1.0f, 1.0f);
    L26:
        this.mTmpBounds.offsetTo(0, 0);
        this.mVectorState.createCachedBitmapIfNeeded(r19, r20);
        if (this.mAllowCaching == true) goto L30;
        this.mVectorState.updateCachedBitmap(r19, r20);
    L32:
        this.mVectorState.drawCachedBitmapWithRootAlpha(r10, r12, this.mTmpBounds);
        r10.restoreToCount(r21);
        return;
    L30:
        if (this.mVectorState.canReuseCache() == true) goto L32;
        this.mVectorState.updateCachedBitmap(r19, r20);
        this.mVectorState.updateCacheStates();
        goto L32
    L37:
        return;
    L35:
        return;
    L17:
        if (r16 == 0.0f) goto L19;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return DrawableCompat.getAlpha(r10);
    L7:
        return this.mVectorState.mVPathRenderer.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 != null) goto L5;
        int r11 = super.getChangingConfigurations();
        return this.mVectorState.getChangingConfigurations() | r11;
    L5:
        return r10.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return DrawableCompat.getColorFilter(r10);
    L7:
        return this.mColorFilter;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable != null) goto L5;
    L8:
        VectorDrawableCompatState r10 = this.mVectorState;
        r10.mChangingConfigurations = getChangingConfigurations();
        return this.mVectorState;
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L8;
        return new VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return r10.getIntrinsicHeight();
    L7:
        return (int) this.mVectorState.mVPathRenderer.mBaseHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return r10.getIntrinsicWidth();
    L7:
        return (int) this.mVectorState.mVPathRenderer.mBaseWidth;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 != null) goto L5;
        return -3;
    L5:
        return r10.getOpacity();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect r10) {
        return super.getPadding(r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public float getPixelSize() {
        VectorDrawableCompatState r10 = this.mVectorState;
        if (r10 == null) goto L17;
        VPathRenderer r11 = r10.mVPathRenderer;
        if (r11 == null) goto L19;
        float r12 = r11.mBaseWidth;
        if (r12 == 0.0f) goto L20;
        float r13 = r11.mBaseHeight;
        if (r13 == 0.0f) goto L21;
        float r14 = r11.mViewportHeight;
        if (r14 == 0.0f) goto L22;
        float r15 = r11.mViewportWidth;
        if (r15 != 0.0f) goto L16;
        return 1.0f;
    L16:
        return Math.min(r15 / r12, r14 / r13);
    L22:
        return 1.0f;
    L21:
        return 1.0f;
    L20:
        return 1.0f;
    L19:
        return 1.0f;
    L17:
        return 1.0f;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    Object getTargetByName(String r10) {
        return this.mVectorState.mVPathRenderer.mVGTargetsMap.get(r10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r10, XmlPullParser r11, AttributeSet r12) {
        Drawable r13 = this.mDelegateDrawable;
        if (r13 == null) goto L6;
        r13.inflate(r10, r11, r12);
        return;
    L6:
        inflate(r10, r11, r12, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) {
        Drawable r14 = this.mDelegateDrawable;
        if (r14 == null) goto L6;
        DrawableCompat.inflate(r14, r10, r11, r12, r13);
        return;
    L6:
        VectorDrawableCompatState r15 = this.mVectorState;
        r15.mVPathRenderer = new VPathRenderer();
        TypedArray r16 = TypedArrayUtils.obtainAttributes(r10, r13, r12, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY);
        updateStateFromTypedArray(r16, r11, r13);
        r16.recycle();
        r15.mChangingConfigurations = getChangingConfigurations();
        r15.mCacheDirty = true;
        inflateInternal(r10, r11, r12, r13);
        this.mTintFilter = updateTintFilter(this.mTintFilter, r15.mTint, r15.mTintMode);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        r10.invalidateSelf();
        return;
    L6:
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return DrawableCompat.isAutoMirrored(r10);
    L7:
        return this.mVectorState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return r10.isStateful();
    L7:
        if (super.isStateful() == true) goto L18;
        VectorDrawableCompatState r11 = this.mVectorState;
        if (r11 != null) goto L11;
    L17:
        return false;
    L11:
        if (r11.isStateful() == true) goto L18;
        ColorStateList r12 = this.mVectorState.mTint;
        if (r12 == null) goto L17;
        if (r12.isStateful() == false) goto L17;
    L18:
        return true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        r10.mutate();
        return this;
    L7:
        if (this.mMutated == false) goto L9;
    L11:
        return this;
    L9:
        if (super.mutate() != this) goto L11;
        this.mVectorState = new VectorDrawableCompatState(this.mVectorState);
        this.mMutated = true;
        goto L11
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        r11.setBounds(r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 != null) goto L5;
        boolean r12 = false;
        VectorDrawableCompatState r13 = this.mVectorState;
        ColorStateList r14 = r13.mTint;
        if (r14 == null) goto L12;
        PorterDuff.Mode r15 = r13.mTintMode;
        if (r15 == null) goto L12;
        this.mTintFilter = updateTintFilter(this.mTintFilter, r14, r15);
        invalidateSelf();
        r12 = true;
    L12:
        if (r13.isStateful() == false) goto L17;
        if (r13.onStateChanged(r10) == false) goto L17;
        invalidateSelf();
        return true;
    L17:
        return r12;
    L5:
        return r11.setState(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable r10, long r11) {
        Drawable r12 = this.mDelegateDrawable;
        if (r12 == null) goto L6;
        r12.scheduleSelf(r10, r11);
        return;
    L6:
        super.scheduleSelf(r10, r11);
    }

    void setAllowCaching(boolean r10) {
        this.mAllowCaching = r10;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L7;
        r11.setAlpha(r10);
        return;
    L7:
        if (this.mVectorState.mVPathRenderer.getRootAlpha() == r10) goto L10;
        this.mVectorState.mVPathRenderer.setRootAlpha(r10);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        DrawableCompat.setAutoMirrored(r11, r10);
        return;
    L6:
        this.mVectorState.mAutoMirrored = r10;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int r10) {
        super.setChangingConfigurations(r10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int r10, PorterDuff.Mode r11) {
        super.setColorFilter(r10, r11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        r11.setColorFilter(r10);
        return;
    L6:
        this.mColorFilter = r10;
        invalidateSelf();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean r10) {
        super.setFilterBitmap(r10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float r10, float r11) {
        super.setHotspot(r10, r11);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int r10, int r11, int r12, int r13) {
        super.setHotspotBounds(r10, r11, r12, r13);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] r10) {
        return super.setState(r10);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        DrawableCompat.setTint(r11, r10);
        return;
    L6:
        setTintList(ColorStateList.valueOf(r10));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        DrawableCompat.setTintList(r11, r10);
        return;
    L6:
        VectorDrawableCompatState r12 = this.mVectorState;
        if (r12.mTint == r10) goto L10;
        r12.mTint = r10;
        this.mTintFilter = updateTintFilter(this.mTintFilter, r10, r12.mTintMode);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        DrawableCompat.setTintMode(r11, r10);
        return;
    L6:
        VectorDrawableCompatState r12 = this.mVectorState;
        if (r12.mTintMode == r10) goto L10;
        r12.mTintMode = r10;
        this.mTintFilter = updateTintFilter(this.mTintFilter, r12.mTint, r10);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r10, boolean r11) {
        Drawable r12 = this.mDelegateDrawable;
        if (r12 == null) goto L7;
        return r12.setVisible(r10, r11);
    L7:
        return super.setVisible(r10, r11);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        r11.unscheduleSelf(r10);
        return;
    L6:
        super.unscheduleSelf(r10);
    }

    PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter r10, ColorStateList r11, PorterDuff.Mode r12) {
        if (r11 == null) goto L7;
        if (r12 != null) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r11.getColorForState(getState(), 0), r12);
    L7:
        return null;
    }
}
