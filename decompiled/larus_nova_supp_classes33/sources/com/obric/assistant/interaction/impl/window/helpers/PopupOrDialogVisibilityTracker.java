package com.obric.assistant.interaction.impl.window.helpers;

import android.app.Dialog;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004~\u007f\u0080\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\u00162\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010;\u001a\u0002072\u0006\u00108\u001a\u00020\bH\u0007J\u0015\u0010<\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\rH\u0000¢\u0006\u0002\b=J\u001b\u0010>\u001a\u0002072\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0000¢\u0006\u0002\b@J\u0015\u0010A\u001a\u0002072\u0006\u0010B\u001a\u00020\u0005H\u0000¢\u0006\u0002\bCJ\u0012\u0010D\u001a\u0002072\b\u0010E\u001a\u0004\u0018\u00010\u000eH\u0007J\u0012\u0010F\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010G\u001a\u0002072\b\u0010E\u001a\u0004\u0018\u00010\u000eH\u0007J$\u0010H\u001a\u0002072\u0006\u0010I\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u00162\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010J\u001a\u0002072\u0006\u0010I\u001a\u00020\u000bH\u0007J\u001e\u0010K\u001a\u0002072\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010L\u001a\u00020\u0011H\u0007J5\u0010K\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00162\u0006\u0010L\u001a\u00020\u00112\u0014\u0010M\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00110\u001dH\u0000¢\u0006\u0002\bNJ\u0010\u0010O\u001a\u0002072\u0006\u00109\u001a\u00020\u0016H\u0007J\u001e\u0010P\u001a\u0002072\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010L\u001a\u00020\u0011H\u0007J\u0010\u0010Q\u001a\u0002072\u0006\u00109\u001a\u00020\u0016H\u0007J\u0010\u0010R\u001a\u0002072\u0006\u0010:\u001a\u00020\u0013H\u0007J\u000e\u0010S\u001a\b\u0012\u0004\u0012\u00020U0TH\u0002J\u0016\u0010V\u001a\u0002072\f\u0010W\u001a\b\u0012\u0004\u0012\u00020U0TH\u0002J\b\u0010X\u001a\u00020\u0016H\u0002J\u0012\u0010Y\u001a\u0004\u0018\u00010\u00132\u0006\u00109\u001a\u00020\u0016H\u0002J\u001a\u0010Z\u001a\u00020\u00112\u0006\u0010[\u001a\u00020\t2\b\u0010\\\u001a\u0004\u0018\u00010\u0013H\u0002J!\u0010]\u001a\u0004\u0018\u00010\u00172\u0006\u00109\u001a\u00020\u00162\b\u0010:\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0002\b^J9\u0010_\u001a\u0004\u0018\u00010\u00172\u0006\u00109\u001a\u00020\u00162\u0006\u0010`\u001a\u00020\u00172\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020b2\b\u0010d\u001a\u0004\u0018\u00010\u0017H\u0000¢\u0006\u0002\beJ\u0017\u0010f\u001a\u0004\u0018\u00010\u00172\u0006\u00108\u001a\u00020\bH\u0000¢\u0006\u0002\bgJ\u0017\u0010h\u001a\u0004\u0018\u00010\u00172\u0006\u0010I\u001a\u00020\u000bH\u0000¢\u0006\u0002\biJ,\u0010j\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00162\u0006\u0010L\u001a\u00020\u00112\b\u0010k\u001a\u0004\u0018\u00010\u00172\b\u0010l\u001a\u0004\u0018\u00010\u0017H\u0002J*\u0010m\u001a\u00020\u00172\u0006\u0010l\u001a\u00020\u00172\u0006\u00109\u001a\u00020\u00162\b\u0010d\u001a\u0004\u0018\u00010\u00172\u0006\u0010k\u001a\u00020\u0017H\u0002J$\u0010n\u001a\u0002072\u0006\u00109\u001a\u00020\u00162\u0006\u0010o\u001a\u00020\u00112\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010p\u001a\u00020qH\u0002J\u001c\u0010r\u001a\u0004\u0018\u00010\t2\u0006\u00109\u001a\u00020\u00162\b\u0010:\u001a\u0004\u0018\u00010\u0013H\u0002J \u0010s\u001a\u0002072\u0006\u00108\u001a\u00020\b2\u0006\u0010E\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u0005H\u0002J\b\u0010t\u001a\u000207H\u0002J\f\u0010u\u001a\u00020\u0005*\u00020\u0013H\u0002J\u0017\u0010v\u001a\u0004\u0018\u00010\u00172\u0006\u0010w\u001a\u00020&H\u0000¢\u0006\u0002\bxJ\u0017\u0010y\u001a\u0004\u0018\u00010\u00172\u0006\u0010w\u001a\u00020&H\u0000¢\u0006\u0002\bzJ\u0017\u0010{\u001a\u0004\u0018\u00010-2\u0006\u0010w\u001a\u00020&H\u0000¢\u0006\u0002\b|J\u000e\u0010}\u001a\u0004\u0018\u00010\u0017*\u00020&H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R(\u0010%\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001f\"\u0004\b(\u0010!R(\u0010)\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R(\u0010,\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010-0\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001f\"\u0004\b/\u0010!R\"\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001701X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006\u0081\u0001"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/helpers/PopupOrDialogVisibilityTracker;", "", "<init>", "()V", "TAG", "", "dialogSources", "Ljava/util/WeakHashMap;", "Landroid/app/Dialog;", "Lcom/obric/assistant/interaction/impl/window/helpers/PopupOrDialogVisibilityTracker$TrackedOverlay;", "popupSources", "Landroid/widget/PopupWindow;", "dialogFragmentsByDialog", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/DialogFragment;", "retainedWindowDialogs", "windowVisible", "", "activityVisibleStates", "Landroidx/fragment/app/FragmentActivity;", "inputControlRectResolver", "Lkotlin/Function2;", "Lcom/obric/assistant/interaction/impl/window/helpers/OverlaySource;", "Landroid/graphics/Rect;", "getInputControlRectResolver$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function2;", "setInputControlRectResolver$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function2;)V", "dialogVisibleRectResolver", "Lkotlin/Function1;", "getDialogVisibleRectResolver$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function1;", "setDialogVisibleRectResolver$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function1;)V", "popupVisibleRectResolver", "getPopupVisibleRectResolver$impl_mainlandRelease", "setPopupVisibleRectResolver$impl_mainlandRelease", "viewVisibleRectResolver", "Landroid/view/View;", "getViewVisibleRectResolver$impl_mainlandRelease", "setViewVisibleRectResolver$impl_mainlandRelease", "popupViewLocalVisibleRectResolver", "getPopupViewLocalVisibleRectResolver$impl_mainlandRelease", "setPopupViewLocalVisibleRectResolver$impl_mainlandRelease", "viewLocationOnScreenResolver", "", "getViewLocationOnScreenResolver$impl_mainlandRelease", "setViewLocationOnScreenResolver$impl_mainlandRelease", "windowVisibleBoundsResolver", "Lkotlin/Function0;", "getWindowVisibleBoundsResolver$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function0;", "setWindowVisibleBoundsResolver$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function0;)V", "onDialogShow", "", "dialog", "source", "activity", "onDialogDismiss", "retainActiveWindowDialog", "retainActiveWindowDialog$impl_mainlandRelease", "releaseWindowDialog", "dialogRef", "releaseWindowDialog$impl_mainlandRelease", "dismissRetainedWindowDialogs", WindowEvent.Params.REASON, "dismissRetainedWindowDialogs$impl_mainlandRelease", "bindDialogFragment", "fragment", "onDialogShowBlocked", "onDialogFragmentDismissed", "onPopupShow", "popupWindow", "onPopupDismiss", "dismissAllTrackedDialogs", "dismissOverlappedOnly", "shouldDismissFragment", "dismissAllTrackedDialogs$impl_mainlandRelease", "clearTrackedDialogs", "dismissAllTrackedPopupWindows", "clearTrackedPopupWindows", "clearTrackedOverlays", "computeVisibilityEventsLocked", "", "Lcom/obric/assistant/interaction/impl/window/helpers/PopupOrDialogVisibilityTracker$VisibilityEvent;", "dispatchEvents", "events", "defaultDismissSource", "dismissActivityIfNeeded", "matchesDismissTargetActivity", "trackedOverlay", "dismissActivity", "resolveInputControlRect", "resolveInputControlRect$impl_mainlandRelease", "buildInputDismissRect", "inputVisibleRect", "inputViewHeight", "", "orientation", "windowBounds", "buildInputDismissRect$impl_mainlandRelease", "resolveDialogVisibleRect", "resolveDialogVisibleRect$impl_mainlandRelease", "resolvePopupVisibleRect", "resolvePopupVisibleRect$impl_mainlandRelease", "shouldDismissOverlay", "inputControlRect", "rawOverlayVisibleRect", "normalizeWindowOverlayRect", "dispatchVisibleChanged", "visible", "currentCounts", "Lcom/obric/assistant/interaction/impl/window/helpers/PopupOrDialogVisibilityTracker$Counts;", "createTrackedOverlay", "clearDialogFragmentBinding", "pruneStaleActivityOverlaysLocked", "activityIdentity", "resolveViewVisibleRect", "view", "resolveViewVisibleRect$impl_mainlandRelease", "resolveViewLocalVisibleRect", "resolveViewLocalVisibleRect$impl_mainlandRelease", "resolveViewLocationOnScreen", "resolveViewLocationOnScreen$impl_mainlandRelease", "visibleRectOrNull", "TrackedOverlay", "VisibilityEvent", "Counts", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupOrDialogVisibilityTracker {
    public static final PopupOrDialogVisibilityTracker INSTANCE = null;
    private static final String TAG = "PopupOrDialogTracker";
    private static final WeakHashMap<FragmentActivity, Boolean> activityVisibleStates = null;
    private static final WeakHashMap<Dialog, WeakReference<DialogFragment>> dialogFragmentsByDialog = null;
    private static final WeakHashMap<Dialog, TrackedOverlay> dialogSources = null;
    private static Function1<? super Dialog, Rect> dialogVisibleRectResolver;
    private static Function2<? super OverlaySource, ? super FragmentActivity, Rect> inputControlRectResolver;
    private static final WeakHashMap<PopupWindow, TrackedOverlay> popupSources = null;
    private static Function1<? super View, Rect> popupViewLocalVisibleRectResolver;
    private static Function1<? super PopupWindow, Rect> popupVisibleRectResolver;
    private static final WeakHashMap<Dialog, WeakReference<Dialog>> retainedWindowDialogs = null;
    private static Function1<? super View, int[]> viewLocationOnScreenResolver;
    private static Function1<? super View, Rect> viewVisibleRectResolver;
    private static boolean windowVisible;
    private static Function0<Rect> windowVisibleBoundsResolver;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/helpers/PopupOrDialogVisibilityTracker$Counts;", "", "windowCount", "", "activityOverlayCount", "activityVisibleSize", "dialogSize", "popupSize", "<init>", "(IIIII)V", "getWindowCount", "()I", "getActivityOverlayCount", "getActivityVisibleSize", "getDialogSize", "getPopupSize", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Counts {
        private final int activityOverlayCount;
        private final int activityVisibleSize;
        private final int dialogSize;
        private final int popupSize;
        private final int windowCount;

        public static /* synthetic */ Counts copy$default(Counts r3, int r4, int r5, int r6, int r7, int r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.windowCount;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.activityOverlayCount;
        L8:
            int r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.activityVisibleSize;
        L11:
            int r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.dialogSize;
        L14:
            int r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.popupSize;
        L17:
            int r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final int component1() {
            return this.windowCount;
        }

        public final int component2() {
            return this.activityOverlayCount;
        }

        public final int component3() {
            return this.activityVisibleSize;
        }

        public final int component4() {
            return this.dialogSize;
        }

        public final int component5() {
            return this.popupSize;
        }

        public final Counts copy(int r8, int r9, int r10, int r11, int r12) {
            return new Counts(r8, r9, r10, r11, r12);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Counts) == true) goto L8;
            return false;
        L8:
            Counts r6 = (Counts) r5;
            if (this.windowCount == r6.windowCount) goto L12;
            return false;
        L12:
            if (this.activityOverlayCount == r6.activityOverlayCount) goto L15;
            return false;
        L15:
            if (this.activityVisibleSize == r6.activityVisibleSize) goto L18;
            return false;
        L18:
            if (this.dialogSize == r6.dialogSize) goto L21;
            return false;
        L21:
            if (this.popupSize == r6.popupSize) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.windowCount * 31) + this.activityOverlayCount) * 31) + this.activityVisibleSize) * 31) + this.dialogSize) * 31) + this.popupSize;
        }

        public String toString() {
            return "Counts(windowCount=" + this.windowCount + ", activityOverlayCount=" + this.activityOverlayCount + ", activityVisibleSize=" + this.activityVisibleSize + ", dialogSize=" + this.dialogSize + ", popupSize=" + this.popupSize + ')';
        }

        public final int getActivityOverlayCount() {
            return this.activityOverlayCount;
        }

        public final int getActivityVisibleSize() {
            return this.activityVisibleSize;
        }

        public final int getDialogSize() {
            return this.dialogSize;
        }

        public final int getPopupSize() {
            return this.popupSize;
        }

        public final int getWindowCount() {
            return this.windowCount;
        }

        public Counts(int r1, int r2, int r3, int r4, int r5) {
            this.windowCount = r1;
            this.activityOverlayCount = r2;
            this.activityVisibleSize = r3;
            this.dialogSize = r4;
            this.popupSize = r5;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÂ\u0003J%\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/helpers/PopupOrDialogVisibilityTracker$TrackedOverlay;", "", "source", "Lcom/obric/assistant/interaction/impl/window/helpers/OverlaySource;", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Lcom/obric/assistant/interaction/impl/window/helpers/OverlaySource;Ljava/lang/ref/WeakReference;)V", "getSource", "()Lcom/obric/assistant/interaction/impl/window/helpers/OverlaySource;", "activity", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "component1", "component2", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TrackedOverlay {
        private final WeakReference<FragmentActivity> activityRef;
        private final OverlaySource source;

        private final WeakReference<FragmentActivity> component2() {
            return this.activityRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TrackedOverlay copy$default(TrackedOverlay r0, OverlaySource r1, WeakReference r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.source;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.activityRef;
        L9:
            return r0.copy(r1, r2);
        }

        public final OverlaySource component1() {
            return this.source;
        }

        public final TrackedOverlay copy(OverlaySource r2, WeakReference<FragmentActivity> r3) {
            Intrinsics.checkNotNullParameter(r2, "source");
            return new TrackedOverlay(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof TrackedOverlay) == true) goto L8;
            return false;
        L8:
            TrackedOverlay r6 = (TrackedOverlay) r5;
            if (this.source == r6.source) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.activityRef, r6.activityRef) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.source.hashCode() * 31;
            WeakReference<FragmentActivity> r1 = this.activityRef;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "TrackedOverlay(source=" + this.source + ", activityRef=" + this.activityRef + ')';
        }

        public final FragmentActivity getActivity() {
            WeakReference<FragmentActivity> r0 = this.activityRef;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.get();
        }

        public final OverlaySource getSource() {
            return this.source;
        }

        public TrackedOverlay(OverlaySource r2, WeakReference<FragmentActivity> r3) {
            Intrinsics.checkNotNullParameter(r2, "source");
            this.source = r2;
            this.activityRef = r3;
        }

        public /* synthetic */ TrackedOverlay(OverlaySource r1, WeakReference r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/helpers/PopupOrDialogVisibilityTracker$VisibilityEvent;", "", "source", "Lcom/obric/assistant/interaction/impl/window/helpers/OverlaySource;", "visible", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Lcom/obric/assistant/interaction/impl/window/helpers/OverlaySource;ZLandroidx/fragment/app/FragmentActivity;)V", "getSource", "()Lcom/obric/assistant/interaction/impl/window/helpers/OverlaySource;", "getVisible", "()Z", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "component1", "component2", "component3", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VisibilityEvent {
        private final FragmentActivity activity;
        private final OverlaySource source;
        private final boolean visible;

        public static /* synthetic */ VisibilityEvent copy$default(VisibilityEvent r0, OverlaySource r1, boolean r2, FragmentActivity r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.source;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.visible;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.activity;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final OverlaySource component1() {
            return this.source;
        }

        public final boolean component2() {
            return this.visible;
        }

        public final FragmentActivity component3() {
            return this.activity;
        }

        public final VisibilityEvent copy(OverlaySource r2, boolean r3, FragmentActivity r4) {
            Intrinsics.checkNotNullParameter(r2, "source");
            return new VisibilityEvent(r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof VisibilityEvent) == true) goto L8;
            return false;
        L8:
            VisibilityEvent r6 = (VisibilityEvent) r5;
            if (this.source == r6.source) goto L12;
            return false;
        L12:
            if (this.visible == r6.visible) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.activity, r6.activity) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = this.source.hashCode() * 31;
            if (this.visible == false) goto L5;
            int r1 = 1231;
        L6:
            int r2 = (r0 + r1) * 31;
            FragmentActivity r3 = this.activity;
            if (r3 != null) goto L9;
            int r4 = 0;
        L11:
            return r2 + r4;
        L9:
            r4 = r3.hashCode();
            goto L11
        L5:
            r1 = 1237;
            goto L6
        }

        public String toString() {
            return "VisibilityEvent(source=" + this.source + ", visible=" + this.visible + ", activity=" + this.activity + ')';
        }

        public final FragmentActivity getActivity() {
            return this.activity;
        }

        public final OverlaySource getSource() {
            return this.source;
        }

        public final boolean getVisible() {
            return this.visible;
        }

        public VisibilityEvent(OverlaySource r2, boolean r3, FragmentActivity r4) {
            Intrinsics.checkNotNullParameter(r2, "source");
            this.source = r2;
            this.visible = r3;
            this.activity = r4;
        }

        public /* synthetic */ VisibilityEvent(OverlaySource r1, boolean r2, FragmentActivity r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 4) == 0) goto L5;
            r3 = null;
        L5:
            this(r1, r2, r3);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[OverlaySource.values().length];
            r0[OverlaySource.WINDOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[OverlaySource.ACTIVITY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    private PopupOrDialogVisibilityTracker() {
    }

    public static /* synthetic */ boolean a(OverlaySource r0, Map.Entry r1) {
        return clearTrackedPopupWindows$lambda$40$lambda$39(r0, r1);
    }

    public static /* synthetic */ boolean b(Map.Entry r0) {
        return pruneStaleActivityOverlaysLocked$lambda$59(r0);
    }

    public static /* synthetic */ boolean c(FragmentActivity r0, Map.Entry r1) {
        return clearTrackedOverlays$lambda$43$lambda$42(r0, r1);
    }

    private final Counts currentCounts() {
        monitor-enter(this);
        INSTANCE.pruneStaleActivityOverlaysLocked();     // Catch: Throwable -> L14
        Ref.IntRef r0 = new Ref.IntRef();     // Catch: Throwable -> L14
        Ref.IntRef r1 = new Ref.IntRef();     // Catch: Throwable -> L14
        LinkedHashSet r2 = new LinkedHashSet();     // Catch: Throwable -> L14
        Iterator<T> r3 = dialogSources.values().iterator();     // Catch: Throwable -> L14
    L5:
        if (r3.hasNext() == false) goto L7;
        currentCounts$lambda$55$recordOverlay$52(r0, r1, r2, (TrackedOverlay) r3.next());     // Catch: Throwable -> L14
        goto L5
    L7:
        Iterator<T> r4 = popupSources.values().iterator();     // Catch: Throwable -> L14
    L9:
        if (r4.hasNext() == false) goto L11;
        currentCounts$lambda$55$recordOverlay$52(r0, r1, r2, (TrackedOverlay) r4.next());     // Catch: Throwable -> L14
        goto L9
    L11:
        Counts r7 = new Counts(r0.element, r1.element, r2.size(), dialogSources.size(), popupSources.size());     // Catch: Throwable -> L14
        monitor-exit(this);
        return r7;
    L14:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void d(DialogFragment r0, Dialog r1) {
        onDialogShowBlocked$lambda$18(r0, r1);
    }

    private static final boolean dismissAllTrackedDialogs$lambda$24(DialogFragment r0) {
        return true;
    }

    public static /* synthetic */ boolean e(DialogFragment r0, Map.Entry r1) {
        return bindDialogFragment$lambda$16$lambda$15(r0, r1);
    }

    public static /* synthetic */ boolean f(DialogFragment r0) {
        return dismissAllTrackedDialogs$lambda$24(r0);
    }

    public static /* synthetic */ boolean g(DialogFragment r0, Map.Entry r1) {
        return onDialogFragmentDismissed$lambda$20$lambda$19(r0, r1);
    }

    public static /* synthetic */ boolean h(FragmentActivity r0, Map.Entry r1) {
        return clearTrackedOverlays$lambda$43$lambda$41(r0, r1);
    }

    public static /* synthetic */ boolean i(OverlaySource r0, Map.Entry r1) {
        return clearTrackedDialogs$lambda$32$lambda$31(r0, r1);
    }

    public static /* synthetic */ boolean j(Map.Entry r0) {
        return pruneStaleActivityOverlaysLocked$lambda$58(r0);
    }

    public static /* synthetic */ Rect k() {
        return windowVisibleBoundsResolver$lambda$0();
    }

    public final WeakReference<Dialog> retainActiveWindowDialog$impl_mainlandRelease() {
        monitor-enter(this);
        WeakHashMap<Dialog, TrackedOverlay> r0 = dialogSources;     // Catch: Throwable -> L41
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L41
        Iterator<Map.Entry<Dialog, TrackedOverlay>> r2 = r0.entrySet().iterator();     // Catch: Throwable -> L41
    L4:
        String r3 = null;
        Dialog r4 = null;
        if (r2.hasNext() == false) goto L28;
        Map.Entry<Dialog, TrackedOverlay> r5 = r2.next();     // Catch: Throwable -> L41
        Dialog r6 = r5.getKey();     // Catch: Throwable -> L41
        TrackedOverlay r7 = r5.getValue();     // Catch: Throwable -> L41
        WeakReference<DialogFragment> r8 = dialogFragmentsByDialog.get(r6);     // Catch: Throwable -> L41
        if (r8 == null) goto L9;
        DialogFragment r9 = r8.get();     // Catch: Throwable -> L41
    L10:
        boolean r10 = false;
        if (r7.getSource() == OverlaySource.WINDOW) goto L13;
    L24:
        if (r10 == false) goto L26;
        r4 = r6;
    L26:
        if (r4 == null) goto L4;
        r1.add(r4);     // Catch: Throwable -> L41
        goto L4
    L13:
        if (r6.isShowing() == false) goto L24;
        if (r9 != null) goto L17;
    L19:
        boolean r11 = false;
    L20:
        if (r11 == false) goto L24;
        if (r9.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L24;
        r10 = true;
        goto L24
    L17:
        if (r9.isAdded() != true) goto L19;
        r11 = true;
        goto L20
    L9:
        r9 = null;
        goto L10
    L28:
        int r12 = r1.size();     // Catch: Throwable -> L41
        Dialog r13 = (Dialog) CollectionsKt.singleOrNull(r1);     // Catch: Throwable -> L41
        if (r13 != null) goto L31;
        Pair r14 = null;
    L32:
        monitor-exit(this);
        if (r14 != null) goto L36;
        FLogger.a.i(TAG, "retainWindowDialog skipped candidateCount=" + r12);
        return null;
    L36:
        dispatchEvents((List) r14.getSecond());
        FLogger r15 = FLogger.a;
        StringBuilder r16 = new StringBuilder("retainWindowDialog dialog=");
        Dialog r17 = (Dialog) ((WeakReference) r14.getFirst()).get();
        if (r17 == null) goto L39;
        r3 = r17.getClass().getName();
    L39:
        r16.append(r3);
        r15.i(TAG, r16.toString());
        return (WeakReference) r14.getFirst();
    L31:
        WeakReference<Dialog> r18 = new WeakReference(r13);     // Catch: Throwable -> L41
        retainedWindowDialogs.put(r13, r18);     // Catch: Throwable -> L41
        dialogSources.remove(r13);     // Catch: Throwable -> L41
        r14 = TuplesKt.to(r18, INSTANCE.computeVisibilityEventsLocked());     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    }

    static {
        PopupOrDialogVisibilityTracker r0 = new PopupOrDialogVisibilityTracker();
        INSTANCE = r0;
        dialogSources = new WeakHashMap();
        popupSources = new WeakHashMap();
        dialogFragmentsByDialog = new WeakHashMap();
        retainedWindowDialogs = new WeakHashMap();
        activityVisibleStates = new WeakHashMap();
        inputControlRectResolver = new PopupOrDialogVisibilityTracker$inputControlRectResolver$1(r0);
        dialogVisibleRectResolver = new PopupOrDialogVisibilityTracker$dialogVisibleRectResolver$1(r0);
        popupVisibleRectResolver = new PopupOrDialogVisibilityTracker$popupVisibleRectResolver$1(r0);
        viewVisibleRectResolver = new PopupOrDialogVisibilityTracker$viewVisibleRectResolver$1(r0);
        popupViewLocalVisibleRectResolver = new PopupOrDialogVisibilityTracker$popupViewLocalVisibleRectResolver$1(r0);
        viewLocationOnScreenResolver = new PopupOrDialogVisibilityTracker$viewLocationOnScreenResolver$1(r0);
        windowVisibleBoundsResolver = new f();
    }

    private final OverlaySource defaultDismissSource() {
        if (WindowHost.INSTANCE.isShowing() == false) goto L6;
        return OverlaySource.WINDOW;
    L6:
        return OverlaySource.ACTIVITY;
    }

    private final void pruneStaleActivityOverlaysLocked() {
        CollectionsKt.removeAll(dialogSources.entrySet(), new h());
        CollectionsKt.removeAll(popupSources.entrySet(), new i());
    }

    private static final Rect windowVisibleBoundsResolver$lambda$0() {
        return WindowHost.INSTANCE.getWindowVisibleBounds$impl_mainlandRelease();
    }

    private final List<VisibilityEvent> computeVisibilityEventsLocked() {
        pruneStaleActivityOverlaysLocked();
        Ref.IntRef r0 = new Ref.IntRef();
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<T> r2 = dialogSources.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        computeVisibilityEventsLocked$recordOverlay(r0, r1, (TrackedOverlay) r2.next());
        goto L4
    L6:
        Iterator<T> r3 = popupSources.values().iterator();
    L8:
        if (r3.hasNext() == false) goto L11;
        computeVisibilityEventsLocked$recordOverlay(r0, r1, (TrackedOverlay) r3.next());
        goto L8
    L11:
        if (r0.element <= 0) goto L13;
        boolean r6 = true;
    L14:
        int r4 = r1.size();
        WeakHashMap<FragmentActivity, Boolean> r10 = activityVisibleStates;
        ArrayList r5 = new ArrayList((r4 + r10.size()) + 1);
        if (r6 == windowVisible) goto L17;
        windowVisible = r6;
        r5.add(new VisibilityEvent(OverlaySource.WINDOW, r6, null, 4, null));
    L17:
        Iterator r7 = CollectionsKt.toList(r10.keySet()).iterator();
    L19:
        if (r7.hasNext() == false) goto L23;
        FragmentActivity r8 = (FragmentActivity) r7.next();
        if (r1.containsKey(r8) == true) goto L19;
        activityVisibleStates.remove(r8);
        r5.add(new VisibilityEvent(OverlaySource.ACTIVITY, false, r8));
        goto L19
    L23:
        Iterator r9 = r1.keySet().iterator();
    L25:
        if (r9.hasNext() == false) goto L30;
        FragmentActivity r11 = (FragmentActivity) r9.next();
        WeakHashMap<FragmentActivity, Boolean> r12 = activityVisibleStates;
        Boolean r13 = r12.get(r11);
        Boolean r14 = Boolean.TRUE;
        if (Intrinsics.areEqual(r13, r14) == true) goto L29;
        r5.add(new VisibilityEvent(OverlaySource.ACTIVITY, true, r11));
    L29:
        r12.put(r11, r14);
        goto L25
    L30:
        return r5;
    L13:
        r6 = false;
        goto L14
    }

    public final Function1<Dialog, Rect> getDialogVisibleRectResolver$impl_mainlandRelease() {
        return dialogVisibleRectResolver;
    }

    public final Function2<OverlaySource, FragmentActivity, Rect> getInputControlRectResolver$impl_mainlandRelease() {
        return inputControlRectResolver;
    }

    public final Function1<View, Rect> getPopupViewLocalVisibleRectResolver$impl_mainlandRelease() {
        return popupViewLocalVisibleRectResolver;
    }

    public final Function1<PopupWindow, Rect> getPopupVisibleRectResolver$impl_mainlandRelease() {
        return popupVisibleRectResolver;
    }

    public final Function1<View, int[]> getViewLocationOnScreenResolver$impl_mainlandRelease() {
        return viewLocationOnScreenResolver;
    }

    public final Function1<View, Rect> getViewVisibleRectResolver$impl_mainlandRelease() {
        return viewVisibleRectResolver;
    }

    public final Function0<Rect> getWindowVisibleBoundsResolver$impl_mainlandRelease() {
        return windowVisibleBoundsResolver;
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupOrDialogVisibilityTracker_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupOrDialogVisibilityTracker_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(DialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupOrDialogVisibilityTracker_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupOrDialogVisibilityTracker_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(PopupWindow r0) {
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    }

    private final String activityIdentity(FragmentActivity r3) {
        return r3.getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(r3));
    }

    @JvmStatic
    public static final void bindDialogFragment(final DialogFragment r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Dialog r0 = r6.getDialog();
        if (r0 != null) goto L7;
        return;
    L7:
        PopupOrDialogVisibilityTracker r1 = INSTANCE;
        monitor-enter(r1);
        WeakHashMap<Dialog, WeakReference<DialogFragment>> r2 = dialogFragmentsByDialog;     // Catch: Throwable -> L13
        CollectionsKt.removeAll(r2.entrySet(), new e(r6));     // Catch: Throwable -> L13
        r2.put(r0, new WeakReference(r6));     // Catch: Throwable -> L13
        int r3 = r2.size();     // Catch: Throwable -> L13
        monitor-exit(r1);
        FLogger.a.i(TAG, "bindDialogFragment dialog=" + r0.getClass().getName() + " fragment=" + r6.getClass().getName() + " bindingSize=" + r3);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void clearTrackedDialogs(final OverlaySource r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        PopupOrDialogVisibilityTracker r0 = INSTANCE;
        monitor-enter(r0);
        CollectionsKt.removeAll(dialogSources.entrySet(), new j(r6));     // Catch: Throwable -> L8
        List<VisibilityEvent> r1 = r0.computeVisibilityEventsLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);
        FLogger.a.i(TAG, "clearTrackedDialogs source=" + r6);
        r0.dispatchEvents(r1);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void clearTrackedOverlays(final FragmentActivity r6) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        PopupOrDialogVisibilityTracker r0 = INSTANCE;
        monitor-enter(r0);
        CollectionsKt.removeAll(dialogSources.entrySet(), new n(r6));     // Catch: Throwable -> L8
        CollectionsKt.removeAll(popupSources.entrySet(), new o(r6));     // Catch: Throwable -> L8
        activityVisibleStates.remove(r6);     // Catch: Throwable -> L8
        List<VisibilityEvent> r1 = r0.computeVisibilityEventsLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);
        FLogger.a.i(TAG, "clearTrackedOverlays activity=" + r0.activityIdentity(r6));
        r0.dispatchEvents(r1);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void clearTrackedPopupWindows(final OverlaySource r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        PopupOrDialogVisibilityTracker r0 = INSTANCE;
        monitor-enter(r0);
        CollectionsKt.removeAll(popupSources.entrySet(), new l(r6));     // Catch: Throwable -> L8
        List<VisibilityEvent> r1 = r0.computeVisibilityEventsLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);
        FLogger.a.i(TAG, "clearTrackedPopupWindows source=" + r6);
        r0.dispatchEvents(r1);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private final FragmentActivity dismissActivityIfNeeded(OverlaySource r5) {
        if (r5 == OverlaySource.ACTIVITY) goto L5;
        return null;
    L5:
        FragmentActivity r6 = WindowUtils.INSTANCE.getCurrentActivityExceptWindow();
        if (r6 == null) goto L10;
        Lifecycle r0 = r6.getLifecycle();
        if (r0 == null) goto L10;
        Lifecycle.State r1 = r0.getCurrentState();
    L12:
        if (r1 == Lifecycle.State.RESUMED) goto L25;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("dismissActivityIfNeeded skip activity=");
        if (r6 == null) goto L16;
        String r4 = activityIdentity(r6);
    L17:
        r3.append(r4);
        r3.append(" state=");
        if (r6 == null) goto L22;
        Lifecycle r7 = r6.getLifecycle();
        if (r7 == null) goto L22;
        Lifecycle.State r8 = r7.getCurrentState();
    L23:
        r3.append(r8);
        r2.i(TAG, r3.toString());
        return null;
    L22:
        r8 = null;
        goto L23
    L16:
        r4 = null;
        goto L17
    L25:
        return r6;
    L10:
        r1 = null;
        goto L12
    }

    private final void dispatchEvents(List<VisibilityEvent> r5) {
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        VisibilityEvent r0 = (VisibilityEvent) r6.next();
        INSTANCE.dispatchVisibleChanged(r0.getSource(), r0.getVisible(), r0.getActivity());
        goto L4
    }

    @JvmStatic
    public static final void onDialogDismiss(Dialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        PopupOrDialogVisibilityTracker r0 = INSTANCE;
        monitor-enter(r0);
        dialogSources.remove(r2);     // Catch: Throwable -> L8
        retainedWindowDialogs.remove(r2);     // Catch: Throwable -> L8
        List<VisibilityEvent> r3 = r0.computeVisibilityEventsLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);
        r0.dispatchEvents(r3);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void onDialogFragmentDismissed(final DialogFragment r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        PopupOrDialogVisibilityTracker r0 = INSTANCE;
        monitor-enter(r0);
        WeakHashMap<Dialog, WeakReference<DialogFragment>> r1 = dialogFragmentsByDialog;     // Catch: Throwable -> L10
        int r2 = r1.size();     // Catch: Throwable -> L10
        CollectionsKt.removeAll(r1.entrySet(), new g(r6));     // Catch: Throwable -> L10
        int r3 = r1.size();     // Catch: Throwable -> L10
        Pair r4 = TuplesKt.to(Integer.valueOf(r2 - r3), Integer.valueOf(r3));     // Catch: Throwable -> L10
        monitor-exit(r0);
        int r5 = ((Number) r4.component1()).intValue();
        int r7 = ((Number) r4.component2()).intValue();
        FLogger.a.i(TAG, "onDialogFragmentDismissed fragment=" + r6.getClass().getName() + " removedCount=" + r5 + " bindingSize=" + r7);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void onDialogShowBlocked(final Dialog r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        PopupOrDialogVisibilityTracker r0 = INSTANCE;
        monitor-enter(r0);
        WeakHashMap<Dialog, WeakReference<DialogFragment>> r1 = dialogFragmentsByDialog;     // Catch: Throwable -> L20
        WeakReference<DialogFragment> r2 = r1.get(r6);     // Catch: Throwable -> L20
        if (r2 == null) goto L9;
        DialogFragment r3 = r2.get();     // Catch: Throwable -> L20
    L10:
        if (r3 != null) goto L12;
        r1.remove(r6);     // Catch: Throwable -> L20
    L12:
        Pair r4 = TuplesKt.to(r3, Integer.valueOf(r1.size()));     // Catch: Throwable -> L20
        monitor-exit(r0);
        final DialogFragment r5 = (DialogFragment) r4.component1();
        int r7 = ((Number) r4.component2()).intValue();
        if (r5 != null) goto L18;
        FLogger.a.w(TAG, "onDialogShowBlocked skipped, owner fragment not found and binding removed dialog=" + r6.getClass().getName() + " bindingSize=" + r7);
        return;
    L18:
        FLogger.a.i(TAG, "onDialogShowBlocked dialog=" + r6.getClass().getName() + " fragment=" + r5.getClass().getName() + " bindingSize=" + r7);
        t0.c(new k(r5, r6));
        return;
    L9:
        r3 = null;
    L20:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void onPopupDismiss(PopupWindow r2) {
        Intrinsics.checkNotNullParameter(r2, "popupWindow");
        PopupOrDialogVisibilityTracker r0 = INSTANCE;
        monitor-enter(r0);
        popupSources.remove(r2);     // Catch: Throwable -> L8
        List<VisibilityEvent> r3 = r0.computeVisibilityEventsLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);
        r0.dispatchEvents(r3);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static final boolean pruneStaleActivityOverlaysLocked$lambda$58(Map.Entry r2) {
        Intrinsics.checkNotNullParameter(r2, "<destruct>");
        TrackedOverlay r3 = (TrackedOverlay) r2.getValue();
        if (r3.getSource() == OverlaySource.ACTIVITY) goto L5;
    L7:
        return false;
    L5:
        if (r3.getActivity() != null) goto L7;
        return true;
    }

    private static final boolean pruneStaleActivityOverlaysLocked$lambda$59(Map.Entry r2) {
        Intrinsics.checkNotNullParameter(r2, "<destruct>");
        TrackedOverlay r3 = (TrackedOverlay) r2.getValue();
        if (r3.getSource() == OverlaySource.ACTIVITY) goto L5;
    L7:
        return false;
    L5:
        if (r3.getActivity() != null) goto L7;
        return true;
    }

    private final Rect visibleRectOrNull(View r2) {
        Rect r0 = new Rect();
        if (r2.getGlobalVisibleRect(r0) == true) goto L5;
        return null;
    L5:
        if (r0.isEmpty() == true) goto L10;
        return r0;
    L10:
        return null;
    }

    public final void dismissRetainedWindowDialogs$impl_mainlandRelease(String r8) {
        Intrinsics.checkNotNullParameter(r8, WindowEvent.Params.REASON);
        monitor-enter(this);
        WeakHashMap<Dialog, WeakReference<Dialog>> r0 = retainedWindowDialogs;     // Catch: Throwable -> L21
        List r1 = CollectionsKt.toList(r0.keySet());     // Catch: Throwable -> L21
        r0.clear();     // Catch: Throwable -> L21
        monitor-exit(this);
        if (r1.isEmpty() == false) goto L9;
        return;
    L9:
        FLogger.a.i(TAG, "dismissRetainedWindowDialogs reason=" + r8 + " size=" + r1.size());
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L20;
        Dialog r3 = (Dialog) r2.next();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L15
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupOrDialogVisibilityTracker_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r3);     // Catch: Throwable -> L15
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L11;
        FLogger.a.e(TAG, "dismissRetainedWindowDialogs failed reason=" + r8 + " dialog=" + r3.getClass().getName(), r6);
    L15:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L20:
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public final void releaseWindowDialog$impl_mainlandRelease(WeakReference<Dialog> r7) {
        Intrinsics.checkNotNullParameter(r7, "dialogRef");
        Dialog r0 = r7.get();
        if (r0 != null) goto L6;
        FLogger.a.i(TAG, "releaseWindowDialog skipped dialogCollected=true");
        return;
    L6:
        monitor-enter(this);
        WeakHashMap<Dialog, WeakReference<Dialog>> r1 = retainedWindowDialogs;     // Catch: Throwable -> L26
        List<VisibilityEvent> r3 = null;
        boolean r4 = false;
        if (r1.get(r0) != r7) goto L20;
        r1.remove(r0);     // Catch: Throwable -> L26
        WeakHashMap<Dialog, TrackedOverlay> r8 = dialogSources;     // Catch: Throwable -> L26
        if (r8.containsKey(r0) == false) goto L13;
    L19:
        r3 = INSTANCE.computeVisibilityEventsLocked();     // Catch: Throwable -> L26
        goto L20
    L13:
        if (r0.isShowing() == false) goto L19;
        if (WindowHost.INSTANCE.isShowing() == false) goto L19;
        TrackedOverlay r2 = INSTANCE.createTrackedOverlay(OverlaySource.WINDOW, null);     // Catch: Throwable -> L26
        if (r2 == null) goto L19;
        r8.put(r0, r2);     // Catch: Throwable -> L26
        r4 = true;
    L20:
        monitor-exit(this);
        if (r3 != null) goto L24;
        FLogger.a.i(TAG, "releaseWindowDialog skipped lifecycleCleared=true");
        return;
    L24:
        FLogger.a.i(TAG, "releaseWindowDialog dialog=" + r0.getClass().getName() + " retracked=" + r4);
        dispatchEvents(r3);
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public final Rect resolveDialogVisibleRect$impl_mainlandRelease(Dialog r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        View r0 = r3.findViewById(2131368870);
        if (r0 == null) goto L7;
        Rect r1 = (Rect) viewVisibleRectResolver.invoke(r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        Window r4 = r3.getWindow();
        if (r4 == null) goto L12;
        View r5 = INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupOrDialogVisibilityTracker_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r4);
        if (r5 == null) goto L12;
        return (Rect) viewVisibleRectResolver.invoke(r5);
    L12:
        return null;
    }

    public final Rect resolvePopupVisibleRect$impl_mainlandRelease(PopupWindow r7) {
        Intrinsics.checkNotNullParameter(r7, "popupWindow");
        if (r7.isShowing() == true) goto L5;
        return null;
    L5:
        View r8 = r7.getContentView();
        if (r8 != null) goto L8;
        return null;
    L8:
        Rect r0 = (Rect) popupViewLocalVisibleRectResolver.invoke(r8);
        int[] r1 = (int[]) viewLocationOnScreenResolver.invoke(r8);
        if (r0 == null) goto L14;
        if (r1 == null) goto L14;
        int r2 = r1[0];
        int r3 = r0.left + r2;
        int r4 = r1[1];
        return new Rect(r3, r0.top + r4, r2 + r0.right, r4 + r0.bottom);
    L14:
        return (Rect) viewVisibleRectResolver.invoke(r8);
    }

    public final Rect resolveViewLocalVisibleRect$impl_mainlandRelease(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Rect r0 = new Rect();
        if (r2.getLocalVisibleRect(r0) == true) goto L5;
        return null;
    L5:
        if (r0.isEmpty() == true) goto L10;
        return r0;
    L10:
        return null;
    }

    public final int[] resolveViewLocationOnScreen$impl_mainlandRelease(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (r2.isAttachedToWindow() == true) goto L6;
        return null;
    L6:
        int[] r0 = new int[2];
        r2.getLocationOnScreen(r0);
        return r0;
    }

    public final Rect resolveViewVisibleRect$impl_mainlandRelease(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        return visibleRectOrNull(r2);
    }

    public final void setDialogVisibleRectResolver$impl_mainlandRelease(Function1<? super Dialog, Rect> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        dialogVisibleRectResolver = r2;
    }

    public final void setInputControlRectResolver$impl_mainlandRelease(Function2<? super OverlaySource, ? super FragmentActivity, Rect> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        inputControlRectResolver = r2;
    }

    public final void setPopupViewLocalVisibleRectResolver$impl_mainlandRelease(Function1<? super View, Rect> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        popupViewLocalVisibleRectResolver = r2;
    }

    public final void setPopupVisibleRectResolver$impl_mainlandRelease(Function1<? super PopupWindow, Rect> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        popupVisibleRectResolver = r2;
    }

    public final void setViewLocationOnScreenResolver$impl_mainlandRelease(Function1<? super View, int[]> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        viewLocationOnScreenResolver = r2;
    }

    public final void setViewVisibleRectResolver$impl_mainlandRelease(Function1<? super View, Rect> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        viewVisibleRectResolver = r2;
    }

    public final void setWindowVisibleBoundsResolver$impl_mainlandRelease(Function0<Rect> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        windowVisibleBoundsResolver = r2;
    }

    private static final boolean bindDialogFragment$lambda$16$lambda$15(DialogFragment r1, Map.Entry r2) {
        Intrinsics.checkNotNullParameter(r2, "<destruct>");
        DialogFragment r3 = (DialogFragment) ((WeakReference) r2.getValue()).get();
        if (r3 == null) goto L7;
        if (r3 == r1) goto L7;
        return false;
    L7:
        return true;
    }

    private static final boolean clearTrackedDialogs$lambda$32$lambda$31(OverlaySource r1, Map.Entry r2) {
        Intrinsics.checkNotNullParameter(r2, "<destruct>");
        if (((TrackedOverlay) r2.getValue()).getSource() != r1) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean clearTrackedOverlays$lambda$43$lambda$41(FragmentActivity r2, Map.Entry r3) {
        Intrinsics.checkNotNullParameter(r3, "<destruct>");
        TrackedOverlay r4 = (TrackedOverlay) r3.getValue();
        if (r4.getSource() == OverlaySource.ACTIVITY) goto L5;
    L7:
        return false;
    L5:
        if (r4.getActivity() != r2) goto L7;
        return true;
    }

    private static final boolean clearTrackedOverlays$lambda$43$lambda$42(FragmentActivity r2, Map.Entry r3) {
        Intrinsics.checkNotNullParameter(r3, "<destruct>");
        TrackedOverlay r4 = (TrackedOverlay) r3.getValue();
        if (r4.getSource() == OverlaySource.ACTIVITY) goto L5;
    L7:
        return false;
    L5:
        if (r4.getActivity() != r2) goto L7;
        return true;
    }

    private static final boolean clearTrackedPopupWindows$lambda$40$lambda$39(OverlaySource r1, Map.Entry r2) {
        Intrinsics.checkNotNullParameter(r2, "<destruct>");
        if (((TrackedOverlay) r2.getValue()).getSource() != r1) goto L5;
        return true;
    L5:
        return false;
    }

    private final TrackedOverlay createTrackedOverlay(OverlaySource r3, FragmentActivity r4) {
        WeakReference r1 = null;
        if (r3 != OverlaySource.ACTIVITY) goto L7;
        if (r4 != null) goto L7;
        FLogger.a.w(TAG, "skip tracking activity overlay because activity is null");
        return null;
    L7:
        if (r4 == null) goto L10;
        r1 = new WeakReference(r4);
    L10:
        return new TrackedOverlay(r3, r1);
    }

    @JvmStatic
    public static final void dismissAllTrackedDialogs(OverlaySource r2, boolean r3) {
        INSTANCE.dismissAllTrackedDialogs$impl_mainlandRelease(r2, r3, new m());
    }

    @JvmStatic
    public static final void dismissAllTrackedPopupWindows(OverlaySource r9, boolean r10) {
        if (r9 != null) goto L4;
        r9 = INSTANCE.defaultDismissSource();
    L4:
        PopupOrDialogVisibilityTracker r0 = INSTANCE;
        FragmentActivity r1 = r0.dismissActivityIfNeeded(r9);
        String r2 = null;
        if (r10 == false) goto L7;
        Rect r3 = (Rect) inputControlRectResolver.invoke(r9, r1);
    L8:
        monitor-enter(r0);
        WeakHashMap<PopupWindow, TrackedOverlay> r4 = popupSources;     // Catch: Throwable -> L43
        LinkedHashMap r5 = new LinkedHashMap();     // Catch: Throwable -> L43
        Iterator<Map.Entry<PopupWindow, TrackedOverlay>> r6 = r4.entrySet().iterator();     // Catch: Throwable -> L43
    L11:
        if (r6.hasNext() == false) goto L20;
        Map.Entry<PopupWindow, TrackedOverlay> r7 = r6.next();     // Catch: Throwable -> L43
        TrackedOverlay r8 = r7.getValue();     // Catch: Throwable -> L43
        if (r8.getSource() != r9) goto L17;
        PopupOrDialogVisibilityTracker r11 = INSTANCE;     // Catch: Throwable -> L43
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L43
        if (r11.matchesDismissTargetActivity(r8, r1) == false) goto L17;
        boolean r12 = true;
    L18:
        if (r12 == false) goto L11;
        r5.put(r7.getKey(), r7.getValue());     // Catch: Throwable -> L43
    L17:
        r12 = false;
        goto L18
    L20:
        List r13 = CollectionsKt.toList(r5.keySet());     // Catch: Throwable -> L43
        monitor-exit(r0);
        ArrayList r14 = new ArrayList();
        Iterator r15 = r13.iterator();
    L24:
        if (r15.hasNext() == false) goto L28;
        Object r16 = r15.next();
        PopupWindow r17 = (PopupWindow) r16;
        PopupOrDialogVisibilityTracker r18 = INSTANCE;
        Function1<? super PopupWindow, Rect> r19 = popupVisibleRectResolver;
        Intrinsics.checkNotNull(r17);
        if (r18.shouldDismissOverlay(r9, r10, r3, (Rect) r19.invoke(r17)) == false) goto L24;
        r14.add(r16);
        goto L24
    L28:
        FLogger r20 = FLogger.a;
        StringBuilder r21 = new StringBuilder("dismissAllTrackedPopupWindows size=");
        r21.append(r14.size());
        r21.append(" dismissSource=");
        r21.append(r9);
        r21.append(" dismissActivity=");
        if (r1 == null) goto L31;
        r2 = INSTANCE.activityIdentity(r1);
    L31:
        r21.append(r2);
        r21.append(" windowShowing=");
        r21.append(WindowHost.INSTANCE.isShowing());
        r21.append(" dismissOverlappedOnly=");
        r21.append(r10);
        r21.append(" inputControlRect=");
        r21.append(r3);
        r20.i(TAG, r21.toString());
        Iterator r110 = r14.iterator();
    L33:
        if (r110.hasNext() == false) goto L42;
        PopupWindow r22 = (PopupWindow) r110.next();
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L37
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupOrDialogVisibilityTracker_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(r22);     // Catch: Throwable -> L37
        Object r24 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L39:
        Throwable r25 = Result.exceptionOrNull-impl(r24);
        if (r25 == null) goto L33;
        FLogger.a.e(TAG, "dismissAllTrackedPopupWindows failed popupWindow=" + r22 + " source=" + r9, r25);
    L37:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    L42:
        return;
    L43:
        th = move-exception;
        throw th;
    L7:
        r3 = null;
        goto L8
    }

    private final boolean matchesDismissTargetActivity(TrackedOverlay r4, FragmentActivity r5) {
        if (r4.getSource() != OverlaySource.ACTIVITY) goto L10;
        if (r5 != null) goto L6;
    L8:
        return false;
    L6:
        if (r4.getActivity() != r5) goto L8;
        return true;
    L10:
        return true;
    }

    private static final boolean onDialogFragmentDismissed$lambda$20$lambda$19(DialogFragment r1, Map.Entry r2) {
        Intrinsics.checkNotNullParameter(r2, "<destruct>");
        DialogFragment r3 = (DialogFragment) ((WeakReference) r2.getValue()).get();
        if (r3 == null) goto L7;
        if (r3 == r1) goto L7;
        return false;
    L7:
        return true;
    }

    private static final void onDialogShowBlocked$lambda$18(DialogFragment r6, Dialog r7) {
        if (r6.getDialog() == r7) goto L21;
        FLogger.a.w(TAG, "onDialogShowBlocked skipped, dialog binding changed fragment=".concat(r6.getClass().getName()));
        INSTANCE.clearDialogFragmentBinding(r7, r6, "binding_changed");
        return;
    L21:
    L11:
        th = move-exception;
        FLogger.a.e(TAG, "dismiss blocked dialog fragment failed fragment=".concat(r6.getClass().getName()), th);     // Catch: Throwable -> L15
    L13:
        INSTANCE.clearDialogFragmentBinding(r7, r6, "show_blocked_handled");
        return;
    L15:
        th = move-exception;
        INSTANCE.clearDialogFragmentBinding(r7, r6, "show_blocked_handled");
        throw th;
    L7:
        if (r6.isAdded() == false) goto L9;
        FLogger.a.i(TAG, "onDialogShowBlocked dismiss fragment=".concat(r6.getClass().getName()));     // Catch: Throwable -> L11
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupOrDialogVisibilityTracker_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r6);     // Catch: Throwable -> L11
    L20:
        goto L13
    L9:
        FLogger.a.w(TAG, "onDialogShowBlocked skipped, fragment not added fragment=".concat(r6.getClass().getName()));     // Catch: Throwable -> L11
        goto L20
    }

    public final Rect resolveInputControlRect$impl_mainlandRelease(OverlaySource r10, FragmentActivity r11) {
        Intrinsics.checkNotNullParameter(r10, "source");
        int r0 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        Rect r2 = null;
        if (r0 != 1) goto L5;
        IAssistantChatWindow r12 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r12 == null) goto L22;
        t1a.b r13 = r12.provideWindowVContext();
        if (r13 == null) goto L22;
    L26:
        if (r13 == null) goto L42;
        va8.m r14 = r13.getAbility(va8.m.class);
        if (r14 == null) goto L42;
        va8.l r15 = r14.iX();
        if (r15 == null) goto L42;
        FrameLayout r16 = r15.getInput();
        if (r16 == null) goto L42;
        Rect r5 = visibleRectOrNull(r16);
        if (r5 != null) goto L37;
        return null;
    L37:
        int r7 = r16.getResources().getConfiguration().orientation;
        int r6 = r16.getHeight();
        if (r10 != OverlaySource.WINDOW) goto L41;
        r2 = (Rect) windowVisibleBoundsResolver.invoke();
    L41:
        return buildInputDismissRect$impl_mainlandRelease(r10, r5, r6, r7, r2);
    L42:
        return null;
    L22:
        IAssistantChatWindow r17 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r17 == null) goto L25;
        r13 = r17.getCurrentVContext();
    L25:
        r13 = null;
        goto L26
    L5:
        if (r0 != 2) goto L17;
        if (r11 != null) goto L8;
    L10:
        if (r11 == null) goto L13;
        r13 = PopupOrDialogVisibilityTrackerKt.getMainBotVContext(r11);
        if (r13 != null) goto L26;
    L13:
        IAssistantChatWindow r18 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r18 == null) goto L25;
        r13 = r18.getCurrentVContext();
        goto L26
    L8:
        if (ObricChatContextServiceDelegate.b.c(r11) == false) goto L10;
        r13 = PopupOrDialogVisibilityTrackerKt.getMainBotVContext(r11);
        goto L26
    L17:
        throw new NoWhenBranchMatchedException();
    }

    private final void clearDialogFragmentBinding(Dialog r6, DialogFragment r7, String r8) {
        monitor-enter(this);
        WeakHashMap<Dialog, WeakReference<DialogFragment>> r0 = dialogFragmentsByDialog;     // Catch: Throwable -> L16
        WeakReference<DialogFragment> r1 = r0.get(r6);     // Catch: Throwable -> L16
        if (r1 == null) goto L6;
        DialogFragment r2 = r1.get();     // Catch: Throwable -> L16
    L7:
        if (r2 != r7) goto L9;
        r0.remove(r6);     // Catch: Throwable -> L16
        boolean r3 = true;
    L10:
        Pair r4 = TuplesKt.to(Boolean.valueOf(r3), Integer.valueOf(r0.size()));     // Catch: Throwable -> L16
        monitor-exit(this);
        boolean r5 = ((Boolean) r4.component1()).booleanValue();
        int r9 = ((Number) r4.component2()).intValue();
        if (r5 == false) goto L21;
        FLogger.a.i(TAG, "clearDialogFragmentBinding reason=" + r8 + " dialog=" + r6.getClass().getName() + " fragment=" + r7.getClass().getName() + " bindingSize=" + r9);
        return;
    L21:
        return;
    L9:
        r3 = false;
        goto L10
    L6:
        r2 = null;
    L16:
        th = move-exception;
        throw th;
    }

    private static final void computeVisibilityEventsLocked$recordOverlay(Ref.IntRef r2, LinkedHashMap<FragmentActivity, Integer> r3, TrackedOverlay r4) {
        int r0 = WhenMappings.$EnumSwitchMapping$0[r4.getSource().ordinal()];
        if (r0 != 1) goto L5;
        r2.element++;
        return;
    L5:
        if (r0 != 2) goto L14;
        FragmentActivity r5 = r4.getActivity();
        if (r5 == null) goto L17;
        Integer r6 = r3.get(r5);
        if (r6 == null) goto L11;
        int r7 = r6.intValue();
    L12:
        r3.put(r5, Integer.valueOf(r7 + 1));
        return;
    L11:
        r7 = 0;
        goto L12
    L17:
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    private final void dispatchVisibleChanged(OverlaySource r6, boolean r7, FragmentActivity r8) {
        Counts r0 = currentCounts();
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("visibleChanged source=");
        r2.append(r6);
        r2.append(" visible=");
        r2.append(r7);
        r2.append(" activity=");
        t1a.b r3 = null;
        if (r8 == null) goto L5;
        String r4 = activityIdentity(r8);
    L6:
        r2.append(r4);
        r2.append(" windowCount=");
        r2.append(r0.getWindowCount());
        r2.append(" activityOverlayCount=");
        r2.append(r0.getActivityOverlayCount());
        r2.append(" activityVisibleSize=");
        r2.append(r0.getActivityVisibleSize());
        r2.append(" dialogSize=");
        r2.append(r0.getDialogSize());
        r2.append(" popupSize=");
        r2.append(r0.getPopupSize());
        r1.i(TAG, r2.toString());
        int r5 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];
        if (r5 != 1) goto L9;
        IAssistantChatWindow r9 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r9 == null) goto L20;
        t1a.b r10 = r9.provideWindowVContext();
        if (r10 == null) goto L20;
        r3 = r10;
    L24:
        if (r6 != OverlaySource.ACTIVITY) goto L27;
        if (r8 != null) goto L27;
        r1.w(TAG, "dispatchVisibleChanged missing activity for ACTIVITY event");
    L27:
        if (r3 == null) goto L32;
        laa.d r11 = r3.getAbility(laa.d.class);
        if (r11 == null) goto L33;
        r11.Ks(r7);
        return;
    L33:
        return;
    L32:
        return;
    L20:
        IAssistantChatWindow r12 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r12 == null) goto L24;
        r3 = r12.getCurrentVContext();
        goto L24
    L9:
        if (r5 != 2) goto L13;
        if (r8 == null) goto L24;
        r3 = PopupOrDialogVisibilityTrackerKt.getMainBotVContext(r8);
        goto L24
    L13:
        throw new NoWhenBranchMatchedException();
    L5:
        r4 = null;
        goto L6
    }

    @JvmStatic
    public static final void onDialogShow(Dialog r2, OverlaySource r3, FragmentActivity r4) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        Intrinsics.checkNotNullParameter(r3, "source");
        PopupOrDialogVisibilityTracker r0 = INSTANCE;
        monitor-enter(r0);
        PopupOrDialogVisibilityTracker r1 = INSTANCE;     // Catch: Throwable -> L11
        TrackedOverlay r5 = r1.createTrackedOverlay(r3, r4);     // Catch: Throwable -> L11
        if (r5 == null) goto L7;
        dialogSources.put(r2, r5);     // Catch: Throwable -> L11
    L7:
        List<VisibilityEvent> r6 = r1.computeVisibilityEventsLocked();     // Catch: Throwable -> L11
        monitor-exit(r0);
        r1.dispatchEvents(r6);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void onPopupShow(PopupWindow r2, OverlaySource r3, FragmentActivity r4) {
        Intrinsics.checkNotNullParameter(r2, "popupWindow");
        Intrinsics.checkNotNullParameter(r3, "source");
        PopupOrDialogVisibilityTracker r0 = INSTANCE;
        monitor-enter(r0);
        PopupOrDialogVisibilityTracker r1 = INSTANCE;     // Catch: Throwable -> L11
        TrackedOverlay r5 = r1.createTrackedOverlay(r3, r4);     // Catch: Throwable -> L11
        if (r5 == null) goto L7;
        popupSources.put(r2, r5);     // Catch: Throwable -> L11
    L7:
        List<VisibilityEvent> r6 = r1.computeVisibilityEventsLocked();     // Catch: Throwable -> L11
        monitor-exit(r0);
        r1.dispatchEvents(r6);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void dismissAllTrackedDialogs$impl_mainlandRelease(OverlaySource r10, boolean r11, Function1<? super DialogFragment, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r12, "shouldDismissFragment");
        if (r10 != null) goto L5;
        r10 = defaultDismissSource();
    L5:
        FragmentActivity r0 = dismissActivityIfNeeded(r10);
        String r1 = null;
        if (r11 == false) goto L8;
        Rect r2 = (Rect) inputControlRectResolver.invoke(r10, r0);
    L9:
        monitor-enter(this);
        WeakHashMap<Dialog, TrackedOverlay> r3 = dialogSources;     // Catch: Throwable -> L50
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Throwable -> L50
        Iterator<Map.Entry<Dialog, TrackedOverlay>> r5 = r3.entrySet().iterator();     // Catch: Throwable -> L50
    L12:
        if (r5.hasNext() == false) goto L27;
        Map.Entry<Dialog, TrackedOverlay> r6 = r5.next();     // Catch: Throwable -> L50
        Dialog r7 = r6.getKey();     // Catch: Throwable -> L50
        TrackedOverlay r8 = r6.getValue();     // Catch: Throwable -> L50
        if (r8.getSource() != r10) goto L24;
        PopupOrDialogVisibilityTracker r9 = INSTANCE;     // Catch: Throwable -> L50
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L50
        if (r9.matchesDismissTargetActivity(r8, r0) == false) goto L24;
        WeakReference<DialogFragment> r13 = dialogFragmentsByDialog.get(r7);     // Catch: Throwable -> L50
        if (r13 == null) goto L20;
        DialogFragment r14 = r13.get();     // Catch: Throwable -> L50
    L22:
        if (((Boolean) r12.invoke(r14)).booleanValue() == false) goto L24;
        boolean r15 = true;
    L25:
        if (r15 == false) goto L12;
        r4.put(r6.getKey(), r6.getValue());     // Catch: Throwable -> L50
        goto L12
    L20:
        r14 = null;
    L24:
        r15 = false;
        goto L25
    L27:
        List r16 = CollectionsKt.toList(r4.keySet());     // Catch: Throwable -> L50
        monitor-exit(this);
        ArrayList r17 = new ArrayList();
        Iterator r18 = r16.iterator();
    L31:
        if (r18.hasNext() == false) goto L35;
        Object r19 = r18.next();
        Dialog r20 = (Dialog) r19;
        PopupOrDialogVisibilityTracker r21 = INSTANCE;
        Function1<? super Dialog, Rect> r22 = dialogVisibleRectResolver;
        Intrinsics.checkNotNull(r20);
        if (r21.shouldDismissOverlay(r10, r11, r2, (Rect) r22.invoke(r20)) == false) goto L31;
        r17.add(r19);
        goto L31
    L35:
        FLogger r110 = FLogger.a;
        StringBuilder r23 = new StringBuilder("dismissAllTrackedDialogs size=");
        r23.append(r17.size());
        r23.append(" dismissSource=");
        r23.append(r10);
        r23.append(" dismissActivity=");
        if (r0 == null) goto L38;
        r1 = activityIdentity(r0);
    L38:
        r23.append(r1);
        r23.append(" windowShowing=");
        r23.append(WindowHost.INSTANCE.isShowing());
        r23.append(" dismissOverlappedOnly=");
        r23.append(r11);
        r23.append(" inputControlRect=");
        r23.append(r2);
        r110.i(TAG, r23.toString());
        Iterator r111 = r17.iterator();
    L40:
        if (r111.hasNext() == false) goto L49;
        Dialog r112 = (Dialog) r111.next();
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L44
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupOrDialogVisibilityTracker_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r112);     // Catch: Throwable -> L44
        Object r25 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L46:
        Throwable r26 = Result.exceptionOrNull-impl(r25);
        if (r26 == null) goto L40;
        FLogger.a.e(TAG, "dismissAllTrackedDialogs failed dialog=" + r112 + " source=" + r10, r26);
    L44:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L46
    L49:
        return;
    L50:
        th = move-exception;
        throw th;
    L8:
        r2 = null;
        goto L9
    }

    private static final void currentCounts$lambda$55$recordOverlay$52(Ref.IntRef r2, Ref.IntRef r3, LinkedHashSet<FragmentActivity> r4, TrackedOverlay r5) {
        int r0 = WhenMappings.$EnumSwitchMapping$0[r5.getSource().ordinal()];
        if (r0 != 1) goto L5;
        r2.element++;
        return;
    L5:
        if (r0 != 2) goto L10;
        FragmentActivity r6 = r5.getActivity();
        if (r6 == null) goto L13;
        r3.element++;
        r4.add(r6);
        return;
    L13:
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ void dismissAllTrackedDialogs$default(OverlaySource r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r0 = null;
    L6:
        if ((r2 & 2) == 0) goto L8;
        r1 = true;
    L8:
        dismissAllTrackedDialogs(r0, r1);
    }

    public static /* synthetic */ void dismissAllTrackedPopupWindows$default(OverlaySource r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r0 = null;
    L6:
        if ((r2 & 2) == 0) goto L8;
        r1 = true;
    L8:
        dismissAllTrackedPopupWindows(r0, r1);
    }

    private final Rect normalizeWindowOverlayRect(Rect r2, OverlaySource r3, Rect r4, Rect r5) {
        Rect r0 = new Rect(r2);
        if (r3 != OverlaySource.WINDOW) goto L14;
        if (r4 == null) goto L14;
        if (r4.isEmpty() == true) goto L14;
        if (Rect.intersects(r0, r5) == false) goto L11;
        return r0;
    L11:
        Rect r6 = new Rect(r0);
        r6.offset(r4.left, r4.top);
        if (Rect.intersects(r6, r5) == false) goto L14;
        return r6;
    L14:
        return r0;
    }

    private final boolean shouldDismissOverlay(OverlaySource r2, boolean r3, Rect r4, Rect r5) {
        if (r3 == true) goto L5;
        return true;
    L5:
        if (r4 == null) goto L15;
        if (r5 == null) goto L15;
        if (r2 != OverlaySource.WINDOW) goto L11;
        Rect r6 = (Rect) windowVisibleBoundsResolver.invoke();
    L13:
        return Rect.intersects(r4, normalizeWindowOverlayRect(r5, r2, r6, r4));
    L11:
        r6 = null;
    L15:
        if (r2 == OverlaySource.WINDOW) goto L19;
        return false;
    L19:
        return true;
    }

    public static /* synthetic */ void onDialogShow$default(Dialog r0, OverlaySource r1, FragmentActivity r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        onDialogShow(r0, r1, r2);
    }

    public static /* synthetic */ void onPopupShow$default(PopupWindow r0, OverlaySource r1, FragmentActivity r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        onPopupShow(r0, r1, r2);
    }

    public final Rect buildInputDismissRect$impl_mainlandRelease(OverlaySource r5, Rect r6, int r7, int r8, Rect r9) {
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r6, "inputVisibleRect");
        if (r8 == 2) goto L6;
        r7 = r7 / 3;
    L6:
        Rect r1 = new Rect(r6.left, r6.top - r7, r6.right, r6.bottom);
        if (r5 != OverlaySource.WINDOW) goto L20;
        if (r8 != 2) goto L20;
        if (r9 == null) goto L20;
        if (r9.isEmpty() == false) goto L14;
        return r1;
    L14:
        int r10 = RangesKt.coerceAtLeast(r1.top, r9.top);
        int r11 = RangesKt.coerceAtMost(r1.bottom, r9.bottom);
        if (r10 < r11) goto L19;
        return null;
    L19:
        return new Rect(r9.left, r10, r9.right, r11);
    L20:
        return r1;
    }

    public static /* synthetic */ void dispatchVisibleChanged$default(PopupOrDialogVisibilityTracker r0, OverlaySource r1, boolean r2, FragmentActivity r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.dispatchVisibleChanged(r1, r2, r3);
    }
}
