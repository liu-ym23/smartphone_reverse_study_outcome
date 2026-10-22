package x20;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.updateByteLinkListener", owner = "JiangXZ")
public final class g extends b implements h {
    public final String d;
    public f e;
    public final Map<String, Integer> f;

    public final void release() {
        ALogger.i(this.d, "release Jsb ListenMap:" + this.f);
        f r0 = this.e;
        if (r0 == null) goto L8;
        Iterator r1 = ((LinkedHashMap) this.f).entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        com.ss.ugc.live.sdk.platform.a.f.m((String) ((Map.Entry) r1.next()).getKey(), r0);
    L8:
        ((LinkedHashMap) this.f).clear();
        this.e = null;
    }

    public g() {
        this.d = "LiveUpdateByteLinkListenerMethod";
        this.f = new LinkedHashMap();
    }

    public final void handle(IBDXBridgeContext r11, XBaseParamModel r12, CompletionBlock r13) {
        b.InterfaceC0294b r14 = (b.InterfaceC0294b) r12;
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        List<String> r0 = r14.getMessageMethod();
        ALogger.i(this.d, "invoke JSB(" + hashCode() + ") Param ActionType:" + r14.getActionType() + ", Method: " + r14.getMessageMethod() + '}');
        if (r0 != null) goto L5;
        r13.onFailure(0, "Message List isEmpty", ne7.e.b(b.c.class));
        return;
    L5:
        Number r15 = r14.getActionType();
        if (Intrinsics.areEqual(r15, 1) == false) goto L26;
        Iterator<T> r16 = r0.iterator();
    L9:
        if (r16.hasNext() == false) goto L24;
        String r1 = (String) r16.next();
        if (this.e != null) goto L13;
        ALogger.i(this.d, "Create Payload Listener");
        this.e = new f(this, r1, r11);
    L13:
        Integer r3 = (Integer) ((LinkedHashMap) this.f).get(r1);
        if (r3 == null) goto L16;
        int r4 = r3.intValue();
    L17:
        ALogger.i(this.d, "Method(" + r1 + ") methodListenCount:" + r4);
        if (r4 == 0) goto L19;
        this.f.put(r1, Integer.valueOf(r4 + 1));
        goto L9
    L19:
        f r5 = this.e;
        if (r5 == null) goto L22;
        com.ss.ugc.live.sdk.platform.a.f.d(r1, r5);
    L22:
        this.f.put(r1, 1);
        goto L9
    L16:
        r4 = 0;
        goto L17
    L24:
        CompletionBlock.DefaultImpls.onSuccess$default(r13, ne7.e.b(b.c.class), null, 2, null);
        return;
    L26:
        if (Intrinsics.areEqual(r15, 2) == false) goto L44;
        Iterator<T> r17 = r0.iterator();
    L29:
        if (r17.hasNext() == false) goto L43;
        String r18 = (String) r17.next();
        f r2 = this.e;
        if (r2 == null) goto L29;
        Integer r6 = (Integer) ((LinkedHashMap) this.f).get(r18);
        if (r6 == null) goto L36;
        int r7 = r6.intValue();
    L37:
        ALogger.i(this.d, "Method(" + r18 + ") methodListenCount:" + r7);
        if (r7 > 1) goto L39;
        this.f.remove(r18);
        if (r7 != 1) goto L29;
        com.ss.ugc.live.sdk.platform.a.f.m(r18, r2);
        goto L29
    L39:
        this.f.put(r18, Integer.valueOf(r7 - 1));
        goto L29
    L36:
        r7 = 0;
        goto L37
    L43:
        CompletionBlock.DefaultImpls.onSuccess$default(r13, ne7.e.b(b.c.class), null, 2, null);
        return;
    L44:
        r13.onFailure(0, "Action Type isNot Support", ne7.e.b(b.c.class));
    }
}
