package z2;

import com.bytedance.ai.bridge.core.AIBridgeMethod;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t implements i3.b {
    public static final Set<String> a = null;

    public static final class a {
    }

    public t() {
    }

    @Override // i3.b
    public final int getPriority() {
        return 100;
    }

    @Override // i3.b
    public final void reset() {
    }

    static {
        a = SetsKt.setOf(new String[]{"doubao.navigateTo", "doubao.navigateBack", "doubao.redirectTo", "doubao.reLaunch", "doubao.postMessage"});
    }

    @Override // i3.b
    public final AIBridgeMethod.Error a(i3.a r10) {
        Intrinsics.checkNotNullParameter(r10, "invocation");
        if (a.contains(r10.a) == false) goto L6;
        return null;
    L6:
        return new AIBridgeMethod.Error(-1, "method " + r10.a + " is not allowed in WebView context", null, f3.a.l);
    }
}
