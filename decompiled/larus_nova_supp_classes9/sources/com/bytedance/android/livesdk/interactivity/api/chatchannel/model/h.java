package com.bytedance.android.livesdk.interactivity.api.chatchannel.model;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.room_channel.GetChannelUserListResponse.ResponseData")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/h;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "hasMore", "Z", "a", "()Z", "setHasMore", "(Z)V", "isFull", "setFull", BuildConfig.FLAVOR, "total", "I", "getTotal", "()I", "setTotal", "(I)V", "maxMemberCount", "getMaxMemberCount", "setMaxMemberCount", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/h$a;", "userList", "Ljava/util/List;", "b", "()Ljava/util/List;", "setUserList", "(Ljava/util/List;)V", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h implements vh7.h {

    @SerializedName("has_more")
    protected boolean hasMore;

    @SerializedName("is_full")
    protected boolean isFull;

    @SerializedName("max_member_count")
    protected int maxMemberCount;

    @SerializedName("total")
    protected int total;

    @SerializedName("user_list")
    protected List<a> userList;

    @ProtoMessage("webcast.api.room_channel.GetChannelUserListResponse.UserInfo")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/h$a;", BuildConfig.FLAVOR, "Lcom/bytedance/android/live/base/model/user/User;", "user", "Lcom/bytedance/android/live/base/model/user/User;", "b", "()Lcom/bytedance/android/live/base/model/user/User;", "setUser", "(Lcom/bytedance/android/live/base/model/user/User;)V", BuildConfig.FLAVOR, "isOwner", "Z", "c", "()Z", "setOwner", "(Z)V", "isInvitedByCurrentUser", "setInvitedByCurrentUser", BuildConfig.FLAVOR, "invitedUserName", "Ljava/lang/String;", "getInvitedUserName", "()Ljava/lang/String;", "setInvitedUserName", "(Ljava/lang/String;)V", "needPermit", "a", "setNeedPermit", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements vh7.h {

        @SerializedName("invited_by_nick_name")
        protected String invitedUserName;

        @SerializedName("invited_by")
        protected boolean isInvitedByCurrentUser;

        @SerializedName("is_owner")
        protected boolean isOwner;

        @SerializedName("need_permit")
        protected boolean needPermit;

        @SerializedName("user")
        protected User user;

        public a() {
        }

        public a(am3.g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L21;
            if (r2 != 1) goto L8;
            this.user = new User(r5);
            goto L3
        L8:
            if (r2 != 2) goto L10;
            this.isOwner = am3.h.a(r5);
            goto L3
        L10:
            if (r2 != 3) goto L12;
            this.isInvitedByCurrentUser = am3.h.a(r5);
            goto L3
        L12:
            if (r2 != 4) goto L14;
            this.invitedUserName = am3.h.c(r5);
            goto L3
        L14:
            if (r2 != 5) goto L15;
            this.needPermit = am3.h.a(r5);
            goto L3
        L15:
            am3.h.e(r5);
            goto L3
        L21:
            r5.d(r0);
        }

        public final boolean a() {
            return this.needPermit;
        }

        public final User b() {
            return this.user;
        }

        public final boolean c() {
            return this.isOwner;
        }
    }

    public h() {
    }

    public final boolean a() {
        return this.hasMore;
    }

    public final List<a> b() {
        return this.userList;
    }

    public h(am3.g r5) {
        this.userList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.userList.add(new a(r5));
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.total = (int) r5.j();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.hasMore = am3.h.a(r5);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.isFull = am3.h.a(r5);
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.maxMemberCount = (int) r5.j();
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
    }
}
