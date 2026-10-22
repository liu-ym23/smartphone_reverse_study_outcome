package com.larus.agents.impl.settings;

import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.agents.api.OfficeTaskPreferenceSaveResult;
import com.larus.agents.impl.network.NetworkOfficeTaskPreferenceRemoteDataSource;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class DefaultOfficeTaskPreferenceRepository implements e {
    public final e a;
    public final d b;
    public final Function0<String> c;
    public final MutexImpl d;
    public final MutexImpl e;

    public static final class a {
    }

    static {
    }

    public DefaultOfficeTaskPreferenceRepository(int r4) {
        KevaOfficeTaskPreferenceRepository r5 = new KevaOfficeTaskPreferenceRepository();
        NetworkOfficeTaskPreferenceRemoteDataSource r0 = new NetworkOfficeTaskPreferenceRemoteDataSource();
        Function0<String> r1 = new com.larus.agents.impl.settings.a();
        Intrinsics.checkNotNullParameter(r5, "local");
        Intrinsics.checkNotNullParameter(r0, "remote");
        Intrinsics.checkNotNullParameter(r1, "accountIdProvider");
        this.a = r5;
        this.b = r0;
        this.c = r1;
        this.d = kotlinx.coroutines.sync.b.a();
        this.e = kotlinx.coroutines.sync.b.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v10, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v26, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v3, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v30, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    @Override // com.larus.agents.impl.settings.e
    public final Object a(Continuation<? super b> r12) {
        if ((r12 instanceof DefaultOfficeTaskPreferenceRepository$get$1) == false) goto L7;
        DefaultOfficeTaskPreferenceRepository$get$1 r0 = (DefaultOfficeTaskPreferenceRepository$get$1) r12;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r3 = r0.label;
        switch(r3) {
            case 0: goto L30;
            case 1: goto L29;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L17;
            case 8: goto L12;
            default: goto L11;
        };
    L12:
        ?? r4 = (kotlinx.coroutines.sync.a) r0.L$1;
        b r5 = (b) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L15
        r4 = r4;
    L67:
        if (r13 == OfficeTaskPreferenceSaveResult.SUCCESS) goto L69;
        FLogger.a.w("DefaultOfficeTaskPreferenceRepo", "cache remote preference failed");     // Catch: Throwable -> L15
    L69:
        b r14 = r5;
        ?? r6 = r4;
    L71:
        r6.unlock(null);
        return r14;
    L15:
        th = th;
        r3 = r4;
    L73:
        r3.unlock(null);
        throw th;
    L17:
        long r7 = r0.J$0;
        kotlinx.coroutines.sync.a r8 = (kotlinx.coroutines.sync.a) r0.L$2;
        b r9 = (b) r0.L$1;
        String r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L20
        r3 = r8;
    L57:
        r14 = (b) r13;     // Catch: Throwable -> L20
        r6 = r3;
        if (Intrinsics.areEqual(this.c.invoke(), r10) == false) goto L71;
        if (r14.b == r7) goto L62;
        r6 = r3;
        goto L71
    L62:
        e r15 = this.a;     // Catch: Throwable -> L20
        String r11 = r9.a;     // Catch: Throwable -> L20
        r0.L$0 = r9;     // Catch: Throwable -> L20
        r0.L$1 = r3;     // Catch: Throwable -> L20
        r0.L$2 = null;     // Catch: Throwable -> L20
        r0.label = 8;     // Catch: Throwable -> L20
        r13 = r15.b(r11, r0);     // Catch: Throwable -> L20
        if (r13 != r2) goto L65;
        return r2;
    L65:
        r4 = r3;
        r5 = r9;
        goto L67
    L22:
        r7 = r0.J$0;
        kotlinx.coroutines.sync.a r16 = (kotlinx.coroutines.sync.a) r0.L$2;
        r9 = (b) r0.L$1;
        r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
        kotlinx.coroutines.sync.a r17 = r16;
    L54:
        e r19 = this.a;     // Catch: Throwable -> L20
        r0.L$0 = r10;     // Catch: Throwable -> L20
        r0.L$1 = r9;     // Catch: Throwable -> L20
        r0.L$2 = r17;     // Catch: Throwable -> L20
        r0.J$0 = r7;     // Catch: Throwable -> L20
        r0.label = 7;     // Catch: Throwable -> L20
        r13 = r19.a(r0);     // Catch: Throwable -> L20
        r3 = r17;
        if (r13 != r2) goto L57;
        return r2;
    L23:
        ResultKt.throwOnFailure(r13);
    L49:
        return r13;
    L24:
        ResultKt.throwOnFailure(r13);
    L78:
        return r13;
    L25:
        r7 = r0.J$0;
        String r20 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
        Object r110 = ((Result) r13).unbox-impl();
    L43:
        if (Result.exceptionOrNull-impl(r110) != null) goto L75;
        r9 = (b) r110;
        int r111 = c.a;
        if (c.a(r9.a) == true) goto L50;
        FLogger.a.w("DefaultOfficeTaskPreferenceRepo", "remote preference is too long, use local cache");
        e r112 = this.a;
        r0.L$0 = null;
        r0.label = 5;
        r13 = r112.a(r0);
        if (r13 != r2) goto L49;
        return r2;
    L50:
        kotlinx.coroutines.sync.a r113 = this.d;
        r0.L$0 = r20;
        r0.L$1 = r9;
        r0.L$2 = r113;
        r0.J$0 = r7;
        r0.label = 6;
        if (r113.a(null, r0) != r2) goto L53;
        return r2;
    L53:
        r10 = r20;
        r17 = r113;
        goto L54
    L75:
        FLogger.a.w("DefaultOfficeTaskPreferenceRepo", "fetch remote preference failed, use local cache");
        e r114 = this.a;
        r0.L$0 = null;
        r0.label = 4;
        r13 = r114.a(r0);
        if (r13 != r2) goto L78;
        return r2;
    L26:
        kotlinx.coroutines.sync.a r21 = (kotlinx.coroutines.sync.a) r0.L$1;
        String r22 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L79
        r3 = r21;
    L37:
        long r23 = ((b) r13).b;     // Catch: Throwable -> L79
        r3.unlock(null);
        d r115 = this.b;
        r0.L$0 = r22;
        r0.L$1 = null;
        r0.J$0 = r23;
        r0.label = 3;
        r110 = r115.a(r0);
        if (r110 != r2) goto L41;
        return r2;
    L41:
        r20 = r22;
        r7 = r23;
        goto L43
    L29:
        kotlinx.coroutines.sync.a r24 = (kotlinx.coroutines.sync.a) r0.L$1;
        r22 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
        kotlinx.coroutines.sync.a r25 = r24;
    L34:
        e r116 = this.a;     // Catch: Throwable -> L79
        r0.L$0 = r22;     // Catch: Throwable -> L79
        r0.L$1 = r25;     // Catch: Throwable -> L79
        r0.label = 2;     // Catch: Throwable -> L79
        r13 = r116.a(r0);     // Catch: Throwable -> L79
        r3 = r25;
        if (r13 != r2) goto L37;
        return r2;
    L30:
        ResultKt.throwOnFailure(r13);
        r22 = (String) this.c.invoke();
        kotlinx.coroutines.sync.a r117 = this.d;
        r0.L$0 = r22;
        r0.L$1 = r117;
        r0.label = 1;
        if (r117.a(null, r0) != r2) goto L33;
        return r2;
    L33:
        r25 = r117;
        goto L34
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        th = th;
    L79:
        th = move-exception;
        r3.unlock(null);
        throw th;
    L7:
        r0 = new DefaultOfficeTaskPreferenceRepository$get$1(this, r12);
        goto L8
    }

    @Override // com.larus.agents.impl.settings.e
    public final Object b(String r19, Continuation<? super OfficeTaskPreferenceSaveResult> r110) {
        if ((r110 instanceof DefaultOfficeTaskPreferenceRepository$save$1) == false) goto L7;
        DefaultOfficeTaskPreferenceRepository$save$1 r3 = (DefaultOfficeTaskPreferenceRepository$save$1) r110;
        int r4 = r3.label;
        if ((r4 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r3.label = r4 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r0 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L30;
        if (r6 == 1) goto L29;
        if (r6 == 2) goto L24;
        if (r6 == 3) goto L21;
        if (r6 != 4) goto L20;
        kotlinx.coroutines.sync.a r2 = (kotlinx.coroutines.sync.a) r3.L$1;
        kotlinx.coroutines.sync.a r7 = (kotlinx.coroutines.sync.a) r3.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L17
    L57:
        if (r0 == OfficeTaskPreferenceSaveResult.SUCCESS) goto L59;
        FLogger.a.w("DefaultOfficeTaskPreferenceRepo", "cache uploaded preference failed");     // Catch: Throwable -> L17
    L59:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L17
        r2.unlock(null);     // Catch: Throwable -> L64
        OfficeTaskPreferenceSaveResult r8 = OfficeTaskPreferenceSaveResult.SUCCESS;     // Catch: Throwable -> L64
        kotlinx.coroutines.sync.a r9 = r7;
    L62:
        r9.unlock(null);
        return r8;
    L64:
        th = th;
    L75:
        r7.unlock(null);
        throw th;
    L17:
        th = th;
        kotlinx.coroutines.sync.a r10 = r7;
    L68:
        r2.unlock(null);     // Catch: Throwable -> L70
        throw th;     // Catch: Throwable -> L70
    L70:
        th = th;
    L74:
        r7 = r10;
        goto L75
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        r2 = (kotlinx.coroutines.sync.a) r3.L$3;
        String r11 = (String) r3.L$2;
        r10 = (kotlinx.coroutines.sync.a) r3.L$1;
        String r12 = (String) r3.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L70
    L77:
    L67:
        th = th;
        goto L68
    L50:
        if (Intrinsics.areEqual(this.c.invoke(), r11) == true) goto L52;
        FLogger.a.w("DefaultOfficeTaskPreferenceRepo", "account changed before caching uploaded preference");     // Catch: Throwable -> L67
        r7 = r10;
        goto L59
    L52:
        e r13 = this.a;     // Catch: Throwable -> L67
        r3.L$0 = r10;     // Catch: Throwable -> L67
        r3.L$1 = r2;     // Catch: Throwable -> L67
        r3.L$2 = null;     // Catch: Throwable -> L67
        r3.L$3 = null;     // Catch: Throwable -> L67
        r3.label = 4;     // Catch: Throwable -> L67
        r0 = r13.b(r12, r3);     // Catch: Throwable -> L67
        if (r0 != r5) goto L55;
        return r5;
    L55:
        r7 = r10;
        goto L57
    L24:
        r11 = (String) r3.L$2;
        r9 = (kotlinx.coroutines.sync.a) r3.L$1;
        String r14 = (String) r3.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L27
    L42:
        r8 = (OfficeTaskPreferenceSaveResult) r0;     // Catch: Throwable -> L27
        if (r8 == OfficeTaskPreferenceSaveResult.SUCCESS) goto L45;
        FLogger.a.w("DefaultOfficeTaskPreferenceRepo", "upload remote preference failed, result=" + r8);     // Catch: Throwable -> L27
        goto L62
    L45:
        r2 = this.d;     // Catch: Throwable -> L27
        r3.L$0 = r14;     // Catch: Throwable -> L27
        r3.L$1 = r9;     // Catch: Throwable -> L27
        r3.L$2 = r11;     // Catch: Throwable -> L27
        r3.L$3 = r2;     // Catch: Throwable -> L27
        r3.label = 3;     // Catch: Throwable -> L27
        if (r2.a(null, r3) != r5) goto L48;
        return r5;
    L48:
        r10 = r9;
        r12 = r14;
    L27:
        th = th;
        r10 = r9;
        goto L74
    L29:
        kotlinx.coroutines.sync.a r15 = (kotlinx.coroutines.sync.a) r3.L$1;
        String r16 = (String) r3.L$0;
        ResultKt.throwOnFailure(r0);
        kotlinx.coroutines.sync.a r17 = r15;
        String r20 = r16;
    L83:
        String r21 = (String) this.c.invoke();     // Catch: Throwable -> L72
        d r111 = this.b;     // Catch: Throwable -> L72
        b r112 = new b(r20, 0);     // Catch: Throwable -> L72
        r3.L$0 = r20;     // Catch: Throwable -> L72
        r3.L$1 = r17;     // Catch: Throwable -> L72
        r3.L$2 = r21;     // Catch: Throwable -> L72
        r3.label = 2;     // Catch: Throwable -> L72
        Object r22 = r111.b(r112, r3);     // Catch: Throwable -> L72
        if (r22 != r5) goto L41;
        return r5;
    L41:
        String r113 = r20;
        r11 = r21;
        r0 = r22;
        r9 = r17;
        r14 = r113;
    L72:
        th = th;
        r10 = r17;
        goto L74
    L30:
        ResultKt.throwOnFailure(r0);
        if (c.a(r19) == false) goto L33;
        kotlinx.coroutines.sync.a r23 = this.e;
        r20 = r19;
        r3.L$0 = r20;
        r3.L$1 = r23;
        r3.label = 1;
        if (r23.a(null, r3) != r5) goto L37;
        return r5;
    L37:
        r17 = r23;
        goto L83
    L33:
        return OfficeTaskPreferenceSaveResult.MAX_CHARACTER_LIMIT_EXCEEDED;
    L7:
        r3 = new DefaultOfficeTaskPreferenceRepository$save$1(this, r110);
        goto L8
    }
}
