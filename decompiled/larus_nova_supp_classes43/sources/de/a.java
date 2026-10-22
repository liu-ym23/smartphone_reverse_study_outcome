package de;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class a {

    @SerializedName("animated_common_icon_url")
    public String animatedCommonIconUrl;

    @SerializedName("animated_icon_url")
    public String animatedIconUrl;

    @SerializedName("static_icon_url")
    public String staticIconUrl;

    public a() {
    }

    public static a parseFromMap(Map<String, Serializable> r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        a r0 = new a();
        Serializable r1 = r10.get("static_icon_url");
        if ((r1 instanceof String) == false) goto L8;
        r0.staticIconUrl = (String) r1;
    L8:
        Serializable r11 = r10.get("animated_icon_url");
        if ((r11 instanceof String) == false) goto L11;
        r0.animatedIconUrl = (String) r11;
    L11:
        Serializable r12 = r10.get("animated_common_icon_url");
        if ((r12 instanceof String) == false) goto L14;
        r0.animatedCommonIconUrl = (String) r12;
    L14:
        return r0;
    }
}
