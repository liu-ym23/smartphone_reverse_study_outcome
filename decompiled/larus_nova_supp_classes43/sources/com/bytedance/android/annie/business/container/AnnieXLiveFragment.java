package com.bytedance.android.annie.business.container;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.FragmentCustomMonitorKey;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.card.web.WebComponent;
import com.bytedance.android.annie.card.web.secLink.LiveSecLinkManager;
import com.bytedance.android.annie.container.fragment.AnnieFragmentManager;
import com.bytedance.android.annie.container.fragment.q;
import com.bytedance.android.annie.monitor.SlardarMonitorUtils;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.view.FullscreenVideoFrame;
import com.bytedance.android.anniex.container.AnnieXContainer;
import com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager;
import com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager$lastViewHashCodes$1;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.q1;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import y36.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0099\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\f*\u000b\u0016\u0019\u001c·\u0001Ô\u0001û\u0001þ\u0001\b\u0016\u0018\u0000 \u0086\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004\u0087\u0002\u0088\u0002B\t¢\u0006\u0006\b\u0084\u0002\u0010\u0085\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\u001c\u0010\u0013\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u001f\u001a\u00020\bH\u0002J\n\u0010 \u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010#\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J&\u0010(\u001a\u0004\u0018\u00010\u000f2\u0006\u0010%\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J*\u0010.\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010,H\u0016J\u0012\u0010/\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0010\u00102\u001a\u00020\b2\u0006\u00101\u001a\u000200H\u0016J\u0012\u00104\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u00010!H\u0016J\b\u00105\u001a\u00020\bH\u0016J\b\u00106\u001a\u00020\bH\u0017J\u0010\u00109\u001a\u00020\b2\u0006\u00108\u001a\u000207H\u0016J\b\u0010:\u001a\u00020\bH\u0017J)\u0010>\u001a\u00020\b\"\b\b\u0000\u0010;*\u00020\u00022\u0006\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00028\u0000H\u0017¢\u0006\u0004\b>\u0010?J\u0010\u0010B\u001a\u00020\b2\b\u0010A\u001a\u0004\u0018\u00010@J\u0010\u0010E\u001a\u00020\b2\u0006\u0010D\u001a\u00020CH\u0017J'\u0010J\u001a\u00020\b2\u000e\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060F2\u0006\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bJ\u0010KJ\b\u0010L\u001a\u00020\bH\u0016J\u0010\u0010O\u001a\u00020\b2\u0006\u0010N\u001a\u00020MH\u0016J\b\u0010P\u001a\u00020\bH\u0016J \u0010R\u001a\u00020\b2\u0016\u0010Q\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010,H\u0016J\u0010\u0010T\u001a\u00020\b2\u0006\u0010S\u001a\u00020MH\u0016J\b\u0010U\u001a\u00020MH\u0016J\b\u0010V\u001a\u00020\bH\u0016J\u0010\u0010X\u001a\u00020\b2\u0006\u0010W\u001a\u00020MH\u0016J\b\u0010Y\u001a\u00020\bH\u0016J\b\u0010Z\u001a\u00020\bH\u0016J\u0010\u0010\\\u001a\u00020\b2\u0006\u0010[\u001a\u00020MH\u0016J\b\u0010]\u001a\u00020\bH\u0016J\b\u0010^\u001a\u00020\bH\u0016J\b\u0010_\u001a\u00020\bH\u0016J\"\u0010b\u001a\u00020\b2\u0006\u0010I\u001a\u00020H2\u0006\u0010`\u001a\u00020H2\b\u0010=\u001a\u0004\u0018\u00010aH\u0016J\b\u0010c\u001a\u00020\bH\u0016J\u0010\u0010f\u001a\u00020\b2\u0006\u0010e\u001a\u00020dH\u0016J(\u0010f\u001a\u00020\b2\u0006\u0010g\u001a\u00020d2\u0006\u0010h\u001a\u00020d2\u0006\u0010i\u001a\u00020d2\u0006\u0010j\u001a\u00020dH\u0016J\u0012\u0010m\u001a\u00020\b2\b\u0010l\u001a\u0004\u0018\u00010kH\u0016J\u0010\u0010p\u001a\u00020\b2\u0006\u0010o\u001a\u00020nH\u0016J/\u0010s\u001a\u00020\b2\u0006\u0010I\u001a\u00020H2\u000e\u0010G\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060F2\u0006\u0010r\u001a\u00020qH\u0016¢\u0006\u0004\bs\u0010tJ\u0010\u0010v\u001a\u00020\b2\u0006\u0010u\u001a\u00020\u0006H\u0016J\u0010\u0010x\u001a\u00020\b2\u0006\u0010w\u001a\u00020\u0006H\u0016J\u0010\u0010z\u001a\u00020\b2\u0006\u0010y\u001a\u00020\u0006H\u0016J\u0010\u0010|\u001a\u00020\b2\u0006\u0010{\u001a\u00020\u0006H\u0016J\u0010\u0010~\u001a\u00020\b2\u0006\u0010}\u001a\u00020\u0006H\u0016J\u0012\u0010\u0081\u0001\u001a\u00020\b2\u0007\u0010\u0080\u0001\u001a\u00020\u007fH\u0016J\u0013\u0010\u0084\u0001\u001a\u00020\b2\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0016J\u0007\u0010\u0085\u0001\u001a\u00020MJ\t\u0010\u0086\u0001\u001a\u00020MH\u0016J\u0012\u0010\u0088\u0001\u001a\u00020\b2\u0007\u0010\u0087\u0001\u001a\u00020HH\u0016J\u0013\u0010\u008b\u0001\u001a\u00020M2\b\u0010\u008a\u0001\u001a\u00030\u0089\u0001H\u0016J\t\u0010\u008c\u0001\u001a\u00020MH\u0016J\t\u0010\u008d\u0001\u001a\u00020MH\u0016J\u0011\u0010\u008e\u0001\u001a\u00020\b2\u0006\u0010S\u001a\u00020MH\u0016J\u0015\u0010\u0091\u0001\u001a\u00020\b2\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0016J\t\u0010\u0092\u0001\u001a\u00020\bH\u0016J\t\u0010\u0093\u0001\u001a\u00020\u0006H\u0016J9\u0010\u0098\u0001\u001a\u00020\b\"\t\b\u0000\u0010;*\u00030\u0094\u00012\u0011\u0010\u0096\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030\u0094\u00010\u0095\u00012\u0007\u0010\u0097\u0001\u001a\u00028\u0000H\u0016¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J/\u0010\u009a\u0001\u001a\u00028\u0000\"\t\b\u0000\u0010;*\u00030\u0094\u00012\u0010\u0010\u0096\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u00028\u00000\u0095\u0001H\u0016¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J/\u0010\u009d\u0001\u001a\u00020\b\"\u0004\b\u0000\u0010;2\u000e\u0010\u0096\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0095\u00012\u0007\u0010\u009c\u0001\u001a\u00028\u0000¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\f\u0010 \u0001\u001a\u0005\u0018\u00010\u009f\u0001H\u0016J\t\u0010¡\u0001\u001a\u00020MH\u0016J\u001c\u0010¥\u0001\u001a\u00020\b2\b\u0010£\u0001\u001a\u00030¢\u00012\u0007\u0010¤\u0001\u001a\u00020\u0002H\u0016J\t\u0010¦\u0001\u001a\u00020MH\u0016R\u001c\u0010¨\u0001\u001a\u0005\u0018\u00010§\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001b\u0010ª\u0001\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R\u001c\u0010\u00ad\u0001\u001a\u0005\u0018\u00010¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R\u001c\u0010°\u0001\u001a\u0005\u0018\u00010¯\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u001c\u0010³\u0001\u001a\u0005\u0018\u00010²\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R\u0019\u0010µ\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R\u0018\u0010¸\u0001\u001a\u00030·\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R#\u0010»\u0001\u001a\f\u0012\u0005\u0012\u00030\u0082\u0001\u0018\u00010º\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u001b\u0010½\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u001c\u0010À\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u001b\u0010Â\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010¾\u0001R\u001b\u0010Ã\u0001\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u001b\u0010Å\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010¾\u0001R\u001a\u0010Ç\u0001\u001a\u00030Æ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u001b\u0010É\u0001\u001a\u0004\u0018\u00010\u007f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R\u0019\u0010Ë\u0001\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010Ì\u0001R\u0019\u0010Í\u0001\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010Î\u0001R\u0019\u0010Ï\u0001\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Ì\u0001R\u001f\u0010Ò\u0001\u001a\n\u0012\u0005\u0012\u00030Ñ\u00010Ð\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u001f\u0010Õ\u0001\u001a\n\u0012\u0005\u0012\u00030Ô\u00010Ð\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÕ\u0001\u0010Ó\u0001R\u0019\u0010Ö\u0001\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010Ì\u0001R,\u0010Ø\u0001\u001a\u0005\u0018\u00010×\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bØ\u0001\u0010Ù\u0001\u001a\u0006\bÚ\u0001\u0010Û\u0001\"\u0006\bÜ\u0001\u0010Ý\u0001R)\u0010Þ\u0001\u001a\u00020M8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÞ\u0001\u0010Î\u0001\u001a\u0006\bß\u0001\u0010à\u0001\"\u0006\bá\u0001\u0010â\u0001R\u001c\u0010ä\u0001\u001a\u0005\u0018\u00010ã\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bä\u0001\u0010å\u0001R \u0010ç\u0001\u001a\u000b æ\u0001*\u0004\u0018\u00010M0M8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bç\u0001\u0010è\u0001R\u0019\u0010é\u0001\u001a\u00020M8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bé\u0001\u0010Î\u0001R\u0018\u0010ë\u0001\u001a\u00030ê\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bë\u0001\u0010ì\u0001R\u001c\u0010î\u0001\u001a\u0005\u0018\u00010í\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bî\u0001\u0010ï\u0001R\u001c\u0010ñ\u0001\u001a\u0005\u0018\u00010ð\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bñ\u0001\u0010ò\u0001R\u001c\u0010ô\u0001\u001a\u0005\u0018\u00010ó\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bô\u0001\u0010õ\u0001R\u0018\u0010÷\u0001\u001a\u00030ö\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b÷\u0001\u0010ø\u0001R\u001c\u0010ù\u0001\u001a\u0005\u0018\u00010\u009f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bù\u0001\u0010ú\u0001R\u0018\u0010ü\u0001\u001a\u00030û\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bü\u0001\u0010ý\u0001R\u0018\u0010ÿ\u0001\u001a\u00030þ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÿ\u0001\u0010\u0080\u0002R\u0017\u0010\u0083\u0002\u001a\u0005\u0018\u00010¬\u00018F¢\u0006\b\u001a\u0006\b\u0081\u0002\u0010\u0082\u0002¨\u0006\u0089\u0002"}, d2 = {"Lcom/bytedance/android/annie/business/container/AnnieXLiveFragment;", "Lcom/bytedance/android/annie/api/container/HybridFragment;", "", "Lcom/bytedance/common/utility/collection/WeakHandler$IHandler;", "Lcom/bytedance/android/annie/card/f;", "Lcom/bytedance/android/annie/container/fragment/q;", "", "getUrl", "", "addCardAndBindEvent", "parseArgs", "bindCustomEvent", "Lcom/bytedance/android/annie/business/container/AnnieXLiveHybridComponent;", "hybridComponent", "bindCallback", "Landroid/view/View;", "customView", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "callback", "onShowCustomView4Web", "onHideCustomView4Web", "closeActivity", "com/bytedance/android/annie/business/container/AnnieXLiveFragment$f", "getContainerLifecycle", "()Lcom/bytedance/android/annie/business/container/AnnieXLiveFragment$f;", "com/bytedance/android/annie/business/container/AnnieXLiveFragment$g", "getLynxViewClient", "()Lcom/bytedance/android/annie/business/container/AnnieXLiveFragment$g;", "com/bytedance/android/annie/business/container/AnnieXLiveFragment$h", "getWebViewClient", "()Lcom/bytedance/android/annie/business/container/AnnieXLiveFragment$h;", "bindOnBackPressedCallback", "getAnnieXLiveComponent", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "onCreateView", "view", "onViewCreated", com.bytedance.android.ec.core.event.a.KEY_URL, "", "renderData", "load", "onActivityCreated", "Landroid/content/Context;", "context", "onAttach", "args", "setArguments", "release", "handRelease", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onDestroy", "T", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "data", "sendJsEventWithCache", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lcom/bytedance/android/annie/param/AnnieXLiveContext;", "annieXLiveContext", "setAnnieXLiveContext", "Lcom/bytedance/android/annie/api/container/HybridFragment$a;", "lifecycleListener", "registerLifecycleListener", "", "permissions", "", "requestCode", "requestPermissionsProxy", "([Ljava/lang/String;I)V", "closeByReplace", "", "fromPopup", "closeWithFrom", com.bytedance.android.ec.core.event.a.VALUE_CLOSE, "templateData", "reloadTemplate", "enable", "setCloseByGesture", "disableDragDown", "back", "visible", "realVisibleChange", "onStop", "onPause", "isVisibleToUser", "setUserVisibleHint", "onStart", "onResume", "onDetach", "resultCode", "Landroid/content/Intent;", "onActivityResult", "cancelLoading", "", "radius", "setRadius", "topLeft", "topRight", "bottomRight", "bottomLeft", "Landroid/os/Message;", MessageIndication.MESSAGE_TYPE_MSG, "handleMsg", "Lcom/bytedance/android/annie/bridge/method/permission/b;", "onRequestPermissionsCallBack", "registerOnRequestPermissionsCallBack", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "title", "setHybridTitle", "titleColor", "setHybridTitleColor", "navBarColor", "setHybridNavBarColor", "statusBarBgColor", "setHybridStatusBarBgColor", "statusFontMode", "setHybridStatusFontMode", "Lcom/bytedance/android/annie/api/card/IHybridComponent$b;", "l", "setOnScrollChangeListener", "Lcom/bytedance/android/annie/api/card/IHybridComponent$a;", "listener", "setJSBridgeListener", "needAdapterStatusBarColor", "pullUpAdapterStatusBar", "state", "handlePullStateChange", "Landroid/view/MotionEvent;", "event", "inIgnoreArea", "isFullScreen", "isPopup", "enableClose", "Ly6/e;", "shareInfo", "onInjectShareInfo", "onRefresh", "getBizKey", "Lcom/bytedance/android/annie/service/a;", "Ljava/lang/Class;", "clazz", "obj", "registerService", "(Ljava/lang/Class;Lcom/bytedance/android/annie/service/a;)V", "getService", "(Ljava/lang/Class;)Lcom/bytedance/android/annie/service/a;", "item", "registerWeakHolder", "(Ljava/lang/Class;Ljava/lang/Object;)V", "Lv7/b;", "getLoadingFragment", "canBackPresse", "Lcom/bytedance/android/annie/api/container/FragmentCustomMonitorKey;", "key", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "setCustomMonitorKey", "isAnnieXFragment", "Lcom/bytedance/android/annie/business/container/i;", "mAnnieXLivePopAndPageComm", "Lcom/bytedance/android/annie/business/container/i;", "mAnnieXLiveContext", "Lcom/bytedance/android/annie/param/AnnieXLiveContext;", "Lcom/bytedance/android/annie/business/ability/schema/model/b;", "_annieXLiveFragmentModel", "Lcom/bytedance/android/annie/business/ability/schema/model/b;", "Lia/d;", "mPageContainer", "Lia/d;", "Lt36/d;", "mSchemaData", "Lt36/d;", "mCurrentUrl", "Ljava/lang/String;", "com/bytedance/android/annie/business/container/AnnieXLiveFragment$mPageComponent$1", "mPageComponent", "Lcom/bytedance/android/annie/business/container/AnnieXLiveFragment$mPageComponent$1;", "", "mPendingJSBridgeListeners", "Ljava/util/List;", "mRootView", "Landroid/view/View;", "Lcom/bytedance/android/annie/view/FullscreenVideoFrame;", "mCustomLayout", "Lcom/bytedance/android/annie/view/FullscreenVideoFrame;", "mCustomView", "mCustomViewCallback", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "mNavBarShareView", "Lu7/c;", "configModel", "Lu7/c;", "mScrollListener", "Lcom/bytedance/android/annie/api/card/IHybridComponent$b;", "mHybridCardScrollY", "I", "profileShown", "Z", "preLength", "Lkotlin/Lazy;", "Lcom/bytedance/android/annie/business/container/AnnieXLiveFragment$b;", "mGlobalLayoutListener", "Lkotlin/Lazy;", "com/bytedance/android/annie/business/container/AnnieXLiveFragment$mOnAttachStateListener$1$a", "mOnAttachStateListener", "mPullUpState", "Landroid/widget/FrameLayout;", "mFloatView", "Landroid/widget/FrameLayout;", "getMFloatView", "()Landroid/widget/FrameLayout;", "setMFloatView", "(Landroid/widget/FrameLayout;)V", "mModStatusBar", "getMModStatusBar", "()Z", "setMModStatusBar", "(Z)V", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "mPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "kotlin.jvm.PlatformType", "disableWebViewLoad", "Ljava/lang/Boolean;", "isCreateBySystem", "Lio/reactivex/disposables/CompositeDisposable;", "visibleChangeDisposes", "Lio/reactivex/disposables/CompositeDisposable;", "Lm7/a;", "annieXLiveLifeCycle", "Lm7/a;", "Lm7/b;", "annieXLiveLynxViewClient", "Lm7/b;", "Lm7/c;", "annieXLiveWebViewClient", "Lm7/c;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "mLoadingSubFragmentProxy", "Lv7/b;", "com/bytedance/android/annie/business/container/AnnieXLiveFragment$backPressedCallBack$1", "backPressedCallBack", "Lcom/bytedance/android/annie/business/container/AnnieXLiveFragment$backPressedCallBack$1;", "com/bytedance/android/annie/business/container/AnnieXLiveFragment$backPressedCallbackForDetect$1", "backPressedCallbackForDetect", "Lcom/bytedance/android/annie/business/container/AnnieXLiveFragment$backPressedCallbackForDetect$1;", "getMAnnieXLiveFragmentModel", "()Lcom/bytedance/android/annie/business/ability/schema/model/b;", "mAnnieXLiveFragmentModel", "<init>", "()V", "Companion", "a", "b", "annie-mix-glue_release"}, k = 1, mv = {1, 4, 3})
public class AnnieXLiveFragment extends HybridFragment implements WeakHandler.IHandler, com.bytedance.android.annie.card.f, q {
    public static final a Companion = null;
    private static final String TAG = "AnnieXLiveFragment";
    private com.bytedance.android.annie.business.ability.schema.model.b _annieXLiveFragmentModel;
    private m7.a annieXLiveLifeCycle;
    private m7.b annieXLiveLynxViewClient;
    private m7.c annieXLiveWebViewClient;
    private final AnnieXLiveFragment$backPressedCallBack$1 backPressedCallBack;
    private final AnnieXLiveFragment$backPressedCallbackForDetect$1 backPressedCallbackForDetect;
    private u7.c configModel;
    private final Boolean disableWebViewLoad;
    private boolean isCreateBySystem;
    private AnnieXLiveContext mAnnieXLiveContext;
    private com.bytedance.android.annie.business.container.i mAnnieXLivePopAndPageComm;
    private String mCurrentUrl;
    private FullscreenVideoFrame mCustomLayout;
    private View mCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private FrameLayout mFloatView;
    private final Lazy<b> mGlobalLayoutListener;
    private int mHybridCardScrollY;
    private v7.b mLoadingSubFragmentProxy;
    private boolean mModStatusBar;
    private View mNavBarShareView;
    private final Lazy<AnnieXLiveFragment$mOnAttachStateListener$1.a> mOnAttachStateListener;
    private final AnnieXLiveFragment$mPageComponent$1 mPageComponent;
    private ia.d mPageContainer;
    private List<IHybridComponent.a> mPendingJSBridgeListeners;
    private ViewTreeObserver.OnPreDrawListener mPreDrawListener;
    private int mPullUpState;
    private View mRootView;
    private t36.d mSchemaData;
    private IHybridComponent.b mScrollListener;
    private final Handler mainHandler;
    private int preLength;
    private boolean profileShown;
    private final CompositeDisposable visibleChangeDisposes;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final WeakReference<AnnieXLiveFragment> a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            AnnieXLiveFragment r0 = this.a.get();
            int r10 = 0;
            if (r0 == null) goto L13;
            FragmentActivity r1 = r0.getActivity();
            if (r1 == null) goto L13;
            Resources r11 = r1.getResources();
            if (r11 == null) goto L13;
            Configuration r12 = r11.getConfiguration();
            if (r12 == null) goto L13;
            if (r12.orientation != 2) goto L13;
            boolean r13 = true;
        L14:
            AnnieXLiveFragment r14 = this.a.get();
            if (r14 == null) goto L42;
            Integer r15 = null;
            if (r13 == false) goto L21;
            View r16 = r14.getView();
            if (r16 == null) goto L25;
            int r17 = r16.getWidth();
        L24:
            r15 = Integer.valueOf(r17);
        L25:
            if (r15 == null) goto L28;
            r10 = r15.intValue();
        L28:
            if (AnnieXLiveFragment.access$getPreLength$p(r14) != 0) goto L32;
            AnnieXLiveFragment.access$setPreLength$p(r14, r10);
            return;
        L32:
            if (AnnieXLiveFragment.access$getPreLength$p(r14) == r10) goto L43;
            AnnieXLiveFragment.access$setProfileShown$p(r14, true);
            ia.d r18 = AnnieXLiveFragment.access$getMPageContainer$p(r14);
            if (r18 == null) goto L36;
            r18.hideLoading();
        L36:
            View r19 = r14.getView();
            if (r19 == null) goto L44;
            ViewTreeObserver r20 = r19.getViewTreeObserver();
            if (r20 == null) goto L45;
            r20.removeOnGlobalLayoutListener(this);
            return;
        L45:
            return;
        L44:
            return;
        L43:
            return;
        L21:
            View r21 = r14.getView();
            if (r21 == null) goto L25;
            r17 = r21.getHeight();
            goto L24
        L42:
            return;
        L13:
            r13 = false;
            goto L14
        }

        public b(WeakReference<AnnieXLiveFragment> r10) {
            Intrinsics.checkNotNullParameter(r10, "fragment");
            this.a = r10;
        }
    }

    public static final class c implements IHybridComponent.b {
        public final /* synthetic */ AnnieXLiveFragment a;

        public c(AnnieXLiveFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.annie.api.card.IHybridComponent.b
        public final void a(WebComponent r10, int r11, int r12, int r13, int r14) {
            AnnieXLiveFragment.access$setMHybridCardScrollY$p(this.a, r12);
            if (r12 > 0) goto L5;
            if (r12 != 0) goto L15;
            ia.d r0 = AnnieXLiveFragment.access$getMPageContainer$p(this.a);
            if (r0 == null) goto L15;
            r0.f(false);
        L15:
            IHybridComponent.b r1 = AnnieXLiveFragment.access$getMScrollListener$p(this.a);
            if (r1 == null) goto L19;
            r1.a(r10, r11, r12, r13, r14);
            return;
        L19:
            return;
        L5:
            if (AnnieXLiveFragment.access$getMPullUpState$p(this.a) != 3) goto L7;
        L8:
            ia.d r15 = AnnieXLiveFragment.access$getMPageContainer$p(this.a);
            if (r15 == null) goto L15;
            r15.f(true);
            goto L15
        L7:
            if (this.a.isFullScreen() == false) goto L15;
            goto L8
        }
    }

    public static final class d extends com.bytedance.android.annie.card.web.e {
        public final /* synthetic */ AnnieXLiveFragment b;

        @Override // com.bytedance.android.annie.card.web.e
        public final void r() {
            AnnieXLiveFragment.access$onHideCustomView4Web(this.b);
        }

        public d(AnnieXLiveFragment r1) {
            this.b = r1;
            super(null);
        }

        @Override // com.bytedance.android.annie.card.web.e
        public final void A(WebView r10) {
            Intrinsics.checkNotNullParameter(r10, "webView");
            com.bytedance.android.annie.util.c.a("on webview created");
            Intrinsics.checkNotNullParameter(r10, "webView");
        }

        @Override // com.bytedance.android.annie.card.web.e
        public final void z(View r10, WebChromeClient.CustomViewCallback r11) {
            AnnieXLiveFragment.access$onShowCustomView4Web(this.b, r10, r11);
        }
    }

    public static final class e implements FullscreenVideoFrame.a {
        public final /* synthetic */ AnnieXLiveFragment a;

        public e(AnnieXLiveFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.annie.view.FullscreenVideoFrame.a
        public final void onHideFullscreenVideoFrame() {
            AnnieXLiveFragment.access$onHideCustomView4Web(this.a);
        }
    }

    public static final class f extends com.bytedance.android.anniex.base.lifecycle.a {
        public final /* synthetic */ AnnieXLiveFragment a;

        public f(AnnieXLiveFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void a(String r10, ia.c r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r11, "container");
            super.a(r10, r11);
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void e(String r10, ia.c r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r11, "container");
            super.e(r10, r11);
            com.bytedance.android.annie.business.container.i r0 = AnnieXLiveFragment.access$getMAnnieXLivePopAndPageComm$p(this.a);
            if (r0 == null) goto L8;
            com.bytedance.android.annie.business.container.j r1 = r0.q;
            if (r1 == null) goto L9;
            r1.e(r10, r11);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void h(String r10, ia.c r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r11, "container");
            super.h(r10, r11);
            com.bytedance.android.annie.business.container.i r0 = AnnieXLiveFragment.access$getMAnnieXLivePopAndPageComm$p(this.a);
            if (r0 == null) goto L8;
            com.bytedance.android.annie.business.container.j r1 = r0.q;
            if (r1 == null) goto L9;
            r1.h(r10, r11);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void i(String r10, ia.c r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r11, "container");
            super.i(r10, r11);
            com.bytedance.android.annie.business.container.i r0 = AnnieXLiveFragment.access$getMAnnieXLivePopAndPageComm$p(this.a);
            if (r0 == null) goto L8;
            com.bytedance.android.annie.business.container.j r1 = r0.q;
            if (r1 == null) goto L8;
            r1.i(r10, r11);
        L8:
            if (AnnieConfigSettingKeys.ANNIEX_FIX_FRAGMENT_WEB_BG_COLOR.a().booleanValue() == false) goto L18;
            t36.d r12 = AnnieXLiveFragment.access$getMSchemaData$p(this.a);
            if (r12 == null) goto L19;
            String r13 = (String) ((y36.i) new p(r12, "web_bg_color", null)).b;
            Integer r14 = (Integer) ((y36.i) new y36.d(r12, "bundle_web_view_background_color", null)).b;
            View r15 = r11.getKitView();
            if (r15 == null) goto L20;
            if (r14 == null) goto L15;
            int r16 = r14.intValue();
        L16:
            r15.setBackgroundColor(com.bytedance.android.annie.container.fragment.n.a(r13, r16, 0));
            return;
        L15:
            r16 = -1;
            goto L16
        L20:
            return;
        L19:
            return;
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void c(String r10, AnnieXContainer r11, Throwable r12) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r11, "container");
            Intrinsics.checkNotNullParameter(r12, "throwable");
            super.c(r10, r11, r12);
            com.bytedance.android.annie.business.container.i r0 = AnnieXLiveFragment.access$getMAnnieXLivePopAndPageComm$p(this.a);
            if (r0 == null) goto L8;
            com.bytedance.android.annie.business.container.j r1 = r0.q;
            if (r1 == null) goto L9;
            r1.c(r10, r11, r12);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void g(String r10, ia.c r11, Throwable r12) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r11, "container");
            Intrinsics.checkNotNullParameter(r12, "throwable");
            super.g(r10, r11, r12);
            com.bytedance.android.annie.business.container.i r0 = AnnieXLiveFragment.access$getMAnnieXLivePopAndPageComm$p(this.a);
            if (r0 == null) goto L8;
            com.bytedance.android.annie.business.container.j r1 = r0.q;
            if (r1 == null) goto L9;
            r1.g(r10, r11, r12);
            return;
        L9:
            return;
        }
    }

    public static final class g extends q1 {
        public g() {
        }
    }

    public static final class h extends WebViewClient {
        public final /* synthetic */ AnnieXLiveFragment a;

        public h(AnnieXLiveFragment r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r10, String r11) {
            super.onPageFinished(r10, r11);
            com.bytedance.android.annie.business.container.i r0 = AnnieXLiveFragment.access$getMAnnieXLivePopAndPageComm$p(this.a);
            if (r0 == null) goto L8;
            n r1 = r0.r;
            if (r1 == null) goto L9;
            r1.onPageFinished(r10, r11);
            return;
        L9:
            return;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView r10, String r11, Bitmap r12) {
            super.onPageStarted(r10, r11, r12);
            com.bytedance.android.annie.business.container.i r0 = AnnieXLiveFragment.access$getMAnnieXLivePopAndPageComm$p(this.a);
            if (r0 == null) goto L8;
            n r1 = r0.r;
            if (r1 == null) goto L9;
            r1.onPageStarted(r10, r11, r12);
            return;
        L9:
            return;
        }
    }

    public static final class i implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ AnnieXLiveFragment b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            AnnieXLiveFragment.access$addCardAndBindEvent(this.b);
            return true;
        }

        public i(View r1, AnnieXLiveFragment r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ AnnieXLiveFragment a;

        public j(AnnieXLiveFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Integer r10 = (Integer) r1;
            com.bytedance.android.annie.business.container.i r11 = AnnieXLiveFragment.access$getMAnnieXLivePopAndPageComm$p(this.a);
            if (r11 == null) goto L6;
            r11.onStop();
            return;
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ AnnieXLiveFragment a;

        public k(AnnieXLiveFragment r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            HybridLogger r0 = HybridLogger.a;
            k7.a.a(AnnieXLiveFragment.TAG, ((Throwable) r10).toString(), AnnieXLiveFragment.access$getMAnnieXLiveContext$p(this.a));
        }
    }

    static {
        Companion = new a();
    }

    public void handleMsg(Message r1) {
    }

    public void handlePullStateChange(int r1) {
    }

    public boolean inIgnoreArea(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        return false;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public boolean isAnnieXFragment() {
        return true;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public boolean isFullScreen() {
        return true;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment, com.bytedance.android.annie.api.card.IHybridComponent
    public boolean isPopup() {
        return false;
    }

    @Override // com.bytedance.android.annie.card.f
    public void onRefresh() {
    }

    public boolean pullUpAdapterStatusBar() {
        return false;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    @Deprecated(message = "该回调由WebComponent 触发，融合容器不需要")
    public void registerLifecycleListener(HybridFragment.a r10) {
        Intrinsics.checkNotNullParameter(r10, "lifecycleListener");
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    @Deprecated(message = "没有业务调用，已废弃")
    public <T> void sendJsEventWithCache(String r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "data");
    }

    private final void addCardAndBindEvent() {
        HybridLogger r0 = HybridLogger.a;
        Map r1 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, getUrl()));
        AnnieXLiveContext r10 = this.mAnnieXLiveContext;
        com.bytedance.ies.bullet.base.utils.logger.a r11 = null;
        if (r10 == null) goto L5;
        com.bytedance.ies.bullet.base.utils.logger.a r12 = r10.getLogContext();
    L6:
        HybridLogger.k(TAG, "addCardAndBindEvent", r1, r12);
        Context r13 = getContext();
        if (r13 == null) goto L35;
        ia.d r14 = this.mPageContainer;
        if (r14 == null) goto L35;
        com.bytedance.android.annie.business.ability.schema.model.b r15 = this._annieXLiveFragmentModel;
        if (r15 == null) goto L27;
        AnnieXLiveContext r16 = this.mAnnieXLiveContext;
        if (r16 == null) goto L27;
        setMAnnieCard(new AnnieXLiveHybridComponent(r13, r14, r15, r16));
        com.bytedance.android.annie.business.container.i r17 = this.mAnnieXLivePopAndPageComm;
        if (r17 == null) goto L17;
        IHybridComponent r18 = getMAnnieCard();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.bytedance.android.annie.business.container.AnnieXLiveHybridComponent");
        r17.n = (AnnieXLiveHybridComponent) r18;
    L17:
        AnnieXLiveHybridComponent r19 = getAnnieXLiveComponent();
        if (r19 == null) goto L24;
        bindCustomEvent();
        bindCallback(r19);
        r19.e(this.mPendingJSBridgeListeners);
        JSBridgeManager r20 = r19.g;
        if (r20 == null) goto L24;
        com.bytedance.android.annie.business.container.i r21 = this.mAnnieXLivePopAndPageComm;
        if (r21 == null) goto L24;
        r21.n(r20, this);
    L24:
        AnnieFragmentManager.d(containerId(), this);
        AnnieXLiveHybridComponent r22 = getAnnieXLiveComponent();
        if (r22 == null) goto L27;
        a7.a.a(r22, this.mCurrentUrl, null, 2);
        Unit r23 = Unit.INSTANCE;
    L28:
        if (r23 != null) goto L35;
        Map r24 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MSG, "addCardAndBindEvent:_annieXLiveFragmentModel is null"));
        AnnieXLiveContext r25 = this.mAnnieXLiveContext;
        if (r25 == null) goto L32;
        com.bytedance.ies.bullet.base.utils.logger.a r26 = r25.getLogContext();
    L33:
        HybridLogger.g(TAG, "_annieXLiveFragmentModel_init_error", r24, r26);
        goto L35
    L32:
        r26 = null;
    L27:
        r23 = null;
    L35:
        if (getAnnieXLiveComponent() != null) goto L40;
        Map r27 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MSG, "onViewCreated: AnnieXLiveComponent create fail"));
        AnnieXLiveContext r28 = this.mAnnieXLiveContext;
        if (r28 == null) goto L39;
        r11 = r28.getLogContext();
    L39:
        HybridLogger.g(TAG, "AnnieXLiveComponent_create_error", r27, r11);
        Unit r29 = Unit.INSTANCE;
    L40:
        com.bytedance.android.annie.business.container.i r30 = this.mAnnieXLivePopAndPageComm;
        if (r30 == null) goto L44;
        r30.c();
        return;
    L44:
        return;
    L5:
        r12 = null;
        goto L6
    }

    private final void bindCustomEvent() {
        FullscreenVideoFrame r0 = this.mCustomLayout;
        if (r0 == null) goto L6;
        r0.setListener(new e(this));
        return;
    }

    private final void bindOnBackPressedCallback() {
        if (this.mPageContainer == null) goto L10;
        AnnieXBlankDetectorManager$lastViewHashCodes$1 r0 = AnnieXBlankDetectorManager.a;
        if (AnnieXBlankDetectorManager.a(this.mSchemaData) == null) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
        setEnabled(true);
        goto L10
    L7:
        r1 = false;
    L10:
        requireActivity().getOnBackPressedDispatcher().addCallback(this, this.backPressedCallbackForDetect);
        requireActivity().getOnBackPressedDispatcher().addCallback(this, this.backPressedCallBack);
    }

    private final void closeActivity() {
        com.bytedance.android.annie.business.ability.schema.model.b r0 = this._annieXLiveFragmentModel;
        if (r0 == null) goto L5;
        String r1 = r0.c();
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r10 = true;
    L12:
        if (r10 == false) goto L17;
        FragmentActivity r11 = getActivity();
        if (r11 == null) goto L25;
        r11.finish();
        return;
    L25:
        return;
    L17:
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(UriProtector.parse(r1), "intercept_back"), "1") == false) goto L21;
        AnnieXLiveHybridComponent r12 = getAnnieXLiveComponent();
        if (r12 == null) goto L27;
        r12.sendJsEvent("H5_webcastPageQuit", new JSONObject());
        return;
    L27:
        return;
    L21:
        FragmentActivity r13 = getActivity();
        if (r13 == null) goto L29;
        r13.finish();
        return;
    L29:
        return;
    L8:
        if (StringsKt.isBlank(r1) == true) goto L11;
        r10 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    private final f getContainerLifecycle() {
        return new f(this);
    }

    private final g getLynxViewClient() {
        return new g();
    }

    private final h getWebViewClient() {
        return new h(this);
    }

    private final void onHideCustomView4Web() {
        HybridLogger.m(TAG, "===onHideCustomView===", null, null, 12);
        if (this.mCustomView != null) goto L5;
        this.mCustomViewCallback = null;
        return;
    L5:
        ia.d r0 = this.mPageContainer;
        if (r0 == null) goto L8;
        r0.f(false);
    L8:
        FullscreenVideoFrame r1 = this.mCustomLayout;
        if (r1 == null) goto L15;
        r1.setVisibility(8);
        r1.removeView(this.mCustomView);
        this.mCustomView = null;
        UIUtils.requestOrienation(getActivity(), false);
        WebChromeClient.CustomViewCallback r10 = this.mCustomViewCallback;
        if (r10 == null) goto L16;
        r10.onCustomViewHidden();
        return;
    L16:
        return;
    }

    private final void parseArgs() {
        Bundle r10 = getArguments();
        com.bytedance.ies.bullet.base.utils.logger.a r11 = null;
        if (r10 == null) goto L9;
        String r12 = r10.getString("annie_x_inner_bundle_schema");
        if (r12 == null) goto L7;
        this.mCurrentUrl = r12;
        Uri r13 = UriProtector.parse(r12);
    L8:
        if (r13 == null) goto L9;
    L10:
        Uri r14 = r13;
        ia.d r15 = this.mPageContainer;
        if (r15 == null) goto L13;
        t36.d r16 = r15.generateSchemaData(this.mCurrentUrl);
    L14:
        this.mSchemaData = r16;
        if (r16 == null) goto L17;
        Lazy r17 = SchemaService.f;
        SchemaService.a.a().getClass();
        this._annieXLiveFragmentModel = (com.bytedance.android.annie.business.ability.schema.model.b) SchemaService.d(r16, com.bytedance.android.annie.business.ability.schema.model.b.class);
    L17:
        boolean r18 = true;
        if (this.mAnnieXLiveContext != null) goto L28;
        this.isCreateBySystem = true;
        Bundle r19 = getArguments();
        if (r19 == null) goto L22;
        r19.putBoolean("container_has_recreated", true);
        Unit r20 = Unit.INSTANCE;
        Bundle r21 = r19;
    L23:
        AnnieXLiveContext r22 = new AnnieXLiveContext(r14, null, r21, null, null, 24, null);
        h8.c r23 = new h8.c(null);
        r23.onInit(r22);
        r23.onBeforeOpenContainer();
        com.bytedance.android.annie.business.ability.schema.model.b r24 = this._annieXLiveFragmentModel;
        if (r24 == null) goto L26;
        String r25 = r24.b();
    L27:
        r23.onPrepareInitDataStart(r25, "", false);
        r22.setCommonLifecycle(r23);
        this.mAnnieXLiveContext = r22;
        goto L28
    L26:
        r25 = "";
        goto L27
    L22:
        r21 = null;
    L28:
        ia.d r26 = this.mPageContainer;
        if (r26 == null) goto L31;
        this.mAnnieXLivePopAndPageComm = new com.bytedance.android.annie.business.container.i(requireActivity(), r26, this.mAnnieXLiveContext);
    L31:
        com.bytedance.android.annie.business.container.i r27 = this.mAnnieXLivePopAndPageComm;
        if (r27 == null) goto L34;
        r27.o = this._annieXLiveFragmentModel;
    L34:
        IHybridComponent.HybridType r28 = hybridType();
        IHybridComponent.HybridType r29 = IHybridComponent.HybridType.LYNX;
        if (r28 == r29) goto L38;
        r18 = false;
    L38:
        this.configModel = new u7.c(r18, com.bytedance.android.annie.ng.g.b().c.a);
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L63
        com.bytedance.android.annie.business.ability.schema.model.b r31 = this._annieXLiveFragmentModel;     // Catch: Throwable -> L63
        if (r31 == null) goto L60;
        String r32 = r31.c();     // Catch: Throwable -> L63
        com.bytedance.android.annie.business.ability.schema.model.b r33 = this._annieXLiveFragmentModel;     // Catch: Throwable -> L63
        if (r33 == null) goto L44;
        String r34 = r33.b();     // Catch: Throwable -> L63
    L46:
        if (hybridType() != r29) goto L48;
    L59:
        Unit r35 = Unit.INSTANCE;     // Catch: Throwable -> L63
    L61:
        Object r36 = Result.constructor-impl(r35);     // Catch: Throwable -> L63
    L65:
        Throwable r37 = Result.exceptionOrNull-impl(r36);
        if (r37 == null) goto L72;
        HybridLogger r38 = HybridLogger.a;
        Map r0 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MSG, r37.toString()));
        AnnieXLiveContext r39 = this.mAnnieXLiveContext;
        if (r39 == null) goto L70;
        com.bytedance.ies.bullet.base.utils.logger.a r40 = r39.getLogContext();
    L71:
        HybridLogger.g(TAG, "AnnieXLiveFragment_parseArgs_error", r0, r40);
        ExecutorService r1 = com.bytedance.ies.bullet.service.monitor.a.a;
        com.bytedance.ies.bullet.service.monitor.a.d(null, containerId(), "AnnieXLiveFragment parseArgs error: " + r37.getMessage());
        goto L72
    L70:
        r40 = null;
    L72:
        HybridLogger r41 = HybridLogger.a;
        Map r42 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, getUrl()));
        AnnieXLiveContext r43 = this.mAnnieXLiveContext;
        if (r43 == null) goto L75;
        r11 = r43.getLogContext();
    L75:
        HybridLogger.k(TAG, "parse_args", r42, r11);
        return;
    L48:
        if (LiveSecLinkManager.b(r32, r34, getBizKey()) == false) goto L59;
        HybridLogger r44 = HybridLogger.a;     // Catch: Throwable -> L63
        Map r45 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MSG, "invalid scheme " + r34));     // Catch: Throwable -> L63
        AnnieXLiveContext r46 = this.mAnnieXLiveContext;     // Catch: Throwable -> L63
        if (r46 == null) goto L52;
        com.bytedance.ies.bullet.base.utils.logger.a r47 = r46.getLogContext();     // Catch: Throwable -> L63
    L53:
        HybridLogger.g(TAG, "invalid_scheme", r45, r47);     // Catch: Throwable -> L63
        AnnieXLiveContext r48 = this.mAnnieXLiveContext;     // Catch: Throwable -> L63
        if (r48 == null) goto L58;
        b7.b r49 = r48.getCommonLifecycle();     // Catch: Throwable -> L63
        if (r49 == null) goto L58;
        r49.onContainerError(null, 500, "invalid scheme " + r34);     // Catch: Throwable -> L63
    L58:
        close();     // Catch: Throwable -> L63
        goto L59
    L52:
        r47 = null;
        goto L53
    L44:
        r34 = null;
        goto L46
    L60:
        r35 = null;
    L63:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        r36 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L65
    L13:
        r16 = null;
        goto L14
    L7:
        r13 = null;
    L9:
        r13 = Uri.EMPTY;
        goto L10
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public boolean canBackPresse() {
        ia.d r0 = this.mPageContainer;
        if (r0 == null) goto L5;
        AnnieXBlankDetectorManager$lastViewHashCodes$1 r1 = AnnieXBlankDetectorManager.a;
        AnnieXBlankDetectorManager.c(r0.getKitView(), this.mSchemaData);
    L5:
        ia.d r10 = this.mPageContainer;
        if (r10 == null) goto L8;
        boolean r11 = r10.canBackPress();
    L9:
        if (r11 == true) goto L11;
        setEnabled(true);
    L11:
        return r11;
    L8:
        r11 = true;
        goto L9
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public void cancelLoading() {
        ia.d r0 = this.mPageContainer;
        if (r0 == null) goto L6;
        r0.hideLoading();
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public boolean disableDragDown() {
        if (this.mHybridCardScrollY <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public String getBizKey() {
        AnnieXLiveContext r0 = this.mAnnieXLiveContext;
        if (r0 == null) goto L6;
        String r1 = r0.getBizKey();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "host";
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    @Deprecated(message = "不建议使用，请联系@jintai.001", replaceWith = @ReplaceWith(expression = "release()", imports = {}))
    public void handRelease() {
        com.bytedance.android.annie.business.container.i r0 = this.mAnnieXLivePopAndPageComm;
        if (r0 == null) goto L6;
        r0.p();
        return;
    }

    public final boolean needAdapterStatusBarColor() {
        if (AnnieConfigSettingKeys.ENABLE_PULL_UP_ADAPTER_STATUS_BAR.a().booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (pullUpAdapterStatusBar() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment, com.bytedance.android.annie.api.card.IHybridComponent
    public void release() {
        com.bytedance.android.annie.business.container.i r0 = this.mAnnieXLivePopAndPageComm;
        if (r0 == null) goto L6;
        r0.p();
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.annie.business.container.AnnieXLiveFragment$mPageComponent$1] */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.bytedance.android.annie.business.container.AnnieXLiveFragment$backPressedCallBack$1] */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.bytedance.android.annie.business.container.AnnieXLiveFragment$backPressedCallbackForDetect$1] */
    public AnnieXLiveFragment() {
        this.mCurrentUrl = "";
        this.mPageComponent = new AnnieXLiveFragment$mPageComponent$1(this);
        this.configModel = new u7.c(false, false);
        this.mGlobalLayoutListener = LazyKt.lazy(new AnnieXLiveFragment$mGlobalLayoutListener$1(this));
        this.mOnAttachStateListener = LazyKt.lazy(new AnnieXLiveFragment$mOnAttachStateListener$1(this));
        this.mPullUpState = -1;
        this.disableWebViewLoad = AnnieConfigSettingKeys.DISABLE_WEB_VIEW_RETRY_RESOURCE.a();
        this.visibleChangeDisposes = new CompositeDisposable();
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.backPressedCallBack = new AnnieXLiveFragment$backPressedCallBack$1(this);
        this.backPressedCallbackForDetect = new AnnieXLiveFragment$backPressedCallbackForDetect$1(this);
    }

    private final AnnieXLiveHybridComponent getAnnieXLiveComponent() {
        IHybridComponent r0 = getMAnnieCard();
        if ((r0 instanceof AnnieXLiveHybridComponent) == true) goto L7;
        return null;
    L7:
        return (AnnieXLiveHybridComponent) r0;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public void back() {
        AnnieXLiveHybridComponent r0 = getAnnieXLiveComponent();
        if (r0 == null) goto L6;
        r0.goBack();
        return;
    }

    public void onDestroy() {
        super.onDestroy();
        this.annieXLiveLifeCycle = null;
        this.annieXLiveLynxViewClient = null;
        this.annieXLiveWebViewClient = null;
        this.mPendingJSBridgeListeners = null;
        View r0 = this.mRootView;
        if (r0 == null) goto L5;
        r0.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener) this.mOnAttachStateListener.getValue());
    L5:
        ViewTreeObserver.OnPreDrawListener r1 = this.mPreDrawListener;
        if (r1 == null) goto L13;
        View r10 = this.mRootView;
        if (r10 == null) goto L13;
        ViewTreeObserver r11 = r10.getViewTreeObserver();
        if (r11 == null) goto L13;
        r11.removeOnPreDrawListener(r1);
    L13:
        if (needAdapterStatusBarColor() == true) goto L15;
    L21:
        com.bytedance.android.annie.business.container.i r12 = this.mAnnieXLivePopAndPageComm;
        if (r12 == null) goto L24;
        r12.onDestroy();
    L24:
        release();
        return;
    L15:
        if (com.bytedance.android.annie.ng.g.g == false) goto L21;
        com.bytedance.android.annie.ng.g.b().getClass();
        if (com.bytedance.android.annie.ng.e.a.k == false) goto L21;
        if (this.mModStatusBar == false) goto L21;
        com.bytedance.android.annie.util.i.h(getActivity());
        this.mModStatusBar = false;
        goto L21
    }

    public void onDetach() {
        super.onDetach();
        this.visibleChangeDisposes.dispose();
        com.bytedance.android.annie.business.container.i r0 = this.mAnnieXLivePopAndPageComm;
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    public void onPause() {
        super.onPause();
        com.bytedance.android.annie.business.container.i r0 = this.mAnnieXLivePopAndPageComm;
        if (r0 == null) goto L6;
        r0.onPause();
        return;
    }

    public void onResume() {
        super.onResume();
        com.bytedance.android.annie.business.container.i r0 = this.mAnnieXLivePopAndPageComm;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    public void onStart() {
        super.onStart();
        com.bytedance.android.annie.business.container.i r0 = this.mAnnieXLivePopAndPageComm;
        if (r0 == null) goto L6;
        r0.onStart();
        return;
    }

    public void onStop() {
        super.onStop();
        this.visibleChangeDisposes.add(Observable.just(1).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this), new k(this)));
    }

    private final String getUrl() {
        return this.mCurrentUrl;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void close() {
        closeActivity();
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public void closeByReplace() {
        closeActivity();
    }

    @Override // com.bytedance.android.annie.container.fragment.q
    public v7.b getLoadingFragment() {
        return this.mLoadingSubFragmentProxy;
    }

    public final com.bytedance.android.annie.business.ability.schema.model.b getMAnnieXLiveFragmentModel() {
        return this._annieXLiveFragmentModel;
    }

    public final FrameLayout getMFloatView() {
        return this.mFloatView;
    }

    public final boolean getMModStatusBar() {
        return this.mModStatusBar;
    }

    public static final /* synthetic */ void access$addCardAndBindEvent(AnnieXLiveFragment r0) {
        r0.addCardAndBindEvent();
    }

    public static final /* synthetic */ AnnieXLiveFragment$backPressedCallBack$1 access$getBackPressedCallBack$p(AnnieXLiveFragment r0) {
        return r0.backPressedCallBack;
    }

    public static final /* synthetic */ u7.c access$getConfigModel$p(AnnieXLiveFragment r0) {
        return r0.configModel;
    }

    public static final /* synthetic */ f access$getContainerLifecycle(AnnieXLiveFragment r0) {
        return r0.getContainerLifecycle();
    }

    public static final /* synthetic */ g access$getLynxViewClient(AnnieXLiveFragment r0) {
        return r0.getLynxViewClient();
    }

    public static final /* synthetic */ AnnieXLiveContext access$getMAnnieXLiveContext$p(AnnieXLiveFragment r0) {
        return r0.mAnnieXLiveContext;
    }

    public static final /* synthetic */ com.bytedance.android.annie.business.container.i access$getMAnnieXLivePopAndPageComm$p(AnnieXLiveFragment r0) {
        return r0.mAnnieXLivePopAndPageComm;
    }

    public static final /* synthetic */ Lazy access$getMGlobalLayoutListener$p(AnnieXLiveFragment r0) {
        return r0.mGlobalLayoutListener;
    }

    public static final /* synthetic */ ia.d access$getMPageContainer$p(AnnieXLiveFragment r0) {
        return r0.mPageContainer;
    }

    public static final /* synthetic */ int access$getMPullUpState$p(AnnieXLiveFragment r0) {
        return r0.mPullUpState;
    }

    public static final /* synthetic */ View access$getMRootView$p(AnnieXLiveFragment r0) {
        return r0.mRootView;
    }

    public static final /* synthetic */ t36.d access$getMSchemaData$p(AnnieXLiveFragment r0) {
        return r0.mSchemaData;
    }

    public static final /* synthetic */ IHybridComponent.b access$getMScrollListener$p(AnnieXLiveFragment r0) {
        return r0.mScrollListener;
    }

    public static final /* synthetic */ int access$getPreLength$p(AnnieXLiveFragment r0) {
        return r0.preLength;
    }

    public static final /* synthetic */ h access$getWebViewClient(AnnieXLiveFragment r0) {
        return r0.getWebViewClient();
    }

    public static final /* synthetic */ com.bytedance.android.annie.business.ability.schema.model.b access$get_annieXLiveFragmentModel$p(AnnieXLiveFragment r0) {
        return r0._annieXLiveFragmentModel;
    }

    public static final /* synthetic */ void access$onHideCustomView4Web(AnnieXLiveFragment r0) {
        r0.onHideCustomView4Web();
    }

    private final void bindCallback(AnnieXLiveHybridComponent r10) {
        HybridLogger r0 = HybridLogger.a;
        k7.a.b(TAG, "bindAnnieCardCallbackNew: " + getUrl(), this.mAnnieXLiveContext);
        c r1 = new c(this);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r1, "l");
        if (AnnieConfigSettingKeys.ENABLE_ANNIEX_WEB_SHOW_CUSTOMVIEW.a().booleanValue() == true) goto L5;
        return;
    L5:
        if (r10.hybridType() != IHybridComponent.HybridType.H5) goto L9;
        r10.registerLifecycleCallback(new d(this));
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public void closeWithFrom(boolean r1) {
        close();
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public void enableClose(boolean r10) {
        ia.d r0 = this.mPageContainer;
        if (r0 == null) goto L6;
        r0.interceptBackPress(!r10);
        return;
    }

    public <T extends com.bytedance.android.annie.service.a> T getService(Class<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        return (T) Annie.getService(r10, getBizKey());
    }

    public void onActivityCreated(Bundle r10) {
        super.onActivityCreated(r10);
        com.bytedance.android.annie.business.container.i r0 = this.mAnnieXLivePopAndPageComm;
        if (r0 == null) goto L6;
        r0.onActivityCreated(r10);
    L6:
        if (AnnieConfigSettingKeys.ENABLE_FIX_SCREEN_HEIGHT.a().booleanValue() == true) goto L8;
    L15:
        addCardAndBindEvent();
        return;
    L8:
        if (isFullScreen() == false) goto L15;
        View r11 = this.mRootView;
        if (r11 == null) goto L12;
        this.mPreDrawListener = new i(r11, this);
        r11.getViewTreeObserver().addOnPreDrawListener(this.mPreDrawListener);
        Unit r12 = Unit.INSTANCE;
    L13:
        if (r12 != null) goto L17;
        addCardAndBindEvent();
        return;
    L17:
        return;
    L12:
        r12 = null;
        goto L13
    }

    public void onAttach(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super.onAttach(r10);
        com.bytedance.android.anniex.assemble.a r11 = com.bytedance.android.anniex.assemble.a.a;
        Function1<com.bytedance.android.anniex.base.builder.b, Unit> r12 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r12, "block");
        com.bytedance.android.anniex.base.builder.b r0 = new com.bytedance.android.anniex.base.builder.b();
        r12.invoke(r0);
        com.bytedance.android.anniex.container.c r13 = new com.bytedance.android.anniex.container.c(r0);
        m7.a r1 = this.annieXLiveLifeCycle;
        if (r1 == null) goto L5;
        r1.d = r13;
    L5:
        m7.b r14 = this.annieXLiveLynxViewClient;
        if (r14 == null) goto L8;
        r14.d = r13;
    L8:
        m7.c r15 = this.annieXLiveWebViewClient;
        if (r15 == null) goto L11;
        r15.d = r13;
    L11:
        r13.l(this.mPageComponent);
        this.mPageContainer = r13;
        AnnieXLiveContext r16 = this.mAnnieXLiveContext;
        if (r16 == null) goto L16;
        b7.b r17 = r16.getCommonLifecycle();
        if (r17 == null) goto L16;
        r17.onContainerInitEnd();
    L16:
        ia.d r18 = this.mPageContainer;
        if (r18 == null) goto L19;
        r18.onAttachToWindow();
    L19:
        HybridLogger r19 = HybridLogger.a;
        AnnieXLiveContext r20 = this.mAnnieXLiveContext;
        if (r20 == null) goto L22;
        com.bytedance.ies.bullet.base.utils.logger.a r21 = r20.getLogContext();
    L23:
        HybridLogger.k(TAG, "container_init_end", null, r21);
        return;
    L22:
        r21 = null;
        goto L23
    }

    public void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        super.onConfigurationChanged(r10);
        com.bytedance.android.annie.business.container.i r0 = this.mAnnieXLivePopAndPageComm;
        if (r0 == null) goto L6;
        r0.onConfigurationChanged(r10);
        return;
    }

    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        com.bytedance.ies.bullet.base.utils.logger.a r11 = null;
        if (com.bytedance.android.annie.ng.g.g == true) goto L9;
        HybridLogger r12 = HybridLogger.a;
        Map r13 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MSG, "===onCreate: 未初始化直播"));
        AnnieXLiveContext r0 = this.mAnnieXLiveContext;
        if (r0 == null) goto L7;
        r11 = r0.getLogContext();
    L7:
        HybridLogger.g(TAG, "AnnieManager_init_error", r13, r11);
        return;
    L9:
        HybridLogger r1 = HybridLogger.a;
        AnnieXLiveContext r14 = this.mAnnieXLiveContext;
        if (r14 == null) goto L12;
        com.bytedance.ies.bullet.base.utils.logger.a r15 = r14.getLogContext();
    L13:
        HybridLogger.k(TAG, "on_create", null, r15);
        ia.d r16 = this.mPageContainer;
        if (r16 == null) goto L16;
        r16.onCreate(r10);
    L16:
        parseArgs();
        if (this.mAnnieXLiveContext != null) goto L23;
        Map r17 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MSG, "mAnnieXLiveContext is null"));
        AnnieXLiveContext r18 = this.mAnnieXLiveContext;
        if (r18 == null) goto L21;
        com.bytedance.ies.bullet.base.utils.logger.a r19 = r18.getLogContext();
    L22:
        HybridLogger.g(TAG, "mAnnieXLiveContext_init_error", r17, r19);
        ExecutorService r20 = com.bytedance.ies.bullet.service.monitor.a.a;
        com.bytedance.ies.bullet.service.monitor.a.d(null, containerId(), "AnnieXLiveFragment mAnnieXLiveContext is null");
        Unit r21 = Unit.INSTANCE;
        goto L23
    L21:
        r19 = null;
    L23:
        com.bytedance.android.annie.business.ability.schema.model.b r22 = this._annieXLiveFragmentModel;
        if (r22 == null) goto L30;
        String r23 = r22.c();
        Set<String> r24 = SlardarMonitorUtils.a;
        if (hybridType() != IHybridComponent.HybridType.LYNX) goto L28;
        String r25 = "lynx";
    L29:
        SlardarMonitorUtils.a(r23, this, r25);
        goto L30
    L28:
        r25 = "H5";
    L30:
        com.bytedance.android.annie.business.ability.schema.model.b r26 = this._annieXLiveFragmentModel;
        if (r26 == null) goto L33;
        String r27 = r26.c();
    L34:
        if (r27 != null) goto L40;
        Map r28 = MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MSG, "mAnnieXLiveFragmentModel.url is null"));
        AnnieXLiveContext r29 = this.mAnnieXLiveContext;
        if (r29 == null) goto L38;
        com.bytedance.ies.bullet.base.utils.logger.a r30 = r29.getLogContext();
    L39:
        HybridLogger.g(TAG, "mAnnieXLiveFragmentModel_url_error", r28, r30);
        ExecutorService r31 = com.bytedance.ies.bullet.service.monitor.a.a;
        com.bytedance.ies.bullet.service.monitor.a.d(null, containerId(), "AnnieXLiveFragment mAnnieXLiveFragmentModel.url is null");
        goto L40
    L38:
        r30 = null;
    L40:
        bindOnBackPressedCallback();
        return;
    L33:
        r27 = null;
        goto L34
    L12:
        r15 = null;
        goto L13
    }

    @Override // com.bytedance.android.annie.card.f
    public void onInjectShareInfo(y6.e r10) {
        View r11 = this.mNavBarShareView;
        if (r11 == null) goto L7;
        r11.setVisibility(0);
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public void realVisibleChange(boolean r10) {
        ia.d r0 = this.mPageContainer;
        if (r0 == null) goto L6;
        r0.onVisibleChange(r10, Boolean.FALSE);
        return;
    }

    @Override // com.bytedance.android.annie.container.fragment.q
    public void registerOnRequestPermissionsCallBack(com.bytedance.android.annie.bridge.method.permission.b r10) {
        Intrinsics.checkNotNullParameter(r10, "onRequestPermissionsCallBack");
        com.bytedance.android.annie.business.container.i r1 = this.mAnnieXLivePopAndPageComm;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r10, "onRequestPermissionsCallBack");
        r1.g = r10;
        return;
    }

    public void reloadTemplate(Map<String, ? extends Object> r10) {
        com.bytedance.android.annie.business.container.i r0 = this.mAnnieXLivePopAndPageComm;
        if (r0 == null) goto L8;
        AnnieXLiveHybridComponent r1 = r0.n;
        if (r1 == null) goto L9;
        r1.b.reloadTemplate(r10);
        return;
    L9:
        return;
    }

    public final void setAnnieXLiveContext(AnnieXLiveContext r10) {
        this.mAnnieXLiveContext = r10;
        com.bytedance.android.annie.business.container.i r0 = this.mAnnieXLivePopAndPageComm;
        if (r0 == null) goto L7;
        if (r10 == null) goto L8;
        r0.c = r10;
        return;
    L8:
        return;
    }

    public void setArguments(Bundle r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.getString("annie_x_inner_bundle_schema") == null) goto L8;
        super.setArguments(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public void setCloseByGesture(boolean r10) {
        com.bytedance.android.annie.business.container.i r0 = this.mAnnieXLivePopAndPageComm;
        if (r0 == null) goto L6;
        r0.b.interceptBackPress(!r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public void setHybridNavBarColor(String r10) {
        Intrinsics.checkNotNullParameter(r10, "navBarColor");
        ia.d r0 = this.mPageContainer;
        if (r0 == null) goto L6;
        r0.e(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public void setHybridStatusBarBgColor(String r10) {
        Intrinsics.checkNotNullParameter(r10, "statusBarBgColor");
        ia.d r0 = this.mPageContainer;
        if (r0 == null) goto L6;
        r0.c(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public void setHybridStatusFontMode(String r10) {
        Intrinsics.checkNotNullParameter(r10, "statusFontMode");
        ia.d r0 = this.mPageContainer;
        if (r0 == null) goto L6;
        r0.setStatusFontMode(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public void setHybridTitle(String r10) {
        Intrinsics.checkNotNullParameter(r10, "title");
        ia.d r0 = this.mPageContainer;
        if (r0 == null) goto L6;
        r0.setTitle(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public void setHybridTitleColor(String r10) {
        Intrinsics.checkNotNullParameter(r10, "titleColor");
        ia.d r0 = this.mPageContainer;
        if (r0 == null) goto L6;
        r0.p(r10);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void setJSBridgeListener(IHybridComponent.a r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        com.bytedance.android.annie.business.container.i r0 = this.mAnnieXLivePopAndPageComm;
        if (r0 == null) goto L5;
        r0.q(r10);
        return;
    L5:
        List<IHybridComponent.a> r1 = this.mPendingJSBridgeListeners;
        if (r1 == null) goto L8;
        r1.add(r10);
        return;
    L8:
        this.mPendingJSBridgeListeners = CollectionsKt.mutableListOf(new IHybridComponent.a[]{r10});
    }

    public final void setMFloatView(FrameLayout r1) {
        this.mFloatView = r1;
    }

    public final void setMModStatusBar(boolean r1) {
        this.mModStatusBar = r1;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment, com.bytedance.android.annie.api.card.IHybridComponent
    public void setOnScrollChangeListener(IHybridComponent.b r10) {
        Intrinsics.checkNotNullParameter(r10, "l");
        this.mScrollListener = r10;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment, a7.b
    public void setRadius(float r1) {
        getAnnieXLiveComponent();
    }

    public void setUserVisibleHint(boolean r10) {
        super.setUserVisibleHint(r10);
        com.bytedance.android.annie.business.container.i r0 = this.mAnnieXLivePopAndPageComm;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(r10);
        return;
    }

    public static final /* synthetic */ void access$setAnnieXLiveLifeCycle$p(AnnieXLiveFragment r0, m7.a r1) {
        r0.annieXLiveLifeCycle = r1;
    }

    public static final /* synthetic */ void access$setAnnieXLiveLynxViewClient$p(AnnieXLiveFragment r0, m7.b r1) {
        r0.annieXLiveLynxViewClient = r1;
    }

    public static final /* synthetic */ void access$setAnnieXLiveWebViewClient$p(AnnieXLiveFragment r0, m7.c r1) {
        r0.annieXLiveWebViewClient = r1;
    }

    public static final /* synthetic */ void access$setMHybridCardScrollY$p(AnnieXLiveFragment r0, int r1) {
        r0.mHybridCardScrollY = r1;
    }

    public static final /* synthetic */ void access$setMLoadingSubFragmentProxy$p(AnnieXLiveFragment r0, v7.b r1) {
        r0.mLoadingSubFragmentProxy = r1;
    }

    public static final /* synthetic */ void access$setPreLength$p(AnnieXLiveFragment r0, int r1) {
        r0.preLength = r1;
    }

    public static final /* synthetic */ void access$setProfileShown$p(AnnieXLiveFragment r0, boolean r1) {
        r0.profileShown = r1;
    }

    private final void onShowCustomView4Web(View r10, WebChromeClient.CustomViewCallback r11) {
        HybridLogger.m(TAG, "===onShowCustomView===", null, null, 12);
        com.bytedance.android.annie.ng.a r0 = com.bytedance.android.annie.ng.g.c.get(getBizKey());
        if (r0 == null) goto L9;
        o8.h r1 = r0.a;
        if (r1 == null) goto L9;
        if (r1.c == true) goto L9;
        boolean r12 = true;
    L10:
        if (r12 == false) goto L13;
        return;
    L13:
        if (this.mCustomView == null) goto L17;
        if (r11 == null) goto L31;
        r11.onCustomViewHidden();
        return;
    L31:
        return;
    L17:
        ia.d r13 = this.mPageContainer;
        if (r13 == null) goto L20;
        r13.f(false);
    L20:
        this.mCustomViewCallback = r11;
        FullscreenVideoFrame r14 = this.mCustomLayout;
        if (r14 == null) goto L23;
        r14.addView(r10);
    L23:
        this.mCustomView = r10;
        UIUtils.requestOrienation(getActivity(), true);
        FullscreenVideoFrame r15 = this.mCustomLayout;
        if (r15 == null) goto L27;
        r15.setVisibility(0);
    L27:
        FullscreenVideoFrame r16 = this.mCustomLayout;
        if (r16 == null) goto L32;
        r16.requestFocus();
        return;
    L32:
        return;
    L9:
        r12 = false;
        goto L10
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment, com.bytedance.android.annie.api.card.IHybridComponent
    public void load(String r10, Map<String, ? extends Object> r11) {
        setCustomMonitorKey(FragmentCustomMonitorKey.HasReload, Integer.valueOf(isLoaded() ? 1 : 0));
        HybridLogger r0 = HybridLogger.a;
        k7.a.b(TAG, "load: " + getUrl(), this.mAnnieXLiveContext);
        super.load(r10, r11);
    }

    public void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        com.bytedance.android.annie.business.container.i r0 = this.mAnnieXLivePopAndPageComm;
        if (r0 == null) goto L6;
        r0.b(r10, r11);
        return;
    }

    public <T extends com.bytedance.android.annie.service.a> void registerService(Class<? extends com.bytedance.android.annie.service.a> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Intrinsics.checkNotNullParameter(r11, "obj");
        Annie.registerService(r10, r11, getBizKey());
    }

    public final <T> void registerWeakHolder(Class<T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        ia.d r0 = this.mPageContainer;
        if (r0 == null) goto L6;
        r0.registerWeakHolder(r10, r11);
        return;
    }

    @Override // com.bytedance.android.annie.container.fragment.q
    public void requestPermissionsProxy(String[] r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "permissions");
        super.requestPermissions(r10, r11);
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment
    public void setCustomMonitorKey(FragmentCustomMonitorKey r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        com.bytedance.android.annie.business.container.i r12 = this.mAnnieXLivePopAndPageComm;
        if (r12 == null) goto L51;
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        AnnieXLiveContext r0 = r12.c;
        if (r0 == null) goto L7;
        String r1 = r0.getMonitorID();
    L8:
        Intrinsics.checkNotNull(r1);
        k9.d r13 = ((k9.e) r12.e(k9.e.class)).V0();
        HybridLogger r14 = HybridLogger.a;
        k7.a.b("AnnieXLivePopAndPageComm", "setCustomMonitorKey " + r10 + ", value: " + r11 + ", monitorId: " + r1, r12.c);
        int r15 = com.bytedance.android.annie.business.container.i.b.a[r10.ordinal()];
        if (r15 == 1) goto L40;
        if (r15 != 2) goto L13;
        r13.d(r1, "is_container_preload", r11.toString());
        AnnieXLiveContext r16 = r12.c;
        if (r16 == null) goto L61;
        Bundle r17 = r16.getBundle();
        if (r17 == null) goto L62;
        r17.putString("is_container_preload", r11.toString());
        return;
    L62:
        return;
    L61:
        return;
    L13:
        if (r15 != 3) goto L15;
        r13.d(r1, "is_user_open", r11.toString());
        AnnieXLiveContext r18 = r12.c;
        if (r18 == null) goto L58;
        Bundle r19 = r18.getBundle();
        if (r19 == null) goto L59;
        r19.putString("is_user_open", r11.toString());
        return;
    L59:
        return;
    L58:
        return;
    L15:
        if (r15 != 4) goto L17;
        r13.d(r1, "is_prerender", r11.toString());
        AnnieXLiveContext r20 = r12.c;
        if (r20 == null) goto L55;
        Bundle r21 = r20.getBundle();
        if (r21 == null) goto L56;
        r21.putString("is_prerender", r11.toString());
        return;
    L56:
        return;
    L55:
        return;
    L17:
        if (r15 != 5) goto L67;
        r13.d(r1, "has_reload", r11.toString());
        AnnieXLiveContext r22 = r12.c;
        if (r22 == null) goto L52;
        Bundle r23 = r22.getBundle();
        if (r23 == null) goto L53;
        r23.putString("has_reload", r11.toString());
        return;
    L53:
        return;
    L52:
        return;
    L67:
        return;
    L40:
        if (r12.s == true) goto L68;
        r12.s = true;
        if ((r11 instanceof Long) == false) goto L49;
        Number r24 = (Number) r11;
        r13.c(r1, "open_time", r24.longValue());
        AnnieXLiveContext r25 = r12.c;
        if (r25 == null) goto L64;
        Bundle r26 = r25.getBundle();
        if (r26 == null) goto L65;
        r26.putLong("real_open_time", r24.longValue());
        return;
    L65:
        return;
    L64:
        return;
    L49:
        k7.a.b("AnnieXLivePopAndPageComm", "setCustomMonitorKey " + r10 + ", typeof value is not Long, do nothing", r12.c);
        return;
    L68:
        return;
    L7:
        r1 = null;
        goto L8
    }

    public static final /* synthetic */ void access$onShowCustomView4Web(AnnieXLiveFragment r0, View r1, WebChromeClient.CustomViewCallback r10) {
        r0.onShowCustomView4Web(r1, r10);
    }

    public void onActivityResult(int r10, int r11, Intent r12) {
        super.onActivityResult(r10, r11, r12);
        com.bytedance.android.annie.business.container.i r0 = this.mAnnieXLivePopAndPageComm;
        if (r0 == null) goto L6;
        r0.onActivityResult(r10, r11, r12);
        return;
    }

    public View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        View r13 = r10.inflate(2131558567, r11, false);
        r13.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) this.mOnAttachStateListener.getValue());
        this.mRootView = r13;
        this.mCustomLayout = (FullscreenVideoFrame) r13.findViewById(2131363001);
        com.bytedance.android.annie.business.container.i r14 = this.mAnnieXLivePopAndPageComm;
        if (r14 == null) goto L5;
        r14.a(this.mRootView);
    L5:
        this.mFloatView = (FrameLayout) r13.findViewById(2131372985);
        return r13;
    }

    public void onRequestPermissionsResult(int r10, String[] r11, int[] r12) {
        Intrinsics.checkNotNullParameter(r11, "permissions");
        Intrinsics.checkNotNullParameter(r12, "grantResults");
        super.onRequestPermissionsResult(r10, r11, r12);
        com.bytedance.android.annie.business.container.i r0 = this.mAnnieXLivePopAndPageComm;
        if (r0 == null) goto L6;
        r0.k(r10, r11, r12);
        return;
    }

    @Override // com.bytedance.android.annie.api.container.HybridFragment, a7.b
    public void setRadius(float r1, float r10, float r11, float r12) {
        getAnnieXLiveComponent();
    }
}
