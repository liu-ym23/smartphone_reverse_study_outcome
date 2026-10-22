package com.larus.dora.obric.device_management.device_home;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.TextViewCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.button.OButton;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.image.OImage;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.lisitem.OUICardConstraintLayout;
import com.obric.oui.tag.OTextTag;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;
        public static final /* synthetic */ int[] d = null;

        static {
            int[] r0 = new int[DoraObricEnvironmentMemoryLabel.values().length];
            r0[DoraObricEnvironmentMemoryLabel.ON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L45:
            r0[DoraObricEnvironmentMemoryLabel.OFF.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L59:
            r0[DoraObricEnvironmentMemoryLabel.UNAVAILABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L8:
            a = r0;
            int[] r1 = new int[DoraObricEnvironmentMemoryIcon.values().length];
            r1[DoraObricEnvironmentMemoryIcon.RUNNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L47:
            r1[DoraObricEnvironmentMemoryIcon.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L11:
            b = r1;
            int[] r2 = new int[DoraObricDeviceBusinessStatus.values().length];
            r2[DoraObricDeviceBusinessStatus.VIDEO_CALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L49:
            r2[DoraObricDeviceBusinessStatus.RECORDING_MINUTES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L37:
            r2[DoraObricDeviceBusinessStatus.VIDEO_RECORDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L51:
            r2[DoraObricDeviceBusinessStatus.INTERPRETATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L17:
            c = r2;
            int[] r3 = new int[DoraObricEnvironmentMemoryTextStyle.values().length];
            r3[DoraObricEnvironmentMemoryTextStyle.RUNNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L43:
            r3[DoraObricEnvironmentMemoryTextStyle.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L53:
            r3[DoraObricEnvironmentMemoryTextStyle.HEADPHONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L35
        L41:
            r3[DoraObricEnvironmentMemoryTextStyle.DISABLED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L36
        L22:
            d = r3;
        }
    }

    static {
    }

    public static int d(OUICardConstraintLayout r1, int r2) {
        Resources r3 = r1.getResources();
        return (int) ((r2 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f);
    }

    public static int c(View r1, int r2, int r3) {
        return r1.getResources().getDimensionPixelSize(v19.c.b(r2, r1.getContext(), r3));
    }

    public static void b(OUILinearLayout r8, OButton r9, OTextView r10, final b r11, final Function0 r12) {
        Intrinsics.checkNotNullParameter(r8, "statusRow");
        Intrinsics.checkNotNullParameter(r9, "environmentMemoryStatus");
        Intrinsics.checkNotNullParameter(r10, "interpretationStatus");
        Intrinsics.checkNotNullParameter(r11, "presentation");
        int r0 = a.a[r11.j.ordinal()];
        boolean r3 = true;
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L9;
        if (r0 != 3) goto L8;
        int r1 = 2131903489;
    L11:
        r9.setText(r1);
        int r2 = a.d[r11.l.ordinal()];
        if (r2 == 1) goto L20;
        if (r2 == 2) goto L19;
        if (r2 == 3) goto L19;
        if (r2 == 4) goto L19;
        throw new NoWhenBranchMatchedException();
    L19:
        int r4 = 2131104350;
    L21:
        int r5 = ContextCompat.getColor(r9.getContext(), r4);
        r9.setTextColor(r5);
        TextViewCompat.setCompoundDrawableTintList(r9, ColorStateList.valueOf(r5));
        r9.setEnabled(r11.g);
        Context r6 = r9.getContext();
        int r7 = a.b[r11.k.ordinal()];
        if (r7 == 1) goto L27;
        if (r7 != 2) goto L26;
        int r13 = 2131240585;
    L28:
        Drawable r14 = AppCompatResources.getDrawable(r6, r13);
        if (r14 == null) goto L31;
        Drawable r15 = r14.mutate();
    L32:
        if (r15 != null) goto L34;
    L36:
        r9.setCompoundDrawablesRelativeWithIntrinsicBounds(r15, null, null, null);
        DoraObricDeviceBusinessStatus r16 = r11.n;
        if (r16 != null) goto L39;
        int r17 = -1;
    L40:
        if (r17 == (-1)) goto L51;
        if (r17 == 1) goto L50;
        if (r17 == 2) goto L49;
        if (r17 == 3) goto L48;
        if (r17 == 4) goto L51;
        throw new NoWhenBranchMatchedException();
    L48:
        int r18 = 2131903493;
    L52:
        r10.setText(r18);
        int r20 = c(r10, 2130971517, 2131167404);
        int r21 = ContextCompat.getColor(r10.getContext(), 2131104979);
        GradientDrawable r22 = new GradientDrawable();
        r22.setShape(1);
        r22.setColor(r21);
        r22.setSize(r20, r20);
        r10.setCompoundDrawablesRelativeWithIntrinsicBounds(r22, null, null, null);
        TextViewCompat.setCompoundDrawableTintList(r10, ColorStateList.valueOf(r21));
        if (r11.f == false) goto L55;
        com.larus.utils.e1.x(r9);
    L56:
        r9.setOnClickListener(new d(r11, r12));
        r9.setClickable(r11.g);
        r10.setClickable(false);
        r10.setFocusable(false);
        if (r11.n != null) goto L60;
        r3 = false;
    L60:
        if (r3 == false) goto L62;
        com.larus.utils.e1.x(r10);
    L64:
        if (r11.f == false) goto L66;
    L69:
        com.larus.utils.e1.x(r8);
        r8.bringToFront();
        return;
    L66:
        if (r11.n != null) goto L69;
        com.larus.utils.e1.o(r8);
        return;
    L62:
        com.larus.utils.e1.o(r10);
        goto L64
    L55:
        com.larus.utils.e1.o(r9);
        goto L56
    L49:
        r18 = 2131903491;
        goto L52
    L50:
        r18 = 2131903492;
    L51:
        r18 = 2131903490;
        goto L52
    L39:
        r17 = a.c[r16.ordinal()];
        goto L40
    L34:
        if (r11.m == false) goto L36;
        DrawableCompat.setTint(r15, r5);
        goto L36
    L31:
        r15 = null;
        goto L32
    L26:
        throw new NoWhenBranchMatchedException();
    L27:
        r13 = 2131240557;
        goto L28
    L20:
        r4 = 2131104819;
        goto L21
    L8:
        throw new NoWhenBranchMatchedException();
    L9:
        r1 = 2131903487;
        goto L11
    L10:
        r1 = 2131903488;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(OUICardConstraintLayout r18, OImage r110, OUILinearLayout r20, OUILinearLayout r21, OUILinearLayout r22, OUIFrameLayout r23, OTextTag r24, OImage r25, OImage r26, DoraObricDeviceModeEntryView r27, boolean r28) {
        Intrinsics.checkNotNullParameter(r18, "root");
        Intrinsics.checkNotNullParameter(r110, "image");
        Intrinsics.checkNotNullParameter(r20, "nameRow");
        Intrinsics.checkNotNullParameter(r21, "batteryRow");
        Intrinsics.checkNotNullParameter(r22, "earbudsBatteryRow");
        Intrinsics.checkNotNullParameter(r23, "connectionRow");
        Intrinsics.checkNotNullParameter(r24, "modeTag");
        Intrinsics.checkNotNullParameter(r25, "legacySettingsButton");
        Intrinsics.checkNotNullParameter(r26, "topSettingsButton");
        Intrinsics.checkNotNullParameter(r27, "modeEntry");
        ConstraintLayout.LayoutParams r16 = null;
        boolean r17 = true;
        if (r28 == false) goto L74;
        int r6 = f.a;
        int r7 = d(r18, 228);
        r18.setMinimumHeight(r7);
        ViewGroup.LayoutParams r8 = r18.getLayoutParams();
        if (r8 != null) goto L8;
    L10:
        ConstraintLayout.LayoutParams r9 = r27.getLayoutParams();
        if ((r9 instanceof ConstraintLayout.LayoutParams) == false) goto L13;
        ConstraintLayout.LayoutParams r10 = r9;
    L14:
        if (r10 != null) goto L16;
        boolean r11 = false;
    L17:
        if (r11 == false) goto L19;
        r27.setLayoutParams(r27.getLayoutParams());
    L19:
        ConstraintLayout.LayoutParams r12 = r110.getLayoutParams();
        if ((r12 instanceof ConstraintLayout.LayoutParams) == false) goto L22;
        ConstraintLayout.LayoutParams r13 = r12;
    L23:
        if (r13 != null) goto L25;
        boolean r14 = false;
    L26:
        if (r14 == false) goto L28;
        r110.setLayoutParams(r110.getLayoutParams());
    L28:
        r110.setScaleType(ImageView.ScaleType.FIT_CENTER);
        ConstraintLayout.LayoutParams r1 = r20.getLayoutParams();
        if ((r1 instanceof ConstraintLayout.LayoutParams) == false) goto L31;
        ConstraintLayout.LayoutParams r2 = r1;
    L33:
        if (r2 != null) goto L35;
        boolean r3 = false;
    L36:
        if (r3 == false) goto L38;
        r20.setLayoutParams(r20.getLayoutParams());
    L38:
        r20.setGravity(8388627);
        ConstraintLayout.LayoutParams r4 = r21.getLayoutParams();
        if ((r4 instanceof ConstraintLayout.LayoutParams) == false) goto L41;
        ConstraintLayout.LayoutParams r5 = r4;
    L42:
        if (r5 != null) goto L44;
        boolean r15 = false;
    L45:
        if (r15 == false) goto L47;
        r21.setLayoutParams(r21.getLayoutParams());
    L47:
        ConstraintLayout.LayoutParams r30 = r22.getLayoutParams();
        if ((r30 instanceof ConstraintLayout.LayoutParams) == false) goto L50;
        ConstraintLayout.LayoutParams r31 = r30;
    L51:
        if (r31 != null) goto L53;
        boolean r32 = false;
    L54:
        if (r32 == false) goto L56;
        r22.setLayoutParams(r22.getLayoutParams());
    L56:
        ConstraintLayout.LayoutParams r33 = r23.getLayoutParams();
        if ((r33 instanceof ConstraintLayout.LayoutParams) == false) goto L59;
        ConstraintLayout.LayoutParams r34 = r33;
    L60:
        if (r34 != null) goto L62;
        boolean r35 = false;
    L63:
        if (r35 == false) goto L65;
        r23.setLayoutParams(r23.getLayoutParams());
    L65:
        ConstraintLayout.LayoutParams r36 = r26.getLayoutParams();
        if ((r36 instanceof ConstraintLayout.LayoutParams) == false) goto L68;
        r16 = r36;
    L68:
        ConstraintLayout.LayoutParams r37 = r16;
        if (r37 != null) goto L71;
        r17 = false;
    L72:
        if (r17 == false) goto L134;
        r26.setLayoutParams(r26.getLayoutParams());
        return;
    L134:
        return;
    L71:
        ((ViewGroup.MarginLayoutParams) r37).width = d(r18, 32);
        ((ViewGroup.MarginLayoutParams) r37).height = d(r18, 32);
        r37.v = 0;
        r37.i = 0;
        ((ViewGroup.MarginLayoutParams) r37).topMargin = d(r18, 16);
        r37.setMarginEnd(d(r18, 16));
        goto L72
    L62:
        r34.t = 0;
        r34.v = -1;
        r34.i = -1;
        r34.j = r20.getId();
        r34.l = -1;
        r34.setMarginStart(c(r18, 2130971208, 2131166786));
        ((ViewGroup.MarginLayoutParams) r34).topMargin = d(r18, 2);
        ((ViewGroup.MarginLayoutParams) r34).bottomMargin = 0;
        r35 = true;
        goto L63
    L59:
        r34 = null;
        goto L60
    L53:
        r31.t = 0;
        r31.v = -1;
        r31.i = -1;
        r31.j = r20.getId();
        r31.l = -1;
        r31.setMarginStart(c(r18, 2130971208, 2131166786));
        ((ViewGroup.MarginLayoutParams) r31).topMargin = d(r18, 2);
        ((ViewGroup.MarginLayoutParams) r31).bottomMargin = 0;
        r32 = true;
        goto L54
    L50:
        r31 = null;
        goto L51
    L44:
        r5.t = 0;
        r5.v = -1;
        r5.i = -1;
        r5.j = r20.getId();
        r5.l = -1;
        r5.setMarginStart(c(r18, 2130971208, 2131166786));
        ((ViewGroup.MarginLayoutParams) r5).topMargin = d(r18, 2);
        ((ViewGroup.MarginLayoutParams) r5).bottomMargin = 0;
        r15 = true;
        goto L45
    L41:
        r5 = null;
        goto L42
    L35:
        ((ViewGroup.MarginLayoutParams) r2).width = -2;
        r2.t = 0;
        r2.v = -1;
        r2.i = -1;
        r2.j = r27.getId();
        r2.setMarginStart(c(r18, 2130971208, 2131166786));
        ((ViewGroup.MarginLayoutParams) r2).topMargin = d(r18, 0);
        r3 = true;
        goto L36
    L31:
        r2 = null;
        goto L33
    L25:
        ((ViewGroup.MarginLayoutParams) r13).width = d(r18, 300);
        ((ViewGroup.MarginLayoutParams) r13).height = d(r18, 96);
        r13.t = -1;
        r13.v = 0;
        r13.i = 0;
        r13.j = -1;
        ((ViewGroup.MarginLayoutParams) r13).topMargin = d(r18, 80);
        r13.setMarginEnd(-d(r18, 44));
        r14 = true;
        goto L26
    L22:
        r13 = null;
        goto L23
    L16:
        ((ViewGroup.MarginLayoutParams) r10).height = d(r18, 32);
        r10.t = 0;
        r10.i = 0;
        r10.setMarginStart(d(r18, 16));
        ((ViewGroup.MarginLayoutParams) r10).topMargin = d(r18, 16);
        r11 = true;
        goto L17
    L13:
        r10 = null;
        goto L14
    L8:
        if (r8.height == r7) goto L10;
        r8.height = r7;
        r18.setLayoutParams(r8);
        goto L10
    L74:
        int r38 = f.a;
        int r40 = d(r18, 228);
        r18.setMinimumHeight(r40);
        ViewGroup.LayoutParams r41 = r18.getLayoutParams();
        if (r41 != null) goto L78;
    L80:
        ConstraintLayout.LayoutParams r42 = r110.getLayoutParams();
        if ((r42 instanceof ConstraintLayout.LayoutParams) == false) goto L83;
        ConstraintLayout.LayoutParams r43 = r42;
    L84:
        if (r43 != null) goto L86;
        boolean r44 = false;
    L87:
        if (r44 == false) goto L89;
        r110.setLayoutParams(r110.getLayoutParams());
    L89:
        r110.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ConstraintLayout.LayoutParams r45 = r20.getLayoutParams();
        if ((r45 instanceof ConstraintLayout.LayoutParams) == false) goto L92;
        ConstraintLayout.LayoutParams r46 = r45;
    L93:
        if (r46 != null) goto L95;
        boolean r47 = false;
    L96:
        if (r47 == false) goto L98;
        r20.setLayoutParams(r20.getLayoutParams());
    L98:
        r20.setGravity(17);
        Iterator r48 = CollectionsKt.listOf(new View[]{r21, r22, r23}).iterator();
    L100:
        if (r48.hasNext() == false) goto L110;
        View r50 = (View) r48.next();
        ConstraintLayout.LayoutParams r51 = r50.getLayoutParams();
        if ((r51 instanceof ConstraintLayout.LayoutParams) == false) goto L104;
        ConstraintLayout.LayoutParams r52 = r51;
    L105:
        if (r52 != null) goto L107;
        boolean r53 = false;
    L108:
        if (r53 == false) goto L100;
        r50.setLayoutParams(r50.getLayoutParams());
        goto L100
    L107:
        r52.t = 0;
        r52.v = 0;
        r52.i = -1;
        r52.j = r20.getId();
        r52.l = -1;
        r52.setMarginStart(0);
        ((ViewGroup.MarginLayoutParams) r52).topMargin = d(r18, 0);
        ((ViewGroup.MarginLayoutParams) r52).bottomMargin = 0;
        r53 = true;
        goto L108
    L104:
        r52 = null;
        goto L105
    L110:
        ConstraintLayout.LayoutParams r54 = r25.getLayoutParams();
        if ((r54 instanceof ConstraintLayout.LayoutParams) == false) goto L113;
        ConstraintLayout.LayoutParams r55 = r54;
    L114:
        if (r55 != null) goto L116;
        boolean r56 = false;
    L117:
        if (r56 == false) goto L119;
        r25.setLayoutParams(r25.getLayoutParams());
    L119:
        ConstraintLayout.LayoutParams r57 = r24.getLayoutParams();
        if ((r57 instanceof ConstraintLayout.LayoutParams) == false) goto L122;
        r16 = r57;
    L122:
        ConstraintLayout.LayoutParams r58 = r16;
        if (r58 != null) goto L125;
        r17 = false;
    L126:
        if (r17 == false) goto L136;
        r24.setLayoutParams(r24.getLayoutParams());
        return;
    L136:
        return;
    L125:
        r58.v = -1;
        r58.u = r25.getId();
        r58.i = 0;
        r58.j = -1;
        ((ViewGroup.MarginLayoutParams) r58).topMargin = d(r18, 16);
        r58.setMarginEnd(d(r18, 8));
        goto L126
    L116:
        ((ViewGroup.MarginLayoutParams) r55).width = d(r18, 32);
        ((ViewGroup.MarginLayoutParams) r55).height = d(r18, 32);
        r55.t = -1;
        r55.v = 0;
        r55.i = 0;
        r55.j = -1;
        r55.l = -1;
        ((ViewGroup.MarginLayoutParams) r55).topMargin = d(r18, 16);
        r55.setMarginEnd(d(r18, 16));
        ((ViewGroup.MarginLayoutParams) r55).bottomMargin = 0;
        r56 = true;
        goto L117
    L113:
        r55 = null;
        goto L114
    L95:
        ((ViewGroup.MarginLayoutParams) r46).width = -2;
        r46.t = 0;
        r46.v = 0;
        r46.i = 0;
        r46.j = -1;
        r46.setMarginStart(0);
        ((ViewGroup.MarginLayoutParams) r46).topMargin = d(r18, 18);
        r47 = true;
        goto L96
    L92:
        r46 = null;
        goto L93
    L86:
        ((ViewGroup.MarginLayoutParams) r43).width = d(r18, 180);
        ((ViewGroup.MarginLayoutParams) r43).height = d(r18, 128);
        r43.t = 0;
        r43.v = 0;
        r43.i = 0;
        r43.j = -1;
        ((ViewGroup.MarginLayoutParams) r43).topMargin = d(r18, 88);
        r43.setMarginEnd(0);
        r44 = true;
        goto L87
    L83:
        r43 = null;
        goto L84
    L78:
        if (r41.height == r40) goto L80;
        r41.height = r40;
        r18.setLayoutParams(r41);
        goto L80
    }
}
