package com.ss.android.lark.movable;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.ViewGroupKt;
import com.bytedance.lark.lark_markdown_render_android.FfiCaret;
import com.bytedance.lark.lark_markdown_render_android.Lark_markdown_renderKt;
import com.bytedance.lark.lark_markdown_render_android.MovableCallback;
import com.bytedance.lark.lark_markdown_render_android.MovableDocumentInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.attatchment.MovableAttachmentApplier;
import com.ss.android.lark.movable.attatchment.p;
import com.ss.android.lark.movable.island.MovableIslandsOpsApplier;
import com.ss.android.lark.movable.island.ScrollIsland;
import com.ss.android.lark.movable.selection.HandleStyle;
import com.ss.android.lark.movable.selection.MovableLongPressBehavior;
import com.ss.android.lark.movable.selection.MovableSelectionManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b'\b\u0016\u0018\u0000 Â\u00012\u00020\u00012\u00020\u0002:\u0006Â\u0001Ã\u0001Ä\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010?\u001a\u00020@2\b\u00107\u001a\u0004\u0018\u00010%2\b\u0010A\u001a\u0004\u0018\u00010\u0000J\u0006\u0010B\u001a\u00020\u0000J\u0006\u0010C\u001a\u00020\u001cJ\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00000EJ!\u0010Y\u001a\u00020@2\u0017\u0010Z\u001a\u0013\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020@0[¢\u0006\u0002\b]H\u0016J\u0010\u0010^\u001a\u00020@2\u0006\u0010_\u001a\u00020\\H\u0004J\u0010\u0010`\u001a\u00020@2\u0006\u0010_\u001a\u00020\\H\u0014J\b\u0010a\u001a\u00020@H\u0002J\n\u0010b\u001a\u0004\u0018\u000106H\u0002J\u0010\u0010c\u001a\u00020@2\u0006\u0010d\u001a\u00020TH\u0002J\b\u0010e\u001a\u0004\u0018\u00010>J\u0006\u0010f\u001a\u00020gJ\b\u0010h\u001a\u0004\u0018\u00010iJ\u0006\u0010j\u001a\u00020@J\u0010\u0010k\u001a\u00020@2\u0006\u0010-\u001a\u00020\u001cH\u0007J\r\u0010l\u001a\u00020\nH\u0000¢\u0006\u0002\bmJ\b\u0010n\u001a\u0004\u0018\u00010oJ!\u0010p\u001a\u00020@2\u0006\u0010q\u001a\u00020\u00122\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>H\u0000¢\u0006\u0002\brJ\u000e\u0010s\u001a\u00020@2\u0006\u0010t\u001a\u00020\u001cJ\b\u0010u\u001a\u00020@H\u0014J\b\u0010v\u001a\u00020@H\u0014J\b\u0010w\u001a\u00020@H\u0002J\u0012\u0010x\u001a\u00020@2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u0010\u0010y\u001a\u00020@2\u0006\u0010q\u001a\u00020\u0012H\u0002J\b\u0010z\u001a\u00020@H\u0002J\b\u0010{\u001a\u00020@H\u0002J%\u0010|\u001a\u00020@2\u001b\u0010}\u001a\u0017\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u007f\u0012\u0005\u0012\u00030\u0080\u00010~\u0018\u00010EH\u0002J\u0011\u0010\u0081\u0001\u001a\u00020\u001c2\u0006\u0010d\u001a\u00020TH\u0014J\u001b\u0010\u0082\u0001\u001a\u00020@2\u0007\u0010\u0083\u0001\u001a\u00020\n2\u0007\u0010\u0084\u0001\u001a\u00020\nH\u0014J-\u0010\u0085\u0001\u001a\u00020@2\u0007\u0010\u0086\u0001\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u00020\n2\u0007\u0010\u0088\u0001\u001a\u00020\n2\u0007\u0010\u0089\u0001\u001a\u00020\nH\u0014J\r\u0010\u008a\u0001\u001a\u00020i*\u00020>H\u0002J\u0010\u0010\u008b\u0001\u001a\u00020@2\u0007\u0010\u008c\u0001\u001a\u00020>J\u0010\u0010\u008d\u0001\u001a\u00020@2\u0007\u0010\u008c\u0001\u001a\u00020>J\u001b\u0010\u008e\u0001\u001a\u00020@2\u0007\u0010\u008f\u0001\u001a\u00020T2\u0007\u0010\u0090\u0001\u001a\u00020\nH\u0014J\u0015\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\u0007\u0010\u008c\u0001\u001a\u00020>H\u0002JW\u0010\u0093\u0001\u001a\u00020@2\b\u0010\u0094\u0001\u001a\u00030\u0092\u00012\u001b\u0010\u0095\u0001\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120~0E2\u0007\u0010\u0096\u0001\u001a\u00020\u001c2\u001c\u0010\u0097\u0001\u001a\u0017\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\u007f\u0012\u0005\u0012\u00030\u0080\u00010~\u0018\u00010EH\u0002J\t\u0010\u0098\u0001\u001a\u00020@H\u0016J\u0007\u0010\u0099\u0001\u001a\u00020@J\u0012\u0010\u009a\u0001\u001a\u00020@2\u0007\u0010\u009b\u0001\u001a\u00020\u001cH\u0002J@\u0010\u009c\u0001\u001a\u00020@2\b\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020g2\u0007\u0010 \u0001\u001a\u00020g2\u0007\u0010¡\u0001\u001a\u00020g2\u0007\u0010¢\u0001\u001a\u00020gH\u0016¢\u0006\u0006\b£\u0001\u0010¤\u0001J\u0012\u0010¥\u0001\u001a\u00020@2\u0007\u0010¦\u0001\u001a\u00020\u001cH\u0002J\u0012\u0010§\u0001\u001a\u00020\u001c2\u0007\u0010¨\u0001\u001a\u00020UH\u0016J\t\u0010©\u0001\u001a\u00020@H\u0016J\t\u0010ª\u0001\u001a\u00020@H\u0002J,\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020g0E2\b\u0010\u009d\u0001\u001a\u00030\u009e\u00012\b\u0010¬\u0001\u001a\u00030\u009e\u0001H\u0016¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J.\u0010¯\u0001\u001a\u00020@2\u0007\u0010°\u0001\u001a\u00020i2\u0007\u0010±\u0001\u001a\u00020i2\b\u0010²\u0001\u001a\u00030\u009e\u0001H\u0016¢\u0006\u0006\b³\u0001\u0010´\u0001J4\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020g0E2\b\u0010¶\u0001\u001a\u00030\u009e\u00012\u0007\u0010·\u0001\u001a\u00020g2\u0007\u0010¸\u0001\u001a\u00020iH\u0016¢\u0006\u0006\b¹\u0001\u0010º\u0001J-\u0010»\u0001\u001a\u00020@2\u0007\u0010\t\u001a\u00030\u009e\u00012\u0007\u0010¼\u0001\u001a\u00020i2\u0007\u0010½\u0001\u001a\u00020iH\u0016¢\u0006\u0006\b¾\u0001\u0010¿\u0001J\u000f\u0010À\u0001\u001a\b\u0012\u0004\u0012\u00020i0EH\u0016J!\u0010Á\u0001\u001a\u00020@2\u0007\u0010¡\u0001\u001a\u00020g2\u0007\u0010¢\u0001\u001a\u00020g2\u0006\u0010t\u001a\u00020\u001cR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010-\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001c@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u000e\u001a\u0004\b0\u00101R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u0004\u0018\u00010%X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0010\u0010<\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010L\u001a\u0004\u0018\u00010MX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010R\u001a\u0016\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020@\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010X\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020@\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Å\u0001"}, d2 = {"Lcom/ss/android/lark/movable/MovableView;", "Lcom/ss/android/lark/movable/OverflowClipContainer;", "Lcom/bytedance/lark/lark_markdown_render_android/MovableCallback;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "instanceId", "", "getInstanceId", "()I", "instanceId$delegate", "Lkotlin/Lazy;", "attachmentApplier", "Lcom/ss/android/lark/movable/attatchment/MovableAttachmentApplier;", "attachmentBlob", "", "textData", "islandsOps", "scope", "Lkotlinx/coroutines/CoroutineScope;", "renderJob", "Lkotlinx/coroutines/Job;", "currentRenderToken", "", "enableDrawGlyphs", "", "textCanvasView", "Lcom/ss/android/lark/movable/rcanvas/RCanvas;", "selectionEnabledByConfig", "selectionActive", "isSelectionEnabled", "()Z", "islands", "", "Lcom/ss/android/lark/movable/island/ScrollIsland;", "selectionManager", "Lcom/ss/android/lark/movable/selection/MovableSelectionManager;", "getSelectionManager$movable_release", "()Lcom/ss/android/lark/movable/selection/MovableSelectionManager;", "setSelectionManager$movable_release", "(Lcom/ss/android/lark/movable/selection/MovableSelectionManager;)V", "value", "isInStreaming", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "loadingView", "Lcom/ss/android/lark/movable/LoadingView;", "selectionManagerBuilder", "Lcom/ss/android/lark/movable/selection/MovableSelectionManager$Builder;", "parentIsland", "getParentIsland$movable_release", "()Lcom/ss/android/lark/movable/island/ScrollIsland;", "setParentIsland$movable_release", "(Lcom/ss/android/lark/movable/island/ScrollIsland;)V", "parentMovableView", "documentInfo", "Lcom/bytedance/lark/lark_markdown_render_android/MovableDocumentInfo;", "setParentInfo", "", "rootMovableView", "getRootMovableView", "isRootMovableView", "getInnerMovableViews", "", "eventClickListener", "Lcom/ss/android/lark/movable/IMovableEventClickListener;", "getEventClickListener$movable_release", "()Lcom/ss/android/lark/movable/IMovableEventClickListener;", "setEventClickListener$movable_release", "(Lcom/ss/android/lark/movable/IMovableEventClickListener;)V", "imageLoader", "Lcom/ss/android/lark/movable/attatchment/MovableImageLoader;", "getImageLoader$movable_release", "()Lcom/ss/android/lark/movable/attatchment/MovableImageLoader;", "setImageLoader$movable_release", "(Lcom/ss/android/lark/movable/attatchment/MovableImageLoader;)V", "onNonClickableAreaClick", "Lkotlin/Function2;", "Landroid/view/View;", "Landroid/view/MotionEvent;", "initialized", "shouldRegisterOnAttach", "onWidthChangedListener", "setup", "block", "Lkotlin/Function1;", "Lcom/ss/android/lark/movable/MovableView$Config;", "Lkotlin/ExtensionFunctionType;", "setupWithConfig", "config", "applyConfig", "attachTextRCanvas", "resolveSelectionManagerBuilder", "ensureChildMeasuredAndLaidOut", "child", "getMovableDocumentInfo", "getMovableDocumentHeight", "", "getSelectedMarkdownText", "", "clearSelection", "updateIsInStreaming", "getMovableInstanceId", "getMovableInstanceId$movable_release", "getCopyStrategy", "Lcom/ss/android/lark/movable/selection/MovableCopyStrategy;", "updateTextRender", "data", "updateTextRender$movable_release", "updateLoadingState", "inStreaming", "onAttachedToWindow", "onDetachedFromWindow", "registerMovableViewIfAttached", "updateMovableDocumentInfo", "updateAttachmentRender", "removeAttachment", "removeScrollIsland", "updateIslandViews", "ops", "Lkotlin/Pair;", "Lcom/ss/android/lark/movable/island/MovableIslandsOpsApplier$Op;", "Lcom/ss/android/lark/movable/island/IslandInfo;", "shouldOverflow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "logInfo", "render", "originDocumentInfo", "renderSync", "onVisibilityChanged", "changedView", "visibility", "prepareRender", "Lcom/ss/android/lark/movable/MovableView$RenderContext;", "applyRenderData", "renderContext", "islandResults", "needUpdateScrollIsland", "islandOpList", "onRecycled", "release", "releaseInternal", "resetLayout", "markHighlightUpdate", "canvasId", "Lkotlin/UInt;", "x", "y", "width", "height", "markHighlightUpdate-iyaXS9w", "(IFFFF)V", "updateEnableSelection", "active", "onTouchEvent", "event", "cancelLongPress", "cancelInternalLongPress", "getScrollIslandScrollOffset", "islandId", "getScrollIslandScrollOffset-feOb9K0", "(II)Ljava/util/List;", "registerFont", "name", "path", "ttcIndex", "registerFont-jXDDuk8", "(Ljava/lang/String;Ljava/lang/String;I)V", "measureAttachment", "typeId", "containerWidth", "propertyString", "measureAttachment-OzbTU-A", "(IFLjava/lang/String;)Ljava/util/List;", "eventClick", "schema", "payload", "eventClick-OzbTU-A", "(ILjava/lang/String;Ljava/lang/String;)V", "getFontPrefixPathCandidates", "updateSize", "Companion", "RenderContext", "Config", "movable_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class MovableView extends OverflowClipContainer implements MovableCallback {
    public static final /* synthetic */ int A = 0;
    public final Lazy b;
    public final MovableAttachmentApplier c;
    public byte[] d;
    public byte[] e;
    public byte[] f;
    public final CoroutineScope g;
    public volatile long h;
    public final boolean i;
    public final ksb.b j;
    public boolean k;
    public boolean l;
    public final Map<Integer, ScrollIsland> m;
    public MovableSelectionManager n;
    public final Lazy o;
    public com.ss.android.lark.movable.c p;
    public MovableSelectionManager.a q;
    public ScrollIsland r;
    public MovableView s;
    public MovableDocumentInfo t;
    public com.ss.android.lark.movable.b u;
    public p v;
    public Function2<? super View, ? super MotionEvent, Unit> w;
    public boolean x;
    public boolean y;
    public Function2<? super Integer, ? super Integer, Unit> z;

    public static final class a {
    }

    public static class b {
        public p a;
        public com.ss.android.lark.movable.b b;
        public boolean c;
        public MovableSelectionManager.a d;
        public Function2<? super Integer, ? super Integer, Unit> e;
        public Function2<? super View, ? super MotionEvent, Unit> f;

        public b() {
            this.c = true;
        }
    }

    public static final class c {
        public final MovableDocumentInfo a;
        public final MovableDocumentInfo b;
        public final int c;
        public final int d;
        public final boolean e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + UInt.hashCode-impl(this.c)) * 31) + UInt.hashCode-impl(this.d)) * 31;
            if (this.e == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "RenderContext(originDocumentInfo=" + this.a + ", documentInfo=" + this.b + ", documentVersion=" + UInt.toString-impl(this.c) + ", renderId=" + UInt.toString-impl(this.d) + ", inStreaming=" + this.e + ')';
        }

        public c(MovableDocumentInfo r2, MovableDocumentInfo r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "originDocumentInfo");
            Intrinsics.checkNotNullParameter(r3, "documentInfo");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = false;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.movable.MovableView$onDetachedFromWindow$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.movable.MovableView$onDetachedFromWindow$1", f = "MovableView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MovableView this$0;

        public AnonymousClass1(MovableView r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            MovableSelectionManager r3 = this.this$0.getSelectionManager$movable_release();
            if (r3 == null) goto L8;
            r3.d();
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.movable.MovableView$onVisibilityChanged$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.movable.MovableView$onVisibilityChanged$1", f = "MovableView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MovableView this$0;

        public C04411(MovableView r1, Continuation<? super C04411> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04411(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            MovableSelectionManager r3 = this.this$0.getSelectionManager$movable_release();
            if (r3 == null) goto L8;
            r3.d();
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    /* JADX INFO: renamed from: registerFont-jXDDuk8, reason: not valid java name */
    public final void m1473registerFontjXDDuk8(String r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "name");
        Intrinsics.checkNotNullParameter(r2, "path");
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.o.getValue();
    }

    private final int getInstanceId() {
        return ((Number) this.b.getValue()).intValue();
    }

    public void d() {
        Log.i("MovableView", "movable onRecycled() called, hashCode:" + hashCode());
        com.ss.android.lark.movable.c r0 = this.p;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.p = null;
        removeAllViews();
        ksb.b r1 = this.j;
        r1.getClass();
        Log.d("RCanvas", "canvasSh: " + r1.e + ", reset called");
        r1.c = new byte[0];
        r1.d = null;
        ((LinkedHashMap) this.m).clear();
        this.d = null;
        this.e = null;
        this.f = null;
        this.t = null;
        this.x = false;
        this.y = false;
        MovableGlobalManager.d.a().e(getMovableInstanceId$movable_release());
        this.u = null;
        this.v = null;
        this.n = null;
        this.q = null;
        this.z = null;
        this.r = null;
        this.s = null;
        this.l = true;
        if (getLayoutParams() == null) goto L12;
        ViewGroup.LayoutParams r2 = getLayoutParams();
        if (r2 == null) goto L11;
        r2.height = 0;
        setLayoutParams(r2);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void e() {
        if (this.y == true) goto L5;
        return;
    L5:
        if (this.x == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(getRootMovableView(), this) == true) goto L9;
        return;
    L9:
        if (isAttachedToWindow() == false) goto L15;
        MovableGlobalManager.d.a().c(getMovableInstanceId$movable_release(), this);
        return;
    }

    public final List<MovableView> getInnerMovableViews() {
        Map<Integer, ScrollIsland> r0 = this.m;
        ArrayList r1 = new ArrayList(r0.size());
        Iterator r2 = ((LinkedHashMap) r0).entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((ScrollIsland) ((Map.Entry) r2.next()).getValue()).getInnerMovableView());
        goto L4
    L6:
        return r1;
    }

    public final MovableView getRootMovableView() {
        MovableView r0 = this.s;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this;
    }

    @Override // android.view.View
    public final void cancelLongPress() {
        super.cancelLongPress();
        long r2 = SystemClock.uptimeMillis();
        MotionEvent r0 = MotionEvent.obtain(r2, r2, 3, 0.0f, 0.0f, 0);
        getGestureDetector().onTouchEvent(r0);     // Catch: Throwable -> L8
        MovableSelectionManager r1 = this.n;     // Catch: Throwable -> L8
        if (r1 == null) goto L6;
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L8
        r1.l(r0);     // Catch: Throwable -> L8
    L6:
        r0.recycle();
        return;
    L8:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public final MovableSelectionManager.a f() {
        if (getRootMovableView().k == true) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(getRootMovableView(), this) == true) goto L11;
        MovableSelectionManager.a r0 = getRootMovableView().f();
        if (r0 == null) goto L15;
        MovableSelectionManager.a r1 = new MovableSelectionManager.a();
        HandleStyle r2 = r0.f;
        Intrinsics.checkNotNullParameter(r2, "style");
        r1.f = r2;
        r1.g = r0.g;
        return r1;
    L15:
        return null;
    L11:
        MovableSelectionManager.a r3 = this.q;
        if (r3 == null) goto L14;
        return r3;
    L14:
        return new MovableSelectionManager.a();
    }

    public final com.ss.android.lark.movable.selection.h getCopyStrategy() {
        MovableSelectionManager r0 = getRootMovableView().n;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    public List<String> getFontPrefixPathCandidates() {
        return CollectionsKt.emptyList();
    }

    public final float getMovableDocumentHeight() {
        MovableDocumentInfo r0 = getMovableDocumentInfo();
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.getHeight();
    }

    public final MovableDocumentInfo getMovableDocumentInfo() {
        return getRootMovableView().t;
    }

    public final int getMovableInstanceId$movable_release() {
        return getRootMovableView().getInstanceId();
    }

    public final String getSelectedMarkdownText() {
        MovableDocumentInfo r0 = getMovableDocumentInfo();
        if (r0 != null) goto L5;
        return null;
    L5:
        String r1 = Lark_markdown_renderKt.ffiMovableGetMarkdownFromRange-feOb9K0(r0.getDocumentId-pVg5ArA(), r0.getDocumentVersion-pVg5ArA());
        if (r1.length() <= 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        return null;
    L11:
        return r1;
    L8:
        r2 = false;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.y == false) goto L6;
        e();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        if (Intrinsics.areEqual(getRootMovableView(), this) == false) goto L5;
        MovableGlobalManager.d.a().e(getMovableInstanceId$movable_release());
    L5:
        BuildersKt.launch$default(this.g, null, null, new AnonymousClass1(this, null), 3, null);
        super.onDetachedFromWindow();
    }

    public final com.ss.android.lark.movable.b getEventClickListener$movable_release() {
        return this.u;
    }

    public final p getImageLoader$movable_release() {
        return this.v;
    }

    public final ScrollIsland getParentIsland$movable_release() {
        return this.r;
    }

    public final MovableSelectionManager getSelectionManager$movable_release() {
        return this.n;
    }

    @Override // com.ss.android.lark.movable.OverflowClipContainer
    public final boolean a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "child");
        if ((r3 instanceof com.ss.android.lark.movable.selection.d) == false) goto L5;
        return true;
    L5:
        if (this.k == true) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L15;
        return false;
    L15:
        return true;
    L7:
        if (this.l == false) goto L9;
        r4 = true;
        goto L10
    }

    public void b(b r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        this.v = r3.a;
        com.ss.android.lark.movable.b r0 = r3.b;
        if (r0 != null) goto L5;
        r0 = new com.ss.android.lark.movable.a();
    L5:
        this.u = r0;
        this.k = r3.c;
        this.q = r3.d;
        this.c.a = null;
        this.z = r3.e;
        this.w = r3.f;
        if (getWidth() <= 0) goto L10;
        Function2<? super Integer, ? super Integer, Unit> r4 = this.z;
        if (r4 == null) goto L10;
        r4.invoke(Integer.valueOf(getWidth()), 0);
    L10:
        this.y = true;
        e();
    }

    public final void g(byte[] r5) {
        if (Arrays.equals(this.d, r5) == false) goto L6;
        Log.i("MovableView", "received empty attachment render data, ignore");
        return;
    L6:
        this.d = r5;
        List r0 = SequencesKt.toList(SequencesKt.filter(ViewGroupKt.getChildren(this), MovableView$removeAttachment$1.INSTANCE));
        Log.i("MovableView", "remove all Attachment, size: " + r0.size());
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        removeView((View) r1.next());
        goto L8
    L10:
        this.c.b(this, r5);
    }

    public final void h(boolean r14) {
        Integer r0 = null;
        if (r14 == true) goto L9;
        com.ss.android.lark.movable.c r15 = this.p;
        if (r15 == null) goto L7;
        r15.a();
    L7:
        this.p = null;
        return;
    L9:
        MovableDocumentInfo r16 = this.t;
        if (r16 != null) goto L102;
        List r17 = null;
    L23:
        if (r17 != null) goto L25;
    L97:
        com.ss.android.lark.movable.c r18 = this.p;
        if (r18 == null) goto L100;
        r18.a();
    L100:
        this.p = null;
        return;
    L25:
        if (r17.size() < 4) goto L97;
        float r4 = com.ss.android.lark.movable.utils.b.d(((Number) ListProtector.get(r17, 0)).floatValue(), getContext());
        boolean r5 = true;
        float r6 = com.ss.android.lark.movable.utils.b.d(((Number) ListProtector.get(r17, 1)).floatValue(), getContext());
        float r8 = com.ss.android.lark.movable.utils.b.d(((Number) ListProtector.get(r17, 2)).floatValue(), getContext());
        float r19 = com.ss.android.lark.movable.utils.b.d(((Number) ListProtector.get(r17, 3)).floatValue(), getContext());
        if (this.p != null) goto L37;
        com.ss.android.lark.movable.c r10 = new com.ss.android.lark.movable.c(getContext());
        this.p = r10;
        Intrinsics.checkNotNullParameter(this, "parent");
        addView(r10);
        r10.setAlpha(1.0f);
        ObjectAnimator r11 = r10.c;
        if (r11 != null) goto L31;
    L33:
        boolean r12 = false;
    L34:
        if (r12 == true) goto L37;
        ObjectAnimator r9 = ObjectAnimator.ofFloat(r10, "alpha", new float[]{1.0f, 0.0f, 1.0f});
        r9.setDuration(1200);
        r9.setRepeatCount(-1);
        r9.setInterpolator(new LinearInterpolator());
        r9.start();
        r10.c = r9;
        goto L37
    L31:
        if (r11.isRunning() != true) goto L33;
        r12 = true;
    L37:
        float r7 = (r4 + r8) + com.ss.android.lark.movable.utils.b.e(4, getContext());
        float r3 = 2;
        float r13 = r6 + (r19 / r3);
        com.ss.android.lark.movable.c r110 = this.p;
        if (r110 == null) goto L40;
        float r111 = r110.getRadius();
    L41:
        float r20 = r13 - r111;
        Log.d("MovableView", "loadingViewX: " + r7 + ", loadingViewCenterY: " + r20);
        com.ss.android.lark.movable.c r112 = this.p;
        float r1 = (float) getWidth();
        float r21 = (float) getHeight();
        if (r112 == null) goto L52;
        Integer r22 = Integer.valueOf(r112.getMeasuredWidth());
        if (r22.intValue() <= 0) goto L46;
        boolean r113 = true;
    L47:
        if (r113 == true) goto L50;
        r22 = null;
    L50:
        if (r22 == null) goto L52;
        float r23 = r22.intValue();
    L56:
        if (r112 == null) goto L65;
        Integer r114 = Integer.valueOf(r112.getMeasuredHeight());
        if (r114.intValue() <= 0) goto L60;
        boolean r115 = true;
    L61:
        if (r115 == false) goto L63;
        r0 = r114;
    L63:
        if (r0 == null) goto L65;
        float r2 = r0.intValue();
    L70:
        if (r1 > 0.0f) goto L72;
    L87:
        if (r5 == false) goto L91;
        if (r112 == null) goto L104;
        r112.setVisibility(8);
        return;
    L104:
        return;
    L91:
        if (r112 == null) goto L93;
        r112.setVisibility(0);
    L93:
        if (r112 == null) goto L95;
        r112.setTranslationX(r7);
    L95:
        if (r112 == null) goto L105;
        r112.setTranslationY(r20);
        return;
    L105:
        return;
    L72:
        if (r21 <= 0.0f) goto L87;
        if (r23 <= 0.0f) goto L87;
        if (r2 <= 0.0f) goto L87;
        if (r7 < 0.0f) goto L87;
        if (r20 < 0.0f) goto L87;
        if ((r23 + r7) > r1) goto L87;
        if ((r2 + r20) > r21) goto L87;
        r5 = false;
        goto L87
    L60:
        r115 = false;
    L65:
        if (r112 == null) goto L67;
        float r24 = r112.getRadius();
    L68:
        r2 = r24 * r3;
        goto L70
    L67:
        r24 = 0.0f;
        goto L68
    L46:
        r113 = false;
    L52:
        if (r112 == null) goto L54;
        float r25 = r112.getRadius();
    L55:
        r23 = r25 * r3;
        goto L56
    L54:
        r25 = 0.0f;
        goto L55
    L40:
        r111 = 0.0f;
        goto L41
    L102:
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L13
        Object r116 = Result.constructor-impl(Lark_markdown_renderKt.ffiGetTailElement-feOb9K0(r16.getDocumentId-pVg5ArA(), r16.getDocumentVersion-pVg5ArA()));     // Catch: Throwable -> L13
    L15:
        Throwable r27 = Result.exceptionOrNull-impl(r116);
        if (r27 == null) goto L19;
        Log.e("MovableView", "ffiGetTailElement failed: " + r27.getMessage());
    L19:
        if (Result.isFailure-impl(r116) == false) goto L21;
        r116 = null;
    L21:
        r17 = (List) r116;
    L13:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r116 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        boolean r0 = getGestureDetector().onTouchEvent(r5);
        if (this.k == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L15;
        if (r0 == false) goto L11;
        return true;
    L11:
        if (super.onTouchEvent(r5) == true) goto L27;
        return false;
    L27:
        return true;
    L15:
        MovableSelectionManager r2 = this.n;
        if (r2 == null) goto L18;
        r2.l(r5);
        boolean r3 = true;
    L19:
        if (r0 == true) goto L28;
        if (r3 == false) goto L22;
        return true;
    L22:
        if (super.onTouchEvent(r5) == true) goto L30;
        return false;
    L30:
        return true;
    L28:
        return true;
    L18:
        r3 = false;
        goto L19
    L5:
        if (this.l == false) goto L7;
        r1 = true;
        goto L8
    }

    public final void setEventClickListener$movable_release(com.ss.android.lark.movable.b r1) {
        this.u = r1;
    }

    public final void setImageLoader$movable_release(p r1) {
        this.v = r1;
    }

    public final void setParentIsland$movable_release(ScrollIsland r1) {
        this.r = r1;
    }

    public final void setSelectionManager$movable_release(MovableSelectionManager r1) {
        this.n = r1;
    }

    public void setup(Function1<? super b, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        b r0 = new b();
        r2.invoke(r0);
        setupWithConfig(r0);
    }

    public final void setupWithConfig(b r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        if (this.x == false) goto L5;
        return;
    L5:
        b(r2);
        this.x = true;
        MovableGlobalManager.d.a().c(getMovableInstanceId$movable_release(), this);
    }

    public MovableView(final Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.b = LazyKt.lazy(MovableView$instanceId$2.INSTANCE);
        this.c = new MovableAttachmentApplier();
        this.g = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        if (Build.VERSION.SDK_INT < 31) goto L5;
        boolean r5 = true;
    L6:
        this.i = r5;
        ksb.b r0 = new ksb.b(r3);
        r0.setEnableDrawGlyphs(r5);
        this.j = r0;
        this.k = true;
        this.l = true;
        this.m = new LinkedHashMap();
        this.o = LazyKt.lazy(new MovableView$gestureDetector$2(r3, this));
        return;
    L5:
        r5 = false;
        goto L6
    }

    /* JADX INFO: renamed from: getScrollIslandScrollOffset-feOb9K0, reason: not valid java name */
    public final List<Float> m1470getScrollIslandScrollOffsetfeOb9K0(int r3, int r4) {
        Log.d("native_get_scroll_island_scroll_offset", "getScrollIslandScrollOffset() called");
        Float[] r5 = new Float[2];
        ScrollIsland r6 = (ScrollIsland) ((LinkedHashMap) this.m).get(Integer.valueOf(r4));
        if (r6 == null) goto L5;
        float r7 = com.ss.android.lark.movable.utils.b.g(r6.getScrollX(), getContext());
    L6:
        r5[0] = Float.valueOf(r7);
        r5[1] = Float.valueOf(0.0f);
        return CollectionsKt.listOf(r5);
    L5:
        r7 = 0.0f;
        goto L6
    }

    public final void i(byte[] r14, MovableDocumentInfo r15) {
        Intrinsics.checkNotNullParameter(r14, "data");
        boolean r1 = true;
        if (r14.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        if (Arrays.equals(this.e, r14) == false) goto L11;
        return;
    L11:
        Log.d("MovableView", "updateTextRender called, data size: " + r14.length);
        this.e = r14;
        if (indexOfChild(this.j) == (-1)) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L17;
    L38:
        this.j.a(r14, r15);
        return;
    L17:
        if (indexOfChild(this.j) != (-1)) goto L20;
        r1 = false;
    L20:
        if (r1 == true) goto L38;
        addView(this.j, new FrameLayout.LayoutParams(-1, -1));
        ksb.b r3 = this.j;
        if (getWidth() > 0) goto L25;
    L28:
        MovableSelectionManager.a r4 = f();
        if (r4 == null) goto L35;
        Intrinsics.checkNotNullParameter(this, "movableView");
        com.ss.android.lark.movable.selection.h r5 = r4.a;
        com.ss.android.lark.movable.selection.g r6 = r4.b;
        boolean r7 = r4.c;
        boolean r8 = r4.d;
        MovableLongPressBehavior r9 = r4.e;
        HandleStyle r10 = r4.f;
        Integer r11 = r4.g;
        if (r11 == null) goto L33;
        int r12 = r11.intValue();
    L34:
        MovableSelectionManager r13 = new MovableSelectionManager(this, r5, r6, r7, r8, r9, r10, r12, r4.h, r4.i);
    L36:
        if (r13 == null) goto L38;
        this.n = r13;
        goto L38
    L33:
        r12 = UIUtils.getColor(getContext(), 2131105548);
        goto L34
    L35:
        r13 = null;
        goto L36
    L25:
        if (getHeight() <= 0) goto L28;
        r3.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        r3.layout(0, 0, getWidth(), getHeight());
        goto L28
    L14:
        r2 = false;
        goto L15
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        int r0 = getLayoutParams().width;
        int r1 = getLayoutParams().height;
        if (r0 >= 0) goto L6;
        r0 = FrameLayout.resolveSize(0, r4);
    L6:
        if (r1 >= 0) goto L9;
        r1 = FrameLayout.resolveSize(0, r5);
    L9:
        setMeasuredDimension(r0, r1);
        int r6 = View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
        int r7 = View.MeasureSpec.makeMeasureSpec(r1, 1073741824);
        Iterator r2 = ViewGroupKt.getChildren(this).iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        measureChild((View) r2.next(), r6, r7);
        goto L11
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "changedView");
        super.onVisibilityChanged(r7, r8);
        if (isShown() == true) goto L6;
        BuildersKt.launch$default(this.g, null, null, new C04411(this, null), 3, null);
        return;
    }

    /* JADX INFO: renamed from: eventClick-OzbTU-A, reason: not valid java name */
    public final void m1469eventClickOzbTUA(int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "schema");
        Intrinsics.checkNotNullParameter(r5, "payload");
        com.ss.android.lark.movable.b r0 = this.u;
        if (r0 == null) goto L6;
        r0.d(getContext(), r3, r4, r5);
        return;
    }

    /* JADX INFO: renamed from: measureAttachment-OzbTU-A, reason: not valid java name */
    public final List<Float> m1472measureAttachmentOzbTUA(int r1, float r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "propertyString");
        return CollectionsKt.emptyList();
    }

    public final void c(c r8, List<Pair<Integer, byte[]>> r9, boolean r10, List<? extends Pair<? extends MovableIslandsOpsApplier.Op, jsb.a>> r11) {
        if (r10 == false) goto L53;
        List r12 = SequencesKt.toList(SequencesKt.filter(ViewGroupKt.getChildren(this), MovableView$removeScrollIsland$1.INSTANCE));
        Log.d("MovableView", "remove all ScrollIsland, size: " + r12.size());
        Iterator r13 = r12.iterator();
    L4:
        Integer r2 = null;
        if (r13.hasNext() == false) goto L13;
        View r0 = (View) r13.next();
        removeView(r0);
        Map<Integer, ScrollIsland> r3 = this.m;
        if ((r0 instanceof ScrollIsland) == false) goto L9;
        ScrollIsland r1 = (ScrollIsland) r0;
    L10:
        if (r1 == null) goto L12;
        r2 = Integer.valueOf(r1.getIslandID());
    L12:
        TypeIntrinsics.asMutableMap(r3).remove(r2);
        goto L4
    L9:
        r1 = null;
        goto L10
    L13:
        List<? extends Pair<? extends MovableIslandsOpsApplier.Op, jsb.a>> r14 = r11;
        if (r14 != null) goto L16;
    L19:
        boolean r15 = true;
    L20:
        if (r15 == true) goto L41;
        MovableIslandsOpsApplier r16 = new MovableIslandsOpsApplier(this, new g(this));
        Intrinsics.checkNotNullParameter(r11, "ops");
        Iterator<T> r17 = r11.iterator();
    L24:
        if (r17.hasNext() == false) goto L41;
        Pair r4 = (Pair) r17.next();
        MovableIslandsOpsApplier.Op r5 = (MovableIslandsOpsApplier.Op) r4.component1();
        jsb.a r6 = (jsb.a) r4.component2();
        int r7 = MovableIslandsOpsApplier.c.a[r5.ordinal()];
        if (r7 != 1) goto L28;
        r16.a(r16.a, r6);
        goto L24
    L28:
        if (r7 != 2) goto L30;
        MovableView r18 = r16.a;
        int r19 = r6.a;
        ScrollIsland r20 = (ScrollIsland) r18.findViewWithTag(Integer.valueOf(r19));
        if (r20 == null) goto L24;
        r18.removeView(r20);
        r16.b.b(r19);
        Log.d("MovableIslandsOpsApplier", "remove island islandID=" + r19);
        goto L24
    L30:
        if (r7 != 3) goto L36;
        MovableView r21 = r16.a;
        ScrollIsland r22 = (ScrollIsland) r21.findViewWithTag(Integer.valueOf(r6.a));
        if (r22 != null) goto L33;
        r16.a(r21, r6);
        Log.d("MovableIslandsOpsApplier", "update island new, islandID=" + r6.a);
        goto L24
    L33:
        r22.a(r6);
        Log.d("MovableIslandsOpsApplier", "update island islandID=" + r6.a);
        goto L24
    L36:
        throw new NoWhenBranchMatchedException();
    L41:
        Iterator<Pair<Integer, byte[]>> r23 = r9.iterator();
    L43:
        if (r23.hasNext() == false) goto L82;
        Pair<Integer, byte[]> r110 = r23.next();
        int r111 = ((Number) r110.component1()).intValue();
        byte[] r112 = (byte[]) r110.component2();
        if (r112 == null) goto L43;
        ScrollIsland r24 = (ScrollIsland) ((LinkedHashMap) this.m).get(Integer.valueOf(r111));
        if (r24 == null) goto L48;
        Log.i("MovableView", "islandData content render, islandID: " + r111 + ", docInfo: " + r8.b.toString() + ", islandRenderDataSize: " + r112.length);     // Catch: Exception -> L51
        Intrinsics.checkNotNullParameter(r112, "renderData");     // Catch: Exception -> L51
        r24.b.i(r112, null);     // Catch: Exception -> L51
    L51:
        e = move-exception;
        Log.e("MovableView", "Failed to render island " + r111 + ": " + e.getMessage(), e);
        goto L43
    L48:
        Log.w("MovableView", "island " + r111 + " disappeared before apply");
        goto L43
    L82:
        return;
    L16:
        if (r14.isEmpty() == true) goto L19;
        r15 = false;
        goto L20
    }

    @Override // android.view.View
    public final void onSizeChanged(int r3, int r4, int r5, int r6) {
        super.onSizeChanged(r3, r4, r5, r6);
        Log.i("MovableView", "onSizeChanged, w:" + r3 + ", h:" + r4 + ", oldw:" + r5 + ", oldh:" + r6);
        if (r3 == r5) goto L7;
        Function2<? super Integer, ? super Integer, Unit> r7 = this.z;
        if (r7 == null) goto L7;
        r7.invoke(Integer.valueOf(r3), Integer.valueOf(r5));
    L7:
        if (r5 <= 0) goto L23;
        if (r3 == r5) goto L24;
        MovableSelectionManager r8 = this.n;     // Catch: Exception -> L18
        if (r8 == null) goto L13;
        r8.d();     // Catch: Exception -> L18
    L13:
        if (Intrinsics.areEqual(getRootMovableView(), this) == true) goto L25;
        MovableSelectionManager r9 = getRootMovableView().n;     // Catch: Exception -> L18
        if (r9 == null) goto L26;
        r9.d();     // Catch: Exception -> L18
        return;
    L26:
        return;
    L25:
        return;
    L18:
        e = move-exception;
        Log.w("MovableView", "clearSelection on width changed failed: " + e.getMessage());
        return;
    L24:
        return;
    }

    /* JADX INFO: renamed from: markHighlightUpdate-iyaXS9w, reason: not valid java name */
    public final void m1471markHighlightUpdateiyaXS9w(int r11, float r12, float r13, float r14, float r15) {
        MovableSelectionManager r16 = this.n;
        if (r16 == null) goto L83;
        ksb.b r17 = r16.o;
        byte[] r18 = Lark_markdown_renderKt.ffiGetHighlightStream-feOb9K0(r16.g(), r16.h());
        LruCache<String, byte[]> r19 = ksb.b.f;
        r17.a(r18, null);
        Iterator<T> r110 = r16.a.getInnerMovableViews().iterator();
    L5:
        int r111 = 0;
        if (r110.hasNext() == false) goto L15;
        MovableView r112 = (MovableView) r110.next();
        MovableSelectionManager r0 = r112.getSelectionManager$movable_release();
        if (r0 == null) goto L5;
        ksb.b r1 = r0.o;
        if (r1 == null) goto L5;
        ScrollIsland r113 = r112.getParentIsland$movable_release();
        if (r113 == null) goto L14;
        r111 = UInt.constructor-impl(r113.getIslandID());
    L14:
        r1.a(Lark_markdown_renderKt.ffiRequestIslandHighlightStream-zly0blg(r111, r16.g(), r16.h()), null);
        goto L5
    L15:
        List r114 = Lark_markdown_renderKt.ffiMovableRequestCarets-zly0blg(r16.i(), r16.g(), r16.h());
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator r116 = r114.iterator();
    L17:
        if (r116.hasNext() == false) goto L19;
        FfiCaret r2 = (FfiCaret) r116.next();
        Context r3 = r16.n;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "context");
        r115.add(FfiCaret.copy-rhtGY3M$default(r2, com.ss.android.lark.movable.utils.b.d(r2.getX(), r3), com.ss.android.lark.movable.utils.b.d(r2.getY(), r3), com.ss.android.lark.movable.utils.b.d(r2.getHeight(), r3), false, 0, 0, 56, null));
        goto L17
    L19:
        Iterator r117 = r115.iterator();
    L21:
        if (r117.hasNext() == false) goto L25;
        Object r4 = r117.next();
        if ((!((FfiCaret) r4).getDirection()) == false) goto L21;
    L26:
        FfiCaret r5 = (FfiCaret) r4;
        int r118 = r16.i();
        if (r5 == null) goto L29;
        UInt r6 = UInt.box-impl(r5.getCanvasId-pVg5ArA());
    L31:
        if (UInt.equals-impl(r118, r6) == false) goto L33;
        FfiCaret r119 = r5;
    L34:
        r16.o(true, r119);
        Iterator<T> r120 = r16.a.getInnerMovableViews().iterator();
    L36:
        if (r120.hasNext() == false) goto L51;
        MovableView r7 = (MovableView) r120.next();
        MovableSelectionManager r8 = r7.getSelectionManager$movable_release();
        if (r8 == null) goto L36;
        ScrollIsland r9 = r7.getParentIsland$movable_release();
        if (r9 == null) goto L42;
        UInt r10 = UInt.box-impl(UInt.constructor-impl(r9.getIslandID()));
    L43:
        if (r5 == null) goto L45;
        UInt r20 = UInt.box-impl(r5.getCanvasId-pVg5ArA());
    L47:
        if (Intrinsics.areEqual(r10, r20) == false) goto L49;
        FfiCaret r21 = r5;
    L50:
        r8.o(true, r21);
        goto L36
    L49:
        r21 = null;
        goto L50
    L45:
        r20 = null;
        goto L47
    L42:
        r10 = null;
        goto L43
    L51:
        Iterator r121 = r115.iterator();
    L53:
        if (r121.hasNext() == false) goto L57;
        Object r122 = r121.next();
        if (((FfiCaret) r122).getDirection() == false) goto L53;
    L58:
        FfiCaret r123 = (FfiCaret) r122;
        int r124 = r16.i();
        if (r123 == null) goto L61;
        UInt r22 = UInt.box-impl(r123.getCanvasId-pVg5ArA());
    L63:
        if (UInt.equals-impl(r124, r22) == false) goto L65;
        FfiCaret r125 = r123;
    L66:
        r16.o(false, r125);
        Iterator<T> r126 = r16.a.getInnerMovableViews().iterator();
    L68:
        if (r126.hasNext() == false) goto L108;
        MovableView r127 = (MovableView) r126.next();
        MovableSelectionManager r23 = r127.getSelectionManager$movable_release();
        if (r23 == null) goto L68;
        ScrollIsland r128 = r127.getParentIsland$movable_release();
        if (r128 == null) goto L74;
        UInt r129 = UInt.box-impl(UInt.constructor-impl(r128.getIslandID()));
    L75:
        if (r123 == null) goto L77;
        UInt r24 = UInt.box-impl(r123.getCanvasId-pVg5ArA());
    L79:
        if (Intrinsics.areEqual(r129, r24) == false) goto L81;
        FfiCaret r130 = r123;
    L82:
        r23.o(false, r130);
        goto L68
    L81:
        r130 = null;
        goto L82
    L77:
        r24 = null;
        goto L79
    L74:
        r129 = null;
        goto L75
    L108:
        return;
    L65:
        r125 = null;
        goto L66
    L61:
        r22 = null;
        goto L63
    L57:
        r122 = null;
        goto L58
    L33:
        r119 = null;
        goto L34
    L29:
        r6 = null;
        goto L31
    L25:
        r4 = null;
        goto L26
    }
}
