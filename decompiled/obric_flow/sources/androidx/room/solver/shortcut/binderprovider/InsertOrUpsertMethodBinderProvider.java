package androidx.room.solver.shortcut.binderprovider;

import androidx.room.compiler.processing.XType;
import androidx.room.solver.shortcut.binder.InsertOrUpsertMethodBinder;
import androidx.room.vo.ShortcutQueryParameter;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/room/solver/shortcut/binderprovider/InsertOrUpsertMethodBinderProvider;", "", "matches", "", "declared", "Landroidx/room/compiler/processing/XType;", "provide", "Landroidx/room/solver/shortcut/binder/InsertOrUpsertMethodBinder;", LynxResourceModule.PARAMS_KEY, "", "Landroidx/room/vo/ShortcutQueryParameter;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface InsertOrUpsertMethodBinderProvider {
    boolean matches(XType r5);

    InsertOrUpsertMethodBinder provide(XType r5, List<ShortcutQueryParameter> r10);
}
