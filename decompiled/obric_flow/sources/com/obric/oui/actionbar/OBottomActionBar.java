package com.obric.oui.actionbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OButton;
import com.obric.oui.divider.ODivider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import tq.a;
import tq.b;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "请根据设计稿，使用 v2 包下的对应样式的 OBottomActionBar(Floating/NormalHorizontal/NormalVertical) 代替")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001:\u0001\bB\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/oui/actionbar/OBottomActionBar;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Ltq/b;", "l", "", "setBottomButtonClickListener", "(Ltq/b;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OBottomActionBar extends FrameLayout {
    public static final /* synthetic */ int f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f11915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinearLayout f11916c;
    public final ODivider d;
    public final List e;

    @JvmOverloads
    public OBottomActionBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
    }

    public final void setBottomButtonClickListener(b r5) {
    }

    @JvmOverloads
    public OBottomActionBar(Context r22, AttributeSet r23) {
        Intrinsics.checkNotNullParameter(r22, "context");
        super(r22, r23);
        this.f11914a = "OBottomActionBar";
        View.inflate(r22, R$layout.o_widget_bottom_action_bar, this);
        setBackgroundColor(ContextCompat.getColor(r22, R$color.Transparent));
        this.f11916c = (LinearLayout) findViewById(R$id.root_layout);
        this.d = (ODivider) findViewById(R$id.top_divider);
        TypedArray r5 = r22.getTheme().obtainStyledAttributes(r23, R$styleable.OBottomActionBar, 0, 0);
        boolean r10 = r5.getBoolean(R$styleable.OBottomActionBar_oui_hasDivider, true);
        boolean r11 = r5.getBoolean(R$styleable.OBottomActionBar_oui_buttonLastPrimary, false);
        String r12 = r5.getString(R$styleable.OBottomActionBar_oui_buttonStyle);
        int r13 = r5.getResourceId(R$styleable.OBottomActionBar_oui_buttonTexts, 0);
        int r14 = r5.getResourceId(R$styleable.OBottomActionBar_oui_buttonImgIds, 0);
        Object r15 = null;
        if (r13 != 0) goto L5;
        List r16 = null;
    L6:
        if (r14 != 0) goto L8;
        List r17 = null;
    L13:
        if (r12 != null) goto L15;
        r12 = "l1";
    L15:
        Intrinsics.checkNotNullParameter(r12, "buttonStyle");
        r5.recycle();
        int r18 = r12.hashCode();
        LinearLayout r19 = this.f11916c;
        if (r18 == (-1612256902)) goto L49;
        if (r18 == 3397) goto L45;
        if (r18 == 104387) goto L41;
        if (r18 == 678742426) goto L37;
        if (r18 == 3428) goto L33;
        if (r18 == 3429) goto L29;
    L52:
        int r20 = r12.compareTo("img");
        String r21 = this.f11914a;
        if (r20 != 0) goto L73;
        List r24 = this.e;
        if (r24 == null) goto L103;
        if (r17 == null) goto L64;
        int r25 = Math.min(r17.size(), r24.size());
        if (r17.size() <= r24.size()) goto L61;
        Log.e(r21, Intrinsics.stringPlus("Exceeded the maximum number of buttons Max is ", Integer.valueOf(r24.size())));
    L61:
        int r26 = r25 - 1;
        int r27 = 0;
    L62:
        if (r27 >= r25) goto L65;
        ((OButton) r24.get(r27)).setVisibility(0);
        ((OButton) r24.get(r27)).setButtonSourceBitmap(((Number) r17.get(r27)).intValue());
        r27 = r27 + 1;
    L65:
        if (r26 != (-1)) goto L67;
        r26 = r24.size() - 1;
    L67:
        if (r26 < 0) goto L103;
        final int r28 = 0;
    L69:
        int r29 = r28 + 1;
        final int r30 = 0;
        ((OButton) r24.get(r28)).setOnClickListener(new a(this, r28, r30));
        if (r28 == r26) goto L103;
        r28 = r29;
        goto L69
    L64:
        r26 = -1;
    L103:
        ODivider r31 = this.d;
        if (r10 == false) goto L106;
        r31.setVisibility(0);
        return;
    L106:
        r31.setVisibility(8);
        return;
    L73:
        List r32 = this.e;
        if (r32 == null) goto L103;
        if (r16 == null) goto L83;
        int r110 = Math.min(r16.size(), r32.size());
        if (r16.size() <= r32.size()) goto L80;
        Log.e(r21, Intrinsics.stringPlus("Exceeded the maximum number of buttons Max is ", Integer.valueOf(r32.size())));
    L80:
        int r33 = r110 - 1;
        int r111 = 0;
    L81:
        if (r111 >= r110) goto L84;
        ((OButton) r32.get(r111)).setVisibility(0);
        ((OButton) r32.get(r111)).setText((CharSequence) r16.get(r111));
        r111 = r111 + 1;
    L84:
        if (r33 != (-1)) goto L86;
        r33 = r32.size() - 1;
    L86:
        if (r11 == false) goto L97;
        ((OButton) r32.get(r33)).setBackgroundColor(getResources().getColor(R$color.oui_accent_bg_high_contrast));
        ((OButton) r32.get(r33)).setTextColor(getResources().getColor(R$color.oui_on_accent_default));
        Object r34 = r32.get(r33);
        if (r34 != null) goto L91;
    L93:
        com.obric.oui.common.style.a r35 = (com.obric.oui.common.style.a) r15;
        if (r35 == null) goto L97;
        r35.i(r21);
        goto L97
    L91:
        if ((r34 instanceof com.obric.oui.common.style.a) == false) goto L93;
        r15 = r34;
    L97:
        if (r33 < 0) goto L103;
        final int r36 = 0;
    L99:
        int r37 = r36 + 1;
        final int r38 = 1;
        ((OButton) r32.get(r36)).setOnClickListener(new a(this, r36, r38));
        if (r36 == r33) goto L103;
        r36 = r37;
        goto L99
    L83:
        r33 = -1;
        goto L84
    L29:
        if (r12.equals("m2") == false) goto L52;
        this.f11915b = View.inflate(getContext(), R$layout.o_widget_bottom_action_bar_m2, null);
        r19.addView(this.f11915b, new LinearLayout.LayoutParams(-1, -1));
        this.e = CollectionsKt.mutableListOf(new OButton[]{(OButton) findViewById(R$id.action_button_m20), (OButton) findViewById(R$id.action_button_m21), (OButton) findViewById(R$id.action_button_m22)});
        goto L52
    L33:
        if (r12.equals("m1") == false) goto L52;
        this.f11915b = View.inflate(getContext(), R$layout.o_widget_bottom_action_bar_m1, null);
        r19.addView(this.f11915b, new LinearLayout.LayoutParams(-1, -1));
        this.e = CollectionsKt.mutableListOf(new OButton[]{(OButton) findViewById(R$id.action_button_0), (OButton) findViewById(R$id.action_button_1), (OButton) findViewById(R$id.action_button_2), (OButton) findViewById(R$id.action_button_3), (OButton) findViewById(R$id.action_button_4)});
        goto L52
    L37:
        if (r12.equals("m2-primary") == false) goto L52;
        this.f11915b = View.inflate(getContext(), R$layout.o_widget_bottom_action_bar_m2_primary, null);
        r19.addView(this.f11915b, new LinearLayout.LayoutParams(-1, -1));
        this.e = CollectionsKt.mutableListOf(new OButton[]{(OButton) findViewById(R$id.action_button_m2_primary0), (OButton) findViewById(R$id.action_button_m2_primary1)});
        goto L52
    L41:
        if (r12.equals("img") == false) goto L52;
        this.f11915b = View.inflate(getContext(), R$layout.o_widget_bottom_action_bar_img, null);
        r19.addView(this.f11915b, new LinearLayout.LayoutParams(-1, -1));
        this.e = CollectionsKt.mutableListOf(new OButton[]{(OButton) findViewById(R$id.action_button_0), (OButton) findViewById(R$id.action_button_1), (OButton) findViewById(R$id.action_button_2), (OButton) findViewById(R$id.action_button_3), (OButton) findViewById(R$id.action_button_4), (OButton) findViewById(R$id.action_button_5)});
        goto L52
    L45:
        if (r12.equals("l1") == false) goto L52;
        this.f11915b = View.inflate(getContext(), R$layout.o_widget_bottom_action_bar_l1, null);
        r19.addView(this.f11915b, new LinearLayout.LayoutParams(-1, -1));
        this.e = CollectionsKt.mutableListOf(new OButton[]{(OButton) findViewById(R$id.action_button_L10), (OButton) findViewById(R$id.action_button_L11)});
        goto L52
    L49:
        if (r12.equals("l1-primary") == false) goto L52;
        this.f11915b = View.inflate(getContext(), R$layout.o_widget_bottom_action_bar_l1_primary, null);
        r19.addView(this.f11915b, new LinearLayout.LayoutParams(-1, -1));
        this.e = CollectionsKt.mutableListOf(new OButton[]{(OButton) findViewById(R$id.action_button_L1_primary)});
        goto L52
    L8:
        TypedArray r39 = r5.getResources().obtainTypedArray(r14);
        ArrayList r112 = new ArrayList();
        int r113 = r39.length();
        int r114 = 0;
    L9:
        if (r114 >= r113) goto L11;
        r112.add(Integer.valueOf(r39.getResourceId(r114, 0)));
        r114 = r114 + 1;
        goto L9
    L11:
        r17 = CollectionsKt.toMutableList(r112);
        r39.recycle();
        goto L13
    L5:
        r16 = ArraysKt.toMutableList(r5.getResources().getStringArray(r13));
        goto L6
    }
}
