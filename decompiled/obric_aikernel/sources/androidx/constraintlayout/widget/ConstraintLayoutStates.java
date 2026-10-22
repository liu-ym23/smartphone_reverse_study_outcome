package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.bytedance.bdinstall.oaid.OaidModel;
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

        public State(Context r10, XmlPullParser r11) {
            this.mVariants = new ArrayList();
            this.mConstraintID = -1;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.State);
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L13;
            int r15 = r12.getIndex(r14);
            if (r15 != R.styleable.State_android_id) goto L8;
            this.mId = r12.getResourceId(r15, this.mId);
        L12:
            r14 = r14 + 1;
            goto L3
        L8:
            if (r15 != R.styleable.State_constraints) goto L12;
            this.mConstraintID = r12.getResourceId(r15, this.mConstraintID);
            String r16 = r10.getResources().getResourceTypeName(this.mConstraintID);
            r10.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r16) == false) goto L12;
            ConstraintSet r17 = new ConstraintSet();
            this.mConstraintSet = r17;
            r17.clone(r10, this.mConstraintID);
            goto L12
        L13:
            r12.recycle();
        }

        void add(Variant r10) {
            this.mVariants.add(r10);
        }

        public int findMatch(float r10, float r11) {
            int r12 = 0;
        L4:
            if (r12 >= this.mVariants.size()) goto L9;
            if (this.mVariants.get(r12).match(r10, r11) == true) goto L7;
            r12 = r12 + 1;
            goto L4
        L7:
            return r12;
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

        public Variant(Context r10, XmlPullParser r11) {
            this.mMinWidth = Float.NaN;
            this.mMinHeight = Float.NaN;
            this.mMaxWidth = Float.NaN;
            this.mMaxHeight = Float.NaN;
            this.mConstraintID = -1;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.Variant);
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L23;
            int r15 = r12.getIndex(r14);
            if (r15 != R.styleable.Variant_constraints) goto L10;
            this.mConstraintID = r12.getResourceId(r15, this.mConstraintID);
            String r16 = r10.getResources().getResourceTypeName(this.mConstraintID);
            r10.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r16) == false) goto L22;
            ConstraintSet r17 = new ConstraintSet();
            this.mConstraintSet = r17;
            r17.clone(r10, this.mConstraintID);
        L22:
            r14 = r14 + 1;
            goto L3
        L10:
            if (r15 != R.styleable.Variant_region_heightLessThan) goto L13;
            this.mMaxHeight = r12.getDimension(r15, this.mMaxHeight);
            goto L22
        L13:
            if (r15 != R.styleable.Variant_region_heightMoreThan) goto L16;
            this.mMinHeight = r12.getDimension(r15, this.mMinHeight);
            goto L22
        L16:
            if (r15 != R.styleable.Variant_region_widthLessThan) goto L19;
            this.mMaxWidth = r12.getDimension(r15, this.mMaxWidth);
            goto L22
        L19:
            if (r15 != R.styleable.Variant_region_widthMoreThan) goto L21;
            this.mMinWidth = r12.getDimension(r15, this.mMinWidth);
            goto L22
        L21:
            Log.v("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r12.recycle();
        }

        boolean match(float r10, float r11) {
            if (Float.isNaN(this.mMinWidth) == true) goto L8;
            if (r10 >= this.mMinWidth) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.mMinHeight) == true) goto L13;
            if (r11 >= this.mMinHeight) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.mMaxWidth) == true) goto L18;
            if (r10 <= this.mMaxWidth) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.mMaxHeight) == false) goto L20;
            return true;
        L20:
            if (r11 <= this.mMaxHeight) goto L24;
            return false;
        L24:
            return true;
        }
    }

    ConstraintLayoutStates(Context r10, ConstraintLayout r11, int r12) {
        this.mCurrentStateId = -1;
        this.mCurrentConstraintNumber = -1;
        this.mStateList = new SparseArray();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintsChangedListener = null;
        this.mConstraintLayout = r11;
        load(r10, r12);
    }

    private void load(Context r10, int r11) {
        XmlResourceParser r12 = r10.getResources().getXml(r11);
        State r13 = null;
        int r14 = r12.getEventType();     // Catch: IOException -> L41 XmlPullParserException -> L43
    L4:
        byte r15 = 1;
        if (r14 == 1) goto L58;
        if (r14 != 0) goto L8;
        r12.getName();     // Catch: IOException -> L41 XmlPullParserException -> L43
    L39:
        r14 = r12.next();     // Catch: IOException -> L41 XmlPullParserException -> L43
    L8:
        if (r14 != 2) goto L39;
        String r16 = r12.getName();     // Catch: IOException -> L41 XmlPullParserException -> L43
        switch(r16.hashCode()) {
            case -1349929691: goto L26;
            case 80204913: goto L23;
            case 1382829617: goto L20;
            case 1657696882: goto L17;
            case 1901439077: goto L14;
            default: goto L28;
        };     // Catch: IOException -> L41 XmlPullParserException -> L43
    L28:
        r15 = -1;
    L29:
        if (r15 == 2) goto L37;
        if (r15 == 3) goto L34;
        if (r15 != 4) goto L39;
        parseConstraintSet(r10, r12);     // Catch: IOException -> L41 XmlPullParserException -> L43
        goto L39
    L34:
        Variant r17 = new Variant(r10, r12);     // Catch: IOException -> L41 XmlPullParserException -> L43
        if (r13 == null) goto L39;
        r13.add(r17);     // Catch: IOException -> L41 XmlPullParserException -> L43
        goto L39
    L37:
        r13 = new State(r10, r12);     // Catch: IOException -> L41 XmlPullParserException -> L43
        this.mStateList.put(r13.mId, r13);     // Catch: IOException -> L41 XmlPullParserException -> L43
        goto L39
    L14:
        if (r16.equals("Variant") == false) goto L28;
        r15 = 3;
        goto L29
    L17:
        if (r16.equals("layoutDescription") == false) goto L28;
        r15 = 0;
        goto L29
    L20:
        if (r16.equals("StateSet") == false) goto L28;
    L23:
        if (r16.equals("State") == false) goto L28;
        r15 = 2;
        goto L29
    L26:
        if (r16.equals("ConstraintSet") == false) goto L28;
        r15 = 4;
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
        ConstraintSet r12 = new ConstraintSet();
        int r13 = r11.getAttributeCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L27;
        String r15 = r11.getAttributeName(r14);
        String r16 = r11.getAttributeValue(r14);
        if (r15 == null) goto L20;
        if (r16 == null) goto L20;
        if (OaidModel.KEY_ID.equals(r15) == false) goto L20;
        if (r16.contains("/") == false) goto L13;
        int r17 = r10.getResources().getIdentifier(r16.substring(r16.indexOf(47) + 1), OaidModel.KEY_ID, r10.getPackageName());
    L14:
        if (r17 == (-1)) goto L16;
    L19:
        r12.load(r10, r11);
        this.mConstraintSetMap.put(r17, r12);
        return;
    L16:
        if (r16.length() <= 1) goto L18;
        r17 = Integer.parseInt(r16.substring(1));
        goto L19
    L18:
        Log.e("ConstraintLayoutStates", "error in parsing id");
        goto L19
    L13:
        r17 = -1;
    L20:
        r14 = r14 + 1;
        goto L3
    }

    public boolean needsToChange(int r10, float r11, float r12) {
        int r13 = this.mCurrentStateId;
        if (r13 == r10) goto L6;
        return true;
    L6:
        if (r10 != (-1)) goto L8;
        State r14 = this.mStateList.valueAt(0);
    L9:
        State r15 = r14;
        int r16 = this.mCurrentConstraintNumber;
        if (r16 == (-1)) goto L15;
        if (r15.mVariants.get(r16).match(r11, r12) == false) goto L15;
        return false;
    L15:
        if (this.mCurrentConstraintNumber != r15.findMatch(r11, r12)) goto L17;
        return false;
    L17:
        return true;
    L8:
        r14 = this.mStateList.get(r13);
        goto L9
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener r10) {
        this.mConstraintsChangedListener = r10;
    }

    public void updateConstraints(int r10, float r11, float r12) {
        int r13 = this.mCurrentStateId;
        if (r13 != r10) goto L29;
        if (r10 != (-1)) goto L6;
        State r14 = this.mStateList.valueAt(0);
    L7:
        State r15 = r14;
        int r16 = this.mCurrentConstraintNumber;
        if (r16 != (-1)) goto L10;
    L12:
        int r17 = r15.findMatch(r11, r12);
        if (this.mCurrentConstraintNumber != r17) goto L15;
        return;
    L15:
        if (r17 != (-1)) goto L17;
        ConstraintSet r18 = this.mDefaultConstraintSet;
    L18:
        if (r17 != (-1)) goto L20;
        int r19 = r15.mConstraintID;
    L21:
        if (r18 != null) goto L23;
        return;
    L23:
        this.mCurrentConstraintNumber = r17;
        ConstraintsChangedListener r20 = this.mConstraintsChangedListener;
        if (r20 == null) goto L26;
        r20.preLayoutChange(-1, r19);
    L26:
        r18.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener r21 = this.mConstraintsChangedListener;
        if (r21 == null) goto L46;
        r21.postLayoutChange(-1, r19);
        return;
    L46:
        return;
    L20:
        r19 = r15.mVariants.get(r17).mConstraintID;
        goto L21
    L17:
        r18 = r15.mVariants.get(r17).mConstraintSet;
        goto L18
    L10:
        if (r15.mVariants.get(r16).match(r11, r12) == false) goto L12;
        return;
    L6:
        r14 = this.mStateList.get(r13);
        goto L7
    L29:
        this.mCurrentStateId = r10;
        State r22 = this.mStateList.get(r10);
        int r23 = r22.findMatch(r11, r12);
        if (r23 != (-1)) goto L32;
        ConstraintSet r24 = r22.mConstraintSet;
    L33:
        if (r23 != (-1)) goto L35;
        int r25 = r22.mConstraintID;
    L36:
        if (r24 != null) goto L39;
        Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + r10 + ", dim =" + r11 + ", " + r12);
        return;
    L39:
        this.mCurrentConstraintNumber = r23;
        ConstraintsChangedListener r26 = this.mConstraintsChangedListener;
        if (r26 == null) goto L42;
        r26.preLayoutChange(r10, r25);
    L42:
        r24.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener r27 = this.mConstraintsChangedListener;
        if (r27 == null) goto L48;
        r27.postLayoutChange(r10, r25);
        return;
    L48:
        return;
    L35:
        r25 = r22.mVariants.get(r23).mConstraintID;
        goto L36
    L32:
        r24 = r22.mVariants.get(r23).mConstraintSet;
        goto L33
    }
}
