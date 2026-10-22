package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.meta.MetaType;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J'\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0010¢\u0006\u0002\b\u0018J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/obric/capabilitykit/entity/app/Preview;", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "vid", "", "(Ljava/lang/String;)V", "getVid", "()Ljava/lang/String;", "setVid", "component1", "copy", "equals", "", "other", "", "hashCode", "", "onReadMetaValueExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "onReadMetaValueExtensionField$capabilitykitcommon_release", "toString", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class Preview extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private String vid;

    static {
        CREATOR = new CREATOR(null);
    }

    public Preview(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        this(EntityExtKt.e(r3));
        readMetaValueExtensionField$capabilitykitcommon_release(r3, 0, r3.readInt());
    }

    public Preview(String r2) {
        Intrinsics.checkNotNullParameter(r2, "vid");
        super(MetaType.Preview);
        this.vid = r2;
    }

    public static /* synthetic */ Preview copy$default(Preview r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.vid;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.vid;
    }

    public final Preview copy(String r2) {
        Intrinsics.checkNotNullParameter(r2, "vid");
        return new Preview(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof Preview) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.vid, ((Preview) r4).vid) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final String getVid() {
        return this.vid;
    }

    public int hashCode() {
        return this.vid.hashCode();
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public final void setVid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.vid = r2;
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "Preview(vid=" + this.vid + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.vid);
        r1.writeInt(0);
    }
}
