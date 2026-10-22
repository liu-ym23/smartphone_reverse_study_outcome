package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.linkmic_audience.UserSearchResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/IListSearchDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/t;", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/u;", "users", "Ljava/util/List;", "getUsers", "()Ljava/util/List;", "setUsers", "(Ljava/util/List;)V", "", "hasMore$delegate", "Ljava/lang/Object;", "getHasMore", "()Z", "hasMore", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IListSearchDataFlexImpl extends FlexModelBase<t> implements t, vh7.h {

    @SerializedName("has_more")
    protected boolean _$$hasMore;

    @SerializedName("users")
    protected List<? extends u> users;

    public IListSearchDataFlexImpl() {
        super(t.class);
        this._$$hasMore = false;
    }

    public IListSearchDataFlexImpl(am3.g r8) {
        super(t.class);
        this.users = new ArrayList();
        setThreadSafe(false);
        long r1 = r8.c();
        boolean r3 = false;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L12;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        if (r4 != 1) goto L8;
        this.users.add(vh7.f.a(r8, u.class));
        goto L3
    L8:
        if (r4 != 2) goto L9;
        this._$$hasMore = am3.h.a(r8);
        r3 = r3 | true;
        goto L3
    L9:
        am3.h.d(r5, r8);
        goto L3
    L12:
        r8.d(r1);
        setThreadSafe(true);
        if ((r3 & true) == true) goto L25;
        this._$$hasMore = false;
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.t
    public final boolean getHasMore() {
        return this._$$hasMore;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.t
    public List<u> getUsers() {
        return this.users;
    }

    public void setUsers(List<? extends u> r1) {
        this.users = r1;
    }
}
