package com.ss.android.lark.chameleon.api;

import com.ss.android.lark.chat.constant.ChatFromType;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chameleon/api/ChameleonBizType;", BuildConfig.FLAVOR, IPortraitService.TYPE, BuildConfig.FLAVOR, "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "BIZ_DOCS", "BIZ_SLIDES", "BIZ_SPACE", "BIZ_WORKSPACE", "BIZ_AI_PERMISSION", "BIZ_PROFILE", "BIZ_PROFILE_SUBPAGE", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum ChameleonBizType extends Enum<ChameleonBizType> {
    private static final /* synthetic */ ChameleonBizType[] $VALUES = null;
    public static final ChameleonBizType BIZ_AI_PERMISSION = null;
    public static final ChameleonBizType BIZ_DOCS = null;
    public static final ChameleonBizType BIZ_PROFILE = null;
    public static final ChameleonBizType BIZ_PROFILE_SUBPAGE = null;
    public static final ChameleonBizType BIZ_SLIDES = null;
    public static final ChameleonBizType BIZ_SPACE = null;
    public static final ChameleonBizType BIZ_WORKSPACE = null;
    private final String type;

    private static final /* synthetic */ ChameleonBizType[] $values() {
        return new ChameleonBizType[]{BIZ_DOCS, BIZ_SLIDES, BIZ_SPACE, BIZ_WORKSPACE, BIZ_AI_PERMISSION, BIZ_PROFILE, BIZ_PROFILE_SUBPAGE};
    }

    public static ChameleonBizType valueOf(String r1) {
        return (ChameleonBizType) a.a(ChameleonBizType.class, r1);
    }

    public static ChameleonBizType[] values() {
        return (ChameleonBizType[]) $VALUES.clone();
    }

    static {
        BIZ_DOCS = new ChameleonBizType("BIZ_DOCS", 0, "docs");
        BIZ_SLIDES = new ChameleonBizType("BIZ_SLIDES", 1, "slides");
        BIZ_SPACE = new ChameleonBizType("BIZ_SPACE", 2, "space");
        BIZ_WORKSPACE = new ChameleonBizType("BIZ_WORKSPACE", 3, "workspace");
        BIZ_AI_PERMISSION = new ChameleonBizType("BIZ_AI_PERMISSION", 4, "aipermission");
        BIZ_PROFILE = new ChameleonBizType("BIZ_PROFILE", 5, ChatFromType.PROFILE);
        BIZ_PROFILE_SUBPAGE = new ChameleonBizType("BIZ_PROFILE_SUBPAGE", 6, "profile_subpage");
        $VALUES = $values();
    }

    public final String getType() {
        return this.type;
    }

    private ChameleonBizType(String r1, int r2, String r3) {
        super(r1, r2);
        this.type = r3;
    }
}
