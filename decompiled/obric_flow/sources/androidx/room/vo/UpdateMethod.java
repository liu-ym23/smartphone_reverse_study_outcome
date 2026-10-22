package androidx.room.vo;

import androidx.room.OnConflictStrategy;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.solver.shortcut.binder.DeleteOrUpdateMethodBinder;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/room/vo/UpdateMethod;", "Landroidx/room/vo/DeleteOrUpdateShortcutMethod;", "element", "Landroidx/room/compiler/processing/XMethodElement;", "entities", "", "", "Landroidx/room/vo/ShortcutEntity;", "parameters", "", "Landroidx/room/vo/ShortcutQueryParameter;", "methodBinder", "Landroidx/room/solver/shortcut/binder/DeleteOrUpdateMethodBinder;", "onConflictStrategy", "", "(Landroidx/room/compiler/processing/XMethodElement;Ljava/util/Map;Ljava/util/List;Landroidx/room/solver/shortcut/binder/DeleteOrUpdateMethodBinder;I)V", "getOnConflictStrategy", "()I", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UpdateMethod extends DeleteOrUpdateShortcutMethod {
    private final int onConflictStrategy;

    public UpdateMethod(XMethodElement r5, Map<String, ShortcutEntity> r10, List<ShortcutQueryParameter> r11, DeleteOrUpdateMethodBinder r12, @OnConflictStrategy int r13) {
        Intrinsics.checkNotNullParameter(r5, "element");
        Intrinsics.checkNotNullParameter(r10, "entities");
        Intrinsics.checkNotNullParameter(r11, "parameters");
        super(r5, r10, r11, r12);
        this.onConflictStrategy = r13;
    }

    public final int getOnConflictStrategy() {
        return this.onConflictStrategy;
    }
}
