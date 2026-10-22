package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.user.GroupLiveBanner")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/base/model/user/h;", "", "Lcom/bytedance/android/live/base/model/user/i;", "uiConfig", "Lcom/bytedance/android/live/base/model/user/i;", "c", "()Lcom/bytedance/android/live/base/model/user/i;", "setUiConfig", "(Lcom/bytedance/android/live/base/model/user/i;)V", "", "titleText", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setTitleText", "(Ljava/lang/String;)V", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "memberList", "Ljava/util/List;", "a", "()Ljava/util/List;", "setMemberList", "(Ljava/util/List;)V", "<init>", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h implements vh7.h {

    @SerializedName("members")
    protected List<? extends IBaseUser> memberList;

    @SerializedName("text")
    protected String titleText;

    @SerializedName("ui_config")
    protected i uiConfig;

    public h() {
    }

    public h(am3.g r5) {
        this.memberList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.titleText = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.uiConfig = new i(r5);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.memberList.add(vh7.f.a(r5, IBaseUser.class));
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
    }

    public final List<IBaseUser> a() {
        return this.memberList;
    }

    public final String b() {
        return this.titleText;
    }

    public final i c() {
        return this.uiConfig;
    }
}
