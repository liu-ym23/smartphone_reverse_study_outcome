package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.user.UserFriendListResponseData")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/v1;", "", "", "Lcom/bytedance/android/live/base/model/user/User;", "userList", "Ljava/util/List;", "", "hasMore", "Ljava/lang/Boolean;", "", "cursor", "J", "", "total", "I", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v1 implements vh7.h {

    @SerializedName("cursor")
    public long cursor;

    @SerializedName("has_more")
    public Boolean hasMore;

    @SerializedName("total")
    public int total;

    @SerializedName("users")
    public List<User> userList;

    public v1() {
        this.userList = new ArrayList();
    }

    public v1(am3.g r5) {
        this.userList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.userList.add(new User(r5));
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.hasMore = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.cursor = r5.j();
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.total = r5.i();
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
        if (this.userList.isEmpty() == false) goto L37;
        this.userList = new ArrayList();
        return;
    }
}
