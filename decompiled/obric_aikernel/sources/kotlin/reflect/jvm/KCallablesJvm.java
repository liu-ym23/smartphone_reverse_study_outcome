package kotlin.reflect.jvm;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "KCallablesJvm")
public final class KCallablesJvm {
    public static final boolean isAccessible(KCallable<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof KMutableProperty) == false) goto L21;
        KProperty r11 = (KProperty) r10;
        Field r12 = ReflectJvmMapping.getJavaField(r11);
        if (r12 == null) goto L7;
        boolean r13 = r12.isAccessible();
    L8:
        if (r13 == false) goto L85;
        Method r14 = ReflectJvmMapping.getJavaGetter(r11);
        if (r14 == null) goto L12;
        boolean r15 = r14.isAccessible();
    L13:
        if (r15 == false) goto L88;
        Method r16 = ReflectJvmMapping.getJavaSetter((KMutableProperty) r10);
        if (r16 == null) goto L17;
        boolean r17 = r16.isAccessible();
    L18:
        if (r17 == true) goto L92;
        return false;
    L92:
        return true;
    L17:
        r17 = true;
        goto L18
    L88:
        return false;
    L12:
        r15 = true;
        goto L13
    L85:
        return false;
    L7:
        r13 = true;
        goto L8
    L21:
        if ((r10 instanceof KProperty) == false) goto L34;
        KProperty r18 = (KProperty) r10;
        Field r19 = ReflectJvmMapping.getJavaField(r18);
        if (r19 == null) goto L25;
        boolean r20 = r19.isAccessible();
    L26:
        if (r20 == false) goto L90;
        Method r21 = ReflectJvmMapping.getJavaGetter(r18);
        if (r21 == null) goto L30;
        boolean r22 = r21.isAccessible();
    L31:
        if (r22 == true) goto L92;
        return false;
    L30:
        r22 = true;
        goto L31
    L90:
        return false;
    L25:
        r20 = true;
        goto L26
    L34:
        if ((r10 instanceof KProperty.Getter) == false) goto L47;
        Field r23 = ReflectJvmMapping.getJavaField(((KProperty.Getter) r10).getProperty());
        if (r23 == null) goto L38;
        boolean r24 = r23.isAccessible();
    L39:
        if (r24 == false) goto L93;
        Method r25 = ReflectJvmMapping.getJavaMethod((KFunction) r10);
        if (r25 == null) goto L43;
        boolean r26 = r25.isAccessible();
    L44:
        if (r26 == true) goto L92;
        return false;
    L43:
        r26 = true;
        goto L44
    L93:
        return false;
    L38:
        r24 = true;
        goto L39
    L47:
        if ((r10 instanceof KMutableProperty.Setter) == false) goto L60;
        Field r27 = ReflectJvmMapping.getJavaField(((KMutableProperty.Setter) r10).getProperty());
        if (r27 == null) goto L51;
        boolean r28 = r27.isAccessible();
    L52:
        if (r28 == false) goto L95;
        Method r29 = ReflectJvmMapping.getJavaMethod((KFunction) r10);
        if (r29 == null) goto L56;
        boolean r30 = r29.isAccessible();
    L57:
        if (r30 == true) goto L92;
        return false;
    L56:
        r30 = true;
        goto L57
    L95:
        return false;
    L51:
        r28 = true;
        goto L52
    L60:
        if ((r10 instanceof KFunction) == false) goto L87;
        KFunction r31 = (KFunction) r10;
        Method r32 = ReflectJvmMapping.getJavaMethod(r31);
        if (r32 == null) goto L64;
        boolean r33 = r32.isAccessible();
    L65:
        if (r33 == false) goto L97;
        KCallableImpl<?> r34 = UtilKt.asKCallableImpl(r10);
        AccessibleObject r35 = null;
        if (r34 == null) goto L71;
        Caller<?> r36 = r34.getDefaultCaller();
        if (r36 == null) goto L71;
        Member r37 = r36.mo1315getMember();
    L73:
        if ((r37 instanceof AccessibleObject) == false) goto L75;
        r35 = (AccessibleObject) r37;
    L75:
        if (r35 == null) goto L77;
        boolean r38 = r35.isAccessible();
    L78:
        if (r38 == false) goto L98;
        Constructor r39 = ReflectJvmMapping.getJavaConstructor(r31);
        if (r39 == null) goto L82;
        boolean r40 = r39.isAccessible();
    L83:
        if (r40 == true) goto L92;
        return false;
    L82:
        r40 = true;
        goto L83
    L98:
        return false;
    L77:
        r38 = true;
    L71:
        r37 = null;
        goto L73
    L97:
        return false;
    L64:
        r33 = true;
        goto L65
    L87:
        throw new UnsupportedOperationException("Unknown callable: " + r10 + " (" + r10.getClass() + ')');
    }

    public static final void setAccessible(KCallable<?> r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof KMutableProperty) == false) goto L16;
        KProperty r12 = (KProperty) r10;
        Field r13 = ReflectJvmMapping.getJavaField(r12);
        if (r13 == null) goto L8;
        r13.setAccessible(r11);
    L8:
        Method r14 = ReflectJvmMapping.getJavaGetter(r12);
        if (r14 == null) goto L12;
        r14.setAccessible(r11);
    L12:
        Method r15 = ReflectJvmMapping.getJavaSetter((KMutableProperty) r10);
        if (r15 == null) goto L69;
    L24:
        r15.setAccessible(r11);
        return;
    L69:
        return;
    L16:
        if ((r10 instanceof KProperty) == false) goto L26;
        KProperty r16 = (KProperty) r10;
        Field r17 = ReflectJvmMapping.getJavaField(r16);
        if (r17 == null) goto L21;
        r17.setAccessible(r11);
    L21:
        r15 = ReflectJvmMapping.getJavaGetter(r16);
        if (r15 != null) goto L24;
        return;
    L26:
        if ((r10 instanceof KProperty.Getter) == false) goto L35;
        Field r18 = ReflectJvmMapping.getJavaField(((KProperty.Getter) r10).getProperty());
        if (r18 == null) goto L31;
        r18.setAccessible(r11);
    L31:
        r15 = ReflectJvmMapping.getJavaMethod((KFunction) r10);
        if (r15 != null) goto L24;
        return;
    L35:
        if ((r10 instanceof KMutableProperty.Setter) == false) goto L44;
        Field r19 = ReflectJvmMapping.getJavaField(((KMutableProperty.Setter) r10).getProperty());
        if (r19 == null) goto L40;
        r19.setAccessible(r11);
    L40:
        r15 = ReflectJvmMapping.getJavaMethod((KFunction) r10);
        if (r15 != null) goto L24;
        return;
    L44:
        if ((r10 instanceof KFunction) == false) goto L67;
        KFunction r20 = (KFunction) r10;
        Method r21 = ReflectJvmMapping.getJavaMethod(r20);
        if (r21 == null) goto L49;
        r21.setAccessible(r11);
    L49:
        KCallableImpl<?> r22 = UtilKt.asKCallableImpl(r10);
        AccessibleObject r23 = null;
        if (r22 == null) goto L54;
        Caller<?> r24 = r22.getDefaultCaller();
        if (r24 == null) goto L54;
        Member r25 = r24.mo1315getMember();
    L56:
        if ((r25 instanceof AccessibleObject) == false) goto L58;
        r23 = (AccessibleObject) r25;
    L58:
        if (r23 == null) goto L61;
        r23.setAccessible(true);
    L61:
        Constructor r26 = ReflectJvmMapping.getJavaConstructor(r20);
        if (r26 == null) goto L73;
        r26.setAccessible(r11);
        return;
    L73:
        return;
    L54:
        r25 = null;
        goto L56
    L67:
        throw new UnsupportedOperationException("Unknown callable: " + r10 + " (" + r10.getClass() + ')');
    }
}
