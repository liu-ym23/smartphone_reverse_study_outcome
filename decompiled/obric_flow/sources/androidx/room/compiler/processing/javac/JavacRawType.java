package androidx.room.compiler.processing.javac;

import androidx.room.compiler.codegen.XTypeName;
import androidx.room.compiler.processing.XRawType;
import com.squareup.javapoet.x;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Types;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\n \u0019*\u0004\u0018\u00010\u001c0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001f\u0010%\u001a\u00060\u001fj\u0002` 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010(\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010\n¨\u0006)"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacRawType;", "Landroidx/room/compiler/processing/XRawType;", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "env", "Landroidx/room/compiler/processing/javac/JavacType;", "original", "<init>", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Landroidx/room/compiler/processing/javac/JavacType;)V", "Landroidx/room/compiler/codegen/XTypeName;", "asTypeName", "()Landroidx/room/compiler/codegen/XTypeName;", "other", "", "isAssignableFrom", "(Landroidx/room/compiler/processing/XRawType;)Z", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljavax/lang/model/type/TypeMirror;", "kotlin.jvm.PlatformType", "erased", "Ljavax/lang/model/type/TypeMirror;", "Ljavax/lang/model/util/Types;", "typeUtils", "Ljavax/lang/model/util/Types;", "Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/javapoet/JTypeName;", "typeName$delegate", "Lkotlin/Lazy;", "getTypeName", "()Lcom/squareup/javapoet/x;", "typeName", "xTypeName$delegate", "getXTypeName", "xTypeName", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavacRawType implements XRawType {
    private final TypeMirror erased;
    private final Lazy typeName$delegate;
    private final Types typeUtils;
    private final Lazy xTypeName$delegate;

    public JavacRawType(JavacProcessingEnv r5, final JavacType r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "original");
        this.erased = r5.getTypeUtils().erasure(r10.mo55getTypeMirror());
        this.typeUtils = r5.getDelegate().getTypeUtils();
        this.typeName$delegate = LazyKt.lazy(new JavacRawType$typeName$2(this));
        this.xTypeName$delegate = LazyKt.lazy(new JavacRawType$xTypeName$2(this, r10));
    }

    public static final /* synthetic */ TypeMirror access$getErased$p(JavacRawType r5) {
        return r5.erased;
    }

    public static final /* synthetic */ XTypeName access$getXTypeName(JavacRawType r5) {
        return r5.getXTypeName();
    }

    private final XTypeName getXTypeName() {
        return (XTypeName) this.xTypeName$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XRawType
    public XTypeName asTypeName() {
        return getXTypeName();
    }

    public boolean equals(Object r5) {
        if (this == r5) goto L13;
        XTypeName r10 = getXTypeName();
        XTypeName r11 = null;
        if ((r5 instanceof XRawType) == false) goto L6;
        XRawType r12 = (XRawType) r5;
    L7:
        if (r12 == null) goto L10;
        r11 = r12.asTypeName();
    L10:
        if (Intrinsics.areEqual(r10, r11) == true) goto L13;
        return false;
    L6:
        r12 = null;
    L13:
        return true;
    }

    @Override // androidx.room.compiler.processing.XRawType
    public x getTypeName() {
        return (x) this.typeName$delegate.getValue();
    }

    public int hashCode() {
        return getXTypeName().hashCode();
    }

    @Override // androidx.room.compiler.processing.XRawType
    public boolean isAssignableFrom(XRawType r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if ((r5 instanceof JavacRawType) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.typeUtils.isAssignable(((JavacRawType) r5).erased, this.erased) == false) goto L7;
        return true;
    }

    public String toString() {
        return getXTypeName().getJava$room_compiler_processing().toString();
    }
}
