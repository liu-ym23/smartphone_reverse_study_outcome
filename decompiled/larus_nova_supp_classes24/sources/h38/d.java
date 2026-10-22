package h38;

import android.content.Context;
import android.widget.FrameLayout;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class d extends FrameLayout {
    public abstract void a(Message r1, NestedFileContent r2, BaseResourceViewHolder.a r3);

    public abstract void setUpEnableEditImageForSingleImg(boolean r1);

    public abstract void setUpImmersiveStyle(boolean r1);

    public abstract void setupDelegateCallback(c r1);

    public d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
