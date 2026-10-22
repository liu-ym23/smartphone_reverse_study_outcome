package a4a;

import androidx.appcompat.app.AppCompatActivity;
import com.larus.voicecall.impl.ui.RealtimeCallActivity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class c {
    public final AppCompatActivity a;
    public final Lazy b;
    public final Lazy c;

    public abstract void a();

    public final AppCompatActivity getActivity() {
        return this.a;
    }

    public c(RealtimeCallActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
        this.b = LazyKt.lazy(new a(this));
        this.c = LazyKt.lazy(new b());
    }
}
