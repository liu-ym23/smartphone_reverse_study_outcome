package io.noties.markwon.c;

import android.content.Context;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lio/noties/markwon/movement/ReplacementLinkMovementMethod;", "Landroid/text/method/LinkMovementMethod;", "()V", "downTime", "", "downX", "", "downY", "handlerTouchSpans", "", "Lio/noties/markwon/movement/IHandlerTouchSpan;", "[Lio/noties/markwon/movement/IHandlerTouchSpan;", "longPressTimeout", "", "touchSlop", "initialize", "", "widget", "Landroid/widget/TextView;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "Landroid/text/Spannable;", "onTouchEvent", "", "buffer", "event", "Landroid/view/MotionEvent;", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
public final class c extends LinkMovementMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16407b;
    private float c;
    private float d;
    private long e;
    private a[] f;

    public c() {
        this.f16406a = ViewConfiguration.getLongPressTimeout();
        this.f = new a[0];
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public void initialize(TextView r3, Spannable r4) {
        Spannable r5 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r4, Spannable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "widget");
        super.initialize(r3, r5);
        ViewConfiguration r6 = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkExpressionValueIsNotNull(r6, "ViewConfiguration.get(widget.context)");
        this.f16407b = r6.getScaledTouchSlop();
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView r17, Spannable r18, MotionEvent r19) {
        Spannable r3 = (Spannable) ZeusTransformUtils.wrapperContextForParams(r18, Spannable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r17, "widget");
        Intrinsics.checkParameterIsNotNull(r3, "buffer");
        Intrinsics.checkParameterIsNotNull(r19, "event");
        if (r19.getActionMasked() != 1) goto L5;
    L8:
        float r5 = (r19.getX() - r17.getTotalPaddingLeft()) + r17.getScrollX();
        float r7 = (r19.getY() - r17.getTotalPaddingTop()) + r17.getScrollY();
        Layout r8 = r17.getLayout();
        int r9 = r8.getOffsetForHorizontal(r8.getLineForVertical((int) r7), r5);
        ClickableSpan[] r10 = (ClickableSpan[]) ZeusTransformUtils.preCheckCast(r3.getSpans(r9, r9, ClickableSpan.class), ClickableSpan[].class, "com.obric.memorydata.plugin");
        int r12 = 0;
        if (r19.getActionMasked() != 0) goto L20;
        this.c = r19.getX();
        this.d = r19.getY();
        this.e = System.currentTimeMillis();
        Object[] r6 = r3.getSpans(r9, r9, a.class);
        Intrinsics.checkExpressionValueIsNotNull(r6, "buffer.getSpans(off, off…lerTouchSpan::class.java)");
        a[] r4 = (a[]) ZeusTransformUtils.preCheckCast(r6, a[].class, "com.obric.memorydata.plugin");
        this.f = r4;
        int r0 = r4.length;
        int r11 = 0;
    L11:
        if (r11 >= r0) goto L13;
        r4[r11].a(r17);
        r11 = r11 + 1;
        goto L11
    L13:
        Intrinsics.checkExpressionValueIsNotNull(r10, "links");
        if (r10.length != 0) goto L17;
        r12 = 1;
    L17:
        if ((r12 ^ 1) == 0) goto L56;
        Selection.setSelection(r3, r3.getSpanStart(ArraysKt.first(r10)), r3.getSpanEnd(ArraysKt.first(r10)));
    L56:
        return Touch.onTouchEvent(r17, r3, r19);
    L20:
        if (r19.getActionMasked() != 1) goto L52;
        a[] r13 = this.f;
        int r14 = r13.length;
        int r15 = 0;
    L22:
        if (r15 >= r14) goto L25;
        r13[r15].b(r17);
        r15 = r15 + 1;
        goto L22
    L25:
        if (Math.abs(r19.getX() - this.c) < this.f16407b) goto L27;
    L50:
        Selection.removeSelection(r3);
        return Touch.onTouchEvent(r17, r3, r19);
    L27:
        if (Math.abs(r19.getY() - this.d) >= this.f16407b) goto L50;
        if ((System.currentTimeMillis() - this.e) >= this.f16406a) goto L50;
        Intrinsics.checkExpressionValueIsNotNull(r10, "links");
        if (r10.length != 0) goto L33;
        boolean r1 = true;
    L35:
        if ((!r1) == false) goto L50;
        float r16 = r8.getPrimaryHorizontal(r9);
        int r20 = r10.length;
    L37:
        if (r12 >= r20) goto L50;
        ClickableSpan r21 = r10[r12];
        if (r16 >= r5) goto L46;
        if (r3.getSpanEnd(r21) > r9) goto L42;
    L49:
        r12 = r12 + 1;
        goto L37
    L42:
        r21.onClick((View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.memorydata.plugin"));
        return true;
    L46:
        if (r3.getSpanStart(r21) >= r9) goto L49;
        r21.onClick((View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.memorydata.plugin"));
        return true;
    L33:
        r1 = false;
        goto L35
    L52:
        a[] r2 = this.f;
        int r22 = r2.length;
    L53:
        if (r12 >= r22) goto L56;
        r2[r12].c(r17);
        r12 = r12 + 1;
        goto L53
    L5:
        if (r19.getActionMasked() == 0) goto L8;
        if (r19.getActionMasked() != 3) goto L56;
        goto L8
    }
}
