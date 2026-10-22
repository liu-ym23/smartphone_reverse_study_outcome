package androidx.room.compiler.processing;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"filterMethodsByConfig", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/compiler/processing/XMethodElement;", "env", "Landroidx/room/compiler/processing/XProcessingEnv;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class XMethodElementKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends XMethodElement> List<T> filterMethodsByConfig(List<? extends T> r5, XProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "env");
        if (r10.getConfig().getExcludeMethodsWithInvalidJvmSourceNames() == false) goto L17;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r5.iterator();
    L6:
        if (r12.hasNext() == false) goto L11;
        Object r13 = r12.next();
        if (((XMethodElement) r13).hasValidJvmSourceName() == false) goto L6;
        r11.add(r13);
        goto L6
    L11:
        return r11;
    L17:
        return r5;
    }
}
