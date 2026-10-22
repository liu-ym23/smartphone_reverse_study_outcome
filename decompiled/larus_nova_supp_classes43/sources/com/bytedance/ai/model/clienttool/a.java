package com.bytedance.ai.model.clienttool;

import com.bytedance.ai.bridge.core.AIBridgeMethod;
import d3.a0;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements i3.b {
    public static final Set<String> a = null;

    /* JADX INFO: renamed from: com.bytedance.ai.model.clienttool.a$a, reason: collision with other inner class name */
    public static final class C0043a {
    }

    public a() {
    }

    @Override // i3.b
    public final int getPriority() {
        return 0;
    }

    @Override // i3.b
    public final void reset() {
    }

    static {
        a = SetsKt.setOf(new String[]{"replyLocalPlugin", "doubao.getAccountInfo", "doubao.getSetting", "doubao.getAppAuthorizeSetting", "doubao.getSystemInfo", "doubao.getSystemSetting", "doubao.request", "doubao.getLocation", "doubao.login", "doubao.getDeviceInfo", "doubao.reportEvent", "doubao.setStorage", "doubao.getStorage", "doubao.removeStorage", "doubao.clearStorage", "doubao.getStorageInfo"});
    }

    @Override // i3.b
    public final AIBridgeMethod.Error a(i3.a r10) {
        Intrinsics.checkNotNullParameter(r10, "invocation");
        a0 r0 = r10.c.getContainerContext();
        if (r0 == null) goto L5;
        Integer r11 = r0.getAppSourceType();
    L6:
        com.bytedance.ai.utils.g r12 = com.bytedance.ai.utils.g.a;
        StringBuilder r13 = new StringBuilder("intercept: appletId=");
        Object r14 = "unknown";
        if (r0 == null) goto L10;
        String r1 = r0.getAppletId();
        if (r1 == null) goto L10;
    L11:
        r13.append(r1);
        r13.append(", methodName=");
        r13.append(r10.a);
        r13.append(", sourceType=");
        if (r11 == null) goto L15;
        r14 = r11;
    L15:
        r13.append(r14);
        r12.i("ClientToolJSBInterceptor", r13.toString());
        if (r11 != null) goto L19;
    L20:
        return null;
    L19:
        if (r11.intValue() != 2) goto L20;
        if (a.contains(r10.a) == false) goto L25;
        return null;
    L25:
        return new AIBridgeMethod.Error(-1, "method " + r10.a + " is not allowed in Client Tool Runtime", null, f3.a.l);
    L10:
        r1 = "unknown";
        goto L11
    L5:
        r11 = null;
        goto L6
    }
}
