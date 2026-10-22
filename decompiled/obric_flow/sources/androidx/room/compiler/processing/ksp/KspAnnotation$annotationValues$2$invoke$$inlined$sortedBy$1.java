package androidx.room.compiler.processing.ksp;

import androidx.exifinterface.media.ExifInterface;
import java.util.Comparator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KspAnnotation$annotationValues$2$invoke$$inlined$sortedBy$1<T> implements Comparator {
    final /* synthetic */ Map $indexByName$inlined;

    public KspAnnotation$annotationValues$2$invoke$$inlined$sortedBy$1(Map r5) {
        this.$indexByName$inlined = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r5, T r10) {
        return ComparisonsKt.compareValues((Integer) this.$indexByName$inlined.get(((KspAnnotationValue) r5).getName()), (Integer) this.$indexByName$inlined.get(((KspAnnotationValue) r10).getName()));
    }
}
