package com.larus.dora.o.impl.health;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.web.AiChatHostWebService;
import com.larus.dora.o.impl.health.calendar.OHealthCalendarDialog;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zt8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u000b\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006!"}, d2 = {"Lcom/larus/dora/o/impl/health/OHealthTabFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "webFragment", "Lcom/larus/platform/model/webview/AbsWebFragment;", "calendarDialog", "Lcom/larus/dora/o/impl/health/calendar/OHealthCalendarDialog;", "receiverRegistered", "", "openCalendarReceiver", "com/larus/dora/o/impl/health/OHealthTabFragment$openCalendarReceiver$1", "Lcom/larus/dora/o/impl/health/OHealthTabFragment$openCalendarReceiver$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "mountWeb", "url", "", "buildUrl", "showCalendar", "date", "notifyDateSelected", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OHealthTabFragment extends Fragment {
    public static final /* synthetic */ int h = 0;
    public AbsWebFragment d;
    public OHealthCalendarDialog e;
    public boolean f;
    public final OHealthTabFragment$openCalendarReceiver$1 g;

    public static final class a {
    }

    static {
    }

    public final void onDestroyView() {
        OHealthCalendarDialog r0 = this.e;
        if (r0 != null) goto L16;
    L10:
        this.e = null;
        Context r1 = getContext();
        if (this.f == false) goto L14;
        if (r1 == null) goto L14;
        LocalBroadcastManager.getInstance(r1).unregisterReceiver(this.g);
    L14:
        this.f = false;
        this.d = null;
        super.onDestroyView();
        return;
    L16:
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L10;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    public OHealthTabFragment() {
        this.g = new OHealthTabFragment$openCalendarReceiver$1(this);
    }

    public final void onViewCreated(View r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r18, "view");
        super.onViewCreated(r18, r110);
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r1 = r0.getString("dora_o_health_url");
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        String r4 = r1;
        if (StringsKt.isBlank(r4) == false) goto L12;
        FLogger.a.w("OHealthH5", "health url empty, nothing to mount");
        return;
    L12:
        ViewGroup r6 = (ViewGroup) r18.findViewById(2131369772);
        ViewCompat.setOnApplyWindowInsetsListener(r6, new x69.a());
        ViewCompat.requestApplyInsets(r6);
        Intrinsics.checkNotNull(r6);
        AbsWebFragment r3 = AiChatHostWebService.a.a(null);
        if (r3 != null) goto L37;
        FLogger.a.e("OHealthH5", "host web fragment unavailable");
    L26:
        boolean r2 = false;
    L32:
        if (r2 == true) goto L35;
        FLogger.a.e("OHealthH5", "mount health h5 failed, leave empty");
        return;
    L35:
        LocalBroadcastManager.getInstance(r18.getContext()).registerReceiver(this.g, new IntentFilter("com.larus.dora.health.OPEN_CALENDAR"));
        this.f = true;
        return;
    L37:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L17
        Object r7 = Result.constructor-impl(UriProtector.parse(r4).buildUpon().appendQueryParameter("embedded", "1").appendQueryParameter("bottom_reserve", "100").build().toString());     // Catch: Throwable -> L17
    L20:
        if (Result.exceptionOrNull-impl(r7) != null) goto L22;
        Object r8 = r7;
    L23:
        String r9 = (String) r8;
        Bundle r10 = AiChatHostWebService.a.c(new b(r9, false, false, Integer.valueOf(ContextCompat.getColor(r6.getContext(), 2131101351)), false, 100));
        if (r10 != null) goto L27;
        FLogger.a.e("OHealthH5", "web fragment arguments null");
        goto L26
    L27:
        r10.putString("enable_error_view", "1");
        r3.setArguments(r10);
        this.d = r3;
        FragmentTransaction r11 = getChildFragmentManager().beginTransaction();
        int r12 = r6.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r11, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "dora_o_health_web", r12) == true) goto L31;
        r11.replace(r12, r3, "dora_o_health_web");
    L31:
        r11.commit();
        FLogger.a.i("OHealthH5", "mount url=".concat(r9));
        r2 = true;
        goto L32
    L22:
        FLogger.a.w("OHealthH5", "build url failed, use raw url");
        r8 = r4;
    L17:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L5:
        r1 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131562230, r3, false);
    }
}
