package com.bytedance.android.live.profit.vote.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.gift.GetGiftVotesResponse.Vote")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0019\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b+\u0010,R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR;\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R+\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R+\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R+\u0010\"\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R+\u0010&\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0006\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R+\u0010*\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00148V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0006\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019¨\u0006-"}, d2 = {"Lcom/bytedance/android/live/profit/vote/model/IVoteModelFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/vote/model/a;", "", "<set-?>", "voteId$delegate", "Ljava/lang/Object;", "getVoteId", "()Ljava/lang/String;", "setVoteId", "(Ljava/lang/String;)V", "voteId", "", "Lcom/bytedance/android/live/profit/vote/a;", "voteItems$delegate", "getVoteItems", "()Ljava/util/List;", "setVoteItems", "(Ljava/util/List;)V", "voteItems", "", "finishTime$delegate", "getFinishTime", "()J", "setFinishTime", "(J)V", "finishTime", "currentTime$delegate", "getCurrentTime", "setCurrentTime", "currentTime", "status$delegate", "getStatus", "setStatus", "status", "voteType$delegate", "getVoteType", "setVoteType", "voteType", "userCount$delegate", "getUserCount", "setUserCount", "userCount", "<init>", "()V", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IVoteModelFlexImpl extends FlexModelBase<a> implements a, h {

    @SerializedName("current_time")
    protected long _$$currentTime;

    @SerializedName("finish_time")
    protected long _$$finishTime;

    @SerializedName("status")
    protected long _$$status;

    @SerializedName("user_count")
    protected long _$$userCount;

    @SerializedName("vote_id")
    protected String _$$voteId;

    @SerializedName("results")
    protected List<? extends com.bytedance.android.live.profit.vote.a> _$$voteItems;

    @SerializedName("vote_type")
    protected long _$$voteType;

    public IVoteModelFlexImpl() {
        super(a.class);
    }

    @Override // com.bytedance.android.live.profit.vote.model.a
    public final long getCurrentTime() {
        return this._$$currentTime;
    }

    @Override // com.bytedance.android.live.profit.vote.model.a
    public final long getFinishTime() {
        return this._$$finishTime;
    }

    @Override // com.bytedance.android.live.profit.vote.model.a
    public final long getStatus() {
        return this._$$status;
    }

    @Override // com.bytedance.android.live.profit.vote.model.a
    public final long getUserCount() {
        return this._$$userCount;
    }

    @Override // com.bytedance.android.live.profit.vote.model.a
    public final String getVoteId() {
        return this._$$voteId;
    }

    @Override // com.bytedance.android.live.profit.vote.model.a
    public final List<com.bytedance.android.live.profit.vote.a> getVoteItems() {
        return this._$$voteItems;
    }

    @Override // com.bytedance.android.live.profit.vote.model.a
    public final long getVoteType() {
        return this._$$voteType;
    }

    public IVoteModelFlexImpl(g r5) {
        super(a.class);
        this._$$voteItems = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        this._$$userCount = r5.j();
        goto L3
    L9:
        this._$$voteType = r5.j();
        goto L3
    L10:
        this._$$status = r5.j();
        goto L3
    L11:
        this._$$currentTime = r5.j();
        goto L3
    L12:
        this._$$finishTime = r5.j();
        goto L3
    L13:
        this._$$voteItems.add(vh7.f.a(r5, com.bytedance.android.live.profit.vote.a.class));
        goto L3
    L14:
        this._$$voteId = am3.h.c(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L15:
        r5.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.vote.model.a
    public final void setCurrentTime(long r1) {
        this._$$currentTime = r1;
    }

    @Override // com.bytedance.android.live.profit.vote.model.a
    public final void setFinishTime(long r1) {
        this._$$finishTime = r1;
    }

    @Override // com.bytedance.android.live.profit.vote.model.a
    public final void setStatus(long r1) {
        this._$$status = r1;
    }

    @Override // com.bytedance.android.live.profit.vote.model.a
    public final void setUserCount(long r1) {
        this._$$userCount = r1;
    }

    @Override // com.bytedance.android.live.profit.vote.model.a
    public final void setVoteId(String r1) {
        this._$$voteId = r1;
    }

    @Override // com.bytedance.android.live.profit.vote.model.a
    public final void setVoteItems(List<? extends com.bytedance.android.live.profit.vote.a> r1) {
        this._$$voteItems = r1;
    }

    @Override // com.bytedance.android.live.profit.vote.model.a
    public final void setVoteType(long r1) {
        this._$$voteType = r1;
    }
}
