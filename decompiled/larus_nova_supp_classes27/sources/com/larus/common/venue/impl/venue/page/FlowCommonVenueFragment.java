package com.larus.common.venue.impl.venue.page;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.view.BottomMenuGridLayout;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common.venue.impl.databinding.LarusFragmentCommonVenueBinding;
import com.larus.common_ui.view.TouchInterceptingView;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;
import va8.l;
import va8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0006\u0010\u001f\u001a\u00020\u000fJ\b\u0010 \u001a\u00020\u000fH\u0002J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\f\u0010'\u001a\u00020\u000f*\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u001eH\u0002J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u000fH\u0002J\b\u0010-\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006/"}, d2 = {"Lcom/larus/common/venue/impl/venue/page/FlowCommonVenueFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "inputContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "binding", "Lcom/larus/common/venue/impl/databinding/LarusFragmentCommonVenueBinding;", "flowCommonVenueLynxAbility", "Lcom/larus/common/venue/impl/venue/ability/FlowCommonVenueLynxAbility;", "getFlowCommonVenueLynxAbility", "()Lcom/larus/common/venue/impl/venue/ability/FlowCommonVenueLynxAbility;", "flowCommonVenueLynxAbility$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "autoLogEnterPage", "", "fragmentOnActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "getCurrentPageName", "", "onBackPressed", "quitPage", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "addSpeakerView", "Lcom/larus/bmhome/view/ChatConstraintLayout;", "resolveViewId", "name", "resolveLayoutId", "bindToVContext", "attachComponent", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowCommonVenueFragment extends TraceFragment {
    public static final /* synthetic */ int g = 0;
    public LarusFragmentCommonVenueBinding e;
    public final Lazy f;

    public static final class a {
    }

    public static final class b implements m {
        public final /* synthetic */ FlowCommonVenueFragment a;

        public final Fragment getChatFragment() {
            return null;
        }

        public final l iX() {
            LarusFragmentCommonVenueBinding r0 = this.a.e;
            if (r0 != null) goto L7;
            return null;
        L7:
            return new com.larus.common.venue.impl.venue.page.a(r0);
        }

        public b(FlowCommonVenueFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final boolean S90() {
        return false;
    }

    public final String k() {
        return "common_venue";
    }

    public FlowCommonVenueFragment() {
        this.f = LazyKt.lazy(new c(this));
    }

    public final void onAttach(Context r21) {
        Intrinsics.checkNotNullParameter(r21, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r21);
        s1a.a.g(this).n(new dr9.d(false), dr9.d.class);
        de8.c r0 = new de8.c(getArguments(), getArguments(), true, null, null, false, null, null, null, null, false, false, null, 0, 32760);
        s1a.a.g(this).n(r0, de8.c.class);
        s1a.a.g(this).n(new x09.a(getArguments()), x09.a.class);
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        if (ObricFeatureServiceDelegate.b.a() == true) goto L10;
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_MULTI_MODAL);
        k1a.b.a(this, new com.larus.common.venue.impl.venue.page.b(this));
        return;
    L10:
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_MULTI_MODAL);     // Catch: IllegalStateException -> L6
        k1a.b.a(this, new com.larus.common.venue.impl.venue.page.b(this));     // Catch: IllegalStateException -> L6
        return;
    L6:
        e = move-exception;
        FLogger.a.e("FlowCommonVenueFragment", "[attachComponent] failed in obric mode", e);
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        View r16 = r13.inflate(2131562365, r14, false);
        int r17 = 2131364480;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r16, 2131364480);
        if (r3 == null) goto L87;
        r17 = 2131364488;
        BottomMenuGridLayout r4 = ViewBindings.findChildViewById(r16, 2131364488);
        if (r4 == null) goto L87;
        r17 = 2131365254;
        if (((ViewStub) ViewBindings.findChildViewById(r16, 2131365254)) == null) goto L87;
        r17 = 2131365588;
        ChatConstraintLayout r18 = ViewBindings.findChildViewById(r16, 2131365588);
        if (r18 == null) goto L87;
        r17 = 2131372705;
        if (ViewBindings.findChildViewById(r16, 2131372705) == null) goto L87;
        r17 = 2131372706;
        if (ViewBindings.findChildViewById(r16, 2131372706) == null) goto L87;
        r17 = 2131375324;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r16, 2131375324);
        if (r6 == null) goto L87;
        if (((ViewStub) ViewBindings.findChildViewById(r16, 2131375364)) == null) goto L85;
        TouchInterceptingView r7 = ViewBindings.findChildViewById(r16, 2131375385);
        if (r7 != null) goto L21;
        r17 = 2131375385;
        goto L87
    L21:
        if (ViewBindings.findChildViewById(r16, 2131375556) != null) goto L23;
        r17 = 2131375556;
        goto L87
    L23:
        if (ViewBindings.findChildViewById(r16, 2131377386) != null) goto L25;
        r17 = 2131377386;
        goto L87
    L25:
        if (((ViewStub) ViewBindings.findChildViewById(r16, 2131382457)) == null) goto L81;
        FrameLayout r8 = (FrameLayout) r16;
        if (((Space) ViewBindings.findChildViewById(r16, 2131387040)) != null) goto L29;
        r17 = 2131387040;
        goto L87
    L29:
        if (((Space) ViewBindings.findChildViewById(r16, 2131387041)) != null) goto L31;
        r17 = 2131387041;
        goto L87
    L31:
        if (((ViewStub) ViewBindings.findChildViewById(r16, 2131387057)) == null) goto L78;
        View r9 = ViewBindings.findChildViewById(r16, 2131387119);
        if (r9 != null) goto L35;
        r17 = 2131387119;
        goto L87
    L35:
        if (((ViewStub) ViewBindings.findChildViewById(r16, 2131387487)) != null) goto L37;
        r17 = 2131387487;
        goto L87
    L37:
        if (ViewBindings.findChildViewById(r16, 2131389133) != null) goto L39;
        r17 = 2131389133;
        goto L87
    L39:
        if (ViewBindings.findChildViewById(r16, 2131389273) == null) goto L74;
        this.e = new LarusFragmentCommonVenueBinding(r8, r3, r4, r18, r6, r7, r8, r9);
        ViewStub r110 = (ViewStub) r18.findViewById(2131375364);
        if (r110 == null) goto L43;
        InputViewCreatorDelegate.b.a(r110, 2131375364);
    L43:
        LarusFragmentCommonVenueBinding r111 = this.e;
        if (r111 == null) goto L48;
        ChatConstraintLayout r112 = r111.d;
        if (r112 == null) goto L48;
        View r113 = IAIChatUgcAIGCService.a.K(r112.getContext());
        r113.setId(2131387057);
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(-1, 0);
        ((ViewGroup.MarginLayoutParams) r1).bottomMargin = i5.h();
        r113.setLayoutParams(r1);
        e1.o(r113);
        r112.addView(r113);
        ConstraintSet r114 = new ConstraintSet();
        r114.clone(r112);
        r114.connect(2131387057, 4, 2131375324, 4);
        r114.applyTo(r112);
    L48:
        Context r115 = getContext();
        if (r115 == null) goto L55;
        LarusFragmentCommonVenueBinding r116 = this.e;
        if (r116 == null) goto L55;
        ChatConstraintLayout r117 = r116.d;
        if (r117 == null) goto L55;
        r117.k6(r115);
    L55:
        LarusFragmentCommonVenueBinding r118 = this.e;
        if (r118 == null) goto L60;
        ChatConstraintLayout r119 = r118.d;
        if (r119 == null) goto L60;
        r119.U5();
    L60:
        LarusFragmentCommonVenueBinding r120 = this.e;
        if (r120 == null) goto L69;
        ChatConstraintLayout r121 = r120.d;
        if (r121 == null) goto L69;
        ViewGroup.LayoutParams r122 = r121.getLayoutParams();
        if (r122 == null) goto L68;
        ViewGroup.MarginLayoutParams r123 = (ViewGroup.MarginLayoutParams) r122;
        r123.topMargin = 0;
        r123.bottomMargin = 0;
        r121.setLayoutParams(r123);
        goto L69
    L68:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L69:
        s1a.a.g(this).c(new b(this), m.class);
        LarusFragmentCommonVenueBinding r124 = this.e;
        if (r124 != null) goto L88;
        return null;
    L88:
        return r124.g;
    L74:
        r17 = 2131389273;
        goto L87
    L78:
        r17 = 2131387057;
        goto L87
    L81:
        r17 = 2131382457;
        goto L87
    L85:
        r17 = 2131375364;
    L87:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r17)));
    }
}
