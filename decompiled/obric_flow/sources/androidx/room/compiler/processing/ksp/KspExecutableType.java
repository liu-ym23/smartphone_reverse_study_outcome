package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.XExecutableType;
import androidx.room.compiler.processing.XType;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0001H\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013¨\u0006\u001b"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspExecutableType;", "Landroidx/room/compiler/processing/XExecutableType;", "env", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "origin", "Landroidx/room/compiler/processing/ksp/KspExecutableElement;", "containing", "Landroidx/room/compiler/processing/ksp/KspType;", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Landroidx/room/compiler/processing/ksp/KspExecutableElement;Landroidx/room/compiler/processing/ksp/KspType;)V", "getContaining", "()Landroidx/room/compiler/processing/ksp/KspType;", "getEnv", "()Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "getOrigin", "()Landroidx/room/compiler/processing/ksp/KspExecutableElement;", "parameterTypes", "", "Landroidx/room/compiler/processing/XType;", "getParameterTypes", "()Ljava/util/List;", "parameterTypes$delegate", "Lkotlin/Lazy;", "thrownTypes", "getThrownTypes", "isSameType", "", "other", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KspExecutableType implements XExecutableType {
    private final KspType containing;
    private final KspProcessingEnv env;
    private final KspExecutableElement origin;
    private final Lazy parameterTypes$delegate;

    public KspExecutableType(KspProcessingEnv r5, KspExecutableElement r10, KspType r11) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "origin");
        this.env = r5;
        this.origin = r10;
        this.containing = r11;
        this.parameterTypes$delegate = LazyKt.lazy(new KspExecutableType$parameterTypes$2(this));
    }

    public final KspType getContaining() {
        return this.containing;
    }

    public final KspProcessingEnv getEnv() {
        return this.env;
    }

    public KspExecutableElement getOrigin() {
        return this.origin;
    }

    @Override // androidx.room.compiler.processing.XExecutableType
    public List<XType> getParameterTypes() {
        return (List) this.parameterTypes$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XExecutableType
    public List<XType> getThrownTypes() {
        return getOrigin().getThrownTypes();
    }

    @Override // androidx.room.compiler.processing.XExecutableType
    public boolean isSameType(XExecutableType r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        return this.env.isSameType$room_compiler_processing(this, r5);
    }
}
