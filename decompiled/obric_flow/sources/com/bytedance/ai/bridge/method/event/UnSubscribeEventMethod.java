package com.bytedance.ai.bridge.method.event;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.event.AbsUnSubscribeEventMethodIDL;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m1.j;
import n1.a;
import n1.c;
import o1.f;
import s1.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/event/UnSubscribeEventMethod;", "Lcom/bytedance/ai/bridge/event/AbsUnSubscribeEventMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/event/AbsUnSubscribeEventMethodIDL$UnSubscribeEventParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/event/AbsUnSubscribeEventMethodIDL$EmptyMessageModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/event/AbsUnSubscribeEventMethodIDL$UnSubscribeEventParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnSubscribeEventMethod extends AbsUnSubscribeEventMethodIDL {
    public UnSubscribeEventMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsUnSubscribeEventMethodIDL.UnSubscribeEventParamModel) r10, r11);
    }

    public void handle(c r10, AbsUnSubscribeEventMethodIDL.UnSubscribeEventParamModel r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        Lazy r13 = s1.c.f21808a;
        a r14 = (a) r10;
        m1.f r5 = r14.f20195a;
        j r15 = (j) r14.b(j.class);
        String r16 = null;
        if (r15 == null) goto L5;
        String r17 = r15.c();
    L6:
        j r18 = (j) r14.b(j.class);
        if (r18 == null) goto L9;
        r16 = r18.b();
    L9:
        d r19 = new d(r5, r17, r16, System.currentTimeMillis());
        String r20 = r11.getEventName();
        Intrinsics.checkNotNullParameter(r19, "subscriber");
        Intrinsics.checkNotNullParameter(r20, "eventName");
        CopyOnWriteArrayList r21 = (CopyOnWriteArrayList) ((ConcurrentHashMap) s1.c.f21809b.getValue()).get(r20);
        if (r21 == null) goto L12;
        r21.remove(r19);
    L12:
        Intrinsics.checkNotNullParameter(AbsUnSubscribeEventMethodIDL.EmptyMessageModel.class, "<this>");
        r12.b((ResultModel) e.c(AbsUnSubscribeEventMethodIDL.EmptyMessageModel.class), "");
        return;
    L5:
        r17 = null;
        goto L6
    }
}
