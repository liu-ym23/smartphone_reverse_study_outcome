package com.obric.oui.tab;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import r9.c;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "使用 optimize 包下的 OBottomTabBar，优化约 5-8ms 左右")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/oui/tab/OBottomTabBar;", "Lcom/obric/oui/tab/OTabLayoutBase;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomTabBar extends OTabLayoutBase {
    static {
        new c();
    }

    @JvmOverloads
    public OBottomTabBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
    }

    @JvmOverloads
    public OBottomTabBar(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        setTabMode(1);
        setBackground(AppCompatResources.getDrawable(r5, R$color.oui_bg_base_2_1_low_elevation));
        int r11 = (int) getResources().getDimension(R$dimen.oui_p_container_2);
        int r12 = (int) getResources().getDimension(R$dimen.oui_p_container_2);
        this.f14665r.setPadding(r11, 0, r12, 0);
        setShowTopLine(Boolean.TRUE);
        setShowSelectedIndicator(Boolean.FALSE);
    }
}
