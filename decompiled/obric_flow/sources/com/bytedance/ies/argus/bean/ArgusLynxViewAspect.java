package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusLynxViewAspect;", "", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ArgusLynxViewAspect extends Enum<ArgusLynxViewAspect> implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArgusLynxViewAspect f5072b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArgusLynxViewAspect f5073c = null;
    public static final /* synthetic */ ArgusLynxViewAspect[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5074a;

    static {
        ArgusLynxViewAspect r5 = new ArgusLynxViewAspect("ABOUT_TO_LOAD_TEMPLATE", 0, "about_to_load_template");
        ArgusLynxViewAspect r10 = new ArgusLynxViewAspect("LOAD_TEMPLATE", 1, "load_template");
        f5072b = r10;
        ArgusLynxViewAspect r11 = new ArgusLynxViewAspect("EXIT", 2, "exit");
        ArgusLynxViewAspect r12 = new ArgusLynxViewAspect("ABOUT_TO_REQUEST_LYNX_SSR_URL", 3, "about_to_request_lynx_ssr_url");
        f5073c = r12;
        d = new ArgusLynxViewAspect[]{r5, r10, r11, r12};
    }

    public ArgusLynxViewAspect(String r5, int r10, String r11) {
        super(r5, r10);
        this.f5074a = r11;
    }

    public static ArgusLynxViewAspect valueOf(String r5) {
        return (ArgusLynxViewAspect) Enum.valueOf(ArgusLynxViewAspect.class, r5);
    }

    public static ArgusLynxViewAspect[] values() {
        return (ArgusLynxViewAspect[]) d.clone();
    }

    @Override // com.bytedance.ies.argus.bean.c
    public final String a() {
        return this.f5074a;
    }
}
