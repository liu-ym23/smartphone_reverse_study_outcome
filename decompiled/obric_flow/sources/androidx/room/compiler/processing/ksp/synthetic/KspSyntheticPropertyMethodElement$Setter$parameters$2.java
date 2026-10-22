package androidx.room.compiler.processing.ksp.synthetic;

import androidx.room.compiler.processing.ksp.KspProcessingEnv;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement$Setter$SyntheticExecutableParameterElement;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KspSyntheticPropertyMethodElement$Setter$parameters$2 extends Lambda implements Function0<List<? extends KspSyntheticPropertyMethodElement.Setter.SyntheticExecutableParameterElement>> {
    final /* synthetic */ KspProcessingEnv $env;
    final /* synthetic */ KspSyntheticPropertyMethodElement.Setter this$0;

    public KspSyntheticPropertyMethodElement$Setter$parameters$2(KspProcessingEnv r5, KspSyntheticPropertyMethodElement.Setter r10) {
        this.$env = r5;
        this.this$0 = r10;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends KspSyntheticPropertyMethodElement.Setter.SyntheticExecutableParameterElement> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends KspSyntheticPropertyMethodElement.Setter.SyntheticExecutableParameterElement> invoke2() {
        return CollectionsKt.listOf(new KspSyntheticPropertyMethodElement.Setter.SyntheticExecutableParameterElement(this.$env, this.this$0));
    }
}
