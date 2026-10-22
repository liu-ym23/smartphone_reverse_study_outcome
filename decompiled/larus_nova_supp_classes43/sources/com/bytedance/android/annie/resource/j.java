package com.bytedance.android.annie.resource;

import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j implements com.bytedance.android.annie.service.resource.f {
    public j() {
    }

    @Override // com.bytedance.android.annie.service.resource.f
    public final List<String> r() {
        AnnieGeckoClient r0 = i.a;
        if (r0 == null) goto L9;
        List r1 = ResLoadUtils.getAllLocalChannels(r0.b, r0.g);
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r11 = r1.iterator();
    L6:
        if (r11.hasNext() == false) goto L11;
        r10.add((String) ((Pair) r11.next()).first);
        goto L6
    L11:
        return r10;
    L9:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.annie.service.resource.f
    public final String Z(final String r10) {
        AnnieGeckoClient r0 = i.a;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r10 != null) goto L7;
    L10:
        boolean r11 = true;
    L11:
        if (r11 == false) goto L13;
    L47:
        return "";
    L13:
        if (StringsKt.startsWith$default(r10, "data:image", false, 2, null) == true) goto L47;
        if (StringsKt.startsWith$default(r10, "app://", false, 2, null) == false) goto L22;
        if (r10 == null) goto L21;
        String r12 = "res:///" + r10.substring(6);
    L53:
        return r12;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L22:
        kotlin.Pair r1 = (kotlin.Pair) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(AnnieConfigSettingKeys.LIVE_LYNX_GECKO_CHANNEL_LIST.a()), new AnnieGeckoClient$getLynxRedirectImageUrl$1(r10)));
        if (r1 == null) goto L47;
        String r13 = (String) r1.component1();
        int r14 = (((Number) r1.component2()).intValue() + r13.length()) + 1;
        if (r10 == null) goto L46;
        String r15 = r10.substring(r14);
        String r16 = r13 + '/' + r15;
        Intrinsics.checkNotNullParameter(r16, "relativePath");
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L30
        Object r18 = Result.constructor-impl(Boolean.valueOf(r0.e.a.a(r16)));     // Catch: Throwable -> L30
    L32:
        Boolean r19 = Boolean.FALSE;
        if (Result.isFailure-impl(r18) == false) goto L36;
        r18 = r19;
    L36:
        if (((Boolean) r18).booleanValue() == false) goto L47;
        StringBuilder r20 = new StringBuilder();
        r20.append(r0.h);
        r20.append('/');
        r20.append(r0.g);
        r20.append('/');
        r20.append(r13);
        r20.append('/');
        Intrinsics.checkNotNullParameter(r13, "channel");
        r20.append((Long) ((HashMap) r0.e.b()).get(r13));
        r20.append("/res/");
        r20.append(r15);
        String r21 = r20.toString();
    L43:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L47
    L39:
        if (new PolarisFileWrapper(r21).exists() == false) goto L41;
        r12 = "file://" + r21;     // Catch: Throwable -> L43
        goto L53
    L41:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L43
    L30:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L46:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L7:
        if (StringsKt.isBlank(r10) == true) goto L10;
        r11 = false;
        goto L11
    }

    @Override // com.bytedance.android.annie.service.resource.f
    public final WebResourceResponse j(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        return i.a(r10);
    }
}
