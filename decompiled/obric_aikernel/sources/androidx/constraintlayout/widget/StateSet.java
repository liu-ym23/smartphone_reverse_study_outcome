package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
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

        public State(Context r10, XmlPullParser r11) {
            this.mVariants = new ArrayList();
            this.mConstraintID = -1;
            int r12 = 0;
            this.mIsLayout = false;
            TypedArray r13 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.State);
            int r14 = r13.getIndexCount();
        L3:
            if (r12 >= r14) goto L13;
            int r15 = r13.getIndex(r12);
            if (r15 != R.styleable.State_android_id) goto L8;
            this.mId = r13.getResourceId(r15, this.mId);
        L12:
            r12 = r12 + 1;
            goto L3
        L8:
            if (r15 != R.styleable.State_constraints) goto L12;
            this.mConstraintID = r13.getResourceId(r15, this.mConstraintID);
            String r16 = r10.getResources().getResourceTypeName(this.mConstraintID);
            r10.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r16) == false) goto L12;
            this.mIsLayout = true;
            goto L12
        L13:
            r13.recycle();
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
        int mId;
        boolean mIsLayout;
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
            int r12 = 0;
            this.mIsLayout = false;
            TypedArray r13 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.Variant);
            int r14 = r13.getIndexCount();
        L3:
            if (r12 >= r14) goto L23;
            int r15 = r13.getIndex(r12);
            if (r15 != R.styleable.Variant_constraints) goto L10;
            this.mConstraintID = r13.getResourceId(r15, this.mConstraintID);
            String r16 = r10.getResources().getResourceTypeName(this.mConstraintID);
            r10.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r16) == false) goto L22;
            this.mIsLayout = true;
        L22:
            r12 = r12 + 1;
            goto L3
        L10:
            if (r15 != R.styleable.Variant_region_heightLessThan) goto L13;
            this.mMaxHeight = r13.getDimension(r15, this.mMaxHeight);
            goto L22
        L13:
            if (r15 != R.styleable.Variant_region_heightMoreThan) goto L16;
            this.mMinHeight = r13.getDimension(r15, this.mMinHeight);
            goto L22
        L16:
            if (r15 != R.styleable.Variant_region_widthLessThan) goto L19;
            this.mMaxWidth = r13.getDimension(r15, this.mMaxWidth);
            goto L22
        L19:
            if (r15 != R.styleable.Variant_region_widthMoreThan) goto L21;
            this.mMinWidth = r13.getDimension(r15, this.mMinWidth);
            goto L22
        L21:
            Log.v("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r13.recycle();
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

    public StateSet(Context r10, XmlPullParser r11) {
        this.mDefaultState = -1;
        this.mCurrentStateId = -1;
        this.mCurrentConstraintNumber = -1;
        this.mStateList = new SparseArray();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintsChangedListener = null;
        load(r10, r11);
    }

    private void load(Context r10, XmlPullParser r11) {
        TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.StateSet);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        int r15 = r12.getIndex(r14);
        if (r15 != R.styleable.StateSet_defaultState) goto L7;
        this.mDefaultState = r12.getResourceId(r15, this.mDefaultState);
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        r12.recycle();
        State r16 = null;
        int r17 = r11.getEventType();     // Catch: IOException -> L46 XmlPullParserException -> L48
    L10:
        byte r18 = 1;
        if (r17 == 1) goto L66;
        if (r17 != 0) goto L14;
        r11.getName();     // Catch: IOException -> L46 XmlPullParserException -> L48
    L44:
        r17 = r11.next();     // Catch: IOException -> L46 XmlPullParserException -> L48
        goto L10
    L14:
        if (r17 == 2) goto L20;
        if (r17 != 3) goto L44;
        if ("StateSet".equals(r11.getName()) == false) goto L44;
        return;
    L20:
        String r19 = r11.getName();     // Catch: IOException -> L46 XmlPullParserException -> L48
        switch(r19.hashCode()) {
            case 80204913: goto L33;
            case 1301459538: goto L30;
            case 1382829617: goto L27;
            case 1901439077: goto L24;
            default: goto L35;
        };     // Catch: IOException -> L46 XmlPullParserException -> L48
    L35:
        r18 = -1;
    L36:
        if (r18 == 2) goto L42;
        if (r18 != 3) goto L44;
        Variant r20 = new Variant(r10, r11);     // Catch: IOException -> L46 XmlPullParserException -> L48
        if (r16 == null) goto L44;
        r16.add(r20);     // Catch: IOException -> L46 XmlPullParserException -> L48
        goto L44
    L42:
        r16 = new State(r10, r11);     // Catch: IOException -> L46 XmlPullParserException -> L48
        this.mStateList.put(r16.mId, r16);     // Catch: IOException -> L46 XmlPullParserException -> L48
        goto L44
    L24:
        if (r19.equals("Variant") == false) goto L35;
        r18 = 3;
        goto L36
    L27:
        if (r19.equals("StateSet") == false) goto L35;
    L30:
        if (r19.equals("LayoutDescription") == false) goto L35;
        r18 = 0;
        goto L36
    L33:
        if (r19.equals("State") == false) goto L35;
        r18 = 2;
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

    public int convertToConstraintSet(int r10, int r11, float r12, float r13) {
        State r14 = this.mStateList.get(r11);
        if (r14 != null) goto L6;
        return r11;
    L6:
        if (r12 == (-1.0f)) goto L25;
        if (r13 == (-1.0f)) goto L25;
        Variant r15 = null;
        Iterator<Variant> r16 = r14.mVariants.iterator();
    L12:
        if (r16.hasNext() == false) goto L19;
        Variant r17 = r16.next();
        if (r17.match(r12, r13) == false) goto L12;
        if (r10 == r17.mConstraintID) goto L17;
        r15 = r17;
        goto L12
    L17:
        return r10;
    L19:
        if (r15 == null) goto L23;
        return r15.mConstraintID;
    L23:
        return r14.mConstraintID;
    L25:
        if (r14.mConstraintID != r10) goto L27;
        return r10;
    L27:
        Iterator<Variant> r18 = r14.mVariants.iterator();
    L29:
        if (r18.hasNext() == false) goto L34;
        if (r10 != r18.next().mConstraintID) goto L29;
        return r10;
    L34:
        return r14.mConstraintID;
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

    public int stateGetConstraintID(int r10, int r11, int r12) {
        return updateConstraints(-1, r10, r11, r12);
    }

    public int updateConstraints(int r10, int r11, float r12, float r13) {
        if (r10 != r11) goto L22;
        if (r11 != (-1)) goto L6;
        State r14 = this.mStateList.valueAt(0);
    L7:
        State r15 = r14;
        if (r15 != null) goto L11;
        return -1;
    L11:
        if (this.mCurrentConstraintNumber != (-1)) goto L13;
    L15:
        int r16 = r15.findMatch(r12, r13);
        if (r10 != r16) goto L18;
        return r10;
    L18:
        if (r16 != (-1)) goto L21;
        return r15.mConstraintID;
    L21:
        return r15.mVariants.get(r16).mConstraintID;
    L13:
        if (r15.mVariants.get(r10).match(r12, r13) == false) goto L15;
        return r10;
    L6:
        r14 = this.mStateList.get(this.mCurrentStateId);
        goto L7
    L22:
        State r17 = this.mStateList.get(r11);
        if (r17 != null) goto L25;
        return -1;
    L25:
        int r18 = r17.findMatch(r12, r13);
        if (r18 != (-1)) goto L29;
        return r17.mConstraintID;
    L29:
        return r17.mVariants.get(r18).mConstraintID;
    }
}
