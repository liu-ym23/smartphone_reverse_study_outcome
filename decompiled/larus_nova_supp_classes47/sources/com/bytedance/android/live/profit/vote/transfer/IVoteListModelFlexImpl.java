package com.bytedance.android.live.profit.vote.transfer;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.gift.GetGiftVotesResponse.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R7\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/profit/vote/transfer/IVoteListModelFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/vote/transfer/a;", "", "Lcom/bytedance/android/live/profit/vote/model/a;", "<set-?>", "mVotes$delegate", "Ljava/lang/Object;", "getMVotes", "()Ljava/util/List;", "setMVotes", "(Ljava/util/List;)V", "mVotes", "", "mVoteType$delegate", "getMVoteType", "()J", "setMVoteType", "(J)V", "mVoteType", "<init>", "()V", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IVoteListModelFlexImpl extends FlexModelBase<a> implements a, vh7.h {

    @SerializedName("vote_type")
    protected long _$$mVoteType;

    @SerializedName("votes")
    protected List<? extends com.bytedance.android.live.profit.vote.model.a> _$$mVotes;

    public IVoteListModelFlexImpl() {
        super(a.class);
        this._$$mVotes = $defaultValue_mVotes$();
    }

    public final List<com.bytedance.android.live.profit.vote.model.a> $defaultValue_mVotes$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.profit.vote.transfer.a
    public final long getMVoteType() {
        return this._$$mVoteType;
    }

    @Override // com.bytedance.android.live.profit.vote.transfer.a
    public final List<com.bytedance.android.live.profit.vote.model.a> getMVotes() {
        return this._$$mVotes;
    }

    public IVoteListModelFlexImpl(am3.g r6) {
        super(a.class);
        this._$$mVotes = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$mVotes.add(vh7.f.a(r6, com.bytedance.android.live.profit.vote.model.a.class));
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$mVoteType = r6.j();
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$mVotes.isEmpty() == false) goto L25;
        this._$$mVotes = $defaultValue_mVotes$();
        return;
    }

    @Override // com.bytedance.android.live.profit.vote.transfer.a
    public final void setMVoteType(long r1) {
        this._$$mVoteType = r1;
    }

    @Override // com.bytedance.android.live.profit.vote.transfer.a
    public final void setMVotes(List<? extends com.bytedance.android.live.profit.vote.model.a> r1) {
        this._$$mVotes = r1;
    }
}
