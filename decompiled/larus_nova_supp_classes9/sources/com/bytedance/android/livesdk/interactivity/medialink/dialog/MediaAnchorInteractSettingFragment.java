package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.uikit.rtl.AutoRTLImageView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaAnchorInteractSettingContract$View;
import com.bytedance.android.livesdk.interactivity.medialink.network.LinkCrossRoomApi;
import com.bytedance.android.livesdk.interactivity.medialink.network.LinkCrossRoomApiCompat;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class MediaAnchorInteractSettingFragment extends MediaAnchorInteractSettingContract$View implements CompoundButton.OnCheckedChangeListener {
    public static final /* synthetic */ int h = 0;
    public Switch g;

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final float T90() {
        return 432.0f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final View U90() {
        AutoRTLImageView r0 = new AutoRTLImageView(getContext());
        r0.setLayoutParams(new RelativeLayout.LayoutParams(s1.f(32.0f), s1.f(32.0f)));
        r0.setImageDrawable(s1.m(2131251314));
        r0.setOnClickListener(new e(this));
        r3.c(r0, s1.B(2131918649), true);
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View
    public final String V90() {
        return getString(2131920298);
    }

    public MediaAnchorInteractSettingFragment() {
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r7, final boolean r8) {
        if (r7.getId() != 2131387869) goto L12;
        Room r9 = jc1.k.f(IRoomService.class).getCurrentRoom();
        HashMap r5 = new HashMap();
        r5.put("is_turn_on", Boolean.valueOf(r8));
        if (r9 == null) goto L13;
        LinkCrossRoomApiCompat r0 = (LinkCrossRoomApiCompat) com.bytedance.android.live.network.c.b().e(LinkCrossRoomApiCompat.class);
        long r1 = r9.getId();
        if (r9.getBaseOwner() == null) goto L9;
        String r10 = r9.getBaseOwner().getCastSecUid();
    L10:
        ((SingleSubscribeProxy) r0.updateAnchorLinkSetting(r1, r10, 0, r5).as(S90())).subscribe(new f(r8), new g60.c());
        return;
    L9:
        r10 = BuildConfig.FLAVOR;
        goto L10
    L13:
        return;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        View r6 = r3.inflate(2131566907, r4, false);
        Switch r7 = (Switch) r6.findViewById(2131387869);
        this.g = r7;
        r7.setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.b.S1.getValue()).booleanValue());
        Room r8 = (Room) RoomContext.getShared().getRoom().getValue();
        if (r8 == null) goto L5;
        ((SingleSubscribeProxy) ((LinkCrossRoomApi) com.bytedance.android.live.network.c.b().e(LinkCrossRoomApi.class)).getAnchorLinkSetting(r8.getId(), r8.getBaseOwner().getCastSecUid()).as(S90())).subscribe(new c(this), new d());
    L5:
        this.g.setOnCheckedChangeListener(this);
        return r6;
    }
}
