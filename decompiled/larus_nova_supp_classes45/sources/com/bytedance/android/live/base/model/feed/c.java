package com.bytedance.android.live.base.model.feed;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.feed.FeedExtra.SimilarCollectionText")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/base/model/feed/c;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "buttonText", "getButtonText", "setButtonText", "Lcom/bytedance/android/live/base/model/ImageModel;", "iconLeft", "Lcom/bytedance/android/live/base/model/ImageModel;", "getIconLeft", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setIconLeft", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "iconRight", "getIconRight", "setIconRight", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements h {

    @SerializedName("button_text")
    protected String buttonText;

    @SerializedName("icon_left")
    protected ImageModel iconLeft;

    @SerializedName("icon_right")
    protected ImageModel iconRight;

    @SerializedName("title")
    protected String title;

    public c() {
    }

    public c(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.title = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.buttonText = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.iconLeft = x.a(r5);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.iconRight = x.a(r5);
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
    }
}
