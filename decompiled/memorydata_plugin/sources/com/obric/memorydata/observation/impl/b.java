package com.obric.memorydata.observation.impl;

import androidx.core.view.InputDeviceCompat;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/observation/impl/GlassesRawObservationAdapter;", "", "<init>", "()V", "ERROR_INVALID_EVENT_TIME", "", "ERROR_INVALID_PAYLOAD", "toRawObservation", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "src", "Lcom/obric/memorydata/observation/api/GlassesObservationInput;", "buildMeta", "Lorg/json/JSONObject;", "validationError", "mediaType", "", "observation_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11997a = null;

    static {
        f11997a = new b();
    }

    private b() {
    }

    private final int a(com.obric.memorydata.observation.api.a r9, String r10) {
        if (r9.c() > 0) goto L6;
        return 3101;
    L6:
        if (Intrinsics.areEqual(r10, "audio") == false) goto L26;
        if (r9.d() > 0) goto L10;
    L24:
        return 3101;
    L10:
        if (r9.e() < r9.d()) goto L24;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9.g(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L15;
    L23:
        return 3102;
    L15:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9.i(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L23;
        if (r9.h() != 1) goto L20;
    L22:
        return 0;
    L20:
        if (r9.h() == 2) goto L22;
        return 3102;
    L26:
        if (Intrinsics.areEqual(r10, "image") == true) goto L28;
        return 3102;
    L28:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r9.m(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L30;
        return 0;
    L30:
        return 3102;
    }

    private final JSONObject b(com.obric.memorydata.observation.api.a r5) {
        JSONObject r4 = new JSONObject();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5.l(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L6;
        r4.put("profile_id", r5.l());
    L6:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5.n(), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L9;
        r4.put("image_url", r5.n());
    L9:
        if (r5.o() <= 0) goto L11;
        r4.put("media_expire_at_ms", r5.o());
    L11:
        return r4;
    }

    public final RawObservationEntity a(com.obric.memorydata.observation.api.a r26) {
        Intrinsics.checkNotNullParameter(r26, "src");
        String r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r26.b(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        Locale r2 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r2, "ROOT");
        String r3 = r1.toLowerCase(r2);
        Intrinsics.checkNotNullExpressionValue(r3, "toLowerCase(...)");
        JSONObject r4 = new JSONObject().put("device_time", r26.c()).put("server_time", r26.f()).put("media_type", r3);
        if (Intrinsics.areEqual(r3, "audio") == false) goto L7;
        Object r5 = new JSONObject().put("start_time", r26.d()).put("end_time", r26.e()).put("role", r26.h()).put("seq_id", r26.j()).put("back_tracking_type", r26.k()).put("local_speaker_id", r26.i()).put(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, r26.g());
        String r6 = "asr_result";
    L5:
        r4.put(r6, r5);
    L9:
        JSONObject r7 = b(r26);
        Iterator<Map.Entry<String, String>> r8 = r26.p().entrySet().iterator();
    L11:
        if (r8.hasNext() == false) goto L19;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9.getKey(), String.class, "com.obric.memorydata.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r9.getValue(), String.class, "com.obric.memorydata.plugin");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L11;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L11;
        if (r7.has(r10) == true) goto L11;
        r7.put(r10, r11);
        goto L11
    L19:
        int r22 = a(r26, r3);
        String r12 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r26.a(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        long r13 = r26.c();
        long r14 = r26.d();
        long r15 = r26.e();
        String r0 = r4.toString();
        Intrinsics.checkNotNullExpressionValue(r0, "toString(...)");
        String r16 = r7.toString();
        Intrinsics.checkNotNullExpressionValue(r16, "toString(...)");
        if (r22 != 0) goto L22;
        String r17 = "PENDING";
    L24:
        return new RawObservationEntity(0, r12, "glasses", r13, r14, r15, r0, r16, r17, "NONE", 0, r22, InputDeviceCompat.SOURCE_GAMEPAD, null);
    L22:
        r17 = RawObservationEntity.STATE_FAILED;
        goto L24
    L7:
        if (Intrinsics.areEqual(r3, "image") == false) goto L9;
        r5 = r26.m();
        r6 = "media_ref";
        goto L5
    }
}
