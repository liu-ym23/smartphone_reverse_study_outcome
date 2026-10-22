package com.bytedance.android.live.broadcast.rts;

import com.bytedance.rts.foundation.RTSJSONObject;
import com.bytedance.rts.foundation.RTSSerializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010)\u001a\u00020*2\n\u0010+\u001a\u00060,j\u0002`-H\u0016J\b\u0010.\u001a\u00020*H\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R:\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001dj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u0018R\u001c\u0010&\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018¨\u0006/"}, d2 = {"Lcom/bytedance/android/live/broadcast/rts/AnchorStatusRealtimeSuggest;", "Lcom/bytedance/rts/foundation/RTSSerializable;", "JSONObject", "Lcom/bytedance/rts/foundation/RTSJSONObject;", "JSONString", "", "(Lcom/bytedance/rts/foundation/RTSJSONObject;Ljava/lang/String;)V", "duration", "", "getDuration", "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "icon", "Lcom/bytedance/android/live/broadcast/rts/AnchorStatusImageModel;", "getIcon", "()Lcom/bytedance/android/live/broadcast/rts/AnchorStatusImageModel;", "setIcon", "(Lcom/bytedance/android/live/broadcast/rts/AnchorStatusImageModel;)V", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "panelIcon", "getPanelIcon", "setPanelIcon", "params", "", "Lcom/bytedance/rts/foundation/RTSMap;", "getParams", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "schemaUrl", "getSchemaUrl", "setSchemaUrl", "text", "getText", "setText", "mapping", "", "map", "Lorg/json/JSONObject;", "Lcom/bytedance/rts/foundation/RTSJSONMap;", "unmapping", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnchorStatusRealtimeSuggest extends RTSSerializable {
    private Long duration;
    private AnchorStatusImageModel icon;
    private String id;
    private AnchorStatusImageModel panelIcon;
    private Map<String, String> params;
    private String schemaUrl;
    private String text;

    public void unmapping() {
        super.unmapping();
        String r0 = this.id;
        if (r0 == null) goto L5;
        getEncodeData().put("id", r0);
    L5:
        String r1 = this.text;
        if (r1 == null) goto L8;
        getEncodeData().put("text", r1);
    L8:
        String r2 = this.schemaUrl;
        if (r2 == null) goto L11;
        getEncodeData().put("schema_url", r2);
    L11:
        Long r3 = this.duration;
        if (r3 == null) goto L14;
        long r4 = r3.longValue();
        getEncodeData().put("duration", Long.valueOf(r4));
    L14:
        AnchorStatusImageModel r5 = this.icon;
        if (r5 == null) goto L17;
        getEncodeData().put("icon", r5);
    L17:
        AnchorStatusImageModel r6 = this.panelIcon;
        if (r6 == null) goto L20;
        getEncodeData().put("panel_icon", r6);
    L20:
        Map<String, String> r7 = this.params;
        if (r7 == null) goto L24;
        getEncodeData().put("params", r7);
        return;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final AnchorStatusImageModel getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.id;
    }

    public final AnchorStatusImageModel getPanelIcon() {
        return this.panelIcon;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final String getSchemaUrl() {
        return this.schemaUrl;
    }

    public final String getText() {
        return this.text;
    }

    public void mapping(JSONObject r6) {
        Intrinsics.checkNotNullParameter(r6, "map");
        super.mapping(r6);
        RTSJSONObject.a r1 = RTSJSONObject.Companion;
        String r2 = RTSJSONObject.a.e(r1, r6, "id");
        if (r2 != null) goto L5;
        r2 = this.id;
    L5:
        this.id = r2;
        String r3 = RTSJSONObject.a.e(r1, r6, "text");
        if (r3 != null) goto L8;
        r3 = this.text;
    L8:
        this.text = r3;
        String r4 = RTSJSONObject.a.e(r1, r6, "schema_url");
        if (r4 != null) goto L11;
        r4 = this.schemaUrl;
    L11:
        this.schemaUrl = r4;
        Intrinsics.checkNotNullParameter(r6, "map");
        Intrinsics.checkNotNullParameter("duration", "key");
        Object r0 = null;
        Long r5 = RTSJSONObject.a.d(r6, "duration", null);
        if (r5 != null) goto L14;
        r5 = this.duration;
    L14:
        this.duration = r5;
        if (r6.has("icon") == false) goto L17;
        AnchorStatusImageModel r7 = new AnchorStatusImageModel(new RTSJSONObject(r6.optJSONObject("icon")), null, 2, null);
    L18:
        this.icon = r7;
        if (r6.has("panel_icon") == false) goto L21;
        AnchorStatusImageModel r8 = new AnchorStatusImageModel(new RTSJSONObject(r6.optJSONObject("panel_icon")), null, 2, null);
    L22:
        this.panelIcon = r8;
        Object r9 = optMapList(1, r6.opt("params"), AnonymousClass1.INSTANCE);
        if (TypeIntrinsics.isMutableMap(r9) == false) goto L26;
        r0 = r9;
    L26:
        Map<String, String> r11 = (Map) r0;
        if (r11 != null) goto L29;
        r11 = this.params;
    L29:
        this.params = r11;
        return;
    L21:
        r8 = this.panelIcon;
        goto L22
    L17:
        r7 = this.icon;
        goto L18
    }

    public final void setDuration(Long r1) {
        this.duration = r1;
    }

    public final void setIcon(AnchorStatusImageModel r1) {
        this.icon = r1;
    }

    public final void setId(String r1) {
        this.id = r1;
    }

    public final void setPanelIcon(AnchorStatusImageModel r1) {
        this.panelIcon = r1;
    }

    public final void setParams(Map<String, String> r1) {
        this.params = r1;
    }

    public final void setSchemaUrl(String r1) {
        this.schemaUrl = r1;
    }

    public final void setText(String r1) {
        this.text = r1;
    }

    public AnchorStatusRealtimeSuggest(RTSJSONObject r1, String r2) {
        super(r1, r2);
        if (r1 != null) goto L7;
        if (r2 != null) goto L7;
        doInit(false);
        return;
    L7:
        doInit(true);
    }

    public /* synthetic */ AnchorStatusRealtimeSuggest(RTSJSONObject r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
