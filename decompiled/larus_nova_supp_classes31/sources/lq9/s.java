package lq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/platform/model/audio/NoticeConfig;", "", "showTimeDuration", "", "delayTimeDuration", "<init>", "(II)V", "getShowTimeDuration", "()I", "getDelayTimeDuration", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class s {

    @SerializedName("delay_time")
    private final int delayTimeDuration;

    @SerializedName("show_time")
    private final int showTimeDuration;

    public s() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s) == true) goto L8;
        return false;
    L8:
        s r6 = (s) r5;
        if (this.showTimeDuration == r6.showTimeDuration) goto L12;
        return false;
    L12:
        if (this.delayTimeDuration == r6.delayTimeDuration) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.showTimeDuration * 31) + this.delayTimeDuration;
    }

    public final String toString() {
        return "NoticeConfig(showTimeDuration=" + this.showTimeDuration + ", delayTimeDuration=" + this.delayTimeDuration + ')';
    }

    public final int a() {
        return this.delayTimeDuration;
    }

    public final int b() {
        return this.showTimeDuration;
    }

    public s(int r1) {
        this.showTimeDuration = 10;
        this.delayTimeDuration = 5;
    }
}
