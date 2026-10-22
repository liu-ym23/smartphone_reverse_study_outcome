package com.bytedance.ai.bridge.method.ui;

import android.content.Context;
import android.view.View;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.bridge.service.ToastBuilder;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f2.k;
import f3.h;
import g2.b;
import i4.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\"\u0010\u0012\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/ShowToastMethod;", "Lcom/bytedance/ai/bridge/method/ui/AbsShowToastMethodIDL;", "<init>", "()V", "altNames", "", "", "getAltNames", "()Ljava/util/List;", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/ui/AbsShowToastMethodIDL$ShowToastParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/ui/AbsShowToastMethodIDL$ShowToastResultModel;", "fail", MessageIndication.MESSAGE_TYPE_MSG, "errNo", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "isLegalType", "", "toastType", "mapToNativeToastType", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowToastMethod extends AbsShowToastMethodIDL {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final List<String> getAltNames() {
        return CollectionsKt.listOf("doubao.showToast");
    }

    public ShowToastMethod() {
    }

    public final void b(h<AbsShowToastMethodIDL.b> r10, String r11, f3.a r12) {
        g.a.e("AISDK_JSB_ShowToastMethod", "call failed, errNo=" + r12.a + ", msg=" + r11);
        h.a.a(r10, r11, r12, null, 10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r19, ParamModel r20, h r21) {
        AbsShowToastMethodIDL.a r10 = (AbsShowToastMethodIDL.a) r20;
        Intrinsics.checkNotNullParameter(r19, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r21, "callback");
        a0 r11 = r19.getContainerContext();
        g r12 = g.a;
        StringBuilder r13 = new StringBuilder("call start, hasType=");
        String r14 = r10.getType();
        boolean r15 = false;
        if (r14 != null) goto L5;
    L8:
        boolean r16 = true;
    L9:
        r13.append(!r16);
        r13.append(", hasIcon=");
        String r17 = r10.getIcon();
        if (r17 != null) goto L12;
    L15:
        boolean r18 = true;
    L16:
        r13.append(!r18);
        r13.append(", messageLen=");
        r13.append(r10.getMessage().length());
        r13.append(", appletId=");
        Boolean r22 = null;
        if (r11 == null) goto L19;
        String r110 = r11.getAppletId();
    L20:
        r13.append(r110);
        r13.append(", containerId=");
        if (r11 == null) goto L23;
        String r111 = r11.getContainerId();
    L24:
        r13.append(r111);
        r12.i("AISDK_JSB_ShowToastMethod", r13.toString());
        if (r11 == null) goto L27;
        ContainerType r23 = r11.getContainerType();
    L29:
        if (r23 != ContainerType.WORKER) goto L31;
        Context r24 = k.b();
    L34:
        Context r112 = r24;
    L36:
        if (r112 != null) goto L39;
        b(r21, "context not provided in host", f3.a.f);
        return;
    L39:
        if (r10.getType() != null) goto L44;
        if (r10.getIcon() != null) goto L44;
        b(r21, "either type or icon should have value", f3.a.h);
        return;
    L44:
        if (r10.getMessage().length() != 0) goto L46;
        boolean r25 = true;
    L47:
        if (r25 == false) goto L49;
        b(r21, "message can not be empty", f3.a.h);
        return;
    L49:
        String r26 = r10.getType();
        if (r26 != null) goto L52;
    L55:
        boolean r27 = true;
    L57:
        if (r27 == false) goto L59;
        boolean r28 = false;
    L60:
        if (r28 == false) goto L97;
        String r29 = r10.getIcon();
        if (r29 != null) goto L64;
    L67:
        boolean r30 = true;
    L68:
        if (r30 == false) goto L97;
        if (r10.getDuration() != null) goto L97;
        String r31 = r10.getCustomIcon();
        if (r31 != null) goto L74;
    L75:
        r15 = true;
    L76:
        if (r15 == false) goto L97;
        AppletRuntimeManager.INSTANCE.getClass();
        b r1 = AppletRuntimeManager.d;
        if (r1 == null) goto L112;
        Intrinsics.checkNotNull(r26);
        switch(r26.hashCode()) {
            case -1867169789: goto L92;
            case 96784904: goto L88;
            case 1124446108: goto L84;
            case 1544803905: goto L82;
            default: goto L95;
        };
    L82:
        r26.equals("default");
    L95:
        String r32 = "DEFAULT";
    L96:
        r1.q(r32, r10.getMessage());
        return;
    L84:
        if (r26.equals("warning") == false) goto L95;
        r32 = "WARNING";
        goto L96
    L88:
        if (r26.equals(IHostStyleUIDepend.TOAST_TYPE_ERROR) == false) goto L95;
        r32 = "FAILURE";
        goto L96
    L92:
        if (r26.equals("success") == false) goto L95;
        r32 = "SUCCESS";
        goto L96
    L112:
        return;
    L74:
        if (r31.length() != 0) goto L76;
    L64:
        if (r29.length() == 0) goto L67;
        r30 = false;
    L97:
        Number r33 = r10.getDuration();
        if (r33 == null) goto L100;
        int r34 = r33.intValue();
    L101:
        ToastBuilder r35 = new ToastBuilder(r112, r10.getMessage(), r10.getType(), Integer.valueOf(r34), r10.getIcon(), r10.getCustomIcon());
        IHostStyleUIDepend r36 = r4.a.e;
        if (r36 == null) goto L105;
        r22 = r36.showToast(r35);
    L105:
        if (Intrinsics.areEqual(r22, Boolean.TRUE) == true) goto L107;
        new c().showToast(r35);
    L107:
        r12.i("AISDK_JSB_ShowToastMethod", "call success");
        Intrinsics.checkNotNullParameter(AbsShowToastMethodIDL.b.class, "<this>");
        r21.b((ResultModel) k3.c.a(AbsShowToastMethodIDL.b.class), "");
        return;
    L100:
        r34 = 3000;
        goto L101
    L59:
        r28 = SetsKt.setOf(new String[]{"default", "success", IHostStyleUIDepend.TOAST_TYPE_ERROR, "warning"}).contains(r26);
        goto L60
    L52:
        if (r26.length() == 0) goto L55;
        r27 = false;
        goto L57
    L46:
        r25 = false;
        goto L47
    L31:
        View r37 = r19.getEngineView();
        if (r37 == null) goto L35;
        r24 = r37.getContext();
        goto L34
    L35:
        r112 = null;
        goto L36
    L27:
        r23 = null;
        goto L29
    L23:
        r111 = null;
        goto L24
    L19:
        r110 = null;
        goto L20
    L12:
        if (r17.length() == 0) goto L15;
        r18 = false;
        goto L16
    L5:
        if (r14.length() == 0) goto L8;
        r16 = false;
        goto L9
    }
}
