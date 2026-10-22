package com.bytedance.android.live.base.model.user;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.User.XiguaParams")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001b\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\n*\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\n*\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\fJ\u001b\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\n*\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R$\u0010*\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\"\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&¨\u0006/"}, d2 = {"Lcom/bytedance/android/live/base/model/user/XiguaParams;", "", "", "getUserAuthInfo", "userAuthInfo", "", "setUserAuthInfo", "", "getXiguaUid", "Lpy/k;", "T", "getAvatarThumb", "()Lpy/k;", "getAvatarMedium", "getAvatarLarge", "xiguaUid", "setXiguaUid", "_userAuthInfo", "Ljava/lang/String;", "get_userAuthInfo", "()Ljava/lang/String;", "set_userAuthInfo", "(Ljava/lang/String;)V", "_xiguaUid", "J", "get_xiguaUid", "()J", "set_xiguaUid", "(J)V", "_nickName", "get_nickName", "set_nickName", "Lcom/bytedance/android/live/base/model/ImageModel;", "_avatarThumb", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_avatarThumb", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_avatarThumb", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "_avatarMedium", "get_avatarMedium", "set_avatarMedium", "_avatarLarge", "get_avatarLarge", "set_avatarLarge", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XiguaParams implements vh7.h {

    @SerializedName("avatar_large")
    protected ImageModel _avatarLarge;

    @SerializedName("avatar_medium")
    protected ImageModel _avatarMedium;

    @SerializedName("avatar_thumb")
    protected ImageModel _avatarThumb;

    @SerializedName("nick_name")
    protected String _nickName;

    @SerializedName("user_auth_info")
    protected String _userAuthInfo;

    @SerializedName("xigua_uid")
    protected long _xiguaUid;

    public XiguaParams() {
    }

    public <T extends py.k> T getAvatarLarge() {
        ImageModel r0 = this._avatarLarge;
        if ((r0 instanceof py.k) == true) goto L6;
        return null;
    L6:
        return r0;
    }

    public <T extends py.k> T getAvatarMedium() {
        ImageModel r0 = this._avatarMedium;
        if ((r0 instanceof py.k) == true) goto L6;
        return null;
    L6:
        return r0;
    }

    public <T extends py.k> T getAvatarThumb() {
        ImageModel r0 = this._avatarThumb;
        if ((r0 instanceof py.k) == true) goto L6;
        return null;
    L6:
        return r0;
    }

    public String getUserAuthInfo() {
        return this._userAuthInfo;
    }

    public long getXiguaUid() {
        return this._xiguaUid;
    }

    public final ImageModel get_avatarLarge() {
        return this._avatarLarge;
    }

    public final ImageModel get_avatarMedium() {
        return this._avatarMedium;
    }

    public final ImageModel get_avatarThumb() {
        return this._avatarThumb;
    }

    public final String get_nickName() {
        return this._nickName;
    }

    public final String get_userAuthInfo() {
        return this._userAuthInfo;
    }

    public final long get_xiguaUid() {
        return this._xiguaUid;
    }

    public XiguaParams(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L7;
        this._userAuthInfo = am3.h.c(r5);
        goto L3
    L7:
        switch(r2) {
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            default: goto L8;
        };
    L9:
        this._avatarLarge = com.bytedance.android.live.base.model.x.a(r5);
        goto L3
    L10:
        this._avatarMedium = com.bytedance.android.live.base.model.x.a(r5);
        goto L3
    L11:
        this._avatarThumb = com.bytedance.android.live.base.model.x.a(r5);
        goto L3
    L12:
        this._nickName = am3.h.c(r5);
        goto L3
    L13:
        this._xiguaUid = r5.j();
        goto L3
    L8:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }

    public final void setUserAuthInfo(String r1) {
        this._userAuthInfo = r1;
    }

    public final void setXiguaUid(long r1) {
        this._xiguaUid = r1;
    }

    public final void set_avatarLarge(ImageModel r1) {
        this._avatarLarge = r1;
    }

    public final void set_avatarMedium(ImageModel r1) {
        this._avatarMedium = r1;
    }

    public final void set_avatarThumb(ImageModel r1) {
        this._avatarThumb = r1;
    }

    public final void set_nickName(String r1) {
        this._nickName = r1;
    }

    public final void set_userAuthInfo(String r1) {
        this._userAuthInfo = r1;
    }

    public final void set_xiguaUid(long r1) {
        this._xiguaUid = r1;
    }
}
