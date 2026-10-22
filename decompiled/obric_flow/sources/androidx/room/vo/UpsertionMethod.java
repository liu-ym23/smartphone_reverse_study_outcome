package androidx.room.vo;

import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.solver.shortcut.binder.InsertOrUpsertMethodBinder;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/room/vo/UpsertionMethod;", "Landroidx/room/vo/InsertOrUpsertShortcutMethod;", "element", "Landroidx/room/compiler/processing/XMethodElement;", "entities", "", "", "Landroidx/room/vo/ShortcutEntity;", "returnType", "Landroidx/room/compiler/processing/XType;", "parameters", "", "Landroidx/room/vo/ShortcutQueryParameter;", "methodBinder", "Landroidx/room/solver/shortcut/binder/InsertOrUpsertMethodBinder;", "(Landroidx/room/compiler/processing/XMethodElement;Ljava/util/Map;Landroidx/room/compiler/processing/XType;Ljava/util/List;Landroidx/room/solver/shortcut/binder/InsertOrUpsertMethodBinder;)V", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UpsertionMethod extends InsertOrUpsertShortcutMethod {
    public UpsertionMethod(XMethodElement r5, Map<String, ShortcutEntity> r10, XType r11, List<ShortcutQueryParameter> r12, InsertOrUpsertMethodBinder r13) {
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(r10, "entities");
        Intrinsics.checkNotNullParameter(r11, "returnType");
        Intrinsics.checkNotNullParameter(r12, "parameters");
        Intrinsics.checkNotNullParameter(r13, "methodBinder");
        super(r5, r10, r11, r12, r13);
    }
}
