package com.larus.avlink.gallery.silent;

import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.silent.SilentSyncManager$init$linkListener$1$onDoraLinkStateChanged$1", f = "SilentSyncManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SilentSyncManager$init$linkListener$1$onDoraLinkStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $state;
    int label;

    public SilentSyncManager$init$linkListener$1$onDoraLinkStateChanged$1(int r1, Continuation<? super SilentSyncManager$init$linkListener$1$onDoraLinkStateChanged$1> r2) {
        this.$state = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SilentSyncManager$init$linkListener$1$onDoraLinkStateChanged$1(this.$state, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L40;
        ResultKt.throwOnFailure(r8);
        boolean r1 = false;
        if (this.$state != 2) goto L7;
        boolean r9 = true;
    L9:
        if (r9 == false) goto L36;
        FLogger r10 = FLogger.a;
        r10.i("SilentSyncManager", "DoraLink connected, taking silent trans state");
        Lazy r3 = com.larus.avlink.b.a;
        if (((Keva) r3.getValue()).getBoolean("album_silent_sync_default_on_applied", false) == true) goto L31;
        r10.i("SilentSyncManager", "DoraLink first Connection, applying silent trans default value");
        Job r4 = SilentSyncManager.a;
        if (Build.VERSION.SDK_INT < 33) goto L18;
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.NEARBY_WIFI_DEVICES") == 0) goto L19;
    L20:
        if (r1 == false) goto L30;
        r10.i("SilentSyncManager", "DoraLink first Connection, has location permission");
        IDoraService r2 = SilentSyncManager.c;
        if (r2 == null) goto L26;
        DeviceService r5 = r2.device();
        if (r5 == null) goto L26;
        Boolean r6 = Boxing.boxBoolean(r5.I0());
    L28:
        if (Intrinsics.areEqual(r6, Boxing.boxBoolean(true)) == false) goto L31;
        ((Keva) r3.getValue()).storeBoolean("album_silent_sync_default_on_applied", true);
        r10.i("SilentSyncManager", "DoraLink first Connection, silent trans switch on applied");
    L26:
        r6 = null;
        goto L28
    L30:
        ((Keva) r3.getValue()).storeBoolean("album_silent_sync_default_on_applied", true);
        r10.i("SilentSyncManager", "DoraLink first Connection, no location permission");
    L19:
        r1 = true;
        goto L20
    L18:
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), "android.permission.ACCESS_FINE_LOCATION") != 0) goto L20;
    L31:
        IDoraService r11 = SilentSyncManager.c;
        if (r11 == null) goto L38;
        DeviceService r12 = r11.device();
        if (r12 == null) goto L38;
        r12.M0();
    L38:
        return Unit.INSTANCE;
    L36:
        FLogger.a.i("SilentSyncManager", "DoraLink disconnected, cancelling auto sync");
        Job r13 = SilentSyncManager.a;
        SilentSyncManager.d("DoraLink disconnected");
        goto L38
    L7:
        r9 = false;
        goto L9
    L40:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
