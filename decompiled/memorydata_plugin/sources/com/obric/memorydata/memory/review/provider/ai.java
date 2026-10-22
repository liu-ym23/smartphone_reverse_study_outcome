package com.obric.memorydata.memory.review.provider;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.bdinstall.Api;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.memory.review.model.MemoryReviewModule;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\rH\u0002J\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0005*\u00020\rH\u0002J\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0005*\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\f\u0010\u001a\u001a\u00020\r*\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackTranscriptEnricher;", "", "<init>", "()V", "TAG", "", "enrich", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedback;", "feedback", "transcriptRepository", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptRepository;", "enrichEpisodicAudio", "callerCard", "Lorg/json/JSONObject;", "snapshot", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptSnapshot;", "enrichLegacyAudio", "displayedCard", "readTranscriptText", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackTranscriptEnricher$TranscriptContent;", "Ljava/io/InputStream;", "maxBytes", "", "resolveTranscriptContentUrl", "optNonBlankString", "key", "toLightweightCard", "LIGHTWEIGHT_CARD_KEYS", "", "AUDITORY_EPISODIC_PRODUCT_TYPE", "READ_BUFFER_BYTES", "TranscriptContent", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ai f10410a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f10411b = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackTranscriptEnricher$TranscriptContent;", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "byteCount", "", "<init>", "(Ljava/lang/String;I)V", "getText", "()Ljava/lang/String;", "getByteCount", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10413b;

        public a(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            this.f10412a = r2;
            this.f10413b = r3;
        }

        public final String a() {
            return this.f10412a;
        }

        public final int b() {
            return this.f10413b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10412a, r6.f10412a) == true) goto L12;
            return false;
        L12:
            if (this.f10413b == r6.f10413b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f10412a.hashCode() * 31) + Integer.hashCode(this.f10413b);
        }

        public String toString() {
            return "TranscriptContent(text=" + this.f10412a + ", byteCount=" + this.f10413b + ')';
        }
    }

    static {
        f10410a = new ai();
        f10411b = CollectionsKt.listOf(new String[]{"createTime", "modifyTime", Api.KEY_UUID, "title", Params.CONTENT, "startTimestamp", "endTimestamp", "productType", "logId"});
    }

    private ai() {
    }

    private final com.obric.memorydata.memory.review.model.c a(com.obric.memorydata.memory.review.model.c r15, JSONObject r16) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(a(r16, "transcriptText"), CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L11;
        return r15;
    L11:
        String r0 = a(r16);
        if (r0 != null) goto L41;
        return r15;
    L41:
        long r5 = SystemClock.elapsedRealtime();     // Catch: RuntimeException -> L31 IOException -> L33
        InputStream r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver().openInputStream(Uri.parse(r0));     // Catch: RuntimeException -> L31 IOException -> L33
        if (r1 == null) goto L30;
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(r1, Closeable.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L31 IOException -> L33
        a r7 = f10410a.a((InputStream) ZeusTransformUtils.preCheckCast(r6, InputStream.class, "com.obric.memorydata.plugin"), 1048576);     // Catch: Throwable -> L23
        CloseableKt.closeFinally(r6, null);     // Catch: RuntimeException -> L31 IOException -> L33
        if (r7 == null) goto L30;
        RunLog.INSTANCE.debug("MemoryReviewFeedbackTranscriptEnricher", "enrich legacy feedback transcript success recordId=" + r15.a() + " bytes=" + r7.b() + " costMs=" + (SystemClock.elapsedRealtime() - r5));     // Catch: RuntimeException -> L31 IOException -> L33
        r16.put("transcriptText", r7.a());     // Catch: RuntimeException -> L31 IOException -> L33
        String r8 = r16.toString();     // Catch: RuntimeException -> L31 IOException -> L33
        Intrinsics.checkNotNullExpressionValue(r8, "toString(...)");     // Catch: RuntimeException -> L31 IOException -> L33
        return com.obric.memorydata.memory.review.model.c.a(r15, null, null, null, null, null, r8, null, null, 223, null);
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: RuntimeException -> L31 IOException -> L33
        throw th;     // Catch: RuntimeException -> L31 IOException -> L33
    L30:
        return r15;
    L33:
        e = e;
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r9 = new StringBuilder();
    L35:
        IRunLog.a.a(r2, "MemoryReviewFeedbackTranscriptEnricher", r9.append("enrich legacy feedback transcript failed, errorType=").append(e.getClass().getSimpleName()).toString(), null, 4, null);
        return r15;
    L31:
        e = e;
        r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r9 = new StringBuilder();
        goto L35
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r4 = false;
        goto L9
    }

    private final com.obric.memorydata.memory.review.model.c a(com.obric.memorydata.memory.review.model.c r25, JSONObject r26, k r27) {
        if (r26 == null) goto L6;
        JSONObject r0 = b(r26);
        if (r0 == null) goto L6;
    L7:
        String r7 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        if (r27 == null) goto L10;
        List<String> r1 = r27.g();
    L11:
        if (r1 != null) goto L13;
        r1 = CollectionsKt.emptyList();
    L13:
        com.obric.memorydata.memory.review.model.c r2 = com.obric.memorydata.memory.review.model.c.a(r25, null, null, null, null, null, r7, null, r1, 95, null);
        if (r27 != null) goto L16;
        return r2;
    L16:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r27.e(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L18;
        return r2;
    L18:
        if (r27.f() > 1048576) goto L27;
        r0.put("transcriptText", r27.e());     // Catch: JSONException -> L22
        String r3 = r0.toString();     // Catch: JSONException -> L22
        Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");     // Catch: JSONException -> L22
        return com.obric.memorydata.memory.review.model.c.a(r2, null, null, null, null, null, r3, null, null, 223, null);
    L28:
        return r2;
    L27:
        return r2;
    L10:
        r1 = null;
    L6:
        r0 = new JSONObject();
        goto L7
    }

    private final a a(InputStream r13, int r14) {
        ByteArrayOutputStream r12 = new ByteArrayOutputStream(Math.min(r14, 8192));
        byte[] r0 = new byte[8192];
        int r2 = 0;
    L3:
        int r3 = r13.read(r0);
        if (r3 < 0) goto L11;
        if (r3 == 0) goto L3;
        r2 = r2 + r3;
        if (r2 > r14) goto L8;
        r12.write(r0, 0, r3);
        goto L3
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryReviewFeedbackTranscriptEnricher", "skip legacy transcript enrichment because file exceeds maxBytes=" + r14, null, 4, null);
        return null;
    L11:
        String r15 = r12.toString(Charsets.UTF_8.name());
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L15;
        r15 = null;
    L15:
        if (r15 != null) goto L18;
        return null;
    L18:
        return new a(r15, r2);
    }

    private final String a(JSONObject r6) {
        String r0 = a(r6, "transcriptContentUrl");
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r1 = a(r6, "transcriptUrl");
        if (r1 == null) goto L8;
        return r1;
    L8:
        Object r7 = r6.opt("transcript");
        if (ZeusTransformUtils.instanceOf(r7, JSONObject.class) == false) goto L12;
        return a((JSONObject) ZeusTransformUtils.preCheckCast(r7, JSONObject.class, "com.obric.memorydata.plugin"), "contentUrl");
    L12:
        if (ZeusTransformUtils.instanceOf(r7, String.class) == false) goto L20;
        return a(new JSONObject((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin")), "contentUrl");
    L21:
        return null;
    L20:
        return null;
    }

    private final String a(JSONObject r2, String r3) {
        if (r2.has(r3) == true) goto L5;
        return null;
    L5:
        if (r2.isNull(r3) == true) goto L18;
        String r1 = r2.optString(r3);
        Intrinsics.checkNotNull(r1);
        boolean r4 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L10;
    L12:
        r4 = false;
    L13:
        if (r4 == true) goto L15;
        return null;
    L15:
        return r1;
    L10:
        if (Intrinsics.areEqual(r1, "null") == true) goto L12;
    L18:
        return null;
    }

    private final JSONObject b(JSONObject r5) {
        JSONObject r4 = new JSONObject();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(f10411b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (r5.has(r1) == false) goto L4;
        if (r5.isNull(r1) == true) goto L4;
        r4.put(r1, r5.opt(r1));
        goto L4
    L10:
        return r4;
    }

    public final com.obric.memorydata.memory.review.model.c a(com.obric.memorydata.memory.review.model.c r11, h r12) {
        Intrinsics.checkNotNullParameter(r11, "feedback");
        Intrinsics.checkNotNullParameter(r12, "transcriptRepository");
        if (r11.b() == MemoryReviewModule.AUDIO_MEMORY) goto L5;
        return r11;
    L5:
        k r0 = null;
        JSONObject r1 = new JSONObject(r11.f());     // Catch: JSONException -> L8
    L9:
        boolean r2 = true;
        r0 = r12.a(r11.a(), true);     // Catch: RuntimeException -> L12
    L15:
        if (r0 != null) goto L25;
        if (r1 != null) goto L18;
    L20:
        boolean r3 = false;
    L21:
        if (r3 == true) goto L25;
        if (r1 == null) goto L25;
        r2 = false;
        goto L25
    L18:
        if (r1.optInt("productType", -1) != 1006) goto L20;
        r3 = true;
    L25:
        if (r2 == false) goto L28;
        return a(r11, r1, r0);
    L28:
        return a(r11, r1);
    L12:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryReviewFeedbackTranscriptEnricher", "enrich feedback transcript failed, errorType=" + e.getClass().getSimpleName(), null, 4, null);
    L8:
        r1 = null;
        goto L9
    }
}
