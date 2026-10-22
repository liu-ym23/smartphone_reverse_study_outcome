package com.ss.android.lark.docs.sdk.domain;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.EncryptUtil;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DomainService {
    public final Lazy a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public DomainService() {
        Lazy r0 = LazyKt.lazy(DomainService$domainMap$2.INSTANCE);
        this.a = r0;
        Lazy r1 = LazyKt.lazy(DomainService$pathPrefixList$2.INSTANCE);
        this.b = r1;
        ((Map) r0.getValue()).put(EDomainType.DOCS_API, CollectionsKt.listOf("internal-api-space.feishu.cn"));
        ((Map) r0.getValue()).put(EDomainType.DRIVE_STREAM, CollectionsKt.listOf("internal-api-drive-stream.feishu.cn"));
        ((List) r1.getValue()).clear();
        ((List) r1.getValue()).add("space");
    }

    public final Uri a(EDomainType r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "domainType");
        String r4 = BuildConfig.FLAVOR;
        if (r11 != null) goto L5;
        String r5 = BuildConfig.FLAVOR;
    L40:
        Uri r6 = UriProtector.parse(r5);     // Catch: Exception -> L37
        String r7 = r6.getPath();     // Catch: Exception -> L37
        if (r7 != null) goto L11;
        Log.e("DomainService", "standardizeUrl, rawPath is empty, rawUrl: " + EncryptUtil.maskAllToken(r11));     // Catch: Exception -> L37
        return null;
    L11:
        Intrinsics.checkNotNullParameter(r10, "domainType");     // Catch: Exception -> L37
        List r12 = (List) ((Map) this.a.getValue()).get(r10);     // Catch: Exception -> L37
        if (r12 == null) goto L15;
        String r13 = (String) CollectionsKt.firstOrNull(r12);     // Catch: Exception -> L37
        if (r13 == null) goto L15;
    L16:
        String r1 = (String) CollectionsKt.firstOrNull((List) this.b.getValue());     // Catch: Exception -> L37
        if (r1 == null) goto L21;
        r4 = r1;
    L21:
        if (r4.length() != 0) goto L23;
        boolean r2 = true;
    L24:
        if (r2 == false) goto L27;
    L36:
        return r6.buildUpon().scheme("https").authority(r13).path(r7).build();
    L27:
        if (StringsKt.startsWith$default(r7, r4, false, 2, null) == true) goto L36;
        if (StringsKt.startsWith$default(r7, "/".concat(r4), false, 2, null) == true) goto L36;
        if (StringsKt.startsWith$default(r7, "/", false, 2, null) == false) goto L34;
        r7 = r4.concat(r7);     // Catch: Exception -> L37
        goto L36
    L34:
        r7 = r4 + '/' + r7;     // Catch: Exception -> L37
        goto L36
    L23:
        r2 = false;
    L15:
        r13 = BuildConfig.FLAVOR;
    L37:
        e = move-exception;
        Log.e("DomainService", "standardizeUrl, error: ", e);
        return null;
    L5:
        r5 = r11;
        goto L40
    }
}
