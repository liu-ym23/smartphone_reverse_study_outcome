package z6a;

import android.text.Spanned;
import android.util.LruCache;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class v {
    public final LruCache<com.lynx.tasm.behavior.shadow.text.f, com.lynx.tasm.behavior.shadow.text.e> a;

    public static class a {
        public static final v a = null;

        static {
            a = new v();
        }
    }

    public v() {
        this.a = new LruCache(500);
    }

    public final com.lynx.tasm.behavior.shadow.text.e a(LynxContext r6, com.lynx.tasm.behavior.shadow.text.f r7) {
        if (r6.isTextLayoutCacheEnabled() == false) goto L5;
        com.lynx.tasm.behavior.shadow.text.e r0 = this.a.get(r7);
        if (r0 == null) goto L9;
        return r0;
    L9:
        com.lynx.tasm.behavior.shadow.text.e r1 = new com.lynx.tasm.behavior.shadow.text.e(r6, r7);
        com.lynx.tasm.behavior.shadow.text.a r8 = r7.a.b;
        boolean r2 = false;
        if (r8.q == false) goto L12;
    L22:
        if (r2 == false) goto L24;
        this.a.put(r7, r1);
    L24:
        return r1;
    L12:
        if (r8.r == true) goto L22;
        Spanned r9 = (Spanned) r1.a.getText();
        h[] r3 = (h[]) r9.getSpans(0, r9.length(), h.class);
        l[] r10 = (l[]) r9.getSpans(0, r9.length(), l.class);
        if (r3 != null) goto L17;
    L18:
        if (r10 != null) goto L20;
    L21:
        r2 = true;
        goto L22
    L20:
        if (r10.length != 0) goto L22;
    L17:
        if (r3.length != 0) goto L22;
    L5:
        return new com.lynx.tasm.behavior.shadow.text.e(r6, r7);
    }
}
