package com.bytedance.ai.applet.render.core.relax;

import com.relax.uirender.UIRenderRegistry;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ai/applet/render/core/relax/RelaxRenderView$RenderMode", "", "Lcom/bytedance/ai/applet/render/core/relax/RelaxRenderView$RenderMode;", "applet-render-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum RelaxRenderView$RenderMode extends Enum<RelaxRenderView$RenderMode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RelaxRenderView$RenderMode f1783b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ RelaxRenderView$RenderMode[] f1784c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1785a;

    static {
        RelaxRenderView$RenderMode r5 = new RelaxRenderView$RenderMode("CLAY", 0, "CLAY");
        f1783b = r5;
        RelaxRenderView$RenderMode[] r10 = {r5, new RelaxRenderView$RenderMode("LYNX_UI", 1, "LYNX_UI")};
        f1784c = r10;
        EnumEntriesKt.enumEntries(r10);
    }

    public RelaxRenderView$RenderMode(String r5, int r10, String r11) {
        super(r5, r10);
        this.f1785a = r11;
    }

    public static RelaxRenderView$RenderMode valueOf(String r5) {
        return (RelaxRenderView$RenderMode) Enum.valueOf(RelaxRenderView$RenderMode.class, r5);
    }

    public static RelaxRenderView$RenderMode[] values() {
        return (RelaxRenderView$RenderMode[]) f1784c.clone();
    }

    public final UIRenderRegistry.RenderType a() {
        int r5 = ordinal();
        if (r5 == 0) goto L11;
        if (r5 != 1) goto L9;
        return UIRenderRegistry.RenderType.LYNX_UI;
    L9:
        throw new NoWhenBranchMatchedException();
    L11:
        return UIRenderRegistry.RenderType.CLAY;
    }
}
