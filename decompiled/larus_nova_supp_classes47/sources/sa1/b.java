package sa1;

import android.view.View;
import com.bytedance.android.live.search.impl.search.viewholder.LiveSearchSugViewHolder;
import com.bytedance.android.livesdk.log.u;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ra1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ LiveSearchSugViewHolder a;
    public final /* synthetic */ g b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;

    public b(LiveSearchSugViewHolder r1, g r2, String r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        qa1.c r6 = this.a.f;
        if (r6 == null) goto L5;
        r6.BO(this.b, this.c, this.d);
    L5:
        int r7 = com.bytedance.android.live.search.impl.search.g.a;
        LiveSearchSugViewHolder r8 = this.a;
        String r0 = r8.e;
        String r1 = this.c;
        g r9 = r8.b;
        if (r9 == null) goto L8;
        Map<String, String> r10 = r9.b();
    L9:
        Intrinsics.checkNotNullParameter(r0, "keyword");
        Intrinsics.checkNotNullParameter(r1, "rid");
        HashMap r2 = new HashMap();
        r2.put("raw_query", r0);
        r2.put("query_id", r1);
        r2.put("search_position", "live_square");
        r2.put("rank", "-1");
        if (r10 == null) goto L12;
        r2.putAll(r10);
    L12:
        u.l().e("trending_words_click", r2, new Object[0]);
        return;
    L8:
        r10 = null;
        goto L9
    }
}
