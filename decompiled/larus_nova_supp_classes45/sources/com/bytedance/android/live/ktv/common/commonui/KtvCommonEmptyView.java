package com.bytedance.android.live.ktv.common.commonui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.util.h;
import kb0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/ktv/common/commonui/KtvCommonEmptyView;", "Landroid/widget/FrameLayout;", "", "Lkotlin/Function0;", "", "goSelectMusicAction", "setGoSelectMusicAction", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvCommonEmptyView extends FrameLayout {
    public final View a;
    public final TextView b;
    public final TextView c;
    public final LinearLayout d;
    public final View e;

    public KtvCommonEmptyView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvCommonEmptyView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void c(int r2) {
        if (r2 != 0) goto L7;
        LinearLayout r0 = this.d;
        if (r0 == null) goto L17;
        r0.setVisibility(r2);
        return;
    L17:
        return;
    L7:
        if (r2 != 8) goto L12;
        LinearLayout r1 = this.d;
        if (r1 == null) goto L19;
        r1.setVisibility(r2);
        return;
    L19:
        return;
    L12:
        if (r2 != 4) goto L21;
        LinearLayout r3 = this.d;
        if (r3 == null) goto L22;
        r3.setVisibility(r2);
        return;
    L22:
        return;
    }

    public void setGoSelectMusicAction(Function0<Unit> r3) {
        LinearLayout r0 = this.d;
        if (r0 == null) goto L6;
        r0.setOnClickListener(new b(r3));
        return;
    }

    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "hintPhase1");
        Intrinsics.checkNotNullParameter(r3, "hintPhase2");
        TextView r0 = this.b;
        if (r0 == null) goto L5;
        r0.setText(r2);
    L5:
        TextView r4 = this.c;
        if (r4 == null) goto L9;
        r4.setText(r3);
        return;
    }

    public final void b(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "tabName");
        String r1 = "";
        switch(r3.hashCode()) {
            case -2123439502: goto L39;
            case -1877754167: goto L36;
            case -906336856: goto L28;
            case -808572632: goto L17;
            case 3541915: goto L14;
            case 1050790300: goto L6;
            default: goto L46;
        };
    L46:
        TextView r5 = this.b;
        if (r5 == null) goto L49;
        r5.setText(s1.B(2131918624));
    L49:
        TextView r6 = this.c;
        if (r6 == null) goto L61;
        r6.setText("");
        return;
    L61:
        return;
    L6:
        if (r3.equals("favorite") == false) goto L46;
        TextView r7 = this.b;
        if (r7 == null) goto L10;
        r7.setText(s1.B(2131918385));
    L10:
        TextView r8 = this.c;
        if (r8 == null) goto L53;
        r8.setText("");
        return;
    L53:
        return;
    L14:
        if (r3.equals("sung") == false) goto L46;
    L40:
        TextView r9 = this.b;
        if (r9 == null) goto L43;
        r9.setText(s1.B(2131918556));
    L43:
        TextView r11 = this.c;
        if (r11 == null) goto L59;
        r11.setText(s1.B(2131918557));
        return;
    L59:
        return;
    L17:
        if (r3.equals("recently") == false) goto L46;
        TextView r12 = this.b;
        if (r12 == null) goto L21;
        r12.setText(s1.B(2131918509));
    L21:
        TextView r13 = this.c;
        if (r13 == null) goto L55;
        if (r4 == true) goto L26;
        r1 = s1.B(2131918510);
    L26:
        r13.setText(r1);
        return;
    L55:
        return;
    L28:
        if (r3.equals("search") == false) goto L46;
        TextView r14 = this.b;
        if (r14 == null) goto L32;
        r14.setText(s1.B(2131918572));
    L32:
        TextView r15 = this.c;
        if (r15 == null) goto L57;
        r15.setText(s1.B(2131918573));
        return;
    L57:
        return;
    L36:
        if (r3.equals("play_list") == false) goto L46;
    L39:
        if (r3.equals("mine_want_sing") == false) goto L46;
        goto L40
    }

    public KtvCommonEmptyView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        View r7 = LayoutInflater.from(r4).inflate(2131566668, this, true);
        this.a = r7;
        if (r7 == null) goto L5;
        LinearLayout r8 = (LinearLayout) r7.findViewById(2131382381);
    L5:
        View r9 = null;
        if (r7 == null) goto L8;
        ImageView r11 = (ImageView) r7.findViewById(2131371572);
    L9:
        if (r7 == null) goto L11;
        TextView r0 = (TextView) r7.findViewById(2131371577);
    L12:
        this.b = r0;
        if (r7 == null) goto L15;
        TextView r1 = (TextView) r7.findViewById(2131371578);
    L16:
        this.c = r1;
        if (r7 == null) goto L19;
        LinearLayout r2 = (LinearLayout) r7.findViewById(2131373835);
    L20:
        this.d = r2;
        if (r7 == null) goto L23;
        TextView r3 = (TextView) r7.findViewById(2131373837);
    L24:
        if (r7 == null) goto L26;
        r9 = r7.findViewById(2131373836);
    L26:
        this.e = r9;
        int r12 = h.a;
        if (r11 == null) goto L29;
        FrescoLoader.with(r11.getContext()).load("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_bg_ktv_empty_black_light.png").into(r11);
    L29:
        if (r0 == null) goto L31;
        KtvOrderSongThemeManager.d(r0, 106);
    L31:
        if (r1 == null) goto L33;
        KtvOrderSongThemeManager.d(r1, 107);
    L33:
        if (r3 == null) goto L36;
        KtvOrderSongThemeManager.d(r3, 108);
        return;
    L36:
        return;
    L23:
        r3 = null;
        goto L24
    L19:
        r2 = null;
        goto L20
    L15:
        r1 = null;
        goto L16
    L11:
        r0 = null;
        goto L12
    L8:
        r11 = null;
        goto L9
    }

    public /* synthetic */ KtvCommonEmptyView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
