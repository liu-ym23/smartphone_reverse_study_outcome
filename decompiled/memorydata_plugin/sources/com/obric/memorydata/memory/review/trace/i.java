package com.obric.memorydata.memory.review.trace;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001)B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\f\u0010\u000b\u001a\u00020\f*\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u000eH\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u000eH\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002R\u000e\u0010 \u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportObservationJson;", "", "<init>", "()V", "encode", "Lorg/json/JSONArray;", "rawObservations", "", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "limitAsrTexts", "observations", "toJson", "Lorg/json/JSONObject;", "limitObservationAsrText", "", "observation", "remainingBytes", "putTruncationMetadata", "", "currentCodePointCount", "retainedText", "", "parsePayload", "payload", "takeCodePoints", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "maxCodePoints", "takeUtf8Prefix", "Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportObservationJson$Utf8Prefix;", "maxBytes", "utf8ByteCount", "codePoint", "MAX_ASR_TEXT_CODE_POINTS_PER_OBSERVATION", "MAX_ASR_TEXT_UTF8_BYTES_PER_BATCH", "KEY_SOURCE", "KEY_PAYLOAD", "KEY_ASR_RESULT", "KEY_TEXT", "KEY_ASR_TEXT_TRUNCATED", "KEY_ASR_TEXT_ORIGINAL_CHAR_COUNT", "KEY_ASR_TEXT_RETAINED_CHAR_COUNT", "Utf8Prefix", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f10494a = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/review/trace/MemoryTraceReportObservationJson$Utf8Prefix;", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "utf8Bytes", "", "<init>", "(Ljava/lang/String;I)V", "getText", "()Ljava/lang/String;", "getUtf8Bytes", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10496b;

        public a(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            this.f10495a = r2;
            this.f10496b = r3;
        }

        public final String a() {
            return this.f10495a;
        }

        public final int b() {
            return this.f10496b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10495a, r6.f10495a) == true) goto L12;
            return false;
        L12:
            if (this.f10496b == r6.f10496b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f10495a.hashCode() * 31) + Integer.hashCode(this.f10496b);
        }

        public String toString() {
            return "Utf8Prefix(text=" + this.f10495a + ", utf8Bytes=" + this.f10496b + ')';
        }
    }

    static {
        f10494a = new i();
    }

    private i() {
    }

    private final int a(int r1) {
        if (r1 > 127) goto L6;
        return 1;
    L6:
        if (r1 > 2047) goto L9;
        return 2;
    L9:
        if (r1 > 65535) goto L11;
        return 3;
    L11:
        return 4;
    }

    private final int a(JSONObject r10, int r11) {
        if (Intrinsics.areEqual(r10.optString(AILabCheckPermissionTask.KEY_SOURCE), "auditory") == true) goto L5;
        return r11;
    L5:
        String r1 = r10.optString("payload");
        Intrinsics.checkNotNull(r1);
        JSONObject r2 = a(r1);
        if (r2 != null) goto L8;
        return r11;
    L8:
        JSONObject r3 = r2.optJSONObject("asr_result");
        if (r3 != null) goto L11;
        return r11;
    L11:
        Object r4 = r3.opt(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L14;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
    L15:
        if (r5 != null) goto L17;
        return r11;
    L17:
        int r6 = r5.codePointCount(0, r5.length());
        a r7 = b(a(r5, 100000), r11);
        boolean r8 = r10.optBoolean("asr_text_truncated", false);
        boolean r9 = !Intrinsics.areEqual(r7.a(), r5);
        if (r9 == false) goto L20;
        r3.put(IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, r7.a());
        r10.put("payload", r2.toString());
    L20:
        if (r8 == true) goto L22;
        if (r9 == true) goto L22;
    L24:
        return r11 - r7.b();
    L22:
        a(r10, r6, r7.a());
        goto L24
    L14:
        r5 = null;
        goto L15
    }

    private final String a(String r2, int r3) {
        if (r2.codePointCount(0, r2.length()) > r3) goto L5;
        return r2;
    L5:
        String r1 = r2.substring(0, r2.offsetByCodePoints(0, r3));
        Intrinsics.checkNotNullExpressionValue(r1, "substring(...)");
        return r1;
    }

    private final JSONObject a(RawObservationEntity r4) {
        JSONObject r3 = new JSONObject().put(OaidModel.KEY_ID, r4.getId()).put("device_id", r4.getDeviceId()).put(AILabCheckPermissionTask.KEY_SOURCE, r4.getSource()).put("timestamp", r4.getTimestamp()).put("span_start", r4.getSpanStart()).put("span_end", r4.getSpanEnd()).put("payload", r4.getPayload()).put("meta", r4.getMeta()).put("state", r4.getState()).put("client_state", r4.getClientState()).put("retry_count", r4.getRetryCount()).put("last_error_code", r4.getLastErrorCode());
        Intrinsics.checkNotNullExpressionValue(r3, "put(...)");
        return r3;
    }

    private final JSONObject a(String r2) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L9;
        return null;
    L9:
        return new JSONObject(r2);
    L11:
        return null;
    }

    private final void a(JSONObject r3, int r4, String r5) {
        int r6 = RangesKt.coerceAtLeast(r3.optInt("asr_text_original_char_count", r4), r4);
        r3.put("asr_text_truncated", true).put("asr_text_original_char_count", r6).put("asr_text_retained_char_count", r5.codePointCount(0, r5.length()));
    }

    private final a b(String r6, int r7) {
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r6.length()) goto L8;
        int r3 = r6.codePointAt(r1);
        int r4 = a(r3) + r2;
        if (r4 > r7) goto L8;
        r1 = r1 + Character.charCount(r3);
        r2 = r4;
    L8:
        String r8 = r6.substring(0, r1);
        Intrinsics.checkNotNullExpressionValue(r8, "substring(...)");
        return new a(r8, r2);
    }

    public final JSONArray a(List<RawObservationEntity> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "rawObservations");
        JSONArray r0 = new JSONArray();
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L7;
        RawObservationEntity r2 = (RawObservationEntity) ZeusTransformUtils.preCheckCast(r7.next(), RawObservationEntity.class, "com.obric.memorydata.plugin");
        r0.put(f10494a.a(r2));
        goto L4
    L7:
        return a(r0);
    }

    public final JSONArray a(JSONArray r5) {
        Intrinsics.checkNotNullParameter(r5, "observations");
        int r0 = r5.length();
        int r1 = 1048576;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        JSONObject r3 = r5.optJSONObject(r2);
        if (r3 == null) goto L8;
        r1 = a(r3, r1);
    L8:
        r2 = r2 + 1;
        goto L3
    L9:
        return r5;
    }
}
