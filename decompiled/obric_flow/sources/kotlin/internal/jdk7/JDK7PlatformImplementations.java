package kotlin.internal.jdk7;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.internal.PlatformImplementations;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000f"}, d2 = {"Lkotlin/internal/jdk7/JDK7PlatformImplementations;", "Lkotlin/internal/PlatformImplementations;", "()V", "addSuppressed", "", "cause", "", "exception", "getSuppressed", "", "sdkIsNullOrAtLeast", "", "version", "", "ReflectSdkVersion", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class JDK7PlatformImplementations extends PlatformImplementations {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/internal/jdk7/JDK7PlatformImplementations$ReflectSdkVersion;", "", "()V", "sdkVersion", "", "Ljava/lang/Integer;", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nJDK7PlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JDK7PlatformImplementations.kt\nkotlin/internal/jdk7/JDK7PlatformImplementations$ReflectSdkVersion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,38:1\n1#2:39\n*E\n"})
    public static final class ReflectSdkVersion {
        public static final ReflectSdkVersion INSTANCE = null;

        @JvmField
        public static final Integer sdkVersion = null;

        static {
            INSTANCE = new ReflectSdkVersion();
            Integer r5 = null;
            Object r10 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);     // Catch: Throwable -> L14
            if ((r10 instanceof Integer) == false) goto L7;
            Integer r11 = (Integer) r10;     // Catch: Throwable -> L14
        L8:
            if (r11 != null) goto L10;
        L12:
            sdkVersion = r5;
            return;
        L10:
            if (r11.intValue() <= 0) goto L12;
            r5 = r11;
        L7:
            r11 = null;
            goto L8
        }

        private ReflectSdkVersion() {
        }
    }

    public JDK7PlatformImplementations() {
    }

    private final boolean sdkIsNullOrAtLeast(int r5) {
        Integer r10 = ReflectSdkVersion.sdkVersion;
        if (r10 != null) goto L5;
    L8:
        return true;
    L5:
        if (r10.intValue() >= r5) goto L8;
        return false;
    }

    @Override // kotlin.internal.PlatformImplementations
    public void addSuppressed(Throwable r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, "cause");
        Intrinsics.checkNotNullParameter(r10, "exception");
        if (sdkIsNullOrAtLeast(19) == false) goto L5;
        r5.addSuppressed(r10);
        return;
    L5:
        super.addSuppressed(r5, r10);
    }

    @Override // kotlin.internal.PlatformImplementations
    public List<Throwable> getSuppressed(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "exception");
        if (sdkIsNullOrAtLeast(19) == false) goto L6;
        return ArraysKt.asList(r5.getSuppressed());
    L6:
        return super.getSuppressed(r5);
    }
}
