package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/core/widget/ECStatusView;", "Landroid/widget/FrameLayout;", "", com.bytedance.android.ec.core.event.a.KEY_STATUS, "", "setStatus", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStatusView extends FrameLayout {
    public final oj.b a;

    public static final class a {
    }

    static {
    }

    public ECStatusView(Context r10) {
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public ECStatusView(Context r10, AttributeSet r11) {
        this(r10, r11, 4, 0);
    }

    public final void c() {
        setVisibility(0);
        oj.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final void a() {
        setVisibility(8);
        oj.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public final void setStatus(int r10) {
        oj.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.setECStatus(r10);
        return;
    }

    public ECStatusView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        oj.b r13 = com.bytedance.android.ec.sdk.helper.i.a.d(r10);
        this.a = r13;
        if ((r13 instanceof View) == true) goto L5;
        r13 = null;
    L5:
        View r14 = (View) r13;
        if (r14 == null) goto L8;
        addView(r14, new FrameLayout.LayoutParams(-1, -1));
        return;
    L8:
        setVisibility(8);
    }

    public final void b(Context r10, View r11, View r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        oj.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.c(r10, r11, r12);
        return;
    }

    public /* synthetic */ ECStatusView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
