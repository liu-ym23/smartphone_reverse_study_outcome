package o3a;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.voicecall.impl.component.translator.QuicInterpretComponent;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class h implements Function0 {
    public final /* synthetic */ QuicInterpretComponent a;

    public /* synthetic */ h(QuicInterpretComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        return LifecycleOwnerKt.getLifecycleScope(s1a.a.c(this.a));
    }
}
