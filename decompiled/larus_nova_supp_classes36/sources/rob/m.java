package rob;

import android.view.View;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.VoiceMoreActionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ VoiceMoreActionAdapter a;
    public final /* synthetic */ g b;

    public m(VoiceMoreActionAdapter r1, g r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        d r4 = this.a.b;
        if (r4 == null) goto L6;
        Object r0 = this.b.a();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.AsrLanguageData");
        r4.d((b) r0);
        return;
    }
}
