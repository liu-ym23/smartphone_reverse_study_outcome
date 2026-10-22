package androidx.room.processor;

import androidx.room.compiler.processing.XArrayType;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.compiler.processing.XTypeKt;
import androidx.room.compiler.processing.XVariableElement;
import androidx.room.vo.ShortcutQueryParameter;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\u0010\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0006\u0010\u0014\u001a\u00020\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Landroidx/room/processor/ShortcutParameterProcessor;", "", "baseContext", "Landroidx/room/processor/Context;", "containing", "Landroidx/room/compiler/processing/XType;", "element", "Landroidx/room/compiler/processing/XVariableElement;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XVariableElement;)V", "getContaining", "()Landroidx/room/compiler/processing/XType;", "context", "getContext", "()Landroidx/room/processor/Context;", "getElement", "()Landroidx/room/compiler/processing/XVariableElement;", "extractPojoType", "Lkotlin/Pair;", "", "typeMirror", "process", "Landroidx/room/vo/ShortcutQueryParameter;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ShortcutParameterProcessor {
    private final XType containing;
    private final Context context;
    private final XVariableElement element;

    public ShortcutParameterProcessor(Context r5, XType r10, XVariableElement r11) {
        Intrinsics.checkNotNullParameter(r5, "baseContext");
        Intrinsics.checkNotNullParameter(r10, "containing");
        Intrinsics.checkNotNullParameter(r11, "element");
        this.containing = r10;
        this.element = r11;
        this.context = Context.fork$default(r5, r11, null, 2, null);
    }

    private final Pair<XType, Boolean> extractPojoType(XType r5) {
        if (this.context.getProcessingEnv().requireType("java.lang.Iterable").getRawType().isAssignableFrom(r5) == false) goto L7;
        return extractPojoType$verifyAndPair(extractPojoType$extractPojoTypeFromIterator(r5), true);
    L7:
        if (XTypeKt.isArray(r5) == false) goto L11;
        return extractPojoType$verifyAndPair(((XArrayType) r5).getComponentType(), true);
    L11:
        return extractPojoType$verifyAndPair(r5, false);
    }

    private static final XType extractPojoType$extractPojoTypeFromIterator(XType r5) {
        XTypeElement r10 = r5.getTypeElement();
        Intrinsics.checkNotNull(r10);
        Iterator<XMethodElement> r11 = r10.getAllNonPrivateInstanceMethods().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        XMethodElement r12 = r11.next();
        if (Intrinsics.areEqual(r12.getJvmName(), "iterator") == false) goto L4;
        return (XType) CollectionsKt.first(r12.asMemberOf(r5).getReturnType().getTypeArguments());
    L10:
        throw new IllegalArgumentException("iterator() not found in Iterable " + r5);
    }

    private static final Pair<XType, Boolean> extractPojoType$verifyAndPair(XType r5, boolean r10) {
        XType r11 = r5.extendsBound();
        if (r11 == null) goto L6;
        return extractPojoType$verifyAndPair(r11, r10);
    L6:
        return new Pair(r5, Boolean.valueOf(r10));
    }

    public final XType getContaining() {
        return this.containing;
    }

    public final Context getContext() {
        return this.context;
    }

    public final XVariableElement getElement() {
        return this.element;
    }

    public final ShortcutQueryParameter process() {
        XType r5 = this.element.asMemberOf(this.containing);
        String r10 = this.element.getName();
        this.context.getChecker().check(!StringsKt.P(r10, "_"), this.element, ProcessorErrors.INSTANCE.getQUERY_PARAMETERS_CANNOT_START_WITH_UNDERSCORE(), new Object[0]);
        Pair<XType, Boolean> r11 = extractPojoType(r5);
        return new ShortcutQueryParameter(this.element, r10, r5, r11.component1(), r11.component2().booleanValue());
    }
}
