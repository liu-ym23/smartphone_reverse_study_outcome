package u10;

import com.bytedance.android.live.base.model.NameValuePair;
import com.bytedance.android.livesdkapi.model.HttpResponse;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function3;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ e a;
    public final /* synthetic */ Function3 b;
    public final /* synthetic */ long c;

    public g(e r1, Function3 r2, long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r7) {
        HttpResponse r8 = (HttpResponse) r7;
        Function3 r0 = this.b;
        Integer r1 = Integer.valueOf(r8.getStatusCode());
        e r2 = this.a;
        List r3 = r8.getHeaders();
        r2.getClass();
        JSONObject r4 = new JSONObject();
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        NameValuePair r6 = (NameValuePair) r5.next();
        r4.put(r6.getName(), r6.getValue());
        goto L4
    L6:
        r0.invoke(r1, r4, new String(r8.getBody(), Charsets.UTF_8));
        this.a.c.remove(Long.valueOf(this.c));
    }
}
