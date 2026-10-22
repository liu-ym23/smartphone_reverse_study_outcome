package com.bytedance.android.live.livepkaudience.dialog;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/dialog/PkGuestInviteContainerFragment;", "Lcom/bytedance/android/live/livepkaudience/dialog/PkGuestInviteContainerContract$View;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PkGuestInviteContainerFragment extends PkGuestInviteContainerContract$View implements Observer<KVData> {
    public static final /* synthetic */ int l = 0;
    public Fragment g;
    public PkAudienceListInviteDialogFragment h;
    public DataCenter i;
    public final Handler j;
    public boolean k;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.RevInteractDialogFragmentBaseContract$View
    public final String T90() {
        return "";
    }

    public PkGuestInviteContainerFragment() {
        this.j = new Handler();
    }

    @Override // com.bytedance.android.live.livepkaudience.dialog.RevInteractDialogFragmentBaseContract$View
    public final float S90() {
        return UtilityKotlinExtentionsKt.j(t6.c(s1.getContext()) * 1.2f) - 48;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.j.removeCallbacksAndMessages(null);
        DataCenter r0 = this.i;
        if (r0 == null) goto L6;
        r0.removeObserver(this);
        return;
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 == null) goto L35;
        String r0 = r6.getKey();
        if (r0.hashCode() == 73092145) goto L9;
        return;
    L9:
        if (r0.equals("data_video_talk_show_invite_list_or_search") == false) goto L33;
        Boolean r7 = (Boolean) r6.getData();
        PkAudienceListInviteDialogFragment r1 = this.h;
        if (r1 == null) goto L34;
        if (r7 == null) goto L37;
        Intrinsics.checkNotNullParameter(r1, "fragment");
        if (r1.isAdded() == false) goto L17;
        Fragment r8 = this.g;
        if (r8 == null) goto L31;
        getChildFragmentManager().beginTransaction().hide(r8).show(r1).commitAllowingStateLoss();
    L31:
        this.g = r1;
        r1.setUserVisibleHint(getUserVisibleHint());
        return;
    L17:
        if (this.g != null) goto L23;
        FragmentTransaction r9 = getChildFragmentManager().beginTransaction();
        String r2 = PkAudienceListInviteDialogFragment.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r9, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r2, 2131375598) == true) goto L22;
        r9 = r9.add(2131375598, r1, r2);
    L22:
        r9.commitAllowingStateLoss();
        goto L31
    L23:
        FragmentTransaction r10 = getChildFragmentManager().beginTransaction();
        Fragment r3 = this.g;
        Intrinsics.checkNotNull(r3);
        FragmentTransaction r11 = r10.hide(r3);
        String r4 = PkAudienceListInviteDialogFragment.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r11, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, 2131375598) == true) goto L27;
        r11 = r11.add(2131375598, r1, r4);
    L27:
        r11.commitAllowingStateLoss();
        goto L31
    L37:
        return;
    L34:
        return;
    L33:
        return;
    }

    public final void setUserVisibleHint(boolean r2) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r2);
        Fragment r0 = this.g;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(r2);
        return;
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        k0 r5 = this.d;
        if (r5 != null) goto L6;
        int r6 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        Intrinsics.checkNotNullParameter("PkGuestInviteContainerFragment", "fragment");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("fragment", "PkGuestInviteContainerFragment");
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("talk_room_invite_dialog_is_null", r0);
        return;
    L6:
        int r7 = PkAudienceListInviteDialogFragment.H;
        DataCenter r8 = this.i;
        boolean r1 = this.k;
        Intrinsics.checkNotNullParameter(r5, "view");
        PkAudienceListInviteDialogFragment r2 = new PkAudienceListInviteDialogFragment();
        r2.d = r5;
        r2.B = r8;
        r2.l = jc1.k.n(IRoomService.class).getCurrentRoom();
        r2.x = true;
        r2.F = r1;
        this.h = r2;
        DataCenter r9 = this.i;
        if (r9 == null) goto L9;
        r9.observe("data_video_talk_show_invite_list_or_search", this);
    L9:
        DataCenter r10 = this.i;
        if (r10 == null) goto L13;
        r10.put("data_video_talk_show_invite_list_or_search", Boolean.FALSE);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565531, r3, false);
    }
}
