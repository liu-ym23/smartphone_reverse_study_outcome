package kotlinx.serialization.internal;

import androidx.room.compiler.processing.ksp.KspArrayType;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends k0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19265b;

    public /* synthetic */ c(kotlinx.serialization.descriptors.g r5, int r10) {
        this.f19265b = r10;
        super(r5);
    }

    @Override // kotlinx.serialization.descriptors.g
    public final String h() {
        switch(this.f19265b) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        return "kotlin.collections.LinkedHashSet";
    L6:
        return "kotlin.collections.HashSet";
    L8:
        return "kotlin.collections.ArrayList";
    L10:
        return KspArrayType.KOTLIN_ARRAY_Q_NAME;
    }
}
