package p99;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import q99.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class d extends c {

    public static final class a extends d {
        public final i b;

        @Override // p99.d
        public final void f(q99.e r2) {
            Intrinsics.checkNotNullParameter(r2, "delivery");
        }

        @Override // p99.d
        public final void g(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
        }

        @Override // p99.d
        public final void h() {
        }

        @Override // p99.d
        public final void i(boolean r1) {
        }

        @Override // p99.d
        public final void j(String r2) {
            Intrinsics.checkNotNullParameter(r2, "newSectionId");
        }

        @Override // p99.d
        public final void k(String r1) {
        }

        @Override // p99.d
        public final i e() {
            return this.b;
        }

        public a(i r2) {
            Intrinsics.checkNotNullParameter(r2, "host");
            super(new n99.a.C0132a());
            this.b = r2;
        }
    }

    public abstract i e();

    public abstract void f(q99.e r1);

    public abstract void g(Message r1);

    public abstract void h();

    public abstract void i(boolean r1);

    public abstract void j(String r1);

    public abstract void k(String r1);

    public d(n99.a r2) {
        Intrinsics.checkNotNullParameter(r2, "remoteGateway");
        super(r2);
    }
}
