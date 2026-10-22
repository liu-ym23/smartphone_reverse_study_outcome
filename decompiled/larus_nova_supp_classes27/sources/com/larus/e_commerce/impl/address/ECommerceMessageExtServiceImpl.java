package com.larus.e_commerce.impl.address;

import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.address.IAddressService;
import com.larus.bmhome.chat.api.IMessageExtService;
import com.larus.dora.api.protocol.FlowProtocolAbility;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import o83.b;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\u000f"}, d2 = {"Lcom/larus/e_commerce/impl/address/ECommerceMessageExtServiceImpl;", "Lcom/larus/bmhome/chat/api/IMessageExtService;", "<init>", "()V", "setSendMessageExt", "", "map", "", "", FlowProtocolAbility.FEATURE_CONVERSATION, "Lcom/larus/im/bean/conversation/Conversation;", "metadata", "Lcom/larus/bmhome/chat/api/IMessageExtService$QueryData;", "getDeliveryAddress", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ECommerceMessageExtServiceImpl implements IMessageExtService {

    public static final class a {
    }

    static {
    }

    public ECommerceMessageExtServiceImpl() {
    }

    public final String service() {
        return "";
    }

    public final void b(Map r1, IMessageExtService.a r2) {
        Intrinsics.checkNotNullParameter(r1, "map");
    }

    public final void a(Map<String, String> r6, e r7, IMessageExtService.a r8) {
        Intrinsics.checkNotNullParameter(r6, "map");
        if (r6.containsKey("delivery_address") == false) goto L5;
        return;
    L5:
        e10 r9 = e10.a;
        String r0 = null;
        if (e10.S().getEnableChatWithDeliveryAddress() == false) goto L50;
        int r10 = ECSdk.a;
        IAddressService r11 = (IAddressService) ECSdk.a(IAddressService.class);
        if (r11 == null) goto L50;
        o83.a r12 = IAddressService.a.a(r11, null, null, 7);
        if (r12 == null) goto L50;
        List r13 = r12.a;
        if (r13 == null) goto L50;
        Iterator r1 = r13.iterator();
    L16:
        if (r1.hasNext() == false) goto L20;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((b) r2).e, "xiaodian.supermarket_pop") == false) goto L16;
    L21:
        b r3 = (b) r2;
        if (r3 != null) goto L24;
        r3 = (b) CollectionsKt.firstOrNull(r13);
    L24:
        if (r3 == null) goto L50;
        int r14 = b.f;
        JSONObject r15 = b.a.a(r3.a, false);
        if (r15 != null) goto L53;
    L48:
        if (r15 == null) goto L50;
        r0 = r15.toString();
        goto L50
    L53:
        JSONObject r4 = r3.a;     // Catch: Exception -> L46
        if (r4 == null) goto L30;
        JSONObject r5 = r4.optJSONObject("poi_info");     // Catch: Exception -> L46
    L31:
        if (r5 == null) goto L34;
        JSONObject r16 = r5.optJSONObject("coordinate");     // Catch: Exception -> L46
    L36:
        if (r16 == null) goto L38;
        String r17 = Double.valueOf(r16.optDouble("latitude")).toString();     // Catch: Exception -> L46
    L39:
        r15.put("latitude", r17);     // Catch: Exception -> L46
        if (r16 == null) goto L43;
        String r18 = Double.valueOf(r16.optDouble("longitude")).toString();     // Catch: Exception -> L46
    L44:
        r15.put("longitude", r18);     // Catch: Exception -> L46
        goto L48
    L43:
        r18 = null;
        goto L44
    L38:
        r17 = null;
        goto L39
    L34:
        r16 = null;
        goto L36
    L30:
        r5 = null;
    L46:
        e = move-exception;
        FLogger.a.e("ECommerceMessageExtServiceImpl", "poiAddress parse error: " + e);
        goto L48
    L20:
        r2 = null;
    L50:
        if (r0 == null) goto L58;
        r6.put("delivery_address", r0);
        return;
    }
}
