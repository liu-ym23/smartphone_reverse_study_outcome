package com.bytedance.ies.bullet.pool;

import android.net.Uri;
import android.os.Handler;
import com.bytedance.android.anniex.scene.core.i;
import com.bytedance.forest.utils.m;
import com.bytedance.ies.bullet.service.base.PoolResult;
import com.bytedance.ies.bullet.service.base.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f5802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f5803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f5804c;
    public final /* synthetic */ Ref.LongRef d;
    public final /* synthetic */ String e;

    public c(k r5, Uri r10, d r11, Ref.LongRef r12, String r13) {
        this.f5802a = r5;
        this.f5803b = r10;
        this.f5804c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // com.bytedance.ies.bullet.service.base.k
    public final void c(PoolResult r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "result");
        this.f5802a.c(r5, r10);
        d r11 = this.f5804c;
        int r12 = ((m) r11.f5806b.f5817a.f22361b).size();
        wn.f.c(this.f5803b, "load_failed", r12, r10, r11.f5805a);
    }

    @Override // com.bytedance.ies.bullet.service.base.k
    public final void onSuccess(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        this.f5802a.onSuccess(r10);
        d r11 = this.f5804c;
        int r5 = ((m) r11.f5806b.f5817a.f22361b).size();
        Uri r12 = this.f5803b;
        wn.f.c(r12, "load_success", r5, null, r11.f5805a);
        Ref.LongRef r13 = this.d;
        if (r13.element <= 0) goto L6;
        ((Handler) r11.e.getValue()).postDelayed(new i(r11, r12, this.e, 8), r13.element);
        return;
    }
}
