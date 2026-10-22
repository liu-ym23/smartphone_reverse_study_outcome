package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/UILayout;", BuildConfig.FLAVOR, "Normal", "Enlarge", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum UILayout extends Enum<UILayout> {
    public static final UILayout Enlarge = null;
    public static final UILayout Normal = null;
    public static final /* synthetic */ UILayout[] a = null;

    static {
        UILayout r1 = new UILayout("Normal", 0);
        Normal = r1;
        UILayout r2 = new UILayout("Enlarge", 1);
        Enlarge = r2;
        a = new UILayout[]{r1, r2};
    }

    public static UILayout valueOf(String r1) {
        return (UILayout) r27.a.a(UILayout.class, r1);
    }

    public static UILayout[] values() {
        return (UILayout[]) a.clone();
    }

    public UILayout(String r1, int r2) {
        super(r1, r2);
    }
}
