package io.noties.markwon.ext.tables;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class e implements MovementMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MovementMethod f16495a;

    public e(MovementMethod r3) {
        this.f16495a = (MovementMethod) ZeusTransformUtils.wrapperContextForParams(r3, MovementMethod.class, "com.obric.memorydata.plugin");
    }

    public static boolean a(TextView r8, Spannable r9, MotionEvent r10) {
        Spannable r11 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r9, Spannable.class, "com.obric.memorydata.plugin");
        if (r10.getAction() == 1) goto L5;
        return false;
    L5:
        int r0 = (int) r10.getX();
        int r12 = (int) r10.getY();
        int r1 = r0 - r8.getTotalPaddingLeft();
        int r13 = r12 - r8.getTotalPaddingTop();
        int r2 = r1 + r8.getScrollX();
        int r14 = r13 + r8.getScrollY();
        Layout r4 = r8.getLayout();
        int r5 = r4.getLineForVertical(r14);
        int r6 = r4.getOffsetForHorizontal(r5, r2);
        a[] r15 = (a[]) ZeusTransformUtils.preCheckCast(r11.getSpans(r6, r6, a.class), a[].class, "com.obric.memorydata.plugin");
        if (r15.length != 0) goto L8;
        return false;
    L8:
        ClickableSpan[] r16 = (ClickableSpan[]) ZeusTransformUtils.preCheckCast(r15[0].a(r2, r14 - r4.getLineTop(r5), ClickableSpan.class), ClickableSpan[].class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L11;
    L14:
        return false;
    L11:
        if (r16.length <= 0) goto L14;
        r16[0].onClick(r8);
        return true;
    }

    @Override // android.text.method.MovementMethod
    public boolean canSelectArbitrarily() {
        return this.f16495a.canSelectArbitrarily();
    }

    @Override // android.text.method.MovementMethod
    public void initialize(TextView r3, Spannable r4) {
        Spannable r5 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        this.f16495a.initialize(r3, r5);
    }

    @Override // android.text.method.MovementMethod
    public boolean onGenericMotionEvent(TextView r3, Spannable r4, MotionEvent r5) {
        Spannable r6 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        return this.f16495a.onGenericMotionEvent(r3, r6, r5);
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyDown(TextView r3, Spannable r4, int r5, KeyEvent r6) {
        Spannable r7 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        return this.f16495a.onKeyDown(r3, r7, r5, r6);
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyOther(TextView r3, Spannable r4, KeyEvent r5) {
        Spannable r6 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        return this.f16495a.onKeyOther(r3, r6, r5);
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyUp(TextView r3, Spannable r4, int r5, KeyEvent r6) {
        Spannable r7 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        return this.f16495a.onKeyUp(r3, r7, r5, r6);
    }

    @Override // android.text.method.MovementMethod
    public void onTakeFocus(TextView r3, Spannable r4, int r5) {
        Spannable r6 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        this.f16495a.onTakeFocus(r3, r6, r5);
    }

    @Override // android.text.method.MovementMethod
    public boolean onTouchEvent(TextView r3, Spannable r4, MotionEvent r5) {
        Spannable r6 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        if (this.f16495a.onTouchEvent(r3, r6, r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (a(r3, r6, r5) == true) goto L8;
        return false;
    }

    @Override // android.text.method.MovementMethod
    public boolean onTrackballEvent(TextView r3, Spannable r4, MotionEvent r5) {
        Spannable r6 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        return this.f16495a.onTrackballEvent(r3, r6, r5);
    }
}
