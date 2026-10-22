package com.larus.uaigc.createpage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.ChatBubbleParams;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.uaigc.createpage.component.instruction.CreationEditorComponent;
import com.larus.uaigc.impl.databinding.LarusFragmentHalfCreationPageBinding;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.tencent.open.log.TraceLevel;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 j2\u00020\u00012\u00020\u0002:\u0001jB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0012\u0010.\u001a\u00020+2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u0018H\u0016J&\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00108\u001a\u00020+2\u0006\u00109\u001a\u0002032\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u0010:\u001a\u00020+H\u0016J\b\u0010;\u001a\u00020+H\u0002J\u000f\u0010<\u001a\u0004\u0018\u00010\u0017H\u0000¢\u0006\u0002\b=J\b\u0010>\u001a\u00020+H\u0002J\b\u0010?\u001a\u00020+H\u0002J'\u0010@\u001a\u00020+2\u0006\u0010A\u001a\u00020\u00162\u0006\u0010B\u001a\u00020\u00162\b\u0010C\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\bDJ\r\u0010E\u001a\u00020\u0018H\u0000¢\u0006\u0002\bFJ\r\u0010G\u001a\u00020\u0018H\u0000¢\u0006\u0002\bHJ\"\u0010I\u001a\u00020+2\u0006\u0010A\u001a\u00020\u00162\u0006\u0010B\u001a\u00020\u00162\b\u0010C\u001a\u0004\u0018\u00010\u001dH\u0017J\b\u0010J\u001a\u00020+H\u0002J\b\u0010K\u001a\u00020+H\u0002J\n\u0010L\u001a\u0004\u0018\u000103H\u0016J\u001a\u0010M\u001a\u00020+2\u0006\u0010B\u001a\u00020\u00162\b\u0010C\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010N\u001a\u00020+H\u0002J\b\u0010O\u001a\u00020+H\u0016J\u001f\u0010P\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020\u00112\b\u0010R\u001a\u0004\u0018\u00010\u0017H\u0000¢\u0006\u0002\bSJ\u0012\u0010T\u001a\u0004\u0018\u00010\u000e2\u0006\u0010Q\u001a\u00020\u0011H\u0002J\u0010\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u000207H\u0002J\u0014\u0010X\u001a\u00020+*\u00020Y2\u0006\u0010W\u001a\u000207H\u0002J\b\u0010Z\u001a\u00020+H\u0002J\b\u0010[\u001a\u00020+H\u0002J\u0010\u0010\\\u001a\u00020+2\u0006\u0010W\u001a\u000207H\u0002J\b\u0010]\u001a\u00020+H\u0002J\u0018\u0010^\u001a\u00020+2\u0006\u0010_\u001a\u00020\u00132\u0006\u0010`\u001a\u00020\u0018H\u0002J\u0018\u0010a\u001a\u00020+2\u0006\u0010_\u001a\u00020\u00132\u0006\u0010b\u001a\u00020\u0016H\u0002J\b\u0010c\u001a\u00020\u0018H\u0002J\u001a\u0010d\u001a\u0002002\u0006\u0010B\u001a\u00020\u00162\b\u0010C\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010e\u001a\u00020+H\u0002J\b\u0010f\u001a\u00020\u001dH\u0002J\b\u0010g\u001a\u00020+H\u0002J\b\u0010h\u001a\u00020+H\u0002J\b\u0010i\u001a\u00020\u0017H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u0016\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006k"}, d2 = {"Lcom/larus/uaigc/createpage/CreationHalfChatFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/uaigc/bean/createpage/ICreationHalfHost;", "<init>", "()V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusFragmentHalfCreationPageBinding;", "instructionArgumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "hitPointData", "Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "creationHalfContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "hostContainer", "Landroid/widget/FrameLayout;", "hostFragmentRef", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/Fragment;", "hostChatRoot", "Lcom/larus/bmhome/view/ChatConstraintLayout;", "hostRootBottomPaddingInterceptor", "Lkotlin/Function2;", "", "", "", "originalHostRootBottomPaddingInterceptor", "hasPendingResult", "pendingResultCode", "pendingResultData", "Landroid/content/Intent;", "resultDelivered", "dismissRequested", "creationEditorAbility", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "getCreationEditorAbility", "()Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "creationEditorAbility$delegate", "Lkotlin/Lazy;", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "autoLogEnterPage", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "dismiss", "getPreviousPage", "getPreviousPage$impl_mainlandRelease", "bindToVContext", "attachComponent", "onResult", "requestCode", "resultCode", "data", "onResult$impl_mainlandRelease", "isDismissRequested", "isDismissRequested$impl_mainlandRelease", "shouldUseCompactForsetiImeFix", "shouldUseCompactForsetiImeFix$impl_mainlandRelease", "onActivityResult", "initBackPressed", "requestDismissPage", "getContentView", "setCreationHalfResult", "deliverPendingResultIfNeeded", "finishCreationHalfPage", "showPageFragment", "parentFragment", "tag", "showPageFragment$impl_mainlandRelease", "ensureHostContainer", "createHostLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "root", "compensateHostPadding", "Landroid/view/ViewGroup$MarginLayoutParams;", "dismissPageAllowingStateLoss", "scheduleRemoveHostContainer", "installHostRootInsetsGuard", "restoreHostRootInsets", "resetHostRootImeInsets", "chatRoot", "shouldPinBottomPadding", "pinHostRootBottomPadding", "targetBottom", "shouldPinHostRootBottomPadding", "buildResultBundle", "cancelPendingEditorIme", "buildCancelResultIntent", "deliverCancelResultIfNeeded", "deliverPendingResultOrCancelIfNeeded", "getCurrentPageName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationHalfChatFragment extends TraceFragment implements ny9.i {
    public static final /* synthetic */ int p = 0;
    public LarusFragmentHalfCreationPageBinding e;
    public FrameLayout f;
    public WeakReference<Fragment> g;
    public ChatConstraintLayout h;
    public Function2<? super Integer, ? super String, Boolean> i;
    public boolean j;
    public int k;
    public Intent l;
    public boolean m;
    public boolean n;
    public final Lazy o;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return false;
    }

    @Override // ny9.i
    public final void YV() {
        this.n = true;
        U90();
        View r1 = getView();
        if (r1 == null) goto L5;
        r1.setVisibility(8);
    L5:
        ICoreInputAbility r2 = s1a.a.g(this).getAbility(ICoreInputAbility.class);
        if (r2 == null) goto L8;
        r2.qp(true);
    L8:
        Z90();
        W90();
        if (isAdded() == true) goto L20;
        FrameLayout r0 = this.f;
        Z90();
        if (r0 != null) goto L18;
        this.g = null;
        return;
    L18:
        r0.post(new b0(r0));
        this.f = null;
        this.g = null;
        return;
    L20:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        Object r4 = Result.constructor-impl(Integer.valueOf(getParentFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss()));     // Catch: Throwable -> L12
    L14:
        Result.box-impl(r4);
        return;
    L12:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final String k() {
        return "CreationHalfChatFragment";
    }

    public final void U90() {
        ys8.a r0 = (ys8.a) this.o.getValue();
        if ((r0 instanceof CreationEditorComponent) == false) goto L5;
        CreationEditorComponent r1 = (CreationEditorComponent) r0;
    L6:
        if (r1 == null) goto L8;
        r1.C3();
    L8:
        py9.a r2 = (py9.a) s1a.a.g(this).getAbility(py9.a.class);
        if (r2 == null) goto L12;
        r2.NM();
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void V90() {
        if (this.m == false) goto L5;
        return;
    L5:
        if (this.j == true) goto L10;
        Intent r0 = new Intent();
        r0.putExtra("ai_creation", true);
        r0.putExtra("end_modify", true);
        Dc(0, r0);
        return;
    }

    public final void X90() {
        if (this.n == false) goto L5;
        return;
    L5:
        this.n = true;
        U90();
        py9.a r0 = (py9.a) s1a.a.g(this).getAbility(py9.a.class);
        if (r0 == null) goto L9;
        r0.Gj();
        return;
    L9:
        V90();
        YV();
    }

    public final void Z90() {
        ChatConstraintLayout r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        z2.a.w3();
        Y90(r0);
        this.h = null;
        this.i = null;
    }

    public final boolean aa0() {
        WeakReference<Fragment> r0 = this.g;
        xe8.a r1 = null;
        if (r0 == null) goto L6;
        Fragment r2 = r0.get();
        if (r2 == null) goto L6;
    L11:
        if ((r2 instanceof xe8.a) == false) goto L14;
        r1 = (xe8.a) r2;
    L14:
        if (r1 == null) goto L21;
        ChatBubbleParams r3 = r1.Mz();
        if (r3 != null) goto L18;
        return false;
    L18:
        if (r3.b != true) goto L23;
        return true;
    L23:
        return false;
    L21:
        return false;
    L6:
        WeakReference<Fragment> r4 = s0.b;
        if (r4 == null) goto L9;
        r2 = r4.get();
        goto L11
    L9:
        r2 = null;
        goto L11
    }

    public final void onDestroyView() {
        FrameLayout r0 = this.f;
        if ((r0 instanceof h0) == false) goto L5;
        h0 r1 = (h0) r0;
    L6:
        if (r1 == null) goto L8;
        r1.a = null;
        r1.b = null;
    L8:
        U90();
        Z90();
        W90();
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
        FrameLayout r2 = this.f;
        Z90();
        if (r2 != null) goto L11;
        this.g = null;
        return;
    L11:
        r2.post(new b0(r2));
        this.f = null;
        this.g = null;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public CreationHalfChatFragment() {
        this.o = LazyKt.lazy(new z(this));
    }

    public final void W90() {
        V90();
        if (this.m == false) goto L5;
        return;
    L5:
        if (this.j == false) goto L31;
        WeakReference<Fragment> r0 = this.g;
        if (r0 == null) goto L11;
        Fragment r1 = r0.get();
        if (r1 == null) goto L11;
    L16:
        if ((r1 instanceof xe8.a) == false) goto L32;
        int r2 = this.k;
        Intent r3 = this.l;
        if (r3 == null) goto L22;
        Bundle r4 = r3.getExtras();
        if (r4 == null) goto L22;
    L23:
        Bundle r5 = new Bundle(r4);
        if (r5.getBoolean("end_modify") == false) goto L28;
        r5.putBoolean("restore_action_bar_on_return", true);
        if (r2 != 0) goto L28;
        r5.putBoolean("close_instruction_editor_on_return", true);
    L28:
        this.m = true;
        ((xe8.a) r1).Lc(r5, 100, this.k);
        return;
    L22:
        r4 = new Bundle();
        goto L23
    L32:
        return;
    L11:
        WeakReference<Fragment> r6 = s0.b;
        if (r6 == null) goto L14;
        r1 = r6.get();
        goto L16
    L14:
        r1 = null;
        goto L16
    }

    @Override // ny9.i
    public final View getContentView() {
        return getView();
    }

    public static void Y90(ChatConstraintLayout r2) {
        Function2 r0 = r2.getInterruptBottomPaddingUpdate();
        r2.setInterruptBottomPaddingUpdate(new f0());     // Catch: Throwable -> L6
        r2.u6();     // Catch: Throwable -> L6
        r2.setInterruptBottomPaddingUpdate(r0);
        return;
    L6:
        th = move-exception;
        r2.setInterruptBottomPaddingUpdate(r0);
        throw th;
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

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_ONLY);
        k1a.b.a(this, new c0(this));
    }

    @Override // ny9.i
    public final void Dc(int r2, Intent r3) {
        if (this.m == false) goto L5;
        return;
    L5:
        this.k = r2;
        this.l = r3;
        this.j = true;
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        FrameLayout r4 = this.f;
        ConstraintLayout r0 = null;
        if ((r4 instanceof h0) == false) goto L5;
        h0 r5 = (h0) r4;
    L6:
        if (r5 == null) goto L11;
        LarusFragmentHalfCreationPageBinding r6 = this.e;
        if (r6 == null) goto L10;
        r0 = r6.c;
    L10:
        r5.a = r0;
        r5.c = false;
        r5.b = new a0(this);
    L11:
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new CreationHalfChatFragment$initBackPressed$1(this));
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Deprecated(message = "Deprecated in Java")
    public final void onActivityResult(int r1, int r2, Intent r3) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r1, r2, r3);
        ys8.a r4 = (ys8.a) this.o.getValue();
        if (r4 == null) goto L6;
        r4.pz(r2, r3);
        return;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusFragmentHalfCreationPageBinding r4 = LarusFragmentHalfCreationPageBinding.a(r1, r2);
        this.e = r4;
        ViewStub r5 = r4.e;
        if (r5 == null) goto L6;
        InputViewCreatorDelegate.b.a(r5, 2131375364);
    L6:
        if (aa0() == true) goto L12;
        LarusFragmentHalfCreationPageBinding r6 = this.e;
        if (r6 == null) goto L12;
        ChatConstraintLayout r7 = r6.f;
        if (r7 == null) goto L12;
        r7.post(new y(this));
    L12:
        LarusFragmentHalfCreationPageBinding r8 = this.e;
        if (r8 == null) goto L17;
        ConstraintLayout r9 = r8.c;
        if (r9 == null) goto L17;
        com.larus.uaigc.createpage.utils.p.a(r9);
    L17:
        LarusFragmentHalfCreationPageBinding r10 = this.e;
        if (r10 != null) goto L22;
        return null;
    L22:
        return r10.f;
    }
}
