package com.obric.aikernel.api.impl.security;

import android.util.Log;
import com.obric.aikernel.api.security.FbeFeature;
import com.obric.aikernel.middleware.api.traker.TrackerApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/obric/aikernel/api/impl/security/ObricFbeImpl;", "Lcom/obric/aikernel/api/security/FbeFeature;", "()V", "checkFbeRootDirs", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initAndGetRootDir", "", "context", "Landroid/content/Context;", "root", "hostUserId", "", "hostType", "Companion", "fbe_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a extends FbeFeature {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0249a f5983a = null;

    /* JADX INFO: renamed from: com.obric.aikernel.api.impl.security.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/aikernel/api/impl/security/ObricFbeImpl$Companion;", "", "()V", "TAG", "", "fbe_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0249a {
        private C0249a() {
        }

        public /* synthetic */ C0249a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f5983a = new C0249a(null);
    }

    public a() {
    }

    public static final /* synthetic */ Object a(a r2, Continuation r3) {
        return ((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin")).a((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(Continuation<? super Unit> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, ObricFbeImpl$checkFbeRootDirs$1.class) == false) goto L7;
        ObricFbeImpl$checkFbeRootDirs$1 r0 = (ObricFbeImpl$checkFbeRootDirs$1) ZeusTransformUtils.preCheckCast(r13, ObricFbeImpl$checkFbeRootDirs$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 == 1) goto L17;
        if (r2 == 2) goto L16;
        if (r2 != 3) goto L15;
        int r15 = r0.I$0;
        Pair[] r3 = (Pair[]) ZeusTransformUtils.preCheckCast(r0.L$1, Pair[].class, "com.obric.memorydata.plugin");
        Pair[] r1 = (Pair[]) ZeusTransformUtils.preCheckCast(r0.L$0, Pair[].class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L30:
        r3[r15] = TuplesKt.to(r11, Boxing.boxBoolean(false));
        Map r16 = MapsKt.mapOf(r1);
        JSONObject r17 = new JSONObject();
        Iterator r18 = r16.entrySet().iterator();
    L32:
        if (r18.hasNext() == false) goto L56;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin");
        boolean r6 = ((Boolean) ZeusTransformUtils.preCheckCast(r4.getValue(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        File r7 = new File(r5);
        String r8 = r7.getName();
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L51
        boolean r10 = r7.exists();     // Catch: Throwable -> L51
        String r19 = r8 + "_exist";     // Catch: Throwable -> L51
        if (r10 == false) goto L37;
        boolean r20 = true;
    L38:
        r17.put(r19, r20);     // Catch: Throwable -> L51
        if (r7.canWrite() == false) goto L43;
        String r21 = r8 + "_w";     // Catch: Throwable -> L51
    L41:
        r17.put(r21, true);     // Catch: Throwable -> L51
    L46:
        if (r10 == true) goto L49;
        if (r6 == false) goto L49;
        r17.put(r8 + "_mkdir", r7.mkdirs());     // Catch: Throwable -> L51
    L49:
        Object r22 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L51
    L53:
        Throwable r23 = Result.m1424exceptionOrNullimpl(r22);
        if (r23 == null) goto L32;
        r17.put(r8 + "_exception", ExceptionsKt.stackTraceToString(r23));
        goto L32
    L43:
        if (r7.canRead() == false) goto L45;
        r21 = r8 + "_r";     // Catch: Throwable -> L51
        goto L41
    L45:
        r17.put(r8 + "_wr", false);     // Catch: Throwable -> L51
        goto L46
    L37:
        r20 = false;
    L51:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r22 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L53
    L56:
        Log.i("ObricFbeImpl", "checkFbeRootDirs: " + r17);
        TrackerApi.INSTANCE.onEvent("fbe_roots_check", r17);
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        int r25 = r0.I$0;
        StringBuilder r26 = (StringBuilder) ZeusTransformUtils.preCheckCast(r0.L$2, StringBuilder.class, "com.obric.memorydata.plugin");
        Pair[] r27 = (Pair[]) ZeusTransformUtils.preCheckCast(r0.L$1, Pair[].class, "com.obric.memorydata.plugin");
        Pair[] r28 = (Pair[]) ZeusTransformUtils.preCheckCast(r0.L$0, Pair[].class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L26:
        r27[r25] = TuplesKt.to(r26.append((String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin")).append("/preset_model_decrypt").toString(), Boxing.boxBoolean(true));
        r28[2] = TuplesKt.to("/data/fbe", Boxing.boxBoolean(false));
        r28[3] = TuplesKt.to("/data/fbe/aikernel", Boxing.boxBoolean(false));
        com.obric.framework.a r29 = com.obric.framework.a.f8039a;
        r0.L$0 = r28;
        r0.L$1 = r28;
        r0.L$2 = null;
        r0.I$0 = 4;
        r0.label = 3;
        Object r30 = r29.a(r0);
        if (r30 != r14) goto L29;
        return r14;
    L29:
        r15 = 4;
        r11 = r30;
        r1 = r28;
        r3 = r1;
        goto L30
    L17:
        int r31 = r0.I$0;
        StringBuilder r32 = (StringBuilder) ZeusTransformUtils.preCheckCast(r0.L$2, StringBuilder.class, "com.obric.memorydata.plugin");
        Pair[] r33 = (Pair[]) ZeusTransformUtils.preCheckCast(r0.L$1, Pair[].class, "com.obric.memorydata.plugin");
        r28 = (Pair[]) ZeusTransformUtils.preCheckCast(r0.L$0, Pair[].class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L22:
        r33[r31] = TuplesKt.to(r32.append((String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.memorydata.plugin")).append("/prs").toString(), Boxing.boxBoolean(true));
        r26 = new StringBuilder();
        com.obric.framework.a r110 = com.obric.framework.a.f8039a;
        r0.L$0 = r28;
        r0.L$1 = r28;
        r0.L$2 = r26;
        r0.I$0 = 1;
        r0.label = 2;
        r11 = r110.a(r0);
        if (r11 != r14) goto L25;
        return r14;
    L25:
        r25 = 1;
        r27 = r28;
        goto L26
    L18:
        ResultKt.throwOnFailure(r11);
        r33 = new Pair[5];
        r32 = new StringBuilder();
        com.obric.framework.a r111 = com.obric.framework.a.f8039a;
        r0.L$0 = r33;
        r0.L$1 = r33;
        r0.L$2 = r32;
        r0.I$0 = 0;
        r0.label = 1;
        r11 = r111.a(r0);
        if (r11 != r14) goto L21;
        return r14;
    L21:
        r31 = 0;
        r28 = r33;
    L7:
        r0 = new ObricFbeImpl$checkFbeRootDirs$1(this, r13);
        goto L8
    }
}
