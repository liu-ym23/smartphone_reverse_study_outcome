package com.obric.assistant.dora;

import android.os.Binder;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import com.bytedance.dora.annotation.ProductNameType;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.keepalive.ObricKeepAliveLevelController;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0016¨\u0006\u001b"}, d2 = {"com/obric/assistant/dora/DoraPrivateProtocolService$binder$1", "Lcom/obric/assistant/dora/IDoraPrivateProtocolService$Stub;", "onTransact", "", "code", "", "data", "Landroid/os/Parcel;", "reply", "flags", "registerCallback", "", "callback", "Lcom/obric/assistant/dora/IDoraPrivateProtocolCallback;", "registerCallbackWithExtra", "extra", "", "registerCallbackInternal", "unregisterCallback", "getConnectionState", "getCurrentDeviceInfo", "Lcom/obric/assistant/dora/DoraDeviceInfo;", "syncConnectionState", "state", "deviceInfo", "syncBatteryChanged", "syncChargeStateChanged", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class DoraPrivateProtocolService$binder$1 extends IDoraPrivateProtocolService.Stub {
    final /* synthetic */ DoraPrivateProtocolService this$0;

    public static /* synthetic */ boolean a(IDoraPrivateProtocolCallback r0, DoraPrivateProtocolService$a r1) {
        return registerCallbackInternal$lambda$1(r0, r1);
    }

    public int getConnectionState() {
        int r0 = this.this$0.b;
        FLogger.a.i("DoraPrivateProtocolSvc", "getConnectionState called, state=" + r0);
        return r0;
    }

    public DoraDeviceInfo getCurrentDeviceInfo() {
        DoraDeviceInfo r0 = this.this$0.c;
        FLogger.a.i("DoraPrivateProtocolSvc", "getCurrentDeviceInfo called");
        return r0;
    }

    public DoraPrivateProtocolService$binder$1(DoraPrivateProtocolService r1) {
        this.this$0 = r1;
    }

    public void registerCallback(IDoraPrivateProtocolCallback r2) {
        registerCallbackInternal(r2, null);
    }

    public void syncBatteryChanged(DoraDeviceInfo r14) {
        if (r14 != null) goto L4;
        r14 = new DoraDeviceInfo(null, null, null, null, 0, 0, null, 0, 0, 0, 0, 16383);
    L4:
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("syncBatteryChanged called: mac=");
        r1.append(r14.a);
        r1.append(", battery=");
        int[] r2 = r14.e;
        DoraPrivateProtocolService$BatteryDeviceType r3 = null;
        if (r2 == null) goto L7;
        String r4 = Arrays.toString(r2);
    L8:
        r1.append(r4);
        r0.i("DoraPrivateProtocolSvc", r1.toString());
        this.this$0.c = r14;
        DoraPrivateProtocolService r5 = this.this$0;
        if (r5.a.isEmpty() == false) goto L11;
        r0.i("DoraPrivateProtocolSvc", "notifyBatteryChanged skipped: callbacks is empty");
        return;
    L11:
        ProductNameType r6 = ProductNameType.getProduct(r14.n);
        if (r6 == null) goto L14;
        Integer r7 = Integer.valueOf(r6.deviceType);
    L15:
        int r8 = r14.getType();
        ProductNameType r9 = ProductNameType.H_FREE_CLIP_2;
        int r10 = r9.deviceType;
        if (r8 != r10) goto L18;
    L79:
        r3 = DoraPrivateProtocolService$BatteryDeviceType.H_FREE_CLIP_2;
    L80:
        Iterator r11 = r5.a.iterator();
    L82:
        if (r11.hasNext() == false) goto L115;
        DoraPrivateProtocolService$a r12 = (DoraPrivateProtocolService$a) r11.next();
        Set<DoraPrivateProtocolService$BatteryDeviceType> r13 = r12.b;
        if (r13 == null) goto L86;
        if (r3 != null) goto L94;
    L96:
        boolean r15 = false;
    L97:
        if (r15 == false) goto L98;
        r12.a.onBatteryChanged(r14);     // Catch: RemoteException -> L104
    L104:
        e = move-exception;
        FLogger.a.e("DoraPrivateProtocolSvc", "notifyBatteryChanged: failed to notify callback, removing it. Error: " + e.getMessage());
        r5.a.remove(r12);
        goto L82
    L98:
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("notifyBatteryChanged skipped: deviceType=");
        r17.append(r3);
        r17.append(", subscribed=");
        Object r18 = r12.b;
        if (r18 != null) goto L101;
        r18 = "legacy";
    L101:
        r17.append(r18);
        r16.i("DoraPrivateProtocolSvc", r17.toString());
        goto L82
    L94:
        if (r13.contains(r3) == false) goto L96;
    L95:
        r15 = true;
        goto L97
    L86:
        if (r3 == DoraPrivateProtocolService$BatteryDeviceType.LITE) goto L95;
        if (r3 == DoraPrivateProtocolService$BatteryDeviceType.H_FREE_CLIP_2) goto L95;
        if (r3 != DoraPrivateProtocolService$BatteryDeviceType.H_FREE_BUDS_PRO_5) goto L96;
    L115:
        return;
    L18:
        if (r14.n == r9.id) goto L79;
        if (r7 != null) goto L22;
    L24:
        int r19 = r14.getType();
        ProductNameType r20 = ProductNameType.H_FREE_BUDS_PRO_5;
        int r21 = r20.deviceType;
        if (r19 != r21) goto L27;
    L78:
        r3 = DoraPrivateProtocolService$BatteryDeviceType.H_FREE_BUDS_PRO_5;
        goto L80
    L27:
        if (r14.n == r20.id) goto L78;
        if (r7 == null) goto L34;
        if (r7.intValue() == r21) goto L78;
    L34:
        if (r14.getType() != 16) goto L36;
    L77:
        r3 = DoraPrivateProtocolService$BatteryDeviceType.G1;
        goto L80
    L36:
        if (r14.n == ProductNameType.DORA_G.id) goto L77;
        if (r7 == null) goto L43;
        if (r7.intValue() == 16) goto L77;
    L43:
        if (r14.getType() != 17) goto L45;
    L76:
        r3 = DoraPrivateProtocolService$BatteryDeviceType.G2;
        goto L80
    L45:
        if (r14.n == ProductNameType.DORA_G2.id) goto L76;
        if (r7 == null) goto L52;
        if (r7.intValue() == 17) goto L76;
    L52:
        if (r14.getType() != 18) goto L54;
    L75:
        r3 = DoraPrivateProtocolService$BatteryDeviceType.G_AIR;
        goto L80
    L54:
        if (r14.n == ProductNameType.DORA_G_AIR.id) goto L75;
        if (r7 == null) goto L61;
        if (r7.intValue() == 18) goto L75;
    L61:
        if (r14.getType() != 19) goto L63;
    L74:
        r3 = DoraPrivateProtocolService$BatteryDeviceType.G_PIN;
        goto L80
    L63:
        if (r14.n == ProductNameType.DORA_G_PIN.id) goto L74;
        if (r7 != null) goto L67;
    L69:
        int r22 = r14.getType();
        ProductNameType r23 = ProductNameType.DORA_LITE;
        if (r22 != r23.deviceType) goto L72;
    L73:
        r3 = DoraPrivateProtocolService$BatteryDeviceType.LITE;
        goto L80
    L72:
        if (r14.n != r23.id) goto L80;
    L67:
        if (r7.intValue() != 19) goto L69;
    L22:
        if (r7.intValue() != r10) goto L24;
    L14:
        r7 = null;
        goto L15
    L7:
        r4 = null;
        goto L8
    }

    public void syncChargeStateChanged(DoraDeviceInfo r14) {
        if (r14 != null) goto L4;
        r14 = new DoraDeviceInfo(null, null, null, null, 0, 0, null, 0, 0, 0, 0, 16383);
    L4:
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("syncChargeStateChanged called: mac=");
        r1.append(r14.a);
        r1.append(", charge=");
        int[] r2 = r14.d;
        if (r2 == null) goto L7;
        String r3 = Arrays.toString(r2);
    L8:
        r1.append(r3);
        r0.i("DoraPrivateProtocolSvc", r1.toString());
        this.this$0.c = r14;
        DoraPrivateProtocolService r4 = this.this$0;
        Iterator r5 = r4.a.iterator();
    L10:
        if (r5.hasNext() == false) goto L16;
        DoraPrivateProtocolService$a r6 = (DoraPrivateProtocolService$a) r5.next();
        r6.a.onChargeStateChanged(r14);     // Catch: RemoteException -> L14
    L14:
        e = move-exception;
        FLogger.a.e("DoraPrivateProtocolSvc", "notifyChargeStateChanged: failed to notify callback, removing it. Error: " + e.getMessage());
        r4.a.remove(r6);
        goto L10
    L16:
        return;
    L7:
        r3 = null;
        goto L8
    }

    public void unregisterCallback(IDoraPrivateProtocolCallback r4) {
        if (r4 != null) goto L6;
        FLogger.a.w("DoraPrivateProtocolSvc", "unregisterCallback: callback is null");
        return;
    L6:
        FLogger.a.i("DoraPrivateProtocolSvc", "unregisterCallback called");
        CollectionsKt.removeAll(this.this$0.a, new f(r4));
    }

    private final void registerCallbackInternal(final IDoraPrivateProtocolCallback r14, String r15) {
        if (r14 != null) goto L6;
        FLogger.a.w("DoraPrivateProtocolSvc", "registerCallback: callback is null");
        return;
    L6:
        Set r2 = null;
        r2 = null;
        if (r15 == null) goto L54;
        DoraPrivateProtocolService r3 = this.this$0;
        int r4 = DoraPrivateProtocolService.e;
        r3.getClass();
        String r5 = StringsKt.trim(r15).toString();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L11
        Object r7 = Result.constructor-impl(new JSONObject(r5).optString("device_type"));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r7) == false) goto L16;
        r7 = null;
    L16:
        String r8 = (String) r7;
        if (r8 != null) goto L20;
        r8 = "";
    L20:
        if (StringsKt.isBlank(r8) == false) goto L22;
        String r9 = r5;
    L23:
        List r10 = StringsKt.split$default(r9, new char[]{','}, false, 0, 6, null);
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L25:
        if (r12.hasNext() == false) goto L53;
        String r13 = (String) r12.next();
        DoraPrivateProtocolService$BatteryDeviceType.a r16 = DoraPrivateProtocolService$BatteryDeviceType.Companion;
        String r17 = StringsKt.trim(r13).toString();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "value");
        String r18 = StringsKt.replace$default(r17, '-', '_', false, 4, null).toUpperCase(Locale.ROOT);
        switch(r18.hashCode()) {
            case -10040147: goto L40;
            case -10025736: goto L36;
            case 2179971: goto L33;
            case 2194382: goto L30;
            default: goto L43;
        };
    L43:
        Iterator r19 = DoraPrivateProtocolService$BatteryDeviceType.getEntries().iterator();
    L45:
        if (r19.hasNext() == false) goto L49;
        Object r20 = r19.next();
        if (Intrinsics.areEqual(((DoraPrivateProtocolService$BatteryDeviceType) r20).name(), r18) == false) goto L45;
    L50:
        DoraPrivateProtocolService$BatteryDeviceType r21 = (DoraPrivateProtocolService$BatteryDeviceType) r20;
    L51:
        if (r21 == null) goto L25;
        r11.add(r21);
        goto L25
    L49:
        r20 = null;
        goto L50
    L30:
        if (r18.equals("GPIN") == false) goto L43;
    L38:
        r21 = DoraPrivateProtocolService$BatteryDeviceType.G_PIN;
        goto L51
    L33:
        if (r18.equals("GAIR") == false) goto L43;
    L42:
        r21 = DoraPrivateProtocolService$BatteryDeviceType.G_AIR;
        goto L51
    L36:
        if (r18.equals("DORA_G_PIN") == true) goto L38;
    L40:
        if (r18.equals("DORA_G_AIR") == true) goto L42;
    L53:
        Set r22 = CollectionsKt.toSet(r11);
    L55:
        if (r22 != null) goto L57;
    L59:
        if (r15 == null) goto L62;
        if (r2 != null) goto L62;
        FLogger.a.w("DoraPrivateProtocolSvc", "registerCallback: device types unavailable, extra=" + r15 + ", falling back to legacy subscription");
    L62:
        CollectionsKt.removeAll(this.this$0.a, new g(r14));
        this.this$0.a.add(new DoraPrivateProtocolService$a(r14, r2));
        FLogger r110 = FLogger.a;
        StringBuilder r1 = new StringBuilder("registerCallback called size:");
        r1.append(this.this$0.a.size());
        r1.append(", deviceTypes=");
        Object r23 = r2;
        if (r2 != null) goto L65;
        r23 = "legacy";
    L65:
        r1.append(r23);
        r110.i("DoraPrivateProtocolSvc", r1.toString());
        r14.onConnectionStateChanged(this.this$0.b, this.this$0.c);     // Catch: RemoteException -> L68
        r110.i("DoraPrivateProtocolSvc", "registerCallback: sent initial state to callback");     // Catch: RemoteException -> L68
        return;
    L68:
        e = move-exception;
        FLogger.a.e("DoraPrivateProtocolSvc", "registerCallback: failed to send initial state, removing callback. Error: " + e.getMessage());
        CollectionsKt.removeAll(this.this$0.a, new f(r14));
        return;
    L57:
        if ((true ^ r22.isEmpty()) == false) goto L59;
        r2 = r22;
        goto L59
    L22:
        r9 = r8;
    L11:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L54:
        r22 = null;
        goto L55
    }

    private static final boolean registerCallbackInternal$lambda$1(IDoraPrivateProtocolCallback r0, DoraPrivateProtocolService$a r1) {
        return Intrinsics.areEqual(r1.a.asBinder(), r0.asBinder());
    }

    public void registerCallbackWithExtra(IDoraPrivateProtocolCallback r1, String r2) {
        registerCallbackInternal(r1, r2);
    }

    public void syncConnectionState(int r14, DoraDeviceInfo r15) {
        if (r15 != null) goto L4;
        r15 = new DoraDeviceInfo(null, null, null, null, 0, 0, null, 0, 0, 0, 0, 16383);
    L4:
        FLogger r0 = FLogger.a;
        r0.i("DoraPrivateProtocolSvc", "syncConnectionState called: state=" + r14 + ", mac=" + r15.a);
        DoraPrivateProtocolService r1 = this.this$0;
        r1.b = r14;
        r1.c = r15;
        this.this$0.getClass();
        ObricKeepAliveLevelController r2 = ObricKeepAliveLevelController.a;
        boolean r3 = false;
        if (r14 != 2) goto L7;
        boolean r4 = true;
    L9:
        if (ObricKeepAliveLevelController.b == r4) goto L11;
        r3 = true;
    L11:
        ObricKeepAliveLevelController.b = r4;
        r0.i("ObricKeepAliveLevel", "updateDoraPrivateLinkConnected connected=" + r4 + ", connectionChanged=" + r3);
        if (r4 == true) goto L14;
        r2.a();
    L21:
        DoraPrivateProtocolService r5 = this.this$0;
        Iterator r6 = r5.a.iterator();
    L23:
        if (r6.hasNext() == false) goto L29;
        DoraPrivateProtocolService$a r7 = (DoraPrivateProtocolService$a) r6.next();
        r7.a.onConnectionStateChanged(r14, r15);     // Catch: RemoteException -> L27
    L27:
        e = move-exception;
        FLogger.a.e("DoraPrivateProtocolSvc", "notifyConnectionStateChanged: failed to notify callback, removing it. Error: " + e.getMessage());
        r5.a.remove(r7);
        goto L23
    L29:
        return;
    L14:
        monitor-enter(r2);
        Job r8 = ObricKeepAliveLevelController.g;     // Catch: Throwable -> L30
        if (r8 == null) goto L18;
        Job.DefaultImpls.cancel$default(r8, null, 1, null);     // Catch: Throwable -> L30
    L18:
        ObricKeepAliveLevelController.g = null;     // Catch: Throwable -> L30
        monitor-exit(r2);
        r2.b("HighLevel");
    L30:
        th = move-exception;
        throw th;
    L7:
        r4 = false;
        goto L9
    }

    public boolean onTransact(int r7, Parcel r8, Parcel r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "data");
        int r0 = Binder.getCallingUid();
        if (r0 == Process.myUid()) goto L19;
        String[] r1 = this.this$0.getPackageManager().getPackagesForUid(r0);
        boolean r2 = true;
        if (r1 != null) goto L7;
    L9:
        boolean r3 = false;
    L11:
        if (this.this$0.checkCallingPermission("com.obric.assistant.dora.permission.DoraPrivateProtocolService") == 0) goto L14;
        r2 = false;
    L14:
        if (r3 == true) goto L19;
        if (r2 == true) goto L19;
        FLogger.a.e("DoraPrivateProtocolSvc", "onTransact denied: callingUid=" + r0 + " does not have permission and is not SystemUI");
        return false;
    L7:
        if (ArraysKt.contains(r1, "com.android.systemui") != true) goto L9;
        r3 = true;
    L19:
        return super.onTransact(r7, r8, r9, r10);
    }
}
