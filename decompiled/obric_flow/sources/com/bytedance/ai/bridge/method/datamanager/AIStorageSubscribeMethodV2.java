package com.bytedance.ai.bridge.method.datamanager;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import com.lynx.tasm.t;
import com.lynx.tasm.utils.d;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import m2.a;
import m2.b;
import n1.c;
import o1.f;
import ym.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/method/datamanager/AIStorageSubscribeMethodV2;", "Lcom/bytedance/ai/bridge/method/datamanager/AbsSubscribeStorageMethodIDL;", "<init>", "()V", "", "mustRunInMain", "()Z", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/datamanager/AbsSubscribeStorageMethodIDL$SubscribeStorageParam;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/datamanager/AbsSubscribeStorageMethodIDL$SubscribeStorageResultModal;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/datamanager/AbsSubscribeStorageMethodIDL$SubscribeStorageParam;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIStorageSubscribeMethodV2 extends AbsSubscribeStorageMethodIDL {
    public AIStorageSubscribeMethodV2() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsSubscribeStorageMethodIDL.SubscribeStorageParam) r10, r11);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public boolean mustRunInMain() {
        return true;
    }

    public void handle(c r10, AbsSubscribeStorageMethodIDL.SubscribeStorageParam r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        if (r11.getGroupId().length() != 0) goto L7;
        r12.a("no group id");
        return;
    L7:
        if (r11.isShared() == true) goto L10;
        Intrinsics.checkNotNullParameter(AbsSubscribeStorageMethodIDL.SubscribeStorageResultModal.class, "<this>");
        r12.b((ResultModel) e.c(AbsSubscribeStorageMethodIDL.SubscribeStorageResultModal.class), "");
        return;
    L10:
        a r13 = d.j(r10);
        if (r13 != null) goto L14;
        r12.a("no find AiContainer");
        return;
    L14:
        t r14 = d.g(r10, r11);
        if (r14 != null) goto L18;
        r12.a("no find ViewModel");
        return;
    L18:
        String r5 = r14.b(r11.getGroupId(), r11.getStorageId());
        String r15 = r11.getKey();
        boolean r16 = r11.isPersist();
        WeakReference r17 = new WeakReference(r13);
        m2.c r18 = new m2.c(r5, r15, r16, r17);
        Intrinsics.checkNotNullParameter(r18, "subscriber");
        String r19 = "subscribeStorageItem " + r18;
        Intrinsics.checkNotNullParameter("AIStorageItem", "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L21;
        r20.d("AIStorageItem", r19);
    L21:
        Lazy r21 = (Lazy) r14.f;
        CopyOnWriteArrayList r22 = (CopyOnWriteArrayList) ((ConcurrentHashMap) r21.getValue()).get(r5);
        if (r22 != null) goto L25;
        r22 = new CopyOnWriteArrayList();
        ((ConcurrentHashMap) r21.getValue()).put(r5, r22);
    L27:
        r22.add(r18);
        ((ConcurrentHashMap) r21.getValue()).put(r5, r22);
        if (r16 == false) goto L30;
        b r23 = (r9.c) r14.e;
    L31:
        String r24 = r23.a(r5, r15, null);
        if (r24 == null) goto L36;
        List<String> r25 = new Regex("&").split(r5, 0);
        a r26 = (a) r17.get();
        if (r26 == null) goto L36;
        JsonObject r27 = new JsonObject();
        r27.addProperty("groupID", (String) r14.f10963c);
        r27.addProperty("storageID", r25.get(r25.size() - 1));
        r27.addProperty("persistent", Boolean.valueOf(r16));
        r27.addProperty(STGroup.DICT_KEY, r15);
        r27.addProperty("value", r24);
        Unit r28 = Unit.INSTANCE;
        r26.onMessageToAIBridge("onDataUpdated", r27);
    L36:
        Intrinsics.checkNotNullParameter(AbsSubscribeStorageMethodIDL.SubscribeStorageResultModal.class, "<this>");
        r12.b((ResultModel) e.c(AbsSubscribeStorageMethodIDL.SubscribeStorageResultModal.class), "");
        return;
    L30:
        r23 = (o) r14.d;
        goto L31
    L25:
        if (r22.contains(r18) == false) goto L27;
        goto L27
    }
}
