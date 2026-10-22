package androidx.room.processor;

import androidx.room.compiler.processing.XType;
import androidx.room.ext.Javapoet_extKt;
import com.squareup.javapoet.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isSuspendAndReturnsDeferredType", "", "Landroidx/room/processor/MethodProcessorDelegate;", "room-compiler"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class MethodProcessorDelegateKt {
    public static final boolean isSuspendAndReturnsDeferredType(MethodProcessorDelegate r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getExecutableElement().isSuspendFunction() == true) goto L5;
        return false;
    L5:
        List<e> r10 = Javapoet_extKt.getDEFERRED_TYPES();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        e r13 = (e) r12.next();
        XType r14 = r5.getContext().getProcessingEnv().findType(r13);
        if (r14 == null) goto L7;
        r11.add(r14);
        goto L7
    L11:
        XType r15 = r5.extractReturnType();
        if (r11.isEmpty() == true) goto L29;
        Iterator r16 = r11.iterator();
    L16:
        if (r16.hasNext() == false) goto L30;
        if (((XType) r16.next()).getRawType().isAssignableFrom(r15.getRawType()) == false) goto L16;
        return true;
    L30:
        return false;
    L29:
        return false;
    }
}
