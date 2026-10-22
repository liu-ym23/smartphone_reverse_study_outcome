package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.t;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "", "invoke", "()[Ljava/lang/String;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class JsonNamesMapKt$serializationNamesIndices$1 extends Lambda implements Function0<String[]> {
    final /* synthetic */ t $strategy;
    final /* synthetic */ kotlinx.serialization.descriptors.g $this_serializationNamesIndices;

    public JsonNamesMapKt$serializationNamesIndices$1(kotlinx.serialization.descriptors.g r5, t r10) {
        this.$this_serializationNamesIndices = r5;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String[] invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String[] invoke2() {
        int r5 = this.$this_serializationNamesIndices.d();
        String[] r10 = new String[r5];
        if (r5 > 0) goto L5;
        return r10;
    L5:
        this.$this_serializationNamesIndices.e(0);
        throw null;
    }
}
