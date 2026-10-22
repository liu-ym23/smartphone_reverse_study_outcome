package km8;

import com.larus.bmhome.chat.standarduikit.memory.view.MemoryView;
import com.larus.im.bean.message.Message;
import jm8.m;
import jm8.n;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i {
    public m a;
    public final a b;
    public b c;
    public km8.a d;
    public final Lazy e;

    public static final class a implements n {
        public final /* synthetic */ i a;

        @Override // jm8.n
        public final boolean a() {
            b r0 = this.a.c;
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.a();
        }

        @Override // jm8.n
        public final void b() {
            i r0 = this.a;
            b r1 = r0.c;
            if (r1 == null) goto L15;
            km8.a r2 = r0.d;
            if (r2 == null) goto L7;
            Message r3 = r2.c;
        L8:
            if (r2 == null) goto L12;
            Integer r4 = r2.e;
            if (r4 == null) goto L12;
            int r5 = r4.intValue();
        L13:
            r1.b(i.a(this.a), r5, r3);
            return;
        L12:
            r5 = 0;
            goto L13
        L7:
            r3 = null;
            goto L8
        }

        @Override // jm8.n
        public final void c() {
            i r0 = this.a;
            b r1 = r0.c;
            if (r1 == null) goto L15;
            km8.a r2 = r0.d;
            if (r2 == null) goto L7;
            Message r3 = r2.c;
        L8:
            if (r2 == null) goto L12;
            Integer r4 = r2.e;
            if (r4 == null) goto L12;
            int r5 = r4.intValue();
        L13:
            r1.d(i.a(this.a), r5, r3);
            return;
        L12:
            r5 = 0;
            goto L13
        L7:
            r3 = null;
            goto L8
        }

        public a(i r1) {
            this.a = r1;
        }

        @Override // jm8.n
        public final void d(MemoryView r3) {
            b r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.c(r3.getContext(), this.a.a.k);
            return;
        }
    }

    public i() {
        this.a = new m(0);
        this.b = new a(this);
        this.e = LazyKt.lazy(new h());
    }

    public static final String a(i r2) {
        km8.a r0 = r2.d;
        if (r0 == null) goto L7;
        ph8.e r1 = r0.d;
        if (r1 == null) goto L7;
        boolean r3 = Intrinsics.areEqual(r1.c(), Boolean.TRUE);
    L8:
        if (r3 == false) goto L10;
        return "updating";
    L10:
        km8.a r4 = r2.d;
        if (r4 == null) goto L16;
        ph8.e r5 = r4.d;
        if (r5 == null) goto L16;
        String r6 = r5.e();
        if (r6 == null) goto L16;
        return r6;
    L16:
        return "";
    L7:
        r3 = false;
        goto L8
    }
}
