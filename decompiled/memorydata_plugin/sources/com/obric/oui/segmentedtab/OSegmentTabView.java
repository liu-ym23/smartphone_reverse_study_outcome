package com.obric.oui.segmentedtab;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.a.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\fH\u0016J\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0007J\u0016\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\fH\u0002J\u0018\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\nH\u0002J\u000e\u0010$\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\fJ\u0010\u0010%\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\fH\u0002J\u0018\u0010&\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\nH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/oui/segmentedtab/OSegmentTabView;", "Lcom/obric/oui/segmentedtab/OTouchAnimView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "enableMaterial", "", "iconView", "Landroid/widget/ImageView;", "originIconAlpha", "selectState", "tabTitle", "Landroid/widget/TextView;", "textSelectColor", "textUnselectColor", "canPerFormAnim", "initView", "", "onTouchAnimUpdate", "animFraction", "", MemoryInfoSectionEditActivity.KIND_SCENE, "setOriginIconAlpha", "setOriginTextColor", "selectedTextColor", "unselectedTextColor", "updateIconAlpha", "isSelected", "updateIconAlphaOnPress", "fraction", "updateSelectState", "updateTextAppearance", "updateTextAppearanceOnPress", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSegmentTabView extends OTouchAnimView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14433a = null;
    private static int j;
    private static Typeface k;
    private static Typeface l;
    private final String c;
    private int d;
    private int e;
    private int f;
    private TextView g;
    private ImageView h;
    private boolean i;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/segmentedtab/OSegmentTabView$Companion;", "", "()V", "DEFAULT_TYPE_FACE", "Landroid/graphics/Typeface;", "SELECTED_TYPE_FACE", "instanceId", "", "getSelectedTypeFace", "typeface", "weight", "newInstance", "Lcom/obric/oui/segmentedtab/OSegmentTabView;", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final Typeface a(Typeface r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "typeface");
            if (OSegmentTabView.c() != null) goto L8;
            if (Build.VERSION.SDK_INT < 28) goto L8;
            OSegmentTabView.a(Typeface.create(r2, r3, false));
        L8:
            return OSegmentTabView.c();
        }

        public final OSegmentTabView a(Context r4) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
            View r5 = RelativeLayout.inflate(r3, ZeusTransformUtils.mapRes(R.layout.o_layout_tab_segment, "layout", "o_layout_tab_segment"), null);
            Objects.requireNonNull(r5, "null cannot be cast to non-null type com.obric.oui.segmentedtab.OSegmentTabView");
            OSegmentTabView r6 = (OSegmentTabView) ZeusTransformUtils.preCheckCast(r5, OSegmentTabView.class, "com.obric.memorydata.plugin");
            r6.b();
            return r6;
        }
    }

    static {
        f14433a = new a(null);
    }

    public OSegmentTabView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OSegmentTabView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OSegmentTabView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        int r8 = j;
        j = r8 + 1;
        this.c = Intrinsics.stringPlus("OSegmentTabView_", Integer.valueOf(r8));
    }

    public /* synthetic */ OSegmentTabView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ void a(Typeface r0) {
        l = r0;
    }

    private final void b(float r9, String r10) {
        boolean r1 = false;
        if (Intrinsics.areEqual(r10, "press_anim") == false) goto L6;
    L4:
        int r0 = this.e;
    L11:
        if (r0 != 0) goto L13;
        return;
    L13:
        int r2 = (r0 >> 24) & 255;
        int r3 = RangesKt.coerceIn((int) (r2 * OTouchAnimView.f14440b.a(r9)), 0, 255);
        int r4 = ((r0 >> 16) & 255) << 16;
        int r5 = (r0 & 255) | ((r4 | (r3 << 24)) | (((r0 >> 8) & 255) << 8));
        TextView r6 = this.g;
        Typeface r7 = null;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        r6 = null;
    L16:
        r6.setTextColor(r5);
        TextView r8 = this.g;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        r8 = null;
    L20:
        if (this.i == true) goto L22;
    L30:
        Typeface r11 = k;
        if (r11 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("DEFAULT_TYPE_FACE");
    L34:
        r8.setTypeface(r7);
        b.b(this.c, "updateTextColorOnPress, scene: " + r10 + ", fraction: " + r9 + ", newTextAlpha: " + r3 + ", originTextAlpha: " + r2);
        return;
    L33:
        r7 = r11;
        goto L34
    L22:
        if (r9 != 0.0f) goto L24;
        r1 = true;
    L24:
        if (r1 == false) goto L30;
        a r12 = f14433a;
        Typeface r13 = k;
        if (r13 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("DEFAULT_TYPE_FACE");
    L29:
        r7 = r12.a(r7, 500);
        goto L34
    L28:
        r7 = r13;
        goto L29
    L6:
        if (Intrinsics.areEqual(r10, "release_anim") == true) goto L8;
        r0 = 0;
        goto L11
    L8:
        if (this.i == false) goto L4;
        r0 = this.d;
        goto L11
    }

    private final void b(boolean r5) {
        Typeface r2 = null;
        if (r5 == true) goto L5;
        e();
        TextView r6 = this.g;
        if (r6 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        r6 = null;
    L21:
        r6.setTextColor(this.e);
        TextView r4 = this.g;
        if (r4 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        r4 = null;
    L24:
        Typeface r7 = k;
        if (r7 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("DEFAULT_TYPE_FACE");
    L28:
        r4.setTypeface(r2);
        return;
    L27:
        r2 = r7;
        goto L28
    L5:
        if (d() == true) goto L31;
        TextView r8 = this.g;
        if (r8 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        r8 = null;
    L10:
        r8.setTextColor(this.d);
        TextView r9 = this.g;
        if (r9 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        r9 = null;
    L13:
        a r10 = f14433a;
        Typeface r1 = k;
        if (r1 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("DEFAULT_TYPE_FACE");
    L17:
        r9.setTypeface(r10.a(r2, 500));
        return;
    L16:
        r2 = r1;
        goto L17
    }

    public static final /* synthetic */ Typeface c() {
        return l;
    }

    private final void c(float r5, String r6) {
        int r0 = RangesKt.coerceIn((int) (this.f * OTouchAnimView.f14440b.a(r5)), 0, 255);
        ImageView r1 = this.h;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        r1 = null;
    L5:
        r1.setImageAlpha(r0);
        b.b(this.c, "updateIconAlphaOnPress, scene: " + r6 + ", fraction: " + r5 + ", alpha: " + r0 + ", originIconAlpha: " + this.f);
    }

    private final void c(boolean r3) {
        ImageView r0 = null;
        if (r3 == true) goto L5;
        e();
        ImageView r4 = this.h;
        if (r4 != null) goto L13;
    L12:
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L14:
        r0.setImageAlpha(this.f);
        return;
    L13:
        r0 = r4;
        goto L14
    L5:
        if (d() == true) goto L16;
        r4 = this.h;
        if (r4 != null) goto L13;
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public void a(float r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, MemoryInfoSectionEditActivity.KIND_SCENE);
        b.b(this.c, "onTouchAnimUpdate, scene: " + r5 + ", animFraction: " + r4);
        b(r4, r5);
        c(r4, r5);
    }

    public final void a(int r1, int r2) {
        this.d = r1;
        this.e = r2;
    }

    public final void a(boolean r4) {
        b.b(this.c, Intrinsics.stringPlus("updateSelectState, isSelected: ", Boolean.valueOf(r4)));
        this.i = r4;
        setSelected(r4);
        b(r4);
        c(r4);
    }

    @Override // com.obric.oui.segmentedtab.OTouchAnimView
    public boolean a() {
        return !this.i;
    }

    public final void b() {
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_tab_title, OaidModel.KEY_ID, "tv_tab_title"));
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.tv_tab_title)");
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r0, TextView.class, "com.obric.memorydata.plugin");
        this.g = r1;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitle");
        r1 = null;
    L5:
        Typeface r2 = r1.getTypeface();
        Intrinsics.checkNotNullExpressionValue(r2, "tabTitle.typeface");
        k = r2;
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_tab_icon, OaidModel.KEY_ID, "tv_tab_icon"));
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.tv_tab_icon)");
        this.h = (ImageView) ZeusTransformUtils.preCheckCast(r3, ImageView.class, "com.obric.memorydata.plugin");
    }

    public final void setOriginIconAlpha(int r1) {
        this.f = r1;
    }
}
