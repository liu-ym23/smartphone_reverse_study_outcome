package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.distribution.GetGroupListResponse.ResponseData")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/k0;", "", "", "Lcom/bytedance/android/live/broadcast/api/model/p0;", "list", "Ljava/util/List;", "", "hasMore", "Ljava/lang/Boolean;", "", "nextCursor", "J", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k0 implements vh7.h {

    @SerializedName("has_more")
    public Boolean hasMore;

    @SerializedName("group_info_list")
    public List<p0> list;

    @SerializedName("next_cursor")
    public long nextCursor;

    public k0() {
        this.list = new ArrayList();
    }

    public k0(am3.g r5) {
        this.list = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.list.add(new p0(r5));
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.hasMore = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.nextCursor = r5.j();
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
        if (this.list.isEmpty() == false) goto L31;
        this.list = new ArrayList();
        return;
    }
}
