package com.ss.android.lark.lynxkit.xbridge;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import com.lynx.react.bridge.JavaOnlyMap;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012 \u0010\u0002\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R(\u0010\u0002\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/XBridgeLynxJsEventDelegate;", "Lcom/bytedance/ies/xbridge/XBridgeMethod$JsEventDelegate;", "sendGlobalEvent", "Lkotlin/Function2;", "", "", "", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "sendJsEvent", "eventName", "params", "Lcom/bytedance/ies/xbridge/XReadableMap;", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class XBridgeLynxJsEventDelegate implements XBridgeMethod.b {
    private final Function2<String, List<? extends Object>, Unit> sendGlobalEvent;

    /* JADX WARN: Multi-variable type inference failed */
    public XBridgeLynxJsEventDelegate(Function2<? super String, ? super List<? extends Object>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "sendGlobalEvent");
        this.sendGlobalEvent = r2;
    }

    public void sendJsEvent(String r3, XReadableMap r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        JavaOnlyMapConverter r0 = JavaOnlyMapConverter.INSTANCE;
        if (r4 == null) goto L6;
        Map r5 = r4.toMap();
        if (r5 == null) goto L6;
    L7:
        JavaOnlyMap r6 = r0.toLynxMap(MapsKt.mapOf(TuplesKt.to("data", r5)));
        this.sendGlobalEvent.invoke(r3, CollectionsKt.listOf(r6));
        return;
    L6:
        r5 = MapsKt.emptyMap();
        goto L7
    }
}
