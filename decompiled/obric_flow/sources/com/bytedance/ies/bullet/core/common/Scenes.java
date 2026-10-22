package com.bytedance.ies.bullet.core.common;

import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "use Components instead")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/core/common/Scenes;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum Scenes extends Enum<Scenes> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Scenes f5282b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Scenes f5283c = null;
    public static final Scenes d = null;
    public static final Scenes e = null;
    public static final Scenes f = null;
    public static final Scenes g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Scenes f5284h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ Scenes[] f5285i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5286a;

    static {
        Scenes r5 = new Scenes("AbsActivity", 0, "page");
        f5282b = r5;
        Scenes r10 = new Scenes("PopupFragment", 1, OpenPageMethod.APP_POPUP);
        f5283c = r10;
        Scenes r11 = new Scenes("ContainerFragment", 2, "fragment");
        d = r11;
        Scenes r12 = new Scenes("Container", 3, "card");
        e = r12;
        Scenes r13 = new Scenes("Card", 4, "card");
        f = r13;
        Scenes r14 = new Scenes("LitePage", 5, "lite_page");
        g = r14;
        Scenes r15 = new Scenes("AnnieXPage", 6, "annie_x_page");
        f5284h = r15;
        f5285i = new Scenes[]{r5, r10, r11, r12, r13, r14, r15};
    }

    public Scenes(String r5, int r10, String r11) {
        super(r5, r10);
        this.f5286a = r11;
    }

    public static Scenes valueOf(String r5) {
        return (Scenes) Enum.valueOf(Scenes.class, r5);
    }

    public static Scenes[] values() {
        return (Scenes[]) f5285i.clone();
    }
}
