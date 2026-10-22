package kotlinx.coroutines.selects;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0007¢\u0006\u0002\u0010\n\u001aH\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"onTimeout", "", "R", "Lkotlinx/coroutines/selects/SelectBuilder;", "timeMillis", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectBuilder;JLkotlin/jvm/functions/Function1;)V", LocationMonitorConst.TIMEOUT, "Lkotlin/time/Duration;", "onTimeout-8Mi8wO0", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class b {
    public static final <R> void a(c<? super R> r2, long r3, Function1<? super Continuation<? super R>, ? extends Object> r5) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
        Function1<? super Continuation<? super R>, ? extends Object> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        r4.a(new a(r3).a(), r6);
    }

    public static final <R> void b(c<? super R> r2, long r3, Function1<? super Continuation<? super R>, ? extends Object> r5) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        a(r4, au.a(r3), r6);
    }
}
