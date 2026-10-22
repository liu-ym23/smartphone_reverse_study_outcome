package kotlin.internal.jdk7;

import com.bytedance.apm6.util.constant.CommonConsts;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.internal.PlatformImplementations;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
public class JDK7PlatformImplementations extends PlatformImplementations {

    @SourceDebugExtension({"SMAP\nJDK7PlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JDK7PlatformImplementations.kt\nkotlin/internal/jdk7/JDK7PlatformImplementations$ReflectSdkVersion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,38:1\n1#2:39\n*E\n"})
    private static final class ReflectSdkVersion {
        public static final ReflectSdkVersion INSTANCE = null;

        @JvmField
        public static final Integer sdkVersion = null;

        static {
            INSTANCE = new ReflectSdkVersion();
            Integer r10 = null;
            Object r11 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);     // Catch: Throwable -> L17
            if ((r11 instanceof Integer) == false) goto L7;
            Integer r12 = (Integer) r11;     // Catch: Throwable -> L17
        L8:
            if (r12 != null) goto L10;
        L15:
            sdkVersion = r10;
            return;
        L10:
            if (r12.intValue() <= 0) goto L12;
            boolean r13 = true;
        L13:
            if (r13 == false) goto L15;
            r10 = r12;
            goto L15
        L12:
            r13 = false;
        L7:
            r12 = null;
            goto L8
        }

        private ReflectSdkVersion() {
        }
    }

    public JDK7PlatformImplementations() {
    }

    private final boolean sdkIsNullOrAtLeast(int r10) {
        Integer r11 = ReflectSdkVersion.sdkVersion;
        if (r11 != null) goto L5;
    L8:
        return true;
    L5:
        if (r11.intValue() >= r10) goto L8;
        return false;
    }

    @Override // kotlin.internal.PlatformImplementations
    public void addSuppressed(Throwable r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r10, "cause");
        Intrinsics.checkNotNullParameter(r11, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);
        if (sdkIsNullOrAtLeast(19) == false) goto L5;
        r10.addSuppressed(r11);
        return;
    L5:
        super.addSuppressed(r10, r11);
    }

    @Override // kotlin.internal.PlatformImplementations
    public List<Throwable> getSuppressed(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);
        if (sdkIsNullOrAtLeast(19) == false) goto L6;
        Throwable[] r11 = r10.getSuppressed();
        Intrinsics.checkNotNullExpressionValue(r11, "exception.suppressed");
        return ArraysKt.asList(r11);
    L6:
        return super.getSuppressed(r10);
    }
}
