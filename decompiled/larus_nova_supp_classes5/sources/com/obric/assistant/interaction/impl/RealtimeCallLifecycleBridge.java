package com.obric.assistant.interaction.impl;

import com.larus.utils.logger.FLogger;
import com.larus.voicecall.obric.IObricRealtimeCallService;
import com.larus.voicecall.obric.ObricRealtimeCallServiceDelegate;
import com.obric.assistant.interaction.base.util.DeviceUtil;
import com.obric.assistant.state.api.multitask.ObricRealtimeCallStateProducerServiceDelegate;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/interaction/impl/RealtimeCallLifecycleBridge;", "Lcom/larus/voicecall/obric/IObricRealtimeCallService$IObricRealtimeCallActivityStateListener;", "<init>", "()V", "TAG", "", "samsungScreenFlatModel", "", "getSamsungScreenFlatModel", "()Z", "samsungScreenFlatModel$delegate", "Lkotlin/Lazy;", "useRefCount", "countRef", "Ljava/util/concurrent/atomic/AtomicInteger;", "init", "", "onEnterRealtimeCall", "botId", "conversationId", "onExitRealtimeCall", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallLifecycleBridge implements IObricRealtimeCallService.a {
    public static final RealtimeCallLifecycleBridge INSTANCE = null;
    private static final String TAG = "RealtimeCallLifecycleBridge";
    private static final AtomicInteger countRef = null;
    private static final Lazy samsungScreenFlatModel$delegate = null;
    private static final boolean useRefCount = false;

    private RealtimeCallLifecycleBridge() {
    }

    public static /* synthetic */ boolean a() {
        return samsungScreenFlatModel_delegate$lambda$0();
    }

    static {
        RealtimeCallLifecycleBridge r0 = new RealtimeCallLifecycleBridge();
        INSTANCE = r0;
        samsungScreenFlatModel$delegate = LazyKt.lazy(new g0());
        useRefCount = r0.getSamsungScreenFlatModel();
        countRef = new AtomicInteger(0);
    }

    private final boolean getSamsungScreenFlatModel() {
        return ((Boolean) samsungScreenFlatModel$delegate.getValue()).booleanValue();
    }

    private static final boolean samsungScreenFlatModel_delegate$lambda$0() {
        DeviceUtil r0 = DeviceUtil.INSTANCE;
        if (r0.isSamsung() == true) goto L5;
    L9:
        return false;
    L5:
        if (r0.isHorizontalFoldable() == false) goto L7;
    L8:
        return true;
    L7:
        if (r0.isVerticalFoldable() == false) goto L9;
        goto L8
    }

    public final void init() {
        FLogger.a.d(TAG, "init");
        ObricRealtimeCallServiceDelegate.b.l(this);
    }

    public void onEnterRealtimeCall(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "botId");
        Intrinsics.checkNotNullParameter(r7, "conversationId");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onEnterRealtimeCall ");
        r1.append(r6);
        r1.append(" cvID : ");
        r1.append(r7);
        r1.append(" countRefWay? ");
        boolean r2 = useRefCount;
        r1.append(r2);
        r1.append(" and count is ");
        AtomicInteger r3 = countRef;
        r1.append(r3.get());
        r0.d(TAG, r1.toString());
        if (r2 == true) goto L5;
    L7:
        ObricRealtimeCallStateProducerServiceDelegate.b.d(r6, r7);
        return;
    L5:
        if (r3.getAndIncrement() <= 0) goto L7;
    }

    public void onExitRealtimeCall(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "botId");
        Intrinsics.checkNotNullParameter(r7, "conversationId");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onExitRealtimeCall ");
        r1.append(r6);
        r1.append(" cvID : ");
        r1.append(r7);
        r1.append(" countRefWay? ");
        boolean r2 = useRefCount;
        r1.append(r2);
        r1.append(" and count is ");
        AtomicInteger r3 = countRef;
        r1.append(r3.get());
        r0.d(TAG, r1.toString());
        if (r2 == false) goto L10;
        int r4 = r3.decrementAndGet();
        if (r4 <= 0) goto L8;
        r0.d(TAG, "ignore exit while another realtime call page is active, count=" + r4);
        return;
    L8:
        if (r4 >= 0) goto L10;
        r3.set(0);
    L10:
        ObricRealtimeCallStateProducerServiceDelegate.b.c(r6, r7);
    }
}
