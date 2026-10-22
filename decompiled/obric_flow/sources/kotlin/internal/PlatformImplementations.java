package kotlin.internal;

import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.text.MatchGroup;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0013"}, d2 = {"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "getSuppressed", "", "ReflectThrowable", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
public class PlatformImplementations {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "()V", "addSuppressed", "Ljava/lang/reflect/Method;", "getSuppressed", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations$ReflectThrowable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
    public static final class ReflectThrowable {
        public static final ReflectThrowable INSTANCE = null;

        @JvmField
        public static final Method addSuppressed = null;

        @JvmField
        public static final Method getSuppressed = null;

        static {
            INSTANCE = new ReflectThrowable();
            Method[] r5 = Throwable.class.getMethods();
            Intrinsics.checkNotNull(r5);
            int r10 = r5.length;
            int r11 = 0;
            int r12 = 0;
        L3:
            Method r13 = null;
            if (r12 >= r10) goto L11;
            Method r14 = r5[r12];
            if (Intrinsics.areEqual(r14.getName(), "addSuppressed") == false) goto L10;
            if (Intrinsics.areEqual(ArraysKt.singleOrNull(r14.getParameterTypes()), Throwable.class) == false) goto L10;
        L12:
            addSuppressed = r14;
            int r15 = r5.length;
        L13:
            if (r11 >= r15) goto L18;
            Method r16 = r5[r11];
            if (Intrinsics.areEqual(r16.getName(), "getSuppressed") == true) goto L16;
            r11 = r11 + 1;
            goto L13
        L16:
            r13 = r16;
        L18:
            getSuppressed = r13;
            return;
        L10:
            r12 = r12 + 1;
            goto L3
        L11:
            r14 = null;
            goto L12
        }

        private ReflectThrowable() {
        }
    }

    public PlatformImplementations() {
    }

    public void addSuppressed(Throwable r5, Throwable r10) {
        Intrinsics.checkNotNullParameter(r5, "cause");
        Intrinsics.checkNotNullParameter(r10, "exception");
        Method r11 = ReflectThrowable.addSuppressed;
        if (r11 == null) goto L6;
        r11.invoke(r5, new Object[]{r10});
        return;
    }

    public Random defaultPlatformRandom() {
        return new FallbackThreadLocalRandom();
    }

    public MatchGroup getMatchResultNamedGroup(MatchResult r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "matchResult");
        Intrinsics.checkNotNullParameter(r10, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    public List<Throwable> getSuppressed(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "exception");
        Method r10 = ReflectThrowable.getSuppressed;
        if (r10 == null) goto L9;
        Object r11 = r10.invoke(r5, null);
        if (r11 == null) goto L9;
        List<Throwable> r12 = ArraysKt.asList((Throwable[]) r11);
        if (r12 == null) goto L9;
        return r12;
    L9:
        return CollectionsKt.emptyList();
    }
}
