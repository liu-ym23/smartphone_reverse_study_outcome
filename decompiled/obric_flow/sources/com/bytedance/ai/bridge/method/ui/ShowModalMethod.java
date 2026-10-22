package com.bytedance.ai.bridge.method.ui;

import android.app.Activity;
import android.content.DialogInterface;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.DialogBuilder;
import com.bytedance.ai.bridge.system.ui.AbsShowModalMethodIDL;
import com.bytedance.ai.ex.widget.inittasks.AISdkInitializer$injectAIBridgeBaseRuntime$4$1;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import g2.d;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/ShowModalMethod;", "Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL$ShowModalParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL$ShowModalResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL$ShowModalParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ShowModalMethod extends AbsShowModalMethodIDL {
    public ShowModalMethod() {
    }

    public static /* synthetic */ void b(f r5, DialogInterface r10, int r11) {
        handle$lambda$3(r5, r10, r11);
    }

    public static /* synthetic */ void c(f r5, DialogInterface r10, int r11) {
        handle$lambda$1(r5, r10, r11);
    }

    public static /* synthetic */ void d(f r5, DialogInterface r10) {
        handle$lambda$5(r5, r10);
    }

    private static final void handle$lambda$1(f r5, DialogInterface r10, int r11) {
        KClass r12 = Reflection.getOrCreateKotlinClass(AbsShowModalMethodIDL.ShowModalResultModel.class);
        Intrinsics.checkNotNullParameter(r12, "<this>");
        BaseModel r13 = e.c(JvmClassMappingKt.getJavaClass(r12));
        ((AbsShowModalMethodIDL.ShowModalResultModel) r13).setAction(AbsShowModalMethodIDL.ModalAction.CONFIRM);
        r5.b((ResultModel) r13, "");
    }

    private static final void handle$lambda$3(f r5, DialogInterface r10, int r11) {
        KClass r12 = Reflection.getOrCreateKotlinClass(AbsShowModalMethodIDL.ShowModalResultModel.class);
        Intrinsics.checkNotNullParameter(r12, "<this>");
        BaseModel r13 = e.c(JvmClassMappingKt.getJavaClass(r12));
        ((AbsShowModalMethodIDL.ShowModalResultModel) r13).setAction(AbsShowModalMethodIDL.ModalAction.CANCEL);
        r5.b((ResultModel) r13, "");
    }

    private static final void handle$lambda$5(f r5, DialogInterface r10) {
        KClass r11 = Reflection.getOrCreateKotlinClass(AbsShowModalMethodIDL.ShowModalResultModel.class);
        Intrinsics.checkNotNullParameter(r11, "<this>");
        BaseModel r12 = e.c(JvmClassMappingKt.getJavaClass(r11));
        ((AbsShowModalMethodIDL.ShowModalResultModel) r12).setAction(AbsShowModalMethodIDL.ModalAction.MASK);
        r5.b((ResultModel) r12, "");
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsShowModalMethodIDL.ShowModalParamModel) r10, r11);
    }

    public void handle(c r11, AbsShowModalMethodIDL.ShowModalParamModel r12, final f r13) {
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r13, "callback");
        Activity r5 = s0.c.b();
        if (r5 != null) goto L6;
        r13.a("context not provided in host");
        return;
    L6:
        boolean r10 = r12.getTapMaskToDismiss();
        String r14 = r12.getConfirmText();
        if (r14 != null) goto L9;
    L12:
        String r15 = "CONFIRM".toLowerCase();
    L11:
        String r16 = r15;
        String r17 = r12.getContent();
        String r18 = r12.getTitle();
        final int r19 = 0;
        DialogInterface.OnClickListener r20 = new g2.c(r13, r19);
        Boolean r110 = null;
        if (r12.getShowCancel() == false) goto L22;
        String r111 = r12.getCancelText();
        if (r111 != null) goto L18;
    L20:
        String r112 = "CANCEL".toLowerCase();
    L21:
        final int r21 = 1;
        String r22 = r112;
        DialogInterface.OnClickListener r23 = new g2.c(r13, r21);
    L23:
        if (r10 == false) goto L25;
        DialogInterface.OnCancelListener r24 = new d(r13);
    L26:
        DialogBuilder r113 = new DialogBuilder(r5, r18, r17, r16, r20, r22, r23, r24, r10);
        AISdkInitializer$injectAIBridgeBaseRuntime$4$1 r114 = k5.d.d;
        if (r114 == null) goto L30;
        r110 = r114.showDialog(r113);
    L30:
        if (Intrinsics.areEqual(r110, Boolean.TRUE) == true) goto L33;
        Intrinsics.checkNotNullParameter(r113, "dialogBuilder");
        Intrinsics.checkNotNullParameter(r113, "dialogBuilder");
        return;
    L33:
        return;
    L25:
        r24 = null;
        goto L26
    L18:
        if (r111.length() <= 0) goto L20;
        r112 = r12.getCancelText();
        goto L21
    L22:
        r22 = null;
        r23 = null;
        goto L23
    L9:
        if (r14.length() <= 0) goto L12;
        r15 = r12.getConfirmText();
        goto L11
    }
}
