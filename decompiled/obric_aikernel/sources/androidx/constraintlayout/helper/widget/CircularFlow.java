package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class CircularFlow extends VirtualLayout {
    private static float DEFAULT_ANGLE = 0.0f;
    private static int DEFAULT_RADIUS = 0;
    private static final String TAG = "CircularFlow";
    private float[] mAngles;
    ConstraintLayout mContainer;
    private int mCountAngle;
    private int mCountRadius;
    private int[] mRadius;
    private String mReferenceAngles;
    private Float mReferenceDefaultAngle;
    private Integer mReferenceDefaultRadius;
    private String mReferenceRadius;
    int mViewCenter;

    static {
    }

    public CircularFlow(Context r10) {
        super(r10);
    }

    public CircularFlow(Context r10, AttributeSet r11) {
        super(r10, r11);
    }

    public CircularFlow(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }

    private void addAngle(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() != 0) goto L7;
        return;
    L7:
        if (this.myContext != null) goto L9;
        return;
    L9:
        float[] r11 = this.mAngles;
        if (r11 != null) goto L13;
        return;
    L13:
        if ((this.mCountAngle + 1) <= r11.length) goto L15;
        this.mAngles = Arrays.copyOf(r11, r11.length + 1);
    L15:
        this.mAngles[this.mCountAngle] = Integer.parseInt(r10);
        this.mCountAngle++;
    }

    private void addRadius(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() != 0) goto L7;
        return;
    L7:
        if (this.myContext != null) goto L9;
        return;
    L9:
        int[] r11 = this.mRadius;
        if (r11 != null) goto L13;
        return;
    L13:
        if ((this.mCountRadius + 1) <= r11.length) goto L15;
        this.mRadius = Arrays.copyOf(r11, r11.length + 1);
    L15:
        this.mRadius[this.mCountRadius] = (int) (Integer.parseInt(r10) * this.myContext.getResources().getDisplayMetrics().density);
        this.mCountRadius++;
    }

    private void anchorReferences() {
        this.mContainer = (ConstraintLayout) getParent();
        int r10 = 0;
    L4:
        if (r10 >= this.mCount) goto L38;
        View r11 = this.mContainer.getViewById(this.mIds[r10]);
        if (r11 == null) goto L37;
        int r12 = DEFAULT_RADIUS;
        float r13 = DEFAULT_ANGLE;
        int[] r14 = this.mRadius;
        if (r14 != null) goto L11;
    L13:
        Integer r15 = this.mReferenceDefaultRadius;
        if (r15 != null) goto L16;
    L21:
        Log.e(TAG, "Added radius to view with id: " + this.mMap.get(Integer.valueOf(r11.getId())));
    L22:
        float[] r16 = this.mAngles;
        if (r16 != null) goto L25;
    L27:
        Float r17 = this.mReferenceDefaultAngle;
        if (r17 != null) goto L30;
    L35:
        Log.e(TAG, "Added angle to view with id: " + this.mMap.get(Integer.valueOf(r11.getId())));
    L36:
        ConstraintLayout.LayoutParams r18 = (ConstraintLayout.LayoutParams) r11.getLayoutParams();
        r18.circleAngle = r13;
        r18.circleConstraint = this.mViewCenter;
        r18.circleRadius = r12;
        r11.setLayoutParams(r18);
        goto L37
    L30:
        if (r17.floatValue() == (-1.0f)) goto L35;
        this.mCountAngle++;
        if (this.mAngles != null) goto L34;
        this.mAngles = new float[1];
    L34:
        float[] r19 = getAngles();
        this.mAngles = r19;
        r19[this.mCountAngle - 1] = r13;
        goto L36
    L25:
        if (r10 >= r16.length) goto L27;
        r13 = r16[r10];
        goto L36
    L16:
        if (r15.intValue() == (-1)) goto L21;
        this.mCountRadius++;
        if (this.mRadius != null) goto L20;
        this.mRadius = new int[1];
    L20:
        int[] r20 = getRadius();
        this.mRadius = r20;
        r20[this.mCountRadius - 1] = r12;
        goto L22
    L11:
        if (r10 >= r14.length) goto L13;
        r12 = r14[r10];
    L37:
        r10 = r10 + 1;
        goto L4
    L38:
        applyLayoutFeatures();
    }

    private float[] removeAngle(float[] r10, int r11) {
        if (r10 == null) goto L9;
        if (r11 < 0) goto L9;
        if (r11 >= this.mCountAngle) goto L9;
        return removeElementFromArray(r10, r11);
    L9:
        return r10;
    }

    public static float[] removeElementFromArray(float[] r10, int r11) {
        float[] r12 = new float[r10.length - 1];
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r10.length) goto L9;
        if (r13 == r11) goto L8;
        r12[r14] = r10[r13];
        r14 = r14 + 1;
    L8:
        r13 = r13 + 1;
        goto L4
    L9:
        return r12;
    }

    public static int[] removeElementFromArray(int[] r10, int r11) {
        int[] r12 = new int[r10.length - 1];
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r13 >= r10.length) goto L9;
        if (r13 == r11) goto L8;
        r12[r14] = r10[r13];
        r14 = r14 + 1;
    L8:
        r13 = r13 + 1;
        goto L4
    L9:
        return r12;
    }

    private int[] removeRadius(int[] r10, int r11) {
        if (r10 == null) goto L9;
        if (r11 < 0) goto L9;
        if (r11 >= this.mCountRadius) goto L9;
        return removeElementFromArray(r10, r11);
    L9:
        return r10;
    }

    private void setAngles(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r11 = 0;
        this.mCountAngle = 0;
    L5:
        int r12 = r10.indexOf(44, r11);
        if (r12 == (-1)) goto L7;
        addAngle(r10.substring(r11, r12).trim());
        r11 = r12 + 1;
        goto L5
    L7:
        addAngle(r10.substring(r11).trim());
    }

    private void setRadius(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r11 = 0;
        this.mCountRadius = 0;
    L5:
        int r12 = r10.indexOf(44, r11);
        if (r12 == (-1)) goto L7;
        addRadius(r10.substring(r11, r12).trim());
        r11 = r12 + 1;
        goto L5
    L7:
        addRadius(r10.substring(r11).trim());
    }

    public void addViewToCircularFlow(View r10, int r11, float r12) {
        if (containsId(r10.getId()) == false) goto L5;
        return;
    L5:
        addView(r10);
        this.mCountAngle++;
        float[] r13 = getAngles();
        this.mAngles = r13;
        r13[this.mCountAngle - 1] = r12;
        this.mCountRadius++;
        int[] r14 = getRadius();
        this.mRadius = r14;
        r14[this.mCountRadius - 1] = (int) (r11 * this.myContext.getResources().getDisplayMetrics().density);
        anchorReferences();
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.mAngles, this.mCountAngle);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.mRadius, this.mCountRadius);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet r10) {
        super.init(r10);
        if (r10 == null) goto L31;
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R.styleable.ConstraintLayout_Layout);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L22;
        int r14 = r11.getIndex(r13);
        if (r14 != R.styleable.ConstraintLayout_Layout_circularflow_viewCenter) goto L10;
        this.mViewCenter = r11.getResourceId(r14, 0);
    L21:
        r13 = r13 + 1;
        goto L5
    L10:
        if (r14 != R.styleable.ConstraintLayout_Layout_circularflow_angles) goto L13;
        String r15 = r11.getString(r14);
        this.mReferenceAngles = r15;
        setAngles(r15);
        goto L21
    L13:
        if (r14 != R.styleable.ConstraintLayout_Layout_circularflow_radiusInDP) goto L16;
        String r16 = r11.getString(r14);
        this.mReferenceRadius = r16;
        setRadius(r16);
        goto L21
    L16:
        if (r14 != R.styleable.ConstraintLayout_Layout_circularflow_defaultAngle) goto L19;
        Float r17 = Float.valueOf(r11.getFloat(r14, DEFAULT_ANGLE));
        this.mReferenceDefaultAngle = r17;
        setDefaultAngle(r17.floatValue());
        goto L21
    L19:
        if (r14 != R.styleable.ConstraintLayout_Layout_circularflow_defaultRadius) goto L21;
        Integer r18 = Integer.valueOf(r11.getDimensionPixelSize(r14, DEFAULT_RADIUS));
        this.mReferenceDefaultRadius = r18;
        setDefaultRadius(r18.intValue());
        goto L21
    L22:
        r11.recycle();
        return;
    }

    public boolean isUpdatable(View r10) {
        if (containsId(r10.getId()) == true) goto L6;
        return false;
    L6:
        if (indexFromId(r10.getId()) == (-1)) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String r10 = this.mReferenceAngles;
        if (r10 == null) goto L5;
        this.mAngles = new float[1];
        setAngles(r10);
    L5:
        String r11 = this.mReferenceRadius;
        if (r11 == null) goto L8;
        this.mRadius = new int[1];
        setRadius(r11);
    L8:
        Float r12 = this.mReferenceDefaultAngle;
        if (r12 == null) goto L11;
        setDefaultAngle(r12.floatValue());
    L11:
        Integer r13 = this.mReferenceDefaultRadius;
        if (r13 == null) goto L14;
        setDefaultRadius(r13.intValue());
    L14:
        anchorReferences();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public int removeView(View r10) {
        int r11 = super.removeView(r10);
        if (r11 != (-1)) goto L5;
        return r11;
    L5:
        ConstraintSet r12 = new ConstraintSet();
        r12.clone(this.mContainer);
        r12.clear(r10.getId(), 8);
        r12.applyTo(this.mContainer);
        float[] r13 = this.mAngles;
        if (r11 >= r13.length) goto L8;
        this.mAngles = removeAngle(r13, r11);
        this.mCountAngle--;
    L8:
        int[] r14 = this.mRadius;
        if (r11 >= r14.length) goto L11;
        this.mRadius = removeRadius(r14, r11);
        this.mCountRadius--;
    L11:
        anchorReferences();
        return r11;
    }

    public void setDefaultAngle(float r10) {
        DEFAULT_ANGLE = r10;
    }

    public void setDefaultRadius(int r10) {
        DEFAULT_RADIUS = r10;
    }

    public void updateAngle(View r10, float r11) {
        if (isUpdatable(r10) == true) goto L6;
        Log.e(TAG, "It was not possible to update angle to view with id: " + r10.getId());
        return;
    L6:
        int r12 = indexFromId(r10.getId());
        if (r12 <= this.mAngles.length) goto L9;
        return;
    L9:
        float[] r13 = getAngles();
        this.mAngles = r13;
        r13[r12] = r11;
        anchorReferences();
    }

    public void updateRadius(View r10, int r11) {
        if (isUpdatable(r10) == true) goto L6;
        Log.e(TAG, "It was not possible to update radius to view with id: " + r10.getId());
        return;
    L6:
        int r12 = indexFromId(r10.getId());
        if (r12 <= this.mRadius.length) goto L9;
        return;
    L9:
        int[] r13 = getRadius();
        this.mRadius = r13;
        r13[r12] = (int) (r11 * this.myContext.getResources().getDisplayMetrics().density);
        anchorReferences();
    }

    public void updateReference(View r10, int r11, float r12) {
        if (isUpdatable(r10) == true) goto L6;
        Log.e(TAG, "It was not possible to update radius and angle to view with id: " + r10.getId());
        return;
    L6:
        int r13 = indexFromId(r10.getId());
        if (getAngles().length <= r13) goto L10;
        float[] r14 = getAngles();
        this.mAngles = r14;
        r14[r13] = r12;
    L10:
        if (getRadius().length <= r13) goto L12;
        int[] r15 = getRadius();
        this.mRadius = r15;
        r15[r13] = (int) (r11 * this.myContext.getResources().getDisplayMetrics().density);
    L12:
        anchorReferences();
    }
}
