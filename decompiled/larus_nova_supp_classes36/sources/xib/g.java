package xib;

import com.larksuite.component.universe_design.image.UDAvatar;
import com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3;
import com.ss.android.lark.forwardv3.recentforward.viewholder.RecentForwardViewHolder;
import com.ss.android.lark.forwardv3.utils.n;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g extends e<SearchShieldP2PChatInfo> {
    public g(RecentForwardAdapterV3.b r2, RecentForwardAdapterV3.a r3) {
        Intrinsics.checkNotNullParameter(r2, "itemClickHandler");
        Intrinsics.checkNotNullParameter(r3, "onItemBusinessConsumeClickListener");
        super(r2, r3);
    }

    @Override // xib.e
    public final void b(SearchBaseInfo r8, RecentForwardViewHolder r9) {
        SearchShieldP2PChatInfo r10 = (SearchShieldP2PChatInfo) r8;
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r9, "holder");
        UDAvatar r2 = r9.b;
        if (r2 == null) goto L6;
        int r11 = n.a;
        n.b(r2.getContext(), r2, r10.getAvatarKey(), r10.getChatterId(), y9c.d.b(r2.getContext(), 48.0f), y9c.d.b(r2.getContext(), 48.0f));
        return;
    }
}
