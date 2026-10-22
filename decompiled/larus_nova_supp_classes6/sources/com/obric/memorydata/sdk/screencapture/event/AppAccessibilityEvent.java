package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.memorydata.sdk.screencapture.rule.AppAccessibilityEventRule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0012HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/AppAccessibilityEvent;", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "accessibilityRule", "Lcom/obric/memorydata/sdk/screencapture/rule/AppAccessibilityEventRule;", "<init>", "(Lcom/obric/memorydata/sdk/screencapture/rule/AppAccessibilityEventRule;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAccessibilityRule", "()Lcom/obric/memorydata/sdk/screencapture/rule/AppAccessibilityEventRule;", "eventType", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "getEventType", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "writeToParcel", "", "flags", "", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class AppAccessibilityEvent extends ScreenEvent {
    public final AppAccessibilityEventRule d;
    public final ScreenEvent.EventType e;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof AppAccessibilityEvent) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.d, ((AppAccessibilityEvent) r4).d) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final String toString() {
        return "AppAccessibilityEvent(accessibilityRule=" + this.d + ')';
    }

    public final int hashCode() {
        this.d.getClass();
        throw null;
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent
    public final ScreenEvent.EventType a() {
        return this.e;
    }

    public AppAccessibilityEvent(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        Parcelable r3 = r2.readParcelable(ScreenEvent.class.getClassLoader());
        Intrinsics.checkNotNull(r3);
        AppAccessibilityEventRule r4 = (AppAccessibilityEventRule) r3;
        Intrinsics.checkNotNullParameter(r4, "accessibilityRule");
        this.d = r4;
        this.e = ScreenEvent.EventType.ACCESSIBILITY;
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent, android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        super.writeToParcel(r2, r3);
        r2.writeParcelable(this.d, r3);
    }
}
