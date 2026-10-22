package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskAction;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", MemorySourceLinkType.INTENT, "", TrackerImpl.PARAMS, "Lcom/obric/capabilitykit/common/intent/IntentParams;", "(Ljava/lang/String;Lcom/obric/capabilitykit/common/intent/IntentParams;)V", "getIntent", "()Ljava/lang/String;", "getParams", "()Lcom/obric/capabilitykit/common/intent/IntentParams;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "Companion", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ShortcutTaskAction implements Parcelable {
    public static final Parcelable.Creator<ShortcutTaskAction> CREATOR = null;
    public static final a Companion = null;
    private final String intent;
    private final IntentParams params;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskAction$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskAction;", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/obric/eventkit/eventstaskmanager/ShortcutTaskAction$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskAction;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskAction;", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements Parcelable.Creator<ShortcutTaskAction> {
        public b() {
        }

        public ShortcutTaskAction a(Parcel r5) {
            int r4 = r5.readInt();
            Intrinsics.checkNotNullParameter(r5, "parcel");
            ShortcutTaskAction r0 = new ShortcutTaskAction(r5);
            int r1 = Math.min(r4, 0);
            ClassLoader r2 = b.class.getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r1) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r4) goto L7;
            com.obric.b.a.a(r5, r2);
            r3 = r3 + 1;
            goto L5
        L7:
            return r0;
        }

        public ShortcutTaskAction[] a(int r1) {
            return new ShortcutTaskAction[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ShortcutTaskAction createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ShortcutTaskAction[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        Companion = new a(null);
        CREATOR = new b();
    }

    public ShortcutTaskAction(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        this(j.a(r4), (IntentParams) ZeusTransformUtils.preCheckCast(r4.readParcelable(IntentParams.class.getClassLoader()), IntentParams.class, "com.obric.memorydata.plugin"));
    }

    public ShortcutTaskAction(String r3, IntentParams r4) {
        IntentParams r5 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r4, IntentParams.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        this.intent = r3;
        this.params = r5;
    }

    public static /* synthetic */ ShortcutTaskAction copy$default(ShortcutTaskAction r1, String r2, IntentParams r3, int r4, Object r5) {
        IntentParams r6 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r3, IntentParams.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.intent;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = r1.params;
    L9:
        return r1.copy(r2, r6);
    }

    public final String component1() {
        return this.intent;
    }

    public final IntentParams component2() {
        return this.params;
    }

    public final ShortcutTaskAction copy(String r2, IntentParams r3) {
        IntentParams r1 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r3, IntentParams.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
        return new ShortcutTaskAction(r2, r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ShortcutTaskAction.class) == true) goto L8;
        return false;
    L8:
        ShortcutTaskAction r6 = (ShortcutTaskAction) ZeusTransformUtils.preCheckCast(r5, ShortcutTaskAction.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.intent, r6.intent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r6.params) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getIntent() {
        return this.intent;
    }

    public final IntentParams getParams() {
        return this.params;
    }

    public int hashCode() {
        int r0 = this.intent.hashCode() * 31;
        IntentParams r1 = this.params;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ShortcutTaskAction(intent=" + this.intent + ", params=" + this.params + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(0);
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeString(this.intent);
        r2.writeParcelable(this.params, r3);
    }
}
