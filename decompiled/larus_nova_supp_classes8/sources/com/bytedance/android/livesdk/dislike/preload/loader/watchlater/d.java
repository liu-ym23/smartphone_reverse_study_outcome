package com.bytedance.android.livesdk.dislike.preload.loader.watchlater;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.livesdkapi.depend.model.live.ILLPanelWidget;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@ProtoMessage("webcast.api.distribution.PreviewPanelWidget")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0097D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/preload/loader/watchlater/d;", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILLPanelWidget;", "", "id", "I", "getId", "()I", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "", "displayText", "Ljava/lang/String;", "getDisplayText", "()Ljava/lang/String;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d implements ILLPanelWidget, h {

    @SerializedName("display_text")
    protected String displayText;

    @SerializedName("icon")
    protected ImageModel icon;

    @SerializedName("id")
    protected int id;

    public d() {
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final ImageModel getIcon() {
        return this.icon;
    }

    public final int getId() {
        return this.id;
    }

    public d(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.id = r5.i();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.icon = x.a(r5);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.displayText = am3.h.c(r5);
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }
}
