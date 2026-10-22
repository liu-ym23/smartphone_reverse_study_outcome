package xib;

import com.larksuite.component.universe_design.image.UDAvatar;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3;
import com.ss.android.lark.forwardv3.recentforward.viewholder.RecentForwardViewHolder;
import com.ss.android.lark.forwardv3.utils.n;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f extends e<SearchChatInfo> {
    public f(RecentForwardAdapterV3.b r2, RecentForwardAdapterV3.a r3) {
        Intrinsics.checkNotNullParameter(r2, "itemClickHandler");
        Intrinsics.checkNotNullParameter(r3, "onItemBusinessConsumeClickListener");
        super(r2, r3);
    }

    @Override // xib.e
    public final void b(SearchBaseInfo r8, RecentForwardViewHolder r9) {
        SearchChatInfo r10 = (SearchChatInfo) r8;
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r9, "holder");
        UDAvatar r2 = r9.b;
        if (r2 == null) goto L7;
        int r11 = n.a;
        if (n.d(r10, r2) == false) goto L7;
        return;
    L7:
        if (r2 == null) goto L10;
        int r12 = n.a;
        n.b(r2.getContext(), r2, r10.getAvatarKey(), r10.getId(), UIUtils.dp2px(r2.getContext(), 48.0f), UIUtils.dp2px(r2.getContext(), 48.0f));
        return;
    }
}
