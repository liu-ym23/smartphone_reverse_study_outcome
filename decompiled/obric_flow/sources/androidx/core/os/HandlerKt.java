package androidx.core.os;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u001a1\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b¨\u0006\f"}, d2 = {"postAtTime", "Ljava/lang/Runnable;", "Landroid/os/Handler;", "uptimeMillis", "", "token", "", "action", "Lkotlin/Function0;", "", "postDelayed", "delayInMillis", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HandlerKt {
    public static final Runnable postAtTime(Handler r5, long r10, Object r11, Function0<Unit> r12) {
        HandlerKt$postAtTime$runnable$1 r13 = new HandlerKt$postAtTime$runnable$1(r12);
        r5.postAtTime(r13, r11, r10);
        return r13;
    }

    public static /* synthetic */ Runnable postAtTime$default(Handler r5, long r10, Object r11, Function0 r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r11 = null;
    L5:
        HandlerKt$postAtTime$runnable$1 r15 = new HandlerKt$postAtTime$runnable$1(r12);
        r5.postAtTime(r15, r11, r10);
        return r15;
    }

    public static final Runnable postDelayed(Handler r5, long r10, Object r11, Function0<Unit> r12) {
        HandlerKt$postDelayed$runnable$1 r13 = new HandlerKt$postDelayed$runnable$1(r12);
        if (r11 != null) goto L5;
        r5.postDelayed(r13, r10);
    L6:
        return r13;
    L5:
        HandlerCompat.postDelayed(r5, r13, r11, r10);
        goto L6
    }

    public static /* synthetic */ Runnable postDelayed$default(Handler r5, long r10, Object r11, Function0 r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r11 = null;
    L5:
        HandlerKt$postDelayed$runnable$1 r15 = new HandlerKt$postDelayed$runnable$1(r12);
        if (r11 != null) goto L8;
        r5.postDelayed(r15, r10);
    L9:
        return r15;
    L8:
        HandlerCompat.postDelayed(r5, r15, r11, r10);
        goto L9
    }
}
