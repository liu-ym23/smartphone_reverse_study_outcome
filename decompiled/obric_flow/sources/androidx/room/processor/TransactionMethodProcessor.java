package androidx.room.processor;

import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XRawType;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.compiler.processing.XVariableElement;
import androidx.room.ext.Javapoet_extKt;
import androidx.room.preconditions.Checks;
import androidx.room.vo.TransactionMethod;
import com.squareup.javapoet.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0014\u001a\u00020\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Landroidx/room/processor/TransactionMethodProcessor;", "", "baseContext", "Landroidx/room/processor/Context;", "containingElement", "Landroidx/room/compiler/processing/XTypeElement;", "containingType", "Landroidx/room/compiler/processing/XType;", "executableElement", "Landroidx/room/compiler/processing/XMethodElement;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XTypeElement;Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XMethodElement;)V", "getContainingElement", "()Landroidx/room/compiler/processing/XTypeElement;", "getContainingType", "()Landroidx/room/compiler/processing/XType;", "context", "getContext", "()Landroidx/room/processor/Context;", "getExecutableElement", "()Landroidx/room/compiler/processing/XMethodElement;", "process", "Landroidx/room/vo/TransactionMethod;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TransactionMethodProcessor {
    private final XTypeElement containingElement;
    private final XType containingType;
    private final Context context;
    private final XMethodElement executableElement;

    public TransactionMethodProcessor(Context r5, XTypeElement r10, XType r11, XMethodElement r12) {
        Intrinsics.checkNotNullParameter(r5, "baseContext");
        Intrinsics.checkNotNullParameter(r10, "containingElement");
        Intrinsics.checkNotNullParameter(r11, "containingType");
        Intrinsics.checkNotNullParameter(r12, "executableElement");
        this.containingElement = r10;
        this.containingType = r11;
        this.executableElement = r12;
        this.context = Context.fork$default(r5, r12, null, 2, null);
    }

    public final XTypeElement getContainingElement() {
        return this.containingElement;
    }

    public final XType getContainingType() {
        return this.containingType;
    }

    public final Context getContext() {
        return this.context;
    }

    public final XMethodElement getExecutableElement() {
        return this.executableElement;
    }

    public final TransactionMethod process() {
        MethodProcessorDelegate r5 = MethodProcessorDelegate.Companion.createFor(this.context, this.containingType, this.executableElement);
        boolean r10 = this.executableElement.hasKotlinDefaultImpl();
        Checks r11 = this.context.getChecker();
        if (this.executableElement.isOverrideableIgnoringContainer() == true) goto L5;
    L8:
        boolean r12 = false;
    L9:
        r11.check(r12, this.executableElement, ProcessorErrors.INSTANCE.getTRANSACTION_METHOD_MODIFIERS(), new Object[0]);
        XType r13 = r5.extractReturnType();
        XRawType r14 = r13.getRawType();
        Iterator<T> r15 = Javapoet_extKt.getDEFERRED_TYPES().iterator();
    L11:
        if (r15.hasNext() == false) goto L18;
        Object r16 = r15.next();
        XType r17 = this.context.getProcessingEnv().findType((e) r16);
        if (r17 == null) goto L15;
        boolean r18 = r17.getRawType().isAssignableFrom(r14);
    L16:
        if (r18 == false) goto L11;
    L19:
        e r19 = (e) r16;
        if (r19 == null) goto L23;
        this.context.getLogger().e(ProcessorErrors.INSTANCE.transactionMethodAsync(r19.toString()), new Object[]{this.executableElement});
    L23:
        if (this.executableElement.isJavaDefault() == true) goto L25;
        if (r10 == false) goto L31;
        TransactionMethod.CallType r20 = TransactionMethod.CallType.DEFAULT_KOTLIN;
    L27:
        TransactionMethod.CallType r110 = r20;
        XMethodElement r21 = this.executableElement;
        List<XVariableElement> r111 = r5.extractParams();
        ArrayList r112 = new ArrayList(CollectionsKt.h(r111));
        Iterator<T> r113 = r111.iterator();
    L34:
        if (r113.hasNext() == false) goto L37;
        r112.add(((XVariableElement) r113.next()).getName());
        goto L34
    L37:
        return new TransactionMethod(r21, r13, r112, r110, r5.findTransactionMethodBinder(r110));
    L31:
        r20 = TransactionMethod.CallType.CONCRETE;
        goto L27
    L25:
        if (this.containingElement.isInterface() == false) goto L28;
        r20 = TransactionMethod.CallType.DEFAULT_JAVA8;
        goto L27
    L28:
        r20 = TransactionMethod.CallType.INHERITED_DEFAULT_JAVA8;
        goto L27
    L15:
        r18 = false;
        goto L16
    L18:
        r16 = null;
        goto L19
    L5:
        if (this.executableElement.isAbstract() == false) goto L7;
        if (r10 == false) goto L8;
    L7:
        r12 = true;
        goto L9
    }
}
