package com.larus.common.account.bdauth.repository;

import android.content.Context;
import android.os.Bundle;
import com.larus.account.base.api.AccountSwitchReason;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.api.IMultiAccountService;
import com.larus.account.base.model.profile.AvatarInfo;
import com.larus.common.account.bdauth.model.CustomBDAuthorizeModel;
import com.larus.nova.view.FlowBDAuthorizeActivity;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class BDAuthorizeRepository {
    public final Context a;
    public final vz8.a b;
    public final k c;
    public final Lazy d;
    public final Lazy e;
    public com.larus.common.account.bdauth.repository.a f;

    public static final class a {
        public final za7.c a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            za7.c r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "AuthInfoResult(response=" + this.a + ')';
        }

        public a(za7.c r1) {
            this.a = r1;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BDAuthorizeBlockingErrorType.values().length];
            r0[BDAuthorizeBlockingErrorType.MinorMode.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[BDAuthorizeBlockingErrorType.EnterpriseAccount.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            if (((com.larus.common.account.bdauth.repository.a) r3).f == false) goto L5;
            int r5 = 1;
        L7:
            if (((com.larus.common.account.bdauth.repository.a) r4).f == false) goto L9;
            int r6 = 1;
        L11:
            return ComparisonsKt.compareValues(r5, r6);
        L9:
            r6 = 0;
            goto L11
        L5:
            r5 = 0;
            goto L7
        }
    }

    public static final class d<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public d(e r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r0 = this.a.compare(r2, r3);
            if (r0 != 0) goto L14;
            String r4 = ((com.larus.common.account.bdauth.repository.a) r2).a;
            String r1 = "";
            if (r4 != null) goto L8;
            r4 = "";
        L8:
            String r5 = ((com.larus.common.account.bdauth.repository.a) r3).a;
            if (r5 == null) goto L13;
            r1 = r5;
        L13:
            return ComparisonsKt.compareValues(r4, r1);
        L14:
            return r0;
        }
    }

    public static final class e<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public e(c r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            int r0 = this.a.compare(r3, r4);
            if (r0 == 0) goto L6;
            return r0;
        L6:
            return ComparisonsKt.compareValues(Long.valueOf(((com.larus.common.account.bdauth.repository.a) r4).i), Long.valueOf(((com.larus.common.account.bdauth.repository.a) r3).i));
        }
    }

    public static List h(List r6) {
        if (r6.isEmpty() == true) goto L5;
        List r7 = r6;
        Iterator r0 = r7.iterator();
    L8:
        if (r0.hasNext() == false) goto L19;
        Object r1 = r0.next();
        com.larus.common.account.bdauth.repository.a r3 = (com.larus.common.account.bdauth.repository.a) r1;
        if (r3.h == true) goto L12;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L8;
    L20:
        com.larus.common.account.bdauth.repository.a r2 = (com.larus.common.account.bdauth.repository.a) r1;
        ArrayList r5 = new ArrayList();
        Iterator r8 = r7.iterator();
    L22:
        if (r8.hasNext() == false) goto L30;
        Object r9 = r8.next();
        String r10 = ((com.larus.common.account.bdauth.repository.a) r9).b;
        if (r2 == null) goto L26;
        String r11 = r2.b;
    L28:
        if (Intrinsics.areEqual(r10, r11) == true) goto L22;
        r5.add(r9);
        goto L22
    L26:
        r11 = null;
        goto L28
    L30:
        List r12 = CollectionsKt.sortedWith(r5, new d(new e(new c())));
        List r13 = CollectionsKt.createListBuilder();
        if (r2 == null) goto L33;
        r13.add(r2);
    L33:
        r13.addAll(r12);
        return CollectionsKt.build(r13);
    L12:
        if (r3.g == false) goto L16;
        if (r3.f == true) goto L16;
        r4 = true;
        goto L17
    L19:
        r1 = null;
        goto L20
    L5:
        return CollectionsKt.emptyList();
    }

    public static com.larus.common.account.bdauth.repository.a l(q38.b r14) {
        String r0 = r14.g();
        String r1 = null;
        if (r0 != null) goto L5;
    L18:
        return null;
    L5:
        if ((!StringsKt.isBlank(r0)) == false) goto L7;
        String r5 = r0;
    L8:
        if (r5 == null) goto L18;
        String r4 = r14.j();
        String r2 = r14.c();
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        String r6 = r2;
        String r7 = r14.b();
        q38.b.a r3 = r14.i();
        if (r3 == null) goto L17;
        r1 = r3.b();
    L17:
        return new com.larus.common.account.bdauth.repository.a(r4, r5, r6, r7, r1, r14.l(), r14.d(), r14.k(), r14.e());
    L7:
        r5 = null;
        goto L8
    }

    public final Object c(Continuation<? super com.larus.common.account.bdauth.repository.a> r110) {
        if ((r110 instanceof BDAuthorizeRepository$buildFallbackCurrentAccount$1) == false) goto L7;
        BDAuthorizeRepository$buildFallbackCurrentAccount$1 r2 = (BDAuthorizeRepository$buildFallbackCurrentAccount$1) r110;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        String r6 = null;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        String r7 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
        String r9 = r7;
    L26:
        r38.b r8 = (r38.b) r1;
        FLogger.a.d("BDAuthorizeRepository", "1. [buildFallbackCurrentAccount]: secUserId=" + r9 + ", userInfo=" + r8);
        if (r8 == null) goto L35;
        String r10 = r8.d();
        if (r10 == null) goto L35;
        if ((!StringsKt.isBlank(r10)) == true) goto L34;
        r10 = null;
    L34:
        if (r10 == null) goto L35;
    L44:
        String r11 = r10;
        if (r8 == null) goto L52;
        AvatarInfo r12 = r8.a();
        if (r12 == null) goto L52;
        String r13 = r12.a();
        if (r13 == null) goto L52;
    L51:
        String r14 = r13;
    L57:
        ILoginService.Companion r15 = ILoginService.a;
        String r16 = r15.getAccountInfo().c;
        if (r8 == null) goto L63;
        r38.a r17 = r8.e();
        if (r17 == null) goto L63;
        r6 = r17.b();
    L63:
        return new com.larus.common.account.bdauth.repository.a(r16, r9, r11, r14, r6, r15.getAccountInfo().g, true, true, System.currentTimeMillis());
    L52:
        if (r8 == null) goto L56;
        AvatarInfo r18 = r8.a();
        if (r18 == null) goto L56;
        r13 = r18.b();
    L56:
        r14 = null;
    L35:
        if (r8 == null) goto L41;
        r10 = r8.g();
        if (r10 == null) goto L41;
        if ((!StringsKt.isBlank(r10)) == false) goto L41;
    L42:
        if (r10 != null) goto L44;
        r10 = "";
    L41:
        r10 = null;
        goto L42
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        String r20 = ILoginService.a.getAccountInfo().d;
        if (r20 != null) goto L17;
    L64:
        return null;
    L17:
        if ((!StringsKt.isBlank(r20)) == true) goto L20;
        r20 = null;
    L20:
        if (r20 == null) goto L64;
        r2.L$0 = r20;
        r2.label = 1;
        Object r21 = d(r2);
        if (r21 != r4) goto L25;
        return r4;
    L25:
        r9 = r20;
        r1 = r21;
    L7:
        r2 = new BDAuthorizeRepository$buildFallbackCurrentAccount$1(this, r110);
        goto L8
    }

    public final Object d(Continuation<? super r38.b> r8) {
        if ((r8 instanceof BDAuthorizeRepository$ensureCurrentUserProfileIfNeeded$1) == false) goto L7;
        BDAuthorizeRepository$ensureCurrentUserProfileIfNeeded$1 r0 = (BDAuthorizeRepository$ensureCurrentUserProfileIfNeeded$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r9);
    L39:
        return r9;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r9);
    L36:
        r0.label = 3;
        r9 = BuildersKt.withContext(Dispatchers.getIO(), new BDAuthorizeRepository$requestUserInfoFromRemote$2(null), r0);
        if (r9 != r2) goto L39;
        return r2;
    L17:
        ResultKt.throwOnFailure(r9);
    L27:
        r38.b r10 = (r38.b) r9;
        if (r10 == null) goto L30;
        return r10;
    L30:
        r0.label = 2;
        Object r11 = BuildersKt.withContext(Dispatchers.getIO(), new BDAuthorizeRepository$createDefaultUserInfo$2(null), r0);
        if (r11 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L34;
        r11 = Unit.INSTANCE;
    L34:
        if (r11 != r2) goto L36;
        return r2;
    L18:
        ResultKt.throwOnFailure(r9);
        if (AccountService.a.isLogin().booleanValue() == true) goto L21;
        return null;
    L21:
        r38.b r12 = IAccountService.a.getUserInfo();
        if (r12 == null) goto L24;
        return r12;
    L24:
        r0.label = 1;
        r9 = BuildersKt.withContext(Dispatchers.getIO(), new BDAuthorizeRepository$requestUserInfoFromRemote$2(null), r0);
        if (r9 != r2) goto L27;
        return r2;
    L7:
        r0 = new BDAuthorizeRepository$ensureCurrentUserProfileIfNeeded$1(this, r8);
        goto L8
    }

    public BDAuthorizeRepository(Context r3, FlowBDAuthorizeActivity.authorizeViewModel.2.1.a r4) {
        CustomBDAuthorizeModel r0 = new CustomBDAuthorizeModel(r3);
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r0, "authorizeModel");
        Intrinsics.checkNotNullParameter(r4, "sceneRestorer");
        this.a = r3;
        this.b = r0;
        this.c = r4;
        this.d = LazyKt.lazy(new g());
        this.e = LazyKt.lazy(new h());
    }

    public static void a(fb7.d r1, int r2) {
        if (((fb7.b) r1).c != null) goto L5;
        ((fb7.b) r1).c = new Bundle();
    L5:
        ((fb7.b) r1).c.putInt("response_type", r2);
    }

    public static Object k(com.larus.common.account.bdauth.repository.a r16, ContinuationImpl r17) {
        kotlinx.coroutines.j r1 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r17), 1);
        r1.C();
        IMultiAccountService.Companion r2 = IMultiAccountService.a;
        String r5 = r16.a;
        String r6 = r16.b;
        String r7 = r16.c;
        String r8 = r16.d;
        String r4 = r16.e;
        if (r4 == null) goto L5;
        q38.b.a r9 = new q38.b.a(r4, 1);
    L6:
        r2.e(new q38.b(r5, r6, r7, r8, r9, r16.f, r16.i, r16.g, r16.h, 768), new j(r1), AccountSwitchReason.UNKNOWN);
        Object r0 = r1.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r17);
    L9:
        return r0;
    L5:
        r9 = null;
        goto L6
    }

    public final Object e(fb7.c r18, Continuation<? super f> r110) {
        fb7.c r1 = r18;
        if ((r110 instanceof BDAuthorizeRepository$prepareAuthorize$1) == false) goto L7;
        BDAuthorizeRepository$prepareAuthorize$1 r3 = (BDAuthorizeRepository$prepareAuthorize$1) r110;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        Object r12 = null;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L19;
        if (r6 == 2) goto L18;
        if (r6 == 3) goto L17;
        if (r6 != 4) goto L16;
        BDAuthorizeRepository r7 = (BDAuthorizeRepository) r3.L$2;
        com.larus.common.account.bdauth.repository.c r8 = (com.larus.common.account.bdauth.repository.c) r3.L$1;
        a r9 = (a) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L72:
        r7.f = (com.larus.common.account.bdauth.repository.a) r2;
        FLogger.a.d("BDAuthorizeRepository", "4. [prepareAuthorize]: getCurrentAuthorizeAccount = " + this.f);
        return new f.d(new com.larus.common.account.bdauth.repository.e(r9.a, r8));
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        a r10 = (a) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L47:
        com.larus.common.account.bdauth.repository.c r11 = (com.larus.common.account.bdauth.repository.c) r2;
        FLogger.a.d("BDAuthorizeRepository", "3. [prepareAuthorize]: build account snapshot = " + r11);
        Iterator<T> r13 = r11.a.iterator();
    L49:
        if (r13.hasNext() == false) goto L59;
        Object r14 = r13.next();
        com.larus.common.account.bdauth.repository.a r15 = (com.larus.common.account.bdauth.repository.a) r14;
        if (r15.g == true) goto L53;
    L55:
        boolean r16 = false;
    L56:
        if (r16 == false) goto L49;
        r12 = r14;
        goto L59
    L53:
        if (r15.f == true) goto L55;
        r16 = true;
    L59:
        if (((com.larus.common.account.bdauth.repository.a) r12) != null) goto L62;
        com.larus.common.account.bdauth.repository.d r17 = new com.larus.common.account.bdauth.repository.d(BDAuthorizeBlockingErrorType.EnterpriseAccount);
        FLogger.a.d("BDAuthorizeRepository", "1.3 [prepareAuthorize]: check blocking: EnterpriseAccount=" + r17);
        return new f.a(r17);
    L62:
        r3.L$0 = r10;
        r3.L$1 = r11;
        r3.L$2 = this;
        r3.label = 4;
        q38.b r20 = IMultiAccountService.a.c();
        if (r20 == null) goto L68;
        com.larus.common.account.bdauth.repository.a r21 = l(r20);
        if (r21 == null) goto L68;
        Object r22 = r21;
    L69:
        if (r22 != r5) goto L71;
        return r5;
    L71:
        r8 = r11;
        r2 = r22;
        r9 = r10;
        r7 = this;
    L68:
        r22 = c(r3);
        goto L69
    L18:
        ResultKt.throwOnFailure(r2);
    L38:
        a r23 = (a) r2;
        FLogger.a.d("BDAuthorizeRepository", "2. [prepareAuthorize]: request auth info = " + r23);
        za7.c r24 = r23.a;
        if (r24 != null) goto L41;
    L74:
        fb7.d r25 = new fb7.d();
        ((fb7.b) r25).a = -1;
        if (r24 == null) goto L77;
        ((fb7.b) r25).a = ((za7.d) r24).b;
        ((fb7.b) r25).b = ((za7.d) r24).c;
    L78:
        a(r25, 1);
        return new f.b(r25);
    L77:
        ((fb7.b) r25).a = -3;
        goto L78
    L41:
        if (((za7.d) r24).a == false) goto L74;
        boolean r26 = ((Boolean) this.d.getValue()).booleanValue();
        r3.L$0 = r23;
        r3.label = 3;
        Object r27 = b(true, r26, false, r3);
        if (r27 != r5) goto L46;
        return r5;
    L46:
        r2 = r27;
        r10 = r23;
        goto L47
    L19:
        r1 = (fb7.c) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L32:
        if (((Boolean) r2).booleanValue() == false) goto L35;
        com.larus.common.account.bdauth.repository.d r28 = new com.larus.common.account.bdauth.repository.d(BDAuthorizeBlockingErrorType.MinorMode);
        FLogger.a.d("BDAuthorizeRepository", "1.2 [prepareAuthorize]: check blocking: isMinorMode=" + r28);
        return new f.a(r28);
    L35:
        r3.L$0 = null;
        r3.label = 2;
        r2 = f(r1, r3);
        if (r2 != r5) goto L38;
        return r5;
    L20:
        ResultKt.throwOnFailure(r2);
        if (r1 != null) goto L24;
        fb7.d r30 = new fb7.d();
        ((fb7.b) r30).a = -1;
        return new f.b(r30);
    L24:
        boolean r31 = AccountService.a.isLogin().booleanValue();
        FLogger.a.d("BDAuthorizeRepository", "1.1 [prepareAuthorize]: check blocking: multiAccountAuthEnabled=" + ((Boolean) this.e.getValue()).booleanValue() + ", multiAccountEnabled=" + ((Boolean) this.d.getValue()).booleanValue() + ", isLogin=" + r31);
        if (r31 == false) goto L27;
        CoroutineDispatcher r32 = Dispatchers.getIO();
        BDAuthorizeRepository$prepareAuthorize$isMinorMode$1 r33 = new BDAuthorizeRepository$prepareAuthorize$isMinorMode$1(null);
        r3.L$0 = r1;
        r3.label = 1;
        r2 = BuildersKt.withContext(r32, r33, r3);
        if (r2 != r5) goto L32;
        return r5;
    L27:
        return f.c.a;
    L7:
        r3 = new BDAuthorizeRepository$prepareAuthorize$1(this, r110);
        goto L8
    }

    public final Object f(fb7.c r6, Continuation<? super a> r7) {
        if ((r7 instanceof BDAuthorizeRepository$requestAuthInfo$1) == false) goto L7;
        BDAuthorizeRepository$requestAuthInfo$1 r0 = (BDAuthorizeRepository$requestAuthInfo$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L22:
        return new a((za7.c) r8);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        int r9 = xz8.b.a;
        if (xz8.b.a.b(this.a) == false) goto L17;
        CoroutineDispatcher r10 = Dispatchers.getIO();
        BDAuthorizeRepository$requestAuthInfo$authInfoResponse$1 r4 = new BDAuthorizeRepository$requestAuthInfo$authInfoResponse$1(this, r6, null);
        r0.label = 1;
        r8 = BuildersKt.withContext(r10, r4, r0);
        if (r8 != r2) goto L22;
        return r2;
    L17:
        return new a(null);
    L7:
        r0 = new BDAuthorizeRepository$requestAuthInfo$1(this, r7);
        goto L8
    }

    public final Object i(fb7.c r12, Continuation<? super m> r13) {
        if ((r13 instanceof BDAuthorizeRepository$submitAuthCodeInternal$1) == false) goto L7;
        BDAuthorizeRepository$submitAuthCodeInternal$1 r0 = (BDAuthorizeRepository$submitAuthCodeInternal$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        r12 = (fb7.c) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L44:
        za7.a r15 = (za7.a) r14;
    L50:
        if (r15 != null) goto L52;
    L55:
        fb7.d r16 = new fb7.d();
        ((fb7.b) r16).a = -1;
        if (r15 == null) goto L58;
        ((fb7.b) r16).a = ((za7.d) r15).b;
        ((fb7.b) r16).b = ((za7.d) r15).c;
    L58:
        a(r16, 3);
        return new m.b(r16);
    L52:
        if (((za7.d) r15).a == false) goto L55;
        fb7.d r5 = new fb7.d();
        r5.d = r15.e;
        r5.f = r12.g;
        r5.e = r12.c;
        return new m.d(r5);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        za7.a r17 = (za7.a) r0.L$1;
        fb7.c r6 = (fb7.c) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L39:
        if (((Boolean) r14).booleanValue() == false) goto L45;
        CoroutineDispatcher r18 = Dispatchers.getIO();
        BDAuthorizeRepository$submitAuthCodeInternal$2 r110 = new BDAuthorizeRepository$submitAuthCodeInternal$2(this, r6, null);
        r0.L$0 = r6;
        r0.L$1 = null;
        r0.label = 3;
        r14 = BuildersKt.withContext(r18, r110, r0);
        if (r14 != r2) goto L43;
        return r2;
    L43:
        r12 = r6;
        goto L44
    L45:
        fb7.d r7 = new fb7.d();
        ((fb7.b) r7).a = -1;
        if (r17 == null) goto L48;
        ((fb7.b) r7).a = ((za7.d) r17).b;
        ((fb7.b) r7).b = ((za7.d) r17).c;
    L48:
        a(r7, 3);
        return new m.b(r7);
    L17:
        r12 = (fb7.c) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L21:
        r15 = (za7.a) r14;
        if (r15 != null) goto L24;
    L26:
        boolean r8 = false;
    L27:
        if (r8 == true) goto L50;
        if (r15 != null) goto L30;
    L32:
        r4 = false;
    L33:
        if (r4 == false) goto L50;
        CoroutineDispatcher r9 = Dispatchers.getIO();
        BDAuthorizeRepository$submitAuthCodeInternal$registerResult$1 r10 = new BDAuthorizeRepository$submitAuthCodeInternal$registerResult$1(this, null);
        r0.L$0 = r12;
        r0.L$1 = r15;
        r0.label = 2;
        Object r11 = BuildersKt.withContext(r9, r10, r0);
        if (r11 != r2) goto L37;
        return r2;
    L37:
        r6 = r12;
        r17 = r15;
        r14 = r11;
        goto L39
    L30:
        if (((za7.d) r15).b != 4099) goto L32;
    L24:
        if (((za7.d) r15).a != true) goto L26;
        r8 = true;
        goto L27
    L18:
        ResultKt.throwOnFailure(r14);
        CoroutineDispatcher r111 = Dispatchers.getIO();
        BDAuthorizeRepository$submitAuthCodeInternal$authCodeResponse$1 r20 = new BDAuthorizeRepository$submitAuthCodeInternal$authCodeResponse$1(this, r12, null);
        r0.L$0 = r12;
        r0.label = 1;
        r14 = BuildersKt.withContext(r111, r20, r0);
        if (r14 != r2) goto L21;
        return r2;
    L7:
        r0 = new BDAuthorizeRepository$submitAuthCodeInternal$1(this, r13);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0069 -> B:25:0x006e). Please report as a decompilation issue!!! */
    public final Object g(com.larus.common.account.bdauth.repository.a r13, l r14, Continuation<? super Unit> r15) {
        if ((r15 instanceof BDAuthorizeRepository$restoreOriginalAccount$2) == false) goto L7;
        BDAuthorizeRepository$restoreOriginalAccount$2 r0 = (BDAuthorizeRepository$restoreOriginalAccount$2) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L18;
        if (r3 != 2) goto L17;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L14
    L30:
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L33:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L37;
        FLogger.a.w("BDAuthorizeRepository", "restore scene failed: " + r18.getMessage());
    L37:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        int r110 = r0.I$2;
        int r111 = r0.I$1;
        int r4 = r0.I$0;
        l r6 = (l) r0.L$1;
        com.larus.common.account.bdauth.repository.a r7 = (com.larus.common.account.bdauth.repository.a) r0.L$0;
        ResultKt.throwOnFailure(r16);
        BDAuthorizeRepository r8 = this;
    L25:
        n38.b r112 = (n38.b) r16;
        if (r112.c == false) goto L38;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L14
        k r114 = r8.c;     // Catch: Throwable -> L14
        r0.L$0 = null;     // Catch: Throwable -> L14
        r0.L$1 = null;     // Catch: Throwable -> L14
        r0.label = 2;     // Catch: Throwable -> L14
        if (r114.b(r0) != r2) goto L30;
        return r2;
    L38:
        FLogger.a.w("BDAuthorizeRepository", "restoreOriginalAccount failed, retryIndex=" + r110 + ", code=" + r112.d + ", msg=" + r112.e);
        r110 = r111 + 1;
        l r115 = r6;
        com.larus.common.account.bdauth.repository.a r116 = r7;
        BDAuthorizeRepository r9 = r8;
    L20:
        if (r110 >= r4) goto L39;
        r0.L$0 = r116;
        r0.L$1 = r115;
        r0.I$0 = r4;
        r0.I$1 = r110;
        r0.I$2 = r110;
        r0.label = 1;
        Object r10 = k(r116, r0);
        if (r10 != r2) goto L24;
        return r2;
    L24:
        r8 = r9;
        r6 = r115;
        r16 = r10;
        r7 = r116;
        r111 = r110;
        goto L25
    L39:
        FLogger.a.w("BDAuthorizeRepository", "restoreOriginalAccount failed after retry, keep target account in foreground");
        return Unit.INSTANCE;
    L19:
        ResultKt.throwOnFailure(r16);
        r9 = this;
        r115 = r14;
        r4 = 2;
        r116 = r13;
        r110 = 0;
    L14:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new BDAuthorizeRepository$restoreOriginalAccount$2(this, r15);
        goto L8
    }

    public final Object j(fb7.c r18, com.larus.common.account.bdauth.repository.a r110, Continuation<? super m> r20) {
        fb7.c r0 = r18;
        if ((r20 instanceof BDAuthorizeRepository$submitAuthorize$1) == false) goto L7;
        BDAuthorizeRepository$submitAuthorize$1 r4 = (BDAuthorizeRepository$submitAuthorize$1) r20;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r2 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L26;
        if (r7 == 1) goto L25;
        if (r7 == 2) goto L24;
        if (r7 == 3) goto L19;
        if (r7 == 4) goto L18;
        if (r7 != 5) goto L16;
        Throwable r1 = (Throwable) r4.L$0;
        ResultKt.throwOnFailure(r2);
        throw r1;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        m r3 = (m) r4.L$0;
        ResultKt.throwOnFailure(r2);
    L98:
        FLogger.a.d("BDAuthorizeRepository", "5. [submitAuthorize]: Auth Code Result =" + r3);
        return r3;
    L19:
        l r8 = (l) r4.L$1;
        com.larus.common.account.bdauth.repository.a r9 = (com.larus.common.account.bdauth.repository.a) r4.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L22
    L90:
        r3 = (m) r2;     // Catch: Throwable -> L22
        com.larus.common.account.bdauth.repository.a r10 = this.f;
        if (r10 == null) goto L98;
        if (Intrinsics.areEqual(r10.b, r9.b) == true) goto L98;
        FLogger.a.d("BDAuthorizeRepository", "4. [submitAuthorize]: restoreOriginalAccount B->A = " + r10);
        r4.L$0 = r3;
        r4.L$1 = null;
        r4.label = 4;
        if (g(r10, r8, r4) != r6) goto L98;
        return r6;
    L22:
        th = th;
        l r11 = r8;
        com.larus.common.account.bdauth.repository.a r12 = r9;
    L102:
        com.larus.common.account.bdauth.repository.a r13 = this.f;
        if (r13 != null) goto L105;
        throw th;
    L105:
        if (Intrinsics.areEqual(r13.b, r12.b) == true) goto L115;
        FLogger.a.d("BDAuthorizeRepository", "4. [submitAuthorize]: restoreOriginalAccount B->A = " + r13);
        r4.L$0 = th;
        r4.L$1 = null;
        r4.L$2 = null;
        r4.label = 5;
        if (g(r13, r11, r4) != r6) goto L116;
        return r6;
    L116:
        throw th;
    L115:
        throw th;
    L24:
        l r14 = (l) r4.L$2;
        com.larus.common.account.bdauth.repository.a r15 = (com.larus.common.account.bdauth.repository.a) r4.L$1;
        fb7.c r16 = (fb7.c) r4.L$0;
        ResultKt.throwOnFailure(r2);
    L73:
        n38.b r17 = (n38.b) r2;
        if (r17.c == true) goto L85;
        int r21 = r17.d;
        if (r21 == 1) goto L82;
        if (r21 == 4) goto L82;
        if (r21 == 1011) goto L81;
        com.larus.common.account.bdauth.repository.b r22 = new com.larus.common.account.bdauth.repository.b(BDAuthorizeAccountIssueType.SessionExpired, r15);
    L84:
        return new m.a(r22);
    L81:
        r22 = new com.larus.common.account.bdauth.repository.b(BDAuthorizeAccountIssueType.AccountDeactivated, r15);
    L82:
        r22 = new com.larus.common.account.bdauth.repository.b(BDAuthorizeAccountIssueType.SessionExpired, r15);
        goto L84
    L85:
        r11 = r14;
        r12 = r15;
        r0 = r16;
    L110:
        FLogger.a.d("BDAuthorizeRepository", "3. [submitAuthorize]: submit Auth Code =" + r0);     // Catch: Throwable -> L101
        r4.L$0 = r12;     // Catch: Throwable -> L101
        r4.L$1 = r11;     // Catch: Throwable -> L101
        r4.L$2 = null;     // Catch: Throwable -> L101
        r4.label = 3;     // Catch: Throwable -> L101
        Object r23 = i(r0, r4);     // Catch: Throwable -> L101
        if (r23 != r6) goto L89;
        return r6;
    L89:
        r9 = r12;
        r8 = r11;
        r2 = r23;
    L101:
        th = th;
        goto L102
    L25:
        com.larus.common.account.bdauth.repository.a r24 = (com.larus.common.account.bdauth.repository.a) r4.L$1;
        fb7.c r25 = (fb7.c) r4.L$0;
        ResultKt.throwOnFailure(r2);
        r12 = r24;
        r0 = r25;
        Object r26 = r2;
    L45:
        com.larus.common.account.bdauth.repository.a r27 = (com.larus.common.account.bdauth.repository.a) r26;
        if (r12 != null) goto L48;
        r12 = r27;
    L48:
        if (r12 != null) goto L52;
        return m.c.a;
    L52:
        if (r12.f == false) goto L56;
        return new m.a(new com.larus.common.account.bdauth.repository.b(BDAuthorizeAccountIssueType.EnterpriseUnsupported, r12));
    L56:
        if (r12.g == false) goto L58;
        if (r27 != null) goto L61;
    L63:
        boolean r28 = false;
    L64:
        FLogger r111 = FLogger.a;
        r111.d("BDAuthorizeRepository", "1. [submitAuthorize]: shouldSwitchBeforeAuthorize=" + r28);
        if (r28 == false) goto L67;
        r11 = this.c.a();
    L68:
        if (r28 == false) goto L110;
        r111.d("BDAuthorizeRepository", "2. [submitAuthorize]: switchAccountSilently A->B = " + r12);
        r4.L$0 = r0;
        r4.L$1 = r12;
        r4.L$2 = r11;
        r4.label = 2;
        Object r30 = k(r12, r4);
        if (r30 != r6) goto L72;
        return r6;
    L72:
        r16 = r0;
        r14 = r11;
        r15 = r12;
        r2 = r30;
        goto L73
    L67:
        r11 = null;
        goto L68
    L61:
        if (Intrinsics.areEqual(r27.b, r12.b) == true) goto L63;
        r28 = true;
        goto L64
    L58:
        return new m.a(new com.larus.common.account.bdauth.repository.b(BDAuthorizeAccountIssueType.SessionExpired, r12));
    L26:
        ResultKt.throwOnFailure(r2);
        if (r0 != null) goto L30;
        fb7.d r31 = new fb7.d();
        ((fb7.b) r31).a = -1;
        return new m.b(r31);
    L30:
        int r32 = xz8.b.a;
        if (xz8.b.a.b(this.a) == true) goto L35;
        fb7.d r33 = new fb7.d();
        ((fb7.b) r33).a = -3;
        a(r33, 3);
        return new m.b(r33);
    L35:
        if (AccountService.a.isLogin().booleanValue() == false) goto L37;
        r4.L$0 = r0;
        r12 = r110;
        r4.L$1 = r12;
        r4.label = 1;
        q38.b r34 = IMultiAccountService.a.c();
        if (r34 == null) goto L42;
        r26 = l(r34);
        if (r26 == null) goto L42;
    L43:
        if (r26 != r6) goto L45;
        return r6;
    L42:
        r26 = c(r4);
        goto L43
    L37:
        return m.c.a;
    L7:
        r4 = new BDAuthorizeRepository$submitAuthorize$1(this, r20);
        goto L8
    }

    public final Object b(boolean r25, boolean r26, boolean r27, Continuation<? super com.larus.common.account.bdauth.repository.c> r28) {
        if ((r28 instanceof BDAuthorizeRepository$buildAccountSnapshot$1) == false) goto L7;
        BDAuthorizeRepository$buildAccountSnapshot$1 r4 = (BDAuthorizeRepository$buildAccountSnapshot$1) r28;
        int r6 = r4.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r6 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r4.label;
        String r11 = null;
        if (r8 == 0) goto L16;
        if (r8 == 1) goto L15;
        if (r8 != 2) goto L14;
        boolean r1 = r4.Z$0;
        List r2 = (List) r4.L$2;
        BDAuthorizeRepository r5 = (BDAuthorizeRepository) r4.L$1;
        List r9 = (List) r4.L$0;
        ResultKt.throwOnFailure(r3);
    L44:
        r5.getClass();
        List r10 = (List) r3;
        if (r10.isEmpty() == true) goto L48;
        r2 = r10;
    L48:
        ArrayList r12 = new ArrayList();
        Iterator r13 = r2.iterator();
    L50:
        if (r13.hasNext() == false) goto L71;
        q38.b r14 = (q38.b) r13.next();
        String r15 = r14.g();
        if (r15 != null) goto L54;
    L67:
        com.larus.common.account.bdauth.repository.a r16 = null;
    L68:
        if (r16 == null) goto L50;
        r12.add(r16);
        goto L50
    L54:
        if ((!StringsKt.isBlank(r15)) == false) goto L56;
        String r17 = r15;
    L57:
        if (r17 == null) goto L67;
        String r18 = r14.j();
        String r20 = r14.c();
        if (r20 != null) goto L62;
        r20 = "";
    L62:
        String r110 = r20;
        String r111 = r14.b();
        q38.b.a r21 = r14.i();
        if (r21 == null) goto L65;
        String r112 = r21.b();
    L66:
        r16 = new com.larus.common.account.bdauth.repository.a(r18, r17, r110, r111, r112, r14.l(), r14.d(), r14.k(), r14.e());
        goto L68
    L65:
        r112 = null;
        goto L66
    L56:
        r17 = null;
        goto L57
    L71:
        if (r12.isEmpty() == true) goto L74;
        r9 = r12;
    L74:
        List r22 = r9;
        boolean r113 = r1;
    L76:
        if (r113 == true) goto L78;
    L80:
        List r23 = CollectionsKt.take(h(r22), 1);
    L81:
        List r114 = r23;
        List r24 = r114;
        Iterator r30 = r24.iterator();
    L83:
        if (r30.hasNext() == false) goto L94;
        Object r31 = r30.next();
        com.larus.common.account.bdauth.repository.a r32 = (com.larus.common.account.bdauth.repository.a) r31;
        if (r32.h == true) goto L87;
    L91:
        boolean r33 = false;
    L92:
        if (r33 == false) goto L83;
    L95:
        com.larus.common.account.bdauth.repository.a r34 = (com.larus.common.account.bdauth.repository.a) r31;
        if (r34 == null) goto L100;
        String r35 = r34.b;
        if (r35 == null) goto L100;
        String r115 = r35;
    L116:
        FLogger.a.d("BDAuthorizeRepository", "2. [buildAccountSnapshot]: build account snapshot: defaultSelectedSecUserId=" + r115 + ", displayAccounts=" + r114);
        if (r113 == true) goto L119;
    L121:
        boolean r116 = false;
    L123:
        return new com.larus.common.account.bdauth.repository.c(r114, r115, r116, r113, !r114.isEmpty());
    L119:
        if (((Boolean) this.e.getValue()).booleanValue() == false) goto L121;
        r116 = true;
    L100:
        Iterator r36 = r24.iterator();
    L102:
        if (r36.hasNext() == false) goto L111;
        Object r37 = r36.next();
        com.larus.common.account.bdauth.repository.a r38 = (com.larus.common.account.bdauth.repository.a) r37;
        if (r38.g == true) goto L106;
    L108:
        boolean r40 = false;
    L109:
        if (r40 == false) goto L102;
    L112:
        com.larus.common.account.bdauth.repository.a r41 = (com.larus.common.account.bdauth.repository.a) r37;
        if (r41 == null) goto L115;
        r11 = r41.b;
    L115:
        r115 = r11;
        goto L116
    L106:
        if (r38.f == true) goto L108;
        r40 = true;
        goto L109
    L111:
        r37 = null;
        goto L112
    L87:
        if (r32.g == false) goto L91;
        if (r32.f == true) goto L91;
        r33 = true;
        goto L92
    L94:
        r31 = null;
        goto L95
    L78:
        if (((Boolean) this.e.getValue()).booleanValue() == false) goto L80;
        r23 = h(r22);
        goto L81
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r42 = r4.Z$1;
        boolean r43 = r4.Z$0;
        List r44 = (List) r4.L$0;
        ResultKt.throwOnFailure(r3);
    L35:
        r22 = CollectionsKt.listOfNotNull(r3);
    L36:
        if (r43 == false) goto L75;
        if (r42 == false) goto L75;
        r4.L$0 = r22;
        r4.L$1 = this;
        r4.L$2 = r44;
        r4.Z$0 = r43;
        r4.label = 2;
        kotlinx.coroutines.j r45 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r4), 1);
        r45.C();
        IMultiAccountService.a.f(new i(r45));
        Object r46 = r45.B();
        if (r46 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L41;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L41:
        if (r46 != r7) goto L43;
        return r7;
    L43:
        r9 = r22;
        r3 = r46;
        r1 = r43;
        r2 = r44;
        r5 = this;
    L75:
        r113 = r43;
        goto L76
    L16:
        ResultKt.throwOnFailure(r3);
        if (r25 == false) goto L19;
        FLogger.a.d("BDAuthorizeRepository", "1. [buildAccountSnapshot]: build account snapshot: isLogin=" + r25 + ", multiAccountEnabled=" + r26 + ", refreshRemote=" + r27);
        List r47 = IMultiAccountService.a.g();
        if (r26 == true) goto L23;
    L31:
        r4.L$0 = r47;
        r4.Z$0 = r26;
        r4.Z$1 = r27;
        r4.label = 1;
        r3 = c(r4);
        if (r3 != r7) goto L34;
        return r7;
    L34:
        r44 = r47;
        r42 = r27;
        r43 = r26;
        goto L35
    L23:
        if ((!r47.isEmpty()) == false) goto L31;
        ArrayList r48 = new ArrayList();
        Iterator r50 = r47.iterator();
    L26:
        if (r50.hasNext() == false) goto L30;
        com.larus.common.account.bdauth.repository.a r117 = l((q38.b) r50.next());
        if (r117 == null) goto L26;
        r48.add(r117);
        goto L26
    L30:
        r22 = r48;
        r44 = r47;
        r42 = r27;
        r43 = r26;
        goto L36
    L19:
        return new com.larus.common.account.bdauth.repository.c(CollectionsKt.emptyList(), null, false, r26, false);
    L7:
        r4 = new BDAuthorizeRepository$buildAccountSnapshot$1(this, r28);
        goto L8
    }
}
