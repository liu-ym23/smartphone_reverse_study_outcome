package androidx.room.processor;

import androidx.room.Update;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.preconditions.Checks;
import androidx.room.solver.shortcut.binder.DeleteOrUpdateMethodBinder;
import androidx.room.vo.ShortcutEntity;
import androidx.room.vo.ShortcutQueryParameter;
import androidx.room.vo.UpdateMethod;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/room/processor/UpdateMethodProcessor;", "", "baseContext", "Landroidx/room/processor/Context;", "containing", "Landroidx/room/compiler/processing/XType;", "executableElement", "Landroidx/room/compiler/processing/XMethodElement;", "(Landroidx/room/processor/Context;Landroidx/room/compiler/processing/XType;Landroidx/room/compiler/processing/XMethodElement;)V", "getContaining", "()Landroidx/room/compiler/processing/XType;", "context", "getContext", "()Landroidx/room/processor/Context;", "getExecutableElement", "()Landroidx/room/compiler/processing/XMethodElement;", "process", "Landroidx/room/vo/UpdateMethod;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UpdateMethodProcessor {
    private final XType containing;
    private final Context context;
    private final XMethodElement executableElement;

    public UpdateMethodProcessor(Context r5, XType r10, XMethodElement r11) {
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

    public final UpdateMethod process() {
        ShortcutMethodProcessor r5 = new ShortcutMethodProcessor(this.context, this.containing, this.executableElement);
        KClass r10 = Reflection.getOrCreateKotlinClass(Update.class);
        ProcessorErrors r11 = ProcessorErrors.INSTANCE;
        XAnnotationBox r12 = r5.extractAnnotation(r10, r11.getMISSING_UPDATE_ANNOTATION());
        if (r12 == null) goto L8;
        Update r13 = (Update) r12.getValue();
        if (r13 == null) goto L8;
        int r14 = r13.onConflict();
    L7:
        int r15 = r14;
        Checks r16 = this.context.getChecker();
        boolean r17 = true;
        if (r15 >= 0) goto L12;
    L14:
        boolean r18 = false;
    L15:
        r16.check(r18, this.executableElement, r11.getINVALID_ON_CONFLICT_VALUE(), new Object[0]);
        if (r12 == null) goto L18;
        XType r19 = r12.getAsType("entity");
    L19:
        Pair<Map<String, ShortcutEntity>, List<ShortcutQueryParameter>> r20 = r5.extractParams(r19, r11.getUPDATE_MISSING_PARAMS(), new AnonymousClass1(this));
        Map<String, ShortcutEntity> r21 = r20.component1();
        List<ShortcutQueryParameter> r22 = r20.component2();
        DeleteOrUpdateMethodBinder r23 = r5.findDeleteOrUpdateMethodBinder(r5.extractReturnType());
        Checks r24 = this.context.getChecker();
        if (r23.getAdapter() != null) goto L23;
        r17 = false;
    L23:
        r24.check(r17, this.executableElement, r11.getCANNOT_FIND_UPDATE_RESULT_ADAPTER(), new Object[0]);
        return new UpdateMethod(r5.getExecutableElement(), r21, r22, r23, r15);
    L18:
        r19 = null;
        goto L19
    L12:
        if (r15 >= 6) goto L14;
        r18 = true;
    L8:
        r14 = OnConflictProcessor.INSTANCE.getINVALID_ON_CONFLICT();
        goto L7
    }
}
