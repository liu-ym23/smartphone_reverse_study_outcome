package p8a;

import android.graphics.Typeface;
import com.lynx.xelement.markdown.LynxUIMarkdownShadowNode;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t implements com.lynx.markdown.e {
    public final s a;
    public final HashMap<String, q> b;
    public final HashMap<String, r> c;
    public boolean d;
    public boolean e;

    public static class a implements com.lynx.tasm.behavior.shadow.text.g.c {
        public final WeakReference<t> a;
        public final String b;
        public final int c;
        public final int d;

        @Override // com.lynx.tasm.behavior.shadow.text.g.c
        public final void a(Typeface r4, int r5) {
            t r6 = this.a.get();
            if (r6 == null) goto L14;
            s r7 = r6.a;
            if (r7 == null) goto L16;
            String r8 = this.b;
            int r0 = this.c;
            int r1 = this.d;
            LynxUIMarkdownShadowNode r9 = (LynxUIMarkdownShadowNode) r7;
            if (r9.o == true) goto L17;
            d r10 = r9.D();
            if (r10 == null) goto L15;
            r10.onFontLoaded(r8, r0, r1);
            return;
        L15:
            return;
        L17:
            return;
        L16:
            return;
        }

        public a(t r2, String r3, int r4, int r5) {
            this.a = new WeakReference(r2);
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public t(s r2) {
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = false;
        this.e = false;
        this.a = r2;
    }
}
