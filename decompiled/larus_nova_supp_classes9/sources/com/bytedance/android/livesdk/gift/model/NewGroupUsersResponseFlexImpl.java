package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.anchor.QueryGroupMemberInfosResp.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eR7\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/NewGroupUsersResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/u2;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/t2;", "<set-?>", "groupMemberList$delegate", "Ljava/lang/Object;", "getGroupMemberList", "()Ljava/util/List;", "setGroupMemberList", "(Ljava/util/List;)V", "groupMemberList", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class NewGroupUsersResponseFlexImpl extends FlexModelBase<u2> implements u2, vh7.h {

    @SerializedName("members")
    protected List<? extends t2> _$$groupMemberList;

    public NewGroupUsersResponseFlexImpl() {
        super(u2.class);
        this._$$groupMemberList = $defaultValue_groupMemberList$();
    }

    public NewGroupUsersResponseFlexImpl(am3.g r6) {
        super(u2.class);
        this._$$groupMemberList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this._$$groupMemberList.add(vh7.f.a(r6, t2.class));
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$groupMemberList.isEmpty() == false) goto L19;
        this._$$groupMemberList = $defaultValue_groupMemberList$();
        return;
    }

    public final List<t2> $defaultValue_groupMemberList$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.gift.model.u2
    public final List<t2> getGroupMemberList() {
        return this._$$groupMemberList;
    }

    @Override // com.bytedance.android.livesdk.gift.model.u2
    public final void setGroupMemberList(List<? extends t2> r1) {
        this._$$groupMemberList = r1;
    }
}
