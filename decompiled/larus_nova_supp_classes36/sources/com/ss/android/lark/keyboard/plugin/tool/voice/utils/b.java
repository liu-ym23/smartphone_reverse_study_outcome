package com.ss.android.lark.keyboard.plugin.tool.voice.utils;

import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final Map<String, Integer> a = null;

    public static boolean b() {
        if (KeyboardVoiceFGUtils.a("im.messenger.voice_input_polish", null) == true) goto L6;
        return true;
    L6:
        return LarkKVStorage.q(com.ss.android.lark.im.base.a.a, true).getBoolean("user_voice_input_polish_enabled_local_key", true);
    }

    static {
        HashMap r0 = new HashMap();
        a = r0;
        r0.put("zh_ch", 2131890345);
        r0.put("en_us", 2131890346);
    }

    public static String a() {
        if (KeyboardVoiceModule.a().isEn() == false) goto L5;
        String r0 = "en_us";
    L6:
        String r1 = LarkKVStorage.q(com.ss.android.lark.im.base.a.a, true).getString("user_audio_2_text_locale_server_key", r0);
        Log.i("ConfigHelper", "getAudioRecognizeLocale defaultLocale=" + r0 + ", result" + r1);
        return r1;
    L5:
        r0 = "zh_ch";
        goto L6
    }

    public static void c(String r2) {
        LarkKVStorage.q(com.ss.android.lark.im.base.a.a, true).putString("user_audio_2_text_locale_local_key", r2);
    }
}
