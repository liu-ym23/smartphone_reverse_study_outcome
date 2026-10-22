package kotlinx.metadata.impl.extensions;

import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "Lkotlinx/metadata/impl/extensions/a;", "kotlin.jvm.PlatformType", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class MetadataExtensions$Companion$INSTANCES$2 extends Lambda implements Function0<List<? extends a>> {
    public static final MetadataExtensions$Companion$INSTANCES$2 INSTANCE = null;

    static {
        INSTANCE = new MetadataExtensions$Companion$INSTANCES$2();
    }

    public MetadataExtensions$Companion$INSTANCES$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends a> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends a> invoke2() {
        List<? extends a> r5 = CollectionsKt.toList(ServiceLoader.load(a.class, a.class.getClassLoader()));
        if (r5.isEmpty() == true) goto L6;
        return r5;
    L6:
        throw new IllegalStateException("No MetadataExtensions instances found in the classpath. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
    }
}
