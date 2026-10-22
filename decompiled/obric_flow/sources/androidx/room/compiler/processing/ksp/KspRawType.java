package androidx.room.compiler.processing.ksp;

import ai.j0;
import androidx.room.compiler.codegen.XTypeName;
import androidx.room.compiler.processing.XRawType;
import com.squareup.javapoet.x;
import il.p;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\"\u001a\u00060\u001dj\u0002`\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010!R\u001b\u0010%\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\b¨\u0006&"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspRawType;", "Landroidx/room/compiler/processing/XRawType;", "Landroidx/room/compiler/processing/ksp/KspType;", "original", "<init>", "(Landroidx/room/compiler/processing/ksp/KspType;)V", "Landroidx/room/compiler/codegen/XTypeName;", "asTypeName", "()Landroidx/room/compiler/codegen/XTypeName;", "other", "", "isAssignableFrom", "(Landroidx/room/compiler/processing/XRawType;)Z", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroidx/room/compiler/processing/ksp/KspType;", "Lil/p;", "ksType$delegate", "Lkotlin/Lazy;", "getKsType", "()Lil/p;", "ksType", "Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/javapoet/JTypeName;", "typeName$delegate", "getTypeName", "()Lcom/squareup/javapoet/x;", "typeName", "xTypeName$delegate", "getXTypeName", "xTypeName", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspRawType implements XRawType {
    private final Lazy ksType$delegate;
    private final KspType original;
    private final Lazy typeName$delegate;
    private final Lazy xTypeName$delegate;

    public KspRawType(KspType r5) {
        Intrinsics.checkNotNullParameter(r5, "original");
        this.original = r5;
        this.ksType$delegate = LazyKt.lazy(new KspRawType$ksType$2(this));
        this.typeName$delegate = LazyKt.lazy(new KspRawType$typeName$2(this));
        this.xTypeName$delegate = LazyKt.lazy(new KspRawType$xTypeName$2(this));
    }

    public static final /* synthetic */ KspType access$getOriginal$p(KspRawType r5) {
        return r5.original;
    }

    public static final /* synthetic */ XTypeName access$getXTypeName(KspRawType r5) {
        return r5.getXTypeName();
    }

    private final p getKsType() {
        j0.A(this.ksType$delegate.getValue());
        return null;
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
        if ((r5 instanceof KspRawType) == false) goto L5;
        getKsType();
        ((KspRawType) r5).getKsType();
        throw null;
    L5:
        throw new IllegalStateException("Check failed.");
    }

    public String toString() {
        return getXTypeName().getKotlin$room_compiler_processing().toString();
    }
}
