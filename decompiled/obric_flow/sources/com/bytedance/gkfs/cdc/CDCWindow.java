package com.bytedance.gkfs.cdc;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0082 ¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0082 ¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0002H\u0082 ¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/gkfs/cdc/CDCWindow;", "", "", "nCreate", "()J", "wPtr", "", "b", "nSlide8", "(JB)J", "", "nReset", "(J)V", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class CDCWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f4817a;

    static {
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L4
        System.loadLibrary("gkfs");     // Catch: Throwable -> L4
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }

    public CDCWindow() {
        this.f4817a = LazyKt.lazy(new CDCWindow$nWindow$2(this));
    }

    public static final /* synthetic */ long b(CDCWindow r5) {
        return r5.nCreate();
    }

    private final native long nCreate();

    private final native void nReset(long r5);

    private final native long nSlide8(long r5, byte r10);

    public final long a(byte r10) {
        Lazy r5 = this.f4817a;
        if (((Number) r5.getValue()).longValue() == 0) goto L7;
        return nSlide8(((Number) r5.getValue()).longValue(), r10);
    L7:
        throw new IllegalStateException("window not created, maybe libgkfs.so load failed");
    }

    public final void c() {
        Lazy r5 = this.f4817a;
        if (((Number) r5.getValue()).longValue() == 0) goto L7;
        nReset(((Number) r5.getValue()).longValue());
        return;
    L7:
        throw new IllegalStateException("window not created, maybe libgkfs.so load failed");
    }
}
