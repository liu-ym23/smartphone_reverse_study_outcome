package zh0;

import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        JSONObject r2 = new JSONObject();
        this.a.getClass();
        r2.put("speaking", false);
        this.a.c.c1("radio_sei", r2, 1, false, true);
    }
}
