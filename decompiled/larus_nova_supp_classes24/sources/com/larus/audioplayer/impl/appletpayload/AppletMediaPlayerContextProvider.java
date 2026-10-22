package com.larus.audioplayer.impl.appletpayload;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.controller.GlobalAudioController;
import com.larus.bmhome.chat.api.IAppletPayloadProviderService;
import com.larus.bmhome.chat.api.t0;
import com.larus.call_plugins_doubao_common.CommonAppletPlugin;
import com.larus.common.apphost.AppHost;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u0010"}, d2 = {"Lcom/larus/audioplayer/impl/appletpayload/AppletMediaPlayerContextProvider;", "Lcom/larus/bmhome/chat/api/IAppletPayloadProviderService;", "<init>", "()V", "getAppletPayload", "", "", "conversationId", "botId", "msgId", "addOnAppletPayloadChangedListener", "", "listener", "Lcom/larus/bmhome/chat/api/OnAppletPayloadChangedListener;", "removeOnAppletPayloadChangedListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AppletMediaPlayerContextProvider implements IAppletPayloadProviderService {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static Map a(String r11, String r12) {
            if (AppHost.a.isOversea() == false) goto L6;
            return null;
        L6:
            if (r11 != null) goto L8;
        L11:
            boolean r2 = true;
        L13:
            if (r2 == true) goto L21;
            Pair[] r3 = new Pair[4];
            r3[0] = TuplesKt.to("current_system_volume", String.valueOf(GlobalAudioController.a.e()));
            r3[1] = TuplesKt.to("vui_media_player_scene", r11);
            if (r12 != null) goto L18;
            r12 = "";
        L18:
            r3[2] = TuplesKt.to("media_player_business_scene", r12);
            r3[3] = TuplesKt.to("vui_media_player_occupied", "1");
            return MapsKt.mapOf(r3);
        L21:
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("current_system_volume", String.valueOf(GlobalAudioController.a.e())), TuplesKt.to("vui_media_player_scene", ""), TuplesKt.to("vui_media_player_occupied", "0")});
        L8:
            if (r11.length() == 0) goto L11;
            r2 = false;
            goto L13
        }
    }

    static {
    }

    public AppletMediaPlayerContextProvider() {
    }

    public final void a(t0 r1) {
    }

    public final void c(CommonAppletPlugin.initAppletPayloadChangeListener.1 r1) {
    }

    public final Map<String, String> b(String r1, String r2, String r3) {
        GlobalAudioController r4 = GlobalAudioController.a;
        return a.a(r4.getCurrentScene(), r4.g());
    }
}
