package com.bytedance.android.live.revenue.common.player.vendor.link;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$appDataStr$2 extends FunctionReferenceImpl implements Function0<String> {
    public RevSeiFrame$appDataStr$2(RevSeiFrame r8) {
        super(0, r8, RevSeiFrame.class, "parseAppDataStr", "parseAppDataStr()Ljava/lang/String;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m369invoke() {
        RevSeiFrame r0 = (RevSeiFrame) ((CallableReference) this).receiver;
        Lazy r1 = RevSeiFrame.D;
        r0.getClass();
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L38
        int r5 = 0;
        if (StringsKt.contains$default(r0.C, "TTLiveSDK_", false, 2, null) == true) goto L50;
        int r4 = StringsKt.indexOf$default(r0.C, "app_data", 0, false, 6, null);     // Catch: Throwable -> L38
        if (r4 == (-1)) goto L51;
        int r6 = r0.C.length();     // Catch: Throwable -> L38
    L11:
        if (r4 >= r6) goto L15;
        if (r0.C.charAt(r4) == '{') goto L15;
        r4 = r4 + 1;     // Catch: Throwable -> L38
    L15:
        if (r4 < r6) goto L17;
    L19:
        int r7 = -1;
    L20:
        if (r7 == (-1)) goto L52;
    L22:
        if (r4 >= r6) goto L32;
        if (r0.C.charAt(r4) != '{') goto L27;
        r5 = r5 + 1;     // Catch: Throwable -> L38
    L29:
        if (r5 == 0) goto L32;
        r4 = r4 + 1;     // Catch: Throwable -> L38
        goto L22
    L27:
        if (r0.C.charAt(r4) != '}') goto L29;
        r5 = r5 - 1;     // Catch: Throwable -> L38
    L32:
        if (r5 != 0) goto L53;
        String r8 = r0.C;     // Catch: Throwable -> L38
        int r9 = r4 + 1;     // Catch: Throwable -> L38
        if (r8 == null) goto L37;
        return r8.substring(r7, r9);
    L37:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L38
    L53:
        return null;
    L52:
        return null;
    L17:
        if (r0.C.charAt(r4) != '{') goto L19;
        r7 = r4;
        goto L20
    L51:
        return null;
    L50:
        return null;
    L38:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Object r12 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r12) == true) goto L44;
        r2 = r12;
    L44:
        return (String) r2;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m369invoke();
    }
}
