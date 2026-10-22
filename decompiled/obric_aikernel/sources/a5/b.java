package a5;

/* JADX INFO: loaded from: classes.dex */
public class b extends o2.b<d> {
    public boolean S;
    public int T;

    class a implements o2.b.InterfaceC0254b {
        a() {
        }

        @Override // o2.b.InterfaceC0254b
        public o2.b create() {
            return new b();
        }
    }

    public b() {
        this.S = false;
        this.T = -1;
    }

    public static void d() {
        o2.b.c(new a());
    }
}
