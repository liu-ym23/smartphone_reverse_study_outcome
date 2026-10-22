package com.bytedance.android.live.broadcast.rts;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.rts.foundation.RTSJSONObject;
import com.bytedance.rts.foundation.RTSSerializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\n\u00102\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u00103\u001a\u0002042\n\u00105\u001a\u000606j\u0002`7H\u0016J\b\u00108\u001a\u000204H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010\u000bR\u001c\u0010%\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\t\"\u0004\b'\u0010\u000bR.\u0010(\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010)j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017¨\u00069"}, d2 = {"Lcom/bytedance/android/live/broadcast/rts/AnchorStatusImageModel;", "Lcom/bytedance/rts/foundation/RTSSerializable;", "JSONObject", "Lcom/bytedance/rts/foundation/RTSJSONObject;", "JSONString", "", "(Lcom/bytedance/rts/foundation/RTSJSONObject;Ljava/lang/String;)V", "avgColor", "getAvgColor", "()Ljava/lang/String;", "setAvgColor", "(Ljava/lang/String;)V", "content", "Lcom/bytedance/android/live/broadcast/rts/AnchorStatusContent;", "getContent", "()Lcom/bytedance/android/live/broadcast/rts/AnchorStatusContent;", "setContent", "(Lcom/bytedance/android/live/broadcast/rts/AnchorStatusContent;)V", "height", "", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "imageType", "getImageType", "setImageType", "isAnimated", "", "()Ljava/lang/Boolean;", "setAnimated", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "schema", "getSchema", "setSchema", "uri", "getUri", "setUri", "urlList", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/foundation/RTSArray;", "getUrlList", "()Ljava/util/ArrayList;", "setUrlList", "(Ljava/util/ArrayList;)V", "width", "getWidth", "setWidth", "getFirstUrl", "mapping", "", "map", "Lorg/json/JSONObject;", "Lcom/bytedance/rts/foundation/RTSJSONMap;", "unmapping", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnchorStatusImageModel extends RTSSerializable {
    private String avgColor;
    private AnchorStatusContent content;
    private Integer height;
    private Integer imageType;
    private Boolean isAnimated;
    private String schema;
    private String uri;
    private ArrayList<String> urlList;
    private Integer width;

    public String getFirstUrl() {
        ArrayList<String> r0 = this.urlList;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        if (com.bytedance.rts.foundation.j.d(r0) <= 0) goto L10;
        ArrayList<String> r1 = this.urlList;
        Intrinsics.checkNotNull(r1);
        return (String) ListProtector.get(r1, 0);
    L10:
        return null;
    L8:
        return null;
    }

    public void unmapping() {
        super.unmapping();
        String r0 = this.avgColor;
        if (r0 == null) goto L5;
        getEncodeData().put("avg_color", r0);
    L5:
        String r1 = this.uri;
        if (r1 == null) goto L8;
        getEncodeData().put("uri", r1);
    L8:
        ArrayList<String> r2 = this.urlList;
        if (r2 == null) goto L11;
        getEncodeData().put("url_list", r2);
    L11:
        String r3 = this.schema;
        if (r3 == null) goto L14;
        getEncodeData().put("open_web_url", r3);
    L14:
        Integer r4 = this.imageType;
        if (r4 == null) goto L17;
        int r5 = r4.intValue();
        getEncodeData().put("image_type", Integer.valueOf(r5));
    L17:
        AnchorStatusContent r6 = this.content;
        if (r6 == null) goto L20;
        getEncodeData().put("content", r6);
    L20:
        Boolean r7 = this.isAnimated;
        if (r7 == null) goto L23;
        boolean r8 = r7.booleanValue();
        getEncodeData().put("is_animated", Boolean.valueOf(r8));
    L23:
        Integer r9 = this.width;
        if (r9 == null) goto L26;
        int r11 = r9.intValue();
        getEncodeData().put("width", Integer.valueOf(r11));
    L26:
        Integer r12 = this.height;
        if (r12 == null) goto L30;
        int r13 = r12.intValue();
        getEncodeData().put("height", Integer.valueOf(r13));
        return;
    }

    public final String getAvgColor() {
        return this.avgColor;
    }

    public final AnchorStatusContent getContent() {
        return this.content;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getImageType() {
        return this.imageType;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final String getUri() {
        return this.uri;
    }

    public final ArrayList<String> getUrlList() {
        return this.urlList;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final Boolean isAnimated() {
        return this.isAnimated;
    }

    public void mapping(JSONObject r7) {
        Intrinsics.checkNotNullParameter(r7, "map");
        super.mapping(r7);
        RTSJSONObject.a r1 = RTSJSONObject.Companion;
        String r2 = RTSJSONObject.a.e(r1, r7, "avg_color");
        if (r2 != null) goto L5;
        r2 = this.avgColor;
    L5:
        this.avgColor = r2;
        String r3 = RTSJSONObject.a.e(r1, r7, "uri");
        if (r3 != null) goto L8;
        r3 = this.uri;
    L8:
        this.uri = r3;
        Object r4 = optMapList(1, r7.opt("url_list"), AnonymousClass1.INSTANCE);
        Boolean r5 = null;
        if ((r4 instanceof ArrayList) == true) goto L11;
        r4 = null;
    L11:
        ArrayList<String> r6 = (ArrayList) r4;
        if (r6 != null) goto L14;
        r6 = this.urlList;
    L14:
        this.urlList = r6;
        String r8 = RTSJSONObject.a.e(r1, r7, "open_web_url");
        if (r8 != null) goto L17;
        r8 = this.schema;
    L17:
        this.schema = r8;
        Integer r9 = RTSJSONObject.a.b(r1, r7, "image_type");
        if (r9 != null) goto L20;
        r9 = this.imageType;
    L20:
        this.imageType = r9;
        if (r7.has("content") == false) goto L23;
        AnchorStatusContent r11 = new AnchorStatusContent(new RTSJSONObject(r7.optJSONObject("content")), null, 2, null);
    L24:
        this.content = r11;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter("is_animated", "key");
        Object r0 = RTSJSONObject.a.a(r7, "is_animated");
        if ((r0 instanceof Boolean) == false) goto L27;
        Boolean r12 = (Boolean) r0;
    L28:
        if (r12 == null) goto L31;
        r5 = r12;
    L31:
        if (r5 != null) goto L33;
        r5 = this.isAnimated;
    L33:
        this.isAnimated = r5;
        Integer r13 = RTSJSONObject.a.b(r1, r7, "width");
        if (r13 != null) goto L36;
        r13 = this.width;
    L36:
        this.width = r13;
        Integer r14 = RTSJSONObject.a.b(r1, r7, "height");
        if (r14 != null) goto L39;
        r14 = this.height;
    L39:
        this.height = r14;
        return;
    L27:
        r12 = null;
        goto L28
    L23:
        r11 = this.content;
        goto L24
    }

    public final void setAnimated(Boolean r1) {
        this.isAnimated = r1;
    }

    public final void setAvgColor(String r1) {
        this.avgColor = r1;
    }

    public final void setContent(AnchorStatusContent r1) {
        this.content = r1;
    }

    public final void setHeight(Integer r1) {
        this.height = r1;
    }

    public final void setImageType(Integer r1) {
        this.imageType = r1;
    }

    public final void setSchema(String r1) {
        this.schema = r1;
    }

    public final void setUri(String r1) {
        this.uri = r1;
    }

    public final void setUrlList(ArrayList<String> r1) {
        this.urlList = r1;
    }

    public final void setWidth(Integer r1) {
        this.width = r1;
    }

    public AnchorStatusImageModel(RTSJSONObject r1, String r2) {
        super(r1, r2);
        if (r1 != null) goto L7;
        if (r2 != null) goto L7;
        doInit(false);
        return;
    L7:
        doInit(true);
    }

    public /* synthetic */ AnchorStatusImageModel(RTSJSONObject r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
