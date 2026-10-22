package com.larus.avlink.impl;

import com.larus.avlink.gallery.coordinator.MediaSyncCoordinator;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/larus/avlink/api/DoraOAlbumSyncState;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.impl.DoraAVLinkServiceImpl$observeAlbumSyncState$1", f = "DoraAVLinkServiceImpl.kt", i = {}, l = {1067}, m = "invokeSuspend", n = {}, s = {})
public final class DoraAVLinkServiceImpl$observeAlbumSyncState$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.k<? super w88.i>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements u98.a {
        public final /* synthetic */ kotlinx.coroutines.channels.k<w88.i> a;

        @Override // u98.a
        public final void N30() {
            w88.i r0 = DoraAVLinkServiceImpl$observeAlbumSyncState$1.invokeSuspend$albumSyncStateForCurrentProgress$default(null, 1, null);
            FLogger r1 = FLogger.a;
            StringBuilder r2 = new StringBuilder("observeAlbumSyncState showMediaDiff mapped=");
            r2.append(DoraAVLinkServiceImpl$observeAlbumSyncState$1.access$invokeSuspend$logName(r0));
            r2.append(", isSyncing=");
            MediaSyncCoordinator r3 = MediaSyncCoordinator.a;
            r2.append(MediaSyncCoordinator.i());
            r1.i("DoraAVLinkServiceImpl", r2.toString());
            this.a.trySend-JP2dKIU(r0);
        }

        @Override // u98.a
        public final void QR() {
        }

        @Override // u98.a
        public final void VD(int r1) {
        }

        @Override // u98.a
        public final void A10() {
            DoraAVLinkServiceImpl$observeAlbumSyncState$1.access$invokeSuspend$sendAlbumSyncState(this.a, "onNoSpace", new w88.i.b("no_space"));
        }

        @Override // u98.a
        public final void Ff() {
            DoraAVLinkServiceImpl$observeAlbumSyncState$1.access$invokeSuspend$sendAlbumSyncState(this.a, "onNoData", w88.i.c.a);
        }

        @Override // u98.a
        public final void Mv() {
            DoraAVLinkServiceImpl$observeAlbumSyncState$1.access$invokeSuspend$sendAlbumSyncState(this.a, "onTransferStarted", new w88.i.d(0));
        }

        @Override // u98.a
        public final void Po() {
            DoraAVLinkServiceImpl$observeAlbumSyncState$1.access$invokeSuspend$sendAlbumSyncState(this.a, "onTransferCompleted", w88.i.a.a);
        }

        @Override // u98.a
        public final void V00() {
            DoraAVLinkServiceImpl$observeAlbumSyncState$1.access$invokeSuspend$sendAlbumSyncState(this.a, "onLowPower", new w88.i.b("low_power"));
        }

        @Override // u98.a
        public final void WQ() {
            DoraAVLinkServiceImpl$observeAlbumSyncState$1.access$invokeSuspend$sendAlbumSyncState(this.a, "onRecording", new w88.i.b("recording"));
        }

        public a(kotlinx.coroutines.channels.k<? super w88.i> r1) {
            this.a = r1;
        }

        @Override // u98.a
        public final void RK(int r3) {
            this.a.trySend-JP2dKIU(new w88.i.d(r3));
        }

        @Override // u98.a
        public final void m40(z98.a r6) {
            String r1 = null;
            if ((r6 instanceof z98.a.l) == false) goto L6;
            w88.i.e r0 = w88.i.e.a;
        L45:
            FLogger r2 = FLogger.a;
            StringBuilder r3 = new StringBuilder("observeAlbumSyncState banner event=");
            r3.append(r6.a);
            r3.append(", mapped=");
            if (r0 == null) goto L48;
            r1 = DoraAVLinkServiceImpl$observeAlbumSyncState$1.access$invokeSuspend$logName(r0);
        L48:
            r3.append(r1);
            r3.append(", isSyncing=");
            MediaSyncCoordinator r7 = MediaSyncCoordinator.a;
            r3.append(MediaSyncCoordinator.i());
            r2.i("DoraAVLinkServiceImpl", r3.toString());
            if (r0 == null) goto L52;
            this.a.trySend-JP2dKIU(r0);
            return;
        L52:
            return;
        L6:
            if ((r6 instanceof z98.a.j) == false) goto L9;
            r0 = new w88.i.d(0);
            goto L45
        L9:
            if ((r6 instanceof z98.a.i) == false) goto L12;
            r0 = w88.i.a.a;
            goto L45
        L12:
            if ((r6 instanceof z98.a.e) == false) goto L15;
            r0 = new w88.i.b("low_power");
            goto L45
        L15:
            if ((r6 instanceof z98.a.g) == false) goto L18;
            r0 = new w88.i.b("recording");
            goto L45
        L18:
            if ((r6 instanceof z98.a.C0098a) == false) goto L21;
            r0 = new w88.i.b("ap_enabled");
            goto L45
        L21:
            if ((r6 instanceof z98.a.b) == false) goto L24;
            r0 = new w88.i.b("gps_disabled");
            goto L45
        L24:
            if ((r6 instanceof z98.a.m) == false) goto L27;
            r0 = new w88.i.b("wifi_disabled");
            goto L45
        L27:
            if ((r6 instanceof z98.a.k) == false) goto L30;
            r0 = new w88.i.b("vpn_enabled");
            goto L45
        L30:
            if ((r6 instanceof z98.a.n) == false) goto L33;
            r0 = new w88.i.b("wifi_error");
            goto L45
        L33:
            if ((r6 instanceof z98.a.f) == false) goto L36;
            r0 = new w88.i.b("no_permission");
            goto L45
        L36:
            if ((r6 instanceof z98.a.d) == false) goto L38;
        L44:
            r0 = DoraAVLinkServiceImpl$observeAlbumSyncState$1.invokeSuspend$albumSyncStateForCurrentProgress$default(null, 1, null);
            goto L45
        L38:
            if ((r6 instanceof z98.a.c) == true) goto L44;
            if ((r6 instanceof z98.a.h) == true) goto L44;
            throw new NoWhenBranchMatchedException();
        }

        @Override // u98.a
        public final void onError(String r3) {
            Intrinsics.checkNotNullParameter(r3, "error");
            DoraAVLinkServiceImpl$observeAlbumSyncState$1.access$invokeSuspend$sendAlbumSyncState(this.a, "onError", new w88.i.b(r3));
        }
    }

    public DoraAVLinkServiceImpl$observeAlbumSyncState$1(Continuation<? super DoraAVLinkServiceImpl$observeAlbumSyncState$1> r2) {
        super(2, r2);
    }

    public static final /* synthetic */ String access$invokeSuspend$logName(w88.i r0) {
        return a(r0);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        DoraAVLinkServiceImpl$observeAlbumSyncState$1 r0 = new DoraAVLinkServiceImpl$observeAlbumSyncState$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((kotlinx.coroutines.channels.k) r1, (Continuation) r2);
    }

    public final Object invoke(kotlinx.coroutines.channels.k<? super w88.i> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static final String a(w88.i r3) {
        if ((r3 instanceof w88.i.c) == false) goto L6;
        return "Idle";
    L6:
        if ((r3 instanceof w88.i.e) == false) goto L9;
        return "WifiConnecting";
    L9:
        if ((r3 instanceof w88.i.d) == false) goto L12;
        return "Transferring(progress=" + ((w88.i.d) r3).a + ')';
    L12:
        if ((r3 instanceof w88.i.a) == false) goto L15;
        return "Completed";
    L15:
        if ((r3 instanceof w88.i.b) == false) goto L19;
        return "Error(message=" + ((w88.i.b) r3).a + ')';
    L19:
        throw new NoWhenBranchMatchedException();
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.channels.k r6 = (kotlinx.coroutines.channels.k) this.L$0;
        final a r2 = new a(r6);
        MediaSyncCoordinator r3 = MediaSyncCoordinator.a;
        MediaSyncCoordinator.p(r2);
        Function0 r4 = new j(r2);
        this.label = 1;
        if (ProduceKt.a(r6, r4, this) != r0) goto L12;
        return r0;
    }

    public static final void access$invokeSuspend$sendAlbumSyncState(kotlinx.coroutines.channels.k r3, String r4, w88.i r5) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("observeAlbumSyncState emit source=");
        r1.append(r4);
        r1.append(", state=");
        r1.append(a(r5));
        r1.append(", isSyncing=");
        MediaSyncCoordinator r6 = MediaSyncCoordinator.a;
        r1.append(MediaSyncCoordinator.i());
        r0.i("DoraAVLinkServiceImpl", r1.toString());
        r3.trySend-JP2dKIU(r5);
    }

    public static w88.i invokeSuspend$albumSyncStateForCurrentProgress$default(w88.i r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L5;
        r0 = w88.i.c.a;
    L5:
        MediaSyncCoordinator r3 = MediaSyncCoordinator.a;
        if (MediaSyncCoordinator.i() == true) goto L8;
        return r0;
    L8:
        return new w88.i.d(0);
    }
}
