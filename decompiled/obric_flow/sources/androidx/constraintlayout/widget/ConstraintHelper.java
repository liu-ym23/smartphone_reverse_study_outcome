package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintHelper extends View {
    protected int mCount;
    protected Helper mHelperWidget;
    protected int[] mIds;
    private HashMap<Integer, String> mMap;
    protected String mReferenceIds;
    protected String mReferenceTags;
    protected boolean mUseViewMeasure;
    private View[] mViews;
    protected Context myContext;

    public ConstraintHelper(Context r5) {
        super(r5);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = r5;
        init(null);
    }

    private void addID(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() != 0) goto L7;
        return;
    L7:
        if (this.myContext != null) goto L9;
        return;
    L9:
        String r10 = r5.trim();
        if ((getParent() instanceof ConstraintLayout) == false) goto L12;
        ConstraintLayout r11 = (ConstraintLayout) getParent();
    L12:
        int r12 = findId(r10);
        if (r12 == 0) goto L15;
        this.mMap.put(Integer.valueOf(r12), r10);
        addRscID(r12);
        return;
    L15:
        Log.w("ConstraintHelper", "Could not find id of \"" + r10 + "\"");
    }

    private void addRscID(int r5) {
        if (r5 != getId()) goto L5;
        return;
    L5:
        int r10 = this.mCount + 1;
        int[] r11 = this.mIds;
        if (r10 <= r11.length) goto L8;
        this.mIds = Arrays.copyOf(r11, r11.length * 2);
    L8:
        int[] r12 = this.mIds;
        int r13 = this.mCount;
        r12[r13] = r5;
        this.mCount = r13 + 1;
    }

    private void addTag(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() != 0) goto L7;
        return;
    L7:
        if (this.myContext != null) goto L9;
        return;
    L9:
        String r11 = r10.trim();
        if ((getParent() instanceof ConstraintLayout) == false) goto L12;
        ConstraintLayout r5 = (ConstraintLayout) getParent();
    L14:
        if (r5 != null) goto L17;
        Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
        return;
    L17:
        int r12 = r5.getChildCount();
        int r13 = 0;
    L18:
        if (r13 >= r12) goto L35;
        View r14 = r5.getChildAt(r13);
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if ((r15 instanceof ConstraintLayout.LayoutParams) == false) goto L27;
        if (r11.equals(((ConstraintLayout.LayoutParams) r15).constraintTag) == false) goto L27;
        if (r14.getId() != (-1)) goto L26;
        Log.w("ConstraintHelper", "to use ConstraintTag view " + r14.getClass().getSimpleName() + " must have an ID");
        goto L27
    L26:
        addRscID(r14.getId());
    L27:
        r13 = r13 + 1;
        goto L18
    L35:
        return;
    L12:
        r5 = null;
        goto L14
    }

    private int[] convertReferenceString(View r5, String r10) {
        String[] r11 = r10.split(",");
        r5.getContext();
        int[] r12 = new int[r11.length];
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r11.length) goto L10;
        int r15 = findId(r11[r13].trim());
        if (r15 == 0) goto L8;
        r12[r14] = r15;
        r14 = r14 + 1;
    L8:
        r13 = r13 + 1;
        goto L4
    L10:
        if (r14 != r11.length) goto L12;
        return r12;
    L12:
        return Arrays.copyOf(r12, r14);
    }

    private int findId(String r10) {
        if ((getParent() instanceof ConstraintLayout) == false) goto L5;
        ConstraintLayout r5 = (ConstraintLayout) getParent();
    L6:
        int r11 = 0;
        if (isInEditMode() == false) goto L12;
        if (r5 == null) goto L12;
        Object r12 = r5.getDesignInformation(0, r10);
        if ((r12 instanceof Integer) == false) goto L12;
        r11 = ((Integer) r12).intValue();
    L12:
        if (r11 != 0) goto L15;
        if (r5 == null) goto L15;
        r11 = findId(r5, r10);
    L15:
        if (r11 == 0) goto L21;
    L17:
        if (r11 == 0) goto L19;
        return r11;
    L19:
        return this.myContext.getResources().getIdentifier(r10, "id", this.myContext.getPackageName());
    L21:
        r11 = R.id.class.getField(r10).getInt(null);     // Catch: Exception -> L20
        goto L17
    L5:
        r5 = null;
        goto L6
    }

    public void addView(View r5) {
        if (r5 != this) goto L5;
        return;
    L5:
        if (r5.getId() != (-1)) goto L9;
        Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
        return;
    L9:
        if (r5.getParent() != null) goto L12;
        Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
        return;
    L12:
        this.mReferenceIds = null;
        addRscID(r5.getId());
        requestLayout();
    }

    public void applyLayoutFeatures(ConstraintLayout r10) {
        int r5 = getVisibility();
        float r11 = getElevation();
        int r12 = 0;
    L4:
        if (r12 >= this.mCount) goto L11;
        View r13 = r10.getViewById(this.mIds[r12]);
        if (r13 == null) goto L10;
        r13.setVisibility(r5);
        if (r11 <= 0.0f) goto L10;
        r13.setTranslationZ(r13.getTranslationZ() + r11);
    L10:
        r12 = r12 + 1;
        goto L4
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.mIds, this.mCount);
    }

    public View[] getViews(ConstraintLayout r5) {
        View[] r10 = this.mViews;
        if (r10 != null) goto L5;
    L6:
        this.mViews = new View[this.mCount];
    L7:
        int r11 = 0;
    L9:
        if (r11 >= this.mCount) goto L12;
        int r12 = this.mIds[r11];
        this.mViews[r11] = r5.getViewById(r12);
        r11 = r11 + 1;
        goto L9
    L12:
        return this.mViews;
    L5:
        if (r10.length == this.mCount) goto L7;
        goto L6
    }

    public void init(AttributeSet r5) {
        if (r5 == null) goto L18;
        TypedArray r10 = getContext().obtainStyledAttributes(r5, R.styleable.ConstraintLayout_Layout);
        int r11 = r10.getIndexCount();
        int r12 = 0;
    L4:
        if (r12 >= r11) goto L12;
        int r13 = r10.getIndex(r12);
        if (r13 != R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) goto L9;
        String r14 = r10.getString(r13);
        this.mReferenceIds = r14;
        setIds(r14);
    L11:
        r12 = r12 + 1;
        goto L4
    L9:
        if (r13 != R.styleable.ConstraintLayout_Layout_constraint_referenced_tags) goto L11;
        String r15 = r10.getString(r13);
        this.mReferenceTags = r15;
        setReferenceTags(r15);
        goto L11
    L12:
        r10.recycle();
        return;
    }

    public void loadParameters(ConstraintSet.Constraint r5, HelperWidget r10, ConstraintLayout.LayoutParams r11, SparseArray<ConstraintWidget> r12) {
        ConstraintSet.Layout r13 = r5.layout;
        int[] r14 = r13.mReferenceIds;
        if (r14 == null) goto L5;
        setReferencedIds(r14);
    L10:
        r10.removeAllIds();
        if (r5.layout.mReferenceIds == null) goto L19;
        int r15 = 0;
    L13:
        int[] r16 = r5.layout.mReferenceIds;
        if (r15 >= r16.length) goto L23;
        ConstraintWidget r17 = r12.get(r16[r15]);
        if (r17 == null) goto L18;
        r10.add(r17);
    L18:
        r15 = r15 + 1;
        goto L13
    L23:
        return;
    L19:
        return;
    L5:
        String r18 = r13.mReferenceIdString;
        if (r18 == null) goto L10;
        if (r18.length() <= 0) goto L10;
        ConstraintSet.Layout r19 = r5.layout;
        r19.mReferenceIds = convertReferenceString(this, r19.mReferenceIdString);
        goto L10
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r5 = this.mReferenceIds;
        if (r5 == null) goto L5;
        setIds(r5);
    L5:
        String r10 = this.mReferenceTags;
        if (r10 == null) goto L9;
        setReferenceTags(r10);
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
    }

    @Override // android.view.View
    public void onMeasure(int r5, int r10) {
        if (this.mUseViewMeasure == false) goto L5;
        super.onMeasure(r5, r10);
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    public void removeView(View r5) {
        int r10 = r5.getId();
        if (r10 != (-1)) goto L5;
        return;
    L5:
        this.mReferenceIds = null;
        int r11 = 0;
    L7:
        if (r11 >= this.mCount) goto L15;
        if (this.mIds[r11] == r10) goto L10;
        r11 = r11 + 1;
    L10:
        int r12 = this.mCount;
        if (r11 >= (r12 - 1)) goto L13;
        int[] r13 = this.mIds;
        int r14 = r11 + 1;
        r13[r11] = r13[r14];
        r11 = r14;
        goto L10
    L13:
        this.mIds[r12 - 1] = 0;
        this.mCount = r12 - 1;
    L15:
        requestLayout();
    }

    public void resolveRtl(ConstraintWidget r5, boolean r10) {
    }

    public void setIds(String r5) {
        this.mReferenceIds = r5;
        if (r5 != null) goto L5;
        return;
    L5:
        int r10 = 0;
        this.mCount = 0;
    L6:
        int r11 = r5.indexOf(44, r10);
        if (r11 == (-1)) goto L8;
        addID(r5.substring(r10, r11));
        r10 = r11 + 1;
        goto L6
    L8:
        addID(r5.substring(r10));
    }

    public void setReferenceTags(String r5) {
        this.mReferenceTags = r5;
        if (r5 != null) goto L5;
        return;
    L5:
        int r10 = 0;
        this.mCount = 0;
    L6:
        int r11 = r5.indexOf(44, r10);
        if (r11 == (-1)) goto L8;
        addTag(r5.substring(r10, r11));
        r10 = r11 + 1;
        goto L6
    L8:
        addTag(r5.substring(r10));
    }

    public void setReferencedIds(int[] r5) {
        this.mReferenceIds = null;
        int r10 = 0;
        this.mCount = 0;
    L4:
        if (r10 >= r5.length) goto L6;
        addRscID(r5[r10]);
        r10 = r10 + 1;
        goto L4
    }

    @Override // android.view.View
    public void setTag(int r5, Object r10) {
        super.setTag(r5, r10);
        if (r10 == null) goto L5;
        return;
    L5:
        if (this.mReferenceIds != null) goto L9;
        addRscID(r5);
        return;
    }

    public void updatePostConstraints(ConstraintLayout r5) {
    }

    public void updatePostLayout(ConstraintLayout r5) {
    }

    public void updatePostMeasure(ConstraintLayout r5) {
    }

    public void updatePreDraw(ConstraintLayout r5) {
    }

    public void updatePreLayout(ConstraintLayout r10) {
        if (isInEditMode() == false) goto L5;
        setIds(this.mReferenceIds);
    L5:
        Helper r5 = this.mHelperWidget;
        if (r5 != null) goto L8;
        return;
    L8:
        r5.removeAllIds();
        int r11 = 0;
    L10:
        if (r11 >= this.mCount) goto L19;
        int r12 = this.mIds[r11];
        View r13 = r10.getViewById(r12);
        if (r13 != null) goto L16;
        String r14 = this.mMap.get(Integer.valueOf(r12));
        int r15 = findId(r10, r14);
        if (r15 == 0) goto L16;
        this.mIds[r11] = r15;
        this.mMap.put(Integer.valueOf(r15), r14);
        r13 = r10.getViewById(r15);
    L16:
        if (r13 == null) goto L18;
        this.mHelperWidget.add(r10.getViewWidget(r13));
    L18:
        r11 = r11 + 1;
        goto L10
    L19:
        this.mHelperWidget.updateConstraints(r10.mLayoutWidget);
    }

    public void validateParams() {
        if (this.mHelperWidget != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r5 = getLayoutParams();
        if ((r5 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ConstraintWidget r10 = (ConstraintWidget) this.mHelperWidget;
        ((ConstraintLayout.LayoutParams) r5).widget = r10;
        return;
    }

    public ConstraintHelper(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = r5;
        init(r10);
    }

    public void applyLayoutFeatures() {
        ViewParent r5 = getParent();
        if (r5 != null) goto L5;
        return;
    L5:
        if ((r5 instanceof ConstraintLayout) == false) goto L9;
        applyLayoutFeatures((ConstraintLayout) r5);
        return;
    }

    private int findId(ConstraintLayout r10, String r11) {
        if (r11 == null) goto L21;
        if (r10 == null) goto L21;
        Resources r12 = this.myContext.getResources();
        if (r12 != null) goto L9;
        return 0;
    L9:
        int r5 = r10.getChildCount();
        int r13 = 0;
    L10:
        if (r13 >= r5) goto L21;
        View r14 = r10.getChildAt(r13);
        if (r14.getId() == (-1)) goto L20;
        String r15 = r12.getResourceEntryName(r14.getId());     // Catch: Resources.NotFoundException -> L15
    L17:
        if (r11.equals(r15) == false) goto L20;
        return r14.getId();
    L15:
        r15 = null;
    L20:
        r13 = r13 + 1;
    L21:
        return 0;
    }

    public ConstraintHelper(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = r5;
        init(r10);
    }

    public void updatePreLayout(ConstraintWidgetContainer r5, Helper r10, SparseArray<ConstraintWidget> r11) {
        r10.removeAllIds();
        int r12 = 0;
    L4:
        if (r12 >= this.mCount) goto L6;
        r10.add(r11.get(this.mIds[r12]));
        r12 = r12 + 1;
        goto L4
    }
}
