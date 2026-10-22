package lt8;

import android.view.View;
import com.larus.bmhome.view.resourcebar.ResourceBarAdapter;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements BaseResourceViewHolder.a {
    public final /* synthetic */ ResourceBarAdapter a;

    public a(ResourceBarAdapter r1) {
        this.a = r1;
    }

    public final boolean b(String r4, View r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "v");
        FLogger.a.i("ResourceBarAdapter", "onLongClick, key:" + r4);
        BaseResourceViewHolder.a r0 = this.a.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.b(r4, r5);
    }

    public final void a(String r4, int r5, View r6) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r6, "v");
        FLogger.a.i("ResourceBarAdapter", "onClick, key:" + r4 + ", event:" + r5);
        BaseResourceViewHolder.a r0 = this.a.b;
        if (r0 == null) goto L6;
        r0.a(r4, r5, r6);
        return;
    }
}
