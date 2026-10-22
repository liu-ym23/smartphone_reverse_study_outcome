package com.bytedance.ai.bridge.remote;

import ai.h0;
import com.bytedance.ttnet.utils.d;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.z;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f2069a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h0 f2070b = null;

    static {
        f2069a = new b();
        f2070b = d.e("https://mini-program.doubao.com");
    }

    public static /* synthetic */ Object e(String r10, ContinuationImpl r11, int r12) {
        b r5 = f2069a;
        if ((r12 & 2) == 0) goto L6;
        String r13 = "user_info";
    L8:
        return r5.a(r10, r13, "482431", "custom", r11);
    L6:
        r13 = "user_info,mobile";
        goto L8
    }

    public final Object a(String r10, String r11, String r12, String r13, ContinuationImpl r14) {
        if ((r14 instanceof UserAuthService$getLoginCode$1) == false) goto L7;
        UserAuthService$getLoginCode$1 r5 = (UserAuthService$getLoginCode$1) r14;
        int r15 = r5.f2056c;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r5.f2056c = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r5.f2054a;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r5.f2056c;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L18:
        return ((Result) r16).m133unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        z r19 = Dispatchers.getIO();
        UserAuthService$getLoginCode$2 r20 = new UserAuthService$getLoginCode$2(r10, r12, r11, r13, null);
        r5.f2056c = 1;
        r16 = BuildersKt.withContext(r19, r20, r5);
        if (r16 != r17) goto L18;
        return r17;
    L7:
        r5 = new UserAuthService$getLoginCode$1(this, r14);
        goto L8
    }

    public final Object b(String r5, String r10, String r11, ContinuationImpl r12) {
        if ((r12 instanceof UserAuthService$exchangeCode$1) == false) goto L7;
        UserAuthService$exchangeCode$1 r13 = (UserAuthService$exchangeCode$1) r12;
        int r14 = r13.f2050c;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.f2050c = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.f2048a;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.f2050c;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L18:
        return ((Result) r15).m133unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        z r18 = Dispatchers.getIO();
        UserAuthService$exchangeCode$2 r19 = new UserAuthService$exchangeCode$2(r5, r10, r11, null);
        r13.f2050c = 1;
        r15 = BuildersKt.withContext(r18, r19, r13);
        if (r15 != r16) goto L18;
        return r16;
    L7:
        r13 = new UserAuthService$exchangeCode$1(this, r12);
        goto L8
    }

    public final Object c(String r5, String r10, ContinuationImpl r11) {
        if ((r11 instanceof UserAuthService$checkPrivacy$1) == false) goto L7;
        UserAuthService$checkPrivacy$1 r12 = (UserAuthService$checkPrivacy$1) r11;
        int r13 = r12.f2045c;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.f2045c = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.f2043a;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.f2045c;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L18:
        return ((Result) r14).m133unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        z r17 = Dispatchers.getIO();
        UserAuthService$checkPrivacy$2 r18 = new UserAuthService$checkPrivacy$2(r5, r10, null);
        r12.f2045c = 1;
        r14 = BuildersKt.withContext(r17, r18, r12);
        if (r14 != r15) goto L18;
        return r15;
    L7:
        r12 = new UserAuthService$checkPrivacy$1(this, r11);
        goto L8
    }

    public final Object d(String r5, ContinuationImpl r10) {
        if ((r10 instanceof UserAuthService$acceptPrivacy$1) == false) goto L7;
        UserAuthService$acceptPrivacy$1 r11 = (UserAuthService$acceptPrivacy$1) r10;
        int r12 = r11.f2041c;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.f2041c = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.f2039a;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.f2041c;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L18:
        return ((Result) r13).m133unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        z r16 = Dispatchers.getIO();
        UserAuthService$acceptPrivacy$2 r17 = new UserAuthService$acceptPrivacy$2(r5, null);
        r11.f2041c = 1;
        r13 = BuildersKt.withContext(r16, r17, r11);
        if (r13 != r14) goto L18;
        return r14;
    L7:
        r11 = new UserAuthService$acceptPrivacy$1(this, r10);
        goto L8
    }

    public final Object f(String r5, ContinuationImpl r10) {
        if ((r10 instanceof UserAuthService$getPhoneCode$1) == false) goto L7;
        UserAuthService$getPhoneCode$1 r11 = (UserAuthService$getPhoneCode$1) r10;
        int r12 = r11.f2062c;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.f2062c = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.f2060a;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.f2062c;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L18:
        return ((Result) r13).m133unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        z r16 = Dispatchers.getIO();
        UserAuthService$getPhoneCode$2 r17 = new UserAuthService$getPhoneCode$2(r5, null);
        r11.f2062c = 1;
        r13 = BuildersKt.withContext(r16, r17, r11);
        if (r13 != r14) goto L18;
        return r14;
    L7:
        r11 = new UserAuthService$getPhoneCode$1(this, r10);
        goto L8
    }

    public final Object g(String r5, ContinuationImpl r10) {
        if ((r10 instanceof UserAuthService$getPhoneMask$1) == false) goto L7;
        UserAuthService$getPhoneMask$1 r11 = (UserAuthService$getPhoneMask$1) r10;
        int r12 = r11.f2067c;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.f2067c = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.f2065a;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.f2067c;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L18:
        return ((Result) r13).m133unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        z r16 = Dispatchers.getIO();
        UserAuthService$getPhoneMask$2 r17 = new UserAuthService$getPhoneMask$2(r5, null);
        r11.f2067c = 1;
        r13 = BuildersKt.withContext(r16, r17, r11);
        if (r13 != r14) goto L18;
        return r14;
    L7:
        r11 = new UserAuthService$getPhoneMask$1(this, r10);
        goto L8
    }
}
