package com.bytedance.android.live.base.model.tab;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.setting.TabItem")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b<\u0010=R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR$\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\"\u0010 \u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R\"\u0010#\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\"\u0010&\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R$\u0010)\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\r\"\u0004\b+\u0010\u000fR$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR$\u00106\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u000b\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u000fR$\u00109\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u000b\u001a\u0004\b:\u0010\r\"\u0004\b;\u0010\u000f¨\u0006>"}, d2 = {"Lcom/bytedance/android/live/base/model/tab/a;", "", "", "id", "I", "getId", "()I", "setId", "(I)V", "", LiveSlardarConstants.EXTRA_KEY_URL, "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "", "style", "J", "getStyle", "()J", "setStyle", "(J)V", "umengEvent", "getUmengEvent", "setUmengEvent", "event", "getEvent", "setEvent", "umengSource", "getUmengSource", "setUmengSource", "enableDislike", "getEnableDislike", "setEnableDislike", "enableDrawStream", "getEnableDrawStream", "setEnableDrawStream", "interUrl", "getInterUrl", "setInterUrl", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "contentType", "getContentType", "setContentType", "feUrl", "getFeUrl", "setFeUrl", "xiguaOldTabData", "getXiguaOldTabData", "setXiguaOldTabData", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("content_type")
    protected int contentType;

    @SerializedName("enable_dislike")
    protected long enableDislike;

    @SerializedName("enable_draw_stream")
    protected long enableDrawStream;

    @SerializedName("event")
    protected String event;

    @SerializedName("fe_url")
    protected String feUrl;

    @SerializedName("icon")
    protected ImageModel icon;

    @SerializedName("id")
    protected int id;

    @SerializedName("inter_url")
    protected String interUrl;

    @SerializedName("name")
    protected String name;

    @SerializedName("style")
    protected long style;

    @SerializedName("umeng_event")
    protected String umengEvent;

    @SerializedName("umeng_source")
    protected long umengSource;

    @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
    protected String url;

    @SerializedName("xigua_old_tab_data")
    protected String xiguaOldTabData;

    public a() {
    }

    public a(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L39;
        if (r2 != 1) goto L8;
        this.id = (int) r5.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.url = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.name = am3.h.c(r5);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.style = r5.j();
        goto L3
    L14:
        if (r2 != 16) goto L16;
        this.event = am3.h.c(r5);
        goto L3
    L16:
        if (r2 != 21) goto L18;
        this.icon = x.a(r5);
        goto L3
    L18:
        if (r2 != 200) goto L20;
        this.xiguaOldTabData = am3.h.c(r5);
        goto L3
    L20:
        if (r2 != 25) goto L22;
        this.contentType = r5.i();
        goto L3
    L22:
        if (r2 != 26) goto L23;
        this.feUrl = am3.h.c(r5);
        goto L3
    L23:
        switch(r2) {
            case 7: goto L29;
            case 8: goto L28;
            case 9: goto L27;
            case 10: goto L26;
            case 11: goto L25;
            default: goto L24;
        };
    L25:
        this.interUrl = am3.h.c(r5);
        goto L3
    L26:
        this.enableDrawStream = r5.j();
        goto L3
    L27:
        this.enableDislike = r5.j();
        goto L3
    L28:
        this.umengSource = r5.j();
        goto L3
    L29:
        this.umengEvent = am3.h.c(r5);
        goto L3
    L24:
        am3.h.e(r5);
        goto L3
    L39:
        r5.d(r0);
    }
}
