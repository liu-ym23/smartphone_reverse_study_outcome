package lu1;

import com.bytedance.android.livesdk.dynamicstrategy.api.entity.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j {
    public static final n a(com.bytedance.android.livesdk.dynamicstrategy.api.entity.m r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$toDynamicFactor");
        String r0 = r4.name;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        return null;
    L13:
        if (r4.featureType != 6) goto L22;
        s r5 = r4.nfaInfo;
        if (r5 != null) goto L17;
        return null;
    L17:
        if (r5.c() == 2) goto L21;
        if (r5.c() == 3) goto L21;
        return null;
    L21:
        return new l(r0, r5);
    L22:
        com.bytedance.android.livesdk.dynamicstrategy.api.entity.n r6 = r4.featureValue;
        if (r6 != null) goto L26;
        return null;
    L26:
        switch(r6.valType) {
            case 1: goto L45;
            case 2: goto L43;
            case 3: goto L41;
            case 4: goto L39;
            case 5: goto L37;
            case 6: goto L35;
            case 7: goto L33;
            case 8: goto L31;
            case 9: goto L29;
            default: goto L27;
        };
    L27:
        return null;
    L29:
        return new a(r0, r6);
    L31:
        return new i(r0, r6);
    L33:
        return new h(r0, r6);
    L35:
        return new g(r0, r6);
    L37:
        return new f(r0, r6);
    L39:
        return new e(r0, r6);
    L41:
        return new d(r0, r6);
    L43:
        return new c(r0, r6);
    L45:
        return new b(r0, r6);
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }
}
