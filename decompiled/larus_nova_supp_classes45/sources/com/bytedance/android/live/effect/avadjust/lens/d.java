package com.bytedance.android.live.effect.avadjust.lens;

import android.view.View;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import pv0.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ LensTabItemView a;
    public final /* synthetic */ k90.b b;
    public final /* synthetic */ LiveLensFragment c;
    public final /* synthetic */ k90.a d;

    public d(LensTabItemView r1, k90.b r2, LiveLensFragment r3, k90.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r14) {
        String r0 = "open";
        String r3 = "";
        if (this.d.getType() != 0) goto L17;
        this.b.getClass();
        if (0.0f == 0.0f) goto L7;
        boolean r15 = true;
    L8:
        int r2 = com.bytedance.android.live.videocapture.ve.b.a;
        xs2.b.a().post(new i(r15));
        LiveLensFragment r4 = this.c;
        HashMap<String, String> r6 = new HashMap();
        if (r15 == true) goto L12;
        r0 = "close";
    L12:
        r6.put("stability_status", r0);
        if (r15 == false) goto L15;
        String r16 = "0";
    L16:
        r6.put("stability_gear", r16);
        Unit r17 = Unit.INSTANCE;
        int r18 = LiveLensFragment.k;
        r4.T90("livesdk_sound_image_set_tab_camera_lens_stability_select_click", "", r6);
    L68:
        k90.a r19 = this.d;
        this.b.getClass();
        r19.a = 0.0f;
        LiveLensFragment r110 = this.c;
        LensTabItemView r1 = this.a;
        Iterator r111 = ((ArrayList) r110.h).iterator();
    L70:
        if (r111.hasNext() == false) goto L72;
        ((LensTabItemView) r111.next()).R5(false);
        goto L70
    L72:
        r1.R5(true);
        LiveLensAdapter r112 = (LiveLensAdapter) this.c.g.getValue();
        int r5 = r112.b;
        if (r5 >= 0) goto L75;
        return;
    L75:
        if (r5 >= ((ArrayList) r112.a).size()) goto L84;
        r112.notifyItemChanged(r112.b);
        return;
    L84:
        return;
    L15:
        r16 = GamePromoteDataContext.GAME_TYPE_MOBILE;
        goto L16
    L7:
        r15 = false;
        goto L8
    L17:
        Sticker r8 = this.c.e;
        if (r8 != null) goto L20;
        return;
    L20:
        this.b.getClass();
        float r113 = 0;
        if (0.0f <= r113) goto L46;
        List r7 = r8.getTags();
        if (r7 != null) goto L25;
    L28:
        boolean r9 = true;
    L29:
        if (r9 == true) goto L46;
        List<String> r11 = LiveEffectContext.h;
        List<Sticker> r12 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().o(d0.c);
        if (r12.isEmpty() == false) goto L33;
        Sticker r13 = null;
    L34:
        if (r13 == null) goto L46;
        List r21 = r13.getTags();
        if (r21 == null) goto L46;
        List r22 = r8.getTags();
        if (r22 == null) goto L46;
        Iterator r23 = r22.iterator();
    L41:
        if (r23.hasNext() == false) goto L46;
        if (r21.contains((String) r23.next()) == false) goto L41;
        f2.c("请关闭当前特效后再尝试", 0);
        return;
    L33:
        r13 = (Sticker) ListProtector.get(r12, 0);
        goto L34
    L25:
        if (r7.isEmpty() == true) goto L28;
        r9 = false;
    L46:
        Map<Long, Float> r24 = com.bytedance.android.live.effect.avadjust.a.a;
        Long r25 = Long.valueOf(r8.getId());
        this.b.getClass();
        r24.put(r25, Float.valueOf(0.0f));
        this.b.getClass();
        if (0.0f == 0.0f) goto L56;
        List<String> r26 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.c.getType()).a().a("live_camera_move", r8, "ttlive_anchor_effect_LiveLensFragmentrefreshTabLayout");
        ILiveEffectComposerManager r27 = LiveEffectContext.a.a(this.c.getType()).a();
        Sticker.ComposerConfig r28 = r8.getSmallItemConfig();
        if (r28 == null) goto L54;
        String r29 = r28.getTag();
        if (r29 == null) goto L54;
        String r31 = r29;
    L55:
        this.b.getClass();
        ILiveEffectComposerManager.f.d(r27, "live_camera_move", r8, r31, 0.0f, null, 48);
    L57:
        LiveLensFragment r32 = this.c;
        Sticker r33 = r32.e;
        if (r33 == null) goto L63;
        String r34 = r33.getName();
        if (r34 == null) goto L63;
        r3 = r34;
    L63:
        HashMap<String, String> r35 = new HashMap();
        this.b.getClass();
        if (0.0f > r113) goto L67;
        r0 = "close";
    L67:
        r35.put("follow_status", r0);
        this.b.getClass();
        r35.put("follow_gear", null);
        this.b.getClass();
        r35.put("follow_value", String.valueOf(0.0f));
        Unit r114 = Unit.INSTANCE;
        r32.T90("livesdk_sound_image_set_tab_camera_lens_follow_select_click", r3, r35);
    L54:
        r31 = "";
        goto L55
    L56:
        List<String> r36 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.c.getType()).a().O("live_camera_move", r8, "ttlive_anchor_effect_LiveLensFragmentrefreshTabLayout");
        goto L57
    }
}
