package androidx.vectordrawable.graphics.drawable;

import ai.j0;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
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
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.motion.widget.a;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import java.io.IOException;
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
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class VClipPath extends VPath {
        public VClipPath() {
        }

        private void updateStateFromTypedArray(TypedArray r5, XmlPullParser r10) {
            String r11 = r5.getString(0);
            if (r11 == null) goto L5;
            this.mPathName = r11;
        L5:
            String r12 = r5.getString(1);
            if (r12 == null) goto L8;
            this.mNodes = PathParser.createNodesFromPathData(r12);
        L8:
            this.mFillRule = TypedArrayUtils.getNamedInt(r5, r10, "fillType", 2, 0);
        }

        public void inflate(Resources r5, AttributeSet r10, Resources.Theme r11, XmlPullParser r12) {
            if (TypedArrayUtils.hasAttribute(r12, "pathData") == true) goto L5;
            return;
        L5:
            TypedArray r13 = TypedArrayUtils.obtainAttributes(r5, r11, r10, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH);
            updateStateFromTypedArray(r13, r12);
            r13.recycle();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public boolean isClipPath() {
            return true;
        }

        public VClipPath(VClipPath r5) {
            super(r5);
        }
    }

    public static class VFullPath extends VPath {
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

        public VFullPath() {
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

        private Paint.Cap getStrokeLineCap(int r5, Paint.Cap r10) {
            if (r5 == 0) goto L13;
            if (r5 == 1) goto L11;
            if (r5 == 2) goto L9;
            return r10;
        L9:
            return Paint.Cap.SQUARE;
        L11:
            return Paint.Cap.ROUND;
        L13:
            return Paint.Cap.BUTT;
        }

        private Paint.Join getStrokeLineJoin(int r5, Paint.Join r10) {
            if (r5 == 0) goto L13;
            if (r5 == 1) goto L11;
            if (r5 == 2) goto L9;
            return r10;
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
            String r5 = r10.getString(0);
            if (r5 == null) goto L8;
            this.mPathName = r5;
        L8:
            String r13 = r10.getString(2);
            if (r13 == null) goto L11;
            this.mNodes = PathParser.createNodesFromPathData(r13);
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
        public void applyTheme(Resources.Theme r5) {
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public boolean canApplyTheme() {
            if (this.mThemeAttrs == null) goto L5;
            return true;
        L5:
            return false;
        }

        public float getFillAlpha() {
            return this.mFillAlpha;
        }

        @ColorInt
        public int getFillColor() {
            return this.mFillColor.getColor();
        }

        public float getStrokeAlpha() {
            return this.mStrokeAlpha;
        }

        @ColorInt
        public int getStrokeColor() {
            return this.mStrokeColor.getColor();
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public float getTrimPathEnd() {
            return this.mTrimPathEnd;
        }

        public float getTrimPathOffset() {
            return this.mTrimPathOffset;
        }

        public float getTrimPathStart() {
            return this.mTrimPathStart;
        }

        public void inflate(Resources r5, AttributeSet r10, Resources.Theme r11, XmlPullParser r12) {
            TypedArray r13 = TypedArrayUtils.obtainAttributes(r5, r11, r10, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_PATH);
            updateStateFromTypedArray(r13, r12, r11);
            r13.recycle();
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
        public boolean onStateChanged(int[] r5) {
            boolean r10 = this.mFillColor.onStateChanged(r5);
            return this.mStrokeColor.onStateChanged(r5) | r10;
        }

        public void setFillAlpha(float r5) {
            this.mFillAlpha = r5;
        }

        public void setFillColor(int r5) {
            this.mFillColor.setColor(r5);
        }

        public void setStrokeAlpha(float r5) {
            this.mStrokeAlpha = r5;
        }

        public void setStrokeColor(int r5) {
            this.mStrokeColor.setColor(r5);
        }

        public void setStrokeWidth(float r5) {
            this.mStrokeWidth = r5;
        }

        public void setTrimPathEnd(float r5) {
            this.mTrimPathEnd = r5;
        }

        public void setTrimPathOffset(float r5) {
            this.mTrimPathOffset = r5;
        }

        public void setTrimPathStart(float r5) {
            this.mTrimPathStart = r5;
        }

        public VFullPath(VFullPath r5) {
            super(r5);
            this.mStrokeWidth = 0.0f;
            this.mStrokeAlpha = 1.0f;
            this.mFillAlpha = 1.0f;
            this.mTrimPathStart = 0.0f;
            this.mTrimPathEnd = 1.0f;
            this.mTrimPathOffset = 0.0f;
            this.mStrokeLineCap = Paint.Cap.BUTT;
            this.mStrokeLineJoin = Paint.Join.MITER;
            this.mStrokeMiterlimit = 4.0f;
            this.mThemeAttrs = r5.mThemeAttrs;
            this.mStrokeColor = r5.mStrokeColor;
            this.mStrokeWidth = r5.mStrokeWidth;
            this.mStrokeAlpha = r5.mStrokeAlpha;
            this.mFillColor = r5.mFillColor;
            this.mFillRule = r5.mFillRule;
            this.mFillAlpha = r5.mFillAlpha;
            this.mTrimPathStart = r5.mTrimPathStart;
            this.mTrimPathEnd = r5.mTrimPathEnd;
            this.mTrimPathOffset = r5.mTrimPathOffset;
            this.mStrokeLineCap = r5.mStrokeLineCap;
            this.mStrokeLineJoin = r5.mStrokeLineJoin;
            this.mStrokeMiterlimit = r5.mStrokeMiterlimit;
        }
    }

    public static class VGroup extends VObject {
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

        public VGroup(VGroup r5, ArrayMap<String, Object> r10) {
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
            Matrix r11 = new Matrix();
            this.mLocalMatrix = r11;
            this.mGroupName = null;
            this.mRotate = r5.mRotate;
            this.mPivotX = r5.mPivotX;
            this.mPivotY = r5.mPivotY;
            this.mScaleX = r5.mScaleX;
            this.mScaleY = r5.mScaleY;
            this.mTranslateX = r5.mTranslateX;
            this.mTranslateY = r5.mTranslateY;
            this.mThemeAttrs = r5.mThemeAttrs;
            String r12 = r5.mGroupName;
            this.mGroupName = r12;
            this.mChangingConfigurations = r5.mChangingConfigurations;
            if (r12 == null) goto L5;
            r10.put(r12, this);
        L5:
            r11.set(r5.mLocalMatrix);
            ArrayList<VObject> r13 = r5.mChildren;
            int r14 = 0;
        L7:
            if (r14 >= r13.size()) goto L23;
            VObject r15 = r13.get(r14);
            if ((r15 instanceof VGroup) == false) goto L12;
            this.mChildren.add(new VGroup((VGroup) r15, r10));
        L20:
            r14 = r14 + 1;
            goto L7
        L12:
            if ((r15 instanceof VFullPath) == false) goto L15;
            VPath r16 = new VFullPath((VFullPath) r15);
        L17:
            this.mChildren.add(r16);
            String r17 = r16.mPathName;
            if (r17 == null) goto L20;
            r10.put(r17, r16);
            goto L20
        L15:
            if ((r15 instanceof VClipPath) == false) goto L22;
            r16 = new VClipPath((VClipPath) r15);
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

        private void updateStateFromTypedArray(TypedArray r5, XmlPullParser r10) {
            this.mThemeAttrs = null;
            this.mRotate = TypedArrayUtils.getNamedFloat(r5, r10, "rotation", 5, this.mRotate);
            this.mPivotX = r5.getFloat(1, this.mPivotX);
            this.mPivotY = r5.getFloat(2, this.mPivotY);
            this.mScaleX = TypedArrayUtils.getNamedFloat(r5, r10, "scaleX", 3, this.mScaleX);
            this.mScaleY = TypedArrayUtils.getNamedFloat(r5, r10, "scaleY", 4, this.mScaleY);
            this.mTranslateX = TypedArrayUtils.getNamedFloat(r5, r10, "translateX", 6, this.mTranslateX);
            this.mTranslateY = TypedArrayUtils.getNamedFloat(r5, r10, "translateY", 7, this.mTranslateY);
            String r11 = r5.getString(0);
            if (r11 == null) goto L5;
            this.mGroupName = r11;
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

        public void inflate(Resources r5, AttributeSet r10, Resources.Theme r11, XmlPullParser r12) {
            TypedArray r13 = TypedArrayUtils.obtainAttributes(r5, r11, r10, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
            updateStateFromTypedArray(r13, r12);
            r13.recycle();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean isStateful() {
            int r5 = 0;
        L4:
            if (r5 >= this.mChildren.size()) goto L10;
            if (this.mChildren.get(r5).isStateful() == true) goto L7;
            r5 = r5 + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean onStateChanged(int[] r5) {
            int r10 = 0;
            boolean r11 = false;
        L4:
            if (r10 >= this.mChildren.size()) goto L6;
            r11 = r11 | this.mChildren.get(r10).onStateChanged(r5);
            r10 = r10 + 1;
            goto L4
        L6:
            return r11;
        }

        public void setPivotX(float r5) {
            if (r5 == this.mPivotX) goto L6;
            this.mPivotX = r5;
            updateLocalMatrix();
            return;
        }

        public void setPivotY(float r5) {
            if (r5 == this.mPivotY) goto L6;
            this.mPivotY = r5;
            updateLocalMatrix();
            return;
        }

        public void setRotation(float r5) {
            if (r5 == this.mRotate) goto L6;
            this.mRotate = r5;
            updateLocalMatrix();
            return;
        }

        public void setScaleX(float r5) {
            if (r5 == this.mScaleX) goto L6;
            this.mScaleX = r5;
            updateLocalMatrix();
            return;
        }

        public void setScaleY(float r5) {
            if (r5 == this.mScaleY) goto L6;
            this.mScaleY = r5;
            updateLocalMatrix();
            return;
        }

        public void setTranslateX(float r5) {
            if (r5 == this.mTranslateX) goto L6;
            this.mTranslateX = r5;
            updateLocalMatrix();
            return;
        }

        public void setTranslateY(float r5) {
            if (r5 == this.mTranslateY) goto L6;
            this.mTranslateY = r5;
            updateLocalMatrix();
            return;
        }

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
    }

    public static abstract class VObject {
        private VObject() {
        }

        public boolean isStateful() {
            return false;
        }

        public boolean onStateChanged(int[] r5) {
            return false;
        }

        public /* synthetic */ VObject(AnonymousClass1 r5) {
            this();
        }
    }

    public static abstract class VPath extends VObject {
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

        public void applyTheme(Resources.Theme r5) {
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
            int r5 = 0;
        L4:
            if (r5 >= r10.length) goto L10;
            StringBuilder r12 = j0.u(r11);
            r12.append(r10[r5].mType);
            r12.append(":");
            r11 = r12.toString();
            float[] r13 = r10[r5].mParams;
            int r14 = 0;
        L7:
            if (r14 >= r13.length) goto L9;
            r11 = a.r(j0.u(r11), r13[r14], ",");
            r14 = r14 + 1;
            goto L7
        L9:
            r5 = r5 + 1;
            goto L4
        L10:
            return r11;
        }

        public void printVPath(int r5) {
            String r10 = "";
            int r11 = 0;
        L3:
            if (r11 >= r5) goto L5;
            r10 = j0.j(r10, "    ");
            r11 = r11 + 1;
            goto L3
        L5:
            StringBuilder r12 = j0.w(r10, "current path is :");
            r12.append(this.mPathName);
            r12.append(" pathData is ");
            r12.append(nodesToString(this.mNodes));
            Log.v(VectorDrawableCompat.LOGTAG, r12.toString());
        }

        public void setPathData(PathParser.PathDataNode[] r5) {
            if (PathParser.canMorph(this.mNodes, r5) == true) goto L5;
            this.mNodes = PathParser.deepCopyNodes(r5);
            return;
        L5:
            PathParser.updateNodes(this.mNodes, r5);
        }

        public void toPath(Path r5) {
            r5.reset();
            PathParser.PathDataNode[] r10 = this.mNodes;
            if (r10 == null) goto L6;
            PathParser.PathDataNode.nodesToPath(r10, r5);
            return;
        }

        public VPath(VPath r5) {
            super(null);
            this.mNodes = null;
            this.mFillRule = 0;
            this.mPathName = r5.mPathName;
            this.mChangingConfigurations = r5.mChangingConfigurations;
            this.mNodes = PathParser.deepCopyNodes(r5.mNodes);
        }
    }

    public static class VPathRenderer {
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

        private static float cross(float r5, float r10, float r11, float r12) {
            return (r5 * r12) - (r10 * r11);
        }

        private void drawGroupTree(VGroup r10, Matrix r11, Canvas r12, int r13, int r14, ColorFilter r15) {
            r10.mStackedMatrix.set(r11);
            r10.mStackedMatrix.preConcat(r10.mLocalMatrix);
            r12.save();
            int r16 = 0;
        L4:
            if (r16 >= r10.mChildren.size()) goto L12;
            VObject r5 = r10.mChildren.get(r16);
            if ((r5 instanceof VGroup) == false) goto L9;
            drawGroupTree((VGroup) r5, r10.mStackedMatrix, r12, r13, r14, r15);
        L11:
            r16 = r16 + 1;
            goto L4
        L9:
            if ((r5 instanceof VPath) == false) goto L11;
            drawPath(r10, (VPath) r5, r12, r13, r14, r15);
            goto L11
        L12:
            r12.restore();
        }

        private void drawPath(VGroup r10, VPath r11, Canvas r12, int r13, int r14, ColorFilter r15) {
            float r16 = r13 / this.mViewportWidth;
            float r17 = r14 / this.mViewportHeight;
            float r5 = Math.min(r16, r17);
            Matrix r18 = r10.mStackedMatrix;
            this.mFinalPathMatrix.set(r18);
            this.mFinalPathMatrix.postScale(r16, r17);
            float r19 = getMatrixScale(r18);
            if (r19 != 0.0f) goto L5;
            return;
        L5:
            r11.toPath(this.mPath);
            Path r110 = this.mPath;
            this.mRenderPath.reset();
            if (r11.isClipPath() == false) goto L12;
            Path r20 = this.mRenderPath;
            if (r11.mFillRule != 0) goto L10;
            Path.FillType r21 = Path.FillType.WINDING;
        L11:
            r20.setFillType(r21);
            this.mRenderPath.addPath(r110, this.mFinalPathMatrix);
            r12.clipPath(this.mRenderPath);
            return;
        L10:
            r21 = Path.FillType.EVEN_ODD;
            goto L11
        L12:
            VFullPath r22 = (VFullPath) r11;
            float r23 = r22.mTrimPathStart;
            if (r23 == 0.0f) goto L15;
        L16:
            float r24 = r22.mTrimPathOffset;
            float r25 = (r23 + r24) % 1.0f;
            float r26 = (r22.mTrimPathEnd + r24) % 1.0f;
            if (this.mPathMeasure != null) goto L19;
            this.mPathMeasure = new PathMeasure();
        L19:
            this.mPathMeasure.setPath(this.mPath, false);
            float r27 = this.mPathMeasure.getLength();
            float r28 = r25 * r27;
            float r29 = r26 * r27;
            r110.reset();
            if (r28 <= r29) goto L22;
            this.mPathMeasure.getSegment(r28, r27, r110, true);
            this.mPathMeasure.getSegment(0.0f, r29, r110, true);
        L23:
            r110.rLineTo(0.0f, 0.0f);
        L24:
            this.mRenderPath.addPath(r110, this.mFinalPathMatrix);
            if (r22.mFillColor.willDraw() == false) goto L39;
            ComplexColorCompat r111 = r22.mFillColor;
            if (this.mFillPaint != null) goto L29;
            Paint r30 = new Paint(1);
            this.mFillPaint = r30;
            r30.setStyle(Paint.Style.FILL);
        L29:
            Paint r31 = this.mFillPaint;
            if (r111.isGradient() == false) goto L32;
            Shader r112 = r111.getShader();
            r112.setLocalMatrix(this.mFinalPathMatrix);
            r31.setShader(r112);
            r31.setAlpha(Math.round(r22.mFillAlpha * 255.0f));
        L33:
            r31.setColorFilter(r15);
            Path r113 = this.mRenderPath;
            if (r22.mFillRule != 0) goto L36;
            Path.FillType r32 = Path.FillType.WINDING;
        L37:
            r113.setFillType(r32);
            r12.drawPath(this.mRenderPath, r31);
            goto L39
        L36:
            r32 = Path.FillType.EVEN_ODD;
            goto L37
        L32:
            r31.setShader(null);
            r31.setAlpha(255);
            r31.setColor(VectorDrawableCompat.applyAlpha(r111.getColor(), r22.mFillAlpha));
        L39:
            if (r22.mStrokeColor.willDraw() == false) goto L56;
            ComplexColorCompat r114 = r22.mStrokeColor;
            if (this.mStrokePaint != null) goto L43;
            Paint r33 = new Paint(1);
            this.mStrokePaint = r33;
            r33.setStyle(Paint.Style.STROKE);
        L43:
            Paint r34 = this.mStrokePaint;
            Paint.Join r35 = r22.mStrokeLineJoin;
            if (r35 == null) goto L46;
            r34.setStrokeJoin(r35);
        L46:
            Paint.Cap r36 = r22.mStrokeLineCap;
            if (r36 == null) goto L49;
            r34.setStrokeCap(r36);
        L49:
            r34.setStrokeMiter(r22.mStrokeMiterlimit);
            if (r114.isGradient() == false) goto L52;
            Shader r115 = r114.getShader();
            r115.setLocalMatrix(this.mFinalPathMatrix);
            r34.setShader(r115);
            r34.setAlpha(Math.round(r22.mStrokeAlpha * 255.0f));
        L53:
            r34.setColorFilter(r15);
            r34.setStrokeWidth(r22.mStrokeWidth * (r5 * r19));
            r12.drawPath(this.mRenderPath, r34);
            return;
        L52:
            r34.setShader(null);
            r34.setAlpha(255);
            r34.setColor(VectorDrawableCompat.applyAlpha(r114.getColor(), r22.mStrokeAlpha));
            goto L53
        L56:
            return;
        L22:
            this.mPathMeasure.getSegment(r28, r29, r110, true);
            goto L23
        L15:
            if (r22.mTrimPathEnd == 1.0f) goto L24;
            goto L16
        }

        private float getMatrixScale(Matrix r10) {
            float[] r5 = {0.0f, 1.0f, 1.0f, 0.0f};
            r10.mapVectors(r5);
            float r11 = (float) Math.hypot(r5[0], r5[1]);
            float r12 = (float) Math.hypot(r5[2], r5[3]);
            float r13 = cross(r5[0], r5[1], r5[2], r5[3]);
            float r14 = Math.max(r11, r12);
            if (r14 > 0.0f) goto L5;
            return 0.0f;
        L5:
            return Math.abs(r13) / r14;
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

        public boolean onStateChanged(int[] r5) {
            return this.mRootGroup.onStateChanged(r5);
        }

        public void setAlpha(float r5) {
            setRootAlpha((int) (r5 * 255.0f));
        }

        public void setRootAlpha(int r5) {
            this.mRootAlpha = r5;
        }

        public VPathRenderer(VPathRenderer r5) {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mIsStateful = null;
            ArrayMap<String, Object> r10 = new ArrayMap();
            this.mVGTargetsMap = r10;
            this.mRootGroup = new VGroup(r5.mRootGroup, r10);
            this.mPath = new Path(r5.mPath);
            this.mRenderPath = new Path(r5.mRenderPath);
            this.mBaseWidth = r5.mBaseWidth;
            this.mBaseHeight = r5.mBaseHeight;
            this.mViewportWidth = r5.mViewportWidth;
            this.mViewportHeight = r5.mViewportHeight;
            this.mChangingConfigurations = r5.mChangingConfigurations;
            this.mRootAlpha = r5.mRootAlpha;
            this.mRootName = r5.mRootName;
            String r11 = r5.mRootName;
            if (r11 == null) goto L5;
            r10.put(r11, this);
        L5:
            this.mIsStateful = r5.mIsStateful;
        }
    }

    public static class VectorDrawableCompatState extends Drawable.ConstantState {
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

        public VectorDrawableCompatState(VectorDrawableCompatState r5) {
            this.mTint = null;
            this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
            if (r5 == null) goto L12;
            this.mChangingConfigurations = r5.mChangingConfigurations;
            VPathRenderer r10 = new VPathRenderer(r5.mVPathRenderer);
            this.mVPathRenderer = r10;
            if (r5.mVPathRenderer.mFillPaint == null) goto L8;
            r10.mFillPaint = new Paint(r5.mVPathRenderer.mFillPaint);
        L8:
            if (r5.mVPathRenderer.mStrokePaint == null) goto L10;
            VPathRenderer r11 = this.mVPathRenderer;
            r11.mStrokePaint = new Paint(r5.mVPathRenderer.mStrokePaint);
        L10:
            this.mTint = r5.mTint;
            this.mTintMode = r5.mTintMode;
            this.mAutoMirrored = r5.mAutoMirrored;
            return;
        }

        public boolean canReuseBitmap(int r5, int r10) {
            if (r5 == this.mCachedBitmap.getWidth()) goto L5;
            return false;
        L5:
            if (r10 != this.mCachedBitmap.getHeight()) goto L10;
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

        public void createCachedBitmapIfNeeded(int r5, int r10) {
            if (this.mCachedBitmap != null) goto L5;
        L6:
            this.mCachedBitmap = Bitmap.createBitmap(r5, r10, Bitmap.Config.ARGB_8888);
            this.mCacheDirty = true;
            return;
        L5:
            if (canReuseBitmap(r5, r10) == false) goto L6;
        }

        public void drawCachedBitmapWithRootAlpha(Canvas r5, ColorFilter r10, Rect r11) {
            Paint r12 = getPaint(r10);
            r5.drawBitmap(this.mCachedBitmap, null, r11, r12);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public Paint getPaint(ColorFilter r5) {
            if (hasTranslucentRoot() == true) goto L8;
            if (r5 != null) goto L8;
            return null;
        L8:
            if (this.mTempPaint != null) goto L10;
            Paint r10 = new Paint();
            this.mTempPaint = r10;
            r10.setFilterBitmap(true);
        L10:
            this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
            this.mTempPaint.setColorFilter(r5);
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

        public boolean onStateChanged(int[] r5) {
            boolean r10 = this.mVPathRenderer.onStateChanged(r5);
            this.mCacheDirty |= r10;
            return r10;
        }

        public void updateCacheStates() {
            this.mCachedTint = this.mTint;
            this.mCachedTintMode = this.mTintMode;
            this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
            this.mCachedAutoMirrored = this.mAutoMirrored;
            this.mCacheDirty = false;
        }

        public void updateCachedBitmap(int r5, int r10) {
            this.mCachedBitmap.eraseColor(0);
            Canvas r11 = new Canvas(this.mCachedBitmap);
            this.mVPathRenderer.draw(r11, r5, r10, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources r5) {
            return new VectorDrawableCompat(this);
        }

        public VectorDrawableCompatState() {
            this.mTint = null;
            this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
            this.mVPathRenderer = new VPathRenderer();
        }
    }

    @RequiresApi(24)
    public static class VectorDrawableDelegateState extends Drawable.ConstantState {
        private final Drawable.ConstantState mDelegateState;

        public VectorDrawableDelegateState(Drawable.ConstantState r5) {
            this.mDelegateState = r5;
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
            VectorDrawableCompat r5 = new VectorDrawableCompat();
            r5.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable();
            return r5;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r5) {
            VectorDrawableCompat r10 = new VectorDrawableCompat();
            r10.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(r5);
            return r10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r5, Resources.Theme r10) {
            VectorDrawableCompat r11 = new VectorDrawableCompat();
            r11.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(r5, r10);
            return r11;
        }
    }

    static {
        DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    }

    public VectorDrawableCompat() {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = new VectorDrawableCompatState();
    }

    public static int applyAlpha(int r5, float r10) {
        return (r5 & ViewCompat.MEASURED_SIZE_MASK) | (((int) (Color.alpha(r5) * r10)) << 24);
    }

    @Nullable
    public static VectorDrawableCompat create(@NonNull Resources r5, @DrawableRes int r10, @Nullable Resources.Theme r11) {
        VectorDrawableCompat r12 = new VectorDrawableCompat();
        r12.mDelegateDrawable = ResourcesCompat.getDrawable(r5, r10, r11);
        r12.mCachedConstantStateDelegate = new VectorDrawableDelegateState(r12.mDelegateDrawable.getConstantState());
        return r12;
    }

    public static VectorDrawableCompat createFromXmlInner(Resources r5, XmlPullParser r10, AttributeSet r11, Resources.Theme r12) throws XmlPullParserException, IOException {
        VectorDrawableCompat r13 = new VectorDrawableCompat();
        r13.inflate(r5, r10, r11, r12);
        return r13;
    }

    private void inflateInternal(Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) throws XmlPullParserException, IOException {
        VectorDrawableCompatState r14 = this.mVectorState;
        VPathRenderer r5 = r14.mVPathRenderer;
        ArrayDeque r15 = new ArrayDeque();
        r15.push(r5.mRootGroup);
        int r16 = r11.getEventType();
        int r17 = r11.getDepth() + 1;
        boolean r18 = true;
    L3:
        if (r16 == 1) goto L32;
        if (r11.getDepth() >= r17) goto L8;
        if (r16 == 3) goto L32;
    L8:
        if (r16 != 2) goto L27;
        String r19 = r11.getName();
        VGroup r20 = (VGroup) r15.peek();
        if ("path".equals(r19) == false) goto L16;
        VFullPath r21 = new VFullPath();
        r21.inflate(r10, r12, r13, r11);
        r20.mChildren.add(r21);
        if (r21.getPathName() == null) goto L14;
        r5.mVGTargetsMap.put(r21.getPathName(), r21);
    L14:
        r14.mChangingConfigurations = r21.mChangingConfigurations | r14.mChangingConfigurations;
        r18 = false;
    L31:
        r16 = r11.next();
        goto L3
    L16:
        if (SHAPE_CLIP_PATH.equals(r19) == false) goto L22;
        VClipPath r22 = new VClipPath();
        r22.inflate(r10, r12, r13, r11);
        r20.mChildren.add(r22);
        if (r22.getPathName() == null) goto L20;
        r5.mVGTargetsMap.put(r22.getPathName(), r22);
    L20:
        r14.mChangingConfigurations = r22.mChangingConfigurations | r14.mChangingConfigurations;
        goto L31
    L22:
        if (SHAPE_GROUP.equals(r19) == false) goto L31;
        VGroup r23 = new VGroup();
        r23.inflate(r10, r12, r13, r11);
        r20.mChildren.add(r23);
        r15.push(r23);
        if (r23.getGroupName() == null) goto L26;
        r5.mVGTargetsMap.put(r23.getGroupName(), r23);
    L26:
        r14.mChangingConfigurations = r23.mChangingConfigurations | r14.mChangingConfigurations;
        goto L31
    L27:
        if (r16 != 3) goto L31;
        if (SHAPE_GROUP.equals(r11.getName()) == false) goto L31;
        r15.pop();
    L32:
        if (r18 == true) goto L35;
        return;
    L35:
        throw new XmlPullParserException("no path defined");
    }

    private boolean needMirroring() {
        if (isAutoMirrored() == true) goto L5;
    L7:
        return false;
    L5:
        if (DrawableCompat.getLayoutDirection(this) != 1) goto L7;
        return true;
    }

    private static PorterDuff.Mode parseTintModeCompat(int r5, PorterDuff.Mode r10) {
        if (r5 == 3) goto L21;
        if (r5 == 5) goto L19;
        if (r5 == 9) goto L17;
        switch(r5) {
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            default: goto L9;
        };
    L9:
        return r10;
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

    private void printGroupTree(VGroup r5, int r10) {
        String r11 = "";
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L5;
        r11 = j0.j(r11, "    ");
        r13 = r13 + 1;
        goto L3
    L5:
        StringBuilder r14 = j0.w(r11, "current group is :");
        r14.append(r5.getGroupName());
        r14.append(" rotation is ");
        r14.append(r5.mRotate);
        Log.v(LOGTAG, r14.toString());
        Log.v(LOGTAG, r11 + "matrix is :" + r5.getLocalMatrix().toString());
    L7:
        if (r12 >= r5.mChildren.size()) goto L13;
        VObject r15 = r5.mChildren.get(r12);
        if ((r15 instanceof VGroup) == false) goto L11;
        printGroupTree((VGroup) r15, r10 + 1);
    L12:
        r12 = r12 + 1;
        goto L7
    L11:
        ((VPath) r15).printVPath(r10 + 1);
        goto L12
    }

    private void updateStateFromTypedArray(TypedArray r5, XmlPullParser r10, Resources.Theme r11) throws XmlPullParserException {
        VectorDrawableCompatState r12 = this.mVectorState;
        VPathRenderer r13 = r12.mVPathRenderer;
        r12.mTintMode = parseTintModeCompat(TypedArrayUtils.getNamedInt(r5, r10, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList r14 = TypedArrayUtils.getNamedColorStateList(r5, r10, r11, "tint", 1);
        if (r14 == null) goto L5;
        r12.mTint = r14;
    L5:
        r12.mAutoMirrored = TypedArrayUtils.getNamedBoolean(r5, r10, "autoMirrored", 5, r12.mAutoMirrored);
        r13.mViewportWidth = TypedArrayUtils.getNamedFloat(r5, r10, "viewportWidth", 7, r13.mViewportWidth);
        float r15 = TypedArrayUtils.getNamedFloat(r5, r10, "viewportHeight", 8, r13.mViewportHeight);
        r13.mViewportHeight = r15;
        if (r13.mViewportWidth <= 0.0f) goto L24;
        if (r15 <= 0.0f) goto L22;
        r13.mBaseWidth = r5.getDimension(3, r13.mBaseWidth);
        float r16 = r5.getDimension(2, r13.mBaseHeight);
        r13.mBaseHeight = r16;
        if (r13.mBaseWidth <= 0.0f) goto L20;
        if (r16 <= 0.0f) goto L18;
        r13.setAlpha(TypedArrayUtils.getNamedFloat(r5, r10, "alpha", 4, r13.getAlpha()));
        String r17 = r5.getString(0);
        if (r17 == null) goto L25;
        r13.mRootName = r17;
        r13.mVGTargetsMap.put(r17, r13);
        return;
    L25:
        return;
    L18:
        throw new XmlPullParserException(r5.getPositionDescription() + "<vector> tag requires height > 0");
    L20:
        throw new XmlPullParserException(r5.getPositionDescription() + "<vector> tag requires width > 0");
    L22:
        throw new XmlPullParserException(r5.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    L24:
        throw new XmlPullParserException(r5.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme r5) {
        super.applyTheme(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        DrawableCompat.canApplyTheme(r5);
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
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L6;
        r5.draw(r10);
        return;
    L6:
        copyBounds(this.mTmpBounds);
        if (this.mTmpBounds.width() > 0) goto L9;
        return;
    L9:
        if (this.mTmpBounds.height() <= 0) goto L36;
        ColorFilter r11 = this.mColorFilter;
        if (r11 != null) goto L14;
        r11 = this.mTintFilter;
    L14:
        r10.getMatrix(this.mTmpMatrix);
        this.mTmpMatrix.getValues(this.mTmpFloats);
        float r12 = Math.abs(this.mTmpFloats[0]);
        float r13 = Math.abs(this.mTmpFloats[4]);
        float r14 = Math.abs(this.mTmpFloats[1]);
        float r15 = Math.abs(this.mTmpFloats[3]);
        if (r14 == 0.0f) goto L17;
    L18:
        r12 = 1.0f;
        r13 = 1.0f;
    L19:
        int r16 = (int) (this.mTmpBounds.width() * r12);
        int r17 = (int) (this.mTmpBounds.height() * r13);
        int r18 = Math.min(2048, r16);
        int r19 = Math.min(2048, r17);
        if (r18 <= 0) goto L35;
        if (r19 <= 0) goto L37;
        int r20 = r10.save();
        Rect r21 = this.mTmpBounds;
        r10.translate(r21.left, r21.top);
        if (needMirroring() == false) goto L26;
        r10.translate(this.mTmpBounds.width(), 0.0f);
        r10.scale(-1.0f, 1.0f);
    L26:
        this.mTmpBounds.offsetTo(0, 0);
        this.mVectorState.createCachedBitmapIfNeeded(r18, r19);
        if (this.mAllowCaching == true) goto L30;
        this.mVectorState.updateCachedBitmap(r18, r19);
    L32:
        this.mVectorState.drawCachedBitmapWithRootAlpha(r10, r11, this.mTmpBounds);
        r10.restoreToCount(r20);
        return;
    L30:
        if (this.mVectorState.canReuseCache() == true) goto L32;
        this.mVectorState.updateCachedBitmap(r18, r19);
        this.mVectorState.updateCacheStates();
        goto L32
    L37:
        return;
    L35:
        return;
    L17:
        if (r15 == 0.0f) goto L19;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        return DrawableCompat.getAlpha(r5);
    L7:
        return this.mVectorState.mVPathRenderer.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 != null) goto L5;
        int r10 = super.getChangingConfigurations();
        return this.mVectorState.getChangingConfigurations() | r10;
    L5:
        return r5.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        return DrawableCompat.getColorFilter(r5);
    L7:
        return this.mColorFilter;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable != null) goto L5;
        VectorDrawableCompatState r5 = this.mVectorState;
        r5.mChangingConfigurations = getChangingConfigurations();
        return this.mVectorState;
    L5:
        return new VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        return r5.getIntrinsicHeight();
    L7:
        return (int) this.mVectorState.mVPathRenderer.mBaseHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        return r5.getIntrinsicWidth();
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
        Drawable r5 = this.mDelegateDrawable;
        if (r5 != null) goto L5;
        return -3;
    L5:
        return r5.getOpacity();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect r5) {
        return super.getPadding(r5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public float getPixelSize() {
        VectorDrawableCompatState r5 = this.mVectorState;
        if (r5 == null) goto L17;
        VPathRenderer r10 = r5.mVPathRenderer;
        if (r10 == null) goto L19;
        float r11 = r10.mBaseWidth;
        if (r11 == 0.0f) goto L20;
        float r12 = r10.mBaseHeight;
        if (r12 == 0.0f) goto L21;
        float r13 = r10.mViewportHeight;
        if (r13 == 0.0f) goto L22;
        float r14 = r10.mViewportWidth;
        if (r14 != 0.0f) goto L16;
        return 1.0f;
    L16:
        return Math.min(r14 / r11, r13 / r12);
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

    public Object getTargetByName(String r5) {
        return this.mVectorState.mVPathRenderer.mVGTargetsMap.get(r5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r5, XmlPullParser r10, AttributeSet r11) throws XmlPullParserException, IOException {
        Drawable r12 = this.mDelegateDrawable;
        if (r12 == null) goto L6;
        r12.inflate(r5, r10, r11);
        return;
    L6:
        inflate(r5, r10, r11, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L6;
        r5.invalidateSelf();
        return;
    L6:
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        return DrawableCompat.isAutoMirrored(r5);
    L7:
        return this.mVectorState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        return r5.isStateful();
    L7:
        if (super.isStateful() == true) goto L18;
        VectorDrawableCompatState r10 = this.mVectorState;
        if (r10 != null) goto L11;
    L17:
        return false;
    L11:
        if (r10.isStateful() == true) goto L18;
        ColorStateList r11 = this.mVectorState.mTint;
        if (r11 == null) goto L17;
        if (r11.isStateful() == false) goto L17;
    L18:
        return true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        r5.mutate();
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
    public void onBoundsChange(Rect r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        r10.setBounds(r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r10) {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 != null) goto L5;
        VectorDrawableCompatState r11 = this.mVectorState;
        ColorStateList r12 = r11.mTint;
        if (r12 == null) goto L11;
        PorterDuff.Mode r13 = r11.mTintMode;
        if (r13 == null) goto L11;
        this.mTintFilter = updateTintFilter(this.mTintFilter, r12, r13);
        invalidateSelf();
        boolean r14 = true;
    L13:
        if (r11.isStateful() == false) goto L18;
        if (r11.onStateChanged(r10) == false) goto L18;
        invalidateSelf();
        return true;
    L18:
        return r14;
    L11:
        r14 = false;
        goto L13
    L5:
        return r5.setState(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable r5, long r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        r11.scheduleSelf(r5, r10);
        return;
    L6:
        super.scheduleSelf(r5, r10);
    }

    public void setAllowCaching(boolean r5) {
        this.mAllowCaching = r5;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        r10.setAlpha(r5);
        return;
    L7:
        if (this.mVectorState.mVPathRenderer.getRootAlpha() == r5) goto L10;
        this.mVectorState.mVPathRenderer.setRootAlpha(r5);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        DrawableCompat.setAutoMirrored(r10, r5);
        return;
    L6:
        this.mVectorState.mAutoMirrored = r5;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int r5) {
        super.setChangingConfigurations(r5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int r5, PorterDuff.Mode r10) {
        super.setColorFilter(r5, r10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean r5) {
        super.setFilterBitmap(r5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float r5, float r10) {
        super.setHotspot(r5, r10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int r5, int r10, int r11, int r12) {
        super.setHotspotBounds(r5, r10, r11, r12);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] r5) {
        return super.setState(r5);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        DrawableCompat.setTint(r10, r5);
        return;
    L6:
        setTintList(ColorStateList.valueOf(r5));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        DrawableCompat.setTintList(r10, r5);
        return;
    L6:
        VectorDrawableCompatState r11 = this.mVectorState;
        if (r11.mTint == r5) goto L10;
        r11.mTint = r5;
        this.mTintFilter = updateTintFilter(this.mTintFilter, r5, r11.mTintMode);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        DrawableCompat.setTintMode(r10, r5);
        return;
    L6:
        VectorDrawableCompatState r11 = this.mVectorState;
        if (r11.mTintMode == r5) goto L10;
        r11.mTintMode = r5;
        this.mTintFilter = updateTintFilter(this.mTintFilter, r11.mTint, r5);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r5, boolean r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L7;
        return r11.setVisible(r5, r10);
    L7:
        return super.setVisible(r5, r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        r10.unscheduleSelf(r5);
        return;
    L6:
        super.unscheduleSelf(r5);
    }

    public PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter r5, ColorStateList r10, PorterDuff.Mode r11) {
        if (r10 == null) goto L7;
        if (r11 != null) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r10.getColorForState(getState(), 0), r11);
    L7:
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        r10.setColorFilter(r5);
        return;
    L6:
        this.mColorFilter = r5;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r5, XmlPullParser r10, AttributeSet r11, Resources.Theme r12) throws XmlPullParserException, IOException {
        Drawable r13 = this.mDelegateDrawable;
        if (r13 == null) goto L6;
        DrawableCompat.inflate(r13, r5, r10, r11, r12);
        return;
    L6:
        VectorDrawableCompatState r14 = this.mVectorState;
        r14.mVPathRenderer = new VPathRenderer();
        TypedArray r15 = TypedArrayUtils.obtainAttributes(r5, r12, r11, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY);
        updateStateFromTypedArray(r15, r10, r12);
        r15.recycle();
        r14.mChangingConfigurations = getChangingConfigurations();
        r14.mCacheDirty = true;
        inflateInternal(r5, r10, r11, r12);
        this.mTintFilter = updateTintFilter(this.mTintFilter, r14.mTint, r14.mTintMode);
    }

    public VectorDrawableCompat(@NonNull VectorDrawableCompatState r5) {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = r5;
        this.mTintFilter = updateTintFilter(this.mTintFilter, r5.mTint, r5.mTintMode);
    }
}
