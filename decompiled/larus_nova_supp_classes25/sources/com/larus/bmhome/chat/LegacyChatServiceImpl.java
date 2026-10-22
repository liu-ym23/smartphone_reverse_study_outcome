package com.larus.bmhome.chat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.text.InputFilter;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.api.ILegacyChatUiService;
import com.larus.bmhome.chat.auth.PluginManagerDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepsearch.component.g;
import com.larus.bmhome.chat.font.FontLevel;
import com.larus.bmhome.chat.helper.ConversationClickHelper;
import com.larus.bmhome.chat.helper.ConversationFragmentAbilityImpl;
import com.larus.bmhome.chat.layout.holder.helper.MarkDownSelectHelper;
import com.larus.bmhome.chat.layout.holder.helper.MessageCopyHelper;
import com.larus.bmhome.chat.layout.item.RecordStatus;
import com.larus.bmhome.chat.layout.item.SearchListBox;
import com.larus.bmhome.chat.manager.Gpt4SwitchManager;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.ConversationListModel;
import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import com.larus.bmhome.databinding.LarusPageChatFullScreenEditBinding;
import com.larus.bmhome.double_post.adapter.AwemeRecommendAdapter;
import com.larus.bmhome.instruction.i;
import com.larus.bmhome.utils.j;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.common_ui.paging.FPagingAdapter;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.EditPos;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000Ð\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ*\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016JE\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00122*\u0010\u0013\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00150\u0014\"\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0016¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J8\u0010\u001b\u001a\u00020\u00052\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u000bH\u0016J@\u0010#\u001a\u00020\u00052\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u000b2\u0006\u0010$\u001a\u00020\u0005H\u0016J\u0012\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010'H\u0016Jå\u0001\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010!2\u0006\u00104\u001a\u0002052\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0019072\u001e\u00108\u001a\u001a\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0019092\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00190;2\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\u00052\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010\u00142\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0016¢\u0006\u0002\u0010DJ\u0010\u0010E\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010F\u001a\u00020\u0019H\u0016J\u0012\u0010G\u001a\u00020!2\b\u0010H\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010I\u001a\u00020\u00192\u0006\u0010J\u001a\u00020KH\u0016J\u0012\u0010L\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010M\u001a\u00020\u0005H\u0016J\b\u0010N\u001a\u00020\u0019H\u0016J\n\u0010O\u001a\u0004\u0018\u00010PH\u0016J\n\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\n\u0010S\u001a\u0004\u0018\u00010TH\u0016J\n\u0010U\u001a\u0004\u0018\u00010VH\u0016J\b\u0010W\u001a\u00020XH\u0016J\u0018\u0010Y\u001a\u0002052\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0016J\n\u0010^\u001a\u0004\u0018\u00010_H\u0016J\n\u0010`\u001a\u0004\u0018\u00010aH\u0016J\n\u0010b\u001a\u0004\u0018\u00010cH\u0016Jk\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020i2$\u0010j\u001a \u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190k2\b\u0010m\u001a\u0004\u0018\u00010!2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020o0;2\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020sH\u0016¢\u0006\u0002\u0010tJ\u0018\u0010u\u001a\u00020\u00192\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020!H\u0016J\u0018\u0010y\u001a\u00020\u00192\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020!H\u0016J3\u0010z\u001a\u00020{2\u0006\u0010Z\u001a\u00020[2\u0006\u0010|\u001a\u00020!2\u0019\u0010}\u001a\u0015\u0012\u0004\u0012\u00020\u007f\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0004\u0012\u00020\u00190~H\u0016J\u0012\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0006\u0010Z\u001a\u00020[H\u0016J\n\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\n\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0016J\n\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0016JH\u0010\u0089\u0001\u001a\u00020\u00192\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u000b2\u0007\u0010\u008e\u0001\u001a\u00020\u000bH\u0016J:\u0010\u008f\u0001\u001a\u00020\u00192\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010o2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010]2\u0007\u0010\u0092\u0001\u001a\u00020\u000b2\u0007\u0010\u0093\u0001\u001a\u00020\u000b2\u0007\u0010\u0094\u0001\u001a\u00020\u000bH\u0016¨\u0006\u0095\u0001"}, d2 = {"Lcom/larus/bmhome/chat/LegacyChatServiceImpl;", "Lcom/larus/bmhome/chat/api/ILegacyChatUiService;", "<init>", "()V", "realtimeCallEnabled", "", "editPos", "Lcom/larus/platform/model/EditPos;", "botModel", "Lcom/larus/im/bean/bot/BotModel;", "conversationId", "", "(Lcom/larus/platform/model/EditPos;Lcom/larus/im/bean/bot/BotModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enableSilence", "isEditable", "isContinuousTalk", "shouldCloseInstruction", "messageSendExt", "", "param", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Ljava/util/Map;", "getImgAttachInstructExt", "musicPlayerPausing", "", "pausing", "insertMultiQuestionReferenceFromInstruction", "extra", "", "message", "Lcom/larus/im/bean/message/Message;", "searchIndex", "", "scene", "insertMultiQuestionReference", "isReferenceAction", "isRecording", "adapter", "Lcom/larus/bmhome/list/ICoreMessageListAdapter;", "buildFullScreenEditTextView", "activity", "Landroidx/fragment/app/FragmentActivity;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "imeHeight", "isImmerse", "bgImgColor", "voiceInputContent", "", "onClickSend", "Lkotlin/Function1;", "onUpdateInputText", "Lkotlin/Function3;", "onFold", "Lkotlin/Function0;", "inModify", "forceDarkMode", "targetContainer", "Landroid/view/ViewGroup;", "enableSetFullEditBackground", "inputFilters", "Landroid/text/InputFilter;", "fullInputBoxMobParams", "(Landroidx/fragment/app/FragmentActivity;Lcom/larus/im/bean/bot/BotModel;Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;Lcom/larus/ui/arch/context/external/VContext;Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;IZLjava/lang/Integer;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;ZZLandroid/view/ViewGroup;Z[Landroid/text/InputFilter;Ljava/util/Map;)V", "trackOnClickCallSpeakIcon", "stopRecording", "getSelectIndex", "parentMessageId", "startRealtimeCallD", "bean", "Lcom/larus/voicecall/api/bean/StartCallPayLoadBean;", "isShowGpt4InputHintAndAnsweringText", "hasSubBenefitsFromStore", "invokeAppletSaveClick", "getWidgetCardClickHelper", "Lcom/larus/bmhome/chat/layout/holder/helper/api/WidgetCardClickHelper;", "observerManager", "Lcom/larus/bmhome/chat/api/ILegacyMessageObserver;", "containerAppreciableTrace", "Lcom/larus/bmhome/chat/api/IContainerAppreciableTrace;", "conversationListModel", "Lcom/larus/bmhome/chat/api/IConversationListModel;", "conversationFragmentAbility", "Lcom/larus/bmhome/chat/api/IConversationFragmentAbility;", "getConversationBrief", "context", "Landroid/content/Context;", "conversationData", "Lcom/larus/bmhome/chat/model/api/ConversationData;", "instructionSwitchHelper", "Lcom/larus/bmhome/instruction/IInstructionSwitch;", "pluginManagerDelegate", "Lcom/larus/bmhome/chat/auth/api/IPluginManager;", "messageCopyHelper", "Lcom/larus/bmhome/chat/layout/holder/helper/IMessageCopyHelper;", "createMessageAdapter", "Lcom/larus/bmhome/chat/adapter/MessageAdapter;", "loader", "Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "msgActionCallback", "Lkotlin/Function4;", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "immerseBgColor", "hostFragment", "Landroidx/fragment/app/Fragment;", "componentFeature", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "provider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "(Lcom/larus/bmhome/social/page/datasource/prefetch/IPagingAutoLoader;Lcom/larus/bmhome/chat/ChatParam;Lkotlin/jvm/functions/Function4;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;)Lcom/larus/bmhome/chat/adapter/MessageAdapter;", "stubMessageList", "viewStub", "Landroid/view/ViewStub;", "id", "stubNestedScrollList", "createAwemeRecommendAdapterForWidget", "Lcom/larus/bmhome/double_post/adapter/AwemeRecommendAdapter;", "coverWidth", "mobCardShow", "Lkotlin/Function2;", "Lcom/larus/bmhome/video/Content;", "Landroid/view/View;", "createSearchBoxView", "Lcom/larus/bmhome/chat/api/ISearchListBox;", "markdownSelectHelper", "Lcom/larus/bmhome/chat/api/IMarkDownSelectHelper;", "chatSendTrace", "Lcom/larus/bmhome/chat/api/IChatSendTrace;", "messageCellTrace", "Lcom/larus/bmhome/chat/api/IMessageCellTrace;", "mobDeepSearchButtonShoww", "currentPage", "previousPage", "messageId", "botId", "enterMethod", "handleConversationClick", "fragment", "data", "enterFrom", "currentPageName", "argPosition", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class LegacyChatServiceImpl implements ILegacyChatUiService {

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(r4 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public LegacyChatServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final Map<String, String> B8() {
        od8.d.a.getClass();
        String r0 = ((Keva) od8.d.b.getValue()).getString("SAVE_KEY_INSTRUCT_EXT_", "");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r2 = new JSONObject(r0);     // Catch: Throwable -> L9
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Throwable -> L9
        Iterator<String> r4 = r2.keys();     // Catch: Throwable -> L9
    L5:
        if (r4.hasNext() == false) goto L7;
        String r5 = r4.next();     // Catch: Throwable -> L9
        r3.put(r5, JSONObjectProtectorUtils.getString(r2, r5));     // Catch: Throwable -> L9
        goto L5
    L7:
        Object r6 = Result.constructor-impl(r3);     // Catch: Throwable -> L9
    L12:
        if (Result.exceptionOrNull-impl(r6) == null) goto L16;
        r6 = null;
    L16:
        return (Map) r6;
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void G8() {
        Map r0 = ts8.a.a;
        Iterator r1 = ((LinkedHashMap) ts8.a.a).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((ts8.b) ((Map.Entry) r1.next()).getValue()).onClick();
        goto L4
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final com.larus.bmhome.chat.api.v K8() {
        return new ConversationFragmentAbilityImpl();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean isRecording() {
        return AudioServiceDelegate.a.P().isRecording();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean q8() {
        CoroutineScope r0 = Gpt4SwitchManager.a;
        return Gpt4SwitchManager.c();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void stopRecording() {
        AudioServiceDelegate.a.P().a("LegacyChatServiceImpl");
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean p8() {
        return ce8.c.a();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final hc8.b E8() {
        return PluginManagerDelegate.a;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final com.larus.bmhome.chat.api.z F8() {
        return MarkDownSelectHelper.a;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final cf8.c H8() {
        return com.larus.bmhome.chat.layout.holder.helper.d3.a;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final i I8() {
        return com.larus.bmhome.instruction.c.a;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final com.larus.bmhome.chat.api.y N8() {
        return ji8.d.a;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final com.larus.bmhome.chat.api.t V8() {
        return com.larus.bmhome.chat.trace.container.b.a;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final com.larus.bmhome.chat.layout.holder.helper.s0 X8() {
        return MessageCopyHelper.a;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final com.larus.bmhome.chat.api.a0 r8() {
        return com.larus.bmhome.chat.list.trace.c.a;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final com.larus.bmhome.chat.api.s t8() {
        return com.larus.bmhome.chat.trace.z.a;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final com.larus.bmhome.chat.api.w z8() {
        return ConversationListModel.a;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void A8(b3a.c r3) {
        Intrinsics.checkNotNullParameter(r3, "bean");
        VoiceCallServiceDelegate.a.t(r3, false);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean C8(wq8.b r5) {
        Integer r1 = null;
        if ((r5 instanceof MessageAdapter) == false) goto L5;
        MessageAdapter r6 = (MessageAdapter) r5;
    L7:
        if (r6 == null) goto L34;
        List<xc8.b> r7 = r6.z2();
        if (r7 == null) goto L35;
        xc8.b r8 = (xc8.b) CollectionsKt.getOrNull(r7, 0);
        if (r8 == null) goto L30;
        ic8.p0 r9 = ic8.q0.a(r8.getMessage());
        if (r9 == null) goto L15;
        r1 = r9.d();
    L15:
        int r10 = RecordStatus.RECORDING.getType();
        if (r1 != null) goto L19;
    L20:
        int r11 = RecordStatus.Connecting.getType();
        if (r1 != null) goto L24;
    L26:
        boolean r12 = false;
    L28:
        if (r12 != true) goto L30;
        boolean r13 = true;
    L31:
        if (r13 != true) goto L36;
        return true;
    L36:
        return false;
    L24:
        if (r11 != r1.intValue()) goto L26;
    L27:
        r12 = true;
        goto L28
    L19:
        if (r10 == r1.intValue()) goto L27;
    L30:
        r13 = false;
        goto L31
    L35:
        return false;
    L34:
        return false;
    L5:
        r6 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean D8(String r1) {
        return j.b(r1);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void Q8(ViewStub r2) {
        Intrinsics.checkNotNullParameter(r2, "viewStub");
        r2.setLayoutResource(2131562866);
        r2.setInflatedId(2131379994);
        r2.inflate();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final Map<String, String> S8(Pair<String, String>... r3) {
        Intrinsics.checkNotNullParameter(r3, "param");
        ChatSendUtils r0 = ChatSendUtils.a;
        Pair[] r4 = (Pair[]) Arrays.copyOf(r3, r3.length);
        r0.getClass();
        return ChatSendUtils.p(r4);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void T8(boolean r1) {
        com.larus.bmhome.music.player.f.e = r1;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean U8(String r2) {
        CoroutineScope r0 = Gpt4SwitchManager.a;
        return Gpt4SwitchManager.d(r2);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final int d(String r2) {
        com.larus.bmhome.chat.helper.n0.a.getClass();
        return com.larus.bmhome.utils.w2.a(r2);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final com.larus.bmhome.chat.api.c0 s8(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new SearchListBox(r2);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final String u8(t1a.b r3) {
        Intrinsics.checkNotNullParameter(r3, "vContext");
        StateFlowImpl r0 = ce8.c.a;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        String r1 = UUID.randomUUID().toString();
        ce8.c.b = r1;
        ce8.c.c = "continuous_chat_left_to_asr_input";
        ce8.c.b("continuous_chat_left_to_asr_input", r1, r3);
        return ce8.c.b;
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final CharSequence J8(Context r4, wh8.a r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "conversationData");
        Set<Integer> r2 = com.larus.bmhome.chat.helper.e0.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "conversationData");
        String r0 = com.larus.bmhome.chat.helper.e0.c(r5);
        if (r0 != null) goto L7;
        r0 = com.larus.bmhome.chat.helper.e0.a(r4, r5, false);
    L7:
        return com.larus.bmhome.chat.helper.e0.d(r0);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void x8(ViewStub r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "viewStub");
        r2.setLayoutResource(2131562865);
        r2.setInflatedId(r3);
        r2.inflate();
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean M8(Map r6, Message r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "extra");
        com.larus.bmhome.chat.helper.n0.a.getClass();
        Intrinsics.checkNotNullParameter(r6, "extra");
        boolean r0 = true;
        if (r7 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L21;
        if (r7 == null) goto L14;
        String r3 = r7.getMessageId();
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        r6.put("edu_multi_answers_msg_id", r3);
        JSONObject r4 = new JSONObject();
        JSONObject r5 = new JSONObject();
        r5.put("search_index", r8);
        r5.put("refer_msg_id", r7.getReplyId());
        r5.put("send_msg_scene", "instruction_input");
        Unit r9 = Unit.INSTANCE;
        r4.put("data", r5.toString());
        r6.put("Copilot:hippo:hippo_ext", r4.toString());
    L14:
        if (r7 != null) goto L16;
    L18:
        r0 = false;
    L20:
        return r0;
    L16:
        if (com.larus.bmhome.chat.bean.d.x0(r7) != true) goto L18;
    L21:
        return false;
    L5:
        if (com.larus.bmhome.chat.bean.d.x0(r7) != true) goto L7;
        r2 = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.bmhome.chat.q4] */
    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final RecyclerView.Adapter W8(final Context r8, int r9, final com.larus.bmhome.chat.markdown.ugc.c r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r10, "mobCardShow");
        return new AwemeRecommendAdapter(new FPagingAdapter.a(4, new p4()), r9, true, new q4(r8, r10), 4);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean O8(Map r2, Message r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "extra");
        com.larus.bmhome.chat.helper.n0.a.getClass();
        return com.larus.bmhome.chat.helper.n0.c(r2, r3, r4, "reference_input", r5);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void R8(Fragment r9, wh8.a r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter("chat_list", "enterFrom");
        Intrinsics.checkNotNullParameter(r11, "currentPageName");
        Intrinsics.checkNotNullParameter(r12, "argPosition");
        new ConversationClickHelper(r9, r11, null, null, false).d(r10, "chat_list", r12, null);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final Object v8(EditPos r2, BotModel r3, String r4, Continuation<? super Boolean> r5) {
        return VoiceCallServiceDelegate.a.f(r2, r3, r4, r5);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void w8(String r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter("feedback", "enterMethod");
        Intrinsics.checkNotNullParameter("feedback", "enterMethod");
        sf8.n.b("deep_search_button_show", r9, r10, r11, r12, new sf8.j("feedback"));
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final boolean y8(BotModel r2, String r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        return VoiceCallServiceDelegate.a.x(r2, r3, r4, r5);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final com.larus.bmhome.chat.api.q0 P8(com.larus.bmhome.chat.deepsearch.component.f r10, ChatParam r11, com.larus.bmhome.chat.deepsearch.component.d r12, com.larus.bmhome.chat.deepsearch.component.e r13, ComponentFeature r14, g r15) {
        Intrinsics.checkNotNullParameter(r10, "loader");
        Intrinsics.checkNotNullParameter(r11, "chatParam");
        Intrinsics.checkNotNullParameter(r12, "msgActionCallback");
        Intrinsics.checkNotNullParameter(r13, "hostFragment");
        Intrinsics.checkNotNullParameter(r14, "componentFeature");
        Intrinsics.checkNotNullParameter(r15, "provider");
        return new MessageAdapter(r10, r11, r12, null, r13, r14, r15);
    }

    @Override // com.larus.bmhome.chat.api.ILegacyChatUiService
    public final void L8(FragmentActivity r17, BotModel r18, de8.c r19, t1a.b r20, com.larus.bmhome.chat.component.cvs.y r21, int r22, boolean r23, Integer r24, CharSequence r25, com.larus.bmhome.chat.component.bottom.core.v2 r26, com.larus.bmhome.chat.component.bottom.core.x2 r27, com.larus.bmhome.chat.component.bottom.core.y2 r28, boolean r29, boolean r30, ViewGroup r31, boolean r32, InputFilter[] r33, Map r34) {
        Intrinsics.checkNotNullParameter(r17, "activity");
        Intrinsics.checkNotNullParameter(r20, "vContext");
        Intrinsics.checkNotNullParameter(r25, "voiceInputContent");
        Intrinsics.checkNotNullParameter(r26, "onClickSend");
        Intrinsics.checkNotNullParameter(r27, "onUpdateInputText");
        Intrinsics.checkNotNullParameter(r28, "onFold");
        Intrinsics.checkNotNullParameter(r34, "fullInputBoxMobParams");
        com.larus.bmhome.utils.l0 r11 = new com.larus.bmhome.utils.l0(r17);
        r11.c = r18;
        r11.h = r19;
        r11.i = r21;
        com.larus.bmhome.chat.component.bottom.voice.d0 r0 = new com.larus.bmhome.chat.component.bottom.voice.d0(r20);
        Intrinsics.checkNotNullParameter(r0, "tracker");
        r11.k = r0;
        r11.j = r22;
        Intrinsics.checkNotNullParameter(r26, "callback");
        r11.d = r26;
        Intrinsics.checkNotNullParameter(r27, "callback");
        r11.e = r27;
        Intrinsics.checkNotNullParameter(r25, ChatDraftItem.TYPE_TEXT);
        r11.f = r25;
        if (r23 == false) goto L5;
        Integer r1 = r24;
    L6:
        r11.g = r1;
        Intrinsics.checkNotNullParameter(r28, "onFold");
        r11.l = r28;
        r11.m = r31;
        r11.n = r30;
        r11.o = r32;
        r11.p = r33;
        Intrinsics.checkNotNullParameter(r34, "params");
        r11.q = r34;
        FullScreenEditFrameLayout r2 = r11.a();
        FragmentActivity r3 = r11.a;
        BotModel r4 = r11.c;
        com.larus.bmhome.chat.component.bottom.voice.d0 r5 = r11.k;
        Function1<? super Boolean, Unit> r6 = r11.d;
        Function3<? super CharSequence, ? super Boolean, ? super Boolean, Unit> r7 = r11.e;
        Function0<Unit> r8 = r11.l;
        boolean r12 = r11.n;
        boolean r13 = r11.o;
        InputFilter[] r14 = r11.p;
        Map<String, String> r15 = r11.q;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "onClickSend");
        Intrinsics.checkNotNullParameter(r7, "onUpdateInputText");
        Intrinsics.checkNotNullParameter(r8, "onFold");
        Intrinsics.checkNotNullParameter(r15, "fullInputBoxMobParams");
        r2.f = r3;
        r2.e = r4;
        r2.g = r5;
        r2.h = r6;
        r2.i = r7;
        r2.q = r12;
        r2.r = r8;
        if (r12 == false) goto L9;
        AppCompatImageView r9 = r2.a.c;
        int r10 = com.larus.utils.j0.a;
        r9.setImageDrawable(com.larus.utils.j0.c(2131241440));
    L9:
        r2.s = r13;
        r2.t = r15;
        if (r14 == null) goto L12;
        r2.getClass();
        r2.a.m.setFilters(r14);
    L12:
        ViewGroup.LayoutParams r16 = new ViewGroup.LayoutParams(-1, -1);
        r11.a().setLayoutParams(r16);
        r11.a().setOnClickListener(new dg5.d());
        final FullScreenEditFrameLayout r35 = r11.a();
        com.larus.utils.e1.d(r35.a.k, new m3(r35));
        r11.a().o(r11.a, r11.j, r11.h, r11.i);
        int r36 = ContextCompat.getColor(r11.a, 2131103293);
        FlowCommonAppCompatActivity r37 = r11.a;
        if ((r37 instanceof FlowCommonAppCompatActivity) == false) goto L15;
        FlowCommonAppCompatActivity r38 = r37;
    L16:
        if (r38 == null) goto L18;
        r38.B1(r36);
    L18:
        r11.a().setInputText(r11.f);
        FullScreenEditFrameLayout.l(r11.a());
        Integer r39 = r11.g;
        if (r39 == null) goto L21;
        r11.a().setImmersiveStyle(r39.intValue());
    L21:
        Boolean r40 = Boolean.valueOf(r11.n);
        if (r40.booleanValue() == true) goto L25;
        r40 = null;
    L25:
        if (r40 == null) goto L29;
        r40.booleanValue();
        FullScreenEditFrameLayout r41 = r11.a();
        LarusPageChatFullScreenEditBinding r42 = r41.a;
        r42.j.setBackground(ContextCompat.getDrawable(r41.getContext(), 2131239836));
        r42.l.setImageTintList(ColorStateList.valueOf(ColorProtector.parseColor("#FF777777")));
        r42.m.setTextColor(ContextCompat.getColor(r41.getContext(), 2131103298));
        r42.m.setHintTextColor(ColorProtector.parseColor("#FF777777"));
        r42.c.setImageResource(2131240047);
        com.larus.utils.e1.v(r42.e, ColorProtector.parseColor("#FF000000"));
        if (Build.VERSION.SDK_INT < 29) goto L29;
        r42.m.setTextCursorDrawable(ContextCompat.getDrawable(r41.getContext(), 2131240254));
    L29:
        FullScreenEditFrameLayout r43 = r11.a();
        if (r11.g == null) goto L32;
        boolean r44 = true;
    L33:
        r43.getClass();
        Lazy r45 = we8.e.a;
        if (we8.e.d != FontLevel.SUPER_EXTRA_LARGE.getValue()) goto L36;
        we8.a.b(r43.a.m, v19.i5.t(), r44, null, null, 12);
    L36:
        ViewGroup r46 = r11.m;
        if (r46 == null) goto L39;
        r46.addView(r11.a(), r16);
        return;
    L39:
        r11.a.addContentView(r11.a(), r16);
        return;
    L32:
        r44 = false;
        goto L33
    L15:
        r38 = null;
        goto L16
    L5:
        r1 = null;
        goto L6
    }
}
