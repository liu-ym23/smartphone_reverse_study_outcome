package com.larus.bmhome.miniartifact.product;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.miniartifact.input.MiniArtifactInputComponent;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.mainbot.api.miniartifact.MiniArtifactInputContent;
import com.larus.mainbot.api.miniartifact.MiniArtifactProductParams;
import com.larus.mainbot.api.miniartifact.MiniArtifactTemplateParams;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.search.api.model.SchemaSuffixMap;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001/\u0018\u0000 E2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001EB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u00020 H\u0016J\b\u00109\u001a\u000207H\u0002J\b\u0010:\u001a\u000207H\u0016J\b\u0010;\u001a\u000207H\u0002J\b\u0010<\u001a\u000207H\u0002J\u0010\u0010=\u001a\u0002072\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u000207H\u0002J\b\u0010A\u001a\u00020?H\u0002J\b\u0010B\u001a\u000207H\u0002J\b\u0010C\u001a\u000207H\u0016J\b\u0010D\u001a\u000207H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100R\u001a\u00101\u001a\u00020-X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006F"}, d2 = {"Lcom/larus/bmhome/miniartifact/product/MiniArtifactProductComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/miniartifact/product/abilities/MiniArtifactTitleBarAndWebAbility;", "<init>", "()V", "miniInputAbility", "Lcom/larus/bmhome/miniartifact/input/IMiniArtifactInputAbility;", "getMiniInputAbility", "()Lcom/larus/bmhome/miniartifact/input/IMiniArtifactInputAbility;", "miniInputAbility$delegate", "Lkotlin/Lazy;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "preloadHelper", "Lcom/larus/bmhome/miniartifact/product/network/PreloadMiniArtifactShareHelper;", "getPreloadHelper", "()Lcom/larus/bmhome/miniartifact/product/network/PreloadMiniArtifactShareHelper;", "preloadHelper$delegate", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "shareDialog", "Landroidx/fragment/app/DialogFragment;", "haveReportProductShow", "", "ivBack", "Landroid/view/View;", "tvSubTitle", "Landroid/widget/TextView;", "ivShare", "tvTitle", "inputView", "webFragment", "Lcom/larus/platform/model/webview/AbsWebFragment;", "enterTimestamp", "", "firstFinishTimestamp", "Ljava/lang/Long;", "sendMessageCount", "", "miniArtifactProductLoadFinishNotifier", "com/larus/bmhome/miniartifact/product/MiniArtifactProductComponent$miniArtifactProductLoadFinishNotifier$1", "Lcom/larus/bmhome/miniartifact/product/MiniArtifactProductComponent$miniArtifactProductLoadFinishNotifier$1;", "contentViewId", "getContentViewId", "()I", "setContentViewId", "(I)V", "onViewCreated", "", "view", "initInputView", "exitPage", "setupBackButton", "setupSubTitle", "refreshUIStatus", "refreshSource", "", "refreshInputView", "generateWebUrl", "addWebView", "onDestroy", "performShare", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactProductComponent extends BaseContentWidget implements er8.b {
    public static final /* synthetic */ int C = 0;
    public final b A;
    public int B;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public DialogFragment q;
    public boolean r;
    public View s;
    public View t;
    public TextView u;
    public View v;
    public AbsWebFragment w;
    public long x;
    public Long y;
    public int z;

    public static final class a {
    }

    public static final class b implements fr8.a {
        public final /* synthetic */ MiniArtifactProductComponent a;

        public b(MiniArtifactProductComponent r1) {
            this.a = r1;
        }

        @Override // fr8.a
        public final void a(ik9.d r13) {
            Intrinsics.checkNotNullParameter(r13, "miniArtifactProductLoadFinish");
            String r4 = r13.a;
            FLogger.a.i("MiniArtifactProductPage", "notifyMiniArtifactProductLoadFinished title -> " + r4 + '-' + r13.b + "- trackParams:" + r13.c);
            MiniArtifactProductParams r1 = s1a.a.g(s1a.a.c(this.a)).a(MiniArtifactProductParams.class);
            if (r1 == null) goto L13;
            MiniArtifactProductComponent r0 = this.a;
            Boolean r5 = Boolean.TRUE;
            String r6 = r13.b;
            Map r7 = r1.getTrackParams();
            if (r7 != null) goto L7;
            r7 = MapsKt.emptyMap();
        L7:
            Map r14 = r13.c;
            if (r14 != null) goto L10;
            r14 = MapsKt.emptyMap();
        L10:
            s1a.a.g(s1a.a.c(r0)).n(MiniArtifactProductParams.copy$default(r1, null, null, r4, r5, r6, MapsKt.plus(r7, r14), null, null, 195, null), MiniArtifactProductParams.class);
            int r15 = MiniArtifactProductComponent.C;
            r0.h3("JsbNotify");
            if (r0.y != null) goto L13;
            r0.y = Long.valueOf(System.currentTimeMillis());
        L13:
            er8.a r16 = (er8.a) s1a.a.g(s1a.a.c(this.a)).getAbility(er8.a.class);
            if (r16 == null) goto L17;
            r16.RO();
            return;
        }
    }

    public static final class c implements Function0<br8.a> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(br8.a.class));
        }
    }

    public static final class d implements Function0<va8.o> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.o.class));
        }
    }

    static {
    }

    @Override // er8.b
    public final void GH() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r1 != null) goto L5;
        return;
    L5:
        MiniArtifactProductParams r2 = s1a.d.a(this).a(MiniArtifactProductParams.class);
        if (r2 == null) goto L21;
        long r3 = System.currentTimeMillis() - this.x;
        Long r5 = this.y;
        if (r5 == null) goto L10;
        long r6 = r5.longValue() - this.x;
    L11:
        int r7 = ar8.a.a;
        if (Intrinsics.areEqual(r2.getMiniArtifactFinished(), Boolean.TRUE) == false) goto L14;
        String r8 = "finish";
    L15:
        int r9 = MiniArtifactInputComponent.A;
        boolean r10 = MiniArtifactInputComponent.a.a();
        int r11 = this.z;
        String r12 = r2.getMiniArtifactId();
        String r4 = r2.getMiniArtifactTitle();
        Intrinsics.checkNotNullParameter(r8, "status");
        JSONObject r13 = new JSONObject();
        r13.put("status", r8);
        r13.put("loading_duration", r6);
        r13.put("stay_duration", r3);
        r13.put("is_input_downgrade", r10 ? 1 : 0);
        r13.put("send_message_count", r11);
        if (r12 == null) goto L18;
        r13.put("artifact_id", r12);
    L18:
        if (r4 == null) goto L20;
        r13.put("artifact_name", r4);
    L20:
        com.larus.platform.service.o.a.reportEvent("rd_mini_artifact_product_leave", r13);
        goto L21
    L14:
        r8 = "loading";
        goto L15
    L10:
        r6 = r3;
    L21:
        r1.finish();
        Intrinsics.checkNotNullParameter(this, "<this>");
        MiniArtifactProductParams r0 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).a(MiniArtifactProductParams.class);
        if (r0 != null) goto L24;
        return;
    L24:
        if (Intrinsics.areEqual(r0.getPushFromBottom(), Boolean.TRUE) == false) goto L28;
        r1.overridePendingTransition(0, 2130772402);
        return;
    }

    public final void onDestroy() {
        List<fr8.a> r0 = fr8.b.a;
        b r1 = this.A;
        Intrinsics.checkNotNullParameter(r1, "notifier");
        ((ArrayList) fr8.b.a).remove(r1);
    }

    public MiniArtifactProductComponent() {
        this.m = LazyKt.lazy(new c(this));
        this.n = LazyKt.lazy(new d(this));
        this.o = LazyKt.lazy(new com.larus.bmhome.miniartifact.product.c());
        this.p = LazyKt.lazy(new com.larus.bmhome.miniartifact.product.d(this));
        this.A = new b(this);
        this.B = 2131384813;
    }

    public final void Y2() {
        MiniArtifactProductParams r0 = s1a.d.a(this).a(MiniArtifactProductParams.class);
        if (r0 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r0.getMiniArtifactFinished(), Boolean.FALSE) == false) goto L20;
        AbsWebFragment r1 = this.w;
        if (r1 == null) goto L16;
        View r2 = r1.getView();
        if (r2 == null) goto L16;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L15;
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) r3;
        r4.bottomMargin = 0;
        r2.setLayoutParams(r4);
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L16:
        View r5 = this.v;
        if (r5 == null) goto L75;
        e1.o(r5);
        return;
    L75:
        return;
    L20:
        int r6 = MiniArtifactInputComponent.A;
        if (MiniArtifactInputComponent.a.a() == false) goto L35;
        AbsWebFragment r7 = this.w;
        if (r7 == null) goto L31;
        View r8 = r7.getView();
        if (r8 == null) goto L31;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if (r9 == null) goto L30;
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) r9;
        r10.bottomMargin = 0;
        r8.setLayoutParams(r10);
        goto L31
    L30:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L31:
        View r11 = this.v;
        if (r11 == null) goto L76;
        e1.o(r11);
        return;
    L76:
        return;
    L35:
        View r12 = this.v;
        boolean r13 = true;
        if (r12 != null) goto L38;
    L40:
        boolean r14 = false;
    L41:
        if (r14 == false) goto L62;
        va8.o r15 = (va8.o) this.n.getValue();
        if (r15 != null) goto L45;
    L47:
        r13 = false;
    L48:
        if (r13 == false) goto L62;
        AbsWebFragment r16 = this.w;
        if (r16 == null) goto L58;
        View r17 = r16.getView();
        if (r17 == null) goto L58;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r18 == null) goto L57;
        FrameLayout.LayoutParams r19 = (FrameLayout.LayoutParams) r18;
        r19.bottomMargin = 0;
        r17.setLayoutParams(r19);
        goto L58
    L57:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L58:
        View r20 = this.v;
        if (r20 == null) goto L77;
        e1.o(r20);
        return;
    L77:
        return;
    L45:
        if (r15.n5() == true) goto L47;
    L62:
        AbsWebFragment r21 = this.w;
        if (r21 == null) goto L71;
        View r22 = r21.getView();
        if (r22 == null) goto L71;
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if (r23 == null) goto L70;
        FrameLayout.LayoutParams r24 = (FrameLayout.LayoutParams) r23;
        r24.bottomMargin = i5.s0();
        r22.setLayoutParams(r24);
        goto L71
    L70:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L71:
        View r25 = this.v;
        if (r25 == null) goto L78;
        e1.x(r25);
        return;
    L78:
        return;
    L38:
        if (ViewExtKt.h(r12) != true) goto L40;
        r14 = true;
        goto L41
    }

    public final int U2() {
        return this.B;
    }

    public final void X2(int r1) {
        this.B = r1;
    }

    public final void h3(String r4) {
        FLogger.a.i("MiniArtifactProductPage", "refreshTitleAndShareIcon===refreshSource:".concat(r4));
        MiniArtifactProductParams r5 = s1a.d.a(this).a(MiniArtifactProductParams.class);
        if (r5 != null) goto L5;
        return;
    L5:
        Boolean r0 = r5.getMiniArtifactFinished();
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == true) goto L8;
    L15:
        View r2 = this.t;
        if (r2 == null) goto L19;
        e1.o(r2);
    L19:
        if (Intrinsics.areEqual(r5.getMiniArtifactFinished(), r1) == false) goto L31;
        String r6 = r5.getMiniArtifactTitle();
        if (r6 != null) goto L24;
        r6 = "";
    L24:
        if (r6.length() <= 0) goto L26;
        boolean r3 = true;
    L27:
        if (r3 == false) goto L34;
        TextView r7 = this.u;
        if (r7 == null) goto L34;
        r7.setText(r6);
    L34:
        Y2();
        return;
    L26:
        r3 = false;
        goto L27
    L31:
        TextView r8 = this.u;
        if (r8 == null) goto L34;
        r8.setText(getContext().getString(2131900430));
        goto L34
    L8:
        if (o0.d(r5.getMiniArtifactId()) == false) goto L15;
        View r9 = this.t;
        if (r9 == null) goto L12;
        e1.x(r9);
    L12:
        View r10 = this.t;
        if (r10 == null) goto L19;
        e1.d(r10, new i(this));
        goto L19
    }

    public final void onViewCreated(View r13) {
        Intrinsics.checkNotNullParameter(r13, "view");
        Intrinsics.checkNotNullParameter(r13, "view");
        this.x = System.currentTimeMillis();
        this.s = r13.findViewById(2131375900);
        this.t = r13.findViewById(2131375944);
        this.u = (TextView) r13.findViewById(2131390084);
        this.v = r13.findViewById(2131365588);
        TextView r14 = (TextView) r13.findViewById(2131387517);
        if (r14 == null) goto L5;
        e1.d(r14, new h(this));
    L5:
        e1.d(this.s, new j(this));
        MiniArtifactProductParams r15 = s1a.d.a(this).a(MiniArtifactProductParams.class);
        if (r15 == null) goto L24;
        Boolean r1 = r15.getMiniArtifactFinished();
        Boolean r2 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r2) == false) goto L13;
        if (this.y != null) goto L13;
        this.y = Long.valueOf(System.currentTimeMillis());
    L13:
        if (Intrinsics.areEqual(r15.getMiniArtifactFinished(), r2) == false) goto L15;
        String r3 = "finish";
    L17:
        if (this.r == true) goto L24;
        this.r = true;
        int r4 = ar8.a.a;
        int r5 = MiniArtifactInputComponent.A;
        boolean r6 = MiniArtifactInputComponent.a.a();
        String r7 = r15.getMiniArtifactId();
        String r16 = r15.getMiniArtifactTitle();
        Intrinsics.checkNotNullParameter(r3, "status");
        JSONObject r8 = new JSONObject();
        r8.put("status", r3);
        r8.put("is_input_downgrade", r6 ? 1 : 0);
        if (r7 == null) goto L21;
        r8.put("artifact_id", r7);
    L21:
        if (r16 == null) goto L23;
        r8.put("artifact_name", r16);
    L23:
        com.larus.platform.service.o.a.reportEvent("rd_mini_artifact_product_show", r8);
        goto L24
    L15:
        r3 = "loading";
    L24:
        List<fr8.a> r17 = fr8.b.a;
        b r18 = this.A;
        Intrinsics.checkNotNullParameter(r18, "notifier");
        ((ArrayList) fr8.b.a).add(r18);
        AbsWebFragment r19 = com.larus.platform.service.q.a.c();
        this.w = r19;
        Map r9 = null;
        if (r19 == null) goto L89;
        MiniArtifactProductParams r10 = s1a.d.a(this).a(MiniArtifactProductParams.class);
        if (r10 == null) goto L29;
        String r11 = r10.getMiniArtifactUrl();
    L30:
        String r12 = "";
        if (r11 != null) goto L33;
        r11 = "";
    L33:
        if (r10 == null) goto L35;
        String r20 = r10.getMiniArtifactUserInputInfoId();
    L36:
        if (r20 == null) goto L40;
        r12 = r20;
    L40:
        if (r11.length() != 0) goto L42;
        boolean r21 = true;
    L43:
        if (r21 == true) goto L84;
        Uri.Builder r22 = UriProtector.parse(r11).buildUpon();
        if (r12.length() <= 0) goto L48;
        boolean r23 = true;
    L49:
        if (r23 == false) goto L59;
        String r24 = UriProtector.getQueryParameter(r22.build(), "mini_artifact_user_input_info_id");
        if (r24 != null) goto L53;
    L56:
        boolean r25 = true;
    L57:
        if (r25 == false) goto L59;
        r22.appendQueryParameter("mini_artifact_user_input_info_id", r12);
        goto L59
    L53:
        if (r24.length() == 0) goto L56;
        r25 = false;
    L59:
        String r26 = PollingConfigService.a.f("mini_art_dg");
        String r27 = TriggerSendLoading.NO_LOADING;
        if (r26 != null) goto L62;
        r26 = TriggerSendLoading.NO_LOADING;
    L62:
        r22.appendQueryParameter("mini_art_dg", r26);
        if (r10 == null) goto L65;
        boolean r28 = Intrinsics.areEqual(r10.getTemplateEnableConfig(), Boolean.FALSE);
    L66:
        if (r28 == true) goto L70;
        r27 = "1";
    L70:
        if (r27.length() <= 0) goto L72;
        boolean r29 = true;
    L73:
        if (r29 == false) goto L83;
        String r30 = UriProtector.getQueryParameter(r22.build(), "template_enable_config");
        if (r30 != null) goto L77;
    L80:
        boolean r31 = true;
    L81:
        if (r31 == false) goto L83;
        r22.appendQueryParameter("template_enable_config", r27);
        goto L83
    L77:
        if (r30.length() == 0) goto L80;
        r31 = false;
    L83:
        r11 = r22.build().toString();
        goto L84
    L72:
        r29 = false;
        goto L73
    L65:
        r28 = false;
        goto L66
    L48:
        r23 = false;
    L84:
        int r32 = ar8.c.a;
        r19.setArguments(ar8.c.a(r11, new SchemaSuffixMap(MapsKt.mapOf(new Pair[]{TuplesKt.to("bdhm_bid", "z_activity"), TuplesKt.to("bdhm_pid", "z_coding_artifact_page")}))));
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentTransaction r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r19, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131393123) == true) goto L88;
        r0 = r0.replace(2131393123, r19);
    L88:
        r0.commitAllowingStateLoss();
        goto L89
    L42:
        r21 = false;
        goto L43
    L35:
        r20 = null;
        goto L36
    L29:
        r11 = null;
    L89:
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).c(this, er8.b.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        t1a.b r110 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        Intrinsics.checkNotNullParameter(this, "<this>");
        MiniArtifactProductParams r33 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).a(MiniArtifactProductParams.class);
        if (r33 == null) goto L92;
        r9 = r33.getTrackParams();
    L92:
        r110.n(new MiniArtifactTemplateParams(new MiniArtifactInputContent(null, null, null, null, r9, 15, null), null, null, null, "", null, 46, null), MiniArtifactTemplateParams.class);
        br8.a r111 = (br8.a) this.m.getValue();
        if (r111 == null) goto L95;
        r111.xI(new f(this));
    L95:
        t0.c(new g(this));
        t0.c(new e(this));
    }
}
