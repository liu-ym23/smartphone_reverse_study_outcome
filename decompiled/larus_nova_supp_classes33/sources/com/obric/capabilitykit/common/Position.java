package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016j\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/common/Position;", "", "Landroid/os/Parcelable;", "(Ljava/lang/String;I)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "TOP", "BOTTOM", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum Position extends Enum<Position> implements Parcelable {
    private static final /* synthetic */ Position[] $VALUES = null;
    public static final Position BOTTOM = null;
    public static final Parcelable.Creator<Position> CREATOR = null;
    public static final b Companion = null;
    public static final Position TOP = null;

    public static final class b {
        public b() {
        }
    }

    private static final /* synthetic */ Position[] $values() {
        return new Position[]{TOP, BOTTOM};
    }

    static {
        TOP = new Position("TOP", 0);
        BOTTOM = new Position("BOTTOM", 1);
        $VALUES = $values();
        Companion = new b();
        CREATOR = new a();
    }

    private Position(String r1, int r2) {
        super(r1, r2);
    }

    public static Position valueOf(String r1) {
        return (Position) r27.a.a(Position.class, r1);
    }

    public static Position[] values() {
        return (Position[]) $VALUES.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(name());
    }
}
