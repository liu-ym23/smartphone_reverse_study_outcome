package com.larus.voicecall.impl.component.vlm;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.av_call.view.VoiceCallBottomLayout;
import com.larus.av_call.view.VoiceCallTopLayout;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.ZoomableTextureView;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.ui.VoiceCallContentLayout;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.utils.RealtimeNoticeDialogHelper;
import com.larus.voicecall.impl.video.VideoFaceMemoryAuthDialog;
import com.larus.voicecall.impl.video.VideoPreviewState;
import com.lynx.jsbridge.LynxAccessibilityModule;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.xelement.overlay.LynxUIOverlay;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.RiskPreferenceSettings;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.vesdk.VEDisplaySettings;
import com.ss.android.vesdk.VESDK;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import v19.e6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000Ô\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\u009b\u0001\u0018\u0000 \u0080\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0006\u0080\u0002\u0081\u0002\u0082\u0002B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J0\u0010\u009d\u0001\u001a\u00030\u008a\u00012\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0007\u0010 \u0001\u001a\u00020o2\b\u0010¡\u0001\u001a\u00030\u009f\u00012\u0007\u0010¢\u0001\u001a\u00020oH\u0016J\t\u0010¤\u0001\u001a\u00020\bH\u0002J\t\u0010¥\u0001\u001a\u00020\bH\u0002J\u001f\u0010¦\u0001\u001a\u00030\u008a\u00012\b\u0010§\u0001\u001a\u00030¨\u00012\t\b\u0002\u0010©\u0001\u001a\u00020\bH\u0002J\n\u0010ª\u0001\u001a\u00030\u008a\u0001H\u0016J\n\u0010«\u0001\u001a\u00030\u008a\u0001H\u0016J\n\u0010¯\u0001\u001a\u00030\u008a\u0001H\u0002J\u0013\u0010°\u0001\u001a\u00030\u008a\u00012\u0007\u0010±\u0001\u001a\u00020`H\u0016J\u0014\u0010²\u0001\u001a\u00030\u008a\u00012\b\u0010³\u0001\u001a\u00030´\u0001H\u0002J\n\u0010µ\u0001\u001a\u00030\u008a\u0001H\u0002J\u0014\u0010¶\u0001\u001a\u00030\u008a\u00012\b\u0010³\u0001\u001a\u00030´\u0001H\u0002J\u0014\u0010·\u0001\u001a\u00030\u008a\u00012\b\u0010¸\u0001\u001a\u00030¹\u0001H\u0016J \u0010º\u0001\u001a\u00030\u008a\u00012\b\u0010¸\u0001\u001a\u00030\u0089\u00012\n\u0010»\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0016J3\u0010½\u0001\u001a\u00030\u008a\u00012\u0007\u0010¾\u0001\u001a\u00020o2\u0007\u0010¿\u0001\u001a\u00020o2\t\b\u0002\u0010À\u0001\u001a\u00020\b2\n\b\u0002\u0010Á\u0001\u001a\u00030\u0089\u0001H\u0002J\n\u0010Â\u0001\u001a\u00030\u008a\u0001H\u0016J\n\u0010Ã\u0001\u001a\u00030\u008a\u0001H\u0016J\n\u0010Ä\u0001\u001a\u00030\u008a\u0001H\u0002J\n\u0010Å\u0001\u001a\u00030\u008a\u0001H\u0002J\n\u0010Ç\u0001\u001a\u00030\u008a\u0001H\u0002J\u0014\u0010È\u0001\u001a\u00030\u008a\u00012\b\u0010É\u0001\u001a\u00030\u0089\u0001H\u0002J\n\u0010Ê\u0001\u001a\u00030\u008a\u0001H\u0002J\u0013\u0010Ë\u0001\u001a\u00030\u008a\u00012\u0007\u0010Ì\u0001\u001a\u00020\bH\u0002J\n\u0010Í\u0001\u001a\u00030\u008a\u0001H\u0002J\n\u0010Î\u0001\u001a\u00030\u008a\u0001H\u0002J\u0012\u0010Ï\u0001\u001a\u00020\b2\u0007\u0010©\u0001\u001a\u00020\bH\u0002J\u0013\u0010Ð\u0001\u001a\u00030\u008a\u00012\u0007\u0010Ñ\u0001\u001a\u00020\bH\u0002J&\u0010Ò\u0001\u001a\u00030\u008a\u00012\u0007\u0010Ó\u0001\u001a\u00020o2\u0007\u0010Ô\u0001\u001a\u00020o2\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0002J\n\u0010×\u0001\u001a\u00030\u008a\u0001H\u0002J\u0013\u0010Ø\u0001\u001a\u00030\u008a\u00012\u0007\u0010Ù\u0001\u001a\u00020\bH\u0002J\t\u0010Ú\u0001\u001a\u00020\bH\u0002J\u0013\u0010Û\u0001\u001a\u00030\u008a\u00012\u0007\u0010Ü\u0001\u001a\u00020gH\u0016J\n\u0010Ý\u0001\u001a\u00030\u008a\u0001H\u0002J\u0014\u0010Þ\u0001\u001a\u00030\u008a\u00012\b\u0010ß\u0001\u001a\u00030\u0089\u0001H\u0002J\n\u0010à\u0001\u001a\u00030\u008a\u0001H\u0002J\u0013\u0010á\u0001\u001a\u00030\u008a\u00012\u0007\u0010â\u0001\u001a\u00020\bH\u0002J\n\u0010ã\u0001\u001a\u00030\u008a\u0001H\u0002J\u0014\u0010ä\u0001\u001a\u00030\u008a\u00012\b\u0010Ü\u0001\u001a\u00030\u008c\u0001H\u0002J\u0014\u0010å\u0001\u001a\u00030\u008a\u00012\b\u0010§\u0001\u001a\u00030\u0089\u0001H\u0016J\u0014\u0010æ\u0001\u001a\u00030\u008a\u00012\b\u0010§\u0001\u001a\u00030\u0089\u0001H\u0016J\n\u0010ç\u0001\u001a\u00030\u008a\u0001H\u0016J\u001d\u0010è\u0001\u001a\u00030\u008a\u00012\b\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010©\u0001\u001a\u00020\bH\u0016J\n\u0010é\u0001\u001a\u00030\u008a\u0001H\u0016J\t\u0010ê\u0001\u001a\u00020\bH\u0016J\n\u0010ë\u0001\u001a\u00030\u008a\u0001H\u0016J\t\u0010ì\u0001\u001a\u00020\bH\u0016J\t\u0010í\u0001\u001a\u00020\bH\u0016J\u001d\u0010è\u0001\u001a\u00030\u008a\u00012\b\u0010§\u0001\u001a\u00030\u0089\u00012\u0007\u0010©\u0001\u001a\u00020\bH\u0016J6\u0010ï\u0001\u001a\u00030\u008a\u00012\b\u0010ß\u0001\u001a\u00030\u0089\u00012\u000f\u0010ð\u0001\u001a\n\u0012\u0005\u0012\u00030\u008a\u00010\u0099\u00012\u000f\u0010ñ\u0001\u001a\n\u0012\u0005\u0012\u00030\u008a\u00010\u0099\u0001H\u0002J\n\u0010ò\u0001\u001a\u00030\u008a\u0001H\u0002J)\u0010ó\u0001\u001a\u00030\u008a\u00012\u0007\u0010ô\u0001\u001a\u00020\b2\b\u0010§\u0001\u001a\u00030\u0089\u00012\n\b\u0002\u0010õ\u0001\u001a\u00030ö\u0001H\u0002J\u0013\u0010÷\u0001\u001a\u00020\b2\b\u0010§\u0001\u001a\u00030\u0089\u0001H\u0002J\n\u0010ø\u0001\u001a\u00030\u008a\u0001H\u0002J\u0010\u0010ù\u0001\u001a\u00020\bH\u0096@¢\u0006\u0003\u0010ú\u0001J\u001d\u0010û\u0001\u001a\u00020\b2\u0006\u0010u\u001a\u00020`2\n\u0010ü\u0001\u001a\u0005\u0018\u00010ý\u0001H\u0016J\n\u0010þ\u0001\u001a\u00030\u008a\u0001H\u0016J\t\u0010ÿ\u0001\u001a\u00020\bH\u0016R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0010\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0010\u001a\u0004\b1\u00102R\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0010\u001a\u0004\b6\u00107R\u001b\u00109\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0010\u001a\u0004\b:\u0010\nR\u001d\u0010<\u001a\u0004\u0018\u00010=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0010\u001a\u0004\b>\u0010?R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0010\u001a\u0004\bC\u0010DR\u001d\u0010F\u001a\u0004\u0018\u00010G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0010\u001a\u0004\bH\u0010IR\u001d\u0010K\u001a\u0004\u0018\u00010G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0010\u001a\u0004\bL\u0010IR\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010P\u001a\u0004\u0018\u00010Q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\u0010\u001a\u0004\bR\u0010SR\u001d\u0010U\u001a\u0004\u0018\u00010V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u0010\u001a\u0004\bW\u0010XR\u001d\u0010Z\u001a\u0004\u0018\u00010[8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010\u0010\u001a\u0004\b\\\u0010]R\u001d\u0010_\u001a\u0004\u0018\u00010`8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\u0010\u001a\u0004\ba\u0010bR\u000e\u0010d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010h\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bh\u0010\nR\u001d\u0010i\u001a\u0004\u0018\u00010j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bm\u0010\u0010\u001a\u0004\bk\u0010lR\u000e\u0010n\u001a\u00020oX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010p\u001a\u0004\u0018\u00010q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bt\u0010\u0010\u001a\u0004\br\u0010sR\u001b\u0010u\u001a\u00020v8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\by\u0010\u0010\u001a\u0004\bw\u0010xR\u000e\u0010z\u001a\u00020{X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010}\u001a\u00020~8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010\u0010\u001a\u0005\b\u007f\u0010\u0080\u0001R\u000f\u0010\u0082\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0083\u0001\u001a\n\u0012\u0005\u0012\u00030\u0085\u00010\u0084\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0087\u0001\u001a\u0013\u0012\u0005\u0012\u00030\u0089\u0001\u0012\u0005\u0012\u00030\u008a\u0001\u0018\u00010\u0088\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u008f\u0001\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0091\u0001\u0010\u0010\u001a\u0005\b\u0090\u0001\u0010?R\u000f\u0010\u0092\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0093\u0001\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0093\u0001\u0010\nR\u0016\u0010\u0094\u0001\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0095\u0001\u0010\nR\u0016\u0010\u0096\u0001\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0096\u0001\u0010\nR\u000f\u0010\u0097\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0098\u0001\u001a\n\u0012\u0005\u0012\u00030\u008a\u00010\u0099\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u009a\u0001\u001a\u00030\u009b\u0001X\u0082\u000e¢\u0006\u0005\n\u0003\u0010\u009c\u0001R\u000f\u0010£\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¬\u0001\u001a\u00030\u00ad\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010®\u0001\u001a\n\u0012\u0005\u0012\u00030\u008a\u00010\u0099\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010Æ\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010î\u0001\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0083\u0002"}, d2 = {"Lcom/larus/voicecall/impl/component/vlm/RealtimeVideoComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/vlm/IRealtimeVideoAbility;", "Lcom/larus/voicecall/impl/component/vlm/float_window/IRealtimeGlobalFloatWindowAbility;", "Lcom/obric/assistant/ability/call/IObricRealtimeVideoAbility;", "<init>", "()V", "useBackCamera", NameKeys.UnloadStrategy_No_Strategy, "getUseBackCamera", "()Z", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity$delegate", "Lkotlin/Lazy;", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "coreAbility", "Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "getCoreAbility", "()Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "coreAbility$delegate", "subtitleAbility", "Lcom/larus/voicecall/impl/component/subtitle/IRealtimeSubtitleAbility;", "getSubtitleAbility", "()Lcom/larus/voicecall/impl/component/subtitle/IRealtimeSubtitleAbility;", "subtitleAbility$delegate", "topAbility", "Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "getTopAbility", "()Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "topAbility$delegate", "contentAbility", "Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "getContentAbility", "()Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "contentAbility$delegate", "bottomAbility", "Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "getBottomAbility", "()Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "bottomAbility$delegate", "tracer", "Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "getTracer", "()Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "tracer$delegate", "fixTouristEnable", "getFixTouristEnable", "fixTouristEnable$delegate", "viewStateManager", "Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "getViewStateManager", "()Lcom/larus/voicecall/impl/realtime/RealtimeCallViewStateManager;", "viewStateManager$delegate", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "switchCameraView", "Landroid/widget/ImageView;", "getSwitchCameraView", "()Landroid/widget/ImageView;", "switchCameraView$delegate", "flashlightIcon", "getFlashlightIcon", "flashlightIcon$delegate", "showHideFlashIconJob", "Lkotlinx/coroutines/Job;", "bottomControlArea", "Lcom/larus/av_call/view/VoiceCallBottomLayout;", "getBottomControlArea", "()Lcom/larus/av_call/view/VoiceCallBottomLayout;", "bottomControlArea$delegate", "videoViewContainer", "Landroid/widget/FrameLayout;", "getVideoViewContainer", "()Landroid/widget/FrameLayout;", "videoViewContainer$delegate", "voiceCallTopLayout", "Lcom/larus/av_call/view/VoiceCallTopLayout;", "getVoiceCallTopLayout", "()Lcom/larus/av_call/view/VoiceCallTopLayout;", "voiceCallTopLayout$delegate", "smallViewPortPH", "Landroid/view/View;", "getSmallViewPortPH", "()Landroid/view/View;", "smallViewPortPH$delegate", "hasLoseConnect", "hasPendingCloseVideo", "curConnectStatus", "Lcom/larus/im/internal/audio/context/SessionState;", "isVeCaptureEnable", "sceneAbility", "Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "getSceneAbility", "()Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "sceneAbility$delegate", "curUiState", NameKeys.UnloadStrategy_No_Strategy, "cameraManager", "Lcom/larus/voicecall/impl/component/vlm/camera/camera_state/ICameraManager;", "getCameraManager", "()Lcom/larus/voicecall/impl/component/vlm/camera/camera_state/ICameraManager;", "cameraManager$delegate", "videoView", "Landroid/view/TextureView;", "getVideoView", "()Landroid/view/TextureView;", "videoView$delegate", "viewModel", "Lcom/larus/voicecall/impl/video/RealtimeCallVideoViewModel;", "isFirstOpen", "videoSwitcher", "Lcom/larus/voicecall/impl/video/ViewPortSwitcher;", "getVideoSwitcher", "()Lcom/larus/voicecall/impl/video/ViewPortSwitcher;", "videoSwitcher$delegate", "hasMobLeave", "viewStateSnapshot", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/voicecall/impl/component/vlm/RealtimeVideoComponent$ViewStateSnapshot;", "needCloseSubtitle", "fullVideoPreviewLazyTask", "Lkotlin/Function1;", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "lastPreviewState", "Lcom/larus/voicecall/impl/video/VideoPreviewState;", "pendingCameraStatusUpdate", "hasSentInitialAppBackgroundContext", "stateManager", "getStateManager", "stateManager$delegate", "shouldResumeWhenAppForeground", "isBackCamera", "videoCaptureStarted", "getVideoCaptureStarted", "isOpenVlm", "everToastedFaceMemory", "onRejectCameraPermission", "Lkotlin/Function0;", "appForegroundObserver", "com/larus/voicecall/impl/component/vlm/RealtimeVideoComponent$appForegroundObserver$1", "Lcom/larus/voicecall/impl/component/vlm/RealtimeVideoComponent$appForegroundObserver$1;", "onUpdateUIState", "currentMajorState", "Lcom/larus/audio/call/mgr/MajorState;", "currentState", "newMajorState", "newState", "needEnterHalf", "shouldUseFloatVideoSubtitle", "shouldOpenFullPreviewWhenAutoEnterVideo", "closeVideo", "reason", "Lcom/larus/voicecall/impl/component/vlm/ExitVideoModalReason;", "needSwitchModal", "onAttach", "onVContextReady", "lastScale", NameKeys.UnloadStrategy_No_Strategy, "pinchClicker", "switchSubtitleWhenPopToFullVideo", "onViewCreated", "view", "showFocusView", "e", "Landroid/view/MotionEvent;", "hideFocusView", "triggerFocus", "onReceiveEvent", "event", "Lcom/larus/im/service/audio/MediaSessionListener$Event;", "otherEvent", LynxAccessibilityModule.MSG_CONTENT, NameKeys.UnloadStrategy_No_Strategy, "mobVideoError", "deviceState", "deviceError", "isCheckoutModalError", "errorMsg", "onDestroy", "onFragmentViewDestroyed", "setupVideoView", "setupVideoControl", "needEnterVideoCall", "registerSceneChangeListener", "mobExitVideoCall", "leaveMethod", "setupMenus", "updateCameraStatusContext", "useBack", "resumeCamera", "setupObservers", "startVideoCapture", "setOtherVideoChildrenVisible", LynxUIOverlay.PROP_VISIBLE, "syncVePreviewSize", "width", "height", "fitMode", "Lcom/ss/android/vesdk/VEDisplaySettings$VEDisplayFitMode;", "syncVePreviewSizeAfterLayout", "onFirstFrameCapture", "isVECapture", "shouldRefreshFlashlightAfterFirstFrame", "onConnectionStateChanged", "state", "onVideoStart", "setVideoFullPreviewMode", "caller", "showFlashlightOnOpenFullVideo", "setForceDarkMode", "force", "hideSomeViews", "restoreSomeViews", "switchPopMode", "switchFullMode", "openLLMVideo", "tryCloseVideo", "tryPreloadVideoCapture", "isCameraBack", "refreshPipDialog", "isVideoFullPreviewMode", "isVideoPipPreviewMode", "isRequestCameraPermission", "requestCameraPermission", "onGranted", "onReject", "setupFlashlight", "resetFlashlightIcon", "show", "delayTime", NameKeys.UnloadStrategy_No_Strategy, "shouldCloseFlashlightWhenHidden", "closeFlashlight", "enableFlashlight", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showGlobalFloatWindow", "config", "Lcom/larus/voicecall/impl/component/vlm/float_window/GlobalFloatWindowConfig;", "hideGlobalFloatWindow", "isGlobalFloatWindowShowing", "Companion", "CameraStatus", "ViewStateSnapshot", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeVideoComponent extends RealtimeComponent implements com.larus.voicecall.impl.component.vlm.b, naa.b {
    public static final /* synthetic */ int g1 = 0;
    public final Lazy A;
    public Job B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public boolean G;
    public boolean H;
    public boolean H0;
    public jd9.c I;
    public final Lazy J;
    public int K;
    public final Lazy L;
    public float L0;
    public final Lazy M;
    public final com.larus.voicecall.impl.video.n N;
    public boolean O;
    public final Lazy P;
    public final n0 P0;
    public boolean Q;
    public final List<b> R;
    public boolean S;
    public Function1<? super String, Unit> T;
    public VideoPreviewState U;
    public boolean V;
    public boolean V0;
    public boolean W;
    public final Lazy X;
    public boolean Y;
    public boolean Z;
    public boolean b1;
    public final m0 k0;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final d p0;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/voicecall/impl/component/vlm/RealtimeVideoComponent$CameraStatus;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NO_CHANGE", "BACK", "FRONT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CameraStatus extends Enum<CameraStatus> {
        public static final CameraStatus BACK = null;
        public static final CameraStatus FRONT = null;
        public static final CameraStatus NO_CHANGE = null;
        public static final /* synthetic */ CameraStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<CameraStatus> getEntries() {
            return b;
        }

        static {
            CameraStatus r0 = new CameraStatus("NO_CHANGE", 0, "0");
            NO_CHANGE = r0;
            CameraStatus r1 = new CameraStatus("BACK", 1, "1");
            BACK = r1;
            CameraStatus r2 = new CameraStatus("FRONT", 2, RiskPreferenceSettings.SMART_BALANCE);
            FRONT = r2;
            CameraStatus[] r4 = {r0, r1, r2};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
        }

        public static CameraStatus[] values() {
            return (CameraStatus[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static CameraStatus valueOf(String r1) {
            return (CameraStatus) r27.a.a(CameraStatus.class, r1);
        }

        public CameraStatus(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final View b;
        public final Function1<VideoPreviewState, Boolean> c;

        public b() {
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(int r3, VoiceCallContentLayout r4) {
            Function1<VideoPreviewState, Boolean> r0 = new f2();
            Intrinsics.checkNotNullParameter(r4, "view");
            Intrinsics.checkNotNullParameter(r0, "restorePredict");
            this.a = r3;
            this.b = r4;
            this.c = r0;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[VideoPreviewState.values().length];
            r0[VideoPreviewState.close.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[VideoPreviewState.full.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[VideoPreviewState.pip.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class d implements f09.a.b {
        public final /* synthetic */ RealtimeVideoComponent a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
            FLogger.a.i("RealtimeVideoComponent", "app enter to background. videoCaptureStarted=" + this.a.D5());
            if (this.a.D5() == false) goto L21;
            this.a.E3().y("onAppBackground");
            if (this.a.i4() == true) goto L7;
            com.larus.voicecall.impl.plugins.o1 r0 = this.a.E3().z();
            if (r0 == null) goto L19;
            r0.N();
        L19:
            this.a.Y = true;
            return;
        L7:
            if (z2.a.isRealtimeVideoBackgroundPublishEnable() == false) goto L13;
            com.larus.voicecall.impl.plugins.o1 r1 = this.a.E3().z();
            if (r1 == null) goto L13;
            com.larus.im.service.audio.z r2 = r1.e();
            if (r2 == null) goto L13;
            r2.u();
        L13:
            com.larus.voicecall.impl.component.vlm.camera.camera_state.f r3 = this.a.G3();
            if (r3 == null) goto L19;
            r3.closeCamera();
            goto L19
        }

        public final void onAppForeground() {
            FLogger.a.i("RealtimeVideoComponent", "app enter to onAppForeground. videoCaptureStarted=" + this.a.D5() + " shouldResumeWhenAppForeground=" + this.a.Y);
            RealtimeVideoComponent r0 = this.a;
            if (r0.Y == true) goto L5;
            return;
        L5:
            if (r0.i4() == true) goto L7;
            com.larus.voicecall.impl.plugins.o1 r1 = this.a.E3().z();
            if (r1 == null) goto L19;
            r1.V1(this.a.Z3());
        L19:
            RealtimeVideoComponent r2 = this.a;
            if (r2.i4() == false) goto L24;
            com.larus.voicecall.impl.component.vlm.camera.camera_state.f r3 = r2.G3();
            if (r3 == null) goto L27;
            r3.b(Intrinsics.areEqual(r2.N.b.getValue(), Boolean.TRUE));
        L27:
            RealtimeVideoComponent r4 = this.a;
            r4.Y = false;
            r4.E3().y("onAppForeground");
            return;
        L24:
            com.larus.voicecall.impl.plugins.o1 r5 = r2.E3().z();
            if (r5 == null) goto L27;
            r5.b(Intrinsics.areEqual(r2.N.b.getValue(), Boolean.TRUE));
            goto L27
        L7:
            if (z2.a.isRealtimeVideoBackgroundPublishEnable() == false) goto L13;
            com.larus.voicecall.impl.plugins.o1 r6 = this.a.E3().z();
            if (r6 == null) goto L13;
            com.larus.im.service.audio.z r7 = r6.e();
            if (r7 == null) goto L13;
            r7.s();
        L13:
            com.larus.voicecall.impl.component.vlm.camera.camera_state.f r8 = this.a.G3();
            if (r8 == null) goto L19;
            r8.openCamera();
            goto L19
        }

        public d(RealtimeVideoComponent r1) {
            this.a = r1;
        }
    }

    public static final class e implements ZoomableTextureView.c {
        public final /* synthetic */ RealtimeVideoComponent a;

        public final void b() {
        }

        public final void c() {
        }

        public final void f() {
        }

        public final void a() {
            this.a.L0 = 1.0f;
            FLogger.a.i("RealtimeVideoComponent", "start scale video");
        }

        public e(RealtimeVideoComponent r1) {
            this.a = r1;
        }

        public final void d(float r10) {
            FLogger.a.i("RealtimeVideoComponent", "end scale video startScale=1.0 endScale=" + r10);
            if (r10 <= 1.0f) goto L5;
            String r11 = "zoom_in";
        L6:
            String r6 = r11;
            int r12 = com.larus.voicecall.impl.util.x0.a;
            RealtimeVideoComponent r13 = this.a;
            int r0 = RealtimeVideoComponent.g1;
            com.larus.voicecall.impl.util.x0.c(r13.Q3().a(), this.a.B3(), ((h88.b) this.a.Q3()).m, false, Boolean.valueOf(Intrinsics.areEqual(this.a.N.b.getValue(), Boolean.TRUE)), "pinch", r6, null, 136);
            return;
        L5:
            r11 = "zoom_out";
            goto L6
        }

        public final void e(MotionEvent r9) {
            Intrinsics.checkNotNullParameter(r9, "e");
            if (this.a.D5() == true) goto L5;
            return;
        L5:
            if (this.a.s6() == false) goto L27;
            RealtimeVideoComponent r0 = this.a;
            if (r0.i4() == false) goto L11;
            com.larus.voicecall.impl.component.vlm.camera.camera_state.f r1 = r0.G3();
            if (r1 == null) goto L14;
            r1.f(r9.getX(), r9.getY());
        L14:
            final RealtimeVideoComponent r2 = this.a;
            g3a.a r3 = r2.H3();
            if (r3 == null) goto L28;
            ZoomableTextureView r4 = r3.iB();
            if (r4 == null) goto L30;
            g3a.a r5 = r2.H3();
            if (r5 == null) goto L29;
            AppCompatImageView r6 = r5.Km();
            if (r6 == null) goto L31;
            r6.setAlpha(0.0f);
            r6.setTranslationX(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r9.getX() - (r6.getMeasuredWidth() / 2), 0.0f), r4.getMeasuredWidth() - r6.getMeasuredWidth()));
            r6.setTranslationY(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r9.getY() - (r6.getMeasuredHeight() / 2), 0.0f), r4.getMeasuredHeight() - r6.getMeasuredHeight()));
            r6.setScaleX(1.0f);
            r6.setScaleY(1.0f);
            ViewPropertyAnimator r10 = r6.animate();
            r10.alpha(1.0f);
            r10.scaleX(0.6f);
            r10.scaleY(0.6f);
            r10.setDuration(300);
            r10.withEndAction(new k1(r2));
            r10.start();
            return;
        L31:
            return;
        L29:
            return;
        L30:
            return;
        L28:
            return;
        L11:
            int r7 = m2.a;
            Context r8 = r0.getContext();
            Intrinsics.checkNotNullParameter(r9, "event");
            Intrinsics.checkNotNullParameter(r8, "ctx");
            float r11 = r9.getRawX();
            float r12 = r9.getRawY();
            Resources r13 = r8.getResources();
            DisplayMetrics r14 = WindowDisplayMetricsOverride.apply(r13, r13.getDisplayMetrics());
            int r15 = r14.widthPixels;
            float r16 = r12 / r14.heightPixels;
            Pair r17 = TuplesKt.to(Float.valueOf(Math.max(0.0f, Math.min(1.0f, r11 / r15))), Float.valueOf(Math.max(0.0f, Math.min(1.0f, r16))));
            com.larus.voicecall.impl.plugins.o1 r18 = r0.E3().z();
            if (r18 == null) goto L14;
            r18.f(((Number) r17.getFirst()).floatValue(), ((Number) r17.getSecond()).floatValue());
            goto L14
        }

        public final void g(float r7, float r8, float r9) {
            RealtimeVideoComponent r0 = this.a;
            if (r7 != r0.L0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L9;
            return;
        L9:
            if (r0.i4() == false) goto L14;
            com.larus.voicecall.impl.component.vlm.camera.camera_state.f r10 = this.a.G3();
            if (r10 == null) goto L22;
            r10.d(r7);
            return;
        L22:
            return;
        L14:
            if (r7 <= this.a.L0) goto L18;
            FLogger.a.i("RealtimeVideoComponent", "zoom_in scaleFactor=" + r7 + " focusX=" + r8 + " focusY=" + r9);
            com.larus.voicecall.impl.plugins.o1 r11 = this.a.E3().z();
            if (r11 == null) goto L24;
            r11.g();
            return;
        L24:
            return;
        L18:
            FLogger.a.i("RealtimeVideoComponent", "zoom_out scaleFactor=" + r7 + " focusX=" + r8 + " focusY=" + r9);
            com.larus.voicecall.impl.plugins.o1 r12 = this.a.E3().z();
            if (r12 == null) goto L26;
            r12.k();
            return;
        L26:
            return;
        L5:
            r1 = false;
            goto L6
        }
    }

    public static final class f implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public f(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.n.getValue();
    }

    public static void h4() {
        t3a.g r0 = (t3a.g) t3a.g.j.getValue();
        if (r0.c == true) goto L17;
        r0.a();
        return;
    L17:
        t3a.b r2 = r0.d;     // Catch: Exception -> L14
        if (r2 != null) goto L8;
    L12:
        r0.d = null;     // Catch: Exception -> L14
        r0.b();     // Catch: Exception -> L14
        r0.a();     // Catch: Exception -> L14
        r0.c = false;     // Catch: Exception -> L14
        FLogger.a.i("RealtimeVideoGlobalFloatWindow", "global float window hidden");     // Catch: Exception -> L14
        return;
    L8:
        if (r2.l == 0) goto L12;
        if (r2.j == null) goto L12;
        r2.c(r2.b);     // Catch: Exception -> L14
        r2.l = 0;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        FLogger.a.e("RealtimeVideoGlobalFloatWindow", "hide global float window error: " + e.getMessage(), e);
    }

    public final void A2() {
        FLogger.a.d("RealtimeVideoComponent", "onDestroyView");
        if (i4() == true) goto L8;
        com.larus.voicecall.impl.plugins.o1 r0 = E3().z();
        if (r0 == null) goto L9;
        r0.o();
        return;
    L9:
        return;
    }

    public final e3a.a B3() {
        return (e3a.a) this.o.getValue();
    }

    public final com.larus.voicecall.impl.component.bottom.b C3() {
        return (com.larus.voicecall.impl.component.bottom.b) this.u.getValue();
    }

    public final VoiceCallBottomLayout D3() {
        return (VoiceCallBottomLayout) this.C.getValue();
    }

    @Override // naa.b
    public final boolean DZ() {
        if (this.N.c.getValue() != VideoPreviewState.pip) goto L5;
        return true;
    L5:
        return false;
    }

    public final RealtimeCallService E3() {
        return (RealtimeCallService) this.p.getValue();
    }

    public final com.larus.voicecall.impl.component.vlm.camera.camera_state.f G3() {
        return (com.larus.voicecall.impl.component.vlm.camera.camera_state.f) this.L.getValue();
    }

    public final g3a.a H3() {
        return (g3a.a) this.t.getValue();
    }

    public final ImageView IF() {
        return (ImageView) this.A.getValue();
    }

    public final e3a.b Q3() {
        return (e3a.b) this.y.getValue();
    }

    public final boolean R4() {
        boolean r0 = z2.a.getRealtimeCallNewStyleConfig().a();
        if (((h88.b) Q3()).d == true) goto L6;
        FLogger.a.i("RealtimeVideoComponent", "shouldUseFloatVideoSubtitle use setting, isMainBot=" + ((h88.b) Q3()).d + ", settingDefault=" + r0);
        return r0;
    L6:
        RealtimeCallUtil r1 = RealtimeCallUtil.a;
        boolean r4 = ((h88.b) Q3()).d;
        r1.getClass();
        boolean r2 = RealtimeCallUtil.f(r4);
        Boolean r5 = null;
        if (r2 == false) goto L15;
        com.larus.voicecall.impl.util.t0.a.getClass();
        int r6 = ((Keva) com.larus.voicecall.impl.util.t0.b.getValue()).getInt("VIDEO_SUBTITLE_MODE_WHEN_EXIT_REALTIME", -1);
        if (r6 != 0) goto L11;
        r5 = Boolean.FALSE;
        goto L15
    L11:
        if (r6 != 1) goto L15;
        r5 = Boolean.TRUE;
    L15:
        if (r5 == null) goto L17;
        boolean r7 = r5.booleanValue();
    L18:
        FLogger.a.i("RealtimeVideoComponent", "shouldUseFloatVideoSubtitle use remembered, rememberedMode=" + r5 + ", settingDefault=" + r0 + ", result=" + r7 + ", subtitleEnabled=" + r2 + ", subtitleOpen=" + RealtimeCallUtil.z + ", lastPreviewState=" + this.U + ", isFullVideo=" + ((h88.b) Q3()).r + ", isPipVideo=" + ((h88.b) Q3()).s);
        return r7;
    L17:
        r7 = r0;
        goto L18
    }

    public final com.larus.voicecall.impl.component.scene.a V3() {
        return (com.larus.voicecall.impl.component.scene.a) this.J.getValue();
    }

    public final com.larus.voicecall.impl.component.subtitle.a W3() {
        return (com.larus.voicecall.impl.component.subtitle.a) this.r.getValue();
    }

    public final ImageView X3() {
        return (ImageView) this.z.getValue();
    }

    @Override // com.larus.voicecall.impl.component.vlm.b
    public final void X60() {
        if (this.N.c.getValue() != VideoPreviewState.pip) goto L6;
        h4();
        T4(a4(), null);
        return;
    }

    public final boolean Z3() {
        return Intrinsics.areEqual(this.N.b.getValue(), Boolean.TRUE);
    }

    public final TextureView a4() {
        return (TextureView) this.M.getValue();
    }

    public final FrameLayout c4() {
        return (FrameLayout) this.D.getValue();
    }

    public final w3a.k d4() {
        return (w3a.k) this.x.getValue();
    }

    public final VoiceCallTopLayout e4() {
        return (VoiceCallTopLayout) this.E.getValue();
    }

    public final boolean i4() {
        RealtimeCallUtil r0 = RealtimeCallUtil.a;
        AudioSessionType r1 = ((h88.b) Q3()).e;
        r0.getClass();
        return RealtimeCallUtil.L(r1);
    }

    @Override // naa.b
    public final void ju() {
        q4("openLLMVideo", new z0(this), this.k0);
    }

    @Override // com.larus.voicecall.impl.component.vlm.b
    public final void m20() {
        Intrinsics.checkNotNullParameter("onSubtitleClose", "reason");
        com.larus.voicecall.impl.plugins.o1 r2 = E3().z();
        if (r2 == null) goto L7;
        boolean r3 = true;
        if (r2.D5() != true) goto L7;
    L8:
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("[realtime_ball_video_debug] switchFullMode called, reason=onSubtitleClose, serviceVideoCaptureStarted=");
        r5.append(r3);
        r5.append(", componentVideoCaptureStarted=");
        r5.append(D5());
        r5.append(", previewState=");
        r5.append(this.N.c.getValue());
        r5.append(", runtimeFull=");
        r5.append(((h88.b) Q3()).r);
        r5.append(", runtimePip=");
        r5.append(((h88.b) Q3()).s);
        r5.append(", subtitleOpen=");
        RealtimeCallUtil.a.getClass();
        r5.append(RealtimeCallUtil.z);
        r4.i("RealtimeVideoComponent", r5.toString());
        if (r3 == false) goto L11;
        com.larus.voicecall.impl.video.n r6 = this.N;
        r6.getClass();
        Intrinsics.checkNotNullParameter("onSubtitleClose", "reason");
        r6.a(VideoPreviewState.full, "onSubtitleClose", new com.larus.voicecall.impl.video.m());
        return;
    L11:
        r4.i("RealtimeVideoComponent", "[realtime_ball_video_debug] switchFullMode skip, reason=onSubtitleClose, videoCaptureStarted=false");
        return;
    L7:
        r3 = false;
        goto L8
    }

    public final void onDestroy() {
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.h == false) goto L5;
        h4();
    L5:
        RealtimeCallUtil.R = false;
        if (((h88.b) Q3()).d == false) goto L9;
        com.larus.voicecall.impl.util.t0 r1 = com.larus.voicecall.impl.util.t0.a;
        boolean r2 = D5();
        r1.getClass();
        ((Keva) com.larus.voicecall.impl.util.t0.b.getValue()).storeBoolean("IS_VIDEO_MODEL_WHEN_EXIT_REALTIME", r2);
    L9:
        if (D5() == false) goto L17;
        String r3 = Q3().a().H;
        if (StringsKt.isBlank(r3) == false) goto L13;
        r3 = "end_call";
    L13:
        j4(r3);
        Job r4 = RealtimeNoticeDialogHelper.b;
        if (r4 == null) goto L16;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L16:
        RealtimeNoticeDialogHelper.b = null;
    L17:
        FLogger.a.i("RealtimeVideoComponent", "onDestroy  videoCaptureStarted=" + D5() + " mainBot=" + ((h88.b) Q3()).d);
        if (i4() == false) goto L26;
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r5 = G3();
        if (r5 == null) goto L22;
        r5.closeCamera();
    L22:
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r6 = G3();
        if (r6 == null) goto L25;
        r6.onDestroy();
    L25:
        VESDK.enableRefactorRecorder(false);
    L26:
        com.larus.voicecall.impl.plugins.o1 r0 = E3().z();
        if (r0 == null) goto L29;
        r0.m0(true);
    L29:
        AppHost.a.a().c(this.p0);
    }

    public final void p4() {
        VideoPreviewState r0 = this.U;
        boolean r2 = true;
        if (r0 == VideoPreviewState.close) goto L5;
        if (r0 == null) goto L5;
    L11:
        if (this.O == true) goto L13;
    L16:
        FLogger r1 = FLogger.a;
        r1.i("jyt_test", "start video 2 needSwitchModal=" + r2);
        r1.i("jyt_test", "start video 2 end, isSuccess=" + V4(r2));
        this.O = false;
        return;
    L13:
        if (((h88.a) B3()).m == false) goto L16;
        r2 = false;
    L5:
        RealtimeNoticeDialogHelper.b();
        ((IRealtimeCallTracer) this.v.getValue()).B(IRealtimeCallTracer.TotalTimeType.VIDEO_SHARE_START_TIME, true);
        ((w3a.k) this.X.getValue()).a(w3a.f.a);
        this.Q = false;
        if (i4() == false) goto L11;
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r3 = G3();
        if (r3 == null) goto L11;
        r3.openCamera();
        goto L11
    }

    @Override // com.larus.voicecall.impl.component.vlm.b, naa.b
    public final boolean s6() {
        if (this.N.c.getValue() != VideoPreviewState.full) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.voicecall.impl.component.vlm.b
    public final boolean xH() {
        return Intrinsics.areEqual(this.N.b.getValue(), Boolean.TRUE);
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.vlm.b.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, naa.b.class);
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.larus.voicecall.impl.component.vlm.m0] */
    public RealtimeVideoComponent() {
        this.n = LazyKt.lazy(new g0(this));
        this.o = LazyKt.lazy(new i0(this));
        this.p = LazyKt.lazy(new o0(this));
        this.q = LazyKt.lazy(new p0(this));
        this.r = LazyKt.lazy(new q0(this));
        this.s = LazyKt.lazy(new s0(this));
        this.t = LazyKt.lazy(new t0(this));
        this.u = LazyKt.lazy(new u0(this));
        this.v = LazyKt.lazy(new v0(this));
        this.w = LazyKt.lazy(new w0());
        this.x = LazyKt.lazy(new r0(this));
        this.y = LazyKt.lazy(new c1(this));
        this.z = LazyKt.lazy(new n1(this));
        this.A = LazyKt.lazy(new y1(this));
        this.C = LazyKt.lazy(new a2(this));
        this.D = LazyKt.lazy(new b2(this));
        this.E = LazyKt.lazy(new c2(this));
        this.F = LazyKt.lazy(new d2(this));
        this.I = jd9.c.e.c;
        this.J = LazyKt.lazy(new e2(this));
        this.K = -1;
        this.L = LazyKt.lazy(new h0(this));
        this.M = LazyKt.lazy(new j0(this));
        this.N = new com.larus.voicecall.impl.video.n();
        this.O = true;
        this.P = LazyKt.lazy(new k0(this));
        this.R = new ArrayList();
        this.V = true;
        this.X = LazyKt.lazy(new l0(this));
        this.k0 = new m0(this);
        this.p0 = new d(this);
        this.H0 = true;
        this.L0 = 1.0f;
        this.P0 = new n0(this);
    }

    public final void A0() {
        getActivity();
        B3();
        E3();
        com.larus.voicecall.impl.component.core.a r0 = (com.larus.voicecall.impl.component.core.a) this.q.getValue();
        W3();
        Q3();
        w3a.k r1 = (w3a.k) this.X.getValue();
        com.larus.voicecall.impl.plugins.o1 r2 = E3().z();
        if (r2 == null) goto L6;
        r2.x2(((h88.a) B3()).m);
        return;
    }

    @Override // com.larus.voicecall.impl.component.vlm.b
    public final boolean D5() {
        com.larus.voicecall.impl.plugins.o1 r0 = E3().z();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.D5() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.voicecall.impl.component.vlm.b
    public final void my() {
        if (((h88.a) B3()).m == false) goto L9;
        RealtimeCallUtil.a.getClass();
        if (((Boolean) RealtimeCallUtil.i0.getValue()).booleanValue() == false) goto L9;
        com.larus.voicecall.impl.plugins.o1 r0 = E3().z();
        if (r0 == null) goto L11;
        r0.L0(a4(), Z3());
        return;
    L11:
        return;
    L9:
        FLogger.a.e("RealtimeVideoComponent", "tryPreloadVideoCapture but openVLMOnStart is false");
    }

    public static TextureView h3(RealtimeVideoComponent r1) {
        return new TextureView(r1.getActivity());
    }

    public final void B4(VideoPreviewState r6) {
        Iterator r0 = ((ArrayList) this.R).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        b r1 = (b) r0.next();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "state");
        if (((Boolean) r1.c.invoke(r6)).booleanValue() == false) goto L8;
        r1.b.setVisibility(r1.a);
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
        FLogger.a.d("RealtimeVideoComponent", "remove snapshot for view id: " + r1.b.getId());
        r0.remove();
        goto L4
    L8:
        r2 = false;
        goto L9
    }

    public final void D9(com.larus.im.service.audio.z0.a r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        boolean r1 = false;
        if ((r7 instanceof pf9.o) == false) goto L12;
        com.larus.voicecall.impl.plugins.o1 r8 = E3().z();
        if (r8 != null) goto L7;
    L9:
        if (r1 == false) goto L44;
        D5();
        return;
    L44:
        return;
    L7:
        if (r8.y1() != true) goto L9;
        r1 = true;
        goto L9
    L12:
        if ((r7 instanceof pf9.o0) == false) goto L26;
        if (D5() == false) goto L23;
        if (((pf9.o0) r7).a == false) goto L23;
        int r9 = com.larus.voicecall.impl.util.x0.a;
        e3a.b r10 = Q3();
        e3a.a r0 = B3();
        boolean r2 = Intrinsics.areEqual(this.N.b.getValue(), Boolean.TRUE);
        Intrinsics.checkNotNullParameter(r10, "runtimeData");
        Intrinsics.checkNotNullParameter(r0, "argumentData");
        com.larus.platform.service.o r3 = com.larus.platform.service.o.a;
        JSONObject r4 = new JSONObject();
        if (r2 == false) goto L20;
        String r5 = "back_camera";
    L21:
        r4.put("camera_position", r5);
        r4.put("current_page", "chat");
        com.larus.voicecall.impl.util.x0.a(r4, r10.a(), r0);
        Unit r11 = Unit.INSTANCE;
        r3.reportEvent("enter_video_call", r4);
        B3().h1 = false;
        return;
    L20:
        r5 = "front_camera";
    L23:
        if (D5() == false) goto L47;
        StringBuilder r6 = new StringBuilder("videoCaptureStarted=");
        r6.append(D5());
        r6.append(" isSuccess=");
        pf9.o0 r12 = (pf9.o0) r7;
        r6.append(r12.a);
        k4(-1, -1, true, r6.toString());
        FLogger.a.e("RealtimeVideoComponent", "server enter video call failed! videoCaptureStarted=" + D5() + " isSuccess=" + r12.a);
        return;
    L47:
        return;
    L26:
        if ((r7 instanceof pf9.l0) == false) goto L49;
        boolean r13 = z2.a.hasFaceMemoryFunc();
        boolean r14 = AccountService.a.a();
        if (r13 == false) goto L39;
        if (r14 == true) goto L39;
        if (this.Z == false) goto L34;
        return;
    L34:
        this.Z = true;
        int r15 = VideoFaceMemoryAuthDialog.g;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentManager r16 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragmentManager();
        Map r17 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r16, "fragmentManager");
        Intrinsics.checkNotNullParameter(r17, LynxResourceModule.PARAMS_KEY);
        VideoFaceMemoryAuthDialog r18 = new VideoFaceMemoryAuthDialog();
        LandscapeRestrictionOperation r19 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r18, "face_auth", r19);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r16, r18, r19) == true) goto L51;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L41
    L38:
        r18.show(r16, "face_auth");
        return;
    L51:
        return;
    L39:
        FLogger.a.i("RealtimeVideoComponent", "[ignore_video_face_toast_event]:hasFaceMemoryFunc=" + r13 + " or isInMinorMode=" + r14);
        return;
    }

    public final void F4(boolean r4) {
        com.larus.voicecall.impl.component.bottom.b r0 = C3();
        if (r0 == null) goto L7;
        VoiceCallBottomLayout r1 = r0.BT();
        if (r1 == null) goto L7;
        r1.i8(r4, ((h88.b) Q3()).p, ((h88.b) Q3()).q);
    L7:
        m3a.a r2 = (m3a.a) this.s.getValue();
        if (r2 == null) goto L13;
        VoiceCallTopLayout r3 = r2.Fv();
        if (r3 == null) goto L14;
        r3.U5(r4, ((h88.b) Q3()).p, ((h88.b) Q3()).q);
        return;
    L14:
        return;
    }

    public final void G4(boolean r6) {
        FrameLayout r0 = c4();
        if (r0 == null) goto L18;
        ArrayList r1 = new ArrayList();
        i2 r2 = new i2(r0);
    L6:
        if (r2.hasNext() == false) goto L10;
        View r3 = r2.next();
        if ((!Intrinsics.areEqual(r3, a4())) == false) goto L6;
        r1.add(r3);
        goto L6
    L10:
        Iterator r4 = r1.iterator();
    L12:
        if (r4.hasNext() == false) goto L27;
        View r5 = (View) r4.next();
        if (r6 == false) goto L16;
        int r7 = 0;
    L17:
        r5.setVisibility(r7);
        goto L12
    L16:
        r7 = 8;
        goto L17
    L27:
        return;
    }

    public final void I6(jd9.c r6) {
        Intrinsics.checkNotNullParameter(r6, "state");
        boolean r0 = r6 instanceof jd9.c.a;
        boolean r1 = false;
        if (r0 == true) goto L5;
    L21:
        this.I = r6;
        if (r0 == true) goto L24;
    L26:
        boolean r7 = r6 instanceof jd9.c.d;
        if (r7 == false) goto L29;
        this.G = true;
    L29:
        RealtimeCallUtil.a.getClass();
        if (RealtimeCallUtil.E() == false) goto L56;
        if (r7 == true) goto L33;
    L35:
        com.larus.voicecall.impl.component.bottom.b r8 = C3();
        if (r8 == null) goto L38;
        VoiceCallBottomLayout r9 = r8.BT();
    L39:
        if (r0 == false) goto L49;
        if (r9 == null) goto L57;
        com.larus.av_call.view.b r10 = r9.getRightDynamicButton();
        if (r10 != null) goto L44;
        return;
    L44:
        if (this.K == 7) goto L46;
        r1 = true;
    L46:
        h88.d r11 = r10.c;
        if (r11 == null) goto L59;
        r11.a(r1);
        return;
    L59:
        return;
    L57:
        return;
    L49:
        if (r9 == null) goto L61;
        com.larus.av_call.view.b r12 = r9.getRightDynamicButton();
        if (r12 == null) goto L62;
        h88.d r13 = r12.c;
        if (r13 == null) goto L63;
        r13.a(false);
        return;
    L63:
        return;
    L62:
        return;
    L61:
        return;
    L38:
        r9 = null;
        goto L39
    L33:
        if (D5() == false) goto L35;
        p3(ExitVideoModalReason.EXIT_FOR_DISCONNECT, true);
        this.H = true;
        j4("lose_internet_connection");
        goto L35
    L56:
        return;
    L24:
        if (this.W == true) goto L26;
        this.W = true;
        E3().y("onConnectionStateChanged");
        goto L26
    L5:
        if (z2.a.O1() == false) goto L21;
        if (this.G == false) goto L21;
        if (D5() == false) goto L14;
        com.larus.voicecall.impl.plugins.o1 r2 = E3().z();
        if (r2 == null) goto L20;
        r2.r0();
    L20:
        FLogger.a.i("RealtimeVideoComponent", "onConnectionStateChanged videoCaptureStarted=" + D5() + " isScreenShare=" + ((h88.b) Q3()).t + " hasPendingCloseVideo=" + this.H);
        this.H = false;
        goto L21
    L14:
        if (((h88.b) Q3()).t == true) goto L20;
        if (this.H == false) goto L20;
        com.larus.voicecall.impl.plugins.o1 r3 = E3().z();
        if (r3 == null) goto L20;
        r3.v2();
        goto L20
    }

    @Override // naa.b
    public final void PW(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        if (D5() == false) goto L6;
        ExitVideoModalReason r3 = ExitVideoModalReason.O_EXIT_VIDEO_MODAL;
        p3(r3, true);
        j4(r3.getStr());
        return;
    }

    public final boolean V4(boolean r8) {
        String r1 = null;
        boolean r2 = false;
        if (i4() == false) goto L21;
        RealtimeCallUtil.a.getClass();
        if (((Boolean) RealtimeCallUtil.s.getValue()).booleanValue() == false) goto L21;
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r0 = G3();
        if (r0 == null) goto L9;
        r3a.l r3 = r0.getCurrentState();
    L11:
        if ((r3 instanceof com.larus.voicecall.impl.component.vlm.camera.camera_state.a) == false) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L21;
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r5 = G3();
        if (r5 == null) goto L21;
        r5.openCamera();
        goto L21
    L13:
        if ((r3 instanceof com.larus.voicecall.impl.component.vlm.camera.camera_state.b) == true) goto L16;
        r4 = false;
        goto L17
    L9:
        r3 = null;
    L21:
        com.larus.voicecall.impl.plugins.o1 r6 = E3().z();
        if (r6 == null) goto L24;
        r2 = r6.M2(a4(), r8, Z3());
    L24:
        if (r2 == false) goto L33;
        int r9 = com.larus.voicecall.impl.util.x0.a;
        e3a.b r10 = Q3();
        e3a.a r7 = B3();
        Intrinsics.checkNotNullParameter(r10, "runtimeData");
        Intrinsics.checkNotNullParameter(r7, "argumentData");
        com.larus.platform.service.o r11 = com.larus.platform.service.o.a;
        JSONObject r12 = new JSONObject();
        r12.put("current_page", "chat");
        RealtimeCallParam.c r13 = r10.a().p.o;
        if (r13 == null) goto L28;
        String r14 = r13.a;
    L29:
        r12.put("action_bar_item_id", r14);
        RealtimeCallParam.c r15 = r10.a().p.o;
        if (r15 == null) goto L32;
        r1 = r15.d;
    L32:
        r12.put("action_bar_key", r1);
        com.larus.voicecall.impl.util.x0.a(r12, r10.a(), r7);
        Unit r16 = Unit.INSTANCE;
        r11.reportEvent("start_video_capture", r12);
        goto L33
    L28:
        r14 = null;
    L33:
        return r2;
    }

    @Override // com.larus.voicecall.impl.component.vlm.b
    public final void Y80(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        if (D5() == true) goto L6;
        FLogger.a.e("RealtimeVideoComponent", "switchPopMode but videoCaptureStarted is false");
        return;
    L6:
        com.larus.voicecall.impl.video.n r1 = this.N;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "reason");
        r1.a(VideoPreviewState.pip, r4, new com.larus.voicecall.impl.video.j());
    }

    public final void j4(String r5) {
        if (this.Q == true) goto L6;
        ((IRealtimeCallTracer) this.v.getValue()).k0(r5, Q3().a(), Intrinsics.areEqual(this.N.b.getValue(), Boolean.TRUE), B3());
        this.Q = true;
        return;
    }

    public final void l4(boolean r7) {
        int r0 = com.larus.voicecall.impl.util.x0.a;
        e3a.b r1 = Q3();
        e3a.a r2 = B3();
        Intrinsics.checkNotNullParameter(r1, "runtimeData");
        Intrinsics.checkNotNullParameter(r2, "argumentData");
        com.larus.platform.service.o r3 = com.larus.platform.service.o.a;
        JSONObject r4 = new JSONObject();
        r4.put("current_page", "chat");
        com.larus.voicecall.impl.util.x0.a(r4, r1.a(), r2);
        r4.put("is_ve_capture", r7 ? 1 : 0);
        Unit r8 = Unit.INSTANCE;
        r3.reportEvent("video_call_first_frame", r4);
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), Dispatchers.getMain(), null, new RealtimeVideoComponent$onFirstFrameCapture$1(this, null), 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [com.larus.voicecall.impl.component.vlm.h1] */
    /* JADX WARN: Type inference failed for: r4v8, types: [com.larus.voicecall.impl.component.vlm.r1] */
    /* JADX WARN: Type inference failed for: r4v9, types: [com.larus.voicecall.impl.component.vlm.i1] */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.larus.voicecall.impl.component.vlm.m1] */
    public final void onViewCreated(View r9) {
        Intrinsics.checkNotNullParameter(r9, "view");
        FLogger r0 = FLogger.a;
        r0.d("RealtimeVideoComponent", "onViewCreated width=" + r9.getWidth() + " height=" + r9.getHeight());
        z2 r10 = z2.a;
        final boolean r2 = r10.getRealtimeCallNewStyleConfig().b();
        if (r2 == false) goto L8;
        ImageView r3 = X3();
        if (r3 == null) goto L8;
        r3.setImageResource(2131242162);
    L8:
        if (r10.realtimeTalkbackOptEnable() == true) goto L10;
    L17:
        ImageView r4 = X3();
        if (r4 == null) goto L20;
        com.larus.utils.e1.d(r4, new e1(this, r2));
    L20:
        com.larus.voicecall.impl.plugins.o1 r5 = E3().z();
        if (r5 == null) goto L23;
        r5.A1(new f1(this));
    L23:
        ((w3a.k) this.X.getValue()).c(new k2(this));
        com.larus.voicecall.impl.component.bottom.b r6 = C3();
        if (r6 == null) goto L28;
        VoiceCallBottomLayout r7 = r6.BT();
        if (r7 == null) goto L28;
        r7.setLLMVideoBtnClickListener(new g1(this));
    L28:
        FrameLayout r8 = c4();
        boolean r11 = false;
        if (r8 == null) goto L31;
        r8.addView(a4(), 0, new ViewGroup.LayoutParams(-1, -1));
    L31:
        RealtimeCallUtil.a.getClass();
        if (((Boolean) RealtimeCallUtil.i0.getValue()).booleanValue() == true) goto L37;
        FrameLayout r12 = c4();
        if (r12 == null) goto L37;
        com.larus.utils.e1.q(r12);
    L37:
        if (i4() == false) goto L47;
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r13 = G3();
        if (r13 == null) goto L41;
        r13.m(a4());
    L41:
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r14 = G3();
        if (r14 == 0) goto L44;
        r14.j(new h1(this));
    L44:
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r15 = G3();
        if (r15 == 0) goto L47;
        r15.q(new i1(this));
    L47:
        MutableLiveData<Boolean> r16 = this.N.b;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r16.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), new f(new l1(this)));
        com.larus.voicecall.impl.component.core.a r17 = (com.larus.voicecall.impl.component.core.a) this.q.getValue();
        if (r17 == 0) goto L51;
        r17.yK(new m1(this));
    L51:
        if (((h88.a) B3()).m == false) goto L68;
        FrameLayout r18 = c4();
        if (r18 == null) goto L56;
        r18.setBackgroundResource(2131103292);
    L56:
        if (((Boolean) this.w.getValue()).booleanValue() == false) goto L61;
        Pair<Boolean, Boolean> r19 = com.larus.voicecall.impl.l.i;
        if (i3.a.i() == false) goto L61;
        boolean r20 = false;
    L62:
        Pair<Boolean, Boolean> r21 = com.larus.voicecall.impl.l.i;
        if (com.larus.voicecall.impl.l.a.b(getActivity()) == false) goto L68;
        if (r20 == false) goto L68;
        com.larus.voicecall.impl.component.core.a r22 = (com.larus.voicecall.impl.component.core.a) this.q.getValue();
        if (r22 == null) goto L68;
        r22.tF("videoWrapper_onViewCreated", false, new o1());
    L61:
        r20 = true;
    L68:
        com.larus.voicecall.impl.plugins.o1 r23 = E3().z();
        if (r23 == null) goto L71;
        r23.r2(new p1(this));
    L71:
        MutableLiveData<VideoPreviewState> r24 = this.N.c;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r24.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), new f(new q1(this)));
        com.larus.voicecall.impl.plugins.o1 r25 = E3().z();
        if (r25 == 0) goto L74;
        r25.W0(new r1(this));
    L74:
        StringBuilder r26 = new StringBuilder("[flashlight_debug] setupFlashlight, flashlightIconNull=");
        if (IF() != null) goto L77;
        r11 = true;
    L77:
        r26.append(r11);
        r26.append(", initialVisibility=");
        ImageView r27 = IF();
        Boolean r28 = null;
        if (r27 == null) goto L80;
        Integer r29 = Integer.valueOf(r27.getVisibility());
    L81:
        r26.append(r29);
        r26.append(", initialSelected=");
        ImageView r30 = IF();
        if (r30 == null) goto L84;
        r28 = Boolean.valueOf(r30.isSelected());
    L84:
        r26.append(r28);
        r26.append(", isVeCaptureEnable=");
        r26.append(i4());
        r26.append(", useTwoLine=");
        r26.append(r10.realtimeCallUseTwoLineStyle());
        r0.i("RealtimeVideoComponent", r26.toString());
        ImageView r31 = IF();
        if (r31 == null) goto L88;
        com.larus.utils.e1.d(r31, new j1(this));
    L88:
        if (RealtimeCallUtil.h == false) goto L90;
        ((t3a.g) t3a.g.j.getValue()).i = this.P0;
    L91:
        AppHost.a.a().j(this.p0);
        if (((h88.a) B3()).m == false) goto L94;
        int r32 = com.larus.voicecall.impl.util.x0.a;
        com.larus.voicecall.impl.util.x0.d(Q3(), B3(), e6.a.b());
    L94:
        g3a.a r33 = H3();
        if (r33 == null) goto L100;
        ZoomableTextureView r34 = r33.iB();
        if (r34 == null) goto L101;
        r34.setGestureListener(new e(this));
        return;
    L101:
        return;
    L100:
        return;
    L90:
        com.larus.voicecall.impl.video.y r35 = (com.larus.voicecall.impl.video.y) this.P.getValue();
        Function0<Unit> r1 = new a1(this);
        r35.getClass();
        Intrinsics.checkNotNullParameter(r1, "action");
        r35.i = r1;
        goto L91
    L80:
        r29 = null;
        goto L81
    L10:
        if (Intrinsics.areEqual(this.N.b.getValue(), Boolean.TRUE) == false) goto L14;
        ImageView r36 = X3();
        if (r36 == null) goto L17;
        r36.setContentDescription(getContext().getString(2131898819));
        goto L17
    L14:
        ImageView r37 = X3();
        if (r37 == null) goto L17;
        r37.setContentDescription(getContext().getString(2131898820));
        goto L17
    }

    public final Object z3(Continuation<? super Boolean> r9) {
        z2 r0 = z2.a;
        boolean r5 = false;
        if (r0.getRealtimeCallNewStyleConfig().e() == true) goto L6;
        FLogger.a.i("RealtimeVideoComponent", "[flashlight_debug] enableFlashlight=false, reason=useFlashlight_config_false, isCameraBack=" + this.N.b.getValue() + ", previewState=" + this.N.c.getValue() + ", videoCaptureStarted=" + D5() + ", useTwoLine=" + r0.realtimeCallUseTwoLineStyle());
    L18:
        return Boxing.boxBoolean(r5);
    L6:
        if (i4() == false) goto L20;
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r10 = G3();
        if (r10 != null) goto L10;
    L12:
        boolean r11 = false;
    L13:
        FLogger r1 = FLogger.a;
        StringBuilder r6 = new StringBuilder("[flashlight_debug] enableFlashlight check ve, result=");
        r6.append(r11);
        r6.append(", isTorchSupported=");
        r6.append(r11);
        r6.append(", isCameraBack=");
        r6.append(this.N.b.getValue());
        r6.append(", previewState=");
        r6.append(this.N.c.getValue());
        r6.append(", videoCaptureStarted=");
        r6.append(D5());
        r6.append(", cameraManagerNull=");
        if (G3() != null) goto L16;
        r5 = true;
    L16:
        r6.append(r5);
        r1.i("RealtimeVideoComponent", r6.toString());
        r5 = r11;
        goto L18
    L10:
        if (r10.isCameraTorchSupported() != true) goto L12;
        r11 = true;
        goto L13
    L20:
        return BuildersKt.withContext(Dispatchers.getIO(), new RealtimeVideoComponent$enableFlashlight$2(this, null), r9);
    }

    public static final boolean m3(RealtimeVideoComponent r0, String r1) {
        r0.getClass();
        if (Intrinsics.areEqual(r1, "switch_camera") == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, "close_video") == true) goto L10;
        if (Intrinsics.areEqual(r1, "pip_video_view") == true) goto L10;
        return false;
    }

    public final boolean T4(View r6, t3a.e r7) {
        Intrinsics.checkNotNullParameter(r6, "videoView");
    L18:
        e = move-exception;
        FLogger.a.e("RealtimeVideoComponent", "show global float window error: " + e.getMessage(), e);
        return false;
    L4:
        if (z2.a.D0() == false) goto L6;
        ((t3a.g) t3a.g.j.getValue()).i = this.P0;     // Catch: Exception -> L18
    L6:
        FLogger.a.i("RealtimeVideoComponent", "show global float window");     // Catch: Exception -> L18
        if (r7 != null) goto L9;
        r7 = new t3a.e(0);     // Catch: Exception -> L18
    L9:
        boolean r8 = ((t3a.g) t3a.g.j.getValue()).c(r6, r7);     // Catch: Exception -> L18
        if (r8 == false) goto L23;
        int r2 = r7.a;     // Catch: Exception -> L18
        int r9 = r7.b;     // Catch: Exception -> L18
        VEDisplaySettings.VEDisplayFitMode r3 = VEDisplaySettings.VEDisplayFitMode.SCALE_MODE_CENTER_CROP;     // Catch: Exception -> L18
        if (i4() == false) goto L23;
        com.larus.voicecall.impl.component.vlm.camera.camera_state.f r4 = G3();     // Catch: Exception -> L18
        if (r4 == null) goto L23;
        r4.e(r2, r9, r3);     // Catch: Exception -> L18
    L23:
        return r8;
    }

    @Override // com.larus.voicecall.impl.component.vlm.b
    public final void c30(ExitVideoModalReason r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        if (D5() == false) goto L6;
        p3(r2, r3);
        j4(r2.getStr());
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.voicecall.impl.component.vlm.x0] */
    public final void p3(ExitVideoModalReason r2, final boolean r3) {
        if (r2 == ExitVideoModalReason.OPEN_SHARE_SCREEN) goto L5;
    L7:
        boolean r4 = com.bytedance.apm.util.u.a();
        final ?? r0 = new x0(this, r3);
        if (r4 == false) goto L10;
        r0.run();
        return;
    L10:
        a4().post(new y0(r0));
        return;
    L5:
        if (((h88.a) B3()).k0 == false) goto L7;
        this.H0 = false;
        goto L7
    }

    public final void z2(String r7, Object r8) {
        Intrinsics.checkNotNullParameter(r7, "event");
        Intrinsics.checkNotNullParameter(r7, "event");
        if (Intrinsics.areEqual(r7, "OTHER_EVENT_RTC_FIRST_LOCAL_VIDEO_FRAME_CAPTURED") == false) goto L6;
        com.larus.platform.service.o r9 = com.larus.platform.service.o.a;
        JSONObject r10 = new JSONObject();
        r10.put("duration", -1);
        r10.put("camera_type", "rtc");
        Unit r0 = Unit.INSTANCE;
        r9.reportEvent("flow_video_capture_first_frame", r10);
        return;
    L6:
        if (Intrinsics.areEqual(r7, "OTHER_EVENT_RTC_VIDEO_STOPPED") == false) goto L28;
    L22:
        th = move-exception;
        FLogger.a.e("RealtimeVideoComponent", "otherEvent err event=" + r7 + ", content=" + r8);
        StringBuilder r11 = new StringBuilder("video on error. msg=");
        r11.append(th);
        EnsureManager.ensureNotReachHere(r11.toString());
        return;
    L8:
        if ((r8 instanceof String) == false) goto L11;
        String r2 = (String) r8;     // Catch: Throwable -> L22
    L13:
        if (r2 != null) goto L15;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L15:
        JSONObject r4 = new JSONObject(r2);     // Catch: Throwable -> L22
        int r3 = JSONObjectProtectorUtils.getInt(r4, "device_state");     // Catch: Throwable -> L22
        int r5 = JSONObjectProtectorUtils.getInt(r4, "device_error");     // Catch: Throwable -> L22
        if (D5() == true) goto L18;
        return;
    L18:
        if (r3 != 3) goto L30;
        if (r5 <= 0) goto L31;
        k4(r3, r5, false, NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L22
        FLogger.a.e("RealtimeVideoComponent", "exit video call for rtc error. payload=" + r8);     // Catch: Throwable -> L22
        c30(ExitVideoModalReason.EXIT_FOR_RTC_ERROR, true);     // Catch: Throwable -> L22
        return;
    L31:
        return;
    L30:
        return;
    L11:
        r2 = null;
        goto L13
    }

    public final void q4(String r11, Function0 r12, m0 r13) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)), Dispatchers.getMain().plus(new h2(CoroutineExceptionHandler.Key, r11, this)), null, new RealtimeVideoComponent$requestCameraPermission$2(this, r11, r12, r13, null), 2, null);
    }

    public final void v4(boolean r12, String r13, long r14) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[flashlight_debug] resetFlashlightIcon request, show=");
        r1.append(r12);
        r1.append(", reason=");
        r1.append(r13);
        r1.append(", delayTime=");
        r1.append(r14);
        r1.append(", oldJobActive=");
        Job r2 = this.B;
        if (r2 == null) goto L5;
        Boolean r3 = Boolean.valueOf(r2.isActive());
    L6:
        r1.append(r3);
        r1.append(", oldVisibility=");
        ImageView r4 = IF();
        if (r4 == null) goto L9;
        Integer r5 = Integer.valueOf(r4.getVisibility());
    L10:
        r1.append(r5);
        r1.append(", oldSelected=");
        ImageView r6 = IF();
        if (r6 == null) goto L13;
        Boolean r7 = Boolean.valueOf(r6.isSelected());
    L14:
        r1.append(r7);
        r1.append(", isCameraBack=");
        r1.append(this.N.b.getValue());
        r1.append(", previewState=");
        r1.append(this.N.c.getValue());
        r1.append(", videoCaptureStarted=");
        r1.append(D5());
        r0.i("RealtimeVideoComponent", r1.toString());
        Job r8 = this.B;
        if (r8 == null) goto L17;
        Job.DefaultImpls.cancel$default(r8, null, 1, null);
    L17:
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.B = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), null, null, new RealtimeVideoComponent$resetFlashlightIcon$1(r14, this, r12, r13, null), 3, null);
        return;
    L13:
        r7 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void k4(int r4, int r5, boolean r6, String r7) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("is_checkout_modal_error", r6);
        r1.put("error_msg", r7);
        r1.put("device_state", r4);
        r1.put("device_error", r5);
        r1.put("modal_type", "video_call");
        int r8 = com.larus.voicecall.impl.util.x0.a;
        com.larus.voicecall.impl.util.x0.a(r1, Q3().a(), B3());
        Unit r9 = Unit.INSTANCE;
        r0.reportEvent("realtime_vlm_call_error", r1);
    }

    public final void o1(MajorState r2, int r3, MajorState r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "currentMajorState");
        Intrinsics.checkNotNullParameter(r4, "newMajorState");
        super.o1(r2, r3, r4, r5);
        if (r5 != 14) goto L5;
        return;
    L5:
        if (r5 == 15) goto L9;
        this.K = r5;
        return;
    }
}
