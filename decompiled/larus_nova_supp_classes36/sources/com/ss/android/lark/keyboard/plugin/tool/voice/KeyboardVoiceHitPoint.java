package com.ss.android.lark.keyboard.plugin.tool.voice;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.http.model.http.HttpHeaders;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class KeyboardVoiceHitPoint {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/KeyboardVoiceHitPoint$ClickNew;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SPEECH_TO_TEXT", "HOLD_TO_TALK", "HOLD_TO_TEXT", "CLOSE", "SEND", "ONLY_VOICE", "SEND_TEXT", "CANCEL", "CLICK_INPUT", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum ClickNew extends Enum<ClickNew> {
        public static final ClickNew CANCEL = null;
        public static final ClickNew CLICK_INPUT = null;
        public static final ClickNew CLOSE = null;
        public static final ClickNew HOLD_TO_TALK = null;
        public static final ClickNew HOLD_TO_TEXT = null;
        public static final ClickNew ONLY_VOICE = null;
        public static final ClickNew SEND = null;
        public static final ClickNew SEND_TEXT = null;
        public static final ClickNew SPEECH_TO_TEXT = null;
        public static final /* synthetic */ ClickNew[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<ClickNew> getEntries() {
            return b;
        }

        static {
            ClickNew r0 = new ClickNew("SPEECH_TO_TEXT", 0, "speech_to_text");
            SPEECH_TO_TEXT = r0;
            ClickNew r1 = new ClickNew("HOLD_TO_TALK", 1, "hold_to_talk");
            HOLD_TO_TALK = r1;
            ClickNew r2 = new ClickNew("HOLD_TO_TEXT", 2, "hold_to_text");
            HOLD_TO_TEXT = r2;
            ClickNew r4 = new ClickNew("CLOSE", 3, HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE);
            CLOSE = r4;
            ClickNew r6 = new ClickNew("SEND", 4, "send");
            SEND = r6;
            ClickNew r8 = new ClickNew("ONLY_VOICE", 5, "only_voice");
            ONLY_VOICE = r8;
            ClickNew r10 = new ClickNew("SEND_TEXT", 6, "send_text");
            SEND_TEXT = r10;
            ClickNew r12 = new ClickNew("CANCEL", 7, "cancel");
            CANCEL = r12;
            ClickNew r14 = new ClickNew("CLICK_INPUT", 8, "click_input");
            CLICK_INPUT = r14;
            ClickNew[] r13 = {r0, r1, r2, r4, r6, r8, r10, r12, r14};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static ClickNew[] values() {
            return (ClickNew[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static ClickNew valueOf(String r1) {
            return (ClickNew) r27.a.a(ClickNew.class, r1);
        }

        public ClickNew(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/KeyboardVoiceHitPoint$FromSource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CHAT", "VOICE", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum FromSource extends Enum<FromSource> {
        public static final FromSource CHAT = null;
        public static final FromSource VOICE = null;
        public static final /* synthetic */ FromSource[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<FromSource> getEntries() {
            return b;
        }

        static {
            FromSource r0 = new FromSource("CHAT", 0, "chat_menu");
            CHAT = r0;
            FromSource r1 = new FromSource("VOICE", 1, "voice_menu");
            VOICE = r1;
            FromSource[] r2 = {r0, r1};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
        }

        public static FromSource[] values() {
            return (FromSource[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static FromSource valueOf(String r1) {
            return (FromSource) r27.a.a(FromSource.class, r1);
        }

        public FromSource(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
    }
}
