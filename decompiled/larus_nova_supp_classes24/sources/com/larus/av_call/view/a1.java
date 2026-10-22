package com.larus.av_call.view;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.av_call.databinding.LarusLayoutRealtimeCallBottomNewV2Binding;
import com.larus.av_call.util.RealtimeBottomMoreBtn;
import com.larus.common_ui.widget.UrlSpanTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a1 implements c {
    public final b a;
    public final View b;
    public final View c;
    public final View d;
    public final AppCompatImageView e;
    public final RealtimeBottomMoreBtn f;
    public final /* synthetic */ LarusLayoutRealtimeCallBottomNewV2Binding g;
    public final /* synthetic */ VoiceCallBottomLayout h;

    @Override // com.larus.av_call.view.c
    public final LinearLayout c() {
        return this.g.n;
    }

    @Override // com.larus.av_call.view.c
    public final AppCompatImageView d() {
        return this.g.k;
    }

    @Override // com.larus.av_call.view.c
    public final ProgressBar g() {
        return this.g.e;
    }

    @Override // com.larus.av_call.view.c
    public final RealtimeCallSuggestView i() {
        return this.g.m;
    }

    @Override // com.larus.av_call.view.c
    public final ConstraintLayout j() {
        return this.g.v;
    }

    @Override // com.larus.av_call.view.c
    public final View k() {
        return this.g.f;
    }

    @Override // com.larus.av_call.view.c
    public final ConstraintLayout l() {
        return this.g.v;
    }

    @Override // com.larus.av_call.view.c
    public final View m() {
        return this.g.q;
    }

    @Override // com.larus.av_call.view.c
    public final UrlSpanTextView n() {
        return this.g.w;
    }

    @Override // com.larus.av_call.view.c
    public final TextView o() {
        return this.g.c;
    }

    @Override // com.larus.av_call.view.c
    public final com.larus.common_ui.view.u p() {
        h88.a r0 = this.h.g;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        LarusLayoutRealtimeCallBottomNewV2Binding r2 = this.g;
        if (r1 == false) goto L11;
        return r2.b;
    L11:
        return r2.j;
    L5:
        if (r0.k0 != true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.larus.av_call.view.c
    public final AppCompatImageView q() {
        return this.g.d;
    }

    @Override // com.larus.av_call.view.c
    public final RealtimeBottomMoreBtn a() {
        return this.f;
    }

    @Override // com.larus.av_call.view.c
    public final View b() {
        return this.d;
    }

    @Override // com.larus.av_call.view.c
    public final View e() {
        return this.c;
    }

    @Override // com.larus.av_call.view.c
    public final b f() {
        return this.a;
    }

    @Override // com.larus.av_call.view.c
    public final View h() {
        return this.b;
    }

    @Override // com.larus.av_call.view.c
    public final AppCompatImageView r() {
        return this.e;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.av_call.view.z0] */
    public a1(LarusLayoutRealtimeCallBottomNewV2Binding r5, final VoiceCallBottomLayout r6) {
        this.g = r5;
        this.h = r6;
        this.a = new b(r5.o, VoiceCallBottomLayout.Z5(r6), new z0(r6));
        this.b = r5.t;
        this.c = r5.h;
        this.d = r5.z;
        this.e = r5.x;
        this.f = r5.s;
    }
}
