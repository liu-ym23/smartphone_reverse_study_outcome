package com.obric.audio.continuous_talk;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.asr.VoiceInputType;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.IFlowTtsClientService;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.DoraConfig;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.i2;
import com.larus.platform.service.i3;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricAssistantBaseServiceDelegate;
import com.obric.assistant.audio.service.ObricAssistantForAudioDelegate;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.h1;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.interaction.impl.activityresult.ActivityProxyRequestStoreKt;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.spi.dora.IDoraWakeupService;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import com.obric.assistant.t1;
import com.obric.assistant.voice.IObricVoiceService;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraWearState;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\b*\u0002F]\u0018\u0000 ³\u00012\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0002³\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010H\u001a\u00020I2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020I0KH\u0016J\n\u0010V\u001a\u0004\u0018\u00010DH\u0002J\"\u0010W\u001a\u00020I2\u0006\u0010X\u001a\u00020D2\u0006\u0010Y\u001a\u00020D2\b\u0010Z\u001a\u0004\u0018\u00010DH\u0002J\u0012\u0010[\u001a\u00020I2\b\u0010Z\u001a\u0004\u0018\u00010DH\u0002JS\u0010_\u001a\u00020I2\b\u0010`\u001a\u0004\u0018\u00010D2\b\u0010a\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010M2\b\b\u0002\u0010c\u001a\u00020d2\b\b\u0002\u0010e\u001a\u00020A2\b\u0010f\u001a\u0004\u0018\u00010D2\u0006\u0010Q\u001a\u00020DH\u0002¢\u0006\u0002\u0010gJ\b\u0010h\u001a\u00020IH\u0003J\u0013\u0010i\u001a\u0004\u0018\u00010M*\u00020\u000bH\u0002¢\u0006\u0002\u0010jJ\u000f\u0010k\u001a\u0004\u0018\u00010MH\u0002¢\u0006\u0002\u0010lJ\u0016\u0010m\u001a\u00020A*\u00020\u000b2\b\b\u0002\u0010n\u001a\u00020AH\u0002J\f\u0010o\u001a\u00020A*\u00020\u000bH\u0002J\f\u0010p\u001a\u00020M*\u00020\u000bH\u0002J\u0016\u0010q\u001a\u00020A*\u00020\u000b2\b\b\u0002\u0010n\u001a\u00020AH\u0002J\b\u0010r\u001a\u00020IH\u0002J5\u0010s\u001a\u00020I2\u0006\u0010t\u001a\u00020M2\u0014\u0010u\u001a\u0010\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020P\u0018\u00010O2\b\u0010b\u001a\u0004\u0018\u00010MH\u0017¢\u0006\u0002\u0010vJG\u0010s\u001a\u00020I2\u0006\u0010t\u001a\u00020M2\u0014\u0010u\u001a\u0010\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020P\u0018\u00010O2\b\u0010b\u001a\u0004\u0018\u00010M2\b\u0010f\u001a\u0004\u0018\u00010D2\u0006\u0010Q\u001a\u00020DH\u0003¢\u0006\u0002\u0010wJ6\u0010x\u001a\u00020I2\u0006\u0010y\u001a\u00020\u00072\u0014\u0010u\u001a\u0010\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020P\u0018\u00010O2\u0006\u0010z\u001a\u00020A2\u0006\u0010{\u001a\u00020AH\u0016J\u0010\u0010|\u001a\u00020A2\u0006\u0010t\u001a\u00020MH\u0016J\b\u0010}\u001a\u00020AH\u0016J\u001d\u0010\u0081\u0001\u001a\u00020I2\u0007\u0010\u0082\u0001\u001a\u00020A2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010DH\u0002J\u001c\u0010\u0084\u0001\u001a\u00020I2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010D2\u0006\u0010y\u001a\u00020DH\u0002JT\u0010\u0086\u0001\u001a\u00020I2\b\u0010`\u001a\u0004\u0018\u00010D2\b\u0010a\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010M2\b\b\u0002\u0010c\u001a\u00020d2\b\b\u0002\u0010e\u001a\u00020A2\b\u0010f\u001a\u0004\u0018\u00010D2\u0006\u0010Q\u001a\u00020DH\u0002¢\u0006\u0002\u0010gJ\t\u0010\u0087\u0001\u001a\u00020AH\u0002J\t\u0010\u0088\u0001\u001a\u00020IH\u0003J\u0013\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001H\u0082@¢\u0006\u0003\u0010\u008b\u0001J\u0013\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0082@¢\u0006\u0003\u0010\u008b\u0001JA\u0010\u008e\u0001\u001a\u0005\u0018\u0001H\u008f\u0001\"\u0005\b\u0000\u0010\u008f\u00012\t\b\u0002\u0010\u0090\u0001\u001a\u00020\u007f2\u001a\u0010J\u001a\u0016\u0012\f\u0012\n\u0012\u0005\u0012\u0003H\u008f\u00010\u0091\u0001\u0012\u0004\u0012\u00020I0KH\u0082@¢\u0006\u0003\u0010\u0092\u0001J\t\u0010\u0093\u0001\u001a\u00020IH\u0002J\t\u0010\u0094\u0001\u001a\u00020IH\u0002J\t\u0010\u0095\u0001\u001a\u00020IH\u0016J\t\u0010\u0096\u0001\u001a\u00020IH\u0016J\t\u0010\u0097\u0001\u001a\u00020IH\u0016J\t\u0010\u0098\u0001\u001a\u00020IH\u0016J\t\u0010\u0099\u0001\u001a\u00020IH\u0016J\t\u0010\u009a\u0001\u001a\u00020AH\u0002J\t\u0010\u009b\u0001\u001a\u00020IH\u0002J\t\u0010\u009c\u0001\u001a\u00020IH\u0002JT\u0010\u009d\u0001\u001a\u00020I2\b\u0010`\u001a\u0004\u0018\u00010D2\b\u0010a\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010M2\b\b\u0002\u0010c\u001a\u00020d2\b\b\u0002\u0010e\u001a\u00020A2\b\u0010f\u001a\u0004\u0018\u00010D2\u0006\u0010Q\u001a\u00020DH\u0002¢\u0006\u0002\u0010gJT\u0010\u009e\u0001\u001a\u00020I2\b\u0010`\u001a\u0004\u0018\u00010D2\b\u0010a\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010M2\b\b\u0002\u0010c\u001a\u00020d2\b\b\u0002\u0010e\u001a\u00020A2\b\u0010f\u001a\u0004\u0018\u00010D2\u0006\u0010Q\u001a\u00020DH\u0002¢\u0006\u0002\u0010gJ\u0012\u0010\u009f\u0001\u001a\u00020I2\u0007\u0010 \u0001\u001a\u00020DH\u0002J\u001e\u0010¡\u0001\u001a\u00020I2\u0013\u0010¢\u0001\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020I0KH\u0002J\u0012\u0010£\u0001\u001a\u0004\u0018\u00010DH\u0082@¢\u0006\u0003\u0010\u008b\u0001JT\u0010¤\u0001\u001a\u00020I2\b\u0010`\u001a\u0004\u0018\u00010D2\b\u0010a\u001a\u0004\u0018\u00010D2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010M2\b\b\u0002\u0010c\u001a\u00020d2\b\b\u0002\u0010e\u001a\u00020A2\b\u0010f\u001a\u0004\u0018\u00010D2\u0006\u0010Q\u001a\u00020DH\u0002¢\u0006\u0002\u0010gJ\u0011\u0010¥\u0001\u001a\u00020I2\u0006\u0010Q\u001a\u00020DH\u0002J\u001a\u0010¦\u0001\u001a\u00020I2\u0007\u0010§\u0001\u001a\u00020D2\u0006\u0010Q\u001a\u00020DH\u0002J\u001b\u0010¨\u0001\u001a\u00020I2\b\u0010f\u001a\u0004\u0018\u00010D2\u0006\u0010Q\u001a\u00020DH\u0002J\t\u0010©\u0001\u001a\u00020IH\u0016J\u0013\u0010ª\u0001\u001a\u00020I2\b\u0010«\u0001\u001a\u00030¬\u0001H\u0016J\t\u0010\u00ad\u0001\u001a\u00020IH\u0002J\u0012\u0010®\u0001\u001a\u00020I2\u0007\u0010¯\u0001\u001a\u00020\tH\u0002J\u0012\u0010°\u0001\u001a\u00020I2\u0007\u0010±\u0001\u001a\u00020AH\u0002J\t\u0010²\u0001\u001a\u00020DH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000f\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u000f\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\u0004\u0018\u00010*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u000f\u001a\u0004\b+\u0010,R\u001d\u0010.\u001a\u0004\u0018\u00010/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u000f\u001a\u0004\b0\u00101R\u001d\u00103\u001a\u0004\u0018\u0001048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u000f\u001a\u0004\b5\u00106R\u001d\u00108\u001a\u0004\u0018\u0001098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u000f\u001a\u0004\b:\u0010;R\u001d\u0010=\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u000f\u001a\u0004\b>\u0010'R\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010GR\u000e\u0010L\u001a\u00020MX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010N\u001a\u0010\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020P\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u00020]X\u0082\u000e¢\u0006\u0004\n\u0002\u0010^R\u000e\u0010~\u001a\u00020\u007fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006´\u0001"}, d2 = {"Lcom/obric/audio/continuous_talk/ObricContinuousTalkCtrlComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/obric/audio/continuous_talk/IObricContinuousTalkCtrlAbility;", "<init>", "()V", "continuousTalkEndType", "Lcom/obric/audio/continuous_talk/ObricContinuousTalkEndType;", "lastDoraGWearState", "Lcom/obric/assistant/wakeup/co_wakeup/dora/model/DoraWearState;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "chatListAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListAbility$delegate", "instructionAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionAbility$delegate", "obricContinuousTalkAbility", "Lcom/obric/audio/continuous_talk/IObricContinuousTalkAbility;", "getObricContinuousTalkAbility", "()Lcom/obric/audio/continuous_talk/IObricContinuousTalkAbility;", "obricContinuousTalkAbility$delegate", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "intercomAbility", "Lcom/obric/assistant/ability/IObricIntercomAbility;", "getIntercomAbility", "()Lcom/obric/assistant/ability/IObricIntercomAbility;", "intercomAbility$delegate", "attachmentAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentAbility$delegate", "instructionInputAbility", "getInstructionInputAbility", "instructionInputAbility$delegate", "messageListClipToPadding", "", "isDoraWakeup", "curCallId", "", "appBackgroundListener", "com/obric/audio/continuous_talk/ObricContinuousTalkCtrlComponent$appBackgroundListener$1", "Lcom/obric/audio/continuous_talk/ObricContinuousTalkCtrlComponent$appBackgroundListener$1;", "getBotId", "", "callback", "Lkotlin/Function1;", "wakeupFrom", "", "wakeupArgs", "", "", "startupRequestToken", "pendingStartupAttemptId", "pendingWakeupPauseCloseRunnable", "Ljava/lang/Runnable;", "pendingWakeupPauseCloseRequestToken", "captureStartupAttempt", "finishStartupAttempt", WindowEvent.Params.RESULT, WindowEvent.Params.REASON, "attemptId", "replacePendingStartupAttempt", "netWorkCallback", "com/obric/audio/continuous_talk/ObricContinuousTalkCtrlComponent$netWorkCallback$1", "Lcom/obric/audio/continuous_talk/ObricContinuousTalkCtrlComponent$netWorkCallback$1;", "openContinuousTalk", "enterMethod", "callID", "vuiId", "voiceInputType", "Lcom/larus/asr/VoiceInputType;", "breathWakeup", "startupAttemptId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/asr/VoiceInputType;ZLjava/lang/String;Ljava/lang/String;)V", "tryStartContinuousTalk", "getVuiId", "(Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;)Ljava/lang/Integer;", "getCurrentVoiceWakeupId", "()Ljava/lang/Integer;", "isWakeUp", "remove", "isAutoMic", "getWakeupFrom", "isLongPressAi", "tryInterruptCurConv", "tryOpenContinuousTalk", "type", "args", "(ILjava/util/Map;Ljava/lang/Integer;)V", "(ILjava/util/Map;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "closeContinuousTalk", "endType", "endDoraSession", "immediately", "shouldOpenChatClickTalk", "isSpeaking", "startTimeStamp", "", "traceStarted", "traceContinuousTalkStart", WindowEvent.WindowOpenPerfResult.SUCCESS, "failType", "traceContinuousTalkEnd", "messageId", "prepareAndOpenContinuousTalk", "canLaunchAssistant", "playEndSound", "observeBotModel", "Lcom/larus/im/bean/bot/BotModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeConversation", "Lcom/larus/im/bean/conversation/Conversation;", "suspendCoroutine", "T", "timeMillis", "Lkotlinx/coroutines/CancellableContinuation;", "(JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverInputArea", "recoverChatPage", "onAttach", "onParentViewCreated", "onResume", "onPause", "onStop", "shouldDeferPendingWakeupClose", "schedulePendingWakeupPauseClose", "cancelPendingWakeupPauseClose", "checkAudioPermission", "onPermissionGranted", "enterAutoHalfDuplexMode", "botId", "handleBotOperations", "onBotAvailable", "fetchBotIfNeeded", "realStart", "rollbackContinuousTalkStartFailure", "onFinishCall", "endMethod", "onPermissionDenied", "onDestroy", "onViewCreated", "view", "Landroid/view/View;", "observeDoraGWearState", "handleDoraGWearStateChanged", "wearState", "operateDoraVUI", "enable", "getMainBotId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricContinuousTalkCtrlComponent extends BaseContentWidget implements com.obric.audio.continuous_talk.c {
    public static final /* synthetic */ int L = 0;
    public String A;
    public final c B;
    public int C;
    public Map<String, Object> D;
    public volatile String E;
    public volatile String F;
    public v G;
    public String H;
    public final d I;
    public long J;
    public boolean K;
    public DoraWearState m;
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
    public final boolean y;
    public boolean z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ObricContinuousTalkEndType.values().length];
            r0[ObricContinuousTalkEndType.TIMEOUT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[ObricContinuousTalkEndType.INTERRUPT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[ObricContinuousTalkEndType.MANUAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ObricContinuousTalkEndType.RESTART.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[ObricContinuousTalkEndType.DESTROY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[ObricContinuousTalkEndType.PAUSE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[ObricContinuousTalkEndType.STOP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[ObricContinuousTalkEndType.MEDIA_INTERRUPT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    public static final class c implements f09.a.b {
        public final /* synthetic */ ObricContinuousTalkCtrlComponent a;

        public final void onAppForeground() {
        }

        public final void onAllActivityDestroyed() {
            com.obric.audio.continuous_talk.c.a.a(this.a, ObricContinuousTalkEndType.DESTROY, null, false, true, 6);
        }

        public final void onAppBackground() {
            FLogger.a.i("ObricContinuousTalkCtrlComponent", "onAppBackground");
            com.obric.audio.continuous_talk.c.a.a(this.a, ObricContinuousTalkEndType.STOP, null, false, !t1.a.isTtsPlayBackgroundEnabled(), 6);
        }

        public c(ObricContinuousTalkCtrlComponent r1) {
            this.a = r1;
        }
    }

    public static final class d extends ConnectivityManager.NetworkCallback {
        public final /* synthetic */ ObricContinuousTalkCtrlComponent a;

        public d(ObricContinuousTalkCtrlComponent r1) {
            this.a = r1;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network r8) {
            Intrinsics.checkNotNullParameter(r8, "network");
            super.onLost(r8);
            if (this.a.m0() == false) goto L6;
            t19.s r9 = t19.s.a;
            Application r0 = AppHost.a.getApplication();
            r9.getClass();
            t19.s.s(r0, 2131908080);
            com.obric.audio.continuous_talk.c.a.a(this.a, ObricContinuousTalkEndType.NETWORK_ERROR, null, false, false, 14);
            return;
        }
    }

    public static final class e implements com.larus.bmhome.chat.component.cvs.y.a<BotModel> {
        public final /* synthetic */ ObricContinuousTalkCtrlComponent a;
        public final /* synthetic */ AtomicBoolean b;
        public final /* synthetic */ kotlinx.coroutines.i<BotModel> c;

        public final void c(Object r4) {
            BotModel r5 = (BotModel) r4;
            Intrinsics.checkNotNullParameter(r5, "new");
            ObricContinuousTalkCtrlComponent r0 = this.a;
            int r1 = ObricContinuousTalkCtrlComponent.L;
            com.larus.bmhome.chat.component.cvs.y r2 = r0.u0();
            if (r2 == null) goto L6;
            r2.lQ(this);
        L6:
            if (this.b.compareAndSet(false, true) == false) goto L9;
            this.c.resumeWith(Result.constructor-impl(r5));
            return;
        }

        public e(ObricContinuousTalkCtrlComponent r1, AtomicBoolean r2, kotlinx.coroutines.i<? super BotModel> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class f implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
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

    public static final class g implements Function0<com.larus.bmhome.chat.component.cvs.y> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
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

    public static final class h implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
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

    public static final class i implements Function0<va8.o> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
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

    public static final class j implements Function0<u7> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
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

    public static final class k implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
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

    public static final class l implements Function0<com.obric.audio.continuous_talk.b> {
        public final /* synthetic */ AttachReceiver a;

        public l(AttachReceiver r1) {
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

    public static final class m implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public m(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class n implements Function0<laa.f> {
        public final /* synthetic */ AttachReceiver a;

        public n(AttachReceiver r1) {
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

    public static final class o implements Function0<g1> {
        public final /* synthetic */ AttachReceiver a;

        public o(AttachReceiver r1) {
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

    static {
    }

    public final void B2() {
    }

    public final void onViewCreated(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    public final com.obric.audio.continuous_talk.b C3() {
        return (com.obric.audio.continuous_talk.b) this.t.getValue();
    }

    public final void V3() {
        va8.o r0 = (va8.o) this.q.getValue();
        if (r0 == null) goto L5;
        r0.nX();
    L5:
        u7 r1 = (u7) this.r.getValue();
        if (r1 == null) goto L8;
        r1.tU(0);
    L8:
        u7 r2 = (u7) this.r.getValue();
        if (r2 == null) goto L11;
        u7.a.a(r2, this.y);
    L11:
        com.larus.bmhome.instruction.g r3 = (com.larus.bmhome.instruction.g) this.s.getValue();
        if (r3 == null) goto L15;
        r3.vW(true);
        return;
    }

    public final de8.c f1() {
        return (de8.c) this.n.getValue();
    }

    public final void m3() {
        v r0 = this.G;
        if (r0 == null) goto L5;
        com.larus.utils.t0.a.removeCallbacks(r0);
    L5:
        this.G = null;
        this.H = null;
    }

    public final void onDestroy() {
        com.obric.audio.continuous_talk.c.a.a(this, ObricContinuousTalkEndType.DESTROY, null, false, true, 6);
        AppHost.Companion r0 = AppHost.a;
        r0.a().c(this.B);
        Object r1 = r0.getApplication().getSystemService("connectivity");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ((ConnectivityManager) r1).unregisterNetworkCallback(this.I);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.obric.audio.continuous_talk.v, java.lang.Runnable] */
    public final void onPause() {
        FLogger r0 = FLogger.a;
        r0.i("ObricContinuousTalkCtrlComponent", "onPause");
        IAssistantChatWindow r2 = IAssistantChatWindowKt.getAssistantChatWindow();
        boolean r3 = false;
        if (r2 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L10;
    L20:
        if (r3 == false) goto L25;
        final String r5 = this.E;
        if (r5 == null) goto L28;
        m3();
        this.H = r5;
        ?? r6 = new v(this, r5);
        this.G = r6;
        com.larus.utils.t0.a.postDelayed(r6, 200);
        r0.i("ObricContinuousTalkCtrlComponent", "delay pending wakeup close after onPause, requestToken=".concat(r5));
        return;
    L28:
        return;
    L25:
        com.obric.audio.continuous_talk.c.a.a(this, ObricContinuousTalkEndType.PAUSE, null, false, false, 6);
        return;
    L10:
        if (this.C != 0) goto L20;
        if (this.E == null) goto L20;
        com.obric.audio.continuous_talk.b r7 = C3();
        if (r7 == null) goto L16;
        ContinuousTalkStatus r8 = r7.u10();
    L18:
        if (r8 != ContinuousTalkStatus.STOPPED) goto L20;
        r3 = true;
        goto L20
    L16:
        r8 = null;
        goto L18
    L5:
        if (r2.isWindowMode() != true) goto L7;
        r4 = true;
        goto L8
    }

    public final com.larus.bmhome.chat.component.cvs.y u0() {
        return (com.larus.bmhome.chat.component.cvs.y) this.o.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.obric.audio.continuous_talk.c.class);
        AppHost.Companion r0 = AppHost.a;
        Object r1 = r0.getApplication().getSystemService("connectivity");
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ((ConnectivityManager) r1).registerNetworkCallback(new NetworkRequest.Builder().build(), this.I);
        r0.a().j(this.B);
        FLogger.a.i("ObricContinuousTalkCtrlComponent", "observeDoraGWearState");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricContinuousTalkCtrlComponent$observeDoraGWearState$1(this, null), 3, null);
    }

    public final Integer z3() {
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

    public ObricContinuousTalkCtrlComponent() {
        ObricContinuousTalkEndType r0 = ObricContinuousTalkEndType.TIMEOUT;
        this.m = DoraWearState.NA;
        this.n = LazyKt.lazy(new u(this));
        this.o = LazyKt.lazy(new g(this));
        this.p = LazyKt.lazy(new h(this));
        this.q = LazyKt.lazy(new i(this));
        this.r = LazyKt.lazy(new j(this));
        this.s = LazyKt.lazy(new k(this));
        this.t = LazyKt.lazy(new l(this));
        this.u = LazyKt.lazy(new m(this));
        this.v = LazyKt.lazy(new n(this));
        this.w = LazyKt.lazy(new o(this));
        this.x = LazyKt.lazy(new f(this));
        this.y = true;
        this.B = new c(this);
        this.C = -1;
        this.D = new LinkedHashMap();
        this.I = new d(this);
    }

    public final String B3() {
        com.larus.bmhome.chat.component.cvs.y r0 = u0();
        if (r0 == null) goto L9;
        BotModel r1 = r0.j0();
        if (r1 == null) goto L9;
        String r2 = r1.getBotId();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return DoraConfig.g();
    }

    @Override // com.obric.audio.continuous_talk.c
    public final boolean m0() {
        com.obric.audio.continuous_talk.b r0 = C3();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.m0() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void onResume() {
        m3();
        if (qO(-1) == true) goto L42;
        Bundle r0 = f1().b;
        Integer r3 = null;
        if (r0 == null) goto L7;
        String r1 = r0.getString("wakeup_source", "");
    L8:
        boolean r2 = Intrinsics.areEqual(r1, IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC);
        de8.c r4 = f1();
        boolean r5 = !r2;
        Bundle r6 = r4.b;
        if (r6 == null) goto L11;
        boolean r7 = r6.getBoolean("arg_wakeup", false);
    L12:
        if (r5 == false) goto L16;
        Bundle r8 = r4.b;
        if (r8 == null) goto L16;
        r8.remove("arg_wakeup");
    L16:
        de8.c r9 = f1();
        Bundle r10 = r9.b;
        if (r10 == null) goto L19;
        boolean r11 = r10.getBoolean("arg_long_press_ai", false);
    L20:
        if (r5 == false) goto L24;
        Bundle r12 = r9.b;
        if (r12 == null) goto L24;
        r12.remove("arg_long_press_ai");
    L24:
        Bundle r13 = f1().b;
        if (r13 == null) goto L27;
        String r14 = r13.getString("wakeup_source", "");
    L28:
        int r15 = h1.a(r14, 0);
        FLogger.a.i("ObricContinuousTalkCtrlComponent", "wakeUp = " + r7 + ", type = " + r15 + ", chatArgumentData.isAutoOpenCamera() = " + f1().v() + ", isLongPressAi = " + r11 + " isAutoMic " + r2);
        if (r7 == true) goto L31;
        return;
    L31:
        if (f1().v() == true) goto L44;
        if (r11 == true) goto L45;
        if (r2 == true) goto L46;
        de8.c r16 = f1();
        Bundle r17 = r16.b;
        if (r17 == null) goto L37;
        r3 = Integer.valueOf(r17.getInt("arg_vuiid", 0));
    L37:
        Bundle r18 = r16.b;
        if (r18 == null) goto L40;
        r18.remove("arg_vuiid");
    L40:
        com.obric.audio.continuous_talk.c.a.b(this, r15, r3, 2);
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L27:
        r14 = null;
        goto L28
    L19:
        r11 = false;
        goto L20
    L11:
        r7 = false;
        goto L12
    L7:
        r1 = null;
        goto L8
    }

    public final void onStop() {
        m3();
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onStop wakeupFrom ");
        r1.append(this.C);
        r1.append(" AppHost.activityStackManager.currentActivity ");
        AppHost.Companion r2 = AppHost.a;
        r1.append(r2.a().getCurrentActivity());
        r0.i("ObricContinuousTalkCtrlComponent", r1.toString());
        if (r2.a().getCurrentActivity() != null) goto L5;
        com.obric.audio.continuous_talk.c.a.a(this, ObricContinuousTalkEndType.STOP, null, false, false, 6);
    L6:
        IObricChatService.a.getClass();
        IObricChatService r3 = IObricChatService.a.a();
        if (r3 == null) goto L10;
        r3.onStop();
        return;
    L10:
        return;
    L5:
        com.obric.audio.continuous_talk.c.a.a(this, ObricContinuousTalkEndType.STOP, null, false, true, 6);
        goto L6
    }

    public final Object D3(Continuation<? super BotModel> r6) {
        Function1 r0 = new w(this);
        return TimeoutKt.c(RangesKt.coerceAtLeast(ActivityProxyRequestStoreKt.PROXY_CREATE_TIMEOUT_MS, 0), new ObricContinuousTalkCtrlComponent$suspendCoroutine$2(r0, null), r6);
    }

    public final void H3(final boolean r5) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("operateDoraVUI enable vui : ");
        r1.append(r5);
        r1.append(" , connected ? ");
        AudioServiceDelegate r2 = AudioServiceDelegate.a;
        r1.append(r2.isDoraConnected());
        r0.i("ObricContinuousTalkCtrlComponent", r1.toString());
        if (r2.isDoraConnected() == false) goto L6;
        r0.a.a(new q(this, r5));
        return;
    }

    public final synchronized void W3(String r2) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (Intrinsics.areEqual(this.E, r2) == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.E = null;     // Catch: Throwable -> L20
        this.F = null;     // Catch: Throwable -> L20
        IDoraWakeupService r3 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);     // Catch: Throwable -> L20
        if (r3 == null) goto L12;
        r3.i(false);     // Catch: Throwable -> L20
    L12:
        if (this.z == true) goto L14;
        H3(true);     // Catch: Throwable -> L20
    L15:
        X3(IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER);     // Catch: Throwable -> L20
        V3();     // Catch: Throwable -> L20
        this.C = -1;     // Catch: Throwable -> L20
        Map<String, Object> r4 = this.D;     // Catch: Throwable -> L20
        if (r4 == null) goto L18;
        r4.clear();     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return;
    L14:
        this.z = false;     // Catch: Throwable -> L20
        goto L15
    }

    public final void X3(String r8) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.K == false) goto L10;
        this.K = false;     // Catch: Throwable -> L13
        String r0 = B3();     // Catch: Throwable -> L13
        com.larus.bmhome.chat.component.cvs.y r1 = u0();     // Catch: Throwable -> L13
        if (r1 == null) goto L8;
        String r2 = r1.Y1();     // Catch: Throwable -> L13
    L9:
        d0.b(r0, r2, this.A, r8, Integer.valueOf((int) (SystemClock.elapsedRealtime() - this.J)));     // Catch: Throwable -> L13
        goto L10
    L8:
        r2 = null;
    L10:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    @Override // com.obric.audio.continuous_talk.c
    public final boolean qO(int r11) {
        boolean r1 = true;
        if (t1.a.N() == true) goto L5;
        return true;
    L5:
        Bundle r0 = f1().b;
        if (r0 == null) goto L8;
        boolean r2 = r0.getBoolean("arg_wakeup", false);
    L9:
        if (r2 == false) goto L17;
        Bundle r3 = f1().b;
        if (r3 == null) goto L13;
        String r4 = r3.getString("wakeup_source", "");
    L15:
        if (h1.a(r4, 0) != 3) goto L17;
        boolean r5 = true;
    L18:
        boolean r6 = ObricAssistantForAudioDelegate.b.O4();
        laa.d r7 = (laa.d) this.u.getValue();
        if (r7 != null) goto L21;
    L23:
        boolean r8 = false;
    L24:
        g1 r9 = (g1) this.w.getValue();
        if (r9 == null) goto L29;
        List r10 = r9.q1();
        if (r10 == null) goto L29;
        int r12 = r10.size();
    L30:
        if (r12 <= 0) goto L32;
        boolean r13 = true;
    L33:
        com.larus.bmhome.instruction.g r14 = (com.larus.bmhome.instruction.g) this.x.getValue();
        if (r14 != null) goto L36;
    L38:
        boolean r15 = false;
    L39:
        boolean r16 = SetsKt.setOf(new Integer[]{4, 2}).contains(Integer.valueOf(r11));
        if (r5 == true) goto L48;
        if (r6 == true) goto L48;
        if (r8 == false) goto L48;
        if (r13 == true) goto L48;
        if (r15 == true) goto L48;
        if (r16 == true) goto L48;
        r1 = false;
    L48:
        FLogger.a.i("ObricContinuousTalkCtrlComponent", "shouldOpenChatClickTalk " + r1);
        return r1;
    L36:
        if (r14.z0() != true) goto L38;
        r15 = true;
        goto L39
    L32:
        r13 = false;
    L29:
        r12 = 0;
        goto L30
    L21:
        if (r7.Da() != true) goto L23;
        r8 = true;
        goto L24
    L13:
        r4 = null;
    L17:
        r5 = false;
        goto L18
    L8:
        r2 = false;
        goto L9
    }

    public static final Object Y2(ObricContinuousTalkCtrlComponent r4, Continuation r5) {
        r4.getClass();
        if ((r5 instanceof ObricContinuousTalkCtrlComponent$fetchBotIfNeeded$1) == false) goto L7;
        ObricContinuousTalkCtrlComponent$fetchBotIfNeeded$1 r0 = (ObricContinuousTalkCtrlComponent$fetchBotIfNeeded$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
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
        FLogger.a.i("ObricContinuousTalkCtrlComponent", "Fetched botId: " + r8);
        return r8;
    L22:
        r8 = null;
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        String r9 = r4.B3();
        if (r9 != null) goto L25;
        r0.label = 1;
        r6 = r4.D3(r0);
        if (r6 != r2) goto L19;
        return r2;
    L25:
        return r9;
    L7:
        r0 = new ObricContinuousTalkCtrlComponent$fetchBotIfNeeded$1(r4, r5);
        goto L8
    }

    public final synchronized void E3(String r2, String r3) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (Intrinsics.areEqual(this.E, r3) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        Z3(false, ObricAssistantForAudioDelegate.b.d5());     // Catch: Throwable -> L10
        p3("blocked", "record_audio_denied", r2);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final void Z3(boolean r7, String r8) {
        monitor-enter(this);
        boolean r2 = !this.K;     // Catch: Throwable -> L17
        if (r2 == false) goto L7;
        FLogger.a.i("ObricContinuousTalkCtrlComponent", "traceClickTalkStart will go on ,traceStarted:" + this.K + " , success: " + r7 + " and failedType: " + r8);     // Catch: Throwable -> L17
    L8:
        if (r2 == false) goto L14;
        this.K = true;     // Catch: Throwable -> L17
        this.J = SystemClock.elapsedRealtime();     // Catch: Throwable -> L17
        String r0 = B3();     // Catch: Throwable -> L17
        com.larus.bmhome.chat.component.cvs.y r1 = u0();     // Catch: Throwable -> L17
        if (r1 == null) goto L12;
        String r3 = r1.Y1();     // Catch: Throwable -> L17
    L13:
        d0.c(r0, r3, this.A, r7, r8);     // Catch: Throwable -> L17
        goto L14
    L12:
        r3 = null;
    L14:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L7:
        FLogger.a.i("ObricContinuousTalkCtrlComponent", "traceClickTalkStart will not go on ,traceStarted:" + this.K + " , success: " + r7 + " and failedType: " + r8);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.audio.continuous_talk.c
    public final synchronized void Yd(int r8, Map<String, Object> r9, Integer r10) {
        monitor-enter(this);
        String r6 = UUID.randomUUID().toString();     // Catch: Throwable -> L38
        Bundle r0 = f1().b;     // Catch: Throwable -> L38
        String r2 = null;
        if (r0 == null) goto L13;
        String r1 = r0.getString("obric_startup_attempt_id");     // Catch: Throwable -> L38
        if (r1 == null) goto L13;
        if ((!StringsKt.isBlank(r1)) == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L13;
    L24:
        if (Intrinsics.areEqual(r1, AssistantStartupTelemetry.a.i("asr_record_ready")) == true) goto L27;
        r1 = null;
    L27:
        String r5 = r1;
    L28:
        this.E = r6;     // Catch: Throwable -> L38
        String r3 = this.F;     // Catch: Throwable -> L38
        if (r3 != null) goto L31;
    L35:
        this.F = r5;     // Catch: Throwable -> L38
        a4(r8, r9, r10, r5, r6);     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L31:
        if ((!Intrinsics.areEqual(r3, r5)) == false) goto L33;
        r2 = r3;
    L33:
        if (r2 == null) goto L35;
        p3("cancelled", "continuous_talk_replaced_before_start", r2);     // Catch: Throwable -> L38
    L13:
        Bundle r4 = f1().a;     // Catch: Throwable -> L38
        if (r4 == null) goto L20;
        r1 = r4.getString("obric_startup_attempt_id");     // Catch: Throwable -> L38
        if (r1 == null) goto L20;
        if ((!StringsKt.isBlank(r1)) == false) goto L20;
    L21:
        if (r1 != null) goto L24;
        r5 = null;
    L20:
        r1 = null;
    L38:
        th = move-exception;
        throw th;
    }

    public final void p3(String r7, String r8, String r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        IAssistantStartupTelemetry.a.a(AssistantStartupTelemetry.a, r9, r7, r8, null, 24);
        if (Intrinsics.areEqual(this.F, r9) == false) goto L8;
        this.F = null;
        return;
    }

    @Override // com.obric.audio.continuous_talk.c
    public final synchronized void f10(final ObricContinuousTalkEndType r20, Map<String, Object> r21, boolean r22, final boolean r23) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r20, "endType");     // Catch: Throwable -> L78
        m3();     // Catch: Throwable -> L78
        com.obric.audio.continuous_talk.b r4 = C3();     // Catch: Throwable -> L78
        if (r4 != null) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r21 == null) goto L12;
        boolean r10 = Intrinsics.areEqual(r21.get("suppress_close_haptic_for_intercom_switch"), Boolean.TRUE);     // Catch: Throwable -> L78
    L13:
        Object r11 = null;
        if (r20 == ObricContinuousTalkEndType.RESTART) goto L20;
        this.E = null;     // Catch: Throwable -> L78
        if (r20 != ObricContinuousTalkEndType.TIMEOUT) goto L18;
        String r0 = "timeout";
    L19:
        p3(r0, "continuous_talk_" + r20.name().toLowerCase(Locale.ROOT) + "_before_start", this.F);     // Catch: Throwable -> L78
        goto L20
    L18:
        r0 = "cancelled";
    L20:
        FLogger r1 = FLogger.a;     // Catch: Throwable -> L78
        r1.i("ObricContinuousTalkCtrlComponent", "closeContinuousTalk with obricContinuousTalkEndType " + r20 + " , isSpeaking " + r5 + ", wakeupFrom " + this.C + ", endDoraSession: " + r22 + ", immediately: " + r23);     // Catch: Throwable -> L78
        com.obric.audio.continuous_talk.b r2 = C3();     // Catch: Throwable -> L78
        if (r2 == null) goto L23;
        ContinuousTalkStatus r3 = r2.u10();     // Catch: Throwable -> L78
    L25:
        if (r3 != ContinuousTalkStatus.STOPPED) goto L31;
        this.C = -1;     // Catch: Throwable -> L78
        Map<String, Object> r6 = this.D;     // Catch: Throwable -> L78
        if (r6 == null) goto L29;
        r6.clear();     // Catch: Throwable -> L78
    L29:
        monitor-exit(this);
        return;
    L31:
        com.obric.audio.continuous_talk.b r7 = C3();     // Catch: Throwable -> L78
        if (r7 == null) goto L34;
        ContinuousTalkStatus r8 = r7.u10();     // Catch: Throwable -> L78
    L36:
        if (r8 != ContinuousTalkStatus.RUNNING) goto L69;
        if (r22 == true) goto L39;
    L50:
        IDoraWakeupService r9 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);     // Catch: Throwable -> L78
        if (r9 == null) goto L54;
        r9.i(false);     // Catch: Throwable -> L78
    L54:
        if (this.z == true) goto L56;
        H3(true);     // Catch: Throwable -> L78
    L81:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L59
        Object r13 = Result.constructor-impl(s1a.a.getActivity(this));     // Catch: Throwable -> L59
    L62:
        if (Result.isFailure-impl(r13) == true) goto L65;
        r11 = r13;
    L65:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new ObricContinuousTalkCtrlComponent$closeContinuousTalk$1(this, r10, r20, (FragmentActivity) r11, null), 2, null);     // Catch: Throwable -> L78
        com.larus.utils.t0.a.post(new com.obric.audio.continuous_talk.j(r20, this, r23));     // Catch: Throwable -> L78
        this.C = -1;     // Catch: Throwable -> L78
        Map<String, Object> r14 = this.D;     // Catch: Throwable -> L78
        if (r14 == null) goto L68;
        r14.clear();     // Catch: Throwable -> L78
    L68:
        ObricContinuousTalkEndType r15 = ObricContinuousTalkEndType.TIMEOUT;     // Catch: Throwable -> L78
    L76:
        monitor-exit(this);
        return;
    L59:
        th = move-exception;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L78
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L78
        goto L62
    L56:
        this.z = false;     // Catch: Throwable -> L78
        goto L81
    L39:
        if (AudioServiceDelegate.a.e0() == false) goto L50;
        IDoraWakeupService r17 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);     // Catch: Throwable -> L78
        if (r17 != null) goto L43;
    L45:
        boolean r18 = false;
    L46:
        if (r18 == true) goto L50;
        r1.i("ObricContinuousTalkCtrlComponent", "closeContinuousTalk, close VUI session");     // Catch: Throwable -> L78
        IDoraWakeupService r19 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);     // Catch: Throwable -> L78
        if (r19 == null) goto L50;
        r19.p();     // Catch: Throwable -> L78
        goto L50
    L43:
        if (r17.o() != true) goto L45;
        r18 = true;
        goto L46
    L69:
        com.obric.audio.continuous_talk.b r24 = C3();     // Catch: Throwable -> L78
        if (r24 == null) goto L73;
        r11 = r24.u10();     // Catch: Throwable -> L78
    L73:
        if (r11 != ContinuousTalkStatus.STOPPING) goto L76;
        if (r23 == false) goto L76;
        com.larus.utils.t0.a.post(new s(this));     // Catch: Throwable -> L78
        goto L76
    L34:
        r8 = null;
        goto L36
    L23:
        r3 = null;
        goto L25
    L12:
        r10 = false;
        goto L13
    L7:
        if (r4.m0() != true) goto L9;
        r5 = true;
    L78:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.obric.audio.continuous_talk.y] */
    public final void a4(final int r25, final Map<String, Object> r26, final Integer r27, final String r28, final String r29) {
        if (Intrinsics.areEqual(this.E, r29) == true) goto L5;
        return;
    L5:
        FLogger r0 = FLogger.a;
        r0.i("ObricContinuousTalkCtrlComponent", "tryOpenClickTalk from :" + r25 + "  【 0 means voice wakeup , 1 means bluetooth key press wakeup， 2 means auto mic wakeup 】");
        laa.f r1 = (laa.f) this.v.getValue();
        if (r1 == null) goto L8;
        r1.j();
    L8:
        this.C = -1;
        this.D = null;
        IFlowTtsClientService.a.getClass();
        int r13 = 0;
        IFlowTtsClientService.a.a().n(false);
        ObricAssistantBaseServiceDelegate.b.a();
        r0.i("ObricContinuousTalkCtrlComponent", "tryInterruptCurConv: tryInterruptTts");
        IObricChatService r2 = (IObricChatService) ServiceManager.get().getService(IObricChatService.class);
        if (r2 == null) goto L13;
        wc9.e r3 = r2.h();
        if (r3 == null) goto L13;
        String r4 = r3.a;
    L14:
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        String r15 = r4;
        boolean r7 = true;
        if (r15.length() <= 0) goto L19;
        boolean r5 = true;
    L20:
        if (r5 == false) goto L22;
        r0.i("ObricContinuousTalkCtrlComponent", "tryInterruptCurConv: mainCvsId is " + r15 + ", will tryInterrupt");
        IConversationRepoService.a.f(RepoDispatcherDelegate.b.f(), r15, false, false, null, 14);
    L23:
        final boolean r6 = com.obric.audio.continuous_talk.session.impl.p.b(r27, z3());
        int r8 = com.larus.utils.f0.a;
        if (com.larus.utils.f0.a(getContext()) == true) goto L41;
        if (AudioServiceDelegate.a.e0() == false) goto L38;
        if (r6 == false) goto L38;
        IDoraWakeupService r9 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r9 != null) goto L31;
    L33:
        r7 = false;
    L34:
        if (r7 == true) goto L38;
        r0.i("ObricContinuousTalkCtrlComponent", "Network not available, close VUI session");
        IDoraWakeupService r10 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r10 == null) goto L38;
        r10.p();
        goto L38
    L31:
        if (r9.o() != true) goto L33;
    L38:
        t19.s r11 = t19.s.a;
        Application r12 = AppHost.a.getApplication();
        r11.getClass();
        t19.s.s(r12, 2131908080);
        Z3(false, ObricAssistantForAudioDelegate.b.e5());
        p3("blocked", "network_unavailable", r28);
        return;
    L41:
        if (AudioServiceDelegate.a.P().isRecording() == false) goto L43;
        r0.e("ObricContinuousTalkCtrlComponent", "canLaunchAssistant AiNoteManager.isRecording()");
        com.larus.utils.t0.a.post(new com.obric.audio.continuous_talk.m(this));
        Z3(false, ObricAssistantForAudioDelegate.b.a5());
        boolean r14 = false;
    L44:
        if (r14 == true) goto L47;
        p3("blocked", "assistant_unavailable", r28);
        return;
    L47:
        com.obric.audio.continuous_talk.b r16 = C3();
        if (r16 != null) goto L50;
    L52:
        boolean r17 = false;
    L53:
        if (r17 == false) goto L56;
        com.obric.audio.continuous_talk.c.a.a(this, ObricContinuousTalkEndType.RESTART, null, false, true, 6);
        com.larus.utils.t0.a.postDelayed(new x(this, r25, r26, r27, r28, r29), 60);
        return;
    L56:
        Set r18 = com.obric.assistant.common.utils.p.a;
        if (com.obric.assistant.common.utils.p.e(getContext()) == true) goto L59;
    L63:
        this.C = r25;
        this.D = r26;
        IObricVoiceService r19 = (IObricVoiceService) ServiceManager.get().getService(IObricVoiceService.class);
        if (r19 == null) goto L66;
        Boolean r110 = Boolean.valueOf(r19.d());
    L67:
        final Boolean r20 = r110;
        final ?? r21 = new y(this, r29, r6, r25, r27, r20, r28);
        Context r22 = getContext();
        ArrayList r23 = new ArrayList();
        Object[] r24 = {"android.permission.RECORD_AUDIO"};
        f06.b r30 = new f06.b("auto_cert_com_obric_audio_continuous_talk_ObricContinuousTalkCtrlComponent_android_content_Context_checkSelfPermission");
        g06.a r111 = (g06.a) ApiHookConfig.b.get(102608);
        if (r111 == null) goto L70;
        f06.a[] r112 = r111.i;
    L71:
        int r113 = r112.length;
    L73:
        if (r13 >= r113) goto L84;
        int r210 = r113;
        f06.a r114 = r112[r13];
        Object[] r211 = r24;
        f06.d r31 = r114.preInvoke(102608, "android/content/Context", "checkSelfPermission", r22, r24, "int", r30);     // Catch: Exception -> L82
        f06.b r212 = r30;
        if (r31.a == true) goto L86;
        r23.add(r114);     // Catch: Exception -> L93
    L86:
        if (r31.a == false) goto L88;
        int r32 = ((Integer) r31.b).intValue();
    L89:
        if (r32 == 0) goto L91;
        FLogger.a.i("ObricContinuousTalkCtrlComponent", "checkSelfPermission RECORD_AUDIO not granted");
        i2.b.a(s1a.a.getActivity(this), CollectionsKt.mutableListOf(new String[]{"android.permission.RECORD_AUDIO"}), new z(this, r29, r21, r28));
        return;
    L91:
        FLogger.a.i("ObricContinuousTalkCtrlComponent", "checkSelfPermission RECORD_AUDIO has been granted");
        r21.invoke();
        return;
    L88:
        r32 = r22.checkSelfPermission("android.permission.RECORD_AUDIO");
    L83:
        r13 = r13 + 1;
        r113 = r210;
        r24 = r211;
        r30 = r212;
    L82:
        r212 = r30;
        goto L83
    L84:
        r31 = new f06.d(false, null);
        goto L86
    L70:
        r112 = ApiHookConfig.d;
        goto L71
    L66:
        r110 = null;
        goto L67
    L59:
        if (com.obric.assistant.common.utils.y.e() == false) goto L61;
        r0.i("ObricContinuousTalkCtrlComponent", "tryOpenClickTalk skip mic-in-use intercept by ROM concurrent record optimize");
        goto L63
    L61:
        p3("blocked", "mic_in_use", r28);
        return;
    L50:
        if (r16.m0() != true) goto L52;
        r17 = true;
        goto L53
    L43:
        r0.e("ObricContinuousTalkCtrlComponent", "canLaunchAssistant true");
        r14 = true;
        goto L44
    L22:
        r0.i("ObricContinuousTalkCtrlComponent", "tryInterruptCurConv: mainCvsId is empty, cannot tryInterrupt");
        goto L23
    L19:
        r5 = false;
    L13:
        r4 = null;
        goto L14
    }

    public final synchronized void G3(String r6, String r7, Integer r8, boolean r9, String r10, String r11) {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L4:
        if (Intrinsics.areEqual(this.E, r11) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        FLogger r0 = FLogger.a;     // Catch: Throwable -> L36
        r0.i("ObricContinuousTalkCtrlComponent", "onPermissionGranted");     // Catch: Throwable -> L36
        laa.d r1 = (laa.d) this.u.getValue();     // Catch: Throwable -> L36
        if (r1 != null) goto L10;
    L12:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L28;
        com.larus.bmhome.chat.component.cvs.y r3 = u0();     // Catch: Throwable -> L36
        if (r3 == null) goto L18;
        wc9.e r4 = r3.h();     // Catch: Throwable -> L36
    L19:
        if (r4 == null) goto L25;
        com.larus.bmhome.chat.component.cvs.y r5 = u0();     // Catch: Throwable -> L36
        if (r5 == null) goto L23;
        BotModel r12 = r5.j0();     // Catch: Throwable -> L36
    L24:
        if (r12 != null) goto L28;
    L23:
        r12 = null;
    L25:
        r0.e("ObricContinuousTalkCtrlComponent", "onPermissionGranted error, conversation or bot is null");     // Catch: Throwable -> L36
        p3("dropped", "chat_context_unavailable", r10);     // Catch: Throwable -> L36
        monitor-exit(this);
        return;
    L18:
        r4 = null;
    L28:
        boolean r13 = com.obric.audio.continuous_talk.session.impl.p.b(r8, z3());     // Catch: Throwable -> L36
        if (AudioServiceDelegate.a.isDoraConnected() == false) goto L32;
        if (r13 == false) goto L32;
        this.z = true;     // Catch: Throwable -> L36
    L33:
        Z3(true, null);     // Catch: Throwable -> L36
        Q3(r6, r7, r8, r9, r10, r11);     // Catch: Throwable -> L36
        monitor-exit(this);
        return;
    L32:
        H3(false);     // Catch: Throwable -> L36
        goto L33
    L10:
        if (r1.Da() != true) goto L12;
        r2 = true;
        goto L14
    }

    public final void Q3(final String r12, final String r13, final Integer r14, final boolean r15, final String r16, final String r17) {
        FLogger.a.i("ObricContinuousTalkCtrlComponent", "realStart with enterMethod " + r12 + " , callID : " + r13 + ", vuiId = " + r14 + ", breathWakeup = " + r15);
        com.larus.utils.t0.a.post(new p(this, r17, r16, r13, r14, r12, r15));
    }

    public static final void h3(final ObricContinuousTalkCtrlComponent r12, final String r13, final String r14, final Integer r15, final VoiceInputType r16, final boolean r17, final String r18, final String r19) {
        if (Intrinsics.areEqual(r12.E, r19) == false) goto L15;
        FLogger.a.i("ObricContinuousTalkCtrlComponent", "openContinuousTalk enterMethod:" + r13 + " callID:" + r14);
        if (i3.a.i() == false) goto L8;
        r12.p3("blocked", "login_required", r18);
        i3.j(TriggerLoginScene.TRIGGER_LOGIN_CLICK_CALL, null, null, 6);
        return;
    L8:
        List r9 = CollectionsKt.listOf("android.permission.RECORD_AUDIO");
        if (ContextCompat.checkSelfPermission(r12.getContext(), "android.permission.RECORD_AUDIO") == 0) goto L11;
        i2 r0 = i2.b;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        i2.q(com.larus.ui.arch.component.internal.attach.a.b(r12, r12), r9, new a0(r12, r19, r13, r14, r15, r16, r17, r18));
        return;
    L11:
        r12.G3(r13, r14, r15, r17, r18, r19);
        return;
    }
}
