package com.larus.bmhome.miniartifact.listpage;

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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.mainbot.api.miniartifact.MiniArtifactListPageParams;
import com.larus.mainbot.impl.databinding.LarusFragmentMiniArtifactPageListBinding;
import com.larus.mainbot.impl.databinding.LarusMiniArtifactInputBinding;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ny9.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/miniartifact/listpage/MiniArtifactListPageFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusFragmentMiniArtifactPageListBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "autoLogEnterPage", "", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "trackEnterPage", "onDestroyView", "getCurrentPageName", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniArtifactListPageFragment extends TraceFragment {
    public static final /* synthetic */ int f = 0;
    public LarusFragmentMiniArtifactPageListBinding e;

    public final boolean S90() {
        return false;
    }

    public final String k() {
        return "ai_code_template_list_page";
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
    }

    public MiniArtifactListPageFragment() {
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
        r1.n(new ny9.s(getArguments()), ny9.s.class);
        r1.n(new u(null), u.class);
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_MULTI_MODAL);
        k1a.b.a(this, new b(this));
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        ConstraintLayout r7 = r4.inflate(2131562410, r5, false);
        int r8 = 2131365588;
        View r9 = ViewBindings.findChildViewById(r7, 2131365588);
        if (r9 == null) goto L67;
        LarusMiniArtifactInputBinding r10 = LarusMiniArtifactInputBinding.a(r9);
        if (((TextView) ViewBindings.findChildViewById(r7, 2131371579)) != null) goto L7;
        r8 = 2131371579;
        goto L67
    L7:
        if (((LinearLayout) ViewBindings.findChildViewById(r7, 2131371607)) != null) goto L9;
        r8 = 2131371607;
        goto L67
    L9:
        if (((ImageView) ViewBindings.findChildViewById(r7, 2131375900)) != null) goto L11;
        r8 = 2131375900;
        goto L67
    L11:
        if (ViewBindings.findChildViewById(r7, 2131379091) != null) goto L13;
        r8 = 2131379091;
        goto L67
    L13:
        if (ViewBindings.findChildViewById(r7, 2131380136) == null) goto L61;
        FrameLayout r0 = (FrameLayout) ViewBindings.findChildViewById(r7, 2131380137);
        if (r0 == null) goto L60;
        ConstraintLayout r11 = r7;
        if (ViewBindings.findChildViewById(r7, 2131388867) != null) goto L19;
        r8 = 2131388867;
        goto L67
    L19:
        if (((TextView) ViewBindings.findChildViewById(r7, 2131390051)) != null) goto L21;
        r8 = 2131390051;
        goto L67
    L21:
        if (((TextView) ViewBindings.findChildViewById(r7, 2131390084)) == null) goto L57;
        this.e = new LarusFragmentMiniArtifactPageListBinding(r11, r10, r0, r11);
        if (r11 == null) goto L27;
        ViewStub r12 = (ViewStub) r11.findViewById(2131375364);
        if (r12 == null) goto L27;
        InputViewCreatorDelegate.b.a(r12, 2131375364);
    L27:
        Context r13 = getContext();
        if (r13 == null) goto L36;
        LarusFragmentMiniArtifactPageListBinding r14 = this.e;
        if (r14 == null) goto L36;
        LarusMiniArtifactInputBinding r15 = r14.b;
        if (r15 == null) goto L36;
        ChatConstraintLayout r16 = r15.a;
        if (r16 == null) goto L36;
        r16.k6(r13);
        r16.setDisableBottomPadding(true);
        r16.setDisableTopPadding(true);
        r16.R5();
    L36:
        Bundle r17 = getArguments();
        if (r17 == null) goto L39;
        Serializable r18 = r17.getSerializable("mini_artifact_list_page_navigation_params");
    L41:
        if ((r18 instanceof MiniArtifactListPageParams) == false) goto L43;
        MiniArtifactListPageParams r19 = (MiniArtifactListPageParams) r18;
    L44:
        if (r19 == null) goto L46;
        s1a.a.g(this).n(r19, MiniArtifactListPageParams.class);
    L46:
        MiniArtifactListPageParams r20 = s1a.a.g(this).a(MiniArtifactListPageParams.class);
        if (r20 == null) goto L49;
        Map r21 = r20.getTrackParams();
    L50:
        int r22 = ar8.a.a;
        ar8.a.a("ai_code_template_list_page", ar8.b.e(r21), ar8.b.c(r21), null, null);
        LarusFragmentMiniArtifactPageListBinding r23 = this.e;
        if (r23 == null) goto L55;
        ConstraintLayout r24 = r23.d;
        if (r24 == null) goto L55;
        return r24;
    L55:
        FrameLayout r25 = new FrameLayout(requireContext());
        r25.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return r25;
    L49:
        r21 = null;
        goto L50
    L43:
        r19 = null;
        goto L44
    L39:
        r18 = null;
        goto L41
    L57:
        r8 = 2131390084;
        goto L67
    L60:
        r8 = 2131380137;
        goto L67
    L61:
        r8 = 2131380136;
    L67:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r8)));
    }
}
