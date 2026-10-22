package com.bytedance.android.anniex.monitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/anniex/monitor/AnnieXCardScene;", "", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "NEW", "RELOAD", "REUSE", "RESET_DATA", "UPDATE_DATA", "SSR", "SL", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum AnnieXCardScene extends Enum<AnnieXCardScene> {
    public static final AnnieXCardScene NEW = null;
    public static final AnnieXCardScene RELOAD = null;
    public static final AnnieXCardScene RESET_DATA = null;
    public static final AnnieXCardScene REUSE = null;
    public static final AnnieXCardScene SL = null;
    public static final AnnieXCardScene SSR = null;
    public static final AnnieXCardScene UPDATE_DATA = null;
    public static final /* synthetic */ AnnieXCardScene[] a = null;
    private final String value;

    public static AnnieXCardScene valueOf(String r1) {
        return (AnnieXCardScene) r27.a.a(AnnieXCardScene.class, r1);
    }

    public static AnnieXCardScene[] values() {
        return (AnnieXCardScene[]) a.clone();
    }

    static {
        AnnieXCardScene r0 = new AnnieXCardScene("NEW", 0, "new");
        NEW = r0;
        AnnieXCardScene r1 = new AnnieXCardScene("RELOAD", 1, "reload");
        RELOAD = r1;
        AnnieXCardScene r10 = new AnnieXCardScene("REUSE", 2, "reuse");
        REUSE = r10;
        AnnieXCardScene r11 = new AnnieXCardScene("RESET_DATA", 3, "resetData");
        RESET_DATA = r11;
        AnnieXCardScene r12 = new AnnieXCardScene("UPDATE_DATA", 4, "updateData");
        UPDATE_DATA = r12;
        AnnieXCardScene r13 = new AnnieXCardScene("SSR", 5, "ssr");
        SSR = r13;
        AnnieXCardScene r14 = new AnnieXCardScene("SL", 6, "sl");
        SL = r14;
        a = new AnnieXCardScene[]{r0, r1, r10, r11, r12, r13, r14};
    }

    public final String getValue() {
        return this.value;
    }

    public AnnieXCardScene(String r1, int r10, String r11) {
        super(r1, r10);
        this.value = r11;
    }
}
