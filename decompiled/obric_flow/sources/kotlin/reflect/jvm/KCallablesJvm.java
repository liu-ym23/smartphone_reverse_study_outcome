package kotlin.reflect.jvm;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\",\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"value", "", "isAccessible", "Lkotlin/reflect/KCallable;", "(Lkotlin/reflect/KCallable;)Z", "setAccessible", "(Lkotlin/reflect/KCallable;Z)V", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
@JvmName(name = "KCallablesJvm")
public final class KCallablesJvm {
    public static final boolean isAccessible(KCallable<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof KMutableProperty) == false) goto L21;
        KProperty r10 = (KProperty) r5;
        Field r11 = ReflectJvmMapping.getJavaField(r10);
        if (r11 == null) goto L7;
        boolean r12 = r11.isAccessible();
    L8:
        if (r12 == false) goto L85;
        Method r13 = ReflectJvmMapping.getJavaGetter(r10);
        if (r13 == null) goto L12;
        boolean r14 = r13.isAccessible();
    L13:
        if (r14 == false) goto L88;
        Method r15 = ReflectJvmMapping.getJavaSetter((KMutableProperty) r5);
        if (r15 == null) goto L17;
        boolean r16 = r15.isAccessible();
    L18:
        if (r16 == true) goto L90;
        return false;
    L90:
        return true;
    L17:
        r16 = true;
        goto L18
    L88:
        return false;
    L12:
        r14 = true;
        goto L13
    L85:
        return false;
    L7:
        r12 = true;
        goto L8
    L21:
        if ((r5 instanceof KProperty) == false) goto L34;
        KProperty r17 = (KProperty) r5;
        Field r18 = ReflectJvmMapping.getJavaField(r17);
        if (r18 == null) goto L25;
        boolean r19 = r18.isAccessible();
    L26:
        if (r19 == false) goto L91;
        Method r20 = ReflectJvmMapping.getJavaGetter(r17);
        if (r20 == null) goto L30;
        boolean r21 = r20.isAccessible();
    L31:
        if (r21 == true) goto L90;
        return false;
    L30:
        r21 = true;
        goto L31
    L91:
        return false;
    L25:
        r19 = true;
        goto L26
    L34:
        if ((r5 instanceof KProperty.Getter) == false) goto L47;
        Field r22 = ReflectJvmMapping.getJavaField(((KProperty.Getter) r5).getProperty());
        if (r22 == null) goto L38;
        boolean r23 = r22.isAccessible();
    L39:
        if (r23 == false) goto L93;
        Method r24 = ReflectJvmMapping.getJavaMethod((KFunction) r5);
        if (r24 == null) goto L43;
        boolean r25 = r24.isAccessible();
    L44:
        if (r25 == true) goto L90;
        return false;
    L43:
        r25 = true;
        goto L44
    L93:
        return false;
    L38:
        r23 = true;
        goto L39
    L47:
        if ((r5 instanceof KMutableProperty.Setter) == false) goto L60;
        Field r26 = ReflectJvmMapping.getJavaField(((KMutableProperty.Setter) r5).getProperty());
        if (r26 == null) goto L51;
        boolean r27 = r26.isAccessible();
    L52:
        if (r27 == false) goto L95;
        Method r28 = ReflectJvmMapping.getJavaMethod((KFunction) r5);
        if (r28 == null) goto L56;
        boolean r29 = r28.isAccessible();
    L57:
        if (r29 == true) goto L90;
        return false;
    L56:
        r29 = true;
        goto L57
    L95:
        return false;
    L51:
        r27 = true;
        goto L52
    L60:
        if ((r5 instanceof KFunction) == false) goto L87;
        KFunction r30 = (KFunction) r5;
        Method r31 = ReflectJvmMapping.getJavaMethod(r30);
        if (r31 == null) goto L64;
        boolean r32 = r31.isAccessible();
    L65:
        if (r32 == false) goto L97;
        KCallableImpl<?> r33 = UtilKt.asKCallableImpl(r5);
        AccessibleObject r34 = null;
        if (r33 == null) goto L71;
        Caller<?> r35 = r33.getDefaultCaller();
        if (r35 == null) goto L71;
        Member r36 = r35.mo1394getMember();
    L73:
        if ((r36 instanceof AccessibleObject) == false) goto L75;
        r34 = (AccessibleObject) r36;
    L75:
        if (r34 == null) goto L77;
        boolean r37 = r34.isAccessible();
    L78:
        if (r37 == false) goto L98;
        Constructor r38 = ReflectJvmMapping.getJavaConstructor(r30);
        if (r38 == null) goto L82;
        boolean r39 = r38.isAccessible();
    L83:
        if (r39 == true) goto L90;
        return false;
    L82:
        r39 = true;
        goto L83
    L98:
        return false;
    L77:
        r37 = true;
    L71:
        r36 = null;
        goto L73
    L97:
        return false;
    L64:
        r32 = true;
        goto L65
    L87:
        throw new UnsupportedOperationException("Unknown callable: " + r5 + " (" + r5.getClass() + ')');
    }

    public static final void setAccessible(KCallable<?> r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof KMutableProperty) == false) goto L17;
        KProperty r11 = (KProperty) r5;
        Field r12 = ReflectJvmMapping.getJavaField(r11);
        if (r12 == null) goto L8;
        r12.setAccessible(r10);
    L8:
        Method r13 = ReflectJvmMapping.getJavaGetter(r11);
        if (r13 == null) goto L12;
        r13.setAccessible(r10);
    L12:
        Method r14 = ReflectJvmMapping.getJavaSetter((KMutableProperty) r5);
        if (r14 == null) goto L75;
        r14.setAccessible(r10);
        return;
    L75:
        return;
    L17:
        if ((r5 instanceof KProperty) == false) goto L27;
        KProperty r15 = (KProperty) r5;
        Field r16 = ReflectJvmMapping.getJavaField(r15);
        if (r16 == null) goto L22;
        r16.setAccessible(r10);
    L22:
        Method r17 = ReflectJvmMapping.getJavaGetter(r15);
        if (r17 == null) goto L76;
        r17.setAccessible(r10);
        return;
    L76:
        return;
    L27:
        if ((r5 instanceof KProperty.Getter) == false) goto L37;
        Field r18 = ReflectJvmMapping.getJavaField(((KProperty.Getter) r5).getProperty());
        if (r18 == null) goto L32;
        r18.setAccessible(r10);
    L32:
        Method r19 = ReflectJvmMapping.getJavaMethod((KFunction) r5);
        if (r19 == null) goto L77;
        r19.setAccessible(r10);
        return;
    L77:
        return;
    L37:
        if ((r5 instanceof KMutableProperty.Setter) == false) goto L47;
        Field r20 = ReflectJvmMapping.getJavaField(((KMutableProperty.Setter) r5).getProperty());
        if (r20 == null) goto L42;
        r20.setAccessible(r10);
    L42:
        Method r21 = ReflectJvmMapping.getJavaMethod((KFunction) r5);
        if (r21 == null) goto L78;
        r21.setAccessible(r10);
        return;
    L78:
        return;
    L47:
        if ((r5 instanceof KFunction) == false) goto L70;
        KFunction r22 = (KFunction) r5;
        Method r23 = ReflectJvmMapping.getJavaMethod(r22);
        if (r23 == null) goto L52;
        r23.setAccessible(r10);
    L52:
        KCallableImpl<?> r24 = UtilKt.asKCallableImpl(r5);
        AccessibleObject r25 = null;
        if (r24 == null) goto L57;
        Caller<?> r26 = r24.getDefaultCaller();
        if (r26 == null) goto L57;
        Member r27 = r26.mo1394getMember();
    L59:
        if ((r27 instanceof AccessibleObject) == false) goto L61;
        r25 = (AccessibleObject) r27;
    L61:
        if (r25 == null) goto L64;
        r25.setAccessible(true);
    L64:
        Constructor r28 = ReflectJvmMapping.getJavaConstructor(r22);
        if (r28 == null) goto L79;
        r28.setAccessible(r10);
        return;
    L79:
        return;
    L57:
        r27 = null;
        goto L59
    L70:
        throw new UnsupportedOperationException("Unknown callable: " + r5 + " (" + r5.getClass() + ')');
    }
}
