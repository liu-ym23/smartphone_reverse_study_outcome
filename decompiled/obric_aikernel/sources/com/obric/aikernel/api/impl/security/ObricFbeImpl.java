package com.obric.aikernel.api.impl.security;

import android.content.Context;
import android.util.Log;
import com.obric.aikernel.middleware.api.traker.TrackerApi;
import com.obric.framework.ObricSecurityPartition;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ObricFbeImpl extends com.obric.aikernel.api.security.a {

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public ObricFbeImpl() {
    }

    public static final /* synthetic */ Object b(ObricFbeImpl r10, Continuation r11) {
        return r10.c(r11);
    }

    private final Object c(Continuation<? super Unit> r10) {
        if ((r10 instanceof ObricFbeImpl$checkFbeRootDirs$1) == false) goto L7;
        ObricFbeImpl$checkFbeRootDirs$1 r11 = (ObricFbeImpl$checkFbeRootDirs$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L18;
        if (r15 == 1) goto L17;
        if (r15 == 2) goto L16;
        if (r15 != 3) goto L15;
        int r16 = r11.I$0;
        Pair[] r17 = (Pair[]) r11.L$1;
        Pair[] r18 = (Pair[]) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L30:
        r17[r16] = TuplesKt.to(r13, Boxing.boxBoolean(false));
        Map r19 = MapsKt.mapOf(r18);
        JSONObject r110 = new JSONObject();
        Iterator r20 = r19.entrySet().iterator();
    L32:
        if (r20.hasNext() == false) goto L56;
        Map.Entry r21 = (Map.Entry) r20.next();
        String r22 = (String) r21.getKey();
        boolean r23 = ((Boolean) r21.getValue()).booleanValue();
        File r24 = new File(r22);
        String r25 = r24.getName();
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L51
        boolean r27 = r24.exists();     // Catch: Throwable -> L51
        String r28 = r25 + "_exist";     // Catch: Throwable -> L51
        if (r27 == false) goto L37;
        boolean r29 = true;
    L38:
        r110.put(r28, r29);     // Catch: Throwable -> L51
        if (r24.canWrite() == false) goto L43;
        String r30 = r25 + "_w";     // Catch: Throwable -> L51
    L41:
        r110.put(r30, true);     // Catch: Throwable -> L51
    L46:
        if (r27 == true) goto L49;
        if (r23 == false) goto L49;
        r110.put(r25 + "_mkdir", r24.mkdirs());     // Catch: Throwable -> L51
    L49:
        Object r31 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L51
    L53:
        Throwable r32 = Result.m35exceptionOrNullimpl(r31);
        if (r32 == null) goto L32;
        r110.put(r25 + "_exception", ExceptionsKt.stackTraceToString(r32));
        goto L32
    L43:
        if (r24.canRead() == false) goto L45;
        r30 = r25 + "_r";     // Catch: Throwable -> L51
        goto L41
    L45:
        r110.put(r25 + "_wr", false);     // Catch: Throwable -> L51
        goto L46
    L37:
        r29 = false;
    L51:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r31 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L53
    L56:
        Log.i("ObricFbeImpl", "checkFbeRootDirs: " + r110);
        TrackerApi.INSTANCE.onEvent("fbe_roots_check", r110);
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        int r34 = r11.I$0;
        StringBuilder r35 = (StringBuilder) r11.L$2;
        Pair[] r36 = (Pair[]) r11.L$1;
        Pair[] r37 = (Pair[]) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L26:
        r35.append((String) r13);
        r35.append("/preset_model_decrypt");
        r36[r34] = TuplesKt.to(r35.toString(), Boxing.boxBoolean(true));
        r37[2] = TuplesKt.to("/data/fbe", Boxing.boxBoolean(false));
        r37[3] = TuplesKt.to("/data/fbe/aikernel", Boxing.boxBoolean(false));
        ObricSecurityPartition r38 = ObricSecurityPartition.f5790a;
        r11.L$0 = r37;
        r11.L$1 = r37;
        r11.L$2 = null;
        r11.I$0 = 4;
        r11.label = 3;
        Object r39 = r38.d(r11);
        if (r39 != r14) goto L29;
        return r14;
    L29:
        r16 = 4;
        r13 = r39;
        r18 = r37;
        r17 = r18;
        goto L30
    L17:
        int r40 = r11.I$0;
        StringBuilder r41 = (StringBuilder) r11.L$2;
        Pair[] r42 = (Pair[]) r11.L$1;
        r37 = (Pair[]) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L22:
        r41.append((String) r13);
        r41.append("/prs");
        r42[r40] = TuplesKt.to(r41.toString(), Boxing.boxBoolean(true));
        r35 = new StringBuilder();
        ObricSecurityPartition r43 = ObricSecurityPartition.f5790a;
        r11.L$0 = r37;
        r11.L$1 = r37;
        r11.L$2 = r35;
        r11.I$0 = 1;
        r11.label = 2;
        r13 = r43.d(r11);
        if (r13 != r14) goto L25;
        return r14;
    L25:
        r34 = 1;
        r36 = r37;
        goto L26
    L18:
        ResultKt.throwOnFailure(r13);
        r42 = new Pair[5];
        r41 = new StringBuilder();
        ObricSecurityPartition r44 = ObricSecurityPartition.f5790a;
        r11.L$0 = r42;
        r11.L$1 = r42;
        r11.L$2 = r41;
        r11.I$0 = 0;
        r11.label = 1;
        r13 = r44.d(r11);
        if (r13 != r14) goto L21;
        return r14;
    L21:
        r40 = 0;
        r37 = r42;
    L7:
        r11 = new ObricFbeImpl$checkFbeRootDirs$1(this, r10);
        goto L8
    }

    @Override // com.obric.aikernel.api.security.a
    public String a(Context r10, String r11, int r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "root");
        Intrinsics.checkNotNullParameter(r13, "hostType");
        String r14 = ObricSecurityPartition.f5790a.g(r10, 0, r12, r13);
        h.d(m0.a(z0.b()), null, null, new ObricFbeImpl$initAndGetRootDir$1$1(this, null), 3, null);
        return r14;
    }
}
