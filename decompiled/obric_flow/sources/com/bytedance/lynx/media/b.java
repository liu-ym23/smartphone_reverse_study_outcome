package com.bytedance.lynx.media;

import com.google.common.reflect.w;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.resourceprovider.LynxResourceResponse$ResponseState;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements go.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsMediaEngineView f6816b;

    public b(int r5, AbsMediaEngineView r10) {
        this.f6815a = r5;
        this.f6816b = r10;
    }

    @Override // go.a
    public final void f(w r5) {
        Intrinsics.checkNotNullParameter(r5, "response");
        TraceEvent.c("AbsMediaEngineView.genericResourceResponseCallback");
        if (this.f6815a == this.f6816b.f6804y) goto L5;
        return;
    L5:
        this.f6816b.F = true;
        if (((LynxResourceResponse$ResponseState) r5.f9377c) != LynxResourceResponse$ResponseState.f10948b) goto L13;
        CharSequence r10 = (CharSequence) r5.f9376b;
        if (r10 == null) goto L13;
        if (StringsKt.isBlank(r10) == true) goto L13;
        AbsMediaEngineView r11 = this.f6816b;
        Object r12 = r5.f9376b;
        Intrinsics.checkNotNull(r12);
        r11.j(new AbsMediaEngineView$onAsyncFetchResourceSuccess$1(r11, (String) r12), null);
    L14:
        this.f6816b.i("redirect", new HashMap());
        TraceEvent.a(0, "AbsMediaEngineView.genericResourceResponseCallback");
        return;
    L13:
        AbsMediaEngineView r13 = this.f6816b;
        r13.j(null, new AbsMediaEngineView$onAsyncFetchResourceFailure$1(r13));
        goto L14
    }
}
