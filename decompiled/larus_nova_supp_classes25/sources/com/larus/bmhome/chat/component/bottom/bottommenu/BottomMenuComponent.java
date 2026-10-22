package com.larus.bmhome.chat.component.bottom.bottommenu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.c9;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.chat.component.bottom.multimodal.g1;
import com.larus.bmhome.view.BottomMenuGridLayout;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common_res.common_ui.databinding.LarusWidgetBottomMenuGridItemBinding;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.common_ui.view.BottomOverlayView;
import com.larus.common_ui.view.BottomOverlayViewAdapterPad;
import com.larus.extension.diversion.api.HostDiversionServiceDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.UploadUiStyle;
import com.larus.platform.model.chat.UploadFilePolicy;
import com.larus.platform.service.x1;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallConfigServiceDelegate;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.skydoves.balloon.Balloon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Þ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0016\u0018\u0000 ¯\u00022\u00060\u0001j\u0002`\u00022\u00020\u00032\u00020\u0004:\u0004¯\u0002°\u0002B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010¥\u0001\u001a\u00020iH\u0016J\u0012\u0010¦\u0001\u001a\u00020i2\u0007\u0010§\u0001\u001a\u00020nH\u0016J\t\u0010¨\u0001\u001a\u00020iH\u0016J\t\u0010©\u0001\u001a\u00020iH\u0016J\t\u0010ª\u0001\u001a\u00020iH\u0016J\t\u0010£\u0001\u001a\u00020iH\u0016J\t\u0010¤\u0001\u001a\u00020iH\u0016J\t\u0010«\u0001\u001a\u00020iH\u0016J\t\u0010¬\u0001\u001a\u00020iH\u0002J\t\u0010\u00ad\u0001\u001a\u00020iH\u0016J\u0018\u0010®\u0001\u001a\u00020i2\r\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00020i0pH\u0016J\t\u0010°\u0001\u001a\u00020iH\u0016J\u0012\u0010±\u0001\u001a\u00020i2\u0007\u0010²\u0001\u001a\u00020\\H\u0016J\u0012\u0010³\u0001\u001a\u00020i2\u0007\u0010´\u0001\u001a\u00020\\H\u0016J\t\u0010µ\u0001\u001a\u00020iH\u0016J\u0012\u0010¶\u0001\u001a\u00020i2\u0007\u0010·\u0001\u001a\u00020\\H\u0016J\u000b\u0010¸\u0001\u001a\u0004\u0018\u00010XH\u0002J\u000b\u0010¹\u0001\u001a\u0004\u0018\u00010hH\u0002J\u000b\u0010º\u0001\u001a\u0004\u0018\u00010ZH\u0002J\u0013\u0010»\u0001\u001a\u00020i2\b\u0010¼\u0001\u001a\u00030½\u0001H\u0002J\u0012\u0010¾\u0001\u001a\u00020i2\u0007\u0010¿\u0001\u001a\u00020\bH\u0002J\u0012\u0010À\u0001\u001a\u00020i2\u0007\u0010Á\u0001\u001a\u00020\bH\u0002J\t\u0010Â\u0001\u001a\u00020iH\u0002J\f\u0010Ã\u0001\u001a\u0005\u0018\u00010Ä\u0001H\u0002J\u0015\u0010Å\u0001\u001a\u00020i2\n\u0010Æ\u0001\u001a\u0005\u0018\u00010Ä\u0001H\u0002J\u0013\u0010Ç\u0001\u001a\u00020i2\b\u0010Æ\u0001\u001a\u00030Ä\u0001H\u0002J\u0014\u0010È\u0001\u001a\u00020i2\t\b\u0002\u0010²\u0001\u001a\u00020\\H\u0002J\u0012\u0010É\u0001\u001a\u00020i2\u0007\u0010Ê\u0001\u001a\u00020\\H\u0002J-\u0010Ë\u0001\u001a\u00020i2\u0007\u0010Ê\u0001\u001a\u00020\\2\u0007\u0010Ì\u0001\u001a\u00020\b2\u0007\u0010Í\u0001\u001a\u00020\b2\u0007\u0010Î\u0001\u001a\u00020\\H\u0002J\u0012\u0010Ï\u0001\u001a\u00020i2\u0007\u0010Ð\u0001\u001a\u00020wH\u0002J\u0012\u0010Ñ\u0001\u001a\u00020i2\u0007\u0010Ê\u0001\u001a\u00020\\H\u0002J\t\u0010Ò\u0001\u001a\u00020iH\u0002J\t\u0010Ó\u0001\u001a\u00020iH\u0002J\t\u0010Ô\u0001\u001a\u00020iH\u0002J\t\u0010Õ\u0001\u001a\u00020iH\u0002J\u0010\u0010Ö\u0001\u001a\t\u0012\u0005\u0012\u00030×\u00010sH\u0002J\t\u0010Ø\u0001\u001a\u00020\\H\u0002J\u001f\u0010Ù\u0001\u001a\u00020\\*\u000b\u0012\u0004\u0012\u00020h\u0018\u00010Ú\u00012\u0007\u0010Û\u0001\u001a\u00020hH\u0002J\u001b\u0010Ü\u0001\u001a\u00020\b2\u0007\u0010Ý\u0001\u001a\u00020\b2\u0007\u0010Þ\u0001\u001a\u00020\bH\u0002J!\u0010ß\u0001\u001a\n\u0012\u0005\u0012\u00030×\u00010à\u00012\u000e\u0010á\u0001\u001a\t\u0012\u0005\u0012\u00030×\u00010sH\u0002J\t\u0010â\u0001\u001a\u00020\\H\u0002J\u0012\u0010ã\u0001\u001a\u00020i2\u0007\u0010§\u0001\u001a\u00020nH\u0002J$\u0010ä\u0001\u001a\u00020i2\u0007\u0010§\u0001\u001a\u00020n2\u0007\u0010å\u0001\u001a\u00020n2\u0007\u0010æ\u0001\u001a\u00020\\H\u0002J\u0013\u0010ç\u0001\u001a\u00020i2\b\u0010è\u0001\u001a\u00030é\u0001H\u0016J\t\u0010ê\u0001\u001a\u00020iH\u0002J\t\u0010ë\u0001\u001a\u00020iH\u0002J\t\u0010ì\u0001\u001a\u00020iH\u0002J*\u0010í\u0001\u001a\u00020i2\u0007\u0010î\u0001\u001a\u00020h2\u0007\u0010ï\u0001\u001a\u00020\\2\r\u0010ð\u0001\u001a\b\u0012\u0004\u0012\u00020i0pH\u0002J\u0012\u0010ñ\u0001\u001a\u00020i2\u0007\u0010ò\u0001\u001a\u00020ZH\u0002J\u0013\u0010ó\u0001\u001a\u00020i2\b\u0010ô\u0001\u001a\u00030õ\u0001H\u0002J\t\u0010ö\u0001\u001a\u00020iH\u0002J\t\u0010÷\u0001\u001a\u00020iH\u0002J\t\u0010ø\u0001\u001a\u00020iH\u0002J\b\u0010q\u001a\u00020\\H\u0016J\t\u0010ù\u0001\u001a\u00020\\H\u0016J\u0016\u0010ú\u0001\u001a\u0004\u0018\u00010n2\t\u0010û\u0001\u001a\u0004\u0018\u00010nH\u0016J\u0016\u0010ü\u0001\u001a\u0004\u0018\u00010n2\t\u0010û\u0001\u001a\u0004\u0018\u00010nH\u0016J\u0016\u0010ý\u0001\u001a\u00020i2\u000b\b\u0002\u0010þ\u0001\u001a\u0004\u0018\u00010JH\u0002J\u0012\u0010ÿ\u0001\u001a\u00020\\2\u0007\u0010§\u0001\u001a\u00020nH\u0002J\u001d\u0010\u0080\u0002\u001a\u00020i2\u0007\u0010\u0081\u0002\u001a\u00020n2\t\u0010\u0082\u0002\u001a\u0004\u0018\u00010JH\u0002J\u0015\u0010\u0083\u0002\u001a\u00020i2\n\u0010\u0084\u0002\u001a\u0005\u0018\u00010\u0085\u0002H\u0016J\u001e\u0010\u0086\u0002\u001a\u00020i2\u0013\u0010\u0087\u0002\u001a\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020i0gH\u0016J\u001a\u0010\u0088\u0002\u001a\u00020i2\t\u0010\u0089\u0002\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0003\u0010\u008a\u0002J\u001a\u0010\u008b\u0002\u001a\u00020i2\t\u0010\u008c\u0002\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0003\u0010\u008a\u0002JT\u0010\u008d\u0002\u001a\u00020i2I\u0010\u0087\u0002\u001aD\u0012\u0004\u0012\u00020n\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020n0à\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u008f\u00020à\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0090\u00020à\u0001\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020i0\u008e\u0002H\u0016J\u0012\u0010\u0091\u0002\u001a\u00020i2\u0007\u0010\u0092\u0002\u001a\u00020tH\u0016J\u0012\u0010\u0093\u0002\u001a\u00020i2\u0007\u0010\u0092\u0002\u001a\u00020tH\u0016J\t\u0010\u0094\u0002\u001a\u00020iH\u0016J\u001d\u0010\u0095\u0002\u001a\u00020i2\u0007\u0010Ê\u0001\u001a\u00020\\2\t\b\u0002\u0010\u0096\u0002\u001a\u00020\bH\u0002J\u001b\u0010\u0098\u0002\u001a\u00020i2\u0007\u0010Ê\u0001\u001a\u00020\\2\u0007\u0010\u0096\u0002\u001a\u00020\bH\u0016J\t\u0010\u0099\u0002\u001a\u00020iH\u0002J\u0012\u0010\u009a\u0002\u001a\u00020i2\u0007\u0010\u008c\u0002\u001a\u00020\bH\u0002J*\u0010\u009b\u0002\u001a\u00020i2\u001f\u0010\u009c\u0002\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020h\u0012\u0005\u0012\u00030\u0093\u0001\u0018\u00010\u0092\u0001\u0018\u00010pH\u0016J\u0019\u0010\u009d\u0002\u001a\u0012\u0012\u0004\u0012\u00020h\u0012\u0005\u0012\u00030\u0093\u0001\u0018\u00010\u0092\u0001H\u0016J\t\u0010\u009e\u0002\u001a\u00020iH\u0016J\t\u0010\u009f\u0002\u001a\u00020iH\u0016J\t\u0010 \u0002\u001a\u00020iH\u0016J\u001b\u0010¡\u0002\u001a\u00020i2\u0007\u0010¢\u0002\u001a\u00020\\2\u0007\u0010£\u0002\u001a\u00020hH\u0016J\u000b\u0010¤\u0002\u001a\u0004\u0018\u00010JH\u0016J\u0012\u0010¥\u0002\u001a\u00020i2\u0007\u0010¦\u0002\u001a\u00020\\H\u0016J\t\u0010§\u0002\u001a\u00020\\H\u0016J$\u0010¨\u0002\u001a\u00020i2\u0007\u0010Ê\u0001\u001a\u00020\\2\u0007\u0010£\u0002\u001a\u00020\b2\u0007\u0010©\u0002\u001a\u00020\bH\u0016J7\u0010ª\u0002\u001a\u00020i2\u0007\u0010Ê\u0001\u001a\u00020\\2\u0007\u0010£\u0002\u001a\u00020\b2\u0007\u0010©\u0002\u001a\u00020\b2\u0007\u0010Ì\u0001\u001a\u00020\b2\b\u0010«\u0002\u001a\u00030¬\u0002H\u0016J-\u0010\u00ad\u0002\u001a\u00020i2\u0007\u0010Ê\u0001\u001a\u00020\\2\u0007\u0010£\u0002\u001a\u00020\b2\u0007\u0010©\u0002\u001a\u00020\b2\u0007\u0010®\u0002\u001a\u00020\\H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b#\u0010$R\u001d\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0012\u001a\u0004\b(\u0010)R\u001d\u0010+\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0012\u001a\u0004\b-\u0010.R\u001d\u00100\u001a\u0004\u0018\u0001018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0012\u001a\u0004\b2\u00103R\u001d\u00105\u001a\u0004\u0018\u0001068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0012\u001a\u0004\b7\u00108R\u001d\u0010:\u001a\u0004\u0018\u00010;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0012\u001a\u0004\b<\u0010=R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u0012\u001a\u0004\bA\u0010BR\u001d\u0010D\u001a\u0004\u0018\u00010E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u0012\u001a\u0004\bF\u0010GR\u001d\u0010I\u001a\u0004\u0018\u00010J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0012\u001a\u0004\bK\u0010LR\u001d\u0010N\u001a\u0004\u0018\u00010E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0012\u001a\u0004\bO\u0010GR\u001d\u0010Q\u001a\u0004\u0018\u00010R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u0012\u001a\u0004\bS\u0010TR\u0016\u0010V\u001a\n\u0012\u0004\u0012\u00020X\u0018\u00010WX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Y\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010WX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010`\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0004\n\u0002\u0010aR\u000e\u0010b\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010h\u0012\u0004\u0012\u00020i\u0018\u00010gX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010j\u001a\u0016\u0012\u0004\u0012\u00020h\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020i\u0018\u00010kX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010m\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010n\u0012\u0004\u0012\u00020i\u0018\u00010gX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010o\u001a\n\u0012\u0004\u0012\u00020i\u0018\u00010pX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010r\u001a\b\u0012\u0004\u0012\u00020t0sX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010v\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010x\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010yR\u0012\u0010z\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010yR\u000e\u0010{\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010~\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u007f\u0010\nR\u0016\u0010\u0080\u0001\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010\nR\u0016\u0010\u0082\u0001\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010\nR\"\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0088\u0001\u0010\u0012\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\"\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008d\u0001\u0010\u0012\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0011\u0010\u008e\u0001\u001a\u0004\u0018\u00010nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0090\u0001\u001a\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020i0gX\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010\u0091\u0001\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020h\u0012\u0005\u0012\u00030\u0093\u0001\u0018\u00010\u0092\u0001\u0018\u00010pX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0094\u0001\u001a\u00020\\8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0097\u0001\u0010\u0012\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001f\u0010\u0098\u0001\u001a\u00020\\8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009a\u0001\u0010\u0012\u001a\u0006\b\u0099\u0001\u0010\u0096\u0001R\u001f\u0010\u009b\u0001\u001a\u00020\\8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009d\u0001\u0010\u0012\u001a\u0006\b\u009c\u0001\u0010\u0096\u0001R \u0010\u009e\u0001\u001a\u00030\u009f\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¢\u0001\u0010\u0012\u001a\u0006\b \u0001\u0010¡\u0001R\u000f\u0010£\u0001\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¤\u0001\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0097\u0002\u001a\u00020\\X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006±\u0002"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/bottommenu/BottomMenuComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalPanelAbility;", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "multimodalInputAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "chatListAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListAbility$delegate", "fastSendImageAbility", "Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "getFastSendImageAbility", "()Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "fastSendImageAbility$delegate", "chatClickTalkAbility", "Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "getChatClickTalkAbility", "()Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "chatClickTalkAbility$delegate", "referenceMsgAbility", "Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "getReferenceMsgAbility", "()Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "referenceMsgAbility$delegate", "uploadUiStyle", "Lcom/larus/platform/model/UploadUiStyle;", "getUploadUiStyle", "()Lcom/larus/platform/model/UploadUiStyle;", "uploadUiStyle$delegate", "bottomMenuGridLayout", "Lcom/larus/bmhome/view/BottomMenuGridLayout;", "getBottomMenuGridLayout", "()Lcom/larus/bmhome/view/BottomMenuGridLayout;", "bottomMenuGridLayout$delegate", "bottomLayout", "Landroid/view/ViewGroup;", "getBottomLayout", "()Landroid/view/ViewGroup;", "bottomLayout$delegate", "bottomMenu", "getBottomMenu", "bottomMenu$delegate", "root", "Lcom/larus/bmhome/view/ChatConstraintLayout;", "getRoot", "()Lcom/larus/bmhome/view/ChatConstraintLayout;", "root$delegate", "onConversationIdOrTypeChanged", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility$ChangeListener;", "Lcom/larus/im/bean/conversation/Conversation;", "onBotModelChanged", "Lcom/larus/im/bean/bot/BotModel;", "readyToShowBottomMenu", "", "intendToShowBottomMenu", "isRealtimeCallEnabled", "isRealtimeCallDowngrade", "isRealtimeCallShouldShow", "Ljava/lang/Boolean;", "mCameraVisible", "mAlbumVisible", "mFileVisible", "bottomMenuViewCreated", "cameraClickAction", "Lkotlin/Function1;", "", "", "albumClickAction", "Lkotlin/Function2;", "Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalBizScene;", "fileClickAction", "Landroid/view/View;", "voiceCallClickAction", "Lkotlin/Function0;", "isBottomMenuShow", "panelItemProcessors", "", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalPanelAbility$PanelItemConfigProcessor;", "disableBottomMenuExpandAnimator", "lastExternalPanelHeightAnimationState", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/BottomMenuComponent$ExternalPanelHeightAnimationState;", "bottomAlbumPeekHeightLimit", "Ljava/lang/Integer;", "imeWrapperHeight", "forceHideFileBrowser", "forceHideVoiceCall", "forceHideBottomAlbum", "bottomAlbumSpaceHeight", "getBottomAlbumSpaceHeight", "bottomMenuGridHeight", "getBottomMenuGridHeight", "bottomMenuTotalHeight", "getBottomMenuTotalHeight", "chatBottomCombineAbility", "Lcom/obric/assistant/ability/chat/bottom/IObricChatBottomAbility;", "getChatBottomCombineAbility", "()Lcom/obric/assistant/ability/chat/bottom/IObricChatBottomAbility;", "chatBottomCombineAbility$delegate", "inputBottomMenuContainerAbility", "Lcom/larus/bmhome/ability/IInputBottomMenuContainerAbility;", "getInputBottomMenuContainerAbility", "()Lcom/larus/bmhome/ability/IInputBottomMenuContainerAbility;", "inputBottomMenuContainerAbility$delegate", "bottomViewOverMenuAndSheet", "bottomAttachRootView", "bottomMenuListener", "bottomMenuEventExtProvider", "", "", "enableClickItemShowDownloadDialog", "getEnableClickItemShowDownloadDialog", "()Z", "enableClickItemShowDownloadDialog$delegate", "enableFileClickShowDownloadDialog", "getEnableFileClickShowDownloadDialog", "enableFileClickShowDownloadDialog$delegate", "enableRealtimeCallShowDownloadDialog", "getEnableRealtimeCallShowDownloadDialog", "enableRealtimeCallShowDownloadDialog$delegate", "inputBottomAlbumHeightConfig", "Lcom/larus/platform/model/chat/InputBottomAlbumHeightConfig;", "getInputBottomAlbumHeightConfig", "()Lcom/larus/platform/model/chat/InputBottomAlbumHeightConfig;", "inputBottomAlbumHeightConfig$delegate", "banBottomMenuEnterAnim", "banBottomChildMenuGoneAnim", "onAttach", "onViewCreated", "view", "onResume", "onFragmentViewDestroyed", "onDestroy", "autoOpenMenuEntrance", "refreshAudioDowngradeWhenResume", "hideBottomMenuWhenShowAlbum", "tryDirectOpenBottomMenu", "showAction", "updateAllMenuEnable", "callShowBottomMenu", "animate", "callHideBottomMenu", "showAnimator", "updateAttachmentMenuDisable", "setAudioBtnEnabled", "enabled", "getConversation", "getConversationId", "currentBot", "setParentTrackNode", "node", "Lcom/ixigua/lib/track/ITrackNode;", "updateBottomMenuHeight", "h", "notifyBottomMenuHeightChanged", "curHeight", "updateBottomMenuArea", "bottomMenuConfig", "Lcom/larus/bmhome/input/config/BottomMenuConfig;", "applySlotVisibility", "config", "applyBottomMenuConfig", "animOpenBottomMenu", "startDummyAnimator", "isShow", "updateBottomAlbumPeekHeightByExternalPanel", "current", "target", "isAnimEnd", "applyExternalPanelHeightAnimationState", "state", "startAnimator", "observerConversationChanged", "observerBotChanged", "setupBottomMenu", "rebuildBottomMenuItems", "buildDefaultPanelItems", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalPanelAbility$PanelItemConfig;", "hideAlbumEntranceInInjectedPhotoPicker", "isItemAllowed", "", "itemId", "resolveBottomMenuIcon", "attrRes", "fallbackRes", "applyProcessors", "", "items", "resolveRealtimeCallVisible", "selectDriveFile", "showNormalDriveSelectBalloon", "wrappedView", "shouldUseLayoutRtl", "selectFileForMention", "type", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/MentionFilePickerType;", "selectLocalFile", "selectChatFile", "syncUploadFileRuntimePolicy", "checkInterceptors", "scene", "showDialog", "onPassCheck", "cvsReadyLiveDataForLiveBot", "bot", "updateBottomMenu", "editPos", "Lcom/larus/platform/model/EditPos;", "openMenuEntranceIfReady", "setReadyToShowBottomMenu", "openMenuEntranceIfNeed", "isMenuHide", "addMaskOnBottomMenuAndBottomSheet", "sheet", "addMaskOnBottomMenuAndBottomSheetAdapterPad", "clearBottomOverlayView", "rootView", "isBottomOverlayView", "removeBottomOverlayView", "overlay", "parentHint", "setBottomMenuBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "setBottomMenuListener", "callback", "setBottomAlbumPeekHeightLimit", "limit", "(Ljava/lang/Integer;)V", "setImeWrapperHeight", "height", "setBottomMenuCallback", "Lkotlin/Function6;", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "registerPanelItemProcessor", "processor", "unregisterPanelItemProcessor", "refreshPanel", "launchBottomMenuAnimator", "holdSpace", "isOnlyMenuHide", "changeBottomMenuStatus", "resetBottomOverlayHeight", "updateBottomOverlayHeight", "setBottomMenuEventExtProvider", "provider", "getBottomMenuEventExt", "hideFileBrowser", "hideVoiceCall", "showVoiceCall", "setForceHideBottomAlbum", "forceHide", "from", "obtainBottomMenuGridView", "setDisableBottomMenuExpandAnimator", "disable", "getDisableBottomMenuExpandAnimator", "onExternalPanelHeightAnimationStart", "to", "onExternalPanelHeightAnimationUpdate", "fraction", "", "onExternalPanelHeightAnimationEnd", "isCanceled", "Companion", "ExternalPanelHeightAnimationState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public class BottomMenuComponent extends BaseContentWidget implements com.larus.bmhome.chat.component.bottom.multimodal.h, f1 {
    public static final /* synthetic */ int x1 = 0;
    public final Lazy A;
    public c1 B;
    public b1 C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public Boolean H;
    public ViewGroup H0;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public Function1<? super Boolean, Unit> L0;
    public b0 M;
    public c0 N;
    public d0 O;
    public e0 P;
    public Function0<? extends Map<String, ? extends Object>> P0;
    public boolean Q;
    public final List<com.larus.bmhome.chat.component.bottom.multimodal.h.b> R;
    public boolean S;
    public b T;
    public Integer U;
    public Integer V;
    public final Lazy V0;
    public boolean W;
    public boolean X;
    public boolean Y;
    public final Lazy Z;
    public final Lazy b1;
    public final Lazy g1;
    public final Lazy h1;
    public final Lazy k0;
    public boolean k1;
    public int m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public View p0;
    public boolean p1;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public boolean v1;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b {
        public final boolean a;
        public final int b;
        public final int c;
        public final boolean d;

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
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = ((((r0 * 31) + this.b) * 31) + this.c) * 31;
            if (this.d == true) goto L11;
            r1 = 1237;
        L11:
            return r2 + r1;
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "ExternalPanelHeightAnimationState(isShow=" + this.a + ", current=" + this.b + ", target=" + this.c + ", isAnimEnd=" + this.d + ')';
        }

        public b(boolean r1, int r2, int r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[UploadUiStyle.values().length];
            r0[UploadUiStyle.LOCAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r0[UploadUiStyle.LOCAL_DRIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[UploadUiStyle.LOCAL_DRIVE_RECENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            a = r0;
            int[] r1 = new int[MentionFilePickerType.values().length];
            r1[MentionFilePickerType.CAMERA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r1[MentionFilePickerType.ALBUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r1[MentionFilePickerType.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            b = r1;
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ BottomMenuComponent a;
        public final /* synthetic */ boolean b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            BottomMenuComponent r3 = this.a;
            int r0 = BottomMenuComponent.x1;
            BottomMenuGridLayout r4 = r3.E3();
            if (r4 == null) goto L6;
            r4.f(this.b);
            return;
        }

        public d(BottomMenuComponent r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e implements Function1<rp8.c, Unit> {
        public final /* synthetic */ BottomMenuComponent a;

        public e(BottomMenuComponent r1) {
            this.a = r1;
        }

        public final Object invoke(Object r3) {
            rp8.c r4 = (t1a.c) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            BottomMenuComponent r0 = this.a;
            int r1 = BottomMenuComponent.x1;
            r0.h3(r4);
            if (r0.L == false) goto L6;
            r0.c4();
        L6:
            return Unit.INSTANCE;
        }
    }

    public static final class f implements Function0<oaa.a> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(oaa.a.class));
        }
    }

    public static final class g implements Function0<va8.h0> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.h0.class));
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.bottommenu.BottomMenuComponent$setAudioBtnEnabled$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.bottommenu.BottomMenuComponent$setAudioBtnEnabled$1", f = "BottomMenuComponent.kt", i = {}, l = {532}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enabled;
        int label;
        final /* synthetic */ BottomMenuComponent this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.bottommenu.BottomMenuComponent$setAudioBtnEnabled$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.bottommenu.BottomMenuComponent$setAudioBtnEnabled$1$1", f = "BottomMenuComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $enabled;
            int label;
            final /* synthetic */ BottomMenuComponent this$0;

            public C00441(boolean r1, BottomMenuComponent r2, Continuation<? super C00441> r3) {
                this.$enabled = r1;
                this.this$0 = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00441(this.$enabled, this.this$0, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r3);
                FLogger.a.i("MultimodalInputWrapper", "updateBottomRealCall: " + this.$enabled);
                BottomMenuComponent r4 = this.this$0;
                int r0 = BottomMenuComponent.x1;
                BottomMenuGridLayout r5 = r4.E3();
                if (r5 == null) goto L8;
                r5.g("realtime_call", this.$enabled);
            L8:
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(boolean r1, BottomMenuComponent r2, Continuation<? super AnonymousClass1> r3) {
            this.$enabled = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$enabled, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            MainCoroutineDispatcher r8 = Dispatchers.getMain();
            C00441 r2 = new C00441(this.$enabled, this.this$0, null);
            this.label = 1;
            if (BuildersKt.withContext(r8, r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public final void A2() {
        this.L = false;
        BottomMenuGridLayout r0 = C3();
        if (r0 == null) goto L5;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        ViewCompat.setWindowInsetsAnimationCallback(r0, null);
    L5:
        p3(this.H0);
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void HN() {
        this.X = true;
        if (this.L == false) goto L6;
        c4();
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void TA() {
        this.W = true;
        this.K = false;
        if (this.L == false) goto L6;
        c4();
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void XM() {
        this.E = true;
        if (this.D == false) goto L10;
        this.E = false;
        ICoreInputAbility r2 = Q3();
        if (r2 == null) goto L9;
        r2.C1(true, false, "");
        return;
    L9:
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void g20() {
        this.p1 = true;
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void sx() {
        this.k1 = true;
    }

    public final int B3() {
        if (this.Y == false) goto L5;
        return 0;
    L5:
        Integer r0 = this.V;
        if (r0 != null) goto L8;
    L11:
        com.larus.bmhome.chat.component.fastsend.e0 r1 = I50();
        if (r1 != null) goto L14;
        return 0;
    L14:
        return r1.ce();
    L8:
        if (r0.intValue() <= 0) goto L11;
        return RangesKt.coerceAtLeast(r0.intValue() - D3(), 0);
    }

    public final BottomMenuGridLayout C3() {
        return (BottomMenuGridLayout) this.z.getValue();
    }

    public final BottomMenuGridLayout E3() {
        return (BottomMenuGridLayout) this.x.getValue();
    }

    public final int G3() {
        Integer r0 = this.V;
        if (r0 != null) goto L5;
    L7:
        int r1 = B3() + D3();
    L8:
        FLogger.a.d("MultimodalInputWrapper", "bottomMenuTotalHeight " + r1 + " (albumSpace=" + B3() + ", grid=" + D3() + ", imeWrapperHeight=" + r0 + ')');
        return r1;
    L5:
        if (r0.intValue() <= 0) goto L7;
        r1 = r0.intValue();
        goto L8
    }

    public final com.larus.bmhome.chat.component.fastsend.e0 I50() {
        return (com.larus.bmhome.chat.component.fastsend.e0) this.t.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void KO() {
        FLogger.a.i("MultimodalInputWrapper", "[setDisableBottomMenuExpandAnimator] disable:true");
        this.S = true;
    }

    public final ICoreInputAbility Q3() {
        return (ICoreInputAbility) this.q.getValue();
    }

    public final boolean V3() {
        return ((Boolean) this.g1.getValue()).booleanValue();
    }

    public final ChatConstraintLayout W3() {
        return (ChatConstraintLayout) this.A.getValue();
    }

    public final void c4() {
        ArrayList r0 = new ArrayList();
        sd8.a r1 = s1a.d.a(this).getAbility(sd8.a.class);
        if (r1 == null) goto L7;
        qy8.a r2 = r1.yu();
        if (r2 == null) goto L7;
        Set r3 = r2.i;
    L9:
        if (this.I == false) goto L11;
        r0.add(new com.larus.bmhome.chat.component.bottom.multimodal.h.a("camera", v19.c.b(2130971947, getContext(), 2131242528), 2131900535, new n(this)));
    L11:
        boolean r4 = false;
        if (this.J == false) goto L22;
        Bundle r5 = f1().b;
        if (r5 != null) goto L16;
    L18:
        boolean r6 = false;
    L19:
        if (r6 == true) goto L22;
        r0.add(new com.larus.bmhome.chat.component.bottom.multimodal.h.a("album", v19.c.b(2130971945, getContext(), 2131242522), 2131908357, new o(this)));
        goto L22
    L16:
        if (r5.getBoolean("inject_input_hide_album_entrance", false) != true) goto L18;
        r6 = true;
    L22:
        if (this.K == false) goto L25;
        r0.add(new com.larus.bmhome.chat.component.bottom.multimodal.h.a("file", v19.c.b(2130971951, getContext(), 2131242547), 2131905683, new p(this)));
    L25:
        if (e4() == true) goto L27;
    L43:
        Iterator r7 = ((ArrayList) this.R).iterator();
        List<com.larus.bmhome.chat.component.bottom.multimodal.h.a> r8 = r0;
    L45:
        if (r7.hasNext() == false) goto L47;
        r8 = ((com.larus.bmhome.chat.component.bottom.multimodal.h.b) r7.next()).a(CollectionsKt.toMutableList(r8));
        goto L45
    L47:
        ArrayList r9 = new ArrayList();
        Iterator r10 = r8.iterator();
    L49:
        if (r10.hasNext() == false) goto L53;
        Object r11 = r10.next();
        if (((com.larus.bmhome.chat.component.bottom.multimodal.h.a) r11).e == false) goto L49;
        r9.add(r11);
        goto L49
    L53:
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r13 = r9.iterator();
    L55:
        if (r13.hasNext() == false) goto L57;
        com.larus.bmhome.chat.component.bottom.multimodal.h.a r14 = (com.larus.bmhome.chat.component.bottom.multimodal.h.a) r13.next();
        r12.add(new com.larus.bmhome.view.k(r14.a, r14.b, r14.c, r14.d, r14.e, r14.f));
        goto L55
    L57:
        BottomMenuGridLayout r15 = E3();
        if (r15 == null) goto L68;
        r15.setItems(r12);
        return;
    L68:
        return;
    L27:
        if (X3(r3, "realtime_call") == false) goto L43;
        if (V3() == true) goto L39;
        VoiceCallConfigServiceDelegate r16 = VoiceCallConfigServiceDelegate.b;
        if (r16.e() == false) goto L39;
        if (com.larus.bmhome.utils.i.f(h()) == false) goto L39;
        if (r16.i() == false) goto L39;
        if (x1.a.a() == true) goto L39;
        r4 = true;
    L39:
        if (r4 == false) goto L41;
        int r17 = v19.c.b(2130971646, getContext(), 2131240874);
    L42:
        r0.add(new com.larus.bmhome.chat.component.bottom.multimodal.h.a("realtime_call", r17, 2131900478, new q(this)));
        goto L43
    L41:
        r17 = v19.c.b(2130971952, getContext(), 2131242552);
    L7:
        r3 = null;
        goto L9
    }

    public final de8.c f1() {
        return (de8.c) this.n.getValue();
    }

    public final void k4() {
        boolean r0 = UploadFilePolicy.a;
        com.larus.bmhome.instruction.g r1 = (com.larus.bmhome.instruction.g) this.p.getValue();
        if (r1 == null) goto L7;
        boolean r2 = true;
        if (r1.yW() != true) goto L7;
    L8:
        UploadFilePolicy.a = r2;
        ICoreInputAbility r3 = Q3();
        if (r3 == null) goto L12;
        r3.Pi();
        return;
    L12:
        return;
    L7:
        r2 = false;
        goto L8
    }

    public final void onDestroy() {
        p3(this.H0);
        com.larus.bmhome.chat.component.cvs.y r0 = u0();
        if (r0 == null) goto L5;
        r0.lQ(this.B);
    L5:
        com.larus.bmhome.chat.component.cvs.y r1 = u0();
        if (r1 == null) goto L9;
        r1.lQ(this.C);
        return;
    }

    public final void onResume() {
        if (this.H != null) goto L6;
        return;
    L6:
        if (V3() == false) goto L9;
        return;
    L9:
        if (z2.a.enableRealtimeCallDowngrade() == false) goto L18;
        boolean r0 = VoiceCallServiceDelegate.a.q("voice_call", "plus_panel", true);
        if (r0 == this.G) goto L15;
        this.G = r0;
        c4();
        return;
    L15:
        return;
    }

    public final com.larus.bmhome.chat.component.cvs.y u0() {
        return (com.larus.bmhome.chat.component.cvs.y) this.o.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final Map<String, Object> wV() {
        Function0<? extends Map<String, ? extends Object>> r0 = this.P0;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (Map) r0.invoke();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.bmhome.chat.component.bottom.multimodal.h.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, f1.class);
        t1a.e r0 = s1a.d.a(this).p(Reflection.getOrCreateKotlinClass(rp8.c.class));
        if (r0 == null) goto L6;
        t1a.e.a.a(r0, false, new e(this));
        return;
    }

    public BottomMenuComponent() {
        this.m = 2131365588;
        this.n = LazyKt.lazy(new l(this));
        this.o = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.bottommenu.c(this));
        this.p = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.bottommenu.d(this));
        this.q = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.bottommenu.e(this));
        this.r = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.bottommenu.f(this));
        this.s = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.bottommenu.g(this));
        this.t = LazyKt.lazy(new h(this));
        this.u = LazyKt.lazy(new i(this));
        this.v = LazyKt.lazy(new j(this));
        this.w = LazyKt.lazy(new k());
        this.x = LazyKt.lazy(new w(this));
        this.y = LazyKt.lazy(new h0(this));
        this.z = LazyKt.lazy(new s0(this));
        this.A = LazyKt.lazy(new w0(this));
        this.F = true;
        this.R = new ArrayList();
        this.Z = LazyKt.lazy(new f(this));
        this.k0 = LazyKt.lazy(new g(this));
        this.L0 = new x0();
        this.V0 = LazyKt.lazy(new y0());
        this.b1 = LazyKt.lazy(new z0());
        this.g1 = LazyKt.lazy(new a1());
        this.h1 = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.bottommenu.b());
    }

    public final int D3() {
        BottomMenuGridLayout r0 = E3();
        if (r0 == null) goto L6;
        return r0.getBottomMenuHeight();
    L6:
        return i5.y0(v19.c.b(2130971155, null, 2131166679));
    }

    public final String H3() {
        com.larus.bmhome.chat.component.cvs.y r0 = u0();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Y1();
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void Ro() {
        com.larus.bmhome.chat.component.fastsend.e0 r0 = I50();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L13;
        ICoreInputAbility r2 = Q3();
        if (r2 == null) goto L14;
        r2.C1(false, true, "");
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r0.bx() != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void Rw() {
        BottomMenuGridLayout r0 = E3();
        if (r0 == null) goto L10;
        Iterator r1 = ((LinkedHashMap) r0.f).entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        Map.Entry r2 = (Map.Entry) r1.next();
        String r3 = (String) r2.getKey();
        LarusWidgetBottomMenuGridItemBinding r4 = (LarusWidgetBottomMenuGridItemBinding) r2.getValue();
        r4.b.setAlpha(1.0f);
        r4.b.setClickable(true);
        Map r5 = r0.g;
        if (r5 == null) goto L6;
        r5.put(r3, Boolean.TRUE);
        goto L6
    L16:
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void SX() {
        de8.c r0 = (de8.c) s1a.d.a(this).a(de8.c.class);
        if (r0 == null) goto L9;
        Bundle r1 = r0.b;
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.getBoolean("arg_hide_plus_panel_call", false) != true) goto L9;
    L10:
        if (r2 == false) goto L12;
        return;
    L12:
        this.X = false;
        if (this.L == false) goto L16;
        c4();
        return;
    L16:
        return;
    L9:
        r2 = false;
        goto L10
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void aJ() {
        BottomMenuGridLayout r0 = C3();
        if (r0 == null) goto L6;
        r0.setBackground(null);
        return;
    }

    public final boolean e4() {
        rp8.c r0 = s1a.d.a(this).a(rp8.c.class);
        if (r0 == null) goto L5;
        boolean r1 = Intrinsics.areEqual(r0.d, Boolean.FALSE);
    L6:
        if (r1 == false) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.H, Boolean.TRUE) == true) goto L10;
        return false;
    L10:
        if (this.G == false) goto L12;
        return false;
    L12:
        if (this.X == true) goto L18;
        return true;
    L18:
        return false;
    L5:
        r1 = false;
        goto L6
    }

    public final wc9.e h() {
        com.larus.bmhome.chat.component.cvs.y r0 = u0();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h();
    }

    public final void h4() {
        ICoreInputAbility r0 = Q3();
        if (r0 == null) goto L5;
        boolean r1 = r0.wy();
    L6:
        com.larus.bmhome.chat.component.bottom.multimodal.g r2 = r5();
        if (r2 == null) goto L10;
        com.larus.bmhome.chat.component.bottom.multimodal.f1.c r4 = new com.larus.bmhome.chat.component.bottom.multimodal.f1.c(r1, 5);
        g1 r5 = new g1(true, MultimodalBizScene.ChatInputFile, false);
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("upload_file_click_from", "plus_panel");
        Unit r3 = Unit.INSTANCE;
        r2.n90(new com.larus.bmhome.chat.component.bottom.multimodal.e1(r4, r5, null, r7, 4));
        return;
    L10:
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final BottomMenuGridLayout jJ() {
        return E3();
    }

    public final com.larus.bmhome.chat.component.bottom.multimodal.g r5() {
        return s1a.d.a(this).getAbility(com.larus.bmhome.chat.component.bottom.multimodal.g.class);
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void rJ() {
        BottomMenuGridLayout r0 = E3();
        if (r0 == null) goto L5;
        r0.g("camera", false);
    L5:
        BottomMenuGridLayout r1 = E3();
        if (r1 == null) goto L8;
        r1.g("album", false);
    L8:
        BottomMenuGridLayout r2 = E3();
        if (r2 == null) goto L12;
        r2.g("file", false);
        return;
    }

    public final BotModel z3() {
        com.larus.bmhome.chat.component.cvs.y r0 = u0();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j0();
    }

    public int U2() {
        return this.m;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.h
    public final void d6() {
        c4();
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final boolean lt() {
        return this.v1;
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final boolean sL() {
        return this.Q;
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void B50(com.larus.common.venue.impl.venue.component.d r1) {
        this.P0 = r1;
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final BottomOverlayViewAdapterPad J60(View r19) {
        if (r19 == null) goto L5;
        View r1 = r19.getRootView();
    L7:
        if ((r1 instanceof ViewGroup) == false) goto L9;
        ViewGroup r2 = (ViewGroup) r1;
    L10:
        if (r2 != null) goto L12;
        r2 = this.H0;
    L12:
        p3(r2);
        BottomMenuGridLayout r6 = C3();
        if (r6 != null) goto L16;
        return null;
    L16:
        if (this.Q == false) goto L45;
        if (r19 == null) goto L45;
        CoordinatorLayout r3 = r19.getParent();
        if ((r3 instanceof CoordinatorLayout) == false) goto L22;
        CoordinatorLayout r4 = r3;
    L23:
        if (r4 != null) goto L25;
        return null;
    L25:
        View r12 = new BottomOverlayViewAdapterPad(getContext(), null, 6, 0);
        Intrinsics.checkNotNullParameter(r6, "menu");
        Intrinsics.checkNotNullParameter(r19, "sheet");
        Intrinsics.checkNotNullParameter(r4, "coordinator");
        ((BottomOverlayViewAdapterPad) r12).a = 0.0f;
        ((BottomOverlayViewAdapterPad) r12).b = 0.0f;
        ((BottomOverlayViewAdapterPad) r12).c = null;
        ((BottomOverlayViewAdapterPad) r12).d = false;
        ((BottomOverlayViewAdapterPad) r12).e = false;
        r12.a();
        ((BottomOverlayViewAdapterPad) r12).f = r6;
        ((BottomOverlayViewAdapterPad) r12).g = r19;
        ((BottomOverlayViewAdapterPad) r12).h = r4;
        ((BottomOverlayViewAdapterPad) r12).i = true;
        ((BottomOverlayViewAdapterPad) r12).j = false;
        ((BottomOverlayViewAdapterPad) r12).k = null;
        r6.addOnLayoutChangeListener(((BottomOverlayViewAdapterPad) r12).l);
        View r5 = ((BottomOverlayViewAdapterPad) r12).g;
        if (r5 == null) goto L28;
        r5.addOnLayoutChangeListener(((BottomOverlayViewAdapterPad) r12).l);
    L28:
        CoordinatorLayout r7 = ((BottomOverlayViewAdapterPad) r12).h;
        if (r7 == null) goto L31;
        r7.addOnLayoutChangeListener(((BottomOverlayViewAdapterPad) r12).l);
    L31:
        Rect r8 = new Rect();
        Rect r9 = new Rect();
        Rect r10 = new Rect();
        Rect r11 = new Rect();
        r6.getGlobalVisibleRect(r8);
        r19.getGlobalVisibleRect(r9);
        r4.getGlobalVisibleRect(r11);
        r12.e(r8, r9, r10);
        int r13 = r8.width();
        int r14 = r10.width();
        int r15 = Math.abs(r8.left - r9.left);
        FLogger r16 = FLogger.a;
        r16.i("BottomOverlayViewAdapterPad", "initCover menuRect:" + r8 + " sheetRect:" + r9 + " coverRect:" + r10 + " menuW:" + r13 + " coverW:" + r14 + " gap:" + r15);
        if (r13 > 0) goto L34;
    L36:
        r12.d();
        r12.setBackgroundColor(0);
        r12.setOnTouchListener(new com.larus.common_ui.view.f(r12, r9, r4, r8, r6, r11, r19, r10));
        this.p0 = r12;
        View r17 = r19.getRootView();
        if ((r17 instanceof ViewGroup) == false) goto L39;
        ViewGroup r18 = (ViewGroup) r17;
    L40:
        this.H0 = r18;
        if (r18 == null) goto L43;
        r18.addView(r12);
    L43:
        return r12;
    L39:
        r18 = null;
        goto L40
    L34:
        if (r14 <= (r13 * 1.5f)) goto L36;
        r16.e("BottomOverlayViewAdapterPad", "cover_width_abnormal menuRect:" + r8 + " sheetRect:" + r9 + " coverRect:" + r10 + " menuW:" + r13 + " coverW:" + r14);
        goto L36
    L22:
        r4 = null;
    L45:
        return null;
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void Jz(MentionFilePickerType r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        int r4 = c.b[r3.ordinal()];
        if (r4 != 1) goto L5;
        b0 r5 = this.M;
        if (r5 == null) goto L24;
        r5.invoke("attach_menu");
        return;
    L24:
        return;
    L5:
        if (r4 != 2) goto L7;
        c0 r6 = this.N;
        if (r6 == null) goto L22;
        r6.invoke("addition_menu", MultimodalBizScene.ChatAttachmentPanelMoreAlbum);
        return;
    L22:
        return;
    L7:
        if (r4 != 3) goto L12;
        d0 r7 = this.O;
        if (r7 == null) goto L20;
        r7.invoke(null);
        return;
    L20:
        return;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void NL(boolean r11) {
        FLogger r0 = FLogger.a;
        r0.d("MultimodalInputWrapper", "callHideBottomMenu showAnimator=" + r11);
        com.larus.bmhome.chat.component.fastsend.e0 r1 = I50();
        if (r1 == null) goto L6;
        r1.W20("callHideBottomMenu");
    L6:
        if (r11 == true) goto L54;
        va8.o r12 = (va8.o) this.r.getValue();
        if (r12 != null) goto L10;
    L12:
        boolean r13 = false;
    L13:
        StringBuilder r5 = new StringBuilder("hideBottomMenu isImeShowing:");
        r5.append(r13);
        r5.append(", bottomMenuTotalHeight:");
        r5.append(c7.d(Integer.valueOf(G3())));
        r5.append(", curPaddingBottom:");
        ChatConstraintLayout r6 = W3();
        if (r6 == null) goto L16;
        Float r7 = Float.valueOf(c7.d(Integer.valueOf(r6.getPaddingBottom())));
    L17:
        r5.append(r7);
        r0.i("MultimodalInputWrapper", r5.toString());
        if (r13 == true) goto L20;
    L51:
        l4(0);
        BottomMenuGridLayout r14 = C3();
        if (r14 == null) goto L55;
        r14.setAlpha(1.0f);
    L55:
        this.Q = false;
        va8.o r15 = (va8.o) this.r.getValue();
        if (r15 == null) goto L58;
        r15.lj();
    L58:
        this.L0.invoke(Boolean.valueOf(this.Q));
        oaa.a r16 = (oaa.a) this.Z.getValue();
        if (r16 == null) goto L61;
        r16.F3(this.Q);
    L61:
        com.larus.bmhome.instruction.g r17 = (com.larus.bmhome.instruction.g) this.p.getValue();
        if (r17 == null) goto L64;
        r17.vW(true);
    L64:
        p3(this.H0);
        if (this.v1 == false) goto L68;
        c4();
        this.v1 = false;
        return;
    L68:
        return;
    L20:
        if (((com.larus.platform.model.chat.w) this.h1.getValue()).c() == false) goto L24;
        ChatConstraintLayout r18 = W3();
        if (r18 == null) goto L27;
        int r19 = r18.getActualBottomPadding();
    L28:
        int r8 = G3();
        if (this.v1 == false) goto L31;
        r8 = B3();
    L31:
        int r9 = r19 + r8;
        if (com.larus.platform.exp.g.a() == true) goto L34;
    L48:
        r0.d("MultimodalInputWrapper", "hideBottomMenu rootBottomPadding=" + r9 + " bottomPadding=" + r19 + " bottomMenuActualHeight=" + r8 + " isOnlyMenuHide=" + this.v1);
        ChatConstraintLayout r110 = W3();
        if (r110 == null) goto L51;
        r110.C6(r9, "callHideBottomMenu");
        goto L51
    L34:
        if (((com.larus.platform.model.chat.w) this.h1.getValue()).a() == false) goto L48;
        ChatConstraintLayout r10 = W3();
        if (r10 == null) goto L48;
        WindowInsetsCompat r20 = ViewCompat.getRootWindowInsets(r10);
        if (r20 == null) goto L48;
        Insets r21 = r20.getInsets(WindowInsetsCompat.Type.ime());
        if (r21 == null) goto L48;
        int r22 = r21.bottom;
        if (r22 <= 0) goto L48;
        if (r9 >= r22) goto L48;
        if (r10.getDisableBottomPadding() == true) goto L48;
        r0.i("MultimodalInputWrapper", "rootBottomPadding " + r9 + " reset to " + r21.bottom);
        r9 = r21.bottom;
    L27:
        r19 = 0;
        goto L28
    L24:
        ChatConstraintLayout r111 = W3();
        if (r111 == null) goto L27;
        r19 = r111.getBottomPadding();
        goto L28
    L16:
        r7 = null;
        goto L17
    L10:
        if (r12.w() != true) goto L12;
        r13 = true;
        goto L13
    L54:
        r0.i("MultimodalInputWrapper", "hideBottomMenu startAnimator");
        j4(false);
        goto L55
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void U00(Integer r3) {
        if (r3 != null) goto L5;
    L10:
        r3 = null;
    L11:
        this.V = r3;
        if (r3 == null) goto L17;
        this.U = Integer.valueOf(B3());
        com.larus.bmhome.chat.component.fastsend.e0 r4 = I50();
        if (r4 == null) goto L18;
        r4.kh(B3());
        return;
    L18:
        return;
    L17:
        return;
    L5:
        if (r3.intValue() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
    L7:
        r1 = false;
        goto L8
    }

    public void X2(int r1) {
        this.m = r1;
    }

    public final void Y2(b r4) {
        if (this.S == true) goto L6;
        return;
    L6:
        if (r4.a == true) goto L8;
        return;
    L8:
        int r0 = r4.b - D3();
        boolean r1 = false;
        int r2 = RangesKt.coerceAtLeast(r0, 0);
        Integer r3 = this.U;
        if (r3 == null) goto L12;
        r2 = RangesKt.coerceAtMost(r2, r3.intValue());
    L12:
        if (r4.d == true) goto L17;
        int r5 = r4.c;
        if (r5 > 0) goto L16;
    L18:
        com.larus.bmhome.chat.component.fastsend.e0 r6 = I50();
        if (r6 == null) goto L22;
        r6.k6(r2, r1);
        return;
    L22:
        return;
    L16:
        if (r4.b < r5) goto L18;
    L17:
        r1 = true;
        goto L18
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void Yj(com.larus.bmhome.double_post.drag_panel.m r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.L0 = r2;
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final BottomOverlayView Yp(View r8) {
        ViewGroup r0 = null;
        if (r8 == null) goto L5;
        View r1 = r8.getRootView();
    L7:
        if ((r1 instanceof ViewGroup) == false) goto L9;
        ViewGroup r2 = (ViewGroup) r1;
    L10:
        if (r2 != null) goto L12;
        r2 = this.H0;
    L12:
        p3(r2);
        BottomMenuGridLayout r3 = C3();
        if (r3 != null) goto L16;
        return null;
    L16:
        if (this.Q == false) goto L32;
        if (r8 == null) goto L32;
        CoordinatorLayout r4 = r8.getParent();
        if ((r4 instanceof CoordinatorLayout) == false) goto L22;
        CoordinatorLayout r5 = r4;
    L23:
        if (r5 != null) goto L25;
        return null;
    L25:
        BottomOverlayView r6 = new BottomOverlayView(getContext(), null, 6, 0);
        r6.a(r3, r8, r5);
        this.p0 = r6;
        View r9 = r8.getRootView();
        if ((r9 instanceof ViewGroup) == false) goto L28;
        r0 = (ViewGroup) r9;
    L28:
        this.H0 = r0;
        if (r0 == null) goto L31;
        r0.addView(r6);
    L31:
        return r6;
    L22:
        r5 = null;
    L32:
        return null;
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public final void a4(int r3) {
        int r0 = G3();
        oaa.a r1 = (oaa.a) this.Z.getValue();
        if (r1 == null) goto L5;
        r1.L(r3, r0);
    L5:
        va8.h0 r2 = (va8.h0) this.k0.getValue();
        if (r2 == null) goto L9;
        r2.sy(r3, r0);
        return;
    }

    public final void h3(rp8.c r9) {
        ICoreInputAbility r0 = Q3();
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = r0.Qd(false);
    L6:
        ICoreInputAbility r3 = Q3();
        if (r3 == null) goto L9;
        boolean r4 = r3.CD(false);
    L10:
        sd8.a r5 = s1a.d.a(this).getAbility(sd8.a.class);
        Boolean r6 = null;
        if (r5 == null) goto L15;
        qy8.a r7 = r5.yu();
        if (r7 == null) goto L15;
        Set r8 = r7.i;
    L16:
        int r10 = c9.a;
        if (r9 == null) goto L19;
        Boolean r11 = r9.a;
    L21:
        if ((!X3(r8, "camera")) == true) goto L27;
        if (r11 == null) goto L24;
        boolean r12 = r11.booleanValue();
    L25:
        if (r12 == false) goto L27;
        boolean r13 = true;
    L28:
        this.I = r13;
        if (r9 == null) goto L31;
        Boolean r14 = r9.b;
    L33:
        if ((!X3(r8, "album")) == true) goto L38;
        if (r14 == null) goto L36;
        r2 = r14.booleanValue();
    L36:
        if (r2 == false) goto L38;
        boolean r15 = true;
    L39:
        this.J = r15;
        if (r9 == null) goto L43;
        r6 = r9.c;
    L43:
        if (this.W == false) goto L45;
    L48:
        boolean r16 = true;
    L49:
        if (r16 == true) goto L54;
        if (r6 == null) goto L52;
        r4 = r6.booleanValue();
    L52:
        if (r4 == false) goto L54;
        r1 = true;
    L54:
        this.K = r1;
        return;
    L45:
        if (X3(r8, "file") == false) goto L48;
        r16 = false;
    L38:
        r15 = false;
        goto L39
    L31:
        r14 = null;
        goto L33
    L24:
        r12 = r2;
    L27:
        r13 = false;
        goto L28
    L19:
        r11 = null;
    L15:
        r8 = null;
        goto L16
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void hP(boolean r11) {
        com.larus.bmhome.chat.component.fastsend.e0 r0 = I50();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        by7.e r3 = null;
        if (r1 == true) goto L15;
        oaa.a r2 = (oaa.a) this.Z.getValue();
        if (r2 == null) goto L13;
        r2.fs();
        boolean r4 = true;
    L14:
        if (r4 == true) goto L15;
    L23:
        va8.o r5 = (va8.o) this.r.getValue();
        if (r5 != null) goto L26;
    L28:
        boolean r6 = false;
    L29:
        Integer r7 = this.V;
        if (r7 != null) goto L32;
    L36:
        FLogger r8 = FLogger.a;
        StringBuilder r9 = new StringBuilder("callShowBottomMenu, bottomMenuTotalHeight:");
        r9.append(G3());
        r9.append(" curPaddingBottom:");
        ChatConstraintLayout r10 = W3();
        if (r10 == null) goto L39;
        Integer r12 = Integer.valueOf(r10.getPaddingBottom());
    L40:
        r9.append(r12);
        r9.append(" showIme=");
        r9.append(r6);
        r8.i("MultimodalInputWrapper", r9.toString());
        if (r6 == false) goto L74;
        BottomMenuGridLayout r13 = E3();
        if (r13 == null) goto L45;
        r13.setAlpha(1.0f);
    L45:
        l4(G3());
        StringBuilder r14 = new StringBuilder("callShowBottomMenu, bottomMenuTotalHeight:");
        r14.append(c7.d(Integer.valueOf(G3())));
        r14.append(", curPaddingBottom:");
        ChatConstraintLayout r15 = W3();
        if (r15 == null) goto L48;
        Float r16 = Float.valueOf(c7.d(Integer.valueOf(r15.getPaddingBottom())));
    L49:
        r14.append(r16);
        r8.i("MultimodalInputWrapper", r14.toString());
        ChatConstraintLayout r17 = W3();
        if (r17 == null) goto L56;
        ChatConstraintLayout r18 = W3();
        if (r18 == null) goto L54;
        int r19 = r18.getBottomPadding();
    L55:
        r17.C6(r19 - G3(), "callShowBottomMenu");
        goto L56
    L54:
        r19 = 0;
    L56:
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isDetached() == false) goto L60;
        return;
    L60:
        if (this.Y == true) goto L64;
        com.larus.bmhome.chat.component.fastsend.e0 r110 = I50();
        if (r110 == null) goto L67;
        r110.G90(false);
    L67:
        ICoreInputAbility r111 = Q3();
        if (r111 == null) goto L70;
        r111.qp(false);
    L70:
        ChatConstraintLayout r112 = W3();
        if (r112 == null) goto L101;
        r112.postDelayed(new com.larus.bmhome.chat.component.bottom.bottommenu.a(this), 50);
    L101:
        h3((rp8.c) s1a.d.a(this).a(rp8.c.class));
        c4();
        if (e4() == false) goto L119;
        BottomMenuGridLayout r113 = E3();
        if (r113 == null) goto L108;
        Intrinsics.checkNotNullParameter("realtime_call", "itemId");
        if (r113.f.containsKey("realtime_call") != true) goto L108;
        boolean r114 = true;
    L109:
        if (r114 == false) goto L119;
        LruCache r115 = ko8.a.a;
        BottomMenuGridLayout r116 = E3();
        if (r116 == null) goto L113;
        r3 = by7.h.b(r116);
    L113:
        BotModel r117 = z3();
        if (r117 == null) goto L117;
        String r118 = r117.getBotId();
        if (r118 == null) goto L117;
    L118:
        Intrinsics.checkNotNullParameter("bottom_menu", "position");
        Intrinsics.checkNotNullParameter(r118, "botId");
        IAIChatControlTraceService.a.Ra("bottom_menu", false, r3, r118);
    L117:
        r118 = "";
    L108:
        r114 = false;
    L119:
        this.Q = true;
        va8.o r119 = (va8.o) this.r.getValue();
        if (r119 == null) goto L122;
        r119.lj();
    L122:
        this.L0.invoke(Boolean.valueOf(this.Q));
        oaa.a r120 = (oaa.a) this.Z.getValue();
        if (r120 == null) goto L125;
        r120.F3(this.Q);
    L125:
        com.larus.bmhome.instruction.g r121 = (com.larus.bmhome.instruction.g) this.p.getValue();
        if (r121 == null) goto L129;
        r121.vW(true);
        return;
    L129:
        return;
    L64:
        com.larus.bmhome.chat.component.fastsend.e0 r122 = I50();
        if (r122 == null) goto L67;
        r122.Wi("forceHideBottomAlbum");
        goto L67
    L48:
        r16 = null;
        goto L49
    L74:
        if (this.Y == true) goto L78;
        com.larus.bmhome.chat.component.fastsend.e0 r20 = I50();
        if (r20 == null) goto L81;
        r20.G90(true);
    L81:
        if (r11 == false) goto L101;
        if (this.S == false) goto L100;
        int r123 = G3();
        if (this.S == false) goto L101;
        BottomMenuGridLayout r21 = C3();
        if (r21 == null) goto L94;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
        if (r22 == null) goto L93;
        r22.height = r123;
        r21.setLayoutParams(r22);
        goto L94
    L93:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L94:
        a4(r123);
        b r124 = this.T;
        if (r124 == null) goto L97;
        Y2(r124);
    L97:
        BottomMenuGridLayout r125 = C3();
        if (r125 == null) goto L101;
        r125.setAlpha(1.0f);
        goto L101
    L100:
        j4(true);
        goto L101
    L78:
        com.larus.bmhome.chat.component.fastsend.e0 r23 = I50();
        if (r23 == null) goto L81;
        r23.Wi("forceHideBottomAlbum");
        goto L81
    L39:
        r12 = null;
        goto L40
    L32:
        if (r7.intValue() <= 0) goto L36;
        com.larus.bmhome.chat.component.fastsend.e0 r24 = I50();
        if (r24 == null) goto L36;
        r24.kh(B3());
        goto L36
    L26:
        if (r5.w() != true) goto L28;
        r6 = true;
        goto L29
    L13:
        r4 = false;
    L15:
        BottomMenuGridLayout r25 = E3();
        if (r25 == null) goto L23;
        if (r25.a == true) goto L23;
        r25.a = true;
        r25.setPadding(r25.getResources().getDimensionPixelSize(v19.c.b(2130971546, null, 2131167462)), r25.getResources().getDimensionPixelSize(v19.c.b(2130971254, null, 2131166879)), r25.getResources().getDimensionPixelSize(v19.c.b(2130971546, null, 2131167462)), r25.getResources().getDimensionPixelSize(v19.c.b(2130971186, null, 2131166742)));
        r25.a();
        if (r25.d == null) goto L23;
        r25.d();
        goto L23
    L5:
        if (r0.xX() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void j4(boolean r13) {
        if (r13 == false) goto L4;
        long r0 = 300;
    L5:
        final long r5 = r0;
        if (r13 == false) goto L8;
        int r1 = 0;
    L9:
        if (r13 == false) goto L11;
        int r2 = G3();
    L13:
        if (r13 == false) goto L15;
        final float r7 = 0.0f;
    L16:
        if (r13 == false) goto L18;
        final float r8 = 1.0f;
    L19:
        final Interpolator r9 = PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
        final ValueAnimator r3 = ValueAnimator.ofInt(new int[]{r1, r2});
        r3.setDuration(r5);
        r3.setInterpolator(r9);
        r3.addUpdateListener(new t(this));
        FLogger.a.w("MultimodalInputWrapper", "startAnimator: " + r13 + ", height:" + r1 + "->" + r2);
        if (this.k1 == false) goto L28;
        if (r13 == true) goto L25;
        BottomMenuGridLayout r14 = E3();
        if (r14 == null) goto L32;
        r14.postDelayed(new u(r3, this, r5, r7, r8, r9), 50);
        return;
    L32:
        return;
    L25:
        BottomMenuGridLayout r15 = C3();
        if (r15 == null) goto L34;
        r15.setAlpha(1.0f);
        return;
    L34:
        return;
    L28:
        BottomMenuGridLayout r16 = E3();
        if (r16 == null) goto L36;
        r16.postDelayed(new v(r3, this, r5, r7, r8, r9), 50);
        return;
    L36:
        return;
    L18:
        r8 = 0.0f;
        goto L19
    L15:
        r7 = 1.0f;
        goto L16
    L11:
        r2 = 0;
        goto L13
    L8:
        r1 = G3();
        goto L9
    L4:
        r0 = 200;
        goto L5
    }

    public final void l4(int r4) {
        FLogger.a.i("MultimodalInputWrapper", "updateBottomMenuHeight: " + r4);
        a4(r4);
        BottomMenuGridLayout r0 = C3();
        if (r0 == null) goto L9;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L8;
        r1.height = r4;
        r0.setLayoutParams(r1);
        r0.requestLayout();
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void nQ(boolean r3) {
        Intrinsics.checkNotNullParameter("clarification", "from");
        this.Y = r3;
        if (r3 == false) goto L8;
        com.larus.bmhome.chat.component.fastsend.e0 r4 = I50();
        if (r4 == null) goto L9;
        r4.Wi("clarification");
        return;
    L9:
        return;
    }

    public final void onViewCreated(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.L = true;
        Intrinsics.checkNotNullParameter(this, "<this>");
        by7.e r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if ((r0 instanceof by7.e) == false) goto L5;
        by7.e r1 = r0;
    L6:
        if (r1 == null) goto L10;
        ViewGroup r2 = (ViewGroup) this.y.getValue();
        if (r2 == null) goto L10;
        r2.setTag(2131377847, r1);
    L10:
        this.B = new c1(this);
        com.larus.bmhome.chat.component.cvs.y r3 = u0();
        if (r3 == null) goto L13;
        r3.rh(new x(), this.B);
    L13:
        this.C = new b1(this);
        com.larus.bmhome.chat.component.cvs.y r4 = u0();
        if (r4 == null) goto L16;
        r4.ll(new s(), this.C);
    L16:
        BottomMenuGridLayout r6 = C3();
        if (r6 == null) goto L19;
        ViewExtKt.n(r6, null, null, new r(this), 1);
    L19:
        de8.c r7 = (de8.c) s1a.d.a(this).a(de8.c.class);
        boolean r8 = false;
        if (r7 == null) goto L26;
        Bundle r9 = r7.b;
        if (r9 == null) goto L26;
        if (r9.getBoolean("arg_hide_plus_panel_call", false) != true) goto L26;
        r8 = true;
    L26:
        if (r8 == false) goto L28;
        this.X = true;
    L28:
        oaa.a r10 = (oaa.a) this.Z.getValue();
        if (r10 == null) goto L32;
        r10.ma();
        return;
    L32:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void p3(ViewGroup r6) {
        View r0 = this.p0;
        this.p0 = null;
        this.H0 = null;
        if (r0 == null) goto L5;
        d4(r0, r6);
    L5:
        if (r6 == null) goto L20;
        int r1 = r6.getChildCount() - 1;
    L8:
        if ((-1) >= r1) goto L25;
        View r3 = r6.getChildAt(r1);
        Intrinsics.checkNotNull(r3);
        if ((r3 instanceof BottomOverlayView) == false) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == false) goto L19;
        if (r3 == r0) goto L19;
        d4(r3, r6);
    L19:
        r1 = r1 - 1;
        goto L8
    L12:
        if ((r3 instanceof BottomOverlayViewAdapterPad) == true) goto L15;
        r4 = false;
        goto L16
    L25:
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.h
    public final void q80(com.larus.bmhome.chat.component.bottom.multimodal.h.b r2) {
        Intrinsics.checkNotNullParameter(r2, "processor");
        ((ArrayList) this.R).remove(r2);
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void setAudioBtnEnabled(boolean r7) {
        this.F = r7;     // Catch: Exception -> L6
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass1(r7, this, null), 2, null);     // Catch: Exception -> L6
        ICoreInputAbility r0 = Q3();     // Catch: Exception -> L6
        if (r0 == null) goto L11;
        r0.gX(r7);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        FLogger.a.e("MultimodalInputWrapper", "updateBottomRealCall exception: " + e);
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void t00(Function6<? super View, ? super List<? extends View>, ? super List<? extends ImageView>, ? super List<? extends TextView>, ? super Boolean, ? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        BottomMenuGridLayout r0 = E3();
        if (r0 == null) goto L6;
        r0.setCallback(r2);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void v80(com.larus.bmhome.chat.component.bottom.core.e r2) {
        Intrinsics.checkNotNullParameter(r2, "showAction");
        r2.invoke();
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void vo(Integer r1) {
        this.U = r1;
    }

    @Override // com.larus.bmhome.chat.component.bottom.multimodal.h
    public final void xp(com.larus.bmhome.chat.component.bottom.multimodal.h.b r2) {
        Intrinsics.checkNotNullParameter(r2, "processor");
        if (((ArrayList) this.R).contains(r2) == true) goto L6;
        ((ArrayList) this.R).add(r2);
        return;
    }

    public static boolean X3(Set r0, String r1) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.contains(r1) == true) goto L7;
        return false;
    }

    public static void d4(final View r2, ViewGroup r3) {
        r2.setVisibility(8);
        ViewParent r0 = r2.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 == null) goto L9;
        r3 = r1;
    L9:
        if (r3 == null) goto L13;
        boolean r4 = true;
        if (r3.isAttachedToWindow() != true) goto L13;
    L14:
        if (r4 == false) goto L16;
        r3.post(new m(r2));
        return;
    L16:
        if (r3 == null) goto L20;
        r3.removeView(r2);
        return;
    L20:
        return;
    L13:
        r4 = false;
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void Vx(boolean r4, int r5) {
        FLogger.a.i("MultimodalInputWrapper", "changeBottomMenuStatus, isShow: " + r4 + ", holdSpace: " + r5);
        if (r4 == false) goto L16;
        Z3(true, r5);
        this.v1 = false;
        BottomOverlayView r6 = this.p0;
        if ((r6 instanceof BottomOverlayView) == false) goto L14;
        BottomOverlayView r7 = r6;
        int r8 = r7.c;
        if (r8 < 0) goto L34;
        ViewGroup.LayoutParams r0 = r7.getLayoutParams();
        if (r0 == null) goto L12;
        r0.height = r8;
    L12:
        r7.requestLayout();
        return;
    L34:
        return;
    L14:
        if ((r6 instanceof BottomOverlayViewAdapterPad) == false) goto L30;
        BottomOverlayViewAdapterPad r9 = (BottomOverlayViewAdapterPad) r6;
        r9.k = null;
        r9.d();
        return;
    L30:
        return;
    L16:
        Z3(false, r5);
        this.v1 = true;
        BottomOverlayView r10 = this.p0;
        if ((r10 instanceof BottomOverlayView) == false) goto L23;
        BottomOverlayView r11 = r10;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L21;
        r12.height = 0;
    L21:
        r11.requestLayout();
        return;
    L23:
        if ((r10 instanceof BottomOverlayViewAdapterPad) == false) goto L33;
        BottomOverlayViewAdapterPad r13 = (BottomOverlayViewAdapterPad) r10;
        r13.k = 0;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 != null) goto L27;
        r14 = new ViewGroup.LayoutParams(r13.getWidth(), 0);
    L27:
        r14.height = 0;
        r13.setLayoutParams(r14);
        r13.requestLayout();
        return;
    }

    public final void Z3(boolean r18, int r19) {
        int r3 = com.larus.utils.u.b(s1a.a.getActivity(this));
        com.larus.bmhome.chat.component.fastsend.e0 r4 = I50();
        if (r4 == null) goto L5;
        int r5 = r4.rw();
    L6:
        int r6 = r5 + r19;
        com.larus.bmhome.chat.component.fastsend.e0 r7 = I50();
        int r8 = 0;
        if (r7 == null) goto L13;
        com.larus.platform.api.a0 r9 = r7.WW();
        if (r9 == null) goto L13;
        if (r9.au() != true) goto L13;
        boolean r10 = true;
    L15:
        if (r10 == false) goto L29;
        FLogger.a.w("MultimodalInputWrapper", "album total show, just update bottomMenuHeight, isShow:" + r18 + ", holdSpace:" + r19 + ", navPadding:" + r3 + ", topPadding:" + r19 + ", hiddenHeight:" + r6);
        if (r18 == false) goto L19;
        r6 = G3();
    L19:
        l4(r6);
        BottomMenuGridLayout r2 = C3();
        if (r2 == null) goto L25;
        if (r18 == false) goto L23;
        float r11 = 1.0f;
    L24:
        r2.setAlpha(r11);
        goto L25
    L23:
        r11 = 0.0f;
    L25:
        BottomMenuGridLayout r12 = E3();
        if (r12 == null) goto L51;
        r12.f(r18);
        return;
    L51:
        return;
    L29:
        if (r18 == false) goto L31;
        int r13 = r6;
    L32:
        if (r18 == false) goto L34;
        int r15 = G3();
    L35:
        Interpolator r14 = PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
        ValueAnimator r16 = ValueAnimator.ofInt(new int[]{r13, r15});
        r16.setDuration(250);
        r16.setInterpolator(r14);
        r16.addUpdateListener(new z(this));
        r16.addListener(new d(this, r18));
        r16.start();
        FLogger.a.w("MultimodalInputWrapper", "launchBottomMenuAnimator isShow:" + r18 + ", height:" + r13 + "->" + r15 + ", holdSpace:" + r19 + ", navPadding:" + r3 + ", topPadding:" + r19 + ", hiddenHeight:" + r6);
        final BottomMenuGridLayout r17 = C3();
        if (r17 == null) goto L52;
        if (r18 == false) goto L39;
        final float r20 = 0.0f;
    L40:
        if (r18 == false) goto L42;
        final float r21 = 1.0f;
    L44:
        if (this.p1 == false) goto L48;
        int r1 = r17.getChildCount();
    L46:
        if (r8 >= r1) goto L53;
        r17.getChildAt(r8).setAlpha(r21);
        r8 = r8 + 1;
        goto L46
    L53:
        return;
    L48:
        d2a.b.a(new a0(r17, r20, r21));
        return;
    L42:
        r21 = 0.0f;
        goto L44
    L39:
        r20 = 1.0f;
        goto L40
    L52:
        return;
    L34:
        r15 = r6;
        goto L35
    L31:
        r13 = G3();
    L13:
        r10 = false;
        goto L15
    L5:
        r5 = B3();
        goto L6
    }

    public static void i4(View r9, View r10, boolean r11) {
        Balloon r12 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r9, r10, false, null, null, null, new u0(), 56);
        if (r11 == false) goto L5;
        int r13 = -r9.getMeasuredWidth();
    L6:
        r12.v(r9, r13, i5.Q());
        return;
    L5:
        r13 = r9.getMeasuredWidth();
        goto L6
    }

    public final void m3(String r4, boolean r5, Function0<Unit> r6) {
        FLogger.a.i("MultimodalInputWrapper", "checkInterceptors: " + r4 + ", " + r5);
        if (r5 == false) goto L7;
        HostDiversionServiceDelegate r7 = HostDiversionServiceDelegate.b;
        if (r7 == null) goto L9;
        Context r8 = getContext();
        JSONObject r0 = new JSONObject();
        r0.put("open_window_from", r4);
        Unit r9 = Unit.INSTANCE;
        r7.a(r8, r0);
        return;
    L9:
        return;
    L7:
        r6.invoke();
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void zR(boolean r4, int r5, int r6) {
        FLogger.a.i("MultimodalInputWrapper", "[onExternalPanelHeightAnimationStart] isShow:" + r4 + ", from:" + r5 + ", to:" + r6);
        b r0 = new b(r4, r5, r6, false);
        this.T = r0;
        Y2(r0);
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void tn(boolean r4, int r5, int r6, boolean r7) {
        FLogger.a.i("MultimodalInputWrapper", "[onExternalPanelHeightAnimationEnd] isShow:" + r4 + ", from:" + r5 + ", to:" + r6 + ", isCanceled:" + r7);
        if (r7 == false) goto L5;
        return;
    L5:
        b r8 = new b(r4, r6, r6, true);
        this.T = r8;
        Y2(r8);
    }

    @Override // com.larus.bmhome.chat.component.bottom.bottommenu.f1
    public final void Er(boolean r4, int r5, int r6, int r7, float r8) {
        FLogger.a.d("MultimodalInputWrapper", "[onExternalPanelHeightAnimationUpdate] isShow:" + r4 + ", from:" + r5 + ", to:" + r6 + ", current:" + r7 + ", fraction:" + r8);
        b r9 = new b(r4, r7, r6, false);
        this.T = r9;
        Y2(r9);
    }
}
