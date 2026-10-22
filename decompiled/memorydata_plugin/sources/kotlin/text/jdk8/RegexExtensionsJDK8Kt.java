package kotlin.text.jdk8;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchNamedGroupCollection;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0002¨\u0006\u0005"}, d2 = {"get", "Lkotlin/text/MatchGroup;", "Lkotlin/text/MatchGroupCollection;", ActivityLifecycle.NAME, "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, pn = "kotlin.text", xi = 48)
public final class RegexExtensionsJDK8Kt {
    public static final MatchGroup get(MatchGroupCollection r2, String r3) {
        MatchGroupCollection r4 = (MatchGroupCollection) ZeusTransformUtils.wrapperContextForParams(r2, MatchGroupCollection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        if (ZeusTransformUtils.instanceOf(r4, MatchNamedGroupCollection.class) == false) goto L5;
        MatchNamedGroupCollection r5 = (MatchNamedGroupCollection) ZeusTransformUtils.preCheckCast(r4, MatchNamedGroupCollection.class, "com.obric.memorydata.plugin");
    L6:
        if (r5 == null) goto L10;
        return r5.get(r3);
    L10:
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    L5:
        r5 = null;
        goto L6
    }
}
