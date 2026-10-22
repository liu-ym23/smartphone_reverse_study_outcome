package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/larus/platform/model/audio/ContinuousSpeechUIConfig;", "Ljava/io/Serializable;", "showSpeechOnLeft", "", "triggerSpeechDelayTime", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Long;)V", "getShowSpeechOnLeft", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTriggerSpeechDelayTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/larus/platform/model/audio/ContinuousSpeechUIConfig;", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ContinuousSpeechUIConfig implements Serializable {
    public static final a Companion = null;
    private static final ContinuousSpeechUIConfig DEFAULT = null;

    @SerializedName("continuous_speak_button_left")
    private final Boolean showSpeechOnLeft;

    @SerializedName("click_continuous_speak_duration")
    private final Long triggerSpeechDelayTime;

    public static final class a {
        public a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuousSpeechUIConfig() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ContinuousSpeechUIConfig copy$default(ContinuousSpeechUIConfig r0, Boolean r1, Long r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.showSpeechOnLeft;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.triggerSpeechDelayTime;
    L9:
        return r0.copy(r1, r2);
    }

    public final Boolean component1() {
        return this.showSpeechOnLeft;
    }

    public final Long component2() {
        return this.triggerSpeechDelayTime;
    }

    public final ContinuousSpeechUIConfig copy(Boolean r2, Long r3) {
        return new ContinuousSpeechUIConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ContinuousSpeechUIConfig) == true) goto L8;
        return false;
    L8:
        ContinuousSpeechUIConfig r6 = (ContinuousSpeechUIConfig) r5;
        if (Intrinsics.areEqual(this.showSpeechOnLeft, r6.showSpeechOnLeft) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.triggerSpeechDelayTime, r6.triggerSpeechDelayTime) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.showSpeechOnLeft;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.triggerSpeechDelayTime;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ContinuousSpeechUIConfig(showSpeechOnLeft=" + this.showSpeechOnLeft + ", triggerSpeechDelayTime=" + this.triggerSpeechDelayTime + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Companion = new a();
        Boolean r2 = null;
        Object[] r3 = 0 == true ? 1 : 0;
        DEFAULT = new ContinuousSpeechUIConfig(r2, r3, 3, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ ContinuousSpeechUIConfig access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public final Boolean getShowSpeechOnLeft() {
        return this.showSpeechOnLeft;
    }

    public final Long getTriggerSpeechDelayTime() {
        return this.triggerSpeechDelayTime;
    }

    public ContinuousSpeechUIConfig(Boolean r1, Long r2) {
        this.showSpeechOnLeft = r1;
        this.triggerSpeechDelayTime = r2;
    }

    public /* synthetic */ ContinuousSpeechUIConfig(Boolean r1, Long r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Boolean.FALSE;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 0L;
    L8:
        this(r1, r2);
    }
}
