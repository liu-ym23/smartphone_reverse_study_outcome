package com.larus.av_call.view;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.av_call.databinding.LarusLayoutRealtimeCallBottomNewBinding;
import com.larus.av_call.util.RealtimeBottomMoreBtn;
import com.larus.common_ui.widget.UrlSpanTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b1 implements c {
    public final /* synthetic */ LarusLayoutRealtimeCallBottomNewBinding a;
    public final /* synthetic */ VoiceCallBottomLayout b;

    @Override // com.larus.av_call.view.c
    public final RealtimeBottomMoreBtn a() {
        return null;
    }

    @Override // com.larus.av_call.view.c
    public final View b() {
        return null;
    }

    @Override // com.larus.av_call.view.c
    public final AppCompatImageView d() {
        return null;
    }

    @Override // com.larus.av_call.view.c
    public final View e() {
        return null;
    }

    @Override // com.larus.av_call.view.c
    public final b f() {
        return null;
    }

    @Override // com.larus.av_call.view.c
    public final View h() {
        return null;
    }

    @Override // com.larus.av_call.view.c
    public final AppCompatImageView r() {
        return null;
    }

    @Override // com.larus.av_call.view.c
    public final LinearLayout c() {
        return this.a.i;
    }

    @Override // com.larus.av_call.view.c
    public final ProgressBar g() {
        return this.a.e;
    }

    @Override // com.larus.av_call.view.c
    public final RealtimeCallSuggestView i() {
        return this.a.h;
    }

    @Override // com.larus.av_call.view.c
    public final ConstraintLayout j() {
        return this.a.k;
    }

    @Override // com.larus.av_call.view.c
    public final View k() {
        return this.a.f;
    }

    @Override // com.larus.av_call.view.c
    public final ConstraintLayout l() {
        return this.a.k;
    }

    @Override // com.larus.av_call.view.c
    public final View m() {
        return this.a.j;
    }

    @Override // com.larus.av_call.view.c
    public final UrlSpanTextView n() {
        return this.a.l;
    }

    @Override // com.larus.av_call.view.c
    public final TextView o() {
        return this.a.c;
    }

    @Override // com.larus.av_call.view.c
    public final com.larus.common_ui.view.u p() {
        h88.a r0 = this.b.g;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        LarusLayoutRealtimeCallBottomNewBinding r2 = this.a;
        if (r1 == false) goto L11;
        return r2.b;
    L11:
        return r2.g;
    L5:
        if (r0.k0 != true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.larus.av_call.view.c
    public final AppCompatImageView q() {
        return this.a.d;
    }

    public b1(LarusLayoutRealtimeCallBottomNewBinding r1, VoiceCallBottomLayout r2) {
        this.a = r1;
        this.b = r2;
    }
}
