package com.bytedance.android.live.profit.dress.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/dress/api/LoadTriggeredBy;", "", "", "value", "I", "getValue", "()I", "EnterRoom", "Message", "Getting", "Other", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LoadTriggeredBy extends Enum<LoadTriggeredBy> {
    public static final LoadTriggeredBy EnterRoom = null;
    public static final LoadTriggeredBy Getting = null;
    public static final LoadTriggeredBy Message = null;
    public static final LoadTriggeredBy Other = null;
    public static final /* synthetic */ LoadTriggeredBy[] a = null;
    private final int value;

    static {
        LoadTriggeredBy r1 = new LoadTriggeredBy("EnterRoom", 0, 0);
        EnterRoom = r1;
        LoadTriggeredBy r2 = new LoadTriggeredBy("Message", 1, 1);
        Message = r2;
        LoadTriggeredBy r3 = new LoadTriggeredBy("Getting", 2, 2);
        Getting = r3;
        LoadTriggeredBy r4 = new LoadTriggeredBy("Other", 3, -1);
        Other = r4;
        a = new LoadTriggeredBy[]{r1, r2, r3, r4};
    }

    public static LoadTriggeredBy valueOf(String r1) {
        return (LoadTriggeredBy) a.a(LoadTriggeredBy.class, r1);
    }

    public static LoadTriggeredBy[] values() {
        return (LoadTriggeredBy[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LoadTriggeredBy(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
