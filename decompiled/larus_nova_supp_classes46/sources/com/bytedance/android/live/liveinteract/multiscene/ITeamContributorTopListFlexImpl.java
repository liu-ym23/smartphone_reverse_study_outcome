package com.bytedance.android.live.liveinteract.multiscene;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.TeamContributorTopList")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eR;\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multiscene/ITeamContributorTopListFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/liveinteract/multiscene/e;", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "<set-?>", "userList$delegate", "Ljava/lang/Object;", "getUserList", "()Ljava/util/List;", "setUserList", "(Ljava/util/List;)V", "userList", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ITeamContributorTopListFlexImpl extends FlexModelBase<e> implements e, vh7.h {

    @SerializedName("user_list")
    protected List<? extends IBaseUser> _$$userList;

    public ITeamContributorTopListFlexImpl() {
        super(e.class);
    }

    public ITeamContributorTopListFlexImpl(am3.g r6) {
        super(e.class);
        this._$$userList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this._$$userList.add(vh7.f.a(r6, IBaseUser.class));
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.e
    public final List<IBaseUser> getUserList() {
        return this._$$userList;
    }

    @Override // com.bytedance.android.live.liveinteract.multiscene.e
    public final void setUserList(List<? extends IBaseUser> r1) {
        this._$$userList = r1;
    }
}
