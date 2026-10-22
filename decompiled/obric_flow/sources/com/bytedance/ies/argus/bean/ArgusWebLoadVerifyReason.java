package com.bytedance.ies.argus.bean;

import androidx.core.view.PointerIconCompat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusWebLoadVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/d;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ArgusWebLoadVerifyReason extends Enum<ArgusWebLoadVerifyReason> implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArgusWebLoadVerifyReason f5095c = null;
    public static final ArgusWebLoadVerifyReason d = null;
    public static final ArgusWebLoadVerifyReason e = null;
    public static final ArgusWebLoadVerifyReason f = null;
    public static final ArgusWebLoadVerifyReason g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ArgusWebLoadVerifyReason f5096h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ArgusWebLoadVerifyReason f5097i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ ArgusWebLoadVerifyReason[] f5098j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5100b;

    static {
        ArgusWebLoadVerifyReason r5 = new ArgusWebLoadVerifyReason("BLACK_PROTOCOL", 0, -1, "hit black protocol");
        f5095c = r5;
        ArgusWebLoadVerifyReason r10 = new ArgusWebLoadVerifyReason("BLACK_URL_REG", 1, -2, "hit black url reg");
        d = r10;
        ArgusWebLoadVerifyReason r11 = new ArgusWebLoadVerifyReason("HIT_SEC_LINK_SCENE", 2, -5, "container context's secLinkScene is");
        e = r11;
        ArgusWebLoadVerifyReason r12 = new ArgusWebLoadVerifyReason("FORCE_TO_HTTPS", 3, -6, "domain in share cookie list and use http is forbidden");
        f = r12;
        ArgusWebLoadVerifyReason r13 = new ArgusWebLoadVerifyReason("WHITE_URL", 4, 1, "hit white url");
        g = r13;
        ArgusWebLoadVerifyReason r14 = new ArgusWebLoadVerifyReason("ALREADY_SEC_LINK_PAGE", 5, 2, "already secLink page");
        f5096h = r14;
        ArgusWebLoadVerifyReason r15 = new ArgusWebLoadVerifyReason("REWRITE_BY_SEC_LINK", 6, 3, "rewrite by secLink");
        ArgusWebLoadVerifyReason r16 = new ArgusWebLoadVerifyReason("PASS_BY_SEC_LINK_SERVER", 7, 4, "pass by secLink server");
        ArgusWebLoadVerifyReason r17 = new ArgusWebLoadVerifyReason("HAS_TRIGGER_CHECK", 8, 5, "has triggered checked");
        ArgusWebLoadVerifyReason r18 = new ArgusWebLoadVerifyReason("REDIRECT_LAST_URL_IS_SEC_LINK_PAGE", 9, 6, "redirect last url is secLink page");
        ArgusWebLoadVerifyReason r19 = new ArgusWebLoadVerifyReason("RELOAD_SEC_URL", 10, 7, "reload sec url");
        ArgusWebLoadVerifyReason r110 = new ArgusWebLoadVerifyReason("REDIRECT_REWRITE_URL", 11, 8, "redirect rewrite url, will trigger reload");
        ArgusWebLoadVerifyReason r111 = new ArgusWebLoadVerifyReason("NO_SEC_LINK_SCENE", 12, 9, "no secLink scene");
        f5097i = r111;
        f5098j = new ArgusWebLoadVerifyReason[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, new ArgusWebLoadVerifyReason("SEC_LINK_HANDLER_IS_NULL", 13, 1001, "secLinkHandler is null"), new ArgusWebLoadVerifyReason("SEC_LINK_VERIFY_MODE_NOT_ENABLE", 14, PointerIconCompat.TYPE_HAND, "secLinkVerifyMode not enable")};
    }

    public ArgusWebLoadVerifyReason(String r5, int r10, int r11, String r12) {
        super(r5, r10);
        this.f5099a = r11;
        this.f5100b = r12;
    }

    public static ArgusWebLoadVerifyReason valueOf(String r5) {
        return (ArgusWebLoadVerifyReason) Enum.valueOf(ArgusWebLoadVerifyReason.class, r5);
    }

    public static ArgusWebLoadVerifyReason[] values() {
        return (ArgusWebLoadVerifyReason[]) f5098j.clone();
    }

    @Override // com.bytedance.ies.argus.bean.d
    public final String a() {
        return this.f5100b;
    }

    @Override // com.bytedance.ies.argus.bean.d
    public final int getCode() {
        return this.f5099a;
    }
}
