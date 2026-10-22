package com.larus.asr;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.component.cvs.y;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class p1 implements y.a<wc9.e> {
    public final /* synthetic */ ChatBottomSpeakerComponent a;

    public p1(ChatBottomSpeakerComponent r1) {
        this.a = r1;
    }

    public final void c(Object r9) {
        wc9.e r10 = (wc9.e) r9;
        Intrinsics.checkNotNullParameter(r10, "new");
        ChatBottomSpeakerComponent r0 = this.a;
        Set r1 = ChatBottomSpeakerComponent.F2;
        r0.getClass();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new ChatBottomSpeakerComponent$updateBotId$1(r0, r10, null), 3, null);
        ChatBottomSpeakerComponent.G3(this.a, r10);
    }
}
