package com.bytedance.android.live.base.model.user;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.user.ActionConfig.ClickedInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/base/model/user/ClickedInfo;", "", "()V", "action", "Lcom/bytedance/android/live/base/model/ImageModel;", "getAction", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setAction", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClickedInfo implements vh7.h {

    @SerializedName("action")
    protected ImageModel action;

    @SerializedName("title")
    protected String title;

    public ClickedInfo() {
    }

    public ClickedInfo(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.action = com.bytedance.android.live.base.model.x.a(r5);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.title = am3.h.c(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
    }

    public final ImageModel getAction() {
        return this.action;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setAction(ImageModel r1) {
        this.action = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }
}
