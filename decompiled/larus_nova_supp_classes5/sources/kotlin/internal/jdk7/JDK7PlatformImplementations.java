package kotlin.internal.jdk7;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.internal.PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000f"}, d2 = {"Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "Lkotlin/internal/PlatformImplementations;", "()V", "addSuppressed", "", "cause", "", "exception", "getSuppressed", "", "sdkIsNullOrAtLeast", "", EffectConfiguration.KEY_VERSION, "", "ReflectSdkVersion", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class JDK7PlatformImplementations extends PlatformImplementations {
    public JDK7PlatformImplementations() {
    }

    private final boolean sdkIsNullOrAtLeast(int r2) {
        Integer r0 = ReflectSdkVersion.sdkVersion;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.intValue() >= r2) goto L8;
        return false;
    }

    @Override // kotlin.internal.PlatformImplementations
    public List<Throwable> getSuppressed(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "exception");
        if (sdkIsNullOrAtLeast(19) == false) goto L6;
        return ArraysKt.asList(r2.getSuppressed());
    L6:
        return super.getSuppressed(r2);
    }

    @Override // kotlin.internal.PlatformImplementations
    public void addSuppressed(Throwable r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "cause");
        Intrinsics.checkNotNullParameter(r3, "exception");
        if (sdkIsNullOrAtLeast(19) == false) goto L5;
        r2.addSuppressed(r3);
        return;
    L5:
        super.addSuppressed(r2, r3);
    }
}
