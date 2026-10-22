package kotlin.reflect.jvm.internal.impl.platform;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class PlatformUtilKt {
    public static final String getPresentableDescription(TargetPlatform r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return CollectionsKt.joinToString$default(r10.getComponentPlatforms(), "/", null, null, 0, null, null, 62, null);
    }
}
