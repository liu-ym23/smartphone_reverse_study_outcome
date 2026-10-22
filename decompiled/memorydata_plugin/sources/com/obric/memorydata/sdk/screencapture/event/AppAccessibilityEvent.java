package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.memorydata.sdk.screencapture.rule.AppAccessibilityEventRule;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0012HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/AppAccessibilityEvent;", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "accessibilityRule", "Lcom/obric/memorydata/sdk/screencapture/rule/AppAccessibilityEventRule;", "<init>", "(Lcom/obric/memorydata/sdk/screencapture/rule/AppAccessibilityEventRule;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAccessibilityRule", "()Lcom/obric/memorydata/sdk/screencapture/rule/AppAccessibilityEventRule;", "eventType", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "getEventType", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "writeToParcel", "", "flags", "", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppAccessibilityEvent extends ScreenEvent {
    private final AppAccessibilityEventRule accessibilityRule;
    private final ScreenEvent.EventType eventType;

    public AppAccessibilityEvent(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        Parcelable r4 = r3.readParcelable(ScreenEvent.class.getClassLoader());
        Intrinsics.checkNotNull(r4);
        this((AppAccessibilityEventRule) ZeusTransformUtils.preCheckCast(r4, AppAccessibilityEventRule.class, "com.obric.memorydata.plugin"));
    }

    public AppAccessibilityEvent(AppAccessibilityEventRule r2) {
        Intrinsics.checkNotNullParameter(r2, "accessibilityRule");
        super(null);
        this.accessibilityRule = r2;
        this.eventType = ScreenEvent.EventType.ACCESSIBILITY;
    }

    public static /* synthetic */ AppAccessibilityEvent copy$default(AppAccessibilityEvent r0, AppAccessibilityEventRule r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.accessibilityRule;
    L6:
        return r0.copy(r1);
    }

    public final AppAccessibilityEventRule component1() {
        return this.accessibilityRule;
    }

    public final AppAccessibilityEvent copy(AppAccessibilityEventRule r1) {
        Intrinsics.checkNotNullParameter(r1, "accessibilityRule");
        return new AppAccessibilityEvent(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppAccessibilityEvent.class) == true) goto L8;
        return false;
    L8:
        AppAccessibilityEvent r6 = (AppAccessibilityEvent) ZeusTransformUtils.preCheckCast(r5, AppAccessibilityEvent.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.accessibilityRule, r6.accessibilityRule) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final AppAccessibilityEventRule getAccessibilityRule() {
        return this.accessibilityRule;
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent
    public ScreenEvent.EventType getEventType() {
        return this.eventType;
    }

    public int hashCode() {
        return this.accessibilityRule.hashCode();
    }

    public String toString() {
        return "AppAccessibilityEvent(accessibilityRule=" + this.accessibilityRule + ')';
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent, android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        super.writeToParcel(r3, r4);
        r3.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.accessibilityRule, Parcelable.class, "com.obric.memorydata.plugin"), r4);
    }
}
