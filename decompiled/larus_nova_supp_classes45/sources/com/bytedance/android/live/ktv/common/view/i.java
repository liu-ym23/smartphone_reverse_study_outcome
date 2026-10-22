package com.bytedance.android.live.ktv.common.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.viewmodel.OpusPreviewViewModel;
import com.bytedance.android.livesdk.ktvimpl.mv.opus.OpusPreviewDialog;
import com.bytedance.android.livesdk.message.model.od;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i extends g<od> {
    public final Function0<Unit> h;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.h.invoke();
        }
    }

    @Override // com.bytedance.android.live.ktv.common.view.g
    public final View e() {
        FrameLayout r0 = this.c;
        if (r0 != null) goto L7;
        FrameLayout r1 = new FrameLayout(getContext());
        this.c = r1;
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-1, -2);
        r2.topMargin = s1.f(10.0f);
        r2.bottomMargin = s1.f(10.0f);
        r2.leftMargin = s1.f(10.0f);
        r2.rightMargin = s1.f(10.0f);
        Unit r3 = Unit.INSTANCE;
        r1.setLayoutParams(r2);
        TextView r4 = new TextView(r1.getContext());
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-2, -2);
        r5.gravity = 19;
        r4.setLayoutParams(r5);
        r4.setText(2131918464);
        r4.setTextColor(-16777216);
        r4.setTextSize(1, 14.0f);
        r1.addView(r4);
        TextView r6 = new TextView(r1.getContext());
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-2, -2);
        r7.gravity = 21;
        r6.setLayoutParams(r7);
        r6.setText(2131918271);
        r6.setCompoundDrawablesWithIntrinsicBounds(2131252025, 0, 0, 0);
        r6.setCompoundDrawablePadding(s1.f(3.0f));
        r6.setTextColor(-16777216);
        r6.setOnClickListener(new a(this));
        r6.setTextSize(1, 15.0f);
        r1.addView(r6);
        return r1;
    L7:
        return r0;
    }

    public i(Context r2, OpusPreviewViewModel r3, OpusPreviewDialog.previewListViewHolderProvider.1 r4, com.bytedance.android.livesdk.ktvapi.model.mv.i r5, Function0 r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vm");
        Intrinsics.checkNotNullParameter(r4, "vhProvider");
        Intrinsics.checkNotNullParameter(r6, "changeMvCallback");
        super(r2, r4, r5);
        this.h = r6;
    }
}
