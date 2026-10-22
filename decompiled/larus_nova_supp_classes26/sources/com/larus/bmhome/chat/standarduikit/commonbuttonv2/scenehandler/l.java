package com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l extends c {
    public final String a;

    public l() {
        this.a = "live_tutor_main";
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final String getScene() {
        return this.a;
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final void a(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r5) {
        Intrinsics.checkNotNullParameter(r5, "vmData");
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        r1.put("item_content", r5.a);
        r1.put("suggested_type", "live_tutor");
        r1.put("current_page", "chat");
        Message r6 = r5.i;
        if (r6 == null) goto L5;
        String r7 = r6.getMessageId();
    L6:
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        r1.put(MusicAppletPage.KEY_MESSAGE_ID, r7);
        r1.put("item_type", "tutor_sug_card");
        r1.put("button_type", "tutor_entrance");
        Unit r8 = Unit.INSTANCE;
        r0.reportEvent("live_tutor_click_button", r1);
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final boolean c(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r2) {
        Intrinsics.checkNotNullParameter(r2, "vmData");
        String r3 = r2.a;
        if (r3 != null) goto L5;
    L8:
        return true;
    L5:
        if (r3.length() == 0) goto L8;
        return false;
    }

    @Override // com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.c, com.larus.bmhome.chat.standarduikit.commonbuttonv2.scenehandler.d
    public final void d(com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r5) {
        Intrinsics.checkNotNullParameter(r5, "vmData");
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        r1.put("item_content", r5.a);
        r1.put("suggested_type", "live_tutor");
        r1.put("current_page", "chat");
        Message r6 = r5.i;
        if (r6 == null) goto L5;
        String r7 = r6.getMessageId();
    L6:
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        r1.put(MusicAppletPage.KEY_MESSAGE_ID, r7);
        r1.put("item_type", "tutor_sug_card");
        Unit r8 = Unit.INSTANCE;
        r0.reportEvent("live_tutor_item_show", r1);
        return;
    L5:
        r7 = null;
        goto L6
    }
}
