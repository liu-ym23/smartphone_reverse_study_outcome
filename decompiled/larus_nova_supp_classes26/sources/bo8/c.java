package bo8;

import android.content.Context;
import com.larus.bmhome.chat.standarduikit.vlm.view.VLMContainerView;
import do8.k;
import do8.w;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import th8.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final Context a;
    public final f.b b;
    public final Lazy c;
    public final Lazy d;
    public com.larus.bmhome.chat.standarduikit.vlm.view.a e;

    public final VLMContainerView b() {
        return (VLMContainerView) this.c.getValue();
    }

    public final Context getContext() {
        return this.a;
    }

    public c(Context r2, f.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "sizeConfig");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(new a(this));
        this.d = LazyKt.lazy(new b(this));
    }

    public final void a(k r2, do8.a r3) {
        Intrinsics.checkNotNullParameter(r2, "vmData");
        ((w) this.d.getValue()).a(r2, r3);
        com.larus.bmhome.chat.standarduikit.vlm.view.a r4 = ((w) this.d.getValue()).g();
        this.e = r4;
        w.b r5 = (w.b) ((w) this.d.getValue()).j.getValue();
        b().v(r4, r5);
    }
}
