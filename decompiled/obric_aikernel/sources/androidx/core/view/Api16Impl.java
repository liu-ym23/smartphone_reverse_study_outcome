package androidx.core.view;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(16)
final class Api16Impl {
    public static final Api16Impl INSTANCE = null;

    static {
        INSTANCE = new Api16Impl();
    }

    private Api16Impl() {
    }

    @JvmStatic
    @DoNotInline
    public static final void postOnAnimationDelayed(View r10, Runnable r11, long r12) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "action");
        r10.postOnAnimationDelayed(r11, r12);
    }
}
