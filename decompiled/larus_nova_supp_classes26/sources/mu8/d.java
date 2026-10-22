package mu8;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public static final Gson a = null;

    static {
        a = new GsonBuilder().excludeFieldsWithModifiers(new int[]{128, 8}).create();
        new GsonBuilder().disableHtmlEscaping().excludeFieldsWithModifiers(new int[]{128, 8}).create();
    }

    public static String a(Object r2) {
        return a.toJson(r2);
    L4:
        th = move-exception;
        nu8.a.b("GsonUtils", "exception : " + th.getMessage());
        return "";
    }
}
