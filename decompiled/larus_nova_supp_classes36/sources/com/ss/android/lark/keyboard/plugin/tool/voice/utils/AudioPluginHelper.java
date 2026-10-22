package com.ss.android.lark.keyboard.plugin.tool.voice.utils;

import com.bytedance.lark.pb.basic.v1.UniversalUserSetting;
import com.ss.android.lark.audio.voiceinput.AudioPluginUseType;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioKBPlugin;
import com.ss.android.lark.larkconfig.universal.e;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AudioPluginHelper {
    public static final /* synthetic */ int f = 0;
    public final AudioKBPlugin a;
    public final Lazy b;
    public AudioPluginUseType c;
    public final boolean d;
    public final boolean e;

    public static final class a {
        public static Pair a() {
            e r0 = e.a;
            Intrinsics.checkNotNullParameter("VOICE_SEND_MENU_OPTION", TabAppInfo.IMAGE_JSON_KEY);
            com.ss.android.lark.larkconfig.universal.a.a.getClass();
            Intrinsics.checkNotNullParameter("VOICE_SEND_MENU_OPTION", TabAppInfo.IMAGE_JSON_KEY);
            UniversalUserSetting r1 = (UniversalUserSetting) ((LinkedHashMap) com.ss.android.lark.larkconfig.universal.a.b).get("VOICE_SEND_MENU_OPTION");
            StringBuilder r2 = new StringBuilder("get VOICE_SEND_MENU_OPTION is null -> ");
            boolean r3 = false;
            if (r1 != null) goto L5;
            boolean r4 = true;
        L6:
            r2.append(r4);
            Log.e("UniversalUserSettingManager", r2.toString());
            AudioPluginUseType r5 = null;
            if (r1 == null) goto L20;
            com.ss.android.lark.im.base.a.a().putInt("KV_VOICE_SEND_MENU_OPTION", (int) r1.int_value.longValue());
            AudioPluginUseType.a r6 = AudioPluginUseType.Companion;
            int r7 = (int) r1.int_value.longValue();
            r6.getClass();
            AudioPluginUseType[] r8 = AudioPluginUseType.values();
            int r9 = r8.length;
            int r10 = 0;
        L9:
            if (r10 >= r9) goto L17;
            AudioPluginUseType r11 = r8[r10];
            if (r11.getType() != r7) goto L13;
            boolean r12 = true;
        L14:
            if (r12 == true) goto L15;
            r10 = r10 + 1;
            goto L9
        L15:
            r5 = r11;
            goto L17
        L13:
            r12 = false;
        L17:
            if (r5 != null) goto L19;
            r5 = AudioPluginUseType.NEVER_SET;
        L19:
            Log.i("AudioSendTypeHelper", "get user setting success = " + r5.getType());
            r3 = true;
        L33:
            return new Pair(r5, Boolean.valueOf(r3));
        L20:
            Log.i("AudioSendTypeHelper", "set getUserSettingTypeSuccess= false");
            AudioPluginUseType.a r13 = AudioPluginUseType.Companion;
            com.ss.android.lark.storage.kv.repo.a r14 = com.ss.android.lark.im.base.a.a();
            AudioPluginUseType r15 = AudioPluginUseType.NEVER_SET;
            int r16 = r14.getInt("KV_VOICE_SEND_MENU_OPTION", r15.getType());
            r13.getClass();
            AudioPluginUseType[] r17 = AudioPluginUseType.values();
            int r18 = r17.length;
            int r19 = 0;
        L21:
            if (r19 >= r18) goto L29;
            AudioPluginUseType r20 = r17[r19];
            if (r20.getType() != r16) goto L25;
            boolean r110 = true;
        L26:
            if (r110 == true) goto L27;
            r19 = r19 + 1;
            goto L21
        L27:
            r5 = r20;
            goto L29
        L25:
            r110 = false;
        L29:
            if (r5 != null) goto L31;
            r5 = r15;
        L31:
            Log.i("AudioSendTypeHelper", "get user setting fail, use local kv = " + r5.getType());
            goto L33
        L5:
            r4 = false;
            goto L6
        }
    }

    static {
    }

    public final void a() {
        if (this.a.f.b != VoiceInputScene.EnterpriseAnswer) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L11;
        Log.i("AudioSendTypeHelper", "initAudioConfig ->this scene do not need update");
        return;
    L11:
        if (this.e == false) goto L18;
        Log.i("AudioSendTypeHelper", "initAudioConfig -> FG enable new audio, getUserSettingTypeSuccess = " + this.d);
        if (this.c == AudioPluginUseType.NEVER_SET) goto L15;
        return;
    L15:
        if (this.d == false) goto L20;
        Log.i("AudioSendTypeHelper", "userSettingType never set, start upgrade to new audio plugin");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AudioPluginHelper$initAudioConfig$1(this, null), 3, null);
        this.c = AudioPluginUseType.NEW;
        return;
    L20:
        return;
    L18:
        return;
    L5:
        r0 = false;
        goto L7
    }

    public final void b() {
        Job r0 = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AudioPluginHelper$rollbackToOldAudio$1(this, null), 3, null);
        ((ArrayList) this.b.getValue()).add(r0);
    }

    public AudioPluginHelper(AudioKBPlugin r2) {
        Intrinsics.checkNotNullParameter(r2, "currentAudioKBPlugin");
        this.a = r2;
        this.b = LazyKt.lazy(AudioPluginHelper$jobList$2.INSTANCE);
        this.e = KeyboardVoiceFGUtils.h();
        Pair r3 = a.a();
        AudioPluginUseType r0 = (AudioPluginUseType) r3.component1();
        boolean r4 = ((Boolean) r3.component2()).booleanValue();
        this.c = r0;
        this.d = r4;
    }
}
