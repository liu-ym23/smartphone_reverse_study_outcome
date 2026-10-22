package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.net.Uri;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.follow.ScheduledLiveItem;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.e5;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ DrawerFollowViewHolder a;
    public final /* synthetic */ FeedItem b;

    public m(DrawerFollowViewHolder r1, FeedItem r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        FeedItem r0 = this.b;
        if (r0 == null) goto L45;
        ScheduledLiveItem r1 = r0.scheduledLive;
        if (r1 == null) goto L45;
        String r2 = r1.getAnnouncementContent();
        if (r2 == null) goto L45;
        if (r2.length() <= 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 != true) goto L45;
        ScheduledLiveItem r4 = this.b.scheduledLive;
        String r5 = "";
        if (r4 == null) goto L18;
        String r6 = r4.getUidStr();
        if (r6 == null) goto L18;
    L19:
        ScheduledLiveItem r8 = this.b.scheduledLive;
        if (r8 == null) goto L25;
        String r9 = r8.getSecUid();
        if (r9 == null) goto L25;
        r5 = r9;
    L25:
        if (fm3.d.b() == false) goto L27;
        String r10 = e5.a.getValue().b();
    L28:
        Uri r11 = UriProtector.parse(r10);
        String r12 = UriProtector.getQueryParameter(r11, "url");     // Catch: Throwable -> L43
        if (r12 == null) goto L32;
        r12 = UriProtector.parse(r12).buildUpon().appendQueryParameter("anchor_id", r6).appendQueryParameter("sec_anchor_id", r5).toString();     // Catch: Throwable -> L43
    L32:
        Uri.Builder r13 = r11.buildUpon().clearQuery();     // Catch: Throwable -> L43
        Iterator r14 = UriProtector.getQueryParameterNames(r11).iterator();     // Catch: Throwable -> L43
    L34:
        if (r14.hasNext() == false) goto L39;
        String r15 = (String) r14.next();     // Catch: Throwable -> L43
        if (Intrinsics.areEqual(r15, "url") == true) goto L37;
        r13.appendQueryParameter(r15, UriProtector.getQueryParameter(r11, r15));     // Catch: Throwable -> L43
        goto L34
    L37:
        r13.appendQueryParameter(r15, r12);     // Catch: Throwable -> L43
        goto L34
    L39:
        ILiveService r16 = TTLiveService.getLiveService();     // Catch: Throwable -> L43
        if (r16 == null) goto L59;
        r16.handleSchema(((RecyclerView.ViewHolder) this.a).itemView.getContext(), r13.build());     // Catch: Throwable -> L43
        return;
    L59:
        return;
    L43:
        th = move-exception;
        ALogger.e("DrawerFollowFragment", String.valueOf(th.getMessage()));
        return;
    L27:
        r10 = e5.a.getValue().a();
    L18:
        r6 = "";
        goto L19
    L11:
        r3 = false;
    L45:
        DrawerFollowViewHolder r17 = this.a;
        FeedItem r18 = this.b;
        if (r18 == null) goto L48;
        ScheduledLiveItem r19 = r18.scheduledLive;
    L49:
        DrawerFollowViewHolder.T3(r17, r19);
        return;
    L48:
        r19 = null;
        goto L49
    }
}
