package com.bytedance.android.live.effect.api;

import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c0 {
    public static final List<s> a = null;
    public static final List<String> b = null;
    public static final boolean c = false;

    static {
        LinkedList r0 = new LinkedList();
        a = r0;
        LinkedList r1 = new LinkedList();
        b = r1;
        boolean r2 = LiveEffectSettings.LIVE_EFFECT_DIGITAL_AVATAR_REPEL_COMPATIBLE.getValue().booleanValue();
        c = r2;
        if (r2 == false) goto L5;
        r0.add(new s("livedigitavatar", Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
    L6:
        r0.add(new s("guestfight", Arrays.asList(new Integer[]{1, 2, 3, 4, 5})));
        r0.add(new s("teamfight", Arrays.asList(new Integer[]{1, 2, 3, 4, 5})));
        r0.add(new s("theme_event", Arrays.asList(new Integer[]{1, 2, 3, 4, 5})));
        r0.add(new s("multi_seat_widget", Arrays.asList(new Integer[]{1, 2, 3, 4, 5})));
        r0.add(new s("livegame", Collections.singletonList(3)));
        r0.add(new s(d0.g, Collections.singletonList(5)));
        r0.add(new s(FileUtils.BEAUTY, Arrays.asList(new Integer[]{1, 2, 3})));
        r0.add(new s("magicGestureActivity", Arrays.asList(new Integer[]{1, 2, 3, 4, 5})));
        String r3 = d0.i;
        r0.add(new s(r3, Arrays.asList(new Integer[]{1, 2, 3, 6})));
        String r5 = d0.k;
        r0.add(new s(r5, Arrays.asList(new Integer[]{1, 2, 3, 6})));
        r0.add(new s("effect_gift", Arrays.asList(new Integer[]{1, 3, 5, 6})));
        r0.add(new s("effect_gift_special", Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r0.add(new s("effect_gift_top_effect", Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r0.add(new s("effect_interact_gift", Arrays.asList(new Integer[]{1, 3, 5, 6})));
        r0.add(new s("livetakepagegame", Collections.singletonList(3)));
        r0.add(new s("livemoneygame", Collections.singletonList(3)));
        r0.add(new s(d0.b, Arrays.asList(new Integer[]{2, 4})));
        r0.add(new s(d0.c, Collections.singletonList(2)));
        r0.add(new s(d0.h, Collections.singletonList(2)));
        r0.add(new s("livebody", Arrays.asList(new Integer[]{1, 2, 3})));
        String r7 = d0.a;
        r0.add(new s(r7, Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r0.add(new s(d0.d, Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r0.add(new s("effect_interact_gift_special", Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r0.add(new s("effect_interact_gift_pk_env", Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r0.add(new s("effect_atmosphere", Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r0.add(new s("live_adjustment", Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r0.add(new s("live_camera_move", Collections.singletonList(2)));
        r0.add(new s("zongyiyouxi", Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r0.add(new s("effect_pk_interact_play", Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r1.add(r3);
        r1.add(r5);
        r1.add("live_adjustment");
        r1.add("live_camera_move");
        r1.add(r7);
        return;
    L5:
        r0.add(new s("livedigitavatar", Arrays.asList(new Integer[]{4, 6})));
        goto L6
    }
}
