package com.obric.assistant.interaction.impl.window.landscape.childwindow;

import android.R;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.interaction.impl.window.AssistantChatDialog;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.WindowHost;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0010¤\u0001¥\u0001¦\u0001§\u0001¨\u0001©\u0001ª\u0001«\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u00104\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\f2\u0006\u00105\u001a\u00020\u0005H\u0007J\u001a\u00106\u001a\u0002072\b\u00103\u001a\u0004\u0018\u00010\f2\u0006\u00105\u001a\u00020\u0005H\u0002J\u0012\u00108\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u00109\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\fH\u0007J\r\u0010:\u001a\u000202H\u0000¢\u0006\u0002\b;J\r\u0010<\u001a\u00020\u0007H\u0000¢\u0006\u0002\b=J\u0015\u0010>\u001a\u0002022\u0006\u00103\u001a\u00020\fH\u0000¢\u0006\u0002\b?J\u0015\u0010@\u001a\u0002022\u0006\u00103\u001a\u00020\fH\u0000¢\u0006\u0002\bAJ\u001d\u0010B\u001a\u0002022\u0006\u00103\u001a\u00020\f2\u0006\u0010C\u001a\u00020\u0007H\u0000¢\u0006\u0002\bDJ#\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010F2\u0006\u00103\u001a\u00020\fH\u0000¢\u0006\u0002\bGJ\u0015\u0010H\u001a\u00020\u00122\u0006\u00103\u001a\u00020\fH\u0000¢\u0006\u0002\bIJ\u0012\u0010J\u001a\u0004\u0018\u00010\u001c2\u0006\u00103\u001a\u00020\fH\u0002J\"\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020.2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u001cH\u0002J\u0018\u0010Q\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u001c2\u0006\u0010R\u001a\u00020\u0007H\u0002J\u0017\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010VJ \u0010W\u001a\u00020\u00072\u0006\u0010M\u001a\u00020.2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u001cH\u0002J)\u0010X\u001a\u0004\u0018\u00010\u00072\b\u0010Y\u001a\u0004\u0018\u00010!2\u0006\u0010Z\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\\J\u0018\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u0007H\u0002J\u0018\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u0007H\u0002J\u0018\u0010c\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010e\u001a\u00020\u0005H\u0002J\u0010\u0010f\u001a\u0002022\u0006\u0010d\u001a\u00020\rH\u0002J\u0010\u0010g\u001a\u0002022\u0006\u0010d\u001a\u00020\rH\u0002J\u0018\u0010h\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010e\u001a\u00020\u0005H\u0002J0\u0010i\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'2\u0006\u0010e\u001a\u00020\u0005H\u0002J0\u0010l\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'2\u0006\u0010e\u001a\u00020\u0005H\u0002J0\u0010m\u001a\u00020\u00122\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'2\u0006\u0010e\u001a\u00020\u0005H\u0002J0\u0010n\u001a\u00020\u00122\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'2\u0006\u0010e\u001a\u00020\u0005H\u0002J2\u0010o\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'2\b\b\u0002\u0010p\u001a\u00020\u0012H\u0002J0\u0010q\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020!0'2\b\b\u0002\u0010p\u001a\u00020\u0012H\u0002J(\u0010r\u001a\u00020\u00122\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'H\u0002J(\u0010s\u001a\u00020\u00122\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'H\u0002J*\u0010t\u001a\u0004\u0018\u00010u2\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'H\u0002J(\u0010v\u001a\u0004\u0018\u00010u2\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020!0'H\u0002J\u0018\u0010w\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u001c2\u0006\u0010x\u001a\u00020\u001cH\u0002J.\u0010y\u001a\u00020\u00122\u0006\u0010x\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020\u001c2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020!0'2\u0006\u0010z\u001a\u00020\u0007H\u0002J\u0018\u0010{\u001a\u00020\u00072\u0006\u0010j\u001a\u00020!2\u0006\u0010P\u001a\u00020\u001cH\u0002J \u0010|\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020!2\u0006\u0010}\u001a\u00020\u00072\u0006\u0010~\u001a\u00020\u0007H\u0002J\u0012\u0010\u007f\u001a\u0004\u0018\u00010u2\u0006\u0010j\u001a\u00020!H\u0002J\u0019\u0010\u0080\u0001\u001a\u00020\u00122\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!H\u0002J)\u0010\u0081\u0001\u001a\u00020\u00122\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'H\u0002J\u0019\u0010\u0082\u0001\u001a\u00020\u00122\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'H\u0002J\u0019\u0010\u0083\u0001\u001a\u00020\u00122\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'H\u0002J\u0019\u0010\u0083\u0001\u001a\u00020\u00122\b\u0010d\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0003\u0010\u0084\u0001J\u0019\u0010\u0085\u0001\u001a\u00020\u00122\b\u0010d\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0003\u0010\u0084\u0001J\u0011\u0010\u0086\u0001\u001a\u00020\u00122\u0006\u0010e\u001a\u00020\u0005H\u0002J!\u0010\u0087\u0001\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010'2\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!H\u0002J!\u0010\u0088\u0001\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u0006\u0010e\u001a\u00020\u0005H\u0002J\u0019\u0010\u0089\u0001\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!H\u0002J\u001f\u0010\u008a\u0001\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020!0'H\u0002J\u0019\u0010\u008b\u0001\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010e\u001a\u00020\u0005H\u0002J\u0019\u0010\u008c\u0001\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010e\u001a\u00020\u0005H\u0002J!\u0010\u008d\u0001\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\u0006\u0010j\u001a\u00020!2\u0006\u0010e\u001a\u00020\u0005H\u0002J%\u0010\u008e\u0001\u001a\u0002022\u0006\u0010j\u001a\u00020!2\u0007\u0010\u008f\u0001\u001a\u00020\u00072\t\b\u0002\u0010\u0090\u0001\u001a\u00020\u0012H\u0002J\u001f\u0010\u0091\u0001\u001a\u0002022\f\u0010k\u001a\b\u0012\u0004\u0012\u00020!0'2\u0006\u0010~\u001a\u00020\u0007H\u0002J \u0010\u0092\u0001\u001a\u0002022\f\u0010k\u001a\b\u0012\u0004\u0012\u00020!0'2\u0007\u0010\u0093\u0001\u001a\u00020\u0007H\u0002J\u001b\u0010\u0094\u0001\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0002J\u001b\u0010\u0097\u0001\u001a\u0002022\u0006\u0010d\u001a\u00020\r2\b\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0002J\u001a\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0096\u00012\f\u0010k\u001a\b\u0012\u0004\u0012\u00020!0'H\u0002J\u0013\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u001c2\u0006\u0010Y\u001a\u00020!H\u0002J\u0019\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00072\u0006\u0010M\u001a\u00020.H\u0002¢\u0006\u0003\u0010\u009b\u0001J\u0019\u0010\u009c\u0001\u001a\u00020\u00122\u0006\u00103\u001a\u00020\f2\u0006\u00105\u001a\u00020\u0005H\u0002J\u0011\u0010\u009d\u0001\u001a\u00020\u00122\u0006\u00103\u001a\u00020\fH\u0002J\"\u0010\u009e\u0001\u001a\u00020\u00122\u000e\u0010\u009f\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010 \u00012\u0007\u0010¡\u0001\u001a\u00020\u0005H\u0002J\u000e\u0010¢\u0001\u001a\u00020\u0012*\u00030£\u0001H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\"\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R(\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010!0 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R.\u0010&\u001a\u0016\u0012\u0004\u0012\u00020!\u0012\f\u0012\n\u0012\u0004\u0012\u00020!\u0018\u00010'0 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R(\u0010*\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010\u001c0 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010#\"\u0004\b,\u0010%R(\u0010-\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0006\u0012\u0004\u0018\u00010\u00070 X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010#\"\u0004\b0\u0010%¨\u0006¬\u0001"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter;", "", "<init>", "()V", "TAG", "", "UNSET_TOP", "", "WARM_UP_SAMPLE_LIMIT", "DRIFT_THRESHOLD_PX", "states", "Ljava/util/WeakHashMap;", "Landroid/app/Dialog;", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$BoundsState;", "preAddViewBoundsSessions", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$PreAddViewBoundsSession;", "landscapeRestrictionActiveResolver", "Lkotlin/Function0;", "", "getLandscapeRestrictionActiveResolver$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function0;", "setLandscapeRestrictionActiveResolver$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function0;)V", "windowTokenResolver", "Landroid/os/IBinder;", "getWindowTokenResolver$impl_mainlandRelease", "setWindowTokenResolver$impl_mainlandRelease", "hostVisibleBoundsResolver", "Landroid/graphics/Rect;", "getHostVisibleBoundsResolver$impl_mainlandRelease", "setHostVisibleBoundsResolver$impl_mainlandRelease", "bottomSheetViewResolver", "Lkotlin/Function1;", "Landroid/view/View;", "getBottomSheetViewResolver$impl_mainlandRelease", "()Lkotlin/jvm/functions/Function1;", "setBottomSheetViewResolver$impl_mainlandRelease", "(Lkotlin/jvm/functions/Function1;)V", "bottomSheetBehaviorResolver", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "getBottomSheetBehaviorResolver$impl_mainlandRelease", "setBottomSheetBehaviorResolver$impl_mainlandRelease", "viewGlobalVisibleRectResolver", "getViewGlobalVisibleRectResolver$impl_mainlandRelease", "setViewGlobalVisibleRectResolver$impl_mainlandRelease", "screenWidthResolver", "Landroid/view/Window;", "getScreenWidthResolver$impl_mainlandRelease", "setScreenWidthResolver$impl_mainlandRelease", "beginPreAddViewBoundsSession", "", "dialog", "onDialogPreAddView", WindowEvent.Params.TRIGGER, "applyPreAddViewBounds", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$PreAddViewBoundsApplyResult;", "onDialogShown", "onDialogDismissed", "clearForTest", "clearForTest$impl_mainlandRelease", "trackedStateCountForTest", "trackedStateCountForTest$impl_mainlandRelease", "restoreStableBoundsForTest", "restoreStableBoundsForTest$impl_mainlandRelease", "sampleAndRestoreForTest", "sampleAndRestoreForTest$impl_mainlandRelease", "dispatchStateForTest", "newState", "dispatchStateForTest$impl_mainlandRelease", "stableBoundsForTest", "Lkotlin/Pair;", "stableBoundsForTest$impl_mainlandRelease", "hasBehaviorCallbackForTest", "hasBehaviorCallbackForTest$impl_mainlandRelease", "resolveTargetChildDialogHostBounds", "resolveOnStartHorizontalBounds", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$HorizontalBounds;", "window", "attrs", "Landroid/view/WindowManager$LayoutParams;", "hostBounds", "resolveHostCenterOffset", "screenWidth", "resolveSizeRequestMode", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode;", "size", "(Ljava/lang/Integer;)Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode;", "measureWrapContentWidth", "measureViewWidth", "view", "widthSpec", "heightSpec", "(Landroid/view/View;II)Ljava/lang/Integer;", "resolveMeasureHeight", "height", "hostHeight", "replaceHorizontalGravityPreservingVertical", "originalGravity", "horizontalGravity", "postSampleAndRestore", "state", WindowEvent.Params.REASON, "installStableListeners", "removeSheetPreDrawListener", "sampleAndRestoreStableBounds", "sampleStableBounds", "sheet", "behavior", "refreshStableBehavior", "installOrRefreshSettledFullHeightTarget", "installOrRefreshOverflowFitToHostTarget", "applyFullHeightExpandedParams", "forceExpandedState", "applyOverflowFitToHostParams", "shouldApplyFullHeightExpandedParams", "shouldPromoteCurrentLayoutToFullHeight", "resolveSettledFullHeightTarget", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$StableSheetTarget;", "resolveOverflowFitToHostTarget", "resolveOverflowFitTargetBottom", "sheetRect", "canExpandOverflowSheet", "targetHeight", "resolveBottomSheetDesiredContentHeight", "measureViewDesiredHeight", "width", "maxHeight", "resolveSettledSheetStableTarget", "hasFullHeightRequest", "hasFullHeightExpandedIntent", "isExpandedOrSkipCollapsed", "isUnsettledBottomSheetState", "(Ljava/lang/Integer;)Z", "isHiddenBottomSheetState", "isLayoutSamplingReason", "resolveBottomSheetBehavior", "updateStableBoundsFromCurrentLayout", "recordSheetLayoutRequest", "installBehaviorCallback", "restoreStableBounds", "restoreStableSheetBounds", "normalizeStableSheetBounds", "syncSheetHeight", "stableHeight", "forceRequestLayout", "setMaxHeightCompat", "setExpandedOffsetCompat", "expandedOffset", "setBottomSheetCallback", "callback", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "clearBottomSheetCallback", "getSingleBottomSheetCallback", "resolveGlobalVisibleRect", "resolveScreenWidth", "(Landroid/view/Window;)Ljava/lang/Integer;", "shouldDeferToBottomSheetOnStart", "isMaterialBottomSheetDialog", "isClassOrSuperclassNamed", "type", "Ljava/lang/Class;", "className", "isStrongStableMode", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$BottomSheetStableMode;", "CallbackInstallMode", "BottomSheetStableMode", "SizeRequestMode", "HorizontalBounds", "StableSheetTarget", "PreAddViewBoundsSession", "PreAddViewBoundsApplyResult", "BoundsState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LandscapeChildDialogBoundsAdapter {
    private static final int DRIFT_THRESHOLD_PX = 1;
    public static final LandscapeChildDialogBoundsAdapter INSTANCE = null;
    private static final String TAG = "LandscapeChildDialogBounds";
    private static final int UNSET_TOP = Integer.MIN_VALUE;
    private static final int WARM_UP_SAMPLE_LIMIT = 3;
    private static Function1<? super View, ? extends BottomSheetBehavior<View>> bottomSheetBehaviorResolver;
    private static Function1<? super Dialog, ? extends View> bottomSheetViewResolver;
    private static Function0<Rect> hostVisibleBoundsResolver;
    private static Function0<Boolean> landscapeRestrictionActiveResolver;
    private static final WeakHashMap<Dialog, PreAddViewBoundsSession> preAddViewBoundsSessions = null;
    private static Function1<? super Window, Integer> screenWidthResolver;
    private static final WeakHashMap<Dialog, BoundsState> states = null;
    private static Function1<? super View, Rect> viewGlobalVisibleRectResolver;
    private static Function0<? extends IBinder> windowTokenResolver;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$BottomSheetStableMode;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "FULL_HEIGHT_EXPANDED", "OVERFLOW_FIT_TO_HOST", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BottomSheetStableMode extends Enum<BottomSheetStableMode> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ BottomSheetStableMode[] $VALUES = null;
        public static final BottomSheetStableMode FULL_HEIGHT_EXPANDED = null;
        public static final BottomSheetStableMode NONE = null;
        public static final BottomSheetStableMode OVERFLOW_FIT_TO_HOST = null;

        private static final /* synthetic */ BottomSheetStableMode[] $values() {
            return new BottomSheetStableMode[]{NONE, FULL_HEIGHT_EXPANDED, OVERFLOW_FIT_TO_HOST};
        }

        public static EnumEntries<BottomSheetStableMode> getEntries() {
            return $ENTRIES;
        }

        static {
            NONE = new BottomSheetStableMode("NONE", 0);
            FULL_HEIGHT_EXPANDED = new BottomSheetStableMode("FULL_HEIGHT_EXPANDED", 1);
            OVERFLOW_FIT_TO_HOST = new BottomSheetStableMode("OVERFLOW_FIT_TO_HOST", 2);
            BottomSheetStableMode[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static BottomSheetStableMode[] values() {
            return (BottomSheetStableMode[]) $VALUES.clone();
        }

        public static BottomSheetStableMode valueOf(String r1) {
            return (BottomSheetStableMode) r27.a.a(BottomSheetStableMode.class, r1);
        }

        private BottomSheetStableMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bC\b\u0002\u0018\u00002\u00020\u0001B\u008d\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001d\u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\b\b\u0002\u0010#\u001a\u00020\u001d\u0012\b\b\u0002\u0010$\u001a\u00020\u001d\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010/\"\u0004\b3\u00101R\u001a\u0010\r\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\u001a\u0010\u000e\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010I\"\u0004\bM\u0010KR\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001a\u0010\u001e\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010S\"\u0004\bV\u0010UR\u001a\u0010\u001f\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010S\"\u0004\bW\u0010UR\u001a\u0010 \u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010S\"\u0004\bX\u0010UR\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001a\u0010#\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010S\"\u0004\b]\u0010UR\u001a\u0010$\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010S\"\u0004\b_\u0010UR\u001e\u0010%\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010d\u001a\u0004\b`\u0010a\"\u0004\bb\u0010c¨\u0006e"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$BoundsState;", "", "dialogRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Dialog;", "decorRef", "Landroid/view/View;", "sheetRef", "hostBounds", "Landroid/graphics/Rect;", "stableGlobalTop", "", "stableLocalTop", "stableHeight", "warmUpSamples", "stableLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "preDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "preDrawObserver", "Landroid/view/ViewTreeObserver;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "behaviorCallback", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "previousBehaviorCallback", "callbackInstallMode", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$CallbackInstallMode;", "hasObservedMatchParentHeight", "", "isSamplingEnabled", "isHidden", "isRestoring", "stableMode", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$BottomSheetStableMode;", "isStableInstalled", "hasNormalizedStableBounds", "currentBehaviorState", "<init>", "(Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;Landroid/graphics/Rect;IIIILandroid/view/View$OnLayoutChangeListener;Landroid/view/ViewTreeObserver$OnPreDrawListener;Landroid/view/ViewTreeObserver;Lcom/google/android/material/bottomsheet/BottomSheetBehavior;Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$CallbackInstallMode;ZZZZLcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$BottomSheetStableMode;ZZLjava/lang/Integer;)V", "getDialogRef", "()Ljava/lang/ref/WeakReference;", "getDecorRef", "getSheetRef", "getHostBounds", "()Landroid/graphics/Rect;", "getStableGlobalTop", "()I", "setStableGlobalTop", "(I)V", "getStableLocalTop", "setStableLocalTop", "getStableHeight", "setStableHeight", "getWarmUpSamples", "setWarmUpSamples", "getStableLayoutListener", "()Landroid/view/View$OnLayoutChangeListener;", "setStableLayoutListener", "(Landroid/view/View$OnLayoutChangeListener;)V", "getPreDrawListener", "()Landroid/view/ViewTreeObserver$OnPreDrawListener;", "setPreDrawListener", "(Landroid/view/ViewTreeObserver$OnPreDrawListener;)V", "getPreDrawObserver", "()Landroid/view/ViewTreeObserver;", "setPreDrawObserver", "(Landroid/view/ViewTreeObserver;)V", "getBehavior", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "setBehavior", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior;)V", "getBehaviorCallback", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;", "setBehaviorCallback", "(Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;)V", "getPreviousBehaviorCallback", "setPreviousBehaviorCallback", "getCallbackInstallMode", "()Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$CallbackInstallMode;", "setCallbackInstallMode", "(Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$CallbackInstallMode;)V", "getHasObservedMatchParentHeight", "()Z", "setHasObservedMatchParentHeight", "(Z)V", "setSamplingEnabled", "setHidden", "setRestoring", "getStableMode", "()Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$BottomSheetStableMode;", "setStableMode", "(Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$BottomSheetStableMode;)V", "setStableInstalled", "getHasNormalizedStableBounds", "setHasNormalizedStableBounds", "getCurrentBehaviorState", "()Ljava/lang/Integer;", "setCurrentBehaviorState", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BoundsState {
        private BottomSheetBehavior<View> behavior;
        private BottomSheetBehavior.BottomSheetCallback behaviorCallback;
        private CallbackInstallMode callbackInstallMode;
        private Integer currentBehaviorState;
        private final WeakReference<View> decorRef;
        private final WeakReference<Dialog> dialogRef;
        private boolean hasNormalizedStableBounds;
        private boolean hasObservedMatchParentHeight;
        private final Rect hostBounds;
        private boolean isHidden;
        private boolean isRestoring;
        private boolean isSamplingEnabled;
        private boolean isStableInstalled;
        private ViewTreeObserver.OnPreDrawListener preDrawListener;
        private ViewTreeObserver preDrawObserver;
        private BottomSheetBehavior.BottomSheetCallback previousBehaviorCallback;
        private final WeakReference<View> sheetRef;
        private int stableGlobalTop;
        private int stableHeight;
        private View.OnLayoutChangeListener stableLayoutListener;
        private int stableLocalTop;
        private BottomSheetStableMode stableMode;
        private int warmUpSamples;

        public final BottomSheetBehavior<View> getBehavior() {
            return this.behavior;
        }

        public final BottomSheetBehavior.BottomSheetCallback getBehaviorCallback() {
            return this.behaviorCallback;
        }

        public final CallbackInstallMode getCallbackInstallMode() {
            return this.callbackInstallMode;
        }

        public final Integer getCurrentBehaviorState() {
            return this.currentBehaviorState;
        }

        public final WeakReference<View> getDecorRef() {
            return this.decorRef;
        }

        public final WeakReference<Dialog> getDialogRef() {
            return this.dialogRef;
        }

        public final boolean getHasNormalizedStableBounds() {
            return this.hasNormalizedStableBounds;
        }

        public final boolean getHasObservedMatchParentHeight() {
            return this.hasObservedMatchParentHeight;
        }

        public final Rect getHostBounds() {
            return this.hostBounds;
        }

        public final ViewTreeObserver.OnPreDrawListener getPreDrawListener() {
            return this.preDrawListener;
        }

        public final ViewTreeObserver getPreDrawObserver() {
            return this.preDrawObserver;
        }

        public final BottomSheetBehavior.BottomSheetCallback getPreviousBehaviorCallback() {
            return this.previousBehaviorCallback;
        }

        public final WeakReference<View> getSheetRef() {
            return this.sheetRef;
        }

        public final int getStableGlobalTop() {
            return this.stableGlobalTop;
        }

        public final int getStableHeight() {
            return this.stableHeight;
        }

        public final View.OnLayoutChangeListener getStableLayoutListener() {
            return this.stableLayoutListener;
        }

        public final int getStableLocalTop() {
            return this.stableLocalTop;
        }

        public final BottomSheetStableMode getStableMode() {
            return this.stableMode;
        }

        public final int getWarmUpSamples() {
            return this.warmUpSamples;
        }

        public final boolean isHidden() {
            return this.isHidden;
        }

        public final boolean isRestoring() {
            return this.isRestoring;
        }

        public final boolean isSamplingEnabled() {
            return this.isSamplingEnabled;
        }

        public final boolean isStableInstalled() {
            return this.isStableInstalled;
        }

        public final void setBehavior(BottomSheetBehavior<View> r1) {
            this.behavior = r1;
        }

        public final void setBehaviorCallback(BottomSheetBehavior.BottomSheetCallback r1) {
            this.behaviorCallback = r1;
        }

        public final void setCallbackInstallMode(CallbackInstallMode r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.callbackInstallMode = r2;
        }

        public final void setCurrentBehaviorState(Integer r1) {
            this.currentBehaviorState = r1;
        }

        public final void setHasNormalizedStableBounds(boolean r1) {
            this.hasNormalizedStableBounds = r1;
        }

        public final void setHasObservedMatchParentHeight(boolean r1) {
            this.hasObservedMatchParentHeight = r1;
        }

        public final void setHidden(boolean r1) {
            this.isHidden = r1;
        }

        public final void setPreDrawListener(ViewTreeObserver.OnPreDrawListener r1) {
            this.preDrawListener = r1;
        }

        public final void setPreDrawObserver(ViewTreeObserver r1) {
            this.preDrawObserver = r1;
        }

        public final void setPreviousBehaviorCallback(BottomSheetBehavior.BottomSheetCallback r1) {
            this.previousBehaviorCallback = r1;
        }

        public final void setRestoring(boolean r1) {
            this.isRestoring = r1;
        }

        public final void setSamplingEnabled(boolean r1) {
            this.isSamplingEnabled = r1;
        }

        public final void setStableGlobalTop(int r1) {
            this.stableGlobalTop = r1;
        }

        public final void setStableHeight(int r1) {
            this.stableHeight = r1;
        }

        public final void setStableInstalled(boolean r1) {
            this.isStableInstalled = r1;
        }

        public final void setStableLayoutListener(View.OnLayoutChangeListener r1) {
            this.stableLayoutListener = r1;
        }

        public final void setStableLocalTop(int r1) {
            this.stableLocalTop = r1;
        }

        public final void setStableMode(BottomSheetStableMode r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.stableMode = r2;
        }

        public final void setWarmUpSamples(int r1) {
            this.warmUpSamples = r1;
        }

        public BoundsState(WeakReference<Dialog> r8, WeakReference<View> r9, WeakReference<View> r10, Rect r11, int r12, int r13, int r14, int r15, View.OnLayoutChangeListener r16, ViewTreeObserver.OnPreDrawListener r17, ViewTreeObserver r18, BottomSheetBehavior<View> r19, BottomSheetBehavior.BottomSheetCallback r20, BottomSheetBehavior.BottomSheetCallback r21, CallbackInstallMode r22, boolean r23, boolean r24, boolean r25, boolean r26, BottomSheetStableMode r27, boolean r28, boolean r29, Integer r30) {
            Intrinsics.checkNotNullParameter(r8, "dialogRef");
            Intrinsics.checkNotNullParameter(r9, "decorRef");
            Intrinsics.checkNotNullParameter(r11, "hostBounds");
            Intrinsics.checkNotNullParameter(r22, "callbackInstallMode");
            Intrinsics.checkNotNullParameter(r27, "stableMode");
            this.dialogRef = r8;
            this.decorRef = r9;
            this.sheetRef = r10;
            this.hostBounds = r11;
            this.stableGlobalTop = r12;
            this.stableLocalTop = r13;
            this.stableHeight = r14;
            this.warmUpSamples = r15;
            this.stableLayoutListener = r16;
            this.preDrawListener = r17;
            this.preDrawObserver = r18;
            this.behavior = r19;
            this.behaviorCallback = r20;
            this.previousBehaviorCallback = r21;
            this.callbackInstallMode = r22;
            this.hasObservedMatchParentHeight = r23;
            this.isSamplingEnabled = r24;
            this.isHidden = r25;
            this.isRestoring = r26;
            this.stableMode = r27;
            this.isStableInstalled = r28;
            this.hasNormalizedStableBounds = r29;
            this.currentBehaviorState = r30;
        }

        public /* synthetic */ BoundsState(WeakReference r28, WeakReference r29, WeakReference r30, Rect r31, int r32, int r33, int r34, int r35, View.OnLayoutChangeListener r36, ViewTreeObserver.OnPreDrawListener r37, ViewTreeObserver r38, BottomSheetBehavior r39, BottomSheetBehavior.BottomSheetCallback r40, BottomSheetBehavior.BottomSheetCallback r41, CallbackInstallMode r42, boolean r43, boolean r44, boolean r45, boolean r46, BottomSheetStableMode r47, boolean r48, boolean r49, Integer r50, int r51, DefaultConstructorMarker r52) {
            if ((r51 & 16) == 0) goto L5;
            int r8 = LandscapeChildDialogBoundsAdapter.UNSET_TOP;
        L7:
            if ((r51 & 32) == 0) goto L9;
            int r9 = LandscapeChildDialogBoundsAdapter.UNSET_TOP;
        L11:
            if ((r51 & 64) == 0) goto L13;
            int r10 = 0;
        L15:
            if ((r51 & 128) == 0) goto L17;
            int r11 = 0;
        L19:
            if ((r51 & 256) == 0) goto L21;
            View.OnLayoutChangeListener r12 = null;
        L23:
            if ((r51 & 512) == 0) goto L25;
            ViewTreeObserver.OnPreDrawListener r13 = null;
        L27:
            if ((r51 & 1024) == 0) goto L29;
            ViewTreeObserver r14 = null;
        L31:
            if ((r51 & 2048) == 0) goto L33;
            BottomSheetBehavior r15 = null;
        L35:
            if ((r51 & 4096) == 0) goto L37;
            BottomSheetBehavior.BottomSheetCallback r16 = null;
        L39:
            if ((r51 & 8192) == 0) goto L41;
            BottomSheetBehavior.BottomSheetCallback r17 = null;
        L43:
            if ((r51 & 16384) == 0) goto L45;
            CallbackInstallMode r18 = CallbackInstallMode.NONE;
        L47:
            if ((32768 & r51) == 0) goto L49;
            boolean r19 = false;
        L51:
            if ((65536 & r51) == 0) goto L53;
            boolean r20 = false;
        L55:
            if ((131072 & r51) == 0) goto L57;
            boolean r21 = false;
        L59:
            if ((262144 & r51) == 0) goto L61;
            boolean r22 = false;
        L63:
            if ((524288 & r51) == 0) goto L65;
            BottomSheetStableMode r23 = BottomSheetStableMode.NONE;
        L67:
            if ((1048576 & r51) == 0) goto L69;
            boolean r24 = false;
        L71:
            if ((2097152 & r51) == 0) goto L73;
            boolean r25 = false;
        L75:
            if ((r51 & UiType.FLAG_NO_FEEDBACK) == 0) goto L77;
            Integer r26 = null;
        L78:
            this(r28, r29, r30, r31, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
            return;
        L77:
            r26 = r50;
            goto L78
        L73:
            r25 = r49;
            goto L75
        L69:
            r24 = r48;
            goto L71
        L65:
            r23 = r47;
            goto L67
        L61:
            r22 = r46;
            goto L63
        L57:
            r21 = r45;
            goto L59
        L53:
            r20 = r44;
            goto L55
        L49:
            r19 = r43;
            goto L51
        L45:
            r18 = r42;
            goto L47
        L41:
            r17 = r41;
            goto L43
        L37:
            r16 = r40;
            goto L39
        L33:
            r15 = r39;
            goto L35
        L29:
            r14 = r38;
            goto L31
        L25:
            r13 = r37;
            goto L27
        L21:
            r12 = r36;
            goto L23
        L17:
            r11 = r35;
            goto L19
        L13:
            r10 = r34;
            goto L15
        L9:
            r9 = r33;
            goto L11
        L5:
            r8 = r32;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$CallbackInstallMode;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "ADD_REMOVE", "SET_SINGLE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CallbackInstallMode extends Enum<CallbackInstallMode> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ CallbackInstallMode[] $VALUES = null;
        public static final CallbackInstallMode ADD_REMOVE = null;
        public static final CallbackInstallMode NONE = null;
        public static final CallbackInstallMode SET_SINGLE = null;

        private static final /* synthetic */ CallbackInstallMode[] $values() {
            return new CallbackInstallMode[]{NONE, ADD_REMOVE, SET_SINGLE};
        }

        public static EnumEntries<CallbackInstallMode> getEntries() {
            return $ENTRIES;
        }

        static {
            NONE = new CallbackInstallMode("NONE", 0);
            ADD_REMOVE = new CallbackInstallMode("ADD_REMOVE", 1);
            SET_SINGLE = new CallbackInstallMode("SET_SINGLE", 2);
            CallbackInstallMode[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static CallbackInstallMode[] values() {
            return (CallbackInstallMode[]) $VALUES.clone();
        }

        public static CallbackInstallMode valueOf(String r1) {
            return (CallbackInstallMode) r27.a.a(CallbackInstallMode.class, r1);
        }

        private CallbackInstallMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$HorizontalBounds;", "", "width", "", "x", "<init>", "(II)V", "getWidth", "()I", "getX", "component1", "component2", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HorizontalBounds {
        private final int width;
        private final int x;

        public static /* synthetic */ HorizontalBounds copy$default(HorizontalBounds r0, int r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.width;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.x;
        L9:
            return r0.copy(r1, r2);
        }

        public final int component1() {
            return this.width;
        }

        public final int component2() {
            return this.x;
        }

        public final HorizontalBounds copy(int r2, int r3) {
            return new HorizontalBounds(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof HorizontalBounds) == true) goto L8;
            return false;
        L8:
            HorizontalBounds r6 = (HorizontalBounds) r5;
            if (this.width == r6.width) goto L12;
            return false;
        L12:
            if (this.x == r6.x) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.width * 31) + this.x;
        }

        public String toString() {
            return "HorizontalBounds(width=" + this.width + ", x=" + this.x + ')';
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getX() {
            return this.x;
        }

        public HorizontalBounds(int r1, int r2) {
            this.width = r1;
            this.x = r2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$PreAddViewBoundsApplyResult;", "", "<init>", "(Ljava/lang/String;I)V", "APPLIED", "UNCHANGED", "SKIPPED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PreAddViewBoundsApplyResult extends Enum<PreAddViewBoundsApplyResult> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ PreAddViewBoundsApplyResult[] $VALUES = null;
        public static final PreAddViewBoundsApplyResult APPLIED = null;
        public static final PreAddViewBoundsApplyResult SKIPPED = null;
        public static final PreAddViewBoundsApplyResult UNCHANGED = null;

        private static final /* synthetic */ PreAddViewBoundsApplyResult[] $values() {
            return new PreAddViewBoundsApplyResult[]{APPLIED, UNCHANGED, SKIPPED};
        }

        public static EnumEntries<PreAddViewBoundsApplyResult> getEntries() {
            return $ENTRIES;
        }

        static {
            APPLIED = new PreAddViewBoundsApplyResult("APPLIED", 0);
            UNCHANGED = new PreAddViewBoundsApplyResult("UNCHANGED", 1);
            SKIPPED = new PreAddViewBoundsApplyResult("SKIPPED", 2);
            PreAddViewBoundsApplyResult[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static PreAddViewBoundsApplyResult[] values() {
            return (PreAddViewBoundsApplyResult[]) $VALUES.clone();
        }

        public static PreAddViewBoundsApplyResult valueOf(String r1) {
            return (PreAddViewBoundsApplyResult) r27.a.a(PreAddViewBoundsApplyResult.class, r1);
        }

        private PreAddViewBoundsApplyResult(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0006\"\u0004\b\u0007\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$PreAddViewBoundsSession;", "", "isConsumed", "", "<init>", "(Z)V", "()Z", "setConsumed", "component1", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PreAddViewBoundsSession {
        private boolean isConsumed;

        public PreAddViewBoundsSession() {
            boolean r2 = false;
            this(r2, 1, null);
        }

        public static /* synthetic */ PreAddViewBoundsSession copy$default(PreAddViewBoundsSession r0, boolean r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.isConsumed;
        L6:
            return r0.copy(r1);
        }

        public final boolean component1() {
            return this.isConsumed;
        }

        public final PreAddViewBoundsSession copy(boolean r2) {
            return new PreAddViewBoundsSession(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof PreAddViewBoundsSession) == true) goto L9;
            return false;
        L9:
            if (this.isConsumed == ((PreAddViewBoundsSession) r4).isConsumed) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            if (this.isConsumed == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public String toString() {
            return "PreAddViewBoundsSession(isConsumed=" + this.isConsumed + ')';
        }

        public final boolean isConsumed() {
            return this.isConsumed;
        }

        public PreAddViewBoundsSession(boolean r1) {
            this.isConsumed = r1;
        }

        public final void setConsumed(boolean r1) {
            this.isConsumed = r1;
        }

        public /* synthetic */ PreAddViewBoundsSession(boolean r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = false;
        L5:
            this(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode;", "", "<init>", "()V", "MatchParent", "Fixed", "WrapContent", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode$Fixed;", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode$MatchParent;", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode$WrapContent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class SizeRequestMode {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode$Fixed;", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode;", "size", "", "<init>", "(I)V", "getSize", "()I", "component1", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Fixed extends SizeRequestMode {
            private final int size;

            public static /* synthetic */ Fixed copy$default(Fixed r0, int r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L6;
                r1 = r0.size;
            L6:
                return r0.copy(r1);
            }

            public final int component1() {
                return this.size;
            }

            public final Fixed copy(int r2) {
                return new Fixed(r2);
            }

            public boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof Fixed) == true) goto L9;
                return false;
            L9:
                if (this.size == ((Fixed) r4).size) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.size;
            }

            public String toString() {
                return "Fixed(size=" + this.size + ')';
            }

            public final int getSize() {
                return this.size;
            }

            public Fixed(int r2) {
                super(null);
                this.size = r2;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode$MatchParent;", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class MatchParent extends SizeRequestMode {
            public static final MatchParent INSTANCE = null;

            static {
                INSTANCE = new MatchParent();
            }

            private MatchParent() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode$WrapContent;", "Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$SizeRequestMode;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class WrapContent extends SizeRequestMode {
            public static final WrapContent INSTANCE = null;

            static {
                INSTANCE = new WrapContent();
            }

            private WrapContent() {
                super(null);
            }
        }

        private SizeRequestMode() {
        }

        public /* synthetic */ SizeRequestMode(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/landscape/childwindow/LandscapeChildDialogBoundsAdapter$StableSheetTarget;", "", "globalTop", "", "localTop", "height", "<init>", "(III)V", "getGlobalTop", "()I", "getLocalTop", "getHeight", "component1", "component2", "component3", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StableSheetTarget {
        private final int globalTop;
        private final int height;
        private final int localTop;

        public static /* synthetic */ StableSheetTarget copy$default(StableSheetTarget r0, int r1, int r2, int r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.globalTop;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.localTop;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.height;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final int component1() {
            return this.globalTop;
        }

        public final int component2() {
            return this.localTop;
        }

        public final int component3() {
            return this.height;
        }

        public final StableSheetTarget copy(int r2, int r3, int r4) {
            return new StableSheetTarget(r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof StableSheetTarget) == true) goto L8;
            return false;
        L8:
            StableSheetTarget r6 = (StableSheetTarget) r5;
            if (this.globalTop == r6.globalTop) goto L12;
            return false;
        L12:
            if (this.localTop == r6.localTop) goto L15;
            return false;
        L15:
            if (this.height == r6.height) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.globalTop * 31) + this.localTop) * 31) + this.height;
        }

        public String toString() {
            return "StableSheetTarget(globalTop=" + this.globalTop + ", localTop=" + this.localTop + ", height=" + this.height + ')';
        }

        public final int getGlobalTop() {
            return this.globalTop;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getLocalTop() {
            return this.localTop;
        }

        public StableSheetTarget(int r1, int r2, int r3) {
            this.globalTop = r1;
            this.localTop = r2;
            this.height = r3;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[CallbackInstallMode.values().length];
            r0[CallbackInstallMode.ADD_REMOVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CallbackInstallMode.SET_SINGLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CallbackInstallMode.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    private LandscapeChildDialogBoundsAdapter() {
    }

    public static /* synthetic */ IBinder a() {
        return windowTokenResolver$lambda$1();
    }

    public static /* synthetic */ BottomSheetBehavior b(View r0) {
        return bottomSheetBehaviorResolver$lambda$5(r0);
    }

    public static /* synthetic */ void c(BoundsState r0, String r1) {
        postSampleAndRestore$lambda$19(r0, r1);
    }

    public static /* synthetic */ Rect d() {
        return hostVisibleBoundsResolver$lambda$2();
    }

    public static /* synthetic */ void e(BoundsState r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        installStableListeners$lambda$20(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ View f(Dialog r0) {
        return bottomSheetViewResolver$lambda$3(r0);
    }

    public static /* synthetic */ boolean g() {
        return landscapeRestrictionActiveResolver$lambda$0();
    }

    public static /* synthetic */ Rect h(View r0) {
        return viewGlobalVisibleRectResolver$lambda$6(r0);
    }

    public static /* synthetic */ Integer i(Window r0) {
        return screenWidthResolver$lambda$7(r0);
    }

    private final int replaceHorizontalGravityPreservingVertical(int r2, int r3) {
        return ((r2 & (-8)) & (-8388616)) | r3;
    }

    static {
        INSTANCE = new LandscapeChildDialogBoundsAdapter();
        states = new WeakHashMap();
        preAddViewBoundsSessions = new WeakHashMap();
        landscapeRestrictionActiveResolver = new c();
        windowTokenResolver = new d();
        hostVisibleBoundsResolver = new e();
        bottomSheetViewResolver = new f();
        bottomSheetBehaviorResolver = new g();
        viewGlobalVisibleRectResolver = new h();
        screenWidthResolver = new i();
    }

    private static final Rect hostVisibleBoundsResolver$lambda$2() {
        return WindowHost.INSTANCE.getLandscapeWindowVisibleBounds$impl_mainlandRelease();
    }

    private static final boolean landscapeRestrictionActiveResolver$lambda$0() {
        return WindowHost.INSTANCE.isLandscapeRestrictionActive();
    }

    private static final IBinder windowTokenResolver$lambda$1() {
        return WindowHost.INSTANCE.getWindowToken();
    }

    public final void clearForTest$impl_mainlandRelease() {
        Iterator r0 = CollectionsKt.toList(states.keySet()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        onDialogDismissed((Dialog) r0.next());
        goto L4
    L6:
        states.clear();
        preAddViewBoundsSessions.clear();
    }

    public final int trackedStateCountForTest$impl_mainlandRelease() {
        return states.size();
    }

    public final Function1<View, BottomSheetBehavior<View>> getBottomSheetBehaviorResolver$impl_mainlandRelease() {
        return bottomSheetBehaviorResolver;
    }

    public final Function1<Dialog, View> getBottomSheetViewResolver$impl_mainlandRelease() {
        return bottomSheetViewResolver;
    }

    public final Function0<Rect> getHostVisibleBoundsResolver$impl_mainlandRelease() {
        return hostVisibleBoundsResolver;
    }

    public final Function0<Boolean> getLandscapeRestrictionActiveResolver$impl_mainlandRelease() {
        return landscapeRestrictionActiveResolver;
    }

    public final Function1<Window, Integer> getScreenWidthResolver$impl_mainlandRelease() {
        return screenWidthResolver;
    }

    public final Function1<View, Rect> getViewGlobalVisibleRectResolver$impl_mainlandRelease() {
        return viewGlobalVisibleRectResolver;
    }

    public final Function0<IBinder> getWindowTokenResolver$impl_mainlandRelease() {
        return windowTokenResolver;
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_landscape_childwindow_LandscapeChildDialogBoundsAdapter_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_landscape_childwindow_LandscapeChildDialogBoundsAdapter_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    @JvmStatic
    public static final void beginPreAddViewBoundsSession(Dialog r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if ((r5 instanceof AssistantChatDialog) == false) goto L8;
        preAddViewBoundsSessions.remove(r5);
        return;
    L8:
        boolean r4 = false;
        preAddViewBoundsSessions.put(r5, new PreAddViewBoundsSession(r4, 1, null));
    }

    private static final BottomSheetBehavior bottomSheetBehaviorResolver$lambda$5(View r1) {
        Intrinsics.checkNotNullParameter(r1, "sheet");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(BottomSheetBehavior.from(r1));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r2) == false) goto L11;
        r2 = null;
    L11:
        return (BottomSheetBehavior) r2;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    private static final View bottomSheetViewResolver$lambda$3(Dialog r1) {
        Intrinsics.checkNotNullParameter(r1, "dialog");
        return r1.findViewById(2131368870);
    }

    private final BottomSheetBehavior.BottomSheetCallback getSingleBottomSheetCallback(BottomSheetBehavior<View> r4) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Field r2 = r4.getClass().getDeclaredField("callback");     // Catch: Throwable -> L9
        r2.setAccessible(true);     // Catch: Throwable -> L9
        Object r5 = r2.get(r4);     // Catch: Throwable -> L9
        if ((r5 instanceof BottomSheetBehavior.BottomSheetCallback) == false) goto L6;
        BottomSheetBehavior.BottomSheetCallback r6 = (BottomSheetBehavior.BottomSheetCallback) r5;     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r7) == true) goto L16;
        r0 = r7;
    L16:
        return (BottomSheetBehavior.BottomSheetCallback) r0;
    L6:
        r6 = null;
    L9:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    private final void installStableListeners(final BoundsState r4) {
        WeakReference<View> r0 = r4.getSheetRef();
        if (r0 == null) goto L11;
        View r1 = r0.get();
        if (r1 == null) goto L13;
        View.OnLayoutChangeListener r2 = new a(r4);
        r4.setStableLayoutListener(r2);
        r1.addOnLayoutChangeListener(r2);
        ViewTreeObserver.OnPreDrawListener r3 = new LandscapeChildDialogBoundsAdapter$installStableListeners$preDrawListener$1(r4);
        ViewTreeObserver r5 = r1.getViewTreeObserver();
        if (r5.isAlive() == false) goto L12;
        r4.setPreDrawListener(r3);
        r4.setPreDrawObserver(r5);
        r5.addOnPreDrawListener(r3);
        return;
    L12:
        return;
    L13:
        return;
    }

    private final boolean isExpandedOrSkipCollapsed(BottomSheetBehavior<View> r5) {
        if (r5 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L18;
        if (r5 != null) goto L11;
    L13:
        boolean r6 = false;
    L14:
        if (r6 == true) goto L19;
        return false;
    L19:
        return true;
    L11:
        if (r5.getSkipCollapsed() != true) goto L13;
        r6 = true;
        goto L14
    L18:
        return true;
    L5:
        if (r5.getState() != 3) goto L7;
        r2 = true;
        goto L8
    }

    private final boolean isHiddenBottomSheetState(Integer r2) {
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.intValue() != 5) goto L7;
        return true;
    }

    private final boolean isLayoutSamplingReason(String r2) {
        return Intrinsics.areEqual(r2, "layout");
    }

    private final boolean isMaterialBottomSheetDialog(Dialog r2) {
        return isClassOrSuperclassNamed(r2.getClass(), "com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    private final boolean isStrongStableMode(BottomSheetStableMode r2) {
        if (r2 != BottomSheetStableMode.FULL_HEIGHT_EXPANDED) goto L5;
    L8:
        return true;
    L5:
        if (r2 == BottomSheetStableMode.OVERFLOW_FIT_TO_HOST) goto L8;
        return false;
    }

    private final boolean isUnsettledBottomSheetState(BottomSheetBehavior<View> r4) {
        if (r4 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L18;
        if (r4 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == true) goto L19;
        return false;
    L19:
        return true;
    L11:
        if (r4.getState() != 2) goto L13;
        r5 = true;
        goto L14
    L18:
        return true;
    L5:
        if (r4.getState() != 1) goto L7;
        r2 = true;
        goto L8
    }

    @JvmStatic
    public static final void onDialogDismissed(Dialog r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        preAddViewBoundsSessions.remove(r3);
        BoundsState r4 = states.remove(r3);
        if (r4 != null) goto L7;
        return;
    L7:
        WeakReference<View> r0 = r4.getSheetRef();
        if (r0 == null) goto L10;
        View r1 = r0.get();
    L11:
        if (r1 == null) goto L13;
        r1.removeOnLayoutChangeListener(r4.getStableLayoutListener());
    L13:
        LandscapeChildDialogBoundsAdapter r2 = INSTANCE;
        r2.removeSheetPreDrawListener(r4);
        BottomSheetBehavior.BottomSheetCallback r5 = r4.getBehaviorCallback();
        if (r5 == null) goto L16;
        r2.clearBottomSheetCallback(r4, r5);
    L16:
        r4.setStableLayoutListener(null);
        r4.setPreDrawListener(null);
        r4.setPreDrawObserver(null);
        r4.setBehaviorCallback(null);
        r4.setPreviousBehaviorCallback(null);
        r4.setBehavior(null);
        r4.setHasObservedMatchParentHeight(false);
        r4.setSamplingEnabled(false);
        r4.setStableGlobalTop(UNSET_TOP);
        r4.setStableLocalTop(UNSET_TOP);
        r4.setStableHeight(0);
        r4.setWarmUpSamples(0);
        r4.setStableMode(BottomSheetStableMode.NONE);
        r4.setStableInstalled(false);
        r4.setHasNormalizedStableBounds(false);
        r4.setCurrentBehaviorState(null);
        return;
    L10:
        r1 = null;
        goto L11
    }

    @JvmStatic
    public static final void onDialogShown(Dialog r31) {
        if (r31 != null) goto L5;
        return;
    L5:
        onDialogDismissed(r31);
        Rect r2 = INSTANCE.resolveTargetChildDialogHostBounds(r31);
        if (r2 != null) goto L8;
        return;
    L8:
        Window r0 = r31.getWindow();
        if (r0 != null) goto L26;
        return;
    L26:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        Object r1 = Result.constructor-impl(INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_landscape_childwindow_LandscapeChildDialogBoundsAdapter_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r0));     // Catch: Throwable -> L13
    L15:
        WeakReference r4 = null;
        if (Result.isFailure-impl(r1) == false) goto L18;
        r1 = null;
    L18:
        View r5 = (View) r1;
        if (r5 != null) goto L21;
        return;
    L21:
        View r6 = (View) bottomSheetViewResolver.invoke(r31);
        WeakReference r7 = new WeakReference(r31);
        WeakReference r8 = new WeakReference(r5);
        if (r6 == null) goto L24;
        r4 = new WeakReference(r6);
    L24:
        BoundsState r9 = new BoundsState(r7, r8, r4, new Rect(r2), 0, 0, 0, 0, null, null, null, null, null, null, null, false, false, false, false, null, false, false, null, 8388592, null);
        states.put(r31, r9);
        LandscapeChildDialogBoundsAdapter r10 = INSTANCE;
        r10.installStableListeners(r9);
        r10.postSampleAndRestore(r9, "postShow");
        return;
    L13:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    private final void removeSheetPreDrawListener(BoundsState r6) {
        ViewTreeObserver.OnPreDrawListener r0 = r6.getPreDrawListener();
        if (r0 != null) goto L5;
        return;
    L5:
        ViewTreeObserver r1 = r6.getPreDrawObserver();
        boolean r2 = false;
        if (r1 != null) goto L8;
    L10:
        if (r2 == false) goto L13;
        r1.removeOnPreDrawListener(r0);
        return;
    L13:
        WeakReference<View> r7 = r6.getSheetRef();
        if (r7 == null) goto L26;
        View r8 = r7.get();
        if (r8 == null) goto L27;
        ViewTreeObserver r9 = r8.getViewTreeObserver();
        if (r9 != null) goto L20;
        return;
    L20:
        if (r9.isAlive() == true) goto L23;
        r9 = null;
    L23:
        if (r9 == null) goto L29;
        r9.removeOnPreDrawListener(r0);
        return;
    L29:
        return;
    L27:
        return;
    L26:
        return;
    L8:
        if (r1.isAlive() != true) goto L10;
        r2 = true;
        goto L10
    }

    private final Rect resolveGlobalVisibleRect(View r2) {
        Rect r0 = new Rect();
        if (r2.getGlobalVisibleRect(r0) == true) goto L5;
        return null;
    L5:
        if (r0.isEmpty() == true) goto L10;
        return r0;
    L10:
        return null;
    }

    private final Integer resolveScreenWidth(Window r6) {
        Point r0 = new Point();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Display r3 = INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_landscape_childwindow_LandscapeChildDialogBoundsAdapter_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r6).getDisplay();     // Catch: Throwable -> L11
        if (r3 != null) goto L6;
        r3 = r6.getWindowManager().getDefaultDisplay();     // Catch: Throwable -> L11
    L6:
        if (r3 == null) goto L8;
        r3.getRealSize(r0);     // Catch: Throwable -> L11
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Result.constructor-impl(r4);     // Catch: Throwable -> L11
    L13:
        Integer r1 = Integer.valueOf(r0.x);
        boolean r5 = true;
        if (r1.intValue() <= 0) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == true) goto L20;
        r1 = null;
    L20:
        if (r1 != null) goto L22;
        Object r8 = Result.constructor-impl(Integer.valueOf(INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_landscape_childwindow_LandscapeChildDialogBoundsAdapter_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r6.getContext().getResources()).widthPixels));     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r8) == false) goto L30;
        r8 = null;
    L30:
        Integer r9 = (Integer) r8;
        if (r9 != null) goto L33;
        return null;
    L33:
        if (r9.intValue() > 0) goto L36;
        r5 = false;
    L36:
        if (r5 == true) goto L38;
        return null;
    L38:
        return r9;
    L25:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L22:
        return Integer.valueOf(r1.intValue());
    L16:
        r7 = false;
        goto L17
    L8:
        r4 = null;
    L11:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    private final StableSheetTarget resolveSettledSheetStableTarget(View r6) {
        Rect r0 = (Rect) viewGlobalVisibleRectResolver.invoke(r6);
        if (r0 == null) goto L24;
        boolean r3 = true;
        if ((!r0.isEmpty()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L24;
        Integer r2 = Integer.valueOf(r0.height());
        if (r2.intValue() > 0) goto L14;
        r3 = false;
    L14:
        if (r3 == true) goto L17;
        r2 = null;
    L17:
        if (r2 == null) goto L19;
        int r4 = r2.intValue();
    L20:
        if (r4 > 0) goto L22;
        return null;
    L22:
        int r1 = r0.top - r6.getTop();
        int r5 = r0.top;
        return new StableSheetTarget(r5, r5 - r1, r4);
    L19:
        r4 = r6.getHeight();
    L24:
        return null;
    }

    private final SizeRequestMode resolveSizeRequestMode(Integer r3) {
        if (r3 != null) goto L5;
    L7:
        if (r3 == null) goto L12;
        if (r3.intValue() <= 0) goto L12;
        return new SizeRequestMode.Fixed(r3.intValue());
    L12:
        return SizeRequestMode.WrapContent.INSTANCE;
    L5:
        if (r3.intValue() != (-1)) goto L7;
        return SizeRequestMode.MatchParent.INSTANCE;
    }

    private final Rect resolveTargetChildDialogHostBounds(Dialog r3) {
        if ((r3 instanceof AssistantChatDialog) == false) goto L6;
        return null;
    L6:
        if (((Boolean) landscapeRestrictionActiveResolver.invoke()).booleanValue() == true) goto L8;
        return null;
    L8:
        IBinder r0 = (IBinder) windowTokenResolver.invoke();
        if (r0 != null) goto L11;
        return null;
    L11:
        Window r4 = r3.getWindow();
        if (r4 == null) goto L33;
        WindowManager.LayoutParams r5 = r4.getAttributes();
        if (r5 == null) goto L34;
        IBinder r6 = r5.token;
        if (r6 == null) goto L37;
        if (r6 == r0) goto L20;
        return null;
    L20:
        Rect r7 = (Rect) hostVisibleBoundsResolver.invoke();
        if (r7 != null) goto L23;
        return null;
    L23:
        if (r7.isEmpty() == false) goto L25;
    L29:
        boolean r1 = false;
    L30:
        if (r1 == true) goto L32;
        return null;
    L32:
        return r7;
    L25:
        if (r7.width() <= 0) goto L29;
        if (r7.height() <= 0) goto L29;
        r1 = true;
        goto L30
    L37:
        return null;
    L34:
        return null;
    L33:
        return null;
    }

    private static final Integer screenWidthResolver$lambda$7(Window r1) {
        Intrinsics.checkNotNullParameter(r1, "window");
        return INSTANCE.resolveScreenWidth(r1);
    }

    private static final Rect viewGlobalVisibleRectResolver$lambda$6(View r1) {
        Intrinsics.checkNotNullParameter(r1, "view");
        return INSTANCE.resolveGlobalVisibleRect(r1);
    }

    public final boolean hasBehaviorCallbackForTest$impl_mainlandRelease(Dialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        BoundsState r3 = states.get(r2);
        if (r3 == null) goto L5;
        BottomSheetBehavior.BottomSheetCallback r4 = r3.getBehaviorCallback();
    L6:
        if (r4 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r4 = null;
        goto L6
    }

    public final void restoreStableBoundsForTest$impl_mainlandRelease(Dialog r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        BoundsState r4 = states.get(r3);
        if (r4 == null) goto L6;
        INSTANCE.restoreStableBounds(r4, "test");
        return;
    }

    public final void sampleAndRestoreForTest$impl_mainlandRelease(Dialog r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        BoundsState r4 = states.get(r3);
        if (r4 == null) goto L6;
        INSTANCE.sampleAndRestoreStableBounds(r4, "test");
        return;
    }

    public final void setBottomSheetBehaviorResolver$impl_mainlandRelease(Function1<? super View, ? extends BottomSheetBehavior<View>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        bottomSheetBehaviorResolver = r2;
    }

    public final void setBottomSheetViewResolver$impl_mainlandRelease(Function1<? super Dialog, ? extends View> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        bottomSheetViewResolver = r2;
    }

    public final void setHostVisibleBoundsResolver$impl_mainlandRelease(Function0<Rect> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        hostVisibleBoundsResolver = r2;
    }

    public final void setLandscapeRestrictionActiveResolver$impl_mainlandRelease(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        landscapeRestrictionActiveResolver = r2;
    }

    public final void setScreenWidthResolver$impl_mainlandRelease(Function1<? super Window, Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        screenWidthResolver = r2;
    }

    public final void setViewGlobalVisibleRectResolver$impl_mainlandRelease(Function1<? super View, Rect> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        viewGlobalVisibleRectResolver = r2;
    }

    public final void setWindowTokenResolver$impl_mainlandRelease(Function0<? extends IBinder> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        windowTokenResolver = r2;
    }

    public final Pair<Integer, Integer> stableBoundsForTest$impl_mainlandRelease(Dialog r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");
        BoundsState r4 = states.get(r3);
        if (r4 != null) goto L6;
        return null;
    L6:
        if (r4.isStableInstalled() == true) goto L9;
        return null;
    L9:
        return TuplesKt.to(Integer.valueOf(r4.getStableGlobalTop()), Integer.valueOf(r4.getStableHeight()));
    }

    private final boolean isUnsettledBottomSheetState(Integer r3) {
        if (r3 != null) goto L6;
    L7:
        if (r3 != null) goto L10;
    L12:
        return false;
    L10:
        if (r3.intValue() != 2) goto L12;
        return true;
    L6:
        if (r3.intValue() != 1) goto L7;
        return true;
    }

    private final PreAddViewBoundsApplyResult applyPreAddViewBounds(Dialog r8, String r9) {
        if (r8 != null) goto L6;
        return PreAddViewBoundsApplyResult.SKIPPED;
    L6:
        if ((r8 instanceof AssistantChatDialog) == false) goto L10;
        return PreAddViewBoundsApplyResult.SKIPPED;
    L10:
        if (((Boolean) landscapeRestrictionActiveResolver.invoke()).booleanValue() == false) goto L12;
        IBinder r10 = (IBinder) windowTokenResolver.invoke();
        if (r10 == null) goto L16;
        Window r11 = r8.getWindow();
        if (r11 == null) goto L20;
        WindowManager.LayoutParams r0 = r11.getAttributes();
        if (r0 == null) goto L24;
        IBinder r1 = r0.token;
        if (r1 == null) goto L28;
        if (r1 != r10) goto L31;
        Rect r12 = (Rect) hostVisibleBoundsResolver.invoke();
        boolean r2 = false;
        boolean r3 = true;
        if (r12 != null) goto L35;
    L44:
        r12 = null;
    L45:
        if (r12 == null) goto L47;
        HorizontalBounds r13 = resolveOnStartHorizontalBounds(r11, r0, r12);
        if (r13 == null) goto L51;
        int r4 = replaceHorizontalGravityPreservingVertical(r0.gravity, 1);
        if (r0.width == r13.getWidth()) goto L55;
        r0.width = r13.getWidth();
        boolean r5 = true;
    L57:
        if (r0.x == r13.getX()) goto L60;
        r0.x = r13.getX();
        r5 = true;
    L60:
        if (r0.gravity == r4) goto L62;
        r0.gravity = r4;
        r2 = true;
    L63:
        if (r3 == false) goto L65;
        r11.setAttributes(r0);
        if (r2 == false) goto L70;
        r11.setGravity(r0.gravity);
    L70:
        return PreAddViewBoundsApplyResult.APPLIED;
    L65:
        return PreAddViewBoundsApplyResult.UNCHANGED;
    L62:
        r3 = r5;
        goto L63
    L55:
        r5 = false;
        goto L57
    L51:
        return PreAddViewBoundsApplyResult.SKIPPED;
    L47:
        return PreAddViewBoundsApplyResult.SKIPPED;
    L35:
        if (r12.isEmpty() == false) goto L37;
    L41:
        boolean r6 = false;
    L42:
        if (r6 == false) goto L44;
    L37:
        if (r12.width() <= 0) goto L41;
        if (r12.height() <= 0) goto L41;
        r6 = true;
        goto L42
    L31:
        return PreAddViewBoundsApplyResult.SKIPPED;
    L28:
        return PreAddViewBoundsApplyResult.SKIPPED;
    L24:
        return PreAddViewBoundsApplyResult.SKIPPED;
    L20:
        return PreAddViewBoundsApplyResult.SKIPPED;
    L16:
        return PreAddViewBoundsApplyResult.SKIPPED;
    L12:
        return PreAddViewBoundsApplyResult.SKIPPED;
    }

    private final void clearBottomSheetCallback(BoundsState r12, BottomSheetBehavior.BottomSheetCallback r13) {
        BottomSheetBehavior<View> r0 = r12.getBehavior();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = WhenMappings.$EnumSwitchMapping$0[r12.getCallbackInstallMode().ordinal()];
        if (r1 != 1) goto L8;
        Method[] r2 = r0.getClass().getMethods();
        int r4 = r2.length;
        int r6 = 0;
    L26:
        Object r7 = null;
        if (r6 >= r4) goto L39;
        Method r8 = r2[r6];
        if (Intrinsics.areEqual(r8.getName(), "removeBottomSheetCallback") == true) goto L31;
    L35:
        boolean r9 = false;
    L36:
        if (r9 == true) goto L53;
        r6 = r6 + 1;
    L53:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L45
        if (r8 == null) goto L43;
        r7 = r8.invoke(r0, new Object[]{r13});     // Catch: Throwable -> L45
    L43:
        Object r14 = Result.constructor-impl(r7);     // Catch: Throwable -> L45
    L47:
        Throwable r5 = Result.exceptionOrNull-impl(r14);
        if (r5 == null) goto L50;
        FLogger.a.w(TAG, "removeBottomSheetCallback failed", r5);
    L50:
        Result.box-impl(r14);
    L51:
        r12.setCallbackInstallMode(CallbackInstallMode.NONE);
        return;
    L45:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L47
    L31:
        if (r8.getParameterTypes().length != 1) goto L35;
        if (r8.getParameterTypes()[0].isAssignableFrom(BottomSheetBehavior.BottomSheetCallback.class) == false) goto L35;
        r9 = true;
        goto L36
    L39:
        r8 = null;
        goto L53
    L8:
        if (r1 != 2) goto L10;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L19
        if (getSingleBottomSheetCallback(r0) != r13) goto L17;
        r0.setBottomSheetCallback(r12.getPreviousBehaviorCallback());     // Catch: Throwable -> L19
    L17:
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L24;
        FLogger.a.w(TAG, "restoreBottomSheetCallback failed", r16);
    L24:
        Result.box-impl(r15);
    L19:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L10:
        if (r1 != 3) goto L13;
        Unit r18 = Unit.INSTANCE;
        goto L51
    L13:
        throw new NoWhenBranchMatchedException();
    }

    private final boolean hasFullHeightRequest(BoundsState r3, View r4) {
        if (r3.getHasObservedMatchParentHeight() == true) goto L14;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 != null) goto L7;
    L9:
        boolean r6 = false;
    L10:
        if (r6 == true) goto L15;
        return false;
    L15:
        return true;
    L7:
        if (r5.height != (-1)) goto L9;
        r6 = true;
        goto L10
    L14:
        return true;
    }

    private final void installBehaviorCallback(BoundsState r2, BottomSheetBehavior<View> r3) {
        if (r2.getBehaviorCallback() == null) goto L5;
        return;
    L5:
        LandscapeChildDialogBoundsAdapter$installBehaviorCallback$callback$1 r0 = new LandscapeChildDialogBoundsAdapter$installBehaviorCallback$callback$1(r2);
        r2.setBehavior(r3);
        r2.setBehaviorCallback(r0);
        setBottomSheetCallback(r2, r0);
    }

    private final boolean isClassOrSuperclassNamed(Class<?> r2, String r3) {
    L2:
        if (r2 == null) goto L8;
        if (Intrinsics.areEqual(r2.getName(), r3) == true) goto L5;
        r2 = r2.getSuperclass();
        goto L2
    L5:
        return true;
    L8:
        return false;
    }

    @JvmStatic
    public static final void onDialogPreAddView(Dialog r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, WindowEvent.Params.TRIGGER);
        if (r4 != null) goto L5;
    L7:
        if (r4 == null) goto L9;
        PreAddViewBoundsSession r0 = preAddViewBoundsSessions.get(r4);
    L10:
        if (r4 == null) goto L14;
        if (r0 != null) goto L14;
        return;
    L14:
        if (r4 == null) goto L22;
        boolean r2 = false;
        if (r0 != null) goto L18;
    L20:
        if (r2 == false) goto L22;
        return;
    L18:
        if (r0.isConsumed() != true) goto L20;
        r2 = true;
    L22:
        PreAddViewBoundsApplyResult r6 = INSTANCE.applyPreAddViewBounds(r4, r5);
        if (r0 != null) goto L25;
        return;
    L25:
        if (r6 == PreAddViewBoundsApplyResult.SKIPPED) goto L29;
        r0.setConsumed(true);
        return;
    L29:
        return;
    L9:
        r0 = null;
        goto L10
    L5:
        if (INSTANCE.shouldDeferToBottomSheetOnStart(r4, r5) == false) goto L7;
    }

    private final void postSampleAndRestore(final BoundsState r3, final String r4) {
        View r0 = r3.getDecorRef().get();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.post(new b(r3, r4));
    }

    private static final void postSampleAndRestore$lambda$19(BoundsState r1, String r2) {
        r1.setSamplingEnabled(true);
        INSTANCE.sampleAndRestoreStableBounds(r1, r2);
    }

    private final void recordSheetLayoutRequest(BoundsState r4, View r5) {
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        boolean r1 = false;
        if (r6 != null) goto L5;
    L7:
        if (r1 == false) goto L10;
        r4.setHasObservedMatchParentHeight(true);
        return;
    L10:
        return;
    L5:
        if (r6.height != (-1)) goto L7;
        r1 = true;
        goto L7
    }

    private final BottomSheetBehavior<View> resolveBottomSheetBehavior(BoundsState r2, View r3) {
        BottomSheetBehavior<View> r0 = r2.getBehavior();
        if (r0 != null) goto L9;
        BottomSheetBehavior<View> r1 = (BottomSheetBehavior) bottomSheetBehaviorResolver.invoke(r3);
        if (r1 == null) goto L7;
        r2.setBehavior(r1);
        return r1;
    L7:
        return null;
    L9:
        return r0;
    }

    private final int resolveBottomSheetDesiredContentHeight(View r9, Rect r10) {
        int r0 = r10.width();
        int r11 = r10.height();
        if (r0 <= 0) goto L46;
        if (r11 <= 0) goto L46;
        Integer r2 = Integer.valueOf(r9.getWidth());
        if (r2.intValue() <= 0) goto L9;
        boolean r3 = true;
    L10:
        ViewGroup.MarginLayoutParams r4 = null;
        if (r3 == true) goto L14;
        r2 = null;
    L14:
        if (r2 == null) goto L17;
        r0 = Math.min(r2.intValue(), r0);
    L17:
        if ((r9 instanceof ViewGroup) == false) goto L19;
        ViewGroup r5 = (ViewGroup) r9;
    L20:
        if (r5 == null) goto L22;
        View r6 = r5.getChildAt(0);
    L23:
        if (r6 == null) goto L45;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
        r4 = (ViewGroup.MarginLayoutParams) r7;
    L27:
        if (r4 == null) goto L29;
        int r8 = r4.leftMargin;
    L30:
        if (r4 == null) goto L32;
        int r12 = r4.rightMargin;
    L33:
        int r13 = r8 + r12;
        if (r4 == null) goto L36;
        int r14 = r4.topMargin;
    L37:
        if (r4 == null) goto L39;
        int r15 = r4.bottomMargin;
    L40:
        int r16 = r14 + r15;
        ViewGroup r17 = (ViewGroup) r9;
        int r1 = measureViewDesiredHeight(r6, RangesKt.coerceAtLeast(((r0 - r17.getPaddingLeft()) - r17.getPaddingRight()) - r13, 0), RangesKt.coerceAtLeast(((r11 - r17.getPaddingTop()) - r17.getPaddingBottom()) - r16, 0));
        if (r1 <= 0) goto L45;
        return ((r1 + r17.getPaddingTop()) + r17.getPaddingBottom()) + r16;
    L39:
        r15 = 0;
        goto L40
    L36:
        r14 = 0;
        goto L37
    L32:
        r12 = 0;
        goto L33
    L29:
        r8 = 0;
    L45:
        return measureViewDesiredHeight(r9, r0, r11);
    L22:
        r6 = null;
        goto L23
    L19:
        r5 = null;
        goto L20
    L9:
        r3 = false;
    L46:
        return 0;
    }

    private final int resolveHostCenterOffset(Rect r1, int r2) {
        return r1.centerX() - (r2 / 2);
    }

    private final int resolveMeasureHeight(int r1, int r2) {
        if (r1 > 0) goto L4;
        return r2;
    L4:
        return Math.min(r1, r2);
    }

    private final int resolveOverflowFitTargetBottom(Rect r5, Rect r6) {
        int r0 = r5.width();
        int r1 = r5.height();
        if (r5.top <= 0) goto L11;
        boolean r3 = true;
        if (Math.abs(r6.left) > 1) goto L11;
        if (Math.abs(r6.right - r0) > 1) goto L11;
        if (Math.abs(r6.bottom - r1) > 1) goto L11;
    L12:
        if (r3 == false) goto L15;
        return r1;
    L15:
        return r5.bottom;
    L11:
        r3 = false;
        goto L12
    }

    private final void restoreStableBounds(BoundsState r2, String r3) {
        if (r2.isHidden() == false) goto L5;
        return;
    L5:
        if (r2.isRestoring() == true) goto L17;
        r2.setRestoring(true);
        restoreStableSheetBounds(r2, r3);     // Catch: Throwable -> L11
        r2.setRestoring(false);
        return;
    L11:
        th = move-exception;
        r2.setRestoring(false);
        throw th;
    }

    private final void restoreStableSheetBounds(BoundsState r17, String r18) {
        if (r17.isStableInstalled() == true) goto L5;
        return;
    L5:
        if (isStrongStableMode(r17.getStableMode()) == true) goto L7;
        return;
    L7:
        if (r17.getStableGlobalTop() != UNSET_TOP) goto L9;
        return;
    L9:
        if (r17.getStableHeight() <= 0) goto L126;
        WeakReference<View> r2 = r17.getSheetRef();
        if (r2 == null) goto L125;
        View r3 = r2.get();
        if (r3 != null) goto L17;
        return;
    L17:
        if (isLayoutSamplingReason(r18) == false) goto L19;
        return;
    L19:
        Rect r4 = (Rect) viewGlobalVisibleRectResolver.invoke(r3);
        if (r4 != null) goto L22;
        return;
    L22:
        int r5 = r17.getStableGlobalTop() - r4.top;
        boolean r6 = false;
        if (r5 <= 1) goto L25;
        boolean r7 = true;
    L26:
        int r8 = r4.height() - r17.getStableHeight();
        int r9 = r3.getHeight() - r17.getStableHeight();
        if (r8 <= 1) goto L29;
        boolean r10 = true;
    L30:
        if (r9 <= 1) goto L32;
        boolean r11 = true;
    L34:
        if (isUnsettledBottomSheetState(r17.getBehavior()) == false) goto L36;
    L39:
        boolean r12 = true;
    L41:
        if (r17.isHidden() == true) goto L52;
        BottomSheetBehavior<View> r13 = r17.getBehavior();
        if (r13 == null) goto L45;
        Integer r14 = Integer.valueOf(r13.getState());
    L47:
        if (isHiddenBottomSheetState(r14) == true) goto L52;
        if (isHiddenBottomSheetState(r17.getCurrentBehaviorState()) == true) goto L52;
        boolean r15 = false;
    L53:
        BottomSheetBehavior<View> r16 = r17.getBehavior();
        if (r16 != null) goto L56;
    L58:
        boolean r19 = false;
    L59:
        if (r19 == true) goto L74;
        Integer r110 = r17.getCurrentBehaviorState();
        if (r110 != null) goto L64;
    L65:
        BottomSheetBehavior<View> r111 = r17.getBehavior();
        if (r111 != null) goto L68;
    L70:
        boolean r112 = false;
    L71:
        if (r112 == true) goto L74;
        boolean r113 = false;
    L75:
        if (r12 == true) goto L78;
        if (r113 == false) goto L78;
        boolean r114 = true;
    L79:
        if (r114 == true) goto L81;
    L83:
        boolean r115 = false;
    L84:
        if (r114 == true) goto L86;
    L88:
        boolean r20 = false;
    L89:
        if (r114 == true) goto L91;
    L93:
        boolean r21 = false;
    L94:
        if (r7 == true) goto L98;
        if (r115 == true) goto L98;
        boolean r116 = false;
    L99:
        if (r10 == true) goto L105;
        if (r11 == true) goto L105;
        if (r20 == true) goto L105;
        if (r21 == true) goto L105;
        boolean r22 = false;
    L107:
        if (r17.getStableMode() != BottomSheetStableMode.FULL_HEIGHT_EXPANDED) goto L110;
        if (r7 == false) goto L110;
        r6 = true;
    L110:
        if (r15 == false) goto L112;
        return;
    L112:
        if (r12 == false) goto L115;
        if (r6 == true) goto L115;
        return;
    L115:
        if (r116 == true) goto L118;
        if (r22 == true) goto L118;
        return;
    L118:
        if (r22 == false) goto L120;
        syncSheetHeight(r3, r17.getStableHeight(), true);
    L120:
        int r23 = r3.getTop() + r5;
        r3.layout(r3.getLeft(), r23, r3.getRight(), r17.getStableHeight() + r23);
        FLogger.a.i(TAG, "restore stable bounds, reason=" + r18 + ", top=" + r3.getTop() + ", height=" + r3.getHeight() + ", globalTop=" + r4.top + ", stableGlobalTop=" + r17.getStableGlobalTop() + ", stableHeight=" + r17.getStableHeight());
        return;
    L105:
        r22 = true;
    L98:
        r116 = true;
        goto L99
    L91:
        if (Math.abs(r9) <= 1) goto L93;
        r21 = true;
        goto L94
    L86:
        if (Math.abs(r8) <= 1) goto L88;
        r20 = true;
        goto L89
    L81:
        if (Math.abs(r5) <= 1) goto L83;
        r115 = true;
    L78:
        r114 = false;
        goto L79
    L68:
        if (r111.getSkipCollapsed() != true) goto L70;
        r112 = true;
        goto L71
    L64:
        if (r110.intValue() != 3) goto L65;
    L74:
        r113 = true;
        goto L75
    L56:
        if (r16.getState() != 3) goto L58;
        r19 = true;
        goto L59
    L45:
        r14 = null;
    L52:
        r15 = true;
        goto L53
    L36:
        if (isUnsettledBottomSheetState(r17.getCurrentBehaviorState()) == true) goto L39;
        r12 = false;
        goto L41
    L32:
        r11 = false;
        goto L34
    L29:
        r10 = false;
        goto L30
    L25:
        r7 = false;
        goto L26
    L125:
        return;
    }

    private final void sampleAndRestoreStableBounds(BoundsState r7, String r8) {
        Dialog r0 = r7.getDialogRef().get();
        if (r0 != null) goto L6;
        return;
    L6:
        if (states.get(r0) == r7) goto L8;
        return;
    L8:
        if (r7.isHidden() == false) goto L10;
        return;
    L10:
        if (r7.isRestoring() == false) goto L12;
        return;
    L12:
        if (r7.isSamplingEnabled() == false) goto L56;
        Rect r1 = resolveTargetChildDialogHostBounds(r0);
        if (r1 != null) goto L17;
        return;
    L17:
        r7.getHostBounds().set(r1);
        WeakReference<View> r2 = r7.getSheetRef();
        BottomSheetBehavior<View> r3 = null;
        if (r2 == null) goto L20;
        View r4 = r2.get();
    L21:
        if (r4 == null) goto L23;
        r3 = INSTANCE.resolveBottomSheetBehavior(r7, r4);
    L23:
        if (r3 == null) goto L25;
        r7.setCurrentBehaviorState(Integer.valueOf(r3.getState()));
        installBehaviorCallback(r7, r3);
    L25:
        if (r4 == null) goto L51;
        LandscapeChildDialogBoundsAdapter r5 = INSTANCE;
        r5.recordSheetLayoutRequest(r7, r4);
        if (r5.isLayoutSamplingReason(r8) == true) goto L29;
    L31:
        boolean r6 = false;
    L32:
        if (r6 == false) goto L36;
        if (r7.getStableMode() == BottomSheetStableMode.FULL_HEIGHT_EXPANDED) goto L36;
    L40:
        if (r5.installOrRefreshOverflowFitToHostTarget(r7, r4, r3, r8) == false) goto L44;
        r5.restoreStableBounds(r7, r8);
        return;
    L44:
        if (r7.isStableInstalled() == true) goto L48;
        if (r6 == true) goto L51;
        r5.sampleStableBounds(r7, r4, r3, r8);
        goto L51
    L48:
        if (r5.isStrongStableMode(r7.getStableMode()) == true) goto L51;
        if (r6 == true) goto L51;
        r5.refreshStableBehavior(r7, r4, r3, r8);
    L36:
        if (r5.installOrRefreshSettledFullHeightTarget(r7, r4, r3, r8) == false) goto L40;
        r5.restoreStableBounds(r7, r8);
        return;
    L29:
        if (r5.hasFullHeightExpandedIntent(r7, r4, r3) == false) goto L31;
        r6 = true;
    L51:
        restoreStableBounds(r7, r8);
        return;
    L20:
        r4 = null;
        goto L21
    }

    private final void setBottomSheetCallback(BoundsState r10, final BottomSheetBehavior.BottomSheetCallback r11) {
        BottomSheetBehavior<View> r0 = r10.getBehavior();
        if (r0 != null) goto L5;
        return;
    L5:
        Method[] r1 = r0.getClass().getMethods();
        int r2 = r1.length;
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L19;
        Method r6 = r1[r4];
        if (Intrinsics.areEqual(r6.getName(), "addBottomSheetCallback") == true) goto L11;
    L15:
        boolean r7 = false;
    L16:
        if (r7 == true) goto L21;
        r4 = r4 + 1;
    L21:
        if (r6 != null) goto L41;
    L32:
        final BottomSheetBehavior.BottomSheetCallback r3 = getSingleBottomSheetCallback(r0);
        r10.setPreviousBehaviorCallback(r3);
        BottomSheetBehavior.BottomSheetCallback r5 = new LandscapeChildDialogBoundsAdapter$setBottomSheetCallback$chainedCallback$1(r3, r11);
        r10.setBehaviorCallback(r5);
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L35
        r0.setBottomSheetCallback(r5);     // Catch: Throwable -> L35
        r10.setCallbackInstallMode(CallbackInstallMode.SET_SINGLE);     // Catch: Throwable -> L35
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        Throwable r12 = Result.exceptionOrNull-impl(r9);
        if (r12 == null) goto L47;
        r10.setBehaviorCallback(r11);
        FLogger.a.w(TAG, "setBottomSheetCallback failed", r12);
        return;
    L47:
        return;
    L35:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    L41:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L24
        r6.invoke(r0, new Object[]{r11});     // Catch: Throwable -> L24
        r10.setCallbackInstallMode(CallbackInstallMode.ADD_REMOVE);     // Catch: Throwable -> L24
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L30;
        FLogger.a.w(TAG, "addBottomSheetCallback failed", r16);
    L30:
        if (r10.getCallbackInstallMode() != CallbackInstallMode.ADD_REMOVE) goto L32;
        return;
    L24:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L11:
        if (r6.getParameterTypes().length != 1) goto L15;
        if (r6.getParameterTypes()[0].isAssignableFrom(BottomSheetBehavior.BottomSheetCallback.class) == false) goto L15;
        r7 = true;
        goto L16
    L19:
        r6 = null;
        goto L21
    }

    private final void setExpandedOffsetCompat(BottomSheetBehavior<View> r11, int r12) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        Method[] r1 = r11.getClass().getMethods();     // Catch: Throwable -> L19
        int r2 = r1.length;     // Catch: Throwable -> L19
        int r3 = 0;
    L3:
        Object r4 = null;
        if (r3 >= r2) goto L14;
        Method r6 = r1[r3];     // Catch: Throwable -> L19
        if (Intrinsics.areEqual(r6.getName(), "setExpandedOffset") == true) goto L8;
    L10:
        boolean r7 = false;
    L11:
        if (r7 == true) goto L15;
        r3 = r3 + 1;     // Catch: Throwable -> L19
    L15:
        if (r6 == null) goto L17;
        r4 = r6.invoke(r11, new Object[]{Integer.valueOf(r12)});     // Catch: Throwable -> L19
    L17:
        Object r13 = Result.constructor-impl(r4);     // Catch: Throwable -> L19
    L21:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L29;
        FLogger.a.w(TAG, "setExpandedOffsetCompat failed", r14);
        return;
    L29:
        return;
    L8:
        if (Arrays.equals(r6.getParameterTypes(), new Class[]{Integer.TYPE}) == false) goto L10;
        r7 = true;
        goto L11
    L14:
        r6 = null;
    L19:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    private final void setMaxHeightCompat(BottomSheetBehavior<View> r11, int r12) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        Method[] r1 = r11.getClass().getMethods();     // Catch: Throwable -> L19
        int r2 = r1.length;     // Catch: Throwable -> L19
        int r3 = 0;
    L3:
        Object r4 = null;
        if (r3 >= r2) goto L14;
        Method r6 = r1[r3];     // Catch: Throwable -> L19
        if (Intrinsics.areEqual(r6.getName(), "setMaxHeight") == true) goto L8;
    L10:
        boolean r7 = false;
    L11:
        if (r7 == true) goto L15;
        r3 = r3 + 1;     // Catch: Throwable -> L19
    L15:
        if (r6 == null) goto L17;
        r4 = r6.invoke(r11, new Object[]{Integer.valueOf(r12)});     // Catch: Throwable -> L19
    L17:
        Object r13 = Result.constructor-impl(r4);     // Catch: Throwable -> L19
    L21:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L29;
        FLogger.a.w(TAG, "setMaxHeightCompat failed", r14);
        return;
    L29:
        return;
    L8:
        if (Arrays.equals(r6.getParameterTypes(), new Class[]{Integer.TYPE}) == false) goto L10;
        r7 = true;
        goto L11
    L14:
        r6 = null;
    L19:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    private final boolean shouldDeferToBottomSheetOnStart(Dialog r2, String r3) {
        if (Intrinsics.areEqual(r3, "componentDialog:onStart") == true) goto L5;
    L7:
        return false;
    L5:
        if (isMaterialBottomSheetDialog(r2) == false) goto L7;
        return true;
    }

    public final void dispatchStateForTest$impl_mainlandRelease(Dialog r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        BoundsState r4 = states.get(r2);
        if (r4 != null) goto L5;
        return;
    L5:
        WeakReference<View> r0 = r4.getSheetRef();
        if (r0 == null) goto L14;
        View r1 = r0.get();
        if (r1 == null) goto L16;
        BottomSheetBehavior.BottomSheetCallback r5 = r4.getBehaviorCallback();
        if (r5 == null) goto L15;
        r5.onStateChanged(r1, r3);
        return;
    L15:
        return;
    L16:
        return;
    }

    public static final /* synthetic */ void access$restoreStableBounds(LandscapeChildDialogBoundsAdapter r0, BoundsState r1, String r2) {
        r0.restoreStableBounds(r1, r2);
    }

    public static final /* synthetic */ void access$sampleAndRestoreStableBounds(LandscapeChildDialogBoundsAdapter r0, BoundsState r1, String r2) {
        r0.sampleAndRestoreStableBounds(r1, r2);
    }

    private final boolean hasFullHeightExpandedIntent(BoundsState r1, View r2, BottomSheetBehavior<View> r3) {
        if (hasFullHeightRequest(r1, r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (isExpandedOrSkipCollapsed(r3) == false) goto L7;
        return true;
    }

    private final int measureViewDesiredHeight(View r4, int r5, int r6) {
        if (r5 <= 0) goto L29;
        if (r6 <= 0) goto L31;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        ViewGroup.LayoutParams r2 = r4.getLayoutParams();     // Catch: Throwable -> L18
        if (r2 == null) goto L9;
        int r3 = r2.height;     // Catch: Throwable -> L18
    L10:
        if (r3 <= 0) goto L13;
        r6 = Math.min(r3, r6);     // Catch: Throwable -> L18
    L13:
        if (r3 <= 0) goto L15;
        int r7 = 1073741824;
    L16:
        r4.measure(View.MeasureSpec.makeMeasureSpec(r5, 1073741824), View.MeasureSpec.makeMeasureSpec(r6, r7));     // Catch: Throwable -> L18
        Object r8 = Result.constructor-impl(Integer.valueOf(r4.getMeasuredHeight()));     // Catch: Throwable -> L18
    L21:
        if (Result.isFailure-impl(r8) == false) goto L23;
        r8 = null;
    L23:
        Integer r9 = (Integer) r8;
        if (r9 != null) goto L26;
        return 0;
    L26:
        return r9.intValue();
    L15:
        r7 = UNSET_TOP;
        goto L16
    L9:
        r3 = -2;
    L18:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L31:
        return 0;
    L29:
        return 0;
    }

    private final Integer measureViewWidth(View r3, int r4, int r5) {
        Object r0 = null;
        if (r3 != null) goto L15;
        return null;
    L15:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        r3.measure(r4, r5);     // Catch: Throwable -> L7
        Object r6 = Result.constructor-impl(Integer.valueOf(r3.getMeasuredWidth()));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r6) == true) goto L14;
        r0 = r6;
    L14:
        return (Integer) r0;
    L7:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    private final int measureWrapContentWidth(Window r5, WindowManager.LayoutParams r6, Rect r7) {
        int r0 = r7.width();
        int r8 = r7.height();
        if (r0 <= 0) goto L40;
        if (r8 <= 0) goto L42;
        int r2 = UNSET_TOP;
        int r1 = View.MeasureSpec.makeMeasureSpec(r0, UNSET_TOP);
        int r9 = resolveMeasureHeight(r6.height, r8);
        if (r6.height <= 0) goto L9;
        r2 = 1073741824;
    L9:
        int r10 = View.MeasureSpec.makeMeasureSpec(r9, r2);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L12
        Object r12 = Result.constructor-impl(INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_landscape_childwindow_LandscapeChildDialogBoundsAdapter_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r5));     // Catch: Throwable -> L12
    L14:
        ViewGroup r3 = null;
        if (Result.isFailure-impl(r12) == false) goto L17;
        r12 = null;
    L17:
        View r13 = (View) r12;
        if (r13 == null) goto L20;
        r3 = (ViewGroup) r13.findViewById(R.id.content);
    L20:
        List r14 = CollectionsKt.listOfNotNull(new Integer[]{measureViewWidth(r13, r1, r10), measureViewWidth(r3, r1, r10)});
        ArrayList r15 = new ArrayList();
        Iterator r16 = r14.iterator();
    L22:
        if (r16.hasNext() == false) goto L29;
        Object r4 = r16.next();
        if (((Number) r4).intValue() <= 0) goto L26;
        boolean r17 = true;
    L27:
        if (r17 == false) goto L22;
        r15.add(r4);
        goto L22
    L26:
        r17 = false;
        goto L27
    L29:
        Integer r18 = (Integer) CollectionsKt.maxOrNull(r15);
        if (r18 != null) goto L32;
        return 0;
    L32:
        return r18.intValue();
    L12:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L42:
        return 0;
    L40:
        return 0;
    }

    private final void normalizeStableSheetBounds(BoundsState r7, View r8, String r9) {
        if (r7.getHasNormalizedStableBounds() == false) goto L5;
        return;
    L5:
        if (r7.isStableInstalled() == true) goto L7;
        return;
    L7:
        if (isStrongStableMode(r7.getStableMode()) == true) goto L9;
        return;
    L9:
        if (r7.getStableGlobalTop() != UNSET_TOP) goto L11;
        return;
    L11:
        if (r7.getStableHeight() <= 0) goto L48;
        Rect r0 = (Rect) viewGlobalVisibleRectResolver.invoke(r8);
        if (r0 != null) goto L16;
        return;
    L16:
        Integer r1 = Integer.valueOf(r0.height());
        boolean r3 = false;
        if (r1.intValue() <= 0) goto L19;
        boolean r2 = true;
    L20:
        if (r2 == true) goto L23;
        r1 = null;
    L23:
        if (r1 == null) goto L25;
        int r4 = r1.intValue();
    L26:
        int r5 = r7.getStableGlobalTop() - r0.top;
        if (Math.abs(r5) <= 1) goto L29;
        boolean r6 = true;
    L31:
        if (Math.abs(r4 - r7.getStableHeight()) <= 1) goto L33;
    L34:
        r3 = true;
    L35:
        if (r6 == true) goto L40;
        if (r3 == true) goto L40;
        r7.setHasNormalizedStableBounds(true);
        return;
    L40:
        if (isLayoutSamplingReason(r9) == false) goto L42;
        return;
    L42:
        syncSheetHeight(r8, r7.getStableHeight(), true);
        int r10 = r8.getTop() + r5;
        r8.layout(r8.getLeft(), r10, r8.getRight(), r7.getStableHeight() + r10);
        r7.setHasNormalizedStableBounds(true);
        return;
    L33:
        if (Math.abs(r8.getHeight() - r7.getStableHeight()) <= 1) goto L35;
    L29:
        r6 = false;
        goto L31
    L25:
        r4 = r8.getHeight();
        goto L26
    L19:
        r2 = false;
        goto L20
    }

    private final HorizontalBounds resolveOnStartHorizontalBounds(Window r5, WindowManager.LayoutParams r6, Rect r7) {
        int r0 = r7.width();
        Integer r1 = (Integer) screenWidthResolver.invoke(r5);
        if (r1 == null) goto L24;
        int r2 = r1.intValue();
        if (r0 <= 0) goto L24;
        if (r2 <= 0) goto L24;
        int r3 = resolveHostCenterOffset(r7, r2);
        SizeRequestMode r4 = resolveSizeRequestMode(Integer.valueOf(r6.width));
        if (Intrinsics.areEqual(r4, SizeRequestMode.MatchParent.INSTANCE) == false) goto L12;
        return new HorizontalBounds(r0, r3);
    L12:
        if ((r4 instanceof SizeRequestMode.Fixed) == false) goto L16;
        HorizontalBounds r8 = new HorizontalBounds(Math.min(((SizeRequestMode.Fixed) r4).getSize(), r0), r3);
    L26:
        return r8;
    L16:
        if (Intrinsics.areEqual(r4, SizeRequestMode.WrapContent.INSTANCE) == false) goto L23;
        int r9 = measureWrapContentWidth(r5, r6, r7);
        if (r9 <= 0) goto L21;
        r8 = new HorizontalBounds(Math.min(r9, r0), r3);
        goto L26
    L21:
        return new HorizontalBounds(-2, r3);
    L23:
        throw new NoWhenBranchMatchedException();
    L24:
        return null;
    }

    private final StableSheetTarget resolveOverflowFitToHostTarget(BoundsState r9, View r10, BottomSheetBehavior<View> r11) {
        Rect r0 = r9.getHostBounds();
        boolean r2 = false;
        if (r0.isEmpty() == false) goto L5;
    L9:
        boolean r1 = false;
    L11:
        if (r1 == true) goto L14;
        r0 = null;
    L14:
        if (r0 != null) goto L16;
        return null;
    L16:
        int r3 = r0.height();
        Rect r5 = (Rect) viewGlobalVisibleRectResolver.invoke(r10);
        if (r5 != null) goto L19;
    L56:
        return null;
    L19:
        if ((!r5.isEmpty()) == true) goto L22;
        r5 = null;
    L22:
        if (r5 == null) goto L56;
        Integer r6 = Integer.valueOf(r5.height());
        if (r6.intValue() <= 0) goto L27;
        boolean r7 = true;
    L28:
        if (r7 == true) goto L31;
        r6 = null;
    L31:
        if (r6 == null) goto L33;
        int r8 = r6.intValue();
    L34:
        if (r8 > 0) goto L36;
        return null;
    L36:
        int r12 = resolveBottomSheetDesiredContentHeight(r10, r0);
        if (r12 > 0) goto L39;
        return null;
    L39:
        int r4 = Math.min(r12, r3);
        if (r4 > 0) goto L43;
        return null;
    L43:
        if (r9.getStableMode() != BottomSheetStableMode.OVERFLOW_FIT_TO_HOST) goto L45;
        r2 = true;
    L45:
        if (r2 == false) goto L47;
    L49:
        int r13 = resolveOverflowFitTargetBottom(r0, r5);
        if (r2 == false) goto L52;
    L54:
        int r14 = r13 - r4;
        return new StableSheetTarget(r14, r14 - (r5.top - r10.getTop()), r4);
    L52:
        if (canExpandOverflowSheet(r5, r0, r11, r4) == true) goto L54;
        return null;
    L47:
        if (r4 > (r8 + 1)) goto L49;
        return null;
    L33:
        r8 = r10.getHeight();
        goto L34
    L27:
        r7 = false;
        goto L28
    L5:
        if (r0.width() <= 0) goto L9;
        if (r0.height() <= 0) goto L9;
        r1 = true;
        goto L11
    }

    private final StableSheetTarget resolveSettledFullHeightTarget(BoundsState r2, View r3, BottomSheetBehavior<View> r4) {
        if (hasFullHeightExpandedIntent(r2, r3, r4) == true) goto L5;
        return null;
    L5:
        if (isUnsettledBottomSheetState(r4) == false) goto L8;
        return null;
    L8:
        if (r2.isStableInstalled() == false) goto L14;
        if (r2.getStableMode() != BottomSheetStableMode.FULL_HEIGHT_EXPANDED) goto L14;
        return new StableSheetTarget(r2.getStableGlobalTop(), r2.getStableLocalTop(), r2.getStableHeight());
    L14:
        return resolveSettledSheetStableTarget(r3);
    }

    private final boolean shouldApplyFullHeightExpandedParams(BoundsState r3, View r4, BottomSheetBehavior<View> r5) {
        if (r3.getStableHeight() > 0) goto L6;
        return false;
    L6:
        if (hasFullHeightExpandedIntent(r3, r4, r5) == true) goto L8;
        return false;
    L8:
        if (isUnsettledBottomSheetState(r5) == true) goto L12;
        return true;
    L12:
        return false;
    }

    private final boolean shouldPromoteCurrentLayoutToFullHeight(BoundsState r4, View r5, BottomSheetBehavior<View> r6) {
        if (r4.getStableMode() != BottomSheetStableMode.FULL_HEIGHT_EXPANDED) goto L5;
        return false;
    L5:
        if (hasFullHeightExpandedIntent(r4, r5, r6) == true) goto L7;
        return false;
    L7:
        if (isUnsettledBottomSheetState(r6) == true) goto L28;
        Rect r7 = (Rect) viewGlobalVisibleRectResolver.invoke(r5);
        if (r7 != null) goto L12;
        return false;
    L12:
        Integer r8 = Integer.valueOf(r7.height());
        if (r8.intValue() <= 0) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == true) goto L19;
        r8 = null;
    L19:
        if (r8 == null) goto L21;
        int r10 = r8.intValue();
    L22:
        if (r10 <= 0) goto L27;
        return true;
    L27:
        return false;
    L21:
        r10 = r5.getHeight();
        goto L22
    L15:
        r9 = false;
        goto L16
    L28:
        return false;
    }

    private final void syncSheetHeight(View r3, int r4, boolean r5) {
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.height != r4) goto L10;
        if (r5 == false) goto L12;
        r3.requestLayout();
        return;
    L12:
        return;
    L10:
        r0.height = r4;
        r3.setLayoutParams(r0);
        r3.requestLayout();
    }

    private final void updateStableBoundsFromCurrentLayout(BoundsState r5, View r6, String r7) {
        if (r5.getStableMode() == BottomSheetStableMode.NONE) goto L5;
        return;
    L5:
        Rect r0 = (Rect) viewGlobalVisibleRectResolver.invoke(r6);
        if (r0 != null) goto L8;
        return;
    L8:
        Integer r1 = Integer.valueOf(r0.height());
        if (r1.intValue() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == true) goto L15;
        r1 = null;
    L15:
        if (r1 == null) goto L17;
        int r3 = r1.intValue();
    L19:
        if (r0.top == UNSET_TOP) goto L29;
        if (r3 > 0) goto L23;
        return;
    L23:
        if (r5.getStableGlobalTop() == r0.top) goto L25;
    L27:
        r5.setStableGlobalTop(r0.top);
        r5.setStableLocalTop(r6.getTop());
        r5.setStableHeight(r3);
        FLogger.a.i(TAG, "refresh stable bounds for full height sheet, reason=" + r7 + ", dialog=" + r5.getDialogRef().get() + ", globalTop=" + r5.getStableGlobalTop() + ", localTop=" + r5.getStableLocalTop() + ", height=" + r5.getStableHeight());
        return;
    L25:
        if (r5.getStableHeight() != r3) goto L27;
        return;
    L29:
        return;
    L17:
        r3 = r6.getHeight();
        goto L19
    L11:
        r2 = false;
        goto L12
    }

    private final void applyFullHeightExpandedParams(BoundsState r7, View r8, BottomSheetBehavior<View> r9, boolean r10) {
        syncSheetHeight$default(this, r8, r7.getStableHeight(), false, 4, null);
        if (r9 == null) goto L41;
        INSTANCE.setMaxHeightCompat(r9, r7.getStableHeight());
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L7
        r9.setPeekHeight(r7.getStableHeight());     // Catch: Throwable -> L7
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L39;
        FLogger.a.w(TAG, "setPeekHeight failed", r13);
    L39:
        r9.setSkipCollapsed(true);     // Catch: Throwable -> L15
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L21;
        FLogger.a.w(TAG, "setSkipCollapsed failed", r15);
    L21:
        if (r9.isFitToContents() == false) goto L23;
    L25:
        if (r10 == true) goto L37;
        return;
    L37:
        r9.setState(3);     // Catch: Throwable -> L29
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L43;
        FLogger.a.w(TAG, "setExpandedState failed", r17);
        return;
    L43:
        return;
    L29:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L23:
        if (r7.getStableLocalTop() == UNSET_TOP) goto L25;
        INSTANCE.setExpandedOffsetCompat(r9, r7.getStableLocalTop());
    L15:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    private final void applyOverflowFitToHostParams(BoundsState r7, View r8, BottomSheetBehavior<View> r9, boolean r10) {
        syncSheetHeight$default(this, r8, r7.getStableHeight(), false, 4, null);
        setMaxHeightCompat(r9, r7.getStableHeight());
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        r9.setPeekHeight(r7.getStableHeight());     // Catch: Throwable -> L5
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L11;
        FLogger.a.w(TAG, "setOverflowPeekHeight failed", r13);
    L11:
        if (r9.isFitToContents() == false) goto L13;
    L15:
        if (r10 == true) goto L25;
        return;
    L25:
        r9.setState(3);     // Catch: Throwable -> L19
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L30;
        FLogger.a.w(TAG, "setOverflowExpandedState failed", r15);
        return;
    L30:
        return;
    L19:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L13:
        if (r7.getStableLocalTop() == UNSET_TOP) goto L15;
        setExpandedOffsetCompat(r9, r7.getStableLocalTop());
    L5:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private final boolean canExpandOverflowSheet(Rect r2, Rect r3, BottomSheetBehavior<View> r4, int r5) {
        if (r2.top <= (r3.top + 1)) goto L5;
        return true;
    L5:
        int r6 = r4.getState();
        if (r6 != 4) goto L8;
        return true;
    L8:
        if (r6 == 6) goto L19;
        int r7 = r4.getPeekHeight();
        if (1 > r7) goto L13;
        if (r7 >= r5) goto L13;
        boolean r8 = true;
    L14:
        if (r8 == true) goto L20;
        return false;
    L20:
        return true;
    L13:
        r8 = false;
        goto L14
    L19:
        return true;
    }

    private final boolean installOrRefreshOverflowFitToHostTarget(BoundsState r6, View r7, BottomSheetBehavior<View> r8, String r9) {
        boolean r2 = false;
        if (r6.getStableMode() == BottomSheetStableMode.FULL_HEIGHT_EXPANDED) goto L38;
        if (r8 == null) goto L38;
        if (hasFullHeightExpandedIntent(r6, r7, r8) == true) goto L38;
        if (isUnsettledBottomSheetState(r8) == true) goto L38;
        if (isHiddenBottomSheetState(Integer.valueOf(r8.getState())) == true) goto L38;
        if (isHiddenBottomSheetState(r6.getCurrentBehaviorState()) == true) goto L38;
        StableSheetTarget r0 = resolveOverflowFitToHostTarget(r6, r7, r8);
        if (r0 != null) goto L18;
        return false;
    L18:
        if (r6.isStableInstalled() == true) goto L20;
    L29:
        boolean r1 = true;
    L30:
        if (r1 == false) goto L32;
        r6.setStableGlobalTop(r0.getGlobalTop());
        r6.setStableLocalTop(r0.getLocalTop());
        r6.setStableHeight(r0.getHeight());
        r6.setWarmUpSamples(3);
        r6.setStableInstalled(true);
        r6.setStableMode(BottomSheetStableMode.OVERFLOW_FIT_TO_HOST);
        r6.setHasNormalizedStableBounds(false);
    L32:
        if (r1 == false) goto L34;
    L35:
        r2 = true;
    L36:
        applyOverflowFitToHostParams(r6, r7, r8, r2);
        normalizeStableSheetBounds(r6, r7, r9);
        return true;
    L34:
        if (isUnsettledBottomSheetState(r8) == true) goto L36;
    L20:
        if (r6.getStableMode() != BottomSheetStableMode.OVERFLOW_FIT_TO_HOST) goto L29;
        if (r6.getStableGlobalTop() != r0.getGlobalTop()) goto L29;
        if (r6.getStableLocalTop() != r0.getLocalTop()) goto L29;
        if (r6.getStableHeight() != r0.getHeight()) goto L29;
        r1 = false;
    L38:
        return false;
    }

    private final boolean installOrRefreshSettledFullHeightTarget(BoundsState r6, View r7, BottomSheetBehavior<View> r8, String r9) {
        boolean r1 = false;
        if (isUnsettledBottomSheetState(r8) == false) goto L5;
        return false;
    L5:
        StableSheetTarget r0 = resolveSettledFullHeightTarget(r6, r7, r8);
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r6.isStableInstalled() == true) goto L11;
    L20:
        boolean r2 = true;
    L21:
        if (r2 == false) goto L23;
        r6.setStableGlobalTop(r0.getGlobalTop());
        r6.setStableLocalTop(r0.getLocalTop());
        r6.setStableHeight(r0.getHeight());
        r6.setWarmUpSamples(3);
        r6.setStableInstalled(true);
        r6.setStableMode(BottomSheetStableMode.FULL_HEIGHT_EXPANDED);
        r6.setHasNormalizedStableBounds(false);
    L23:
        if (r2 == false) goto L25;
    L26:
        r1 = true;
    L27:
        applyFullHeightExpandedParams(r6, r7, r8, r1);
        normalizeStableSheetBounds(r6, r7, r9);
        return true;
    L25:
        if (isUnsettledBottomSheetState(r8) == true) goto L27;
    L11:
        if (r6.getStableMode() != BottomSheetStableMode.FULL_HEIGHT_EXPANDED) goto L20;
        if (r6.getStableGlobalTop() != r0.getGlobalTop()) goto L20;
        if (r6.getStableLocalTop() != r0.getLocalTop()) goto L20;
        if (r6.getStableHeight() != r0.getHeight()) goto L20;
        r2 = false;
        goto L21
    }

    private final void refreshStableBehavior(BoundsState r10, View r11, BottomSheetBehavior<View> r12, String r13) {
        if (r10.getStableHeight() > 0) goto L5;
        return;
    L5:
        if (r12 == null) goto L8;
        INSTANCE.installBehaviorCallback(r10, r12);
    L8:
        if (isUnsettledBottomSheetState(r12) == false) goto L11;
        return;
    L11:
        if (shouldPromoteCurrentLayoutToFullHeight(r10, r11, r12) == false) goto L14;
        updateStableBoundsFromCurrentLayout(r10, r11, r13);
    L14:
        if (shouldApplyFullHeightExpandedParams(r10, r11, r12) == true) goto L16;
        return;
    L16:
        BottomSheetStableMode r0 = r10.getStableMode();
        BottomSheetStableMode r1 = BottomSheetStableMode.FULL_HEIGHT_EXPANDED;
        if (r0 != r1) goto L19;
        boolean r2 = true;
    L20:
        updateStableBoundsFromCurrentLayout(r10, r11, r13);
        r10.setStableMode(r1);
        applyFullHeightExpandedParams$default(this, r10, r11, r12, false, 8, null);
        if (r2 == true) goto L23;
        normalizeStableSheetBounds(r10, r11, r13);
    L23:
        FLogger.a.i(TAG, "activate full height stable behavior, reason=" + r13 + ", dialog=" + r10.getDialogRef().get() + ", stableTop=" + r10.getStableGlobalTop() + ", stableHeight=" + r10.getStableHeight());
        return;
    L19:
        r2 = false;
        goto L20
    }

    private final void sampleStableBounds(BoundsState r9, View r10, BottomSheetBehavior<View> r11, String r12) {
        if (r9.isStableInstalled() == false) goto L5;
        return;
    L5:
        if (r9.getWarmUpSamples() < 3) goto L8;
        return;
    L8:
        if (isUnsettledBottomSheetState(r11) == false) goto L10;
        return;
    L10:
        Rect r0 = (Rect) viewGlobalVisibleRectResolver.invoke(r10);
        if (r0 != null) goto L13;
        return;
    L13:
        Integer r2 = Integer.valueOf(r0.height());
        boolean r4 = false;
        if (r2.intValue() <= 0) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == true) goto L20;
        r2 = null;
    L20:
        if (r2 == null) goto L22;
        int r5 = r2.intValue();
    L24:
        if (r0.top == UNSET_TOP) goto L44;
        if (r5 > 0) goto L28;
        return;
    L28:
        if (r9.getStableGlobalTop() != UNSET_TOP) goto L30;
    L31:
        r9.setStableGlobalTop(r0.top);
        r9.setStableLocalTop(r10.getTop());
        r4 = true;
    L33:
        if (r9.getStableHeight() > 0) goto L35;
    L36:
        r9.setStableHeight(r5);
        r4 = true;
    L37:
        r9.setWarmUpSamples(r9.getWarmUpSamples() + 1);
        if (r9.getWarmUpSamples() >= 3) goto L41;
        FLogger.a.i(TAG, "warm up stable bounds, reason=" + r12 + ", samples=" + r9.getWarmUpSamples() + ", globalTop=" + r9.getStableGlobalTop() + ", localTop=" + r9.getStableLocalTop() + ", height=" + r9.getStableHeight() + ", changed=" + r4);
        return;
    L41:
        r9.setStableInstalled(true);
        refreshStableBehavior(r9, r10, r11, r12);
        FLogger.a.i(TAG, "install stable bounds, reason=" + r12 + ", dialog=" + r9.getDialogRef().get() + ", globalTop=" + r9.getStableGlobalTop() + ", localTop=" + r9.getStableLocalTop() + ", height=" + r9.getStableHeight() + ", stableMode=" + r9.getStableMode());
        return;
    L35:
        if (r5 >= r9.getStableHeight()) goto L37;
    L30:
        if (r0.top <= r9.getStableGlobalTop()) goto L33;
    L44:
        return;
    L22:
        r5 = r10.getHeight();
        goto L24
    L16:
        r3 = false;
        goto L17
    }

    public static /* synthetic */ void syncSheetHeight$default(LandscapeChildDialogBoundsAdapter r0, View r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.syncSheetHeight(r1, r2, r3);
    }

    public static /* synthetic */ void applyFullHeightExpandedParams$default(LandscapeChildDialogBoundsAdapter r0, BoundsState r1, View r2, BottomSheetBehavior r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = true;
    L5:
        r0.applyFullHeightExpandedParams(r1, r2, r3, r4);
    }

    public static /* synthetic */ void applyOverflowFitToHostParams$default(LandscapeChildDialogBoundsAdapter r0, BoundsState r1, View r2, BottomSheetBehavior r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = true;
    L5:
        r0.applyOverflowFitToHostParams(r1, r2, r3, r4);
    }

    private static final void installStableListeners$lambda$20(BoundsState r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        INSTANCE.sampleAndRestoreStableBounds(r0, "layout");
    }
}
