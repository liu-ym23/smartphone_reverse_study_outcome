package androidx.room.compiler.processing.ksp.synthetic;

import androidx.room.compiler.processing.ksp.KspType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/room/compiler/processing/ksp/KspType;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KspSyntheticPropertyMethodElement$Setter$SyntheticExecutableParameterElement$type$2 extends Lambda implements Function0<KspType> {
    final /* synthetic */ KspSyntheticPropertyMethodElement.Setter.SyntheticExecutableParameterElement this$0;

    public KspSyntheticPropertyMethodElement$Setter$SyntheticExecutableParameterElement$type$2(KspSyntheticPropertyMethodElement.Setter.SyntheticExecutableParameterElement r5) {
        this.this$0 = r5;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ KspType invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final KspType invoke() {
        return this.this$0.getEnclosingElement().getField().getType().withJvmTypeResolver(KspSyntheticPropertyMethodElement.Setter.SyntheticExecutableParameterElement.access$getJvmTypeResolutionScope$p(this.this$0));
    }
}
