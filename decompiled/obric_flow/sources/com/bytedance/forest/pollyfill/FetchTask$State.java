package com.bytedance.forest.pollyfill;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/forest/pollyfill/FetchTask$State", "", "Lcom/bytedance/forest/pollyfill/FetchTask$State;", "forest_release"}, k = 1, mv = {1, 4, 0})
final enum FetchTask$State extends Enum<FetchTask$State> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FetchTask$State f4459a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FetchTask$State f4460b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FetchTask$State f4461c = null;
    public static final FetchTask$State d = null;
    public static final FetchTask$State e = null;
    public static final FetchTask$State f = null;
    public static final /* synthetic */ FetchTask$State[] g = null;

    static {
        FetchTask$State r5 = new FetchTask$State("PENDING", 0);
        f4459a = r5;
        FetchTask$State r10 = new FetchTask$State("SUCCESS", 1);
        f4460b = r10;
        FetchTask$State r11 = new FetchTask$State("FAILURE", 2);
        f4461c = r11;
        FetchTask$State r12 = new FetchTask$State("CANCEL", 3);
        d = r12;
        FetchTask$State r13 = new FetchTask$State("REDIRECTION", 4);
        e = r13;
        FetchTask$State r14 = new FetchTask$State("INTERCEPT", 5);
        f = r14;
        g = new FetchTask$State[]{r5, r10, r11, r12, r13, r14};
    }

    public FetchTask$State(String r5, int r10) {
        super(r5, r10);
    }

    public static FetchTask$State valueOf(String r5) {
        return (FetchTask$State) Enum.valueOf(FetchTask$State.class, r5);
    }

    public static FetchTask$State[] values() {
        return (FetchTask$State[]) g.clone();
    }
}
