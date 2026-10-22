package jab;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.statistics.Statistics;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends q5c.a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: jab.a$a, reason: collision with other inner class name */
    public static final class C0240a {
        public static void a(Chat r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "chat");
            Map r0 = MapsKt.mapOf(new Pair[]{TuplesKt.to(Boolean.valueOf(r4.isThread()), "circle"), TuplesKt.to(Boolean.valueOf(!r4.isCrossTenant()), "internal"), TuplesKt.to(Boolean.valueOf(r4.isCrossTenant()), "external"), TuplesKt.to(Boolean.valueOf(r4.is_department()), "department"), TuplesKt.to(Boolean.valueOf(r4.isTenant()), "all_staff"), TuplesKt.to(Boolean.valueOf(r4.isOnCall()), "on_call"), TuplesKt.to(Boolean.valueOf(r4.isCustomerService()), "customer_service"), TuplesKt.to(Boolean.valueOf(r4.isMeeting()), "meeting")});
            LinkedHashMap r1 = new LinkedHashMap();
            Iterator r2 = r0.entrySet().iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            Map.Entry r3 = (Map.Entry) r2.next();
            ((Boolean) r3.getKey()).booleanValue();
            r1.put(r3.getKey(), r3.getValue());
            goto L4
        L6:
            List r6 = CollectionsKt.toList(r1.values());
            if (r4.isPublic() == false) goto L9;
            String r7 = "public";
        L10:
            boolean r8 = r4.isCrossTenant();
            JSONObject r9 = new JSONObject();
            r9.put("source", r5);
            r9.put(IPortraitService.TYPE, r6);
            r9.put("mode", r7);
            r9.put("is_external", r8 ? 1 : 0);
            Statistics.sendEvent("im_chat_create_success", r9);
            return;
        L9:
            r7 = "private";
            goto L10
        }
    }

    static {
    }
}
