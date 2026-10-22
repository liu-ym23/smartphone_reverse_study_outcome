package com.bytedance.android.live.profit.vote;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(LiveVoteConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/profit/vote/LiveVoteConfig;", "Lvh7/j;", "Companion", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface LiveVoteConfig extends vh7.j<LiveVoteConfig> {
    public static final Companion a = null;

    public static final class Companion {
        public static final Lazy a = null;
        public static final /* synthetic */ Companion b = null;

        public Companion() {
        }

        static {
            b = new Companion();
            a = LazyKt.lazy(LiveVoteConfig$Companion$DEFAULT$2.INSTANCE);
        }
    }

    @JsonAdapter(LiveVoteConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    static {
        a = Companion.b;
    }

    @FieldName(name = "ktv_vote_text_plan")
    Integer V3();

    @FieldName(name = "ktv_vote_create_uri")
    String X0();

    @FieldName(name = "gift_vote_enabled")
    Integer X8();

    @FieldName(name = "ktv_vote_detail_uri")
    String Y2();

    @FieldName(name = "gift_vote_detail_uri")
    String g7();

    @FieldName(name = "gift_vote_create_uri")
    String m9();

    @FieldName(name = "ktv_vote_enabled")
    Integer u8();
}
