package androidx.room.processor;

import androidx.room.Upsert;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.preconditions.Checks;
import androidx.room.solver.shortcut.binder.InsertOrUpsertMethodBinder;
import androidx.room.vo.ShortcutEntity;
import androidx.room.vo.ShortcutQueryParameter;
import androidx.room.vo.UpsertionMethod;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/room/processor/UpsertionMethodProcessor;", "", "baseContext", "Landroidx/room/processor/Context;", "containing", "Landroidx/room/compiler/processing/XType;", "executableElement", "Landroidx/room/compiler/processing/XMethodElement;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XMethodElement;)V", "getContaining", "()Landroidx/room/compiler/processing/XType;", "context", "getContext", "()Landroidx/room/processor/Context;", "getExecutableElement", "()Landroidx/room/compiler/processing/XMethodElement;", "process", "Landroidx/room/vo/UpsertionMethod;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UpsertionMethodProcessor {
    private final XType containing;
    private final Context context;
    private final XMethodElement executableElement;

    public UpsertionMethodProcessor(Context r5, XType r10, XMethodElement r11) {
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

    public final UpsertionMethod process() {
        ShortcutMethodProcessor r5 = new ShortcutMethodProcessor(this.context, this.containing, this.executableElement);
        KClass r10 = Reflection.getOrCreateKotlinClass(Upsert.class);
        ProcessorErrors r11 = ProcessorErrors.INSTANCE;
        XAnnotationBox r12 = r5.extractAnnotation(r10, r11.getMISSING_UPSERT_ANNOTATION());
        XType r13 = r5.extractReturnType();
        this.context.getChecker().notUnbound(r13.getTypeName(), this.executableElement, r11.getCANNOT_USE_UNBOUND_GENERICS_IN_UPSERTION_METHODS(), new Object[0]);
        if (r12 == null) goto L5;
        XType r14 = r12.getAsType("entity");
    L6:
        Pair<Map<String, ShortcutEntity>, List<ShortcutQueryParameter>> r15 = r5.extractParams(r14, r11.getUPSERTION_DOES_NOT_HAVE_ANY_PARAMETERS_TO_UPSERT(), new AnonymousClass1(this));
        Map<String, ShortcutEntity> r16 = r15.component1();
        List<ShortcutQueryParameter> r17 = r15.component2();
        InsertOrUpsertMethodBinder r18 = r5.findUpsertMethodBinder(r13, r17);
        Checks r19 = this.context.getChecker();
        if (r18.getAdapter() == null) goto L9;
        boolean r20 = true;
    L10:
        r19.check(r20, this.executableElement, r11.getCANNOT_FIND_UPSERT_RESULT_ADAPTER(), new Object[0]);
        return new UpsertionMethod(this.executableElement, r16, r13, r17, r18);
    L9:
        r20 = false;
        goto L10
    L5:
        r14 = null;
        goto L6
    }
}
