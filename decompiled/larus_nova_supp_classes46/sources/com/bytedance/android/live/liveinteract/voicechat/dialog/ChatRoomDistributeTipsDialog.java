package com.bytedance.android.live.liveinteract.voicechat.dialog;

import am2.x;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdk.chatroom.model.a0;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/dialog/ChatRoomDistributeTipsDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChatRoomDistributeTipsDialog extends LiveDialogFragment {
    public static final a f = null;
    public Map<Integer, View> d;
    public a0 e;

    public static final class a {
        public a() {
        }

        public static void a(Context r5, a0 r6) {
            Intrinsics.checkNotNullParameter(r5, "context");
            if (r6 != null) goto L5;
            return;
        L5:
            com.bytedance.android.livesdk.sharedpref.e r0 = b6.q;
            Boolean r1 = Boolean.valueOf(r6.getEnableDelegate());
            r0.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);
            Integer r2 = r6.getStatus();
            if (r2 == null) goto L16;
            r2.intValue();
            com.bytedance.android.livesdk.sharedpref.e r3 = b6.r;
            ILinkmicAudienceSetting.LinkmicSettingStatus r4 = ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OPEN;
            int r7 = r4.getValue();
            if (r2.intValue() == r7) goto L14;
            r4 = ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_DELEGATED_TO_EVERYONE;
            int r8 = r4.getValue();
            if (r2.intValue() == r8) goto L14;
            r4 = ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OFF;
            r4.getValue();
            r2.intValue();
        L14:
            r3.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r3, r4);
        L16:
            if (r6.getShowPanel() == false) goto L26;
            Intrinsics.checkNotNullParameter(r6, "delegateSetting");
            ChatRoomDistributeTipsDialog r9 = new ChatRoomDistributeTipsDialog();
            r9.e = r6;
            FragmentManager r10 = ((FragmentActivity) r5).getSupportFragmentManager();
            LandscapeRestrictionOperation r11 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r9, "ChatRoomDistributeTipsDialog", r11);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r10, r9, r11) == true) goto L27;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
        L21:
            r9.show(r10, "ChatRoomDistributeTipsDialog");
            return;
        L27:
            return;
        }
    }

    static {
        f = new a();
    }

    public ChatRoomDistributeTipsDialog() {
        this.d = new LinkedHashMap();
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        LinkedHashMap r0 = new LinkedHashMap();
        int r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        if (r1 != 5) goto L5;
    L11:
        String r2 = "radio";
    L12:
        r0.put("function_type", r2);
        if (((Boolean) b6.q.getValue()).booleanValue() == false) goto L15;
        String r3 = "on";
    L16:
        r0.put("switch_status", r3);
        j0.l().sendLog("livesdk_guest_link_distribute_panel_close", r0, new Object[]{IRoom.class, x.class});
        return;
    L15:
        r3 = "off";
        goto L16
    L5:
        if (r1 != 9) goto L7;
        r2 = "ktv";
        goto L12
    L7:
        if (r1 != 10) goto L11;
        r2 = "watch";
        goto L12
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void T90(int r3) {
        if (r3 != ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OPEN.getValue()) goto L8;
        TextView r4 = (TextView) S90(2131390872);
        if (r4 == null) goto L18;
        r4.setText(s1.B(2131919502));
        return;
    L18:
        return;
    L8:
        if (r3 != ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_DELEGATED_TO_EVERYONE.getValue()) goto L13;
        TextView r5 = (TextView) S90(2131390872);
        if (r5 == null) goto L20;
        r5.setText(s1.B(2131919501));
        return;
    L20:
        return;
    L13:
        if (r3 != ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OFF.getValue()) goto L22;
        TextView r6 = (TextView) S90(2131390872);
        if (r6 == null) goto L23;
        r6.setText(s1.B(2131919504));
        return;
    L23:
        return;
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        WindowManager.LayoutParams r0 = r5.getAttributes();
        r0.width = -1;
        r0.height = -1;
        r5.setAttributes(r0);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        r5.setGravity(80);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954719);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        if (r3 == null) goto L5;
        r3.setCanceledOnTouchOutside(true);
    L5:
        return r3;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        py.k r10 = jc1.k.n(IMiddlewareUserService.class).user().b().getAvatarMedium();
        if (r10 == null) goto L5;
        a1.v((ImageView) S90(2131363703), r10, 2131251889);
    L5:
        a0 r11 = this.e;
        if (r11 == null) goto L10;
        py.k r12 = r11.getTagImageUrl();
        if (r12 == null) goto L10;
        ImageLoader.bindImage(S90(2131376321), r12);
    L10:
        a0 r13 = this.e;
        if (r13 == null) goto L23;
        String r14 = r13.getPrompt();
        if (r14 == null) goto L23;
        if (r14.length() <= 0) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == true) goto L21;
        r14 = null;
    L21:
        if (r14 == null) goto L23;
        ((TextView) S90(2131391601)).setText(r14);
        goto L23
    L17:
        r2 = false;
    L23:
        com.bytedance.android.live.liveinteract.voicechat.util.d.a.getClass();
        int r15 = com.bytedance.android.live.liveinteract.voicechat.util.d.a.a();
        if (r15 == 1) goto L32;
        if (r15 != 2) goto L35;
        ((Switch) S90(2131387897)).setVisibility(8);
        ((LinearLayout) S90(2131378735)).setVisibility(0);
        ((TextView) S90(2131388741)).setText(getString(2131915779));
        a0 r16 = this.e;
        if (r16 == null) goto L35;
        Integer r17 = r16.getStatus();
        if (r17 == null) goto L35;
        T90(r17.intValue());
    L35:
        int r18 = com.bytedance.android.live.liveinteract.voicechat.util.d.a.a();
        if (r18 == 1) goto L40;
        if (r18 != 2) goto L41;
        ((LinearLayout) S90(2131378735)).setOnClickListener(new d(this));
    L41:
        ((Button) S90(2131390759)).setOnClickListener(new b(this));
        LinkedHashMap r19 = new LinkedHashMap();
        int r3 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        TalkRoomLogUtils.B0(r19, Integer.valueOf(r3), null, 4);
        TalkRoomLogUtils.I0(r19, r3);
        j0.l().sendLog("livesdk_guest_link_distribute_panel_show", r19, new Object[]{IRoom.class, x.class});
        return;
    L40:
        ((Switch) S90(2131387897)).setOnCheckedChangeListener(c.a);
        goto L41
    L32:
        ((Switch) S90(2131387897)).setVisibility(0);
        ((LinearLayout) S90(2131378735)).setVisibility(8);
        ((TextView) S90(2131388741)).setText(getString(2131915777));
        a0 r20 = this.e;
        if (r20 == null) goto L35;
        ((Switch) S90(2131387897)).setChecked(r20.getEnableDelegate());
        goto L35
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565421, r3, false);
    }
}
