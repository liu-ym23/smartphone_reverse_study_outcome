package com.obric.aiproactive.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0006\u0010\u0006\u001a\u00020\u0004\"\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"toAiProactiveUserRequirementRequest", "Lcom/obric/aiproactive/api/AiProactiveUserRequirementRequest;", "Lcom/obric/aiproactive/api/AiProactiveActionExecuteItem;", "requestId", "", "submittedAt", "generatePositiveAiProactiveRequestId", "AI_PROACTIVE_REQUEST_ID_RANDOM", "Ljava/security/SecureRandom;", "ai_proactive_api_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SecureRandom f6281a = null;

    static {
        f6281a = new SecureRandom();
    }

    public static final long a() {
    L2:
        long r0 = f6281a.nextLong() & Long.MAX_VALUE;
        if (r0 == 0) goto L2;
        return r0;
    }

    public static final x a(b r13, long r14, long r16) {
        Intrinsics.checkNotNullParameter(r13, "<this>");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r13.b(), CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r0) == false) goto L5;
        r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r13.a(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L5:
        String r5 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L8;
        return null;
    L8:
        if (r14 > 0) goto L10;
        return null;
    L10:
        if (r16 > 0) goto L13;
        return null;
    L13:
        return new x(r5, r14, r16, null, 8, null);
    }
}
