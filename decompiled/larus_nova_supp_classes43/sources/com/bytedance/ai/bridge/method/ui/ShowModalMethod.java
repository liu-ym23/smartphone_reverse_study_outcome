package com.bytedance.ai.bridge.method.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.DialogBuilder;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.bridge.system.ui.AbsShowModalMethodIDL;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f2.k;
import f3.h;
import h4.b;
import h4.c;
import h4.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J+\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0002\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0017\u001a\u00020\u0006H\u0002R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/ShowModalMethod;", "Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL;", "<init>", "()V", "altNames", "", "", "getAltNames", "()Ljava/util/List;", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL$ShowModalParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL$ShowModalResultModel;", "parseModalColor", "", "fieldName", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/bridge/core/CompletionBlock;)Ljava/lang/Integer;", "fail", MessageIndication.MESSAGE_TYPE_MSG, "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowModalMethod extends AbsShowModalMethodIDL {
    public static final Regex c = null;
    public final List<String> b;

    public static final class a {
    }

    static {
        c = new Regex("^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})$");
    }

    public ShowModalMethod() {
        this.b = CollectionsKt.listOf("applet.showModal");
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final List<String> getAltNames() {
        return this.b;
    }

    public static void b(h r10, String r11) {
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call failed, errNo=");
        f3.a r12 = f3.a.h;
        r1.append(r12.a);
        r1.append(", msg=");
        r1.append(r11);
        r0.e("AISDK_JSB_ShowModalMethod", r1.toString());
        h.a.a(r10, r11, r12, null, 10);
    }

    public static final void c(h<AbsShowModalMethodIDL.b> r10, AbsShowModalMethodIDL.a r11, String r12) {
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call success, action=");
        AbsShowModalMethodIDL.ModalAction r13 = AbsShowModalMethodIDL.ModalAction.CONFIRM;
        r1.append(r13);
        r0.i("AISDK_JSB_ShowModalMethod", r1.toString());
        BaseModel r14 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsShowModalMethodIDL.b.class));
        AbsShowModalMethodIDL.b r15 = (AbsShowModalMethodIDL.b) r14;
        r15.setAction(r13);
        if (r11.getEditable() == false) goto L7;
        if (r12 != null) goto L6;
        r12 = "";
    L6:
        r15.setContent(r12);
    L7:
        r10.b((ResultModel) r14, "");
    }

    public static Integer d(String r10, String r11, h r12) {
        if (r10.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        Object r1 = null;
        if (r0 == false) goto L10;
        return null;
    L10:
        if (c.matches(r10) == true) goto L23;
        b(r12, r11.concat(" must be a hex color string"));
        return null;
    L23:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L15
        Object r14 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r10)));     // Catch: Throwable -> L15
    L18:
        if (Result.exceptionOrNull-impl(r14) != null) goto L20;
        r1 = r14;
    L22:
        return (Integer) r1;
    L20:
        b(r12, r11.concat(" must be a valid color"));
    L15:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r23, ParamModel r24, final h r25) {
        final AbsShowModalMethodIDL.a r1 = (AbsShowModalMethodIDL.a) r24;
        Intrinsics.checkNotNullParameter(r23, "bridgeContext");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r25, "callback");
        String r10 = r1.getConfirmText();
        boolean r11 = true;
        int r12 = 0;
        Boolean r13 = null;
        if (r10 != null) goto L5;
    L12:
        r10 = "确定";
    L13:
        String r14 = r10;
        String r15 = r1.getCancelText();
        if (r15 != null) goto L16;
    L23:
        r15 = "取消";
    L25:
        if (r14.length() <= 4) goto L28;
        b(r25, "confirmText length should not exceed 4");
        return;
    L28:
        if (r15.length() <= 4) goto L30;
        b(r25, "cancelText length should not exceed 4");
        return;
    L30:
        String r16 = r1.getConfirmColor();
        if (r16 != null) goto L33;
    L43:
        Integer r17 = null;
    L44:
        String r18 = r1.getCancelColor();
        if (r18 != null) goto L47;
    L57:
        Integer r19 = null;
    L58:
        a0 r20 = r23.getContainerContext();
        String r21 = r1.getContent();
        if (r21 != null) goto L61;
        r21 = "";
    L61:
        String r110 = r21;
        g r22 = g.a;
        StringBuilder r26 = new StringBuilder("call start, titleLen=");
        String r27 = r1.getTitle();
        if (r27 == null) goto L64;
        r12 = r27.length();
    L64:
        r26.append(r12);
        r26.append(", contentLen=");
        r26.append(r110.length());
        r26.append(", showCancel=");
        r26.append(r1.getShowCancel());
        r26.append(", editable=");
        r26.append(r1.getEditable());
        r26.append(", appletId=");
        if (r20 == null) goto L67;
        String r28 = r20.getAppletId();
    L68:
        r26.append(r28);
        r26.append(", containerId=");
        if (r20 == null) goto L71;
        String r29 = r20.getContainerId();
    L72:
        r26.append(r29);
        r22.i("AISDK_JSB_ShowModalMethod", r26.toString());
        Activity r30 = k.b();
        if (r30 != null) goto L75;
        StringBuilder r31 = new StringBuilder("call failed, errNo=");
        f3.a r32 = f3.a.f;
        r31.append(r32.a);
        r31.append(", msg=context not provided in host");
        r22.e("AISDK_JSB_ShowModalMethod", r31.toString());
        h.a.a(r25, "context not provided in host", r32, null, 10);
        return;
    L75:
        boolean r111 = r1.getTapMaskToDismiss();
        String r33 = r1.getTitle();
        DialogInterface.OnClickListener r112 = new b(r25, r1);
        Function1 r113 = new c(r25, r1);
        if (r1.getShowCancel() == false) goto L78;
        String r114 = r15;
        DialogInterface.OnClickListener r115 = new h4.d(r25);
    L79:
        if (r111 == false) goto L81;
        DialogInterface.OnCancelListener r116 = new e(r25);
    L82:
        DialogBuilder r0 = new DialogBuilder(r30, r33, r110, r14, r112, r113, r17, r114, r115, r19, r116, r111, r1.getEditable(), r1.getPlaceholderText());
        IHostStyleUIDepend r34 = r4.a.e;
        if (r34 == null) goto L86;
        r13 = r34.showDialog(r0);
    L86:
        if (Intrinsics.areEqual(r13, Boolean.TRUE) == true) goto L94;
        new i4.c().showDialog(r0);
        return;
    L94:
        return;
    L81:
        r116 = null;
        goto L82
    L78:
        r114 = null;
        r115 = null;
        goto L79
    L71:
        r29 = null;
        goto L72
    L67:
        r28 = null;
        goto L68
    L47:
        if (r18.length() > 0) goto L50;
        r11 = false;
    L50:
        if (r11 == true) goto L53;
        r18 = null;
    L53:
        if (r18 == null) goto L57;
        Integer r35 = d(r18, "cancelColor", r25);
        if (r35 == null) goto L92;
        r19 = Integer.valueOf(r35.intValue());
        goto L58
    L92:
        return;
    L33:
        if (r16.length() <= 0) goto L35;
        boolean r36 = true;
    L36:
        if (r36 == true) goto L39;
        r16 = null;
    L39:
        if (r16 == null) goto L43;
        Integer r37 = d(r16, "confirmColor", r25);
        if (r37 == null) goto L91;
        r17 = Integer.valueOf(r37.intValue());
        goto L44
    L91:
        return;
    L35:
        r36 = false;
        goto L36
    L16:
        if (r15.length() <= 0) goto L18;
        boolean r38 = true;
    L19:
        if (r38 == true) goto L22;
        r15 = null;
    L22:
        if (r15 != null) goto L25;
    L18:
        r38 = false;
        goto L19
    L5:
        if (r10.length() <= 0) goto L7;
        boolean r39 = true;
    L8:
        if (r39 == true) goto L11;
        r10 = null;
    L11:
        if (r10 != null) goto L13;
    L7:
        r39 = false;
        goto L8
    }
}
