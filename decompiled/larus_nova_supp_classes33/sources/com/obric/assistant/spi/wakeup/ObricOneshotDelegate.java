package com.obric.assistant.spi.wakeup;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0096\u0001J\t\u0010\f\u001a\u00020\u0005H\u0096\u0001J\t\u0010\r\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\"\u0010\u0014\u001a\u0002H\u0015\"\n\b\u0000\u0010\u0015*\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0096\u0001¢\u0006\u0002\u0010\u0019J\t\u0010\u001a\u001a\u00020\u000fH\u0096\u0001J\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\u001d\u001a\u00020\tH\u0096\u0001J\t\u0010\u001e\u001a\u00020\tH\u0096\u0001J\t\u0010\u001f\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010 \u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0013\u0010!\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0019\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH\u0096\u0001J!\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u000fH\u0096\u0001¨\u0006)"}, d2 = {"Lcom/obric/assistant/spi/wakeup/ObricOneshotDelegate;", "Lcom/obric/assistant/spi/wakeup/IObricOneshotService;", "<init>", "()V", "addToCache", "", "recorder", "Landroid/media/AudioRecord;", "cached", "", WindowEvent.Params.TRIGGER, "Lkotlin/Function0;", "clearAudioRecord", "clearOneshotParam", "getBackTraceHistoryMs", "", "getCachedAudioRecorder", "mono", "bufSize", "", "getOneshotParam", "T", "", "name", "", "(Ljava/lang/String;)Ljava/lang/Object;", "getWakeupTimeStamp", "isCachedAudioRecorder", "record", "isCurrentSessionUsingOneshot", "isSupportOneshotQuery", "onAsrInfoUpdate", "removeFromCache", "setAudioRecord", "setBackTraceParams", "historyLengthMs", "wakeupTimeStamp", "setOneshotParams", "sessionId", "keywords", "offsetTime", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricOneshotDelegate implements IObricOneshotService {
    public static final ObricOneshotDelegate b = null;
    public final /* synthetic */ IObricOneshotService a;

    static {
        b = new ObricOneshotDelegate();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final boolean a() {
        return this.a.a();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final void b(long r2, long r4) {
        this.a.b(r2, r4);
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final boolean c() {
        return this.a.c();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final long d() {
        return this.a.d();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final void e() {
        this.a.e();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final <T> T f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return (T) this.a.f(r2);
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final void g() {
        this.a.g();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final long h() {
        return this.a.h();
    }

    @Override // com.obric.assistant.spi.wakeup.IObricOneshotService
    public final void i(int r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "keywords");
        this.a.i(r2, r3, r4);
    }

    private ObricOneshotDelegate() {
        IObricOneshotService r0 = (IObricOneshotService) ServiceManager.get().getService(IObricOneshotService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultOneshotServiceImpl();
    L5:
        this.a = r0;
    }
}
