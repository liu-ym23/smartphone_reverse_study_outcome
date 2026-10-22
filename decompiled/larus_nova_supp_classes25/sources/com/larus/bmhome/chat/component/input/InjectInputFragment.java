package com.larus.bmhome.chat.component.input;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import androidx.collection.LruCache;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.ab.InputMultilineScene;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.common_ui.widget.InjectInputContainer;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001WB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u000204H\u0016J&\u00108\u001a\u0004\u0018\u00010\u00062\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u001a\u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010?\u001a\u000204H\u0016J\b\u0010@\u001a\u000204H\u0002J\b\u0010A\u001a\u00020)H\u0002J\u0012\u0010B\u001a\u0002042\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0010\u0010E\u001a\u0002042\u0006\u0010F\u001a\u00020GH\u0002J\u0012\u0010H\u001a\u0002042\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0012\u0010I\u001a\u0002042\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\b\u0010J\u001a\u000204H\u0016J\b\u0010K\u001a\u000204H\u0002J\b\u0010L\u001a\u00020)H\u0002J\u0010\u0010M\u001a\u0002042\u0006\u0010N\u001a\u00020)H\u0016J\b\u0010O\u001a\u000204H\u0016J\b\u0010P\u001a\u00020QH\u0016J\u0010\u0010R\u001a\u0002042\u0006\u0010S\u001a\u00020)H\u0016J\b\u0010T\u001a\u00020)H\u0016J\b\u0010U\u001a\u00020GH\u0016J\b\u0010V\u001a\u00020)H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000e\u001a\u0004\b%\u0010&R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u000e\u001a\u0004\b0\u00101¨\u0006X"}, d2 = {"Lcom/larus/bmhome/chat/component/input/InjectInputFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/bmhome/injectinput/IInjectInputHostCallback;", "<init>", "()V", "injectInputRootView", "Landroid/view/View;", "injectInputContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "multimodalAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalAbility$delegate", "Lkotlin/Lazy;", "attachmentAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "injectInputAbility", "Lcom/larus/bmhome/injectinput/IInjectInputAbility;", "getInjectInputAbility", "()Lcom/larus/bmhome/injectinput/IInjectInputAbility;", "injectInputAbility$delegate", "chatCameraAbility", "Lcom/larus/bmhome/camera/IChatCameraAbility;", "getChatCameraAbility", "()Lcom/larus/bmhome/camera/IChatCameraAbility;", "chatCameraAbility$delegate", "componentAttached", "", "pendingExpandStatus", "Ljava/lang/Boolean;", "pendingShowInputRunnable", "Ljava/lang/Runnable;", "initialInputStateController", "Lcom/larus/bmhome/injectinput/InjectInputInitialStateController;", "getInitialInputStateController", "()Lcom/larus/bmhome/injectinput/InjectInputInitialStateController;", "initialInputStateController$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "attachComponents", "shouldUsePhotoPickerCameraInput", "addToAttachment", "uri", "Landroid/net/Uri;", "showInjectInputView", "addedItemUri", "", "deleteFromAttachment", "onAttachmentDeleted", "resetAllAttachmentInfo", "hideInjectInputView", "shouldKeepInjectInputForText", "hideIme", "forceHide", "forceCloseIme", "getChatUniqueKey", "", "onExpandStatusChanged", "expand", "isInjectInputViewShowing", "getCurrentPageName", "autoLogEnterPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class InjectInputFragment extends TraceFragment implements op8.g {
    public static final /* synthetic */ int p = 0;
    public View e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public boolean l;
    public Boolean m;
    public p0 n;
    public final Lazy o;

    public static final class a {
    }

    public static final class b implements ICoreInputAbility.e {
        public final /* synthetic */ InjectInputFragment a;

        public b(InjectInputFragment r1) {
            this.a = r1;
        }

        public final void h(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
        }

        public final void i(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
            if (r2.length() != 0) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == false) goto L9;
            InjectInputFragment r4 = this.a;
            int r0 = InjectInputFragment.p;
            r4.V90();
            return;
        L9:
            return;
        L5:
            r3 = false;
            goto L6
        }

        public final void j(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ InjectInputFragment a;
        public final /* synthetic */ View b;
        public final /* synthetic */ String c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            FLogger.a.d("InjectInputFragment", "showInjectInputView onAnimationEnd");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            FLogger.a.d("InjectInputFragment", "showInjectInputView onAnimationStart");
            InjectInputFragment r4 = this.a;
            int r0 = InjectInputFragment.p;
            op8.e r5 = (op8.e) r4.j.getValue();
            if (r5 == null) goto L6;
            r5.M7(this.b, this.c);
            return;
        }

        public c(InjectInputFragment r1, View r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.input.InjectInputFragment$onViewCreated$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.input.InjectInputFragment$onViewCreated$3", f = "InjectInputFragment.kt", i = {}, l = {230}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InjectInputFragment this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.input.InjectInputFragment$onViewCreated$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "hasAttachment", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.chat.component.input.InjectInputFragment$onViewCreated$3$1", f = "InjectInputFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
            /* synthetic */ boolean Z$0;
            int label;
            final /* synthetic */ InjectInputFragment this$0;

            public AnonymousClass1(InjectInputFragment r1, Continuation<? super AnonymousClass1> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
                r0.Z$0 = ((Boolean) r3).booleanValue();
                return r0;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
            }

            public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
                return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L23;
                ResultKt.throwOnFailure(r2);
                if (this.Z$0 == false) goto L19;
                InjectInputFragment r3 = this.this$0;
                int r0 = InjectInputFragment.p;
                g1 r4 = r3.U90();
                if (r4 == null) goto L15;
                List<UplinkFileEntity> r5 = r4.q1();
                if (r5 == null) goto L15;
                UplinkFileEntity r6 = (UplinkFileEntity) CollectionsKt.lastOrNull(r5);
                if (r6 == null) goto L15;
                Uri r7 = r6.getUri();
                if (r7 == null) goto L15;
                String r8 = r7.toString();
            L16:
                if (r8 != null) goto L18;
                r8 = "";
            L18:
                this.this$0.X90(r8);
            L21:
                return Unit.INSTANCE;
            L15:
                r8 = null;
                goto L16
            L19:
                InjectInputFragment r9 = this.this$0;
                int r1 = InjectInputFragment.p;
                r9.V90();
                goto L21
            L23:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass3(InjectInputFragment r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            InjectInputFragment r7 = this.this$0;
            int r2 = InjectInputFragment.p;
            g1 r8 = r7.U90();
            if (r8 == null) goto L16;
            b1 r9 = r8.Ry();
            if (r9 == null) goto L16;
            AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (kotlinx.coroutines.flow.e.i(r9, r3, this) != r0) goto L16;
            return r0;
        }
    }

    static {
    }

    public final boolean S90() {
        return false;
    }

    public final g1 U90() {
        return (g1) this.g.getValue();
    }

    public final void V90() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("hideInjectInputView attachmentListSize=");
        g1 r2 = U90();
        if (r2 == null) goto L7;
        List<UplinkFileEntity> r3 = r2.q1();
        if (r3 == null) goto L7;
        Integer r4 = Integer.valueOf(r3.size());
    L8:
        r1.append(r4);
        r1.append(" injectInputRootView=");
        View r5 = this.e;
        boolean r6 = true;
        if (r5 != null) goto L11;
        Boolean r7 = null;
    L16:
        r1.append(r7);
        r0.d("InjectInputFragment", r1.toString());
        g1 r8 = U90();
        if (r8 == null) goto L19;
        List<UplinkFileEntity> r9 = r8.q1();
    L20:
        List<UplinkFileEntity> r10 = r9;
        if (r10 != null) goto L23;
    L26:
        if (r6 == true) goto L28;
        return;
    L28:
        if (W90() == true) goto L47;
        p0 r11 = this.n;
        if (r11 == null) goto L34;
        View r12 = this.e;
        if (r12 == null) goto L34;
        r12.removeCallbacks(r11);
    L34:
        this.n = null;
        View r13 = this.e;
        if (r13 != null) goto L37;
        return;
    L37:
        if (isVisible() == false) goto L50;
        e1.o(r13);
        ICoreInputAbility r14 = (ICoreInputAbility) this.h.getValue();
        if (r14 == null) goto L42;
        r14.qp(false);
    L42:
        op8.e r15 = (op8.e) this.j.getValue();
        if (r15 == null) goto L49;
        r15.f4(r13);
        return;
    L49:
        return;
    L50:
        return;
    L47:
        return;
    L23:
        if (r10.isEmpty() == true) goto L26;
        r6 = false;
        goto L26
    L19:
        r9 = null;
        goto L20
    L11:
        if (r5.getVisibility() != 0) goto L13;
        boolean r16 = true;
    L14:
        r7 = Boolean.valueOf(r16);
        goto L16
    L13:
        r16 = false;
    L7:
        r4 = null;
        goto L8
    }

    public final boolean W90() {
        ac8.d r0 = ac8.f.a;
        if (ac8.f.a(InputMultilineScene.ALBUM_QUICK_INPUT).a == false) goto L18;
        ICoreInputAbility r1 = (ICoreInputAbility) this.h.getValue();
        if (r1 == null) goto L14;
        String r2 = r1.N5();
        if (r2 == null) goto L14;
        if (r2.length() <= 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 != true) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L19;
        return true;
    L19:
        return false;
    L11:
        r3 = false;
    L14:
        r4 = false;
        goto L15
    L18:
        return false;
    }

    public final boolean lr() {
        View r0 = this.e;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getVisibility() == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public final void onDestroyView() {
        p0 r0 = this.n;
        if (r0 == null) goto L7;
        View r1 = this.e;
        if (r1 == null) goto L7;
        r1.removeCallbacks(r0);
    L7:
        this.n = null;
        this.e = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public InjectInputFragment() {
        this.f = LazyKt.lazy(new r(this));
        this.g = LazyKt.lazy(new c0(this));
        this.h = LazyKt.lazy(new j0(this));
        this.i = LazyKt.lazy(new k0(this));
        this.j = LazyKt.lazy(new l0(this));
        this.k = LazyKt.lazy(new m0(this));
        this.o = LazyKt.lazy(new n0(this));
    }

    public final void c3() {
        View r0 = getView();
        InjectInputContainer r1 = null;
        if (r0 == null) goto L5;
        ViewParent r2 = r0.getParent();
    L7:
        if ((r2 instanceof InjectInputContainer) == false) goto L9;
        r1 = (InjectInputContainer) r2;
    L9:
        va8.o r3 = (va8.o) this.i.getValue();
        if (r3 == null) goto L12;
        r3.c3();
    L12:
        if (r1 == null) goto L19;
        Function3 r4 = r1.e;
        if (r4 == null) goto L16;
        int r5 = ((Number) r4.invoke(r1.getContext(), ViewCompat.getRootWindowInsets(r1), Integer.valueOf(r1.a))).intValue();
    L17:
        r1.setPaddingRelative(0, 0, 0, r5);
        r1.c.invoke();
        return;
    L16:
        r5 = 0;
        goto L17
    L19:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final long getChatUniqueKey() {
        de8.c r0 = (de8.c) s1a.a.g(this).a(de8.c.class);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.n;
    }

    public final String k() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        String r1 = r0.getString("current_page", "");
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "inject_input";
    }

    public final void onDestroy() {
        if (s1a.a.g(this).a(op8.k.class) == null) goto L9;
        Bundle r0 = getArguments();
        if (r0 == null) goto L9;
        String r1 = r0.getString("inject_input_initial_attachment_snapshot_id");
        if (r1 == null) goto L9;
        dr9.g r2 = dr9.g.a;
        dr9.g.f(r1);
    L9:
        ((op8.j) this.o.getValue()).a();
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.l = false;
    }

    public final void ru() {
        g1 r0 = U90();
        if (r0 == null) goto L5;
        r0.W0();
    L5:
        V90();
    }

    public final void Ed(Uri r4) {
        FLogger.a.d("InjectInputFragment", "deleteFromAttachment uri=" + r4);
        if (r4 == null) goto L5;
        op8.j r0 = (op8.j) this.o.getValue();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "uri");
        r0.k = SetsKt.minus(r0.k, r4);
    L5:
        g1 r1 = U90();
        if (r1 == null) goto L8;
        r1.kS(r4);
    L8:
        V90();
    }

    public final void LQ(Uri r22) {
        FLogger.a.d("InjectInputFragment", "addToAttachment uri=" + r22);
        if (r22 != null) goto L5;
        return;
    L5:
        op8.j r2 = (op8.j) this.o.getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r22, "uri");
        if ((!r2.l.isEmpty()) == false) goto L8;
    L32:
        com.larus.bmhome.chat.component.bottom.multimodal.g r3 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.f.getValue();
        if (r3 == null) goto L42;
        String r6 = null;
        List r9 = CollectionsKt.listOf(new com.larus.bmhome.chat.component.bottom.multimodal.a.C0050a(r22, null, 2));
        com.larus.bmhome.chat.component.bottom.multimodal.g1 r10 = new com.larus.bmhome.chat.component.bottom.multimodal.g1(true, MultimodalBizScene.PhotoPickerAttachmentPanel, false);
        Bundle r4 = getArguments();
        if (r4 == null) goto L37;
        String r5 = r4.getString("click_from");
    L39:
        if (Intrinsics.areEqual(r5, "chat_album_preview_click") == false) goto L41;
        r6 = "photo_picker_attachment";
    L41:
        r3.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(r9, r10, null, null, new com.larus.bmhome.chat.component.bottom.multimodal.m(null, null, null, null, false, r6, 63), 12));
        goto L42
    L37:
        r5 = null;
    L42:
        X90(r22.toString());
        return;
    L8:
        if (r2.k.isEmpty() == true) goto L32;
        if (r2.k.contains(r22) == true) goto L32;
        Iterable r7 = (Iterable) r2.b.invoke();
        ArrayList r8 = new ArrayList();
        Iterator r11 = r7.iterator();
    L14:
        if (r11.hasNext() == false) goto L25;
        Object r12 = r11.next();
        UplinkFileEntity r13 = (UplinkFileEntity) r12;
        if (CollectionsKt.contains(r2.l, r13.getFileIdentifier()) == false) goto L18;
    L21:
        boolean r14 = true;
    L22:
        if (r14 == false) goto L14;
        r8.add(r12);
        goto L14
    L18:
        if (CollectionsKt.contains(r2.k, r13.getUri()) == true) goto L21;
        r14 = false;
        goto L22
    L25:
        if ((!r8.isEmpty()) == false) goto L27;
        r2.d.invoke(r8);
    L31:
        r2.k = SetsKt.emptySet();
        r2.l = SetsKt.emptySet();
        goto L32
    L27:
        Iterator r15 = r2.k.iterator();
    L29:
        if (r15.hasNext() == false) goto L31;
        r2.e.invoke((Uri) r15.next());
        goto L29
    }

    public final void O9(boolean r4) {
        FLogger r0 = FLogger.a;
        r0.i("InjectInputFragment", "[onExpandStatusChanged] expand: " + r4);
        if (this.l == true) goto L5;
    L14:
        this.m = Boolean.valueOf(r4);
        return;
    L5:
        if (isAdded() == false) goto L14;
        if (isDetached() == true) goto L14;
        if (((zb8.e) this.k.getValue()) != null) goto L11;
        r0.e("InjectInputFragment", "onExpandStatusChanged, chatCameraAbility is null");
        EnsureManager.ensureNotReachHere("onExpandStatusChanged, chatCameraAbility is null");
    L11:
        zb8.e r1 = (zb8.e) this.k.getValue();
        if (r1 == null) goto L16;
        r1.kL(r4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.larus.bmhome.chat.component.input.p0, java.lang.Runnable] */
    public final void X90(final String r7) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("showInjectInputView injectInputRootView=");
        View r2 = this.e;
        boolean r3 = false;
        if (r2 != null) goto L5;
        Boolean r4 = null;
    L10:
        r1.append(r4);
        r0.d("InjectInputFragment", r1.toString());
        final View r5 = this.e;
        if (r5 == 0) goto L27;
        p0 r6 = this.n;
        if (r6 == null) goto L15;
        r5.removeCallbacks(r6);
    L15:
        this.n = null;
        if (uy8.b.c() == true) goto L18;
        r3 = isVisible();
    L21:
        if (r3 == false) goto L25;
        op8.e r8 = (op8.e) this.j.getValue();
        if (r8 == null) goto L28;
        r8.M7(r5, r7);
        return;
    L28:
        return;
    L25:
        ?? r9 = new p0(this, r5, r7);
        this.n = r9;
        r5.postDelayed(r9, 200);
        return;
    L18:
        if (r5.getVisibility() != 0) goto L21;
        r3 = true;
        goto L21
    L27:
        return;
    L5:
        if (r2.getVisibility() != 0) goto L7;
        boolean r10 = true;
    L8:
        r4 = Boolean.valueOf(r10);
        goto L10
    L7:
        r10 = false;
        goto L8
    }

    public final void h0(Uri r1) {
        V90();
    }

    public final void o7(boolean r2) {
        ICoreInputAbility r3 = (ICoreInputAbility) this.h.getValue();
        if (r3 == null) goto L6;
        r3.qp(true);
        return;
    }

    public final void onCreate(Bundle r24) {
        Fragment r1 = getParentFragment();
        if (r1 == null) goto L9;
        t1a.b r2 = s1a.a.g(r1);
        if (r2 == null) goto L9;
        op8.k r3 = r2.a(op8.k.class);
        if (r3 == null) goto L9;
        s1a.a.g(this).n(r3, op8.k.class);
    L9:
        super.onCreate(r24);
        Bundle r4 = getArguments();
        if (r4 != null) goto L12;
        r4 = new Bundle();
    L12:
        Bundle r5 = r4;
        s1a.a.g(this).n(new dr9.d(r5.getBoolean("inject_input_mobile_preview_host_enabled", false)), dr9.d.class);
        t1a.b r6 = s1a.a.g(this);
        LruCache r7 = ko8.a.a;
        r6.n(new de8.c(r5, r5, false, null, null, false, null, null, null, null, false, false, null, ko8.a.g(), 24572), de8.c.class);
        ChatParam r8 = new ChatParam(null, null, null, null, null, 255);
        Bundle r9 = getArguments();
        String r10 = "";
        if (r9 == null) goto L16;
        String r11 = r9.getString("current_page", "");
        if (r11 == null) goto L16;
    L17:
        r8.d = r11;
        Bundle r12 = getArguments();
        if (r12 == null) goto L21;
        String r13 = r12.getString("conversation_id", "");
        if (r13 == null) goto L21;
    L22:
        r8.a = r13;
        Bundle r14 = getArguments();
        if (r14 == null) goto L28;
        String r15 = r14.getString("bot_id", "");
        if (r15 == null) goto L28;
        r10 = r15;
    L28:
        r8.b = r10;
        s1a.a.g(this).n(r8, ChatParam.class);
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_ONLY);
        k1a.b.a(this, new q0(this));
        this.l = true;
        return;
    L21:
        r13 = "";
    L16:
        r11 = "";
        goto L17
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        this.e = r8.findViewById(2131375298);
        Fragment r10 = getParentFragment();
        if (r10 == null) goto L5;
        View r11 = r10.getView();
    L7:
        if ((r11 instanceof ViewGroup) == false) goto L9;
        ViewGroup r12 = (ViewGroup) r11;
    L10:
        if (r12 == null) goto L14;
        va8.o r1 = s1a.a.g(this).getAbility(va8.o.class);
        if (r1 == null) goto L14;
        r1.m1(r12);
    L14:
        Boolean r13 = this.m;
        if (r13 == null) goto L21;
        boolean r14 = r13.booleanValue();
        zb8.e r2 = (zb8.e) this.k.getValue();
        if (r2 == null) goto L19;
        r2.kL(r14);
    L19:
        this.m = null;
    L21:
        if (uy8.b.c() == false) goto L23;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AnonymousClass3(this, null), 3, null);
    L23:
        r8.post(new o0(this));
        ICoreInputAbility r15 = (ICoreInputAbility) this.h.getValue();
        if (r15 == null) goto L27;
        r15.QG(new b(this));
        return;
    L27:
        return;
    L9:
        r12 = null;
        goto L10
    L5:
        r11 = null;
        goto L7
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131562834, r3, false);
        ViewStub r6 = (ViewStub) r5.findViewById(2131375364);
        InputViewCreatorDelegate r0 = InputViewCreatorDelegate.b;
        Intrinsics.checkNotNull(r6);
        r0.a(r6, 2131375364);
        return r5;
    }
}
