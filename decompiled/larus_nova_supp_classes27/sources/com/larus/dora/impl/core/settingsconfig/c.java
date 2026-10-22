package com.larus.dora.impl.core.settingsconfig;

import com.larus.dora.api.IDoraService;
import com.larus.dora.api.protocol.FlowProtocolAbility;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import g49.d;
import hq9.a1;
import hq9.b1;
import hq9.b5;
import hq9.d0;
import hq9.g;
import hq9.g4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public static final c a = null;
    public static final List<String> b = null;

    public static final class a {
        public final boolean a;
        public final List<String> b;
        public final boolean c;
        public final boolean d;
        public final String e;
        public final String f;
        public final String g;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = ((r0 * 31) + this.b.hashCode()) * 31;
            if (this.c == false) goto L9;
            int r3 = 1231;
        L10:
            int r4 = (r2 + r3) * 31;
            if (this.d == true) goto L15;
            r1 = 1237;
        L15:
            return ((((((r4 + r1) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
        L9:
            r3 = 1237;
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "ConfigState(rtcEnabled=" + this.a + ", supportLinks=" + this.b + ", videoStreamingEnabled=" + this.c + ", showEntrance=" + this.d + ", transport=" + this.e + ", controlMode=" + this.f + ", activeLink=" + this.g + ')';
        }

        public a(boolean r2, List<String> r3, boolean r4, boolean r5, String r6, String r7, String r8) {
            Intrinsics.checkNotNullParameter(r3, "supportLinks");
            Intrinsics.checkNotNullParameter(r6, "transport");
            Intrinsics.checkNotNullParameter(r7, "controlMode");
            Intrinsics.checkNotNullParameter(r8, "activeLink");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DoraXLinkTransportMode.values().length];
            r0[DoraXLinkTransportMode.WIFI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DoraXLinkTransportMode.BLUETOOTH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DoraXLinkTransportMode.OFF.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public c() {
    }

    static {
        a = new c();
        b = CollectionsKt.listOf(new String[]{"spp", "p2p"});
    }

    public static a b() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        String r1 = null;
        if (r0 == null) goto L6;
        a1 r2 = r0.getDoraXLinkCommonConfig();
        if (r2 == null) goto L6;
    L7:
        g r3 = r2.a;
        if (r3 == null) goto L12;
        d0 r4 = r3.a;
        if (r4 == null) goto L12;
        g4 r5 = r4.a;
    L13:
        if (r3 == null) goto L17;
        b1 r6 = r3.b;
        if (r6 == null) goto L17;
        b5 r7 = r6.a;
    L18:
        if (r5 == null) goto L20;
        List r8 = r5.b;
    L22:
        if (r8 != null) goto L24;
        List<String> r12 = b;
    L38:
        if (r5 == null) goto L42;
        Boolean r9 = r5.a;
        if (r9 == null) goto L42;
        boolean r11 = r9.booleanValue();
    L43:
        if (r7 == null) goto L47;
        Boolean r10 = r7.a;
        if (r10 == null) goto L47;
        boolean r13 = r10.booleanValue();
    L48:
        if (r7 == null) goto L52;
        Boolean r14 = r7.b;
        if (r14 == null) goto L52;
        boolean r15 = r14.booleanValue();
    L53:
        if (r7 == null) goto L56;
        String r16 = r7.c;
        if (r16 == null) goto L56;
    L57:
        String r17 = r16;
        if (r7 == null) goto L61;
        r1 = r7.d;
    L61:
        if (Intrinsics.areEqual(r1, "preset") == false) goto L63;
        String r18 = "preset";
    L64:
        if (r7 == null) goto L69;
        String r20 = r7.e;
        if (r20 == null) goto L69;
        String r110 = r20;
    L71:
        return new a(r11, r12, r13, r15, r17, r18, r110);
    L69:
        r110 = "spp";
        goto L71
    L63:
        r18 = "user_select";
    L56:
        r16 = FlowProtocolAbility.FEATURE_BLUETOOTH_RTC;
    L52:
        r15 = false;
    L47:
        r13 = false;
    L42:
        r11 = true;
        goto L43
    L24:
        ArrayList r21 = new ArrayList();
        Iterator r22 = r8.iterator();
    L26:
        if (r22.hasNext() == false) goto L36;
        Object r23 = r22.next();
        String r24 = (String) r23;
        if (Intrinsics.areEqual(r24, "spp") == false) goto L30;
    L33:
        boolean r25 = true;
    L34:
        if (r25 == false) goto L26;
        r21.add(r23);
        goto L26
    L30:
        if (Intrinsics.areEqual(r24, "p2p") == true) goto L33;
        r25 = false;
        goto L34
    L36:
        r12 = r21;
        goto L38
    L20:
        r8 = null;
    L17:
        r7 = null;
    L12:
        r5 = null;
    L6:
        d.b("DoraXLinkStrategy", "currentState: IDoraService is null, fallback to empty DoraXLinkCommonConfig");
        r2 = new a1(null);
        goto L7
    }

    public static String a() {
        a r0 = b();
        return "rtcEnabled=" + r0.a + ", supportLinks=" + r0.b + ", videoStreamingEnabled=" + r0.c + ", showEntrance=" + r0.d + ", transport=" + r0.e + ", controlMode=" + r0.f + ", activeLink=" + r0.g + ", videoStreamingAvailable=" + h(r0);
    }

    public static boolean g() {
        return Intrinsics.areEqual(b().f, "user_select");
    }

    public static boolean j() {
        a r0 = b();
        if (h(r0) == true) goto L5;
    L7:
        return false;
    L5:
        if (r0.d == false) goto L7;
        return true;
    }

    public static boolean h(a r2) {
        if (r2.a == true) goto L5;
    L11:
        return false;
    L5:
        if (r2.c == false) goto L11;
        if (Intrinsics.areEqual(r2.e, FlowProtocolAbility.FEATURE_BLUETOOTH_RTC) == false) goto L11;
        if ((!r2.b.isEmpty()) == false) goto L11;
        return true;
    }

    public static List i(boolean r4) {
        a r0 = b();
        if (h(r0) == false) goto L18;
        if (r0.d == false) goto L18;
        if (Intrinsics.areEqual(r0.f, "user_select") == false) goto L18;
        List r1 = CollectionsKt.mutableListOf(new DoraXLinkTransportMode[]{DoraXLinkTransportMode.OFF});
        if (r0.b.contains("spp") == false) goto L13;
        r1.add(DoraXLinkTransportMode.BLUETOOTH);
    L13:
        if (r0.b.contains("p2p") == false) goto L16;
        if (r4 == false) goto L16;
        r1.add(DoraXLinkTransportMode.WIFI);
    L16:
        return r1;
    L18:
        return CollectionsKt.emptyList();
    }

    public static DoraXLinkTransportMode d(boolean r1, boolean r2, boolean r3) {
        return c(b(), r1, r2, r3);
    }

    public static DoraXLinkTransportMode c(a r2, boolean r3, boolean r4, boolean r5) {
        if (h(r2) == true) goto L7;
        return DoraXLinkTransportMode.OFF;
    L7:
        if (Intrinsics.areEqual(r2.f, "user_select") == true) goto L9;
        String r6 = r2.g;
        if (Intrinsics.areEqual(r6, "p2p") == false) goto L23;
        DoraXLinkTransportMode r7 = DoraXLinkTransportMode.WIFI;
    L27:
        return f(r7, r2, r5, true);
    L23:
        if (Intrinsics.areEqual(r6, "spp") == false) goto L25;
        r7 = DoraXLinkTransportMode.BLUETOOTH;
        goto L27
    L25:
        r7 = DoraXLinkTransportMode.OFF;
        goto L27
    L9:
        if (r2.d == false) goto L11;
        DoraXLinkTransportMode.Companion.getClass();
        if (r4 == false) goto L15;
        DoraXLinkTransportMode r8 = DoraXLinkTransportMode.WIFI;
    L28:
        return f(r8, r2, r5, false);
    L15:
        if (r3 == false) goto L17;
        r8 = DoraXLinkTransportMode.BLUETOOTH;
        goto L28
    L17:
        r8 = DoraXLinkTransportMode.OFF;
        goto L28
    L11:
        return DoraXLinkTransportMode.OFF;
    }

    public static DoraXLinkTransportMode e(boolean r1, boolean r2, boolean r3, boolean r4) {
        a r0 = b();
        DoraXLinkTransportMode r5 = c(r0, r1, r2, r3);
        if (r4 == false) goto L5;
        return r5;
    L5:
        if (r5 == DoraXLinkTransportMode.WIFI) goto L7;
        return r5;
    L7:
        if (r0.b.contains("spp") == true) goto L9;
        return r5;
    L9:
        return DoraXLinkTransportMode.BLUETOOTH;
    }

    public static DoraXLinkTransportMode f(DoraXLinkTransportMode r2, a r3, boolean r4, boolean r5) {
        int r6 = b.a[r2.ordinal()];
        if (r6 == 1) goto L16;
        if (r6 == 2) goto L12;
        if (r6 != 3) goto L10;
        return DoraXLinkTransportMode.OFF;
    L10:
        throw new NoWhenBranchMatchedException();
    L12:
        if (r3.b.contains("spp") == false) goto L27;
        return DoraXLinkTransportMode.BLUETOOTH;
    L27:
        return DoraXLinkTransportMode.OFF;
    L16:
        if (r3.b.contains("p2p") == false) goto L19;
        if (r4 == false) goto L19;
        return DoraXLinkTransportMode.WIFI;
    L19:
        if (r5 == false) goto L24;
        if (r3.b.contains("spp") == false) goto L24;
        return DoraXLinkTransportMode.BLUETOOTH;
    L24:
        return DoraXLinkTransportMode.OFF;
    }
}
