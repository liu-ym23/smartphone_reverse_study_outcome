package kotlin.reflect.jvm.internal.calls;

import com.bytedance.crash.entity.EventBody;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationConstructorCaller implements Caller {
    private final CallMode callMode;
    private final List<Object> defaultValues;
    private final List<Class<?>> erasedParameterTypes;
    private final Class<?> jClass;
    private final List<Method> methods;
    private final List<String> parameterNames;
    private final List<Type> parameterTypes;

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

        private CallMode(String r10, int r11) {
            super(r10, r11);
        }

        public static CallMode valueOf(String r10) {
            return (CallMode) Enum.valueOf(CallMode.class, r10);
        }

        public static CallMode[] values() {
            return (CallMode[]) $VALUES.clone();
        }
    }

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

        private Origin(String r10, int r11) {
            super(r10, r11);
        }

        public static Origin valueOf(String r10) {
            return (Origin) Enum.valueOf(Origin.class, r10);
        }

        public static Origin[] values() {
            return (Origin[]) $VALUES.clone();
        }
    }

    public AnnotationConstructorCaller(Class<?> r10, List<String> r11, CallMode r12, Origin r13, List<Method> r14) {
        Intrinsics.checkNotNullParameter(r10, "jClass");
        Intrinsics.checkNotNullParameter(r11, "parameterNames");
        Intrinsics.checkNotNullParameter(r12, "callMode");
        Intrinsics.checkNotNullParameter(r13, "origin");
        Intrinsics.checkNotNullParameter(r14, "methods");
        this.jClass = r10;
        this.parameterNames = r11;
        this.callMode = r12;
        this.methods = r14;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r16 = r14.iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        r15.add(((Method) r16.next()).getGenericReturnType());
        goto L4
    L6:
        this.parameterTypes = r15;
        List<Method> r17 = this.methods;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<T> r19 = r17.iterator();
    L8:
        if (r19.hasNext() == false) goto L14;
        Class<?> r20 = ((Method) r19.next()).getReturnType();
        Intrinsics.checkNotNullExpressionValue(r20, "it");
        Class<?> r21 = ReflectClassUtilKt.getWrapperByPrimitive(r20);
        if (r21 == null) goto L13;
        r20 = r21;
    L13:
        r18.add(r20);
        goto L8
    L14:
        this.erasedParameterTypes = r18;
        List<Method> r22 = this.methods;
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator<T> r24 = r22.iterator();
    L16:
        if (r24.hasNext() == false) goto L18;
        r23.add(((Method) r24.next()).getDefaultValue());
        goto L16
    L18:
        this.defaultValues = r23;
        if (this.callMode == CallMode.POSITIONAL_CALL) goto L21;
        return;
    L21:
        if (r13 == Origin.JAVA) goto L23;
        return;
    L23:
        if ((!CollectionsKt.minus(this.parameterNames, EventBody.KEY_VALUE).isEmpty()) == true) goto L26;
        return;
    L26:
        throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
    }

    public /* synthetic */ AnnotationConstructorCaller(Class r10, List r11, CallMode r12, Origin r13, List r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 16) == 0) goto L8;
        r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r17 = r11.iterator();
    L6:
        if (r17.hasNext() == false) goto L8;
        r14.add(r10.getDeclaredMethod((String) r17.next(), new Class[0]));
    L8:
        this(r10, r11, r12, r13, r14);
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Object call(Object[] r10) {
        Intrinsics.checkNotNullParameter(r10, "args");
        checkArguments(r10);
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = r10.length;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L15;
        Object r15 = r10[r13];
        int r16 = r14 + 1;
        if (r15 == null) goto L7;
    L9:
        Object r17 = AnnotationConstructorCallerKt.access$transformKotlinToJvm(r15, this.erasedParameterTypes.get(r14));
    L10:
        if (r17 == null) goto L12;
        r11.add(r17);
        r13 = r13 + 1;
        r14 = r16;
        goto L3
    L12:
        AnnotationConstructorCallerKt.access$throwIllegalArgumentType(r14, this.parameterNames.get(r14), this.erasedParameterTypes.get(r14));
        throw null;
    L7:
        if (this.callMode != CallMode.CALL_BY_NAME) goto L9;
        r17 = this.defaultValues.get(r14);
        goto L10
    L15:
        return AnnotationConstructorCallerKt.createAnnotationInstance(this.jClass, MapsKt.toMap(CollectionsKt.zip(this.parameterNames, r11)), this.methods);
    }

    public void checkArguments(Object[] r10) {
        Caller.DefaultImpls.checkArguments(this, r10);
    }

    public Void getMember() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* JADX INFO: renamed from: getMember, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Member mo1315getMember() {
        return (Member) getMember();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public List<Type> getParameterTypes() {
        return this.parameterTypes;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Type getReturnType() {
        return this.jClass;
    }
}
