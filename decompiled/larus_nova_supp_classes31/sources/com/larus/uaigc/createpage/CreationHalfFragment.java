package com.larus.uaigc.createpage;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.uaigc.impl.databinding.LarusFragmentHalfCreationPageBinding;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020&2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010-\u001a\u00020\u001dH\u0016J\u0006\u0010.\u001a\u00020\u001dJ\u0006\u0010/\u001a\u00020\u001dJ\b\u00100\u001a\u0004\u0018\u000101J\b\u00102\u001a\u00020\u001dH\u0002J\b\u00103\u001a\u00020\u001dH\u0002J \u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u000109J\u0010\u0010:\u001a\u00020\u001d2\b\u00108\u001a\u0004\u0018\u000109J\u0010\u0010;\u001a\u00020\u001d2\b\u00108\u001a\u0004\u0018\u000109J\b\u0010<\u001a\u00020\u001dH\u0002J\u0010\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u000201H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001a¨\u0006B"}, d2 = {"Lcom/larus/uaigc/createpage/CreationHalfFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusFragmentHalfCreationPageBinding;", "instructionArgumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "hitPointData", "Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "creationHalfContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "creationEditorAbility", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "getCreationEditorAbility", "()Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "creationEditorAbility$delegate", "Lkotlin/Lazy;", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "autoLogEnterPage", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "onBackPressed", "dismiss", "getPreviousPage", "", "bindToVContext", "attachComponent", "onResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onUploadDigitalAvatarResult", "onDeleteDigitalAvatarResult", "setupDialogWindow", "adaptHostContainerWidth", "window", "Landroid/view/Window;", "getCurrentPageName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationHalfFragment extends TraceFragment {
    public static final /* synthetic */ int i = 0;
    public LarusFragmentHalfCreationPageBinding e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return false;
    }

    public final String k() {
        return "CreationHalfFragment";
    }

    public CreationHalfFragment() {
        this.f = LazyKt.lazy(new i0(this));
        this.g = LazyKt.lazy(new j0(this));
        this.h = LazyKt.lazy(new k0(this));
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
    }

    public final void onAttach(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r3);
        t1a.b r4 = s1a.a.g(this);
        de8.c r0 = de8.c.s;
        r4.n(de8.c.a.a(getArguments()), de8.c.class);
        Bundle r5 = getArguments();
        ChatPageContext r1 = null;
        if (r5 == null) goto L5;
        ChatPageContext r6 = (ChatPageContext) r5.getParcelable("chat_page_context");
    L7:
        if ((r6 instanceof ChatPageContext) == false) goto L9;
        r1 = r6;
    L9:
        if (r1 == null) goto L11;
        s1a.a.g(this).n(r1, ChatPageContext.class);
    L11:
        ny9.s r7 = new ny9.s(getArguments());
        s1a.a.g(this).n(r7, ny9.s.class);
        s1a.a.g(this).n(new ny9.u(r7), ny9.u.class);
        return;
    L5:
        r6 = null;
        goto L7
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_ONLY);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        String r4 = r3.getString("open_from");
    L7:
        if (Intrinsics.areEqual(r4, "slides") == false) goto L9;
        k1a.b.a(this, new m0(this));
        return;
    L9:
        k1a.b.a(this, new n0(this));
        return;
    L5:
        r4 = null;
        goto L7
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        FragmentActivity r6 = requireActivity();
        if (r6 == null) goto L14;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L14;
        WindowManager.LayoutParams r0 = r7.getAttributes();
        r7.setLayout(-1, -1);
        r7.setBackgroundDrawable(new ColorDrawable(0));
        r7.clearFlags(2);
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 29) goto L10;
        r7.setNavigationBarContrastEnforced(false);
    L10:
        r7.addFlags(Integer.MIN_VALUE);
        if (r1 <= 28) goto L13;
        r0.layoutInDisplayCutoutMode = 1;
    L13:
        z2.a.w3();
    L14:
        z8 r8 = (z8) this.h.getValue();
        if (r8 == null) goto L18;
        r8.w9(false);
        return;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusFragmentHalfCreationPageBinding r4 = LarusFragmentHalfCreationPageBinding.a(r1, r2);
        this.e = r4;
        ViewStub r5 = r4.e;
        if (r5 == null) goto L5;
        InputViewCreatorDelegate.b.a(r5, 2131375364);
    L5:
        LarusFragmentHalfCreationPageBinding r6 = this.e;
        if (r6 == null) goto L10;
        ChatConstraintLayout r7 = r6.f;
        if (r7 == null) goto L10;
        r7.post(new l0(this));
    L10:
        LarusFragmentHalfCreationPageBinding r8 = this.e;
        if (r8 == null) goto L15;
        ConstraintLayout r9 = r8.c;
        if (r9 == null) goto L15;
        com.larus.uaigc.createpage.utils.p.a(r9);
    L15:
        LarusFragmentHalfCreationPageBinding r10 = this.e;
        if (r10 != null) goto L20;
        return null;
    L20:
        return r10.f;
    }
}
