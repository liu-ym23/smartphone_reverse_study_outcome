package androidx.room.compiler.codegen;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.processing.XNullability;
import com.squareup.javapoet.e;
import com.squareup.javapoet.x;
import io.reactivex.exceptions.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\b\u001a\u00020\u0007*\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\b\u0010\t\"\u001a\u0010\u000b\u001a\u00020\n8\u0000X\u0080D¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u001a\u0010\u000f\u001a\u00020\n8\u0000X\u0080D¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e\"\u001a\u0010\u0011\u001a\u00020\n8\u0000X\u0080D¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u001a\u0010\u0013\u001a\u00020\n8\u0000X\u0080D¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000e\"\u001a\u0010\u0015\u001a\u00020\n8\u0000X\u0080D¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000e*\n\u0010\u0018\"\u00020\u00172\u00020\u0017*\n\u0010\u001a\"\u00020\u00192\u00020\u0019*\n\u0010\u001c\"\u00020\u001b2\u00020\u001b*\n\u0010\u001e\"\u00020\u001d2\u00020\u001d*\n\u0010 \"\u00020\u001f2\u00020\u001f*\n\u0010\"\"\u00020!2\u00020!*\n\u0010$\"\u00020#2\u00020#*\n\u0010&\"\u00020%2\u00020%*\n\u0010(\"\u00020'2\u00020'¨\u0006)"}, d2 = {"Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/javapoet/JTypeName;", "Landroidx/room/compiler/codegen/XTypeName;", "toXTypeName", "(Lcom/squareup/javapoet/x;)Landroidx/room/compiler/codegen/XTypeName;", "Lcom/squareup/javapoet/e;", "Lcom/squareup/kotlinpoet/javapoet/JClassName;", "Landroidx/room/compiler/codegen/XClassName;", "toXClassName", "(Lcom/squareup/javapoet/e;)Landroidx/room/compiler/codegen/XClassName;", "", "L", "Ljava/lang/String;", "getL", "()Ljava/lang/String;", ExifInterface.GPS_DIRECTION_TRUE, "getT", "N", "getN", ExifInterface.LATITUDE_SOUTH, "getS", ExifInterface.LONGITUDE_WEST, "getW", "Lcom/squareup/javapoet/a;", "JAnnotationSpecBuilder", "Lcom/squareup/javapoet/c;", "JArrayTypeName", "Lcom/squareup/javapoet/i;", "JCodeBlock", "Lcom/squareup/javapoet/g;", "JCodeBlockBuilder", "Lcom/squareup/javapoet/y;", "JTypeSpecBuilder", "Lcom/squareup/kotlinpoet/a;", "KAnnotationSpecBuilder", "Lcom/squareup/kotlinpoet/e;", "KCodeBlock", "Lcom/squareup/kotlinpoet/d;", "KCodeBlockBuilder", "Lcom/squareup/kotlinpoet/c0;", "KTypeSpecBuilder", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PoetExtKt {
    private static final String L = "$L";
    private static final String N = "$N";
    private static final String S = "$S";
    private static final String T = "$T";
    private static final String W = "$W";

    public static final String getL() {
        return L;
    }

    public static final String getN() {
        return N;
    }

    public static final String getS() {
        return S;
    }

    public static final String getT() {
        return T;
    }

    public static final String getW() {
        return W;
    }

    public static final XClassName toXClassName(e r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new XClassName(r5, a.q(r5), XNullability.NONNULL);
    }

    public static final XTypeName toXTypeName(x r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return XTypeName.Companion.invoke(r5, a.r(r5), XNullability.NONNULL);
    }
}
