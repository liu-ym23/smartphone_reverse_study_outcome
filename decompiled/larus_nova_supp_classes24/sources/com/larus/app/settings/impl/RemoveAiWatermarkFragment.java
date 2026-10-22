package com.larus.app.settings.impl;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.app.settings.impl.databinding.LarusPageRemoveAiWatermarkBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0016\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0007H\u0002J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u001a\u0010#\u001a\u00020\u00162\u0010\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010&\u0018\u00010%H\u0002J\b\u0010'\u001a\u00020\u0016H\u0002J \u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0007H\u0002J\u0018\u0010,\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\b\u0010-\u001a\u00020\u0016H\u0002J\b\u0010.\u001a\u00020\u0007H\u0016J\b\u0010/\u001a\u00020*H\u0016J\b\u00100\u001a\u00020\u0016H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/larus/app/settings/impl/RemoveAiWatermarkFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/app/settings/impl/databinding/LarusPageRemoveAiWatermarkBinding;", "documentEnabled", "", "mediaEnabled", "watermarkConfigVersions", "", "", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "readPreloadedSwitchState", "Lkotlin/Pair;", "setupSwitchVisibility", "refreshSwitchState", "onGetConfigFailed", "renderSwitchState", "renderSwitchChecked", "configType", "isChecked", "updateWatermarkConfig", "isOn", "captureVersions", "configs", "", "Lcom/larus/uaigc/api/SettingWatermarkConfigItem;", "setupSwitchEvents", "onWatermarkRowClicked", "watermarkType", "", "currentEnabled", "showRemoveAiWatermarkConfirmDialog", "setupSubtitle", "autoLogEnterPage", "getCurrentPageName", "onDestroyView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class RemoveAiWatermarkFragment extends TraceFragment {
    public static final /* synthetic */ int i = 0;
    public LarusPageRemoveAiWatermarkBinding e;
    public boolean f;
    public boolean g;
    public final Map<Integer, Long> h;

    public final boolean S90() {
        return false;
    }

    public final String k() {
        return "ai_watermark_setting_page";
    }

    public final void onDestroyView() {
        this.e = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public RemoveAiWatermarkFragment() {
        this.h = new LinkedHashMap();
    }

    public static void U90(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static final void V90(RemoveAiWatermarkFragment r5, List r6) {
        r5.getClass();
        if (r6 == null) goto L11;
        Iterator r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L17;
        com.larus.uaigc.api.v r0 = (com.larus.uaigc.api.v) r7.next();
        if (r0 == null) goto L6;
        r5.h.put(Integer.valueOf(r0.a()), Long.valueOf(r0.c()));
        goto L6
    L17:
        return;
    }

    public final void X90(int r3, boolean r4) {
        if (r3 != 150) goto L5;
        this.g = r4;
        LarusPageRemoveAiWatermarkBinding r5 = this.e;
        if (r5 == null) goto L21;
        ItemTextArrow r6 = r5.c;
        if (r6 == null) goto L22;
        String r7 = v.d(getContext(), r4);
        int r0 = ItemTextArrow.k;
        r6.Z5(r7, null);
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (r3 != 151) goto L23;
        this.f = r4;
        LarusPageRemoveAiWatermarkBinding r8 = this.e;
        if (r8 == null) goto L18;
        ItemTextArrow r9 = r8.b;
        if (r9 == null) goto L19;
        String r10 = v.d(getContext(), r4);
        int r1 = ItemTextArrow.k;
        r9.Z5(r10, null);
        return;
    L19:
        return;
    L18:
        return;
    }

    public final void Y90(boolean r4, boolean r5) {
        this.f = r5;
        this.g = r4;
        LarusPageRemoveAiWatermarkBinding r0 = this.e;
        if (r0 == null) goto L7;
        ItemTextArrow r1 = r0.b;
        if (r1 == null) goto L7;
        String r6 = v.d(getContext(), r5);
        int r2 = ItemTextArrow.k;
        r1.Z5(r6, null);
    L7:
        LarusPageRemoveAiWatermarkBinding r7 = this.e;
        if (r7 == null) goto L13;
        ItemTextArrow r8 = r7.c;
        if (r8 == null) goto L14;
        String r9 = v.d(getContext(), r4);
        int r3 = ItemTextArrow.k;
        r8.Z5(r9, null);
        return;
    L14:
        return;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        LarusPageRemoveAiWatermarkBinding r10 = this.e;
        if (r10 != null) goto L5;
        return;
    L5:
        NovaTitleBarEx.b6(r10.f, 2131241477, false, null, null, new w(this), 14);
        by7.a r11 = new by7.a("enter_page");
        r11.d("current_page", "ai_watermark_setting_page");
        r11.d("enter_method", "setting");
        r11.b();
        LarusPageRemoveAiWatermarkBinding r12 = this.e;
        if (r12 == null) goto L25;
        Context r13 = getContext();
        if (r13 == null) goto L25;
        TextView r0 = r12.e;
        int r1 = c0.a;
        String r2 = r13.getString(2131897438);
        String r3 = "";
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        r0.setText(r2);
        UrlSpanTextView r4 = r12.d;
        String r5 = r13.getString(2131897437);
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        r4.setText(r5);
        ItemTextArrow r6 = r12.b;
        String r7 = r13.getString(2131897441);
        if (r7 != null) goto L20;
        r7 = "";
    L20:
        r6.setText(r7);
        ItemTextArrow r14 = r12.c;
        String r15 = r13.getString(2131897439);
        if (r15 == null) goto L24;
        r3 = r15;
    L24:
        r14.setText(r3);
    L25:
        kq9.u r16 = z2.a.watermarkRemovalConfig();
        LarusPageRemoveAiWatermarkBinding r17 = this.e;
        int r19 = 0;
        if (r17 == null) goto L34;
        ItemTextArrow r20 = r17.b;
        if (r20 == null) goto L34;
        if (Intrinsics.areEqual(r16.c(), Boolean.FALSE) == true) goto L32;
        int r21 = 0;
    L33:
        r20.setVisibility(r21);
        goto L34
    L32:
        r21 = 8;
    L34:
        LarusPageRemoveAiWatermarkBinding r22 = this.e;
        if (r22 == null) goto L43;
        ItemTextArrow r23 = r22.c;
        if (r23 == null) goto L43;
        if (Intrinsics.areEqual(r16.b(), Boolean.FALSE) == false) goto L42;
        r19 = 8;
    L42:
        r23.setVisibility(r19);
    L43:
        LarusPageRemoveAiWatermarkBinding r24 = this.e;
        if (r24 == null) goto L47;
        r24.b.setOnClickListener(new x(this));
        r24.c.setOnClickListener(new y(this));
    L47:
        Bundle r25 = getArguments();
        if (r25 != null) goto L51;
    L56:
        Pair r26 = null;
    L57:
        if (r26 == null) goto L59;
        Y90(((Boolean) r26.getFirst()).booleanValue(), ((Boolean) r26.getSecond()).booleanValue());
    L59:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new RemoveAiWatermarkFragment$refreshSwitchState$1(this, null), 3, null);
        return;
    L51:
        if (r25.containsKey("extra_watermark_media_enabled") == false) goto L56;
        if (r25.containsKey("extra_watermark_document_enabled") == false) goto L56;
        r26 = TuplesKt.to(Boolean.valueOf(r25.getBoolean("extra_watermark_media_enabled")), Boolean.valueOf(r25.getBoolean("extra_watermark_document_enabled")));
        goto L57
    }

    public final void W90(final String r21, final int r22, boolean r23) {
        boolean r4 = !r23;
        if (r4 == false) goto L5;
        String r5 = "on";
    L6:
        by7.a r6 = new by7.a("ai_watermark_switch_click");
        String r7 = "current_page";
        r6.d("current_page", "ai_watermark_setting_page");
        if (Intrinsics.areEqual(r21, "document") == false) goto L9;
        Object r10 = "ai_watermark_office_doc";
    L10:
        r6.d("switch_type", r10);
        r6.d("to_status", r5);
        r6.b();
        if (r4 == false) goto L70;
        X90(r22, true);
        Context r8 = getContext();
        if (r8 == null) goto L77;
        final Dialog r11 = new Dialog(r8);
        Window r13 = r11.getWindow();
        if (r13 == null) goto L18;
        r13.setBackgroundDrawable(new ColorDrawable(0));
    L18:
        r11.setCanceledOnTouchOutside(true);
        r11.setOnCancelListener(new z(r21, this, r22));
        LinearLayout r14 = new LinearLayout(r8);
        r14.setOrientation(1);
        r14.setGravity(1);
        r14.setPadding(v.a(24, r8), v.a(24, r8), v.a(24, r8), v.a(20, r8));
        int r3 = v19.c.a(2130970532, r8, 2131102539);
        float r9 = v.a(20, r8);
        GradientDrawable r12 = new GradientDrawable();
        r12.setColor(r3);
        r12.setCornerRadius(r9);
        r14.setBackground(r12);
        TextView r15 = new TextView(r8);
        int r16 = c0.a;
        String r17 = r8.getString(2131897447);
        if (r17 != null) goto L21;
        r17 = "";
    L21:
        r15.setText(r17);
        r15.setGravity(17);
        r15.setTextColor(v19.c.a(2130972079, r8, 2131103136));
        r15.setTextSize(18.0f);
        r15.setTypeface(Typeface.DEFAULT_BOLD);
        TextView r19 = new TextView(r8);
        if (Intrinsics.areEqual(r21, "document") == false) goto L28;
        CharSequence r110 = r8.getString(2131897442);
        if (r110 != null) goto L26;
        r110 = "";
        CharSequence r111 = r110;
    L27:
        r7 = "current_page";
    L45:
        r19.setText(r110);
        r19.setGravity(17);
        r19.setTextColor(v19.c.a(2130972082, r8, 2131103146));
        r19.setTextSize(15.0f);
        Typeface r112 = Typeface.create("PingFang SC", 0);
        int r113 = Build.VERSION.SDK_INT;
        if (r113 < 28) goto L48;
        r112 = Typeface.create(r112, 400, false);
        Intrinsics.checkNotNull(r112);
    L49:
        r19.setTypeface(r112);
        r19.setLetterSpacing(0.0f);
        r19.setLineSpacing(v.a(2, r8), 1.0f);
        if (r113 < 26) goto L52;
        r19.setJustificationMode(0);
    L52:
        TextView r114 = new TextView(r8);
        CharSequence r115 = r8.getString(2131897443);
        if (r115 != null) goto L55;
        r115 = r111;
    L55:
        r114.setText(r115);
        r114.setGravity(17);
        r114.setTextColor(-1);
        r114.setTextSize(16.0f);
        r114.setTypeface(Typeface.DEFAULT_BOLD);
        int r116 = v19.c.a(2130972123, r8, 2131103203);
        float r117 = v.a(12, r8);
        GradientDrawable r118 = new GradientDrawable();
        r118.setColor(r116);
        r118.setCornerRadius(r117);
        r114.setBackground(r118);
        r114.setOnClickListener(new a0(r11, r21, this, r22));
        TextView r119 = new TextView(r8);
        CharSequence r120 = r8.getString(2131897444);
        if (r120 != null) goto L58;
        r120 = r111;
    L58:
        r119.setText(r120);
        r119.setGravity(17);
        r119.setTextColor(v19.c.a(2130972082, r8, 2131103146));
        r119.setTextSize(16.0f);
        r119.setOnClickListener(new b0(r21, this, r22, r11));
        r14.addView(r15, -1, -2);
        LinearLayout.LayoutParams r20 = new LinearLayout.LayoutParams(-1, -2);
        r20.topMargin = v.a(8, r8);
        Unit r121 = Unit.INSTANCE;
        r14.addView(r19, r20);
        LinearLayout.LayoutParams r24 = new LinearLayout.LayoutParams(-1, v.a(48, r8));
        r24.topMargin = v.a(24, r8);
        r14.addView(r114, r24);
        LinearLayout.LayoutParams r25 = new LinearLayout.LayoutParams(-1, v.a(48, r8));
        r25.topMargin = v.a(8, r8);
        r14.addView(r119, r25);
        r11.setContentView(r14);
        if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L73;
        DialogLancet.handleBlockedDialogShow(r11);
    L63:
        by7.a r26 = new by7.a("popup_show");
        if (Intrinsics.areEqual(r21, "document") == false) goto L66;
        Object r122 = "ai_watermark_office_doc";
    L67:
        r26.d("popup_type", r122);
        r26.d(r7, "ai_watermark_setting_page");
        r26.d("enter_method", "setting");
        r26.b();
        Window r1 = r11.getWindow();
        if (r1 == null) goto L75;
        Resources r27 = r8.getResources();
        r1.setLayout(WindowDisplayMetricsOverride.apply(r27, r27.getDisplayMetrics()).widthPixels - v.a(48, r8), -2);
        return;
    L75:
        return;
    L66:
        r122 = "ai_watermark_image_video";
        goto L67
    L73:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L72
    L62:
        DialogLancet.beforeDialogShow(r11);
        r11.show();
        DialogLancet.afterDialogShow(r11);
        goto L63
    L48:
        Intrinsics.checkNotNull(r112);
        goto L49
    L26:
        r111 = "";
        goto L27
    L28:
        String r123 = r8.getString(2131897440);
        if (r123 != null) goto L31;
        r123 = "";
    L31:
        r111 = "";
        MatchResult r124 = Regex.find$default(new Regex("。\\s+"), r123, 0, 2, null);
        if (r124 == null) goto L36;
        IntRange r29 = r124.getRange();
        if (r29 == null) goto L36;
        int r125 = 1;
        int r30 = r29.getLast() + 1;
    L37:
        if (r30 < 0) goto L39;
        Intrinsics.checkNotNull(r124);
        String r126 = r123.substring(0, r124.getRange().getFirst() + r125) + "\n\n" + r123.substring(r30);
    L40:
        SpannableString r127 = new SpannableString(r126);
        if (r30 < 0) goto L44;
        r127.setSpan(new ForegroundColorSpan(v19.c.a(2130972079, r8, 2131103136)), r126.length() - (r123.length() - r30), r126.length(), 33);
    L44:
        r110 = r127;
        goto L45
    L39:
        r126 = r123;
    L36:
        r125 = 1;
        r30 = -1;
        goto L37
    L77:
        return;
    L70:
        X90(r22, false);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new RemoveAiWatermarkFragment$updateWatermarkConfig$1(r22, this, false, null), 3, null);
        return;
    L9:
        r10 = "ai_watermark_image_video";
        goto L10
    L5:
        r5 = "off";
        goto L6
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131563065, r9, false);
        int r12 = 2131384259;
        if (((LinearLayout) ViewBindings.findChildViewById(r11, 2131384259)) == null) goto L25;
        r12 = 2131384260;
        ItemTextArrow r2 = ViewBindings.findChildViewById(r11, 2131384260);
        if (r2 == null) goto L25;
        r12 = 2131384262;
        ItemTextArrow r3 = ViewBindings.findChildViewById(r11, 2131384262);
        if (r3 == null) goto L25;
        r12 = 2131384263;
        if (ViewBindings.findChildViewById(r11, 2131384263) == null) goto L25;
        r12 = 2131384264;
        if (ViewBindings.findChildViewById(r11, 2131384264) == null) goto L25;
        r12 = 2131384265;
        UrlSpanTextView r4 = ViewBindings.findChildViewById(r11, 2131384265);
        if (r4 == null) goto L25;
        r12 = 2131384266;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r11, 2131384266);
        if (r5 == null) goto L25;
        r12 = 2131384267;
        if (ViewBindings.findChildViewById(r11, 2131384267) == null) goto L25;
        r12 = 2131384268;
        if (((ImageView) ViewBindings.findChildViewById(r11, 2131384268)) == null) goto L25;
        r12 = 2131388807;
        NovaTitleBarEx r6 = ViewBindings.findChildViewById(r11, 2131388807);
        if (r6 == null) goto L25;
        LinearLayout r13 = (LinearLayout) r11;
        this.e = new LarusPageRemoveAiWatermarkBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
