package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/QueryAuthenticateConfig;", NameKeys.UnloadStrategy_No_Strategy, "expireTimeSecond", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(I)V", "getExpireTimeSecond", "()I", "component1", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", "toString", NameKeys.UnloadStrategy_No_Strategy, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QueryAuthenticateConfig {

    @SerializedName("expire_time_second")
    private final int expireTimeSecond;

    public QueryAuthenticateConfig() {
        int r2 = 0;
        this(r2, 1, null);
    }

    public static /* synthetic */ QueryAuthenticateConfig copy$default(QueryAuthenticateConfig r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.expireTimeSecond;
    L6:
        return r0.copy(r1);
    }

    public final int component1() {
        return this.expireTimeSecond;
    }

    public final QueryAuthenticateConfig copy(int r2) {
        return new QueryAuthenticateConfig(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof QueryAuthenticateConfig) == true) goto L9;
        return false;
    L9:
        if (this.expireTimeSecond == ((QueryAuthenticateConfig) r4).expireTimeSecond) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.expireTimeSecond;
    }

    public String toString() {
        return "QueryAuthenticateConfig(expireTimeSecond=" + this.expireTimeSecond + ')';
    }

    public final int getExpireTimeSecond() {
        return this.expireTimeSecond;
    }

    public QueryAuthenticateConfig(int r1) {
        this.expireTimeSecond = r1;
    }

    public /* synthetic */ QueryAuthenticateConfig(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 60;
    L5:
        this(r1);
    }
}
