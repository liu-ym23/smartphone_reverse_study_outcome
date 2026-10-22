package de;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class b {

    @SerializedName("allow_show_cart")
    public boolean allowShowCart;

    public b() {
    }

    public static b parseFromMap(Map<String, Serializable> r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        b r0 = new b();
        Serializable r11 = r10.get("allow_show_cart");
        if ((r11 instanceof Boolean) == false) goto L8;
        r0.allowShowCart = ((Boolean) r11).booleanValue();
    L8:
        return r0;
    }
}
