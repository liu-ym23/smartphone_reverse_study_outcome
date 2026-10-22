package com.obric.assistant.state.impl.multitask.producer;

import aha.g;
import aha.k;
import aha.q;
import aha.r;
import aha.u;
import com.google.gson.Gson;
import com.larus.bmhome.chat.component.regen.i;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.VideoData;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.ArtifactStatus;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.GenericToolBlock;
import com.larus.im.bean.message.block.GenericToolBlockStatus;
import com.larus.im.d;
import com.larus.im.internal.stream.b;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.multitask.TaskFlowManager;
import com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import dp8.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import jha.h;
import jha.l;
import jha.m;
import jha.o;
import jha.p;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u000e*\u00029<\b\u0007\u0018\u0000 }2\u00020\u0001:\u0002}~B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010,\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010/\u001a\u0002002\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0016H\u0002J\u0018\u00102\u001a\u0002002\u0006\u0010-\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u000fH\u0002J\u0018\u00104\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000fH\u0002J.\u0010>\u001a\u0002002\u0006\u0010?\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u00162\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020AH\u0082@¢\u0006\u0002\u0010CJ&\u0010D\u001a\u00020A2\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u00162\u0006\u00105\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010EJ\u001e\u0010F\u001a\u0002002\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010GJ\u0012\u0010H\u001a\u0004\u0018\u00010I2\u0006\u00101\u001a\u00020\u0016H\u0002J\u001e\u0010J\u001a\u0002002\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010GJ\u001e\u0010K\u001a\u0002002\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010GJ\u0010\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\u0014H\u0002J\u001e\u0010N\u001a\u0002002\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010GJB\u0010O\u001a\u0002002\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u00162\u0006\u0010P\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u000f2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00160\nH\u0082@¢\u0006\u0002\u0010SJ\u001a\u0010T\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0016H\u0002J\u0018\u0010U\u001a\u00020A2\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0016H\u0002J&\u0010V\u001a\u0002002\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u00162\u0006\u00105\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010EJ\u0018\u0010W\u001a\u00020A2\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0016H\u0002J\u001e\u0010X\u001a\u0002002\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010GJ\u0018\u0010Y\u001a\u00020A2\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0016H\u0002J\u001e\u0010Z\u001a\u0002002\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010GJ8\u0010[\u001a\u0002002\u0006\u0010\\\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u00162\b\u0010]\u001a\u0004\u0018\u00010\u001b2\u0006\u0010^\u001a\u00020AH\u0082@¢\u0006\u0002\u0010_J\u001a\u0010`\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0016H\u0002J\u0018\u0010a\u001a\u00020A2\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0016H\u0002J\u0012\u0010b\u001a\u0004\u0018\u00010\u000f2\u0006\u00101\u001a\u00020\u0016H\u0002JJ\u0010c\u001a\u0002002\u0006\u0010\\\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010^\u001a\u00020A2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00160\nH\u0082@¢\u0006\u0002\u0010dJ6\u0010e\u001a\u0002002\u0006\u0010\\\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010f\u001a\u00020AH\u0082@¢\u0006\u0002\u0010gJ \u0010h\u001a\u0002002\u0006\u0010\\\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0016H\u0002J\u0018\u0010i\u001a\u0002002\u0006\u0010\\\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0016H\u0002J\u0010\u0010j\u001a\u0002002\u0006\u0010\\\u001a\u00020\u000fH\u0002J\u0010\u0010k\u001a\u0002002\u0006\u0010\\\u001a\u00020\u000fH\u0002J\b\u0010l\u001a\u000200H\u0016J\u0018\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00160\u0007*\b\u0012\u0004\u0012\u00020\u00160\u0007H\u0002J6\u0010n\u001a\u0002002\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u00162\u0006\u00105\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020AH\u0082@¢\u0006\u0002\u0010oJ.\u0010r\u001a\u0002002\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u00162\u0006\u00105\u001a\u00020\u000f2\u0006\u0010s\u001a\u00020AH\u0082@¢\u0006\u0002\u0010tJ(\u0010u\u001a\u0002002\u0006\u0010-\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u00162\u0006\u00105\u001a\u00020\u000f2\u0006\u0010v\u001a\u00020\u000bH\u0002J \u0010w\u001a\u0002002\u0006\u0010-\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u0016H\u0002J\u0018\u0010x\u001a\u0002002\u0006\u0010-\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000fH\u0002J\u001e\u0010y\u001a\u0002002\u0006\u0010z\u001a\u00020\u00162\u0006\u0010{\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010|R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00160\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00160\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00160\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00160\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00160\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001e0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R2\u0010%\u001a&\u0012\f\u0012\n '*\u0004\u0018\u00010\u000b0\u000b '*\u0012\u0012\f\u0012\n '*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010(0&X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010)\u001a&\u0012\f\u0012\n '*\u0004\u0018\u00010\u000b0\u000b '*\u0012\u0012\f\u0012\n '*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010(0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001e0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0004\n\u0002\u0010:R\u0010\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010=R \u0010p\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020q0\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u007f"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/MessageStateProducer;", "Lcom/obric/assistant/state/multitask/core/TaskFlowAutoInitProducer;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activeStateList", "", "", "activeMessageHandles", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/assistant/state/impl/multitask/producer/MessageTrackingKey;", "Lcom/obric/assistant/state/multitask/core/TaskHandle;", "Lcom/obric/assistant/state/api/multitask/state/ObricMessageActiveState;", "activeAigcTasks", "", "Lcom/obric/assistant/state/impl/multitask/producer/MessageStateProducer$ActiveAigcTask;", "activeCreationTasks", "Lcom/larus/bmhome/creative/messagecard/bean/CreationTask;", "activeCreationBlockItems", "Lcom/larus/im/bean/message/CreationItem;", "activeImageMessages", "Lcom/larus/im/bean/message/Message;", "activeMusicMessages", "activeVideoToolMessages", "activeGeneralAgentMusicMessages", "activeArtifactBlocks", "Lcom/larus/im/bean/message/block/ArtifactBlock;", "activePptMessages", "aigcTimeoutJobs", "Lkotlinx/coroutines/Job;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "aigcMessageKeys", "", "kotlin.jvm.PlatformType", "", "musicGenerationRequestKeys", "messageTaskRootIdRegistry", "Lcom/obric/assistant/state/impl/multitask/producer/MessageTaskRootIdRegistry;", "resolveTaskRootMessageId", "conversationId", "replyId", "recordMessageIdMapping", "", "msg", "removeMessageIdMapping", "localMessageId", "messageTrackingKey", "taskRootMessageId", "activeTimeoutJobs", "lastStreamMessageIds", "streamObserver", "com/obric/assistant/state/impl/multitask/producer/MessageStateProducer$streamObserver$1", "Lcom/obric/assistant/state/impl/multitask/producer/MessageStateProducer$streamObserver$1;", "messageObserver", "com/obric/assistant/state/impl/multitask/producer/MessageStateProducer$messageObserver$1", "Lcom/obric/assistant/state/impl/multitask/producer/MessageStateProducer$messageObserver$1;", "onUpdateMessageInternal", "cid", "associateNewTaskWithActiveMode", "", "allowSendSuccessTaskCreation", "(Ljava/lang/String;Lcom/larus/im/bean/message/Message;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitMessageAigcGenerationState", "(Ljava/lang/String;Lcom/larus/im/bean/message/Message;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitPptAigcGenerationState", "(Ljava/lang/String;Lcom/larus/im/bean/message/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parsePptAsyncJob", "Lcom/obric/assistant/state/impl/multitask/producer/PptAsyncJob;", "emitLegacyCreationAigcGenerationState", "emitCreationBlockAigcGenerationState", "creationItemAigcType", "item", "emitMusicAigcGenerationState", "emitSimpleMessageAigcState", "prefix", EffectConfiguration.KEY_TYPE, "cache", "(Ljava/lang/String;Lcom/larus/im/bean/message/Message;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/ConcurrentHashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "musicTaskFlowIdentity", "hasActiveMusicTask", "emitGeneralAgentMusicAigcGenerationState", "hasActiveGeneralAgentMusicTask", "emitVideoToolAigcGenerationState", "hasActiveVideoToolTask", "emitArtifactAigcGenerationState", "dispatchArtifactAigcState", "id", "artifact", "running", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/Message;Lcom/larus/im/bean/message/block/ArtifactBlock;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "artifactTaskFlowIdentity", "hasActiveArtifactTask", "aigcMessageIdentity", "emitTrackedAigcState", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/Message;Ljava/lang/String;ZLjava/util/concurrent/ConcurrentHashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startOrUpdateAigcTask", "newTask", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/Message;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endAigcTask", "scheduleAigcTimeout", "cancelAigcTimeout", "removeActiveAigcPayload", "initProducer", "filterActiveSelfMessagesWithoutReply", "emitMessageActiveState", "(Ljava/lang/String;Lcom/larus/im/bean/message/Message;Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deepThinkHandles", "Lcom/obric/assistant/state/api/multitask/state/ObricDeepThinkMessageState;", "emitDeepThinkState", "isAigcGenerationMessage", "(Ljava/lang/String;Lcom/larus/im/bean/message/Message;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endDeepThinkIfStarted", "trackingKey", "scheduleActiveTimeout", "cancelActiveTimeout", "handleStreamEvent", "message", "event", "(Lcom/larus/im/bean/message/Message;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ActiveAigcTask", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageStateProducer implements TaskFlowAutoInitProducer {
    public static final Set<Integer> w = null;
    public final CoroutineScope a;
    public final List<Integer> b;
    public final ConcurrentHashMap<h, l<q>> c;
    public final ConcurrentHashMap<String, a> d;
    public final ConcurrentHashMap<String, CreationTask> e;
    public final ConcurrentHashMap<String, CreationItem> f;
    public final ConcurrentHashMap<String, Message> g;
    public final ConcurrentHashMap<String, Message> h;
    public final ConcurrentHashMap<String, Message> i;
    public final ConcurrentHashMap<String, Message> j;
    public final ConcurrentHashMap<String, ArtifactBlock> k;
    public final ConcurrentHashMap<String, Message> l;
    public final ConcurrentHashMap<String, Job> m;
    public final Lazy n;
    public final Set<h> o;
    public final Set<h> p;
    public final g q;
    public final ConcurrentHashMap<h, Job> r;
    public final ConcurrentHashMap<h, String> s;
    public final MessageStateProducer$streamObserver$1 t;
    public final MessageStateProducer$messageObserver$1 u;
    public final ConcurrentHashMap<h, l<aha.j>> v;

    static {
        w = SetsKt.setOf(new Integer[]{3, 1});
    }

    @Override // com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer
    public final void f() {
        FLogger.a.i("MessageStateProducer", "init global message observer for task flow");
        d.e().registerOnGlobalMessageObserver(this.u);
        b.a.a(this.t);
    }

    /* JADX WARN: Type inference failed for: r0v25, types: [com.obric.assistant.state.impl.multitask.producer.MessageStateProducer$streamObserver$1] */
    /* JADX WARN: Type inference failed for: r0v26, types: [com.obric.assistant.state.impl.multitask.producer.MessageStateProducer$messageObserver$1] */
    public MessageStateProducer() {
        ExecutorCoroutineDispatcher r0 = jha.f.a;
        this.a = jha.f.b;
        this.b = CollectionsKt.listOf(new Integer[]{0, 1, 2, 10, 11, 20, 24});
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
        this.h = new ConcurrentHashMap();
        this.i = new ConcurrentHashMap();
        this.j = new ConcurrentHashMap();
        this.k = new ConcurrentHashMap();
        this.l = new ConcurrentHashMap();
        this.m = new ConcurrentHashMap();
        this.n = LazyKt.lazy(new f());
        this.o = Collections.newSetFromMap(new ConcurrentHashMap());
        this.p = Collections.newSetFromMap(new ConcurrentHashMap());
        this.q = new g();
        this.r = new ConcurrentHashMap();
        this.s = new ConcurrentHashMap();
        this.t = new MessageStateProducer$streamObserver$1(this);
        this.u = new MessageStateProducer$messageObserver$1(this);
        this.v = new ConcurrentHashMap();
    }

    public static String c(Message r5) {
        String r0 = r5.getReplyId();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L17:
        r0 = r5.getLocalMessageId();
        if (r0 != null) goto L20;
    L25:
        r0 = null;
    L26:
        if (r0 != null) goto L35;
        String r6 = r5.getMessageId();
        if (r6 != null) goto L30;
        return null;
    L30:
        if (r6.length() <= 0) goto L32;
        r1 = true;
    L32:
        if (r1 == true) goto L38;
        return null;
    L38:
        return r6;
    L35:
        return r0;
    L20:
        if (r0.length() <= 0) goto L22;
        boolean r4 = true;
    L23:
        if (r4 == false) goto L25;
    L22:
        r4 = false;
        goto L23
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == true) goto L10;
    L12:
        boolean r8 = false;
    L13:
        if (r8 == true) goto L16;
        r0 = null;
    L16:
        if (r0 != null) goto L35;
    L10:
        if (Intrinsics.areEqual(r0, "0") == true) goto L12;
        r8 = true;
        goto L13
    L7:
        r7 = false;
        goto L8
    }

    public static String e(CreationItem r1) {
        CreationGenDetail r0 = r1.genDetail;
        if (r0 == null) goto L8;
        Integer r2 = r0.taskType;
        if (r2 == null) goto L8;
        String r3 = r2.toString();
        if (r3 == null) goto L8;
        return r3;
    L8:
        Integer r4 = r1.type;
        if (r4 != null) goto L12;
    L14:
        return "image";
    L12:
        if (r4.intValue() != 2) goto L14;
        return "gen_video";
    }

    public static String d(String r2, Message r3) {
        String r4 = c(r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return "artifact:" + r2 + ':' + r4;
    }

    public final void r(String r7, String r8) {
        g r0 = this.q;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r7, "conversationId");
        Intrinsics.checkNotNullParameter(r8, "localMessageId");
        Set r1 = r0.a.entrySet();
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L13;
        Object r4 = r3.next();
        Map.Entry r5 = (Map.Entry) r4;
        Intrinsics.checkNotNull(r5);
        g.a r6 = (g.a) r5.getKey();
        String r9 = (String) r5.getValue();
        if (Intrinsics.areEqual(r6.a, r7) == true) goto L8;
    L10:
        boolean r10 = false;
    L11:
        if (r10 == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        if (Intrinsics.areEqual(r9, r8) == false) goto L10;
        r10 = true;
        goto L11
    L13:
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r12 = r2.iterator();
    L15:
        if (r12.hasNext() == false) goto L17;
        r11.add((g.a) ((Map.Entry) r12.next()).getKey());
        goto L15
    L17:
        ConcurrentHashMap r13 = r0.a;
        Iterator r14 = r11.iterator();
    L19:
        if (r14.hasNext() == false) goto L21;
        r13.remove((g.a) r14.next());
        goto L19
    }

    public final String s(String r3, String r4) {
        g r0 = this.q;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return null;
    L11:
        String r5 = (String) r0.a.get(new g.a(r3, r4));
        if (r5 == null) goto L16;
        r4 = r5;
    L16:
        return r4;
    L5:
        if (r4.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static final Unit a(MessageStateProducer r9, Message r10, String r11) {
        r9.getClass();
        String r1 = r10.getConversationId();
        if (r1 == null) goto L45;
        String r0 = r10.getReplyId();
        if (r0 == null) goto L44;
        boolean r3 = true;
        String r4 = null;
        if ((!Intrinsics.areEqual(r0, "0")) == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L44;
        String r2 = r9.s(r1, r0);
        if (r2 == null) goto L46;
        h r5 = new h(r1, r2);
        l<q> r6 = r9.c.get(r5);
        if (r6 == null) goto L47;
        r9.t(r1, r2, r10);
        String r7 = r10.getMessageId();
        if (r7 != null) goto L22;
    L27:
        if (r4 == null) goto L49;
        if (Intrinsics.areEqual(r9.s.get(r5), r4) == true) goto L49;
        r9.s.put(r5, r4);
        FLogger.a.i("MessageStateProducer", r11 + ": dispatch active update for task " + r2 + ", msgId=" + r4);
        String r8 = r10.getMessageId();
        TaskFlowManager r12 = TaskFlowManager.a;
        jha.q r13 = TaskFlowManager.d(r6.a);
        if (r13 == null) goto L40;
        p r14 = r13.a();
        if (r14 == null) goto L40;
        q r15 = r14.b;
        if (r15 == null) goto L40;
        u r16 = r15.b();
        if (r16 == null) goto L40;
    L41:
        TaskFlowDslKt.f(r6, new q.a(r1, r8, 20, r10, r16));
        return Unit.INSTANCE;
    L40:
        r16 = m.c(r10, false);
    L49:
        return Unit.INSTANCE;
    L22:
        if (r7.length() > 0) goto L25;
        r3 = false;
    L25:
        if (r3 == false) goto L27;
        r4 = r7;
        goto L27
    L47:
        return Unit.INSTANCE;
    L46:
        return Unit.INSTANCE;
    L44:
        return Unit.INSTANCE;
    L45:
        return Unit.INSTANCE;
    }

    public final Object h(String r17, Message r18, Continuation<? super Unit> r19) {
        if ((r19 instanceof emitCreationBlockAigcGenerationState.1) == false) goto L7;
        emitCreationBlockAigcGenerationState.1 r1 = (emitCreationBlockAigcGenerationState.1) r19;
        int r2 = r1.label;
        if ((r2 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - IntCompanionObject.MIN_VALUE;
    L8:
        emitCreationBlockAigcGenerationState.1 r8 = r1;
        Object r0 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Iterator r4 = (Iterator) r8.L$2;
        Message r5 = (Message) r8.L$1;
        String r6 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
        Iterator r14 = r4;
        Message r13 = r5;
        String r12 = r6;
    L94:
        if (r14.hasNext() == false) goto L103;
        Map.Entry r7 = (Map.Entry) r14.next();
        String r10 = (String) r7.getKey();
        CreationItem r11 = (CreationItem) r7.getValue();
        String r15 = e(r11);
        if (this.f.put(r10, r11) != null) goto L98;
        boolean r16 = true;
    L99:
        r8.L$0 = r12;
        r8.L$1 = r13;
        r8.L$2 = r14;
        r8.label = 1;
        if (u(r10, r15, r13, r12, r16, r8) != r9) goto L94;
        return r9;
    L98:
        r16 = false;
        goto L99
    L103:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        String r20 = c(r18);
        if (r20 == null) goto L17;
        String r21 = "creation_block:" + r17 + ':' + r20 + ':';
        List r22 = com.larus.im.bean.message.a.l(r18);
        ArrayList r23 = new ArrayList();
        Iterator r24 = ((ArrayList) r22).iterator();
        int r25 = 0;
    L19:
        Pair r26 = null;
        if (r24.hasNext() == false) goto L42;
        Object r27 = r24.next();
        int r110 = r25 + 1;
        if (r25 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        CreationItem r28 = (CreationItem) r27;
        if (CollectionsKt.contains(SetsKt.setOf(new Integer[]{Boxing.boxInt(1), Boxing.boxInt(2)}), r28.type) == false) goto L39;
        StringBuilder r111 = new StringBuilder();
        r111.append(r21);
        Pair r112 = r28.id;
        if (r112 != null) goto L30;
    L37:
        r26 = Boxing.boxInt(r25);
    L38:
        r111.append(r26);
        r26 = TuplesKt.to(r111.toString(), r28);
        goto L39
    L30:
        if (r112.length() <= 0) goto L32;
        boolean r113 = true;
    L34:
        if (Boxing.boxBoolean(r113).booleanValue() == false) goto L36;
        r26 = r112;
    L36:
        if (r26 != null) goto L38;
    L32:
        r113 = false;
    L39:
        if (r26 == null) goto L41;
        r23.add(r26);
    L41:
        r25 = r110;
        goto L19
    L42:
        Map r29 = MapsKt.toMap(r23);
        LinkedHashMap r30 = new LinkedHashMap();
        Iterator r31 = r29.entrySet().iterator();
    L44:
        if (r31.hasNext() == false) goto L70;
        Map.Entry r32 = (Map.Entry) r31.next();
        CreationItem r114 = (CreationItem) r32.getValue();
        Integer r115 = r114.type;
        if (r115 != null) goto L49;
    L58:
        if (r115 != null) goto L61;
    L67:
        boolean r116 = false;
    L68:
        if (r116 == false) goto L44;
        r30.put(r32.getKey(), r32.getValue());
        goto L44
    L61:
        if (r115.intValue() != 2) goto L67;
        Set r117 = SetsKt.setOf(new Integer[]{Boxing.boxInt(1), Boxing.boxInt(2)});
        VideoData r118 = r114.video;
        if (r118 == null) goto L65;
        Integer r119 = r118.status;
    L66:
        r116 = CollectionsKt.contains(r117, r119);
        goto L68
    L65:
        r119 = null;
        goto L66
    L49:
        if (r115.intValue() != 1) goto L58;
        ImageData r120 = r114.image;
        if (r120 == null) goto L67;
        Integer r121 = r120.status;
        if (r121 == null) goto L67;
        if (r121.intValue() != 1) goto L67;
        r116 = true;
        goto L68
    L70:
        Set<String> r33 = this.f.keySet();
        ArrayList r34 = new ArrayList();
        Iterator<T> r35 = r33.iterator();
    L72:
        if (r35.hasNext() == false) goto L81;
        Object r122 = r35.next();
        String r123 = (String) r122;
        Intrinsics.checkNotNull(r123);
        if (StringsKt.startsWith$default(r123, r21, false, 2, null) == true) goto L76;
    L78:
        boolean r124 = false;
    L79:
        if (r124 == false) goto L72;
        r34.add(r122);
        goto L72
    L76:
        if (r30.containsKey(r123) == true) goto L78;
        r124 = true;
        goto L79
    L81:
        Iterator r36 = r34.iterator();
    L83:
        if (r36.hasNext() == false) goto L92;
        String r37 = (String) r36.next();
        CreationItem r38 = this.f.remove(r37);
        if (r38 == null) goto L83;
        Intrinsics.checkNotNull(r37);
        CreationItem r39 = (CreationItem) r29.get(r37);
        if (r39 == null) goto L91;
        r38 = r39;
    L91:
        p(r37, e(r38), r18);
        goto L83
    L92:
        r14 = r30.entrySet().iterator();
        r12 = r17;
        r13 = r18;
        goto L94
    L17:
        return Unit.INSTANCE;
    L7:
        r1 = new emitCreationBlockAigcGenerationState.1(this, r19);
        goto L8
    }

    public final Object j(String r17, Message r18, Continuation<? super Unit> r19) {
        if ((r19 instanceof emitLegacyCreationAigcGenerationState.1) == false) goto L7;
        emitLegacyCreationAigcGenerationState.1 r2 = (emitLegacyCreationAigcGenerationState.1) r19;
        int r3 = r2.label;
        if ((r3 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        Iterator r6 = (Iterator) r2.L$2;
        Message r7 = (Message) r2.L$1;
        String r8 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
        Iterator r14 = r6;
        String r9 = r8;
        Message r10 = r7;
    L111:
        if (r14.hasNext() == false) goto L125;
        Map.Entry r11 = (Map.Entry) r14.next();
        String r12 = (String) r11.getKey();
        CreationTask r13 = (CreationTask) r11.getValue();
        Integer r15 = r13.taskType;
        if (r15 == null) goto L111;
        String r16 = r15.toString();
        if (r16 == null) goto L111;
        if (this.e.put(r12, r13) != null) goto L120;
        boolean r110 = true;
    L121:
        r2.L$0 = r9;
        r2.L$1 = r10;
        r2.L$2 = r14;
        r2.label = 1;
        if (u(r12, r16, r10, r9, r110, r2) != r4) goto L111;
        return r4;
    L120:
        r110 = false;
        goto L121
    L125:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        CreationMsgContentData r20 = e.c(r18);
        if (r20 == null) goto L127;
        CreationInfo r21 = r20.creationInfo;
        if (r21 == null) goto L127;
        String r22 = r21.taskGroupId;
        if (r22 != null) goto L22;
    L29:
        r22 = c(r18);
        if (r22 == null) goto L32;
    L33:
        String r23 = "creation:" + r17 + ':' + r22 + ':';
        Map r24 = r21.taskInfo;
        if (r24 != null) goto L36;
        r24 = MapsKt.emptyMap();
    L36:
        Set r25 = r24.entrySet();
        ArrayList r26 = new ArrayList();
        Iterator r27 = r25.iterator();
    L38:
        if (r27.hasNext() == false) goto L75;
        Map.Entry r111 = (Map.Entry) r27.next();
        String r112 = (String) r111.getKey();
        CreationTask r113 = (CreationTask) r111.getValue();
        if (r113 != null) goto L43;
    L71:
        Pair r114 = null;
    L73:
        if (r114 == null) goto L38;
        r26.add(r114);
        goto L38
    L43:
        if (CollectionsKt.contains(com.obric.assistant.state.impl.v2.utils.c.a, r113.taskType) == false) goto L71;
        String r115 = r113.id;
        if (r115 != null) goto L48;
    L55:
        if (r112 != null) goto L57;
        r115 = null;
    L65:
        if (r115 != null) goto L72;
        Integer r116 = r113.index;
        if (r116 == null) goto L69;
        r115 = r116.toString();
    L70:
        if (r115 != null) goto L72;
    L69:
        r115 = null;
    L72:
        r114 = TuplesKt.to(r23 + r115, r113);
        goto L73
    L57:
        if (r112.length() <= 0) goto L59;
        boolean r117 = true;
    L60:
        if (r117 == true) goto L63;
        r112 = null;
    L63:
        r115 = r112;
        goto L65
    L59:
        r117 = false;
        goto L60
    L48:
        if (r115.length() <= 0) goto L50;
        boolean r118 = true;
    L51:
        if (r118 == true) goto L54;
        r115 = null;
    L54:
        if (r115 != null) goto L72;
    L50:
        r118 = false;
        goto L51
    L75:
        Map r28 = MapsKt.toMap(r26);
        LinkedHashMap r29 = new LinkedHashMap();
        Iterator r119 = r28.entrySet().iterator();
    L77:
        if (r119.hasNext() == false) goto L81;
        Map.Entry r120 = (Map.Entry) r119.next();
        if (CollectionsKt.contains(w, ((CreationTask) r120.getValue()).status) == false) goto L77;
        r29.put(r120.getKey(), r120.getValue());
        goto L77
    L81:
        Set<String> r121 = this.e.keySet();
        ArrayList r122 = new ArrayList();
        Iterator<T> r123 = r121.iterator();
    L83:
        if (r123.hasNext() == false) goto L92;
        Object r124 = r123.next();
        String r125 = (String) r124;
        Intrinsics.checkNotNull(r125);
        if (StringsKt.startsWith$default(r125, r23, false, 2, null) == true) goto L87;
    L89:
        boolean r126 = false;
    L90:
        if (r126 == false) goto L83;
        r122.add(r124);
        goto L83
    L87:
        if (r29.containsKey(r125) == true) goto L89;
        r126 = true;
        goto L90
    L92:
        Iterator r30 = r122.iterator();
    L94:
        if (r30.hasNext() == false) goto L109;
        String r31 = (String) r30.next();
        CreationTask r127 = this.e.remove(r31);
        if (r127 == null) goto L94;
        Intrinsics.checkNotNull(r31);
        CreationTask r128 = (CreationTask) r28.get(r31);
        if (r128 == null) goto L104;
        Integer r129 = r128.taskType;
        if (r129 == null) goto L104;
        String r130 = r129.toString();
        if (r130 == null) goto L104;
    L108:
        p(r31, r130, r18);
    L104:
        Integer r131 = r127.taskType;
        if (r131 == null) goto L107;
        r130 = r131.toString();
        goto L108
    L107:
        r130 = "image";
        goto L108
    L109:
        r14 = r29.entrySet().iterator();
        r9 = r17;
        r10 = r18;
        goto L111
    L32:
        return Unit.INSTANCE;
    L22:
        if (r22.length() <= 0) goto L24;
        boolean r32 = true;
    L25:
        if (r32 == true) goto L28;
        r22 = null;
    L28:
        if (r22 != null) goto L33;
    L24:
        r32 = false;
    L127:
        return Unit.INSTANCE;
    L7:
        r2 = new emitLegacyCreationAigcGenerationState.1(this, r19);
        goto L8
    }

    public final Object o(String r17, Message r18, Continuation<? super Unit> r19) {
        if ((r19 instanceof emitVideoToolAigcGenerationState.1) == false) goto L7;
        emitVideoToolAigcGenerationState.1 r1 = (emitVideoToolAigcGenerationState.1) r19;
        int r2 = r1.label;
        if ((r2 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - IntCompanionObject.MIN_VALUE;
    L8:
        emitVideoToolAigcGenerationState.1 r8 = r1;
        Object r0 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Iterator r4 = (Iterator) r8.L$2;
        Message r5 = (Message) r8.L$1;
        String r6 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
        Iterator r14 = r4;
        Message r13 = r5;
        String r12 = r6;
    L107:
        if (r14.hasNext() == false) goto L116;
        String r7 = (String) r14.next();
        if (this.i.put(r7, r13) != null) goto L111;
        boolean r10 = true;
    L112:
        r8.L$0 = r12;
        r8.L$1 = r13;
        r8.L$2 = r14;
        r8.label = 1;
        if (u(r7, "gen_video", r13, r12, r10, r8) != r9) goto L107;
        return r9;
    L111:
        r10 = false;
        goto L112
    L116:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        String r11 = c(r18);
        if (r11 == null) goto L17;
        String r15 = "video_tool:" + r17 + ':' + r11 + ':';
        List r16 = com.obric.assistant.state.impl.v2.utils.c.b(r18);
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r21 = ((ArrayList) r16).iterator();
        int r22 = 0;
    L19:
        Object r23 = null;
        if (r21.hasNext() == false) goto L36;
        Object r24 = r21.next();
        int r110 = r22 + 1;
        if (r22 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        Block r25 = (Block) r24;
        StringBuilder r111 = new StringBuilder();
        r111.append(r15);
        String r112 = r25.getBlockId();
        if (r112 != null) goto L27;
    L34:
        r23 = Boxing.boxInt(r22);
    L35:
        r111.append(r23);
        r20.add(TuplesKt.to(r111.toString(), r25));
        r22 = r110;
        goto L19
    L27:
        if (r112.length() <= 0) goto L29;
        boolean r113 = true;
    L31:
        if (Boxing.boxBoolean(r113).booleanValue() == false) goto L33;
        r23 = r112;
    L33:
        if (r23 != null) goto L35;
    L29:
        r113 = false;
        goto L31
    L36:
        Map r26 = MapsKt.toMap(r20);
        ArrayList r27 = (ArrayList) com.larus.im.bean.message.a.l(r18);
        if (r27.isEmpty() == true) goto L57;
        Iterator r28 = r27.iterator();
    L41:
        if (r28.hasNext() == false) goto L57;
        CreationItem r29 = (CreationItem) r28.next();
        Integer r114 = r29.type;
        if (r114 != null) goto L46;
    L54:
        boolean r30 = false;
    L55:
        if (r30 == false) goto L41;
        boolean r31 = true;
    L58:
        Set r32 = r26.keySet();
        if (r31 == false) goto L61;
    L63:
        boolean r33 = false;
    L64:
        if (r33 == true) goto L67;
        r32 = null;
    L67:
        if (r32 == null) goto L87;
        ArrayList r34 = new ArrayList();
        Iterator r35 = r32.iterator();
    L70:
        if (r35.hasNext() == false) goto L86;
        Object r115 = r35.next();
        Block r116 = (Block) r26.get((String) r115);
        if (r116 == null) goto L83;
        BlockContent r117 = r116.getContent();
        if (r117 == null) goto L83;
        GenericToolBlock r118 = r117.getGenericToolBlock();
        if (r118 == null) goto L83;
        Integer r119 = r118.status;
        int r120 = GenericToolBlockStatus.STATUS_PROCESSING.getValue();
        if (r119 == null) goto L83;
        if (r119.intValue() != r120) goto L83;
        boolean r121 = true;
    L84:
        if (r121 == false) goto L70;
        r34.add(r115);
    L83:
        r121 = false;
        goto L84
    L86:
        Set r36 = CollectionsKt.toSet(r34);
    L88:
        if (r36 != null) goto L90;
        r36 = SetsKt.emptySet();
    L90:
        Set<String> r37 = this.i.keySet();
        ArrayList r38 = new ArrayList();
        Iterator<T> r39 = r37.iterator();
    L92:
        if (r39.hasNext() == false) goto L101;
        Object r122 = r39.next();
        String r123 = (String) r122;
        Intrinsics.checkNotNull(r123);
        if (StringsKt.startsWith$default(r123, r15, false, 2, null) == true) goto L96;
    L98:
        boolean r124 = false;
    L99:
        if (r124 == false) goto L92;
        r38.add(r122);
        goto L92
    L96:
        if (r36.contains(r123) == true) goto L98;
        r124 = true;
        goto L99
    L101:
        Iterator r40 = r38.iterator();
    L103:
        if (r40.hasNext() == false) goto L105;
        String r41 = (String) r40.next();
        this.i.remove(r41);
        Intrinsics.checkNotNull(r41);
        p(r41, "gen_video", r18);
        goto L103
    L105:
        r14 = r36.iterator();
        r12 = r17;
        r13 = r18;
        goto L107
    L87:
        r36 = null;
        goto L88
    L61:
        if (SetsKt.setOf(new Integer[]{Boxing.boxInt(20), Boxing.boxInt(24)}).contains(Boxing.boxInt(r18.getMessageStatusLocal())) == false) goto L63;
        r33 = true;
        goto L64
    L46:
        if (r114.intValue() != 2) goto L54;
        Set r125 = SetsKt.setOf(new Integer[]{Boxing.boxInt(3), Boxing.boxInt(4)});
        VideoData r42 = r29.video;
        if (r42 == null) goto L50;
        Integer r43 = r42.status;
    L52:
        if (CollectionsKt.contains(r125, r43) == false) goto L54;
        r30 = true;
        goto L55
    L50:
        r43 = null;
    L57:
        r31 = false;
        goto L58
    L17:
        return Unit.INSTANCE;
    L7:
        r1 = new emitVideoToolAigcGenerationState.1(this, r19);
        goto L8
    }

    public final void p(String r4, String r5, Message r6) {
        Job r0 = this.m.remove(r4);
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        a r7 = this.d.remove(r4);
        if (r7 != null) goto L8;
        return;
    L8:
        TaskFlowDslKt.c(r7.a, new g.b(r5, r6, r7.c, r7.d));
    }

    public final void t(String r16, String r17, Message r18) {
        h r8 = new h(r16, r17);
        Job r0 = this.r.get(r8);
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        Job r1 = BuildersKt.launch$default(this.a, null, null, new scheduleActiveTimeout.job.1(this, r8, r17, r16, r18, null), 3, null);
        this.r.put(r8, r1);
    }

    public final Object l(String r19, Message r20, String r21, Continuation<? super Boolean> r22) {
        String r0 = r21;
        if ((r22 instanceof emitMessageAigcGenerationState.1) == false) goto L7;
        emitMessageAigcGenerationState.1 r2 = (emitMessageAigcGenerationState.1) r22;
        int r3 = r2.label;
        if ((r3 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - IntCompanionObject.MIN_VALUE;
    L8:
        emitMessageAigcGenerationState.1 r8 = r2;
        Object r1 = r8.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r8.label) {
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L12;
            case 8: goto L12;
            default: goto L11;
        };
    L12:
        boolean r4 = r8.Z$0;
        h r5 = (h) r8.L$2;
        h r6 = (h) r8.L$1;
        Message r7 = (Message) r8.L$0;
        ResultKt.throwOnFailure(r1);
    L300:
        boolean r14 = r4;
        h r13 = r5;
        h r12 = r6;
    L302:
        if (this.b.contains(Boxing.boxInt(r7.getMessageStatusLocal())) == true) goto L305;
        this.o.remove(r12);
        this.p.remove(r13);
    L305:
        return Boxing.boxBoolean(r14);
    L13:
        ResultKt.throwOnFailure(r1);
        r12 = new h(r19, r0);
        if (com.larus.bmhome.chat.bean.d.G0(r20) == false) goto L26;
        String r9 = r20.getMessageId();
        if (r9 != null) goto L18;
    L41:
        r9 = r0;
    L42:
        r13 = new h(r19, r9);
        if (com.larus.bmhome.chat.bean.d.G0(r20) == false) goto L54;
        Map r10 = r20.getExt();
        if (r10 == null) goto L47;
        String r15 = (String) r10.get("gen_music_create_type");
    L49:
        if (Intrinsics.areEqual(r15, "ai") == false) goto L54;
        this.p.add(r13);
        if (Intrinsics.areEqual(r13, r12) == true) goto L54;
        this.p.remove(r12);
        goto L54
    L47:
        r15 = null;
    L54:
        if (com.larus.bmhome.chat.bean.d.G0(r20) == true) goto L64;
        Map r16 = r20.getExt();
        if (r16 == null) goto L58;
        String r17 = (String) r16.get("general_agent");
    L60:
        if (Intrinsics.areEqual(r17, "1") == false) goto L64;
        if (this.p.contains(r13) == false) goto L64;
        boolean r18 = true;
    L65:
        if (r18 == false) goto L67;
    L70:
        boolean r23 = true;
    L72:
        if (com.obric.assistant.state.impl.v2.utils.c.d(r20) == true) goto L74;
        if (r23 == true) goto L74;
    L75:
        r14 = this.o.contains(r12);
        if (r14 == false) goto L79;
        q(r19, r20, r0, r12);
    L79:
        if (com.larus.im.bean.message.a.l0(r20) == false) goto L176;
        r8.L$0 = r20;
        r8.L$1 = r12;
        r8.L$2 = r13;
        r8.Z$0 = r14;
        r8.label = 1;
        Map r24 = r20.getExt();
        if (r24 == null) goto L104;
        String r25 = (String) r24.get("async_job");
        if (r25 == null) goto L104;
        if (r25.length() <= 0) goto L87;
        boolean r26 = true;
    L88:
        if (r26 == true) goto L91;
        r25 = null;
    L91:
        if (r25 == null) goto L104;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L95
        Object r28 = Result.constructor-impl((l) ((Gson) this.n.getValue()).fromJson(r25, l.class));     // Catch: Throwable -> L95
    L97:
        Throwable r29 = Result.exceptionOrNull-impl(r28);
        if (r29 == null) goto L101;
        FLogger.a.w("MessageStateProducer", "parse ppt async_job failed, msgId=" + r20.getMessageId(), r29);
    L101:
        if (Result.isFailure-impl(r28) == false) goto L103;
        r28 = null;
    L103:
        l r30 = (l) r28;
    L105:
        Map r31 = r20.getExt();
        if (r31 == null) goto L117;
        String r32 = (String) r31.get("aippt_task_id");
        if (r32 == null) goto L117;
        if (r32.length() <= 0) goto L112;
        boolean r33 = true;
    L113:
        if (r33 == true) goto L116;
        r32 = null;
    L116:
        if (r32 == null) goto L117;
    L131:
        String r34 = "ppt:" + r19 + ':' + r32;
        Map r35 = r20.getExt();
        if (r35 == null) goto L134;
        String r36 = (String) r35.get("is_finish");
    L136:
        if (Intrinsics.areEqual(r36, "1") == true) goto L162;
        Map r37 = r20.getExt();
        if (r37 == null) goto L147;
        String r38 = (String) r37.get("aippt_task_status");
        if (r38 == null) goto L147;
        Integer r39 = StringsKt.toIntOrNull(r38);
        if (r39 == null) goto L147;
        if (r39.intValue() != 2) goto L147;
        boolean r40 = true;
    L148:
        if (r40 == true) goto L162;
        if (r30 == null) goto L158;
        Integer r41 = r30.b();
        if (r41 == null) goto L158;
        if (r41.intValue() == 1) goto L155;
        boolean r42 = true;
    L156:
        if (r42 != true) goto L158;
        boolean r43 = true;
    L159:
        if (r43 == true) goto L162;
        boolean r44 = false;
    L164:
        if (r44 == false) goto L166;
    L168:
        boolean r45 = false;
    L169:
        Object r46 = n(r34, "ppt", r20, r19, r45, this.l, r8);
        if (r46 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L173;
        r46 = Unit.INSTANCE;
    L173:
        if (r46 != r11) goto L299;
        return r11;
    L299:
        r7 = r20;
        r6 = r12;
        r5 = r13;
        r4 = r14;
        goto L300
    L166:
        if (SetsKt.setOf(new Integer[]{Boxing.boxInt(20), Boxing.boxInt(24)}).contains(Boxing.boxInt(r20.getMessageStatusLocal())) == false) goto L168;
        r45 = true;
        goto L169
    L155:
        r42 = false;
    L158:
        r43 = false;
    L147:
        r40 = false;
    L162:
        r44 = true;
        goto L164
    L134:
        r36 = null;
        goto L136
    L112:
        r33 = false;
    L117:
        if (r30 == null) goto L126;
        r32 = r30.a();
        if (r32 == null) goto L126;
        if (r32.length() <= 0) goto L123;
        boolean r47 = true;
    L124:
        if (r47 == false) goto L126;
    L127:
        if (r32 != null) goto L131;
        r32 = c(r20);
        if (r32 != null) goto L131;
        r46 = Unit.INSTANCE;
        goto L173
    L123:
        r47 = false;
    L126:
        r32 = null;
    L95:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L97
    L87:
        r26 = false;
    L104:
        r30 = null;
        goto L105
    L176:
        if (com.obric.assistant.state.impl.v2.utils.e.b(r20) == false) goto L196;
        if (com.larus.im.bean.message.a.V(r20) == false) goto L189;
        String r49 = c(r20);
        if (r49 == null) goto L182;
        String r50 = "music:" + r19 + ':' + r49;
    L183:
        if (r50 != null) goto L185;
    L187:
        boolean r51 = false;
    L188:
        if (r51 == false) goto L196;
    L185:
        if (this.h.containsKey(r50) != true) goto L187;
        r51 = true;
        goto L188
    L182:
        r50 = null;
    L189:
        r8.L$0 = r20;
        r8.L$1 = r12;
        r8.L$2 = r13;
        r8.Z$0 = r14;
        r8.label = 2;
        Object r52 = m(r19, r20, "music", "gen_music", this.h, r8);
        if (r52 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L193;
        r52 = Unit.INSTANCE;
    L193:
        if (r52 != r11) goto L299;
        return r11;
    L196:
        if (r23 == true) goto L198;
    L199:
        String r53 = c(r20);
        if (r53 != null) goto L202;
    L204:
        boolean r54 = false;
    L205:
        if (r54 == false) goto L217;
    L206:
        r8.L$0 = r20;
        r8.L$1 = r12;
        r8.L$2 = r13;
        r8.Z$0 = r14;
        r8.label = 3;
        String r55 = c(r20);
        if (r55 == null) goto L210;
        r0 = r55;
    L210:
        Object r56 = n("general_agent_music:" + r19 + ':' + r0, "gen_music", r20, r19, SetsKt.setOf(new Integer[]{Boxing.boxInt(20), Boxing.boxInt(24)}).contains(Boxing.boxInt(r20.getMessageStatusLocal())), this.j, r8);
        if (r56 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L214;
        r56 = Unit.INSTANCE;
    L214:
        if (r56 != r11) goto L299;
        return r11;
    L217:
        if (com.obric.assistant.state.impl.v2.utils.c.f(r20) == true) goto L296;
        String r57 = c(r20);
        if (r57 == null) goto L232;
        Set<String> r58 = this.i.keySet();
        if ((r58 instanceof Collection) == true) goto L224;
    L226:
        Iterator<T> r59 = r58.iterator();
    L228:
        if (r59.hasNext() == false) goto L232;
        String r60 = (String) r59.next();
        Intrinsics.checkNotNull(r60);
        if (StringsKt.startsWith$default(r60, "video_tool:" + r19 + ':' + r57 + ':', false, 2, null) == false) goto L228;
        boolean r61 = true;
    L233:
        if (r61 == true) goto L296;
        if (com.obric.assistant.state.impl.v2.utils.c.c(r20) == true) goto L265;
        String r62 = d(r19, r20);
        if (r62 != null) goto L240;
    L242:
        boolean r63 = false;
    L243:
        if (r63 == true) goto L265;
        if (com.larus.bmhome.chat.bean.d.k(r20) == false) goto L251;
        r8.L$0 = r20;
        r8.L$1 = r12;
        r8.L$2 = r13;
        r8.Z$0 = r14;
        r8.label = 6;
        if (h(r19, r20, r8) != r11) goto L299;
        return r11;
    L251:
        if (i.a(r20) == false) goto L256;
        r8.L$0 = r20;
        r8.L$1 = r12;
        r8.L$2 = r13;
        r8.Z$0 = r14;
        r8.label = 7;
        if (j(r19, r20, r8) != r11) goto L299;
        return r11;
    L256:
        if (r20.getContentType() == 6) goto L258;
    L264:
        r7 = r20;
        goto L302
    L258:
        if (com.larus.bmhome.chat.bean.d.o0(r20) == false) goto L264;
        if (com.larus.bmhome.chat.bean.d.N0(r20) == true) goto L264;
        ConcurrentHashMap<String, Message> r64 = this.g;
        r8.L$0 = r20;
        r8.L$1 = r12;
        r8.L$2 = r13;
        r8.Z$0 = r14;
        r8.label = 8;
        if (m(r19, r20, "image", "image", r64, r8) != r11) goto L299;
        return r11;
    L240:
        if (this.k.containsKey(r62) != true) goto L242;
        r63 = true;
    L265:
        r8.L$0 = r20;
        r8.L$1 = r12;
        r8.L$2 = r13;
        r8.Z$0 = r14;
        r8.label = 5;
        String r65 = d(r19, r20);
        if (r65 != null) goto L268;
        Object r66 = Unit.INSTANCE;
    L294:
        if (r66 != r11) goto L299;
        return r11;
    L268:
        ArtifactBlock r67 = com.larus.im.bean.message.a.n(r20);
        if (r67 != null) goto L271;
    L283:
        ArtifactBlock r68 = (ArtifactBlock) CollectionsKt.firstOrNull(com.obric.assistant.state.impl.v2.utils.c.a(r20));
        if (r68 == null) goto L289;
        if (SetsKt.setOf(new Integer[]{Boxing.boxInt(20), Boxing.boxInt(24)}).contains(Boxing.boxInt(r20.getMessageStatusLocal())) == false) goto L289;
        boolean r69 = true;
    L290:
        r66 = g(r65, r19, r20, r68, r69, r8);
        if (r66 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L294;
        r66 = Unit.INSTANCE;
    L289:
        r69 = false;
        goto L290
    L271:
        if (CollectionsKt.contains(com.obric.assistant.state.impl.v2.utils.c.b, r67.getResourceType()) == false) goto L283;
        Integer r70 = r67.getStatus();
        int r71 = ArtifactStatus.GENERATING.getValue();
        if (r70 != null) goto L276;
    L278:
        boolean r110 = false;
    L279:
        r66 = g(r65, r19, r20, r67, r110, r8);
        if (r66 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L294;
        r66 = Unit.INSTANCE;
        goto L294
    L276:
        if (r70.intValue() != r71) goto L278;
        r110 = true;
        goto L279
    L224:
        if (r58.isEmpty() == false) goto L226;
    L232:
        r61 = false;
    L296:
        r8.L$0 = r20;
        r8.L$1 = r12;
        r8.L$2 = r13;
        r8.Z$0 = r14;
        r8.label = 4;
        if (o(r19, r20, r8) != r11) goto L299;
        return r11;
    L202:
        if (this.j.containsKey("general_agent_music:" + r19 + ':' + r53) != true) goto L204;
        r54 = true;
        goto L205
    L198:
        if (com.larus.im.bean.message.a.V(r20) == false) goto L206;
    L74:
        this.o.add(r12);
        goto L75
    L67:
        if (com.obric.assistant.state.impl.v2.utils.c.e(r20) == true) goto L70;
        r23 = false;
        goto L72
    L58:
        r17 = null;
    L64:
        r18 = false;
        goto L65
    L18:
        if (r9.length() <= 0) goto L20;
        boolean r72 = true;
    L21:
        if (r72 == true) goto L24;
        r9 = null;
    L24:
        if (r9 != null) goto L42;
    L20:
        r72 = false;
        goto L21
    L26:
        r9 = r20.getReplyId();
        if (r9 == null) goto L41;
        if (r9.length() <= 0) goto L31;
        boolean r73 = true;
    L32:
        if (r73 == true) goto L34;
    L36:
        boolean r74 = false;
    L37:
        if (r74 == true) goto L40;
        r9 = null;
    L40:
        if (r9 != null) goto L42;
    L34:
        if (Intrinsics.areEqual(r9, "0") == true) goto L36;
        r74 = true;
        goto L37
    L31:
        r73 = false;
        goto L32
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r2 = new emitMessageAigcGenerationState.1(this, r22);
        goto L8
    }

    public final void q(String r9, Message r10, String r11, h r12) {
        l<aha.j> r13 = this.v.remove(r12);
        if (r13 != null) goto L5;
        return;
    L5:
        int r3 = r10.getMessageStatusLocal();
        h.c r5 = h.c.a;
        TaskFlowManager r0 = TaskFlowManager.a;
        jha.q r1 = TaskFlowManager.d(r.a(r9, r11));
        if (r1 == null) goto L14;
        p r2 = r1.a();
        if (r2 == null) goto L14;
        q r4 = r2.b;
        if (r4 == null) goto L14;
        u r6 = r4.b();
        if (r6 == null) goto L14;
    L15:
        TaskFlowDslKt.c(r13, new aha.j.a(r9, r11, r3, r10, r5, r6));
        return;
    L14:
        r6 = m.c(r10, false);
        goto L15
    }

    public final Object i(String r15, Message r16, String r17, boolean r18, Continuation<? super Unit> r19) {
        if ((r19 instanceof emitDeepThinkState.1) == false) goto L7;
        emitDeepThinkState.1 r4 = (emitDeepThinkState.1) r19;
        int r6 = r4.label;
        if ((r6 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r4.label = r6 - IntCompanionObject.MIN_VALUE;
    L8:
        emitDeepThinkState.1 r8 = r4;
        Object r1 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r8.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        h r2 = (h) r8.L$0;
        ResultKt.throwOnFailure(r1);
    L50:
        m r3 = (m) r1;
        if (r3 == null) goto L53;
        this.v.put(r2, r3.a);
    L56:
        return Unit.INSTANCE;
    L53:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        h r11 = new h(r15, r17);
        switch(r16.getMessageStatusLocal()) {
            case 20: goto L18;
            case 21: goto L17;
            case 22: goto L17;
            case 23: goto L17;
            case 24: goto L18;
            default: goto L56;
        };
    L17:
        q(r15, r16, r17, r11);
        goto L56
    L18:
        if (r18 == false) goto L22;
        q(r15, r16, r17, r11);
        return Unit.INSTANCE;
    L22:
        if (com.larus.im.bean.message.a.C0(r16) == true) goto L24;
    L28:
        boolean r7 = false;
    L29:
        if (r7 == true) goto L33;
        return Unit.INSTANCE;
    L33:
        if (this.v.containsKey(r11) == true) goto L35;
        Intrinsics.checkNotNullParameter(r15, "conversationId");
        k r10 = k.a;
        int r12 = com.obric.assistant.state.multitask.ext.f.a;
        jha.g r13 = TaskFlowDslKt.b(r10, com.obric.assistant.state.multitask.ext.g.a(new com.obric.assistant.state.multitask.ext.g(), new String[]{r15, r17}));
        TaskFlowManager r14 = TaskFlowManager.a;
        jha.q r20 = TaskFlowManager.d(r.a(r15, r17));
        if (r20 == null) goto L45;
        p r21 = r20.a();
        if (r21 == null) goto L45;
        q r22 = r21.b;
        if (r22 == null) goto L45;
        u r23 = r22.b();
        if (r23 == null) goto L45;
    L46:
        aha.j.b r110 = new aha.j.b(r15, r17, r16.getMessageStatusLocal(), r16, h.a.a, r23);
        jha.c r24 = jha.j.a.a(this);
        r8.L$0 = r11;
        r8.label = 1;
        r1 = TaskFlowDslKt.e(r13, r110, r24, r8);
        if (r1 != r9) goto L49;
        return r9;
    L49:
        r2 = r11;
    L45:
        r23 = m.c(r16, false);
        goto L46
    L35:
        return Unit.INSTANCE;
    L24:
        if (com.larus.bmhome.chat.bean.d.f0(r16) == false) goto L28;
        if (com.obric.assistant.state.impl.v2.utils.e.a(r16) == true) goto L28;
        r7 = true;
    L7:
        r4 = new emitDeepThinkState.1(this, r19);
        goto L8
    }

    public static final Object b(MessageStateProducer r16, String r17, Message r18, boolean r19, boolean r20, Continuation r21) {
        r16.getClass();
        if ((r21 instanceof onUpdateMessageInternal.1) == false) goto L7;
        onUpdateMessageInternal.1 r1 = (onUpdateMessageInternal.1) r21;
        int r2 = r1.label;
        if ((r2 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - IntCompanionObject.MIN_VALUE;
    L8:
        onUpdateMessageInternal.1 r9 = r1;
        Object r0 = r9.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r9.label;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L18;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        h r4 = (h) r9.L$3;
        String r5 = (String) r9.L$2;
        Message r6 = (Message) r9.L$1;
        String r7 = (String) r9.L$0;
        ResultKt.throwOnFailure(r0);
    L83:
        if (r16.b.contains(Boxing.boxInt(r6.getMessageStatusLocal())) == true) goto L86;
        r16.r(r7, r5);
        r16.s.remove(r4);
    L86:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        h r8 = (h) r9.L$3;
        String r11 = (String) r9.L$2;
        Message r12 = (Message) r9.L$1;
        String r13 = (String) r9.L$0;
        ResultKt.throwOnFailure(r0);
        h r14 = r8;
        String r15 = r11;
        Message r110 = r12;
    L17:
        String r111 = r13;
        boolean r22 = ((Boolean) r0).booleanValue();
        r9.L$0 = r111;
        r9.L$1 = r110;
        r9.L$2 = r15;
        r9.L$3 = r14;
        r9.label = 3;
        if (r16.i(r111, r110, r15, r22, r9) == r10) goto L91;
        r4 = r14;
        r5 = r15;
        r7 = r111;
        r6 = r110;
        goto L83
    L91:
        return r10;
    L18:
        h r23 = (h) r9.L$3;
        String r24 = (String) r9.L$2;
        Message r25 = (Message) r9.L$1;
        r13 = (String) r9.L$0;
        ResultKt.throwOnFailure(r0);
        r110 = r25;
    L74:
        r9.L$0 = r13;
        r9.L$1 = r110;
        r9.L$2 = r24;
        r9.L$3 = r23;
        r9.label = 2;
        r0 = r16.l(r13, r110, r24, r9);
        if (r0 == r10) goto L90;
        r14 = r23;
        r15 = r24;
        goto L17
    L90:
        return r10;
    L19:
        ResultKt.throwOnFailure(r0);
        String r26 = r18.getMessageId();
        boolean r27 = false;
        if (r26 != null) goto L22;
    L25:
        boolean r28 = true;
    L26:
        if (r28 == false) goto L45;
        String r29 = r18.getReplyId();
        if (r29 != null) goto L30;
    L33:
        boolean r30 = true;
    L34:
        if (r30 == false) goto L45;
        String r31 = r18.getLocalMessageId();
        if (r31 != null) goto L38;
    L41:
        boolean r32 = true;
    L42:
        if (r32 == false) goto L45;
        FLogger.a.i("MessageStateProducer", "onUpdateMessageInternal messageId and localMessageId are null , return");
        return Unit.INSTANCE;
    L38:
        if (r31.length() == 0) goto L41;
        r32 = false;
        goto L42
    L30:
        if (r29.length() == 0) goto L33;
        r30 = false;
    L45:
        if (com.larus.bmhome.chat.bean.d.G0(r18) == false) goto L62;
        g r33 = r16.q;
        String r34 = r18.getMessageId();
        String r35 = r18.getLocalMessageId();
        r33.getClass();
        Intrinsics.checkNotNullParameter(r17, "conversationId");
        if (r34 != null) goto L49;
    L52:
        boolean r36 = true;
    L53:
        if (r36 == true) goto L62;
        if (r35 != null) goto L56;
    L57:
        r27 = true;
    L58:
        if (r27 == true) goto L62;
        r33.a.put(new g.a(r17, r34), r35);
        goto L62
    L56:
        if (r35.length() != 0) goto L58;
    L49:
        if (r34.length() == 0) goto L52;
        r36 = false;
    L62:
        if (com.larus.bmhome.chat.bean.d.G0(r18) == false) goto L66;
        String r37 = r18.getLocalMessageId();
        if (r37 != null) goto L67;
        r37 = r18.getMessageId();
    L67:
        String r112 = r37;
        if (r112 == null) goto L88;
        h r113 = new h(r17, r112);
        r9.L$0 = r17;
        r110 = r18;
        r9.L$1 = r110;
        r9.L$2 = r112;
        r9.L$3 = r113;
        r9.label = 1;
        if (r16.k(r17, r18, r112, r19, r20, r9) == r10) goto L89;
        r13 = r17;
        r24 = r112;
        r23 = r113;
        goto L74
    L89:
        return r10;
    L88:
        return Unit.INSTANCE;
    L66:
        r37 = r16.s(r17, r18.getReplyId());
        goto L67
    L22:
        if (r26.length() == 0) goto L25;
        r28 = false;
    L7:
        r1 = new onUpdateMessageInternal.1(r16, r21);
        goto L8
    }

    public final Object g(String r10, String r11, Message r12, ArtifactBlock r13, boolean r14, Continuation<? super Unit> r15) {
        ArtifactBlock r0 = this.k.get(r10);
        String r1 = "artifact";
        if (r13 == null) goto L21;
        if (r14 == false) goto L21;
        Integer r16 = r13.getResourceType();
        if (r16 == null) goto L11;
        String r17 = r16.toString();
        if (r17 == null) goto L11;
        String r4 = r17;
    L13:
        if (this.k.put(r10, r13) != null) goto L15;
        boolean r7 = true;
    L16:
        Object r18 = u(r10, r4, r12, r11, r7, r15);
        if (r18 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        return r18;
    L20:
        return Unit.INSTANCE;
    L15:
        r7 = false;
    L11:
        r4 = "artifact";
    L21:
        if (r0 == null) goto L34;
        this.k.remove(r10);
        if (r13 == null) goto L26;
        Integer r19 = r13.getResourceType();
        if (r19 == null) goto L26;
    L27:
        if (r19 == null) goto L32;
        String r110 = r19.toString();
        if (r110 == null) goto L32;
        r1 = r110;
    L32:
        p(r10, r1, r12);
    L26:
        r19 = r0.getResourceType();
    L34:
        return Unit.INSTANCE;
    }

    public final Object k(String r18, Message r19, String r20, boolean r21, boolean r22, Continuation<? super Unit> r23) {
        String r9 = r20;
        if ((r23 instanceof emitMessageActiveState.1) == false) goto L7;
        emitMessageActiveState.1 r3 = (emitMessageActiveState.1) r23;
        int r4 = r3.label;
        if ((r4 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - IntCompanionObject.MIN_VALUE;
    L8:
        emitMessageActiveState.1 r10 = r3;
        Object r2 = r10.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r10.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        q.a r1 = (q.a) r10.L$4;
        h r6 = (h) r10.L$3;
        String r7 = (String) r10.L$2;
        Message r8 = (Message) r10.L$1;
        String r12 = (String) r10.L$0;
        ResultKt.throwOnFailure(r2);
        r9 = r7;
    L51:
        m r13 = (m) r2;
        if (r13 == null) goto L54;
        this.c.put(r6, r13.a);
        if (r13.b == true) goto L59;
        TaskFlowDslKt.f(r13.a, r1);
    L59:
        t(r12, r9, r8);
    L74:
        return Unit.INSTANCE;
    L54:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        h r14 = new h(r18, r9);
        l<q> r15 = this.c.get(r14);
        if (com.larus.bmhome.chat.bean.d.G0(r19) == true) goto L17;
    L22:
        jha.g r16 = r.a(r18, r9);
        boolean r17 = this.b.contains(Boxing.boxInt(r19.getMessageStatusLocal()));
        TaskFlowManager r24 = TaskFlowManager.a;
        jha.q r25 = TaskFlowManager.d(r16);
        if (r25 == null) goto L29;
        p r26 = r25.a();
        if (r26 == null) goto L29;
        q r27 = r26.b;
        if (r27 == null) goto L29;
        u r28 = r27.b();
    L30:
        if (r28 != null) goto L32;
    L42:
        u r110 = m.c(r19, r21);
    L43:
        FLogger.a.i("MessageStateProducer", "emitMessageState taskId:" + r16 + ",isTaskActive:" + r17 + ",status=" + r19.getMessageStatusLocal());
        if (r17 == false) goto L60;
        q.a r29 = new q.a(r18, r19.getMessageId(), r19.getMessageStatusLocal(), r19, r110);
        if (r15 != null) goto L58;
        jha.c r30 = jha.j.a.a(this);
        r10.L$0 = r18;
        r10.L$1 = r19;
        r10.L$2 = r9;
        r10.L$3 = r14;
        r10.L$4 = r29;
        r10.label = 1;
        r2 = TaskFlowDslKt.e(r16, r29, r30, r10);
        if (r2 != r11) goto L50;
        return r11;
    L50:
        r12 = r18;
        r8 = r19;
        r1 = r29;
        r6 = r14;
        goto L51
    L58:
        TaskFlowDslKt.f(r15, r29);
        r12 = r18;
        r8 = r19;
        goto L59
    L60:
        Job r31 = this.r.remove(new h(r18, r9));
        if (r31 == null) goto L63;
        Job.DefaultImpls.cancel$default(r31, null, 1, null);
    L63:
        l<q> r32 = this.c.remove(r14);
        if (r32 == null) goto L74;
        String r33 = r19.getMessageId();
        int r34 = r19.getMessageStatusLocal();
        if (com.obric.assistant.oauto.f.a(r19) == true) goto L68;
    L71:
        boolean r111 = true;
    L72:
        TaskFlowDslKt.c(r32, new q.b(r18, r33, r34, r19, MapsKt.mapOf(TuplesKt.to("round_completed", Boxing.boxBoolean(r111))), r110));
        goto L74
    L68:
        if (com.obric.assistant.oauto.f.c(r19) == true) goto L71;
        r111 = false;
        goto L72
    L32:
        if (r28.d != null) goto L36;
        if (r21 == false) goto L36;
        boolean r35 = false;
    L37:
        if (r35 == true) goto L40;
        r28 = null;
    L40:
        if (r28 == null) goto L42;
        r110 = r28;
    L36:
        r35 = true;
    L29:
        r28 = null;
        goto L30
    L17:
        if (r19.getMessageStatusLocal() != 11) goto L22;
        if (r15 != null) goto L22;
        if (r22 == true) goto L22;
        FLogger.a.i("MessageStateProducer", "ignore SEND_SUCCESS without local send task, messageId=" + r19.getMessageId() + ",localMessageId=" + r19.getLocalMessageId());
        return Unit.INSTANCE;
    L7:
        r3 = new emitMessageActiveState.1(this, r23);
        goto L8
    }

    public final Object m(String r12, Message r13, String r14, String r15, ConcurrentHashMap<String, Message> r16, Continuation<? super Unit> r17) {
        String r0 = c(r13);
        if (r0 == null) goto L5;
        Object r1 = n(r14 + ':' + r12 + ':' + r0, r15, r13, r12, SetsKt.setOf(new Integer[]{Boxing.boxInt(20), Boxing.boxInt(24)}).contains(Boxing.boxInt(r13.getMessageStatusLocal())), r16, r17);
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r1;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public final Object u(String r14, String r15, Message r16, String r17, boolean r18, Continuation<? super Unit> r19) {
        String r1 = r14;
        String r2 = r15;
        Message r3 = r16;
        String r4 = r17;
        if ((r19 instanceof startOrUpdateAigcTask.1) == false) goto L7;
        startOrUpdateAigcTask.1 r6 = (startOrUpdateAigcTask.1) r19;
        int r7 = r6.label;
        if ((r7 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r6.label = r7 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r5 = r6.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r9 = r6.label;
        if (r9 == 0) goto L14;
        if (r9 != 1) goto L13;
        o r10 = (g.a) r6.L$5;
        u r11 = (u) r6.L$4;
        String r12 = (String) r6.L$3;
        Message r13 = (Message) r6.L$2;
        String r20 = (String) r6.L$1;
        String r21 = (String) r6.L$0;
        ResultKt.throwOnFailure(r5);
        o r110 = r10;
        u r22 = r11;
        r1 = r21;
        r2 = r20;
        r4 = r12;
        r3 = r13;
    L24:
        m r23 = (m) r5;
        if (r23 == null) goto L27;
        this.d.put(r1, new a(r23.a, r2, r4, r22));
        if (r23.b == true) goto L35;
        TaskFlowDslKt.f(r23.a, r110);
    L35:
        Job r24 = this.m.remove(r1);
        if (r24 == null) goto L38;
        Job.DefaultImpls.cancel$default(r24, null, 1, null);
    L38:
        a r25 = this.d.get(r1);
        if (r25 == null) goto L43;
        this.m.put(r1, BuildersKt.launch$default(this.a, null, null, new scheduleAigcTimeout.1(this, r1, r25, r3, null), 3, null));
    L43:
        return Unit.INSTANCE;
    L27:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        a r26 = this.d.get(r14);
        if (r26 == null) goto L18;
        r22 = r26.d;
        if (r22 == null) goto L18;
    L19:
        r110 = new g.a(r15, r3, r4, r22);
        if (r26 != null) goto L31;
        Intrinsics.checkNotNullParameter(r14, DBDefinition.TASK_ID);
        jha.g r27 = TaskFlowDslKt.b(aha.f.a, r14);
        jha.c r111 = jha.j.a.a(this);
        r6.L$0 = r1;
        r6.L$1 = r2;
        r6.L$2 = r3;
        r6.L$3 = r4;
        r6.L$4 = r22;
        r6.L$5 = r110;
        r6.label = 1;
        r5 = TaskFlowDslKt.e(r27, r110, r111, r6);
        if (r5 != r8) goto L24;
        return r8;
    L31:
        if (r18 == true) goto L33;
    L34:
        TaskFlowDslKt.f(r26.a, r110);
        goto L35
    L33:
        if (Intrinsics.areEqual(r26.getType(), r15) == true) goto L35;
    L18:
        r22 = m.c(r3, false);
    L7:
        r6 = new startOrUpdateAigcTask.1(this, r19);
        goto L8
    }

    public final Object n(String r8, String r9, Message r10, String r11, boolean r12, ConcurrentHashMap<String, Message> r13, Continuation<? super Unit> r14) {
        if (r12 == false) goto L13;
        if (r13.put(r8, r10) != null) goto L6;
        boolean r5 = true;
    L7:
        Object r15 = u(r8, r9, r10, r11, r5, r14);
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        return r15;
    L11:
        return Unit.INSTANCE;
    L6:
        r5 = false;
        goto L7
    L13:
        if (r13.remove(r8) == null) goto L16;
        p(r8, r9, r10);
    L16:
        return Unit.INSTANCE;
    }
}
