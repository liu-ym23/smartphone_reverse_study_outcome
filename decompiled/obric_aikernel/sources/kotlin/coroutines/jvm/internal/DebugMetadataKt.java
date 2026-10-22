package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nDebugMetadata.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/DebugMetadataKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,134:1\n37#2,2:135\n*S KotlinDebug\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/DebugMetadataKt\n*L\n131#1:135,2\n*E\n"})
public final class DebugMetadataKt {
    private static final int COROUTINES_DEBUG_METADATA_VERSION = 1;

    private static final void checkDebugMetadataVersion(int r10, int r11) {
        if (r11 > r10) goto L5;
        return;
    L5:
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + r10 + ", got " + r11 + ". Please update the Kotlin standard library.").toString());
    }

    private static final DebugMetadata getDebugMetadataAnnotation(BaseContinuationImpl r10) {
        return (DebugMetadata) r10.getClass().getAnnotation(DebugMetadata.class);
    }

    private static final int getLabel(BaseContinuationImpl r10) {
        Field r11 = r10.getClass().getDeclaredField("label");     // Catch: Exception -> L11
        r11.setAccessible(true);     // Catch: Exception -> L11
        Object r12 = r11.get(r10);     // Catch: Exception -> L11
        if ((r12 instanceof Integer) == false) goto L5;
        Integer r13 = (Integer) r12;     // Catch: Exception -> L11
    L6:
        if (r13 == null) goto L9;
        int r14 = r13.intValue();     // Catch: Exception -> L11
    L15:
        return r14 - 1;
    L9:
        r14 = 0;
        goto L15
    L5:
        r13 = null;
    L11:
        return -1;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "getSpilledVariableFieldMapping")
    public static final String[] getSpilledVariableFieldMapping(BaseContinuationImpl r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        DebugMetadata r11 = getDebugMetadataAnnotation(r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        checkDebugMetadataVersion(1, r11.v());
        ArrayList r12 = new ArrayList();
        int r13 = getLabel(r10);
        int[] r14 = r11.i();
        int r15 = r14.length;
        int r16 = 0;
    L7:
        if (r16 >= r15) goto L13;
        if (r14[r16] != r13) goto L11;
        r12.add(r11.s()[r16]);
        r12.add(r11.n()[r16]);
    L11:
        r16 = r16 + 1;
        goto L7
    L13:
        return (String[]) r12.toArray(new String[0]);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "getStackTraceElement")
    public static final StackTraceElement getStackTraceElement(BaseContinuationImpl r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        DebugMetadata r11 = getDebugMetadataAnnotation(r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        checkDebugMetadataVersion(1, r11.v());
        int r12 = getLabel(r10);
        if (r12 >= 0) goto L9;
        int r13 = -1;
    L10:
        String r14 = ModuleNameRetriever.INSTANCE.getModuleName(r10);
        if (r14 != null) goto L13;
        String r15 = r11.c();
    L15:
        return new StackTraceElement(r15, r11.m(), r11.f(), r13);
    L13:
        r15 = r14 + '/' + r11.c();
        goto L15
    L9:
        r13 = r11.l()[r12];
        goto L10
    }
}
