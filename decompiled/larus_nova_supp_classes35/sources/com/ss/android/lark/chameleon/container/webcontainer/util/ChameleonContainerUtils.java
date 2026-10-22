package com.ss.android.lark.chameleon.container.webcontainer.util;

import com.ss.android.lark.chameleon.Chameleon;
import com.ss.android.lark.chameleon.api.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0004J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J$\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R,\u0010\b\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/util/ChameleonContainerUtils;", BuildConfig.FLAVOR, "()V", "DOC_TRACER_TAG", BuildConfig.FLAVOR, "MAX_URL_LENGTH", BuildConfig.FLAVOR, "TAG", "bizConfig", BuildConfig.FLAVOR, "Lkotlin/Pair;", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;", "getBizConfig", "session", "getBizPlugins", "getPlainUrl", "url", "releaseBizConfig", BuildConfig.FLAVOR, "safeUrlString", "setBizConfig", "config", "bizPlugins", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonContainerUtils {
    public static final String DOC_TRACER_TAG = "[DocTracer]";
    public static final ChameleonContainerUtils INSTANCE = null;
    public static final int MAX_URL_LENGTH = 1024;
    private static final String TAG = "CML_TAG_ContainerUtils";
    private static final Map<String, Pair<ChameleonConfig, List<AbsChameleonPlugin>>> bizConfig = null;

    private ChameleonContainerUtils() {
    }

    public final String getPlainUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        return r2;
    }

    static {
        INSTANCE = new ChameleonContainerUtils();
        bizConfig = new LinkedHashMap();
    }

    public final ChameleonConfig getBizConfig(String r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        Pair<ChameleonConfig, List<AbsChameleonPlugin>> r3 = bizConfig.get(r2);
        if (r3 == null) goto L7;
        ChameleonConfig r4 = (ChameleonConfig) r3.getFirst();
        if (r4 == null) goto L7;
        return r4;
    L7:
        return Chameleon.INSTANCE.getHostDefaultConfig();
    }

    public final List<AbsChameleonPlugin> getBizPlugins(String r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        Pair<ChameleonConfig, List<AbsChameleonPlugin>> r3 = bizConfig.get(r2);
        if (r3 == null) goto L7;
        List<AbsChameleonPlugin> r4 = (List) r3.getSecond();
        if (r4 == null) goto L7;
        return r4;
    L7:
        return CollectionsKt.emptyList();
    }

    public final void releaseBizConfig(String r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        bizConfig.remove(r2);
    }

    public final String safeUrlString(String r8) {
        if (r8 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return BuildConfig.FLAVOR;
    L12:
        int r2 = StringsKt.indexOf$default(r8, "?", 0, false, 6, null);
        if (r2 <= (-1)) goto L16;
        r8 = r8.substring(0, r2);
    L16:
        if (r8.length() > 1024) goto L18;
        return r8;
    L18:
        return r8.substring(0, MAX_URL_LENGTH);
    L5:
        if (r8.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void setBizConfig(String r3, ChameleonConfig r4, List<? extends AbsChameleonPlugin> r5) {
        Intrinsics.checkNotNullParameter(r3, "session");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "bizPlugins");
        bizConfig.put(r3, new Pair(r4, r5));
    }
}
