package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.event.MessageIndication;
import kotlin.Metadata;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/InputMode;", "", "com/bytedance/ai/bridge/method/floatinginput/e", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum InputMode extends Enum<InputMode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f1817a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final InputMode f1818b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final InputMode f1819c = null;
    public static final /* synthetic */ InputMode[] d = null;

    static {
        InputMode r5 = new InputMode("TEXT", 0, MessageIndication.CONTENT_TYPE_TEXT);
        f1818b = r5;
        InputMode r10 = new InputMode("ASR", 1, "asr");
        f1819c = r10;
        InputMode[] r11 = {r5, r10};
        d = r11;
        EnumEntriesKt.enumEntries(r11);
        f1817a = new e();
    }

    public InputMode(String r5, int r10, String r11) {
        super(r5, r10);
    }

    public static InputMode valueOf(String r5) {
        return (InputMode) Enum.valueOf(InputMode.class, r5);
    }

    public static InputMode[] values() {
        return (InputMode[]) d.clone();
    }
}
