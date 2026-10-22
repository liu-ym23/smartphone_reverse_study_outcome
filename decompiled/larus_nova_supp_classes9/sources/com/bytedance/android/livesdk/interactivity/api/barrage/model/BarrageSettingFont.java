package com.bytedance.android.livesdk.interactivity.api.barrage.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/BarrageSettingFont;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "font", "I", "getFont", "()I", "level", "getLevel", BuildConfig.FLAVOR, "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "Companion", "a", "LARGE", "BIG", "MID", "SMALL", "VS_PORTRAIT", "VS_PORTRAIT_SMALL", "VS_PORTRAIT_MID", "VS_PORTRAIT_BIG", "VS_PORTRAIT_LARGE", "PORTRAIT", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BarrageSettingFont extends Enum<BarrageSettingFont> {
    public static final BarrageSettingFont BIG = null;
    public static final a Companion = null;
    public static final BarrageSettingFont LARGE = null;
    public static final BarrageSettingFont MID = null;
    public static final BarrageSettingFont PORTRAIT = null;
    public static final BarrageSettingFont SMALL = null;
    public static final BarrageSettingFont VS_PORTRAIT = null;
    public static final BarrageSettingFont VS_PORTRAIT_BIG = null;
    public static final BarrageSettingFont VS_PORTRAIT_LARGE = null;
    public static final BarrageSettingFont VS_PORTRAIT_MID = null;
    public static final BarrageSettingFont VS_PORTRAIT_SMALL = null;
    public static final /* synthetic */ BarrageSettingFont[] a = null;
    private final String des;
    private final int font;
    private final int level;

    public static final class a {
        public a() {
        }
    }

    public static BarrageSettingFont valueOf(String r1) {
        return (BarrageSettingFont) r27.a.a(BarrageSettingFont.class, r1);
    }

    public static BarrageSettingFont[] values() {
        return (BarrageSettingFont[]) a.clone();
    }

    static {
        BarrageSettingFont r7 = new BarrageSettingFont("LARGE", 0, -1, 3, "超大");
        LARGE = r7;
        BarrageSettingFont r1 = new BarrageSettingFont("BIG", 1, 0, 2, "大");
        BIG = r1;
        BarrageSettingFont r2 = new BarrageSettingFont("MID", 2, 1, 1, "适中");
        MID = r2;
        BarrageSettingFont r3 = new BarrageSettingFont("SMALL", 3, 2, 0, "小");
        SMALL = r3;
        BarrageSettingFont r4 = new BarrageSettingFont("VS_PORTRAIT", 4, 3, 0, "竖屏横流默认");
        VS_PORTRAIT = r4;
        BarrageSettingFont r5 = new BarrageSettingFont("VS_PORTRAIT_SMALL", 5, 4, 0, "小");
        VS_PORTRAIT_SMALL = r5;
        BarrageSettingFont r6 = new BarrageSettingFont("VS_PORTRAIT_MID", 6, 5, 1, "适中");
        VS_PORTRAIT_MID = r6;
        BarrageSettingFont r8 = new BarrageSettingFont("VS_PORTRAIT_BIG", 7, 6, 2, "大");
        VS_PORTRAIT_BIG = r8;
        BarrageSettingFont r9 = new BarrageSettingFont("VS_PORTRAIT_LARGE", 8, 7, 3, "超大");
        VS_PORTRAIT_LARGE = r9;
        BarrageSettingFont r10 = new BarrageSettingFont("PORTRAIT", 9, 8, 0, BuildConfig.FLAVOR);
        PORTRAIT = r10;
        a = new BarrageSettingFont[]{r7, r1, r2, r3, r4, r5, r6, r8, r9, r10};
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

    public BarrageSettingFont(String r1, int r2, int r3, int r4, String r5) {
        super(r1, r2);
        this.font = r3;
        this.level = r4;
        this.des = r5;
    }
}
