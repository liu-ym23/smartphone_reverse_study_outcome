package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/InputMethodEvent;", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "visible", "", "<init>", "(Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getVisible", "()Z", "eventType", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "getEventType", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "writeToParcel", "", "flags", "", "component1", "copy", "equals", "other", "", "hashCode", "toString", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InputMethodEvent extends ScreenEvent {
    private final ScreenEvent.EventType eventType;
    private final boolean visible;

    public InputMethodEvent(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        if (r2.readByte() == 0) goto L5;
        boolean r3 = true;
    L6:
        this(r3);
        return;
    L5:
        r3 = false;
        goto L6
    }

    public InputMethodEvent(boolean r2) {
        super(null);
        this.visible = r2;
        this.eventType = ScreenEvent.EventType.INPUT_METHOD;
    }

    public static /* synthetic */ InputMethodEvent copy$default(InputMethodEvent r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.visible;
    L6:
        return r0.copy(r1);
    }

    public final boolean component1() {
        return this.visible;
    }

    public final InputMethodEvent copy(boolean r1) {
        return new InputMethodEvent(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, InputMethodEvent.class) == true) goto L8;
        return false;
    L8:
        InputMethodEvent r6 = (InputMethodEvent) ZeusTransformUtils.preCheckCast(r5, InputMethodEvent.class, "com.obric.memorydata.plugin");
        if (this.visible == r6.visible) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent
    public ScreenEvent.EventType getEventType() {
        return this.eventType;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        return Boolean.hashCode(this.visible);
    }

    public String toString() {
        return "InputMethodEvent(visible=" + this.visible + ')';
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        super.writeToParcel(r2, r3);
        r2.writeByte(this.visible ? 1 : 0);
    }
}
