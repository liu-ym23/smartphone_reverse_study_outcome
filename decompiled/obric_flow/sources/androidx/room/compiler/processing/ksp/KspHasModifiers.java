package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.XHasModifiers;
import il.c;
import il.d;
import il.g;
import il.k;
import il.l;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00122\u00020\u0001:\u0005\u0013\u0012\u0014\u0015\u0016B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0082\u0001\u0004\u0017\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspHasModifiers;", "Landroidx/room/compiler/processing/XHasModifiers;", "Lil/d;", "declaration", "<init>", "(Lil/d;)V", "", "isPublic", "()Z", "isProtected", "isAbstract", "isPrivate", "isStatic", "isTransient", "isFinal", "Lil/d;", "getDeclaration", "()Lil/d;", "Companion", "ClassDeclaration", "Declaration", "PropertyField", "PropertyFieldAccessor", "Landroidx/room/compiler/processing/ksp/KspHasModifiers$ClassDeclaration;", "Landroidx/room/compiler/processing/ksp/KspHasModifiers$Declaration;", "Landroidx/room/compiler/processing/ksp/KspHasModifiers$PropertyField;", "Landroidx/room/compiler/processing/ksp/KspHasModifiers$PropertyFieldAccessor;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KspHasModifiers implements XHasModifiers {
    public static final Companion Companion = null;
    private final d declaration;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspHasModifiers$ClassDeclaration;", "Landroidx/room/compiler/processing/ksp/KspHasModifiers;", "Lil/d;", "declaration", "<init>", "(Lil/d;)V", "", "isStatic", "()Z", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ClassDeclaration extends KspHasModifiers {
        public ClassDeclaration(d r5) {
            Intrinsics.checkNotNullParameter(r5, "declaration");
            super(r5, null);
        }

        @Override // androidx.room.compiler.processing.ksp.KspHasModifiers, androidx.room.compiler.processing.XHasModifiers
        public boolean isStatic() {
            getDeclaration();
            if (KSDeclarationExtKt.isStatic(null) == false) goto L6;
            return true;
        L6:
            getDeclaration();
            throw null;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u000fJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0010¢\u0006\u0004\b\f\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspHasModifiers$Companion;", "", "<init>", "()V", "Lil/l;", "property", "Lil/k;", "accessor", "Landroidx/room/compiler/processing/XHasModifiers;", "createForSyntheticAccessor", "(Lil/l;Lil/k;)Landroidx/room/compiler/processing/XHasModifiers;", "owner", "create", "(Lil/l;)Landroidx/room/compiler/processing/XHasModifiers;", "Lil/g;", "(Lil/g;)Landroidx/room/compiler/processing/XHasModifiers;", "Lil/c;", "(Lil/c;)Landroidx/room/compiler/processing/XHasModifiers;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final XHasModifiers create(l r5) {
            Intrinsics.checkNotNullParameter(r5, "owner");
            return new PropertyField(r5);
        }

        public final XHasModifiers createForSyntheticAccessor(l r5, k r10) {
            Intrinsics.checkNotNullParameter(r5, "property");
            if (r10 == null) goto L7;
            return new PropertyFieldAccessor(r10);
        L7:
            return new Declaration(r5);
        }

        private Companion() {
        }

        public final XHasModifiers create(g r5) {
            Intrinsics.checkNotNullParameter(r5, "owner");
            return new Declaration(r5);
        }

        public final XHasModifiers create(c r5) {
            Intrinsics.checkNotNullParameter(r5, "owner");
            return new ClassDeclaration(r5);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspHasModifiers$Declaration;", "Landroidx/room/compiler/processing/ksp/KspHasModifiers;", "Lil/d;", "declaration", "<init>", "(Lil/d;)V", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Declaration extends KspHasModifiers {
        public Declaration(d r5) {
            Intrinsics.checkNotNullParameter(r5, "declaration");
            super(r5, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\bR\u001b\u0010\u000e\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\b¨\u0006\u000f"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspHasModifiers$PropertyField;", "Landroidx/room/compiler/processing/ksp/KspHasModifiers;", "Lil/l;", "declaration", "<init>", "(Lil/l;)V", "", "isPublic", "()Z", "isProtected", "isPrivate", "acceptDeclarationModifiers$delegate", "Lkotlin/Lazy;", "getAcceptDeclarationModifiers", "acceptDeclarationModifiers", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PropertyField extends KspHasModifiers {
        private final Lazy acceptDeclarationModifiers$delegate;

        public PropertyField(final l r5) {
            Intrinsics.checkNotNullParameter(r5, "declaration");
            super(r5, null);
            this.acceptDeclarationModifiers$delegate = LazyKt.lazy(new KspHasModifiers$PropertyField$acceptDeclarationModifiers$2(r5));
        }

        private final boolean getAcceptDeclarationModifiers() {
            return ((Boolean) this.acceptDeclarationModifiers$delegate.getValue()).booleanValue();
        }

        @Override // androidx.room.compiler.processing.ksp.KspHasModifiers, androidx.room.compiler.processing.XHasModifiers
        public boolean isPrivate() {
            if (getAcceptDeclarationModifiers() == true) goto L7;
            return true;
        L7:
            return super.isPrivate();
        }

        @Override // androidx.room.compiler.processing.ksp.KspHasModifiers, androidx.room.compiler.processing.XHasModifiers
        public boolean isProtected() {
            if (getAcceptDeclarationModifiers() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.isProtected() == false) goto L7;
            return true;
        }

        @Override // androidx.room.compiler.processing.ksp.KspHasModifiers, androidx.room.compiler.processing.XHasModifiers
        public boolean isPublic() {
            if (getAcceptDeclarationModifiers() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.isPublic() == false) goto L7;
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspHasModifiers$PropertyFieldAccessor;", "Landroidx/room/compiler/processing/ksp/KspHasModifiers;", "Lil/k;", "accessor", "<init>", "(Lil/k;)V", "", "isPublic", "()Z", "isProtected", "isPrivate", "Lil/k;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PropertyFieldAccessor extends KspHasModifiers {
        private final k accessor;

        /* JADX WARN: Multi-variable type inference failed */
        public PropertyFieldAccessor(k r5) {
            Intrinsics.checkNotNullParameter(r5, "accessor");
            r5.i();
            super(null, 0 == true ? 1 : 0);
        }

        @Override // androidx.room.compiler.processing.ksp.KspHasModifiers, androidx.room.compiler.processing.XHasModifiers
        public boolean isPrivate() {
            throw null;
        }

        @Override // androidx.room.compiler.processing.ksp.KspHasModifiers, androidx.room.compiler.processing.XHasModifiers
        public boolean isProtected() {
            throw null;
        }

        @Override // androidx.room.compiler.processing.ksp.KspHasModifiers, androidx.room.compiler.processing.XHasModifiers
        public boolean isPublic() {
            throw null;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ KspHasModifiers(d r5, DefaultConstructorMarker r10) {
        this(r5);
    }

    public final d getDeclaration() {
        return null;
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isAbstract() {
        throw null;
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isFinal() {
        com.google.devtools.ksp.a.b();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isPrivate() {
        Intrinsics.checkNotNullParameter(null, "<this>");
        throw null;
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isProtected() {
        Intrinsics.checkNotNullParameter(null, "<this>");
        com.google.devtools.ksp.a.a();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isPublic() {
        com.google.devtools.ksp.a.a();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isStatic() {
        return KSDeclarationExtKt.isStatic(null);
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isTransient() {
        return KSDeclarationExtKt.isTransient(null);
    }

    private KspHasModifiers(d r5) {
    }
}
