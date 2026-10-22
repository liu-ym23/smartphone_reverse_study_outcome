package com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpErrorMsg;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final c a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmHttpErrorMsg.ErrorDisplayType.values().length];
            r0[MmHttpErrorMsg.ErrorDisplayType.ALERT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[MmHttpErrorMsg.ErrorDisplayType.TOAST_NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[MmHttpErrorMsg.ErrorDisplayType.TOAST_SUCCEED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[MmHttpErrorMsg.ErrorDisplayType.TOAST_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[MmHttpErrorMsg.ErrorDisplayType.TOAST_INFO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[MmHttpErrorMsg.ErrorDisplayType.UNKNOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    static {
        a = new c();
    }

    public c() {
    }

    public static b a(c r10, gvb.b r11, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r12) {
        com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error.a r0 = new com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error.a(r12);
        MmHttpErrorProcessor$processCommonError$1 r13 = MmHttpErrorProcessor$processCommonError$1.INSTANCE;
        MmHttpErrorProcessor$processCommonError$2 r1 = MmHttpErrorProcessor$processCommonError$2.INSTANCE;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r0, "uiSink");
        Intrinsics.checkNotNullParameter(r13, "fallbackBodyProvider");
        Intrinsics.checkNotNullParameter(r1, "positiveButtonProvider");
        MmHttpErrorMsg r5 = null;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L61
        if (r11 == null) goto L6;
        MmHttpErrorMsg r7 = r11.b();     // Catch: Throwable -> L61
    L7:
        lvb.a.e("MmHttpErrorProcessor", "[processCommonError] commonError=" + r7);     // Catch: Throwable -> L61
        if (r7 != null) goto L11;
        b r14 = new b(null, false, false);     // Catch: Throwable -> L61
    L58:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L61
    L63:
        Throwable r2 = Result.exceptionOrNull-impl(r15);
        if (r2 == null) goto L76;
        lvb.a.b("MmHttpErrorProcessor", "[processCommonError] failed, error=" + r2.getMessage());
        if (r11 == null) goto L69;
        r5 = r11.b();
    L69:
        if (r11 == null) goto L73;
        MmHttpErrorMsg r16 = r11.b();
        if (r16 == null) goto L73;
        boolean r17 = r16.isOverride();
    L74:
        r15 = new b(r5, false, r17);
    L73:
        r17 = false;
    L76:
        return (b) r15;
    L11:
        if (r7.isShow() == true) goto L13;
        lvb.a.e("MmHttpErrorProcessor", "[processCommonError] skip display, isShow=false");     // Catch: Throwable -> L61
        r14 = new b(r7, false, r7.isOverride());     // Catch: Throwable -> L61
        goto L58
    L13:
        MmHttpErrorMsg.MessageContent r3 = r7.getContent();     // Catch: Throwable -> L61
        boolean r8 = true;
        if (r3 == null) goto L23;
        String r4 = r3.getBody();     // Catch: Throwable -> L61
        if (r4 == null) goto L23;
        if ((!StringsKt.isBlank(r4)) == true) goto L21;
        r4 = null;
    L21:
        if (r4 == null) goto L23;
    L24:
        MmHttpErrorMsg.ErrorDisplayType.a r18 = MmHttpErrorMsg.ErrorDisplayType.Companion;     // Catch: Throwable -> L61
        int r9 = r7.getType();     // Catch: Throwable -> L61
        r18.getClass();     // Catch: Throwable -> L61
        if (r9 != 1) goto L27;
        MmHttpErrorMsg.ErrorDisplayType r19 = MmHttpErrorMsg.ErrorDisplayType.ALERT;     // Catch: Throwable -> L61
    L41:
        switch(a.a[r19.ordinal()]) {
            case 1: goto L45;
            case 2: goto L44;
            case 3: goto L44;
            case 4: goto L44;
            case 5: goto L44;
            case 6: goto L43;
            default: goto L60;
        };     // Catch: Throwable -> L61
    L43:
        lvb.a.e("MmHttpErrorProcessor", "[processCommonError] unknown display type=" + r7.getType());     // Catch: Throwable -> L61
        boolean r110 = false;
    L53:
        if (r7.isOverride() == true) goto L57;
        if (r110 == true) goto L57;
        r8 = false;
    L57:
        r14 = new b(r7, r110, r8);     // Catch: Throwable -> L61
        goto L58
    L44:
        r110 = r0.b(r19, r4);     // Catch: Throwable -> L61
        goto L53
    L45:
        MmHttpErrorMsg.MessageContent r111 = r7.getContent();     // Catch: Throwable -> L61
        if (r111 == null) goto L48;
        String r112 = r111.getTitle();     // Catch: Throwable -> L61
    L49:
        if (r112 != null) goto L51;
        r112 = "";
    L51:
        r110 = r0.a(r112, r4, (String) r1.invoke());     // Catch: Throwable -> L61
        goto L53
    L48:
        r112 = null;
        goto L49
    L60:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L61
    L27:
        if (r9 != 2) goto L29;
        r19 = MmHttpErrorMsg.ErrorDisplayType.TOAST_NORMAL;     // Catch: Throwable -> L61
        goto L41
    L29:
        if (r9 != 3) goto L31;
        r19 = MmHttpErrorMsg.ErrorDisplayType.TOAST_SUCCEED;     // Catch: Throwable -> L61
        goto L41
    L31:
        if (r9 != 4) goto L33;
        r19 = MmHttpErrorMsg.ErrorDisplayType.TOAST_FAILED;     // Catch: Throwable -> L61
        goto L41
    L33:
        if (r9 == 5) goto L35;
        r19 = MmHttpErrorMsg.ErrorDisplayType.UNKNOWN;     // Catch: Throwable -> L61
        goto L41
    L35:
        r19 = MmHttpErrorMsg.ErrorDisplayType.TOAST_INFO;     // Catch: Throwable -> L61
    L23:
        r4 = (String) r13.invoke();     // Catch: Throwable -> L61
        goto L24
    L6:
        r7 = null;
    L61:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L63
    }
}
