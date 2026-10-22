package com.bytedance.android.ec.core.monitor;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final String a;
        public final List<String> b;

        public a() {
            throw null;
        }

        public a(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "key");
            Intrinsics.checkNotNullParameter(r11, "checkRule");
            List<String> r12 = CollectionsKt.listOf(r11);
            Intrinsics.checkNotNullParameter(r10, "key");
            Intrinsics.checkNotNullParameter(r12, "checkRules");
            this.a = r10;
            this.b = r12;
        }
    }

    static {
    }

    public static boolean c(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "checkRule");
        int r0 = r11.hashCode();
        if (r0 == (-1276666629)) goto L27;
        if (r0 == (-850029332)) goto L18;
        if (r0 == 1612879795) goto L10;
    L35:
        return true;
    L10:
        if (r11.equals("is_json_string") == false) goto L35;
        if (cg4.a.a(r10) == false) goto L41;
        new JSONObject(r10);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return false;
    L41:
        return false;
    L18:
        if (r11.equals("valid_number") == false) goto L35;
        if (r10 == null) goto L43;
        if (CastLongProtector.parseLong(r10) > 0) goto L35;
        return false;
    L24:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return false;
    L43:
        return false;
    L27:
        if (r11.equals("presence") == false) goto L35;
        if (r10 != null) goto L30;
    L33:
        boolean r12 = true;
    L34:
        if (r12 == false) goto L35;
        return false;
    L30:
        if (r10.length() == 0) goto L33;
        r12 = false;
        goto L34
    }

    public static void a(String r12, String r13, String r14, List r15) {
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r14, "destPage");
        Intrinsics.checkNotNullParameter(r15, "checkParams");
        Uri r0 = UriProtector.parse(r12);
        Iterator r16 = r15.iterator();
    L4:
        if (r16.hasNext() == false) goto L11;
        a r1 = (a) r16.next();
        String r10 = UriProtector.getQueryParameter(r0, r1.a);
        Iterator<T> r11 = r1.b.iterator();
    L7:
        if (r11.hasNext() == false) goto L4;
        String r17 = (String) r11.next();
        if (c(r10, r17) == true) goto L7;
        int r18 = d.a;
        d.c(r13, r14, r12, r1.a, r17, null, 32);
        goto L7
    }

    public static void b(String r10, String r11, JSONObject r12, List r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "scene");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "checkParams");
        Uri r14 = UriProtector.parse(r10);
        Iterator r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L11;
        a r0 = (a) r15.next();
        String r1 = UriProtector.getQueryParameter(r14, r0.a);
        Iterator<T> r16 = r0.b.iterator();
    L7:
        if (r16.hasNext() == false) goto L4;
        String r17 = (String) r16.next();
        if (c(r1, r17) == true) goto L7;
        int r18 = d.a;
        d.d(r0.a, r17, null, r11, r12);
        goto L7
    }
}
