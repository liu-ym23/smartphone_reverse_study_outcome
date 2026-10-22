package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusContainerAspect;", "", "Lcom/bytedance/ies/argus/bean/c;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ArgusContainerAspect extends Enum<ArgusContainerAspect> implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArgusContainerAspect f5030b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ ArgusContainerAspect[] f5031c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5032a;

    static {
        ArgusContainerAspect r5 = new ArgusContainerAspect("CONTAINER_CREATED", 0, "container_created");
        ArgusContainerAspect r10 = new ArgusContainerAspect("JSB_CALL", 1, "jsb_call");
        f5030b = r10;
        f5031c = new ArgusContainerAspect[]{r5, r10};
    }

    public ArgusContainerAspect(String r5, int r10, String r11) {
        super(r5, r10);
        this.f5032a = r11;
    }

    public static ArgusContainerAspect valueOf(String r5) {
        return (ArgusContainerAspect) Enum.valueOf(ArgusContainerAspect.class, r5);
    }

    public static ArgusContainerAspect[] values() {
        return (ArgusContainerAspect[]) f5031c.clone();
    }

    @Override // com.bytedance.ies.argus.bean.c
    public final String a() {
        return this.f5032a;
    }
}
