package com.larus.bmhome.miniartifact.product;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.mainbot.api.miniartifact.MiniArtifactProductParams;
import com.larus.mainbot.impl.databinding.LarusFragmentMiniArtifactProductBinding;
import com.larus.mainbot.impl.databinding.LarusMiniArtifactInputBinding;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ny9.s;
import ny9.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016J\b\u0010 \u001a\u00020\u0019H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/bmhome/miniartifact/product/MiniArtifactProductFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/bmhome/miniartifact/product/abilities/MiniArtifactProductPageAbility;", "<init>", "()V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusFragmentMiniArtifactProductBinding;", "miniArtifactProductParams", "Lcom/larus/mainbot/api/miniartifact/MiniArtifactProductParams;", "pendingEnterProductTracking", "", "autoLogEnterPage", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "tryTraceEnterProductPage", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "reportEnter", "currentPage", "", "previousPage", "exitPage", "onAttach", "context", "Landroid/content/Context;", "onDestroyView", "getCurrentPageName", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactProductFragment extends TraceFragment implements er8.a {
    public static final /* synthetic */ int h = 0;
    public LarusFragmentMiniArtifactProductBinding e;
    public MiniArtifactProductParams f;
    public boolean g;

    public final boolean S90() {
        return false;
    }

    @Override // er8.a
    public final void RO() {
        if (this.g == false) goto L6;
        U90("ai_code_artifact_page", "ai_code_artifact_loading_page");
        this.g = false;
        return;
    }

    public final String k() {
        MiniArtifactProductParams r0 = s1a.a.g(this).a(MiniArtifactProductParams.class);
        if (r0 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r0.getMiniArtifactFinished(), Boolean.TRUE);
    L6:
        if (r1 == false) goto L8;
        return "ai_code_artifact_page";
    L8:
        return "ai_code_artifact_loading_page";
    L5:
        r1 = false;
        goto L6
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
    }

    public MiniArtifactProductFragment() {
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new AnonymousClass1(this));
    }

    public final void onCreate(Bundle r21) {
        super.onCreate(r21);
        t1a.b r1 = s1a.a.g(this);
        de8.c r15 = new de8.c(getArguments(), null, true, null, null, false, null, null, null, null, false, false, null, 0, 32762);
        s1a.a.g(this).n(r15, de8.c.class);
        r1.n(new s(getArguments()), s.class);
        r1.n(new u(null), u.class);
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_MULTI_MODAL);
        k1a.b.a(this, new n(this));
    }

    public final void U90(String r5, String r6) {
        MiniArtifactProductParams r0 = s1a.a.g(this).a(MiniArtifactProductParams.class);
        int r1 = ar8.a.a;
        String r2 = null;
        if (r0 == null) goto L5;
        Map r3 = r0.getTrackParams();
    L6:
        String r4 = ar8.b.c(r3);
        if (r0 == null) goto L9;
        String r7 = r0.getMiniArtifactId();
    L10:
        if (r0 == null) goto L12;
        r2 = r0.getMiniArtifactTitle();
    L12:
        ar8.a.a(r5, r6, r4, r7, r2);
        return;
    L9:
        r7 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        boolean r0 = false;
        ChatConstraintLayout r8 = r5.inflate(2131562411, r6, false);
        int r9 = 2131365588;
        View r1 = ViewBindings.findChildViewById(r8, 2131365588);
        if (r1 == null) goto L69;
        LarusMiniArtifactInputBinding r10 = LarusMiniArtifactInputBinding.a(r1);
        if (((ImageView) ViewBindings.findChildViewById(r8, 2131375900)) != null) goto L7;
        r9 = 2131375900;
        goto L69
    L7:
        if (((ImageView) ViewBindings.findChildViewById(r8, 2131375944)) == null) goto L66;
        ChatConstraintLayout r2 = r8;
        if (((TextView) ViewBindings.findChildViewById(r8, 2131387517)) != null) goto L11;
        r9 = 2131387517;
        goto L69
    L11:
        if (ViewBindings.findChildViewById(r8, 2131388867) != null) goto L13;
        r9 = 2131388867;
        goto L69
    L13:
        if (((TextView) ViewBindings.findChildViewById(r8, 2131390084)) == null) goto L63;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r8, 2131393123);
        if (r3 == null) goto L62;
        this.e = new LarusFragmentMiniArtifactProductBinding(r2, r10, r2, r3);
        if (r2 == null) goto L21;
        ViewStub r11 = (ViewStub) r2.findViewById(2131375364);
        if (r11 == null) goto L21;
        InputViewCreatorDelegate.b.a(r11, 2131375364);
    L21:
        Context r12 = getContext();
        if (r12 == null) goto L30;
        LarusFragmentMiniArtifactProductBinding r4 = this.e;
        if (r4 == null) goto L30;
        LarusMiniArtifactInputBinding r13 = r4.b;
        if (r13 == null) goto L30;
        ChatConstraintLayout r14 = r13.a;
        if (r14 == null) goto L30;
        r14.k6(r12);
        r14.setDisableBottomPadding(true);
        r14.setDisableTopPadding(true);
        r14.R5();
    L30:
        LarusFragmentMiniArtifactProductBinding r15 = this.e;
        if (r15 == null) goto L35;
        ChatConstraintLayout r16 = r15.c;
        if (r16 == null) goto L35;
        r16.setDisableBottomPadding(true);
        r16.setDisableTopPadding(true);
        r16.R5();
    L35:
        Bundle r17 = getArguments();
        Map r18 = null;
        if (r17 == null) goto L38;
        Serializable r19 = r17.getSerializable("mini_artifact_product_page_navigation_params");
    L40:
        if ((r19 instanceof MiniArtifactProductParams) == false) goto L42;
        MiniArtifactProductParams r20 = (MiniArtifactProductParams) r19;
    L43:
        this.f = r20;
        if (r20 == null) goto L46;
        s1a.a.g(this).n(r20, MiniArtifactProductParams.class);
    L46:
        s1a.a.g(this).c(this, er8.a.class);
        MiniArtifactProductParams r21 = s1a.a.g(this).a(MiniArtifactProductParams.class);
        if (r21 == null) goto L49;
        r18 = r21.getTrackParams();
    L49:
        String r22 = ar8.b.e(r18);
        MiniArtifactProductParams r23 = this.f;
        if (r23 == null) goto L52;
        r0 = Intrinsics.areEqual(r23.getMiniArtifactFinished(), Boolean.TRUE);
    L52:
        if (r0 == false) goto L54;
        String r24 = "ai_code_artifact_page";
    L55:
        U90(r24, r22);
        this.g = !r0;
        LarusFragmentMiniArtifactProductBinding r25 = this.e;
        if (r25 == null) goto L61;
        ChatConstraintLayout r26 = r25.c;
        if (r26 == null) goto L61;
        return r26;
    L61:
        return new View(r5.getContext());
    L54:
        r24 = "ai_code_artifact_loading_page";
        goto L55
    L42:
        r20 = null;
        goto L43
    L38:
        r19 = null;
        goto L40
    L62:
        r9 = 2131393123;
        goto L69
    L63:
        r9 = 2131390084;
        goto L69
    L66:
        r9 = 2131375944;
    L69:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r9)));
    }
}
