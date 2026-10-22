package androidx.room.processor;

import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XElement;
import androidx.room.vo.Warning;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Suppress;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/room/processor/SuppressWarningProcessor;", "", "()V", "getSuppressedWarnings", "", "Landroidx/room/vo/Warning;", "element", "Landroidx/room/compiler/processing/XElement;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SuppressWarningProcessor {
    public static final SuppressWarningProcessor INSTANCE = null;

    static {
        INSTANCE = new SuppressWarningProcessor();
    }

    private SuppressWarningProcessor() {
    }

    public final Set<Warning> getSuppressedWarnings(XElement r10) {
        Intrinsics.checkNotNullParameter(r10, "element");
        Set r11 = SetsKt.createSetBuilder();
        XAnnotationBox r5 = r10.getAnnotation(Reflection.getOrCreateKotlinClass(SuppressWarnings.class));
        int r12 = 0;
        if (r5 == null) goto L13;
        SuppressWarnings r13 = (SuppressWarnings) r5.getValue();
        if (r13 == null) goto L13;
        String[] r14 = r13.value();
        Warning.Companion r15 = Warning.Companion;
        ArrayList r16 = new ArrayList();
        int r17 = r14.length;
        int r18 = 0;
    L7:
        if (r18 >= r17) goto L12;
        Warning r19 = r15.fromPublicKey(r14[r18]);
        if (r19 == null) goto L11;
        r16.add(r19);
    L11:
        r18 = r18 + 1;
        goto L7
    L12:
        r11.addAll(r16);
    L13:
        XAnnotationBox r20 = r10.getAnnotation(Reflection.getOrCreateKotlinClass(Suppress.class));
        if (r20 == null) goto L25;
        Suppress r21 = (Suppress) r20.getValue();
        if (r21 == null) goto L25;
        String[] r22 = r21.names();
        Warning.Companion r23 = Warning.Companion;
        ArrayList r24 = new ArrayList();
        int r25 = r22.length;
    L18:
        if (r12 >= r25) goto L23;
        Warning r26 = r23.fromPublicKey(r22[r12]);
        if (r26 == null) goto L22;
        r24.add(r26);
    L22:
        r12 = r12 + 1;
        goto L18
    L23:
        r11.addAll(r24);
    L25:
        return SetsKt.build(r11);
    }
}
