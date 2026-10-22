package com.obric.assistant.component.clicktalk;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.asr.VoiceInputType;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.audio.call.InstanceCallState;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.p1;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.DoraConfig;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.i2;
import com.larus.platform.service.i3;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.f0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.t0;
import com.larus.voicecall.obric.ObricRealtimeCallServiceDelegate;
import com.obric.aiagent.assistant.idl.IAgentVoiceInteractionIDL;
import com.obric.assistant.ability.audio.ExitClickSpeakerType;
import com.obric.assistant.audio.sessionstate.AutoHalfDuplexModeServiceDelegate;
import com.obric.assistant.automic.IObricAutoMicService;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.h1;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.reporter.IObricReporter;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.obric.assistant.spi.dora.IDoraWakeupService;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import com.obric.assistant.state.api.multitask.ForegroundInteractionPhase;
import com.obric.assistant.state.api.multitask.ObricInteractionProjectionDelegate;
import com.obric.assistant.state.api.multitask.VoiceCaptureStateProducerDelegate;
import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
import com.obric.assistant.util.g2;
import com.obric.assistant.utils.IObricAssistantUtilHelperService;
import com.obric.assistant.voice.ComplexEvent;
import com.obric.assistant.voice.ContentScene;
import com.obric.assistant.voice.ContentStatus;
import com.obric.assistant.voice.IObricVoiceService;
import com.obric.assistant.voice.OAutoEvent;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraWearState;
import com.obric.audio.continuous_talk.ContinuousTalkStatus;
import com.obric.audio.continuous_talk.c;
import com.obric.audio.continuous_talk.r0;
import com.obric.eventkit.eventstaskmanager.AppEvent;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
import laa.d;
import laa.f;
import org.json.JSONObject;
import qba.a;
import uga.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000ë\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\r\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005*\u0005kæ\u0001ó\u0001\u0018\u0000 ±\u00022\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0006±\u0002²\u0002³\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010z\u001a\u00020{2\u0012\u0010|\u001a\u000e\u0012\u0004\u0012\u00020s\u0012\u0004\u0012\u00020{0}H\u0016J\t\u0010\u008f\u0001\u001a\u00020gH\u0016J\t\u0010\u0090\u0001\u001a\u00020gH\u0016J\t\u0010\u0091\u0001\u001a\u00020gH\u0002J\t\u0010\u0092\u0001\u001a\u00020gH\u0016J\u000b\u0010\u0093\u0001\u001a\u0004\u0018\u00010sH\u0002J\u000b\u0010\u0094\u0001\u001a\u0004\u0018\u00010sH\u0002J&\u0010\u0095\u0001\u001a\u00020{2\u0007\u0010\u0096\u0001\u001a\u00020s2\u0007\u0010\u0097\u0001\u001a\u00020s2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010sH\u0002J$\u0010\u0099\u0001\u001a\u00020{2\u0007\u0010\u009a\u0001\u001a\u00020v2\u0007\u0010\u0096\u0001\u001a\u00020s2\u0007\u0010\u0097\u0001\u001a\u00020sH\u0002J\u0014\u0010\u009b\u0001\u001a\u00020{2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010sH\u0002JS\u0010\u009c\u0001\u001a\u00020{2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010s2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010s2\u000b\b\u0002\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010 \u0001\u001a\u00030¡\u00012\t\u0010¢\u0001\u001a\u0004\u0018\u00010s2\b\u0010£\u0001\u001a\u00030\u0086\u0001H\u0002¢\u0006\u0003\u0010¤\u0001J\t\u0010¥\u0001\u001a\u00020{H\u0003J\u0015\u0010¦\u0001\u001a\u0004\u0018\u00010\u0007*\u00020\u000fH\u0002¢\u0006\u0003\u0010§\u0001J\u0011\u0010¨\u0001\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0003\u0010©\u0001J%\u0010ª\u0001\u001a\u00020g2\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010«\u0001\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0003\u0010¬\u0001J\r\u0010\u00ad\u0001\u001a\u00020g*\u00020\u000fH\u0002J\r\u0010®\u0001\u001a\u00020g*\u00020\u000fH\u0002J\r\u0010¯\u0001\u001a\u00020\u0007*\u00020\u000fH\u0002J\u001b\u0010°\u0001\u001a\u0010\u0012\u0004\u0012\u00020s\u0012\u0005\u0012\u00030\u0081\u00010\u0080\u0001*\u00020\u000fH\u0002J\r\u0010±\u0001\u001a\u00020g*\u00020\u000fH\u0002J<\u0010²\u0001\u001a\u00020{2\u0007\u0010³\u0001\u001a\u00020\u00072\u0017\u0010´\u0001\u001a\u0012\u0012\u0004\u0012\u00020s\u0012\u0005\u0012\u00030\u0081\u0001\u0018\u00010\u0080\u00012\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0007H\u0017¢\u0006\u0003\u0010µ\u0001JQ\u0010²\u0001\u001a\u00020{2\u0007\u0010³\u0001\u001a\u00020\u00072\u0017\u0010´\u0001\u001a\u0012\u0012\u0004\u0012\u00020s\u0012\u0005\u0012\u00030\u0081\u0001\u0018\u00010\u0080\u00012\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00072\t\u0010¢\u0001\u001a\u0004\u0018\u00010s2\b\u0010£\u0001\u001a\u00030\u0086\u0001H\u0003¢\u0006\u0003\u0010¶\u0001J\u001a\u0010·\u0001\u001a\u00020{2\u0006\u0010\b\u001a\u00020\t2\u0007\u0010¸\u0001\u001a\u00020sH\u0002J\u0011\u0010¹\u0001\u001a\u00020{2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010º\u0001\u001a\u00020{2\u0007\u0010»\u0001\u001a\u00020sH\u0002J3\u0010¼\u0001\u001a\u00020{2\u0006\u0010\b\u001a\u00020\t2\u0017\u0010´\u0001\u001a\u0012\u0012\u0004\u0012\u00020s\u0012\u0005\u0012\u00030\u0081\u0001\u0018\u00010\u0080\u00012\u0007\u0010½\u0001\u001a\u00020gH\u0016J\u001d\u0010À\u0001\u001a\u00020{2\u0007\u0010Á\u0001\u001a\u00020g2\t\u0010Â\u0001\u001a\u0004\u0018\u00010sH\u0002J(\u0010Ã\u0001\u001a\u00020{2\t\u0010Ä\u0001\u001a\u0004\u0018\u00010s2\u0007\u0010Å\u0001\u001a\u00020s2\t\b\u0002\u0010Æ\u0001\u001a\u00020gH\u0002JS\u0010Ç\u0001\u001a\u00020{2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010s2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010s2\u000b\b\u0002\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010 \u0001\u001a\u00030¡\u00012\t\u0010¢\u0001\u001a\u0004\u0018\u00010s2\b\u0010£\u0001\u001a\u00030\u0086\u0001H\u0002¢\u0006\u0003\u0010¤\u0001J\t\u0010È\u0001\u001a\u00020gH\u0002J\t\u0010É\u0001\u001a\u00020{H\u0003J\u0014\u0010Ê\u0001\u001a\u00020{2\t\u0010Ë\u0001\u001a\u0004\u0018\u00010\u000bH\u0016J/\u0010Ì\u0001\u001a\u00020{2\u0007\u0010Í\u0001\u001a\u00020g2\u0007\u0010Î\u0001\u001a\u00020s2\u0012\u0010|\u001a\u000e\u0012\u0004\u0012\u00020s\u0012\u0004\u0012\u00020{0}H\u0016J\u0013\u0010Ï\u0001\u001a\u00020{2\b\u0010Ð\u0001\u001a\u00030Ñ\u0001H\u0016J\u0013\u0010Ò\u0001\u001a\u00020{2\b\u0010Ó\u0001\u001a\u00030Ô\u0001H\u0016J\t\u0010Õ\u0001\u001a\u00020gH\u0016J\t\u0010Ö\u0001\u001a\u00020gH\u0016J\t\u0010×\u0001\u001a\u00020gH\u0016J\u0013\u0010Ø\u0001\u001a\u0005\u0018\u00010Ù\u0001H\u0082@¢\u0006\u0003\u0010Ú\u0001J\u0013\u0010Û\u0001\u001a\u0005\u0018\u00010Ü\u0001H\u0082@¢\u0006\u0003\u0010Ú\u0001JB\u0010Ý\u0001\u001a\u0005\u0018\u0001HÞ\u0001\"\u0005\b\u0000\u0010Þ\u00012\n\b\u0002\u0010ß\u0001\u001a\u00030\u008d\u00012\u001a\u0010|\u001a\u0016\u0012\f\u0012\n\u0012\u0005\u0012\u0003HÞ\u00010à\u0001\u0012\u0004\u0012\u00020{0}H\u0082@¢\u0006\u0003\u0010á\u0001J\t\u0010â\u0001\u001a\u00020{H\u0002J\t\u0010ã\u0001\u001a\u00020{H\u0002J\t\u0010ä\u0001\u001a\u00020gH\u0002J\t\u0010è\u0001\u001a\u00020{H\u0016J\t\u0010é\u0001\u001a\u00020{H\u0016J\t\u0010ê\u0001\u001a\u00020{H\u0016J\t\u0010ë\u0001\u001a\u00020{H\u0016J\t\u0010ì\u0001\u001a\u00020{H\u0016J\t\u0010í\u0001\u001a\u00020gH\u0002J\t\u0010î\u0001\u001a\u00020{H\u0002J\t\u0010ï\u0001\u001a\u00020{H\u0002JS\u0010ð\u0001\u001a\u00020{2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010s2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010s2\u000b\b\u0002\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010 \u0001\u001a\u00030¡\u00012\t\u0010¢\u0001\u001a\u0004\u0018\u00010s2\b\u0010£\u0001\u001a\u00030\u0086\u0001H\u0002¢\u0006\u0003\u0010¤\u0001JS\u0010ñ\u0001\u001a\u00020{2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010s2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010s2\u000b\b\u0002\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010 \u0001\u001a\u00030¡\u00012\t\u0010¢\u0001\u001a\u0004\u0018\u00010s2\b\u0010£\u0001\u001a\u00030\u0086\u0001H\u0002¢\u0006\u0003\u0010¤\u0001J\u001e\u0010õ\u0001\u001a\u00020{2\u0013\u0010ö\u0001\u001a\u000e\u0012\u0004\u0012\u00020s\u0012\u0004\u0012\u00020{0}H\u0002J\u0012\u0010÷\u0001\u001a\u0004\u0018\u00010sH\u0082@¢\u0006\u0003\u0010Ú\u0001JS\u0010ø\u0001\u001a\u00020{2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010s2\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010s2\u000b\b\u0002\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010 \u0001\u001a\u00030¡\u00012\t\u0010¢\u0001\u001a\u0004\u0018\u00010s2\b\u0010£\u0001\u001a\u00030\u0086\u0001H\u0002¢\u0006\u0003\u0010¤\u0001J0\u0010ù\u0001\u001a\u00020{2\b\u0010£\u0001\u001a\u00030\u0086\u00012\u0007\u0010ú\u0001\u001a\u00020s2\u0007\u0010û\u0001\u001a\u00020s2\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010vH\u0002J\u001e\u0010ü\u0001\u001a\u00020{2\t\u0010¢\u0001\u001a\u0004\u0018\u00010s2\b\u0010£\u0001\u001a\u00030\u0086\u0001H\u0002J\u0013\u0010ý\u0001\u001a\u00020g2\b\u0010£\u0001\u001a\u00030\u0086\u0001H\u0002J\u0013\u0010þ\u0001\u001a\u00020{2\b\u0010£\u0001\u001a\u00030\u0086\u0001H\u0002J\u001e\u0010ÿ\u0001\u001a\u00020{2\u0007\u0010Î\u0001\u001a\u00020s2\n\u0010£\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0002J\u0013\u0010\u0080\u0002\u001a\u00020{2\b\u0010\u0081\u0002\u001a\u00030\u008d\u0001H\u0002J\u0013\u0010\u0082\u0002\u001a\u00020{2\b\u0010£\u0001\u001a\u00030\u0086\u0001H\u0002J\t\u0010\u0083\u0002\u001a\u00020{H\u0002J\t\u0010\u0084\u0002\u001a\u00020{H\u0016J\u0013\u0010\u0085\u0002\u001a\u00020{2\b\u0010\u0086\u0002\u001a\u00030\u0087\u0002H\u0016J\t\u0010\u0088\u0002\u001a\u00020{H\u0002J\u0012\u0010\u0089\u0002\u001a\u00020{2\u0007\u0010\u008a\u0002\u001a\u00020\rH\u0002J\u0012\u0010\u008b\u0002\u001a\u00020{2\u0007\u0010\u008c\u0002\u001a\u00020gH\u0002J\u0014\u0010\u008d\u0002\u001a\u00020{2\t\u0010\u008e\u0002\u001a\u0004\u0018\u00010sH\u0016J\u0012\u0010\u008f\u0002\u001a\u00020{2\u0007\u0010¸\u0001\u001a\u00020sH\u0016J\t\u0010\u0090\u0002\u001a\u00020sH\u0002J\t\u0010\u0091\u0002\u001a\u00020{H\u0016J>\u0010\u0092\u0002\u001a\u00020{2\t\u0010\u0093\u0002\u001a\u0004\u0018\u00010s2\t\u0010\u0094\u0002\u001a\u0004\u0018\u00010s2\t\u0010\u0095\u0002\u001a\u0004\u0018\u00010s2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010s2\u0007\u0010\u0096\u0002\u001a\u00020\u0007H\u0016J\u0013\u0010\u0097\u0002\u001a\u00020{2\b\u0010\u0098\u0002\u001a\u00030\u0099\u0002H\u0016J\u0012\u0010\u009a\u0002\u001a\u00020{2\u0007\u0010\u009b\u0002\u001a\u00020\u0007H\u0002J\u001f\u0010\u009c\u0002\u001a\u00020{2\t\u0010\u009d\u0002\u001a\u0004\u0018\u00010s2\t\u0010\u009e\u0002\u001a\u0004\u0018\u00010sH\u0002J\t\u0010\u009f\u0002\u001a\u00020{H\u0002J\u001f\u0010 \u0002\u001a\u00020{2\t\u0010\u009d\u0002\u001a\u0004\u0018\u00010s2\t\u0010\u009e\u0002\u001a\u0004\u0018\u00010sH\u0002J\u001f\u0010¡\u0002\u001a\u00020{2\t\u0010\u009d\u0002\u001a\u0004\u0018\u00010s2\t\u0010\u009e\u0002\u001a\u0004\u0018\u00010sH\u0002J\t\u0010¢\u0002\u001a\u00020{H\u0002J\u001b\u0010£\u0002\u001a\u00020{2\u0007\u0010¤\u0002\u001a\u00020s2\u0007\u0010¥\u0002\u001a\u00020sH\u0002J:\u0010§\u0002\u001a\u0004\u0018\u00010s2\u0007\u0010Î\u0001\u001a\u00020s2\t\u0010¨\u0002\u001a\u0004\u0018\u00010s2\u0007\u0010©\u0002\u001a\u00020g2\u0007\u0010ª\u0002\u001a\u00020s2\u0007\u0010«\u0002\u001a\u00020sH\u0016JH\u0010¬\u0002\u001a\u00030\u00ad\u00022\u0007\u0010Î\u0001\u001a\u00020s2\t\u0010®\u0002\u001a\u0004\u0018\u00010s2\u0018\u0010¨\u0002\u001a\u0013\u0012\u0004\u0012\u00020s\u0012\u0006\u0012\u0004\u0018\u00010s\u0018\u00010¯\u00022\u0007\u0010©\u0002\u001a\u00020gH\u0096@¢\u0006\u0003\u0010°\u0002J\t\u0010¯\u0001\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0013\u001a\u0004\b%\u0010&R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0013\u001a\u0004\b*\u0010+R\u001d\u0010-\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0013\u001a\u0004\b/\u00100R\u001d\u00102\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0013\u001a\u0004\b4\u00105R\u001d\u00107\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0013\u001a\u0004\b9\u0010:R\u001d\u0010<\u001a\u0004\u0018\u00010=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0013\u001a\u0004\b>\u0010?R\u001d\u0010A\u001a\u0004\u0018\u00010B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0013\u001a\u0004\bC\u0010DR\u0016\u0010F\u001a\u0004\u0018\u00010B8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010DR\u001d\u0010H\u001a\u0004\u0018\u00010I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u0013\u001a\u0004\bJ\u0010KR\u001d\u0010M\u001a\u0004\u0018\u00010N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\u0013\u001a\u0004\bO\u0010PR\u001d\u0010R\u001a\u0004\u0018\u00010S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u0013\u001a\u0004\bT\u0010UR\u001d\u0010W\u001a\u0004\u0018\u00010X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\u0013\u001a\u0004\bY\u0010ZR\u001d\u0010\\\u001a\u0004\u0018\u00010]8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\u0013\u001a\u0004\b^\u0010_R\u001d\u0010a\u001a\u0004\u0018\u00010b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010\u0013\u001a\u0004\bc\u0010dR\u001b\u0010f\u001a\u00020g8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bi\u0010\u0013\u001a\u0004\bf\u0010hR\u001b\u0010j\u001a\u00020k8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010\u0013\u001a\u0004\bl\u0010mR\u000e\u0010o\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010r\u001a\u0004\u0018\u00010sX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010t\u001a\u0004\u0018\u00010sX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010u\u001a\u0004\u0018\u00010vX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u0004\u0018\u00010sX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010x\u001a\u000e\u0012\u0004\u0012\u00020s\u0012\u0004\u0012\u00020v0yX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u007f\u001a\u0012\u0012\u0004\u0012\u00020s\u0012\u0005\u0012\u00030\u0081\u0001\u0018\u00010\u0080\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0085\u0001\u001a\u000f\u0012\u0004\u0012\u00020s\u0012\u0005\u0012\u00030\u0086\u00010yX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010sX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0086\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0089\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0083\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001X\u0082\u000e¢\u0006\u0005\n\u0003\u0010\u008e\u0001R\u0010\u0010¾\u0001\u001a\u00030\u008d\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¿\u0001\u001a\u00020gX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010å\u0001\u001a\u00030æ\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010ç\u0001R\u0013\u0010ò\u0001\u001a\u00030ó\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010ô\u0001R\u000f\u0010¦\u0002\u001a\u00020gX\u0082D¢\u0006\u0002\n\u0000¨\u0006´\u0002"}, d2 = {"Lcom/obric/assistant/component/clicktalk/ChatClickTalkComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "<init>", "()V", "WAKEUP_FROM_AUTO_MIC", "", "exitClickSpeakerType", "Lcom/obric/assistant/ability/audio/ExitClickSpeakerType;", "curMsg", "Lcom/larus/im/bean/message/Message;", "lastDoraGWearState", "Lcom/obric/assistant/wakeup/co_wakeup/dora/model/DoraWearState;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "chatBottomAbility", "Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "getChatBottomAbility", "()Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "chatBottomAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "chatListAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListAbility$delegate", "instructionAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionAbility$delegate", "attachmentAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentAbility$delegate", "chatWindowAbility", "Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "getChatWindowAbility", "()Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "chatWindowAbility$delegate", "chatBottomSpeakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getChatBottomSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "chatBottomSpeakerAbility$delegate", "cachedClickTalkSessionFacade", "Lcom/obric/assistant/ability/audio/IClickTalkSamiAsrSessionAbility;", "getCachedClickTalkSessionFacade", "()Lcom/obric/assistant/ability/audio/IClickTalkSamiAsrSessionAbility;", "cachedClickTalkSessionFacade$delegate", "clickTalkSessionFacade", "getClickTalkSessionFacade", "touchSpeakerEventAbility", "Lcom/obric/assistant/ability/audio/ITouchSpeakEventAbility;", "getTouchSpeakerEventAbility", "()Lcom/obric/assistant/ability/audio/ITouchSpeakEventAbility;", "touchSpeakerEventAbility$delegate", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "intercomAbility", "Lcom/obric/assistant/ability/IObricIntercomAbility;", "getIntercomAbility", "()Lcom/obric/assistant/ability/IObricIntercomAbility;", "intercomAbility$delegate", "continuousTalkAbility", "Lcom/obric/audio/continuous_talk/IObricContinuousTalkAbility;", "getContinuousTalkAbility", "()Lcom/obric/audio/continuous_talk/IObricContinuousTalkAbility;", "continuousTalkAbility$delegate", "continuousTalkCtrlAbility", "Lcom/obric/audio/continuous_talk/IObricContinuousTalkCtrlAbility;", "getContinuousTalkCtrlAbility", "()Lcom/obric/audio/continuous_talk/IObricContinuousTalkCtrlAbility;", "continuousTalkCtrlAbility$delegate", "obricStateExtension", "Lcom/obric/assistant/callback/IObricStateExtensionCallback;", "getObricStateExtension", "()Lcom/obric/assistant/callback/IObricStateExtensionCallback;", "obricStateExtension$delegate", "isDebug", "", "()Z", "isDebug$delegate", "thinkingTimeoutTimer", "com/obric/assistant/component/clicktalk/ChatClickTalkComponent$thinkingTimeoutTimer$2$1", "getThinkingTimeoutTimer", "()Lcom/obric/assistant/component/clicktalk/ChatClickTalkComponent$thinkingTimeoutTimer$2$1;", "thinkingTimeoutTimer$delegate", "messageListClipToPadding", "isDoraWakeup", "hasReceivedAsrText", "curCallId", "", "curTaskId", "startupAudioSession", "Lcom/obric/assistant/spi/startup/AssistantStartupAudioSession;", "pendingStartupAttemptId", "startupSessionByTaskId", "Ljava/util/concurrent/ConcurrentHashMap;", "getBotId", "", "callback", "Lkotlin/Function1;", "wakeupFrom", "wakeupArgs", "", "", "idleServiceRunnable", "Ljava/lang/Runnable;", "hasDispatchedClickTalkStart", "listeningUiBindingsByTaskId", "Lcom/obric/assistant/component/clicktalk/ChatClickTalkComponent$ClickTalkRequest;", "currentSpeakerTaskId", "currentClickTalkRequest", "clickTalkRequestGeneration", "Ljava/util/concurrent/atomic/AtomicLong;", "pendingWakeupPauseCloseRunnable", "pendingWakeupPauseCloseRequestId", "", "Ljava/lang/Long;", "isClickTalking", "isClickTalkClosing", "hasActiveClickTalkStart", "isClickTalkRealActive", "startupAttemptFromArguments", "captureStartupAttempt", "finishStartupAttempt", "result", "reason", "attemptId", "finishStartupAudioSession", "startupSession", "replacePendingStartupAttempt", "openClickTalk", "enterMethod", "callID", "vuiId", "voiceInputType", "Lcom/larus/asr/VoiceInputType;", "startupAttemptId", "request", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/asr/VoiceInputType;Ljava/lang/String;Lcom/obric/assistant/component/clicktalk/ChatClickTalkComponent$ClickTalkRequest;)V", "tryStartClickTalk", "getVuiId", "(Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;)Ljava/lang/Integer;", "getCurrentVoiceWakeupId", "()Ljava/lang/Integer;", "isDoraVuiWakeup", "wakeupId", "(Ljava/lang/Integer;Ljava/lang/Integer;)Z", "isWakeUp", "isAutoMic", "getWakeupFrom", "getAutoMicData", "isLongPressAi", "tryOpenClickTalk", EffectConfiguration.KEY_TYPE, "args", "(ILjava/util/Map;Ljava/lang/Integer;)V", "(ILjava/util/Map;Ljava/lang/Integer;Ljava/lang/String;Lcom/obric/assistant/component/clicktalk/ChatClickTalkComponent$ClickTalkRequest;)V", "clearLaunchMethodParamTask", "tag", "scheduleClickTalkClosingGuard", "hideVoiceViewIfNeeded", "source", "closeClickTalk", "endDoraSession", "startTimeStamp", "traceStarted", "traceClickTalkStart", "success", "failType", "traceClickTalkEnd", "messageId", "endType", "requireActiveSession", "prepareAndOpenContinuousTalk", "canLaunchAssistant", "playEndSound", "startNextRound", "msg", "setSpeakerVisible", "visible", DBDefinition.TASK_ID, "setAudioData", "data", "", "setAudioVolume", "volume", "", "interceptSpeak", "interruptClickTalk", "finishAsrSession", "observeBotModel", "Lcom/larus/im/bean/bot/BotModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeConversation", "Lcom/larus/im/bean/conversation/Conversation;", "suspendCoroutine", "T", "timeMillis", "Lkotlinx/coroutines/CancellableContinuation;", "(JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverInputArea", "recoverChatPage", "hasAttachment", "startupAsrLifeStateListener", "com/obric/assistant/component/clicktalk/ChatClickTalkComponent$startupAsrLifeStateListener$1", "Lcom/obric/assistant/component/clicktalk/ChatClickTalkComponent$startupAsrLifeStateListener$1;", "onAttach", "onParentViewCreated", "onResume", "onPause", "onStop", "shouldDeferPendingWakeupClose", "schedulePendingWakeupPauseClose", "cancelPendingWakeupPauseClose", "checkAudioPermission", "onPermissionGranted", "idleObserver", "com/obric/assistant/component/clicktalk/ChatClickTalkComponent$idleObserver$1", "Lcom/obric/assistant/component/clicktalk/ChatClickTalkComponent$idleObserver$1;", "handleBotOperations", "onBotAvailable", "fetchBotIfNeeded", "realStart", "onFinishCall", "businessTaskId", "endMethod", "onPermissionDenied", "dropStaleClickTalkRequest", "stopListeningUiLoading", "bindSpeakerTaskToClickTalkRequest", "removeClickTalkRequestTaskAliases", "requestId", "finishClickTalkRequestHandle", "finishPendingListeningUiHandles", "onDestroy", "onViewCreated", "view", "Landroid/view/View;", "observeDoraGWearState", "handleDoraGWearStateChanged", "wearState", "operateDoraVUI", "enable", "updateScreenshotForAsr", "tosKey", "resetLaunchMethodParams", "getMainBotId", "finishChatPage", "mobClickTalkEnter", "botId", "conversationId", "callId", "cost", "onClickTalkEvent", "event", "Lcom/obric/assistant/ability/audio/ClickTalkEvent;", "handleTalkStateChanged", "talkState", "handleAsrResultEnd", "asrTaskID", "text", "handleAsrEnd", "handleAsrUpdate", "handleQueryBegin", "handleQueryEnd", "updateCurMsg", "key", "value", "enableSpeakerIdentify", "updateAsrExtraForAutoMic", DBDefinition.EXTRA, "enablePvadCheck", "userId", "deviceUuid", "handleAutoMicAsrResult", "Lcom/obric/assistant/ability/audio/AutoMicHandleResult;", "asrText", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ClickTalkRequest", "SvInfo", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatClickTalkComponent extends BaseContentWidget implements maa.e {
    public static final /* synthetic */ int L0 = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final e H0;
    public final boolean I;
    public boolean J;
    public String K;
    public String L;
    public volatile b M;
    public volatile String N;
    public final ConcurrentHashMap<String, b> O;
    public int P;
    public Map<String, Object> Q;
    public com.obric.assistant.component.clicktalk.n R;
    public volatile boolean S;
    public final ConcurrentHashMap<String, a> T;
    public String U;
    public a V;
    public final AtomicLong W;
    public com.obric.assistant.component.clicktalk.i X;
    public Long Y;
    public long Z;
    public boolean k0;
    public final int m;
    public Message n;
    public DoraWearState o;
    public final Lazy p;
    public final v p0;
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

    public static final class e implements a {
        public final /* synthetic */ ChatClickTalkComponent a;

        public e(ChatClickTalkComponent r1) {
            this.a = r1;
        }

        public final void a(String r6, Map<String, ? extends Object> r7) {
            Intrinsics.checkNotNullParameter(r6, "botId");
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("onIdleTimeout:");
            r1.append(r6);
            r1.append(" curBotId:");
            ChatClickTalkComponent r2 = this.a;
            int r3 = ChatClickTalkComponent.L0;
            r1.append(r2.Q3());
            r1.append(" , args ");
            r1.append(r7);
            r0.i("ChatClickTalkComponent", r1.toString());
            boolean r4 = Intrinsics.areEqual(this.a.Q3(), r6);
            d r5 = this.a.V3();
            boolean r8 = true;
            if (r5 != null) goto L5;
        L7:
            boolean r9 = false;
        L8:
            if (r9 == false) goto L10;
        L15:
            r8 = false;
        L16:
            String r10 = null;
            if (r4 == true) goto L19;
            if (r8 == true) goto L19;
        L24:
            if (r7 == null) goto L26;
            Object r11 = r7.get("wakeupFrom");
        L28:
            if ((r11 instanceof Integer) == false) goto L30;
            Integer r12 = (Integer) r11;
        L31:
            if (r12 == null) goto L33;
            int r13 = r12.intValue();
        L35:
            if (r13 != 2) goto L50;
            ContentScene.a r14 = ContentScene.Companion;
            if (r7 == null) goto L39;
            Object r15 = r7.get("scene");
        L41:
            if ((r15 instanceof String) == false) goto L43;
            r10 = (String) r15;
        L43:
            if (r10 != null) goto L45;
            r10 = ContentScene.UNKNOWN.getStr();
        L45:
            r14.getClass();
            ContentScene r16 = ContentScene.a.a(r10);
            if (r16.isValid() == false) goto L50;
            IObricAutoMicService.a.getClass();
            IObricAutoMicService r17 = IObricAutoMicService.a.a();
            if (r17 == null) goto L50;
            r17.a();
            r17.i(r16, "idle_timeout");
            goto L50
        L39:
            r15 = null;
        L50:
            Object r18 = AppHost.a.getApplication().getSystemService("audio");
            Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type android.media.AudioManager");
            if (((AudioManager) r18).getRingerMode() != 2) goto L54;
            SoundEffectHelper.INSTANCE.playExit();
            return;
        L54:
            return;
        L33:
            r13 = -1;
            goto L35
        L30:
            r12 = null;
            goto L31
        L26:
            r11 = null;
        L19:
            ChatClickTalkComponent r19 = this.a;
            ExitClickSpeakerType r20 = ExitClickSpeakerType.TIMEOUT;
            if (r7 == null) goto L22;
            Map r21 = MapsKt.toMutableMap(r7);
        L23:
            maa.e.a.a(r19, r20, r21, false, 4);
            goto L24
        L22:
            r21 = null;
            goto L23
        L10:
            if (r6.length() != 0) goto L12;
            boolean r22 = true;
        L13:
            if (r22 == false) goto L15;
        L12:
            r22 = false;
            goto L13
        L5:
            if (r5.Da() != true) goto L7;
            r9 = true;
            goto L8
        }
    }

    public static final class g implements Function0<maa.g> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(maa.g.class));
        }
    }

    public static final class h implements Function0<maa.h> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(maa.h.class));
        }
    }

    public static final class i implements Function0<d> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(d.class));
        }
    }

    public static final class j implements Function0<f> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(f.class));
        }
    }

    public static final class k implements Function0<com.obric.audio.continuous_talk.b> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.obric.audio.continuous_talk.b.class));
        }
    }

    public static final class l implements Function0<c> {
        public final /* synthetic */ AttachReceiver a;

        public l(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(c.class));
        }
    }

    public static final class m implements Function0<y> {
        public final /* synthetic */ AttachReceiver a;

        public m(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(y.class));
        }
    }

    public static final class n implements Function0<p1> {
        public final /* synthetic */ AttachReceiver a;

        public n(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(p1.class));
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

    public static final class q implements Function0<u7> {
        public final /* synthetic */ AttachReceiver a;

        public q(AttachReceiver r1) {
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

    public static final class r implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public r(AttachReceiver r1) {
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

    public static final class s implements Function0<g1> {
        public final /* synthetic */ AttachReceiver a;

        public s(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(g1.class));
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

    public static final class u implements Function0<com.larus.bmhome.chat.component.bottom.core.speaker.l> {
        public final /* synthetic */ AttachReceiver a;

        public u(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.core.speaker.l.class));
        }
    }

    public static final class v implements com.larus.bmhome.chat.component.bottom.core.speaker.b {
        public final /* synthetic */ ChatClickTalkComponent a;

        public v(ChatClickTalkComponent r1) {
            this.a = r1;
        }

        public final void a(y58.b r2) {
            Intrinsics.checkNotNullParameter(r2, "result");
        }

        public final void q(AsrLifeState r2, String r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r2, "lifeState");
            if (r3 == null) goto L15;
            b r5 = this.a.O.get(r3);
            if (r5 == null) goto L17;
            int r6 = a.a[r2.ordinal()];
            if (r6 != 1) goto L10;
            this.a.O.remove(r3);
            this.a.D3(r5, "dropped", "asr_failed_before_pcm");
            return;
        L10:
            if (r6 != 2) goto L18;
            this.a.O.remove(r3);
            this.a.D3(r5, "cancelled", "asr_cancelled_before_pcm");
            return;
        L18:
            return;
        L17:
            return;
        }
    }

    static {
    }

    public final void B2() {
    }

    public final void onViewCreated(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    public final com.larus.bmhome.chat.component.bottom.core.speaker.l Ak() {
        return (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.y.getValue();
    }

    public final void B3() {
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<T> r1 = this.T.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        laa.n r2 = ((a) r1.next()).b;
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L8:
        a r3 = this.V;
        if (r3 == null) goto L13;
        laa.n r4 = r3.b;
        if (r4 == null) goto L13;
        r0.add(r4);
    L13:
        Iterator r5 = r0.iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        laa.n r6 = (laa.n) r5.next();
        f r7 = H3();
        if (r7 == null) goto L15;
        r7.UU(r6);
        goto L15
    L19:
        this.T.clear();
        this.U = null;
        this.V = null;
    }

    public final boolean Ds() {
        Set r0 = com.obric.assistant.common.utils.p.a;
        if (com.obric.assistant.common.utils.p.e(getContext()) == false) goto L10;
        if (com.obric.assistant.common.utils.y.e() == false) goto L7;
        FLogger.a.i("ChatClickTalkComponent", "interceptSpeak skip mic-in-use intercept by ROM concurrent record optimize");
        goto L10
    L7:
        t0.e(new a());
        return true;
    L10:
        if (x3() == false) goto L20;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r1 = Ak();
        if (r1 != null) goto L14;
    L16:
        boolean r2 = false;
    L17:
        if (r2 == false) goto L20;
        return true;
    L14:
        if (r1.m0() != true) goto L16;
        r2 = true;
    L20:
        if (x3() == false) goto L22;
        maa.e.a.a(this, null, null, false, 7);
    L22:
        return false;
    }

    public final maa.g E3() {
        maa.g r0 = (maa.g) this.z.getValue();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return s1a.d.a(this).o(Reflection.getOrCreateKotlinClass(maa.g.class));
    }

    public final Integer G3() {
        IObricVoiceService.a.getClass();
        IObricVoiceService r0 = IObricVoiceService.a.a();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.n() != true) goto L7;
    L8:
        if (r1 == false) goto L12;
        IObricVoiceService r2 = IObricVoiceService.a.a();
        if (r2 == null) goto L12;
        return r2.q();
    L12:
        return null;
    L7:
        r1 = false;
        goto L8
    }

    public final f H3() {
        return (f) this.C.getValue();
    }

    public final d V3() {
        return (d) this.B.getValue();
    }

    public final de8.c f1() {
        return (de8.c) this.p.getValue();
    }

    public final void m3() {
        Runnable r0 = this.X;
        if (r0 == null) goto L5;
        t0.a.removeCallbacks(r0);
    L5:
        this.X = null;
        this.Y = null;
    }

    public final void onDestroy() {
        this.W.incrementAndGet();
        B3();
        maa.e.a.a(this, ExitClickSpeakerType.DESTROY, null, false, 6);
        W3(new f(this));
    }

    public final void onPause() {
        FLogger r0 = FLogger.a;
        r0.i("ChatClickTalkComponent", "onPause wakeupFrom:" + this.P);
        com.larus.bmhome.chat.component.bottom.core.speaker.l r1 = Ak();
        if (r1 == null) goto L5;
        r1.K8(this.p0);
    L5:
        String r2 = Q3();
        int r3 = this.P;
        boolean r4 = true;
        if (r3 != 1) goto L8;
    L10:
        boolean r5 = false;
    L12:
        if (r5 == true) goto L15;
        r2 = null;
    L15:
        if (r2 == null) goto L41;
        ForegroundInteractionPhase r6 = ObricInteractionProjectionDelegate.b.a(r2).e;
        r0.i("ChatClickTalkComponent", "onPause current phase is " + r6);
        if (r6 == ForegroundInteractionPhase.Thinking) goto L42;
        IAssistantChatWindow r7 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r7 != null) goto L21;
    L23:
        boolean r8 = false;
    L24:
        if (r8 == false) goto L26;
    L34:
        r4 = false;
    L35:
        if (r4 == false) goto L39;
        a r9 = this.V;
        if (r9 == null) goto L43;
        long r10 = r9.a;
        m3();
        this.Y = Long.valueOf(r10);
        Runnable r11 = new com.obric.assistant.component.clicktalk.i(this, r10);
        this.X = r11;
        t0.a.postDelayed(r11, 200);
        r0.i("ChatClickTalkComponent", "delay pending wakeup close after onPause, requestId=" + r10);
        return;
    L43:
        return;
    L39:
        maa.e.a.a(this, null, null, false, 7);
        return;
    L26:
        if (this.P != 0) goto L34;
        if (this.V == null) goto L34;
        if (this.S == true) goto L34;
        if (this.L != null) goto L34;
    L21:
        if (r7.isWindowMode() != true) goto L23;
        r8 = true;
        goto L24
    L42:
        return;
    L41:
        return;
    L8:
        if (r3 == 2) goto L10;
        r5 = true;
        goto L12
    }

    public final void onStop() {
        FLogger r0 = FLogger.a;
        r0.i("ChatClickTalkComponent", "onStop wakeupFrom " + this.P);
        Long r1 = this.Y;
        m3();
        if (r1 == null) goto L11;
        a r6 = this.V;
        if (r6 == null) goto L7;
        Long r7 = Long.valueOf(r6.a);
    L9:
        if (Intrinsics.areEqual(r7, r1) == false) goto L11;
        r0.i("ChatClickTalkComponent", "close delayed pending wakeup request onStop, requestId=" + r1);
        maa.e.a.a(this, null, null, false, 7);
        goto L11
    L7:
        r7 = null;
    L11:
        String r2 = Q3();
        int r8 = this.P;
        boolean r9 = true;
        if (r8 != 1) goto L14;
    L19:
        if (r9 == true) goto L22;
        r2 = null;
    L22:
        if (r2 == null) goto L26;
        ForegroundInteractionPhase r3 = ObricInteractionProjectionDelegate.b.a(r2).e;
        r0.i("ChatClickTalkComponent", "onStop current phase is " + r3);
        if (r3 == ForegroundInteractionPhase.Thinking) goto L26;
        maa.e.a.a(this, null, null, false, 7);
    L26:
        IObricChatService.a.getClass();
        IObricChatService r4 = IObricChatService.a.a();
        if (r4 == null) goto L30;
        r4.onStop();
        return;
    L30:
        return;
    L14:
        if (r8 == 2) goto L19;
        if (r8 == 4) goto L19;
        r9 = false;
        goto L19
    }

    public final y u0() {
        return (y) this.q.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, maa.e.class);
        FLogger.a.i("ChatClickTalkComponent", "observeDoraGWearState");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new observeDoraGWearState.1(this, null), 3, null);
    }

    public ChatClickTalkComponent() {
        this.m = 2;
        ExitClickSpeakerType r0 = ExitClickSpeakerType.ASR_END;
        this.o = DoraWearState.NA;
        this.p = LazyKt.lazy(new w(this));
        this.q = LazyKt.lazy(new m(this));
        this.r = LazyKt.lazy(new n(this));
        this.s = LazyKt.lazy(new o(this));
        this.t = LazyKt.lazy(new p(this));
        this.u = LazyKt.lazy(new q(this));
        this.v = LazyKt.lazy(new r(this));
        this.w = LazyKt.lazy(new s(this));
        this.x = LazyKt.lazy(new t(this));
        this.y = LazyKt.lazy(new u(this));
        this.z = LazyKt.lazy(new g(this));
        this.A = LazyKt.lazy(new h(this));
        this.B = LazyKt.lazy(new i(this));
        this.C = LazyKt.lazy(new j(this));
        this.D = LazyKt.lazy(new k(this));
        this.E = LazyKt.lazy(new l(this));
        this.F = LazyKt.lazy(new z());
        this.G = LazyKt.lazy(new a0());
        this.H = LazyKt.lazy(new b0());
        this.I = true;
        this.O = new ConcurrentHashMap();
        this.P = -1;
        this.Q = new LinkedHashMap();
        this.T = new ConcurrentHashMap();
        this.W = new AtomicLong();
        this.p0 = new v(this);
        this.H0 = new e(this);
    }

    public final boolean L4() {
        maa.g r0 = E3();
        if (r0 == null) goto L5;
        boolean r1 = r0.L4();
    L6:
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("isClickTalkClosing ? ");
        r3.append(r1);
        r3.append("; state:");
        maa.g r4 = E3();
        if (r4 == null) goto L9;
        maa.d r5 = r4.vD();
    L10:
        r3.append(r5);
        r2.i("ChatClickTalkComponent", r3.toString());
        return r1;
    L9:
        r5 = null;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public final String Q3() {
        y r0 = u0();
        if (r0 == null) goto L9;
        BotModel r1 = r0.j0();
        if (r1 == null) goto L9;
        String r2 = r1.getBotId();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return DoraConfig.g();
    }

    public final void Te() {
        if (x3() == false) goto L6;
        maa.e.a.a(this, ExitClickSpeakerType.MOTIVE_END, null, false, 6);
        return;
    }

    public final boolean gn() {
        if (x3() == false) goto L5;
        return true;
    L5:
        if (this.S == true) goto L7;
    L11:
        boolean r0 = false;
    L12:
        if (r0 == true) goto L17;
        return false;
    L17:
        return true;
    L7:
        if (this.L == null) goto L11;
        if (this.P == (-1)) goto L11;
        r0 = true;
        goto L12
    }

    public final void onResume() {
        m3();
        com.larus.bmhome.chat.component.bottom.core.speaker.l r0 = Ak();
        if (r0 == null) goto L5;
        r0.A4(this.p0);
    L5:
        Bundle r1 = f1().b;
        String r2 = "";
        OAutoEvent r3 = null;
        if (r1 == null) goto L8;
        String r4 = r1.getString("wakeup_source", "");
    L10:
        if (Intrinsics.areEqual(r4, IInteractionStateService.WAKEUP_SOURCE_AUTO_MIC) == true) goto L18;
        c r5 = (c) this.E.getValue();
        if (r5 != null) goto L14;
    L16:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L18;
        return;
    L14:
        if (r5.qO(-1) == true) goto L16;
        r6 = true;
    L18:
        de8.c r7 = f1();
        Bundle r8 = r7.b;
        if (r8 == null) goto L21;
        boolean r9 = r8.getBoolean("arg_wakeup", false);
    L22:
        Bundle r10 = r7.b;
        if (r10 == null) goto L25;
        r10.remove("arg_wakeup");
    L25:
        de8.c r11 = f1();
        Bundle r12 = r11.b;
        if (r12 == null) goto L28;
        boolean r13 = r12.getBoolean("arg_long_press_ai", false);
    L29:
        Bundle r14 = r11.b;
        if (r14 == null) goto L32;
        r14.remove("arg_long_press_ai");
    L32:
        Bundle r15 = f1().b;
        if (r15 == null) goto L35;
        String r16 = r15.getString("wakeup_source", "");
    L36:
        boolean r17 = Intrinsics.areEqual(r16, IInteractionStateService.WAKEUP_SOURCE_AUTO_MIC);
        Bundle r18 = f1().b;
        if (r18 == null) goto L39;
        String r19 = r18.getString("wakeup_source", "");
    L40:
        int r20 = h1.a(r19, 0);
        FLogger.a.i("ChatClickTalkComponent", "wakeUp = " + r9 + ", type = " + r20 + ", chatArgumentData.isAutoOpenCamera() = " + f1().v() + ", isLongPressAi = " + r13 + " isAutoMic " + r17);
        if (r9 == true) goto L43;
        return;
    L43:
        if (f1().v() == true) goto L95;
        if (r13 == true) goto L96;
        de8.c r21 = f1();
        Bundle r22 = r21.b;
        if (r22 == null) goto L48;
        Integer r23 = Integer.valueOf(r22.getInt("arg_vuiid", 0));
    L49:
        Bundle r24 = r21.b;
        if (r24 == null) goto L53;
        r24.remove("arg_vuiid");
    L53:
        if (r17 == false) goto L91;
        de8.c r25 = f1();
        Bundle r26 = r25.b;
        if (r26 == null) goto L60;
        String r27 = r26.getString("scene");
        if (r27 == null) goto L60;
        r2 = r27;
    L60:
        LinkedHashMap r28 = new LinkedHashMap();
        if (Intrinsics.areEqual(r2, ContentScene.OAUTO_CALL_USER.getStr()) == false) goto L70;
        if (Build.VERSION.SDK_INT < 33) goto L90;
        Bundle r29 = r25.b;
        if (r29 == null) goto L67;
        r3 = (OAutoEvent) r29.getParcelable("data", OAutoEvent.class);
    L67:
        if (r3 == null) goto L90;
        r28.put("data", r3);
    L90:
        r28.put("scene", r2);
        nO(2, r28, r23);
        return;
    L70:
        if (Intrinsics.areEqual(r2, ContentScene.PRIORITY_NOTIFICATION.getStr()) == true) goto L84;
        if (Intrinsics.areEqual(r2, ContentScene.AI_ACTIVE_ASK.getStr()) == true) goto L84;
        if (Intrinsics.areEqual(r2, ContentScene.COMPLEX_ASK_USER.getStr()) == false) goto L90;
        if (Build.VERSION.SDK_INT < 33) goto L90;
        Bundle r30 = r25.b;
        if (r30 == null) goto L81;
        r3 = (ComplexEvent) r30.getParcelable("data", ComplexEvent.class);
    L81:
        if (r3 == null) goto L90;
        r28.put("data", r3);
    L84:
        if (Build.VERSION.SDK_INT < 33) goto L90;
        Bundle r31 = r25.b;
        if (r31 == null) goto L88;
        r3 = (AppEvent) r31.getParcelable("data", AppEvent.class);
    L88:
        if (r3 == null) goto L90;
        r28.put("data", r3);
        goto L90
    L91:
        maa.e.a.b(this, r20, r23, 2);
        return;
    L48:
        r23 = null;
        goto L49
    L96:
        return;
    L95:
        return;
    L39:
        r19 = null;
        goto L40
    L35:
        r16 = null;
        goto L36
    L28:
        r13 = false;
        goto L29
    L21:
        r9 = false;
        goto L22
    L8:
        r4 = null;
        goto L10
    }

    public final boolean x3() {
        maa.g r0 = E3();
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = r0.x3();
    L6:
        maa.g r3 = E3();
        if (r3 == null) goto L9;
        r1 = r3.L4();
    L9:
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("isClickTalking ? ");
        r5.append(r2);
        r5.append(", isClickTalkClosing ");
        r5.append(r1);
        r5.append("; state:");
        maa.g r6 = E3();
        if (r6 == null) goto L12;
        maa.d r7 = r6.vD();
    L13:
        r5.append(r7);
        r4.i("ChatClickTalkComponent", r5.toString());
        return r2;
    L12:
        r7 = null;
        goto L13
    L5:
        r2 = false;
        goto L6
    }

    public final int nZ() {
        return this.P;
    }

    public final void W3(Function1<? super String, Unit> r8) {
        String r0 = Q3();
        if (r0 == null) goto L5;
        r8.invoke(r0);
        return;
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new handleBotOperations.1(this, r8, null), 3, null);
    }

    public final void X3(String r5) {
        com.obric.audio.continuous_talk.b r0 = (com.obric.audio.continuous_talk.b) this.D.getValue();
        if (r0 == null) goto L5;
        ContinuousTalkStatus r1 = r0.u10();
    L7:
        if (r1 != ContinuousTalkStatus.RUNNING) goto L9;
        FLogger.a.i("ChatClickTalkComponent", r5.concat(" keep voice view for continuous talk"));
        return;
    L9:
        FLogger.a.i("ChatClickTalkComponent", r5 + " hide voice view, continuousTalkStatus=" + r1);
        laa.m r6 = (laa.m) this.x.getValue();
        if (r6 == null) goto L14;
        r6.Rb();
        return;
    L14:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void XB(g2 r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        W3(new com.obric.assistant.component.clicktalk.j(r2));
    }

    public final Object a4(Continuation<? super BotModel> r6) {
        d r0 = new d(this);
        return TimeoutKt.c(RangesKt.coerceAtLeast(10000, 0), new suspendCoroutine.2(r0, null), r6);
    }

    public final void d4(boolean r5) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("operateDoraVUI enable vui : ");
        r1.append(r5);
        r1.append(" , connected ? ");
        AudioServiceDelegate r2 = AudioServiceDelegate.a;
        r1.append(r2.isDoraConnected());
        r0.i("ChatClickTalkComponent", r1.toString());
        if (r2.isDoraConnected() == false) goto L6;
        r0.a.a(new com.obric.assistant.component.clicktalk.m(this, r5));
        return;
    }

    public final void e4(long r7) {
        Set<Map.Entry<String, a>> r0 = this.T.entrySet();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Object r3 = r2.next();
        if (((a) ((Map.Entry) r3).getValue()).a != r7) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        r4 = false;
        goto L9
    L11:
        Iterator r8 = r1.iterator();
    L13:
        if (r8.hasNext() == false) goto L15;
        Map.Entry r9 = (Map.Entry) r8.next();
        this.T.remove(r9.getKey(), r9.getValue());
        goto L13
    }

    public final void ea(float r3) {
        f r0 = H3();
        if (r0 == null) goto L6;
        r0.us(r3, null);
        return;
    }

    public final void h4(a r7) {
        if (p3(r7) == false) goto L5;
        return;
    L5:
        e4(r7.a);
        a r0 = this.V;
        boolean r1 = false;
        if (r0 != null) goto L8;
    L10:
        if (r1 == false) goto L12;
        this.V = null;
    L12:
        f r2 = H3();
        if (r2 == null) goto L16;
        r2.tH(r7.b);
        return;
    L16:
        return;
    L8:
        if (r0.a != r7.a) goto L10;
        r1 = true;
        goto L10
    }

    public final void nN(maa.c r12) {
        Intrinsics.checkNotNullParameter(r12, "event");
        boolean r2 = false;
        if ((r12 instanceof maa.c.f) == false) goto L20;
        int r13 = ((maa.c.f) r12).a;
        InstanceCallState.Companion.getClass();
        FLogger.a.i("ChatClickTalkComponent", "new state: ".concat(InstanceCallState.a.a(r13)));
        ((w) this.H.getValue()).a();
        VoiceCaptureStateProducerDelegate r5 = VoiceCaptureStateProducerDelegate.b;
        y r0 = u0();
        if (r0 == null) goto L7;
        String r6 = r0.Y1();
    L8:
        r5.a(r6, VoiceCaptureScene.CLICK_TALK, r13, this.L, Integer.valueOf(this.P));
        if (r13 != 4) goto L11;
    L18:
        ((w) this.H.getValue()).d();
        return;
    L11:
        if (r13 == 9) goto L18;
        if (r13 == 6) goto L17;
        if (r13 != 7) goto L72;
        maa.e.a.a(this, ExitClickSpeakerType.INTERRUPT, null, false, 6);
        return;
    L72:
        return;
    L17:
        t19.s r14 = t19.s.a;
        Application r1 = AppHost.a.getApplication();
        r14.getClass();
        t19.s.s(r1, 2131908080);
        maa.e.a.a(this, null, null, false, 7);
        return;
    L7:
        r6 = null;
        goto L8
    L20:
        if ((r12 instanceof maa.c.c) == false) goto L23;
        maa.c.c r15 = (maa.c.c) r12;
        return;
    L23:
        if (Intrinsics.areEqual(r12, maa.c.a.a) == false) goto L27;
        FLogger.a.i("ChatClickTalkComponent", "onAsrEnd");
        IAgentVoiceInteractionIDL r16 = com.obric.aiagent.assistant.idl.u.a(Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class));
        if (r16 == null) goto L66;
        r16.onAsrEnd();
        return;
    L66:
        return;
    L27:
        boolean r7 = true;
        if ((r12 instanceof maa.c.d) == false) goto L40;
        maa.c.d r17 = (maa.c.d) r12;
        FLogger.a.i("ChatClickTalkComponent", "observeQueryBeginEvent");
        String r18 = Q3();
        AutoHalfDuplexModeServiceDelegate r3 = AutoHalfDuplexModeServiceDelegate.b;
        g1 r4 = (g1) this.w.getValue();
        if (r4 == null) goto L36;
        List r8 = r4.q1();
        if (r8 == null) goto L36;
        if (r8.size() <= 0) goto L36;
        r2 = true;
    L36:
        r3.h(r18, r2);
        r3.g(r18);
        IAgentVoiceInteractionIDL r19 = com.obric.aiagent.assistant.idl.u.a(Reflection.getOrCreateKotlinClass(IAgentVoiceInteractionIDL.class));
        if (r19 == null) goto L68;
        r19.onAsrStart(null);
        return;
    L68:
        return;
    L40:
        if (Intrinsics.areEqual(r12, maa.c.e.a) == false) goto L55;
        FLogger.a.i("ChatClickTalkComponent", "observeQueryEndEvent");
        Message r110 = this.n;
        if (r110 == null) goto L44;
        String r111 = r110.getLocalMessageId();
    L45:
        i4(this, r111, "asr_end");
        maa.g r112 = E3();
        if (r112 != null) goto L48;
    L50:
        r7 = false;
    L51:
        if (r7 == false) goto L53;
        AutoHalfDuplexModeServiceDelegate.b.f(Q3());
    L53:
        maa.e.a.a(this, ExitClickSpeakerType.ASR_END, null, false, 6);
        return;
    L48:
        if (r112.L4() == true) goto L50;
    L44:
        r111 = null;
        goto L45
    L55:
        if ((r12 instanceof maa.c.b) == false) goto L61;
        maa.c.b r113 = (maa.c.b) r12;
        String r9 = r113.a;
        String r114 = r113.b;
        d r10 = V3();
        if (r10 == null) goto L71;
        r10.D50(r9, r114);
        return;
    L71:
        return;
    L61:
        throw new NoWhenBranchMatchedException();
    }

    public final void oG(Message r4) {
        FLogger.a.i("ChatClickTalkComponent", "startNextRound，msg:" + r4);
        this.n = r4;
        String r5 = r4.getLocalMessageId();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r5 = null;
    L11:
        if (r5 == null) goto L20;
        this.U = r5;
        a r1 = this.V;
        if (r1 == null) goto L15;
        this.T.put(r5, r1);
    L15:
        b r2 = this.M;
        if (r2 == null) goto L21;
        this.O.put(r5, r2);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final boolean p3(a r8) {
        if (this.W.get() == r8.a) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return false;
    L8:
        t0.a.post(new c(this, r8));
        FLogger.a.i("ChatClickTalkComponent", "drop stale ClickTalk request: " + r8.a);
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public final void setAudioData(byte[] r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        String r0 = this.U;
        laa.n r1 = null;
        boolean r2 = false;
        if (r0 == null) goto L12;
        b r3 = this.O.get(r0);
        if (r3 == null) goto L12;
        if (r3 != this.M) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
    L13:
        if (r3 != null) goto L15;
    L21:
        if (r2 == false) goto L23;
        r3.a(IAssistantStartupTelemetry.a.c(AssistantStartupTelemetry.a, r3.a, "asr_record_ready"));
    L23:
        f r5 = H3();
        if (r5 == null) goto L30;
        a r7 = this.V;
        if (r7 == null) goto L28;
        r1 = r7.b;
    L28:
        r5.Ru(r6, r1);
        return;
    L30:
        return;
    L15:
        if (r6.length != 0) goto L17;
        boolean r8 = true;
    L19:
        if (r3.b(!r8) != true) goto L21;
        r2 = true;
        goto L21
    L17:
        r8 = false;
        goto L19
    L9:
        r4 = false;
    L12:
        r3 = null;
        goto L13
    }

    public final void updateScreenshotForAsr(String r2) {
        maa.g r0 = E3();
        if (r0 == null) goto L6;
        r0.updateScreenshotForAsr(r2);
        return;
    }

    public final void v50(String r8) {
        Intrinsics.checkNotNullParameter(r8, "tag");
        FLogger r0 = FLogger.a;
        r0.i("ChatClickTalkComponent", "resetLaunchMethodParams from ".concat(r8));
        ExitClickSpeakerType r1 = ExitClickSpeakerType.MANUAL;
        String r9 = "reset-by-caller source is: ".concat(r8);
        StringBuilder r3 = new StringBuilder("try to clearLaunchMethodParamTask type : ");
        r3.append(r1);
        r3.append(" tag: ");
        r3.append(r9);
        r3.append(" wakeup souce ");
        IObricReporter.a.getClass();
        IObricReporter r2 = IObricReporter.a.a();
        String r4 = null;
        if (r2 == null) goto L5;
        String r5 = r2.getWakeupSource();
    L6:
        r3.append(r5);
        r0.i("ChatClickTalkComponent", r3.toString());
        String[] r6 = {"voice.wakeup", "dora.wakeup", "dora.bluetooth", "voice.breath"};
        IObricReporter r7 = IObricReporter.a.a();
        if (r7 == null) goto L10;
        r4 = r7.getWakeupSource();
    L10:
        if (ArraysKt.contains(r6, r4) == false) goto L15;
        r0.i("ChatClickTalkComponent", "closeClickTalk clearLaunchMethodParamTask executed from " + r9);
        IObricReporter r10 = IObricReporter.a.a();
        if (r10 == null) goto L16;
        r10.d();
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void z3(a r12) {
        a r0 = this.V;
        laa.n r1 = r12.b;
        boolean r3 = true;
        if (r1 == null) goto L10;
        if (r0 == null) goto L6;
        laa.n r5 = r0.b;
    L8:
        if (Intrinsics.areEqual(r5, r1) == false) goto L10;
        boolean r2 = true;
    L11:
        laa.n r6 = r12.b;
        if (r6 == null) goto L24;
        if (r0 == null) goto L15;
        long r7 = r0.a;
    L17:
        if (r7 == r12.a) goto L21;
        if (r2 == false) goto L21;
        boolean r4 = false;
    L22:
        if (r4 == false) goto L24;
        boolean r8 = true;
    L25:
        if (r8 == false) goto L30;
        if (r6 == null) goto L30;
        f r9 = H3();
        if (r9 == null) goto L30;
        r9.UU(r6);
    L30:
        e4(r12.a);
        if (r0 != null) goto L33;
    L35:
        r3 = false;
    L36:
        if (r3 == false) goto L39;
        this.V = null;
        return;
    L39:
        return;
    L33:
        if (r0.a != r12.a) goto L35;
    L21:
        r4 = true;
        goto L22
    L15:
        r7 = 0;
    L24:
        r8 = false;
        goto L25
    L6:
        r5 = null;
    L10:
        r2 = false;
        goto L11
    }

    public static final Object Y2(ChatClickTalkComponent r4, Continuation r5) {
        r4.getClass();
        if ((r5 instanceof fetchBotIfNeeded.1) == false) goto L7;
        fetchBotIfNeeded.1 r0 = (fetchBotIfNeeded.1) r5;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L19:
        BotModel r7 = (BotModel) r6;
        if (r7 == null) goto L22;
        String r8 = r7.getBotId();
    L23:
        FLogger.a.i("ChatClickTalkComponent", "Fetched botId: " + r8);
        return r8;
    L22:
        r8 = null;
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        String r9 = r4.Q3();
        if (r9 != null) goto L25;
        r0.label = 1;
        r6 = r4.a4(r0);
        if (r6 != r2) goto L19;
        return r2;
    L25:
        return r9;
    L7:
        r0 = new fetchBotIfNeeded.1(r4, r5);
        goto L8
    }

    public static boolean Z3(Integer r4, Integer r5) {
        if (r4 != null) goto L4;
    L8:
        boolean r0 = false;
    L9:
        FLogger.a.i("ChatClickTalkComponent", "isDoraVuiWakeup vuiId=" + r4 + ", wakeupId=" + r5 + ", result=" + r0);
        return r0;
    L4:
        if (r4.intValue() == 0) goto L8;
        if (Intrinsics.areEqual(r4, r5) == true) goto L8;
        r0 = true;
        goto L9
    }

    public final void j4(boolean r7, String r8) {
        monitor-enter(this);
        boolean r2 = !this.k0;     // Catch: Throwable -> L17
        if (r2 == false) goto L7;
        FLogger.a.i("ChatClickTalkComponent", "traceClickTalkStart will go on ,traceStarted:" + this.k0 + " , success: " + r7 + " and failedType: " + r8);     // Catch: Throwable -> L17
    L8:
        if (r2 == false) goto L14;
        this.k0 = true;     // Catch: Throwable -> L17
        this.Z = SystemClock.elapsedRealtime();     // Catch: Throwable -> L17
        String r0 = Q3();     // Catch: Throwable -> L17
        y r1 = u0();     // Catch: Throwable -> L17
        if (r1 == null) goto L12;
        String r3 = r1.Y1();     // Catch: Throwable -> L17
    L13:
        mha.a.b(r0, r3, this.K, r7, r8);     // Catch: Throwable -> L17
        goto L14
    L12:
        r3 = null;
    L14:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L7:
        FLogger.a.i("ChatClickTalkComponent", "traceClickTalkStart will not go on ,traceStarted:" + this.k0 + " , success: " + r7 + " and failedType: " + r8);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public static void i4(ChatClickTalkComponent r11, String r12, String r13) {
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (r11.x3() == true) goto L7;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L14;
        FLogger.a.i("ChatClickTalkComponent", "traceClickTalkEnd will go on, traceStarted:" + r11.k0 + " clickTalk " + r11.x3() + " with endType " + r13 + " and msgId : " + r12);     // Catch: Throwable -> L9
    L15:
        if (r2 == false) goto L21;
        r11.k0 = false;     // Catch: Throwable -> L9
        String r5 = r11.Q3();     // Catch: Throwable -> L9
        y r0 = r11.u0();     // Catch: Throwable -> L9
        if (r0 == null) goto L19;
        String r1 = r0.Y1();     // Catch: Throwable -> L9
    L20:
        mha.a.a(r5, r1, r11.K, r12, r13, Integer.valueOf((int) (SystemClock.elapsedRealtime() - r11.Z)));     // Catch: Throwable -> L9
        goto L21
    L19:
        r1 = null;
    L21:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r11);
        return;
    L14:
        FLogger.a.i("ChatClickTalkComponent", "traceClickTalkEnd will not go on, traceStarted:" + r11.k0 + " clickTalk " + r11.x3() + " with endType " + r13 + " and msgId : " + r12);     // Catch: Throwable -> L9
        goto L15
    L7:
        if (r11.k0 == false) goto L11;
        r2 = true;
        goto L12
    }

    public final void C3(String r7, String r8, String r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        IAssistantStartupTelemetry.a.a(AssistantStartupTelemetry.a, r9, r7, r8, null, 24);
        b r10 = this.M;
        if (r10 == null) goto L7;
        String r11 = r10.a;
    L9:
        if (Intrinsics.areEqual(r11, r9) == false) goto L12;
        this.M = null;
    L12:
        if (Intrinsics.areEqual(this.N, r9) == false) goto L15;
        this.N = null;
        return;
    L15:
        return;
    L7:
        r11 = null;
        goto L9
    }

    public final void D3(b r2, String r3, String r4) {
        if (r2.c() == false) goto L6;
        C3(r3, r4, r2.a);
        return;
    L6:
        if (this.M != r2) goto L10;
        this.M = null;
        return;
    }

    public final void TE(boolean r7, String r8, Function1<? super String, Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r9, "callback");
        a r0 = this.V;
        boolean r1 = false;
        if (r0 == null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L13;
        f r4 = H3();
        if (r4 == null) goto L13;
        r4.sC(r8, r7);
    L13:
        String r5 = null;
        if (r7 == false) goto L30;
        this.U = r8;
        if (r0 == null) goto L18;
        this.T.put(r8, r0);
    L18:
        laa.m r10 = (laa.m) this.x.getValue();
        if (r10 == null) goto L21;
        r10.I2(new f0(r9, r8));
    L21:
        laa.m r11 = (laa.m) this.x.getValue();
        if (r11 == null) goto L68;
        if (r0 == null) goto L25;
        laa.n r12 = r0.b;
    L26:
        b r13 = this.M;
        if (r13 == null) goto L29;
        r5 = r13.a;
    L29:
        r11.GC(true, false, r12, r5);
        return;
    L25:
        r12 = null;
        goto L26
    L68:
        return;
    L30:
        a r14 = this.T.get(r8);
        String r15 = this.U;
        if (r15 == null) goto L35;
        a r2 = this.T.get(r15);
        if (r2 == null) goto L35;
        Long r6 = Long.valueOf(r2.a);
    L36:
        if (r14 == null) goto L38;
        Long r16 = Long.valueOf(r14.a);
    L39:
        Intrinsics.checkNotNullParameter(r8, "terminalTaskId");
        if (r6 == null) goto L45;
        if (r16 == null) goto L45;
        if (Intrinsics.areEqual(r6, r16) == false) goto L53;
    L54:
        if (r14 == null) goto L56;
        z3(r14);
    L57:
        if (r1 == false) goto L61;
        FLogger.a.i("ChatClickTalkComponent", "ignore stale listening UI terminal: ".concat(r8));
        return;
    L61:
        if (Intrinsics.areEqual(this.U, r15) == false) goto L63;
        this.U = null;
    L63:
        laa.m r17 = (laa.m) this.x.getValue();
        if (r17 == null) goto L66;
        r17.I2(new b());
    L66:
        X3("setSpeakerVisible");
        return;
    L56:
        this.T.remove(r8);
    L53:
        r1 = true;
    L45:
        Intrinsics.checkNotNullParameter(r8, "terminalTaskId");
        if (r8.length() <= 0) goto L48;
        boolean r18 = true;
    L49:
        if (r18 == false) goto L54;
        if (r15 == null) goto L54;
        if (Intrinsics.areEqual(r15, r8) == true) goto L54;
    L48:
        r18 = false;
        goto L49
    L38:
        r16 = null;
    L35:
        r6 = null;
        goto L36
    L5:
        if (this.T.containsKey(r8) == true) goto L8;
        r3 = false;
        goto L9
    }

    public final synchronized void e70(ExitClickSpeakerType r18, Map<String, Object> r19, boolean r20) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r18, "exitClickSpeakerType");     // Catch: Throwable -> L126
        m3();     // Catch: Throwable -> L126
        FLogger r7 = FLogger.a;     // Catch: Throwable -> L126
        StringBuilder r9 = new StringBuilder("closeClickTalk with exitAssistantType ");     // Catch: Throwable -> L126
        r9.append(r18);     // Catch: Throwable -> L126
        r9.append(" , clickTalkState ");     // Catch: Throwable -> L126
        maa.g r6 = E3();     // Catch: Throwable -> L126
        if (r6 == null) goto L7;
        maa.d r8 = r6.vD();     // Catch: Throwable -> L126
    L8:
        r9.append(r8);     // Catch: Throwable -> L126
        r9.append(", wakeupFrom ");     // Catch: Throwable -> L126
        r9.append(this.P);     // Catch: Throwable -> L126
        r9.append(", endDoraSession: ");     // Catch: Throwable -> L126
        r9.append(r20);     // Catch: Throwable -> L126
        r9.append(", hasDispatchedClickTalkStart: ");     // Catch: Throwable -> L126
        r9.append(this.S);     // Catch: Throwable -> L126
        r9.append(", curTaskId: ");     // Catch: Throwable -> L126
        r9.append(this.L);     // Catch: Throwable -> L126
        r9.append('}');     // Catch: Throwable -> L126
        r7.i("ChatClickTalkComponent", r9.toString());     // Catch: Throwable -> L126
        if (r19 == null) goto L11;
        boolean r2 = Intrinsics.areEqual(r19.get("suppress_close_haptic_for_intercom_switch"), Boolean.TRUE);     // Catch: Throwable -> L126
    L12:
        ExitClickSpeakerType r10 = ExitClickSpeakerType.RESTART;     // Catch: Throwable -> L126
        if (r18 != r10) goto L15;
        this.O.clear();     // Catch: Throwable -> L126
        this.M = null;     // Catch: Throwable -> L126
    L23:
        if (r18 == r10) goto L26;
        this.W.incrementAndGet();     // Catch: Throwable -> L126
    L26:
        if (gn() == true) goto L42;
        B3();     // Catch: Throwable -> L126
        if (this.S == false) goto L37;
        hca.c r0 = (hca.c) this.F.getValue();     // Catch: Throwable -> L126
        if (r0 == null) goto L36;
        y r3 = u0();     // Catch: Throwable -> L126
        if (r3 == null) goto L34;
        String r4 = r3.Y1();     // Catch: Throwable -> L126
    L35:
        r0.d(r4, Integer.valueOf(this.P), this.L);     // Catch: Throwable -> L126
        goto L36
    L34:
        r4 = null;
    L36:
        this.S = false;     // Catch: Throwable -> L126
        this.L = null;     // Catch: Throwable -> L126
    L37:
        this.P = -1;     // Catch: Throwable -> L126
        Map<String, Object> r1 = this.Q;     // Catch: Throwable -> L126
        if (r1 == null) goto L40;
        r1.clear();     // Catch: Throwable -> L126
    L40:
        monitor-exit(this);
        return;
    L42:
        maa.g r5 = E3();     // Catch: Throwable -> L126
        if (r5 == null) goto L45;
        r5.JN();     // Catch: Throwable -> L126
    L45:
        Handler r11 = t0.a;     // Catch: Throwable -> L126
        r11.postDelayed(new com.obric.assistant.component.clicktalk.k(this, r18), 300);     // Catch: Throwable -> L126
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L48;
        X3("closeClickTalk");     // Catch: Throwable -> L126
    L49:
        IDoraWakeupService r12 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);     // Catch: Throwable -> L126
        if (r12 != null) goto L52;
    L54:
        boolean r13 = false;
    L55:
        if (r13 == false) goto L69;
        if (r20 == false) goto L69;
        if (AudioServiceDelegate.a.e0() == false) goto L69;
        IDoraWakeupService r14 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);     // Catch: Throwable -> L126
        if (r14 != null) goto L62;
    L64:
        boolean r15 = false;
    L65:
        if (r15 == true) goto L69;
        r7.i("ChatClickTalkComponent", "closeClickTalk, close VUI session");     // Catch: Throwable -> L126
        IDoraWakeupService r16 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);     // Catch: Throwable -> L126
        if (r16 == null) goto L69;
        r16.p();     // Catch: Throwable -> L126
        goto L69
    L62:
        if (r14.o() != true) goto L64;
        r15 = true;
    L69:
        boolean r17 = IKeyguardStateKt.getKeyguardState().isKeyguardLocked();     // Catch: Throwable -> L126
        IObricChatService.a.getClass();     // Catch: Throwable -> L126
        IObricChatService r110 = IObricChatService.a.a();     // Catch: Throwable -> L126
        if (r110 != null) goto L72;
    L74:
        boolean r111 = false;
    L75:
        if (r17 == true) goto L78;
        if (r111 == true) goto L78;
    L82:
        boolean r21 = false;
    L84:
        if (r20 == false) goto L99;
        if (AudioServiceDelegate.a.e0() == false) goto L99;
        if (r21 == true) goto L99;
        IDoraWakeupService r22 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);     // Catch: Throwable -> L126
        if (r22 != null) goto L91;
    L93:
        boolean r23 = false;
    L94:
        if (r23 == true) goto L99;
        r7.i("ChatClickTalkComponent", "closeClickTalk, close VUI session");     // Catch: Throwable -> L126
        IDoraWakeupService r24 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);     // Catch: Throwable -> L126
        if (r24 == null) goto L99;
        r24.p();     // Catch: Throwable -> L126
        goto L99
    L91:
        if (r22.o() != true) goto L93;
        r23 = true;
    L99:
        if (AudioServiceDelegate.a.e0() == false) goto L106;
        if (SetsKt.setOf(new ExitClickSpeakerType[]{ExitClickSpeakerType.ASR_END, ExitClickSpeakerType.SEND_MESSAGE}).contains(r18) == false) goto L106;
        IDoraWakeupService r25 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);     // Catch: Throwable -> L126
        if (r25 == null) goto L106;
        r25.h();     // Catch: Throwable -> L126
    L106:
        if (this.J == true) goto L108;
        d4(true);     // Catch: Throwable -> L126
    L109:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new closeClickTalk.3(this, r2, null), 3, null);     // Catch: Throwable -> L126
        hca.c r26 = (hca.c) this.F.getValue();     // Catch: Throwable -> L126
        if (r26 == null) goto L116;
        y r27 = u0();     // Catch: Throwable -> L126
        if (r27 == null) goto L114;
        String r28 = r27.Y1();     // Catch: Throwable -> L126
    L115:
        r26.d(r28, Integer.valueOf(this.P), this.L);     // Catch: Throwable -> L126
        goto L116
    L114:
        r28 = null;
    L116:
        this.S = false;     // Catch: Throwable -> L126
        this.L = null;     // Catch: Throwable -> L126
        r11.post(new com.obric.assistant.component.clicktalk.l(r18, this));     // Catch: Throwable -> L126
        this.P = -1;     // Catch: Throwable -> L126
        Map<String, Object> r29 = this.Q;     // Catch: Throwable -> L126
        if (r29 == null) goto L120;
        r29.clear();     // Catch: Throwable -> L126
    L120:
        if (r18 != ExitClickSpeakerType.TIMEOUT) goto L124;
        d r30 = V3();     // Catch: Throwable -> L126
        if (r30 == null) goto L124;
        r30.le();     // Catch: Throwable -> L126
    L124:
        monitor-exit(this);
        return;
    L108:
        this.J = false;     // Catch: Throwable -> L126
    L78:
        if (r18 != ExitClickSpeakerType.ASR_END) goto L80;
    L83:
        r21 = true;
        goto L84
    L80:
        if (r18 != ExitClickSpeakerType.SEND_MESSAGE) goto L82;
    L72:
        if (r110.k() != true) goto L74;
        r111 = true;
        goto L75
    L52:
        if (r12.g() != true) goto L54;
        r13 = true;
        goto L55
    L48:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new closeClickTalk.2(this, null), 2, null);     // Catch: Throwable -> L126
        goto L49
    L15:
        if (r18 != ExitClickSpeakerType.TIMEOUT) goto L17;
        String r31 = "timeout";
    L18:
        b r112 = this.M;     // Catch: Throwable -> L126
        if (r112 == null) goto L21;
        D3(r112, r31, "click_talk_" + r18.name().toLowerCase(Locale.ROOT) + "_before_pcm");     // Catch: Throwable -> L126
    L21:
        C3(r31, "click_talk_" + r18.name().toLowerCase(Locale.ROOT) + "_before_start", this.N);     // Catch: Throwable -> L126
        this.O.clear();     // Catch: Throwable -> L126
        goto L23
    L17:
        r31 = "cancelled";
        goto L18
    L11:
        r2 = false;
        goto L12
    L7:
        r8 = null;
    L126:
        th = move-exception;
        throw th;
    }

    public final synchronized void nO(int r7, Map<String, Object> r8, Integer r9) {
        monitor-enter(this);
        long r0 = this.W.incrementAndGet();     // Catch: Throwable -> L45
        f r2 = H3();     // Catch: Throwable -> L45
        String r3 = null;
        if (r2 == null) goto L6;
        com.obric.assistant.view.listening.b r4 = r2.Nf();     // Catch: Throwable -> L45
    L7:
        a r5 = new a(r0, r4);     // Catch: Throwable -> L45
        Bundle r1 = f1().b;     // Catch: Throwable -> L45
        if (r1 == null) goto L17;
        String r6 = r1.getString("obric_startup_attempt_id");     // Catch: Throwable -> L45
        if (r6 == null) goto L17;
        if ((!StringsKt.isBlank(r6)) == true) goto L15;
        r6 = null;
    L15:
        if (r6 == null) goto L17;
    L25:
        if (r6 == null) goto L29;
        String r10 = AssistantStartupTelemetry.a.i("asr_record_ready");     // Catch: Throwable -> L45
        if (r10 == null) goto L29;
        if (Intrinsics.areEqual(r6, r10) == true) goto L34;
        r6 = null;
    L34:
        String r11 = r6;
    L35:
        String r12 = this.N;     // Catch: Throwable -> L45
        if (r12 != null) goto L38;
    L42:
        this.N = r11;     // Catch: Throwable -> L45
        k4(r7, r8, r9, r11, r5);     // Catch: Throwable -> L45
        monitor-exit(this);
        return;
    L38:
        if ((!Intrinsics.areEqual(r12, r11)) == false) goto L40;
        r3 = r12;
    L40:
        if (r3 == null) goto L42;
        C3("cancelled", "click_talk_replaced_before_start", r3);     // Catch: Throwable -> L45
    L29:
        r11 = null;
    L17:
        Bundle r13 = f1().a;     // Catch: Throwable -> L45
        if (r13 == null) goto L24;
        r6 = r13.getString("obric_startup_attempt_id");     // Catch: Throwable -> L45
        if (r6 == null) goto L24;
        if ((!StringsKt.isBlank(r6)) == true) goto L25;
    L24:
        r6 = null;
        goto L25
    L6:
        r4 = null;
    L45:
        th = move-exception;
        throw th;
    }

    public final String Js(String r4, String r5, boolean r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r7, "userId");
        Intrinsics.checkNotNullParameter(r8, "deviceUuid");
        IObricAutoMicService.a.getClass();
        IObricAutoMicService r0 = IObricAutoMicService.a.a();
        if (r0 == null) goto L40;
        com.obric.assistant.voice.a r9 = r0.b(r4);
        if (r9 == null) goto L40;
        if (r9.d == ContentStatus.INIT) goto L10;
        return null;
    L10:
        ContentStatus r1 = ContentStatus.VOICE_AUTHEN;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r9.d = r1;
        boolean r10 = false;
        if (r5 != null) goto L13;
    L16:
        boolean r2 = true;
    L17:
        if (r2 == false) goto L41;
        JSONObject r11 = new JSONObject();
    L28:
        r11.put("enable_speaker_identify", false);
        if (r6 == false) goto L31;
        r11.put("enable_pvad_audio_interrupt", true);
    L31:
        String r12 = ObricEnrollInteropDelegate.b.v();
        if (r12 != null) goto L34;
    L35:
        r10 = true;
    L36:
        if (r10 == false) goto L38;
        JSONObject r13 = new JSONObject();
        r13.put("engine_version", "1.0.0.100");
        r13.put("voice_print_id", r7 + '-' + r8);
        r12 = r13.toString();
    L38:
        Intrinsics.checkNotNull(r12);
        r11.put("dora_engine_version", r12);
        return r11.toString();
    L34:
        if (r12.length() != 0) goto L36;
    L41:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L21
        Object r14 = Result.constructor-impl(new JSONObject(r5));     // Catch: Throwable -> L21
    L24:
        if (Result.exceptionOrNull-impl(r14) == null) goto L27;
        r14 = new JSONObject();
    L27:
        r11 = (JSONObject) r14;
    L21:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L13:
        if (r5.length() == 0) goto L16;
        r2 = false;
    L40:
        return null;
    }

    public final void KW(String r9, String r10, String r11, String r12, int r13) {
        IObricAssistantUtilHelperService r1 = (IObricAssistantUtilHelperService) ServiceManager.get().getService(IObricAssistantUtilHelperService.class);
        if (r1 == null) goto L6;
        r1.a(r9, r10, r11, r12, Integer.valueOf(r13), new JSONObject());
        return;
    }

    public final void k4(int r26, Map<String, Object> r27, Integer r28, String r29, a r30) {
        if (p3(r30) == false) goto L5;
        return;
    L5:
        this.V = r30;
        FLogger r0 = FLogger.a;
        r0.i("ChatClickTalkComponent", "tryOpenClickTalk from :" + r26 + "  【 0 means voice wakeup , 1 means bluetooth key press wakeup， 2 means auto mic wakeup 】");
        f r1 = H3();
        if (r1 == null) goto L8;
        r1.j();
    L8:
        this.P = -1;
        this.Q = null;
        Set r2 = com.obric.assistant.common.utils.p.a;
        if (com.obric.assistant.common.utils.p.e(getContext()) == true) goto L11;
    L15:
        boolean r3 = Z3(r28, G3());
        int r4 = f0.a;
        boolean r14 = true;
        if (f0.a(getContext()) == false) goto L18;
        AudioServiceDelegate r5 = AudioServiceDelegate.a;
        if (r5.P().isRecording() == false) goto L35;
        r0.e("ChatClickTalkComponent", "canLaunchAssistant AiNoteManager.isRecording()");
        t0.a.post(new com.obric.assistant.component.clicktalk.u(this));
        j4(false, "recording_started");
        boolean r6 = false;
    L36:
        if (r6 == true) goto L39;
        C3("blocked", "assistant_unavailable", r29);
        h4(r30);
        return;
    L39:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r7 = Ak();
        if (r7 != null) goto L42;
    L44:
        boolean r8 = false;
    L45:
        if (r8 == true) goto L54;
        IDoraWakeupService r9 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r9 != null) goto L49;
    L51:
        boolean r10 = false;
    L52:
        if (r10 == true) goto L54;
    L57:
        this.P = r26;
        this.Q = r27;
        boolean r11 = gn();
        maa.g r12 = E3();
        if (r12 == null) goto L60;
        boolean r13 = r12.L4();
    L61:
        if (r11 == false) goto L66;
        if (r13 == true) goto L64;
        maa.e.a.a(this, ExitClickSpeakerType.RESTART, null, false, 6);
    L64:
        t0.a.postDelayed(new c0(this, r26, r27, r28, r29, r30), 60);
        return;
    L66:
        IDoraWakeupService r15 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r15 != null) goto L69;
    L71:
        boolean r16 = false;
    L72:
        boolean r17 = r5.e0();
        IDoraWakeupService r18 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r18 == null) goto L75;
        Boolean r19 = Boolean.valueOf(r18.o());
    L76:
        r0.i("ChatClickTalkComponent", "open click talk, check dora vui: isDoraProxyWakeup: " + r16 + ", isDoraWakeup: " + r17 + ", isDoraInRadioPressing = " + r19);
        if (r16 == true) goto L91;
        if (r17 == false) goto L91;
        if (Intrinsics.areEqual(r19, Boolean.TRUE) == true) goto L91;
        IDoraWakeupService r20 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r20 != null) goto L84;
    L86:
        boolean r21 = false;
    L87:
        if (r21 == true) goto L91;
        r0.i("ChatClickTalkComponent", "open click talk from non-dora, stopVUI");
        IDoraWakeupService r22 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r22 == null) goto L91;
        r22.p();
        goto L91
    L84:
        if (r20.g() != true) goto L86;
        r21 = true;
    L91:
        d0 r23 = new d0(r17, r16, r3, r26, this, r28, r29, r30);
        Context r24 = getContext();
        ArrayList r25 = new ArrayList();
        Object[] r31 = {"android.permission.RECORD_AUDIO"};
        f06.b r32 = new f06.b("auto_cert_com_obric_assistant_component_clicktalk_ChatClickTalkComponent_android_content_Context_checkSelfPermission");
        g06.a r33 = (g06.a) ApiHookConfig.b.get(102608);
        if (r33 == null) goto L94;
        f06.a[] r34 = r33.i;
    L95:
        int r110 = r34.length;
        int r111 = 0;
    L97:
        if (r111 >= r110) goto L108;
        f06.a r112 = r34[r111];
        Object[] r210 = r31;
        f06.d r35 = r112.preInvoke(102608, "android/content/Context", "checkSelfPermission", r24, r31, "int", r32);     // Catch: Exception -> L106
        f06.b r211 = r32;
        if (r35.a == true) goto L110;
        r25.add(r112);     // Catch: Exception -> L117
    L110:
        if (r35.a == false) goto L112;
        int r36 = ((Integer) r35.b).intValue();
    L113:
        if (r36 == 0) goto L115;
        FLogger.a.i("ChatClickTalkComponent", "checkSelfPermission RECORD_AUDIO not granted");
        i2.b.a(s1a.a.getActivity(this), CollectionsKt.mutableListOf(new String[]{"android.permission.RECORD_AUDIO"}), new e0(this, r30, r23, r29));
        return;
    L115:
        FLogger.a.i("ChatClickTalkComponent", "checkSelfPermission RECORD_AUDIO has been granted");
        r23.invoke();
        return;
    L112:
        r36 = r24.checkSelfPermission("android.permission.RECORD_AUDIO");
    L107:
        r111 = r111 + 1;
        r31 = r210;
        r32 = r211;
    L106:
        r211 = r32;
        goto L107
    L108:
        r35 = new f06.d(false, null);
        goto L110
    L94:
        r34 = ApiHookConfig.d;
        goto L95
    L75:
        r19 = null;
        goto L76
    L69:
        if (r15.c() != true) goto L71;
        r16 = true;
        goto L72
    L60:
        r13 = false;
        goto L61
    L49:
        if (r9.o() != true) goto L51;
        r10 = true;
    L54:
        if (x3() == true) goto L57;
        C3("blocked", "audio_session_busy", r29);
        h4(r30);
        return;
    L42:
        if (r7.m0() != true) goto L44;
        r8 = true;
        goto L45
    L35:
        r0.e("ChatClickTalkComponent", "canLaunchAssistant true");
        r6 = true;
        goto L36
    L18:
        if (AudioServiceDelegate.a.e0() == false) goto L30;
        if (r3 == false) goto L30;
        IDoraWakeupService r37 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r37 != null) goto L23;
    L25:
        r14 = false;
    L26:
        if (r14 == true) goto L30;
        r0.i("ChatClickTalkComponent", "Network not available, close VUI session");
        IDoraWakeupService r38 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r38 == null) goto L30;
        r38.p();
        goto L30
    L23:
        if (r37.o() != true) goto L25;
    L30:
        t19.s r39 = t19.s.a;
        Application r40 = AppHost.a.getApplication();
        r39.getClass();
        t19.s.s(r40, 2131908080);
        j4(false, IInteractionStateService.WAKE_UP_SOURCE_OTHER);
        C3("blocked", "network_unavailable", r29);
        h4(r30);
        return;
    L11:
        if (com.obric.assistant.common.utils.y.e() == false) goto L13;
        r0.i("ChatClickTalkComponent", "tryOpenClickTalk skip mic-in-use intercept by ROM concurrent record optimize");
        goto L15
    L13:
        C3("blocked", "mic_in_use", r29);
        h4(r30);
    }

    public final Object rP(String r19, String r20, Map<String, String> r21, boolean r22, Continuation<? super maa.a> r23) {
        if ((r23 instanceof handleAutoMicAsrResult.1) == false) goto L7;
        handleAutoMicAsrResult.1 r5 = (handleAutoMicAsrResult.1) r23;
        int r6 = r5.label;
        if ((r6 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r5.label;
        String r9 = "o_auto_mic";
        if (r8 == 0) goto L14;
        if (r8 != 1) goto L13;
        long r1 = r5.J$0;
        Ref.ObjectRef r3 = (Ref.ObjectRef) r5.L$4;
        Ref.ObjectRef r10 = (Ref.ObjectRef) r5.L$3;
        Function1 r11 = (Function1) r5.L$2;
        com.obric.assistant.voice.a r13 = (com.obric.assistant.voice.a) r5.L$1;
        IObricAutoMicService r12 = (IObricAutoMicService) r5.L$0;
        ResultKt.throwOnFailure(r4);
        r9 = "o_auto_mic";
    L129:
        r3.element = r4;
        long r14 = System.currentTimeMillis() - r1;
        boolean r0 = o0.d((String) r10.element);
        FLogger.a.i("ChatClickTalkComponent", "onAsrResult..(@ RELAVANCE RESULT @) " + r0 + ", polishContent = " + ((String) r10.element) + ", cost time " + r14 + "  ");
        if (r0 == false) goto L144;
        String r2 = r13.a();
        Message r15 = this.n;
        if (r15 == null) goto L134;
        Map r16 = r15.getExt();
    L136:
        if (TypeIntrinsics.isMutableMap(r16) == false) goto L138;
        Map r17 = r16;
    L139:
        if (r17 == null) goto L141;
        String r18 = (String) r17.put(r9, r2);
    L141:
        r12.k(r13.a, true);
        return new maa.a(true, true, (String) r10.element);
    L138:
        r17 = null;
        goto L139
    L134:
        r16 = null;
        goto L136
    L144:
        if (AudioServiceDelegate.a.e0() == false) goto L162;
        IDoraWakeupService r24 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r24 != null) goto L148;
    L150:
        boolean r25 = false;
    L151:
        if (r25 == true) goto L162;
        IDoraWakeupService r26 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r26 != null) goto L155;
    L157:
        boolean r27 = false;
    L158:
        if (r27 == true) goto L162;
        IDoraWakeupService r28 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r28 == null) goto L162;
        r28.p();
        goto L162
    L155:
        if (r26.g() != true) goto L157;
        r27 = true;
        goto L158
    L148:
        if (r24.o() != true) goto L150;
        r25 = true;
    L162:
        r11.invoke("relavance check failed !");
        r12.k(r13.a, false);
        return new maa.a(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        IObricAutoMicService.a.getClass();
        IObricAutoMicService r29 = IObricAutoMicService.a.a();
        if (r29 != null) goto L17;
    L19:
        boolean r30 = false;
    L20:
        if (r30 == false) goto L22;
        com.obric.assistant.voice.a r31 = r29.b(r19);
        if (r31 == null) goto L165;
        if (r31.d == ContentStatus.VOICE_AUTHEN) goto L28;
    L32:
        boolean r110 = false;
    L33:
        if (r110 == false) goto L35;
        r13 = r31;
    L36:
        if (r13 == null) goto L165;
        ContentScene r32 = r13.a;
        if (r32 != ContentScene.AI_ACTIVE_ASK) goto L51;
        String r33 = r13.a();
        Message r34 = this.n;
        if (r34 == null) goto L42;
        Map r35 = r34.getExt();
    L44:
        if (TypeIntrinsics.isMutableMap(r35) == false) goto L46;
        Map r36 = r35;
    L47:
        if (r36 == null) goto L49;
        String r37 = (String) r36.put("o_auto_mic", r33);
    L49:
        r29.i(r13.a, "endpoint");
        r29.a();
        r29.h(r19);
        return new maa.a(true, true, r20);
    L46:
        r36 = null;
        goto L47
    L42:
        r35 = null;
        goto L44
    L51:
        r29.i(r32, "endpoint");
        if (r22 == false) goto L62;
        if (r21 == null) goto L55;
        String r111 = r21.get("is_pvad");
    L57:
        if (Intrinsics.areEqual(r111, "true") == true) goto L59;
    L61:
        boolean r112 = false;
    L63:
        if (r21 == null) goto L65;
        String r113 = r21.get("is_speaker_match");
    L66:
        boolean r114 = Intrinsics.areEqual(r113, "true");
        if (r21 == null) goto L69;
        String r38 = r21.get("is_second_speaker_match");
    L70:
        boolean r39 = Intrinsics.areEqual(r38, "true");
        if (r21 == null) goto L73;
        String r40 = r21.get("sv_info");
    L75:
        if ((r40 instanceof String) == true) goto L78;
        r40 = null;
    L78:
        int r41 = com.obric.assistant.automic.h.a;
        if (o0.d(r40) == false) goto L86;
        int r42 = c.a;
        Intrinsics.checkNotNull(r40);
        Intrinsics.checkNotNullParameter(r40, "str");
        c r43 = (c) GsonProtectorUtils.fromJson(new Gson(), r40, c.class);
        Intrinsics.checkNotNull(r43);
        Float r44 = r43.a();
        if (r44 == null) goto L83;
        float r45 = r44.floatValue();
    L84:
        FLogger.a.i("ChatClickTalkComponent", "onAsrResult.. svScore is " + r45 + " from svInfo " + r40);
        goto L86
    L83:
        r45 = 0.0f;
    L86:
        if (r114 == true) goto L89;
        if (r39 == false) goto L89;
        int r46 = 1;
    L90:
        FLogger r47 = FLogger.a;
        r47.i("ChatClickTalkComponent", "onAsrResult.. pvadMatch " + r112 + " [Note: if pvad is true , might be enablePvad check is false, then ignore the pvad result , enablePvad? false]");
        ContentStatus r48 = ContentStatus.ASR_RESULT;
        Intrinsics.checkNotNullParameter(r48, "<set-?>");
        r13.d = r48;
        Function1 r49 = new com.obric.assistant.component.clicktalk.g(r13, this);
        if (r112 == true) goto L113;
        r47.i("ChatClickTalkComponent", "onAsrResult.. NOT CONTINUE !! caused by the speakerMatch enableSpeakerIdentify? false, 1stLevel? " + r114 + " 2ndLevel " + r39 + " or pvadMatch " + r112 + " isDebug " + ((Boolean) this.G.getValue()).booleanValue());
        if (AudioServiceDelegate.a.e0() == false) goto L111;
        IDoraWakeupService r50 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r50 != null) goto L97;
    L99:
        boolean r51 = false;
    L100:
        if (r51 == true) goto L111;
        IDoraWakeupService r52 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r52 != null) goto L104;
    L106:
        boolean r115 = false;
    L107:
        if (r115 == true) goto L111;
        IDoraWakeupService r53 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r53 == null) goto L111;
        r53.p();
        goto L111
    L104:
        if (r52.g() != true) goto L106;
        r115 = true;
        goto L107
    L97:
        if (r50.o() != true) goto L99;
        r51 = true;
    L111:
        r49.invoke("pvadMatch failed");
        return new maa.a(true);
    L113:
        r29.a();
        r29.h(r19);
        r47.i("ChatClickTalkComponent", "onAsrResult..START RELAVANCE PROCES ");
        Ref.ObjectRef r54 = new Ref.ObjectRef();
        long r116 = System.currentTimeMillis();
        StringBuilder r55 = new StringBuilder("onAsrResult..RELAVANCE PARAMS CHECK Q ");
        boolean r117 = com.obric.assistant.utils.j.a;
        if (r20 == null) goto L120;
        Charset r118 = Charsets.UTF_8;
        byte[] r119 = r20.getBytes(r118);
        if (Build.VERSION.SDK_INT < 26) goto L118;
        byte[] r56 = Base64.getEncoder().encode(r119);
    L119:
        Intrinsics.checkNotNull(r56);
        String r57 = new String(r56, r118);
    L121:
        r55.append(r57);
        r55.append(" , previouse Query ");
        r55.append(r13);
        r47.i("ChatClickTalkComponent", r55.toString());
        if (r20 != null) goto L124;
        String r58 = "";
    L125:
        r5.L$0 = r29;
        r5.L$1 = r13;
        r5.L$2 = r49;
        r5.L$3 = r54;
        r5.L$4 = r54;
        r5.I$0 = r46;
        r5.J$0 = r116;
        r5.label = 1;
        Object r59 = r29.g(r58, r13, r5);
        if (r59 != r7) goto L128;
        return r7;
    L128:
        r3 = r54;
        r10 = r3;
        r12 = r29;
        r11 = r49;
        r1 = r116;
        r4 = r59;
        goto L129
    L124:
        r58 = r20;
        goto L125
    L118:
        r56 = new byte[0];
        goto L119
    L120:
        r57 = null;
    L89:
        r46 = 0;
        goto L90
    L73:
        r40 = null;
        goto L75
    L69:
        r38 = null;
        goto L70
    L65:
        r113 = null;
        goto L66
    L59:
        if (o0.d(r20) == false) goto L61;
    L55:
        r111 = null;
    L62:
        r112 = true;
        goto L63
    L35:
        r13 = null;
        goto L36
    L28:
        if (r31.a != ContentScene.AI_ACTIVE_ASK) goto L30;
    L31:
        r110 = true;
        goto L33
    L30:
        if (o0.d(r31.b) == false) goto L32;
    L165:
        return new maa.a(false);
    L22:
        return new maa.a(false);
    L17:
        if (r29.f() != true) goto L19;
        r30 = true;
    L7:
        r5 = new handleAutoMicAsrResult.1(this, r23);
        goto L8
    }

    public final void c4(String r18, String r19, Integer r20, VoiceInputType r21, String r22, a r23) {
        if (p3(r23) == false) goto L5;
        return;
    L5:
        FLogger r0 = FLogger.a;
        r0.i("ChatClickTalkComponent", "onPermissionGranted");
        d r4 = V3();
        if (r4 != null) goto L8;
    L10:
        boolean r5 = false;
    L11:
        Integer r7 = null;
        if (r5 == false) goto L25;
        y r6 = u0();
        if (r6 == null) goto L16;
        wc9.e r8 = r6.h();
    L17:
        if (r8 == null) goto L23;
        y r9 = u0();
        if (r9 == null) goto L21;
        BotModel r10 = r9.j0();
    L22:
        if (r10 != null) goto L25;
    L21:
        r10 = null;
    L23:
        r0.e("ChatClickTalkComponent", "onPermissionGranted error, conversation or bot is null");
        C3("dropped", "chat_context_unavailable", r22);
        h4(r23);
        return;
    L16:
        r8 = null;
    L25:
        ObricRealtimeCallServiceDelegate r11 = ObricRealtimeCallServiceDelegate.b;
        y r12 = u0();
        if (r12 == null) goto L30;
        BotModel r13 = r12.j0();
        if (r13 == null) goto L30;
        Integer r14 = r13.getBotType();
    L32:
        if (r11.d(r14) == false) goto L41;
        t19.s.a.g(getContext(), 2131901013, false);
        StringBuilder r15 = new StringBuilder("type:");
        y r16 = u0();
        if (r16 == null) goto L38;
        BotModel r17 = r16.j0();
        if (r17 == null) goto L38;
        r7 = r17.getBotType();
    L38:
        r15.append(r7);
        r15.append("【Downgrade】");
        r0.e("ChatClickTalkComponent", r15.toString());
        j4(false, IInteractionStateService.WAKE_UP_SOURCE_OTHER);
        C3("blocked", "realtime_call_downgraded", r22);
        h4(r23);
        return;
    L41:
        if (AudioServiceDelegate.a.isDoraConnected() == false) goto L46;
        if (Z3(r20, G3()) == false) goto L46;
        this.J = true;
    L47:
        j4(true, null);
        String r24 = Q3();
        AutoHalfDuplexModeServiceDelegate r25 = AutoHalfDuplexModeServiceDelegate.b;
        y r26 = u0();
        if (r26 == null) goto L50;
        String r27 = r26.Y1();
    L51:
        r25.start(r24, r27);
        Runnable r28 = this.R;
        if (r28 == null) goto L54;
        t0.a.removeCallbacks(r28);
    L54:
        Runnable r29 = new com.obric.assistant.component.clicktalk.n(this, r24);
        this.R = r29;
        Handler r110 = t0.a;
        Intrinsics.checkNotNull(r29);
        r110.postDelayed(r29, 200);
        if (this.P != 4) goto L58;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new onPermissionGranted.3(null), 2, null);
    L58:
        if (p3(r23) == false) goto L61;
        return;
    L61:
        if (p3(r23) == true) goto L65;
        r0.i("ChatClickTalkComponent", "realStart with enterMethod " + r18 + " , callID : " + r19);
        r110.post(new com.obric.assistant.component.clicktalk.v(this, r23, r22, r21, r19, r18, r20));
        return;
    L65:
        return;
    L50:
        r27 = null;
    L46:
        d4(false);
    L30:
        r14 = null;
        goto L32
    L8:
        if (r4.Da() != true) goto L10;
        r5 = true;
        goto L11
    }

    public static final void h3(ChatClickTalkComponent r11, String r12, String r13, Integer r14, VoiceInputType r15, String r16, a r17) {
        if (r11.p3(r17) == true) goto L18;
        FLogger.a.i("ChatClickTalkComponent", "openClickTalk enterMethod:" + r12 + " callID:" + r13 + ", vuiId = " + r14);
        if (i3.a.i() == false) goto L9;
        r11.C3("blocked", "login_required", r16);
        i3.j(TriggerLoginScene.TRIGGER_LOGIN_CLICK_CALL, null, null, 6);
        r11.h4(r17);
        return;
    L9:
        if (r11.p3(r17) == true) goto L19;
        List r8 = CollectionsKt.listOf("android.permission.RECORD_AUDIO");
        if (ContextCompat.checkSelfPermission(r11.getContext(), "android.permission.RECORD_AUDIO") == 0) goto L14;
        i2 r0 = i2.b;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        i2.q(com.larus.ui.arch.component.internal.attach.a.b(r11, r11), r8, new com.obric.assistant.component.clicktalk.h(r11, r17, r12, r13, r14, r15, r16));
        return;
    L14:
        r11.c4(r12, r13, r14, r15, r16, r17);
        return;
    L19:
        return;
    }
}
