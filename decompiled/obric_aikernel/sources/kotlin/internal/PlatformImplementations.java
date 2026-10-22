package kotlin.internal;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.text.MatchGroup;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
public class PlatformImplementations {

    @SourceDebugExtension({"SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations$ReflectThrowable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
    private static final class ReflectThrowable {
        public static final ReflectThrowable INSTANCE = null;

        @JvmField
        public static final Method addSuppressed = null;

        @JvmField
        public static final Method getSuppressed = null;

        static {
            INSTANCE = new ReflectThrowable();
            Method[] r10 = Throwable.class.getMethods();
            Intrinsics.checkNotNullExpressionValue(r10, "throwableMethods");
            int r11 = r10.length;
            int r12 = 0;
            int r13 = 0;
        L3:
            Method r14 = null;
            if (r13 >= r11) goto L14;
            Method r15 = r10[r13];
            if (Intrinsics.areEqual(r15.getName(), "addSuppressed") == false) goto L10;
            Class<?>[] r16 = r15.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(r16, "it.parameterTypes");
            if (Intrinsics.areEqual(ArraysKt.singleOrNull(r16), Throwable.class) == false) goto L10;
            boolean r17 = true;
        L11:
            if (r17 == true) goto L15;
            r13 = r13 + 1;
        L15:
            addSuppressed = r15;
            int r18 = r10.length;
        L16:
            if (r12 >= r18) goto L21;
            Method r19 = r10[r12];
            if (Intrinsics.areEqual(r19.getName(), "getSuppressed") == true) goto L19;
            r12 = r12 + 1;
            goto L16
        L19:
            r14 = r19;
        L21:
            getSuppressed = r14;
            return;
        L10:
            r17 = false;
            goto L11
        L14:
            r15 = null;
            goto L15
        }

        private ReflectThrowable() {
        }
    }

    public PlatformImplementations() {
    }

    public void addSuppressed(Throwable r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r10, "cause");
        Intrinsics.checkNotNullParameter(r11, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);
        Method r12 = ReflectThrowable.addSuppressed;
        if (r12 == null) goto L6;
        r12.invoke(r10, new Object[]{r11});
        return;
    }

    public Random defaultPlatformRandom() {
        return new FallbackThreadLocalRandom();
    }

    public MatchGroup getMatchResultNamedGroup(MatchResult r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "matchResult");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    public List<Throwable> getSuppressed(Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);
        Method r11 = ReflectThrowable.getSuppressed;
        if (r11 == null) goto L9;
        Object r12 = r11.invoke(r10, new Object[0]);
        if (r12 == null) goto L9;
        List<Throwable> r13 = ArraysKt.asList((Throwable[]) r12);
        if (r13 == null) goto L9;
        return r13;
    L9:
        return CollectionsKt.emptyList();
    }
}
