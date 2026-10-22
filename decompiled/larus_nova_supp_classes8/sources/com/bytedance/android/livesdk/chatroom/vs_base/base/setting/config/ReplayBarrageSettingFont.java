package com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/setting/config/ReplayBarrageSettingFont;", "", "", "font", "I", "getFont", "()I", "level", "getLevel", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "Companion", "a", "LARGE", "BIG", "MID", "SMALL", "VS_PORTRAIT", "VS_PORTRAIT_SMALL", "VS_PORTRAIT_MID", "VS_PORTRAIT_BIG", "VS_PORTRAIT_LARGE", "PORTRAIT", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReplayBarrageSettingFont extends Enum<ReplayBarrageSettingFont> {
    public static final ReplayBarrageSettingFont BIG = null;
    public static final a Companion = null;
    public static final ReplayBarrageSettingFont LARGE = null;
    public static final ReplayBarrageSettingFont MID = null;
    public static final ReplayBarrageSettingFont PORTRAIT = null;
    public static final ReplayBarrageSettingFont SMALL = null;
    public static final ReplayBarrageSettingFont VS_PORTRAIT = null;
    public static final ReplayBarrageSettingFont VS_PORTRAIT_BIG = null;
    public static final ReplayBarrageSettingFont VS_PORTRAIT_LARGE = null;
    public static final ReplayBarrageSettingFont VS_PORTRAIT_MID = null;
    public static final ReplayBarrageSettingFont VS_PORTRAIT_SMALL = null;
    public static final /* synthetic */ ReplayBarrageSettingFont[] a = null;
    private final String des;
    private final int font;
    private final int level;

    public static final class a {
        public a() {
        }
    }

    public static ReplayBarrageSettingFont valueOf(String r1) {
        return (ReplayBarrageSettingFont) r27.a.a(ReplayBarrageSettingFont.class, r1);
    }

    public static ReplayBarrageSettingFont[] values() {
        return (ReplayBarrageSettingFont[]) a.clone();
    }

    static {
        ReplayBarrageSettingFont r7 = new ReplayBarrageSettingFont("LARGE", 0, -1, 3, "超大");
        LARGE = r7;
        ReplayBarrageSettingFont r1 = new ReplayBarrageSettingFont("BIG", 1, 0, 2, "大");
        BIG = r1;
        ReplayBarrageSettingFont r2 = new ReplayBarrageSettingFont("MID", 2, 1, 1, "适中");
        MID = r2;
        ReplayBarrageSettingFont r3 = new ReplayBarrageSettingFont("SMALL", 3, 2, 0, "小");
        SMALL = r3;
        ReplayBarrageSettingFont r4 = new ReplayBarrageSettingFont("VS_PORTRAIT", 4, 3, 0, "竖屏横流默认");
        VS_PORTRAIT = r4;
        ReplayBarrageSettingFont r5 = new ReplayBarrageSettingFont("VS_PORTRAIT_SMALL", 5, 4, 0, "小");
        VS_PORTRAIT_SMALL = r5;
        ReplayBarrageSettingFont r6 = new ReplayBarrageSettingFont("VS_PORTRAIT_MID", 6, 5, 1, "适中");
        VS_PORTRAIT_MID = r6;
        ReplayBarrageSettingFont r8 = new ReplayBarrageSettingFont("VS_PORTRAIT_BIG", 7, 6, 2, "大");
        VS_PORTRAIT_BIG = r8;
        ReplayBarrageSettingFont r9 = new ReplayBarrageSettingFont("VS_PORTRAIT_LARGE", 8, 7, 3, "超大");
        VS_PORTRAIT_LARGE = r9;
        ReplayBarrageSettingFont r10 = new ReplayBarrageSettingFont("PORTRAIT", 9, 8, 0, "");
        PORTRAIT = r10;
        a = new ReplayBarrageSettingFont[]{r7, r1, r2, r3, r4, r5, r6, r8, r9, r10};
        Companion = new a();
    }

    public final String getDes() {
        return this.des;
    }

    public final int getFont() {
        return this.font;
    }

    public final int getLevel() {
        return this.level;
    }

    public ReplayBarrageSettingFont(String r1, int r2, int r3, int r4, String r5) {
        super(r1, r2);
        this.font = r3;
        this.level = r4;
        this.des = r5;
    }
}
