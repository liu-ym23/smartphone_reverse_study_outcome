package okio;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: renamed from: okio.-Platform, reason: invalid class name */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000\u001a\f\u0010\t\u001a\u00020\u0003*\u00020\nH\u0000\u001a\f\u0010\u000b\u001a\u00020\n*\u00020\u0003H\u0000*\n\u0010\f\"\u00020\r2\u00020\r*\n\u0010\u000e\"\u00020\u000f2\u00020\u000f*\n\u0010\u0010\"\u00020\u00112\u00020\u0011*\n\u0010\u0012\"\u00020\u00132\u00020\u0013*\n\u0010\u0014\"\u00020\u00152\u00020\u0015¨\u0006\u0016"}, d2 = {"arraycopy", "", "src", "", "srcPos", "", "dest", "destPos", XSDatatype.FACET_LENGTH, "asUtf8ToByteArray", "", "toUtf8String", "ArrayIndexOutOfBoundsException", "Ljava/lang/ArrayIndexOutOfBoundsException;", "JvmField", "Lkotlin/jvm/JvmField;", "JvmName", "Lkotlin/jvm/JvmName;", "JvmOverloads", "Lkotlin/jvm/JvmOverloads;", "JvmStatic", "Lkotlin/jvm/JvmStatic;", "jvm"}, k = 2, mv = {1, 1, 11})
public final class Platform {
    public static final void arraycopy(byte[] r1, int r2, byte[] r3, int r4, int r5) {
        Intrinsics.checkParameterIsNotNull(r1, "src");
        Intrinsics.checkParameterIsNotNull(r3, "dest");
        System.arraycopy(r1, r2, r3, r4, r5);
    }

    public static final byte[] asUtf8ToByteArray(String r1) {
        Intrinsics.checkParameterIsNotNull(r1, "$receiver");
        byte[] r2 = r1.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(r2, "(this as java.lang.String).getBytes(charset)");
        return r2;
    }

    public static final String toUtf8String(byte[] r2) {
        Intrinsics.checkParameterIsNotNull(r2, "$receiver");
        return new String(r2, Charsets.UTF_8);
    }
}
