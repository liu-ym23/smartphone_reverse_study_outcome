package com.obric.assistant.session.lifecycle;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.ObricWakeupSoundConfig;
import com.obric.assistant.ObricWakeupSoundOption;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.t1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class WakeupSoundPlayer {
    public static final WakeupSoundPlayer a = null;

    static {
        a = new WakeupSoundPlayer();
    }

    public WakeupSoundPlayer() {
    }

    public static Integer c(String r5) {
        String r1 = StringsKt.removePrefix(r5, "raw:");
        if (StringsKt.startsWith$default(r5, "raw:", false, 2, null) == true) goto L6;
        r1 = null;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        int r6 = r1.hashCode();
        if (r6 == (-1621433828)) goto L47;
        if (r6 == (-612322121)) goto L43;
        switch(r6) {
            case -935579990: goto L39;
            case -935579989: goto L35;
            case -935579988: goto L31;
            case -935579987: goto L27;
            case -935579986: goto L23;
            case -935579985: goto L19;
            case -935579984: goto L15;
            default: goto L59;
        };
    L59:
        return null;
    L15:
        if (r1.equals("sound_effect_doubao_peach_07") == true) goto L51;
        return null;
    L51:
        return 2131820654;
    L19:
        if (r1.equals("sound_effect_doubao_peach_06") == true) goto L52;
        return null;
    L52:
        return 2131820653;
    L23:
        if (r1.equals("sound_effect_doubao_peach_05") == true) goto L53;
        return null;
    L53:
        return 2131820652;
    L27:
        if (r1.equals("sound_effect_doubao_peach_04") == true) goto L54;
        return null;
    L54:
        return 2131820651;
    L31:
        if (r1.equals("sound_effect_doubao_peach_03") == true) goto L55;
        return null;
    L55:
        return 2131820650;
    L35:
        if (r1.equals("sound_effect_doubao_peach_02") == true) goto L56;
        return null;
    L56:
        return 2131820649;
    L39:
        if (r1.equals("sound_effect_doubao_peach_01") == true) goto L57;
        return null;
    L57:
        return 2131820648;
    L43:
        if (r1.equals("sound_effect_assistant_wake_up") == true) goto L58;
        return null;
    L58:
        return 2131820645;
    L47:
        if (r1.equals("sound_effect_assistant_listening") == true) goto L50;
        return null;
    L50:
        return 2131820641;
    }

    public final Object b(Continuation<? super Unit> r12) {
        if ((r12 instanceof WakeupSoundPlayer$playWakeupSound$1) == false) goto L7;
        WakeupSoundPlayer$playWakeupSound$1 r0 = (WakeupSoundPlayer$playWakeupSound$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L95:
        if (((Boolean) r13).booleanValue() == true) goto L97;
        SoundEffectHelper.INSTANCE.playActivate();
        return Unit.INSTANCE;
    L97:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r0.label = 1;
        t1 r14 = t1.a;
        ObricWakeupSoundConfig r5 = r14.x1();
        if (r5.getEnable() == true) goto L17;
        FLogger.a.i("WakeupSoundPlayer", "playConfiguredWakeupSound skip, config disabled");
        r13 = Boxing.boxBoolean(false);
    L92:
        if (r13 != r2) goto L95;
        return r2;
    L17:
        List r6 = r5.getOptions();
        String r7 = r5.getDefaultSoundId();
        String r8 = null;
        if (r6 == null) goto L20;
        List r9 = CollectionsKt.filterNotNull(r6);
    L21:
        if (r9 != null) goto L23;
        r9 = CollectionsKt.emptyList();
    L23:
        String r10 = "";
        if (r9.isEmpty() == false) goto L26;
        ObricWakeupSoundOption r11 = null;
    L48:
        if (r11 != null) goto L50;
        FLogger.a.w("WakeupSoundPlayer", "playConfiguredWakeupSound skip, option not found");
        r13 = Boxing.boxBoolean(false);
        goto L92
    L50:
        String r15 = r11.getType();
        if (Intrinsics.areEqual(r15, "raw") == false) goto L64;
        String r16 = r11.getAudio();
        if (r16 != null) goto L55;
        r16 = "";
    L55:
        Integer r17 = c(r16);
        if (r17 != null) goto L58;
        FLogger.a.w("WakeupSoundPlayer", "playRawWakeupSound unsupported audio=" + r16 + ", id=" + r11.getId());
    L90:
        r4 = false;
    L91:
        r13 = Boxing.boxBoolean(r4);
        goto L92
    L58:
        int r18 = r17.intValue();
        String r19 = r11.getId();
        if (r19 == null) goto L62;
        r10 = r19;
    L62:
        a(r18, r10, r16);
        goto L91
    L64:
        if (Intrinsics.areEqual(r15, "raw_pool") == true) goto L66;
        FLogger.a.w("WakeupSoundPlayer", "playConfiguredWakeupSound skip, unknown type=" + r11.getType());
        goto L90
    L66:
        if (Intrinsics.areEqual(r11.getResourceSource(), "raw_builtin") == true) goto L68;
        FLogger.a.w("WakeupSoundPlayer", "playRawPoolWakeupSound unsupported resourceSource=" + r11.getResourceSource() + ", id=" + r11.getId());
        goto L90
    L68:
        List r110 = r11.getAudioPool();
        if (r110 == null) goto L79;
        List r111 = CollectionsKt.filterNotNull(r110);
        if (r111 == null) goto L79;
        ArrayList r20 = new ArrayList();
        Iterator r112 = r111.iterator();
    L74:
        if (r112.hasNext() == false) goto L78;
        Object r21 = r112.next();
        if ((!StringsKt.isBlank((String) r21)) == false) goto L74;
        r20.add(r21);
        goto L74
    L78:
        r8 = (String) CollectionsKt.randomOrNull(r20, Random.Default);
    L79:
        if (r8 != null) goto L81;
        FLogger.a.w("WakeupSoundPlayer", "playRawPoolWakeupSound empty audioPool, id=" + r11.getId());
        goto L90
    L81:
        Integer r113 = c(r8);
        if (r113 != null) goto L84;
        FLogger.a.w("WakeupSoundPlayer", "playRawPoolWakeupSound unsupported audio=" + r8 + ", id=" + r11.getId());
        goto L90
    L84:
        int r114 = r113.intValue();
        String r22 = r11.getId();
        if (r22 == null) goto L88;
        r10 = r22;
    L88:
        a(r114, r10, r8);
        goto L91
    L26:
        String r115 = r14.d0();
        if (StringsKt.isBlank(r115) == false) goto L31;
        if (r7 != null) goto L30;
        r115 = "";
        goto L31
    L30:
        r115 = r7;
    L31:
        List r23 = r9;
        Iterator r24 = r23.iterator();
    L33:
        if (r24.hasNext() == false) goto L37;
        Object r25 = r24.next();
        if (Intrinsics.areEqual(((ObricWakeupSoundOption) r25).getId(), r115) == false) goto L33;
    L38:
        r11 = (ObricWakeupSoundOption) r25;
        if (r11 != null) goto L48;
        Iterator r116 = r23.iterator();
    L42:
        if (r116.hasNext() == false) goto L46;
        Object r26 = r116.next();
        if (Intrinsics.areEqual(((ObricWakeupSoundOption) r26).getId(), r7) == false) goto L42;
    L47:
        r11 = (ObricWakeupSoundOption) r26;
        goto L48
    L46:
        r26 = null;
        goto L47
    L37:
        r25 = null;
        goto L38
    L20:
        r9 = null;
    L7:
        r0 = new WakeupSoundPlayer$playWakeupSound$1(this, r12);
        goto L8
    }

    public static void a(int r6, String r7, String r8) {
        SoundEffectHelper r0 = SoundEffectHelper.INSTANCE;
        if (r0.playWakeupRaw(r6) == true) goto L5;
        FLogger.a.w("WakeupSoundPlayer", "playResolvedWakeupRaw failed, fallback playActivate, id=" + r7 + ", audio=" + r8);
        r0.playActivate();
    L5:
        FLogger.a.i("WakeupSoundPlayer", "playResolvedWakeupRaw, id=" + r7 + ", audio=" + r8 + ", rawResId=" + r6);
    }
}
