package androidx.work;

/* JADX INFO: loaded from: classes.dex */
public final class o extends w {

    public static final class a extends w.a<a, o> {
        public a(Class<? extends l> r8) {
            super(r8);
            r1.t r10 = this.f2964b;
            r10.f11342d = OverwritingInputMerger.class.getName();
        }

        @Override // androidx.work.w.a
        public final w b() {
            return new o(this);
        }

        @Override // androidx.work.w.a
        public final w.a c() {
            return this;
        }
    }

    public o(a r8) {
        he.i.f(r8, "builder");
        super(r8.f2963a, r8.f2964b, r8.f2965c);
    }
}
