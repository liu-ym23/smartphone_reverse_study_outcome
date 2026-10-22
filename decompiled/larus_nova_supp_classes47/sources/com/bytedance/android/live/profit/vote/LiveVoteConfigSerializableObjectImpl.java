package com.bytedance.android.live.profit.vote;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0019\u0018\u00002\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001f\u0010 R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\b¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/profit/vote/LiveVoteConfigSerializableObjectImpl;", "Lcom/bytedance/android/live/profit/vote/LiveVoteConfig;", "", "mVoteEnable", "Ljava/lang/Integer;", "X8", "()Ljava/lang/Integer;", "setMVoteEnable", "(Ljava/lang/Integer;)V", "", "mGiftVoteCreateUri", "Ljava/lang/String;", "m9", "()Ljava/lang/String;", "setMGiftVoteCreateUri", "(Ljava/lang/String;)V", "mGiftVoteDetailUri", "g7", "setMGiftVoteDetailUri", "mKtvVoteEnabled", "u8", "setMKtvVoteEnabled", "mKtvVoteCreateUri", "X0", "setMKtvVoteCreateUri", "mKtvVoteDetailUri", "Y2", "setMKtvVoteDetailUri", "mKtvVoteTextPlan", "V3", "setMKtvVoteTextPlan", "<init>", "()V", "Adapter", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveVoteConfigSerializableObjectImpl implements LiveVoteConfig {

    @SerializedName("gift_vote_create_uri")
    private String mGiftVoteCreateUri;

    @SerializedName("gift_vote_detail_uri")
    private String mGiftVoteDetailUri;

    @SerializedName("ktv_vote_create_uri")
    private String mKtvVoteCreateUri;

    @SerializedName("ktv_vote_detail_uri")
    private String mKtvVoteDetailUri;

    @SerializedName("ktv_vote_enabled")
    private Integer mKtvVoteEnabled;

    @SerializedName("ktv_vote_text_plan")
    private Integer mKtvVoteTextPlan;

    @SerializedName("gift_vote_enabled")
    private Integer mVoteEnable;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profit/vote/LiveVoteConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LiveVoteConfigSerializableObjectImpl.class);
        }
    }

    public LiveVoteConfigSerializableObjectImpl() {
    }

    @Override // com.bytedance.android.live.profit.vote.LiveVoteConfig
    public final Integer V3() {
        return this.mKtvVoteTextPlan;
    }

    @Override // com.bytedance.android.live.profit.vote.LiveVoteConfig
    public final String X0() {
        return this.mKtvVoteCreateUri;
    }

    @Override // com.bytedance.android.live.profit.vote.LiveVoteConfig
    public final Integer X8() {
        return this.mVoteEnable;
    }

    @Override // com.bytedance.android.live.profit.vote.LiveVoteConfig
    public final String Y2() {
        return this.mKtvVoteDetailUri;
    }

    @Override // com.bytedance.android.live.profit.vote.LiveVoteConfig
    public final String g7() {
        return this.mGiftVoteDetailUri;
    }

    @Override // com.bytedance.android.live.profit.vote.LiveVoteConfig
    public final String m9() {
        return this.mGiftVoteCreateUri;
    }

    @Override // com.bytedance.android.live.profit.vote.LiveVoteConfig
    public final Integer u8() {
        return this.mKtvVoteEnabled;
    }
}
