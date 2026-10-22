package ai;

import io.reactivex.subjects.MaybeSubject;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final ConcurrentHashMap<String, MaybeSubject<JSONObject>> a;

    public a() {
        this.a = new ConcurrentHashMap();
    }
}
