package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
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

    public static class State {
        int mConstraintID;
        ConstraintSet mConstraintSet;
        int mId;
        ArrayList<Variant> mVariants;

        public State(Context r10, XmlPullParser r11) {
            this.mVariants = new ArrayList();
            this.mConstraintID = -1;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.State);
            int r5 = r12.getIndexCount();
            int r13 = 0;
        L3:
            if (r13 >= r5) goto L13;
            int r14 = r12.getIndex(r13);
            if (r14 != R.styleable.State_android_id) goto L8;
            this.mId = r12.getResourceId(r14, this.mId);
        L12:
            r13 = r13 + 1;
            goto L3
        L8:
            if (r14 != R.styleable.State_constraints) goto L12;
            this.mConstraintID = r12.getResourceId(r14, this.mConstraintID);
            String r15 = r10.getResources().getResourceTypeName(this.mConstraintID);
            r10.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r15) == false) goto L12;
            ConstraintSet r16 = new ConstraintSet();
            this.mConstraintSet = r16;
            r16.clone(r10, this.mConstraintID);
            goto L12
        L13:
            r12.recycle();
        }

        public void add(Variant r5) {
            this.mVariants.add(r5);
        }

        public int findMatch(float r5, float r10) {
            int r11 = 0;
        L4:
            if (r11 >= this.mVariants.size()) goto L9;
            if (this.mVariants.get(r11).match(r5, r10) == true) goto L7;
            r11 = r11 + 1;
            goto L4
        L7:
            return r11;
        L9:
            return -1;
        }
    }

    public static class Variant {
        int mConstraintID;
        ConstraintSet mConstraintSet;
        int mId;
        float mMaxHeight;
        float mMaxWidth;
        float mMinHeight;
        float mMinWidth;

        public Variant(Context r10, XmlPullParser r11) {
            this.mMinWidth = Float.NaN;
            this.mMinHeight = Float.NaN;
            this.mMaxWidth = Float.NaN;
            this.mMaxHeight = Float.NaN;
            this.mConstraintID = -1;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.Variant);
            int r5 = r12.getIndexCount();
            int r13 = 0;
        L3:
            if (r13 >= r5) goto L23;
            int r14 = r12.getIndex(r13);
            if (r14 != R.styleable.Variant_constraints) goto L10;
            this.mConstraintID = r12.getResourceId(r14, this.mConstraintID);
            String r15 = r10.getResources().getResourceTypeName(this.mConstraintID);
            r10.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r15) == false) goto L22;
            ConstraintSet r16 = new ConstraintSet();
            this.mConstraintSet = r16;
            r16.clone(r10, this.mConstraintID);
        L22:
            r13 = r13 + 1;
            goto L3
        L10:
            if (r14 != R.styleable.Variant_region_heightLessThan) goto L13;
            this.mMaxHeight = r12.getDimension(r14, this.mMaxHeight);
            goto L22
        L13:
            if (r14 != R.styleable.Variant_region_heightMoreThan) goto L16;
            this.mMinHeight = r12.getDimension(r14, this.mMinHeight);
            goto L22
        L16:
            if (r14 != R.styleable.Variant_region_widthLessThan) goto L19;
            this.mMaxWidth = r12.getDimension(r14, this.mMaxWidth);
            goto L22
        L19:
            if (r14 != R.styleable.Variant_region_widthMoreThan) goto L21;
            this.mMinWidth = r12.getDimension(r14, this.mMinWidth);
            goto L22
        L21:
            Log.v("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r12.recycle();
        }

        public boolean match(float r5, float r10) {
            if (Float.isNaN(this.mMinWidth) == true) goto L8;
            if (r5 >= this.mMinWidth) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.mMinHeight) == true) goto L13;
            if (r10 >= this.mMinHeight) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.mMaxWidth) == true) goto L18;
            if (r5 <= this.mMaxWidth) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.mMaxHeight) == false) goto L20;
            return true;
        L20:
            if (r10 <= this.mMaxHeight) goto L24;
            return false;
        L24:
            return true;
        }
    }

    public ConstraintLayoutStates(Context r5, ConstraintLayout r10, int r11) {
        this.mCurrentStateId = -1;
        this.mCurrentConstraintNumber = -1;
        this.mStateList = new SparseArray();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintsChangedListener = null;
        this.mConstraintLayout = r10;
        load(r5, r11);
    }

    private void load(Context r10, int r11) {
        XmlResourceParser r12 = r10.getResources().getXml(r11);
        int r5 = r12.getEventType();     // Catch: IOException -> L16 XmlPullParserException -> L18
        State r13 = null;
    L5:
        if (r5 == 1) goto L64;
        if (r5 != 0) goto L8;
        r12.getName();     // Catch: IOException -> L16 XmlPullParserException -> L18
    L45:
        r5 = r12.next();     // Catch: IOException -> L16 XmlPullParserException -> L18
    L8:
        if (r5 != 2) goto L45;
        String r14 = r12.getName();     // Catch: IOException -> L16 XmlPullParserException -> L18
        switch(r14.hashCode()) {
            case -1349929691: goto L30;
            case 80204913: goto L27;
            case 1382829617: goto L24;
            case 1657696882: goto L21;
            case 1901439077: goto L14;
            default: goto L32;
        };     // Catch: IOException -> L16 XmlPullParserException -> L18
    L32:
        byte r15 = -1;
    L33:
        if (r15 == 0) goto L45;
        if (r15 == 1) goto L45;
        if (r15 == 2) goto L43;
        if (r15 == 3) goto L40;
        if (r15 == 4) goto L39;
        Log.v("ConstraintLayoutStates", "unknown tag " + r14);     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L45
    L39:
        parseConstraintSet(r10, r12);     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L45
    L40:
        Variant r16 = new Variant(r10, r12);     // Catch: IOException -> L16 XmlPullParserException -> L18
        if (r13 == null) goto L45;
        r13.add(r16);     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L45
    L43:
        r13 = new State(r10, r12);     // Catch: IOException -> L16 XmlPullParserException -> L18
        this.mStateList.put(r13.mId, r13);     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L45
    L14:
        if (r14.equals("Variant") == false) goto L32;
        r15 = 3;
        goto L33
    L21:
        if (r14.equals("layoutDescription") == false) goto L32;
        r15 = 0;
        goto L33
    L24:
        if (r14.equals("StateSet") == false) goto L32;
        r15 = 1;
        goto L33
    L27:
        if (r14.equals("State") == false) goto L32;
        r15 = 2;
        goto L33
    L30:
        if (r14.equals("ConstraintSet") == false) goto L32;
        r15 = 4;
        goto L33
    L64:
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
    }

    private void parseConstraintSet(Context r10, XmlPullParser r11) {
        ConstraintSet r5 = new ConstraintSet();
        int r12 = r11.getAttributeCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L20;
        if ("id".equals(r11.getAttributeName(r13)) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        String r14 = r11.getAttributeValue(r13);
        if (r14.contains("/") == false) goto L9;
        int r15 = r10.getResources().getIdentifier(r14.substring(r14.indexOf(47) + 1), "id", r10.getPackageName());
    L10:
        if (r15 == (-1)) goto L12;
    L15:
        r5.load(r10, r11);
        this.mConstraintSetMap.put(r15, r5);
        return;
    L12:
        if (r14.length() <= 1) goto L14;
        r15 = Integer.parseInt(r14.substring(1));
        goto L15
    L14:
        Log.e("ConstraintLayoutStates", "error in parsing id");
        goto L15
    L9:
        r15 = -1;
        goto L10
    }

    public boolean needsToChange(int r5, float r10, float r11) {
        int r12 = this.mCurrentStateId;
        if (r12 == r5) goto L6;
        return true;
    L6:
        if (r5 != (-1)) goto L9;
        State r13 = this.mStateList.valueAt(0);
    L8:
        State r14 = r13;
        int r15 = this.mCurrentConstraintNumber;
        if (r15 == (-1)) goto L16;
        if (r14.mVariants.get(r15).match(r10, r11) == false) goto L16;
        return false;
    L16:
        if (this.mCurrentConstraintNumber != r14.findMatch(r10, r11)) goto L18;
        return false;
    L18:
        return true;
    L9:
        r13 = this.mStateList.get(r12);
        goto L8
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener r5) {
        this.mConstraintsChangedListener = r5;
    }

    public void updateConstraints(int r5, float r10, float r11) {
        int r12 = this.mCurrentStateId;
        if (r12 != r5) goto L29;
        if (r5 != (-1)) goto L6;
        State r13 = this.mStateList.valueAt(0);
    L7:
        int r14 = this.mCurrentConstraintNumber;
        if (r14 != (-1)) goto L10;
    L12:
        int r15 = r13.findMatch(r10, r11);
        if (this.mCurrentConstraintNumber != r15) goto L15;
        return;
    L15:
        if (r15 != (-1)) goto L17;
        ConstraintSet r16 = this.mDefaultConstraintSet;
    L18:
        if (r15 != (-1)) goto L20;
        int r17 = r13.mConstraintID;
    L21:
        if (r16 != null) goto L23;
        return;
    L23:
        this.mCurrentConstraintNumber = r15;
        ConstraintsChangedListener r18 = this.mConstraintsChangedListener;
        if (r18 == null) goto L26;
        r18.preLayoutChange(-1, r17);
    L26:
        r16.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener r19 = this.mConstraintsChangedListener;
        if (r19 == null) goto L46;
        r19.postLayoutChange(-1, r17);
        return;
    L46:
        return;
    L20:
        r17 = r13.mVariants.get(r15).mConstraintID;
        goto L21
    L17:
        r16 = r13.mVariants.get(r15).mConstraintSet;
        goto L18
    L10:
        if (r13.mVariants.get(r14).match(r10, r11) == false) goto L12;
        return;
    L6:
        r13 = this.mStateList.get(r12);
        goto L7
    L29:
        this.mCurrentStateId = r5;
        State r20 = this.mStateList.get(r5);
        int r21 = r20.findMatch(r10, r11);
        if (r21 != (-1)) goto L32;
        ConstraintSet r22 = r20.mConstraintSet;
    L33:
        if (r21 != (-1)) goto L35;
        int r23 = r20.mConstraintID;
    L36:
        if (r22 != null) goto L39;
        Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + r5 + ", dim =" + r10 + ", " + r11);
        return;
    L39:
        this.mCurrentConstraintNumber = r21;
        ConstraintsChangedListener r24 = this.mConstraintsChangedListener;
        if (r24 == null) goto L42;
        r24.preLayoutChange(r5, r23);
    L42:
        r22.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener r25 = this.mConstraintsChangedListener;
        if (r25 == null) goto L48;
        r25.postLayoutChange(r5, r23);
        return;
    L48:
        return;
    L35:
        r23 = r20.mVariants.get(r21).mConstraintID;
        goto L36
    L32:
        r22 = r20.mVariants.get(r21).mConstraintSet;
        goto L33
    }
}
