package rc8;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJJ\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0016\u0010\r¨\u0006#"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/datasource/BubbleBannerRawPolicy;", "", "showTiming", "", "dismissTiming", "autoDismissSeconds", "", "keepOnLeave", "", "clickDismissBehavior", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getShowTiming", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDismissTiming", "getAutoDismissSeconds", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getKeepOnLeave", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getClickDismissBehavior", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/bubble/floating/datasource/BubbleBannerRawPolicy;", "equals", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class f {

    @SerializedName("auto_dismiss_seconds")
    private final Long autoDismissSeconds;

    @SerializedName("click_dismiss_behavior")
    private final Integer clickDismissBehavior;

    @SerializedName("dismiss_timing")
    private final Integer dismissTiming;

    @SerializedName("keep_on_leave")
    private final Boolean keepOnLeave;

    @SerializedName("show_timing")
    private final Integer showTiming;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.showTiming, r6.showTiming) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dismissTiming, r6.dismissTiming) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.autoDismissSeconds, r6.autoDismissSeconds) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.keepOnLeave, r6.keepOnLeave) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.clickDismissBehavior, r6.clickDismissBehavior) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.showTiming;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.dismissTiming;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.autoDismissSeconds;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.keepOnLeave;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.clickDismissBehavior;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "BubbleBannerRawPolicy(showTiming=" + this.showTiming + ", dismissTiming=" + this.dismissTiming + ", autoDismissSeconds=" + this.autoDismissSeconds + ", keepOnLeave=" + this.keepOnLeave + ", clickDismissBehavior=" + this.clickDismissBehavior + ')';
    }

    public f() {
        this.showTiming = null;
        this.dismissTiming = null;
        this.autoDismissSeconds = null;
        this.keepOnLeave = null;
        this.clickDismissBehavior = null;
    }

    public final Long a() {
        return this.autoDismissSeconds;
    }

    public final Integer b() {
        return this.clickDismissBehavior;
    }

    public final Integer c() {
        return this.dismissTiming;
    }

    public final Boolean d() {
        return this.keepOnLeave;
    }

    public final Integer e() {
        return this.showTiming;
    }
}
