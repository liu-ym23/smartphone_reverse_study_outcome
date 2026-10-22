package com.larus.dora.obric.onboarding;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.router.SmartRouter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.business.markdown.impl.markwon.MarkdownTextView;
import com.larus.dora.impl.databinding.ObricDoraGOnboardingFragmentV2Binding;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.resource.DoraResourceTheme;
import com.larus.dora.impl.resource.DoraResourceType;
import com.larus.dora.impl.view.DoraTextViewWithAnim;
import com.larus.dora.obric.view.ObricFloatingTitleBar;
import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.AccountService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.live.alphaplayer.Configuration;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.PlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000ë\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b2\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001=\u0018\u0000 Ñ\u00012\u00020\u0001:\u0004Ð\u0001Ñ\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020#2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\u0010\u0010R\u001a\u00020N2\u0006\u0010O\u001a\u00020#H\u0002J\b\u0010S\u001a\u00020NH\u0016J\b\u0010T\u001a\u00020UH\u0016J\u0006\u0010V\u001a\u00020NJ\u0006\u0010W\u001a\u00020NJ\u0006\u0010X\u001a\u00020NJ\u0006\u0010Y\u001a\u00020NJ\u0006\u0010Z\u001a\u00020NJ\u0006\u0010[\u001a\u00020NJ\b\u0010\\\u001a\u0004\u0018\u00010\u000eJ\u001c\u0010]\u001a\u00020N2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010_\u001a\u00020\u0010J\u0006\u0010`\u001a\u00020NJ\b\u0010a\u001a\u00020NH\u0002J\b\u0010b\u001a\u00020NH\u0002J\u0006\u0010c\u001a\u00020NJ\b\u0010d\u001a\u00020NH\u0002J\b\u0010e\u001a\u00020NH\u0002J\b\u0010f\u001a\u00020NH\u0002J\b\u0010g\u001a\u00020NH\u0002J\u0010\u0010h\u001a\u00020N2\u0006\u0010i\u001a\u00020jH\u0002J\u0010\u0010k\u001a\u00020N2\u0006\u0010i\u001a\u00020jH\u0002J\u0018\u0010l\u001a\u00020N2\u0006\u0010m\u001a\u00020\u000e2\u0006\u0010n\u001a\u00020\u000eH\u0002J\u0010\u0010o\u001a\u00020N2\u0006\u0010i\u001a\u00020jH\u0002J\b\u0010p\u001a\u00020NH\u0002J\b\u0010q\u001a\u00020NH\u0002J\u0012\u0010r\u001a\u00020N2\b\u0010^\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010s\u001a\u00020NH\u0002J\b\u0010t\u001a\u00020NH\u0002J\b\u0010u\u001a\u00020NH\u0002J\b\u0010v\u001a\u00020NH\u0002J\u0010\u0010w\u001a\u00020N2\u0006\u0010m\u001a\u00020\u000eH\u0002J\b\u0010x\u001a\u00020NH\u0002J\u0012\u0010y\u001a\u00020N2\b\u0010z\u001a\u0004\u0018\u00010#H\u0002J\b\u0010{\u001a\u00020NH\u0002J\b\u0010|\u001a\u00020NH\u0002J\b\u0010}\u001a\u00020~H\u0002J\u000e\u0010\u007f\u001a\u0004\u0018\u00010\u000e*\u00020jH\u0002J\r\u0010\u0080\u0001\u001a\u00020\u0010*\u00020jH\u0002J\r\u0010\u0081\u0001\u001a\u00020\u000e*\u00020jH\u0002J\r\u0010\u0082\u0001\u001a\u00020\u0010*\u00020jH\u0002J\u0007\u0010\u0083\u0001\u001a\u00020NJ\u0007\u0010\u0084\u0001\u001a\u00020NJ\u0007\u0010\u0085\u0001\u001a\u00020NJ\u0007\u0010\u0086\u0001\u001a\u00020NJ\u0007\u0010\u0087\u0001\u001a\u00020NJ\u0007\u0010\u0088\u0001\u001a\u00020NJ\u0007\u0010\u0089\u0001\u001a\u00020NJ\t\u0010\u008a\u0001\u001a\u00020NH\u0002J\u0007\u0010\u008b\u0001\u001a\u00020NJ\t\u0010\u008c\u0001\u001a\u00020NH\u0002J\t\u0010\u008d\u0001\u001a\u00020\u0010H\u0002J.\u0010\u008e\u0001\u001a\u00020N2\u000b\b\u0002\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u000e2\t\b\u0002\u0010\u0090\u0001\u001a\u00020\u00102\u000b\b\u0002\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u000eH\u0002J\u0007\u0010\u0092\u0001\u001a\u00020NJ\u0007\u0010\u0093\u0001\u001a\u00020NJ\u0012\u0010\u0094\u0001\u001a\u00020N2\u0007\u0010\u0095\u0001\u001a\u00020#H\u0002J\t\u0010\u0096\u0001\u001a\u00020NH\u0002J\u0010\u0010\u0097\u0001\u001a\u00020N2\u0007\u0010\u0098\u0001\u001a\u00020\u0010J\u0010\u0010\u0099\u0001\u001a\u00020N2\u0007\u0010\u0098\u0001\u001a\u00020\u0010J\u001a\u0010\u009a\u0001\u001a\u00020N2\t\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0003\u0010\u009c\u0001J\u001b\u0010\u009d\u0001\u001a\u00020N2\u0007\u0010\u009e\u0001\u001a\u00020\u00142\u0007\u0010\u009f\u0001\u001a\u00020\u0010H\u0002J\t\u0010 \u0001\u001a\u00020NH\u0002J\t\u0010¡\u0001\u001a\u00020NH\u0002J\u001b\u0010¢\u0001\u001a\u00020N2\u0007\u0010£\u0001\u001a\u00020\f2\u0007\u0010¤\u0001\u001a\u00020\u0014H\u0002J\u001b\u0010¥\u0001\u001a\u00020N2\u0007\u0010£\u0001\u001a\u00020\f2\u0007\u0010¤\u0001\u001a\u00020\u0014H\u0002J\u001b\u0010¦\u0001\u001a\u00020N2\u0007\u0010£\u0001\u001a\u00020\f2\u0007\u0010¤\u0001\u001a\u00020\u0014H\u0002J\u001b\u0010§\u0001\u001a\u00020N2\u0007\u0010£\u0001\u001a\u00020\f2\u0007\u0010¤\u0001\u001a\u00020\u0014H\u0002J\u001b\u0010¨\u0001\u001a\u00020N2\u0007\u0010£\u0001\u001a\u00020\f2\u0007\u0010¤\u0001\u001a\u00020\u0014H\u0002J\u001b\u0010©\u0001\u001a\u00020N2\u0007\u0010£\u0001\u001a\u00020\f2\u0007\u0010¤\u0001\u001a\u00020\u0014H\u0002J\u001b\u0010ª\u0001\u001a\u00020N2\u0007\u0010£\u0001\u001a\u00020\f2\u0007\u0010¤\u0001\u001a\u00020\u0014H\u0002J\u0012\u0010«\u0001\u001a\u00020N2\u0007\u0010£\u0001\u001a\u00020\fH\u0002J\u001b\u0010¬\u0001\u001a\u00020\u000e2\u0007\u0010\u00ad\u0001\u001a\u00020\u000e2\u0007\u0010®\u0001\u001a\u00020\u000eH\u0002J,\u0010¯\u0001\u001a\u00020N2\b\u0010°\u0001\u001a\u00030±\u00012\u0007\u0010²\u0001\u001a\u00020\u00142\u000e\u0010³\u0001\u001a\t\u0012\u0004\u0012\u00020N0´\u0001H\u0002JG\u0010µ\u0001\u001a\u00020N2\u0007\u0010¶\u0001\u001a\u00020\u000e2-\u0010·\u0001\u001a\u0017\u0012\u0013\b\u0001\u0012\u000f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0¸\u00010@\"\u000f\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0¸\u0001H\u0002¢\u0006\u0003\u0010¹\u0001J$\u0010º\u0001\u001a\u00020N2\u0007\u0010»\u0001\u001a\u00020\u000e2\u0007\u0010²\u0001\u001a\u00020\u00142\u0007\u0010¼\u0001\u001a\u00020\u0014H\u0002J\t\u0010½\u0001\u001a\u00020NH\u0002J\u0012\u0010¾\u0001\u001a\u00020\u00102\u0007\u0010»\u0001\u001a\u00020\u000eH\u0002J\u0012\u0010¿\u0001\u001a\u00020\u00142\u0007\u0010»\u0001\u001a\u00020\u000eH\u0002J'\u0010À\u0001\u001a\u0005\u0018\u00010Á\u00012\u0007\u0010»\u0001\u001a\u00020\u000e2\u0007\u0010²\u0001\u001a\u00020\u00142\u0007\u0010Â\u0001\u001a\u00020\u0010H\u0002J\u000b\u0010Ã\u0001\u001a\u0004\u0018\u00010 H\u0002J\u000b\u0010Ä\u0001\u001a\u0004\u0018\u00010\tH\u0002J!\u0010Å\u0001\u001a\u0011\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0010\u0018\u00010¸\u00012\u0007\u0010»\u0001\u001a\u00020\u000eH\u0002J\u000b\u0010Æ\u0001\u001a\u0004\u0018\u00010\fH\u0002J\t\u0010Ç\u0001\u001a\u00020NH\u0002J\u0014\u0010È\u0001\u001a\u00020N2\t\b\u0002\u0010É\u0001\u001a\u00020\u0010H\u0002J\t\u0010Ê\u0001\u001a\u00020NH\u0002J\t\u0010Ë\u0001\u001a\u00020NH\u0002J\t\u0010Ì\u0001\u001a\u00020\tH\u0002J\u0015\u0010Í\u0001\u001a\u0005\u0018\u00010Î\u00012\u0007\u0010»\u0001\u001a\u00020\u000eH\u0002J\r\u0010Ï\u0001\u001a\u00020\u000e*\u00020QH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u00106\u001a\u0004\u0018\u0001078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b8\u00109R\u0010\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0004\n\u0002\u0010>R\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000e0@X\u0082\u0004¢\u0006\u0004\n\u0002\u0010AR!\u0010B\u001a\b\u0012\u0004\u0012\u00020D0C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010;\u001a\u0004\bE\u0010FR'\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010;\u001a\u0004\bJ\u0010K¨\u0006Ò\u0001"}, d2 = {"Lcom/larus/dora/obric/onboarding/ObricDoraGOnboardingWelcomeStateFragment;", "Lcom/larus/dora/obric/onboarding/ObricDoraGOnboardingUiStateBaseFragment;", "<init>", "()V", "titleBar", "Lcom/larus/dora/obric/view/ObricFloatingTitleBar;", "exitDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "alphaPlayer", "Lcom/ss/android/ugc/aweme/live/alphaplayer/controller/IPlayerController;", "preloadedAlphaPlayer", "preloadedAlphaLayer", "Landroid/widget/FrameLayout;", "preloadedAlphaAssetPath", "", "isPreloadedAlphaReady", "", "alphaPreloadJob", "Lkotlinx/coroutines/Job;", "alphaPreloadRequestId", "", "sharedAlphaVideoLayerRootLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "welcomePlaybackId", "welcomeVideoJob", "videoQueryPlaybackId", "clickStopPlaybackId", "longPressWakeupPlaybackId", "mediaControlPlaybackId", "photoPlaybackId", "finishPlaybackId", "videoQueryViews", "Lcom/larus/dora/obric/onboarding/ObricDoraGOnboardingWelcomeStateFragment$VideoQueryViews;", "activeSceneLayerIndex", "clickStopQueryContainerView", "Landroid/view/View;", "clickStopQueryLoadingView", "Landroid/widget/ImageView;", "clickStopQueryView", "Lcom/larus/dora/impl/view/DoraTextViewWithAnim;", "clickStopAnswerView", "Lcom/larus/business/markdown/impl/markwon/MarkdownTextView;", "clickStopAnswerContainerView", "clickStopAnswerLoadingView", "hasClickStopQueryEntryAnimated", "hasClickStopUserQueryEntryAnimated", "hasClickStopAnswerEntryAnimated", "latestVideoQueryAsrText", "videoQueryAsrResultListener", "Lcom/larus/dora/impl/plugin/IDoraAsrListener;", "clickStopAsrResultListener", "clickStopObserverConversationId", "isClickStopObserverRegistering", "showAnswerLoadingOnUserQuery", "doraPageConfig", "Lcom/larus/dora/api/config/IDoraPageConfig;", "getDoraPageConfig", "()Lcom/larus/dora/api/config/IDoraPageConfig;", "doraPageConfig$delegate", "Lkotlin/Lazy;", "clickStopMessageObserver", "com/larus/dora/obric/onboarding/ObricDoraGOnboardingWelcomeStateFragment$clickStopMessageObserver$1", "Lcom/larus/dora/obric/onboarding/ObricDoraGOnboardingWelcomeStateFragment$clickStopMessageObserver$1;", "sceneImages", "", "[Ljava/lang/String;", "configuredVideoQueryItems", "", "Lcom/larus/dora/obric/onboarding/ObricDoraOnboardingQueryItem;", "getConfiguredVideoQueryItems", "()Ljava/util/List;", "configuredVideoQueryItems$delegate", "presetAnswersByQuery", "", "getPresetAnswersByQuery", "()Ljava/util/Map;", "presetAnswersByQuery$delegate", "onViewCreated", "", "view", "savedInstanceState", "Landroid/os/Bundle;", "applyExternalOnboardingImages", "onDestroyView", "uiState", "Lcom/larus/dora/obric/onboarding/ObricDoraGOnboardingFragmentBaseUiState;", "showDirectDiaryState", "startWelcomeAlphaVideo", "stopWelcomeAlphaVideo", "showVideoQueryState", "hideVideoQueryState", "stopVideoQueryAutoScrollForVoiceWakeup", "getCurrentVideoQueryText", "showClickStopState", "queryText", "usePresetAnswer", "hideClickStopState", "registerClickStopMessageObserver", "unregisterClickStopMessageObserver", "trackClickStopSingleClickInterrupt", "registerVideoQueryAsrResultListener", "unregisterVideoQueryAsrResultListener", "registerClickStopAsrResultListener", "unregisterClickStopAsrResultListener", "updateClickStopMessage", "msg", "Lcom/larus/im/bean/message/Message;", "updateClickStopUserQuery", "updateClickStopUserQueryText", "text", "source", "updateClickStopRemoteAnswer", "showClickStopAnswerLoading", "showClickStopQueryLoading", "showClickStopPresetAnswer", "startClickStopReplyLoadingIndicator", "startClickStopQueryLoadingIndicator", "stopClickStopReplyLoadingIndicator", "stopClickStopQueryLoadingIndicator", "renderClickStopAnswer", "resetClickStopAnswer", "playClickStopEntryAnimation", "target", "playClickStopQueryEntryAnimation", "playClickStopAnswerEntryAnimation", "clickStopEntryTranslationY", "", "extractDisplayText", "isClickStopUserQueryMessage", "clickStopDebugSummary", "isCurrentAccountMessage", "showLongPressWakeupState", "hideLongPressWakeupState", "showMediaControlState", "hideMediaControlState", "showPhotoState", "hidePhotoState", "showDiaryState", "clearAlphaVideoContent", "hideDiaryState", "enableEnvObserveAndContinue", "isDirectDiaryEntry", "finishDiaryOnboarding", "leaveType", "openEnvObserve", "mac", "showFinishState", "hideFinishState", "initTitleBar", "root", "showExitDialog", "showTitleBarBackAction", "show", "showTitleBarCloseAction", "updateOnboardingProgress", "step", "(Ljava/lang/Integer;)V", "updateSceneImage", "index", "animate", "cancelSceneImageAnimations", "startVideoQueryAlphaVideo", "startClickStopAlphaVideo", "videoLayer", "playbackId", "startClickStopLoop", "startLongPressWakeupAlphaVideo", "startLongPressWakeupLoop", "startMediaControlAlphaVideo", "startPhotoAlphaVideo", "startPhotoLoop", "startFinishAlphaVideo", "resolveThemedAssetPath", "lightPath", "darkPath", "postAlphaSegmentTransition", "startedAt", "", "totalFrame", "action", "Lkotlin/Function0;", "preloadNextAlphaVideoAssets", "reason", "themedAssetPaths", "Lkotlin/Pair;", "(Ljava/lang/String;[Lkotlin/Pair;)V", "preloadAlphaVideo", "assetPath", "requestId", "invalidateAlphaPreload", "promotePreloadedAlphaVideo", "alphaVideoTotalFrame", "createAlphaDataSource", "Lcom/ss/android/ugc/aweme/live/alphaplayer/model/DataSource;", "loop", "bindVideoQueryViews", "sharedAlphaPlayer", "activeAlphaPlayer", "sharedAlphaVideoLayer", "showSharedAlphaVideoLayer", "hideSharedAlphaVideoLayer", "keepAttached", "moveSharedAlphaVideoLayerTo", "restoreSharedAlphaVideoLayerToRoot", "createAlphaPlayer", "resolveVideoFile", "Ljava/io/File;", "debugSummary", "VideoQueryViews", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricDoraGOnboardingWelcomeStateFragment extends ObricDoraGOnboardingUiStateBaseFragment {
    public static final /* synthetic */ int y1 = 0;
    public com.obric.oui.dialog.v2.alert.c A;
    public IPlayerController B;
    public IPlayerController C;
    public FrameLayout D;
    public String E;
    public boolean F;
    public Job G;
    public int H;
    public String H0;
    public ViewGroup.LayoutParams I;
    public int J;
    public Job K;
    public int L;
    public r1 L0;
    public int M;
    public int N;
    public int O;
    public int P;
    public ObricDoraGOnboardingWelcomeStateFragment$registerClickStopAsrResultListener$1 P0;
    public int Q;
    public b R;
    public int S;
    public View T;
    public ImageView U;
    public DoraTextViewWithAnim V;
    public String V0;
    public MarkdownTextView W;
    public View X;
    public ImageView Y;
    public boolean Z;
    public boolean b1;
    public boolean g1;
    public final Lazy h1;
    public boolean k0;
    public final c k1;
    public boolean p0;
    public final String[] p1;
    public final Lazy v1;
    public final Lazy x1;
    public ObricFloatingTitleBar z;

    public static final class a {
    }

    public static final class b {
        public final View a;
        public final List<BottomFadeImageView> b;
        public final FrameLayout c;
        public final ObricDoraGOnboardingTopicView d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "VideoQueryViews(root=" + this.a + ", sceneLayers=" + this.b + ", videoLayer=" + this.c + ", topicView=" + this.d + ')';
        }

        public b(View r2, List<BottomFadeImageView> r3, FrameLayout r4, ObricDoraGOnboardingTopicView r5) {
            Intrinsics.checkNotNullParameter(r2, "root");
            Intrinsics.checkNotNullParameter(r3, "sceneLayers");
            Intrinsics.checkNotNullParameter(r4, "videoLayer");
            Intrinsics.checkNotNullParameter(r5, "topicView");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class c implements nf9.b {
        public final /* synthetic */ ObricDoraGOnboardingWelcomeStateFragment a;

        public final void b(String r2, MessageListState r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r4, "msgList");
        }

        public final void d(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void f(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void onMessageListReplaced(String r2, List<Message> r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "oldMsgList");
            Intrinsics.checkNotNullParameter(r4, "newMsgList");
        }

        public c(ObricDoraGOnboardingWelcomeStateFragment r1) {
            this.a = r1;
        }

        public final void a(String r3, Message r4) {
            Intrinsics.checkNotNullParameter(r3, "cid");
            Intrinsics.checkNotNullParameter(r4, "msg");
            StringBuilder r5 = new StringBuilder("click stop onSendMessage, ");
            ObricDoraGOnboardingWelcomeStateFragment r0 = this.a;
            int r1 = ObricDoraGOnboardingWelcomeStateFragment.y1;
            r0.getClass();
            r5.append(ObricDoraGOnboardingWelcomeStateFragment.Ca0(r4));
            g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", r5.toString());
            this.a.hb0(r4);
        }

        public final void c(String r2, Message r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
            StringBuilder r5 = new StringBuilder("click stop onUpdateMessage, ");
            ObricDoraGOnboardingWelcomeStateFragment r6 = this.a;
            int r0 = ObricDoraGOnboardingWelcomeStateFragment.y1;
            r6.getClass();
            r5.append(ObricDoraGOnboardingWelcomeStateFragment.Ca0(r3));
            g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", r5.toString());
            ObricDoraGOnboardingWelcomeStateFragment.za0(this.a, r3);
        }

        public final void e(String r2, Message r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
            StringBuilder r5 = new StringBuilder("click stop onReceiveMessage, ");
            ObricDoraGOnboardingWelcomeStateFragment r6 = this.a;
            int r0 = ObricDoraGOnboardingWelcomeStateFragment.y1;
            r6.getClass();
            r5.append(ObricDoraGOnboardingWelcomeStateFragment.Ca0(r3));
            g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", r5.toString());
            ObricDoraGOnboardingWelcomeStateFragment.za0(this.a, r3);
        }
    }

    static {
    }

    public final void Ha0() {
        jb0(null);
        this.M++;
        gb0();
        ObricDoraGOnboardingWelcomeStateFragment$registerClickStopAsrResultListener$1 r1 = this.P0;
        if (r1 == null) goto L5;
        m69.a r3 = m69.a.a;
        Intrinsics.checkNotNullParameter(r1, "listener");
        m69.a.b.remove(r1);
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", "unregisterClickStopAsrResultListener");
    L5:
        this.P0 = null;
        MarkdownTextView r2 = this.W;
        if (r2 == null) goto L8;
        r2.setText("");
    L8:
        db0();
        eb0();
        DoraTextViewWithAnim r4 = this.V;
        if (r4 == null) goto L11;
        r4.y();
    L11:
        View r5 = this.T;
        if (r5 == null) goto L16;
        ViewPropertyAnimator r6 = r5.animate();
        if (r6 == null) goto L16;
        r6.cancel();
    L16:
        View r7 = this.X;
        if (r7 == null) goto L21;
        ViewPropertyAnimator r8 = r7.animate();
        if (r8 == null) goto L21;
        r8.cancel();
    L21:
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = false;
        this.k0 = false;
        this.p0 = false;
        this.g1 = true;
        ObricDoraGOnboardingFragmentV2Binding r0 = this.r;
        if (r0 == null) goto L28;
        ConstraintLayout r9 = r0.a;
        if (r9 == null) goto L28;
        FrameLayout r10 = (FrameLayout) r9.findViewById(2131381170);
        if (r10 == null) goto L28;
        com.larus.utils.e1.o(r10);
    L28:
        Ma0(true);
    }

    public final void Ja0() {
        jb0(null);
        this.N++;
        ObricDoraGOnboardingFragmentV2Binding r0 = this.r;
        if (r0 == null) goto L9;
        ConstraintLayout r1 = r0.a;
        if (r1 == null) goto L9;
        FrameLayout r2 = (FrameLayout) r1.findViewById(2131381205);
        if (r2 == null) goto L9;
        com.larus.utils.e1.o(r2);
    L9:
        Ma0(true);
    }

    public final void Ka0() {
        jb0(null);
        this.O++;
        ObricDoraGOnboardingFragmentV2Binding r0 = this.r;
        if (r0 == null) goto L9;
        ConstraintLayout r1 = r0.a;
        if (r1 == null) goto L9;
        FrameLayout r2 = (FrameLayout) r1.findViewById(2131381208);
        if (r2 == null) goto L9;
        com.larus.utils.e1.o(r2);
    L9:
        Ma0(true);
    }

    public final void La0() {
        jb0(null);
        this.P++;
        ObricDoraGOnboardingFragmentV2Binding r0 = this.r;
        if (r0 == null) goto L9;
        ConstraintLayout r1 = r0.a;
        if (r1 == null) goto L9;
        FrameLayout r2 = (FrameLayout) r1.findViewById(2131381233);
        if (r2 == null) goto L9;
        com.larus.utils.e1.o(r2);
    L9:
        Ma0(true);
    }

    public final void Na0() {
        jb0(null);
        this.L++;
        r1 r1 = this.L0;
        if (r1 == null) goto L5;
        m69.a r3 = m69.a.a;
        Intrinsics.checkNotNullParameter(r1, "listener");
        m69.a.b.remove(r1);
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", "unregisterVideoQueryAsrResultListener");
    L5:
        this.L0 = null;
        Ba0();
        b r0 = this.R;
        if (r0 == null) goto L10;
        ObricDoraGOnboardingTopicView r2 = r0.d;
        if (r2 == null) goto L10;
        r2.setAutoScrollEnabled(true);
    L10:
        b r4 = this.R;
        if (r4 == null) goto L15;
        ObricDoraGOnboardingTopicView r5 = r4.d;
        if (r5 == null) goto L15;
        r5.s();
    L15:
        b r6 = this.R;
        if (r6 == null) goto L20;
        ObricDoraGOnboardingTopicView r7 = r6.d;
        if (r7 == null) goto L20;
        r7.e();
    L20:
        b r8 = this.R;
        if (r8 == null) goto L25;
        View r9 = r8.a;
        if (r9 == null) goto L25;
        com.larus.utils.e1.o(r9);
    L25:
        Ma0(true);
    }

    public final void gb0() {
        this.b1 = false;
        String r0 = this.V0;
        if (r0 != null) goto L5;
        return;
    L5:
        com.larus.im.d.e().unregisterOnMessageChangedObserver(r0, this.k1);
        this.V0 = null;
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", "unregisterClickStopMessageObserver, conversationId=".concat(r0));
    }

    public final void Ba0() {
        b r0 = this.R;
        if (r0 == null) goto L10;
        List<BottomFadeImageView> r1 = r0.b;
        if (r1 == null) goto L12;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        ((BottomFadeImageView) r2.next()).animate().cancel();
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public final void Ia0() {
        this.Q++;
        ObricDoraGOnboardingFragmentV2Binding r0 = this.r;
        if (r0 == null) goto L9;
        ConstraintLayout r1 = r0.a;
        if (r1 == null) goto L9;
        FrameLayout r2 = (FrameLayout) r1.findViewById(2131381192);
        if (r2 == null) goto L9;
        com.larus.utils.e1.o(r2);
    L9:
        Ma0(false);
    }

    public final void Qa0() {
        if (this.p0 == false) goto L8;
        View r0 = this.X;
        if (r0 == null) goto L10;
        r0.setAlpha(1.0f);
        r0.setTranslationY(0.0f);
        com.larus.utils.e1.x(r0);
        return;
    L10:
        return;
    L8:
        this.p0 = true;
        Ra0(this.X);
    }

    public final void Sa0() {
        if (this.Z == false) goto L8;
        View r0 = this.T;
        if (r0 == null) goto L10;
        r0.setAlpha(1.0f);
        r0.setTranslationY(0.0f);
        com.larus.utils.e1.x(r0);
        return;
    L10:
        return;
    L8:
        this.Z = true;
        Ra0(this.T);
    }

    public final FrameLayout Za0() {
        ObricDoraGOnboardingFragmentV2Binding r0 = this.r;
        if (r0 == null) goto L7;
        ConstraintLayout r1 = r0.a;
        if (r1 == null) goto L7;
        return (FrameLayout) r1.findViewById(2131381245);
    L7:
        return null;
    }

    public final void ab0() {
        View r0 = this.X;
        if (r0 == null) goto L5;
        com.larus.utils.e1.x(r0);
    L5:
        Qa0();
        ImageView r1 = this.Y;
        if (r1 == null) goto L13;
        r1.setVisibility(0);
        Object r2 = r1.getDrawable();
        if ((r2 instanceof Animatable) == false) goto L10;
        Animatable r3 = (Animatable) r2;
    L11:
        if (r3 == null) goto L13;
        r3.start();
        goto L13
    L10:
        r3 = null;
    L13:
        MarkdownTextView r4 = this.W;
        if (r4 == null) goto L16;
        r4.setText("");
    L16:
        MarkdownTextView r5 = this.W;
        if (r5 == null) goto L20;
        r5.setText("");
        r5.setVisibility(4);
        return;
    }

    public final void bb0() {
        StringBuilder r0 = new StringBuilder("showDirectDiaryState, currentState=");
        p r1 = pa0();
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getClass().getSimpleName();
    L6:
        r0.append(r3);
        r0.append(", argumentSummary=");
        Bundle r4 = getArguments();
        if (r4 == null) goto L9;
        r2 = Ea0(r4);
    L9:
        r0.append(r2);
        r0.append(", bindingReady=");
        if (this.r == null) goto L12;
        boolean r5 = true;
    L13:
        r0.append(r5);
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", r0.toString());
        if ((pa0() instanceof r) == false) goto L16;
        return;
    L16:
        fb0();
        r r6 = new r(this, this.r, ga0());
        r6.b();
        va0(r6);
        return;
    L12:
        r5 = false;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public final void db0() {
        ImageView r0 = this.U;
        if (r0 == null) goto L12;
        Object r1 = r0.getDrawable();
        if ((r1 instanceof Animatable) == false) goto L7;
        Animatable r2 = (Animatable) r1;
    L8:
        if (r2 == null) goto L10;
        r2.stop();
    L10:
        r0.setVisibility(8);
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void eb0() {
        ImageView r0 = this.Y;
        if (r0 == null) goto L12;
        Object r1 = r0.getDrawable();
        if ((r1 instanceof Animatable) == false) goto L7;
        Animatable r2 = (Animatable) r1;
    L8:
        if (r2 == null) goto L10;
        r2.stop();
    L10:
        r0.setVisibility(8);
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void fb0() {
        this.J++;
        Job r0 = this.K;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.K = null;
        Ma0(false);
    }

    @Override // com.larus.dora.obric.onboarding.ObricDoraGOnboardingUiStateBaseFragment
    public final void onDestroyView() {
        com.obric.oui.dialog.v2.alert.c r0 = this.A;
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
    L21:
        this.A = null;
        Ba0();
        b r3 = this.R;
        if (r3 == null) goto L26;
        ObricDoraGOnboardingTopicView r4 = r3.d;
        if (r4 == null) goto L26;
        r4.s();
    L26:
        b r5 = this.R;
        if (r5 == null) goto L31;
        ObricDoraGOnboardingTopicView r6 = r5.d;
        if (r6 == null) goto L31;
        r6.e();
    L31:
        this.R = null;
        this.S = 0;
        this.J++;
        Job r7 = this.K;
        if (r7 == null) goto L34;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L34:
        this.K = null;
        this.L++;
        this.M++;
        this.N++;
        this.O++;
        this.P++;
        this.Q++;
        this.H++;
        Job r8 = this.G;
        if (r8 == null) goto L37;
        Job.DefaultImpls.cancel$default(r8, null, 1, null);
    L37:
        this.G = null;
        r1 r9 = this.L0;
        if (r9 == null) goto L40;
        m69.a r10 = m69.a.a;
        Intrinsics.checkNotNullParameter(r9, "listener");
        m69.a.b.remove(r9);
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", "unregisterVideoQueryAsrResultListener");
    L40:
        this.L0 = null;
        gb0();
        ObricDoraGOnboardingWelcomeStateFragment$registerClickStopAsrResultListener$1 r11 = this.P0;
        if (r11 == null) goto L43;
        m69.a r12 = m69.a.a;
        Intrinsics.checkNotNullParameter(r11, "listener");
        m69.a.b.remove(r11);
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", "unregisterClickStopAsrResultListener");
    L43:
        this.P0 = null;
        MarkdownTextView r13 = this.W;
        if (r13 == null) goto L46;
        r13.setText("");
    L46:
        db0();
        eb0();
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = false;
        this.k0 = false;
        this.p0 = false;
        this.g1 = true;
        IPlayerController r14 = this.B;
        if (r14 == null) goto L49;
        r14.release();
    L49:
        this.B = null;
        IPlayerController r15 = this.C;
        if (r15 == null) goto L52;
        r15.release();
    L52:
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = false;
        super.onDestroyView();
    }

    public ObricDoraGOnboardingWelcomeStateFragment() {
        this.g1 = true;
        this.h1 = LazyKt.lazy(new e1());
        this.k1 = new c(this);
        this.p1 = new String[]{"obric_vision_query_english", "obric_vision_query_flower", "obric_vision_query_food", "obric_vision_query_cat", "obric_vision_query_building", "obric_vision_query_plant", "obric_vision_query_fridge", "obric_vision_query_noodle_price", "obric_vision_query_clothes", "obric_vision_query_durian", "obric_vision_query_local_life"};
        this.v1 = LazyKt.lazy(new g1());
        this.x1 = LazyKt.lazy(new h1(this));
    }

    public final boolean Pa0() {
        Bundle r0 = getArguments();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        StringBuilder r2 = new StringBuilder("isDirectDiaryEntry=");
        r2.append(r1);
        r2.append(", argumentSummary=");
        Bundle r3 = getArguments();
        if (r3 == null) goto L10;
        String r4 = Ea0(r3);
    L11:
        r2.append(r4);
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", r2.toString());
        return r1;
    L10:
        r4 = null;
        goto L11
    L5:
        if (r0.getBoolean("obric_start_daily") != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void Xa0() {
        FrameLayout r0 = Za0();
        if (r0 != null) goto L5;
        return;
    L5:
        ObricDoraGOnboardingFragmentV2Binding r1 = this.r;
        if (r1 == null) goto L24;
        ViewParent r2 = r1.a;
        if (r2 != null) goto L11;
        return;
    L11:
        if (r0.getParent() != r2) goto L13;
        return;
    L13:
        ViewParent r3 = r0.getParent();
        if ((r3 instanceof ViewGroup) == false) goto L16;
        ViewGroup r4 = (ViewGroup) r3;
    L17:
        if (r4 == null) goto L19;
        r4.removeView(r0);
    L19:
        ViewGroup.LayoutParams r5 = this.I;
        if (r5 != null) goto L22;
        r5 = new ViewGroup.LayoutParams(-1, -1);
    L22:
        r2.addView(r0, 0, r5);
        this.I = null;
        return;
    L16:
        r4 = null;
        goto L17
    }

    public final IPlayerController Ya0() {
        FrameLayout r0 = Za0();
        if (r0 != null) goto L5;
        return null;
    L5:
        IPlayerController r2 = this.B;
        if (r2 != null) goto L9;
        Configuration r3 = new Configuration();
        r3.a = requireContext();
        r3.b = getViewLifecycleOwner();
        r3.c = 1;
        r3.e = true;
        PlayerController r4 = new PlayerController(r3, null);
        this.B = r4;
        r4.attachAlphaView(r0);
        return r4;
    L9:
        return r2;
    }

    public final void cb0() {
        FrameLayout r0 = Za0();
        if (r0 == null) goto L6;
        r0.setAlpha(1.0f);
        com.larus.utils.e1.x(r0);
        return;
    }

    @Override // com.larus.dora.obric.onboarding.ObricDoraGOnboardingUiStateBaseFragment
    public final p xa0() {
        boolean r0 = Pa0();
        StringBuilder r1 = new StringBuilder("uiState, directDiary=");
        r1.append(r0);
        r1.append(", argumentSummary=");
        Bundle r2 = getArguments();
        if (r2 == null) goto L5;
        String r3 = Ea0(r2);
    L6:
        r1.append(r3);
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", r1.toString());
        if (r0 == false) goto L10;
        return new r(this, this.r, ga0());
    L10:
        return new y(this, this.r, ga0());
    L5:
        r3 = null;
        goto L6
    }

    public static String Ca0(Message r2) {
        StringBuilder r0 = new StringBuilder("messageId=");
        r0.append(r2.getMessageId());
        r0.append(", localMessageId=");
        r0.append(r2.getLocalMessageId());
        r0.append(", senderId=");
        r0.append(r2.getSenderId());
        r0.append(", userType=");
        r0.append(r2.getUserType());
        r0.append(", isCurrentAccount=");
        r0.append(Oa0(r2));
        r0.append(", statusLocal=");
        r0.append(r2.getMessageStatusLocal());
        r0.append(", contentType=");
        r0.append(r2.getContentType());
        r0.append(", textLength=");
        String r3 = Fa0(r2);
        if (r3 == null) goto L5;
        int r4 = r3.length();
    L6:
        r0.append(r4);
        return r0.toString();
    L5:
        r4 = 0;
        goto L6
    }

    public static String Fa0(Message r1) {
        if (com.larus.im.bean.message.a.b0(r1) == false) goto L5;
        String r2 = com.larus.im.bean.message.a.B(r1);
    L6:
        if (r2 != null) goto L8;
    L10:
        return null;
    L8:
        if ((!StringsKt.isBlank(r2)) == false) goto L10;
        return r2;
    L5:
        r2 = com.larus.im.bean.message.a.O(r1);
        goto L6
    }

    public static boolean Oa0(Message r3) {
        String r4 = r3.getSenderId();
        if (r4 != null) goto L5;
        return false;
    L5:
        AccountService r1 = AccountService.a;
        if (Intrinsics.areEqual(r4, r1.getUserId()) == false) goto L8;
    L9:
        return true;
    L8:
        if (Intrinsics.areEqual(r4, r1.getSecUserId()) == true) goto L9;
        return false;
    }

    public final Pair<IPlayerController, Boolean> Aa0(String r6) {
        boolean r2 = false;
        if (this.F == true) goto L5;
    L20:
        IPlayerController r7 = Ya0();
        if (r7 == null) goto L26;
        if (r2 == true) goto L25;
        r7.stop();
    L25:
        return TuplesKt.to(r7, Boolean.valueOf(r2));
    L26:
        return null;
    L5:
        if (Intrinsics.areEqual(this.E, r6) == false) goto L20;
        FrameLayout r8 = Za0();
        if (r8 == null) goto L20;
        FrameLayout r0 = this.D;
        if (r0 == null) goto L20;
        IPlayerController r3 = this.C;
        if (r3 == null) goto L20;
        IPlayerController r4 = this.B;
        if (r4 == null) goto L19;
        r4.attachAlphaView(r0);
    L19:
        r3.attachAlphaView(r8);
        this.B = r3;
        this.C = r4;
        this.D = r0;
        this.E = null;
        this.F = false;
        r0.setVisibility(4);
        r8.setVisibility(0);
        r2 = true;
        goto L20
    }

    public final String Ea0(Bundle r3) {
        return "size=" + r3.size();
    }

    public final void Ma0(boolean r3) {
        IPlayerController r0 = this.B;
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        FrameLayout r1 = Za0();
        if (r1 == null) goto L10;
        r1.setAlpha(1.0f);
        if (r3 == true) goto L10;
        com.larus.utils.e1.q(r1);
    L10:
        if (r3 == true) goto L13;
        Xa0();
        return;
    }

    public final void Ra0(View r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        r4.animate().cancel();
        r4.setVisibility(0);
        r4.setAlpha(0.0f);
        Resources r1 = getResources();
        r4.setTranslationY(WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density * 16.0f);
        r4.animate().alpha(1.0f).translationY(0.0f).setDuration(300).setInterpolator(new FastOutSlowInInterpolator()).start();
    }

    public final void Ua0(String r33) {
        MarkdownTextView r2 = this.W;
        if (r2 != null) goto L5;
        return;
    L5:
        gw8.c.a.getClass();
        gw8.c r3 = gw8.c.a.b();
        if (r3 == null) goto L8;
        lw8.l r4 = gw8.c.b.b(r3, r2, r33, true, new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31));
    L9:
        if (r4 == null) goto L11;
        r2.setMarkdown(r4);
        return;
    L11:
        r2.setText(r33);
        return;
    L8:
        r4 = null;
        goto L9
    }

    public final File Wa0(String r17) {
        if (StringsKt.contains$default(r17, "/dark/", false, 2, null) == false) goto L5;
        DoraResourceTheme r0 = DoraResourceTheme.NIGHT;
    L6:
        String r1 = StringsKt.replace$default(StringsKt.replace$default(r17, "/dark/", "/", false, 4, null), "/light/", "/", false, 4, null);
        com.larus.dora.impl.resource.j0 r2 = com.larus.dora.impl.resource.j0.a;
        DoraResourceDeviceType r4 = DoraResourceDeviceType.G2;
        DoraResourceType r5 = DoraResourceType.RAW;
        r2.getClass();
        com.larus.dora.impl.resource.k r3 = com.larus.dora.impl.resource.j0.e(r4, r5, r1, r0);
        if ((r3 instanceof com.larus.dora.impl.resource.k.b) == true) goto L9;
        g49.d.b("ObricDoraGOnboardingWelcomeStateFragment", "onboarding video resource is missing, path=" + r1);
        return null;
    L9:
        return ((com.larus.dora.impl.resource.k.b) r3).a;
    L5:
        r0 = DoraResourceTheme.LIGHT;
        goto L6
    }

    public final void hb0(Message r5) {
        String r0 = Fa0(r5);
        if (r0 != null) goto L6;
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", "ignore click stop user query, empty text, " + Ca0(r5));
        return;
    L6:
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", "update click stop user query, textLength=" + r0.length() + ", " + Ca0(r5));
        ib0(r0, "message");
    }

    public final void jb0(Integer r4) {
        ObricDoraGOnboardingFragmentV2Binding r0 = this.r;
        if (r0 == null) goto L12;
        ConstraintLayout r1 = r0.a;
        if (r1 == null) goto L13;
        AppCompatTextView r2 = (DoraTextViewWithAnim) r1.findViewById(2131381231);
        if (r2 == null) goto L14;
        if (r4 != null) goto L10;
        com.larus.utils.e1.o(r2);
        return;
    L10:
        r2.setText(getString(2131912751, new Object[]{r4}));
        com.larus.utils.e1.x(r2);
        return;
    L14:
        return;
    L13:
        return;
    }

    public static String Va0(String r1, String r2) {
        boolean r0 = v19.h.a;
        if (v19.h.a(null) == true) goto L5;
        return r1;
    L5:
        return r2;
    }

    public static final void za0(ObricDoraGOnboardingWelcomeStateFragment r6, Message r7) {
        r6.getClass();
        boolean r2 = true;
        if (Oa0(r7) == false) goto L5;
    L8:
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", "updateClickStopMessage, isUserQuery=" + r2 + ", " + Ca0(r7));
        if (r2 == false) goto L11;
        r6.hb0(r7);
        return;
    L11:
        String r0 = Fa0(r7);
        if (r0 != null) goto L14;
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", "ignore click stop remote answer, empty text, " + Ca0(r7));
        return;
    L14:
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", "update click stop remote answer, textLength=" + r0.length() + ", " + Ca0(r7));
        View r8 = r6.X;
        if (r8 == null) goto L17;
        com.larus.utils.e1.x(r8);
    L17:
        MarkdownTextView r9 = r6.W;
        if (r9 == null) goto L20;
        r9.setVisibility(0);
    L20:
        r6.eb0();
        r6.Ua0(r0);
        return;
    L5:
        if (r7.getUserType() == 1) goto L8;
        r2 = false;
        goto L8
    }

    public final void Ta0(String r13, Pair<String, String>... r14) {
        ArrayList r0 = new ArrayList(r14.length);
        int r1 = r14.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        Pair<String, String> r3 = r14[r2];
        r0.add(Va0((String) r3.getFirst(), (String) r3.getSecond()));
        r2 = r2 + 1;
        goto L3
    L5:
        List r4 = CollectionsKt.distinct(r0);
        if (r4.isEmpty() == false) goto L8;
        return;
    L8:
        int r5 = this.H + 1;
        this.H = r5;
        Job r15 = this.G;
        if (r15 == null) goto L11;
        Job.DefaultImpls.cancel$default(r15, null, 1, null);
    L11:
        this.G = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ObricDoraGOnboardingWelcomeStateFragment$preloadNextAlphaVideoAssets$1(r4, r5, this, r13, null), 3, null);
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [android.widget.TextView, com.larus.dora.impl.view.DoraTextViewWithAnim] */
    public final void ib0(String r3, String r4) {
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", "updateClickStopUserQueryText, source=" + r4 + ", textLength=" + r3.length());
        ?? r5 = this.V;
        if (r5 == 0) goto L5;
        r5.y();
        r5.setText(r3);
        r5.setVisibility(0);
    L5:
        db0();
        if (this.k0 == false) goto L10;
        View r6 = this.T;
        if (r6 == null) goto L12;
        r6.setAlpha(1.0f);
        r6.setTranslationY(0.0f);
        r6.setVisibility(0);
    L12:
        if (this.g1 == false) goto L15;
        ab0();
        return;
    L15:
        return;
    L10:
        this.k0 = true;
        Ra0(this.T);
        goto L12
    }

    @Override // com.larus.dora.obric.onboarding.ObricDoraGOnboardingUiStateBaseFragment, com.larus.dora.obric.onboarding.ObricDoraGOnboardingBaseFragmentV2, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        StringBuilder r0 = new StringBuilder("onViewCreated, argumentSummary=");
        Bundle r1 = getArguments();
        if (r1 == null) goto L5;
        String r2 = Ea0(r1);
    L6:
        r0.append(r2);
        r0.append(", savedInstanceState=");
        if (r13 == null) goto L9;
        boolean r4 = true;
    L10:
        r0.append(r4);
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", r0.toString());
        super.onViewCreated(r12, r13);
        TextView r14 = this.j;
        if (r14 == null) goto L13;
        com.larus.utils.e1.o(r14);
    L13:
        ObricFloatingTitleBar r15 = (ObricFloatingTitleBar) r12.findViewById(2131368926);
        if (r15 == null) goto L18;
        this.z = r15;
        View.OnClickListener r3 = new n1(this);
        int r5 = ObricFloatingTitleBar.g;
        r15.c.j(-1, r3);
        r15.c.h(2131244127, -1, new u0(this));
        r15.c.getStartButtonGroup().setVisibility(8);
        if ((pa0() instanceof r) == false) goto L18;
        r15.c.Q(false);
    L18:
        Drawable r16 = new ColorDrawable(ContextCompat.getColor(requireContext(), 2131104375));
        com.larus.dora.impl.resource.j0 r6 = com.larus.dora.impl.resource.j0.a;
        Context r7 = requireContext();
        DoraResourceDeviceType r10 = DoraResourceDeviceType.G2;
        Drawable r8 = com.larus.dora.impl.resource.j0.f(r6, r7, r10, "obric_onboarding_bg", null, 24);
        if (r8 == null) goto L22;
        r16 = new LayerDrawable(new Drawable[]{r16, r8});
    L22:
        r12.setBackground(r16);
        SimpleDraweeView r17 = r12.findViewById(2131381188);
        if (r17 == null) goto L26;
        ImageLoaderKt.s(r17, com.larus.dora.impl.resource.j0.g(r6, requireContext(), r10, DoraResourceType.DRAWABLE, "obric_onboarding_service_recommendation_icon"), null);
        return;
    L26:
        return;
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final DataSource Da0(String r2, int r3, boolean r4) {
        File r5 = Wa0(r2);
        if (r5 != null) goto L6;
        return null;
    L6:
        DataSource.DataInfo r0 = new DataSource.DataInfo(r5.getAbsolutePath());
        r0.j = 1;
        r0.c = r3;
        r0.f = 1440;
        r0.g = 1600;
        r0.h = 720;
        r0.i = 1600;
        r0.b(new int[]{0, 0, 720, 1600});
        r0.c(new int[]{720, 0, 720, 1600});
        r0.b = DataSource.ScaleType.ScaleAspectFill;
        DataSource r6 = new DataSource();
        r6.b = r0;
        r6.a();
        r6.g = false;
        r6.d = r4;
        return r6;
    }

    public static final void ya0(ObricDoraGOnboardingWelcomeStateFragment r4, long r5, int r7, final Function0 r8) {
        r4.getClass();
        long r6 = RangesKt.coerceAtLeast(((((long) r7) * 1000) / ((long) 60)) - (SystemClock.uptimeMillis() - r5), 0);
        ObricDoraGOnboardingFragmentV2Binding r9 = r4.r;
        if (r9 == null) goto L8;
        ConstraintLayout r10 = r9.a;
        if (r10 == null) goto L9;
        r10.postDelayed(new a1(r8), r6);
        return;
    L9:
        return;
    }

    public static void Ga0(ObricDoraGOnboardingWelcomeStateFragment r2, String r3, boolean r4, String r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r5 = null;
    L11:
        r2.ua0(r3);
        ObricDoraGOnboardingViewModelV2 r7 = r2.ga0();
        if (r7 == null) goto L14;
        r7.exitOnboarding();
    L14:
        if (r4 == false) goto L16;
        com.bytedance.router.i r8 = SmartRouter.buildRoute(r2.getContext(), "//flow/dora/obric_g_env_observe");
        r8.c.putExtra("mac", r5);
        r8.d();
    L16:
        FragmentActivity r9 = r2.getActivity();
        if (r9 == null) goto L20;
        r9.finish();
        return;
    }
}
