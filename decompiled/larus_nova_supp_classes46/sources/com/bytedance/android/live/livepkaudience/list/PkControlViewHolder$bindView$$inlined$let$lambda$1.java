package com.bytedance.android.live.livepkaudience.list;

import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "invoke", "com/bytedance/android/live/livepkaudience/list/PkControlViewHolder$bindView$2$1"}, k = 3, mv = {1, 4, 3})
final class PkControlViewHolder$bindView$$inlined$let$lambda$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ User $it;
    final /* synthetic */ LinkPlayerInfo $linkPlayerInfo$inlined;
    final /* synthetic */ String $role$inlined;
    final /* synthetic */ PkControlViewHolder this$0;

    public PkControlViewHolder$bindView$$inlined$let$lambda$1(User r1, PkControlViewHolder r2, LinkPlayerInfo r3, String r4) {
        this.$it = r1;
        this.this$0 = r2;
        this.$linkPlayerInfo$inlined = r3;
        this.$role$inlined = r4;
        super(1);
    }

    public final void invoke(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        if (this.this$0.getType() == 0) goto L5;
    L8:
        xs2.b.a().post(new UserProfileEvent(this.$it).setClickUserPosition("pk_linked_audience").setReportSource("audience_audio").setReportType("data_card_linked_audience"));
        return;
    L5:
        if (this.$linkPlayerInfo$inlined.isAnonymous == false) goto L8;
        ALogger.i("ttlive_pk_guest_view_holder", "click on the anonymous user avatar for apply , do not pull up the profile card");
        f2.c(s1.B(2131918948), 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}
