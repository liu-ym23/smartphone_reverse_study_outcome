package androidx.room.vo;

import ai.j0;
import androidx.room.compiler.codegen.XCodeBlock;
import androidx.room.compiler.processing.XConstructorElement;
import androidx.room.compiler.processing.XElementKt;
import androidx.room.compiler.processing.XExecutableElement;
import androidx.room.compiler.processing.XMethodElement;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001fB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006 "}, d2 = {"Landroidx/room/vo/Constructor;", "", "element", "Landroidx/room/compiler/processing/XExecutableElement;", LynxResourceModule.PARAMS_KEY, "", "Landroidx/room/vo/Constructor$Param;", "(Landroidx/room/compiler/processing/XExecutableElement;Ljava/util/List;)V", "getElement", "()Landroidx/room/compiler/processing/XExecutableElement;", "getParams", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hasField", "field", "Landroidx/room/vo/Field;", "hashCode", "", "toString", "", "writeConstructor", "", "outVar", "args", "builder", "Landroidx/room/compiler/codegen/XCodeBlock$Builder;", "Param", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Constructor {
    private final XExecutableElement element;
    private final List<Param> params;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0082\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Landroidx/room/vo/Constructor$Param;", "", "()V", "log", "", "EmbeddedParam", "FieldParam", "RelationParam", "Landroidx/room/vo/Constructor$Param$EmbeddedParam;", "Landroidx/room/vo/Constructor$Param$FieldParam;", "Landroidx/room/vo/Constructor$Param$RelationParam;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class Param {

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/room/vo/Constructor$Param$EmbeddedParam;", "Landroidx/room/vo/Constructor$Param;", "embedded", "Landroidx/room/vo/EmbeddedField;", "(Landroidx/room/vo/EmbeddedField;)V", "getEmbedded", "()Landroidx/room/vo/EmbeddedField;", "log", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class EmbeddedParam extends Param {
            private final EmbeddedField embedded;

            public EmbeddedParam(EmbeddedField r5) {
                Intrinsics.checkNotNullParameter(r5, "embedded");
                super(null);
                this.embedded = r5;
            }

            public final EmbeddedField getEmbedded() {
                return this.embedded;
            }

            @Override // androidx.room.vo.Constructor.Param
            public String log() {
                return this.embedded.getField().getPath();
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/room/vo/Constructor$Param$FieldParam;", "Landroidx/room/vo/Constructor$Param;", "field", "Landroidx/room/vo/Field;", "(Landroidx/room/vo/Field;)V", "getField", "()Landroidx/room/vo/Field;", "log", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class FieldParam extends Param {
            private final Field field;

            public FieldParam(Field r5) {
                Intrinsics.checkNotNullParameter(r5, "field");
                super(null);
                this.field = r5;
            }

            public final Field getField() {
                return this.field;
            }

            @Override // androidx.room.vo.Constructor.Param
            public String log() {
                return this.field.getPath();
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/room/vo/Constructor$Param$RelationParam;", "Landroidx/room/vo/Constructor$Param;", "relation", "Landroidx/room/vo/Relation;", "(Landroidx/room/vo/Relation;)V", "getRelation", "()Landroidx/room/vo/Relation;", "log", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class RelationParam extends Param {
            private final Relation relation;

            public RelationParam(Relation r5) {
                Intrinsics.checkNotNullParameter(r5, "relation");
                super(null);
                this.relation = r5;
            }

            public final Relation getRelation() {
                return this.relation;
            }

            @Override // androidx.room.vo.Constructor.Param
            public String log() {
                return this.relation.getField().getPath();
            }
        }

        public /* synthetic */ Param(DefaultConstructorMarker r5) {
            this();
        }

        public abstract String log();

        private Param() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Constructor(XExecutableElement r5, List<? extends Param> r10) {
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        this.element = r5;
        this.params = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Constructor copy$default(Constructor r5, XExecutableElement r10, List r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.element;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.params;
    L9:
        return r5.copy(r10, r11);
    }

    public final XExecutableElement component1() {
        return this.element;
    }

    public final List<Param> component2() {
        return this.params;
    }

    public final Constructor copy(XExecutableElement r5, List<? extends Param> r10) {
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        return new Constructor(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Constructor) == true) goto L8;
        return false;
    L8:
        Constructor r10 = (Constructor) r5;
        if (Intrinsics.areEqual(this.element, r10.element) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r10.params) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final XExecutableElement getElement() {
        return this.element;
    }

    public final List<Param> getParams() {
        return this.params;
    }

    public final boolean hasField(Field r5) {
        Intrinsics.checkNotNullParameter(r5, "field");
        List<Param> r10 = this.params;
        if (r10 != null) goto L5;
    L7:
        Iterator<T> r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L42;
        Param r12 = (Param) r11.next();
        if ((r12 instanceof Param.FieldParam) == true) goto L13;
        if ((r12 instanceof Param.EmbeddedParam) == true) goto L18;
        if ((r12 instanceof Param.RelationParam) == false) goto L26;
        if (((Param.RelationParam) r12).getRelation().getField() != r5) goto L9;
    L24:
        return true;
    L26:
        throw new NoWhenBranchMatchedException();
    L18:
        if (((Param.EmbeddedParam) r12).getEmbedded().getField() != r5) goto L9;
    L13:
        if (((Param.FieldParam) r12).getField() != r5) goto L9;
    L42:
        return false;
    L5:
        if (r10.isEmpty() == false) goto L7;
        return false;
    }

    public int hashCode() {
        int r5 = this.element.hashCode() * 31;
        return this.params.hashCode() + r5;
    }

    public String toString() {
        return "Constructor(element=" + this.element + ", params=" + this.params + ")";
    }

    public final void writeConstructor(String r5, String r10, XCodeBlock.Builder r11) {
        Intrinsics.checkNotNullParameter(r5, "outVar");
        Intrinsics.checkNotNullParameter(r10, "args");
        Intrinsics.checkNotNullParameter(r11, "builder");
        if (XElementKt.isConstructor(this.element) == false) goto L6;
        r11.addStatement("%L = %L", new Object[]{r5, XCodeBlock.Companion.ofNewInstance(r11.getLanguage(), ((XConstructorElement) this.element).getEnclosingElement().asClassName(), r10, new Object[0])});
        return;
    L6:
        if (XElementKt.isMethod(this.element) == false) goto L10;
        r11.addStatement("%L = %T.%L(%L)", new Object[]{r5, this.element.getEnclosingElement().asClassName(), ((XMethodElement) this.element).getJvmName(), r10});
        return;
    L10:
        throw new IllegalStateException(j0.C("Invalid constructor kind ", this.element.kindName()));
    }
}
