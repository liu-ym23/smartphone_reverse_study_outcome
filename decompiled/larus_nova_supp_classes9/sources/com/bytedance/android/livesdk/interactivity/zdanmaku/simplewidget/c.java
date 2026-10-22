package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager.SimpleSettingManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.zdanmaku.render.canvas.RenderEngineView;
import io.reactivex.functions.Consumer;
import p22.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ PortraitSimpleZDanmakuWidget a;

    public c(PortraitSimpleZDanmakuWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        o r7 = (o) r6;
        int r0 = i.a;
        StringBuilder r1 = new StringBuilder("observeSimpleDanmakuSettingChange, widget.hashCode: ");
        r1.append(this.a.hashCode());
        r1.append(", room.hashCode: ");
        Room r2 = this.a.i;
        Integer r3 = null;
        if (r2 == null) goto L5;
        Integer r4 = Integer.valueOf(r2.hashCode());
    L6:
        r1.append(r4);
        r1.append(", roomId: ");
        Room r5 = this.a.i;
        if (r5 == null) goto L9;
        Long r8 = Long.valueOf(r5.id);
    L10:
        r1.append(r8);
        i.d(r1.toString());
        PortraitSimpleZDanmakuWidget r9 = this.a;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r10 = SimpleSettingManager.a;
        RenderEngineView r11 = r9.a;
        if (r11 == null) goto L20;
        Integer r13 = Integer.valueOf(r11.getWidth());
        if (r13.intValue() <= 0) goto L15;
        boolean r14 = true;
    L16:
        if (r14 == false) goto L18;
        r3 = r13;
    L18:
        if (r3 == null) goto L20;
        int r15 = r3.intValue();
    L21:
        r9.xq(SimpleSettingManager.a(r7, r15));
        return;
    L15:
        r14 = false;
    L20:
        r15 = s1.y();
        goto L21
    L9:
        r8 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
