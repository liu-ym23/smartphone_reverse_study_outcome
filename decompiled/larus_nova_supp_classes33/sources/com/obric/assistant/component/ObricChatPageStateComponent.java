package com.obric.assistant.component;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ai.api.AppletExtService;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.bmhome.chat.api.IAuthModelService;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.utils.FirstFeedSceneEnum;
import com.larus.bmhome.view.TitleAvatarImageView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.common_ui.widget.BaseConstraintLayout;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.multitask_management.api.IMultiTaskHostAbility;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.IObricActivityService;
import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.SessionAuthenticationServiceDelegate;
import com.obric.assistant.ability.PageStateChangedReason;
import com.obric.assistant.authenticationsession.SessionAuthenticationStateView;
import com.obric.assistant.banner.IObricBannerService;
import com.obric.assistant.component.viewmodel.OrionChatPageStateViewModel;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.AssistantWindowHideReason;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindow$DefaultImpls;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.interact.IObserveToken;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.task.ObricTaskStatusManager;
import com.obric.assistant.view.ObricIconSwipeUpView;
import com.obric.assistant.view.ObricSwipeGestureView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000º\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010 \n\u0002\b\u0015*\u0006Á\u0001Ä\u0001Ð\u0001\u0018\u0000 Þ\u00032\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u00062\u00020\u00072\u00020\b:\u0002Þ\u0003B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010Æ\u0001\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u0001H\u0002J#\u0010Ê\u0001\u001a\u00020\u00122\u0018\u0010Ë\u0001\u001a\u0013\u0012\u0005\u0012\u00030¿\u0001\u0012\u0005\u0012\u00030¿\u0001\u0018\u00010Ì\u0001H\u0002J\u0016\u0010Í\u0001\u001a\u00030Ç\u00012\n\u0010Î\u0001\u001a\u0005\u0018\u00010É\u0001H\u0002J\u001b\u0010\u0091\u0002\u001a\u00030Ç\u00012\u000f\u0010\u0092\u0002\u001a\n\u0012\u0005\u0012\u00030Ç\u00010\u0093\u0002H\u0002J\t\u0010\u0094\u0002\u001a\u00020\u0012H\u0002J(\u0010\u0095\u0002\u001a\u00030Ç\u00012\b\u0010\u0096\u0002\u001a\u00030¿\u00012\f\b\u0002\u0010\u0097\u0002\u001a\u0005\u0018\u00010µ\u0001H\u0002¢\u0006\u0003\u0010\u0098\u0002J\n\u0010\u0099\u0002\u001a\u00030Ç\u0001H\u0016J\n\u0010\u009a\u0002\u001a\u00030Ç\u0001H\u0002J\u000e\u0010\u009b\u0002\u001a\u00020\u0012*\u00030\u009c\u0002H\u0002J\n\u0010\u009d\u0002\u001a\u00030Ç\u0001H\u0016J\u0014\u0010\u009e\u0002\u001a\u00030Ç\u00012\b\u0010\u009f\u0002\u001a\u00030ë\u0001H\u0016J\n\u0010 \u0002\u001a\u00030Ç\u0001H\u0016J\n\u0010¡\u0002\u001a\u00030Ç\u0001H\u0016J\u001e\u0010¢\u0002\u001a\u00030Ç\u00012\b\u0010È\u0001\u001a\u00030É\u00012\b\u0010£\u0002\u001a\u00030¿\u0001H\u0002J\u0014\u0010¤\u0002\u001a\u00030Ç\u00012\b\u0010£\u0002\u001a\u00030¿\u0001H\u0002J\u0014\u0010¥\u0002\u001a\u00030Ç\u00012\b\u0010£\u0002\u001a\u00030¿\u0001H\u0002J\n\u0010¦\u0002\u001a\u00030Ç\u0001H\u0002J\u0014\u0010§\u0002\u001a\u00030Ç\u00012\b\u0010£\u0002\u001a\u00030¿\u0001H\u0002J\n\u0010¨\u0002\u001a\u00030Ç\u0001H\u0002J\n\u0010©\u0002\u001a\u00030Ç\u0001H\u0002J\u0014\u0010ª\u0002\u001a\u00030Ç\u00012\b\u0010«\u0002\u001a\u00030¿\u0001H\u0002J\n\u0010¬\u0002\u001a\u00030Ç\u0001H\u0002J\t\u0010\u00ad\u0002\u001a\u00020\u0012H\u0002J\n\u0010®\u0002\u001a\u00030Ç\u0001H\u0002J\n\u0010¯\u0002\u001a\u00030Ç\u0001H\u0016J\n\u0010°\u0002\u001a\u00030Ç\u0001H\u0016J\n\u0010±\u0002\u001a\u00030Ç\u0001H\u0016J\u0012\u0010²\u0002\u001a\u00020\u00122\u0007\u0010³\u0002\u001a\u00020\u0012H\u0002J\u0014\u0010´\u0002\u001a\u00030Ç\u00012\b\u0010µ\u0002\u001a\u00030²\u0001H\u0016J\u001d\u0010¶\u0002\u001a\u00030Ç\u00012\b\u0010\u0097\u0002\u001a\u00030µ\u00012\u0007\u0010·\u0002\u001a\u00020\u0012H\u0016J/\u0010¸\u0002\u001a\u00030Ç\u00012\u0007\u0010¹\u0002\u001a\u00020\u00122\b\u0010º\u0002\u001a\u00030²\u00012\n\u0010\u0097\u0002\u001a\u0005\u0018\u00010µ\u0001H\u0002¢\u0006\u0003\u0010»\u0002J%\u0010¼\u0002\u001a\u00030Ç\u00012\u0007\u0010¹\u0002\u001a\u00020\u00122\n\u0010\u0097\u0002\u001a\u0005\u0018\u00010µ\u0001H\u0002¢\u0006\u0003\u0010½\u0002J.\u0010¾\u0002\u001a\u00030Ç\u00012\u0007\u0010¹\u0002\u001a\u00020\u00122\n\u0010\u0097\u0002\u001a\u0005\u0018\u00010µ\u00012\u0007\u0010¿\u0002\u001a\u00020\u0012H\u0002¢\u0006\u0003\u0010À\u0002JK\u0010Á\u0002\u001a\u00030Ç\u00012\u0007\u0010¹\u0002\u001a\u00020\u00122\b\u0010º\u0002\u001a\u00030²\u00012\n\u0010\u0097\u0002\u001a\u0005\u0018\u00010µ\u00012\u0007\u0010Â\u0002\u001a\u00020\u00122\u0007\u0010·\u0002\u001a\u00020\u00122\b\u0010\u0096\u0002\u001a\u00030Ã\u0002H\u0016¢\u0006\u0003\u0010Ä\u0002J/\u0010Å\u0002\u001a\u00030Ç\u00012\n\u0010\u0097\u0002\u001a\u0005\u0018\u00010µ\u00012\u0007\u0010¹\u0002\u001a\u00020\u00122\b\u0010\u0096\u0002\u001a\u00030¿\u0001H\u0016¢\u0006\u0003\u0010Æ\u0002J3\u0010Ç\u0002\u001a\u00030È\u00022\u0007\u0010¹\u0002\u001a\u00020\u00122\f\b\u0002\u0010\u0097\u0002\u001a\u0005\u0018\u00010µ\u00012\n\b\u0002\u0010\u0096\u0002\u001a\u00030¿\u0001H\u0002¢\u0006\u0003\u0010É\u0002J\u0010\u0010Ê\u0002\u001a\u00020\u0012*\u0005\u0018\u00010\u008a\u0002H\u0002J\u000f\u0010Ë\u0002\u001a\u00030\u008a\u0002*\u00030\u008a\u0002H\u0002J\u0010\u0010Ì\u0002\u001a\u00020\u0012*\u0005\u0018\u00010\u008a\u0002H\u0002J\u0013\u0010Í\u0002\u001a\u00030Ç\u00012\u0007\u0010Î\u0002\u001a\u00020\u0012H\u0002J\u0018\u0010Í\u0002\u001a\u00030Ç\u0001*\u00030Ï\u00022\u0007\u0010Î\u0002\u001a\u00020\u0012H\u0002J\u000f\u0010Ð\u0002\u001a\u00030Ç\u0001*\u00030Ï\u0002H\u0002J\u000f\u0010Ð\u0002\u001a\u00030Ç\u0001*\u00030\u009c\u0002H\u0002J\n\u0010Ñ\u0002\u001a\u00030²\u0001H\u0002J\n\u0010Ò\u0002\u001a\u00030²\u0001H\u0002J\u0013\u0010Ó\u0002\u001a\u00030Ç\u00012\u0007\u0010Ô\u0002\u001a\u00020\u0012H\u0016J\n\u0010Õ\u0002\u001a\u00030¿\u0001H\u0002J\u000b\u0010Ö\u0002\u001a\u0004\u0018\u00010\u0005H\u0002J\f\u0010×\u0002\u001a\u0005\u0018\u00010Ø\u0002H\u0002J\u0014\u0010Ù\u0002\u001a\t\u0012\u0004\u0012\u00020\u00050Ú\u0002*\u00020\u001fH\u0002J\u0015\u0010Û\u0002\u001a\n\u0012\u0005\u0012\u00030Ø\u00020Ú\u0002*\u00020\u001fH\u0002J\u0015\u0010Ü\u0002\u001a\u00020\u00122\n\u0010Ý\u0002\u001a\u0005\u0018\u00010¿\u0001H\u0016J\t\u0010Þ\u0002\u001a\u00020\u0012H\u0002J&\u0010ß\u0002\u001a\u00030Ç\u00012\b\u0010µ\u0002\u001a\u00030²\u00012\u0007\u0010à\u0002\u001a\u00020\u00122\u0007\u0010á\u0002\u001a\u00020\u0012H\u0016J6\u0010ß\u0002\u001a\u00030Ç\u00012\u0007\u0010â\u0002\u001a\u00020\u00122\t\u0010á\u0002\u001a\u0004\u0018\u00010\u00122\u0007\u0010·\u0002\u001a\u00020\u00122\u0007\u0010Ô\u0002\u001a\u00020\u0012H\u0016¢\u0006\u0003\u0010ã\u0002J\n\u0010ä\u0002\u001a\u00030\u008a\u0002H\u0016J\t\u0010å\u0002\u001a\u00020\u0012H\u0016J\t\u0010æ\u0002\u001a\u00020\u0012H\u0016J\n\u0010ç\u0002\u001a\u00030¿\u0001H\u0016J\u0013\u0010³\u0001\u001a\u00030Ç\u00012\u0007\u0010è\u0002\u001a\u00020\u0012H\u0016J\t\u0010é\u0002\u001a\u00020\u0012H\u0016J\t\u0010ê\u0002\u001a\u00020\u0012H\u0016J\t\u0010ë\u0002\u001a\u00020\u0012H\u0016J\u0015\u0010ì\u0002\u001a\u00020\u00122\n\u0010í\u0002\u001a\u0005\u0018\u00010Ï\u0002H\u0002J\n\u0010î\u0002\u001a\u00030Ç\u0001H\u0002J\u0014\u0010ï\u0002\u001a\u00030Ç\u00012\b\u0010ð\u0002\u001a\u00030\u008a\u0002H\u0002J\u0014\u0010ñ\u0002\u001a\u00030Ç\u00012\b\u0010ð\u0002\u001a\u00030ò\u0002H\u0002J\u0014\u0010ó\u0002\u001a\u00030Ç\u00012\b\u0010ð\u0002\u001a\u00030ô\u0002H\u0002J\n\u0010õ\u0002\u001a\u00030Ç\u0001H\u0002J\u0014\u0010ö\u0002\u001a\u00030Ç\u00012\b\u0010ð\u0002\u001a\u00030È\u0002H\u0002J\u0014\u0010÷\u0002\u001a\u00030Ç\u00012\b\u0010µ\u0002\u001a\u00030²\u0001H\u0002J\u0014\u0010ø\u0002\u001a\u00030Ç\u00012\b\u0010µ\u0002\u001a\u00030²\u0001H\u0002J\u0015\u0010ù\u0002\u001a\u00030Ç\u00012\t\b\u0002\u0010ú\u0002\u001a\u00020\u0012H\u0002J\n\u0010û\u0002\u001a\u00030²\u0001H\u0016J&\u0010ü\u0002\u001a\u00030Ç\u00012\u0007\u0010ý\u0002\u001a\u00020\u00122\u0007\u0010þ\u0002\u001a\u00020\u00122\b\u0010ÿ\u0002\u001a\u00030¿\u0001H\u0016J\u0013\u0010\u0080\u0003\u001a\u00030Ç\u00012\u0007\u0010\u0081\u0003\u001a\u00020\u0012H\u0016J\u0013\u0010\u0082\u0003\u001a\u00030Ç\u00012\u0007\u0010\u0083\u0003\u001a\u00020\u0012H\u0016J\n\u0010\u0084\u0003\u001a\u00030Ç\u0001H\u0016J\n\u0010\u0085\u0003\u001a\u00030Ç\u0001H\u0016J\u0014\u0010\u0086\u0003\u001a\u00030Ç\u00012\b\u0010\u0087\u0003\u001a\u00030\u0088\u0003H\u0016J\u0013\u0010\u0089\u0003\u001a\u00030Ç\u00012\u0007\u0010\u0081\u0003\u001a\u00020\u0012H\u0016J\u0013\u0010\u008a\u0003\u001a\u00030Ç\u00012\u0007\u0010\u0081\u0003\u001a\u00020\u0012H\u0016J\u0013\u0010\u008b\u0003\u001a\u00030Ç\u00012\u0007\u0010\u008c\u0003\u001a\u00020\u0012H\u0016J\u0014\u0010\u008d\u0003\u001a\u00030Ç\u00012\b\u0010\u008e\u0003\u001a\u00030²\u0001H\u0016J\u001c\u0010\u008f\u0003\u001a\u00030Ç\u00012\u0007\u0010\u0081\u0003\u001a\u00020\u00122\u0007\u0010\u0090\u0003\u001a\u00020\u0012H\u0016J\u0013\u0010\u0091\u0003\u001a\u00030Ç\u00012\u0007\u0010\u0081\u0003\u001a\u00020\u0012H\u0016J\u0013\u0010\u0092\u0003\u001a\u00030Ç\u00012\u0007\u0010\u0081\u0003\u001a\u00020\u0012H\u0016J\n\u0010\u0093\u0003\u001a\u00030Ç\u0001H\u0016J\u0014\u0010\u0094\u0003\u001a\u00030Ç\u00012\b\u0010\u008e\u0003\u001a\u00030\u0095\u0003H\u0016J\f\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J\n\u0010\u0096\u0003\u001a\u00030²\u0001H\u0002J\u001e\u0010\u0097\u0003\u001a\u00030Ç\u00012\b\u0010\u0098\u0003\u001a\u00030²\u00012\b\u0010\u0099\u0003\u001a\u00030²\u0001H\u0002J\u0013\u0010\u009a\u0003\u001a\u00030Ç\u00012\u0007\u0010ê\u0002\u001a\u00020\u0012H\u0002J\u0014\u0010\u009b\u0003\u001a\u00030Ç\u00012\b\u0010\u009c\u0003\u001a\u00030µ\u0001H\u0002J\n\u0010\u009d\u0003\u001a\u00030Ç\u0001H\u0002J\n\u0010\u009e\u0003\u001a\u00030Ç\u0001H\u0002J.\u0010\u009f\u0003\u001a\u00030Ç\u0001*\u00030ë\u00012\u001c\u0010 \u0003\u001a\u0017\u0012\u0005\u0012\u00030¢\u0003\u0012\u0005\u0012\u00030Ç\u00010¡\u0003¢\u0006\u0003\b£\u0003H\u0082\bJ\n\u0010¤\u0003\u001a\u00030Ç\u0001H\u0016J\u0014\u0010¥\u0003\u001a\u00030Ç\u00012\b\u0010¦\u0003\u001a\u00030µ\u0001H\u0002J\n\u0010§\u0003\u001a\u00030Ç\u0001H\u0016J\n\u0010¨\u0003\u001a\u00030ë\u0001H\u0016J\u0014\u0010©\u0003\u001a\u00030Ç\u00012\b\u0010ª\u0003\u001a\u00030©\u0001H\u0016J\u0014\u0010«\u0003\u001a\u00030Ç\u00012\b\u0010ª\u0003\u001a\u00030©\u0001H\u0016J\u0014\u0010¬\u0003\u001a\u00030Ç\u00012\b\u0010ª\u0003\u001a\u00030«\u0001H\u0016J\u0014\u0010\u00ad\u0003\u001a\u00030Ç\u00012\b\u0010ª\u0003\u001a\u00030«\u0001H\u0016J\n\u0010®\u0003\u001a\u00030Ç\u0001H\u0016J\n\u0010¯\u0003\u001a\u00030Ç\u0001H\u0016J\"\u0010°\u0003\u001a\u00030Ç\u00012\n\u0010±\u0003\u001a\u0005\u0018\u00010¿\u00012\n\u0010²\u0003\u001a\u0005\u0018\u00010¿\u0001H\u0016J\f\u0010³\u0003\u001a\u0005\u0018\u00010\u0088\u0001H\u0016J\n\u0010´\u0003\u001a\u00030Ç\u0001H\u0016J\u0013\u0010µ\u0003\u001a\u00030Ç\u00012\u0007\u0010¶\u0003\u001a\u00020\u0012H\u0016J\u0013\u0010·\u0003\u001a\u00030Ç\u00012\u0007\u0010\u0081\u0003\u001a\u00020\u0012H\u0016J(\u0010¸\u0003\u001a\u00030Ç\u00012\b\u0010¹\u0003\u001a\u00030Ï\u00022\b\u0010º\u0003\u001a\u00030²\u00012\b\u0010»\u0003\u001a\u00030²\u0001H\u0016J\t\u0010¼\u0003\u001a\u00020\u0012H\u0016J\t\u0010½\u0003\u001a\u00020\u0012H\u0016J\u001f\u0010¾\u0003\u001a\u00030Ç\u00012\n\u0010¿\u0003\u001a\u0005\u0018\u00010¿\u00012\u0007\u0010À\u0003\u001a\u00020\u0012H\u0016J\t\u0010Á\u0003\u001a\u00020\u0012H\u0016J\u001d\u0010Â\u0003\u001a\u00030Ç\u00012\b\u0010Ã\u0003\u001a\u00030²\u00012\u0007\u0010\u0081\u0003\u001a\u00020\u0012H\u0002J\u0014\u0010Ä\u0003\u001a\u00030Ç\u00012\b\u0010Å\u0003\u001a\u00030¿\u0001H\u0002J\n\u0010Æ\u0003\u001a\u00030Ç\u0001H\u0002J\u0014\u0010Ç\u0003\u001a\u00030Ç\u00012\b\u0010Î\u0001\u001a\u00030É\u0001H\u0002J%\u0010È\u0003\u001a\u00030Ç\u00012\u000f\u0010É\u0003\u001a\n\u0012\u0005\u0012\u00030¿\u00010Ê\u00032\b\u0010Ë\u0003\u001a\u00030²\u0001H\u0002J\u0018\u0010Ì\u0003\u001a\u00030Ç\u00012\f\b\u0002\u0010Í\u0003\u001a\u0005\u0018\u00010¿\u0001H\u0002J\u0013\u0010Î\u0003\u001a\u00030Ç\u00012\u0007\u0010Ï\u0003\u001a\u00020\u0005H\u0017J\n\u0010Ð\u0003\u001a\u00030Ç\u0001H\u0002J\u0014\u0010Ñ\u0003\u001a\u00030Ç\u00012\b\u0010µ\u0002\u001a\u00030²\u0001H\u0016J\n\u0010Ò\u0003\u001a\u00030Ç\u0001H\u0016J\u0014\u0010Ó\u0003\u001a\u00030µ\u00012\b\u0010Ô\u0003\u001a\u00030²\u0001H\u0016J\u0013\u0010Õ\u0003\u001a\u00030Ç\u00012\u0007\u0010Ö\u0003\u001a\u00020\u0012H\u0002J\u000f\u0010×\u0003\u001a\u00030Ç\u0001*\u00030ë\u0001H\u0002J\n\u0010Ø\u0003\u001a\u00030Ç\u0001H\u0003J\t\u0010Ù\u0003\u001a\u00020\u0012H\u0016J\u0013\u0010Ú\u0003\u001a\u00020\u00122\b\u0010ÿ\u0002\u001a\u00030¿\u0001H\u0016J\t\u0010Û\u0003\u001a\u00020\u0012H\u0016J\u0014\u0010Ü\u0003\u001a\u00030Ç\u00012\b\u0010µ\u0002\u001a\u00030²\u0001H\u0016J\n\u0010Ý\u0003\u001a\u00030Ç\u0001H\u0016R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b%\u0010&R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b*\u0010+R\u001d\u0010-\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u001d\u001a\u0004\b/\u00100R\u001d\u00102\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u001d\u001a\u0004\b4\u00105R\u001d\u00107\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u001d\u001a\u0004\b9\u0010:R\u001d\u0010<\u001a\u0004\u0018\u00010=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u001d\u001a\u0004\b>\u0010?R\u001d\u0010A\u001a\u0004\u0018\u00010B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u001d\u001a\u0004\bC\u0010DR\u001d\u0010F\u001a\u0004\u0018\u00010G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u001d\u001a\u0004\bH\u0010IR\u001d\u0010K\u001a\u0004\u0018\u00010L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u001d\u001a\u0004\bM\u0010NR\u001d\u0010P\u001a\u0004\u0018\u00010Q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\u001d\u001a\u0004\bR\u0010SR\u001d\u0010U\u001a\u0004\u0018\u00010V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u001d\u001a\u0004\bW\u0010XR\u001d\u0010Z\u001a\u0004\u0018\u00010[8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010\u001d\u001a\u0004\b\\\u0010]R\u001d\u0010_\u001a\u0004\u0018\u00010`8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\u001d\u001a\u0004\ba\u0010bR\u001d\u0010d\u001a\u0004\u0018\u00010e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010\u001d\u001a\u0004\bf\u0010gR\u001d\u0010i\u001a\u0004\u0018\u00010j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bm\u0010\u001d\u001a\u0004\bk\u0010lR\u001d\u0010n\u001a\u0004\u0018\u00010o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010\u001d\u001a\u0004\bp\u0010qR\u001d\u0010s\u001a\u0004\u0018\u00010t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bw\u0010\u001d\u001a\u0004\bu\u0010vR\u001d\u0010x\u001a\u0004\u0018\u00010y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b|\u0010\u001d\u001a\u0004\bz\u0010{R\u001f\u0010}\u001a\u0004\u0018\u00010~8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010\u001d\u001a\u0005\b\u007f\u0010\u0080\u0001R\"\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0086\u0001\u0010\u001d\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\"\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008b\u0001\u0010\u001d\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\"\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0090\u0001\u0010\u001d\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\"\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008d\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0093\u0001\u0010\u001d\u001a\u0006\b\u0092\u0001\u0010\u008f\u0001R\"\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u008d\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0096\u0001\u0010\u001d\u001a\u0006\b\u0095\u0001\u0010\u008f\u0001R\"\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u008d\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0099\u0001\u0010\u001d\u001a\u0006\b\u0098\u0001\u0010\u008f\u0001R\u001a\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001a\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u0083\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009f\u0001\u0010\u0085\u0001R\"\u0010 \u0001\u001a\u0005\u0018\u00010¡\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¤\u0001\u0010\u001d\u001a\u0006\b¢\u0001\u0010£\u0001R\u0017\u0010¥\u0001\u001a\u00020\u00128BX\u0082\u0004¢\u0006\b\u001a\u0006\b¥\u0001\u0010¦\u0001R\u0017\u0010§\u0001\u001a\n\u0012\u0005\u0012\u00030©\u00010¨\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010ª\u0001\u001a\n\u0012\u0005\u0012\u00030«\u00010¨\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010¬\u0001\u001a\u00030\u00ad\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b°\u0001\u0010\u001d\u001a\u0006\b®\u0001\u0010¯\u0001R\u0010\u0010±\u0001\u001a\u00030²\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010³\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010´\u0001\u001a\u00030µ\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¶\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010·\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¸\u0001\u001a\u00030²\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¹\u0001\u001a\u0005\u0018\u00010º\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010»\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010¼\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010½\u0001\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¾\u0001\u001a\u0005\u0018\u00010¿\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010À\u0001\u001a\u00030Á\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010Â\u0001R\u0013\u0010Ã\u0001\u001a\u00030Ä\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010Å\u0001R\u0013\u0010Ï\u0001\u001a\u00030Ð\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010Ñ\u0001R \u0010Ò\u0001\u001a\u00030Ó\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÖ\u0001\u0010\u001d\u001a\u0006\bÔ\u0001\u0010Õ\u0001R \u0010×\u0001\u001a\u00030Ø\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÛ\u0001\u0010\u001d\u001a\u0006\bÙ\u0001\u0010Ú\u0001R\u0010\u0010Ü\u0001\u001a\u00030µ\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ý\u0001\u001a\u00030µ\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010Þ\u0001\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010ß\u0001\u001a\u00030µ\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010à\u0001\u001a\u00030µ\u0001X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010á\u0001\u001a\u00030µ\u0001X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010â\u0001\u001a\u00030µ\u0001X\u0082D¢\u0006\u0002\n\u0000R\u0018\u0010ã\u0001\u001a\u00030²\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bä\u0001\u0010å\u0001R\u0010\u0010æ\u0001\u001a\u00030ç\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010è\u0001\u001a\u0005\u0018\u00010é\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010ê\u0001\u001a\u00030ë\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bî\u0001\u0010\u001d\u001a\u0006\bì\u0001\u0010í\u0001R \u0010ï\u0001\u001a\u00030ë\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bñ\u0001\u0010\u001d\u001a\u0006\bð\u0001\u0010í\u0001R \u0010ò\u0001\u001a\u00030ó\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bö\u0001\u0010\u001d\u001a\u0006\bô\u0001\u0010õ\u0001R \u0010÷\u0001\u001a\u00030ø\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bû\u0001\u0010\u001d\u001a\u0006\bù\u0001\u0010ú\u0001R \u0010ü\u0001\u001a\u00030ë\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bþ\u0001\u0010\u001d\u001a\u0006\bý\u0001\u0010í\u0001R \u0010ÿ\u0001\u001a\u00030\u0080\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0083\u0002\u0010\u001d\u001a\u0006\b\u0081\u0002\u0010\u0082\u0002R\"\u0010\u0084\u0002\u001a\u0005\u0018\u00010\u0085\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0088\u0002\u0010\u001d\u001a\u0006\b\u0086\u0002\u0010\u0087\u0002R\u0010\u0010\u0089\u0002\u001a\u00030\u008a\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u008b\u0002\u001a\u00030²\u0001X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008c\u0002\u0010å\u0001\"\u0006\b\u008d\u0002\u0010\u008e\u0002R\u0012\u0010\u008f\u0002\u001a\u0005\u0018\u00010\u0090\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ß\u0003"}, d2 = {"Lcom/obric/assistant/component/ObricChatPageStateComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/obric/assistant/callback/IAnimationCallback;", "Lcom/obric/assistant/callback/IPageStateCallback;", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility$ChangeListener;", "Lcom/larus/im/bean/conversation/Conversation;", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "Lcom/obric/assistant/ability/chat/page/IObricFloatChatPageStateCoreAbility;", "Lcom/obric/assistant/interaction/base/interact/IObserveToken;", "<init>", "()V", "viewModel", "Lcom/obric/assistant/component/viewmodel/OrionChatPageStateViewModel;", "getViewModel", "()Lcom/obric/assistant/component/viewmodel/OrionChatPageStateViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "paused", "", "isStopped", "lastOnStopUptimeMs", "", "voiceNoiseReductionUpgradeDialogJob", "Lkotlinx/coroutines/Job;", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "Lkotlin/Lazy;", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "conversationAbility$delegate", "multimodalAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "titleAbility", "Lcom/larus/chat/api/IChatTitleAbility;", "getTitleAbility", "()Lcom/larus/chat/api/IChatTitleAbility;", "titleAbility$delegate", "listAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getListAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "listAbility$delegate", "windowStyleAbility", "Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "getWindowStyleAbility", "()Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "windowStyleAbility$delegate", "clickTalkAbility", "Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "getClickTalkAbility", "()Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "clickTalkAbility$delegate", "floatingAbility", "Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "getFloatingAbility", "()Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "floatingAbility$delegate", "intercomAbility", "Lcom/obric/assistant/ability/IObricIntercomAbility;", "getIntercomAbility", "()Lcom/obric/assistant/ability/IObricIntercomAbility;", "intercomAbility$delegate", "specialInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "getSpecialInputAbility", "()Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "specialInputAbility$delegate", "collectAbility", "Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "getCollectAbility", "()Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "collectAbility$delegate", "caseAbility", "Lcom/larus/bmhome/chat/component/showcase/IChatCaseMessageAbility;", "getCaseAbility", "()Lcom/larus/bmhome/chat/component/showcase/IChatCaseMessageAbility;", "caseAbility$delegate", "instructionAbility", "Lcom/obric/assistant/ability/chat/instruction/IObricInstructionAbility;", "getInstructionAbility", "()Lcom/obric/assistant/ability/chat/instruction/IObricInstructionAbility;", "instructionAbility$delegate", "fastSendImageAbility", "Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "getFastSendImageAbility", "()Lcom/larus/bmhome/chat/component/fastsend/IFastSendImageAbility;", "fastSendImageAbility$delegate", "inputUIAbility", "Lcom/obric/assistant/chat/bottom/sub/IObricChatInputUIAbility;", "getInputUIAbility", "()Lcom/obric/assistant/chat/bottom/sub/IObricChatInputUIAbility;", "inputUIAbility$delegate", "inputLogicAbility", "Lcom/obric/assistant/chat/bottom/sub/IObricChatInputLogicAbility;", "getInputLogicAbility", "()Lcom/obric/assistant/chat/bottom/sub/IObricChatInputLogicAbility;", "inputLogicAbility$delegate", "photoActionAbility", "Lcom/obric/assistant/ability/IObricPhotoActionAbility;", "getPhotoActionAbility", "()Lcom/obric/assistant/ability/IObricPhotoActionAbility;", "photoActionAbility$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "chatRoot", "Landroid/view/ViewGroup;", "getChatRoot", "()Landroid/view/ViewGroup;", "chatRoot$delegate", "messageList", "Landroidx/recyclerview/widget/RecyclerView;", "getMessageList", "()Landroidx/recyclerview/widget/RecyclerView;", "messageList$delegate", "input", "Landroid/widget/FrameLayout;", "getInput", "()Landroid/widget/FrameLayout;", "input$delegate", "bottomLayout", "getBottomLayout", "bottomLayout$delegate", "chatListParent", "getChatListParent", "chatListParent$delegate", "titleContainer", "getTitleContainer", "titleContainer$delegate", "inputUiContract", "Lcom/larus/bmhome/ability/ChatInputUiContract;", "getInputUiContract", "()Lcom/larus/bmhome/ability/ChatInputUiContract;", "actionBarContainer", "getActionBarContainer", "gestureView", "Lcom/obric/assistant/view/ObricIconSwipeUpView;", "getGestureView", "()Lcom/obric/assistant/view/ObricIconSwipeUpView;", "gestureView$delegate", "isScreenLocked", "()Z", "chatStyleChangedCallbackList", "", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "dragStateCallbackList", "Lcom/obric/assistant/ability/IDraggingStateCallback;", "autoIncreaseUtils", "Lcom/obric/assistant/util/AutoIncreaseUtils;", "getAutoIncreaseUtils", "()Lcom/obric/assistant/util/AutoIncreaseUtils;", "autoIncreaseUtils$delegate", "halfScreenHeight", "", "cancelMoveTaskToBack", "halfChangeThreshold", "", "isFirstOpenSpecialInputWindow", "isLongPressAiStart", "messageListHeight", "pendingComplexTaskReplyTarget", "Lcom/obric/assistant/ability/PendingComplexTaskReplyTarget;", "observedMessageListAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "latestKnownServerIndex", "boundStartupReadyAttemptId", "", "messageListAdapterObserver", "com/obric/assistant/component/ObricChatPageStateComponent$messageListAdapterObserver$1", "Lcom/obric/assistant/component/ObricChatPageStateComponent$messageListAdapterObserver$1;", "changeListener", "com/obric/assistant/component/ObricChatPageStateComponent$changeListener$1", "Lcom/obric/assistant/component/ObricChatPageStateComponent$changeListener$1;", "checkCloseClickTalk", "", "msg", "Lcom/larus/im/bean/message/Message;", "isObricActionBarMessage", "ext", "", "handleMessageExtWhenStreamEnd", "message", "streamObserver", "com/obric/assistant/component/ObricChatPageStateComponent$streamObserver$1", "Lcom/obric/assistant/component/ObricChatPageStateComponent$streamObserver$1;", "animationHelper", "Lcom/obric/assistant/util/ChatPageStateAnimationHelper;", "getAnimationHelper", "()Lcom/obric/assistant/util/ChatPageStateAnimationHelper;", "animationHelper$delegate", "excludeViewIds", "", "getExcludeViewIds", "()[I", "excludeViewIds$delegate", "maxRadius", "minRadius", "navigatorSimplify", "titleHideTranslationX", "titleShowTranslationX", "titleHideAlpha", "titleShowAlpha", "statusBarHeight", "getStatusBarHeight", "()I", "keva", "Lcom/bytedance/keva/Keva;", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "keepAliveAnchorView", "Landroid/view/View;", "getKeepAliveAnchorView", "()Landroid/view/View;", "keepAliveAnchorView$delegate", "fakeBgView", "getFakeBgView", "fakeBgView$delegate", "gradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getGradientDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "gradientDrawable$delegate", "slidingBar", "Lcom/obric/assistant/view/ObricSwipeGestureView;", "getSlidingBar", "()Lcom/obric/assistant/view/ObricSwipeGestureView;", "slidingBar$delegate", "realBottomView", "getRealBottomView", "realBottomView$delegate", "realTopView", "Landroid/widget/RelativeLayout;", "getRealTopView", "()Landroid/widget/RelativeLayout;", "realTopView$delegate", "actionBarAvatar", "Lcom/larus/bmhome/view/TitleAvatarImageView;", "getActionBarAvatar", "()Lcom/larus/bmhome/view/TitleAvatarImageView;", "actionBarAvatar$delegate", "lastState", "Lcom/obric/assistant/data/ObricFloatChatPageState;", "contentViewId", "getContentViewId", "setContentViewId", "(I)V", "cachedActivity", "Landroidx/fragment/app/FragmentActivity;", "runIfPageLifecycleValid", "action", "Lkotlin/Function0;", "isPageStateSwitchSupported", "ensureFullScreenStateForUnsupportedHost", WindowEvent.Params.REASON, "velocity", "(Ljava/lang/String;Ljava/lang/Float;)V", "onCreate", "mobEnterChatActivity", "isStartFromLauncher", "Landroid/content/Intent;", "onAttach", "onViewCreated", "view", "onStart", "onResume", "keepOmniQueryMessageAtBottom", WindowEvent.Params.TRIGGER, "updatePendingComplexTaskReplyTarget", "postTryConsumePendingComplexTaskReplyTarget", "ensureMessageListAdapterObserver", "tryConsumePendingComplexTaskReplyTarget", "setIsShownAfterResponded", "dealWithAgent", "dealWithAllSearch", "allSearch", "restoreWindowInputDraftIfNeeded", "isOpenFromSingleClick", "saveDismissInfo", "onPause", "onStop", "onDestroy", "shouldHandleAutoIncreaseWindowChange", "increase", "changeToDragging", "height", "changeToChatWindow", "applyImmediately", "changeToHalfInternal", "useAnim", "topEmptyHeight", "(ZILjava/lang/Float;)V", "handleBiometricAuthentication", "(ZLjava/lang/Float;)V", "handleAuthenticationFailure", "requestDismissKeyguard", "(ZLjava/lang/Float;Z)V", "changeToHalf", "requestBiometricAuthentication", "Lcom/obric/assistant/ability/PageStateChangedReason;", "(ZILjava/lang/Float;ZZLcom/obric/assistant/ability/PageStateChangedReason;)V", "changeToFull", "(Ljava/lang/Float;ZLjava/lang/String;)V", "createFullScreenPageState", "Lcom/obric/assistant/data/ObricFloatChatPageStateFullScreen;", "(ZLjava/lang/Float;Ljava/lang/String;)Lcom/obric/assistant/data/ObricFloatChatPageStateFullScreen;", "shouldRestoreFullScreenOnRecreate", "fullScreenRestorePreviousState", "isCompactWindowState", "updateFullScreenRestoreArguments", "restore", "Landroid/os/Bundle;", "removeFullScreenRestoreShapeArguments", "getPanelTopHeightInKeyGuard", "getMessageListContentHeightFast", "finishWithAnimation", "isUseOverlayAnim", "getConversationId", "getConversation", "getBot", "Lcom/larus/im/bean/bot/BotModel;", "conversationFlow", "Lkotlinx/coroutines/flow/Flow;", "botFlow", "onPerformBack", "leaveMethod", "isMainBotPage", "changeToDismiss", "moveTaskToBack", "fromUser", "dismissWindow", "(ZLjava/lang/Boolean;ZZ)V", "getPageState", "isChatWindow", "isHalfScreen", "getPageStateToString", WindowEvent.WindowOpenPerfResult.CANCEL, "isFullScreen", "isVisible", "isMainBot", "isCreateSubCvs", "currentArgument", "bindChatStartupReadyIfNeeded", "onPageStateChange", "pageState", "onChangeToWindow", "Lcom/obric/assistant/data/ObricFloatChatPageStateChatWindow;", "onChangeToHalf", "Lcom/obric/assistant/data/ObricFloatChatPageStateHalfWindow;", "cancelPaddingAnim", "onChangeToFull", "onChangeToDismiss", "onChangeToDragging", "onChatStyleChanged", "chatWindowStyle", "getTopEmptyHeight", "switchMenuEntranceStatus", "showBottomMenu", "isReset", "from", "onAttachmentPanelVisibleChanged", "visible", "onInstructionVisibleChanged", "instructionOpen", "onClickTopEmptyView", "onTouchStatusBarArea", "onTouchIntercept", "event", "Landroid/view/MotionEvent;", "onVoiceVisible", "onSpeakerVisible", "onPopupOrDialogShow", "show", "onActionBarScrollStateChanged", "state", "onInputReplyPanelVisibleChange", "inVisibleState", "onSecondaryMenuVisibleChange", "onMessageModifyPanelVisibleChange", "clickTalkTimeOut", "onContinuousTalkStateChanged", "Lcom/larus/audio/call/mgr/AVKitDuplexState;", "getCurrentPageTopEmptyHeight", "setTopEmptyHeight", "value", "maxTopEmptyHeight", "resetChatListUI", "setChildTranslationExcludeWindow", "translationY", "onChangeToHalfThreshold", "onChangeToFullThreshold", "updateConstraintParams", "update", "Lkotlin/Function1;", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "Lkotlin/ExtensionFunctionType;", "hideTitleBackIcon", "changeTitleBackIcon", "progress", "refresh", "getAnchorView", "registerChatStyleChangedCallback", "callback", "unregisterChatStyleChangedCallback", "registerDragProgressCallback", "unregisterDragProgressCallback", "onScreenOff", "onScreenUnlocked", "onAsrResultEnd", "asrTaskID", "text", "getChatMessageList", "handleMessageListOnTouched", "onMenuEntranceStatusChanged", "showMenu", "onTaskSkillPanelVisibleChanged", "handleChatSettingResult", "bundle", "requestCode", "resultCode", "getDisableFastButton", "getDisableBackToLastViewedButton", "changePageState", "pageStateStr", "isBeforeWindowShow", "isChatWindowOrHalfScreen", "onBottomPanelVisibleChanged", "type", "registerStream", "conversationId", "unregisterStream", "handleMessageNeedPermissions", "requestEachPermission", "permissions", "", "permissionIndex", "updateItemOnDisplay", "enterMethod", "onChange", "new", "setInputHint", "onTopEmptyHeightChanged", "onWindowDismiss", "getBaseAlpha", "id", "excludeFromRecents", "exclude", "removeFromParent", "init", "needJumpAutoIncrease", "onTouchDownSlide", "isTtsEnable", "setMessageListHeight", "resetIsFirstOpenSpecialInput", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatPageStateComponent extends BaseContentWidget implements hca.a, hca.d, com.larus.bmhome.chat.component.cvs.y.a<wc9.e>, laa.d, taa.a, IObserveToken {
    public static final com.larus.bmhome.view.b v2 = null;
    public static final String[] x2 = null;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final float G1;
    public final Lazy H;
    public laa.w H0;
    public final float H1;
    public final Lazy I;
    public final Lazy J;
    public final Lazy K;
    public final Lazy L;
    public RecyclerView.Adapter<?> L0;
    public final Keva L1;
    public final Lazy M;
    public final Lazy M1;
    public final Lazy N;
    public final Lazy O;
    public final Lazy P;
    public long P0;
    public final Lazy P1;
    public final Lazy Q;
    public final Lazy Q1;
    public final Lazy R;
    public final Lazy S;
    public final Lazy S1;
    public final List<hca.b> T;
    public final Lazy T1;
    public final List<laa.a> U;
    public final Lazy V;
    public String V0;
    public final Lazy V1;
    public int W;
    public boolean X;
    public float Y;
    public boolean Z;
    public final ObricChatPageStateComponent$messageListAdapterObserver$1 b1;
    public final Lazy b2;
    public final ObricChatPageStateComponent$changeListener$1 g1;
    public ObricFloatChatPageState g2;
    public final z h1;
    public int h2;
    public boolean k0;
    public final Lazy k1;
    public final com.larus.ui.arch.vm.internal.l m;
    public boolean n;
    public boolean o;
    public long p;
    public int p0;
    public final Lazy p1;
    public FragmentActivity p2;
    public Job q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final float v1;
    public final Lazy w;
    public final Lazy x;
    public final float x1;
    public final Lazy y;
    public final boolean y1;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements com.larus.platform.api.g1.c {
        public final /* synthetic */ List<String> a;
        public final /* synthetic */ int b;
        public final /* synthetic */ List<String> c;
        public final /* synthetic */ ObricChatPageStateComponent d;

        public final void onGoSettingsDialogShow() {
        }

        public final void onSettingPageReturn() {
            FLogger.a.i("OrionChatPageStateComponent", "requestEachPermission permission: " + this.a + " onSettingPageReturn");
            if ((this.b + 1) >= this.c.size()) goto L6;
            final ObricChatPageStateComponent r0 = this.d;
            final List<String> r1 = this.c;
            final int r2 = this.b;
            com.larus.utils.t0.d(new g1(r0, r1, r2), 500);
            return;
        }

        public final void onGoSettingsDialogDismiss(boolean r4) {
            FLogger.a.i("OrionChatPageStateComponent", "requestEachPermission permission: " + this.a + " onGoSettingsDialogDismiss isConfirmed: " + r4);
            if ((this.b + 1) >= this.c.size()) goto L6;
            final ObricChatPageStateComponent r5 = this.d;
            final List<String> r0 = this.c;
            final int r1 = this.b;
            com.larus.utils.t0.d(new h1(r5, r0, r1), 500);
            return;
        }

        public b(List<String> r1, int r2, List<String> r3, ObricChatPageStateComponent r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void onResult(boolean r4, List<String> r5, List<String> r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r5, "grantedList");
            Intrinsics.checkNotNullParameter(r6, "deniedList");
            FLogger.a.i("OrionChatPageStateComponent", "requestEachPermission permission: " + this.a + " onResult allGranted: " + r4 + ", grantedList: " + r5 + ", deniedList: " + r6 + ", isGoSettingsDialogShown: " + r7);
            if (r4 == true) goto L6;
            if (r7 == false) goto L6;
            return;
        L6:
            if ((this.b + 1) >= this.c.size()) goto L10;
            final ObricChatPageStateComponent r8 = this.d;
            final List<String> r9 = this.c;
            final int r10 = this.b;
            com.larus.utils.t0.d(new i1(r8, r9, r10), 500);
            return;
        }
    }

    public static final class c implements Function0<ld8.n> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ld8.n.class));
        }
    }

    public static final class d implements Function0<laa.f> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.f.class));
        }
    }

    public static final class e implements Function0<laa.j> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.j.class));
        }
    }

    public static final class f implements Function0<com.larus.bmhome.chat.component.collection.o> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.collection.o.class));
        }
    }

    public static final class g implements Function0<com.larus.bmhome.chat.component.showcase.x> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.showcase.x.class));
        }
    }

    public static final class h implements Function0<qaa.a> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(qaa.a.class));
        }
    }

    public static final class i implements Function0<com.larus.bmhome.chat.component.fastsend.e0> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.fastsend.e0.class));
        }
    }

    public static final class j implements Function0<ada.c> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ada.c.class));
        }
    }

    public static final class k implements Function0<ada.b> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ada.b.class));
        }
    }

    public static final class l implements Function0<laa.h> {
        public final /* synthetic */ AttachReceiver a;

        public l(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.h.class));
        }
    }

    public static final class m implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public m(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    public static final class n implements Function0<com.larus.bmhome.chat.component.cvs.y> {
        public final /* synthetic */ AttachReceiver a;

        public n(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.cvs.y.class));
        }
    }

    public static final class o implements Function0<com.larus.bmhome.chat.component.bottom.multimodal.g> {
        public final /* synthetic */ AttachReceiver a;

        public o(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.multimodal.g.class));
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.component.ObricChatPageStateComponent$onResume$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.component.ObricChatPageStateComponent$onResume$1", f = "ObricChatPageStateComponent.kt", i = {}, l = {708}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricChatPageStateComponent this$0;

        public AnonymousClass1(ObricChatPageStateComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            com.obric.assistant.guide.ui.x0.a.b(this.this$0.getContext());
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            this.label = 1;
            if (DelayKt.delay(3000, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.component.ObricChatPageStateComponent$onResume$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.component.ObricChatPageStateComponent$onResume$3", f = "ObricChatPageStateComponent.kt", i = {0}, l = {800}, m = "invokeSuspend", n = {"sp"}, s = {"L$0"})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ ObricChatPageStateComponent this$0;

        /* JADX INFO: renamed from: com.obric.assistant.component.ObricChatPageStateComponent$onResume$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.assistant.component.ObricChatPageStateComponent$onResume$3$1", f = "ObricChatPageStateComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
                return new AnonymousClass1(r2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                com.obric.assistant.t1.a.U();
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass3(ObricChatPageStateComponent r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            SharedPreferences r2 = (SharedPreferences) this.L$0;
            ResultKt.throwOnFailure(r10);
        L28:
            if (r2 == null) goto L34;
            SharedPreferences.Editor r11 = r2.edit();     // Catch: Exception -> L31
            r11.putInt("obric_need_add_launcher", 0);     // Catch: Exception -> L31
            r11.commit();     // Catch: Exception -> L31
        L31:
            e = move-exception;
            FLogger.a.e("OrionChatPageStateComponent", "update obric_need_add_launcher, error: " + e);
        L34:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            SharedPreferences r12 = this.this$0.getContext().getSharedPreferences("obric_privacy_cache", 4);
            if (r12 != null) goto L37;
            Integer r6 = null;
        L13:
            if (r6 == null) goto L18;
            if (r6.intValue() != 1) goto L18;
            boolean r7 = true;
        L19:
            if (r7 == false) goto L34;
            FLogger r8 = FLogger.a;
            StringBuilder r9 = new StringBuilder("alreadyEnableOnPrivacyPage, ");
            if (r12 == null) goto L23;
            Integer r13 = Boxing.boxInt(r12.getInt("obric_need_add_launcher", 0));
        L24:
            r9.append(r13);
            r8.i("OrionChatPageStateComponent", r9.toString());
            MainCoroutineDispatcher r14 = Dispatchers.getMain();
            AnonymousClass1 r15 = new AnonymousClass1(null);
            this.L$0 = r12;
            this.label = 1;
            if (BuildersKt.withContext(r14, r15, this) != r0) goto L27;
            return r0;
        L27:
            r2 = r12;
            goto L28
        L23:
            r13 = null;
        L18:
            r7 = false;
            goto L19
        L37:
            r6 = Boxing.boxInt(r12.getInt("obric_need_add_launcher", 0));     // Catch: Exception -> L11
            goto L13
        }
    }

    public static final class p implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public p(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ICoreInputAbility.class));
        }
    }

    public static final class q implements Function0<va8.o> {
        public final /* synthetic */ AttachReceiver a;

        public q(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.o.class));
        }
    }

    public static final class r implements Function0<ry8.b> {
        public final /* synthetic */ AttachReceiver a;

        public r(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ry8.b.class));
        }
    }

    public static final class s implements Function0<u7> {
        public final /* synthetic */ AttachReceiver a;

        public s(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(u7.class));
        }
    }

    public static final class t implements Function0<laa.m> {
        public final /* synthetic */ AttachReceiver a;

        public t(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.m.class));
        }
    }

    public static final class u implements Function0<maa.e> {
        public final /* synthetic */ AttachReceiver a;

        public u(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(maa.e.class));
        }
    }

    public static final class v implements Function0<de8.c> {
        public final /* synthetic */ AttachReceiver a;

        public v(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(de8.c.class));
        }
    }

    public static final class w implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public w(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class x implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public x(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class y implements Function0<ViewModelProvider.Factory> {
        public static final y a = null;

        static {
            a = new y();
        }

        public y() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    public static final class z implements nf9.c {
        public String a;
        public final /* synthetic */ ObricChatPageStateComponent b;

        public final void B(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
        }

        public final void C(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
        }

        public z(ObricChatPageStateComponent r1) {
            this.b = r1;
            this.a = "";
        }

        public final void A(Message r28) {
            Intrinsics.checkNotNullParameter(r28, "message");
            ObricChatPageStateComponent r2 = this.b;
            com.larus.bmhome.view.b r3 = ObricChatPageStateComponent.v2;
            r2.getClass();
            if (r28 != null) goto L5;
            return;
        L5:
            if (com.larus.bmhome.chat.bean.d.j0(r28) == false) goto L80;
            Map r0 = r28.getExt();
            if (r0 == null) goto L9;
            String r1 = (String) r0.get("client_meta");
        L10:
            int r4 = 1;
            if (r1 != null) goto L13;
        L16:
            boolean r6 = true;
        L17:
            if (r6 == true) goto L81;
            JsonObject r5 = JsonParser.parseString(r1).getAsJsonObject();
            if (r5.has("need_permissions") == false) goto L82;
            Gson r7 = new Gson();
            Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L25
            Object r9 = Result.constructor-impl((List) r7.fromJson(r5.get("need_permissions"), new f1().getType()));     // Catch: Throwable -> L25
        L28:
            if (Result.isFailure-impl(r9) == false) goto L30;
            r9 = null;
        L30:
            List r10 = (List) r9;
            List r11 = r10;
            if (r11 != null) goto L33;
        L36:
            boolean r12 = true;
        L37:
            if (r12 == true) goto L83;
            FLogger.a.i("OrionChatPageStateComponent", "handleMessageNeedPermissions response permissions: " + r10);
            ArrayList r13 = new ArrayList();
            Iterator r14 = r10.iterator();
        L41:
            if (r14.hasNext() == false) goto L66;
            String r15 = (String) r14.next();
            if (Build.VERSION.SDK_INT < 23) goto L64;
            Context r16 = r2.getContext();
            ArrayList r17 = new ArrayList();
            Object[] r18 = new Object[r4];
            r18[0] = r15;
            f06.b r19 = new f06.b("auto_cert_com_obric_assistant_component_ObricChatPageStateComponent_android_content_Context_checkSelfPermission");
            g06.a r110 = (g06.a) ApiHookConfig.b.get(102608);
            if (r110 == null) goto L47;
            f06.a[] r111 = r110.i;
        L48:
            f06.a[] r112 = r111;
            int r113 = r112.length;
            int r114 = 0;
        L50:
            if (r114 >= r113) goto L57;
            f06.a r20 = r112[r114];
            int r22 = r114;
            int r23 = r113;
            f06.a[] r24 = r112;
            f06.b r25 = r19;
            Object[] r26 = r18;
            f06.d r115 = r20.preInvoke(102608, "android/content/Context", "checkSelfPermission", r16, r26, "int", r25);     // Catch: Exception -> L68
            if (r115.a == true) goto L59;
            r17.add(r20);     // Catch: Exception -> L68
        L59:
            if (r115.a == false) goto L61;
            int r21 = ((Integer) r115.b).intValue();
        L62:
            if (r21 == 0) goto L64;
            r13.add(r15);
        L65:
            r4 = 1;
            goto L41
        L61:
            r21 = r16.checkSelfPermission(r15);
        L56:
            r114 = r22 + 1;
            r113 = r23;
            r112 = r24;
            r19 = r25;
            r18 = r26;
            goto L50
        L57:
            r115 = new f06.d(false, null);
            goto L59
        L47:
            r111 = ApiHookConfig.d;
        L64:
            FLogger.a.i("OrionChatPageStateComponent", "handleMessageNeedPermissions permission: " + r15 + " has been granted");
            goto L65
        L66:
            FLogger.a.i("OrionChatPageStateComponent", "handleMessageNeedPermissions need request permissions: " + r13);
            r2.T4(r13, 0);
            return;
        L83:
            return;
        L33:
            if (r11.isEmpty() == true) goto L36;
            r12 = false;
        L25:
            th = move-exception;
            Result.Companion r27 = Result.Companion;
            r9 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L28
        L82:
            return;
        L81:
            return;
        L13:
            if (r1.length() == 0) goto L16;
            r6 = false;
            goto L17
        L9:
            r1 = null;
            goto L10
        }
    }

    public final void Ht() {
    }

    public final void Nq() {
    }

    public final int mb() {
        return 0;
    }

    public final void onStart() {
        this.o = false;
        this.p = 0;
    }

    public final void onStop() {
        this.o = true;
        this.p = SystemClock.uptimeMillis();
        Job r1 = this.q;
        if (r1 == null) goto L5;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L5:
        this.q = null;
        ObricFloatChatPageState r0 = getPageState();
        ObricFloatChatPageData.Companion.getClass();
        if ((r0 instanceof vda.a) == false) goto L11;
        va8.o r2 = (va8.o) this.v.getValue();
        if (r2 == null) goto L12;
        r2.c3();
        return;
    L12:
        return;
    }

    public final void qT(Boolean r1, boolean r2, boolean r3) {
    }

    public final void sN(int r1) {
    }

    public final void tV() {
    }

    public final void uv() {
        C1(false, true, "onScreenUnlocked");
    }

    public final void xK() {
    }

    public final void ze() {
    }

    static {
        v2 = new com.larus.bmhome.view.b(2131103797, 0.8f, -1, 21, 2131245961);
        x2 = new String[]{"arg_launch_floating_window", "arg_launch_half_screen", "obric_need_translucent", "all_search", "launch_from_agent", "agent_window_state"};
    }

    public final boolean Da() {
        com.larus.bmhome.chat.component.collection.o r0 = (com.larus.bmhome.chat.component.collection.o) this.D.getValue();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        Object r4 = null;
        if (r1 == true) goto L69;
        com.larus.bmhome.chat.component.showcase.x r2 = (com.larus.bmhome.chat.component.showcase.x) this.E.getValue();
        if (r2 != null) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == true) goto L69;
        de8.c r5 = f1();
        if (r5 == null) goto L21;
        Bundle r6 = r5.b;
    L22:
        if (r6 != null) goto L24;
    L26:
        boolean r7 = false;
    L27:
        if (r7 == false) goto L30;
        FLogger.a.i("OrionChatPageStateComponent", "is create sub cvs, not main bot");
        return false;
    L30:
        de8.c r8 = f1();
        if (r8 == null) goto L35;
        Bundle r9 = r8.b;
        if (r9 == null) goto L35;
        String r10 = r9.getString("argConversationId", "");
    L36:
        if (r10 != null) goto L38;
    L41:
        boolean r11 = true;
    L42:
        if (r11 == false) goto L49;
        de8.c r12 = f1();
        if (r12 == null) goto L48;
        Bundle r13 = r12.a;
        if (r13 == null) goto L48;
        r10 = r13.getString("argConversationId", "");
    L48:
        r10 = null;
    L49:
        IAuthModelService r14 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r14 == null) goto L54;
        LiveData r15 = r14.y();
        if (r15 == null) goto L54;
        wc9.e r16 = (wc9.e) r15.getValue();
    L55:
        if (r10 != null) goto L57;
    L60:
        boolean r17 = true;
    L61:
        if (r17 == true) goto L78;
        if (r16 == null) goto L65;
        r4 = r16.a;
    L65:
        if (Intrinsics.areEqual(r10, r4) == true) goto L79;
        return false;
    L79:
        return true;
    L78:
        return true;
    L57:
        if (r10.length() == 0) goto L60;
        r17 = false;
    L54:
        r16 = null;
        goto L55
    L38:
        if (r10.length() == 0) goto L41;
        r11 = false;
    L35:
        r10 = null;
        goto L36
    L24:
        if (r6.getBoolean("is_create_sub_conversation") != true) goto L26;
        r7 = true;
        goto L27
    L21:
        r6 = null;
        goto L22
    L13:
        if (r2.e6() != true) goto L15;
        r3 = true;
    L69:
        FLogger r18 = FLogger.a;
        StringBuilder r19 = new StringBuilder("is collect mode ");
        com.larus.bmhome.chat.component.collection.o r20 = (com.larus.bmhome.chat.component.collection.o) this.D.getValue();
        if (r20 == null) goto L72;
        Boolean r21 = Boolean.valueOf(r20.i0());
    L73:
        r19.append(r21);
        r19.append(", is showcase mode ");
        com.larus.bmhome.chat.component.showcase.x r22 = (com.larus.bmhome.chat.component.showcase.x) this.E.getValue();
        if (r22 == null) goto L76;
        r4 = Boolean.valueOf(r22.e6());
    L76:
        r19.append(r4);
        r18.i("OrionChatPageStateComponent", r19.toString());
        return false;
    L72:
        r21 = null;
        goto L73
    L5:
        if (r0.i0() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final com.obric.assistant.util.s0 E3() {
        return (com.obric.assistant.util.s0) this.k1.getValue();
    }

    public final int G1() {
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r1 = getPageState();
        r0.getClass();
        boolean r2 = ObricFloatChatPageData.a.d(r1);
        int r3 = 0;
        if (r2 == false) goto L5;
    L10:
        ViewGroup.LayoutParams r4 = d4().getLayoutParams();
        if (r4 == null) goto L13;
        int r5 = r4.height;
    L14:
        FrameLayout r6 = i4();
        if (r6 == null) goto L18;
        r3 = (int) r6.getTranslationY();
    L18:
        return r3 + r5;
    L13:
        r5 = 0;
        goto L14
    L5:
        if ((getPageState() instanceof vda.c) == true) goto L10;
        ViewGroup.LayoutParams r7 = d4().getLayoutParams();
        if (r7 != null) goto L20;
        return 0;
    L20:
        return r7.height;
    }

    public final com.obric.assistant.util.j0 G3() {
        return (com.obric.assistant.util.j0) this.V.getValue();
    }

    public final va8.l H3() {
        return (va8.l) this.L.getValue();
    }

    public final boolean Hu() {
        laa.j r0 = (laa.j) this.C.getValue();
        if (r0 == null) goto L9;
        kotlinx.coroutines.flow.b1 r1 = r0.O4();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L41;
        laa.j r3 = (laa.j) this.C.getValue();
        if (r3 == null) goto L22;
        kotlinx.coroutines.flow.b1 r4 = r3.i80();
        if (r4 == null) goto L22;
        laa.v r5 = (laa.v) r4.getValue();
        if (r5 == null) goto L22;
        StateInfo r6 = r5.b;
        if (r6 == null) goto L22;
        if (r6.getRequestType() != 2) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == true) goto L39;
        laa.j r8 = (laa.j) this.C.getValue();
        if (r8 == null) goto L35;
        kotlinx.coroutines.flow.b1 r9 = r8.i80();
        if (r9 == null) goto L35;
        laa.v r10 = (laa.v) r9.getValue();
        if (r10 == null) goto L35;
        StateInfo r11 = r10.b;
        if (r11 == null) goto L35;
        if (r11.getRequestType() != 1) goto L35;
        boolean r12 = true;
    L36:
        if (r12 == true) goto L39;
        ObricTaskStatusManager.a.getClass();
        if (Intrinsics.areEqual(ObricTaskStatusManager.b(), "clarify_complex_task") == true) goto L39;
        return false;
    L35:
        r12 = false;
    L39:
        return true;
    L22:
        r7 = false;
        goto L23
    L41:
        return false;
    L9:
        r2 = false;
        goto L10
    }

    public final boolean JY() {
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r1 = getPageState();
        r0.getClass();
        return ObricFloatChatPageData.a.a(r1);
    }

    public final void N1() {
        pd6.b r0 = pd6.c.a;
        IMultiTaskHostAbility r1 = pd6.c.a(Reflection.getOrCreateKotlinClass(IMultiTaskHostAbility.class));
        if (r1 == null) goto L7;
        boolean r2 = true;
        if (r1.P0() != true) goto L7;
    L8:
        ConstraintLayout.LayoutParams r3 = null;
        if (r2 == false) goto L11;
    L45:
        ry8.b r4 = h4();
        if (r4 == null) goto L57;
        com.larus.platform.api.g0 r5 = r4.C5();
        if (r5 == null) goto L57;
        View r6 = r5.getMultitaskManagementIcon();
        if (r6 == null) goto L57;
        ConstraintLayout.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof ConstraintLayout.LayoutParams) == false) goto L54;
        r3 = r7;
    L54:
        if (r3 == null) goto L57;
        r3.setMarginStart(i5.q());
        r3.startToStart = 0;
        r3.startToEnd = -1;
        r6.setLayoutParams(r3);
    L57:
        ry8.b r8 = h4();
        if (r8 == null) goto L64;
        com.larus.platform.api.g0 r9 = r8.C5();
        if (r9 == null) goto L64;
        View r10 = r9.getBackIcon();
        if (r10 == null) goto L64;
        r10.setAlpha(0.0f);
    L64:
        ry8.b r11 = h4();
        if (r11 == null) goto L71;
        com.larus.platform.api.g0 r12 = r11.C5();
        if (r12 == null) goto L71;
        View r13 = r12.getRedDot();
        if (r13 == null) goto L71;
        r13.setAlpha(0.0f);
    L71:
        ry8.b r14 = h4();
        if (r14 == null) goto L79;
        com.larus.platform.api.g0 r15 = r14.C5();
        if (r15 == null) goto L80;
        View r16 = r15.getBackIcon();
        if (r16 == null) goto L81;
        r16.setEnabled(false);
        return;
    L81:
        return;
    L80:
        return;
    L79:
        return;
    L11:
        if (this.y1 == false) goto L38;
        ry8.b r17 = h4();
        if (r17 == null) goto L25;
        com.larus.platform.api.g0 r18 = r17.C5();
        if (r18 == null) goto L25;
        View r19 = r18.getTitle();
        if (r19 == null) goto L25;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        if ((r20 instanceof ConstraintLayout.LayoutParams) == false) goto L21;
        ConstraintLayout.LayoutParams r21 = (ConstraintLayout.LayoutParams) r20;
    L22:
        if (r21 == null) goto L25;
        r21.horizontalBias = 0.0f;
        r21.setMarginStart(i5.E());
        r21.startToStart = 0;
        r21.startToEnd = -1;
        r21.endToEnd = 0;
        r21.endToStart = -1;
        r19.setLayoutParams(r21);
        goto L25
    L21:
        r21 = null;
    L25:
        ry8.b r22 = h4();
        if (r22 == null) goto L45;
        com.larus.platform.api.g0 r23 = r22.C5();
        if (r23 == null) goto L45;
        View r24 = r23.getTitleText();
        if (r24 == null) goto L45;
        ConstraintLayout.LayoutParams r25 = r24.getLayoutParams();
        if ((r25 instanceof ConstraintLayout.LayoutParams) == false) goto L34;
        ConstraintLayout.LayoutParams r26 = r25;
    L35:
        if (r26 == null) goto L45;
        r26.horizontalBias = 0.0f;
        r24.setLayoutParams(r26);
        goto L45
    L34:
        r26 = null;
        goto L35
    L38:
        ry8.b r27 = h4();
        if (r27 == null) goto L45;
        com.larus.platform.api.g0 r28 = r27.C5();
        if (r28 == null) goto L45;
        View r29 = r28.getTitle();
        if (r29 == null) goto L45;
        r29.setTranslationX(this.G1);
    L7:
        r2 = false;
        goto L8
    }

    public final FrameLayout Q3() {
        return (FrameLayout) this.P.getValue();
    }

    public final ViewGroup V3() {
        return (ViewGroup) this.M.getValue();
    }

    public final ICoreInputAbility W3() {
        return (ICoreInputAbility) this.u.getValue();
    }

    public final FrameLayout X3() {
        return (FrameLayout) this.O.getValue();
    }

    public final boolean Xh() {
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r1 = getPageState();
        r0.getClass();
        return r1 instanceof vda.e;
    }

    public final va8.c Z3() {
        va8.o r0 = (va8.o) this.v.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Uv();
    }

    public final RecyclerView a4() {
        return (RecyclerView) this.N.getValue();
    }

    public final boolean aF() {
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r1 = getPageState();
        r0.getClass();
        return r1 instanceof vda.a;
    }

    public final RelativeLayout d4() {
        return (RelativeLayout) this.V1.getValue();
    }

    public final ObricSwipeGestureView e4() {
        return (ObricSwipeGestureView) this.S1.getValue();
    }

    public final de8.c f1() {
        return (de8.c) this.K.getValue();
    }

    public final ry8.b h4() {
        return (ry8.b) this.w.getValue();
    }

    public final FrameLayout i4() {
        return (FrameLayout) this.R.getValue();
    }

    public final boolean isFullScreen() {
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r1 = getPageState();
        r0.getClass();
        return r1 instanceof vda.d;
    }

    public final boolean isVisible() {
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r1 = getPageState();
        r0.getClass();
        if (ObricFloatChatPageData.a.d(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.n == true) goto L7;
        return true;
    }

    public final OrionChatPageStateViewModel j4() {
        return (OrionChatPageStateViewModel) this.m.getValue();
    }

    public final View o0() {
        return (View) this.M1.getValue();
    }

    public final void onDestroy() {
        Job r0 = this.q;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.q = null;
        com.obric.assistant.h.a.removeObservers(s1a.a.getActivity(this));
        va8.l r1 = H3();
        if (r1 == null) goto L8;
        FrameLayout r2 = r1.getTitleContainer();
    L9:
        if (r2 == null) goto L11;
        r2.getViewTreeObserver();
    L11:
        IObricBannerService r3 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
        if (r3 == null) goto L14;
        r3.g();
    L14:
        t19.s.a.a();
        com.larus.bmhome.chat.component.cvs.y r4 = (com.larus.bmhome.chat.component.cvs.y) this.s.getValue();
        if (r4 == null) goto L17;
        r4.lQ(this);
    L17:
        com.obric.assistant.util.s0 r5 = E3();
        r5.d().cancel();
        r5.c().cancel();
        ((ObjectAnimator) r5.j.getValue()).cancel();
        RecyclerView.Adapter<?> r6 = this.L0;
        if (r6 == null) goto L20;
        r6.unregisterAdapterDataObserver(this.b1);
    L20:
        this.L0 = null;
        NativeMessageServiceImpl r7 = com.larus.im.d.e();
        com.larus.bmhome.chat.component.cvs.y r8 = (com.larus.bmhome.chat.component.cvs.y) this.s.getValue();
        if (r8 == null) goto L24;
        String r9 = r8.Y1();
        if (r9 == null) goto L24;
    L25:
        r7.unregisterOnMessageChangedObserver(r9, this.g1);
        IAssistantInteractionServiceKt.getInteractionStateService().removeAutoIncreaseWindowObserver(this);
        com.larus.im.internal.stream.b r10 = com.larus.im.internal.stream.b.a;
        z r11 = this.h1;
        r10.e(r11.a, r11);
        this.Z = true;
        sea.e.c(false);
        return;
    L24:
        r9 = "";
        goto L25
    L8:
        r2 = null;
        goto L9
    }

    public final void onPause() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onPause, isOpenFromSingleClick = ");
        de8.c r2 = f1();
        boolean r4 = false;
        if (r2 == null) goto L9;
        Bundle r3 = r2.b;
        if (r3 == null) goto L9;
        if (r3.getBoolean("arg_launch_floating_window", false) != true) goto L9;
        r4 = true;
    L9:
        r1.append(r4);
        r1.append(" pageState = ");
        r1.append(getPageState());
        r0.i("OrionChatPageStateComponent", r1.toString());
        this.n = true;
        ObricFloatChatPageState r5 = getPageState();
        ObricFloatChatPageData.Companion.getClass();
        if ((r5 instanceof vda.d) == false) goto L12;
        this.L1.storeLong("last_dismiss_time", System.currentTimeMillis());
    L12:
        G3().m();
    }

    public final void onResume() {
        boolean r9 = false;
        this.n = false;
        B3();
        ObricFloatChatPageState r0 = getPageState();
        ObricFloatChatPageData.Companion.getClass();
        Float r11 = null;
        if ((r0 instanceof vda.e) == false) goto L5;
    L6:
        com.obric.assistant.t1 r1 = com.obric.assistant.t1.a;
        if (r1.B() == true) goto L9;
    L17:
        ObricInteractDelegate r2 = ObricInteractDelegate.b;
        Boolean r3 = r2.isNeedUpdatePageState();
        Boolean r4 = r2.getWakeupSource();
        Boolean r5 = r2.getRelaunchEvent();
        Object r6 = getContext().getSystemService("keyguard");
        if ((r6 instanceof KeyguardManager) == false) goto L20;
        KeyguardManager r7 = (KeyguardManager) r6;
    L21:
        boolean r8 = IKeyguardStateKt.getKeyguardState().isKeyguardLocked();
        if (r7 == null) goto L24;
        Boolean r10 = Boolean.valueOf(r7.isKeyguardSecure());
    L25:
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 24) goto L32;
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("onResume, ");
        r15.append(r3);
        r15.append(", ");
        r15.append(r4);
        r15.append(", ");
        r15.append(r5);
        r15.append(", ");
        r15.append(r8);
        r15.append(", ");
        r15.append(r10);
        r15.append(", ");
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r13 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r13 == null) goto L30;
        Boolean r16 = Boolean.valueOf(r13.isInMultiWindowMode());
    L31:
        r15.append(r16);
        r15.append(", ");
        r15.append(hashCode());
        r14.i("OrionChatPageStateComponent", r15.toString());
        goto L32
    L30:
        r16 = null;
    L32:
        de8.c r17 = f1();
        if (r17 == null) goto L37;
        Bundle r18 = r17.b;
        if (r18 == null) goto L37;
        String r19 = r18.getString("all_search");
    L38:
        if (r19 != null) goto L40;
    L43:
        boolean r20 = true;
    L44:
        if (r20 == true) goto L56;
        FLogger r21 = FLogger.a;
        r21.i("OrionChatPageStateComponent", "observer, launch from all search");
        r21.i("OrionChatPageStateComponent", "dealWithAllSearch");
        ICoreInputAbility r22 = W3();
        if (r22 == null) goto L48;
        r22.g2(1, true);
    L48:
        ICoreInputAbility r110 = W3();
        if (r110 == null) goto L51;
        ICoreInputAbility.b.d(r110, r19, false, false, null, null, false, 62);
    L51:
        de8.c r23 = f1();
        if (r23 == null) goto L114;
        Bundle r24 = r23.b;
        if (r24 == null) goto L114;
        r24.remove("all_search");
    L114:
        de8.c r25 = f1();
        if (r25 == null) goto L120;
        Bundle r26 = r25.b;
        if (r26 == null) goto L120;
        String r27 = r26.getString("obric_window_input_draft");
        if (r27 == null) goto L120;
    L126:
        if (r27 != null) goto L128;
    L131:
        boolean r28 = true;
    L132:
        if (r28 == true) goto L163;
        va8.o r29 = (va8.o) this.v.getValue();
        if (r29 == null) goto L136;
        String r30 = r29.u7();
    L138:
        if (com.larus.utils.o0.d(r30) == true) goto L163;
        FLogger.a.i("OrionChatPageStateComponent", "restoreWindowInputDraftIfNeeded");
        ICoreInputAbility r31 = W3();
        if (r31 == null) goto L143;
        r31.g2(1, true);
    L143:
        ICoreInputAbility r111 = W3();
        if (r111 == null) goto L153;
        ada.b r32 = (ada.b) this.I.getValue();
        if (r32 == null) goto L151;
        CharSequence r33 = r32.x9(r27);
        if (r33 == null) goto L151;
        CharSequence r112 = r33;
    L152:
        ICoreInputAbility.b.d(r111, r112, false, false, null, null, false, 62);
    L151:
        r112 = r27;
    L153:
        de8.c r34 = f1();
        if (r34 == null) goto L158;
        Bundle r35 = r34.b;
        if (r35 == null) goto L158;
        r35.remove("obric_window_input_draft");
    L158:
        de8.c r36 = f1();
        if (r36 == null) goto L163;
        Bundle r37 = r36.a;
        if (r37 == null) goto L163;
        r37.remove("obric_window_input_draft");
        goto L163
    L136:
        r30 = null;
    L163:
        sea.e.c(false);
        sea.e.d(false);
        com.obric.assistant.util.j0 r38 = G3();
        ICoreInputAbility r39 = W3();
        if (r39 != null) goto L166;
    L168:
        r38.t(r9);
        G3().n();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass3(this, null), 2, null);
        if ((getPageState() instanceof vda.a) == false) goto L172;
        f5();
    L172:
        if (ObricFloatChatPageData.a.d(getPageState()) == false) goto L179;
        ViewGroup r40 = V3();
        if (r40 == null) goto L177;
        r11 = Float.valueOf(r40.getAlpha());
    L177:
        if (Intrinsics.areEqual(r11, 1.0f) == false) goto L179;
        h3();
    L179:
        G4("on_resume_end");
        return;
    L166:
        if (r39.c2() != true) goto L168;
        r9 = true;
        goto L168
    L128:
        if (r27.length() == 0) goto L131;
        r28 = false;
    L120:
        de8.c r41 = f1();
        if (r41 == null) goto L125;
        Bundle r42 = r41.a;
        if (r42 == null) goto L125;
        r27 = r42.getString("obric_window_input_draft");
    L125:
        r27 = null;
        goto L126
    L56:
        de8.c r43 = f1();
        if (r43 == null) goto L61;
        Bundle r44 = r43.a;
        if (r44 == null) goto L61;
        String r45 = r44.getString("launch_from_agent");
    L63:
        if (com.larus.utils.o0.d(r45) == false) goto L76;
        FLogger.a.i("OrionChatPageStateComponent", "observer, launch from agent");
        de8.c r46 = f1();
        if (r46 == null) goto L69;
        Bundle r47 = r46.a;
        if (r47 == null) goto L69;
        r47.remove("launch_from_agent");
    L69:
        de8.c r48 = f1();
        if (r48 == null) goto L74;
        Bundle r49 = r48.a;
        if (r49 == null) goto L74;
        r49.remove("agent_window_state");
    L74:
        N1();
        OrionChatPageStateViewModel r50 = j4();
        vda.e r51 = new vda.e(false, com.obric.assistant.util.m2.a, null);
        r51.setPreviousState(getPageState());
        r50.changePageStatus(r51);
        goto L114
    L76:
        if (Intrinsics.areEqual(r2.isNeedUpdatePageState(), Boolean.TRUE) == false) goto L85;
        Boolean r52 = Boolean.FALSE;
        if (Intrinsics.areEqual(r4, r52) == false) goto L85;
        if (Intrinsics.areEqual(r5, r52) == false) goto L85;
        if (r8 == true) goto L85;
        if (sea.e.a.get() == true) goto L85;
    L93:
        laa.d.a.c(this, null, false, null, 7);
    L85:
        if (r12 < 24) goto L94;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r53 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r53 != null) goto L89;
    L91:
        boolean r54 = false;
    L92:
        if (r54 == false) goto L94;
    L89:
        if (r53.isInMultiWindowMode() != true) goto L91;
        r54 = true;
    L94:
        ObricFloatChatPageState r55 = getPageState();
        if ((r55 instanceof vda.b) == false) goto L112;
        FLogger.a.i("OrionChatPageStateComponent", "onResume page is dismiss");
        if (sea.e.b.get() == false) goto L101;
        sea.e.d(false);
        sea.e.c(false);
        laa.d.a.d(this, false, com.obric.assistant.util.m2.b, null, false, false, null, 61);
        G4("on_resume_change_to_half");
        return;
    L101:
        if (ObricFloatChatPageData.a.b(r55) == false) goto L103;
    L109:
        laa.d.a.c(this, null, false, null, 7);
        G4("on_resume_change_to_full");
        return;
    L103:
        if (ObricFloatChatPageData.a.e(r55) == true) goto L109;
        if (r55.getHeight() != 0) goto L108;
        laa.d.a.a(this, 0.0f, false, 3);
        goto L114
    L108:
        laa.d.a.d(this, false, com.obric.assistant.util.m2.b, null, false, false, null, 61);
        goto L114
    L112:
        if (ObricFloatChatPageData.a.c(r55) == false) goto L114;
        FLogger.a.i("OrionChatPageStateComponent", "onResume but is unknown");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricChatPageStateComponent$onResume$2$1(this, null), 3, null);
    L61:
        r45 = null;
        goto L63
    L40:
        if (r19.length() == 0) goto L43;
        r20 = false;
    L37:
        r19 = null;
        goto L38
    L24:
        r10 = null;
        goto L25
    L20:
        r7 = null;
        goto L21
    L9:
        if (r1.V1() == true) goto L15;
        Job r56 = this.q;
        if (r56 == null) goto L13;
        Job.DefaultImpls.cancel$default(r56, null, 1, null);
    L13:
        this.q = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass1(this, null), 3, null);
    L15:
        if (r1.d() == true) goto L17;
        r1.k();
        goto L17
    L5:
        if ((r0 instanceof vda.d) == false) goto L17;
        goto L6
    }

    public final void onScreenOff() {
        FLogger r0 = FLogger.a;
        r0.i("OrionChatPageStateComponent", "onScreenOff " + JY() + " setShowWhenLocked false");
        com.obric.assistant.live.api.j.a.r(false);
        if (this.o == false) goto L11;
        if (this.p <= 0) goto L11;
        if ((SystemClock.uptimeMillis() - this.p) <= 500) goto L11;
        r0.i("OrionChatPageStateComponent", "onScreenOff skip");
        ObricInteractDelegate.b.notifyWakeupEvent(false);
        return;
    L11:
        if (JY() == false) goto L14;
        ObricInteractDelegate.b.notifyWakeupEvent(false);
        s1a.a.getActivity(this).moveTaskToBack(true);
        return;
    }

    public final void onWindowDismiss() {
        FLogger.a.e("OrionChatPageStateComponent", "onWindowDismiss, current page state is " + getPageState() + ", cancelMoveTaskToBack = " + this.X);
        laa.f r0 = (laa.f) this.B.getValue();
        if (r0 == null) goto L5;
        r0.hU();
    L5:
        va8.o r1 = (va8.o) this.v.getValue();
        if (r1 == null) goto L8;
        r1.c3();
    L8:
        IAssistantChatWindow r2 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r2 == null) goto L11;
        IAssistantChatWindow$DefaultImpls.stash$default(r2, null, 1, null);
    L11:
        AssistantWindowHideReason.INSTANCE.setNext("finish_with_animation");
        ObricFloatChatPageData.a r3 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r4 = getPageState();
        r3.getClass();
        if (ObricFloatChatPageData.a.e(r4) == true) goto L15;
        return;
    L15:
        if ((getPageState() instanceof vda.b) == true) goto L20;
        if (ObricFloatChatPageData.a.c(getPageState()) == true) goto L20;
        return;
    L20:
        if (this.X == false) goto L23;
        this.X = false;
        return;
    L23:
        s1a.a.getActivity(this).moveTaskToBack(true);
        s1a.a.getActivity(this).overridePendingTransition(0, 0);
    }

    public final boolean p4() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(s1a.a.getActivity(this));     // Catch: Throwable -> L4
    L7:
        if (Result.exceptionOrNull-impl(r1) == null) goto L10;
        FLogger.a.w("OrionChatPageStateComponent", "isPageStateSwitchSupported, activity is null, will use cachedActivity=" + this.p2);
    L10:
        if (Result.isFailure-impl(r1) == false) goto L12;
        r1 = null;
    L12:
        FragmentActivity r2 = (FragmentActivity) r1;
        if (r2 != null) goto L16;
        r2 = this.p2;
    L16:
        if (s1a.a.e(this) == false) goto L18;
    L21:
        boolean r3 = true;
    L22:
        if (r3 == true) goto L24;
        FLogger.a.i("OrionChatPageStateComponent", "isPageStateSwitchSupported=false, pageState=" + getPageState() + ", isWindowHost=" + s1a.a.e(this) + ", activity=" + r2);
    L24:
        return r3;
    L18:
        if ((r2 instanceof com.larus.bmhome.chat.n4) == true) goto L21;
        r3 = false;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX WARN: Type inference failed for: r0v66, types: [com.obric.assistant.component.ObricChatPageStateComponent$messageListAdapterObserver$1] */
    /* JADX WARN: Type inference failed for: r0v67, types: [com.obric.assistant.component.ObricChatPageStateComponent$changeListener$1] */
    public ObricChatPageStateComponent() {
        this.m = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(OrionChatPageStateViewModel.class), Reflection.getOrCreateKotlinClass(ObricFloatChatPageData.class), new w(this), new x(this), y.a);
        this.r = LazyKt.lazy(new m(this));
        this.s = LazyKt.lazy(new n(this));
        this.t = LazyKt.lazy(new o(this));
        this.u = LazyKt.lazy(new p(this));
        this.v = LazyKt.lazy(new q(this));
        this.w = LazyKt.lazy(new r(this));
        this.x = LazyKt.lazy(new s(this));
        this.y = LazyKt.lazy(new t(this));
        this.z = LazyKt.lazy(new u(this));
        this.A = LazyKt.lazy(new c(this));
        this.B = LazyKt.lazy(new d(this));
        this.C = LazyKt.lazy(new e(this));
        this.D = LazyKt.lazy(new f(this));
        this.E = LazyKt.lazy(new g(this));
        this.F = LazyKt.lazy(new h(this));
        this.G = LazyKt.lazy(new i(this));
        this.H = LazyKt.lazy(new j(this));
        this.I = LazyKt.lazy(new k(this));
        this.J = LazyKt.lazy(new l(this));
        this.K = LazyKt.lazy(new v(this));
        this.L = LazyKt.lazy(new com.obric.assistant.component.y(this));
        this.M = LazyKt.lazy(new com.obric.assistant.component.o(this));
        this.N = LazyKt.lazy(new com.obric.assistant.component.p(this));
        this.O = LazyKt.lazy(new com.obric.assistant.component.q(this));
        this.P = LazyKt.lazy(new com.obric.assistant.component.r(this));
        this.Q = LazyKt.lazy(new com.obric.assistant.component.s(this));
        this.R = LazyKt.lazy(new com.obric.assistant.component.t(this));
        this.S = LazyKt.lazy(new com.obric.assistant.component.u(this));
        this.T = new ArrayList();
        this.U = new ArrayList();
        this.V = LazyKt.lazy(new com.obric.assistant.component.v(this));
        this.W = com.obric.assistant.util.m2.b;
        this.Z = true;
        this.P0 = Long.MIN_VALUE;
        this.b1 = new ObricChatPageStateComponent$messageListAdapterObserver$1(this);
        this.g1 = new ObricChatPageStateComponent$changeListener$1(this);
        this.h1 = new z(this);
        this.k1 = LazyKt.lazy(new com.obric.assistant.component.w(this));
        this.p1 = LazyKt.lazy(new j0());
        this.v1 = i5.Q();
        this.x1 = i5.e0();
        this.y1 = com.larus.platform.service.z2.a.getChatNavigatorConfig().b;
        this.G1 = -i5.b0();
        this.H1 = 1.0f;
        this.L1 = xg9.b.a();
        this.M1 = LazyKt.lazy(new u0(this));
        this.P1 = LazyKt.lazy(new v0(this));
        this.Q1 = LazyKt.lazy(new w0(this));
        this.S1 = LazyKt.lazy(new x0(this));
        this.T1 = LazyKt.lazy(new y0(this));
        this.V1 = LazyKt.lazy(new z0(this));
        this.b2 = LazyKt.lazy(new a1(this));
        ObricFloatChatPageData.Companion.getClass();
        this.g2 = ObricFloatChatPageData.access$getUNKNOWN$cp();
        this.h2 = 2131365588;
    }

    public final void B3() {
        RecyclerView r0 = a4();
        if (r0 == null) goto L14;
        RecyclerView.Adapter<?> r1 = r0.getAdapter();
        if (r1 == null) goto L14;
        RecyclerView.Adapter<?> r2 = this.L0;
        if (r2 != r1) goto L10;
        return;
    L10:
        if (r2 == null) goto L12;
        r2.unregisterAdapterDataObserver(this.b1);
    L12:
        this.L0 = r1;
        r1.registerAdapterDataObserver(this.b1);
        FLogger.a.i("OrionChatPageStateComponent", "ensureMessageListAdapterObserver success, itemCount=" + r1.getItemCount());
        G4("adapter_observer_registered");
        return;
    L14:
        FLogger.a.i("OrionChatPageStateComponent", "ensureMessageListAdapterObserver skipped, adapter is null");
    }

    public final void Ba() {
        com.obric.assistant.util.j0 r0 = G3();
        r0.n = true;
        r0.c("handleMessageListOnTouched");
    }

    public final ViewGroup D3() {
        com.larus.bmhome.chat.component.bottom.core.a r0 = Z3();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public final RecyclerView Xw() {
        return a4();
    }

    public final boolean YQ() {
        ObricFloatChatPageState r0 = getPageState();
        ObricFloatChatPageData.Companion.getClass();
        if ((r0 instanceof vda.a) == false) goto L5;
    L14:
        return true;
    L5:
        if ((r0 instanceof vda.b) == true) goto L14;
        if ((r0 instanceof vda.c) == true) goto L14;
        if (ObricFloatChatPageData.a.c(r0) == true) goto L14;
        if (E3().c().isRunning() == true) goto L14;
        return false;
    }

    public final String bl() {
        return ((ObricFloatChatPageData) j4().getState()).getPageState().toString();
    }

    public final int c4() {
        RecyclerView r0 = a4();
        ViewGroup.MarginLayoutParams r1 = null;
        int r2 = 0;
        if (r0 == null) goto L13;
        wq8.b r3 = r0.getAdapter();
        if ((r3 instanceof wq8.b) == false) goto L8;
        wq8.b r4 = r3;
    L9:
        if (r4 == null) goto L13;
        RecyclerView.LayoutManager r5 = r0.getLayoutManager();
        if (r5 == null) goto L13;
        Iterator r6 = r4.getCurrentList().iterator();
        int r7 = 0;
        int r8 = 0;
    L16:
        if (r6.hasNext() == false) goto L25;
        Object r9 = r6.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        Message r11 = (Message) r9;
        View r12 = r5.findViewByPosition(r8);
        if (r12 != null) goto L23;
        int r13 = i5.f0();
    L24:
        r7 = r7 + r13;
        r8 = r10;
        goto L16
    L23:
        r13 = r5.getBottomDecorationHeight(r12) + (r12.getHeight() + r5.getTopDecorationHeight(r12));
    L25:
        int r14 = this.p0;
        if (r14 <= 0) goto L28;
        r7 = r14;
    L34:
        FrameLayout r15 = Q3();
        if (r15 != null) goto L37;
    L39:
        boolean r16 = false;
    L40:
        if (r16 == false) goto L44;
        FrameLayout r17 = Q3();
        if (r17 == null) goto L44;
        int r18 = r17.getHeight();
    L45:
        FrameLayout r19 = X3();
        if (r19 == null) goto L52;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        if ((r20 instanceof ViewGroup.MarginLayoutParams) == false) goto L50;
        r1 = (ViewGroup.MarginLayoutParams) r20;
    L50:
        if (r1 == null) goto L52;
        int r21 = r1.bottomMargin;
    L53:
        com.larus.utils.i0.a.getClass();
        int r22 = com.larus.utils.i0.e();
        FrameLayout r23 = X3();
        if (r23 == null) goto L56;
        int r24 = r23.getHeight();
    L57:
        int r25 = r24 + r21;
        FrameLayout r26 = i4();
        if (r26 == null) goto L61;
        r2 = r26.getHeight();
    L61:
        return RangesKt.coerceIn(((Number) com.obric.assistant.util.m2.a(((r25 + r2) + r18) + r22, r7).component1()).intValue(), com.obric.assistant.util.m2.b, com.obric.assistant.util.m2.a);
    L56:
        r24 = 0;
    L52:
        r21 = 0;
    L44:
        r18 = 0;
        goto L45
    L37:
        if (r15.getVisibility() != 0) goto L39;
        r16 = true;
        goto L40
    L28:
        if (r7 > 0) goto L34;
        IObricChatUIService r27 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r27 == null) goto L33;
        r7 = r27.h();
        goto L34
    L33:
        r7 = 0;
        goto L34
    L8:
        r4 = null;
    L13:
        r7 = 0;
        goto L25
    }

    public final void f5() {
        va8.c r0 = Z3();
        Integer r1 = null;
        if (r0 == null) goto L5;
        final TextView r2 = r0.b();
    L7:
        if (r2 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == true) goto L21;
        List r3 = CollectionsKt.listOf(new Integer[]{1, 3});
        ICoreInputAbility r5 = W3();
        if (r5 == null) goto L17;
        r1 = Integer.valueOf(r5.Rp());
    L17:
        if (CollectionsKt.contains(r3, r1) == false) goto L22;
        if (r2 == null) goto L23;
        r2.post(new com.obric.assistant.component.n(r2, this));
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L9:
        if (r2.hasFocus() != true) goto L11;
        r4 = true;
        goto L12
    L5:
        r2 = null;
        goto L7
    }

    public final ObricFloatChatPageState getPageState() {
        return ((ObricFloatChatPageData) j4().getState()).getPageState();
    }

    public final ViewGroup getTitleContainer() {
        ry8.b r0 = h4();
        if (r0 == null) goto L7;
        com.larus.platform.api.g0 r1 = r0.C5();
        if (r1 == null) goto L7;
        View r2 = r1.getTitleView();
    L9:
        if ((r2 instanceof ViewGroup) == true) goto L11;
        return null;
    L11:
        return (ViewGroup) r2;
    L7:
        r2 = null;
        goto L9
    }

    public final void h3() {
        de8.c r0 = f1();
        String r2 = null;
        if (r0 == null) goto L14;
        Bundle r1 = r0.b;
        if (r1 == null) goto L14;
        String r3 = r1.getString("obric_startup_attempt_id");
        if (r3 == null) goto L14;
        if ((!StringsKt.isBlank(r3)) == true) goto L12;
        r3 = null;
    L12:
        if (r3 == null) goto L14;
    L22:
        r2 = r3;
    L23:
        String r4 = AssistantStartupTelemetry.a.i("chat_content_ready");
        if (r4 != null) goto L26;
        return;
    L26:
        if (r2 != null) goto L28;
    L30:
        if (r2 != null) goto L33;
        r2 = r4;
    L33:
        if (Intrinsics.areEqual(this.V0, r2) == false) goto L35;
        return;
    L35:
        int r5 = xga.b.a;
        if (xga.b.a(V3(), r2, "chat_content_ready", new k0()) == false) goto L39;
        this.V0 = r2;
        return;
    L39:
        return;
    L28:
        if (Intrinsics.areEqual(r2, r4) == true) goto L30;
        return;
    L14:
        de8.c r6 = f1();
        if (r6 == null) goto L23;
        Bundle r7 = r6.a;
        if (r7 == null) goto L23;
        r3 = r7.getString("obric_startup_attempt_id");
        if (r3 == null) goto L23;
        if ((!StringsKt.isBlank(r3)) == false) goto L23;
        goto L22
    }

    public final void i5() {
        RecyclerView r0 = a4();
        if (r0 == null) goto L44;
        RecyclerView.Adapter r1 = r0.getAdapter();
        if (r1 == null) goto L48;
        RecyclerView r2 = a4();
        LinearLayoutManager r3 = null;
        if (r2 == null) goto L10;
        RecyclerView.LayoutManager r4 = r2.getLayoutManager();
    L12:
        if ((r4 instanceof LinearLayoutManager) == false) goto L14;
        r3 = (LinearLayoutManager) r4;
    L14:
        if (r3 != null) goto L16;
        return;
    L16:
        int r5 = r3.findFirstVisibleItemPosition();
        int r6 = r3.findLastVisibleItemPosition();
        if (r5 == (-1)) goto L45;
        if (r6 == (-1)) goto L49;
        boolean r7 = false;
        IntRange r8 = RangesKt.until(0, r1.getItemCount());
        if (r5 > r6) goto L46;
        int r9 = r8.getFirst();
        if (r5 > r8.getLast()) goto L26;
        if (r9 > r5) goto L26;
        boolean r10 = true;
    L27:
        if (r10 == false) goto L47;
        int r11 = r8.getFirst();
        if (r6 > r8.getLast()) goto L32;
        if (r11 > r6) goto L32;
        boolean r12 = true;
    L33:
        if (r12 == false) goto L50;
        RecyclerView r13 = a4();
        if (r13 != null) goto L38;
    L40:
        if (r7 == false) goto L42;
        return;
    L42:
        r1.notifyItemRangeChanged(r5 + 1, r6 - r5);
        return;
    L38:
        if (r13.isComputingLayout() != true) goto L40;
        r7 = true;
        goto L40
    L50:
        return;
    L32:
        r12 = false;
        goto L33
    L47:
        return;
    L26:
        r10 = false;
        goto L27
    L46:
        return;
    L49:
        return;
    L45:
        return;
    L10:
        r4 = null;
        goto L12
    L48:
        return;
    }

    public final void le() {
        G3().d();
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        FLogger r0 = FLogger.a;
        r0.i("OrionChatPageStateComponent", "mobEnterChatActivity, activity = " + s1a.a.getActivity(this));
        IAssistantChatWindow r1 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r1 == null) goto L7;
        boolean r3 = true;
        if (r1.isWindowMode() != true) goto L7;
    L8:
        if (r3 == true) goto L10;
        r0.i("OrionChatPageStateComponent", "is not window mode");
        return;
    L10:
        int r2 = com.obric.assistant.chat.p.a;
        if (com.obric.assistant.chat.p.d(s1a.a.getActivity(this)) == false) goto L24;
        Intent r4 = s1a.a.getActivity(this).getIntent();
        if (r4 != null) goto L16;
        r0.i("OrionChatPageStateComponent", "intent is null");
        fia.a.a(null);
        return;
    L16:
        if (Intrinsics.areEqual(r4.getStringExtra("enter_method"), "landing") == false) goto L18;
        r0.i("OrionChatPageStateComponent", "intent is start from launcher");
        fia.a.a("icon");
        return;
    L18:
        String r5 = r4.getStringExtra("obric_enter_full_screen");
        if (r5 == null) goto L21;
        r0.i("OrionChatPageStateComponent", "enter method is not null, method = ".concat(r5));
        fia.a.a(r5);
        return;
    L21:
        fia.a.a(null);
        return;
    L24:
        return;
    L7:
        r3 = false;
        goto L8
    }

    public final void refresh() {
        ObricFloatChatPageState r0 = getPageState();
        ObricFloatChatPageData.a r1 = ObricFloatChatPageData.Companion;
        r1.getClass();
        if ((r0 instanceof vda.a) == false) goto L5;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.assistant.data.ObricFloatChatPageStateChatWindow");
        F4((vda.a) r0);
        C1(false, false, "refresh");
        return;
    L5:
        r1.getClass();
        if ((r0 instanceof vda.e) == false) goto L8;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.assistant.data.ObricFloatChatPageStateHalfWindow");
        B4((vda.e) r0);
        return;
    L8:
        r1.getClass();
        if ((r0 instanceof vda.d) == false) goto L14;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.assistant.data.ObricFloatChatPageStateFullScreen");
        v4((vda.d) r0);
        return;
    }

    public final void y2() {
        this.p2 = s1a.a.getActivity(this);
        FLogger.a.i("OrionChatPageStateComponent", "onAttach: cachedActivity = " + this.p2);
    }

    public final int U2() {
        return this.h2;
    }

    public static boolean l4(ObricFloatChatPageState r3) {
        if (r3 == null) goto L7;
        ObricFloatChatPageData.Companion.getClass();
        if ((r3 instanceof vda.a) != true) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L15;
        if (r3 == null) goto L13;
        ObricFloatChatPageData.Companion.getClass();
        if ((r3 instanceof vda.e) != true) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == true) goto L15;
        return false;
    L13:
        r4 = false;
    L15:
        return true;
    L7:
        r2 = false;
        goto L8
    }

    public final void AN(hca.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        ((ArrayList) this.T).remove(r2);
    }

    public final void B4(vda.e r11) {
        h5(false);
        FragmentActivity r1 = s1a.a.getActivity(this);
        boolean r2 = v19.h.a;
        com.larus.utils.u.g(r1, !v19.h.b(getContext()));
        this.L1.storeBoolean("is_dismiss_from_half_screen", false);
        e4().setEnabled(true);
        com.larus.utils.e1.x(e4());
        C3(true);
        boolean r3 = r11.a;
        int r4 = r11.b;
        Float r5 = r11.c;
        FLogger r6 = FLogger.a;
        r6.i("OrionChatPageStateComponent", "onChangeToHalf, useAnim is " + r3 + ", height is " + r4 + ", velocity is " + r5 + ", getTopEmptyHeight is " + G1() + ", pageState is " + r11);
        ObricFloatChatPageState r7 = r11.getPreviousState();
        if (r7 == null) goto L7;
        ObricFloatChatPageData.Companion.getClass();
        if ((r7 instanceof vda.b) != true) goto L7;
        boolean r8 = true;
    L8:
        if (r8 == true) goto L23;
        ObricFloatChatPageState r9 = r11.getPreviousState();
        if (r9 == null) goto L14;
        ObricFloatChatPageData.Companion.getClass();
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if ((r9 instanceof com.obric.assistant.data.a) != true) goto L14;
        boolean r10 = true;
    L15:
        if (r10 == true) goto L23;
        ObricFloatChatPageState r12 = r11.getPreviousState();
        if (r12 == null) goto L21;
        ObricFloatChatPageData.Companion.getClass();
        if ((r12 instanceof vda.a) != true) goto L21;
        boolean r13 = true;
    L22:
        if (r13 == true) goto L23;
    L32:
        ObricFloatChatPageState r14 = r11.getPreviousState();
        if (r14 == null) goto L37;
        ObricFloatChatPageData.Companion.getClass();
        if ((r14 instanceof vda.a) != true) goto L37;
        boolean r15 = true;
    L38:
        if (r15 == true) goto L40;
        E3().g(0);
    L40:
        if (r3 == false) goto L42;
        E3().b(G1(), r4, r5);
    L43:
        ViewGroup r16 = V3();
        if (r16 == null) goto L46;
        int r17 = r16.getPaddingTop();
        int r18 = r16.getPaddingBottom();
        r6.i("updatePaddingRelative", "view:" + r16.getClass().getSimpleName() + ",source:,start:0,top:" + r17 + ",end:0,bottom:" + r18);
        r16.setPaddingRelative(0, r17, 0, r18);
    L46:
        i5();
        float r19 = this.x1;
        GradientDrawable r20 = (GradientDrawable) this.Q1.getValue();
        float r21 = this.v1;
        r20.setCornerRadii(new float[]{r21, r21, r21, r21, r19, r19, r19, r19});
        E3().f(true, true);
        ObricInteractDelegate.b.notifyChangeWindowEvent(false);
        com.larus.utils.u.e(s1a.a.getActivity(this), false, v19.h.a(null));
        return;
    L42:
        E3().a();
        J1(r4);
    L37:
        r15 = false;
    L21:
        r13 = false;
    L14:
        r10 = false;
    L23:
        int r22 = com.obric.assistant.util.m2.a;
        J1(com.obric.assistant.util.m2.b(V3(), X3(), Q3(), D3()));
        ObricFloatChatPageState r23 = r11.getPreviousState();
        if (r23 == null) goto L28;
        ObricFloatChatPageData.Companion.getClass();
        if ((r23 instanceof vda.a) != true) goto L28;
        boolean r24 = true;
    L29:
        if (r24 == true) goto L31;
        E3().e(i5.r());
    L31:
        N1();
    L28:
        r24 = false;
    L7:
        r8 = false;
        goto L8
    }

    public final void Bn(AVKitDuplexState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        if ((r2.getDownState() instanceof AVKitCoreStates.Speaking) == false) goto L6;
        G3().r(null);
        return;
    }

    public final void C00(boolean r1) {
        G3().v();
    }

    public final void C3(boolean r10) {
        FLogger.a.i("OrionChatPageStateComponent", "excludeFromRecents: exclude = " + r10);
        Object r0 = s1a.a.getActivity(this).getSystemService("activity");
        Object r3 = null;
        if ((r0 instanceof ActivityManager) == false) goto L5;
        ActivityManager r1 = (ActivityManager) r0;
    L6:
        if (r1 == null) goto L44;
        List<ActivityManager.AppTask> r2 = r1.getAppTasks();
        List<ActivityManager.AppTask> r4 = r2;
        if (r4 != null) goto L10;
    L13:
        boolean r5 = true;
    L14:
        if (r5 == true) goto L45;
        Iterator<T> r6 = r2.iterator();
    L17:
        if (r6.hasNext() == false) goto L35;
        Object r7 = r6.next();
        ActivityManager.AppTask r8 = (ActivityManager.AppTask) r7;
        if (Build.VERSION.SDK_INT < 29) goto L26;
        if (r8 == null) goto L32;
        ActivityManager.RecentTaskInfo r9 = r8.getTaskInfo();
        if (r9 == null) goto L32;
        if (r9.taskId != s1a.a.getActivity(this).getTaskId()) goto L32;
    L31:
        boolean r11 = true;
    L33:
        if (r11 == false) goto L17;
        r3 = r7;
    L32:
        r11 = false;
        goto L33
    L26:
        if (r8 == null) goto L32;
        ActivityManager.RecentTaskInfo r12 = r8.getTaskInfo();
        if (r12 == null) goto L32;
        if (r12.id != s1a.a.getActivity(this).getTaskId()) goto L32;
    L35:
        ActivityManager.AppTask r13 = (ActivityManager.AppTask) r3;
        if (r13 == null) goto L46;
        FLogger.a.i("OrionChatPageStateComponent", "setTask ExcludeFromRecents " + r10 + ' ' + r13.getTaskInfo());
        r13.setExcludeFromRecents(r10);
        return;
    L46:
        return;
    L45:
        return;
    L10:
        if (r4.isEmpty() == true) goto L13;
        r5 = false;
        goto L14
    L44:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void F0(boolean r2) {
        q4(2, r2);
    }

    public final void F4(vda.a r11) {
        FLogger r0 = FLogger.a;
        r0.i("OrionChatPageStateComponent", "onChangeToWindow");
        h5(false);
        IObricBannerService r3 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
        if (r3 == null) goto L5;
        r3.g();
    L5:
        e4().setEnabled(false);
        this.L1.storeBoolean("is_dismiss_from_half_screen", false);
        this.L1.storeBoolean("obric_first_open_in_keyguard_locked", false);
        com.obric.assistant.util.s0 r4 = E3();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r11, "pageState");
        ObricFloatChatPageState r5 = r11.getPreviousState();
        boolean r6 = true;
        if (r5 == null) goto L10;
        ObricFloatChatPageData.Companion.getClass();
        if ((r5 instanceof vda.b) != true) goto L10;
        boolean r7 = true;
    L11:
        if (r7 == true) goto L21;
        ObricFloatChatPageState r8 = r11.getPreviousState();
        if (r8 == null) goto L17;
        ObricFloatChatPageData.Companion.getClass();
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if ((r8 instanceof com.obric.assistant.data.a) != true) goto L17;
        boolean r9 = true;
    L18:
        if (r9 == true) goto L21;
        boolean r10 = false;
    L22:
        float r12 = r11.a;
        int r13 = com.obric.assistant.util.m2.a;
        int r14 = com.obric.assistant.util.m2.b(r4.d, r4.e, r4.c, r4.f);
        if (r10 == false) goto L25;
        r4.b.J1(r14);
        r4.b.N1();
        r4.e(i5.r());
        r4.g(0);
        r4.f(true, false);
    L26:
        TitleAvatarImageView r15 = (TitleAvatarImageView) this.b2.getValue();
        if (r15 == null) goto L29;
        r15.setVisibility(0);
        com.larus.bmhome.utils.f2.a = FirstFeedSceneEnum.CHAT_DETAIL;
        com.larus.bmhome.utils.f2.a(r15, "OBRIC_CHAT_WINDOW_SHOW");
    L29:
        C3(true);
        ObricInteractDelegate.b.notifyChangeWindowEvent(false);
        FragmentActivity r16 = this.p2;
        com.larus.utils.u.h(s1a.a.getActivity(this), false);
        if (r16 == null) goto L53;
        IObricActivityService r17 = (IObricActivityService) ServiceManager.get().getService(IObricActivityService.class);
        if (r17 != null) goto L34;
    L36:
        r6 = false;
    L37:
        if (r6 == true) goto L53;
        de8.c r18 = f1();
        if (r18 == null) goto L55;
        Bundle r19 = r18.a;
        if (r19 != null) goto L43;
        return;
    L43:
        if (r19.getBoolean("obric_open_special_input", false) == true) goto L45;
        return;
    L45:
        if (this.Z == false) goto L58;
        this.Z = false;
        r0.i("OrionChatPageStateComponent", "open special input panel");
        laa.j r1 = (laa.j) this.C.getValue();
        if (r1 != null) goto L49;
        return;
    L49:
        if (Build.VERSION.SDK_INT < 33) goto L51;
        StateInfo r110 = (StateInfo) r19.getParcelable("obric_special_input_state_info", StateInfo.class);
    L52:
        laa.j.a.a(r1, false, r110, null, null, true, false, 109);
        return;
    L51:
        r110 = r19.getParcelable("obric_special_input_state_info");
        goto L52
    L58:
        return;
    L55:
        return;
    L34:
        if (r17.a(r16) != true) goto L36;
    L53:
        r0.i("OrionChatPageStateComponent", "is relaunch ignore special input");
        return;
    L25:
        r4.b(r4.b.G1(), r14, Float.valueOf(r12));
        r4.f(true, false);
    L17:
        r9 = false;
    L21:
        r10 = true;
    L10:
        r7 = false;
        goto L11
    }

    public final void G4(final String r3) {
        ViewGroup r0 = V3();
        if (r0 == null) goto L6;
        r0.post(new c0(this, r3));
        return;
    }

    public final void Gm(boolean r4) {
        FLogger.a.i("OrionChatPageStateComponent", "finishWithAnimation, isUseOverlayAnim = " + r4);
        FrameLayout r5 = X3();
        if (r5 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == false) goto L12;
        FrameLayout r7 = X3();
        if (r7 == null) goto L12;
        ViewExtKt.g(r7);
    L12:
        ObricFloatChatPageData.a r8 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r2 = getPageState();
        r8.getClass();
        if (ObricFloatChatPageData.a.a(r2) == false) goto L15;
    L16:
        Hd(false);
        hca.d.a.a(this, true, 3);
    L17:
        C1(false, true, "finishWithAnimation");
        return;
    L15:
        if (ObricFloatChatPageData.a.e(getPageState()) == true) goto L17;
    L5:
        if (com.larus.utils.e1.s(r5) != true) goto L7;
        r6 = true;
        goto L8
    }

    public final void H30(laa.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        ((ArrayList) this.U).remove(r2);
    }

    public final void HU(hca.b r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        ((ArrayList) this.T).add(r3);
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r1 = getPageState();
        r0.getClass();
        if (ObricFloatChatPageData.a.d(r1) == false) goto L6;
        r3.r2(getPageState() instanceof vda.a);
        return;
    }

    public final void Hd(boolean r4) {
        FLogger.a.i("OrionChatPageStateComponent", "cancelMoveTaskToBack, cancel is " + r4);
        this.X = r4;
    }

    public final void J1(int r17) {
        int r2 = com.obric.assistant.util.m2.a;
        int r3 = com.obric.assistant.util.m2.b(V3(), X3(), Q3(), D3());
        if (r17 < 0) goto L255;
        int r4 = com.obric.assistant.util.m2.b;
        if (r17 > r4) goto L8;
        com.larus.utils.e1.x(e4());
    L8:
        FLogger r5 = FLogger.a;
        r5.e("OrionChatPageStateComponent", "setTopEmptyHeight, value = " + r17 + ", maxTopEmptyHeight = " + r3);
        int r6 = com.obric.assistant.util.m2.e;
        if (r17 <= r6) goto L11;
    L15:
        int r7 = com.obric.assistant.util.m2.f;
        int r9 = r3 - r7;
        if (r17 < r9) goto L39;
        if (r9 <= r4) goto L39;
        RelativeLayout r14 = d4();
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L38;
        ConstraintLayout.LayoutParams r16 = (ConstraintLayout.LayoutParams) r15;
        ((ViewGroup.MarginLayoutParams) r16).height = r9;
        r14.setLayoutParams(r16);
        ObricFloatChatPageData.a r10 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r18 = getPageState();
        r10.getClass();
        if ((r18 instanceof vda.c) == false) goto L23;
    L24:
        d5((r17 + r7) - r3);
    L26:
        if ((getPageState() instanceof vda.c) == false) goto L28;
    L35:
        V4(false);
    L36:
        r5.e("OrionChatPageStateComponent", "setTopEmptyHeight, value = " + r17 + ", maxTopEmptyHeight = " + r3 + ", excludeWindow1 = " + ((r7 + r17) - r3));
    L42:
        com.larus.utils.i0 r8 = com.larus.utils.i0.a;
        r8.getClass();
        int r11 = com.larus.utils.i0.g() - r17;
        if (r11 > 0) goto L46;
        r11 = 0;
    L46:
        FrameLayout r12 = i4();
        if (r12 == null) goto L49;
        int r13 = r12.getPaddingStart();
        int r19 = r12.getPaddingEnd();
        int r110 = r12.getPaddingBottom();
        r5.i("updatePaddingRelative", "view:" + r12.getClass().getSimpleName() + ",source:,start:" + r13 + ",top:" + r11 + ",end:" + r19 + ",bottom:" + r110);
        r12.setPaddingRelative(r13, r11, r19, r110);
    L49:
        r8.getClass();
        if (r17 < com.larus.utils.i0.g()) goto L55;
        r8.getClass();
        float r20 = r17 - com.larus.utils.i0.g();
        r8.getClass();
        float r21 = r20 / (r4 - com.larus.utils.i0.g());
        if (r21 <= 1.0f) goto L54;
        r21 = 1.0f;
    L54:
        e4().setAlpha(r21);
    L56:
        float r22 = r17 / r4;
        if (r22 <= 1.0f) goto L59;
        r22 = 1.0f;
    L59:
        float r23 = this.v1;
        float r24 = this.x1;
        float r25 = ((r23 - r24) * r22) + r24;
        ((GradientDrawable) this.Q1.getValue()).setCornerRadii(new float[]{r25, r25, r25, r25, r24, r24, r24, r24});
        if (r17 != 0) goto L70;
        ObricFloatChatPageData.a r26 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r27 = getPageState();
        r26.getClass();
        if ((r27 instanceof vda.d) == false) goto L70;
        if (s1a.a.getActivity(this).isFinishing() == true) goto L70;
        if (s1a.a.getActivity(this).isDestroyed() == true) goto L70;
        if (Build.VERSION.SDK_INT < 30) goto L70;
        s1a.a.getActivity(this).setTranslucent(false);
    L70:
        pd6.b r28 = pd6.c.a;
        IMultiTaskHostAbility r29 = pd6.c.a(Reflection.getOrCreateKotlinClass(IMultiTaskHostAbility.class));
        if (r29 != null) goto L73;
    L75:
        boolean r30 = false;
    L76:
        ConstraintLayout.LayoutParams r31 = null;
        if (r30 == false) goto L79;
    L113:
        ry8.b r32 = h4();
        if (r32 == null) goto L120;
        com.larus.platform.api.g0 r33 = r32.C5();
        if (r33 == null) goto L120;
        View r34 = r33.getBackIcon();
        if (r34 == null) goto L120;
        ViewGroup.LayoutParams r35 = r34.getLayoutParams();
    L121:
        Intrinsics.checkNotNull(r35, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r36 = (ConstraintLayout.LayoutParams) r35;
        ry8.b r37 = h4();
        if (r37 == null) goto L136;
        com.larus.platform.api.g0 r38 = r37.C5();
        if (r38 == null) goto L136;
        View r39 = r38.getMultitaskManagementIcon();
        if (r39 == null) goto L136;
        ViewGroup.LayoutParams r40 = r39.getLayoutParams();
        if ((r40 instanceof ConstraintLayout.LayoutParams) == false) goto L130;
        r31 = (ConstraintLayout.LayoutParams) r40;
    L130:
        if (r31 == null) goto L136;
        if (r31.startToStart != 0) goto L135;
        r31.setMarginStart(MathKt.roundToInt(((((ViewGroup.MarginLayoutParams) r36).width + r36.getMarginStart()) - i5.q()) * (1 - (r22 * r22))) + i5.q());
    L135:
        r39.setLayoutParams(r31);
    L136:
        float r41 = this.H1;
        float r42 = ((0.0f - r41) * r22) + r41;
        ry8.b r43 = h4();
        if (r43 == null) goto L143;
        com.larus.platform.api.g0 r44 = r43.C5();
        if (r44 == null) goto L143;
        View r45 = r44.getBackIcon();
        if (r45 == null) goto L143;
        r45.setAlpha(r42);
    L143:
        ry8.b r46 = h4();
        if (r46 == null) goto L150;
        com.larus.platform.api.g0 r47 = r46.C5();
        if (r47 == null) goto L150;
        View r48 = r47.getRedDot();
        if (r48 == null) goto L150;
        r48.setAlpha(r42);
    L150:
        ry8.b r49 = h4();
        if (r49 == null) goto L161;
        com.larus.platform.api.g0 r50 = r49.C5();
        if (r50 == null) goto L161;
        View r51 = r50.getBackIcon();
        if (r51 == null) goto L161;
        if (r42 <= 0.9f) goto L159;
        boolean r52 = true;
    L160:
        r51.setEnabled(r52);
        goto L161
    L159:
        r52 = false;
    L161:
        int r53 = r3 - r17;
        if (r53 >= 0) goto L164;
    L166:
        boolean r54 = false;
    L167:
        if (r54 == false) goto L169;
        float r55 = r53 / i5.k0();
    L172:
        if (r17 > r4) goto L174;
        r55 = 1.0f;
    L174:
        Iterator r1 = ((ArrayList) this.U).iterator();
    L176:
        if (r1.hasNext() == false) goto L178;
        ((laa.a) r1.next()).t0(r53);
        goto L176
    L178:
        com.obric.assistant.util.s0 r56 = E3();
        ViewGroup r57 = r56.d;
        if (r57 == null) goto L193;
        int r58 = r57.getChildCount();
        int r59 = 0;
    L181:
        if (r59 >= r58) goto L193;
        View r60 = r57.getChildAt(r59);
        if (ArraysKt.contains(r56.a, r60.getId()) == true) goto L192;
        if (r60.getId() == 2131379994) goto L192;
        if (r60.getAlpha() != r55) goto L189;
        boolean r61 = true;
    L190:
        if (r61 == true) goto L192;
        r60.setAlpha(r55);
        goto L192
    L189:
        r61 = false;
    L192:
        r59 = r59 + 1;
    L193:
        ObricFloatChatPageData.a r62 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r63 = getPageState();
        r62.getClass();
        if ((r63 instanceof vda.a) == false) goto L196;
    L201:
        ObricIconSwipeUpView r64 = (ObricIconSwipeUpView) this.S.getValue();
        if (r64 == null) goto L205;
        r64.setAlpha(1 - r55);
    L205:
        if (r55 < 0.3f) goto L207;
        boolean r111 = true;
    L208:
        laa.m r65 = (laa.m) this.y.getValue();
        if (r65 == null) goto L211;
        r65.uA(1.0f - r55, r111);
    L211:
        qaa.a r66 = (qaa.a) this.F.getValue();
        if (r66 == null) goto L215;
        r66.j00(1.0f - r55, r111);
    L215:
        if (r53 > i5.k0()) goto L220;
        ObricIconSwipeUpView r67 = (ObricIconSwipeUpView) this.S.getValue();
        if (r67 == null) goto L220;
        r67.d(-r53);
    L220:
        if ((getPageState() instanceof vda.e) == false) goto L232;
        ObricFloatChatPageState r68 = getPageState().getPreviousState();
        if (r68 == null) goto L226;
        boolean r112 = true;
        if ((r68 instanceof vda.b) != true) goto L227;
        boolean r69 = true;
    L228:
        if (r69 == false) goto L233;
        u7 r70 = (u7) this.x.getValue();
        if (r70 == null) goto L233;
        r70.TP(false);
    L233:
        float r71 = this.Y;
        if (r71 == r55) goto L237;
        r112 = false;
    L237:
        if (r112 == false) goto L239;
    L245:
        this.Y = r55;
        return;
    L239:
        if (r71 >= 1.0f) goto L245;
        if (r55 < 1.0f) goto L245;
        if ((getPageState() instanceof vda.c) == false) goto L245;
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_TICK);
    L227:
        r69 = false;
        goto L228
    L226:
        r112 = true;
        goto L227
    L232:
        r112 = true;
        goto L233
    L207:
        r111 = false;
        goto L208
    L196:
        if ((getPageState() instanceof vda.c) == true) goto L201;
        ObricIconSwipeUpView r72 = (ObricIconSwipeUpView) this.S.getValue();
        if (r72 == null) goto L205;
        r72.setAlpha(0.0f);
        goto L205
    L169:
        if (r53 >= 0) goto L171;
        r55 = 0.0f;
        goto L172
    L171:
        r55 = 1.0f;
        goto L172
    L164:
        if (r53 > i5.k0()) goto L166;
        r54 = true;
    L120:
        r35 = null;
        goto L121
    L79:
        if (this.y1 == false) goto L106;
        ry8.b r73 = h4();
        if (r73 == null) goto L93;
        com.larus.platform.api.g0 r74 = r73.C5();
        if (r74 == null) goto L93;
        View r75 = r74.getTitle();
        if (r75 == null) goto L93;
        ViewGroup.LayoutParams r76 = r75.getLayoutParams();
        if ((r76 instanceof ConstraintLayout.LayoutParams) == false) goto L89;
        ConstraintLayout.LayoutParams r77 = (ConstraintLayout.LayoutParams) r76;
    L90:
        if (r77 == null) goto L93;
        r77.horizontalBias = ((1 - r22) * 0.5f) + 0.0f;
        r77.setMarginStart(MathKt.roundToInt(i5.E() * r22));
        r75.setLayoutParams(r77);
        goto L93
    L89:
        r77 = null;
    L93:
        ry8.b r78 = h4();
        if (r78 == null) goto L113;
        com.larus.platform.api.g0 r79 = r78.C5();
        if (r79 == null) goto L113;
        View r80 = r79.getTitleText();
        if (r80 == null) goto L113;
        ConstraintLayout.LayoutParams r81 = r80.getLayoutParams();
        if ((r81 instanceof ConstraintLayout.LayoutParams) == false) goto L102;
        ConstraintLayout.LayoutParams r82 = r81;
    L103:
        if (r82 == null) goto L113;
        r82.horizontalBias = ((1 - r22) * 0.5f) + 0.0f;
        r80.setLayoutParams(r82);
        goto L113
    L102:
        r82 = null;
        goto L103
    L106:
        float r83 = ((this.G1 - 0.0f) * r22) + 0.0f;
        ry8.b r84 = h4();
        if (r84 == null) goto L113;
        com.larus.platform.api.g0 r85 = r84.C5();
        if (r85 == null) goto L113;
        View r86 = r85.getTitle();
        if (r86 == null) goto L113;
        r86.setTranslationX(r83);
        goto L113
    L73:
        if (r29.P0() != true) goto L75;
        r30 = true;
        goto L76
    L55:
        e4().setAlpha(0.0f);
        goto L56
    L28:
        if ((getPageState() instanceof vda.a) == true) goto L35;
        if ((getPageState() instanceof vda.e) == false) goto L33;
    L34:
        V4(true);
        goto L36
    L33:
        if ((getPageState() instanceof vda.d) == false) goto L36;
    L23:
        if ((getPageState() instanceof vda.a) == false) goto L26;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L39:
        RelativeLayout r87 = d4();
        ViewGroup.LayoutParams r88 = r87.getLayoutParams();
        if (r88 == null) goto L248;
        ConstraintLayout.LayoutParams r89 = (ConstraintLayout.LayoutParams) r88;
        ((ViewGroup.MarginLayoutParams) r89).height = r17;
        r87.setLayoutParams(r89);
        V4(true);
        d5(0.0f);
        r5.e("OrionChatPageStateComponent", "setTopEmptyHeight, value = " + r17 + ", maxTopEmptyHeight = " + r3 + ", excludeWindow2 = 0");
        goto L42
    L248:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L11:
        if (G1() <= r6) goto L15;
        ObricFloatChatPageData.a r90 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r91 = getPageState();
        r90.getClass();
        if ((r91 instanceof vda.c) == false) goto L15;
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_TICK);
        goto L15
    }

    public final void Ks(boolean r2) {
        G3().o(r2);
    }

    public final void MO(boolean r1) {
        G3().s();
    }

    public final void Mx(laa.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        ((ArrayList) this.U).add(r2);
    }

    public final void P5(int r1) {
        this.p0 = r1;
    }

    public final void R4(View r3) {
        ViewParent r0 = r3.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 == null) goto L9;
        r1.removeView(r3);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void U3(boolean r2) {
        G3().t(r2);
    }

    public final boolean UR(String r4) {
        Intrinsics.checkNotNullParameter(r4, "from");
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r1 = getPageState();
        r0.getClass();
        if ((r1 instanceof vda.e) == false) goto L20;
        com.larus.bmhome.chat.component.fastsend.e0 r2 = (com.larus.bmhome.chat.component.fastsend.e0) this.G.getValue();
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L21;
        com.larus.bmhome.chat.component.fastsend.e0 r5 = (com.larus.bmhome.chat.component.fastsend.e0) this.G.getValue();
        if (r5 != null) goto L14;
    L16:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L22;
        C1(false, true, r4);
        return true;
    L22:
        return false;
    L14:
        if (r5.bx() != true) goto L16;
        r6 = true;
        goto L17
    L21:
        return false;
    L7:
        if (r2.xX() != true) goto L9;
        r3 = true;
        goto L10
    L20:
        return false;
    }

    public final void V4(boolean r3) {
        FrameLayout r0 = (FrameLayout) this.Q.getValue();
        if (r0 == null) goto L8;
        if (r3 == false) goto L6;
        float r1 = 1.0f;
    L7:
        r0.setAlpha(r1);
        goto L8
    L6:
        r1 = 0.0f;
    L8:
        if (r3 == false) goto L12;
        FrameLayout r4 = (FrameLayout) this.Q.getValue();
        if (r4 == null) goto L16;
        com.larus.utils.e1.x(r4);
        return;
    L16:
        return;
    L12:
        FrameLayout r5 = (FrameLayout) this.Q.getValue();
        if (r5 == null) goto L18;
        com.larus.utils.e1.q(r5);
        return;
    }

    public final void W4(final Function0<Unit> r2) {
        com.larus.utils.t0.e(new r0(this, r2));
    }

    public final void X2(int r1) {
        this.h2 = r1;
    }

    public final void Yx(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        G3().u(r2);
    }

    public final void a7(boolean r2) {
        G3().l(r2);
    }

    public final void c(Object r4) {
        wc9.e r5 = (wc9.e) r4;
        Intrinsics.checkNotNullParameter(r5, "new");
        if (ic8.n.v(r5) == false) goto L13;
        com.larus.im.d.e().registerOnMessageChangedObserver(r5.a, this.g1);
        String r6 = r5.a;
        if (r6.length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        com.larus.im.internal.stream.b r1 = com.larus.im.internal.stream.b.a;
        z r2 = this.h1;
        r1.e(r2.a, r2);
        z r3 = this.h1;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r3.a = r6;
        r1.b(r6, this.h1);
    L11:
        f5();
        G4("conversation_change");
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final void d5(float r7) {
        ViewGroup r0 = V3();
        if (r0 == null) goto L10;
        int r1 = r0.getChildCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L14;
        View r3 = r0.getChildAt(r2);
        if (ArraysKt.contains((int[]) this.p1.getValue(), r3.getId()) == true) goto L9;
        r3.setTranslationY(r7);
    L9:
        r2 = r2 + 1;
        goto L5
    L14:
        return;
    }

    public final void g8(int r2) {
        G3().i(r2);
    }

    public final void h1(boolean r2) {
        q4(3, r2);
    }

    public final void h5(boolean r9) {
        FragmentActivity r0 = this.p2;
        if (r0 == null) goto L5;
        Intent r1 = r0.getIntent();
    L6:
        int r2 = 0;
        String[] r3 = x2;
        if (r9 == false) goto L14;
        if (r1 == null) goto L12;
        int r5 = r3.length;
        int r6 = 0;
    L10:
        if (r6 >= r5) goto L12;
        r1.removeExtra(r3[r6]);
        r6 = r6 + 1;
    L12:
        if (r1 == null) goto L16;
        r1.putExtra("argument_restore_full_screen_on_recreate", true);
    L16:
        de8.c r4 = f1();
        if (r4 == null) goto L26;
        Bundle r7 = r4.a;
        if (r7 == null) goto L26;
        if (r9 == false) goto L25;
        int r8 = r3.length;
        int r10 = 0;
    L22:
        if (r10 >= r8) goto L24;
        r7.remove(r3[r10]);
        r10 = r10 + 1;
        goto L22
    L24:
        r7.putBoolean("argument_restore_full_screen_on_recreate", true);
        goto L26
    L25:
        r7.remove("argument_restore_full_screen_on_recreate");
    L26:
        de8.c r11 = f1();
        if (r11 == null) goto L40;
        Bundle r12 = r11.b;
        if (r12 == null) goto L41;
        if (r9 == false) goto L35;
        int r13 = r3.length;
    L32:
        if (r2 >= r13) goto L34;
        r12.remove(r3[r2]);
        r2 = r2 + 1;
        goto L32
    L34:
        r12.putBoolean("argument_restore_full_screen_on_recreate", true);
        return;
    L35:
        r12.remove("argument_restore_full_screen_on_recreate");
        return;
    L41:
        return;
    L40:
        return;
    L14:
        if (r1 == null) goto L16;
        r1.removeExtra("argument_restore_full_screen_on_recreate");
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    public final void j1(boolean r2) {
        q4(0, r2);
    }

    public final void o2(int r8) {
        ObricFloatChatPageState r1 = null;
        if (p4() == true) goto L7;
        z3("ignore_dragging_unsupported", null);
        return;
    L7:
        if (r8 != G1()) goto L9;
        return;
    L9:
        int r0 = com.obric.assistant.util.m2.a;
        int r2 = com.obric.assistant.util.m2.b(V3(), X3(), Q3(), D3());
        if (r8 > r2) goto L12;
    L15:
        ObricFloatChatPageData.a r3 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r4 = getPageState();
        r3.getClass();
        if ((r4 instanceof vda.a) == true) goto L18;
    L20:
        OrionChatPageStateViewModel r5 = j4();
        vda.c r6 = new vda.c(r8, null);
        if ((getPageState() instanceof vda.c) == false) goto L23;
        r6.setPreviousState(getPageState().getPreviousState());
    L30:
        r5.changePageStatus(r6);
        return;
    L23:
        ObricFloatChatPageState r9 = getPageState();
        if (Boolean.valueOf(r9 instanceof vda.a).booleanValue() == false) goto L26;
        r1 = r9;
    L26:
        if (r1 == null) goto L28;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.assistant.data.ObricFloatChatPageStateChatWindow");
        int r7 = com.obric.assistant.util.m2.b(V3(), X3(), Q3(), D3());
        ((vda.a) r1).b = r7;
    L29:
        r6.setPreviousState(r1);
        goto L30
    L28:
        r1 = getPageState();
        goto L29
    L18:
        if (G1() == r2) goto L20;
        J1(r2);
        goto L20
    L12:
        if (G1() != r2) goto L14;
        return;
    L14:
        r8 = r2;
        goto L15
    }

    public final void onViewCreated(View r25) {
        Intrinsics.checkNotNullParameter(r25, "view");
        ViewGroup r0 = V3();
        if (r0 == null) goto L5;
        r0.setAlpha(0.0f);
    L5:
        com.larus.bmhome.chat.component.cvs.y r1 = (com.larus.bmhome.chat.component.cvs.y) this.s.getValue();
        if (r1 == null) goto L8;
        com.larus.bmhome.chat.component.cvs.y.b.b(r1, this);
    L8:
        FLogger r8 = FLogger.a;
        r8.i("OrionChatPageStateComponent", "init");
        R4((View) this.M1.getValue());
        R4((View) this.P1.getValue());
        R4(d4());
        R4((View) this.T1.getValue());
        R4(e4());
        Bundle r2 = null;
        if (Da() == false) goto L50;
        BaseConstraintLayout r3 = V3();
        if (r3 != null) goto L13;
    L33:
        FrameLayout r4 = i4();
        if (r4 == null) goto L36;
        r4.addView(e4(), new ConstraintLayout.LayoutParams(-1, i5.k0()));
    L36:
        FrameLayout r5 = X3();
        if (r5 == null) goto L39;
        r5.setOnTouchListener(new e0(this));
    L39:
        com.larus.utils.e1.d((View) this.P1.getValue(), new f0());
        ObricSwipeGestureView r6 = e4();
        com.obric.assistant.util.j0 r7 = G3();
        r7.getClass();
        r6.setOnSwipeGestureListener(new com.obric.assistant.util.k0(r7));
        ComponentViewModel.onEach$default(j4(), ObricChatPageStateComponent$init$4.INSTANCE, null, new ObricChatPageStateComponent$init$5(this, null), 2, null);
        FrameLayout r18 = Q3();
        if (r18 == null) goto L42;
        ViewExtKt.l(r18, new g0(this), null, null, null, 14);
    L42:
        IAssistantInteractionServiceKt.getInteractionStateService().setAutoIncreaseWindowObserver(this, new h0(this));
        if (com.obric.assistant.t1.a.m0() == true) goto L49;
        r8.i("OrionChatPageStateComponent", "showUserGuide: enter");
        if (cea.b.a() == true) goto L49;
        ViewGroup r9 = V3();
        if (r9 == null) goto L49;
        r9.post(new i0(this));
    L49:
        d4().addView(new SessionAuthenticationStateView(getContext()));
        G3().x();
    L56:
        B3();
        IObricActivityService r10 = (IObricActivityService) com.obric.assistant.k.a.getValue();
        if (r10 != null) goto L59;
    L61:
        boolean r11 = false;
    L62:
        OrionChatPageStateViewModel r12 = j4();
        de8.c r13 = f1();
        if (r13 == null) goto L65;
        r2 = r13.a;
    L65:
        OrionChatPageStateViewModel.initPageState$default(r12, r2, this, r11, false, 8, null);
        de8.c r14 = f1();
        if (r14 == null) goto L70;
        Bundle r15 = r14.a;
        if (r15 == null) goto L70;
        boolean r16 = r15.getBoolean("arg_long_press_ai", false);
    L71:
        this.k0 = r16;
        r8.i("OrionChatPageStateComponent", "onViewCreated: isLongPressAiStart: " + this.k0);
        if (Da() == false) goto L79;
        FragmentActivity r17 = s1a.a.getActivity(this);
        boolean r19 = v19.h.a;
        com.larus.utils.u.g(r17, !v19.h.b(getContext()));
        if (Build.VERSION.SDK_INT < 29) goto L80;
        Window r20 = s1a.a.getActivity(this).getWindow();
        if (r20 == null) goto L81;
        r20.setNavigationBarContrastEnforced(false);
        return;
    L81:
        return;
    L80:
        return;
    L79:
        return;
    L70:
        r16 = false;
        goto L71
    L59:
        if (r10.a(s1a.a.getActivity(this)) != true) goto L61;
        r11 = true;
        goto L62
    L13:
        if ((r3 instanceof BaseConstraintLayout) == false) goto L15;
        r3.setDisableTopPadding(true);
    L15:
        r3.indexOfChild(i4());
        r3.setBackgroundColor(0);
        r3.setClipToPadding(false);
        r3.setClipChildren(false);
        int r21 = r3.getPaddingStart();
        int r22 = r3.getPaddingEnd();
        int r23 = r3.getPaddingBottom();
        r8.i("updatePaddingRelative", "view:" + r3.getClass().getSimpleName() + ",source:,start:" + r21 + ",top:0,end:" + r22 + ",bottom:" + r23);
        r3.setPaddingRelative(r21, 0, r22, r23);
        View r24 = (View) this.M1.getValue();
        com.larus.utils.i0 r26 = com.larus.utils.i0.a;
        r26.getClass();
        ViewGroup.LayoutParams r27 = new ConstraintLayout.LayoutParams(0, com.larus.utils.i0.g() + i5.k0());
        ((ConstraintLayout.LayoutParams) r27).topToTop = 0;
        ((ConstraintLayout.LayoutParams) r27).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r27).endToEnd = 0;
        Unit r28 = Unit.INSTANCE;
        r3.addView(r24, 0, r27);
        View r29 = (View) this.P1.getValue();
        ViewGroup.LayoutParams r30 = new ConstraintLayout.LayoutParams(0, 0);
        ((ConstraintLayout.LayoutParams) r30).topToTop = 2131388843;
        ((ConstraintLayout.LayoutParams) r30).bottomToBottom = ((View) this.T1.getValue()).getId();
        ((ConstraintLayout.LayoutParams) r30).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r30).endToEnd = 0;
        r3.addView(r29, 0, r30);
        RelativeLayout r31 = d4();
        ViewGroup.LayoutParams r32 = new ConstraintLayout.LayoutParams(0, 0);
        ((ConstraintLayout.LayoutParams) r32).topToTop = 0;
        ((ConstraintLayout.LayoutParams) r32).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r32).endToEnd = 0;
        ((ConstraintLayout.LayoutParams) r32).bottomToTop = 2131388843;
        r3.addView(r31, 0, r32);
        View r33 = (View) this.T1.getValue();
        r26.getClass();
        ViewGroup.LayoutParams r34 = new ConstraintLayout.LayoutParams(0, com.larus.utils.i0.e() + ((Number) i5.U1.getValue()).intValue());
        ((ConstraintLayout.LayoutParams) r34).topToBottom = 2131364480;
        ((ConstraintLayout.LayoutParams) r34).startToStart = 0;
        r3.addView(r33, r34);
        FrameLayout r35 = i4();
        if (r35 == null) goto L18;
        ViewGroup.LayoutParams r36 = r35.getLayoutParams();
    L20:
        if ((r36 instanceof ConstraintLayout.LayoutParams) == false) goto L22;
        ConstraintLayout.LayoutParams r37 = (ConstraintLayout.LayoutParams) r36;
    L23:
        if (r37 == null) goto L27;
        r37.topToTop = -1;
        r37.topToBottom = d4().getId();
        FrameLayout r38 = i4();
        if (r38 == null) goto L27;
        r38.setLayoutParams(r37);
    L27:
        com.larus.utils.e1.d(r3, new d0(this));
        ViewGroup.LayoutParams r39 = r3.getLayoutParams();
        if ((r39 instanceof FrameLayout.LayoutParams) == false) goto L30;
        FrameLayout.LayoutParams r40 = (FrameLayout.LayoutParams) r39;
    L31:
        if (r40 == null) goto L33;
        r40.gravity = 1;
        goto L33
    L30:
        r40 = null;
        goto L31
    L22:
        r37 = null;
        goto L23
    L18:
        r36 = null;
        goto L20
    L50:
        ViewGroup r41 = V3();
        if (r41 == null) goto L53;
        r41.setAlpha(1.0f);
    L53:
        ViewGroup r42 = V3();
        if (r42 == null) goto L56;
        View r43 = (View) this.M1.getValue();
        ConstraintLayout.LayoutParams r44 = new ConstraintLayout.LayoutParams(0, i5.k0());
        r44.topToTop = 0;
        r44.startToStart = 0;
        r44.endToEnd = 0;
        Unit r45 = Unit.INSTANCE;
        r42.addView(r43, 0, r44);
        r42.setBackgroundColor(ContextCompat.getColor(r42.getContext(), 2131102529));
        goto L56
    }

    public final boolean rD(String r12) {
        FLogger r0 = FLogger.a;
        r0.i("OrionChatPageStateComponent", "onPerformBack return , pageState = " + getPageState());
        ObricFloatChatPageData.a r1 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r3 = getPageState();
        r1.getClass();
        if ((r3 instanceof vda.a) == false) goto L7;
        Gm(false);
        return true;
    L7:
        if ((getPageState() instanceof vda.e) == false) goto L11;
        laa.d.a.a(this, 0.0f, false, 2);
        return true;
    L11:
        if ((getPageState() instanceof vda.d) == true) goto L13;
        return false;
    L13:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r5 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        String r6 = null;
        if (r5 == null) goto L22;
        Activity r7 = AppHost.a.a().a(r5, null);
        if (r7 == null) goto L22;
        if (r7.getTaskId() != r5.getTaskId()) goto L20;
        boolean r8 = true;
    L21:
        Boolean r9 = Boolean.valueOf(r8);
    L23:
        if (r9 != null) goto L25;
        boolean r10 = true;
    L26:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r11 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r11 == null) goto L36;
        Activity r13 = AppHost.a.a().a(r11, null);
        if (r13 == null) goto L33;
        AppletExtService r14 = (AppletExtService) ServiceManager.get().getService(AppletExtService.class);
        if (r14 == null) goto L33;
        Boolean r15 = Boolean.valueOf(r14.o(r13));
    L34:
        if (r15 == null) goto L36;
        boolean r16 = r15.booleanValue();
    L37:
        StringBuilder r17 = new StringBuilder("onPerformBack leaveMethod = ");
        r17.append(r12);
        r17.append(" taskEmpty = ");
        r17.append(r10);
        r17.append(", wakeupSource = ");
        ObricInteractDelegate r18 = ObricInteractDelegate.b;
        r17.append(r18.getWakeupSource());
        r17.append(", previousPage: ");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r19 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r19 == null) goto L40;
        String r20 = r19.getString("argPreviousPage");
    L41:
        r17.append(r20);
        r17.append(", argument: ");
        Intrinsics.checkNotNullParameter(this, "<this>");
        r17.append(com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments());
        r0.i("OrionChatPageStateComponent", r17.toString());
        if (r10 == true) goto L45;
        if (r16 == true) goto L45;
    L52:
        return false;
    L45:
        if (Intrinsics.areEqual(r18.getWakeupSource(), Boolean.TRUE) == true) goto L51;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r110 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r110 == null) goto L50;
        r6 = r110.getString("argPreviousPage");
    L50:
        if (Intrinsics.areEqual(r6, "wakeup") == false) goto L52;
    L51:
        r0.i("OrionChatPageStateComponent", "launch MainActivity");
        com.bytedance.router.i r111 = SmartRouter.buildRoute(getContext(), "//flow/home");
        r111.c.putExtra("is_from_hot_launch", true);
        r111.d = 2130772523;
        r111.e = 2130772525;
        r111.c.addFlags(268468224);
        r111.d();
        goto L52
    L40:
        r20 = null;
    L33:
        r15 = null;
    L36:
        r16 = false;
        goto L37
    L25:
        r10 = false;
        goto L26
    L20:
        r8 = false;
    L22:
        r9 = null;
        goto L23
    }

    public final void v4(vda.d r8) {
        ObricFloatChatPageState r0 = r8.getPreviousState();
        if (l4(r0) == true) goto L14;
        if (r0 == null) goto L8;
        ObricFloatChatPageData.Companion.getClass();
        if ((r0 instanceof vda.c) != true) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
    L13:
        boolean r2 = false;
    L15:
        if (r2 == false) goto L17;
        h5(true);
    L17:
        FragmentActivity r3 = s1a.a.getActivity(this);
        boolean r4 = v19.h.a;
        com.larus.utils.u.g(r3, !v19.h.b(getContext()));
        this.L1.storeBoolean("is_dismiss_from_half_screen", false);
        C3(false);
        boolean r5 = r8.a;
        Float r9 = r8.b;
        e4().setEnabled(false);
        E3().e(0);
        if (r5 == false) goto L20;
        E3().b(G1(), 0.0f, r9);
    L21:
        E3().g(0);
        ViewGroup r10 = V3();
        if (r10 == null) goto L24;
        int r6 = r10.getPaddingTop();
        int r7 = r10.getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + r10.getClass().getSimpleName() + ",source:,start:0,top:" + r6 + ",end:0,bottom:" + r7);
        r10.setPaddingRelative(0, r6, 0, r7);
    L24:
        i5();
        FLogger r11 = FLogger.a;
        r11.i("OrionChatPageStateComponent", "onChangeToFull");
        ObricInteractDelegate.b.notifyChangeWindowEvent(true);
        if (Build.VERSION.SDK_INT < 27) goto L27;
        r11.i("OrionChatPageStateComponent", "setShowWhenLocked false");
        s1a.a.getActivity(this).setShowWhenLocked(false);
    L27:
        ry8.b r12 = h4();
        if (r12 == null) goto L47;
        com.larus.platform.api.g0 r13 = r12.C5();
        if (r13 == null) goto L47;
        View r14 = r13.getMultitaskManagementIcon();
        if (r14 == null) goto L47;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if ((r15 instanceof ConstraintLayout.LayoutParams) == false) goto L36;
        ConstraintLayout.LayoutParams r16 = (ConstraintLayout.LayoutParams) r15;
    L37:
        if (r16 == null) goto L47;
        int r17 = -1;
        r16.startToStart = -1;
        ry8.b r18 = h4();
        if (r18 == null) goto L46;
        com.larus.platform.api.g0 r19 = r18.C5();
        if (r19 == null) goto L46;
        View r20 = r19.getBackIcon();
        if (r20 == null) goto L46;
        r17 = r20.getId();
    L46:
        r16.startToEnd = r17;
        r16.setMarginStart(0);
        r14.setLayoutParams(r16);
        goto L47
    L36:
        r16 = null;
    L47:
        com.larus.utils.u.e(s1a.a.getActivity(this), true, v19.h.a(null));
        return;
    L20:
        E3().a();
        J1(0);
        goto L21
    L11:
        if (l4(r0.getPreviousState()) == false) goto L13;
    L8:
        r1 = false;
    L14:
        r2 = true;
        goto L15
    }

    public final void zf(boolean r2) {
        G3().q(r2);
    }

    public static final void Y2(ObricChatPageStateComponent r9, String r10) {
        laa.w r0 = r9.H0;
        if (r0 == null) goto L19;
        String r1 = sea.e.b();
        if (Intrinsics.areEqual(r1, r0.a) == true) goto L8;
        FLogger.a.i("OrionChatPageStateComponent", "tryConsumePendingComplexTaskReplyTarget skipped, trigger=" + r10 + ", reason=expired_or_replaced, pending=" + r0 + ", sceneReplyMessageId=" + r1);
        r9.H0 = null;
        return;
    L8:
        Intrinsics.checkNotNullParameter(r9, "<this>");
        laa.c r2 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(r9, r9)).getAbility(laa.c.class);
        if (r2 != null) goto L12;
        FLogger.a.i("OrionChatPageStateComponent", "tryConsumePendingComplexTaskReplyTarget skipped, trigger=" + r10 + ", reason=no_chat_list_ability, pending=" + r0);
        return;
    L12:
        if (r2.BL(r0.a) == true) goto L14;
        FLogger.a.i("OrionChatPageStateComponent", "tryConsumePendingComplexTaskReplyTarget waiting, trigger=" + r10 + ", replyMessageId=" + r0.a + ", source=" + r0.b);
        return;
    L14:
        FLogger.a.i("OrionChatPageStateComponent", "tryConsumePendingComplexTaskReplyTarget success, trigger=" + r10 + ", replyMessageId=" + r0.a + ", source=" + r0.b);
        r2.vC(r0.a);
        sea.e.e.set(SystemClock.elapsedRealtime());
        r9.H0 = null;
        sea.e.a(r0.a);
        return;
    }

    public final void C0(boolean r2, boolean r3) {
        G3().k(r2, r3);
    }

    public final void D50(String r1, String r2) {
        if (r1 == null) goto L6;
        if (r2 == null) goto L7;
        G3().r(null);
        return;
    L7:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T4(List<String> r10, int r11) {
        FLogger.a.i("OrionChatPageStateComponent", "requestEachPermission permissions: " + r10 + ", permissionIndex: " + r11);
        if (r11 >= 0) goto L5;
        return;
    L5:
        if (r11 >= r10.size()) goto L9;
        List r4 = CollectionsKt.mutableListOf(new String[]{ListProtector.get(r10, r11)});
        com.larus.platform.service.i2 r0 = com.larus.platform.service.i2.b;
        com.larus.platform.api.g1.a.b(s1a.a.getActivity(this), r4, new b(r4, r11, r10, this), null, null, 56);
        return;
    }

    public final void T8(float r3, boolean r4) {
        if (p4() == true) goto L6;
        z3("ignore_chat_window_unsupported", Float.valueOf(r3));
        return;
    L6:
        OrionChatPageStateViewModel r5 = j4();
        vda.a r0 = new vda.a(r3, 2);
        r0.setPreviousState(getPageState());
        r5.changePageStatus(r0);
    }

    public final void q4(int r12, boolean r13) {
        if (r12 == 1) goto L10;
        if (r13 == true) goto L10;
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r1 = getPageState();
        r0.getClass();
        if ((r1 instanceof vda.a) == false) goto L10;
        FrameLayout r2 = X3();
        if (r2 == null) goto L10;
        r2.post(new com.obric.assistant.component.x(this));
    L10:
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("onBottomPanelVisibleChanged, type is ");
        r4.append(r12);
        r4.append(", visible is ");
        r4.append(r13);
        r4.append(", current page is ");
        r4.append(getPageState());
        r4.append(", min top empty height is ");
        int r5 = com.obric.assistant.util.m2.b;
        r4.append(r5);
        r3.i("OrionChatPageStateComponent", r4.toString());
        if (r13 == false) goto L19;
        ObricFloatChatPageData.a r6 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r7 = getPageState();
        r6.getClass();
        if ((r7 instanceof vda.e) == true) goto L17;
        if ((getPageState() instanceof vda.c) == false) goto L19;
    L17:
        if (getPageState().getHeight() <= r5) goto L19;
        G3().h();
        laa.d.a.d(this, false, r5, null, false, false, null, 61);
    L23:
        G3().j(r12, r13);
        return;
    L19:
        if (r13 == false) goto L23;
        ObricFloatChatPageData.a r8 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r9 = getPageState();
        r8.getClass();
        if ((r9 instanceof vda.c) == false) goto L23;
        G3().h();
        laa.d.a.d(this, false, r5, null, false, false, null, 61);
        goto L23
    }

    public final void xw(String r14, boolean r15) {
        FLogger r0 = FLogger.a;
        r0.i("OrionChatPageStateComponent", "changePageState = " + r14);
        if (p4() == true) goto L6;
        z3("ignore_page_state_unsupported_" + r14, null);
        return;
    L6:
        ObricFloatChatPageData.Companion.getClass();
        if (Intrinsics.areEqual(r14, ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp()) == false) goto L13;
        com.obric.assistant.util.j0 r1 = G3();
        r1.getClass();
        r1.l = xg9.b.a().getLong("last_msg_create_time", Long.MAX_VALUE);
        r1.x();
        int r2 = this.L1.getInt("launch_to_half_screen_mode", 0);
        if (r2 != 2) goto L11;
        this.W = this.L1.getInt("last_dismiss_height_from_half_screen", 0);
    L11:
        r0.i("OrionChatPageStateComponent", "changePageState, launchToHalfScreenMode = " + r2 + " halfScreenHeight= " + this.W);
    L13:
        if (Intrinsics.areEqual(r14, ObricFloatChatPageData.access$getCHAT_WINDOW_SIMPLE_NAME$cp()) == false) goto L16;
        laa.d.a.a(this, 0.0f, false, 3);
        return;
    L16:
        if (Intrinsics.areEqual(r14, ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp()) == false) goto L19;
        laa.d.a.d(this, false, this.W, null, false, false, null, 61);
        this.W = com.obric.assistant.util.m2.b;
        return;
    L19:
        if (Intrinsics.areEqual(r14, ObricFloatChatPageData.access$getFULL_SCREEN_SIMPLE_NAME$cp()) == false) goto L26;
        if (r15 == false) goto L22;
        j4().changePageStatus(p3(false, null, "restore_full_screen_on_recreate"));
        return;
    L22:
        laa.d.a.c(this, null, false, null, 7);
        return;
    }

    public final void z3(String r5, Float r6) {
        ObricFloatChatPageState r0 = getPageState();
        ObricFloatChatPageData.Companion.getClass();
        if ((r0 instanceof vda.d) == false) goto L6;
        FLogger.a.i("OrionChatPageStateComponent", "ensureFullScreenStateForUnsupportedHost skip, already full screen, reason=" + r5);
        return;
    L6:
        FLogger.a.i("OrionChatPageStateComponent", "ensureFullScreenStateForUnsupportedHost change to full screen, reason=" + r5);
        j4().changePageStatus(p3(false, r6, r5));
    }

    public final void C1(boolean r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "from");
        FLogger.a.i("OrionChatPageStateComponent", "switchMenuEntranceStatus newStatus:false, isReset:" + r4 + ", from:" + r5);
        ICoreInputAbility r6 = W3();
        if (r6 == null) goto L6;
        r6.C1(false, r4, "");
        return;
    }

    public final void Ns(int r6, boolean r7, boolean r8) {
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r1 = getPageState();
        r0.getClass();
        if ((r1 instanceof vda.e) == false) goto L5;
        long r2 = System.currentTimeMillis();
        FLogger.a.i("OrionChatPageStateComponent", "saveDismissInfo, dismissTime = " + r2);
        this.L1.storeLong("last_dismiss_time_from_half_screen", r2);
        this.L1.storeLong("last_dismiss_time", r2);
        this.L1.storeInt("last_dismiss_height_from_half_screen", getPageState().getHeight());
        this.L1.storeBoolean("is_dismiss_from_half_screen", true);
    L5:
        OrionChatPageStateViewModel r3 = j4();
        vda.b r4 = new vda.b(r6, r7, r8, false);
        r4.setPreviousState(getPageState());
        r3.changePageStatus(r4);
    }

    public final void T7(final Float r13, final boolean r14, String r15) {
        Intrinsics.checkNotNullParameter(r15, WindowEvent.Params.REASON);
        FLogger r0 = FLogger.a;
        r0.i("OrionChatPageStateComponent", "changeToFull, isScreenLocked = " + IKeyguardStateKt.getKeyguardState().isKeyguardLocked() + ", reason = " + r15);
        boolean r2 = false;
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L5;
        com.obric.assistant.spi.keyguard.a.a(new a0(this, r14, r13), new b0(this, r13), null, false, 28);
        return;
    L5:
        long r6 = this.L1.getLong("last_dismiss_time", 0);
        long r8 = this.L1.getLong("last_message_send_time_ms", 0);
        long r3 = this.L1.getLong("response_end_time", 0);
        long r10 = System.currentTimeMillis();
        r0.i("OrionChatPageStateComponent", "isFirstOpenAfterResponseCompleted, lastDismiss:" + r6 + ", lastMsgSendTime:" + r8 + ", responseEnd:" + r3 + ", currentTime:" + r10);
        if ((r8 + 1) <= r6) goto L8;
    L10:
        if (r2 == true) goto L12;
    L14:
        j4().changePageStatus(p3(r14, r13, ""));
        return;
    L12:
        if ((r10 - r3) > 300000) goto L14;
        this.L1.storeBoolean("is_shown_after_responded", true);
        this.L1.storeBoolean("is_shown_sub_message_received", true);
        goto L14
    L8:
        if (r6 >= r3) goto L10;
        r2 = true;
        goto L10
    }

    public final void Y9(Bundle r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "bundle");
        boolean r7 = false;
        boolean r8 = r4.getBoolean("conversation_exit", false);
        String r9 = r4.getString("leave_method", "");
        de8.c r0 = f1();
        if (r0 == null) goto L7;
        Bundle r1 = r0.a;
        if (r1 == null) goto L7;
        r7 = r1.getBoolean("arg_auto_go_to_setting", false);
        r1.remove("arg_auto_go_to_setting");
    L7:
        FLogger.a.i("OrionChatPageStateComponent", "handleChatSettingResult, backFromSetting = " + r8 + ", autoGoToSettings = " + r7 + " leaveMethod " + r9);
        if (r8 == false) goto L14;
        if (r7 == true) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual("click_clear_context", r9) == true) goto L16;
        AppHost.a.a().finishAllActivities();
        return;
    L16:
        return;
    }

    public final void k4(final boolean r2, final Float r3, final boolean r4) {
        W4(new com.obric.assistant.component.z(r4, this, r3, r2));
    }

    public final void m3(boolean r4, int r5, Float r6) {
        FLogger.a.i("OrionChatPageStateComponent", "changeToHalfInternal useAnim = " + r4 + ", topEmptyHeight = " + r5 + ", velocity = " + r6);
        int r0 = com.obric.assistant.util.m2.a;
        vda.e r1 = new vda.e(r4, Math.max(r5, com.obric.assistant.util.m2.b), r6);
        r1.setPreviousState(getPageState());
        j4().changePageStatus(r1);
        ObricInteractDelegate.b.notifyWakeupEvent(true);
    }

    public final vda.d p3(boolean r2, Float r3, String r4) {
        vda.d r0 = new vda.d(r2, r3, r4);
        ObricFloatChatPageState r5 = getPageState();
        ObricFloatChatPageState r6 = r5.getPreviousState();
        if (r6 == null) goto L12;
        ObricFloatChatPageData.Companion.getClass();
        if ((r5 instanceof vda.c) == true) goto L7;
    L9:
        boolean r7 = false;
    L10:
        if (r7 == false) goto L12;
    L13:
        if (r6 == null) goto L16;
        r5 = r6;
    L16:
        r0.setPreviousState(r5);
        return r0;
    L7:
        if (l4(r6) == false) goto L9;
        r7 = true;
    L12:
        r6 = null;
        goto L13
    }

    public final void i2(boolean r4, int r5, Float r6, boolean r7, boolean r8, PageStateChangedReason r9) {
        Intrinsics.checkNotNullParameter(r9, WindowEvent.Params.REASON);
        if (p4() == true) goto L6;
        z3("ignore_half_window_unsupported", r6);
        return;
    L6:
        FLogger r10 = FLogger.a;
        r10.i("OrionChatPageStateComponent", "changeToHalf, useAnim = " + r4 + ", topEmptyHeight = " + r5 + ", velocity = " + r6 + ", requestBiometricAuthentication = " + r7);
        ObricFloatChatPageData.a r11 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r2 = getPageState();
        r11.getClass();
        if ((r2 instanceof vda.e) == false) goto L13;
        if (r5 < getPageState().getHeight()) goto L13;
        r10.i("OrionChatPageStateComponent", "changeToHalf, but change to small, ignore");
        return;
    L13:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L39;
        if (r7 == false) goto L18;
        if (((Boolean) SessionAuthenticationServiceDelegate.b.o().getValue()).booleanValue() == true) goto L18;
    L20:
        if (j4().isInKeyguardAndWithSendingMessage() == true) goto L22;
    L35:
        r10.i("OrionChatPageStateComponent", "handleBiometricAuthentication");
        r10.i("OrionChatPageStateComponent", "handleBiometricAuthentication useAnim = " + r4 + ", velocity = " + r6);
        ISessionAuthenticationService r12 = (ISessionAuthenticationService) ServiceManager.get().getService(ISessionAuthenticationService.class);
        if (r12 == null) goto L38;
        r12.g(new com.obric.assistant.o4(null, null, null, 7), 15000L, new e1(this, r4, r6), false);
        return;
    L38:
        r10.w("OrionChatPageStateComponent", "requestBiometricAuthentication: ISessionAuthenticationService is null");
        k4(r4, r6, false);
        return;
    L22:
        if ((getPageState() instanceof vda.a) == false) goto L24;
    L34:
        r10.i("OrionChatPageStateComponent", "changeToHalfInternal with sending message");
        m3(r4, c4(), r6);
        return;
    L24:
        if (ObricFloatChatPageData.a.c(getPageState()) == true) goto L34;
        if ((getPageState() instanceof vda.c) == false) goto L35;
        ObricFloatChatPageState r13 = getPageState().getPreviousState();
        if (r13 == null) goto L32;
        boolean r14 = true;
        if ((r13 instanceof vda.a) != true) goto L32;
    L33:
        if (r14 == false) goto L35;
    L32:
        r14 = false;
    L18:
        if (ObricFloatChatPageData.a.c(getPageState()) == true) goto L20;
    L39:
        r10.i("OrionChatPageStateComponent", "changeToHalfInternal without sending message");
        m3(r4, r5, r6);
    }
}
