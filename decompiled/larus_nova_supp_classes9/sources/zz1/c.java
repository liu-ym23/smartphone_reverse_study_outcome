package zz1;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.x;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.f1;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.kmp.livesdk.gift.platform.aio.service.client.OperationResultCode;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oc6.i0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements oc6.l, com.bytedance.android.scope.o {
    public final f1 a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final oc6.c getCurrentAISortInfo() {
        this.a.getClass();
        JSONObject r1 = new JSONObject();
        r1.put("room_live_scene", null);
        r1.put("strategy_info", null);
        return new oc6.c(r1.toString());
    }

    public c(f1 r2) {
        Intrinsics.checkNotNullParameter(r2, "listSortService");
        this.a = r2;
    }

    public final i0 getAllGiftAIAgentDataByDimension(String r5) {
        Intrinsics.checkNotNullParameter(r5, "dimensionKey");
        x r0 = (x) com.bytedance.android.live.revenue.core.util.f.a(x.class);
        Intrinsics.checkNotNullParameter(r5, "key");
        if (Intrinsics.areEqual(r5, BuildConfig.FLAVOR) == true) goto L14;
        Map r6 = (Map) ((LinkedHashMap) r0.a).get(r5);
        if (r6 == null) goto L11;
        Collection r7 = r6.values();
        if (r7 == null) goto L11;
        List r8 = CollectionsKt.toList(r7);
        if (r8 == null) goto L11;
    L13:
        return new i0(0, r8, null, 5);
    L11:
        r8 = CollectionsKt.emptyList();
        goto L13
    L14:
        return new i0(OperationResultCode.KeyIsEmpty.getValue(), null, "Key is empty!", 2);
    }

    public final i0 removeSingleGiftAIAgentData(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "dimensionKey");
        Intrinsics.checkNotNullParameter(r6, "queryId");
        x r1 = (x) com.bytedance.android.live.revenue.core.util.f.a(x.class);
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "queryId");
        if (Intrinsics.areEqual(r5, BuildConfig.FLAVOR) == true) goto L16;
        Map r7 = (Map) ((LinkedHashMap) r1.a).get(r5);
        if (r7 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L15;
        r7.remove(r6);
        return new i0(0, null, null, 7);
    L15:
        return new i0(OperationResultCode.ListIsEmpty.getValue(), null, "Current list does not exist!", 2);
    L8:
        if (r7.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    L16:
        return new i0(OperationResultCode.KeyIsEmpty.getValue(), null, "Key is empty!", 2);
    }

    public final i0 pushSingleGiftAIAgentData(String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "dimensionKey");
        Intrinsics.checkNotNullParameter(r6, "queryId");
        Intrinsics.checkNotNullParameter(r7, "data");
        x r1 = (x) com.bytedance.android.live.revenue.core.util.f.a(x.class);
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "queryId");
        Intrinsics.checkNotNullParameter(r7, "element");
        if (Intrinsics.areEqual(r5, BuildConfig.FLAVOR) == false) goto L6;
        return new i0(OperationResultCode.KeyIsEmpty.getValue(), null, "Key is empty!", 2);
    L6:
        if (r1.a.size() >= r1.b) goto L8;
    L10:
        LinkedHashMap r0 = (LinkedHashMap) r1.a;
        Object r3 = r0.get(r5);
        if (r3 != null) goto L13;
        r3 = new LinkedHashMap();
        r0.put(r5, r3);
    L13:
        Map r4 = (Map) r3;
        r4.put(r6, r7);
        if (r4.size() <= r1.c) goto L17;
        r4.remove(CollectionsKt.first(r4.keySet()));
    L17:
        return new i0(0, null, null, 7);
    L8:
        if (r1.a.containsKey(r5) == true) goto L10;
        String r2 = (String) CollectionsKt.first(((LinkedHashMap) r1.a).keySet());
        r1.a.remove(r2);
        goto L10
    }

    public final i0 updateSingleGiftAIAgentData(String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "dimensionKey");
        Intrinsics.checkNotNullParameter(r6, "queryId");
        Intrinsics.checkNotNullParameter(r7, "data");
        x r1 = (x) com.bytedance.android.live.revenue.core.util.f.a(x.class);
        Intrinsics.checkNotNullParameter(r5, "key");
        Intrinsics.checkNotNullParameter(r6, "queryId");
        Intrinsics.checkNotNullParameter(r7, "element");
        if (Intrinsics.areEqual(r5, BuildConfig.FLAVOR) == true) goto L16;
        Map r8 = (Map) ((LinkedHashMap) r1.a).get(r5);
        if (r8 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L15;
        r8.put(r6, r7);
        return new i0(0, null, null, 7);
    L15:
        return new i0(OperationResultCode.ListIsEmpty.getValue(), null, "Current list does not exist!", 2);
    L8:
        if (r8.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    L16:
        return new i0(OperationResultCode.KeyIsEmpty.getValue(), null, "Key is empty!", 2);
    }
}
