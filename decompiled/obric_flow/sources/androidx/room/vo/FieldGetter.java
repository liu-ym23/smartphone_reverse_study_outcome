package androidx.room.vo;

import androidx.room.compiler.codegen.XCodeBlock;
import androidx.room.compiler.processing.XType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Landroidx/room/vo/FieldGetter;", "", "jvmName", "", "type", "Landroidx/room/compiler/processing/XType;", "callType", "Landroidx/room/vo/CallType;", "(Ljava/lang/String;Landroidx/room/compiler/processing/XType;Landroidx/room/vo/CallType;)V", "getCallType", "()Landroidx/room/vo/CallType;", "getJvmName", "()Ljava/lang/String;", "getType", "()Landroidx/room/compiler/processing/XType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "writeGet", "", "ownerVar", "outVar", "builder", "Landroidx/room/compiler/codegen/XCodeBlock$Builder;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FieldGetter {
    private final CallType callType;
    private final String jvmName;
    private final XType type;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[CallType.values().length];
            r5[CallType.FIELD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[CallType.METHOD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[CallType.CONSTRUCTOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public FieldGetter(String r5, XType r10, CallType r11) {
        Intrinsics.checkNotNullParameter(r5, "jvmName");
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "callType");
        this.jvmName = r5;
        this.type = r10;
        this.callType = r11;
    }

    public static /* synthetic */ FieldGetter copy$default(FieldGetter r5, String r10, XType r11, CallType r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.jvmName;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.type;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.callType;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final String component1() {
        return this.jvmName;
    }

    public final XType component2() {
        return this.type;
    }

    public final CallType component3() {
        return this.callType;
    }

    public final FieldGetter copy(String r5, XType r10, CallType r11) {
        Intrinsics.checkNotNullParameter(r5, "jvmName");
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "callType");
        return new FieldGetter(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FieldGetter) == true) goto L8;
        return false;
    L8:
        FieldGetter r10 = (FieldGetter) r5;
        if (Intrinsics.areEqual(this.jvmName, r10.jvmName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r10.type) == true) goto L15;
        return false;
    L15:
        if (this.callType == r10.callType) goto L17;
        return false;
    L17:
        return true;
    }

    public final CallType getCallType() {
        return this.callType;
    }

    public final String getJvmName() {
        return this.jvmName;
    }

    public final XType getType() {
        return this.type;
    }

    public int hashCode() {
        int r5 = this.jvmName.hashCode() * 31;
        int r10 = (this.type.hashCode() + r5) * 31;
        return this.callType.hashCode() + r10;
    }

    public String toString() {
        return "FieldGetter(jvmName=" + this.jvmName + ", type=" + this.type + ", callType=" + this.callType + ")";
    }

    public final void writeGet(String r10, String r11, XCodeBlock.Builder r12) {
        Intrinsics.checkNotNullParameter(r10, "ownerVar");
        Intrinsics.checkNotNullParameter(r11, "outVar");
        Intrinsics.checkNotNullParameter(r12, "builder");
        CallType r5 = this.callType;
        int r13 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r13 != 1) goto L5;
        String r14 = "%L.%L";
    L13:
        if (r14 == null) goto L16;
        XCodeBlock.Builder.addLocalVariable$default(r12, r11, this.type.asTypeName(), false, XCodeBlock.Companion.of(r12.getLanguage(), r14, new Object[]{r10, this.jvmName}), 4, null);
        return;
    L16:
        return;
    L5:
        if (r13 != 2) goto L7;
        r14 = "%L.%L()";
        goto L13
    L7:
        if (r13 != 3) goto L10;
        r14 = null;
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
