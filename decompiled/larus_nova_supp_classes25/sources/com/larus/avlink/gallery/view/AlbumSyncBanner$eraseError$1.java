package com.larus.avlink.gallery.view;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.view.AlbumSyncBanner$eraseError$1", f = "GallerySyncBanner.kt", i = {}, l = {289, 292}, m = "invokeSuspend", n = {}, s = {})
final class AlbumSyncBanner$eraseError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AlbumSyncBanner this$0;

    /* JADX INFO: renamed from: com.larus.avlink.gallery.view.AlbumSyncBanner$eraseError$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.view.AlbumSyncBanner$eraseError$1$1", f = "GallerySyncBanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AlbumSyncBanner this$0;

        public AnonymousClass1(AlbumSyncBanner r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.this$0.T5(z98.a.e.b);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AlbumSyncBanner$eraseError$1(AlbumSyncBanner r1, Continuation<? super AlbumSyncBanner$eraseError$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AlbumSyncBanner$eraseError$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L24:
        String r2 = (String) r6;
    L25:
        FLogger r7 = FLogger.a;
        r7.i("AlbumSyncBanner", "EraseError preCheckResult:" + r2);
        if (r2 != null) goto L28;
    L45:
        AlbumSyncBanner r8 = this.this$0;
        int r3 = AlbumSyncBanner.n;
        Boxing.boxBoolean(r8.b6());
    L47:
        return Unit.INSTANCE;
    L28:
        switch(r2.hashCode()) {
            case -1939875703: goto L42;
            case -1732558418: goto L38;
            case 186311881: goto L34;
            case 769870174: goto L31;
            default: goto L45;
        };
    L31:
        if (r2.equals("P2P_FAILED_DUE_TO_WIFI_DISABLED") == false) goto L45;
        r7.i("AlbumSyncBanner", "EraseError trigger: WifiDisabled");
        this.this$0.T5(z98.a.m.b);
        goto L47
    L34:
        if (r2.equals("P2P_FAILED_DUE_TO_GPS_CLOSED") == false) goto L45;
        r7.i("AlbumSyncBanner", "EraseError trigger: GpsDisabled");
        this.this$0.T5(z98.a.b.b);
        goto L47
    L38:
        if (r2.equals("P2P_FAILED_DUE_TO_VPN_ENABLED") == false) goto L45;
        r7.i("AlbumSyncBanner", "EraseError trigger: VpnDetected");
        this.this$0.T5(z98.a.k.b);
        goto L47
    L42:
        if (r2.equals("P2P_FAILED_DUE_TO_HOTSPOT_ENABLED") == false) goto L45;
        r7.i("AlbumSyncBanner", "EraseError trigger: ApDetected");
        this.this$0.T5(z98.a.C0098a.b);
        goto L47
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L16:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r6);
        r2 = null;
        if (com.larus.avlink.gallery.f.a() == false) goto L17;
        FLogger.a.i("AlbumSyncBanner", "EraseError trigger: LowBattery");
        MainCoroutineDispatcher r9 = Dispatchers.getMain();
        AnonymousClass1 r4 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (BuildersKt.withContext(r9, r4, this) != r0) goto L16;
        return r0;
    L17:
        IDoraService r10 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r10 == null) goto L25;
        IDoraService.j r11 = r10.S();
        if (r11 == null) goto L25;
        this.label = 2;
        r6 = r11.g();
        if (r6 != r0) goto L24;
        return r0;
    }
}
