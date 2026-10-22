package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.listener.IDownloadProviderEffectListListener;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.ProviderEffect;
import com.ss.ugc.effectplatform.model.net.GifProviderEffectListResponse;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q0 implements hlc.b {
    public final List<ProviderEffect> a;
    public final List<ProviderEffect> b;
    public final int c;
    public final /* synthetic */ r0 d;
    public final /* synthetic */ GifProviderEffectListResponse e;
    public final /* synthetic */ List f;

    @Override // hlc.b
    public final void onProgress(ProviderEffect r1, int r2, long r3) {
    }

    public final void a() {
        if (((ArrayList) this.b).size() <= 0) goto L11;
        r0 r0 = this.d;
        GifProviderEffectListResponse r1 = this.e;
        List<ProviderEffect> r2 = this.a;
        List<ProviderEffect> r3 = this.b;
        ExceptionResult r4 = new ExceptionResult(1);
        IEffectPlatformBaseListener r5 = r0.n.N.a(r0.o);
        if ((r5 instanceof IDownloadProviderEffectListListener) == false) goto L7;
        ((IDownloadProviderEffectListListener) r5).onDownloadFailed(r2, r3, r4);
    L9:
        r0.n.N.c(r0.o);
        return;
    L7:
        if (r5 == null) goto L9;
        r5.onFail(r1, r4);
        goto L9
    L11:
        r0 r6 = this.d;
        GifProviderEffectListResponse r7 = this.e;
        List<? extends ProviderEffect> r8 = this.f;
        IEffectPlatformBaseListener r9 = r6.n.N.a(r6.o);
        if ((r9 instanceof IDownloadProviderEffectListListener) == false) goto L14;
        ((IDownloadProviderEffectListListener) r9).onDownloadSuccess(r8);
    L16:
        r6.n.N.c(r6.o);
        return;
    L14:
        if (r9 == null) goto L16;
        r9.onSuccess(r7);
        goto L16
    }

    public final void onSuccess(Object r2) {
        ArrayList r0 = (ArrayList) this.a;
        r0.add((ProviderEffect) r2);
        if ((((ArrayList) this.a).size() + ((ArrayList) this.b).size()) != this.c) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L9;
        a();
        return;
    L9:
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final void onFail(Object r1, ExceptionResult r2) {
        ArrayList r3 = (ArrayList) this.b;
        r3.add((ProviderEffect) r1);
        if ((((ArrayList) this.a).size() + ((ArrayList) this.b).size()) != this.c) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L9;
        a();
        return;
    L9:
        return;
    L5:
        r4 = false;
        goto L6
    }

    public q0(r0 r1, GifProviderEffectListResponse r2, List r3) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = r3.size();
    }
}
