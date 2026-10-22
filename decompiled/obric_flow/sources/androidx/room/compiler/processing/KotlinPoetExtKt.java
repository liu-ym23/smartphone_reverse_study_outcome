package androidx.room.compiler.processing;

import androidx.exifinterface.media.ExifInterface;
import com.squareup.kotlinpoet.a0;
import com.squareup.kotlinpoet.c;
import com.squareup.kotlinpoet.q;
import com.squareup.kotlinpoet.u;
import javax.lang.model.element.Element;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a)\u0010\u0004\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\b\"\u001e\u0010\u000b\u001a\u00060\tj\u0002`\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/squareup/kotlinpoet/q;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/compiler/processing/XElement;", "element", "addOriginatingElement", "(Lcom/squareup/kotlinpoet/q;Landroidx/room/compiler/processing/XElement;)Lcom/squareup/kotlinpoet/q;", "Lcom/squareup/kotlinpoet/a0;", "rawTypeName", "(Lcom/squareup/kotlinpoet/a0;)Lcom/squareup/kotlinpoet/a0;", "Lcom/squareup/kotlinpoet/c;", "Lcom/squareup/kotlinpoet/javapoet/KClassName;", "KOTLIN_NONE_TYPE_NAME", "Lcom/squareup/kotlinpoet/c;", "getKOTLIN_NONE_TYPE_NAME", "()Lcom/squareup/kotlinpoet/c;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KotlinPoetExtKt {
    private static final c KOTLIN_NONE_TYPE_NAME = null;

    static {
        KOTLIN_NONE_TYPE_NAME = new c("androidx.room.compiler.processing.error", new String[]{"NotAType"});
    }

    public static final <T extends q> T addOriginatingElement(T r5, XElement r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "element");
        Element r11 = XElementKt.originatingElementForPoet(r10);
        if (r11 == null) goto L5;
        r5.b(r11);
    L5:
        return r5;
    }

    public static final c getKOTLIN_NONE_TYPE_NAME() {
        return KOTLIN_NONE_TYPE_NAME;
    }

    public static final a0 rawTypeName(a0 r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof u) == true) goto L5;
        return r5;
    L5:
        return ((u) r5).f;
    }
}
