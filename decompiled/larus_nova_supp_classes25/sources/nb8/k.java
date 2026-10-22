package nb8;

import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;
import com.larus.im.bean.message.Message;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k implements hb8.a {
    public m a;
    public Message b;
    public String c;
    public nb8.a d;
    public boolean e;
    public final Lazy f;

    public static final class a implements l {
        public final /* synthetic */ k a;

        @Override // nb8.l
        public final void onRefresh() {
            nb8.a r0 = this.a.d;
            if (r0 == null) goto L6;
            r0.onRefresh();
            return;
        }

        public a(k r1) {
            this.a = r1;
        }

        @Override // nb8.l
        public final void a(ow8.a r50) {
            Intrinsics.checkNotNullParameter(r50, "view");
            k r2 = this.a;
            nb8.a r3 = r2.d;
            if (r3 == null) goto L11;
            m r4 = r2.a;
            if (r4 == null) goto L8;
            Message r5 = r4.b;
            if (r5 == null) goto L8;
        L9:
            r3.a(r5, r50);
            return;
        L8:
            r5 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
            goto L9
        }

        @Override // nb8.l
        public final void b(ow8.a r49, st8.a r50) {
            k r1 = this.a;
            nb8.a r2 = r1.d;
            if (r2 == null) goto L11;
            m r3 = r1.a;
            if (r3 == null) goto L8;
            Message r4 = r3.b;
            if (r4 == null) goto L8;
        L9:
            r2.b(r4, r49, r50, LongClickSource.Thinking);
            return;
        L8:
            r4 = new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1, 31, null);
            goto L9
        }
    }

    @Override // hb8.a
    public final void f() {
        this.e = false;
    }

    public k() {
        this.f = LazyKt.lazy(new j(this));
    }
}
