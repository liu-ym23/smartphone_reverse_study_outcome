package com.larus.dora.impl.core.wifi;

import android.net.wifi.WifiManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.dora.wlan.DoraWifiLinkStrategy;
import com.bytedance.dora.wlan.model.DoraWifiScene;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.dora.api.protocol.FlowProtocolAbility;
import com.larus.dora.impl.core.o0;
import com.larus.dora.impl.util.b0;
import com.larus.settings.value.e10;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import kotlinx.coroutines.sync.MutexImpl;
import nu9.f;
import nu9.q;
import vk4.e;
import vk4.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraWifiLinkWrapper {
    public static final DoraWifiLinkWrapper a = null;
    public static final MutexImpl b = null;
    public static final ConcurrentHashMap<String, h> c = null;
    public static final ConcurrentHashMap<String, Function0<Unit>> d = null;
    public static final Set<String> e = null;
    public static final Object f = null;
    public static String g;
    public static DoraWifiScene h;
    public static String i;

    public static final class a {
        public final boolean a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L11;
            r1 = 1237;
        L11:
            return r2 + r1;
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "P2PRTCRuntimeState(hasP2PLinkPermissions=" + this.a + ", hasP2PRTCAbility=" + this.b + ')';
        }

        public final boolean a() {
            if (this.a == true) goto L5;
        L7:
            return false;
        L5:
            if (this.b == false) goto L7;
            return true;
        }

        public a(boolean r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements h {
        public final /* synthetic */ e a;
        public final /* synthetic */ String b;

        public b(e r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(int r2, int r3, String r4) {
            if (r3 == 0) goto L4;
            return;
        L4:
            Object r5 = DoraWifiLinkWrapper.f;
            String r6 = this.b;
            monitor-enter(r5);
            Function0<Unit> r0 = null;
            if (DoraWifiLinkWrapper.c.remove(r6, this) == true) goto L10;
        L13:
            monitor-exit(r5);
            this.a.j(this);
            if (r0 == null) goto L23;
            r0.invoke();
            return;
        L23:
            return;
        L10:
            if (Intrinsics.areEqual(DoraWifiLinkWrapper.g, r6) == false) goto L12;
            DoraWifiLinkWrapper.g = null;     // Catch: Throwable -> L18
            DoraWifiLinkWrapper.h = null;     // Catch: Throwable -> L18
        L12:
            DoraWifiLinkWrapper.e.remove(r6);     // Catch: Throwable -> L18
            r0 = DoraWifiLinkWrapper.d.remove(r6);     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            throw th;
        }
    }

    public static final class c implements Function1<Throwable, Unit> {
        public final /* synthetic */ DoraWifiScene a;
        public final /* synthetic */ e b;
        public final /* synthetic */ d c;
        public final /* synthetic */ String d;

        public c(DoraWifiScene r1, e r2, d r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final Object invoke(Object r5) {
            Throwable r6 = (Throwable) r5;
            g49.d.d("DoraWifiLinkWrapper", "connect: invokeOnCancellation, scene=" + this.a);
            this.b.j(this.c);
            Object r7 = DoraWifiLinkWrapper.f;
            String r0 = this.d;
            d r1 = this.c;
            monitor-enter(r7);
            if (r0 != null) goto L32;
        L11:
            boolean r2 = true;
        L12:
            if (r2 == true) goto L14;
        L16:
            if (r0 == null) goto L19;
            if (r2 == false) goto L19;
            DoraWifiLinkWrapper.e.remove(r0);     // Catch: Throwable -> L9
        L19:
            if (r0 == null) goto L27;
            if (r2 == false) goto L27;
            if (DoraWifiLinkWrapper.c.remove(r0, r1) == false) goto L27;
            DoraWifiLinkWrapper.d.remove(r0);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        L27:
            monitor-exit(r7);
            if (r2 == false) goto L31;
            this.b.b(this.a);
        L31:
            return Unit.INSTANCE;
        L14:
            if (Intrinsics.areEqual(DoraWifiLinkWrapper.i, r0) == false) goto L16;
            DoraWifiLinkWrapper.i = null;     // Catch: Throwable -> L9
            goto L16
        L32:
            if (DoraWifiLinkWrapper.c.get(r0) == r1) goto L11;
            r2 = false;
            goto L12
        }
    }

    public static final class d implements h {
        public final /* synthetic */ DoraWifiScene a;
        public final /* synthetic */ String b;
        public final /* synthetic */ e c;
        public final /* synthetic */ AtomicBoolean d;
        public final /* synthetic */ i<x39.b> e;
        public final /* synthetic */ Function0<Unit> f;

        public final void a(int r7, int r8, String r9) {
            g49.d.d("DoraWifiLinkWrapper", "connect: wifiLinkStateChanged: " + r7 + " -> " + r8 + ", reason=" + r9 + ", scene=" + this.a);
            Function0<Unit> r10 = null;
            if (r8 != 0) goto L5;
            Object r11 = DoraWifiLinkWrapper.f;
            String r2 = this.b;
            monitor-enter(r11);
            if (r2 != null) goto L130;
        L86:
            boolean r3 = true;
        L87:
            if (r2 == null) goto L92;
            if (r3 == false) goto L92;
            if (DoraWifiLinkWrapper.e.contains(r2) == false) goto L92;
            boolean r4 = true;
        L93:
            if (r3 == true) goto L95;
        L97:
            if (r3 == true) goto L99;
        L101:
            if (r2 == null) goto L104;
            if (r3 == false) goto L104;
            DoraWifiLinkWrapper.e.remove(r2);     // Catch: Throwable -> L84
        L104:
            if (r2 == null) goto L112;
            if (r3 == false) goto L112;
            if (DoraWifiLinkWrapper.c.remove(r2, this) == false) goto L112;
            r10 = DoraWifiLinkWrapper.d.remove(r2);     // Catch: Throwable -> L84
        L84:
            th = move-exception;
            throw th;
        L112:
            monitor-exit(r11);
            if (r4 == false) goto L115;
            Object r12 = new x39.b.a("disconnected_after_cancel");
        L122:
            if (this.d.compareAndSet(false, true) == false) goto L124;
            this.e.resumeWith(Result.constructor-impl(r12));
        L124:
            this.c.j(this);
            if (r10 == null) goto L141;
            r10.invoke();
            return;
        L141:
            return;
        L115:
            DoraWifiLinkWrapper.a.getClass();
            r12 = DoraWifiLinkWrapper.m(r9);
            if (r12 != null) goto L122;
            if (r9 != null) goto L120;
            r9 = "";
        L120:
            r12 = new x39.b.a(r9);
            goto L122
        L99:
            if (Intrinsics.areEqual(DoraWifiLinkWrapper.i, r2) == false) goto L101;
            DoraWifiLinkWrapper.i = null;     // Catch: Throwable -> L84
            goto L101
        L95:
            if (Intrinsics.areEqual(DoraWifiLinkWrapper.g, r2) == false) goto L97;
            DoraWifiLinkWrapper.g = null;     // Catch: Throwable -> L84
            DoraWifiLinkWrapper.h = null;     // Catch: Throwable -> L84
        L92:
            r4 = false;
            goto L93
        L130:
            if (DoraWifiLinkWrapper.c.get(r2) == this) goto L86;
            r3 = false;
            goto L87
        L5:
            if (r8 != 2) goto L142;
            String r13 = this.b;
            if (r13 == null) goto L28;
            Object r14 = DoraWifiLinkWrapper.f;
            DoraWifiScene r5 = this.a;
            monitor-enter(r14);
        L25:
            th = move-exception;
            throw th;
        L12:
            if (DoraWifiLinkWrapper.c.get(r13) == this) goto L14;
        L20:
            boolean r15 = false;
        L21:
            monitor-exit(r14);
            if (r15 == true) goto L28;
            boolean r16 = false;
        L29:
            if (r16 == true) goto L58;
            String r17 = this.b;
            if (r17 == null) goto L50;
            Object r18 = DoraWifiLinkWrapper.f;
            monitor-enter(r18);
            ConcurrentHashMap<String, h> r6 = DoraWifiLinkWrapper.c;     // Catch: Throwable -> L47
            if (r6.get(r17) != this) goto L43;
            Set<String> r20 = DoraWifiLinkWrapper.e;     // Catch: Throwable -> L47
            if (r20.contains(r17) == false) goto L43;
            if (Intrinsics.areEqual(DoraWifiLinkWrapper.i, r17) == false) goto L41;
            DoraWifiLinkWrapper.i = null;     // Catch: Throwable -> L47
        L41:
            r6.remove(r17, this);     // Catch: Throwable -> L47
            r20.remove(r17);     // Catch: Throwable -> L47
            DoraWifiLinkWrapper.d.remove(r17);     // Catch: Throwable -> L47
            boolean r21 = true;
        L44:
            monitor-exit(r18);
            if (r21 == false) goto L50;
            boolean r22 = true;
        L51:
            g49.d.e("DoraWifiLinkWrapper", "connect: ignore stale/cancelled owner callback scene=" + this.a + " cancelled=" + r22);
            this.c.j(this);
            if (r22 == false) goto L136;
            this.c.b(this.a);
            if (this.d.compareAndSet(false, true) == false) goto L137;
            i<x39.b> r23 = this.e;
            Result.Companion r24 = Result.Companion;
            r23.resumeWith(Result.constructor-impl(new x39.b.a("connected_after_cancel")));
            return;
        L137:
            return;
        L136:
            return;
        L43:
            r21 = false;
        L47:
            th = move-exception;
            throw th;
        L50:
            r22 = false;
            goto L51
        L58:
            if (this.b != null) goto L68;
            Object r25 = DoraWifiLinkWrapper.f;
            monitor-enter(r25);
            DoraWifiLinkWrapper.i = null;     // Catch: Throwable -> L64
            DoraWifiLinkWrapper.g = null;     // Catch: Throwable -> L64
            DoraWifiLinkWrapper.h = null;     // Catch: Throwable -> L64
            Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L64
            monitor-exit(r25);
        L64:
            th = move-exception;
            throw th;
        L68:
            if (this.d.compareAndSet(false, true) == false) goto L138;
            i<x39.b> r27 = this.e;
            Result.Companion r28 = Result.Companion;
            String r30 = this.c.c();
            if (r30 != null) goto L72;
            r30 = "";
        L72:
            r27.resumeWith(Result.constructor-impl(new x39.b.f(r30)));
            if (this.b != null) goto L75;
        L76:
            this.c.j(this);
            return;
        L75:
            if (this.f == null) goto L76;
            return;
        L138:
            return;
        L14:
            if (Intrinsics.areEqual(DoraWifiLinkWrapper.i, r13) == false) goto L20;
            if (DoraWifiLinkWrapper.e.contains(r13) == true) goto L20;
            DoraWifiLinkWrapper.i = null;     // Catch: Throwable -> L25
            DoraWifiLinkWrapper.g = r13;     // Catch: Throwable -> L25
            DoraWifiLinkWrapper.h = r5;     // Catch: Throwable -> L25
            r15 = true;
        L28:
            r16 = true;
            goto L29
        }

        public d(DoraWifiScene r1, String r2, e r3, AtomicBoolean r4, j r5, Function0 r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public DoraWifiLinkWrapper() {
    }

    static {
        a = new DoraWifiLinkWrapper();
        b = kotlinx.coroutines.sync.b.a();
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = new LinkedHashSet();
        f = new Object();
    }

    public static boolean f() {
        if (o0.d(FlowProtocolAbility.FEATURE_P2P_RTC) == false) goto L7;
        sk4.e r0 = o0.a;
        if (o0.d(FlowProtocolAbility.FEATURE_P2P_BT_RTC) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public static boolean k() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L20
        Object r1 = AppHost.a.getApplication().getApplicationContext().getSystemService("wifi");     // Catch: Throwable -> L20
        Integer r2 = null;
        if ((r1 instanceof WifiManager) == false) goto L5;
        WifiManager r3 = (WifiManager) r1;     // Catch: Throwable -> L20
    L6:
        if (r3 == null) goto L8;
        r2 = Integer.valueOf(r3.getWifiState());     // Catch: Throwable -> L20
    L8:
        boolean r4 = true;
        if (r2 != null) goto L12;
    L13:
        if (r2 != null) goto L16;
    L18:
        Object r5 = Result.constructor-impl(Boolean.valueOf(r4));     // Catch: Throwable -> L20
    L22:
        Boolean r6 = Boolean.TRUE;
        if (Result.isFailure-impl(r5) == false) goto L26;
        r5 = r6;
    L26:
        return ((Boolean) r5).booleanValue();
    L16:
        if (r2.intValue() != 0) goto L18;
    L17:
        r4 = false;
        goto L18
    L12:
        if (r2.intValue() == 1) goto L17;
    L5:
        r3 = null;
    L20:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }

    public static x39.a o() {
        DoraWifiScene r0 = DoraWifiScene.OTHER;
        e r1 = e.d.a;
        r1.getClass();
        String r2 = r1.i(q(r0, DoraWifiLinkStrategy.fromValue(pk4.i.a.a.a.getInt("wifi_link_strategy", -1))));
        if (r2 == null) goto L24;
        switch(r2.hashCode()) {
            case -1743217746: goto L20;
            case -1374293515: goto L16;
            case -196981436: goto L12;
            case 1377196703: goto L8;
            default: goto L24;
        };
    L8:
        if (r2.equals(FlowDoraConnectReason.P2P_CHECK_HOTSPOT_OPEN) == false) goto L24;
        return x39.a.b.a;
    L12:
        if (r2.equals(FlowDoraConnectReason.P2P_CHECK_VPN_OPEN) == false) goto L24;
        return x39.a.d.a;
    L16:
        if (r2.equals(FlowDoraConnectReason.P2P_CHECK_LOCATION_NOT_PASS) == false) goto L24;
        return x39.a.C0146a.a;
    L20:
        if (r2.equals(FlowDoraConnectReason.P2P_CHECK_WIFI_NOT_OPEN) == false) goto L24;
        return x39.a.e.a;
    L24:
        return x39.a.c.a;
    }

    public static List p() {
        int r0 = Build.VERSION.SDK_INT;
        boolean r1 = ObricFeatureServiceDelegate.b.b();
        if (r0 < 33) goto L8;
        if (r1 == false) goto L10;
        return CollectionsKt.listOf("android.permission.ACCESS_FINE_LOCATION");
    L10:
        return CollectionsKt.listOf(new String[]{"android.permission.NEARBY_WIFI_DEVICES", "android.permission.ACCESS_FINE_LOCATION"});
    L8:
        return CollectionsKt.listOf("android.permission.ACCESS_FINE_LOCATION");
    }

    public static boolean g() {
        List r0 = p();
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L23;
        String r2 = (String) r1.next();
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), r2) != 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L9;
        return false;
    L13:
        r3 = false;
        goto L14
    L23:
        return true;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return true;
    }

    public static boolean h() {
        boolean r2 = false;
        if (f() == true) goto L6;
        g49.d.d("DoraWifiLinkWrapper", "dataSaving decision: enabled=false, reason=no_bt_p2p_rtc_ability");
        return false;
    L6:
        Integer r0 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L15
        e10 r4 = e10.a;     // Catch: Throwable -> L15
        nu9.a r5 = e10.Q().a();     // Catch: Throwable -> L15
        if (r5 == null) goto L12;
        q r6 = r5.b();     // Catch: Throwable -> L15
        if (r6 == null) goto L12;
        f r7 = r6.a();     // Catch: Throwable -> L15
    L13:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r8) == false) goto L20;
        Object r9 = null;
    L21:
        f r10 = (f) r9;
        if (r10 == null) goto L24;
        Integer r11 = r10.b();
    L25:
        if (r10 == null) goto L27;
        r0 = r10.a();
    L27:
        if (r0 == null) goto L29;
        int r12 = r0.intValue();
    L31:
        if (r12 != 1) goto L33;
        boolean r13 = true;
    L34:
        if (r11 == null) goto L36;
        int r14 = r11.intValue();
    L37:
        if (r14 != 1) goto L39;
        boolean r15 = true;
    L40:
        String r16 = ILoginService.a.getAccountInfo().c;
        if (r16 != null) goto L44;
        r16 = "";
    L44:
        if (r15 == false) goto L48;
        b0.a.getClass();
        Intrinsics.checkNotNullParameter(r16, "uid");
        if (b0.j().contains("dora_enable_data_saving_".concat(r16)) == false) goto L48;
        boolean r17 = true;
    L49:
        if (r15 == false) goto L53;
        if (r17 == false) goto L53;
        b0.a.getClass();
        Intrinsics.checkNotNullParameter(r16, "uid");
        boolean r18 = b0.j().getBoolean("dora_enable_data_saving_".concat(r16), r13);
    L54:
        StringBuilder r110 = new StringBuilder("dataSaving decision: enabled=");
        r110.append(r18);
        r110.append(", settingsFetched=");
        r110.append(Result.isSuccess-impl(r8));
        r110.append(", settingsNull=");
        if (r10 != null) goto L57;
        r2 = true;
    L57:
        r110.append(r2);
        r110.append(", rawShowEntrance=");
        r110.append(r11);
        r110.append(", rawDefValue=");
        r110.append(r0);
        r110.append(", showEntrance=");
        r110.append(r15);
        r110.append(", defValue=");
        r110.append(r13);
        r110.append(", hasUserChoice=");
        r110.append(r17);
        g49.d.d("DoraWifiLinkWrapper", r110.toString());
        return r18;
    L53:
        r18 = r13;
    L48:
        r17 = false;
        goto L49
    L39:
        r15 = false;
        goto L40
    L36:
        r14 = 0;
        goto L37
    L33:
        r13 = false;
        goto L34
    L29:
        r12 = 0;
        goto L31
    L24:
        r11 = null;
        goto L25
    L20:
        r9 = r8;
    L12:
        r7 = null;
    L15:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    public static boolean i() {
        boolean r0 = f();
        Integer r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        e10 r3 = e10.a;     // Catch: Throwable -> L11
        nu9.a r4 = e10.Q().a();     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        q r5 = r4.b();     // Catch: Throwable -> L11
        if (r5 == null) goto L8;
        f r6 = r5.a();     // Catch: Throwable -> L11
    L9:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r7) == false) goto L16;
        Object r8 = null;
    L17:
        f r9 = (f) r8;
        if (r9 == null) goto L20;
        Integer r10 = r9.b();
    L21:
        boolean r11 = true;
        if (r0 == false) goto L28;
        if (r10 == null) goto L25;
        int r12 = r10.intValue();
    L26:
        if (r12 != 1) goto L28;
        boolean r13 = true;
    L29:
        StringBuilder r14 = new StringBuilder("dataSaving entrance: visible=");
        r14.append(r13);
        r14.append(", hasAbility=");
        r14.append(r0);
        r14.append(", settingsFetched=");
        r14.append(Result.isSuccess-impl(r7));
        r14.append(", settingsNull=");
        if (r9 == null) goto L33;
        r11 = false;
    L33:
        r14.append(r11);
        r14.append(", rawShowEntrance=");
        r14.append(r10);
        r14.append(", rawDefValue=");
        if (r9 == null) goto L36;
        r1 = r9.a();
    L36:
        r14.append(r1);
        g49.d.d("DoraWifiLinkWrapper", r14.toString());
        return r13;
    L25:
        r12 = 0;
    L28:
        r13 = false;
        goto L29
    L20:
        r10 = null;
        goto L21
    L16:
        r8 = r7;
    L8:
        r6 = null;
    L11:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public static boolean j() {
        if (f() == true) goto L5;
    L8:
        return true;
    L5:
        if (l() == true) goto L8;
        return false;
    }

    public static boolean l() {
        boolean r0 = f();
        boolean r1 = k();
        if (r0 == true) goto L6;
        g49.d.d("DoraWifiLinkWrapper", "videoCallWifiEffective=" + r1 + ", reason=legacy_no_bt_p2p_rtc, systemWifi=" + r1);
        return r1;
    L6:
        boolean r2 = h();
        boolean r4 = true;
        if (r2 == true) goto L21;
        boolean r5 = true;
    L17:
        if (r2 == false) goto L19;
        r4 = r5;
    L19:
        g49.d.d("DoraWifiLinkWrapper", "videoCallWifiEffective=" + r4 + ", hasAbility=true, dataSaving=" + r2 + ", phoneWifiConnected=" + r5 + ", systemWifi=" + r1);
        return r4;
    L21:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L10
        Object r7 = Result.constructor-impl(Boolean.valueOf(NetworkUtils.isWifi(AppHost.a.getApplication())));     // Catch: Throwable -> L10
    L12:
        Boolean r8 = Boolean.FALSE;
        if (Result.isFailure-impl(r7) == false) goto L15;
        r7 = r8;
    L15:
        r5 = ((Boolean) r7).booleanValue();
    L10:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static a n() {
        return new a(g(), o0.d(FlowProtocolAbility.FEATURE_P2P_RTC));
    }

    public static Object e(Continuation r5) {
        List r0 = p();
        List r1 = r0;
        boolean r3 = true;
        if ((r1 instanceof Collection) == true) goto L5;
    L7:
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L17;
        String r4 = (String) r2.next();
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), r4) != 0) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == true) goto L9;
        r3 = false;
        goto L17
    L13:
        r6 = false;
    L17:
        if (r3 == false) goto L20;
        return null;
    L20:
        return BuildersKt.withContext(Dispatchers.getMain(), new DoraWifiLinkWrapper$checkAndRequestPermissions$2(r0, null), r5);
    L5:
        if (r1.isEmpty() == false) goto L7;
        goto L7
    }

    public static x39.b m(String r1) {
        if (r1 != null) goto L4;
    L22:
        return null;
    L4:
        switch(r1.hashCode()) {
            case -1743217746: goto L19;
            case -1374293515: goto L15;
            case -196981436: goto L11;
            case 1377196703: goto L7;
            default: goto L22;
        };
    L7:
        if (r1.equals(FlowDoraConnectReason.P2P_CHECK_HOTSPOT_OPEN) == false) goto L22;
        return x39.b.c.b;
    L11:
        if (r1.equals(FlowDoraConnectReason.P2P_CHECK_VPN_OPEN) == false) goto L22;
        return x39.b.g.b;
    L15:
        if (r1.equals(FlowDoraConnectReason.P2P_CHECK_LOCATION_NOT_PASS) == false) goto L22;
        return x39.b.C0147b.b;
    L19:
        if (r1.equals(FlowDoraConnectReason.P2P_CHECK_WIFI_NOT_OPEN) == false) goto L22;
        return x39.b.h.b;
    }

    public static void d(DoraWifiScene r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "scene");
        e r0 = e.d.a;
        Object r1 = f;
        monitor-enter(r1);
        boolean r2 = true;
        boolean r3 = false;
        if (r7 != null) goto L48;
    L13:
        if (r7 == null) goto L15;
    L21:
        boolean r4 = false;
    L22:
        if (r4 == false) goto L24;
        r2 = false;
    L40:
        monitor-exit(r1);
        if (r2 == true) goto L44;
        g49.d.e("DoraWifiLinkWrapper", "disconnect: reject mismatched owner scene=" + r6);
        return;
    L44:
        g49.d.d("DoraWifiLinkWrapper", "disconnect: scene=" + r6);
        return;
    L24:
        if (r7 != null) goto L27;
        r0.b(r6);     // Catch: Throwable -> L11
        goto L40
    L27:
        if (Intrinsics.areEqual(g, r7) == true) goto L29;
    L31:
        boolean r5 = Intrinsics.areEqual(i, r7);     // Catch: Throwable -> L11
        h r8 = null;
        if (r3 == false) goto L34;
        g = null;     // Catch: Throwable -> L11
        h = null;     // Catch: Throwable -> L11
        e.remove(r7);     // Catch: Throwable -> L11
        i = null;     // Catch: Throwable -> L11
        d.remove(r7);     // Catch: Throwable -> L11
        r8 = c.remove(r7);     // Catch: Throwable -> L11
    L36:
        if (r8 == null) goto L38;
        r0.j(r8);     // Catch: Throwable -> L11
    L38:
        if (r5 == true) goto L40;
        r0.b(r6);     // Catch: Throwable -> L11
        goto L40
    L34:
        if (r5 == false) goto L36;
        e.add(r7);     // Catch: Throwable -> L11
        d.remove(r7);     // Catch: Throwable -> L11
        goto L36
    L29:
        if (h != r6) goto L31;
        r3 = true;
        goto L31
    L15:
        if (g == null) goto L19;
        if (h != r6) goto L19;
    L20:
        r4 = true;
    L19:
        if (i == null) goto L21;
    L48:
    L11:
        th = move-exception;
        throw th;
    L7:
        if (Intrinsics.areEqual(g, r7) == true) goto L13;
        if (Intrinsics.areEqual(i, r7) == false) goto L20;
        goto L20
    }

    public static DoraWifiLinkStrategy q(DoraWifiScene r1, DoraWifiLinkStrategy r2) {
        if (r1 != DoraWifiScene.ALBUM_SILENT) goto L7;
        return DoraWifiLinkStrategy.P2P_ONLY;
    L7:
        if (ObricFeatureServiceDelegate.b.b() == true) goto L9;
    L12:
        return r2;
    L9:
        if (r2 != DoraWifiLinkStrategy.P2P_NEXT_SOFT_AP) goto L12;
        g49.d.d("DoraWifiLinkWrapper", "resolveWifiStrategy: override P2P_NEXT_SOFT_AP to P2P_ONLY for Obric OS, scene=" + r1);
        return DoraWifiLinkStrategy.P2P_ONLY;
    }

    public static boolean a(e r6, DoraWifiScene r7, String r8, Function0 r9) {
        b r0 = new b(r6, r8);
        Object r1 = f;
        monitor-enter(r1);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(g, r8) == false) goto L9;
        if (r9 == null) goto L19;
        d.put(r8, r9);     // Catch: Throwable -> L29
    L19:
        boolean r10 = true;
    L21:
        monitor-exit(r1);
        if (r10 == true) goto L24;
        return false;
    L24:
        r6.a(r7);
        if (r6.e != 2) goto L27;
        return true;
    L27:
        r6.b(r7);
        r0.a(2, 0, "connected_link_lost");
        return false;
    L9:
        if (g == null) goto L11;
    L20:
        r10 = false;
        goto L21
    L11:
        if (i != null) goto L20;
        if (r6.e != 2) goto L20;
        g = r8;     // Catch: Throwable -> L29
        h = r7;     // Catch: Throwable -> L29
        c.put(r8, r0);     // Catch: Throwable -> L29
        if (r9 == null) goto L18;
        d.put(r8, r9);     // Catch: Throwable -> L29
    L18:
        ((CopyOnWriteArraySet) r6.c).add(r0);     // Catch: Throwable -> L29
        goto L19
    }

    public final Object b(DoraWifiScene r10, DoraWifiLinkStrategy r11, boolean r12, String r13, Function0<Unit> r14, Continuation<? super x39.b> r15) {
        if ((r15 instanceof DoraWifiLinkWrapper$connect$2) == false) goto L7;
        DoraWifiLinkWrapper$connect$2 r0 = (DoraWifiLinkWrapper$connect$2) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        DoraWifiLinkWrapper$connect$2 r7 = r0;
        Object r16 = r7.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r7.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        r10 = (kotlinx.coroutines.sync.a) r7.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L32
    L29:
        x39.b r17 = (x39.b) r16;     // Catch: Throwable -> L32
        r10.unlock(null);
        return r17;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r12 = r7.Z$0;
        r10 = (kotlinx.coroutines.sync.a) r7.L$4;
        Function0<Unit> r18 = (Function0) r7.L$3;
        String r110 = (String) r7.L$2;
        DoraWifiLinkStrategy r111 = (DoraWifiLinkStrategy) r7.L$1;
        DoraWifiScene r4 = (DoraWifiScene) r7.L$0;
        ResultKt.throwOnFailure(r16);
        String r5 = r110;
        Function0<Unit> r6 = r18;
        DoraWifiLinkStrategy r112 = r111;
        DoraWifiScene r113 = r4;
    L22:
        DoraWifiLinkWrapper r8 = a;     // Catch: Throwable -> L32
        if (r12 == false) goto L25;
        boolean r9 = true;
    L26:
        r7.L$0 = r10;     // Catch: Throwable -> L32
        r7.L$1 = null;     // Catch: Throwable -> L32
        r7.L$2 = null;     // Catch: Throwable -> L32
        r7.L$3 = null;     // Catch: Throwable -> L32
        r7.L$4 = null;     // Catch: Throwable -> L32
        r7.label = 2;     // Catch: Throwable -> L32
        r16 = r8.c(r113, r112, r9, r5, r6, r7);     // Catch: Throwable -> L32
        if (r16 != r2) goto L29;
        return r2;
    L25:
        r9 = false;
        goto L26
    L18:
        ResultKt.throwOnFailure(r16);
        DoraWifiScene r114 = b;
        r7.L$0 = r10;
        r7.L$1 = r11;
        r7.L$2 = r13;
        r7.L$3 = r14;
        r7.L$4 = r114;
        r7.Z$0 = r12;
        r7.label = 1;
        if (r114.a(null, r7) != r2) goto L21;
        return r2;
    L21:
        r5 = r13;
        r6 = r14;
        r112 = r11;
        r113 = r10;
        r10 = r114;
    L32:
        th = move-exception;
        r10.unlock(null);
        throw th;
    L7:
        r0 = new DoraWifiLinkWrapper$connect$2(this, r15);
        goto L8
    }

    public final Object c(DoraWifiScene r110, DoraWifiLinkStrategy r20, boolean r21, String r22, Function0<Unit> r23, Continuation<? super x39.b> r24) {
        if ((r24 instanceof DoraWifiLinkWrapper$connectLocked$1) == false) goto L7;
        DoraWifiLinkWrapper$connectLocked$1 r1 = (DoraWifiLinkWrapper$connectLocked$1) r24;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        boolean r5 = true;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        DoraWifiLinkStrategy r6 = (DoraWifiLinkStrategy) r1.L$4;
        e r7 = (e) r1.L$3;
        Function0 r8 = (Function0) r1.L$2;
        String r9 = (String) r1.L$1;
        DoraWifiScene r10 = (DoraWifiScene) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L108:
        return r0;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Function0<Unit> r11 = (Function0) r1.L$3;
        String r12 = (String) r1.L$2;
        DoraWifiLinkStrategy r13 = (DoraWifiLinkStrategy) r1.L$1;
        DoraWifiScene r14 = (DoraWifiScene) r1.L$0;
        ResultKt.throwOnFailure(r0);
        Function0<Unit> r15 = r11;
        DoraWifiLinkStrategy r16 = r13;
    L22:
        x39.b r17 = (x39.b) r0;
    L40:
        if (r17 == null) goto L43;
        g49.d.b("DoraWifiLinkWrapper", "connect: permission denied " + r17);
        return r17;
    L43:
        g49.d.d("DoraWifiLinkWrapper", "connect: start method, scene=" + r14 + ", strategy=" + r16);
        e r18 = e.d.a;
        if (r16 != null) goto L46;
        r18.getClass();
        r16 = DoraWifiLinkStrategy.fromValue(pk4.i.a.a.a.getInt("wifi_link_strategy", -1));
    L46:
        DoraWifiLinkStrategy r25 = q(r14, r16);
        if (r18.e != 2) goto L49;
        boolean r111 = true;
    L50:
        if (r111 == false) goto L85;
        Object r26 = f;
        monitor-enter(r26);
        String r27 = g;     // Catch: Throwable -> L81
        monitor-exit(r26);
        if (r12 == null) goto L70;
        if (r27 != null) goto L58;
    L60:
        if (r27 == null) goto L62;
    L66:
        Intrinsics.checkNotNull(r18);
        boolean r28 = a(r18, r14, r12, r15);
    L67:
        if (r28 == true) goto L70;
        r5 = false;
        goto L70
    L62:
        if (r25 != DoraWifiLinkStrategy.P2P_ONLY) goto L66;
        if (r18.e() == false) goto L66;
    L65:
        r28 = false;
        goto L67
    L58:
        if (Intrinsics.areEqual(r27, r12) == true) goto L60;
    L70:
        if (r5 == true) goto L73;
        g49.d.e("DoraWifiLinkWrapper", "connect: reject unknown/mismatched owner scene=" + r14);
        return new x39.b.a("connected_owner_mismatch");
    L73:
        g49.d.d("DoraWifiLinkWrapper", "connect: already connected, scene=" + r14);
        if (r12 != null) goto L76;
        r18.a(r14);
    L76:
        String r30 = r18.c();
        if (r30 != null) goto L80;
        r30 = "";
    L80:
        return new x39.b.f(r30);
    L81:
        th = move-exception;
        throw th;
    L85:
        String r112 = r18.i(r25);
        x39.b r113 = m(r112);
        if (r113 == null) goto L89;
        g49.d.e("DoraWifiLinkWrapper", "connect: precheck failed, reason=" + r112 + ", scene=" + r14);
        return r113;
    L89:
        r1.L$0 = r14;
        r1.L$1 = r12;
        r1.L$2 = r15;
        r1.L$3 = r18;
        r1.L$4 = r25;
        r1.label = 2;
        j r31 = new j(IntrinsicsKt.intercepted(r1), 1);
        r31.C();
        d r32 = new d(r14, r12, r18, new AtomicBoolean(false), r31, r15);
        r31.i(new c(r14, r18, r32, r12));
        if (r12 == null) goto L103;
        Object r114 = f;
        monitor-enter(r114);
        e.remove(r12);     // Catch: Throwable -> L100
        i = r12;     // Catch: Throwable -> L100
        if (r15 == null) goto L96;
        d.put(r12, r15);     // Catch: Throwable -> L100
    L96:
        h r33 = c.put(r12, r32);     // Catch: Throwable -> L100
        monitor-exit(r114);
        if (r33 == null) goto L103;
        r18.j(r33);
    L100:
        th = move-exception;
        throw th;
    L103:
        ((CopyOnWriteArraySet) r18.c).add(r32);
        g49.d.d("DoraWifiLinkWrapper", "connect: do connect action, scene=" + r14 + ", finalStrategy=" + r25);
        dl4.a.a(new vk4.b(r18, r14, r25));
        r0 = r31.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L106;
        DebugProbesKt.probeCoroutineSuspended(r1);
    L106:
        if (r0 != r3) goto L108;
        return r3;
    L49:
        r111 = false;
        goto L50
    L16:
        ResultKt.throwOnFailure(r0);
        if (r21 == false) goto L23;
        r1.L$0 = r110;
        r16 = r20;
        r1.L$1 = r16;
        r12 = r22;
        r1.L$2 = r12;
        r15 = r23;
        r1.L$3 = r15;
        r1.label = 1;
        Object r34 = e(r1);
        if (r34 != r3) goto L21;
        return r3;
    L21:
        r14 = r110;
        r0 = r34;
        goto L22
    L23:
        r16 = r20;
        r12 = r22;
        r15 = r23;
        int r35 = Build.VERSION.SDK_INT;
        boolean r115 = ObricFeatureServiceDelegate.b.b();
        if (r35 < 33) goto L27;
        if (r115 == false) goto L27;
        String r36 = null;
    L30:
        if (r36 != null) goto L33;
    L34:
        x39.b r37 = null;
    L39:
        x39.b r116 = r37;
        r14 = r110;
        r17 = r116;
        goto L40
    L33:
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), r36) == 0) goto L34;
        if (Intrinsics.areEqual(r36, "android.permission.NEARBY_WIFI_DEVICES") == false) goto L38;
        r37 = x39.b.e.b;
        goto L39
    L38:
        r37 = x39.b.d.b;
    L27:
        if (r35 < 33) goto L29;
        r36 = "android.permission.NEARBY_WIFI_DEVICES";
        goto L30
    L29:
        r36 = "android.permission.ACCESS_FINE_LOCATION";
    L7:
        r1 = new DoraWifiLinkWrapper$connectLocked$1(this, r24);
        goto L8
    }
}
