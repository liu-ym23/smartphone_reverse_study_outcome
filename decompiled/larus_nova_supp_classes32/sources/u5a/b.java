package u5a;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static InputMethodManager h;
    public final View a;
    public final FlutterRenderer b;
    public int c;
    public int d;
    public u5a.a e;
    public com.lynx.clay.embedding.android.a f;
    public boolean g;

    public class a implements InterfaceC0113b {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: u5a.b$b, reason: collision with other inner class name */
    public interface InterfaceC0113b {
    }

    public b(View r2, FlutterRenderer r3) {
        this.c = 0;
        this.d = 0;
        this.g = false;
        this.a = r2;
        this.b = r3;
        if (h != null) goto L5;
        h = (InputMethodManager) r2.getContext().getApplicationContext().getSystemService("input_method");
    L5:
        a r4 = new a(this);
        r3.a.setInputMethodHandler(r4);
    }
}
