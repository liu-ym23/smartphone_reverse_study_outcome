package com.larus.bmhome.chat.component.action;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ixigua.lib.track.TrackParams;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.adapter.MessageModifyMode;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceEmpty;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.bean.SuggestActionType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.chat.component.bottom.multimodal.e1;
import com.larus.bmhome.chat.component.bottom.multimodal.f1;
import com.larus.bmhome.chat.component.bottom.p1;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.j1;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.utils.FileMimeTypeUtils;
import com.larus.canvas.service.ICanvasService;
import com.larus.canvas.service.bean.LocalFileImage;
import com.larus.canvas.service.bean.NetworkImage;
import com.larus.common_ui.view.SuggestedActionBar;
import com.larus.common_ui.view.z;
import com.larus.feishu.office.im.impl.base.q0;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.model.action.InstructionConfig;
import com.larus.platform.model.action.InstructionRedirectType;
import com.larus.platform.model.action.RedirectionCfg;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionKey;
import com.larus.platform.model.action.SuggestedActionScene;
import com.larus.platform.model.action.SuggestedActionType;
import com.larus.platform.model.action.SuggestedExt;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import od8.h0;
import org.json.JSONException;
import org.json.JSONObject;
import yc9.l1;
import yc9.n1;
import zb8.e$a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 «\u00012\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0004«\u0001¬\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010g\u001a\u00020`H\u0002J\b\u0010h\u001a\u00020iH\u0016J\b\u0010j\u001a\u00020iH\u0016J\u0010\u0010k\u001a\u00020i2\u0006\u0010l\u001a\u00020YH\u0016J\b\u0010m\u001a\u00020iH\u0016J\b\u0010n\u001a\u00020iH\u0002J\b\u0010o\u001a\u00020iH\u0014J\u000e\u0010p\u001a\u00020qH\u0082@¢\u0006\u0002\u0010rJN\u0010s\u001a\u00020i2\b\u0010t\u001a\u0004\u0018\u00010u2\u0006\u0010v\u001a\u00020G2\u0006\u0010w\u001a\u00020^2\u000e\u0010x\u001a\n\u0012\u0004\u0012\u00020y\u0018\u00010[2\u001a\u0010z\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\\\u0018\u00010[\u0012\u0004\u0012\u00020i0{H\u0016J*\u0010|\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010[2\b\u0010t\u001a\u0004\u0018\u00010u2\u0006\u0010v\u001a\u00020G2\u0006\u0010w\u001a\u00020^H\u0016J:\u0010}\u001a\u00020i2\b\u0010t\u001a\u0004\u0018\u00010u2\u0006\u0010v\u001a\u00020G2\u0006\u0010w\u001a\u00020^2\u000e\u0010x\u001a\n\u0012\u0004\u0012\u00020y\u0018\u00010[2\u0006\u0010~\u001a\u00020^H\u0016J7\u0010\u007f\u001a\u00020i2\u0006\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020G2\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\\0[2\u0006\u0010w\u001a\u00020^2\u0006\u0010~\u001a\u00020^H\u0016J8\u0010\u0081\u0001\u001a\u00020i2\u0006\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020G2\r\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\\0[2\u000e\u0010\u0082\u0001\u001a\t\u0012\u0004\u0012\u00020G0\u0083\u0001H\u0016J\u0012\u0010\u0084\u0001\u001a\u00020i2\u0007\u0010\u0085\u0001\u001a\u00020^H\u0016J\u0014\u0010\u0086\u0001\u001a\u00020i2\t\b\u0002\u0010\u0087\u0001\u001a\u00020^H\u0002J\t\u0010\u0088\u0001\u001a\u00020^H\u0002J&\u0010\u0089\u0001\u001a\u00020i2\u0006\u0010v\u001a\u00020G2\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00012\u0007\u0010\u008c\u0001\u001a\u00020^H\u0002J\t\u0010\u008d\u0001\u001a\u00020^H\u0016J&\u0010\u008e\u0001\u001a\u00020i2\u0006\u0010v\u001a\u00020G2\n\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00012\u0007\u0010\u008c\u0001\u001a\u00020^H\u0016J\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008b\u00012\u0006\u0010v\u001a\u00020G2\u0006\u0010w\u001a\u00020^H\u0016J\u0012\u0010\u0090\u0001\u001a\u00020i2\u0007\u0010\u0091\u0001\u001a\u00020^H\u0016J\u0012\u0010\u0092\u0001\u001a\u00020i2\u0007\u0010\u0093\u0001\u001a\u00020^H\u0016J\t\u0010\u0094\u0001\u001a\u00020iH\u0016J\t\u0010\u0095\u0001\u001a\u00020^H\u0016J\u001a\u0010\u0096\u0001\u001a\t\u0012\u0005\u0012\u00030\u0097\u00010[*\b\u0012\u0004\u0012\u00020\\0[H\u0002J\t\u0010\u0098\u0001\u001a\u00020GH\u0002J\f\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0002J\u000b\u0010\u009b\u0001\u001a\u0004\u0018\u00010qH\u0002J\u0012\u0010\u009c\u0001\u001a\u00020i2\u0007\u0010\u009d\u0001\u001a\u00020^H\u0016J\u000b\u0010\u009e\u0001\u001a\u0004\u0018\u00010YH\u0016J\u000b\u0010\u009f\u0001\u001a\u0004\u0018\u00010YH\u0016J\u0012\u0010 \u0001\u001a\u00020i2\u0007\u0010¡\u0001\u001a\u00020GH\u0016J0\u0010¢\u0001\u001a\u00020i2%\u0010£\u0001\u001a \u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\\0[\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\\0[\u0018\u00010{H\u0016J&\u0010¤\u0001\u001a\u00020i2\u001b\u0010¥\u0001\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020H0F\u0018\u00010EH\u0016J\u0015\u0010¦\u0001\u001a\u00020i2\n\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001H\u0004J\u0012\u0010©\u0001\u001a\u00020^2\u0007\u0010ª\u0001\u001a\u00020\\H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010$R\u001d\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b(\u0010)R\u001d\u0010+\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0011\u001a\u0004\b-\u0010.R\u001d\u00100\u001a\u0004\u0018\u0001018DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0011\u001a\u0004\b2\u00103R\u001d\u00105\u001a\u0004\u0018\u0001068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0011\u001a\u0004\b7\u00108R\u001d\u0010:\u001a\u0004\u0018\u00010;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0011\u001a\u0004\b<\u0010=R\u001d\u0010?\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u0011\u001a\u0004\bA\u0010BR\"\u0010D\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020H0F\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010I\u001a\n K*\u0004\u0018\u00010J0J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\u0011\u001a\u0004\bL\u0010MR#\u0010O\u001a\n K*\u0004\u0018\u00010P0P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u0011\u001a\u0004\bQ\u0010RR\u0010\u0010T\u001a\u0004\u0018\u00010UX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010WX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010Z\u001a\b\u0012\u0004\u0012\u00020\\0[X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010_\u001a\u00020`8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\u0011\u001a\u0004\ba\u0010bR\u0014\u0010d\u001a\u00020^8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\be\u0010f¨\u0006\u00ad\u0001"}, d2 = {"Lcom/larus/bmhome/chat/component/action/SuggestedActionComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "instructionCoreAbility", "Lcom/larus/bmhome/instruction/IInstructionCoreHandler;", "getInstructionCoreAbility", "()Lcom/larus/bmhome/instruction/IInstructionCoreHandler;", "instructionCoreAbility$delegate", "chatCameraAbility", "Lcom/larus/bmhome/camera/IChatCameraAbility;", "getChatCameraAbility", "()Lcom/larus/bmhome/camera/IChatCameraAbility;", "chatCameraAbility$delegate", "multimodalAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "chatBottomAbility", "Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "getChatBottomAbility", "()Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "chatBottomAbility$delegate", "refMsgAbility", "Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "getRefMsgAbility", "()Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "refMsgAbility$delegate", "attachmentSuggestedActionEventParamsProvider", "Lkotlin/Function0;", "", "", "", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "typeToken", "Ljava/lang/reflect/Type;", "getTypeToken", "()Ljava/lang/reflect/Type;", "typeToken$delegate", "input", "Lcom/larus/bmhome/chat/component/bottom/core/InputView;", "suggestedActionBar", "Lcom/larus/common_ui/view/SuggestedActionBar;", "suggestedActionBarTopDivider", "Landroid/view/View;", "boundInputSuggestedActions", "", "Lcom/larus/platform/model/action/SuggestedAction;", "suggestBarSuppressedForInputText", "", "suggestedActionDataController", "Lcom/larus/bmhome/chat/camera/command/CameraSuggestedActionProvider;", "getSuggestedActionDataController", "()Lcom/larus/bmhome/chat/camera/command/CameraSuggestedActionProvider;", "suggestedActionDataController$delegate", "disableSuggestedAction", "getDisableSuggestedAction", "()Z", "createSuggestedActionDataController", "onAttach", "", "onCreate", "onViewCreated", "view", "onDestroy", "clearInvalidDraft", "initSuggestedAction", "getBotAsync", "Lcom/larus/im/bean/bot/BotModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSuggestedAction", "scene", "Lcom/larus/platform/model/action/SuggestedActionScene;", "bizScene", "useDraft", "attachmentList", "Lcom/larus/im/bean/message/UplinkFileEntity;", "callback", "Lkotlin/Function1;", "getSuggestedActionSync", "bindInputSuggestedAction", "hideSuggestActionBar", "bindInputSuggestedActions", "actions", "insertInputSuggestedActionsWithAnimate", "removeActionKeys", "", "setSuggestBarSuppressedForInputText", "suppressed", "applySuggestBarVisibility", "animatedForInputText", "isInterceptBind", "updateSuggestedActionOperationsDraft", "suggestedActionOperations", "Lcom/larus/platform/model/action/SuggestedActionOperations;", "updateDraft", "previewSugEnabled", "setSuggestedActionOperations", "getSuggestedActionOperations", "scrollSuggestedActionToFirst", "withAnim", "setSuggestedActionBarEnabled", "enable", "resetSuggestedAction", "getSuggestedActionBarVisibility", "convert2BarItemList", "Lcom/larus/common_ui/view/SuggestedActionBar$SuggestedActionBarItem;", "conversationId", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "currentBot", "changeShowMode", "value", "obtainSuggestedActionBar", "obtainDividerActionbarView", "addSuggestedActionPrefix", "prefix", "setSuggestedActionFilter", "filter", "setAttachmentSuggestedActionEventParamsProvider", "provider", "completeSuggestedActionData", "data", "Lcom/larus/platform/model/action/SuggestedActionData;", "handleRedirectionAction", "action", "Companion", "SuggestedActionBarCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public class SuggestedActionComponent extends BaseContentWidget implements bc8.a {
    public static final /* synthetic */ int G = 0;
    public final Lazy A;
    public SuggestedActionBar B;
    public View C;
    public List<SuggestedAction> D;
    public boolean E;
    public final Lazy F;
    public int m;
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
    public Function0<? extends Map<String, ? extends Object>> y;
    public final Lazy z;

    public static final class a {
    }

    public final class b implements SuggestedActionBar.a {
        public final String a;
        public final SuggestedActionScene b;
        public final List<SuggestedAction> c;
        public final /* synthetic */ SuggestedActionComponent d;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[SuggestedActionScene.values().length];
                r0[SuggestedActionScene.AttachmentAreaSingleImg.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
            L25:
                r0[SuggestedActionScene.AttachmentAreaSingleFile.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
            L39:
                r0[SuggestedActionScene.AttachmentAreaMultiImg.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
            L29:
                r0[SuggestedActionScene.AttachmentAreaMultiFile.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
            L31:
                r0[SuggestedActionScene.AttachmentAreaAudio.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
            L23:
                r0[SuggestedActionScene.AttachmentAreaAudioFile.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
            L33:
                r0[SuggestedActionScene.AttachmentAreaAudioSheet.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
            L35:
                r0[SuggestedActionScene.EcomPageAttachmentAreaSingleImage.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
            L27:
                r0[SuggestedActionScene.EcomPageAttachmentAreaMultiImage.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
            L12:
                a = r0;
            }
        }

        public static ResourceUploadInstantInfo c(UplinkFileEntity r3) {
            String r4 = r3.getInstantUploadInfoJson();
            Object r0 = null;
            if (r4 != null) goto L5;
            return null;
        L5:
            if (r4.length() <= 0) goto L7;
            boolean r1 = true;
        L8:
            if (r1 == true) goto L11;
            r4 = null;
        L11:
            if (r4 == null) goto L25;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
            Object r5 = Result.constructor-impl((ResourceUploadInstantInfo) new GsonBuilder().create().fromJson(r4, ResourceUploadInstantInfo.class));     // Catch: Throwable -> L14
        L17:
            if (Result.isFailure-impl(r5) == true) goto L21;
            r0 = r5;
        L21:
            return (ResourceUploadInstantInfo) r0;
        L14:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            r5 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L17
        L25:
            return null;
        L7:
            r1 = false;
            goto L8
        }

        public static boolean f(Image r5) {
            Boolean r0 = r5.aiCreationImage;
            if (r0 != null) goto L5;
            ImageObj r1 = r5.previewImage;
            String r2 = null;
            if (r1 == null) goto L9;
            String r3 = r1.url;
        L11:
            if (r3 != null) goto L13;
        L15:
            boolean r4 = false;
        L16:
            if (r4 == true) goto L39;
            ImageObj r6 = r5.imageThumb;
            if (r6 == null) goto L20;
            String r7 = r6.url;
        L21:
            if (r7 != null) goto L23;
        L25:
            boolean r8 = false;
        L26:
            if (r8 == true) goto L40;
            ImageObj r9 = r5.imageOri;
            if (r9 == null) goto L30;
            r2 = r9.url;
        L30:
            if (r2 != null) goto L32;
        L34:
            boolean r10 = false;
        L35:
            if (r10 == true) goto L41;
            return false;
        L41:
            return true;
        L32:
            if (StringsKt.contains(r2, "watermark", true) != true) goto L34;
            r10 = true;
            goto L35
        L40:
            return true;
        L23:
            if (StringsKt.contains(r7, "watermark", true) != true) goto L25;
            r8 = true;
            goto L26
        L20:
            r7 = null;
            goto L21
        L39:
            return true;
        L13:
            if (StringsKt.contains(r3, "watermark", true) != true) goto L15;
            r4 = true;
            goto L16
        L9:
            r3 = null;
            goto L11
        L5:
            return r0.booleanValue();
        }

        public final boolean d(SuggestedAction r81) {
            Intrinsics.checkNotNullParameter(r81, "action");
            boolean r4 = false;
            if (r81.getSuggestedActionType() == SuggestedActionType.Redirection.getValue()) goto L5;
            return false;
        L5:
            String r1 = r81.getSuggestedActionKey();
            String r7 = "";
            if (Intrinsics.areEqual(r1, SuggestedActionKey.AIBeautify.getValue()) == false) goto L162;
            SuggestedActionComponent r2 = this.d;
            int r3 = SuggestedActionComponent.G;
            g1 r5 = r2.f70();
            if (r5 == null) goto L310;
            List<UplinkFileEntity> r6 = r5.q1();
            if (r6 == null) goto L310;
            UplinkFileEntity r8 = (UplinkFileEntity) CollectionsKt.firstOrNull(r6);
            if (r8 == null) goto L310;
            g1 r9 = this.d.f70();
            if (r9 == null) goto L22;
            Map r10 = r8.getExtra();
            if (r10 == null) goto L20;
            Map r11 = MapsKt.toMutableMap(r10);
            if (r11 == null) goto L20;
        L21:
            r11.put("disable_remote_delete", "1");
            Unit r12 = Unit.INSTANCE;
            r9.EC(UplinkFileEntity.copy$default(r8, null, null, null, null, null, null, null, null, null, false, null, null, null, r11, 8191, null));
        L20:
            r11 = new LinkedHashMap();
        L22:
            Image r13 = l1.c(r8);
            if (r13 == null) goto L310;
            if (z2.a.getCreationCanvasConfig().a() == false) goto L139;
            String r14 = r13.localResPath;
            if (r14 != null) goto L30;
        L32:
            String r15 = null;
        L33:
            if (r15 != null) goto L35;
        L38:
            boolean r16 = true;
        L39:
            if (r16 == true) goto L49;
            String r17 = r13.key;
            ImageObj r18 = r13.imageOri;
            if (r18 == null) goto L43;
            Integer r19 = Integer.valueOf(r18.width);
        L44:
            ImageObj r20 = r13.imageOri;
            if (r20 == null) goto L47;
            Integer r110 = Integer.valueOf(r20.height);
        L48:
            LocalFileImage r21 = new LocalFileImage(r15, r17, r19, r110, false);
        L99:
            LocalFileImage r111 = r21;
        L100:
            FragmentActivity r112 = s1a.a.getActivity(this.d);
            Pair[] r22 = new Pair[4];
            BotModel r23 = SuggestedActionComponent.m3(this.d);
            if (r23 == null) goto L103;
            String r24 = r23.getBotId();
        L104:
            r22[0] = TuplesKt.to("bot_id", r24);
            BotModel r25 = SuggestedActionComponent.m3(this.d);
            if (r25 == null) goto L107;
            String r26 = r25.getChatType(AccountService.a.getUserId());
        L108:
            r22[1] = TuplesKt.to("chat_type", r26);
            r22[2] = TuplesKt.to("previous_page", "chat");
            r22[3] = TuplesKt.to("enter_method", "input_attachment_sug");
            Bundle r113 = com.larus.utils.f.c(r22);
            wc9.e r27 = SuggestedActionComponent.Y2(this.d);
            if (r27 == null) goto L116;
            Integer r28 = r27.f;
            if (r28 == null) goto L116;
            if (r28.intValue() != 1) goto L116;
            boolean r29 = true;
        L117:
            if (r29 == false) goto L125;
            wc9.e r30 = (wc9.e) AuthModelDelegate.b.y().getValue();
            if (r30 == null) goto L121;
            String r31 = r30.a;
        L122:
            if (r31 == null) goto L137;
            String r114 = r31;
        L138:
            ny8.e r32 = new ny8.e(r112, null, r111, r113, r114, 54);
            ICanvasService.a.a(r32);
        L137:
            r114 = r7;
            goto L138
        L121:
            r31 = null;
            goto L122
        L125:
            String r33 = SuggestedActionComponent.h3(this.d);
            if (r33.length() != 0) goto L128;
            r4 = true;
        L128:
            if (r4 == false) goto L136;
            wc9.e r34 = (wc9.e) AuthModelDelegate.b.y().getValue();
            if (r34 == null) goto L132;
            String r35 = r34.a;
        L133:
            if (r35 == null) goto L137;
            r7 = r35;
            goto L137
        L132:
            r35 = null;
            goto L133
        L136:
            r7 = r33;
        L116:
            r29 = false;
            goto L117
        L107:
            r26 = null;
            goto L108
        L103:
            r24 = null;
            goto L104
        L47:
            r110 = null;
            goto L48
        L43:
            r19 = null;
            goto L44
        L49:
            ImageObj r36 = r13.previewImage;
            if (r36 == null) goto L58;
            String r37 = r36.url;
            if (r37 == null) goto L58;
            if (o0.d(r37) == true) goto L57;
            r37 = null;
        L57:
            if (r37 == null) goto L58;
        L77:
            String r115 = r37;
            String r116 = r13.key;
            ImageObj r38 = r13.previewImage;
            if (r38 != null) goto L85;
            r38 = r13.imageOri;
            if (r38 != null) goto L85;
            r38 = r13.imageThumb;
            if (r38 != null) goto L85;
            Integer r117 = null;
        L87:
            ImageObj r39 = r13.previewImage;
            if (r39 != null) goto L92;
            r39 = r13.imageOri;
            if (r39 != null) goto L92;
            ImageObj r40 = r13.imageThumb;
            if (r40 == null) goto L97;
            int r41 = r40.height;
        L96:
            Integer r118 = Integer.valueOf(r41);
        L98:
            r21 = new NetworkImage(r116, r115, r117, r118, null, false);
            goto L99
        L97:
            r118 = null;
        L92:
            r41 = r39.height;
        L85:
            r117 = Integer.valueOf(r38.width);
        L58:
            ImageObj r42 = r13.imageOri;
            if (r42 == null) goto L65;
            r37 = r42.url;
            if (r37 == null) goto L65;
            if (o0.d(r37) == false) goto L65;
        L66:
            if (r37 != null) goto L77;
            ImageObj r43 = r13.imageThumb;
            if (r43 == null) goto L74;
            r37 = r43.url;
            if (r37 == null) goto L74;
            if (o0.d(r37) == false) goto L74;
        L75:
            if (r37 != null) goto L77;
            r111 = null;
        L74:
            r37 = null;
        L65:
            r37 = null;
            goto L66
        L35:
            if (r15.length() == 0) goto L38;
            r16 = false;
            goto L39
        L30:
            if (o0.d(r14) == false) goto L32;
            r15 = r14;
            goto L33
        L139:
            com.larus.bmhome.instruction.g r44 = this.d.vc();
            if (r44 == null) goto L142;
            Pair r45 = r44.N8();
        L143:
            ICreationWorkflowService.Companion r46 = ICreationWorkflowService.a;
            FragmentActivity r210 = s1a.a.getActivity(this.d);
            if (r45 == null) goto L310;
            z0 r310 = (z0) r45.getFirst();
            if (r310 == null) goto L310;
            String r47 = SuggestedActionComponent.h3(this.d);
            BotModel r48 = SuggestedActionComponent.m3(this.d);
            if (r48 == null) goto L151;
            String r49 = r48.getBotId();
        L152:
            ChatParam r311 = new ChatParam(r47, r49, null, null, null, 252);
            wc9.e r50 = SuggestedActionComponent.Y2(this.d);
            if (r50 == null) goto L155;
            String r76 = r50.B;
        L156:
            ResourceUploadInstantInfo r410 = c(r8);
            g1 r51 = this.d.f70();
            if (r51 == null) goto L159;
            String r411 = r51.uM();
        L160:
            boolean r412 = f(r13);
            SuggestedActionComponent r52 = this.d;
            r46.f0(new ny9.b(false, r210, r310, r311, false, false, null, null, null, null, null, null, null, null, r13, r410, r411, null, null, r412, false, new s(r52, r13), null, null, true, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, (ChatPageContext) s1a.d.a(r52).a(ChatPageContext.class), null, s1a.a.c(this.d), null, r76, false, -19513359, 176127));
            goto L310
        L159:
            r411 = null;
            goto L160
        L155:
            r76 = null;
            goto L156
        L151:
            r49 = null;
            goto L152
        L142:
            r45 = null;
        L310:
            return true;
        L162:
            if (Intrinsics.areEqual(r1, SuggestedActionKey.InvokeCamera.getValue()) == false) goto L170;
            HashMap r119 = new HashMap();
            ChatFragment r53 = s1a.a.c(this.d);
            if ((r53 instanceof ChatFragment) == false) goto L166;
            r119.put("chat_key", Long.valueOf(r53.getChatUniqueKey()));
        L166:
            r119.put("click_from", "input_attachment_sug");
            zb8.e r120 = (zb8.e) this.d.r.getValue();
            if (r120 == null) goto L310;
            e$a.b(r120, "suggested_action", r119, null, null, null, false, 124);
            goto L310
        L170:
            if (Intrinsics.areEqual(r1, SuggestedActionKey.InvokeAlbum.getValue()) == false) goto L175;
            com.larus.bmhome.chat.component.bottom.multimodal.g r54 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.d.s.getValue();
            if (r54 == null) goto L310;
            r54.n90(new e1(new f1.a(false, 0, 3), new com.larus.bmhome.chat.component.bottom.multimodal.g1(true, MultimodalBizScene.SuggestedActionAlbum, false), null, null, 12));
            goto L310
        L175:
            if (Intrinsics.areEqual(r1, SuggestedActionKey.InvokeDirectory.getValue()) == false) goto L180;
            com.larus.bmhome.chat.component.bottom.multimodal.g r55 = (com.larus.bmhome.chat.component.bottom.multimodal.g) this.d.s.getValue();
            if (r55 == null) goto L310;
            r55.n90(new e1(new f1.c(false, 7), new com.larus.bmhome.chat.component.bottom.multimodal.g1(true, MultimodalBizScene.SuggestedActionFile, false), null, null, 12));
            goto L310
        L180:
            if (Intrinsics.areEqual(r1, SuggestedActionKey.InvokeCall.getValue()) == false) goto L241;
            SuggestedActionComponent r56 = this.d;
            int r57 = SuggestedActionComponent.G;
            va8.o r58 = (va8.o) r56.v.getValue();
            if (r58 != null) goto L184;
        L186:
            boolean r312 = false;
        L187:
            ILegacyChatUiServiceEmpty r59 = ILegacyChatUiServiceEmpty.a;
            Fragment r211 = s1a.a.c(this.d);
            String r212 = SuggestedActionComponent.h3(this.d);
            wc9.e r60 = SuggestedActionComponent.Y2(this.d);
            if (r60 == null) goto L190;
            String r63 = r60.I;
        L191:
            wc9.e r61 = SuggestedActionComponent.Y2(this.d);
            if (r61 == null) goto L194;
            String r313 = r61.B;
        L195:
            wc9.e r62 = SuggestedActionComponent.Y2(this.d);
            if (r62 == null) goto L198;
            Long r314 = r62.q;
        L199:
            BotModel r315 = SuggestedActionComponent.m3(this.d);
            de8.c r64 = this.d.f1();
            if (r64 == null) goto L202;
            RecommendFrom r316 = r64.d;
        L203:
            ChatControlTrace r65 = ChatControlTrace.b;
            wc9.e r66 = SuggestedActionComponent.Y2(this.d);
            if (r66 == null) goto L206;
            Integer r67 = r66.v;
        L207:
            BotModel r68 = SuggestedActionComponent.m3(this.d);
            if (r68 == null) goto L210;
            Integer r69 = r68.getBotType();
        L211:
            BotModel r70 = SuggestedActionComponent.m3(this.d);
            if (r70 == null) goto L216;
            BotCreatorInfo r71 = r70.getBotCreatorInfo();
            if (r71 == null) goto L216;
            String r72 = r71.getId();
        L217:
            String r317 = r65.g(r67, r69, Intrinsics.areEqual(r72, AccountService.a.getUserId()));
            de8.c r73 = this.d.f1();
            if (r73 == null) goto L220;
            SearchMobParam r318 = r73.e;
        L221:
            by7.e r74 = s1a.a.c(this.d);
            if ((r74 instanceof by7.e) == false) goto L224;
            by7.e r413 = r74;
        L225:
            de8.c r75 = this.d.f1();
            if (r75 == null) goto L231;
            String r77 = r75.e();
            if (r77 == null) goto L231;
            String r414 = r77;
        L232:
            de8.c r78 = this.d.f1();
            if (r78 == null) goto L238;
            String r79 = r78.d();
            if (r79 == null) goto L238;
            String r415 = r79;
        L239:
            b3a.c r80 = new b3a.c(r211, r212, r313, r314, r315, r316, r317, "chat", "input_attachment_sug", null, r312, r318, null, r413, r414, r415, 0, null, null, null, null, null, null, null, null, null, null, ChatControlTrace.L, ChatControlTrace.M, ChatControlTrace.P, null, null, null, null, null, r63, -939585024, 63);
            r59.getClass();
            Intrinsics.checkNotNullParameter(r80, "bean");
        L238:
            r415 = "";
        L231:
            r414 = "";
            goto L232
        L224:
            r413 = null;
            goto L225
        L220:
            r318 = null;
        L216:
            r72 = null;
            goto L217
        L210:
            r69 = null;
            goto L211
        L206:
            r67 = null;
            goto L207
        L202:
            r316 = null;
            goto L203
        L198:
            r314 = null;
            goto L199
        L194:
            r313 = null;
            goto L195
        L190:
            r63 = null;
            goto L191
        L184:
            if (r58.a8() != true) goto L186;
            r312 = true;
            goto L187
        L241:
            if (Intrinsics.areEqual(r1, SuggestedActionKey.AIVideoGenerate.getValue()) == false) goto L313;
            RedirectionCfg r82 = r81.getRedirectionCfg();
            if (r82 == null) goto L247;
            InstructionConfig r83 = r82.getInstructionConfig();
            if (r83 == null) goto L247;
            Integer r84 = Integer.valueOf(r83.getRedirectionType());
        L248:
            int r85 = InstructionRedirectType.EnterIndependentPage.getValue();
            if (r84 != null) goto L252;
        L285:
            int r86 = InstructionRedirectType.SendMessage.getValue();
            if (r84 != null) goto L289;
        L311:
            FLogger.a.e("SuggestedActionComponent", "AIVideoGenerate redirectionType is invalid");
            return false;
        L289:
            if (r84.intValue() != r86) goto L311;
            RedirectionCfg r87 = r81.getRedirectionCfg();
            if (r87 == null) goto L293;
            InstructionConfig r88 = r87.getInstructionConfig();
        L294:
            SuggestedActionComponent r89 = this.d;
            int r90 = SuggestedActionComponent.G;
            g1 r91 = r89.f70();
            if (r91 == null) goto L310;
            List<UplinkFileEntity> r92 = r91.q1();
            if (r92 == null) goto L310;
            UplinkFileEntity r93 = (UplinkFileEntity) CollectionsKt.firstOrNull(r92);
            if (r93 == null) goto L310;
            Image r121 = l1.c(r93);
            if (r121 == null) goto L310;
            com.larus.bmhome.instruction.f r94 = (com.larus.bmhome.instruction.f) this.d.q.getValue();
            if (r94 == null) goto L310;
            if (r88 == null) goto L308;
            String r95 = r88.getMessageText();
        L309:
            aq8.e r96 = new aq8.e(String.valueOf(r95), null, null, null, null, false, null, "attachment_suggest", null, r121, 382);
            Unit r97 = Unit.INSTANCE;
            r94.b(new com.larus.bmhome.instruction.n(SuggestActionType.VIDEO, r96, true, null, null, 24));
            goto L310
        L308:
            r95 = null;
            goto L309
        L293:
            r88 = null;
            goto L294
        L252:
            if (r84.intValue() != r85) goto L285;
            SuggestedActionComponent r99 = this.d;
            int r100 = SuggestedActionComponent.G;
            com.larus.bmhome.instruction.g r101 = r99.vc();
            if (r101 == null) goto L258;
            Pair r102 = r101.A7();
            if (r102 == null) goto L258;
            z0 r319 = (z0) r102.getFirst();
        L259:
            g1 r103 = this.d.f70();
            if (r103 == null) goto L310;
            List<UplinkFileEntity> r104 = r103.q1();
            if (r104 == null) goto L310;
            UplinkFileEntity r105 = (UplinkFileEntity) CollectionsKt.firstOrNull(r104);
            if (r105 == null) goto L310;
            Image r106 = l1.c(r105);
            if (r106 == null) goto L310;
            ICreationWorkflowService.Companion r107 = ICreationWorkflowService.a;
            FragmentActivity r213 = s1a.a.getActivity(this.d);
            if (r319 == null) goto L310;
            String r108 = SuggestedActionComponent.h3(this.d);
            BotModel r109 = SuggestedActionComponent.m3(this.d);
            if (r109 == null) goto L275;
            String r122 = r109.getBotId();
        L276:
            ChatParam r320 = new ChatParam(r108, r122, null, null, null, 252);
            wc9.e r123 = SuggestedActionComponent.Y2(this.d);
            if (r123 == null) goto L279;
            String r710 = r123.B;
        L280:
            ResourceUploadInstantInfo r416 = c(r105);
            g1 r124 = this.d.f70();
            if (r124 == null) goto L283;
            String r417 = r124.uM();
        L284:
            boolean r418 = f(r106);
            SuggestedActionComponent r125 = this.d;
            r107.f0(new ny9.b(false, r213, r319, r320, false, false, null, null, null, null, null, null, null, null, r106, r416, r417, null, null, r418, false, new t(r125, r106), null, null, true, null, null, null, false, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, (ChatPageContext) s1a.d.a(r125).a(ChatPageContext.class), null, s1a.a.c(this.d), null, r710, false, -19513359, 176127));
            goto L310
        L283:
            r417 = null;
            goto L284
        L279:
            r710 = null;
            goto L280
        L275:
            r122 = null;
        L258:
            r319 = null;
        L247:
            r84 = null;
            goto L248
        L313:
            return false;
        }

        public b(SuggestedActionComponent r2, String r3, SuggestedActionScene r4, List<SuggestedAction> r5) {
            Intrinsics.checkNotNullParameter(r3, "bizScene");
            Intrinsics.checkNotNullParameter(r4, "suggestedActionScene");
            this.d = r2;
            this.a = r3;
            this.b = r4;
            this.c = r5;
        }

        public final void a(String r16, int r17, int r18, boolean r19) {
            Intrinsics.checkNotNullParameter(r16, "key");
            if (Intrinsics.areEqual(r16, SuggestedActionKey.Loading.getValue()) == false) goto L5;
            return;
        L5:
            List<SuggestedAction> r0 = this.c;
            if (r0 == null) goto L41;
            Iterator<T> r1 = r0.iterator();
        L8:
            String r7 = null;
            if (r1.hasNext() == false) goto L13;
            Object r2 = r1.next();
            if (Intrinsics.areEqual(((SuggestedAction) r2).getSuggestedActionKey(), r16) == false) goto L8;
        L14:
            SuggestedAction r11 = (SuggestedAction) r2;
            if (r11 == null) goto L45;
            e(false, r16, r17, r18, r19);
            if (r11.getSuggestedActionType() != SuggestedActionType.Redirection.getValue()) goto L21;
            d(r11);
            return;
        L21:
            if (r11.getSuggestedActionType() != SuggestedActionType.MessageWithPromptReplacement.getValue()) goto L43;
            SuggestedActionScene r3 = this.b;
            Map r4 = r11.getEventExtra();
            if (r4 != null) goto L25;
        L28:
            ICoreInputAbility r8 = this.d.B3();
            if (r8 == null) goto L44;
            String r5 = r11.getDisplayName();
            if (r5 != null) goto L33;
            r5 = "";
        L33:
            String r9 = r5;
            Map r6 = r11.getEventExtra();
            if (r6 == null) goto L36;
            r7 = (String) r6.get("sug_scene");
        L36:
            ICoreInputAbility.b.c(r8, r9, false, r11, r7, null, 16);
            return;
        L44:
            return;
        L25:
            switch(a.a[r3.ordinal()]) {
                case 1: goto L27;
                case 2: goto L27;
                case 3: goto L27;
                case 4: goto L27;
                case 5: goto L27;
                case 6: goto L27;
                case 7: goto L27;
                case 8: goto L27;
                case 9: goto L27;
                default: goto L28;
            };
        L27:
            r4.put("sug_scene", "attachment_suggest");
            goto L28
        L43:
            return;
        L45:
            return;
        L13:
            r2 = null;
            goto L14
        }

        public final void b(String r8, int r9, int r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r8, "key");
            if (Intrinsics.areEqual(r8, SuggestedActionKey.Loading.getValue()) == false) goto L5;
            return;
        L5:
            e(true, r8, r9, r10, r11);
        }

        public final void e(boolean r29, String r30, int r31, int r32, boolean r33) {
            List<SuggestedAction> r0 = this.c;
            if (r0 == null) goto L203;
            Iterator<T> r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            Object r2 = r1.next();
            if (Intrinsics.areEqual(((SuggestedAction) r2).getSuggestedActionKey(), r30) == false) goto L6;
        L11:
            SuggestedAction r4 = (SuggestedAction) r2;
            if (r4 == null) goto L207;
            List<SuggestedAction> r3 = this.c;
            LinkedHashMap r5 = new LinkedHashMap();
            Iterator<T> r6 = r3.iterator();
        L16:
            if (r6.hasNext() == false) goto L21;
            Object r7 = r6.next();
            Integer r8 = Integer.valueOf(((SuggestedAction) r7).getRow());
            Object r9 = r5.get(r8);
            if (r9 != null) goto L20;
            r9 = new ArrayList();
            r5.put(r8, r9);
        L20:
            ((List) r9).add(r7);
            goto L16
        L21:
            int r10 = r5.size();
            SuggestedActionScene r11 = this.b;
            boolean r12 = false;
            if (r11 != SuggestedActionScene.AttachmentAreaSingleImg) goto L24;
        L31:
            boolean r13 = true;
        L32:
            SuggestedActionComponent r14 = this.d;
            int r15 = SuggestedActionComponent.G;
            com.larus.bmhome.instruction.g r16 = r14.vc();
            if (r16 == null) goto L35;
            Pair r17 = r16.N8();
        L36:
            g1 r18 = this.d.f70();
            if (r18 == null) goto L39;
            int r19 = g1.a.b(r18);
        L40:
            com.larus.bmhome.chat.component.bottom.reference.a r20 = (com.larus.bmhome.chat.component.bottom.reference.a) this.d.x.getValue();
            if (r20 != null) goto L43;
        L45:
            boolean r21 = false;
        L47:
            if (r21 == false) goto L121;
            ChatControlTrace r22 = ChatControlTrace.b;
            String r23 = this.a;
            long r110 = de8.d.a(this.d.f1());
            r22.getClass();
            Intrinsics.checkNotNullParameter(r4, "action");
            Intrinsics.checkNotNullParameter("chat", "currentPage");
            if (Intrinsics.areEqual(r23, "unknown_ref") == true) goto L208;
            com.larus.bmhome.chat.trace.a r24 = (com.larus.bmhome.chat.trace.a) ChatControlTrace.C.get(Long.valueOf(r110));
            if (r24 == null) goto L204;
            String r25 = r22.g(r24.d, r24.e, r24.b);
            String r111 = "direct";
            if (r29 == false) goto L92;
            String r26 = r24.a;
            String r27 = String.valueOf(r31 + 1);
            String r28 = String.valueOf(r32 + 1);
            if (r10 <= 1) goto L58;
            Object r34 = "multi_line";
        L59:
            SuggestedExt r35 = r4.getExt();
            if (r35 == null) goto L62;
            String r36 = r35.getDisplayNameStartlingKey();
        L63:
            if (r33 == true) goto L66;
            r111 = "slide";
        L66:
            JSONObject r112 = new JSONObject();
            Intrinsics.checkNotNullParameter(r112, "params");
            if (r23 != null) goto L192;
        L71:
            if (r26 == null) goto L73;
            r112.put("bot_id", r26);     // Catch: JSONException -> L69
        L73:
            if (r27 == null) goto L75;
            r112.put("prompt_position_row", r27);     // Catch: JSONException -> L69
        L75:
            if (r28 == null) goto L77;
            r112.put("prompt_position", r28);     // Catch: JSONException -> L69
        L77:
            r112.put("prompt_type", r34);     // Catch: JSONException -> L69
            if (r36 == null) goto L80;
            r112.put("title", r36);     // Catch: JSONException -> L69
        L80:
            r112.put("chat_type", r25);     // Catch: JSONException -> L69
            r112.put("show_way", r111);     // Catch: JSONException -> L69
            r112.put("current_page", "chat");     // Catch: JSONException -> L69
            String r37 = "QuestionRefEventHelper";
        L83:
            TrackParams r38 = new TrackParams().merge(r112);
            by7.a r39 = new by7.a("cite_suggest_prompt_show");
            r39.a.merge(r38);
            r39.b();
            Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L86
            com.larus.platform.service.g.a.monitorEventForSlardar("cite_suggest_prompt_show", r112, null, null);     // Catch: Throwable -> L86
            Object r41 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L86
        L88:
            Throwable r42 = Result.exceptionOrNull-impl(r41);
            if (r42 == null) goto L209;
            FLogger.a.e(r37, "slardar report error, citeSuggestPromptShow " + r42.getLocalizedMessage());
            return;
        L209:
            return;
        L86:
            th = move-exception;
            Result.Companion r43 = Result.Companion;
            r41 = Result.constructor-impl(ResultKt.createFailure(th));
        L69:
            e = move-exception;
            r37 = "QuestionRefEventHelper";
            FLogger.a.e(r37, "error in QuestionRefEventHelper citeSuggestPromptShow " + e.getLocalizedMessage());
            goto L83
        L192:
            r112.put("click_from", r23);     // Catch: JSONException -> L69
            goto L71
        L62:
            r36 = null;
            goto L63
        L58:
            r34 = "single_line";
            goto L59
        L92:
            String r44 = r24.a;
            String r45 = String.valueOf(r31 + 1);
            String r46 = String.valueOf(r32 + 1);
            if (r10 <= 1) goto L95;
            Object r47 = "multi_line";
        L96:
            SuggestedExt r48 = r4.getExt();
            if (r48 == null) goto L99;
            String r49 = r48.getDisplayNameStartlingKey();
        L100:
            if (r33 == false) goto L102;
            Object r113 = "direct";
        L103:
            JSONObject r114 = new JSONObject();
            Intrinsics.checkNotNullParameter(r114, "params");
            if (r23 != null) goto L194;
        L108:
            if (r44 == null) goto L110;
            r114.put("bot_id", r44);     // Catch: JSONException -> L106
        L110:
            if (r45 == null) goto L112;
            r114.put("prompt_position_row", r45);     // Catch: JSONException -> L106
        L112:
            if (r46 == null) goto L114;
            r114.put("prompt_position", r46);     // Catch: JSONException -> L106
        L114:
            r114.put("prompt_type", r47);     // Catch: JSONException -> L106
            if (r49 == null) goto L117;
            r114.put("title", r49);     // Catch: JSONException -> L106
        L117:
            r114.put("chat_type", r25);     // Catch: JSONException -> L106
            r114.put("show_way", r113);     // Catch: JSONException -> L106
            r114.put("current_page", "chat");     // Catch: JSONException -> L106
        L120:
            TrackParams r50 = new TrackParams().merge(r114);
            by7.a r51 = new by7.a("cite_suggest_prompt_click");
            r51.a.merge(r50);
            r51.b();
            return;
        L106:
            e = move-exception;
            FLogger.a.e("QuestionRefEventHelper", "error in QuestionRefEventHelper citeSuggestPromptClick " + e.getLocalizedMessage());
            goto L120
        L194:
            r114.put("click_from", r23);     // Catch: JSONException -> L106
            goto L108
        L102:
            r113 = "slide";
            goto L103
        L99:
            r49 = null;
            goto L100
        L95:
            r47 = "single_line";
            goto L96
        L204:
            return;
        L208:
            return;
        L121:
            ICoreInputAbility r52 = this.d.B3();
            if (r52 == null) goto L127;
            if (r52.c1() != true) goto L127;
            boolean r53 = true;
        L128:
            if (r53 == false) goto L140;
            ChatParam r54 = (ChatParam) s1a.d.a(this.d).a(ChatParam.class);
            if (r54 == null) goto L140;
            String r55 = r54.d;
            if (r55 == null) goto L140;
            if (r55.length() <= 0) goto L136;
            r12 = true;
        L136:
            if (r12 == false) goto L138;
            String r56 = r55;
        L139:
            String r57 = r56;
        L141:
            ChatControlTrace r58 = ChatControlTrace.b;
            long r59 = de8.d.a(this.d.f1());
            if (r13 == false) goto L144;
            String r60 = "pic_upload";
        L145:
            String r115 = r60;
            if (r17 == null) goto L154;
            z0 r61 = (z0) r17.getFirst();
            if (r61 == null) goto L154;
            com.larus.bmhome.actionbar.model.r r62 = r61.q;
            if (r62 == null) goto L154;
            Integer r63 = r62.a;
            if (r63 == null) goto L154;
            String r116 = r63.toString();
        L155:
            if (r17 == null) goto L161;
            z0 r64 = (z0) r17.getFirst();
            if (r64 == null) goto L161;
            com.larus.bmhome.actionbar.model.r r65 = r64.q;
            if (r65 == null) goto L161;
            String r117 = r65.g;
        L162:
            String r118 = this.a;
            BotModel r66 = SuggestedActionComponent.m3(this.d);
            if (r66 == null) goto L165;
            String r119 = r66.getBotId();
        L166:
            wc9.e r67 = SuggestedActionComponent.Y2(this.d);
            if (r67 == null) goto L169;
            Integer r68 = r67.v;
        L170:
            BotModel r69 = SuggestedActionComponent.m3(this.d);
            if (r69 == null) goto L173;
            Integer r70 = r69.getBotType();
        L174:
            BotModel r71 = SuggestedActionComponent.m3(this.d);
            if (r71 == null) goto L179;
            BotCreatorInfo r72 = r71.getBotCreatorInfo();
            if (r72 == null) goto L179;
            String r73 = r72.getId();
        L180:
            String r210 = r58.g(r68, r70, Intrinsics.areEqual(r73, AccountService.a.getUserId()));
            JSONObject r120 = new JSONObject();
            Function0<? extends Map<String, ? extends Object>> r74 = this.d.y;
            if (r74 == null) goto L188;
            Map r75 = (Map) r74.invoke();
            if (r75 == null) goto L188;
            Iterator r76 = r75.entrySet().iterator();
        L186:
            if (r76.hasNext() == false) goto L188;
            Map.Entry r77 = (Map.Entry) r76.next();
            r120.put((String) r77.getKey(), r77.getValue());
        L188:
            Unit r78 = Unit.INSTANCE;
            r58.b0(r29, r4, r59, r57, r33, null, r10, r32, r31, r115, "input_attachment_sug", r19, r116, r117, r118, r119, r210, r120);
            return;
        L179:
            r73 = null;
            goto L180
        L173:
            r70 = null;
            goto L174
        L169:
            r68 = null;
            goto L170
        L165:
            r119 = null;
        L161:
            r117 = null;
        L154:
            r116 = null;
            goto L155
        L144:
            r60 = "file_upload";
            goto L145
        L138:
            r56 = "chat";
        L140:
            r57 = "chat";
        L127:
            r53 = false;
            goto L128
        L43:
            if (r20.i9() != true) goto L45;
            r21 = true;
            goto L47
        L39:
            r19 = 0;
            goto L40
        L35:
            r17 = null;
            goto L36
        L24:
            if (r11 == SuggestedActionScene.AttachmentAreaMultiImg) goto L31;
            if (r11 == SuggestedActionScene.EcomPageAttachmentAreaSingleImage) goto L31;
            if (r11 == SuggestedActionScene.EcomPageAttachmentAreaMultiImage) goto L31;
            r13 = false;
            goto L32
        L207:
            return;
        L10:
            r2 = null;
            goto L11
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/larus/bmhome/chat/component/action/SuggestedActionComponent$typeToken$2$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/platform/model/action/SuggestedActionOperations;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class c extends TypeToken<iq9.e> {
        public c() {
        }
    }

    static {
    }

    public final ICoreInputAbility B3() {
        return (ICoreInputAbility) this.u.getValue();
    }

    @Override // bc8.a
    public final void Bz() {
        SuggestedActionBar r0 = this.B;
        if (r0 == null) goto L6;
        r0.setSuggestedActionBarEnabled(true);
        return;
    }

    public final com.larus.bmhome.chat.camera.command.p C3() {
        return (com.larus.bmhome.chat.camera.command.p) this.F.getValue();
    }

    public final p1 cr() {
        return (p1) this.w.getValue();
    }

    public final de8.c f1() {
        return (de8.c) this.n.getValue();
    }

    public final g1 f70() {
        return (g1) this.t.getValue();
    }

    @Override // bc8.a
    public final boolean mt() {
        SuggestedActionBar r0 = this.B;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 != true) goto L12;
        return true;
    L12:
        return false;
    L7:
        r1 = false;
        goto L8
    }

    @Override // bc8.a
    public final void np() {
        SuggestedActionBar r0 = this.B;
        if (r0 == null) goto L6;
        r0.scrollTo(0, 0);
        return;
    }

    @Override // bc8.a
    public final void r10() {
        SuggestedActionBar r0 = this.B;
        if (r0 == null) goto L6;
        r0.g = true;
        return;
    }

    public final y u0() {
        return (y) this.o.getValue();
    }

    public final com.larus.bmhome.instruction.g vc() {
        return (com.larus.bmhome.instruction.g) this.p.getValue();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, bc8.a.class);
    }

    public SuggestedActionComponent() {
        this.m = 2131375364;
        this.n = LazyKt.lazy(new com.larus.bmhome.chat.component.action.a(this));
        this.o = LazyKt.lazy(new n(this));
        this.p = LazyKt.lazy(new o(this));
        this.q = LazyKt.lazy(new p(this));
        this.r = LazyKt.lazy(new q(this));
        this.s = LazyKt.lazy(new r(this));
        this.t = LazyKt.lazy(new com.larus.bmhome.chat.component.action.b(this));
        this.u = LazyKt.lazy(new com.larus.bmhome.chat.component.action.c(this));
        this.v = LazyKt.lazy(new d(this));
        this.w = LazyKt.lazy(new e(this));
        this.x = LazyKt.lazy(new j(this));
        this.z = LazyKt.lazy(new k());
        this.A = LazyKt.lazy(new l());
        this.D = CollectionsKt.emptyList();
        this.F = LazyKt.lazy(new m(this));
    }

    public void D3() {
        C3().preload(DowngradeSource.COLD_LAUNCH.getValue());
    }

    public final boolean E3() {
        ICoreInputAbility r0 = B3();
        Integer r1 = null;
        if (r0 == null) goto L5;
        MessageModifyMode r2 = r0.FF();
    L7:
        if (r2 == null) goto L10;
        return true;
    L10:
        if (uy8.b.c() == false) goto L54;
        Intrinsics.checkNotNullParameter(this, "<this>");
        dr9.d r4 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).a(dr9.d.class);
        if (r4 != null) goto L14;
    L16:
        boolean r5 = false;
    L17:
        if (r5 == false) goto L54;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if ((com.larus.ui.arch.component.internal.attach.a.b(this, this) instanceof xe8.a) == true) goto L33;
        ICoreInputAbility r3 = B3();
        if (r3 != null) goto L23;
    L25:
        boolean r6 = false;
    L26:
        if (r6 == false) goto L54;
        ICoreInputAbility r7 = B3();
        if (r7 == null) goto L30;
        String r8 = r7.EW();
    L32:
        if (Intrinsics.areEqual(r8, "inject_input_photo_picker") == false) goto L54;
    L30:
        r8 = null;
        goto L32
    L23:
        if (r3.c1() != true) goto L25;
        r6 = true;
    L33:
        g1 r9 = f70();
        if (r9 == null) goto L51;
        List<UplinkFileEntity> r10 = r9.q1();
        if (r10 == null) goto L51;
        List<UplinkFileEntity> r11 = r10;
        if ((r11 instanceof Collection) == true) goto L40;
    L42:
        Iterator<T> r12 = r11.iterator();
    L44:
        if (r12.hasNext() == false) goto L48;
        if (n1.e((UplinkFileEntity) r12.next()) == false) goto L44;
        boolean r13 = true;
    L49:
        if (r13 != true) goto L51;
        boolean r14 = true;
    L52:
        if (r14 == false) goto L54;
        return true;
    L48:
        r13 = false;
        goto L49
    L40:
        if (r11.isEmpty() == false) goto L42;
    L51:
        r14 = false;
        goto L52
    L14:
        if (r4.a != true) goto L16;
        r5 = true;
    L54:
        int r15 = h0.a;
        com.larus.bmhome.instruction.g r16 = vc();
        if (r16 == null) goto L57;
        Integer r17 = Integer.valueOf(r16.Q1());
    L59:
        if (h0.f(r17) == true) goto L71;
        com.larus.bmhome.instruction.g r18 = vc();
        if (r18 == null) goto L64;
        r1 = Integer.valueOf(r18.Q1());
    L64:
        if (h0.i(r1) == true) goto L72;
        return false;
    L72:
        return true;
    L71:
        return true;
    L57:
        r17 = null;
        goto L59
    L5:
        r2 = null;
        goto L7
    }

    @Override // bc8.a
    public final boolean d3() {
        if (C3() != com.larus.bmhome.chat.camera.command.s.a) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return false;
    L9:
        return C3().d3();
    L5:
        r0 = false;
        goto L6
    }

    @Override // bc8.a
    public final void mX() {
        oaa.a r0 = s1a.d.a(this).getAbility(oaa.a.class);
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.z10() != true) goto L7;
    L8:
        if (r2 == false) goto L11;
        FLogger.a.d("SuggestedActionComponent", "resetSuggestedAction ignored: attachment action bar is taken over");
        return;
    L11:
        this.D = CollectionsKt.emptyList();
        va8.o r1 = (va8.o) this.v.getValue();
        if (r1 == null) goto L14;
        r1.e10(false);
    L14:
        View r3 = this.C;
        if (r3 == null) goto L17;
        com.larus.utils.e1.o(r3);
    L17:
        SuggestedActionBar r4 = this.B;
        if (r4 == null) goto L20;
        r4.j();
    L20:
        SuggestedActionBar r5 = this.B;
        if (r5 == null) goto L24;
        com.larus.utils.e1.o(r5);
        return;
    L24:
        return;
    L7:
        r2 = false;
        goto L8
    }

    public final void onDestroy() {
        p1 r0 = cr();
        if (r0 == null) goto L7;
        j1 r1 = r0.Y3();
        if (r1 == null) goto L7;
        ChatDraftItem r2 = r1.f();
    L8:
        if (r2 == null) goto L24;
        p1 r3 = cr();
        if (r3 == null) goto L14;
        j1 r4 = r3.Y3();
        if (r4 == null) goto L14;
        ChatDraftItem r5 = r4.d();
    L15:
        if (r5 != null) goto L24;
        FLogger.a.i("SuggestedActionComponent", "remove invalid sug draft without nested-file/file/image draft");
        String r6 = r2.getKey();
        if (r6 == null) goto L19;
        C3().c(r6, null);
    L19:
        p1 r7 = cr();
        if (r7 == null) goto L24;
        j1 r8 = r7.Y3();
        if (r8 == null) goto L24;
        r8.h();
    L14:
        r5 = null;
    L24:
        ICoreInputAbility r9 = B3();
        boolean r10 = false;
        if (r9 != null) goto L27;
    L29:
        if (r10 == true) goto L32;
        Lazy r11 = com.larus.bmhome.chat.camera.command.v.a;
        ((LinkedHashMap) com.larus.bmhome.chat.camera.command.v.b).clear();
        return;
    L32:
        return;
    L27:
        if (r9.c1() != true) goto L29;
        r10 = true;
    L7:
        r2 = null;
        goto L8
    }

    @Override // bc8.a
    public final SuggestedActionBar JU() {
        return this.B;
    }

    public final int U2() {
        return this.m;
    }

    public final void onCreate() {
        D3();
    }

    @Override // bc8.a
    public final View y8() {
        return this.C;
    }

    public static final wc9.e Y2(SuggestedActionComponent r0) {
        y r1 = r0.u0();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.h();
    }

    public static final String h3(SuggestedActionComponent r0) {
        y r1 = r0.u0();
        if (r1 == null) goto L5;
        String r2 = r1.Y1();
    L6:
        if (r2 != null) goto L9;
        return "";
    L9:
        return r2;
    L5:
        r2 = null;
        goto L6
    }

    public static final BotModel m3(SuggestedActionComponent r0) {
        y r1 = r0.u0();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.j0();
    }

    @Override // bc8.a
    public final void G8(q0 r2) {
        C3().G8(r2);
    }

    @Override // bc8.a
    public final boolean Ge(SuggestedAction r5) {
        Intrinsics.checkNotNullParameter(r5, "action");
        return new b(this, "", SuggestedActionScene.Unknown, null).d(r5);
    }

    @Override // bc8.a
    public final void Gh(com.larus.common.venue.impl.venue.component.g r1) {
        this.y = r1;
    }

    @Override // bc8.a
    public final void Rg(String r9) {
        Intrinsics.checkNotNullParameter(r9, "prefix");
        SuggestedActionBar r1 = this.B;
        if (r1 == null) goto L26;
        Intrinsics.checkNotNullParameter(r9, "prefix");
        String r0 = r1.f;
        r1.f = r9;
        Iterator r10 = ViewGroupKt.getChildren(r1.c).iterator();
    L6:
        if (r10.hasNext() == false) goto L38;
        View r2 = (View) r10.next();
        if ((r2 instanceof ViewGroup) == false) goto L6;
        Iterator r3 = ViewGroupKt.getChildren((ViewGroup) r2).iterator();
    L11:
        if (r3.hasNext() == false) goto L6;
        View r4 = (View) r3.next();
        if ((r4 instanceof ViewGroup) == false) goto L11;
        TextView r5 = (TextView) r4.findViewById(2131387713);
        if (r5 == null) goto L11;
        String r6 = r5.getText().toString();
        if (r0.length() <= 0) goto L19;
        boolean r7 = true;
    L20:
        if (r7 == true) goto L22;
    L24:
        String r8 = StringsKt.removePrefix(r6, r1.f);
    L25:
        r5.setText(r1.f(r8));
        goto L11
    L22:
        if (StringsKt.startsWith$default(r6, r0, false, 2, null) == false) goto L24;
        r8 = StringsKt.removePrefix(r6, r0);
        goto L25
    L19:
        r7 = false;
        goto L20
    L38:
        return;
    }

    public final void X2(int r1) {
        this.m = r1;
    }

    @Override // bc8.a
    public final void nv(boolean r2) {
        if (this.E != r2) goto L5;
        return;
    L5:
        this.E = r2;
        p3(true);
    }

    public final void onViewCreated(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        g9.b r0 = new g9.b(r4);
        Intrinsics.checkNotNullParameter(r0, "finder");
        View r5 = r0.a;
        View r1 = null;
        if (r5 == null) goto L5;
        View r6 = r5.findViewById(2131375412);
    L6:
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.larus.common_ui.view.SuggestedActionBar");
        this.B = (SuggestedActionBar) r6;
        View r7 = r0.a;
        if (r7 == null) goto L9;
        r1 = r7.findViewById(2131375414);
    L9:
        this.C = r1;
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void p3(boolean r5) {
        List<UplinkFileEntity> r1 = null;
        if (this.E == true) goto L5;
        g1 r0 = f70();
        if (r0 == null) goto L22;
        r1 = r0.q1();
    L22:
        List<UplinkFileEntity> r2 = r1;
        int r3 = 0;
        if (r2 != null) goto L25;
    L28:
        boolean r4 = true;
    L30:
        if (((ArrayList) z3(this.D)).isEmpty() == false) goto L42;
        View r6 = this.C;
        if (r6 == null) goto L34;
        com.larus.utils.e1.o(r6);
    L34:
        if (r4 == false) goto L38;
        va8.o r7 = (va8.o) this.v.getValue();
        if (r7 == null) goto L38;
        r7.e10(false);
    L38:
        SuggestedActionBar r8 = this.B;
        if (r8 == null) goto L63;
        r8.b(new g(this));
        return;
    L63:
        return;
    L42:
        View r9 = this.C;
        if (r9 != null) goto L45;
    L49:
        va8.o r10 = (va8.o) this.v.getValue();
        if (r10 == null) goto L52;
        r10.e10(true);
    L52:
        if (r5 == false) goto L56;
        SuggestedActionBar r11 = this.B;
        if (r11 == null) goto L56;
        r11.g = true;
    L56:
        SuggestedActionBar r12 = this.B;
        if (r12 == null) goto L64;
        r12.c();
        return;
    L64:
        return;
    L45:
        if ((!r4) == true) goto L48;
        r3 = 8;
    L48:
        r9.setVisibility(r3);
        goto L49
    L25:
        if (r2.isEmpty() == true) goto L28;
        r4 = false;
        goto L30
    L5:
        if (mt() == false) goto L60;
        View r13 = this.C;
        if (r13 == null) goto L9;
        com.larus.utils.e1.o(r13);
    L9:
        SuggestedActionBar r14 = this.B;
        if (r14 == null) goto L12;
        r14.g = r5;
    L12:
        if (r14 == null) goto L14;
        int r15 = SuggestedActionBar.t;
        r14.b(null);
    L14:
        if (r5 == false) goto L61;
        SuggestedActionBar r16 = this.B;
        if (r16 == null) goto L62;
        r16.requestLayout();
        return;
    L62:
        return;
    L61:
        return;
    }

    public final List<SuggestedActionBar.c> z3(List<SuggestedAction> r11) {
        List<SuggestedAction> r12 = r11;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L14;
        SuggestedAction r1 = (SuggestedAction) r13.next();
        String r2 = r1.getSuggestedActionKey();
        if (r2 != null) goto L8;
        String r4 = "";
    L9:
        int r5 = r1.getRow();
        String r3 = r1.getDisplayName();
        if (r3 != null) goto L12;
        String r6 = "";
    L13:
        r0.add(new SuggestedActionBar.c(r4, r5, r6, r1.getDisplayHighlight(), Intrinsics.areEqual(r1.getSuggestedActionKey(), SuggestedActionKey.Loading.getValue()), 224));
        goto L4
    L12:
        r6 = r3;
        goto L13
    L8:
        r4 = r2;
        goto L9
    L14:
        ArrayList r14 = new ArrayList();
        Iterator r7 = r0.iterator();
    L16:
        if (r7.hasNext() == false) goto L23;
        Object r8 = r7.next();
        SuggestedActionBar.c r9 = (SuggestedActionBar.c) r8;
        IFlowSdkDepend r10 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r10 == null) goto L21;
        r10.v();
    L21:
        if ((!CollectionsKt.emptyList().contains(r9.a)) == false) goto L16;
        r14.add(r8);
        goto L16
    L23:
        return r14;
    }

    @Override // bc8.a
    public final void kC(String r4, iq9.e r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "bizScene");
        FLogger.a.i("SuggestedActionComponent", "setSuggestedActionOperations[" + r4 + "] suggestedActionOperations = " + r5 + ", updateDraft = " + r6);
        C3().c(r4, r5);
        if (r6 == false) goto L26;
        Gson r7 = (Gson) this.z.getValue();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Object r8 = Result.constructor-impl(r7.toJson(r5));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r8) == false) goto L13;
        r8 = null;
    L13:
        String r9 = (String) r8;
        if (r9 == null) goto L23;
        p1 r10 = cr();
        if (r10 == null) goto L24;
        j1 r11 = r10.Y3();
        if (r11 == null) goto L25;
        r11.t(r4, r9);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L8:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // bc8.a
    public final List<SuggestedAction> r4(SuggestedActionScene r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "bizScene");
        if (C3() != com.larus.bmhome.chat.camera.command.s.a) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return CollectionsKt.emptyList();
    L10:
        return C3().r4(r3, r4, r5);
    L5:
        r0 = false;
        goto L6
    }

    @Override // bc8.a
    public final void r40(SuggestedActionScene r17, String r18, List<SuggestedAction> r19, Set<String> r20) {
        Intrinsics.checkNotNullParameter(r17, "scene");
        Intrinsics.checkNotNullParameter(r18, "bizScene");
        Intrinsics.checkNotNullParameter(r19, "actions");
        Intrinsics.checkNotNullParameter(r20, "removeActionKeys");
        if (E3() == false) goto L5;
        return;
    L5:
        ArrayList r7 = new ArrayList();
        Iterator<T> r6 = r19.iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        String r8 = ((SuggestedAction) r6.next()).getSuggestedActionKey();
        if (r8 == null) goto L7;
        r7.add(r8);
        goto L7
    L11:
        Set r9 = CollectionsKt.toSet(r7);
        List<SuggestedAction> r10 = r19;
        List<SuggestedAction> r11 = this.D;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L12:
        boolean r14 = true;
        if (r13.hasNext() == false) goto L22;
        Object r15 = r13.next();
        SuggestedAction r16 = (SuggestedAction) r15;
        if (CollectionsKt.contains(r20, r16.getSuggestedActionKey()) == false) goto L17;
    L20:
        if (r14 == true) goto L12;
        r12.add(r15);
        goto L12
    L17:
        if (CollectionsKt.contains(r9, r16.getSuggestedActionKey()) == true) goto L20;
        r14 = false;
        goto L20
    L22:
        List<SuggestedAction> r21 = CollectionsKt.plus(r10, r12);
        this.D = r21;
        b r22 = new b(this, r18, r17, r21);
        SuggestedActionBar r2 = this.B;
        if (r2 == null) goto L28;
        List<SuggestedActionBar.c> r23 = z3(r19);
        int r1 = SuggestedActionBar.t;
        Intrinsics.checkNotNullParameter(r23, "items");
        Intrinsics.checkNotNullParameter(r20, "removeActionKeys");
        r2.q = r22;
        int r3 = r2.r + 1;
        r2.r = r3;
        if (r2.c.isLayoutRequested() == false) goto L27;
        r2.c.addOnLayoutChangeListener(new z(r2, r3, r23, r20, null));
        goto L28
    L27:
        r2.h(r23, r20, null);
    L28:
        p3(false);
    }

    @Override // bc8.a
    public final void YP(final SuggestedActionScene r8, final String r9, final boolean r10, List<UplinkFileEntity> r11, final boolean r12) {
        Intrinsics.checkNotNullParameter(r9, "bizScene");
        if (r8 != null) goto L6;
        return;
    L6:
        if (E3() == false) goto L8;
        return;
    L8:
        cL(r8, r9, r10, r11, new f(this, r8, r9, r10, r12));
    }

    @Override // bc8.a
    public final void Zv(SuggestedActionScene r3, String r4, List<SuggestedAction> r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "bizScene");
        Intrinsics.checkNotNullParameter(r5, "actions");
        if (E3() == false) goto L5;
        return;
    L5:
        if (r7 == false) goto L7;
        List<SuggestedActionBar.c> r0 = CollectionsKt.emptyList();
    L8:
        if (r7 == false) goto L10;
        List<SuggestedAction> r8 = CollectionsKt.emptyList();
    L11:
        this.D = r8;
        if ((!r0.isEmpty()) == true) goto L14;
    L19:
        p3(false);
        return;
    L14:
        if (r6 == false) goto L16;
        r4 = "draft";
    L16:
        b r9 = new b(this, r4, r3, r5);
        SuggestedActionBar r10 = this.B;
        if (r10 == null) goto L19;
        int r11 = SuggestedActionBar.t;
        r10.e(r0, r9, false, null);
        goto L19
    L10:
        r8 = r5;
        goto L11
    L7:
        r0 = z3(r5);
        goto L8
    }

    @Override // bc8.a
    public final void cL(SuggestedActionScene r7, String r8, boolean r9, List<UplinkFileEntity> r10, Function1<? super List<SuggestedAction>, Unit> r11) {
        Intrinsics.checkNotNullParameter(r8, "bizScene");
        Intrinsics.checkNotNullParameter(r11, "callback");
        boolean r2 = false;
        if (C3() != com.larus.bmhome.chat.camera.command.s.a) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r11.invoke(CollectionsKt.emptyList());
        return;
    L9:
        com.larus.bmhome.chat.camera.command.p r1 = C3();
        int r3 = com.larus.bmhome.chat.camera.command.m.a;
        Context r4 = getContext();
        Intrinsics.checkNotNullParameter(r4, "context");
        if (r7 != SuggestedActionScene.AttachmentAreaSingleFile) goto L39;
        if (r10 != null) goto L14;
    L16:
        boolean r5 = false;
    L17:
        if (r5 == false) goto L39;
        if (r10.size() != 1) goto L39;
        UplinkFileEntity r12 = (UplinkFileEntity) CollectionsKt.firstOrNull(r10);
        if (r12 == null) goto L39;
        HashMap r6 = FileMimeTypeUtils.a;
        Uri r13 = r12.getUri();
        if (r13 == null) goto L26;
        String r14 = r4.getContentResolver().getType(r13);
    L27:
        if (r14 != null) goto L29;
    L30:
        r2 = true;
    L31:
        if (r2 == false) goto L38;
        UplinkEntityContent r15 = r12.getUplinkEntityContent();
        if (r15 == null) goto L37;
        UplinkFileInfo r16 = r15.getUplinkFileInfo();
        if (r16 == null) goto L37;
        r14 = r16.getMimeType();
    L37:
        r14 = null;
    L38:
        String r17 = FileMimeTypeUtils.e(r14, null).getType();
    L40:
        r1.a(r7, r8, r9, r17, r11);
        return;
    L29:
        if (r14.length() != 0) goto L31;
    L26:
        r14 = null;
        goto L27
    L14:
        if ((!r10.isEmpty()) != true) goto L16;
        r5 = true;
    L39:
        r17 = null;
        goto L40
    L5:
        r0 = false;
        goto L6
    }
}
