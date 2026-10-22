package com.obric.memorydata.utils.icon;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002efB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020/J\u0010\u00100\u001a\u00020$2\b\b\u0001\u00101\u001a\u00020\nJ\u000e\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020\rJ\u001f\u00104\u001a\u00020$2\u0012\u00105\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r06\"\u00020\r¢\u0006\u0002\u00107J\u001e\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020\u00052\u000e\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u001cJ\u0010\u0010;\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0002J7\u0010<\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00052\b\b\u0002\u0010=\u001a\u00020>2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010@\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010AJ\b\u0010B\u001a\u00020$H\u0002J\u001e\u0010C\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0DJ\u0006\u0010E\u001a\u00020$J\u0006\u0010F\u001a\u00020$J[\u0010G\u001a\u0004\u0018\u00010\u000f2\u0006\u0010.\u001a\u00020/2\u0006\u00109\u001a\u00020\u00052\b\b\u0002\u0010H\u001a\u00020>2\u0018\b\u0002\u0010I\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010J2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010@\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0002\u0010KJ\u0091\u0001\u0010L\u001a\u00020$2\u0006\u0010.\u001a\u00020/2\u0006\u0010M\u001a\u00020)2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u000f2\b\b\u0003\u0010 \u001a\u00020\n2\u0018\b\u0002\u0010I\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010J2\u0016\b\u0002\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010J2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010@\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010P\u001a\u00020>¢\u0006\u0002\u0010QJ3\u0010R\u001a\u00020$2\u0006\u0010.\u001a\u00020/2\u0006\u0010M\u001a\u00020)2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010T\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010UJ\u0091\u0001\u0010V\u001a\u00020$2\u0006\u0010.\u001a\u00020/2\u0006\u0010M\u001a\u00020)2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u000f2\b\b\u0003\u0010 \u001a\u00020\n2\u0018\b\u0002\u0010I\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010J2\u0016\b\u0002\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010J2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010@\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010P\u001a\u00020>¢\u0006\u0002\u0010QJ3\u0010W\u001a\u00020$2\u0006\u0010.\u001a\u00020/2\u0006\u0010M\u001a\u00020)2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010T\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010UJ\u0018\u0010X\u001a\u00020$2\u0006\u0010M\u001a\u00020)2\u0006\u0010Y\u001a\u00020*H\u0002J\u0018\u0010Z\u001a\u00020$2\u0006\u0010M\u001a\u00020)2\u0006\u0010Y\u001a\u00020,H\u0002J\u0010\u0010[\u001a\u00020$2\u0006\u0010M\u001a\u00020)H\u0002J\b\u0010\\\u001a\u00020$H\u0002J\u000e\u0010]\u001a\u00020$2\u0006\u0010M\u001a\u00020)J\u0012\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tJ\u0014\u0010_\u001a\u00020$2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020$0\u001cJ\u0014\u0010a\u001a\u00020$2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020$0\u001cJ\u0010\u0010b\u001a\u00020$2\u0006\u0010.\u001a\u00020/H\u0002J\u001a\u0010c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010.\u001a\u00020/2\u0006\u00109\u001a\u00020\u0005H\u0002J\u000e\u0010d\u001a\u00020$2\u0006\u0010.\u001a\u00020/R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u001c0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n8\u0006@BX\u0087\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001c0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020,0(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/obric/memorydata/utils/icon/BaseAppIconCache;", "", "<init>", "()V", "TAG", "", "ACTION_OVERLAY_CHANGED", "mergedIconResMap", "", "Lkotlin/Pair;", "", "providers", "", "Lcom/obric/memorydata/utils/icon/AppIconProvider;", "appIconCache", "Landroid/graphics/drawable/Drawable;", "processedIconCache", "Landroid/util/LruCache;", "getProcessedIconCache", "()Landroid/util/LruCache;", "processedIconCache$delegate", "Lkotlin/Lazy;", "iconTaskMutexes", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlinx/coroutines/sync/Mutex;", "providerPackageNames", "", "dynamicIconLoaders", "Lkotlin/Function0;", "scope", "Lkotlinx/coroutines/CoroutineScope;", EventBody.KEY_VALUE, "defaultIconRes", "getDefaultIconRes", "()I", "overlayChangeListeners", "", "overlayReceiver", "Landroid/content/BroadcastReceiver;", "autoRefreshAppIconViews", "Ljava/util/WeakHashMap;", "Landroid/widget/ImageView;", "Lcom/obric/memorydata/utils/icon/BaseAppIconCache$AutoRefreshConfig;", "autoRefreshImageViews", "Lcom/obric/memorydata/utils/icon/BaseAppIconCache$AutoRefreshImageConfig;", CommonConsts.APM_INNER_EVENT_COST_INIT, "context", "Landroid/content/Context;", "setDefaultIcon", "iconRes", "registerProvider", "provider", "registerProviders", "providerList", "", "([Lcom/obric/memorydata/utils/icon/AppIconProvider;)V", "registerDynamicIconLoader", ObricMemoryConstants.KEY_PACKAGE_NAME, "loader", "dynamicIconCacheKey", "iconCacheKey", "hasCustomLoader", "", "cacheKeyOverride", "customIconRes", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "rebuildIconResMap", "getIconResMap", "", "releaseCache", "releaseAllCache", "getAppIcon", "disableDefaultDrawable", "customIconLoader", "Lkotlin/Function1;", "(Landroid/content/Context;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/Integer;)Landroid/graphics/drawable/Drawable;", "setAppIconImage", "imageView", "defaultIcon", "styleProcessor", "decorateIcon", "(Landroid/content/Context;Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/drawable/Drawable;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/Integer;Z)V", "setImage", "drawable", "drawableRes", "(Landroid/content/Context;Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;)V", "setAppIconImageWithAutoRefresh", "setImageWithAutoRefresh", "setupAutoRefresh", "config", "setupAutoRefreshImage", "clearImageViewOutline", "refreshAllAutoRefreshViews", "cancelAutoRefresh", "getAutoRefreshViewCount", "addOverlayChangeListener", "listener", "removeOverlayChangeListener", "registerOverlayReceiver", "getApplicationIcon", "destroy", "AutoRefreshConfig", "AutoRefreshImageConfig", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f13229a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Pair<Integer, Integer>> f13230b = null;
    private static final List<com.obric.memorydata.utils.icon.a> c = null;
    private static final Map<String, Drawable> d = null;
    private static final Lazy e = null;
    private static final ConcurrentHashMap<String, kotlinx.coroutines.sync.a> f = null;
    private static final Set<String> g = null;
    private static final ConcurrentHashMap<String, Function0<Drawable>> h = null;
    private static final al i = null;
    private static int j;
    private static final List<Function0<Unit>> k = null;
    private static PluginBroadcastReceiver l;
    private static final WeakHashMap<ImageView, a> m = null;
    private static final WeakHashMap<ImageView, C0724b> n = null;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b#\b\u0082\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000b\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\u0019\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000bHÆ\u0003J\u0017\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010 J\t\u0010,\u001a\u00020\u0010HÆ\u0003J\u008e\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\u00102\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\tHÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00063"}, d2 = {"Lcom/obric/memorydata/utils/icon/BaseAppIconCache$AutoRefreshConfig;", "", "context", "Landroid/content/Context;", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "defaultIcon", "Landroid/graphics/drawable/Drawable;", "defaultIconRes", "", "customIconLoader", "Lkotlin/Function1;", "styleProcessor", "cacheKeyOverride", "customIconRes", "decorateIcon", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroid/graphics/drawable/Drawable;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/Integer;Z)V", "getContext", "()Landroid/content/Context;", "getPackageName", "()Ljava/lang/String;", "getDefaultIcon", "()Landroid/graphics/drawable/Drawable;", "getDefaultIconRes", "()I", "getCustomIconLoader", "()Lkotlin/jvm/functions/Function1;", "getStyleProcessor", "getCacheKeyOverride", "getCustomIconRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDecorateIcon", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Landroid/content/Context;Ljava/lang/String;Landroid/graphics/drawable/Drawable;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/Integer;Z)Lcom/obric/memorydata/utils/icon/BaseAppIconCache$AutoRefreshConfig;", "equals", "other", "hashCode", "toString", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f13231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f13232b;
        private final Drawable c;
        private final int d;
        private final Function1<String, Drawable> e;
        private final Function1<Drawable, Drawable> f;
        private final String g;
        private final Integer h;
        private final boolean i;

        public a(Context r3, String r4, Drawable r5, int r6, Function1<? super String, ? extends Drawable> r7, Function1<? super Drawable, ? extends Drawable> r8, String r9, Integer r10, boolean r11) {
            Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Function1<String, Drawable> r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
            Function1<Drawable, Drawable> r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, "context");
            this.f13231a = ZeusTransformUtils.wrapperContext(r12, "com.obric.memorydata.plugin");
            this.f13232b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r13;
            this.f = r14;
            this.g = r9;
            this.h = r10;
            this.i = r11;
        }

        public final String a() {
            return this.f13232b;
        }

        public final Drawable b() {
            return this.c;
        }

        public final int c() {
            return this.d;
        }

        public final Function1<String, Drawable> d() {
            return this.e;
        }

        public final Function1<Drawable, Drawable> e() {
            return this.f;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13231a, r6.f13231a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13232b, r6.f13232b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L35;
            return false;
        L35:
            return true;
        }

        public final String f() {
            return this.g;
        }

        public final Integer g() {
            return this.h;
        }

        public final Context getContext() {
            return this.f13231a;
        }

        public final boolean h() {
            return this.i;
        }

        public int hashCode() {
            int r0 = this.f13231a.hashCode() * 31;
            String r1 = this.f13232b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Drawable r5 = this.c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (((r4 + r6) * 31) + Integer.hashCode(this.d)) * 31;
            Function1<String, Drawable> r8 = this.e;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Function1<Drawable, Drawable> r11 = this.f;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            String r14 = this.g;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            Integer r17 = this.h;
            if (r17 == null) goto L27;
            r2 = r17.hashCode();
        L27:
            return ((r16 + r2) * 31) + Boolean.hashCode(this.i);
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "AutoRefreshConfig(context=" + this.f13231a + ", packageName=" + this.f13232b + ", defaultIcon=" + this.c + ", defaultIconRes=" + this.d + ", customIconLoader=" + this.e + ", styleProcessor=" + this.f + ", cacheKeyOverride=" + this.g + ", customIconRes=" + this.h + ", decorateIcon=" + this.i + ')';
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.utils.icon.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ0\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/utils/icon/BaseAppIconCache$AutoRefreshImageConfig;", "", "context", "Landroid/content/Context;", "drawable", "Landroid/graphics/drawable/Drawable;", "drawableRes", "", "<init>", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;)V", "getContext", "()Landroid/content/Context;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getDrawableRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;)Lcom/obric/memorydata/utils/icon/BaseAppIconCache$AutoRefreshImageConfig;", "equals", "", "other", "hashCode", "toString", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0724b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f13233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Drawable f13234b;
        private final Integer c;

        public C0724b(Context r3, Drawable r4, Integer r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "context");
            this.f13233a = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
            this.f13234b = r4;
            this.c = r5;
        }

        public final Drawable a() {
            return this.f13234b;
        }

        public final Integer b() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0724b.class) == true) goto L8;
            return false;
        L8:
            C0724b r6 = (C0724b) ZeusTransformUtils.preCheckCast(r5, C0724b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f13233a, r6.f13233a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f13234b, r6.f13234b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final Context getContext() {
            return this.f13233a;
        }

        public int hashCode() {
            int r0 = this.f13233a.hashCode() * 31;
            Drawable r1 = this.f13234b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Integer r5 = this.c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "AutoRefreshImageConfig(context=" + this.f13233a + ", drawable=" + this.f13234b + ", drawableRes=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0014J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0014¨\u0006\u000e"}, d2 = {"com/obric/memorydata/utils/icon/BaseAppIconCache$processedIconCache$2$1", "Landroid/util/LruCache;", "", "Landroid/graphics/drawable/Drawable;", "sizeOf", "", "key", EventBody.KEY_VALUE, "entryRemoved", "", "evicted", "", "oldValue", "newValue", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends LruCache<String, Drawable> {
        c(int r1) {
            super(r1);
        }

        public int a(String r1, Drawable r2) {
            Intrinsics.checkNotNullParameter(r1, "key");
            Intrinsics.checkNotNullParameter(r2, EventBody.KEY_VALUE);
            if (ZeusTransformUtils.instanceOf(r2, BitmapDrawable.class) == true) goto L5;
        L7:
            return 144;
        L5:
            if (((BitmapDrawable) ZeusTransformUtils.preCheckCast(r2, BitmapDrawable.class, "com.obric.memorydata.plugin")).getBitmap() == null) goto L7;
            return ((BitmapDrawable) ZeusTransformUtils.preCheckCast(r2, BitmapDrawable.class, "com.obric.memorydata.plugin")).getBitmap().getAllocationByteCount() / 1024;
        }

        public void a(boolean r1, String r2, Drawable r3, Drawable r4) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "oldValue");
            if (r1 == false) goto L6;
            RunLog.INSTANCE.debug("BaseAppIconCache", "LruCache EVICTED [key=" + r2 + "]. Current icon count: " + snapshot().size() + ", Memory used: " + size() + " KB / " + maxSize() + " KB");
            return;
        }

        @Override // android.util.LruCache
        public /* synthetic */ void entryRemoved(boolean r3, String r4, Drawable r5, Drawable r6) {
            a(r3, (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"), (Drawable) ZeusTransformUtils.preCheckCast(r5, Drawable.class, "com.obric.memorydata.plugin"), (Drawable) ZeusTransformUtils.preCheckCast(r6, Drawable.class, "com.obric.memorydata.plugin"));
        }

        @Override // android.util.LruCache
        public /* synthetic */ int sizeOf(String r3, Drawable r4) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (Drawable) ZeusTransformUtils.preCheckCast(r4, Drawable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.memorydata.utils.icon.a) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.utils.icon.a.class, "com.obric.memorydata.plugin")).b()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((com.obric.memorydata.utils.icon.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.utils.icon.a.class, "com.obric.memorydata.plugin")).b()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/utils/icon/BaseAppIconCache$registerOverlayReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "ctx", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends PluginBroadcastReceiver {
        e() {
        }

        public void onReceive(Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin"), "ctx");
            Intrinsics.checkNotNullParameter(r9, MemorySourceLinkType.INTENT);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BaseAppIconCache", "ACTION_OVERLAY_CHANGED received, clearing icon cache", false, 4, null);
            b.f13229a.b();
            b.a(b.f13229a);
            Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(b.e(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            ((Function0) ZeusTransformUtils.preCheckCast(r7.next(), Function0.class, "com.obric.memorydata.plugin")).invoke();
            goto L4
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f13235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f13236b;
        final /* synthetic */ String c;
        final /* synthetic */ Function1 d;
        final /* synthetic */ String e;
        final /* synthetic */ Integer f;
        final /* synthetic */ boolean g;
        final /* synthetic */ Function1 h;
        final /* synthetic */ Drawable i;
        final /* synthetic */ Context j;

        public f(ImageView r3, String r4, String r5, Function1 r6, String r7, Integer r8, boolean r9, Function1 r10, Drawable r11, Context r12) {
            Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
            Function1 r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
            Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
            this.f13235a = r3;
            this.f13236b = r4;
            this.c = r5;
            this.d = r13;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r14;
            this.i = r11;
            this.j = ZeusTransformUtils.wrapperContext(r15, "com.obric.memorydata.plugin");
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
            r11.removeOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
            b.a(this.f13235a, this.f13236b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f13237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f13238b;
        final /* synthetic */ Drawable c;
        final /* synthetic */ Context d;

        public g(ImageView r3, int r4, Drawable r5, Context r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            this.f13237a = r3;
            this.f13238b = r4;
            this.c = r5;
            this.d = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(this, View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
            b.a(this.f13237a, this.f13238b, this.c, this.d);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/utils/icon/BaseAppIconCache$setupAutoRefresh$attachListener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", BaseSwitches.V, "Landroid/view/View;", "onViewDetachedFromWindow", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class h implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f13239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f13240b;

        h(ImageView r1, a r2) {
            this.f13239a = r1;
            this.f13240b = r2;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, BaseSwitches.V);
            ((Map) ZeusTransformUtils.preCheckCast(b.c(), Map.class, "com.obric.memorydata.plugin")).put(this.f13239a, this.f13240b);
            RunLog.INSTANCE.debug("BaseAppIconCache", "ImageView attached: " + System.identityHashCode(this.f13239a));
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, BaseSwitches.V);
            b.c().remove(this.f13239a);
            RunLog.INSTANCE.debug("BaseAppIconCache", "ImageView detached: " + System.identityHashCode(this.f13239a));
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/utils/icon/BaseAppIconCache$setupAutoRefreshImage$attachListener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", BaseSwitches.V, "Landroid/view/View;", "onViewDetachedFromWindow", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class i implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f13241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ C0724b f13242b;

        i(ImageView r1, C0724b r2) {
            this.f13241a = r1;
            this.f13242b = r2;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, BaseSwitches.V);
            ((Map) ZeusTransformUtils.preCheckCast(b.d(), Map.class, "com.obric.memorydata.plugin")).put(this.f13241a, this.f13242b);
            RunLog.INSTANCE.debug("BaseAppIconCache", "Image attached: " + System.identityHashCode(this.f13241a));
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r3) {
            Intrinsics.checkNotNullParameter(r3, BaseSwitches.V);
            b.d().remove(this.f13241a);
            RunLog.INSTANCE.debug("BaseAppIconCache", "Image detached: " + System.identityHashCode(this.f13241a));
        }
    }

    static {
        f13229a = new b();
        f13230b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        d = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        e = LazyKt.lazy($$Lambda$b$yITEdP3Qd49LHVal_5GwquQISU0.INSTANCE);
        f = new ConcurrentHashMap();
        g = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        h = new ConcurrentHashMap();
        i = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        j = ZeusTransformUtils.mapRes(R.drawable.ic_rectangle_default, "drawable", "ic_rectangle_default");
        k = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        m = new WeakHashMap();
        n = new WeakHashMap();
    }

    private b() {
    }

    private final Drawable a(Context r3, String r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r4, AppInfo.Calendar.getPackageName()) == false) goto L6;
        return (Drawable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.icon.c.f13243a.a(r2, AppInfo.OAssistant.getPackageName(), ZeusTransformUtils.getResources(r2, "com.obric.memorydata.plugin").getDisplayMetrics().densityDpi), Drawable.class, "com.obric.memorydata.plugin");
    L6:
        return com.obric.memorydata.utils.c.f13193a.b(r2, r4);
    }

    public static /* synthetic */ Drawable a(b r9, Context r10, String r11, boolean r12, Function1 r13, String r14, Integer r15, int r16, Object r17) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Function1<? super String, ? extends Drawable> r0 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        if ((r16 & 4) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r16 & 8) == 0) goto L9;
        Function1<? super String, ? extends Drawable> r6 = null;
    L11:
        if ((r16 & 16) == 0) goto L13;
        String r7 = null;
    L15:
        if ((r16 & 32) == 0) goto L17;
        Integer r8 = null;
    L19:
        return r9.a(r3, r11, r5, r6, r7, r8);
    L17:
        r8 = r15;
        goto L19
    L13:
        r7 = r14;
        goto L15
    L9:
        r6 = r0;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }

    private final String a(String r2) {
        return "dynamic_icon:" + r2;
    }

    private final String a(String r3, boolean r4, String r5, Integer r6) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L13;
        StringBuilder r2 = new StringBuilder().append("override_icon:").append(r5);
    L12:
        return r2.toString();
    L13:
        if (r6 == null) goto L15;
        r2 = new StringBuilder().append("resource_icon:").append(r6);
        goto L12
    L15:
        if (r4 == true) goto L19;
        if (h.containsKey(r3) == true) goto L19;
        return r3;
    L19:
        return a(r3);
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final void a(ImageView r1) {
        r1.setClipToOutline(false);
        r1.setOutlineProvider(null);
    }

    public static final /* synthetic */ void a(ImageView r2, int r3, Drawable r4, Context r5) {
        b(r2, r3, r4, (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin"));
    }

    private final void a(ImageView r5, a r6) {
        Object r4 = r5.getTag(ZeusTransformUtils.mapRes(R.id.app_icon_attach_listener, OaidModel.KEY_ID, "app_icon_attach_listener"));
        if (ZeusTransformUtils.instanceOf(r4, View.OnAttachStateChangeListener.class) == false) goto L5;
        View.OnAttachStateChangeListener r7 = (View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(r4, View.OnAttachStateChangeListener.class, "com.obric.memorydata.plugin");
    L6:
        if (r7 == null) goto L8;
        r5.removeOnAttachStateChangeListener(r7);
    L8:
        h r8 = new h(r5, r6);
        r5.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(r8, View.OnAttachStateChangeListener.class, "com.obric.memorydata.plugin"));
        r5.setTag(ZeusTransformUtils.mapRes(R.id.app_icon_attach_listener, OaidModel.KEY_ID, "app_icon_attach_listener"), r8);
        if (r5.isAttachedToWindow() == false) goto L12;
        ((Map) ZeusTransformUtils.preCheckCast(m, Map.class, "com.obric.memorydata.plugin")).put(r5, r6);
        return;
    L12:
        return;
    L5:
        r7 = null;
        goto L6
    }

    private final void a(ImageView r5, C0724b r6) {
        Object r4 = r5.getTag(ZeusTransformUtils.mapRes(R.id.app_icon_attach_listener, OaidModel.KEY_ID, "app_icon_attach_listener"));
        if (ZeusTransformUtils.instanceOf(r4, View.OnAttachStateChangeListener.class) == false) goto L5;
        View.OnAttachStateChangeListener r7 = (View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(r4, View.OnAttachStateChangeListener.class, "com.obric.memorydata.plugin");
    L6:
        if (r7 == null) goto L8;
        r5.removeOnAttachStateChangeListener(r7);
    L8:
        i r8 = new i(r5, r6);
        r5.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(r8, View.OnAttachStateChangeListener.class, "com.obric.memorydata.plugin"));
        r5.setTag(ZeusTransformUtils.mapRes(R.id.app_icon_attach_listener, OaidModel.KEY_ID, "app_icon_attach_listener"), r8);
        if (r5.isAttachedToWindow() == false) goto L12;
        ((Map) ZeusTransformUtils.preCheckCast(n, Map.class, "com.obric.memorydata.plugin")).put(r5, r6);
        return;
    L12:
        return;
    L5:
        r7 = null;
        goto L6
    }

    public static final /* synthetic */ void a(ImageView r12, String r13, String r14, Function1 r15, String r16, Integer r17, boolean r18, Function1 r19, Drawable r20, Context r21) {
        b(r12, r13, r14, (Function1) ZeusTransformUtils.wrapperContextForParams(r15, Function1.class, "com.obric.memorydata.plugin"), r16, r17, r18, (Function1) ZeusTransformUtils.wrapperContextForParams(r19, Function1.class, "com.obric.memorydata.plugin"), r20, (Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(b r0) {
        r0.i();
    }

    public static /* synthetic */ void a(b r1, Context r2, ImageView r3, Drawable r4, Integer r5, int r6, Object r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.b(r8, r3, r4, r5);
    }

    public static /* synthetic */ void a(b r14, Context r15, ImageView r16, String r17, Drawable r18, int r19, Function1 r20, Function1 r21, String r22, Integer r23, boolean r24, int r25, Object r26) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.memorydata.plugin");
        Function1<? super String, ? extends Drawable> r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r20, Function1.class, "com.obric.memorydata.plugin");
        Function1<? super Drawable, ? extends Drawable> r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r21, Function1.class, "com.obric.memorydata.plugin");
        if ((r25 & 4) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r25 & 8) == 0) goto L9;
        Drawable r7 = null;
    L11:
        if ((r25 & 16) == 0) goto L13;
        int r8 = j;
    L15:
        if ((r25 & 32) == 0) goto L17;
        Function1<? super String, ? extends Drawable> r9 = null;
    L19:
        if ((r25 & 64) == 0) goto L21;
        Function1<? super Drawable, ? extends Drawable> r10 = null;
    L23:
        if ((r25 & 128) == 0) goto L25;
        String r11 = null;
    L27:
        if ((r25 & 256) == 0) goto L29;
        Integer r12 = null;
    L31:
        if ((r25 & 512) == 0) goto L33;
        boolean r13 = true;
    L34:
        r14.b(r4, r16, r6, r7, r8, r9, r10, r11, r12, r13);
        return;
    L33:
        r13 = r24;
        goto L34
    L29:
        r12 = r23;
        goto L31
    L25:
        r11 = r22;
        goto L27
    L21:
        r10 = r2;
        goto L23
    L17:
        r9 = r1;
        goto L19
    L13:
        r8 = r19;
        goto L15
    L9:
        r7 = r18;
        goto L11
    L5:
        r6 = r17;
        goto L7
    }

    public static final /* synthetic */ LruCache b(b r0) {
        return r0.g();
    }

    private final void b(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (l == null) goto L5;
        return;
    L5:
        l = (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(new e(), PluginBroadcastReceiver.class, "com.obric.memorydata.plugin");
        IntentFilter r5 = new IntentFilter("android.intent.action.OVERLAY_CHANGED");
        r5.addDataScheme("package");
        r5.addDataSchemeSpecificPart("android", 0);
        ZeusTransformUtils.registerReceiver(r3, l, r5, "com.obric.memorydata.plugin");
    }

    private static final void b(ImageView r15, int r16, Drawable r17, Context r18) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r15.getTag(ZeusTransformUtils.mapRes(R.id.app_icon_package, OaidModel.KEY_ID, "app_icon_package")), Integer.valueOf(r16)) == true) goto L5;
        return;
    L5:
        Integer r0 = Integer.valueOf(Math.min(r15.getWidth(), r15.getHeight()));
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L14;
        int r2 = r0.intValue();
    L15:
        int r6 = r2;
        String r3 = "image_" + r16 + '_' + r6;
        Drawable r4 = (Drawable) ZeusTransformUtils.preCheckCast(f13229a.g().get(r3), Drawable.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L19;
        r15.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r15.setImageDrawable(r4);
        return;
    L19:
        r15.setTag(ZeusTransformUtils.mapRes(R.id.app_icon_job, OaidModel.KEY_ID, "app_icon_job"), kotlinx.coroutines.i.a(i, null, null, (Function2) ZeusTransformUtils.preCheckCast(new BaseAppIconCache$setImage$loadImage$job$1(r15, r16, r3, r17, r5, r6, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));
        return;
    L14:
        r2 = MathKt.roundToInt(TypedValue.applyDimension(1, ((Number) ZeusTransformUtils.preCheckCast(48, Number.class, "com.obric.memorydata.plugin")).floatValue(), Resources.getSystem().getDisplayMetrics()));
        goto L15
    L8:
        r1 = false;
        goto L9
    }

    private static final void b(ImageView r21, String r22, String r23, Function1<? super String, ? extends Drawable> r24, String r25, Integer r26, boolean r27, Function1<? super Drawable, ? extends Drawable> r28, Drawable r29, Context r30) {
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r24, Function1.class, "com.obric.memorydata.plugin");
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r28, Function1.class, "com.obric.memorydata.plugin");
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r30, Context.class, "com.obric.memorydata.plugin");
        Object r0 = r21.getTag(ZeusTransformUtils.mapRes(R.id.app_icon_package, OaidModel.KEY_ID, "app_icon_package"));
        Integer r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L5;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    L7:
        if (Intrinsics.areEqual(r1, r22) == true) goto L9;
        return;
    L9:
        Integer r4 = Integer.valueOf(Math.min(r21.getWidth(), r21.getHeight()));
        boolean r5 = false;
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L15;
        r2 = r4;
    L15:
        if (r2 == null) goto L17;
        int r8 = r2.intValue();
    L18:
        int r12 = r8;
        StringBuilder r10 = new StringBuilder();
        b r11 = f13229a;
        if (r9 == null) goto L21;
        r5 = true;
    L21:
        String r13 = r10.append(r11.a(r23, r5, r25, r26)).append('_').append(r12).append("_decorate_").append(r27).toString();
        if (r3 != null) goto L27;
        Drawable r14 = (Drawable) ZeusTransformUtils.preCheckCast(r11.g().get(r13), Drawable.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L27;
        r21.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r21.setImageDrawable(r14);
        return;
    L27:
        r21.setTag(ZeusTransformUtils.mapRes(R.id.app_icon_job, OaidModel.KEY_ID, "app_icon_job"), kotlinx.coroutines.i.a(i, null, null, (Function2) ZeusTransformUtils.preCheckCast(new BaseAppIconCache$setAppIconImage$loadIcon$job$1(r21, r22, r3, r13, r27, r29, r7, r23, r9, r25, r26, r12, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));
        return;
    L17:
        r8 = MathKt.roundToInt(TypedValue.applyDimension(1, ((Number) ZeusTransformUtils.preCheckCast(48, Number.class, "com.obric.memorydata.plugin")).floatValue(), Resources.getSystem().getDisplayMetrics()));
        goto L18
    L12:
        r6 = false;
        goto L13
    L5:
        r1 = null;
        goto L7
    }

    private static final boolean b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return !g.contains(r1);
    }

    public static final /* synthetic */ WeakHashMap c() {
        return m;
    }

    public static final /* synthetic */ WeakHashMap d() {
        return n;
    }

    public static final /* synthetic */ List e() {
        return k;
    }

    public static final /* synthetic */ ConcurrentHashMap f() {
        return f;
    }

    private final LruCache<String, Drawable> g() {
        return (LruCache) ZeusTransformUtils.preCheckCast(e.getValue(), LruCache.class, "com.obric.memorydata.plugin");
    }

    private final synchronized void h() {
        monitor-enter(this);
        f13230b.clear();     // Catch: Throwable -> L15
        g.clear();     // Catch: Throwable -> L15
        g().evictAll();     // Catch: Throwable -> L15
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new d(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L15
    L5:
        if (r0.hasNext() == false) goto L13;
        Map<? extends String, ? extends Pair<Integer, Integer>> r1 = MapsKt.toMap(((com.obric.memorydata.utils.icon.a) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.memorydata.utils.icon.a.class, "com.obric.memorydata.plugin")).a());     // Catch: Throwable -> L15
        f13230b.putAll(r1);     // Catch: Throwable -> L15
        Iterator<Map.Entry<? extends String, ? extends Pair<Integer, Integer>>> r2 = r1.entrySet().iterator();     // Catch: Throwable -> L15
    L8:
        if (r2.hasNext() == false) goto L5;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        Pair r5 = (Pair) ZeusTransformUtils.preCheckCast(r3.getValue(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        g.add(r4);     // Catch: Throwable -> L15
        Drawable r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getDrawable(((Number) ZeusTransformUtils.preCheckCast(r5.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue());     // Catch: Throwable -> L15
        if (r6 == null) goto L8;
        d.put(r4, r6);     // Catch: Throwable -> L15
        goto L8
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private final void i() {
        kotlinx.coroutines.i.a(i, (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new BaseAppIconCache$refreshAllAutoRefreshViews$1(null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    private static final c j() {
        int r0 = (int) (Runtime.getRuntime().maxMemory() / ((long) 1024));
        int r1 = r0 / 8;
        RunLog.INSTANCE.debug("BaseAppIconCache", "Init processedIconCache, maxMemory: " + r0 + " KB, allocated cacheSize: " + r1 + " KB");
        return new c(r1);
    }

    /* JADX INFO: renamed from: lambda$swiXop9-dmwkeS40Qdxiw8YwNJ4, reason: not valid java name */
    public static /* synthetic */ boolean m1248lambda$swiXop9dmwkeS40Qdxiw8YwNJ4(String r0) {
        return b(r0);
    }

    public static /* synthetic */ c lambda$yITEdP3Qd49LHVal_5GwquQISU0() {
        return j();
    }

    public final int a() {
        return j;
    }

    public final Drawable a(Context r5, String r6, boolean r7, Function1<? super String, ? extends Drawable> r8, String r9, Integer r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (r12 == null) goto L5;
        boolean r0 = true;
    L6:
        String r13 = a(r6, r0, r9, r10);
        Map<String, Drawable> r1 = d;
        if (r1.containsKey(r13) == false) goto L12;
        RunLog.INSTANCE.debug("BaseAppIconCache", r13 + " hit cache");
    L10:
        return (Drawable) ZeusTransformUtils.preCheckCast(r1.get(r13), Drawable.class, "com.obric.memorydata.plugin");
    L12:
        if (r10 == null) goto L15;
        Drawable r14 = ContextCompat.getDrawable(r11, ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r14 == null) goto L15;
    L25:
        if (r14 == null) goto L27;
        r1.put(r13, r14);
        goto L10
    L27:
        Pair r15 = (Pair) ZeusTransformUtils.preCheckCast(f13230b.get(r6), Pair.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L32;
        Drawable r4 = ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").getDrawable(((Number) ZeusTransformUtils.preCheckCast(r15.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue(), null);
        if (r4 == null) goto L10;
    L31:
        r1.put(r13, r4);
        goto L10
    L32:
        b r16 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
        if (r7 == true) goto L10;
        if (j == 0) goto L10;
        r4 = ZeusTransformUtils.getResources(r11, "com.obric.memorydata.plugin").getDrawable(j, null);
    L15:
        if (r12 == null) goto L17;
        r14 = (Drawable) ZeusTransformUtils.preCheckCast(r12.invoke(r6), Drawable.class, "com.obric.memorydata.plugin");
    L18:
        if (r14 != null) goto L25;
        Function0 r17 = (Function0) ZeusTransformUtils.preCheckCast(h.get(r6), Function0.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L22;
        r14 = (Drawable) ZeusTransformUtils.preCheckCast(r17.invoke(), Drawable.class, "com.obric.memorydata.plugin");
    L23:
        if (r14 != null) goto L25;
        r14 = a(r11, r6);
        goto L25
    L22:
        r14 = null;
        goto L23
    L17:
        r14 = null;
        goto L18
    L5:
        r0 = false;
        goto L6
    }

    public final void a(int r1) {
        j = r1;
    }

    public final void a(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BaseAppIconCache", "init ...", false, 4, null);
        b(r9);
    }

    public final void a(Context r5, ImageView r6, Drawable r7, Integer r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r6, "imageView");
        a(r6);
        RunLog.INSTANCE.debug("BaseAppIconCache", '[' + System.identityHashCode(r6) + "] setImage called, drawableRes=" + r8 + ", size=" + r6.getWidth() + 'x' + r6.getHeight());
        Object r4 = r6.getTag(ZeusTransformUtils.mapRes(R.id.app_icon_job, OaidModel.KEY_ID, "app_icon_job"));
        Drawable r3 = null;
        if (ZeusTransformUtils.instanceOf(r4, bx.class) == false) goto L5;
        bx r10 = (bx) ZeusTransformUtils.preCheckCast(r4, bx.class, "com.obric.memorydata.plugin");
    L6:
        if (r10 == null) goto L8;
        bx.a.a(r10, null, 1, null);
    L8:
        if (r7 != null) goto L15;
        if (r8 == null) goto L11;
        r3 = ContextCompat.getDrawable(r9, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue());
    L11:
        if (r3 == null) goto L14;
    L16:
        if (r8 == null) goto L18;
        int r11 = r8.intValue();
    L19:
        r6.setTag(ZeusTransformUtils.mapRes(R.id.app_icon_package, OaidModel.KEY_ID, "app_icon_package"), Integer.valueOf(r11));
        if (r6.getWidth() > 0) goto L22;
    L24:
        View r12 = (View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin");
        if (ViewCompat.isLaidOut(r12) == true) goto L27;
    L29:
        r12.addOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(new g(r6, r11, r3, r9), View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
        return;
    L27:
        if (r12.isLayoutRequested() == true) goto L29;
        a(r6, r11, r3, r9);
        return;
    L22:
        if (r6.getHeight() <= 0) goto L24;
        b(r6, r11, r3, r9);
        return;
    L18:
        r11 = System.identityHashCode(r7);
        goto L19
    L14:
        throw new IllegalStateException("drawable & drawableRes can't be null at the same time".toString());
    L15:
        r3 = r7;
        goto L16
    L5:
        r10 = null;
        goto L6
    }

    public final void a(Context r19, ImageView r20, String r21, Drawable r22, int r23, Function1<? super String, ? extends Drawable> r24, Function1<? super Drawable, ? extends Drawable> r25, String r26, Integer r27, boolean r28) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.memorydata.plugin");
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r24, Function1.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r25, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r20, "imageView");
        a(r20);
        RunLog.INSTANCE.debug("BaseAppIconCache", '[' + System.identityHashCode(r20) + "] setAppIconImage called, packageName=" + r21 + ", size=" + r20.getWidth() + 'x' + r20.getHeight());
        Object r5 = r20.getTag(ZeusTransformUtils.mapRes(R.id.app_icon_job, OaidModel.KEY_ID, "app_icon_job"));
        if (ZeusTransformUtils.instanceOf(r5, bx.class) == false) goto L5;
        bx r6 = (bx) ZeusTransformUtils.preCheckCast(r5, bx.class, "com.obric.memorydata.plugin");
    L6:
        boolean r7 = true;
        if (r6 == null) goto L9;
        bx.a.a(r6, null, 1, null);
    L9:
        if (r26 != null) goto L11;
        String r9 = r21;
    L12:
        r20.setTag(ZeusTransformUtils.mapRes(R.id.app_icon_package, OaidModel.KEY_ID, "app_icon_package"), r9);
        if (r22 != null) goto L19;
        b r0 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BaseAppIconCache", "fallback to defaultIconRes: " + r23, false, 4, null);
        Drawable r1 = ContextCompat.getDrawable(r10, r23);
        if (r1 == null) goto L18;
        Drawable r11 = r1;
    L20:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L23;
    L26:
        if (r7 == false) goto L30;
        r20.setImageDrawable(r11);
        return;
    L30:
        if (r20.getWidth() > 0) goto L32;
    L34:
        View r12 = (View) ZeusTransformUtils.preCheckCast(r20, View.class, "com.obric.memorydata.plugin");
        if (ViewCompat.isLaidOut(r12) == true) goto L37;
    L39:
        r12.addOnLayoutChangeListener((View.OnLayoutChangeListener) ZeusTransformUtils.preCheckCast(new f(r20, r9, r21, r4, r26, r27, r28, r8, r11, r10), View.OnLayoutChangeListener.class, "com.obric.memorydata.plugin"));
        return;
    L37:
        if (r12.isLayoutRequested() == true) goto L39;
        a(r20, r9, r21, r4, r26, r27, r28, r8, r11, r10);
        return;
    L32:
        if (r20.getHeight() <= 0) goto L34;
        b(r20, r9, r21, r4, r26, r27, r28, r8, r11, r10);
        return;
    L23:
        if (r2.length() == 0) goto L26;
        r7 = false;
        goto L26
    L18:
        throw new IllegalStateException("get default icon failed".toString());
    L19:
        r11 = r22;
        goto L20
    L11:
        r9 = r26;
        goto L12
    L5:
        r6 = null;
        goto L6
    }

    public final synchronized void a(String r10, Function0<? extends Drawable> r11) {
        monitor-enter(this);
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Intrinsics.checkNotNullParameter(r10, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L20
        Intrinsics.checkNotNullParameter(r12, "loader");     // Catch: Throwable -> L20
        ((Map) ZeusTransformUtils.preCheckCast(h, Map.class, "com.obric.memorydata.plugin")).put(r10, r12);     // Catch: Throwable -> L20
        Map<String, Drawable> r13 = d;     // Catch: Throwable -> L20
        r13.remove(r10);     // Catch: Throwable -> L20
        r13.remove(a(r10));     // Catch: Throwable -> L20
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(g().snapshot().keySet(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Iterator r15 = r14.iterator();     // Catch: Throwable -> L20
    L5:
        if (r15.hasNext() == false) goto L13;
        Object r1 = r15.next();     // Catch: Throwable -> L20
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L20
        boolean r7 = false;
        if (StringsKt.startsWith$default(r2, r10 + '_', false, 2, null) == false) goto L9;
    L10:
        r7 = true;
    L11:
        if (r7 == false) goto L5;
        r0.add(r1);     // Catch: Throwable -> L20
        goto L5
    L9:
        if (StringsKt.startsWith$default(r2, f13229a.a(r10) + '_', false, 2, null) == false) goto L11;
    L13:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        LruCache<String, Drawable> r17 = g();     // Catch: Throwable -> L20
        Iterator r18 = r16.iterator();     // Catch: Throwable -> L20
    L14:
        if (r18.hasNext() == false) goto L18;
        r17.remove((String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L20
        goto L14
    L18:
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void a(com.obric.memorydata.utils.icon.a... r4) {
        Intrinsics.checkNotNullParameter(r4, "providerList");
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(c, Collection.class, "com.obric.memorydata.plugin"), r4);
        h();
    }

    public final synchronized void b() {
        monitor-enter(this);
        CollectionsKt.removeAll((Iterable) ZeusTransformUtils.preCheckCast(d.keySet(), Iterable.class, "com.obric.memorydata.plugin"), $$Lambda$b$swiXop9dmwkeS40Qdxiw8YwNJ4.INSTANCE);     // Catch: Throwable -> L6
        g().evictAll();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void b(Context r3, ImageView r4, Drawable r5, Integer r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r4, "imageView");
        C0724b r0 = new C0724b(r7, r5, r6);
        a(r7, r4, r5, r6);
        a(r4, r0);
    }

    public final void b(Context r23, ImageView r24, String r25, Drawable r26, int r27, Function1<? super String, ? extends Drawable> r28, Function1<? super Drawable, ? extends Drawable> r29, String r30, Integer r31, boolean r32) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.memorydata.plugin");
        Function1<? super String, ? extends Drawable> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r28, Function1.class, "com.obric.memorydata.plugin");
        Function1<? super Drawable, ? extends Drawable> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r29, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r24, "imageView");
        a r10 = new a(r2, r25, r26, r27, r6, r7, r30, r31, r32);
        a(r2, r24, r25, r26, r27, r6, r7, r30, r31, r32);
        a(r24, r10);
    }
}
