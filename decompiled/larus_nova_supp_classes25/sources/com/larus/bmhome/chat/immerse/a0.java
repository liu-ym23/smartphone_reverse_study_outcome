package com.larus.bmhome.chat.immerse;

import android.animation.AnimatorSet;
import com.bytedance.keva.Keva;
import com.larus.bmhome.databinding.LarusPageChatImmersiveBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a0 {
    public final LarusPageChatImmersiveBinding a;
    public final AnimatorSet b;
    public final Keva c;
    public boolean d;

    public static final class a {
    }

    static {
    }

    public a0(LarusPageChatImmersiveBinding r2) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        this.a = r2;
        this.b = new AnimatorSet();
        this.c = Keva.getRepo("immers", 0);
    }
}
