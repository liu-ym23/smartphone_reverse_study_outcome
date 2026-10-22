package kotlin.reflect.jvm.internal.calls;

import androidx.core.app.NotificationCompat;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002 !B?\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0016¢\u0006\u0002\u0010\u001fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "jClass", "Ljava/lang/Class;", "parameterNames", "", "", "callMode", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "defaultValues", "", "erasedParameterTypes", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", NotificationCompat.CATEGORY_CALL, "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", "Origin", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnnotationConstructorCaller.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnotationConstructorCaller.kt\nkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,181:1\n1549#2:182\n1620#2,3:183\n1549#2:186\n1620#2,2:187\n1622#2:190\n1549#2:191\n1620#2,3:192\n1549#2:195\n1620#2,3:196\n1#3:189\n11425#4:199\n11536#4,4:200\n*S KotlinDebug\n*F\n+ 1 AnnotationConstructorCaller.kt\nkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller\n*L\n28#1:182\n28#1:183,3\n35#1:186\n35#1:187,2\n35#1:190\n37#1:191\n37#1:192,3\n20#1:195\n20#1:196,3\n53#1:199\n53#1:200,4\n*E\n"})
public final class AnnotationConstructorCaller implements Caller {
    private final CallMode callMode;
    private final List<Object> defaultValues;
    private final List<Class<?>> erasedParameterTypes;
    private final Class<?> jClass;
    private final List<Method> methods;
    private final List<String> parameterNames;
    private final List<Type> parameterTypes;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum CallMode extends Enum<CallMode> {
        private static final /* synthetic */ CallMode[] $VALUES = null;
        public static final CallMode CALL_BY_NAME = null;
        public static final CallMode POSITIONAL_CALL = null;

        private static final /* synthetic */ CallMode[] $values() {
            return new CallMode[]{CALL_BY_NAME, POSITIONAL_CALL};
        }

        static {
            CALL_BY_NAME = new CallMode("CALL_BY_NAME", 0);
            POSITIONAL_CALL = new CallMode("POSITIONAL_CALL", 1);
            $VALUES = $values();
        }

        private CallMode(String r5, int r10) {
            super(r5, r10);
        }

        public static CallMode valueOf(String r5) {
            return (CallMode) Enum.valueOf(CallMode.class, r5);
        }

        public static CallMode[] values() {
            return (CallMode[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum Origin extends Enum<Origin> {
        private static final /* synthetic */ Origin[] $VALUES = null;
        public static final Origin JAVA = null;
        public static final Origin KOTLIN = null;

        private static final /* synthetic */ Origin[] $values() {
            return new Origin[]{JAVA, KOTLIN};
        }

        static {
            JAVA = new Origin("JAVA", 0);
            KOTLIN = new Origin("KOTLIN", 1);
            $VALUES = $values();
        }

        private Origin(String r5, int r10) {
            super(r5, r10);
        }

        public static Origin valueOf(String r5) {
            return (Origin) Enum.valueOf(Origin.class, r5);
        }

        public static Origin[] values() {
            return (Origin[]) $VALUES.clone();
        }
    }

    public AnnotationConstructorCaller(Class<?> r5, List<String> r10, CallMode r11, Origin r12, List<Method> r13) {
        Intrinsics.checkNotNullParameter(r5, "jClass");
        Intrinsics.checkNotNullParameter(r10, "parameterNames");
        Intrinsics.checkNotNullParameter(r11, "callMode");
        Intrinsics.checkNotNullParameter(r12, "origin");
        Intrinsics.checkNotNullParameter(r13, "methods");
        this.jClass = r5;
        this.parameterNames = r10;
        this.callMode = r11;
        this.methods = r13;
        ArrayList r14 = new ArrayList(CollectionsKt.h(r13));
        Iterator<T> r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        r14.add(((Method) r15.next()).getGenericReturnType());
        goto L4
    L6:
        this.parameterTypes = r14;
        List<Method> r16 = this.methods;
        ArrayList r17 = new ArrayList(CollectionsKt.h(r16));
        Iterator<T> r18 = r16.iterator();
    L8:
        if (r18.hasNext() == false) goto L14;
        Class<?> r19 = ((Method) r18.next()).getReturnType();
        Class<?> r20 = ReflectClassUtilKt.getWrapperByPrimitive(r19);
        if (r20 == null) goto L13;
        r19 = r20;
    L13:
        r17.add(r19);
        goto L8
    L14:
        this.erasedParameterTypes = r17;
        List<Method> r21 = this.methods;
        ArrayList r22 = new ArrayList(CollectionsKt.h(r21));
        Iterator<T> r23 = r21.iterator();
    L16:
        if (r23.hasNext() == false) goto L18;
        r22.add(((Method) r23.next()).getDefaultValue());
        goto L16
    L18:
        this.defaultValues = r22;
        if (this.callMode == CallMode.POSITIONAL_CALL) goto L21;
        return;
    L21:
        if (r12 == Origin.JAVA) goto L23;
        return;
    L23:
        if (CollectionsKt.u(this.parameterNames).isEmpty() == false) goto L26;
        return;
    L26:
        throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Object call(Object[] r10) {
        Intrinsics.checkNotNullParameter(r10, "args");
        checkArguments(r10);
        ArrayList r5 = new ArrayList(r10.length);
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L15;
        Object r14 = r10[r12];
        int r15 = r13 + 1;
        if (r14 == null) goto L7;
    L9:
        Object r16 = AnnotationConstructorCallerKt.access$transformKotlinToJvm(r14, this.erasedParameterTypes.get(r13));
    L10:
        if (r16 == null) goto L12;
        r5.add(r16);
        r12 = r12 + 1;
        r13 = r15;
        goto L3
    L12:
        AnnotationConstructorCallerKt.access$throwIllegalArgumentType(r13, this.parameterNames.get(r13), this.erasedParameterTypes.get(r13));
        throw null;
    L7:
        if (this.callMode != CallMode.CALL_BY_NAME) goto L9;
        r16 = this.defaultValues.get(r13);
        goto L10
    L15:
        return AnnotationConstructorCallerKt.createAnnotationInstance(this.jClass, MapsKt.toMap(CollectionsKt.zip(this.parameterNames, r5)), this.methods);
    }

    public void checkArguments(Object[] r5) {
        Caller.DefaultImpls.checkArguments(this, r5);
    }

    public Void getMember() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public List<Type> getParameterTypes() {
        return this.parameterTypes;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Type getReturnType() {
        return this.jClass;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* JADX INFO: renamed from: getMember, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Member mo1394getMember() {
        return (Member) getMember();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List] */
    public /* synthetic */ AnnotationConstructorCaller(Class r10, List r11, CallMode r12, Origin r13, List r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 16) == 0) goto L8;
        r14 = new ArrayList(CollectionsKt.h(r11));
        Iterator r17 = r11.iterator();
    L6:
        if (r17.hasNext() == false) goto L8;
        r14.add(r10.getDeclaredMethod((String) r17.next(), null));
    L8:
        this(r10, r11, r12, r13, r14);
    }
}
