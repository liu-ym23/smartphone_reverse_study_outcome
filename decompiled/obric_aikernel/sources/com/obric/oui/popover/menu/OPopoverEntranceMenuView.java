package com.obric.oui.popover.menu;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.bytedance.crash.entity.EventBody;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u001d\u0010\b\u001a\u00020\u00028B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView;", "Lcom/obric/oui/popover/menu/OPopoverMenuView;", "", "getAvailableItemWidth", "k", "Lkotlin/Lazy;", "getVerticalPadding", "()I", "verticalPadding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "WidthLevel", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OPopoverEntranceMenuView extends OPopoverMenuView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f7146n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f7147o = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f7148j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f7149k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f7150l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f7151m;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$WidthLevel;", "", "", EventBody.KEY_VALUE, "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "WIDTH_LEVEL_STANDARD", "WIDTH_LEVEL_BROAD", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum WidthLevel extends Enum<WidthLevel> {
        private static final /* synthetic */ WidthLevel[] $VALUES = null;
        public static final WidthLevel WIDTH_LEVEL_BROAD = null;
        public static final WidthLevel WIDTH_LEVEL_STANDARD = null;
        private final int value;

        static {
            WidthLevel r10 = new WidthLevel("WIDTH_LEVEL_STANDARD", 0, OPopoverEntranceMenuView.e());
            WIDTH_LEVEL_STANDARD = r10;
            WidthLevel r11 = new WidthLevel("WIDTH_LEVEL_BROAD", 1, OPopoverEntranceMenuView.d());
            WIDTH_LEVEL_BROAD = r11;
            $VALUES = new WidthLevel[]{r10, r11};
        }

        private WidthLevel(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static WidthLevel valueOf(String r10) {
            return (WidthLevel) Enum.valueOf(WidthLevel.class, r10);
        }

        public static WidthLevel[] values() {
            return (WidthLevel[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
        Resources r10 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r10, "Resources.getSystem()");
        f7146n = MathKt.roundToInt(TypedValue.applyDimension(1, 200, r10.getDisplayMetrics()));
        Resources r11 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r11, "Resources.getSystem()");
        f7147o = MathKt.roundToInt(TypedValue.applyDimension(1, 224, r11.getDisplayMetrics()));
    }

    @JvmOverloads
    public OPopoverEntranceMenuView(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OPopoverEntranceMenuView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OPopoverEntranceMenuView(final Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        OPopoverEntranceMenuView$itemLayoutProcess$1 r13 = OPopoverEntranceMenuView$itemLayoutProcess$1.INSTANCE;
        new ArrayList();
        this.f7148j = f7146n;
        this.f7149k = LazyKt.lazy(new OPopoverEntranceMenuView$verticalPadding$2(r10));
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        this.f7150l = MathKt.roundToInt(TypedValue.applyDimension(1, 8, r14.getDisplayMetrics()));
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        MathKt.roundToInt(TypedValue.applyDimension(1, 2, r15.getDisplayMetrics()));
        this.f7151m = r10.getResources().getDimensionPixelSize(d.oui_popover_max_height);
    }

    public /* synthetic */ OPopoverEntranceMenuView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ int d() {
        return f7147o;
    }

    public static final /* synthetic */ int e() {
        return f7146n;
    }

    private final int getAvailableItemWidth() {
        return this.f7148j - (this.f7150l * 2);
    }

    private final int getVerticalPadding() {
        return ((Number) this.f7149k.getValue()).intValue();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if (getMeasuredHeight() <= this.f7151m) goto L6;
        setMeasuredDimension(getMeasuredWidth(), this.f7151m);
        return;
    }
}
