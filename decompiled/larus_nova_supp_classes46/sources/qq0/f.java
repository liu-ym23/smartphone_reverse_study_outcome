package qq0;

import android.widget.ListView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.model.shelf.MicroAppLabel;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.AudienceShelfDisplayDialog;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.MicroAppLabelListAdapter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ AudienceShelfDisplayDialog a;

    public f(AudienceShelfDisplayDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        ShelfMicroAppInfo r6 = (ShelfMicroAppInfo) r5;
        if (r6 == null) goto L19;
        AudienceShelfDisplayDialog r2 = this.a;
        int r3 = AudienceShelfDisplayDialog.v;
        HSImageView r4 = r2.X90().findViewById(2131380152);
        ImageModel r7 = r6.icon;
        if (r7 == null) goto L9;
        List r8 = r7.getUrls();
        if (r8 == null) goto L9;
        String r9 = (String) CollectionsKt.firstOrNull(r8);
    L10:
        ImageLoader.bindImage(r4, r9);
        ((TextView) this.a.X90().findViewById(2131380153)).setText(r6.name);
        List<MicroAppLabel> r1 = r6.label;
        if (r1 != null) goto L13;
    L16:
        boolean r10 = true;
    L17:
        if (r10 == true) goto L21;
        ListView r11 = (ListView) this.a.X90().findViewById(2131377098);
        MicroAppLabelListAdapter r12 = this.a.q;
        List<MicroAppLabel> r13 = r6.label;
        Intrinsics.checkNotNull(r13);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r12.a = r13;
        this.a.q.notifyDataSetChanged();
        r11.setVisibility(0);
        return;
    L21:
        return;
    L13:
        if (r1.isEmpty() == true) goto L16;
        r10 = false;
    L9:
        r9 = null;
        goto L10
    L19:
        StringBuilder r14 = new StringBuilder("主播已关闭");
        AudienceShelfDisplayDialog r15 = this.a;
        int r16 = AudienceShelfDisplayDialog.v;
        r14.append(((TextView) r15.X90().findViewById(2131380153)).getText());
        r14.append("功能");
        f2.c(r14.toString(), 0);
    }
}
