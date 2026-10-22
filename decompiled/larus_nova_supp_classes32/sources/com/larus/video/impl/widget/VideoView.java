package com.larus.video.impl.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyCharacterMap;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common_ui.view.ActivityIndicatorView;
import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.media.MediaLevel;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MixPriority;
import com.larus.media.o0;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.p0;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.lynx.xelement.overlay.LynxUIOverlay;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.DataSource;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.utils.Error;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000ñ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b)*\u0001W\u0018\u0000 ±\u00012\u00020\u0001:\u000e°\u0001±\u0001²\u0001³\u0001´\u0001µ\u0001¶\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010l\u001a\u00020\u000f2\u0006\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u00072\u0006\u0010o\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\u0007H\u0014J\b\u0010q\u001a\u00020\u000fH\u0014J\b\u0010r\u001a\u00020\u000fH\u0014J\u0006\u0010s\u001a\u00020\u0007J8\u0010t\u001a\u00020\u000f2\u0006\u0010u\u001a\u00020@2\b\u0010v\u001a\u0004\u0018\u00010E2\b\u0010w\u001a\u0004\u0018\u00010G2\b\u0010x\u001a\u0004\u0018\u00010>2\n\b\u0002\u0010y\u001a\u0004\u0018\u000106J8\u0010z\u001a\u00020\u000f2\u0006\u0010u\u001a\u00020@2\b\u0010v\u001a\u0004\u0018\u00010E2\b\u0010w\u001a\u0004\u0018\u00010G2\b\u0010x\u001a\u0004\u0018\u00010>2\n\b\u0002\u0010y\u001a\u0004\u0018\u000106J\u0006\u0010{\u001a\u00020\u000fJ\b\u0010|\u001a\u00020\u000fH\u0002J\u0010\u0010}\u001a\u00020\u000f2\u0006\u0010w\u001a\u00020GH\u0002J\b\u0010~\u001a\u00020\u000fH\u0002J\b\u0010\u007f\u001a\u00020\u000fH\u0002J\u0019\u0010\u0080\u0001\u001a\u00020\u000f2\u0007\u0010\u0081\u0001\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u00020\u0007J\u0007\u0010\u0083\u0001\u001a\u00020\u0017J\u0007\u0010\u0084\u0001\u001a\u00020\u0017J\u0007\u0010\u0085\u0001\u001a\u00020\u000fJ\u0011\u0010\u0089\u0001\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001cJ\u0011\u0010\u008a\u0001\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001cJ\u001c\u0010\u008b\u0001\u001a\u00020\u000f2\u0007\u0010\u008c\u0001\u001a\u00020\u00072\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001J\u0007\u0010\u008f\u0001\u001a\u00020\u000fJ\u0007\u0010\u0090\u0001\u001a\u00020\u000fJ\u0016\u0010\u0091\u0001\u001a\u00020\u000f2\r\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014JU\u0010\u0093\u0001\u001a\u00020\u000f2L\u0010\u0092\u0001\u001aG\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u000f0\u0016J+\u0010\u0094\u0001\u001a\u00020\u000f2\"\u0010\u0092\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000f0\u000bJ+\u0010\u0095\u0001\u001a\u00020\u000f2\"\u0010\u0092\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u000f0\u000bJ+\u0010\u0096\u0001\u001a\u00020\u000f2\"\u0010\u0092\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000f0\u000bJ+\u0010\u0097\u0001\u001a\u00020\u000f2\"\u0010\u0092\u0001\u001a\u001d\u0012\u0013\u0012\u00110$¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000f0\u000bJ+\u0010\u0098\u0001\u001a\u00020\u000f2\"\u0010\u0092\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u000f0\u000bJ+\u0010\u0099\u0001\u001a\u00020\u000f2\"\u0010\u0092\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000f0\u000bJ+\u0010\u009a\u0001\u001a\u00020\u000f2\"\u0010\u0092\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000bJ+\u0010\u009b\u0001\u001a\u00020\u000f2\"\u0010\u0092\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000f0\u000bJ\u0007\u0010\u009c\u0001\u001a\u00020\u001cJ\u0007\u0010\u009d\u0001\u001a\u00020\u001cJ\u0007\u0010\u009e\u0001\u001a\u00020\u000fJ\t\u0010\u009f\u0001\u001a\u00020\u000fH\u0002J\t\u0010 \u0001\u001a\u00020\u000fH\u0002J\u0012\u0010¡\u0001\u001a\u00020\u001c2\u0007\u0010¢\u0001\u001a\u00020$H\u0016J\u001b\u0010£\u0001\u001a\u00020\u000f2\u0007\u0010\u0081\u0001\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u00020\u0007H\u0002J\u0007\u0010¤\u0001\u001a\u00020\u000fJ\t\u0010¥\u0001\u001a\u00020\u000fH\u0002J\u0010\u0010¦\u0001\u001a\u00020\u000f2\u0007\u0010§\u0001\u001a\u00020\u0007J\t\u0010¨\u0001\u001a\u00020\u000fH\u0002J\t\u0010©\u0001\u001a\u00020\u000fH\u0002J\u0012\u0010ª\u0001\u001a\u00020\u000f2\u0007\u0010«\u0001\u001a\u00020TH\u0002J\t\u0010¬\u0001\u001a\u00020\u001cH\u0002J\u0012\u0010\u00ad\u0001\u001a\u00020\u000f2\u0007\u0010«\u0001\u001a\u00020TH\u0002J\t\u0010®\u0001\u001a\u00020\u000fH\u0002J\t\u0010¯\u0001\u001a\u00020\u000fH\u0002R+\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000RU\u0010\u0015\u001aI\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u001e\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010!\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010#\u001a\u001f\u0012\u0013\u0012\u00110$¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\u00020\u0007X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\bB\u0010CR\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010J\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010R\u001a\u0016\u0012\u0004\u0012\u00020T\u0018\u00010Sj\n\u0012\u0004\u0012\u00020T\u0018\u0001`UX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010XR\u000e\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010_\u001a\u0004\u0018\u00010`X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u000e\u0010j\u001a\u00020kX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0086\u0001\u001a\u00020\u001cX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010L\"\u0005\b\u0088\u0001\u0010N¨\u0006·\u0001"}, d2 = {"Lcom/larus/video/impl/widget/VideoView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOnLoadStateChanged", "Lkotlin/Function1;", "Lkotlin/ParameterName;", EasyGoDbTable.Server.NAME, "loadState", NameKeys.UnloadStrategy_No_Strategy, "mOnBufferingUpdate", "percent", "mOnPlayingProgressUpdate", "mOnVideoPlay", "Lkotlin/Function0;", "mOnVideoStop", "Lkotlin/Function3;", NameKeys.UnloadStrategy_No_Strategy, "currentPlaybackTime", "duration", "completionCount", "mOnVideoResume", NameKeys.UnloadStrategy_No_Strategy, "byUser", "mOnVideoLoop", "count", "mOnVideoPause", "mOnVideoCompletion", "videoDuration", "mOnDoubleClick", "Landroid/view/MotionEvent;", "e", "mVideoView", "Landroid/view/TextureView;", "mCoverView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "mPlayButton", "Landroid/widget/ImageView;", "mLoadingView", "Lcom/larus/common_ui/view/ActivityIndicatorView;", "mSurface", "Landroid/view/Surface;", "mViewAspectRatio", NameKeys.UnloadStrategy_No_Strategy, "mVideoAspectRatio", "mVideoDataSource", "Lcom/larus/video/impl/widget/VideoView$VideoDataSource;", "mVideoId", NameKeys.UnloadStrategy_No_Strategy, "mCoverImageUrl", "mVideoLocalUrl", "mVideoUrl", "mVideoCacheKey", "mVideoModel", "Lcom/larus/platform/api/IFlowVideoModel;", "mMediaEntity", "Lcom/larus/platform/uimodel/MediaEntity;", "mVideoViewHolder", "Lcom/larus/video/impl/widget/VideoViewHolder;", "mPlayType", "getMPlayType$annotations", "()V", "mVideoController", "Lcom/larus/platform/api/IVideoController;", "mVideoEngine", "Lcom/ss/ttvideoengine/TTVideoEngine;", "mCompletionCount", "mShouldBePlaying", "allowGesture", "getAllowGesture", "()Z", "setAllowGesture", "(Z)V", "mMainHandler", "Landroid/os/Handler;", "mExecutingActions", "mPendingActions", "Ljava/util/ArrayList;", "Ljava/lang/Runnable;", "Lkotlin/collections/ArrayList;", "mSurfaceTextureListener", "com/larus/video/impl/widget/VideoView$mSurfaceTextureListener$1", "Lcom/larus/video/impl/widget/VideoView$mSurfaceTextureListener$1;", "mGestureDetector", "Landroid/view/GestureDetector;", "mProgressUpdateTask", "Lcom/larus/video/impl/widget/VideoView$ProgressUpdateTask;", "mOnPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "afterClickCallBack", "Lcom/larus/video/impl/widget/VideoView$AfterClickCallBack;", "getAfterClickCallBack", "()Lcom/larus/video/impl/widget/VideoView$AfterClickCallBack;", "setAfterClickCallBack", "(Lcom/larus/video/impl/widget/VideoView$AfterClickCallBack;)V", "dataChange", "getDataChange", "()Lkotlin/jvm/functions/Function0;", "setDataChange", "(Lkotlin/jvm/functions/Function0;)V", "mediaApplicant", "Lcom/larus/media/model/MediaRequestApplicant;", "onSizeChanged", "w", "h", "oldw", "oldh", "onAttachedToWindow", "onDetachedFromWindow", "getPlayType", "bindVideo", "videoViewHolder", "videoController", "videoEngine", "videoEntity", "category", "bindVideoWithViewModel", "start", "realStart", "resetSurfaceAndPlay", "requestFirstStreamData", "retryStart", "setVideoAspectRatio", "width", "height", "getCurrentPlaybackTime", "getDuration", "stop", "mResumeOrPauseByUser", "getMResumeOrPauseByUser", "setMResumeOrPauseByUser", "resume", "pause", "seekTo", "msec", "listener", "Lcom/ss/ttvideoengine/SeekCompletionListener;", "showLoading", "hideLoading", "onVideoPlay", "block", "onVideoStop", "onVideoResume", "onVideoLoop", "onVideoPause", "onDoubleClick", "onVideoCompletion", "onBufferingUpdate", "onLoadStateChanged", "onPlayingProgressUpdate", "isPlaying", "isPaused", "onSingleTap", "updateProgress", "resetViewVisible", "onTouchEvent", "event", "fitCoverImage", "loadCoverImage", "fitVideoSize", "setPlayButtonVisible", LynxUIOverlay.PROP_VISIBLE, "fitVideoViewSize", "abandonAudioFocus", "execAction", "action", "isSurfaceValid", "enqueueAction", "execPendingActions", "clearPendingActions", "AfterClickCallBack", "Companion", "PlayType", "VideoDataSource", "EngineListener", "ProgressUpdateTask", "GestureDetectorListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoView extends FrameLayout {
    public static boolean G;
    public e A;
    public final com.larus.video.impl.widget.c B;
    public a C;
    public Function0<Unit> D;
    public final com.larus.media.model.a E;
    public boolean F;
    public Function1<? super Integer, Unit> a;
    public Function1<? super Integer, Unit> b;
    public final TextureView c;
    public final SimpleDraweeView d;
    public final ImageView e;
    public final ActivityIndicatorView f;
    public Surface g;
    public float h;
    public float i;
    public f j;
    public String k;
    public String l;
    public String m;
    public String n;
    public p0 o;
    public MediaEntity p;
    public VideoViewHolder q;
    public int r;
    public IVideoController s;
    public TTVideoEngine t;
    public boolean u;
    public boolean v;
    public final Handler w;
    public boolean x;
    public ArrayList<Runnable> y;
    public final GestureDetector z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/larus/video/impl/widget/VideoView$PlayType;", NameKeys.UnloadStrategy_No_Strategy, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PlayType {
    }

    public interface a {
        void onPause();

        void onPlay();
    }

    public static final class b {
    }

    public static final class c implements VideoEngineCallback {
        public final VideoView a;

        public final /* synthetic */ String getEncryptedLocalTime() {
            return VideoEngineCallback.-CC.$default$getEncryptedLocalTime(this);
        }

        public final /* synthetic */ void onABRPredictBitrate(int r1, int r2) {
            VideoEngineCallback.-CC.$default$onABRPredictBitrate(this, r1, r2);
        }

        public final /* synthetic */ void onAVBadInterlaced(Map r1) {
            VideoEngineCallback.-CC.$default$onAVBadInterlaced(this, r1);
        }

        public final /* synthetic */ void onBufferEnd(int r1) {
            VideoEngineCallback.-CC.$default$onBufferEnd(this, r1);
        }

        public final /* synthetic */ void onCurrentPlaybackTimeUpdate(TTVideoEngine r1, int r2) {
            VideoEngineCallback.-CC.$default$onCurrentPlaybackTimeUpdate(this, r1, r2);
        }

        public final /* synthetic */ void onFirstAVSyncFrame(TTVideoEngine r1) {
            VideoEngineCallback.-CC.$default$onFirstAVSyncFrame(this, r1);
        }

        public final /* synthetic */ void onFrameAboutToBeRendered(TTVideoEngine r1, int r2, long r3, long r5, Map r7) {
            VideoEngineCallback.-CC.$default$onFrameAboutToBeRendered(this, r1, r2, r3, r5, r7);
        }

        public final /* synthetic */ void onFrameDraw(int r1, Map r2) {
            VideoEngineCallback.-CC.$default$onFrameDraw(this, r1, r2);
        }

        public final /* synthetic */ void onInfoIdChanged(int r1) {
            VideoEngineCallback.-CC.$default$onInfoIdChanged(this, r1);
        }

        public final /* synthetic */ void onPlayUrlChanged(int r1, String r2, String r3) {
            VideoEngineCallback.-CC.$default$onPlayUrlChanged(this, r1, r2, r3);
        }

        public final void onPrepare(TTVideoEngine r1) {
        }

        public final void onPrepared(TTVideoEngine r1) {
        }

        public final /* synthetic */ void onReadyForDisplay(TTVideoEngine r1) {
            VideoEngineCallback.-CC.$default$onReadyForDisplay(this, r1);
        }

        public final /* synthetic */ void onRefreshSurface(TTVideoEngine r1) {
            VideoEngineCallback.-CC.$default$onRefreshSurface(this, r1);
        }

        public final /* synthetic */ void onSARChanged(int r1, int r2) {
            VideoEngineCallback.-CC.$default$onSARChanged(this, r1, r2);
        }

        public final /* synthetic */ int onSetSurface(TTVideoEngine r1, VideoSurface r2, Surface r3) {
            return VideoEngineCallback.-CC.$default$onSetSurface(this, r1, r2, r3);
        }

        public final /* synthetic */ void onSilenceDetected(TTVideoEngine r1) {
            VideoEngineCallback.-CC.$default$onSilenceDetected(this, r1);
        }

        public final /* synthetic */ void onVideoSecondFrame(TTVideoEngine r1) {
            VideoEngineCallback.-CC.$default$onVideoSecondFrame(this, r1);
        }

        public final /* synthetic */ void onVideoStreamBitrateChanged(Resolution r1, int r2) {
            VideoEngineCallback.-CC.$default$onVideoStreamBitrateChanged(this, r1, r2);
        }

        public final /* synthetic */ void onVideoURLRouteFailed(Error r1, String r2) {
            VideoEngineCallback.-CC.$default$onVideoURLRouteFailed(this, r1, r2);
        }

        public final void onCompletion(TTVideoEngine r4) {
            FLogger.a.d("VideoView", "onCompletion");
            VideoView r0 = this.a;
            boolean r1 = VideoView.G;
            r0.getClass();
            this.a.getClass();
            if (r4 == null) goto L7;
            boolean r2 = true;
            if (r4.getLooping(true) != true) goto L7;
        L8:
            if (r2 == false) goto L10;
            this.a.getClass();
            return;
        L10:
            if (r4 == null) goto L12;
            r4.play();
        L12:
            this.a.getClass();
            return;
        L7:
            r2 = false;
            goto L8
        }

        public final void onError(Error r4) {
            FLogger.a.d("VideoView", "onError: " + r4);
        }

        public final void onRenderStart(TTVideoEngine r2) {
            VideoView r3 = this.a;
            boolean r0 = VideoView.G;
            r3.getClass();
            VideoView.b(this.a);
            this.a.f.setVisibility(8);
            this.a.d.setVisibility(8);
        }

        public final void onVideoStatusException(int r4) {
            FLogger.a.d("VideoView", "onVideoStatusException: " + r4);
            this.a.post(new j(this));
        }

        public c(VideoView r1, p0 r2) {
            Intrinsics.checkNotNullParameter(r1, "view");
            this.a = r1;
        }

        public final void onBufferingUpdate(TTVideoEngine r1, int r2) {
            Function1<? super Integer, Unit> r3 = this.a.a;
            if (r3 == null) goto L6;
            r3.invoke(Integer.valueOf(r2));
            return;
        }

        public final void onLoadStateChanged(TTVideoEngine r3, int r4) {
            FLogger.a.d("VideoView", "onLoadStateChanged: " + r4);
            VideoView r5 = this.a;
            boolean r0 = VideoView.G;
            r5.getClass();
            if (r4 != 1) goto L5;
            this.a.f.setVisibility(8);
            return;
        L5:
            if (r4 != 2) goto L7;
            VideoView r6 = this.a;
            r6.e.setVisibility(8);
            r6.f.setVisibility(0);
            if (NetworkUtils.isNetworkAvailable(this.a.getContext()) == true) goto L16;
            t19.s r7 = t19.s.a;
            Context r8 = this.a.getContext();
            String r1 = this.a.getContext().getResources().getString(2131906741);
            r7.getClass();
            t19.s.c(r8, r1);
            return;
        L16:
            return;
        L7:
            if (r4 != 3) goto L18;
            VideoView.a(this.a);
            return;
        }

        public final void onPlaybackStateChanged(TTVideoEngine r3, int r4) {
            FLogger.a.d("VideoView", "onPlaybackStateChanged: " + r4);
            if (r4 != 0) goto L5;
        L13:
            VideoView r5 = this.a;
            boolean r6 = VideoView.G;
            r5.getClass();
            Lazy r7 = MediaResourceManager.a;
            MediaResourceManager.a(r5.E);
            this.a.getClass();
            return;
        L5:
            if (r4 != 1) goto L7;
            this.a.e.setVisibility(8);
            this.a.f.setVisibility(8);
            this.a.getClass();
            return;
        L7:
            if (r4 == 2) goto L13;
            if (r4 != 3) goto L17;
            VideoView.a(this.a);
            return;
        }

        public final void onStreamChanged(TTVideoEngine r3, int r4) {
            FLogger.a.d("VideoView", "onStreamChanged: " + r4);
        }

        public final void onBufferStart(int r4, int r5, int r6) {
            VideoEngineCallback.-CC.$default$onBufferStart(this, r4, r5, r6);
            FLogger.a.d("VideoView", "Stuttering  REASON : " + r4 + " TIME : " + r5 + "ACTION : " + r6);
        }

        public final void onVideoSizeChanged(TTVideoEngine r2, int r3, int r4) {
            VideoView r5 = this.a;
            boolean r6 = VideoView.G;
            if (r5.h <= r5.i) goto L7;
            TTVideoEngine r7 = r5.t;
            if (r7 == null) goto L11;
            r7.setIntOption(4, 2);
            return;
        L11:
            return;
        L7:
            TTVideoEngine r8 = r5.t;
            if (r8 == null) goto L13;
            r8.setIntOption(4, 0);
            return;
        }
    }

    public static final class d extends GestureDetector.SimpleOnGestureListener {
        public final VideoView a;
        public long b;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            return true;
        }

        public d(VideoView r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r3, "e");
            this.b = System.currentTimeMillis();
            VideoView r0 = this.a;
            boolean r1 = VideoView.G;
            r0.getClass();
            return super.onDoubleTap(r3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r6) {
            Intrinsics.checkNotNullParameter(r6, "e");
            if ((System.currentTimeMillis() - this.b) <= 500) goto L6;
            this.a.f();
        L6:
            return super.onSingleTapConfirmed(r6);
        }
    }

    public static final class e implements Runnable {
        public final VideoView a;

        @Override // java.lang.Runnable
        public final void run() {
            VideoView.b(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(VideoView r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
        }
    }

    public static final class f implements DataSource {
        public final String a;
        public final long b;
        public final String c;

        public final String apiForFetcher(Map<String, String> r1, int r2) {
            return NameKeys.UnloadStrategy_No_Strategy;
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof f) == true) goto L8;
            return false;
        L8:
            f r9 = (f) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            String r3 = this.c;
            if (r3 != null) goto L5;
            int r4 = 0;
        L7:
            return r2 + r4;
        L5:
            r4 = r3.hashCode();
            goto L7
        }

        public final String toString() {
            return "VideoDataSource(videoID=" + this.a + ", itemId=" + this.b + ", category=" + this.c + ')';
        }

        public f(String r3) {
            Intrinsics.checkNotNullParameter(NameKeys.UnloadStrategy_No_Strategy, "videoID");
            this.a = NameKeys.UnloadStrategy_No_Strategy;
            this.b = 0;
            this.c = r3;
        }
    }

    public static final class g implements TextureView.SurfaceTextureListener {
        public final /* synthetic */ VideoView a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
        }

        public g(VideoView r1) {
            this.a = r1;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
            r2.release();
            Surface r3 = this.a.g;
            if (r3 == null) goto L5;
            r3.release();
        L5:
            this.a.g = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "surface");
            VideoView r6 = this.a;
            boolean r7 = VideoView.G;
            Surface r8 = r6.g;
            if (r8 != null) goto L5;
        L7:
            boolean r9 = false;
        L8:
            if (r9 == true) goto L10;
            VideoView r10 = this.a;
            r10.g = new Surface(r3);
        L10:
            VideoView r11 = this.a;
            TTVideoEngine r12 = r11.t;
            if (r12 != null) goto L13;
        L15:
            VideoView r13 = this.a;
            if (r13.x == true) goto L30;
            ArrayList<Runnable> r14 = r13.y;
            if (r14 == null) goto L27;
            r13.x = true;
            Iterator r15 = new ArrayList(r14).iterator();
        L22:
            if (r15.hasNext() == false) goto L24;
            ((Runnable) r15.next()).run();
            goto L22
        L24:
            ArrayList<Runnable> r16 = r13.y;
            if (r16 == null) goto L27;
            r16.clear();
        L27:
            r13.x = false;
            return;
        L30:
            return;
        L13:
            if (r11.u == false) goto L15;
            r12.setSurface(r11.g);
            goto L15
        L5:
            if (r8.isValid() != true) goto L7;
            r9 = true;
            goto L8
        }
    }

    public static final class h implements com.larus.media.v {
        public ValueAnimator a;
        public final /* synthetic */ VideoView b;

        public h(VideoView r1) {
            this.b = r1;
        }

        public final boolean b(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            Map r0 = o0.a;
            return o0.a("VIDEO", r2.getScene());
        }

        public final void e(lk9.g r3) {
            Intrinsics.checkNotNullParameter(r3, "applicant");
            com.larus.media.v.a.d(r3);
            final VideoView r4 = this.b;
            r4.w.post(new k(r4, this));
        }

        public final void f(MediaResourceManager.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void a(lk9.g r4, float r5) {
            Intrinsics.checkNotNullParameter(r4, "applicant");
            final VideoView r0 = this.b;
            r0.w.post(new l(r0, this));
            com.larus.media.v.a.f(r4, r5);
        }

        public final void d(lk9.g r1, lk9.g r2) {
            com.larus.media.v.a.c(r1, r2);
        }

        public final void g(lk9.g r1, float r2) {
            com.larus.media.v.a.g(r1, r2);
        }

        public final void i(lk9.g r2, lk9.g r3) {
            Intrinsics.checkNotNullParameter(r2, "current");
            Intrinsics.checkNotNullParameter(r3, "applicant");
            com.larus.media.v.a.e(r2, r3);
            final VideoView r4 = this.b;
            r4.w.post(new m(r4, this));
        }

        public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
            return com.larus.media.v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(lk9.g r1, lk9.g r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "current");
            Intrinsics.checkNotNullParameter(r2, "applicant");
            Map r4 = o0.a;
            return o0.b("VIDEO", r2.getScene());
        }
    }

    public VideoView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VideoView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private static /* synthetic */ void getMPlayType$annotations() {
    }

    static {
        G = true;
    }

    public final void d() {
        boolean r1 = true;
        if (this.h != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (this.i != 0.0f) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L80;
        CommonVideoModel.Companion.getClass();
        if (CommonVideoModel.access$getTopBarHeight$cp() < 0) goto L16;
        CommonVideoModel.access$getTopBarHeight$cp();
    L18:
        if (CommonVideoModel.access$getBottomBarHeight$cp() < 0) goto L20;
        CommonVideoModel.access$getBottomBarHeight$cp();
    L28:
        int r3 = getHeight() - i5.b();
        int r4 = getWidth();
        float r5 = r4;
        float r6 = r3;
        float r7 = r5 / r6;
        float r8 = this.i;
        if (r8 < 1.0f) goto L32;
    L48:
        r3 = (int) (r5 / r8);
    L49:
        ViewGroup.LayoutParams r9 = this.c.getLayoutParams();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) r9;
        if (this.h != 0.0f) goto L52;
        boolean r11 = true;
    L53:
        if (r11 == true) goto L71;
        if (this.i == 0.0f) goto L58;
        r1 = false;
    L58:
        if (r1 == true) goto L71;
        if (this.d.getVisibility() != 0) goto L71;
        if (this.h <= this.i) goto L65;
        ImageView.ScaleType r12 = ImageView.ScaleType.CENTER_CROP;
    L66:
        ViewGroup.LayoutParams r13 = this.d.getLayoutParams();
        r13.width = r4;
        r13.height = r3;
        this.d.setLayoutParams(r13);
        this.d.setScaleType(r12);
        if (this.l == null) goto L69;
        this.d.setVisibility(0);
        goto L71
    L69:
        this.d.setVisibility(8);
        goto L71
    L65:
        r12 = ImageView.ScaleType.FIT_CENTER;
    L71:
        if (r10.height == r3) goto L73;
    L74:
        r10.gravity = 17;
        r10.width = r4;
        r10.height = r3;
        r10.bottomMargin = i5.b();
        this.c.setLayoutParams(r10);
        return;
    L73:
        if (r10.width != r4) goto L74;
        return;
    L52:
        r11 = false;
        goto L53
    L32:
        if (r8 >= 1.0f) goto L37;
        if (r8 >= r7) goto L37;
    L47:
        r4 = (int) (r6 * r8);
    L37:
        if (r8 >= 1.0f) goto L44;
        if (r8 <= r7) goto L44;
        if (r8 >= 0.6d) goto L48;
    L44:
        if (r8 >= 0.6d) goto L48;
        if (r8 <= 0.0f) goto L48;
    L20:
        boolean r14 = KeyCharacterMap.deviceHasKey(3);
        i0.a.getClass();
        int r15 = i0.f();
        if (r14 == false) goto L76;
        if (r15 > 0) goto L76;
        int r16 = 0;
    L26:
        CommonVideoModel.access$setBottomBarHeight$cp(r16);
    L76:
        r16 = i0.e();     // Catch: Throwable -> L27
    L16:
        i0.a.getClass();
        CommonVideoModel.access$setTopBarHeight$cp(i0.g());
        goto L18
    L80:
        return;
    L10:
        r2 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public final void e() {
        this.e.setVisibility(8);
        this.f.setVisibility(0);
        if (this.l == null) goto L5;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(com.larus.utils.i.d(getContext()), (int) (com.larus.utils.i.d(getContext()) / this.i));
        r0.gravity = 17;
        this.d.setLayoutParams(r0);
        this.d.setHierarchy(GenericDraweeHierarchyBuilder.newInstance(getResources()).setBackground(AppCompatResources.getDrawable(getContext(), 2131243611)).setPlaceholderImage(AppCompatResources.getDrawable(getContext(), 2131243611)).setPlaceholderImageScaleType(ScalingUtils.ScaleType.CENTER_CROP).build());
        ImageLoaderKt.u(this.d, this.l, "video_cover_img");
        this.d.setVisibility(0);
        return;
    L5:
        this.d.setVisibility(8);
    }

    public final void f() {
        FLogger.a.d("VideoView", "[onSingleTap]");
        TTVideoEngine r0 = this.t;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L12;
        g(this);
        a r3 = this.C;
        if (r3 == null) goto L23;
        r3.onPause();
        return;
    L23:
        return;
    L12:
        TTVideoEngine r4 = this.t;
        if (r4 != null) goto L15;
    L17:
        if (r1 == false) goto L21;
        i(this);
        a r5 = this.C;
        if (r5 == null) goto L25;
        r5.onPlay();
        return;
    L25:
        return;
    L21:
        j();
        return;
    L15:
        if (r4.getPlaybackState() != 2) goto L17;
        r1 = true;
        goto L17
    L5:
        if (r0.getPlaybackState() != 1) goto L7;
        r2 = true;
        goto L8
    }

    public final long getCurrentPlaybackTime() {
        TTVideoEngine r0 = this.t;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getCurrentPlaybackTime();
    }

    public final long getDuration() {
        TTVideoEngine r0 = this.t;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getDuration();
    }

    public final void j() {
        Lazy r0 = MediaResourceManager.a;
        MediaResourceManager.m(this.E, new com.larus.video.impl.widget.g(this), new com.larus.video.impl.widget.h(this), 0, 8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this.B);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this.B);
        Lazy r0 = MediaResourceManager.a;
        MediaResourceManager.a(this.E);
    }

    public final a getAfterClickCallBack() {
        return this.C;
    }

    public final boolean getAllowGesture() {
        return this.v;
    }

    public final Function0<Unit> getDataChange() {
        return this.D;
    }

    public final boolean getMResumeOrPauseByUser() {
        return this.F;
    }

    public final int getPlayType() {
        return this.r;
    }

    public static final void a(VideoView r5) {
        r5.getClass();
        FLogger.a.d("VideoView", "[retryStart]");
        if (NetworkUtils.isNetworkAvailable(r5.getContext()) == false) goto L47;
        TTVideoEngine r0 = r5.t;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0 != null) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == true) goto L48;
        r0.stop();
        int r4 = r5.r;
        if (r4 == (-1)) goto L37;
        if (r4 == 0) goto L32;
        if (r4 != 1) goto L20;
        return;
    L20:
        if (r4 != 2) goto L43;
        p0 r1 = r5.o;
        VideoModel r2 = null;
        if (r1 == null) goto L25;
        VideoModel r6 = r1.getImpl();
    L26:
        if (r6 == null) goto L43;
        p0 r7 = r5.o;
        if (r7 == null) goto L30;
        r2 = r7.getImpl();
    L30:
        r0.setVideoModel(r2);
        goto L43
    L25:
        r6 = null;
    L43:
        r0.play();
        return;
    L32:
        if (r5.j == null) goto L43;
        String r8 = r5.k;
        if (r8 == null) goto L43;
        r5.r = 1;
        r0.setVideoID(r8);
        r0.setDataSource(r5.j);
        goto L43
    L37:
        if (r5.m == null) goto L42;
        r5.r = 0;
        if (r0.isSystemPlayer() == false) goto L41;
        r0.setDirectURL(r5.m);
        goto L43
    L41:
        r0.setDirectUrlUseDataLoader(r5.m, r5.n, r5.k);
        goto L43
    L42:
        r5.r = 1;
        r0.setVideoID(r5.k);
        r0.setDataSource(r5.j);
        goto L43
    L48:
        return;
    L10:
        if (r0.getPlaybackState() != 1) goto L12;
        r3 = true;
        goto L13
    }

    public static final void b(VideoView r5) {
        e r0 = r5.A;
        if (r0 == null) goto L17;
        TTVideoEngine r1 = r5.t;
        if (r1 == null) goto L7;
        int r2 = r1.getCurrentPlaybackTime();
    L8:
        TTVideoEngine r3 = r5.t;
        if (r3 == null) goto L11;
        int r4 = r3.getDuration();
    L12:
        Function1<? super Integer, Unit> r6 = r5.b;
        if (r6 == null) goto L15;
        r6.invoke(Integer.valueOf((r2 * 100) / r4));
    L15:
        r5.postDelayed(r0, 500);
        return;
    L11:
        r4 = 100;
        goto L12
    L7:
        r2 = 0;
        goto L8
    }

    public static void g(final VideoView r4) {
        r4.getClass();
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[pause] byUser:");
        final boolean r2 = true;
        r1.append(true);
        r0.d("VideoView", r1.toString());
        r4.c(new com.larus.video.impl.widget.e(r4, r2));
    }

    public static void i(final VideoView r4) {
        r4.getClass();
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[resume] byUser:");
        final boolean r2 = true;
        r1.append(true);
        r0.d("VideoView", r1.toString());
        r4.c(new com.larus.video.impl.widget.f(r4, r2));
    }

    public final void c(Runnable r3) {
        Surface r0 = this.g;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.isValid() != true) goto L7;
    L8:
        if (r1 == false) goto L11;
        r3.run();
        return;
    L11:
        if (this.y != null) goto L13;
        this.y = new ArrayList();
    L13:
        ArrayList<Runnable> r2 = this.y;
        if (r2 == null) goto L18;
        r2.add(r3);
        return;
    L18:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void h(TTVideoEngine r5) {
        FLogger.a.d("VideoView", "[resetSurfaceAndPlay]");
        r5.setSurface(this.g);
        r5.setVideoEngineCallback(new c(this, this.o));
        if (NetworkUtils.isNetworkAvailable(getContext()) == true) goto L5;
    L9:
        r5.play();
        return;
    L5:
        if (NetworkUtils.isWifi(getContext()) == true) goto L9;
        if (G == false) goto L9;
        G = false;
        t19.s r0 = t19.s.a;
        Context r1 = getContext();
        String r2 = getContext().getString(2131910900);
        r0.getClass();
        t19.s.t(r1, r2);
        goto L9
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.v == false) goto L9;
        if (this.z.onTouchEvent(r2) == false) goto L9;
        return true;
    L9:
        return super.onTouchEvent(r2);
    }

    public final void setAfterClickCallBack(a r1) {
        this.C = r1;
    }

    public final void setAllowGesture(boolean r1) {
        this.v = r1;
    }

    public final void setDataChange(Function0<Unit> r1) {
        this.D = r1;
    }

    public final void setMResumeOrPauseByUser(boolean r1) {
        this.F = r1;
    }

    public final void setPlayButtonVisible(int r2) {
        this.e.setVisibility(r2);
    }

    /* JADX WARN: Type inference failed for: r8v2, types: [com.larus.video.impl.widget.c] */
    public VideoView(Context r24, AttributeSet r25, int r26) {
        Intrinsics.checkNotNullParameter(r24, "context");
        super(r24, r25, r26);
        TextureView r2 = new TextureView(r24);
        this.c = r2;
        SimpleDraweeView r3 = new SimpleDraweeView(r24);
        this.d = r3;
        ImageView r4 = new ImageView(r24);
        this.e = r4;
        View r5 = new ActivityIndicatorView(r24, null);
        this.f = r5;
        this.r = -1;
        this.w = new Handler(Looper.getMainLooper());
        g r7 = new g(this);
        this.z = new GestureDetector(r24, new d(this));
        this.B = new com.larus.video.impl.widget.c(this);
        this.E = new com.larus.media.model.a(null, "VIDEO", false, 0, 2, false, MixPriority.DEFAULT.getValue(), false, false, MediaLevel.PLAY_HIGH.getValue(), false, new h(this), 1453);
        setBackgroundColor(ContextCompat.getColor(r24, 2131103292));
        r3.setAdjustViewBounds(true);
        addView(r2, -1, -1);
        int r8 = (int) UIUtils.dip2Px(r24, 56.0f);
        int r1 = (int) UIUtils.dip2Px(r24, 32.0f);
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(r8, r8);
        r9.gravity = 17;
        addView(r4, r9);
        r4.setImageResource(2131243486);
        e1.d(r4, new com.larus.video.impl.widget.d(this));
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(r1, r1);
        r6.gravity = 17;
        ((ActivityIndicatorView) r5).d = true;
        r5.setColor(getResources().getColor(2131103143));
        r5.setStrokeWidth(i5.Y());
        addView(r5, r6);
        r5.setVisibility(8);
        addView(r3, -1, -1);
        r2.setSurfaceTextureListener(r7);
    }

    public /* synthetic */ VideoView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        d();
    }
}
