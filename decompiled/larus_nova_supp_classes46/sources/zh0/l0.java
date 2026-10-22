package zh0;

import com.bytedance.android.live.liveinteract.radio.impl.RadioWidget;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l0 implements Consumer<Long> {
    public final /* synthetic */ RadioWidget a;

    public l0(RadioWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) throws Exception {
        Long r6 = (Long) r5;
        RadioWidget r7 = this.a;
        if (r7.V == r7.W) goto L10;
        JsonObject r8 = new JsonObject();
        r8.addProperty("type", "speaking");
        JsonObject r0 = new JsonObject();
        r0.addProperty("is_speaking", Boolean.valueOf(this.a.W));
        r8.add("data", r0);
        ih0.b r1 = this.a.g;
        if (r1 == null) goto L8;
        r1.Dk("radio", "radio_event", r8, false);
    L8:
        RadioWidget r9 = this.a;
        r9.V = r9.W;
        return;
    }
}
