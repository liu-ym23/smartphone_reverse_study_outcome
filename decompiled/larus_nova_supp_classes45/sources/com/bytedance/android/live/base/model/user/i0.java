package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/base/model/user/i0;", "", "Lcom/bytedance/android/live/base/model/user/j0;", "uiConfig", "Lcom/bytedance/android/live/base/model/user/j0;", "getUiConfig", "()Lcom/bytedance/android/live/base/model/user/j0;", "setUiConfig", "(Lcom/bytedance/android/live/base/model/user/j0;)V", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "members", "Ljava/util/List;", "a", "()Ljava/util/List;", "setMembers", "(Ljava/util/List;)V", "residentLinkmicRoomAnchor", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "b", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setResidentLinkmicRoomAnchor", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "<init>", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i0 implements vh7.h {

    @SerializedName("members")
    protected List<? extends IBaseUser> members;

    @SerializedName("resident_linkmic_room_anchor")
    protected IBaseUser residentLinkmicRoomAnchor;

    @SerializedName("ui_config")
    protected j0 uiConfig;

    public i0() {
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public i0(am3.g r5) {
        this.members = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.uiConfig = new j0(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.members.add(vh7.f.a(r5, IBaseUser.class));
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.residentLinkmicRoomAnchor = vh7.f.a(r5, IBaseUser.class);
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }

    public final List<IBaseUser> a() {
        return this.members;
    }

    public final IBaseUser b() {
        return this.residentLinkmicRoomAnchor;
    }
}
