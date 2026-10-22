package mb8;

import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import lb8.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public mb8.a a;
    public lb8.a b;
    public final Lazy c;

    public static final class a implements h {
        public final /* synthetic */ c a;

        @Override // lb8.h
        public final void b() {
            lb8.a r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.b();
            return;
        }

        public a(c r1) {
            this.a = r1;
        }

        @Override // lb8.h
        public final void a(ow8.a r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            lb8.a r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.a(r2);
            return;
        }

        @Override // lb8.h
        public final void c(ow8.a r3, st8.a r4) {
            lb8.a r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.c(r3, r4, LongClickSource.Thinking);
            return;
        }
    }

    public c() {
        this.c = LazyKt.lazy(new b(this));
    }
}
