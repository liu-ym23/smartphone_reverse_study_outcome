package com.ss.android.lark.locationmessage.message;

import android.content.Intent;
import android.view.View;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.keyboard.biz.plus.PlusKBPlugin;
import com.ss.android.lark.location.dto.POIConfig;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.lark.locationmessage.statistics.LocationHitpointParams$Click;
import com.ss.android.lark.locationmessage.statistics.LocationHitpointParams$IsFullScreen;
import com.ss.android.lark.locationmessage.statistics.LocationHitpointParams$Target;
import com.ss.android.lark.locationmessage.statistics.NavigateHitPoint$Event;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements d5b.a {
    public d5b.c a;
    public final Chat b;
    public final boolean c;
    public final Token d;

    public final boolean a(Intent r1, int r2) {
        return false;
    }

    public final void b() {
    }

    public final void c() {
    }

    public final int e() {
        return 60;
    }

    public final int getIconId() {
        return 2131243868;
    }

    public final boolean isVisible() {
        return true;
    }

    public final /* synthetic */ void showRedDot() {
    }

    public final String getName() {
        return UIHelper.getString(2131890377);
    }

    public b(Chat r3) {
        this.d = new Token("LARK-PSDA-keyboard_send_location");
        this.b = r3;
        this.c = true;
    }

    public final void d(PlusKBPlugin r1) {
        this.a = r1;
    }

    public final void onClick(View r12) {
        HashMap r0 = new HashMap(1);
        r0.put("click_button", "location");
        Statistics.sendEvent("im_chat_input_toolbar_plus", new JSONObject(r0));
        Statistics.sendEvent(NavigateHitPoint$Event.MESSAGE_LOCATION_ENTER);
        LocationHitpointParams$IsFullScreen r1 = LocationHitpointParams$IsFullScreen.FALSE;
        Statistics.sendEvent("im_chat_input_plus_click", LocationHitpointParams$Click.LOCATION.plus(LocationHitpointParams$Target.MESSAGE_LOCATION_VIEW).plus(r1).plus(ChatParamUtils.e()).toJson());
        POIConfig r5 = new POIConfig();
        r5.setActionText(r12.getContext().getString(2131892196));
        r5.setSnapshot(true);
        r5.setSelfDefine(false);
        r5.setNeedWGSLatLng(true);
        fqb.a.c(this.a.getActivity(), null, r5, this.d, Scene.IM.INSTANCE, new a(this), false, this.c);
    }
}
