package androidx.room.processor;

import androidx.room.Delete;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.preconditions.Checks;
import androidx.room.solver.shortcut.binder.DeleteOrUpdateMethodBinder;
import androidx.room.vo.DeletionMethod;
import androidx.room.vo.ShortcutEntity;
import androidx.room.vo.ShortcutQueryParameter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/room/processor/DeletionMethodProcessor;", "", "baseContext", "Landroidx/room/processor/Context;", "containing", "Landroidx/room/compiler/processing/XType;", "executableElement", "Landroidx/room/compiler/processing/XMethodElement;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XMethodElement;)V", "getContaining", "()Landroidx/room/compiler/processing/XType;", "context", "getContext", "()Landroidx/room/processor/Context;", "getExecutableElement", "()Landroidx/room/compiler/processing/XMethodElement;", "process", "Landroidx/room/vo/DeletionMethod;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DeletionMethodProcessor {
    private final XType containing;
    private final Context context;
    private final XMethodElement executableElement;

    public DeletionMethodProcessor(Context r5, XType r10, XMethodElement r11) {
        Intrinsics.checkNotNullParameter(r5, "baseContext");
        Intrinsics.checkNotNullParameter(r10, "containing");
        Intrinsics.checkNotNullParameter(r11, "executableElement");
        this.containing = r10;
        this.executableElement = r11;
        this.context = Context.fork$default(r5, r11, null, 2, null);
    }

    public final XType getContaining() {
        return this.containing;
    }

    public final Context getContext() {
        return this.context;
    }

    public final XMethodElement getExecutableElement() {
        return this.executableElement;
    }

    public final DeletionMethod process() {
        ShortcutMethodProcessor r5 = new ShortcutMethodProcessor(this.context, this.containing, this.executableElement);
        KClass r10 = Reflection.getOrCreateKotlinClass(Delete.class);
        ProcessorErrors r11 = ProcessorErrors.INSTANCE;
        XAnnotationBox r12 = r5.extractAnnotation(r10, r11.getMISSING_DELETE_ANNOTATION());
        DeleteOrUpdateMethodBinder r13 = r5.findDeleteOrUpdateMethodBinder(r5.extractReturnType());
        Checks r14 = this.context.getChecker();
        if (r13.getAdapter() == null) goto L5;
        boolean r15 = true;
    L6:
        r14.check(r15, this.executableElement, r11.getCANNOT_FIND_DELETE_RESULT_ADAPTER(), new Object[0]);
        if (r12 == null) goto L9;
        XType r16 = r12.getAsType("entity");
    L10:
        Pair<Map<String, ShortcutEntity>, List<ShortcutQueryParameter>> r17 = r5.extractParams(r16, r11.getDELETION_MISSING_PARAMS(), AnonymousClass1.INSTANCE);
        return new DeletionMethod(r5.getExecutableElement(), r17.component1(), r17.component2(), r13);
    L9:
        r16 = null;
        goto L10
    L5:
        r15 = false;
        goto L6
    }
}
