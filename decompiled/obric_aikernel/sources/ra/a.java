package ra;

import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class a implements pa.a<String> {
    public a() {
        this("MM-dd HH:mm:ss");
    }

    public a(String r10) {
        new Date();
    }

    @Override // pa.a
    public /* bridge */ /* synthetic */ String a(String r10) {
        return b(r10);
    }

    public String b(String r10) {
        return r10;
    }
}
