package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private SparseArray<ConstraintSet> mConstraintSetMap;
    private ConstraintsChangedListener mConstraintsChangedListener;
    int mCurrentConstraintNumber;
    int mCurrentStateId;
    ConstraintSet mDefaultConstraintSet;
    int mDefaultState;
    private SparseArray<State> mStateList;

    static class State {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        ArrayList<Variant> mVariants;

        public State(Context r8, XmlPullParser r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
            XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.memorydata.plugin");
            this.mVariants = new ArrayList();
            this.mConstraintID = -1;
            int r0 = 0;
            this.mIsLayout = false;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.State);
            int r2 = r12.getIndexCount();
        L3:
            if (r0 >= r2) goto L13;
            int r3 = r12.getIndex(r0);
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.State_android_id, "styleable", "State_android_id")) goto L8;
            this.mId = r12.getResourceId(r3, this.mId);
        L12:
            r0 = r0 + 1;
            goto L3
        L8:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.State_constraints, "styleable", "State_constraints")) goto L12;
            this.mConstraintID = r12.getResourceId(r3, this.mConstraintID);
            String r4 = ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceTypeName(this.mConstraintID);
            ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceName(this.mConstraintID);
            if ("layout".equals(r4) == false) goto L12;
            this.mIsLayout = true;
            goto L12
        L13:
            r12.recycle();
        }

        void add(Variant r1) {
            this.mVariants.add(r1);
        }

        public int findMatch(float r5, float r6) {
            int r0 = 0;
        L4:
            if (r0 >= this.mVariants.size()) goto L9;
            if (((Variant) ZeusTransformUtils.preCheckCast(this.mVariants.get(r0), Variant.class, "com.obric.memorydata.plugin")).match(r5, r6) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            return r0;
        L9:
            return -1;
        }
    }

    static class Variant {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        float mMaxHeight;
        float mMaxWidth;
        float mMinHeight;
        float mMinWidth;

        public Variant(Context r8, XmlPullParser r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
            XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.memorydata.plugin");
            this.mMinWidth = Float.NaN;
            this.mMinHeight = Float.NaN;
            this.mMaxWidth = Float.NaN;
            this.mMaxHeight = Float.NaN;
            this.mConstraintID = -1;
            int r0 = 0;
            this.mIsLayout = false;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.Variant);
            int r2 = r12.getIndexCount();
        L3:
            if (r0 >= r2) goto L23;
            int r3 = r12.getIndex(r0);
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_constraints, "styleable", "Variant_constraints")) goto L10;
            this.mConstraintID = r12.getResourceId(r3, this.mConstraintID);
            String r4 = ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceTypeName(this.mConstraintID);
            ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceName(this.mConstraintID);
            if ("layout".equals(r4) == false) goto L22;
            this.mIsLayout = true;
        L22:
            r0 = r0 + 1;
            goto L3
        L10:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_heightLessThan, "styleable", "Variant_region_heightLessThan")) goto L13;
            this.mMaxHeight = r12.getDimension(r3, this.mMaxHeight);
            goto L22
        L13:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_heightMoreThan, "styleable", "Variant_region_heightMoreThan")) goto L16;
            this.mMinHeight = r12.getDimension(r3, this.mMinHeight);
            goto L22
        L16:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_widthLessThan, "styleable", "Variant_region_widthLessThan")) goto L19;
            this.mMaxWidth = r12.getDimension(r3, this.mMaxWidth);
            goto L22
        L19:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_region_widthMoreThan, "styleable", "Variant_region_widthMoreThan")) goto L21;
            this.mMinWidth = r12.getDimension(r3, this.mMinWidth);
            goto L22
        L21:
            Log.v("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r12.recycle();
        }

        boolean match(float r3, float r4) {
            if (Float.isNaN(this.mMinWidth) == true) goto L8;
            if (r3 >= this.mMinWidth) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.mMinHeight) == true) goto L13;
            if (r4 >= this.mMinHeight) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.mMaxWidth) == true) goto L18;
            if (r3 <= this.mMaxWidth) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.mMaxHeight) == false) goto L20;
            return true;
        L20:
            if (r4 <= this.mMaxHeight) goto L24;
            return false;
        L24:
            return true;
        }
    }

    public StateSet(Context r3, XmlPullParser r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r4, XmlPullParser.class, "com.obric.memorydata.plugin");
        this.mDefaultState = -1;
        this.mCurrentStateId = -1;
        this.mCurrentConstraintNumber = -1;
        this.mStateList = new SparseArray();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintsChangedListener = null;
        load(r5, r6);
    }

    private void load(Context r10, XmlPullParser r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        XmlPullParser r13 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r11, XmlPullParser.class, "com.obric.memorydata.plugin");
        TypedArray r0 = r12.obtainStyledAttributes(Xml.asAttributeSet(r13), R.styleable.StateSet);
        int r1 = r0.getIndexCount();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        int r4 = r0.getIndex(r3);
        if (r4 != ZeusTransformUtils.mapRes(R.styleable.StateSet_defaultState, "styleable", "StateSet_defaultState")) goto L7;
        this.mDefaultState = r0.getResourceId(r4, this.mDefaultState);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        r0.recycle();
        State r2 = null;
        int r5 = r13.getEventType();     // Catch: IOException -> L46 XmlPullParserException -> L48
    L10:
        byte r6 = 1;
        if (r5 == 1) goto L66;
        if (r5 != 0) goto L14;
        r13.getName();     // Catch: IOException -> L46 XmlPullParserException -> L48
    L44:
        r5 = r13.next();     // Catch: IOException -> L46 XmlPullParserException -> L48
        goto L10
    L14:
        if (r5 == 2) goto L20;
        if (r5 != 3) goto L44;
        if ("StateSet".equals(r13.getName()) == false) goto L44;
        return;
    L20:
        String r7 = r13.getName();     // Catch: IOException -> L46 XmlPullParserException -> L48
        switch(r7.hashCode()) {
            case 80204913: goto L33;
            case 1301459538: goto L30;
            case 1382829617: goto L27;
            case 1901439077: goto L24;
            default: goto L35;
        };     // Catch: IOException -> L46 XmlPullParserException -> L48
    L35:
        r6 = -1;
    L36:
        if (r6 == 2) goto L42;
        if (r6 != 3) goto L44;
        Variant r8 = new Variant(r12, r13);     // Catch: IOException -> L46 XmlPullParserException -> L48
        if (r2 == null) goto L44;
        r2.add(r8);     // Catch: IOException -> L46 XmlPullParserException -> L48
        goto L44
    L42:
        r2 = new State(r12, r13);     // Catch: IOException -> L46 XmlPullParserException -> L48
        this.mStateList.put(r2.mId, r2);     // Catch: IOException -> L46 XmlPullParserException -> L48
        goto L44
    L24:
        if (r7.equals("Variant") == false) goto L35;
        r6 = 3;
        goto L36
    L27:
        if (r7.equals("StateSet") == false) goto L35;
    L30:
        if (r7.equals("LayoutDescription") == false) goto L35;
        r6 = 0;
        goto L36
    L33:
        if (r7.equals("State") == false) goto L35;
        r6 = 2;
        goto L36
    L66:
        return;
    L46:
        e = move-exception;
        e.printStackTrace();
        return;
    L48:
        e = move-exception;
        e.printStackTrace();
    }

    public int convertToConstraintSet(int r5, int r6, float r7, float r8) {
        State r4 = (State) ZeusTransformUtils.preCheckCast(this.mStateList.get(r6), State.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return r6;
    L6:
        if (r7 == (-1.0f)) goto L25;
        if (r8 == (-1.0f)) goto L25;
        Variant r9 = null;
        Iterator<Variant> r0 = r4.mVariants.iterator();
    L12:
        if (r0.hasNext() == false) goto L19;
        Variant r2 = (Variant) ZeusTransformUtils.preCheckCast(r0.next(), Variant.class, "com.obric.memorydata.plugin");
        if (r2.match(r7, r8) == false) goto L12;
        if (r5 == r2.mConstraintID) goto L17;
        r9 = r2;
        goto L12
    L17:
        return r5;
    L19:
        if (r9 == null) goto L23;
        return r9.mConstraintID;
    L23:
        return r4.mConstraintID;
    L25:
        if (r4.mConstraintID != r5) goto L27;
        return r5;
    L27:
        Iterator<Variant> r10 = r4.mVariants.iterator();
    L29:
        if (r10.hasNext() == false) goto L34;
        if (r5 != ((Variant) ZeusTransformUtils.preCheckCast(r10.next(), Variant.class, "com.obric.memorydata.plugin")).mConstraintID) goto L29;
        return r5;
    L34:
        return r4.mConstraintID;
    }

    public boolean needsToChange(int r6, float r7, float r8) {
        int r0 = this.mCurrentStateId;
        if (r0 == r6) goto L6;
        return true;
    L6:
        if (r6 != (-1)) goto L8;
        State r9 = this.mStateList.valueAt(0);
    L9:
        State r10 = (State) ZeusTransformUtils.preCheckCast(r9, State.class, "com.obric.memorydata.plugin");
        if (this.mCurrentConstraintNumber == (-1)) goto L15;
        if (((Variant) ZeusTransformUtils.preCheckCast(r10.mVariants.get(this.mCurrentConstraintNumber), Variant.class, "com.obric.memorydata.plugin")).match(r7, r8) == false) goto L15;
        return false;
    L15:
        if (this.mCurrentConstraintNumber != r10.findMatch(r7, r8)) goto L17;
        return false;
    L17:
        return true;
    L8:
        r9 = this.mStateList.get(r0);
        goto L9
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener r1) {
        this.mConstraintsChangedListener = r1;
    }

    public int stateGetConstraintID(int r2, int r3, int r4) {
        return updateConstraints(-1, r2, r3, r4);
    }

    public int updateConstraints(int r4, int r5, float r6, float r7) {
        if (r4 != r5) goto L22;
        if (r5 != (-1)) goto L6;
        State r8 = this.mStateList.valueAt(0);
    L7:
        State r9 = (State) ZeusTransformUtils.preCheckCast(r8, State.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L11;
        return -1;
    L11:
        if (this.mCurrentConstraintNumber != (-1)) goto L13;
    L15:
        int r3 = r9.findMatch(r6, r7);
        if (r4 != r3) goto L18;
        return r4;
    L18:
        if (r3 != (-1)) goto L21;
        return r9.mConstraintID;
    L21:
        return ((Variant) ZeusTransformUtils.preCheckCast(r9.mVariants.get(r3), Variant.class, "com.obric.memorydata.plugin")).mConstraintID;
    L13:
        if (((Variant) ZeusTransformUtils.preCheckCast(r9.mVariants.get(r4), Variant.class, "com.obric.memorydata.plugin")).match(r6, r7) == false) goto L15;
        return r4;
    L6:
        r8 = this.mStateList.get(this.mCurrentStateId);
        goto L7
    L22:
        State r10 = (State) ZeusTransformUtils.preCheckCast(this.mStateList.get(r5), State.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L25;
        return -1;
    L25:
        int r11 = r10.findMatch(r6, r7);
        if (r11 != (-1)) goto L29;
        return r10.mConstraintID;
    L29:
        return ((Variant) ZeusTransformUtils.preCheckCast(r10.mVariants.get(r11), Variant.class, "com.obric.memorydata.plugin")).mConstraintID;
    }
}
