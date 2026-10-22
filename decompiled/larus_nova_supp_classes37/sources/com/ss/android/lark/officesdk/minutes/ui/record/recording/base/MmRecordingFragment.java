package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmBubbleDirection;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.ToastType;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.CloseReason;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.MmRecordingEntity;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.HideKeyboardLinearLayout;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.IMmRecordingScope;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.content.MmRecordingContentController;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingAINoteToolBarView;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model.MmRecordingFloatDismissReason;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import iub.k;
import java.io.Serializable;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000Â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 µ\u00012\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0002µ\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010e\u001a\u00020\u00002\u0006\u0010f\u001a\u00020(J\u000e\u0010g\u001a\u00020\u00002\u0006\u0010h\u001a\u00020*J\u0018\u0010i\u001a\u00020\u00002\u0006\u0010j\u001a\u00020k2\b\u0010l\u001a\u0004\u0018\u00010mJ\u000e\u0010n\u001a\u00020\u00002\u0006\u0010j\u001a\u00020kJ\"\u0010o\u001a\u00020\u00002\u0006\u0010j\u001a\u00020k2\b\u0010l\u001a\u0004\u0018\u00010m2\u0006\u0010p\u001a\u00020\rH\u0002J\u000e\u0010q\u001a\u00020\r*\u0004\u0018\u00010mH\u0002J\u0012\u0010r\u001a\u00020s2\b\u0010t\u001a\u0004\u0018\u00010uH\u0016J$\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020y2\b\u0010z\u001a\u0004\u0018\u00010{2\b\u0010t\u001a\u0004\u0018\u00010uH\u0016J\u001a\u0010|\u001a\u00020s2\u0006\u0010}\u001a\u00020w2\b\u0010t\u001a\u0004\u0018\u00010uH\u0016J\b\u0010~\u001a\u00020sH\u0016J\b\u0010\u007f\u001a\u00020sH\u0016J\t\u0010\u0080\u0001\u001a\u00020sH\u0016J\t\u0010\u0081\u0001\u001a\u00020sH\u0016J\u0013\u0010\u0082\u0001\u001a\u00020\"2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0002J\u0013\u0010\u0085\u0001\u001a\u00020s2\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0016J\u0012\u0010\u0088\u0001\u001a\u00020s2\u0007\u0010\u0089\u0001\u001a\u00020\"H\u0014J\t\u0010\u008a\u0001\u001a\u00020sH\u0002J\t\u0010\u008b\u0001\u001a\u00020*H\u0002J\n\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0002J\n\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0002J\n\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0002J\t\u0010\u0092\u0001\u001a\u00020sH\u0002J\t\u0010\u0093\u0001\u001a\u00020\"H\u0002J\u0011\u0010\u0094\u0001\u001a\u00020s2\u0006\u00104\u001a\u000205H\u0002J\t\u0010\u0095\u0001\u001a\u00020sH\u0002J-\u0010\u0096\u0001\u001a\u00020s2\u0007\u0010\u0097\u0001\u001a\u00020*2\u0007\u0010\u0098\u0001\u001a\u00020*2\u0007\u0010\u0099\u0001\u001a\u00020*2\u0007\u0010\u009a\u0001\u001a\u00020*H\u0014J\t\u0010\u009b\u0001\u001a\u00020sH\u0002J\t\u0010\u009c\u0001\u001a\u00020\"H\u0002J\f\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0002J\t\u0010\u009f\u0001\u001a\u00020sH\u0016J\t\u0010 \u0001\u001a\u00020sH\u0016JA\u0010¡\u0001\u001a\u00020s2\b\u0010¢\u0001\u001a\u00030£\u00012&\u0010¤\u0001\u001a!\b\u0001\u0012\u0004\u0012\u00020\"\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020s0¦\u0001\u0012\u0007\u0012\u0005\u0018\u00010§\u00010¥\u0001H\u0016¢\u0006\u0003\u0010¨\u0001J\t\u0010©\u0001\u001a\u00020sH\u0002J\t\u0010ª\u0001\u001a\u00020sH\u0002J\t\u0010«\u0001\u001a\u00020sH\u0016J\t\u0010¬\u0001\u001a\u00020sH\u0016J\t\u0010\u00ad\u0001\u001a\u00020sH\u0016J\n\u0010®\u0001\u001a\u00030¯\u0001H\u0016J\t\u0010°\u0001\u001a\u00020sH\u0002J\u0013\u0010«\u0001\u001a\u00020s2\b\u0010±\u0001\u001a\u00030²\u0001H\u0002J\t\u0010³\u0001\u001a\u00020sH\u0002J\t\u0010´\u0001\u001a\u00020sH\u0002R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0011\u001a\u0004\b/\u00100R\u001b\u00102\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0011\u001a\u0004\b2\u00100R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u00106\u001a\u0004\u0018\u0001078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0011\u001a\u0004\b8\u00109R\u001d\u0010;\u001a\u0004\u0018\u00010<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u0011\u001a\u0004\b=\u0010>R\u0016\u0010@\u001a\u0004\u0018\u00010A8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u001b\u0010D\u001a\u00020\u00058TX\u0094\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u0011\u001a\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020I8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u001b\u0010L\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0011\u001a\u0004\bN\u0010OR\u001b\u0010Q\u001a\u00020R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u0011\u001a\u0004\bS\u0010TR\u001b\u0010V\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\u0011\u001a\u0004\bX\u0010YR\u001b\u0010[\u001a\u00020\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010\u0011\u001a\u0004\b]\u0010^R\u001b\u0010`\u001a\u00020a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010\u0011\u001a\u0004\bb\u0010c¨\u0006¶\u0001"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingFragment;", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/mvi/MviBaseFragment;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingVMState;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingVMEvent;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingUIEvent;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/IMmRecordingScope;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/scope/IMmRecordingPageController;", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/scope/IMmRecordingStateProvider;", "<init>", "()V", "logDetail", "", "getLogDetail", "()Ljava/lang/String;", "logDetail$delegate", "Lkotlin/Lazy;", "mmUccApi", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "getMmUccApi", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "setMmUccApi", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;)V", "_recordingView", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmRecordingFragmentView;", "recordingView", "getRecordingView", "()Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmRecordingFragmentView;", "contentController", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/content/MmRecordingContentController;", "slotsController", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/controller/MmRecordingSlotsController;", "isDefaultMiddleBound", "", "isRecordingNotificationBound", "hasResumedOnce", "recordingEntity", "Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/route/MmRecordingEntity;", "recordingSlotsConfig", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/model/MmRecordingSlotsConfig;", "toolbarSlotBottomPaddingPx", "", "Ljava/lang/Integer;", "aiNoteToolbarView", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/toolbar/MmRecordingAINoteToolBarView;", "isInvalidRestore", "isPersonalAINoteEnable", "()Z", "isPersonalAINoteEnable$delegate", "isAiNotesDisabled", "isAiNotesDisabled$delegate", "uiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "navRectProvider", "Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/IMmNavRectProvider;", "getNavRectProvider", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/IMmNavRectProvider;", "navRectProvider$delegate", "appletNavigator", "Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/IMmAppletNavigator;", "getAppletNavigator", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/IMmAppletNavigator;", "appletNavigator$delegate", "metaRepo", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/meta/MmRecordingMetaRepo;", "getMetaRepo", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/meta/MmRecordingMetaRepo;", "viewModel", "getViewModel", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingViewModel;", "viewModel$delegate", "defaultViewModelProviderFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getDefaultViewModelProviderFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "recordingSlotScope", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/scope/MmRecordingSlotScope;", "getRecordingSlotScope", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/scope/MmRecordingSlotScope;", "recordingSlotScope$delegate", "recordingSlotUiController", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/scope/MmRecordingSlotHostUiController;", "getRecordingSlotUiController", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/scope/MmRecordingSlotHostUiController;", "recordingSlotUiController$delegate", "floatWindowController", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/controller/RecordingFloatWindowController;", "getFloatWindowController", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/controller/RecordingFloatWindowController;", "floatWindowController$delegate", "windowInsetsController", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/controller/RecordingWindowInsetsController;", "getWindowInsetsController", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/controller/RecordingWindowInsetsController;", "windowInsetsController$delegate", "darkModeController", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/controller/RecordingDarkModeController;", "getDarkModeController", "()Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/controller/RecordingDarkModeController;", "darkModeController$delegate", "setRecordingSlots", "config", "setToolbarSlotBottomPaddingPx", "bottomPaddingPx", "setRecordingSlotOverride", "key", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/model/MmRecordingSlotKey;", "slot", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/slot/model/MmRecordingSlot;", "clearRecordingSlotOverride", "applyRecordingSlotOverride", "logAction", "slotLogName", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "onResume", "onPause", "onStop", "goToSubtitle", "request", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/ainote/MmRecordingAINoteSubtitleNavigationRequest;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDarkModeChanged", "isDarkMode", "initViews", "resolveToolbarSlotBottomPaddingPx", "createDefaultTopSlotView", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/toolbar/MmRecordingTopBarView;", "createDefaultTitleSlotView", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/toolbar/MmRecordingTitleNameView;", "createDefaultMiddleSlotView", "Lcom/ss/android/lark/officesdk/minutes/ui/style/viewcontract/recording/MmRecordingDefaultMiddleView;", "bindDefaultMiddleIfNeeded", "isDefaultMiddleAttached", "bindRecordingNotification", "setupNavLayoutListener", "onWindowInsetsChanged", "left", "top", "right", "bottom", "bindBottomBarView", "hasTopSlotOverride", "currentRecordingCapacity", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/IMmRecordingCapacity;", "openLanguageSetting", "openAIInterpretationSetting", "observeAIInterpretationEntry", "scope", "Lkotlinx/coroutines/CoroutineScope;", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;)V", "showAIInterpretationSwitchTipBubble", "showAutoTranslationTipBubble", "closePage", "onDestroy", "onDestroyView", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "setupBackPressedHandler", "reason", "Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/CloseReason;", "registerMapContainer", "unregisterMapContainer", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmRecordingFragment extends Hilt_MmRecordingFragment<i, h, g, MmRecordingViewModel> implements IMmRecordingScope, d0c.c, com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope.a {
    public static final /* synthetic */ int J = 0;
    public MmRecordingUILaunchMode A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;
    public final Lazy m;

    @Inject
    public com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a n;
    public mwb.e o;
    public MmRecordingContentController p;
    public com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.controller.a q;
    public boolean r;
    public boolean s;
    public boolean t;
    public MmRecordingEntity u;
    public dwb.b v;
    public MmRecordingAINoteToolBarView w;
    public boolean x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
        public static MmRecordingFragment a(MmRecordingEntity r4, UserSession r5) {
            Intrinsics.checkNotNullParameter(r4, "entity");
            MmRecordingFragment r0 = new MmRecordingFragment();
            Bundle r1 = new Bundle();
            r1.putSerializable("arg_mm_recording_entity", r4);
            Application r6 = LarkContext.getApplication();
            if (r6 == null) goto L7;
            if (r5 == null) goto L6;
            PassportcConvention.h(r1, r5);
        L8:
            r0.setArguments(r1);
            return r0;
        L6:
            PassportcConvention.f(r1, r6);
            goto L8
        L7:
            int r7 = bwb.b.a;
            bwb.b.d(MmUiLogScene.RECORDING, "newInstance", "Application not initialized", null);
            goto L8
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RecordingSessionType.values().length];
            r0[RecordingSessionType.STANDALONE_AI_INTERPRETATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ MmRecordingFragment a;
        public final /* synthetic */ String b;

        public c(MmRecordingFragment r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MmRecordingSession r0 = this.a.ja0().getSession();     // Catch: Throwable -> L13
            if (r0 == null) goto L16;
            com.ss.android.lark.officesdk.minutes.service.recording.common.core.b r1 = r0.q;     // Catch: Throwable -> L13
            if (r1 == null) goto L20;
            String r2 = this.b;     // Catch: Throwable -> L13
            Intrinsics.checkNotNullParameter(r2, "recordingId");     // Catch: Throwable -> L13
            if (StringsKt.isBlank(r2) == false) goto L9;
            return;
        L9:
            if (r1.c == true) goto L22;
            r1.c = true;     // Catch: Throwable -> L13
            r1.a.tryEmit(new iub.l.b(r2));     // Catch: Throwable -> L13
            return;
        L22:
            return;
        L20:
            return;
        L16:
            return;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L23;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingVMEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingFragment$onViewCreated$1", f = "MmRecordingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<h, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MmRecordingFragment this$0;

        public AnonymousClass1(MmRecordingFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(h r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((h) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r30) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L115;
            ResultKt.throwOnFailure(r30);
            final h r1 = (h) this.L$0;
            int r2 = bwb.b.a;
            MmRecordingFragment r4 = this.this$0;
            int r5 = MmRecordingFragment.J;
            bwb.b.f(MmUiLogScene.RECORDING, "subscribeVMEvent", "event=" + r1, r4.U90());
            Integer r6 = null;
            if ((r1 instanceof h.g) == false) goto L17;
            qub.h r3 = (qub.h) this.this$0.ja0().getUiProviders().c.getValue();
            svb.a r7 = ((h.g) r1).a;
            if ((r7 instanceof svb.a.c) == false) goto L10;
            MmRecordingUILaunchMode r8 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.a;
            ((svb.a.c) r7).getClass();
            Intrinsics.checkNotNullParameter(null, "toastMsg");
            com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.b(r3, new rub.e(null, ToastType.WARNING, null, 26));
        L111:
            return Unit.INSTANCE;
        L10:
            if ((r7 instanceof svb.a.C0191a) == false) goto L13;
            MmRecordingUILaunchMode r9 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.a;
            String r10 = ((svb.a.C0191a) r7).a;
            Intrinsics.checkNotNullParameter(r10, "toastMsg");
            com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.b(r3, new rub.e(r10, ToastType.ERROR, null, 26));
            goto L111
        L13:
            if ((r7 instanceof svb.a.b) == false) goto L16;
            MmRecordingUILaunchMode r11 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.a;
            String r12 = ((svb.a.b) r7).a;
            Intrinsics.checkNotNullParameter(r12, "toastMsg");
            com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.b(r3, new rub.e(r12, ToastType.NORMAL, null, 26));
            goto L111
        L16:
            throw new NoWhenBranchMatchedException();
        L17:
            boolean r13 = true;
            if ((r1 instanceof h.d) == false) goto L49;
            int r14 = cwb.b.a;
            Context r15 = this.this$0.getContext();
            qub.c r16 = (qub.c) this.this$0.ja0().getUiProviders().d.getValue();
            final MmRecordingFragment r17 = this.this$0;
            MmRecordingUILaunchMode r18 = r17.A;
            com.ss.android.lark.officesdk.minutes.ui.record.recording.base.b r19 = ((h.d) r1).a;
            Function0<Unit> r110 = new C00591(r17, r1);
            Intrinsics.checkNotNullParameter(r16, "dialogProvider");
            Intrinsics.checkNotNullParameter(r18, "uiLaunchMode");
            if (r19 != null) goto L22;
            r110.invoke();
            goto L111
        L22:
            if (r15 != null) goto L24;
            bwb.b.d(MmUiLogScene.OVERLAY, "showAutoSaveDialog", "context is null", null);
            r110.invoke();
            goto L111
        L24:
            int r20 = cwb.b.a.b[r19.a.ordinal()];
            if (r20 == 1) goto L38;
            if (r20 != 2) goto L37;
            int r21 = cwb.b.a.a[r19.b.ordinal()];
            if (r21 == 1) goto L35;
            if (r21 == 2) goto L34;
            if (r21 != 3) goto L33;
            int r22 = 2131894028;
        L47:
            r16.u0(r15, new rub.b(null, null, r15.getString(r22), r15.getString(2131892890), null, false, r110, r18, 28531));
            goto L111
        L33:
            throw new NoWhenBranchMatchedException();
        L34:
            r22 = 2131894027;
            goto L47
        L35:
            r22 = 2131894029;
            goto L47
        L37:
            throw new NoWhenBranchMatchedException();
        L38:
            int r23 = cwb.b.a.a[r19.b.ordinal()];
            if (r23 == 1) goto L46;
            if (r23 == 2) goto L45;
            if (r23 != 3) goto L44;
            r22 = 2131894034;
            goto L47
        L44:
            throw new NoWhenBranchMatchedException();
        L45:
            r22 = 2131894033;
            goto L47
        L46:
            r22 = 2131894035;
            goto L47
        L49:
            if ((r1 instanceof h.b) == false) goto L58;
            int r24 = cwb.b.a;
            Context r25 = this.this$0.getContext();
            qub.c r26 = (qub.c) this.this$0.ja0().getUiProviders().d.getValue();
            final MmRecordingFragment r27 = this.this$0;
            MmRecordingUILaunchMode r111 = r27.A;
            String r112 = ((h.b) r1).a;
            Function0<Unit> r28 = new AnonymousClass2(r27);
            Intrinsics.checkNotNullParameter(r26, "dialogProvider");
            Intrinsics.checkNotNullParameter(r111, "uiLaunchMode");
            Intrinsics.checkNotNullParameter(r112, "content");
            if (r25 != null) goto L54;
            bwb.b.d(MmUiLogScene.OVERLAY, "showAIInterpretationHeadsetDialog", "context is null", null);
            goto L111
        L54:
            if (r111 != MmRecordingUILaunchMode.WITH_DOUBAO_UI) goto L56;
            r6 = Integer.valueOf(ContextCompat.getColor(r25, 2131102040));
        L56:
            r26.u0(r25, new rub.b("ai_interpretation_headset_dialog", r112, null, r25.getString(2131892890), r6, true, r28, r111, 28500));
            goto L111
        L58:
            if ((r1 instanceof h.f) == false) goto L68;
            MmRecordingFragment r29 = this.this$0;
            MmRecordingAINoteToolBarView r31 = r29.w;
            if (r31 != null) goto L62;
        L64:
            r13 = false;
        L65:
            if (r13 == true) goto L111;
            MmRecordingUILaunchMode r32 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.a;
            qub.h r33 = (qub.h) this.this$0.ja0().getUiProviders().c.getValue();
            String r34 = this.this$0.getString(2131893999);
            Intrinsics.checkNotNullParameter(r34, "toastMsg");
            com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.b(r33, new rub.e(r34, ToastType.NORMAL, null, 26));
            goto L111
        L62:
            if (r31.b6(((h.f) r1).a, r29.ja0()) != true) goto L64;
        L68:
            if ((r1 instanceof h.i) == false) goto L76;
            Context r35 = this.this$0.getContext();
            if (r35 == null) goto L111;
            int r36 = wvb.d.b;
            Intrinsics.checkNotNullParameter(r35, "context");
            long r37 = System.currentTimeMillis();
            if ((r37 - wvb.d.a) >= 250) goto L74;
            bwb.b.b(MmUiLogScene.FOUNDATION, "vibrateLight", "skip duplicated light vibrate", null, 8);
            goto L111
        L74:
            wvb.d.a = r37;
            wvb.d.b(r35, 30);
            goto L111
        L76:
            if (Intrinsics.areEqual(r1, h.c.a) == false) goto L89;
            MmRecordingFragment r38 = this.this$0;
            Context r113 = r38.getContext();
            if (r113 == null) goto L111;
            View r39 = ((com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.d) r38.H.getValue()).b();
            View r40 = r39.findViewById(2131375895);
            if (r40 != null) goto L83;
            View r114 = r39;
        L85:
            if (r114.getVisibility() == 0) goto L87;
            bwb.b.f(MmUiLogScene.OVERLAY, "showAIInterpretationSwitchTipBubble", "skip, anchor not visible", r38.U90());
            goto L111
        L87:
            int r41 = com.ss.android.lark.officesdk.minutes.ui.record.bubble.c.a;
            com.ss.android.lark.officesdk.minutes.ui.record.bubble.c.b(r113, r114, r113.getString(2131893524), MmBubbleDirection.TOP, true, true, 6000, false, Integer.valueOf(UIUtils.dp2px(r113, 300.0f)), 1, new Point(0, -UIUtils.dp2px(r113, 10.0f)), null, null, r38.A, null, null, 110856);
            goto L111
        L83:
            r114 = r40;
            goto L85
        L89:
            if (Intrinsics.areEqual(r1, h.e.a) == false) goto L104;
            MmRecordingFragment r42 = this.this$0;
            if (r42.getViewLifecycleOwner().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == true) goto L93;
            bwb.b.f(MmUiLogScene.OVERLAY, "showAutoTranslationTipBubble", "skip, page is not resumed", r42.U90());
            goto L111
        L93:
            Context r43 = r42.getContext();
            if (r43 == null) goto L111;
            View r44 = ((com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.d) r42.H.getValue()).b().findViewById(2131375918);
            if (r44 != null) goto L99;
        L102:
            bwb.b.f(MmUiLogScene.OVERLAY, "showAutoTranslationTipBubble", "skip, language anchor not visible", r42.U90());
            goto L111
        L99:
            if (r44.getVisibility() != 0) goto L102;
            int r45 = com.ss.android.lark.officesdk.minutes.ui.record.bubble.c.a;
            com.ss.android.lark.officesdk.minutes.ui.record.bubble.c.b(r43, r44, r43.getString(2131894014), MmBubbleDirection.TOP, true, true, 3000, false, null, null, null, null, null, r42.A, null, null, 114440);
            goto L111
        L104:
            if ((r1 instanceof h.a) == false) goto L109;
            if (this.this$0.fa0() != null) goto L111;
            com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host.d r46 = com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.a.a;
            String r47 = ((h.a) r1).a;
            Intrinsics.checkNotNullParameter(r47, "recordingId");
            com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.a.c(r47, MmRecordingFloatDismissReason.RECORDING_END);
            wvb.a.a(this.this$0.fa0(), this.this$0.getActivity(), CloseReason.RECORDING_END);
            goto L111
        L109:
            if ((r1 instanceof h.C0063h) == true) goto L111;
            throw new NoWhenBranchMatchedException();
        L115:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // d0c.c
    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public final String U90() {
        return (String) this.m.getValue();
    }

    public final uub.a fa0() {
        return (uub.a) this.C.getValue();
    }

    public final com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.c ga0() {
        return (com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.c) this.G.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.base.Hilt_MmRecordingFragment
    public final ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return new MmRecordingViewModel.Factory(ha0());
    }

    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a ha0() {
        com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r0 = this.n;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mmUccApi");
        return null;
    }

    public final mwb.e ia0() {
        mwb.e r0 = this.o;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Recording view is not created".toString());
    }

    public final MmRecordingViewModel ja0() {
        return (MmRecordingViewModel) this.D.getValue();
    }

    public final void onDestroy() {
        if (this.x == false) goto L6;
        super.onDestroy();
        return;
    L6:
        ja0().trackPageBackgroundRunEnd();
        super.onDestroy();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onDestroyView() {
        if (this.x == false) goto L6;
        super.onDestroyView();
        return;
    L6:
        com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.c r0 = ga0();
        MmRecordingViewModel r1 = (MmRecordingViewModel) r0.a.invoke();
        if (r1.isRecordingActiveForFloat() == false) goto L9;
        int r2 = bwb.b.a;
        bwb.b.f(MmUiLogScene.FLOAT, "dismissFloatWindowIfSessionInactive", "skip, recording active", (String) r0.f.invoke());
    L16:
        ja0().getUiProviders().a(getContext(), getChildFragmentManager());
        super.onDestroyView();
        T90();
        MmRecordingContentController r3 = this.p;
        if (r3 == null) goto L22;
        Runnable r4 = r3.o;
        if (r4 == null) goto L21;
        r3.a.b().removeCallbacks(r4);
    L21:
        r3.o = null;
    L22:
        this.p = null;
        this.q = null;
        this.r = false;
        this.s = false;
        this.o = null;
        this.w = null;
        ja0().clearNotificationManager();
        return;
    L9:
        MmRecordingSession r5 = r1.getSession();
        if (r5 == null) goto L12;
        String r6 = r5.e();
    L13:
        if (r6 != null) goto L15;
        int r7 = bwb.b.a;
        bwb.b.f(MmUiLogScene.FLOAT, "dismissFloatWindowIfSessionInactive", "skip, recordingId is null", (String) r0.f.invoke());
        goto L16
    L15:
        int r8 = bwb.b.a;
        bwb.b.f(MmUiLogScene.FLOAT, "dismissFloatWindowIfSessionInactive", "dismiss, recordingId=".concat(r6), (String) r0.f.invoke());
        com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.host.d r9 = com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.a.a;
        com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.a.c(r6, MmRecordingFloatDismissReason.SESSION_INACTIVE);
        goto L16
    L12:
        r6 = null;
        goto L13
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onStop() {
        if (this.x == false) goto L6;
        super.onStop();
        return;
    L6:
        ja0().trackPageBackgroundRunStart();
        mwb.e r0 = this.o;
        if (r0 == null) goto L11;
        ViewGroup r1 = r0.b;
        if (r1 == null) goto L11;
        ja0().dispatchEvent(new g.u(r1));
    L11:
        com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.c r2 = ga0();
        r2.getClass();
        FragmentActivity r3 = (FragmentActivity) r2.c.invoke();
        boolean r4 = true;
        if (r3 == null) goto L20;
        Intent r5 = r3.getIntent();
        if (r5 == null) goto L20;
        if (r5.getBooleanExtra("minutes_skip_vc_fast_entry_on_next_stop", false) == false) goto L20;
        r5.removeExtra("minutes_skip_vc_fast_entry_on_next_stop");
        boolean r6 = true;
    L21:
        if (r6 == false) goto L23;
        int r7 = bwb.b.a;
        bwb.b.f(MmUiLogScene.FLOAT, "handleRecordingPageInvisibleForFloat", "skip once for ai note camera", (String) r2.f.invoke());
    L41:
        super.onStop();
        return;
    L23:
        if (r3 != null) goto L25;
    L27:
        boolean r8 = false;
    L28:
        if (r8 == true) goto L40;
        if (r3 != null) goto L31;
    L33:
        r4 = false;
    L34:
        if (r4 == true) goto L40;
        MmRecordingViewModel r9 = (MmRecordingViewModel) r2.a.invoke();
        MmRecordingSession r10 = r9.getSession();
        if (r10 != null) goto L39;
        int r11 = bwb.b.a;
        bwb.b.f(MmUiLogScene.FLOAT, "handleRecordingPageInvisibleForFloat", "skip, session is null", (String) r2.f.invoke());
        goto L41
    L39:
        r2.b();
        boolean r12 = r9.isRecordingActiveForFloat();
        int r13 = bwb.b.a;
        bwb.b.f(MmUiLogScene.FLOAT, "handleRecordingPageInvisibleForFloat", "skip, support=false, active=" + r12 + ", recordingId=" + r10.e(), (String) r2.f.invoke());
        goto L41
    L31:
        if (r3.isChangingConfigurations() != true) goto L33;
    L40:
        int r14 = bwb.b.a;
        bwb.b.f(MmUiLogScene.FLOAT, "handleRecordingPageInvisibleForFloat", "skip, finishing=" + r3.isFinishing() + ", changingConfig=" + r3.isChangingConfigurations(), (String) r2.f.invoke());
        goto L41
    L25:
        if (r3.isFinishing() != true) goto L27;
        r8 = true;
    L20:
        r6 = false;
        goto L21
    }

    public MmRecordingFragment() {
        this.m = LazyKt.lazy(new MmRecordingFragment$logDetail$2(this));
        this.v = new dwb.b(null, null, null, null, 63);
        this.y = LazyKt.lazy(new MmRecordingFragment$isPersonalAINoteEnable$2(this));
        this.z = LazyKt.lazy(new MmRecordingFragment$isAiNotesDisabled$2(this));
        this.A = MmRecordingUILaunchMode.UNKNOWN;
        this.B = LazyKt.lazy(new MmRecordingFragment$navRectProvider$2(this));
        this.C = LazyKt.lazy(new MmRecordingFragment$appletNavigator$2(this));
        this.D = LazyKt.lazy(new MmRecordingFragment$viewModel$2(this));
        this.E = LazyKt.lazy(new MmRecordingFragment$recordingSlotScope$2(this));
        this.F = LazyKt.lazy(new MmRecordingFragment$recordingSlotUiController$2(this));
        this.G = LazyKt.lazy(new MmRecordingFragment$floatWindowController$2(this));
        this.H = LazyKt.lazy(new MmRecordingFragment$windowInsetsController$2(this));
        this.I = LazyKt.lazy(new MmRecordingFragment$darkModeController$2(this));
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MviBaseFragment
    public final /* bridge */ /* synthetic */ com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.a Z90() {
        return ja0();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope.a
    public final void closePage() {
        com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.c r0 = ga0();
        int r1 = com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.c.g;
        r0.a(true, null);
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    public final boolean ka0() {
        mwb.d r0 = ia0().i;
        if (r0 == null) goto L7;
        HideKeyboardLinearLayout r1 = r0.a;
        if (r1 == null) goto L7;
        ViewParent r2 = r1.getParent();
    L9:
        if (r2 != ia0().f) goto L11;
        return true;
    L11:
        return false;
    L7:
        r2 = null;
        goto L9
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onResume() {
        super.onResume();
        if (this.x == false) goto L5;
        return;
    L5:
        com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.c r0 = ga0();
        r0.b();
        int r1 = bwb.b.a;
        bwb.b.f(MmUiLogScene.FLOAT, "dismissFloatWindowIfSupported", "skip, support=false", (String) r0.f.invoke());
        boolean r2 = true;
        if (this.t == false) goto L11;
        com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.b r3 = (com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.b) this.I.getValue();
        if (((Boolean) r3.c.invoke()).booleanValue() == false) goto L12;
        r3.d.invoke(Boolean.TRUE);
    L12:
        MmRecordingSession r4 = ja0().getSession();
        if (r4 == null) goto L15;
        String r5 = r4.e();
    L16:
        if (r5 != null) goto L18;
    L21:
        if (r2 == false) goto L24;
        bwb.b.h(MmUiLogScene.RECORDING, "onResume", "skip notifyPageShown: recordingId is null", U90());
        return;
    L24:
        View r6 = getView();
        if (r6 == null) goto L27;
        r6.post(new c(this, r5));
    L27:
        ja0().refreshQuotaAfterUpgradeReturnIfNeeded("recordingPageResume");
        ja0().dispatchEvent(g.l.a);
        return;
    L18:
        if (r5.length() == 0) goto L21;
        r2 = false;
        goto L21
    L15:
        r5 = null;
        goto L16
    L11:
        this.t = true;
        goto L12
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onStart() {
        super.onStart();
        if (this.x == false) goto L5;
        return;
    L5:
        ja0().trackPageBackgroundRunStop();
        mwb.e r0 = this.o;
        if (r0 == null) goto L11;
        ViewGroup r1 = r0.b;
        if (r1 == null) goto L12;
        ja0().dispatchEvent(new g.k(r1));
        return;
    L12:
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m440provideComponent() {
        return provideComponent();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onPause() {
        super.onPause();
    }

    public static final boolean da0(MmRecordingFragment r1) {
        com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.controller.a r0 = r1.q;
        if (r0 == null) goto L8;
        if (r0.k.a != null) goto L9;
    L10:
        return false;
    L9:
        return true;
    L8:
        if (r1.v.a == null) goto L10;
        goto L9
    }

    public static String ma0(dwb.a r1) {
        if (r1 != null) goto L5;
        return "Default";
    L5:
        if ((r1 instanceof dwb.a.C0134a) == false) goto L8;
        return "FragmentSlot";
    L8:
        if ((r1 instanceof dwb.a.b) == false) goto L12;
        return "ViewSlot";
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void X90(boolean r8) {
        if (this.x == false) goto L5;
        return;
    L5:
        com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.b r9 = (com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.b) this.I.getValue();
        if (r9.a.isAdded() == true) goto L9;
        int r0 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "recreateSelf", "fragment not added, skip", (String) r9.h.invoke());
        return;
    L9:
        if (r9.a.getParentFragmentManager().isStateSaved() == false) goto L11;
        int r1 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "recreateSelf", "state already saved, skip", (String) r9.h.invoke());
        return;
    L11:
        MmRecordingSession r2 = ((MmRecordingViewModel) r9.b.invoke()).getSession();
        if (r2 == null) goto L14;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r3 = r2.g();
    L15:
        if (r3 == null) goto L19;
        boolean r4 = true;
        if (r3.a() != true) goto L19;
    L20:
        if (r4 == true) goto L22;
        int r5 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "recreateSelf", "skip recreate: recording is not active (state=" + r3 + ')', (String) r9.h.invoke());
        return;
    L22:
        MmRecordingEntity r6 = (MmRecordingEntity) r9.e.invoke();
        if (r6 != null) goto L25;
        int r7 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "recreateSelf", "entity is null, skip", (String) r9.h.invoke());
        return;
    L25:
        View r10 = r9.a.getView();
        if (r10 == null) goto L28;
        ViewParent r11 = r10.getParent();
    L30:
        if ((r11 instanceof ViewGroup) == false) goto L32;
        ViewGroup r12 = (ViewGroup) r11;
    L33:
        if (r12 == null) goto L43;
        int r13 = r12.getId();
        Iterator r14 = r9.a.getChildFragmentManager().getFragments().iterator();
    L36:
        if (r14.hasNext() == false) goto L38;
        r9.a.getChildFragmentManager().beginTransaction().remove((Fragment) r14.next()).commitNow();
        goto L36
    L38:
        int r15 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "recreateSelf", "recreate fragment for dark mode change", (String) r9.h.invoke());
        MmRecordingFragment r16 = a.a(r6, (UserSession) r9.f.invoke());
        r16.la0((dwb.b) r9.g.invoke());
        FragmentTransaction r17 = r9.a.getParentFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r17, r16, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r13) == true) goto L42;
        r17 = r17.replace(r13, r16);
    L42:
        r17.commitAllowingStateLoss();
        return;
    L43:
        int r18 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "recreateSelf", "parent view is null, skip", (String) r9.h.invoke());
        return;
    L32:
        r12 = null;
        goto L33
    L28:
        r11 = null;
    L19:
        r4 = false;
        goto L20
    L14:
        r3 = null;
        goto L15
    }

    public final void ea0(CloseReason r3) {
        wvb.a.a(fa0(), getActivity(), r3);
    }

    public final void la0(dwb.b r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        int r0 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "setRecordingSlots", "top=" + ma0(r5.a) + ", title=" + ma0(r5.b) + ", middle=" + ma0(r5.c) + ", toolbar=" + ma0(r5.d) + ", isAdded=" + isAdded(), U90());
        this.v = r5;
        if (isAdded() == false) goto L8;
        com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.controller.a r1 = this.q;
        if (r1 == null) goto L9;
        r1.f(r5);
        return;
    L9:
        return;
    }

    public final void onConfigurationChanged(Configuration r4) {
        Intrinsics.checkNotNullParameter(r4, "newConfig");
        super.onConfigurationChanged(r4);
        if (this.x == false) goto L6;
        return;
    L6:
        if (ka0() == false) goto L11;
        MmRecordingContentController r0 = this.p;
        if (r0 == null) goto L11;
        StringBuilder r1 = new StringBuilder("orientation=");
        r1.append(r4.orientation);
        r1.append(", screenLayout=");
        r1.append(r4.screenLayout);
        r1.append(", density=");
        Resources r5 = getResources();
        r1.append(WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).densityDpi);
        String r6 = r1.toString();
        Intrinsics.checkNotNullParameter(r6, "reason");
        ViewPager2 r2 = r0.a.b();
        r2.post(new com.ss.android.lark.officesdk.minutes.ui.record.recording.content.d(r2, r6, r0));
    L11:
        if (fa0() != null) goto L13;
        return;
    L13:
        com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.b r7 = (com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.b) this.I.getValue();
        if (((Boolean) r7.c.invoke()).booleanValue() == false) goto L18;
        r7.d.invoke(Boolean.TRUE);
        return;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        if (LarkContext.getApplication() != null) goto L6;
        int r10 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, "onCreate", "Application not initialized, finish activity", U90());
        this.x = true;
        ea0(CloseReason.PARAMETER_INVALID);
        return;
    L6:
        Bundle r11 = getArguments();
        MmRecordingUILaunchMode r2 = null;
        if (r11 == null) goto L9;
        Serializable r12 = r11.getSerializable("arg_mm_recording_entity");
    L11:
        if ((r12 instanceof MmRecordingEntity) == false) goto L13;
        MmRecordingEntity r13 = (MmRecordingEntity) r12;
    L14:
        if (r13 != null) goto L17;
        int r14 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, "onCreate", "finishActivity entity is null", U90());
        this.x = true;
        ea0(CloseReason.PARAMETER_INVALID);
        return;
    L17:
        this.u = r13;
        String r3 = r13.getRecordingId();
        MmRecordingSessionManager r4 = ha0().A();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "sessionId");
        MmRecordingSession r5 = r4.m(r3);
        if (r5 != null) goto L21;
        int r15 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, "onCreate", "session is invalid, close page", U90());
        this.x = true;
        ea0(CloseReason.PARAMETER_INVALID);
        return;
    L21:
        boolean r6 = false;
        if (b.a[r5.a.ordinal()] != 1) goto L27;
        if (r5.h() != null) goto L28;
    L29:
        boolean r7 = false;
    L30:
        if (r7 == true) goto L33;
        int r16 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, "onCreate", "session repo is invalid, close page", U90());
        this.x = true;
        ea0(CloseReason.PARAMETER_INVALID);
        return;
    L33:
        MmRecordingUILaunchMode r8 = r13.getUiLaunchMode();
        k r17 = r5.f;
        if (r17 == null) goto L37;
        r2 = r17.c;
    L37:
        if (r8.shouldHandleUI() == true) goto L45;
        if (r2 != null) goto L41;
    L43:
        if (r6 == false) goto L51;
        r8 = r2;
        goto L45
    L51:
        int r18 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, "onCreate", "uiLaunchMode is invalid, route=" + r8 + ", session=" + r2 + ", close page", U90());
        this.x = true;
        ea0(CloseReason.PARAMETER_INVALID);
        return;
    L41:
        if (r2.shouldHandleUI() != true) goto L43;
        r6 = true;
    L45:
        this.A = r8;
        com.ss.android.lark.officesdk.minutes.ui.style.e.a.getClass();
        if (com.ss.android.lark.officesdk.minutes.ui.style.e.c(r8) != null) goto L49;
        int r19 = bwb.b.a;
        bwb.b.d(MmUiLogScene.RECORDING, "onCreate", "ui provider is missing, ui=" + this.A + ", close page", U90());
        this.x = true;
        ea0(CloseReason.PARAMETER_INVALID);
        return;
    L49:
        this.h = Boolean.valueOf(W90());
        int r1 = bwb.b.a;
        bwb.b.f(MmUiLogScene.ENTRY, "onCreate", "page=recording, ui=" + this.A + ", recording=" + r13.getRecordingId() + ", source=" + r13.getOpenSource() + ", dark=" + this.h, U90());
        ja0().initSession(r13.getRecordingId(), r5, this.A);
        return;
    L28:
        r7 = true;
        goto L30
    L27:
        if (r5.f() == null) goto L29;
    L13:
        r13 = null;
        goto L14
    L9:
        r12 = null;
        goto L11
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super.onViewCreated(r13, r14);
        if (this.x == false) goto L5;
        return;
    L5:
        int r1 = uvb.b.a;
        uvb.a.b(r13, uvb.c.b);
        uvb.b.a(r13, 2131390088, uvb.c.c);
        uvb.b.a(r13, 2131390025, uvb.c.d);
        uvb.b.a(r13, 2131380193, uvb.c.e);
        uvb.b.a(r13, 2131390023, uvb.c.p);
        uvb.b.a(r13, 2131383984, uvb.c.q);
        uvb.b.a(r13, 2131375939, uvb.c.r);
        uvb.b.a(r13, 2131375945, uvb.c.s);
        uvb.b.a(r13, 2131375918, uvb.c.t);
        uvb.b.a(r13, 2131375943, uvb.c.u);
        uvb.b.a(r13, 2131375895, uvb.c.v);
        uvb.b.a(r13, 2131375944, uvb.c.w);
        uvb.b.a(r13, 2131374778, uvb.c.h);
        ia0().d.setTopBarView(((com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.d) this.H.getValue()).b());
        ia0().d.setListener(new d(this));
        mwb.e r0 = ia0();
        int r2 = UIUtils.dp2px(requireContext(), 24.0f);
        FrameLayout r3 = r0.g;
        r3.setPadding(r3.getPaddingLeft(), r0.g.getPaddingTop(), r0.g.getPaddingRight(), RangesKt.coerceAtLeast(r2, 0));
        com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.controller.a r11 = new com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.controller.a(this, getChildFragmentManager(), ia0(), (com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope.d) this.E.getValue(), new MmRecordingFragment$initViews$1(this), new MmRecordingFragment$initViews$2(this), new MmRecordingFragment$initViews$3(this), new MmRecordingFragment$initViews$4(this), new MmRecordingFragment$initViews$5(this), new MmRecordingFragment$initViews$6(this));
        r11.f(this.v);
        this.q = r11;
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new MmRecordingFragment$setupBackPressedHandler$1(this));
        AnonymousClass1 r4 = new AnonymousClass1(this, null);
        Intrinsics.checkNotNullParameter(r4, "action");
        Z90().selectSubscribeVMEvent(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), r4);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        super.onCreateView(r2, r3, r4);
        if (this.x == true) goto L5;
        LayoutInflater r5 = LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(r2.getContext(), this.A));
        com.ss.android.lark.officesdk.minutes.ui.style.e r6 = com.ss.android.lark.officesdk.minutes.ui.style.e.a;
        MmRecordingUILaunchMode r0 = this.A;
        r6.getClass();
        com.ss.android.lark.officesdk.minutes.ui.style.contract.f r7 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r0).getLayout();
        Intrinsics.checkNotNull(r5);
        mwb.e r8 = r7.u(r5, r3);
        this.o = r8;
        return r8.a;
    L5:
        return new View(r2.getContext());
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void Y90(int r9, int r10, int r11, int r12) {
        com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.d r0 = (com.ss.android.lark.officesdk.minutes.ui.record.recording.base.controller.d) this.H.getValue();
        mwb.e r1 = (mwb.e) r0.a.invoke();
        MmRecordingUILaunchMode r2 = (MmRecordingUILaunchMode) r0.c.invoke();
        com.ss.android.lark.officesdk.minutes.ui.style.e.a.getClass();
        boolean r3 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r2).getCapability().e();
        uub.b r4 = (uub.b) r0.d.invoke();
        if (r3 == false) goto L6;
        if (r4 == null) goto L6;
        Rect r5 = r4.p0();
    L7:
        int r6 = bwb.b.a;
        MmUiLogScene r7 = MmUiLogScene.RECORDING;
        StringBuilder r8 = new StringBuilder("onWindowInsetsChanged: insets=[");
        r8.append(r9);
        r8.append(',');
        r8.append(r10);
        r8.append(',');
        r8.append(r11);
        r8.append(',');
        r8.append(r12);
        r8.append("], hasNavRectProvider=");
        if (r4 == null) goto L10;
        boolean r13 = true;
    L11:
        r8.append(r13);
        r8.append(", navRect=");
        r8.append(r5);
        bwb.b.f(r7, "onWindowInsetsChanged", r8.toString(), (String) r0.f.invoke());
        Context r14 = r0.b().getContext();
        ViewGroup.LayoutParams r15 = r1.c.getLayoutParams();
        if (r5 != null) goto L14;
        if (r3 == false) goto L28;
        if (r4 == null) goto L28;
        r0.c(r10);
        if ((r15 instanceof ConstraintLayout.LayoutParams) == false) goto L35;
        ConstraintLayout.LayoutParams r16 = (ConstraintLayout.LayoutParams) r15;
        ((ViewGroup.MarginLayoutParams) r16).width = -1;
        ((ViewGroup.MarginLayoutParams) r16).height = -2;
        r16.setMarginEnd(UIUtils.dp2px(r14, 108.0f));
        r16.endToEnd = 0;
        r16.startToStart = 0;
        r16.topToTop = 0;
        r1.c.setLayoutParams(r15);
    L35:
        r0.a();
        return;
    L28:
        r0.c(r10);
        View r17 = ((mwb.e) r0.a.invoke()).a;
        if (r17.getPaddingBottom() == r12) goto L33;
        r17.setPadding(r17.getPaddingLeft(), r17.getPaddingTop(), r17.getPaddingRight(), r12);
    L33:
        if ((r15 instanceof ConstraintLayout.LayoutParams) == false) goto L35;
        ConstraintLayout.LayoutParams r18 = (ConstraintLayout.LayoutParams) r15;
        ((ViewGroup.MarginLayoutParams) r18).width = -1;
        ((ViewGroup.MarginLayoutParams) r18).height = -2;
        r18.endToEnd = 0;
        r18.startToStart = 0;
        r18.topToTop = 0;
        r1.c.setLayoutParams(r15);
        goto L35
    L14:
        if (((Boolean) r0.e.invoke()).booleanValue() == false) goto L16;
        r0.c(r10);
    L16:
        int r19 = UIUtils.dp2px(r14, r5.height());
        int r20 = UIUtils.dp2px(r14, r5.width());
        if ((r15 instanceof ConstraintLayout.LayoutParams) == false) goto L35;
        ConstraintLayout.LayoutParams r21 = (ConstraintLayout.LayoutParams) r15;
        ((ViewGroup.MarginLayoutParams) r21).width = -1;
        ((ViewGroup.MarginLayoutParams) r21).height = -2;
        if (((Boolean) r0.e.invoke()).booleanValue() == false) goto L21;
        ((ViewGroup.MarginLayoutParams) r21).topMargin = 0;
    L22:
        r21.topToTop = 0;
        r21.setMarginEnd(r20 + UIUtils.dp2px(r14, 24.0f));
        r21.endToEnd = 0;
        r21.startToStart = 0;
        r1.c.setLayoutParams(r15);
        goto L35
    L21:
        ((ViewGroup.MarginLayoutParams) r21).topMargin = Math.max(r10, (UIUtils.dp2px(r14, r5.top) + (r19 / 2)) - (UIUtils.dp2px(r14, 44.0f) / 2));
        goto L22
    L10:
        r13 = false;
    L6:
        r5 = null;
        goto L7
    }
}
