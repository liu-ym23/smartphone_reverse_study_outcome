package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/AppStateEvent;", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "state", "Lcom/obric/memorydata/sdk/screencapture/event/AppStateEvent$AppState;", "<init>", "(Lcom/obric/memorydata/sdk/screencapture/event/AppStateEvent$AppState;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getState", "()Lcom/obric/memorydata/sdk/screencapture/event/AppStateEvent$AppState;", "eventType", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "getEventType", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "writeToParcel", "", "flags", "", "toString", "", "component1", "copy", "equals", "", "other", "", "hashCode", "AppState", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppStateEvent extends ScreenEvent {
    private final ScreenEvent.EventType eventType;
    private final AppState state;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/AppStateEvent$AppState;", "", "<init>", "(Ljava/lang/String;I)V", "OPEN", "CLOSE", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum AppState extends Enum<AppState> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ AppState[] $VALUES = null;
        public static final AppState CLOSE = null;
        public static final AppState OPEN = null;

        private static final /* synthetic */ AppState[] $values() {
            return new AppState[]{OPEN, CLOSE};
        }

        static {
            OPEN = new AppState("OPEN", 0);
            CLOSE = new AppState("CLOSE", 1);
            AppState[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private AppState(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<AppState> getEntries() {
            return $ENTRIES;
        }

        public static AppState valueOf(String r2) {
            return (AppState) ZeusTransformUtils.preCheckCast(Enum.valueOf(AppState.class, r2), AppState.class, "com.obric.memorydata.plugin");
        }

        public static AppState[] values() {
            return (AppState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AppState[].class, "com.obric.memorydata.plugin");
        }
    }

    public AppStateEvent(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        this(AppState.values()[r2.readInt()]);
    }

    public AppStateEvent(AppState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        super(null);
        this.state = r2;
        this.eventType = ScreenEvent.EventType.APP_STATE;
    }

    public static /* synthetic */ AppStateEvent copy$default(AppStateEvent r0, AppState r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.state;
    L6:
        return r0.copy(r1);
    }

    public final AppState component1() {
        return this.state;
    }

    public final AppStateEvent copy(AppState r1) {
        Intrinsics.checkNotNullParameter(r1, "state");
        return new AppStateEvent(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppStateEvent.class) == true) goto L8;
        return false;
    L8:
        AppStateEvent r6 = (AppStateEvent) ZeusTransformUtils.preCheckCast(r5, AppStateEvent.class, "com.obric.memorydata.plugin");
        if (this.state == r6.state) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent
    public ScreenEvent.EventType getEventType() {
        return this.eventType;
    }

    public final AppState getState() {
        return this.state;
    }

    public int hashCode() {
        return this.state.hashCode();
    }

    public String toString() {
        return "AppStateEvent(state=" + this.state.name() + ", appName=" + getAppName() + ", pkgName=" + getPackageName() + ')';
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        super.writeToParcel(r2, r3);
        r2.writeInt(this.state.ordinal());
    }
}
