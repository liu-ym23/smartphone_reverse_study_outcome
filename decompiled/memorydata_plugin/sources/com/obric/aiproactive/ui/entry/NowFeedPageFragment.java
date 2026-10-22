package com.obric.aiproactive.ui.entry;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.security.obric.guard.ObricSecurityGuardStub;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.transition.ChangeBounds;
import androidx.transition.ChangeTransform;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.google.android.material.appbar.AppBarLayout;
import com.obric.aiagent.product.platform.api.vibratefeedback.FeedbackType;
import com.obric.aiproactive.api.AlgorithmTaskInvokeResult;
import com.obric.aiproactive.api.PageType;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.aiproactive.api.ProactiveRecommendationEnabledStore;
import com.obric.aiproactive.ui.feedback.ProactiveFeedbackSheet;
import com.obric.aiproactive.ui.list.ProactiveListAdapter;
import com.obric.aiproactive.ui.preference.AiRuleActivity;
import com.obric.aiproactive.ui.progress.ProactiveAgentRunActivity;
import com.obric.aiproactive.ui.settings.ProactiveSettingsFragment;
import com.obric.aiproactive.ui.util.ProactiveTopBarIconButton;
import com.obric.aiproactive.ui.voice.AiVoiceSdkAsrBridge;
import com.obric.aiproactive.ui.widget.GradientTextView;
import com.obric.aiproactive.ui.widget.ProactiveAvatarView;
import com.obric.aiproactive.ui.widget.RequirementVoiceOverlayView;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u009b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u001c*\u0001\u0005\u0018\u0000 ¦\u00032\u00020\u0001:\b¦\u0003§\u0003¨\u0003©\u0003B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\H\u0002J\u0013\u0010\u00ad\u0001\u001a\u00020Z2\b\u0010®\u0001\u001a\u00030¯\u0001H\u0016J\u001e\u0010°\u0001\u001a\u00020Z2\u0007\u0010±\u0001\u001a\u00020\\2\n\u0010²\u0001\u001a\u0005\u0018\u00010¯\u0001H\u0016J\t\u0010³\u0001\u001a\u000209H\u0014J\u001b\u0010´\u0001\u001a\u00020\u000e2\u0007\u0010µ\u0001\u001a\u00020\u000e2\u0007\u0010¶\u0001\u001a\u00020\u000eH\u0014J\u001b\u0010·\u0001\u001a\u00020\u000e2\u0007\u0010¸\u0001\u001a\u00020\u000e2\u0007\u0010¹\u0001\u001a\u00020\u000eH\u0014J\t\u0010º\u0001\u001a\u00020ZH\u0016J\u0012\u0010»\u0001\u001a\u00020Z2\u0007\u0010¼\u0001\u001a\u000205H\u0014J+\u0010½\u0001\u001a\u00020Z2\u0007\u0010¾\u0001\u001a\u0002092\u000e\u0010¿\u0001\u001a\t\u0012\u0005\u0012\u00030À\u00010C2\u0007\u0010¼\u0001\u001a\u000205H\u0014J\u0012\u0010Á\u0001\u001a\u00020Z2\u0007\u0010Â\u0001\u001a\u00020DH\u0014J\t\u0010Ã\u0001\u001a\u00020ZH\u0014J\t\u0010Ä\u0001\u001a\u00020ZH\u0016J\t\u0010Å\u0001\u001a\u00020ZH\u0016J\t\u0010Æ\u0001\u001a\u00020ZH\u0016J\t\u0010Ç\u0001\u001a\u00020ZH\u0002J\t\u0010È\u0001\u001a\u00020ZH\u0002J\t\u0010É\u0001\u001a\u00020ZH\u0002J\t\u0010Ê\u0001\u001a\u00020ZH\u0002J\u0012\u0010Ë\u0001\u001a\u00020Z2\u0007\u0010Ì\u0001\u001a\u000209H\u0002J\u001c\u0010Í\u0001\u001a\u0002092\b\u0010Î\u0001\u001a\u00030Ï\u00012\u0007\u0010Ð\u0001\u001a\u000209H\u0002J\t\u0010Ñ\u0001\u001a\u00020ZH\u0002J\u001b\u0010Ò\u0001\u001a\u00020Z2\u0007\u0010Ó\u0001\u001a\u00020r2\u0007\u0010Ô\u0001\u001a\u00020rH\u0002J\u0012\u0010Õ\u0001\u001a\u00020Z2\u0007\u0010Ö\u0001\u001a\u000209H\u0002J\u0013\u0010×\u0001\u001a\u00020Z2\b\u0010Ø\u0001\u001a\u00030\u008c\u0001H\u0002J\u001a\u0010Ù\u0001\u001a\u00020Z2\t\u0010Ú\u0001\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0003\u0010Û\u0001J\u0012\u0010Ü\u0001\u001a\u00020Z2\u0007\u0010Ý\u0001\u001a\u000209H\u0002J\t\u0010Þ\u0001\u001a\u00020ZH\u0002J\t\u0010ß\u0001\u001a\u00020ZH\u0002J\t\u0010à\u0001\u001a\u00020kH\u0002J\u0013\u0010á\u0001\u001a\u00020Z2\b\u0010â\u0001\u001a\u00030\u008c\u0001H\u0002J\t\u0010ã\u0001\u001a\u00020ZH\u0002J\u0013\u0010ä\u0001\u001a\u0002092\b\u0010å\u0001\u001a\u00030æ\u0001H\u0002J\t\u0010ç\u0001\u001a\u00020ZH\u0002J\t\u0010è\u0001\u001a\u00020ZH\u0002J\t\u0010é\u0001\u001a\u00020ZH\u0002J\u0013\u0010ê\u0001\u001a\u00020Z2\b\u0010ë\u0001\u001a\u00030ì\u0001H\u0002J\u001d\u0010í\u0001\u001a\u00020Z2\b\u0010ë\u0001\u001a\u00030ì\u00012\b\u0010î\u0001\u001a\u00030ï\u0001H\u0002J\t\u0010ð\u0001\u001a\u00020ZH\u0002J'\u0010ñ\u0001\u001a\u00020Z2\b\u0010ò\u0001\u001a\u00030ó\u00012\u0007\u0010ô\u0001\u001a\u00020r2\t\b\u0002\u0010õ\u0001\u001a\u000209H\u0002J\u001b\u0010ö\u0001\u001a\u00020Z2\u0007\u0010ô\u0001\u001a\u00020r2\u0007\u0010÷\u0001\u001a\u00020\u000eH\u0002J\t\u0010ø\u0001\u001a\u00020ZH\u0002J$\u0010ù\u0001\u001a\u00020\u000e2\u0007\u0010ú\u0001\u001a\u00020\u000e2\u0007\u0010û\u0001\u001a\u00020\u000e2\u0007\u0010ü\u0001\u001a\u00020rH\u0002J\t\u0010ý\u0001\u001a\u00020ZH\u0002J\u0012\u0010þ\u0001\u001a\u00020Z2\u0007\u0010ÿ\u0001\u001a\u00020\u000eH\u0002J\u0019\u0010\u0080\u0002\u001a\u0002092\u0007\u0010Ó\u0001\u001a\u00020r2\u0007\u0010Ô\u0001\u001a\u00020rJ\u0015\u0010\u0081\u0002\u001a\u00020Z2\n\u0010ò\u0001\u001a\u0005\u0018\u00010ó\u0001H\u0002J\u0012\u0010\u0082\u0002\u001a\u00020Z2\u0007\u0010\u0083\u0002\u001a\u000209H\u0002J\t\u0010\u0084\u0002\u001a\u00020ZH\u0002J\u001b\u0010\u0085\u0002\u001a\u00020Z2\u0007\u0010\u0086\u0002\u001a\u0002092\u0007\u0010\u0087\u0002\u001a\u000209H\u0002J\t\u0010\u0088\u0002\u001a\u00020ZH\u0002J\t\u0010\u0089\u0002\u001a\u00020ZH\u0002J\t\u0010\u008a\u0002\u001a\u00020ZH\u0002J\u0012\u0010\u008b\u0002\u001a\u00020Z2\u0007\u0010\u008c\u0002\u001a\u00020?H\u0002J\t\u0010\u008d\u0002\u001a\u00020ZH\u0002J\t\u0010\u008e\u0002\u001a\u00020ZH\u0002J\u0012\u0010\u008f\u0002\u001a\u00020Z2\u0007\u0010\u0090\u0002\u001a\u000209H\u0002J\u0014\u0010\u0091\u0002\u001a\u00020Z2\t\u0010\u0092\u0002\u001a\u0004\u0018\u00010\\H\u0002J\t\u0010\u0093\u0002\u001a\u00020ZH\u0002J\t\u0010\u0094\u0002\u001a\u00020ZH\u0002J0\u0010\u0095\u0002\u001a\u00020Z2\r\u0010\u0096\u0002\u001a\b\u0012\u0004\u0012\u00020D0C2\r\u0010\u0097\u0002\u001a\b\u0012\u0004\u0012\u00020D0C2\u0007\u0010¼\u0001\u001a\u000205H\u0002J\u0012\u0010\u0098\u0002\u001a\u00020Z2\u0007\u0010Â\u0001\u001a\u00020DH\u0002J\t\u0010\u0099\u0002\u001a\u00020ZH\u0002J0\u0010\u009a\u0002\u001a\u00020Z2\r\u0010\u0097\u0002\u001a\b\u0012\u0004\u0012\u00020D0C2\r\u0010\u0096\u0002\u001a\b\u0012\u0004\u0012\u00020D0C2\u0007\u0010¼\u0001\u001a\u000205H\u0002J\u0018\u0010\u009b\u0002\u001a\u0002092\r\u0010\u0096\u0002\u001a\b\u0012\u0004\u0012\u00020D0CH\u0002J\u0013\u0010\u009c\u0002\u001a\u00020Z2\b\u0010\u009d\u0002\u001a\u00030\u008c\u0001H\u0002J\u001e\u0010\u009e\u0002\u001a\u00020Z2\b\u0010\u009d\u0002\u001a\u00030\u008c\u00012\t\b\u0002\u0010\u009f\u0002\u001a\u000209H\u0002J\t\u0010 \u0002\u001a\u00020ZH\u0002J\t\u0010¡\u0002\u001a\u000207H\u0002J\u0013\u0010¢\u0002\u001a\u00030£\u00022\u0007\u0010¤\u0002\u001a\u000207H\u0002J\u0012\u0010¥\u0002\u001a\u00020Z2\u0007\u0010¤\u0002\u001a\u000207H\u0002J\t\u0010¦\u0002\u001a\u00020ZH\u0002J\t\u0010§\u0002\u001a\u00020ZH\u0002J\t\u0010¨\u0002\u001a\u00020ZH\u0002J\t\u0010©\u0002\u001a\u00020ZH\u0002J\u001b\u0010ª\u0002\u001a\u00020Z2\u0007\u0010\u0083\u0002\u001a\u0002092\u0007\u0010«\u0002\u001a\u000209H\u0002J\t\u0010¬\u0002\u001a\u000209H\u0002J\t\u0010\u00ad\u0002\u001a\u000209H\u0002J(\u0010®\u0002\u001a\u00020Z2\u0007\u0010¯\u0002\u001a\u0002092\t\b\u0002\u0010°\u0002\u001a\u0002092\t\b\u0002\u0010±\u0002\u001a\u000209H\u0002J\t\u0010²\u0002\u001a\u00020ZH\u0002J\t\u0010³\u0002\u001a\u00020ZH\u0002J\u0012\u0010³\u0002\u001a\u00020Z2\u0007\u0010´\u0002\u001a\u00020?H\u0002J\u0013\u0010µ\u0002\u001a\u00020Z2\b\u0010\u009d\u0002\u001a\u00030\u008c\u0001H\u0002J\t\u0010¶\u0002\u001a\u00020ZH\u0002J\t\u0010·\u0002\u001a\u000209H\u0002J\t\u0010¸\u0002\u001a\u000209H\u0002J\u001c\u0010¹\u0002\u001a\u00020Z2\b\u0010\u009d\u0002\u001a\u00030\u008c\u00012\u0007\u0010º\u0002\u001a\u000209H\u0002J%\u0010»\u0002\u001a\u00020Z2\b\u0010\u009d\u0002\u001a\u00030\u008c\u00012\u0007\u0010º\u0002\u001a\u0002092\u0007\u0010¼\u0002\u001a\u00020\u000eH\u0002J\u001c\u0010½\u0002\u001a\u00020Z2\b\u0010\u009d\u0002\u001a\u00030\u008c\u00012\u0007\u0010º\u0002\u001a\u000209H\u0002J\t\u0010¾\u0002\u001a\u000209H\u0002J\n\u0010¿\u0002\u001a\u00030À\u0002H\u0002J\t\u0010Á\u0002\u001a\u000209H\u0002J\t\u0010Â\u0002\u001a\u000209H\u0002J\n\u0010Ã\u0002\u001a\u00030À\u0002H\u0002J\t\u0010Ä\u0002\u001a\u000209H\u0002J\t\u0010Å\u0002\u001a\u000209H\u0002J\t\u0010Æ\u0002\u001a\u00020ZH\u0002J\t\u0010Ç\u0002\u001a\u00020ZH\u0002J\t\u0010È\u0002\u001a\u00020\u000eH\u0002J\u0013\u0010É\u0002\u001a\u00020Z2\b\u0010Ê\u0002\u001a\u00030Ë\u0002H\u0002J\"\u0010Ì\u0002\u001a\u00030Ë\u00022\r\u0010Í\u0002\u001a\b\u0012\u0004\u0012\u00020D0C2\u0007\u0010Î\u0002\u001a\u000209H\u0002J\t\u0010Ï\u0002\u001a\u00020ZH\u0002J\u001b\u0010Ð\u0002\u001a\u00020Z2\u0007\u0010Ñ\u0002\u001a\u00020r2\u0007\u0010Ò\u0002\u001a\u00020rH\u0002J\u0013\u0010Ó\u0002\u001a\u00030Ô\u00022\u0007\u0010Õ\u0002\u001a\u00020rH\u0002J?\u0010Ö\u0002\u001a\u00020Z2\u0007\u0010×\u0002\u001a\u00020r2\u0007\u0010Ø\u0002\u001a\u00020r2\u0007\u0010Ù\u0002\u001a\u00020r2\u0007\u0010Ú\u0002\u001a\u00020r2\u0007\u0010Û\u0002\u001a\u00020r2\u0007\u0010Ü\u0002\u001a\u00020rH\u0002J\t\u0010Ý\u0002\u001a\u00020\u000eH\u0002J\u0012\u0010Þ\u0002\u001a\u00020Z2\u0007\u0010ß\u0002\u001a\u00020rH\u0002J\u0012\u0010à\u0002\u001a\u00020Z2\u0007\u0010á\u0002\u001a\u000209H\u0002J\u0012\u0010â\u0002\u001a\u00020Z2\u0007\u0010¤\u0002\u001a\u000207H\u0002J\u0013\u0010â\u0002\u001a\u00020Z2\b\u0010ã\u0002\u001a\u00030ä\u0002H\u0002J\u0012\u0010å\u0002\u001a\u00020Z2\u0007\u0010æ\u0002\u001a\u000207H\u0002J%\u0010ç\u0002\u001a\u00020Z2\u0007\u0010è\u0002\u001a\u00020\u000e2\u0007\u0010¼\u0001\u001a\u0002052\b\u0010é\u0002\u001a\u00030ê\u0002H\u0014J\t\u0010ë\u0002\u001a\u000209H\u0002J\t\u0010ì\u0002\u001a\u00020ZH\u0002J\t\u0010í\u0002\u001a\u00020ZH\u0002J\t\u0010î\u0002\u001a\u00020ZH\u0002J\t\u0010ï\u0002\u001a\u00020ZH\u0002J\t\u0010ð\u0002\u001a\u00020ZH\u0002J\t\u0010ñ\u0002\u001a\u00020ZH\u0002J\u0019\u0010ò\u0002\u001a\u00020Z2\u000e\u0010ó\u0002\u001a\t\u0012\u0004\u0012\u00020Z0ô\u0002H\u0002J\u0014\u0010õ\u0002\u001a\u00020Z2\t\b\u0002\u0010¼\u0002\u001a\u00020\u000eH\u0002J\u0014\u0010ö\u0002\u001a\u00020Z2\t\b\u0002\u0010¼\u0002\u001a\u00020\u000eH\u0002J\u0012\u0010÷\u0002\u001a\u00020Z2\u0007\u0010¼\u0002\u001a\u00020\u000eH\u0002J\t\u0010ø\u0002\u001a\u00020ZH\u0002J\u001c\u0010ù\u0002\u001a\u00020Z2\b\u0010ú\u0002\u001a\u00030û\u00022\u0007\u0010ü\u0002\u001a\u00020\u000eH\u0002J\t\u0010ý\u0002\u001a\u00020ZH\u0002J\u0012\u0010þ\u0002\u001a\u00020Z2\u0007\u0010ü\u0001\u001a\u00020rH\u0002J\u0013\u0010ÿ\u0002\u001a\u00020Z2\b\u0010\u0080\u0003\u001a\u00030\u008c\u0001H\u0002J\t\u0010\u0081\u0003\u001a\u00020ZH\u0002J\t\u0010\u0082\u0003\u001a\u00020ZH\u0002J\t\u0010\u0083\u0003\u001a\u00020ZH\u0002J\t\u0010\u0084\u0003\u001a\u00020ZH\u0002J\t\u0010\u0085\u0003\u001a\u00020ZH\u0002J\t\u0010\u0086\u0003\u001a\u00020ZH\u0002J\t\u0010\u0087\u0003\u001a\u00020ZH\u0002J\t\u0010\u0088\u0003\u001a\u00020ZH\u0002J.\u0010\u0089\u0003\u001a\u00020Z2\u000f\b\u0002\u0010Í\u0002\u001a\b\u0012\u0004\u0012\u00020D0C2\u0012\b\u0002\u0010\u008a\u0003\u001a\u000b\u0012\u0005\u0012\u00030\u008b\u0003\u0018\u00010CH\u0002J\t\u0010\u008c\u0003\u001a\u00020ZH\u0002J\u0014\u0010\u008d\u0003\u001a\u00030\u008e\u00032\b\u0010\u008f\u0003\u001a\u00030\u008c\u0001H\u0002J\u001b\u0010\u0090\u0003\u001a\u00020\u000e2\u0007\u0010\u0091\u0003\u001a\u00020\u000e2\u0007\u0010\u0092\u0003\u001a\u00020rH\u0002J\u0012\u0010\u0093\u0003\u001a\u00020Z2\u0007\u0010\u0094\u0003\u001a\u00020VH\u0002J\t\u0010\u0095\u0003\u001a\u00020ZH\u0002J\u0012\u0010\u0096\u0003\u001a\u00020Z2\u0007\u0010\u0097\u0003\u001a\u00020\u000eH\u0002J\u0012\u0010\u0098\u0003\u001a\u00020Z2\u0007\u0010\u0097\u0003\u001a\u00020\u000eH\u0002J\t\u0010\u0099\u0003\u001a\u00020ZH\u0002J\t\u0010\u009a\u0003\u001a\u00020ZH\u0002J\u0014\u0010\u009b\u0003\u001a\u00020Z2\t\b\u0002\u0010\u009c\u0003\u001a\u000209H\u0002J\t\u0010\u009d\u0003\u001a\u00020ZH\u0002J \u0010\u009e\u0003\u001a\t\u0012\u0005\u0012\u00030À\u00010C2\u000e\u0010¿\u0001\u001a\t\u0012\u0005\u0012\u00030À\u00010CH\u0002J\t\u0010\u009f\u0003\u001a\u00020?H\u0002J\u000f\u0010 \u0003\u001a\b\u0012\u0004\u0012\u00020D0CH\u0002J\u0012\u0010¡\u0003\u001a\u00020Z2\u0007\u0010á\u0002\u001a\u000209H\u0002J\t\u0010¢\u0003\u001a\u00020ZH\u0002J\t\u0010£\u0003\u001a\u00020ZH\u0002J\t\u0010¤\u0003\u001a\u00020ZH\u0002J\t\u0010¥\u0003\u001a\u00020ZH\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001a\u001a\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020+8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020D0CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020D0CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020VX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010f\u001a\u0004\u0018\u00010gX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010h\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010iR\u000e\u0010j\u001a\u00020kX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010p\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020kX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010z\u001a\n |*\u0004\u0018\u00010{0{8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u007f\u0010\u001a\u001a\u0004\b}\u0010~R\u0017\u0010\u0080\u0001\u001a\u0002098BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0017\u0010\u0082\u0001\u001a\n\u0012\u0005\u0012\u00030\u0084\u00010\u0083\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0085\u0001\u001a\u00030\u0084\u00018BX\u0082\u0084\u0002¢\u0006\u0010\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001*\u0006\b\u0086\u0001\u0010\u0087\u0001R \u0010\u008a\u0001\u001a\u0013\u0012\u000e\u0012\f |*\u0005\u0018\u00010\u008c\u00010\u008c\u00010\u008b\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u008d\u0001\u001a\u00030\u008e\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008f\u0001\u001a\u00020rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u00020rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0001\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0092\u0001\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0001\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0094\u0001\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0095\u0001\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0096\u0001\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0097\u0001\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0098\u0001\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0099\u0001\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009a\u0001\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009b\u0001\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u009c\u0001\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u008c\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009e\u0001\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009f\u0001\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010 \u0001\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¡\u0001\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¢\u0001\u001a\u00030£\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010¤\u0001\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b¦\u0001\u0010\u001a\u001a\u0005\b¥\u0001\u0010\u0010R\u001e\u0010§\u0001\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b©\u0001\u0010\u001a\u001a\u0005\b¨\u0001\u0010\u0010R\u001e\u0010ª\u0001\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b¬\u0001\u0010\u001a\u001a\u0005\b«\u0001\u0010\u0010¨\u0006ª\u0003"}, d2 = {"Lcom/obric/aiproactive/ui/entry/NowFeedPageFragment;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedPageFragment;", "<init>", "()V", "avatarOvalOutlineProvider", "com/obric/aiproactive/ui/entry/NowFeedPageFragment$avatarOvalOutlineProvider$1", "Lcom/obric/aiproactive/ui/entry/NowFeedPageFragment$avatarOvalOutlineProvider$1;", "proactiveEnabledListener", "Lcom/obric/aiproactive/api/ProactiveRecommendationEnabledListener;", "pageType", "Lcom/obric/aiproactive/api/PageType;", "getPageType", "()Lcom/obric/aiproactive/api/PageType;", "backgroundResId", "", "getBackgroundResId", "()I", "adapterMode", "Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Mode;", "getAdapterMode", "()Lcom/obric/aiproactive/ui/list/ProactiveListAdapter$Mode;", "nowViewModel", "Lcom/obric/aiproactive/ui/entry/NowFeedViewModel;", "getNowViewModel", "()Lcom/obric/aiproactive/ui/entry/NowFeedViewModel;", "nowViewModel$delegate", "Lkotlin/Lazy;", "allViewModel", "Lcom/obric/aiproactive/ui/entry/AllFeedViewModel;", "getAllViewModel", "()Lcom/obric/aiproactive/ui/entry/AllFeedViewModel;", "allViewModel$delegate", "requirementComposerViewModel", "Lcom/obric/aiproactive/ui/entry/AiProactiveUserRequirementComposerViewModel;", "getRequirementComposerViewModel", "()Lcom/obric/aiproactive/ui/entry/AiProactiveUserRequirementComposerViewModel;", "requirementComposerViewModel$delegate", "guidedPreferenceInterviewStore", "Lcom/obric/aiproactive/ui/preference/GuidedPreferenceInterviewStore;", "getGuidedPreferenceInterviewStore", "()Lcom/obric/aiproactive/ui/preference/GuidedPreferenceInterviewStore;", "guidedPreferenceInterviewStore$delegate", "baseViewModel", "Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel;", "getBaseViewModel", "()Lcom/obric/aiproactive/ui/entry/BaseProactiveFeedViewModel;", "latestNowState", "Lcom/obric/aiproactive/ui/model/FeedPageUiState;", "latestAllState", "Lcom/obric/aiproactive/ui/model/AllPageUiState;", "latestStartupState", "Lcom/obric/aiproactive/ui/entry/StartupInspirationCoordinatorState;", "adapterRef", "Lcom/obric/aiproactive/ui/list/ProactiveListAdapter;", "currentVisualState", "Lcom/obric/aiproactive/ui/entry/NowFeedPageFragment$NowVisualState;", "isProactiveEnabled", "", "forceSensingAfterCelebration", "celebrationActive", "celebrationPending", "celebrationAppBarExpansionRequested", "celebrationBatchId", "", "latestBatchId", "previousHadPendingRecommendations", "celebrationRecommendations", "", "Lcom/obric/aiproactive/ui/model/ProactiveListItem$Recommendation;", "celebrationResetRunnable", "Ljava/lang/Runnable;", "celebrationStartRunnable", "sensingExitActive", "sensingExitAnimationQueued", "sensingExitRecommendations", "sensingExitResetRunnable", "debugMockRecommendations", "debugMockBatchId", "wakeUpInProgress", "todaySensingEventsJob", "Lkotlinx/coroutines/Job;", "agentRunJob", "todaySensingEventsDayAnchor", "latestAgentRun", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;", "lifecycleAgentStatusBarState", "Lcom/obric/aiproactive/ui/entry/NowAgentStatusBarState;", "agentStatusBarState", "agentStatusResetRunnable", "performLightTapHaptic", "", TypedValues.AttributesType.S_TARGET, "Landroid/view/View;", "todaySensingEventsStarted", "morePopover", "Lcom/obric/oui/popover/v2/OPopover;", "shouldReportMorePopoverCollapse", "sensingRecordCount", "entryGate", "Lcom/obric/aiproactive/ui/entry/AiProactiveEntryGate;", "navigationBarBottom", "userRequirementSending", "userRequirementSendingAnimator", "Landroid/animation/ObjectAnimator;", "pendingUserRequirementToastResId", "Ljava/lang/Integer;", "userRequirementInputMode", "Lcom/obric/aiproactive/ui/entry/NowFeedPageFragment$UserRequirementInputMode;", "voicePressActive", "voicePressStarted", "voicePressStartedFromTextInput", "voiceAwaitingResult", "voiceStartRunnable", "voicePressRawX", "", "voicePressRawY", "voiceOverlayOwnsComposerVisibility", "voiceComposerWasVisible", "pendingVoiceModeEntry", "voicePermissionRequestInFlight", "voiceSubmissionInFlight", "voiceSubmissionReturnMode", "requirementInputModePreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getRequirementInputModePreferences", "()Landroid/content/SharedPreferences;", "requirementInputModePreferences$delegate", "isAiVoiceSupportedOnThisDevice", "()Z", "voiceAsrBridgeDelegate", "Lkotlin/Lazy;", "Lcom/obric/aiproactive/ui/voice/AiVoiceSdkAsrBridge;", "voiceAsrBridge", "getVoiceAsrBridge$delegate", "(Lcom/obric/aiproactive/ui/entry/NowFeedPageFragment;)Ljava/lang/Object;", "getVoiceAsrBridge", "()Lcom/obric/aiproactive/ui/voice/AiVoiceSdkAsrBridge;", "recordAudioPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "sensingUiState", "Lcom/obric/aiproactive/ui/entry/NowSensingUiState;", "startCenterYOffset", "startAvatarSize", "defaultSuggestionRecyclerTop", "currentAppBarOffset", "collapseEvaluationPosted", "collapseMeasurementRetryCount", "collapseEvaluationFirstPassRunnable", "collapseEvaluationSecondPassRunnable", "nowListScrollEnabled", "nowAppBarCollapseEnabled", "nowListStickyOverlapEnabled", "scrollStateConfigured", "lastLayoutDebugLogAt", "lastRenderedVisualState", "pendingViewportResetReason", "pendingViewportResetForce", "avatarTapCount", "lastAvatarFiveTapTriggeredAt", "avatarFiveTapRequestInFlight", "celebrationWindowFocusChangeListener", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "defaultTitleColor", "getDefaultTitleColor", "defaultTitleColor$delegate", "primaryTitleColor", "getPrimaryTitleColor", "primaryTitleColor$delegate", "tertiaryTextColor", "getTertiaryTextColor", "tertiaryTextColor$delegate", "onSaveInstanceState", "outState", "Landroid/os/Bundle;", "onViewCreated", "view", "savedInstanceState", "canStartPageData", "resolveTopPadding", "titleContainerBottom", "extraTop", "resolveBottomPadding", "bottomHandleHeight", "extraBottom", "onDestroyView", "observePageState", "adapter", "renderPageState", "loading", "items", "Lcom/obric/aiproactive/ui/model/ProactiveListItem;", "onRecommendationAdopted", "item", "onBeforeOpenRecommendationDetail", "onPause", "onStop", "onResume", "setupStaticViews", "setupUserRequirementComposer", "requestUserRequirementVoiceMode", "enterUserRequirementVoiceMode", "exitUserRequirementVoiceMode", "showIme", "handleUserRequirementVoiceTouch", "event", "Landroid/view/MotionEvent;", "fromTextInput", "startUserRequirementVoiceRecording", "updateUserRequirementVoiceCancellation", "rawX", "rawY", "finishUserRequirementVoiceRecording", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "handleUserRequirementVoiceSuccess", "transcript", "handleUserRequirementVoiceFailure", "errorCode", "(Ljava/lang/Integer;)V", "cancelUserRequirementVoiceSession", "resetToTextMode", "restoreUserRequirementStableInputMode", "clearVoiceStartRunnable", "voiceIdleModeAfterCurrentPress", "performVoiceStartHaptic", AILabCheckPermissionTask.KEY_SOURCE, "performVoiceStateHaptic", "performVoiceHaptic", "feedbackType", "Lcom/obric/aiagent/product/platform/api/vibratefeedback/FeedbackType;", "applyUserRequirementComposerMaterials", "restoreUserRequirementComposerFallbackBackgrounds", "clearUserRequirementComposerMaterials", "normalizeRequirementInputContainerPadding", "inputLayout", "Lcom/obric/oui/forms/OInputLayout;", "updateUserRequirementInputHeight", "input", "Landroid/widget/EditText;", "setupUserRequirementComposerInsetsAnimation", "applyUserRequirementComposerInsets", "insets", "Landroidx/core/view/WindowInsetsCompat;", "imeProgress", "useAnimatedImeBottom", "updateUserRequirementComposerMargins", "navigationBottom", "updateUserRequirementComposerBackdropLayout", "interpolateRequirementComposerMargin", CommonConsts.APM_INNER_EVENT_COST_START, "end", "progress", "submitUserRequirement", "dismissImeThenShowUserRequirementToast", "messageResId", "dismissUserRequirementImeIfTouchOutside", "showPendingUserRequirementToastIfImeHidden", "updateUserRequirementComposerVisibility", "visible", "updateUserRequirementComposerState", "updateUserRequirementVoiceOverlay", "isRecording", "isCancelling", "startUserRequirementSendingAnimator", "stopUserRequirementSendingAnimator", "onAvatarTapped", "handleAvatarFiveTapTriggered", "triggerAt", "restoreNowPageFromStickyAvatar", "showMorePopup", "dismissMorePopover", "reportCollapse", "disableClipFromButtonAncestors", "button", "showFeedbackDialog", "resetDisabledProactiveState", "maybeStartCelebration", "currentRecommendations", "previousRecommendations", "queueCelebrationAfterAdopting", "pauseCelebrationUntilForeground", "maybeStartSensingExitAnimation", "cancelCelebrationForReplacement", "prepareForSecondaryActivity", InfoRequestQPSOptTraceLogger.REASON, "cancelCelebrationState", "forceSensing", "renderCurrentState", "resolveVisualState", "resolveAvatarSource", "Lcom/obric/aiproactive/ui/widget/ProactiveAvatarView$Source;", "visualState", "renderAvatar", "renderSleepState", "renderSensingState", "renderSuggestionState", "renderCelebrationState", "updateActionButtons", "historyEnabled", "canOpenHistoryPage", "hasHistoryContent", "configureScrollState", "enableListScroll", "enableAppBarCollapse", "enableListStickyOverlap", "installCollapseStateLayoutObservers", "scheduleCollapseStateEvaluation", "delayMillis", "requestCollapseStateReevaluation", "refreshCollapseStateAfterResume", "shouldResetNowViewportAfterResume", "isRecyclerTopItemSettled", "scheduleNowViewportReset", "force", "scheduleNowViewportResetRetry", "attempt", "resetNowViewportToTop", "canResetNowViewportForCurrentState", "currentScrollBehavior", "Lcom/obric/aiproactive/ui/entry/NowListScrollBehavior;", "supportsCollapsibleListForCurrentContent", "hasGuidedPreferenceEntry", "resolveScrollBehaviorForCurrentContent", "shouldRunCollapseEvaluation", "isScreenInteractive", "clearPendingCollapseEvaluation", "ensureNowListBottomSpacing", "nowListBottomSafeSpacePx", "applyVisualConfig", "config", "Lcom/obric/aiproactive/ui/entry/NowVisualConfig;", "resolveNowVisualConfigForItems", "recommendations", "hasVisibleCards", "updateNowListTopPadding", "updateAvatarLayout", "avatarSize", "centerYOffset", "createAvatarBorderDrawable", "Landroid/graphics/drawable/GradientDrawable;", "radiusPx", "updateAvatarTextLayout", "titleTopMarginDp", "titleTextSizeSp", "subtitleTopMarginDp", "subtitleTextSizeSp", "subtitleHorizontalMarginDp", "eventTopMarginDp", "calculateSensingHeadlineTextMaxWidth", "updateHeaderBottomPadding", "bottomPaddingDp", "updateTitleSweep", "enabled", "applyTitleStyle", "style", "Lcom/obric/aiproactive/ui/entry/NowTitleStyle;", "maybeStartSharedElementTransition", "nextVisualState", "onRecyclerScrolled", "dy", "layoutManager", "Lcom/obric/oui/orecyclerview/widget/LinearLayoutManager;", "shouldAutoReturnTopForCelebration", "tryCompleteCelebrationPending", "smoothScrollCelebrationListToTop", "scheduleCelebrationPendingCheck", "startCelebrationState", "renderPostCelebrationGuidedEntry", "maybeRunSensingExitAnimation", "playNowCardsExitAnimation", "onAnimationEnd", "Lkotlin/Function0;", "resetNowViewportAfterCelebrationIfNeeded", "playGuidedEntryEnterAfterCelebration", "retryGuidedEntryEnterAfterCelebration", "resetSensingExitState", "updateCollapsedVisuals", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "verticalOffset", "resetCollapsedVisuals", "updateRecyclerOverlap", "debugLayoutWarning", "message", "ensureStickyForegroundOrder", "configureAvatarPlayback", "configureAvatarOvalClipping", "refreshAvatarOvalClipping", "observeAllPageState", "ensureHistoryPageDataStarted", "ensureTodaySensingEventsStarted", "ensureAgentRunStarted", "refreshAgentStatusBarState", "todayRows", "Lcom/obric/aiproactive/api/AiProactiveEventRecordDto;", "renderSensingHeadline", "buildSensingHeadlineText", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "withAlphaFraction", TypedValues.Custom.S_COLOR, "fraction", "updateAgentStatusBarState", "nextState", "renderAgentStatusBar", "applyTemporaryMockRecommendations", CommonConsts.COUNT_TYPE, "applyTemporaryCelebrationRecommendations", "clearTemporaryMockRecommendations", "refreshCurrentPage", "refreshGuidedPreferenceEntryVisibility", "forceRebuild", "onGuidedPreferenceEntryClick", "currentRenderItems", "currentRenderBatchId", "currentActiveRecommendations", "setProactiveEnabled", "refreshProactiveEnabledState", "continueWakeUp", "observeStartupCoordinator", "tryHandleStartupInspiration", "Companion", "UserRequirementInputMode", "NowViewportSnapshot", "NowVisualState", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NowFeedPageFragment extends BaseProactiveFeedPageFragment {
    private static final long AVATAR_FIVE_TAP_COOLDOWN_MS = 120000;
    private static final int AVATAR_FIVE_TAP_TRIGGER_COUNT = 5;
    public static final a Companion = null;
    private static final long GUIDED_ENTRY_ENTER_DURATION_MS = 300;
    private static final int GUIDED_ENTRY_ENTER_MAX_ATTEMPTS = 8;
    private static final float GUIDED_ENTRY_ENTER_OFFSET_DP = 180.0f;
    private static final float NOW_LIST_BOTTOM_SAFE_SPACE_DP = 148.0f;
    private static final String REQUIREMENT_INPUT_MODE_PREFS = "ai_proactive_requirement_input_mode";
    private static final String REQUIREMENT_INPUT_MODE_VOICE_KEY = "voice_mode_enabled";
    private static final long REQUIREMENT_SENDING_ROTATION_DURATION_MS = 700;
    private static final int RESET_AFTER_CELEBRATION_MAX_ATTEMPTS = 8;
    private static final float SENSING_HEADLINE_ICON_DP = 16.0f;
    private static final float SENSING_HEADLINE_SCREEN_MARGIN_DP = 24.0f;
    private static final float SENSING_HEADLINE_TEXT_ALPHA = 0.38f;
    private static final float SENSING_HEADLINE_TEXT_GAP_DP = 4.0f;
    private static final float STICKY_CHROME_HEIGHT_DP = 132.0f;
    private static final float STICKY_LIST_MAX_OVERLAP_DP = 84.0f;
    private static final float STICKY_OVERLAY_MAX_ALPHA = 0.18f;
    private static final long TEXT_INPUT_VOICE_PRESS_START_DELAY_MS = 300;
    private static final int VIEWPORT_RESET_RETRY_COUNT = 2;
    private static final long VIEWPORT_RESET_SHORT_DELAY_MS = 80;
    private static final long VIEWPORT_RESET_TRANSITION_DELAY_MS = 360;
    private static final long VOICE_PRESS_START_DELAY_MS = 150;
    private final ProactiveListAdapter.Mode adapterMode;
    private ProactiveListAdapter adapterRef;
    private bx agentRunJob;
    private j agentStatusBarState;
    private Runnable agentStatusResetRunnable;
    private final Lazy allViewModel$delegate;
    private boolean avatarFiveTapRequestInFlight;
    private final c avatarOvalOutlineProvider;
    private int avatarTapCount;
    private final int backgroundResId;
    private boolean celebrationActive;
    private boolean celebrationAppBarExpansionRequested;
    private long celebrationBatchId;
    private boolean celebrationPending;
    private List<com.obric.aiproactive.ui.model.j.f> celebrationRecommendations;
    private Runnable celebrationResetRunnable;
    private Runnable celebrationStartRunnable;
    private final ViewTreeObserver.OnWindowFocusChangeListener celebrationWindowFocusChangeListener;
    private Runnable collapseEvaluationFirstPassRunnable;
    private boolean collapseEvaluationPosted;
    private Runnable collapseEvaluationSecondPassRunnable;
    private int collapseMeasurementRetryCount;
    private int currentAppBarOffset;
    private NowVisualState currentVisualState;
    private long debugMockBatchId;
    private List<com.obric.aiproactive.ui.model.j.f> debugMockRecommendations;
    private int defaultSuggestionRecyclerTop;
    private final Lazy defaultTitleColor$delegate;
    private AiProactiveEntryGate entryGate;
    private boolean forceSensingAfterCelebration;
    private final Lazy guidedPreferenceInterviewStore$delegate;
    private boolean isProactiveEnabled;
    private long lastAvatarFiveTapTriggeredAt;
    private long lastLayoutDebugLogAt;
    private NowVisualState lastRenderedVisualState;
    private com.obric.aiproactive.api.g latestAgentRun;
    private com.obric.aiproactive.ui.model.f latestAllState;
    private long latestBatchId;
    private com.obric.aiproactive.ui.model.g latestNowState;
    private ac latestStartupState;
    private j lifecycleAgentStatusBarState;
    private com.obric.oui.popover.v2.a morePopover;
    private int navigationBarBottom;
    private boolean nowAppBarCollapseEnabled;
    private boolean nowListScrollEnabled;
    private boolean nowListStickyOverlapEnabled;
    private final Lazy nowViewModel$delegate;
    private final PageType pageType;
    private Integer pendingUserRequirementToastResId;
    private boolean pendingViewportResetForce;
    private String pendingViewportResetReason;
    private boolean pendingVoiceModeEntry;
    private boolean previousHadPendingRecommendations;
    private final Lazy primaryTitleColor$delegate;
    private final com.obric.aiproactive.api.ae proactiveEnabledListener;
    private final ActivityResultLauncher<String> recordAudioPermissionLauncher;
    private final Lazy requirementComposerViewModel$delegate;
    private final Lazy requirementInputModePreferences$delegate;
    private boolean scrollStateConfigured;
    private boolean sensingExitActive;
    private boolean sensingExitAnimationQueued;
    private List<com.obric.aiproactive.ui.model.j.f> sensingExitRecommendations;
    private Runnable sensingExitResetRunnable;
    private int sensingRecordCount;
    private q sensingUiState;
    private boolean shouldReportMorePopoverCollapse;
    private float startAvatarSize;
    private float startCenterYOffset;
    private final Lazy tertiaryTextColor$delegate;
    private long todaySensingEventsDayAnchor;
    private bx todaySensingEventsJob;
    private boolean todaySensingEventsStarted;
    private UserRequirementInputMode userRequirementInputMode;
    private boolean userRequirementSending;
    private ObjectAnimator userRequirementSendingAnimator;
    private final Lazy<AiVoiceSdkAsrBridge> voiceAsrBridgeDelegate;
    private boolean voiceAwaitingResult;
    private boolean voiceComposerWasVisible;
    private boolean voiceOverlayOwnsComposerVisibility;
    private boolean voicePermissionRequestInFlight;
    private boolean voicePressActive;
    private float voicePressRawX;
    private float voicePressRawY;
    private boolean voicePressStarted;
    private boolean voicePressStartedFromTextInput;
    private Runnable voiceStartRunnable;
    private boolean voiceSubmissionInFlight;
    private UserRequirementInputMode voiceSubmissionReturnMode;
    private boolean wakeUpInProgress;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aiproactive/ui/entry/NowFeedPageFragment$NowVisualState;", "", "<init>", "(Ljava/lang/String;I)V", "SLEEP", "SENSING", "SUGGESTION", "CELEBRATION", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum NowVisualState extends Enum<NowVisualState> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ NowVisualState[] $VALUES = null;
        public static final NowVisualState CELEBRATION = null;
        public static final NowVisualState SENSING = null;
        public static final NowVisualState SLEEP = null;
        public static final NowVisualState SUGGESTION = null;

        private static final /* synthetic */ NowVisualState[] $values() {
            return new NowVisualState[]{SLEEP, SENSING, SUGGESTION, CELEBRATION};
        }

        static {
            SLEEP = new NowVisualState("SLEEP", 0);
            SENSING = new NowVisualState("SENSING", 1);
            SUGGESTION = new NowVisualState("SUGGESTION", 2);
            CELEBRATION = new NowVisualState("CELEBRATION", 3);
            NowVisualState[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private NowVisualState(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<NowVisualState> getEntries() {
            return $ENTRIES;
        }

        public static NowVisualState valueOf(String r2) {
            return (NowVisualState) ZeusTransformUtils.preCheckCast(Enum.valueOf(NowVisualState.class, r2), NowVisualState.class, "com.obric.memorydata.plugin");
        }

        public static NowVisualState[] values() {
            return (NowVisualState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NowVisualState[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/aiproactive/ui/entry/NowFeedPageFragment$UserRequirementInputMode;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "VOICE_READY", "VOICE_RECORDING", "VOICE_CANCELLING", "VOICE_TRANSCRIBING", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final enum UserRequirementInputMode extends Enum<UserRequirementInputMode> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ UserRequirementInputMode[] $VALUES = null;
        public static final UserRequirementInputMode TEXT = null;
        public static final UserRequirementInputMode VOICE_CANCELLING = null;
        public static final UserRequirementInputMode VOICE_READY = null;
        public static final UserRequirementInputMode VOICE_RECORDING = null;
        public static final UserRequirementInputMode VOICE_TRANSCRIBING = null;

        private static final /* synthetic */ UserRequirementInputMode[] $values() {
            return new UserRequirementInputMode[]{TEXT, VOICE_READY, VOICE_RECORDING, VOICE_CANCELLING, VOICE_TRANSCRIBING};
        }

        static {
            TEXT = new UserRequirementInputMode("TEXT", 0);
            VOICE_READY = new UserRequirementInputMode("VOICE_READY", 1);
            VOICE_RECORDING = new UserRequirementInputMode("VOICE_RECORDING", 2);
            VOICE_CANCELLING = new UserRequirementInputMode("VOICE_CANCELLING", 3);
            VOICE_TRANSCRIBING = new UserRequirementInputMode("VOICE_TRANSCRIBING", 4);
            UserRequirementInputMode[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private UserRequirementInputMode(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<UserRequirementInputMode> getEntries() {
            return $ENTRIES;
        }

        public static UserRequirementInputMode valueOf(String r2) {
            return (UserRequirementInputMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(UserRequirementInputMode.class, r2), UserRequirementInputMode.class, "com.obric.memorydata.plugin");
        }

        public static UserRequirementInputMode[] values() {
            return (UserRequirementInputMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), UserRequirementInputMode[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/aiproactive/ui/entry/NowFeedPageFragment$Companion;", "", "<init>", "()V", "AVATAR_FIVE_TAP_TRIGGER_COUNT", "", "AVATAR_FIVE_TAP_COOLDOWN_MS", "", "STICKY_CHROME_HEIGHT_DP", "", "STICKY_OVERLAY_MAX_ALPHA", "STICKY_LIST_MAX_OVERLAP_DP", "NOW_LIST_BOTTOM_SAFE_SPACE_DP", "REQUIREMENT_SENDING_ROTATION_DURATION_MS", "VOICE_PRESS_START_DELAY_MS", "TEXT_INPUT_VOICE_PRESS_START_DELAY_MS", "REQUIREMENT_INPUT_MODE_PREFS", "", "REQUIREMENT_INPUT_MODE_VOICE_KEY", "SENSING_HEADLINE_SCREEN_MARGIN_DP", "SENSING_HEADLINE_ICON_DP", "SENSING_HEADLINE_TEXT_GAP_DP", "SENSING_HEADLINE_TEXT_ALPHA", "RESET_AFTER_CELEBRATION_MAX_ATTEMPTS", "VIEWPORT_RESET_RETRY_COUNT", "VIEWPORT_RESET_SHORT_DELAY_MS", "VIEWPORT_RESET_TRANSITION_DELAY_MS", "GUIDED_ENTRY_ENTER_MAX_ATTEMPTS", "GUIDED_ENTRY_ENTER_DURATION_MS", "GUIDED_ENTRY_ENTER_OFFSET_DP", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6585a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f6586b = null;
        public static final /* synthetic */ int[] c = null;
        public static final /* synthetic */ int[] d = null;

        static {
            int[] r0 = new int[UserRequirementInputMode.values().length];
            r0[UserRequirementInputMode.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L67:
            r0[UserRequirementInputMode.VOICE_READY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L73:
            r0[UserRequirementInputMode.VOICE_RECORDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L49:
            r0[UserRequirementInputMode.VOICE_CANCELLING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L51:
            r0[UserRequirementInputMode.VOICE_TRANSCRIBING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L11:
            f6585a = r0;
            int[] r1 = new int[NowVisualState.values().length];
            r1[NowVisualState.SENSING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L43:
            r1[NowVisualState.SUGGESTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L53:
            r1[NowVisualState.SLEEP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L61:
            r1[NowVisualState.CELEBRATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L35
        L16:
            f6586b = r1;
            int[] r2 = new int[CollapseMeasurementAction.values().length];
            r2[CollapseMeasurementAction.EVALUATE_NOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L36
        L55:
            r2[CollapseMeasurementAction.RETRY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L37
        L63:
            r2[CollapseMeasurementAction.FORCE_ENABLE_COLLAPSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L38
        L20:
            c = r2;
            int[] r3 = new int[NowCelebrationViewportAction.values().length];
            r3[NowCelebrationViewportAction.WAIT_FOR_LIST_TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L39
        L57:
            r3[NowCelebrationViewportAction.REQUEST_APP_BAR_EXPANSION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L40
        L65:
            r3[NowCelebrationViewportAction.WAIT_FOR_APP_BAR_EXPANSION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L41
        L71:
            r3[NowCelebrationViewportAction.START_CELEBRATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L42
        L25:
            d = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/aiproactive/ui/entry/NowFeedPageFragment$avatarOvalOutlineProvider$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends ViewOutlineProvider {
        c() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r2, Outline r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "outline");
            r3.setOval(0, 0, r2.getWidth(), r2.getHeight());
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/aiproactive/ui/entry/NowFeedPageFragment$configureAvatarPlayback$1", "Lcom/obric/aiproactive/ui/widget/ProactiveAvatarView$PlaybackListener;", "onPlaybackError", "", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/aiproactive/ui/widget/ProactiveAvatarView$Source;", "error", "Lcom/obric/aiproactive/ui/widget/ProactiveAvatarView$PlaybackError;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements ProactiveAvatarView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NowFeedPageFragment f6587a;

        d(NowFeedPageFragment r1) {
            this.f6587a = r1;
        }

        @Override // com.obric.aiproactive.ui.widget.ProactiveAvatarView.b
        public void a(ProactiveAvatarView.c r1) {
            ProactiveAvatarView.b.a.a(this, r1);
        }

        @Override // com.obric.aiproactive.ui.widget.ProactiveAvatarView.b
        public void a(ProactiveAvatarView.c r7, ProactiveAvatarView.a r8) {
            Intrinsics.checkNotNullParameter(r7, AILabCheckPermissionTask.KEY_SOURCE);
            Intrinsics.checkNotNullParameter(r8, "error");
            String r2 = "[code=avatar_video_playback_failed] operation=" + r8.a() + " videoResId=" + r7.a() + " what=" + r8.b() + " extra=" + r8.c();
            if (r8.d() == null) goto L5;
            RunLog.INSTANCE.warn(this.f6587a.getLogTag(), r2, (Throwable) ZeusTransformUtils.preCheckCast(r8.d(), Throwable.class, "com.obric.memorydata.plugin"));
            return;
        L5:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.f6587a.getLogTag(), r2, null, 4, null);
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"com/obric/aiproactive/ui/entry/NowFeedPageFragment$setupStaticViews$3", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$OnItemTouchListener;", "initialX", "", "initialY", "onInterceptTouchEvent", "", "rv", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "onTouchEvent", "", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements RecyclerView.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NowFeedPageFragment f6588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f6589b;
        private float c;
        private float d;

        e(NowFeedPageFragment r1, int r2) {
            this.f6588a = r1;
            this.f6589b = r2;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
        public void a(boolean r1) {
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
        public boolean a(RecyclerView r7, MotionEvent r8) {
            Intrinsics.checkNotNullParameter(r7, "rv");
            Intrinsics.checkNotNullParameter(r8, "e");
            int r9 = r8.getActionMasked();
            if (r9 != 0) goto L5;
            this.c = r8.getX();
            this.d = r8.getY();
        L21:
            return false;
        L5:
            if (r9 != 2) goto L21;
            boolean r10 = NowFeedPageFragment.access$getNowListScrollEnabled$p(this.f6588a);
            boolean r1 = NowFeedPageFragment.access$getNowAppBarCollapseEnabled$p(this.f6588a);
            if (this.f6588a.getBinding().appBar.getTotalScrollRange() > 0) goto L10;
        L12:
            boolean r2 = false;
        L14:
            if (n.a(r10, r1, r2, r8.getY() - this.d) == false) goto L21;
            float r11 = r8.getX() - this.c;
            float r12 = r8.getY() - this.d;
            if (Math.abs(r12) <= this.f6589b) goto L21;
            if (Math.abs(r12) <= Math.abs(r11)) goto L21;
            return true;
        L10:
            if (NowFeedPageFragment.access$getCurrentAppBarOffset$p(this.f6588a) > (-this.f6588a.getBinding().appBar.getTotalScrollRange())) goto L12;
            r2 = true;
            goto L14
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.l
        public void b(RecyclerView r1, MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r1, "rv");
            Intrinsics.checkNotNullParameter(r2, "e");
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.NowFeedPageFragment$ensureAgentRunStarted$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.NowFeedPageFragment$ensureAgentRunStarted$1", f = "NowFeedPageFragment.kt", i = {}, l = {3441}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ NowFeedPageFragment this$0;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.NowFeedPageFragment$ensureAgentRunStarted$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "run", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.aiproactive.ui.entry.NowFeedPageFragment$ensureAgentRunStarted$1$1", f = "NowFeedPageFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C03011 extends SuspendLambda implements Function2<com.obric.aiproactive.api.g, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NowFeedPageFragment this$0;

            C03011(NowFeedPageFragment r3, Continuation<? super C03011> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                C03011 r0 = new C03011(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(com.obric.aiproactive.api.g r3, Continuation<? super Unit> r4) {
                return ((C03011) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C03011.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(com.obric.aiproactive.api.g r3, Continuation<? super Unit> r4) {
                return invoke2((com.obric.aiproactive.api.g) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.api.g.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r3);
                com.obric.aiproactive.api.g r4 = (com.obric.aiproactive.api.g) ZeusTransformUtils.preCheckCast(this.L$0, com.obric.aiproactive.api.g.class, "com.obric.memorydata.plugin");
                NowFeedPageFragment r0 = this.this$0;
                NowFeedPageFragment.access$setLatestAgentRun$p(r0, n.a(NowFeedPageFragment.access$getLatestAgentRun$p(r0), r4));
                NowFeedPageFragment.refreshAgentStatusBarState$default(this.this$0, null, null, 3, null);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(NowFeedPageFragment r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.i<com.obric.aiproactive.api.g> r7 = this.this$0.getRepository().c();
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C03011(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r7, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.NowFeedPageFragment$ensureTodaySensingEventsStarted$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.NowFeedPageFragment$ensureTodaySensingEventsStarted$1", f = "NowFeedPageFragment.kt", i = {}, l = {3408}, m = "invokeSuspend", n = {}, s = {})
    static final class C10571 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $dayAnchor;
        int label;
        final /* synthetic */ NowFeedPageFragment this$0;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.NowFeedPageFragment$ensureTodaySensingEventsStarted$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Pair;", "", "", "Lcom/obric/aiproactive/api/AiProactiveEventRecordDto;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.aiproactive.ui.entry.NowFeedPageFragment$ensureTodaySensingEventsStarted$1$1", f = "NowFeedPageFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C03021 extends SuspendLambda implements Function2<Pair<? extends Integer, ? extends List<? extends com.obric.aiproactive.api.p>>, Continuation<? super Unit>, Object> {
            final /* synthetic */ long $subscribedDayAnchor;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NowFeedPageFragment this$0;

            C03021(long r3, NowFeedPageFragment r5, Continuation<? super C03021> r6) {
                Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
                this.$subscribedDayAnchor = r3;
                this.this$0 = r5;
                super(2, r7);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
                Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
                C03021 r0 = new C03021(this.$subscribedDayAnchor, this.this$0, r7);
                r0.L$0 = r5;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(Pair<? extends Integer, ? extends List<? extends com.obric.aiproactive.api.p>> r3, Continuation<? super Unit> r4) {
                return invoke2((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Pair<Integer, ? extends List<com.obric.aiproactive.api.p>> r3, Continuation<? super Unit> r4) {
                return ((C03021) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C03021.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r13) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L16;
                ResultKt.throwOnFailure(r13);
                Pair r14 = (Pair) ZeusTransformUtils.preCheckCast(this.L$0, Pair.class, "com.obric.memorydata.plugin");
                int r3 = ((Number) ZeusTransformUtils.preCheckCast(r14.component1(), Number.class, "com.obric.memorydata.plugin")).intValue();
                List r15 = (List) ZeusTransformUtils.preCheckCast(r14.component2(), List.class, "com.obric.memorydata.plugin");
                long r4 = n.a(0, null, 3, null);
                if (z.a(this.$subscribedDayAnchor, r4) != SensingEventsDayEmissionDecision.RESTART) goto L8;
                IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.this$0.getLogTag(), "[NowPage] restart today sensing events listener oldDay=" + this.$subscribedDayAnchor + " newDay=" + r4 + " total=" + r3 + " rows=" + r15.size(), false, 4, null);
                NowFeedPageFragment.access$ensureTodaySensingEventsStarted(this.this$0);
                return Unit.INSTANCE;
            L8:
                NowFeedPageFragment.access$setSensingRecordCount$p(this.this$0, r3);
                NowFeedPageFragment.access$setSensingUiState$p(this.this$0, n.a(r15, r3, System.currentTimeMillis(), null, 8, null));
                NowFeedPageFragment.refreshAgentStatusBarState$default(this.this$0, null, r15, 1, null);
                if (NowFeedPageFragment.access$getCurrentVisualState$p(this.this$0) != NowVisualState.SENSING) goto L11;
            L12:
                NowFeedPageFragment.access$renderSensingHeadline(this.this$0);
            L14:
                return Unit.INSTANCE;
            L11:
                if (NowFeedPageFragment.access$getCurrentVisualState$p(this.this$0) != NowVisualState.SUGGESTION) goto L14;
            L16:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C10571(long r3, NowFeedPageFragment r5, Continuation<? super C10571> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$dayAnchor = r3;
            this.this$0 = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10571(this.$dayAnchor, this.this$0, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10571) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10571.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            long r3 = this.$dayAnchor;
            kotlinx.coroutines.flow.i<Pair<Integer, List<com.obric.aiproactive.api.p>>> r9 = this.this$0.getRepository().b();
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C03021(r3, this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r9, r2, r4) != r0) goto L12;
            return r0;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/obric/aiproactive/ui/entry/NowFeedPageFragment$setupStaticViews$4", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "dx", "", "dy", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f extends RecyclerView.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NowFeedPageFragment f6590a;

        f(NowFeedPageFragment r1) {
            this.f6590a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "recyclerView");
            boolean r6 = NowFeedPageFragment.access$getNowListScrollEnabled$p(this.f6590a);
            boolean r7 = NowFeedPageFragment.access$getNowAppBarCollapseEnabled$p(this.f6590a);
            if (this.f6590a.getBinding().appBar.getTotalScrollRange() > 0) goto L5;
        L7:
            boolean r2 = false;
        L9:
            if (n.a(r6, r7, r2, r3.canScrollVertically(-1)) == true) goto L11;
            return;
        L11:
            r3.stopScroll();
            RecyclerView.h r8 = r3.getLayoutManager();
            if (ZeusTransformUtils.instanceOf(r8, LinearLayoutManager.class) == false) goto L14;
            LinearLayoutManager r9 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r8, LinearLayoutManager.class, "com.obric.memorydata.plugin");
        L15:
            if (r9 == null) goto L18;
            r9.b(0, 0);
            return;
        L18:
            return;
        L14:
            r9 = null;
            goto L15
        L5:
            if (NowFeedPageFragment.access$getCurrentAppBarOffset$p(this.f6590a) > (-this.f6590a.getBinding().appBar.getTotalScrollRange())) goto L7;
            r2 = true;
            goto L9
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/obric/aiproactive/ui/entry/NowFeedPageFragment$setupUserRequirementComposer$5$1", "Landroid/text/TextWatcher;", "beforeTextChanged", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "afterTextChanged", "editable", "Landroid/text/Editable;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class g implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NowFeedPageFragment f6591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OEditText f6592b;
        final /* synthetic */ OInputLayout c;

        g(NowFeedPageFragment r1, OEditText r2, OInputLayout r3) {
            this.f6591a = r1;
            this.f6592b = r2;
            this.c = r3;
        }

        private static final void a(NowFeedPageFragment r2, OInputLayout r3, OEditText r4) {
            NowFeedPageFragment.access$updateUserRequirementInputHeight(r2, r3, (EditText) ZeusTransformUtils.preCheckCast(r4, EditText.class, "com.obric.memorydata.plugin"));
        }

        public static /* synthetic */ void lambda$8voXT3kVBOMzTOqC7MFCBtrx6b4(NowFeedPageFragment r0, OInputLayout r1, OEditText r2) {
            a(r0, r1, r2);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r3) {
            Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.memorydata.plugin");
            AiProactiveUserRequirementComposerViewModel r0 = NowFeedPageFragment.access$getRequirementComposerViewModel(this.f6591a);
            if (r4 == null) goto L5;
            String r5 = r4.toString();
        L6:
            if (r5 != null) goto L8;
            r5 = "";
        L8:
            r0.onDraftChanged(r5);
            NowFeedPageFragment.access$updateUserRequirementComposerState(this.f6591a);
            final OEditText r6 = this.f6592b;
            final NowFeedPageFragment r1 = this.f6591a;
            final OInputLayout r2 = this.c;
            r6.post(new $$Lambda$NowFeedPageFragment$g$8voXT3kVBOMzTOqC7MFCBtrx6b4(r1, r2, r6));
            return;
        L5:
            r5 = null;
            goto L6
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, d2 = {"com/obric/aiproactive/ui/entry/NowFeedPageFragment$smoothScrollCelebrationListToTop$smoothScroller$1", "Lcom/obric/oui/orecyclerview/widget/LinearSmoothScroller;", "getVerticalSnapPreference", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class h extends com.obric.oui.orecyclerview.widget.p {
        h(Context r3) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.obric.oui.orecyclerview.widget.p
        public int a() {
            return -1;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.NowFeedPageFragment$handleAvatarFiveTapTriggered$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.NowFeedPageFragment$handleAvatarFiveTapTriggered$1", f = "NowFeedPageFragment.kt", i = {}, l = {1817}, m = "invokeSuspend", n = {}, s = {})
    static final class C10581 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ NowFeedPageFragment this$0;

        C10581(NowFeedPageFragment r3, Continuation<? super C10581> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10581(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10581) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10581.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L7
        L15:
            AlgorithmTaskInvokeResult r12 = (AlgorithmTaskInvokeResult) ZeusTransformUtils.preCheckCast(r11, AlgorithmTaskInvokeResult.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), this.this$0.getLogTag(), "[NowPage] hidden proactive entry finished code=" + r12.getCode() + " message=" + r12.getMessage(), false, 4, null);     // Catch: Throwable -> L7
        L18:
            NowFeedPageFragment.access$setAvatarFiveTapRequestInFlight$p(this.this$0, false);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r11);
            com.obric.aiproactive.ui.data.b r13 = this.this$0.getRepository();     // Catch: Throwable -> L7
            Continuation<? super AlgorithmTaskInvokeResult> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            r11 = r13.d(r2);     // Catch: Throwable -> L7
            if (r11 != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            RunLog.INSTANCE.warn(this.this$0.getLogTag(), "[NowPage] hidden proactive entry failed", th);     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            NowFeedPageFragment.access$setAvatarFiveTapRequestInFlight$p(this.this$0, false);
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.NowFeedPageFragment$observeAllPageState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.NowFeedPageFragment$observeAllPageState$1", f = "NowFeedPageFragment.kt", i = {}, l = {3384}, m = "invokeSuspend", n = {}, s = {})
    static final class C10591 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ NowFeedPageFragment this$0;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.NowFeedPageFragment$observeAllPageState$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/obric/aiproactive/ui/model/AllPageUiState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.aiproactive.ui.entry.NowFeedPageFragment$observeAllPageState$1$1", f = "NowFeedPageFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C03031 extends SuspendLambda implements Function2<com.obric.aiproactive.ui.model.f, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NowFeedPageFragment this$0;

            C03031(NowFeedPageFragment r3, Continuation<? super C03031> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                C03031 r0 = new C03031(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(com.obric.aiproactive.ui.model.f r3, Continuation<? super Unit> r4) {
                return ((C03031) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C03031.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(com.obric.aiproactive.ui.model.f r3, Continuation<? super Unit> r4) {
                return invoke2((com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r3);
                com.obric.aiproactive.ui.model.f r4 = (com.obric.aiproactive.ui.model.f) ZeusTransformUtils.preCheckCast(this.L$0, com.obric.aiproactive.ui.model.f.class, "com.obric.memorydata.plugin");
                NowFeedPageFragment.access$setLatestAllState$p(this.this$0, r4);
                if (NowFeedPageFragment.access$getCurrentVisualState$p(this.this$0) == NowVisualState.SLEEP) goto L8;
                NowFeedPageFragment r2 = this.this$0;
                NowFeedPageFragment.access$updateActionButtons(r2, true, NowFeedPageFragment.access$hasHistoryContent(r2));
            L8:
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C10591(NowFeedPageFragment r3, Continuation<? super C10591> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10591(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10591) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10591.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(NowFeedPageFragment.access$getAllViewModel(this.this$0).getAllUiState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C03031(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.NowFeedPageFragment$observePageState$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.NowFeedPageFragment$observePageState$2", f = "NowFeedPageFragment.kt", i = {}, l = {418}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ ProactiveListAdapter $adapter;
        int label;
        final /* synthetic */ NowFeedPageFragment this$0;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.NowFeedPageFragment$observePageState$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/obric/aiproactive/ui/model/FeedPageUiState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.aiproactive.ui.entry.NowFeedPageFragment$observePageState$2$1", f = "NowFeedPageFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<com.obric.aiproactive.ui.model.g, Continuation<? super Unit>, Object> {
            final /* synthetic */ ProactiveListAdapter $adapter;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NowFeedPageFragment this$0;

            AnonymousClass1(NowFeedPageFragment r3, ProactiveListAdapter r4, Continuation<? super AnonymousClass1> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                this.$adapter = r4;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$adapter, r6);
                r0.L$0 = r4;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(com.obric.aiproactive.ui.model.g r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(com.obric.aiproactive.ui.model.g r3, Continuation<? super Unit> r4) {
                return invoke2((com.obric.aiproactive.ui.model.g) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.ui.model.g.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r4);
                com.obric.aiproactive.ui.model.g r5 = (com.obric.aiproactive.ui.model.g) ZeusTransformUtils.preCheckCast(this.L$0, com.obric.aiproactive.ui.model.g.class, "com.obric.memorydata.plugin");
                NowFeedPageFragment.access$setLatestNowState$p(this.this$0, r5);
                this.this$0.renderPageState(r5.b(), r5.c(), this.$adapter);
                NowFeedPageFragment.access$tryHandleStartupInspiration(this.this$0);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass2(NowFeedPageFragment r3, ProactiveListAdapter r4, Continuation<? super AnonymousClass2> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$adapter = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, this.$adapter, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            kotlinx.coroutines.flow.i r9 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(NowFeedPageFragment.access$getNowViewModel(this.this$0).getNowUiState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$adapter, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r9, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.NowFeedPageFragment$observeStartupCoordinator$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.NowFeedPageFragment$observeStartupCoordinator$1", f = "NowFeedPageFragment.kt", i = {}, l = {3755}, m = "invokeSuspend", n = {}, s = {})
    static final class C10601 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ NowFeedPageFragment this$0;

        /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.NowFeedPageFragment$observeStartupCoordinator$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/obric/aiproactive/ui/entry/StartupInspirationCoordinatorState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.aiproactive.ui.entry.NowFeedPageFragment$observeStartupCoordinator$1$1", f = "NowFeedPageFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C03041 extends SuspendLambda implements Function2<ac, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ NowFeedPageFragment this$0;

            C03041(NowFeedPageFragment r3, Continuation<? super C03041> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                C03041 r0 = new C03041(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(ac r3, Continuation<? super Unit> r4) {
                return ((C03041) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C03041.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(ac r3, Continuation<? super Unit> r4) {
                return invoke2((ac) ZeusTransformUtils.preCheckCast(r3, ac.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r3);
                ac r4 = (ac) ZeusTransformUtils.preCheckCast(this.L$0, ac.class, "com.obric.memorydata.plugin");
                NowFeedPageFragment.access$setLatestStartupState$p(this.this$0, r4);
                NowFeedPageFragment.access$tryHandleStartupInspiration(this.this$0);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C10601(NowFeedPageFragment r3, Continuation<? super C10601> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10601(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10601) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10601.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
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
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.this$0.getStartupCoordinatorViewModel().getState(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C03041(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.flow.k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.entry.NowFeedPageFragment$submitUserRequirement$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.entry.NowFeedPageFragment$submitUserRequirement$1", f = "NowFeedPageFragment.kt", i = {}, l = {1523}, m = "invokeSuspend", n = {}, s = {})
    static final class C10621 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.obric.aiproactive.api.x $request;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ NowFeedPageFragment this$0;

        C10621(NowFeedPageFragment r3, com.obric.aiproactive.api.x r4, Continuation<? super C10621> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.$request = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            C10621 r0 = new C10621(this.this$0, this.$request, r6);
            r0.L$0 = r4;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C10621) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10621.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L15
        L13:
            Object r14 = Result.m1421constructorimpl((com.obric.aiproactive.api.z) ZeusTransformUtils.preCheckCast(r13, com.obric.aiproactive.api.z.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
        L17:
            NowFeedPageFragment r3 = this.this$0;
            com.obric.aiproactive.api.x r4 = this.$request;
            Throwable r5 = Result.m1424exceptionOrNullimpl(r14);
            if (r5 == null) goto L20;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r3.getLogTag(), "[UserRequirement] submit failed requestId=" + r4.b() + " errorType=" + r5.getClass().getSimpleName(), null, 4, null);
        L20:
            String r6 = null;
            if (Result.m1427isFailureimpl(r14) == false) goto L23;
            r14 = null;
        L23:
            com.obric.aiproactive.api.z r15 = (com.obric.aiproactive.api.z) ZeusTransformUtils.preCheckCast(r14, com.obric.aiproactive.api.z.class, "com.obric.memorydata.plugin");
            if (this.this$0.isBindingAvailable() == false) goto L26;
            NowFeedPageFragment.access$setUserRequirementSending$p(this.this$0, false);
            if (r15 != null) goto L30;
        L32:
            r2 = false;
        L34:
            if (r2 == false) goto L48;
            if (r15.c() != this.$request.b()) goto L48;
            NowFeedPageFragment.access$getRequirementComposerViewModel(this.this$0).onSubmissionSucceeded();
            String r16 = NowFeedPageFragment.access$getRequirementComposerViewModel(this.this$0).getDraft();
            Editable r7 = this.this$0.getBinding().inputUserRequirement.getVInput().getText();
            if (r7 == null) goto L41;
            r6 = r7.toString();
        L41:
            if (Intrinsics.areEqual(r6, r16) == true) goto L44;
            this.this$0.getBinding().inputUserRequirement.getVInput().setText((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin"));
            this.this$0.getBinding().inputUserRequirement.getVInput().setSelection(r16.length());
        L44:
            if (NowFeedPageFragment.access$getVoiceSubmissionInFlight$p(this.this$0) == false) goto L46;
            NowFeedPageFragment r17 = this.this$0;
            NowFeedPageFragment.access$setUserRequirementInputMode$p(r17, NowFeedPageFragment.access$getVoiceSubmissionReturnMode$p(r17));
        L46:
            NowFeedPageFragment r18 = this.this$0;
            int r8 = R.string.ai_proactive_user_requirement_success;
            String r9 = "ai_proactive_user_requirement_success";
        L51:
            NowFeedPageFragment.access$dismissImeThenShowUserRequirementToast(r18, ZeusTransformUtils.mapRes(r8, TypedValues.Custom.S_STRING, r9));
            NowFeedPageFragment.access$setVoiceSubmissionInFlight$p(this.this$0, false);
            NowFeedPageFragment.access$setVoiceSubmissionReturnMode$p(this.this$0, UserRequirementInputMode.VOICE_READY);
            NowFeedPageFragment.access$updateUserRequirementComposerState(this.this$0);
            return Unit.INSTANCE;
        L48:
            if (NowFeedPageFragment.access$getVoiceSubmissionInFlight$p(this.this$0) == false) goto L50;
            NowFeedPageFragment.access$setUserRequirementInputMode$p(this.this$0, UserRequirementInputMode.TEXT);
            String r19 = NowFeedPageFragment.access$getRequirementComposerViewModel(this.this$0).getDraft();
            this.this$0.getBinding().inputUserRequirement.getVInput().setText((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.memorydata.plugin"));
            this.this$0.getBinding().inputUserRequirement.getVInput().setSelection(r19.length());
        L50:
            r18 = this.this$0;
            r8 = R.string.ai_proactive_user_requirement_failure;
            r9 = "ai_proactive_user_requirement_failure";
            goto L51
        L30:
            if (r15.a() != true) goto L32;
        L26:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r13);
            al r110 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            NowFeedPageFragment r111 = this.this$0;
            com.obric.aiproactive.api.x r10 = this.$request;
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L15
            com.obric.aiproactive.ui.data.b r112 = r111.getRepository();     // Catch: Throwable -> L15
            this.label = 1;     // Catch: Throwable -> L15
            r13 = r112.a(r10, this);     // Catch: Throwable -> L15
            if (r13 != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r14 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L17
        }
    }

    static {
        Companion = new a(null);
    }

    public NowFeedPageFragment() {
        this.avatarOvalOutlineProvider = new c();
        this.proactiveEnabledListener = new $$Lambda$NowFeedPageFragment$GLHy28ovfBD_3sr9lKa6o_alo(this);
        this.pageType = PageType.NOW;
        this.backgroundResId = ZeusTransformUtils.mapRes(R.drawable.bg_ai_proactive_demo_page, "drawable", "bg_ai_proactive_demo_page");
        this.adapterMode = ProactiveListAdapter.Mode.NOW;
        this.nowViewModel$delegate = LazyKt.lazy(new $$Lambda$NowFeedPageFragment$7elTMUjJRengUw2mjDWDYCETMoc(this));
        this.allViewModel$delegate = LazyKt.lazy(new $$Lambda$NowFeedPageFragment$2kUfcz3dwxUNYF6tBJ0Ch3KkxUk(this));
        this.requirementComposerViewModel$delegate = LazyKt.lazy(new $$Lambda$NowFeedPageFragment$TdK2dBYdiFK6JQ264UFrcxO4WAw(this));
        this.guidedPreferenceInterviewStore$delegate = LazyKt.lazy(new $$Lambda$NowFeedPageFragment$bMMqzfwF1rgJCtlpea9kEOIwuXc(this));
        this.latestNowState = new com.obric.aiproactive.ui.model.g(0, true, null, false, 13, null);
        this.latestAllState = new com.obric.aiproactive.ui.model.f(0, true, null, false, null, null, null, null, 253, null);
        this.latestStartupState = new ac(0, null, null, 7, null);
        this.currentVisualState = NowVisualState.SLEEP;
        this.celebrationBatchId = Long.MIN_VALUE;
        this.latestBatchId = Long.MIN_VALUE;
        this.celebrationRecommendations = CollectionsKt.emptyList();
        this.sensingExitRecommendations = CollectionsKt.emptyList();
        this.debugMockRecommendations = CollectionsKt.emptyList();
        this.todaySensingEventsDayAnchor = Long.MIN_VALUE;
        this.lifecycleAgentStatusBarState = j.f6620a.a();
        this.agentStatusBarState = j.f6620a.a();
        this.entryGate = AiProactiveEntryGate.BLOCK;
        this.userRequirementInputMode = UserRequirementInputMode.TEXT;
        this.voiceSubmissionReturnMode = UserRequirementInputMode.VOICE_READY;
        this.requirementInputModePreferences$delegate = LazyKt.lazy(new $$Lambda$NowFeedPageFragment$xz5uqYbqM5XCJ9i6z1lqI4H9tiA(this));
        this.voiceAsrBridgeDelegate = LazyKt.lazy(new $$Lambda$NowFeedPageFragment$f3OGOP2eaugQ8_RNCXrNsxrIuYI(this));
        ActivityResultLauncher<String> r1 = registerForActivityResult((ActivityResultContract) ZeusTransformUtils.preCheckCast(new ActivityResultContracts.RequestPermission(), ActivityResultContract.class, "com.obric.memorydata.plugin"), new $$Lambda$NowFeedPageFragment$9ZbN0Keyfd2Vk0q08TGHkkUJANc(this));
        Intrinsics.checkNotNullExpressionValue(r1, "registerForActivityResult(...)");
        this.recordAudioPermissionLauncher = r1;
        this.sensingUiState = n.b(System.currentTimeMillis(), null, 2, null);
        this.startCenterYOffset = 96.0f;
        this.startAvatarSize = 104.0f;
        this.celebrationWindowFocusChangeListener = new $$Lambda$NowFeedPageFragment$IhfdYEbl7I12tb0a98H4QAcRsMI(this);
        this.defaultTitleColor$delegate = LazyKt.lazy(new $$Lambda$NowFeedPageFragment$wtp4U3LxNeoyWxozAmSv7fp9vMo(this));
        this.primaryTitleColor$delegate = LazyKt.lazy(new $$Lambda$NowFeedPageFragment$Ojm261Aol3FHXHRwZY2xlHy014(this));
        this.tertiaryTextColor$delegate = LazyKt.lazy(new $$Lambda$NowFeedPageFragment$JutCi6uygOzqtckvsfOldpG2w(this));
    }

    public static final /* synthetic */ void access$applyUserRequirementComposerInsets(NowFeedPageFragment r0, WindowInsetsCompat r1, float r2, boolean r3) {
        r0.applyUserRequirementComposerInsets(r1, r2, r3);
    }

    public static final /* synthetic */ void access$continueWakeUp(NowFeedPageFragment r0) {
        r0.continueWakeUp();
    }

    public static final /* synthetic */ void access$dismissImeThenShowUserRequirementToast(NowFeedPageFragment r0, int r1) {
        r0.dismissImeThenShowUserRequirementToast(r1);
    }

    public static final /* synthetic */ void access$ensureTodaySensingEventsStarted(NowFeedPageFragment r0) {
        r0.ensureTodaySensingEventsStarted();
    }

    public static final /* synthetic */ AllFeedViewModel access$getAllViewModel(NowFeedPageFragment r0) {
        return r0.getAllViewModel();
    }

    public static final /* synthetic */ int access$getCurrentAppBarOffset$p(NowFeedPageFragment r0) {
        return r0.currentAppBarOffset;
    }

    public static final /* synthetic */ NowVisualState access$getCurrentVisualState$p(NowFeedPageFragment r0) {
        return r0.currentVisualState;
    }

    public static final /* synthetic */ com.obric.aiproactive.api.g access$getLatestAgentRun$p(NowFeedPageFragment r0) {
        return r0.latestAgentRun;
    }

    public static final /* synthetic */ boolean access$getNowAppBarCollapseEnabled$p(NowFeedPageFragment r0) {
        return r0.nowAppBarCollapseEnabled;
    }

    public static final /* synthetic */ boolean access$getNowListScrollEnabled$p(NowFeedPageFragment r0) {
        return r0.nowListScrollEnabled;
    }

    public static final /* synthetic */ NowFeedViewModel access$getNowViewModel(NowFeedPageFragment r0) {
        return r0.getNowViewModel();
    }

    public static final /* synthetic */ AiProactiveUserRequirementComposerViewModel access$getRequirementComposerViewModel(NowFeedPageFragment r0) {
        return r0.getRequirementComposerViewModel();
    }

    public static final /* synthetic */ boolean access$getVoiceSubmissionInFlight$p(NowFeedPageFragment r0) {
        return r0.voiceSubmissionInFlight;
    }

    public static final /* synthetic */ UserRequirementInputMode access$getVoiceSubmissionReturnMode$p(NowFeedPageFragment r0) {
        return r0.voiceSubmissionReturnMode;
    }

    public static final /* synthetic */ boolean access$hasHistoryContent(NowFeedPageFragment r0) {
        return r0.hasHistoryContent();
    }

    public static final /* synthetic */ void access$renderSensingHeadline(NowFeedPageFragment r0) {
        r0.renderSensingHeadline();
    }

    public static final /* synthetic */ void access$setAvatarFiveTapRequestInFlight$p(NowFeedPageFragment r0, boolean r1) {
        r0.avatarFiveTapRequestInFlight = r1;
    }

    public static final /* synthetic */ void access$setEntryGate$p(NowFeedPageFragment r0, AiProactiveEntryGate r1) {
        r0.entryGate = r1;
    }

    public static final /* synthetic */ void access$setLatestAgentRun$p(NowFeedPageFragment r0, com.obric.aiproactive.api.g r1) {
        r0.latestAgentRun = r1;
    }

    public static final /* synthetic */ void access$setLatestAllState$p(NowFeedPageFragment r0, com.obric.aiproactive.ui.model.f r1) {
        r0.latestAllState = r1;
    }

    public static final /* synthetic */ void access$setLatestNowState$p(NowFeedPageFragment r0, com.obric.aiproactive.ui.model.g r1) {
        r0.latestNowState = r1;
    }

    public static final /* synthetic */ void access$setLatestStartupState$p(NowFeedPageFragment r0, ac r1) {
        r0.latestStartupState = r1;
    }

    public static final /* synthetic */ void access$setSensingRecordCount$p(NowFeedPageFragment r0, int r1) {
        r0.sensingRecordCount = r1;
    }

    public static final /* synthetic */ void access$setSensingUiState$p(NowFeedPageFragment r0, q r1) {
        r0.sensingUiState = r1;
    }

    public static final /* synthetic */ void access$setUserRequirementInputMode$p(NowFeedPageFragment r0, UserRequirementInputMode r1) {
        r0.userRequirementInputMode = r1;
    }

    public static final /* synthetic */ void access$setUserRequirementSending$p(NowFeedPageFragment r0, boolean r1) {
        r0.userRequirementSending = r1;
    }

    public static final /* synthetic */ void access$setVoiceSubmissionInFlight$p(NowFeedPageFragment r0, boolean r1) {
        r0.voiceSubmissionInFlight = r1;
    }

    public static final /* synthetic */ void access$setVoiceSubmissionReturnMode$p(NowFeedPageFragment r0, UserRequirementInputMode r1) {
        r0.voiceSubmissionReturnMode = r1;
    }

    public static final /* synthetic */ void access$setWakeUpInProgress$p(NowFeedPageFragment r0, boolean r1) {
        r0.wakeUpInProgress = r1;
    }

    public static final /* synthetic */ void access$showPendingUserRequirementToastIfImeHidden(NowFeedPageFragment r0, WindowInsetsCompat r1) {
        r0.showPendingUserRequirementToastIfImeHidden(r1);
    }

    public static final /* synthetic */ void access$tryHandleStartupInspiration(NowFeedPageFragment r0) {
        r0.tryHandleStartupInspiration();
    }

    public static final /* synthetic */ void access$updateActionButtons(NowFeedPageFragment r0, boolean r1, boolean r2) {
        r0.updateActionButtons(r1, r2);
    }

    public static final /* synthetic */ void access$updateUserRequirementComposerState(NowFeedPageFragment r0) {
        r0.updateUserRequirementComposerState();
    }

    public static final /* synthetic */ void access$updateUserRequirementInputHeight(NowFeedPageFragment r0, OInputLayout r1, EditText r2) {
        r0.updateUserRequirementInputHeight(r1, r2);
    }

    private static final AllFeedViewModel allViewModel_delegate$lambda$3(NowFeedPageFragment r4) {
        FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "requireActivity(...)");
        return (AllFeedViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r1, ViewModelStoreOwner.class, "com.obric.memorydata.plugin"), (ViewModelProvider.Factory) ZeusTransformUtils.preCheckCast(r4.getViewModelFactory(), ViewModelProvider.Factory.class, "com.obric.memorydata.plugin")).get(AllFeedViewModel.class), AllFeedViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void applyTemporaryCelebrationRecommendations(int r42) {
        Runnable r1 = this.celebrationStartRunnable;
        if (r1 == null) goto L5;
        getBinding().root.removeCallbacks(r1);
    L5:
        this.celebrationStartRunnable = null;
        Runnable r2 = this.celebrationResetRunnable;
        if (r2 == null) goto L8;
        getBinding().root.removeCallbacks(r2);
    L8:
        this.celebrationResetRunnable = null;
        resetSensingExitState();
        this.celebrationActive = false;
        this.celebrationPending = false;
        this.forceSensingAfterCelebration = false;
        long r3 = System.currentTimeMillis();
        this.debugMockBatchId = r3;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(n.a(r42, r3), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        com.obric.aiproactive.ui.model.j.f r7 = (com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin");
        r5.add(com.obric.aiproactive.ui.model.j.f.a(r7, ProactiveRecommendationDto.copy$default(r7.b(), null, null, null, null, null, null, null, null, null, 0, 0.0d, null, null, 2, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 134209535, null), null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null));
        goto L10
    L12:
        this.debugMockRecommendations = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        setProactiveEnabled(true);
        getBinding().appBar.setExpanded(true, false);
        refreshCurrentPage();
    }

    private final void applyTemporaryMockRecommendations(int r4) {
        Runnable r0 = this.celebrationStartRunnable;
        if (r0 == null) goto L5;
        getBinding().root.removeCallbacks(r0);
    L5:
        this.celebrationStartRunnable = null;
        Runnable r1 = this.celebrationResetRunnable;
        if (r1 == null) goto L8;
        getBinding().root.removeCallbacks(r1);
    L8:
        this.celebrationResetRunnable = null;
        resetSensingExitState();
        this.celebrationActive = false;
        this.celebrationPending = false;
        this.forceSensingAfterCelebration = false;
        long r2 = System.currentTimeMillis();
        this.debugMockBatchId = r2;
        this.debugMockRecommendations = n.a(r4, r2);
        setProactiveEnabled(true);
        getBinding().appBar.setExpanded(true, false);
        refreshCurrentPage();
    }

    private final void applyTitleStyle(NowVisualState r4) {
        applyTitleStyle(n.a(r4, getPrimaryTitleColor(), getDefaultTitleColor(), getTertiaryTextColor()));
    }

    private final void applyTitleStyle(r r4) {
        GradientTextView r0 = getBinding().tvAvatarTitle;
        if (ZeusTransformUtils.instanceOf(r0, GradientTextView.class) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L8;
        r0.setSweepColors(r4.a(), r4.b());
    L9:
        updateTitleSweep(r4.c());
        return;
    L8:
        getBinding().tvAvatarTitle.setTextColor(r4.a());
        goto L9
    }

    private final void applyUserRequirementComposerInsets(WindowInsetsCompat r3, float r4, boolean r5) {
        int r0 = WindowInsetsCompat.Type.ime();
        this.navigationBarBottom = r3.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        int r1 = 0;
        if (r5 == false) goto L5;
    L6:
        r1 = RangesKt.coerceAtLeast(r3.getInsets(r0).bottom - this.navigationBarBottom, 0);
    L7:
        updateUserRequirementComposerMargins(r4, this.navigationBarBottom);
        ensureNowListBottomSpacing();
        float r6 = -r1;
        getBinding().requirementComposerBackdrop.setTranslationY(r6);
        getBinding().requirementComposerContainer.setTranslationY(r6);
        getBinding().tvUserRequirementVoiceTip.setTranslationY(r6);
        return;
    L5:
        if (r3.isVisible(r0) == false) goto L7;
        goto L6
    }

    static /* synthetic */ void applyUserRequirementComposerInsets$default(NowFeedPageFragment r0, WindowInsetsCompat r1, float r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.applyUserRequirementComposerInsets(r1, r2, r3);
    }

    private final void applyUserRequirementComposerMaterials() {
        if (isBindingAvailable() == true) goto L32;
        return;
    L32:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        if (OMaterialHelper.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((NowFeedPageFragment) ZeusTransformUtils.preCheckCast(this, NowFeedPageFragment.class, "com.obric.memorydata.plugin")).requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L9;
    L11:
        boolean r1 = false;
    L12:
        Object r2 = Result.m1421constructorimpl(Boolean.valueOf(r1));     // Catch: Throwable -> L14
    L17:
        if (Result.m1427isFailureimpl(r2) == false) goto L20;
        r2 = false;
    L20:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L23;
        restoreUserRequirementComposerFallbackBackgrounds();
        return;
    L23:
        View r3 = getBinding().requirementComposerBackdrop;
        Intrinsics.checkNotNullExpressionValue(r3, "requirementComposerBackdrop");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L26
        NowFeedPageFragment r4 = (NowFeedPageFragment) ZeusTransformUtils.preCheckCast(this, NowFeedPageFragment.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        r3.setBackground(null);     // Catch: Throwable -> L26
        OMaterialHelper.a(r3, new com.obric.oui.material.c(null, null, OMaterialHelper.a(ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.array.ai_proactive_requirement_backdrop_blur_colors, "array", "ai_proactive_requirement_backdrop_blur_colors"), ZeusTransformUtils.mapRes(R.array.ai_proactive_requirement_backdrop_blur_blend_modes, "array", "ai_proactive_requirement_backdrop_blur_blend_modes")), null, null, null, new com.obric.oui.blur.a(BlurToken.Blur_Progress_Regular, 2, 0.0f, 6, 0.0f, 20, null), null, null, null, 955, null), 5);     // Catch: Throwable -> L26
        OMaterialHelper.a(r3, r3);     // Catch: Throwable -> L26
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L36;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[UserRequirement] apply OUI material failed errorType=" + r7.getClass().getSimpleName(), null, 4, null);
        clearUserRequirementComposerMaterials();
        restoreUserRequirementComposerFallbackBackgrounds();
        return;
    L36:
        return;
    L26:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L28
    L9:
        if (OMaterialHelper.d() == false) goto L11;
        r1 = true;
    L14:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    private final void applyVisualConfig(s r10) {
        debugLayoutWarning("applyVisualConfig state=" + this.currentVisualState + " rootInLayout=" + getBinding().root.isInLayout() + " avatarSize=" + r10.a() + " centerYOffset=" + r10.b());
        updateAvatarLayout(r10.a(), r10.b());
        updateAvatarTextLayout(r10.c(), r10.d(), r10.e(), r10.f(), r10.g(), r10.h());
        updateHeaderBottomPadding(r10.i());
        updateNowListTopPadding();
    }

    private final CharSequence buildSensingHeadlineText(String r8) {
        Integer r0 = n.a(r8);
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        SpannableString r2 = new SpannableString((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r1 <= 0) goto L10;
        r2.setSpan(new ForegroundColorSpan(withAlphaFraction(getPrimaryTitleColor(), SENSING_HEADLINE_TEXT_ALPHA)), 0, r1, 33);
    L10:
        if (r1 >= r8.length()) goto L13;
        r2.setSpan(new ForegroundColorSpan(getPrimaryTitleColor()), r1, r8.length(), 33);
    L13:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
    L5:
        r1 = r8.length();
        goto L6
    }

    private final int calculateSensingHeadlineTextMaxWidth() {
        return RangesKt.coerceAtLeast((int) (ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().widthPixels - (ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density * 68.0f)), 0);
    }

    private final boolean canOpenHistoryPage() {
        return hasHistoryContent();
    }

    private final boolean canResetNowViewportForCurrentState() {
        NowVisualState r0 = this.currentVisualState;
        int r1 = b.f6586b[r0.ordinal()];
        if (r1 != 1) goto L5;
        ProactiveListAdapter r5 = this.adapterRef;
        if (r5 == null) goto L17;
        List<com.obric.aiproactive.ui.model.j> r6 = r5.b();
    L18:
        if (r6 != null) goto L20;
        r6 = CollectionsKt.emptyList();
    L20:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L23;
    L25:
        Iterator r8 = r7.iterator();
    L27:
        if (r8.hasNext() == false) goto L37;
        if (ZeusTransformUtils.instanceOf((com.obric.aiproactive.ui.model.j) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.aiproactive.ui.model.j.class, "com.obric.memorydata.plugin"), com.obric.aiproactive.ui.model.j.c.class) == false) goto L27;
    L35:
        return true;
    L37:
        return false;
    L23:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L25;
        return false;
    L17:
        r6 = null;
        goto L18
    L5:
        if (r1 == 2) goto L35;
        if (r1 != 3) goto L9;
        return false;
    L9:
        if (r1 == 4) goto L35;
        throw new NoWhenBranchMatchedException();
    }

    private final boolean cancelCelebrationForReplacement(List<com.obric.aiproactive.ui.model.j.f> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.celebrationRecommendations, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.add(((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).b().getInspirationId());
        goto L4
    L6:
        List r3 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L11;
        r4.add(((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).b().getInspirationId());
        goto L8
    L11:
        if (m.a(r3, (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), this.celebrationPending, this.celebrationActive) == true) goto L13;
        return false;
    L13:
        cancelCelebrationState("stale_batch", false);
        return true;
    }

    private final void cancelCelebrationState(String r8, boolean r9) {
        if (this.celebrationPending == false) goto L5;
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[NowPage] cancel celebration state reason=" + r8, false, 4, null);
        Runnable r10 = this.celebrationStartRunnable;
        if (r10 == null) goto L16;
        getBinding().root.removeCallbacks(r10);
    L16:
        this.celebrationStartRunnable = null;
        Runnable r0 = this.celebrationResetRunnable;
        if (r0 == null) goto L19;
        getBinding().root.removeCallbacks(r0);
    L19:
        this.celebrationResetRunnable = null;
        this.celebrationAppBarExpansionRequested = false;
        this.celebrationPending = false;
        this.celebrationActive = false;
        this.forceSensingAfterCelebration = r9;
        this.celebrationRecommendations = CollectionsKt.emptyList();
        refreshGuidedPreferenceEntryVisibility$default(this, false, 1, null);
        return;
    L5:
        if (this.celebrationActive == true) goto L13;
        if (this.celebrationStartRunnable != null) goto L13;
        if (this.celebrationResetRunnable != null) goto L13;
        if (this.celebrationRecommendations.isEmpty() == false) goto L13;
    }

    static /* synthetic */ void cancelCelebrationState$default(NowFeedPageFragment r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.cancelCelebrationState(r1, r2);
    }

    private final void cancelUserRequirementVoiceSession(boolean r2) {
        if (isBindingAvailable() == false) goto L5;
        clearVoiceStartRunnable();
    L7:
        if (this.voiceAsrBridgeDelegate.isInitialized() == false) goto L9;
        getVoiceAsrBridge().c();
    L9:
        this.voicePressActive = false;
        this.voicePressStarted = false;
        this.voicePressStartedFromTextInput = false;
        this.voiceAwaitingResult = false;
        this.pendingVoiceModeEntry = false;
        if (r2 == false) goto L13;
        this.userRequirementInputMode = UserRequirementInputMode.TEXT;
    L13:
        if (isBindingAvailable() == false) goto L16;
        updateUserRequirementComposerState();
        return;
    L16:
        return;
    L5:
        this.voiceStartRunnable = null;
        goto L7
    }

    private static final void celebrationWindowFocusChangeListener$lambda$12(NowFeedPageFragment r1, boolean r2) {
        if (r1.isBindingAvailable() == true) goto L5;
        return;
    L5:
        if (r2 == true) goto L7;
        r1.pauseCelebrationUntilForeground();
        return;
    L7:
        if (r1.celebrationPending == false) goto L11;
        r1.scheduleCelebrationPendingCheck();
        return;
    }

    private final void clearPendingCollapseEvaluation() {
        Runnable r0 = this.collapseEvaluationFirstPassRunnable;
        if (r0 == null) goto L5;
        getBinding().recyclerView.removeCallbacks(r0);
    L5:
        this.collapseEvaluationFirstPassRunnable = null;
        Runnable r1 = this.collapseEvaluationSecondPassRunnable;
        if (r1 == null) goto L8;
        getBinding().recyclerView.removeCallbacks(r1);
    L8:
        this.collapseEvaluationSecondPassRunnable = null;
        this.collapseEvaluationPosted = false;
        this.collapseMeasurementRetryCount = 0;
    }

    private final void clearTemporaryMockRecommendations() {
        Runnable r0 = this.celebrationStartRunnable;
        if (r0 == null) goto L5;
        getBinding().root.removeCallbacks(r0);
    L5:
        this.celebrationStartRunnable = null;
        Runnable r1 = this.celebrationResetRunnable;
        if (r1 == null) goto L8;
        getBinding().root.removeCallbacks(r1);
    L8:
        this.celebrationResetRunnable = null;
        resetSensingExitState();
        this.celebrationActive = false;
        this.celebrationPending = false;
        this.forceSensingAfterCelebration = false;
        this.celebrationRecommendations = CollectionsKt.emptyList();
        this.debugMockRecommendations = CollectionsKt.emptyList();
        this.debugMockBatchId = 0;
        getBinding().appBar.setExpanded(true, false);
        refreshCurrentPage();
    }

    private final void clearUserRequirementComposerMaterials() {
        if (isBindingAvailable() == true) goto L5;
        return;
    L5:
        View r0 = getBinding().requirementComposerBackdrop;
        Intrinsics.checkNotNullExpressionValue(r0, "requirementComposerBackdrop");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        NowFeedPageFragment r3 = (NowFeedPageFragment) ZeusTransformUtils.preCheckCast(this, NowFeedPageFragment.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        OMaterialHelper.b(r0, 0);     // Catch: Throwable -> L8
        OMaterialHelper.a(r0, null);     // Catch: Throwable -> L8
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    }

    private final void clearVoiceStartRunnable() {
        Runnable r0 = this.voiceStartRunnable;
        if (r0 == null) goto L5;
        getBinding().root.removeCallbacks(r0);
    L5:
        this.voiceStartRunnable = null;
    }

    private final void configureAvatarOvalClipping() {
        ProactiveAvatarView r0 = getBinding().videoContainer;
        r0.setOutlineProvider((ViewOutlineProvider) ZeusTransformUtils.preCheckCast(this.avatarOvalOutlineProvider, ViewOutlineProvider.class, "com.obric.memorydata.plugin"));
        r0.setClipToOutline(true);
        r0.addOnLayoutChangeListener($$Lambda$NowFeedPageFragment$ELhh5XdhaMZo2ffM6rmWqS2K8Io.INSTANCE);
        refreshAvatarOvalClipping();
    }

    private static final void configureAvatarOvalClipping$lambda$136$lambda$135(View r0, int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8) {
        r0.invalidateOutline();
    }

    private final void configureAvatarPlayback() {
        getBinding().videoContainer.setPlaybackListener((ProactiveAvatarView.b) ZeusTransformUtils.preCheckCast(new d(this), ProactiveAvatarView.b.class, "com.obric.memorydata.plugin"));
        ProactiveAvatarView r0 = getBinding().videoContainer;
        LifecycleOwner r4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r4, "getViewLifecycleOwner(...)");
        r0.bindLifecycle(r4);
    }

    private final void configureScrollState(boolean r5, boolean r6, boolean r7) {
        if (this.scrollStateConfigured == true) goto L5;
    L11:
        this.scrollStateConfigured = true;
        this.nowListScrollEnabled = r5;
        this.nowAppBarCollapseEnabled = r6;
        this.nowListStickyOverlapEnabled = r7;
        int r1 = 0;
        if (r6 == false) goto L15;
        if (r7 == true) goto L15;
        int r8 = (int) (ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density * STICKY_CHROME_HEIGHT_DP);
    L17:
        if (getBinding().collapsingToolbar.getMinimumHeight() == r8) goto L19;
        getBinding().collapsingToolbar.setMinimumHeight(r8);
    L19:
        ViewGroup.LayoutParams r9 = getBinding().collapsingToolbar.getLayoutParams();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        AppBarLayout.LayoutParams r10 = (AppBarLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r9, AppBarLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        if (r6 == false) goto L22;
        r1 = 3;
    L22:
        r10.a(r1);
        getBinding().collapsingToolbar.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        if (r6 == true) goto L27;
        if (r5 == true) goto L26;
        getBinding().recyclerView.stopScroll();
    L26:
        getBinding().appBar.setExpanded(true, true);
        resetCollapsedVisuals();
    L27:
        updateRecyclerOverlap(0.0f);
        return;
    L15:
        r8 = 0;
        goto L17
    L5:
        if (this.nowListScrollEnabled != r5) goto L11;
        if (this.nowAppBarCollapseEnabled != r6) goto L11;
        if (this.nowListStickyOverlapEnabled != r7) goto L11;
    }

    static /* synthetic */ void configureScrollState$default(NowFeedPageFragment r0, boolean r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = r1;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = r2;
    L8:
        r0.configureScrollState(r1, r2, r3);
    }

    private final void continueWakeUp() {
        setProactiveEnabled(true);
        this.forceSensingAfterCelebration = false;
        this.celebrationActive = false;
        getBinding().appBar.setExpanded(true, false);
        renderCurrentState();
        if (n.a(true ^ ((Collection) ZeusTransformUtils.preCheckCast(currentActiveRecommendations(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        getBinding().recyclerView.post(new $$Lambda$NowFeedPageFragment$fw2qAqBpDD3QXeh7nBZyE3sCjFM(this));
        return;
    }

    private static final void continueWakeUp$lambda$149(NowFeedPageFragment r1) {
        r1.getBinding().recyclerView.scrollToPosition(0);
    }

    private final GradientDrawable createAvatarBorderDrawable(float r3) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        r0.setCornerRadius(r3);
        r0.setColor(0);
        r0.setStroke(RangesKt.coerceAtLeast((int) ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density, 1), Color.argb(15, 0, 0, 0));
        return r0;
    }

    private final List<com.obric.aiproactive.ui.model.j.f> currentActiveRecommendations() {
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.debugMockRecommendations, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L18;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.latestNowState.c(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        Object r1 = r5.next();
        if (ZeusTransformUtils.instanceOf(r1, com.obric.aiproactive.ui.model.j.f.class) == false) goto L7;
        r0.add(r1);
        goto L7
    L12:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L18:
        return this.debugMockRecommendations;
    }

    private final long currentRenderBatchId() {
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.debugMockRecommendations, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        return this.debugMockBatchId;
    L6:
        return this.latestNowState.a();
    }

    private final List<com.obric.aiproactive.ui.model.j> currentRenderItems(List<? extends com.obric.aiproactive.ui.model.j> r4) {
        List<com.obric.aiproactive.ui.model.j> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.debugMockRecommendations, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L5;
        return r5;
    L5:
        return this.debugMockRecommendations;
    }

    private final p currentScrollBehavior() {
        return new p(this.nowListScrollEnabled, this.nowAppBarCollapseEnabled, this.nowListStickyOverlapEnabled);
    }

    private final void debugLayoutWarning(String r7) {
        long r0 = System.currentTimeMillis();
        if ((r0 - this.lastLayoutDebugLogAt) >= 120) goto L5;
        return;
    L5:
        this.lastLayoutDebugLogAt = r0;
        RunLog.INSTANCE.debug(getLogTag(), "[LayoutDebug] " + r7);
    }

    private static final int defaultTitleColor_delegate$lambda$13(NowFeedPageFragment r3) {
        return ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_secondary, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_secondary"));
    }

    private final void disableClipFromButtonAncestors(View r3) {
        if (r3 == null) goto L4;
        ViewParent r2 = r3.getParent();
    L6:
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == false) goto L8;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin")).setClipChildren(false);
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin")).setClipToPadding(false);
        r2 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.memorydata.plugin")).getParent();
        goto L6
    L8:
        return;
    L4:
        r2 = null;
        goto L6
    }

    private final void dismissImeThenShowUserRequirementToast(int r5) {
        this.pendingUserRequirementToastResId = Integer.valueOf(r5);
        getBinding().inputUserRequirement.getVInput().clearFocus();
        WindowInsetsCompat r6 = ViewCompat.getRootWindowInsets((View) ZeusTransformUtils.preCheckCast(getBinding().root, View.class, "com.obric.memorydata.plugin"));
        boolean r0 = true;
        if (r6 != null) goto L5;
    L7:
        r0 = false;
    L8:
        if (r0 == true) goto L11;
        showPendingUserRequirementToastIfImeHidden(r6);
        return;
    L11:
        WindowInsetsControllerCompat r4 = ViewCompat.getWindowInsetsController((View) ZeusTransformUtils.preCheckCast(getBinding().inputUserRequirement, View.class, "com.obric.memorydata.plugin"));
        if (r4 == null) goto L15;
        r4.hide(WindowInsetsCompat.Type.ime());
        return;
    L15:
        return;
    L5:
        if (r6.isVisible(WindowInsetsCompat.Type.ime()) != true) goto L7;
        goto L7
    }

    private final void dismissMorePopover(boolean r2) {
        com.obric.oui.popover.v2.a r0 = this.morePopover;
        if (r0 != null) goto L5;
        return;
    L5:
        this.shouldReportMorePopoverCollapse = r2;
        r0.dismiss();
        if (this.morePopover != r0) goto L9;
        this.morePopover = null;
        return;
    }

    private final void ensureAgentRunStarted() {
        bx r0 = this.agentRunJob;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        r1 = false;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        LifecycleOwner r2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r2, "getViewLifecycleOwner(...)");
        this.agentRunJob = kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r2), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L5:
        if (r0.a() != true) goto L7;
        goto L7
    }

    private final void ensureHistoryPageDataStarted() {
        getAllViewModel().startIfNeeded();
    }

    private final void ensureNowListBottomSpacing() {
        getBinding().recyclerView.setClipToPadding(false);
        getBinding().recyclerView.setPadding(getBinding().recyclerView.getPaddingLeft(), getBinding().recyclerView.getPaddingTop(), getBinding().recyclerView.getPaddingRight(), nowListBottomSafeSpacePx());
    }

    private final void ensureStickyForegroundOrder() {
        getBinding().topCutOff.setTranslationZ(0.0f);
        getBinding().topBlurView.setElevation(0.0f);
        getBinding().topBlurView.setTranslationZ(0.0f);
        getBinding().requirementComposerBackdrop.setTranslationZ(0.0f);
        getBinding().requirementComposerContainer.setTranslationZ(0.0f);
        getBinding().videoContainer.setTranslationZ(0.0f);
        getBinding().topCutOff.bringToFront();
        getBinding().topBlurView.bringToFront();
        getBinding().videoContainer.bringToFront();
        getBinding().btnHistoryContainer.bringToFront();
        getBinding().btnMoreContainer.bringToFront();
        getBinding().requirementComposerBackdrop.bringToFront();
        getBinding().requirementComposerContainer.bringToFront();
    }

    private final void ensureTodaySensingEventsStarted() {
        ensureAgentRunStarted();
        long r0 = n.a(0, null, 3, null);
        if (this.todaySensingEventsStarted == true) goto L5;
    L7:
        bx r3 = this.todaySensingEventsJob;
        if (r3 == null) goto L10;
        bx.a.a(r3, null, 1, null);
    L10:
        this.todaySensingEventsStarted = true;
        this.todaySensingEventsDayAnchor = r0;
        LifecycleOwner r4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r4, "getViewLifecycleOwner(...)");
        this.todaySensingEventsJob = kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r4), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10571(r0, this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L5:
        if (this.todaySensingEventsDayAnchor != r0) goto L7;
    }

    private final void enterUserRequirementVoiceMode() {
        if (isAiVoiceSupportedOnThisDevice() == true) goto L5;
        return;
    L5:
        OEditText r0 = getBinding().inputUserRequirement.getVInput();
        r0.clearFocus();
        WindowInsetsControllerCompat r1 = ViewCompat.getWindowInsetsController((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"));
        if (r1 == null) goto L8;
        r1.hide(WindowInsetsCompat.Type.ime());
    L8:
        this.userRequirementInputMode = UserRequirementInputMode.VOICE_READY;
        getRequirementInputModePreferences().edit().putBoolean(REQUIREMENT_INPUT_MODE_VOICE_KEY, true).apply();
        updateUserRequirementComposerState();
    }

    private final void exitUserRequirementVoiceMode(boolean r4) {
        cancelUserRequirementVoiceSession(true);
        int r2 = 0;
        getRequirementInputModePreferences().edit().putBoolean(REQUIREMENT_INPUT_MODE_VOICE_KEY, false).apply();
        if (r4 == true) goto L5;
        return;
    L5:
        if (isBindingAvailable() == false) goto L13;
        final OEditText r5 = getBinding().inputUserRequirement.getVInput();
        r5.requestFocus();
        Editable r0 = r5.getText();
        if (r0 == null) goto L10;
        r2 = r0.length();
    L10:
        r5.setSelection(r2);
        r5.post(new $$Lambda$NowFeedPageFragment$AhNpr_2fBQLz1bbtwZeY9uHRzWI(this, r5));
        return;
    }

    private static final void exitUserRequirementVoiceMode$lambda$49(NowFeedPageFragment r1, OEditText r2) {
        if (r1.isBindingAvailable() == true) goto L5;
        return;
    L5:
        WindowInsetsControllerCompat r3 = ViewCompat.getWindowInsetsController((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"));
        if (r3 == null) goto L9;
        r3.show(WindowInsetsCompat.Type.ime());
        return;
    }

    private final void finishUserRequirementVoiceRecording(boolean r2) {
        this.voicePressStarted = false;
        if (r2 == false) goto L6;
        getVoiceAsrBridge().c();
        this.userRequirementInputMode = voiceIdleModeAfterCurrentPress();
        this.voicePressStartedFromTextInput = false;
        updateUserRequirementComposerState();
        return;
    L6:
        this.voiceAwaitingResult = true;
        this.userRequirementInputMode = UserRequirementInputMode.VOICE_TRANSCRIBING;
        updateUserRequirementComposerState();
        getVoiceAsrBridge().b();
    }

    private final AllFeedViewModel getAllViewModel() {
        return (AllFeedViewModel) ZeusTransformUtils.preCheckCast(this.allViewModel$delegate.getValue(), AllFeedViewModel.class, "com.obric.memorydata.plugin");
    }

    private final int getDefaultTitleColor() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.defaultTitleColor$delegate.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private final com.obric.aiproactive.ui.preference.k getGuidedPreferenceInterviewStore() {
        return (com.obric.aiproactive.ui.preference.k) ZeusTransformUtils.preCheckCast(this.guidedPreferenceInterviewStore$delegate.getValue(), com.obric.aiproactive.ui.preference.k.class, "com.obric.memorydata.plugin");
    }

    private final NowFeedViewModel getNowViewModel() {
        return (NowFeedViewModel) ZeusTransformUtils.preCheckCast(this.nowViewModel$delegate.getValue(), NowFeedViewModel.class, "com.obric.memorydata.plugin");
    }

    private final int getPrimaryTitleColor() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.primaryTitleColor$delegate.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private final AiProactiveUserRequirementComposerViewModel getRequirementComposerViewModel() {
        return (AiProactiveUserRequirementComposerViewModel) ZeusTransformUtils.preCheckCast(this.requirementComposerViewModel$delegate.getValue(), AiProactiveUserRequirementComposerViewModel.class, "com.obric.memorydata.plugin");
    }

    private final SharedPreferences getRequirementInputModePreferences() {
        return (SharedPreferences) ZeusTransformUtils.preCheckCast(this.requirementInputModePreferences$delegate.getValue(), SharedPreferences.class, "com.obric.memorydata.plugin");
    }

    private final int getTertiaryTextColor() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.tertiaryTextColor$delegate.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private final AiVoiceSdkAsrBridge getVoiceAsrBridge() {
        return (AiVoiceSdkAsrBridge) ZeusTransformUtils.preCheckCast(this.voiceAsrBridgeDelegate.getValue(), AiVoiceSdkAsrBridge.class, "com.obric.memorydata.plugin");
    }

    private static Object getVoiceAsrBridge$delegate(NowFeedPageFragment r0) {
        return r0.voiceAsrBridgeDelegate;
    }

    private static final com.obric.aiproactive.ui.preference.k guidedPreferenceInterviewStore_delegate$lambda$5(NowFeedPageFragment r3) {
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireContext(...)");
        return new com.obric.aiproactive.ui.preference.k(r4);
    }

    private final void handleAvatarFiveTapTriggered(long r8) {
        com.obric.aiproactive.ui.util.h.f6884a.b("home", "unlock_screen", "wake_up_doubao");
        this.avatarFiveTapRequestInFlight = true;
        this.lastAvatarFiveTapTriggeredAt = r8;
        ProactiveAvatarView r9 = getBinding().videoContainer;
        Intrinsics.checkNotNullExpressionValue(r9, "videoContainer");
        performLightTapHaptic((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"));
        LifecycleOwner r10 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r10, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r10), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10581(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void handleUserRequirementVoiceFailure(Integer r10) {
        if (isBindingAvailable() == true) goto L5;
        return;
    L5:
        boolean r0 = this.voiceAwaitingResult;
        this.voicePressActive = false;
        this.voicePressStarted = false;
        this.voiceAwaitingResult = false;
        this.userRequirementInputMode = voiceIdleModeAfterCurrentPress();
        this.voicePressStartedFromTextInput = false;
        updateUserRequirementComposerState();
        com.obric.oui.toast.a.C0786a r3 = com.obric.oui.toast.a.f14807a;
        FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "requireActivity(...)");
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(r1, Context.class, "com.obric.memorydata.plugin");
        if (r0 == false) goto L9;
        if (r10 != null) goto L9;
        int r11 = R.string.ai_proactive_voice_no_speech;
        String r2 = "ai_proactive_voice_no_speech";
    L10:
        String r5 = getString(ZeusTransformUtils.mapRes(r11, TypedValues.Custom.S_STRING, r2));
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        com.obric.oui.toast.a.C0786a.a(r3, r4, r5, 0, 4, null);
        return;
    L9:
        r11 = R.string.ai_proactive_voice_unavailable;
        r2 = "ai_proactive_voice_unavailable";
        goto L10
    }

    private final void handleUserRequirementVoiceSuccess(String r10) {
        if (isBindingAvailable() == true) goto L5;
        return;
    L5:
        this.voicePressActive = false;
        this.voicePressStarted = false;
        this.voiceAwaitingResult = false;
        String r11 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        this.userRequirementInputMode = voiceIdleModeAfterCurrentPress();
        this.voicePressStartedFromTextInput = false;
        updateUserRequirementComposerState();
        com.obric.oui.toast.a.C0786a r3 = com.obric.oui.toast.a.f14807a;
        FragmentActivity r12 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r12, "requireActivity(...)");
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(r12, Context.class, "com.obric.memorydata.plugin");
        String r5 = getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_voice_no_speech, TypedValues.Custom.S_STRING, "ai_proactive_voice_no_speech"));
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        com.obric.oui.toast.a.C0786a.a(r3, r4, r5, 0, 4, null);
        return;
    L12:
        this.voiceSubmissionReturnMode = voiceIdleModeAfterCurrentPress();
        this.voicePressStartedFromTextInput = false;
        this.voiceSubmissionInFlight = true;
        getRequirementComposerViewModel().onDraftChanged(r11);
        updateUserRequirementComposerState();
        submitUserRequirement();
        return;
    L8:
        r1 = false;
        goto L9
    }

    private final boolean handleUserRequirementVoiceTouch(MotionEvent r6, boolean r7) {
        if (isAiVoiceSupportedOnThisDevice() == true) goto L6;
        return false;
    L6:
        if (r7 == true) goto L8;
    L22:
        boolean r2 = false;
    L23:
        if (r7 == false) goto L25;
    L31:
        boolean r3 = false;
    L32:
        if (r7 == true) goto L34;
    L38:
        boolean r4 = false;
    L39:
        if (r2 == true) goto L43;
        if (r3 == true) goto L43;
        if (r4 == true) goto L43;
        return false;
    L43:
        int r5 = r6.getActionMasked();
        if (r5 == 0) goto L79;
        if (r5 != 1) goto L47;
        this.voicePressActive = false;
        clearVoiceStartRunnable();
        boolean r8 = this.voicePressStarted;
        if (r8 == true) goto L70;
        this.voicePressStartedFromTextInput = false;
    L75:
        if (r8 == true) goto L78;
        if (r7 == false) goto L78;
        return false;
    L78:
        return true;
    L70:
        if (this.userRequirementInputMode != UserRequirementInputMode.VOICE_CANCELLING) goto L72;
        boolean r9 = true;
    L73:
        finishUserRequirementVoiceRecording(r9);
        goto L75
    L72:
        r9 = false;
        goto L73
    L47:
        if (r5 != 2) goto L49;
        this.voicePressRawX = r6.getRawX();
        this.voicePressRawY = r6.getRawY();
        if (this.voicePressStarted == false) goto L63;
        updateUserRequirementVoiceCancellation(r6.getRawX(), r6.getRawY());
    L63:
        if (this.voicePressStarted == true) goto L66;
        if (r7 == false) goto L66;
        return false;
    L66:
        return true;
    L49:
        if (r5 == 3) goto L51;
        return false;
    L51:
        this.voicePressActive = false;
        clearVoiceStartRunnable();
        boolean r10 = this.voicePressStarted;
        if (r10 == false) goto L54;
        finishUserRequirementVoiceRecording(true);
    L55:
        if (r10 == true) goto L58;
        if (r7 == false) goto L58;
        return false;
    L58:
        return true;
    L54:
        this.voicePressStartedFromTextInput = false;
        goto L55
    L79:
        this.voicePressActive = true;
        this.voicePressStarted = false;
        this.voicePressStartedFromTextInput = r7;
        this.voiceAwaitingResult = false;
        this.voicePressRawX = r6.getRawX();
        this.voicePressRawY = r6.getRawY();
        clearVoiceStartRunnable();
        Runnable r11 = new $$Lambda$NowFeedPageFragment$0z_21DGuhdQRu1qmvt2GiMpNR4(this);
        ConstraintLayout r1 = getBinding().root;
        if (r7 == false) goto L82;
        long r12 = 300;
    L83:
        r1.postDelayed(r11, r12);
        this.voiceStartRunnable = r11;
        return !r7;
    L82:
        r12 = 150;
        goto L83
    L34:
        if (this.voicePressStarted == false) goto L38;
        if (this.voicePressStartedFromTextInput == false) goto L38;
        r4 = true;
        goto L39
    L25:
        if (this.userRequirementInputMode != UserRequirementInputMode.VOICE_READY) goto L27;
    L30:
        r3 = true;
        goto L32
    L27:
        if (this.userRequirementInputMode == UserRequirementInputMode.VOICE_RECORDING) goto L30;
        if (this.userRequirementInputMode != UserRequirementInputMode.VOICE_CANCELLING) goto L31;
    L8:
        if (this.userRequirementInputMode != UserRequirementInputMode.TEXT) goto L22;
        if (this.userRequirementSending == true) goto L22;
        Editable r13 = getBinding().inputUserRequirement.getVInput().getText();
        if (r13 != null) goto L14;
    L19:
        boolean r14 = false;
    L20:
        if (r14 == false) goto L22;
        r2 = true;
        goto L23
    L14:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L16;
        boolean r15 = true;
    L17:
        if (r15 != true) goto L19;
        r14 = true;
        goto L20
    L16:
        r15 = false;
        goto L17
    }

    private static final void handleUserRequirementVoiceTouch$lambda$50(NowFeedPageFragment r1) {
        if (r1.voicePressActive == true) goto L5;
        return;
    L5:
        if (r1.isBindingAvailable() == false) goto L9;
        r1.startUserRequirementVoiceRecording();
        return;
    }

    private final boolean hasGuidedPreferenceEntry() {
        ProactiveListAdapter r4 = this.adapterRef;
        if (r4 == null) goto L5;
        List<com.obric.aiproactive.ui.model.j> r5 = r4.b();
    L6:
        if (r5 != null) goto L8;
        r5 = CollectionsKt.emptyList();
    L8:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L11;
    L13:
        Iterator r7 = r6.iterator();
    L15:
        if (r7.hasNext() == false) goto L24;
        if (ZeusTransformUtils.instanceOf((com.obric.aiproactive.ui.model.j) ZeusTransformUtils.preCheckCast(r7.next(), com.obric.aiproactive.ui.model.j.class, "com.obric.memorydata.plugin"), com.obric.aiproactive.ui.model.j.c.class) == false) goto L15;
        return true;
    L24:
        return false;
    L11:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L13;
        return false;
    L5:
        r5 = null;
        goto L6
    }

    private final boolean hasHistoryContent() {
        return n.a(currentActiveRecommendations(), this.celebrationRecommendations, this.debugMockRecommendations, this.latestAllState, this.sensingRecordCount);
    }

    private final void installCollapseStateLayoutObservers() {
        View.OnLayoutChangeListener r0 = new $$Lambda$NowFeedPageFragment$wSmRUIBaYct2I0NIu_A8scKEDQQ(this);
        getBinding().root.addOnLayoutChangeListener(r0);
        getBinding().appBar.addOnLayoutChangeListener(r0);
        getBinding().recyclerView.addOnLayoutChangeListener(r0);
    }

    private static final void installCollapseStateLayoutObservers$lambda$93(NowFeedPageFragment r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if (r2 != r6) goto L7;
        if (r3 != r7) goto L7;
        if (r4 != r8) goto L7;
        if (r5 != r9) goto L7;
        return;
    L7:
        r0.requestCollapseStateReevaluation("layout_changed");
    }

    private final int interpolateRequirementComposerMargin(int r1, int r2, float r3) {
        return (int) (r1 + ((r2 - r1) * r3));
    }

    private final boolean isAiVoiceSupportedOnThisDevice() {
        if (Build.VERSION.SDK_INT < 31) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean isRecyclerTopItemSettled() {
        RecyclerView.Adapter r0 = getBinding().recyclerView.getAdapter();
        if (r0 != null) goto L6;
        return true;
    L6:
        if (r0.d() != 0) goto L8;
        return true;
    L8:
        RecyclerView.h r1 = getBinding().recyclerView.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r1, LinearLayoutManager.class) == false) goto L11;
        LinearLayoutManager r2 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r1, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L12:
        if (r2 != null) goto L15;
        return true;
    L15:
        if (r2.x() != 0) goto L18;
        return false;
    L18:
        if (r2.o() == 0) goto L20;
        return false;
    L20:
        View r3 = r2.c(0);
        if (r3 != null) goto L23;
        return false;
    L23:
        int r4 = RangesKt.coerceAtLeast((int) (ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density * 2.0f), 1);
        if (Math.abs(r2.i(r3) - getBinding().recyclerView.getPaddingTop()) > r4) goto L27;
        return true;
    L27:
        return false;
    L11:
        r2 = null;
        goto L12
    }

    private final boolean isScreenInteractive() {
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return false;
    L5:
        PowerManager r4 = (PowerManager) ZeusTransformUtils.preCheckCast(ContextCompat.getSystemService(r3, PowerManager.class), PowerManager.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L9;
        return false;
    L9:
        return r4.isInteractive();
    }

    /* JADX INFO: renamed from: lambda$0-z_21DGuhdQRu1qmvt2GiMpNR4, reason: not valid java name */
    public static /* synthetic */ void m268lambda$0z_21DGuhdQRu1qmvt2GiMpNR4(NowFeedPageFragment r0) {
        handleUserRequirementVoiceTouch$lambda$50(r0);
    }

    public static /* synthetic */ void lambda$0VEdh1d1T2ifAD1f4pQeAU40Jwo(NowFeedPageFragment r0, String r1) {
        resetNowViewportToTop$lambda$99(r0, r1);
    }

    public static /* synthetic */ void lambda$0VJ5P28672KSAiU59_g2OxxMoME(NowFeedPageFragment r0, TextSwitcher r1, float r2) {
        updateAvatarTextLayout$lambda$110$lambda$109(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$1JsKTNHkFUAmH0miS_0P8WqFCys(NowFeedPageFragment r0, View r1, MotionEvent r2) {
        return setupUserRequirementComposer$lambda$48(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$2aWIWThfm5SC2Dj53Nx1_PD4_1A(NowFeedPageFragment r0, String r1, int r2, boolean r3) {
        scheduleNowViewportResetRetry$lambda$98(r0, r1, r2, r3);
    }

    public static /* synthetic */ AllFeedViewModel lambda$2kUfcz3dwxUNYF6tBJ0Ch3KkxUk(NowFeedPageFragment r0) {
        return allViewModel_delegate$lambda$3(r0);
    }

    public static /* synthetic */ void lambda$37Iqrcpf_73JO7lyb9TIwhuZ_8Y(NowFeedPageFragment r0) {
        resolveScrollBehaviorForCurrentContent$lambda$102(r0);
    }

    public static /* synthetic */ void lambda$7_pXnn0Qs8mq6OopZ6akdGtIn7Q(NowFeedPageFragment r0, int r1) {
        resetNowViewportAfterCelebrationIfNeeded$lambda$126(r0, r1);
    }

    public static /* synthetic */ NowFeedViewModel lambda$7elTMUjJRengUw2mjDWDYCETMoc(NowFeedPageFragment r0) {
        return nowViewModel_delegate$lambda$2(r0);
    }

    public static /* synthetic */ void lambda$7sWh_3bOLZHmcUf6XH2lKAQ1cPU(NowFeedPageFragment r0) {
        restoreNowPageFromStickyAvatar$lambda$70(r0);
    }

    /* JADX INFO: renamed from: lambda$92a-_75I0j1Qup5M4NleFyukwe4, reason: not valid java name */
    public static /* synthetic */ void m269lambda$92a_75I0j1Qup5M4NleFyukwe4(NowFeedPageFragment r0) {
        scheduleNowViewportReset$lambda$97$lambda$96(r0);
    }

    public static /* synthetic */ void lambda$9ZbN0Keyfd2Vk0q08TGHkkUJANc(NowFeedPageFragment r0, Boolean r1) {
        recordAudioPermissionLauncher$lambda$11(r0, r1);
    }

    public static /* synthetic */ void lambda$AhNpr_2fBQLz1bbtwZeY9uHRzWI(NowFeedPageFragment r0, OEditText r1) {
        exitUserRequirementVoiceMode$lambda$49(r0, r1);
    }

    public static /* synthetic */ Unit lambda$B1oiU70aLRCcmqjwrI4cwQsJkfg(NowFeedPageFragment r0, String r1) {
        return startUserRequirementVoiceRecording$lambda$54(r0, r1);
    }

    public static /* synthetic */ void lambda$ELhh5XdhaMZo2ffM6rmWqS2K8Io(View r0, int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8) {
        configureAvatarOvalClipping$lambda$136$lambda$135(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ void lambda$Efg2xbsJ50nN5o4LqnO1sk9Kp30(NowFeedPageFragment r0, View r1) {
        setupStaticViews$lambda$37(r0, r1);
    }

    public static /* synthetic */ void lambda$Fk7JgbN7EWG4xB0JwQwSBSohb0w(NowFeedPageFragment r0) {
        setupUserRequirementComposer$lambda$40(r0);
    }

    public static /* synthetic */ Unit lambda$Fxfm21L67p0EZe6ROzxbkK5MxbY(NowFeedPageFragment r0, Function0 r1) {
        return playNowCardsExitAnimation$lambda$124(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$GLHy28-o-vfBD_3sr9lKa6o_alo, reason: not valid java name */
    public static /* synthetic */ void m270lambda$GLHy28ovfBD_3sr9lKa6o_alo(NowFeedPageFragment r0, boolean r1) {
        proactiveEnabledListener$lambda$1(r0, r1);
    }

    public static /* synthetic */ void lambda$IhfdYEbl7I12tb0a98H4QAcRsMI(NowFeedPageFragment r0, boolean r1) {
        celebrationWindowFocusChangeListener$lambda$12(r0, r1);
    }

    public static /* synthetic */ void lambda$Ipykttopw3Wn2NFfOKvh1Xu1MNw(NowFeedPageFragment r0) {
        scheduleNowViewportReset$lambda$97(r0);
    }

    /* JADX INFO: renamed from: lambda$JutCi6uyg-OzqtckvsfOl-dpG2w, reason: not valid java name */
    public static /* synthetic */ int m271lambda$JutCi6uygOzqtckvsfOldpG2w(NowFeedPageFragment r0) {
        return tertiaryTextColor_delegate$lambda$15(r0);
    }

    public static /* synthetic */ void lambda$KPqn4_NcksRKHEV1vJKUicxXfqY(NowFeedPageFragment r0) {
        scheduleCelebrationPendingCheck$lambda$116(r0);
    }

    public static /* synthetic */ Unit lambda$KjHTIqJ7ODVGEaIpWhPTkfXQmUs(NowFeedPageFragment r0, byte[] r1) {
        return startUserRequirementVoiceRecording$lambda$53(r0, r1);
    }

    public static /* synthetic */ void lambda$LjO1BhQNPww0b5wsBt7UlmnULXg(NowFeedPageFragment r0, com.obric.oui.popover.v2.a r1) {
        showMorePopup$lambda$76(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$LtXfdmNTyF2cZaCjx-1mAnstfnc, reason: not valid java name */
    public static /* synthetic */ void m272lambda$LtXfdmNTyF2cZaCjx1mAnstfnc(NowFeedPageFragment r0, View r1) {
        setupStaticViews$lambda$32(r0, r1);
    }

    public static /* synthetic */ void lambda$NBVTSpK6kGLDwYa7y1jb8vePLvk(NowFeedPageFragment r0) {
        setupStaticViews$lambda$28(r0);
    }

    public static /* synthetic */ Unit lambda$OA26QHaaUcH1nfs7MVOONoWs20s(NowFeedPageFragment r0) {
        return observePageState$lambda$20(r0);
    }

    /* JADX INFO: renamed from: lambda$OS3vTxeMMEmXiaJ0oOpw-gANpwc, reason: not valid java name */
    public static /* synthetic */ void m273lambda$OS3vTxeMMEmXiaJ0oOpwgANpwc(NowFeedPageFragment r0, View r1) {
        setupStaticViews$lambda$36(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$Ojm261Aol-3FHXHRwZY2xlHy014, reason: not valid java name */
    public static /* synthetic */ int m274lambda$Ojm261Aol3FHXHRwZY2xlHy014(NowFeedPageFragment r0) {
        return primaryTitleColor_delegate$lambda$14(r0);
    }

    public static /* synthetic */ void lambda$P1hB_U1fqssvgqSupNq7Bwp1swk(NowFeedPageFragment r0) {
        tryCompleteCelebrationPending$lambda$114(r0);
    }

    public static /* synthetic */ View lambda$RW7rL6fPSxxXA6PN6G5UsLnzXxA(NowFeedPageFragment r0) {
        return setupStaticViews$lambda$31(r0);
    }

    /* JADX INFO: renamed from: lambda$SjyfvXGFLWq0kcQru-pLIgNprxM, reason: not valid java name */
    public static /* synthetic */ void m275lambda$SjyfvXGFLWq0kcQrupLIgNprxM(NowFeedPageFragment r0) {
        setupStaticViews$lambda$29(r0);
    }

    public static /* synthetic */ void lambda$TLJz3TvCZfE7T_epSQOanngK7Q0(NowFeedPageFragment r0) {
        scheduleCollapseStateEvaluation$lambda$94(r0);
    }

    public static /* synthetic */ AiProactiveUserRequirementComposerViewModel lambda$TdK2dBYdiFK6JQ264UFrcxO4WAw(NowFeedPageFragment r0) {
        return requirementComposerViewModel_delegate$lambda$4(r0);
    }

    /* JADX INFO: renamed from: lambda$VaA8tsguifpkO-Ln9Mmz9Ua5r1M, reason: not valid java name */
    public static /* synthetic */ void m276lambda$VaA8tsguifpkOLn9Mmz9Ua5r1M(NowFeedPageFragment r0, int r1) {
        retryGuidedEntryEnterAfterCelebration$lambda$130(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$Wot_CwbA_pzP8F09ZSDKkCT3-zw, reason: not valid java name */
    public static /* synthetic */ void m277lambda$Wot_CwbA_pzP8F09ZSDKkCT3zw(NowFeedPageFragment r0, OInputLayout r1) {
        setupUserRequirementComposer$lambda$39(r0, r1);
    }

    public static /* synthetic */ void lambda$XFa5CQQmh688uHd4Tz5HbyZYTyM(NowFeedPageFragment r0, int r1, int r2) {
        playGuidedEntryEnterAfterCelebration$lambda$129(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$YFxvkxkmEVpi_Kw9QHCuO3yRZ8g(NowFeedPageFragment r0, View r1) {
        setupUserRequirementComposer$lambda$47(r0, r1);
    }

    public static /* synthetic */ void lambda$_V9A99GsK9y19pw1rhUXh0inZgE(NowFeedPageFragment r0, View r1) {
        proactiveEnabledListener$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ void lambda$_bbCkmTh7t3IlFh5Ie3sIsRBBOA(NowFeedPageFragment r0, View r1) {
        setupStaticViews$lambda$34(r0, r1);
    }

    public static /* synthetic */ void lambda$_hYRuA7K8HhKVLQbogW9TNYiO28(NowFeedPageFragment r0) {
        updateUserRequirementComposerState$lambda$68(r0);
    }

    /* JADX INFO: renamed from: lambda$_uR-RUsNwSH7vTnZxpnbWfmQEb0, reason: not valid java name */
    public static /* synthetic */ Unit m278lambda$_uRRUsNwSH7vTnZxpnbWfmQEb0(NowFeedPageFragment r0, Integer r1) {
        return startUserRequirementVoiceRecording$lambda$55(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$bJb7o8-UD_c8UJ3LUa2A0vsgSj8, reason: not valid java name */
    public static /* synthetic */ void m279lambda$bJb7o8UD_c8UJ3LUa2A0vsgSj8(NowFeedPageFragment r0) {
        setupStaticViews$lambda$27(r0);
    }

    public static /* synthetic */ com.obric.aiproactive.ui.preference.k lambda$bMMqzfwF1rgJCtlpea9kEOIwuXc(NowFeedPageFragment r0) {
        return guidedPreferenceInterviewStore_delegate$lambda$5(r0);
    }

    public static /* synthetic */ Unit lambda$bUaRD9n9VtJXMd0Yl318ReUijrE(NowFeedPageFragment r0, View r1, int r2) {
        return showMorePopup$lambda$74(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$dUBcEvwoZBv7q8nOfgZScy_xS44(NowFeedPageFragment r0, View r1, int r2) {
        return showMorePopup$lambda$73(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$dwHXmEirydurgmmOkW2RLsjhRn8(NowFeedPageFragment r0, AppBarLayout r1, int r2) {
        setupStaticViews$lambda$38(r0, r1, r2);
    }

    public static /* synthetic */ AiVoiceSdkAsrBridge lambda$f3OGOP2eaugQ8_RNCXrNsxrIuYI(NowFeedPageFragment r0) {
        return voiceAsrBridgeDelegate$lambda$10(r0);
    }

    public static /* synthetic */ void lambda$fw2qAqBpDD3QXeh7nBZyE3sCjFM(NowFeedPageFragment r0) {
        continueWakeUp$lambda$149(r0);
    }

    /* JADX INFO: renamed from: lambda$heo-_gqMW_WWl6I_ByCWN0RMg8k, reason: not valid java name */
    public static /* synthetic */ void m280lambda$heo_gqMW_WWl6I_ByCWN0RMg8k(NowFeedPageFragment r0, View r1) {
        setupUserRequirementComposer$lambda$46(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$jPZ_Y-A2mgMCdVXS-1QLKZnSa2E, reason: not valid java name */
    public static /* synthetic */ String m281lambda$jPZ_YA2mgMCdVXS1QLKZnSa2E(NowFeedPageFragment r0, int r1) {
        return renderAgentStatusBar$lambda$140(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$jm9-HKwkezoNq7mPy-KxrF7XV3o, reason: not valid java name */
    public static /* synthetic */ Unit m282lambda$jm9HKwkezoNq7mPyKxrF7XV3o(NowFeedPageFragment r0, View r1, int r2) {
        return showMorePopup$lambda$75(r0, r1, r2);
    }

    public static /* synthetic */ WindowInsetsCompat lambda$kGb0E4y1NIGS0_xv6AFfFSj6YRk(Ref.ObjectRef r0, NowFeedPageFragment r1, Ref.BooleanRef r2, int r3, View r4, WindowInsetsCompat r5) {
        return setupUserRequirementComposerInsetsAnimation$lambda$66(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void lambda$kevK2PUjgw6DxVF0Ez9rnElXHEk(NowFeedPageFragment r0, j r1) {
        updateAgentStatusBarState$lambda$139(r0, r1);
    }

    public static /* synthetic */ boolean lambda$mIvqXWK8G55SEPvSYrx5ZRhkPF4(NowFeedPageFragment r0, View r1, MotionEvent r2) {
        return setupUserRequirementComposer$lambda$44$lambda$43(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$nb2bCazuxyH4lRMpgnY_tDjyaGI() {
        return startUserRequirementVoiceRecording$lambda$52();
    }

    /* JADX INFO: renamed from: lambda$o0473cmsOmFs03V18O6-5ygqXbk, reason: not valid java name */
    public static /* synthetic */ void m283lambda$o0473cmsOmFs03V18O65ygqXbk(NowFeedPageFragment r0) {
        maybeStartCelebration$lambda$84(r0);
    }

    public static /* synthetic */ void lambda$q047LcDck83ZKM2zkkDB__mxLo0(Function0 r0) {
        playNowCardsExitAnimation$lambda$125(r0);
    }

    public static /* synthetic */ Unit lambda$qvG7ZnDY9QGp0WZkkkN3rlysLXI(NowFeedPageFragment r0) {
        return maybeRunSensingExitAnimation$lambda$121(r0);
    }

    /* JADX INFO: renamed from: lambda$rXxsJQ0JojNxM259cz-IKzcvrvA, reason: not valid java name */
    public static /* synthetic */ void m284lambda$rXxsJQ0JojNxM259czIKzcvrvA(NowFeedPageFragment r0) {
        setupUserRequirementComposer$lambda$42(r0);
    }

    public static /* synthetic */ void lambda$rY5IQnCWbvQbefxRQcVicf2qGZc(NowFeedPageFragment r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        setupUserRequirementComposer$lambda$41(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: lambda$rp7vUTqZWtWh-dbd-PyHFTEKgxc, reason: not valid java name */
    public static /* synthetic */ Unit m285lambda$rp7vUTqZWtWhdbdPyHFTEKgxc(NowFeedPageFragment r0, View r1, int r2) {
        return showMorePopup$lambda$71(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$sCE3rRVgi__Vdd-mR_U1PNkjdVw, reason: not valid java name */
    public static /* synthetic */ Unit m286lambda$sCE3rRVgi__VddmR_U1PNkjdVw(NowFeedPageFragment r0, com.obric.aiproactive.ui.feedback.d r1) {
        return showFeedbackDialog$lambda$79(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$tOJzJSPhJqCDY1-9K3i74o5BzJE, reason: not valid java name */
    public static /* synthetic */ void m287lambda$tOJzJSPhJqCDY19K3i74o5BzJE(NowFeedPageFragment r0) {
        resolveScrollBehaviorForCurrentContent$lambda$103(r0);
    }

    public static /* synthetic */ Unit lambda$tUt0gMZnDZNFpKjFc86JJ0aZ7tU(NowFeedPageFragment r0) {
        return startCelebrationState$lambda$120$lambda$119(r0);
    }

    public static /* synthetic */ void lambda$u1DrYgCrPmktCnTL4KF_wc2JXow(NowFeedPageFragment r0) {
        updateRecyclerOverlap$lambda$134(r0);
    }

    public static /* synthetic */ void lambda$wSmRUIBaYct2I0NIu_A8scKEDQQ(NowFeedPageFragment r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        installCollapseStateLayoutObservers$lambda$93(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void lambda$wfmVkrCzQtpcu1gfEANFA3gBxZM(NowFeedPageFragment r0) {
        startCelebrationState$lambda$120(r0);
    }

    public static /* synthetic */ int lambda$wtp4U3LxNeoyWxozAmSv7fp9vMo(NowFeedPageFragment r0) {
        return defaultTitleColor_delegate$lambda$13(r0);
    }

    public static /* synthetic */ void lambda$xv8N02Iw68ko9wxiUYzy4OkAd8g(NowFeedPageFragment r0, View r1) {
        playGuidedEntryEnterAfterCelebration$lambda$129$lambda$128(r0, r1);
    }

    public static /* synthetic */ SharedPreferences lambda$xz5uqYbqM5XCJ9i6z1lqI4H9tiA(NowFeedPageFragment r0) {
        return requirementInputModePreferences_delegate$lambda$8(r0);
    }

    /* JADX INFO: renamed from: lambda$y-lPpgdqkmcFvO05BsSwPCUNTlU, reason: not valid java name */
    public static /* synthetic */ void m288lambda$ylPpgdqkmcFvO05BsSwPCUNTlU(NowFeedPageFragment r0, View r1) {
        setupStaticViews$lambda$33(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$yO0hJ5OUCILmqmjC8bCXsKlG-O4, reason: not valid java name */
    public static /* synthetic */ void m289lambda$yO0hJ5OUCILmqmjC8bCXsKlGO4(NowFeedPageFragment r0, OInputLayout r1, OEditText r2) {
        setupUserRequirementComposer$lambda$45(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$yXjZaDdTdgCuBQLA7CepHqRrf_M(NowFeedPageFragment r0, RecyclerView r1, Runnable r2) {
        scheduleCollapseStateEvaluation$lambda$95(r0, r1, r2);
    }

    private final void maybeRunSensingExitAnimation() {
        if (this.sensingExitActive == true) goto L5;
        return;
    L5:
        if (this.sensingExitAnimationQueued == false) goto L7;
        return;
    L7:
        if (this.sensingExitRecommendations.isEmpty() == true) goto L13;
        this.sensingExitAnimationQueued = true;
        playNowCardsExitAnimation(new $$Lambda$NowFeedPageFragment$qvG7ZnDY9QGp0WZkkkN3rlysLXI(this));
        return;
    }

    private static final Unit maybeRunSensingExitAnimation$lambda$121(NowFeedPageFragment r0) {
        r0.resetSensingExitState();
        r0.renderCurrentState();
        return Unit.INSTANCE;
    }

    private final void maybeStartCelebration(List<com.obric.aiproactive.ui.model.j.f> r11, List<com.obric.aiproactive.ui.model.j.f> r12, ProactiveListAdapter r13) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        if (this.forceSensingAfterCelebration == false) goto L5;
        return;
    L5:
        if (this.celebrationActive == false) goto L7;
        return;
    L7:
        if (this.celebrationPending == true) goto L25;
        long r14 = currentRenderBatchId();
        List<com.obric.aiproactive.ui.model.j.f> r0 = m.a(r3, r4);
        if (m.a(this.previousHadPendingRecommendations, r3, r4, r14, this.celebrationBatchId, this.celebrationRecommendations) == true) goto L12;
        return;
    L12:
        this.celebrationBatchId = r14;
        this.celebrationRecommendations = r0;
        r13.a(r0);
        Runnable r15 = this.celebrationStartRunnable;
        if (r15 == null) goto L15;
        getBinding().root.removeCallbacks(r15);
    L15:
        Runnable r16 = this.celebrationResetRunnable;
        if (r16 == null) goto L18;
        getBinding().root.removeCallbacks(r16);
    L18:
        this.celebrationAppBarExpansionRequested = false;
        this.celebrationPending = true;
        this.celebrationActive = false;
        refreshGuidedPreferenceEntryVisibility$default(this, false, 1, null);
        if (shouldAutoReturnTopForCelebration() == false) goto L21;
        getBinding().recyclerView.stopScroll();
        smoothScrollCelebrationListToTop();
    L21:
        this.celebrationStartRunnable = new $$Lambda$NowFeedPageFragment$o0473cmsOmFs03V18O65ygqXbk(this);
        getBinding().root.post(this.celebrationStartRunnable);
        return;
    }

    private static final void maybeStartCelebration$lambda$84(NowFeedPageFragment r0) {
        r0.tryCompleteCelebrationPending();
    }

    private final void maybeStartSensingExitAnimation(List<com.obric.aiproactive.ui.model.j.f> r8, List<com.obric.aiproactive.ui.model.j.f> r9, ProactiveListAdapter r10) {
        List<com.obric.aiproactive.ui.model.j.f> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if (n.a(this.previousHadPendingRecommendations, r11, r12, this.celebrationPending, this.celebrationActive) == true) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[NowPage] start sensing exit animation previous=" + r11.size() + " current=" + r12.size(), false, 4, null);
        Runnable r13 = this.sensingExitResetRunnable;
        if (r13 == null) goto L8;
        getBinding().root.removeCallbacks(r13);
    L8:
        this.sensingExitResetRunnable = null;
        this.sensingExitActive = true;
        this.sensingExitAnimationQueued = false;
        this.sensingExitRecommendations = r11;
        r10.a(r11);
    }

    private final void maybeStartSharedElementTransition(NowVisualState r5) {
        if (isBindingAvailable() == true) goto L5;
        return;
    L5:
        NowVisualState r0 = this.lastRenderedVisualState;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0 != r5) goto L10;
        return;
    L10:
        debugLayoutWarning("beginDelayedTransition prev=" + r0 + " next=" + r5 + " rootInLayout=" + getBinding().root.isInLayout());
        TransitionSet r6 = new TransitionSet();
        ChangeBounds r1 = new ChangeBounds();
        r1.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new FastOutSlowInInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        TransitionSet r7 = r6.addTransition((Transition) ZeusTransformUtils.preCheckCast(r1, Transition.class, "com.obric.memorydata.plugin"));
        ChangeTransform r2 = new ChangeTransform();
        r2.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new FastOutSlowInInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        TransitionSet r8 = r7.addTransition((Transition) ZeusTransformUtils.preCheckCast(r2, Transition.class, "com.obric.memorydata.plugin"));
        Fade r3 = new Fade();
        r3.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new FastOutSlowInInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        TransitionSet r9 = r8.addTransition((Transition) ZeusTransformUtils.preCheckCast(r3, Transition.class, "com.obric.memorydata.plugin")).setDuration(350);
        Intrinsics.checkNotNullExpressionValue(r9, "setDuration(...)");
        TransitionManager.beginDelayedTransition((ViewGroup) ZeusTransformUtils.preCheckCast(getBinding().root, ViewGroup.class, "com.obric.memorydata.plugin"), (Transition) ZeusTransformUtils.preCheckCast(r9, Transition.class, "com.obric.memorydata.plugin"));
    }

    private final void normalizeRequirementInputContainerPadding(OInputLayout r6) {
        r6.setMinimumHeight(0);
        View r0 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.container, OaidModel.KEY_ID, "container"));
        if (r0 == null) goto L5;
        r0.setMinimumHeight(0);
    L5:
        View r7 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.input_container, OaidModel.KEY_ID, "input_container"));
        if (r7 == null) goto L9;
        int r1 = ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.ai_proactive_requirement_input_container_vertical_padding, "dimen", "ai_proactive_requirement_input_container_vertical_padding"));
        r7.setMinimumHeight(0);
        r7.setPaddingRelative(ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.ai_proactive_requirement_input_horizontal_start_padding, "dimen", "ai_proactive_requirement_input_horizontal_start_padding")), r1, ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.ai_proactive_requirement_input_horizontal_end_padding, "dimen", "ai_proactive_requirement_input_horizontal_end_padding")), r1);
        return;
    }

    private final int nowListBottomSafeSpacePx() {
        return ((int) (ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density * NOW_LIST_BOTTOM_SAFE_SPACE_DP)) + this.navigationBarBottom;
    }

    private static final NowFeedViewModel nowViewModel_delegate$lambda$2(NowFeedPageFragment r4) {
        FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "requireActivity(...)");
        return (NowFeedViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r1, ViewModelStoreOwner.class, "com.obric.memorydata.plugin"), (ViewModelProvider.Factory) ZeusTransformUtils.preCheckCast(r4.getViewModelFactory(), ViewModelProvider.Factory.class, "com.obric.memorydata.plugin")).get(NowFeedViewModel.class), NowFeedViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void observeAllPageState() {
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10591(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private static final Unit observePageState$lambda$20(NowFeedPageFragment r0) {
        r0.onGuidedPreferenceEntryClick();
        return Unit.INSTANCE;
    }

    private final void observeStartupCoordinator() {
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10601(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void onAvatarTapped() {
        if (this.avatarFiveTapRequestInFlight == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[NowPage] ignore avatar tap because hidden proactive entry is running", false, 4, null);
        this.avatarTapCount = 0;
        return;
    L6:
        this.avatarTapCount++;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[NowPage] avatar tap count=" + this.avatarTapCount + " visualState=" + this.currentVisualState + " offset=" + this.currentAppBarOffset, false, 4, null);
        if (this.avatarTapCount >= 5) goto L9;
        return;
    L9:
        this.avatarTapCount = 0;
        long r0 = System.currentTimeMillis();
        if ((r0 - this.lastAvatarFiveTapTriggeredAt) >= 120000) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[NowPage] ignore avatar five tap because it is in cooldown", false, 4, null);
        return;
    L13:
        handleAvatarFiveTapTriggered(r0);
    }

    private final void onGuidedPreferenceEntryClick() {
        com.obric.aiproactive.ui.util.h.f6884a.b("home", "unlock_screen", "enter_interview");
        com.obric.aiproactive.ui.preference.h r0 = com.obric.aiproactive.ui.preference.h.f6772a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "requireContext(...)");
        if (r0.a(r1, "now_feed", currentSessionEnterFrom()) == false) goto L12;
        FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, i.class) == false) goto L7;
        i r3 = (i) ZeusTransformUtils.preCheckCast(r2, i.class, "com.obric.memorydata.plugin");
    L8:
        if (r3 == null) goto L10;
        r3.onHomeChildPageOpened("interview");
    L10:
        refreshGuidedPreferenceEntryVisibility$default(this, false, 1, null);
        refreshCurrentPage();
        return;
    L7:
        r3 = null;
        goto L8
    }

    private final void pauseCelebrationUntilForeground() {
        Runnable r0 = this.celebrationStartRunnable;
        if (r0 == null) goto L5;
        getBinding().root.removeCallbacks(r0);
    L5:
        this.celebrationStartRunnable = null;
        if (this.celebrationActive == true) goto L8;
        return;
    L8:
        Runnable r1 = this.celebrationResetRunnable;
        if (r1 == null) goto L11;
        getBinding().root.removeCallbacks(r1);
    L11:
        this.celebrationResetRunnable = null;
        this.celebrationActive = false;
        this.celebrationPending = true;
    }

    private final void performLightTapHaptic(View r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        NowFeedPageFragment r1 = (NowFeedPageFragment) ZeusTransformUtils.preCheckCast(this, NowFeedPageFragment.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L4
        Object r4 = Result.m1421constructorimpl(Boolean.valueOf(r3.performHapticFeedback(3)));     // Catch: Throwable -> L4
    L6:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
        if (r5 == null) goto L12;
        RunLog.INSTANCE.warn(getLogTag(), "[Haptic] performLightTapHaptic failed", r5);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private final boolean performVoiceHaptic(FeedbackType r8) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        NowFeedPageFragment r3 = (NowFeedPageFragment) ZeusTransformUtils.preCheckCast(this, NowFeedPageFragment.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        com.obric.aiagent.product.b.f5974a.a().vibrateFeedback().performVibratorSmtFeedback(r8);     // Catch: Throwable -> L5
        Object r4 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.m1424exceptionOrNullimpl(r4);
        if (r5 == null) goto L24;
        RunLog.INSTANCE.warn(getLogTag(), "[VoiceInput] product haptic failed type=" + r8, r5);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L17
        NowFeedPageFragment r7 = (NowFeedPageFragment) ZeusTransformUtils.preCheckCast(this, NowFeedPageFragment.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r8 != FeedbackType.LONG_PRESS) goto L14;
        int r9 = 0;
    L15:
        Object r10 = Result.m1421constructorimpl(Boolean.valueOf(r7.getBinding().root.performHapticFeedback(r9)));     // Catch: Throwable -> L17
    L20:
        if (Result.m1427isFailureimpl(r10) == false) goto L22;
        r10 = false;
    L22:
        r4 = Boolean.valueOf(((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
        goto L24
    L14:
        r9 = 3;
    L17:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L24:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r4 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final void performVoiceStartHaptic(String r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[VoiceInput] long press haptic source=" + r9 + " performed=" + performVoiceHaptic(FeedbackType.LONG_PRESS), false, 4, null);
    }

    private final void performVoiceStateHaptic() {
        if (this.userRequirementInputMode != UserRequirementInputMode.VOICE_CANCELLING) goto L5;
        boolean r0 = true;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[VoiceInput] cancel boundary haptic entering=" + r0 + " performed=" + performVoiceHaptic(FeedbackType.TICK), false, 4, null);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void playGuidedEntryEnterAfterCelebration(final int r10) {
        if (isBindingAvailable() == true) goto L5;
        return;
    L5:
        ProactiveListAdapter r0 = this.adapterRef;
        if (r0 != null) goto L8;
        return;
    L8:
        Iterator<com.obric.aiproactive.ui.model.j> r1 = r0.b().iterator();
        final int r2 = 0;
    L10:
        if (r1.hasNext() == false) goto L15;
        if (ZeusTransformUtils.instanceOf((com.obric.aiproactive.ui.model.j) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.aiproactive.ui.model.j.class, "com.obric.memorydata.plugin"), com.obric.aiproactive.ui.model.j.c.class) == true) goto L16;
        r2 = r2 + 1;
    L16:
        if (r2 >= 0) goto L19;
        retryGuidedEntryEnterAfterCelebration(r10);
        return;
    L19:
        RecyclerView.h r3 = getBinding().recyclerView.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r3, LinearLayoutManager.class) == false) goto L22;
        LinearLayoutManager r4 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r3, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L23:
        if (r4 != null) goto L25;
        return;
    L25:
        RecyclerView.e r5 = getBinding().recyclerView.getItemAnimator();
        if (getBinding().recyclerView.isComputingLayout() == false) goto L28;
    L37:
        retryGuidedEntryEnterAfterCelebration(r10);
        return;
    L28:
        if (r5 != null) goto L30;
    L32:
        boolean r6 = false;
    L33:
        if (r6 == true) goto L37;
        getBinding().recyclerView.stopScroll();
        getBinding().appBar.setExpanded(true, false);
        resetCollapsedVisuals();
        r4.b(r2, 0);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[NowPage] play guided entry enter after celebration position=" + r2 + " attempt=" + r10, false, 4, null);
        getBinding().recyclerView.postOnAnimation(new $$Lambda$NowFeedPageFragment$XFa5CQQmh688uHd4Tz5HbyZYTyM(this, r2, r10));
        return;
    L30:
        if (r5.c() != true) goto L32;
        r6 = true;
        goto L33
    L22:
        r4 = null;
        goto L23
    L15:
        r2 = -1;
        goto L16
    }

    static /* synthetic */ void playGuidedEntryEnterAfterCelebration$default(NowFeedPageFragment r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        r0.playGuidedEntryEnterAfterCelebration(r1);
    }

    private static final void playGuidedEntryEnterAfterCelebration$lambda$129(final NowFeedPageFragment r4, int r5, int r6) {
        if (r4.isBindingAvailable() == true) goto L5;
        return;
    L5:
        RecyclerView.h r0 = r4.getBinding().recyclerView.getLayoutManager();
        final View r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, LinearLayoutManager.class) == false) goto L8;
        LinearLayoutManager r1 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r0, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L9:
        if (r1 == null) goto L11;
        r2 = r1.c(r5);
    L11:
        if (r2 != null) goto L14;
        r4.retryGuidedEntryEnterAfterCelebration(r6);
        return;
    L14:
        float r7 = RangesKt.coerceAtLeast(ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getDisplayMetrics().density * GUIDED_ENTRY_ENTER_OFFSET_DP, r2.getHeight() * 0.5f);
        r2.animate().cancel();
        r2.setTranslationY(r7);
        r2.setAlpha(0.0f);
        r2.animate().translationY(0.0f).alpha(1.0f).setDuration(300).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new FastOutSlowInInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin")).withEndAction(new $$Lambda$NowFeedPageFragment$xv8N02Iw68ko9wxiUYzy4OkAd8g(r4, r2)).start();
        return;
    L8:
        r1 = null;
        goto L9
    }

    private static final void playGuidedEntryEnterAfterCelebration$lambda$129$lambda$128(NowFeedPageFragment r1, View r2) {
        if (r1.isBindingAvailable() == true) goto L5;
        return;
    L5:
        r2.setTranslationY(0.0f);
        r2.setAlpha(1.0f);
        r1.scheduleNowViewportReset("guided_entry_enter_done", false);
    }

    private final void playNowCardsExitAnimation(Function0<Unit> r14) {
        final Function0 r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r14, Function0.class, "com.obric.memorydata.plugin");
        RecyclerView.h r0 = getBinding().recyclerView.getLayoutManager();
        Integer r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, LinearLayoutManager.class) == false) goto L5;
        LinearLayoutManager r1 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r0, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L6:
        ProactiveListAdapter r2 = this.adapterRef;
        if (r2 == null) goto L9;
        List<com.obric.aiproactive.ui.model.j> r4 = r2.b();
    L10:
        if (r4 != null) goto L13;
        r4 = CollectionsKt.emptyList();
    L13:
        if (r1 == null) goto L23;
        Integer r7 = Integer.valueOf(r1.o());
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue() == (-1)) goto L17;
        boolean r8 = true;
    L18:
        if (r8 == true) goto L21;
        r7 = null;
    L21:
        if (r7 == null) goto L23;
        int r9 = r7.intValue();
    L24:
        if (r1 == null) goto L33;
        Integer r10 = Integer.valueOf(r1.p());
        if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).intValue() == (-1)) goto L28;
        boolean r5 = true;
    L29:
        if (r5 == false) goto L31;
        r3 = r10;
    L31:
        if (r3 == null) goto L33;
        int r6 = r3.intValue();
    L34:
        if (r1 != null) goto L36;
    L50:
        r15.invoke();
        return;
    L36:
        if (r4.isEmpty() == true) goto L50;
        if (r6 < r9) goto L50;
        if (r9 > r6) goto L48;
        int r11 = r9;
    L42:
        View r12 = r1.c(r11);
        if (r12 == null) goto L46;
        r12.animate().translationY(r12.getHeight() * 1.5f).alpha(0.0f).setDuration(300).setStartDelay(((long) (r11 - r9)) * 50).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new FastOutLinearInInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin")).start();
    L46:
        if (r11 == r6) goto L48;
        r11 = r11 + 1;
    L48:
        long r13 = ((((long) RangesKt.coerceAtLeast(r6 - r9, 0)) * 50) + 300) + 50;
        final Function0 r16 = new $$Lambda$NowFeedPageFragment$Fxfm21L67p0EZe6ROzxbkK5MxbY(this, r15);
        getBinding().root.postDelayed(new $$Lambda$NowFeedPageFragment$q047LcDck83ZKM2zkkDB__mxLo0(r16), r13);
        return;
    L28:
        r5 = false;
    L33:
        r6 = r4.size() - 1;
        goto L34
    L17:
        r8 = false;
    L23:
        r9 = 0;
        goto L24
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    private static final Unit playNowCardsExitAnimation$lambda$124(NowFeedPageFragment r2, Function0 r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        if (r2.isBindingAvailable() == false) goto L6;
        r4.invoke();
    L6:
        return Unit.INSTANCE;
    }

    private static final void playNowCardsExitAnimation$lambda$125(Function0 r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    private final void prepareForSecondaryActivity(String r2) {
        cancelCelebrationState(r2, false);
    }

    private static final int primaryTitleColor_delegate$lambda$14(NowFeedPageFragment r3) {
        return ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_primary, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_primary"));
    }

    private static final void proactiveEnabledListener$lambda$1(final NowFeedPageFragment r1, boolean r2) {
        final View r3 = r1.getView();
        if (r3 != null) goto L5;
        return;
    L5:
        r3.post(new $$Lambda$NowFeedPageFragment$_V9A99GsK9y19pw1rhUXh0inZgE(r1, r3));
    }

    private static final void proactiveEnabledListener$lambda$1$lambda$0(NowFeedPageFragment r1, View r2) {
        if (r1.isAdded() == true) goto L5;
        return;
    L5:
        if (r1.getView() != r2) goto L10;
        r1.refreshProactiveEnabledState();
        return;
    }

    private final void queueCelebrationAfterAdopting(com.obric.aiproactive.ui.model.j.f r5) {
        List<com.obric.aiproactive.ui.model.j.f> r6 = m.a(currentActiveRecommendations(), r5.b().getInspirationId());
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        this.celebrationBatchId = currentRenderBatchId();
        this.celebrationRecommendations = r6;
        Runnable r7 = this.celebrationResetRunnable;
        if (r7 == null) goto L8;
        getBinding().root.removeCallbacks(r7);
    L8:
        this.celebrationResetRunnable = null;
        this.celebrationPending = true;
        this.celebrationActive = false;
        this.forceSensingAfterCelebration = false;
        ProactiveListAdapter r2 = this.adapterRef;
        if (r2 == null) goto L11;
        r2.a(this.celebrationRecommendations);
    L11:
        refreshGuidedPreferenceEntryVisibility$default(this, false, 1, null);
        scheduleCelebrationPendingCheck();
    }

    private static final void recordAudioPermissionLauncher$lambda$11(NowFeedPageFragment r6, Boolean r7) {
        r6.voicePermissionRequestInFlight = false;
        boolean r1 = r6.pendingVoiceModeEntry;
        r6.pendingVoiceModeEntry = false;
        if (r6.isAiVoiceSupportedOnThisDevice() == true) goto L5;
        return;
    L5:
        if (r6.isBindingAvailable() == false) goto L14;
        if (r1 == true) goto L9;
        return;
    L9:
        if (r7.booleanValue() == false) goto L11;
        r6.enterUserRequirementVoiceMode();
        return;
    L11:
        com.obric.oui.toast.a.C0786a r0 = com.obric.oui.toast.a.f14807a;
        FragmentActivity r8 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r8, "requireActivity(...)");
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(r8, Context.class, "com.obric.memorydata.plugin");
        String r3 = r6.getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_voice_permission_denied, TypedValues.Custom.S_STRING, "ai_proactive_voice_permission_denied"));
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        com.obric.oui.toast.a.C0786a.a(r0, r2, r3, 0, 4, null);
        return;
    }

    private final void refreshAgentStatusBarState(List<com.obric.aiproactive.ui.model.j.f> r20, List<com.obric.aiproactive.api.p> r21) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        long r5 = System.currentTimeMillis();
        if (this.latestNowState.b() == true) goto L5;
    L7:
        Integer r3 = Integer.valueOf(n.a(r1, r5));
    L8:
        Integer r9 = r3;
        if (r2 == null) goto L13;
        j r4 = n.a(r2, r5, r9);
    L11:
        this.lifecycleAgentStatusBarState = r4;
    L22:
        updateAgentStatusBarState(n.a(this.latestAgentRun, this.lifecycleAgentStatusBarState, r5, 0, r9, 8, null));
        return;
    L13:
        if (this.lifecycleAgentStatusBarState.getType() != NowAgentStatusType.COMPLETED) goto L22;
        if (this.lifecycleAgentStatusBarState.a() <= 0) goto L22;
        if (r9 != null) goto L19;
        r4 = this.lifecycleAgentStatusBarState;
        goto L11
    L19:
        if (r9.intValue() <= 0) goto L21;
        r4 = j.a(this.lifecycleAgentStatusBarState, null, r9.intValue(), 0, 0, 13, null);
        goto L11
    L21:
        r4 = j.f6620a.a();
        goto L11
    L5:
        if (r1.isEmpty() == false) goto L7;
        r3 = null;
        goto L8
    }

    static /* synthetic */ void refreshAgentStatusBarState$default(NowFeedPageFragment r1, List r2, List r3, int r4, Object r5) {
        List<com.obric.aiproactive.ui.model.j.f> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List<com.obric.aiproactive.api.p> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.currentActiveRecommendations();
    L6:
        if ((r4 & 2) == 0) goto L8;
        r7 = null;
    L8:
        r1.refreshAgentStatusBarState(r6, r7);
    }

    private final void refreshAvatarOvalClipping() {
        getBinding().videoContainer.invalidateOutline();
    }

    private final void refreshCollapseStateAfterResume() {
        if (supportsCollapsibleListForCurrentContent() == true) goto L6;
        return;
    L6:
        if (shouldResetNowViewportAfterResume() == false) goto L8;
        scheduleNowViewportReset("resume_intermediate", false);
    L8:
        requestCollapseStateReevaluation("resume");
    }

    private final void refreshCurrentPage() {
        ProactiveListAdapter r0 = this.adapterRef;
        if (r0 == null) goto L6;
        renderPageState(this.latestNowState.b(), this.latestNowState.c(), r0);
    L6:
        if (this.adapterRef != null) goto L9;
        renderCurrentState();
        return;
    }

    private final void refreshGuidedPreferenceEntryVisibility(boolean r4) {
        boolean r0 = m.a(com.obric.aiproactive.ui.preference.k.a(getGuidedPreferenceInterviewStore(), null, 1, null), this.celebrationPending, this.celebrationActive);
        getNowViewModel().setShowGuidedPreferenceEntry(r0, r4);
    }

    static /* synthetic */ void refreshGuidedPreferenceEntryVisibility$default(NowFeedPageFragment r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.refreshGuidedPreferenceEntryVisibility(r1);
    }

    private final void refreshProactiveEnabledState() {
        boolean r0 = getRepository().g();
        if (this.isProactiveEnabled != r0) goto L5;
        return;
    L5:
        if (r0 == true) goto L7;
        resetDisabledProactiveState();
    L7:
        this.isProactiveEnabled = r0;
        getBinding().appBar.setExpanded(true, false);
        renderCurrentState();
    }

    private final void renderAgentStatusBar() {
        applyTitleStyle(n.a(this.agentStatusBarState, getPrimaryTitleColor(), getTertiaryTextColor()));
        GradientTextView r0 = getBinding().tvAvatarTitle;
        j r1 = this.agentStatusBarState;
        String r2 = getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_status_sensing, TypedValues.Custom.S_STRING, "ai_proactive_status_sensing"));
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        String r5 = getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_status_running, TypedValues.Custom.S_STRING, "ai_proactive_status_running"));
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        Function1 r6 = new $$Lambda$NowFeedPageFragment$jPZ_YA2mgMCdVXS1QLKZnSa2E(this);
        String r7 = getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_status_completed_without_suggestions, TypedValues.Custom.S_STRING, "ai_proactive_status_completed_without_suggestions"));
        Intrinsics.checkNotNullExpressionValue(r7, "getString(...)");
        String r8 = getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_status_failed, TypedValues.Custom.S_STRING, "ai_proactive_status_failed"));
        Intrinsics.checkNotNullExpressionValue(r8, "getString(...)");
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(n.a(r1, r2, r5, r6, r7, r8), CharSequence.class, "com.obric.memorydata.plugin"));
        renderSensingHeadline();
    }

    private static final String renderAgentStatusBar$lambda$140(NowFeedPageFragment r3, int r4) {
        String r5 = r3.getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_status_completed_with_suggestions, TypedValues.Custom.S_STRING, "ai_proactive_status_completed_with_suggestions"), new Object[]{Integer.valueOf(r4)});
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        return r5;
    }

    private final void renderAvatar(NowVisualState r2) {
        getBinding().videoContainer.setSource(resolveAvatarSource(r2));
    }

    private final void renderCelebrationState() {
        if (cancelCelebrationForReplacement(currentActiveRecommendations()) == false) goto L6;
        renderCurrentState();
        return;
    L6:
        applyVisualConfig(t.a(NowVisualState.CELEBRATION));
        applyTitleStyle(NowVisualState.CELEBRATION);
        renderAvatar(NowVisualState.CELEBRATION);
        ProactiveListAdapter r0 = this.adapterRef;
        if (r0 == null) goto L9;
        r0.a(this.celebrationRecommendations);
    L9:
        getBinding().emptyContainer.setVisibility(8);
        getBinding().avatarContainer.setVisibility(0);
        getBinding().videoContainer.setVisibility(0);
        getBinding().recyclerView.setVisibility(0);
        getBinding().tvLoading.setVisibility(8);
        getBinding().btnWakeUp.setVisibility(8);
        getBinding().llSingleEvent.setVisibility(0);
        getBinding().tvAvatarTitle.setVisibility(0);
        getBinding().tvAvatarSubtitle.setVisibility(8);
        getBinding().tvAvatarTitle.setAlpha(1.0f);
        getBinding().tvAvatarSubtitle.setAlpha(1.0f);
        getBinding().llSingleEvent.setAlpha(1.0f);
        getBinding().tvAvatarTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_status_celebration, TypedValues.Custom.S_STRING, "ai_proactive_status_celebration"), new Object[]{Integer.valueOf(this.celebrationRecommendations.size())}), CharSequence.class, "com.obric.memorydata.plugin"));
        renderSensingHeadline();
        updateUserRequirementComposerVisibility(true);
        updateActionButtons(true, true);
        scheduleCollapseStateEvaluation();
    }

    private final void renderCurrentState() {
        cancelCelebrationForReplacement(currentActiveRecommendations());
        NowVisualState r0 = resolveVisualState();
        debugLayoutWarning("renderCurrentState next=" + r0 + " prev=" + this.lastRenderedVisualState + " rootInLayout=" + getBinding().root.isInLayout());
        maybeStartSharedElementTransition(r0);
        int r1 = b.f6586b[r0.ordinal()];
        if (r1 != 1) goto L5;
        renderSensingState();
    L16:
        this.lastRenderedVisualState = r0;
        return;
    L5:
        if (r1 != 2) goto L7;
        renderSuggestionState();
        goto L16
    L7:
        if (r1 != 3) goto L9;
        renderSleepState();
        goto L16
    L9:
        if (r1 != 4) goto L12;
        renderCelebrationState();
        goto L16
    L12:
        throw new NoWhenBranchMatchedException();
    }

    private final void renderPostCelebrationGuidedEntry() {
        if (isBindingAvailable() == true) goto L5;
        return;
    L5:
        ProactiveListAdapter r0 = this.adapterRef;
        if (r0 == null) goto L8;
        com.obric.aiproactive.ui.model.g r1 = (com.obric.aiproactive.ui.model.g) ZeusTransformUtils.preCheckCast(getNowViewModel().getNowUiState().c(), com.obric.aiproactive.ui.model.g.class, "com.obric.memorydata.plugin");
        renderPageState(r1.b(), r1.c(), r0);
    L9:
        resetNowViewportAfterCelebrationIfNeeded$default(this, 0, 1, null);
        playGuidedEntryEnterAfterCelebration$default(this, 0, 1, null);
        return;
    L8:
        renderCurrentState();
        goto L9
    }

    private final void renderSensingHeadline() {
        boolean r0 = n.a(this.latestAgentRun, this.agentStatusBarState, this.celebrationActive);
        boolean r1 = n.a(this.agentStatusBarState, this.celebrationActive);
        int r2 = 0;
        if (r0 == true) goto L7;
        if (r1 == true) goto L7;
        boolean r3 = false;
    L8:
        LinearLayout r4 = getBinding().llSingleEvent;
        if (r3 == false) goto L11;
        int r5 = 0;
    L12:
        r4.setVisibility(r5);
        getBinding().llSingleEvent.setClickable(r0);
        getBinding().llSingleEvent.setFocusable(r0);
        ImageView r6 = getBinding().ivSingleEventDirection;
        if (r0 == true) goto L16;
        r2 = 8;
    L16:
        r6.setVisibility(r2);
        if (r3 == true) goto L19;
        return;
    L19:
        j r7 = this.agentStatusBarState;
        boolean r8 = this.celebrationActive;
        String r9 = getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_status_sensing_hint, TypedValues.Custom.S_STRING, "ai_proactive_status_sensing_hint"));
        Intrinsics.checkNotNullExpressionValue(r9, "getString(...)");
        String r10 = getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_agent_entry_running, TypedValues.Custom.S_STRING, "ai_proactive_agent_entry_running"));
        Intrinsics.checkNotNullExpressionValue(r10, "getString(...)");
        String r11 = getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_agent_entry_completed, TypedValues.Custom.S_STRING, "ai_proactive_agent_entry_completed"));
        Intrinsics.checkNotNullExpressionValue(r11, "getString(...)");
        getBinding().tsSingleEvent.setCurrentText(buildSensingHeadlineText(n.a(r7, r8, r9, r10, r11)));
        return;
    L11:
        r5 = 8;
    L7:
        r3 = true;
        goto L8
    }

    private final void renderSensingState() {
        configureScrollState$default(this, false, false, false, 6, null);
        List<com.obric.aiproactive.ui.model.j> r0 = currentRenderItems(this.latestNowState.c());
        if (m.b(r0) == false) goto L5;
    L10:
        boolean r1 = true;
    L11:
        applyVisualConfig(m.a(r1));
        renderAvatar(NowVisualState.SENSING);
        getBinding().emptyContainer.setVisibility(8);
        getBinding().avatarContainer.setVisibility(0);
        getBinding().videoContainer.setVisibility(0);
        if (this.sensingExitActive == false) goto L20;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.sensingExitRecommendations, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        ProactiveListAdapter r2 = this.adapterRef;
        if (r2 == null) goto L18;
        r2.a(this.sensingExitRecommendations);
    L18:
        getBinding().recyclerView.setVisibility(0);
        maybeRunSensingExitAnimation();
    L23:
        getBinding().tvLoading.setVisibility(8);
        getBinding().tvAvatarTitle.setVisibility(0);
        getBinding().tvAvatarSubtitle.setVisibility(8);
        getBinding().tvAvatarTitle.setAlpha(1.0f);
        getBinding().tvAvatarSubtitle.setAlpha(1.0f);
        getBinding().llSingleEvent.setAlpha(1.0f);
        getBinding().btnWakeUp.setVisibility(8);
        getBinding().llSingleEvent.setVisibility(0);
        renderAgentStatusBar();
        renderSensingHeadline();
        updateUserRequirementComposerVisibility(true);
        updateActionButtons(true, hasHistoryContent());
        return;
    L20:
        if (m.a(this.sensingExitActive, this.sensingExitRecommendations.size(), r0) == false) goto L22;
        getBinding().recyclerView.setVisibility(0);
        goto L23
    L22:
        getBinding().recyclerView.setVisibility(8);
        goto L23
    L5:
        if (this.sensingExitActive == true) goto L7;
    L9:
        r1 = false;
        goto L11
    L7:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.sensingExitRecommendations, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L9;
        goto L9
    }

    private final void renderSleepState() {
        configureScrollState$default(this, false, false, false, 6, null);
        applyVisualConfig(t.a(NowVisualState.SLEEP));
        applyTitleStyle(NowVisualState.SLEEP);
        renderAvatar(NowVisualState.SLEEP);
        getBinding().emptyContainer.setVisibility(8);
        getBinding().avatarContainer.setVisibility(0);
        getBinding().videoContainer.setVisibility(0);
        getBinding().recyclerView.setVisibility(8);
        getBinding().tvLoading.setVisibility(8);
        getBinding().llSingleEvent.setVisibility(8);
        getBinding().btnWakeUp.setVisibility(0);
        getBinding().tvAvatarTitle.setVisibility(0);
        getBinding().tvAvatarSubtitle.setVisibility(0);
        getBinding().tvAvatarTitle.setAlpha(1.0f);
        getBinding().tvAvatarSubtitle.setAlpha(1.0f);
        getBinding().llSingleEvent.setAlpha(1.0f);
        getBinding().tvAvatarTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast("休眠中", CharSequence.class, "com.obric.memorydata.plugin"));
        getBinding().tvAvatarSubtitle.setText((CharSequence) ZeusTransformUtils.preCheckCast("唤醒后，豆包会主动理解你的当前情境，并在恰当时间给出你当下最需要关注的内容。", CharSequence.class, "com.obric.memorydata.plugin"));
        updateUserRequirementComposerVisibility(false);
        updateActionButtons(false, false);
    }

    private final void renderSuggestionState() {
        applyVisualConfig(t.a(NowVisualState.SUGGESTION));
        renderAvatar(NowVisualState.SUGGESTION);
        getBinding().emptyContainer.setVisibility(8);
        getBinding().avatarContainer.setVisibility(0);
        getBinding().videoContainer.setVisibility(0);
        getBinding().recyclerView.setVisibility(0);
        getBinding().tvLoading.setVisibility(8);
        getBinding().btnWakeUp.setVisibility(8);
        getBinding().llSingleEvent.setVisibility(0);
        getBinding().tvAvatarTitle.setVisibility(0);
        getBinding().tvAvatarSubtitle.setVisibility(8);
        getBinding().tvAvatarTitle.setAlpha(1.0f);
        getBinding().tvAvatarSubtitle.setAlpha(1.0f);
        getBinding().llSingleEvent.setAlpha(1.0f);
        renderAgentStatusBar();
        renderSensingHeadline();
        updateUserRequirementComposerVisibility(true);
        updateActionButtons(true, hasHistoryContent());
        scheduleCollapseStateEvaluation();
    }

    private final void requestCollapseStateReevaluation(String r5) {
        if (supportsCollapsibleListForCurrentContent() == true) goto L6;
        return;
    L6:
        if (shouldRunCollapseEvaluation() == true) goto L9;
        clearPendingCollapseEvaluation();
        return;
    L9:
        RunLog.INSTANCE.debug(getLogTag(), "[ScrollHeight] request reevaluate reason=" + r5);
        this.collapseEvaluationPosted = false;
        scheduleCollapseStateEvaluation();
    }

    private final void requestUserRequirementVoiceMode() {
        if (isAiVoiceSupportedOnThisDevice() == true) goto L6;
        return;
    L6:
        if (this.voicePermissionRequestInFlight == false) goto L9;
        return;
    L9:
        if (ContextCompat.checkSelfPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "android.permission.RECORD_AUDIO") != 0) goto L12;
        enterUserRequirementVoiceMode();
        return;
    L12:
        this.pendingVoiceModeEntry = true;
        this.voicePermissionRequestInFlight = true;
        this.recordAudioPermissionLauncher.launch("android.permission.RECORD_AUDIO");
    }

    private static final AiProactiveUserRequirementComposerViewModel requirementComposerViewModel_delegate$lambda$4(NowFeedPageFragment r3) {
        return (AiProactiveUserRequirementComposerViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r3, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(AiProactiveUserRequirementComposerViewModel.class), AiProactiveUserRequirementComposerViewModel.class, "com.obric.memorydata.plugin");
    }

    private static final SharedPreferences requirementInputModePreferences_delegate$lambda$8(NowFeedPageFragment r2) {
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(REQUIREMENT_INPUT_MODE_PREFS, 0);
    }

    private final void resetCollapsedVisuals() {
        getBinding().videoContainer.setScaleX(1.0f);
        getBinding().videoContainer.setScaleY(1.0f);
        getBinding().videoContainer.setTranslationX(0.0f);
        getBinding().videoContainer.setTranslationY(0.0f);
        getBinding().topCutOff.setAlpha(0.0f);
        getBinding().topBlurView.setAlpha(0.0f);
        getBinding().tvAvatarTitle.setAlpha(1.0f);
        getBinding().tvAvatarSubtitle.setAlpha(1.0f);
        getBinding().llSingleEvent.setAlpha(1.0f);
        updateRecyclerOverlap(0.0f);
    }

    private final void resetDisabledProactiveState() {
        Runnable r0 = this.celebrationStartRunnable;
        if (r0 == null) goto L5;
        getBinding().root.removeCallbacks(r0);
    L5:
        this.celebrationStartRunnable = null;
        Runnable r1 = this.celebrationResetRunnable;
        if (r1 == null) goto L8;
        getBinding().root.removeCallbacks(r1);
    L8:
        this.celebrationResetRunnable = null;
        resetSensingExitState();
        this.celebrationActive = false;
        this.celebrationPending = false;
        this.forceSensingAfterCelebration = false;
        this.debugMockRecommendations = CollectionsKt.emptyList();
        this.debugMockBatchId = 0;
    }

    private final void resetNowViewportAfterCelebrationIfNeeded(final int r3) {
        if (isBindingAvailable() == true) goto L5;
        return;
    L5:
        ProactiveListAdapter r0 = this.adapterRef;
        if (r0 == null) goto L8;
        List<com.obric.aiproactive.ui.model.j> r1 = r0.b();
    L9:
        if (r1 != null) goto L12;
        r1 = CollectionsKt.emptyList();
    L12:
        if (m.a(r1) == false) goto L16;
        scheduleNowViewportReset("celebration_guided_entry", true);
        return;
    L16:
        if (r3 < 8) goto L18;
        return;
    L18:
        getBinding().recyclerView.postDelayed(new $$Lambda$NowFeedPageFragment$7_pXnn0Qs8mq6OopZ6akdGtIn7Q(this, r3), VIEWPORT_RESET_SHORT_DELAY_MS);
        return;
    L8:
        r1 = null;
        goto L9
    }

    static /* synthetic */ void resetNowViewportAfterCelebrationIfNeeded$default(NowFeedPageFragment r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        r0.resetNowViewportAfterCelebrationIfNeeded(r1);
    }

    private static final void resetNowViewportAfterCelebrationIfNeeded$lambda$126(NowFeedPageFragment r0, int r1) {
        r0.resetNowViewportAfterCelebrationIfNeeded(r1 + 1);
    }

    private final void resetNowViewportToTop(final String r11, boolean r12) {
        if (canResetNowViewportForCurrentState() == true) goto L6;
        return;
    L6:
        if (getBinding().recyclerView.getVisibility() == 0) goto L8;
        return;
    L8:
        RecyclerView.Adapter r0 = getBinding().recyclerView.getAdapter();
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0.d() != 0) goto L14;
        return;
    L14:
        RecyclerView.h r1 = getBinding().recyclerView.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r1, LinearLayoutManager.class) == false) goto L17;
        LinearLayoutManager r2 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r1, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L18:
        if (r2 != null) goto L21;
        return;
    L21:
        if (r12 == false) goto L23;
    L30:
        boolean r4 = true;
    L31:
        if (r4 == true) goto L33;
        return;
    L33:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[NowPage] reset viewport reason=" + r11 + " force=" + r12 + " offset=" + this.currentAppBarOffset + " first=" + r2.o() + " paddingTop=" + getBinding().recyclerView.getPaddingTop(), false, 4, null);
        getBinding().recyclerView.stopScroll();
        getBinding().appBar.setExpanded(true, false);
        resetCollapsedVisuals();
        r2.b(0, 0);
        getBinding().recyclerView.post(new $$Lambda$NowFeedPageFragment$0VEdh1d1T2ifAD1f4pQeAU40Jwo(this, r11));
        return;
    L23:
        if (this.currentAppBarOffset != 0) goto L30;
        if (getBinding().recyclerView.canScrollVertically(-1) == true) goto L30;
        if (isRecyclerTopItemSettled() == false) goto L30;
        r4 = false;
        goto L31
    L17:
        r2 = null;
        goto L18
    }

    private static final void resetNowViewportToTop$lambda$99(NowFeedPageFragment r3, String r4) {
        if (r3.isBindingAvailable() == true) goto L6;
        return;
    L6:
        if (r3.getBinding().recyclerView.canScrollVertically(-1) == false) goto L13;
        RecyclerView.h r0 = r3.getBinding().recyclerView.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r0, LinearLayoutManager.class) == false) goto L10;
        LinearLayoutManager r1 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r0, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L11:
        if (r1 == null) goto L13;
        r1.b(0, 0);
        goto L13
    L10:
        r1 = null;
    L13:
        r3.requestCollapseStateReevaluation("viewport_reset_" + r4);
    }

    private final void resetSensingExitState() {
        Runnable r0 = this.sensingExitResetRunnable;
        if (r0 == null) goto L5;
        getBinding().root.removeCallbacks(r0);
    L5:
        this.sensingExitResetRunnable = null;
        this.sensingExitActive = false;
        this.sensingExitAnimationQueued = false;
        this.sensingExitRecommendations = CollectionsKt.emptyList();
    }

    private final ProactiveAvatarView.c resolveAvatarSource(NowVisualState r4) {
        int r3 = b.f6586b[r4.ordinal()];
        if (r3 == 1) goto L15;
        if (r3 == 2) goto L15;
        if (r3 == 3) goto L17;
        if (r3 != 4) goto L12;
        return new ProactiveAvatarView.c(ZeusTransformUtils.mapRes(R.raw.proactive_celebration, "raw", "proactive_celebration"), ZeusTransformUtils.mapRes(R.drawable.ic_proactive_celebration_frame, "drawable", "ic_proactive_celebration_frame"));
    L12:
        throw new NoWhenBranchMatchedException();
    L17:
        return new ProactiveAvatarView.c(ZeusTransformUtils.mapRes(R.raw.proactive_sleeping, "raw", "proactive_sleeping"), ZeusTransformUtils.mapRes(R.drawable.ic_proactive_sleeping_frame, "drawable", "ic_proactive_sleeping_frame"));
    L15:
        return new ProactiveAvatarView.c(ZeusTransformUtils.mapRes(R.raw.proactive_sensing, "raw", "proactive_sensing"), ZeusTransformUtils.mapRes(R.drawable.ic_proactive_sensing_frame, "drawable", "ic_proactive_sensing_frame"));
    }

    private final s resolveNowVisualConfigForItems(List<com.obric.aiproactive.ui.model.j.f> r4, boolean r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        NowVisualState r3 = m.a(this.entryGate, this.isProactiveEnabled, this.celebrationPending, this.celebrationActive, r6);
        int r7 = b.f6586b[r3.ordinal()];
        if (r7 == 1) goto L15;
        if (r7 == 2) goto L16;
        if (r7 == 3) goto L16;
        if (r7 == 4) goto L16;
        throw new NoWhenBranchMatchedException();
    L16:
        return t.a(r3);
    L15:
        return m.a(r5);
    }

    private final p resolveScrollBehaviorForCurrentContent() {
        boolean r1 = false;
        if (supportsCollapsibleListForCurrentContent() == true) goto L7;
        return new p(false, false, false);
    L7:
        if (getBinding().recyclerView.getVisibility() != 0) goto L9;
        RecyclerView.Adapter r0 = getBinding().recyclerView.getAdapter();
        if (r0 != null) goto L15;
        return new p(false, false, false);
    L15:
        if (r0.d() == 0) goto L17;
        RecyclerView.e r2 = getBinding().recyclerView.getItemAnimator();
        if (r2 != null) goto L21;
    L23:
        boolean r4 = false;
    L24:
        if (r4 == false) goto L28;
        r2.a(new $$Lambda$NowFeedPageFragment$37Iqrcpf_73JO7lyb9TIwhuZ_8Y(this));
        return currentScrollBehavior();
    L28:
        if (getBinding().recyclerView.isComputingLayout() == false) goto L31;
        getBinding().recyclerView.post(new $$Lambda$NowFeedPageFragment$tOJzJSPhJqCDY19K3i74o5BzJE(this));
        return currentScrollBehavior();
    L31:
        RecyclerView.h r3 = getBinding().recyclerView.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r3, LinearLayoutManager.class) == false) goto L34;
        LinearLayoutManager r5 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r3, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L35:
        if (r5 == null) goto L37;
        int r6 = getBinding().root.getHeight() - getBinding().appBar.getHeight();
        com.obric.aiproactive.ui.entry.d r7 = l.a(r6, r5.x(), this.collapseMeasurementRetryCount, 0, 8, null);
        int r8 = b.c[r7.a().ordinal()];
        if (r8 != 1) goto L41;
        this.collapseMeasurementRetryCount = 0;
        int r9 = getBinding().recyclerView.getPaddingTop();
        int r10 = r5.x();
        int r11 = 0;
        int r12 = 0;
    L51:
        if (r11 >= r10) goto L57;
        View r13 = r5.i(r11);
        if (r13 == null) goto L56;
        int r14 = r5.g(r13);
        r9 = r9 + r14;
        r12 = Math.max(r12, r14);
    L56:
        r11 = r11 + 1;
        goto L51
    L57:
        int r15 = r9 + getBinding().recyclerView.getPaddingBottom();
        if (r5.x() < r0.d()) goto L60;
        boolean r16 = true;
    L62:
        if (this.currentVisualState != NowVisualState.SENSING) goto L64;
        r1 = true;
    L64:
        p r17 = n.a(r15, r12, r6, r16, r1);
        RunLog.INSTANCE.debug(getLogTag(), "[ScrollHeight] Result: list=" + r17.a() + ", appbar=" + r17.b() + ", overlap=" + r17.c() + " | totalContentHeight=" + r15 + ", maxItemHeight=" + r12 + ", availableHeight=" + r6 + " (root=" + getBinding().root.getHeight() + ", appBar=" + getBinding().appBar.getHeight() + "), childCount=" + r5.x() + ", itemCount=" + r0.d());
        return r17;
    L60:
        r16 = false;
        goto L62
    L41:
        if (r8 != 2) goto L43;
        this.collapseMeasurementRetryCount = r7.b();
        RunLog.INSTANCE.debug(getLogTag(), "[ScrollHeight] measurement not ready, retry=" + r7.b() + ", availableHeight=" + r6 + ", childCount=" + r5.x());
        this.collapseEvaluationPosted = false;
        scheduleCollapseStateEvaluation(200);
        return currentScrollBehavior();
    L43:
        if (r8 != 3) goto L47;
        this.collapseMeasurementRetryCount = r7.b();
        RunLog.INSTANCE.debug(getLogTag(), "[ScrollHeight] measurement retry exhausted, force enable collapse, availableHeight=" + r6 + ", childCount=" + r5.x());
        return new p(true, true, true);
    L47:
        throw new NoWhenBranchMatchedException();
    L37:
        return new p(false, false, false);
    L34:
        r5 = null;
        goto L35
    L21:
        if (r2.c() != true) goto L23;
        r4 = true;
        goto L24
    L17:
        return new p(false, false, false);
    L9:
        return new p(false, false, false);
    }

    private static final void resolveScrollBehaviorForCurrentContent$lambda$102(NowFeedPageFragment r0) {
        r0.scheduleCollapseStateEvaluation();
    }

    private static final void resolveScrollBehaviorForCurrentContent$lambda$103(NowFeedPageFragment r0) {
        r0.scheduleCollapseStateEvaluation();
    }

    private final NowVisualState resolveVisualState() {
        NowVisualState r0 = m.a(this.entryGate, this.isProactiveEnabled, this.celebrationPending, this.celebrationActive, currentActiveRecommendations());
        this.currentVisualState = r0;
        return r0;
    }

    private final void restoreNowPageFromStickyAvatar() {
        if (this.currentAppBarOffset == 0) goto L5;
        boolean r0 = true;
    L6:
        boolean r3 = getBinding().recyclerView.canScrollVertically(-1);
        if (r0 == true) goto L10;
        if (r3 == true) goto L10;
        return;
    L10:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[NowPage] restore from sticky avatar needExpandAppBar=" + r0 + " needResetList=" + r3, false, 4, null);
        getBinding().recyclerView.stopScroll();
        getBinding().appBar.setExpanded(true, true);
        if (r3 == false) goto L14;
        getBinding().recyclerView.smoothScrollToPosition(0);
        getBinding().recyclerView.post(new $$Lambda$NowFeedPageFragment$7sWh_3bOLZHmcUf6XH2lKAQ1cPU(this));
        return;
    L14:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private static final void restoreNowPageFromStickyAvatar$lambda$70(NowFeedPageFragment r2) {
        RecyclerView.h r3 = r2.getBinding().recyclerView.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r3, LinearLayoutManager.class) == false) goto L5;
        LinearLayoutManager r4 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r3, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 == null) goto L9;
        r4.b(0, 0);
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }

    private final void restoreUserRequirementComposerFallbackBackgrounds() {
        if (isBindingAvailable() == true) goto L5;
        return;
    L5:
        getBinding().requirementComposerBackdrop.setBackground(ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.drawable.bg_proactive_sticky_overlay, "drawable", "bg_proactive_sticky_overlay")));
    }

    private final void restoreUserRequirementStableInputMode() {
        if (isBindingAvailable() == true) goto L5;
        return;
    L5:
        Editable r0 = getBinding().inputUserRequirement.getVInput().getText();
        if (r0 == null) goto L8;
        String r1 = r0.toString();
    L9:
        if (r1 != null) goto L12;
        r1 = "";
    L12:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L14;
        boolean r2 = true;
    L16:
        if (isAiVoiceSupportedOnThisDevice() == false) goto L21;
        if (r2 == true) goto L21;
        if (getRequirementInputModePreferences().getBoolean(REQUIREMENT_INPUT_MODE_VOICE_KEY, false) == false) goto L21;
        UserRequirementInputMode r3 = UserRequirementInputMode.VOICE_READY;
    L22:
        this.userRequirementInputMode = r3;
        updateUserRequirementComposerState();
        return;
    L21:
        r3 = UserRequirementInputMode.TEXT;
        goto L22
    L14:
        r2 = false;
        goto L16
    L8:
        r1 = null;
        goto L9
    }

    private final void retryGuidedEntryEnterAfterCelebration(final int r3) {
        if (r3 < 8) goto L5;
        return;
    L5:
        getBinding().recyclerView.postDelayed(new $$Lambda$NowFeedPageFragment$VaA8tsguifpkOLn9Mmz9Ua5r1M(this, r3), VIEWPORT_RESET_SHORT_DELAY_MS);
    }

    private static final void retryGuidedEntryEnterAfterCelebration$lambda$130(NowFeedPageFragment r0, int r1) {
        r0.playGuidedEntryEnterAfterCelebration(r1 + 1);
    }

    private final void scheduleCelebrationPendingCheck() {
        if (isBindingAvailable() == true) goto L5;
        return;
    L5:
        Runnable r0 = this.celebrationStartRunnable;
        if (r0 == null) goto L8;
        getBinding().root.removeCallbacks(r0);
    L8:
        this.celebrationStartRunnable = new $$Lambda$NowFeedPageFragment$KPqn4_NcksRKHEV1vJKUicxXfqY(this);
        getBinding().root.postDelayed(this.celebrationStartRunnable, 16);
    }

    private static final void scheduleCelebrationPendingCheck$lambda$116(NowFeedPageFragment r0) {
        r0.tryCompleteCelebrationPending();
    }

    private final void scheduleCollapseStateEvaluation() {
        scheduleCollapseStateEvaluation(0);
    }

    private final void scheduleCollapseStateEvaluation(long r6) {
        if (this.collapseEvaluationPosted == false) goto L6;
        return;
    L6:
        if (shouldRunCollapseEvaluation() == true) goto L8;
        return;
    L8:
        this.collapseEvaluationPosted = true;
        final RecyclerView r0 = getBinding().recyclerView;
        Intrinsics.checkNotNullExpressionValue(r0, "recyclerView");
        final Runnable r1 = new $$Lambda$NowFeedPageFragment$TLJz3TvCZfE7T_epSQOanngK7Q0(this);
        this.collapseEvaluationSecondPassRunnable = r1;
        Runnable r2 = new $$Lambda$NowFeedPageFragment$yXjZaDdTdgCuBQLA7CepHqRrf_M(this, r0, r1);
        this.collapseEvaluationFirstPassRunnable = r2;
        if (r6 <= 0) goto L11;
        r0.postDelayed(r2, r6);
        return;
    L11:
        r0.post(r2);
    }

    private static final void scheduleCollapseStateEvaluation$lambda$94(NowFeedPageFragment r3) {
        r3.collapseEvaluationSecondPassRunnable = null;
        r3.collapseEvaluationPosted = false;
        if (r3.shouldRunCollapseEvaluation() == true) goto L5;
        return;
    L5:
        p r0 = r3.resolveScrollBehaviorForCurrentContent();
        r3.configureScrollState(r0.a(), r0.b(), r0.c());
    }

    private static final void scheduleCollapseStateEvaluation$lambda$95(NowFeedPageFragment r2, RecyclerView r3, Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        r2.collapseEvaluationFirstPassRunnable = null;
        if (r2.shouldRunCollapseEvaluation() == true) goto L6;
        r2.clearPendingCollapseEvaluation();
        return;
    L6:
        r3.post(r5);
    }

    private final void scheduleNowViewportReset(String r2, boolean r3) {
        if (isBindingAvailable() == true) goto L5;
        return;
    L5:
        this.pendingViewportResetReason = r2;
        if (this.pendingViewportResetForce == true) goto L10;
        if (r3 == true) goto L10;
        boolean r4 = false;
    L11:
        this.pendingViewportResetForce = r4;
        getBinding().recyclerView.post(new $$Lambda$NowFeedPageFragment$Ipykttopw3Wn2NFfOKvh1Xu1MNw(this));
        return;
    L10:
        r4 = true;
        goto L11
    }

    private static final void scheduleNowViewportReset$lambda$97(final NowFeedPageFragment r2) {
        if (r2.isBindingAvailable() == true) goto L5;
        return;
    L5:
        r2.getBinding().recyclerView.postOnAnimation(new $$Lambda$NowFeedPageFragment$92a_75I0j1Qup5M4NleFyukwe4(r2));
    }

    private static final void scheduleNowViewportReset$lambda$97$lambda$96(NowFeedPageFragment r3) {
        if (r3.isBindingAvailable() == true) goto L5;
        return;
    L5:
        String r0 = r3.pendingViewportResetReason;
        if (r0 != null) goto L8;
        return;
    L8:
        boolean r1 = r3.pendingViewportResetForce;
        r3.pendingViewportResetReason = null;
        r3.pendingViewportResetForce = false;
        r3.resetNowViewportToTop(r0, r1);
        r3.scheduleNowViewportResetRetry(r0, r1, 1);
    }

    private final void scheduleNowViewportResetRetry(final String r5, final boolean r6, final int r7) {
        if (isBindingAvailable() == true) goto L5;
        return;
    L5:
        if (r7 <= 2) goto L8;
        return;
    L8:
        if (r7 != 1) goto L10;
        long r0 = VIEWPORT_RESET_SHORT_DELAY_MS;
    L11:
        getBinding().recyclerView.postDelayed(new $$Lambda$NowFeedPageFragment$2aWIWThfm5SC2Dj53Nx1_PD4_1A(this, r5, r7, r6), r0);
        return;
    L10:
        r0 = VIEWPORT_RESET_TRANSITION_DELAY_MS;
        goto L11
    }

    private static final void scheduleNowViewportResetRetry$lambda$98(NowFeedPageFragment r2, String r3, int r4, boolean r5) {
        if (r2.isBindingAvailable() == true) goto L5;
        return;
    L5:
        r2.resetNowViewportToTop(r3 + "_retry_" + r4, r5);
        r2.scheduleNowViewportResetRetry(r3, r5, r4 + 1);
    }

    private final void setProactiveEnabled(boolean r2) {
        if (this.isProactiveEnabled != r2) goto L5;
        return;
    L5:
        this.isProactiveEnabled = r2;
        getRepository().a(r2);
    }

    private final void setupStaticViews() {
        configureAvatarPlayback();
        configureAvatarOvalClipping();
        ensureStickyForegroundOrder();
        ensureNowListBottomSpacing();
        installCollapseStateLayoutObservers();
        getBinding().btnHistoryContainer.post(new $$Lambda$NowFeedPageFragment$bJb7o8UD_c8UJ3LUa2A0vsgSj8(this));
        getBinding().btnMoreContainer.post(new $$Lambda$NowFeedPageFragment$NBVTSpK6kGLDwYa7y1jb8vePLvk(this));
        getBinding().recyclerView.setDescendantFocusability(393216);
        getBinding().recyclerView.setFocusable(false);
        getBinding().recyclerView.setFocusableInTouchMode(false);
        int r0 = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledTouchSlop();
        getBinding().recyclerView.addOnItemTouchListener((RecyclerView.l) ZeusTransformUtils.preCheckCast(new e(this, r0), RecyclerView.l.class, "com.obric.memorydata.plugin"));
        getBinding().recyclerView.addOnScrollListener((RecyclerView.m) ZeusTransformUtils.preCheckCast(new f(this), RecyclerView.m.class, "com.obric.memorydata.plugin"));
        getBinding().recyclerView.post(new $$Lambda$NowFeedPageFragment$SjyfvXGFLWq0kcQrupLIgNprxM(this));
        getBinding().tsSingleEvent.setFactory(new $$Lambda$NowFeedPageFragment$RW7rL6fPSxxXA6PN6G5UsLnzXxA(this));
        renderSensingHeadline();
        setupUserRequirementComposer();
        getBinding().btnWakeUp.setOnClickListener(new $$Lambda$NowFeedPageFragment$LtXfdmNTyF2cZaCjx1mAnstfnc(this));
        getBinding().llSingleEvent.setOnClickListener(new $$Lambda$NowFeedPageFragment$ylPpgdqkmcFvO05BsSwPCUNTlU(this));
        getBinding().videoContainer.setOnClickListener(new $$Lambda$NowFeedPageFragment$_bbCkmTh7t3IlFh5Ie3sIsRBBOA(this));
        getBinding().btnHistoryContainer.setOnClickListener(new $$Lambda$NowFeedPageFragment$OS3vTxeMMEmXiaJ0oOpwgANpwc(this));
        getBinding().btnMoreContainer.setOnClickListener(new $$Lambda$NowFeedPageFragment$Efg2xbsJ50nN5o4LqnO1sk9Kp30(this));
        getBinding().appBar.addOnOffsetChangedListener(new $$Lambda$NowFeedPageFragment$dwHXmEirydurgmmOkW2RLsjhRn8(this));
    }

    private static final void setupStaticViews$lambda$27(NowFeedPageFragment r3) {
        r3.disableClipFromButtonAncestors((View) ZeusTransformUtils.preCheckCast(r3.getBinding().btnHistoryContainer, View.class, "com.obric.memorydata.plugin"));
    }

    private static final void setupStaticViews$lambda$28(NowFeedPageFragment r3) {
        r3.disableClipFromButtonAncestors((View) ZeusTransformUtils.preCheckCast(r3.getBinding().btnMoreContainer, View.class, "com.obric.memorydata.plugin"));
    }

    private static final void setupStaticViews$lambda$29(NowFeedPageFragment r1) {
        if (r1.defaultSuggestionRecyclerTop == 0) goto L5;
        return;
    L5:
        if (r1.getBinding().recyclerView.getTop() <= 0) goto L9;
        r1.defaultSuggestionRecyclerTop = r1.getBinding().recyclerView.getTop();
        return;
    }

    private static final View setupStaticViews$lambda$31(NowFeedPageFragment r6) {
        TextView r0 = new TextView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r0.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-2, -1, 17), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r0.setTextColor(r6.getPrimaryTitleColor());
        r0.setTextSize(13.0f);
        TextViewCompat.setLineHeight(r0, (int) (ZeusTransformUtils.getResources(r0, "com.obric.memorydata.plugin").getDisplayMetrics().density * 18.0f));
        r0.setGravity(17);
        r0.setTextAlignment(4);
        r0.setIncludeFontPadding(false);
        r0.setMaxWidth(r6.calculateSensingHeadlineTextMaxWidth());
        r0.setMaxLines(1);
        r0.setEllipsize(TextUtils.TruncateAt.END);
        return (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
    }

    private static final void setupStaticViews$lambda$32(NowFeedPageFragment r9, View r10) {
        if (r9.wakeUpInProgress == false) goto L5;
        return;
    L5:
        com.obric.aiproactive.ui.util.h.f6884a.b("home", "unlock_screen", "wake_up_doubao");
        OButton r11 = r9.getBinding().btnWakeUp;
        Intrinsics.checkNotNullExpressionValue(r11, "btnWakeUp");
        r9.performLightTapHaptic((View) ZeusTransformUtils.preCheckCast(r11, View.class, "com.obric.memorydata.plugin"));
        r9.wakeUpInProgress = true;
        OButton r12 = r9.getBinding().btnWakeUp;
        Intrinsics.checkNotNullExpressionValue(r12, "btnWakeUp");
        r12.setEnabled(false);
        LifecycleOwner r0 = r9.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new NowFeedPageFragment$setupStaticViews$7$1(r9, r12, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private static final void setupStaticViews$lambda$33(NowFeedPageFragment r4, View r5) {
        com.obric.aiproactive.api.g r6 = n.a(r4.latestAgentRun, r4.getRepository().d());
        r4.latestAgentRun = r6;
        if (n.a(r6, r4.agentStatusBarState, r4.celebrationActive) == true) goto L5;
        return;
    L5:
        if (r6 == null) goto L11;
        String r7 = r6.a();
        if (r7 == null) goto L12;
        com.obric.aiproactive.ui.util.h.f6884a.b("home", "unlock_screen", "show_detail");
        r4.prepareForSecondaryActivity("open_agent_run");
        ZeusTransformUtils.startActivity(r4, new Intent((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ProactiveAgentRunActivity.class).putExtra(ProactiveAgentRunActivity.EXTRA_EXECUTION_ID, r7), "com.obric.memorydata.plugin");
        return;
    L12:
        return;
    }

    private static final void setupStaticViews$lambda$34(NowFeedPageFragment r0, View r1) {
        r0.onAvatarTapped();
        if (n.a(r0.currentVisualState) == false) goto L6;
        r0.restoreNowPageFromStickyAvatar();
        return;
    }

    private static final void setupStaticViews$lambda$36(NowFeedPageFragment r3, View r4) {
        if (r3.canOpenHistoryPage() == false) goto L11;
        r3.prepareForSecondaryActivity("open_history");
        Intent r5 = new Intent((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ProactiveHistoryActivity.class);
        r5.putExtra("enter_from", r3.currentSessionEnterFrom());
        ZeusTransformUtils.startActivity(r3, r5, "com.obric.memorydata.plugin");
        FragmentActivity r6 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, i.class) == false) goto L7;
        i r7 = (i) ZeusTransformUtils.preCheckCast(r6, i.class, "com.obric.memorydata.plugin");
    L8:
        if (r7 == null) goto L12;
        r7.onHomeChildPageOpened("proactive_all");
        return;
    L12:
        return;
    L7:
        r7 = null;
        goto L8
    }

    private static final void setupStaticViews$lambda$37(NowFeedPageFragment r3, View r4) {
        if (r3.morePopover == null) goto L6;
        r3.dismissMorePopover(true);
        return;
    L6:
        com.obric.aiproactive.ui.util.h.f6884a.b("home", "unlock_screen", "show_menu");
        r3.showMorePopup();
    }

    private static final void setupStaticViews$lambda$38(NowFeedPageFragment r1, AppBarLayout r2, int r3) {
        if (r3 == r1.currentAppBarOffset) goto L5;
        r1.onNestedPageScrolled();
    L5:
        r1.currentAppBarOffset = r3;
        if (r1.supportsCollapsibleListForCurrentContent() == false) goto L8;
        Intrinsics.checkNotNull(r2);
        r1.updateCollapsedVisuals(r2, r3);
        r1.tryCompleteCelebrationPending();
        return;
    L8:
        r1.resetCollapsedVisuals();
    }

    private final void setupUserRequirementComposer() {
        final OInputLayout r0 = getBinding().inputUserRequirement;
        Intrinsics.checkNotNullExpressionValue(r0, "inputUserRequirement");
        final OEditText r1 = r0.getVInput();
        boolean r2 = true;
        r0.setType(1);
        r0.a(false);
        r0.c(false);
        r0.e(false);
        r0.setMaxLines(4);
        normalizeRequirementInputContainerPadding(r0);
        r0.post(new $$Lambda$NowFeedPageFragment$Wot_CwbA_pzP8F09ZSDKkCT3zw(this, r0));
        getBinding().requirementComposerContainer.setEnableShadowWidthRadius(true);
        getBinding().requirementComposerContainer.post(new $$Lambda$NowFeedPageFragment$Fk7JgbN7EWG4xB0JwQwSBSohb0w(this));
        getBinding().requirementComposerContainer.addOnLayoutChangeListener(new $$Lambda$NowFeedPageFragment$rY5IQnCWbvQbefxRQcVicf2qGZc(this));
        getBinding().requirementComposerContainer.post(new $$Lambda$NowFeedPageFragment$rXxsJQ0JojNxM259czIKzcvrvA(this));
        int r6 = ZeusTransformUtils.getResources(r1, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.ai_proactive_requirement_input_vertical_padding, "dimen", "ai_proactive_requirement_input_vertical_padding"));
        r1.setHint((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_user_requirement_hint, TypedValues.Custom.S_STRING, "ai_proactive_user_requirement_hint")), CharSequence.class, "com.obric.memorydata.plugin"));
        r1.setTypeface(Typeface.create("Olasans-sc-compact", 0));
        r1.setTextSize(16.0f);
        r1.setTextColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_primary, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_primary")));
        r1.setHintTextColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_tertiary, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_tertiary")));
        r1.setSingleLine(false);
        r1.setMinLines(1);
        r1.setMaxLines(4);
        r1.setGravity(8388627);
        r1.setTextAlignment(5);
        r1.setHorizontallyScrolling(false);
        r1.setVerticalScrollBarEnabled(true);
        r1.setOverScrollMode(1);
        r1.setIncludeFontPadding(false);
        r1.setPadding(0, r6, 0, r6);
        r1.setRawInputType(147457);
        TextViewCompat.setLineHeight((TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.memorydata.plugin"), (int) (ZeusTransformUtils.getResources(r1, "com.obric.memorydata.plugin").getDisplayMetrics().scaledDensity * 22.0f));
        r1.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new g(this, r1, r0), TextWatcher.class, "com.obric.memorydata.plugin"));
        r1.setOnTouchListener(new $$Lambda$NowFeedPageFragment$mIvqXWK8G55SEPvSYrx5ZRhkPF4(this));
        r1.post(new $$Lambda$NowFeedPageFragment$yO0hJ5OUCILmqmjC8bCXsKlGO4(this, r0, r1));
        getBinding().btnUserRequirementSend.setDisabledAlpha(1.0f);
        getBinding().btnUserRequirementSend.setChangeAlphaWhenDisable(false);
        getBinding().btnUserRequirementSend.setOnClickListener(new $$Lambda$NowFeedPageFragment$heo_gqMW_WWl6I_ByCWN0RMg8k(this));
        getBinding().btnUserRequirementInputMode.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_primary, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_primary"))));
        getBinding().btnUserRequirementInputMode.setOnClickListener(new $$Lambda$NowFeedPageFragment$YFxvkxkmEVpi_Kw9QHCuO3yRZ8g(this));
        getBinding().tvUserRequirementVoiceHold.setOnTouchListener(new $$Lambda$NowFeedPageFragment$1JsKTNHkFUAmH0miS_0P8WqFCys(this));
        String r3 = getRequirementComposerViewModel().getDraft();
        Editable r7 = r1.getText();
        if (r7 == null) goto L5;
        String r8 = r7.toString();
    L7:
        if (Intrinsics.areEqual(r8, r3) == true) goto L9;
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        r1.setSelection(r3.length());
    L9:
        restoreUserRequirementStableInputMode();
        setupUserRequirementComposerInsetsAnimation();
        ViewCompat.requestApplyInsets((View) ZeusTransformUtils.preCheckCast(getBinding().root, View.class, "com.obric.memorydata.plugin"));
        updateUserRequirementComposerState();
        if (isAiVoiceSupportedOnThisDevice() == false) goto L12;
        getVoiceAsrBridge().a();
    L12:
        int r4 = b.f6586b[resolveVisualState().ordinal()];
        if (r4 != 1) goto L15;
    L23:
        updateUserRequirementComposerVisibility(r2);
        return;
    L15:
        if (r4 == 2) goto L23;
        if (r4 == 3) goto L22;
        if (r4 == 4) goto L22;
        throw new NoWhenBranchMatchedException();
    L22:
        r2 = false;
        goto L23
    L5:
        r8 = null;
        goto L7
    }

    private static final void setupUserRequirementComposer$lambda$39(NowFeedPageFragment r0, OInputLayout r1) {
        r0.normalizeRequirementInputContainerPadding(r1);
    }

    private static final void setupUserRequirementComposer$lambda$40(NowFeedPageFragment r0) {
        r0.applyUserRequirementComposerMaterials();
    }

    private static final void setupUserRequirementComposer$lambda$41(NowFeedPageFragment r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if ((r5 - r3) == (r9 - r7)) goto L6;
        r0.updateUserRequirementComposerBackdropLayout();
        return;
    }

    private static final void setupUserRequirementComposer$lambda$42(NowFeedPageFragment r0) {
        r0.updateUserRequirementComposerBackdropLayout();
    }

    private static final boolean setupUserRequirementComposer$lambda$44$lambda$43(NowFeedPageFragment r0, View r1, MotionEvent r2) {
        Intrinsics.checkNotNull(r2);
        return r0.handleUserRequirementVoiceTouch(r2, true);
    }

    private static final void setupUserRequirementComposer$lambda$45(NowFeedPageFragment r2, OInputLayout r3, OEditText r4) {
        r2.updateUserRequirementInputHeight(r3, (EditText) ZeusTransformUtils.preCheckCast(r4, EditText.class, "com.obric.memorydata.plugin"));
    }

    private static final void setupUserRequirementComposer$lambda$46(NowFeedPageFragment r0, View r1) {
        r0.submitUserRequirement();
    }

    private static final void setupUserRequirementComposer$lambda$47(NowFeedPageFragment r2, View r3) {
        UserRequirementInputMode r4 = r2.userRequirementInputMode;
        int r5 = b.f6585a[r4.ordinal()];
        if (r5 != 1) goto L5;
        r2.requestUserRequirementVoiceMode();
        return;
    L5:
        if (r5 != 2) goto L7;
        r2.exitUserRequirementVoiceMode(true);
        return;
    L7:
        if (r5 != 3) goto L9;
        return;
    L9:
        if (r5 != 4) goto L11;
        return;
    L11:
        if (r5 != 5) goto L14;
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean setupUserRequirementComposer$lambda$48(NowFeedPageFragment r0, View r1, MotionEvent r2) {
        Intrinsics.checkNotNull(r2);
        return r0.handleUserRequirementVoiceTouch(r2, false);
    }

    private final void setupUserRequirementComposerInsetsAnimation() {
        final int r0 = WindowInsetsCompat.Type.ime();
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        final Ref.BooleanRef r2 = new Ref.BooleanRef();
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(getBinding().root, View.class, "com.obric.memorydata.plugin"), new $$Lambda$NowFeedPageFragment$kGb0E4y1NIGS0_xv6AFfFSj6YRk(r1, this, r2, r0));
        ViewCompat.setWindowInsetsAnimationCallback((View) ZeusTransformUtils.preCheckCast(getBinding().root, View.class, "com.obric.memorydata.plugin"), (WindowInsetsAnimationCompat.Callback) ZeusTransformUtils.preCheckCast(new C10612(r0, r2, this, r1), WindowInsetsAnimationCompat.Callback.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final WindowInsetsCompat setupUserRequirementComposerInsetsAnimation$lambda$66(Ref.ObjectRef r6, NowFeedPageFragment r7, Ref.BooleanRef r8, int r9, View r10, WindowInsetsCompat r11) {
        Intrinsics.checkNotNullParameter(r10, "<unused var>");
        Intrinsics.checkNotNullParameter(r11, "insets");
        r6.element = r11;
        if (r7.isBindingAvailable() == true) goto L5;
    L11:
        return r11;
    L5:
        if (r8.element == true) goto L11;
        if (r11.isVisible(r9) == false) goto L9;
        float r12 = 1.0f;
    L10:
        applyUserRequirementComposerInsets$default(r7, r11, r12, false, 4, null);
        r7.showPendingUserRequirementToastIfImeHidden(r11);
        goto L11
    L9:
        r12 = 0.0f;
        goto L10
    }

    private final boolean shouldAutoReturnTopForCelebration() {
        if (this.currentAppBarOffset == 0) goto L5;
    L8:
        return true;
    L5:
        if (getBinding().recyclerView.canScrollVertically(-1) == true) goto L8;
        return false;
    }

    private final boolean shouldResetNowViewportAfterResume() {
        RecyclerView.h r0 = getBinding().recyclerView.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r0, LinearLayoutManager.class) == false) goto L5;
        LinearLayoutManager r1 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r0, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L7:
        if (r1 != null) goto L9;
        return false;
    L9:
        int r2 = r1.o();
        if (r2 != (-1)) goto L13;
        return false;
    L13:
        if (getBinding().recyclerView.canScrollVertically(-1) == false) goto L15;
        return false;
    L15:
        if (r2 <= 0) goto L18;
        return false;
    L18:
        if (this.currentAppBarOffset == 0) goto L21;
        return true;
    L21:
        return !isRecyclerTopItemSettled();
    L5:
        r1 = null;
        goto L7
    }

    private final boolean shouldRunCollapseEvaluation() {
        LifecycleOwner r0 = (LifecycleOwner) ZeusTransformUtils.preCheckCast(getViewLifecycleOwnerLiveData().getValue(), LifecycleOwner.class, "com.obric.memorydata.plugin");
        boolean r1 = true;
        if (r0 == null) goto L11;
        Lifecycle r2 = r0.getLifecycle();
        if (r2 == null) goto L11;
        Lifecycle.State r3 = r2.getCurrentState();
        if (r3 == null) goto L11;
        if (r3.isAtLeast(Lifecycle.State.STARTED) != true) goto L11;
    L13:
        return l.a(r1, isScreenInteractive());
    L11:
        r1 = false;
        goto L13
    }

    private final void showFeedbackDialog() {
        FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "requireActivity(...)");
        ProactiveFeedbackSheet.a(new ProactiveFeedbackSheet((Activity) ZeusTransformUtils.preCheckCast(r1, Activity.class, "com.obric.memorydata.plugin")), ProactiveFeedbackSheet.Mode.GENERIC, null, null, new $$Lambda$NowFeedPageFragment$sCE3rRVgi__VddmR_U1PNkjdVw(this), 6, null);
    }

    private static final Unit showFeedbackDialog$lambda$79(NowFeedPageFragment r11, com.obric.aiproactive.ui.feedback.d r12) {
        Intrinsics.checkNotNullParameter(r12, "result");
        com.obric.aiproactive.ui.util.h r2 = com.obric.aiproactive.ui.util.h.f6884a;
        String r4 = com.obric.aiproactive.ui.feedback.f.a(r12.a());
        String r0 = r12.b();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L5;
        String r5 = r0;
    L6:
        com.obric.aiproactive.ui.util.h.a(r2, SlardarSettingsConstants.SETTING_GENERAL, r4, r5, null, 8, null);
        NowFeedViewModel r1 = r11.getNowViewModel();
        String r3 = com.obric.aiproactive.ui.feedback.f.a(r12.a());
        String r6 = r12.b();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L9;
        String r7 = r6;
    L10:
        r1.submitAiDirectFeedback(new com.obric.aiproactive.api.o(null, r3, r7, m.c(r11.currentActiveRecommendations()), "original", 1, null));
        return Unit.INSTANCE;
    L9:
        r7 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    private final void showMorePopup() {
        FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "requireActivity(...)");
        OPopoverEntranceMenuView.Builder r13 = new OPopoverEntranceMenuView.Builder((Context) ZeusTransformUtils.preCheckCast(r1, Context.class, "com.obric.memorydata.plugin"));
        OPopoverEntranceMenuView.Builder.a(r13, 0, null, null, (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.ai_proactive_sensing_events_title, TypedValues.Custom.S_STRING, "ai_proactive_sensing_events_title")), CharSequence.class, "com.obric.memorydata.plugin"), null, null, false, null, new $$Lambda$NowFeedPageFragment$rp7vUTqZWtWhdbdPyHFTEKgxc(this), 246, null);
        OPopoverEntranceMenuView.Builder.a(r13, 0, null, null, (CharSequence) ZeusTransformUtils.preCheckCast("偏好", CharSequence.class, "com.obric.memorydata.plugin"), null, null, false, null, new $$Lambda$NowFeedPageFragment$dUBcEvwoZBv7q8nOfgZScy_xS44(this), 246, null);
        OPopoverEntranceMenuView.Builder.a(r13, 0, null, null, (CharSequence) ZeusTransformUtils.preCheckCast("反馈", CharSequence.class, "com.obric.memorydata.plugin"), null, null, false, null, new $$Lambda$NowFeedPageFragment$bUaRD9n9VtJXMd0Yl318ReUijrE(this), 246, null);
        OPopoverEntranceMenuView.Builder.a(r13, 0, null, null, (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.proactive_menu_settings, TypedValues.Custom.S_STRING, "proactive_menu_settings")), CharSequence.class, "com.obric.memorydata.plugin"), null, null, false, null, new $$Lambda$NowFeedPageFragment$jm9HKwkezoNq7mPyKxrF7XV3o(this), 246, null);
        OPopoverEntranceMenuView r2 = r13.c();
        FragmentActivity r3 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "requireActivity(...)");
        final com.obric.oui.popover.v2.a r4 = ((com.obric.oui.popover.v2.a.C0765a) ZeusTransformUtils.preCheckCast(((com.obric.oui.popover.v2.a.C0765a) ZeusTransformUtils.preCheckCast(new com.obric.oui.popover.v2.a.C0765a((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.memorydata.plugin")).a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin")), com.obric.oui.popover.v2.a.C0765a.class, "com.obric.memorydata.plugin")).a(true), com.obric.oui.popover.v2.a.C0765a.class, "com.obric.memorydata.plugin")).F();
        this.morePopover = r4;
        this.shouldReportMorePopoverCollapse = true;
        r4.setOnDismissListener(new $$Lambda$NowFeedPageFragment$LjO1BhQNPww0b5wsBt7UlmnULXg(this, r4));
        com.obric.oui.popover.v2.e r5 = com.obric.oui.popover.v2.e.f14366a;
        ProactiveTopBarIconButton r0 = getBinding().btnMoreContainer;
        Intrinsics.checkNotNullExpressionValue(r0, "btnMoreContainer");
        com.obric.oui.popover.v2.e.a(r5, r4, (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"), 80, false, 0, false, 0, 0, 248, null);
    }

    private static final Unit showMorePopup$lambda$71(NowFeedPageFragment r2, View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        r2.dismissMorePopover(false);
        com.obric.aiproactive.ui.util.h.f6884a.b("home", "unlock_screen", "show_detail");
        r2.prepareForSecondaryActivity("open_sensing_events");
        SensingEventsActivity.a r5 = SensingEventsActivity.Companion;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "requireContext(...)");
        ZeusTransformUtils.startActivity(r2, r5.a(r6, r2.currentSessionEnterFrom()), "com.obric.memorydata.plugin");
        com.obric.memorydata.ui.h r7 = com.obric.memorydata.ui.h.f13009a;
        FragmentActivity r8 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r8, "requireActivity(...)");
        r7.a((Activity) ZeusTransformUtils.preCheckCast(r8, Activity.class, "com.obric.memorydata.plugin"));
        FragmentActivity r9 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, i.class) == false) goto L5;
        i r10 = (i) ZeusTransformUtils.preCheckCast(r9, i.class, "com.obric.memorydata.plugin");
    L6:
        if (r10 == null) goto L9;
        r10.onHomeChildPageOpened("events");
    L9:
        return Unit.INSTANCE;
    L5:
        r10 = null;
        goto L6
    }

    private static final Unit showMorePopup$lambda$73(NowFeedPageFragment r3, View r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "<unused var>");
        r3.dismissMorePopover(false);
        com.obric.aiproactive.ui.util.h.f6884a.b("home", "unlock_screen", "preference");
        r3.prepareForSecondaryActivity("open_preference");
        Intent r6 = new Intent((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), AiRuleActivity.class);
        r6.putExtra("enter_from", r3.currentSessionEnterFrom());
        ZeusTransformUtils.startActivity(r3, r6, "com.obric.memorydata.plugin");
        FragmentActivity r7 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, i.class) == false) goto L5;
        i r8 = (i) ZeusTransformUtils.preCheckCast(r7, i.class, "com.obric.memorydata.plugin");
    L6:
        if (r8 == null) goto L8;
        r8.onHomeChildPageOpened("preference");
    L8:
        com.obric.memorydata.ui.h r9 = com.obric.memorydata.ui.h.f13009a;
        FragmentActivity r10 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r10, "requireActivity(...)");
        r9.a((Activity) ZeusTransformUtils.preCheckCast(r10, Activity.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    L5:
        r8 = null;
        goto L6
    }

    private static final Unit showMorePopup$lambda$74(NowFeedPageFragment r2, View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "<unused var>");
        r2.dismissMorePopover(false);
        com.obric.aiproactive.ui.util.h.f6884a.b("home", "unlock_screen", "feedback");
        r2.showFeedbackDialog();
        return Unit.INSTANCE;
    }

    private static final Unit showMorePopup$lambda$75(NowFeedPageFragment r1, View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        r1.dismissMorePopover(false);
        ProactiveSettingsFragment.a r4 = ProactiveSettingsFragment.Companion;
        FragmentManager r5 = r1.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(r5, "getParentFragmentManager(...)");
        r4.a(r5);
        FragmentActivity r6 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, i.class) == false) goto L5;
        i r7 = (i) ZeusTransformUtils.preCheckCast(r6, i.class, "com.obric.memorydata.plugin");
    L6:
        if (r7 == null) goto L9;
        r7.onHomeChildPageOpened("proactive_settings");
    L9:
        return Unit.INSTANCE;
    L5:
        r7 = null;
        goto L6
    }

    private static final void showMorePopup$lambda$76(NowFeedPageFragment r2, com.obric.oui.popover.v2.a r3) {
        boolean r0 = r2.shouldReportMorePopoverCollapse;
        r2.shouldReportMorePopoverCollapse = false;
        if (r2.morePopover != r3) goto L5;
        r2.morePopover = null;
    L5:
        if (r0 == false) goto L8;
        com.obric.aiproactive.ui.util.h.f6884a.b("home", "unlock_screen", "collapse_menu");
        return;
    }

    private final void showPendingUserRequirementToastIfImeHidden(WindowInsetsCompat r8) {
        Integer r0 = this.pendingUserRequirementToastResId;
        if (r0 == null) goto L11;
        int r1 = r0.intValue();
        if (r8 != null) goto L7;
        return;
    L7:
        if (r8.isVisible(WindowInsetsCompat.Type.ime()) == true) goto L13;
        this.pendingUserRequirementToastResId = null;
        com.obric.oui.toast.a.C0786a r2 = com.obric.oui.toast.a.f14807a;
        FragmentActivity r9 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r9, "requireActivity(...)");
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(r9, Context.class, "com.obric.memorydata.plugin");
        String r4 = getString(r1);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
        com.obric.oui.toast.a.C0786a.a(r2, r3, r4, 0, 4, null);
        return;
    L13:
        return;
    }

    private final void smoothScrollCelebrationListToTop() {
        RecyclerView.Adapter r0 = getBinding().recyclerView.getAdapter();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.d() != 0) goto L8;
        return;
    L8:
        RecyclerView.h r1 = getBinding().recyclerView.getLayoutManager();
        if (ZeusTransformUtils.instanceOf(r1, LinearLayoutManager.class) == false) goto L11;
        LinearLayoutManager r2 = (LinearLayoutManager) ZeusTransformUtils.preCheckCast(r1, LinearLayoutManager.class, "com.obric.memorydata.plugin");
    L12:
        if (r2 != null) goto L14;
        return;
    L14:
        h r3 = new h((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r3.c(0);
        r2.a((RecyclerView.r) ZeusTransformUtils.preCheckCast(r3, RecyclerView.r.class, "com.obric.memorydata.plugin"));
        return;
    L11:
        r2 = null;
        goto L12
    }

    private final void startCelebrationState() {
        Runnable r0 = this.celebrationStartRunnable;
        if (r0 == null) goto L5;
        getBinding().root.removeCallbacks(r0);
    L5:
        this.celebrationStartRunnable = null;
        Runnable r1 = this.celebrationResetRunnable;
        if (r1 == null) goto L8;
        getBinding().root.removeCallbacks(r1);
    L8:
        this.celebrationAppBarExpansionRequested = false;
        this.celebrationActive = true;
        refreshGuidedPreferenceEntryVisibility$default(this, false, 1, null);
        getBinding().appBar.setExpanded(true, false);
        getBinding().recyclerView.scrollToPosition(0);
        renderCurrentState();
        this.celebrationResetRunnable = new $$Lambda$NowFeedPageFragment$wfmVkrCzQtpcu1gfEANFA3gBxZM(this);
        getBinding().root.postDelayed(this.celebrationResetRunnable, 4650);
    }

    private static final void startCelebrationState$lambda$120(final NowFeedPageFragment r9) {
        if (r9.isBindingAvailable() == true) goto L5;
        return;
    L5:
        r9.celebrationActive = false;
        r9.forceSensingAfterCelebration = true;
        r9.maybeStartSharedElementTransition(r9.resolveVisualState());
        configureScrollState$default(r9, false, false, false, 6, null);
        if (m.b(r9.currentRenderItems(r9.latestNowState.c())) == false) goto L8;
    L13:
        boolean r2 = true;
    L14:
        r9.applyVisualConfig(m.a(r2));
        r9.renderAvatar(NowVisualState.SENSING);
        r9.renderAgentStatusBar();
        r9.getBinding().tvAvatarSubtitle.setVisibility(8);
        r9.getBinding().btnWakeUp.setVisibility(8);
        r9.getBinding().llSingleEvent.setVisibility(0);
        r9.renderSensingHeadline();
        r9.updateActionButtons(true, r9.hasHistoryContent());
        r9.playNowCardsExitAnimation(new $$Lambda$NowFeedPageFragment$tUt0gMZnDZNFpKjFc86JJ0aZ7tU(r9));
        return;
    L8:
        if (r9.sensingExitActive == true) goto L10;
    L12:
        r2 = false;
        goto L14
    L10:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9.sensingExitRecommendations, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L12;
        goto L12
    }

    private static final Unit startCelebrationState$lambda$120$lambda$119(NowFeedPageFragment r1) {
        r1.refreshGuidedPreferenceEntryVisibility(true);
        r1.renderPostCelebrationGuidedEntry();
        return Unit.INSTANCE;
    }

    private final void startUserRequirementSendingAnimator() {
        ObjectAnimator r0 = this.userRequirementSendingAnimator;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        r1 = false;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        ObjectAnimator r2 = ObjectAnimator.ofFloat(getBinding().ivUserRequirementSending, View.ROTATION, new float[]{0.0f, 360.0f});
        r2.setDuration(700);
        r2.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new LinearInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r2.setRepeatCount(-1);
        r2.start();
        this.userRequirementSendingAnimator = r2;
        return;
    L5:
        if (r0.isRunning() != true) goto L7;
        goto L7
    }

    private final void startUserRequirementVoiceRecording() {
        if (isAiVoiceSupportedOnThisDevice() == true) goto L6;
        return;
    L6:
        if (this.voicePressActive == true) goto L8;
        return;
    L8:
        if (this.voicePressStarted == false) goto L11;
        return;
    L11:
        if (ContextCompat.checkSelfPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "android.permission.RECORD_AUDIO") == 0) goto L15;
        this.voicePressActive = false;
        this.voicePressStarted = false;
        this.pendingVoiceModeEntry = !this.voicePressStartedFromTextInput;
        this.voicePressStartedFromTextInput = false;
        this.voicePermissionRequestInFlight = true;
        this.recordAudioPermissionLauncher.launch("android.permission.RECORD_AUDIO");
        return;
    L15:
        if (this.voicePressStartedFromTextInput == false) goto L19;
        getBinding().inputUserRequirement.getVInput().cancelLongPress();
        getBinding().inputUserRequirement.getVInput().clearFocus();
        WindowInsetsControllerCompat r0 = ViewCompat.getWindowInsetsController((View) ZeusTransformUtils.preCheckCast(getBinding().inputUserRequirement.getVInput(), View.class, "com.obric.memorydata.plugin"));
        if (r0 == null) goto L19;
        r0.hide(WindowInsetsCompat.Type.ime());
    L19:
        this.voicePressStarted = true;
        this.userRequirementInputMode = UserRequirementInputMode.VOICE_RECORDING;
        updateUserRequirementComposerState();
        if (this.voicePressStartedFromTextInput == false) goto L22;
        String r1 = "text_input";
    L23:
        performVoiceStartHaptic(r1);
        getBinding().requirementVoiceOverlay.a(this.voicePressRawX, this.voicePressRawY);
        if (getVoiceAsrBridge().a($$Lambda$NowFeedPageFragment$nb2bCazuxyH4lRMpgnY_tDjyaGI.INSTANCE, new $$Lambda$NowFeedPageFragment$KjHTIqJ7ODVGEaIpWhPTkfXQmUs(this), new $$Lambda$NowFeedPageFragment$B1oiU70aLRCcmqjwrI4cwQsJkfg(this), new $$Lambda$NowFeedPageFragment$_uRRUsNwSH7vTnZxpnbWfmQEb0(this)) == true) goto L28;
        this.voicePressActive = false;
        return;
    L28:
        return;
    L22:
        r1 = "voice_button";
        goto L23
    }

    private static final Unit startUserRequirementVoiceRecording$lambda$52() {
        return Unit.INSTANCE;
    }

    private static final Unit startUserRequirementVoiceRecording$lambda$53(NowFeedPageFragment r1, byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "bytes");
        if (r1.isBindingAvailable() == false) goto L6;
        r1.getBinding().requirementVoiceOverlay.a(r2);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit startUserRequirementVoiceRecording$lambda$54(NowFeedPageFragment r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "transcript");
        r1.handleUserRequirementVoiceSuccess(r2);
        return Unit.INSTANCE;
    }

    private static final Unit startUserRequirementVoiceRecording$lambda$55(NowFeedPageFragment r0, Integer r1) {
        r0.handleUserRequirementVoiceFailure(r1);
        return Unit.INSTANCE;
    }

    private final void stopUserRequirementSendingAnimator() {
        ObjectAnimator r0 = this.userRequirementSendingAnimator;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.userRequirementSendingAnimator = null;
        if (isBindingAvailable() == false) goto L9;
        getBinding().ivUserRequirementSending.setRotation(0.0f);
        return;
    }

    private final void submitUserRequirement() {
        if (this.userRequirementSending == false) goto L5;
        return;
    L5:
        com.obric.aiproactive.api.x r0 = getRequirementComposerViewModel().prepareSubmission(System.currentTimeMillis());
        if (r0 != null) goto L9;
        return;
    L9:
        if (this.voiceSubmissionInFlight == true) goto L11;
        OIconButton r1 = getBinding().btnUserRequirementSend;
        Intrinsics.checkNotNullExpressionValue(r1, "btnUserRequirementSend");
        performLightTapHaptic((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"));
    L11:
        this.userRequirementSending = true;
        updateUserRequirementComposerState();
        LifecycleOwner r2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r2, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r2), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C10621(this, r0, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final boolean supportsCollapsibleListForCurrentContent() {
        return n.a(this.currentVisualState, hasGuidedPreferenceEntry());
    }

    private static final int tertiaryTextColor_delegate$lambda$15(NowFeedPageFragment r3) {
        return ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_tertiary, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_tertiary"));
    }

    private final void tryCompleteCelebrationPending() {
        if (isBindingAvailable() == true) goto L6;
        return;
    L6:
        if (cancelCelebrationForReplacement(currentActiveRecommendations()) == false) goto L9;
        return;
    L9:
        if (this.celebrationPending == true) goto L12;
        return;
    L12:
        if (isResumed() == false) goto L64;
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L22;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L22;
        View r2 = r1.getDecorView();
        if (r2 == null) goto L22;
        if (r2.hasWindowFocus() != true) goto L22;
        boolean r3 = true;
    L23:
        if (r3 == true) goto L26;
        return;
    L26:
        if (getBinding().recyclerView.isComputingLayout() == false) goto L29;
        scheduleCelebrationPendingCheck();
        return;
    L29:
        RecyclerView.e r4 = getBinding().recyclerView.getItemAnimator();
        if (r4 != null) goto L32;
    L34:
        boolean r5 = false;
    L35:
        if (r5 == false) goto L39;
        r4.a(new $$Lambda$NowFeedPageFragment$P1hB_U1fqssvgqSupNq7Bwp1swk(this));
        return;
    L39:
        if (getBinding().recyclerView.canScrollVertically(-1) == false) goto L41;
    L43:
        boolean r6 = false;
    L45:
        if (this.currentAppBarOffset != 0) goto L47;
        boolean r7 = true;
    L48:
        int r8 = b.d[n.a(r6, r7, this.celebrationAppBarExpansionRequested).ordinal()];
        if (r8 == 1) goto L62;
        if (r8 != 2) goto L53;
        this.celebrationAppBarExpansionRequested = true;
        getBinding().appBar.setExpanded(true, true);
    L60:
        scheduleCelebrationPendingCheck();
        return;
    L53:
        if (r8 == 3) goto L60;
        if (r8 != 4) goto L58;
        this.celebrationPending = false;
        this.celebrationAppBarExpansionRequested = false;
        refreshGuidedPreferenceEntryVisibility$default(this, false, 1, null);
        startCelebrationState();
        return;
    L58:
        throw new NoWhenBranchMatchedException();
    L62:
        if (getBinding().recyclerView.getScrollState() != 0) goto L60;
        smoothScrollCelebrationListToTop();
        goto L60
    L47:
        r7 = false;
        goto L48
    L41:
        if (isRecyclerTopItemSettled() == false) goto L43;
        r6 = true;
        goto L45
    L32:
        if (r4.c() != true) goto L34;
        r5 = true;
    L22:
        r3 = false;
        goto L23
    }

    private static final void tryCompleteCelebrationPending$lambda$114(NowFeedPageFragment r0) {
        r0.scheduleCelebrationPendingCheck();
    }

    private final void tryHandleStartupInspiration() {
        if (this.latestNowState.b() == false) goto L6;
        return;
    L6:
        if (this.latestStartupState.c() == StartupInspirationStage.WAITING_NOW) goto L8;
        return;
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[StartupFlow] tryHandleNow requestId=" + this.latestStartupState.a() + " inspirationId=" + this.latestStartupState.b() + " batchId=" + this.latestNowState.a() + " itemSize=" + this.latestNowState.c().size(), false, 4, null);
        ae r0 = getStartupCoordinatorViewModel().resolveFromNow(this.latestNowState.a(), extractRecommendations(this.latestNowState.c()));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), getLogTag(), "[StartupFlow] tryHandleNow decision=" + r0.getClass().getSimpleName() + " requestId=" + this.latestStartupState.a(), false, 4, null);
        handleStartupDecision(r0);
    }

    private final void updateActionButtons(boolean r6, boolean r7) {
        if (r6 == false) goto L4;
        int r0 = 0;
    L5:
        com.obric.aiproactive.ui.entry.g r1 = n.a(r6, r7);
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L8;
        int r8 = R.color.ai_proactive_demo_text_primary;
        String r4 = "ai_proactive_demo_text_primary";
    L9:
        int r9 = ContextCompat.getColor(r2, ZeusTransformUtils.mapRes(r8, TypedValues.Custom.S_COLOR, r4));
        getBinding().btnHistoryContainer.setVisibility(r0);
        getBinding().btnMoreContainer.setVisibility(r0);
        getBinding().btnHistoryContainer.setEnabled(r1.a());
        getBinding().btnHistoryContainer.setClickable(r1.b());
        getBinding().btnHistoryContainer.setFocusable(r1.b());
        getBinding().btnHistoryContainer.setAlpha(r1.c());
        ProactiveTopBarIconButton r3 = getBinding().btnHistoryContainer;
        ColorStateList r10 = ColorStateList.valueOf(r9);
        Intrinsics.checkNotNullExpressionValue(r10, "valueOf(...)");
        r3.setIconTintColor(r10);
        ProactiveTopBarIconButton r5 = getBinding().btnMoreContainer;
        if (r6 == false) goto L12;
        float r11 = 1.0f;
    L13:
        r5.setAlpha(r11);
        return;
    L12:
        r11 = 0.0f;
        goto L13
    L8:
        r8 = R.color.ai_proactive_demo_text_disabled;
        r4 = "ai_proactive_demo_text_disabled";
        goto L9
    L4:
        r0 = 8;
        goto L5
    }

    private final void updateAgentStatusBarState(final j r7) {
        Runnable r0 = this.agentStatusResetRunnable;
        if (r0 == null) goto L5;
        getBinding().root.removeCallbacks(r0);
    L5:
        this.agentStatusResetRunnable = null;
        this.agentStatusBarState = r7;
        if (this.celebrationActive == true) goto L11;
        if (this.currentVisualState == NowVisualState.SLEEP) goto L11;
        renderAgentStatusBar();
    L11:
        if (r7.getType() == NowAgentStatusType.COMPLETED) goto L13;
        return;
    L13:
        if (r7.c() <= 0) goto L28;
        long r1 = RangesKt.coerceAtLeast(r7.c() - System.currentTimeMillis(), 0);
        if (r1 > 0) goto L23;
        this.agentStatusBarState = j.f6620a.a();
        if (this.celebrationActive == false) goto L20;
        return;
    L20:
        if (this.currentVisualState == NowVisualState.SLEEP) goto L26;
        renderAgentStatusBar();
        return;
    L26:
        return;
    L23:
        this.agentStatusResetRunnable = new $$Lambda$NowFeedPageFragment$kevK2PUjgw6DxVF0Ez9rnElXHEk(this, r7);
        getBinding().root.postDelayed(this.agentStatusResetRunnable, r1);
        return;
    }

    private static final void updateAgentStatusBarState$lambda$139(NowFeedPageFragment r4, j r5) {
        if (r4.isBindingAvailable() == true) goto L5;
        return;
    L5:
        r4.agentStatusResetRunnable = null;
        if (r4.agentStatusBarState.b() == r5.b()) goto L8;
        return;
    L8:
        r4.agentStatusBarState = j.f6620a.a();
        if (r4.celebrationActive == false) goto L11;
        return;
    L11:
        if (r4.currentVisualState == NowVisualState.SLEEP) goto L15;
        r4.renderAgentStatusBar();
        return;
    }

    private final void updateAvatarLayout(float r9, float r10) {
        this.startAvatarSize = r9;
        this.startCenterYOffset = r10;
        float r1 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        float r11 = r9 * r1;
        int r2 = (int) r11;
        int r12 = (int) (r10 * r1);
        ViewGroup.LayoutParams r3 = getBinding().videoPlaceholder.getLayoutParams();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r4.width == r2) goto L5;
    L8:
        debugLayoutWarning("updateAvatarLayout rootInLayout=" + getBinding().root.isInLayout() + " placeholder=" + r4.width + 'x' + r4.height + '@' + r4.topMargin + " -> " + r2 + 'x' + r2 + '@' + r12);
        r4.width = r2;
        r4.height = r2;
        r4.topMargin = r12;
        getBinding().videoPlaceholder.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    L9:
        ViewGroup.LayoutParams r5 = getBinding().videoContainer.getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r6.width == r2) goto L12;
    L15:
        r6.width = r2;
        r6.height = r2;
        r6.topMargin = r12;
        getBinding().videoContainer.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    L16:
        refreshAvatarOvalClipping();
        getBinding().videoContainer.setElevation(0.0f);
        getBinding().videoContainer.setTranslationZ(0.0f);
        getBinding().videoContainer.setForeground((Drawable) ZeusTransformUtils.preCheckCast(createAvatarBorderDrawable(r11 / 2.0f), Drawable.class, "com.obric.memorydata.plugin"));
        return;
    L12:
        if (r6.height != r2) goto L15;
        if (r6.topMargin == r12) goto L16;
    L5:
        if (r4.height != r2) goto L8;
        if (r4.topMargin == r12) goto L9;
        goto L8
    }

    private final void updateAvatarTextLayout(float r8, float r9, float r10, final float r11, float r12, float r13) {
        float r1 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        float r2 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().scaledDensity;
        ViewGroup.LayoutParams r3 = getBinding().tvAvatarTitle.getLayoutParams();
        ConstraintLayout.LayoutParams r5 = null;
        if (ZeusTransformUtils.instanceOf(r3, ConstraintLayout.LayoutParams.class) == false) goto L5;
        ConstraintLayout.LayoutParams r4 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L7:
        if (r4 == null) goto L14;
        int r14 = (int) (r8 * r1);
        if (r4.topMargin == r14) goto L12;
        r4.topMargin = r14;
        getBinding().tvAvatarTitle.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    L12:
        if (Math.abs(getBinding().tvAvatarTitle.getTextSize() - (r9 * r2)) <= 0.5f) goto L14;
        getBinding().tvAvatarTitle.setTextSize(r9);
    L14:
        ViewGroup.LayoutParams r15 = getBinding().tvAvatarSubtitle.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r15, ConstraintLayout.LayoutParams.class) == false) goto L17;
        ConstraintLayout.LayoutParams r16 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r15, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L18:
        if (r16 == null) goto L29;
        int r17 = (int) (r10 * r1);
        int r18 = (int) (r12 * r1);
        if (r16.topMargin == r17) goto L22;
    L25:
        r16.topMargin = r17;
        r16.setMarginStart(r18);
        r16.setMarginEnd(r18);
        getBinding().tvAvatarSubtitle.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r16, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    L27:
        if (Math.abs(getBinding().tvAvatarSubtitle.getTextSize() - (r2 * r11)) <= 0.5f) goto L29;
        getBinding().tvAvatarSubtitle.setTextSize(r11);
        goto L29
    L22:
        if (r16.getMarginStart() != r18) goto L25;
        if (r16.getMarginEnd() == r18) goto L27;
    L29:
        ViewGroup.LayoutParams r19 = getBinding().llSingleEvent.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r19, ConstraintLayout.LayoutParams.class) == false) goto L32;
        r5 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r19, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L32:
        if (r5 == null) goto L38;
        int r20 = (int) (r13 * r1);
        if (r5.topMargin == r20) goto L36;
        r5.topMargin = r20;
        getBinding().llSingleEvent.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    L36:
        final TextSwitcher r21 = getBinding().tsSingleEvent;
        Intrinsics.checkNotNullExpressionValue(r21, "tsSingleEvent");
        r21.post(new $$Lambda$NowFeedPageFragment$0VJ5P28672KSAiU59_g2OxxMoME(this, r21, r11));
        return;
    L38:
        return;
    L17:
        r16 = null;
        goto L18
    L5:
        r4 = null;
        goto L7
    }

    private static final void updateAvatarTextLayout$lambda$110$lambda$109(NowFeedPageFragment r2, TextSwitcher r3, float r4) {
        if (r2.isBindingAvailable() == true) goto L5;
        return;
    L5:
        if (r3.isAttachedToWindow() == false) goto L18;
        View r5 = r3.getCurrentView();
        if (ZeusTransformUtils.instanceOf(r5, TextView.class) == false) goto L10;
        TextView r6 = (TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.memorydata.plugin");
    L11:
        if (r6 == null) goto L13;
        r6.setTextSize(r4);
    L13:
        if (r6 == null) goto L17;
        r6.setMaxWidth(r2.calculateSensingHeadlineTextMaxWidth());
        return;
    L17:
        return;
    L10:
        r6 = null;
        goto L11
    }

    private final void updateCollapsedVisuals(AppBarLayout r13, int r14) {
        int r15 = -r14;
        int r16 = r13.getTotalScrollRange();
        if (r16 > 0) goto L5;
        return;
    L5:
        float r0 = RangesKt.coerceIn(r15 / r16, 0.0f, 1.0f);
        Integer r3 = null;
        float r2 = n.a(r0, 0.0f, 2, null);
        float r4 = n.a(r0, 0.0f, 0.0f, 6, null);
        float r1 = RangesKt.coerceIn(1.0f - (r0 * 3.4f), 0.0f, 1.0f);
        getBinding().tvAvatarTitle.setAlpha(r1);
        getBinding().tvAvatarSubtitle.setAlpha(r1);
        getBinding().llSingleEvent.setAlpha(r1);
        float r5 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        com.obric.aiproactive.ui.entry.e r6 = n.a(r2, r5, ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().widthPixels, this.startCenterYOffset, this.startAvatarSize);
        if (this.defaultSuggestionRecyclerTop == 0) goto L8;
    L10:
        int r7 = this.defaultSuggestionRecyclerTop;
        Integer r8 = Integer.valueOf(getBinding().topBlurView.getBottom());
        boolean r9 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L13;
        boolean r10 = true;
    L14:
        if (r10 == true) goto L18;
        r8 = null;
    L18:
        if (r8 == null) goto L20;
        int r11 = r8.intValue();
    L21:
        Integer r12 = Integer.valueOf(getBinding().topBlurView.getHeight());
        if (((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).intValue() > 0) goto L25;
        r9 = false;
    L25:
        if (r9 == false) goto L27;
        r3 = r12;
    L27:
        if (r3 == null) goto L29;
        int r17 = r3.intValue();
    L30:
        float r18 = n.a(r7, r15, r11, r17);
        getBinding().videoContainer.setScaleX(r6.a());
        getBinding().videoContainer.setScaleY(r6.a());
        getBinding().videoContainer.setTranslationX(r6.b());
        getBinding().videoContainer.setTranslationY(r6.c());
        getBinding().topCutOff.setAlpha(RangesKt.coerceIn(r4 * STICKY_OVERLAY_MAX_ALPHA, 0.0f, STICKY_OVERLAY_MAX_ALPHA));
        getBinding().topBlurView.setAlpha(r4);
        updateRecyclerOverlap(r18);
        return;
    L29:
        r17 = (int) (r5 * STICKY_CHROME_HEIGHT_DP);
        goto L30
    L20:
        r11 = (int) (r5 * STICKY_CHROME_HEIGHT_DP);
        goto L21
    L13:
        r10 = false;
        goto L14
    L8:
        if (getBinding().recyclerView.getTop() <= 0) goto L10;
        this.defaultSuggestionRecyclerTop = getBinding().recyclerView.getTop();
        goto L10
    }

    private final void updateHeaderBottomPadding(float r4) {
        int r5 = (int) (r4 * ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density);
        if (getBinding().avatarContainer.getPaddingBottom() == r5) goto L6;
        getBinding().avatarContainer.setPadding(getBinding().avatarContainer.getPaddingLeft(), getBinding().avatarContainer.getPaddingTop(), getBinding().avatarContainer.getPaddingRight(), r5);
        return;
    }

    private final void updateNowListTopPadding() {
        if (getBinding().recyclerView.getPaddingTop() != 0) goto L5;
        return;
    L5:
        getBinding().recyclerView.setPadding(getBinding().recyclerView.getPaddingLeft(), 0, getBinding().recyclerView.getPaddingRight(), getBinding().recyclerView.getPaddingBottom());
    }

    private final void updateRecyclerOverlap(float r5) {
        ViewGroup.LayoutParams r0 = getBinding().recyclerView.getLayoutParams();
        AppBarLayout.ScrollingViewBehavior r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, CoordinatorLayout.LayoutParams.class) == false) goto L5;
        CoordinatorLayout.LayoutParams r1 = (CoordinatorLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, CoordinatorLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        CoordinatorLayout.Behavior r3 = r1.getBehavior();
        if (ZeusTransformUtils.instanceOf(r3, AppBarLayout.ScrollingViewBehavior.class) == false) goto L11;
        r2 = (AppBarLayout.ScrollingViewBehavior) ZeusTransformUtils.preCheckCast(r3, AppBarLayout.ScrollingViewBehavior.class, "com.obric.memorydata.plugin");
    L11:
        if (r2 != null) goto L14;
        return;
    L14:
        if (this.nowListStickyOverlapEnabled == false) goto L16;
        int r4 = n.a(r5, ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density, STICKY_LIST_MAX_OVERLAP_DP);
    L18:
        if (r2.getOverlayTop() != r4) goto L20;
        return;
    L20:
        debugLayoutWarning("updateRecyclerOverlap rootInLayout=" + getBinding().root.isInLayout() + " current=" + r2.getOverlayTop() + " target=" + r4 + " progress=" + r5);
        r2.setOverlayTop(r4);
        getBinding().recyclerView.postOnAnimation(new $$Lambda$NowFeedPageFragment$u1DrYgCrPmktCnTL4KF_wc2JXow(this));
        return;
    L16:
        r4 = 0;
        goto L18
    L5:
        r1 = null;
        goto L6
    }

    private static final void updateRecyclerOverlap$lambda$134(NowFeedPageFragment r1) {
        if (r1.getView() == null) goto L6;
        r1.getBinding().recyclerView.requestLayout();
        return;
    }

    private final void updateTitleSweep(boolean r2) {
        GradientTextView r1 = getBinding().tvAvatarTitle;
        if (ZeusTransformUtils.instanceOf(r1, GradientTextView.class) == true) goto L6;
        r1 = null;
    L6:
        if (r1 == null) goto L9;
        r1.setSweepEnabled(r2);
        return;
    }

    private final void updateUserRequirementComposerBackdropLayout() {
        if (isBindingAvailable() == true) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r0 = getBinding().requirementComposerContainer.getLayoutParams();
        Integer r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L8;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        Integer r3 = Integer.valueOf(getBinding().requirementComposerContainer.getHeight());
        if (((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L18;
        r2 = r3;
    L18:
        if (r2 == null) goto L20;
        int r5 = r2.intValue();
    L21:
        int r6 = (r5 + r1.bottomMargin) + ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.ai_proactive_requirement_composer_backdrop_top, "dimen", "ai_proactive_requirement_composer_backdrop_top"));
        ViewGroup.LayoutParams r7 = getBinding().requirementComposerBackdrop.getLayoutParams();
        if (r7.height != r6) goto L24;
        return;
    L24:
        r7.height = r6;
        getBinding().requirementComposerBackdrop.setLayoutParams(r7);
        return;
    L20:
        r5 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.ai_proactive_requirement_composer_min_height, "dimen", "ai_proactive_requirement_composer_min_height"));
        goto L21
    L14:
        r4 = false;
        goto L15
    L8:
        r1 = null;
        goto L9
    }

    private final void updateUserRequirementComposerMargins(float r9, int r10) {
        ViewGroup.LayoutParams r0 = getBinding().requirementComposerContainer.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        float r11 = RangesKt.coerceIn(r9, 0.0f, 1.0f);
        int r2 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.ai_proactive_requirement_composer_horizontal_margin, "dimen", "ai_proactive_requirement_composer_horizontal_margin"));
        int r3 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.ai_proactive_requirement_composer_bottom_margin, "dimen", "ai_proactive_requirement_composer_bottom_margin"));
        int r4 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.ai_proactive_requirement_composer_ime_margin, "dimen", "ai_proactive_requirement_composer_ime_margin"));
        int r5 = interpolateRequirementComposerMargin(r2, r4, r11);
        int r12 = r10 + interpolateRequirementComposerMargin(r3, r4, r11);
        if (r1.getMarginStart() == r5) goto L11;
    L16:
        r1.setMarginStart(r5);
        r1.setMarginEnd(r5);
        r1.bottomMargin = r12;
        getBinding().requirementComposerContainer.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        updateUserRequirementComposerBackdropLayout();
        return;
    L11:
        if (r1.getMarginEnd() != r5) goto L16;
        if (r1.bottomMargin != r12) goto L16;
        updateUserRequirementComposerBackdropLayout();
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void updateUserRequirementComposerState() {
        if (isBindingAvailable() == true) goto L5;
        return;
    L5:
        Editable r1 = getBinding().inputUserRequirement.getVInput().getText();
        if (r1 == null) goto L8;
        String r2 = r1.toString();
    L9:
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == true) goto L17;
    L19:
        boolean r5 = false;
    L21:
        if (this.userRequirementInputMode != UserRequirementInputMode.TEXT) goto L23;
        boolean r6 = true;
    L25:
        if (this.userRequirementInputMode != UserRequirementInputMode.VOICE_READY) goto L27;
        boolean r7 = true;
    L29:
        if (this.userRequirementInputMode != UserRequirementInputMode.VOICE_RECORDING) goto L31;
    L34:
        boolean r8 = true;
    L36:
        if (this.userRequirementInputMode != UserRequirementInputMode.VOICE_CANCELLING) goto L38;
        boolean r9 = true;
    L40:
        if (this.userRequirementInputMode != UserRequirementInputMode.VOICE_TRANSCRIBING) goto L42;
        boolean r10 = true;
    L43:
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r3 == false) goto L46;
    L49:
        int r13 = R.color.ai_proactive_requirement_send_enabled_bg;
        String r14 = "ai_proactive_requirement_send_enabled_bg";
    L50:
        int r12 = ContextCompat.getColor(r11, ZeusTransformUtils.mapRes(r13, TypedValues.Custom.S_COLOR, r14));
        Context r15 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r3 == false) goto L53;
    L56:
        int r4 = ZeusTransformUtils.mapRes(R.color.ai_proactive_requirement_send_enabled_icon, TypedValues.Custom.S_COLOR, "ai_proactive_requirement_send_enabled_icon");
    L57:
        int r16 = ContextCompat.getColor(r15, r4);
        getBinding().btnUserRequirementSend.setEnabled(r5);
        getBinding().btnUserRequirementSend.setBackgroundColor(r12);
        getBinding().btnUserRequirementSend.setImageTintList(ColorStateList.valueOf(r16));
        OIconButton r17 = getBinding().btnUserRequirementSend;
        if (this.userRequirementSending == false) goto L60;
        int r18 = 0;
    L61:
        r17.setImageAlpha(r18);
        LinearLayout r19 = getBinding().userRequirementContentColumn;
        if (r6 == true) goto L66;
        if (r8 == true) goto L66;
        int r110 = 8;
    L67:
        r19.setVisibility(r110);
        LinearLayout r20 = getBinding().userRequirementContentColumn;
        if (r8 == false) goto L70;
        float r111 = 0.0f;
    L71:
        r20.setAlpha(r111);
        OIconButton r21 = getBinding().btnUserRequirementSend;
        if (r6 == false) goto L77;
        if (r3 == false) goto L75;
    L76:
        int r112 = 0;
    L78:
        r21.setVisibility(r112);
        AppCompatImageButton r22 = getBinding().btnUserRequirementInputMode;
        if (isAiVoiceSupportedOnThisDevice() == false) goto L86;
        if (r6 == false) goto L86;
        if (r3 == true) goto L86;
        if (this.userRequirementSending == true) goto L86;
    L88:
        int r23 = 0;
    L90:
        r22.setVisibility(r23);
        if (r7 == false) goto L93;
        getBinding().btnUserRequirementInputMode.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_ai_proactive_keyboard_input, "drawable", "ic_ai_proactive_keyboard_input"));
        AppCompatImageButton r24 = getBinding().btnUserRequirementInputMode;
        int r25 = R.string.ai_proactive_voice_switch_to_keyboard;
        String r113 = "ai_proactive_voice_switch_to_keyboard";
    L94:
        r24.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(r25, TypedValues.Custom.S_STRING, r113)), CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r26 = getBinding().tvUserRequirementVoiceHold;
        if (r7 == true) goto L100;
        if (r10 == true) goto L100;
        if (r8 == true) goto L100;
        int r27 = 8;
    L101:
        r26.setVisibility(r27);
        TextView r28 = getBinding().tvUserRequirementVoiceHold;
        if (r8 == false) goto L104;
        float r114 = 0.0f;
    L105:
        r28.setAlpha(r114);
        TextView r29 = getBinding().tvUserRequirementVoiceHold;
        if (r10 == false) goto L108;
        int r30 = R.string.ai_proactive_voice_transcribing;
        String r115 = "ai_proactive_voice_transcribing";
    L109:
        r29.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(r30, TypedValues.Custom.S_STRING, r115)), CharSequence.class, "com.obric.memorydata.plugin"));
        TextView r31 = getBinding().tvUserRequirementVoiceHold;
        if (r7 == true) goto L114;
        if (r8 == true) goto L114;
        boolean r32 = false;
    L115:
        r31.setEnabled(r32);
        getBinding().voiceRequirementVisualizer.setVisibility(8);
        getBinding().voiceRequirementVisualizer.a();
        getBinding().tvUserRequirementVoiceTip.setVisibility(8);
        updateUserRequirementVoiceOverlay(r8, r9);
        getBinding().ivUserRequirementSending.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_requirement_send_enabled_icon, TypedValues.Custom.S_COLOR, "ai_proactive_requirement_send_enabled_icon"))));
        ImageView r33 = getBinding().ivUserRequirementSending;
        if (r6 == true) goto L118;
    L120:
        int r34 = 8;
    L121:
        r33.setVisibility(r34);
        if (this.userRequirementSending == false) goto L124;
        startUserRequirementSendingAnimator();
    L125:
        getBinding().requirementComposerContainer.post(new $$Lambda$NowFeedPageFragment$_hYRuA7K8HhKVLQbogW9TNYiO28(this));
        return;
    L124:
        stopUserRequirementSendingAnimator();
        goto L125
    L118:
        if (this.userRequirementSending == false) goto L120;
        r34 = 0;
    L114:
        r32 = true;
        goto L115
    L108:
        r30 = R.string.ai_proactive_voice_hold_to_talk;
        r115 = "ai_proactive_voice_hold_to_talk";
        goto L109
    L104:
        r114 = 1.0f;
    L100:
        r27 = 0;
        goto L101
    L93:
        getBinding().btnUserRequirementInputMode.setImageResource(ZeusTransformUtils.mapRes(R.drawable.ic_ai_proactive_voice_input, "drawable", "ic_ai_proactive_voice_input"));
        r24 = getBinding().btnUserRequirementInputMode;
        r25 = R.string.ai_proactive_voice_switch_to_voice;
        r113 = "ai_proactive_voice_switch_to_voice";
    L86:
        if (isAiVoiceSupportedOnThisDevice() == false) goto L89;
        if (r7 == true) goto L88;
    L89:
        r23 = 8;
        goto L90
    L75:
        if (this.userRequirementSending == true) goto L76;
    L77:
        r112 = 8;
        goto L78
    L70:
        r111 = 1.0f;
    L66:
        r110 = 0;
        goto L67
    L60:
        r18 = 255;
        goto L61
    L53:
        if (this.userRequirementSending == true) goto L56;
        r4 = ZeusTransformUtils.mapRes(R.color.ai_proactive_requirement_send_disabled_icon, TypedValues.Custom.S_COLOR, "ai_proactive_requirement_send_disabled_icon");
        goto L57
    L46:
        if (this.userRequirementSending == true) goto L49;
        r13 = R.color.ai_proactive_requirement_send_disabled_bg;
        r14 = "ai_proactive_requirement_send_disabled_bg";
        goto L50
    L42:
        r10 = false;
        goto L43
    L38:
        r9 = false;
        goto L40
    L31:
        if (this.userRequirementInputMode == UserRequirementInputMode.VOICE_CANCELLING) goto L34;
        r8 = false;
        goto L36
    L27:
        r7 = false;
        goto L29
    L23:
        r6 = false;
        goto L25
    L17:
        if (this.userRequirementSending == true) goto L19;
        r5 = true;
        goto L21
    L14:
        r3 = false;
        goto L15
    L8:
        r2 = null;
        goto L9
    }

    private static final void updateUserRequirementComposerState$lambda$68(NowFeedPageFragment r1) {
        if (r1.isBindingAvailable() == false) goto L6;
        r1.updateUserRequirementComposerBackdropLayout();
        return;
    }

    private final void updateUserRequirementComposerVisibility(boolean r4) {
        int r0 = 0;
        if (r4 == true) goto L8;
        if (this.userRequirementInputMode == UserRequirementInputMode.TEXT) goto L8;
        cancelUserRequirementVoiceSession(false);
        restoreUserRequirementStableInputMode();
    L8:
        if (r4 == true) goto L11;
        r0 = 8;
    L11:
        getBinding().requirementComposerBackdrop.setVisibility(r0);
        getBinding().requirementComposerContainer.setVisibility(r0);
        if (r4 == true) goto L15;
        getBinding().tvUserRequirementVoiceTip.setVisibility(8);
        return;
    }

    private final void updateUserRequirementInputHeight(OInputLayout r3, EditText r4) {
        ViewGroup.LayoutParams r2 = r3.getLayoutParams();
        if (r2.height == (-2)) goto L5;
        r2.height = -2;
        r3.setLayoutParams(r2);
    L5:
        r4.requestLayout();
        r3.requestLayout();
    }

    private final void updateUserRequirementVoiceCancellation(float r2, float r3) {
        getBinding().requirementVoiceOverlay.a(r2, r3);
        if (getBinding().requirementVoiceOverlay.a(r3) == false) goto L5;
        UserRequirementInputMode r4 = UserRequirementInputMode.VOICE_CANCELLING;
    L7:
        if (r4 != this.userRequirementInputMode) goto L9;
        return;
    L9:
        this.userRequirementInputMode = r4;
        performVoiceStateHaptic();
        updateUserRequirementComposerState();
        return;
    L5:
        r4 = UserRequirementInputMode.VOICE_RECORDING;
        goto L7
    }

    private final void updateUserRequirementVoiceOverlay(boolean r3, boolean r4) {
        RequirementVoiceOverlayView r0 = getBinding().requirementVoiceOverlay;
        Intrinsics.checkNotNullExpressionValue(r0, "requirementVoiceOverlay");
        r0.setCancelling(r4);
        boolean r5 = false;
        if (r3 == true) goto L5;
        r0.b();
        if (this.voiceOverlayOwnsComposerVisibility == true) goto L15;
        return;
    L15:
        getBinding().requirementComposerContainer.setAlpha(1.0f);
        getBinding().requirementComposerBackdrop.setAlpha(1.0f);
        if (this.voiceComposerWasVisible == false) goto L18;
        getBinding().requirementComposerContainer.setVisibility(0);
        getBinding().requirementComposerBackdrop.setVisibility(0);
    L18:
        this.voiceOverlayOwnsComposerVisibility = false;
        this.voiceComposerWasVisible = false;
        return;
    L5:
        if (this.voiceOverlayOwnsComposerVisibility == false) goto L7;
    L10:
        getBinding().requirementComposerContainer.setAlpha(0.0f);
        getBinding().requirementComposerBackdrop.setAlpha(0.0f);
        r0.a();
        return;
    L7:
        if (getBinding().requirementComposerContainer.getVisibility() != 0) goto L9;
        r5 = true;
    L9:
        this.voiceComposerWasVisible = r5;
        this.voiceOverlayOwnsComposerVisibility = true;
        goto L10
    }

    private static final AiVoiceSdkAsrBridge voiceAsrBridgeDelegate$lambda$10(NowFeedPageFragment r3) {
        if (r3.isAiVoiceSupportedOnThisDevice() == false) goto L7;
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireContext(...)");
        return new AiVoiceSdkAsrBridge(r4);
    L7:
        throw new IllegalStateException("AIVoice requires Android 12 or newer".toString());
    }

    private final UserRequirementInputMode voiceIdleModeAfterCurrentPress() {
        if (this.voicePressStartedFromTextInput == false) goto L6;
        return UserRequirementInputMode.TEXT;
    L6:
        return UserRequirementInputMode.VOICE_READY;
    }

    private final int withAlphaFraction(int r3, float r4) {
        return Color.argb((int) (Color.alpha(r3) * RangesKt.coerceIn(r4, 0.0f, 1.0f)), Color.red(r3), Color.green(r3), Color.blue(r3));
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public boolean canStartPageData() {
        AiProactiveEntryGate r0 = ag.a(AppContext.INSTANCE.getUserId(), getRepository().f());
        this.entryGate = r0;
        if (r0 != AiProactiveEntryGate.ALLOW) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean dismissUserRequirementImeIfTouchOutside(float r4, float r5) {
        if (isBindingAvailable() == true) goto L5;
        return false;
    L5:
        OEditText r0 = getBinding().inputUserRequirement.getVInput();
        if (r0.hasFocus() == true) goto L8;
        return false;
    L8:
        Rect r2 = new Rect();
        if (getBinding().requirementComposerContainer.getGlobalVisibleRect(r2) == true) goto L11;
    L18:
        return false;
    L11:
        if (r2.contains((int) r4, (int) r5) == true) goto L18;
        r0.clearFocus();
        WindowInsetsControllerCompat r3 = ViewCompat.getWindowInsetsController((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"));
        if (r3 == null) goto L19;
        r3.hide(WindowInsetsCompat.Type.ime());
        return true;
    L19:
        return true;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public ProactiveListAdapter.Mode getAdapterMode() {
        return this.adapterMode;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public int getBackgroundResId() {
        return this.backgroundResId;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public BaseProactiveFeedViewModel getBaseViewModel() {
        return (BaseProactiveFeedViewModel) ZeusTransformUtils.preCheckCast(getNowViewModel(), BaseProactiveFeedViewModel.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public PageType getPageType() {
        return this.pageType;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public void observePageState(ProactiveListAdapter r11) {
        Intrinsics.checkNotNullParameter(r11, "adapter");
        this.adapterRef = r11;
        r11.a(new $$Lambda$NowFeedPageFragment$OA26QHaaUcH1nfs7MVOONoWs20s(this));
        refreshGuidedPreferenceEntryVisibility$default(this, false, 1, null);
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, r11, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public void onBeforeOpenRecommendationDetail() {
        prepareForSecondaryActivity("open_recommendation_detail");
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ProactiveRecommendationEnabledStore.INSTANCE.unregisterListener(this.proactiveEnabledListener);
        cancelUserRequirementVoiceSession(true);
        dismissMorePopover(false);
        bx r2 = this.todaySensingEventsJob;
        if (r2 == null) goto L5;
        bx.a.a(r2, null, 1, null);
    L5:
        this.todaySensingEventsJob = null;
        bx r3 = this.agentRunJob;
        if (r3 == null) goto L8;
        bx.a.a(r3, null, 1, null);
    L8:
        this.agentRunJob = null;
        this.todaySensingEventsStarted = false;
        this.todaySensingEventsDayAnchor = Long.MIN_VALUE;
        this.wakeUpInProgress = false;
        this.avatarTapCount = 0;
        this.avatarFiveTapRequestInFlight = false;
        this.lastAvatarFiveTapTriggeredAt = 0;
        stopUserRequirementSendingAnimator();
        this.userRequirementSending = false;
        this.pendingUserRequirementToastResId = null;
        clearUserRequirementComposerMaterials();
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(getBinding().root, View.class, "com.obric.memorydata.plugin"), null);
        ViewCompat.setWindowInsetsAnimationCallback((View) ZeusTransformUtils.preCheckCast(getBinding().root, View.class, "com.obric.memorydata.plugin"), null);
        ViewTreeObserver r0 = getBinding().root.getViewTreeObserver();
        if (r0.isAlive() == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L14;
        r0.removeOnWindowFocusChangeListener(this.celebrationWindowFocusChangeListener);
    L14:
        clearPendingCollapseEvaluation();
        Runnable r1 = this.celebrationStartRunnable;
        if (r1 == null) goto L17;
        getBinding().root.removeCallbacks(r1);
    L17:
        this.celebrationStartRunnable = null;
        Runnable r4 = this.celebrationResetRunnable;
        if (r4 == null) goto L20;
        getBinding().root.removeCallbacks(r4);
    L20:
        this.celebrationResetRunnable = null;
        Runnable r5 = this.agentStatusResetRunnable;
        if (r5 == null) goto L23;
        getBinding().root.removeCallbacks(r5);
    L23:
        this.agentStatusResetRunnable = null;
        resetSensingExitState();
        ProactiveListAdapter r6 = this.adapterRef;
        if (r6 == null) goto L26;
        r6.a(null);
    L26:
        this.adapterRef = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        dismissMorePopover(false);
        clearPendingCollapseEvaluation();
        pauseCelebrationUntilForeground();
        super.onPause();
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public void onRecommendationAdopted(com.obric.aiproactive.ui.model.j.f r42) {
        Intrinsics.checkNotNullParameter(r42, "item");
        queueCelebrationAfterAdopting(r42);
        if (n.a(r42.b()) == false) goto L13;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(this.debugMockRecommendations, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        com.obric.aiproactive.ui.model.j.f r6 = (com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r6.b().getInspirationId(), r42.b().getInspirationId()) == false) goto L10;
        r6 = com.obric.aiproactive.ui.model.j.f.a(r6, ProactiveRecommendationDto.copy$default(r6.b(), null, null, null, null, null, null, null, null, null, 0, 0.0d, null, null, 2, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 134209535, null), null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
    L10:
        r3.add(r6);
        goto L6
    L11:
        this.debugMockRecommendations = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        refreshCurrentPage();
        return;
    L13:
        getNowViewModel().pinNowAdopted(r42.b().getInspirationId());
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public void onRecyclerScrolled(int r1, ProactiveListAdapter r2, LinearLayoutManager r3) {
        Intrinsics.checkNotNullParameter(r2, "adapter");
        Intrinsics.checkNotNullParameter(r3, "layoutManager");
        tryCompleteCelebrationPending();
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        refreshProactiveEnabledState();
        if (this.entryGate != AiProactiveEntryGate.ALLOW) goto L6;
        ensureHistoryPageDataStarted();
        ensureTodaySensingEventsStarted();
        this.latestAgentRun = n.a(this.latestAgentRun, getRepository().d());
        refreshAgentStatusBarState$default(this, null, null, 3, null);
    L6:
        if (m.a(this.entryGate) == false) goto L8;
        getNowViewModel().refresh();
    L8:
        refreshGuidedPreferenceEntryVisibility$default(this, false, 1, null);
        refreshCollapseStateAfterResume();
        if (this.celebrationPending == false) goto L12;
        scheduleCelebrationPendingCheck();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "outState");
        super.onSaveInstanceState(r4);
        r4.putBoolean("forceSensingAfterCelebration", this.forceSensingAfterCelebration);
        r4.putBoolean("celebrationActive", this.celebrationActive);
        r4.putBoolean("celebrationPending", this.celebrationPending);
        r4.putLong("celebrationBatchId", this.celebrationBatchId);
        r4.putLong("latestBatchId", this.latestBatchId);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        cancelUserRequirementVoiceSession(false);
        restoreUserRequirementStableInputMode();
        clearPendingCollapseEvaluation();
        super.onStop();
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        if (r7 == null) goto L5;
        this.forceSensingAfterCelebration = r7.getBoolean("forceSensingAfterCelebration", false);
        this.celebrationActive = r7.getBoolean("celebrationActive", false);
        this.celebrationPending = r7.getBoolean("celebrationPending", false);
        this.celebrationBatchId = r7.getLong("celebrationBatchId", Long.MIN_VALUE);
        this.latestBatchId = r7.getLong("latestBatchId", Long.MIN_VALUE);
    L5:
        this.isProactiveEnabled = getRepository().g();
        ProactiveRecommendationEnabledStore.INSTANCE.registerListener(this.proactiveEnabledListener, false);
        this.latestAgentRun = n.a(this.latestAgentRun, getRepository().d());
        refreshGuidedPreferenceEntryVisibility$default(this, false, 1, null);
        observeStartupCoordinator();
        observeAllPageState();
        if (this.entryGate != AiProactiveEntryGate.ALLOW) goto L8;
        ensureHistoryPageDataStarted();
        ensureTodaySensingEventsStarted();
    L8:
        setupStaticViews();
        getBinding().root.getViewTreeObserver().addOnWindowFocusChangeListener(this.celebrationWindowFocusChangeListener);
        renderCurrentState();
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public void renderPageState(boolean r12, List<? extends com.obric.aiproactive.ui.model.j> r13, ProactiveListAdapter r14) {
        List<? extends com.obric.aiproactive.ui.model.j> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "items");
        Intrinsics.checkNotNullParameter(r14, "adapter");
        this.adapterRef = r14;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r14.b(), Iterable.class, "com.obric.memorydata.plugin");
        boolean r4 = false;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L6;
        if (ZeusTransformUtils.instanceOf((com.obric.aiproactive.ui.model.j) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.aiproactive.ui.model.j.class, "com.obric.memorydata.plugin"), com.obric.aiproactive.ui.model.j.c.class) == false) goto L9;
        boolean r2 = true;
    L13:
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r14.b(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r3.iterator();
    L15:
        if (r6.hasNext() == false) goto L19;
        Object r7 = r6.next();
        if (ZeusTransformUtils.instanceOf(r7, com.obric.aiproactive.ui.model.j.f.class) == false) goto L15;
        r5.add(r7);
        goto L15
    L19:
        List<com.obric.aiproactive.ui.model.j.f> r8 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        List<com.obric.aiproactive.ui.model.j> r16 = currentRenderItems(r15);
        long r9 = currentRenderBatchId();
        if (r12 == true) goto L22;
    L24:
        boolean r17 = false;
    L25:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r10.iterator();
    L27:
        if (r18.hasNext() == false) goto L31;
        Object r19 = r18.next();
        if (ZeusTransformUtils.instanceOf(r19, com.obric.aiproactive.ui.model.j.f.class) == false) goto L27;
        r11.add(r19);
        goto L27
    L31:
        List<com.obric.aiproactive.ui.model.j.f> r20 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");
        cancelCelebrationForReplacement(r20);
        if (r9 == this.latestBatchId) goto L34;
        boolean r21 = true;
    L36:
        if (r21 == false) goto L38;
        this.latestBatchId = r9;
        this.forceSensingAfterCelebration = false;
        this.celebrationActive = false;
        resetSensingExitState();
        refreshGuidedPreferenceEntryVisibility$default(this, false, 1, null);
    L38:
        super.renderPageState(r17, r16, r14);
        if (r17 == true) goto L42;
        refreshAgentStatusBarState$default(this, r20, null, 2, null);
    L42:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r20, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L44;
    L46:
        if (r17 == false) goto L48;
    L50:
        if (r17 == true) goto L52;
        maybeStartCelebration(r20, r8, r14);
        maybeStartSensingExitAnimation(r8, r20, r14);
    L52:
        Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r110, Collection.class) == true) goto L55;
    L57:
        Iterator r111 = r110.iterator();
    L59:
        if (r111.hasNext() == false) goto L56;
        if (((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r111.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).b().getRecommendStatus() == 2) goto L63;
        boolean r22 = true;
    L64:
        if (r22 == false) goto L59;
        boolean r112 = true;
    L66:
        this.previousHadPendingRecommendations = r112;
        renderCurrentState();
        if (r21 == false) goto L84;
        Iterable r113 = (Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r113, Collection.class) == true) goto L71;
    L73:
        Iterator r114 = r113.iterator();
    L75:
        if (r114.hasNext() == false) goto L72;
        if (((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r114.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).b().getRecommendStatus() == 2) goto L79;
        boolean r23 = true;
    L80:
        if (r23 == false) goto L75;
        boolean r115 = true;
    L82:
        if (r115 == false) goto L84;
        scheduleNowViewportReset("new_batch", true);
        goto L84
    L79:
        r23 = false;
    L72:
        r115 = false;
        goto L82
    L71:
        if (((Collection) ZeusTransformUtils.preCheckCast(r113, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L73;
    L84:
        if (r17 == true) goto L113;
        if (r2 == true) goto L113;
        Iterable r116 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r116, Collection.class) == true) goto L89;
    L91:
        Iterator r117 = r116.iterator();
    L93:
        if (r117.hasNext() == false) goto L90;
        if (ZeusTransformUtils.instanceOf((com.obric.aiproactive.ui.model.j) ZeusTransformUtils.preCheckCast(r117.next(), com.obric.aiproactive.ui.model.j.class, "com.obric.memorydata.plugin"), com.obric.aiproactive.ui.model.j.c.class) == false) goto L93;
        boolean r118 = true;
    L97:
        if (r118 == false) goto L113;
        Iterable r119 = (Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r119, Collection.class) == true) goto L101;
    L103:
        Iterator r120 = r119.iterator();
    L105:
        if (r120.hasNext() == false) goto L102;
        if (((com.obric.aiproactive.ui.model.j.f) ZeusTransformUtils.preCheckCast(r120.next(), com.obric.aiproactive.ui.model.j.f.class, "com.obric.memorydata.plugin")).b().getRecommendStatus() == 2) goto L109;
        boolean r121 = true;
    L110:
        if (r121 == false) goto L105;
    L111:
        if (r4 == false) goto L113;
        scheduleNowViewportReset("guided_entry", true);
        goto L113
    L109:
        r121 = false;
    L102:
        r4 = true;
        goto L111
    L101:
        if (((Collection) ZeusTransformUtils.preCheckCast(r119, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L103;
    L90:
        r118 = false;
        goto L97
    L89:
        if (((Collection) ZeusTransformUtils.preCheckCast(r116, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L91;
    L113:
        scheduleCollapseStateEvaluation();
        return;
    L63:
        r22 = false;
    L56:
        r112 = false;
        goto L66
    L55:
        if (((Collection) ZeusTransformUtils.preCheckCast(r110, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L57;
    L48:
        if (r20.isEmpty() == false) goto L50;
        cancelCelebrationState$default(this, "empty_recommendations", false, 2, null);
        goto L50
    L44:
        if (this.sensingExitActive == false) goto L46;
        resetSensingExitState();
        goto L46
    L34:
        r21 = false;
        goto L36
    L22:
        if (this.debugMockRecommendations.isEmpty() == false) goto L24;
        r17 = true;
    L6:
        r2 = false;
        goto L13
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public int resolveBottomPadding(int r1, int r2) {
        return nowListBottomSafeSpacePx();
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveFeedPageFragment
    public int resolveTopPadding(int r1, int r2) {
        return 0;
    }
}
