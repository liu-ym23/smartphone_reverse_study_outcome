package com.larus.bmhome.chat.component.bottom.reference;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.gson.Gson;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.component.bottom.reference.entity.RefEntranceType;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.manager.l0;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.databinding.LarusChatInputReplyBinding;
import com.larus.bmhome.utils.ReferenceMessage;
import com.larus.bmhome.utils.i2;
import com.larus.bmhome.utils.o3;
import com.larus.bmhome.view.ChatInputReply;
import com.larus.bmhome.view.MessageMenu;
import com.larus.bmhome.view.ReplySuggestList;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.im.observer.MessageListState;
import com.larus.platform.model.action.SuggestedActionScene;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.SafeExtKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0093\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001l\u0018\u0000 ¶\u00012\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0002¶\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010p\u001a\u00020qH\u0016J\b\u0010r\u001a\u00020qH\u0016J\b\u0010s\u001a\u00020qH\u0016J\u0012\u0010t\u001a\u00020q2\b\u0010u\u001a\u0004\u0018\u00010bH\u0016J;\u0010v\u001a\u00020q2\u0006\u0010w\u001a\u00020x2\b\u0010y\u001a\u0004\u0018\u00010z2\b\u0010{\u001a\u0004\u0018\u00010j2\u0006\u0010|\u001a\u00020[2\b\u0010}\u001a\u0004\u0018\u00010~H\u0016¢\u0006\u0002\u0010\u007fJ#\u0010\u0080\u0001\u001a\u00020q2\u0006\u0010w\u001a\u00020x2\b\u0010{\u001a\u0004\u0018\u00010j2\u0006\u0010|\u001a\u00020[H\u0016J\u001c\u0010\u0081\u0001\u001a\u00020q2\b\u0010w\u001a\u0004\u0018\u00010x2\u0007\u0010\u0082\u0001\u001a\u00020[H\u0016J\u000b\u0010\u0083\u0001\u001a\u0004\u0018\u00010jH\u0016J\u0014\u0010\u0084\u0001\u001a\u00020q2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010jH\u0016J\u0015\u0010\u0086\u0001\u001a\u0004\u0018\u00010j2\b\u0010}\u001a\u0004\u0018\u00010~H\u0016J\b\u0010\\\u001a\u00020[H\u0016J\t\u0010\u0087\u0001\u001a\u00020[H\u0016J\t\u0010\u0088\u0001\u001a\u00020jH\u0016J\u0012\u0010\u0089\u0001\u001a\u00020q2\u0007\u0010\u008a\u0001\u001a\u00020[H\u0016J\t\u0010\u008b\u0001\u001a\u00020[H\u0016J\t\u0010\u008c\u0001\u001a\u00020qH\u0016J\u000b\u0010\u008d\u0001\u001a\u0004\u0018\u00010jH\u0016J\f\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0016J\t\u0010\u0090\u0001\u001a\u00020[H\u0016J\t\u0010\u0091\u0001\u001a\u00020[H\u0016J\u001a\u0010\u0092\u0001\u001a\u00020q2\u0007\u0010\u0093\u0001\u001a\u00020j2\u0006\u0010|\u001a\u00020[H\u0016J\u0011\u0010\u0094\u0001\u001a\u00020q2\u0006\u0010w\u001a\u00020jH\u0016J\t\u0010\u0095\u0001\u001a\u00020qH\u0016J\u0013\u0010\u0096\u0001\u001a\u00020q2\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0016J\t\u0010\u0099\u0001\u001a\u00020qH\u0016J\t\u0010\u009a\u0001\u001a\u00020qH\u0002J\u000b\u0010\u009b\u0001\u001a\u0004\u0018\u00010bH\u0002J\f\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001H\u0002J\u001b\u0010\u009e\u0001\u001a\u00020q2\t\u0010\u009f\u0001\u001a\u0004\u0018\u00010bH\u0082@¢\u0006\u0003\u0010 \u0001J\u0016\u0010¡\u0001\u001a\u0004\u0018\u00010f2\t\b\u0002\u0010¢\u0001\u001a\u00020[H\u0002J\t\u0010£\u0001\u001a\u00020fH\u0002JX\u0010¤\u0001\u001a\u00020q2\u0007\u0010\u0085\u0001\u001a\u00020j2\b\u0010¥\u0001\u001a\u00030\u009d\u00012\u000e\u0010¦\u0001\u001a\t\u0012\u0004\u0012\u00020j0§\u00012\b\u0010{\u001a\u0004\u0018\u00010j2\b\b\u0002\u0010|\u001a\u00020[2\u000b\b\u0002\u0010¨\u0001\u001a\u0004\u0018\u00010j2\t\b\u0002\u0010©\u0001\u001a\u00020[H\u0002J0\u0010ª\u0001\u001a\u00020q2\u0007\u0010\u0085\u0001\u001a\u00020j2\b\u0010¥\u0001\u001a\u00030\u009d\u00012\b\u0010{\u001a\u0004\u0018\u00010j2\b\b\u0002\u0010|\u001a\u00020[H\u0002J\t\u0010«\u0001\u001a\u00020qH\u0002J\t\u0010¬\u0001\u001a\u00020qH\u0002J\u0012\u0010\u00ad\u0001\u001a\u00020q2\u0007\u0010®\u0001\u001a\u00020jH\u0002J\u0083\u0001\u0010¯\u0001\u001a\u00020q2\u0007\u0010w\u001a\u00030\u009d\u00012\u000e\u0010°\u0001\u001a\t\u0012\u0004\u0012\u00020q0±\u00012\b\b\u0002\u0010|\u001a\u00020[2\u0010\b\u0002\u0010¦\u0001\u001a\t\u0012\u0004\u0012\u00020j0§\u00012\t\b\u0002\u0010²\u0001\u001a\u00020[2\t\b\u0002\u0010³\u0001\u001a\u00020j2\n\b\u0002\u0010{\u001a\u0004\u0018\u00010j2\t\b\u0002\u0010´\u0001\u001a\u00020[2\u000b\b\u0002\u0010¨\u0001\u001a\u0004\u0018\u00010j2\t\b\u0002\u0010©\u0001\u001a\u00020[H\u0002J\t\u0010µ\u0001\u001a\u00020qH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b \u0010!R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0013\u001a\u0004\b%\u0010&R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0013\u001a\u0004\b*\u0010+R\u001d\u0010-\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0013\u001a\u0004\b/\u00100R\u001d\u00102\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0013\u001a\u0004\b4\u00105R\u001d\u00107\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0013\u001a\u0004\b9\u0010:R\u001d\u0010<\u001a\u0004\u0018\u00010=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0013\u001a\u0004\b>\u0010?R\u001d\u0010A\u001a\u0004\u0018\u00010B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0013\u001a\u0004\bC\u0010DR\u001d\u0010F\u001a\u0004\u0018\u00010G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0013\u001a\u0004\bH\u0010IR\u001d\u0010K\u001a\u0004\u0018\u00010L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u0013\u001a\u0004\bM\u0010NR\u001d\u0010P\u001a\u0004\u0018\u00010Q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\u0013\u001a\u0004\bR\u0010SR\u001b\u0010U\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u0013\u001a\u0004\bW\u0010XR\u000e\u0010Z\u001a\u00020[X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\\\u001a\u00020[8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010\u0013\u001a\u0004\b]\u0010^R\u0016\u0010`\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010c\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020[X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u0004\u0018\u00010jX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u00020lX\u0082\u0004¢\u0006\u0004\n\u0002\u0010mR\u0010\u0010n\u001a\u0004\u0018\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006·\u0001"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/reference/ReferenceMsgComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "<init>", "()V", "input", "Lcom/larus/bmhome/chat/component/bottom/core/InputView;", "viewModel", "Lcom/larus/bmhome/chat/component/bottom/reference/ReferenceMsgComponentViewModel;", "getViewModel", "()Lcom/larus/bmhome/chat/component/bottom/reference/ReferenceMsgComponentViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "bottomAbility", "Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "getBottomAbility", "()Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "bottomAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "chatDraft", "Lcom/larus/bmhome/chat/model/ChatDraft;", "getChatDraft", "()Lcom/larus/bmhome/chat/model/ChatDraft;", "chatDraft$delegate", "suggestedActionAbility", "Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "getSuggestedActionAbility", "()Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "suggestedActionAbility$delegate", "listComponentAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getListComponentAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "listComponentAbility$delegate", "chatBottomFloatingAbility", "Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "getChatBottomFloatingAbility", "()Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "chatBottomFloatingAbility$delegate", "uiBlockAbility", "Lcom/larus/bmhome/view/actionbar/api/IChatUIBlockAbility;", "getUiBlockAbility", "()Lcom/larus/bmhome/view/actionbar/api/IChatUIBlockAbility;", "uiBlockAbility$delegate", "chatBottomCombineAbility", "Lcom/obric/assistant/ability/chat/bottom/IObricChatBottomAbility;", "getChatBottomCombineAbility", "()Lcom/obric/assistant/ability/chat/bottom/IObricChatBottomAbility;", "chatBottomCombineAbility$delegate", "obricWindowMaterialAbility", "Lcom/obric/assistant/ability/chat/material/IObricWindowMaterialAbility;", "getObricWindowMaterialAbility", "()Lcom/obric/assistant/ability/chat/material/IObricWindowMaterialAbility;", "obricWindowMaterialAbility$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "refMsgManager", "Lcom/larus/bmhome/utils/ReferenceMessage$Manager;", "getRefMsgManager", "()Lcom/larus/bmhome/utils/ReferenceMessage$Manager;", "refMsgManager$delegate", "isChatViewOptEnable", "", "enableAttachment", "getEnableAttachment", "()Z", "enableAttachment$delegate", "onBotModelChanged", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility$ChangeListener;", "Lcom/larus/im/bean/bot/BotModel;", "onConversationOrTypeChanged", "Lcom/larus/im/bean/conversation/Conversation;", "chatInputReply2", "Lcom/larus/bmhome/view/ChatInputReply;", "isDocReference", "isImmerse", "preCvsId", "", "messageChangeListener", "com/larus/bmhome/chat/component/bottom/reference/ReferenceMsgComponent$messageChangeListener$1", "Lcom/larus/bmhome/chat/component/bottom/reference/ReferenceMsgComponent$messageChangeListener$1;", "sideBarLayoutListener", "Lcom/larus/bmhome/ISideBarLayoutListener;", "onAttach", "", "clearReferenceMsg", "clearReferenceMsgAndSpeak", "updateReferenceMessageInfo", "bot", "setReferenceMessageAndShowIme", "message", "Lcom/larus/im/bean/message/Message;", "botType", "", "referenceAction", "showIme", "refEntrance", "Lcom/larus/bmhome/chat/component/bottom/reference/entity/RefEntranceType;", "(Lcom/larus/im/bean/message/Message;Ljava/lang/Integer;Ljava/lang/String;ZLcom/larus/bmhome/chat/component/bottom/reference/entity/RefEntranceType;)V", "setReferenceMessageWithoutReply", "clearReferenceMessage", "forceClear", "getReferenceAction", "setReferenceAction", "action", "getRefScene", "readyToSendWithAttachment", "referenceFromTypeMobString", "changeChatInputReplyVisibility", "visible", "getChatInputReplyVisibility", "hideReplySuggest", "suggestContent", "referenceInfo", "Lcom/larus/im/bean/message/ReferenceInfo;", "hasReferenceMsg", "hasDocReferenceTxt", "setReferenceText", ChatDraftItem.TYPE_TEXT, "setReferenceTextForDoc", "clearDocReferenceTextAndHideSuggestAction", "onViewCreated", "view", "Landroid/view/View;", "onDestroy", "updateImmerseModeStatus", "currentBot", "getCurrentReferenceMsg", "Lcom/larus/bmhome/utils/ReferenceMessage;", "updateFromChatDraft", "newBot", "(Lcom/larus/im/bean/bot/BotModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChatInputReplyView", "forceInit", "generateInputReplyView", "onRefMsgUpdate", "refMsg", "suggestList", "", "refScene", "hideSuggestActionBar", "updateRefMsgWithoutReply", "observerBotChanged", "observeConversationChanged", "changeMessageObserver", "newConversationId", "setReferenceMessage", "onClear", "Lkotlin/Function0;", "changeSwitchStatus", "multiAttachmentLocalMsgId", "fromDraft", "initObserverOnImmerseModeChanged", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ReferenceMsgComponent extends BaseContentWidget implements com.larus.bmhome.chat.component.bottom.reference.a {
    public static final /* synthetic */ int N = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final boolean D;
    public final Lazy E;
    public e0 F;
    public d0 G;
    public ChatInputReply H;
    public boolean I;
    public boolean J;
    public String K;
    public final b L;
    public c M;
    public g9 m;
    public final com.larus.ui.arch.vm.internal.l n;
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

    public static final class b implements nf9.b {
        public final /* synthetic */ ReferenceMsgComponent a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[MessageListState.values().length];
                r0[MessageListState.REFRESH_ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                a = r0;
            }
        }

        public final void a(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void c(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void d(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void e(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
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

        public b(ReferenceMsgComponent r1) {
            this.a = r1;
        }

        public final void b(String r2, MessageListState r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r4, "msgList");
            if (a.a[r3.ordinal()] == 1) goto L5;
            return;
        L5:
            if (this.a.i9() == false) goto L9;
            this.a.xo(null, true);
            return;
        }
    }

    public static final class c implements com.larus.bmhome.c0 {
        public c() {
        }

        public final void G(boolean r1) {
        }

        public final void n0(boolean r1) {
        }

        public final void H0(int r1) {
            WeakReference r2 = MessageMenu.x;
            MessageMenu.a.a();
        }
    }

    public static final class d implements Function0<oaa.a> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
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

    public static final class e implements Function0<raa.a> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(raa.a.class));
        }
    }

    public static final class f implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public f(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class g implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public g(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class h implements Function0<ViewModelProvider.Factory> {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    static {
    }

    @Override // com.larus.bmhome.chat.component.bottom.reference.a
    public final void NR() {
        Ek(false);
        this.I = false;
        C3().e = null;
        bc8.a r0 = (bc8.a) this.v.getValue();
        if (r0 == null) goto L6;
        r0.mX();
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.reference.a
    public final boolean Qj() {
        ChatInputReply r1 = m3(true);
        if (r1 != null) goto L5;
    L10:
        return false;
    L5:
        if (r1.getVisibility() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 != true) goto L10;
        return true;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.reference.a
    public final void mE() {
        ChatInputReply r1 = m3(false);
        if (r1 == null) goto L8;
        LarusChatInputReplyBinding r2 = r1.a;
        if (r2 == null) goto L9;
        e1.o(r2.e);
        r1.S5(false);
        Unit r0 = Unit.INSTANCE;
        return;
    L9:
        return;
    }

    public final boolean B3() {
        return ((Boolean) this.E.getValue()).booleanValue();
    }

    public final ReferenceMessage.a C3() {
        return (ReferenceMessage.a) this.C.getValue();
    }

    public final de8.c f1() {
        return (de8.c) this.B.getValue();
    }

    public final g1 f70() {
        return (g1) this.q.getValue();
    }

    public final com.larus.bmhome.chat.model.n h3() {
        return (com.larus.bmhome.chat.model.n) this.u.getValue();
    }

    public final void onDestroy() {
        com.larus.bmhome.chat.component.cvs.y r0 = (com.larus.bmhome.chat.component.cvs.y) this.r.getValue();
        if (r0 == null) goto L5;
        r0.lQ(this.F);
    L5:
        c r1 = this.M;
        String r2 = null;
        if (r1 == null) goto L11;
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.bmhome.a0 r3 = com.larus.bmhome.b0.a(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        if (r3 == null) goto L10;
        r3.OB(r1);
    L10:
        this.M = null;
    L11:
        NativeMessageServiceImpl r4 = com.larus.im.d.e();
        String r5 = this.K;
        if (r5 != null) goto L19;
        com.larus.bmhome.chat.component.cvs.y r6 = (com.larus.bmhome.chat.component.cvs.y) this.r.getValue();
        if (r6 == null) goto L16;
        r2 = r6.Y1();
    L16:
        if (r2 != null) goto L18;
        r5 = "";
        goto L19
    L18:
        r5 = r2;
    L19:
        r4.unregisterOnMessageChangedObserver(r5, this.L);
    }

    public final va8.o p3() {
        return (va8.o) this.p.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.bmhome.chat.component.bottom.reference.a.class);
        c r1 = new c();
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.bmhome.a0 r0 = com.larus.bmhome.b0.a(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        if (r0 == null) goto L5;
        r0.If(r1);
    L5:
        this.M = r1;
    }

    public final ICoreInputAbility z3() {
        return (ICoreInputAbility) this.o.getValue();
    }

    public ReferenceMsgComponent() {
        this.n = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(ReferenceMsgComponentViewModel.class), Reflection.getOrCreateKotlinClass(ReferenceMsgComponentViewState.class), new f(this), new g(this), h.a);
        this.o = LazyKt.lazy(new m(this));
        this.p = LazyKt.lazy(new z(this));
        this.q = LazyKt.lazy(new a0(this));
        this.r = LazyKt.lazy(new b0(this));
        this.s = LazyKt.lazy(new c0(this));
        this.t = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.reference.c(this));
        this.u = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.reference.d(this));
        this.v = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.reference.e(this));
        this.w = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.reference.f(this));
        this.x = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.reference.g(this));
        this.y = LazyKt.lazy(new v(this));
        this.z = LazyKt.lazy(new d(this));
        this.A = LazyKt.lazy(new e(this));
        this.B = LazyKt.lazy(new w(this));
        this.C = LazyKt.lazy(new x());
        this.D = true;
        this.E = LazyKt.lazy(new y());
        this.L = new b(this);
    }

    @Override // com.larus.bmhome.chat.component.bottom.reference.a
    public final boolean GD() {
        return o0.d(C3().e);
    }

    @Override // com.larus.bmhome.chat.component.bottom.reference.a
    public final boolean LX() {
        return B3();
    }

    @Override // com.larus.bmhome.chat.component.bottom.reference.a
    public final ReferenceInfo T6() {
        ReferenceMessage r0 = C3().b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getReferenceInfo();
    }

    @Override // com.larus.bmhome.chat.component.bottom.reference.a
    public final String TL() {
        return C3().c;
    }

    @Override // com.larus.bmhome.chat.component.bottom.reference.a
    public final boolean VM() {
        boolean r0 = i9();
        va8.o r1 = p3();
        if (r1 == null) goto L6;
        String r2 = r1.u7();
        if (r2 == null) goto L6;
    L7:
        boolean r3 = !StringsKt.isBlank(r2);
        g1 r4 = f70();
        boolean r5 = false;
        if (r4 != null) goto L10;
    L12:
        if (r0 == false) goto L20;
        if (r5 == true) goto L18;
        if (z2.a.disableFix1340InputSendProblem() == true) goto L18;
        return true;
    L18:
        return r3;
    L20:
        return true;
    L10:
        if (r4.isVisible() != true) goto L12;
        r5 = true;
    L6:
        r2 = "";
        goto L7
    }

    @Override // com.larus.bmhome.chat.component.bottom.reference.a
    public final boolean i9() {
        if (C3().b == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.chat.component.bottom.reference.a
    public final void sZ() {
        ReferenceMessage.a r0 = C3();
        r0.b = null;
        r0.c = null;
        r0.d = null;
        r0.a.invoke();
        com.larus.bmhome.instruction.g r1 = (com.larus.bmhome.instruction.g) this.t.getValue();
        if (r1 == null) goto L5;
        r1.vW(true);
    L5:
        ICoreInputAbility r2 = z3();
        if (r2 == null) goto L20;
        r2.Rk();
        ICoreInputAbility r3 = z3();
        if (r3 != null) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == false) goto L15;
        r2.g2(2, true);
        goto L20
    L15:
        int r5 = 3;
        if (r2.Rp() == 3) goto L19;
        r5 = 1;
    L19:
        r2.g2(r5, true);
        goto L20
    L10:
        if (r3.Rp() != 2) goto L12;
        r4 = true;
    L20:
        bc8.a r6 = (bc8.a) this.v.getValue();
        if (r6 == null) goto L24;
        bc8.a.C0001a.a(r6, SuggestedActionScene.Unknown, "clear_reference_msg", false, null, false, 28);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.reference.a
    public final String vS() {
        return C3().d;
    }

    @Override // com.larus.bmhome.chat.component.bottom.reference.a
    public final String wf() {
        ReferenceMessage r0 = C3().b;
        if (r0 != null) goto L7;
        return "no_cite";
    L7:
        if (r0.getSelf() == false) goto L9;
        return "user";
    L9:
        return "assistant";
    }

    @Override // com.larus.bmhome.chat.component.bottom.reference.a
    public final void CN(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        ((ReferenceMsgComponentViewModel) this.n.getValue()).setReferenceMessageWithoutReply(r5, "auto_cite", false, new ReferenceMsgComponent$setReferenceMessageWithoutReply$1(this));
    }

    @Override // com.larus.bmhome.chat.component.bottom.reference.a
    public final void Dk(String r8) {
        Intrinsics.checkNotNullParameter(r8, "message");
        ChatInputReply r1 = m3(true);
        if (r1 != null) goto L5;
        return;
    L5:
        this.I = true;
        if (r8.length() <= 200) goto L8;
        String r2 = r8.substring(0, DoraCallStateCode.DORA_OB_USER_END) + "...";
    L9:
        List r3 = CollectionsKt.emptyList();
        int r5 = ChatInputReply.d;
        r1.R5(r2, r3, false, null);
        r1.setOnReplyCloseListener(new com.larus.bmhome.chat.component.bottom.reference.b(this));
        C3().e = r8;
        Ek(true);
        com.larus.bmhome.instruction.g r9 = (com.larus.bmhome.instruction.g) this.t.getValue();
        if (r9 == null) goto L12;
        r9.A1();
    L12:
        com.larus.bmhome.instruction.g r10 = (com.larus.bmhome.instruction.g) this.t.getValue();
        if (r10 == null) goto L15;
        r10.vW(false);
    L15:
        bc8.a r0 = (bc8.a) this.v.getValue();
        if (r0 == null) goto L19;
        bc8.a.C0001a.a(r0, SuggestedActionScene.DocAiEditReferenceAction, "unknown_ref", false, null, false, 28);
        return;
    L19:
        return;
    L8:
        r2 = r8;
        goto L9
    }

    @Override // com.larus.bmhome.chat.component.bottom.reference.a
    public final void Ek(boolean r9) {
        boolean r0 = true;
        ChatInputReply r1 = m3(true);
        if (r1 != null) goto L5;
    L10:
        boolean r2 = false;
    L11:
        FLogger.a.i("ReferenceMsgComponent", "[changeChatInputReplyVisibility] " + r2 + " to " + r9);
        if (r9 == false) goto L40;
        ld8.n r4 = (ld8.n) this.x.getValue();
        if (r4 == null) goto L16;
        r4.RZ();
    L16:
        ChatInputReply r5 = m3(true);
        if (r5 == null) goto L20;
        r5.setVisibility(0);
    L20:
        if (B3() == false) goto L66;
        de8.c r6 = f1();
        if (r6 != null) goto L24;
    L26:
        boolean r7 = false;
    L27:
        if (r7 == false) goto L37;
        int r8 = com.larus.bmhome.chat.immerse.k0.a;
        de8.c r10 = f1();
        if (r10 == null) goto L33;
        Integer r11 = r10.m();
        if (r11 == null) goto L33;
        int r12 = r11.intValue();
    L34:
        int r13 = com.larus.bmhome.chat.immerse.k0.a(r12, 0.1f, 0.35f);
        GradientDrawable r14 = new GradientDrawable();
        r14.setShape(0);
        float r15 = c7.b(16);
        r14.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, r15, r15, r15, r15});
        r14.setColor(r13);
        va8.o r3 = p3();
        if (r3 == null) goto L66;
        r3.l70(r14, r13);
    L33:
        r12 = 0;
        goto L34
    L37:
        va8.o r16 = p3();
        if (r16 == null) goto L66;
        r16.p9(v19.c.b(2130970690, getContext(), 2131239155));
        goto L66
    L24:
        if (r6.C() != true) goto L26;
        r7 = true;
    L66:
        if (r9 == true) goto L76;
        if (r2 == false) goto L76;
        ICoreInputAbility r17 = z3();
        if (r17 == null) goto L72;
        r17.Jc(getContext());
    L72:
        if (this.I == true) goto L76;
        g1 r18 = f70();
        if (r18 == null) goto L76;
        r18.Bg();
    L76:
        oaa.a r19 = (oaa.a) this.z.getValue();
        if (r19 == null) goto L79;
        r19.C0(r9, r2);
    L79:
        u7 r20 = (u7) this.w.getValue();
        if (r20 == null) goto L82;
        r20.U1();
    L82:
        g9 r21 = this.m;
        if (r21 == null) goto L88;
        View r22 = r21.root();
        if (r22 == null) goto L89;
        r22.post(new l(this));
        return;
    L89:
        return;
    L88:
        return;
    L40:
        ChatInputReply r23 = m3(false);
        if (r23 == null) goto L43;
        r23.setVisibility(8);
    L43:
        g1 r24 = f70();
        if (r24 != null) goto L46;
    L48:
        boolean r25 = false;
    L49:
        boolean r26 = !r25;
        if (B3() == false) goto L66;
        if (r2 == false) goto L66;
        if (r26 == true) goto L66;
        de8.c r27 = f1();
        if (r27 != null) goto L56;
    L58:
        r0 = false;
    L59:
        if (r0 == false) goto L63;
        ICoreInputAbility r28 = z3();
        if (r28 == null) goto L66;
        r28.zi();
        goto L66
    L63:
        va8.o r29 = p3();
        if (r29 == null) goto L66;
        r29.p9(v19.c.b(2130970689, getContext(), 2131239150));
        goto L66
    L56:
        if (r27.C() != true) goto L58;
    L46:
        if (r24.isVisible() == true) goto L48;
        r25 = true;
        goto L49
    L5:
        if (r1.getVisibility() != 0) goto L7;
        boolean r30 = true;
    L8:
        if (r30 != true) goto L10;
        r2 = true;
        goto L11
    L7:
        r30 = false;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.reference.a
    public final void OW(BotModel r11) {
        com.larus.bmhome.chat.model.n r0 = h3();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L12;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ReferenceMsgComponent$updateReferenceMessageInfo$1(this, r11, null), 3, null);
        return;
    L12:
        int r3 = l0.a;
        com.larus.bmhome.chat.component.cvs.y r4 = (com.larus.bmhome.chat.component.cvs.y) this.r.getValue();
        if (r4 == null) goto L15;
        BotModel r5 = r4.j0();
    L16:
        if (r5 == null) goto L18;
        Integer r6 = r5.getBotType();
    L20:
        if (l0.a(r6) == true) goto L27;
        if (r11 != null) goto L23;
    L25:
        if (r1 == true) goto L27;
        return;
    L23:
        if (ce8.a.b(r11) != true) goto L25;
        r1 = true;
    L27:
        if (i9() == false) goto L31;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ReferenceMsgComponent$updateReferenceMessageInfo$2(this, r11, null), 3, null);
        return;
    L31:
        return;
    L18:
        r6 = null;
        goto L20
    L15:
        r5 = null;
        goto L16
    L5:
        if (r0.d != true) goto L7;
        r2 = true;
        goto L9
    }

    public final ChatInputReply m3(boolean r9) {
        if (r9 == true) goto L6;
        return this.H;
    L6:
        if (this.m == null) goto L56;
        ChatInputReply r10 = this.H;
        if (r10 != null) goto L58;
        if (r10 != null) goto L55;
        FLogger.a.i("ReferenceMsgComponent", "[generateInputReplyView] ChatInputReply");
        if (i2.a().e() == false) goto L24;
        int r11 = gd8.b.b;
        Context r12 = getContext();
        Intrinsics.checkNotNullParameter(r12, "curCtx");
        if (z2.a.enablePreloadChatPageView().b() == false) goto L20;
        o37.c.e.getClass();
        if (o37.c.f("chat_bottom_nita") == false) goto L20;
        if ((r12 instanceof Activity) == false) goto L20;
        View r13 = o37.c.e("chat_bottom_nita").i(-1, (Activity) r12, true);
    L22:
        if ((r13 instanceof ChatInputReply) == false) goto L24;
        r10 = (ChatInputReply) r13;
    L26:
        if (r10 != null) goto L29;
        r10 = new ChatInputReply(getContext(), null, 6, 0);
    L29:
        if (B3() == false) goto L52;
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-1, -2);
        r10.setId(2131365542);
        r10.setLayoutParams(r0);
        e1.o(r10);
        raa.a r1 = (raa.a) this.A.getValue();
        if (r1 == null) goto L34;
        Drawable r2 = r1.HD();
        if (r2 == null) goto L34;
    L49:
        r10.setBackground(r2);
        va8.o r3 = p3();
        if (r3 == null) goto L55;
        r3.Ca(r10, 2131365542);
    L34:
        de8.c r4 = f1();
        if (r4 != null) goto L37;
    L39:
        boolean r5 = false;
    L40:
        if (r5 == false) goto L48;
        int r6 = com.larus.bmhome.chat.immerse.k0.a;
        de8.c r7 = f1();
        if (r7 == null) goto L46;
        Integer r8 = r7.m();
        if (r8 == null) goto L46;
        int r14 = r8.intValue();
    L47:
        int r15 = com.larus.bmhome.chat.immerse.k0.a(r14, 0.1f, 0.35f);
        GradientDrawable r16 = new GradientDrawable();
        r16.setShape(0);
        float r17 = c7.b(16);
        r16.setCornerRadii(new float[]{r17, r17, r17, r17, 0.0f, 0.0f, 0.0f, 0.0f});
        r16.setColor(r15);
        r2 = r16;
    L46:
        r14 = 0;
        goto L47
    L48:
        r2 = ContextCompat.getDrawable(getContext(), v19.c.b(2130970553, getContext(), 2131238608));
        goto L49
    L37:
        if (r4.C() != true) goto L39;
        r5 = true;
        goto L40
    L52:
        e1.o(r10);
        va8.o r18 = p3();
        if (r18 == null) goto L55;
        r18.Ww(r10);
    L20:
        r13 = null;
    L24:
        r10 = null;
    L55:
        this.H = r10;
    L58:
        return this.H;
    L56:
        FLogger.a.e("ReferenceMsgComponent", "[getChatInputReplyView] called before bind ViewBinding");
        goto L58
    }

    public final void onViewCreated(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        this.m = InputViewCreatorDelegate.b.f((ViewGroup) r3);
        if (this.D == true) goto L5;
        m3(true);
    L5:
        de8.c r4 = f1();
        if (r4 == null) goto L8;
        boolean r5 = r4.C();
    L9:
        this.J = r5;
        ((ReferenceMsgComponentViewModel) this.n.getValue()).observerImmerseModeChanged(new p(this));
        this.F = new e0(this);
        com.larus.bmhome.chat.component.cvs.y r6 = (com.larus.bmhome.chat.component.cvs.y) this.r.getValue();
        if (r6 == null) goto L12;
        r6.ll(new k(), this.F);
    L12:
        FLogger.a.d("ReferenceMsgComponent", "observeConversationChanged");
        this.G = new d0(this);
        com.larus.bmhome.chat.component.cvs.y r7 = (com.larus.bmhome.chat.component.cvs.y) this.r.getValue();
        if (r7 == null) goto L16;
        r7.rh(new com.larus.bmhome.chat.component.bottom.reference.h(), this.G);
        return;
    L16:
        return;
    L8:
        r5 = this.J;
        goto L9
    }

    @Override // com.larus.bmhome.chat.component.bottom.reference.a
    public final void L60(String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, ChatDraftItem.TYPE_TEXT);
        if (StringsKt.isBlank(r14) == false) goto L6;
        FLogger.a.i("ReferenceMsgComponent", "[setReferenceText] empty text, skip");
        return;
    L6:
        ReferenceMessage r0 = new ReferenceMessage(null, r14, null, true, true, 0, null, null, 229, null);
        List r5 = CollectionsKt.emptyList();
        E3(this, r0, new u(), r15, r5, true, null, null, false, null, false, 992);
    }

    @Override // com.larus.bmhome.chat.component.bottom.reference.a
    public final void xo(Message r3, boolean r4) {
        ((ReferenceMsgComponentViewModel) this.n.getValue()).clearReferenceMessage(r3, r4, new ReferenceMsgComponent$clearReferenceMessage$1(this));
    }

    public static final Object Y2(final ReferenceMsgComponent r21, BotModel r22, Continuation r23) {
        r21.getClass();
        if ((r23 instanceof ReferenceMsgComponent$updateFromChatDraft$1) == false) goto L7;
        ReferenceMsgComponent$updateFromChatDraft$1 r2 = (ReferenceMsgComponent$updateFromChatDraft$1) r23;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r6 = true;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        int r7 = r2.I$0;
        ReferenceMessage r8 = (ReferenceMessage) r2.L$1;
        g9 r9 = (g9) r2.L$0;
        ResultKt.throwOnFailure(r0);
    L96:
        Message r10 = (Message) r0;
    L126:
        Gson r1 = new Gson();     // Catch: Exception -> L109
        Type r11 = new f0().getType();     // Catch: Exception -> L109
        String r12 = r8.getRefExt();     // Catch: Exception -> L109
        if (r12 != null) goto L101;
        r12 = "";
    L101:
        HashMap r13 = (HashMap) r1.fromJson(r12, r11);     // Catch: Exception -> L109
        if (r13 == null) goto L104;
        Object r14 = r13.get("ref_icon_key");     // Catch: Exception -> L109
    L105:
        if (Intrinsics.areEqual(r14, "task") == true) goto L108;
    L111:
        String r15 = null;
        boolean r16 = false;
    L112:
        List r17 = yc9.d0.a(r10);
        if (r7 == 0) goto L116;
        r6 = false;
    L116:
        g1 r18 = r21.f70();
        if (r18 == null) goto L122;
        String r19 = r18.uM();
        if (r19 == null) goto L122;
        String r20 = r19;
    L123:
        E3(r21, r8, new o(r21), false, r17, r6, r20, null, true, r15, r16, 64);
    L125:
        return Unit.INSTANCE;
    L122:
        r20 = "";
        goto L123
    L108:
        r15 = "task_card_ref";
        r16 = true;
        goto L112
    L104:
        r14 = null;
    L109:
        e = move-exception;
        FLogger.a.e("ReferenceMsgComponent", "[updateFromChatDraft] error: " + e);
        goto L111
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        g9 r24 = r21.m;
        if (r24 == null) goto L125;
        de8.c r25 = r21.f1();
        if (r25 == null) goto L23;
        Bundle r26 = r25.b;
        if (r26 == null) goto L23;
        if (r26.getBoolean("key_skip_draft_restore", false) != true) goto L23;
        boolean r27 = true;
    L24:
        if (r27 == false) goto L26;
        FLogger.a.i("ReferenceMsgComponent", "[updateFromChatDraft] skip by argument");
        goto L125
    L26:
        int r28 = l0.a;
        com.larus.bmhome.chat.component.cvs.y r29 = (com.larus.bmhome.chat.component.cvs.y) r21.r.getValue();
        if (r29 == null) goto L29;
        BotModel r30 = r29.j0();
    L30:
        if (r30 == null) goto L32;
        Integer r31 = r30.getBotType();
    L34:
        if (l0.a(r31) == true) goto L45;
        if (r22 != null) goto L37;
    L39:
        boolean r32 = false;
    L40:
        if (r32 == true) goto L45;
        com.larus.bmhome.chat.model.n r33 = r21.h3();
        if (r33 == null) goto L125;
        r33.n();
        goto L125
    L37:
        if (ce8.a.b(r22) != true) goto L39;
        r32 = true;
    L45:
        com.larus.bmhome.chat.model.n r34 = r21.h3();
        if (r34 == null) goto L52;
        ChatDraftItem r35 = r34.m();
        if (r35 == null) goto L52;
        String r36 = r35.getContent();
        if (r36 == null) goto L52;
        ReferenceMessage.Companion.getClass();
        Intrinsics.checkNotNullParameter(r36, "jsonString");
        ReferenceMessage r110 = (ReferenceMessage) com.larus.utils.l0.a(null, new o3(r36));
    L53:
        Intrinsics.checkNotNullParameter(r21, "<this>");
        Bundle r37 = com.larus.ui.arch.component.internal.attach.a.b(r21, r21).getArguments();
        if (r37 == null) goto L56;
        Integer r38 = Boxing.boxInt(r37.getInt("arg_outer_input_event_id", -1));
    L57:
        if (r38 != null) goto L60;
    L62:
        int r39 = 0;
    L63:
        if (r110 == null) goto L65;
        String r111 = r110.getSenderName();
    L67:
        if (o0.d(r111) == false) goto L89;
        if (r22 == null) goto L70;
        String r112 = r22.getName();
    L72:
        if (o0.d(r112) == false) goto L89;
        if (r110 == null) goto L75;
        String r113 = r110.getSenderName();
    L76:
        if (r22 == null) goto L78;
        String r114 = r22.getName();
    L80:
        if (Intrinsics.areEqual(r113, r114) == true) goto L89;
        if (r110 != null) goto L83;
        r110 = null;
        goto L89
    L83:
        if (r22 == null) goto L86;
        String r115 = r22.getName();
        if (r115 == null) goto L86;
    L87:
        r110 = ReferenceMessage.copy$default(r110, null, null, r115, false, false, 0, null, null, 251, null);
    L86:
        r115 = "";
        goto L87
    L78:
        r114 = null;
        goto L80
    L75:
        r113 = null;
        goto L76
    L70:
        r112 = null;
    L89:
        if (r110 == null) goto L125;
        String r116 = r110.getMessageId();
        if (r116 == null) goto L97;
        RepoDispatcher.a.getClass();
        ChatRepo r117 = RepoDispatcher.d;
        r2.L$0 = r24;
        r2.L$1 = r110;
        r2.I$0 = r39;
        r2.label = 1;
        r0 = r117.E1(r116, r2);
        if (r0 == r4) goto L128;
        r7 = r39;
        r8 = r110;
        goto L96
    L128:
        return r4;
    L97:
        r7 = r39;
        r10 = null;
        r8 = r110;
        goto L126
    L65:
        r111 = null;
        goto L67
    L60:
        if (r38.intValue() != 202) goto L62;
        r39 = 1;
        goto L63
    L56:
        r38 = null;
    L52:
        r110 = null;
        goto L53
    L32:
        r31 = null;
        goto L34
    L29:
        r30 = null;
    L23:
        r27 = false;
    L7:
        r2 = new ReferenceMsgComponent$updateFromChatDraft$1(r21, r23);
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.reference.a
    public final void Vu(Message r10, Integer r11, String r12, boolean r13, RefEntranceType r14) {
        Intrinsics.checkNotNullParameter(r10, "message");
        if (com.larus.bmhome.chat.bean.d.v0(r10) == false) goto L6;
        FLogger.a.i("ReferenceMsgComponent", "invalid reference msg");
        return;
    L6:
        ReferenceMsgComponentViewModel r1 = (ReferenceMsgComponentViewModel) this.n.getValue();
        C3().getClass();
        if (r14 != null) goto L9;
        int r0 = -1;
    L11:
        if (r0 != 1) goto L13;
        String r2 = "choose_text_auto_cite";
    L26:
        r1.setReferenceMessageAndShowIme(r10, r11, r12, r13, r2, r14, new ReferenceMsgComponent$setReferenceMessageAndShowIme$1(this));
        return;
    L13:
        if (r0 != 2) goto L15;
        r2 = "long_press_answer_more";
        goto L26
    L15:
        if (r0 != 3) goto L17;
        r2 = "long_press_and_choose_text";
        goto L26
    L17:
        if (r0 != 4) goto L19;
        r2 = "click_link";
        goto L26
    L19:
        if (r0 == 5) goto L21;
        r2 = null;
        goto L26
    L21:
        r2 = "task_card_ref";
        goto L26
    L9:
        r0 = ReferenceMessage.a.a.a[r14.ordinal()];
        goto L11
    }

    public final void D3(String r17, ReferenceMessage r18, List<String> r19, String r20, boolean r21, String r22, boolean r23) {
        FLogger r1 = FLogger.a;
        r1.i("ReferenceMsgComponent", "[onRefMsgUpdate] action:" + r17 + ", messageId:" + r18.getMessageId());
        int r2 = r17.hashCode();
        if (r2 == (-1767957272)) goto L45;
        if (r2 == 1096596436) goto L31;
        if (r2 != 1593208562) goto L62;
        if (r17.equals("action_update") == false) goto L62;
        com.larus.bmhome.chat.model.n r0 = h3();
        if (r0 == null) goto L24;
        String r4 = r18.toJsonString();
        Intrinsics.checkNotNullParameter(r4, "refMsgJsonString");
        if (r0.d == true) goto L24;
        r1.d("ChatDraft", "updateReplyChatDraftItem content:" + r4);
        ChatDraftItem r3 = ChatDraftItem.a.a(ChatDraftItem.Companion, ChatDraftItem.TYPE_REPLY, r4, "", "", null, DoraCallStateCode.DOUBAO_CMD_12);
        List<ChatDraftItem> r5 = r0.p;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L19:
        if (r7.hasNext() == false) goto L23;
        Object r8 = r7.next();
        if ((true ^ Intrinsics.areEqual(((ChatDraftItem) r8).getType(), ChatDraftItem.TYPE_REPLY)) == false) goto L19;
        r6.add(r8);
        goto L19
    L23:
        List<ChatDraftItem> r9 = CollectionsKt.toMutableList(r6);
        r9.add(r3);
        r0.p = r9;
        r0.q = true;
        com.larus.bmhome.chat.model.n.A(r0, false, false, null, 15);
    L24:
        Function0 r10 = new n(this);
        g1 r11 = f70();
        if (r11 == null) goto L28;
        String r12 = r11.uM();
        if (r12 == null) goto L28;
    L29:
        E3(this, r18, r10, r21, r19, false, r12, r20, false, r22, r23, 144);
        return;
    L28:
        r12 = "";
    L62:
        return;
    L31:
        if (r17.equals("action_delete") == false) goto L67;
        ReferenceMessage r13 = C3().b;
        if (r13 != null) goto L36;
    L38:
        com.larus.bmhome.chat.model.n r14 = h3();
        if (r14 == null) goto L41;
        r14.n();
    L41:
        ICoreInputAbility r15 = z3();
        if (r15 == null) goto L64;
        r15.Rk();
        return;
    L64:
        return;
    L36:
        if (Intrinsics.areEqual(r13.getMessageId(), r18.getMessageId()) == false) goto L38;
        sZ();
        goto L38
    L67:
        return;
    L45:
        if (r17.equals("action_force_delete") == true) goto L48;
        return;
    L48:
        if (i9() == false) goto L50;
        sZ();
    L50:
        com.larus.bmhome.chat.model.n r16 = h3();
        if (r16 == null) goto L53;
        r16.n();
    L53:
        ICoreInputAbility r24 = z3();
        if (r24 == null) goto L66;
        r24.Rk();
        return;
    }

    public static void E3(final ReferenceMsgComponent r20, ReferenceMessage r21, Function0 r22, boolean r23, List r24, boolean r25, String r26, String r27, boolean r28, String r29, boolean r30, int r31) {
        boolean r5 = true;
        if ((r31 & 4) == 0) goto L5;
        boolean r4 = true;
    L7:
        if ((r31 & 8) == 0) goto L9;
        List r6 = CollectionsKt.emptyList();
    L11:
        if ((r31 & 16) == 0) goto L13;
        boolean r7 = true;
    L14:
        String r9 = "";
        if ((r31 & 32) == 0) goto L17;
        String r8 = "";
    L19:
        if ((r31 & 64) == 0) goto L21;
        String r10 = null;
    L23:
        if ((r31 & 128) == 0) goto L25;
        boolean r12 = false;
    L27:
        if ((r31 & 256) == 0) goto L29;
        String r14 = null;
    L31:
        if ((r31 & 512) == 0) goto L33;
        boolean r3 = false;
    L34:
        ss8.g r15 = (ss8.g) r20.y.getValue();
        if (r15 == null) goto L37;
        ss8.g.a r16 = r15.TI();
    L38:
        if (r16 != null) goto L150;
        ss8.g r17 = (ss8.g) r20.y.getValue();
        if (r17 == null) goto L42;
        r17.bA();
    L42:
        final ChatInputReply r18 = r20.m3(true);
        if (r18 == null) goto L153;
        r20.I = false;
        com.larus.bmhome.instruction.g r11 = (com.larus.bmhome.instruction.g) r20.t.getValue();
        if (r11 == null) goto L48;
        r11.A1();
    L48:
        com.larus.bmhome.instruction.g r13 = (com.larus.bmhome.instruction.g) r20.t.getValue();
        if (r13 == null) goto L51;
        r13.vW(false);
    L51:
        ReferenceMessage.a r19 = r20.C3();
        r19.getClass();
        Intrinsics.checkNotNullParameter(r21, "message");
        Intrinsics.checkNotNullParameter(r22, "onClear");
        r19.b = r21;
        r19.a = r22;
        r20.C3().d = r10;
        va8.o r1 = r20.p3();
        if (r1 != null) goto L54;
    L56:
        boolean r2 = false;
    L58:
        if (r20.J == false) goto L68;
        LarusChatInputReplyBinding r32 = r18.a;
        if (r32 == null) goto L68;
        r32.f.setTextColor(ve8.d.a(2131103298, AppHost.a.getApplication()));
        r32.d.setImageResource(2131241861);
        r32.c.setImageResource(2131241854);
        ReplySuggestList.SuggestAdapter r33 = r32.e.getAdapter();
        if ((r33 instanceof ReplySuggestList.SuggestAdapter) == false) goto L64;
        ReplySuggestList.SuggestAdapter r34 = r33;
    L65:
        if (r34 == null) goto L68;
        r34.b = true;
        goto L68
    L64:
        r34 = null;
    L68:
        if (Intrinsics.areEqual(r20.C3().d, "rewrite") == false) goto L72;
        ICoreInputAbility r35 = r20.z3();
        if (r35 == null) goto L72;
        r35.Yk(r20.getContext().getResources().getString(2131909191));
    L72:
        ReferenceMessage r36 = r20.C3().b;
        if (r36 == null) goto L75;
        String r37 = r36.getReferenceReply();
    L76:
        if (r37 == null) goto L79;
        r9 = r37;
    L79:
        String r38 = StringsKt.replace$default(StringsKt.replace$default(r9, "\n", "", false, 4, null), "\r", "", false, 4, null);
        if (r38.length() <= 200) goto L83;
        r38 = r38.substring(0, DoraCallStateCode.DORA_OB_USER_END) + "...";
    L83:
        va8.o r39 = r20.p3();
        if (r39 == null) goto L86;
        String r40 = r39.u7();
    L87:
        if (r40 != null) goto L89;
    L92:
        boolean r41 = true;
    L93:
        if (r41 == false) goto L96;
        if (r2 == false) goto L96;
        boolean r42 = true;
    L98:
        if (Intrinsics.areEqual(r14, "task_card_ref") == false) goto L100;
        Integer r43 = 2131242739;
    L101:
        r18.R5(r38, r6, r42, r43);
        r18.setOnReplyCloseListener(new q(r20));
        r18.setOnItemClickListener(new r(r20));
        if (r7 == false) goto L122;
        ICoreInputAbility r44 = r20.z3();
        if (r44 == null) goto L106;
        Integer r45 = Integer.valueOf(r44.Rp());
    L107:
        if (r45 == null) goto L112;
        int r46 = 3;
        if (r45.intValue() != 3) goto L112;
    L118:
        ICoreInputAbility r47 = r20.z3();
        if (r47 == null) goto L121;
        r47.g2(r46, true);
    L121:
        r20.Ek(true);
    L112:
        if (r45 == null) goto L117;
        r46 = 2;
        if (r45.intValue() == 2) goto L118;
    L117:
        r46 = 1;
        goto L118
    L106:
        r45 = null;
    L122:
        if (r12 == true) goto L137;
        Integer r48 = z2.a.attachmentEditConfig().getKeepAttachmentWhenQuote();
        if (r48 != null) goto L127;
    L129:
        r5 = false;
    L130:
        if (r5 == true) goto L134;
        g1 r49 = r20.f70();
        if (r49 == null) goto L134;
        r49.b2(r8);
    L134:
        bc8.a r50 = (bc8.a) r20.v.getValue();
        if (r50 == null) goto L138;
        r50.mX();
    L138:
        if (r4 == false) goto L140;
        SafeExtKt.b(r20.F2(), new s(r20), 200);
    L140:
        ViewExtKt.j(r18, new t(r20, r18), null, 6);
        bc8.a r0 = (bc8.a) r20.v.getValue();
        if (r0 != null) goto L143;
        return;
    L143:
        if (Intrinsics.areEqual(r14, "click_link") == false) goto L145;
        bc8.a.C0001a.a(r0, SuggestedActionScene.Unknown, r14, false, null, r3, 12);
        return;
    L145:
        SuggestedActionScene r51 = SuggestedActionScene.ReferenceAction;
        if (r14 != null) goto L148;
        r14 = "unknown_ref";
    L148:
        bc8.a.C0001a.a(r0, r51, r14, false, null, r3, 12);
        return;
    L127:
        if (r48.intValue() != 1) goto L129;
    L137:
        FLogger.a.i("ReferenceMsgComponent", "[setReferenceMessage] fromDraft, keep attachments");
        goto L138
    L100:
        r43 = null;
    L96:
        r42 = false;
        goto L98
    L89:
        if (r40.length() == 0) goto L92;
        r41 = false;
        goto L93
    L86:
        r40 = null;
        goto L87
    L75:
        r37 = null;
        goto L76
    L54:
        if (r1.w() != true) goto L56;
        r2 = true;
        goto L58
    L153:
        return;
    L150:
        return;
    L37:
        r16 = null;
        goto L38
    L33:
        r3 = r30;
        goto L34
    L29:
        r14 = r29;
        goto L31
    L25:
        r12 = r28;
        goto L27
    L21:
        r10 = r27;
        goto L23
    L17:
        r8 = r26;
        goto L19
    L13:
        r7 = r25;
        goto L14
    L9:
        r6 = r24;
        goto L11
    L5:
        r4 = r23;
        goto L7
    }
}
