package com.obric.aiagent.product.a;

import aiassistant.version.AssistantVersion;
import com.aiassistant.utils.AssistantFeatureValidator;
import com.obric.utils.ObricFeatureValidator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import obric.version.ObricVersion;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\u0007H\u0007J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\nJ\u0014\u0010\f\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eJ\u0006\u0010\u000f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/aiagent/product/utils/OsFeatureUtil;", "", "<init>", "()V", "ASSISTANT_API_BEGIN_VERSION", "", "useAssistantApi", "", "hasObricFeature", "featureName", "", "isInAppSupported", "isOsFeatureSupported", "osFeatures", "", "getObricApiVersion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5964a = null;

    static {
        f5964a = new a();
    }

    private a() {
    }

    @JvmStatic
    public static final boolean b() {
        boolean r2 = ObricFeatureValidator.hasFeature("obric.in.app.rule");     // Catch: Throwable -> L5
        com.obric.aiagent.platform.a.d.b r3 = com.obric.aiagent.platform.a.d.f5954a;     // Catch: Throwable -> L5
        String r4 = a.class.getSimpleName();     // Catch: Throwable -> L5
        Intrinsics.checkNotNullExpressionValue(r4, "getSimpleName(...)");     // Catch: Throwable -> L5
        r3.b(r4, "isInAppSupported: feature=obric.in.app.rule, hasFeature=" + r2);     // Catch: Throwable -> L5
        return r2;
    L5:
        th = move-exception;
        com.obric.aiagent.platform.a.d.b r5 = com.obric.aiagent.platform.a.d.f5954a;
        String r1 = a.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r1, "getSimpleName(...)");
        r5.a(r1, "isInAppSupported: feature=obric.in.app.rule, code=feature_query_failed, fallback=false", th);
        return false;
    }

    public final boolean a() {
        if (c() < 10) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "osFeatures");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return true;
    L9:
        if (a() == false) goto L12;
        return AssistantFeatureValidator.hasFeature(r3);
    L12:
        return ObricFeatureValidator.hasFeature(r3);
    L5:
        r0 = false;
        goto L6
    }

    public final boolean a(List<String> r4) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "osFeatures");
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L5;
        return true;
    L5:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L8;
    L10:
        Iterator r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L21;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        if (f5964a.a(r7) == true) goto L12;
        return false;
    L21:
        return true;
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L10;
        return true;
    }

    public final int c() {
        int r1 = AssistantVersion.getVersion();     // Catch: Throwable -> L5
    L11:
        com.obric.aiagent.platform.a.d.b r2 = com.obric.aiagent.platform.a.d.f5954a;
        String r0 = a.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r0, "getSimpleName(...)");
        r2.b(r0, "getObricApiVersion, version: " + r1);
        return r1;
    L5:
        th = move-exception;
        com.obric.aiagent.platform.a.d.b r3 = com.obric.aiagent.platform.a.d.f5954a;
        String r4 = a.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r4, "getSimpleName(...)");
        r3.b(r4, "getAssistantVersion failed, e: " + th);
        r1 = ObricVersion.getVersion();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        com.obric.aiagent.platform.a.d.b r5 = com.obric.aiagent.platform.a.d.f5954a;
        String r6 = a.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r6, "getSimpleName(...)");
        r5.c(r6, "getObricVersion failed, e: " + th);
        r1 = -1;
        goto L11
    }
}
