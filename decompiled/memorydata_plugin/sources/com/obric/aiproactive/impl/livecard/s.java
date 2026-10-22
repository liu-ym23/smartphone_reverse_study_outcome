package com.obric.aiproactive.impl.livecard;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\u0000\u001a$\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b*\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0002¨\u0006\f"}, d2 = {"buildLockScreenCardShowParams", "", "", "", "recommendationId", "buildLockScreenCardClickParams", "buttonType", "shouldReportLockScreenIgnore", "", "detachedSessionFound", "toJsonObject", "Lorg/json/JSONObject;", "ai_proactive_impl_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class s {
    public static final Map<String, Object> a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "recommendationId");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("show_position", "lock_screen"), TuplesKt.to("recommandation_id", r3), TuplesKt.to("rank", 1)});
    }

    public static final Map<String, Object> a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "recommendationId");
        Intrinsics.checkNotNullParameter(r4, "buttonType");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("click_position", "lock_screen"), TuplesKt.to("button_type", r4), TuplesKt.to("recommandation_id", r3), TuplesKt.to("rank", 1)});
    }

    public static final /* synthetic */ JSONObject a(Map r2) {
        return b((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"));
    }

    public static final boolean a(boolean r0) {
        return r0;
    }

    private static final JSONObject b(Map<String, ? extends Object> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        JSONObject r0 = new JSONObject();
        Iterator r7 = r6.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.put((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), r2.getValue());
        goto L4
    L6:
        return r0;
    }
}
