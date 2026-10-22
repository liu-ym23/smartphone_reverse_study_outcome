package androidx.room.compiler.processing.ksp.synthetic;

import androidx.room.compiler.processing.ksp.KspProcessingEnv;
import androidx.room.compiler.processing.ksp.KspVoidType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/room/compiler/processing/ksp/KspVoidType;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KspSyntheticPropertyMethodElement$Setter$returnType$2 extends Lambda implements Function0<KspVoidType> {
    final /* synthetic */ KspProcessingEnv $env;

    public KspSyntheticPropertyMethodElement$Setter$returnType$2(KspProcessingEnv r5) {
        this.$env = r5;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ KspVoidType invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final KspVoidType invoke() {
        return this.$env.getVoidType();
    }
}
