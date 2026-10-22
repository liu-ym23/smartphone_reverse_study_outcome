package com.bytedance.ai.bridge.method.floatinginput;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/InputMode;", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TEXT", "ASR", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InputMode extends Enum<InputMode> {
    public static final InputMode ASR = null;
    public static final a Companion = null;
    public static final InputMode TEXT = null;
    public static final /* synthetic */ InputMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static final class a {
        public a() {
        }

        public static InputMode a(String r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
            InputMode r0 = InputMode.TEXT;
            if (Intrinsics.areEqual(r10, r0.getValue()) == true) goto L7;
            r0 = InputMode.ASR;
            if (Intrinsics.areEqual(r10, r0.getValue()) == true) goto L7;
            throw new IllegalArgumentException("No enum constant " + r10);
        L7:
            return r0;
        }
    }

    public static EnumEntries<InputMode> getEntries() {
        return b;
    }

    static {
        InputMode r0 = new InputMode("TEXT", 0, "text");
        TEXT = r0;
        InputMode r1 = new InputMode("ASR", 1, "asr");
        ASR = r1;
        InputMode[] r10 = {r0, r1};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
        Companion = new a();
    }

    public static InputMode[] values() {
        return (InputMode[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static InputMode valueOf(String r1) {
        return (InputMode) r27.a.a(InputMode.class, r1);
    }

    public InputMode(String r1, int r10, String r11) {
        super(r1, r10);
        this.value = r11;
    }
}
