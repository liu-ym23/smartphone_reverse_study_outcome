package com.bytedance.ai.bridge.method.event;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.event.AbsSubscribeEventMethodIDL;
import com.bytedance.ai.model.m;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import m1.j;
import n1.a;
import n1.c;
import o1.f;
import s1.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/event/SubscribeEventMethod;", "Lcom/bytedance/ai/bridge/event/AbsSubscribeEventMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/event/AbsSubscribeEventMethodIDL$SubscribeEventParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/event/AbsSubscribeEventMethodIDL$EmptyMessageModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/event/AbsSubscribeEventMethodIDL$SubscribeEventParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SubscribeEventMethod extends AbsSubscribeEventMethodIDL {
    public SubscribeEventMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsSubscribeEventMethodIDL.SubscribeEventParamModel) r10, r11);
    }

    public void handle(c r10, AbsSubscribeEventMethodIDL.SubscribeEventParamModel r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        r11.getEventName();
        r11.getTimestamp();
        Lazy r13 = s1.c.f21808a;
        a r14 = (a) r10;
        m1.f r5 = r14.f20195a;
        j r15 = (j) r14.b(j.class);
        if (r15 == null) goto L5;
        String r16 = r15.c();
    L6:
        j r17 = (j) r14.b(j.class);
        if (r17 == null) goto L9;
        String r18 = r17.b();
    L10:
        long r19 = r11.getTimestamp();
        j r20 = (j) r14.b(j.class);
        d r21 = new d(r5, r16, r18, r19);
        String r22 = r11.getEventName();
        Intrinsics.checkNotNullParameter(r21, "subscriber");
        Intrinsics.checkNotNullParameter(r22, "eventName");
        Lazy r23 = s1.c.f21809b;
        CopyOnWriteArrayList r24 = (CopyOnWriteArrayList) ((ConcurrentHashMap) r23.getValue()).get(r22);
        if (r24 != null) goto L14;
        r24 = new CopyOnWriteArrayList();
        ((ConcurrentHashMap) r23.getValue()).put(r22, r24);
    L25:
        CollectionsKt.removeAll(r24, new m(19));
        r24.add(r21);
        ((ConcurrentHashMap) r23.getValue()).put(r22, r24);
        Iterator r25 = ((CopyOnWriteArrayList) s1.c.f21808a.getValue()).iterator();
    L27:
        if (r25.hasNext() == false) goto L33;
        s1.a r26 = (s1.a) r25.next();
        if (Intrinsics.areEqual(r26.f21804a, r22) == false) goto L27;
        if (r21.f21812c >= r26.f21806c) goto L27;
        Intrinsics.checkNotNull(r26);
        r21.a(r26);
    L33:
        Intrinsics.checkNotNullParameter(AbsSubscribeEventMethodIDL.EmptyMessageModel.class, "<this>");
        r12.b((ResultModel) e.c(AbsSubscribeEventMethodIDL.EmptyMessageModel.class), "");
        return;
    L14:
        if (r24.contains(r21) == false) goto L25;
        Iterator r27 = r24.iterator();
    L17:
        if (r27.hasNext() == false) goto L21;
        Object r28 = r27.next();
        if (Intrinsics.areEqual(((d) r28).f21810a, r21.f21810a) == false) goto L17;
    L22:
        d r29 = (d) r28;
        if (Intrinsics.areEqual(null, null) == true) goto L33;
        Intrinsics.checkNotNullParameter("AIBridgeEventCenter", "tag");
        Intrinsics.checkNotNullParameter("tag is different. remove old subscriber", "msg");
        a1.a.f43a.i("AIBridgeEventCenter", "tag is different. remove old subscriber");
        r24.remove(r29);
        goto L25
    L21:
        r28 = null;
        goto L22
    L9:
        r18 = null;
        goto L10
    L5:
        r16 = null;
        goto L6
    }
}
