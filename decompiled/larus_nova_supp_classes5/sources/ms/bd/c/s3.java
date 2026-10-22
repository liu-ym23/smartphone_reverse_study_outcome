package ms.bd.c;

import java.util.function.Consumer;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class s3 implements Consumer {
    public s3() {
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r4) {
        Integer r5 = (Integer) r4;
        v3.e.put(String.valueOf(r5), System.currentTimeMillis());     // Catch: JSONException -> L5
        return;
    }
}
