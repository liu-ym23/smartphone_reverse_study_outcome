package com.bytedance.android.annie.business.container;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.container.fragment.p;
import com.bytedance.android.annie.container.fragment.q;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/annie/business/container/AnnieXLiveDialog;", "Lcom/bytedance/android/annie/api/container/HybridDialog;", "Landroid/content/DialogInterface$OnShowListener;", "Lcom/bytedance/android/annie/container/fragment/q;", "Lcom/bytedance/android/annie/container/fragment/p;", "<init>", "()V", "a", "annie-mix-glue_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieXLiveDialog extends HybridDialog implements DialogInterface.OnShowListener, q, p {
    public i d;
    public AnnieXLiveContext e;
    public com.bytedance.android.annie.business.ability.schema.model.a f;
    public com.bytedance.android.anniex.container.d g;
    public t36.d h;
    public AnnieXLiveHybridComponent i;
    public String j;
    public Function0<Unit> k;
    public List<IHybridComponent.a> l;
    public View m;
    public final com.bytedance.android.annie.container.dialog.l n;
    public final AnnieXLiveDialog$popupComponent$1 o;
    public final List<HybridDialog.a> p;
    public m7.a q;
    public m7.b r;
    public m7.c s;
    public boolean t;
    public v7.b u;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog, com.bytedance.android.annie.api.card.IHybridComponent
    public final boolean isPopup() {
        return true;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final String getBizKey() {
        AnnieXLiveContext r0 = this.e;
        if (r0 == null) goto L6;
        String r1 = r0.getBizKey();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "host";
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final IHybridComponent getHybridComponent() {
        AnnieXLiveHybridComponent r0 = this.i;
        if ((r0 instanceof AnnieXLiveHybridComponent) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog, com.bytedance.android.annie.api.card.IHybridComponent
    public final void release() {
        i r0 = this.d;
        if (r0 == null) goto L6;
        r0.p();
        return;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.android.annie.business.container.AnnieXLiveDialog$popupComponent$1] */
    public AnnieXLiveDialog() {
        this.j = "";
        this.n = ((d9.b) Annie.getService(d9.b.class, "webcast")).P();
        this.o = new AnnieXLiveDialog$popupComponent$1(this);
        this.p = new ArrayList();
        this.t = true;
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.n.onDestroyProxy();
        if (this.n.needAdapterStatusBarColor() == true) goto L5;
    L11:
        this.q = null;
        this.r = null;
        this.s = null;
        com.bytedance.android.annie.container.dialog.k.c(this);
        Function0<Unit> r1 = this.k;
        if (r1 == null) goto L14;
        r1.invoke();
    L14:
        i r10 = this.d;
        if (r10 == null) goto L17;
        r10.onDestroy();
    L17:
        this.l = null;
        release();
        return;
    L5:
        if (com.bytedance.android.annie.ng.g.g == false) goto L11;
        com.bytedance.android.annie.ng.g.b().getClass();
        if (com.bytedance.android.annie.ng.e.a.k == false) goto L11;
        if (this.n.getModStatusBar() == false) goto L11;
        com.bytedance.android.annie.util.i.h(getActivity());
        this.n.setModStatusBar(false);
        goto L11
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.n.onDestroyViewProxy();
    }

    public final void onDetach() {
        super.onDetach();
        i r0 = this.d;
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        i r0 = this.d;
        if (r0 == null) goto L6;
        r0.onPause();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        i r0 = this.d;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        i r0 = this.d;
        if (r0 == null) goto L6;
        r0.onStart();
        return;
    }

    public final void onStop() {
        super.onStop();
        i r0 = this.d;
        if (r0 == null) goto L6;
        r0.onStop();
        return;
    }

    @Override // com.bytedance.android.annie.container.fragment.q
    public final v7.b getLoadingFragment() {
        return this.u;
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void T90(HybridDialog.a r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        ((ArrayList) this.p).add(r10);
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void U90(boolean r10) {
        setCancelable(r10);
        Dialog r0 = getDialog();
        if (r0 == null) goto L6;
        r0.setCanceledOnTouchOutside(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void V90(boolean r10) {
        com.bytedance.android.anniex.container.d r0 = this.g;
        if (r0 == null) goto L6;
        r0.h = r10;
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void W90(boolean r10) {
        com.bytedance.android.anniex.container.d r0 = this.g;
        if (r0 == null) goto L6;
        r0.i = r10;
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void X90(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "onDestroy");
        this.k = r10;
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void Y90(boolean r10) {
        com.bytedance.android.anniex.container.d r0 = this.g;
        if (r0 == null) goto L9;
        ab.a r1 = r0.j;
        if (r1 == null) goto L10;
        r1.C = new y36.a(Boolean.valueOf(r10));
        return;
    L10:
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void Z90(boolean r10) {
        com.bytedance.android.anniex.container.d r0 = this.g;
        if (r0 == null) goto L37;
        View r1 = r0.getRootView();
        ImageView r11 = null;
        if (r1 == null) goto L7;
        ImageView r12 = (ImageView) r1.findViewById(2131363002);
    L8:
        View r13 = r0.getRootView();
        if (r13 == null) goto L11;
        r11 = (ImageView) r13.findViewById(2131362987);
    L11:
        int r14 = 8;
        if (r0.canGoBack() == false) goto L31;
        ab.a r15 = r0.j;
        if (r15 == null) goto L24;
        y36.a r16 = r15.b0;
        if (r16 == null) goto L20;
        Boolean r17 = (Boolean) ((y36.i) r16).b;
        if (r17 == null) goto L20;
        boolean r18 = r17.booleanValue();
    L21:
        boolean r19 = true;
        if (r18 != true) goto L24;
    L25:
        if (r19 == false) goto L31;
        if (r11 == null) goto L39;
        if (r10 == false) goto L30;
        r14 = 0;
    L30:
        r11.setVisibility(r14);
        return;
    L39:
        return;
    L20:
        r18 = false;
    L24:
        r19 = false;
    L31:
        if (r12 == null) goto L40;
        if (r10 == false) goto L35;
        r14 = 0;
    L35:
        r12.setVisibility(r14);
        return;
    L40:
        return;
    L7:
        r12 = null;
        goto L8
    }

    public final void ba0(DialogInterface r10) {
        Intrinsics.checkNotNullParameter(r10, "dialog");
        super.onDismiss(r10);
        HybridLogger r0 = HybridLogger.a;
        Map r1 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, this.j));
        AnnieXLiveContext r11 = this.e;
        if (r11 == null) goto L5;
        com.bytedance.ies.bullet.base.utils.logger.a r12 = r11.getLogContext();
    L6:
        HybridLogger.k("AnnieXLiveDialog", "onDismiss", r1, r12);
        Iterator r13 = ((ArrayList) this.p).iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        ((HybridDialog.a) r13.next()).onDismiss();
        goto L8
    L10:
        com.bytedance.android.anniex.container.d r14 = this.g;
        if (r14 == null) goto L13;
        r14.onDismiss(r10);
    L13:
        s26.d r15 = s26.d.c;
        com.bytedance.android.anniex.base.service.c r16 = s26.d.c.d("caijing", com.bytedance.android.anniex.base.service.c.class);
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.bytedance.android.annie.container.fragment.p
    public final void enableClose(boolean r10) {
        com.bytedance.android.anniex.container.d r0 = this.g;
        if (r0 == null) goto L6;
        r0.interceptBackPress(!r10);
        return;
    }

    public final void onActivityCreated(Bundle r10) {
        super.onActivityCreated(r10);
        this.n.onActivityCreatedProxy(r10);
        if (com.bytedance.android.annie.ng.g.g == true) goto L5;
        return;
    L5:
        i r0 = this.d;
        if (r0 == null) goto L9;
        r0.onActivityCreated(r10);
    L9:
        if (getShowsDialog() == false) goto L14;
        Dialog r11 = getDialog();
        if (r11 == null) goto L15;
        int r1 = t7.a.a;
        r11.setOnShowListener(new t7.b(this));
        return;
    L15:
        return;
    }

    public final void onAttach(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super.onAttach(r10);
        if (com.bytedance.android.annie.ng.g.g == true) goto L9;
        HybridLogger r11 = HybridLogger.a;
        Map r12 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MSG, "===onAttach: 未初始化直播"));
        AnnieXLiveContext r13 = this.e;
        if (r13 == null) goto L7;
        com.bytedance.ies.bullet.base.utils.logger.a r14 = r13.getLogContext();
    L8:
        HybridLogger.g("AnnieXLiveDialog", "AnnieManager_init_error", r12, r14);
        goto L9
    L7:
        r14 = null;
    L9:
        com.bytedance.android.anniex.assemble.a r15 = com.bytedance.android.anniex.assemble.a.a;
        Function1<com.bytedance.android.anniex.base.builder.c, Unit> r16 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r16, "block");
        com.bytedance.android.anniex.base.builder.c r17 = new com.bytedance.android.anniex.base.builder.c();
        r16.invoke(r17);
        com.bytedance.android.anniex.container.d r18 = new com.bytedance.android.anniex.container.d(r17);
        m7.a r19 = this.q;
        if (r19 == null) goto L12;
        r19.d = r18;
    L12:
        m7.b r20 = this.r;
        if (r20 == null) goto L15;
        r20.d = r18;
    L15:
        m7.c r21 = this.s;
        if (r21 == null) goto L18;
        r21.d = r18;
    L18:
        r18.d(this.o);
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        r18.c = this;
        this.g = r18;
        AnnieXLiveContext r22 = this.e;
        if (r22 == null) goto L23;
        b7.b r23 = r22.getCommonLifecycle();
        if (r23 == null) goto L23;
        r23.onContainerInitEnd();
    L23:
        com.bytedance.android.anniex.container.d r24 = this.g;
        if (r24 == null) goto L26;
        r24.onAttachToWindow();
    L26:
        HybridLogger r25 = HybridLogger.a;
        AnnieXLiveContext r26 = this.e;
        if (r26 == null) goto L29;
        com.bytedance.ies.bullet.base.utils.logger.a r27 = r26.getLogContext();
    L30:
        HybridLogger.k("AnnieXLiveDialog", "container_init_end", null, r27);
        return;
    L29:
        r27 = null;
        goto L30
    }

    public final void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r10);
        i r0 = this.d;
        if (r0 == null) goto L6;
        r0.onConfigurationChanged(r10);
        return;
    }

    public final void onCreate(Bundle r12) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        if (com.bytedance.ies.bullet.service.base.h.J() == true) goto L5;
    L13:
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r10 = Result.exceptionOrNull-impl(r1);
        Unit r11 = null;
        if (r10 == null) goto L24;
        HybridLogger r13 = HybridLogger.a;
        String r14 = "enableDialogRestoreInstanceState error :" + r10.getMessage();
        AnnieXLiveContext r15 = this.e;
        if (r15 == null) goto L22;
        com.bytedance.ies.bullet.base.utils.logger.a r16 = r15.getLogContext();
    L23:
        HybridLogger.g("AnnieXLiveDialog", r14, null, r16);
        goto L24
    L22:
        r16 = null;
    L24:
        HybridLogger r17 = HybridLogger.a;
        Map r18 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, this.j));
        AnnieXLiveContext r19 = this.e;
        if (r19 == null) goto L27;
        com.bytedance.ies.bullet.base.utils.logger.a r20 = r19.getLogContext();
    L28:
        HybridLogger.k("AnnieXLiveDialog", "on_create", r18, r20);
        if (this.e == null) goto L31;
    L49:
        AnnieXLiveContext r21 = this.e;
        if (r21 == null) goto L60;
        String r22 = r21.getUri().toString();
        this.j = r22;
        com.bytedance.android.anniex.container.d r23 = this.g;
        if (r23 == null) goto L54;
        t36.d r24 = r23.generateSchemaData(r22);
    L55:
        this.h = r24;
        if (r24 == null) goto L58;
        Lazy r25 = SchemaService.f;
        SchemaService.a.a().getClass();
        com.bytedance.android.annie.business.ability.schema.model.a r26 = (com.bytedance.android.annie.business.ability.schema.model.a) SchemaService.d(r24, com.bytedance.android.annie.business.ability.schema.model.a.class);
    L59:
        this.f = r26;
    L61:
        super.onCreate(r12);
        if (com.bytedance.android.annie.ng.g.g == false) goto L94;
        com.bytedance.android.annie.business.ability.schema.model.a r27 = this.f;
        if (r27 == null) goto L73;
        String r28 = r27.b();
    L74:
        if (r28 == null) goto L76;
        com.bytedance.android.annie.container.dialog.k.b(r28, this);
        r11 = Unit.INSTANCE;
    L76:
        if (r11 == null) goto L92;
    L83:
        com.bytedance.android.anniex.container.d r29 = this.g;
        if (r29 == null) goto L88;
        AnnieXLiveContext r30 = this.e;
        if (r30 == null) goto L88;
        i r31 = new i(requireActivity(), r29, r30);
        this.d = r31;
        r31.o = this.f;
    L88:
        com.bytedance.android.anniex.container.d r32 = this.g;
        if (r32 == null) goto L100;
        r32.onCreate(r12);
        return;
    L100:
        return;
    L92:
        dismissAllowingStateLoss();     // Catch: Exception -> L79
    L79:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r33 = DialogFragmentLancet.sLastShowStack;
        if (r33 == null) goto L83;
        com.bytedance.crash.d.d(r33, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L83
    L73:
        r28 = null;
        goto L74
    L94:
        dismissAllowingStateLoss();     // Catch: Exception -> L65
        return;
    L65:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r110 = DialogFragmentLancet.sLastShowStack;
        if (r110 == null) goto L98;
        com.bytedance.crash.d.d(r110, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L98:
        return;
    L58:
        r26 = null;
        goto L59
    L54:
        r24 = null;
        goto L55
    L60:
        k7.a.a("AnnieXLiveDialog", "AnnieXLiveDialog mAnnieXLiveContext is null", r21);
        ExecutorService r34 = com.bytedance.ies.bullet.service.monitor.a.a;
        com.bytedance.ies.bullet.service.monitor.a.d(null, containerId(), "AnnieXLiveDialog mAnnieXLiveContext is null");
        goto L61
    L31:
        if (com.bytedance.android.annie.ng.g.g == false) goto L49;
        Bundle r35 = getArguments();
        if (r35 == null) goto L39;
        String r36 = r35.getString("annie_x_inner_bundle_schema");
        if (r36 == null) goto L37;
        Uri r37 = UriProtector.parse(r36);
    L38:
        if (r37 == null) goto L39;
    L40:
        Uri r38 = r37;
        Bundle r39 = getArguments();
        if (r39 == null) goto L43;
        r39.putBoolean("container_has_recreated", true);
        Bundle r40 = r39;
    L44:
        AnnieXLiveContext r41 = new AnnieXLiveContext(r38, null, r40, null, null, 24, null);
        r41.setType(hybridType().toMonitorString());
        h8.c r42 = new h8.c(null);
        r42.onInit(r41);
        r42.onBeforeOpenContainer();
        com.bytedance.android.annie.business.ability.schema.model.a r43 = this.f;
        if (r43 == null) goto L47;
        String r44 = r43.b();
    L48:
        r42.onPrepareInitDataStart(r44, "", false);
        r41.setCommonLifecycle(r42);
        this.e = r41;
        k7.a.b("AnnieXLiveDialog", "reOnCreate: " + this.j, this.e);
        goto L49
    L47:
        r44 = "";
        goto L48
    L43:
        r40 = null;
        goto L44
    L37:
        r37 = null;
    L39:
        r37 = Uri.EMPTY;
        goto L40
    L27:
        r20 = null;
        goto L28
    L5:
        if (r12 == null) goto L7;
        r12.remove("android:support:fragments");     // Catch: Throwable -> L15
    L7:
        if (r12 == null) goto L9;
        r12.remove("android:fragments");     // Catch: Throwable -> L15
    L9:
        if (r12 == null) goto L13;
        Bundle r45 = r12.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");     // Catch: Throwable -> L15
        if (r45 == null) goto L13;
        r45.remove("android:support:fragments");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public final Dialog onCreateDialog(Bundle r10) {
        com.bytedance.android.anniex.container.d r0 = this.g;
        if (r0 == null) goto L7;
        Dialog r1 = r0.h(r10);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return super.onCreateDialog(r10);
    }

    public final void onDismiss(DialogInterface r10) {
        ba0(r10);     // Catch: Throwable -> L5
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

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r10) {
        HybridLogger r0 = HybridLogger.a;
        Map r1 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, this.j));
        AnnieXLiveContext r11 = this.e;
        if (r11 == null) goto L5;
        com.bytedance.ies.bullet.base.utils.logger.a r12 = r11.getLogContext();
    L6:
        HybridLogger.k("AnnieXLiveDialog", "onShow", r1, r12);
        Iterator r13 = ((ArrayList) this.p).iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        ((HybridDialog.a) r13.next()).onShow();
        goto L8
    L10:
        com.bytedance.android.anniex.container.d r14 = this.g;
        if (r14 == null) goto L15;
        r14.onShow(r10);
        return;
    L15:
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.bytedance.android.annie.container.fragment.q
    public final void registerOnRequestPermissionsCallBack(com.bytedance.android.annie.bridge.method.permission.b r10) {
        Intrinsics.checkNotNullParameter(r10, "onRequestPermissionsCallBack");
        i r1 = this.d;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r10, "onRequestPermissionsCallBack");
        r1.g = r10;
        return;
    }

    @Override // com.bytedance.android.annie.container.fragment.p
    public final void setCloseByGesture(boolean r10) {
        i r0 = this.d;
        if (r0 == null) goto L6;
        r0.b.interceptBackPress(!r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void setJSBridgeListener(IHybridComponent.a r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        i r0 = this.d;
        if (r0 == null) goto L5;
        r0.q(r10);
        return;
    L5:
        List<IHybridComponent.a> r1 = this.l;
        if (r1 == null) goto L8;
        r1.add(r10);
        return;
    L8:
        this.l = CollectionsKt.mutableListOf(new IHybridComponent.a[]{r10});
    }

    public final void setUserVisibleHint(boolean r10) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r10);
        i r0 = this.d;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(r10);
        return;
    }

    public static final Dialog aa0(AnnieXLiveDialog r0, Bundle r1) {
        return super.onCreateDialog(r1);
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        if (com.bytedance.android.annie.ng.g.g == true) goto L5;
        return;
    L5:
        HybridLogger r0 = HybridLogger.a;
        Map r1 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, this.j));
        AnnieXLiveContext r12 = this.e;
        com.bytedance.ies.bullet.base.utils.logger.a r13 = null;
        if (r12 == null) goto L8;
        com.bytedance.ies.bullet.base.utils.logger.a r14 = r12.getLogContext();
    L9:
        HybridLogger.k("AnnieXLiveDialog", "on_view_created", r1, r14);
        int r15 = com.bytedance.android.annie.util.b.a;
        com.bytedance.android.annie.util.b.a(this.j, r10);
        Context r16 = getContext();
        if (r16 == null) goto L38;
        com.bytedance.android.anniex.container.d r17 = this.g;
        if (r17 == null) goto L38;
        com.bytedance.android.annie.business.ability.schema.model.a r18 = this.f;
        if (r18 == null) goto L33;
        AnnieXLiveContext r19 = this.e;
        if (r19 == null) goto L31;
        AnnieXLiveHybridComponent r20 = new AnnieXLiveHybridComponent(r16, r17, r18, r19);
        this.i = r20;
        i r21 = this.d;
        if (r21 == null) goto L20;
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type com.bytedance.android.annie.business.container.AnnieXLiveHybridComponent");
        r21.n = r20;
    L20:
        AnnieXLiveHybridComponent r22 = this.i;
        if ((r22 instanceof AnnieXLiveHybridComponent) == true) goto L24;
        r22 = null;
    L24:
        if (r22 == null) goto L31;
        r22.e(this.l);
        JSBridgeManager r23 = r22.g;
        if (r23 == null) goto L30;
        i r24 = this.d;
        if (r24 == null) goto L30;
        r24.n(r23, this);
    L30:
        a7.a.a(r22, this.j, null, 2);
    L32:
        if (r22 != null) goto L38;
    L31:
        r22 = null;
    L33:
        Map r25 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MSG, "onViewCreated:mAnnieXLiveDialogModel is null"));
        AnnieXLiveContext r26 = this.e;
        if (r26 == null) goto L36;
        com.bytedance.ies.bullet.base.utils.logger.a r27 = r26.getLogContext();
    L37:
        HybridLogger.g("AnnieXLiveDialog", "mAnnieXLiveDialogModel_init_error", r25, r27);
        Unit r28 = Unit.INSTANCE;
        goto L38
    L36:
        r27 = null;
    L38:
        AnnieXLiveHybridComponent r29 = this.i;
        if ((r29 instanceof AnnieXLiveHybridComponent) == true) goto L42;
        r29 = null;
    L42:
        if (r29 != null) goto L47;
        Map r30 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MSG, "onViewCreated: mHybridComponent create fail"));
        AnnieXLiveContext r31 = this.e;
        if (r31 == null) goto L46;
        r13 = r31.getLogContext();
    L46:
        HybridLogger.g("AnnieXLiveDialog", "mHybridComponent_create_error", r30, r13);
        Unit r32 = Unit.INSTANCE;
    L47:
        i r33 = this.d;
        if (r33 == null) goto L50;
        r33.b(r10, r11);
    L50:
        i r34 = this.d;
        if (r34 == null) goto L54;
        r34.c();
        return;
    L54:
        return;
    L8:
        r14 = null;
        goto L9
    }

    @Override // com.bytedance.android.annie.container.fragment.q
    public final void requestPermissionsProxy(String[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "permissions");
        super/*androidx.fragment.app.Fragment*/.requestPermissions(r10, r11);
    }

    public final void show(FragmentManager r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        HybridLogger r0 = HybridLogger.a;
        AnnieXLiveContext r1 = this.e;
        com.bytedance.ies.bullet.base.utils.logger.a r12 = null;
        if (r1 == null) goto L5;
        com.bytedance.ies.bullet.base.utils.logger.a r13 = r1.getLogContext();
    L6:
        HybridLogger.k("AnnieXLiveDialog", "show", null, r13);
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L18
        if (r10.isDestroyed() == false) goto L11;
        this.t = false;     // Catch: Throwable -> L18
        return;
    L11:
        r10.beginTransaction().remove(this).commit();     // Catch: Throwable -> L18
        LandscapeRestrictionOperation r15 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L18
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r11, r15);     // Catch: Throwable -> L18
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r10, this, r15) == false) goto L29;
    L16:
        this.t = true;     // Catch: Throwable -> L18
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L31;
        this.t = false;
        HybridLogger r18 = HybridLogger.a;
        Map r19 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MSG, "===show error:" + r17.getMessage() + "==="));
        AnnieXLiveContext r20 = this.e;
        if (r20 == null) goto L25;
        r12 = r20.getLogContext();
    L25:
        HybridLogger.g("AnnieXLiveDialog", "show_error", r19, r12);
        return;
    L31:
        return;
    L29:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27 Throwable -> L18
    L15:
        super.show(r10, r11);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L5:
        r13 = null;
        goto L6
    }

    public final void onActivityResult(int r10, int r11, Intent r12) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r10, r11, r12);
        i r0 = this.d;
        if (r0 == null) goto L6;
        r0.onActivityResult(r10, r11, r12);
        return;
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        if (com.bytedance.android.annie.ng.g.g == true) goto L6;
        return null;
    L6:
        super/*androidx.fragment.app.Fragment*/.onCreateView(r10, r11, r12);
        View r13 = r10.inflate(2131558562, r11, false);
        this.m = r13;
        i r14 = this.d;
        if (r14 == null) goto L9;
        r14.a(r13);
    L9:
        com.bytedance.android.anniex.container.d r15 = this.g;
        if (r15 == null) goto L14;
        com.bytedance.android.annie.business.ability.schema.model.a r16 = this.f;
        if (r16 == null) goto L14;
        com.bytedance.android.annie.container.dialog.l r17 = this.n;
        View r0 = this.m;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        r17.attach((FrameLayout) ((ViewGroup) r0).findViewById(2131372985), r15, r16, AnnieConfigSettingKeys.ENABLE_PULL_UP_ADAPTER_STATUS_BAR.a().booleanValue());
    L14:
        Dialog r18 = getDialog();
        if (r18 == null) goto L18;
        r18.setOnKeyListener(new com.bytedance.android.annie.business.container.a(this));
    L18:
        return this.m;
    }

    public final void onRequestPermissionsResult(int r10, String[] r11, int[] r12) {
        Intrinsics.checkNotNullParameter(r11, "permissions");
        Intrinsics.checkNotNullParameter(r12, "grantResults");
        super/*androidx.fragment.app.Fragment*/.onRequestPermissionsResult(r10, r11, r12);
        i r0 = this.d;
        if (r0 == null) goto L6;
        r0.k(r10, r11, r12);
        return;
    }
}
