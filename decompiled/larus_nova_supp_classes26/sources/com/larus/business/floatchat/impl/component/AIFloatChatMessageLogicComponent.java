package com.larus.business.floatchat.impl.component;

import android.os.Bundle;
import com.larus.bmhome.ability.FloatChatWindowEventType;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.message.GuiContext;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.observer.MessageListState;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u0013*\u0006NQTWZ]\u0018\u0000 ¾\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002¾\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010_\u001a\u00020LH\u0016J\b\u0010`\u001a\u00020LH\u0016J\b\u0010a\u001a\u00020LH\u0016J\b\u0010b\u001a\u00020LH\u0016J\u0010\u0010c\u001a\u00020L2\u0006\u0010d\u001a\u00020)H\u0016J\u0010\u0010e\u001a\u00020L2\u0006\u0010d\u001a\u00020)H\u0016J\u0012\u0010f\u001a\u00020L2\b\u0010g\u001a\u0004\u0018\u000106H\u0016J$\u0010h\u001a\u00020L2\u001a\u0010i\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0I\u0018\u00010jH\u0016J\n\u0010k\u001a\u0004\u0018\u00010'H\u0016J\n\u0010l\u001a\u0004\u0018\u00010'H\u0016J\b\u0010m\u001a\u00020LH\u0002J\n\u0010n\u001a\u0004\u0018\u00010=H\u0016J\u000e\u0010o\u001a\b\u0012\u0004\u0012\u00020-0jH\u0016J\b\u0010p\u001a\u00020@H\u0016J\b\u0010q\u001a\u00020@H\u0016J\n\u0010r\u001a\u0004\u0018\u00010=H\u0002J\u001c\u0010s\u001a\u00020L2\b\u0010t\u001a\u0004\u0018\u00010=2\b\u0010u\u001a\u0004\u0018\u00010=H\u0002J\u0010\u0010v\u001a\u00020L2\u0006\u0010w\u001a\u00020@H\u0002J\u001c\u0010x\u001a\u00020L2\b\u0010y\u001a\u0004\u0018\u00010'2\b\u0010z\u001a\u0004\u0018\u00010{H\u0016J\u0010\u0010|\u001a\u00020L2\u0006\u0010}\u001a\u00020~H\u0016J\u0011\u0010\u007f\u001a\u00020L2\u0007\u0010\u0080\u0001\u001a\u00020CH\u0016J\u0012\u0010\u0081\u0001\u001a\u00020L2\u0007\u0010\u0082\u0001\u001a\u00020'H\u0002J\t\u0010\u0083\u0001\u001a\u00020LH\u0016J\f\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0016J\u001b\u0010\u0086\u0001\u001a\u00020L2\u0007\u0010\u0087\u0001\u001a\u00020'2\u0007\u0010\u0088\u0001\u001a\u00020'H\u0016J\\\u0010\u0089\u0001\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'\u0018\u0001082\u0015\u0010\u008a\u0001\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'\u0018\u0001082\u0015\u0010\u008b\u0001\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'\u0018\u0001082\u0015\u0010\u008c\u0001\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'\u0018\u000108H\u0002J8\u0010\u008d\u0001\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010j2\u000f\u0010\u008a\u0001\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010j2\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010;2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010;H\u0002J\u0017\u0010\u0090\u0001\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'\u0018\u000108H\u0002J\u0017\u0010\u0091\u0001\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'\u0018\u000108H\u0002J!\u0010\u0092\u0001\u001a\u00020L2\u0015\b\u0004\u0010\u0093\u0001\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020L0KH\u0082\bJ\u001b\u0010\u0094\u0001\u001a\u00020L2\u0007\u0010\u0095\u0001\u001a\u00020-2\u0007\u0010\u0096\u0001\u001a\u00020@H\u0002J\r\u0010\u0097\u0001\u001a\u00020@*\u00020-H\u0002J\u0018\u0010\u0098\u0001\u001a\u00020@2\r\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020'0jH\u0002J!\u0010\u009a\u0001\u001a\u00020L2\u0007\u0010\u009b\u0001\u001a\u00020'2\r\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020-0jH\u0002J\r\u0010\u009d\u0001\u001a\u00020@*\u00020-H\u0002J\u0012\u0010\u009e\u0001\u001a\u00020@2\u0007\u0010\u0095\u0001\u001a\u00020-H\u0002J\u0012\u0010\u009f\u0001\u001a\u00020L2\u0007\u0010\u0095\u0001\u001a\u00020-H\u0002J\u0012\u0010 \u0001\u001a\u00020L2\u0007\u0010\u0095\u0001\u001a\u00020-H\u0002J\t\u0010¡\u0001\u001a\u00020LH\u0002J\u001b\u0010¢\u0001\u001a\u00020L2\u0007\u0010\u0095\u0001\u001a\u00020-2\u0007\u0010\u008a\u0001\u001a\u00020'H\u0002J\u001d\u0010£\u0001\u001a\u00020L2\b\u0010y\u001a\u0004\u0018\u00010'2\b\u0010z\u001a\u0004\u0018\u00010{H\u0002J\u0012\u0010¤\u0001\u001a\u00020@2\u0007\u0010¥\u0001\u001a\u00020{H\u0002J\u0018\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020'0j2\u0007\u0010\u0095\u0001\u001a\u00020-H\u0002J\u0014\u0010§\u0001\u001a\u0004\u0018\u00010'2\u0007\u0010\u0095\u0001\u001a\u00020-H\u0002J\u0018\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020'0j2\u0007\u0010\u0095\u0001\u001a\u00020-H\u0002J\u0012\u0010©\u0001\u001a\u00020@2\u0007\u0010\u0095\u0001\u001a\u00020-H\u0002J\u0012\u0010ª\u0001\u001a\u00020@2\u0007\u0010\u0095\u0001\u001a\u00020-H\u0002J\u0012\u0010¯\u0001\u001a\u00020L2\u0007\u0010\u0095\u0001\u001a\u00020-H\u0002J\u0018\u0010²\u0001\u001a\u00020@2\r\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020'0jH\u0002J\t\u0010´\u0001\u001a\u00020LH\u0002J\u0012\u0010µ\u0001\u001a\u00020L2\u0007\u0010\u0095\u0001\u001a\u00020-H\u0002J\u0016\u0010¶\u0001\u001a\u00020L2\u000b\b\u0002\u0010·\u0001\u001a\u0004\u0018\u00010'H\u0002J!\u0010¸\u0001\u001a\u00020L2\u0007\u0010\u0095\u0001\u001a\u00020-2\r\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020'0jH\u0002J\u0012\u0010¹\u0001\u001a\u00020L2\u0007\u0010\u0095\u0001\u001a\u00020-H\u0002J\u0010\u0010c\u001a\u00020L2\u0006\u00101\u001a\u00020'H\u0002J\u0010\u0010e\u001a\u00020L2\u0006\u00101\u001a\u00020'H\u0002J\u0011\u0010º\u0001\u001a\u00020L2\u0006\u00101\u001a\u00020'H\u0002J\u0011\u0010»\u0001\u001a\u00020L2\u0006\u00101\u001a\u00020'H\u0002J\t\u0010¼\u0001\u001a\u00020LH\u0002J\t\u0010½\u0001\u001a\u00020LH\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0004\n\u0002\u0010DR\u000e\u0010E\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010H\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0I0&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010J\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020L0KX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0004\n\u0002\u0010OR\u0010\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0004\n\u0002\u0010RR\u0010\u0010S\u001a\u00020TX\u0082\u0004¢\u0006\u0004\n\u0002\u0010UR\u0010\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010XR\u0010\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0004\n\u0002\u0010[R\u0010\u0010\\\u001a\u00020]X\u0082\u0004¢\u0006\u0004\n\u0002\u0010^R\u0018\u0010«\u0001\u001a\u00030¬\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u00ad\u0001\u0010®\u0001R\u001b\u0010°\u0001\u001a\u00020@*\u00020-8BX\u0082\u0004¢\u0006\b\u001a\u0006\b°\u0001\u0010±\u0001¨\u0006¿\u0001"}, d2 = {"Lcom/larus/business/floatchat/impl/component/AIFloatChatMessageLogicComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/business/floatchat/api/ability/IAIChatMessageLogicAbility;", "Lcom/larus/bmhome/ability/FloatChatWindowStateChangeListener;", "<init>", "()V", "chatListCoreAbility", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListCoreAbility", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListCoreAbility$delegate", "Lkotlin/Lazy;", "chatListComponentAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListComponentAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListComponentAbility$delegate", "chatInputUiCoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUiCoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUiCoreAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatBottomSpeakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getChatBottomSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "chatBottomSpeakerAbility$delegate", "foldCoreAbility", "Lcom/larus/bmhome/ability/IAIFloatChatFoldCoreAbility;", "getFoldCoreAbility", "()Lcom/larus/bmhome/ability/IAIFloatChatFoldCoreAbility;", "foldCoreAbility$delegate", "handledSendMessageIds", "Lcom/flow/kmp/common/collections/CopyOnWriteArraySet;", "", "messageChangedObservers", "Lcom/larus/business/floatchat/api/OnMessageChangedObserver;", "currentAnchorMessageIds", "currentAnchorMessages", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/im/bean/message/Message;", "receivedEndNotifiedKeys", "answerIntentDispatchedKeys", "currentPrimaryAnchorMessageId", "conversationId", "registeredConvChangeListenerId", "registeredMsgObserverId", "registeredStreamObserverId", "chatContextProvider", "Lcom/larus/business/floatchat/api/ChatContextProvider;", "componentReqExt", "", "componentBizExt", "componentGuiContext", "Lcom/larus/im/bean/message/GuiContext;", "previewRoundMessageFilterConfig", "Lcom/larus/bmhome/ability/PreviewRoundMessageFilterConfig;", "currentSendCollectionId", "currentSendIsVui", "", "enteredPreviewState", "windowDragStartProgress", "", "Ljava/lang/Float;", "isDragging", "isResumed", "voiceInputActive", "cmdBizTypePairs", "Lkotlin/Pair;", "inputFocusChangeListener", "Lkotlin/Function1;", "", "speakerStateListener", "com/larus/business/floatchat/impl/component/AIFloatChatMessageLogicComponent$speakerStateListener$1", "Lcom/larus/business/floatchat/impl/component/AIFloatChatMessageLogicComponent$speakerStateListener$1;", "conversationChangeListener", "com/larus/business/floatchat/impl/component/AIFloatChatMessageLogicComponent$conversationChangeListener$1", "Lcom/larus/business/floatchat/impl/component/AIFloatChatMessageLogicComponent$conversationChangeListener$1;", "messageChangedObserver", "com/larus/business/floatchat/impl/component/AIFloatChatMessageLogicComponent$messageChangedObserver$1", "Lcom/larus/business/floatchat/impl/component/AIFloatChatMessageLogicComponent$messageChangedObserver$1;", "streamObserver", "com/larus/business/floatchat/impl/component/AIFloatChatMessageLogicComponent$streamObserver$1", "Lcom/larus/business/floatchat/impl/component/AIFloatChatMessageLogicComponent$streamObserver$1;", "sendMessageListener", "com/larus/business/floatchat/impl/component/AIFloatChatMessageLogicComponent$sendMessageListener$1", "Lcom/larus/business/floatchat/impl/component/AIFloatChatMessageLogicComponent$sendMessageListener$1;", "asrResultRewriteInterceptor", "com/larus/business/floatchat/impl/component/AIFloatChatMessageLogicComponent$asrResultRewriteInterceptor$1", "Lcom/larus/business/floatchat/impl/component/AIFloatChatMessageLogicComponent$asrResultRewriteInterceptor$1;", "onParentViewCreated", "onResume", "onPause", "onFragmentViewDestroyed", "registerMessageChangedObserver", "changedListener", "unregisterMessageChangedObserver", "setChatContextProvider", "provider", "registerCmdBizType", "bizToTypePairs", "", "getOriginMessageId", "getPageName", "updatePreviewRoundFilter", "getPreviewRoundMessageFilterConfig", "getCurrentAnchorMessages", "isCurrentAnswerInProgress", "shouldForceLoadingWhenStreaming", "buildPreviewRoundMessageFilterConfig", "updatePreviewRoundFilterConfig", "newConfig", "oldConfig", "refreshPreviewRoundFilterList", "scrollToLatest", "onReceiveRefreshCmd", "queryMsgId", "viewBusinessPayload", "Lcom/larus/bmhome/ability/ViewBusinessPayload;", "onWindowStateChanged", "snapshot", "Lcom/larus/bmhome/ability/FloatChatWindowSnapshot;", "onWindowDragProgress", "progress", "clearPreviewRoundFilter", "reason", "updateChatPageContext", "getChatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "updateChatPageRequestHeader", "key", "value", "mergeExt", MusicAppletPage.KEY_SOURCE, "oldComponentExt", "newComponentExt", "mergeGuiContext", "oldComponentGuiContext", "newComponentGuiContext", "buildRequestExt", "buildBizExt", "notifyMessageChangedObservers", "callback", "handleSendSuccess", "msg", "requireSuccess", "ignoreMessage", "shouldHandleSelfMessageUpdate", "anchorMessageIds", "handleVuiInsertedMessages", "cid", "msgList", "isVuiSendMessage", "isCurrentVuiReply", "handleAnswerIntentOnStreamEnd", "handleFirstTokenAnswerIntent", "dispatchStartedReplyFromCurrentListIfNeeded", "dispatchAnswerIntentIfNeeded", "handleRefreshPageIntent", "shouldHandleRefreshPayload", "payload", "resolveMessageIds", "resolvePrimaryMessageId", "resolveReceiveMessageKeys", "isReplyStarted", "isReplyBodyStarted", "answerIntentLogic", "", "getAnswerIntentLogic", "()I", "dispatchReceiveMessageEndIfNeeded", "isReceiveFinish", "(Lcom/larus/im/bean/message/Message;)Z", "markSendMessageHandled", "messageIds", "syncAnchorMessageIdsFromCurrentList", "syncAnchorMessageIds", "beginCurrentSendRound", "collectionId", "ensureCurrentSendRound", "upsertCurrentAnchorMessage", "registerStreamObserver", "unregisterStreamObserver", "registerCurrentConversationObservers", "unregisterCurrentConversationObservers", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIFloatChatMessageLogicComponent extends Component implements ew8.b, va8.i {
    public static final /* synthetic */ int W = 0;
    public String A;
    public String B;
    public dw8.p C;
    public Map<String, String> D;
    public Map<String, String> E;
    public GuiContext F;
    public va8.p0 G;
    public String H;
    public boolean I;
    public boolean J;
    public Float K;
    public boolean L;
    public boolean M;
    public boolean N;
    public vt7.b<Pair<String, String>> O;
    public final d0 P;
    public final f Q;
    public final c R;
    public final d S;
    public final m T;
    public final e U;
    public final b V;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final vt7.b<String> r;
    public final vt7.b<dw8.t> s;
    public final vt7.b<String> t;
    public final CopyOnWriteArrayList<Message> u;
    public final vt7.b<String> v;
    public final vt7.b<String> w;
    public String x;
    public String y;
    public String z;

    public static final class a {
    }

    public static final class b implements ICoreInputAbility.c {
        public final /* synthetic */ AIFloatChatMessageLogicComponent a;

        public b(AIFloatChatMessageLogicComponent r1) {
            this.a = r1;
        }

        public final String a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "asrResult");
            this.a.KA();
            return r2;
        }

        public final String b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
            return r2;
        }
    }

    public static final class c implements com.larus.im.service.d0<wc9.e> {
        public final /* synthetic */ AIFloatChatMessageLogicComponent a;

        public c(AIFloatChatMessageLogicComponent r1) {
            this.a = r1;
        }

        public final void c(Object r2) {
            Intrinsics.checkNotNullParameter((wc9.e) r2, "conversation");
        }

        public final void a(wc9.e r5, wc9.e r6) {
            Intrinsics.checkNotNullParameter(r6, "new");
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("onReplaceConversation, targetId=");
            if (r5 == null) goto L5;
            String r3 = r5.a;
        L6:
            r1.append(r3);
            r1.append(", newId=");
            r1.append(r6.a);
            r0.i("AIFloatChatMessageLogicComponent", r1.toString());
            String r2 = this.a.y;
            if (r2 == null) goto L11;
            Lazy r4 = ic8.n.a;
            Intrinsics.checkNotNullParameter(r2, "<this>");
            boolean r7 = true;
            if (com.larus.im.j.f(r2) != true) goto L11;
        L12:
            if (r7 == false) goto L33;
            String r8 = this.a.y;
            if (r5 == null) goto L16;
            String r9 = r5.a;
        L18:
            if (Intrinsics.areEqual(r8, r9) == false) goto L34;
            AIFloatChatMessageLogicComponent r10 = this.a;
            r10.y = r6.a;
            if (r5 == null) goto L29;
            String r11 = r5.a;
            if (r11 == null) goto L29;
            com.larus.im.d.e().unregisterOnMessageChangedObserver(r11, r10.S);
            if (Intrinsics.areEqual(r10.A, r11) == false) goto L26;
            r10.A = null;
        L26:
            com.larus.im.internal.stream.b.a.e(r11, r10.T);
            if (Intrinsics.areEqual(r10.B, r11) == false) goto L29;
            r10.B = null;
        L29:
            AIFloatChatMessageLogicComponent r12 = this.a;
            if (r12.M == false) goto L35;
            r12.B3(r6.a);
            this.a.C3(r6.a);
            return;
        L35:
            return;
        L34:
            return;
        L16:
            r9 = null;
            goto L18
        L33:
            return;
        L11:
            r7 = false;
            goto L12
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class d implements nf9.b {
        public final /* synthetic */ AIFloatChatMessageLogicComponent a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[MessageListState.values().length];
                r0[MessageListState.INSERT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[MessageListState.UPDATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
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

        public d(AIFloatChatMessageLogicComponent r1) {
            this.a = r1;
        }

        public final void a(String r4, Message r5) {
            Intrinsics.checkNotNullParameter(r4, "cid");
            Intrinsics.checkNotNullParameter(r5, "msg");
            AIFloatChatMessageLogicComponent r0 = this.a;
            if (r0.M == true) goto L5;
            return;
        L5:
            r0.m3(r5, false);
            FLogger.a.i("AIFloatChatMessageLogicComponent", "onSendMessage, cid=" + r4 + ", msg=" + r5);
        }

        public final void b(String r10, MessageListState r11, List<Message> r12) {
            Intrinsics.checkNotNullParameter(r10, "cid");
            Intrinsics.checkNotNullParameter(r11, "state");
            Intrinsics.checkNotNullParameter(r12, "msgList");
            if (this.a.M == true) goto L5;
            return;
        L5:
            int r13 = a.a[r11.ordinal()];
            if (r13 != 1) goto L8;
            AIFloatChatMessageLogicComponent r14 = this.a;
            r14.getClass();
            List<Message> r15 = r12;
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r15.iterator();
        L17:
            String r4 = null;
            boolean r5 = false;
            if (r2.hasNext() == false) goto L29;
            Object r3 = r2.next();
            Message r6 = (Message) r3;
            if (com.larus.bmhome.chat.bean.d.G0(r6) == false) goto L27;
            Map r7 = r6.getExt();
            if (r7 == null) goto L25;
            r4 = (String) r7.get("call_id");
        L25:
            if (com.larus.utils.o0.d(r4) == false) goto L27;
            r5 = true;
        L27:
            if (r5 == false) goto L17;
            r1.add(r3);
            goto L17
        L29:
            Iterator r8 = r1.iterator();
        L31:
            if (r8.hasNext() == false) goto L33;
            Message r9 = (Message) r8.next();
            r14.m3(r9, false);
            FLogger.a.i("AIFloatChatMessageLogicComponent", "handleVuiInsertSendMessage, cid=" + r10 + ", msg=" + r9);
            goto L31
        L33:
            ArrayList r16 = new ArrayList();
            Iterator<T> r17 = r15.iterator();
        L35:
            if (r17.hasNext() == false) goto L60;
            Object r18 = r17.next();
            Message r19 = (Message) r18;
            if (com.larus.bmhome.chat.bean.d.G0(r19) == true) goto L57;
            String r20 = r19.getReplyId();
            if (r20 != null) goto L41;
        L54:
            boolean r21 = false;
        L55:
            if (r21 == false) goto L57;
            boolean r22 = true;
        L58:
            if (r22 == false) goto L35;
            r16.add(r18);
            goto L35
        L41:
            if (r20.length() <= 0) goto L43;
            boolean r23 = true;
        L44:
            if (r23 == true) goto L47;
            r20 = null;
        L47:
            if (r20 == null) goto L54;
            if (r14.I == false) goto L54;
            if (r14.t.contains(r20) == false) goto L54;
            r21 = true;
            goto L55
        L43:
            r23 = false;
        L57:
            r22 = false;
            goto L58
        L60:
            Iterator r110 = r16.iterator();
        L62:
            if (r110.hasNext() == false) goto L88;
            Message r0 = (Message) r110.next();
            Iterator r24 = r14.s.iterator();
        L65:
            if (r24.hasNext() == false) goto L67;
            ((dw8.t) r24.next()).p(r0);
            goto L65
        L67:
            r14.N2(r0);
            r14.h3(r0);
            FLogger.a.i("AIFloatChatMessageLogicComponent", "handleVuiInsertReplyMessage, cid=" + r10 + ", replyId=" + r0.getReplyId() + ", msgId=" + r0.getMessageId());
            goto L62
        L88:
            return;
        L8:
            if (r13 != 2) goto L68;
            AIFloatChatMessageLogicComponent r111 = this.a;
            Iterator<T> r112 = r12.iterator();
        L12:
            if (r112.hasNext() == false) goto L87;
            Message r113 = (Message) r112.next();
            if (com.larus.bmhome.chat.bean.d.G0(r113) == false) goto L12;
            r111.H3(r113);
            goto L12
        L87:
            return;
        }

        public final void c(String r3, Message r4, Map<String, String> r5) {
            Intrinsics.checkNotNullParameter(r3, "cid");
            Intrinsics.checkNotNullParameter(r4, "msg");
            if (this.a.M == true) goto L6;
            return;
        L6:
            if (com.larus.bmhome.chat.bean.d.G0(r4) == false) goto L9;
            this.a.m3(r4, true);
            FLogger.a.i("AIFloatChatMessageLogicComponent", "onUpdateSelfMessage, cid=" + r3 + ", msg=" + r4);
            return;
        L9:
            Iterator r6 = this.a.s.iterator();
        L11:
            if (r6.hasNext() == false) goto L13;
            ((dw8.t) r6.next()).p(r4);
            goto L11
        L13:
            this.a.N2(r4);
            this.a.h3(r4);
        }

        public final void e(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
            if (this.a.M == true) goto L6;
            return;
        L6:
            if (com.larus.bmhome.chat.bean.d.G0(r2) == true) goto L11;
            Iterator r4 = this.a.s.iterator();
        L9:
            if (r4.hasNext() == false) goto L13;
            ((dw8.t) r4.next()).p(r2);
            goto L9
        L13:
            return;
        }
    }

    public static final class e implements ICoreInputAbility.d {
        public final /* synthetic */ AIFloatChatMessageLogicComponent a;

        public final void a() {
        }

        public final void b(ICoreInputAbility.OnSendParams r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
        }

        public final void c() {
            this.a.KA();
        }

        public e(AIFloatChatMessageLogicComponent r1) {
            this.a = r1;
        }
    }

    public static final class f implements com.larus.bmhome.chat.component.bottom.core.speaker.h {
        public final /* synthetic */ AIFloatChatMessageLogicComponent a;

        public f(AIFloatChatMessageLogicComponent r1) {
            this.a = r1;
        }

        public final void a(com.larus.bmhome.chat.component.bottom.core.speaker.g r2) {
            Intrinsics.checkNotNullParameter(r2, "state");
            if (Intrinsics.areEqual(r2, com.larus.bmhome.chat.component.bottom.core.speaker.g.c.a) == false) goto L11;
            AIFloatChatMessageLogicComponent r3 = this.a;
            if (r3.N == true) goto L25;
            r3.N = true;
            Iterator r4 = r3.s.iterator();
        L8:
            if (r4.hasNext() == false) goto L27;
            ((dw8.t) r4.next()).y();
            goto L8
        L27:
            return;
        L25:
            return;
        L11:
            if ((r2 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.e) == false) goto L13;
        L22:
            this.a.N = false;
            return;
        L13:
            if (Intrinsics.areEqual(r2, com.larus.bmhome.chat.component.bottom.core.speaker.g.a.a) == true) goto L22;
            if (Intrinsics.areEqual(r2, com.larus.bmhome.chat.component.bottom.core.speaker.g.b.a) == true) goto L22;
            if ((r2 instanceof com.larus.bmhome.chat.component.bottom.core.speaker.g.d) == false) goto L21;
            return;
        L21:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class g implements Function0<va8.p> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.p.class));
        }
    }

    public static final class h implements Function0<u7> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
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

    public static final class j implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
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

    public static final class k implements Function0<com.larus.bmhome.chat.component.bottom.core.speaker.l> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
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

    public static final class l implements Function0<va8.k> {
        public final /* synthetic */ AttachReceiver a;

        public l(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.k.class));
        }
    }

    public static final class m implements nf9.c {
        public final /* synthetic */ AIFloatChatMessageLogicComponent a;

        public final void B(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
        }

        public final void C(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
        }

        public m(AIFloatChatMessageLogicComponent r1) {
            this.a = r1;
        }

        public final void A(Message r5) {
            Intrinsics.checkNotNullParameter(r5, "message");
            AIFloatChatMessageLogicComponent r0 = this.a;
            if (r0.M == true) goto L6;
            return;
        L6:
            if (r0.X2() != 0) goto L25;
            String r1 = r5.getReplyId();
            if (r1 != null) goto L11;
            return;
        L11:
            if (r1.length() <= 0) goto L13;
            boolean r2 = true;
        L14:
            if (r2 == true) goto L17;
            r1 = null;
        L17:
            if (r1 == null) goto L26;
            r0.Q3();
            if (r0.t.contains(r1) == false) goto L27;
            r0.L2(r5, "streamEnd");
            FLogger.a.i("AIFloatChatMessageLogicComponent", "handleAnswerIntentOnStreamEnd, replyId=" + r1 + ", anchors=" + r0.t);
            return;
        L27:
            return;
        L26:
            return;
        L13:
            r2 = false;
            goto L14
        }
    }

    static {
    }

    public final void A2() {
        this.M = false;
        va8.k r1 = Y2();
        if (r1 == null) goto L5;
        r1.z40(this);
    L5:
        va8.o r2 = (va8.o) this.n.getValue();
        if (r2 == null) goto L8;
        r2.oR(this.P);
    L8:
        ICoreInputAbility r3 = (ICoreInputAbility) this.o.getValue();
        if (r3 == null) goto L11;
        r3.XG(this.U);
    L11:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r4 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.p.getValue();
        if (r4 == null) goto L14;
        r4.B9(this.Q);
    L14:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r5 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.p.getValue();
        if (r5 == null) goto L17;
        r5.Qs(this.V);
    L17:
        String r6 = this.z;
        if (r6 == null) goto L20;
        com.larus.im.d.c().unRegisterConversationChangeListener(r6, this.R);
    L20:
        this.z = null;
        V3();
        this.r.clear();
        this.s.clear();
        this.t.clear();
        this.u.clear();
        this.v.clear();
        this.w.clear();
        this.O.clear();
        this.x = null;
        this.G = null;
        this.H = null;
        this.J = false;
        this.K = null;
        this.L = false;
        this.N = false;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
    }

    public final void onPause() {
        this.M = false;
        V3();
    }

    public final void onResume() {
        this.M = true;
        z3();
    }

    @Override // ew8.b
    public final va8.p0 Je() {
        if (this.L == false) goto L7;
        return null;
    L7:
        return this.G;
    }

    @Override // ew8.b
    public final void KA() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        ChatPageContext r2 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).a(ChatPageContext.class);
        Map<String, String> r3 = this.D;
        Map<String, String> r4 = this.E;
        final GuiContext r5 = this.F;
        LinkedHashMap r6 = new LinkedHashMap();
        dw8.p r7 = this.C;
        if (r7 == null) goto L7;
        Map<String, String> r8 = r7.getExtra();
        if (r8 == null) goto L7;
        r6.putAll(r8);
    L7:
        dw8.p r9 = this.C;
        if (r9 == null) goto L12;
        Integer r10 = r9.getSource();
        if (r10 == null) goto L12;
        r6.put("chat_entry_source", String.valueOf(r10.intValue()));
    L12:
        dw8.p r11 = this.C;
        String r12 = "1";
        if (r11 != null) goto L15;
    L19:
        va8.k r13 = Y2();
        if (r13 == null) goto L28;
        FloatChatWindowState r14 = r13.getWindowState();
        if (r14 == null) goto L28;
        if (r14 == FloatChatWindowState.Collapsed) goto L27;
        r12 = TriggerSendLoading.NO_LOADING;
    L27:
        r6.put("is_chat_flow_collapsed", r12);
    L28:
        dw8.p r15 = this.C;
        boolean r16 = true;
        int r17 = 0;
        Collection<String> r18 = null;
        if (r15 == null) goto L41;
        String r19 = r15.m();
        if (r19 == null) goto L41;
        if (r19.length() <= 0) goto L35;
        boolean r110 = true;
    L36:
        if (r110 == true) goto L39;
        r19 = null;
    L39:
        if (r19 == null) goto L41;
        r6.put("origin_message_id", r19);
        goto L41
    L35:
        r110 = false;
    L41:
        dw8.p r20 = this.C;
        if (r20 == null) goto L55;
        String r21 = r20.b();
        if (r21 == null) goto L55;
        if (r21.length() <= 0) goto L48;
        boolean r111 = true;
    L49:
        if (r111 == true) goto L52;
        r21 = null;
    L52:
        if (r21 == null) goto L55;
        r6.put("biz_task_id", r21);
        goto L55
    L48:
        r111 = false;
    L55:
        if ((!r6.isEmpty()) == true) goto L58;
        r6 = null;
    L58:
        dw8.p r22 = this.C;
        if (r22 == null) goto L61;
        Map<String, String> r23 = r22.getLogExtra();
    L62:
        if (r23 != null) goto L64;
        r23 = MapsKt.emptyMap();
    L64:
        Map<String, String> r24 = MapsKt.toMutableMap(r23);
        dw8.p r112 = this.C;
        if (r112 == null) goto L77;
        String r113 = r112.getPageName();
        if (r113 == null) goto L77;
        if (r113.length() <= 0) goto L71;
        boolean r114 = true;
    L72:
        if (r114 == true) goto L75;
        r113 = null;
    L75:
        if (r113 == null) goto L77;
        r24.put("saas_current_page", r113);
        goto L77
    L71:
        r114 = false;
    L77:
        dw8.p r115 = this.C;
        if (r115 == null) goto L91;
        String r116 = r115.m();
        if (r116 == null) goto L91;
        if (r116.length() <= 0) goto L84;
        boolean r117 = true;
    L85:
        if (r117 == true) goto L88;
        r116 = null;
    L88:
        if (r116 == null) goto L91;
        r24.put("origin_message_id", r116);
        goto L91
    L84:
        r117 = false;
    L91:
        if ((!r24.isEmpty()) == true) goto L94;
        r24 = null;
    L94:
        dw8.p r118 = this.C;
        if (r118 == null) goto L100;
        if (r6 != null) goto L98;
        Map<String, String> r119 = MapsKt.emptyMap();
    L99:
        final GuiContext r120 = r118.a(r119);
    L101:
        this.D = r6;
        this.E = r24;
        this.F = r120;
        if (r2 != null) goto L104;
        ChatPageContext r25 = new ChatPageContext(null, null, null, null, null, null, 63, null);
    L105:
        if (r2 == null) goto L107;
        Map r121 = r2.getReqExt();
    L108:
        Map r26 = p3(r121, r3, r6);
        if (r2 == null) goto L111;
        Map r27 = r2.getBizExt();
    L112:
        Map r28 = p3(r27, r4, r24);
        if (r2 == null) goto L115;
        List r29 = r2.getGuiContext();
    L116:
        if (r29 != null) goto L118;
        r29 = CollectionsKt.emptyList();
    L118:
        List r30 = CollectionsKt.toMutableList(r29);
        if (r5 == null) goto L121;
        CollectionsKt.removeAll(r30, new e0(r5));
    L121:
        if (r120 == null) goto L124;
        CollectionsKt.removeAll(r30, new f0(r120));
        r30.add(r120);
    L124:
        if ((!r30.isEmpty()) == false) goto L126;
        List r210 = r30;
    L127:
        ChatPageContext r31 = ChatPageContext.copy$default(r25, null, r26, null, r210, r28, null, 37, null);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).n(r31, ChatPageContext.class);
        FLogger r1 = FLogger.a;
        StringBuilder r32 = new StringBuilder("updateChatPageContext componentReqExt=");
        if (r6 == null) goto L130;
        Collection r33 = r6.values();
    L131:
        r32.append(r33);
        r32.append(", componentBizExt=");
        if (r24 == null) goto L134;
        r18 = r24.values();
    L134:
        r32.append(r18);
        r32.append(", hasComponentGuiContext=");
        if (r120 != null) goto L138;
        r16 = false;
    L138:
        r32.append(r16);
        r32.append(", mergedGuiContextSize=");
        List r34 = r31.getGuiContext();
        if (r34 == null) goto L141;
        r17 = r34.size();
    L141:
        r32.append(r17);
        r1.i("AIFloatChatMessageLogicComponent", r32.toString());
        r1.d("AIFloatChatMessageLogicComponent", "updateChatPageContext nextContext=" + r31);
        return;
    L130:
        r33 = null;
        goto L131
    L126:
        r210 = null;
        goto L127
    L115:
        r29 = null;
        goto L116
    L111:
        r27 = null;
        goto L112
    L107:
        r121 = null;
        goto L108
    L104:
        r25 = r2;
        goto L105
    L98:
        r119 = r6;
        goto L99
    L100:
        r120 = null;
        goto L101
    L61:
        r23 = null;
        goto L62
    L15:
        if (r11.c() == false) goto L17;
        Object r35 = "1";
    L18:
        r6.put("is_first_open_in_source_page", r35);
        goto L19
    L17:
        r35 = TriggerSendLoading.NO_LOADING;
        goto L18
    }

    @Override // ew8.b
    public final ChatPageContext M1() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        return s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).a(ChatPageContext.class);
    }

    @Override // ew8.b
    public final List<Message> NJ() {
        return CollectionsKt.toList(this.u);
    }

    public final void Q3() {
        va8.p r0 = (va8.p) this.l.getValue();
        if (r0 == null) goto L10;
        List r1 = r0.getCurrentList();
        if (r1 == null) goto L12;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        H3((Message) r2.next());
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public final void V3() {
        String r0 = this.A;
        if (r0 == null) goto L7;
        com.larus.im.d.e().unregisterOnMessageChangedObserver(r0, this.S);
        if (Intrinsics.areEqual(this.A, r0) == false) goto L7;
        this.A = null;
    L7:
        String r1 = this.B;
        if (r1 == null) goto L12;
        int r2 = com.larus.im.d.a;
        com.larus.im.internal.stream.b.a.e(r1, this.T);
        if (Intrinsics.areEqual(this.B, r1) == false) goto L12;
        this.B = null;
    L12:
        FLogger.a.i("AIFloatChatMessageLogicComponent", "unregisterCurrentConversationObservers, cid=" + this.y);
    }

    public final void W3() {
        va8.p0 r0 = this.G;
        va8.k r1 = Y2();
        va8.p0 r2 = null;
        if (r1 == null) goto L5;
        FloatChatWindowState r3 = r1.getWindowState();
    L7:
        if (r3 == FloatChatWindowState.Expanded) goto L22;
        vt7.b<String> r4 = this.t;
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L11:
        if (r6.hasNext() == false) goto L18;
        Object r7 = r6.next();
        if (((String) r7).length() <= 0) goto L15;
        boolean r8 = true;
    L16:
        if (r8 == false) goto L11;
        r5.add(r7);
        goto L11
    L15:
        r8 = false;
        goto L16
    L18:
        va8.p0 r9 = new va8.p0(CollectionsKt.toSet(r5));
        if ((!r9.a.isEmpty()) == false) goto L22;
        r2 = r9;
    L22:
        if (Intrinsics.areEqual(r2, r0) == true) goto L37;
        this.G = r2;
        u7 r10 = (u7) this.m.getValue();
        if (r10 == null) goto L27;
        r10.C90();
    L27:
        va8.p r11 = (va8.p) this.l.getValue();
        if (r11 == null) goto L30;
        r11.O5(true);
    L30:
        FLogger.a.i("AIFloatChatMessageLogicComponent", "updatePreviewRoundFilter old=" + r0 + ", new=" + r2);
        return;
    L37:
        return;
    L5:
        r3 = null;
        goto L7
    }

    public final int X2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r0 == null) goto L17;
        Integer r1 = Integer.valueOf(r0.getInt("answer_intent_logic", 0));
        int r2 = r1.intValue();
        boolean r3 = true;
        if (r2 == 0) goto L11;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L11;
        r3 = false;
    L11:
        if (r3 == true) goto L14;
        r1 = null;
    L14:
        if (r1 != null) goto L16;
        return 0;
    L16:
        return r1.intValue();
    L17:
        return 0;
    }

    public final va8.k Y2() {
        return (va8.k) this.q.getValue();
    }

    @Override // ew8.b
    public final boolean ef() {
        va8.p r0 = (va8.p) this.l.getValue();
        if (r0 == null) goto L5;
        List r1 = r0.getCurrentList();
    L6:
        if (r1 != null) goto L8;
        r1 = CollectionsKt.emptyList();
    L8:
        Set r2 = CollectionsKt.toSet(this.t);
        if (r2.isEmpty() == false) goto L54;
        List r3 = r1;
        boolean r4 = r3 instanceof Collection;
        if (r4 == true) goto L13;
    L15:
        Iterator r5 = r3.iterator();
    L17:
        if (r5.hasNext() == false) goto L52;
        Message r6 = (Message) r5.next();
        String r7 = r6.getReplyId();
        if (com.larus.bmhome.chat.bean.d.G0(r6) == false) goto L21;
    L49:
        boolean r8 = false;
    L50:
        if (r8 == false) goto L17;
        return true;
    L21:
        if (com.larus.bmhome.chat.bean.d.j0(r6) == true) goto L49;
        if (r7 != null) goto L24;
    L27:
        boolean r9 = true;
    L28:
        if (r9 == true) goto L49;
        if (r4 == true) goto L31;
    L33:
        Iterator r10 = r3.iterator();
    L35:
        if (r10.hasNext() == false) goto L46;
        Message r11 = (Message) r10.next();
        if (com.larus.bmhome.chat.bean.d.G0(r11) == true) goto L39;
    L43:
        boolean r12 = false;
    L44:
        if (r12 == false) goto L35;
        boolean r13 = true;
    L47:
        if (r13 == false) goto L49;
        r8 = true;
        goto L50
    L39:
        if (Intrinsics.areEqual(r11.getMessageId(), r7) == false) goto L41;
    L42:
        r12 = true;
        goto L44
    L41:
        if (Intrinsics.areEqual(r11.getLocalMessageId(), r7) == false) goto L43;
    L46:
        r13 = false;
        goto L47
    L31:
        if (r3.isEmpty() == false) goto L33;
    L24:
        if (r7.length() == 0) goto L27;
        r9 = false;
    L52:
        return false;
    L13:
        if (r3.isEmpty() == false) goto L15;
    L54:
        ArrayList r14 = new ArrayList();
        Iterator r15 = r1.iterator();
    L56:
        if (r15.hasNext() == false) goto L66;
        Object r16 = r15.next();
        Message r17 = (Message) r16;
        if (com.larus.bmhome.chat.bean.d.G0(r17) == false) goto L60;
    L62:
        boolean r18 = false;
    L63:
        if (r18 == false) goto L56;
        r14.add(r16);
        goto L56
    L60:
        if (CollectionsKt.contains(r2, r17.getReplyId()) == false) goto L62;
        r18 = true;
        goto L63
    L66:
        if (r14.isEmpty() == true) goto L74;
        Iterator r19 = r14.iterator();
    L70:
        if (r19.hasNext() == false) goto L74;
        if ((!com.larus.bmhome.chat.bean.d.j0((Message) r19.next())) == false) goto L70;
        boolean r20 = true;
    L75:
        if (r20 == false) goto L78;
        return true;
    L78:
        if ((!r14.isEmpty()) == true) goto L114;
        Set r21 = r2;
        if ((r21 instanceof Collection) == true) goto L82;
    L84:
        Iterator r22 = r21.iterator();
    L86:
        if (r22.hasNext() == false) goto L90;
        if (this.v.contains((String) r22.next()) == false) goto L86;
        boolean r23 = true;
    L91:
        if (r23 == true) goto L114;
        if (this.u.isEmpty() == true) goto L142;
        CopyOnWriteArrayList<Message> r24 = this.u;
        if ((r24 instanceof Collection) == true) goto L98;
    L100:
        Iterator<Message> r25 = r24.iterator();
    L102:
        if (r25.hasNext() == false) goto L109;
        if (r25.next().getMessageStatusLocal() == 12) goto L106;
        boolean r26 = true;
    L107:
        if (r26 == false) goto L102;
        boolean r27 = true;
    L110:
        if (r27 == true) goto L143;
        return false;
    L143:
        return true;
    L106:
        r26 = false;
    L109:
        r27 = false;
        goto L110
    L98:
        if (r24.isEmpty() == false) goto L100;
    L142:
        return true;
    L90:
        r23 = false;
        goto L91
    L82:
        if (r21.isEmpty() == false) goto L84;
    L114:
        return false;
    L74:
        r20 = false;
        goto L75
    L5:
        r1 = null;
        goto L6
    }

    @Override // ew8.b
    public final String getPageName() {
        dw8.p r0 = this.C;
        if (r0 == null) goto L13;
        String r1 = r0.getPageName();
        if (r1 != null) goto L7;
        return null;
    L7:
        if (r1.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L12;
        return null;
    L12:
        return r1;
    L9:
        r2 = false;
        goto L10
    L13:
        return null;
    }

    @Override // ew8.b
    public final String m() {
        dw8.p r0 = this.C;
        if (r0 == null) goto L13;
        String r1 = r0.m();
        if (r1 != null) goto L7;
        return null;
    L7:
        if (r1.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L12;
        return null;
    L12:
        return r1;
    L9:
        r2 = false;
        goto L10
    L13:
        return null;
    }

    public final void z3() {
        String r0 = this.y;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L16;
        B3(r0);
        C3(r0);
        FLogger.a.i("AIFloatChatMessageLogicComponent", "registerCurrentConversationObservers, cid=".concat(r0));
        return;
    L16:
        return;
    L7:
        r1 = false;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [com.larus.business.floatchat.impl.component.d0] */
    public AIFloatChatMessageLogicComponent() {
        this.l = LazyKt.lazy(new g(this));
        this.m = LazyKt.lazy(new h(this));
        this.n = LazyKt.lazy(new i(this));
        this.o = LazyKt.lazy(new j(this));
        this.p = LazyKt.lazy(new k(this));
        this.q = LazyKt.lazy(new l(this));
        this.r = new vt7.b();
        this.s = new vt7.b();
        this.t = new vt7.b();
        this.u = new CopyOnWriteArrayList();
        this.v = new vt7.b();
        this.w = new vt7.b();
        this.O = new vt7.b();
        this.P = new d0(this);
        this.Q = new f(this);
        this.R = new c(this);
        this.S = new d(this);
        this.T = new m(this);
        this.U = new e(this);
        this.V = new b(this);
    }

    public final void B2() {
        va8.k r0 = Y2();
        if (r0 == null) goto L5;
        r0.xf(this);
    L5:
        va8.o r1 = (va8.o) this.n.getValue();
        if (r1 == null) goto L8;
        r1.GM(this.P);
    L8:
        ICoreInputAbility r2 = (ICoreInputAbility) this.o.getValue();
        if (r2 == null) goto L11;
        r2.Jm(this.U);
    L11:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r3 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.p.getValue();
        if (r3 == null) goto L14;
        r3.e8(this.Q);
    L14:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r4 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.p.getValue();
        if (r4 == null) goto L17;
        r4.KR(this.V);
    L17:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r5 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        String r6 = null;
        if (r5 == null) goto L20;
        String r7 = r5.getString("argConversationId", "");
    L21:
        this.y = r7;
        if (r7 == null) goto L29;
        Lazy r8 = ic8.n.a;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (com.larus.im.j.f(r7) == false) goto L26;
        r6 = r7;
    L26:
        if (r6 == null) goto L29;
        com.larus.im.d.c().registerConversationChangeListener(r6, this.R);
        this.z = r6;
    L29:
        if (this.M == false) goto L32;
        z3();
        return;
    L32:
        return;
    L20:
        r7 = null;
        goto L21
    }

    public final void P2() {
        boolean r1 = true;
        if (X2() == 1) goto L5;
        return;
    L5:
        va8.p r0 = (va8.p) this.l.getValue();
        if (r0 == null) goto L59;
        List r2 = r0.getCurrentList();
        if (r2 == null) goto L60;
        Iterator r3 = r2.iterator();
    L10:
        String r4 = null;
        if (r3.hasNext() == false) goto L39;
        Object r5 = r3.next();
        Message r6 = (Message) r5;
        if (com.larus.bmhome.chat.bean.d.G0(r6) == true) goto L36;
        vt7.b<String> r7 = this.t;
        String r8 = r6.getReplyId();
        if (r8 != null) goto L17;
    L23:
        r8 = null;
    L25:
        if (CollectionsKt.contains(r7, r8) == false) goto L36;
        if (com.larus.bmhome.chat.bean.d.Q0(r6) == true) goto L29;
    L33:
        boolean r9 = false;
    L34:
        if (r9 == false) goto L36;
        boolean r10 = true;
    L37:
        if (r10 == false) goto L10;
    L40:
        Message r11 = (Message) r5;
        if (r11 == null) goto L61;
        String r12 = r11.getReplyId();
        if (r12 != null) goto L45;
        return;
    L45:
        if (r12.length() > 0) goto L48;
        r1 = false;
    L48:
        if (r1 == false) goto L50;
        r4 = r12;
    L50:
        if (r4 == null) goto L63;
        L2(r11, "startedFromCurrentList");
        FLogger.a.i("AIFloatChatMessageLogicComponent", "dispatchStartedReplyFromCurrentList, replyId=".concat(r4));
        return;
    L63:
        return;
    L61:
        return;
    L29:
        if (com.larus.bmhome.chat.bean.d.f0(r6) == true) goto L33;
        if (com.larus.bmhome.chat.bean.d.I0(r6) == true) goto L33;
        r9 = true;
        goto L34
    L17:
        if (r8.length() <= 0) goto L19;
        boolean r13 = true;
    L21:
        if (Boolean.valueOf(r13).booleanValue() == false) goto L23;
    L19:
        r13 = false;
    L36:
        r10 = false;
        goto L37
    L39:
        r5 = null;
        goto L40
    L60:
        return;
    }

    @Override // ew8.b
    public final boolean Pa() {
        if (X2() != 0) goto L5;
    L8:
        return true;
    L5:
        if (X2() == 2) goto L8;
        return false;
    }

    public static List D3(Message r6) {
        String[] r0 = new String[2];
        String r1 = r6.getMessageId();
        String r3 = null;
        boolean r4 = false;
        if (r1 != null) goto L5;
    L10:
        r1 = null;
    L11:
        r0[0] = r1;
        String r7 = r6.getLocalMessageId();
        if (r7 != null) goto L14;
    L18:
        r0[1] = r3;
        return CollectionsKt.distinct(CollectionsKt.listOfNotNull(r0));
    L14:
        if (r7.length() <= 0) goto L16;
        r4 = true;
    L16:
        if (r4 == false) goto L18;
        r3 = r7;
        goto L18
    L5:
        if (r1.length() <= 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L10;
    L7:
        r5 = false;
        goto L8
    }

    public static String E3(Message r5) {
        String r0 = r5.getMessageId();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L14:
        String r6 = r5.getLocalMessageId();
        if (r6 != null) goto L17;
        return null;
    L17:
        if (r6.length() <= 0) goto L19;
        r1 = true;
    L19:
        if (r1 == true) goto L21;
        return null;
    L21:
        return r6;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L14;
        return r0;
    L7:
        r4 = false;
        goto L8
    }

    public static List G3(Message r6) {
        String[] r0 = new String[3];
        String r1 = r6.getMessageId();
        boolean r2 = true;
        String r3 = null;
        if (r1 != null) goto L5;
    L10:
        r1 = null;
    L11:
        r0[0] = r1;
        String r4 = r6.getLocalMessageId();
        if (r4 != null) goto L14;
    L19:
        r4 = null;
    L20:
        r0[1] = r4;
        String r7 = r6.getReplyId();
        if (r7 != null) goto L23;
    L28:
        r0[2] = r3;
        return CollectionsKt.distinct(CollectionsKt.listOfNotNull(r0));
    L23:
        if (r7.length() > 0) goto L26;
        r2 = false;
    L26:
        if (r2 == false) goto L28;
        r3 = r7;
        goto L28
    L14:
        if (r4.length() <= 0) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L19;
    L16:
        r5 = false;
        goto L17
    L5:
        if (r1.length() <= 0) goto L7;
        boolean r8 = true;
    L8:
        if (r8 == false) goto L10;
    L7:
        r8 = false;
        goto L8
    }

    public final void B3(String r4) {
        if (Intrinsics.areEqual(this.A, r4) == false) goto L5;
        return;
    L5:
        String r0 = this.A;
        if (r0 == null) goto L8;
        com.larus.im.d.e().unregisterOnMessageChangedObserver(r0, this.S);
    L8:
        com.larus.im.d.e().registerOnMessageChangedObserver(r4, this.S);
        this.A = r4;
    }

    public final void C3(String r4) {
        if (Intrinsics.areEqual(this.B, r4) == false) goto L5;
        return;
    L5:
        String r0 = this.B;
        if (r0 == null) goto L8;
        int r1 = com.larus.im.d.a;
        com.larus.im.internal.stream.b.a.e(r0, this.T);
    L8:
        int r2 = com.larus.im.d.a;
        com.larus.im.internal.stream.b.a.b(r4, this.T);
        this.B = r4;
    }

    public final void F2(String r5) {
        va8.p0 r0 = this.G;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!r0.a.isEmpty()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L16;
        this.G = null;
        u7 r1 = (u7) this.m.getValue();
        if (r1 == null) goto L13;
        r1.C90();
    L13:
        FLogger.a.i("AIFloatChatMessageLogicComponent", "clearPreviewRoundFilter, reason=" + r5 + ", old=" + r0);
        return;
    }

    @Override // ew8.b
    public final void G5(dw8.t r2) {
        Intrinsics.checkNotNullParameter(r2, "changedListener");
        if (this.s.contains(r2) == false) goto L5;
        return;
    L5:
        this.s.add(r2);
    }

    public final void H3(Message r5) {
        if (com.larus.bmhome.chat.bean.d.G0(r5) == true) goto L5;
        return;
    L5:
        List r0 = D3(r5);
        if (r0.isEmpty() == true) goto L41;
        List r1 = r0;
        if ((r1 instanceof Collection) == true) goto L10;
    L12:
        Iterator r2 = r1.iterator();
    L14:
        if (r2.hasNext() == false) goto L18;
        String r3 = (String) r2.next();
        if (this.t.contains(r3) == false) goto L14;
        boolean r4 = false;
    L19:
        if (r4 == true) goto L42;
        List r6 = CollectionsKt.toList(this.t);
        this.t.addAll(r0);
        X3(r5);
        String r7 = E3(r5);
        if (r7 != null) goto L24;
        r7 = this.x;
    L24:
        this.x = r7;
        va8.k r8 = Y2();
        if (r8 == null) goto L27;
        FloatChatWindowState r9 = r8.getWindowState();
    L29:
        if (r9 != FloatChatWindowState.Preview) goto L31;
        W3();
    L31:
        FLogger r10 = FLogger.a;
        StringBuilder r11 = new StringBuilder("syncAnchorMessageIds, old=");
        r11.append(r6);
        r11.append(", new=");
        r11.append(this.t);
        r11.append(", messages=");
        CopyOnWriteArrayList<Message> r12 = this.u;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<Message> r14 = r12.iterator();
    L33:
        if (r14.hasNext() == false) goto L35;
        Message r15 = r14.next();
        Intrinsics.checkNotNull(r15);
        r13.add(E3(r15));
        goto L33
    L35:
        r11.append(r13);
        r10.i("AIFloatChatMessageLogicComponent", r11.toString());
        return;
    L27:
        r9 = null;
        goto L29
    L42:
        return;
    L18:
        r4 = true;
        goto L19
    L10:
        if (r1.isEmpty() == false) goto L12;
    }

    @Override // ew8.b
    public final void K1(List<Pair<String, String>> r12) {
        vt7.b<Pair<String, String>> r0 = new vt7.b();
        if (r12 != null) goto L5;
        r12 = CollectionsKt.emptyList();
    L5:
        r0.addAll(r12);
        this.O = r0;
        FLogger.a.i("AIFloatChatMessageLogicComponent", "registerCmdBizType pairs=" + CollectionsKt.joinToString$default(this.O, null, null, null, 0, null, null, 63, null));
    }

    @Override // ew8.b
    public final void K2(dw8.p r1) {
        this.C = r1;
        KA();
    }

    @Override // ew8.b
    public final void K4(dw8.t r2) {
        Intrinsics.checkNotNullParameter(r2, "changedListener");
        this.s.remove(r2);
    }

    public final void LS(float r7) {
        Float r0 = this.K;
        if (r0 != null) goto L7;
        this.K = Float.valueOf(r7);
        return;
    L7:
        if (this.L == true) goto L31;
        va8.p0 r1 = this.G;
        if (r1 != null) goto L11;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L32;
        va8.k r3 = Y2();
        FloatChatWindowState r4 = null;
        if (r3 == null) goto L18;
        FloatChatWindowState r5 = r3.getWindowState();
    L20:
        if (r5 != FloatChatWindowState.Expanded) goto L22;
        return;
    L22:
        if (r7 <= (r0.floatValue() + 0.001f)) goto L35;
        this.L = true;
        va8.k r8 = Y2();
        if (r8 == null) goto L28;
        r4 = r8.getWindowState();
    L28:
        if (r4 != FloatChatWindowState.Collapsed) goto L34;
        F2("dragInCollapsed");
        this.J = false;
        return;
    L34:
        return;
    L35:
        return;
    L18:
        r5 = null;
        goto L20
    L32:
        return;
    L11:
        if ((!r1.a.isEmpty()) != true) goto L13;
        r2 = true;
        goto L14
    }

    public final void N2(Message r7) {
        boolean r1 = false;
        if (r7.getMessageStatusLocal() != 21) goto L5;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == true) goto L13;
        return;
    L13:
        List r2 = G3(r7);
        if (r2.isEmpty() == false) goto L16;
        return;
    L16:
        List r3 = r2;
        if ((r3 instanceof Collection) == true) goto L19;
    L21:
        Iterator r4 = r3.iterator();
    L23:
        if (r4.hasNext() == false) goto L27;
        if (this.v.contains((String) r4.next()) == false) goto L23;
        r1 = true;
    L27:
        if (r1 == false) goto L30;
        return;
    L30:
        if (this.v.size() < 200) goto L32;
        this.v.clear();
    L32:
        this.v.addAll(r2);
        Iterator r5 = this.s.iterator();
    L34:
        if (r5.hasNext() == false) goto L36;
        ((dw8.t) r5.next()).za(r7);
        goto L34
    L36:
        FLogger.a.i("AIFloatChatMessageLogicComponent", "dispatchReceiveMessageEnd, keys=" + r2 + ", msg=" + r7);
        return;
    L19:
        if (r3.isEmpty() == false) goto L21;
    L5:
        if (r7.getMessageStatusLocal() == 23) goto L10;
        if (r7.getMessageStatusLocal() == 22) goto L10;
        r0 = false;
        goto L11
    }

    public final void X3(Message r7) {
        Set r0 = CollectionsKt.toSet(D3(r7));
        Iterator<Message> r1 = this.u.iterator();
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L20;
        Message r4 = r1.next();
        Intrinsics.checkNotNull(r4);
        List r5 = D3(r4);
        if ((r5 instanceof Collection) == true) goto L8;
    L10:
        Iterator r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L16;
        if (r0.contains((String) r6.next()) == false) goto L12;
        boolean r8 = true;
    L17:
        if (r8 == true) goto L21;
        r3 = r3 + 1;
    L21:
        if (r3 < 0) goto L23;
        this.u.set(r3, r7);
        return;
    L23:
        this.u.add(r7);
        return;
    L16:
        r8 = false;
        goto L17
    L8:
        if (r5.isEmpty() == false) goto L10;
    L20:
        r3 = -1;
        goto L21
    }

    public final void am(va8.h r4) {
        Intrinsics.checkNotNullParameter(r4, "snapshot");
        KA();
        this.K = null;
        this.L = false;
        FloatChatWindowState r1 = r4.a;
        if (r1 == FloatChatWindowState.Preview) goto L5;
        FloatChatWindowState r2 = FloatChatWindowState.Expanded;
        if (r1 != r2) goto L16;
        u7 r3 = (u7) this.m.getValue();
        if (r3 == null) goto L16;
        r3.Os();
    L16:
        if (this.J == false) goto L18;
    L19:
        F2("windowState:" + r4.a);
        this.J = false;
        return;
    L18:
        if (r4.a == r2) goto L19;
        return;
    L5:
        if (this.J == true) goto L9;
        u7 r5 = (u7) this.m.getValue();
        if (r5 == null) goto L9;
        r5.z50();
    L9:
        this.J = true;
    }

    public final void h3(Message r5) {
        boolean r1 = true;
        if (X2() == 1) goto L6;
        return;
    L6:
        if (com.larus.bmhome.chat.bean.d.Q0(r5) == true) goto L8;
    L12:
        boolean r0 = false;
    L13:
        if (r0 == true) goto L15;
        return;
    L15:
        String r2 = r5.getReplyId();
        if (r2 != null) goto L18;
        return;
    L18:
        if (r2.length() > 0) goto L21;
        r1 = false;
    L21:
        if (r1 == true) goto L24;
        r2 = null;
    L24:
        if (r2 == null) goto L32;
        Q3();
        if (this.t.contains(r2) == true) goto L29;
        return;
    L29:
        L2(r5, "firstToken");
        FLogger.a.i("AIFloatChatMessageLogicComponent", "handleAnswerIntentOnFirstToken, replyId=" + r2 + ", anchors=" + this.t);
        return;
    L32:
        return;
    L8:
        if (com.larus.bmhome.chat.bean.d.f0(r5) == true) goto L12;
        if (com.larus.bmhome.chat.bean.d.I0(r5) == true) goto L12;
        r0 = true;
        goto L13
    }

    @Override // ew8.b
    public final void nG(String r15) {
        Intrinsics.checkNotNullParameter("x-flow-function-scene", "key");
        Intrinsics.checkNotNullParameter(r15, "value");
        ChatPageContext r0 = M1();
        if (r0 == null) goto L5;
        Map r2 = r0.getReqHeaderMap();
    L6:
        if (r2 != null) goto L8;
        r2 = MapsKt.emptyMap();
    L8:
        Map r4 = MapsKt.toMutableMap(r2);
        r4.put("x-flow-function-scene", r15);
        Intrinsics.checkNotNullParameter(this, "<this>");
        t1a.b r16 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        if (r0 != null) goto L11;
        r0 = new ChatPageContext(null, null, null, null, null, null, 63, null);
    L11:
        r16.n(ChatPageContext.copy$default(r0, r4, null, null, null, null, null, 62, null), ChatPageContext.class);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void L2(Message r12, String r13) {
        List r0 = G3(r12);
        List r1 = r0;
        boolean r3 = true;
        if ((!r1.isEmpty()) == false) goto L19;
        List r2 = r0;
        if ((r2 instanceof Collection) == true) goto L7;
    L9:
        Iterator r4 = r2.iterator();
    L11:
        if (r4.hasNext() == false) goto L15;
        if (this.w.contains((String) r4.next()) == false) goto L11;
    L16:
        if (r3 == false) goto L19;
        return;
    L15:
        r3 = false;
        goto L16
    L7:
        if (r2.isEmpty() == false) goto L9;
    L19:
        if (this.w.size() < 200) goto L21;
        this.w.clear();
    L21:
        this.w.addAll(r1);
        va8.k r5 = Y2();
        if (r5 == null) goto L24;
        r5.hn(new va8.f(FloatChatWindowEventType.AnswerIntent, null, r12, null, null, false, 58));
    L24:
        FLogger.a.i("AIFloatChatMessageLogicComponent", "dispatchAnswerIntent, source=" + r13 + ", keys=" + r0);
    }

    public final void U2(Message r9, List<String> r10) {
        String r0 = com.larus.im.bean.message.a.g(r9);
        String r1 = null;
        if (r0 != null) goto L5;
    L10:
        r0 = null;
    L11:
        List<String> r4 = r10;
        if ((r4 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r5 = r4.iterator();
    L18:
        if (r5.hasNext() == false) goto L22;
        if (this.t.contains((String) r5.next()) == false) goto L18;
        boolean r6 = true;
    L24:
        if ((!this.t.isEmpty()) == false) goto L30;
        if (r6 == true) goto L29;
        if (r0 == null) goto L30;
        if (Intrinsics.areEqual(r0, this.H) == false) goto L30;
    L29:
        boolean r7 = true;
    L32:
        if (r7 == true) goto L35;
        this.t.clear();
        this.u.clear();
        this.x = null;
        this.H = r0;
        this.I = false;
        FLogger.a.i("AIFloatChatMessageLogicComponent", "beginCurrentSendRound, collectionId=" + r0);
    L37:
        Map r11 = r9.getExt();
        if (r11 == null) goto L41;
        r1 = (String) r11.get("call_id");
    L41:
        if (com.larus.utils.o0.d(r1) == false) goto L43;
        this.I = true;
    L43:
        FLogger.a.i("AIFloatChatMessageLogicComponent", "ensureCurrentSendRound, messageIds=" + r10 + ", messageCollectionId=" + r0 + ", currentCollectionId=" + this.H + ", belongsToCurrentRound=" + r7 + ", currentSendIsVui=" + this.I);
        return;
    L35:
        if (this.H != null) goto L37;
        this.H = r0;
    L30:
        r7 = false;
    L22:
        r6 = false;
        goto L24
    L14:
        if (r4.isEmpty() == false) goto L16;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r8 = true;
    L8:
        if (r8 == false) goto L10;
    L7:
        r8 = false;
        goto L8
    }

    @Override // ew8.b
    public final void ba(String r13, va8.t0 r14) {
        FLogger r0 = FLogger.a;
        r0.i("AIFloatChatMessageLogicComponent", "onReceiveRefreshCmd queryMsgId=" + r13 + ", viewBusinessPayload=" + r14);
        if (r14 != null) goto L5;
        r0.i("AIFloatChatMessageLogicComponent", "ignoreRefreshPageIntent, payload is null, queryMsgId=" + r13);
        return;
    L5:
        vt7.b<Pair<String, String>> r1 = this.O;
        boolean r3 = false;
        if ((r1 instanceof Collection) == true) goto L8;
    L10:
        Iterator r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L21;
        Pair r4 = (Pair) r2.next();
        if (Intrinsics.areEqual(r4.getFirst(), r14.a) == true) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == false) goto L12;
        r3 = true;
        goto L21
    L16:
        if (Intrinsics.areEqual(r4.getSecond(), r14.getType()) == false) goto L18;
        r5 = true;
    L21:
        if (r3 == true) goto L23;
        FLogger.a.i("AIFloatChatMessageLogicComponent", "ignoreRefreshPageIntent, payload=" + r14 + ", registeredPairs=" + CollectionsKt.joinToString$default(this.O, null, null, null, 0, null, null, 63, null));
        return;
    L23:
        if (r13 != null) goto L25;
        r13 = "";
    L25:
        va8.k r6 = Y2();
        if (r6 == null) goto L28;
        r6.hn(new va8.f(FloatChatWindowEventType.RefreshPageIntent, null, null, r13, r14, false, 38));
    L28:
        Iterator r7 = this.s.iterator();
    L30:
        if (r7.hasNext() == false) goto L32;
        ((dw8.t) r7.next()).ba(r13, r14);
        goto L30
    L32:
        FLogger.a.i("AIFloatChatMessageLogicComponent", "handleRefreshPageIntent, queryMsgId=" + r13 + ", payload=" + r14);
        return;
    L8:
        if (r1.isEmpty() == false) goto L10;
        goto L10
    }

    public final void m3(Message r14, boolean r15) {
        if (com.larus.bmhome.chat.bean.d.G0(r14) == true) goto L5;
        return;
    L5:
        List<String> r0 = D3(r14);
        if (r0.isEmpty() == false) goto L8;
        return;
    L8:
        boolean r2 = false;
        if (com.larus.bmhome.chat.bean.d.T(r14) == false) goto L12;
    L50:
        boolean r1 = true;
    L53:
        if (r1 == false) goto L60;
        if (r15 == true) goto L138;
        U2(r14, r0);
        this.t.addAll(r0);
        X3(r14);
        String r16 = E3(r14);
        if (r16 != null) goto L58;
        r16 = (String) CollectionsKt.first(r0);
    L58:
        this.x = r16;
        FLogger.a.i("AIFloatChatMessageLogicComponent", "trackIgnoredSendMessage, anchors=" + this.t);
        return;
    L138:
        return;
    L60:
        if (r15 == false) goto L76;
        List<String> r3 = r0;
        if ((r3 instanceof Collection) == true) goto L64;
    L66:
        Iterator<T> r4 = r3.iterator();
    L68:
        if (r4.hasNext() == false) goto L72;
        if (this.t.contains((String) r4.next()) == false) goto L68;
        boolean r5 = true;
    L73:
        if (r5 == true) goto L76;
        FLogger.a.i("AIFloatChatMessageLogicComponent", "ignoreUntrackedSelfMessageUpdate, anchors=" + r0);
        return;
    L72:
        r5 = false;
        goto L73
    L64:
        if (r3.isEmpty() == false) goto L66;
    L76:
        U2(r14, r0);
        String r6 = r14.getMessageId();
        if (r6 != null) goto L79;
    L82:
        boolean r7 = true;
    L83:
        if (r7 == false) goto L88;
        Iterator r8 = this.s.iterator();
    L86:
        if (r8.hasNext() == false) goto L92;
        ((dw8.t) r8.next()).F1(r14);
    L92:
        if (r15 == true) goto L94;
    L96:
        List<String> r9 = r0;
        this.t.addAll(r9);
        X3(r14);
        String r17 = E3(r14);
        if (r17 != null) goto L99;
        r17 = (String) CollectionsKt.first(r0);
    L99:
        this.x = r17;
        W3();
        if (this.r.size() < 200) goto L102;
        this.r.clear();
    L102:
        List<String> r10 = r0;
        if ((r10 instanceof Collection) == true) goto L105;
    L107:
        Iterator<T> r11 = r10.iterator();
    L109:
        if (r11.hasNext() == false) goto L113;
        if (this.r.contains((String) r11.next()) == false) goto L109;
        r2 = true;
    L113:
        this.r.addAll(r9);
        if ((!r2) == true) goto L117;
        P2();
        return;
    L117:
        va8.k r12 = Y2();
        if (r12 == null) goto L120;
        r12.hn(new va8.f(FloatChatWindowEventType.SendSuccess, null, r14, null, null, false, 58));
    L120:
        va8.p r18 = (va8.p) this.l.getValue();
        if (r18 == null) goto L123;
        r18.O5(true);
    L123:
        FLogger.a.i("AIFloatChatMessageLogicComponent", "handleSendSuccess, primary=" + r17 + ", anchors=" + this.t);
        P2();
        return;
    L105:
        if (r10.isEmpty() == false) goto L107;
    L94:
        if (r14.getMessageStatusLocal() == 11) goto L96;
        return;
    L88:
        Iterator r13 = this.s.iterator();
    L90:
        if (r13.hasNext() == false) goto L92;
        ((dw8.t) r13.next()).oa(r14);
        goto L90
    L79:
        if (r6.length() == 0) goto L82;
        r7 = false;
        goto L83
    L12:
        if (lr8.c.a(r14) == false) goto L51;
        List r19 = com.larus.bmhome.chat.bean.d.f(r14).getEntities();
        if (r19 != null) goto L16;
        r19 = CollectionsKt.emptyList();
    L16:
        List r20 = r19;
        if ((r20 instanceof Collection) == true) goto L19;
    L21:
        Iterator r21 = r20.iterator();
    L23:
        if (r21.hasNext() == false) goto L50;
        UplinkFileEntity r22 = (UplinkFileEntity) r21.next();
        String r23 = l1.d(r22);
        if (r23 != null) goto L27;
    L30:
        boolean r24 = true;
    L31:
        if (r24 == false) goto L47;
        Image r25 = l1.c(r22);
        if (r25 == null) goto L37;
        ImageObj r26 = r25.imageOri;
        if (r26 == null) goto L37;
        String r27 = r26.url;
    L38:
        if (r27 != null) goto L40;
    L43:
        boolean r28 = true;
    L44:
        if (r28 == false) goto L47;
        boolean r29 = false;
    L48:
        if (r29 == false) goto L23;
    L40:
        if (r27.length() == 0) goto L43;
        r28 = false;
    L37:
        r27 = null;
    L47:
        r29 = true;
        goto L48
    L27:
        if (r23.length() == 0) goto L30;
        r24 = false;
        goto L31
    L19:
        if (r20.isEmpty() == false) goto L21;
    L51:
        r1 = false;
        goto L53
    }

    public static Map p3(Map r1, Map r2, Map r3) {
        if (r1 != null) goto L4;
        r1 = MapsKt.emptyMap();
    L4:
        Map r4 = MapsKt.toMutableMap(r1);
        if (r2 != null) goto L7;
        r2 = MapsKt.emptyMap();
    L7:
        Iterator r5 = r2.keySet().iterator();
    L9:
        if (r5.hasNext() == false) goto L11;
        r4.remove((String) r5.next());
        goto L9
    L11:
        if (r3 == null) goto L14;
        r4.putAll(r3);
    L14:
        if ((!r4.isEmpty()) == true) goto L19;
        return null;
    L19:
        return r4;
    }
}
