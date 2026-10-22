package androidx.core.os;

import android.os.Handler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u001a1\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b¨\u0006\f"}, d2 = {"postAtTime", "Ljava/lang/Runnable;", "Landroid/os/Handler;", "uptimeMillis", "", "token", "", "action", "Lkotlin/Function0;", "", "postDelayed", "delayInMillis", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HandlerKt {
    public static final Runnable postAtTime(Handler r2, long r3, Object r5, Function0<Unit> r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.preCheckCast(new HandlerKt$postAtTime$runnable$1((Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin")), Runnable.class, "com.obric.memorydata.plugin");
        r2.postAtTime(r7, r5, r3);
        return r7;
    }

    public static /* synthetic */ Runnable postAtTime$default(Handler r1, long r2, Object r4, Function0 r5, int r6, Object r7) {
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L5;
        r4 = null;
    L5:
        Runnable r9 = (Runnable) ZeusTransformUtils.preCheckCast(new HandlerKt$postAtTime$runnable$1(r8), Runnable.class, "com.obric.memorydata.plugin");
        r1.postAtTime(r9, r4, r2);
        return r9;
    }

    public static final Runnable postDelayed(Handler r2, long r3, Object r5, Function0<Unit> r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.preCheckCast(new HandlerKt$postDelayed$runnable$1((Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin")), Runnable.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        r2.postDelayed(r7, r3);
    L6:
        return r7;
    L5:
        HandlerCompat.postDelayed(r2, r7, r5, r3);
        goto L6
    }

    public static /* synthetic */ Runnable postDelayed$default(Handler r1, long r2, Object r4, Function0 r5, int r6, Object r7) {
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L5;
        r4 = null;
    L5:
        Runnable r9 = (Runnable) ZeusTransformUtils.preCheckCast(new HandlerKt$postDelayed$runnable$1(r8), Runnable.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        r1.postDelayed(r9, r2);
    L9:
        return r9;
    L8:
        HandlerCompat.postDelayed(r1, r9, r4, r2);
        goto L9
    }
}
