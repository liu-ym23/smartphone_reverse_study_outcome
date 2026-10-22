package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.View;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import java.util.LinkedHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/DrawerHistoryMoreItemViewHolder;", "Lcom/bytedance/android/live/core/viewholder/BaseViewHolder;", "Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/k0;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawerHistoryMoreItemViewHolder extends BaseViewHolder<k0> {
    public final View a;
    public final IDrawerFeedAction b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DrawerHistoryMoreItemViewHolder a;

        public a(DrawerHistoryMoreItemViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            IDrawerFeedAction r5 = this.a.b;
            if (r5 == null) goto L5;
            r5.enterHistory();
        L5:
            this.a.getClass();
            LinkedHashMap r6 = new LinkedHashMap();
            r6.put("enter_from_merge", "drawer_hot");
            r6.put("enter_method", "live_history_card");
            IUserService r0 = jc1.k.f(IUserService.class);
            if (r0 == null) goto L11;
            com.bytedance.android.livesdk.user.f r1 = r0.user();
            if (r1 == null) goto L11;
            String r2 = r1.n();
            if (r2 == null) goto L11;
        L12:
            r6.put("user_id", r2);
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_history_all_click", r6, new Object[0]);
            return;
        L11:
            r2 = "";
            goto L12
        }
    }

    public static void T3() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("enter_from_merge", "drawer_hot");
        r0.put("enter_method", "live_history_card");
        IUserService r1 = jc1.k.f(IUserService.class);
        if (r1 == null) goto L8;
        com.bytedance.android.livesdk.user.f r2 = r1.user();
        if (r2 == null) goto L8;
        String r3 = r2.n();
        if (r3 == null) goto L8;
    L9:
        r0.put("user_id", r3);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_history_all_show", r0, new Object[0]);
        return;
    L8:
        r3 = "";
        goto L9
    }

    public DrawerHistoryMoreItemViewHolder(View r1, IDrawerFeedAction r2) {
        super(r1);
        this.a = r1;
        this.b = r2;
        if (r1 == null) goto L6;
        r1.setOnClickListener(new a(this));
        return;
    }

    public final /* bridge */ /* synthetic */ void bind(Object r1, int r2) {
        k0 r3 = (k0) r1;
        T3();
    }
}
