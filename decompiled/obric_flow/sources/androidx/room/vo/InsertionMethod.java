package androidx.room.vo;

import androidx.room.OnConflictStrategy;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XType;
import androidx.room.solver.shortcut.binder.InsertOrUpsertMethodBinder;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/room/vo/InsertionMethod;", "Landroidx/room/vo/InsertOrUpsertShortcutMethod;", "element", "Landroidx/room/compiler/processing/XMethodElement;", "onConflict", "", "entities", "", "", "Landroidx/room/vo/ShortcutEntity;", "returnType", "Landroidx/room/compiler/processing/XType;", "parameters", "", "Landroidx/room/vo/ShortcutQueryParameter;", "methodBinder", "Landroidx/room/solver/shortcut/binder/InsertOrUpsertMethodBinder;", "(Landroidx/room/compiler/processing/XMethodElement;ILjava/util/Map;Landroidx/room/compiler/processing/XType;Ljava/util/List;Landroidx/room/solver/shortcut/binder/InsertOrUpsertMethodBinder;)V", "getOnConflict", "()I", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InsertionMethod extends InsertOrUpsertShortcutMethod {
    private final int onConflict;

    public InsertionMethod(XMethodElement r10, @OnConflictStrategy int r11, Map<String, ShortcutEntity> r12, XType r13, List<ShortcutQueryParameter> r14, InsertOrUpsertMethodBinder r15) {
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r12, "entities");
        Intrinsics.checkNotNullParameter(r13, "returnType");
        Intrinsics.checkNotNullParameter(r14, "parameters");
        Intrinsics.checkNotNullParameter(r15, "methodBinder");
        super(r10, r12, r13, r14, r15);
        this.onConflict = r11;
    }

    public final int getOnConflict() {
        return this.onConflict;
    }
}
