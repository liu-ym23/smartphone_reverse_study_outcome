package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayoutStates {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private final ConstraintLayout mConstraintLayout;
    private SparseArray<ConstraintSet> mConstraintSetMap;
    private ConstraintsChangedListener mConstraintsChangedListener;
    int mCurrentConstraintNumber;
    int mCurrentStateId;
    ConstraintSet mDefaultConstraintSet;
    private SparseArray<State> mStateList;

    static class State {
        int mConstraintID;
        ConstraintSet mConstraintSet;
        int mId;
        ArrayList<Variant> mVariants;

        public State(Context r8, XmlPullParser r9) {
            Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
            XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r9, XmlPullParser.class, "com.obric.memorydata.plugin");
            this.mVariants = new ArrayList();
            this.mConstraintID = -1;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.State);
            int r0 = r12.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L13;
            int r3 = r12.getIndex(r2);
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.State_android_id, "styleable", "State_android_id")) goto L8;
            this.mId = r12.getResourceId(r3, this.mId);
        L12:
            r2 = r2 + 1;
            goto L3
        L8:
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.State_constraints, "styleable", "State_constraints")) goto L12;
            this.mConstraintID = r12.getResourceId(r3, this.mConstraintID);
            String r4 = ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceTypeName(this.mConstraintID);
            ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceName(this.mConstraintID);
            if ("layout".equals(r4) == false) goto L12;
            ConstraintSet r5 = new ConstraintSet();
            this.mConstraintSet = r5;
            r5.clone(r10, this.mConstraintID);
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
        ConstraintSet mConstraintSet;
        int mId;
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
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.Variant);
            int r0 = r12.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L23;
            int r3 = r12.getIndex(r2);
            if (r3 != ZeusTransformUtils.mapRes(R.styleable.Variant_constraints, "styleable", "Variant_constraints")) goto L10;
            this.mConstraintID = r12.getResourceId(r3, this.mConstraintID);
            String r4 = ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceTypeName(this.mConstraintID);
            ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getResourceName(this.mConstraintID);
            if ("layout".equals(r4) == false) goto L22;
            ConstraintSet r5 = new ConstraintSet();
            this.mConstraintSet = r5;
            r5.clone(r10, this.mConstraintID);
        L22:
            r2 = r2 + 1;
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

    ConstraintLayoutStates(Context r3, ConstraintLayout r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mCurrentStateId = -1;
        this.mCurrentConstraintNumber = -1;
        this.mStateList = new SparseArray();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintsChangedListener = null;
        this.mConstraintLayout = r4;
        load(r6, r5);
    }

    private void load(Context r9, int r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        XmlResourceParser r12 = ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").getXml(r10);
        State r0 = null;
        int r1 = r12.getEventType();     // Catch: IOException -> L41 XmlPullParserException -> L43
    L4:
        byte r2 = 1;
        if (r1 == 1) goto L58;
        if (r1 != 0) goto L8;
        r12.getName();     // Catch: IOException -> L41 XmlPullParserException -> L43
    L39:
        r1 = r12.next();     // Catch: IOException -> L41 XmlPullParserException -> L43
    L8:
        if (r1 != 2) goto L39;
        String r3 = r12.getName();     // Catch: IOException -> L41 XmlPullParserException -> L43
        switch(r3.hashCode()) {
            case -1349929691: goto L26;
            case 80204913: goto L23;
            case 1382829617: goto L20;
            case 1657696882: goto L17;
            case 1901439077: goto L14;
            default: goto L28;
        };     // Catch: IOException -> L41 XmlPullParserException -> L43
    L28:
        r2 = -1;
    L29:
        if (r2 == 2) goto L37;
        if (r2 == 3) goto L34;
        if (r2 != 4) goto L39;
        parseConstraintSet(r11, r12);     // Catch: IOException -> L41 XmlPullParserException -> L43
        goto L39
    L34:
        Variant r4 = new Variant(r11, r12);     // Catch: IOException -> L41 XmlPullParserException -> L43
        if (r0 == null) goto L39;
        r0.add(r4);     // Catch: IOException -> L41 XmlPullParserException -> L43
        goto L39
    L37:
        r0 = new State(r11, r12);     // Catch: IOException -> L41 XmlPullParserException -> L43
        this.mStateList.put(r0.mId, r0);     // Catch: IOException -> L41 XmlPullParserException -> L43
        goto L39
    L14:
        if (r3.equals("Variant") == false) goto L28;
        r2 = 3;
        goto L29
    L17:
        if (r3.equals("layoutDescription") == false) goto L28;
        r2 = 0;
        goto L29
    L20:
        if (r3.equals("StateSet") == false) goto L28;
    L23:
        if (r3.equals("State") == false) goto L28;
        r2 = 2;
        goto L29
    L26:
        if (r3.equals("ConstraintSet") == false) goto L28;
        r2 = 4;
        goto L29
    L58:
        return;
    L41:
        e = move-exception;
        e.printStackTrace();
        return;
    L43:
        e = move-exception;
        e.printStackTrace();
    }

    private void parseConstraintSet(Context r10, XmlPullParser r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        XmlPullParser r13 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r11, XmlPullParser.class, "com.obric.memorydata.plugin");
        ConstraintSet r0 = new ConstraintSet();
        int r2 = r13.getAttributeCount();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L27;
        String r4 = r13.getAttributeName(r3);
        String r5 = r13.getAttributeValue(r3);
        if (r4 == null) goto L20;
        if (r5 == null) goto L20;
        if (OaidModel.KEY_ID.equals(r4) == false) goto L20;
        if (r5.contains("/") == false) goto L13;
        int r1 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin"), r5.substring(r5.indexOf(47) + 1), OaidModel.KEY_ID, r12.getPackageName(), "com.obric.memorydata.plugin");
    L14:
        if (r1 == (-1)) goto L16;
    L19:
        r0.load(r12, r13);
        this.mConstraintSetMap.put(r1, r0);
        return;
    L16:
        if (r5.length() <= 1) goto L18;
        r1 = Integer.parseInt(r5.substring(1));
        goto L19
    L18:
        Log.e("ConstraintLayoutStates", "error in parsing id");
        goto L19
    L13:
        r1 = -1;
    L20:
        r3 = r3 + 1;
        goto L3
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

    public void updateConstraints(int r7, float r8, float r9) {
        int r0 = this.mCurrentStateId;
        if (r0 != r7) goto L29;
        if (r7 != (-1)) goto L6;
        State r10 = this.mStateList.valueAt(0);
    L7:
        State r11 = (State) ZeusTransformUtils.preCheckCast(r10, State.class, "com.obric.memorydata.plugin");
        if (this.mCurrentConstraintNumber != (-1)) goto L10;
    L12:
        int r12 = r11.findMatch(r8, r9);
        if (this.mCurrentConstraintNumber != r12) goto L15;
        return;
    L15:
        if (r12 != (-1)) goto L17;
        ConstraintSet r13 = this.mDefaultConstraintSet;
    L18:
        if (r12 != (-1)) goto L20;
        int r14 = r11.mConstraintID;
    L21:
        if (r13 != null) goto L23;
        return;
    L23:
        this.mCurrentConstraintNumber = r12;
        ConstraintsChangedListener r15 = this.mConstraintsChangedListener;
        if (r15 == null) goto L26;
        r15.preLayoutChange(-1, r14);
    L26:
        r13.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener r6 = this.mConstraintsChangedListener;
        if (r6 == null) goto L46;
        r6.postLayoutChange(-1, r14);
        return;
    L46:
        return;
    L20:
        r14 = ((Variant) ZeusTransformUtils.preCheckCast(r11.mVariants.get(r12), Variant.class, "com.obric.memorydata.plugin")).mConstraintID;
        goto L21
    L17:
        r13 = ((Variant) ZeusTransformUtils.preCheckCast(r11.mVariants.get(r12), Variant.class, "com.obric.memorydata.plugin")).mConstraintSet;
        goto L18
    L10:
        if (((Variant) ZeusTransformUtils.preCheckCast(r11.mVariants.get(this.mCurrentConstraintNumber), Variant.class, "com.obric.memorydata.plugin")).match(r8, r9) == false) goto L12;
        return;
    L6:
        r10 = this.mStateList.get(r0);
        goto L7
    L29:
        this.mCurrentStateId = r7;
        State r1 = (State) ZeusTransformUtils.preCheckCast(this.mStateList.get(r7), State.class, "com.obric.memorydata.plugin");
        int r3 = r1.findMatch(r8, r9);
        if (r3 != (-1)) goto L32;
        ConstraintSet r4 = r1.mConstraintSet;
    L33:
        if (r3 != (-1)) goto L35;
        int r2 = r1.mConstraintID;
    L36:
        if (r4 != null) goto L39;
        Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + r7 + ", dim =" + r8 + ", " + r9);
        return;
    L39:
        this.mCurrentConstraintNumber = r3;
        ConstraintsChangedListener r16 = this.mConstraintsChangedListener;
        if (r16 == null) goto L42;
        r16.preLayoutChange(r7, r2);
    L42:
        r4.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener r17 = this.mConstraintsChangedListener;
        if (r17 == null) goto L48;
        r17.postLayoutChange(r7, r2);
        return;
    L48:
        return;
    L35:
        r2 = ((Variant) ZeusTransformUtils.preCheckCast(r1.mVariants.get(r3), Variant.class, "com.obric.memorydata.plugin")).mConstraintID;
        goto L36
    L32:
        r4 = ((Variant) ZeusTransformUtils.preCheckCast(r1.mVariants.get(r3), Variant.class, "com.obric.memorydata.plugin")).mConstraintSet;
        goto L33
    }
}
