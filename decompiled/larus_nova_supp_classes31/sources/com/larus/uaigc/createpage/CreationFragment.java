package com.larus.uaigc.createpage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.platform.service.AccountService;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.uaigc.impl.databinding.LarusFragmentCreationPageBinding;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.ui.arch.modulizer.di.IComponentRegistry;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 c2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001cB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\u0012\u00100\u001a\u00020-2\b\u00101\u001a\u0004\u0018\u000102H\u0016J&\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00109\u001a\u00020-2\u0006\u0010:\u001a\u0002042\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u0010;\u001a\u00020-2\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020-H\u0016J\b\u0010?\u001a\u00020-H\u0016J\u0010\u0010@\u001a\u00020-2\u0006\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020-H\u0002J\b\u0010D\u001a\u00020-H\u0002J\b\u0010E\u001a\u00020-H\u0002J\b\u0010F\u001a\u00020-H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010G\u001a\u00020-2\u0006\u0010H\u001a\u00020BH\u0016J\b\u0010I\u001a\u00020BH\u0016J\b\u0010J\u001a\u00020BH\u0016J\b\u0010K\u001a\u00020BH\u0016J\b\u0010L\u001a\u00020BH\u0016J\u0018\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020NH\u0016J\b\u0010Q\u001a\u00020NH\u0002J\b\u0010R\u001a\u00020SH\u0016J\b\u0010T\u001a\u00020BH\u0016J \u0010U\u001a\u00020-2\u0006\u0010V\u001a\u00020N2\u0006\u0010W\u001a\u00020N2\b\u0010X\u001a\u0004\u0018\u00010YJ\u0010\u0010Z\u001a\u00020-2\b\u0010X\u001a\u0004\u0018\u00010YJ\u0010\u0010[\u001a\u00020-2\b\u0010X\u001a\u0004\u0018\u00010YJ\u000e\u0010\\\u001a\u00020-2\u0006\u0010]\u001a\u00020BJ\u0006\u0010^\u001a\u00020-J\b\u0010_\u001a\u00020-H\u0002J\u0006\u0010`\u001a\u00020-J\b\u0010a\u001a\u00020-H\u0002J\b\u0010b\u001a\u00020-H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0013\u001a\u0004\b$\u0010%R\u001d\u0010'\u001a\u0004\u0018\u00010(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0013\u001a\u0004\b)\u0010*¨\u0006d"}, d2 = {"Lcom/larus/uaigc/createpage/CreationFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/uaigc/createpage/CreationFragmentAbility;", "Lcom/larus/uaigc/bean/createpage/ICreationFragment;", "<init>", "()V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusFragmentCreationPageBinding;", "instructionArgumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "hitPointData", "Lcom/larus/uaigc/bean/createpage/InstructionHitPointData;", "creationHalfContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "hostUiPolicy", "Lcom/larus/uaigc/createpage/CreationHostUiPolicy;", "getHostUiPolicy", "()Lcom/larus/uaigc/createpage/CreationHostUiPolicy;", "hostUiPolicy$delegate", "Lkotlin/Lazy;", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "creationEditorAbility", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "getCreationEditorAbility", "()Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "creationEditorAbility$delegate", "templateFeedAbility", "Lcom/larus/uaigc/bean/createpage/component/templatefeed/ITemplateFeedAbility;", "getTemplateFeedAbility", "()Lcom/larus/uaigc/bean/createpage/component/templatefeed/ITemplateFeedAbility;", "templateFeedAbility$delegate", "argumentData", "getArgumentData", "()Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "argumentData$delegate", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "adaptHostBottomPadding", "root", "Lcom/larus/bmhome/view/ChatConstraintLayout;", "onDestroyView", "onDestroy", "quit", "force", "", "exitCurrentPage", "cancelResourceAccessForPageLeave", "finishNativeCreationPage", "mobLeavePageIfNeeded", "setHostTitleScrimVisible", "visible", "shouldUseHostTitleBar", "shouldShowTitleScrimOnIme", "shouldKeepTitleOnIme", "shouldUseTemplateFeedImeMask", "coerceMediaSelectorTopPaddingOnIme", "", "currentTopPadding", "hostMinTopPadding", "resolveHostBackIconRes", "getCurrentPageName", "", "autoLogEnterPage", "onResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onUploadDigitalAvatarResult", "onDeleteDigitalAvatarResult", "onWindowFocusChanged", "hasFocus", "onActivityFinish", "openNativeMineProfileFromAICreationApplet", "onBackPressed", "bindToVContext", "attachComponent", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationFragment extends TraceFragment implements v, ny9.g {
    public static final /* synthetic */ int n = 0;
    public LarusFragmentCreationPageBinding e;
    public ny9.s f;
    public ny9.u g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[CreationHostUiPolicy.LeadingAction.values().length];
            r0[CreationHostUiPolicy.LeadingAction.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r0[CreationHostUiPolicy.LeadingAction.BACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[CreationHostUiPolicy.LeadingAction.CLOSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            a = r0;
            int[] r1 = new int[CreationHostUiPolicy.ExitAction.values().length];
            r1[CreationHostUiPolicy.ExitAction.NAVIGATE_BACK_IN_HOST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r1[CreationHostUiPolicy.ExitAction.CLOSE_HOST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r1[CreationHostUiPolicy.ExitAction.FINISH_NATIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            b = r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.CreationFragment$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.CreationFragment$onCreate$1", f = "CreationFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CreationFragment this$0;

        public AnonymousClass1(CreationFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r60) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L35;
            ResultKt.throwOnFailure(r60);
            Bundle r1 = this.this$0.getArguments();
            if (r1 == null) goto L9;
            boolean r3 = true;
            if (r1.getBoolean("is_enter_template", true) == true) goto L9;
        L10:
            if (r3 == false) goto L33;
            ny9.u r2 = this.this$0.g;
            if (r2 == null) goto L14;
            String r9 = r2.q();
        L15:
            ny9.u r4 = this.this$0.g;
            if (r4 == null) goto L18;
            String r12 = r4.getEnterMethod();
        L19:
            ny9.u r5 = this.this$0.g;
            if (r5 == null) goto L22;
            String r20 = r5.b();
        L23:
            ny9.s r6 = this.this$0.f;
            if (r6 == null) goto L30;
            ICoreInputAbility.MessageExtMap r7 = r6.m();
            if (r7 == null) goto L30;
            Map r8 = r7.a;
            if (r8 == null) goto L30;
            String r32 = (String) r8.get("outer_link_source");
        L31:
            tx9.a1.c(null, null, null, null, null, r9, null, null, r12, null, null, null, null, null, null, null, r20, null, null, null, null, null, null, null, null, null, null, null, r32, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1049729, -129, 7);
        L30:
            r32 = null;
            goto L31
        L22:
            r20 = null;
            goto L23
        L18:
            r12 = null;
            goto L19
        L14:
            r9 = null;
        L33:
            return Unit.INSTANCE;
        L9:
            r3 = false;
            goto L10
        L35:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final boolean S90() {
        return false;
    }

    public final ny9.s V90() {
        return (ny9.s) this.l.getValue();
    }

    public final CreationHostUiPolicy W90() {
        return (CreationHostUiPolicy) this.h.getValue();
    }

    public CreationFragment() {
        this.h = LazyKt.lazy(new q(this));
        this.i = LazyKt.lazy(new r(this));
        this.j = LazyKt.lazy(new s(this));
        this.k = LazyKt.lazy(new t(this));
        this.l = LazyKt.lazy(new u(this));
        this.m = LazyKt.lazy(new com.larus.uaigc.createpage.b(this));
    }

    @Override // com.larus.uaigc.createpage.v
    public final boolean Fl() {
        CreationHostUiPolicy r0 = W90();
        ny9.s r1 = V90();
        if (r1 == null) goto L5;
        Integer r2 = r1.l();
    L6:
        r0.getClass();
        CreationHostUiPolicy.KeyboardChromeMode r3 = CreationHostUiPolicy.KeyboardChromeMode.HOST_ROOT_CLEAR;
        Set r4 = SetsKt.setOf(new CreationHostUiPolicy.KeyboardChromeMode[]{CreationHostUiPolicy.KeyboardChromeMode.HOST_ROOT_SCRIM, r3});
        if (r0.a == true) goto L9;
        r3 = CreationHostUiPolicy.KeyboardChromeMode.NATIVE;
    L16:
        return r4.contains(r3);
    L9:
        if (r2 != null) goto L12;
    L14:
        r3 = CreationHostUiPolicy.KeyboardChromeMode.HOST_KEEP_CLEAR;
        goto L16
    L12:
        if (r2.intValue() != 28) goto L14;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.uaigc.createpage.v
    public final boolean IA() {
        CreationHostUiPolicy r0 = W90();
        ny9.s r1 = V90();
        if (r1 == null) goto L5;
        Integer r2 = r1.l();
    L7:
        if (r0.a == true) goto L9;
        CreationHostUiPolicy.KeyboardChromeMode r3 = CreationHostUiPolicy.KeyboardChromeMode.NATIVE;
    L16:
        if (r3 != CreationHostUiPolicy.KeyboardChromeMode.HOST_ROOT_SCRIM) goto L18;
        return true;
    L18:
        return false;
    L9:
        if (r2 != null) goto L12;
    L14:
        r3 = CreationHostUiPolicy.KeyboardChromeMode.HOST_KEEP_CLEAR;
        goto L16
    L12:
        if (r2.intValue() != 28) goto L14;
        r3 = CreationHostUiPolicy.KeyboardChromeMode.HOST_ROOT_CLEAR;
        goto L16
    L5:
        r2 = null;
        goto L7
    }

    public final void N6() {
        ry9.g r0 = (ry9.g) s1a.a.g(this).getAbility(ry9.g.class);
        if (r0 == null) goto L5;
        r0.N6();
    L5:
        ry9.h r1 = (ry9.h) s1a.a.g(this).getAbility(ry9.h.class);
        if (r1 == null) goto L9;
        r1.N6();
        return;
    }

    public final void U90() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L5;
        Intent r1 = new Intent();
        r1.putExtra("end_modify", true);
        r1.putExtra("result_from", "creation");
        Unit r2 = Unit.INSTANCE;
        r0.setResult(0, r1);
    L5:
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L9;
        r3.finish();
        return;
    }

    @Override // com.larus.uaigc.createpage.v
    public final boolean VV() {
        return !W90().a;
    }

    public final String k() {
        ny9.s r0 = V90();
        boolean r1 = true;
        if (r0 == null) goto L10;
        Integer r2 = r0.l();
        if (r2 == null) goto L10;
        if (r2.intValue() != 28) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        return "ai_generate_feed";
    L13:
        ny9.s r4 = V90();
        if (r4 == null) goto L21;
        Integer r5 = r4.l();
        if (r5 == null) goto L21;
        if (r5.intValue() != 4) goto L21;
        boolean r6 = true;
    L22:
        if (r6 == false) goto L24;
        return "ai_generate_feed_image";
    L24:
        ny9.s r7 = V90();
        if (r7 == null) goto L32;
        Integer r8 = r7.l();
        if (r8 == null) goto L32;
        if (r8.intValue() != 18) goto L32;
    L33:
        if (r1 == false) goto L35;
        return "ai_generate_feed_video";
    L35:
        return "";
    L32:
        r1 = false;
    L21:
        r6 = false;
    L10:
        r3 = false;
        goto L11
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        nz9.b.f("-999", CollectionsKt.listOf(new String[]{"creation_page", "creation_page/first_frame", "creation_page/album_upload", "creation_page/re_upload", "creation_page/album_upload/video"}), null);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
    }

    @Override // com.larus.uaigc.createpage.v
    public final boolean wD() {
        if (W90().c() == CreationHostUiPolicy.TitleBarMode.NATIVE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.uaigc.createpage.v
    public final LarusFragmentCreationPageBinding e() {
        return this.e;
    }

    @Override // com.larus.uaigc.createpage.v
    public final void UV(boolean r5) {
        CreationHostUiPolicy r0 = W90();
        LarusFragmentCreationPageBinding r1 = this.e;
        Integer r2 = null;
        if (r1 == null) goto L5;
        View r3 = r1.b;
    L6:
        ny9.s r4 = V90();
        if (r4 == null) goto L9;
        r2 = r4.l();
    L9:
        if (r3 != null) goto L11;
        r0.getClass();
        return;
    L11:
        if (r0.a == true) goto L13;
        CreationHostUiPolicy.KeyboardChromeMode r6 = CreationHostUiPolicy.KeyboardChromeMode.NATIVE;
    L19:
        int r7 = 0;
        if (r6 != CreationHostUiPolicy.KeyboardChromeMode.HOST_ROOT_SCRIM) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == false) goto L26;
        if (r5 == false) goto L26;
    L27:
        r3.setVisibility(r7);
        return;
    L26:
        r7 = 8;
        goto L27
    L22:
        r8 = false;
        goto L23
    L13:
        if (r2 != null) goto L16;
    L18:
        r6 = CreationHostUiPolicy.KeyboardChromeMode.HOST_KEEP_CLEAR;
        goto L19
    L16:
        if (r2.intValue() != 28) goto L18;
        r6 = CreationHostUiPolicy.KeyboardChromeMode.HOST_ROOT_CLEAR;
        goto L19
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.uaigc.createpage.v
    public final void kB(boolean r11) {
        boolean r0 = false;
        if (r11 == false) goto L5;
    L18:
        py9.a r12 = (py9.a) s1a.a.g(this).getAbility(py9.a.class);
        if (r12 == null) goto L21;
        r12.mV();
    L21:
        N6();
        ICoreInputAbility r13 = (ICoreInputAbility) this.i.getValue();
        if (r13 == null) goto L24;
        r13.qp(true);
    L24:
        int r14 = b.b[W90().b().ordinal()];
        if (r14 != 1) goto L27;
        ICreationWorkflowService.a.H(new com.larus.uaigc.createpage.a(this));
    L37:
        ny9.s r15 = this.f;
        if (r15 == null) goto L47;
        com.larus.bmhome.actionbar.model.r r16 = r15.k();
        if (r16 == null) goto L47;
        Integer r17 = r16.a;
        if (r17 == null) goto L47;
        if (r17.intValue() != 4) goto L47;
        boolean r18 = true;
    L48:
        if (r18 == true) goto L60;
        ny9.s r19 = this.f;
        if (r19 == null) goto L59;
        com.larus.bmhome.actionbar.model.r r110 = r19.k();
        if (r110 == null) goto L59;
        Integer r111 = r110.a;
        if (r111 == null) goto L59;
        if (r111.intValue() != 16) goto L59;
        r0 = true;
    L59:
        if (r0 == true) goto L60;
        return;
    L60:
        ny9.u r112 = this.g;
        String r1 = null;
        if (r112 == null) goto L63;
        String r4 = r112.m();
    L64:
        ny9.u r113 = this.g;
        if (r113 == null) goto L67;
        String r5 = r113.i();
    L68:
        ny9.u r114 = this.g;
        if (r114 == null) goto L71;
        String r3 = r114.getEnterMethod();
    L72:
        ny9.u r115 = this.g;
        if (r115 == null) goto L75;
        Integer r2 = Integer.valueOf((int) (System.currentTimeMillis() - r115.b));
    L76:
        ny9.u r116 = this.g;
        if (r116 == null) goto L79;
        String r6 = r116.f();
    L80:
        ny9.u r117 = this.g;
        if (r117 == null) goto L83;
        String r8 = r117.p();
    L84:
        ny9.u r118 = this.g;
        if (r118 == null) goto L87;
        String r7 = r118.j();
    L88:
        ny9.u r119 = this.g;
        if (r119 == null) goto L91;
        r1 = r119.getBotId();
    L91:
        nz9.c.c("click_close", r2, r3, r4, r5, r6, r7, r8, r1);
        return;
    L87:
        r7 = null;
        goto L88
    L83:
        r8 = null;
        goto L84
    L79:
        r6 = null;
        goto L80
    L75:
        r2 = null;
        goto L76
    L71:
        r3 = null;
        goto L72
    L67:
        r5 = null;
        goto L68
    L63:
        r4 = null;
    L47:
        r18 = false;
        goto L48
    L27:
        if (r14 == 2) goto L34;
        if (r14 != 3) goto L32;
        U90();
        goto L37
    L32:
        throw new NoWhenBranchMatchedException();
    L34:
        if (ICreationWorkflowService.a.L() == true) goto L37;
        U90();
        goto L37
    L5:
        if (W90().b() == CreationHostUiPolicy.ExitAction.CLOSE_HOST) goto L7;
        boolean r120 = true;
    L8:
        if (r120 == false) goto L18;
        uy9.a r121 = (uy9.a) this.k.getValue();
        if (r121 != null) goto L12;
    L14:
        boolean r122 = false;
    L15:
        if (r122 == false) goto L18;
        FLogger.a.i("CreationFragment", "interceptClickLeftTitleQuit by templateFeedAbility");
        return;
    L12:
        if (r121.jT() != true) goto L14;
        r122 = true;
        goto L15
    L7:
        r120 = false;
        goto L8
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
        this.f = r7;
        ny9.u r2 = new ny9.u(r7);
        s1a.a.g(this).n(r2, ny9.u.class);
        this.g = r2;
        s1a.a.g(this).c(this, v.class);
        return;
    L5:
        r6 = null;
        goto L7
    }

    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        IComponentRegistry.a r8 = IComponentRegistry.a;
        ContainerFilter r0 = ContainerFilter.INPUT_ONLY;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r0, "filter");
        u1a.d r9 = u1a.d.a;
        Intrinsics.checkNotNullParameter(r0, "filter");
        monitor-enter(r9);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (u1a.d.c.containsKey(r0) == false) goto L9;
        if (u1a.d.b.containsKey(r0) == false) goto L9;
        boolean r1 = true;
    L10:
        monitor-exit(r9);
        if (r1 == true) goto L13;
        IComponentRegistry.a.d();
    L13:
        FragmentAttachExtKt.b(this, r0);
        k1a.b.a(this, new c(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
        return;
    L9:
        r1 = false;
        goto L10
    }

    @Override // com.larus.uaigc.createpage.v
    public final int Ts(int r3, int r4) {
        CreationHostUiPolicy r0 = W90();
        ny9.s r1 = V90();
        if (r1 == null) goto L5;
        Integer r2 = r1.l();
    L7:
        if (r0.a == false) goto L14;
        if (r2 != null) goto L11;
        return r3;
    L11:
        if (r2.intValue() == 24) goto L13;
        return r3;
    L13:
        return RangesKt.coerceAtLeast(r3, r4);
    L14:
        return r3;
    L5:
        r2 = null;
        goto L7
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r13, r14);
        LarusFragmentCreationPageBinding r15 = this.e;
        if (r15 != null) goto L5;
        return;
    L5:
        NovaTitleBarEx r16 = r15.j;
        CreationHostUiPolicy r0 = W90();
        CreationHostUiPolicy.TitleBarMode r1 = r0.c();
        int r2 = CreationHostUiPolicy.c.a[r1.ordinal()];
        boolean r7 = true;
        if (r2 == 1) goto L20;
        if (r2 == 2) goto L16;
        if (r2 != 3) goto L10;
        CreationHostUiPolicy.b r3 = new CreationHostUiPolicy.b(r1, CreationHostUiPolicy.LeadingAction.BACK, false, true);
    L21:
        CreationHostUiPolicy.b r9 = r3;
    L23:
        if (r9.a == CreationHostUiPolicy.TitleBarMode.NATIVE) goto L30;
        Intrinsics.checkNotNull(r16);
        ViewGroup.LayoutParams r4 = r16.getLayoutParams();
        if (r4 == null) goto L28;
        r4.height = c7.b(44);
        r16.setLayoutParams(r4);
        goto L30
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L30:
        if (r9.d == false) goto L44;
        ny9.s r5 = V90();
        if (r5 == null) goto L34;
        String r6 = r5.w();
    L35:
        if (r6 != null) goto L38;
        r6 = "";
    L38:
        if (r6.length() != 0) goto L40;
        boolean r8 = true;
    L41:
        if (r8 == false) goto L43;
        r6 = getString(2131897499);
    L43:
        NovaTitleBarEx.Y5(r16, r6, null, null, 6);
        goto L44
    L40:
        r8 = false;
        goto L41
    L34:
        r6 = null;
    L44:
        int r10 = b.a[r9.b.ordinal()];
        if (r10 == 1) goto L56;
        if (r10 == 2) goto L51;
        if (r10 != 3) goto L50;
        e1.o(r16.getBinding().d);
        NovaTitleBarEx.b6(r16, 2131240298, false, null, getString(2131898809), new n(this), 6);
    L58:
        if (r9.c == false) goto L60;
        r16.U5("", "", AccountService.a.s());
        r16.T5(Integer.valueOf(c7.b(18)), Integer.valueOf(c7.b(32)));
        r16.setAvatarClickListener(new o(this));
    L60:
        LarusFragmentCreationPageBinding r17 = this.e;
        if (r17 == null) goto L65;
        View r18 = r17.b;
        if (r18 == null) goto L65;
        r18.setOnClickListener(new p(this));
    L65:
        UV(false);
        final ChatConstraintLayout r19 = r15.e;
        final int r110 = c7.b(16);
        final Function2 r11 = r19.getInterruptBottomPaddingUpdate();
        r19.setInterruptBottomPaddingUpdate(new d(r19, r110, this, r11));
        r19.post(new e(r19, r110, this));
        LarusFragmentCreationPageBinding r111 = this.e;
        if (r111 == null) goto L74;
        FrameLayout r112 = r111.g;
        if (r112 == null) goto L74;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if (r113 == null) goto L73;
        com.larus.utils.i0.a.getClass();
        r113.height = com.larus.utils.i0.g();
        r112.setLayoutParams(r113);
        r112.setBackgroundColor(ContextCompat.getColor(r112.getContext(), v19.c.b(2130970531, r112.getContext(), 2131102535)));
        goto L74
    L73:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L74:
        ny9.s r114 = this.f;
        if (r114 == null) goto L82;
        Integer r115 = r114.l();
        if (r115 == null) goto L82;
        if (r115.intValue() != 28) goto L82;
    L83:
        if (r7 == true) goto L88;
        z8 r116 = (z8) this.m.getValue();
        if (r116 == null) goto L89;
        r116.w9(false);
        return;
    L89:
        return;
    L88:
        return;
    L82:
        r7 = false;
        goto L83
    L50:
        throw new NoWhenBranchMatchedException();
    L51:
        e1.o(r16.getBinding().d);
        View r12 = r16.Z5(2131240810, true, ImageView.ScaleType.CENTER_INSIDE, getString(2131898805), new l(this));
        ViewGroup.LayoutParams r20 = r12.getLayoutParams();
        if (r20 == null) goto L55;
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r20;
        r21.width = c7.b(36);
        r21.height = c7.b(36);
        r21.setMarginStart(c7.b(12));
        r12.setLayoutParams(r21);
        goto L58
    L55:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L56:
        e1.o(r16.getBinding().c);
        e1.o(r16.getBinding().d);
        goto L58
    L10:
        if (r2 != 4) goto L13;
        r3 = new CreationHostUiPolicy.b(r1, CreationHostUiPolicy.LeadingAction.CLOSE, false, false);
        goto L21
    L13:
        throw new NoWhenBranchMatchedException();
    L16:
        if (CollectionsKt.contains(SetsKt.setOf(new String[]{"/creation/image-edit", "/creation/photo-motion"}), r0.b) == false) goto L18;
        CreationHostUiPolicy.LeadingAction r22 = CreationHostUiPolicy.LeadingAction.NONE;
    L19:
        r9 = new CreationHostUiPolicy.b(r1, r22, false, false);
        goto L23
    L18:
        r22 = CreationHostUiPolicy.LeadingAction.CLOSE;
        goto L19
    L20:
        r3 = new CreationHostUiPolicy.b(r1, CreationHostUiPolicy.LeadingAction.NONE, true, true);
        goto L21
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        ChatConstraintLayout r16 = r13.inflate(2131562373, r14, false);
        int r17 = 2131363170;
        View r2 = ViewBindings.findChildViewById(r16, 2131363170);
        if (r2 == null) goto L48;
        r17 = 2131363665;
        if (((ViewStub) ViewBindings.findChildViewById(r16, 2131363665)) == null) goto L48;
        r17 = 2131365537;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r16, 2131365537);
        if (r3 == null) goto L48;
        r17 = 2131375364;
        ViewStub r18 = (ViewStub) ViewBindings.findChildViewById(r16, 2131375364);
        if (r18 == null) goto L48;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r16, 2131379825);
        if (r5 == null) goto L46;
        ChatConstraintLayout r6 = r16;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r16, 2131388328);
        if (r7 == null) goto L45;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r16, 2131388347);
        if (r8 == null) goto L44;
        View r9 = ViewBindings.findChildViewById(r16, 2131388348);
        if (r9 == null) goto L43;
        View r10 = ViewBindings.findChildViewById(r16, 2131388349);
        if (r10 == null) goto L42;
        NovaTitleBarEx r11 = ViewBindings.findChildViewById(r16, 2131388772);
        if (r11 == null) goto L41;
        this.e = new LarusFragmentCreationPageBinding(r6, r2, r3, r18, r5, r6, r7, r8, r9, r10, r11);
        InputViewCreatorDelegate.b.a(r18, 2131375364);
        LarusFragmentCreationPageBinding r19 = this.e;
        if (r19 == null) goto L27;
        ChatConstraintLayout r110 = r19.e;
        if (r110 == null) goto L27;
        com.larus.uaigc.createpage.utils.p.a(r110);
    L27:
        LarusFragmentCreationPageBinding r111 = this.e;
        if (r111 == null) goto L30;
        ChatConstraintLayout r112 = r111.e;
    L31:
        nz9.b r113 = nz9.b.a;
        if (r112 != null) goto L34;
    L37:
        LarusFragmentCreationPageBinding r114 = this.e;
        if (r114 != null) goto L40;
        return null;
    L40:
        return r114.e;
    L34:
        if (Intrinsics.areEqual(((LinkedHashMap) nz9.b.d).get("creation_page/first_frame"), Boolean.TRUE) == true) goto L37;
        r112.getViewTreeObserver().addOnPreDrawListener(new nz9.a(r112));
        goto L37
    L30:
        r112 = null;
        goto L31
    L41:
        r17 = 2131388772;
        goto L48
    L42:
        r17 = 2131388349;
        goto L48
    L43:
        r17 = 2131388348;
        goto L48
    L44:
        r17 = 2131388347;
        goto L48
    L45:
        r17 = 2131388328;
        goto L48
    L46:
        r17 = 2131379825;
    L48:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r17)));
    }
}
