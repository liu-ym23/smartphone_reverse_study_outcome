package com.bytedance.android.livesdk.chatroom.vs_base.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vr1.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/view/InputLinearLayout;", "Landroid/widget/LinearLayout;", "Lqq1/b;", "getKeyBoardObservable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InputLinearLayout extends LinearLayout {
    public final qq1.b a;
    public int b;
    public int c;

    public final qq1.b getKeyBoardObservable() {
        return this.a;
    }

    public InputLinearLayout(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        super.onDraw(r3);
        qq1.b r4 = this.a;
        Context r0 = getContext();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(this, "rootView");
        vr1.e r1 = r4.a;
        if (r1 == null) goto L9;
        e0 r2 = r1.a(r0, this);
        if (r2 == null) goto L10;
        r4.c(r2.a, r2.b);
        return;
    L10:
        return;
    }

    public InputLinearLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        int r0 = this.c;
        int r1 = this.b;
        if (r0 != r1) goto L10;
        qq1.b r2 = this.a;
        Context r3 = getContext();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "context");
        vr1.e r6 = r2.a;
        if (r6 == null) goto L11;
        e0 r7 = r6.b(r3, r5);
        if (r7 == null) goto L11;
        r2.c(r7.a, r7.b);
    L11:
        super.onMeasure(r4, r5);
        return;
    L10:
        this.c = r1;
        goto L11
    }

    public InputLinearLayout(Context r2, AttributeSet r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r4 == null) goto L5;
        int r5 = r4.intValue();
    L6:
        super(r2, r3, r5);
        this.a = new qq1.b(this);
        return;
    L5:
        r5 = 0;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        super.onLayout(r8, r9, r10, r11, r12);
        qq1.b r13 = this.a;
        Context r1 = getContext();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(this, "root");
        vr1.e r0 = r13.a;
        if (r0 == null) goto L9;
        e0 r14 = r0.c(r1, this, r9, r10, r11, r12);
        if (r14 == null) goto L10;
        r13.c(r14.a, r14.b);
        return;
    L10:
        return;
    }
}
