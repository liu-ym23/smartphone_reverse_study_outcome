package com.larus.asr.config;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/asr/config/ChatSpeakerStyle;", "", "<init>", "(Ljava/lang/String;I)V", "Normal", "Speech", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ChatSpeakerStyle extends Enum<ChatSpeakerStyle> {
    public static final ChatSpeakerStyle Normal = null;
    public static final ChatSpeakerStyle Speech = null;
    public static final /* synthetic */ ChatSpeakerStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ChatSpeakerStyle> getEntries() {
        return b;
    }

    static {
        ChatSpeakerStyle r0 = new ChatSpeakerStyle("Normal", 0);
        Normal = r0;
        ChatSpeakerStyle r1 = new ChatSpeakerStyle("Speech", 1);
        Speech = r1;
        ChatSpeakerStyle[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ChatSpeakerStyle[] values() {
        return (ChatSpeakerStyle[]) a.clone();
    }

    public static ChatSpeakerStyle valueOf(String r1) {
        return (ChatSpeakerStyle) a.a(ChatSpeakerStyle.class, r1);
    }

    public ChatSpeakerStyle(String r1, int r2) {
        super(r1, r2);
    }
}
