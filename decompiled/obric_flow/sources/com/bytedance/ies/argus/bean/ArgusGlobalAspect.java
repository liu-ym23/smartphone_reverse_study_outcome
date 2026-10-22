package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusGlobalAspect;", "", "Lcom/bytedance/ies/argus/bean/c;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ArgusGlobalAspect extends Enum<ArgusGlobalAspect> implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArgusGlobalAspect f5036b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArgusGlobalAspect f5037c = null;
    public static final ArgusGlobalAspect d = null;
    public static final /* synthetic */ ArgusGlobalAspect[] e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5038a;

    static {
        ArgusGlobalAspect r5 = new ArgusGlobalAspect("ABOUT_TO_PREFETCH", 0, "about_to_prefetch");
        f5036b = r5;
        ArgusGlobalAspect r10 = new ArgusGlobalAspect("LOAD_STATIC_RESOURCE", 1, "load_static_resource");
        f5037c = r10;
        ArgusGlobalAspect r11 = new ArgusGlobalAspect("MOTION_ON_TOUCH", 2, "motion_on_touch");
        d = r11;
        e = new ArgusGlobalAspect[]{r5, r10, r11, new ArgusGlobalAspect("ABOUT_TO_UPLOAD_FILE", 3, "about_to_upload_file")};
    }

    public ArgusGlobalAspect(String r5, int r10, String r11) {
        super(r5, r10);
        this.f5038a = r11;
    }

    public static ArgusGlobalAspect valueOf(String r5) {
        return (ArgusGlobalAspect) Enum.valueOf(ArgusGlobalAspect.class, r5);
    }

    public static ArgusGlobalAspect[] values() {
        return (ArgusGlobalAspect[]) e.clone();
    }

    @Override // com.bytedance.ies.argus.bean.c
    public final String a() {
        return this.f5038a;
    }
}
