package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkmicSubtitleStyle;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkmicSubtitleType;
import com.bytedance.android.livesdk.chatroom.model.interact.UpdateSubtitleType;
import com.bytedance.android.livesdk.chatroom.model.interact.q2;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/subtitle/LinkmicSubtitleSettingDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicSubtitleSettingDialog extends LiveDialogFragment {
    public static final String j = null;
    public static final String k = null;
    public static final String l = null;
    public static final String m = null;
    public static final String n = null;
    public static final String o = null;
    public static final String p = null;
    public Map<Integer, View> d;
    public IAudioSubtitleContent e;
    public boolean f;
    public boolean g;
    public String h;
    public String i;

    public static final class a {
        public static LinkmicSubtitleSettingDialog a(IAudioSubtitleContent r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "audioSubtitleContent");
            Intrinsics.checkNotNullParameter(r2, "requestPage");
            LinkmicSubtitleSettingDialog r0 = new LinkmicSubtitleSettingDialog();
            r0.e = r1;
            r0.h = r2;
            if (r2.equals("click_menu") == false) goto L5;
            r2 = "caption";
        L5:
            r0.i = r2;
            return r0;
        }
    }

    public static boolean V90() {
        if (com.bytedance.android.live.liveinteract.voicechat.radio.e.d(true) == true) goto L5;
    L16:
        return false;
    L5:
        if (je0.d.f() != 0) goto L10;
        IRoom r1 = je0.d.e(null);
        if (r1 == null) goto L10;
        if (r1.isLiveTypeAudio() != true) goto L10;
        return true;
    L10:
        Integer r2 = je0.d.h();
        if (r2 == null) goto L16;
        if (r2.intValue() != 29) goto L16;
        return true;
    }

    static {
        StringBuilder r0 = new StringBuilder("https://");
        LiveCommonConstants r2 = LiveCommonConstants.INSTANCE;
        r0.append(r2.getObjectTosPath());
        r0.append("/obj/live-android/ttlive_audio_subtitle_long.png");
        j = r0.toString();
        k = "https://" + r2.getObjectTosPath() + "/obj/live-android/ttlive_audio_subtitle_short.png";
        l = "https://" + r2.getObjectTosPath() + "/obj/live-android/ttlive_audio_subtitle_room_type_1v8_icon.png";
        m = "https://" + r2.getObjectTosPath() + "/obj/live-android/ttlive_audio_subtitle_room_type_3x3_icon.png";
        n = "https://" + r2.getObjectTosPath() + "/obj/live-android/ttlive_audio_subtitle_enlarged_type_icon.png";
        o = "https://" + r2.getObjectTosPath() + "/obj/live-android/ttlive_audio_subtitle_room_type_1v8_icon_radio.png";
        p = "https://" + r2.getObjectTosPath() + "/obj/live-android/ttlive_audio_subtitle_enlarged_type_icon_radio.png";
    }

    public LinkmicSubtitleSettingDialog() {
        this.d = new LinkedHashMap();
        this.h = "";
        this.i = "";
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

    public static final void T90(LinkmicSubtitleSettingDialog r5, LinkmicSubtitleStyle r6) {
        if (r5.f == true) goto L39;
        r5.f = true;
        IAudioSubtitleContent r0 = r5.e;
        if (r0 != null) goto L8;
        r0 = (IAudioSubtitleContent) vh7.f.c(IAudioSubtitleContent.class);
    L8:
        q2 r1 = r0.getSubtitleStatus();
        if (r1 == null) goto L12;
        r1.setSubtitleStyle(r6.ordinal());
    L12:
        if (((List) b6.q0.getValue()).contains(Integer.valueOf(r6.ordinal())) == true) goto L28;
        nj0.f r2 = LinkmicSubtitleUIContext.Companion.a();
        if (r2 == null) goto L28;
        Integer r3 = je0.d.h();
        if (r3 == null) goto L18;
        int r4 = r3.intValue();
    L19:
        Pair<Float, Float> r7 = r2.di(r4, r6.ordinal());
        if (r7 == null) goto L28;
        q2 r8 = r0.getSubtitleStatus();
        if (r8 == null) goto L24;
        r8.setX(((Number) r7.getFirst()).floatValue());
    L24:
        q2 r9 = r0.getSubtitleStatus();
        if (r9 == null) goto L28;
        r9.setY(((Number) r7.getSecond()).floatValue());
        goto L28
    L18:
        r4 = 0;
    L28:
        if (r6 != LinkmicSubtitleStyle.LONG) goto L34;
        nj0.f r10 = LinkmicSubtitleUIContext.Companion.a();
        if (r10 == null) goto L34;
        float r11 = r10.zp();
        q2 r12 = r0.getSubtitleStatus();
        if (r12 == null) goto L34;
        r12.setX(r11);
    L34:
        nj0.b r13 = LinkmicSubtitleBusinessContext.Companion.b();
        if (r13 == null) goto L38;
        r13.N5(r0, UpdateSubtitleType.STYLE, new d0(r5, r0, r6));
        return;
    L38:
        return;
    }

    public static final void U90(LinkmicSubtitleSettingDialog r3, LinkmicSubtitleType r4) {
        IAudioSubtitleContent r0 = r3.e;
        if (r0 != null) goto L5;
        r0 = (IAudioSubtitleContent) vh7.f.c(IAudioSubtitleContent.class);
    L5:
        q2 r1 = r0.getSubtitleStatus();
        if (r1 == null) goto L8;
        r1.setSubtitleType(r4.ordinal());
    L8:
        nj0.b r5 = LinkmicSubtitleBusinessContext.Companion.b();
        if (r5 == null) goto L12;
        r5.N5(r0, UpdateSubtitleType.TYPE, new e0(r3, r0));
        return;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        s r10 = t.a;
        String r11 = this.i;
        Intrinsics.checkNotNullParameter(r11, "requestPage");
        LinkedHashMap r12 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r12, null, null, 6);
        t.i(r12);
        r12.put("request_page", r11);
        r12.put("play_mode", u0.b());
        j0.l().sendLog("livesdk_caption_setting_menu_show", r12, new Object[]{IRoom.class});
        if (com.bytedance.android.live.liveinteract.voicechat.stage.a.d() == false) goto L28;
        Integer r13 = je0.d.h();
        if (r13 != null) goto L8;
    L9:
        Integer r14 = je0.d.h();
        if (r14 != null) goto L13;
    L14:
        Integer r15 = je0.d.h();
        if (r15 != null) goto L18;
    L24:
        if (V90() == false) goto L26;
    L25:
        S90(2131387675).setVisibility(0);
    L27:
        S90(2131387660).setVisibility(8);
    L29:
        S90(2131387665).setChecked(true);
        S90(2131387668).setChecked(false);
        IAudioSubtitleContent r1 = this.e;
        if (r1 == null) goto L36;
        q2 r2 = r1.getSubtitleStatus();
        if (r2 == null) goto L36;
        if (r2.getSubtitleStyle() != LinkmicSubtitleStyle.LONG.ordinal()) goto L36;
        S90(2131387665).setChecked(true);
        S90(2131387668).setChecked(false);
    L43:
        LiveSwitchButton r16 = S90(2131387661);
        IAudioSubtitleContent r3 = this.e;
        if (r3 != null) goto L46;
    L48:
        boolean r4 = false;
    L49:
        r16.setChecked(r4);
        ImageLoader.bindImage(S90(2131387664), j);
        ImageLoader.bindImage(S90(2131387667), k);
        S90(2131387683).setChecked(true);
        S90(2131387678).setChecked(false);
        IAudioSubtitleContent r5 = this.e;
        if (r5 == null) goto L56;
        q2 r6 = r5.getSubtitleStatus();
        if (r6 == null) goto L56;
        if (r6.getSubtitleType() != LinkmicSubtitleType.Room.ordinal()) goto L56;
        S90(2131387683).setChecked(true);
        S90(2131387678).setChecked(false);
    L63:
        boolean r0 = V90();
        if (r0 == false) goto L66;
        ImageUtil.loadImage((ImageView) S90(2131387677), p, ImageView.ScaleType.FIT_CENTER);
    L67:
        Integer r7 = je0.d.h();
        if (r7 != null) goto L71;
    L73:
        if (r0 == false) goto L75;
        ImageUtil.loadImage((ImageView) S90(2131387682), o, ImageView.ScaleType.FIT_CENTER);
    L77:
        if (V90() == false) goto L79;
        ((TextView) S90(2131387685)).setText(s1.B(2131918806));
        ((TextView) S90(2131387680)).setText(s1.B(2131918803));
    L79:
        S90(2131387664).setOnClickListener(new x(this));
        S90(2131387667).setOnClickListener(new y(this));
        S90(2131387681).setOnClickListener(new z(this));
        S90(2131387676).setOnClickListener(new a0(this));
        S90(2131387661).setOnClickListener(new b0(this));
        return;
    L75:
        ImageUtil.loadImage((ImageView) S90(2131387682), l, ImageView.ScaleType.FIT_CENTER);
        goto L77
    L71:
        if (r7.intValue() != 22) goto L73;
        ImageUtil.loadImage((ImageView) S90(2131387682), m, ImageView.ScaleType.FIT_CENTER);
        goto L77
    L66:
        ImageUtil.loadImage((ImageView) S90(2131387677), n, ImageView.ScaleType.FIT_CENTER);
    L56:
        IAudioSubtitleContent r17 = this.e;
        if (r17 == null) goto L63;
        q2 r18 = r17.getSubtitleStatus();
        if (r18 == null) goto L63;
        if (r18.getSubtitleType() != LinkmicSubtitleType.Enlarged.ordinal()) goto L63;
        S90(2131387683).setChecked(false);
        S90(2131387678).setChecked(true);
        goto L63
    L46:
        if (r3.getStatus() != IAudioSubtitleContent.SwitchStatus.SWITCH_ON.getValue()) goto L48;
        r4 = true;
    L36:
        IAudioSubtitleContent r19 = this.e;
        if (r19 == null) goto L43;
        q2 r20 = r19.getSubtitleStatus();
        if (r20 == null) goto L43;
        if (r20.getSubtitleStyle() != LinkmicSubtitleStyle.SHORT.ordinal()) goto L43;
        S90(2131387665).setChecked(false);
        S90(2131387668).setChecked(true);
        goto L43
    L26:
        S90(2131387480).setVisibility(0);
        S90(2131387675).setVisibility(8);
        goto L27
    L18:
        if (r15.intValue() != 30) goto L24;
    L19:
        com.bytedance.android.live.liveinteract.revenue.fight.b r21 = ((IInteractService) jc1.k.n(IInteractService.class)).teamFightService();
        if (r21 == null) goto L24;
        if (r21.t5() == false) goto L25;
    L13:
        if (r14.intValue() == 26) goto L19;
    L8:
        if (r13.intValue() == 27) goto L19;
    L28:
        S90(2131387660).setVisibility(0);
        S90(2131387675).setVisibility(8);
        goto L29
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131565595, r2);
    }
}
