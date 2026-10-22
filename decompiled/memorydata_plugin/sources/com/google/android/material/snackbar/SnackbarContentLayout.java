package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class SnackbarContentLayout extends LinearLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f4101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Button f4102b;
    private int c;

    public SnackbarContentLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public SnackbarContentLayout(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    private static void a(View r2, int r3, int r4) {
        if (ViewCompat.isPaddingRelative(r2) == false) goto L5;
        ViewCompat.setPaddingRelative(r2, ViewCompat.getPaddingStart(r2), r3, ViewCompat.getPaddingEnd(r2), r4);
        return;
    L5:
        r2.setPadding(r2.getPaddingLeft(), r3, r2.getPaddingRight(), r4);
    }

    private boolean a(int r3, int r4, int r5) {
        if (r3 == getOrientation()) goto L5;
        setOrientation(r3);
        boolean r6 = true;
    L7:
        if (this.f4101a.getPaddingTop() == r4) goto L9;
    L12:
        a(this.f4101a, r4, r5);
        return true;
    L9:
        if (this.f4101a.getPaddingBottom() != r5) goto L12;
        return r6;
    L5:
        r6 = false;
        goto L7
    }

    @Override // com.google.android.material.snackbar.a
    public void a(int r8, int r9) {
        this.f4101a.setAlpha(0.0f);
        long r3 = r9;
        long r5 = r8;
        this.f4101a.animate().alpha(1.0f).setDuration(r3).setStartDelay(r5).start();
        if (this.f4102b.getVisibility() != 0) goto L6;
        this.f4102b.setAlpha(0.0f);
        this.f4102b.animate().alpha(1.0f).setDuration(r3).setStartDelay(r5).start();
        return;
    }

    @Override // com.google.android.material.snackbar.a
    public void b(int r8, int r9) {
        this.f4101a.setAlpha(1.0f);
        long r3 = r9;
        long r5 = r8;
        this.f4101a.animate().alpha(0.0f).setDuration(r3).setStartDelay(r5).start();
        if (this.f4102b.getVisibility() != 0) goto L6;
        this.f4102b.setAlpha(1.0f);
        this.f4102b.animate().alpha(0.0f).setDuration(r3).setStartDelay(r5).start();
        return;
    }

    public Button getActionView() {
        return this.f4102b;
    }

    public TextView getMessageView() {
        return this.f4101a;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f4101a = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.snackbar_text, OaidModel.KEY_ID, "snackbar_text")), TextView.class, "com.obric.memorydata.plugin");
        this.f4102b = (Button) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.snackbar_action, OaidModel.KEY_ID, "snackbar_action")), Button.class, "com.obric.memorydata.plugin");
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r8, int r9) {
        super.onMeasure(r8, r9);
        boolean r1 = true;
        if (getOrientation() != 1) goto L5;
        return;
    L5:
        int r2 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.design_snackbar_padding_vertical_2lines, "dimen", "design_snackbar_padding_vertical_2lines"));
        int r0 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.design_snackbar_padding_vertical, "dimen", "design_snackbar_padding_vertical"));
        if (this.f4101a.getLayout().getLineCount() <= 1) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
    L17:
        if (r3 == true) goto L21;
        r2 = r0;
    L21:
        if (a(0, r2, r2) == true) goto L24;
    L23:
        r1 = false;
    L24:
        if (r1 == false) goto L27;
        super.onMeasure(r8, r9);
        return;
    L27:
        return;
    L11:
        if (this.c <= 0) goto L17;
        if (this.f4102b.getMeasuredWidth() <= this.c) goto L17;
        if (a(1, r2, r2 - r0) == false) goto L23;
    L8:
        r3 = false;
        goto L9
    }

    public void setMaxInlineActionWidth(int r1) {
        this.c = r1;
    }
}
