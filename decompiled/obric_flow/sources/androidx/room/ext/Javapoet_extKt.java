package androidx.room.ext;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.squareup.javapoet.c;
import com.squareup.javapoet.e;
import com.squareup.javapoet.i;
import com.squareup.javapoet.s;
import com.squareup.javapoet.t;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import com.squareup.javapoet.y;
import com.squareup.javapoet.z;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.lang.model.element.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a6\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u0006\u0010\u0004\u001a\u00020\u00002\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0004\b\f\u0010\r\u001aF\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00002\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0004\b\u0010\u0010\u0011\u001aK\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00052\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u001a\u0010\u001b\"\u001a\u0010\u001c\u001a\u00020\u00018\u0006X\u0086D¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u001a\u0010 \u001a\u00020\u00018\u0006X\u0086D¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001f\"\u001a\u0010\"\u001a\u00020\u00018\u0006X\u0086D¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u001a\u0010$\u001a\u00020\u00018\u0006X\u0086D¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\u001f\"\u001a\u0010&\u001a\u00020\u00018\u0006X\u0086D¢\u0006\f\n\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010\u001f\"%\u0010*\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010)0)0(8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0019\u00101\u001a\u00020)*\u0006\u0012\u0002\b\u00030.8F¢\u0006\u0006\u001a\u0004\b/\u00100\"\u0019\u00105\u001a\u000202*\u0006\u0012\u0002\b\u00030.8F¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/squareup/javapoet/x;", "", "defaultValue", "(Lcom/squareup/javapoet/x;)Ljava/lang/String;", "parameterTypeName", "Lkotlin/Function1;", "Lcom/squareup/javapoet/s;", "", "Lkotlin/ExtensionFunctionType;", "callBody", "Lcom/squareup/javapoet/y;", "kotlin.jvm.PlatformType", "CallableTypeSpecBuilder", "(Lcom/squareup/javapoet/x;Lkotlin/jvm/functions/Function1;)Lcom/squareup/javapoet/y;", "parameterName", "returnTypeName", "Function1TypeSpecBuilder", "(Lcom/squareup/javapoet/x;Ljava/lang/String;Lcom/squareup/javapoet/x;Lkotlin/jvm/functions/Function1;)Lcom/squareup/javapoet/y;", "type", "", "rowSize", "columnSizeProducer", "Lkotlin/Function2;", "", "valueProducer", "Lcom/squareup/javapoet/i;", "DoubleArrayLiteral", "(Lcom/squareup/javapoet/x;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/squareup/javapoet/i;", "L", "Ljava/lang/String;", "getL", "()Ljava/lang/String;", ExifInterface.GPS_DIRECTION_TRUE, "getT", "N", "getN", ExifInterface.LATITUDE_SOUTH, "getS", ExifInterface.LONGITUDE_WEST, "getW", "", "Lcom/squareup/javapoet/e;", "DEFERRED_TYPES", "Ljava/util/List;", "getDEFERRED_TYPES", "()Ljava/util/List;", "Lkotlin/reflect/KClass;", "getTypeName", "(Lkotlin/reflect/KClass;)Lcom/squareup/javapoet/e;", "typeName", "Lcom/squareup/javapoet/c;", "getArrayTypeName", "(Lkotlin/reflect/KClass;)Lcom/squareup/javapoet/c;", "arrayTypeName", "room-compiler"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class Javapoet_extKt {
    private static final List<e> DEFERRED_TYPES = null;
    private static final String L = "$L";
    private static final String N = "$N";
    private static final String S = "$S";
    private static final String T = "$T";
    private static final String W = "$W";

    static {
        LifecyclesTypeNames r5 = LifecyclesTypeNames.INSTANCE;
        e r10 = r5.getLIVE_DATA();
        e r11 = r5.getCOMPUTABLE_LIVE_DATA();
        RxJava2TypeNames r12 = RxJava2TypeNames.INSTANCE;
        e r13 = r12.getFLOWABLE();
        e r14 = r12.getOBSERVABLE();
        e r15 = r12.getMAYBE();
        e r16 = r12.getSINGLE();
        e r17 = r12.getCOMPLETABLE();
        RxJava3TypeNames r18 = RxJava3TypeNames.INSTANCE;
        DEFERRED_TYPES = CollectionsKt.listOf(new e[]{r10, r11, r13, r14, r15, r16, r17, r18.getFLOWABLE(), r18.getOBSERVABLE(), r18.getMAYBE(), r18.getSINGLE(), r18.getCOMPLETABLE(), GuavaUtilConcurrentTypeNames.INSTANCE.getLISTENABLE_FUTURE(), KotlinTypeNames.INSTANCE.getFLOW(), ReactiveStreamsTypeNames.INSTANCE.getPUBLISHER()});
    }

    public static final y CallableTypeSpecBuilder(x r5, Function1<? super s, Unit> r10) {
        Intrinsics.checkNotNullParameter(r5, "parameterTypeName");
        Intrinsics.checkNotNullParameter(r10, "callBody");
        y r11 = z.a("", new Object[0]);
        r11.f(v.n(getTypeName(Reflection.getOrCreateKotlinClass(Callable.class)), new x[]{r5}));
        s r12 = t.e(NotificationCompat.CATEGORY_CALL);
        r12.v(r5);
        r12.k(getTypeName(Reflection.getOrCreateKotlinClass(Exception.class)));
        r12.l(new Modifier[]{Modifier.PUBLIC});
        r12.h();
        r10.invoke(r12);
        r11.b(r12.r());
        return r11;
    }

    public static final i DoubleArrayLiteral(x r16, int r17, Function1<? super Integer, Integer> r18, Function2<? super Integer, ? super Integer, ? extends Object> r19) {
        Intrinsics.checkNotNullParameter(r16, "type");
        Intrinsics.checkNotNullParameter(r18, "columnSizeProducer");
        Intrinsics.checkNotNullParameter(r19, "valueProducer");
        String r5 = T;
        String r10 = W;
        String r11 = j0.q(a.y("new ", r5, "[][] {", r10, L), r10, "}");
        ArrayList r12 = new ArrayList(r17);
        int r13 = 0;
    L4:
        if (r13 >= r17) goto L14;
        String r14 = W;
        String r15 = j0.l("{", r14, L, r14, "}");
        int r110 = r18.invoke(Integer.valueOf(r13)).intValue();
        ArrayList r111 = new ArrayList(r110);
        int r112 = 0;
    L6:
        if (r112 >= r110) goto L12;
        if (Intrinsics.areEqual(r16, CommonTypeNames.INSTANCE.getSTRING()) == false) goto L10;
        String r113 = S;
    L11:
        r111.add(i.d(r113, new Object[]{r19.mo2invoke(Integer.valueOf(r13), Integer.valueOf(r112))}));
        r112 = r112 + 1;
        goto L6
    L10:
        r113 = L;
        goto L11
    L12:
        r12.add(i.d(r15, new Object[]{i.c("," + W, r111)}));
        r13 = r13 + 1;
        goto L4
    L14:
        return i.d(r11, new Object[]{r16, i.c("," + W, r12)});
    }

    public static final y Function1TypeSpecBuilder(x r5, String r10, x r11, Function1<? super s, Unit> r12) {
        Intrinsics.checkNotNullParameter(r5, "parameterTypeName");
        Intrinsics.checkNotNullParameter(r10, "parameterName");
        Intrinsics.checkNotNullParameter(r11, "returnTypeName");
        Intrinsics.checkNotNullParameter(r12, "callBody");
        y r13 = z.a("", new Object[0]);
        r13.f(v.n(getTypeName(Reflection.getOrCreateKotlinClass(Function1.class)), new x[]{r5, r11}));
        s r14 = t.e("invoke");
        r14.n(r5, r10, new Modifier[0]);
        r14.v(r11);
        r14.l(new Modifier[]{Modifier.PUBLIC});
        r14.h();
        r12.invoke(r14);
        r13.b(r14.r());
        return r13;
    }

    public static final String defaultValue(x r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.k() == true) goto L6;
        return "null";
    L6:
        if (Intrinsics.areEqual(r5, x.e) == false) goto L8;
        return "false";
    L8:
        return "0";
    }

    public static final c getArrayTypeName(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new c(getTypeName(r5));
    }

    public static final List<e> getDEFERRED_TYPES() {
        return DEFERRED_TYPES;
    }

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

    public static final e getTypeName(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return e.n(JvmClassMappingKt.getJavaClass(r5));
    }

    public static final String getW() {
        return W;
    }
}
