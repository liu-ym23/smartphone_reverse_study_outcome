package com.obric.memorydata.recommend.screenshotupload;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nJ\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\u0006\u0010\b\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/ScreenshotCollectionPolicy;", "", "<init>", "()V", "shouldCollect", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "screenMemoryEnabled", "enabledPackages", "", "collectPackages", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f12558a = null;

    static {
        f12558a = new g();
    }

    private g() {
    }

    public final Set<String> a(boolean r2, Set<String> r3) {
        Set<String> r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "enabledPackages");
        if (r2 == false) goto L6;
        return r1;
    L6:
        return SetsKt.emptySet();
    }

    public final boolean a(String r2, boolean r3, Set<String> r4) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r1, "enabledPackages");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L8;
        if (r3 == false) goto L8;
        if (r1.contains(r2) == false) goto L8;
        return true;
    L8:
        return false;
    }
}
