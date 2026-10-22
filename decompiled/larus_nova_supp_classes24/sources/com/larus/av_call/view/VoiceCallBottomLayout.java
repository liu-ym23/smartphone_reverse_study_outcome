package com.larus.av_call.view;

import android.animation.ObjectAnimator;
import android.app.Application;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.av_call.constant.ThemeType;
import com.larus.av_call.databinding.LarusLayoutRealtimeCallBottomNewBinding;
import com.larus.av_call.databinding.LarusLayoutRealtimeCallBottomNewV2Binding;
import com.larus.av_call.model.RealtimePageMode;
import com.larus.av_call.service.IRealtimeCallConfigDependency;
import com.larus.av_call.util.RealtimeBottomMoreBtn;
import com.larus.av_call.util.ScreenWidthType;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.ChatContinuousAudioVisualizerOpt;
import com.larus.common_ui.view.CustomBarCountAudioVisualizer;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b6\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  \u00022\u00020\u00012\u00020\u0002:\u0006 \u0002¡\u0002¢\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010L\u001a\u00020GJ\u0006\u0010M\u001a\u00020GJ\u0010\u0010N\u001a\u00020G2\b\b\u0002\u0010O\u001a\u00020\u0011J\u0016\u0010P\u001a\u00020G2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010Q\u001a\u00020G2\u0006\u0010R\u001a\u00020\u0011J\b\u0010S\u001a\u00020GH\u0002JH\u0010T\u001a\u00020G2\u0006\u0010U\u001a\u00020V2\u001e\u0010W\u001a\u001a\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020G0E2\u0018\u0010X\u001a\u0014\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020G0YJ\u0014\u0010Z\u001a\u00020G2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020,0\\J\u000e\u0010]\u001a\u00020G2\u0006\u0010^\u001a\u00020,J\u0006\u0010_\u001a\u00020\u0011J\u0006\u0010`\u001a\u00020GJ\u000e\u0010a\u001a\u00020G2\u0006\u0010b\u001a\u00020,J\u0006\u0010c\u001a\u00020GJ\u0006\u0010d\u001a\u00020GJ\u0006\u0010e\u001a\u00020GJ\u0016\u0010f\u001a\u00020G2\u0006\u0010g\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010h\u001a\u00020GJ\u0006\u0010i\u001a\u00020GJ\u0006\u0010j\u001a\u00020GJ\u000e\u0010k\u001a\u00020G2\u0006\u0010l\u001a\u00020\u0011J\u0006\u0010m\u001a\u00020GJ&\u0010n\u001a\u00020G2\u0006\u0010o\u001a\u00020\b2\u0006\u0010p\u001a\u00020,2\u0006\u0010q\u001a\u00020\u00112\u0006\u0010r\u001a\u00020\bJ\u0006\u0010s\u001a\u00020GJ\u0006\u0010t\u001a\u00020GJ\u0006\u0010u\u001a\u00020GJ\u0006\u0010v\u001a\u00020GJ\u0006\u0010w\u001a\u00020GJ\u0006\u0010x\u001a\u00020GJ\u0006\u0010y\u001a\u00020GJ\u000e\u0010z\u001a\u00020G2\u0006\u0010{\u001a\u00020\u0011J\u0006\u0010|\u001a\u00020GJ\u0006\u0010}\u001a\u00020GJ\u0006\u0010~\u001a\u00020GJ\u0006\u0010\u007f\u001a\u00020GJ\u0007\u0010\u0080\u0001\u001a\u00020GJ\u0010\u0010\u0081\u0001\u001a\u00020G2\u0007\u0010\u0082\u0001\u001a\u00020\u0011J\u0012\u0010\u0083\u0001\u001a\u00020G2\u0007\u0010\u0084\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010\u0085\u0001\u001a\u00020\u00112\u0007\u0010\u0084\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010\u0086\u0001\u001a\u00020G2\u0007\u0010\u0084\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010\u0087\u0001\u001a\u00020G2\u0007\u0010\u0084\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u0088\u0001\u001a\u00020GH\u0002J\u0007\u0010\u0089\u0001\u001a\u00020GJ\t\u0010\u008a\u0001\u001a\u00020GH\u0002J\u0012\u0010\u008b\u0001\u001a\u00020G2\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010,J\u0010\u0010\u008d\u0001\u001a\u00020G2\u0007\u0010\u008e\u0001\u001a\u00020\u0011J\u0007\u0010\u008f\u0001\u001a\u00020KJ\u0007\u0010\u0090\u0001\u001a\u00020KJ\u0007\u0010\u0091\u0001\u001a\u00020KJ\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001J\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010KJ\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010KJ\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001J\u0010\u0010\u0098\u0001\u001a\u00020G2\u0007\u0010\u0099\u0001\u001a\u00020,J\u0010\u0010\u009a\u0001\u001a\u00020G2\u0007\u0010\u0099\u0001\u001a\u00020,J\u000f\u0010\u009b\u0001\u001a\u00020G2\u0006\u0010R\u001a\u00020\u0011J\u000f\u0010\u009c\u0001\u001a\u00020G2\u0006\u0010R\u001a\u00020\u0011J\u0016\u0010\u009d\u0001\u001a\u00020G2\r\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020G0\u001cJ\u0016\u0010\u009f\u0001\u001a\u00020G2\r\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020G0\u001cJ\u0010\u0010 \u0001\u001a\u00020G2\u0007\u0010¡\u0001\u001a\u00020\u0011J\n\u0010¢\u0001\u001a\u0005\u0018\u00010£\u0001J%\u0010¤\u0001\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00042\t\b\u0002\u0010¥\u0001\u001a\u00020\u00112\t\b\u0003\u0010¦\u0001\u001a\u00020\bJ\u001b\u0010§\u0001\u001a\u00020\u00112\u0007\u0010¨\u0001\u001a\u00020K2\u0007\u0010©\u0001\u001a\u00020\u0011H\u0002J/\u0010ª\u0001\u001a\u00020G2&\u0010\u009e\u0001\u001a!\u0012\u0016\u0012\u00140\u0011¢\u0006\u000f\b¬\u0001\u0012\n\b\u00ad\u0001\u0012\u0005\b\b(®\u0001\u0012\u0004\u0012\u00020G0«\u0001J\u0011\u0010¯\u0001\u001a\u00020G2\b\u0010°\u0001\u001a\u00030±\u0001J\u0010\u0010²\u0001\u001a\u00020G2\u0007\u0010\u0084\u0001\u001a\u00020\u0011J\u0012\u0010³\u0001\u001a\u00020G2\u0007\u0010´\u0001\u001a\u00020KH\u0002J\t\u0010µ\u0001\u001a\u00020GH\u0002J\t\u0010¶\u0001\u001a\u00020GH\u0002J%\u0010·\u0001\u001a\u00020G2\t\b\u0002\u0010¸\u0001\u001a\u00020\u00112\u0006\u0010{\u001a\u00020\u00112\u0007\u0010¹\u0001\u001a\u00020\u0011H\u0002J\t\u0010º\u0001\u001a\u00020\u0011H\u0002J\t\u0010½\u0001\u001a\u00020GH\u0002J\u0013\u0010¾\u0001\u001a\u00020G2\b\b\u0002\u0010O\u001a\u00020\u0011H\u0002J'\u0010¿\u0001\u001a\u00020G2\r\u0010À\u0001\u001a\b\u0012\u0004\u0012\u00020G0\u001c2\u000f\b\u0002\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00020G0\u001cJ\t\u0010Â\u0001\u001a\u00020GH\u0002J\t\u0010Ã\u0001\u001a\u00020GH\u0002J\t\u0010Ä\u0001\u001a\u00020GH\u0002J\r\u0010Å\u0001\u001a\u00020G*\u00020FH\u0002J,\u0010Æ\u0001\u001a\u00020G*\u00020F2\u000b\b\u0003\u0010Ç\u0001\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010È\u0001\u001a\u00030É\u0001H\u0002¢\u0006\u0003\u0010Ê\u0001J\r\u0010Ë\u0001\u001a\u00020G*\u00020FH\u0002J\r\u0010Ì\u0001\u001a\u00020G*\u00020FH\u0002J&\u0010Í\u0001\u001a\u00020G2\u000b\b\u0001\u0010Ç\u0001\u001a\u0004\u0018\u00010\b2\b\u0010È\u0001\u001a\u00030É\u0001H\u0002¢\u0006\u0003\u0010Î\u0001J \u0010Ï\u0001\u001a\u00020G2\n\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u00012\t\u0010Ò\u0001\u001a\u0004\u0018\u00010KH\u0002J\t\u0010Ó\u0001\u001a\u00020\bH\u0003J\t\u0010Ô\u0001\u001a\u00020\bH\u0003J\t\u0010Õ\u0001\u001a\u00020\u0011H\u0002J\u0014\u0010Ö\u0001\u001a\u00020G2\t\u0010Ò\u0001\u001a\u0004\u0018\u00010KH\u0002J\t\u0010Û\u0001\u001a\u00020GH\u0002J\t\u0010Ü\u0001\u001a\u00020GH\u0002J\t\u0010Ý\u0001\u001a\u00020GH\u0014J\u0007\u0010Þ\u0001\u001a\u00020\u0011J\u001b\u0010ß\u0001\u001a\u00020\f2\u0007\u0010à\u0001\u001a\u00020\u00112\u0007\u0010á\u0001\u001a\u00020\u0011H\u0002J\f\u0010â\u0001\u001a\u0005\u0018\u00010ã\u0001H\u0002J\r\u0010ä\u0001\u001a\u00020G*\u00020\fH\u0002J\r\u0010å\u0001\u001a\u00020G*\u00020\fH\u0002J\u0013\u0010æ\u0001\u001a\u00020G2\b\u0010ç\u0001\u001a\u00030è\u0001H\u0002J\t\u0010é\u0001\u001a\u00020,H\u0002J\t\u0010ê\u0001\u001a\u00020\u0011H\u0002J\u0006\u0010.\u001a\u00020\u0011J\t\u0010ë\u0001\u001a\u00020\u0011H\u0002J\t\u0010ì\u0001\u001a\u00020\bH\u0002J\u001b\u0010í\u0001\u001a\u00020G2\u0007\u0010î\u0001\u001a\u00020\b2\u0007\u0010ï\u0001\u001a\u00020\bH\u0002J\u001b\u0010ð\u0001\u001a\u00020G2\u0007\u0010î\u0001\u001a\u00020\b2\u0007\u0010ï\u0001\u001a\u00020\bH\u0002J\n\u0010ñ\u0001\u001a\u00030ò\u0001H\u0002J\t\u0010ó\u0001\u001a\u00020GH\u0002J\n\u0010ô\u0001\u001a\u00030õ\u0001H\u0002J7\u0010ö\u0001\u001a\u00020G2\b\u0010÷\u0001\u001a\u00030õ\u00012\u0007\u0010ø\u0001\u001a\u00020K2\u0007\u0010ù\u0001\u001a\u00020\b2\u0007\u0010ú\u0001\u001a\u00020\b2\u0007\u0010û\u0001\u001a\u00020\bH\u0002J\t\u0010ü\u0001\u001a\u00020GH\u0002J\t\u0010ý\u0001\u001a\u00020\bH\u0002J\t\u0010þ\u0001\u001a\u00020\bH\u0002J\u0016\u0010ÿ\u0001\u001a\u0004\u0018\u00010K2\t\b\u0001\u0010\u0080\u0002\u001a\u00020\bH\u0002J\u001b\u0010\u0081\u0002\u001a\u00020G2\u0007\u0010î\u0001\u001a\u00020\b2\u0007\u0010ï\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u0082\u0002\u001a\u00020G2\u0007\u0010\u0083\u0002\u001a\u00020\bH\u0002J\u0012\u0010\u0084\u0002\u001a\u00020G2\u0007\u0010\u0085\u0002\u001a\u00020\bH\u0002J\u0012\u0010\u0086\u0002\u001a\u00020G2\u0007\u0010\u0087\u0002\u001a\u00020\bH\u0002J\t\u0010\u0088\u0002\u001a\u00020GH\u0002J\t\u0010\u0089\u0002\u001a\u00020GH\u0002J\u0012\u0010\u008a\u0002\u001a\u00020G2\u0007\u0010\u008b\u0002\u001a\u00020\u0011H\u0002J\t\u0010\u008c\u0002\u001a\u00020GH\u0002J\t\u0010\u008d\u0002\u001a\u00020GH\u0002J\t\u0010\u008e\u0002\u001a\u00020GH\u0002J\t\u0010\u008f\u0002\u001a\u00020\bH\u0003J\u0014\u0010\u0090\u0002\u001a\u00020,2\t\b\u0003\u0010\u0091\u0002\u001a\u00020\bH\u0002J\u0012\u0010\u0092\u0002\u001a\u00020G2\u0007\u0010\u0093\u0002\u001a\u00020\u0011H\u0002J\t\u0010\u0094\u0002\u001a\u00020\bH\u0003J\u0015\u0010\u0095\u0002\u001a\u00030\u0096\u00022\t\b\u0001\u0010\u0097\u0002\u001a\u00020\bH\u0002J#\u0010\u0098\u0002\u001a\u00020G2\u0006\u0010*\u001a\u00020\u00112\u0007\u0010\u0093\u0002\u001a\u00020\u00112\u0007\u0010\u0099\u0002\u001a\u00020\u0011H\u0016J\u0007\u0010\u009a\u0002\u001a\u00020GJ\u0010\u0010\u009b\u0002\u001a\u00020G2\u0007\u0010\u009c\u0002\u001a\u00020\u0011J)\u0010\u009d\u0002\u001a\u000f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u009e\u00022\b\u0010ç\u0001\u001a\u00030è\u00012\u0007\u0010\u009f\u0002\u001a\u00020\bH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\"\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u000e\u0010)\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R \u00106\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R\u0014\u00109\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u0016R\u0014\u0010;\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u0016R\u0014\u0010=\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0016R\"\u0010@\u001a\u0004\u0018\u00010,2\b\u0010?\u001a\u0004\u0018\u00010,@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010D\u001a\u001c\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020G\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010H\u001a\u001c\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020G\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010J\u001a\u001c\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020G\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010»\u0001\u001a\u00030¼\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010×\u0001\u001a\u0005\u0018\u00010Ø\u0001*\u00020\f8BX\u0082\u0004¢\u0006\b\u001a\u0006\bÙ\u0001\u0010Ú\u0001¨\u0006£\u0002"}, d2 = {"Lcom/larus/av_call/view/VoiceCallBottomLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/av_call/view/IRealCallDayNight;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomBinding", "Lcom/larus/av_call/view/IBottomLayout;", "delayShowInterruptBtnJob", "Lkotlinx/coroutines/Job;", "currentState", "isDeepThink", "", "configDependency", "Lcom/larus/av_call/service/IRealtimeCallConfigDependency;", "enableRtcVlm", "getEnableRtcVlm", "()Z", "runtimeData", "Lcom/larus/av_call/model/BaseRealtimeRuntimeData;", "argumentData", "Lcom/larus/av_call/model/BaseRealtimeArgumentData;", "needRefreshMoreBtn", "Lkotlin/Function0;", "getNeedRefreshMoreBtn", "()Lkotlin/jvm/functions/Function0;", "setNeedRefreshMoreBtn", "(Lkotlin/jvm/functions/Function0;)V", "themeType", "Lcom/larus/av_call/constant/ThemeType;", "tracerProvider", "Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "getTracerProvider", "setTracerProvider", "isInSceneMode", "setInSceneMode", "isViewInit", "forceDarkMode", "suggestShowFrom", "", "enableV2Binding", "isUsingDoubleLineCallUI", "isInMinorMode", "enableSubtitleButton", "enableSubtitleButtonClick", "isSubtitleOpened", "statusIconAnimator", "Landroid/animation/ObjectAnimator;", "disclaimerShouldShow", "needShowBadNetNoticeBlock", "getNeedShowBadNetNoticeBlock", "setNeedShowBadNetNoticeBlock", "needShowBadNetNotice", "getNeedShowBadNetNotice", "shouldUseDoubleLineCallUI", "getShouldUseDoubleLineCallUI", "needBottomMoreBtn", "getNeedBottomMoreBtn", "value", "currentSceneKey", "setCurrentSceneKey", "(Ljava/lang/String;)V", "isShowMicAccessArea", "statusTextDarkModeUpdateTask", "Lkotlin/Function3;", "Landroid/widget/TextView;", "", "interruptViewUpdateTask", "Landroid/widget/ImageView;", "muteViewUpdateTask", "Landroid/view/View;", "onSessionStarted", "onQueryBegin", "onQueryEnd", "isForceResetText", "init", "setMinorModeEnabled", "enabled", "changeViewSize", "initRealtimeSuggest", "switchInterval", "", "onItemClick", "onItemUpdate", "Lkotlin/Function2;", "updateRealtimeSuggest", "suggestList", "", "showRealtimeSuggest", "showFrom", "isRealtimeSuggestShowing", "hideRealtimeSuggest", "showCountDown", "showText", "hideCountDown", "releaseRealtimeSuggest", "setupConnectionUI", "updateCurrentState", "state", "onSceneModeChange", "updateBottomUIWithPlayMute", "restoreDefaultBottomUI", "showBadNetNotice", "isVisible", "refreshUiState", "onNetworkError", "errorCode", "errorMsg", "isServerLimiting", "subErrorCode", "onResume", "onMute", "onEnterScreenShare", "onExitScreenShare", "onWaiting", "onListeningAndSpeaking", "onListening", "onThinking", "deepThinking", "onSpeaking", "onEnding", "onStartLoading", "onPause", "onUnMute", "setVideoCallSelected", "selected", "enableRightDynamicButton", "enable", "shouldEnableDynamicButton", "updateVideoButtonState", "updateScreenShareButtonState", "changeUnMute", "onVideoStatesChange", "setupMuteBtn", "updateSceneModelKey", "sceneModelKey", "updateMicAccessArea", "hasPermission", "getVoiceCallHangup", "getRealtimeCallMute", "getRealtimeCallHotArea", "getRightDynamicButton", "Lcom/larus/av_call/view/DynamicButton;", "getScreenShareButton", "getPlayerMuteBtn", "getSubtitleButton", "Landroidx/appcompat/widget/AppCompatImageView;", "logPlayerMuteButtonState", "caller", "refreshPlayerMuteButtonStyle", "setSubtitleButtonEnabled", "setSubtitleButtonClickEnabled", "setTakePhotoBtnClickListener", "onClick", "setSubtitleBtnClickListener", "updateSubtitleButton", "isOpened", "moreBtnView", "Lcom/larus/av_call/util/RealtimeBottomMoreBtn;", "checkSupportTakePhoto", "forceOpen", "sceneModeToastRes", "checkSupportVideoCall", "view", "isEnable", "setLLMVideoBtnClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSelected", "setRecordData", "data", "", "switchAudioVisualizerSelfDraw", "btnSwitchAnim", "target", "refreshWaitingStatusContainer", "refreshListeningAndSpeakingStatusContainer", "showInterruptBtn", "forceShow", "isThinking", "isInInterpretScene", "modifyListeningRunnable", "Ljava/lang/Runnable;", "modifyListeningText", "resetModifyListeningText", "setAsrReject", "onCloseDenoiseClicked", "onShow", "refreshOnEndingStatusContainer", "refreshListeningStatusContainer", "refreshPausedStatusContainer", "updateStatusTextDarkMode", "applyDoubleLineStatusStyle", "iconRes", "animType", "Lcom/larus/av_call/view/VoiceCallBottomLayout$StatusIconAnimType;", "(Landroid/widget/TextView;Ljava/lang/Integer;Lcom/larus/av_call/view/VoiceCallBottomLayout$StatusIconAnimType;)V", "refreshDoubleLineStatusStyleForCurrentStateIfNeeded", "clearDoubleLineStatusIcon", "updateDoubleLineStatusIcon", "(Ljava/lang/Integer;Lcom/larus/av_call/view/VoiceCallBottomLayout$StatusIconAnimType;)V", "showStatusAnimInIconContainer", "iconContainer", "Landroid/view/ViewGroup;", "statusAnimView", "getDoubleLineStatusTextColor", "getDoubleLineStatusWaveColor", "isDoubleLineVideoStyle", "hideStatusAnimInIconContainer", "statusIconAudioVisualizer", "Lcom/larus/common_ui/view/IAudioVisualizer;", "getStatusIconAudioVisualizer", "(Lcom/larus/av_call/view/IBottomLayout;)Lcom/larus/common_ui/view/IAudioVisualizer;", "resumeStatusContainerOnUnMute", "delayShowInterruptBtn", "onDetachedFromWindow", "noShowingInterruptBtn", "getView", "openVLMOnStart", "simpleMode", "createDynamicButtonInitState", "Lcom/larus/av_call/model/DynamicButtonState;", "updateInterruptViewDarkMode", "updateMuteViewDarkMode", "setupButtons", "screenWidthType", "Lcom/larus/av_call/util/ScreenWidthType;", "getLayoutFallbackReason", "shouldUseMinorModeVoiceCallUI", "hasRightDynamicBtn", "calculateSingleLineVisibleCount", "changeToNewUI", "containerHorizontalPadding", "itemHorizontalMargin", "changeToMinorModeVoiceCallUI", "getSingleLineFourButtonLayoutMetrics", "Lcom/larus/av_call/view/VoiceCallBottomLayout$SingleLineFourButtonLayoutMetrics;", "changeToDoubleLineUI", "createDoubleLineRow", "Landroid/widget/LinearLayout;", "addChildToRow", "row", "child", "index", "buttonSizePx", "horizontalGapPx", "restoreFlatButtonContainerIfNeeded", "getFlatBottomControlContainerBottomMargin", "getDoubleLineBottomControlContainerBottomMargin", "findButtonContainer", "containerId", "changeToOldUI", "updateBottomButtonSize", "sizeDp", "updateBottomButtonSizePx", "size", "updateBottomButtonContainerSize", "sizePx", "applyDoubleLineButtonStyleIfNeeded", "updateDoubleLineMoreButtonStyle", "updateDoubleLineMoreButtonScreenShareStyle", "isScreenShare", "updateDoubleLineMuteButtonStyle", "updateDoubleLineVideoButtonStyle", "updateDoubleLinePlayMuteButtonStyle", "getDoubleLinePlayMuteButtonResource", "getDoubleLinePlayMuteButtonResourceName", "resource", "updateSubtitleButtonState", "subtitleUseCC", "getDoubleLineSubtitleButtonColor", "createOvalButtonDrawable", "Landroid/graphics/drawable/GradientDrawable;", "colorRes", "refreshThemeDayNight", "enableAudioBgSimpleColor", "refreshBottomBtn", "updateDisclaimerVisibility", "visible", "calculateContainerHorizontalPaddingAndItemHorizontalMargin", "Lkotlin/Pair;", "itemCount", "Companion", "StatusIconAnimType", "SingleLineFourButtonLayoutMetrics", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class VoiceCallBottomLayout extends ConstraintLayout {
    public static final /* synthetic */ int D = 0;
    public Function3<? super ImageView, ? super ThemeType, ? super Boolean, Unit> A;
    public Function3<? super View, ? super ThemeType, ? super Boolean, Unit> B;
    public final z C;
    public com.larus.av_call.view.c a;
    public Job b;
    public int c;
    public boolean d;
    public final IRealtimeCallConfigDependency e;
    public h88.b f;
    public h88.a g;
    public Function0<Boolean> h;
    public ThemeType i;
    public Function0<? extends IRealtimeCallTracer> j;
    public Function0<Boolean> k;
    public boolean l;
    public boolean m;
    public String n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public ObjectAnimator u;
    public boolean v;
    public Function0<Boolean> w;
    public String x;
    public boolean y;
    public Function3<? super TextView, ? super ThemeType, ? super Boolean, Unit> z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/av_call/view/VoiceCallBottomLayout$StatusIconAnimType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "ROTATE", "WAVE", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum StatusIconAnimType extends Enum<StatusIconAnimType> {
        public static final StatusIconAnimType NONE = null;
        public static final StatusIconAnimType ROTATE = null;
        public static final StatusIconAnimType WAVE = null;
        public static final /* synthetic */ StatusIconAnimType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<StatusIconAnimType> getEntries() {
            return b;
        }

        static {
            StatusIconAnimType r0 = new StatusIconAnimType("NONE", 0);
            NONE = r0;
            StatusIconAnimType r1 = new StatusIconAnimType("ROTATE", 1);
            ROTATE = r1;
            StatusIconAnimType r3 = new StatusIconAnimType("WAVE", 2);
            WAVE = r3;
            StatusIconAnimType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static StatusIconAnimType[] values() {
            return (StatusIconAnimType[]) a.clone();
        }

        public static StatusIconAnimType valueOf(String r1) {
            return (StatusIconAnimType) r27.a.a(StatusIconAnimType.class, r1);
        }

        public StatusIconAnimType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
        }

        public final String toString() {
            return "SingleLineFourButtonLayoutMetrics(containerWidthPx=" + this.a + ", buttonSizePx=" + this.b + ", containerHorizontalPadding=" + this.c + ", itemHorizontalMargin=" + this.d + ')';
        }

        public b(int r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = 0;
            this.d = r3;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[StatusIconAnimType.values().length];
            r0[StatusIconAnimType.ROTATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r0[StatusIconAnimType.WAVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[StatusIconAnimType.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            a = r0;
            int[] r1 = new int[ScreenWidthType.values().length];
            r1[ScreenWidthType.Small.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r1[ScreenWidthType.Medium.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r1[ScreenWidthType.Large.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            b = r1;
        }
    }

    static {
    }

    public VoiceCallBottomLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VoiceCallBottomLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final int getDoubleLinePlayMuteButtonResource() {
        boolean r1 = false;
        if (this.m == true) goto L8;
        Application r0 = i88.e.a;
        if (i88.e.o(this.i) == true) goto L8;
        boolean r2 = false;
    L9:
        h88.b r3 = this.f;
        if (r3 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == true) goto L17;
    L19:
        h88.b r5 = this.f;
        if (r5 != null) goto L22;
    L24:
        if (r1 == false) goto L29;
        if (r2 == false) goto L27;
        return 2131241723;
    L27:
        return 2131241722;
    L29:
        if (r7() == false) goto L31;
        return 2131240725;
    L31:
        if (r2 == false) goto L33;
        return 2131241725;
    L33:
        return 2131241724;
    L22:
        if (r5.v != true) goto L24;
        r1 = true;
        goto L24
    L17:
        if (r7() == false) goto L19;
        return 2131240724;
    L12:
        if (r3.v != true) goto L14;
        r4 = true;
    L8:
        r2 = true;
        goto L9
    }

    private final boolean getEnableRtcVlm() {
        IRealtimeCallConfigDependency r0 = this.e;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L16;
        IRealtimeCallConfigDependency r2 = this.e;
        if (r2 != null) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == true) goto L16;
    L24:
        return false;
    L12:
        if (r2.g() != true) goto L14;
        r3 = true;
    L16:
        h88.b r4 = this.f;
        if (r4 != null) goto L19;
    L21:
        boolean r5 = false;
    L22:
        if (r5 == false) goto L24;
        return true;
    L19:
        if (r4.d != true) goto L21;
        r5 = true;
        goto L22
    L5:
        if (r0.e() != true) goto L7;
        r1 = true;
        goto L8
    }

    private final int getFlatBottomControlContainerBottomMargin() {
        h88.a r0 = this.g;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L10;
        return j19.c.c(40);
    L10:
        return j19.c.c(49);
    L5:
        if (r0.k0 != true) goto L7;
        r1 = true;
        goto L7
    }

    private final boolean getNeedShowBadNetNotice() {
        return ((Boolean) this.w.invoke()).booleanValue();
    }

    private final boolean getShouldUseDoubleLineCallUI() {
        IRealtimeCallConfigDependency r0 = this.e;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.p() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void A8() {
        FLogger.a.i("VoiceCallBottomLayout", "setupConnectionUI exec");
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        UrlSpanTextView r1 = r0.n();
        r1.setText(r1.getContext().getString(2131898459));
        this.z = new v(this);
        N9(r1);
        if (getShouldUseDoubleLineCallUI() == false) goto L8;
        i6(r1, 2131240713, StatusIconAnimType.ROTATE);
    L8:
        int r2 = 0;
        r1.setVisibility(0);
        r0.n().setVisibility(0);
        ProgressBar r3 = r0.g();
        if (getShouldUseDoubleLineCallUI() == false) goto L11;
        r2 = 8;
    L11:
        r3.setVisibility(r2);
        r0.p().a(8);
        r0.q().setVisibility(8);
        r0.i().a(new w(this));
        E8();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E7() {
        com.larus.av_call.view.c r0 = this.a;
        Job r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        this.B = new l0(this);
        I9(r0);
        c6();
        n6(r0.k());
        if (this.c != 6) goto L8;
        return;
    L8:
        FLogger.a.i("VoiceCallBottomLayout", "onMute exec");
        h88.b r1 = this.f;
        if (r1 != null) goto L11;
    L13:
        boolean r3 = false;
    L14:
        int r5 = this.c;
        if (r5 == (-1)) goto L40;
        if (r5 == 1) goto L41;
        if (r3 == false) goto L19;
        return;
    L19:
        if (getNeedShowBadNetNotice() == true) goto L43;
        com.larus.av_call.view.c r4 = this.a;
        if (r4 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r4 = null;
    L23:
        UrlSpanTextView r6 = r4.n();
        this.z = new y0(this);
        N9(r6);
        if (getShouldUseDoubleLineCallUI() == false) goto L26;
        k6(this, r6, null, 3);
    L26:
        Context r7 = r6.getContext();
        if (r7 == null) goto L29;
        String r8 = r7.getString(2131908047);
    L30:
        r6.setText(r8);
        r6.setVisibility(0);
        r4.g().setVisibility(8);
        r4.p().a(8);
        r4.q().setVisibility(8);
        r4.i().a(new r(this));
        Job r9 = this.b;
        if (r9 == null) goto L33;
        Job.DefaultImpls.cancel$default(r9, null, 1, null);
    L33:
        LifecycleOwner r10 = ViewTreeLifecycleOwner.get(this);
        if (r10 == null) goto L38;
        LifecycleCoroutineScope r11 = LifecycleOwnerKt.getLifecycleScope(r10);
        if (r11 == null) goto L38;
        r2 = BuildersKt.launch$default(r11, null, null, new VoiceCallBottomLayout$delayShowInterruptBtn$1(this, null), 3, null);
    L38:
        this.b = r2;
        return;
    L29:
        r8 = null;
        goto L30
    L43:
        return;
    L41:
        return;
    L40:
        return;
    L11:
        if (r1.n != true) goto L13;
        r3 = true;
        goto L14
    }

    public final void E8() {
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        boolean r2 = false;
        r0.k().setVisibility(0);
        h88.b r1 = this.f;
        if (r1 == null) goto L11;
        if (r1.n != true) goto L11;
        r2 = true;
    L11:
        if (r2 == false) goto L17;
        this.A = new a0(this);
        D9(r0);
        AppCompatImageView r3 = r0.q();
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 == null) goto L16;
        r4.width = c7.b(44);
        r4.height = c7.b(44);
        r3.setLayoutParams(r4);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L17:
        this.A = new c0(this);
        D9(r0);
        AppCompatImageView r5 = r0.q();
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L22;
        r6.width = c7.b(18);
        r6.height = c7.b(18);
        r5.setLayoutParams(r6);
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void H7() {
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        boolean r1 = r0.n().removeCallbacks(this.C);
        FLogger.a.i("VoiceCallBottomLayout", "remove 2, delayTime: 5000, current time " + AppHost.a.getAppClock().currentTimeMillis() + ", " + r0.n() + " , result: " + r1);
        r0.n().postDelayed(this.C, (long) 5000);
    }

    public final void L7() {
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L6:
        if (getNeedShowBadNetNotice() == true) goto L9;
        r0.n().setVisibility(4);
    L9:
        if (getShouldUseDoubleLineCallUI() == false) goto L11;
        UrlSpanTextView r2 = r0.n();
        r2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        r2.setCompoundDrawablePadding(0);
        B9(null, StatusIconAnimType.NONE);
    L11:
        r0.g().setVisibility(4);
        r0.p().a(8);
        r0.q().setVisibility(8);
        E8();
    }

    public final void R7() {
        h88.b r0 = this.f;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        H6(true);
    L10:
        com.larus.av_call.view.c r3 = this.a;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r3 = null;
    L13:
        this.B = new v0(this);
        I9(r3);
        c6();
        n6(r3.k());
        int r4 = this.c;
        if (r4 != 6) goto L17;
        return;
    L17:
        if (r4 != 2) goto L19;
        n8();
        return;
    L19:
        if (r4 != 3) goto L21;
        e8();
        return;
    L21:
        if (r4 == 4) goto L37;
        if (r4 == 5) goto L37;
        if (r4 != 7) goto L27;
        g8();
        return;
    L27:
        if (r4 == 9) goto L37;
        if (r4 != 17) goto L31;
        d8();
        return;
    L31:
        if (r4 != 18) goto L52;
        C7();
        return;
    L52:
        return;
    L37:
        if (StringsKt.equals$default(this.x, "interpret_v2", false, 2, null) == false) goto L39;
        n8();
        return;
    L39:
        boolean r5 = this.d;
        if (this.c != 4) goto L42;
        r1 = true;
    L42:
        V8(true, r5, r1);
        return;
    L5:
        if (r0.n != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void T7() {
        com.larus.av_call.view.c r0 = this.a;
        com.larus.av_call.view.c r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        I9(r0);
        if (getShouldUseDoubleLineCallUI() == false) goto L15;
        com.larus.av_call.view.c r2 = this.a;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r2 = null;
    L10:
        b8(r2.n());
        com.larus.av_call.view.c r3 = this.a;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L14:
        r1.i().a(new p0(this));
        goto L15
    L13:
        r1 = r3;
    L15:
        c6();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c6() {
        if (this.o == true) goto L5;
        return;
    L5:
        if (this.p == false) goto L77;
        boolean r1 = true;
        com.larus.av_call.view.c r2 = null;
        if (H8() == false) goto L10;
        int r0 = getSingleLineFourButtonLayoutMetrics().b;
    L17:
        h9(r0);
        com.larus.av_call.view.c r3 = this.a;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r3 = null;
    L20:
        View r4 = r3.k();
        if (r7() == false) goto L32;
        h88.b r5 = this.f;
        if (r5 != null) goto L25;
    L27:
        boolean r6 = false;
    L28:
        if (r6 == false) goto L30;
        int r7 = 2131240722;
    L31:
        r4.setBackgroundResource(r7);
    L41:
        com.larus.av_call.view.c r8 = this.a;
        if (r8 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r8 = null;
    L44:
        View r9 = r8.b();
        if (r9 != null) goto L47;
    L57:
        y9();
        IRealtimeCallConfigDependency r10 = this.e;
        if (r10 != null) goto L60;
    L62:
        r1 = false;
    L63:
        V9(r1);
        int r11 = getDoubleLinePlayMuteButtonResource();
        FLogger r12 = FLogger.a;
        StringBuilder r13 = new StringBuilder("[player_mute_debug] applyDoubleLinePlayMuteButtonStyle, isSilentPlay=");
        h88.b r14 = this.f;
        if (r14 == null) goto L66;
        Boolean r15 = Boolean.valueOf(r14.v);
    L67:
        r13.append(r15);
        r13.append(", isDoubleLineVideoStyle=");
        r13.append(r7());
        r13.append(", resource=");
        r13.append(V6(r11));
        r12.i("VoiceCallBottomLayout", r13.toString());
        com.larus.av_call.view.c r16 = this.a;
        if (r16 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L71:
        View r17 = r2.e();
        if (r17 == null) goto L76;
        r17.setBackgroundResource(r11);
        return;
    L76:
        return;
    L70:
        r2 = r16;
        goto L71
    L66:
        r15 = null;
        goto L67
    L60:
        if (r10.s() != true) goto L62;
    L47:
        if (r7() == false) goto L54;
        if (r9.isSelected() == false) goto L51;
        int r19 = 2131240721;
    L52:
        r9.setBackgroundResource(r19);
        goto L57
    L51:
        r19 = 2131240720;
        goto L52
    L54:
        if (r9.isSelected() == false) goto L56;
        Application r20 = i88.e.a;
        i88.e.l(r9, this.i, this.m, false, this.g);
        goto L57
    L56:
        Application r21 = i88.e.a;
        i88.e.m(r9, this.i, this.m, false, this.g);
        goto L57
    L30:
        r7 = 2131240723;
        goto L31
    L25:
        if (r5.m != true) goto L27;
        r6 = true;
        goto L28
    L32:
        h88.b r22 = this.f;
        if (r22 != null) goto L35;
    L37:
        boolean r23 = false;
    L38:
        if (r23 == false) goto L40;
        Application r24 = i88.e.a;
        i88.e.k(r4, this.i, this.m, r22, this.g);
        goto L41
    L40:
        Application r25 = i88.e.a;
        i88.e.e(r4, this.i, this.m, r22, this.g);
        goto L41
    L35:
        if (r22.m != true) goto L37;
        r23 = true;
        goto L38
    L10:
        com.larus.av_call.view.c r26 = this.a;
        if (r26 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r26 = null;
    L14:
        if (r26.c().getOrientation() != 1) goto L16;
        r0 = getResources().getDimensionPixelSize(2131167682);
        goto L17
    L16:
        r0 = j19.c.c(66);
        goto L17
    }

    public final boolean f7() {
        IRealtimeCallConfigDependency r0 = this.e;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L19;
        IRealtimeCallConfigDependency r2 = this.e;
        if (r2 != null) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == true) goto L20;
        return false;
    L20:
        return true;
    L12:
        if (r2.e() != true) goto L14;
        r3 = true;
        goto L15
    L19:
        return true;
    L5:
        if (r0.h() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void g8() {
        FLogger.a.i("VoiceCallBottomLayout", "refreshPausedStatusContainer exec");
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        UrlSpanTextView r1 = r0.n();
        this.z = new t(this);
        N9(r1);
        if (getShouldUseDoubleLineCallUI() == false) goto L8;
        k6(this, r1, 2131240715, 2);
    L8:
        r1.setText(r1.getContext().getString(2131898477));
        int r2 = 0;
        r1.setVisibility(0);
        r0.g().setVisibility(8);
        r0.p().a(8);
        AppCompatImageView r3 = r0.q();
        if (getShouldUseDoubleLineCallUI() == false) goto L11;
        r2 = 8;
    L11:
        r3.setVisibility(r2);
        Application r4 = i88.e.a;
        i88.e.g(r0.q(), this.i, this.m, this.g);
        AppCompatImageView r5 = r0.q();
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if (r6 == null) goto L16;
        r6.width = c7.b(44);
        r6.height = c7.b(44);
        r5.setLayoutParams(r6);
        r0.i().a(new u(this));
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final View getPlayerMuteBtn() {
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L6:
        return r0.e();
    }

    public final View getRealtimeCallHotArea() {
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L6:
        return r0.l();
    }

    public final View getRealtimeCallMute() {
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L6:
        return r0.k();
    }

    public final com.larus.av_call.view.b getRightDynamicButton() {
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L6:
        return r0.f();
    }

    public final View getScreenShareButton() {
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L6:
        return r0.h();
    }

    public final AppCompatImageView getSubtitleButton() {
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L6:
        return r0.r();
    }

    public final View getVoiceCallHangup() {
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L6:
        return r0.m();
    }

    public final void l7() {
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        com.larus.utils.e1.q(r0.i());
        if (this.o == true) goto L8;
    L19:
        com.larus.av_call.view.c r1 = this.a;
        if (r1 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r1 = null;
    L22:
        o<String> r2 = r1.i().getDelegate();
        Handler r3 = r2.d;
        if (r3 != null) goto L26;
        r3 = null;
    L26:
        if (r3 == null) goto L29;
        com.larus.utils.l0.b(new j(r3));
        r2.a.invoke(null, -1);
        r2.g = 0;
        return;
    L29:
        return;
    L8:
        if (getShouldUseDoubleLineCallUI() == true) goto L10;
    L15:
        com.larus.av_call.view.c r4 = this.a;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r4 = null;
    L18:
        com.larus.utils.e1.x(r4.j());
        goto L19
    L10:
        if (this.y == false) goto L15;
        com.larus.av_call.view.c r5 = this.a;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r5 = null;
    L14:
        com.larus.utils.e1.o(r5.j());
        goto L19
    }

    public final void l8() {
        FLogger r0 = FLogger.a;
        r0.d("VoiceCallBottomLayout", "refreshUiState : currentState = " + this.c);
        int r1 = this.c;
        if (r1 != 2) goto L5;
        n8();
        E8();
        return;
    L5:
        if (r1 != 3) goto L7;
        e8();
        E8();
        return;
    L7:
        if (r1 != 4) goto L9;
        V8(false, this.d, true);
        E8();
        return;
    L9:
        if (r1 != 5) goto L11;
        E8();
        V8(false, false, false);
        return;
    L11:
        if (r1 != 17) goto L13;
        r0.d("VoiceCallBottomLayout", "onListeningAndSpeaking");
        d8();
        E8();
        return;
    L13:
        if (r1 != 18) goto L27;
        C7();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        Job r0 = this.b;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
    }

    public final boolean r7() {
        h88.b r0 = this.f;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return true;
    L10:
        if (this.m == true) goto L15;
        return false;
    L15:
        return true;
    L5:
        if (r0.r != true) goto L7;
        r1 = true;
        goto L8
    }

    public final int s6() {
        IRealtimeCallConfigDependency r0 = this.e;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
    L12:
        int r3 = 2;
    L13:
        IRealtimeCallConfigDependency r4 = this.e;
        if (r4 != null) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == false) goto L22;
        r3 = r3 + 1;
    L22:
        if (getNeedBottomMoreBtn() == false) goto L24;
        r3 = r3 + 1;
    L24:
        FLogger r6 = FLogger.a;
        StringBuilder r7 = new StringBuilder("calculateSingleLineVisibleCount result=");
        r7.append(r3);
        r7.append(", base=2(mute+hangup), addScreenShare=");
        IRealtimeCallConfigDependency r8 = this.e;
        if (r8 != null) goto L27;
    L29:
        boolean r9 = false;
    L30:
        if (r9 == true) goto L32;
    L34:
        boolean r10 = false;
    L35:
        r7.append(r10);
        r7.append(", addVideo=");
        IRealtimeCallConfigDependency r11 = this.e;
        if (r11 != null) goto L38;
    L40:
        r7.append(r1);
        r7.append(", needBottomMoreBtn=");
        r7.append(getNeedBottomMoreBtn());
        r6.i("VoiceCallBottomLayout", r7.toString());
        return r3;
    L38:
        if (r11.e() != true) goto L40;
        r1 = true;
        goto L40
    L32:
        if (getNeedBottomMoreBtn() == true) goto L34;
        r10 = true;
        goto L35
    L27:
        if (r8.g() != true) goto L29;
        r9 = true;
        goto L30
    L16:
        if (r4.e() != true) goto L18;
        r5 = true;
        goto L19
    L10:
        if (getNeedBottomMoreBtn() == true) goto L12;
        r3 = 3;
        goto L13
    L5:
        if (r0.g() != true) goto L7;
        r2 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w8() {
        if (this.a != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L5:
        FrameLayout r0 = (FrameLayout) findViewById(2131383816);
        if (r0 == null) goto L8;
        com.larus.utils.e1.o(r0);
    L8:
        setupButtons(i88.f.a(com.larus.utils.i.d(getContext())));
        a8();
    }

    public final RealtimeBottomMoreBtn y7() {
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L6:
        return r0.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y9() {
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        RealtimeBottomMoreBtn r1 = r0.a();
        if (r1 == null) goto L20;
        h88.b r2 = this.f;
        if (r2 != null) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L16;
        u9(true);
        return;
    L16:
        if (r7() == false) goto L18;
        r1.setIconVisible(true);
        GradientDrawable r4 = new GradientDrawable();
        r4.setShape(1);
        r4.setColor(ContextCompat.getColor(getContext(), 2131103175));
        r1.setBackground(r4);
        r1.setImageResource(2131239990);
        return;
    L18:
        r1.setIconVisible(true);
        Application r5 = i88.e.a;
        i88.e.c(r1, this.f);
        return;
    L10:
        if (r2.t != true) goto L12;
        r3 = true;
        goto L13
    }

    public final void z8() {
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        LinearLayout r1 = r0.c();
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L26;
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) r2;
        ((ViewGroup.MarginLayoutParams) r3).width = -1;
        ((ViewGroup.MarginLayoutParams) r3).bottomMargin = getFlatBottomControlContainerBottomMargin();
        r1.setLayoutParams(r3);
        if (r1.getOrientation() != 0) goto L11;
        f9(j19.c.c(76));
        return;
    L11:
        List r4 = CollectionsKt.listOf(new View[]{N6(2131383811), N6(2131392668), N6(2131383816), N6(2131392676), N6(2131392672), N6(2131392665), N6(2131392662), N6(2131392659)});
        r1.removeAllViews();
        r1.setOrientation(0);
        Iterator r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L24;
        View r6 = (View) r5.next();
        if (r6 == null) goto L16;
        ViewParent r7 = r6.getParent();
        if ((r7 instanceof ViewGroup) == false) goto L20;
        ViewGroup r8 = (ViewGroup) r7;
    L21:
        if (r8 == null) goto L23;
        r8.removeView(r6);
    L23:
        r1.addView(r6, new LinearLayout.LayoutParams(j19.c.c(76), j19.c.c(76)));
        goto L13
    L20:
        r8 = null;
        goto L21
    L16:
        FLogger.a.e("VoiceCallBottomLayout", "restoreFlatButtonContainerIfNeeded skip null child");
        goto L13
    L24:
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int getDoubleLineBottomControlContainerBottomMargin() {
        int r0 = getResources().getDimensionPixelSize(2131167681);
        FragmentActivity r1 = getContext();
        if ((r1 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r2 = r1;
    L7:
        return RangesKt.coerceAtLeast(r0 - com.larus.utils.u.b(r2), 0);
    L5:
        r2 = null;
        goto L7
    }

    private final int getDoubleLineStatusTextColor() {
        if (r7() == false) goto L5;
        return 2131103298;
    L5:
        return 2131103254;
    }

    private final int getDoubleLineStatusWaveColor() {
        if (r7() == false) goto L5;
        return 2131103298;
    L5:
        return 2131103143;
    }

    private final int getDoubleLineSubtitleButtonColor() {
        if (r7() == false) goto L6;
        return 2131103175;
    L6:
        if (this.t == false) goto L8;
        return 2131103250;
    L8:
        return 2131103246;
    }

    private final String getLayoutFallbackReason() {
        if (getShouldUseDoubleLineCallUI() == true) goto L6;
        return "config disabled";
    L6:
        if (H8() == true) goto L8;
    L10:
        return "unknown";
    L8:
        if (this.r == true) goto L10;
        return "minor mode subtitle disabled";
    }

    private final boolean getNeedBottomMoreBtn() {
        if (getShouldUseDoubleLineCallUI() == true) goto L14;
        h88.a r0 = this.g;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L15;
        return false;
    L15:
        return true;
    L7:
        if (r0.Z != true) goto L9;
        r1 = true;
        goto L10
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final b getSingleLineFourButtonLayoutMetrics() {
        int r0 = getResources().getDimensionPixelSize(2131167685);
        int r1 = getResources().getDimensionPixelSize(2131167686);
        return new b(r0, r1, (RangesKt.coerceAtLeast(r0 - (r1 * 4), 0) / 3) / 2);
    }

    public final void C7() {
        if (getNeedShowBadNetNotice() == false) goto L5;
        FLogger.a.i("VoiceCallBottomLayout", "onEnding needShowBadNetNotice is true");
    L12:
        E8();
        return;
    L5:
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L8:
        UrlSpanTextView r2 = r0.n();
        this.z = new e0(this);
        N9(r2);
        if (getShouldUseDoubleLineCallUI() == false) goto L11;
        k6(this, r2, null, 3);
    L11:
        r2.setText(r2.getContext().getString(2131900509));
        r2.setVisibility(0);
        r0.g().setVisibility(8);
        r0.p().a(8);
        r0.q().setVisibility(8);
        r0.i().a(new f0(this));
        goto L12
    }

    public final boolean H8() {
        if (getShouldUseDoubleLineCallUI() == true) goto L5;
        return false;
    L5:
        if (this.q == false) goto L16;
        h88.b r0 = this.f;
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (r0.r != true) goto L11;
        r1 = true;
        goto L12
    L16:
        return false;
    }

    public final void M7() {
        if (getNeedShowBadNetNotice() == false) goto L6;
        FLogger.a.i("VoiceCallBottomLayout", "[onStartLoading] refreshListeningStatusContainer needShowBadNetNotice is true");
        return;
    L6:
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L9:
        UrlSpanTextView r1 = r0.n();
        this.z = new q0(this);
        N9(r1);
        Function3<? super TextView, ? super ThemeType, ? super Boolean, Unit> r2 = this.z;
        if (r2 == null) goto L13;
        r2.invoke(r1, this.i, Boolean.valueOf(this.m));
    L13:
        if (getShouldUseDoubleLineCallUI() == false) goto L15;
        k6(this, r1, 2131240714, 2);
    L15:
        r1.setText(r1.getContext().getString(2131900625));
        int r3 = 0;
        r1.setVisibility(0);
        AppCompatImageView r4 = r0.q();
        if (getShouldUseDoubleLineCallUI() == false) goto L18;
        r3 = 8;
    L18:
        r4.setVisibility(r3);
        Application r5 = i88.e.a;
        i88.e.d(r0.q(), this.i, this.m, this.g);
        AppCompatImageView r6 = r0.q();
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L23;
        r7.width = c7.b(18);
        r7.height = c7.b(18);
        r6.setLayoutParams(r7);
        r0.g().setVisibility(8);
        r0.p().a(8);
        r0.i().a(new r0(this));
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a8() {
        setupButtons(i88.f.a(com.larus.utils.i.d(getContext())));
        boolean r1 = false;
        i8(this.m, false, false);
        h88.b r0 = this.f;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L15;
        if (r0 != null) goto L11;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == true) goto L15;
    L16:
        setVideoCallSelected(r1);
        return;
    L11:
        if (r0.s != true) goto L13;
        r2 = true;
    L15:
        r1 = true;
        goto L16
    L5:
        if (r0.r != true) goto L7;
        r3 = true;
        goto L8
    }

    public final void d8() {
        if (getNeedShowBadNetNotice() == false) goto L6;
        FLogger.a.i("VoiceCallBottomLayout", "refreshListeningStatusContainer needShowBadNetNotice is true");
        return;
    L6:
        FLogger.a.i("VoiceCallBottomLayout", "refreshListeningStatusContainer exec");
        h88.b r0 = this.f;
        int r1 = 0;
        if (r0 == null) goto L11;
        final boolean r2 = true;
        if (r0.m != true) goto L11;
    L12:
        com.larus.av_call.view.c r3 = this.a;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r3 = null;
    L15:
        UrlSpanTextView r4 = r3.n();
        this.z = new g0(this);
        N9(r4);
        Function3<? super TextView, ? super ThemeType, ? super Boolean, Unit> r5 = this.z;
        if (r5 == null) goto L19;
        r5.invoke(r4, this.i, Boolean.valueOf(this.m));
    L19:
        if (getShouldUseDoubleLineCallUI() == false) goto L24;
        if (r2 == false) goto L22;
        StatusIconAnimType r6 = StatusIconAnimType.NONE;
    L23:
        i6(r4, null, r6);
        goto L24
    L22:
        r6 = StatusIconAnimType.WAVE;
    L24:
        Context r7 = r4.getContext();
        if (r2 == false) goto L27;
        int r8 = 2131908047;
    L28:
        r4.setText(r7.getString(r8));
        r4.setVisibility(0);
        r3.n().setVisibility(0);
        r3.g().setVisibility(8);
        com.larus.common_ui.view.u r9 = r3.p();
        if (r2 == false) goto L31;
    L32:
        r1 = 8;
    L33:
        r9.a(r1);
        r3.q().setVisibility(8);
        r3.i().a(new h0(this, r2));
        return;
    L31:
        if (getShouldUseDoubleLineCallUI() == false) goto L33;
    L27:
        r8 = 2131906748;
    L11:
        r2 = false;
        goto L12
    }

    public final void e8() {
        if (getNeedShowBadNetNotice() == false) goto L6;
        FLogger.a.i("VoiceCallBottomLayout", "refreshListeningStatusContainer needShowBadNetNotice is true");
        return;
    L6:
        FLogger.a.i("VoiceCallBottomLayout", "refreshListeningStatusContainer exec");
        h88.b r0 = this.f;
        int r1 = 0;
        if (r0 == null) goto L11;
        final boolean r2 = true;
        if (r0.m != true) goto L11;
    L12:
        com.larus.av_call.view.c r3 = this.a;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r3 = null;
    L15:
        UrlSpanTextView r4 = r3.n();
        this.z = new m0(this);
        N9(r4);
        Function3<? super TextView, ? super ThemeType, ? super Boolean, Unit> r5 = this.z;
        if (r5 == null) goto L19;
        r5.invoke(r4, this.i, Boolean.valueOf(this.m));
    L19:
        if (getShouldUseDoubleLineCallUI() == false) goto L24;
        if (r2 == false) goto L22;
        StatusIconAnimType r6 = StatusIconAnimType.NONE;
    L23:
        i6(r4, null, r6);
        goto L24
    L22:
        r6 = StatusIconAnimType.WAVE;
    L24:
        Context r7 = r4.getContext();
        if (r2 == false) goto L27;
        int r8 = 2131908047;
    L28:
        r4.setText(r7.getString(r8));
        r4.setVisibility(0);
        r3.n().setVisibility(0);
        r3.g().setVisibility(8);
        com.larus.common_ui.view.u r9 = r3.p();
        if (r2 == false) goto L31;
    L32:
        r1 = 8;
    L33:
        r9.a(r1);
        r3.q().setVisibility(8);
        r3.i().a(new s0(this, r2));
        return;
    L31:
        if (getShouldUseDoubleLineCallUI() == false) goto L33;
    L27:
        r8 = 2131898446;
    L11:
        r2 = false;
        goto L12
    }

    public final void n8() {
        if (getNeedShowBadNetNotice() == false) goto L6;
        FLogger.a.i("VoiceCallBottomLayout", "refreshWaitingStatusContainer needShowBadNetNotice is true");
        return;
    L6:
        FLogger.a.i("VoiceCallBottomLayout", "exec refreshWaitingStatusContainer needShowBadNetNotice is false");
        h88.b r0 = this.f;
        int r1 = 0;
        if (r0 == null) goto L11;
        final boolean r2 = true;
        if (r0.m != true) goto L11;
    L12:
        com.larus.av_call.view.c r3 = this.a;
        Integer r4 = null;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r3 = null;
    L15:
        UrlSpanTextView r5 = r3.n();
        this.z = new t0(this);
        N9(r5);
        Context r6 = r5.getContext();
        if (r2 == false) goto L18;
        int r7 = 2131908047;
    L19:
        r5.setText(r6.getString(r7));
        if (getShouldUseDoubleLineCallUI() == false) goto L25;
        if (r2 == true) goto L24;
        r4 = 2131240715;
    L24:
        i6(r5, r4, StatusIconAnimType.NONE);
    L25:
        r5.setVisibility(0);
        r3.n().setVisibility(0);
        r3.g().setVisibility(8);
        com.larus.common_ui.view.u r8 = r3.p();
        if (r2 == false) goto L28;
    L29:
        r1 = 8;
    L30:
        r8.a(r1);
        r3.q().setVisibility(8);
        r3.i().a(new u0(this, r2));
        return;
    L28:
        if (getShouldUseDoubleLineCallUI() == false) goto L30;
    L18:
        r7 = 2131898476;
    L11:
        r2 = false;
        goto L12
    }

    public final Function0<Boolean> getNeedRefreshMoreBtn() {
        return this.h;
    }

    public final Function0<Boolean> getNeedShowBadNetNoticeBlock() {
        return this.w;
    }

    public final Function0<IRealtimeCallTracer> getTracerProvider() {
        return this.j;
    }

    public static String V6(int r2) {
        if (r2 != 2131240724) goto L6;
        return "larus_figma_ic_video_speaker_off";
    L6:
        if (r2 != 2131240725) goto L9;
        return "larus_figma_ic_video_speaker_on";
    L9:
        if (r2 != 2131241722) goto L12;
        return "larus_ic_player_off";
    L12:
        if (r2 != 2131241724) goto L15;
        return "larus_ic_player_on";
    L15:
        return "unknown(" + r2 + ')';
    }

    public static com.larus.common_ui.view.u W6(com.larus.av_call.view.c r1) {
        return r1.j().findViewById(2131383826);
    }

    public static final h88.d Z5(VoiceCallBottomLayout r4) {
        h88.b r0 = r4.f;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        IRealtimeCallConfigDependency r3 = r4.e;
        if (r3 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == true) goto L28;
        IRealtimeCallConfigDependency r6 = r4.e;
        if (r6 != null) goto L19;
    L21:
        if (r1 == false) goto L24;
        return new h88.f();
    L24:
        if (r4.getEnableRtcVlm() == true) goto L30;
        return null;
    L30:
        return new h88.e();
    L19:
        if (r6.l(r2) != true) goto L21;
        r1 = true;
        goto L21
    L28:
        return new h88.e();
    L11:
        if (r3.e() != true) goto L13;
        r5 = true;
        goto L14
    L5:
        if (r0.d != true) goto L7;
        r2 = true;
        goto L8
    }

    public static void n6(View r4) {
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r4, "alpha", new float[]{0.0f, 1.0f});
        r5.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
        r5.setDuration(100);
        r5.start();
    }

    private final void setCurrentSceneKey(String r4) {
        boolean r1 = true;
        if (TextUtils.isEmpty(r4) == true) goto L13;
        h88.a r0 = this.g;
        if (r0 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == true) goto L13;
        r1 = false;
        goto L13
    L7:
        if (r0.k0 != true) goto L9;
        r2 = true;
    L13:
        H6(r1);
        this.x = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setupButtons(ScreenWidthType r19) {
        if (this.o == false) goto L245;
        boolean r2 = H8();
        if (getShouldUseDoubleLineCallUI() == false) goto L10;
        if (r2 == true) goto L8;
    L26:
        boolean r11 = true;
    L27:
        if (r2 == false) goto L30;
        int r3 = 4;
    L33:
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("setupButtons decision, screenWidthType=");
        r15.append(r19);
        r15.append(", screenWidth=");
        r15.append(com.larus.utils.i.d(getContext()));
        r15.append(", shouldUseDoubleLineCallUI=");
        r15.append(getShouldUseDoubleLineCallUI());
        r15.append(", expectedCount=");
        r15.append(r3);
        r15.append(", shouldUseNewLayout=");
        r15.append(r11);
        r15.append(", shouldUseMinorModeVoiceCallUI=");
        r15.append(r2);
        r15.append(", isInMinorMode=");
        r15.append(this.q);
        r15.append(", hasRightDynamicBtn=");
        r15.append(f7());
        r15.append(", needBottomMoreBtn=");
        r15.append(getNeedBottomMoreBtn());
        r15.append(", argumentNeedBottomMore=");
        h88.a r4 = this.g;
        if (r4 == null) goto L36;
        Boolean r5 = Boolean.valueOf(r4.Z);
    L37:
        r15.append(r5);
        r15.append(", useNewInteractionStyle=");
        h88.a r6 = this.g;
        if (r6 == null) goto L40;
        Boolean r7 = Boolean.valueOf(r6.k0);
    L41:
        r15.append(r7);
        r15.append(", simpleMode=");
        h88.a r8 = this.g;
        if (r8 == null) goto L44;
        Boolean r9 = Boolean.valueOf(r8.T);
    L45:
        r15.append(r9);
        r15.append(", openVLMOnStart=");
        h88.a r10 = this.g;
        if (r10 == null) goto L48;
        Boolean r12 = Boolean.valueOf(r10.m);
    L49:
        r15.append(r12);
        r15.append(", runtimeIsScreenShare=");
        h88.b r13 = this.f;
        if (r13 == null) goto L52;
        Boolean r16 = Boolean.valueOf(r13.t);
    L53:
        r15.append(r16);
        r15.append(", runtimeIsFullVideo=");
        h88.b r17 = this.f;
        if (r17 == null) goto L56;
        Boolean r20 = Boolean.valueOf(r17.r);
    L57:
        r15.append(r20);
        r15.append(", runtimeIsPipVideo=");
        h88.b r21 = this.f;
        if (r21 == null) goto L60;
        Boolean r22 = Boolean.valueOf(r21.s);
    L61:
        r15.append(r22);
        r15.append(", isVideoEnable=");
        IRealtimeCallConfigDependency r23 = this.e;
        if (r23 == null) goto L64;
        Boolean r24 = Boolean.valueOf(r23.e());
    L65:
        r15.append(r24);
        r15.append(", isScreenShareEnable=");
        IRealtimeCallConfigDependency r25 = this.e;
        if (r25 == null) goto L68;
        Boolean r26 = Boolean.valueOf(r25.g());
    L69:
        r15.append(r26);
        r15.append(", isTakePhotoEnable=");
        IRealtimeCallConfigDependency r27 = this.e;
        if (r27 == null) goto L72;
        Boolean r29 = Boolean.valueOf(r27.h());
    L73:
        r15.append(r29);
        r14.i("VoiceCallBottomLayout", r15.toString());
        if (r11 == false) goto L217;
        r14.i("VoiceCallBottomLayout", "setupButtons use new ui");
        this.p = getShouldUseDoubleLineCallUI();
        if (r2 == false) goto L79;
        int r30 = 4;
    L82:
        Pair<Integer, Integer> r1 = o6(r19, r30);
        int r31 = ((Number) r1.component1()).intValue();
        int r32 = ((Number) r1.component2()).intValue();
        if (H8() == false) goto L110;
        z8();
        b r110 = getSingleLineFourButtonLayoutMetrics();
        com.larus.av_call.view.c r33 = this.a;
        if (r33 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        com.larus.av_call.view.c r111 = null;
    L88:
        LinearLayout r34 = r111.c();
        r14.i("VoiceCallBottomLayout", "changeToMinorModeVoiceCallUI, containerHorizontalPadding=" + r31 + ", itemHorizontalMargin=" + r32 + ", syncedContainerWidthPx=" + r110.a + ", syncedButtonSizePx=" + r110.b + ", syncedItemHorizontalMargin=" + r110.d);
        r34.setOrientation(0);
        r34.setGravity(17);
        ViewGroup.LayoutParams r35 = r34.getLayoutParams();
        if (r35 == null) goto L108;
        ConstraintLayout.LayoutParams r36 = (ConstraintLayout.LayoutParams) r35;
        ((ViewGroup.MarginLayoutParams) r36).width = r110.a;
        r34.setLayoutParams(r36);
        int r37 = r110.c;
        r34.setPadding(r37, r34.getPaddingTop(), r37, r34.getPaddingBottom());
        com.larus.utils.e1.o(r34.findViewById(2131392668));
        com.larus.utils.e1.o(r34.findViewById(2131392676));
        com.larus.utils.e1.o(r34.findViewById(2131392665));
        com.larus.utils.e1.o(r34.findViewById(2131392659));
        FrameLayout r38 = (FrameLayout) r34.findViewById(2131383811);
        Intrinsics.checkNotNull(r38);
        ViewGroup.LayoutParams r39 = r38.getLayoutParams();
        if (r39 == null) goto L106;
        LinearLayout.LayoutParams r40 = (LinearLayout.LayoutParams) r39;
        r40.setMarginStart(0);
        r40.setMarginEnd(r110.d);
        r38.setLayoutParams(r40);
        com.larus.utils.e1.x(r38);
        FrameLayout r41 = (FrameLayout) r34.findViewById(2131383816);
        Intrinsics.checkNotNull(r41);
        ViewGroup.LayoutParams r42 = r41.getLayoutParams();
        if (r42 == null) goto L104;
        LinearLayout.LayoutParams r43 = (LinearLayout.LayoutParams) r42;
        r43.setMarginStart(r110.d);
        r43.setMarginEnd(r110.d);
        r41.setLayoutParams(r43);
        com.larus.utils.e1.x(r41);
        FrameLayout r44 = (FrameLayout) r34.findViewById(2131392672);
        Intrinsics.checkNotNull(r44);
        ViewGroup.LayoutParams r45 = r44.getLayoutParams();
        if (r45 == null) goto L102;
        LinearLayout.LayoutParams r46 = (LinearLayout.LayoutParams) r45;
        r46.setMarginStart(r110.d);
        r46.setMarginEnd(r110.d);
        r44.setLayoutParams(r46);
        com.larus.utils.e1.x(r44);
        FrameLayout r47 = (FrameLayout) r34.findViewById(2131392662);
        Intrinsics.checkNotNull(r47);
        ViewGroup.LayoutParams r48 = r47.getLayoutParams();
        if (r48 == null) goto L100;
        LinearLayout.LayoutParams r49 = (LinearLayout.LayoutParams) r48;
        r49.setMarginStart(r110.d);
        r49.setMarginEnd(0);
        r47.setLayoutParams(r49);
        com.larus.utils.e1.x(r47);
        f9(r110.b);
        h9(r110.b);
        c6();
        return;
    L100:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L102:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L104:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L106:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L108:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L87:
        r111 = r33;
        goto L88
    L110:
        if (getShouldUseDoubleLineCallUI() == false) goto L120;
        z8();
        com.larus.av_call.view.c r50 = this.a;
        if (r50 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r50 = null;
    L114:
        LinearLayout r51 = r50.c();
        r14.i("VoiceCallBottomLayout", "changeToDoubleLineUI");
        r51.setOrientation(1);
        r51.setGravity(17);
        r51.setPadding(0, r51.getPaddingTop(), 0, r51.getPaddingBottom());
        int r52 = r51.getResources().getDimensionPixelSize(2131167682);
        int r53 = r51.getResources().getDimensionPixelSize(2131167683);
        int r54 = r51.getResources().getDimensionPixelSize(2131167684);
        int r55 = getDoubleLineBottomControlContainerBottomMargin();
        int r112 = RangesKt.coerceAtLeast(r53 - (r52 * 3), 0) / 2;
        ViewGroup.LayoutParams r113 = r51.getLayoutParams();
        if (r113 == null) goto L118;
        ConstraintLayout.LayoutParams r114 = (ConstraintLayout.LayoutParams) r113;
        ((ViewGroup.MarginLayoutParams) r114).bottomMargin = r55;
        r51.setLayoutParams(r114);
        View r56 = r51.findViewById(2131383811);
        View r57 = r51.findViewById(2131392676);
        View r59 = r51.findViewById(2131392672);
        View r115 = r51.findViewById(2131383816);
        View r116 = r51.findViewById(2131392662);
        View r117 = r51.findViewById(2131392665);
        com.larus.utils.e1.o(r51.findViewById(2131392668));
        com.larus.utils.e1.o(r51.findViewById(2131392659));
        LinearLayout r60 = new LinearLayout(getContext());
        r60.setOrientation(0);
        r60.setGravity(17);
        Intrinsics.checkNotNull(r56);
        b6(r60, r56, 0, r52, r112);
        Intrinsics.checkNotNull(r57);
        b6(r60, r57, 1, r52, r112);
        Intrinsics.checkNotNull(r59);
        b6(r60, r59, 2, r52, r112);
        LinearLayout r118 = new LinearLayout(getContext());
        r118.setOrientation(0);
        r118.setGravity(17);
        Intrinsics.checkNotNull(r115);
        b6(r118, r115, 0, r52, r112);
        Intrinsics.checkNotNull(r116);
        b6(r118, r116, 1, r52, r112);
        Intrinsics.checkNotNull(r117);
        b6(r118, r117, 2, r52, r112);
        r51.removeAllViews();
        LinearLayout.LayoutParams r61 = new LinearLayout.LayoutParams(r53, r52);
        r61.bottomMargin = r54;
        Unit r62 = Unit.INSTANCE;
        r51.addView(r60, r61);
        r51.addView(r118, new LinearLayout.LayoutParams(r53, r52));
        com.larus.utils.e1.x(r56);
        com.larus.utils.e1.x(r57);
        com.larus.utils.e1.x(r59);
        com.larus.utils.e1.x(r115);
        com.larus.utils.e1.x(r116);
        com.larus.utils.e1.x(r117);
        h9(r52);
        X9(G8(true));
        c6();
        return;
    L118:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L120:
        if (s6() != 4) goto L122;
        boolean r63 = true;
    L123:
        if (r63 == false) goto L125;
        b r64 = getSingleLineFourButtonLayoutMetrics();
    L126:
        if (r64 == null) goto L128;
        r31 = r64.c;
    L128:
        if (r64 == null) goto L130;
        r32 = r64.d;
    L130:
        if (r64 == null) goto L132;
        int r65 = r64.a;
    L133:
        if (r64 == null) goto L135;
        int r66 = r64.b;
    L136:
        com.larus.av_call.view.c r119 = this.a;
        if (r119 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        com.larus.av_call.view.c r120 = null;
    L140:
        LinearLayout r67 = r120.c();
        r14.i("VoiceCallBottomLayout", "changeToNewUI, containerHorizontalPadding=" + r31 + ", itemHorizontalMargin=" + r32 + ", containerWidthPx=" + r65 + ", buttonSizePx=" + r66);
        ViewGroup.LayoutParams r121 = r67.getLayoutParams();
        if (r121 == null) goto L216;
        ConstraintLayout.LayoutParams r122 = (ConstraintLayout.LayoutParams) r121;
        ((ViewGroup.MarginLayoutParams) r122).width = r65;
        r67.setLayoutParams(r122);
        r67.setPadding(r31, r67.getPaddingTop(), r31, r67.getPaddingBottom());
        r67.setGravity(17);
        FrameLayout r68 = (FrameLayout) r67.findViewById(2131383811);
        Intrinsics.checkNotNull(r68);
        ViewGroup.LayoutParams r69 = r68.getLayoutParams();
        if (r69 == null) goto L214;
        LinearLayout.LayoutParams r70 = (LinearLayout.LayoutParams) r69;
        r70.setMarginStart(0);
        r70.setMarginEnd(r32);
        r68.setLayoutParams(r70);
        com.larus.utils.e1.x(r68);
        FrameLayout r71 = (FrameLayout) r67.findViewById(2131392668);
        Intrinsics.checkNotNull(r71);
        ViewGroup.LayoutParams r72 = r71.getLayoutParams();
        if (r72 == null) goto L212;
        LinearLayout.LayoutParams r73 = (LinearLayout.LayoutParams) r72;
        r73.setMarginStart(r32);
        r73.setMarginEnd(r32);
        r71.setLayoutParams(r73);
        if (getShouldUseDoubleLineCallUI() == false) goto L154;
        h88.b r74 = this.f;
        if (r74 != null) goto L151;
    L156:
        boolean r75 = false;
    L157:
        IRealtimeCallConfigDependency r76 = this.e;
        if (r76 != null) goto L160;
    L162:
        boolean r77 = false;
    L163:
        if (r77 == false) goto L166;
        if (r75 == false) goto L166;
        com.larus.utils.e1.x(r71);
    L167:
        FrameLayout r79 = (FrameLayout) r67.findViewById(2131392676);
        Intrinsics.checkNotNull(r79);
        ViewGroup.LayoutParams r80 = r79.getLayoutParams();
        if (r80 == null) goto L210;
        LinearLayout.LayoutParams r81 = (LinearLayout.LayoutParams) r80;
        r81.setMarginStart(r32);
        r81.setMarginEnd(r32);
        r79.setLayoutParams(r81);
        IRealtimeCallConfigDependency r82 = this.e;
        if (r82 != null) goto L172;
    L174:
        boolean r83 = false;
    L175:
        if (r83 == false) goto L177;
        com.larus.utils.e1.x(r79);
    L178:
        com.larus.utils.e1.o(r67.findViewById(2131392672));
        com.larus.utils.e1.o(r67.findViewById(2131383816));
        FrameLayout r84 = (FrameLayout) r67.findViewById(2131392665);
        Intrinsics.checkNotNull(r84);
        ViewGroup.LayoutParams r85 = r84.getLayoutParams();
        if (r85 == null) goto L208;
        LinearLayout.LayoutParams r86 = (LinearLayout.LayoutParams) r85;
        r86.setMarginStart(r32);
        r86.setMarginEnd(r32);
        r84.setLayoutParams(r86);
        if (getShouldUseDoubleLineCallUI() == false) goto L193;
        h88.b r87 = this.f;
        if (r87 == null) goto L188;
        if (r87.t != true) goto L188;
        boolean r88 = true;
    L189:
        if (r88 == false) goto L193;
        boolean r123 = false;
    L195:
        if (getNeedBottomMoreBtn() == false) goto L198;
        if (r123 == false) goto L198;
        com.larus.utils.e1.x(r84);
    L199:
        FrameLayout r89 = (FrameLayout) r67.findViewById(2131392662);
        Intrinsics.checkNotNull(r89);
        ViewGroup.LayoutParams r90 = r89.getLayoutParams();
        if (r90 == null) goto L206;
        LinearLayout.LayoutParams r91 = (LinearLayout.LayoutParams) r90;
        r91.setMarginStart(r32);
        r91.setMarginEnd(0);
        r89.setLayoutParams(r91);
        com.larus.utils.e1.x(r89);
        com.larus.utils.e1.o(r67.findViewById(2131392659));
        if (getShouldUseDoubleLineCallUI() == false) goto L204;
        h9(j19.c.c(66));
        c6();
        return;
    L204:
        f9(r66);
        h9(r66);
        return;
    L206:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L198:
        com.larus.utils.e1.o(r84);
    L188:
        r88 = false;
    L193:
        r123 = true;
        goto L195
    L208:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L177:
        com.larus.utils.e1.o(r79);
        goto L178
    L172:
        if (r82.e() != true) goto L174;
        r83 = true;
        goto L175
    L210:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L166:
        com.larus.utils.e1.o(r71);
        goto L167
    L160:
        if (r76.g() != true) goto L162;
        r77 = true;
        goto L163
    L151:
        if (r74.t != true) goto L156;
    L155:
        r75 = true;
        goto L157
    L154:
        if (getNeedBottomMoreBtn() == true) goto L156;
    L212:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L214:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L216:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L139:
        r120 = r119;
        goto L140
    L135:
        r66 = j19.c.c(76);
        goto L136
    L132:
        r65 = -1;
        goto L133
    L125:
        r64 = null;
        goto L126
    L122:
        r63 = false;
        goto L123
    L79:
        if (getShouldUseDoubleLineCallUI() == false) goto L81;
        r30 = 6;
        goto L82
    L81:
        r30 = s6();
        goto L82
    L217:
        r14.i("VoiceCallBottomLayout", "setupButtons use old ui, reason=" + getLayoutFallbackReason());
        this.p = false;
        if (f7() == false) goto L220;
        int r92 = 3;
    L221:
        Pair<Integer, Integer> r93 = o6(r19, r92);
        int r94 = ((Number) r93.component1()).intValue();
        int r95 = ((Number) r93.component2()).intValue();
        z8();
        com.larus.av_call.view.c r96 = this.a;
        if (r96 != null) goto L224;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r96 = null;
    L224:
        LinearLayout r97 = r96.c();
        r97.setPadding(r94, r97.getPaddingTop(), r94, r97.getPaddingBottom());
        r97.setGravity(17);
        FrameLayout r98 = (FrameLayout) r97.findViewById(2131383811);
        Intrinsics.checkNotNull(r98);
        ViewGroup.LayoutParams r99 = r98.getLayoutParams();
        if (r99 == null) goto L244;
        LinearLayout.LayoutParams r100 = (LinearLayout.LayoutParams) r99;
        r100.setMarginStart(0);
        r100.setMarginEnd(r95);
        r98.setLayoutParams(r100);
        com.larus.utils.e1.x(r98);
        com.larus.utils.e1.o(r97.findViewById(2131392668));
        com.larus.utils.e1.o(r97.findViewById(2131392676));
        com.larus.utils.e1.o(r97.findViewById(2131392672));
        com.larus.utils.e1.o(r97.findViewById(2131383816));
        FrameLayout r101 = (FrameLayout) r97.findViewById(2131392662);
        Intrinsics.checkNotNull(r101);
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L242;
        LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) r102;
        r103.setMarginStart(r95);
        if (f7() == false) goto L231;
        int r104 = r95;
    L232:
        r103.setMarginEnd(r104);
        r101.setLayoutParams(r103);
        com.larus.utils.e1.x(r101);
        FrameLayout r105 = (FrameLayout) r97.findViewById(2131392659);
        Intrinsics.checkNotNull(r105);
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L240;
        LinearLayout.LayoutParams r107 = (LinearLayout.LayoutParams) r106;
        r107.setMarginStart(r95);
        r107.setMarginEnd(0);
        r105.setLayoutParams(r107);
        if (f7() == false) goto L237;
        com.larus.utils.e1.x(r105);
    L238:
        h9(j19.c.c(76));
        return;
    L237:
        com.larus.utils.e1.o(r105);
        goto L238
    L240:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L231:
        r104 = 0;
        goto L232
    L242:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L244:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L220:
        r92 = 2;
        goto L221
    L72:
        r29 = null;
        goto L73
    L68:
        r26 = null;
        goto L69
    L64:
        r24 = null;
        goto L65
    L60:
        r22 = null;
        goto L61
    L56:
        r20 = null;
        goto L57
    L52:
        r16 = null;
        goto L53
    L48:
        r12 = null;
        goto L49
    L44:
        r9 = null;
        goto L45
    L40:
        r7 = null;
        goto L41
    L36:
        r5 = null;
        goto L37
    L30:
        if (getShouldUseDoubleLineCallUI() == false) goto L32;
        r3 = 6;
        goto L33
    L32:
        r3 = s6();
        goto L33
    L8:
        if (this.r == true) goto L26;
    L25:
        r11 = false;
        goto L27
    L10:
        IRealtimeCallConfigDependency r124 = this.e;
        if (r124 != null) goto L13;
    L15:
        boolean r125 = false;
    L16:
        if (r125 == true) goto L26;
        IRealtimeCallConfigDependency r126 = this.e;
        if (r126 != null) goto L20;
    L22:
        boolean r127 = false;
    L23:
        if (r127 == false) goto L25;
    L20:
        if (r126.e() != true) goto L22;
        r127 = true;
        goto L23
    L13:
        if (r124.g() != true) goto L15;
        r125 = true;
        goto L16
    L245:
        FLogger r108 = FLogger.a;
        StringBuilder r109 = new StringBuilder("setupButtons skip double line, enableV2Binding=false, screenWidthType=");
        r109.append(r19);
        r109.append(", shouldUseDoubleLineCallUI=");
        r109.append(getShouldUseDoubleLineCallUI());
        r109.append(", isVideoEnable=");
        IRealtimeCallConfigDependency r128 = this.e;
        if (r128 == null) goto L248;
        Boolean r129 = Boolean.valueOf(r128.e());
    L249:
        r109.append(r129);
        r109.append(", isScreenShareEnable=");
        IRealtimeCallConfigDependency r130 = this.e;
        if (r130 == null) goto L252;
        Boolean r131 = Boolean.valueOf(r130.g());
    L253:
        r109.append(r131);
        r109.append(", isTakePhotoEnable=");
        IRealtimeCallConfigDependency r132 = this.e;
        if (r132 == null) goto L256;
        Boolean r133 = Boolean.valueOf(r132.h());
    L257:
        r109.append(r133);
        r109.append(", simpleMode=");
        h88.a r134 = this.g;
        if (r134 == null) goto L260;
        Boolean r135 = Boolean.valueOf(r134.T);
    L261:
        r109.append(r135);
        r109.append(", openVLMOnStart=");
        h88.a r136 = this.g;
        if (r136 == null) goto L264;
        Boolean r137 = Boolean.valueOf(r136.m);
    L265:
        r109.append(r137);
        r108.i("VoiceCallBottomLayout", r109.toString());
        return;
    L264:
        r137 = null;
        goto L265
    L260:
        r135 = null;
        goto L261
    L256:
        r133 = null;
        goto L257
    L252:
        r131 = null;
        goto L253
    L248:
        r129 = null;
        goto L249
    }

    public final boolean C6(View r5) {
        h88.b r0 = this.f;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L12;
        t19.s.a.g(r5.getContext(), 2131900504, false);
        return false;
    L12:
        if (TextUtils.isEmpty(this.x) == true) goto L23;
        h88.a r2 = this.g;
        if (r2 != null) goto L16;
    L18:
        boolean r3 = false;
    L19:
        if (r3 == true) goto L23;
        t19.s.a.g(r5.getContext(), 2131900503, false);
        return false;
    L16:
        if (r2.k0 != true) goto L18;
        r3 = true;
    L23:
        if (this.c != 6) goto L26;
        t19.s.a.g(r5.getContext(), 2131900505, false);
        return false;
    L26:
        return true;
    L5:
        if (r0.d != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void D9(com.larus.av_call.view.c r4) {
        Function3<? super ImageView, ? super ThemeType, ? super Boolean, Unit> r0 = this.A;
        if (r0 == null) goto L6;
        r0.invoke(r4.q(), this.i, Boolean.valueOf(this.m));
        return;
    }

    public final void E9(boolean r4) {
        boolean r0 = true;
        this.y = !r4;
        if (this.o == true) goto L5;
    L31:
        E8();
        return;
    L5:
        if (getShouldUseDoubleLineCallUI() == false) goto L31;
        com.larus.av_call.view.c r1 = null;
        if (this.y == false) goto L13;
        com.larus.av_call.view.c r5 = this.a;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L12:
        com.larus.utils.e1.o(r1.j());
        goto L31
    L11:
        r1 = r5;
        goto L12
    L13:
        com.larus.av_call.view.c r6 = this.a;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r6 = null;
    L17:
        if (r6.i().getVisibility() == 0) goto L20;
        r0 = false;
    L20:
        if (r0 == false) goto L26;
        com.larus.av_call.view.c r7 = this.a;
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L25:
        com.larus.utils.e1.q(r1.j());
        goto L31
    L24:
        r1 = r7;
        goto L25
    L26:
        com.larus.av_call.view.c r8 = this.a;
        if (r8 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L30:
        com.larus.utils.e1.x(r1.j());
        goto L31
    L29:
        r1 = r8;
        goto L30
    }

    public final boolean G8(boolean r4) {
        if (this.y == true) goto L27;
        if (r4 == false) goto L28;
        h88.b r5 = this.f;
        if (r5 != null) goto L8;
    L10:
        boolean r6 = false;
    L11:
        if (r6 == true) goto L13;
        return false;
    L13:
        if (TextUtils.isEmpty(this.x) == true) goto L21;
        h88.a r7 = this.g;
        if (r7 != null) goto L17;
    L19:
        boolean r8 = false;
    L20:
        if (r8 == true) goto L21;
        return false;
    L17:
        if (r7.k0 != true) goto L19;
        r8 = true;
    L21:
        int r9 = this.c;
        if (r9 != 6) goto L24;
        return false;
    L24:
        if (r9 == 7) goto L32;
        return true;
    L32:
        return false;
    L8:
        if (r5.d != true) goto L10;
        r6 = true;
        goto L11
    L28:
        return false;
    L27:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H6(boolean r3) {
        final boolean r4 = G8(r3);
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == true) goto L5;
        post(new i0(this, r4));
        return;
    L5:
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L8:
        com.larus.av_call.view.b r1 = r0.f();
        if (r1 == null) goto L13;
        h88.d r2 = r1.c;
        if (r2 == null) goto L13;
        r2.a(r4);
    L13:
        X9(r4);
        M9(r4);
    }

    public final void I9(com.larus.av_call.view.c r4) {
        Function3<? super View, ? super ThemeType, ? super Boolean, Unit> r0 = this.B;
        if (r0 == null) goto L6;
        r0.invoke(r4.k(), this.i, Boolean.valueOf(this.m));
        return;
    }

    public final void J7(boolean r5) {
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        UrlSpanTextView r1 = r0.n();
        FLogger.a.i("VoiceCallBottomLayout", "resetModifyListeningText remove modifyListeningRunnable isForceResetText=" + r5 + " text=" + r1.getText() + " currentState=" + this.c + " needShowBadNetNotice=" + getNeedShowBadNetNotice());
        r1.removeCallbacks(this.C);
        if (r5 == true) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r1.getText(), r1.getContext().getString(2131908700)) == true) goto L10;
        return;
    L10:
        if (this.c == 3) goto L12;
        return;
    L12:
        if (getNeedShowBadNetNotice() == true) goto L18;
        r1.setText(r1.getContext().getString(2131898446));
        return;
    }

    public final void K9(String r1) {
        setCurrentSceneKey(r1);
    }

    public final void M9(boolean r2) {
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        View r1 = r0.h();
        if (r1 == null) goto L13;
        r1.setEnabled(r2);
        if (r2 == false) goto L10;
        float r3 = 1.0f;
    L11:
        r1.setAlpha(r3);
        return;
    L10:
        r3 = 0.4f;
        goto L11
    }

    public final View N6(int r4) {
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        View r1 = r0.c().findViewById(r4);
        if (r1 == null) goto L9;
        return r1;
    L9:
        if (r4 != 2131392668) goto L21;
        com.larus.av_call.view.c r5 = this.a;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r5 = null;
    L13:
        View r6 = r5.h();
        if (r6 == null) goto L16;
        ViewParent r7 = r6.getParent();
    L18:
        if ((r7 instanceof View) == true) goto L36;
        return null;
    L36:
        return (View) r7;
    L16:
        r7 = null;
        goto L18
    L21:
        if (r4 != 2131392659) goto L37;
        com.larus.av_call.view.c r8 = this.a;
        if (r8 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r8 = null;
    L25:
        com.larus.av_call.view.b r9 = r8.f();
        if (r9 == null) goto L30;
        View r10 = r9.a;
        if (r10 == null) goto L30;
        ViewParent r11 = r10.getParent();
    L32:
        if ((r11 instanceof View) == true) goto L34;
        return null;
    L34:
        return (View) r11;
    L30:
        r11 = null;
        goto L32
    L37:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N8(boolean r8) {
        int r0 = this.c;
        if (r0 != 6) goto L5;
    L28:
        FLogger.a.i("VoiceCallBottomLayout", "showBadNetNotice exec, currentState = " + this.c);
        return;
    L5:
        if (r0 == 7) goto L28;
        final com.larus.av_call.view.c r1 = null;
        if (getNeedShowBadNetNotice() == false) goto L17;
        if (r8 == false) goto L17;
        FLogger.a.i("VoiceCallBottomLayout", "showBadNetNotice exec");
        com.larus.av_call.view.c r9 = this.a;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L15:
        r1.n().post(new d0(r1, this));
        return;
    L14:
        r1 = r9;
    L17:
        com.larus.av_call.view.c r2 = this.a;
        if (r2 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r2 = null;
    L20:
        boolean r3 = Intrinsics.areEqual(r2.n().getText(), getContext().getString(2131900059));
        FLogger.a.e("VoiceCallBottomLayout", "showBadNetNotice failed! needShowBadNetNotice=" + getNeedShowBadNetNotice() + " isVisible=" + r8 + " isTextMatch=" + r3);
        if (r3 == false) goto L30;
        com.larus.av_call.view.c r10 = this.a;
        if (r10 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L26:
        r1.n().setText("");
        l8();
        return;
    L25:
        r1 = r10;
        goto L26
    }

    public final void N9(TextView r4) {
        Function3<? super TextView, ? super ThemeType, ? super Boolean, Unit> r0 = this.z;
        if (r0 == null) goto L6;
        r0.invoke(r4, this.i, Boolean.valueOf(this.m));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S9(boolean r3) {
        this.t = r3;
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        AppCompatImageView r1 = r0.r();
        if (r1 == null) goto L12;
        Context r2 = getContext();
        if (r3 == false) goto L10;
        int r4 = 2131900491;
    L11:
        r1.setContentDescription(r2.getString(r4));
        goto L12
    L10:
        r4 = 2131900495;
    L12:
        IRealtimeCallConfigDependency r5 = this.e;
        boolean r6 = false;
        if (r5 != null) goto L15;
    L17:
        V9(r6);
        return;
    L15:
        if (r5.s() != true) goto L17;
        r6 = true;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V9(boolean r9) {
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        AppCompatImageView r2 = r0.r();
        if (r2 == null) goto L44;
        r2.setEnabled(this.s);
        if (this.s == false) goto L10;
        float r1 = 1.0f;
    L11:
        r2.setAlpha(r1);
        if (this.p == false) goto L34;
        r2.setImageTintList(null);
        r2.setImageDrawable(null);
        if (r7() == false) goto L21;
        if (this.t == false) goto L18;
        int r10 = 2131240727;
    L19:
        r2.setBackgroundResource(r10);
        return;
    L18:
        r10 = 2131240726;
        goto L19
    L21:
        if (this.m == true) goto L30;
        Application r11 = i88.e.a;
        if (i88.e.o(this.i) == true) goto L30;
        if (this.t == false) goto L28;
        int r12 = 2131240716;
    L33:
        r2.setBackgroundResource(r12);
        return;
    L28:
        r12 = 2131240718;
    L30:
        if (this.t == false) goto L32;
        r12 = 2131240717;
        goto L33
    L32:
        r12 = 2131240719;
        goto L33
    L34:
        int r3 = getDoubleLineSubtitleButtonColor();
        GradientDrawable r4 = new GradientDrawable();
        r4.setShape(1);
        r4.setColor(ContextCompat.getColor(getContext(), r3));
        r2.setBackground(r4);
        r2.setImageTintList(null);
        Application r5 = i88.e.a;
        ThemeType r6 = this.i;
        boolean r7 = this.t;
        boolean r8 = this.m;
        h88.b r13 = this.f;
        if (r13 == null) goto L37;
        boolean r14 = r13.q;
    L37:
        if (r13 != null) goto L39;
    L41:
        boolean r15 = false;
    L42:
        i88.e.j(r2, r6, r7, r8, r9, r15);
        return;
    L39:
        if (r13.r != true) goto L41;
        r15 = true;
        goto L42
    L10:
        r1 = 0.4f;
        goto L11
    }

    public final void X9(boolean r4) {
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        View r1 = r0.b();
        if (r1 == null) goto L25;
        boolean r2 = false;
        if (r4 == true) goto L10;
    L19:
        r1.setEnabled(r2);
        if (r2 == false) goto L22;
        float r5 = 1.0f;
    L23:
        r1.setAlpha(r5);
        return;
    L22:
        r5 = 0.4f;
        goto L23
    L10:
        if (getShouldUseDoubleLineCallUI() == false) goto L18;
        IRealtimeCallConfigDependency r6 = this.e;
        if (r6 != null) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r7 == false) goto L19;
    L14:
        if (r6.e() != true) goto L16;
        r7 = true;
    L18:
        r2 = true;
        goto L19
    }

    public final void Z8(String r3) {
        Intrinsics.checkNotNullParameter(r3, "showFrom");
        this.n = r3;
        com.larus.av_call.view.c r4 = this.a;
        com.larus.av_call.view.c r0 = null;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r4 = null;
    L5:
        com.larus.utils.e1.x(r4.i());
        if (this.o == true) goto L8;
    L19:
        com.larus.av_call.view.c r5 = this.a;
        if (r5 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L23:
        o<String> r6 = r0.i().getDelegate();
        if (r6.d != null) goto L27;
        r6.d = new Handler(Looper.getMainLooper());
    L27:
        r6.a();
        return;
    L22:
        r0 = r5;
        goto L23
    L8:
        if (getShouldUseDoubleLineCallUI() == true) goto L10;
    L15:
        com.larus.av_call.view.c r7 = this.a;
        if (r7 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r7 = null;
    L18:
        com.larus.utils.e1.q(r7.j());
        goto L19
    L10:
        if (this.y == false) goto L15;
        com.larus.av_call.view.c r8 = this.a;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r8 = null;
    L14:
        com.larus.utils.e1.o(r8.j());
        goto L19
    }

    public final void b8(TextView r9) {
        if (getShouldUseDoubleLineCallUI() == true) goto L5;
        return;
    L5:
        h88.b r0 = this.f;
        if (r0 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        int r3 = this.c;
        if (r3 == 1) goto L43;
        Integer r2 = null;
        if (r3 != 2) goto L16;
        if (r1 == true) goto L42;
        r2 = 2131240715;
    L42:
        i6(r9, r2, StatusIconAnimType.NONE);
        return;
    L16:
        if (r3 != 3) goto L18;
    L35:
        if (r1 == false) goto L37;
        StatusIconAnimType r4 = StatusIconAnimType.NONE;
    L38:
        i6(r9, null, r4);
        return;
    L37:
        r4 = StatusIconAnimType.WAVE;
        goto L38
    L18:
        if (r3 == 4) goto L33;
        if (r3 == 5) goto L33;
        if (r3 != 7) goto L24;
        k6(this, r9, 2131240715, 2);
        return;
    L24:
        if (r3 == 9) goto L33;
        if (r3 == 17) goto L35;
        if (r3 != 18) goto L51;
        k6(this, r9, null, 3);
        return;
    L51:
        return;
    L33:
        if (StringsKt.equals$default(this.x, "interpret_v2", false, 2, null) == true) goto L47;
        k6(this, r9, 2131240714, 2);
        return;
    L47:
        return;
    L43:
        i6(r9, 2131240713, StatusIconAnimType.ROTATE);
        return;
    L8:
        if (r0.m != true) goto L10;
        r1 = true;
        goto L11
    }

    public final void c9(boolean r4) {
        com.larus.av_call.view.c r0 = this.a;
        com.larus.av_call.view.c r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        r0.p().c(r4);
        if (getShouldUseDoubleLineCallUI() == false) goto L15;
        com.larus.av_call.view.c r2 = this.a;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L11:
        com.larus.common_ui.view.u r3 = W6(r1);
        if (r3 == null) goto L16;
        r3.c(r4);
        return;
    L16:
        return;
    L10:
        r1 = r2;
        goto L11
    }

    public final void f9(int r4) {
        Iterator r0 = CollectionsKt.listOf(new Integer[]{2131383811, 2131392668, 2131383816, 2131392676, 2131392672, 2131392665, 2131392662, 2131392659}).iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        View r1 = N6(((Number) r0.next()).intValue());
        if (r1 == null) goto L4;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L11;
        r2.width = r4;
        r2.height = r4;
        r1.setLayoutParams(r2);
        goto L4
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void h9(int r7) {
        com.larus.av_call.view.c r0 = this.a;
        com.larus.av_call.view.c r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        View r2 = r0.k();
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L68;
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) r3;
        r4.width = r7;
        r4.height = r7;
        r4.gravity = 17;
        r2.setLayoutParams(r4);
        com.larus.av_call.view.c r5 = this.a;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r5 = null;
    L10:
        View r6 = r5.h();
        if (r6 == null) goto L17;
        ViewGroup.LayoutParams r8 = r6.getLayoutParams();
        if (r8 == null) goto L16;
        FrameLayout.LayoutParams r9 = (FrameLayout.LayoutParams) r8;
        r9.width = r7;
        r9.height = r7;
        r9.gravity = 17;
        r6.setLayoutParams(r9);
        goto L17
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L17:
        com.larus.av_call.view.c r10 = this.a;
        if (r10 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r10 = null;
    L20:
        View r11 = r10.b();
        if (r11 == null) goto L27;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L26;
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r12;
        r13.width = r7;
        r13.height = r7;
        r13.gravity = 17;
        r11.setLayoutParams(r13);
        goto L27
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L27:
        com.larus.av_call.view.c r14 = this.a;
        if (r14 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r14 = null;
    L30:
        AppCompatImageView r15 = r14.r();
        if (r15 == null) goto L37;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L36;
        FrameLayout.LayoutParams r17 = (FrameLayout.LayoutParams) r16;
        r17.width = r7;
        r17.height = r7;
        r17.gravity = 17;
        r15.setLayoutParams(r17);
        goto L37
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L37:
        com.larus.av_call.view.c r19 = this.a;
        if (r19 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r19 = null;
    L40:
        View r20 = r19.e();
        if (r20 == null) goto L47;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        if (r21 == null) goto L46;
        FrameLayout.LayoutParams r22 = (FrameLayout.LayoutParams) r21;
        r22.width = r7;
        r22.height = r7;
        r22.gravity = 17;
        r20.setLayoutParams(r22);
        goto L47
    L46:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L47:
        com.larus.av_call.view.c r23 = this.a;
        if (r23 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r23 = null;
    L50:
        RealtimeBottomMoreBtn r24 = r23.a();
        if (r24 == null) goto L57;
        ViewGroup.LayoutParams r25 = r24.getLayoutParams();
        if (r25 == null) goto L56;
        FrameLayout.LayoutParams r26 = (FrameLayout.LayoutParams) r25;
        r26.width = r7;
        r26.height = r7;
        r26.gravity = 17;
        r24.setLayoutParams(r26);
        goto L57
    L56:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L57:
        com.larus.av_call.view.c r27 = this.a;
        if (r27 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L61:
        View r29 = r1.m();
        ViewGroup.LayoutParams r30 = r29.getLayoutParams();
        if (r30 == null) goto L66;
        FrameLayout.LayoutParams r31 = (FrameLayout.LayoutParams) r30;
        r31.width = r7;
        r31.height = r7;
        r31.gravity = 17;
        r29.setLayoutParams(r31);
        return;
    L66:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L60:
        r1 = r27;
        goto L61
    L68:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public final void p9(boolean r3) {
        this.v = r3;
        com.larus.av_call.view.c r0 = null;
        if (r3 == false) goto L9;
        com.larus.av_call.view.c r4 = this.a;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L8:
        com.larus.utils.e1.x(r0.o());
        return;
    L7:
        r0 = r4;
        goto L8
    L9:
        com.larus.av_call.view.c r5 = this.a;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L13:
        com.larus.utils.e1.o(r0.o());
        return;
    L12:
        r0 = r5;
        goto L13
    }

    public final void setInSceneMode(Function0<Boolean> r1) {
        this.k = r1;
    }

    public final void setLLMVideoBtnClickListener(final Function1<? super Boolean, Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "onClick");
        com.larus.av_call.view.c r0 = this.a;
        com.larus.av_call.view.c r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        com.larus.av_call.view.b r2 = r0.f();
        if (r2 == null) goto L8;
        Function3<View, Boolean, Boolean, Unit> r4 = new w0(this, r7);
        Intrinsics.checkNotNullParameter(h88.e.class, "clazz");
        Intrinsics.checkNotNullParameter(r4, "action");
        r2.e.put(h88.e.class, r4);
    L8:
        com.larus.av_call.view.c r3 = this.a;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L12:
        View r5 = r1.b();
        if (r5 == null) goto L16;
        com.larus.utils.e1.d(r5, new x0(this, r7));
        return;
    L16:
        return;
    L11:
        r1 = r3;
        goto L12
    }

    public final void setMinorModeEnabled(boolean r1) {
        this.q = r1;
    }

    public final void setNeedRefreshMoreBtn(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    public final void setNeedShowBadNetNoticeBlock(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.w = r2;
    }

    public final void setRecordData(byte[] r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        com.larus.av_call.view.c r0 = this.a;
        com.larus.av_call.view.c r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        r0.p().setAudioData(r4);
        if (getShouldUseDoubleLineCallUI() == false) goto L15;
        com.larus.av_call.view.c r2 = this.a;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L11:
        com.larus.common_ui.view.u r3 = W6(r1);
        if (r3 == null) goto L16;
        r3.setAudioData(r4);
        return;
    L16:
        return;
    L10:
        r1 = r2;
        goto L11
    }

    public final void setSubtitleBtnClickListener(final Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "onClick");
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        AppCompatImageView r1 = r0.r();
        if (r1 == null) goto L9;
        com.larus.utils.e1.d(r1, new s(this, r3));
        return;
    }

    public final void setSubtitleButtonClickEnabled(boolean r3) {
        this.s = r3;
        IRealtimeCallConfigDependency r4 = this.e;
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        V9(r0);
        return;
    L5:
        if (r4.s() != true) goto L7;
        r0 = true;
        goto L7
    }

    public final void setSubtitleButtonEnabled(boolean r1) {
        this.r = r1;
    }

    public final void setTakePhotoBtnClickListener(final Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onClick");
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        com.larus.av_call.view.b r1 = r0.f();
        if (r1 == null) goto L9;
        Function3<View, Boolean, Boolean, Unit> r2 = new k0(this, r4);
        Intrinsics.checkNotNullParameter(h88.f.class, "clazz");
        Intrinsics.checkNotNullParameter(r2, "action");
        r1.e.put(h88.f.class, r2);
        return;
    }

    public final void setTracerProvider(Function0<? extends IRealtimeCallTracer> r1) {
        this.j = r1;
    }

    public final void setVideoCallSelected(boolean r7) {
        boolean r0 = false;
        com.larus.av_call.view.c r1 = null;
        if (r7 == false) goto L10;
        com.larus.av_call.view.c r4 = this.a;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r4 = null;
    L7:
        com.larus.av_call.view.b r5 = r4.f();
        if (r5 == null) goto L37;
        r5.a(new h88.e());
    L37:
        com.larus.av_call.view.c r6 = this.a;
        if (r6 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r6 = null;
    L40:
        com.larus.av_call.view.b r8 = r6.f();
        if (r8 == null) goto L45;
        h88.d r9 = r8.c;
        if (r9 == null) goto L45;
        r9.b(r7);
    L45:
        com.larus.av_call.view.c r10 = this.a;
        if (r10 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L49:
        View r2 = r1.b();
        if (r2 == null) goto L65;
        r2.setSelected(r7);
        if (r7 == false) goto L59;
        Application r11 = i88.e.a;
        ThemeType r12 = this.i;
        boolean r3 = this.m;
        h88.b r13 = this.f;
        if (r13 != null) goto L56;
    L58:
        i88.e.l(r2, r12, r3, r0, this.g);
        goto L65
    L56:
        if (r13.r != true) goto L58;
        r0 = true;
        goto L58
    L59:
        Application r14 = i88.e.a;
        ThemeType r15 = this.i;
        boolean r16 = this.m;
        h88.b r17 = this.f;
        if (r17 != null) goto L62;
    L64:
        i88.e.m(r2, r15, r16, r0, this.g);
        goto L65
    L62:
        if (r17.r != true) goto L64;
        r0 = true;
    L65:
        c6();
        return;
    L48:
        r1 = r10;
        goto L49
    L10:
        h88.b r19 = this.f;
        if (r19 != null) goto L13;
    L15:
        boolean r20 = false;
    L16:
        IRealtimeCallConfigDependency r21 = this.e;
        if (r21 != null) goto L19;
    L21:
        boolean r22 = false;
    L22:
        if (r22 == false) goto L37;
        IRealtimeCallConfigDependency r23 = this.e;
        if (r23 != null) goto L26;
    L28:
        boolean r24 = false;
    L29:
        if (r24 == true) goto L37;
        com.larus.av_call.view.c r25 = this.a;
        if (r25 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r25 = null;
    L33:
        com.larus.av_call.view.b r26 = r25.f();
        if (r26 == null) goto L36;
        r26.a(new h88.f());
    L36:
        H6(true);
        goto L37
    L26:
        if (r23.e() != true) goto L28;
        r24 = true;
        goto L29
    L19:
        if (r21.l(r20) != true) goto L21;
        r22 = true;
        goto L22
    L13:
        if (r19.d != true) goto L15;
        r20 = true;
        goto L16
    }

    public final void u9(boolean r2) {
        if (this.p == true) goto L5;
        return;
    L5:
        com.larus.av_call.view.c r0 = this.a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L8:
        RealtimeBottomMoreBtn r1 = r0.a();
        if (r1 == null) goto L14;
        if (r2 == false) goto L12;
        r1.setBackgroundResource(2131242333);
        r1.setIconVisible(false);
        return;
    L12:
        r1.setIconVisible(true);
        y9();
        return;
    }

    public final void w7(String r4) {
        Intrinsics.checkNotNullParameter(r4, "caller");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[player_mute_debug] caller=");
        r1.append(r4);
        r1.append(", isSilentPlay=");
        h88.b r5 = this.f;
        Boolean r2 = null;
        if (r5 == null) goto L5;
        Boolean r6 = Boolean.valueOf(r5.v);
    L6:
        r1.append(r6);
        r1.append(", isFullVideo=");
        h88.b r7 = this.f;
        if (r7 == null) goto L9;
        Boolean r8 = Boolean.valueOf(r7.r);
    L10:
        r1.append(r8);
        r1.append(", isPipVideo=");
        h88.b r9 = this.f;
        if (r9 == null) goto L13;
        r2 = Boolean.valueOf(r9.s);
    L13:
        r1.append(r2);
        r1.append(", forceDarkMode=");
        r1.append(this.m);
        r1.append(", isDoubleLineVideoStyle=");
        r1.append(r7());
        r1.append(", shouldUseDoubleLineCallUI=");
        r1.append(getShouldUseDoubleLineCallUI());
        r1.append(", isUsingDoubleLineCallUI=");
        r1.append(this.p);
        r1.append(", enableV2Binding=");
        r1.append(this.o);
        r1.append(", expectedResource=");
        r1.append(V6(getDoubleLinePlayMuteButtonResource()));
        r0.i("VoiceCallBottomLayout", r1.toString());
        return;
    L9:
        r8 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    public static void R5(VoiceCallBottomLayout r5, Context r6) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("exe， current time: ");
        r1.append(AppHost.a.getAppClock().currentTimeMillis());
        r1.append(" text=");
        com.larus.av_call.view.c r2 = r5.a;
        com.larus.av_call.view.c r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r2 = null;
    L5:
        r1.append(r2.n().getText());
        r1.append(" currentState=");
        r1.append(r5.c);
        r0.d("VoiceCallBottomLayout", r1.toString());
        com.larus.av_call.view.c r4 = r5.a;
        if (r4 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r4 = null;
    L9:
        if (Intrinsics.areEqual(r4.n().getText(), r6.getString(2131898446)) == true) goto L11;
        return;
    L11:
        if (r5.c == 3) goto L13;
        return;
    L13:
        if (r5.getNeedShowBadNetNotice() == true) goto L22;
        com.larus.av_call.view.c r7 = r5.a;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L18:
        r3.n().setText(r6.getString(2131908700));
        return;
    L17:
        r3 = r7;
        goto L18
    }

    public static Unit U5(VoiceCallBottomLayout r2, TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$updateStyle");
        r2.N9(r3);
        if (r2.getShouldUseDoubleLineCallUI() == false) goto L17;
        if (r2.c != 3) goto L17;
        h88.b r0 = r2.f;
        if (r0 == null) goto L11;
        boolean r1 = true;
        if (r0.m != true) goto L11;
    L12:
        if (r1 == false) goto L14;
        StatusIconAnimType r4 = StatusIconAnimType.NONE;
    L15:
        r2.i6(r3, null, r4);
        goto L17
    L14:
        r4 = StatusIconAnimType.WAVE;
    L11:
        r1 = false;
    L17:
        return Unit.INSTANCE;
    }

    public static void Y5(com.larus.av_call.view.c r4, VoiceCallBottomLayout r5) {
        UrlSpanTextView r0 = r4.n();
        r5.z = null;
        r0.setTextColor(ContextCompat.getColor(r0.getContext(), 2131102650));
        if (r5.getShouldUseDoubleLineCallUI() == false) goto L5;
        r0.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        r0.setCompoundDrawablePadding(0);
        r5.B9(null, StatusIconAnimType.NONE);
    L5:
        r0.setText(r0.getContext().getString(2131900059));
        r0.setAlpha(1.0f);
        r0.setVisibility(0);
        r4.g().setVisibility(8);
        r4.p().a(8);
        r4.q().setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B9(Integer r9, StatusIconAnimType r10) {
        com.larus.av_call.view.c r0 = this.a;
        com.larus.av_call.view.c r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        AppCompatImageView r1 = r0.d();
        if (r1 != null) goto L8;
        return;
    L8:
        ViewParent r3 = r1.getParent();
        if ((r3 instanceof ViewGroup) == false) goto L11;
        ViewGroup r4 = (ViewGroup) r3;
    L12:
        com.larus.av_call.view.c r5 = this.a;
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r5 = null;
    L15:
        View r6 = W6(r5);
        if ((r6 instanceof View) == false) goto L18;
        View r7 = r6;
    L19:
        ObjectAnimator r8 = this.u;
        if (r8 == null) goto L22;
        r8.cancel();
    L22:
        this.u = null;
        r1.clearAnimation();
        r1.setRotation(0.0f);
        r1.setAlpha(1.0f);
        if (r10 != StatusIconAnimType.WAVE) goto L39;
        r1.setVisibility(8);
        if (r4 == null) goto L27;
        r4.setVisibility(0);
    L27:
        if (r4 == null) goto L58;
        if (r7 == null) goto L59;
        com.larus.av_call.view.c r11 = this.a;
        if (r11 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L34:
        com.larus.common_ui.view.u r12 = W6(r2);
        if (r12 == null) goto L37;
        r12.setColor(ContextCompat.getColor(getContext(), getDoubleLineStatusWaveColor()));
    L37:
        r7.setVisibility(0);
        return;
    L33:
        r2 = r11;
        goto L34
    L59:
        return;
    L58:
        return;
    L39:
        if (r7 == null) goto L41;
        r7.setVisibility(8);
    L41:
        if (r9 != null) goto L46;
        r1.setVisibility(8);
        if (r4 == null) goto L60;
        r4.setVisibility(8);
        return;
    L60:
        return;
    L46:
        if (r4 == null) goto L48;
        r4.setVisibility(0);
    L48:
        r1.setVisibility(0);
        r1.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), getDoubleLineStatusWaveColor())));
        r1.setImageResource(r9.intValue());
        int r13 = c.a[r10.ordinal()];
        if (r13 == 1) goto L56;
        if (r13 != 2) goto L52;
        return;
    L52:
        if (r13 != 3) goto L55;
        return;
    L55:
        throw new NoWhenBranchMatchedException();
    L56:
        ObjectAnimator r14 = ObjectAnimator.ofFloat(r1, View.ROTATION, new float[]{0.0f, 360.0f});
        r14.setDuration(1000);
        r14.setRepeatCount(-1);
        r14.setInterpolator(new LinearInterpolator());
        r14.start();
        this.u = r14;
        return;
    L18:
        r7 = null;
        goto L19
    L11:
        r4 = null;
        goto L12
    }

    public final void l9(int r7, boolean r8) {
        if (r7 != 14) goto L5;
    L7:
        boolean r2 = false;
        if (CollectionsKt.listOf(new Integer[]{6, 7}).contains(Integer.valueOf(r7)) == false) goto L11;
        H6(false);
        return;
    L11:
        if (CollectionsKt.listOf(new Integer[]{2, 8, 4, 5, 10}).contains(Integer.valueOf(r7)) == false) goto L21;
        Function0<Boolean> r9 = this.k;
        if (r9 != null) goto L15;
    L17:
        if (r2 == true) goto L22;
        H6(true);
        return;
    L22:
        return;
    L15:
        if (((Boolean) r9.invoke()).booleanValue() != true) goto L17;
        r2 = true;
        goto L17
    L21:
        return;
    L5:
        if (r7 == 15) goto L7;
        this.c = r7;
        this.d = r8;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Pair<Integer, Integer> o6(ScreenWidthType r5, int r6) {
        int r7 = c.b[r5.ordinal()];
        int r1 = 0;
        if (r7 == 1) goto L11;
        if (r7 != 2) goto L6;
        int r8 = i5.r0();
    L27:
        return new Pair(Integer.valueOf(r1), Integer.valueOf(r8));
    L6:
        if (r7 != 3) goto L9;
        r8 = i5.A();
        goto L27
    L9:
        throw new NoWhenBranchMatchedException();
    L11:
        h88.a r9 = this.g;
        if (r9 != null) goto L14;
    L16:
        if (r1 == 0) goto L18;
        int r10 = i5.J();
    L19:
        r1 = r10;
        Integer r11 = kga.b.a().h(getContext());
        if (r11 == null) goto L22;
        int r12 = r11.intValue();
    L23:
        r8 = ((((r12 - r1) - r1) - (i5.q0() * r6)) / (r6 - 1)) / 2;
        if (r8 > 0) goto L27;
        FLogger.a.i("VoiceCallBottomLayout", "[calculateContainerHorizontalPaddingAndItemHorizontalMargin] itemHorizontalMargin <= 0, set to default margin");
        r8 = i5.v0();
        goto L27
    L22:
        r12 = com.larus.utils.i.d(getContext());
        goto L23
    L18:
        r10 = i5.q();
        goto L19
    L14:
        if (r9.k0 != true) goto L16;
        r1 = 1;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v3, types: [android.view.View, android.view.ViewGroup, com.larus.av_call.view.VoiceCallBottomLayout] */
    public final void o7(h88.a r41, h88.b r42) {
        Intrinsics.checkNotNullParameter(r41, "argumentData");
        Intrinsics.checkNotNullParameter(r42, "runtimeData");
        this.f = r42;
        this.g = r41;
        this.i = r42.i;
        Integer r29 = null;
        if (this.l == true) goto L169;
        this.l = true;
        boolean r1 = r41.m;
        boolean r0 = r41.T;
        if (r42.d != true) goto L7;
        boolean r2 = true;
    L8:
        IRealtimeCallConfigDependency r3 = this.e;
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L15:
        if (getShouldUseDoubleLineCallUI() == true) goto L31;
        if (r4 == true) goto L31;
        if (getEnableRtcVlm() == true) goto L31;
        if (r1 == false) goto L28;
        IRealtimeCallConfigDependency r5 = this.e;
        if (r5 != null) goto L23;
    L25:
        boolean r6 = false;
    L26:
        if (r6 == true) goto L31;
    L23:
        if (r5.e() != true) goto L25;
        r6 = true;
    L28:
        if (H8() == true) goto L31;
        boolean r7 = false;
    L32:
        FLogger r11 = FLogger.a;
        StringBuilder r8 = new StringBuilder("getView result=");
        r8.append(r7);
        r8.append(", takePhotoEnable=");
        r8.append(r4);
        r8.append(", enableRtcVlm=");
        r8.append(getEnableRtcVlm());
        r8.append(", openVLMOnStart=");
        r8.append(r1);
        r8.append(", simpleMode=");
        r8.append(r0);
        r8.append(", isMainBot=");
        r8.append(r2);
        r8.append(", isVideoEnable=");
        IRealtimeCallConfigDependency r9 = this.e;
        if (r9 == null) goto L35;
        Boolean r10 = Boolean.valueOf(r9.e());
    L36:
        r8.append(r10);
        r8.append(", isScreenShareEnable=");
        IRealtimeCallConfigDependency r12 = this.e;
        if (r12 == null) goto L39;
        Boolean r13 = Boolean.valueOf(r12.g());
    L40:
        r8.append(r13);
        r8.append(", isTakePhotoEnable=");
        IRealtimeCallConfigDependency r14 = this.e;
        if (r14 == null) goto L43;
        Boolean r15 = Boolean.valueOf(r14.h());
    L44:
        r8.append(r15);
        r8.append(", useDoubleLineCallUI=");
        r8.append(getShouldUseDoubleLineCallUI());
        r11.i("VoiceCallBottomLayout", r8.toString());
        int r16 = 2131367912;
        if (r7 == false) goto L134;
        if (r0 == true) goto L134;
        this.o = true;
        r11.i("VoiceCallBottomLayout", "getView use V2 binding");
        LayoutInflater.from(getContext()).inflate(2131562869, this);
        ChatContinuousAudioVisualizerOpt r17 = ViewBindings.findChildViewById(this, 2131367912);
        if (r17 == null) goto L133;
        TextView r19 = (TextView) ViewBindings.findChildViewById(this, 2131383804);
        if (r19 == null) goto L130;
        AppCompatImageView r20 = ViewBindings.findChildViewById(this, 2131383808);
        if (r20 == null) goto L129;
        ProgressBar r21 = (ProgressBar) ViewBindings.findChildViewById(this, 2131383809);
        if (r21 == null) goto L128;
        View r22 = ViewBindings.findChildViewById(this, 2131383810);
        if (r22 == null) goto L127;
        FrameLayout r110 = (FrameLayout) ViewBindings.findChildViewById(this, 2131383811);
        if (r110 == null) goto L126;
        View r111 = ViewBindings.findChildViewById(this, 2131383815);
        if (r111 == null) goto L125;
        FrameLayout r23 = (FrameLayout) ViewBindings.findChildViewById(this, 2131383816);
        if (r23 == null) goto L124;
        CustomBarCountAudioVisualizer r24 = ViewBindings.findChildViewById(this, 2131383824);
        if (r24 == null) goto L123;
        AppCompatImageView r25 = ViewBindings.findChildViewById(this, 2131383825);
        if (r25 != null) goto L68;
        r16 = 2131383825;
        goto L133
    L68:
        if (((RealtimeCallStatusAudioVisualizer) ViewBindings.findChildViewById(this, 2131383826)) == null) goto L121;
        FrameLayout r26 = (FrameLayout) ViewBindings.findChildViewById(this, 2131383827);
        if (r26 == null) goto L120;
        RealtimeCallSuggestView r27 = (RealtimeCallSuggestView) ViewBindings.findChildViewById(this, 2131383831);
        if (r27 == null) goto L119;
        LinearLayout r210 = (LinearLayout) ViewBindings.findChildViewById(this, 2131392656);
        if (r210 == null) goto L118;
        AppCompatImageView r211 = ViewBindings.findChildViewById(this, 2131392658);
        if (r211 == null) goto L117;
        FrameLayout r212 = (FrameLayout) ViewBindings.findChildViewById(this, 2131392659);
        if (r212 == null) goto L116;
        View r213 = ViewBindings.findChildViewById(this, 2131392661);
        if (r213 == null) goto L115;
        FrameLayout r112 = (FrameLayout) ViewBindings.findChildViewById(this, 2131392662);
        if (r112 == null) goto L114;
        RealtimeBottomMoreBtn r30 = (RealtimeBottomMoreBtn) ViewBindings.findChildViewById(this, 2131392664);
        if (r30 != null) goto L86;
        r16 = 2131392664;
        goto L133
    L86:
        if (ViewBindings.findChildViewById(this, 2131392665) == null) goto L112;
        View r31 = ViewBindings.findChildViewById(this, 2131392667);
        if (r31 == null) goto L111;
        FrameLayout r32 = (FrameLayout) ViewBindings.findChildViewById(this, 2131392668);
        if (r32 == null) goto L110;
        ConstraintLayout r33 = ViewBindings.findChildViewById(this, 2131392669);
        if (r33 == null) goto L109;
        UrlSpanTextView r34 = ViewBindings.findChildViewById(this, 2131392670);
        if (r34 == null) goto L108;
        AppCompatImageView r35 = ViewBindings.findChildViewById(this, 2131392671);
        if (r35 == null) goto L107;
        FrameLayout r36 = (FrameLayout) ViewBindings.findChildViewById(this, 2131392672);
        if (r36 == null) goto L106;
        View r37 = ViewBindings.findChildViewById(this, 2131392675);
        if (r37 == null) goto L105;
        FrameLayout r38 = (FrameLayout) ViewBindings.findChildViewById(this, 2131392676);
        if (r38 == null) goto L104;
        VoiceCallBottomLayout r113 = this;
        com.larus.av_call.view.c r39 = new a1(new LarusLayoutRealtimeCallBottomNewV2Binding(this, r17, r19, r20, r21, r22, r110, r111, r23, r24, r25, r26, r27, r210, r211, r212, r213, r112, r30, r31, r32, r33, r34, r35, r36, r37, r38), r113);
        boolean r40 = false;
        VoiceCallBottomLayout r114 = r113;
    L157:
        r114.a = r39;
        VoiceCallBottomLayout r115 = r114;
    L170:
        h88.a r43 = r115.g;
        if (r43 == null) goto L175;
        boolean r44 = true;
        if (r43.k0 != true) goto L176;
        boolean r116 = true;
    L178:
        if (r116 == false) goto L234;
        int r45 = j19.c.c(66);
        com.larus.av_call.view.c r46 = r115.a;
        if (r46 != null) goto L182;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r46 = null;
    L182:
        View r47 = r46.m();
        ViewGroup.LayoutParams r48 = r47.getLayoutParams();
        if (r48 == null) goto L233;
        r48.width = r45;
        r48.height = r45;
        r47.setLayoutParams(r48);
        com.larus.av_call.view.c r49 = r115.a;
        if (r49 != null) goto L187;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r49 = null;
    L187:
        View r50 = r49.b();
        if (r50 == null) goto L194;
        ViewGroup.LayoutParams r51 = r50.getLayoutParams();
        if (r51 == null) goto L193;
        r51.width = r45;
        r51.height = r45;
        r50.setLayoutParams(r51);
        goto L194
    L193:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L194:
        com.larus.av_call.view.c r52 = r115.a;
        if (r52 != null) goto L197;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r52 = null;
    L197:
        View r53 = r52.k();
        ViewGroup.LayoutParams r54 = r53.getLayoutParams();
        if (r54 == null) goto L231;
        r54.width = r45;
        r54.height = r45;
        r53.setLayoutParams(r54);
        com.larus.av_call.view.c r55 = r115.a;
        if (r55 != null) goto L202;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r55 = null;
    L202:
        RealtimeBottomMoreBtn r56 = r55.a();
        if (r56 == null) goto L209;
        ViewGroup.LayoutParams r57 = r56.getLayoutParams();
        if (r57 == null) goto L208;
        r57.width = r45;
        r57.height = r45;
        r56.setLayoutParams(r57);
        goto L209
    L208:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L209:
        com.larus.av_call.view.c r59 = r115.a;
        if (r59 != null) goto L212;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r59 = null;
    L212:
        AppCompatImageView r60 = r59.q();
        int r61 = i5.z();
        r60.setPadding(r61, r61, r61, r61);
        com.larus.av_call.view.c r62 = r115.a;
        if (r62 != null) goto L215;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r62 = null;
    L215:
        ConstraintLayout.LayoutParams r63 = r62.c().getLayoutParams();
        if ((r63 instanceof ConstraintLayout.LayoutParams) == false) goto L218;
        ConstraintLayout.LayoutParams r64 = r63;
    L219:
        if (r64 == null) goto L221;
        r64.setMargins(((ViewGroup.MarginLayoutParams) r64).leftMargin, ((ViewGroup.MarginLayoutParams) r64).topMargin, ((ViewGroup.MarginLayoutParams) r64).rightMargin, i5.Z());
    L221:
        com.larus.av_call.view.c r65 = r115.a;
        if (r65 != null) goto L224;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r65 = null;
    L224:
        ConstraintLayout.LayoutParams r66 = r65.j().getLayoutParams();
        if ((r66 instanceof ConstraintLayout.LayoutParams) == false) goto L227;
        ConstraintLayout.LayoutParams r67 = r66;
    L228:
        if (r67 == null) goto L234;
        r67.setMargins(((ViewGroup.MarginLayoutParams) r67).leftMargin, ((ViewGroup.MarginLayoutParams) r67).topMargin, ((ViewGroup.MarginLayoutParams) r67).rightMargin, i5.q());
        goto L234
    L227:
        r67 = null;
        goto L228
    L218:
        r64 = null;
        goto L219
    L231:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L233:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L234:
        Integer r68 = kga.b.a().h(getContext());
        if (r68 == null) goto L237;
        int r69 = r68.intValue();
    L238:
        r115.setupButtons(i88.f.a(r69));
        r115.i8(r40, r42.p, r42.q);
        A8();
        com.larus.av_call.view.c r70 = r115.a;
        if (r70 != null) goto L241;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r70 = null;
    L241:
        com.larus.common_ui.view.u r71 = r70.p();
        IRealtimeCallConfigDependency r72 = r115.e;
        if (r72 != null) goto L244;
    L246:
        boolean r117 = false;
    L247:
        if (r117 == false) goto L249;
        r71.b();
    L249:
        IRealtimeCallConfigDependency r73 = r115.e;
        if (r73 == null) goto L261;
        Integer r74 = Integer.valueOf(r73.d());
        if (r74.intValue() <= 0) goto L254;
        boolean r118 = true;
    L255:
        if (r118 == true) goto L258;
        r74 = null;
    L258:
        if (r74 == null) goto L261;
        r71.setFps(r74.intValue());
        goto L261
    L254:
        r118 = false;
    L261:
        if (getShouldUseDoubleLineCallUI() == false) goto L286;
        com.larus.av_call.view.c r75 = r115.a;
        if (r75 != null) goto L265;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r75 = null;
    L265:
        com.larus.common_ui.view.u r76 = W6(r75);
        if (r76 == null) goto L287;
        IRealtimeCallConfigDependency r77 = r115.e;
        if (r77 != null) goto L270;
    L272:
        boolean r119 = false;
    L273:
        if (r119 == false) goto L275;
        r76.b();
    L275:
        IRealtimeCallConfigDependency r79 = r115.e;
        if (r79 == null) goto L288;
        Integer r80 = Integer.valueOf(r79.d());
        if (r80.intValue() <= 0) goto L280;
        boolean r120 = true;
    L281:
        if (r120 == false) goto L283;
        r29 = r80;
    L283:
        if (r29 == null) goto L289;
        r76.setFps(r29.intValue());
        return;
    L289:
        return;
    L280:
        r120 = false;
        goto L281
    L288:
        return;
    L270:
        if (r77.enableRecord() != r44) goto L272;
        r119 = true;
        goto L273
    L287:
        return;
    L286:
        return;
    L244:
        if (r72.enableRecord() != r44) goto L246;
        r117 = true;
        goto L247
    L237:
        r69 = com.larus.utils.i.d(getContext());
    L176:
        r116 = false;
        goto L178
    L175:
        r44 = true;
        goto L176
    L104:
        r16 = 2131392676;
        goto L133
    L105:
        r16 = 2131392675;
        goto L133
    L106:
        r16 = 2131392672;
        goto L133
    L107:
        r16 = 2131392671;
        goto L133
    L108:
        r16 = 2131392670;
        goto L133
    L109:
        r16 = 2131392669;
        goto L133
    L110:
        r16 = 2131392668;
        goto L133
    L111:
        r16 = 2131392667;
        goto L133
    L112:
        r16 = 2131392665;
        goto L133
    L114:
        r16 = 2131392662;
        goto L133
    L115:
        r16 = 2131392661;
        goto L133
    L116:
        r16 = 2131392659;
        goto L133
    L117:
        r16 = 2131392658;
        goto L133
    L118:
        r16 = 2131392656;
        goto L133
    L119:
        r16 = 2131383831;
        goto L133
    L120:
        r16 = 2131383827;
        goto L133
    L121:
        r16 = 2131383826;
        goto L133
    L123:
        r16 = 2131383824;
        goto L133
    L124:
        r16 = 2131383816;
        goto L133
    L125:
        r16 = 2131383815;
        goto L133
    L126:
        r16 = 2131383811;
        goto L133
    L127:
        r16 = 2131383810;
        goto L133
    L128:
        r16 = 2131383809;
        goto L133
    L129:
        r16 = 2131383808;
        goto L133
    L130:
        r16 = 2131383804;
    L133:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r16)));
    L134:
        ?? r121 = this;
        LayoutInflater.from(getContext()).inflate(2131562868, r121);
        ChatContinuousAudioVisualizerOpt r81 = ViewBindings.findChildViewById(r121, 2131367912);
        if (r81 == null) goto L168;
        TextView r122 = (TextView) ViewBindings.findChildViewById(r121, 2131383804);
        if (r122 == null) goto L166;
        AppCompatImageView r82 = ViewBindings.findChildViewById(r121, 2131383808);
        if (r82 == null) goto L165;
        ProgressBar r83 = (ProgressBar) ViewBindings.findChildViewById(r121, 2131383809);
        if (r83 == null) goto L164;
        View r84 = ViewBindings.findChildViewById(r121, 2131383810);
        if (r84 == null) goto L163;
        CustomBarCountAudioVisualizer r123 = ViewBindings.findChildViewById(r121, 2131383824);
        if (r123 == null) goto L162;
        RealtimeCallSuggestView r124 = (RealtimeCallSuggestView) ViewBindings.findChildViewById(r121, 2131383831);
        if (r124 == null) goto L161;
        LinearLayout r125 = (LinearLayout) ViewBindings.findChildViewById(r121, 2131392656);
        if (r125 == null) goto L160;
        View r126 = ViewBindings.findChildViewById(r121, 2131392661);
        if (r126 == null) goto L159;
        r16 = 2131392669;
        ConstraintLayout r127 = ViewBindings.findChildViewById(r121, 2131392669);
        if (r127 == null) goto L168;
        UrlSpanTextView r214 = ViewBindings.findChildViewById(r121, 2131392670);
        if (r214 == null) goto L158;
        LarusLayoutRealtimeCallBottomNewBinding r128 = new LarusLayoutRealtimeCallBottomNewBinding(this, r81, r122, r82, r83, r84, r123, r124, r125, r126, r127, r214);
        r40 = false;
        r121.o = false;
        r11.i("VoiceCallBottomLayout", "getView use V1 binding");
        r39 = new b1(r128, r121);
        r114 = r121;
        goto L157
    L158:
        r16 = 2131392670;
        goto L168
    L159:
        r16 = 2131392661;
        goto L168
    L160:
        r16 = 2131392656;
        goto L168
    L161:
        r16 = 2131383831;
        goto L168
    L162:
        r16 = 2131383824;
        goto L168
    L163:
        r16 = 2131383810;
        goto L168
    L164:
        r16 = 2131383809;
        goto L168
    L165:
        r16 = 2131383808;
        goto L168
    L166:
        r16 = 2131383804;
    L168:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r16)));
    L43:
        r15 = null;
        goto L44
    L39:
        r13 = null;
        goto L40
    L35:
        r10 = null;
    L31:
        r7 = true;
        goto L32
    L11:
        if (r3.l(r2) != true) goto L13;
        r4 = true;
        goto L15
    L7:
        r2 = false;
        goto L8
    L169:
        r115 = this;
        r40 = false;
        goto L170
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [com.larus.av_call.view.z] */
    public VoiceCallBottomLayout(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = -1;
        this.e = (IRealtimeCallConfigDependency) ServiceManager.get().getService(IRealtimeCallConfigDependency.class);
        this.h = new x();
        this.i = ThemeType.DEFAULT;
        this.n = "";
        this.r = true;
        this.s = true;
        this.w = new y();
        this.C = new z(this, r2);
    }

    public static Unit S5(VoiceCallBottomLayout r1, boolean r2, TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$updateStyle");
        r1.N9(r3);
        if (r1.getShouldUseDoubleLineCallUI() == false) goto L9;
        if (r2 == false) goto L6;
        Integer r4 = null;
    L7:
        r1.i6(r3, r4, StatusIconAnimType.NONE);
        goto L9
    L6:
        r4 = 2131240715;
    L9:
        return Unit.INSTANCE;
    }

    public static Unit T5(VoiceCallBottomLayout r1, boolean r2, TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$updateStyle");
        r1.N9(r3);
        if (r1.getShouldUseDoubleLineCallUI() == false) goto L9;
        if (r2 == false) goto L6;
        StatusIconAnimType r4 = StatusIconAnimType.NONE;
    L7:
        r1.i6(r3, null, r4);
        goto L9
    L6:
        r4 = StatusIconAnimType.WAVE;
    L9:
        return Unit.INSTANCE;
    }

    public static Unit V5(VoiceCallBottomLayout r1, boolean r2, TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$updateStyle");
        r1.N9(r3);
        if (r1.getShouldUseDoubleLineCallUI() == false) goto L9;
        if (r2 == false) goto L6;
        StatusIconAnimType r4 = StatusIconAnimType.NONE;
    L7:
        r1.i6(r3, null, r4);
        goto L9
    L6:
        r4 = StatusIconAnimType.WAVE;
    L9:
        return Unit.INSTANCE;
    }

    public final void V8(boolean r7, boolean r8, boolean r9) {
        boolean r0 = true;
        int r1 = 0;
        if (r7 == true) goto L13;
        Job r10 = this.b;
        if (r10 != null) goto L7;
    L9:
        boolean r11 = false;
    L10:
        if (r11 == false) goto L13;
        return;
    L7:
        if (r10.isActive() != true) goto L9;
        r11 = true;
    L13:
        if (getNeedShowBadNetNotice() == false) goto L16;
        FLogger.a.i("VoiceCallBottomLayout", "showInterruptBtn needShowBadNetNotice is true");
        return;
    L16:
        com.larus.av_call.view.c r5 = null;
        if (StringsKt.equals$default(this.x, "interpret_v2", false, 2, null) == false) goto L20;
        FLogger.a.i("VoiceCallBottomLayout", "interpret scene do not show interrupt btn");
        return;
    L20:
        FLogger.a.i("VoiceCallBottomLayout", "showInterruptBtn exec");
        com.larus.av_call.view.c r12 = this.a;
        if (r12 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L24:
        UrlSpanTextView r13 = r5.n();
        this.z = new q(this);
        N9(r13);
        if (r9 == false) goto L34;
        IRealtimeCallConfigDependency r14 = this.e;
        if (r14 != null) goto L29;
    L31:
        boolean r15 = false;
    L32:
        if (r15 == false) goto L34;
        String r16 = AppHost.a.getApplication().getString(2131900507);
    L45:
        r13.setText(r16);
        if (getShouldUseDoubleLineCallUI() == false) goto L48;
        k6(this, r13, 2131240714, 2);
    L48:
        r5.n().setVisibility(0);
        AppCompatImageView r17 = r5.q();
        if (getShouldUseDoubleLineCallUI() == false) goto L51;
        r1 = 8;
    L51:
        r17.setVisibility(r1);
        Application r19 = i88.e.a;
        i88.e.d(r5.q(), this.i, this.m, this.g);
        AppCompatImageView r20 = r5.q();
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        if (r21 == null) goto L56;
        r21.width = c7.b(18);
        r21.height = c7.b(18);
        r20.setLayoutParams(r21);
        r5.g().setVisibility(8);
        r5.p().a(8);
        r5.i().a(new b0(this));
        return;
    L56:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L29:
        if (r14.j() != true) goto L31;
        r15 = true;
    L34:
        if (r8 == false) goto L36;
        r16 = AppHost.a.getApplication().getString(2131900507);
        goto L45
    L36:
        IRealtimeCallConfigDependency r22 = this.e;
        if (r22 != null) goto L39;
    L41:
        r0 = false;
    L42:
        if (r0 == false) goto L44;
        r16 = AppHost.a.getApplication().getString(2131900486);
        goto L45
    L44:
        r16 = AppHost.a.getApplication().getString(2131898449);
        goto L45
    L39:
        if (r22.f() != true) goto L41;
    L23:
        r5 = r12;
        goto L24
    }

    public final void i6(TextView r4, Integer r5, StatusIconAnimType r6) {
        r4.setTextSize(0, j19.c.c(14));
        r4.setTextColor(ContextCompat.getColor(r4.getContext(), getDoubleLineStatusTextColor()));
        r4.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        r4.setCompoundDrawablePadding(0);
        B9(r5, r6);
        r4.setAlpha(1.0f);
    }

    public final void i8(boolean r12, boolean r13, boolean r14) {
        this.m = r12;
        Application r15 = i88.e.a;
        com.larus.av_call.view.c r16 = this.a;
        com.larus.av_call.view.c r17 = null;
        if (r16 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r16 = null;
    L5:
        ThemeType r1 = this.i;
        h88.b r2 = this.f;
        h88.a r3 = this.g;
        boolean r4 = ((Boolean) this.h.invoke()).booleanValue();
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Intrinsics.checkNotNullParameter(r1, "themeType");
        boolean r7 = false;
        if (r2 != null) goto L8;
    L10:
        boolean r9 = false;
    L11:
        i88.e.e(r16.k(), r1, r12, r2, r3);
        if (r4 == false) goto L16;
        RealtimeBottomMoreBtn r5 = r16.a();
        if (r5 == null) goto L16;
        i88.e.c(r5, r2);
    L16:
        r16.p().setColor(i88.e.b(r1, r12, r3));
        View r6 = r16.m();
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r1, "themeType");
        if (r3 != null) goto L19;
    L21:
        boolean r10 = false;
    L22:
        if (r10 == true) goto L24;
    L26:
        if (r9 == false) goto L28;
        int r11 = 2131242330;
    L34:
        r6.setBackgroundResource(r11);
        if (r12 == false) goto L37;
    L44:
        ColorStateList r8 = (ColorStateList) i88.e.d.getValue();
        com.larus.av_call.view.b r19 = r16.f();
        if (r19 == null) goto L49;
        r19.d = true;
        h88.d r20 = r19.c;
        if (r20 == null) goto L49;
        r20.d(true);
    L49:
        if (r3 != null) goto L51;
    L53:
        boolean r21 = false;
    L54:
        if (r21 == false) goto L56;
        r16.o().setTextColor(i88.e.a(i88.e.a, 2130972081, 2131103143));
    L62:
        if (r2 == null) goto L64;
        RealtimePageMode r22 = r2.u;
    L66:
        if (r22 != RealtimePageMode.HALF_SCREEN) goto L73;
        if (AppHost.a.isOversea() == false) goto L73;
        boolean r23 = v19.h.a;
        if (v19.h.a(null) == true) goto L73;
        r8 = (ColorStateList) i88.e.c.getValue();
        FLogger.a.i("CallUIExt", "setDarkMode loadingDrawableDarkDola");
    L73:
        if (Intrinsics.areEqual(r8, r16.g().getIndeterminateTintList()) == true) goto L75;
        r16.g().setIndeterminateTintList(r8);
    L75:
        com.larus.av_call.view.c r110 = this.a;
        if (r110 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r110 = null;
    L78:
        N9(r110.n());
        if (getShouldUseDoubleLineCallUI() == true) goto L81;
    L95:
        com.larus.av_call.view.c r111 = this.a;
        if (r111 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r111 = null;
    L98:
        r111.i().a(new j0(this));
        com.larus.av_call.view.c r112 = this.a;
        if (r112 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r112 = null;
    L101:
        D9(r112);
        com.larus.av_call.view.c r113 = this.a;
        if (r113 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r113 = null;
    L104:
        I9(r113);
        h88.b r114 = this.f;
        if (r114 != null) goto L107;
    L109:
        boolean r115 = false;
    L110:
        if (r115 == false) goto L128;
        com.larus.av_call.view.c r116 = this.a;
        if (r116 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L115:
        View r117 = r17.h();
        if (r117 == null) goto L140;
        ThemeType r118 = this.i;
        h88.b r0 = this.f;
        if (r0 != null) goto L120;
    L122:
        Intrinsics.checkNotNullParameter(r117, "<this>");
        Intrinsics.checkNotNullParameter(r118, "themeType");
        if (r7 == true) goto L127;
        if (r12 == true) goto L127;
        i88.e.o(r118);
    L127:
        r117.setBackgroundResource(2131242333);
        goto L140
    L120:
        if (r0.r != true) goto L122;
        r7 = true;
    L140:
        c6();
        return;
    L114:
        r17 = r116;
        goto L115
    L128:
        com.larus.av_call.view.c r119 = this.a;
        if (r119 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
    L132:
        View r120 = r17.h();
        if (r120 == null) goto L140;
        ThemeType r121 = this.i;
        h88.b r24 = this.f;
        if (r24 != null) goto L137;
    L139:
        i88.e.i(r120, r121, r12, r7);
        goto L140
    L137:
        if (r24.r != true) goto L139;
        r7 = true;
        goto L139
    L131:
        r17 = r119;
        goto L132
    L107:
        if (r114.t != true) goto L109;
        r115 = true;
        goto L110
    L81:
        if (this.c != 3) goto L95;
        com.larus.av_call.view.c r122 = this.a;
        if (r122 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r122 = null;
    L85:
        UrlSpanTextView r123 = r122.n();
        h88.b r25 = this.f;
        if (r25 != null) goto L88;
    L90:
        boolean r26 = false;
    L91:
        if (r26 == false) goto L93;
        StatusIconAnimType r27 = StatusIconAnimType.NONE;
    L94:
        i6(r123, null, r27);
        goto L95
    L93:
        r27 = StatusIconAnimType.WAVE;
        goto L94
    L88:
        if (r25.m != true) goto L90;
        r26 = true;
        goto L91
    L64:
        r22 = null;
        goto L66
    L56:
        if (r12 == false) goto L58;
    L61:
        TextView r29 = r16.o();
        int r30 = com.larus.utils.j0.a;
        r29.setTextColor(com.larus.utils.j0.a(2131103249));
        goto L62
    L58:
        if (i88.e.o(r1) == true) goto L61;
        TextView r31 = r16.o();
        int r32 = com.larus.utils.j0.a;
        r31.setTextColor(com.larus.utils.j0.a(2131103248));
        goto L62
    L51:
        if (r3.k0 != true) goto L53;
        r21 = true;
        goto L54
    L37:
        if (i88.e.o(r1) == true) goto L44;
        r8 = (ColorStateList) i88.e.c.getValue();
        com.larus.av_call.view.b r33 = r16.f();
        if (r33 == null) goto L49;
        r33.d = false;
        h88.d r34 = r33.c;
        if (r34 == null) goto L49;
        r34.d(false);
        goto L49
    L28:
        if (r12 == false) goto L30;
    L33:
        r11 = 2131242285;
        goto L34
    L30:
        if (i88.e.o(r1) == true) goto L33;
        r11 = 2131242284;
        goto L34
    L24:
        if (AppHost.a.isOversea() == false) goto L26;
        r11 = 2131242286;
        goto L34
    L19:
        if (r3.k0 != true) goto L21;
        r10 = true;
        goto L22
    L8:
        if (r2.r != true) goto L10;
        r9 = true;
        goto L11
    }

    public final boolean u6(Context r4, boolean r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (this.c != 6) goto L7;
        t19.s.a.g(r4, 2131900505, false);
        return false;
    L7:
        if (r5 == false) goto L9;
        return true;
    L9:
        h88.b r7 = this.f;
        if (r7 != null) goto L12;
    L14:
        boolean r8 = false;
    L15:
        if (r8 == true) goto L19;
        t19.s.a.g(r4, 2131900504, false);
        return false;
    L19:
        if (TextUtils.isEmpty(this.x) == true) goto L22;
        t19.s.a.g(r4, r6, false);
        return false;
    L22:
        return true;
    L12:
        if (r7.d != true) goto L14;
        r8 = true;
        goto L15
    }

    public /* synthetic */ VoiceCallBottomLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static /* synthetic */ void k6(VoiceCallBottomLayout r2, TextView r3, Integer r4, int r5) {
        StatusIconAnimType r1 = null;
        if ((r5 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r1 = StatusIconAnimType.NONE;
    L8:
        r2.i6(r3, r4, r1);
    }

    public final void G7(int r6, String r7, boolean r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "errorMsg");
        FLogger.a.i("VoiceCallBottomLayout", "onNetworkError exec");
        com.larus.av_call.view.c r0 = this.a;
        String r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomBinding");
        r0 = null;
    L5:
        UrlSpanTextView r2 = r0.n();
        this.z = null;
        r2.setTextColor(ContextCompat.getColor(r2.getContext(), 2131102650));
        if (getShouldUseDoubleLineCallUI() == false) goto L8;
        r2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        r2.setCompoundDrawablePadding(0);
        B9(null, StatusIconAnimType.NONE);
    L8:
        if (r8 == false) goto L27;
        IRealtimeCallConfigDependency r10 = this.e;
        if (r10 == null) goto L12;
        String r11 = r10.k();
    L13:
        if (r11 != null) goto L15;
    L18:
        boolean r12 = true;
    L19:
        if (r12 == false) goto L21;
        String r13 = r2.getContext().getString(2131910598);
    L28:
        r2.setText(r13);
        r2.setAlpha(1.0f);
        r2.setVisibility(0);
        r0.g().setVisibility(8);
        r0.p().a(8);
        r0.q().setVisibility(8);
        Function0<? extends IRealtimeCallTracer> r14 = this.j;
        if (r14 == null) goto L33;
        IRealtimeCallTracer r15 = (IRealtimeCallTracer) r14.invoke();
        if (r15 == null) goto L33;
        r15.J(r6, r7, r9);
    L33:
        E8();
        return;
    L21:
        IRealtimeCallConfigDependency r16 = this.e;
        if (r16 == null) goto L24;
        r1 = r16.k();
    L24:
        if (r1 != null) goto L26;
        r13 = "";
        goto L28
    L26:
        r13 = r1;
        goto L28
    L15:
        if (r11.length() == 0) goto L18;
        r12 = false;
        goto L19
    L12:
        r11 = null;
        goto L13
    L27:
        r13 = r2.getContext().getString(2131908699);
        goto L28
    }

    public static void b6(LinearLayout r3, View r4, int r5, int r6, int r7) {
        ViewParent r0 = r4.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 == null) goto L8;
        r1.removeView(r4);
    L8:
        int r8 = r7 / 2;
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(r6, r6);
        if (r5 != 0) goto L11;
        int r9 = 0;
    L12:
        r2.setMarginStart(r9);
        if (r5 != 2) goto L15;
        r8 = 0;
    L15:
        r2.setMarginEnd(r8);
        Unit r10 = Unit.INSTANCE;
        r3.addView(r4, r2);
        return;
    L11:
        r9 = r8;
        goto L12
    L5:
        r1 = null;
        goto L6
    }
}
