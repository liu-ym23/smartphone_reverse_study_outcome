package com.bytedance.android.live.livepkaudience.dialog;

import android.view.View;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livehostapi.business.IHostSocial;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/bytedance/android/live/livepkaudience/dialog/BasePkAudienceInviteListFragment$onViewCreated$2$1"}, k = 3, mv = {1, 4, 3})
public final class BasePkAudienceInviteListFragment$onViewCreated$$inlined$apply$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ View $view$inlined;
    final /* synthetic */ BasePkAudienceInviteListFragment this$0;

    public BasePkAudienceInviteListFragment$onViewCreated$$inlined$apply$lambda$1(BasePkAudienceInviteListFragment r1, View r2) {
        this.this$0 = r1;
        this.$view$inlined = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m474invoke() {
        int r0 = al0.d.a;
        Pair[] r1 = new Pair[3];
        if (this.this$0.da0() == false) goto L5;
        String r2 = "voice_live";
    L6:
        r1[0] = TuplesKt.to("live_type", r2);
        r1[1] = al0.d.a();
        r1[2] = TuplesKt.to("request_page", "invite");
        Map r3 = MapsKt.mutableMapOf(r1);
        el0.j.k(r3);
        el0.j.n(r3, Integer.valueOf(dl0.n.a()));
        Unit r4 = Unit.INSTANCE;
        al0.d.g("anchor_invite_user_button_click", r3, new Object[0]);
        jc1.k.n(IRoomService.class).setOnNeedMuteAudioFullPage(true);
        jc1.k.n(IHostSocial.class).showInviteFriendActivity(this.$view$inlined.getContext(), new AnonymousClass1(this));
        return;
    L5:
        r2 = "video_live";
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m474invoke();
        return Unit.INSTANCE;
    }
}
