package z8a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public String a;
    public String b;
    public String c;
    public JSONObject d;

    public a() {
    }

    public final String toString() {
        return "CloudMessage{mParams='" + this.a + "', mType=" + this.b + ", send_time=0, command_id='" + this.c + "'}";
    }

    public String getType() {
        return this.b;
    }
}
