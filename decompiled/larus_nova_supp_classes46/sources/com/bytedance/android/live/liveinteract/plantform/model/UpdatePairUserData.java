package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.linkmic_audience.UpdatePairUserResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/UpdatePairUserData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/plantform/model/l0;", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/h0;", "getUsers", "", "isHasMore", "Lcom/bytedance/android/live/liveinteract/plantform/model/PairUser;", "users", "Ljava/util/List;", "hasMore", "Z", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdatePairUserData extends FlexModelBase<l0> implements l0, vh7.h {

    @IgnoreProtoFieldCheck
    @SerializedName("has_more")
    public boolean hasMore;

    @SerializedName("users")
    public List<PairUser> users;

    public UpdatePairUserData() {
        super(l0.class);
    }

    public UpdatePairUserData(am3.g r6) {
        super(l0.class);
        this.users = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this.users.add(new PairUser(r6));
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.l0
    public List<? extends h0> getUsers() {
        return this.users;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.l0
    public boolean isHasMore() {
        return this.hasMore;
    }
}
