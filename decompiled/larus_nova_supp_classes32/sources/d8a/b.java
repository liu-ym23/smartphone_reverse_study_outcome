package d8a;

import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class b {

    public interface a {
        void onFailed(String r1);

        void onSuccess(byte[] r1);
    }

    public b() {
    }

    public abstract void loadTemplate(String r1, a r2);

    public void loadTemplate(String r1, a r2, LynxContext r3) {
        loadTemplate(r1, r2);
    }
}
