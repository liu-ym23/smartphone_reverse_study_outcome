package com.larus.dora.impl.resource;

import com.google.gson.Gson;
import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f {
    public static final f a = null;
    public static final Gson b = null;
    public static final Regex c = null;
    public static final Regex d = null;
    public static final Regex e = null;

    public f() {
    }

    static {
        a = new f();
        b = new Gson();
        c = new Regex("[A-Fa-f0-9]{64}");
        d = new Regex("[A-Za-z0-9][A-Za-z0-9._-]*");
        e = new Regex("[A-Za-z0-9][A-Za-z0-9._-]*");
    }

    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v15 */
    public static g a(String r21) {
        Intrinsics.checkNotNullParameter(r21, "rawResponse");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r0 = Result.constructor-impl((b) b.fromJson(r21, b.class));     // Catch: Throwable -> L5
    L7:
        DoraEnableScope r2 = null;
        if (Result.isFailure-impl(r0) == false) goto L10;
        r0 = null;
    L10:
        b r3 = (b) r0;
        if (r3 == null) goto L14;
        Map<String, d> r4 = r3.b();
        if (r4 == null) goto L14;
    L21:
        LinkedHashMap r5 = new LinkedHashMap();
        LinkedHashSet r6 = new LinkedHashSet();
        Iterator<Map.Entry<String, d>> r7 = r4.entrySet().iterator();
    L23:
        if (r7.hasNext() == false) goto L292;
        Map.Entry<String, d> r8 = r7.next();
        String r9 = r8.getKey();
        d r10 = r8.getValue();
        if (r9 == null) goto L291;
        a.getClass();
        if (Intrinsics.areEqual(r9, "dora_smart_hardware_plum") == false) goto L30;
        DoraEnableScope r11 = DoraEnableScope.G1;
    L33:
        if (r11 == null) goto L291;
        if (r10 == null) goto L287;
        Intrinsics.checkNotNullParameter(r11, "scope");
        Intrinsics.checkNotNullParameter(r10, "config");
        if (r11 == DoraEnableScope.G_SERIES) goto L168;
        Map<String, j> r12 = r10.a();
        if (r12 == null) goto L287;
        Collection<j> r13 = r12.values();
        if (r13 == null) goto L287;
        List r14 = CollectionsKt.filterNotNull(r13);
        if (r14 == null) goto L287;
        Iterator r15 = r14.iterator();
        ?? r16 = 0;
        Object r17 = r2;
        boolean r18 = false;
    L47:
        if (r15.hasNext() == false) goto L64;
        Object r20 = r15.next();
        String r110 = ((j) r20).a();
        int r111 = e.a[r11.ordinal()];
        if (r111 == 1) goto L58;
        if (r111 != 2) goto L52;
        String r112 = DoraObricDeviceHomeViewModel.PRODUCT_CODE_G2;
    L60:
        if (Intrinsics.areEqual(r110, r112) == false) goto L47;
        if (r18 == true) goto L65;
        r17 = r20;
        r18 = true;
    L65:
        r17 = r2;
    L66:
        DoraEnableScope r22 = (j) r17;
        if (r22 == null) goto L287;
        Integer r23 = r22.b();
        if (r23 != null) goto L72;
    L74:
        boolean r24 = false;
    L75:
        if (r24 == true) goto L78;
        r22 = r2;
    L78:
        if (r22 == null) goto L287;
        DoraEnableScope r25 = r22.c();
        if (r25 == null) goto L287;
        if ((!r25.isEmpty()) == true) goto L85;
        r25 = r2;
    L85:
        if (r25 == null) goto L287;
        Map<String, String> r26 = r22.d();
        if (r26 == null) goto L168;
        Set r27 = r25.keySet();
        if ((r27 instanceof Collection) == true) goto L93;
    L95:
        Iterator r28 = r27.iterator();
    L97:
        if (r28.hasNext() == false) goto L104;
        if (((String) r28.next()) != null) goto L101;
        boolean r30 = true;
    L102:
        if (r30 == false) goto L97;
        boolean r31 = true;
    L105:
        if (r31 == true) goto L287;
        Collection r32 = r25.values();
        if ((r32 instanceof Collection) == true) goto L109;
    L111:
        Iterator r33 = r32.iterator();
    L113:
        if (r33.hasNext() == false) goto L120;
        if (((i) r33.next()) != null) goto L117;
        boolean r34 = true;
    L118:
        if (r34 == false) goto L113;
        boolean r35 = true;
    L121:
        if (r35 == true) goto L287;
        Set<String> r36 = r26.keySet();
        if ((r36 instanceof Collection) == true) goto L125;
    L127:
        Iterator<T> r37 = r36.iterator();
    L129:
        if (r37.hasNext() == false) goto L136;
        if (((String) r37.next()) != null) goto L133;
        boolean r38 = true;
    L134:
        if (r38 == false) goto L129;
        boolean r40 = true;
    L137:
        if (r40 == true) goto L287;
        Collection<String> r41 = r26.values();
        if ((r41 instanceof Collection) == true) goto L141;
    L143:
        Iterator<T> r42 = r41.iterator();
    L145:
        if (r42.hasNext() == false) goto L152;
        if (((String) r42.next()) != null) goto L149;
        boolean r43 = true;
    L150:
        if (r43 == false) goto L145;
        boolean r44 = true;
    L153:
        if (r44 == true) goto L287;
        if (Intrinsics.areEqual(r25.keySet(), r26.keySet()) == false) goto L168;
        LinkedHashMap r45 = new LinkedHashMap();
        Iterator r46 = r25.entrySet().iterator();
    L160:
        if (r46.hasNext() == false) goto L286;
        Map.Entry r47 = (Map.Entry) r46.next();
        String r113 = (String) r47.getKey();
        i r114 = (i) r47.getValue();
        f r48 = a;
        if (r113 == null) goto L168;
        if (r114 == null) goto L168;
        String r210 = r26.get(r113);
        if (r210 == null) goto L168;
        r48.getClass();
        if (StringsKt.isBlank(r113) == false) goto L172;
    L194:
        boolean r50 = false;
    L195:
        if (r50 == false) goto L279;
        String r51 = r114.b();
        if (r51 == null) goto L279;
        DoraEnableScope r52 = StringsKt.trim(r51).toString();
        if (r52 == null) goto L279;
        if (e.matches(r52) == false) goto L204;
        DoraEnableScope r115 = r52;
    L205:
        if (r115 == null) goto L279;
        DoraEnableScope r53 = r114.d();
        if (r53 == null) goto L279;
        if (r53.longValue() <= 0) goto L211;
        boolean r116 = true;
    L212:
        if (r116 == true) goto L215;
        r53 = r2;
    L215:
        if (r53 == null) goto L279;
        long r117 = r53.longValue();
        DoraEnableScope r54 = r114.c();
        if (r54 == null) goto L279;
        if (c.matches(r54) == true) goto L222;
        r54 = r2;
    L222:
        if (r54 == null) goto L279;
        String r118 = r54.toLowerCase(Locale.US);
        if (r118 == null) goto L279;
        DoraEnableScope r55 = StringsKt.trim(r210).toString();
        if (StringsKt.startsWith$default(r55, '`', r16, 2, r2) == true) goto L228;
    L233:
        boolean r119 = StringsKt.contains$default(r55, '`', r16, 2, r2);
        DoraEnableScope r56 = r55;
        if (r119 == false) goto L237;
        DoraEnableScope r120 = r2;
    L246:
        if (r120 == null) goto L279;
        if (Intrinsics.areEqual(r114.a(), "application/zip") == false) goto L279;
        Result.Companion r57 = Result.Companion;     // Catch: Throwable -> L264
        URI r58 = new URI(r120);     // Catch: Throwable -> L264
        if (Intrinsics.areEqual(r58.getScheme(), "https") == false) goto L261;
        String r60 = r58.getHost();     // Catch: Throwable -> L264
        if (r60 != null) goto L255;
    L258:
        boolean r61 = true;
    L259:
        if (r61 == true) goto L261;
        boolean r62 = true;
    L262:
        Object r63 = Result.constructor-impl(Boolean.valueOf(r62));     // Catch: Throwable -> L264
    L266:
        Boolean r64 = Boolean.FALSE;
        if (Result.isFailure-impl(r63) == false) goto L270;
        r63 = r64;
    L270:
        if (((Boolean) r63).booleanValue() == false) goto L279;
        String r65 = r114.e();
        if (r65 != null) goto L275;
    L277:
        String r121 = null;
    L278:
        n r66 = new n(r115, r117, r121, r118, r113, r120);
    L280:
        if (r66 == null) goto L287;
        if (r45.put(r66.a, r66) != null) goto L287;
        r2 = null;
        r16 = 0;
        goto L160
    L275:
        if ((!StringsKt.isBlank(r65)) == false) goto L277;
        r121 = r65;
        goto L278
    L255:
        if (StringsKt.isBlank(r60) == true) goto L258;
        r61 = false;
    L261:
        r62 = false;
    L264:
        th = move-exception;
        Result.Companion r67 = Result.Companion;
        r63 = Result.constructor-impl(ResultKt.createFailure(th));
    L237:
        if ((!StringsKt.isBlank(r56)) == true) goto L239;
    L241:
        boolean r122 = false;
    L242:
        if (r122 == true) goto L245;
        r56 = r2;
    L245:
        r120 = r56;
        goto L246
    L239:
        if (StringsKt.contains$default(r56, '`', r16, 2, r2) == true) goto L241;
        r122 = true;
        goto L242
    L228:
        if (StringsKt.endsWith$default(r55, '`', r16, 2, r2) == false) goto L233;
        if (r55.length() <= 2) goto L232;
        r2 = null;
        r56 = r55.substring(1, r55.length() - 1);
        goto L237
    L232:
        r2 = null;
        goto L233
    L211:
        r116 = false;
        goto L212
    L204:
        r115 = r2;
    L279:
        r66 = null;
        goto L280
    L172:
        if (StringsKt.startsWith$default(r113, '/', r16, 2, r2) == true) goto L194;
        if (StringsKt.contains$default(r113, "://", r16, 2, r2) == true) goto L194;
        if (StringsKt.contains$default(r113, '\\', r16, 2, r2) == true) goto L194;
        char[] r123 = new char[1];
        r123[r16] = '/';
        List r68 = StringsKt.split$default(r113, r123, false, 0, 6, null);
        if (r68.size() < 2) goto L194;
        List r70 = r68;
        Regex r124 = d;
        if ((r70 instanceof Collection) == true) goto L183;
    L185:
        Iterator r71 = r70.iterator();
    L187:
        if (r71.hasNext() == false) goto L191;
        if (r124.matches((CharSequence) r71.next()) == true) goto L187;
        boolean r72 = false;
    L192:
        if (r72 == false) goto L194;
        r50 = true;
    L191:
        r72 = true;
        goto L192
    L183:
        if (r70.isEmpty() == false) goto L185;
    L286:
        DoraEnableScope r73 = new c(r11, r45);
    L288:
        if (r73 != null) goto L290;
        r6.add(r11);
        goto L291
    L290:
        r5.put(r11, r73);
        goto L291
    L149:
        r43 = false;
    L152:
        r44 = false;
        goto L153
    L141:
        if (r41.isEmpty() == false) goto L143;
    L133:
        r38 = false;
    L136:
        r40 = false;
        goto L137
    L125:
        if (r36.isEmpty() == false) goto L127;
    L117:
        r34 = false;
    L120:
        r35 = false;
        goto L121
    L109:
        if (r32.isEmpty() == false) goto L111;
    L101:
        r30 = false;
    L104:
        r31 = false;
        goto L105
    L93:
        if (r27.isEmpty() == false) goto L95;
    L72:
        if (r23.intValue() != 1) goto L74;
        r24 = true;
        goto L75
    L52:
        if (r111 == 3) goto L56;
        throw new NoWhenBranchMatchedException();
    L56:
        throw new IllegalStateException("G_SERIES is not a device feature".toString());
    L58:
        r112 = DoraObricDeviceHomeViewModel.PRODUCT_CODE_G1;
        goto L60
    L64:
        if (r18 == true) goto L66;
    L168:
        r73 = r2;
    L287:
        r73 = null;
        goto L288
    L30:
        if (Intrinsics.areEqual(r9, "dora_smart_hardware_peach") == false) goto L32;
        r11 = DoraEnableScope.G2;
        goto L33
    L32:
        r11 = r2;
    L291:
        r2 = null;
        goto L23
    L292:
        LinkedHashMap r74 = new LinkedHashMap();
        Iterator r75 = r5.entrySet().iterator();
    L294:
        if (r75.hasNext() == false) goto L305;
        Map.Entry r76 = (Map.Entry) r75.next();
        DoraEnableScope r77 = (DoraEnableScope) r76.getKey();
        Iterator<T> r78 = ((c) r76.getValue()).b.values().iterator();
    L297:
        if (r78.hasNext() == false) goto L294;
        n r80 = (n) r78.next();
        Pair r81 = (Pair) r74.putIfAbsent(r80.a, TuplesKt.to(r77, r80));
        if (r81 == null) goto L297;
        if (((n) r81.getSecond()).b != r80.b) goto L304;
        if (Intrinsics.areEqual(((n) r81.getSecond()).d, r80.d) == true) goto L297;
    L304:
        r6.add(r81.getFirst());
        r6.add(r77);
        goto L297
    L305:
        Iterator r82 = r6.iterator();
    L307:
        if (r82.hasNext() == false) goto L310;
        r5.remove((DoraEnableScope) r82.next());
        goto L307
    L310:
        return new g(r5, r6);
    L14:
        if (r3 == null) goto L18;
        b.a r83 = r3.a();
        if (r83 == null) goto L18;
        r4 = r83.a();
    L19:
        if (r4 != null) goto L21;
        return null;
    L18:
        r4 = null;
    L5:
        th = move-exception;
        Result.Companion r84 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
