package com.bytedance.android.live.broadcast.rts;

import com.bytedance.rts.foundation.RTSJSONObject;
import com.bytedance.rts.foundation.RTSSerializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\"\u001a\u00020#2\n\u0010$\u001a\u00060%j\u0002`&H\u0016J\b\u0010'\u001a\u00020#H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\t\"\u0004\b!\u0010\u000b¨\u0006("}, d2 = {"Lcom/bytedance/android/live/broadcast/rts/AnchorStatusTab;", "Lcom/bytedance/rts/foundation/RTSSerializable;", "JSONObject", "Lcom/bytedance/rts/foundation/RTSJSONObject;", "JSONString", "", "(Lcom/bytedance/rts/foundation/RTSJSONObject;Ljava/lang/String;)V", "bizData", "getBizData", "()Ljava/lang/String;", "setBizData", "(Ljava/lang/String;)V", "bizMessage", "getBizMessage", "setBizMessage", "bizSchemaUrl", "getBizSchemaUrl", "setBizSchemaUrl", "key", "getKey", "setKey", "name", "getName", "setName", "schemaType", "", "getSchemaType", "()Ljava/lang/Integer;", "setSchemaType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "schemaUrl", "getSchemaUrl", "setSchemaUrl", "mapping", "", "map", "Lorg/json/JSONObject;", "Lcom/bytedance/rts/foundation/RTSJSONMap;", "unmapping", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnchorStatusTab extends RTSSerializable {
    private String bizData;
    private String bizMessage;
    private String bizSchemaUrl;
    private String key;
    private String name;
    private Integer schemaType;
    private String schemaUrl;

    public void unmapping() {
        super.unmapping();
        String r0 = this.key;
        if (r0 == null) goto L5;
        getEncodeData().put("key", r0);
    L5:
        String r1 = this.name;
        if (r1 == null) goto L8;
        getEncodeData().put("name", r1);
    L8:
        Integer r2 = this.schemaType;
        if (r2 == null) goto L11;
        int r3 = r2.intValue();
        getEncodeData().put("schema_type", Integer.valueOf(r3));
    L11:
        String r4 = this.schemaUrl;
        if (r4 == null) goto L14;
        getEncodeData().put("schema_url", r4);
    L14:
        String r5 = this.bizSchemaUrl;
        if (r5 == null) goto L17;
        getEncodeData().put("biz_schema_url", r5);
    L17:
        String r6 = this.bizData;
        if (r6 == null) goto L20;
        getEncodeData().put("biz_data", r6);
    L20:
        String r7 = this.bizMessage;
        if (r7 == null) goto L24;
        getEncodeData().put("biz_message", r7);
        return;
    }

    public final String getBizData() {
        return this.bizData;
    }

    public final String getBizMessage() {
        return this.bizMessage;
    }

    public final String getBizSchemaUrl() {
        return this.bizSchemaUrl;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getSchemaType() {
        return this.schemaType;
    }

    public final String getSchemaUrl() {
        return this.schemaUrl;
    }

    public void mapping(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "map");
        super.mapping(r3);
        RTSJSONObject.a r0 = RTSJSONObject.Companion;
        String r1 = RTSJSONObject.a.e(r0, r3, "key");
        if (r1 != null) goto L5;
        r1 = this.key;
    L5:
        this.key = r1;
        String r2 = RTSJSONObject.a.e(r0, r3, "name");
        if (r2 != null) goto L8;
        r2 = this.name;
    L8:
        this.name = r2;
        Integer r4 = RTSJSONObject.a.b(r0, r3, "schema_type");
        if (r4 != null) goto L11;
        r4 = this.schemaType;
    L11:
        this.schemaType = r4;
        String r5 = RTSJSONObject.a.e(r0, r3, "schema_url");
        if (r5 != null) goto L14;
        r5 = this.schemaUrl;
    L14:
        this.schemaUrl = r5;
        String r6 = RTSJSONObject.a.e(r0, r3, "biz_schema_url");
        if (r6 != null) goto L17;
        r6 = this.bizSchemaUrl;
    L17:
        this.bizSchemaUrl = r6;
        String r7 = RTSJSONObject.a.e(r0, r3, "biz_data");
        if (r7 != null) goto L20;
        r7 = this.bizData;
    L20:
        this.bizData = r7;
        String r8 = RTSJSONObject.a.e(r0, r3, "biz_message");
        if (r8 != null) goto L23;
        r8 = this.bizMessage;
    L23:
        this.bizMessage = r8;
    }

    public final void setBizData(String r1) {
        this.bizData = r1;
    }

    public final void setBizMessage(String r1) {
        this.bizMessage = r1;
    }

    public final void setBizSchemaUrl(String r1) {
        this.bizSchemaUrl = r1;
    }

    public final void setKey(String r1) {
        this.key = r1;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final void setSchemaType(Integer r1) {
        this.schemaType = r1;
    }

    public final void setSchemaUrl(String r1) {
        this.schemaUrl = r1;
    }

    public AnchorStatusTab(RTSJSONObject r1, String r2) {
        super(r1, r2);
        if (r1 != null) goto L7;
        if (r2 != null) goto L7;
        doInit(false);
        return;
    L7:
        doInit(true);
    }

    public /* synthetic */ AnchorStatusTab(RTSJSONObject r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
