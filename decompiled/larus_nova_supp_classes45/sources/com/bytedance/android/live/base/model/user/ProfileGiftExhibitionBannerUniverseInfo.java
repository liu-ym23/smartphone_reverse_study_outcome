package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.user.GiftExhibitionBanner.UniverseInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/base/model/user/ProfileGiftExhibitionBannerUniverseInfo;", "", "()V", "content", "Lcom/bytedance/android/live/base/model/user/ProfileText;", "getContent", "()Lcom/bytedance/android/live/base/model/user/ProfileText;", "setContent", "(Lcom/bytedance/android/live/base/model/user/ProfileText;)V", "subTitle", "getSubTitle", "setSubTitle", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "valid", "", "getValid", "()Z", "setValid", "(Z)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileGiftExhibitionBannerUniverseInfo implements vh7.h {

    @SerializedName("content")
    protected ProfileText content;

    @SerializedName("sub_title")
    protected ProfileText subTitle;

    @SerializedName("type")
    protected String type;

    @SerializedName("valid")
    protected boolean valid;

    public ProfileGiftExhibitionBannerUniverseInfo() {
    }

    public ProfileGiftExhibitionBannerUniverseInfo(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.valid = am3.h.a(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.type = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.subTitle = s0.a(r5);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.content = s0.a(r5);
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
    }

    public final ProfileText getContent() {
        return this.content;
    }

    public final ProfileText getSubTitle() {
        return this.subTitle;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean getValid() {
        return this.valid;
    }

    public final void setContent(ProfileText r1) {
        this.content = r1;
    }

    public final void setSubTitle(ProfileText r1) {
        this.subTitle = r1;
    }

    public final void setType(String r1) {
        this.type = r1;
    }

    public final void setValid(boolean r1) {
        this.valid = r1;
    }
}
