package com.larus.asr.config.builder;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/asr/config/builder/ChatSpeakerGesturePhase;", "", "<init>", "(Ljava/lang/String;I)V", "Move", "Release", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ChatSpeakerGesturePhase extends Enum<ChatSpeakerGesturePhase> {
    public static final ChatSpeakerGesturePhase Move = null;
    public static final ChatSpeakerGesturePhase Release = null;
    public static final /* synthetic */ ChatSpeakerGesturePhase[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ChatSpeakerGesturePhase> getEntries() {
        return b;
    }

    static {
        ChatSpeakerGesturePhase r0 = new ChatSpeakerGesturePhase("Move", 0);
        Move = r0;
        ChatSpeakerGesturePhase r1 = new ChatSpeakerGesturePhase("Release", 1);
        Release = r1;
        ChatSpeakerGesturePhase[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ChatSpeakerGesturePhase[] values() {
        return (ChatSpeakerGesturePhase[]) a.clone();
    }

    public static ChatSpeakerGesturePhase valueOf(String r1) {
        return (ChatSpeakerGesturePhase) a.a(ChatSpeakerGesturePhase.class, r1);
    }

    public ChatSpeakerGesturePhase(String r1, int r2) {
        super(r1, r2);
    }
}
