package u32;

import com.bytedance.android.livesdk.interactivity.like.DiggWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class m extends b {
    public final a a;

    public interface a {
        DiggWidget.o.a a();
    }

    public m(DiggWidget.o r2) {
        Intrinsics.checkNotNullParameter(r2, "initializer");
        this.a = r2;
    }
}
