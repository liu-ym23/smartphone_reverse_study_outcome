package kotlin.comparisons;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a>\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000\u001aY\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u000226\u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\b\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\t\u001aZ\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000\u001a>\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000\u001aZ\u0010\f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000\u001a-\u0010\r\u001a\u00020\u000e\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u000f\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0010\u001a\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\u0011\u001aA\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aY\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u000226\u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\b\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0014\u001a]\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n2\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001aG\u0010\u0016\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022 \u0010\u0007\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u00050\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0014\u001a&\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a-\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087\b\u001a@\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001a2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003\u001a-\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087\b\u001a@\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001a2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003\u001a&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a0\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\u001aO\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003H\u0086\u0004\u001aR\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000\u001an\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000\u001aR\u0010 \u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0005H\u0087\bø\u0001\u0000\u001an\u0010 \u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\n`\u00032\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\bø\u0001\u0000\u001ap\u0010!\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u000328\b\u0004\u0010\"\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0#H\u0087\bø\u0001\u0000\u001aO\u0010&\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0003H\u0086\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006'"}, d2 = {"compareBy", "Ljava/util/Comparator;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Comparator;", "selector", "Lkotlin/Function1;", "", "selectors", "", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "K", "comparator", "compareByDescending", "compareValues", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareValuesBy", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "compareValuesByImpl", "compareValuesByImpl$ComparisonsKt__ComparisonsKt", "naturalOrder", "nullsFirst", "", "nullsLast", "reverseOrder", "reversed", "then", "thenBy", "thenByDescending", "thenComparator", "comparison", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "thenDescending", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
class ComparisonsKt__ComparisonsKt {

    /* JADX INFO: renamed from: kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 9, 0}, xi = 176)
    public static final class AnonymousClass2<T> implements Comparator {
        final /* synthetic */ Function1<T, Comparable<?>> $selector;

        public AnonymousClass2(Function1<? super T, ? extends Comparable<?>> r3) {
            this.$selector = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            Function1<T, Comparable<?>> r2 = this.$selector;
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(r2.invoke(r3), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r2.invoke(r4), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareByDescending$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I"}, k = 3, mv = {1, 9, 0}, xi = 176)
    public static final class AnonymousClass1<T> implements Comparator {
        final /* synthetic */ Function1<T, Comparable<?>> $selector;

        public AnonymousClass1(Function1<? super T, ? extends Comparable<?>> r3) {
            this.$selector = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            Function1<T, Comparable<?>> r2 = this.$selector;
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(r2.invoke(r4), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r2.invoke(r3), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    public ComparisonsKt__ComparisonsKt() {
    }

    private static final <T, K> Comparator<T> compareBy(Comparator<? super K> r2, Function1<? super T, ? extends K> r3) {
        final Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        final Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "comparator");
        Intrinsics.checkNotNullParameter(r5, "selector");
        return (Comparator) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r4, r5), Comparator.class, "com.obric.memorydata.plugin");
    }

    private static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>> r2) {
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "selector");
        return (Comparator) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r3), Comparator.class, "com.obric.memorydata.plugin");
    }

    public static final <T> Comparator<T> compareBy(final Function1<? super T, ? extends Comparable<?>>... r1) {
        Intrinsics.checkNotNullParameter(r1, "selectors");
        if (r1.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return new $$Lambda$ComparisonsKt__ComparisonsKt$nq8UCGW90ISdL04oV8sJ24EEKI(r1);
    L10:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r0 = false;
        goto L6
    }

    private static final int compareBy$lambda$0$ComparisonsKt__ComparisonsKt(Function1[] r1, Object r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "$selectors");
        return compareValuesByImpl$ComparisonsKt__ComparisonsKt(r2, r3, r1);
    }

    private static final <T, K> Comparator<T> compareByDescending(Comparator<? super K> r2, Function1<? super T, ? extends K> r3) {
        final Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        final Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "comparator");
        Intrinsics.checkNotNullParameter(r5, "selector");
        return (Comparator) ZeusTransformUtils.preCheckCast(new C12452(r4, r5), Comparator.class, "com.obric.memorydata.plugin");
    }

    private static final <T> Comparator<T> compareByDescending(Function1<? super T, ? extends Comparable<?>> r2) {
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "selector");
        return (Comparator) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), Comparator.class, "com.obric.memorydata.plugin");
    }

    public static final <T extends Comparable<?>> int compareValues(T r2, T r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.memorydata.plugin");
        Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.memorydata.plugin");
        if (r4 != r5) goto L6;
        return 0;
    L6:
        if (r4 != null) goto L9;
        return -1;
    L9:
        if (r5 != null) goto L13;
        return 1;
    L13:
        return r4.compareTo(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T, K> int compareValuesBy(T r2, T r3, Comparator<? super K> r4, Function1<? super T, ? extends K> r5) {
        Comparator r6 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "comparator");
        Intrinsics.checkNotNullParameter(r7, "selector");
        return r6.compare(r7.invoke(r2), r7.invoke(r3));
    }

    private static final <T> int compareValuesBy(T r2, T r3, Function1<? super T, ? extends Comparable<?>> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "selector");
        return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(r5.invoke(r2), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r5.invoke(r3), Comparable.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> int compareValuesBy(T r1, T r2, Function1<? super T, ? extends Comparable<?>>... r3) {
        Intrinsics.checkNotNullParameter(r3, "selectors");
        if (r3.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return compareValuesByImpl$ComparisonsKt__ComparisonsKt(r1, r2, r3);
    L10:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r0 = false;
        goto L6
    }

    private static final <T> int compareValuesByImpl$ComparisonsKt__ComparisonsKt(T r7, T r8, Function1<? super T, ? extends Comparable<?>>[] r9) {
        int r0 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        Function1<? super T, ? extends Comparable<?>> r3 = r9[r2];
        int r4 = ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(r3.invoke(r7), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r3.invoke(r8), Comparable.class, "com.obric.memorydata.plugin"));
        if (r4 != 0) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r4;
    L8:
        return 0;
    }

    /* JADX INFO: renamed from: lambda$-gpd5rn26uA_qKcB-hI2DNr-hgw, reason: not valid java name */
    public static /* synthetic */ int m2601lambda$gpd5rn26uA_qKcBhI2DNrhgw(Comparator r0, Comparator r1, Object r2, Object r3) {
        return thenDescending$lambda$2$ComparisonsKt__ComparisonsKt(r0, r1, r2, r3);
    }

    public static /* synthetic */ int lambda$6WnilmL2ArBCKOeeYXXH8ELrg4w(Comparator r0, Object r1, Object r2) {
        return nullsFirst$lambda$3$ComparisonsKt__ComparisonsKt(r0, r1, r2);
    }

    public static /* synthetic */ int lambda$Uw4BAo9Vwbm4C3dkpmfByDP7hFs(Comparator r0, Object r1, Object r2) {
        return nullsLast$lambda$4$ComparisonsKt__ComparisonsKt(r0, r1, r2);
    }

    public static /* synthetic */ int lambda$iapHOTD2lDnsDFFbGrAXPm4qZHg(Comparator r0, Comparator r1, Object r2, Object r3) {
        return then$lambda$1$ComparisonsKt__ComparisonsKt(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$nq8UCGW90ISdL04-oV8sJ24EEKI, reason: not valid java name */
    public static /* synthetic */ int m2602lambda$nq8UCGW90ISdL04oV8sJ24EEKI(Function1[] r0, Object r1, Object r2) {
        return compareBy$lambda$0$ComparisonsKt__ComparisonsKt(r0, r1, r2);
    }

    public static final <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        NaturalOrderComparator r0 = NaturalOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return (Comparator) ZeusTransformUtils.preCheckCast(r0, Comparator.class, "com.obric.memorydata.plugin");
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsFirst() {
        return ComparisonsKt.nullsFirst(ComparisonsKt.naturalOrder());
    }

    public static final <T> Comparator<T> nullsFirst(Comparator<? super T> r2) {
        final Comparator r3 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "comparator");
        return new $$Lambda$ComparisonsKt__ComparisonsKt$6WnilmL2ArBCKOeeYXXH8ELrg4w(r3);
    }

    private static final int nullsFirst$lambda$3$ComparisonsKt__ComparisonsKt(Comparator r2, Object r3, Object r4) {
        Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "$comparator");
        if (r3 != r4) goto L5;
        return 0;
    L5:
        if (r3 != null) goto L7;
        return -1;
    L7:
        if (r4 != null) goto L10;
        return 1;
    L10:
        return r5.compare(r3, r4);
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsLast() {
        return ComparisonsKt.nullsLast(ComparisonsKt.naturalOrder());
    }

    public static final <T> Comparator<T> nullsLast(Comparator<? super T> r2) {
        final Comparator r3 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "comparator");
        return new $$Lambda$ComparisonsKt__ComparisonsKt$Uw4BAo9Vwbm4C3dkpmfByDP7hFs(r3);
    }

    private static final int nullsLast$lambda$4$ComparisonsKt__ComparisonsKt(Comparator r2, Object r3, Object r4) {
        Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "$comparator");
        if (r3 != r4) goto L5;
        return 0;
    L5:
        if (r3 != null) goto L7;
        return 1;
    L7:
        if (r4 != null) goto L10;
        return -1;
    L10:
        return r5.compare(r3, r4);
    }

    public static final <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        ReverseOrderComparator r0 = ReverseOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder> }");
        return (Comparator) ZeusTransformUtils.preCheckCast(r0, Comparator.class, "com.obric.memorydata.plugin");
    }

    public static final <T> Comparator<T> reversed(Comparator<T> r3) {
        Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, ReversedComparator.class) == false) goto L6;
        return ((ReversedComparator) ZeusTransformUtils.preCheckCast(r4, ReversedComparator.class, "com.obric.memorydata.plugin")).getComparator();
    L6:
        if (Intrinsics.areEqual(r4, NaturalOrderComparator.INSTANCE) == false) goto L11;
        Object r5 = ReverseOrderComparator.INSTANCE;
    L8:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
        Object r6 = ZeusTransformUtils.preCheckCast(r5, Comparator.class, "com.obric.memorydata.plugin");
    L15:
        return (Comparator) r6;
    L11:
        if (Intrinsics.areEqual(r4, ReverseOrderComparator.INSTANCE) == false) goto L13;
        r5 = NaturalOrderComparator.INSTANCE;
        goto L8
    L13:
        r6 = ZeusTransformUtils.preCheckCast(new ReversedComparator(r4), Comparator.class, "com.obric.memorydata.plugin");
        goto L15
    }

    public static final <T> Comparator<T> then(Comparator<T> r2, Comparator<? super T> r3) {
        final Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        final Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "comparator");
        return new $$Lambda$ComparisonsKt__ComparisonsKt$iapHOTD2lDnsDFFbGrAXPm4qZHg(r4, r5);
    }

    private static final int then$lambda$1$ComparisonsKt__ComparisonsKt(Comparator r2, Comparator r3, Object r4, Object r5) {
        Comparator r6 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        Comparator r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "$this_then");
        Intrinsics.checkNotNullParameter(r7, "$comparator");
        int r8 = r6.compare(r4, r5);
        if (r8 == 0) goto L6;
        return r8;
    L6:
        return r7.compare(r4, r5);
    }

    private static final <T, K> Comparator<T> thenBy(Comparator<T> r2, Comparator<? super K> r3, Function1<? super T, ? extends K> r4) {
        final Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        final Comparator r6 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        final Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "comparator");
        Intrinsics.checkNotNullParameter(r7, "selector");
        return (Comparator) ZeusTransformUtils.preCheckCast(new C12472(r5, r6, r7), Comparator.class, "com.obric.memorydata.plugin");
    }

    private static final <T> Comparator<T> thenBy(Comparator<T> r2, Function1<? super T, ? extends Comparable<?>> r3) {
        final Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        final Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "selector");
        return (Comparator) ZeusTransformUtils.preCheckCast(new C12461(r4, r5), Comparator.class, "com.obric.memorydata.plugin");
    }

    private static final <T, K> Comparator<T> thenByDescending(Comparator<T> r2, Comparator<? super K> r3, Function1<? super T, ? extends K> r4) {
        final Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        final Comparator r6 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        final Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "comparator");
        Intrinsics.checkNotNullParameter(r7, "selector");
        return (Comparator) ZeusTransformUtils.preCheckCast(new C12492(r5, r6, r7), Comparator.class, "com.obric.memorydata.plugin");
    }

    private static final <T> Comparator<T> thenByDescending(Comparator<T> r2, Function1<? super T, ? extends Comparable<?>> r3) {
        final Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        final Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "selector");
        return (Comparator) ZeusTransformUtils.preCheckCast(new C12481(r4, r5), Comparator.class, "com.obric.memorydata.plugin");
    }

    private static final <T> Comparator<T> thenComparator(Comparator<T> r2, Function2<? super T, ? super T, Integer> r3) {
        final Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        final Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "comparison");
        return (Comparator) ZeusTransformUtils.preCheckCast(new C12501(r4, r5), Comparator.class, "com.obric.memorydata.plugin");
    }

    public static final <T> Comparator<T> thenDescending(Comparator<T> r2, Comparator<? super T> r3) {
        final Comparator r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        final Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "comparator");
        return new $$Lambda$ComparisonsKt__ComparisonsKt$gpd5rn26uA_qKcBhI2DNrhgw(r4, r5);
    }

    private static final int thenDescending$lambda$2$ComparisonsKt__ComparisonsKt(Comparator r2, Comparator r3, Object r4, Object r5) {
        Comparator r6 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        Comparator r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "$this_thenDescending");
        Intrinsics.checkNotNullParameter(r7, "$comparator");
        int r8 = r6.compare(r4, r5);
        if (r8 == 0) goto L6;
        return r8;
    L6:
        return r7.compare(r5, r4);
    }
}
