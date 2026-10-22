package androidx.room.compiler.processing;

import com.squareup.javapoet.s;
import com.squareup.javapoet.t;
import com.squareup.javapoet.u;
import java.util.Arrays;
import java.util.Iterator;
import javax.lang.model.element.Modifier;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\nJ5\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\"\u00020\u0010H\u0002¢\u0006\u0004\b\u000b\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/room/compiler/processing/MethodSpecHelper;", "", "<init>", "()V", "Landroidx/room/compiler/processing/XMethodElement;", "elm", "Landroidx/room/compiler/processing/XType;", "owner", "Lcom/squareup/javapoet/s;", "overridingWithFinalParams", "(Landroidx/room/compiler/processing/XMethodElement;Landroidx/room/compiler/processing/XType;)Lcom/squareup/javapoet/s;", "overriding", "executableElement", "Landroidx/room/compiler/processing/XMethodType;", "resolvedType", "", "Ljavax/lang/model/element/Modifier;", "paramModifiers", "(Landroidx/room/compiler/processing/XMethodElement;Landroidx/room/compiler/processing/XMethodType;[Ljavax/lang/model/element/Modifier;)Lcom/squareup/javapoet/s;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MethodSpecHelper {
    public static final MethodSpecHelper INSTANCE = null;

    static {
        INSTANCE = new MethodSpecHelper();
    }

    private MethodSpecHelper() {
    }

    @JvmStatic
    public static final s overriding(XMethodElement r5, XType r10) {
        Intrinsics.checkNotNullParameter(r5, "elm");
        Intrinsics.checkNotNullParameter(r10, "owner");
        XMethodType r11 = r5.asMemberOf(r10);
        return INSTANCE.overriding(r5, r11, new Modifier[0]);
    }

    public static /* synthetic */ s overriding$default(MethodSpecHelper r5, XMethodElement r10, XMethodType r11, Modifier[] r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = r10.getExecutableType();
    L6:
        return r5.overriding(r10, r11, r12);
    }

    @JvmStatic
    public static final s overridingWithFinalParams(XMethodElement r5, XType r10) {
        Intrinsics.checkNotNullParameter(r5, "elm");
        Intrinsics.checkNotNullParameter(r10, "owner");
        XMethodType r11 = r5.asMemberOf(r10);
        return INSTANCE.overriding(r5, r11, new Modifier[]{Modifier.FINAL});
    }

    private final s overriding(XMethodElement r10, XMethodType r11, Modifier... r12) {
        s r13 = t.e(r10.getJvmName());
        r13.p(r11.getTypeVariableNames());
        Iterator<T> r5 = r11.getParameterTypes().iterator();
        int r14 = 0;
    L4:
        if (r5.hasNext() == false) goto L10;
        Object r15 = r5.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r13.m(u.a(((XType) r15).asTypeName().getJava$room_compiler_processing(), r10.getParameters().get(r14).getName(), (Modifier[]) Arrays.copyOf(r12, r12.length)).n());
        r14 = r16;
        goto L4
    L10:
        if (r10.isPublic() == false) goto L13;
        r13.l(new Modifier[]{Modifier.PUBLIC});
    L15:
        r13.h();
        r13.x(r10.isVarArgs());
        Iterator<T> r17 = r10.getThrownTypes().iterator();
    L17:
        if (r17.hasNext() == false) goto L19;
        r13.k(((XType) r17.next()).asTypeName().getJava$room_compiler_processing());
        goto L17
    L19:
        r13.v(r11.getReturnType().asTypeName().getJava$room_compiler_processing());
        return r13;
    L13:
        if (r10.isProtected() == false) goto L15;
        r13.l(new Modifier[]{Modifier.PROTECTED});
        goto L15
    }
}
