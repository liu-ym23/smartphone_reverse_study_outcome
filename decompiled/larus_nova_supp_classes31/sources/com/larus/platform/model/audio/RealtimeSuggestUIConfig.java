package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/larus/platform/model/audio/RealtimeSuggestUIConfig;", "Ljava/io/Serializable;", "suggestSwitchInterval", "", "showSuggestOnUserSilenceInterval", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getSuggestSwitchInterval", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getShowSuggestOnUserSilenceInterval", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/larus/platform/model/audio/RealtimeSuggestUIConfig;", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class RealtimeSuggestUIConfig implements Serializable {
    public static final a Companion = null;
    private static final RealtimeSuggestUIConfig DEFAULT = null;

    @SerializedName("show_suggest_on_user_silence_interval")
    private final Long showSuggestOnUserSilenceInterval;

    @SerializedName("suggest_switch_interval")
    private final Long suggestSwitchInterval;

    public static final class a {
        public a() {
        }
    }

    public RealtimeSuggestUIConfig() {
        Long r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ RealtimeSuggestUIConfig copy$default(RealtimeSuggestUIConfig r0, Long r1, Long r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.suggestSwitchInterval;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.showSuggestOnUserSilenceInterval;
    L9:
        return r0.copy(r1, r2);
    }

    public final Long component1() {
        return this.suggestSwitchInterval;
    }

    public final Long component2() {
        return this.showSuggestOnUserSilenceInterval;
    }

    public final RealtimeSuggestUIConfig copy(Long r2, Long r3) {
        return new RealtimeSuggestUIConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RealtimeSuggestUIConfig) == true) goto L8;
        return false;
    L8:
        RealtimeSuggestUIConfig r6 = (RealtimeSuggestUIConfig) r5;
        if (Intrinsics.areEqual(this.suggestSwitchInterval, r6.suggestSwitchInterval) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showSuggestOnUserSilenceInterval, r6.showSuggestOnUserSilenceInterval) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Long r0 = this.suggestSwitchInterval;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.showSuggestOnUserSilenceInterval;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "RealtimeSuggestUIConfig(suggestSwitchInterval=" + this.suggestSwitchInterval + ", showSuggestOnUserSilenceInterval=" + this.showSuggestOnUserSilenceInterval + ')';
    }

    static {
        Companion = new a();
        Long r2 = null;
        DEFAULT = new RealtimeSuggestUIConfig(r2, r2, 3, r2);
    }

    public static final /* synthetic */ RealtimeSuggestUIConfig access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public final Long getShowSuggestOnUserSilenceInterval() {
        return this.showSuggestOnUserSilenceInterval;
    }

    public final Long getSuggestSwitchInterval() {
        return this.suggestSwitchInterval;
    }

    public RealtimeSuggestUIConfig(Long r1, Long r2) {
        this.suggestSwitchInterval = r1;
        this.showSuggestOnUserSilenceInterval = r2;
    }

    public /* synthetic */ RealtimeSuggestUIConfig(Long r3, Long r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r3 = 3000L;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = 5000L;
    L8:
        this(r3, r4);
    }
}
