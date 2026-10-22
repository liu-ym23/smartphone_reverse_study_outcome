package com.larus.bmhome.miniartifact.template;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBindings;
import ar8.b;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.miniartifact.input.MiniArtifactInputComponent;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.mainbot.api.miniartifact.MiniArtifactBizInfo;
import com.larus.mainbot.api.miniartifact.MiniArtifactInputContent;
import com.larus.mainbot.api.miniartifact.MiniArtifactTemplateParams;
import com.larus.mainbot.impl.databinding.LarusFragmentMiniArtifactTemplateBinding;
import com.larus.mainbot.impl.databinding.LarusMiniArtifactInputBinding;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.platform.service.o;
import com.larus.platform.service.q;
import com.larus.search.api.model.SchemaSuffixMap;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import gr8.c;
import gr8.d;
import gr8.e;
import gr8.i;
import java.io.Serializable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ny9.s;
import ny9.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010 \u001a\u00020\u0010H\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0010H\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u0010H\u0002J\b\u0010(\u001a\u00020\u0010H\u0016J\b\u0010)\u001a\u00020\u0010H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006+"}, d2 = {"Lcom/larus/bmhome/miniartifact/template/MiniArtifactTemplateFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/bmhome/miniartifact/template/IMiniArtifactTemplateFragmentAbility;", "<init>", "()V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusFragmentMiniArtifactTemplateBinding;", "miniArtifactTemplateParams", "Lcom/larus/mainbot/api/miniartifact/MiniArtifactTemplateParams;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "finishPage", "setupTitleBar", "onAttach", "context", "Landroid/content/Context;", "trackClickCloseTemplateDetail", "addWebViewFragment", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onResume", "autoLogEnterPage", "", "onDestroy", "getCurrentPageName", "", "trackEnterTemplateDetail", "enterInputMode", "exitInputMode", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactTemplateFragment extends TraceFragment implements gr8.a {
    public static final /* synthetic */ int h = 0;
    public LarusFragmentMiniArtifactTemplateBinding e;
    public MiniArtifactTemplateParams f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return false;
    }

    public final String k() {
        return "ai_code_template_detail_page";
    }

    @Override // gr8.a
    public final void XP() {
        LarusFragmentMiniArtifactTemplateBinding r0 = this.e;
        if (r0 == null) goto L15;
        LarusMiniArtifactInputBinding r1 = r0.b;
        if (r1 == null) goto L16;
        ChatConstraintLayout r2 = r1.a;
        if (r2 == null) goto L19;
        r2.setVisibility(0);
        LarusFragmentMiniArtifactTemplateBinding r3 = this.e;
        if (r3 == null) goto L17;
        FrameLayout r4 = r3.d;
        if (r4 == null) goto L18;
        r4.setVisibility(8);
        return;
    L18:
        return;
    L17:
        return;
    L19:
        return;
    L16:
        return;
    }

    @Override // gr8.a
    public final void wo() {
        LarusFragmentMiniArtifactTemplateBinding r0 = this.e;
        if (r0 == null) goto L15;
        LarusMiniArtifactInputBinding r1 = r0.b;
        if (r1 == null) goto L16;
        ChatConstraintLayout r2 = r1.a;
        if (r2 == null) goto L19;
        r2.setVisibility(8);
        LarusFragmentMiniArtifactTemplateBinding r3 = this.e;
        if (r3 == null) goto L17;
        FrameLayout r4 = r3.d;
        if (r4 == null) goto L18;
        r4.setVisibility(0);
        return;
    L18:
        return;
    L17:
        return;
    L19:
        return;
    L16:
        return;
    }

    public MiniArtifactTemplateFragment() {
        this.g = LazyKt.lazy(new c(this));
    }

    public final void U90() {
        MiniArtifactTemplateParams r0 = s1a.a.g(this).a(MiniArtifactTemplateParams.class);
        String r1 = null;
        if (r0 == null) goto L7;
        MiniArtifactInputContent r2 = r0.getMiniArtifactInputContent();
        if (r2 == null) goto L7;
        Map r3 = r2.getTrackParams();
    L8:
        int r4 = ar8.a.a;
        Long r5 = b.b(r3);
        String r6 = b.c(r3);
        Integer r7 = b.d(r3);
        String r8 = b.e(r3);
        if (r0 == null) goto L15;
        MiniArtifactInputContent r9 = r0.getMiniArtifactInputContent();
        if (r9 == null) goto L15;
        MiniArtifactBizInfo r10 = r9.getMiniArtifactBizInfo();
        if (r10 == null) goto L15;
        String r11 = r10.getTemplateId();
    L16:
        if (r0 == null) goto L18;
        String r12 = r0.getTemplateTitle();
    L20:
        if (r12 != null) goto L22;
        r12 = "";
    L22:
        if (r0 == null) goto L28;
        MiniArtifactInputContent r13 = r0.getMiniArtifactInputContent();
        if (r13 == null) goto L28;
        MiniArtifactBizInfo r14 = r13.getMiniArtifactBizInfo();
        if (r14 == null) goto L28;
        r1 = r14.getTemplateVersion();
    L28:
        JSONObject r15 = new JSONObject();
        if (r5 == null) goto L31;
        r15.put("action_bar_template_id", r5.longValue());
    L31:
        r15.put("click_from", "");
        r15.put("current_page", "ai_code_template_detail_page");
        if (r6 == null) goto L34;
        r15.put("enter_method", r6);
    L34:
        if (r7 == null) goto L36;
        r15.put("position", r7.intValue());
    L36:
        if (r8 == null) goto L38;
        r15.put("previous_page", r8);
    L38:
        if (r11 == null) goto L40;
        r15.put("template_id", r11);
    L40:
        r15.put("template_name", r12);
        if (r1 == null) goto L43;
        r15.put("template_version", r1);
    L43:
        r15.put("template_sub_type", "ai_code");
        r15.put("template_type", "ai_code");
        o.a.reportEvent("click_close_template_detail", r15);
        FragmentActivity r16 = getActivity();
        if (r16 == null) goto L46;
        r16.finish();
    L46:
        MiniArtifactTemplateParams r17 = this.f;
        if (r17 == null) goto L49;
        boolean r18 = Intrinsics.areEqual(r17.getPushFromBottom(), Boolean.TRUE);
    L50:
        if (r18 == false) goto L55;
        FragmentActivity r19 = getActivity();
        if (r19 == null) goto L56;
        r19.overridePendingTransition(0, 2130772402);
        return;
    L56:
        return;
    L55:
        return;
    L49:
        r18 = false;
        goto L50
    L18:
        r12 = null;
    L15:
        r11 = null;
    L7:
        r3 = null;
        goto L8
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public final void onResume() {
        super.onResume();
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new AnonymousClass1(this));
    }

    public final void onCreate(Bundle r21) {
        super.onCreate(r21);
        t1a.b r1 = s1a.a.g(this);
        s1a.a.g(this).n(new de8.c(getArguments(), null, true, null, null, false, null, null, null, null, false, false, null, 0, 32762), de8.c.class);
        r1.n(new s(getArguments()), s.class);
        String r3 = null;
        r1.n(new u(null), u.class);
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_MULTI_MODAL);
        k1a.b.a(this, new e(this));
        Bundle r2 = getArguments();
        if (r2 == null) goto L5;
        Serializable r4 = r2.getSerializable("mini_artifact_template_page_navigation_params");
    L7:
        if ((r4 instanceof MiniArtifactTemplateParams) == false) goto L9;
        MiniArtifactTemplateParams r5 = (MiniArtifactTemplateParams) r4;
    L10:
        this.f = r5;
        if (r5 == null) goto L13;
        s1a.a.g(this).n(r5, MiniArtifactTemplateParams.class);
    L13:
        s1a.a.g(this).c(this, gr8.a.class);
        MiniArtifactTemplateParams r6 = s1a.a.g(this).a(MiniArtifactTemplateParams.class);
        if (r6 == null) goto L18;
        MiniArtifactInputContent r7 = r6.getMiniArtifactInputContent();
        if (r7 == null) goto L18;
        Map r8 = r7.getTrackParams();
    L19:
        int r9 = ar8.a.a;
        Long r10 = b.b(r8);
        String r11 = b.c(r8);
        Integer r12 = b.d(r8);
        String r13 = b.e(r8);
        if (r6 == null) goto L26;
        MiniArtifactInputContent r14 = r6.getMiniArtifactInputContent();
        if (r14 == null) goto L26;
        MiniArtifactBizInfo r15 = r14.getMiniArtifactBizInfo();
        if (r15 == null) goto L26;
        String r16 = r15.getTemplateId();
    L27:
        if (r6 == null) goto L29;
        String r17 = r6.getTemplateTitle();
    L30:
        if (r17 != null) goto L32;
        r17 = "";
    L32:
        if (r6 == null) goto L38;
        MiniArtifactInputContent r18 = r6.getMiniArtifactInputContent();
        if (r18 == null) goto L38;
        MiniArtifactBizInfo r19 = r18.getMiniArtifactBizInfo();
        if (r19 == null) goto L38;
        r3 = r19.getTemplateVersion();
    L38:
        JSONObject r20 = new JSONObject();
        if (r10 == null) goto L41;
        r20.put("action_bar_template_id", r10.longValue());
    L41:
        r20.put("current_page", "ai_code_template_detail_page");
        if (r11 == null) goto L44;
        r20.put("enter_method", r11);
    L44:
        if (r12 == null) goto L46;
        r20.put("position", r12.intValue());
    L46:
        if (r13 == null) goto L48;
        r20.put("previous_page", r13);
    L48:
        if (r16 == null) goto L50;
        r20.put("template_id", r16);
    L50:
        r20.put("template_name", r17);
        if (r3 == null) goto L53;
        r20.put("template_version", r3);
    L53:
        r20.put("template_sub_type", "ai_code");
        r20.put("template_type", "ai_code");
        o.a.reportEvent("enter_template_detail", r20);
        return;
    L29:
        r17 = null;
    L26:
        r16 = null;
    L18:
        r8 = null;
        goto L19
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L7
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        ChatConstraintLayout r14 = r11.inflate(2131562412, r12, false);
        int r15 = 2131365030;
        if (ViewBindings.findChildViewById(r14, 2131365030) == null) goto L110;
        r15 = 2131365031;
        if (((ImageView) ViewBindings.findChildViewById(r14, 2131365031)) == null) goto L110;
        r15 = 2131365588;
        View r1 = ViewBindings.findChildViewById(r14, 2131365588);
        if (r1 == null) goto L110;
        LarusMiniArtifactInputBinding r4 = LarusMiniArtifactInputBinding.a(r1);
        r15 = 2131375900;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r14, 2131375900);
        if (r5 == null) goto L110;
        r15 = 2131379482;
        if (((LinearLayout) ViewBindings.findChildViewById(r14, 2131379482)) == null) goto L110;
        r15 = 2131379483;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131379483);
        if (r6 == null) goto L110;
        ChatConstraintLayout r16 = r14;
        if (((TextView) ViewBindings.findChildViewById(r14, 2131387517)) != null) goto L17;
        r15 = 2131387517;
        goto L110
    L17:
        if (ViewBindings.findChildViewById(r14, 2131388867) == null) goto L107;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r14, 2131390084);
        if (r8 == null) goto L106;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131393123);
        if (r9 == null) goto L105;
        this.e = new LarusFragmentMiniArtifactTemplateBinding(r16, r4, r5, r6, r16, r8, r9);
        if (r16 == null) goto L27;
        ViewStub r17 = (ViewStub) r16.findViewById(2131375364);
        if (r17 == null) goto L27;
        InputViewCreatorDelegate.b.a(r17, 2131375364);
    L27:
        Context r18 = getContext();
        if (r18 == null) goto L36;
        LarusFragmentMiniArtifactTemplateBinding r2 = this.e;
        if (r2 == null) goto L36;
        LarusMiniArtifactInputBinding r3 = r2.b;
        if (r3 == null) goto L36;
        ChatConstraintLayout r7 = r3.a;
        if (r7 == null) goto L36;
        r7.k6(r18);
        r7.setDisableBottomPadding(true);
        r7.setDisableTopPadding(true);
        r7.R5();
    L36:
        LarusFragmentMiniArtifactTemplateBinding r19 = this.e;
        if (r19 == null) goto L41;
        final ChatConstraintLayout r10 = r19.e;
        if (r10 == null) goto L41;
        r10.setDisableBottomPadding(true);
        r10.setDisableTopPadding(true);
        r10.R5();
        ViewExtKt.l(r10, new d(this, r10), null, null, null, 14);
    L41:
        MiniArtifactTemplateParams r110 = this.f;
        String r20 = null;
        if (r110 == null) goto L44;
        String r111 = r110.getTemplateUrl();
    L45:
        String r21 = "";
        if (r111 != null) goto L48;
        r111 = "";
    L48:
        AbsWebFragment r22 = q.a.c();
        if (r22 == null) goto L55;
        int r23 = ar8.c.a;
        r22.setArguments(ar8.c.a(r111, new SchemaSuffixMap(MapsKt.mapOf(new Pair[]{TuplesKt.to("bdhm_bid", "z_activity"), TuplesKt.to("bdhm_pid", "z_coding_template_detail")}))));
        FragmentTransaction r112 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r112, r22, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131393123) == true) goto L54;
        r112 = r112.replace(2131393123, r22);
    L54:
        r112.commitAllowingStateLoss();
    L55:
        LarusFragmentMiniArtifactTemplateBinding r113 = this.e;
        if (r113 == null) goto L58;
        ImageView r114 = r113.c;
    L59:
        e1.d(r114, new i(this));
        LarusFragmentMiniArtifactTemplateBinding r115 = this.e;
        if (r115 == null) goto L70;
        TextView r116 = r115.f;
        if (r116 == null) goto L70;
        MiniArtifactTemplateParams r117 = this.f;
        if (r117 == null) goto L66;
        String r118 = r117.getTemplateTitle();
    L67:
        if (r118 != null) goto L69;
        r118 = "";
    L69:
        r116.setText(r118);
        goto L70
    L66:
        r118 = null;
    L70:
        int r119 = ar8.a.a;
        int r120 = MiniArtifactInputComponent.A;
        boolean r121 = MiniArtifactInputComponent.a.a();
        MiniArtifactTemplateParams r122 = this.f;
        if (r122 == null) goto L77;
        MiniArtifactInputContent r123 = r122.getMiniArtifactInputContent();
        if (r123 == null) goto L77;
        MiniArtifactBizInfo r124 = r123.getMiniArtifactBizInfo();
        if (r124 == null) goto L77;
        String r125 = r124.getTemplateId();
    L78:
        MiniArtifactTemplateParams r0 = this.f;
        if (r0 == null) goto L81;
        String r24 = r0.getTemplateTitle();
    L82:
        if (r24 == null) goto L85;
        r21 = r24;
    L85:
        MiniArtifactTemplateParams r25 = this.f;
        if (r25 == null) goto L92;
        MiniArtifactInputContent r26 = r25.getMiniArtifactInputContent();
        if (r26 == null) goto L92;
        MiniArtifactBizInfo r27 = r26.getMiniArtifactBizInfo();
        if (r27 == null) goto L92;
        r20 = r27.getTemplateVersion();
    L92:
        JSONObject r28 = new JSONObject();
        r28.put("is_input_downgrade", r121 ? 1 : 0);
        if (r125 == null) goto L95;
        r28.put("template_id", r125);
    L95:
        r28.put("template_name", r21);
        if (r20 == null) goto L98;
        r28.put("template_version", r20);
    L98:
        o.a.reportEvent("rd_mini_artifact_template_page_show", r28);
        LarusFragmentMiniArtifactTemplateBinding r126 = this.e;
        if (r126 == null) goto L104;
        ChatConstraintLayout r127 = r126.e;
        if (r127 == null) goto L104;
        return r127;
    L104:
        return new View(r11.getContext());
    L81:
        r24 = null;
    L77:
        r125 = null;
        goto L78
    L58:
        r114 = null;
        goto L59
    L44:
        r111 = null;
        goto L45
    L105:
        r15 = 2131393123;
        goto L110
    L106:
        r15 = 2131390084;
        goto L110
    L107:
        r15 = 2131388867;
    L110:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }
}
