package ig8;

import com.larus.bmhome.chat.layout.item.i;
import com.larus.im.bean.message.Message;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f extends bd8.b {
    public final Lazy l;
    public final wg8.f m;
    public final e n;

    public f() {
        super(false, -1);
        this.l = LazyKt.lazy(new c(this));
        this.m = new wg8.f();
        this.n = new e(this);
    }

    @Override // bd8.b
    public final void w(final Message r2, int r3, final ec8.b r4) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r2, "message");
        wg8.f r5 = this.m;
        r5.a = this.f;
        i r6 = this.d;
        if (r6 == null) goto L6;
        r6.setOnLongClickListener(new d(this, r4, r2));
        return;
    }
}
