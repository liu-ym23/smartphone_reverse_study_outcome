package com.obric.assistant.window;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.keva.Keva;
import com.larus.audio.call.mgr.AVKitCoreStates;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.taskskill.service.SkillServiceDelegate;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.SessionAuthenticationServiceDelegate;
import com.obric.assistant.ability.PageStateChangedReason;
import com.obric.assistant.banner.IObricBannerService;
import com.obric.assistant.component.viewmodel.PageStateChangeReason;
import com.obric.assistant.component.viewmodel.WindowChatPageStateViewModel;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindow$DefaultImpls;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.OnKeyguardLockStateChangedListener;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.o4;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.window.WindowOpenSource;
import com.obric.assistant.t1;
import com.obric.assistant.util.m2;
import com.obric.assistant.view.ObricIconSwipeUpView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000¤\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010*\u0006£\u0001¦\u0001®\u0001\u0018\u0000 ã\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002ã\u0002B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010°\u0001\u001a\u00030±\u00012\b\u0010²\u0001\u001a\u00030³\u0001H\u0016J\n\u0010´\u0001\u001a\u00030±\u0001H\u0016J\n\u0010µ\u0001\u001a\u00030±\u0001H\u0016J\u0014\u0010¶\u0001\u001a\u00030±\u00012\b\u0010·\u0001\u001a\u00030\u009b\u0001H\u0002J\n\u0010¸\u0001\u001a\u00030±\u0001H\u0016J\n\u0010¹\u0001\u001a\u00030±\u0001H\u0016J\n\u0010º\u0001\u001a\u00030±\u0001H\u0016J\u0014\u0010»\u0001\u001a\u00030±\u00012\b\u0010¼\u0001\u001a\u00030½\u0001H\u0016J\u0014\u0010¾\u0001\u001a\u00030±\u00012\b\u0010¿\u0001\u001a\u00030À\u0001H\u0002J\u0016\u0010Á\u0001\u001a\u00030Â\u00012\n\b\u0002\u0010Ã\u0001\u001a\u00030\u0094\u0001H\u0002J\u0014\u0010Ä\u0001\u001a\u00030±\u00012\b\u0010Å\u0001\u001a\u00030\u009b\u0001H\u0002J\u0014\u0010Æ\u0001\u001a\u00030±\u00012\b\u0010Å\u0001\u001a\u00030\u009b\u0001H\u0002J\u0014\u0010Ç\u0001\u001a\u00030±\u00012\b\u0010Å\u0001\u001a\u00030\u009b\u0001H\u0002J\u0014\u0010È\u0001\u001a\u00030±\u00012\b\u0010¼\u0001\u001a\u00030½\u0001H\u0016J\n\u0010É\u0001\u001a\u00030±\u0001H\u0002J\n\u0010Ê\u0001\u001a\u00030±\u0001H\u0016J\n\u0010Ë\u0001\u001a\u00030±\u0001H\u0016J\n\u0010Ì\u0001\u001a\u00030±\u0001H\u0002J\u0016\u0010Í\u0001\u001a\u00030±\u00012\n\b\u0002\u0010Î\u0001\u001a\u00030\u0094\u0001H\u0002J\n\u0010Ï\u0001\u001a\u00030\u0094\u0001H\u0002J\u0014\u0010Ð\u0001\u001a\u00030\u0094\u00012\b\u0010¿\u0001\u001a\u00030À\u0001H\u0002J\u0014\u0010Ñ\u0001\u001a\u00030\u0094\u00012\b\u0010¿\u0001\u001a\u00030À\u0001H\u0002J\u0014\u0010Ò\u0001\u001a\u00030±\u00012\b\u0010¿\u0001\u001a\u00030À\u0001H\u0002J\n\u0010Ó\u0001\u001a\u00030±\u0001H\u0002J\u0016\u0010Ô\u0001\u001a\u00030±\u00012\n\u0010²\u0001\u001a\u0005\u0018\u00010³\u0001H\u0002J\u0014\u0010Õ\u0001\u001a\u00030±\u00012\b\u0010¿\u0001\u001a\u00030Ö\u0001H\u0002J\n\u0010×\u0001\u001a\u00030±\u0001H\u0002J\n\u0010Ø\u0001\u001a\u00030±\u0001H\u0002J\u0014\u0010Ù\u0001\u001a\u00030±\u00012\b\u0010¿\u0001\u001a\u00030Ú\u0001H\u0002J\u0014\u0010Û\u0001\u001a\u00030±\u00012\b\u0010¿\u0001\u001a\u00030Ú\u0001H\u0002J\u001e\u0010Ü\u0001\u001a\u00030±\u00012\b\u0010¿\u0001\u001a\u00030Ú\u00012\b\u0010Ý\u0001\u001a\u00030\u009b\u0001H\u0002J\u0014\u0010Þ\u0001\u001a\u00030±\u00012\b\u0010¿\u0001\u001a\u00030ß\u0001H\u0002J\n\u0010à\u0001\u001a\u00030±\u0001H\u0002J\n\u0010á\u0001\u001a\u00030±\u0001H\u0002J\u0014\u0010â\u0001\u001a\u00030±\u00012\b\u0010¿\u0001\u001a\u00030ã\u0001H\u0002J\u0014\u0010ä\u0001\u001a\u00030±\u00012\b\u0010å\u0001\u001a\u00030\u0098\u0001H\u0002J\u0014\u0010æ\u0001\u001a\u00030±\u00012\b\u0010¿\u0001\u001a\u00030ç\u0001H\u0002J\u0014\u0010è\u0001\u001a\u00030±\u00012\b\u0010å\u0001\u001a\u00030\u0098\u0001H\u0002J\n\u0010é\u0001\u001a\u00030±\u0001H\u0002J\u0014\u0010ê\u0001\u001a\u00030±\u00012\b\u0010å\u0001\u001a\u00030\u0098\u0001H\u0002J\u0014\u0010ë\u0001\u001a\u00030±\u00012\b\u0010å\u0001\u001a\u00030\u0098\u0001H\u0016J\f\u0010ì\u0001\u001a\u0005\u0018\u00010³\u0001H\u0016J\f\u0010í\u0001\u001a\u0005\u0018\u00010³\u0001H\u0016J\n\u0010î\u0001\u001a\u00030\u0098\u0001H\u0016J\n\u0010ï\u0001\u001a\u00030\u0098\u0001H\u0016J\n\u0010ð\u0001\u001a\u00030\u0098\u0001H\u0016J\n\u0010ñ\u0001\u001a\u00030\u0094\u0001H\u0016J:\u0010ò\u0001\u001a\u00030±\u00012\b\u0010ó\u0001\u001a\u00030\u0094\u00012\n\u0010ô\u0001\u001a\u0005\u0018\u00010\u0094\u00012\b\u0010õ\u0001\u001a\u00030\u0094\u00012\b\u0010ö\u0001\u001a\u00030\u0094\u0001H\u0016¢\u0006\u0003\u0010÷\u0001J\u0014\u0010ø\u0001\u001a\u00030±\u00012\b\u0010å\u0001\u001a\u00030\u0098\u0001H\u0002J\n\u0010ù\u0001\u001a\u00030±\u0001H\u0016J\n\u0010ú\u0001\u001a\u00030±\u0001H\u0016J \u0010û\u0001\u001a\u00030±\u00012\n\u0010ü\u0001\u001a\u0005\u0018\u00010\u009b\u00012\b\u0010ý\u0001\u001a\u00030\u0094\u0001H\u0016J\n\u0010þ\u0001\u001a\u00030±\u0001H\u0016J\f\u0010ÿ\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J\u001e\u0010\u0080\u0002\u001a\u00030±\u00012\b\u0010\u0081\u0002\u001a\u00030\u0082\u00022\b\u0010õ\u0001\u001a\u00030\u0094\u0001H\u0016JN\u0010\u0083\u0002\u001a\u00030±\u00012\b\u0010\u0084\u0002\u001a\u00030\u0094\u00012\b\u0010\u0085\u0002\u001a\u00030\u0098\u00012\n\u0010\u0081\u0002\u001a\u0005\u0018\u00010\u0082\u00022\b\u0010\u0086\u0002\u001a\u00030\u0094\u00012\b\u0010õ\u0001\u001a\u00030\u0094\u00012\b\u0010Ý\u0001\u001a\u00030\u0087\u0002H\u0016¢\u0006\u0003\u0010\u0088\u0002J\u001e\u0010\u0089\u0002\u001a\u00030±\u00012\b\u0010\u0084\u0002\u001a\u00030\u0094\u00012\b\u0010\u0085\u0002\u001a\u00030\u0098\u0001H\u0016J(\u0010\u0089\u0002\u001a\u00030±\u00012\b\u0010\u0084\u0002\u001a\u00030\u0094\u00012\b\u0010\u0085\u0002\u001a\u00030\u0098\u00012\b\u0010õ\u0001\u001a\u00030\u0094\u0001H\u0002J<\u0010\u008a\u0002\u001a\u00030±\u00012\b\u0010\u0084\u0002\u001a\u00030\u0094\u00012\b\u0010\u0085\u0002\u001a\u00030\u0098\u00012\n\u0010\u0081\u0002\u001a\u0005\u0018\u00010\u0082\u00022\n\b\u0002\u0010õ\u0001\u001a\u00030\u0094\u0001H\u0002¢\u0006\u0003\u0010\u008b\u0002J\u0016\u0010\u008c\u0002\u001a\u00030±\u00012\n\b\u0002\u0010õ\u0001\u001a\u00030\u0094\u0001H\u0002J&\u0010\u008d\u0002\u001a\u00030±\u00012\b\u0010\u0084\u0002\u001a\u00030\u0094\u00012\n\u0010\u0081\u0002\u001a\u0005\u0018\u00010\u0082\u0002H\u0002¢\u0006\u0003\u0010\u008e\u0002J0\u0010\u008f\u0002\u001a\u00030±\u00012\b\u0010\u0084\u0002\u001a\u00030\u0094\u00012\n\u0010\u0081\u0002\u001a\u0005\u0018\u00010\u0082\u00022\b\u0010\u0090\u0002\u001a\u00030\u0094\u0001H\u0002¢\u0006\u0003\u0010\u0091\u0002J&\u0010\u0092\u0002\u001a\u00030±\u00012\b\u0010\u0084\u0002\u001a\u00030\u0094\u00012\n\u0010\u0081\u0002\u001a\u0005\u0018\u00010\u0082\u0002H\u0002¢\u0006\u0003\u0010\u008e\u0002J\n\u0010\u0093\u0002\u001a\u00030\u0098\u0001H\u0002J0\u0010\u0094\u0002\u001a\u00030±\u00012\n\u0010\u0081\u0002\u001a\u0005\u0018\u00010\u0082\u00022\b\u0010\u0084\u0002\u001a\u00030\u0094\u00012\b\u0010Ý\u0001\u001a\u00030\u009b\u0001H\u0016¢\u0006\u0003\u0010\u0095\u0002JB\u0010\u0096\u0002\u001a\u00030±\u00012\f\b\u0002\u0010\u0081\u0002\u001a\u0005\u0018\u00010\u0082\u00022\n\b\u0002\u0010\u0084\u0002\u001a\u00030\u0094\u00012\n\b\u0002\u0010Ý\u0001\u001a\u00030\u009b\u00012\n\b\u0002\u0010õ\u0001\u001a\u00030\u0094\u0001H\u0002¢\u0006\u0003\u0010\u0097\u0002J\u000f\u0010\u0098\u0002\u001a\u00030±\u0001*\u00030\u0099\u0002H\u0002J\u000f\u0010\u009a\u0002\u001a\u00030±\u0001*\u00030\u0099\u0002H\u0002J\u0014\u0010\u009b\u0002\u001a\u00030±\u00012\b\u0010Ý\u0001\u001a\u00030\u009b\u0001H\u0002J\u0014\u0010\u009c\u0002\u001a\u00030±\u00012\b\u0010å\u0001\u001a\u00030\u0098\u0001H\u0016J\u0016\u0010\u009d\u0002\u001a\u00030\u0094\u00012\n\b\u0002\u0010¿\u0001\u001a\u00030À\u0001H\u0002J\u001e\u0010\u009e\u0002\u001a\u00030\u0094\u00012\b\u0010å\u0001\u001a\u00030\u0098\u00012\b\u0010\u009f\u0002\u001a\u00030\u0098\u0001H\u0002J\n\u0010 \u0002\u001a\u00030\u0094\u0001H\u0016J\n\u0010¡\u0002\u001a\u00030À\u0001H\u0016J\u0014\u0010¢\u0002\u001a\u00030±\u00012\b\u0010£\u0002\u001a\u00030\u008e\u0001H\u0016J\u0014\u0010¤\u0002\u001a\u00030±\u00012\b\u0010£\u0002\u001a\u00030\u008e\u0001H\u0016J\u0014\u0010¥\u0002\u001a\u00030±\u00012\b\u0010£\u0002\u001a\u00030\u0090\u0001H\u0016J\u0014\u0010¦\u0002\u001a\u00030±\u00012\b\u0010£\u0002\u001a\u00030\u0090\u0001H\u0016J\n\u0010§\u0002\u001a\u00030±\u0001H\u0016J\n\u0010¨\u0002\u001a\u00030±\u0001H\u0016J\"\u0010©\u0002\u001a\u00030±\u00012\n\u0010ª\u0002\u001a\u0005\u0018\u00010\u009b\u00012\n\u0010«\u0002\u001a\u0005\u0018\u00010\u009b\u0001H\u0016J(\u0010¬\u0002\u001a\u00030±\u00012\b\u0010\u00ad\u0002\u001a\u00030\u0094\u00012\b\u0010®\u0002\u001a\u00030\u0094\u00012\b\u0010¯\u0002\u001a\u00030\u009b\u0001H\u0016J\u0014\u0010°\u0002\u001a\u00030±\u00012\b\u0010ö\u0001\u001a\u00030\u0094\u0001H\u0016J\n\u0010±\u0002\u001a\u00030\u0094\u0001H\u0016J\n\u0010²\u0002\u001a\u00030\u0094\u0001H\u0016J\n\u0010³\u0002\u001a\u00030\u0094\u0001H\u0016J\n\u0010´\u0002\u001a\u00030\u0094\u0001H\u0016J\n\u0010µ\u0002\u001a\u00030\u0094\u0001H\u0016J\n\u0010¶\u0002\u001a\u00030\u009b\u0001H\u0016J\u0014\u0010·\u0002\u001a\u00030±\u00012\b\u0010¸\u0002\u001a\u00030\u0094\u0001H\u0016J\u0014\u0010¹\u0002\u001a\u00030±\u00012\b\u0010º\u0002\u001a\u00030\u0094\u0001H\u0016J\u0014\u0010»\u0002\u001a\u00030±\u00012\b\u0010¼\u0002\u001a\u00030\u0094\u0001H\u0016J\u0014\u0010½\u0002\u001a\u00030±\u00012\b\u0010¾\u0002\u001a\u00030\u0094\u0001H\u0016J\u0014\u0010¿\u0002\u001a\u00030±\u00012\b\u0010º\u0002\u001a\u00030\u0094\u0001H\u0016J\u0014\u0010À\u0002\u001a\u00030±\u00012\b\u0010Á\u0002\u001a\u00030Â\u0002H\u0016J\u0014\u0010Ã\u0002\u001a\u00030±\u00012\b\u0010º\u0002\u001a\u00030\u0094\u0001H\u0016J\u0014\u0010Ä\u0002\u001a\u00030±\u00012\b\u0010º\u0002\u001a\u00030\u0094\u0001H\u0016J\u0014\u0010Å\u0002\u001a\u00030±\u00012\b\u0010Æ\u0002\u001a\u00030Ç\u0002H\u0016J\u0014\u0010È\u0002\u001a\u00030±\u00012\b\u0010É\u0002\u001a\u00030\u0094\u0001H\u0016J\u0014\u0010Ê\u0002\u001a\u00030±\u00012\b\u0010Æ\u0002\u001a\u00030\u0098\u0001H\u0016J\u001e\u0010Ë\u0002\u001a\u00030±\u00012\b\u0010º\u0002\u001a\u00030\u0094\u00012\b\u0010Ì\u0002\u001a\u00030\u0094\u0001H\u0016J\u0014\u0010Í\u0002\u001a\u00030±\u00012\b\u0010º\u0002\u001a\u00030\u0094\u0001H\u0016J\u0014\u0010Î\u0002\u001a\u00030±\u00012\b\u0010º\u0002\u001a\u00030\u0094\u0001H\u0016J\n\u0010Ï\u0002\u001a\u00030±\u0001H\u0016J\u001e\u0010Ð\u0002\u001a\u00030±\u00012\b\u0010Ñ\u0002\u001a\u00030\u0098\u00012\b\u0010º\u0002\u001a\u00030\u0094\u0001H\u0002J\u0014\u0010Ò\u0002\u001a\u00030±\u00012\b\u0010Ó\u0002\u001a\u00030Ô\u0002H\u0002J\u0014\u0010Õ\u0002\u001a\u00030±\u00012\b\u0010Ñ\u0002\u001a\u00030\u0098\u0001H\u0002J\u0014\u0010Ö\u0002\u001a\u00030±\u00012\b\u0010å\u0001\u001a\u00030\u0098\u0001H\u0016J\n\u0010×\u0002\u001a\u00030±\u0001H\u0016J\n\u0010Ø\u0002\u001a\u00030\u0094\u0001H\u0016J\n\u0010Ù\u0002\u001a\u00030\u0094\u0001H\u0016J\f\u0010Ú\u0002\u001a\u0005\u0018\u00010³\u0001H\u0016J\u0016\u0010Û\u0002\u001a\u00030\u0094\u00012\n\u0010Ü\u0002\u001a\u0005\u0018\u00010\u009b\u0001H\u0016J\n\u0010Ý\u0002\u001a\u00030±\u0001H\u0016J(\u0010Þ\u0002\u001a\u00030±\u00012\b\u0010ß\u0002\u001a\u00030\u0099\u00022\b\u0010à\u0002\u001a\u00030\u0098\u00012\b\u0010á\u0002\u001a\u00030\u0098\u0001H\u0016J\n\u0010â\u0002\u001a\u00030±\u0001H\u0016R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0013\u001a\u0004\b%\u0010&R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0013\u001a\u0004\b*\u0010+R\u001d\u0010-\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0013\u001a\u0004\b/\u00100R\u001d\u00102\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0013\u001a\u0004\b4\u00105R\u001d\u00107\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0013\u001a\u0004\b8\u00100R\u001d\u0010:\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u0013\u001a\u0004\b;\u0010\u0017R\u001d\u0010=\u001a\u0004\u0018\u00010>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u0013\u001a\u0004\b?\u0010@R\u001d\u0010B\u001a\u0004\u0018\u00010C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u0013\u001a\u0004\bD\u0010ER\u001d\u0010G\u001a\u0004\u0018\u00010H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\u0013\u001a\u0004\bI\u0010JR\u001d\u0010L\u001a\u0004\u0018\u00010M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0013\u001a\u0004\bN\u0010OR\u001d\u0010Q\u001a\u0004\u0018\u00010R8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u0013\u001a\u0004\bS\u0010TR\u001d\u0010V\u001a\u0004\u0018\u00010W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\u0013\u001a\u0004\bX\u0010YR\u001d\u0010[\u001a\u0004\u0018\u00010\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010\u0013\u001a\u0004\b]\u0010^R\u001d\u0010`\u001a\u0004\u0018\u00010a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010\u0013\u001a\u0004\bb\u0010cR\u001d\u0010e\u001a\u0004\u0018\u00010f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010\u0013\u001a\u0004\bg\u0010hR\u001d\u0010j\u001a\u0004\u0018\u00010k8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010\u0013\u001a\u0004\bl\u0010mR\u001d\u0010o\u001a\u0004\u0018\u00010p8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bs\u0010\u0013\u001a\u0004\bq\u0010rR\u001d\u0010t\u001a\u0004\u0018\u00010u8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u0010\u0013\u001a\u0004\bv\u0010wR\u0016\u0010y\u001a\u0004\u0018\u00010z8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b{\u0010|R\u0016\u0010}\u001a\u0004\u0018\u00010p8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b~\u0010rR\u001f\u0010\u007f\u001a\u0004\u0018\u00010u8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010\u0013\u001a\u0005\b\u0080\u0001\u0010wR\"\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0086\u0001\u0010\u0013\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R \u0010\u0087\u0001\u001a\u0004\u0018\u00010u8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0089\u0001\u0010\u0013\u001a\u0005\b\u0088\u0001\u0010wR\u0010\u0010\u008a\u0001\u001a\u00030\u008b\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u008c\u0001\u001a\n\u0012\u0005\u0012\u00030\u008e\u00010\u008d\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u008f\u0001\u001a\n\u0012\u0005\u0012\u00030\u0090\u00010\u008d\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0091\u0001\u001a\u00030\u0092\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0093\u0001\u001a\u00030\u0094\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0095\u0001R\u0018\u0010\u0096\u0001\u001a\u00030\u0094\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0095\u0001R\u0010\u0010\u0097\u0001\u001a\u00030\u0098\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0099\u0001\u001a\u00030\u0094\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u009e\u0001\u001a\u00030\u0094\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009b\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010¢\u0001\u001a\u00030£\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010¤\u0001R\u0013\u0010¥\u0001\u001a\u00030¦\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010§\u0001R \u0010¨\u0001\u001a\u00030\u0098\u0001X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R\u0013\u0010\u00ad\u0001\u001a\u00030®\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010¯\u0001¨\u0006ä\u0002"}, d2 = {"Lcom/obric/assistant/window/ObricPageStateComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/obric/assistant/window/animation/IPageStateAnimationCallback;", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "Lcom/obric/assistant/ability/chat/page/IObricFloatChatPageStateCoreAbility;", "Lcom/obric/assistant/spi/window/WindowLifecycleListener;", "<init>", "()V", "viewModel", "Lcom/obric/assistant/component/viewmodel/WindowChatPageStateViewModel;", "getViewModel", "()Lcom/obric/assistant/component/viewmodel/WindowChatPageStateViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "Lkotlin/Lazy;", "uiAbility", "Lcom/obric/assistant/window/ability/IObricPageUIAbility;", "getUiAbility", "()Lcom/obric/assistant/window/ability/IObricPageUIAbility;", "uiAbility$delegate", "msgAbility", "Lcom/obric/assistant/window/ability/IObricMsgAbility;", "getMsgAbility", "()Lcom/obric/assistant/window/ability/IObricMsgAbility;", "msgAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "photoActionAbility", "Lcom/obric/assistant/ability/IObricPhotoActionAbility;", "getPhotoActionAbility", "()Lcom/obric/assistant/ability/IObricPhotoActionAbility;", "photoActionAbility$delegate", "listAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getListAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "listAbility$delegate", "specialInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "getSpecialInputAbility", "()Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "specialInputAbility$delegate", "chatListComponentAbility", "getChatListComponentAbility", "chatListComponentAbility$delegate", "pageUIAbility", "getPageUIAbility", "pageUIAbility$delegate", "windowExtraViewAbility", "Lcom/obric/assistant/window/ability/IObricWindowExtraViewAbility;", "getWindowExtraViewAbility", "()Lcom/obric/assistant/window/ability/IObricWindowExtraViewAbility;", "windowExtraViewAbility$delegate", "bottomFloatingAbility", "Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "getBottomFloatingAbility", "()Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "bottomFloatingAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "conversationAbility$delegate", "obricActionBarAbility", "Lcom/obric/assistant/ability/IObricActionBarAbility;", "getObricActionBarAbility", "()Lcom/obric/assistant/ability/IObricActionBarAbility;", "obricActionBarAbility$delegate", "actionBarCoreAbility", "Lcom/larus/bmhome/ability/ICustomActionBarCoreAbility;", "getActionBarCoreAbility", "()Lcom/larus/bmhome/ability/ICustomActionBarCoreAbility;", "actionBarCoreAbility$delegate", "obricInstructionAbility", "Lcom/obric/assistant/ability/IObricInstructionExtAbility;", "getObricInstructionAbility", "()Lcom/obric/assistant/ability/IObricInstructionExtAbility;", "obricInstructionAbility$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "chatRoot", "Landroid/view/ViewGroup;", "getChatRoot", "()Landroid/view/ViewGroup;", "chatRoot$delegate", "input", "Landroid/widget/FrameLayout;", "getInput", "()Landroid/widget/FrameLayout;", "input$delegate", "inputUiContract", "Lcom/larus/bmhome/ability/ChatInputUiContract;", "getInputUiContract", "()Lcom/larus/bmhome/ability/ChatInputUiContract;", "actionBarContainer", "getActionBarContainer", "bottomLayout", "getBottomLayout", "bottomLayout$delegate", "messageList", "Landroidx/recyclerview/widget/RecyclerView;", "getMessageList", "()Landroidx/recyclerview/widget/RecyclerView;", "messageList$delegate", "titleContainer", "getTitleContainer", "titleContainer$delegate", "animationHelper", "Lcom/obric/assistant/window/animation/ObricPageStateAnimationHelper;", "chatStyleChangedCallbackList", "", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "dragStateCallbackList", "Lcom/obric/assistant/ability/IDraggingStateCallback;", "keva", "Lcom/bytedance/keva/Keva;", "isScreenLocked", "", "()Z", "isLandscapeMode", "messageListHeight", "", "isFirstOpenSpecialInput", "pendingHideReason", "", "pendingComplexTaskReplyTarget", "Lcom/obric/assistant/ability/PendingComplexTaskReplyTarget;", "hasTriggeredFullThreshold", "boundStartupReadyAttemptId", "voiceNoiseReductionUpgradeDialogJob", "Lkotlinx/coroutines/Job;", "messageListItemBackgroundListener", "com/obric/assistant/window/ObricPageStateComponent$messageListItemBackgroundListener$1", "Lcom/obric/assistant/window/ObricPageStateComponent$messageListItemBackgroundListener$1;", "messageListScrollListener", "com/obric/assistant/window/ObricPageStateComponent$messageListScrollListener$1", "Lcom/obric/assistant/window/ObricPageStateComponent$messageListScrollListener$1;", "contentViewId", "getContentViewId", "()I", "setContentViewId", "(I)V", "keyguardStateListener", "com/obric/assistant/window/ObricPageStateComponent$keyguardStateListener$1", "Lcom/obric/assistant/window/ObricPageStateComponent$keyguardStateListener$1;", "onViewCreated", "", "view", "Landroid/view/View;", "onStart", "onResume", "dealWithAllSearch", "allSearch", "onPause", "onStop", "onDestroy", "onWindowPreOpened", "source", "Lcom/obric/assistant/spi/window/WindowOpenSource;", "restorePageStateOnPop", "pageState", "Lcom/obric/assistant/data/ObricFloatChatPageState;", "preparePageState", "Lcom/obric/assistant/component/viewmodel/PageStateChangeReason;", "beforeWindowShow", "postTryConsumePendingComplexTaskReplyTarget", WindowEvent.Params.TRIGGER, "updatePendingComplexTaskReplyTarget", "tryConsumePendingComplexTaskReplyTarget", "onWindowOpened", "bindWindowStartupReadyIfNeeded", "onWindowPreStashed", "onWindowStashed", "init", "onChatStyleChanged", "chatWindowStyle", "isOrientationChanged", "isLandscapeToPortrait", "isPortraitToLandscape", "onPageStateChange", "initWindowMessageListItemBackground", "updateMessageListItemBackground", "onChangeToChatWindow", "Lcom/obric/assistant/data/ObricFloatChatPageStateChatWindow;", "applyChatWindowImmediately", "openSpecialInputIfNeed", "onChangeToHalf", "Lcom/obric/assistant/data/ObricFloatChatPageStateHalfWindow;", "applyHalfWindowImmediately", "normalizeSettledHalfWindowState", WindowEvent.Params.REASON, "onChangeToLandscapeFullWindow", "Lcom/obric/assistant/data/ObricFloatChatPageStateLandscapeFullWindow;", "applyLandscapeFullWindowImmediately", "applyLandscapeFullWindow", "onChangeToFull", "Lcom/obric/assistant/data/ObricFloatChatPageStateFullScreen;", "onChangeToDismiss", "height", "onChangeToDragging", "Lcom/obric/assistant/data/ObricFloatChatPageStateDragging;", "checkFullThreshold", "onChangeToFullThreshold", "setTopEmptyHeight", "onPageHeightChanged", "getDecorView", "getRootView", "getTopEmptyHeight", "getMaxTopEmptyHeight", "getDismissTranslation", "isWakeUpSpeaking", "changeToDismiss", "dismissWindow", "fromUser", "applyImmediately", "isUseOverlayAnim", "(ZLjava/lang/Boolean;ZZ)V", "saveDismissInfo", "onClickTopEmptyView", "onTouchStatusBarArea", "changePageState", "pageStateStr", "isBeforeWindowShow", "refresh", "getChatMessageList", "changeToChatWindow", "velocity", "", "changeToHalf", "useAnim", "topEmptyHeight", "requestBiometricAuthentication", "Lcom/obric/assistant/ability/PageStateChangedReason;", "(ZILjava/lang/Float;ZZLcom/obric/assistant/ability/PageStateChangedReason;)V", "changeToHalfFromAutoIncrease", "changeToHalfInternal", "(ZILjava/lang/Float;Z)V", "changeToLandscapeFullWindow", "handleBiometricAuthentication", "(ZLjava/lang/Float;)V", "handleAuthenticationFailure", "requestDismissKeyguard", "(ZLjava/lang/Float;Z)V", "restoreStateAfterAuthenticationFailure", "getPanelTopHeightInKeyGuard", "changeToFull", "(Ljava/lang/Float;ZLjava/lang/String;)V", "changeToFullInternal", "(Ljava/lang/Float;ZLjava/lang/String;Z)V", "putWindowInputDraftIfNeeded", "Landroid/os/Bundle;", "putTaskSkillFullScreenTransferIfNeeded", "protectTaskSkillVisibleStateForNextRefresh", "changeToDragging", "shouldDisableWindowDrag", "shouldSettleDraggingToChatWindow", "maxTopEmptyHeight", "isChatWindowOrHalfScreen", "getPageState", "registerChatStyleChangedCallback", "callback", "unregisterChatStyleChangedCallback", "registerDragProgressCallback", "unregisterDragProgressCallback", "onScreenOff", "onScreenUnlocked", "onAsrResultEnd", "asrTaskID", "text", "switchMenuEntranceStatus", "showBottomMenu", "isReset", "from", "finishWithAnimation", "isFullScreen", "isVisible", "isMainBot", "isChatWindow", "isHalfScreen", "getPageStateToString", "cancelMoveTaskToBack", WindowEvent.WindowOpenPerfResult.CANCEL, "onAttachmentPanelVisibleChanged", "visible", "onInstructionVisibleChanged", "instructionOpen", "onMenuEntranceStatusChanged", "showMenu", "onTaskSkillPanelVisibleChanged", "onTouchIntercept", "event", "Landroid/view/MotionEvent;", "onVoiceVisible", "onSpeakerVisible", "onContinuousTalkStateChanged", "state", "Lcom/larus/audio/call/mgr/AVKitDuplexState;", "onPopupOrDialogShow", "show", "onActionBarScrollStateChanged", "onInputReplyPanelVisibleChange", "inVisibleState", "onSecondaryMenuVisibleChange", "onMessageModifyPanelVisibleChange", "clickTalkTimeOut", "onBottomPanelVisibleChanged", "type", "syncAutoDismissBottomPanelStates", "autoDismissDelegate", "Lcom/obric/assistant/util/IAutoDismissDelegate;", "changeToHalfForBottomPanel", "setMessageListHeight", "resetIsFirstOpenSpecialInput", "getDisableFastButton", "getDisableBackToLastViewedButton", "getAnchorView", "onPerformBack", "leaveMethod", "handleMessageListOnTouched", "handleChatSettingResult", "bundle", "requestCode", "resultCode", "onPerformHome", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPageStateComponent extends BaseContentWidget implements yha.e, laa.d, taa.a, wga.b {
    public static final /* synthetic */ int Z = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;
    public final Lazy J;
    public final Lazy K;
    public final Lazy L;
    public final yha.w M;
    public final List<hca.b> N;
    public final List<laa.a> O;
    public final Keva P;
    public boolean Q;
    public laa.w R;
    public boolean S;
    public String T;
    public Job U;
    public final ObricPageStateComponent$messageListItemBackgroundListener$1 V;
    public final ObricPageStateComponent$messageListScrollListener$1 W;
    public int X;
    public final b Y;
    public final com.larus.ui.arch.vm.internal.l m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
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

    public static final class a {
    }

    public static final class b implements OnKeyguardLockStateChangedListener {
        public final /* synthetic */ ObricPageStateComponent a;

        public b(ObricPageStateComponent r1) {
            this.a = r1;
        }

        public final void onKeyguardLockStateChanged(boolean r4) {
            FLogger.a.i("ObricPageStateComponent", "keyguard state: " + r4);
            if (r4 == false) goto L9;
            IAssistantChatWindow r5 = IAssistantChatWindowKt.getAssistantChatWindow();
            if (r5 == null) goto L7;
            IAssistantChatWindow$DefaultImpls.stash$default(r5, null, 1, null);
        L7:
            this.a.onScreenOff();
            return;
        }
    }

    public static final class c implements Function0<xha.c> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(xha.c.class));
        }
    }

    public static final class d implements Function0<xha.e> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(xha.e.class));
        }
    }

    public static final class e implements Function0<ld8.n> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
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

    public static final class f implements Function0<com.larus.bmhome.chat.component.bottom.attachment.g1> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.attachment.g1.class));
        }
    }

    public static final class g implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.g.class));
        }
    }

    public static final class h implements Function0<com.larus.bmhome.chat.component.cvs.y> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
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

    public static final class i implements Function0<laa.b> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.b.class));
        }
    }

    public static final class j implements Function0<va8.c0> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.c0.class));
        }
    }

    public static final class k implements Function0<laa.e> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.e.class));
        }
    }

    public static final class l implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public l(AttachReceiver r1) {
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

    public static final class m implements Function0<xha.c> {
        public final /* synthetic */ AttachReceiver a;

        public m(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(xha.c.class));
        }
    }

    public static final class n implements Function0<xha.b> {
        public final /* synthetic */ AttachReceiver a;

        public n(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(xha.b.class));
        }
    }

    public static final class o implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public o(AttachReceiver r1) {
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

    /* JADX INFO: renamed from: com.obric.assistant.window.ObricPageStateComponent$onResume$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.window.ObricPageStateComponent$onResume$2", f = "ObricPageStateComponent.kt", i = {}, l = {285}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricPageStateComponent this$0;

        public AnonymousClass2(ObricPageStateComponent r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
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

    public static final class p implements Function0<va8.o> {
        public final /* synthetic */ AttachReceiver a;

        public p(AttachReceiver r1) {
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

    public static final class q implements Function0<laa.h> {
        public final /* synthetic */ AttachReceiver a;

        public q(AttachReceiver r1) {
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

    public static final class r implements Function0<u7> {
        public final /* synthetic */ AttachReceiver a;

        public r(AttachReceiver r1) {
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

    public static final class s implements Function0<laa.j> {
        public final /* synthetic */ AttachReceiver a;

        public s(AttachReceiver r1) {
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

    public static final class t implements Function0<u7> {
        public final /* synthetic */ AttachReceiver a;

        public t(AttachReceiver r1) {
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

    public static final class u implements Function0<de8.c> {
        public final /* synthetic */ AttachReceiver a;

        public u(AttachReceiver r1) {
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

    public static final class v implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public v(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class w implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public w(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class x implements Function0<ViewModelProvider.Factory> {
        public static final x a = null;

        static {
            a = new x();
        }

        public x() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    static {
    }

    public final void Ba() {
    }

    public final boolean Da() {
        return true;
    }

    public final void Hd(boolean r1) {
    }

    public final void P5(int r1) {
    }

    public final RecyclerView Xw() {
        return null;
    }

    public final void Y9(Bundle r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "bundle");
    }

    public final View o0() {
        return null;
    }

    public final void onScreenRotationChanged(int r1, int r2) {
    }

    public final void onWindowDismissed() {
    }

    public final void onWindowPreDismissed() {
    }

    public final void onWindowPreOpenClear() {
    }

    public final void refresh() {
    }

    public final void uv() {
        C1(false, true, "onScreenUnlocked");
    }

    public final void xK() {
        Gm(false);
    }

    public final void ze() {
    }

    public final va8.l C3() {
        return (va8.l) this.G.getValue();
    }

    public final FrameLayout D3() {
        return (FrameLayout) this.J.getValue();
    }

    public final va8.o E3() {
        return (va8.o) this.r.getValue();
    }

    public final ViewGroup G3() {
        return (ViewGroup) this.H.getValue();
    }

    public final ICoreInputAbility H3() {
        return (ICoreInputAbility) this.q.getValue();
    }

    public final boolean JY() {
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r1 = getPageState();
        r0.getClass();
        return ObricFloatChatPageData.a.a(r1);
    }

    public final void Nq() {
        laa.h r0 = (laa.h) this.s.getValue();
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.W10() != true) goto L7;
    L8:
        if (r2 == false) goto L13;
        FLogger.a.i("ObricPageStateComponent", "secondary menu open, close secondary menu");
        laa.h r1 = (laa.h) this.s.getValue();
        if (r1 == null) goto L20;
        r1.X30();
        return;
    L20:
        return;
    L13:
        ObricFloatChatPageData.a r3 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r4 = getPageState();
        r3.getClass();
        if ((r4 instanceof vda.a) == false) goto L17;
        Gm(false);
        return;
    L17:
        if ((getPageState() instanceof vda.e) == false) goto L22;
        Gm(false);
        return;
    L22:
        return;
    L7:
        r2 = false;
        goto L8
    }

    public final FrameLayout Q3() {
        return (FrameLayout) this.I.getValue();
    }

    public final RecyclerView V3() {
        return (RecyclerView) this.K.getValue();
    }

    public final xha.b W3() {
        return (xha.b) this.p.getValue();
    }

    public final int X3() {
        IObricChatUIService r0 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.h();
    L6:
        FrameLayout r3 = D3();
        if (r3 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L16;
        FrameLayout r5 = D3();
        if (r5 == null) goto L16;
        int r6 = r5.getHeight();
    L17:
        FrameLayout r7 = Q3();
        if (r7 == null) goto L25;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
    L23:
        if (r9 == null) goto L25;
        int r10 = r9.bottomMargin;
    L26:
        com.larus.utils.i0.a.getClass();
        int r11 = com.larus.utils.i0.e();
        FrameLayout r12 = Q3();
        if (r12 == null) goto L29;
        int r13 = r12.getHeight();
    L30:
        int r14 = r13 + r10;
        FrameLayout r15 = (FrameLayout) this.L.getValue();
        if (r15 == null) goto L34;
        r1 = r15.getHeight();
    L34:
        return RangesKt.coerceIn(((Number) m2.a(((r14 + r1) + r6) + r11, r2).component1()).intValue(), m2.b, m2.a);
    L29:
        r13 = 0;
        goto L30
    L22:
        r9 = null;
    L25:
        r10 = 0;
    L16:
        r6 = 0;
        goto L17
    L9:
        if (r3.getVisibility() != 0) goto L11;
        r4 = true;
        goto L12
    L5:
        r2 = 0;
        goto L6
    }

    public final boolean Xh() {
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r1 = getPageState();
        r0.getClass();
        return r1 instanceof vda.e;
    }

    public final void Y2() {
        IObricBannerService r0 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
        if (r0 == null) goto L5;
        r0.g();
    L5:
        this.P.storeBoolean("is_dismiss_from_half_screen", false);
        this.P.storeBoolean("obric_first_open_in_keyguard_locked", false);
        this.M.b.b();
        v4(0);
        xha.e r1 = (xha.e) this.x.getValue();
        if (r1 == null) goto L10;
        ObricIconSwipeUpView r2 = r1.qR();
        if (r2 == null) goto L10;
        r2.setEnabled(false);
    L10:
        xha.e r3 = (xha.e) this.x.getValue();
        if (r3 == null) goto L13;
        r3.Z20(null);
    L13:
        xha.c r4 = Z3();
        if (r4 == null) goto L16;
        r4.em(1.0f);
    L16:
        ObricInteractDelegate.b.notifyChangeWindowEvent(false);
        i4();
    }

    public final xha.c Z3() {
        return (xha.c) this.o.getValue();
    }

    public final WindowChatPageStateViewModel a4() {
        return (WindowChatPageStateViewModel) this.m.getValue();
    }

    public final boolean aF() {
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r1 = getPageState();
        r0.getClass();
        return r1 instanceof vda.a;
    }

    public final de8.c f1() {
        return (de8.c) this.F.getValue();
    }

    public final void h4() {
        IObricBannerService r0 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
        if (r0 == null) goto L5;
        r0.g();
    L5:
        ICoreInputAbility r1 = H3();
        if (r1 == null) goto L8;
        r1.qp(false);
    L8:
        ObricFloatChatPageState r2 = getPageState();
        if ((r2 instanceof vda.b) == true) goto L11;
    L13:
        WindowAnimationType r3 = WindowAnimationType.Slide;
    L14:
        FLogger.a.w("ObricPageStateComponent", "onChangeToDismiss, lifecycle=" + ((BaseComponentFeatureInternal) this).a.getCurrentState() + ", stateId=" + System.identityHashCode(r2) + ", pageState=" + r2 + ", animation=" + r3);
        IAssistantChatWindow r4 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r4 == null) goto L18;
        r4.stash(r3);
        return;
    L18:
        return;
    L11:
        if (((vda.b) r2).d == false) goto L13;
        r3 = WindowAnimationType.AiKeyOverlayFade;
        goto L14
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
        if (((BaseComponentFeatureInternal) this).a.getCurrentState() != Lifecycle.State.RESUMED) goto L7;
        return true;
    }

    public final int mb() {
        int r0 = com.larus.utils.m0.a;
        int r1 = com.larus.utils.m0.a(getContext());
        if (G3() != null) goto L6;
        FLogger.a.w("ObricPageStateComponent", "getDismissTranslation: chatRoot is null");
        return r1;
    L6:
        va8.l r2 = C3();
        if (r2 == null) goto L28;
        FrameLayout r3 = r2.e();
        if (r3 == null) goto L28;
        FrameLayout r4 = Q3();
        if (r4 != null) goto L15;
        FLogger.a.w("ObricPageStateComponent", "getDismissTranslation: input is null");
        return r1;
    L15:
        FrameLayout r5 = (FrameLayout) this.L.getValue();
        if (r5 != null) goto L20;
        FLogger.a.w("ObricPageStateComponent", "getDismissTranslation:titleContainer is null");
        return r1;
    L20:
        if (r3.getVisibility() != 0) goto L22;
        FLogger.a.i("ObricPageStateComponent", "getDismissTranslation: chatListParent is visible, titleContainer.y = " + r5.getY());
        Number r6 = Float.valueOf(((float) r1) - r5.getY());
    L26:
        FLogger.a.i("ObricPageStateComponent", "getDismissTranslation: screenHeight = " + r1 + ", translationY = " + r6);
        return RangesKt.coerceAtLeast(r6.intValue(), 0);
    L22:
        FLogger.a.i("ObricPageStateComponent", "getDismissTranslation: chatListParent is not visible, input.y = " + r4.getY());
        int r7 = (int) r4.getY();
        if (r7 != 0) goto L25;
        r7 = r1 / 3;
    L25:
        r6 = Integer.valueOf(r1 - r7);
    L28:
        FLogger.a.w("ObricPageStateComponent", "getDismissTranslation: messageListParent is null");
        return r1;
    }

    public final void onDestroy() {
        Job r0 = this.U;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.U = null;
        FLogger.a.i("ObricPageStateComponent", "onDestroy " + hashCode());
        RecyclerView r1 = V3();
        if (r1 == null) goto L8;
        r1.removeOnChildAttachStateChangeListener(this.V);
    L8:
        IAssistantChatWindow r2 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r2 == null) goto L11;
        r2.removeWindowLifecycleListener(this);
    L11:
        IKeyguardStateKt.getKeyguardState().unregisterKeyguardLockStateChangedListener(this.Y);
        RecyclerView r3 = V3();
        if (r3 == null) goto L15;
        r3.removeOnScrollListener(this.W);
        return;
    }

    public final void onPause() {
        FLogger.a.i("ObricPageStateComponent", "onPause " + hashCode());
        xha.b r0 = W3();
        if (r0 == null) goto L8;
        yha.t r1 = r0.u30();
        if (r1 == null) goto L9;
        r1.m();
        return;
    L9:
        return;
    }

    public final void onResume() {
        FLogger r0 = FLogger.a;
        r0.i("ObricPageStateComponent", "onResume " + hashCode());
        xha.b r1 = W3();
        boolean r3 = false;
        if (r1 == null) goto L37;
        yha.t r2 = r1.u30();
        if (r2 == null) goto L37;
        com.larus.bmhome.instruction.g r5 = (com.larus.bmhome.instruction.g) this.A.getValue();
        if (r5 != null) goto L9;
    L11:
        boolean r6 = false;
    L12:
        r2.i(0, r6);
        va8.o r7 = E3();
        if (r7 != null) goto L15;
    L17:
        boolean r8 = false;
    L18:
        r2.i(1, r8);
        com.larus.bmhome.chat.component.bottom.attachment.g1 r9 = (com.larus.bmhome.chat.component.bottom.attachment.g1) this.z.getValue();
        if (r9 != null) goto L21;
    L23:
        boolean r10 = false;
    L24:
        r2.i(2, r10);
        ICoreInputAbility r11 = H3();
        if (r11 != null) goto L27;
    L29:
        boolean r12 = false;
    L30:
        r2.i(3, r12);
        ICoreInputAbility r13 = H3();
        if (r13 != null) goto L33;
    L35:
        boolean r14 = false;
    L36:
        r2.s(r14);
        r2.n();
        goto L37
    L33:
        if (r13.c2() != true) goto L35;
        r14 = true;
        goto L36
    L27:
        if (r11.E50() != true) goto L29;
        r12 = true;
        goto L30
    L21:
        if (r9.isVisible() != true) goto L23;
        r10 = true;
        goto L24
    L15:
        if (r7.w() != true) goto L17;
        r8 = true;
        goto L18
    L9:
        if (r5.z0() != true) goto L11;
        r6 = true;
    L37:
        ObricFloatChatPageState r4 = getPageState();
        ObricFloatChatPageData.Companion.getClass();
        String r15 = null;
        if ((r4 instanceof vda.e) == false) goto L40;
    L41:
        t1 r16 = t1.a;
        if (r16.B() == true) goto L44;
    L52:
        de8.c r17 = f1();
        if (r17 == null) goto L57;
        Bundle r18 = r17.b;
        if (r18 == null) goto L57;
        r15 = r18.getString("all_search");
    L57:
        String r19 = r15;
        if (r19 != null) goto L60;
    L61:
        r3 = true;
    L62:
        if (r3 == true) goto L75;
        r0.i("ObricPageStateComponent", "observer, launch from all search");
        r0.i("ObricPageStateComponent", "dealWithAllSearch");
        ICoreInputAbility r20 = H3();
        if (r20 == null) goto L66;
        r20.g2(1, true);
    L66:
        ICoreInputAbility r21 = H3();
        if (r21 == null) goto L69;
        ICoreInputAbility.b.d(r21, r19, false, false, null, null, false, 62);
    L69:
        de8.c r22 = f1();
        if (r22 == null) goto L75;
        Bundle r23 = r22.b;
        if (r23 == null) goto L75;
        r23.remove("all_search");
    L75:
        if (t1.a.m0() == true) goto L82;
        r0.i("ObricPageStateComponent", "showUserGuide: enter");
        if (cea.b.a() == true) goto L83;
        ViewGroup r24 = G3();
        if (r24 == null) goto L84;
        r24.post(new y(this));
        return;
    L84:
        return;
    L83:
        return;
    L82:
        return;
    L60:
        if (r19.length() != 0) goto L62;
    L44:
        if (r16.V1() == true) goto L50;
        Job r25 = this.U;
        if (r25 == null) goto L48;
        Job.DefaultImpls.cancel$default(r25, null, 1, null);
    L48:
        this.U = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AnonymousClass2(this, null), 3, null);
    L50:
        if (r16.d() == true) goto L52;
        r16.k();
        goto L52
    L40:
        if ((r4 instanceof vda.d) == false) goto L52;
        goto L41
    }

    public final void onStop() {
        Job r0 = this.U;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.U = null;
        ObricFloatChatPageState r1 = ((ObricFloatChatPageData) a4().getState()).getPageState();
        FLogger.a.i("ObricPageStateComponent", "onStop " + hashCode() + ", lifecycle=" + ((BaseComponentFeatureInternal) this).a.getCurrentState() + ", stateId=" + System.identityHashCode(r1) + ", pageState=" + r1);
        ObricFloatChatPageData.a r2 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r3 = getPageState();
        r2.getClass();
        if ((r3 instanceof vda.d) == false) goto L9;
        int r4 = yha.w.c;
        v4(yha.w.a.a(G3(), Q3(), D3(), B3()));
        laa.d.a.b(this, null, true, false, 10);
        h4();
        return;
    }

    public final void tV() {
        FLogger.a.i("ObricPageStateComponent", "resetIsFirstOpenSpecialInput");
        this.Q = true;
    }

    /* JADX WARN: Type inference failed for: r0v58, types: [com.obric.assistant.window.ObricPageStateComponent$messageListItemBackgroundListener$1] */
    /* JADX WARN: Type inference failed for: r0v59, types: [com.obric.assistant.window.ObricPageStateComponent$messageListScrollListener$1] */
    public ObricPageStateComponent() {
        this.m = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(WindowChatPageStateViewModel.class), Reflection.getOrCreateKotlinClass(ObricFloatChatPageData.class), new v(this), new w(this), x.a);
        this.n = LazyKt.lazy(new l(this));
        this.o = LazyKt.lazy(new m(this));
        this.p = LazyKt.lazy(new n(this));
        this.q = LazyKt.lazy(new o(this));
        this.r = LazyKt.lazy(new p(this));
        this.s = LazyKt.lazy(new q(this));
        this.t = LazyKt.lazy(new r(this));
        this.u = LazyKt.lazy(new s(this));
        this.v = LazyKt.lazy(new t(this));
        this.w = LazyKt.lazy(new c(this));
        this.x = LazyKt.lazy(new d(this));
        this.y = LazyKt.lazy(new e(this));
        this.z = LazyKt.lazy(new f(this));
        this.A = LazyKt.lazy(new g(this));
        this.B = LazyKt.lazy(new h(this));
        this.C = LazyKt.lazy(new i(this));
        this.D = LazyKt.lazy(new j(this));
        this.E = LazyKt.lazy(new k(this));
        this.F = LazyKt.lazy(new u(this));
        this.G = LazyKt.lazy(new n0(this));
        this.H = LazyKt.lazy(new o0(this));
        this.I = LazyKt.lazy(new p0(this));
        this.J = LazyKt.lazy(new q0(this));
        this.K = LazyKt.lazy(new r0(this));
        this.L = LazyKt.lazy(new s0(this));
        this.M = new yha.w(this);
        this.N = new ArrayList();
        this.O = new ArrayList();
        this.P = xg9.b.a();
        this.Q = true;
        this.V = new ObricPageStateComponent$messageListItemBackgroundListener$1(this);
        this.W = new ObricPageStateComponent$messageListScrollListener$1(this);
        this.X = 2131365588;
        this.Y = new b(this);
    }

    public final ViewGroup B3() {
        va8.o r0 = E3();
        if (r0 == null) goto L5;
        com.larus.bmhome.chat.component.bottom.core.a r1 = r0.Uv();
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.a();
    L5:
        r1 = null;
        goto L6
    }

    @Override // yha.e
    public final boolean G0() {
        de8.c r0 = f1();
        if (r0 == null) goto L7;
        Bundle r1 = r0.b;
        if (r1 == null) goto L7;
        return r1.getBoolean("arg_wakeup_not_auto_reset");
    L7:
        return false;
    }

    @Override // yha.e
    public final int G1() {
        xha.c r0 = Z3();
        if (r0 == null) goto L7;
        Integer r1 = r0.w40();
        if (r1 == null) goto L7;
        return r1.intValue();
    L7:
        return 0;
    }

    public final void Ht() {
        ICoreInputAbility r0 = H3();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        ICoreInputAbility r2 = H3();
        if (r2 == null) goto L12;
        r2.C1(false, false, "home_gesture_in_window");
    L12:
        ObricFloatChatPageData.a r3 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r4 = getPageState();
        r3.getClass();
        if ((r4 instanceof vda.b) == true) goto L16;
        laa.d.a.b(this, Boolean.TRUE, true, false, 8);
        return;
    L16:
        return;
    L5:
        if (r0.E50() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final boolean YQ() {
        ObricFloatChatPageState r0 = getPageState();
        ObricFloatChatPageData.Companion.getClass();
        if ((r0 instanceof vda.a) == false) goto L5;
        return true;
    L5:
        if ((r0 instanceof vda.b) == false) goto L7;
        return true;
    L7:
        if ((r0 instanceof vda.c) == false) goto L9;
        return true;
    L9:
        if (ObricFloatChatPageData.a.c(r0) == false) goto L11;
        return true;
    L11:
        if (this.M.b.b == null) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == true) goto L29;
        RecyclerView r2 = V3();
        if (r2 != null) goto L18;
    L20:
        boolean r3 = false;
    L21:
        if (r3 == true) goto L30;
        return false;
    L30:
        return true;
    L18:
        if (r2.canScrollVertically(1) == true) goto L20;
        r3 = true;
        goto L21
    L29:
        return true;
    L13:
        r1 = false;
        goto L14
    }

    @Override // yha.e
    public final int a2() {
        if (s1a.a.d(this) == false) goto L5;
        return 0;
    L5:
        int r0 = yha.w.c;
        return yha.w.a.a(G3(), Q3(), D3(), B3());
    }

    public final String bl() {
        return ((ObricFloatChatPageData) a4().getState()).getPageState().toString();
    }

    public final ObricFloatChatPageState getPageState() {
        return ((ObricFloatChatPageData) a4().getState()).getPageState();
    }

    public final void i4() {
        de8.c r0 = f1();
        if (r0 == null) goto L21;
        Bundle r1 = r0.a;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.getBoolean("obric_open_special_input", false) == true) goto L9;
        return;
    L9:
        if (this.Q == false) goto L24;
        this.Q = false;
        FLogger.a.i("ObricPageStateComponent", "open special input panel");
        laa.b r2 = (laa.b) this.C.getValue();
        if (r2 == null) goto L13;
        r2.AP();
    L13:
        laa.j r3 = (laa.j) this.u.getValue();
        if (r3 != null) goto L16;
        return;
    L16:
        if (Build.VERSION.SDK_INT < 33) goto L18;
        StateInfo r4 = (StateInfo) r1.getParcelable("obric_special_input_state_info", StateInfo.class);
    L19:
        laa.j.a.a(r3, false, r4, null, null, true, false, 109);
        return;
    L18:
        r4 = r1.getParcelable("obric_special_input_state_info");
        goto L19
    L24:
        return;
    }

    public final PageStateChangeReason j4() {
        de8.c r0 = f1();
        if (r0 == null) goto L5;
        Bundle r1 = r0.a;
    L6:
        FLogger.a.i("ObricPageStateComponent", "preparePageState, beforeWindowShow = true");
        return a4().initPageState(r1, this, false, true);
    L5:
        r1 = null;
        goto L6
    }

    public final void le() {
        xha.b r0 = W3();
        if (r0 == null) goto L8;
        yha.t r1 = r0.u30();
        if (r1 == null) goto L9;
        r1.c();
        return;
    L9:
        return;
    }

    public final void onScreenOff() {
        ICoreInputAbility r0 = H3();
        if (r0 == null) goto L5;
        r0.p80(true);
    L5:
        ObricFloatChatPageState r1 = getPageState();
        FLogger.a.i("ObricPageStateComponent", "onScreenOff " + r1);
        ViewGroup r2 = G3();
        if (r2 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L15;
        ViewGroup r4 = G3();
        if (r4 == null) goto L15;
        ViewExtKt.g(r4);
    L15:
        ICoreInputAbility r5 = H3();
        if (r5 == null) goto L18;
        r5.C1(false, true, "obric_on_screen_off");
    L18:
        laa.d.a.b(this, null, true, false, 10);
        ObricFloatChatPageData.Companion.getClass();
        if (ObricFloatChatPageData.a.a(r1) == false) goto L21;
        ObricInteractDelegate.b.notifyWakeupEvent(false);
    L21:
        com.obric.assistant.live.api.j.a.r(false);
        return;
    L8:
        if (com.larus.utils.e1.s(r2) != true) goto L10;
        r3 = true;
        goto L11
    }

    public final void onStart() {
        ObricFloatChatPageState r0 = ((ObricFloatChatPageData) a4().getState()).getPageState();
        FLogger.a.i("ObricPageStateComponent", "onStart " + hashCode() + ", lifecycle=" + ((BaseComponentFeatureInternal) this).a.getCurrentState() + ", stateId=" + System.identityHashCode(r0) + ", pageState=" + r0);
        if (sea.e.a.get() == false) goto L5;
    L6:
        laa.d.a.d(this, false, m2.b, null, false, true, PageStateChangedReason.ISLAND_CLICK, 13);
        ViewGroup r1 = G3();
        if (r1 == null) goto L9;
        r1.post(new t0(this));
    L9:
        sea.e.c(false);
        sea.e.d(false);
        return;
    L5:
        if (sea.e.b.get() == true) goto L6;
    }

    public final void onWindowPreStashed() {
        k4("window_pre_stashed");
    }

    public final void onWindowStashed() {
        k4("window_stashed");
        xha.c r0 = (xha.c) this.w.getValue();
        if (r0 == null) goto L5;
        r0.J40(false);
    L5:
        ObricFloatChatPageState r1 = getPageState();
        vda.e r3 = null;
        if ((r1 instanceof vda.c) == false) goto L8;
        vda.c r2 = (vda.c) r1;
    L9:
        if (r2 == null) goto L11;
    L21:
        if (r2 == null) goto L24;
        ObricFloatChatPageState r4 = r2.b;
        if (r4 == null) goto L24;
    L25:
        FLogger r5 = FLogger.a;
        r5.i("ObricPageStateComponent", "onWindowStashed, pageState = " + r1 + ", stateToRestore = " + r4);
        if ((r4 instanceof vda.e) == false) goto L29;
        int r6 = ((vda.e) r4).b;
    L37:
        if (r6 == 0) goto L39;
        long r7 = System.currentTimeMillis();
        r5.i("ObricPageStateComponent", "saveDismissInfo, dismissTime = " + r7);
        this.P.storeLong("last_dismiss_time_from_half_screen", r7);
        this.P.storeLong("last_dismiss_time", r7);
        this.P.storeInt("last_dismiss_height_from_half_screen", r6);
        this.P.storeBoolean("is_dismiss_from_half_screen", true);
    L39:
        ObricFloatChatPageData.Companion.getClass();
        if ((r1 instanceof vda.b) == true) goto L48;
        xha.c r8 = Z3();
        if (r8 == null) goto L46;
        Integer r9 = r8.w40();
        if (r9 == null) goto L46;
        int r10 = r9.intValue();
    L47:
        vda.b r11 = new vda.b(r10, false, false, false);
        r11.setPreviousState(r4);
        r11.setOnlyChangeState(true);
        a4().changePageStatus(r11, true);
    L46:
        r10 = 0;
    L48:
        va8.o r12 = E3();
        if (r12 == null) goto L52;
        r12.c3();
        return;
    L52:
        return;
    L29:
        if ((r4 instanceof vda.b) == false) goto L35;
        ObricFloatChatPageState r13 = r4.getPreviousState();
        if ((r13 instanceof vda.e) == false) goto L33;
        r3 = (vda.e) r13;
    L33:
        if (r3 == null) goto L35;
        r6 = r3.b;
    L35:
        r6 = 0;
    L24:
        r4 = r1;
        goto L25
    L11:
        if ((r1 instanceof vda.e) == false) goto L13;
        vda.e r14 = (vda.e) r1;
    L14:
        if (r14 == null) goto L16;
        ObricFloatChatPageState r15 = r14.getPreviousState();
    L18:
        if ((r15 instanceof vda.c) == false) goto L20;
        r2 = (vda.c) r15;
        goto L21
    L20:
        r2 = null;
        goto L21
    L16:
        r15 = null;
        goto L18
    L13:
        r14 = null;
        goto L14
    L8:
        r2 = null;
        goto L9
    }

    public final int U2() {
        return this.X;
    }

    public final void AN(hca.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        ((ArrayList) this.N).remove(r2);
    }

    @Override // yha.e
    public final void B1(int r1) {
        v4(r1);
    }

    public final void Bn(AVKitDuplexState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        if ((r2.getDownState() instanceof AVKitCoreStates.Speaking) == false) goto L8;
        xha.b r3 = W3();
        if (r3 == null) goto L9;
        r3.F1(null);
        return;
    L9:
        return;
    }

    public final void C00(boolean r1) {
        xha.b r2 = W3();
        if (r2 == null) goto L8;
        yha.t r3 = r2.u30();
        if (r3 == null) goto L9;
        r3.u();
        return;
    L9:
        return;
    }

    public final void F0(boolean r2) {
        e4(2, r2);
    }

    public final void Gm(boolean r5) {
        FLogger.a.i("ObricPageStateComponent", "finishWithAnimation, isUseOverlayAnim = " + r5);
        FrameLayout r0 = Q3();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        FrameLayout r2 = Q3();
        if (r2 == null) goto L12;
        ViewExtKt.g(r2);
    L12:
        ObricFloatChatPageData.a r3 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r4 = getPageState();
        r3.getClass();
        if (ObricFloatChatPageData.a.a(r4) == false) goto L15;
    L16:
        laa.d.a.b(this, null, false, r5, 6);
    L17:
        C1(false, true, "finishWithAnimation");
        return;
    L15:
        if (ObricFloatChatPageData.a.e(getPageState()) == true) goto L17;
    L5:
        if (com.larus.utils.e1.s(r0) != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void H30(laa.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        ((ArrayList) this.O).remove(r2);
    }

    public final void HU(hca.b r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        ((ArrayList) this.N).add(r3);
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r1 = getPageState();
        r0.getClass();
        if (ObricFloatChatPageData.a.d(r1) == false) goto L6;
        r3.r2(getPageState() instanceof vda.a);
        return;
    }

    public final void Ks(boolean r2) {
        xha.b r0 = W3();
        if (r0 == null) goto L8;
        yha.t r1 = r0.u30();
        if (r1 == null) goto L9;
        r1.o(r2);
        return;
    L9:
        return;
    }

    public final void MO(boolean r1) {
        xha.b r2 = W3();
        if (r2 == null) goto L8;
        yha.t r3 = r2.u30();
        if (r3 == null) goto L9;
        r3.r();
        return;
    L9:
        return;
    }

    public final void Mx(laa.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        ((ArrayList) this.O).add(r2);
    }

    public final void U3(boolean r2) {
        xha.b r0 = W3();
        if (r0 == null) goto L8;
        yha.t r1 = r0.u30();
        if (r1 == null) goto L9;
        r1.s(r2);
        return;
    L9:
        return;
    }

    public final void X2(int r1) {
        this.X = r1;
    }

    public final void Yx(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        xha.b r0 = W3();
        if (r0 == null) goto L8;
        yha.t r1 = r0.u30();
        if (r1 == null) goto L9;
        r1.t(r2);
        return;
    L9:
        return;
    }

    public final void a7(boolean r2) {
        xha.b r0 = W3();
        if (r0 == null) goto L8;
        yha.t r1 = r0.u30();
        if (r1 == null) goto L9;
        r1.l(r2);
        return;
    L9:
        return;
    }

    public final void g8(int r2) {
        xha.b r0 = W3();
        if (r0 == null) goto L8;
        yha.t r1 = r0.u30();
        if (r1 == null) goto L9;
        r1.h(r2);
        return;
    L9:
        return;
    }

    public final void h1(boolean r2) {
        e4(3, r2);
    }

    public final void j1(boolean r2) {
        e4(0, r2);
    }

    public final void k4(String r6) {
        com.larus.bmhome.chat.component.cvs.y r0 = (com.larus.bmhome.chat.component.cvs.y) this.B.getValue();
        if (r0 == null) goto L5;
        String r1 = r0.Y1();
    L6:
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        if (StringsKt.isBlank(r1) == false) goto L12;
        FLogger.a.i("ObricPageStateComponent", "protectTaskSkillVisibleStateForNextRefresh skipped, reason=" + r6);
        return;
    L12:
        SkillServiceDelegate.a.p(r1);
        FLogger.a.i("ObricPageStateComponent", "protectTaskSkillVisibleStateForNextRefresh, reason=" + r6 + ", conversationId=" + r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void l4(Bundle r3) {
        com.larus.bmhome.chat.component.cvs.y r0 = (com.larus.bmhome.chat.component.cvs.y) this.B.getValue();
        if (r0 == null) goto L5;
        String r1 = r0.Y1();
    L6:
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        if (StringsKt.isBlank(r1) == false) goto L12;
        FLogger.a.i("ObricPageStateComponent", "putTaskSkillFullScreenTransferIfNeeded skipped, conversationId is blank");
        return;
    L12:
        k4("window_to_full_screen");
        SkillServiceDelegate.a.m(r1);
        r3.putString("task_skill_transfer_from_conversation_id", r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void o2(int r13) {
        ObricFloatChatPageState r0 = getPageState();
        ObricFloatChatPageData.a r1 = ObricFloatChatPageData.Companion;
        r1.getClass();
        boolean r4 = true;
        if ((r0 instanceof vda.f) == false) goto L5;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L20;
        return;
    L20:
        int r3 = yha.w.c;
        int r5 = yha.w.a.a(G3(), Q3(), D3(), B3());
        ObricFloatChatPageState r6 = getPageState();
        r1.getClass();
        if ((r6 instanceof vda.c) == false) goto L31;
        ObricFloatChatPageState r7 = r6.getPreviousState();
        if (r7 != null) goto L25;
    L27:
        boolean r8 = false;
    L28:
        if (r8 == false) goto L31;
        if (r13 < r5) goto L31;
        boolean r9 = true;
    L33:
        if (r9 == false) goto L36;
        FLogger.a.i("ObricPageStateComponent", "changeToDragging settle to chat window, height = " + r13 + ", maxTopEmptyHeight = " + r5);
        laa.d.a.a(this, 0.0f, true, 1);
        return;
    L36:
        xha.c r10 = Z3();
        if (r10 == null) goto L44;
        Integer r11 = r10.w40();
        if (r11 == null) goto L44;
        if (r13 != r11.intValue()) goto L44;
        boolean r12 = true;
    L45:
        if (r12 == false) goto L47;
        return;
    L47:
        if (r13 <= r5) goto L60;
        xha.c r14 = Z3();
        if (r14 == null) goto L56;
        Integer r15 = r14.w40();
        if (r15 == null) goto L56;
        if (r15.intValue() != r5) goto L56;
        boolean r16 = true;
    L57:
        if (r16 == false) goto L59;
        return;
    L59:
        r13 = r5;
    L56:
        r16 = false;
    L60:
        boolean r17 = r0 instanceof vda.a;
        if (r17 == false) goto L73;
        xha.c r18 = Z3();
        if (r18 == null) goto L70;
        Integer r19 = r18.w40();
        if (r19 == null) goto L70;
        if (r19.intValue() != r5) goto L70;
    L71:
        if (r4 == true) goto L73;
        v4(r5);
    L70:
        r4 = false;
    L73:
        boolean r20 = r0 instanceof vda.c;
        if (r20 == false) goto L76;
        vda.c r21 = (vda.c) r0;
    L77:
        if (r21 == null) goto L80;
        ObricFloatChatPageState r22 = r21.b;
        if (r22 == null) goto L80;
    L81:
        if (r20 == true) goto L83;
        FLogger.a.i("ObricPageStateComponent", "changeToDragging start, height = " + r13 + ", stateBeforeDragging = " + r22);
    L83:
        WindowChatPageStateViewModel r23 = a4();
        vda.c r24 = new vda.c(r13, r22);
        if (r20 == false) goto L86;
        r0 = r0.getPreviousState();
    L88:
        r24.setPreviousState(r0);
        WindowChatPageStateViewModel.changePageStatus$default(r23, r24, false, 2, null);
        return;
    L86:
        if (r17 == false) goto L88;
        ((vda.a) r0).b = r5;
    L80:
        r22 = r0;
        goto L81
    L76:
        r21 = null;
    L44:
        r12 = false;
        goto L45
    L25:
        if ((r7 instanceof vda.e) != true) goto L27;
        r8 = true;
    L31:
        r9 = false;
        goto L33
    L5:
        if (s1a.a.e(this) == false) goto L16;
        Resources r25 = getContext().getResources();
        if (r25 == null) goto L13;
        Configuration r26 = r25.getConfiguration();
        if (r26 == null) goto L13;
        if (r26.orientation != 2) goto L13;
        boolean r27 = true;
    L14:
        if (r27 == false) goto L16;
    L13:
        r27 = false;
    L16:
        r2 = false;
        goto L18
    }

    public final void onViewCreated(View r15) {
        Intrinsics.checkNotNullParameter(r15, "view");
        Intrinsics.checkNotNullParameter(r15, "view");
        FLogger r16 = FLogger.a;
        r16.i("ObricPageStateComponent", "onViewCreated " + hashCode());
        ViewGroup r0 = G3();
        if (r0 == null) goto L5;
        r0.setAlpha(0.0f);
    L5:
        xha.c r1 = (xha.c) this.w.getValue();
        if (r1 == null) goto L8;
        r1.init();
    L8:
        xha.e r2 = (xha.e) this.x.getValue();
        if (r2 == null) goto L12;
        r2.init();
    L12:
        if (s1a.a.e(this) == true) goto L14;
        r16.i("ObricPageStateComponent", "initWindowMessageListItemBackground, not window host");
    L22:
        ComponentViewModel.onEach$default(a4(), new u0(), null, new ObricPageStateComponent$init$2(this, null), 2, null);
        FrameLayout r8 = D3();
        if (r8 == null) goto L25;
        ViewExtKt.l(r8, new z(this), null, null, new a0(this), 6);
    L25:
        IAssistantChatWindow r17 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r17 == null) goto L28;
        r17.addWindowLifecycleListener(this);
    L28:
        IKeyguardStateKt.getKeyguardState().registerKeyguardLockStateChangedListener(this.Y);
        RecyclerView r18 = V3();
        if (r18 == null) goto L33;
        r18.addOnScrollListener(this.W);
        return;
    L33:
        return;
    L14:
        RecyclerView r19 = V3();
        if (r19 == null) goto L17;
        r19.addOnChildAttachStateChangeListener(this.V);
    L17:
        RecyclerView r110 = V3();
        if (r110 == null) goto L22;
        int r3 = r110.getChildCount();
        int r4 = 0;
    L20:
        if (r4 >= r3) goto L22;
        r110.getChildAt(r4);
        r4 = r4 + 1;
        goto L20
    }

    public final void onWindowOpened(WindowOpenSource r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        FLogger.a.i("ObricPageStateComponent", "onWindowOpened, source = " + r4);
        k4("window_opened_" + r4);
        va8.c0 r0 = (va8.c0) this.D.getValue();
        if (r0 == null) goto L6;
        r0.KY();
    L6:
        if (r4 != WindowOpenSource.OPEN) goto L40;
        de8.c r5 = f1();
        String r1 = null;
        if (r5 == null) goto L19;
        Bundle r6 = r5.b;
        if (r6 == null) goto L19;
        String r7 = r6.getString("obric_startup_attempt_id");
        if (r7 == null) goto L19;
        if ((!StringsKt.isBlank(r7)) == true) goto L17;
        r7 = null;
    L17:
        if (r7 == null) goto L19;
    L27:
        r1 = r7;
    L28:
        if (r1 != null) goto L31;
        return;
    L31:
        if (Intrinsics.areEqual(AssistantStartupTelemetry.a.i("window_content_ready"), r1) == true) goto L34;
        return;
    L34:
        if (Intrinsics.areEqual(this.T, r1) == true) goto L44;
        int r8 = xga.b.a;
        if (xga.b.a(G3(), r1, "window_content_ready", new b0()) == false) goto L41;
        this.T = r1;
        return;
    L41:
        return;
    L44:
        return;
    L19:
        de8.c r9 = f1();
        if (r9 == null) goto L28;
        Bundle r10 = r9.a;
        if (r10 == null) goto L28;
        r7 = r10.getString("obric_startup_attempt_id");
        if (r7 == null) goto L28;
        if ((!StringsKt.isBlank(r7)) == false) goto L28;
    }

    public final void onWindowPreOpened(WindowOpenSource r12) {
        Intrinsics.checkNotNullParameter(r12, "source");
        Intrinsics.checkNotNullParameter(r12, "source");
        k4("window_pre_opened_" + r12);
        ObricFloatChatPageState r0 = ((ObricFloatChatPageData) a4().getState()).getPageState();
        FLogger r1 = FLogger.a;
        r1.i("ObricPageStateComponent", "onWindowPreOpened begin, source=" + r12 + ", lifecycle=" + ((BaseComponentFeatureInternal) this).a.getCurrentState() + ", stateId=" + System.identityHashCode(r0) + ", pageState=" + r0);
        xha.c r2 = (xha.c) this.w.getValue();
        if (r2 == null) goto L5;
        r2.Bx();
    L5:
        boolean r6 = false;
        if (r12 != WindowOpenSource.OPEN) goto L26;
        com.obric.assistant.task.skill.f.b.set(false);
        PageStateChangeReason r13 = j4();
        com.larus.bmhome.chat.component.bottom.attachment.g1 r3 = (com.larus.bmhome.chat.component.bottom.attachment.g1) this.z.getValue();
        if (r3 != null) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == false) goto L18;
        r1.i("ObricPageStateComponent", "closeInputAboveLayoutUiOnWindowHidden, closeAttachmentPanel");
        com.larus.bmhome.chat.component.bottom.attachment.g1 r5 = (com.larus.bmhome.chat.component.bottom.attachment.g1) this.z.getValue();
        if (r5 == null) goto L18;
        r5.W0();
    L18:
        if (r13 == PageStateChangeReason.PANEL_RESHOW) goto L25;
        u7 r7 = (u7) this.v.getValue();
        if (r7 == null) goto L22;
        r7.TP(true);
    L22:
        xha.c r8 = (xha.c) this.w.getValue();
        if (r8 == null) goto L25;
        r8.Eh();
    L25:
        ObricInteractDelegate.b.setAlreadyShowAuthResult(false);
    L50:
        va8.o r9 = E3();
        if (r9 != null) goto L53;
    L55:
        if (r6 == true) goto L59;
        va8.o r10 = E3();
        if (r10 == null) goto L59;
        r10.ra();
    L59:
        if (r13 == null) goto L62;
        ObricFloatChatPageState r11 = ((ObricFloatChatPageData) a4().getState()).getPageState();
        r1.i("ObricPageStateComponent", "onWindowPreOpened end, reason=" + r13 + ", lifecycle=" + ((BaseComponentFeatureInternal) this).a.getCurrentState() + ", stateId=" + System.identityHashCode(r11) + ", pageState=" + r11);
        return;
    L62:
        return;
    L53:
        if (r9.w() != true) goto L55;
        r6 = true;
        goto L55
    L10:
        if (r3.isVisible() != true) goto L12;
        r4 = true;
        goto L13
    L26:
        ObricFloatChatPageState r14 = getPageState();
        ObricFloatChatPageData.Companion.getClass();
        if (ObricFloatChatPageData.a.c(r14) == false) goto L30;
        laa.d.a.a(this, 0.0f, true, 1);
    L49:
        r13 = null;
        goto L50
    L30:
        if ((r14 instanceof vda.b) == false) goto L49;
        ObricFloatChatPageState r15 = r14.getPreviousState();
        StringBuilder r16 = new StringBuilder("restorePageStateOnPop, currentHeight = ");
        xha.c r17 = Z3();
        if (r17 == null) goto L34;
        Integer r18 = r17.w40();
    L35:
        r16.append(r18);
        r16.append(", pageState = ");
        r16.append(r14);
        r16.append(", resumeState = ");
        r16.append(r15);
        r1.i("ObricPageStateComponent", r16.toString());
        if ((r15 instanceof vda.a) == false) goto L38;
    L41:
        WindowChatPageStateViewModel r19 = a4();
        r15.setPreviousState(r14);
        r15.setOnlyChangeState(true);
        r19.changePageStatus(r15, true);
        if (r15.getHeight() <= 0) goto L44;
        v4(r15.getHeight());
    L44:
        StringBuilder r110 = new StringBuilder("restorePageStateOnPop complete, targetHeight = ");
        r110.append(r15.getHeight());
        r110.append(", currentHeight = ");
        xha.c r20 = Z3();
        if (r20 == null) goto L47;
        Integer r21 = r20.w40();
    L48:
        r110.append(r21);
        r110.append(", resumeState = ");
        r110.append(r15);
        r1.i("ObricPageStateComponent", r110.toString());
        goto L49
    L47:
        r21 = null;
        goto L48
    L38:
        if ((r15 instanceof vda.e) == true) goto L41;
        r1.i("ObricPageStateComponent", "restorePageStateOnPop, invalid resumeState, prepare page state");
        j4();
        goto L49
    L34:
        r18 = null;
        goto L35
    }

    public final void p4(Bundle r3) {
        va8.o r0 = E3();
        if (r0 == null) goto L5;
        String r1 = r0.u7();
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        return;
    L14:
        r3.putString("obric_window_input_draft", r1);
        FLogger.a.i("ObricPageStateComponent", "putWindowInputDraftIfNeeded, hasInputDraft = true");
        return;
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final boolean rD(String r4) {
        FLogger.a.i("ObricPageStateComponent", "onPerformBack return , pageState = " + getPageState());
        laa.e r5 = (laa.e) this.E.getValue();
        if (r5 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == false) goto L10;
        return true;
    L10:
        ObricFloatChatPageData.a r7 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r2 = getPageState();
        r7.getClass();
        if ((r2 instanceof vda.a) == false) goto L15;
        Gm(false);
        return true;
    L15:
        if ((getPageState() instanceof vda.e) == false) goto L19;
        laa.d.a.a(this, 0.0f, false, 2);
        return true;
    L19:
        if ((getPageState() instanceof vda.f) == false) goto L22;
        Gm(false);
        return true;
    L22:
        return false;
    L5:
        if (r5.uc() != true) goto L7;
        r6 = true;
        goto L8
    }

    public final void sN(int r2) {
        m3(r2, false);
    }

    public final void v4(int r3) {
        xha.c r0 = Z3();
        if (r0 == null) goto L6;
        r0.xb(r3, a2());
        return;
    }

    public final void z3(boolean r4) {
        FLogger r0 = FLogger.a;
        r0.i("ObricPageStateComponent", "changeToLandscapeFullWindow, applyImmediately = " + r4);
        if (r4 == false) goto L5;
        r0.i("ObricPageStateComponent", "applyLandscapeFullWindowImmediately");
        Y2();
    L5:
        WindowChatPageStateViewModel r1 = a4();
        vda.f r2 = new vda.f(!r4);
        r2.setPreviousState(getPageState());
        r2.setOnlyChangeState(r4);
        r1.changePageStatus(r2, r4);
    }

    public final void zf(boolean r2) {
        xha.b r0 = W3();
        if (r0 == null) goto L8;
        yha.t r1 = r0.u30();
        if (r1 == null) goto L9;
        r1.p(r2);
        return;
    L9:
        return;
    }

    public static void d4(vda.e r5, String r6) {
        ObricFloatChatPageState r0 = r5.getPreviousState();
        ObricFloatChatPageState r2 = null;
        if ((r0 instanceof vda.c) == false) goto L5;
        vda.c r1 = (vda.c) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        ObricFloatChatPageState r3 = r1.b;
        if (r3 != null) goto L11;
    L13:
        FLogger.a.i("ObricPageStateComponent", "normalizeSettledHalfWindowState, reason=" + r6 + ", oldPreviousState=" + r1 + ", settledPreviousState=" + r2 + ", pageState=" + r5);
        r5.setPreviousState(r2);
        return;
    L11:
        if ((r3 instanceof vda.c) == true) goto L13;
        r2 = r3;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void C0(boolean r2, boolean r3) {
        xha.b r0 = W3();
        if (r0 == null) goto L8;
        yha.t r1 = r0.u30();
        if (r1 == null) goto L9;
        r1.k(r2, r3);
        return;
    L9:
        return;
    }

    public final void D50(String r1, String r2) {
        if (r1 == null) goto L8;
        if (r2 == null) goto L9;
        xha.b r3 = W3();
        if (r3 == null) goto L10;
        r3.F1(null);
        return;
    L10:
        return;
    L9:
        return;
    }

    public final void T8(float r6, boolean r7) {
        FLogger.a.i("ObricPageStateComponent", "changeToChatWindow, velocity = " + r6 + ", resetToChatWindow = " + r7);
        if (r7 == false) goto L8;
        IObricBannerService r0 = (IObricBannerService) ServiceManager.get().getService(IObricBannerService.class);
        if (r0 == null) goto L7;
        r0.g();
    L7:
        this.P.storeBoolean("is_dismiss_from_half_screen", false);
        this.P.storeBoolean("obric_first_open_in_keyguard_locked", false);
        this.M.b.b();
        int r1 = yha.w.c;
        v4(yha.w.a.a(G3(), Q3(), D3(), B3()));
        ObricInteractDelegate.b.notifyChangeWindowEvent(false);
        i4();
    L8:
        WindowChatPageStateViewModel r2 = a4();
        vda.a r3 = new vda.a(r6, 2);
        r3.setPreviousState(getPageState());
        r3.setOnlyChangeState(r7);
        r2.changePageStatus(r3, r7);
    }

    public final void e4(int r12, boolean r13) {
        if (r13 == true) goto L8;
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r1 = getPageState();
        r0.getClass();
        if ((r1 instanceof vda.a) == false) goto L8;
        FrameLayout r2 = Q3();
        if (r2 == null) goto L8;
        r2.post(new c0(this));
    L8:
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("onBottomPanelVisibleChanged, type is ");
        r4.append(r12);
        r4.append(", visible is ");
        r4.append(r13);
        r4.append(", current page is ");
        r4.append(getPageState());
        r4.append(", min top empty height is ");
        int r5 = m2.b;
        r4.append(r5);
        r3.i("ObricPageStateComponent", r4.toString());
        ObricFloatChatPageState r6 = getPageState();
        if (r12 != 1) goto L20;
        ObricFloatChatPageData.Companion.getClass();
        if ((r6 instanceof vda.e) == false) goto L20;
        xha.c r7 = Z3();
        if (r7 == null) goto L17;
        Integer r8 = r7.w40();
        if (r8 == null) goto L17;
        int r9 = r8.intValue();
    L18:
        if (r9 <= r5) goto L20;
        boolean r10 = true;
    L21:
        if (r13 == false) goto L35;
        ObricFloatChatPageData.Companion.getClass();
        if ((r6 instanceof vda.c) == false) goto L25;
    L29:
        xha.b r11 = W3();
        if (r11 == null) goto L32;
        r11.ti();
    L32:
        if (r12 != 1) goto L34;
        m3(r5, true);
        goto L35
    L34:
        laa.d.a.d(this, false, r5, null, false, false, null, 61);
        goto L35
    L25:
        if ((r6 instanceof vda.e) == false) goto L35;
        if (r6.getHeight() > r5) goto L29;
        if (r10 == true) goto L29;
    L35:
        xha.b r14 = W3();
        if (r14 == null) goto L41;
        yha.t r15 = r14.u30();
        if (r15 == null) goto L42;
        r15.i(r12, r13);
        return;
    L42:
        return;
    L41:
        return;
    L17:
        r9 = r6.getHeight();
    L20:
        r10 = false;
        goto L21
    }

    public final void m3(int r8, boolean r9) {
        FLogger r0 = FLogger.a;
        r0.i("ObricPageStateComponent", "changeToHalfFromAutoIncrease, useAnim = true, topEmptyHeight = " + r8);
        ObricFloatChatPageState r1 = getPageState();
        ObricFloatChatPageData.Companion.getClass();
        if ((r1 instanceof vda.e) == true) goto L5;
    L12:
        p3(true, r8, null, r9);
        return;
    L5:
        if (r8 < r1.getHeight()) goto L12;
        int r3 = G1();
        if (r9 == false) goto L10;
        if (r3 <= r8) goto L10;
        r0.i("ObricPageStateComponent", "changeToHalfFromAutoIncrease apply immediately for running height change, currentHeight = " + r1.getHeight() + ", topEmptyHeight = " + r8 + ", currentTopEmptyHeight = " + r3);
    L10:
        r0.i("ObricPageStateComponent", "changeToHalfFromAutoIncrease ignore shrink, currentHeight = " + r1.getHeight() + ", topEmptyHeight = " + r8);
    }

    public final void q4(boolean r11, Float r12) {
        ObricFloatChatPageState r0 = getPageState();
        ObricFloatChatPageState r1 = r0.getPreviousState();
        boolean r2 = a4().isInDeviceLockedAndWithoutSendingMessage();
        boolean r3 = a4().isInDeviceLockedAndWithSendingMessage();
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("restoreStateAfterAuthenticationFailure, currentHeight = ");
        xha.c r6 = Z3();
        Integer r7 = null;
        if (r6 == null) goto L5;
        Integer r8 = r6.w40();
    L6:
        r5.append(r8);
        r5.append(", lockedWithoutSending = ");
        r5.append(r2);
        r5.append(", lockedWithSending = ");
        r5.append(r3);
        r5.append(", pageState = ");
        r5.append(r0);
        r5.append(", stateToRestore = ");
        r5.append(r1);
        r4.i("ObricPageStateComponent", r5.toString());
        ObricFloatChatPageData.Companion.getClass();
        boolean r9 = true;
        if ((r0 instanceof vda.b) == false) goto L16;
        if (r1 != null) goto L10;
    L12:
        boolean r10 = false;
    L13:
        if (r10 == false) goto L16;
        r4.i("ObricPageStateComponent", "restoreStateAfterAuthenticationFailure, wait for pop, stateToRestore = " + r1);
        return;
    L10:
        if (ObricFloatChatPageData.a.a(r1) != true) goto L12;
        r10 = true;
    L16:
        if (r2 == true) goto L18;
        if (r3 == true) goto L27;
        r4.i("ObricPageStateComponent", "restoreStateAfterAuthenticationFailure, no page state change");
        return;
    L27:
        if ((r0 instanceof vda.e) == false) goto L29;
        vda.e r13 = (vda.e) r0;
    L30:
        if (r13 == null) goto L32;
        r7 = Integer.valueOf(r13.b);
    L32:
        if (r7 == null) goto L34;
        int r14 = r7.intValue();
    L35:
        StringBuilder r15 = new StringBuilder("restoreStateAfterAuthenticationFailure, change to half window, topEmptyHeight = ");
        r15.append(r14);
        r15.append(", reuseCurrentHeight = ");
        if (r7 != null) goto L39;
        r9 = false;
    L39:
        r15.append(r9);
        r4.i("ObricPageStateComponent", r15.toString());
        p3(r11, r14, r12, false);
        return;
    L34:
        r14 = X3();
        goto L35
    L29:
        r13 = null;
        goto L30
    L18:
        if ((r0 instanceof vda.a) == true) goto L24;
        r4.i("ObricPageStateComponent", "restoreStateAfterAuthenticationFailure, change to chat window");
        if (r12 == null) goto L22;
        float r16 = r12.floatValue();
    L23:
        laa.d.a.a(this, r16, false, 2);
        return;
    L22:
        r16 = 0.0f;
        goto L23
    L24:
        r4.i("ObricPageStateComponent", "restoreStateAfterAuthenticationFailure, keep chat window");
        return;
    L5:
        r8 = null;
        goto L6
    }

    public final void xw(String r13, boolean r14) {
        FLogger r0 = FLogger.a;
        r0.i("ObricPageStateComponent", "changePageState = " + r13);
        int r1 = m2.b;
        ObricFloatChatPageData.Companion.getClass();
        if (Intrinsics.areEqual(r13, ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp()) == false) goto L11;
        xha.b r3 = W3();
        if (r3 == null) goto L7;
        r3.yg();
    L7:
        int r4 = this.P.getInt("launch_to_half_screen_mode", 0);
        if (r4 != 2) goto L10;
        r1 = this.P.getInt("last_dismiss_height_from_half_screen", 0);
    L10:
        r0.i("ObricPageStateComponent", "changePageState, launchToHalfScreenMode = " + r4 + " halfScreenHeight= " + r1);
    L11:
        int r6 = r1;
        if (Intrinsics.areEqual(r13, ObricFloatChatPageData.access$getCHAT_WINDOW_SIMPLE_NAME$cp()) == false) goto L15;
        laa.d.a.a(this, 0.0f, r14, 1);
    L23:
        Iterator r15 = ((ArrayList) this.N).iterator();
    L25:
        if (r15.hasNext() == false) goto L27;
        hca.b r2 = (hca.b) r15.next();
        ObricFloatChatPageData.Companion.getClass();
        r2.r2(Intrinsics.areEqual(r13, ObricFloatChatPageData.access$getCHAT_WINDOW_SIMPLE_NAME$cp()));
        goto L25
    L27:
        return;
    L15:
        if (Intrinsics.areEqual(r13, ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp()) == false) goto L18;
        laa.d.a.d(this, false, r6, null, false, r14, null, 45);
        goto L23
    L18:
        if (Intrinsics.areEqual(r13, ObricFloatChatPageData.access$getLANDSCAPE_FULL_WINDOW_SIMPLE_NAME$cp()) == false) goto L21;
        z3(r14);
        goto L23
    L21:
        if (Intrinsics.areEqual(r13, ObricFloatChatPageData.access$getFULL_SCREEN_SIMPLE_NAME$cp()) == false) goto L23;
        h3(this, null, false, null, r14, 7);
        goto L23
    }

    public final void C1(boolean r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "from");
        FLogger.a.i("ObricPageStateComponent", "switchMenuEntranceStatus newStatus:false, isReset:" + r4 + ", from:" + r5);
        ICoreInputAbility r6 = H3();
        if (r6 == null) goto L6;
        r6.C1(false, r4, "");
        return;
    }

    public final void T7(Float r8, boolean r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, WindowEvent.Params.REASON);
        h3(this, r8, r9, r10, false, 8);
    }

    public final void c4(final boolean r5, final Float r6, boolean r7) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("handleAuthenticationFailure, requestDismissKeyguard = ");
        r1.append(r7);
        r1.append(", currentHeight = ");
        xha.c r2 = Z3();
        if (r2 == null) goto L5;
        Integer r3 = r2.w40();
    L6:
        r1.append(r3);
        r1.append(", pageState = ");
        r1.append(getPageState());
        r0.i("ObricPageStateComponent", r1.toString());
        if (r7 == false) goto L9;
        com.obric.assistant.spi.keyguard.a.a(new g0(this, r5, r6), new h0(this, r5, r6), null, true, 20);
        return;
    L9:
        com.larus.utils.t0.e(new i0(this, r5, r6));
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void qT(Boolean r5, boolean r6, boolean r7) {
        FLogger.a.i("ObricPageStateComponent", "change to dismiss, dismissWindow: true, fromUser: " + r5 + ", applyImmediately: " + r6 + ", isUseOverlayAnim: " + r7);
        WindowChatPageStateViewModel r0 = a4();
        xha.c r2 = Z3();
        if (r2 == null) goto L7;
        Integer r3 = r2.w40();
        if (r3 == null) goto L7;
        int r4 = r3.intValue();
    L9:
        if (r5 == null) goto L11;
        boolean r8 = r5.booleanValue();
    L12:
        vda.b r1 = new vda.b(r4, true, r8, r7);
        r1.setPreviousState(getPageState());
        r1.setOnlyChangeState(r6);
        r0.changePageStatus(r1, r6);
        return;
    L11:
        r8 = true;
    L7:
        r4 = 0;
        goto L9
    }

    public final void p3(boolean r5, int r6, Float r7, boolean r8) {
        FLogger r0 = FLogger.a;
        r0.i("ObricPageStateComponent", "changeToHalfInternal useAnim = " + r5 + ", topEmptyHeight = " + r6 + ", velocity = " + r7);
        int r9 = Math.max(r6, m2.b);
        if (r8 == false) goto L5;
        r5 = false;
    L5:
        vda.e r1 = new vda.e(r5, r9, r7);
        r1.setPreviousState(getPageState());
        r1.setOnlyChangeState(r8);
        if (r8 == false) goto L8;
        r0.i("ObricPageStateComponent", "applyHalfWindowImmediately, pageState is " + r1);
        this.P.storeBoolean("is_dismiss_from_half_screen", false);
        this.M.b.b();
        v4(r1.b);
        d4(r1, "apply_half_window_immediately");
        ObricInteractDelegate.b.notifyChangeWindowEvent(false);
    L8:
        this.P.storeBoolean("is_dismiss_from_half_screen", false);
        a4().changePageStatus(r1, r8);
        ObricInteractDelegate.b.notifyWakeupEvent(true);
    }

    public static void h3(final ObricPageStateComponent r5, Float r6, boolean r7, final String r8, boolean r9, int r10) {
        if ((r10 & 1) == 0) goto L5;
        r6 = null;
    L5:
        boolean r2 = true;
        if ((r10 & 2) == 0) goto L9;
        r7 = true;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r8 = "";
    L12:
        if ((r10 & 8) == 0) goto L14;
        r9 = false;
    L14:
        r5.getClass();
        FLogger.a.i("ObricPageStateComponent", "changeToFull, isScreenLocked = " + IKeyguardStateKt.getKeyguardState().isKeyguardLocked() + ", reason = " + r8);
        Resources r11 = r5.getContext().getResources();
        if (r11 == null) goto L21;
        Configuration r12 = r11.getConfiguration();
        if (r12 == null) goto L21;
        if (r12.orientation != 2) goto L21;
        boolean r13 = true;
    L22:
        if (r13 == false) goto L29;
        if (r9 == true) goto L27;
        if (r7 == false) goto L27;
        r2 = false;
    L27:
        r5.z3(r2);
        return;
    L29:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L31;
        com.obric.assistant.spi.keyguard.a.a(new e0(r8, r5), new f0(r5), null, false, 20);
        return;
    L31:
        r5.a4().changePageStatus(new vda.d(r7, r6, r8), r9);
        return;
    L21:
        r13 = false;
        goto L22
    }

    public final void i2(boolean r7, int r8, Float r9, boolean r10, boolean r11, PageStateChangedReason r12) {
        Intrinsics.checkNotNullParameter(r12, WindowEvent.Params.REASON);
        FLogger r0 = FLogger.a;
        r0.i("ObricPageStateComponent", "changeToHalf, useAnim = " + r7 + ", topEmptyHeight = " + r8 + ", velocity = " + r9 + ", requestBiometricAuthentication = " + r10 + ", reason = " + r12);
        ObricFloatChatPageData.a r1 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r3 = getPageState();
        r1.getClass();
        if ((r3 instanceof vda.e) == true) goto L5;
    L8:
        gd9.i r2 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r2);
        if (r2.a().e == true) goto L11;
    L16:
        StringBuilder r4 = new StringBuilder("keyguardState.isDeviceLocked() = ");
        r4.append(IKeyguardStateKt.getKeyguardState().isDeviceLocked());
        r4.append(" requestBiometricAuthentication = ");
        r4.append(r10);
        r4.append(" isBiometricPass().value = ");
        SessionAuthenticationServiceDelegate r5 = SessionAuthenticationServiceDelegate.b;
        r4.append(((Boolean) r5.o().getValue()).booleanValue());
        r4.append(" getPageState() = ");
        r4.append(getPageState());
        r4.append(" viewModel.isInDeviceLockedAndWithSendingMessage() = ");
        r4.append(a4().isInDeviceLockedAndWithSendingMessage());
        r4.append("viewModel.isInDeviceLockedAndWithoutSendingMessage() = ");
        r4.append(a4().isInDeviceLockedAndWithoutSendingMessage());
        r4.append("getFinalTopEmptyHeight() = ");
        PageStateChangedReason r6 = PageStateChangedReason.WINDOW_ACTION_VIEW_CLICK;
        if (r12 != r6) goto L19;
        int r13 = r8;
    L20:
        r4.append(r13);
        r0.i("ObricPageStateComponent", r4.toString());
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L53;
        if (r10 == false) goto L26;
        if (((Boolean) r5.o().getValue()).booleanValue() == true) goto L26;
    L30:
        if (a4().isInDeviceLockedAndWithSendingMessage() == true) goto L32;
    L48:
        ISessionAuthenticationService r14 = (ISessionAuthenticationService) ServiceManager.get().getService(ISessionAuthenticationService.class);
        if (r14 == null) goto L51;
        r14.g(new o4(null, null, null, 7), 15000L, new w0(this, r7, r9), false);
        return;
    L51:
        r0.w("ObricPageStateComponent", "requestBiometricAuthentication: ISessionAuthenticationService is null");
        c4(r7, r9, false);
        return;
    L32:
        if ((getPageState() instanceof vda.a) == false) goto L34;
    L44:
        if (r12 == r6) goto L47;
        r8 = X3();
    L47:
        p3(r7, r8, r9, r11);
        return;
    L34:
        if (ObricFloatChatPageData.a.c(getPageState()) == true) goto L44;
        if ((getPageState() instanceof vda.c) == false) goto L48;
        ObricFloatChatPageState r15 = getPageState().getPreviousState();
        if (r15 == null) goto L42;
        boolean r16 = true;
        if ((r15 instanceof vda.a) != true) goto L42;
    L43:
        if (r16 == false) goto L48;
    L42:
        r16 = false;
    L26:
        if (ObricFloatChatPageData.a.c(getPageState()) == false) goto L53;
        if (((Boolean) r5.o().getValue()).booleanValue() == false) goto L30;
    L53:
        if (a4().isInDeviceLockedAndWithoutSendingMessage() == false) goto L65;
        if (ObricFloatChatPageData.a.c(getPageState()) == true) goto L59;
        if ((getPageState() instanceof vda.b) == false) goto L65;
    L59:
        if (((Boolean) r5.o().getValue()).booleanValue() == true) goto L65;
        if (r9 == null) goto L62;
        float r17 = r9.floatValue();
    L63:
        laa.d.a.a(this, r17, false, 2);
        return;
    L62:
        r17 = 0.0f;
    L65:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == true) goto L67;
        p3(r7, r8, r9, r11);
        return;
    L67:
        if (((Boolean) r5.o().getValue()).booleanValue() == true) goto L72;
        if (r12 != r6) goto L70;
        int r18 = r8;
    L71:
        r8 = Math.max(r18, r8);
        goto L72
    L70:
        r18 = X3();
    L72:
        p3(r7, r8, r9, r11);
        return;
    L19:
        r13 = X3();
        goto L20
    L11:
        if (((Boolean) SessionAuthenticationServiceDelegate.b.l().getValue()).booleanValue() == false) goto L16;
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L16;
        r0.i("ObricPageStateComponent", "changeToHalf, app is background, biometric authentication is in progress and device is locked, ignore");
        return;
    L5:
        if (r8 < getPageState().getHeight()) goto L8;
        r0.i("ObricPageStateComponent", "changeToHalf, but change to small, ignore");
    }
}
