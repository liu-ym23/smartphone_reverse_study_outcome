package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.foundation.widget.FlowSwitch;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.MmRecordingAINoteRepo;
import com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MviBaseFragment;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u0090\u00012\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001:\u0002\u0090\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010G\u001a\u0002042\u0006\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u001a\u0010N\u001a\u00020\n2\u0006\u0010O\u001a\u0002042\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u0010\u0010P\u001a\u00020\n2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010Q\u001a\u00020\nH\u0002J\b\u0010R\u001a\u00020\nH\u0002J\"\u0010S\u001a\u00020\n2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020U2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J-\u0010Y\u001a\u00020\n2\u0006\u0010T\u001a\u00020U2\u000e\u0010Z\u001a\n\u0012\u0006\b\u0001\u0012\u00020!0[2\u0006\u0010\\\u001a\u00020]H\u0016¢\u0006\u0002\u0010^J\b\u0010_\u001a\u00020\nH\u0016J\u001e\u0010`\u001a\u00020\n2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020b2\u0006\u0010d\u001a\u00020\u0011J\u0006\u0010e\u001a\u00020\nJ\u0006\u0010f\u001a\u00020\nJ\u000e\u0010g\u001a\u00020\n2\u0006\u0010h\u001a\u00020!J\u0018\u0010i\u001a\u00020\n2\u0006\u0010a\u001a\u00020b2\b\b\u0002\u0010c\u001a\u00020bJ\u0018\u0010j\u001a\u00020\n2\u0006\u0010a\u001a\u00020b2\b\b\u0002\u0010c\u001a\u00020bJ\u000e\u0010k\u001a\u00020\n2\u0006\u0010l\u001a\u00020\u0011J\r\u0010m\u001a\u0004\u0018\u00010b¢\u0006\u0002\u0010nJ\u0006\u0010o\u001a\u00020\u0011J\b\u0010p\u001a\u00020\nH\u0002J!\u0010q\u001a\u00020\n2\u0017\u0010r\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u0002060\u0010¢\u0006\u0002\bsH\u0002J\b\u0010t\u001a\u00020\nH\u0002J\b\u0010u\u001a\u00020\nH\u0002J\u0010\u0010v\u001a\u00020\n2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010w\u001a\u00020\nH\u0002J\u0018\u0010x\u001a\u00020\u00112\u0006\u0010y\u001a\u0002042\u0006\u0010z\u001a\u000204H\u0002J\u0018\u0010{\u001a\u00020\u00112\u0006\u0010y\u001a\u0002042\u0006\u0010z\u001a\u000204H\u0002J\u0018\u0010|\u001a\u00020\n2\u0006\u0010&\u001a\u00020'2\u0006\u0010}\u001a\u00020\u0011H\u0002J\u0018\u0010~\u001a\u00020\n2\u0006\u0010&\u001a\u00020'2\u0006\u0010}\u001a\u00020\u0011H\u0002J\u0018\u0010\u007f\u001a\u00020\n2\u0006\u0010&\u001a\u00020'2\u0006\u0010}\u001a\u00020\u0011H\u0002J.\u0010\u0080\u0001\u001a\u00020\n2\u0007\u0010\u0081\u0001\u001a\u0002042\u0007\u0010\u0082\u0001\u001a\u0002042\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u0011H\u0002J\u001a\u0010\u0086\u0001\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u0002042\u0006\u0010}\u001a\u00020\u0011H\u0002J\u001a\u0010\u0088\u0001\u001a\u00020U2\u0006\u0010O\u001a\u0002042\u0007\u0010\u0089\u0001\u001a\u00020UH\u0002J\u0016\u0010\u008a\u0001\u001a\u00020\n*\u0002042\u0007\u0010\u008b\u0001\u001a\u00020\u0011H\u0002J\"\u0010\u008c\u0001\u001a\u00020\n*\u0002042\u0013\u0010\u008d\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u0010H\u0002J\u0010\u0010\u008e\u0001\u001a\u00020!*\u0005\u0018\u00010\u008f\u0001H\u0002R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u0002068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u00109\u001a\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010#R\u0014\u0010;\u001a\u00020<8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u001b\u0010?\u001a\u00020\u00058TX\u0094\u0084\u0002¢\u0006\f\n\u0004\bB\u0010%\u001a\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020D8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006\u0091\u0001"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteFragment;", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/mvi/MviBaseFragment;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteVMState;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteVMEvent;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteUIEvent;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteViewModel;", "<init>", "()V", "onDismiss", "Lkotlin/Function0;", "", "getOnDismiss", "()Lkotlin/jvm/functions/Function0;", "setOnDismiss", "(Lkotlin/jvm/functions/Function0;)V", "onVisibilityChanged", "Lkotlin/Function1;", "", "getOnVisibilityChanged", "()Lkotlin/jvm/functions/Function1;", "setOnVisibilityChanged", "(Lkotlin/jvm/functions/Function1;)V", "onNavigateToSubtitle", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteSubtitleNavigationRequest;", "getOnNavigateToSubtitle", "setOnNavigateToSubtitle", "aiNoteRepo", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteRepo;", "getAiNoteRepo", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteRepo;", "setAiNoteRepo", "(Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteRepo;)V", "logDetail", "", "getLogDetail", "()Ljava/lang/String;", "logDetail$delegate", "Lkotlin/Lazy;", "binding", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmRecordAiNoteFragmentViewContract;", "panelAnimator", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINotePanelAnimator;", "dismissHandled", "mediaBridge", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteMediaBridge;", "saveSwitchTooltip", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/IMmBubbleHandle;", "globalFocusChangeListener", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "globalFocusChangeObserver", "Landroid/view/ViewTreeObserver;", "globalFocusChangeOwnerView", "Landroid/view/View;", "fragmentArgs", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteFragmentArgs;", "getFragmentArgs", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteFragmentArgs;", "ownerKey", "getOwnerKey", "uiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "getUiLaunchMode", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "viewModel", "getViewModel", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteViewModel;", "viewModel$delegate", "defaultViewModelProviderFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getDefaultViewModelProviderFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "bindClicks", "subscribeState", "subscribeEvents", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onDestroyView", "showAgain", "duration", "", "meetingStartTime", "expandImmediately", "dismissSheet", "hideSheet", "forceDismiss", "reason", "updateDuration", "updateDurationOnly", "updateAnimationState", "isPlaying", "createMarkAINote", "()Ljava/lang/Long;", "isPanelShowing", "handlePanelDismiss", "updateArgs", "update", "Lkotlin/ExtensionFunctionType;", "showSaveSwitchTooltip", "dismissSaveSwitchTooltip", "bindFocusObserver", "unbindFocusObserver", "isAINoteEditorFocus", PickerReporterConstants.KEY.TARGET, "root", "isDescendantOfRoot", "updateHeaderHeight", "saveSwitchVisible", "updateHeaderTitleLayout", "updateBottomActionLayout", "updateActionButtonLayout", "actionView", "iconView", "textView", "Landroid/widget/TextView;", "iconOnly", "updateMiddleSpacerLayout", "spacer", "dp", "value", "setAINoteSwitchChecked", "checked", "setAINoteSwitchChangeListener", "listener", "debugId", "", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmAINoteFragment extends MviBaseFragment<s, r, MmAINoteUIEvent, MmAINoteViewModel> {
    public static final /* synthetic */ int y = 0;
    public Function0<Unit> k;
    public Function1<? super Boolean, Unit> l;
    public Function1<? super com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l, Boolean> m;
    public MmRecordingAINoteRepo n;
    public final Lazy o;
    public mwb.b p;
    public MmAINotePanelAnimator q;
    public boolean r;
    public e s;
    public qub.a t;
    public com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.b u;
    public ViewTreeObserver v;
    public View w;
    public final Lazy x;

    public static final class a {
    }

    public static final class b implements e.a {
        public final /* synthetic */ MmAINoteFragment a;

        @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.e.a
        public final void d() {
            int r0 = bwb.b.a;
            MmUiLogScene r1 = MmUiLogScene.AI_NOTE;
            MmAINoteFragment r2 = this.a;
            int r3 = MmAINoteFragment.y;
            r2.getClass();
            bwb.b.h(r1, "MmAINoteFragment#onCameraOpenFailed", "fragment=".concat(MmAINoteFragment.ca0(this)), null);
            this.a.fa0().handleCameraOpenFailed();
        }

        public b(MmAINoteFragment r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.e.a
        public final void a(String r6) {
            Intrinsics.checkNotNullParameter(r6, AppbrandHostConstants.Schema_RESERVED_FIELD.PATH);
            int r0 = bwb.b.a;
            MmUiLogScene r1 = MmUiLogScene.AI_NOTE;
            StringBuilder r2 = new StringBuilder("fragment=");
            MmAINoteFragment r3 = this.a;
            int r4 = MmAINoteFragment.y;
            r3.getClass();
            r2.append(MmAINoteFragment.ca0(this));
            r2.append(" path=");
            r2.append(r6);
            bwb.b.g(r1, "MmAINoteFragment#onCameraPhotoReady", r2.toString(), null, 8);
            this.a.fa0().handleCapturedPhoto(r6);
        }
    }

    public static final class c implements com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.f {
        public final /* synthetic */ MmAINoteFragment a;

        @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.f
        public final void d() {
            MmAINotePanelAnimator r0 = this.a.q;
            if (r0 == null) goto L6;
            r0.G = Long.MAX_VALUE;
            r0.f.postDelayed(new o(r0), 300);
            return;
        }

        public c(MmAINoteFragment r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.f
        public final void a(long r5, Interpolator r7) {
            MmAINotePanelAnimator r0 = this.a.q;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r5 <= 0) goto L7;
            r0.M = r5;
        L7:
            r0.N = r7;
        }

        @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.f
        public final void c(int r13, List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.g> r14) {
            Intrinsics.checkNotNullParameter(r14, "images");
            e r1 = this.a.s;
            if (r1 == null) goto L57;
            Intrinsics.checkNotNullParameter(r14, "images");
            FragmentActivity r0 = r1.a.getActivity();
            if (r0 != null) goto L7;
            int r15 = bwb.b.a;
            bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINoteMediaBridge#previewImages", "skipped, activity is null", null, 8);
            return;
        L7:
            d.a.getClass();
            List r2 = d.a(r0, r14);
            ArrayList r5 = (ArrayList) r2;
            if (r5.isEmpty() == false) goto L10;
            int r3 = bwb.b.a;
            bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINoteMediaBridge#previewImages", "skipped, no valid image, index=" + r13 + " imageCount=" + ((ArrayList) r14).size(), null, 8);
            return;
        L10:
            ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
            Iterator r4 = r5.iterator();
        L12:
            if (r4.hasNext() == false) goto L14;
            r6.add((com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.d) ((Pair) r4.next()).getSecond());
            goto L12
        L14:
            Iterator r7 = r5.iterator();
            int r8 = 0;
            int r9 = 0;
        L15:
            boolean r10 = true;
            if (r7.hasNext() == false) goto L24;
            if (((Number) ((Pair) r7.next()).getFirst()).intValue() != r13) goto L20;
            boolean r11 = true;
        L21:
            if (r11 == true) goto L25;
            r9 = r9 + 1;
        L25:
            Integer r12 = Integer.valueOf(r9);
            if (r12.intValue() >= 0) goto L29;
            r10 = false;
        L29:
            if (r10 == true) goto L32;
            r12 = null;
        L32:
            if (r12 == null) goto L34;
            r8 = r12.intValue();
        L34:
            String r16 = OfficeSDKManager.getCurrentUid();
            if (r16 != null) goto L52;
            r16 = "";
        L52:
            Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L39
            Object r18 = Result.constructor-impl((com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b) OfficeSDKManager.getHostUserService(r16, com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b.class));     // Catch: Throwable -> L39
        L41:
            Throwable r19 = Result.exceptionOrNull-impl(r18);
            if (r19 == null) goto L45;
            int r20 = bwb.b.a;
            bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINoteMediaBridge#getHostGalleryPreviewDependency", "no host gallery dependency: " + r19.getMessage(), null, 8);
        L45:
            if (Result.isFailure-impl(r18) == false) goto L47;
            r18 = null;
        L47:
            com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b r21 = (com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b) r18;
            if (r21 != null) goto L50;
            int r22 = bwb.b.a;
            bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINoteMediaBridge#previewImages", "skipped, gallery preview dependency is not wired, index=" + r13 + " imageCount=" + ((ArrayList) r14).size(), null, 8);
            return;
        L50:
            r21.A(new com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.e(r6, r8), r1.a);
            int r110 = bwb.b.a;
            bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINoteMediaBridge#previewImages", "open gallery preview, index=" + r8 + " imageCount=" + r6.size(), null, 8);
            return;
        L39:
            th = move-exception;
            Result.Companion r23 = Result.Companion;
            r18 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L41
        L20:
            r11 = false;
            goto L21
        L24:
            r9 = -1;
            goto L25
        }

        @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.f
        public final void b(boolean r7, int r8, int r9) {
            MmAINotePanelAnimator r0 = this.a.q;
            if (r0 == null) goto L15;
            if (r7 == false) goto L6;
        L14:
            r0.f.post(new q(r0, r7, r8, r9));
            goto L15
        L6:
            if (r0.u <= 0) goto L14;
            if (r0.f.isAttachedToWindow() == true) goto L10;
        L13:
            r0.o("ime_hide");
            goto L14
        L10:
            if (r0.f.isFocused() == true) goto L13;
            boolean r1 = r0.f.requestFocus();
            int r2 = bwb.b.a;
            bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINotePanelAnimator", "[takeAINoteFocus] requested=" + r1 + " focused=" + r0.f.isFocused() + " reason=ime_hide", null, 8);
        L15:
            this.a.fa0().dispatchEvent(new MmAINoteUIEvent.f(r7));
        }
    }

    static {
    }

    public final MmAINoteViewModel fa0() {
        return (MmAINoteViewModel) this.x.getValue();
    }

    public final void ga0() {
        if (this.r == false) goto L6;
        int r0 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINoteFragment#handlePanelDismiss", "skip, already handled fragment=".concat(ca0(this)), null, 8);
        return;
    L6:
        this.r = true;
        Function0<Unit> r1 = this.k;
        fa0().dispatchEvent(new MmAINoteUIEvent.g(false));
        int r4 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINoteFragment#handlePanelDismiss", "start fragment=" + ca0(this) + " isAdded=" + isAdded() + " stateSaved=" + getParentFragmentManager().isStateSaved(), null, 8);
        FragmentManager r2 = getParentFragmentManager();
        if (r2.isStateSaved() == false) goto L9;
    L11:
        if (r1 == null) goto L14;
        r1.invoke();
        return;
    L14:
        return;
    L9:
        if (isAdded() == false) goto L11;
        r2.beginTransaction().remove(this).commitNowAllowingStateLoss();
        goto L11
    }

    public final ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        MmAINoteFragmentArgs r1 = ea0();
        MmRecordingAINoteRepo r2 = this.n;
        if (r2 == null) goto L7;
        return new MmAINoteViewModel.Factory(r1, r2);
    L7:
        throw new IllegalStateException("AINote repo missing".toString());
    }

    public final void ha0() {
        com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.b r0 = this.u;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewTreeObserver r1 = this.v;
        if (r1 == null) goto L10;
        boolean r3 = true;
        if (r1.isAlive() != true) goto L10;
    L12:
        if (r3 == false) goto L14;
        r1.removeOnGlobalFocusChangeListener(r0);
    L24:
        this.u = null;
        this.v = null;
        this.w = null;
        return;
    L14:
        View r2 = this.w;
        if (r2 == null) goto L24;
        ViewTreeObserver r4 = r2.getViewTreeObserver();
        if (r4 == null) goto L24;
        if (r4.isAlive() == true) goto L22;
        r4 = null;
    L22:
        if (r4 == null) goto L24;
        r4.removeOnGlobalFocusChangeListener(r0);
    L10:
        r3 = false;
        goto L12
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onDestroyView() {
        int r0 = bwb.b.a;
        MmUiLogScene r1 = MmUiLogScene.AI_NOTE;
        bwb.b.f(r1, "MmAINoteFragment#onDestroyView", "start ownerKey=" + ea0().getOwnerKey() + " fragment=" + ca0(this) + " binding=" + ca0(this.p) + " animator=" + ca0(this.q) + " mediaBridge=" + ca0(this.s), (String) this.o.getValue());
        qub.a r2 = this.t;
        if (r2 == null) goto L5;
        r2.hide();
    L5:
        this.t = null;
        ha0();
        fa0().detachHost();
        MmAINotePanelAnimator r3 = this.q;
        if (r3 == null) goto L8;
        r3.r("fragment_destroy_view");
    L8:
        this.q = null;
        this.p = null;
        this.s = null;
        this.l = null;
        this.k = null;
        this.m = null;
        super.onDestroyView();
        bwb.b.f(r1, "MmAINoteFragment#onDestroyView", "end ownerKey=" + ea0().getOwnerKey() + " fragment=" + ca0(this), (String) this.o.getValue());
    }

    public MmAINoteFragment() {
        this.o = LazyKt.lazy(new MmAINoteFragment$logDetail$2(this));
        this.x = LazyKt.lazy(new MmAINoteFragment$viewModel$2(this));
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MviBaseFragment
    public final /* bridge */ /* synthetic */ com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.a Z90() {
        return fa0();
    }

    public final MmAINoteFragmentArgs ea0() {
        Serializable r0 = requireArguments().getSerializable("arg_ainote_args");
        if ((r0 instanceof MmAINoteFragmentArgs) == false) goto L5;
        MmAINoteFragmentArgs r1 = (MmAINoteFragmentArgs) r0;
    L6:
        if (r1 == null) goto L9;
        return r1;
    L9:
        throw new IllegalStateException("AINote args missing".toString());
    L5:
        r1 = null;
        goto L6
    }

    public static String ca0(Object r2) {
        if (r2 == null) goto L5;
        String r3 = r2.getClass().getSimpleName() + '@' + System.identityHashCode(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return "null";
    }

    public final int da0(View r2, int r3) {
        Resources r4 = r2.getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density) + 0.5f);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onViewCreated(View r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r19, "view");
        super.onViewCreated(r19, r20);
        mwb.b r1 = this.p;
        if (r1 != null) goto L5;
        return;
    L5:
        int r3 = bwb.b.a;
        MmUiLogScene r8 = MmUiLogScene.AI_NOTE;
        StringBuilder r4 = new StringBuilder("start ownerKey=");
        r4.append(ea0().getOwnerKey());
        r4.append(" fragment=");
        r4.append(ca0(this));
        r4.append(" root=");
        r4.append(ca0(r19));
        r4.append(" editorContainer=");
        r4.append(ca0(r1.i));
        r4.append(" saved=");
        if (r20 == null) goto L8;
        boolean r2 = true;
    L9:
        r4.append(r2);
        bwb.b.f(r8, "MmAINoteFragment#onViewCreated", r4.toString(), (String) this.o.getValue());
        this.q = new MmAINotePanelAnimator(r1, new AnonymousClass1(this), new AnonymousClass2(this), new AnonymousClass3(this), new AnonymousClass4(this));
        this.s = new e(this, new b(this));
        fa0().attachHost(r1.i, new c(this));
        ha0();
        com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.b r5 = new com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.b(this, r1);
        this.u = r5;
        View r6 = r1.a;
        this.w = r6;
        ViewTreeObserver r7 = r6.getViewTreeObserver();
        r7.addOnGlobalFocusChangeListener(r5);
        this.v = r7;
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(r1.v, new MmAINoteFragment$bindClicks$1(this));
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(r1.B, new MmAINoteFragment$bindClicks$2(this));
        UDSwitch r9 = r1.F;
        Function1<Boolean, Unit> r10 = new MmAINoteFragment$bindClicks$3(this);
        if ((r9 instanceof UDSwitch) == false) goto L13;
        r9.setOnCheckedChangeListener(new com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.c(r10));
    L15:
        aa0(MmAINoteFragment$subscribeState$1.INSTANCE, new MmAINoteFragment$subscribeState$2(this, null));
        aa0(MmAINoteFragment$subscribeState$3.INSTANCE, new MmAINoteFragment$subscribeState$4(this, null));
        aa0(MmAINoteFragment$subscribeState$5.INSTANCE, new MmAINoteFragment$subscribeState$6(this, null));
        aa0(MmAINoteFragment$subscribeState$7.INSTANCE, new MmAINoteFragment$subscribeState$8(this, null));
        aa0(MmAINoteFragment$subscribeState$9.INSTANCE, new MmAINoteFragment$subscribeState$10(this, null));
        aa0(MmAINoteFragment$subscribeState$11.INSTANCE, new MmAINoteFragment$subscribeState$12(this, null));
        aa0(MmAINoteFragment$subscribeState$13.INSTANCE, new MmAINoteFragment$subscribeState$14(this, null));
        MmAINoteFragment$subscribeEvents$1 r11 = new MmAINoteFragment$subscribeEvents$1(this, null);
        Intrinsics.checkNotNullParameter(r11, "action");
        Z90().selectSubscribeVMEvent(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), r11);
        bwb.b.f(r8, "MmAINoteFragment#dispatchShow", "ownerKey=" + ea0().getOwnerKey() + " fragment=" + ca0(this) + " duration=" + ea0().getInitialDuration() + " meetingStartTime=" + ea0().getMeetingStartTime() + " expandImmediately=" + ea0().getExpandImmediately() + " isWavePlaying=" + ea0().isWavePlaying(), (String) this.o.getValue());
        fa0().dispatchEvent(new MmAINoteUIEvent.j(ea0().getInitialDuration(), ea0().getMeetingStartTime(), ea0().getExpandImmediately(), ea0().isWavePlaying()));
        StringBuilder r12 = new StringBuilder("ownerKey=");
        r12.append(ea0().getOwnerKey());
        r12.append(" duration=");
        r12.append(ea0().getInitialDuration());
        r12.append(" meetingStartTime=");
        r12.append(ea0().getMeetingStartTime());
        r12.append(" expandImmediately=");
        r12.append(ea0().getExpandImmediately());
        r12.append(" isWavePlaying=");
        r12.append(ea0().isWavePlaying());
        bwb.b.f(r8, "MmAINoteFragment#onViewCreated", r12.toString(), (String) this.o.getValue());
        return;
    L13:
        if ((r9 instanceof FlowSwitch) == false) goto L15;
        ((FlowSwitch) r9).setOnCheckedChangeListener(r10);
        goto L15
    L8:
        r2 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r22v0, types: [int] */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v10 */
    /* JADX WARN: Type inference failed for: r22v11 */
    /* JADX WARN: Type inference failed for: r22v12 */
    /* JADX WARN: Type inference failed for: r22v13 */
    /* JADX WARN: Type inference failed for: r22v14 */
    /* JADX WARN: Type inference failed for: r22v15 */
    /* JADX WARN: Type inference failed for: r22v16 */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r22v4 */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r22v6 */
    /* JADX WARN: Type inference failed for: r22v7 */
    /* JADX WARN: Type inference failed for: r22v8 */
    /* JADX WARN: Type inference failed for: r22v9 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.String] */
    public final void onActivityResult(int r21, int r22, Intent r23) {
        super.onActivityResult(r21, r22, r23);
        int r4 = bwb.b.a;
        MmUiLogScene r5 = MmUiLogScene.AI_NOTE;
        StringBuilder r6 = new StringBuilder("fragment=");
        r6.append(ca0(this));
        r6.append(" requestCode=");
        r6.append(r21);
        r6.append(" resultCode=");
        r6.append(r22);
        r6.append(" hasData=");
        if (r23 == null) goto L5;
        boolean r10 = true;
    L6:
        r6.append(r10);
        bwb.b.g(r5, "MmAINoteFragment#onActivityResult", r6.toString(), null, 8);
        e r11 = this.s;
        if (r11 == null) goto L178;
        long r13 = System.currentTimeMillis();
        StringBuilder r15 = new StringBuilder("start requestCode=");
        r15.append(r21);
        r15.append(" resultCode=");
        r15.append(r22);
        r15.append(" hasData=");
        if (r23 == null) goto L11;
        boolean r7 = true;
    L12:
        r15.append(r7);
        r15.append(" pendingUri=");
        r15.append(r11.c);
        r15.append(" fragment=");
        r15.append(e.e(r11.a));
        bwb.b.g(r5, "MmAINoteMediaBridge#handleActivityResult", r15.toString(), null, 8);
        com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.a r8 = e.g();
        if (r8 == null) goto L16;
        r8.F1();
    L16:
        if (r21 == 10001) goto L19;
        bwb.b.g(r5, "MmAINoteMediaBridge#handleActivityResult", "ignore non-camera request costMs=" + (System.currentTimeMillis() - r13), null, 8);
        return;
    L19:
        if (r22 == (-1)) goto L21;
        bwb.b.g(r5, "MmAINoteMediaBridge#handleActivityResult", "ignore camera result resultCode=" + r22 + " costMs=" + (System.currentTimeMillis() - r13), null, 8);
        r11.c = null;
        return;
    L21:
        Uri r1 = r11.c;
        r11.c = null;
        StringBuilder r0 = new StringBuilder("camera result ok, hasOutputUri=");
        if (r1 == null) goto L24;
        boolean r9 = true;
    L25:
        r0.append(r9);
        r0.append(", hasData=");
        if (r23 == null) goto L28;
        boolean r12 = true;
    L29:
        r0.append(r12);
        r0.append(", hasExtras=");
        if (r23 == null) goto L32;
        Bundle r14 = r23.getExtras();
    L33:
        if (r14 == null) goto L35;
        boolean r16 = true;
    L36:
        r0.append(r16);
        bwb.b.g(r5, "MmAINoteMediaBridge#handleActivityResult", r0.toString(), null, 8);
        if (r1 == null) goto L143;
        Context r17 = r11.a.getContext();
        if (r17 == null) goto L43;
        File r18 = r11.d();
        if (r18 == null) goto L43;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L79
        InputStream r20 = ContentResolverWrapper.openInputStream(r17.getContentResolver(), r1);     // Catch: Throwable -> L79
        if (r20 == null) goto L75;
        r22 = ", recycled=";
        PolarisFileOutputStreamWrapper r110 = new PolarisFileOutputStreamWrapper(r18);     // Catch: Throwable -> L67
        r19 = "data";
        String r111 = "MmAINoteMediaBridge#handleActivityResult";
        long r112 = r13;
        ByteStreamsKt.copyTo$default(r20, r110, 0, 2, null);     // Catch: Throwable -> L60
        CloseableKt.closeFinally(r110, null);     // Catch: Throwable -> L58
        CloseableKt.closeFinally(r20, null);     // Catch: Throwable -> L56
        if (r18.length() > 0) goto L54;
        r18.delete();     // Catch: Throwable -> L56
        ?? r24 = r22;
    L76:
        String r2 = null;
        ?? r25 = r24;
    L77:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L56
        ?? r26 = r25;
    L82:
        Throwable r27 = Result.exceptionOrNull-impl(r3);
        if (r27 == null) goto L86;
        int r28 = bwb.b.a;
        bwb.b.d(MmUiLogScene.AI_NOTE, "MmAINoteMediaBridge#copyCameraOutputUriToFile", "failed: " + r27.getMessage(), null);
    L86:
        if (Result.isFailure-impl(r3) == false) goto L88;
        r3 = null;
    L88:
        String r29 = (String) r3;
        ?? r210 = r26;
    L89:
        Context r30 = r11.a.getContext();
        if (r30 != null) goto L166;
    L99:
        if (r29 != null) goto L101;
    L104:
        boolean r31 = true;
    L105:
        if (r31 == true) goto L107;
        int r32 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, r111, "camera output ready, path=" + r29 + ", size=" + e.f(r29) + " costMs=" + (System.currentTimeMillis() - r112), null, 8);
        r11.b.a(r29);
        return;
    L107:
        String r33 = r111;
        if (r23 == null) goto L112;
        Bundle r34 = r23.getExtras();
        if (r34 == null) goto L112;
        Object r35 = r34.get(r19);
    L114:
        if ((r35 instanceof Bitmap) == false) goto L116;
        Bitmap r36 = (Bitmap) r35;
    L117:
        int r37 = bwb.b.a;
        MmUiLogScene r38 = MmUiLogScene.AI_NOTE;
        ?? r39 = new StringBuilder("camera output copy failed, fallbackBitmap=");
        if (r36 == null) goto L120;
        Integer r40 = Integer.valueOf(r36.getWidth());
    L121:
        r39.append(r40);
        r39.append('x');
        if (r36 == null) goto L124;
        Integer r41 = Integer.valueOf(r36.getHeight());
    L125:
        r39.append(r41);
        r39.append(r210);
        if (r36 == null) goto L128;
        Boolean r42 = Boolean.valueOf(r36.isRecycled());
    L129:
        r39.append(r42);
        bwb.b.g(r38, r33, r39.toString(), null, 8);
        if (r36 == null) goto L132;
        String r43 = r11.i(r36);
    L133:
        if (r43 != null) goto L135;
    L138:
        boolean r44 = true;
    L139:
        if (r44 == false) goto L141;
        bwb.b.d(r38, r33, "fallback bitmap save failed", null);
        r11.b.d();
        return;
    L141:
        bwb.b.g(r38, r33, "fallback bitmap ready, path=" + r43 + ", size=" + e.f(r43) + " costMs=" + (System.currentTimeMillis() - r112), null, 8);
        r11.b.a(r43);
        return;
    L135:
        if (StringsKt.isBlank(r43) == true) goto L138;
        r44 = false;
        goto L139
    L132:
        r43 = null;
        goto L133
    L128:
        r42 = null;
        goto L129
    L124:
        r41 = null;
        goto L125
    L120:
        r40 = null;
        goto L121
    L116:
        r36 = null;
    L112:
        r35 = null;
        goto L114
    L101:
        if (StringsKt.isBlank(r29) == true) goto L104;
        r31 = false;
        goto L105
    L166:
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L94
        int r46 = e.a(r30.getContentResolver(), r1);     // Catch: Throwable -> L94
        int r47 = bwb.b.a;     // Catch: Throwable -> L94
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINoteMediaBridge#deleteCameraOutputUri", "uri=" + r1 + ", deleted=" + r46, null, 8);     // Catch: Throwable -> L94
        Object r48 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L94
    L96:
        Throwable r49 = Result.exceptionOrNull-impl(r48);
        if (r49 == null) goto L99;
        int r50 = bwb.b.a;
        bwb.b.d(MmUiLogScene.AI_NOTE, "MmAINoteMediaBridge#deleteCameraOutputUri", "failed: " + r49.getMessage(), null);
    L94:
        th = move-exception;
        Result.Companion r51 = Result.Companion;
        r48 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L96
    L54:
        bwb.b.g(r5, "MmAINoteMediaBridge#copyCameraOutputUriToFile", "copied raw output, path=" + r18.getAbsolutePath() + ", size=" + r18.length(), null, 8);     // Catch: Throwable -> L56
        r2 = r18.getAbsolutePath();     // Catch: Throwable -> L56
        r25 = r22;
        goto L77
    L58:
        th = th;
    L69:
        Throwable r52 = th;
        throw r52;     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        CloseableKt.closeFinally(r20, r52);     // Catch: Throwable -> L56
        throw th;     // Catch: Throwable -> L56
    L60:
        th = move-exception;
        throw th;     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        CloseableKt.closeFinally(r110, th);     // Catch: Throwable -> L58
        throw th;     // Catch: Throwable -> L58
    L67:
        th = th;
        r111 = "MmAINoteMediaBridge#handleActivityResult";
        r19 = "data";
        r112 = r13;
        goto L69
    L75:
        r111 = "MmAINoteMediaBridge#handleActivityResult";
        r19 = "data";
        r112 = r13;
        r24 = ", recycled=";
    L56:
        th = th;
    L81:
        Result.Companion r53 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        r26 = r22;
    L79:
        th = th;
        r111 = "MmAINoteMediaBridge#handleActivityResult";
        r19 = "data";
        r112 = r13;
        r22 = ", recycled=";
    L43:
        r111 = "MmAINoteMediaBridge#handleActivityResult";
        r19 = "data";
        r112 = r13;
        r210 = ", recycled=";
        r29 = null;
        goto L89
    L143:
        if (r23 == null) goto L147;
        Bundle r54 = r23.getExtras();
        if (r54 == null) goto L147;
        Object r55 = r54.get("data");
    L149:
        if ((r55 instanceof Bitmap) == false) goto L151;
        Bitmap r113 = (Bitmap) r55;
    L152:
        if (r113 != null) goto L154;
        bwb.b.d(r5, "MmAINoteMediaBridge#handleActivityResult", "camera result bitmap is null", null);
        r11.b.d();
        return;
    L154:
        String r56 = r11.i(r113);
        if (r56 != null) goto L157;
    L160:
        boolean r57 = true;
    L161:
        if (r57 == false) goto L163;
        bwb.b.d(r5, "MmAINoteMediaBridge#handleActivityResult", "no-output-uri bitmap save failed, bitmap=" + r113.getWidth() + 'x' + r113.getHeight() + ", recycled=" + r113.isRecycled(), null);
        r11.b.d();
        return;
    L163:
        bwb.b.g(r5, "MmAINoteMediaBridge#handleActivityResult", "no-output-uri bitmap ready, path=" + r56 + ", size=" + e.f(r56) + ", bitmap=" + r113.getWidth() + 'x' + r113.getHeight() + " costMs=" + (System.currentTimeMillis() - r13), null, 8);
        r11.b.a(r56);
        return;
    L157:
        if (StringsKt.isBlank(r56) == true) goto L160;
        r57 = false;
        goto L161
    L151:
        r113 = null;
    L147:
        r55 = null;
        goto L149
    L35:
        r16 = false;
        goto L36
    L32:
        r14 = null;
        goto L33
    L28:
        r12 = false;
        goto L29
    L24:
        r9 = false;
        goto L25
    L11:
        r7 = false;
        goto L12
    L178:
        return;
    L5:
        r10 = false;
        goto L6
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        LayoutInflater r5 = LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(r2.getContext(), ea0().getUiLaunchMode()));
        com.ss.android.lark.officesdk.minutes.ui.style.e r6 = com.ss.android.lark.officesdk.minutes.ui.style.e.a;
        MmRecordingUILaunchMode r0 = ea0().getUiLaunchMode();
        r6.getClass();
        com.ss.android.lark.officesdk.minutes.ui.style.contract.f r7 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r0).getLayout();
        Intrinsics.checkNotNull(r5);
        mwb.b r8 = r7.B(r5, r3);
        this.p = r8;
        return r8.a;
    }

    public final void onRequestPermissionsResult(int r4, String[] r5, int[] r6) {
        Intrinsics.checkNotNullParameter(r5, "permissions");
        Intrinsics.checkNotNullParameter(r6, "grantResults");
        super.onRequestPermissionsResult(r4, r5, r6);
        e r2 = this.s;
        if (r2 == null) goto L27;
        Intrinsics.checkNotNullParameter(r5, "permissions");
        Intrinsics.checkNotNullParameter(r6, "grantResults");
        if (r4 == 10002) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(ArraysKt.firstOrNull(r5), "android.permission.CAMERA") == false) goto L15;
        Integer r7 = ArraysKt.firstOrNull(r6);
        if (r7 == null) goto L15;
        if (r7.intValue() != 0) goto L15;
        boolean r8 = true;
    L17:
        if (r8 == true) goto L19;
        int r9 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINoteMediaBridge#handleRequestPermissionsResult", "camera permission denied", null, 8);
        r2.b.d();
        return;
    L19:
        FragmentActivity r10 = r2.a.getActivity();
        if ((r10 instanceof FragmentActivity) == true) goto L23;
        r10 = null;
    L23:
        if (r10 != null) goto L25;
        int r11 = bwb.b.a;
        bwb.b.g(MmUiLogScene.AI_NOTE, "MmAINoteMediaBridge#handleRequestPermissionsResult", "activity is null after permission granted", null, 8);
        r2.b.d();
        return;
    L25:
        r2.h(r10);
        return;
    L15:
        r8 = false;
        goto L17
    }

    public final void ia0(View r5, View r6, TextView r7, boolean r8) {
        if (r8 == false) goto L4;
        int r0 = da0(r5, 78);
    L5:
        ViewGroup.LayoutParams r1 = r5.getLayoutParams();
        if ((r1 instanceof LinearLayout.LayoutParams) == false) goto L8;
        LinearLayout.LayoutParams r2 = (LinearLayout.LayoutParams) r1;
    L10:
        if (r2 != null) goto L12;
        r2 = new LinearLayout.LayoutParams(r0, da0(r5, 44));
    L12:
        r2.width = r0;
        r2.height = da0(r5, 44);
        r5.setLayoutParams(r2);
        int r3 = 20;
        int r4 = 0;
        if (r8 == false) goto L15;
        int r9 = 0;
    L16:
        r5.setPadding(r9, 0, r9, 0);
        if (r8 == true) goto L20;
        r3 = 16;
    L20:
        int r10 = da0(r6, r3);
        ViewGroup.LayoutParams r11 = r6.getLayoutParams();
        if (r11 != null) goto L23;
        r11 = new ViewGroup.LayoutParams(r10, r10);
    L23:
        r11.width = r10;
        r11.height = r10;
        r6.setLayoutParams(r11);
        if (r8 == false) goto L26;
        r4 = 8;
    L26:
        r7.setVisibility(r4);
        return;
    L15:
        r9 = da0(r5, 20);
        goto L16
    L8:
        r2 = null;
        goto L10
    L4:
        r0 = -2;
        goto L5
    }
}
