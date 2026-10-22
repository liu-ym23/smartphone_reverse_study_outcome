package com.bytedance.android.anniex.monitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/anniex/monitor/AnnieXCardScene;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum AnnieXCardScene extends Enum<AnnieXCardScene> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AnnieXCardScene f3258b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AnnieXCardScene f3259c = null;
    public static final AnnieXCardScene d = null;
    public static final AnnieXCardScene e = null;
    public static final AnnieXCardScene f = null;
    public static final AnnieXCardScene g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AnnieXCardScene[] f3260h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3261a;

    static {
        AnnieXCardScene r5 = new AnnieXCardScene("NEW", 0, "new");
        f3258b = r5;
        AnnieXCardScene r10 = new AnnieXCardScene("RELOAD", 1, "reload");
        f3259c = r10;
        AnnieXCardScene r11 = new AnnieXCardScene("REUSE", 2, "reuse");
        d = r11;
        AnnieXCardScene r12 = new AnnieXCardScene("RESET_DATA", 3, "resetData");
        e = r12;
        AnnieXCardScene r13 = new AnnieXCardScene("UPDATE_DATA", 4, "updateData");
        f = r13;
        AnnieXCardScene r14 = new AnnieXCardScene("SSR", 5, "ssr");
        g = r14;
        f3260h = new AnnieXCardScene[]{r5, r10, r11, r12, r13, r14};
    }

    public AnnieXCardScene(String r5, int r10, String r11) {
        super(r5, r10);
        this.f3261a = r11;
    }

    public static AnnieXCardScene valueOf(String r5) {
        return (AnnieXCardScene) Enum.valueOf(AnnieXCardScene.class, r5);
    }

    public static AnnieXCardScene[] values() {
        return (AnnieXCardScene[]) f3260h.clone();
    }
}
