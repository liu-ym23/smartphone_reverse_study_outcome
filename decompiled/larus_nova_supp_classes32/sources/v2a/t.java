package v2a;

import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.voice_setting.voice.mix.VoiceMixBar;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class t implements Function1 {
    public final /* synthetic */ VoiceMixBar a;
    public final /* synthetic */ Function0 b;

    public /* synthetic */ t(VoiceMixBar r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        VoiceMixBar r0 = this.a;
        Function0 r1 = this.b;
        int r2 = VoiceMixBar.h;
        Intrinsics.checkNotNullParameter((AppCompatImageView) r4, "it");
        AppBarLayout r5 = r0.d;
        if (r5 == null) goto L5;
        r5.setExpanded(true);
    L5:
        r1.invoke();
        return Unit.INSTANCE;
    }
}
