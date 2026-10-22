package com.obric.memorydata.sdk.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0001-BW\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003Jg\u0010\u001f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nHÆ\u0001J\u0006\u0010 \u001a\u00020!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020!HÖ\u0001J\t\u0010'\u001a\u00020\nHÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020!R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015¨\u0006."}, d2 = {"Lcom/obric/memorydata/sdk/realtime/RealTimeContext;", "Landroid/os/Parcelable;", "screenMetaValue", "", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "appEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "referenceAppEntities", "referenceMetaValue", "curTopAppPackageName", "", "curTopAppName", "curTopActivityName", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getScreenMetaValue", "()Ljava/util/List;", "getAppEntities", "getReferenceAppEntities", "getReferenceMetaValue", "getCurTopAppPackageName", "()Ljava/lang/String;", "getCurTopAppName", "getCurTopActivityName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class RealTimeContext implements Parcelable {
    public static final Parcelable.Creator<RealTimeContext> CREATOR = null;
    public final List<MetaValue> a;
    public final List<AppEntity> b;
    public final List<AppEntity> c;
    public final List<MetaValue> d;
    public final String e;
    public final String f;
    public final String g;

    public static final class a {
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RealTimeContext) == true) goto L8;
        return false;
    L8:
        RealTimeContext r6 = (RealTimeContext) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public final String toString() {
        return "RealTimeContext(screenMetaValue=" + this.a + ", appEntities=" + this.b + ", referenceAppEntities=" + this.c + ", referenceMetaValue=" + this.d + ", curTopAppPackageName=" + this.e + ", curTopAppName=" + this.f + ", curTopActivityName=" + this.g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        List<MetaValue> r0 = this.a;
        r3.writeInt(r0.size());
        Iterator<MetaValue> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r3.writeParcelable(r1.next(), r4);
        goto L4
    L6:
        List<AppEntity> r2 = this.b;
        r3.writeInt(r2.size());
        Iterator<AppEntity> r5 = r2.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        r3.writeParcelable(r5.next(), r4);
        goto L8
    L10:
        List<AppEntity> r6 = this.c;
        r3.writeInt(r6.size());
        Iterator<AppEntity> r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        r3.writeParcelable(r7.next(), r4);
        goto L12
    L14:
        List<MetaValue> r8 = this.d;
        r3.writeInt(r8.size());
        Iterator<MetaValue> r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        r3.writeParcelable(r9.next(), r4);
        goto L16
    L18:
        r3.writeString(this.e);
        r3.writeString(this.f);
        r3.writeString(this.g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RealTimeContext(List<? extends MetaValue> r2, List<? extends AppEntity> r3, List<? extends AppEntity> r4, List<? extends MetaValue> r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "screenMetaValue");
        Intrinsics.checkNotNullParameter(r3, "appEntities");
        Intrinsics.checkNotNullParameter(r4, "referenceAppEntities");
        Intrinsics.checkNotNullParameter(r5, "referenceMetaValue");
        Intrinsics.checkNotNullParameter(r6, "curTopAppPackageName");
        Intrinsics.checkNotNullParameter(r7, "curTopAppName");
        Intrinsics.checkNotNullParameter(r8, "curTopActivityName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
