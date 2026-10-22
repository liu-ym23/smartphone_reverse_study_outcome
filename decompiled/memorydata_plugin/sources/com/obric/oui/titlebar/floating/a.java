package com.obric.oui.titlebar.floating;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBarActionHost;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\t\n\u0002\b$\u0018\u0000 ß\u00012\u00020\u0001:\fÞ\u0001ß\u0001à\u0001á\u0001â\u0001ã\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u00062\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0002J:\u0010E\u001a\u00020\t2\u0006\u0010C\u001a\u00020D2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010I2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010K\u001a\u00020\rH\u0002J\b\u0010L\u001a\u00020\tH\u0002J\b\u0010M\u001a\u00020GH\u0002J\b\u0010N\u001a\u00020\tH\u0002J\r\u0010O\u001a\u00020\tH\u0000¢\u0006\u0002\bPJ\b\u0010Q\u001a\u00020\tH\u0002J\b\u0010R\u001a\u00020\tH\u0002J\b\u0010S\u001a\u00020$H\u0002J\b\u0010T\u001a\u00020$H\u0002J\b\u0010U\u001a\u00020$H\u0002J\b\u0010V\u001a\u00020\tH\u0002J\b\u0010W\u001a\u00020\tH\u0002J\b\u0010X\u001a\u00020\tH\u0002J#\u0010Y\u001a\b\u0012\u0004\u0012\u00020[0Z2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_H\u0002¢\u0006\u0002\u0010`J,\u0010a\u001a\u00020\u00062\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020g2\n\b\u0002\u0010h\u001a\u0004\u0018\u00010gH\u0002J2\u0010i\u001a\b\u0018\u00010jR\u00020\u00002\u0006\u0010k\u001a\u00020@2\u0006\u0010l\u001a\u00020g2\u0006\u0010m\u001a\u00020G2\n\b\u0002\u0010n\u001a\u0004\u0018\u00010gH\u0002J\u0010\u0010o\u001a\u00020\t2\u0006\u0010p\u001a\u00020GH\u0002J\b\u0010q\u001a\u00020\tH\u0002J\u0014\u0010r\u001a\u00020\r2\n\u0010s\u001a\u00060jR\u00020\u0000H\u0002J@\u0010t\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u00062\u0006\u0010l\u001a\u00020g2\n\u0010s\u001a\u00060jR\u00020\u00002\u0006\u0010F\u001a\u00020G2\u0012\u0010u\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0vH\u0002J\u001c\u0010w\u001a\u0004\u0018\u00010G2\u0006\u0010x\u001a\u00020]2\b\b\u0002\u0010y\u001a\u00020BH\u0002J\b\u0010z\u001a\u00020\tH\u0002J\b\u0010{\u001a\u00020\tH\u0002J\r\u0010|\u001a\u00020\tH\u0000¢\u0006\u0002\b}J,\u0010~\u001a\u00020\t2\u0006\u0010d\u001a\u00020e2\u0006\u0010>\u001a\u00020\u00062\n\u0010s\u001a\u00060jR\u00020\u00002\u0006\u0010\u007f\u001a\u00020@H\u0002JA\u0010\u0080\u0001\u001a\u00020\t2\u0006\u0010d\u001a\u00020e2\u0006\u0010>\u001a\u00020\u00062\f\u0010s\u001a\b\u0018\u00010jR\u00020\u00002\u0006\u0010\u007f\u001a\u00020@2\u0007\u0010\u0081\u0001\u001a\u00020\r2\u0007\u0010\u0082\u0001\u001a\u00020\rH\u0002J\u001b\u0010\u0083\u0001\u001a\u00020\t2\u0007\u0010\u0084\u0001\u001a\u00020\r2\u0007\u0010\u0081\u0001\u001a\u00020\rH\u0002J\u0011\u0010\u0085\u0001\u001a\u00020\t2\u0006\u0010F\u001a\u00020GH\u0002J\u0014\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u00012\u0006\u0010b\u001a\u00020cH\u0002J\u0015\u0010\u0088\u0001\u001a\u0004\u0018\u00010;2\b\u0010\u0089\u0001\u001a\u00030\u0087\u0001H\u0002J\f\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0002J\u001b\u0010\u008c\u0001\u001a\u00020\r2\u0007\u0010\u008d\u0001\u001a\u00020@2\u0007\u0010\u008e\u0001\u001a\u00020$H\u0002JL\u0010\u008f\u0001\u001a\u00020\t2\u0007\u0010\u0090\u0001\u001a\u00020@2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010@2\u0007\u0010\u008e\u0001\u001a\u00020$2\u000f\u0010H\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010I0\u0091\u00012\u0013\u0010\u0092\u0001\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0vH\u0002J&\u0010\u0093\u0001\u001a\u00020\r2\u0007\u0010\u0090\u0001\u001a\u00020@2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010@2\u0007\u0010\u008e\u0001\u001a\u00020$H\u0002J\t\u0010\u0094\u0001\u001a\u00020\tH\u0002J\t\u0010\u0095\u0001\u001a\u00020\tH\u0002J\t\u0010\u0096\u0001\u001a\u00020\tH\u0002J\u000f\u0010\u0097\u0001\u001a\u00020\tH\u0000¢\u0006\u0003\b\u0098\u0001J\u000f\u0010\u0099\u0001\u001a\u00020\rH\u0000¢\u0006\u0003\b\u009a\u0001J\t\u0010\u009b\u0001\u001a\u00020\rH\u0002J\u0019\u0010\u009c\u0001\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u00062\u0006\u0010l\u001a\u00020gH\u0002J\u0011\u0010\u009d\u0001\u001a\u00020\r2\u0006\u0010F\u001a\u00020GH\u0002J\u0017\u0010\u009e\u0001\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u0006H\u0000¢\u0006\u0003\b\u009f\u0001J\u001f\u0010 \u0001\u001a\u00020\r2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010@2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010$H\u0002J\t\u0010¡\u0001\u001a\u00020\tH\u0002J\t\u0010¢\u0001\u001a\u00020\tH\u0002J*\u0010£\u0001\u001a\u00020\r2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010@2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010@2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010$H\u0002J\u0007\u0010¤\u0001\u001a\u00020\tJ\n\u0010¥\u0001\u001a\u00030¦\u0001H\u0002J\u0018\u0010§\u0001\u001a\u00020\t2\u0007\u0010¨\u0001\u001a\u00020*H\u0000¢\u0006\u0003\b©\u0001J\u0018\u0010ª\u0001\u001a\u00020\t2\u0007\u0010¨\u0001\u001a\u00020*H\u0000¢\u0006\u0003\b«\u0001J\u0019\u0010¬\u0001\u001a\u00020\t2\b\u0010>\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0003\b\u00ad\u0001J\u0012\u0010®\u0001\u001a\u00020\t2\t\b\u0002\u0010¯\u0001\u001a\u00020\rJ\t\u0010°\u0001\u001a\u00020\tH\u0002J\t\u0010±\u0001\u001a\u00020\tH\u0002J\u001a\u0010²\u0001\u001a\u00020\t2\u0007\u0010³\u0001\u001a\u00020@2\u0006\u0010F\u001a\u00020GH\u0002J\u0012\u0010´\u0001\u001a\u00020\t2\u0007\u0010µ\u0001\u001a\u00020\u000bH\u0002J8\u0010¶\u0001\u001a\u00020\t2\u0006\u0010d\u001a\u00020e2\u0006\u0010>\u001a\u00020\u00062\f\u0010s\u001a\b\u0018\u00010jR\u00020\u00002\u0006\u0010\u007f\u001a\u00020@2\u0007\u0010\u0081\u0001\u001a\u00020\rH\u0002J2\u0010·\u0001\u001a\u00020\t2\u0006\u0010d\u001a\u00020e2\u0006\u0010>\u001a\u00020\u00062\f\u0010s\u001a\b\u0018\u00010jR\u00020\u00002\t\b\u0002\u0010¸\u0001\u001a\u00020\rH\u0002J(\u0010¹\u0001\u001a\u00020\t2\n\u0010s\u001a\u00060jR\u00020\u00002\u0011\b\u0002\u0010º\u0001\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J\u000f\u0010»\u0001\u001a\u00020\t2\u0006\u0010F\u001a\u00020GJ\u0011\u0010¼\u0001\u001a\u00020\t2\u0006\u0010F\u001a\u00020GH\u0002J\t\u0010½\u0001\u001a\u00020\tH\u0002JG\u0010¾\u0001\u001a\u00020\r2\u0006\u0010F\u001a\u00020G2\b\u0010¿\u0001\u001a\u00030À\u00012\t\b\u0002\u0010Á\u0001\u001a\u00020\r2\u001f\u0010Â\u0001\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0v\u0012\u0004\u0012\u00020\t0vH\u0002J \u0010Ã\u0001\u001a\u00020\r2\u0006\u0010F\u001a\u00020G2\r\u0010Â\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0002J\u0011\u0010Ä\u0001\u001a\u00020\t2\u0006\u0010F\u001a\u00020GH\u0002J\u0011\u0010Å\u0001\u001a\u00020\t2\u0006\u0010F\u001a\u00020GH\u0002J\u0014\u0010Æ\u0001\u001a\u00020\t2\t\b\u0002\u0010Ç\u0001\u001a\u00020\rH\u0002J\t\u0010È\u0001\u001a\u00020\tH\u0002J7\u0010É\u0001\u001a\u00020\r2\u0006\u0010C\u001a\u00020D2\u0006\u0010F\u001a\u00020G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I2\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J\u0012\u0010Ê\u0001\u001a\u00020\t2\t\u0010Ë\u0001\u001a\u0004\u0018\u00010\u001bJ\u0012\u0010Ì\u0001\u001a\u00020\t2\u0007\u0010¨\u0001\u001a\u00020*H\u0002J\u0012\u0010Í\u0001\u001a\u00020\t2\u0007\u0010Î\u0001\u001a\u00020\rH\u0002J\u001d\u0010Ï\u0001\u001a\u00020\t2\t\b\u0002\u0010Ð\u0001\u001a\u00020\r2\t\b\u0002\u0010Ñ\u0001\u001a\u00020\rJ\u0007\u0010Ò\u0001\u001a\u00020\tJ&\u0010Ó\u0001\u001a\u00020\r2\t\u0010Ô\u0001\u001a\u0004\u0018\u00010I2\u0006\u0010F\u001a\u00020G2\b\u0010¿\u0001\u001a\u00030À\u0001H\u0002J\f\u0010M\u001a\u00020G*\u00020\u0006H\u0002J\u000e\u0010Õ\u0001\u001a\u00030¦\u0001*\u00020gH\u0002J\u0016\u0010Ö\u0001\u001a\u00020\t*\u00020D2\u0007\u0010³\u0001\u001a\u00020@H\u0002J\u001f\u0010×\u0001\u001a\u00020\t*\u00020D2\u0007\u0010Ø\u0001\u001a\u00020G2\u0007\u0010³\u0001\u001a\u00020@H\u0002J\r\u0010Ù\u0001\u001a\u00020G*\u00020]H\u0002J\u0016\u0010Ú\u0001\u001a\u00020\t*\u00020D2\u0007\u0010³\u0001\u001a\u00020@H\u0002J\u0016\u0010Û\u0001\u001a\u00020\t*\u00020D2\u0007\u0010³\u0001\u001a\u00020@H\u0002J\r\u0010Ü\u0001\u001a\u00020G*\u00020$H\u0002J\r\u0010Ü\u0001\u001a\u00020G*\u00020gH\u0002J\u0015\u0010Ý\u0001\u001a\u00020g*\u00020g2\u0006\u0010f\u001a\u00020gH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ä\u0001"}, d2 = {"Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge;", "", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "(Lcom/obric/oui/titlebar/OFloatingTitleBar;)V", "actionHost", "Lcom/obric/oui/titlebar/OFloatingTitleBarActionHost;", "activeFinishCoordinator", "Lkotlin/Function0;", "", "activeOverlay", "Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge$ActiveOverlay;", "activityTransitionFinished", "", "blastBufferQueueClass", "Ljava/lang/Class;", "blastCreateSurfaceMethod", "Ljava/lang/reflect/Method;", "blastDestroyMethod", "blastMergeWithNextTransactionMethod", "blastUpdateMethod", "blurRegionReflectionDisabled", "callback", "Landroid/view/IFloatingTransitionCallback$Stub;", "collectMaterialsMethod", "finishCallbackDispatched", "floatingTransitionEndListener", "Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge$OnFloatingTransitionEndListener;", "hasDrawnFirstFrame", "hasProvidedInterruptSnapshot", "hiddenByRegisterForTransition", "hiddenSourceActionHosts", "", "isRegistered", "isTransitionDrawing", "lastStableState", "Landroid/os/Bundle;", "launchActionHost", "pendingHideActions", "pendingRestoreHiddenActionsRunnable", "Ljava/lang/Runnable;", "pendingSourceAnimation", "Landroid/animation/Animator;", "pendingSurfaceDraw", "pendingSurfaceDrawCallbacks", "pendingTargetAnimation", "realActionsHiddenForTransition", "setBlurRegionsMethod", "sourceAnimationCallbackReceived", "sourceAnimationFallbackRunnable", "sourceAnimationPending", "sourceAnimationReady", "stateProvider", "Landroid/view/IFloatingTransitionStateProvider$Stub;", "surfaceGetNextFrameNumberMethod", "targetAnimationFallbackRunnable", "targetAnimationFinished", "targetTransitionActive", "token", "Landroid/os/IBinder;", "transitionStartPending", "applySurfaceBlurRegions", "host", "contentSurface", "Landroid/view/SurfaceControl;", "contentSurfaceTop", "", "transaction", "Landroid/view/SurfaceControl$Transaction;", "applyTransactionImmediately", InfoRequestQPSOptTraceLogger.REASON, "", "commitLatch", "Ljava/util/concurrent/CountDownLatch;", "onCommitted", "hasCommitListener", "armPendingTargetAnimationGate", "bridgeDebugSummary", "cancelPendingRestoreHiddenActions", "cancelPendingSourceAnimation", "cancelPendingSourceAnimation$OUI_standardRelease", "cancelSourceAnimationFallback", "cancelTargetAnimationFallback", "captureFloatingTransitionStateOnMain", "captureFloatingTransitionStateSync", "captureStableStateForService", "clearDrawingFlags", "clearPendingSourceAnimation", "clearPendingTargetAnimation", "collectSurfaceBlurRegions", "", "", "view", "Landroid/view/View;", "rootOffset", "", "(Landroid/view/View;[I)[[F", "createActionHost", "context", "Landroid/content/Context;", "decor", "Landroid/view/ViewGroup;", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/oui/titlebar/OFloatingTitleBarState;", TypedValues.AttributesType.S_TARGET, "createOverlayRenderTarget", "Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge$OverlayRenderTarget;", "parentSurface", "state", ActivityLifecycle.NAME, "targetState", "debugLog", "message", "dispatchFloatingTransitionFinished", "doSurfaceDraw", "renderTarget", "drawOverlayWhenHostReady", "onDrawn", "Lkotlin/Function1;", "findUnreadyOverlayChild", "root", "inheritedAlpha", "finishAsInterruptedSource", "finishCurrentOverlayToTargetState", "finishForUserInteraction", "finishForUserInteraction$OUI_standardRelease", "finishOverlayAfterTransition", "overlaySurface", "finishOverlayToRealActions", "releaseSurface", "deferRemove", "forceCleanupOverlay", "shouldShowRealActions", "forceRestoreHiddenActionsIfStillNeeded", "getActivity", "Landroid/app/Activity;", "getActivityToken", "activity", "getService", "Landroid/view/IFloatingTransitionSession;", "handleSourceHideTitleBarSync", "sourceSurface", "sourceState", "handleTransitionStartOnMain", "transitionSurface", "Ljava/util/concurrent/atomic/AtomicReference;", "complete", "handleTransitionStartSync", "hideBoundActionHostForTransition", "hideRealActions", "hideSourceActionHostsForTransition", "interruptForHostTargetChange", "interruptForHostTargetChange$OUI_standardRelease", "isFloatingSurfaceTransitionRunning", "isFloatingSurfaceTransitionRunning$OUI_standardRelease", "isFloatingTransitionActive", "layoutActionHost", "notifyFloatingTransitionFinished", "onActionHostBound", "onActionHostBound$OUI_standardRelease", "onCallbackHideTitleBar", "onCallbackTransitionCancelled", "onCallbackTransitionFinished", "onCallbackTransitionStart", "onTitleBarStateChanged", "overlayShadowExtraBottomPx", "", "playSourceAnimation", "animation", "playSourceAnimation$OUI_standardRelease", "playTargetAnimation", "playTargetAnimation$OUI_standardRelease", "prepareLaunchActionHost", "prepareLaunchActionHost$OUI_standardRelease", "register", "force", "releasePendingSourceAnimation", "releasePendingTargetAnimation", "releaseSurfaceControl", "surfaceControl", "removeInterruptedSourceOverlayResources", "overlay", "removeOverlayResources", "removeSourcePreviewHost", "removeContentSurface", "requestSurfaceDraw", "afterDraw", "restoreHiddenActionsIfIdle", "restoreHiddenActionsNow", "restoreHiddenSourceActionHosts", "runOnMainAsyncAndWait", "timeoutMs", "", "allowAsyncOnMain", "action", "runOnMainSync", "scheduleRestoreHiddenActionsFallback", "scheduleRestoreHiddenActionsFallbackIfNeeded", "scheduleSourceAnimationFallback", "finalFallback", "scheduleTargetAnimationFallback", "scheduleTransactionOnDraw", "setFloatingTransitionEndListener", "listener", "startAnimation", "stopOverlayAndRestoreRealActionsToTargetState", "keepHidden", "unregister", "restoreActions", "cleanupOverlay", "updateState", "waitForTransactionCommit", "latch", "effectiveContentY", "hideSurface", "invokeVisibilityTransactionMethod", "methodName", "overlayDebugSummary", "removeSurface", "showSurface", "summary", "withSourceStylesForDisappearingActions", "ActiveOverlay", "Companion", "OnFloatingTransitionEndListener", "OverlayRenderTarget", "TransitionCallback", "TransitionStateProvider", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {
    private static final Map<IBinder, a> R = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14784a = null;
    private boolean A;
    private Function0<Unit> B;
    private boolean C;
    private c D;
    private volatile boolean E;
    private volatile boolean F;
    private final List<OFloatingTitleBarActionHost> G;
    private Runnable H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f14785J;
    private Animator K;
    private Animator L;
    private Runnable M;
    private Runnable N;
    private volatile boolean O;
    private final android.view.a.AbstractBinderC0017a P;
    private final android.view.c.a Q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OFloatingTitleBar f14786b;
    private boolean c;
    private IBinder d;
    private boolean e;
    private final List<Function0<Unit>> f;
    private OFloatingTitleBarActionHost g;
    private boolean h;
    private Method i;
    private Method j;
    private Class<?> k;
    private Method l;
    private Method m;
    private Method n;
    private Method o;
    private Method p;
    private C0785a q;
    private Bundle r;
    private volatile boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private OFloatingTitleBarActionHost y;
    private boolean z;

    /* JADX INFO: renamed from: com.obric.oui.titlebar.floating.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0010\u0006\u001a\u00060\u0007R\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\r\u0010\u0016\u001a\u00060\u0007R\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J5\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\b\u0002\u0010\u0006\u001a\u00060\u0007R\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u00060\u0007R\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge$ActiveOverlay;", "", "decor", "Landroid/view/ViewGroup;", "host", "Lcom/obric/oui/titlebar/OFloatingTitleBarActionHost;", "renderTarget", "Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge$OverlayRenderTarget;", "Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge;", "overlaySurface", "Landroid/view/SurfaceControl;", "(Landroid/view/ViewGroup;Lcom/obric/oui/titlebar/OFloatingTitleBarActionHost;Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge$OverlayRenderTarget;Landroid/view/SurfaceControl;)V", "getDecor", "()Landroid/view/ViewGroup;", "getHost", "()Lcom/obric/oui/titlebar/OFloatingTitleBarActionHost;", "getOverlaySurface", "()Landroid/view/SurfaceControl;", "getRenderTarget", "()Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge$OverlayRenderTarget;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class C0785a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewGroup f14787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OFloatingTitleBarActionHost f14788b;
        private final d c;
        private final SurfaceControl d;

        public C0785a(ViewGroup r2, OFloatingTitleBarActionHost r3, d r4, SurfaceControl r5) {
            Intrinsics.checkNotNullParameter(r2, "decor");
            Intrinsics.checkNotNullParameter(r3, "host");
            Intrinsics.checkNotNullParameter(r4, "renderTarget");
            Intrinsics.checkNotNullParameter(r5, "overlaySurface");
            this.f14787a = r2;
            this.f14788b = r3;
            this.c = r4;
            this.d = r5;
        }

        public final ViewGroup a() {
            return this.f14787a;
        }

        public final OFloatingTitleBarActionHost b() {
            return this.f14788b;
        }

        public final d c() {
            return this.c;
        }

        public final SurfaceControl d() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0785a.class) == true) goto L8;
            return false;
        L8:
            C0785a r6 = (C0785a) ZeusTransformUtils.preCheckCast(r5, C0785a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f14787a, r6.f14787a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f14788b, r6.f14788b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f14787a.hashCode() * 31) + this.f14788b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return "ActiveOverlay(decor=" + this.f14787a + ", host=" + this.f14788b + ", renderTarget=" + this.c + ", overlaySurface=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J&\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge$Companion;", "", "()V", "CAPTURE_TIMEOUT_MS", "", "KEY_INTERRUPTED_OVERLAY_SURFACE", "", "OVERLAY_SHADOW_EXTRA_BOTTOM_DP", "", "RESTORE_HIDDEN_ACTIONS_FALLBACK_TIMEOUT_MS", "SOURCE_ANIMATION_CALLBACK_TIMEOUT_MS", "SOURCE_ANIMATION_FINAL_TIMEOUT_MS", "SOURCE_HIDE_TIMEOUT_MS", "TAG", "TARGET_ANIMATION_FALLBACK_TIMEOUT_MS", "registeredOwners", "", "Landroid/os/IBinder;", "Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge;", "cancelFloatingTransitionLaunch", "", "getActivityToken", "activity", "Landroid/app/Activity;", "getFloatingTransitionService", "Landroid/view/IFloatingTransitionSession;", "notifyFloatingTransitionLaunch", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "host", "Lcom/obric/oui/titlebar/OFloatingTitleBarActionHost;", "notifyFloatingTransitionLaunchInternal", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ android.view.b a(b r0) {
            return r0.b();
        }

        private final boolean a(Activity r4) {
            Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
            if (com.obric.oui.titlebar.floating.b.a() == true) goto L5;
            return false;
        L5:
            IBinder r6 = b(r5);
            android.view.b r3 = b();
            if (r6 == null) goto L14;
            if (r3 == null) goto L14;
            r3.b(r6);     // Catch: Throwable -> L12
            Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("floating notify launch token=", r6));     // Catch: Throwable -> L12
            return true;
        L12:
            th = move-exception;
            Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("floating notify launch failed: ", th.getMessage()));
        L14:
            return false;
        }

        private final IBinder b(Activity r4) {
            Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
            IBinder r5 = null;
            Field r1 = Activity.class.getDeclaredField("mToken");     // Catch: Throwable -> L8
            r1.setAccessible(true);     // Catch: Throwable -> L8
            Object r2 = r1.get(r3);     // Catch: Throwable -> L8
            if (ZeusTransformUtils.instanceOf(r2, IBinder.class) == false) goto L7;
            IBinder r6 = (IBinder) ZeusTransformUtils.preCheckCast(r2, IBinder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        L10:
            Window r7 = ZeusTransformUtils.getWindow(r3, "com.obric.memorydata.plugin");
            if (r7 != null) goto L13;
            return r6;
        L13:
            View r0 = r7.getDecorView();
            Intrinsics.checkNotNullExpressionValue(r0, "window.decorView");
            if (r6 != null) goto L19;
            WindowManager.LayoutParams r8 = r7.getAttributes();
            if (r8 == null) goto L20;
            r5 = r8.token;
        L20:
            if (r5 != null) goto L27;
            IBinder r9 = r0.getApplicationWindowToken();
            if (r9 == null) goto L24;
            return r9;
        L24:
            return r0.getWindowToken();
        L27:
            return r5;
        L19:
            r5 = r6;
            goto L20
        L7:
            r6 = null;
        L8:
            th = move-exception;
            Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("floating get activity token failed: ", th.getMessage()));
            r6 = (IBinder) ZeusTransformUtils.preCheckCast(null, IBinder.class, "com.obric.memorydata.plugin");
            goto L10
        }

        private final android.view.b b() {
            if (com.obric.oui.titlebar.floating.b.a() == true) goto L19;
            return null;
        L19:
            Object r0 = ZeusTransformUtils.forName("android.view.WindowManagerGlobal", "com.obric.memorydata.plugin").getMethod("getWindowManagerService", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L16
            Object r1 = r0.getClass().getMethod("getFloatingTransitionService", new Class[0]).invoke(r0, new Object[0]);     // Catch: Throwable -> L16
            if (ZeusTransformUtils.instanceOf(r1, IBinder.class) == false) goto L9;
            IBinder r2 = (IBinder) ZeusTransformUtils.preCheckCast(r1, IBinder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        L12:
            if (r2 != null) goto L14;
            return null;
        L14:
            return android.view.b.a.d(r2);
        L9:
            if (ZeusTransformUtils.instanceOf(r1, IInterface.class) == false) goto L11;
            r2 = ((IInterface) ZeusTransformUtils.preCheckCast(r1, IInterface.class, "com.obric.memorydata.plugin")).asBinder();     // Catch: Throwable -> L16
            goto L12
        L11:
            r2 = null;
        L16:
            th = move-exception;
            Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("floating service unavailable: ", th.getMessage()));
            return (android.view.b) ZeusTransformUtils.preCheckCast(null, android.view.b.class, "com.obric.memorydata.plugin");
        }

        @JvmStatic
        public final void a() {
            if (com.obric.oui.titlebar.floating.b.a() == true) goto L5;
            return;
        L5:
            android.view.b r2 = b();
            if (r2 != null) goto L14;
            return;
        L14:
            r2.b(null);     // Catch: Throwable -> L11
            Log.d("FloatingTrans-Bridge", "floating cancel launch");     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("floating cancel launch failed: ", th.getMessage()));
        }

        @JvmStatic
        public final void a(Activity r3, OFloatingTitleBar r4, OFloatingTitleBarActionHost r5) {
            Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "activity");
            if (r4 == null) goto L9;
            if (r4.c(r5) == true) goto L9;
            r4.n();
            return;
        L9:
            if (a(r6) == true) goto L14;
            if (r4 == null) goto L15;
            r4.n();
            return;
        L15:
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge$OnFloatingTransitionEndListener;", "", "onFloatingTransitionEnd", "", "targetTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface c {
        void onFloatingTransitionEnd(OFloatingTitleBar r1);
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\r\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0012J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0017J\u000e\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0012J\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020&R\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge$OverlayRenderTarget;", "", "parentSurface", "Landroid/view/SurfaceControl;", "contentSurface", "surface", "Landroid/view/Surface;", "blastBufferQueue", "sourceState", "Lcom/obric/oui/titlebar/OFloatingTitleBarState;", "targetState", "(Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge;Landroid/view/SurfaceControl;Landroid/view/SurfaceControl;Landroid/view/Surface;Ljava/lang/Object;Lcom/obric/oui/titlebar/OFloatingTitleBarState;Lcom/obric/oui/titlebar/OFloatingTitleBarState;)V", "getContentSurface", "()Landroid/view/SurfaceControl;", "lastContentSurfaceTop", "", "getParentSurface", "released", "", "getSurface", "()Landroid/view/Surface;", "targetStateStarted", "getNextFrameNumber", "", "()Ljava/lang/Long;", "isAvailable", "markTargetStateStarted", "", "mergeWithNextTransaction", "transaction", "Landroid/view/SurfaceControl$Transaction;", "frameNumber", "release", "removeContentSurface", "resolveContentSurfaceTop", "host", "Lcom/obric/oui/titlebar/OFloatingTitleBarActionHost;", "summary", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f14789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SurfaceControl f14790b;
        private final SurfaceControl c;
        private final Surface d;
        private final Object e;
        private final com.obric.oui.titlebar.a f;
        private final com.obric.oui.titlebar.a g;
        private float h;
        private boolean i;
        private boolean j;

        public d(a r2, SurfaceControl r3, SurfaceControl r4, Surface r5, Object r6, com.obric.oui.titlebar.a r7, com.obric.oui.titlebar.a r8) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            Intrinsics.checkNotNullParameter(r3, "parentSurface");
            Intrinsics.checkNotNullParameter(r4, "contentSurface");
            Intrinsics.checkNotNullParameter(r5, "surface");
            Intrinsics.checkNotNullParameter(r6, "blastBufferQueue");
            Intrinsics.checkNotNullParameter(r7, "sourceState");
            this.f14789a = r2;
            this.f14790b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r7.a().d();
        }

        public final float a(OFloatingTitleBarActionHost r9) {
            Intrinsics.checkNotNullParameter(r9, "host");
            com.obric.oui.titlebar.a r0 = this.g;
            if (r0 == null) goto L5;
            this.f.b().e();
            float r1 = r0.b().e();
            float r10 = r9.f();
            float r2 = a.a(this.f14789a, this.f);
            float r3 = a.a(this.f14789a, r0);
            float r4 = r2 - r0.a().d();
            float r5 = 1.0f;
            if (this.i == true) goto L9;
            r5 = 0.0f;
        L12:
            float r6 = (r2 + ((r3 - r2) * r5)) - r10;
            this.h = r6;
            return r6;
        L9:
            float r7 = r1 - r4;
            if (Math.abs(r7) <= 0.5f) goto L12;
            r5 = RangesKt.coerceIn((r10 - r4) / r7, 0.0f, 1.0f);
            goto L12
        L5:
            return ((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin")).f.a().d();
        }

        public final SurfaceControl a() {
            return this.c;
        }

        public final void a(boolean r7) {
            if (this.j == false) goto L5;
            return;
        L5:
            this.j = true;
            this.d.release();     // Catch: Throwable -> L8
        L31:
            Method r2 = a.z(this.f14789a);     // Catch: Throwable -> L15
            if (r2 != null) goto L13;
            r2 = this.e.getClass().getDeclaredMethod("destroy", new Class[0]);     // Catch: Throwable -> L15
            a r4 = this.f14789a;     // Catch: Throwable -> L15
            r2.setAccessible(true);     // Catch: Throwable -> L15
            a.c(r4, r2);     // Catch: Throwable -> L15
        L13:
            r2.invoke(this.e, new Object[0]);     // Catch: Throwable -> L15
        L17:
            if (r7 == true) goto L33;
        L27:
            this.c.release();     // Catch: Throwable -> L24
            return;
        L24:
            th = move-exception;
            Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("release render content surface failed: ", th.getMessage()));
            return;
        L33:
            SurfaceControl.Transaction r8 = new SurfaceControl.Transaction();     // Catch: Throwable -> L20
            a.b(this.f14789a, r8, a());     // Catch: Throwable -> L20
            r8.apply();     // Catch: Throwable -> L20
            r8.close();     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("remove render content surface failed: ", th.getMessage()));
        L15:
            th = move-exception;
            Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("destroy render bbq failed: ", th.getMessage()));
        L8:
            th = move-exception;
            Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("release render surface failed: ", th.getMessage()));
            goto L31
        }

        public final boolean a(SurfaceControl.Transaction r8, long r9) {
            Intrinsics.checkNotNullParameter(r8, "transaction");
            Method r2 = a.y(this.f14789a);     // Catch: Throwable -> L8
            if (r2 != null) goto L6;
            Class<?> r3 = this.e.getClass();     // Catch: Throwable -> L8
            Class<?> r6 = Long.TYPE;     // Catch: Throwable -> L8
            Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L8
            r2 = r3.getDeclaredMethod("mergeWithNextTransaction", new Class[]{SurfaceControl.Transaction.class, r6});     // Catch: Throwable -> L8
            a r4 = this.f14789a;     // Catch: Throwable -> L8
            r2.setAccessible(true);     // Catch: Throwable -> L8
            a.b(r4, r2);     // Catch: Throwable -> L8
        L6:
            r2.invoke(this.e, new Object[]{r8, Long.valueOf(r9)});     // Catch: Throwable -> L8
            return true;
        L8:
            th = move-exception;
            Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("mergeWithNextTransaction failed: ", th.getMessage()));
            return false;
        }

        public final Surface b() {
            return this.d;
        }

        public final void c() {
            this.i = true;
        }

        public final boolean d() {
            if (this.j == false) goto L5;
        L9:
            return false;
        L5:
            if (this.d.isValid() == false) goto L9;
            if (this.c.isValid() == false) goto L9;
            return true;
        }

        public final Long e() {
            Method r1 = a.x(this.f14789a);     // Catch: Throwable -> L11
            if (r1 != null) goto L6;
            r1 = Surface.class.getDeclaredMethod("getNextFrameNumber", new Class[0]);     // Catch: Throwable -> L11
            a r3 = this.f14789a;     // Catch: Throwable -> L11
            r1.setAccessible(true);     // Catch: Throwable -> L11
            a.a(r3, r1);     // Catch: Throwable -> L11
        L6:
            Object r5 = r1.invoke(this.d, new Object[0]);     // Catch: Throwable -> L11
            if (r5 == null) goto L10;
            return Long.valueOf(((Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.memorydata.plugin")).longValue());
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("getNextFrameNumber failed: ", th.getMessage()));
            return (Long) ZeusTransformUtils.preCheckCast(null, Long.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J&\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge$TransitionCallback;", "Landroid/view/IFloatingTransitionCallback$Stub;", "bridge", "Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge;", "(Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge;)V", "bridgeRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "onHideTitleBar", "", "sourceSurface", "Landroid/view/SurfaceControl;", "sourceState", "Landroid/os/Bundle;", "onTransitionCancelled", "", "onTransitionFinished", "onTransitionStart", "transitionSurface", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class e extends android.view.a.AbstractBinderC0017a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<a> f14791a;

        public e(a r2) {
            Intrinsics.checkNotNullParameter(r2, "bridge");
            this.f14791a = new WeakReference(r2);
        }

        @Override // android.view.a
        public void a() {
            a r2 = (a) ZeusTransformUtils.preCheckCast(this.f14791a.get(), a.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L7;
            a.b(r2);
            return;
        }

        @Override // android.view.a
        public boolean a(SurfaceControl r3, Bundle r4) {
            a r2 = (a) ZeusTransformUtils.preCheckCast(this.f14791a.get(), a.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L6;
            return false;
        L6:
            return a.a(r2, r3, r4);
        }

        @Override // android.view.a
        public boolean a(SurfaceControl r3, SurfaceControl r4, Bundle r5) {
            a r2 = (a) ZeusTransformUtils.preCheckCast(this.f14791a.get(), a.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L6;
            return false;
        L6:
            return a.a(r2, r3, r4, r5);
        }

        @Override // android.view.a
        public void b() {
            a r2 = (a) ZeusTransformUtils.preCheckCast(this.f14791a.get(), a.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L7;
            a.c(r2);
            return;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge$TransitionStateProvider;", "Landroid/view/IFloatingTransitionStateProvider$Stub;", "bridge", "Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge;", "(Lcom/obric/oui/titlebar/floating/FloatingTransitionBridge;)V", "bridgeRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "captureFloatingTransitionState", "Landroid/os/Bundle;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class f extends android.view.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<a> f14792a;

        public f(a r2) {
            Intrinsics.checkNotNullParameter(r2, "bridge");
            this.f14792a = new WeakReference(r2);
        }

        @Override // android.view.c
        public Bundle a() {
            a r2 = (a) ZeusTransformUtils.preCheckCast(this.f14792a.get(), a.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L5;
            Bundle r3 = null;
        L6:
            if (r3 == null) goto L8;
            return r3;
        L8:
            return new Bundle();
        L5:
            r3 = a.r(r2);
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/oui/titlebar/floating/FloatingTransitionBridge$drawOverlayWhenHostReady$listener$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class g implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBarActionHost f14793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewTreeObserver f14794b;
        final /* synthetic */ a c;
        final /* synthetic */ d d;
        final /* synthetic */ String e;
        final /* synthetic */ com.obric.oui.titlebar.a f;
        final /* synthetic */ Ref.BooleanRef g;
        final /* synthetic */ Function1<Boolean, Unit> h;

        g(OFloatingTitleBarActionHost r3, ViewTreeObserver r4, a r5, d r6, String r7, com.obric.oui.titlebar.a r8, Ref.BooleanRef r9, Function1<? super Boolean, Unit> r10) {
            Function1<Boolean, Unit> r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
            this.f14793a = r3;
            this.f14794b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r11;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ViewTreeObserver r0 = this.f14793a.getViewTreeObserver();
            if (r0.isAlive() == false) goto L5;
            r0.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(this, ViewTreeObserver.OnPreDrawListener.class, "com.obric.memorydata.plugin"));
        L5:
            ViewTreeObserver r1 = this.f14794b;
            if (r1 != r0) goto L8;
        L10:
            a.a(this.g, this.h, a.a(this.c, this.d, this.e, this.f14793a, this.f, "preDraw"));
            return true;
        L8:
            if (r1.isAlive() == false) goto L10;
            this.f14794b.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(this, ViewTreeObserver.OnPreDrawListener.class, "com.obric.memorydata.plugin"));
            goto L10
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/titlebar/floating/FloatingTransitionBridge$releasePendingTargetAnimation$listener$1", "Landroid/animation/AnimatorListenerAdapter;", "complete", "", "onAnimationCancel", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Animator f14795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f14796b;
        final /* synthetic */ a c;

        h(Animator r1, AtomicBoolean r2, a r3) {
            this.f14795a = r1;
            this.f14796b = r2;
            this.c = r3;
        }

        private final void a() {
            this.f14795a.removeListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(this, Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
            if (this.f14796b.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            a.a(this.c, true);
            Function0 r3 = a.a(this.c);
            if (r3 == null) goto L10;
            r3.invoke();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            a();
        }
    }

    static {
        f14784a = new b(null);
        R = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    public a(OFloatingTitleBar r3) {
        Intrinsics.checkNotNullParameter(r3, "titleBar");
        this.f14786b = r3;
        this.f = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.z = true;
        this.A = true;
        this.G = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.P = (android.view.a.AbstractBinderC0017a) ZeusTransformUtils.preCheckCast(new e(this), android.view.a.AbstractBinderC0017a.class, "com.obric.memorydata.plugin");
        this.Q = (android.view.c.a) ZeusTransformUtils.preCheckCast(new f(this), android.view.c.a.class, "com.obric.memorydata.plugin");
    }

    private final void A() {
        g(Intrinsics.stringPlus("hideRealActions before bridge=", E()));
        r();
        this.x = true;
        this.w = true;
        v();
        w();
        this.f14786b.g(true);
        g(Intrinsics.stringPlus("hideRealActions after bridge=", E()));
    }

    private static final void A(a r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.b(true, true);
    }

    private final void B() {
        if (this.C == false) goto L5;
        return;
    L5:
        this.C = true;
        c r0 = this.D;
        if (r0 == null) goto L10;
        r0.onFloatingTransitionEnd(this.f14786b);
        return;
    }

    private static final void B(a r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.b(true, true);
    }

    private final Bundle C() {
        OFloatingTitleBarActionHost r1 = this.g;
        if (this.s == false) goto L51;
        if (r1 == null) goto L51;
        boolean r2 = true;
        this.v = true;
        SurfaceControl r3 = null;
        this.B = null;
        this.z = true;
        com.obric.oui.titlebar.a r4 = r1.e();
        int r11 = MathKt.roundToInt(r1.f());
        com.obric.oui.titlebar.a.e r12 = r4.a();
        Integer r5 = Integer.valueOf(r1.getWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == true) goto L12;
        r5 = null;
    L12:
        if (r5 != null) goto L14;
        int r7 = this.f14786b.getWidth();
    L15:
        int r13 = r7;
        Integer r8 = Integer.valueOf(r1.getHeight());
        if (((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L18;
        boolean r9 = true;
    L19:
        if (r9 == true) goto L22;
        r8 = null;
    L22:
        if (r8 != null) goto L24;
        int r10 = this.f14786b.getHeight();
    L25:
        int r14 = r10;
        C0785a r15 = this.q;
        if (r15 != null) goto L28;
    L27:
        Integer r16 = null;
    L32:
        if (r16 != null) goto L34;
        int r17 = r4.a().d();
    L35:
        Bundle r18 = com.obric.oui.titlebar.a.a(r4, com.obric.oui.titlebar.a.e.a(r12, r13, r14, 0, r17, 4, null), com.obric.oui.titlebar.a.g.a(r4.b(), 0, 0, 0, 0, r11, 15, null), null, null, null, null, 60, null).g();
        C0785a r19 = this.q;
        if (r19 == null) goto L42;
        SurfaceControl r20 = r19.d();
        if (r20 == null) goto L42;
        r18.putParcelable("interrupted_overlay_surface", (Parcelable) ZeusTransformUtils.preCheckCast(r20, Parcelable.class, "com.obric.memorydata.plugin"));
    L42:
        StringBuilder r21 = new StringBuilder().append("captureOnMain freeze old surface hasInterruptedSurface=");
        C0785a r22 = this.q;
        if (r22 == null) goto L46;
        r3 = r22.d();
    L46:
        if (r3 != null) goto L49;
        r2 = false;
    L49:
        Log.d("FloatingTrans-Bridge", r21.append(r2).append(" snapshot=").append(a(r18)).toString());
        return r18;
    L34:
        r17 = r16.intValue();
        goto L35
    L28:
        d r23 = r15.c();
        if (r23 == null) goto L27;
        r16 = Integer.valueOf(MathKt.roundToInt(r23.a(r1)));
        goto L32
    L24:
        r10 = r8.intValue();
        goto L25
    L18:
        r9 = false;
        goto L19
    L14:
        r7 = r5.intValue();
        goto L15
    L8:
        r6 = false;
    L51:
        return s();
    }

    private final android.view.b D() {
        return b.a(f14784a);
    }

    private final String E() {
        StringBuilder r0 = new StringBuilder();
        StringBuilder r1 = r0.append("bridge=").append(System.identityHashCode(this)).append(" registered=").append(this.c).append(" token=").append(this.d).append(" targetActive=").append(this.F).append(" startPending=").append(this.E).append(" drawing=").append(this.s).append(" firstFrame=").append(this.t).append(" overlay=");
        boolean r3 = true;
        if (this.q == null) goto L5;
        boolean r2 = true;
    L6:
        StringBuilder r4 = r1.append(r2).append(" actionHost=");
        OFloatingTitleBarActionHost r5 = this.g;
        Integer r6 = null;
        if (r5 != null) goto L9;
        Integer r7 = null;
    L10:
        r4.append(r7).append(" realHidden=").append(this.w).append(" hiddenByRegister=").append(this.x).append(" activityFinished=");
        StringBuilder r8 = r0.append(this.z).append(" targetFinished=").append(this.A).append(" finishCoordinator=");
        if (this.B != null) goto L14;
        r3 = false;
    L14:
        StringBuilder r9 = r8.append(r3).append(" pendingHide=").append(this.u).append(" hiddenHosts=").append(this.G.size()).append(" launchHost=");
        OFloatingTitleBarActionHost r10 = this.y;
        if (r10 == null) goto L18;
        r6 = Integer.valueOf(System.identityHashCode(r10));
    L18:
        r9.append(r6).append(" titleBar=").append(this.f14786b.h());
        return r0.toString();
    L9:
        r7 = Integer.valueOf(System.identityHashCode(r5));
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public static final /* synthetic */ int a(a r0, com.obric.oui.titlebar.a r1) {
        return r0.b(r1);
    }

    public static final /* synthetic */ Activity a(a r2, Context r3) {
        return (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getActivity((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
    }

    private final IBinder a(Activity r4) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        IBinder r5 = null;
        Field r1 = Activity.class.getDeclaredField("mToken");     // Catch: Throwable -> L8
        r1.setAccessible(true);     // Catch: Throwable -> L8
        Object r2 = r1.get(r3);     // Catch: Throwable -> L8
        if (ZeusTransformUtils.instanceOf(r2, IBinder.class) == false) goto L7;
        IBinder r6 = (IBinder) ZeusTransformUtils.preCheckCast(r2, IBinder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
    L10:
        Window r7 = ZeusTransformUtils.getWindow(r3, "com.obric.memorydata.plugin");
        if (r7 != null) goto L13;
        return r6;
    L13:
        View r0 = r7.getDecorView();
        Intrinsics.checkNotNullExpressionValue(r0, "window.decorView");
        if (r6 != null) goto L19;
        WindowManager.LayoutParams r8 = r7.getAttributes();
        if (r8 == null) goto L20;
        r5 = r8.token;
    L20:
        if (r5 != null) goto L27;
        IBinder r9 = r0.getApplicationWindowToken();
        if (r9 == null) goto L24;
        return r9;
    L24:
        return r0.getWindowToken();
    L27:
        return r5;
    L19:
        r5 = r6;
        goto L20
    L7:
        r6 = null;
    L8:
        th = move-exception;
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("floating get activity token failed: ", th.getMessage()));
        r6 = (IBinder) ZeusTransformUtils.preCheckCast(null, IBinder.class, "com.obric.memorydata.plugin");
        goto L10
    }

    private final OFloatingTitleBarActionHost a(Context r14, ViewGroup r15, com.obric.oui.titlebar.a r16, com.obric.oui.titlebar.a r17) {
        OFloatingTitleBarActionHost r1 = new OFloatingTitleBarActionHost((Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin"), null, 0, 6, null);
        int r3 = 0;
        r1.setClipChildren(false);
        r1.setClipToPadding(false);
        OFloatingTitleBarActionHost.a(r1, r16, false, false, null, null, 28, null);
        r1.setVisibility(4);
        Integer r4 = Integer.valueOf(r16.a().a());
        boolean r6 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L5;
        boolean r5 = true;
    L6:
        Integer r7 = null;
        if (r5 == true) goto L10;
        r4 = null;
    L10:
        if (r4 != null) goto L12;
        int r8 = this.f14786b.getWidth();
    L13:
        if (r17 != null) goto L15;
    L14:
        int r9 = 0;
    L28:
        int r10 = Math.max(r8, r9);
        Integer r11 = Integer.valueOf(r16.a().b());
        if (((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L31;
        boolean r12 = true;
    L32:
        if (r12 == true) goto L35;
        r11 = null;
    L35:
        if (r11 != null) goto L37;
        int r0 = this.f14786b.getHeight();
    L38:
        if (r17 == null) goto L52;
        com.obric.oui.titlebar.a.e r13 = r17.a();
        if (r13 == null) goto L52;
        Integer r18 = Integer.valueOf(r13.b());
        if (((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.memorydata.plugin")).intValue() > 0) goto L47;
        r6 = false;
    L47:
        if (r6 == false) goto L49;
        r7 = r18;
    L49:
        if (r7 == null) goto L52;
        r3 = r7.intValue();
    L52:
        int r2 = Math.max(r0, r3);
        View r19 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");
        FrameLayout.LayoutParams r20 = new FrameLayout.LayoutParams(r10, r2);
        r20.topMargin = (-r2) - 1000;
        Unit r21 = Unit.INSTANCE;
        r15.addView(r19, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r20, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r1.a();
        return r1;
    L37:
        r0 = r11.intValue();
        goto L38
    L31:
        r12 = false;
        goto L32
    L15:
        com.obric.oui.titlebar.a.e r22 = r17.a();
        if (r22 == null) goto L14;
        Integer r23 = Integer.valueOf(r22.a());
        if (((Number) ZeusTransformUtils.preCheckCast(r23, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L21;
        boolean r24 = true;
    L22:
        if (r24 == true) goto L25;
        r23 = null;
    L25:
        if (r23 == null) goto L14;
        r9 = r23.intValue();
        goto L28
    L21:
        r24 = false;
        goto L22
    L12:
        r8 = r4.intValue();
        goto L13
    L5:
        r5 = false;
        goto L6
    }

    static /* synthetic */ OFloatingTitleBarActionHost a(a r1, Context r2, ViewGroup r3, com.obric.oui.titlebar.a r4, com.obric.oui.titlebar.a r5, int r6, Object r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if ((r6 & 8) == 0) goto L6;
        r5 = null;
    L6:
        return r1.a(r8, r3, r4, r5);
    }

    private final com.obric.oui.titlebar.a a(com.obric.oui.titlebar.a r14, com.obric.oui.titlebar.a r15) {
        com.obric.oui.titlebar.a.h r13 = r14.d();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15.c().a(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L5;
    L7:
        com.obric.oui.titlebar.a.h r0 = r14.d();
    L8:
        int r1 = r0.a();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15.c().b(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L11;
    L13:
        com.obric.oui.titlebar.a.h r2 = r14.d();
    L14:
        int r3 = r2.b();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15.c().c(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L17;
    L19:
        com.obric.oui.titlebar.a.h r4 = r14.d();
    L20:
        int r5 = r4.c();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15.c().d(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L23;
    L25:
        com.obric.oui.titlebar.a.h r16 = r14.d();
    L27:
        return com.obric.oui.titlebar.a.a(r14, null, null, null, r13.a(r1, r3, r5, r16.d()), null, null, 55, null);
    L23:
        if (r14.c().d().isEmpty() == false) goto L25;
        r16 = r15.d();
        goto L27
    L17:
        if (r14.c().c().isEmpty() == false) goto L19;
        r4 = r15.d();
        goto L20
    L11:
        if (r14.c().b().isEmpty() == false) goto L13;
        r2 = r15.d();
        goto L14
    L5:
        if (r14.c().a().isEmpty() == false) goto L7;
        r0 = r15.d();
        goto L8
    }

    private final d a(SurfaceControl r19, com.obric.oui.titlebar.a r20, String r21, com.obric.oui.titlebar.a r22) {
        Integer r1 = Integer.valueOf(r20.a().a());
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r1 = null;
    L9:
        if (r1 != null) goto L11;
        int r3 = this.f14786b.getWidth();
    L12:
        if (r22 != null) goto L14;
    L13:
        int r4 = 0;
    L27:
        int r5 = Math.max(r3, r4);
        Integer r6 = Integer.valueOf(r20.a().b());
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L30;
        boolean r7 = true;
    L31:
        if (r7 == true) goto L34;
        r6 = null;
    L34:
        if (r6 != null) goto L36;
        int r8 = this.f14786b.getHeight();
    L37:
        if (r22 != null) goto L39;
    L38:
        int r9 = 0;
    L52:
        int r10 = Math.max(r8, r9);
        int r11 = u() + r10;
        if (r5 <= 0) goto L73;
        if (r10 <= 0) goto L73;
        SurfaceControl r12 = new SurfaceControl.Builder().setName(Intrinsics.stringPlus("FloatingTitleBar", r21)).setParent(r19).setBufferSize(r5, r11).setFormat(-3).build();     // Catch: Throwable -> L70
        Intrinsics.checkNotNullExpressionValue(r12, "Builder()\n              …\n                .build()");     // Catch: Throwable -> L70
        Class<?> r13 = this.k;     // Catch: Throwable -> L70
        if (r13 != null) goto L59;
        r13 = ZeusTransformUtils.forName("android.graphics.BLASTBufferQueue", "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        this.k = r13;     // Catch: Throwable -> L70
    L59:
        Class<?> r15 = Boolean.TYPE;     // Catch: Throwable -> L70
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L70
        Object r14 = r13.getDeclaredConstructor(new Class[]{String.class, r15}).newInstance(new Object[]{Intrinsics.stringPlus("FloatingTitleBarBBQ", r21), false});     // Catch: Throwable -> L70
        Method r16 = this.l;     // Catch: Throwable -> L70
        if (r16 != null) goto L62;
        Class<?> r17 = Integer.TYPE;     // Catch: Throwable -> L70
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L70
        Class<?> r18 = Integer.TYPE;     // Catch: Throwable -> L70
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L70
        Class<?> r110 = Integer.TYPE;     // Catch: Throwable -> L70
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L70
        r16 = r13.getDeclaredMethod(BuildConfig.CHANNEL, new Class[]{SurfaceControl.class, r17, r18, r110});     // Catch: Throwable -> L70
        r16.setAccessible(true);     // Catch: Throwable -> L70
        this.l = r16;     // Catch: Throwable -> L70
    L62:
        r16.invoke(r14, new Object[]{r12, Integer.valueOf(r5), Integer.valueOf(r11), -3});     // Catch: Throwable -> L70
        Method r23 = this.m;     // Catch: Throwable -> L70
        if (r23 != null) goto L65;
        r23 = r13.getDeclaredMethod("createSurface", new Class[0]);     // Catch: Throwable -> L70
        r23.setAccessible(true);     // Catch: Throwable -> L70
        this.m = r23;     // Catch: Throwable -> L70
    L65:
        Object r24 = r23.invoke(r14, new Object[0]);     // Catch: Throwable -> L70
        if (r24 == null) goto L69;
        Surface r25 = (Surface) ZeusTransformUtils.preCheckCast(r24, Surface.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        Intrinsics.checkNotNullExpressionValue(r14, "bbq");     // Catch: Throwable -> L70
        return new d(this, r19, r12, r25, r14, r20, r22);
    L69:
        throw new NullPointerException("null cannot be cast to non-null type android.view.Surface");     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        Log.d("FloatingTrans-Bridge", "createOverlayRenderTarget failed name=" + r21 + " error=" + th.getMessage());
        return (d) ZeusTransformUtils.preCheckCast(null, d.class, "com.obric.memorydata.plugin");
    L73:
        Log.d("FloatingTrans-Bridge", "createOverlayRenderTarget skipped name=" + r21 + " width=" + r5 + " height=" + r10);
        return null;
    L39:
        com.obric.oui.titlebar.a.e r26 = r22.a();
        if (r26 == null) goto L38;
        Integer r27 = Integer.valueOf(r26.b());
        if (((Number) ZeusTransformUtils.preCheckCast(r27, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L45;
        boolean r28 = true;
    L46:
        if (r28 == true) goto L49;
        r27 = null;
    L49:
        if (r27 == null) goto L38;
        r9 = r27.intValue();
        goto L52
    L45:
        r28 = false;
        goto L46
    L36:
        r8 = r6.intValue();
        goto L37
    L30:
        r7 = false;
        goto L31
    L14:
        com.obric.oui.titlebar.a.e r29 = r22.a();
        if (r29 == null) goto L13;
        Integer r30 = Integer.valueOf(r29.a());
        if (((Number) ZeusTransformUtils.preCheckCast(r30, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L20;
        boolean r31 = true;
    L21:
        if (r31 == true) goto L24;
        r30 = null;
    L24:
        if (r30 == null) goto L13;
        r4 = r30.intValue();
        goto L27
    L20:
        r31 = false;
        goto L21
    L11:
        r3 = r1.intValue();
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    static /* synthetic */ d a(a r0, SurfaceControl r1, com.obric.oui.titlebar.a r2, String r3, com.obric.oui.titlebar.a r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = null;
    L6:
        return r0.a(r1, r2, r3, r4);
    }

    private final String a(Bundle r2) {
        return a(com.obric.oui.titlebar.a.f14758a.a(r2));
    L4:
        th = move-exception;
        return Intrinsics.stringPlus("invalidState error=", th.getMessage());
    }

    private final String a(View r4) {
        String r0 = null;
        if (ZeusTransformUtils.instanceOf(r4, TextView.class) == false) goto L5;
        TextView r3 = (TextView) ZeusTransformUtils.preCheckCast(r4, TextView.class, "com.obric.memorydata.plugin");
    L6:
        if (r3 == null) goto L12;
        CharSequence r5 = r3.getText();
        if (r5 == null) goto L12;
        r0 = r5.toString();
    L12:
        if (r0 != null) goto L14;
        r0 = "";
    L14:
        StringBuilder r6 = new StringBuilder();
        r6.append(r4.getClass().getSimpleName()).append('@').append(Integer.toHexString(System.identityHashCode(r4))).append(" tag=").append(r4.getTag()).append(" text=").append(r0).append(" vis=").append(r4.getVisibility()).append(" shown=").append(r4.isShown()).append(" alpha=").append(r4.getAlpha()).append(" size=").append(r4.getWidth()).append('x').append(r4.getHeight()).append(" measured=").append(r4.getMeasuredWidth()).append('x').append(r4.getMeasuredHeight()).append(" requestLayout=").append(r4.isLayoutRequested());
        return r6.toString();
    L5:
        r3 = null;
        goto L6
    }

    private final String a(View r7, float r8) {
        if (r7.getVisibility() == 0) goto L5;
        return null;
    L5:
        float r9 = r8 * r7.getAlpha();
        int r3 = 0;
        if (ZeusTransformUtils.instanceOf(r7, TextView.class) == false) goto L29;
        if (r9 < 0.99f) goto L29;
        CharSequence r0 = ((TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.memorydata.plugin")).getText();
        boolean r5 = true;
        if (r0 != null) goto L13;
    L11:
        r5 = false;
    L17:
        if (r5 == false) goto L29;
        if (((TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.memorydata.plugin")).getWidth() <= 0) goto L27;
        if (((TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.memorydata.plugin")).getHeight() <= 0) goto L27;
        if (((TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.memorydata.plugin")).isLayoutRequested() == true) goto L27;
        if (((TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.memorydata.plugin")).getLayout() != null) goto L29;
    L27:
        return a(r7);
    L13:
        if (r0.length() <= 0) goto L15;
        boolean r1 = true;
    L16:
        if (r1 != true) goto L11;
    L15:
        r1 = false;
    L29:
        if (r7.getTag() == null) goto L41;
        if (r9 < 0.99f) goto L41;
        if (r7.getWidth() <= 0) goto L39;
        if (r7.getHeight() <= 0) goto L39;
        if (r7.isLayoutRequested() == false) goto L41;
    L39:
        return a(r7);
    L41:
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.class) == false) goto L48;
        int r2 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount();
    L43:
        if (r3 >= r2) goto L48;
        int r4 = r3 + 1;
        View r6 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.memorydata.plugin")).getChildAt(r3);
        Intrinsics.checkNotNullExpressionValue(r6, "root.getChildAt(i)");
        String r10 = a(r6, r9);
        if (r10 != null) goto L46;
        r3 = r4;
        goto L43
    L46:
        return r10;
    L48:
        return null;
    }

    private final String a(com.obric.oui.titlebar.a r6) {
        StringBuilder r0 = new StringBuilder();
        StringBuilder r5 = r0.append("w=").append(r6.a().a()).append(" h=").append(r6.a().b()).append(" y=").append(r6.a().d()).append(" contentTopInset=").append(r6.b().e()).append(" contentY=").append(b(r6)).append(" start=").append(r6.c().a().size()).append(" center=").append(r6.c().b().size()).append(" sub=").append(r6.c().c().size()).append(" end=").append(r6.c().d().size()).append(" hasAnimationState=");
        boolean r2 = true;
        if (r6.e() == null) goto L5;
        boolean r1 = true;
    L6:
        StringBuilder r7 = r5.append(r1).append(" animStart=");
        com.obric.oui.titlebar.a.d r3 = r6.e();
        int r4 = -1;
        if (r3 != null) goto L9;
    L8:
        int r8 = -1;
    L16:
        r7.append(r8).append(" animCenter=");
        com.obric.oui.titlebar.a.d r9 = r6.e();
        if (r9 != null) goto L19;
    L18:
        int r10 = -1;
    L26:
        StringBuilder r11 = r0.append(r10).append(" animSub=");
        com.obric.oui.titlebar.a.d r12 = r6.e();
        if (r12 != null) goto L29;
    L28:
        int r13 = -1;
    L36:
        StringBuilder r14 = r11.append(r13).append(" animEnd=");
        com.obric.oui.titlebar.a.d r15 = r6.e();
        if (r15 == null) goto L46;
        OButtonGroup.b r16 = r15.d();
        if (r16 == null) goto L46;
        List<OButtonGroup.d> r17 = r16.g();
        if (r17 == null) goto L46;
        r4 = r17.size();
    L46:
        StringBuilder r18 = r14.append(r4).append(" animCenterAlpha=");
        com.obric.oui.titlebar.a.d r19 = r6.e();
        Float r20 = null;
        if (r19 != null) goto L49;
    L48:
        Float r21 = null;
    L53:
        StringBuilder r22 = r18.append(r21).append(" animSubAlpha=");
        com.obric.oui.titlebar.a.d r23 = r6.e();
        if (r23 != null) goto L56;
    L55:
        Float r24 = null;
    L60:
        StringBuilder r25 = r22.append(r24).append(" animEndAlpha=");
        com.obric.oui.titlebar.a.d r26 = r6.e();
        if (r26 == null) goto L67;
        OButtonGroup.b r27 = r26.d();
        if (r27 == null) goto L67;
        r20 = Float.valueOf(r27.b());
    L67:
        StringBuilder r28 = r25.append(r20).append(" hasInterruptedSurface=");
        if (r6.f() != null) goto L71;
        r2 = false;
    L71:
        r28.append(r2);
        return r0.toString();
    L56:
        OButtonGroup.b r29 = r23.c();
        if (r29 == null) goto L55;
        r24 = Float.valueOf(r29.b());
        goto L60
    L49:
        OButtonGroup.b r30 = r19.b();
        if (r30 == null) goto L48;
        r21 = Float.valueOf(r30.b());
        goto L53
    L29:
        OButtonGroup.b r31 = r12.c();
        if (r31 == null) goto L28;
        List<OButtonGroup.d> r32 = r31.g();
        if (r32 == null) goto L28;
        r13 = r32.size();
        goto L36
    L19:
        OButtonGroup.b r33 = r9.b();
        if (r33 == null) goto L18;
        List<OButtonGroup.d> r34 = r33.g();
        if (r34 == null) goto L18;
        r10 = r34.size();
        goto L26
    L9:
        OButtonGroup.b r35 = r3.a();
        if (r35 == null) goto L8;
        List<OButtonGroup.d> r36 = r35.g();
        if (r36 == null) goto L8;
        r8 = r36.size();
        goto L16
    L5:
        r1 = false;
        goto L6
    }

    static /* synthetic */ String a(a r0, View r1, float r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 1.0f;
    L6:
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ Function0 a(a r0) {
        return r0.B;
    }

    private final void a(Animator r5) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        r5.start();     // Catch: Throwable -> L5
        Object r4 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L8:
        if (Result.m1424exceptionOrNullimpl(r4) == null) goto L18;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L11
        a r7 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        r5.end();     // Catch: Throwable -> L11
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        return;
    L18:
        return;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final void a(SurfaceControl.Transaction r2, SurfaceControl r3) {
        a(r2, "show", r3);
    }

    private final void a(SurfaceControl.Transaction r5, String r6, SurfaceControl r7) {
        Method r4 = SurfaceControl.Transaction.class.getDeclaredMethod(r6, new Class[]{SurfaceControl.class});     // Catch: Throwable -> L4
        r4.setAccessible(true);     // Catch: Throwable -> L4
        r4.invoke(r5, new Object[]{r7});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Log.d("FloatingTrans-Bridge", "transaction " + r6 + " failed: " + th.getMessage());
    }

    private final void a(SurfaceControl.Transaction r3, String r4, CountDownLatch r5, Function0<Unit> r6, boolean r7) {
        final Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        r3.apply();     // Catch: Throwable -> L5
        r3.close();     // Catch: Throwable -> L5
    L7:
        if (r7 == true) goto L17;
        if (r5 == null) goto L11;
        r5.countDown();
    L11:
        if (r8 == null) goto L18;
        this.f14786b.post(new $$Lambda$a$cSftzk4WdX4BeuAZ_naG0L_2kcU(r8));
        return;
    L18:
        return;
    L17:
        return;
    L5:
        th = move-exception;
        Log.d("FloatingTrans-Bridge", "apply transaction immediately failed reason=" + r4 + " error=" + th.getMessage());
        goto L7
    }

    private final void a(final SurfaceControl r18, final SurfaceControl r19, Bundle r20, final AtomicReference<CountDownLatch> r21, Function1<? super Boolean, Unit> r22) {
        final Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r22, Function1.class, "com.obric.memorydata.plugin");
        com.obric.oui.titlebar.a r0 = com.obric.oui.titlebar.a.f14758a.a(r20);
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f14786b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "titleBar.context");
        final com.obric.oui.titlebar.a r14 = r0.a(r1);
        final com.obric.oui.titlebar.a r11 = a(this.f14786b.b(), r14);
        this.f14786b.getLocationOnScreen(new int[2]);
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f14786b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "titleBar.context");
        Activity r3 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(r2), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L4:
        View r4 = null;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == false) goto L12;
        final ViewGroup r5 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.memorydata.plugin");
    L14:
        if (r3 == null) goto L30;
        if (r5 != null) goto L17;
        a r7 = this;
    L31:
        r7.F = false;
        r7.E = false;
        k();
        r6.invoke(false);
        return;
    L17:
        final SurfaceControl r9 = r14.f();
        if (r9 != null) goto L20;
        boolean r8 = true;
    L21:
        b(false, r8);
        this.F = true;
        this.E = true;
        this.z = false;
        this.B = null;
        final OFloatingTitleBarActionHost r15 = a((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.memorydata.plugin"), r5, r14, r11);
        final d r10 = a(r18, r14, "Transition", r11);
        if (r10 != null) goto L26;
        this.z = true;
        this.B = null;
        this.F = false;
        this.E = false;
        a(r5, r15, null, r18, true);
        k();
        r6.invoke(false);
        return;
    L26:
        if (r14.e() == null) goto L28;
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("restore snapshot source=", a(r14)));
    L28:
        this.g = r15;
        this.q = new C0785a(r5, r15, r10, r18);
        g();
        this.C = false;
        this.s = true;
        a(r15, r14, r10, "targetFirstFrameDraw", (Function1) ZeusTransformUtils.preCheckCast(new FloatingTransitionBridge$handleTransitionStartOnMain$1(this, r5, r15, r10, r18, r6, r21, r19, r9, r14, r11), Function1.class, "com.obric.memorydata.plugin"));
        return;
    L20:
        r8 = false;
        goto L21
    L30:
        r7 = this;
        goto L31
    L12:
        r5 = null;
        goto L14
    L5:
        Window r12 = ZeusTransformUtils.getWindow(r3, "com.obric.memorydata.plugin");
        if (r12 == null) goto L4;
        r4 = r12.getDecorView();
        goto L10
    }

    private final void a(SurfaceControl r3, String r4) {
        r3.release();     // Catch: Throwable -> L5
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("releaseSurfaceControl done reason=", r4));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.d("FloatingTrans-Bridge", "releaseSurfaceControl failed reason=" + r4 + " error=" + th.getMessage());
    }

    private final void a(ViewGroup r9, OFloatingTitleBarActionHost r10, d r11, SurfaceControl r12) {
        if (this.v == false) goto L6;
        Log.d("FloatingTrans-Bridge", "finishOverlay ignored after interrupt snapshot");
        y();
        return;
    L6:
        this.B = null;
        this.z = true;
        this.A = true;
        this.F = false;
        g();
        a(r9, r10, r11, r12, true, true);
    }

    private final void a(ViewGroup r5, OFloatingTitleBarActionHost r6, d r7, SurfaceControl r8, boolean r9) {
        C0785a r0 = this.q;
        if (r0 != null) goto L5;
        OFloatingTitleBarActionHost r1 = null;
    L6:
        if (r1 != r6) goto L8;
    L13:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L40;
        Log.d("FloatingTrans-Bridge", "removeOverlay skip unknown host");
        return;
    L40:
        r6.d();     // Catch: Throwable -> L37
        if (r6.getParent() != r5) goto L22;
        r5.removeView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L37
    L22:
        if (this.g != r6) goto L24;
        this.g = null;     // Catch: Throwable -> L37
    L24:
        C0785a r10 = this.q;     // Catch: Throwable -> L37
        if (r10 != null) goto L27;
        OFloatingTitleBarActionHost r11 = null;
    L28:
        if (r11 != r6) goto L30;
        this.q = null;     // Catch: Throwable -> L37
    L30:
        if (r7 == null) goto L33;
        r7.a(r9);     // Catch: Throwable -> L37
    L33:
        if (r9 == false) goto L35;
        SurfaceControl.Transaction r12 = new SurfaceControl.Transaction();     // Catch: Throwable -> L37
        b(r12, r8);     // Catch: Throwable -> L37
        r12.apply();     // Catch: Throwable -> L37
        r12.close();     // Catch: Throwable -> L37
        r8.release();     // Catch: Throwable -> L37
    L35:
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("removeOverlay done releaseSurface=", Boolean.valueOf(r9)));     // Catch: Throwable -> L37
        return;
    L27:
        r11 = r10.b();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        this.f14786b.p();
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("floating cleanup failed: ", th.getMessage()));
        return;
    L8:
        if (this.g == r6) goto L13;
        if (r6.getParent() == r5) goto L13;
        r2 = false;
        goto L15
    L5:
        r1 = r0.b();
        goto L6
    }

    private final void a(final ViewGroup r12, final OFloatingTitleBarActionHost r13, final d r14, final SurfaceControl r15, boolean r16, boolean r17) {
        Log.d("FloatingTrans-Bridge", "finishOverlay releaseSurface=" + r16 + " deferRemove=" + r17);
        this.F = false;
        this.f14786b.p();
        x();
        this.x = false;
        this.w = false;
        if (r16 == true) goto L8;
        boolean r6 = f("finish-no-release");
        a(r12, r13, r14, r15, false);
        if (r6 == false) goto L20;
        B();
        return;
    L20:
        return;
    L8:
        SurfaceControl.Transaction r7 = new SurfaceControl.Transaction();
        b(r7, r15);
        if (r17 == true) goto L15;
        a(r7, "finishOverlayImmediate", null, null, false);
        boolean r8 = f("finish-immediate");
        a(r12, r13, r14, r15, true);
        if (r8 == false) goto L21;
        B();
        return;
    L21:
        return;
    L15:
        if (a(this, r7, "finishOverlay", null, (Function0) ZeusTransformUtils.preCheckCast(new FloatingTransitionBridge$finishOverlayToRealActions$scheduled$1(this, r12, r13, r14, r15), Function0.class, "com.obric.memorydata.plugin"), 4, null) == true) goto L22;
        boolean r9 = f("finish-unscheduled");
        a(r12, r13, r14, r15, true);
        if (r9 == false) goto L23;
        B();
        return;
    L23:
        return;
    }

    private final void a(ViewGroup r4, OFloatingTitleBarActionHost r5, d r6, boolean r7) {
        r5.d();     // Catch: Throwable -> L14
        if (r5.getParent() != r4) goto L7;
        r4.removeView((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
    L7:
        if (this.g != r5) goto L9;
        this.g = null;     // Catch: Throwable -> L14
    L9:
        if (r6 == null) goto L12;
        r6.a(r7);     // Catch: Throwable -> L14
    L12:
        Log.d("FloatingTrans-Bridge", "floating source hide cleanup");     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("floating source hide cleanup failed: ", th.getMessage()));
    }

    private final void a(OFloatingTitleBarActionHost r8, SurfaceControl r9, float r10, SurfaceControl.Transaction r11) {
        if (this.h == false) goto L5;
        return;
    L5:
        if (r9.isValid() == true) goto L22;
        return;
    L22:
        int[] r3 = new int[2];     // Catch: Throwable -> L19
        r8.getLocationOnScreen(r3);     // Catch: Throwable -> L19
        float[][] r12 = a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), new int[]{-r3[0], (-r3[1]) + MathKt.roundToInt(r10)});     // Catch: Throwable -> L19
        if (((Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.memorydata.plugin")).length != 0) goto L11;
        boolean r13 = true;
    L12:
        if (r13 == false) goto L14;
        return;
    L14:
        Method r14 = this.i;     // Catch: Throwable -> L19
        if (r14 != null) goto L17;
        r14 = SurfaceControl.Transaction.class.getDeclaredMethod("setBlurRegions", new Class[]{SurfaceControl.class, float[][].class});     // Catch: Throwable -> L19
        r14.setAccessible(true);     // Catch: Throwable -> L19
        this.i = r14;     // Catch: Throwable -> L19
    L17:
        r14.invoke(r11, new Object[]{r9, r12});     // Catch: Throwable -> L19
        return;
    L11:
        r13 = false;
    L19:
        th = move-exception;
        this.h = true;
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("floating set blur regions disabled: ", th.getMessage()));
    }

    private final void a(OFloatingTitleBarActionHost r7, com.obric.oui.titlebar.a r8) {
        Integer r0 = Integer.valueOf(r8.a().a());
        boolean r3 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        Integer r5 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 != null) goto L12;
        int r2 = this.f14786b.getWidth();
    L13:
        Integer r9 = Integer.valueOf(r8.a().b());
        if (((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue() > 0) goto L17;
        r3 = false;
    L17:
        if (r3 == false) goto L19;
        r5 = r9;
    L19:
        if (r5 != null) goto L21;
        int r6 = this.f14786b.getHeight();
    L22:
        if (r2 <= 0) goto L27;
        if (r6 <= 0) goto L27;
        r7.measure(View.MeasureSpec.makeMeasureSpec(r2, 1073741824), View.MeasureSpec.makeMeasureSpec(r6, 1073741824));
        r7.layout(0, 0, r2, r6);
        return;
    L27:
        Log.d("FloatingTrans-Bridge", "layoutActionHost skipped width=" + r2 + " height=" + r6);
        return;
    L21:
        r6 = r5.intValue();
        goto L22
    L12:
        r2 = r0.intValue();
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    private final void a(OFloatingTitleBarActionHost r13, com.obric.oui.titlebar.a r14, d r15, String r16, Function1<? super Boolean, Unit> r17) {
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r17, Function1.class, "com.obric.memorydata.plugin");
        Ref.BooleanRef r9 = new Ref.BooleanRef();
        a(r13, r14);
        ViewTreeObserver r0 = r13.getViewTreeObserver();
        if (r0.isAlive() == true) goto L6;
        Log.d("FloatingTrans-Bridge", "overlay draw failed reason=" + r16 + " dead observer");
        b(r9, r10, false);
        return;
    L6:
        r0.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(new g(r13, r0, this, r15, r16, r14, r9, r10), ViewTreeObserver.OnPreDrawListener.class, "com.obric.memorydata.plugin"));
        r13.requestLayout();
        r13.invalidate();
    }

    private final void a(C0785a r6) {
        r6.b().d();     // Catch: Throwable -> L18
        if (r6.b().getParent() != r6.a()) goto L7;
        r6.a().removeView((View) ZeusTransformUtils.preCheckCast(r6.b(), View.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L18
    L7:
        if (this.g != r6.b()) goto L9;
        this.g = null;     // Catch: Throwable -> L18
    L9:
        C0785a r1 = this.q;     // Catch: Throwable -> L18
        if (r1 != null) goto L12;
        OFloatingTitleBarActionHost r2 = null;
    L14:
        if (r2 != r6.b()) goto L16;
        this.q = null;     // Catch: Throwable -> L18
    L16:
        r6.c().a(false);     // Catch: Throwable -> L18
        r6.d().release();     // Catch: Throwable -> L18
        Log.d("FloatingTrans-Bridge", "interruptedSource local overlay removed");     // Catch: Throwable -> L18
        return;
    L12:
        r2 = r1.b();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("interruptedSource local overlay remove failed: ", th.getMessage()));
    }

    private final void a(final d r3, Function0<Unit> r4) {
        Function0<Unit> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        C0785a r0 = this.q;
        if (r0 == null) goto L7;
        if (r0.c() == r3) goto L7;
        return;
    L7:
        if (r3.d() == false) goto L17;
        if (r5 == null) goto L13;
        this.f.add(r5);
    L13:
        if (this.e == false) goto L15;
        return;
    L15:
        this.e = true;
        this.f14786b.post(new $$Lambda$a$M2j7ujeUOvYRk3kOysEcRDwvhwk(this, r3));
        return;
    }

    public static final /* synthetic */ void a(a r0, SurfaceControl.Transaction r1, SurfaceControl r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(a r6, SurfaceControl r7, SurfaceControl r8, Bundle r9, AtomicReference r10, Function1 r11) {
        r6.a(r7, r8, r9, r10, (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(a r0, SurfaceControl r1, String r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(a r0, ViewGroup r1, OFloatingTitleBarActionHost r2, d r3, SurfaceControl r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void a(a r0, ViewGroup r1, OFloatingTitleBarActionHost r2, d r3, SurfaceControl r4, boolean r5) {
        r0.a(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ void a(a r0, ViewGroup r1, OFloatingTitleBarActionHost r2, d r3, boolean r4) {
        r0.a(r1, r2, r3, r4);
    }

    static /* synthetic */ void a(a r0, ViewGroup r1, OFloatingTitleBarActionHost r2, d r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = true;
    L5:
        r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void a(a r0, OFloatingTitleBarActionHost r1) {
        r0.g = r1;
    }

    public static final /* synthetic */ void a(a r6, OFloatingTitleBarActionHost r7, com.obric.oui.titlebar.a r8, d r9, String r10, Function1 r11) {
        r6.a(r7, r8, r9, r10, (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin"));
    }

    private static final void a(a r3, d r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r4, "$renderTarget");
        boolean r0 = false;
        r3.e = false;
        C0785a r1 = r3.q;
        if (r1 == null) goto L7;
        if (r1.c() == r4) goto L7;
    L8:
        r3.f.clear();
        return;
    L7:
        if (r4.d() == false) goto L8;
        if (r4.b().isValid() == true) goto L13;
    L15:
        if (r0 == true) goto L17;
        return;
    L17:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3.f, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L24;
        List r5 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r3.f, Iterable.class, "com.obric.memorydata.plugin"));
        r3.f.clear();
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r6.hasNext() == false) goto L25;
        ((Function0) ZeusTransformUtils.preCheckCast(r6.next(), Function0.class, "com.obric.memorydata.plugin")).invoke();
        goto L20
    L25:
        return;
    L24:
        return;
    L13:
        if (r3.a(r4) == false) goto L15;
        r0 = true;
        goto L15
    }

    static /* synthetic */ void a(a r1, d r2, Function0 r3, int r4, Object r5) {
        Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.a(r2, r6);
    }

    public static final /* synthetic */ void a(a r0, String r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ void a(a r0, Method r1) {
        r0.p = r1;
    }

    public static final /* synthetic */ void a(a r2, Function0 r3) {
        r2.B = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
    }

    private static final void a(a r4, Ref.ObjectRef r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Intrinsics.checkNotNullParameter(r5, "$task");
        Intrinsics.checkNotNullParameter(r6, "$reason");
        Runnable r0 = r4.H;
        if (r5.element != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("task");
        Runnable r7 = null;
    L6:
        if (r0 == r7) goto L8;
        return;
    L8:
        r4.H = null;
        r4.d(r6);
        return;
    L5:
        r7 = (Runnable) ZeusTransformUtils.preCheckCast(r5.element, Runnable.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public static final /* synthetic */ void a(a r0, boolean r1) {
        r0.A = r1;
    }

    public static /* synthetic */ void a(a r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.a(r1);
    }

    public static final /* synthetic */ void a(a r0, boolean r1, boolean r2) {
        r0.b(r1, r2);
    }

    public static /* synthetic */ void a(a r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = true;
    L8:
        r1.a(r2, r3);
    }

    private static final void a(Runnable r2) {
        ((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin")).run();
    }

    private static final void a(CountDownLatch r2, Function0 r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r2.countDown();
    L6:
        if (r4 == null) goto L10;
        r4.invoke();
        return;
    }

    private static final void a(CountDownLatch r2, Function0 r3, a r4) {
        final Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "this$0");
        if (r2 == null) goto L6;
        r2.countDown();
    L6:
        if (r5 == null) goto L10;
        r4.f14786b.post(new $$Lambda$a$N2JOYEsa2YGfIRGCAZLgCJTpMWA(r5));
        return;
    }

    private static final void a(AtomicBoolean r2, CountDownLatch r3, AtomicReference r4, Function0 r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "$shouldRun");
        Intrinsics.checkNotNullParameter(r3, "$latch");
        Intrinsics.checkNotNullParameter(r4, "$result");
        Intrinsics.checkNotNullParameter(r6, "$action");
        if (r2.get() == true) goto L12;
        r3.countDown();
        return;
    L12:
        r4.set(r6.invoke());     // Catch: Throwable -> L9
        r3.countDown();
        return;
    L9:
        th = move-exception;
        r3.countDown();
        throw th;
    }

    private static final void a(AtomicBoolean r2, final CountDownLatch r3, Function1 r4, String r5, final AtomicReference r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "$shouldRun");
        Intrinsics.checkNotNullParameter(r3, "$latch");
        Intrinsics.checkNotNullParameter(r7, "$action");
        Intrinsics.checkNotNullParameter(r5, "$reason");
        Intrinsics.checkNotNullParameter(r6, "$result");
        if (r2.get() == true) goto L11;
        r3.countDown();
        return;
    L11:
        r7.invoke(new FloatingTransitionBridge$runOnMainAsyncAndWait$2$1(r6, r3));     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Log.d("FloatingTrans-Bridge", "async main action failed reason=" + r5 + " error=" + th.getMessage());
        r6.set(false);
        r3.countDown();
    }

    private static final void a(AtomicReference r1, a r2, CountDownLatch r3) {
        Intrinsics.checkNotNullParameter(r1, "$captured");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$latch");
        r1.set(r2.C());
        r3.countDown();
    }

    private static final void a(Function0 r2) {
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "$cleanup");
        r3.invoke();
    }

    public static final /* synthetic */ void a(Ref.BooleanRef r2, Function1 r3, boolean r4) {
        b(r2, (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin"), r4);
    }

    private final boolean a(SurfaceControl.Transaction r12, String r13, final CountDownLatch r14, Function0<Unit> r15) {
        final Function0<Unit> r16 = (Function0) ZeusTransformUtils.wrapperContextForParams(r15, Function0.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L30;
        if (r16 != null) goto L30;
    L9:
        boolean r10 = false;
    L32:
        Method r3 = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);     // Catch: Throwable -> L27
        r3.setAccessible(true);     // Catch: Throwable -> L27
        Object r4 = r3.invoke(this.f14786b, new Object[0]);     // Catch: Throwable -> L27
        if (r4 != null) goto L14;
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("applyTransactionOnDraw missing root reason=", r13));     // Catch: Throwable -> L27
        a(r12, r13, r14, r16, r10);     // Catch: Throwable -> L27
        return true;
    L14:
        Object r2 = r4.getClass().getMethod("applyTransactionOnDraw", new Class[]{SurfaceControl.Transaction.class}).invoke(r4, new Object[]{r12});     // Catch: Throwable -> L27
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == false) goto L17;
        Boolean r1 = (Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
    L18:
        if (r1 != null) goto L20;
        boolean r5 = true;
    L21:
        if (r5 == true) goto L23;
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("applyTransactionOnDraw returned false reason=", r13));     // Catch: Throwable -> L27
        a(r12, r13, r14, r16, r10);     // Catch: Throwable -> L27
    L29:
        return true;
    L23:
        this.f14786b.invalidate();     // Catch: Throwable -> L27
        if (r10 == true) goto L29;
        this.f14786b.postOnAnimation(new $$Lambda$a$aj_UZUOqUaVpNdXjhHHsDKr680(r14, r16));     // Catch: Throwable -> L27
        goto L29
    L20:
        r5 = r1.booleanValue();     // Catch: Throwable -> L27
        goto L21
    L17:
        r1 = null;
    L27:
        th = move-exception;
        Log.d("FloatingTrans-Bridge", "applyTransactionOnDraw failed reason=" + r13 + " error=" + th.getMessage());
        a(r12, r13, r14, r16, r10);
    L30:
        r12.addTransactionCommittedListener($$Lambda$a$4qkn_y3nB4ccO0ZgeJB6TBXoPrI.INSTANCE, new $$Lambda$a$XJyF15YUlmnN66y4QoGiXT5i9ws(r14, r16, this));     // Catch: Throwable -> L7
        r10 = true;
    L7:
        th = move-exception;
        Log.d("FloatingTrans-Bridge", "add transaction commit listener failed reason=" + r13 + " error=" + th.getMessage());
        goto L9
    }

    private final boolean a(SurfaceControl r2, Bundle r3) {
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L6;
        return false;
    L6:
        this.O = true;
        if (r2 == null) goto L12;
        if (r3 == null) goto L12;
        return b(r2, r3);
    L12:
        return a("hideOnly", (Function0) ZeusTransformUtils.preCheckCast(new FloatingTransitionBridge$onCallbackHideTitleBar$result$1(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    private final boolean a(SurfaceControl r5, SurfaceControl r6, Bundle r7) {
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L5;
        return false;
    L5:
        StringBuilder r0 = new StringBuilder().append("onTransitionStart transitionSurface=");
        if (r5 == null) goto L8;
        boolean r3 = true;
    L9:
        StringBuilder r1 = r0.append(r3).append(" sourceSurface=");
        if (r6 == null) goto L12;
        boolean r4 = true;
    L13:
        StringBuilder r2 = r1.append(r4).append(" state=");
        if (r7 != null) goto L16;
        String r8 = null;
    L17:
        Log.d("FloatingTrans-Bridge", r2.append(r8).toString());
        if (r5 == null) goto L23;
        if (r7 == null) goto L23;
        this.F = true;
        this.E = true;
        return b(r5, r6, r7);
    L23:
        return false;
    L16:
        r8 = a(r7);
        goto L17
    L12:
        r4 = false;
        goto L13
    L8:
        r3 = false;
        goto L9
    }

    private final boolean a(d r10) {
        OFloatingTitleBarActionHost r1 = this.g;
        if (r1 != null) goto L7;
        a r9 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");
        return false;
    L7:
        if (r1.getWidth() > 0) goto L9;
    L35:
        Log.d("FloatingTrans-Bridge", "floating draw surface skipped empty host width=" + r1.getWidth() + " height=" + r1.getHeight());
        return false;
    L9:
        if (r1.getHeight() <= 0) goto L35;
        float r4 = r10.a(r1);
        r1.getLocationOnScreen(new int[2]);
        SurfaceControl.Transaction r6 = new SurfaceControl.Transaction();
        r6.setPosition(r10.a(), 0.0f, r4);
        a(r6, r10.a());
        a(r1, r10.a(), r4, r6);
        Long r5 = r10.e();
        if (r5 != null) goto L16;
        a r11 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");
        r6.close();
        return false;
    L16:
        if (r10.a(r6, r5.longValue()) == true) goto L39;
        r6.close();
        return false;
    L39:
        Canvas r12 = r10.b().lockHardwareCanvas();     // Catch: Throwable -> L21
    L23:
        if (r12 != null) goto L37;
        return false;
    L37:
        r12.drawColor(0, PorterDuff.Mode.CLEAR);     // Catch: Throwable -> L28
        r1.draw(r12);     // Catch: Throwable -> L28
        r10.b().unlockCanvasAndPost(r12);
        return true;
    L28:
        th = move-exception;
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("floating draw surface failed: ", th.getMessage()));     // Catch: Throwable -> L32
        r10.b().unlockCanvasAndPost(r12);
        return false;
    L32:
        th = move-exception;
        r10.b().unlockCanvasAndPost(r12);
        throw th;
    L21:
        th = move-exception;
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("floating lock surface failed: ", th.getMessage()));
        r12 = (Canvas) ZeusTransformUtils.preCheckCast(null, Canvas.class, "com.obric.memorydata.plugin");
        goto L23
    }

    public static final /* synthetic */ boolean a(a r2, SurfaceControl.Transaction r3, String r4, CountDownLatch r5, Function0 r6) {
        return r2.a(r3, r4, r5, (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ boolean a(a r1, SurfaceControl.Transaction r2, String r3, CountDownLatch r4, Function0 r5, int r6, Object r7) {
        Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r8 = null;
    L9:
        return r1.a(r2, r3, r4, r8);
    }

    public static final /* synthetic */ boolean a(a r0, SurfaceControl r1, Bundle r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ boolean a(a r0, SurfaceControl r1, SurfaceControl r2, Bundle r3) {
        return r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ boolean a(a r0, d r1, String r2, OFloatingTitleBarActionHost r3, com.obric.oui.titlebar.a r4, String r5) {
        return b(r0, r1, r2, r3, r4, r5);
    }

    static /* synthetic */ boolean a(a r6, String r7, long r8, boolean r10, Function1 r11, int r12, Object r13) {
        Function1<? super Function1<? super Boolean, Unit>, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        if ((r12 & 4) == 0) goto L6;
        r10 = false;
    L6:
        return r6.a(r7, r8, r10, r5);
    }

    private final boolean a(final String r22, long r23, boolean r25, Function1<? super Function1<? super Boolean, Unit>, Unit> r26) {
        final Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r26, Function1.class, "com.obric.memorydata.plugin");
        long r11 = SystemClock.uptimeMillis();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L22;
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        final Ref.BooleanRef r2 = new Ref.BooleanRef();
        r3.invoke(new FloatingTransitionBridge$runOnMainAsyncAndWait$1(r0, r2));
        if (r0.element == true) goto L9;
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("async main action not completed synchronously reason=", r22));
        if (r25 == false) goto L9;
        return true;
    L9:
        StringBuilder r4 = new StringBuilder().append("async main action done reason=").append(r22).append(" result=");
        if (r0.element == true) goto L12;
    L14:
        boolean r5 = false;
    L15:
        Log.d("FloatingTrans-Bridge", r4.append(r5).append(" onMain=true costMs=").append(SystemClock.uptimeMillis() - r11).toString());
        if (r0.element == false) goto L21;
        if (r2.element == false) goto L21;
        return true;
    L21:
        return false;
    L12:
        if (r2.element == false) goto L14;
        r5 = true;
        goto L15
    L22:
        final CountDownLatch r6 = new CountDownLatch(1);
        AtomicBoolean r1 = new AtomicBoolean(true);
        final AtomicReference r7 = new AtomicReference(false);
        OFloatingTitleBar r8 = this.f14786b;
        final AtomicBoolean r21 = r1;
        r8.post(new $$Lambda$a$YZELnbC_39o2ikvGwbQC69bmEw4(r21, r6, r3, r22, r7));
        if (r6.await(r23, TimeUnit.MILLISECONDS) == true) goto L45;
        r21 = r21;
        String r9 = "FloatingTrans-Bridge";
        boolean r10 = false;
        r21.set(false);     // Catch: InterruptedException -> L40
        Log.d(r9, "async main action timeout reason=" + r22 + " timeoutMs=" + r23 + " costMs=" + (SystemClock.uptimeMillis() - r11));     // Catch: InterruptedException -> L40
        Boolean r12 = false;
    L33:
        Intrinsics.checkNotNullExpressionValue(r12, "{\n            if (latch.…e\n            }\n        }");     // Catch: InterruptedException -> L40
        return r12.booleanValue();
    L37:
        r21.set(r10);
        Thread.currentThread().interrupt();
        Log.d(r9, "async main action interrupted reason=" + r22 + " costMs=" + (SystemClock.uptimeMillis() - r11));
        return r10;
    L45:
        r12 = (Boolean) ZeusTransformUtils.preCheckCast(r7.get(), Boolean.class, "com.obric.memorydata.plugin");     // Catch: InterruptedException -> L29
        r9 = "FloatingTrans-Bridge";
        Log.d(r9, "async main action done reason=" + r22 + " result=" + r12 + " costMs=" + (SystemClock.uptimeMillis() - r11));     // Catch: InterruptedException -> L39
        r21 = r21;
        r10 = false;
    L36:
        r10 = false;
    L29:
        r9 = "FloatingTrans-Bridge";
    L35:
        r9 = "FloatingTrans-Bridge";
        goto L36
    }

    private final boolean a(String r9, Function0<Boolean> r10) {
        final Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        final CountDownLatch r1 = new CountDownLatch(1);
        final AtomicBoolean r4 = new AtomicBoolean(true);
        final AtomicReference r3 = new AtomicReference(false);
        this.f14786b.post(new $$Lambda$a$Alk6E8sw19K2n2jrFBFiGem5KoE(r4, r1, r3, r11));
    L13:
        r4.set(false);
        Thread.currentThread().interrupt();
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("floating source hide wait interrupted reason=", r9));
        return false;
    L8:
        if (r1.await(240, TimeUnit.MILLISECONDS) == false) goto L10;
        Boolean r8 = (Boolean) ZeusTransformUtils.preCheckCast(r3.get(), Boolean.class, "com.obric.memorydata.plugin");     // Catch: InterruptedException -> L13
    L11:
        Intrinsics.checkNotNullExpressionValue(r8, "{\n            if (latch.…e\n            }\n        }");     // Catch: InterruptedException -> L13
        return r8.booleanValue();
    L10:
        r4.set(false);     // Catch: InterruptedException -> L13
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("floating source hide wait timeout reason=", r9));     // Catch: InterruptedException -> L13
        r8 = false;     // Catch: InterruptedException -> L13
        goto L11
    L5:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r11.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private final boolean a(CountDownLatch r7, String r8, long r9) {
        boolean r0 = true;
        boolean r1 = false;
        if (r7 != null) goto L5;
    L16:
        StringBuilder r6 = new StringBuilder().append("transaction commit skip reason=").append(r8).append(" latch=");
        if (r7 == null) goto L19;
        r1 = true;
    L19:
        Log.d("FloatingTrans-Bridge", r6.append(r1).toString());
        return true;
    L5:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L16;
        long r3 = SystemClock.uptimeMillis();
    L14:
        Thread.currentThread().interrupt();
        Log.d("FloatingTrans-Bridge", "transaction commit interrupted reason=" + r8 + " costMs=" + (SystemClock.uptimeMillis() - r3));
        return false;
    L9:
        if (r7.await(r9, TimeUnit.MILLISECONDS) == false) goto L11;
        Log.d("FloatingTrans-Bridge", "transaction commit done reason=" + r8 + " costMs=" + (SystemClock.uptimeMillis() - r3));     // Catch: InterruptedException -> L14
    L22:
        return r0;
    L11:
        Log.d("FloatingTrans-Bridge", "transaction commit timeout reason=" + r8 + " timeoutMs=" + r9 + " costMs=" + (SystemClock.uptimeMillis() - r3));     // Catch: InterruptedException -> L14
        r0 = false;
        goto L22
    }

    private final float[][] a(View r8, int[] r9) {
        Class r0 = ZeusTransformUtils.forName("android.view.IExtEffect", "com.obric.memorydata.plugin");
        Method r2 = this.j;
        if (r2 != null) goto L5;
        r2 = r0.getDeclaredMethod("collectMaterials", new Class[]{View.class, int[].class});
        r2.setAccessible(true);
        this.j = r2;
    L5:
        Object r7 = r2.invoke(null, new Object[]{r8, r9});
        Objects.requireNonNull(r7, "null cannot be cast to non-null type kotlin.Array<kotlin.FloatArray>");
        return (float[][]) ZeusTransformUtils.preCheckCast(r7, float[][].class, "com.obric.memorydata.plugin");
    }

    private final int b(com.obric.oui.titlebar.a r1) {
        return r1.a().d() + r1.b().e();
    }

    private final void b(SurfaceControl.Transaction r2, SurfaceControl r3) {
        a(r2, "remove", r3);
    }

    public static final /* synthetic */ void b(a r0) {
        r0.p();
    }

    public static final /* synthetic */ void b(a r0, SurfaceControl.Transaction r1, SurfaceControl r2) {
        r0.b(r1, r2);
    }

    public static final /* synthetic */ void b(a r0, Method r1) {
        r0.n = r1;
    }

    public static final /* synthetic */ void b(a r0, boolean r1) {
        r0.u = r1;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.obric.oui.titlebar.floating.-$$Lambda$a$f6LnhGVNc1A1QhAKcRc7N-BGOWc] */
    private final void b(final String r6) {
        r();
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = new $$Lambda$a$f6LnhGVNc1A1QhAKcRc7NBGOWc(this, r0, r6);
        Runnable r1 = null;
        if (r0.element != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("task");
        Runnable r7 = null;
    L6:
        this.H = r7;
        OFloatingTitleBar r5 = this.f14786b;
        if (r0.element != 0) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("task");
    L10:
        r5.postDelayed(r1, 1200);
        return;
    L9:
        r1 = (Runnable) ZeusTransformUtils.preCheckCast(r0.element, Runnable.class, "com.obric.memorydata.plugin");
        goto L10
    L5:
        r7 = (Runnable) ZeusTransformUtils.preCheckCast(r0.element, Runnable.class, "com.obric.memorydata.plugin");
        goto L6
    }

    private static final void b(Function0 r2) {
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "$tmp0");
        r3.invoke();
    }

    private static final void b(Ref.BooleanRef r2, Function1<? super Boolean, Unit> r3, boolean r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if (r2.element == false) goto L5;
        return;
    L5:
        r2.element = true;
        r5.invoke(Boolean.valueOf(r4));
    }

    private final void b(boolean r4) {
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("restoreTargetState keepHidden=", Boolean.valueOf(r4)));
        g("restoreTargetState before keepHidden=" + r4 + " bridge=" + E());
        if (r4 == false) goto L5;
        w();
    L5:
        this.f14786b.h(r4);
        if (r4 == true) goto L8;
        x();
    L8:
        this.w = r4;
        g("restoreTargetState after keepHidden=" + r4 + " bridge=" + E());
    }

    private final void b(boolean r10, boolean r11) {
        Log.d("FloatingTrans-Bridge", "forceCleanup showRealActions=" + r10 + " releaseSurface=" + r11);
        g("forceCleanup before showRealActions=" + r10 + " releaseSurface=" + r11 + " bridge=" + E());
        this.B = null;
        this.z = true;
        this.A = true;
        this.F = false;
        g();
        if (r10 == false) goto L7;
        this.x = false;
        this.w = false;
        if (this.q != null) goto L8;
        this.f14786b.p();
        x();
    L8:
        C0785a r0 = this.q;
        if (r0 == null) goto L15;
        ViewGroup r1 = r0.a();
        OFloatingTitleBarActionHost r2 = r0.b();
        d r3 = r0.c();
        SurfaceControl r4 = r0.d();
        if (r10 == false) goto L14;
        a(r1, r2, r3, r4, r11, true);
        goto L15
    L14:
        a(r1, r2, r3, r4, r11);
    L15:
        g("forceCleanup after showRealActions=" + r10 + " releaseSurface=" + r11 + " bridge=" + E());
        return;
    L7:
        b(true);
        goto L8
    }

    private final boolean b(final SurfaceControl r12, final Bundle r13) {
        long r0 = SystemClock.uptimeMillis();
        final AtomicReference r2 = new AtomicReference();
        boolean r14 = a(this, "sourceHideDraw", 240, false, (Function1) ZeusTransformUtils.preCheckCast(new FloatingTransitionBridge$handleSourceHideTitleBarSync$scheduled$1(r13, this, r12, r2), Function1.class, "com.obric.memorydata.plugin"), 4, null);
        if (r14 == true) goto L5;
    L7:
        boolean r11 = false;
    L8:
        Log.d("FloatingTrans-Bridge", "sourceHideShowSurface ready=" + r11 + " scheduled=" + r14 + " costMs=" + (SystemClock.uptimeMillis() - r0));
        return r11;
    L5:
        if (a((CountDownLatch) ZeusTransformUtils.preCheckCast(r2.get(), CountDownLatch.class, "com.obric.memorydata.plugin"), "sourceHideShowSurface", 240) == false) goto L7;
        r11 = true;
        goto L8
    }

    private final boolean b(final SurfaceControl r11, final SurfaceControl r12, final Bundle r13) {
        long r0 = SystemClock.uptimeMillis();
        final AtomicReference r8 = new AtomicReference();
        boolean r14 = a("transitionStart", 240, true, (Function1) ZeusTransformUtils.preCheckCast(new FloatingTransitionBridge$handleTransitionStartSync$scheduled$1(this, r11, r12, r13, r8), Function1.class, "com.obric.memorydata.plugin"));
        boolean r15 = false;
        if (r14 == true) goto L5;
        this.F = false;
        this.E = false;
    L5:
        if (r14 == true) goto L7;
    L9:
        Log.d("FloatingTrans-Bridge", "targetFirstFrame ready=" + r15 + " scheduled=" + r14 + " costMs=" + (SystemClock.uptimeMillis() - r0));
        return r15;
    L7:
        if (a((CountDownLatch) ZeusTransformUtils.preCheckCast(r8.get(), CountDownLatch.class, "com.obric.memorydata.plugin"), "targetFirstFrame", 240) == false) goto L9;
        r15 = true;
        goto L9
    }

    private static final boolean b(a r5, d r6, String r7, OFloatingTitleBarActionHost r8, com.obric.oui.titlebar.a r9, String r10) {
        C0785a r0 = r5.q;
        boolean r1 = false;
        if (r0 == null) goto L7;
        if (r0.c() == r6) goto L7;
    L8:
        StringBuilder r11 = new StringBuilder().append("overlay draw skipped reason=").append(r7).append(" stage=").append(r10).append(" stale=true");
    L9:
        Log.d("FloatingTrans-Bridge", r11.toString());
        return false;
    L7:
        if (r6.d() == false) goto L8;
        r5.a(r8, r9);
        String r12 = a(r5, (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 0.0f, 2, null);
        if (r12 == null) goto L15;
        r11 = new StringBuilder().append("overlay draw wait reason=").append(r7).append(" stage=").append(r10).append(" unready=").append(r12);
        goto L9
    L15:
        if (r6.b().isValid() == true) goto L17;
    L19:
        if (r1 == true) goto L21;
        Log.d("FloatingTrans-Bridge", "overlay draw failed reason=" + r7 + " stage=" + r10 + " surfaceValid=" + r6.b().isValid());
    L21:
        return r1;
    L17:
        if (r5.a(r6) == false) goto L19;
        r1 = true;
        goto L19
    }

    public static final /* synthetic */ boolean b(a r0, String r1) {
        return r0.f(r1);
    }

    private final String c(OFloatingTitleBarActionHost r4) {
        OFloatingTitleBar r3 = r4.getBoundTitleBar();
        StringBuilder r0 = new StringBuilder().append("host=").append(System.identityHashCode(r4)).append(" vis=").append(r4.getVisibility()).append(" shown=").append(r4.isShown()).append(" attached=").append(r4.isAttachedToWindow()).append(" size=").append(r4.getWidth()).append('x').append(r4.getHeight()).append(" alpha=").append(r4.getAlpha()).append(" bound=");
        String r1 = null;
        if (r3 != null) goto L5;
        Integer r2 = null;
    L6:
        StringBuilder r5 = r0.append(r2).append(" boundSummary=");
        if (r3 == null) goto L11;
        r1 = r3.h();
    L11:
        return r5.append(r1).append(" action=").append(r4.getActionTitleBar().h()).toString();
    L5:
        r2 = Integer.valueOf(System.identityHashCode(r3));
        goto L6
    }

    public static final /* synthetic */ void c(a r0) {
        r0.q();
    }

    public static final /* synthetic */ void c(a r0, Method r1) {
        r0.o = r1;
    }

    public static final /* synthetic */ void c(a r0, boolean r1) {
        r0.z = r1;
    }

    private final void c(String r2) {
        if (this.E == false) goto L5;
    L14:
        b(r2);
        return;
    L5:
        if (this.F == true) goto L14;
        if (this.s == true) goto L14;
        if (this.q != null) goto L14;
        if (this.w == true) goto L14;
        if (this.x == true) goto L14;
    }

    private static final void c(Function0 r2) {
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "$tmp0");
        r3.invoke();
    }

    public static final /* synthetic */ void d(a r0, boolean r1) {
        r0.F = r1;
    }

    private final void d(String r3) {
        if (this.A == true) goto L6;
        return;
    L6:
        if (this.f14786b.g() == false) goto L10;
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("restoreHiddenActionsIfIdle fallback skip visible reason=", r3));
        return;
    L10:
        if (this.E == false) goto L12;
    L22:
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("restoreHiddenActionsIfIdle fallback reason=", r3));
        b(true, true);
        return;
    L12:
        if (this.F == true) goto L22;
        if (this.s == true) goto L22;
        if (this.q != null) goto L22;
        if (this.w == true) goto L22;
        if (this.x == true) goto L22;
    }

    private static final void d(Function0 r2) {
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "$tmp0");
        r3.invoke();
    }

    public static final /* synthetic */ boolean d(a r0) {
        return r0.s;
    }

    public static final /* synthetic */ void e(a r0, boolean r1) {
        r0.E = r1;
    }

    private final void e(String r4) {
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("restoreHiddenActionsIfIdle reason=", r4));
        g("restoreHiddenActionsNow before reason=" + r4 + " bridge=" + E());
        this.F = false;
        this.f14786b.p();
        x();
        this.x = false;
        this.w = false;
        g("restoreHiddenActionsNow after reason=" + r4 + " bridge=" + E());
    }

    public static final /* synthetic */ boolean e(a r0) {
        return r0.t;
    }

    public static final /* synthetic */ void f(a r0, boolean r1) {
        r0.x = r1;
    }

    public static final /* synthetic */ boolean f(a r0) {
        return r0.v;
    }

    private final boolean f(String r5) {
        IBinder r1 = this.d;
        if (r1 != null) goto L5;
        return false;
    L5:
        android.view.b r4 = D();
        if (r4 != null) goto L14;
        return false;
    L14:
        r4.c(r1);     // Catch: Throwable -> L11
        Log.d("FloatingTrans-Bridge", "floating notify finished reason=" + r5 + " token=" + r1);     // Catch: Throwable -> L11
        return true;
    L11:
        th = move-exception;
        Log.d("FloatingTrans-Bridge", "floating notify finished failed reason=" + r5 + " error=" + th.getMessage());
        return false;
    }

    private final void g() {
        r();
        this.s = false;
        this.t = false;
        this.u = false;
        this.f.clear();
        this.e = false;
        this.v = false;
        this.E = false;
    }

    public static final /* synthetic */ void g(a r0) {
        r0.y();
    }

    public static final /* synthetic */ void g(a r0, boolean r1) {
        r0.t = r1;
    }

    private final void g(String r1) {
        if (com.obric.oui.titlebar.floating.b.b() == false) goto L6;
        Log.d("lzr", r1);
        return;
    }

    private final Activity getActivity(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
    L4:
        if (ZeusTransformUtils.instanceOf(r1, ContextWrapper.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r1, Activity.class) == true) goto L8;
        r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r1, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "current.baseContext");
        goto L4
    L8:
        return (Activity) ZeusTransformUtils.preCheckCast(r1, Activity.class, "com.obric.memorydata.plugin");
    L10:
        return null;
    }

    private final void h() {
        l();
        Animator r0 = this.K;
        this.K = null;
        this.I = false;
        this.f14785J = false;
        this.O = false;
        if (r0 == null) goto L13;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        r0.cancel();     // Catch: Throwable -> L7
        Object r4 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Result.m1420boximpl(r4);
        return;
    L7:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public static final /* synthetic */ void h(a r0) {
        r0.i();
    }

    public static final /* synthetic */ void h(a r0, boolean r1) {
        r0.w = r1;
    }

    private final void i() {
        if (this.I == true) goto L5;
        return;
    L5:
        l();
        this.f14785J = true;
        Animator r0 = this.K;
        if (r0 != null) goto L8;
        return;
    L8:
        this.K = null;
        this.I = false;
        this.f14785J = false;
        this.O = false;
        a(r0);
    }

    public static final /* synthetic */ void i(a r0) {
        r0.A();
    }

    private final void j() {
        if (this.L == null) goto L6;
        this.A = false;
        return;
    }

    public static final /* synthetic */ void j(a r0) {
        r0.k();
    }

    public static final /* synthetic */ C0785a k(a r0) {
        return r0.q;
    }

    private final void k() {
        Animator r0 = this.L;
        if (r0 != null) goto L5;
        return;
    L5:
        m();
        this.L = null;
        boolean r1 = !this.A;
        AtomicBoolean r3 = new AtomicBoolean(false);
        h r5 = new h(r0, r3, this);
        if (r1 == true) goto L23;
    L8:
        r0.start();     // Catch: Throwable -> L10
        return;
    L10:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L12
        a r8 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        r0.end();     // Catch: Throwable -> L12
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        r0.removeListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r5, Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        if (r1 == true) goto L17;
        return;
    L17:
        if (r3.compareAndSet(false, true) == false) goto L27;
        this.A = true;
        Function0<Unit> r9 = this.B;
        if (r9 == null) goto L29;
        r9.invoke();
        return;
    L29:
        return;
    L27:
        return;
    L12:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    L23:
        r0.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r5, Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
        goto L8
    }

    private final void l() {
        Runnable r0 = this.M;
        if (r0 == null) goto L6;
        this.f14786b.removeCallbacks(r0);
    L6:
        this.M = null;
    }

    public static final /* synthetic */ void l(a r0) {
        r0.z();
    }

    public static /* synthetic */ void lambda$4qkn_y3nB4ccO0ZgeJB6TBXoPrI(Runnable r0) {
        a(r0);
    }

    public static /* synthetic */ void lambda$Alk6E8sw19K2n2jrFBFiGem5KoE(AtomicBoolean r0, CountDownLatch r1, AtomicReference r2, Function0 r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$IBvnpIuPCm96DUnazFFHVqATIGw(a r0) {
        B(r0);
    }

    public static /* synthetic */ void lambda$LRV4aPG2U4gaRwUcHZIO0hinoq0(Function0 r0) {
        a(r0);
    }

    public static /* synthetic */ void lambda$M2j7ujeUOvYRk3kOysEcRDwvhwk(a r0, d r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$N2JOYEsa2YGfIRGCAZLgCJTpMWA(Function0 r0) {
        c(r0);
    }

    public static /* synthetic */ void lambda$XJyF15YUlmnN66y4QoGiXT5i9ws(CountDownLatch r0, Function0 r1, a r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$YZELnbC_39o2ikvGwbQC69bmEw4(AtomicBoolean r0, CountDownLatch r1, Function1 r2, String r3, AtomicReference r4) {
        a(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$aj_UZUOqUaVpNdXjh-HHsDKr680, reason: not valid java name */
    public static /* synthetic */ void m1392lambda$aj_UZUOqUaVpNdXjhHHsDKr680(CountDownLatch r0, Function0 r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$bE54k46SE6_hkuxuFMZHVfVMu4M(AtomicReference r0, a r1, CountDownLatch r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$cSftzk4WdX4BeuAZ_naG0L_2kcU(Function0 r0) {
        d(r0);
    }

    public static /* synthetic */ void lambda$dezr0VMIDCc1wH7OIAFizGnUt4Y(a r0) {
        A(r0);
    }

    /* JADX INFO: renamed from: lambda$f6LnhGVNc1A1QhAKcRc7N-BGOWc, reason: not valid java name */
    public static /* synthetic */ void m1393lambda$f6LnhGVNc1A1QhAKcRc7NBGOWc(a r0, Ref.ObjectRef r1, String r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$oE0RbRB1-nnaipNelL7NwCCVs0w, reason: not valid java name */
    public static /* synthetic */ void m1394lambda$oE0RbRB1nnaipNelL7NwCCVs0w(Function0 r0) {
        b(r0);
    }

    private final void m() {
        Runnable r0 = this.N;
        if (r0 == null) goto L6;
        this.f14786b.removeCallbacks(r0);
    L6:
        this.N = null;
    }

    public static final /* synthetic */ boolean m(a r0) {
        return r0.E;
    }

    private final void n() {
        m();
        Animator r0 = this.L;
        this.L = null;
        if (r0 != null) goto L18;
    L10:
        if (r0 != null) goto L12;
        return;
    L12:
        if (this.A == true) goto L21;
        this.A = true;
        Function0<Unit> r3 = this.B;
        if (r3 == null) goto L22;
        r3.invoke();
        return;
    L22:
        return;
    L21:
        return;
    L18:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        r0.cancel();     // Catch: Throwable -> L7
        Object r4 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Result.m1420boximpl(r4);
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public static final /* synthetic */ boolean n(a r0) {
        return r0.w;
    }

    private final boolean o() {
        if (this.w == false) goto L5;
    L16:
        return true;
    L5:
        if (this.x == true) goto L16;
        if (this.E == true) goto L16;
        if (this.F == true) goto L16;
        if (this.s == true) goto L16;
        if (this.q != null) goto L16;
        return false;
    }

    public static final /* synthetic */ boolean o(a r0) {
        return r0.F;
    }

    private final void p() {
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L5;
        return;
    L5:
        Log.d("FloatingTrans-Bridge", "onTransitionCancelled");
        final Function0 r0 = (Function0) ZeusTransformUtils.preCheckCast(new FloatingTransitionBridge$onCallbackTransitionCancelled$cleanup$1(this), Function0.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L9;
        r0.invoke();
        return;
    L9:
        this.f14786b.post(new $$Lambda$a$LRV4aPG2U4gaRwUcHZIO0hinoq0(r0));
    }

    public static final /* synthetic */ void p(a r0) {
        r0.g();
    }

    public static final /* synthetic */ OFloatingTitleBar q(a r0) {
        return r0.f14786b;
    }

    private final void q() {
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L5;
        return;
    L5:
        Log.d("FloatingTrans-Bridge", "onTransitionFinished");
        final Function0 r0 = (Function0) ZeusTransformUtils.preCheckCast(new FloatingTransitionBridge$onCallbackTransitionFinished$finish$1(this), Function0.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L8;
        r0.invoke();
        return;
    L8:
        this.f14786b.post(new $$Lambda$a$oE0RbRB1nnaipNelL7NwCCVs0w(r0));
    }

    public static final /* synthetic */ Bundle r(a r0) {
        return r0.t();
    }

    private final void r() {
        Runnable r0 = this.H;
        if (r0 == null) goto L6;
        this.f14786b.removeCallbacks(r0);
    L6:
        this.H = null;
    }

    private final Bundle s() {
        return this.f14786b.b().g();
    }

    public static final /* synthetic */ boolean s(a r0) {
        return r0.u;
    }

    private final Bundle t() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        long r2 = SystemClock.uptimeMillis();
        final AtomicReference r4 = new AtomicReference();
        final CountDownLatch r5 = new CountDownLatch(1);
        this.f14786b.post(new $$Lambda$a$bE54k46SE6_hkuxuFMZHVfVMu4M(r4, this, r5));
    L19:
        Thread.currentThread().interrupt();
        Bundle r6 = this.r;
        if (r6 != null) goto L22;
        r6 = new Bundle();
    L22:
        Log.d("FloatingTrans-Bridge", "captureSync interrupted costMs=" + (SystemClock.uptimeMillis() - r2) + " fallback=" + a(r6));
        return r6;
    L8:
        if (r5.await(240, TimeUnit.MILLISECONDS) == false) goto L14;
        Bundle r7 = (Bundle) ZeusTransformUtils.preCheckCast(r4.get(), Bundle.class, "com.obric.memorydata.plugin");     // Catch: InterruptedException -> L19
        if (r7 != null) goto L25;
        Bundle r8 = this.r;     // Catch: InterruptedException -> L19
        if (r8 == null) goto L27;
        return r8;
    L27:
        return new Bundle();
    L25:
        return r7;
    L14:
        Bundle r9 = this.r;     // Catch: InterruptedException -> L19
        if (r9 != null) goto L17;
        r9 = new Bundle();     // Catch: InterruptedException -> L19
    L17:
        Log.d("FloatingTrans-Bridge", "captureSync timeout costMs=" + (SystemClock.uptimeMillis() - r2) + " fallback=" + a(r9));     // Catch: InterruptedException -> L19
        return r9;
    L5:
        return C();
    }

    public static final /* synthetic */ void t(a r0) {
        r0.j();
    }

    private final int u() {
        return (int) ((32 * ZeusTransformUtils.getResources(this.f14786b, "com.obric.memorydata.plugin").getDisplayMetrics().density) + 0.5f);
    }

    public static final /* synthetic */ boolean u(a r0) {
        return r0.z;
    }

    private final void v() {
        OFloatingTitleBarActionHost r0 = this.y;
        if (r0 != null) goto L7;
        a this = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");
        String r1 = Intrinsics.stringPlus("hideSourceActionHostsForTransition skip noLaunchHost bridge=", this.E());
    L5:
        this.g(r1);
        return;
    L7:
        this.y = null;
        if (r0.getBoundTitleBar() == this.f14786b) goto L12;
        StringBuilder r2 = new StringBuilder();
        String r3 = "hideSourceActionHostsForTransition skip ownerMismatch host=";
    L10:
        r1 = r2.append(r3).append(c(r0)).append(" bridge=").append(E()).toString();
        goto L5
    L12:
        if (this.G.contains(r0) == true) goto L14;
        this.G.add(r0);
    L14:
        r0.a(true);
        r2 = new StringBuilder();
        r3 = "hideSourceActionHostsForTransition hidden host=";
        goto L10
    }

    public static final /* synthetic */ boolean v(a r0) {
        return r0.A;
    }

    private final void w() {
        OFloatingTitleBarActionHost r0 = this.f14786b.getBoundActionHost$OUI_standardRelease();
        if (r0 != null) goto L8;
        a this = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");
        String r1 = Intrinsics.stringPlus("hideBoundActionHostForTransition skip noBoundHost bridge=", this.E());
    L5:
        this.g(r1);
        return;
    L8:
        if (r0.getBoundTitleBar() == this.f14786b) goto L12;
        StringBuilder r2 = new StringBuilder();
        String r3 = "hideBoundActionHostForTransition skip ownerMismatch host=";
    L10:
        r1 = r2.append(r3).append(c(r0)).append(" bridge=").append(E()).toString();
        goto L5
    L12:
        if (this.G.contains(r0) == true) goto L14;
        this.G.add(r0);
    L14:
        r0.a(true);
        r2 = new StringBuilder();
        r3 = "hideBoundActionHostForTransition hidden host=";
        goto L10
    }

    public static final /* synthetic */ void w(a r0) {
        r0.B();
    }

    public static final /* synthetic */ Method x(a r0) {
        return r0.p;
    }

    private final void x() {
        if (this.G.isEmpty() == false) goto L6;
        g(Intrinsics.stringPlus("restoreHiddenSourceActionHosts skip empty bridge=", E()));
        return;
    L6:
        g("restoreHiddenSourceActionHosts count=" + this.G.size() + " bridge=" + E());
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.G, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        OFloatingTitleBarActionHost r1 = (OFloatingTitleBarActionHost) ZeusTransformUtils.preCheckCast(r0.next(), OFloatingTitleBarActionHost.class, "com.obric.memorydata.plugin");
        r1.a(false);
        g(Intrinsics.stringPlus("restoreHiddenSourceActionHosts restored host=", c(r1)));
        goto L8
    L10:
        this.G.clear();
    }

    public static final /* synthetic */ Method y(a r0) {
        return r0.n;
    }

    private final void y() {
        C0785a r0 = this.q;
        if (r0 == null) goto L5;
        boolean r3 = true;
    L6:
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("interruptedSource cleanup hasOverlay=", Boolean.valueOf(r3)));
        this.B = null;
        this.z = true;
        this.A = true;
        b(true);
        this.w = false;
        if (r0 == null) goto L10;
        a(r0);
    L10:
        g();
        this.x = false;
        Log.d("FloatingTrans-Bridge", "interruptedSource cleanup done");
        return;
    L5:
        r3 = false;
        goto L6
    }

    public static final /* synthetic */ Method z(a r0) {
        return r0.o;
    }

    private final void z() {
        C0785a r0 = this.q;
        if (r0 == null) goto L5;
        boolean r3 = true;
    L6:
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("cancelToTarget hasOverlay=", Boolean.valueOf(r3)));
        this.B = null;
        this.z = true;
        this.A = true;
        if (r0 == null) goto L9;
        a(r0.a(), r0.b(), r0.c(), r0.d(), true, false);
        return;
    L9:
        boolean r1 = f("cancel-no-overlay");
        this.w = false;
        this.f14786b.p();
        x();
        if (r1 == false) goto L14;
        B();
        return;
    L14:
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final void a() {
        if (this.F == true) goto L5;
    L13:
        boolean r0 = false;
    L14:
        if (r0 == true) goto L16;
        return;
    L16:
        f14784a.a();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L19;
        b(true, true);
        return;
    L19:
        this.f14786b.post(new $$Lambda$a$dezr0VMIDCc1wH7OIAFizGnUt4Y(this));
        return;
    L5:
        if (this.x == false) goto L7;
    L12:
        r0 = true;
        goto L14
    L7:
        if (this.E == true) goto L12;
        if (this.s == true) goto L12;
        if (this.q == null) goto L13;
        goto L12
    }

    public final void a(OFloatingTitleBarActionHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        g("onActionHostBound host=" + c(r4) + " bridge=" + E());
        if (o() == true) goto L8;
        StringBuilder r0 = new StringBuilder();
        String r2 = "onActionHostBound skip inactive host=";
    L5:
        g(r0.append(r2).append(c(r4)).append(" bridge=").append(E()).toString());
        return;
    L8:
        if (this.G.contains(r4) == true) goto L10;
        this.G.add(r4);
    L10:
        r4.a(true);
        r0 = new StringBuilder();
        r2 = "onActionHostBound hidden host=";
        goto L5
    }

    public final void a(c r3) {
        this.D = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
    }

    public final void a(String r7) {
        Intrinsics.checkNotNullParameter(r7, InfoRequestQPSOptTraceLogger.REASON);
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L5;
        return;
    L5:
        boolean r1 = false;
        if (this.F == false) goto L8;
    L13:
        boolean r0 = true;
    L15:
        if (this.E == false) goto L19;
        Log.d("FloatingTrans-Bridge", "restoreHiddenActionsIfIdle skipped reason=" + r7 + " pending=true");
        b(r7);
        return;
    L19:
        if (this.x == false) goto L24;
        if (r0 == false) goto L24;
        Log.d("FloatingTrans-Bridge", "restoreHiddenActionsIfIdle skipped reason=" + r7 + " hiddenByRegister=true");
        b(r7);
        return;
    L24:
        if (this.s == false) goto L26;
    L36:
        StringBuilder r2 = new StringBuilder().append("restoreHiddenActionsIfIdle skipped reason=").append(r7).append(" hidden=").append(this.w).append(" drawing=").append(this.s).append(" overlay=");
        if (this.q == null) goto L39;
        r1 = true;
    L39:
        Log.d("FloatingTrans-Bridge", r2.append(r1).toString());
        b(r7);
        return;
    L26:
        if (this.q != null) goto L36;
        if (this.w == false) goto L31;
    L34:
        r();
        e(r7);
        return;
    L31:
        if (this.x == true) goto L34;
        Log.d("FloatingTrans-Bridge", "restoreHiddenActionsIfIdle skipped reason=" + r7 + " hidden=false");
        return;
    L8:
        if (this.s == true) goto L13;
        if (this.q != null) goto L13;
        r0 = false;
        goto L15
    }

    public final void a(boolean r8) {
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L6;
        return;
    L6:
        if (this.c == false) goto L9;
        if (r8 == true) goto L9;
        return;
    L9:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f14786b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "titleBar.context");
        Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(r1), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L12;
        return;
    L12:
        IBinder r3 = a(r2);
        if (r3 != null) goto L15;
        return;
    L15:
        android.view.b r4 = D();
        if (r4 != null) goto L27;
        return;
    L27:
        boolean r5 = r4.a(r3, (android.view.a) ZeusTransformUtils.preCheckCast(this.P, android.view.a.class, "com.obric.memorydata.plugin"), (android.view.c) ZeusTransformUtils.preCheckCast(this.Q, android.view.c.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L23
        this.d = r3;     // Catch: Throwable -> L23
        this.c = true;     // Catch: Throwable -> L23
        R.put(r3, this);     // Catch: Throwable -> L23
        Log.d("FloatingTrans-Bridge", "register token=" + r3 + " hideOnRegister=" + r5 + " force=" + r8);     // Catch: Throwable -> L23
        e();     // Catch: Throwable -> L23
        if (r5 == false) goto L21;
        g(Intrinsics.stringPlus("register hideOnRegister before bridge=", E()));     // Catch: Throwable -> L23
        this.F = true;     // Catch: Throwable -> L23
        this.x = true;     // Catch: Throwable -> L23
        A();     // Catch: Throwable -> L23
        this.w = false;     // Catch: Throwable -> L23
        g(Intrinsics.stringPlus("register hideOnRegister after bridge=", E()));     // Catch: Throwable -> L23
    L26:
        return;
    L21:
        k();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("floating register failed: ", th.getMessage()));
        k();
    }

    public final void a(boolean r6, boolean r7) {
        r();
        i();
        h();
        n();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f14786b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "titleBar.context");
        Activity r1 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(r0), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L6;
    L4:
        this.d = null;
        this.c = false;
        return;
    L6:
        if (r7 == false) goto L8;
        b(r6, true);
    L8:
        IBinder r8 = this.d;
        if (r8 != null) goto L12;
        this.c = false;
        return;
    L12:
        android.view.b r9 = D();
        if (r9 != null) goto L17;
        Map<IBinder, a> r10 = R;
        if (r10.get(r8) != this) goto L4;
        r10.remove(r8);
        goto L4
    L17:
        Map<IBinder, a> r2 = R;
        if (r2.get(r8) == this) goto L39;
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("floating unregister skip nonOwner token=", r8));
        goto L4
    L39:
        r9.a(r8);     // Catch: Throwable -> L25
        if (r2.get(r8) != this) goto L24;
        r2.remove(r8);
    L24:
        this.d = null;
        this.c = false;
        return;
    L25:
        th = move-exception;
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("floating unregister failed: ", th.getMessage()));     // Catch: Throwable -> L31
        if (R.get(r8) != this) goto L24;
        R.remove(r8);
    L31:
        th = move-exception;
        Map<IBinder, a> r3 = R;
        if (r3.get(r8) != this) goto L35;
        r3.remove(r8);
    L35:
        this.d = null;
        this.c = false;
        throw th;
    }

    public final void b() {
        if (o() == true) goto L5;
        return;
    L5:
        f14784a.a();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L8;
        b(true, true);
        return;
    L8:
        this.f14786b.post(new $$Lambda$a$IBvnpIuPCm96DUnazFFHVqATIGw(this));
    }

    public final void b(OFloatingTitleBarActionHost r1) {
        h();
        this.y = r1;
        this.I = true;
        this.f14785J = false;
        this.O = false;
    }

    public final void c() {
        h();
    }

    public final boolean d() {
        if (this.s == false) goto L5;
    L8:
        return true;
    L5:
        if (this.q != null) goto L8;
        return false;
    }

    public final void e() {
        if (com.obric.oui.titlebar.floating.b.a() == true) goto L6;
        return;
    L6:
        if (this.c == true) goto L8;
        return;
    L8:
        if (this.f14786b.getWidth() != 0) goto L10;
        return;
    L10:
        if (this.f14786b.getHeight() == 0) goto L27;
        IBinder r0 = this.d;
        if (r0 != null) goto L15;
        return;
    L15:
        android.view.b r1 = D();
        if (r1 != null) goto L23;
        return;
    L23:
        Bundle r2 = s();     // Catch: Throwable -> L20
        this.r = new Bundle(r2);     // Catch: Throwable -> L20
        r1.a(r0, r2);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        Log.d("FloatingTrans-Bridge", Intrinsics.stringPlus("floating update state failed: ", th.getMessage()));
        return;
    }

    public final void f() {
        e();
        c("stateChanged");
    }
}
