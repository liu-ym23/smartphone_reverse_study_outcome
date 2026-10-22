package com.obric.oui.segmentedtab;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import ea.b;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/segmentedtab/OSegmentTabView;", "Lcom/obric/oui/segmentedtab/OTouchAnimView;", "", "originIconAlpha", "", "setOriginIconAlpha", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OSegmentTabView extends OTouchAnimView {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static int f7308q;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f7309j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f7310k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f7311l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f7312m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TextView f7313n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ImageView f7314o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f7315p;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    @JvmOverloads
    public OSegmentTabView(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OSegmentTabView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OSegmentTabView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        StringBuilder r13 = new StringBuilder();
        r13.append("OSegmentTabView_");
        int r14 = f7308q;
        f7308q = r14 + 1;
        r13.append(r14);
        this.f7309j = r13.toString();
    }

    public /* synthetic */ OSegmentTabView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final void i(boolean r10) {
        if (r10 == true) goto L5;
        d();
        ImageView r11 = this.f7314o;
        if (r11 != null) goto L12;
    L11:
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L12:
        r11.setImageAlpha(this.f7312m);
        return;
    L5:
        if (e() == true) goto L14;
        r11 = this.f7314o;
        if (r11 != null) goto L12;
    }

    private final void j(float r10, String r11) {
        int r12 = RangesKt.coerceIn((int) (this.f7312m * OTouchAnimView.f7342i.a(r10)), 0, 255);
        ImageView r13 = this.f7314o;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L5:
        r13.setImageAlpha(r12);
        b.a(this.f7309j, "updateIconAlphaOnPress, scene: " + r11 + ", fraction: " + r10 + ", alpha: " + r12 + ", originIconAlpha: " + this.f7312m);
    }

    private final void l(boolean r10) {
        if (r10 == true) goto L5;
        d();
        TextView r11 = this.f7313n;
        if (r11 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
    L13:
        int r12 = this.f7311l;
    L14:
        r11.setTextColor(r12);
        return;
    L5:
        if (e() == true) goto L16;
        r11 = this.f7313n;
        if (r11 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
    L9:
        r12 = this.f7310k;
        goto L14
    }

    private final void m(float r10, String r11) {
        int r12 = r11.hashCode();
        if (r12 == (-1965932727)) goto L11;
        if (r12 == 1870923917) goto L8;
    L13:
        int r13 = 0;
    L14:
        if (r13 != 0) goto L16;
        return;
    L16:
        int r14 = (r13 >> 24) & 255;
        int r15 = RangesKt.coerceIn((int) (r14 * OTouchAnimView.f7342i.a(r10)), 0, 255);
        int r16 = (r13 & 255) | (((r15 << 24) | (((r13 >> 16) & 255) << 16)) | (((r13 >> 8) & 255) << 8));
        TextView r17 = this.f7313n;
        if (r17 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
    L19:
        r17.setTextColor(r16);
        b.a(this.f7309j, "updateTextColorOnPress, scene: " + r11 + ", fraction: " + r10 + ", newTextAlpha: " + r15 + ", originTextAlpha: " + r14);
        return;
    L8:
        if (r11.equals("press_anim") == false) goto L13;
        r13 = this.f7311l;
        goto L14
    L11:
        if (r11.equals("release_anim") == false) goto L13;
        r13 = this.f7310k;
        goto L14
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public boolean c() {
        return !this.f7315p;
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public void f(float r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "scene");
        b.a(this.f7309j, "onTouchAnimUpdate, scene: " + r11 + ", animFraction: " + r10);
        m(r10, r11);
        j(r10, r11);
    }

    public final void k(boolean r10) {
        b.a(this.f7309j, "updateSelectState, isSelected: " + r10);
        this.f7315p = r10;
        l(r10);
        i(r10);
    }

    public final void setOriginIconAlpha(int r10) {
        this.f7312m = r10;
    }
}
