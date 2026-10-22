package com.obric.framework;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aikernel.runtime.utils.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.da;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0003J \u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0011\u0010\u0015\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0003J&\u0010\u0019\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0004J \u0010\u001c\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J \u0010\u001d\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/obric/framework/ObricSecurityPartition;", "", "()V", "TAG", "", "cachedHostType", "cachedHostUserId", "", "initDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "", "checkGuardFile", "", "context", "Landroid/content/Context;", "rootPath", "clearRootEncryptRoot", "salt", "Ljava/io/File;", "root", "serviceId", "getFBEPath", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFBEPathInternal", "getSaltFile", CommonConsts.APM_INNER_EVENT_COST_INIT, "hostUserId", "hostType", "initSecurityPartition", "tryInit", "fbe_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8039a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f8040b;
    private static String c;
    private static final w<Unit> d = null;

    static {
        f8039a = new a();
        c = l.f6234a.a();
        d = y.a(null, 1, null);
    }

    private a() {
    }

    public static final /* synthetic */ w a() {
        return d;
    }

    private final String b() {
        if (f8040b == (-1)) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        return "/data/fbe/aikernel/" + f8040b;
    L10:
        throw new IllegalStateException("init() must be called first".toString());
    L5:
        r1 = false;
        goto L6
    }

    public final Object a(Continuation<? super String> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, ObricSecurityPartition$getFBEPath$1.class) == false) goto L7;
        ObricSecurityPartition$getFBEPath$1 r0 = (ObricSecurityPartition$getFBEPath$1) ZeusTransformUtils.preCheckCast(r9, ObricSecurityPartition$getFBEPath$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        a this = (a) ZeusTransformUtils.preCheckCast(r0.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r10);
    L18:
        return this.b();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        Function2 r11 = (Function2) ZeusTransformUtils.preCheckCast(new ObricSecurityPartition$getFBEPath$2(null), Function2.class, "com.obric.memorydata.plugin");
        r0.L$0 = this;
        r0.label = 1;
        if (da.a(5000, r11, r0) != r2) goto L18;
        return r2;
    L7:
        r0 = new ObricSecurityPartition$getFBEPath$1(this, r9);
        goto L8
    }
}
