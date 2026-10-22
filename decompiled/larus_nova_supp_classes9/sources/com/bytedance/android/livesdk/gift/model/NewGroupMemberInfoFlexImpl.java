package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.GroupLiveMemberInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0019\u001a\u0004\u0018\u00010\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/NewGroupMemberInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/t2;", BuildConfig.FLAVOR, "<set-?>", "score$delegate", "Ljava/lang/Object;", "getScore", "()J", "setScore", "(J)V", "score", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user$delegate", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "user", "Lcom/bytedance/android/livesdk/gift/model/j0;", "extraInfo$delegate", "getExtraInfo", "()Lcom/bytedance/android/livesdk/gift/model/j0;", "setExtraInfo", "(Lcom/bytedance/android/livesdk/gift/model/j0;)V", "extraInfo", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class NewGroupMemberInfoFlexImpl extends FlexModelBase<t2> implements t2, vh7.h {

    @SerializedName("extra_info")
    protected j0 _$$extraInfo;

    @SerializedName("score")
    protected long _$$score;

    @SerializedName("user")
    protected IBaseUser _$$user;

    public NewGroupMemberInfoFlexImpl() {
        super(t2.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.t2
    public final j0 getExtraInfo() {
        return this._$$extraInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.t2
    public final long getScore() {
        return this._$$score;
    }

    @Override // com.bytedance.android.livesdk.gift.model.t2
    public final IBaseUser getUser() {
        return this._$$user;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.gift.model.j0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public NewGroupMemberInfoFlexImpl(am3.g r6) {
        super(t2.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$user = vh7.f.a(r6, IBaseUser.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$score = r6.j();
        goto L3
    L10:
        if (r2 != 4) goto L11;
        this._$$extraInfo = vh7.f.a(r6, j0.class);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.model.t2
    public final void setExtraInfo(j0 r1) {
        this._$$extraInfo = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.t2
    public final void setScore(long r1) {
        this._$$score = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.t2
    public final void setUser(IBaseUser r1) {
        this._$$user = r1;
    }
}
