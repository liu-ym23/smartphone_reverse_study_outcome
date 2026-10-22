package wa;

/* JADX INFO: loaded from: classes2.dex */
public class a implements pa.a {
    public a() {
    }

    @Override // pa.a
    public /* bridge */ /* synthetic */ String a(Object r10) {
        return b((Thread) r10);
    }

    public String b(Thread r10) {
        StringBuffer r11 = new StringBuffer();
        r11.append("Thread: ");
        r11.append(r10.getName());
        return r11.toString();
    }
}
