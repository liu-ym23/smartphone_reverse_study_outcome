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

    public static class State {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        ArrayList<Variant> mVariants;

        public State(Context r10, XmlPullParser r11) {
            this.mVariants = new ArrayList();
            this.mConstraintID = -1;
            int r5 = 0;
            this.mIsLayout = false;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.State);
            int r13 = r12.getIndexCount();
        L3:
            if (r5 >= r13) goto L13;
            int r14 = r12.getIndex(r5);
            if (r14 != R.styleable.State_android_id) goto L8;
            this.mId = r12.getResourceId(r14, this.mId);
        L12:
            r5 = r5 + 1;
            goto L3
        L8:
            if (r14 != R.styleable.State_constraints) goto L12;
            this.mConstraintID = r12.getResourceId(r14, this.mConstraintID);
            String r15 = r10.getResources().getResourceTypeName(this.mConstraintID);
            r10.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r15) == false) goto L12;
            this.mIsLayout = true;
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
            int r5 = 0;
            this.mIsLayout = false;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.Variant);
            int r13 = r12.getIndexCount();
        L3:
            if (r5 >= r13) goto L23;
            int r14 = r12.getIndex(r5);
            if (r14 != R.styleable.Variant_constraints) goto L10;
            this.mConstraintID = r12.getResourceId(r14, this.mConstraintID);
            String r15 = r10.getResources().getResourceTypeName(this.mConstraintID);
            r10.getResources().getResourceName(this.mConstraintID);
            if ("layout".equals(r15) == false) goto L22;
            this.mIsLayout = true;
        L22:
            r5 = r5 + 1;
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

    public StateSet(Context r5, XmlPullParser r10) {
        this.mDefaultState = -1;
        this.mCurrentStateId = -1;
        this.mCurrentConstraintNumber = -1;
        this.mStateList = new SparseArray();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintsChangedListener = null;
        load(r5, r10);
    }

    private void load(Context r10, XmlPullParser r11) {
        TypedArray r5 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R.styleable.StateSet);
        int r12 = r5.getIndexCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        int r14 = r5.getIndex(r13);
        if (r14 != R.styleable.StateSet_defaultState) goto L7;
        this.mDefaultState = r5.getResourceId(r14, this.mDefaultState);
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        r5.recycle();
        int r15 = r11.getEventType();     // Catch: IOException -> L21 XmlPullParserException -> L23
        State r16 = null;
    L12:
        if (r15 == 1) goto L73;
        if (r15 != 0) goto L15;
        r11.getName();     // Catch: IOException -> L21 XmlPullParserException -> L23
    L51:
        r15 = r11.next();     // Catch: IOException -> L21 XmlPullParserException -> L23
        goto L12
    L15:
        if (r15 == 2) goto L25;
        if (r15 != 3) goto L51;
        if ("StateSet".equals(r11.getName()) == false) goto L51;
        return;
    L25:
        String r17 = r11.getName();     // Catch: IOException -> L21 XmlPullParserException -> L23
        switch(r17.hashCode()) {
            case 80204913: goto L38;
            case 1301459538: goto L35;
            case 1382829617: goto L32;
            case 1901439077: goto L29;
            default: goto L40;
        };     // Catch: IOException -> L21 XmlPullParserException -> L23
    L40:
        byte r18 = -1;
    L41:
        if (r18 == 0) goto L51;
        if (r18 == 1) goto L51;
        if (r18 == 2) goto L49;
        if (r18 == 3) goto L46;
        Log.v("ConstraintLayoutStates", "unknown tag " + r17);     // Catch: IOException -> L21 XmlPullParserException -> L23
        goto L51
    L46:
        Variant r19 = new Variant(r10, r11);     // Catch: IOException -> L21 XmlPullParserException -> L23
        if (r16 == null) goto L51;
        r16.add(r19);     // Catch: IOException -> L21 XmlPullParserException -> L23
        goto L51
    L49:
        r16 = new State(r10, r11);     // Catch: IOException -> L21 XmlPullParserException -> L23
        this.mStateList.put(r16.mId, r16);     // Catch: IOException -> L21 XmlPullParserException -> L23
        goto L51
    L29:
        if (r17.equals("Variant") == false) goto L40;
        r18 = 3;
        goto L41
    L32:
        if (r17.equals("StateSet") == false) goto L40;
        r18 = 1;
        goto L41
    L35:
        if (r17.equals("LayoutDescription") == false) goto L40;
        r18 = 0;
        goto L41
    L38:
        if (r17.equals("State") == false) goto L40;
        r18 = 2;
        goto L41
    L73:
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
        return;
    L23:
        e = move-exception;
        e.printStackTrace();
    }

    public int convertToConstraintSet(int r5, int r10, float r11, float r12) {
        State r13 = this.mStateList.get(r10);
        if (r13 != null) goto L6;
        return r10;
    L6:
        if (r11 == (-1.0f)) goto L25;
        if (r12 == (-1.0f)) goto L25;
        Iterator<Variant> r14 = r13.mVariants.iterator();
        Variant r15 = null;
    L12:
        if (r14.hasNext() == false) goto L19;
        Variant r16 = r14.next();
        if (r16.match(r11, r12) == false) goto L12;
        if (r5 == r16.mConstraintID) goto L17;
        r15 = r16;
        goto L12
    L17:
        return r5;
    L19:
        if (r15 == null) goto L23;
        return r15.mConstraintID;
    L23:
        return r13.mConstraintID;
    L25:
        if (r13.mConstraintID != r5) goto L27;
        return r5;
    L27:
        Iterator<Variant> r17 = r13.mVariants.iterator();
    L29:
        if (r17.hasNext() == false) goto L34;
        if (r5 != r17.next().mConstraintID) goto L29;
        return r5;
    L34:
        return r13.mConstraintID;
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

    public int stateGetConstraintID(int r5, int r10, int r11) {
        return updateConstraints(-1, r5, r10, r11);
    }

    public int updateConstraints(int r5, int r10, float r11, float r12) {
        if (r5 != r10) goto L21;
        if (r10 != (-1)) goto L6;
        State r13 = this.mStateList.valueAt(0);
    L7:
        if (r13 != null) goto L10;
        return -1;
    L10:
        if (this.mCurrentConstraintNumber != (-1)) goto L12;
    L14:
        int r14 = r13.findMatch(r11, r12);
        if (r5 != r14) goto L17;
        return r5;
    L17:
        if (r14 != (-1)) goto L20;
        return r13.mConstraintID;
    L20:
        return r13.mVariants.get(r14).mConstraintID;
    L12:
        if (r13.mVariants.get(r5).match(r11, r12) == false) goto L14;
        return r5;
    L6:
        r13 = this.mStateList.get(this.mCurrentStateId);
        goto L7
    L21:
        State r15 = this.mStateList.get(r10);
        if (r15 != null) goto L24;
        return -1;
    L24:
        int r16 = r15.findMatch(r11, r12);
        if (r16 != (-1)) goto L28;
        return r15.mConstraintID;
    L28:
        return r15.mVariants.get(r16).mConstraintID;
    }
}
