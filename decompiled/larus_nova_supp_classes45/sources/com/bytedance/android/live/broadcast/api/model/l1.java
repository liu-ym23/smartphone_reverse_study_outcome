package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.ShareListResponse.ResponseData")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/l1;", "", "", "Lcom/bytedance/android/live/broadcast/api/model/m1;", "userList", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lcom/bytedance/android/live/broadcast/api/model/k1;", "groupList", "a", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l1 implements vh7.h {

    @SerializedName("groups")
    protected List<k1> groupList;

    @SerializedName("users")
    protected List<m1> userList;

    public l1() {
    }

    public l1(am3.g r5) {
        this.userList = new ArrayList();
        this.groupList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L13;
        if (r2 == 1) goto L11;
        if (r2 != 2) goto L9;
        List r3 = this.groupList;
        vh7.h r4 = new k1(r5);
    L12:
        r3.add(r4);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L11:
        r3 = this.userList;
        r4 = new m1(r5);
        goto L12
    L13:
        r5.d(r0);
    }

    public final List<k1> a() {
        return this.groupList;
    }

    public final List<m1> b() {
        return this.userList;
    }
}
