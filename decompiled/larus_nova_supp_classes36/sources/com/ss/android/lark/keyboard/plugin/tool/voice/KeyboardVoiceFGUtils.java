package com.ss.android.lark.keyboard.plugin.tool.voice;

import com.ss.android.lark.audio.recorder.AudioRecordSettings;
import com.ss.android.lark.audio.voiceinput.AudioPluginUseType;
import com.ss.android.lark.audio.voiceinput.utils.d;
import com.ss.android.lark.keyboard.plugin.tool.voice.utils.AudioPluginHelper;
import com.ss.android.lark.utils.CarUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class KeyboardVoiceFGUtils {
    public static final KeyboardVoiceFGUtils a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AudioPluginUseType.values().length];
            r0[AudioPluginUseType.NEVER_SET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AudioPluginUseType.NEW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AudioPluginUseType.OLD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public KeyboardVoiceFGUtils() {
    }

    public static final boolean c() {
        return a("im.messenger.audio_quote", null);
    }

    public static final boolean d() {
        return a("im.messenger.voice_input_emoji", null);
    }

    public static final boolean e() {
        if (a("im.messenger.richtext_voice_input", null) == true) goto L5;
        return false;
    L5:
        if (h() == false) goto L20;
        int r0 = AudioPluginHelper.f;
        Pair r1 = AudioPluginHelper.a.a();
        AudioPluginUseType r2 = (AudioPluginUseType) r1.component1();
        ((Boolean) r1.component2()).booleanValue();
        int r3 = a.a[r2.ordinal()];
        if (r3 != 1) goto L9;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == false) goto L21;
        return true;
    L21:
        return false;
    L9:
        if (r3 == 2) goto L15;
        if (r3 != 3) goto L14;
        r4 = false;
        goto L16
    L14:
        throw new NoWhenBranchMatchedException();
    L20:
        return false;
    }

    static {
        a = new KeyboardVoiceFGUtils();
        b = LazyKt.lazy(KeyboardVoiceFGUtils$isServerPointEnable$2.INSTANCE);
        c = LazyKt.lazy(KeyboardVoiceFGUtils$isPostMessageEnableReverse$2.INSTANCE);
        d = LazyKt.lazy(KeyboardVoiceFGUtils$isDictateRetry$2.INSTANCE);
        e = LazyKt.lazy(KeyboardVoiceFGUtils$isVoiceSecondInputV2$2.INSTANCE);
        f = LazyKt.lazy(KeyboardVoiceFGUtils$isVoiceInputMarkdownRound2$2.INSTANCE);
    }

    public static boolean i() {
        return ((Boolean) f.getValue()).booleanValue();
    }

    public final boolean f() {
        return g(this, "im.messenger.second_voice_input");
    }

    public final boolean j() {
        if (g(this, "im.messenger.voice_input_markdown") == false) goto L5;
    L8:
        return true;
    L5:
        if (g(this, "im.messenger.voice_input_all_use_richtext") == false) goto L8;
        return false;
    }

    public static boolean b() {
        if (AudioRecordSettings.e().contains("im.messenger.text_by_default") == false) goto L5;
    L8:
        return true;
    L5:
        if (a("im.messenger.text_by_default", null) == true) goto L8;
        return false;
    }

    public static final boolean h() {
        if (CarUtils.a() == false) goto L6;
        return true;
    L6:
        if (AudioRecordSettings.e().contains("im.messenger.new_voice_input") == false) goto L8;
        return true;
    L8:
        if (a("im.messenger.new_voice_input", null) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static boolean a(final String r2, d r3) {
        final boolean r0 = KeyboardVoiceModule.a().isCurrentFeatureEnable(r2);
        final Function0<Unit> r1 = new KeyboardVoiceFGUtils$isCurrentFgEnable$1$block$1(r2, r0);
        if (r3 == null) goto L5;
        r3.a(new KeyboardVoiceFGUtils$isCurrentFgEnable$1$1(r1));
    L6:
        return r0;
    L5:
        r1.invoke();
        goto L6
    }

    public static boolean g(KeyboardVoiceFGUtils r1, final String r2) {
        r1.getClass();
        final boolean r3 = KeyboardVoiceModule.a().isFeatureGatingEnable(r2);
        new KeyboardVoiceFGUtils$isFgEnable$1$block$1(r2, r3).invoke();
        return r3;
    }
}
