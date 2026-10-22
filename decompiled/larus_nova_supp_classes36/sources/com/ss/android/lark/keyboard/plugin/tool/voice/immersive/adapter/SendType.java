package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/SendType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "OnlyText", "VoiceWithAsr", "value", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum SendType extends Enum<SendType> {
    public static final SendType OnlyText = null;
    public static final SendType VoiceWithAsr = null;
    public static final /* synthetic */ SendType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<SendType> getEntries() {
        return b;
    }

    static {
        SendType r0 = new SendType("OnlyText", 0, 0);
        OnlyText = r0;
        SendType r1 = new SendType("VoiceWithAsr", 1, 1);
        VoiceWithAsr = r1;
        SendType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static SendType[] values() {
        return (SendType[]) a.clone();
    }

    public final int value() {
        return this.type;
    }

    public static SendType valueOf(String r1) {
        return (SendType) a.a(SendType.class, r1);
    }

    public SendType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
