package com.obric.oui.actionbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.obric.oui.button.OButton;
import com.obric.oui.divider.ODivider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "请根据设计稿，使用 v2 包下的对应样式的 OBottomActionBar(Floating/NormalHorizontal/NormalVertical) 代替")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0002\f\rB\u001d\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/actionbar/OBottomActionBar;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/actionbar/OBottomActionBar$b;", "l", "", "setBottomButtonClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OBottomActionBar extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f6148c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f6149g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final LinearLayout f6150h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ODivider f6151i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private b f6152j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<OButton> f6153k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f6154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f6155b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f6156c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<String> f6157d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<Integer> f6158e;

        public a(boolean r10, boolean r11, String r12, List<String> r13, List<Integer> r14) {
            Intrinsics.checkNotNullParameter(r12, "buttonStyle");
            this.f6154a = r10;
            this.f6155b = r11;
            this.f6156c = r12;
            this.f6157d = r13;
            this.f6158e = r14;
        }

        public final List<Integer> a() {
            return this.f6158e;
        }

        public final String b() {
            return this.f6156c;
        }

        public final List<String> c() {
            return this.f6157d;
        }

        public final boolean d() {
            return this.f6154a;
        }

        public final boolean e() {
            return this.f6155b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof a) == false) goto L16;
            a r11 = (a) r10;
            if (this.f6154a == r11.f6154a) goto L8;
            return false;
        L8:
            if (this.f6155b == r11.f6155b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f6156c, r11.f6156c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6157d, r11.f6157d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f6158e, r11.f6158e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        public int hashCode() {
            boolean r10 = this.f6154a;
            ?? r11 = 1;
            ?? r12 = r10;
            if (r10 == false) goto L5;
            r12 = 1;
        L5:
            int r13 = r12 * 31;
            boolean r14 = this.f6155b;
            if (r14 == true) goto L9;
            r11 = r14;
        L9:
            int r15 = (r13 + r11) * 31;
            String r16 = this.f6156c;
            int r17 = 0;
            if (r16 == null) goto L12;
            int r18 = r16.hashCode();
        L13:
            int r19 = (r15 + r18) * 31;
            List<String> r20 = this.f6157d;
            if (r20 == null) goto L16;
            int r21 = r20.hashCode();
        L17:
            int r22 = (r19 + r21) * 31;
            List<Integer> r23 = this.f6158e;
            if (r23 == null) goto L21;
            r17 = r23.hashCode();
        L21:
            return r22 + r17;
        L16:
            r21 = 0;
            goto L17
        L12:
            r18 = 0;
            goto L13
        }

        public String toString() {
            return "OBABConfig(hasDivider=" + this.f6154a + ", lastPrimary=" + this.f6155b + ", buttonStyle=" + this.f6156c + ", buttonTexts=" + this.f6157d + ", buttonImgIds=" + this.f6158e + ")";
        }
    }

    public interface b {
        void a(View r10, int r11);
    }

    static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OBottomActionBar f6159c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f6160g;

        c(OBottomActionBar r10, int r11) {
            this.f6159c = r10;
            this.f6160g = r11;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            OBottomActionBar r11 = this.f6159c;
            Intrinsics.checkNotNullExpressionValue(r10, "it");
            OBottomActionBar.a(r11, r10, this.f6160g);
        }
    }

    static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OBottomActionBar f6161c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f6162g;

        d(OBottomActionBar r10, int r11) {
            this.f6161c = r10;
            this.f6162g = r11;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            OBottomActionBar r11 = this.f6161c;
            Intrinsics.checkNotNullExpressionValue(r10, "it");
            OBottomActionBar.a(r11, r10, this.f6162g);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OBottomActionBar(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public OBottomActionBar(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.f6148c = "OBottomActionBar";
        FrameLayout.inflate(r10, h.o_widget_bottom_action_bar, this);
        setBackgroundColor(ContextCompat.getColor(r10, u8.c.Transparent));
        View r12 = findViewById(f.root_layout);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.root_layout)");
        this.f6150h = (LinearLayout) r12;
        View r13 = findViewById(f.top_divider);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.top_divider)");
        this.f6151i = (ODivider) r13;
        int r14 = 0;
        TypedArray r15 = r10.getTheme().obtainStyledAttributes(r11, l.OBottomActionBar, 0, 0);
        boolean r16 = r15.getBoolean(l.OBottomActionBar_oui_hasDivider, true);
        boolean r17 = r15.getBoolean(l.OBottomActionBar_oui_buttonLastPrimary, false);
        String r18 = r15.getString(l.OBottomActionBar_oui_buttonStyle);
        int r19 = r15.getResourceId(l.OBottomActionBar_oui_buttonTexts, -1);
        int r20 = r15.getResourceId(l.OBottomActionBar_oui_buttonImgIds, -1);
        if (r19 != (-1)) goto L5;
        List r21 = null;
    L6:
        if (r20 != (-1)) goto L8;
        List r22 = null;
    L12:
        if (r18 == null) goto L14;
        String r23 = r18;
    L15:
        b(new a(r16, r17, r23, r21, r22));
        return;
    L14:
        r23 = "l1";
        goto L15
    L8:
        TypedArray r24 = r15.getResources().obtainTypedArray(r20);
        Intrinsics.checkNotNullExpressionValue(r24, "resources.obtainTypedArray(buttonImg)");
        ArrayList r25 = new ArrayList();
        int r26 = r24.length();
    L9:
        if (r14 >= r26) goto L11;
        r25.add(Integer.valueOf(r24.getResourceId(r14, -1)));
        r14 = r14 + 1;
        goto L9
    L11:
        List r27 = CollectionsKt.toMutableList(r25);
        r24.recycle();
        r22 = r27;
        goto L12
    L5:
        String[] r28 = r15.getResources().getStringArray(r19);
        Intrinsics.checkNotNullExpressionValue(r28, "resources.getStringArray(buttonResourceId)");
        r21 = ArraysKt.toMutableList(r28);
        goto L6
    }

    public /* synthetic */ OBottomActionBar(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public static final /* synthetic */ void a(OBottomActionBar r10, View r11, int r12) {
        r10.e(r11, r12);
    }

    private final void b(a r17) {
        String r10 = r17.b();
        int r11 = r10.hashCode();
        if (r11 == (-1612256902)) goto L31;
        if (r11 == 3397) goto L28;
        if (r11 == 104387) goto L25;
        if (r11 == 678742426) goto L22;
        if (r11 == 3428) goto L19;
        if (r11 != 3429) goto L35;
        if (r10.equals("m2") == false) goto L35;
        this.f6149g = FrameLayout.inflate(getContext(), h.o_widget_bottom_action_bar_m2, null);
        this.f6150h.addView(this.f6149g, new LinearLayout.LayoutParams(-1, -1));
        View r12 = findViewById(f.action_button_m20);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.action_button_m20)");
        View r13 = findViewById(f.action_button_m21);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.action_button_m21)");
        View r14 = findViewById(f.action_button_m22);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.action_button_m22)");
        List<OButton> r15 = CollectionsKt.mutableListOf(new OButton[]{(OButton) r12, (OButton) r13, (OButton) r14});
    L33:
        this.f6153k = r15;
    L35:
        if (r17.b().compareTo("img") != 0) goto L37;
        c(this.f6153k, r17);
    L38:
        boolean r16 = r17.d();
        ODivider r18 = this.f6151i;
        if (r16 == false) goto L41;
        r18.setVisibility(0);
        return;
    L41:
        r18.setVisibility(8);
        return;
    L37:
        d(this.f6153k, r17);
        goto L38
    L19:
        if (r10.equals("m1") == false) goto L35;
        this.f6149g = FrameLayout.inflate(getContext(), h.o_widget_bottom_action_bar_m1, null);
        this.f6150h.addView(this.f6149g, new LinearLayout.LayoutParams(-1, -1));
        View r19 = findViewById(f.action_button_0);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.action_button_0)");
        View r20 = findViewById(f.action_button_1);
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.action_button_1)");
        View r21 = findViewById(f.action_button_2);
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.action_button_2)");
        View r22 = findViewById(f.action_button_3);
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.action_button_3)");
        View r23 = findViewById(f.action_button_4);
        Intrinsics.checkNotNullExpressionValue(r23, "findViewById(R.id.action_button_4)");
        r15 = CollectionsKt.mutableListOf(new OButton[]{(OButton) r19, (OButton) r20, (OButton) r21, (OButton) r22, (OButton) r23});
        goto L33
    L22:
        if (r10.equals("m2-primary") == false) goto L35;
        this.f6149g = FrameLayout.inflate(getContext(), h.o_widget_bottom_action_bar_m2_primary, null);
        this.f6150h.addView(this.f6149g, new LinearLayout.LayoutParams(-1, -1));
        View r24 = findViewById(f.action_button_m2_primary0);
        Intrinsics.checkNotNullExpressionValue(r24, "findViewById(R.id.action_button_m2_primary0)");
        View r25 = findViewById(f.action_button_m2_primary1);
        Intrinsics.checkNotNullExpressionValue(r25, "findViewById(R.id.action_button_m2_primary1)");
        r15 = CollectionsKt.mutableListOf(new OButton[]{(OButton) r24, (OButton) r25});
        goto L33
    L25:
        if (r10.equals("img") == false) goto L35;
        this.f6149g = FrameLayout.inflate(getContext(), h.o_widget_bottom_action_bar_img, null);
        this.f6150h.addView(this.f6149g, new LinearLayout.LayoutParams(-1, -1));
        View r26 = findViewById(f.action_button_0);
        Intrinsics.checkNotNullExpressionValue(r26, "findViewById(R.id.action_button_0)");
        View r27 = findViewById(f.action_button_1);
        Intrinsics.checkNotNullExpressionValue(r27, "findViewById(R.id.action_button_1)");
        View r28 = findViewById(f.action_button_2);
        Intrinsics.checkNotNullExpressionValue(r28, "findViewById(R.id.action_button_2)");
        View r29 = findViewById(f.action_button_3);
        Intrinsics.checkNotNullExpressionValue(r29, "findViewById(R.id.action_button_3)");
        View r30 = findViewById(f.action_button_4);
        Intrinsics.checkNotNullExpressionValue(r30, "findViewById(R.id.action_button_4)");
        View r31 = findViewById(f.action_button_5);
        Intrinsics.checkNotNullExpressionValue(r31, "findViewById(R.id.action_button_5)");
        r15 = CollectionsKt.mutableListOf(new OButton[]{(OButton) r26, (OButton) r27, (OButton) r28, (OButton) r29, (OButton) r30, (OButton) r31});
        goto L33
    L28:
        if (r10.equals("l1") == false) goto L35;
        this.f6149g = FrameLayout.inflate(getContext(), h.o_widget_bottom_action_bar_l1, null);
        this.f6150h.addView(this.f6149g, new LinearLayout.LayoutParams(-1, -1));
        View r32 = findViewById(f.action_button_L10);
        Intrinsics.checkNotNullExpressionValue(r32, "findViewById(R.id.action_button_L10)");
        View r33 = findViewById(f.action_button_L11);
        Intrinsics.checkNotNullExpressionValue(r33, "findViewById(R.id.action_button_L11)");
        r15 = CollectionsKt.mutableListOf(new OButton[]{(OButton) r32, (OButton) r33});
        goto L33
    L31:
        if (r10.equals("l1-primary") == false) goto L35;
        this.f6149g = FrameLayout.inflate(getContext(), h.o_widget_bottom_action_bar_l1_primary, null);
        this.f6150h.addView(this.f6149g, new LinearLayout.LayoutParams(-1, -1));
        View r34 = findViewById(f.action_button_L1_primary);
        Intrinsics.checkNotNullExpressionValue(r34, "findViewById(R.id.action_button_L1_primary)");
        r15 = CollectionsKt.mutableListOf(new OButton[]{(OButton) r34});
        goto L33
    }

    private final void c(List<OButton> r10, a r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r12 = 0;
        if (r11.a() == null) goto L12;
        int r13 = Math.min(r11.a().size(), r10.size());
        if (r11.a().size() <= r10.size()) goto L9;
        Log.e(this.f6148c, "Exceeded the maximum number of buttons Max is " + r10.size());
    L9:
        int r14 = r13 - 1;
        int r15 = 0;
    L10:
        if (r15 >= r13) goto L13;
        r10.get(r15).setVisibility(0);
        r10.get(r15).setButtonSourceBitmap(r11.a().get(r15).intValue());
        r15 = r15 + 1;
    L13:
        if (r14 != (-1)) goto L15;
        r14 = r10.size() - 1;
    L15:
        if (r14 < 0) goto L19;
    L16:
        r10.get(r12).setOnClickListener(new c(this, r12));
        if (r12 == r14) goto L22;
        r12 = r12 + 1;
        goto L16
    L22:
        return;
    L19:
        return;
    L12:
        r14 = -1;
        goto L13
    }

    private final void d(List<OButton> r10, a r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r12 = 0;
        if (r11.c() == null) goto L12;
        int r13 = Math.min(r11.c().size(), r10.size());
        if (r11.c().size() <= r10.size()) goto L9;
        Log.e(this.f6148c, "Exceeded the maximum number of buttons Max is " + r10.size());
    L9:
        int r14 = r13 - 1;
        int r15 = 0;
    L10:
        if (r15 >= r13) goto L13;
        r10.get(r15).setVisibility(0);
        r10.get(r15).setText(r11.c().get(r15));
        r15 = r15 + 1;
    L13:
        if (r14 != (-1)) goto L16;
        r14 = r10.size() - 1;
    L16:
        if (r11.e() == false) goto L25;
        r10.get(r14).setBackgroundColor(getResources().getColor(u8.c.oui_accent_bg_high_contrast));
        r10.get(r14).setTextColor(getResources().getColor(u8.c.oui_on_accent_default));
        da.c r16 = da.c.f8520a;
        OButton r17 = r10.get(r14);
        if (r17 != null) goto L21;
    L19:
        r17 = null;
    L22:
        OButton r18 = r17;
        if (r18 == null) goto L25;
        r18.refreshColors(this.f6148c);
        goto L25
    L21:
        if ((r17 instanceof o9.a) == false) goto L19;
    L25:
        if (r14 < 0) goto L29;
    L26:
        r10.get(r12).setOnClickListener(new d(this, r12));
        if (r12 == r14) goto L32;
        r12 = r12 + 1;
        goto L26
    L32:
        return;
    L29:
        return;
    L12:
        r14 = -1;
        goto L13
    }

    private final void e(View r10, int r11) {
        b r12 = this.f6152j;
        if (r12 == null) goto L6;
        r12.a(r10, r11);
        return;
    }

    private final void f() {
        View r10 = this.f6149g;
        if (r10 == null) goto L6;
        this.f6150h.removeView(r10);
        this.f6149g = null;
        return;
    }

    public final void g(boolean r10, String r11, boolean r12, String[] r13, Integer[] r14) {
        Intrinsics.checkNotNullParameter(r11, "buttonStyle");
        f();
        if (r13 == null) goto L5;
        List r15 = ArraysKt.toMutableList(r13);
    L6:
        if (r14 == null) goto L8;
        List r16 = ArraysKt.toMutableList(r14);
    L9:
        b(new a(r10, r12, r11, r15, r16));
        return;
    L8:
        r16 = null;
        goto L9
    L5:
        r15 = null;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    public final void setBottomButtonClickListener(b r10) {
        this.f6152j = r10;
    }
}
