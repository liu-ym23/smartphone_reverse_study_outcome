package com.bytedance.android.live.profit.vote;

import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tR\u001b\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/profit/vote/VoteState;", "", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", Constants.OperatorKey.CODE, "J", "getCode", "()J", "Companion", "a", "RESUMED", "PAUSED", "FINISHED", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum VoteState extends Enum<VoteState> {
    public static final a Companion = null;
    public static final VoteState FINISHED = null;
    public static final VoteState PAUSED = null;
    public static final VoteState RESUMED = null;
    public static final /* synthetic */ VoteState[] a = null;
    private final long code;

    public static final class a {
        public a() {
        }
    }

    static {
        VoteState r2 = new VoteState("RESUMED", 0, 1);
        RESUMED = r2;
        VoteState r3 = new VoteState("PAUSED", 1, 2);
        PAUSED = r3;
        VoteState r4 = new VoteState("FINISHED", 2, 3);
        FINISHED = r4;
        a = new VoteState[]{r2, r3, r4};
        Companion = new a();
    }

    public static VoteState valueOf(String r1) {
        return (VoteState) r27.a.a(VoteState.class, r1);
    }

    public static VoteState[] values() {
        return (VoteState[]) a.clone();
    }

    public final long getCode() {
        return this.code;
    }

    public VoteState(String r1, int r2, long r3) {
        super(r1, r2);
        this.code = r3;
    }
}
