package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import com.bytedance.bdinstall.oaid.OaidModel;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintHelper extends View {
    protected int mCount;
    protected Helper mHelperWidget;
    protected int[] mIds;
    protected HashMap<Integer, String> mMap;
    protected String mReferenceIds;
    protected String mReferenceTags;
    protected boolean mUseViewMeasure;
    private View[] mViews;
    protected Context myContext;

    public ConstraintHelper(Context r10) {
        super(r10);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = r10;
        init(null);
    }

    public ConstraintHelper(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = r10;
        init(r11);
    }

    public ConstraintHelper(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap();
        this.myContext = r10;
        init(r11);
    }

    private void addID(String r10) {
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
        ConstraintLayout r12 = (ConstraintLayout) getParent();
    L12:
        int r13 = findId(r11);
        if (r13 == 0) goto L15;
        this.mMap.put(Integer.valueOf(r13), r11);
        addRscID(r13);
        return;
    L15:
        Log.w("ConstraintHelper", "Could not find id of \"" + r11 + "\"");
    }

    private void addRscID(int r10) {
        if (r10 != getId()) goto L5;
        return;
    L5:
        int r11 = this.mCount + 1;
        int[] r12 = this.mIds;
        if (r11 <= r12.length) goto L8;
        this.mIds = Arrays.copyOf(r12, r12.length * 2);
    L8:
        int[] r13 = this.mIds;
        int r14 = this.mCount;
        r13[r14] = r10;
        this.mCount = r14 + 1;
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
        ConstraintLayout r12 = null;
        if ((getParent() instanceof ConstraintLayout) == false) goto L13;
        r12 = (ConstraintLayout) getParent();
    L13:
        if (r12 != null) goto L16;
        Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
        return;
    L16:
        int r13 = r12.getChildCount();
        int r14 = 0;
    L17:
        if (r14 >= r13) goto L34;
        View r15 = r12.getChildAt(r14);
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if ((r16 instanceof ConstraintLayout.LayoutParams) == false) goto L26;
        if (r11.equals(((ConstraintLayout.LayoutParams) r16).constraintTag) == false) goto L26;
        if (r15.getId() != (-1)) goto L25;
        Log.w("ConstraintHelper", "to use ConstraintTag view " + r15.getClass().getSimpleName() + " must have an ID");
        goto L26
    L25:
        addRscID(r15.getId());
    L26:
        r14 = r14 + 1;
        goto L17
    }

    private int[] convertReferenceString(View r10, String r11) {
        String[] r12 = r11.split(",");
        r10.getContext();
        int[] r13 = new int[r12.length];
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r14 >= r12.length) goto L10;
        int r16 = findId(r12[r14].trim());
        if (r16 == 0) goto L8;
        r13[r15] = r16;
        r15 = r15 + 1;
    L8:
        r14 = r14 + 1;
        goto L4
    L10:
        if (r15 != r12.length) goto L12;
        return r13;
    L12:
        return Arrays.copyOf(r13, r15);
    }

    private int findId(ConstraintLayout r10, String r11) {
        if (r11 == null) goto L20;
        if (r10 == null) goto L20;
        Resources r12 = this.myContext.getResources();
        if (r12 != null) goto L9;
        return 0;
    L9:
        int r13 = r10.getChildCount();
        int r14 = 0;
    L10:
        if (r14 >= r13) goto L20;
        View r15 = r10.getChildAt(r14);
        if (r15.getId() == (-1)) goto L19;
        String r16 = null;
        r16 = r12.getResourceEntryName(r15.getId());     // Catch: Resources.NotFoundException -> L21
    L16:
        if (r11.equals(r16) == false) goto L19;
        return r15.getId();
    L19:
        r14 = r14 + 1;
    L20:
        return 0;
    }

    private int findId(String r10) {
        if ((getParent() instanceof ConstraintLayout) == false) goto L5;
        ConstraintLayout r11 = (ConstraintLayout) getParent();
    L6:
        int r12 = 0;
        if (isInEditMode() == false) goto L12;
        if (r11 == null) goto L12;
        Object r13 = r11.getDesignInformation(0, r10);
        if ((r13 instanceof Integer) == false) goto L12;
        r12 = ((Integer) r13).intValue();
    L12:
        if (r12 != 0) goto L15;
        if (r11 == null) goto L15;
        r12 = findId(r11, r10);
    L15:
        if (r12 == 0) goto L21;
    L17:
        if (r12 == 0) goto L19;
        return r12;
    L19:
        return this.myContext.getResources().getIdentifier(r10, OaidModel.KEY_ID, this.myContext.getPackageName());
    L21:
        r12 = R.id.class.getField(r10).getInt(null);     // Catch: Exception -> L20
        goto L17
    L5:
        r11 = null;
        goto L6
    }

    public void addView(View r10) {
        if (r10 != this) goto L5;
        return;
    L5:
        if (r10.getId() != (-1)) goto L9;
        Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
        return;
    L9:
        if (r10.getParent() != null) goto L12;
        Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
        return;
    L12:
        this.mReferenceIds = null;
        addRscID(r10.getId());
        requestLayout();
    }

    protected void applyLayoutFeatures() {
        ViewParent r10 = getParent();
        if (r10 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof ConstraintLayout) == false) goto L9;
        applyLayoutFeatures((ConstraintLayout) r10);
        return;
    }

    protected void applyLayoutFeatures(ConstraintLayout r10) {
        int r11 = getVisibility();
        if (Build.VERSION.SDK_INT < 21) goto L5;
        float r12 = getElevation();
    L6:
        int r13 = 0;
    L8:
        if (r13 >= this.mCount) goto L17;
        View r14 = r10.getViewById(this.mIds[r13]);
        if (r14 == null) goto L16;
        r14.setVisibility(r11);
        if (r12 <= 0.0f) goto L16;
        if (Build.VERSION.SDK_INT < 21) goto L16;
        r14.setTranslationZ(r14.getTranslationZ() + r12);
    L16:
        r13 = r13 + 1;
        goto L8
    L17:
        return;
    L5:
        r12 = 0.0f;
        goto L6
    }

    protected void applyLayoutFeaturesInConstraintSet(ConstraintLayout r10) {
    }

    public boolean containsId(int r10) {
        int[] r11 = this.mIds;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        if (r11[r13] == r10) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L11:
        return false;
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.mIds, this.mCount);
    }

    protected View[] getViews(ConstraintLayout r10) {
        View[] r11 = this.mViews;
        if (r11 != null) goto L5;
    L6:
        this.mViews = new View[this.mCount];
    L7:
        int r12 = 0;
    L9:
        if (r12 >= this.mCount) goto L12;
        int r13 = this.mIds[r12];
        this.mViews[r12] = r10.getViewById(r13);
        r12 = r12 + 1;
        goto L9
    L12:
        return this.mViews;
    L5:
        if (r11.length == this.mCount) goto L7;
        goto L6
    }

    public int indexFromId(int r10) {
        int[] r11 = this.mIds;
        int r12 = r11.length;
        int r13 = -1;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L8;
        r13 = r13 + 1;
        if (r11[r14] == r10) goto L6;
        r14 = r14 + 1;
        goto L3
    L6:
        return r13;
    L8:
        return r13;
    }

    protected void init(AttributeSet r10) {
        if (r10 == null) goto L18;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R.styleable.ConstraintLayout_Layout);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L4:
        if (r13 >= r12) goto L12;
        int r14 = r11.getIndex(r13);
        if (r14 != R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) goto L9;
        String r15 = r11.getString(r14);
        this.mReferenceIds = r15;
        setIds(r15);
    L11:
        r13 = r13 + 1;
        goto L4
    L9:
        if (r14 != R.styleable.ConstraintLayout_Layout_constraint_referenced_tags) goto L11;
        String r16 = r11.getString(r14);
        this.mReferenceTags = r16;
        setReferenceTags(r16);
        goto L11
    L12:
        r11.recycle();
        return;
    }

    public void loadParameters(ConstraintSet.Constraint r10, HelperWidget r11, ConstraintLayout.LayoutParams r12, SparseArray<ConstraintWidget> r13) {
        ConstraintSet.Layout r14 = r10.layout;
        int[] r15 = r14.mReferenceIds;
        if (r15 == null) goto L5;
        setReferencedIds(r15);
    L11:
        if (r11 == null) goto L21;
        r11.removeAllIds();
        if (r10.layout.mReferenceIds == null) goto L25;
        int r16 = 0;
    L15:
        int[] r17 = r10.layout.mReferenceIds;
        if (r16 >= r17.length) goto L26;
        ConstraintWidget r18 = r13.get(r17[r16]);
        if (r18 == null) goto L20;
        r11.add(r18);
    L20:
        r16 = r16 + 1;
        goto L15
    L26:
        return;
    L25:
        return;
    L21:
        return;
    L5:
        String r19 = r14.mReferenceIdString;
        if (r19 == null) goto L11;
        if (r19.length() <= 0) goto L10;
        ConstraintSet.Layout r20 = r10.layout;
        r20.mReferenceIds = convertReferenceString(this, r20.mReferenceIdString);
        goto L11
    L10:
        r10.layout.mReferenceIds = null;
        goto L11
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r10 = this.mReferenceIds;
        if (r10 == null) goto L5;
        setIds(r10);
    L5:
        String r11 = this.mReferenceTags;
        if (r11 == null) goto L9;
        setReferenceTags(r11);
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
    }

    @Override // android.view.View
    protected void onMeasure(int r10, int r11) {
        if (this.mUseViewMeasure == false) goto L5;
        super.onMeasure(r10, r11);
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    public int removeView(View r10) {
        int r11 = r10.getId();
        int r12 = -1;
        if (r11 != (-1)) goto L5;
        return -1;
    L5:
        this.mReferenceIds = null;
        int r13 = 0;
    L7:
        if (r13 >= this.mCount) goto L16;
        if (this.mIds[r13] == r11) goto L10;
        r13 = r13 + 1;
        goto L7
    L10:
        int r14 = r13;
    L11:
        int r15 = this.mCount;
        if (r14 >= (r15 - 1)) goto L14;
        int[] r16 = this.mIds;
        int r17 = r14 + 1;
        r16[r14] = r16[r17];
        r14 = r17;
        goto L11
    L14:
        this.mIds[r15 - 1] = 0;
        this.mCount = r15 - 1;
        r12 = r13;
    L16:
        requestLayout();
        return r12;
    }

    public void resolveRtl(ConstraintWidget r10, boolean r11) {
    }

    protected void setIds(String r10) {
        this.mReferenceIds = r10;
        if (r10 != null) goto L5;
        return;
    L5:
        int r11 = 0;
        this.mCount = 0;
    L6:
        int r12 = r10.indexOf(44, r11);
        if (r12 == (-1)) goto L8;
        addID(r10.substring(r11, r12));
        r11 = r12 + 1;
        goto L6
    L8:
        addID(r10.substring(r11));
    }

    protected void setReferenceTags(String r10) {
        this.mReferenceTags = r10;
        if (r10 != null) goto L5;
        return;
    L5:
        int r11 = 0;
        this.mCount = 0;
    L6:
        int r12 = r10.indexOf(44, r11);
        if (r12 == (-1)) goto L8;
        addTag(r10.substring(r11, r12));
        r11 = r12 + 1;
        goto L6
    L8:
        addTag(r10.substring(r11));
    }

    public void setReferencedIds(int[] r10) {
        this.mReferenceIds = null;
        int r11 = 0;
        this.mCount = 0;
    L4:
        if (r11 >= r10.length) goto L6;
        addRscID(r10[r11]);
        r11 = r11 + 1;
        goto L4
    }

    @Override // android.view.View
    public void setTag(int r10, Object r11) {
        super.setTag(r10, r11);
        if (r11 == null) goto L5;
        return;
    L5:
        if (this.mReferenceIds != null) goto L9;
        addRscID(r10);
        return;
    }

    public void updatePostConstraints(ConstraintLayout r10) {
    }

    public void updatePostLayout(ConstraintLayout r10) {
    }

    public void updatePostMeasure(ConstraintLayout r10) {
    }

    public void updatePreDraw(ConstraintLayout r10) {
    }

    public void updatePreLayout(ConstraintWidgetContainer r10, Helper r11, SparseArray<ConstraintWidget> r12) {
        r11.removeAllIds();
        int r13 = 0;
    L4:
        if (r13 >= this.mCount) goto L6;
        r11.add(r12.get(this.mIds[r13]));
        r13 = r13 + 1;
        goto L4
    }

    public void updatePreLayout(ConstraintLayout r10) {
        if (isInEditMode() == false) goto L5;
        setIds(this.mReferenceIds);
    L5:
        Helper r11 = this.mHelperWidget;
        if (r11 != null) goto L8;
        return;
    L8:
        r11.removeAllIds();
        int r12 = 0;
    L10:
        if (r12 >= this.mCount) goto L19;
        int r13 = this.mIds[r12];
        View r14 = r10.getViewById(r13);
        if (r14 != null) goto L16;
        String r15 = this.mMap.get(Integer.valueOf(r13));
        int r16 = findId(r10, r15);
        if (r16 == 0) goto L16;
        this.mIds[r12] = r16;
        this.mMap.put(Integer.valueOf(r16), r15);
        r14 = r10.getViewById(r16);
    L16:
        if (r14 == null) goto L18;
        this.mHelperWidget.add(r10.getViewWidget(r14));
    L18:
        r12 = r12 + 1;
        goto L10
    L19:
        this.mHelperWidget.updateConstraints(r10.mLayoutWidget);
    }

    public void validateParams() {
        if (this.mHelperWidget != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r10 = getLayoutParams();
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ConstraintWidget r11 = (ConstraintWidget) this.mHelperWidget;
        ((ConstraintLayout.LayoutParams) r10).widget = r11;
        return;
    }
}
