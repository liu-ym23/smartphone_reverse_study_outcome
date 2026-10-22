package com.obric.assistant.oneshot.impl;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.oneshot.api.IOneshotService;
import com.obric.assistant.spi.wakeup.IObricOneshotService;
import kfa.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\u001b\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c2\u0006\u0010\u001d\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0010H\u0016J\u0012\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010%\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010 H\u0016J&\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0*H\u0016J\b\u0010+\u001a\u00020\u000eH\u0016J\u0012\u0010,\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010 H\u0016J\b\u0010-\u001a\u00020\u000eH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006."}, d2 = {"Lcom/obric/assistant/oneshot/impl/ObricOneshotServiceImpl;", "Lcom/obric/assistant/spi/wakeup/IObricOneshotService;", "<init>", "()V", "service", "Lcom/obric/assistant/oneshot/api/IOneshotService;", "getService", "()Lcom/obric/assistant/oneshot/api/IOneshotService;", "service$delegate", "Lkotlin/Lazy;", "isSupportOneshotQuery", "", "isCurrentSessionUsingOneshot", "setOneshotParams", "", "sessionId", "", "keywords", "", "offsetTime", "", "setBackTraceParams", "historyLengthMs", "wakeupTimeStamp", "getBackTraceHistoryMs", "getWakeupTimeStamp", "clearOneshotParam", "getOneshotParam", "T", "name", "(Ljava/lang/String;)Ljava/lang/Object;", "getCachedAudioRecorder", "Landroid/media/AudioRecord;", "mono", "bufSize", "isCachedAudioRecorder", "record", "removeFromCache", "addToCache", "recorder", "cached", WindowEvent.Params.TRIGGER, "Lkotlin/Function0;", "onAsrInfoUpdate", "setAudioRecord", "clearAudioRecord", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricOneshotServiceImpl implements IObricOneshotService {
    public final Lazy a;

    public final IOneshotService j() {
        return (IOneshotService) this.a.getValue();
    }

    public ObricOneshotServiceImpl() {
        this.a = LazyKt.lazy(new a());
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final boolean a() {
        IOneshotService r0 = j();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final boolean c() {
        IOneshotService r0 = j();
        if (r0 == null) goto L5;
        r0.c();
        return true;
    L5:
        return false;
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final long d() {
        IOneshotService r0 = j();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.d();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final void e() {
        IOneshotService r0 = j();
        if (r0 == null) goto L6;
        r0.e();
        return;
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final void g() {
        IOneshotService r0 = j();
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final long h() {
        IOneshotService r0 = j();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.h();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final <T> T f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        IOneshotService r0 = j();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.f(r2);
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final void b(long r2, long r4) {
        IOneshotService r0 = j();
        if (r0 == null) goto L6;
        r0.b(r2, r4);
        return;
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final void i(int r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "keywords");
        IOneshotService r0 = j();
        if (r0 == null) goto L6;
        r0.i(r2, r3, r4);
        return;
    }
}
