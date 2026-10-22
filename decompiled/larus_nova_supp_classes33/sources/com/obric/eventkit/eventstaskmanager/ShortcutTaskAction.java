package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0019\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001c\u0010\u001dB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\t\u0010\u0010\u001a\u00020\tHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskAction;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "", "component1", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "component2", MemorySourceLinkType.INTENT, "params", "copy", "toString", "hashCode", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "equals", "Ljava/lang/String;", "getIntent", "()Ljava/lang/String;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "getParams", "()Lcom/obric/capabilitykit/common/intent/IntentParams;", "<init>", "(Ljava/lang/String;Lcom/obric/capabilitykit/common/intent/IntentParams;)V", "(Landroid/os/Parcel;)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class ShortcutTaskAction implements Parcelable {
    public static final Parcelable.Creator<ShortcutTaskAction> CREATOR = null;
    public static final b Companion = null;
    private final String intent;
    private final IntentParams params;

    public static final class a implements Parcelable.Creator<ShortcutTaskAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShortcutTaskAction createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            Intrinsics.checkNotNullParameter(r6, "parcel");
            ShortcutTaskAction r1 = new ShortcutTaskAction(r6);
            int r2 = Math.min(r0, 0);
            ClassLoader r3 = a.class.getClassLoader();
            int r4 = 1;
        L3:
            if (r4 > r2) goto L5;
            r4 = r4 + 1;
        L5:
            if (r4 > r0) goto L7;
            joa.a.d(r6, r3);
            r4 = r4 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public final ShortcutTaskAction[] newArray(int r1) {
            return new ShortcutTaskAction[r1];
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
        CREATOR = new a();
    }

    public ShortcutTaskAction(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        this(TimerTaskKt.a(r3), r3.readParcelable(IntentParams.class.getClassLoader()));
    }

    public ShortcutTaskAction(String r2, IntentParams r3) {
        Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
        this.intent = r2;
        this.params = r3;
    }

    public static /* synthetic */ ShortcutTaskAction copy$default(ShortcutTaskAction r0, String r1, IntentParams r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.intent;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.params;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.intent;
    }

    public final IntentParams component2() {
        return this.params;
    }

    public final ShortcutTaskAction copy(String r2, IntentParams r3) {
        Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
        return new ShortcutTaskAction(r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ShortcutTaskAction) == true) goto L8;
        return false;
    L8:
        ShortcutTaskAction r6 = (ShortcutTaskAction) r5;
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
