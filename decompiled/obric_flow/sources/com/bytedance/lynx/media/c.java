package com.bytedance.lynx.media;

import com.lynx.tasm.base.TraceEvent;
import java.util.HashMap;
import ko.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsMediaEngineView f6818b;

    public c(int r5, AbsMediaEngineView r10) {
        this.f6817a = r5;
        this.f6818b = r10;
    }

    @Override // ko.o
    public final void a(wc.f r5) {
        Intrinsics.checkNotNullParameter(r5, "response");
        TraceEvent.c("AbsMediaEngineView.ResourceResponseCallback");
        if (this.f6817a == this.f6818b.f6804y) goto L5;
        return;
    L5:
        this.f6818b.F = true;
        AbsMediaEngineView r10 = this.f6818b;
        r10.j(null, new AbsMediaEngineView$onAsyncFetchResourceFailure$1(r10));
        this.f6818b.i("redirect", new HashMap());
        TraceEvent.a(0, "AbsMediaEngineView.ResourceResponseCallback");
    }
}
