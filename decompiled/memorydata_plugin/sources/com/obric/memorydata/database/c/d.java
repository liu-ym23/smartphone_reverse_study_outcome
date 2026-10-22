package com.obric.memorydata.database.c;

import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.aa;
import com.obric.memorydata.database.entity.iu;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011JG\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u001aJ\f\u0010\u001b\u001a\u00020\r*\u00020\u0005H\u0002J\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0005*\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/database/review/MemoryReviewSnapshotDiffJson;", "", "<init>", "()V", "KEY_DIFF_CURRENT_CONTENT", "", "KEY_DIFF_PREVIOUS_CONTENT", "KEY_DIFF_PREVIOUS_SNAPSHOT_ID", "KEY_DIFF_PREVIOUS_SNAPSHOT_VERSION", "KEY_DIFF_PREVIOUS_SNAPSHOT_TIME", "putAutoMemoryProDiffFields", "", "snapshotJson", "Lorg/json/JSONObject;", "previousSnapshot", "Lcom/obric/memorydata/database/entity/AutoMemoryProSnapShotEntity;", "putPersonalMemoryDiffFields", "Lcom/obric/memorydata/database/entity/UnionSemanticMemorySnapShotEntity;", "putDiffFields", "currentContent", "previousSnapshotId", "", "previousSnapshotVersion", "", "previousSnapshotTime", "previousContent", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;)V", "toJsonObjectOrEmpty", "optNonBlankString", "key", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8856a = null;

    static {
        f8856a = new d();
    }

    private d() {
    }

    private final String a(JSONObject r2, String r3) {
        if (r2.has(r3) == true) goto L5;
        return null;
    L5:
        if (r2.isNull(r3) == true) goto L11;
        String r1 = r2.optString(r3);
        Intrinsics.checkNotNull(r1);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L9;
        return null;
    L9:
        return r1;
    L11:
        return null;
    }

    private final JSONObject a(String r2) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L4
        Object r3 = Result.m1421constructorimpl(new JSONObject(r2));     // Catch: Throwable -> L4
    L6:
        JSONObject r4 = new JSONObject();
        if (Result.m1427isFailureimpl(r3) == false) goto L10;
        r3 = r4;
    L10:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin");
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private final void a(JSONObject r1, String r2, Long r3, Integer r4, Long r5, String r6) {
        if (r2 == null) goto L4;
        r1.put("diffCurrentContent", r2);
    L4:
        if (r3 == null) goto L22;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
    L11:
        boolean r7 = true;
    L12:
        if (r7 == true) goto L23;
        r1.put("diffPreviousContent", r6);
        r1.put("diffPreviousSnapshotId", r3.longValue());
        Object r8 = r4;
        if (r4 != null) goto L17;
        r8 = JSONObject.NULL;
    L17:
        r1.put("diffPreviousSnapshotVersion", r8);
        Object r9 = r5;
        if (r5 != null) goto L20;
        r9 = JSONObject.NULL;
    L20:
        r1.put("diffPreviousSnapshotTime", r9);
        return;
    L23:
        return;
    L8:
        if (StringsKt.isBlank(r0) == true) goto L11;
        r7 = false;
        goto L12
    }

    public final void a(JSONObject r9, aa r10) {
        Intrinsics.checkNotNullParameter(r9, "snapshotJson");
        String r3 = a(r9, Params.CONTENT);
        if (r10 == null) goto L5;
        Long r4 = Long.valueOf(r10.a());
    L6:
        if (r10 == null) goto L8;
        Integer r5 = Integer.valueOf(r10.d());
    L9:
        if (r10 == null) goto L11;
        Long r6 = Long.valueOf(r10.f());
    L12:
        if (r10 == null) goto L18;
        String r11 = r10.e();
        if (r11 == null) goto L18;
        JSONObject r12 = a(r11);
        if (r12 == null) goto L18;
        String r7 = a(r12, Params.CONTENT);
    L19:
        a(r9, r3, r4, r5, r6, r7);
        return;
    L18:
        r7 = null;
        goto L19
    L11:
        r6 = null;
        goto L12
    L8:
        r5 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }

    public final void a(JSONObject r9, iu r10) {
        Intrinsics.checkNotNullParameter(r9, "snapshotJson");
        String r3 = a(r9, "keyPhrase");
        if (r10 == null) goto L5;
        Long r4 = Long.valueOf(r10.a());
    L6:
        if (r10 == null) goto L8;
        Integer r5 = Integer.valueOf(r10.d());
    L9:
        if (r10 == null) goto L11;
        Long r6 = Long.valueOf(r10.f());
    L12:
        if (r10 == null) goto L18;
        String r11 = r10.e();
        if (r11 == null) goto L18;
        JSONObject r12 = a(r11);
        if (r12 == null) goto L18;
        String r7 = a(r12, "keyPhrase");
    L19:
        a(r9, r3, r4, r5, r6, r7);
        return;
    L18:
        r7 = null;
        goto L19
    L11:
        r6 = null;
        goto L12
    L8:
        r5 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }
}
