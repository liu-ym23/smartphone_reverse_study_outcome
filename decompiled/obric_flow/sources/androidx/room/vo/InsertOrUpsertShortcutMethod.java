package androidx.room.vo;

import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.solver.shortcut.binder.InsertOrUpsertMethodBinder;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/room/vo/InsertOrUpsertShortcutMethod;", "", "element", "Landroidx/room/compiler/processing/XMethodElement;", "entities", "", "", "Landroidx/room/vo/ShortcutEntity;", "returnType", "Landroidx/room/compiler/processing/XType;", "parameters", "", "Landroidx/room/vo/ShortcutQueryParameter;", "methodBinder", "Landroidx/room/solver/shortcut/binder/InsertOrUpsertMethodBinder;", "(Landroidx/room/compiler/processing/XMethodElement;Ljava/util/Map;Landroidx/room/compiler/processing/XType;Ljava/util/List;Landroidx/room/solver/shortcut/binder/InsertOrUpsertMethodBinder;)V", "getElement", "()Landroidx/room/compiler/processing/XMethodElement;", "getEntities", "()Ljava/util/Map;", "getMethodBinder", "()Landroidx/room/solver/shortcut/binder/InsertOrUpsertMethodBinder;", "getParameters", "()Ljava/util/List;", "getReturnType", "()Landroidx/room/compiler/processing/XType;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class InsertOrUpsertShortcutMethod {
    private final XMethodElement element;
    private final Map<String, ShortcutEntity> entities;
    private final InsertOrUpsertMethodBinder methodBinder;
    private final List<ShortcutQueryParameter> parameters;
    private final XType returnType;

    public InsertOrUpsertShortcutMethod(XMethodElement r5, Map<String, ShortcutEntity> r10, XType r11, List<ShortcutQueryParameter> r12, InsertOrUpsertMethodBinder r13) {
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(r10, "entities");
        Intrinsics.checkNotNullParameter(r11, "returnType");
        Intrinsics.checkNotNullParameter(r12, "parameters");
        this.element = r5;
        this.entities = r10;
        this.returnType = r11;
        this.parameters = r12;
        this.methodBinder = r13;
    }

    public final XMethodElement getElement() {
        return this.element;
    }

    public final Map<String, ShortcutEntity> getEntities() {
        return this.entities;
    }

    public final InsertOrUpsertMethodBinder getMethodBinder() {
        return this.methodBinder;
    }

    public final List<ShortcutQueryParameter> getParameters() {
        return this.parameters;
    }

    public final XType getReturnType() {
        return this.returnType;
    }
}
