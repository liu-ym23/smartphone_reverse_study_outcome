package com.bytedance.ies.bullet.base.core.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/base/core/common/Components;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum Components extends Enum<Components> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Components f5183b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Components f5184c = null;
    public static final Components d = null;
    public static final Components e = null;
    public static final /* synthetic */ Components[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5185a;

    static {
        Components r5 = new Components("Activity", 0, "activity");
        f5183b = r5;
        Components r10 = new Components("Fragment", 1, "fragment");
        f5184c = r10;
        Components r11 = new Components("DialogFragment", 2, "dialogFragment");
        d = r11;
        Components r12 = new Components("View", 3, "view");
        e = r12;
        f = new Components[]{r5, r10, r11, r12};
    }

    public Components(String r5, int r10, String r11) {
        super(r5, r10);
        this.f5185a = r11;
    }

    public static Components valueOf(String r5) {
        return (Components) Enum.valueOf(Components.class, r5);
    }

    public static Components[] values() {
        return (Components[]) f.clone();
    }
}
