package com.bytedance.ies.bullet.interaction.predefine.security;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ies/bullet/interaction/predefine/security/PredefineFileValidate$TypeEnum", "", "Lcom/bytedance/ies/bullet/interaction/predefine/security/PredefineFileValidate$TypeEnum;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum PredefineFileValidate$TypeEnum extends Enum<PredefineFileValidate$TypeEnum> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PredefineFileValidate$TypeEnum f5426a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PredefineFileValidate$TypeEnum f5427b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PredefineFileValidate$TypeEnum f5428c = null;
    public static final /* synthetic */ PredefineFileValidate$TypeEnum[] d = null;

    static {
        PredefineFileValidate$TypeEnum r5 = new PredefineFileValidate$TypeEnum("MD5", 0);
        f5426a = r5;
        PredefineFileValidate$TypeEnum r10 = new PredefineFileValidate$TypeEnum("SHA256", 1);
        f5427b = r10;
        PredefineFileValidate$TypeEnum r11 = new PredefineFileValidate$TypeEnum("SIZE_SHA256", 2);
        f5428c = r11;
        d = new PredefineFileValidate$TypeEnum[]{r5, r10, r11};
    }

    public PredefineFileValidate$TypeEnum(String r5, int r10) {
        super(r5, r10);
    }

    public static PredefineFileValidate$TypeEnum valueOf(String r5) {
        return (PredefineFileValidate$TypeEnum) Enum.valueOf(PredefineFileValidate$TypeEnum.class, r5);
    }

    public static PredefineFileValidate$TypeEnum[] values() {
        return (PredefineFileValidate$TypeEnum[]) d.clone();
    }
}
