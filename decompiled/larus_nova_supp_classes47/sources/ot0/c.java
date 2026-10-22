package ot0;

import am2.x;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.profile.event.SpreadStateType;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import st0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements com.bytedance.android.live.profile.ui.component.base.a<g> {
    public final h a;

    public c(Fragment r2, com.bytedance.android.live.profile.profilecontext.a r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "profileContext");
        this.a = r3;
    }

    @Override // com.bytedance.android.live.profile.ui.component.base.a
    public final void a(View r4, NewProfileUser r5, g r6) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "user");
        Intrinsics.checkNotNullParameter(r6, Constants.Keys.DATA);
        if (this.a.isMyLive() == false) goto L14;
        j0.l().sendLog("livesdk_my_live_profile_card_click", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_area", "fans")}), new Object[]{IRoom.class, x.class});
        PropertyOwner<com.bytedance.android.live.profile.event.a> r7 = this.a.getEventHub().a;
        SpreadStateType r8 = ((com.bytedance.android.live.profile.event.a) r7.a).a;
        SpreadStateType r9 = SpreadStateType.Close;
        if (r8 != r9) goto L9;
        com.bytedance.android.live.profile.event.a r10 = new com.bytedance.android.live.profile.event.a(SpreadStateType.Open);
        Intrinsics.checkNotNullParameter(r10, "t");
        r7.a(r10);
        return;
    L9:
        if (r8 != SpreadStateType.Open) goto L13;
        com.bytedance.android.live.profile.event.a r12 = new com.bytedance.android.live.profile.event.a(r9);
        Intrinsics.checkNotNullParameter(r12, "t");
        r7.a(r12);
        return;
    L13:
        return;
    }
}
