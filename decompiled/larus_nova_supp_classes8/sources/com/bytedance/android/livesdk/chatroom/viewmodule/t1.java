package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.livesdk.config.tl;
import com.bytedance.android.livesdk.message.model.RoomNotifyMessageExtra;
import com.bytedance.android.livesdk.message.model.ik;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.TextFormat;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t1<T> implements Consumer {
    public final /* synthetic */ LiveCommerceTipsWidget a;

    public t1(LiveCommerceTipsWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        LiveCommerceTipsWidget r9 = this.a;
        LiveCommerceTipsWidget.a r0 = LiveCommerceTipsWidget.c;
        DataCenter r1 = ((Widget) r9).dataCenter;
        if (r1 != null) goto L6;
    L10:
        boolean r2 = false;
    L12:
        if (r2 == true) goto L19;
        DataCenter r10 = ((Widget) r9).dataCenter;
        vlc.d r3 = null;
        if (r10 == null) goto L16;
        r3 = (vlc.d) r10.get("data_message_manager", null);
    L16:
        if (r3 == null) goto L20;
        LiveCommerceTipsWidget.c.getClass();
        String r11 = tl.a.getValue().b();
        ik r4 = new ik();
        CommonMessageData r5 = new CommonMessageData();
        r5.createTime = com.bytedance.android.livesdk.utils.ntp.e.a();
        r5.showMsg = true;
        r4.setBaseMessage(r5);
        ((com.bytedance.android.livesdk.message.model.o0) r4).isLocalInsertMsg2 = true;
        r4.setSchema("");
        a5 r6 = vh7.f.c(a5.class);
        r6.setDefaultPattern(r11);
        TextFormat r12 = new TextFormat();
        r12.setColor("#FFFFFF");
        r12.setWeight(400);
        r6.setDefaultFormat(r12);
        r5.setDisplayText(r6);
        RoomNotifyMessageExtra r13 = new RoomNotifyMessageExtra();
        ImageModel r14 = new ImageModel();
        r14.width = 355;
        r14.height = 30;
        ArrayList r15 = new ArrayList();
        r15.add("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/xigua_xitongtongzhi888.png_tplv-obj.image");
        r15.add("https://lf9-webcastcdn-tos.douyinstatic.com/obj/live-android/xigua_xitongtongzhi888.png_tplv-obj.image");
        r14.setUrls(r15);
        r14.setUri("webcast/xigua_xitongtongzhi888.png");
        r13.d(r14);
        r13.e(5);
        r4.P(r13);
        r3.j(r4, true);
        return;
    L20:
        return;
    L19:
        return;
    L6:
        if (r9.a == false) goto L8;
    L11:
        r2 = true;
        goto L12
    L8:
        if (((Boolean) r1.get("data_hide_screen", Boolean.FALSE)).booleanValue() == false) goto L10;
        goto L10
    }
}
