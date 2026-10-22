package com.bytedance.android.live.browser.jsbridge.answer;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.registerMessage", owner = "JiangXZ")
public final class h extends a implements com.bytedance.sdk.xbridge.cn.protocol.h {
    public static final /* synthetic */ int h = 0;
    public final String d;
    public f e;
    public g f;
    public final Set<String> g;

    public final void release() {
        ALogger.i(this.d, "LiveRegisterMessageMethod release");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 1);
        if (r0 == null) goto L19;
        Iterator<T> r1 = this.g.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        String r2 = (String) r1.next();
        emc.a r3 = (emc.a) r0.getStreamMessageManager().getValue();
        if (r3 == null) goto L6;
        r3.removeMessageListener(r2, this.f);
        goto L6
    L10:
        this.g.clear();
        vlc.d r4 = (vlc.d) r0.getMessageManager().getValue();
        if (r4 == null) goto L20;
        r4.removeMessageListener(this.e);
        return;
    L20:
        return;
    }

    public h() {
        this.d = "LiveRegisterMessageMethod";
        this.g = new LinkedHashSet();
    }

    public final void handle(final IBDXBridgeContext r8, XBaseParamModel r9, CompletionBlock r11) {
        a.b r12 = (a.b) r9;
        Intrinsics.checkNotNullParameter(r8, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "callback");
        long r0 = CastLongProtector.parseLong(r12.getRoomId());
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, null, r0, 1);
        if (r2 != null) goto L5;
        r2 = RoomContext.a.b(null, r12.getUniqueIdPreview());
    L5:
        ALogger.i(this.d, "LiveRegisterMessageMethod get RoomContext roomId: " + r0 + ", roomContext: " + r2);
        if (r2 == null) goto L32;
        List<String> r1 = r12.getNormalMessageMethod();
        if (r1 == null) goto L14;
        Iterator<T> r3 = r1.iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        final String r4 = (String) r3.next();
        r2.getMessageManager().c(new LiveRegisterMessageMethod$registerNormalMessage$1(this, r4, r8));
    L14:
        List<String> r13 = r12.getStreamMessageMethod();
        if (r13 == null) goto L26;
        Iterator<T> r14 = r13.iterator();
    L18:
        if (r14.hasNext() == false) goto L26;
        final String r5 = (String) r14.next();
        final Ref.ObjectRef r6 = new Ref.ObjectRef();
        r6.element = r5;
        if (StringsKt.startsWith$default(r5, "Webcast", false, 2, null) == true) goto L23;
        r6.element = "Webcast" + r5;
    L23:
        if (this.f != null) goto L25;
        this.f = new g(this, r6, r8);
    L25:
        r2.getMessageManager().c(new LiveRegisterMessageMethod$registerStreamMessage$2(this, r6, r5, r8));
        r2.getStreamMessageManager().c(new LiveRegisterMessageMethod$registerStreamMessage$3(this, r6));
    L26:
        CompletionBlock.DefaultImpls.onSuccess$default(r11, ne7.e.b(a.c.class), null, 2, null);
        return;
    }

    public static final void a(h r1, tlc.d r2, String r3, IBDXBridgeContext r4) {
        r1.getClass();
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("sync_data", GsonProtectorUtils.toJson(GsonHelper.get(), r2));
        r5.put("class_name", r3);
        r4.sendEvent("H5_wrds", r5);
    }
}
