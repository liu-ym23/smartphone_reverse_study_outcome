package androidx.room.vo;

import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import com.squareup.javapoet.x;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000eJ\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000eJ\u0010\u0010\u0015\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0010JL\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b\u0005\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b&\u0010\u000eR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b'\u0010\u000eR\u0017\u0010\n\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010#\u001a\u0004\b\n\u0010\u0010R\u001b\u0010-\u001a\u00020(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u00100\u001a\u00020(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b/\u0010,R\u001b\u00103\u001a\u00020(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010*\u001a\u0004\b2\u0010,R\u001b\u00106\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010*\u001a\u0004\b5\u0010\u001aR\u001b\u00108\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b7\u0010*\u001a\u0004\b8\u0010\u0010¨\u00069"}, d2 = {"Landroidx/room/vo/CustomTypeConverter;", "", "Landroidx/room/compiler/processing/XType;", "enclosingClass", "", "isEnclosingClassKotlinObject", "Landroidx/room/compiler/processing/XMethodElement;", "method", "from", "to", "isProvidedConverter", "<init>", "(Landroidx/room/compiler/processing/XType;ZLandroidx/room/compiler/processing/XMethodElement;Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XType;Z)V", "component1", "()Landroidx/room/compiler/processing/XType;", "component2", "()Z", "component3", "()Landroidx/room/compiler/processing/XMethodElement;", "component4", "component5", "component6", "copy", "(Landroidx/room/compiler/processing/XType;ZLandroidx/room/compiler/processing/XMethodElement;Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XType;Z)Landroidx/room/vo/CustomTypeConverter;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/room/compiler/processing/XType;", "getEnclosingClass", "Z", "Landroidx/room/compiler/processing/XMethodElement;", "getMethod", "getFrom", "getTo", "Lcom/squareup/javapoet/x;", "typeName$delegate", "Lkotlin/Lazy;", "getTypeName", "()Lcom/squareup/javapoet/x;", "typeName", "fromTypeName$delegate", "getFromTypeName", "fromTypeName", "toTypeName$delegate", "getToTypeName", "toTypeName", "methodName$delegate", "getMethodName", "methodName", "isStatic$delegate", "isStatic", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CustomTypeConverter {
    private final XType enclosingClass;
    private final XType from;
    private final Lazy fromTypeName$delegate;
    private final boolean isEnclosingClassKotlinObject;
    private final boolean isProvidedConverter;
    private final Lazy isStatic$delegate;
    private final XMethodElement method;
    private final Lazy methodName$delegate;

    /* JADX INFO: renamed from: to, reason: collision with root package name */
    private final XType f692to;
    private final Lazy toTypeName$delegate;
    private final Lazy typeName$delegate;

    public CustomTypeConverter(XType r5, boolean r10, XMethodElement r11, XType r12, XType r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r5, "enclosingClass");
        Intrinsics.checkNotNullParameter(r11, "method");
        Intrinsics.checkNotNullParameter(r12, "from");
        Intrinsics.checkNotNullParameter(r13, "to");
        this.enclosingClass = r5;
        this.isEnclosingClassKotlinObject = r10;
        this.method = r11;
        this.from = r12;
        this.f692to = r13;
        this.isProvidedConverter = r14;
        this.typeName$delegate = LazyKt.lazy(new CustomTypeConverter$typeName$2(this));
        this.fromTypeName$delegate = LazyKt.lazy(new CustomTypeConverter$fromTypeName$2(this));
        this.toTypeName$delegate = LazyKt.lazy(new CustomTypeConverter$toTypeName$2(this));
        this.methodName$delegate = LazyKt.lazy(new CustomTypeConverter$methodName$2(this));
        this.isStatic$delegate = LazyKt.lazy(new AnonymousClass2(this));
    }

    public static /* synthetic */ CustomTypeConverter copy$default(CustomTypeConverter r5, XType r10, boolean r11, XMethodElement r12, XType r13, XType r14, boolean r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r10 = r5.enclosingClass;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r11 = r5.isEnclosingClassKotlinObject;
    L8:
        boolean r18 = r11;
        if ((r16 & 4) == 0) goto L11;
        r12 = r5.method;
    L11:
        XMethodElement r19 = r12;
        if ((r16 & 8) == 0) goto L14;
        r13 = r5.from;
    L14:
        XType r20 = r13;
        if ((r16 & 16) == 0) goto L17;
        r14 = r5.f692to;
    L17:
        XType r21 = r14;
        if ((r16 & 32) == 0) goto L20;
        r15 = r5.isProvidedConverter;
    L20:
        XType r22 = r10;
        return r5.copy(r22, r18, r19, r20, r21, r15);
    }

    public final XType component1() {
        return this.enclosingClass;
    }

    public final boolean component2() {
        return this.isEnclosingClassKotlinObject;
    }

    public final XMethodElement component3() {
        return this.method;
    }

    public final XType component4() {
        return this.from;
    }

    public final XType component5() {
        return this.f692to;
    }

    public final boolean component6() {
        return this.isProvidedConverter;
    }

    public final CustomTypeConverter copy(XType r10, boolean r11, XMethodElement r12, XType r13, XType r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "enclosingClass");
        Intrinsics.checkNotNullParameter(r12, "method");
        Intrinsics.checkNotNullParameter(r13, "from");
        Intrinsics.checkNotNullParameter(r14, "to");
        return new CustomTypeConverter(r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CustomTypeConverter) == true) goto L8;
        return false;
    L8:
        CustomTypeConverter r10 = (CustomTypeConverter) r5;
        if (Intrinsics.areEqual(this.enclosingClass, r10.enclosingClass) == true) goto L12;
        return false;
    L12:
        if (this.isEnclosingClassKotlinObject == r10.isEnclosingClassKotlinObject) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.method, r10.method) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.from, r10.from) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f692to, r10.f692to) == true) goto L24;
        return false;
    L24:
        if (this.isProvidedConverter == r10.isProvidedConverter) goto L26;
        return false;
    L26:
        return true;
    }

    public final XType getEnclosingClass() {
        return this.enclosingClass;
    }

    public final XType getFrom() {
        return this.from;
    }

    public final x getFromTypeName() {
        return (x) this.fromTypeName$delegate.getValue();
    }

    public final XMethodElement getMethod() {
        return this.method;
    }

    public final String getMethodName() {
        return (String) this.methodName$delegate.getValue();
    }

    public final XType getTo() {
        return this.f692to;
    }

    public final x getToTypeName() {
        return (x) this.toTypeName$delegate.getValue();
    }

    public final x getTypeName() {
        return (x) this.typeName$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r5 = this.enclosingClass.hashCode() * 31;
        boolean r10 = this.isEnclosingClassKotlinObject;
        ?? r11 = 1;
        ?? r12 = r10;
        if (r10 == false) goto L5;
        r12 = 1;
    L5:
        int r13 = (this.f692to.hashCode() + ((this.from.hashCode() + ((this.method.hashCode() + ((r5 + r12) * 31)) * 31)) * 31)) * 31;
        boolean r14 = this.isProvidedConverter;
        if (r14 == true) goto L10;
        r11 = r14;
    L10:
        return r13 + r11;
    }

    public final boolean isEnclosingClassKotlinObject() {
        return this.isEnclosingClassKotlinObject;
    }

    public final boolean isProvidedConverter() {
        return this.isProvidedConverter;
    }

    public final boolean isStatic() {
        return ((Boolean) this.isStatic$delegate.getValue()).booleanValue();
    }

    public String toString() {
        return "CustomTypeConverter(enclosingClass=" + this.enclosingClass + ", isEnclosingClassKotlinObject=" + this.isEnclosingClassKotlinObject + ", method=" + this.method + ", from=" + this.from + ", to=" + this.f692to + ", isProvidedConverter=" + this.isProvidedConverter + ")";
    }
}
