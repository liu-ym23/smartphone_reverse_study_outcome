package com.bytedance.android.anniex.lite;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.anniex.container.ui.e;
import com.bytedance.android.anniex.lite.container.AnnieXLitePageContainer;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.crash.d;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.service.base.l0;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import ia.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y36.i;
import y36.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/anniex/lite/AnnieXLiteFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Lcom/bytedance/ies/bullet/service/base/l0;", "<init>", "()V", "a", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXLiteFragment extends AppCompatDialogFragment implements l0 {
    public com.bytedance.android.anniex.base.builder.a d;
    public String e;
    public String f;
    public String g;
    public Intent h;
    public AnnieXLitePageContainer i;
    public View j;
    public final Lazy k;
    public final AnnieXLiteFragment$lifecycleObserver$1 l;

    public static final class a {
    }

    static {
    }

    public final String MW() {
        return null;
    }

    public final void setArguments(Bundle r1) {
    }

    public final String B() {
        AnnieXLitePageContainer r0 = this.i;
        if (r0 == null) goto L16;
        String r10 = null;
        String r1 = (String) ((i) new p(r0.getAnnieXContext().f.a, "bundle", null)).b;
        if (r1 != null) goto L15;
        com.bytedance.android.anniex.base.builder.a r11 = this.d;
        if (r11 == null) goto L11;
        Bundle r12 = r11.c;
        if (r12 == null) goto L11;
        r10 = r12.getString("__x_param_bundle");
    L11:
        if (r10 != null) goto L17;
        return "";
    L17:
        return r10;
    L15:
        return r1;
    L16:
        return "";
    }

    public final String getBid() {
        com.bytedance.android.anniex.base.builder.a r0 = this.d;
        if (r0 == null) goto L7;
        String r1 = r0.b;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return this.e;
    }

    public final String getChannel() {
        AnnieXLitePageContainer r0 = this.i;
        if (r0 == null) goto L16;
        String r10 = null;
        String r1 = (String) ((i) new p(r0.getAnnieXContext().f.a, "channel", null)).b;
        if (r1 != null) goto L15;
        com.bytedance.android.anniex.base.builder.a r11 = this.d;
        if (r11 == null) goto L11;
        Bundle r12 = r11.c;
        if (r12 == null) goto L11;
        r10 = r12.getString("__x_param_channel");
    L11:
        if (r10 != null) goto L17;
        return "";
    L17:
        return r10;
    L15:
        return r1;
    L16:
        return "";
    }

    public final String getContainerId() {
        AnnieXLitePageContainer r0 = this.i;
        if (r0 == null) goto L6;
        String r1 = r0.getContainerId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final Uri getSchema() {
        AnnieXLitePageContainer r0 = this.i;
        if (r0 == null) goto L5;
        String r1 = r0.getCurrentUrl();
    L7:
        return UriProtector.parse(r1);
    L5:
        r1 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.android.anniex.lite.AnnieXLiteFragment$lifecycleObserver$1] */
    public AnnieXLiteFragment() {
        this.e = "default_bid";
        this.k = LazyKt.lazy(new AnnieXLiteFragment$pageDelegate$2(this));
        this.l = new AnnieXLiteFragment$lifecycleObserver$1(this);
    }

    public final void close() {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L11;
        d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        AnnieXLitePageContainer r0 = this.i;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.i = null;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        AnnieXLitePageContainer r0 = this.i;
        if (r0 == null) goto L5;
        r0.onPause();
    L5:
        AnnieXLitePageContainer r1 = this.i;
        if (r1 == null) goto L9;
        r1.enterBackground();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        AnnieXLitePageContainer r0 = this.i;
        if (r0 == null) goto L5;
        r0.onResume();
    L5:
        AnnieXLitePageContainer r1 = this.i;
        if (r1 == null) goto L9;
        r1.enterForeground();
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        AnnieXLitePageContainer r0 = this.i;
        if (r0 == null) goto L6;
        r0.onStart();
        return;
    }

    public final void onStop() {
        super/*androidx.fragment.app.DialogFragment*/.onStop();
        AnnieXLitePageContainer r0 = this.i;
        if (r0 == null) goto L6;
        r0.onStop();
        return;
    }

    public final void onDetach() {
        super/*androidx.fragment.app.DialogFragment*/.onDetach();
    }

    public final void S90(DialogInterface r10) {
        Intrinsics.checkNotNullParameter(r10, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r10);
        List<AnnieXLiteFragment> r11 = LitePageService.a;
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        ((ArrayList) LitePageService.a).remove(this);
        AnnieXLitePageContainer r12 = this.i;
        if (r12 == null) goto L5;
        r12.release();
    L5:
        na.b r13 = (na.b) this.k.getValue();
        if (r13 == null) goto L8;
        r13.onRelease();
    L8:
        FragmentActivity r14 = getActivity();
        if (r14 == null) goto L14;
        Lifecycle r15 = r14.getLifecycle();
        if (r15 == null) goto L15;
        r15.removeObserver(this.l);
        return;
    L15:
        return;
    }

    public final void onAttach(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super/*androidx.fragment.app.DialogFragment*/.onAttach(r10);
        FragmentActivity r11 = getActivity();
        if (r11 == null) goto L5;
        Intent r12 = r11.getIntent();
    L6:
        this.h = r12;
        FragmentActivity r13 = getActivity();
        if (r13 == null) goto L12;
        Lifecycle r14 = r13.getLifecycle();
        if (r14 == null) goto L13;
        r14.addObserver(this.l);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r10);
    }

    public final void onCreate(Bundle r10) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r10);
        if (r10 == null) goto L8;
        String r0 = r10.getString("bid");
        if (r0 != null) goto L7;
        r0 = "default_bid";
    L7:
        this.e = r0;
        this.f = r10.getString("__x_inner_schema");
        this.g = r10.getString("__x_session_id");
        com.bytedance.android.anniex.base.builder.a r1 = new com.bytedance.android.anniex.base.builder.a();
        String r11 = this.e;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r1.b = r11;
        FragmentActivity r12 = requireActivity();
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r1.a = r12;
        r1.b(r10);
        this.d = r1;
    L8:
        e.a r13 = e.c;
        Context r14 = getContext();
        String r15 = this.e;
        r13.getClass();
        boolean r16 = e.a.a(r14, r15, "AnnieXLiteFragment");
        AnnieXLitePageContainer r17 = null;
        if (r16 == true) goto L21;
        if (h.p() == false) goto L21;
        HybridLogger r18 = HybridLogger.a;
        HybridLogger.m("AnnieXLiteFragment", "tryInitAnnieXIfNeed failed, bid = " + this.e, null, null, 12);
        dismissAllowingStateLoss();     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r19 = DialogFragmentLancet.sLastShowStack;
        if (r19 == null) goto L45;
        d.d(r19, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L45:
        return;
    L21:
        if (this.i != null) goto L28;
        com.bytedance.android.anniex.base.builder.a r20 = this.d;
        if (r20 == null) goto L25;
        r17 = new AnnieXLitePageContainer(r20);
    L25:
        this.i = r17;
        if (r17 == null) goto L28;
        r17.g = (na.b) this.k.getValue();
    L28:
        AnnieXLitePageContainer r21 = this.i;
        if (r21 == null) goto L39;
        na.b r22 = (na.b) this.k.getValue();
        if (r22 == null) goto L38;
        com.bytedance.android.anniex.base.builder.a r23 = this.d;
        if (r23 != null) goto L35;
    L36:
        new Bundle();
    L37:
        r22.c();
        goto L38
    L35:
        if (r23.c != null) goto L37;
    L38:
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        r21.b = this;
    L39:
        AnnieXLitePageContainer r24 = this.i;
        if (r24 == null) goto L47;
        r24.onCreate(r10);
        return;
    }

    public final Dialog onCreateDialog(Bundle r10) {
        Dialog r11 = super.onCreateDialog(r10);
        Window r0 = r11.getWindow();
        if (r0 == null) goto L5;
        r0.setBackgroundDrawable(new ColorDrawable(0));
        r0.addFlags(256);
    L5:
        return r11;
    }

    public final void onDismiss(DialogInterface r10) {
        S90(r10);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onSaveInstanceState(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "outState");
        super/*androidx.fragment.app.DialogFragment*/.onSaveInstanceState(r10);
        r10.putString("bid", this.e);
        r10.putString("__x_inner_schema", this.f);
    }

    public final void setUserVisibleHint(boolean r10) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r10);
        AnnieXLitePageContainer r0 = this.i;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(r10);
        return;
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        if (getActivity() != null) goto L7;
        String r12 = this.g;
        if (r12 == null) goto L7;
        Map<String, i36.d> r13 = MonitorManager.a;
        MonitorManager.i(this.e, r12, AbsBulletMonitorCallback.ErrStage.Container);
    L7:
        View r14 = this.j;
        if (r14 != null) goto L10;
    L12:
        String r15 = this.f;
        if (r15 == null) goto L18;
        AnnieXLitePageContainer r16 = this.i;
        if (r16 == null) goto L19;
        r16.loadSchema(r15, null);
        return;
    L19:
        return;
    L18:
        return;
    L10:
        if (this.i == null) goto L12;
        Intrinsics.checkNotNullParameter(r14, "view");
        goto L12
    }

    public final void onActivityResult(int r10, int r11, Intent r12) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r10, r11, r12);
        na.b r0 = (na.b) this.k.getValue();
        if (r0 == null) goto L6;
        r0.onActivityResult(r10, r11, r12);
        return;
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        View r13 = r10.inflate(2131558566, r11, false);
        this.j = r13;
        AnnieXLitePageContainer r14 = this.i;
        if (r14 == null) goto L6;
        r14.a(r13);
    L6:
        if (this.j == null) goto L17;
        if (this.i == null) goto L17;
        na.b r15 = (na.b) this.k.getValue();
        if (r15 == null) goto L17;
        Intrinsics.checkNotNull(this.j);
        f.a r16 = r15.b();
        if (r16 == null) goto L17;
        AnnieXLitePageContainer r17 = this.i;
        if (r17 == null) goto L17;
        r17.d(r16);
    L17:
        return this.j;
    }
}
