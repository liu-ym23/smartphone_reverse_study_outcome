package com.bytedance.android.livesdk.interactivity.comment.share.model;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class b {

    @SerializedName("extra")
    public String extra;

    @SerializedName("item_id")
    public String itemId;

    @SerializedName("item_type")
    public String itemType;

    @SerializedName("room_id")
    public long roomId;

    @SerializedName("schema")
    public String schema;

    public b() {
    }

    public final Map<String, String> a() {
        HashMap r0 = new HashMap();
        r0.put("room_id", String.valueOf(this.roomId));
        r0.put("item_type", this.itemType);
        r0.put("item_id", this.itemId);
        if (TextUtils.isEmpty(this.extra) == true) goto L6;
        r0.put("extra", this.extra);
    L6:
        if (TextUtils.isEmpty(this.schema) == true) goto L8;
        r0.put("schema", this.schema);
    L8:
        return r0;
    }
}
