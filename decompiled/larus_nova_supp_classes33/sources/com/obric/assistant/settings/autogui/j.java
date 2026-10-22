package com.obric.assistant.settings.autogui;

import com.obric.assistant.AutoGuiAppScopeConfig;
import com.obric.assistant.settings.ObricAppListMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final List<com.obric.assistant.settings.b> a;
        public final List<com.obric.assistant.settings.b> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Result(availableApps=" + this.a + ", unavailableApps=" + this.b + ')';
        }

        public a(List<com.obric.assistant.settings.b> r2, List<com.obric.assistant.settings.b> r3) {
            Intrinsics.checkNotNullParameter(r2, "availableApps");
            Intrinsics.checkNotNullParameter(r3, "unavailableApps");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public static a a(List r19, List r20, Set r21, Set r22, Set r23, Set r24, ObricAppListMode r25, AutoGuiAppScopeConfig r26) {
        Intrinsics.checkNotNullParameter(r19, "launcherApps");
        Intrinsics.checkNotNullParameter(r21, "systemBlockedPackages");
        Intrinsics.checkNotNullParameter(r25, "cloudMode");
        Intrinsics.checkNotNullParameter(r26, "config");
        boolean r6 = true;
        if (r20 == null) goto L24;
        ArrayList r11 = new ArrayList();
        Iterator r10 = r20.iterator();
    L6:
        if (r10.hasNext() == false) goto L23;
        com.obric.assistant.settings.r r12 = (com.obric.assistant.settings.r) r10.next();
        String r13 = r12.e();
        if (r13 == null) goto L20;
        String r14 = StringsKt.trim(r13).toString();
        if (r14 == null) goto L20;
        if (r14.length() <= 0) goto L14;
        boolean r15 = true;
    L15:
        if (r15 == true) goto L18;
        r14 = null;
    L18:
        if (r14 == null) goto L20;
        Pair r16 = TuplesKt.to(r14, r12);
    L21:
        if (r16 == null) goto L6;
        r11.add(r16);
        goto L6
    L14:
        r15 = false;
    L20:
        r16 = null;
        goto L21
    L23:
        Map r17 = MapsKt.toMap(r11);
    L25:
        if (r17 != null) goto L28;
        r17 = MapsKt.emptyMap();
    L28:
        if (r25 != ObricAppListMode.WHITE_LIST) goto L30;
        boolean r5 = true;
    L31:
        ArrayList r18 = new ArrayList();
        ArrayList r110 = new ArrayList();
        Iterator r0 = r19.iterator();
    L33:
        if (r0.hasNext() == false) goto L93;
        com.obric.assistant.settings.b r111 = (com.obric.assistant.settings.b) r0.next();
        com.obric.assistant.settings.r r112 = (com.obric.assistant.settings.r) r17.get(r111.a);
        if (r26.getEnableSaepRestrictedPackages() == false) goto L44;
        if (r22 != null) goto L38;
    L40:
        boolean r113 = false;
    L41:
        if (r113 == false) goto L44;
        com.obric.assistant.settings.b r8 = com.obric.assistant.settings.b.a(r111, null, 0, 63);
    L89:
        if (r8 == null) goto L90;
        r110.add(r8);
        goto L33
    L90:
        r18.add(r111);
        goto L33
    L38:
        if (r22.contains(r111.a) != r6) goto L40;
        r113 = true;
    L44:
        if (r26.getEnableSaepRestrictedPackages() == false) goto L52;
        if (r23 != null) goto L47;
    L49:
        boolean r114 = false;
    L50:
        if (r114 == false) goto L52;
    L88:
        r8 = null;
        goto L89
    L47:
        if (r23.contains(r111.a) != r6) goto L49;
        r114 = true;
    L52:
        if (r112 == null) goto L79;
        List<String> r9 = r112.c();
        if (r9 == null) goto L72;
        ArrayList r115 = new ArrayList();
        Iterator<T> r27 = r9.iterator();
    L57:
        if (r27.hasNext() == false) goto L73;
        String r116 = (String) r27.next();
        if (r116 == null) goto L68;
        String r117 = StringsKt.trim(r116).toString();
        if (r117 == null) goto L68;
        if (r117.length() <= 0) goto L65;
        boolean r118 = true;
    L66:
        if (r118 == false) goto L68;
        String r7 = r117;
    L69:
        if (r7 == null) goto L57;
        r115.add(r7);
        goto L57
    L65:
        r118 = false;
    L68:
        r7 = null;
    L73:
        Integer r28 = r112.d();
        if (r28 == null) goto L76;
        int r29 = r28.intValue();
    L77:
        r8 = com.obric.assistant.settings.b.a(r111, r115, r29, 55);
    L81:
        r6 = true;
        goto L89
    L76:
        r29 = 0;
        goto L77
    L72:
        r115 = null;
        goto L73
    L79:
        if (r21.contains(r111.a) == false) goto L82;
        r8 = com.obric.assistant.settings.b.a(r111, null, 2, 63);
        goto L81
    L82:
        if (r5 == false) goto L87;
        if (r24 != null) goto L85;
    L86:
        r6 = true;
        r8 = com.obric.assistant.settings.b.a(r111, null, 1, 63);
        goto L89
    L85:
        if (r24.contains(r111.a) == false) goto L86;
    L87:
        r6 = true;
        goto L88
    L93:
        return new a(r18, r110);
    L30:
        r5 = false;
        goto L31
    L24:
        r17 = null;
        goto L25
    }
}
