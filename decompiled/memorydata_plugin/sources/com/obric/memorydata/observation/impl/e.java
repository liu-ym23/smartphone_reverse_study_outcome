package com.obric.memorydata.observation.impl;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.utils.n;
import com.obric.memorydata.utils.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/observation/impl/ScreenshotRawObservationAdapter;", "", "<init>", "()V", "contextMetaKeys", "", "", "toRawObservation", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "src", "Lcom/obric/memorydata/observation/api/ScreenshotObservationInput;", "deviceId", "observation_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f12000a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f12001b = null;

    static {
        f12000a = new e();
        f12001b = SetsKt.setOf(new String[]{"location", "location_state", "locationstate", "longitude", "latitude", "movement_state", "movementstate", "commute_state", "commutestate", "har_state", "harstate"});
    }

    private e() {
    }

    public final RawObservationEntity a(com.obric.memorydata.observation.api.b r24, String r25) {
        Intrinsics.checkNotNullParameter(r24, "src");
        Intrinsics.checkNotNullParameter(r25, "deviceId");
        String r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r24.l(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        o r2 = n.f13250a.a();
        JSONObject r5 = new JSONObject().put("type", "image").put("screenshot_path", r24.e()).put("image_tos_key", r24.f());
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r24.m(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L5;
        r5.put("view_tree_path", r24.m());
    L5:
        JSONObject r6 = new JSONObject().put(Api.KEY_APP_NAME, r24.c()).put("package_name", r24.d()).put("app_version_name", r24.o()).put("app_version_code", r24.p()).put("trigger_type", r24.b()).put("click_detail", r24.j()).put("scroll_detail", r24.k());
        if (r2.a() == false) goto L11;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r24.g(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L11;
        r6.put("location", r24.g());
    L11:
        if (r2.a() == false) goto L16;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r24.h(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L16;
        r6.put("location_state", r24.h());
    L16:
        if (r2.b() == false) goto L21;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r24.i(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L21;
        r6.put("movement_state", r24.i());
    L21:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L23;
        r6.put("client_rule_ids", r0);
    L23:
        Iterator<Map.Entry<String, String>> r3 = r24.n().entrySet().iterator();
    L25:
        if (r3.hasNext() == false) goto L35;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.memorydata.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r7.getValue(), String.class, "com.obric.memorydata.plugin");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L25;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L25;
        Set<String> r10 = f12001b;
        String r11 = r8.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r11, "toLowerCase(...)");
        if (r10.contains(r11) == true) goto L25;
        if (r6.has(r8) == true) goto L25;
        r6.put(r8, r9);
        goto L25
    L35:
        long r12 = r24.a();
        long r13 = r24.a();
        long r14 = r24.a();
        String r15 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r15, "toString(...)");
        String r16 = r6.toString();
        Intrinsics.checkNotNullExpressionValue(r16, "toString(...)");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r24.e(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L38;
    L41:
        String r21 = "PENDING";
    L43:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L45;
        String r1 = "PENDING";
    L47:
        return new RawObservationEntity(0, r25, "screenshot", r12, r13, r14, r15, r16, r21, r1, 0, 0, 3073, null);
    L45:
        r1 = "NONE";
        goto L47
    L38:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r24.f(), CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L41;
        r21 = RawObservationEntity.STATE_WAIT_MEDIA;
        goto L43
    }
}
