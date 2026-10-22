package com.obric.memorydata.memory.review.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0005J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0005J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/review/model/MemoryReviewCursor;", "", "<init>", "()V", "KEY_WINDOW_END_TIME", "", "KEY_LAST_CREATED_AT", "KEY_LAST_RECORD_ID", "KEY_LEGACY_UPDATE_TIME", "KEY_LEGACY_RECORD_ID", "encode", "windowEndTimeMillis", "", "lastCreatedAt", "lastRecordId", "updateTimeMillis", "recordId", "decode", "Lcom/obric/memorydata/memory/review/model/MemoryReviewCursorValue;", "cursor", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10381a = null;

    static {
        f10381a = new a();
    }

    private a() {
    }

    public final b a(String r12) {
        String r0 = "lastRecordId";
        String r1 = "lastCreatedAt";
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        Object r4 = null;
        if (r3 == false) goto L30;
        return null;
    L30:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L22
        a r11 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        JSONObject r13 = new JSONObject(r12);     // Catch: Throwable -> L22
        long r6 = r13.optLong("windowEndTimeMillis", Long.MAX_VALUE);     // Catch: Throwable -> L22
        if (r13.has("lastCreatedAt") == true) goto L16;
        r1 = "updateTimeMillis";
    L16:
        long r7 = r13.getLong(r1);     // Catch: Throwable -> L22
        if (r13.has("lastRecordId") == true) goto L20;
        r0 = "recordId";
    L20:
        String r14 = r13.getString(r0);     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L22
        Object r15 = Result.m1421constructorimpl(new b(r6, r7, r14));     // Catch: Throwable -> L22
    L25:
        if (Result.m1427isFailureimpl(r15) == true) goto L29;
        r4 = r15;
    L29:
        return (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin");
    L22:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L25
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r3 = false;
        goto L9
    }

    public final String a(long r3, long r5, String r7) {
        Intrinsics.checkNotNullParameter(r7, "lastRecordId");
        String r2 = new JSONObject().put("windowEndTimeMillis", r3).put("lastCreatedAt", r5).put("lastRecordId", r7).toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        return r2;
    }
}
