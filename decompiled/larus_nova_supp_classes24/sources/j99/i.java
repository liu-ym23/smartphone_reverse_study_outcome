package j99;

import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.extension.chat_extension.impl.databinding.LarusItemLtmTitleBinding;
import com.larus.platform.service.q;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i implements UrlSpanTextView.a {
    public final /* synthetic */ LarusItemLtmTitleBinding a;

    public i(LarusItemLtmTitleBinding r1) {
        this.a = r1;
    }

    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        q.a.e(this.a.c.getContext(), com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", r5)}), null);
    }
}
