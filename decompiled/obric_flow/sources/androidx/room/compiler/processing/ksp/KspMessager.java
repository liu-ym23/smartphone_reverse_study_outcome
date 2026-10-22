package androidx.room.compiler.processing.ksp;

import ai.j0;
import androidx.room.compiler.processing.XAnnotation;
import androidx.room.compiler.processing.XAnnotationValue;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XMessager;
import hl.c;
import il.j;
import il.x;
import java.util.Iterator;
import javax.tools.Diagnostic;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ=\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspMessager;", "Landroidx/room/compiler/processing/XMessager;", "Lhl/c;", "logger", "<init>", "(Lhl/c;)V", "Ljavax/tools/Diagnostic$Kind;", "kind", "", "msg", "Lil/j;", "ksNode", "", "internalPrintMessage", "(Ljavax/tools/Diagnostic$Kind;Ljava/lang/String;Lil/j;)V", "Landroidx/room/compiler/processing/XElement;", "element", "Landroidx/room/compiler/processing/XAnnotation;", "annotation", "Landroidx/room/compiler/processing/XAnnotationValue;", "annotationValue", "onPrintMessage", "(Ljavax/tools/Diagnostic$Kind;Ljava/lang/String;Landroidx/room/compiler/processing/XElement;Landroidx/room/compiler/processing/XAnnotation;Landroidx/room/compiler/processing/XAnnotationValue;)V", "Lhl/c;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspMessager extends XMessager {
    private final c logger;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[Diagnostic.Kind.values().length];
            r5[Diagnostic.Kind.ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r5[Diagnostic.Kind.WARNING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public KspMessager(c r5) {
        Intrinsics.checkNotNullParameter(r5, "logger");
        this.logger = r5;
    }

    private final void internalPrintMessage(Diagnostic.Kind r5, String r10, j r11) {
        int r12 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r12 != 1) goto L5;
        this.logger.error(r10, r11);
        return;
    L5:
        if (r12 == 2) goto L7;
        this.logger.info(r10, r11);
        return;
    L7:
        this.logger.warn(r10, r11);
    }

    public static /* synthetic */ void internalPrintMessage$default(KspMessager r5, Diagnostic.Kind r10, String r11, j r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        r5.internalPrintMessage(r10, r11, r12);
    }

    @Override // androidx.room.compiler.processing.XMessager
    public void onPrintMessage(Diagnostic.Kind r10, String r11, XElement r12, XAnnotation r13, XAnnotationValue r14) {
        Intrinsics.checkNotNullParameter(r10, "kind");
        Intrinsics.checkNotNullParameter(r11, "msg");
        if (r12 != null) goto L6;
        internalPrintMessage$default(this, r10, r11, null, 4, null);
        return;
    L6:
        Object r5 = null;
        Sequence r15 = SequencesKt.filterNotNull(SequencesKt.sequence(new KspMessager$onPrintMessage$nodes$1(r14, r13, r12, null)));
        Iterator r16 = r15.iterator();
    L7:
        boolean r17 = r16.hasNext();
        x r18 = x.f17575a;
        if (r17 == false) goto L12;
        Object r19 = r16.next();
        if (Intrinsics.areEqual(((j) r19).getLocation(), r18) == true) goto L7;
        r5 = r19;
    L12:
        j r20 = (j) r5;
        if (r20 != null) goto L15;
        r20 = (j) SequencesKt.firstOrNull(r15);
    L15:
        if (r20 != null) goto L17;
    L20:
        StringBuilder r21 = j0.w(r11, " - ");
        r21.append(r12.getFallbackLocationText());
        internalPrintMessage(r10, r21.toString(), r20);
        return;
    L17:
        if (Intrinsics.areEqual(r20.getLocation(), r18) == true) goto L20;
        internalPrintMessage(r10, r11, r20);
    }
}
