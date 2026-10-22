package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0002\u001a\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020\bH\u0001¢\u0006\u0002\u0010\r\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\bH\u0001¢\u0006\u0002\b\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"COROUTINES_DEBUG_METADATA_VERSION", "", "checkDebugMetadataVersion", "", "expected", "actual", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getLabel", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDebugMetadata.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/DebugMetadataKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,134:1\n37#2,2:135\n*S KotlinDebug\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/DebugMetadataKt\n*L\n131#1:135,2\n*E\n"})
public final class DebugMetadataKt {
    private static final int COROUTINES_DEBUG_METADATA_VERSION = 1;

    private static final void checkDebugMetadataVersion(int r5, int r10) {
        if (r10 > r5) goto L5;
        return;
    L5:
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + r5 + ", got " + r10 + ". Please update the Kotlin standard library.").toString());
    }

    private static final DebugMetadata getDebugMetadataAnnotation(BaseContinuationImpl r5) {
        return (DebugMetadata) r5.getClass().getAnnotation(DebugMetadata.class);
    }

    private static final int getLabel(BaseContinuationImpl r5) {
        Field r10 = r5.getClass().getDeclaredField("label");     // Catch: Exception -> L11
        r10.setAccessible(true);     // Catch: Exception -> L11
        Object r11 = r10.get(r5);     // Catch: Exception -> L11
        if ((r11 instanceof Integer) == false) goto L5;
        Integer r12 = (Integer) r11;     // Catch: Exception -> L11
    L6:
        if (r12 == null) goto L9;
        int r13 = r12.intValue();     // Catch: Exception -> L11
    L15:
        return r13 - 1;
    L9:
        r13 = 0;
        goto L15
    L5:
        r12 = null;
    L11:
        return -1;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "getSpilledVariableFieldMapping")
    public static final String[] getSpilledVariableFieldMapping(BaseContinuationImpl r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        DebugMetadata r5 = getDebugMetadataAnnotation(r10);
        if (r5 != null) goto L6;
        return null;
    L6:
        checkDebugMetadataVersion(1, r5.v());
        ArrayList r11 = new ArrayList();
        int r12 = getLabel(r10);
        int[] r13 = r5.i();
        int r14 = r13.length;
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L13;
        if (r13[r15] != r12) goto L11;
        r11.add(r5.s()[r15]);
        r11.add(r5.n()[r15]);
    L11:
        r15 = r15 + 1;
        goto L7
    L13:
        return (String[]) r11.toArray(new String[0]);
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "getStackTraceElement")
    public static final StackTraceElement getStackTraceElement(BaseContinuationImpl r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        DebugMetadata r10 = getDebugMetadataAnnotation(r5);
        if (r10 != null) goto L6;
        return null;
    L6:
        checkDebugMetadataVersion(1, r10.v());
        int r11 = getLabel(r5);
        if (r11 >= 0) goto L9;
        int r12 = -1;
    L10:
        String r13 = ModuleNameRetriever.INSTANCE.getModuleName(r5);
        if (r13 != null) goto L13;
        String r14 = r10.c();
    L15:
        return new StackTraceElement(r14, r10.m(), r10.f(), r12);
    L13:
        r14 = r13 + '/' + r10.c();
        goto L15
    L9:
        r12 = r10.l()[r11];
        goto L10
    }
}
