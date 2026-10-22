package com.obric.oui.segmentedtab;

import android.content.Context;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/segmentedtab/OSegmentTabView;", "Lcom/obric/oui/segmentedtab/OTouchAnimView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "originIconAlpha", "", "setOriginIconAlpha", "(I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSegmentTabView extends OTouchAnimView {
    public static int g;
    public final String e;
    public int f;

    @JvmOverloads
    public OSegmentTabView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public final boolean a() {
        return true;
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public final void b(float r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        ps.a.a(this.e, "onTouchAnimUpdate, scene: " + r10 + ", animFraction: " + r5);
        if (Intrinsics.areEqual(r10, "press_anim") == true) goto L6;
        Intrinsics.areEqual(r10, "release_anim");
    L6:
        RangesKt.coerceIn((int) ((1 - (r5 * 0.5f)) * this.f), 0, 255);
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        throw null;
    }

    public final void setOriginIconAlpha(int r5) {
        this.f = r5;
    }

    @JvmOverloads
    public OSegmentTabView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OSegmentTabView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OSegmentTabView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        int r12 = g;
        g = r12 + 1;
        this.e = Intrinsics.stringPlus("OSegmentTabView_", Integer.valueOf(r12));
    }
}
