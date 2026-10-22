package androidx.room.vo;

import androidx.room.compiler.processing.XNullability;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0007J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0000HÆ\u0003J)\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0000HÆ\u0001J\u0013\u0010*\u001a\u00020\u00152\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\u0006\u0010.\u001a\u00020\u0015J\t\u0010/\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u000f\u001a\u0004\b#\u0010$¨\u00060"}, d2 = {"Landroidx/room/vo/EmbeddedField;", "", "field", "Landroidx/room/vo/Field;", "prefix", "", "parent", "(Landroidx/room/vo/Field;Ljava/lang/String;Landroidx/room/vo/EmbeddedField;)V", "getField", "()Landroidx/room/vo/Field;", "getter", "Landroidx/room/vo/FieldGetter;", "getGetter", "()Landroidx/room/vo/FieldGetter;", "getter$delegate", "Lkotlin/Lazy;", "mRootParent", "getMRootParent", "()Landroidx/room/vo/EmbeddedField;", "mRootParent$delegate", "nonNull", "", "getNonNull", "()Z", "getParent", "pojo", "Landroidx/room/vo/Pojo;", "getPojo", "()Landroidx/room/vo/Pojo;", "setPojo", "(Landroidx/room/vo/Pojo;)V", "getPrefix", "()Ljava/lang/String;", "setter", "Landroidx/room/vo/FieldSetter;", "getSetter", "()Landroidx/room/vo/FieldSetter;", "setter$delegate", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "isNonNullRecursively", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EmbeddedField {
    private final Field field;
    private final Lazy getter$delegate;
    private final Lazy mRootParent$delegate;
    private final boolean nonNull;
    private final EmbeddedField parent;
    public Pojo pojo;
    private final String prefix;
    private final Lazy setter$delegate;

    public EmbeddedField(Field r5, String r10, EmbeddedField r11) {
        Intrinsics.checkNotNullParameter(r5, "field");
        Intrinsics.checkNotNullParameter(r10, "prefix");
        this.field = r5;
        this.prefix = r10;
        this.parent = r11;
        this.getter$delegate = LazyKt.lazy(new EmbeddedField$getter$2(this));
        this.setter$delegate = LazyKt.lazy(new EmbeddedField$setter$2(this));
        if (r5.getType().getNullability() != XNullability.NONNULL) goto L5;
        boolean r12 = true;
    L6:
        this.nonNull = r12;
        this.mRootParent$delegate = LazyKt.lazy(new EmbeddedField$mRootParent$2(this));
        return;
    L5:
        r12 = false;
        goto L6
    }

    public static /* synthetic */ EmbeddedField copy$default(EmbeddedField r5, Field r10, String r11, EmbeddedField r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.field;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.prefix;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.parent;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final Field component1() {
        return this.field;
    }

    public final String component2() {
        return this.prefix;
    }

    public final EmbeddedField component3() {
        return this.parent;
    }

    public final EmbeddedField copy(Field r5, String r10, EmbeddedField r11) {
        Intrinsics.checkNotNullParameter(r5, "field");
        Intrinsics.checkNotNullParameter(r10, "prefix");
        return new EmbeddedField(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EmbeddedField) == true) goto L8;
        return false;
    L8:
        EmbeddedField r10 = (EmbeddedField) r5;
        if (Intrinsics.areEqual(this.field, r10.field) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.prefix, r10.prefix) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.parent, r10.parent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final Field getField() {
        return this.field;
    }

    public final FieldGetter getGetter() {
        return (FieldGetter) this.getter$delegate.getValue();
    }

    public final EmbeddedField getMRootParent() {
        return (EmbeddedField) this.mRootParent$delegate.getValue();
    }

    public final boolean getNonNull() {
        return this.nonNull;
    }

    public final EmbeddedField getParent() {
        return this.parent;
    }

    public final Pojo getPojo() {
        Pojo r5 = this.pojo;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pojo");
        return null;
    }

    public final String getPrefix() {
        return this.prefix;
    }

    public final FieldSetter getSetter() {
        return (FieldSetter) this.setter$delegate.getValue();
    }

    public int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(this.field.hashCode() * 31, 31, this.prefix);
        EmbeddedField r10 = this.parent;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return r5 + r11;
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    public final boolean isNonNullRecursively() {
        if (this.field.getNonNull() == false) goto L9;
        EmbeddedField r5 = this.parent;
        if (r5 != null) goto L7;
    L8:
        return true;
    L7:
        if (r5.isNonNullRecursively() == true) goto L8;
    L9:
        return false;
    }

    public final void setPojo(Pojo r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.pojo = r5;
    }

    public String toString() {
        return "EmbeddedField(field=" + this.field + ", prefix=" + this.prefix + ", parent=" + this.parent + ")";
    }

    public /* synthetic */ EmbeddedField(Field r5, String r10, EmbeddedField r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r10 = "";
    L5:
        this(r5, r10, r11);
    }
}
