package com.obric.memorydata.migration.sdk;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001f\u0010\u000b\u001a\u00020\u00052\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\r\"\u00020\u0007¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/migration/sdk/ResourceExtractors;", "", "<init>", "()V", "jsonField", "Lcom/obric/memorydata/migration/sdk/ResourceExtractor;", "key", "", "auto", "rawPath", "rawPathJsonField", "rawPathJsonFields", "keys", "", "([Ljava/lang/String;)Lcom/obric/memorydata/migration/sdk/ResourceExtractor;", "isRawPathExtractor", "", "extractor", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ag f11885a = null;

    static {
        f11885a = new ag();
    }

    private ag() {
    }

    private static final List a(String r2) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return CollectionsKt.emptyList();
    L13:
        return c.a(r2);
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public static /* synthetic */ List lambda$XoXXPVm0Mm0fpahokUdeNJNVwi4(String r0) {
        return a(r0);
    }

    public final af a() {
        return $$Lambda$ag$XoXXPVm0Mm0fpahokUdeNJNVwi4.INSTANCE;
    }

    public final af a(String... r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
        return (af) ZeusTransformUtils.preCheckCast(new h(ArraysKt.toList(r2)), af.class, "com.obric.memorydata.plugin");
    }

    public final boolean a(af r2) {
        af r1 = (af) ZeusTransformUtils.wrapperContextForParams(r2, af.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "extractor");
        return ZeusTransformUtils.instanceOf(r1, ac.class);
    }
}
