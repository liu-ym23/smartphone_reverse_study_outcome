package o5a;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e extends o5a.a {

    public class a implements TextView.OnEditorActionListener {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r5, int r6, KeyEvent r7) {
            if (r6 == 6) goto L15;
            if (r6 == 2) goto L15;
            if (r6 == 3) goto L15;
            if (r6 == 4) goto L15;
            if (r6 == 5) goto L15;
            if (r6 == 0) goto L15;
            return false;
        L15:
            if (this.a.c("confirm") == false) goto L17;
            HashMap r8 = new HashMap();
            r8.put("value", this.a.h.getText().toString());
            this.a.q("confirm", r8);
        L17:
            if (r6 == 5) goto L20;
            this.a.w(false);
            return true;
        L20:
            return false;
        }
    }

    public class b implements d.a {
        public final /* synthetic */ e a;

        @Override // o5a.d.a
        public final void a() {
            this.a.e();
        }

        public b(e r1) {
            this.a = r1;
        }
    }

    @Override // o5a.a, com.lynx.clay.embedding.engine.plugins.platformview.a
    public final View a(Context r2) {
        super.a(r2);
        this.h.setOnEditorActionListener(new a(this));
        this.h.setOnAfterDrawListener(new b(this));
        this.h.setOnTouchListener(null);
        this.h.setImeOptions(6);
        this.h.setLines(1);
        this.h.setSingleLine(true);
        this.h.setHorizontallyScrolling(true);
        return this.h;
    }

    public e(Context r1, int r2, String r3) {
        super(r1, r2, r3);
    }
}
