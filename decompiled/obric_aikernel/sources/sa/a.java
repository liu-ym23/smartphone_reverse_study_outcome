package sa;

import com.ss.android.agilelogger.formatter.FormatException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements pa.a {
    public a() {
    }

    @Override // pa.a
    public /* bridge */ /* synthetic */ String a(Object r10) {
        return b((String) r10);
    }

    public String b(String r10) {
        if (r10 == null) goto L18;
        if (r10.trim().length() == 0) goto L18;
    L14:
        e = move-exception;
        throw new FormatException("Parse JSON error. JSON string:" + r10, e);
    L6:
        if (r10.startsWith("{") == false) goto L9;
        return new JSONObject(r10).toString(4);
    L9:
        if (r10.startsWith("[") == false) goto L13;
        return new JSONArray(r10).toString(4);
    L13:
        throw new FormatException("JSON should start with { or [, but found " + r10);     // Catch: Exception -> L14
    L18:
        throw new FormatException("JSON empty.");
    }
}
