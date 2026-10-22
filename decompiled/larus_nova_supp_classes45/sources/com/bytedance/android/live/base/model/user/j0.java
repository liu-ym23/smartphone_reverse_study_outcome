package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.user.ResidentGuestBanner.UIConfig")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/base/model/user/j0;", "", "", "", "gradientColor", "Ljava/util/List;", "getGradientColor", "()Ljava/util/List;", "setGradientColor", "(Ljava/util/List;)V", "borderColor", "Ljava/lang/String;", "getBorderColor", "()Ljava/lang/String;", "setBorderColor", "(Ljava/lang/String;)V", "titleColor", "getTitleColor", "setTitleColor", "textColor", "getTextColor", "setTextColor", "<init>", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j0 implements vh7.h {

    @SerializedName("border_color")
    protected String borderColor;

    @SerializedName("gradient_color")
    protected List<String> gradientColor;

    @SerializedName("text_color")
    protected String textColor;

    @SerializedName("title_color")
    protected String titleColor;

    public j0() {
    }

    public j0(am3.g r5) {
        this.gradientColor = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.gradientColor.add(am3.h.c(r5));
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.borderColor = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.titleColor = am3.h.c(r5);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.textColor = am3.h.c(r5);
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
    }
}
