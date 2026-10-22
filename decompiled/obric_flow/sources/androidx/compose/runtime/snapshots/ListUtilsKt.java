package androidx.compose.runtime.snapshots;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\t\u001a;\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0007H\u0080\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a;\u0010\u000e\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0007H\u0080\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aV\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2'\u0010\r\u001a#\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0010H\u0080\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a;\u0010\u0015\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0007H\u0080\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aA\u0010\u0017\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0010H\u0080\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aS\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u0002H\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f0\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u001a*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u001a0\u0007H\u0080\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a}\u0010\u001c\u001a\u0002H\u001d\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010\u001d*\u00060\u0003j\u0002`\u0004*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\u001e\u001a\u0002H\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020\b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010$\u001ab\u0010%\u001a\u00020&\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020\b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0000\u001aG\u0010'\u001a\b\u0012\u0004\u0012\u0002H(0\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H(0\u0007H\u0080\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aI\u0010)\u001a\b\u0012\u0004\u0012\u0002H(0\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H(0\u0007H\u0080\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a\u001e\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00020+\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006,"}, d2 = {"appendElement", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "element", "transform", "Lkotlin/Function1;", "", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "fastAll", "", "", "predicate", "fastAny", "fastFilterIndexed", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "fastForEach", "action", "fastForEachIndexed", "fastGroupBy", "", "K", "keySelector", "fastJoinTo", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "buffer", "separator", "prefix", "postfix", "limit", "truncated", "(Ljava/util/List;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "fastJoinToString", "", "fastMap", "R", "fastMapNotNull", "fastToSet", "", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nListUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,238:1\n33#1,6:239\n33#1,6:245\n33#1,6:251\n33#1,6:257\n33#1,4:263\n38#1:274\n33#1,4:275\n38#1:280\n64#1,6:281\n361#2,7:267\n1#3:279\n*S KotlinDebug\n*F\n+ 1 ListUtils.kt\nandroidx/compose/runtime/snapshots/ListUtilsKt\n*L\n50#1:239,6\n84#1:245,6\n94#1:251,6\n111#1:257,6\n122#1:263,4\n122#1:274\n213#1:275,4\n213#1:280\n233#1:281,6\n124#1:267,7\n*E\n"})
public final class ListUtilsKt {
    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void appendElement(Appendable r5, T r10, Function1<? super T, ? extends CharSequence> r11) {
        if (r11 == null) goto L4;
        r5.append(r11.invoke(r10));
        return;
    L4:
        if (r10 != 0) goto L6;
        boolean r12 = true;
    L7:
        if (r12 == false) goto L10;
        r5.append((CharSequence) r10);
        return;
    L10:
        if ((r10 instanceof Character) == false) goto L12;
        r5.append(((Character) r10).charValue());
        return;
    L12:
        r5.append(String.valueOf(r10));
        return;
    L6:
        r12 = r10 instanceof CharSequence;
        goto L7
    }

    public static final <T> boolean fastAll(List<? extends T> r5, Function1<? super T, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "predicate");
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (r10.invoke(r5.get(r12)).booleanValue() == false) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static final <T> boolean fastAny(List<? extends T> r5, Function1<? super T, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "predicate");
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (r10.invoke(r5.get(r12)).booleanValue() == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static final <T> List<T> fastFilterIndexed(List<? extends T> r5, Function2<? super Integer, ? super T, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "predicate");
        ArrayList r11 = new ArrayList(r5.size());
        int r12 = r5.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        T r14 = r5.get(r13);
        if (r10.mo2invoke(Integer.valueOf(r13), r14).booleanValue() == false) goto L7;
        r11.add(r14);
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        return r11;
    }

    public static final <T> void fastForEach(List<? extends T> r5, Function1<? super T, Unit> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "action");
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.invoke(r5.get(r12));
        r12 = r12 + 1;
        goto L3
    }

    public static final <T> void fastForEachIndexed(List<? extends T> r5, Function2<? super Integer, ? super T, Unit> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "action");
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        T r13 = r5.get(r12);
        r10.mo2invoke(Integer.valueOf(r12), r13);
        r12 = r12 + 1;
        goto L3
    }

    public static final <T, K> Map<K, List<T>> fastGroupBy(List<? extends T> r10, Function1<? super T, ? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        HashMap r5 = new HashMap(r10.size());
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        T r14 = r10.get(r13);
        K r15 = r11.invoke(r14);
        Object r16 = r5.get(r15);
        if (r16 != null) goto L7;
        r16 = new ArrayList();
        r5.put(r15, r16);
    L7:
        ((ArrayList) r16).add(r14);
        r13 = r13 + 1;
        goto L3
    L8:
        return r5;
    }

    private static final <T, A extends Appendable> A fastJoinTo(List<? extends T> r5, A r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, Function1<? super T, ? extends CharSequence> r16) {
        r10.append(r12);
        int r17 = r5.size();
        int r18 = 0;
        int r19 = 0;
    L3:
        if (r18 >= r17) goto L10;
        T r20 = r5.get(r18);
        r19 = r19 + 1;
        if (r19 <= 1) goto L7;
        r10.append(r11);
    L7:
        if (r14 < 0) goto L9;
        if (r19 > r14) goto L10;
    L9:
        appendElement(r10, r20, r16);
        r18 = r18 + 1;
    L10:
        if (r14 < 0) goto L13;
        if (r19 <= r14) goto L13;
        r10.append(r15);
    L13:
        r10.append(r13);
        return r10;
    }

    public static /* synthetic */ Appendable fastJoinTo$default(List r10, Appendable r11, CharSequence r12, CharSequence r13, CharSequence r14, int r15, CharSequence r16, Function1 r17, int r18, Object r19) {
        if ((r18 & 2) == 0) goto L5;
        CharSequence r5 = ", ";
    L6:
        CharSequence r20 = "";
        if ((r18 & 4) == 0) goto L9;
        CharSequence r21 = "";
    L11:
        if ((r18 & 8) != 0) goto L15;
        r20 = r14;
    L15:
        if ((r18 & 16) == 0) goto L17;
        int r22 = -1;
    L19:
        if ((r18 & 32) == 0) goto L21;
        CharSequence r23 = "...";
    L23:
        if ((r18 & 64) == 0) goto L25;
        Function1 r24 = null;
    L27:
        return fastJoinTo(r10, r11, r5, r21, r20, r22, r23, r24);
    L25:
        r24 = r17;
        goto L27
    L21:
        r23 = r16;
        goto L23
    L17:
        r22 = r15;
        goto L19
    L9:
        r21 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L6
    }

    public static final <T> String fastJoinToString(List<? extends T> r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, Function1<? super T, ? extends CharSequence> r16) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "separator");
        Intrinsics.checkNotNullParameter(r12, "prefix");
        Intrinsics.checkNotNullParameter(r13, "postfix");
        Intrinsics.checkNotNullParameter(r15, "truncated");
        return ((StringBuilder) fastJoinTo(r10, new StringBuilder(), r11, r12, r13, r14, r15, r16)).toString();
    }

    public static /* synthetic */ String fastJoinToString$default(List r5, CharSequence r10, CharSequence r11, CharSequence r12, int r13, CharSequence r14, Function1 r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        r10 = ", ";
    L5:
        CharSequence r18 = "";
        if ((r16 & 2) == 0) goto L8;
        CharSequence r19 = "";
    L10:
        if ((r16 & 4) != 0) goto L14;
        r18 = r12;
    L14:
        if ((r16 & 8) == 0) goto L16;
        r13 = -1;
    L16:
        int r20 = r13;
        if ((r16 & 16) == 0) goto L19;
        r14 = "...";
    L19:
        CharSequence r21 = r14;
        if ((r16 & 32) == 0) goto L22;
        r15 = null;
    L22:
        CharSequence r22 = r10;
        CharSequence r23 = r19;
        CharSequence r24 = r18;
        return fastJoinToString(r5, r22, r23, r24, r20, r21, r15);
    L8:
        r19 = r11;
        goto L10
    }

    public static final <T, R> List<R> fastMap(List<? extends T> r5, Function1<? super T, ? extends R> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "transform");
        ArrayList r11 = new ArrayList(r5.size());
        int r12 = r5.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(r10.invoke(r5.get(r13)));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public static final <T, R> List<R> fastMapNotNull(List<? extends T> r5, Function1<? super T, ? extends R> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "transform");
        ArrayList r11 = new ArrayList(r5.size());
        int r12 = r5.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        R r14 = r10.invoke(r5.get(r13));
        if (r14 == null) goto L7;
        r11.add(r14);
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        return r11;
    }

    public static final <T> Set<T> fastToSet(List<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        HashSet r10 = new HashSet(r5.size());
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.add(r5.get(r12));
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }
}
