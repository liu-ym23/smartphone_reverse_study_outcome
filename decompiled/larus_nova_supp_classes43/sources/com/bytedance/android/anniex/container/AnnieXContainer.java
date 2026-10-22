package com.bytedance.android.anniex.container;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.android.anniex.base.builder.UIComponentBuilder;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.base.depend.DeviceDepend;
import com.bytedance.android.anniex.base.lifecycle.AnnieXLynxViewClientProxy;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.anniex.worker.AnnieXJSWorkerManager;
import com.bytedance.ies.argus.api.ArgusContainerDelegate;
import com.bytedance.ies.argus.api.params.ArgusContainerCreateType;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.BulletContextManager;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.q;
import com.bytedance.ies.bullet.core.r;
import com.bytedance.ies.bullet.deprecate.fake.ContainerBidParam;
import com.bytedance.ies.bullet.flow.FlowContainerLoaderSwitch;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.service.base.CacheType;
import com.bytedance.ies.bullet.service.base.b0;
import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import com.bytedance.ies.bullet.ui.common.DebugTagTextView;
import com.bytedance.ies.bullet.ui.common.loader.BulletContainerLoader;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000Þ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0006á\u0001ä\u0001è\u0001\b!\u0018\u0000 ¸\u00022\u00020\u0001:\u0002¹\u0002B\u0013\u0012\b\u0010±\u0001\u001a\u00030°\u0001¢\u0006\u0006\b¶\u0002\u0010·\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001c\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0002J\b\u0010\u0017\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002JH\u0010&\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001dH\u0002J&\u0010+\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00022\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)\u0018\u00010(H\u0002J\u001e\u0010,\u001a\u00020\u00042\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)\u0018\u00010(H\u0002J\u0010\u0010.\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u001dH\u0002J\b\u0010/\u001a\u00020\u0004H\u0002J\u0012\u00102\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u000200H\u0002J\u0018\u00105\u001a\u00020\r2\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u001dH\u0002J\u0010\u00107\u001a\u00020\r2\u0006\u00106\u001a\u00020\u001dH\u0002J\u0010\u00108\u001a\u00020\r2\u0006\u00106\u001a\u00020\u001dH\u0002J\b\u00109\u001a\u00020\rH\u0002J\b\u0010:\u001a\u00020\rH\u0002J\b\u0010;\u001a\u00020\rH\u0002J\b\u0010<\u001a\u00020\rH\u0002J&\u0010>\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u001d2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)\u0018\u00010(H\u0002J$\u0010B\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010@\u001a\u00020?2\b\b\u0002\u0010A\u001a\u00020\u0004H\u0002J\b\u0010C\u001a\u00020\rH\u0002J\b\u0010D\u001a\u00020\rH\u0002J\b\u0010E\u001a\u00020\rH\u0002J\u0010\u0010H\u001a\u00020\u00042\u0006\u0010G\u001a\u00020FH\u0002J\b\u0010I\u001a\u00020\rH\u0002J\b\u0010J\u001a\u00020\rH\u0002J\b\u0010L\u001a\u00020KH\u0002J\b\u0010M\u001a\u00020\rH\u0002J\n\u0010O\u001a\u0004\u0018\u00010NH\u0002J\b\u0010P\u001a\u00020\rH\u0002J\u0011\u0010T\u001a\u0004\u0018\u00010QH\u0000¢\u0006\u0004\bR\u0010SJ\b\u0010U\u001a\u00020\u0002H\u0016J\b\u0010V\u001a\u00020\u0002H\u0016J\u0010\u0010X\u001a\u00020\r2\u0006\u0010W\u001a\u00020\u0002H\u0016J\b\u0010Y\u001a\u00020\u0002H\u0016J&\u0010]\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\u00022\u0014\u0010\\\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)\u0018\u00010[H\u0016J\u0010\u0010^\u001a\u00020\r2\u0006\u0010Z\u001a\u00020\u0002H\u0016J\b\u0010_\u001a\u00020\rH\u0014J\u0010\u0010a\u001a\u00020\r2\u0006\u0010`\u001a\u00020\u0004H\u0016J\b\u0010b\u001a\u00020\rH\u0016J\b\u0010c\u001a\u00020\rH\u0016J\b\u0010d\u001a\u00020\u0004H\u0016J\u001e\u0010e\u001a\u00020\r2\u0014\u0010\\\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)\u0018\u00010[H\u0016J \u0010g\u001a\u00020\r2\u0016\u0010f\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u00010[H\u0016J\b\u0010h\u001a\u00020\rH\u0016J\b\u0010i\u001a\u00020\rH\u0016J\b\u0010j\u001a\u00020\rH\u0016J\u0012\u0010l\u001a\u00020\r2\b\u0010k\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010m\u001a\u00020\rH\u0017J\b\u0010n\u001a\u00020\rH\u0016J\u0010\u0010p\u001a\u00020o2\u0006\u0010Z\u001a\u00020\u0002H\u0016J\n\u0010q\u001a\u0004\u0018\u00010oH\u0016J\n\u0010r\u001a\u0004\u0018\u00010oH\u0016J\n\u0010s\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010u\u001a\u00020tH\u0016J\n\u0010v\u001a\u0004\u0018\u000100H\u0016J\b\u0010w\u001a\u00020\u0010H\u0016J\u0010\u0010z\u001a\u00020\r2\u0006\u0010y\u001a\u00020xH\u0016J\b\u0010{\u001a\u00020\u0004H\u0016J\b\u0010|\u001a\u00020\u0004H\u0016J/\u0010\u0081\u0001\u001a\u00020\r\"\u0004\b\u0000\u0010}2\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00028\u00000~2\u0007\u0010\u0080\u0001\u001a\u00028\u0000H\u0016¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001e\u0010\u0084\u0001\u001a\u00020\r2\u0013\u0010\u0083\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)0[H\u0016J\f\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0016J\u001e\u0010\u0088\u0001\u001a\u00020\r2\u0013\u0010\u0087\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)0[H\u0016J\u0012\u0010\u0088\u0001\u001a\u00020\r2\u0007\u0010\u0087\u0001\u001a\u00020\u0002H\u0016J\u001a\u0010\u008a\u0001\u001a\u00020\r2\u0007\u0010\u0089\u0001\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\u001dH\u0016J\u0015\u0010\u008b\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020K0[H\u0017J\u0013\u0010\u008e\u0001\u001a\u00020\r2\b\u0010\u008d\u0001\u001a\u00030\u008c\u0001H\u0004J\t\u0010\u008f\u0001\u001a\u00020\rH\u0004J\t\u0010\u0090\u0001\u001a\u00020\rH\u0016J\u0012\u0010\u0092\u0001\u001a\u00020\r2\u0007\u0010\u0091\u0001\u001a\u00020?H\u0016J\u0007\u0010\u0093\u0001\u001a\u00020\u0004J\t\u0010\u0094\u0001\u001a\u00020\rH\u0016J\t\u0010\u0095\u0001\u001a\u00020\rH\u0016J\n\u0010\u0097\u0001\u001a\u00030\u0096\u0001H\u0016J\t\u0010\u0098\u0001\u001a\u00020\u0002H\u0016J\t\u0010\u0099\u0001\u001a\u00020\rH\u0016J\u0007\u0010\u009a\u0001\u001a\u00020\u0002J&\u0010\u009d\u0001\u001a\u00020\r2\u0007\u0010\u009b\u0001\u001a\u00020\u00042\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u0013\u0010 \u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0096\u00010\u009f\u0001H\u0016J\u0007\u0010¡\u0001\u001a\u00020\u0004J-\u0010¦\u0001\u001a\u00020\r2\u0007\u0010¢\u0001\u001a\u00020\u001d2\u0007\u0010£\u0001\u001a\u00020\u001d2\u0007\u0010¤\u0001\u001a\u00020\u001d2\u0007\u0010¥\u0001\u001a\u00020\u001dH\u0016J \u0010ª\u0001\u001a\u00020\r2\n\u0010¨\u0001\u001a\u0005\u0018\u00010§\u00012\t\u0010©\u0001\u001a\u0004\u0018\u00010\u0002H\u0016J\u0007\u0010«\u0001\u001a\u00020\u0004J\u0007\u0010¬\u0001\u001a\u00020\u001dJ\u0007\u0010\u00ad\u0001\u001a\u00020\u0004J\u0007\u0010®\u0001\u001a\u00020\u001dJ\t\u0010¯\u0001\u001a\u00020\u001dH\u0007R\u001d\u0010±\u0001\u001a\u00030°\u00018\u0006¢\u0006\u0010\n\u0006\b±\u0001\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001R\u0018\u0010¶\u0001\u001a\u00030µ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u0018\u0010¸\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R#\u0010\u0083\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)0(8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010º\u0001R\u0018\u0010¼\u0001\u001a\u00030»\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R \u0010¾\u0001\u001a\u00030\u0096\u00018\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\b¾\u0001\u0010¿\u0001\u001a\u0006\bÀ\u0001\u0010Á\u0001R\u0019\u0010Â\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R\u0019\u0010Ä\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010Ã\u0001R\u0019\u0010Å\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u001b\u0010Ç\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u001b\u0010É\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010È\u0001R\u0018\u0010Ë\u0001\u001a\u00030Ê\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bË\u0001\u0010Ì\u0001R\u0019\u0010Í\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010Î\u0001R+\u0010Ï\u0001\u001a\u0004\u0018\u0001008\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÏ\u0001\u0010Ð\u0001\u001a\u0006\bÑ\u0001\u0010Ò\u0001\"\u0006\bÓ\u0001\u0010Ô\u0001R)\u0010Õ\u0001\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bÕ\u0001\u0010Ö\u0001\u001a\u0006\b×\u0001\u0010Ø\u0001\"\u0006\bÙ\u0001\u0010Ú\u0001R\u001c\u0010Ü\u0001\u001a\u0005\u0018\u00010Û\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÜ\u0001\u0010Ý\u0001R\u001c\u0010ß\u0001\u001a\u0005\u0018\u00010Þ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bß\u0001\u0010à\u0001R\u0018\u0010â\u0001\u001a\u00030á\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u0018\u0010å\u0001\u001a\u00030ä\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001R\u0019\u0010ç\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bç\u0001\u0010Î\u0001R\u001a\u0010é\u0001\u001a\u00030è\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bé\u0001\u0010ê\u0001R\u001a\u0010\u008d\u0001\u001a\u00030\u008c\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008d\u0001\u0010ë\u0001R*\u0010í\u0001\u001a\u00030ì\u00018\u0004@\u0004X\u0084.¢\u0006\u0018\n\u0006\bí\u0001\u0010î\u0001\u001a\u0006\bï\u0001\u0010ð\u0001\"\u0006\bñ\u0001\u0010ò\u0001R+\u0010ó\u0001\u001a\u0004\u0018\u0001008\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0006\bó\u0001\u0010Ð\u0001\u001a\u0006\bô\u0001\u0010Ò\u0001\"\u0006\bõ\u0001\u0010Ô\u0001R\u001c\u0010÷\u0001\u001a\u0005\u0018\u00010ö\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b÷\u0001\u0010ø\u0001R\u0019\u0010ù\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bù\u0001\u0010Î\u0001R\u0017\u0010=\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b=\u0010ú\u0001R\u0017\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b'\u0010Ã\u0001R\u001b\u0010û\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bû\u0001\u0010È\u0001R\u001b\u0010ü\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bü\u0001\u0010È\u0001R%\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020)\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b*\u0010º\u0001R!\u00101\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bý\u0001\u0010þ\u0001\u001a\u0006\bÿ\u0001\u0010Ò\u0001R#\u0010\u0084\u0002\u001a\u0005\u0018\u00010\u0080\u00028FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b\u0081\u0002\u0010þ\u0001\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002R\u0019\u0010\u0085\u0002\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0002\u0010Î\u0001R\u0019\u0010\u0086\u0002\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0002\u0010Î\u0001R\u0019\u0010\u0087\u0002\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0002\u0010Î\u0001R\u001c\u0010\u0089\u0002\u001a\u0005\u0018\u00010\u0088\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0002\u0010\u008a\u0002R\u0019\u0010\u008b\u0002\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0002\u0010Î\u0001R\u001b\u0010\u008c\u0002\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0002\u0010Ð\u0001R\u0019\u0010\u008d\u0002\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0002\u0010Î\u0001R\u001b\u0010\u008e\u0002\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0002\u0010Ð\u0001R\u001b\u0010\u008f\u0002\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0002\u0010Ð\u0001R\u001b\u0010\u0090\u0002\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0002\u0010Ð\u0001R \u0010\u0092\u0002\u001a\t\u0012\u0004\u0012\u00020\u001d0\u0091\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0002\u0010\u0093\u0002R)\u0010\u0094\u0002\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0094\u0002\u0010Î\u0001\u001a\u0006\b\u0095\u0002\u0010\u0096\u0002\"\u0006\b\u0097\u0002\u0010\u0098\u0002R\u0017\u0010d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bd\u0010Î\u0001R\u001b\u0010\u0099\u0002\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0002\u0010Ã\u0001R\u0018\u0010\u009b\u0002\u001a\u00030\u009a\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0002\u0010\u009c\u0002R\u001b\u0010\u009d\u0002\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0002\u0010\u009e\u0002R\u0019\u0010\u009f\u0002\u001a\u00020K8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0002\u0010 \u0002R@\u0010¤\u0002\u001a+\u0012\r\u0012\u000b ¢\u0002*\u0004\u0018\u00010x0x ¢\u0002*\u0014\u0012\r\u0012\u000b ¢\u0002*\u0004\u0018\u00010x0x\u0018\u00010£\u00020¡\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0002\u0010¥\u0002R\u0017\u0010¦\u0002\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¦\u0002\u0010§\u0002R,\u0010©\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0¨\u00028\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b©\u0002\u0010ª\u0002\u001a\u0006\b«\u0002\u0010¬\u0002R\u0019\u0010\u00ad\u0002\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0002\u0010ú\u0001R\u0019\u0010®\u0002\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0002\u0010Î\u0001R!\u0010³\u0002\u001a\u00030¯\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b°\u0002\u0010þ\u0001\u001a\u0006\b±\u0002\u0010²\u0002R\u0018\u0010µ\u0002\u001a\u0004\u0018\u00010Q8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b´\u0002\u0010S¨\u0006º\u0002"}, d2 = {"Lcom/bytedance/android/anniex/container/AnnieXContainer;", "Lia/b;", "", "schemaUri", "", "canCreateNormalBulletContext", "sessionId", "Lcom/bytedance/ies/bullet/core/BulletContext;", "initOrGetBulletContext", "Landroid/net/Uri;", "uri", "Lcom/bytedance/ies/bullet/service/base/o;", "kitView", "", "bindKitView", "kitViewCreateOpt", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getKitTypeWithSchema", "getSessionIdWithBundle", "getSchemaWithBundle", "createModel", "sendPendingEvent", "showNotice", "hideNotice", "showDeny", "hideDeny", "supportScreenProps", "observerKitViewLayoutChanged", "observerRootViewLayoutChanged", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onRootViewLayoutChanged", "foldStatus", "", "", "screenProps", "onFoldStatusChanged", "isBreakPointChange", "softHeight", "possiblyResizeChildOfContent4Web", "needAdapterKeyboard4Web", "Landroid/view/View;", "decorView", "getContentView", "isShowing", "height", "sendKeyboardStatusChangeEvent", "state", "putState", "changeState", "transferToTargetState", "initContainerColor", "setContainerColor", "setBackgroundColor", "orientation", "onOrientationChanged", "Landroid/content/res/Configuration;", "configuration", "isKitViewCreate", "padAdaptation", "sendWindowSizeEvent", "updateLynxScreenMetrics", "addKitView", "Lg16/b;", "debugInfo", "showContainerTag", "addTagView", "closeCurrentPageWhenAfterPageOpen", "", "getOpenTime", "bindWebOnScrollChangeListener", "Landroid/app/Activity;", "getActivity", "setSecureInfo", "Lv36/a;", "getAnnieXContainerModel$anniex_release", "()Lv36/a;", "getAnnieXContainerModel", "getBid", "getContainerId", "containerId", "bindContainerId", "getCurrentUrl", com.bytedance.android.ec.core.event.a.KEY_SCHEMA, "", "renderData", "loadSchema", "preloadSchema", "parseSchema", "enable", "interceptBackPress", "enterForeground", "enterBackground", "isVisibility", "reload", "templateData", "reloadTemplate", "goBack", "showError", "hideError", "text", "showLoading", "hideLoading", com.bytedance.android.ec.core.event.a.VALUE_CLOSE, "Lt36/d;", "generateSchemaData", "getSchemaData", "getCurrentSchema", "getBDXTag", "Lcom/bytedance/ies/bullet/service/sdk/param/LaunchMode;", "getBDXLaunchMode", "getKitView", "getKitType", "Lcom/bytedance/ies/bullet/core/kit/bridge/h;", "event", "sendEvent", "canBackPress", "canGoBack", "T", "Ljava/lang/Class;", "clazz", "item", "registerWeakHolder", "(Ljava/lang/Class;Ljava/lang/Object;)V", "globalProps", "updateGlobalProps", "Lm16/b;", "getContextProviderFactory", "data", "updateData", "width", "updateScreenMetrics", "getPerfMap", "Lia/j;", "uiComponent", "setUiComponent", "initUi", "observerKeyboardStatusChange", "newConfig", "onConfigurationChanged", "isPadOrFold", "onAttachToWindow", "postFirstVisibleEvent", "Landroid/content/Context;", "getSystemContext", "getViewType", "release", "getUrl", "visible", "hasReadySendVisibleEvent", "onVisibleChange", "(ZLjava/lang/Boolean;)V", "Ljava/lang/ref/WeakReference;", "getWeakContext", "isKitViewScrollReachTop", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "onWebScrollChanged", "Landroid/webkit/WebView;", "view", com.bytedance.android.ec.core.event.a.KEY_URL, "onWebPageFinish", "hasStatusBar", "getStatusBarHeight", "hasSystemNavBar", "getNavigationBarHeight", "getRealNavigationBarHeight", "Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;", "builder", "Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;", "getBuilder", "()Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;", "Landroid/os/Bundle;", "bundle", "Landroid/os/Bundle;", "contextProviderFactory", "Lm16/b;", "Ljava/util/Map;", "Lcom/bytedance/android/anniex/container/b;", "lifecycleDispatcher", "Lcom/bytedance/android/anniex/container/b;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "currentBid", "Ljava/lang/String;", "currentSchema", "currentUri", "Landroid/net/Uri;", "padAdapterWidth", "Ljava/lang/Integer;", "padAdapterHeight", "Lq26/a;", "serviceContext", "Lq26/a;", "isWebViewScrollReachTop", "Z", "lynxWithScrollView", "Landroid/view/View;", "getLynxWithScrollView$anniex_release", "()Landroid/view/View;", "setLynxWithScrollView$anniex_release", "(Landroid/view/View;)V", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "getBulletContext", "()Lcom/bytedance/ies/bullet/core/BulletContext;", "setBulletContext", "(Lcom/bytedance/ies/bullet/core/BulletContext;)V", "Lcom/bytedance/android/anniex/base/lifecycle/AnnieXLynxViewClientProxy;", "annieXLynxViewClientProxy", "Lcom/bytedance/android/anniex/base/lifecycle/AnnieXLynxViewClientProxy;", "Lcom/bytedance/android/anniex/base/lifecycle/b;", "annieXWebViewClientProxy", "Lcom/bytedance/android/anniex/base/lifecycle/b;", "com/bytedance/android/anniex/container/AnnieXContainer$e", "containerInstance", "Lcom/bytedance/android/anniex/container/AnnieXContainer$e;", "com/bytedance/android/anniex/container/AnnieXContainer$f", "deprecatedBulletContainer", "Lcom/bytedance/android/anniex/container/AnnieXContainer$f;", "kitViewHasBinded", "com/bytedance/android/anniex/container/AnnieXContainer$c", "bulletLifecycle", "Lcom/bytedance/android/anniex/container/AnnieXContainer$c;", "Lia/j;", "Landroid/view/ViewGroup;", "parentViewGroup", "Landroid/view/ViewGroup;", "getParentViewGroup", "()Landroid/view/ViewGroup;", "setParentViewGroup", "(Landroid/view/ViewGroup;)V", "rootView", "getRootView", "setRootView", "Landroid/view/View$OnLayoutChangeListener;", "rootViewLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "isRootViewFirstLayout", "I", "curHorizontalBreakPoint", "curVerticalBreakPoint", "decorView$delegate", "Lkotlin/Lazy;", "getDecorView", "Landroidx/core/view/WindowInsetsCompat;", "windowInsetsCompat$delegate", "getWindowInsetsCompat", "()Landroidx/core/view/WindowInsetsCompat;", "windowInsetsCompat", "isResuming", "isRuntimeReady", "loadSuccess", "Landroid/graphics/drawable/Drawable;", "originBackground", "Landroid/graphics/drawable/Drawable;", "useCustomBackground", "errorView", "errorViewAdded", "loadingView", "noticeView", "denyView", "Ljava/util/concurrent/ArrayBlockingQueue;", "stateBlockingQueue", "Ljava/util/concurrent/ArrayBlockingQueue;", "containerVisible", "getContainerVisible", "()Z", "setContainerVisible", "(Z)V", "__containerId", "Lcom/bytedance/ies/bullet/ui/common/loader/BulletContainerLoader;", "containerLoader", "Lcom/bytedance/ies/bullet/ui/common/loader/BulletContainerLoader;", "bulletKitView", "Lcom/bytedance/ies/bullet/service/base/o;", "createViewTime", "J", "", "kotlin.jvm.PlatformType", "", "pendingEvent", "Ljava/util/List;", "synchronizedObj", "Ljava/lang/Object;", "Lkotlin/Function1;", "onSoftInputChangeListener", "Lkotlin/jvm/functions/Function1;", "getOnSoftInputChangeListener$anniex_release", "()Lkotlin/jvm/functions/Function1;", "usableHeightPrevious", "isNotRelease", "Landroid/os/Handler;", "mainHandler$delegate", "getMainHandler", "()Landroid/os/Handler;", "mainHandler", "getContainerModel", "containerModel", "<init>", "(Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;)V", "Companion", "a", "anniex_release"}, k = 1, mv = {1, 4, 3})
public abstract class AnnieXContainer extends ia.b {
    public static final a Companion = null;
    private static final String DEFAULT_UNKNOWN = "unknown";
    private static final int LOAD_RUNTIME_READY = 4;
    private static final int LOAD_STATUS_CREATE_KIT_VIEW = 2;
    private static final int LOAD_STATUS_FINISH = 3;
    private static final int LOAD_STATUS_INIT_UI = 0;
    private static final int LOAD_STATUS_PARSE_SCHEMA = 1;
    private static final int LOAD_STATUS_UNKNOWN = -1;
    private static final String TAG = "AnnieXContainer";
    private static final String VISIBLE_CHANGE_TYPE_APP = "app";
    private static final String VISIBLE_CHANGE_TYPE_PAGE = "page";
    private String __containerId;
    private AnnieXLynxViewClientProxy annieXLynxViewClientProxy;
    private com.bytedance.android.anniex.base.lifecycle.b annieXWebViewClientProxy;
    private final UIComponentBuilder builder;
    private BulletContext bulletContext;
    private com.bytedance.ies.bullet.service.base.o bulletKitView;
    private c bulletLifecycle;
    private final Bundle bundle;
    private final e containerInstance;
    private final BulletContainerLoader containerLoader;
    private volatile boolean containerVisible;
    private final Context context;
    private final m16.b contextProviderFactory;
    private long createViewTime;
    private Integer curHorizontalBreakPoint;
    private Integer curVerticalBreakPoint;
    private String currentBid;
    private String currentSchema;
    private Uri currentUri;
    private final Lazy decorView$delegate;
    private View denyView;
    private final f deprecatedBulletContainer;
    private View errorView;
    private boolean errorViewAdded;
    private String foldStatus;
    private final Map<String, Object> globalProps;
    private boolean isNotRelease;
    private boolean isResuming;
    private boolean isRootViewFirstLayout;
    private boolean isRuntimeReady;
    private volatile boolean isVisibility;
    private boolean isWebViewScrollReachTop;
    private boolean kitViewHasBinded;
    private final com.bytedance.android.anniex.container.b lifecycleDispatcher;
    private boolean loadSuccess;
    private View loadingView;
    private View lynxWithScrollView;
    private final Lazy mainHandler$delegate;
    private View noticeView;
    private final Function1<Boolean, Unit> onSoftInputChangeListener;
    private int orientation;
    private Drawable originBackground;
    private Integer padAdapterHeight;
    private Integer padAdapterWidth;
    protected ViewGroup parentViewGroup;
    private final List<com.bytedance.ies.bullet.core.kit.bridge.h> pendingEvent;
    private View rootView;
    private View.OnLayoutChangeListener rootViewLayoutListener;
    private Map<String, ? extends Object> screenProps;
    private final q26.a serviceContext;
    private ArrayBlockingQueue<Integer> stateBlockingQueue;
    private final Object synchronizedObj;
    private ia.j uiComponent;
    private int usableHeightPrevious;
    private boolean useCustomBackground;
    private final Lazy windowInsetsCompat$delegate;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements SSWebView.e {
        public final /* synthetic */ AnnieXContainer a;

        public b(AnnieXContainer r1) {
            this.a = r1;
        }

        public final void onScrollChanged(int r10, int r11, int r12, int r13) {
            AnnieXContainer r0 = this.a;
            boolean r1 = false;
            if (r12 <= r11) goto L5;
        L7:
            AnnieXContainer.access$setWebViewScrollReachTop$p(r0, r1);
            this.a.onWebScrollChanged(r10, r11, r12, r13);
            return;
        L5:
            if (r11 >= 1) goto L7;
            r1 = true;
            goto L7
        }
    }

    public static final class c extends q.a {
        public final /* synthetic */ AnnieXContainer a;

        public c(AnnieXContainer r1) {
            this.a = r1;
        }

        public final void HP(Uri r10, com.bytedance.ies.bullet.service.base.o r11) {
            Intrinsics.checkNotNullParameter(r10, "uri");
            HybridLogger r12 = HybridLogger.a;
            HybridLogger.m(AnnieXContainer.TAG, "===onRuntimeReady:  " + this.a.getUrl(), null, null, 12);
            AnnieXContainer.access$putState(this.a, 4);
            AnnieXContainer.access$getLifecycleDispatcher$p(this.a).k(AnnieXContainer.access$getCurrentSchema$p(this.a), this.a);
        }

        public final void TH(Uri r10, Throwable r11) {
            Intrinsics.checkNotNullParameter(r10, "uri");
            Intrinsics.checkNotNullParameter(r11, "e");
            super.TH(r10, r11);
            AnnieXContainer.access$getLifecycleDispatcher$p(this.a).c(AnnieXContainer.access$getCurrentSchema$p(this.a), this.a, r11);
            this.a.getBulletContext().c.b().TH(r10, r11);
        }

        public final void gQ(Uri r10, com.bytedance.ies.bullet.service.base.o r11) {
            Intrinsics.checkNotNullParameter(r10, "uri");
            AnnieXContainer.access$bindKitView(this.a, r10, r11);
            AnnieXContainer.access$observerKitViewLayoutChanged(this.a);
        }

        public final void go(Uri r10, com.bytedance.ies.bullet.service.base.o r11) {
            Intrinsics.checkNotNullParameter(r10, "uri");
            HybridLogger r0 = HybridLogger.a;
            HybridLogger.m(AnnieXContainer.TAG, "onLoadUriSuccess: " + this.a.getUrl(), null, null, 12);
            AnnieXContainer.access$sendWindowSizeEvent(this.a);
            AnnieXContainer.access$setLoadSuccess$p(this.a, true);
            AnnieXContainer.access$putState(this.a, 3);
            AnnieXContainer.access$getLifecycleDispatcher$p(this.a).i(AnnieXContainer.access$getCurrentSchema$p(this.a), this.a);
            this.a.getBulletContext().c.b().go(r10, r11);
        }

        public final void onLoadFail(Uri r10, Throwable r11) {
            Intrinsics.checkNotNullParameter(r10, "uri");
            Intrinsics.checkNotNullParameter(r11, "e");
            HybridLogger r0 = HybridLogger.a;
            HybridLogger.m(AnnieXContainer.TAG, "onLoadFail: schema===> " + this.a.getUrl() + " error===> " + r11.getMessage() + "  } ", null, null, 12);
            AnnieXContainer.access$setLoadSuccess$p(this.a, false);
            AnnieXContainer.access$putState(this.a, 3);
            AnnieXContainer.access$getLifecycleDispatcher$p(this.a).g(AnnieXContainer.access$getCurrentSchema$p(this.a), this.a, r11);
            this.a.getBulletContext().c.b().onLoadFail(r10, r11);
        }

        public final void LG(Uri r10, com.bytedance.ies.bullet.service.base.o r11, Throwable r12) {
            Intrinsics.checkNotNullParameter(r10, "uri");
            HybridLogger r0 = HybridLogger.a;
            Pair[] r1 = new Pair[2];
            r1[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, r10.toString());
            if (r12 == null) goto L5;
            String r13 = r12.getMessage();
        L6:
            r1[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MSG, r13);
            HybridLogger.k(AnnieXContainer.TAG, "kit_view_destroy", MapsKt.mapOf(r1), this.a.getBulletContext().a());
            AnnieXContainer.access$getLifecycleDispatcher$p(this.a).f(AnnieXContainer.access$getCurrentSchema$p(this.a), this.a);
            this.a.getBulletContext().c.b().getClass();
            Intrinsics.checkNotNullParameter(r10, "uri");
            return;
        L5:
            r13 = null;
            goto L6
        }

        public final void bK(Uri r10, com.bytedance.ies.bullet.service.base.o r11, t36.j r12) {
            Intrinsics.checkNotNullParameter(r10, "uri");
            Intrinsics.checkNotNullParameter(r12, "schemaModelUnion");
            this.a.getBulletContext().c.b().bK(r10, r11, r12);
        }
    }

    public static final class d implements com.bytedance.ies.bullet.core.kit.bridge.h {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;

        public final Object getParams() {
            JSONObject r0 = new JSONObject();
            if (this.b == false) goto L5;
            r0.put("type", "systemBack");
        L5:
            return r0;
        }

        public final String getName() {
            return this.a;
        }

        public d(String r1, boolean r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public static final class e implements ue7.c {
        public final /* synthetic */ AnnieXContainer a;

        public static final class a implements com.bytedance.ies.bullet.core.kit.bridge.h {
            public final String a;
            public final Object b;

            public final String getName() {
                return this.a;
            }

            public final Object getParams() {
                return this.b;
            }

            public a(String r1, Object r10) {
                this.a = r1;
                this.b = r10;
            }
        }

        public final Uri a() {
            return AnnieXContainer.access$getCurrentUri$p(this.a);
        }

        public final String b() {
            return AnnieXContainer.access$getCurrentBid$p(this.a);
        }

        public final Context context() {
            return this.a.getContext();
        }

        public final View i() {
            com.bytedance.ies.bullet.service.base.o r0 = AnnieXContainer.access$getBulletKitView$p(this.a);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.realView();
        }

        public e(AnnieXContainer r1) {
            this.a = r1;
        }

        public final void sendEvent(String r10, Object r11) {
            Intrinsics.checkNotNullParameter(r10, "eventName");
            this.a.sendEvent(new a(r10, r11));
        }
    }

    public static final class f extends h16.e.a {
        public final /* synthetic */ AnnieXContainer a;

        public final BulletContext getBulletContext() {
            return this.a.getBulletContext();
        }

        public final Uri getCurrentUri() {
            return AnnieXContainer.access$getCurrentUri$p(this.a);
        }

        public final com.bytedance.ies.bullet.service.base.o getKitView() {
            return AnnieXContainer.access$getBulletKitView$p(this.a);
        }

        public final Uri getProcessingUri() {
            return AnnieXContainer.access$getCurrentUri$p(this.a);
        }

        public final String getSessionId() {
            return this.a.getContainerId();
        }

        public f(AnnieXContainer r1) {
            this.a = r1;
            AnnieXContainer.access$getContextProviderFactory$p(r1);
        }

        public void onEvent(com.bytedance.ies.bullet.core.kit.bridge.h r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            this.a.sendEvent(r10);
        }
    }

    public static final class g implements View.OnLayoutChangeListener {
        public final /* synthetic */ Ref.IntRef a;
        public final /* synthetic */ Ref.IntRef b;
        public final /* synthetic */ AnnieXContainer c;

        public g(Ref.IntRef r1, Ref.IntRef r10, AnnieXContainer r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
            int r1 = r14 - r12;
            if (r1 <= 0) goto L14;
            int r10 = r15 - r13;
            if (r10 <= 0) goto L15;
            Ref.IntRef r20 = this.a;
            if (r20.element == r1) goto L10;
        L12:
            r20.element = r1;
            this.b.element = r10;
            AnnieXContainer.access$onRootViewLayoutChanged(this.c, r12, r13, r14, r15, r16, r17, r18, r19);
            return;
        L10:
            if (this.b.element != r10) goto L12;
            return;
        L15:
            return;
        }
    }

    public static final class h implements com.bytedance.ies.bullet.core.kit.bridge.h {
        public final Object a;

        public final String getName() {
            return "screenFoldStateChange";
        }

        public final Object getParams() {
            return this.a;
        }

        public h(Map<?, ?> r10) {
            this.a = new JSONObject(r10);
        }
    }

    public static final class i implements com.bytedance.ies.bullet.core.kit.bridge.h {
        public final Object a;

        public final String getName() {
            return "screenOrientationChange";
        }

        public final Object getParams() {
            return this.a;
        }

        public i(Map<?, ?> r10) {
            this.a = new JSONObject(r10);
        }
    }

    public static final class j implements com.bytedance.ies.bullet.core.kit.bridge.h {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ AnnieXContainer b;

        public final String getName() {
            return "pageVisibilityChange";
        }

        public final Object getParams() {
            JSONObject r0 = new JSONObject();
            boolean r1 = this.a;
            AnnieXContainer r10 = this.b;
            r0.put("visible", r1);
            if (Intrinsics.areEqual(r10.getViewType(), "card") == true) goto L12;
            ia.j r11 = AnnieXContainer.access$getUiComponent$p(r10);
            if (r11 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
            r11 = null;
        L8:
            if (r11.e() == false) goto L10;
            String r12 = AnnieXContainer.VISIBLE_CHANGE_TYPE_APP;
        L11:
            r0.put("source", r12);
            goto L12
        L10:
            r12 = "page";
        L12:
            return r0;
        }

        public j(boolean r1, AnnieXContainer r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public static final class k implements com.bytedance.ies.bullet.core.kit.bridge.h {
        public k() {
        }

        public final String getName() {
            return "viewAppeared";
        }

        public final Object getParams() {
            return new JSONObject();
        }
    }

    public static final class l implements com.bytedance.ies.bullet.core.kit.bridge.h {
        public l() {
        }

        public final String getName() {
            return "viewDisappeared";
        }

        public final Object getParams() {
            return new JSONObject();
        }
    }

    public static final class m implements Runnable {
        public final /* synthetic */ AnnieXContainer a;
        public final /* synthetic */ int b;

        public m(AnnieXContainer r1, int r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnnieXContainer.access$changeState(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class n implements Runnable {
        public final /* synthetic */ AnnieXContainer a;

        public n(AnnieXContainer r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getBulletContext().release();     // Catch: Throwable -> L4
            AnnieXContainer.access$getContextProviderFactory$p(this.a).h();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class o implements com.bytedance.ies.bullet.core.kit.bridge.h {
        public final JSONObject a;

        public final String getName() {
            return "H5_keyboardStatusChange";
        }

        public final Object getParams() {
            return this.a;
        }

        public o(JSONObject r1) {
            this.a = r1;
        }
    }

    public static final class p implements com.bytedance.ies.bullet.core.kit.bridge.h {
        public final JSONObject a;

        public final String getName() {
            return "keyboardStatusChange";
        }

        public final Object getParams() {
            return this.a;
        }

        public p(JSONObject r1) {
            this.a = r1;
        }
    }

    static {
        Companion = new a();
    }

    @Override // ia.b, ia.c
    public void enterForeground() {
        this.isResuming = true;
        if (this.isRuntimeReady == false) goto L7;
        com.bytedance.ies.bullet.service.base.o r1 = this.bulletKitView;
        if (r1 == null) goto L7;
        r1.onShow();
    L7:
        this.bulletContext.c.b().yO(UriProtector.parse(this.currentSchema), this.bulletKitView);
        this.isVisibility = true;
        HybridLogger r0 = HybridLogger.a;
        HybridLogger.m(TAG, "===enterForeground: " + getUrl(), null, null, 12);
    }

    @Override // ia.b, ia.c
    public String getViewType() {
        return "card";
    }

    @Override // ia.b
    public void observerKeyboardStatusChange() {
        HybridLogger.m(TAG, "===observerKeyboardStatusChange====", null, null, 12);
    }

    public void onWebPageFinish(WebView r1, String r10) {
    }

    public void onWebScrollChanged(int r1, int r10, int r11, int r12) {
    }

    public void postFirstVisibleEvent() {
    }

    private final void addKitView() {
        HybridLogger r0 = HybridLogger.a;
        HybridLogger.m(TAG, "===addKitView: " + getUrl(), null, null, 12);
        com.bytedance.ies.bullet.service.base.o r1 = this.bulletKitView;
        if (r1 == null) goto L7;
        View r10 = r1.realView();
        if (r10 == null) goto L7;
        getParentViewGroup().addView(r10);
        this.lifecycleDispatcher.a(this.currentSchema, this);
    L7:
        sendPendingEvent();
    }

    private final void addTagView() {
        HybridLogger r0 = HybridLogger.a;
        String r10 = null;
        HybridLogger.m(TAG, "===addTagView: " + getUrl(), null, null, 12);
        ConcurrentHashMap r1 = g16.a.a;
        g16.b r11 = g16.a.a(this.currentBid);
        if (showContainerTag(r11) == true) goto L6;
        r11 = null;
    L6:
        if (r11 == null) goto L52;
        boolean r12 = false;
        DebugTagTextView r13 = LayoutInflater.from(this.context).inflate(2131559209, getParentViewGroup(), false);
        if ((r13 instanceof DebugTagTextView) == false) goto L10;
        DebugTagTextView r14 = r13;
    L11:
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(-2, -2);
        r15.gravity = 8388661;
        getParentViewGroup().addView(r14, r15);
        if (r14 == null) goto L53;
        String r16 = getViewType();
        String r17 = r11.b;
        if (r17 != null) goto L16;
    L19:
        boolean r18 = true;
    L20:
        String r19 = "";
        if (r18 == false) goto L23;
        String r20 = "";
    L24:
        CacheType r21 = this.bulletContext.w.e;
        if (r21 == null) goto L31;
        int r22 = b0.a[r21.ordinal()];
        if (r22 != 1) goto L30;
        String r23 = "(ReUse)";
    L34:
        StringBuilder r110 = new StringBuilder("debug tag: ");
        r110.append(r16);
        r110.append('_');
        r110.append(r20);
        com.bytedance.ies.bullet.service.base.o r24 = this.bulletKitView;
        if (r24 == null) goto L37;
        String r25 = r24.getViewTag();
    L38:
        r110.append(r25);
        r110.append(r23);
        HybridLogger.m(TAG, r110.toString(), null, null, 12);
        BulletContext r26 = this.bulletContext;
        if (r26 != null) goto L41;
    L43:
        if (r12 == false) goto L45;
        r19 = "_flow";
    L45:
        StringBuilder r27 = new StringBuilder("x-");
        com.bytedance.ies.bullet.service.base.o r28 = this.bulletKitView;
        if (r28 == null) goto L50;
        KitType r29 = r28.getKitType();
        if (r29 == null) goto L50;
        r10 = r29.getTag();
    L50:
        r27.append(r10);
        r27.append('-');
        r27.append(r16);
        r27.append('(');
        r27.append(this.currentBid);
        r27.append(')');
        r27.append(r19);
        r14.setText(r27.toString());
        com.bytedance.ies.bullet.core.h.h.getClass();
        return;
    L41:
        if (r26.G != true) goto L43;
        r12 = true;
        goto L43
    L37:
        r25 = null;
        goto L38
    L30:
        if (r22 != 2) goto L31;
        r23 = "(PreRender)";
    L31:
        r23 = "";
        goto L34
    L23:
        r20 = r11.b + " - ";
        goto L24
    L16:
        if (r17.length() == 0) goto L19;
        r18 = false;
        goto L20
    L53:
        return;
    L10:
        r14 = null;
        goto L11
    }

    private final void closeCurrentPageWhenAfterPageOpen() {
        if ((this instanceof com.bytedance.android.anniex.container.c) == false) goto L5;
    L6:
        v36.a r0 = getContainerModel();
        if (r0 == null) goto L30;
        y36.i r1 = r0.y;
        y36.i r10 = null;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("openContainerID");
        r1 = null;
    L12:
        if (r1 == null) goto L31;
        String r11 = (String) r1.b;
        if (r11 == null) goto L32;
        v36.a r12 = getContainerModel();
        if (r12 == null) goto L23;
        y36.i r13 = r12.x;
        if (r13 == null) goto L20;
        r10 = r13;
    L21:
        if (r10 == null) goto L23;
        boolean r14 = Intrinsics.areEqual(r10.b, Boolean.TRUE);
    L24:
        if (r14 == true) goto L26;
        return;
    L26:
        if (Intrinsics.areEqual(r11, "") == true) goto L34;
        com.bytedance.android.anniex.assemble.a r15 = com.bytedance.android.anniex.assemble.a.a;
        com.bytedance.android.anniex.assemble.a.a(r11);
        return;
    L34:
        return;
    L20:
        Intrinsics.throwUninitializedPropertyAccessException("closeAfterOpenSuccess");
    L23:
        r14 = false;
        goto L24
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L5:
        if ((this instanceof com.bytedance.android.anniex.container.d) == true) goto L6;
    }

    private final Activity getActivity() {
        Context r0 = this.context;
        if ((r0 instanceof Activity) == false) goto L7;
        return (Activity) r0;
    L7:
        if ((r0 instanceof ContextThemeWrapper) == true) goto L9;
        return null;
    L9:
        if ((((ContextThemeWrapper) r0).getBaseContext() instanceof Activity) == false) goto L14;
        Context r1 = ((ContextThemeWrapper) this.context).getBaseContext();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.Activity");
        return (Activity) r1;
    L14:
        return null;
    }

    private final v36.a getContainerModel() {
        v36.a r0 = this.bulletContext.g.b;
        if ((r0 instanceof v36.a) == true) goto L7;
        return null;
    L7:
        return r0;
    }

    private final View getDecorView() {
        return (View) this.decorView$delegate.getValue();
    }

    private final Handler getMainHandler() {
        return (Handler) this.mainHandler$delegate.getValue();
    }

    private final String getSchemaWithBundle() {
        String r0 = this.bundle.getString("annie_x_inner_bundle_schema");
        if (r0 != null) goto L6;
        return DEFAULT_UNKNOWN;
    L6:
        return r0;
    }

    private final String getSessionIdWithBundle() {
        String r0 = this.bundle.getString("__x_session_id");
        if (r0 != null) goto L6;
        return DEFAULT_UNKNOWN;
    L6:
        return r0;
    }

    private final void hideDeny() {
        View r0 = this.denyView;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        getParentViewGroup().removeView(r0);
        return;
    }

    private final void hideNotice() {
        View r0 = this.noticeView;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        getParentViewGroup().removeView(r0);
        return;
    }

    private final boolean needAdapterKeyboard4Web() {
        com.bytedance.ies.bullet.service.base.o r0 = this.bulletKitView;
        y36.i r1 = null;
        if (r0 == null) goto L5;
        View r10 = r0.realView();
    L7:
        if ((r10 instanceof LynxView) == false) goto L9;
        return false;
    L9:
        v36.a r11 = getContainerModel();
        if (r11 == null) goto L19;
        y36.i r12 = r11.z;
        if (r12 == null) goto L14;
        r1 = r12;
    L15:
        if (r1 == null) goto L19;
        Integer r13 = (Integer) r1.b;
        if (r13 == null) goto L19;
        int r14 = r13.intValue();
    L20:
        if (r14 <= (-1)) goto L23;
        return false;
    L23:
        if ((this instanceof com.bytedance.android.anniex.container.c) == false) goto L43;
        v36.a r15 = getContainerModel();
        if (r15 == null) goto L29;
        y36.a r16 = r15.h();
        if (r16 == null) goto L29;
        boolean r17 = Intrinsics.areEqual(((y36.i) r16).b, Boolean.TRUE);
    L30:
        if (r17 == true) goto L39;
        v36.a r18 = getContainerModel();
        if (r18 == null) goto L36;
        y36.a r19 = r18.j();
        if (r19 == null) goto L36;
        boolean r20 = Intrinsics.areEqual(((y36.i) r19).b, Boolean.TRUE);
    L37:
        if (r20 == true) goto L39;
        return false;
    L36:
        r20 = false;
    L39:
        if (r14 != (-2)) goto L48;
        return true;
    L48:
        return false;
    L29:
        r17 = false;
        goto L30
    L43:
        if ((this instanceof com.bytedance.android.anniex.container.d) == false) goto L49;
        if (r14 != (-1)) goto L50;
        return true;
    L50:
        return false;
    L49:
        return false;
    L14:
        Intrinsics.throwUninitializedPropertyAccessException("softInputMode");
    L19:
        r14 = -1;
        goto L20
    L5:
        r10 = null;
        goto L7
    }

    private final void sendPendingEvent() {
        Object r0 = this.synchronizedObj;
        monitor-enter(r0);
        Iterator<T> r1 = this.pendingEvent.iterator();     // Catch: Throwable -> L13
    L6:
        if (r1.hasNext() == false) goto L10;
        com.bytedance.ies.bullet.core.kit.bridge.h r10 = (com.bytedance.ies.bullet.core.kit.bridge.h) r1.next();     // Catch: Throwable -> L13
        com.bytedance.ies.bullet.service.base.o r11 = this.bulletKitView;     // Catch: Throwable -> L13
        if (r11 == null) goto L6;
        r11.sendEvent(r10.getName(), r10.getParams());     // Catch: Throwable -> L13
        goto L6
    L10:
        this.pendingEvent.clear();     // Catch: Throwable -> L13
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private final void setSecureInfo() {
        this.bulletContext.c.J("on_container_created_start");
        ArgusContainerDelegate r0 = this.bulletContext.D;
        if (r0 == null) goto L5;
        r0.b(getActivity(), com.bytedance.ies.bullet.secure.d.a(this.bulletContext, ArgusContainerCreateType.Activity));
    L5:
        this.bulletContext.c.J("on_container_created_end");
    }

    private final void showDeny() {
        if (this.denyView == null) goto L5;
    L10:
        View r0 = this.denyView;
        if (r0 == null) goto L14;
        getParentViewGroup().addView(r0);
        r0.setVisibility(0);
        return;
    L14:
        return;
    L5:
        if (this.isNotRelease == false) goto L10;
        HybridLogger.m(TAG, "create deny view", null, null, 12);
        ia.j r1 = this.uiComponent;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
        r1 = null;
    L9:
        r1.getClass();
        Intrinsics.checkNotNullParameter(this, "container");
        this.denyView = null;
        goto L10
    }

    private final void showNotice() {
        if (this.noticeView == null) goto L5;
    L10:
        View r0 = this.noticeView;
        if (r0 == null) goto L14;
        getParentViewGroup().addView(r0);
        r0.setVisibility(0);
        return;
    L14:
        return;
    L5:
        if (this.isNotRelease == false) goto L10;
        HybridLogger.m(TAG, "create notice view", null, null, 12);
        ia.j r1 = this.uiComponent;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
        r1 = null;
    L9:
        r1.getClass();
        Intrinsics.checkNotNullParameter(this, "container");
        this.noticeView = null;
        goto L10
    }

    private final boolean supportScreenProps() {
        if ((this instanceof com.bytedance.android.anniex.container.c) == false) goto L5;
    L8:
        return true;
    L5:
        if ((this instanceof com.bytedance.android.anniex.container.d) == true) goto L8;
        return false;
    }

    private final void transferToTargetState() {
    L3:
        if ((!this.stateBlockingQueue.isEmpty()) == false) goto L5;
        changeState(this.stateBlockingQueue.take().intValue());
        goto L3
    }

    private final void updateLynxScreenMetrics() {
        if (this.bulletKitView == null) goto L10;
        t36.j r0 = this.bulletContext.g;
        Integer r1 = b46.c.a;
        boolean r10 = this instanceof com.bytedance.android.anniex.container.c;
        Scenes r11 = Scenes.AbsActivity;
        b46.c.d(r0);
        Context r12 = this.bulletContext.getContext();
        if (r12 == null) goto L11;
        b46.i r13 = b46.m.a(r12);
        if (r13 == null) goto L12;
        updateScreenMetrics(r13.a, r13.b);
        HybridLogger r14 = HybridLogger.a;
        HybridLogger.m(TAG, "updateLynxScreenMetrics : enableIpadAdapter false , width " + r13.a + " , height " + r13.b, null, null, 12);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // ia.b, ia.c
    public boolean canGoBack() {
        com.bytedance.ies.bullet.service.base.o r0 = this.bulletKitView;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.onBackPressed();
    }

    @Override // ia.b, ia.c
    public void close() {
        HybridLogger r0 = HybridLogger.a;
        ia.j r10 = null;
        HybridLogger.m(TAG, "===close: " + getUrl(), null, null, 12);
        if (this.isNotRelease == false) goto L10;
        ia.j r1 = this.uiComponent;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
    L8:
        r10.a();
        return;
    L7:
        r10 = r1;
        goto L8
    }

    @Override // ia.b, ia.c
    public void enterBackground() {
        com.bytedance.ies.bullet.service.base.o r0 = this.bulletKitView;
        if (r0 == null) goto L5;
        r0.onHide();
    L5:
        r.a r1 = this.bulletContext.c.b();
        UriProtector.parse(this.currentSchema);
        r1.vH(this.bulletKitView);
        this.isVisibility = false;
        HybridLogger r10 = HybridLogger.a;
        HybridLogger.m(TAG, "===enterBackground: " + getUrl(), null, null, 12);
    }

    @Override // ia.b, ia.c
    public LaunchMode getBDXLaunchMode() {
        t36.d r0 = this.bulletContext.e;
        if (r0 == null) goto L7;
        LaunchMode r1 = (LaunchMode) ((y36.i) new y36.e(r0, null)).b;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return LaunchMode.MODE_UNSPECIFIED;
    }

    @Override // ia.b, ia.c
    public String getBDXTag() {
        t36.d r0 = this.bulletContext.e;
        if (r0 != null) goto L5;
        return null;
    L5:
        return (String) ((y36.i) new y36.p(r0, "bdx_tag", null)).b;
    }

    @Override // ia.b, ia.c
    public String getContainerId() {
        String r0 = this.__containerId;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.bulletContext.getSessionId();
    }

    @Override // ia.b, ia.c
    public t36.d getCurrentSchema() {
        return this.bulletContext.e;
    }

    @Override // ia.b, ia.c
    public KitType getKitType() {
        com.bytedance.ies.bullet.service.base.o r0 = this.bulletKitView;
        if (r0 == null) goto L7;
        KitType r1 = r0.getKitType();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return KitType.LYNX;
    }

    @Override // ia.b, ia.c
    public View getKitView() {
        com.bytedance.ies.bullet.service.base.o r0 = this.bulletKitView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.realView();
    }

    public final ViewGroup getParentViewGroup() {
        ViewGroup r0 = this.parentViewGroup;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("parentViewGroup");
        return null;
    }

    @Override // ia.b, ia.c
    public Map<String, Long> getPerfMap() {
        com.bytedance.ies.bullet.service.base.o r1 = this.bulletKitView;
        if (r1 == null) goto L24;
        if (Intrinsics.areEqual(this.bulletContext.x.b, DEFAULT_UNKNOWN) == false) goto L7;
    L10:
        long r10 = 1;
    L12:
        if (r1.getKitType() != KitType.LYNX) goto L15;
        long r11 = this.bulletContext.c.d("prepare_template_start");
        long r14 = this.bulletContext.c.d("read_template_end");
        long r12 = this.bulletContext.c.d("read_template_end");
        long r17 = r10;
        long r13 = this.bulletContext.c.d("render_template_start");
        long r20 = this.bulletContext.c.d("render_template_start");
        long r22 = this.bulletContext.c.d("render_template_end");
        LinkedHashMap r15 = new LinkedHashMap();
        r15.put("prepare_template_start", Long.valueOf(r11));
        r15.put("prepare_template_end", Long.valueOf(r14));
        r15.put("prepare_engine_load_start", Long.valueOf(r20));
        r15.put("prepare_engine_load_end", Long.valueOf(r22));
        r15.put("prepare_render_data_start", Long.valueOf(r12));
        r15.put("prepare_render_data_end", Long.valueOf(r13));
        r15.put("res_from", Long.valueOf(r17));
        return r15;
    L15:
        long r18 = r10;
        long r16 = this.bulletContext.c.d("prepare_template_start");
        long r19 = this.bulletContext.c.d("prepare_template_end");
        long r110 = this.bulletContext.c.d("prepare_component_end");
        long r21 = this.bulletContext.c.d("page_load");
        long r23 = this.bulletContext.c.d("page_load");
        long r25 = this.bulletContext.c.d("page_finish");
        LinkedHashMap r24 = new LinkedHashMap();
        if (r16 <= 0) goto L19;
        r24.put("prepare_template_start", Long.valueOf(r16));
    L19:
        if (r19 <= 0) goto L21;
        r24.put("prepare_template_end", Long.valueOf(r19));
    L21:
        r24.put("prepare_engine_load_start", Long.valueOf(r23));
        r24.put("prepare_engine_load_end", Long.valueOf(r25));
        r24.put("prepare_render_data_start", Long.valueOf(r110));
        r24.put("prepare_render_data_end", Long.valueOf(r21));
        r24.put("res_from", Long.valueOf(r18));
        return r24;
    L7:
        if (StringsKt.contains$default(this.bulletContext.x.b, "cdn", false, 2, null) == true) goto L10;
        r10 = 0;
        goto L12
    L24:
        return MapsKt.emptyMap();
    }

    @Override // ia.b, ia.c
    public t36.d getSchemaData() {
        return this.bulletContext.e;
    }

    @Override // ia.b, ia.c
    public WeakReference<Context> getWeakContext() {
        return new WeakReference(this.context);
    }

    public final WindowInsetsCompat getWindowInsetsCompat() {
        return (WindowInsetsCompat) this.windowInsetsCompat$delegate.getValue();
    }

    @Override // ia.b, ia.c
    public void goBack() {
        HybridLogger r0 = HybridLogger.a;
        HybridLogger.m(TAG, "===goBack: " + getUrl(), null, null, 12);
        com.bytedance.ies.bullet.service.base.o r1 = this.bulletKitView;
        if (r1 == null) goto L7;
        boolean r10 = true;
        if (r1.onBackPressed() != true) goto L7;
    L8:
        if (r10 == true) goto L11;
        close();
        return;
    L11:
        return;
    L7:
        r10 = false;
        goto L8
    }

    @Override // ia.b, ia.c
    public void hideError() {
        HybridLogger r0 = HybridLogger.a;
        HybridLogger.m(TAG, "===hideError: " + getUrl(), null, null, 12);
        View r1 = this.errorView;
        if (r1 == null) goto L7;
        r1.setVisibility(8);
        return;
    }

    @Override // ia.b, ia.c
    public void hideLoading() {
        HybridLogger r0 = HybridLogger.a;
        com.bytedance.ies.bullet.service.base.q r10 = null;
        HybridLogger.m(TAG, "===hideLoading: " + getUrl(), null, null, 12);
        View r1 = this.loadingView;
        boolean r11 = r1 instanceof com.bytedance.ies.bullet.service.base.q;
        if (r11 == false) goto L8;
        if (r11 == false) goto L6;
        r10 = (com.bytedance.ies.bullet.service.base.q) r1;
    L6:
        if (r10 == null) goto L12;
        r10.hide();
        return;
    L12:
        return;
    L8:
        if (r1 == null) goto L14;
        r1.setVisibility(8);
        return;
    }

    public final void initUi() {
        HybridLogger r0 = HybridLogger.a;
        HybridLogger.m(TAG, "===initUi: " + getUrl(), null, null, 12);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        observerKeyboardStatusChange();     // Catch: Throwable -> L5
        observerRootViewLayoutChanged();     // Catch: Throwable -> L5
        putState(0);     // Catch: Throwable -> L5
        this.bulletContext.c.b().rS();     // Catch: Throwable -> L5
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L13;
        HybridLogger r12 = HybridLogger.a;
        HybridLogger.i(TAG, "initUi===>" + getUrl() + " error:" + r11.getMessage(), null, 12);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public void parseSchema() {
        t36.d r0 = this.bulletContext.e;
        if (r0 == null) goto L5;
        int r1 = t36.i.a;
        t36.i.a(this.bulletContext, r0);
    L5:
        putState(1);
        HybridLogger r10 = HybridLogger.a;
        HybridLogger.m(TAG, "===parseSchema: " + getUrl(), null, null, 12);
    }

    @Override // ia.b, ia.c
    public void release() {
        if (this.isNotRelease == true) goto L5;
        return;
    L5:
        super.release();
        HybridLogger r0 = HybridLogger.a;
        HybridLogger.m(TAG, "===release: " + getUrl(), null, null, 12);
        this.lifecycleDispatcher.j(this.currentSchema);
        this.bulletContext.c.b().lX();
        Lazy r1 = BulletContextManager.b;
        BulletContextManager.a.a().d(this.bulletContext);
        View.OnLayoutChangeListener r10 = this.rootViewLayoutListener;
        if (r10 == null) goto L11;
        View r11 = getDecorView();
        if (r11 == null) goto L10;
        r11.removeOnLayoutChangeListener(r10);
    L10:
        this.rootViewLayoutListener = null;
    L11:
        getMainHandler().postDelayed(new n(this), 1000);
        com.bytedance.ies.bullet.service.base.o r12 = this.bulletKitView;
        if (r12 == null) goto L14;
        r12.g();
    L14:
        this.bulletKitView = null;
        this.containerLoader.h();
        SLMonitorCompat r13 = SLMonitorCompat.a;
        String r14 = this.bulletContext.getSessionId();
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "sessionId");
        com.bytedance.android.anniex.monitor.salamander.c.a.c(r14);
        this.errorView = null;
        this.loadingView = null;
        this.noticeView = null;
        this.denyView = null;
        this.isNotRelease = false;
        if (com.bytedance.ies.bullet.base.settings.c.a().f() != 1) goto L18;
        this.annieXLynxViewClientProxy = null;
        this.annieXWebViewClientProxy = null;
        return;
    }

    @Override // ia.b, ia.c
    public void showError() {
        HybridLogger r0 = HybridLogger.a;
        ia.j r10 = null;
        HybridLogger.m(TAG, "===showError: " + getUrl(), null, null, 12);
        if (this.errorView == null) goto L5;
    L13:
        com.bytedance.ies.bullet.service.base.i r1 = this.errorView;
        if (r1 != null) goto L16;
        return;
    L16:
        if (this.errorViewAdded == true) goto L19;
        getParentViewGroup().addView(r1);
        this.errorViewAdded = true;
    L19:
        if ((r1 instanceof com.bytedance.ies.bullet.service.base.i) == false) goto L21;
        r1.show();
        return;
    L21:
        r1.setVisibility(0);
        return;
    L5:
        if (this.isNotRelease == false) goto L13;
        HybridLogger.m(TAG, "create error view", null, null, 12);
        ia.j r11 = this.uiComponent;
        if (r11 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
    L10:
        View r12 = r10.b();
        if (r12 == null) goto L13;
        this.errorView = r12;
        goto L13
    L9:
        r10 = r11;
        goto L10
    }

    private final void bindWebOnScrollChangeListener() {
        if (getKitView() != null) goto L5;
        return;
    L5:
        if ((getKitView() instanceof SSWebView) == false) goto L9;
        SSWebView r0 = getKitView();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ies.bullet.kit.web.SSWebView");
        r0.setWebScrollListener(new b(this));
        return;
    }

    private final KitType getKitTypeWithSchema() {
        String r0 = getSchemaWithBundle();
        if (StringsKt.contains$default(r0, "://lynxview", false, 2, null) == true) goto L15;
        if (StringsKt.contains$default(r0, "://webcast_lynxview", false, 2, null) == true) goto L15;
        if (StringsKt.contains$default(r0, "://webview", false, 2, null) == true) goto L17;
        if (StringsKt.contains$default(r0, "://webcast_webview", false, 2, null) == true) goto L17;
        return KitType.UNKNOWN;
    L17:
        return KitType.WEB;
    L15:
        return KitType.LYNX;
    }

    private final long getOpenTime() {
        long r0 = System.currentTimeMillis();
        long r10 = this.bundle.getLong("open_time");
        if (r10 <= 0) goto L6;
        HybridLogger r11 = HybridLogger.a;
        HybridLogger.m(TAG, "openTime:" + r10 + ", currentTime: " + r0, null, null, 12);
        return Math.min(r10, r0);
    L6:
        return r0;
    }

    private final void initContainerColor() {
        v36.a r0 = getContainerModel();
        if (r0 == null) goto L16;
        Integer r1 = (Integer) ((y36.i) r0.e()).b;
        if (r1 != null) goto L7;
        r1 = (Integer) ((y36.i) r0.b()).b;
    L7:
        if (r1 == null) goto L17;
        int r10 = r1.intValue();
        Drawable r11 = getParentViewGroup().getBackground();
        if (r11 == null) goto L13;
        Drawable.ConstantState r12 = r11.getConstantState();
        if (r12 == null) goto L13;
        Drawable r13 = r12.newDrawable();
    L14:
        this.originBackground = r13;
        this.useCustomBackground = true;
        getParentViewGroup().setBackgroundColor(r10);
        return;
    L13:
        r13 = null;
        goto L14
    L17:
        return;
    }

    private final boolean kitViewCreateOpt() {
        return Intrinsics.areEqual(UriProtector.getQueryParameter(UriProtector.parse(getSchemaWithBundle()), "anniex_kitview_create_opt"), "1");
    }

    private final void observerRootViewLayoutChanged() {
        if (getDecorView() != null) goto L5;
        return;
    L5:
        if (supportScreenProps() == false) goto L26;
        Ref.IntRef r0 = new Ref.IntRef();
        View r1 = getDecorView();
        int r10 = 0;
        if (r1 == null) goto L10;
        int r11 = r1.getWidth();
    L11:
        r0.element = r11;
        Ref.IntRef r12 = new Ref.IntRef();
        View r13 = getDecorView();
        if (r13 == null) goto L14;
        int r14 = r13.getHeight();
    L15:
        r12.element = r14;
        AnnieXRuntime.b().getClass();
        Resources r15 = this.context.getResources();
        if (r15 == null) goto L20;
        Configuration r16 = r15.getConfiguration();
        if (r16 == null) goto L20;
        r10 = r16.orientation;
    L20:
        this.orientation = r10;
        List r17 = i16.a.a;
        this.screenProps = i16.a.h(this.bulletContext.getContext(), this.orientation, null);
        g r18 = new g(r0, r12, this);
        this.rootViewLayoutListener = r18;
        View r19 = getDecorView();
        if (r19 == null) goto L25;
        r19.addOnLayoutChangeListener(r18);
        return;
    L25:
        return;
    L14:
        r14 = 0;
        goto L15
    L10:
        r11 = 0;
        goto L11
    }

    private final void sendWindowSizeEvent() {
        AnnieXRuntime.b().getClass();
        AnnieXRuntime.b().getClass();
    }

    private final void setBackgroundColor() {
        v36.a r0 = getContainerModel();
        Intrinsics.checkNotNull(r0);
        Integer r1 = (Integer) ((y36.i) r0.b()).b;
        if (r1 == null) goto L5;
        int r10 = r1.intValue();
        getParentViewGroup().setBackgroundColor(r10);
        Unit r11 = Unit.INSTANCE;
    L6:
        if (r11 == null) goto L8;
        return;
    L8:
        if (this.useCustomBackground == false) goto L12;
        getParentViewGroup().setBackground(this.originBackground);
        this.useCustomBackground = false;
        return;
    L12:
        return;
    L5:
        r11 = null;
        goto L6
    }

    private final void setContainerColor() {
        v36.a r0 = getContainerModel();
        if (r0 == null) goto L23;
        XBaseRuntime.a.getClass();
        IHostContextDepend r1 = XBaseRuntime.f;
        Unit r10 = null;
        if (r1 == null) goto L7;
        String r11 = r1.getSkinName();
    L8:
        if (r11 != null) goto L10;
        setBackgroundColor();
        return;
    L10:
        if (Intrinsics.areEqual(r11.toLowerCase(), "light") == false) goto L16;
        Integer r12 = (Integer) ((y36.i) r0.d()).b;
        if (r12 == null) goto L14;
        getParentViewGroup().setBackgroundColor(r12.intValue());
        r10 = Unit.INSTANCE;
    L14:
        if (r10 != null) goto L24;
        setBackgroundColor();
        return;
    L24:
        return;
    L16:
        Integer r13 = (Integer) ((y36.i) r0.c()).b;
        if (r13 == null) goto L19;
        getParentViewGroup().setBackgroundColor(r13.intValue());
        r10 = Unit.INSTANCE;
    L19:
        if (r10 != null) goto L26;
        setBackgroundColor();
        return;
    L26:
        return;
    L7:
        r11 = null;
        goto L8
    }

    @Override // ia.b, ia.c
    public boolean canBackPress() {
        v36.a r0 = getContainerModel();
        if (r0 == null) goto L7;
        y36.a r1 = r0.g();
        if (r1 == null) goto L7;
        boolean r10 = Intrinsics.areEqual(((y36.i) r1).b, Boolean.TRUE);
    L8:
        if (r10 == false) goto L10;
        String r11 = "containerShouldClose";
    L11:
        sendEvent(new d(r11, r10));
        return !r10;
    L10:
        r11 = "on_key_back";
    L7:
        r10 = false;
        goto L8
    }

    public final v36.a getAnnieXContainerModel$anniex_release() {
        return getContainerModel();
    }

    public final int getNavigationBarHeight() {
        if (hasSystemNavBar() == true) goto L5;
        return 0;
    L5:
        WindowInsetsCompat r0 = getWindowInsetsCompat();
        if (r0 == null) goto L11;
        Insets r1 = r0.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r1 != null) goto L10;
        return 0;
    L10:
        return r1.bottom;
    L11:
        return 0;
    }

    @Deprecated(message = "该方法可能存在底部导航是否显示判断以及高度获取不准的问题，建议使用上面的getNavigationBarHeight()替代")
    public final int getRealNavigationBarHeight() {
        boolean r10 = true;
        if (hasSystemNavBar() == true) goto L6;
        return 0;
    L6:
        if (getActivity() != null) goto L8;
        return 0;
    L8:
        Map r0 = x26.a.a;
        w26.g r1 = (w26.g) x26.a.a(w26.g.class);
        if (r1 == null) goto L15;
        w26.e r11 = (w26.e) r1.n0(w26.e.class);
        if (r11 == null) goto L15;
        Boolean r12 = r11.o0();
        if (r12 == null) goto L15;
        r10 = r12.booleanValue();
    L15:
        if (r10 == false) goto L21;
        WindowInsetsCompat r13 = getWindowInsetsCompat();
        if (r13 == null) goto L23;
        Insets r14 = r13.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r14 != null) goto L25;
        return 0;
    L25:
        return r14.bottom;
    L23:
        return 0;
    L21:
        i16.c r15 = i16.c.a;
        Activity r16 = getActivity();
        Intrinsics.checkNotNull(r16);
        return r15.h(r16);
    }

    public final int getStatusBarHeight() {
        if (hasStatusBar() == true) goto L5;
        return 0;
    L5:
        WindowInsetsCompat r0 = getWindowInsetsCompat();
        if (r0 == null) goto L11;
        Insets r1 = r0.getInsets(WindowInsetsCompat.Type.statusBars());
        if (r1 != null) goto L10;
        return 0;
    L10:
        return r1.bottom;
    L11:
        return 0;
    }

    public final String getUrl() {
        v36.a r0 = getContainerModel();
        if (r0 == null) goto L6;
        String r1 = ((x36.a) r0).h;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return DEFAULT_UNKNOWN;
    }

    public final boolean hasStatusBar() {
        if (getWindowInsetsCompat() != null) goto L5;
        return false;
    L5:
        WindowInsetsCompat r0 = getWindowInsetsCompat();
        if (r0 != null) goto L8;
        return false;
    L8:
        if (r0.isVisible(WindowInsetsCompat.Type.statusBars()) != true) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean hasSystemNavBar() {
        if (getWindowInsetsCompat() != null) goto L5;
        return false;
    L5:
        WindowInsetsCompat r0 = getWindowInsetsCompat();
        if (r0 != null) goto L8;
        return false;
    L8:
        if (r0.isVisible(WindowInsetsCompat.Type.navigationBars()) != true) goto L12;
        return true;
    L12:
        return false;
    }

    public final boolean isKitViewScrollReachTop() {
        if (getKitType() == KitType.WEB) goto L15;
        View r0 = this.lynxWithScrollView;
        if (r0 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == true) goto L13;
        return true;
    L13:
        return false;
    L8:
        if (r0.canScrollVertically(-1) != true) goto L10;
        r1 = true;
        goto L11
    L15:
        return this.isWebViewScrollReachTop;
    }

    public final boolean isPadOrFold() {
        AnnieXRuntime.b().getClass();
        AnnieXRuntime.b().getClass();
        return false;
    }

    @Override // ia.b, ia.c
    public void onAttachToWindow() {
        super.onAttachToWindow();
        AbsBulletMonitorCallback r0 = this.bulletContext.c;
        this.currentUri.getPath();
        r0.E();
    }

    private final void observerKitViewLayoutChanged() {
        com.bytedance.ies.bullet.service.base.h.w();
    }

    @Override // ia.b, ia.c
    public String getBid() {
        return this.currentBid;
    }

    public final UIComponentBuilder getBuilder() {
        return this.builder;
    }

    public final BulletContext getBulletContext() {
        return this.bulletContext;
    }

    public final boolean getContainerVisible() {
        return this.containerVisible;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // ia.b, ia.c
    public m16.b getContextProviderFactory() {
        return this.contextProviderFactory;
    }

    @Override // ia.b, ia.c
    public String getCurrentUrl() {
        return this.currentSchema;
    }

    public final View getLynxWithScrollView$anniex_release() {
        return this.lynxWithScrollView;
    }

    public final Function1<Boolean, Unit> getOnSoftInputChangeListener$anniex_release() {
        return this.onSoftInputChangeListener;
    }

    public final View getRootView() {
        return this.rootView;
    }

    @Override // ia.b, ia.c
    public Context getSystemContext() {
        return this.context;
    }

    @Override // ia.b
    public boolean isVisibility() {
        return this.isVisibility;
    }

    public AnnieXContainer(UIComponentBuilder r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        this.builder = r10;
        this.bundle = r10.c;
        this.contextProviderFactory = (m16.b) r10.d.getValue();
        this.globalProps = r10.e;
        com.bytedance.android.anniex.container.b r0 = new com.bytedance.android.anniex.container.b();
        com.bytedance.android.anniex.base.lifecycle.a r1 = r10.f;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(r1, "lifecycle");
        r0.a.add(r1);
    L5:
        this.lifecycleDispatcher = r0;
        Context r11 = r10.a;
        if (r11 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("systemContext");
        r11 = null;
    L9:
        this.context = r11;
        this.currentBid = r10.b;
        this.currentSchema = "";
        this.currentUri = Uri.EMPTY;
        q26.a r12 = new q26.a(r11, com.bytedance.ies.bullet.core.h.h.a);
        this.serviceContext = r12;
        this.isWebViewScrollReachTop = true;
        this.bulletContext = initOrGetBulletContext(getSchemaWithBundle(), getSessionIdWithBundle());
        this.annieXLynxViewClientProxy = new AnnieXLynxViewClientProxy(this, r10.h);
        this.annieXWebViewClientProxy = new com.bytedance.android.anniex.base.lifecycle.b(this, r10.g);
        this.containerInstance = new e(this);
        this.deprecatedBulletContainer = new f(this);
        this.bulletLifecycle = new c(this);
        this.isRootViewFirstLayout = true;
        this.foldStatus = "";
        this.decorView$delegate = LazyKt.lazy(new AnnieXContainer$decorView$2(this));
        this.windowInsetsCompat$delegate = LazyKt.lazy(new AnnieXContainer$windowInsetsCompat$2(this));
        this.loadSuccess = true;
        this.stateBlockingQueue = new ArrayBlockingQueue(10);
        BulletContainerLoader r13 = new BulletContainerLoader(r12, this.currentBid);
        this.containerLoader = r13;
        if (kitViewCreateOpt() == false) goto L12;
        com.bytedance.ies.bullet.service.base.o r14 = r13.f(getKitTypeWithSchema(), getSessionIdWithBundle());
    L13:
        this.bulletKitView = r14;
        if (kitViewCreateOpt() == true) goto L16;
    L21:
        this.createViewTime = System.currentTimeMillis();
        this.pendingEvent = Collections.synchronizedList(new ArrayList());
        this.synchronizedObj = new Object();
        this.onSoftInputChangeListener = new AnnieXContainer$onSoftInputChangeListener$1(this);
        this.isNotRelease = true;
        this.mainHandler$delegate = LazyKt.lazy(AnnieXContainer$mainHandler$2.INSTANCE);
        return;
    L16:
        if (this.bulletKitView == null) goto L21;
        String r15 = getSchemaWithBundle();
        com.bytedance.ies.bullet.service.base.o r16 = this.bulletKitView;
        if (r16 == null) goto L20;
        r16.k(r15);
    L20:
        bindKitView$default(this, UriProtector.parse(r15), null, 2, null);
        goto L21
    L12:
        r14 = null;
        goto L13
    }

    public static final /* synthetic */ Activity access$getActivity(AnnieXContainer r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ com.bytedance.ies.bullet.service.base.o access$getBulletKitView$p(AnnieXContainer r0) {
        return r0.bulletKitView;
    }

    public static final /* synthetic */ m16.b access$getContextProviderFactory$p(AnnieXContainer r0) {
        return r0.contextProviderFactory;
    }

    public static final /* synthetic */ String access$getCurrentBid$p(AnnieXContainer r0) {
        return r0.currentBid;
    }

    public static final /* synthetic */ String access$getCurrentSchema$p(AnnieXContainer r0) {
        return r0.currentSchema;
    }

    public static final /* synthetic */ Uri access$getCurrentUri$p(AnnieXContainer r0) {
        return r0.currentUri;
    }

    public static final /* synthetic */ View access$getDecorView(AnnieXContainer r0) {
        return r0.getDecorView();
    }

    public static final /* synthetic */ com.bytedance.android.anniex.container.b access$getLifecycleDispatcher$p(AnnieXContainer r0) {
        return r0.lifecycleDispatcher;
    }

    public static final /* synthetic */ Integer access$getPadAdapterHeight$p(AnnieXContainer r0) {
        return r0.padAdapterHeight;
    }

    public static final /* synthetic */ Integer access$getPadAdapterWidth$p(AnnieXContainer r0) {
        return r0.padAdapterWidth;
    }

    public static final /* synthetic */ Map access$getScreenProps$p(AnnieXContainer r0) {
        return r0.screenProps;
    }

    public static final /* synthetic */ ia.j access$getUiComponent$p(AnnieXContainer r0) {
        return r0.uiComponent;
    }

    public static final /* synthetic */ void access$observerKitViewLayoutChanged(AnnieXContainer r0) {
        r0.observerKitViewLayoutChanged();
    }

    public static final /* synthetic */ void access$sendWindowSizeEvent(AnnieXContainer r0) {
        r0.sendWindowSizeEvent();
    }

    private final boolean canCreateNormalBulletContext(String r10) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        if (UriProtector.parse(r10).getHost() != null) goto L6;
        return false;
    L6:
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L11:
        if (Result.exceptionOrNull-impl(r11) == null) goto L13;
        return false;
    L13:
        return true;
    L8:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    private final void changeState(int r10) {
        if (r10 != 0) goto L4;
        transferToTargetState();
        initContainerColor();
        return;
    L4:
        if (r10 == 1) goto L53;
        if (r10 != 2) goto L8;
        getParentViewGroup().removeAllViews();
        this.errorViewAdded = false;
        addKitView();
        padAdaptation(this.bulletKitView, this.context.getResources().getConfiguration(), true);
        v36.a r11 = getContainerModel();
        if (r11 == null) goto L76;
        y36.a r12 = r11.i();
        if (r12 == null) goto L77;
        Boolean r13 = (Boolean) ((y36.i) r12).b;
        if (r13 != null) goto L29;
        return;
    L29:
        if (r13.booleanValue() == true) goto L32;
        r13 = null;
    L32:
        if (r13 == null) goto L79;
        r13.booleanValue();
        if (this.loadingView == null) goto L36;
    L41:
        View r14 = this.loadingView;
        if (r14 == null) goto L51;
        ViewGroup.LayoutParams r0 = r14.getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == false) goto L46;
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
    L47:
        if (r1 == null) goto L50;
        r1.gravity = 17;
    L50:
        getParentViewGroup().addView(r14);
        goto L51
    L46:
        r1 = null;
    L51:
        showLoading(null);
        return;
    L36:
        if (this.isNotRelease == false) goto L41;
        HybridLogger.m(TAG, "create loading view", null, null, 12);
        ia.j r15 = this.uiComponent;
        if (r15 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
        r15 = null;
    L40:
        this.loadingView = r15.c();
        goto L41
    L79:
        return;
    L77:
        return;
    L76:
        return;
    L8:
        if (r10 == 3) goto L18;
        if (r10 != 4) goto L82;
        this.isRuntimeReady = true;
        if (this.isResuming == false) goto L72;
        com.bytedance.ies.bullet.service.base.o r16 = this.bulletKitView;
        if (r16 == null) goto L73;
        r16.onShow();
        return;
    L73:
        return;
    L72:
        return;
    L82:
        return;
    L18:
        if (this.loadSuccess == false) goto L20;
        HybridLogger.f(TAG, "load success", null, 12);
        setContainerColor();
    L21:
        hideLoading();
        addTagView();
        return;
    L20:
        HybridLogger.f(TAG, "load fail", null, 12);
        showError();
        goto L21
    L53:
        if (Intrinsics.areEqual(getViewType(), com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP) == false) goto L62;
        com.bytedance.android.anniex.assemble.a r17 = com.bytedance.android.anniex.assemble.a.a;
        Iterator r18 = com.bytedance.android.anniex.assemble.a.e().entrySet().iterator();
    L56:
        if (r18.hasNext() == false) goto L62;
        ia.c r19 = (ia.c) ((WeakReference) ((Map.Entry) r18.next()).getValue()).get();
        if (r19 == null) goto L56;
        if (Intrinsics.areEqual(r19.getWeakContext().get(), this.context) == false) goto L56;
        r19.onVisibleChange(false, Boolean.FALSE);
    L62:
        AnnieXContainerManager.INSTANCE.addContainer(this);
    }

    private final void createModel(Uri r10) {
        this.bulletContext = initOrGetBulletContext(r10.toString(), getSessionIdWithBundle());
        parseSchema();
    }

    private final View getContentView(View r10) {
        View r11 = r10.findViewById(R.id.content);
        if ((r11 instanceof ViewGroup) == true) goto L7;
        return null;
    L7:
        return (ViewGroup) r11;
    }

    private final boolean isBreakPointChange(Map<String, Object> r10) {
        Integer r0 = null;
        if (r10 == null) goto L5;
        Object r11 = r10.get("aweBreakPoint");
    L7:
        if ((r11 instanceof Map) == false) goto L9;
        Map r12 = (Map) r11;
    L10:
        if (r12 == null) goto L26;
        Object r1 = r12.get(DeviceDepend.FoldType.HORIZONTAL);
        if ((r1 instanceof Integer) == false) goto L14;
        Integer r13 = (Integer) r1;
    L15:
        Object r14 = r12.get(DeviceDepend.FoldType.VERTICAL);
        if ((r14 instanceof Integer) == false) goto L18;
        r0 = (Integer) r14;
    L18:
        if (r13 == null) goto L28;
        if (r0 != null) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(r13, this.curHorizontalBreakPoint) == true) goto L23;
    L24:
        this.curHorizontalBreakPoint = r13;
        this.curVerticalBreakPoint = r0;
        return true;
    L23:
        if (Intrinsics.areEqual(r0, this.curVerticalBreakPoint) == false) goto L24;
        return false;
    L28:
        return false;
    L14:
        r13 = null;
        goto L15
    L26:
        return false;
    L9:
        r12 = null;
        goto L10
    L5:
        r11 = null;
        goto L7
    }

    private final void possiblyResizeChildOfContent4Web(int r10) {
        if (needAdapterKeyboard4Web() == true) goto L5;
        return;
    L5:
        v36.a r0 = getContainerModel();
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L13;
        y36.i r11 = r0.G;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("disableInputScroll");
        r11 = null;
    L11:
        if (r11 == null) goto L13;
        boolean r12 = Intrinsics.areEqual(r11.b, Boolean.TRUE);
    L14:
        if (r12 == false) goto L16;
        return;
    L16:
        View r13 = getParentViewGroup().getRootView();
        int r14 = r13.getHeight();
        int r15 = r14 - r10;
        if (r15 == this.usableHeightPrevious) goto L47;
        View r16 = getContentView(r13);
        Map r17 = x26.a.a;
        w26.g r18 = (w26.g) x26.a.a(w26.g.class);
        if (r18 == null) goto L25;
        w26.e r19 = (w26.e) r18.n0(w26.e.class);
        if (r19 == null) goto L25;
        Boolean r20 = r19.v0();
        if (r20 == null) goto L25;
        boolean r21 = r20.booleanValue();
    L26:
        if (r21 == true) goto L28;
    L38:
        if (r16 == null) goto L40;
        r1 = r16.getLayoutParams();
    L40:
        if (r1 != null) goto L42;
        return;
    L42:
        if (r10 <= (r14 / 4)) goto L44;
        r1.height = r15;
    L45:
        r16.requestLayout();
        this.usableHeightPrevious = r15;
        return;
    L44:
        r1.height = r14;
        goto L45
    L28:
        if ((this instanceof com.bytedance.android.anniex.container.d) == false) goto L38;
        if (AnnieXContainerManager.isTopContainer(this) == false) goto L38;
        if (r10 != 0) goto L34;
        if (r16 == null) goto L36;
        r16.scrollTo(0, 0);
    L36:
        this.usableHeightPrevious = r15;
        return;
    L34:
        if (r16 == null) goto L36;
        r16.scrollBy(0, r10 - getNavigationBarHeight());
    L25:
        r21 = true;
        goto L26
    L47:
        return;
    L13:
        r12 = false;
        goto L14
    }

    private final void putState(int r10) {
        if (this.parentViewGroup == null) goto L5;
        getMainHandler().post(new m(this, r10));
        return;
    L5:
        this.stateBlockingQueue.put(Integer.valueOf(r10));
    }

    private final boolean showContainerTag(g16.b r10) {
        com.bytedance.ies.bullet.core.h r0 = com.bytedance.ies.bullet.core.h.h;
        com.bytedance.ies.bullet.core.h r1 = com.bytedance.ies.bullet.core.h.h;
        if (r1.a == false) goto L7;
        r1.getClass();
        if (r10.a == false) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // ia.b, ia.c
    public void bindContainerId(String r10) {
        Intrinsics.checkNotNullParameter(r10, "containerId");
        this.__containerId = r10;
    }

    @Override // ia.b, ia.c
    public t36.d generateSchemaData(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        if (Intrinsics.areEqual(r10, this.currentSchema) == true) goto L5;
        this.currentSchema = r10;
        createModel(UriProtector.parse(r10));
    L5:
        t36.d r11 = this.bulletContext.e;
        if (r11 != null) goto L9;
        Lazy r12 = SchemaService.f;
        return SchemaService.a.a().c(this.currentBid, this.currentUri, true);
    L9:
        return r11;
    }

    @Override // ia.b, ia.c
    public void interceptBackPress(boolean r10) {
        v36.a r0 = getContainerModel();
        if (r0 == null) goto L6;
        y36.a r1 = new y36.a(Boolean.valueOf(r10));
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.i = r1;
    L6:
        ia.j r11 = this.uiComponent;
        if (r11 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
        r11 = null;
    L9:
        r11.d(r10);
    }

    public void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        padAdaptation$default(this, this.bulletKitView, r10, false, 4, null);
        updateLynxScreenMetrics();
        sendWindowSizeEvent();
    }

    @Override // ia.b
    public void preloadSchema(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        if (Intrinsics.areEqual(r10, this.currentSchema) == true) goto L5;
        this.currentSchema = r10;
        createModel(UriProtector.parse(r10));
    L5:
        HybridLogger r11 = HybridLogger.a;
        HybridLogger.m(TAG, "===preloadSchema: " + getUrl(), null, null, 12);
    }

    @Override // ia.b, ia.c
    public void reload(Map<String, ? extends Object> r10) {
        HybridLogger r0 = HybridLogger.a;
        HybridLogger.m(TAG, "===reload: " + getUrl(), null, null, 12);
        if (this.loadSuccess == true) goto L14;
        s26.d r1 = s26.d.c;
        m0 r11 = s26.d.c.c(m0.class);
        if (r11 == null) goto L11;
        com.bytedance.ies.bullet.service.base.d r12 = r11.a0();
        if (r12 == null) goto L11;
        boolean r13 = true;
        if (r12.y0 != true) goto L11;
    L12:
        if (r13 == false) goto L14;
        this.kitViewHasBinded = false;
        this.bulletKitView = null;
        this.containerLoader.h();
    L11:
        r13 = false;
    L14:
        loadSchema(this.currentSchema, r10);
    }

    @Override // ia.b, ia.c
    public void reloadTemplate(Map<String, ? extends Object> r10) {
        HybridLogger r0 = HybridLogger.a;
        LinkedHashMap r11 = null;
        HybridLogger.m(TAG, "===reloadTemplate: " + getUrl(), null, null, 12);
        LynxView r1 = this.bulletKitView;
        if ((r1 instanceof LynxView) == false) goto L5;
        LynxView r12 = r1;
    L6:
        if (r12 == null) goto L22;
        this.lifecycleDispatcher.h(this.currentSchema, this);
        if (r10 == null) goto L15;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r11 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r13 = r10.entrySet().iterator();
    L11:
        if (r13.hasNext() == false) goto L15;
        Map.Entry<String, ? extends Object> r14 = r13.next();
        Object r15 = r14.getValue();
        if (r15 == null) goto L11;
        r11.put(r14.getKey(), r15);
    L15:
        TemplateData r16 = TemplateData.fromMap(r11);
        r16.markReadOnly();
        r12.reloadTemplate(r16);
        this.lifecycleDispatcher.i(this.currentSchema, this);
        return;
    L22:
        return;
    L5:
        r12 = null;
        goto L6
    }

    @Override // ia.b, ia.c
    public void sendEvent(com.bytedance.ies.bullet.core.kit.bridge.h r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        com.bytedance.ies.bullet.service.base.o r0 = this.bulletKitView;
        if (r0 == null) goto L6;
        if (r0 == null) goto L16;
        r0.sendEvent(r10.getName(), r10.getParams());
        return;
    L16:
        return;
    L6:
        Object r1 = this.synchronizedObj;
        monitor-enter(r1);
        this.pendingEvent.add(r10);     // Catch: Throwable -> L11
        monitor-exit(r1);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void setBulletContext(BulletContext r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.bulletContext = r10;
    }

    public final void setContainerVisible(boolean r1) {
        this.containerVisible = r1;
    }

    public final void setLynxWithScrollView$anniex_release(View r1) {
        this.lynxWithScrollView = r1;
    }

    public final void setParentViewGroup(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.parentViewGroup = r10;
    }

    public final void setRootView(View r1) {
        this.rootView = r1;
    }

    public final void setUiComponent(ia.j r10) {
        Intrinsics.checkNotNullParameter(r10, "uiComponent");
        this.uiComponent = r10;
    }

    @Override // ia.b, ia.c
    public void showLoading(String r10) {
        HybridLogger r11 = HybridLogger.a;
        com.bytedance.ies.bullet.service.base.q r12 = null;
        HybridLogger.m(TAG, "===showLoading: " + getUrl(), null, null, 12);
        View r13 = this.loadingView;
        boolean r0 = r13 instanceof com.bytedance.ies.bullet.service.base.q;
        if (r0 == false) goto L8;
        if (r0 == false) goto L6;
        r12 = (com.bytedance.ies.bullet.service.base.q) r13;
    L6:
        if (r12 == null) goto L12;
        r12.show();
        return;
    L12:
        return;
    L8:
        if (r13 == null) goto L14;
        r13.setVisibility(0);
        return;
    }

    @Override // ia.b, ia.c
    public void updateData(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        HybridLogger r0 = HybridLogger.a;
        HybridLogger.m(TAG, "===updateData: " + getUrl(), null, null, 12);
        com.bytedance.ies.bullet.service.base.o r1 = this.bulletKitView;
        if (r1 == null) goto L6;
        r1.updateData(r10);
        return;
    }

    @Override // ia.b, ia.c
    public void updateGlobalProps(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "globalProps");
        HybridLogger r0 = HybridLogger.a;
        HybridLogger.m(TAG, "===updateGlobalProps: " + getUrl(), null, null, 12);
        this.globalProps.putAll(r10);
        com.bytedance.ies.bullet.service.base.o r11 = this.bulletKitView;
        if (r11 == null) goto L6;
        r11.updateGlobalProps(this.globalProps);
        return;
    }

    @Override // ia.b
    public void updateData(String r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        HybridLogger r11 = HybridLogger.a;
        HybridLogger.m(TAG, "===updateData: " + getUrl(), null, null, 12);
    }

    public static final /* synthetic */ void access$changeState(AnnieXContainer r0, int r1) {
        r0.changeState(r1);
    }

    public static final /* synthetic */ void access$possiblyResizeChildOfContent4Web(AnnieXContainer r0, int r1) {
        r0.possiblyResizeChildOfContent4Web(r1);
    }

    public static final /* synthetic */ void access$putState(AnnieXContainer r0, int r1) {
        r0.putState(r1);
    }

    public static final /* synthetic */ void access$setLoadSuccess$p(AnnieXContainer r0, boolean r1) {
        r0.loadSuccess = r1;
    }

    public static final /* synthetic */ void access$setWebViewScrollReachTop$p(AnnieXContainer r0, boolean r1) {
        r0.isWebViewScrollReachTop = r1;
    }

    private final void bindKitView(Uri r10, com.bytedance.ies.bullet.service.base.o r11) {
        if (this.kitViewHasBinded != true) goto L5;
        return;
    L5:
        if (r11 != null) goto L7;
    L9:
        postFirstVisibleEvent();
        putState(2);
        com.bytedance.ies.bullet.service.base.o r12 = this.bulletKitView;
        if (r12 == null) goto L33;
        View r13 = r12.realView();
        if (r13 == null) goto L33;
        v36.a r0 = getContainerModel();
        y36.i r14 = null;
        if (r0 == null) goto L23;
        y36.i r1 = r0.r;
        if (r1 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("webBgColor");
        r1 = null;
    L19:
        if (r1 == null) goto L23;
        Integer r15 = (Integer) r1.b;
        if (r15 == null) goto L23;
        r13.setBackgroundColor(r15.intValue());
    L23:
        v36.a r16 = getContainerModel();
        if (r16 == null) goto L33;
        y36.i r17 = ((x36.a) r16).e;
        if (r17 == null) goto L28;
        r14 = r17;
    L29:
        if (r14 == null) goto L33;
        Integer r18 = (Integer) r14.b;
        if (r18 == null) goto L33;
        r13.setBackgroundColor(r18.intValue());
        goto L33
    L28:
        Intrinsics.throwUninitializedPropertyAccessException("contentBgColor");
    L33:
        super.onKitViewCreate();
        this.lifecycleDispatcher.e(this.currentSchema, this);
        this.bulletContext.c.b().gQ(r10, this.bulletKitView);
        bindWebOnScrollChangeListener();
        this.kitViewHasBinded = true;
        return;
    L7:
        if (kitViewCreateOpt() == true) goto L9;
        this.bulletKitView = r11;
        goto L9
    }

    private final BulletContext initOrGetBulletContext(String r10, String r11) {
        if (canCreateNormalBulletContext(r10) == false) goto L11;
        HybridLogger.i(TAG, "====init BulletContext with normal===", null, 12);
        Uri r12 = UriProtector.parse(r10);
        this.currentUri = r12;
        String r13 = UriProtector.getQueryParameter(r12, "bid");
        if (r13 == null) goto L7;
        this.currentBid = r13;
    L7:
        Lazy r14 = BulletContextManager.b;
        BulletContext r15 = BulletContextManager.c(BulletContextManager.a.a(), this.currentBid, this.currentUri, this.bundle);
        r15.b(this.context);
        if (Intrinsics.areEqual(r11, DEFAULT_UNKNOWN) == true) goto L10;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r15.a = r11;
    L10:
        r15.f = this.currentBid;
        com.bytedance.ies.bullet.core.j r0 = r15.u;
        r0.d = this.annieXLynxViewClientProxy;
        com.bytedance.ies.bullet.core.o r1 = r15.v;
        r1.e = this.annieXWebViewClientProxy;
        com.bytedance.ies.bullet.core.e r16 = r15.w;
        r16.i = this.builder.e;
        r15.r = this.serviceContext;
        r15.c.h(r15);
    L13:
        if (FlowContainerLoaderSwitch.INSTANCE.isAnnieXFlowLoaderExist(r11) == true) goto L15;
        com.bytedance.ies.bullet.core.e r17 = r15.w;
        r17.h = this.globalProps;
    L19:
        return r15;
    L15:
        Map<String, Object> r18 = this.globalProps;
        Map<? extends String, ? extends Object> r19 = r15.w.h;
        if (r19 != null) goto L18;
        r19 = new LinkedHashMap();
    L18:
        r18.putAll(r19);
        r15.w.h = r18;
        goto L19
    L11:
        HybridLogger.i(TAG, "====init BulletContext with default===", null, 12);
        r15 = new BulletContext();
        r15.b(this.context);
        Intrinsics.checkNotNullParameter(DEFAULT_UNKNOWN, "<set-?>");
        r15.a = DEFAULT_UNKNOWN;
        UIComponentBuilder r20 = this.builder;
        r15.f = r20.b;
        com.bytedance.ies.bullet.core.j r21 = r15.u;
        r21.d = this.annieXLynxViewClientProxy;
        com.bytedance.ies.bullet.core.o r22 = r15.v;
        r22.e = this.annieXWebViewClientProxy;
        com.bytedance.ies.bullet.core.e r23 = r15.w;
        r23.i = r20.e;
        r15.r = this.serviceContext;
        r15.c.h(r15);
        goto L13
    }

    private final void onFoldStatusChanged(String r1, Map<String, Object> r10) {
        this.foldStatus = r1;
        if (r10 == null) goto L6;
        sendEvent(new h(r10));
        return;
    }

    private final void onOrientationChanged(int r1, Map<String, Object> r10) {
        this.orientation = r1;
        if (r10 == null) goto L6;
        sendEvent(new i(r10));
        return;
    }

    private final void sendKeyboardStatusChangeEvent(boolean r10, int r11) {
        JSONObject r0 = new JSONObject();
        r0.put("visible", r10);
        r0.put("height", r11);
        sendEvent(new o(r0));
        sendEvent(new p(r0));
    }

    @Override // ia.b, ia.c
    public void loadSchema(String r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        long r0 = getOpenTime();
        Uri r12 = UriProtector.parse(r10);
        if (Intrinsics.areEqual(r10, this.currentSchema) == true) goto L5;
        this.currentSchema = r10;
        createModel(r12);
    L5:
        SLMonitorCompat r13 = SLMonitorCompat.a;
        String r14 = getContainerId();
        r13.getClass();
        SLMonitorCompat.r(r14, r10);
        if (com.bytedance.ies.bullet.service.base.h.e0() == true) goto L8;
        int r15 = com.bytedance.ies.bullet.forest.j.a;
        com.bytedance.ies.bullet.forest.j.a(this.bulletContext, null, null, false);
    L8:
        ai7.a.c(r12);
        Application r16 = com.bytedance.ies.bullet.core.h.h.b;
        if (r16 == null) goto L11;
        AnnieXJSWorkerManager.a.c(r16, this.currentSchema);
    L11:
        closeCurrentPageWhenAfterPageOpen();
        this.bulletContext.b(this.context);
        if (r11 == null) goto L16;
        Map r17 = MapsKt.toMutableMap(r11);
        if (r17 == null) goto L16;
        com.bytedance.ies.bullet.core.j r18 = this.bulletContext.u;
        p46.f r19 = new p46.f();
        r19.a = r17;
        r18.b = r19;
    L16:
        setSecureInfo();
        this.contextProviderFactory.d(ContainerBidParam.class, new ContainerBidParam(this.currentBid));
        this.contextProviderFactory.g(Context.class, this.context);
        this.contextProviderFactory.g(BulletContext.class, this.bulletContext);
        this.contextProviderFactory.g(ue7.c.class, this.containerInstance);
        this.contextProviderFactory.g(h16.e.class, this.deprecatedBulletContainer);
        this.contextProviderFactory.g(ia.c.class, this);
        if (com.bytedance.ies.bullet.service.base.h.e0() == true) goto L19;
    L23:
        Map r20 = c36.a.a;
        c36.a.b(this.bulletContext.getSessionId(), this.contextProviderFactory);
        this.lifecycleDispatcher.h(this.currentSchema, this);
        AbsBulletMonitorCallback r21 = this.bulletContext.c;
        int r22 = AbsBulletMonitorCallback.c;
        r21.s(r0, false);
        this.bulletContext.c.k(Long.valueOf(this.createViewTime));
        this.bulletContext.c.b().Ox(this.currentUri, null);
        BulletContext r23 = this.bulletContext;
        r23.m = r23.c.b();
        this.serviceContext.putDependency(BulletContext.class, this.bulletContext);
        this.containerLoader.g(this.bulletContext, this.currentUri, this.bundle, this.bulletLifecycle);
        return;
    L19:
        if (Intrinsics.areEqual(this.currentBid, "webcast") == false) goto L23;
        String r24 = this.__containerId;
        if (r24 == null) goto L23;
        this.contextProviderFactory.d(p16.a.class, new p16.a(r24));
        goto L23
    }

    @Override // ia.b, ia.c
    public void onVisibleChange(boolean r10, Boolean r11) {
        if (r10 != this.containerVisible) goto L5;
        return;
    L5:
        this.containerVisible = r10;
        sendEvent(new j(r10, this));
        if (r11 != null) goto L8;
    L9:
        if (r10 == false) goto L11;
        sendEvent(new k());
        return;
    L11:
        sendEvent(new l());
        return;
    L8:
        if (Intrinsics.areEqual(r11, Boolean.FALSE) == true) goto L9;
    }

    @Override // ia.b, ia.c
    public <T> void registerWeakHolder(Class<T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        this.contextProviderFactory.g(r10, r11);
    }

    @Override // ia.b, ia.c
    public void updateScreenMetrics(int r10, int r11) {
        com.bytedance.ies.bullet.service.base.o r0 = this.bulletKitView;
        LynxView r1 = null;
        if (r0 == null) goto L5;
        View r12 = r0.realView();
    L7:
        if ((r12 instanceof LynxView) == false) goto L9;
        r1 = (LynxView) r12;
    L9:
        if (r1 == null) goto L12;
        r1.updateScreenMetrics(r10, r11);
        return;
    L12:
        return;
    L5:
        r12 = null;
        goto L7
    }

    public static final /* synthetic */ void access$bindKitView(AnnieXContainer r0, Uri r1, com.bytedance.ies.bullet.service.base.o r10) {
        r0.bindKitView(r1, r10);
    }

    public static final /* synthetic */ void access$sendKeyboardStatusChangeEvent(AnnieXContainer r0, boolean r1, int r10) {
        r0.sendKeyboardStatusChangeEvent(r1, r10);
    }

    private final void padAdaptation(com.bytedance.ies.bullet.service.base.o r10, Configuration r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        boolean r13 = this instanceof com.bytedance.android.anniex.container.c;
        Scenes r14 = Scenes.AbsActivity;
        Integer r15 = b46.c.a;
        b46.c.d(this.bulletContext.g);
        HybridLogger r16 = HybridLogger.a;
        HybridLogger.m(TAG, "padAdaptation : current scenes=" + this.bulletContext.i + ",padAdapterWidth=" + this.padAdapterWidth + ",padAdapterHeight=" + this.padAdapterHeight, null, null, 12);
    }

    public static /* synthetic */ void bindKitView$default(AnnieXContainer r0, Uri r1, com.bytedance.ies.bullet.service.base.o r10, int r11, Object r12) {
        if (r12 != null) goto L9;
        if ((r11 & 2) == 0) goto L6;
        r10 = null;
    L6:
        r0.bindKitView(r1, r10);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindKitView");
    }

    public static /* synthetic */ void padAdaptation$default(AnnieXContainer r0, com.bytedance.ies.bullet.service.base.o r1, Configuration r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 4) == 0) goto L6;
        r11 = false;
    L6:
        r0.padAdaptation(r1, r10, r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: padAdaptation");
    }

    private final void onRootViewLayoutChanged(int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17) {
        Resources r18 = this.context.getResources();
        if (r18 == null) goto L7;
        Configuration r19 = r18.getConfiguration();
        if (r19 == null) goto L7;
        Integer r20 = Integer.valueOf(r19.orientation);
    L8:
        boolean r110 = true;
        int r0 = 0;
        if (isPadOrFold() == false) goto L18;
        Map r111 = x26.a.a;
        w26.g r112 = (w26.g) x26.a.a(w26.g.class);
        if (r112 == null) goto L15;
        w26.e r113 = (w26.e) r112.n0(w26.e.class);
        if (r113 == null) goto L15;
        boolean r114 = Intrinsics.areEqual(r113.y1(), Boolean.TRUE);
    L16:
        if (r114 == false) goto L18;
        boolean r115 = true;
    L20:
        if (r115 == false) goto L35;
        if (r20 != null) goto L24;
    L28:
        if (r20 == null) goto L35;
        if (r20.intValue() != 2) goto L35;
        if ((r12 - r10) >= (r13 - r11)) goto L35;
        r20 = 1;
        goto L35
    L24:
        if (r20.intValue() != 1) goto L28;
        if ((r12 - r10) <= (r13 - r11)) goto L28;
        r20 = 2;
    L35:
        List r21 = i16.a.a;
        Context r22 = this.bulletContext.getContext();
        if (r20 == null) goto L38;
        int r23 = r20.intValue();
    L39:
        Map<String, ? extends Object> r24 = i16.a.h(r22, r23, null);
        com.bytedance.ies.bullet.service.base.h.w();
        if (r115 == false) goto L49;
        if (r24 == null) goto L49;
        if (r20 != null) goto L45;
    L47:
        r24.put("isLandscape", Integer.valueOf(r0));
        goto L49
    L45:
        if (r20.intValue() != 2) goto L47;
        r0 = 1;
    L49:
        if (Intrinsics.areEqual(this.screenProps, r24) == true) goto L53;
        this.screenProps = r24;
        if (r24 == null) goto L53;
        updateGlobalProps(r24);
    L53:
        Map r25 = x26.a.a;
        w26.g r26 = (w26.g) x26.a.a(w26.g.class);
        if (r26 == null) goto L60;
        w26.e r27 = (w26.e) r26.n0(w26.e.class);
        if (r27 == null) goto L60;
        Boolean r28 = r27.j0();
        if (r28 == null) goto L60;
        r110 = r28.booleanValue();
    L60:
        if (r110 == false) goto L65;
        if (r20 == null) goto L65;
        if (r20.intValue() == this.orientation) goto L65;
        onOrientationChanged(r20.intValue(), r24);
    L65:
        AnnieXRuntime.b().getClass();
        AnnieXRuntime.b().getClass();
        return;
    L38:
        r23 = 0;
    L15:
        r114 = false;
    L18:
        r115 = false;
    L7:
        r20 = null;
        goto L8
    }

    public static final /* synthetic */ void access$onRootViewLayoutChanged(AnnieXContainer r0, int r1, int r10, int r11, int r12, int r13, int r14, int r15, int r16) {
        r0.onRootViewLayoutChanged(r1, r10, r11, r12, r13, r14, r15, r16);
    }
}
