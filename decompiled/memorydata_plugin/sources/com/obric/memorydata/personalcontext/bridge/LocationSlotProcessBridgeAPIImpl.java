package com.obric.memorydata.personalcontext.bridge;

import com.obric.memorydata.middleware.api.bridge.ILocationSlotProcessBridgeAPI;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0000H\u0007J(\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/personalcontext/bridge/LocationSlotProcessBridgeAPIImpl;", "Lcom/obric/memorydata/middleware/api/bridge/ILocationSlotProcessBridgeAPI;", "<init>", "()V", "TAG", "", "KEY_LOCATION", "KEY_CONTENT", "getInst", "processLocationSlot", "", "", "slotValues", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocationSlotProcessBridgeAPIImpl implements ILocationSlotProcessBridgeAPI {
    public static final LocationSlotProcessBridgeAPIImpl INSTANCE = null;
    private static final String KEY_CONTENT = "content";
    private static final String KEY_LOCATION = "location";
    private static final String TAG = "LocationSlotProcessBridgeAPIImpl";

    static {
        INSTANCE = new LocationSlotProcessBridgeAPIImpl();
    }

    private LocationSlotProcessBridgeAPIImpl() {
    }

    @JvmStatic
    public static final LocationSlotProcessBridgeAPIImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ILocationSlotProcessBridgeAPI
    public Map<String, List<String>> processLocationSlot(List<String> r8) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "slotValues");
        RunLog.INSTANCE.debug(TAG, "processLocationSlot slotValue: " + r7);
        List r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        boolean r3 = true;
        if (r10.hasNext() == false) goto L18;
        Pair<String, String> r2 = n.f12234a.a((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"));
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2.getFirst(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L12;
        r9.add(r2.getFirst());
    L12:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2.getSecond(), CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L15;
        r3 = false;
    L15:
        if (r3 == false) goto L3;
        r1.add(r2.getSecond());
        goto L3
    L8:
        r5 = false;
        goto L9
    L18:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("location", r9), TuplesKt.to("content", r1)});
    }
}
