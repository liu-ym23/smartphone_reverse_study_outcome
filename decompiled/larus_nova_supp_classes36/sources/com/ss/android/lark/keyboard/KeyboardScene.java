package com.ss.android.lark.keyboard;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/keyboard/KeyboardScene;", "", "<init>", "(Ljava/lang/String;I)V", "ChatMain", "ThreadMain", "UNKNOWN", "Moments", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum KeyboardScene extends Enum<KeyboardScene> {
    public static final KeyboardScene ChatMain = null;
    public static final KeyboardScene Moments = null;
    public static final KeyboardScene ThreadMain = null;
    public static final KeyboardScene UNKNOWN = null;
    public static final /* synthetic */ KeyboardScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<KeyboardScene> getEntries() {
        return b;
    }

    static {
        KeyboardScene r0 = new KeyboardScene("ChatMain", 0);
        ChatMain = r0;
        KeyboardScene r1 = new KeyboardScene("ThreadMain", 1);
        ThreadMain = r1;
        KeyboardScene r3 = new KeyboardScene("UNKNOWN", 2);
        UNKNOWN = r3;
        KeyboardScene r5 = new KeyboardScene("Moments", 3);
        Moments = r5;
        KeyboardScene[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static KeyboardScene[] values() {
        return (KeyboardScene[]) a.clone();
    }

    public static KeyboardScene valueOf(String r1) {
        return (KeyboardScene) r27.a.a(KeyboardScene.class, r1);
    }

    public KeyboardScene(String r1, int r2) {
        super(r1, r2);
    }
}
