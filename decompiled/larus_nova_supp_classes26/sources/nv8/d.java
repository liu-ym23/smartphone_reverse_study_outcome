package nv8;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.google.gson.JsonArray;
import com.larus.business.accessbility.impl.AccessibilityHttpService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d implements j6.a {
    public final Lazy a;
    public final Lazy b;
    public String c;

    public static final class a {
    }

    static {
    }

    public final j6.b a() {
        boolean r3 = false;
        if (AppHost.a.isDebug() == false) goto L33;
        FLogger r0 = FLogger.a;
        r0.i("AccessibilityHttpConfigProvider", "[getConfigFile] Version is debug, get debug config data");
        Call<i> r5 = ((AccessibilityHttpService) this.b.getValue()).getAccessibilityDebugConfigData();
        if (r5 == null) goto L7;
        SsResponse r6 = r5.execute();
    L8:
        StringBuilder r7 = new StringBuilder("[getAccessibilityDebugConfigData] Success is ");
        if (r6 == null) goto L11;
        Boolean r8 = Boxing.boxBoolean(r6.isSuccessful());
    L12:
        r7.append(r8);
        r0.i("AccessibilityHttpConfigProvider", r7.toString());
        if (r6 != null) goto L15;
    L17:
        if (r3 == false) goto L89;
        i r4 = (i) r6.body();
        if (r4 == null) goto L92;
        j r9 = r4.a();
        if (r9 == null) goto L93;
        Long r10 = r9.b();
        if (r10 == null) goto L90;
        r10.longValue();
        b r11 = r9.a();
        if (r11 == null) goto L91;
        JsonArray r12 = r11.a();
        if (r12 == null) goto L94;
        r0.i("AccessibilityHttpConfigProvider", "[getAccessibilityDebugConfigData] data is " + r12);
        return new j6.b(r12.toString(), true);
    L94:
        return null;
    L91:
        return null;
    L90:
        return null;
    L93:
        return null;
    L92:
        return null;
    L89:
        return null;
    L15:
        if (r6.isSuccessful() != true) goto L17;
        r3 = true;
        goto L17
    L11:
        r8 = null;
        goto L12
    L7:
        r6 = null;
        goto L8
    L33:
        FLogger r1 = FLogger.a;
        r1.i("AccessibilityHttpConfigProvider", "[getConfigFile] Version is release, get release config data");
        Call<l> r13 = ((AccessibilityHttpService) this.a.getValue()).getAccessibilityConfig(this.c);
        if (r13 == null) goto L36;
        SsResponse r14 = r13.execute();
    L37:
        StringBuilder r15 = new StringBuilder("[getAccessibilityReleaseConfigData] Success is ");
        if (r14 == null) goto L40;
        Boolean r16 = Boxing.boxBoolean(r14.isSuccessful());
    L41:
        r15.append(r16);
        r1.i("AccessibilityHttpConfigProvider", r15.toString());
        if (r14 != null) goto L44;
    L46:
        boolean r17 = false;
    L47:
        if (r17 == false) goto L95;
        l r18 = (l) r14.body();
        if (r18 == null) goto L97;
        k r19 = r18.a();
        if (r19 == null) goto L98;
        String r20 = r19.c();
        String r21 = r19.a();
        String r22 = r19.b();
        if (r20 != null) goto L57;
    L60:
        boolean r23 = true;
    L61:
        if (r23 == false) goto L64;
        r20 = r21;
    L64:
        if (r20 != null) goto L66;
    L69:
        boolean r24 = true;
    L70:
        if (r24 == true) goto L99;
        Call<h> r25 = ((AccessibilityHttpService) this.a.getValue()).getAccessibilityData(r20);
        if (r25 == null) goto L75;
        SsResponse r26 = r25.execute();
    L76:
        if (r26 != null) goto L78;
    L80:
        if (r3 == false) goto L96;
        h r27 = (h) r26.body();
        if (r27 == null) goto L100;
        r1.i("AccessibilityHttpConfigProvider", "[getAccessibilityReleaseConfigData] data is " + r27);
        if (r22 != null) goto L87;
        r22 = "";
    L87:
        this.c = r22;
        return new j6.b(String.valueOf(r27.a()), true);
    L100:
        return null;
    L96:
        return null;
    L78:
        if (r26.isSuccessful() != true) goto L80;
        r3 = true;
        goto L80
    L75:
        r26 = null;
        goto L76
    L99:
        return null;
    L66:
        if (r20.length() == 0) goto L69;
        r24 = false;
        goto L70
    L57:
        if (r20.length() == 0) goto L60;
        r23 = false;
        goto L61
    L98:
        return null;
    L97:
        return null;
    L95:
        return null;
    L44:
        if (r14.isSuccessful() != true) goto L46;
        r17 = true;
        goto L47
    L40:
        r16 = null;
        goto L41
    L36:
        r14 = null;
        goto L37
    }

    public d() {
        this.a = LazyKt.lazy(new b(this));
        this.b = LazyKt.lazy(new c(this));
        this.c = "";
    }
}
