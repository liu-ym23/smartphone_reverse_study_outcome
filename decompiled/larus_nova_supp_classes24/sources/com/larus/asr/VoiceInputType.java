package com.larus.asr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/asr/VoiceInputType;", "", "<init>", "(Ljava/lang/String;I)V", "TouchSpeaker", "ClickSpeaker", "ThirdPartySpeaker", "DoraVoiceSpeaker", "DoraRadioSpeaker", "ObricContinuousTalk", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum VoiceInputType extends Enum<VoiceInputType> {
    public static final VoiceInputType ClickSpeaker = null;
    public static final a Companion = null;
    public static final VoiceInputType DoraRadioSpeaker = null;
    public static final VoiceInputType DoraVoiceSpeaker = null;
    public static final VoiceInputType ObricContinuousTalk = null;
    public static final VoiceInputType ThirdPartySpeaker = null;
    public static final VoiceInputType TouchSpeaker = null;
    public static final /* synthetic */ VoiceInputType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static final class a {
        public a() {
        }

        public static boolean a(VoiceInputType r1) {
            Intrinsics.checkNotNullParameter(r1, "voiceInputType");
            if (r1 != VoiceInputType.ClickSpeaker) goto L5;
        L10:
            return true;
        L5:
            if (r1 == VoiceInputType.ThirdPartySpeaker) goto L10;
            if (r1 == VoiceInputType.DoraVoiceSpeaker) goto L10;
            return false;
        }

        public static boolean b(VoiceInputType r1) {
            if (r1 != VoiceInputType.TouchSpeaker) goto L5;
        L8:
            return true;
        L5:
            if (r1 == VoiceInputType.DoraRadioSpeaker) goto L8;
            return false;
        }
    }

    public static EnumEntries<VoiceInputType> getEntries() {
        return b;
    }

    static {
        VoiceInputType r0 = new VoiceInputType("TouchSpeaker", 0);
        TouchSpeaker = r0;
        VoiceInputType r1 = new VoiceInputType("ClickSpeaker", 1);
        ClickSpeaker = r1;
        VoiceInputType r3 = new VoiceInputType("ThirdPartySpeaker", 2);
        ThirdPartySpeaker = r3;
        VoiceInputType r5 = new VoiceInputType("DoraVoiceSpeaker", 3);
        DoraVoiceSpeaker = r5;
        VoiceInputType r7 = new VoiceInputType("DoraRadioSpeaker", 4);
        DoraRadioSpeaker = r7;
        VoiceInputType r9 = new VoiceInputType("ObricContinuousTalk", 5);
        ObricContinuousTalk = r9;
        VoiceInputType[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public static VoiceInputType[] values() {
        return (VoiceInputType[]) a.clone();
    }

    public static VoiceInputType valueOf(String r1) {
        return (VoiceInputType) r27.a.a(VoiceInputType.class, r1);
    }

    public VoiceInputType(String r1, int r2) {
        super(r1, r2);
    }
}
