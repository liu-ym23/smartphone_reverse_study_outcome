package xjb;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a {

    @SerializedName("areaKey")
    private String areaKey;

    @SerializedName("priority")
    private long priority;

    public a() {
        this("", 0);
    }

    public final String toString() {
        return "AreaInfo{areaKey='" + this.areaKey + "', priority=" + this.priority + '}';
    }

    public final String a() {
        return this.areaKey;
    }

    public a(String r1, long r2) {
        this.areaKey = r1;
        this.priority = r2;
    }
}
