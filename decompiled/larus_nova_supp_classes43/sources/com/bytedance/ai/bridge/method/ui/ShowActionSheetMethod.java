package com.bytedance.ai.bridge.method.ui;

import android.content.Context;
import android.graphics.Color;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.service.ActionSheetBuilder;
import com.bytedance.ai.bridge.service.ActionSheetBuilderAction;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.ai.bridge.system.ui.AbsShowActionSheetMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import e3.e;
import f3.h;
import i4.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/ShowActionSheetMethod;", "Lcom/bytedance/ai/bridge/system/ui/AbsShowActionSheetMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/ui/AbsShowActionSheetMethodIDL$ShowActionSheetParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/system/ui/AbsShowActionSheetMethodIDL$ShowActionSheetResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowActionSheetMethod extends AbsShowActionSheetMethodIDL {

    public static final class a {
    }

    static {
    }

    public ShowActionSheetMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r23, ParamModel r24, h r25) {
        AbsShowActionSheetMethodIDL.a r10 = (AbsShowActionSheetMethodIDL.a) r24;
        Intrinsics.checkNotNullParameter(r23, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r25, "callback");
        a0 r0 = r23.getContainerContext();
        g r11 = g.a;
        StringBuilder r12 = new StringBuilder("call start, itemCount=");
        r12.append(r10.getItemList().size());
        r12.append(", appletId=");
        if (r0 == null) goto L5;
        String r13 = r0.getAppletId();
    L6:
        r12.append(r13);
        r12.append(", containerId=");
        if (r0 == null) goto L9;
        String r1 = r0.getContainerId();
    L10:
        r12.append(r1);
        r11.i("AISDK_JSB_ShowActionSheetMethod", r12.toString());
        Context r14 = e.b(r23);
        if (r14 != null) goto L14;
        StringBuilder r15 = new StringBuilder("call failed, errNo=");
        f3.a r16 = f3.a.f;
        r15.append(r16.a);
        r15.append(", msg=context not provided in host");
        r11.e("AISDK_JSB_ShowActionSheetMethod", r15.toString());
        h.a.a(r25, "context not provided in host", r16, null, 10);
        return;
    L14:
        if (r10.getItemList().isEmpty() == false) goto L16;
        StringBuilder r17 = new StringBuilder("call failed, errNo=");
        f3.a r18 = f3.a.h;
        r17.append(r18.a);
        r17.append(", msg=itemList can not be empty");
        r11.e("AISDK_JSB_ShowActionSheetMethod", r17.toString());
        h.a.a(r25, "itemList can not be empty", r18, null, 10);
        return;
    L16:
        AtomicBoolean r19 = new AtomicBoolean(false);
        h4.a r110 = new h4.a(r19, r25);
        String r20 = r10.getTitle();
        String r21 = r10.getItemColor();
        if (r21 != null) goto L19;
    L22:
        boolean r22 = true;
    L23:
        if (r22 == false) goto L25;
        Integer r111 = null;
    L37:
        List<String> r26 = r10.getItemList();
        ArrayList r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));
        Iterator<T> r28 = r26.iterator();
    L39:
        if (r28.hasNext() == false) goto L41;
        r27.add(new ActionSheetBuilderAction((String) r28.next(), null, "default", 2, null));
        goto L39
    L41:
        ActionSheetBuilder r29 = new ActionSheetBuilder(r14, r20, null, r111, r27, 4, null);
        IHostStyleUIDepend r30 = r4.a.e;
        if (r30 == null) goto L44;
        ActionSheetBuilder r31 = r29;
        Boolean r32 = r30.showActionSheet(r31, r110);
    L45:
        Boolean r33 = Boolean.TRUE;
        if (Intrinsics.areEqual(r32, r33) == false) goto L48;
        Boolean r34 = r33;
    L50:
        if (Intrinsics.areEqual(r34, r33) == false) goto L52;
        return;
    L52:
        if (r19.compareAndSet(false, true) == false) goto L61;
        g r35 = g.a;
        StringBuilder r36 = new StringBuilder("call failed, errNo=");
        f3.a r37 = f3.a.f;
        r36.append(r37.a);
        r36.append(", msg=failed to show action sheet");
        r35.e("AISDK_JSB_ShowActionSheetMethod", r36.toString());
        h.a.a(r25, "failed to show action sheet", r37, null, 10);
        return;
    L61:
        return;
    L48:
        g.a.w("AISDK_JSB_ShowActionSheetMethod", "fallback used, reason=host unavailable");
        new c().showActionSheet(r31, r110);
        r34 = null;
        goto L50
    L44:
        r31 = r29;
        r32 = null;
        goto L45
    L25:
        String r38 = StringsKt.trim(r21).toString();
        if (StringsKt.startsWith$default(r38, "#", false, 2, null) == true) goto L55;
        r38 = "#" + r38;
    L55:
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L31
        Object r40 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r38)));     // Catch: Throwable -> L31
    L34:
        if (Result.isFailure-impl(r40) == false) goto L36;
        r40 = null;
    L36:
        r111 = (Integer) r40;
    L31:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r40 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    L19:
        if (StringsKt.isBlank(r21) == true) goto L22;
        r22 = false;
        goto L23
    L9:
        r1 = null;
        goto L10
    L5:
        r13 = null;
        goto L6
    }
}
