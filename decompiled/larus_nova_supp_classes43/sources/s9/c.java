package s9;

import com.bytedance.android.annie.Annie;
import io.reactivex.functions.Action;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements Action {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public c(String r1, String r10, String r11, String r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }

    public final void run() {
        int r0 = x8.a.a;
        x8.a.d(Annie.ANNIE_TAG, "定时清理:" + this.a, false);
        ConcurrentHashMap<Integer, f> r1 = a.a;
        a.f(this.b, this.c, true);
        j9.b r10 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        String r11 = this.d;
        JSONObject r12 = new JSONObject();
        String r13 = this.c;
        String r14 = this.b;
        String r15 = this.d;
        r12.put("biz", r13);
        r12.put("cache_key", r14);
        r12.put(com.bytedance.android.ec.core.event.a.KEY_URL, r15);
        r12.put("type", 1);
        r12.put(com.bytedance.android.ec.core.event.a.KEY_MSG, "timeout clean");
        Unit r16 = Unit.INSTANCE;
        j9.b.a.a(r10, null, "annie_container_prerender_clear", r11, r12, null, null, null, 1, 320);
    }
}
