package eu8;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g implements d {
    public final d a;

    @Override // eu8.d
    public final Object execute() {
        if (this.a == null) goto L14;
        JSONObject r0 = new JSONObject();
        nu8.a.d(String.format("Exe cmd %s", new Object[]{this.a.toString()}));
        Object r2 = this.a.execute();
        r0.put("cmd", this.a.toString());     // Catch: JSONException -> L7
        r0.put("result", r2.toString());     // Catch: JSONException -> L7
    L9:
        nu8.a.d(String.format("Exe cmd %s result %s", new Object[]{this.a.toString(), r2.toString()}));
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L14:
        return null;
    }

    public g(a r1) {
        this.a = r1;
    }
}
