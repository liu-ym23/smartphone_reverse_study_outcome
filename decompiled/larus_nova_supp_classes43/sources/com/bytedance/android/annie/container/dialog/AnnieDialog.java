package com.bytedance.android.annie.container.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.bridge.method.f2;
import com.bytedance.android.annie.bridge.method.g2;
import com.bytedance.android.annie.bridge.method.h0;
import com.bytedance.android.annie.bridge.method.j0;
import com.bytedance.android.annie.bridge.method.k0;
import com.bytedance.android.annie.bridge.method.l0;
import com.bytedance.android.annie.bridge.method.q1;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.container.fragment.AnnieFragment;
import com.bytedance.android.annie.scheme.vo.refactor.BaseHybridParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.HybridKitType;
import com.bytedance.android.annie.scheme.vo.refactor.PopupHybridParamVoNew;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.util.m;
import com.bytedance.android.annie.util.p;
import com.bytedance.android.annie.util.t;
import com.bytedance.android.ec.core.utils.FontWeight;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/annie/container/dialog/AnnieDialog;", "Lcom/bytedance/android/annie/container/dialog/BaseDialogFragment;", "Lcom/bytedance/android/annie/api/card/IHybridComponent$a;", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class AnnieDialog extends BaseDialogFragment implements IHybridComponent.a {
    public Function0<Unit> s;
    public IHybridComponent.a t;
    public com.bytedance.android.annie.param.a u;
    public int v;
    public int w;

    public static final class a implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ AnnieDialog b;

        public a(View r1, AnnieDialog r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void a() {
            if (this.a != null) goto L5;
            return;
        L5:
            if (this.b.getActivity() == null) goto L20;
            View r0 = this.a.findViewById(2131383767);
            if (r0 == null) goto L18;
            View r1 = this.a;
            AnnieDialog r10 = this.b;
            if (r0.getBottom() != r1.getBottom()) goto L19;
            p r11 = p.a;
            int r12 = p.c(r10.requireActivity()).heightPixels;
            t r13 = t.a;
            int r14 = r12 - t.i();
            Resources r15 = r11.getResources();
            int r16 = r15.getIdentifier("navigation_bar_height", "dimen", "android");
            if (r16 == 0) goto L14;
            int r17 = r15.getDimensionPixelSize(r16);
        L15:
            int r18 = r14 - r17;
            float r19 = Math.min(1.0f, r0.getHeight() / Math.max(1.0f, r18 * 1.0f));
            HybridLogger r20 = HybridLogger.a;
            HybridLogger.m("BaseDialogFragment", "annieDialog show event. screenHeight:" + r18 + " dialogHeight:" + r0.getHeight() + " percent:" + r19, null, null, 12);
            ((d9.b) com.bytedance.android.annie.a.c(d9.b.class)).p(r19);
            return;
        L14:
            r17 = 0;
            goto L15
        L19:
            return;
        L18:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final boolean S90() {
        return false;
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog, com.bytedance.android.annie.api.card.IHybridComponent
    public final boolean isPopup() {
        return true;
    }

    @Override // com.bytedance.android.annie.container.dialog.BaseDialogFragment
    public final void ba0() {
        PopupHybridParamVoNew r0 = this.e;
        boolean r1 = false;
        if (r0 != null) goto L6;
    L9:
        boolean r10 = true;
    L11:
        if (r10 == true) goto L19;
        PopupHybridParamVoNew r11 = this.e;
        if (r11 != null) goto L15;
    L17:
        if (r1 == false) goto L19;
        U90(true);
        return;
    L15:
        if (r11.P2() != true) goto L17;
        r1 = true;
    L19:
        Dialog r12 = getDialog();
        if (r12 == null) goto L24;
        r12.hide();
        return;
    L24:
        return;
    L6:
        if (r0.getWidth() == 0) goto L8;
    L10:
        r10 = false;
        goto L11
    L8:
        if (r0.getHeight() != 0) goto L10;
        goto L9
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final String getBizKey() {
        com.bytedance.android.annie.param.a r0 = this.u;
        if (r0 == null) goto L6;
        String r1 = r0.getBizKey();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "host";
    }

    @Override // com.bytedance.android.annie.container.dialog.BaseDialogFragment
    public final void oa0() {
        PopupHybridParamVoNew r0 = this.e;
        if (r0 == null) goto L5;
        this.v = r0.getHeight();
    L5:
        ua0(null);
        xa0();
        wa0();
    }

    public final void wa0() {
        if (com.bytedance.android.annie.ng.g.b().b.d == false) goto L63;
        PopupHybridParamVoNew r1 = this.e;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.h3() == true) goto L65;
        String r10 = r1.o();
        if (r10 != null) goto L12;
    L15:
        boolean r11 = true;
    L17:
        if (r11 == true) goto L26;
        Uri r12 = UriProtector.parse(r1.o());
        String r13 = UriProtector.getQueryParameter(r12, "margin_bottom");
        if (r13 == null) goto L21;
        int r14 = CastIntegerProtector.parseInt(r13);
    L22:
        String r15 = UriProtector.getQueryParameter(r12, "margin_right");
        if (r15 == null) goto L25;
        int r16 = CastIntegerProtector.parseInt(r15);
    L27:
        HybridLogger r17 = HybridLogger.a;
        Integer r18 = null;
        HybridLogger.m("BaseDialogFragment", "height: " + r1.getHeight() + "; width: " + r1.getWidth(), null, null, 12);
        double r19 = ((double) r1.getHeight()) * ((((double) 375) * 1.0d) / ((double) r1.getWidth()));
        if (ha0() == false) goto L32;
        FragmentActivity r20 = getActivity();
        if (r20 == null) goto L35;
        t r110 = t.a;
        r18 = Integer.valueOf(t.f(r20));
    L35:
        if (r18 == null) goto L61;
        p r21 = p.a;
        int r111 = -1;
        if (r21.h(r18.intValue()) <= 395) goto L39;
        com.bytedance.android.annie.scheme.helper.a.d(r1, "width", 375);
        if (r1.b3() == false) goto L51;
    L60:
        com.bytedance.android.annie.scheme.helper.a.d(r1, "margin_bottom", Integer.valueOf(r14));
        com.bytedance.android.annie.scheme.helper.a.d(r1, "margin_right", Integer.valueOf(r16));
        goto L61
    L51:
        if (0 >= r19) goto L56;
        if (r19 >= 480) goto L56;
        r111 = r1.getHeight();
    L59:
        com.bytedance.android.annie.scheme.helper.a.d(r1, "height", Integer.valueOf(r111));
    L56:
        if (m.c() == true) goto L59;
        r111 = FontWeight.WEIGHT_700;
        goto L59
    L39:
        if (ha0() == true) goto L41;
        com.bytedance.android.annie.scheme.helper.a.d(r1, "width", -1);
    L43:
        if (r1.i3() != 1) goto L47;
        Integer r22 = ((d9.b) getService(d9.b.class)).f1(MapsKt.emptyMap());
        if (r22 == null) goto L47;
        r22.intValue();
        com.bytedance.android.annie.scheme.helper.a.d(r1, "height", Integer.valueOf((int) (((double) r21.h(r22.intValue())) + 0.5d)));
        com.bytedance.android.annie.scheme.helper.a.d(r1, "radius_top_left", 0);
        com.bytedance.android.annie.scheme.helper.a.d(r1, "radius_top_right", 0);
    L47:
        com.bytedance.android.annie.scheme.helper.a.d(r1, "margin_bottom", 0);
        com.bytedance.android.annie.scheme.helper.a.d(r1, "margin_right", 0);
        goto L61
    L41:
        com.bytedance.android.annie.scheme.helper.a.d(r1, "width", Integer.valueOf(r1.getWidth()));
        com.bytedance.android.annie.scheme.helper.a.d(r1, "height", -1);
    L61:
        com.bytedance.android.annie.scheme.helper.a.d(r1, "width_percent", 0);
        com.bytedance.android.annie.scheme.helper.a.d(r1, "height_percent", 0);
        return;
    L32:
        FragmentActivity r23 = getActivity();
        if (r23 == null) goto L35;
        t r112 = t.a;
        r18 = Integer.valueOf(t.g(r23));
        goto L35
    L25:
        r16 = 0;
        goto L27
    L21:
        r14 = 0;
        goto L22
    L26:
        r16 = 0;
        r14 = 0;
        goto L27
    L12:
        if (r10.length() == 0) goto L15;
        r11 = false;
        goto L17
    L65:
        return;
    }

    public AnnieDialog() {
        this.v = 400;
        this.w = -1;
    }

    @Override // com.bytedance.android.annie.container.dialog.BaseDialogFragment
    public final void onDestroy() {
        super.onDestroy();
        Function0<Unit> r0 = this.s;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    public final void ta0() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L13;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L14;
        HybridFragment r10 = this.f;
        if ((r10 instanceof AnnieFragment) == false) goto L9;
        AnnieFragment r11 = (AnnieFragment) r10;
    L10:
        if (r11 == null) goto L15;
        r11.y = r1.getAttributes().width;
        return;
    L15:
        return;
    L9:
        r11 = null;
        goto L10
    L14:
        return;
    }

    public final void xa0() {
        if (com.bytedance.android.annie.ng.g.b().b.c == false) goto L37;
        com.bytedance.android.annie.ng.g.b().getClass();
        if (com.bytedance.android.annie.ng.e.a.j == true) goto L38;
        PopupHybridParamVoNew r0 = this.e;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.h3() == true) goto L40;
        double r10 = ((double) r0.getHeight()) * ((((double) 375) * 1.0d) / ((double) r0.getWidth()));
        com.bytedance.android.annie.scheme.helper.a.d(r0, "width", 375);
        if (r0.i3() != 1) goto L24;
        if (m.c() == false) goto L20;
        p r1 = p.a;
        int r11 = (int) ((r1.d() * 2) / 3.0f);
        com.bytedance.android.annie.param.p r12 = this.n;
        if (r12 == null) goto L18;
        float r13 = r11 / r12.a.density;
    L19:
        com.bytedance.android.annie.scheme.helper.a.d(r0, "height", Integer.valueOf((int) r13));
    L35:
        com.bytedance.android.annie.scheme.helper.a.d(r0, "width_percent", 0);
        com.bytedance.android.annie.scheme.helper.a.d(r0, "height_percent", 0);
        return;
    L18:
        r13 = r1.h(r11);
        goto L19
    L20:
        Integer r14 = ((d9.b) getService(d9.b.class)).f1(MapsKt.mapOf(new Pair[]{TuplesKt.to("pad_use_player_bottom_height", String.valueOf(r0.i3())), TuplesKt.to("margin_bottom", Integer.valueOf(r0.getMarginBottom()))}));
        if (r14 == null) goto L35;
        r14.intValue();
        com.bytedance.android.annie.scheme.helper.a.d(r0, "height", Integer.valueOf((int) (((double) p.a.h(r14.intValue())) + 0.5d)));
        com.bytedance.android.annie.scheme.helper.a.d(r0, "radius_top_left", 0);
        com.bytedance.android.annie.scheme.helper.a.d(r0, "radius_top_right", 0);
        goto L35
    L24:
        if (r0.b3() == true) goto L35;
        if (0 >= r10) goto L31;
        if (r10 >= 480) goto L31;
        int r15 = (int) r10;
    L34:
        com.bytedance.android.annie.scheme.helper.a.d(r0, "height", Integer.valueOf(r15));
    L31:
        if (m.c() == false) goto L33;
        r15 = -1;
        goto L34
    L33:
        r15 = FontWeight.WEIGHT_700;
        goto L34
    L40:
        return;
    L38:
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridDialog
    public final void X90(Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "onDestroy");
        this.s = r10;
    }

    @Override // com.bytedance.android.annie.container.dialog.BaseDialogFragment
    public final AnnieFragment ea0(PopupHybridParamVoNew r10) {
        Intrinsics.checkNotNullParameter(r10, "popupHybridParamVoNew");
        String r11 = getBizKey();
        com.bytedance.android.annie.c r0 = com.bytedance.android.annie.d.a;
        Intrinsics.checkNotNullParameter(r11, "bizKey");
        AnnieFragment r12 = ((e9.b) Annie.getService(e9.b.class, r11)).f();
        if (r12 != null) goto L5;
        r12 = new AnnieFragment();
    L5:
        Bundle r1 = new Bundle();
        r1.putParcelable("hybrid_common_vo_new", this.e);
        r12.setArguments(r1);
        r12.setJSBridgeListener(this);
        com.bytedance.android.annie.param.a r13 = this.u;
        if (r13 == null) goto L13;
        b7.b r14 = r13.getCommonLifecycle();
        if (r14 == null) goto L13;
        com.bytedance.android.annie.param.a r15 = this.u;
        if (r15 == null) goto L13;
        r15.setCommonLifecycle(new com.bytedance.android.annie.container.dialog.a(r14, this));
    L13:
        r12.f = this.u;
        return r12;
    }

    @Override // com.bytedance.android.annie.container.dialog.BaseDialogFragment
    public final void ia0(String r10) {
        Intrinsics.checkNotNullParameter("BaseDialogFragment", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        com.bytedance.android.annie.param.a r0 = this.u;
        if (r0 == null) goto L8;
        x8.b r1 = r0.d;
        if (r1 == null) goto L9;
        r1.e("BaseDialogFragment", r10);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.annie.container.dialog.BaseDialogFragment
    public final void ja0(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "bundle");
        r10.getString(com.bytedance.android.ec.core.event.a.KEY_URL);
        r10.getString("original_scheme");
    }

    @Override // com.bytedance.android.annie.container.dialog.BaseDialogFragment
    public final void onActivityCreated(Bundle r10) {
        super.onActivityCreated(r10);
        Dialog r11 = getDialog();
        if (r11 != null) goto L5;
    L11:
        ta0();
        return;
    L5:
        if (getContext() == null) goto L11;
        if (ha0() == false) goto L11;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L11;
        r12.addFlags(8);
        sa0(r12);
        r12.setType(IServerListener.WHAT_BYTELINK_SINK_ERROR);
        goto L11
    }

    public final void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r10);
        xa0();
        HybridLogger r0 = HybridLogger.a;
        StringBuilder r1 = new StringBuilder("screenWidthDp: ");
        r1.append(r10.screenWidthDp);
        r1.append(";  ");
        p r11 = p.a;
        r1.append(r11.a(r10.screenWidthDp));
        HybridLogger.i("BaseDialogFragment", r1.toString(), null, 12);
        HybridLogger.i("BaseDialogFragment", "screenHeightDp: " + r10.screenHeightDp + ";  " + r11.a(r10.screenHeightDp), null, 12);
        if (com.bytedance.android.annie.ng.g.b().b.d == false) goto L24;
        PopupHybridParamVoNew r12 = this.e;
        if (r12 != null) goto L7;
    L23:
        ua0(r10);
        wa0();
        goto L24
    L7:
        if (r12.F3() != 0) goto L9;
        com.bytedance.android.annie.scheme.helper.a.d(r12, "width", Integer.valueOf(r10.screenWidthDp));
    L22:
        com.bytedance.android.annie.scheme.helper.a.d(this, "height", Integer.valueOf(this.v));
        HybridLogger.m("BaseDialogFragment", "adjustBeforeHeight: " + this.v + "; height: " + r12.getHeight() + "; width: " + r12.getWidth(), null, null, 12);
        goto L23
    L9:
        String r13 = r12.o();
        if (r13 != null) goto L12;
    L15:
        boolean r14 = true;
    L16:
        if (r14 == true) goto L22;
        String r15 = UriProtector.getQueryParameter(UriProtector.parse(r12.o()), "width");
        if (r15 == null) goto L20;
        int r16 = CastIntegerProtector.parseInt(r15);
    L21:
        com.bytedance.android.annie.scheme.helper.a.d(r12, "width", Integer.valueOf(r16));
        goto L22
    L20:
        r16 = FontWeight.WEIGHT_300;
        goto L21
    L12:
        if (r13.length() == 0) goto L15;
        r14 = false;
    L24:
        PopupHybridParamVoNew r17 = this.e;
        if (r17 != null) goto L27;
    L49:
        ta0();
        return;
    L27:
        if (getDialog() == null) goto L49;
        com.bytedance.android.annie.param.a r18 = this.u;
        if (r18 == null) goto L33;
        x8.b r19 = r18.d;
        if (r19 == null) goto L33;
        r19.e("BaseDialogFragment", "onConfigurationChanged, widthDp:" + Integer.valueOf(r10.screenWidthDp) + ", heightDp: " + Integer.valueOf(r10.screenHeightDp));
    L33:
        com.bytedance.android.annie.param.a r20 = this.u;
        if (r20 == null) goto L38;
        s7.c r21 = r20.e;
        if (r21 == null) goto L38;
        r21.a(r10, r17);
        Unit r22 = Unit.INSTANCE;
    L38:
        Dialog r23 = getDialog();
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type android.app.Dialog");
        qa0(r23, r17.getWidth(), r17.getHeight(), r17.T2());
        HybridFragment r24 = this.f;
        if (r24 == null) goto L49;
        IHybridComponent r25 = r24.getHybridComponent();
        if (r25 == null) goto L49;
        if ((r25 instanceof AnnieCard) == false) goto L49;
        com.bytedance.android.annie.param.a r26 = this.u;
        if (r26 == null) goto L49;
        s7.c r27 = r26.e;
        if (r27 == null) goto L49;
        r27.b(r10, (AnnieCard) r25);
        goto L49
    }

    @Override // com.bytedance.android.annie.container.dialog.BaseDialogFragment
    public final void onCreate(Bundle r10) {
        if (this.u == null) goto L5;
    L28:
        com.bytedance.android.annie.param.a r0 = this.u;
        if (r0 != null) goto L31;
    L33:
        super.onCreate(r10);
        return;
    L31:
        if (r0.b != null) goto L33;
        r0.b = new AnnieDialog$onCreate$3$1(this);
        goto L33
    L5:
        if (com.bytedance.android.annie.ng.g.g == false) goto L28;
        Bundle r1 = new Bundle();
        r1.putBoolean("container_has_recreated", true);
        Unit r11 = Unit.INSTANCE;
        com.bytedance.android.annie.param.a r12 = new com.bytedance.android.annie.param.a(null, r1, null, 27);
        PopupHybridParamVoNew r13 = this.e;
        if (r13 == null) goto L9;
        String r14 = r13.b;
    L10:
        r12.setUrl(r14);
        PopupHybridParamVoNew r15 = this.e;
        if (r15 == null) goto L15;
        BaseHybridParamVoNew.HybridType r16 = r15.M1();
        if (r16 == null) goto L15;
        String r17 = r16.toMonitorString();
    L16:
        r12.setType(r17);
        h8.c r18 = new h8.c(null);
        r18.onInit(r12);
        r18.onBeforeOpenContainer();
        PopupHybridParamVoNew r19 = this.e;
        String r20 = "";
        if (r19 == null) goto L20;
        String r21 = r19.o();
        if (r21 == null) goto L20;
    L21:
        PopupHybridParamVoNew r22 = this.e;
        if (r22 == null) goto L27;
        String r23 = r22.c;
        if (r23 == null) goto L27;
        r20 = r23;
    L27:
        r18.onPrepareInitDataStart(r21, r20, false);
        r12.setCommonLifecycle(r18);
        this.u = r12;
    L20:
        r21 = "";
    L15:
        r17 = null;
        goto L16
    L9:
        r14 = null;
        goto L10
    }

    @Override // com.bytedance.android.annie.container.dialog.BaseDialogFragment
    public final void onDismiss(DialogInterface r10) {
        ra0(r10);     // Catch: Throwable -> L5
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

    @Override // com.bytedance.android.annie.api.card.IHybridComponent.a
    public final void onJSBridgeCreated(y6.c r10) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        int r0 = j0.a;
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        Iterator r1 = MapsKt.mapOf(new Pair[]{TuplesKt.to("closeAndOpen", new com.bytedance.android.annie.bridge.method.i(this)), TuplesKt.to("halfFullSwitch", new h0(this)), TuplesKt.to("setLive", new f2(this)), TuplesKt.to("dialogPullDownClose", new q1(this)), TuplesKt.to("pull_down_height", new g2(this))}).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r11 = (Map.Entry) r1.next();
        r10.registerMethod((String) r11.getKey(), (com.bytedance.ies.web.jsbridge2.g) r11.getValue());
        goto L4
    L6:
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        Map r12 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.VALUE_CLOSE, new k0(this)));
        Map r13 = MapsKt.mapOf(TuplesKt.to("login", new l0(this)));
        if (Intrinsics.areEqual(getBizKey(), "webcast") == true) goto L10;
        r12 = MapsKt.plus(r12, r13);
    L10:
        Iterator r14 = r12.entrySet().iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        Map.Entry r15 = (Map.Entry) r14.next();
        r10.registerMethod((String) r15.getKey(), (com.bytedance.ies.web.jsbridge2.f.b) r15.getValue());
        goto L12
    L14:
        FragmentActivity r16 = getActivity();
        if (r16 == null) goto L31;
        Iterator r17 = ((CopyOnWriteArraySet) a9.j.c).iterator();
    L18:
        if (r17.hasNext() == false) goto L31;
        Iterator r18 = ((y6.a) r17.next()).b(r16, this).entrySet().iterator();
    L21:
        if (r18.hasNext() == false) goto L23;
        Map.Entry r19 = (Map.Entry) r18.next();
        r10.registerMethod((String) r19.getKey(), (n56.c) r19.getValue());
        goto L21
    L23:
        Intrinsics.checkNotNullParameter(r16, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        Iterator r20 = MapsKt.emptyMap().entrySet().iterator();
    L25:
        if (r20.hasNext() == false) goto L27;
        Map.Entry r21 = (Map.Entry) r20.next();
        r10.registerMethod((String) r21.getKey(), (com.bytedance.ies.web.jsbridge2.g) r21.getValue());
        goto L25
    L27:
        Intrinsics.checkNotNullParameter(r16, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(this, "dialogFragment");
        Iterator r22 = MapsKt.emptyMap().entrySet().iterator();
    L29:
        if (r22.hasNext() == false) goto L18;
        Map.Entry r23 = (Map.Entry) r22.next();
        r10.registerMethod((String) r23.getKey(), (com.bytedance.ies.web.jsbridge2.f.b) r23.getValue());
    L31:
        IHybridComponent.a r24 = this.t;
        if (r24 == null) goto L41;
        r24.onJSBridgeCreated(r10);
        return;
    }

    @Override // com.bytedance.android.annie.container.dialog.BaseDialogFragment, android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r10) {
        super.onShow(r10);
        if (getContext() != null) goto L5;
        return;
    L5:
        if (ha0() == false) goto L13;
        Dialog r11 = getDialog();
        if (r11 == null) goto L14;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L15;
        r12.clearFlags(8);
        sa0(r12);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void ra0(DialogInterface r10) {
        Intrinsics.checkNotNullParameter(r10, "dialog");
        y9.i<Boolean> r0 = AnnieConfigSettingKeys.ENABLE_MONITOR_DIALOG_EVENT;
        if (r0.a().booleanValue() == false) goto L5;
        ((d9.b) com.bytedance.android.annie.a.c(d9.b.class)).W();
    L5:
        HybridLogger r1 = HybridLogger.a;
        HybridLogger.m("BaseDialogFragment", "annieDialog onDismiss. enable: " + r0.a(), null, null, 12);
        super.onDismiss(r10);
    }

    public final void sa0(Window r10) {
        View r11 = r10.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        r11.setSystemUiVisibility(5894);
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void setJSBridgeListener(IHybridComponent.a r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.t = r10;
        HybridFragment r0 = this.f;
        if (r0 == null) goto L6;
        r0.setJSBridgeListener(r10);
        return;
    }

    public final void ua0(Configuration r10) {
        Context r0 = getContext();
        if (r0 == null) goto L11;
        HybridLogger r11 = HybridLogger.a;
        StringBuilder r12 = new StringBuilder("widthPixels: ");
        Resources r13 = r0.getResources();
        r12.append(WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics()).widthPixels);
        r12.append("; getScreenWidth(): ");
        r12.append(ga0());
        HybridLogger.i("BaseDialogFragment", r12.toString(), null, 12);
        if (r10 == null) goto L8;
        int r14 = p.a.a(r10.screenWidthDp);
    L12:
        com.bytedance.android.annie.param.p r1 = this.n;
        if (r1 == null) goto L19;
        DisplayMetrics r15 = r1.c;
        if (r15 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("realDisplayMetrics");
        r15 = null;
    L18:
        if (r15 == null) goto L19;
    L20:
        int r16 = r15.heightPixels;
        if (com.bytedance.android.annie.ng.g.b().b.d == true) goto L23;
        int r17 = fa0();
    L27:
        int r18 = r16 - r17;
        HybridLogger r19 = HybridLogger.a;
        HybridLogger.i("BaseDialogFragment", "getRealNavigationBarHeight: " + fa0() + "; fullHeight: " + r16 + "; width:" + r14, null, 12);
        if (com.bytedance.android.annie.ng.g.b().b.c == false) goto L40;
        com.bytedance.android.annie.ng.g.b().getClass();
        if (com.bytedance.android.annie.ng.e.a.j == true) goto L40;
        int r20 = m.a;
        FragmentActivity r21 = getActivity();
        if (r21 == null) goto L34;
        int r22 = r21.getRequestedOrientation();
    L36:
        if (m.b(r22) == false) goto L39;
        if (r14 >= r18) goto L39;
        va0(false, r18, r14);
        return;
    L39:
        va0(false, r14, r18);
        return;
    L34:
        r22 = 1;
    L40:
        boolean r23 = ha0();
        if (r23 == true) goto L43;
    L45:
        r16 = r18;
    L46:
        va0(r23, r14, r16);
        return;
    L43:
        if (AnnieConfigSettingKeys.HYBRID_FIX_HORI_SCREEN_HEIGHT.a().booleanValue() == false) goto L45;
    L23:
        if (this.w != (-1)) goto L25;
        this.w = fa0();
    L25:
        r17 = this.w;
    L19:
        p r24 = p.a;
        r15 = p.c(getActivity());
        goto L20
    L8:
        if (AnnieConfigSettingKeys.ENABLE_FIX_SCREEN_WIDTH.a().booleanValue() == false) goto L10;
        Resources r25 = r0.getResources();
        r14 = WindowDisplayMetricsOverride.apply(r25, r25.getDisplayMetrics()).widthPixels;
        goto L12
    L10:
        r14 = ga0();
        goto L12
    L11:
        r14 = ga0();
        goto L12
    }

    @Override // com.bytedance.android.annie.container.dialog.BaseDialogFragment
    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        if (AnnieConfigSettingKeys.ENABLE_MONITOR_DIALOG_EVENT.a().booleanValue() == false) goto L5;
        r10.post(new a(r10, this));
    L5:
        int r12 = com.bytedance.android.annie.util.b.a;
        Bundle r13 = getArguments();
        Intrinsics.checkNotNullParameter(r10, "grayView");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L21
        PopupHybridParamVoNew r1 = null;
        if (r13 == null) goto L9;
        Object r14 = r13.get("hybrid_pop_vo_new");     // Catch: Throwable -> L21
    L11:
        if ((r14 instanceof PopupHybridParamVoNew) == false) goto L13;
        PopupHybridParamVoNew r15 = (PopupHybridParamVoNew) r14;     // Catch: Throwable -> L21
    L14:
        if (r15 == null) goto L19;
        String r16 = r15.o();     // Catch: Throwable -> L21
        if (r16 == null) goto L18;
        com.bytedance.android.annie.util.b.a(r16, r10);     // Catch: Throwable -> L21
    L18:
        r1 = r15;
    L19:
        Result.constructor-impl(r1);     // Catch: Throwable -> L21
        return;
    L13:
        r15 = null;
        goto L14
    L9:
        r14 = null;
    L21:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void va0(boolean r20, int r21, int r22) {
        PopupHybridParamVoNew r0 = this.e;
        Integer r10 = Integer.valueOf(FontWeight.WEIGHT_300);
        if (r0 == null) goto L38;
        int r11 = m.a;
        FragmentActivity r12 = getActivity();
        if (r12 == null) goto L7;
        int r13 = r12.getRequestedOrientation();
    L9:
        if (m.b(r13) == true) goto L11;
        Context r14 = getContext();
        if (r14 == null) goto L38;
        t r15 = t.a;
        if (t.c(r14) == false) goto L38;
        com.bytedance.android.annie.scheme.helper.a.d(r0, "y_offset", Integer.valueOf(r15.e(r14)));
        goto L38
    L11:
        if (r0.b3() == true) goto L14;
        com.bytedance.android.annie.scheme.helper.a.d(r0, "radius", 8);
        com.bytedance.android.annie.scheme.helper.a.d(r0, "height", Integer.valueOf((int) p.a.h(r22 - (r0.d3() * 2))));
        com.bytedance.android.annie.scheme.helper.a.d(r0, "width", r10);
    L14:
        if (r0.a3() == true) goto L17;
        com.bytedance.android.annie.scheme.helper.a.d(r0, "gravity", 8388613);
    L20:
        if (r0.Y2() <= 0) goto L23;
        com.bytedance.android.annie.scheme.helper.a.d(r0, "width", Integer.valueOf(r0.Y2()));
    L23:
        if (r0.V2() <= 0) goto L26;
        com.bytedance.android.annie.scheme.helper.a.d(r0, "height", Integer.valueOf(r0.V2()));
    L26:
        if (r0.W2() <= 0) goto L28;
        com.bytedance.android.annie.scheme.helper.a.d(r0, "height", Integer.valueOf((int) p.a.h((p.c(getActivity()).heightPixels * r0.W2()) / 100)));
    L28:
        com.bytedance.android.annie.scheme.helper.a.d(r0, "up_full_screen", Boolean.FALSE);
        Context r16 = getContext();
        if (r16 == null) goto L38;
        t r17 = t.a;
        if (t.c(r16) == false) goto L38;
        com.bytedance.android.annie.scheme.helper.a.d(r0, "x_offset", Integer.valueOf(r17.e(r16)));
        goto L38
    L17:
        if (r0.T2() != 80) goto L20;
        com.bytedance.android.annie.scheme.helper.a.d(r0, "gravity", 8388693);
        goto L20
    L7:
        r13 = 1;
    L38:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L43;
        Window r18 = r1.getWindow();
        if (r18 == null) goto L43;
        this.g = r18.getStatusBarColor();
    L43:
        PopupHybridParamVoNew r19 = this.e;
        if (r19 != null) goto L46;
        return;
    L46:
        if (AnnieConfigSettingKeys.ENABLE_FIX_SCREEN_WIDTH.a().booleanValue() == false) goto L49;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "width", Integer.valueOf(RangesKt.coerceAtMost(r19.getWidth(), (int) p.a.h(r21))));
    L49:
        if (r19.q3() > 0) goto L51;
    L54:
        if (r20 == true) goto L56;
    L58:
        if (r20 == false) goto L62;
        if (r19.b3() == false) goto L62;
    L66:
        int r23 = r19.getHeight() + r19.getMarginBottom();
        p r24 = p.a;
        if (r23 < ((int) r24.h(r22))) goto L70;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "height", Integer.valueOf(r19.getHeight() - r19.getMarginBottom()));
    L70:
        if (r19.U2() <= 0) goto L76;
        if (getContext() == null) goto L76;
        if (r20 == true) goto L76;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "height", Integer.valueOf((int) r24.h((int) (r22 * (r19.U2() / 100.0f)))));
    L76:
        if (getContext() == null) goto L82;
        if (r20 == true) goto L82;
        if (r19.getHeight() <= r22) goto L82;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "height", Integer.valueOf((int) r24.h(r22)));
    L82:
        if (isFullScreen() == false) goto L85;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "height", Integer.valueOf((int) r24.h(p.c(getActivity()).heightPixels - t.a.e(getActivity()))));
    L85:
        if (r19.B3() <= 0) goto L91;
        if (getContext() == null) goto L91;
        if (r20 == true) goto L91;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "width", Integer.valueOf((int) r24.h((int) (r21 * (r19.B3() / 100.0f)))));
    L91:
        if (r19.c3() == false) goto L94;
        if (r20 == false) goto L94;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "width", Integer.valueOf((int) r24.h(r19.d3() + r22)));
    L94:
        PopupHybridParamVoNew r25 = this.e;
        if (r25 == null) goto L107;
        HybridKitType r26 = r25.a;
        HybridKitType r110 = HybridKitType.LYNX;
        if (r26 == r110) goto L102;
        if (r19.getHeight() > 0) goto L102;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "height", 450);
    L102:
        if (r25.a == r110) goto L107;
        if (r19.getWidth() > 0) goto L107;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "width", r10);
    L107:
        if (r19.y3() == false) goto L110;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "height", Integer.valueOf(r19.getHeight() + 48));
    L110:
        if (getContext() != null) goto L112;
    L139:
        int r27 = 1;
    L141:
        if (r19.z3() != r27) goto L150;
        if (m.c() == true) goto L150;
        if (com.bytedance.android.annie.ng.g.b().b.d == true) goto L150;
        Integer r28 = ((d9.b) getService(d9.b.class)).f1(MapsKt.emptyMap());
        if (r28 == null) goto L150;
        r28.intValue();
        com.bytedance.android.annie.scheme.helper.a.d(r19, "height", Integer.valueOf((int) (((double) p.a.h(r28.intValue())) + 0.5d)));
        com.bytedance.android.annie.scheme.helper.a.d(r19, "radius_top_left", 0);
        com.bytedance.android.annie.scheme.helper.a.d(r19, "radius_top_right", 0);
    L150:
        if (r19.l3() >= 0) goto L153;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "radius", 0);
    L153:
        if (r19.o3() >= 0) goto L156;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "radius_top_left", 0);
    L156:
        if (r19.p3() >= 0) goto L159;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "radius_top_right", 0);
    L159:
        if (r19.n3() >= 0) goto L162;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "radius_bottom_right", 0);
    L162:
        if (r19.m3() >= 0) goto L164;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "radius_bottom_left", 0);
    L164:
        if (r20 == true) goto L166;
        return;
    L166:
        if (AnnieConfigSettingKeys.IMPL_HORIZONTAL_PARAMS.a().booleanValue() == false) goto L181;
        float r29 = RangesKt.coerceAtMost(r19.W2(), 100) / 100.0f;
        float r30 = 0;
        if (r29 <= r30) goto L170;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "height", Integer.valueOf((int) p.a.h((int) (r22 * r29))));
    L170:
        float r31 = RangesKt.coerceAtMost(r19.Z2(), 100) / 100.0f;
        if (r31 <= r30) goto L174;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "width", Integer.valueOf((int) p.a.h((int) (r21 * r31))));
    L174:
        if (r19.X2() <= 0) goto L182;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "radius", Integer.valueOf(r19.X2()));
        return;
    L182:
        return;
    L181:
        return;
    L112:
        if (r19.S2() == false) goto L139;
        t r32 = t.a;
        int r33 = r32.e(getContext());
        if (r19.A3() == false) goto L116;
        Context r111 = getContext();
        Intrinsics.checkNotNull(r111);
        int r34 = r32.d(r111) - r33;
    L120:
        com.bytedance.android.annie.scheme.helper.a.d(r19, "height", Integer.valueOf(((int) r24.h(r34)) + 2));
        if (r19.u3() <= 0) goto L131;
        float r112 = 1 - RangesKt.coerceAtMost(r19.u3() / 100.0f, 1.0f);
        if (r19.A3() == false) goto L125;
        r34 = r34 + r33;
    L125:
        float r35 = r34 * r112;
        if (r19.A3() == false) goto L128;
        int r36 = r33 + 2;
    L129:
        com.bytedance.android.annie.scheme.helper.a.d(r19, "up_offset_height", Integer.valueOf((int) r24.h((int) (r35 - r36))));
        goto L131
    L128:
        r36 = 0;
    L131:
        if (StringUtils.isEmpty(r19.w3()) == false) goto L133;
        String r37 = "#181C2D";
    L177:
        int r38 = Color.parseColor(r37);     // Catch: Throwable -> L136
        r27 = 1;
    L138:
        this.h = r38;
    L136:
        th = move-exception;
        int r39 = x8.a.a;
        r27 = 1;
        x8.a.c("ParsingUriParamHelper", th, true);
        r38 = 0;
        goto L138
    L133:
        r37 = r19.w3();
        goto L177
    L116:
        Context r40 = getContext();
        Rect r113 = new Rect();
        if ((r40 instanceof Activity) == false) goto L119;
        t.b(((Activity) r40).getWindow()).getWindowVisibleDisplayFrame(r113);
    L119:
        r34 = r113.height();
    L62:
        if (r19.T2() != 80) goto L66;
        float r41 = r19.getHeight();
        p r42 = p.a;
        int r43 = (int) (r22 * 0.85f);
        if (r41 <= r42.h(r43)) goto L66;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "height", Integer.valueOf((int) r42.h(r43)));
        HybridLogger r44 = HybridLogger.a;
        HybridLogger.m("BaseDialogFragment", "screenHeight: " + r22 + "; height: " + r19.getHeight(), null, null, 12);
        goto L66
    L56:
        if (r19.getHeight() <= r22) goto L58;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "height", Integer.valueOf((int) p.a.h(r22 - (r19.d3() * 2))));
        goto L58
    L51:
        if (getContext() == null) goto L54;
        if (r20 == true) goto L54;
        com.bytedance.android.annie.scheme.helper.a.d(r19, "height", Integer.valueOf((int) p.a.h((int) (((double) (r19.q3() * r21)) / 375.0d))));
        HybridLogger r45 = HybridLogger.a;
        HybridLogger.m("BaseDialogFragment", "rateHeight: " + r19.q3() + "; height: " + r19.getHeight(), null, null, 12);
        goto L54
    }
}
