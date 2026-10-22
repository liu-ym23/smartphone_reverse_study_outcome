package com.bytedance.ies.bullet.forest;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.Scene;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o {
    public static Pair a(p r5, WebResourceRequest r10, com.bytedance.ies.bullet.core.e r11) {
        if (r10 == null) goto L19;
        String r12 = r10.getMethod();
        Locale r13 = Locale.ENGLISH;
        if (r12 == null) goto L17;
        if (Intrinsics.areEqual(r12.toLowerCase(r13), "get") == true) goto L12;
        Boolean r14 = Boolean.FALSE;
        if (r10.isForMainFrame() == false) goto L10;
        Scene r15 = Scene.f4351k;
    L11:
        Pair r16 = TuplesKt.to(r14, r15);
    L13:
        if (r16 == null) goto L19;
        return r16;
    L10:
        r15 = Scene.f4352l;
        goto L11
    L12:
        r16 = r5.h(r10.getUrl().toString(), r10.isForMainFrame(), r11, null);
        goto L13
    L17:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        return TuplesKt.to(Boolean.FALSE, Scene.f4352l);
    }

    public static Pair b(p r10, String r11, boolean r12, com.bytedance.ies.bullet.core.e r13, rd.e r14) {
        Intrinsics.checkNotNullParameter(r11, "url");
        if (StringsKt.isBlank(r11) == true) goto L68;
        if (StringsKt.P(r11, "http") == false) goto L68;
        Uri r5 = Uri.parse(r11);
        Intrinsics.checkNotNullParameter(r11, "url");
        Lazy r15 = com.bytedance.ies.argus.plugin.b.f5129a;
        Intrinsics.checkNotNullParameter(r11, "url");
        boolean r16 = false;
        String r17 = (String) com.bytedance.ies.argus.plugin.b.f5129a.getValue();     // Catch: Exception -> L13
        if (r17 == null) goto L15;
        if (StringsKt.P(r11, r17) != true) goto L15;
        r16 = true;
    L15:
        if (r16 == true) goto L17;
        if (r12 == true) goto L20;
        String r18 = r5.getPath();
        if (r18 == null) goto L66;
        if (StringsKt.k(r18, ".html") == false) goto L26;
    L29:
        Scene r19 = Scene.f4351k;
    L31:
        if (r19 == Scene.f4351k) goto L33;
        Iterator r20 = q.f5413a.iterator();
    L36:
        if (r20.hasNext() == false) goto L40;
        Object r21 = r20.next();
        if (StringsKt.k(r18, (String) r21) == false) goto L36;
    L41:
        if (r21 != null) goto L43;
        GeckoXAdapter.Companion r22 = GeckoXAdapter.Companion;
        if (r22.isCDNMultiVersionResource(r11) == true) goto L64;
        if (r22.canParsed(r11) == true) goto L64;
        Forest r23 = f.a();
        if (r23 != null) goto L51;
    L53:
        if (r13 != null) goto L55;
    L57:
        if (r14 == null) goto L62;
        if (r10.hasGeckoModelInfo(r14) == true) goto L64;
    L62:
        return TuplesKt.to(Boolean.FALSE, Scene.f4352l);
    L55:
        if (r10.hasGeckoModelInfo(r13) != true) goto L57;
    L51:
        if (Forest.isPreloaded$default(r23, r11, null, 2, null) != true) goto L53;
    L64:
        return TuplesKt.to(Boolean.TRUE, Scene.f4352l);
    L43:
        return TuplesKt.to(Boolean.TRUE, Scene.f4352l);
    L40:
        r21 = null;
        goto L41
    L33:
        return TuplesKt.to(Boolean.TRUE, r19);
    L26:
        if (StringsKt.k(r18, ".hml") == true) goto L29;
        r19 = Scene.f4352l;
        goto L31
    L66:
        return TuplesKt.to(Boolean.FALSE, Scene.f4352l);
    L20:
        return TuplesKt.to(Boolean.TRUE, Scene.f4351k);
    L17:
        return TuplesKt.to(Boolean.FALSE, Scene.f4352l);
    L13:
        e = move-exception;
        k5.d.g("SecLinkPlugin", "get seclink host error: " + e, null, 12);
    L68:
        return TuplesKt.to(Boolean.FALSE, Scene.f4352l);
    }

    public static /* synthetic */ Pair c(p r5, String r10, boolean r11, com.bytedance.ies.bullet.core.e r12, rd.e r13, int r14) {
        if ((r14 & 2) == 0) goto L6;
        r11 = false;
    L6:
        if ((r14 & 8) == 0) goto L9;
        r12 = null;
    L9:
        if ((r14 & 16) == 0) goto L12;
        r13 = null;
    L12:
        return r5.h(r10, r11, r12, r13);
    }
}
