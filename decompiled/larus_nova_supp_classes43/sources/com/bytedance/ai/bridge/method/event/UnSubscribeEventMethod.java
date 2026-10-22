package com.bytedance.ai.bridge.method.event;

import android.os.Build;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.event.AbsUnSubscribeEventMethodIDL;
import d3.a0;
import e3.d;
import e3.g;
import f3.h;
import f4.s;
import f4.w;
import java.util.concurrent.CopyOnWriteArrayList;
import k3.c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/method/event/UnSubscribeEventMethod;", "Lcom/bytedance/ai/bridge/event/AbsUnSubscribeEventMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/event/AbsUnSubscribeEventMethodIDL$UnSubscribeEventParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/event/AbsUnSubscribeEventMethodIDL$EmptyMessageModel;", "stopRelatedEventServiceIfNeeded", "eventName", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UnSubscribeEventMethod extends AbsUnSubscribeEventMethodIDL {
    public UnSubscribeEventMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsUnSubscribeEventMethodIDL.b r13 = (AbsUnSubscribeEventMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Lazy r0 = l3.d.a;
        g r1 = r10.getJsEventDelegate();
        a0 r14 = r10.getContainerContext();
        String r15 = null;
        if (r14 == null) goto L5;
        String r16 = r14.getContainerId();
    L6:
        a0 r17 = r10.getContainerContext();
        if (r17 == null) goto L9;
        r15 = r17.getAppletId();
    L9:
        e r18 = new e(r1, r16, r15, 24);
        String r19 = r13.getEventName();
        Intrinsics.checkNotNullParameter(r18, "subscriber");
        Intrinsics.checkNotNullParameter(r19, "eventName");
        CopyOnWriteArrayList r20 = (CopyOnWriteArrayList) l3.d.a().get(r19);
        if (r20 == null) goto L12;
        r20.remove(r18);
    L12:
        String r21 = r13.getEventName();
        if (l3.d.b(r21) == false) goto L16;
    L21:
        Intrinsics.checkNotNullParameter(AbsUnSubscribeEventMethodIDL.a.class, "<this>");
        r12.b((ResultModel) c.a(AbsUnSubscribeEventMethodIDL.a.class), "");
        return;
    L16:
        if (Intrinsics.areEqual(r21, "doubao.onUserScreenRecord") == false) goto L21;
        w.a.getClass();
        if (Build.VERSION.SDK_INT < 35) goto L21;
        p2.c.d(new s());
        goto L21
    L5:
        r16 = null;
        goto L6
    }
}
