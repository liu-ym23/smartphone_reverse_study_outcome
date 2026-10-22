package com.ss.android.lark.officesdk.minutes.ui.record.widget.more;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import bwb.b;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.titlebar.MmTitleBarView2;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmMoreActionView extends FrameLayout {
    public final Function0<Unit> a;
    public final Function1<View, Unit> b;
    public final View c;
    public final View d;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ MmMoreActionView a;

        public a(MmMoreActionView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.a;
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        int r0 = b.a;
        b.g(MmUiLogScene.FOUNDATION, "onAttachedToWindow", null, null, 12);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int r0 = b.a;
        b.g(MmUiLogScene.FOUNDATION, "onDetachedFromWindow", null, null, 12);
    }

    public MmMoreActionView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, null, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmMoreActionView(Context r10, Function0<Unit> r11, Function1<? super View, Unit> r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r13, "title");
        super(r10, null);
        this.a = r11;
        this.b = r12;
        LayoutInflater.from(r10).inflate(2131564094, this, true);
        int r14 = jwb.a.a;
        Intrinsics.checkNotNullParameter(r10, "context");
        int r15 = zvb.a.b;
        setBackground(zvb.a.C0209a.d(r10, 2131102028, 12, 12, null, null, 240));
        MmTitleBarView2 r16 = (MmTitleBarView2) findViewById(2131388775);
        View r17 = findViewById(2131372263);
        this.c = r17;
        View r2 = findViewById(2131380182);
        this.d = r2;
        r16.setCloseClickListener(new a(this));
        if ((true ^ StringsKt.isBlank(r13)) == false) goto L5;
        r16.setTitle(r13);
    L5:
        Intrinsics.checkNotNullParameter(r10, "context");
        r17.setBackground(zvb.a.C0209a.c(r10, 2131102031, 14, null, null, 52));
        h.a(r2, new AnonymousClass2(this));
    }
}
