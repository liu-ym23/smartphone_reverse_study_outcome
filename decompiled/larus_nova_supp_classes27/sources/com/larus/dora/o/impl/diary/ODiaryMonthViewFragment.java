package com.larus.dora.o.impl.diary;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.web.AiChatHostWebService;
import com.larus.dora.o.impl.databinding.LarusDoraOFragmentDiaryMonthBinding;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\tH\u0002J&\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u0014\u0010\u001b\u001a\u00020\u0016*\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020\tH\u0002J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020\u0016H\u0002J\b\u0010(\u001a\u00020 H\u0002J\u0010\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0002J\b\u0010+\u001a\u00020\u0016H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/dora/o/impl/diary/ODiaryMonthViewFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/dora/o/impl/databinding/LarusDoraOFragmentDiaryMonthBinding;", "monthWebFragment", "Lcom/larus/platform/model/webview/AbsWebFragment;", "currentMonth", "", "prevMonthAction", "Landroid/view/View;", "nextMonthAction", "initMonth", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "applyTopSpacing", "setupTitleBar", "updateMonthActions", "applyEnabled", "enabled", "", "shiftMonth", "delta", "", "canShift", "monthAfter", "Ljava/util/Calendar;", "monthTitleText", "inRange", "target", "setupWeb", "bottomReserveDp", "buildMonthUrl", "rawUrl", "onDestroyView", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODiaryMonthViewFragment extends Fragment {
    public static final SimpleDateFormat i = null;
    public LarusDoraOFragmentDiaryMonthBinding d;
    public AbsWebFragment e;
    public String f;
    public View g;
    public View h;

    public static final class a {
    }

    static {
        i = new SimpleDateFormat("yyyy-MM", Locale.getDefault());
    }

    public final String T90() {
        List r0 = StringsKt.split$default(this.f, new char[]{'-'}, false, 0, 6, null);
        String r1 = (String) CollectionsKt.getOrNull(r0, 0);
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r3 = (String) CollectionsKt.getOrNull(r0, 1);
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        String r4 = StringsKt.trimStart(r2, new char[]{'0'});
        if (r1.length() != 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L15;
    L21:
        String r6 = getString(2131896106);
        Intrinsics.checkNotNull(r6);
        return r6;
    L15:
        if (r4.length() != 0) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == true) goto L21;
        String r8 = getString(2131896107, new Object[]{r1, r4});
        Intrinsics.checkNotNull(r8);
        return r8;
    L17:
        r7 = false;
        goto L18
    L12:
        r5 = false;
        goto L13
    }

    public ODiaryMonthViewFragment() {
        this.f = "";
    }

    public final void onDestroyView() {
        super.onDestroyView();
        getContext();
        this.g = null;
        this.h = null;
        this.d = null;
    }

    public static boolean S90(Calendar r2) {
        SimpleDateFormat r0 = i;
        if (r0.format(r2.getTime()).compareTo(r0.format(Calendar.getInstance().getTime())) > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void U90(int r10) {
        SimpleDateFormat r0 = i;
        Date r1 = r0.parse(this.f);
        Calendar r3 = null;
        if (r1 == null) goto L5;
        Calendar r4 = Calendar.getInstance();
        r4.setTime(r1);
        r4.add(2, r10);
    L6:
        if (r4 != null) goto L9;
        return;
    L9:
        if (S90(r4) == true) goto L12;
        FLogger.a.i("ODiaryMonthViewFragment", "month view: ignore shift out of range");
        return;
    L12:
        this.f = r0.format(r4.getTime());
        FLogger.a.i("ODiaryMonthViewFragment", "month view: month -> " + this.f);
        LarusDoraOFragmentDiaryMonthBinding r11 = this.d;
        if (r11 == null) goto L17;
        OFloatingTitleBar r12 = r11.c;
        if (r12 == null) goto L17;
        r12.setCenterTitle(T90());
    L17:
        View r13 = this.g;
        float r2 = 0.3f;
        boolean r5 = false;
        if (r13 == null) goto L33;
        Date r7 = r0.parse(this.f);
        if (r7 == null) goto L22;
        Calendar r8 = Calendar.getInstance();
        r8.setTime(r7);
        r8.add(2, -1);
    L23:
        if (r8 != null) goto L25;
    L27:
        boolean r9 = false;
    L28:
        r13.setEnabled(r9);
        if (r9 == false) goto L31;
        float r14 = 1.0f;
    L32:
        r13.setAlpha(r14);
        goto L33
    L31:
        r14 = 0.3f;
        goto L32
    L25:
        if (S90(r8) != true) goto L27;
        r9 = true;
        goto L28
    L22:
        r8 = null;
    L33:
        View r15 = this.h;
        if (r15 == null) goto L46;
        Date r6 = r0.parse(this.f);
        if (r6 == null) goto L38;
        r3 = Calendar.getInstance();
        r3.setTime(r6);
        r3.add(2, 1);
    L38:
        if (r3 != null) goto L40;
    L42:
        r15.setEnabled(r5);
        if (r5 == false) goto L45;
        r2 = 1.0f;
    L45:
        r15.setAlpha(r2);
        goto L46
    L40:
        if (S90(r3) != true) goto L42;
        r5 = true;
    L46:
        AbsWebFragment r16 = this.e;
        if (r16 == null) goto L50;
        JSONObject r17 = new JSONObject();
        r17.put("month", this.f);
        Unit r18 = Unit.INSTANCE;
        r16.T90("dora.diary.setMonth", r17);
        return;
    L50:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onViewCreated(View r21, Bundle r22) {
        Intrinsics.checkNotNullParameter(r21, "view");
        super.onViewCreated(r21, r22);
        Bundle r0 = getArguments();
        String r3 = null;
        if (r0 == null) goto L5;
        String r1 = r0.getString("dora_o_month_date");
    L6:
        String r4 = "";
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        boolean r6 = false;
        if (r1.length() < 7) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == true) goto L16;
        r1 = null;
    L16:
        if (r1 == null) goto L19;
        String r2 = r1.substring(0, 7);
        if (r2 == null) goto L19;
    L20:
        this.f = r2;
        LarusDoraOFragmentDiaryMonthBinding r7 = this.d;
        if (r7 == null) goto L25;
        OFloatingTitleBar r8 = r7.c;
        if (r8 == null) goto L25;
        r8.setCenterTitle(T90());
        OFloatingTitleBar.k(r8, new q0(this), 2);
        this.g = r8.h(2131246274, -1, new r0(this));
        this.h = r8.h(2131246278, -1, new s0(this));
    L25:
        View r9 = this.g;
        float r10 = 0.3f;
        if (r9 == null) goto L41;
        Date r11 = i.parse(this.f);
        if (r11 == null) goto L30;
        Calendar r12 = Calendar.getInstance();
        r12.setTime(r11);
        r12.add(2, -1);
    L31:
        if (r12 != null) goto L33;
    L35:
        boolean r13 = false;
    L36:
        r9.setEnabled(r13);
        if (r13 == false) goto L39;
        float r14 = 1.0f;
    L40:
        r9.setAlpha(r14);
        goto L41
    L39:
        r14 = 0.3f;
        goto L40
    L33:
        if (S90(r12) != true) goto L35;
        r13 = true;
        goto L36
    L30:
        r12 = null;
    L41:
        View r15 = this.h;
        if (r15 == null) goto L56;
        Date r16 = i.parse(this.f);
        if (r16 == null) goto L46;
        Calendar r17 = Calendar.getInstance();
        r17.setTime(r16);
        r17.add(2, 1);
    L47:
        if (r17 != null) goto L49;
    L51:
        boolean r18 = false;
    L52:
        r15.setEnabled(r18);
        if (r18 == false) goto L55;
        r10 = 1.0f;
    L55:
        r15.setAlpha(r10);
        goto L56
    L49:
        if (S90(r17) != true) goto L51;
        r18 = true;
        goto L52
    L46:
        r17 = null;
    L56:
        LarusDoraOFragmentDiaryMonthBinding r20 = this.d;
        if (r20 == null) goto L62;
        ConstraintLayout r23 = r20.a;
        if (r23 == null) goto L62;
        Resources r24 = getResources();
        final int r25 = (int) ((56 * WindowDisplayMetricsOverride.apply(r24, r24.getDisplayMetrics()).density) + 0.5f);
        ViewCompat.setOnApplyWindowInsetsListener(r23, new p0(this, r25));
        ViewCompat.requestApplyInsets(r23);
    L62:
        Bundle r26 = getArguments();
        if (r26 == null) goto L65;
        String r27 = r26.getString("dora_o_month_h5_url");
    L66:
        Context r28 = getContext();
        if (r28 == null) goto L133;
        LarusDoraOFragmentDiaryMonthBinding r30 = this.d;
        if (r30 == null) goto L129;
        FrameLayout r31 = r30.b;
        if (r31 == null) goto L134;
        if (r27 != null) goto L76;
    L79:
        boolean r32 = true;
    L81:
        if (r32 == false) goto L83;
        FLogger.a.e("ODiaryMonthViewFragment", "month view: h5 url missing");
        return;
    L83:
        AiChatHostWebService r110 = AiChatHostWebService.a;
        AbsWebFragment r111 = r110.a(null);
        if (r111 != null) goto L127;
        FLogger.a.e("ODiaryMonthViewFragment", "month view: host web fragment unavailable");
        return;
    L127:
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L112
        Uri r34 = UriProtector.parse(r27);     // Catch: Throwable -> L112
        String r112 = r34.getPath();     // Catch: Throwable -> L112
        if (r112 != null) goto L90;
        r112 = "";
    L90:
        String r113 = StringsKt.trimEnd(r112, new char[]{'/'});     // Catch: Throwable -> L112
        Uri.Builder r35 = r34.buildUpon().path(r113 + "/month");     // Catch: Throwable -> L112
        Bundle r114 = getArguments();     // Catch: Throwable -> L112
        if (r114 == null) goto L93;
        String r36 = r114.getString("dora_o_month_date");     // Catch: Throwable -> L112
    L94:
        if (r36 != null) goto L96;
        r36 = "";
    L96:
        Uri.Builder r37 = r35.appendQueryParameter("date", r36);     // Catch: Throwable -> L112
        Bundle r115 = getArguments();     // Catch: Throwable -> L112
        if (r115 == null) goto L99;
        r3 = Integer.valueOf(r115.getInt("dora_o_diary_biz_id", 0)).toString();     // Catch: Throwable -> L112
    L99:
        if (r3 == null) goto L102;
        r4 = r3;
    L102:
        Uri.Builder r38 = r37.appendQueryParameter("biz_id", r4).appendQueryParameter("entry", "month_view").appendQueryParameter("month", this.f);     // Catch: Throwable -> L112
        int r40 = m0.a;     // Catch: Throwable -> L112
        Bundle r41 = getArguments();     // Catch: Throwable -> L112
        if (r41 != null) goto L105;
    L107:
        if (r6 == false) goto L109;
        int r42 = 34;
    L110:
        Object r43 = Result.constructor-impl(r38.appendQueryParameter("bottom_reserve", String.valueOf(r42)).build().toString());     // Catch: Throwable -> L112
    L115:
        if (Result.exceptionOrNull-impl(r43) != null) goto L117;
        Object r44 = r43;
    L118:
        Bundle r45 = r110.c(new zt8.b((String) r44, false, false, Integer.valueOf(ContextCompat.getColor(r28, 2131101351)), false, 100));
        if (r45 != null) goto L121;
        FLogger.a.e("ODiaryMonthViewFragment", "month view: web fragment arguments null");
        return;
    L121:
        r111.setArguments(r45);
        this.e = r111;
        FragmentTransaction r46 = getChildFragmentManager().beginTransaction();
        int r47 = r31.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r46, r111, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "dora_o_month_web", r47) == true) goto L125;
        r46.replace(r47, r111, "dora_o_month_web");
    L125:
        r46.commit();
        FLogger.a.i("ODiaryMonthViewFragment", "month view: h5 mounted month=" + this.f);
        return;
    L117:
        FLogger.a.w("ODiaryMonthViewFragment", "month view: build url failed, use raw url");
        r44 = r27;
        goto L118
    L109:
        r42 = 100;
        goto L110
    L105:
        if (r41.getBoolean("dora_o_diary_show_back") != true) goto L107;
        r6 = true;
        goto L107
    L93:
        r36 = null;
    L112:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r43 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L115
    L76:
        if (r27.length() == 0) goto L79;
        r32 = false;
        goto L81
    L134:
        return;
    L129:
        return;
    L133:
        return;
    L65:
        r27 = null;
    L19:
        r2 = i.format(Calendar.getInstance().getTime());
        goto L20
    L12:
        r5 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ConstraintLayout r5 = r2.inflate(2131562229, r3, false);
        int r6 = 2131380274;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r5, 2131380274);
        if (r7 == null) goto L9;
        r6 = 2131380283;
        OFloatingTitleBar r0 = ViewBindings.findChildViewById(r5, 2131380283);
        if (r0 == null) goto L9;
        ConstraintLayout r8 = r5;
        this.d = new LarusDoraOFragmentDiaryMonthBinding(r8, r7, r0);
        return r8;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
