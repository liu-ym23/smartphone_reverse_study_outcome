package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.content.Context;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.platform.service.n3;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o0 implements o {

    public static final class a {
    }

    static {
    }

    public o0() {
    }

    @Override // com.larus.chat.gallery.impl.preview.toolbar.action.o
    public final Object a(l0 r7, Continuation<? super Unit> r8) {
        FLogger r9 = FLogger.a;
        r9.i("WatermarkAction", "execute: watermark settings clicked, sourceType=" + r7.a.a);
        boolean r0 = IAIChatUgcAIGCService.a.U();
        if (r0 == false) goto L5;
        String r2 = "no_ai_watermark";
    L6:
        JSONObject r3 = new JSONObject();
        r3.put("watermark_status", r2);
        com.larus.platform.service.o.a.reportEvent("creation_watermark_setting_click", r3);
        int r4 = ma9.a.a;
        boolean r5 = false;
        com.larus.chat.gallery.impl.preview.toolbar.action.a r6 = new com.larus.chat.gallery.impl.preview.toolbar.action.a(0);
        AtomicReference r10 = ga9.a.a;
        ga9.e.a.getClass();
        String r11 = ((com.larus.chat.gallery.impl.preview.toolbar.action.a) ga9.e.a(ga9.a.c("creation_watermark_settings_h5_url", ga9.e.c(r6)), com.larus.chat.gallery.impl.preview.toolbar.action.a.class, r6)).a();
        if (r11 != null) goto L10;
        r11 = "";
    L10:
        if (r11.length() != 0) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L16;
        r11 = "https://lf-doubao-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/11517/gecko/resource/z_h5_resources/html/creation-ai-watermark-setting/index.html?gecko_channel=z_h5_resources&gecko_bundle=html/creation-ai-watermark-setting/index.html&gecko_access_key=f0422741984b436c95f7d24f92f34a97&hide_status_bar=1&should_full_screen=1";
    L16:
        if (r11.length() != 0) goto L18;
        r5 = true;
    L18:
        if (r5 == false) goto L21;
        r9.i("WatermarkAction", "execute: watermark settings H5 URL is empty, skip opening");
        return Unit.INSTANCE;
    L21:
        Context r13 = r7.getContext();
        if (r0 == false) goto L24;
        String r1 = "1";
    L25:
        n3.a(r13, UriProtector.parse("sslocal://webview").buildUpon().appendQueryParameter(ShareType.URL, UriProtector.parse(r11).buildUpon().appendQueryParameter("remove_watermark", r1).build().toString()).appendQueryParameter("loader_name", "forest").appendQueryParameter("hide_nav_bar", "1").appendQueryParameter("should_full_screen", "1").appendQueryParameter("use_xbridge3", "true").appendQueryParameter("mix_container_type", "anniex").build().toString());
        return Unit.INSTANCE;
    L24:
        r1 = TriggerSendLoading.NO_LOADING;
        goto L25
    L12:
        r12 = false;
        goto L13
    L5:
        r2 = "ai_watermark";
        goto L6
    }
}
