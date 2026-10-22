package com.larus.bmhome.view;

import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/larus/bmhome/view/ChatConstraintLayout$init$1", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "onPrepare", "", "animation", "Landroidx/core/view/WindowInsetsAnimationCompat;", "onProgress", "Landroidx/core/view/WindowInsetsCompat;", "insets", "runningAnimations", "", "onEnd", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatConstraintLayout$init$1 extends WindowInsetsAnimationCompat.Callback {
    public final /* synthetic */ ChatConstraintLayout a;

    public ChatConstraintLayout$init$1(ChatConstraintLayout r1) {
        this.a = r1;
        super(1);
    }

    public final void onEnd(WindowInsetsAnimationCompat r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        if (this.a.D.remove(r2) == true) goto L5;
        return;
    L5:
        if (this.a.D.isEmpty() == false) goto L9;
        this.a.s6();
        return;
    }

    public final void onPrepare(WindowInsetsAnimationCompat r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        if ((r3.getTypeMask() & WindowInsetsCompat.Type.ime()) == 0) goto L6;
        this.a.D.add(r3);
        return;
    }

    public final WindowInsetsCompat onProgress(WindowInsetsCompat r3, List<WindowInsetsAnimationCompat> r4) {
        Intrinsics.checkNotNullParameter(r3, "insets");
        Intrinsics.checkNotNullParameter(r4, "runningAnimations");
        this.a.H6(r3.getInsets(WindowInsetsCompat.Type.ime()), "imeInsetsAnim");
        return r3;
    }
}
