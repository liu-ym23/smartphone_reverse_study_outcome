package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.XConstructorType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspConstructorType;", "Landroidx/room/compiler/processing/ksp/KspExecutableType;", "Landroidx/room/compiler/processing/XConstructorType;", "env", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "origin", "Landroidx/room/compiler/processing/ksp/KspConstructorElement;", "containing", "Landroidx/room/compiler/processing/ksp/KspType;", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Landroidx/room/compiler/processing/ksp/KspConstructorElement;Landroidx/room/compiler/processing/ksp/KspType;)V", "getOrigin", "()Landroidx/room/compiler/processing/ksp/KspConstructorElement;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspConstructorType extends KspExecutableType implements XConstructorType {
    private final KspConstructorElement origin;

    public KspConstructorType(KspProcessingEnv r5, KspConstructorElement r10, KspType r11) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "origin");
        super(r5, r10, r11);
        this.origin = r10;
    }

    @Override // androidx.room.compiler.processing.ksp.KspExecutableType
    public /* bridge */ /* synthetic */ KspExecutableElement getOrigin() {
        return getOrigin();
    }

    @Override // androidx.room.compiler.processing.ksp.KspExecutableType
    public KspConstructorElement getOrigin() {
        return this.origin;
    }
}
