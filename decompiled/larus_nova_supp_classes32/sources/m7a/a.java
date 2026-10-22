package m7a;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class a extends com.lynx.tasm.event.a {
    @Override // com.lynx.tasm.event.a
    public final String c() {
        return "detail";
    }

    @Override // com.lynx.tasm.event.a
    public final Map<String, Object> b() {
        return this.a;
    }

    public a(int r1, String r2) {
        super(r1, r2);
    }

    public a(int r1, String r2, Map<String, Object> r3) {
        super(r1, r2, r3);
    }
}
