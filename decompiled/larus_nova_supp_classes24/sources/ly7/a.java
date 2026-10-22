package ly7;

import android.content.Context;
import com.larksuite.common_selection.g;
import com.larksuite.common_selection.selectionhandle.CursorHandle;
import com.larksuite.common_selection.selectionhandle.SelectionHandleType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements g {
    public a() {
    }

    @Override // com.larksuite.common_selection.g
    public final CursorHandle a(Context r2, SelectionHandleType r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "handleType");
        return new CursorHandle(r2, r3);
    }
}
