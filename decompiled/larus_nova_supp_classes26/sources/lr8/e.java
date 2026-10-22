package lr8;

import android.content.Context;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e extends h38.d {
    public final void a(Message r2, NestedFileContent r3, BaseResourceViewHolder.a r4) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "callback");
    }

    public final void setUpEnableEditImageForSingleImg(boolean r1) {
    }

    public final void setUpImmersiveStyle(boolean r1) {
    }

    public final void setupDelegateCallback(h38.c r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }

    public e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
