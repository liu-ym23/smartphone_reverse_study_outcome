package q4;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.bridge.security.AppletJSBBridgeChannel;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.utils.g;
import d3.a0;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements i3.b {
    @Override // i3.b
    public final int getPriority() {
        return 10;
    }

    @Override // i3.b
    public final void reset() {
    }

    public a() {
    }

    @Override // i3.b
    public final AIBridgeMethod.Error a(i3.a r11) {
        Intrinsics.checkNotNullParameter(r11, "invocation");
        a0 r0 = r11.c.getContainerContext();
        if (r0 == null) goto L5;
        String r10 = r0.getAppletId();
    L6:
        boolean r12 = true;
        if (r10 != null) goto L9;
    L12:
        boolean r13 = true;
    L14:
        if (r13 == false) goto L17;
        g.a.i("AppletJSBAccessControl", "skip access control: appletId is empty");
        return null;
    L17:
        AIManager r14 = AIManager.a;
        if (AIManager.g(r10) == false) goto L21;
        g.a.i("AppletJSBAccessControl", "skip access control: appletId=" + r10 + ", fromGecko=true");
        return null;
    L21:
        Set<String> r15 = b.a;
        String r16 = "unknown";
        if (r0 != null) goto L24;
        g.a.e("AppletJSBAccessControl", "resolveSourceType failed: containerContext is null");
    L41:
        Integer r17 = null;
    L50:
        g r18 = g.a;
        StringBuilder r19 = new StringBuilder("evaluate: appletId=");
        if (r0 == null) goto L54;
        String r20 = r0.getAppletId();
        if (r20 == null) goto L54;
    L55:
        r19.append(r20);
        r19.append(", containerType=");
        if (r0 == null) goto L63;
        ContainerType r21 = r0.getContainerType();
        if (r21 == null) goto L63;
        String r22 = r21.getTypeName();
        if (r22 == null) goto L63;
        r16 = r22;
    L63:
        r19.append(r16);
        r19.append(", channel=");
        AppletJSBBridgeChannel r23 = AppletJSBBridgeChannel.AIBRIDGE;
        r19.append(r23.getValue());
        r19.append(", methodName=");
        r19.append(r11.a);
        r18.i("AppletJSBAccessControl", r19.toString());
        if (b.a(r11.a, r17, r10) == false) goto L66;
        return null;
    L66:
        String r24 = r11.a;
        if (r0 == null) goto L69;
        String r25 = r0.getAppletId();
    L70:
        if (r0 == null) goto L74;
        ContainerType r1 = r0.getContainerType();
        if (r1 == null) goto L74;
        String r26 = r1.name();
    L75:
        if (r26 != null) goto L77;
        r26 = "";
    L77:
        b.b(r24, r25, r17, r26, r23);
        return new AIBridgeMethod.Error(-1, "method " + r11.a + " is not allowed for third-party applets", null, f3.a.l);
    L74:
        r26 = null;
        goto L75
    L69:
        r25 = null;
    L54:
        r20 = "unknown";
        goto L55
    L24:
        Integer r27 = r0.getAppSourceType();
        if (r27 == null) goto L27;
        r17 = Integer.valueOf(r27.intValue());
        goto L50
    L27:
        g r28 = g.a;
        String r29 = r0.getAppletId();
        if (r29 != null) goto L30;
        r29 = "unknown";
    L30:
        r28.e("AppletJSBAccessControl", "resolveSourceType: appSourceType missing in containerContext, appletId=".concat(r29));
        String r30 = r0.getAppletId();
        if (r30 != null) goto L33;
    L38:
        r30 = null;
    L39:
        if (r30 != null) goto L42;
        r28.e("AppletJSBAccessControl", "resolveSourceType failed: appletId is empty");
        goto L41
    L42:
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r31 = AppletAppManagerService.a(r30);
        if (r31 == null) goto L47;
        Applet r32 = r31.j();
        if (r32 == null) goto L47;
        r17 = Integer.valueOf(r32.G);
    L48:
        if (r17 != null) goto L50;
        r28.e("AppletJSBAccessControl", "resolveSourceType failed: sourceType not found in installed app, appletId=".concat(r30));
    L47:
        r17 = null;
        goto L48
    L33:
        if (r30.length() > 0) goto L36;
        r12 = false;
    L36:
        if (r12 == false) goto L38;
    L9:
        if (r10.length() == 0) goto L12;
        r13 = false;
        goto L14
    L5:
        r10 = null;
        goto L6
    }
}
