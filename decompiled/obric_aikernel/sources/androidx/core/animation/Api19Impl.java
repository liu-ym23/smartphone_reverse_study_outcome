package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
final class Api19Impl {
    public static final Api19Impl INSTANCE = null;

    static {
        INSTANCE = new Api19Impl();
    }

    private Api19Impl() {
    }

    @JvmStatic
    @DoNotInline
    public static final void addPauseListener(Animator r10, Animator.AnimatorPauseListener r11) {
        Intrinsics.checkNotNullParameter(r10, "animator");
        Intrinsics.checkNotNullParameter(r11, "listener");
        r10.addPauseListener(r11);
    }
}
