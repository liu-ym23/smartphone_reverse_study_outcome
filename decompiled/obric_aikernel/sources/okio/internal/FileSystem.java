package okio.internal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequenceScope;
import okio.h;
import okio.i;
import okio.y;

/* JADX INFO: renamed from: okio.internal.-FileSystem, reason: invalid class name */
/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "-FileSystem")
@SourceDebugExtension({"SMAP\nFileSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileSystem.kt\nokio/internal/-FileSystem\n+ 2 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,155:1\n52#2,5:156\n52#2,21:161\n60#2,10:182\n57#2,2:192\n71#2,2:194\n*S KotlinDebug\n*F\n+ 1 FileSystem.kt\nokio/internal/-FileSystem\n*L\n65#1:156,5\n66#1:161,21\n65#1:182,10\n65#1:192,2\n65#1:194,2\n*E\n"})
public final class FileSystem {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v4, types: [kotlin.sequences.SequenceScope] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.lang.Object, kotlin.sequences.SequenceScope, kotlin.sequences.SequenceScope<? super okio.y>] */
    /* JADX WARN: Type inference failed for: r17v1, types: [kotlin.sequences.SequenceScope] */
    public static final Object a(SequenceScope<? super y> r17, i r18, ArrayDeque<y> r19, y r20, boolean r21, boolean r22, Continuation<? super Unit> r23) {
        y r10 = r20;
        boolean r11 = r22;
        if ((r23 instanceof FileSystem$collectRecursively$1) == false) goto L7;
        FileSystem$collectRecursively$1 r12 = (FileSystem$collectRecursively$1) r23;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L22;
        if (r16 == 1) goto L21;
        if (r16 == 2) goto L16;
        if (r16 != 3) goto L15;
        ResultKt.throwOnFailure(r14);
    L68:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        boolean r24 = r12.Z$1;
        boolean r25 = r12.Z$0;
        Iterator<y> r26 = (Iterator) r12.L$4;
        y r27 = (y) r12.L$3;
        ArrayDeque<y> r110 = (ArrayDeque) r12.L$2;
        i r111 = (i) r12.L$1;
        SequenceScope r112 = (SequenceScope) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L19
        ?? r113 = r112;
    L48:
        if (r26.hasNext() == false) goto L57;
        y r28 = r26.next();     // Catch: Throwable -> L19
        if (r24 == false) goto L53;
        boolean r114 = true;
    L54:
        r12.L$0 = r113;     // Catch: Throwable -> L19
        r12.L$1 = r111;     // Catch: Throwable -> L19
        r12.L$2 = r110;     // Catch: Throwable -> L19
        r12.L$3 = r27;     // Catch: Throwable -> L19
        r12.L$4 = r26;     // Catch: Throwable -> L19
        r12.Z$0 = r25;     // Catch: Throwable -> L19
        r12.Z$1 = r24;     // Catch: Throwable -> L19
        r12.label = 2;     // Catch: Throwable -> L19
        if (a(r113, r111, r110, r28, r25, r114, r12) != r15) goto L48;
        return r15;
    L53:
        r114 = false;
        goto L54
    L57:
        r110.removeLast();
        r11 = r24;
        r10 = r27;
        ?? r115 = r113;
    L63:
        if (r11 == false) goto L70;
        r12.L$0 = null;
        r12.L$1 = null;
        r12.L$2 = null;
        r12.L$3 = null;
        r12.L$4 = null;
        r12.label = 3;
        if (r115.yield(r10, r12) != r15) goto L68;
        return r15;
    L70:
        return Unit.INSTANCE;
    L19:
        th = th;
    L60:
        r110.removeLast();
        throw th;
    L21:
        boolean r29 = r12.Z$1;
        boolean r30 = r12.Z$0;
        y r31 = (y) r12.L$3;
        ArrayDeque<y> r32 = (ArrayDeque) r12.L$2;
        i r116 = (i) r12.L$1;
        SequenceScope r117 = (SequenceScope) r12.L$0;
        ResultKt.throwOnFailure(r14);
        r11 = r29;
        boolean r33 = r30;
        r10 = r31;
        r115 = r117;
    L29:
        List<y> r34 = r116.b(r10);
        if (r34 != null) goto L33;
        r34 = CollectionsKt.emptyList();
    L33:
        if ((!r34.isEmpty()) == false) goto L63;
        y r118 = r10;
        int r119 = 0;
    L35:
        if (r33 == true) goto L37;
    L41:
        y r120 = c(r116, r118);
        if (r120 == null) goto L43;
        r119 = r119 + 1;
        r118 = r120;
        goto L35
    L43:
        if (r33 == true) goto L45;
        if (r119 != 0) goto L63;
    L45:
        r32.addLast(r118);
        r113 = r115;
        r111 = r116;
        r110 = r32;
        r27 = r10;
        r25 = r33;
        r24 = r11;
        r26 = r34.iterator();     // Catch: Throwable -> L58
    L58:
        th = th;
        r110 = r32;
        goto L60
    L37:
        if (r32.contains(r118) == false) goto L41;
        throw new IOException("symlink cycle at " + r10);
    L22:
        ResultKt.throwOnFailure(r14);
        if (r11 == true) goto L27;
        r12.L$0 = r17;
        i r35 = r18;
        r12.L$1 = r35;
        r32 = r19;
        r12.L$2 = r32;
        r12.L$3 = r10;
        boolean r121 = r21;
        r12.Z$0 = r121;
        r12.Z$1 = r11;
        r12.label = 1;
        if (r17.yield(r10, r12) != r15) goto L28;
        return r15;
    L28:
        r115 = r17;
        r33 = r121;
        r116 = r35;
        goto L29
    L27:
        r35 = r18;
        r32 = r19;
        r121 = r21;
    L7:
        r12 = new FileSystem$collectRecursively$1(r23);
        goto L8
    }

    public static final h b(i r10, y r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "path");
        h r12 = r10.d(r11);
        if (r12 == null) goto L6;
        return r12;
    L6:
        throw new FileNotFoundException("no such file: " + r11);
    }

    public static final y c(i r10, y r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "path");
        y r12 = r10.c(r11).c();
        if (r12 != null) goto L6;
        return null;
    L6:
        y r13 = r11.h();
        Intrinsics.checkNotNull(r13);
        return r13.k(r12);
    }
}
