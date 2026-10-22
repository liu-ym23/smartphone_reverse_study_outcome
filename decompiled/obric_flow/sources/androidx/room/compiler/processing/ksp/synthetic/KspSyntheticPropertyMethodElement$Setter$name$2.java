package androidx.room.compiler.processing.ksp.synthetic;

import androidx.room.compiler.processing.javac.kotlin.JvmAbi;
import androidx.room.compiler.processing.ksp.KspFieldElement;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KspSyntheticPropertyMethodElement$Setter$name$2 extends Lambda implements Function0<String> {
    final /* synthetic */ KspFieldElement $field;

    public KspSyntheticPropertyMethodElement$Setter$name$2(KspFieldElement r5) {
        this.$field = r5;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        JvmAbi r5 = JvmAbi.INSTANCE;
        this.$field.getDeclaration();
        throw null;
    }
}
