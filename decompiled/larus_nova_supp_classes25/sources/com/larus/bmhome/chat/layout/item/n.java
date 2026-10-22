package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n extends xc8.h {
    public final TextView p;
    public final RoundAvatarImageView q;
    public final LottieAdapterView r;
    public ViewGroup s;
    public ViewGroup t;
    public ViewGroup u;
    public final View v;

    public static final class a {
    }

    static {
    }

    public final void n() {
        FLogger.a.i("BotMakerBox", "hideAvatarLoading");
        LottieAdapterView r0 = this.r;     // Catch: Exception -> L10
        if (r0 == null) goto L6;
        r0.cancelAnimation();     // Catch: Exception -> L10
    L6:
        LottieAdapterView r1 = this.r;     // Catch: Exception -> L10
        if (r1 == null) goto L15;
        r1.setVisibility(8);     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        FLogger.a.e("BotMakerBox", "hideAvatarLoading fail e=" + e.getMessage());
    }

    public final ViewGroup getCreateContainer() {
        return this.t;
    }

    public final ViewGroup getEditContainer() {
        return this.s;
    }

    public final ViewGroup getTitleContainer() {
        return this.u;
    }

    public n(Context r6) {
        super(r6);
        ConstraintLayout.LayoutParams r2 = new ConstraintLayout.LayoutParams(getMaxWidth(), getResources().getDimensionPixelSize(v19.c.b(2130971209, null, 2131166787)));
        View r7 = LayoutInflater.from(r6).inflate(2131561849, null);
        addView(r7, r2);
        this.p = (TextView) r7.findViewById(2131380897);
        this.q = r7.findViewById(2131376287);
        this.r = r7.findViewById(2131363713);
        this.s = (ViewGroup) r7.findViewById(2131371401);
        this.t = (ViewGroup) r7.findViewById(2131368194);
        this.u = (ViewGroup) r7.findViewById(2131388843);
        this.v = r7;
    }

    public final void setCreateContainer(ViewGroup r1) {
        this.t = r1;
    }

    public final void setEditContainer(ViewGroup r1) {
        this.s = r1;
    }

    public final void setTitleContainer(ViewGroup r1) {
        this.u = r1;
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public final void l(boolean r2, boolean r3) {
        super.l(r2, r3);
        View r4 = this.v;
        if (r4 == null) goto L9;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L8;
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) r5;
        r6.width = getMaxWidth();
        r4.setLayoutParams(r6);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }
}
