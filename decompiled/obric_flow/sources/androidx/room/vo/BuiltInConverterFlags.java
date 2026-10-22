package androidx.room.vo;

import androidx.room.BuiltInTypeConverters;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0016"}, d2 = {"Landroidx/room/vo/BuiltInConverterFlags;", "", "enums", "Landroidx/room/BuiltInTypeConverters$State;", "uuid", "(Landroidx/room/BuiltInTypeConverters$State;Landroidx/room/BuiltInTypeConverters$State;)V", "getEnums", "()Landroidx/room/BuiltInTypeConverters$State;", "getUuid", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "withNext", "next", "Companion", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BuiltInConverterFlags {
    public static final Companion Companion = null;
    private static final BuiltInConverterFlags DEFAULT = null;
    private final BuiltInTypeConverters.State enums;
    private final BuiltInTypeConverters.State uuid;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/vo/BuiltInConverterFlags$Companion;", "", "()V", "DEFAULT", "Landroidx/room/vo/BuiltInConverterFlags;", "getDEFAULT", "()Landroidx/room/vo/BuiltInConverterFlags;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final BuiltInConverterFlags getDEFAULT() {
            return BuiltInConverterFlags.access$getDEFAULT$cp();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        BuiltInTypeConverters.State r5 = BuiltInTypeConverters.State.INHERITED;
        DEFAULT = new BuiltInConverterFlags(r5, r5);
    }

    public BuiltInConverterFlags(BuiltInTypeConverters.State r5, BuiltInTypeConverters.State r10) {
        Intrinsics.checkNotNullParameter(r5, "enums");
        Intrinsics.checkNotNullParameter(r10, "uuid");
        this.enums = r5;
        this.uuid = r10;
    }

    public static final /* synthetic */ BuiltInConverterFlags access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public static /* synthetic */ BuiltInConverterFlags copy$default(BuiltInConverterFlags r5, BuiltInTypeConverters.State r10, BuiltInTypeConverters.State r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.enums;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.uuid;
    L9:
        return r5.copy(r10, r11);
    }

    public final BuiltInTypeConverters.State component1() {
        return this.enums;
    }

    public final BuiltInTypeConverters.State component2() {
        return this.uuid;
    }

    public final BuiltInConverterFlags copy(BuiltInTypeConverters.State r5, BuiltInTypeConverters.State r10) {
        Intrinsics.checkNotNullParameter(r5, "enums");
        Intrinsics.checkNotNullParameter(r10, "uuid");
        return new BuiltInConverterFlags(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BuiltInConverterFlags) == true) goto L8;
        return false;
    L8:
        BuiltInConverterFlags r10 = (BuiltInConverterFlags) r5;
        if (this.enums == r10.enums) goto L12;
        return false;
    L12:
        if (this.uuid == r10.uuid) goto L14;
        return false;
    L14:
        return true;
    }

    public final BuiltInTypeConverters.State getEnums() {
        return this.enums;
    }

    public final BuiltInTypeConverters.State getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        int r5 = this.enums.hashCode() * 31;
        return this.uuid.hashCode() + r5;
    }

    public String toString() {
        return "BuiltInConverterFlags(enums=" + this.enums + ", uuid=" + this.uuid + ")";
    }

    public final BuiltInConverterFlags withNext(BuiltInConverterFlags r5) {
        Intrinsics.checkNotNullParameter(r5, "next");
        return new BuiltInConverterFlags(BuiltInConverterFlagsKt.access$plus(this.enums, r5.enums), BuiltInConverterFlagsKt.access$plus(this.uuid, r5.uuid));
    }
}
