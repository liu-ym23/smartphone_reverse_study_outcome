package s2b;

import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.chat.base.model.MessageContentFoldingControlParams;
import com.ss.android.lark.widget.EllipsizeFrameLayout;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public String a;
    public final Map<String, b> b;
    public a c;
    public final Map<String, Integer> d;

    public interface a {
        void a(String r1);
    }

    public class b {
        public boolean a;
        public boolean b;
        public EllipsizeFrameLayout.a c;
        public boolean d;
        public String e;
        public Boolean f;

        public b() {
            this.a = true;
            this.b = true;
            MessageContentFoldingControlParams r0 = (MessageContentFoldingControlParams) SettingManager.getInstance().get(MessageContentFoldingControlParams.class);
            this.c = new EllipsizeFrameLayout.a(r0.b(), r0.a());
        }
    }

    public e() {
        this.d = new HashMap();
        this.b = new HashMap();
    }

    public final EllipsizeFrameLayout.a a(String r3) {
        b r4 = (b) ((HashMap) this.b).get(r3);
        if (r4 != null) goto L5;
        MessageContentFoldingControlParams r5 = (MessageContentFoldingControlParams) SettingManager.getInstance().get(MessageContentFoldingControlParams.class);
        return new EllipsizeFrameLayout.a(r5.d(), r5.c());
    L5:
        return r4.c;
    }

    public final void b(String r3) {
        if (((HashMap) this.b).containsKey(r3) == true) goto L6;
        Map<String, b> r0 = this.b;
        HashMap r1 = (HashMap) r0;
        r1.put(r3, new b());
        return;
    }

    public final boolean c(String r2) {
        b r3 = (b) ((HashMap) this.b).get(r2);
        if (r3 != null) goto L5;
        return true;
    L5:
        return r3.a;
    }

    public final void d(String r2) {
        a r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public final void e(String r3) {
        b r0 = (b) ((HashMap) this.b).get(r3);
        if (r0 != null) goto L6;
        r0 = new b();
        ((HashMap) this.b).put(r3, r0);
    L6:
        if (r0.a == false) goto L9;
        r0.a = false;
        d(r3);
        return;
    }

    public final void i(String r3) {
        String r0 = this.a;
        if (r0 != null) goto L6;
        this.a = r3;
        d(r3);
        return;
    L6:
        if (r3.equals(r0) == false) goto L8;
        this.a = null;
        d(r3);
        return;
    L8:
        this.a = r3;
        d(r3);
        d(r0);
    }

    public final void g(String r3, boolean r4) {
        b r0 = (b) ((HashMap) this.b).get(r3);
        if (r0 != null) goto L5;
        r0 = new b();
        ((HashMap) this.b).put(r3, r0);
    L5:
        Boolean r1 = r0.f;
        if (r1 != null) goto L8;
    L9:
        r0.f = Boolean.valueOf(r4);
        d(r3);
        return;
    L8:
        if (r1.booleanValue() != r4) goto L9;
    }

    public final void h(String r3, boolean r4) {
        b r0 = (b) ((HashMap) this.b).get(r3);
        if (r0 != null) goto L6;
        r0 = new b();
        ((HashMap) this.b).put(r3, r0);
    L6:
        if (r0.b == r4) goto L9;
        r0.b = r4;
        d(r3);
        return;
    }

    public final void f(String r3, String r4, boolean r5) {
        b r0 = (b) ((HashMap) this.b).get(r3);
        if (r0 != null) goto L6;
        r0 = new b();
        ((HashMap) this.b).put(r3, r0);
    L6:
        if (r0.d == r5) goto L9;
        r0.d = r5;
        r0.e = r4;
        d(r3);
        return;
    }
}
