package ds8;

import android.animation.ValueAnimator;
import com.larus.bmhome.top.ChatTopFloatingButtonComponent;
import com.larus.chat.core.impl.databinding.LarusPageChatTopFloatingButtonBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class f implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ChatTopFloatingButtonComponent a;
    public final /* synthetic */ LarusPageChatTopFloatingButtonBinding b;

    public /* synthetic */ f(ChatTopFloatingButtonComponent r1, LarusPageChatTopFloatingButtonBinding r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        ChatTopFloatingButtonComponent r0 = this.a;
        LarusPageChatTopFloatingButtonBinding r1 = this.b;
        int r2 = ChatTopFloatingButtonComponent.z;
        Intrinsics.checkNotNullParameter(r4, "va");
        Object r5 = r4.getAnimatedValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Int");
        r0.s = ((Integer) r5).intValue();
        r1.a.invalidateOutline();
    }
}
