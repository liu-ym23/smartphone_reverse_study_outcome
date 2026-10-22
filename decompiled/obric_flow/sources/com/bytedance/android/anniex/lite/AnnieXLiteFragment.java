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
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.anniex.lite.container.f;
import com.bytedance.ies.bullet.service.base.n;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.obric.launcher.widget.R$id;
import com.obric.launcher.widget.R$layout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import l9.o;
import xc.d;
import xc.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/anniex/lite/AnnieXLiteFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Lcom/bytedance/ies/bullet/service/base/n;", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nAnnieXLiteFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnnieXLiteFragment.kt\ncom/bytedance/android/anniex/lite/AnnieXLiteFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,302:1\n1#2:303\n*E\n"})
public final class AnnieXLiteFragment extends AppCompatDialogFragment implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r3.a f3213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3215c;
    public String d;
    public Intent e;
    public final Lazy f;
    public f g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f3216h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f3217i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AnnieXLiteFragment$lifecycleObserver$1 f3218j;

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.android.anniex.lite.AnnieXLiteFragment$lifecycleObserver$1] */
    public AnnieXLiteFragment() {
        this.f3214b = "default_bid";
        this.f = LazyKt.lazy(new AnnieXLiteFragment$defaultTitleBar$2(this));
        this.f3217i = LazyKt.lazy(new AnnieXLiteFragment$pageDelegate$2(this));
        this.f3218j = new AnnieXLiteFragment$lifecycleObserver$1(this);
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final String d() {
        f r5 = this.g;
        if (r5 == null) goto L15;
        String r10 = null;
        String r11 = (String) new vd.a(r5.getAnnieXContext().f.f21723a, "bundle", null).f22372b;
        if (r11 != null) goto L14;
        r3.a r12 = this.f3213a;
        if (r12 == null) goto L11;
        Bundle r13 = r12.f21654c;
        if (r13 == null) goto L11;
        r10 = r13.getString("__x_param_bundle");
    L11:
        if (r10 != null) goto L13;
        return "";
    L13:
        return r10;
    L14:
        return r11;
    L15:
        return "";
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final String e() {
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final String getBid() {
        r3.a r5 = this.f3213a;
        if (r5 == null) goto L9;
        String r10 = r5.f21653b;
        if (r10 == null) goto L9;
        return r10;
    L9:
        return this.f3214b;
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final String getChannel() {
        f r5 = this.g;
        if (r5 == null) goto L15;
        String r10 = null;
        String r11 = (String) new vd.a(r5.getAnnieXContext().f.f21723a, LynxMonitorService.KEY_CHANNEL, null).f22372b;
        if (r11 != null) goto L14;
        r3.a r12 = this.f3213a;
        if (r12 == null) goto L11;
        Bundle r13 = r12.f21654c;
        if (r13 == null) goto L11;
        r10 = r13.getString("__x_param_channel");
    L11:
        if (r10 != null) goto L13;
        return "";
    L13:
        return r10;
    L14:
        return r11;
    L15:
        return "";
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final String getContainerId() {
        f r5 = this.g;
        if (r5 == null) goto L8;
        String r10 = r5.getContainerId();
        if (r10 == null) goto L10;
        return r10;
    L10:
        return "";
    L8:
        return "";
    }

    @Override // com.bytedance.ies.bullet.service.base.n
    public final Uri getSchema() {
        f r5 = this.g;
        if (r5 == null) goto L5;
        String r10 = r5.getCurrentUrl();
    L7:
        return Uri.parse(r10);
    L5:
        r10 = null;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r5, int r10, Intent r11) {
        super.onActivityResult(r5, r10, r11);
        qo.a.i(this.f3217i.getValue());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super.onAttach(r5);
        FragmentActivity r10 = getActivity();
        if (r10 == null) goto L5;
        Intent r11 = r10.getIntent();
    L6:
        this.e = r11;
        FragmentActivity r12 = getActivity();
        if (r12 == null) goto L12;
        Lifecycle r13 = r12.getLifecycle();
        if (r13 == null) goto L13;
        r13.addObserver(this.f3218j);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        super.onConfigurationChanged(r5);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        if (r10 == null) goto L8;
        String r5 = r10.getString("bid");
        if (r5 != null) goto L7;
        r5 = "default_bid";
    L7:
        this.f3214b = r5;
        this.f3215c = r10.getString("__x_inner_schema");
        this.d = r10.getString("__x_session_id");
        r3.a r11 = new r3.a();
        String r12 = this.f3214b;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r11.f21653b = r12;
        FragmentActivity r13 = requireActivity();
        Intrinsics.checkNotNullParameter(r13, "activity");
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r11.f21652a = r13;
        Intrinsics.checkNotNullParameter(r10, "bundle");
        r11.f21654c.putAll(r10);
        this.f3213a = r11;
    L8:
        f r14 = null;
        if (jm.c.h(getContext(), this.f3214b, "AnnieXLiteFragment") == true) goto L19;
        ConcurrentHashMap r15 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r16 = (e) yc.a.a(e.class, "default_bid");
        if (r16 == null) goto L15;
        d r17 = (d) r16.a(d.class);
        if (r17 == null) goto L15;
        boolean r18 = Intrinsics.areEqual(r17.K0(), Boolean.TRUE);
    L16:
        if (r18 == false) goto L19;
        int r19 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("AnnieXLiteFragment", "tryInitAnnieXIfNeed failed, bid = " + this.f3214b, null, 12);
        dismissAllowingStateLoss();
        return;
    L15:
        r18 = false;
    L19:
        f r20 = this.g;
        Lazy r21 = this.f3217i;
        if (r20 != null) goto L31;
        r3.a r22 = this.f3213a;
        if (r22 == null) goto L24;
        r14 = new f(r22);
    L24:
        this.g = r14;
        if (r14 == null) goto L31;
        if (r21.getValue() == null) goto L31;
        throw new ClassCastException();
    L31:
        f r23 = this.g;
        if (r23 != null) goto L34;
    L38:
        f r24 = this.g;
        if (r24 == null) goto L42;
        r24.onCreate(r10);
        return;
    L42:
        return;
    L34:
        if (r21.getValue() != null) goto L37;
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        r23.f3242b = this;
        goto L38
    L37:
        throw new ClassCastException();
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r5) {
        Dialog r10 = super.onCreateDialog(r5);
        Window r11 = r10.getWindow();
        if (r11 == null) goto L5;
        r11.setBackgroundDrawable(new ColorDrawable(0));
        r11.addFlags(256);
    L5:
        return r10;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r5, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        View r12 = r5.inflate(R$layout.annie_x_fragment_webcast, r10, false);
        this.f3216h = r12;
        if (r12 == null) goto L5;
        FrameLayout r13 = (FrameLayout) r12.findViewById(R$id.anniex_title_bar_container);
    L6:
        o.g(r13, this.g, this.f3214b, (View) this.f.getValue(), getContext());
        f r14 = this.g;
        if (r14 == null) goto L10;
        r14.a(this.f3216h);
    L10:
        if (this.f3216h == null) goto L15;
        if (this.g == null) goto L15;
        qo.a.i(this.f3217i.getValue());
    L15:
        return this.f3216h;
    L5:
        r13 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        f r5 = this.g;
        if (r5 == null) goto L5;
        r5.release();
    L5:
        this.g = null;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r5) {
        Intrinsics.checkNotNullParameter(r5, "dialog");
        super.onDismiss(r5);
        ArrayList r10 = c.f3225a;
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        c.f3225a.remove(this);
        f r11 = this.g;
        if (r11 == null) goto L6;
        r11.release();
    L6:
        if (this.f3217i.getValue() != null) goto L14;
        FragmentActivity r12 = getActivity();
        if (r12 == null) goto L15;
        Lifecycle r13 = r12.getLifecycle();
        if (r13 == null) goto L16;
        r13.removeObserver(this.f3218j);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        throw new ClassCastException();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        f r5 = this.g;
        if (r5 == null) goto L5;
        r5.onVisibleChange(false, Boolean.FALSE);
    L5:
        f r10 = this.g;
        if (r10 == null) goto L9;
        r10.enterBackground();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        f r5 = this.g;
        if (r5 == null) goto L5;
        r5.a();
    L5:
        f r10 = this.g;
        if (r10 == null) goto L9;
        r10.enterForeground();
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r5) {
        Intrinsics.checkNotNullParameter(r5, "outState");
        super.onSaveInstanceState(r5);
        r5.putString("bid", this.f3214b);
        r5.putString("__x_inner_schema", this.f3215c);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        f r5 = this.g;
        if (r5 == null) goto L6;
        r5.b();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r5, Bundle r10) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r10);
        if (getActivity() != null) goto L7;
        String r11 = this.d;
        if (r11 == null) goto L7;
        LinkedHashMap r12 = com.bytedance.android.anniex.monitor.c.f3335a;
        com.bytedance.android.anniex.monitor.c.t(this.f3214b, r11);
    L7:
        View r13 = this.f3216h;
        if (r13 != null) goto L10;
    L12:
        String r14 = this.f3215c;
        if (r14 == null) goto L18;
        f r15 = this.g;
        if (r15 == null) goto L19;
        r15.loadSchema(r14, null);
        return;
    L19:
        return;
    L18:
        return;
    L10:
        if (this.g == null) goto L12;
        Intrinsics.checkNotNullParameter(r13, "view");
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final void setArguments(Bundle r5) {
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r5) {
        super.setUserVisibleHint(r5);
        f r10 = this.g;
        if (r10 == null) goto L6;
        r10.a(r5);
        return;
    }
}
