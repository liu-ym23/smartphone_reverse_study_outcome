package t8a;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.xelement.webview.LynxUIWebView;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements u8a.c {
    public a a;
    public final ConcurrentHashMap<String, u8a.b> b;

    public c() {
        this.b = new ConcurrentHashMap();
    }

    @Override // u8a.c
    public final u8a.b a(String r2, LynxContext r3) {
        if (LynxUIWebView.DEFAULT.equals(r2) == false) goto L10;
        if (this.a != null) goto L8;
        this.a = new a(r3);
    L8:
        return this.a;
    L10:
        return this.b.get(r2);
    }
}
