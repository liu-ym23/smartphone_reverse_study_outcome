package com.larus.bot.impl.feature.edit;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.larus.bmhome.auth.BgImageAbParam;
import com.larus.bmhome.auth.BgImageConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.bot.impl.bean.BotEditParam;
import com.larus.bot.impl.bean.ContentType;
import com.larus.bot.impl.feature.edit.feature.autofill.BotAutoFillViewModel;
import com.larus.bot.impl.feature.edit.feature.avatar.BotAvatarEditViewModel;
import com.larus.bot.impl.feature.edit.feature.bgimage.BotBgImageEditViewModel;
import com.larus.bot.impl.feature.edit.feature.bio.BotBioEditViewModel;
import com.larus.bot.impl.feature.edit.feature.firstmet.BotFirstMetEditViewModel;
import com.larus.bot.impl.repository.UgcBotRepo;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotCreateParam;
import com.larus.im.bean.bot.CreationIdInfo;
import com.larus.im.bean.bot.FirstMet;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.service.z2;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000Æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 Ó\u00012\u00020\u0001:\u0002Ó\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010=\u001a\u00020 J\u000e\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020\rJ\b\u0010z\u001a\u00020xH\u0002J\u001a\u0010{\u001a\u0016\u0012\u0004\u0012\u00020 \u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010 0}0|J\b\u0010~\u001a\u0004\u0018\u00010\u007fJ\u0007\u0010\u0080\u0001\u001a\u00020\rJ\u0007\u0010\u0081\u0001\u001a\u00020\rJ\u0007\u0010\u0082\u0001\u001a\u000208J\u0007\u0010\u0083\u0001\u001a\u00020\rJ\u0007\u0010\u0084\u0001\u001a\u00020\rJ\u0007\u0010\u0085\u0001\u001a\u00020\rJ\u0007\u0010\u0086\u0001\u001a\u00020\rJ\u001c\u0010\u0087\u0001\u001a\u00020x2\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\t\b\u0002\u0010\u008a\u0001\u001a\u00020\rJ\u0010\u0010\u008b\u0001\u001a\u00020x2\u0007\u0010\u008c\u0001\u001a\u00020\rJ\u0007\u0010\u008d\u0001\u001a\u00020xJ\u0019\u0010\u008e\u0001\u001a\u00020\r2\u0007\u0010\u008f\u0001\u001a\u00020\r2\u0007\u0010\u0090\u0001\u001a\u00020\rJ\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001J0\u0010\u0093\u0001\u001a\u00020\u00122\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\t\b\u0002\u0010\u0096\u0001\u001a\u0002082\t\b\u0002\u0010\u0097\u0001\u001a\u000208H\u0082@¢\u0006\u0003\u0010\u0098\u0001J\u0007\u0010\u0099\u0001\u001a\u00020xJ\u0007\u0010\u009a\u0001\u001a\u00020xJ\b\u0010\u009b\u0001\u001a\u00030\u0095\u0001J\u001c\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u00012\u0007\u0010\u009e\u0001\u001a\u00020 H\u0086@¢\u0006\u0003\u0010\u009f\u0001J\u0007\u0010 \u0001\u001a\u00020\rJ\u0019\u0010¡\u0001\u001a\u00020x2\u0007\u0010¢\u0001\u001a\u00020 2\u0007\u0010£\u0001\u001a\u00020 J\u0010\u0010¤\u0001\u001a\u00020x2\u0007\u0010¥\u0001\u001a\u00020 J\u0010\u0010¦\u0001\u001a\u00020x2\u0007\u0010§\u0001\u001a\u00020 J\u0010\u0010¨\u0001\u001a\u00020x2\u0007\u0010©\u0001\u001a\u00020 J\u0010\u0010ª\u0001\u001a\u00020x2\u0007\u0010«\u0001\u001a\u00020 J#\u0010¬\u0001\u001a\u00020x2\u001a\u0010\u00ad\u0001\u001a\u0015\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0®\u0001J\u0010\u0010¯\u0001\u001a\u00020x2\u0007\u0010°\u0001\u001a\u00020\rJ\u001e\u0010±\u0001\u001a\u00020x2\n\u0010²\u0001\u001a\u0005\u0018\u00010³\u00012\t\b\u0002\u0010´\u0001\u001a\u00020\rJ\u0013\u0010µ\u0001\u001a\u00020x2\n\u0010¶\u0001\u001a\u0005\u0018\u00010·\u0001J\u0010\u0010¸\u0001\u001a\u00020x2\u0007\u0010¹\u0001\u001a\u00020\rJ\u0012\u0010º\u0001\u001a\u00020x2\t\u0010»\u0001\u001a\u0004\u0018\u00010 J\u0012\u0010¼\u0001\u001a\u00020x2\t\u0010½\u0001\u001a\u0004\u0018\u00010 J\u0011\u0010¾\u0001\u001a\u00020x2\b\u0010¿\u0001\u001a\u00030À\u0001J\u0010\u0010Á\u0001\u001a\u00020x2\u0007\u0010Â\u0001\u001a\u00020 J\u0010\u0010Ã\u0001\u001a\u00020x2\u0007\u0010Ä\u0001\u001a\u00020 J\u0012\u0010Å\u0001\u001a\u00020x2\t\u0010£\u0001\u001a\u0004\u0018\u00010 J\u0012\u0010Æ\u0001\u001a\u00020x2\t\u0010£\u0001\u001a\u0004\u0018\u00010 J\u0012\u0010Ç\u0001\u001a\u00020x2\t\u0010£\u0001\u001a\u0004\u0018\u00010 J\u0010\u0010È\u0001\u001a\u00020x2\u0007\u0010É\u0001\u001a\u00020\rJ\u0010\u0010Ê\u0001\u001a\u00020x2\u0007\u0010É\u0001\u001a\u00020\rJ\t\u0010Ë\u0001\u001a\u00020xH\u0002J\u0007\u0010Ì\u0001\u001a\u00020xJ\u0007\u0010Í\u0001\u001a\u000208J\u0007\u0010Î\u0001\u001a\u00020xJ\u0007\u0010Ï\u0001\u001a\u00020xJ\b\u0010Ð\u0001\u001a\u00030Ñ\u0001J\u0007\u0010Ò\u0001\u001a\u00020\rR\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00148F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00148F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010/\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u00103\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001a\u00107\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u000e\u0010C\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010F\u001a\u00020G¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u001b\u0010J\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\u000b\u001a\u0004\bL\u0010MR\u0011\u0010O\u001a\u00020P8F¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u001b\u0010S\u001a\u00020T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\u000b\u001a\u0004\bU\u0010VR\u0011\u0010X\u001a\u00020Y8F¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u001b\u0010\\\u001a\u00020]8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\u000b\u001a\u0004\b^\u0010_R\u001b\u0010a\u001a\u00020b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010\u000b\u001a\u0004\bc\u0010dR\u0011\u0010f\u001a\u00020g8F¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0011\u0010j\u001a\u00020k8F¢\u0006\u0006\u001a\u0004\bl\u0010mR\u001b\u0010n\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010\u000b\u001a\u0004\bp\u0010qR\u0011\u0010s\u001a\u00020t8F¢\u0006\u0006\u001a\u0004\bu\u0010v¨\u0006Ô\u0001"}, d2 = {"Lcom/larus/bot/impl/feature/edit/BotCreateViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "bgImageAbParam", "Lcom/larus/bmhome/auth/BgImageAbParam;", "getBgImageAbParam", "()Lcom/larus/bmhome/auth/BgImageAbParam;", "bgImageAbParam$delegate", "Lkotlin/Lazy;", "canAddBgImage", "", "getCanAddBgImage", "()Z", "_createResult", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/bmhome/bot/bean/BotInfoUpdateResult;", "createResult", "Landroidx/lifecycle/LiveData;", "getCreateResult", "()Landroidx/lifecycle/LiveData;", "_descPolishBtnStatus", "Lcom/larus/bot/impl/feature/edit/DescPolishBtnStatus;", "descPolishBtnStatus", "getDescPolishBtnStatus", "_descPolishStatus", "Lcom/larus/bot/impl/feature/edit/DescPolishStatus;", "descPolishStatus", "getDescPolishStatus", "lastDesc", "", "isPolishUndo", "setPolishUndo", "(Z)V", "_ready", "Lkotlinx/coroutines/flow/MutableStateFlow;", "ready", "Lkotlinx/coroutines/flow/StateFlow;", "getReady", "()Lkotlinx/coroutines/flow/StateFlow;", "editParam", "Lcom/larus/bot/impl/bean/BotEditParam;", "getEditParam", "()Lcom/larus/bot/impl/bean/BotEditParam;", "initParam", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "botCreateTrace", "Lcom/larus/bot/impl/feature/edit/trace/BotCreateTrace;", "getBotCreateTrace", "()Lcom/larus/bot/impl/feature/edit/trace/BotCreateTrace;", "privateStatus", "", "getPrivateStatus", "()I", "setPrivateStatus", "(I)V", "getPrivateStatusString", "uiEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/bot/impl/feature/edit/BotCreateUIEvent;", "getUiEvent", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "createCount", "_mainModel", "Lcom/larus/bot/impl/feature/edit/feature/main/IBotMainModel;", "mainEditViewModel", "Lcom/larus/bot/impl/feature/edit/feature/main/IBotMainEditViewModel;", "getMainEditViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/main/IBotMainEditViewModel;", "_avatarModel", "Lcom/larus/bot/impl/feature/edit/feature/avatar/IAvatarModel;", "get_avatarModel", "()Lcom/larus/bot/impl/feature/edit/feature/avatar/IAvatarModel;", "_avatarModel$delegate", "avatarEditModel", "Lcom/larus/bot/impl/feature/edit/feature/avatar/IBotAvatarEditViewModel;", "getAvatarEditModel", "()Lcom/larus/bot/impl/feature/edit/feature/avatar/IBotAvatarEditViewModel;", "_bgImageModel", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/IBgImageModel;", "get_bgImageModel", "()Lcom/larus/bot/impl/feature/edit/feature/bgimage/IBgImageModel;", "_bgImageModel$delegate", "bgImageEditViewModel", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/IBotBgImageEditViewModel;", "getBgImageEditViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/bgimage/IBotBgImageEditViewModel;", "_firstMetModel", "Lcom/larus/bot/impl/feature/edit/feature/firstmet/IFirstMetModel;", "get_firstMetModel", "()Lcom/larus/bot/impl/feature/edit/feature/firstmet/IFirstMetModel;", "_firstMetModel$delegate", "_bioModel", "Lcom/larus/bot/impl/feature/edit/feature/bio/IBioModel;", "get_bioModel", "()Lcom/larus/bot/impl/feature/edit/feature/bio/IBioModel;", "_bioModel$delegate", "firstMetEditViewModel", "Lcom/larus/bot/impl/feature/edit/feature/firstmet/IFirstMetEditViewModel;", "getFirstMetEditViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/firstmet/IFirstMetEditViewModel;", "bioEditViewModel", "Lcom/larus/bot/impl/feature/edit/feature/bio/IBioEditViewModel;", "getBioEditViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/bio/IBioEditViewModel;", "_autoFillModel", "Lcom/larus/bot/impl/feature/edit/feature/autofill/model/IAutoFillModel;", "get_autoFillModel", "()Lcom/larus/bot/impl/feature/edit/feature/autofill/model/IAutoFillModel;", "_autoFillModel$delegate", "autoFillViewModel", "Lcom/larus/bot/impl/feature/edit/feature/autofill/IBotAutoFillViewModel;", "getAutoFillViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/autofill/IBotAutoFillViewModel;", "updateAutoPlayState", "", "autoPlay", "tryCreateBot", "getLatestAutoFilledBotEnrichData", "", "", "getLatestAutoFilledBotAvatarData", "Lcom/larus/bot/impl/feature/edit/feature/autofill/model/AvatarAndBgImageData;", "hasUsedAutoFill", "hasUsedPolishDesc", "getPolishCnt", "polishUseInternet", "autoFillUseInternet", "inRequireBotEnrich", "inRequireBotAvatar", "onBotInfoChanged", "editContent", "Lcom/larus/bot/impl/bean/ContentType;", "isUserEdit", "refreshAvatarLoading", "loading", "refreshAvatar", "checkUserEdited", "checkFirstMet", "checkBio", "create", "Lkotlinx/coroutines/Job;", "requireCreateBot", "param", "Lcom/larus/im/bean/bot/BotCreateParam;", "curRetryCount", "maxRetryCount", "(Lcom/larus/im/bean/bot/BotCreateParam;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireBotPolishDesc", "botPolishDescUndo", "getBotCreateParam", "createBotConversation", "Lcom/larus/im/bean/conversation/Conversation;", "botId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "interceptDoFinish", "updateIconUri", ShareType.URL, "uri", "updateName", "name", "updateDescription", "description", "updatePrologue", "prologue", "updateBio", "bio", "updateSuggests", "suggests", "Lkotlin/Triple;", "updateSuggestSwitch", ItemStyle.ITEM_STYLE_SWITCH, "updateVoice", "speakerVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "fromActivityResult", "updateLanguage", "language", "Lcom/larus/bmhome/bot/bean/BotLanguage;", "updateUsedAutoFill", "used", "updateAvatarPrompt", "avatarPrompt", "updateAvatarPromptForEnrich", "prompt", "updateBgImage", "bgImage", "Lcom/larus/im/bean/bot/BgImage;", "updateUserBotGender", "gender", "updateUserBotType", "type", "updateOriginalUserImgUri", "updateOriginalAvatarImgUri", "updateOriginalBackgroundImgUri", "updateGenPic", "enable", "updateWebSearch", "checkCreateParam", "reset", "defaultPrivateStatus", "onCreateSuccess", "onBackPage", "getFirstMetData", "Lcom/larus/im/bean/bot/FirstMet;", "isFirstMetEditedAfterAutoGen", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotCreateViewModel extends AndroidViewModel {
    public static final a Companion = null;
    private static final String TAG = "BotCreateViewModel";
    private final Lazy _autoFillModel$delegate;
    private final Lazy _avatarModel$delegate;
    private final Lazy _bgImageModel$delegate;
    private final Lazy _bioModel$delegate;
    private final MutableLiveData<ub8.b> _createResult;
    private final MutableLiveData<DescPolishBtnStatus> _descPolishBtnStatus;
    private final MutableLiveData<DescPolishStatus> _descPolishStatus;
    private final Lazy _firstMetModel$delegate;
    private final com.larus.bot.impl.feature.edit.feature.main.d _mainModel;
    private final kotlinx.coroutines.flow.z0<Boolean> _ready;
    private final Bundle arguments;
    private final Lazy bgImageAbParam$delegate;
    private final dv8.b botCreateTrace;
    private final boolean canAddBgImage;
    private int createCount;
    private final BotEditParam editParam;
    private final BotEditParam initParam;
    private boolean isPolishUndo;
    private String lastDesc;
    private final com.larus.bot.impl.feature.edit.feature.main.c mainEditViewModel;
    private int privateStatus;
    private final kotlinx.coroutines.flow.i1<Boolean> ready;
    private final MutableSharedFlow<e0> uiEvent;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.larus.bot.impl.feature.edit.feature.avatar.s {
        public final BotEditParam a;
        public final /* synthetic */ BotCreateViewModel b;

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final int getScene() {
            return 0;
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final BotEditParam a() {
            return this.a;
        }

        public b(BotCreateViewModel r1) {
            this.b = r1;
            this.a = r1.getEditParam();
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void b(boolean r2) {
            BotCreateViewModel.access$get_mainModel$p(this.b).b(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void c(boolean r3) {
            if (r3 == true) goto L5;
            BotCreateViewModel.access$get_autoFillModel(this.b).c(ContentType.HEAD_IMG_PROMPT, true);
            return;
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void h(String r2) {
            this.b.updateAvatarPrompt(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void m(String r2) {
            this.b.updateAvatarPromptForEnrich(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void k(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, ShareType.URL);
            Intrinsics.checkNotNullParameter(r3, "uri");
            this.b.updateIconUri(r2, r3);
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.BotCreateViewModel$botPolishDescUndo$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.BotCreateViewModel$botPolishDescUndo$1", f = "BotCreateViewModel.kt", i = {}, l = {457}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BotCreateViewModel this$0;

        public AnonymousClass1(BotCreateViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            this.this$0.setPolishUndo(true);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            MutableSharedFlow<e0> r7 = this.this$0.getUiEvent();
            e0.b r2 = new e0.b(new wu8.c.C0140c(BotCreateViewModel.access$getLastDesc$p(this.this$0)));
            this.label = 1;
            if (r7.emit(r2, this) != r0) goto L11;
            return r0;
        }
    }

    public static final class c implements com.larus.bot.impl.feature.edit.feature.bgimage.s {
        public final BotEditParam a;
        public final /* synthetic */ BotCreateViewModel b;

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final int getScene() {
            return 0;
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
        public final Map<String, List<String>> g() {
            return BotCreateViewModel.access$get_autoFillModel(this.b).i();
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final BotEditParam a() {
            return this.a;
        }

        public c(BotCreateViewModel r1) {
            this.b = r1;
            this.a = r1.getEditParam();
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void b(boolean r2) {
            BotCreateViewModel.access$get_mainModel$p(this.b).b(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void c(boolean r3) {
            if (r3 == true) goto L5;
            BotCreateViewModel.access$get_autoFillModel(this.b).c(ContentType.HEAD_IMG_PROMPT, true);
            return;
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
        public final void e(String r2) {
            Intrinsics.checkNotNullParameter(r2, "type");
            this.b.updateUserBotType(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
        public final void f(String r2) {
            this.b.updateOriginalAvatarImgUri(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void h(String r2) {
            this.b.updateAvatarPrompt(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
        public final void j(String r2) {
            this.b.updateOriginalUserImgUri(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
        public final void l(String r2) {
            Intrinsics.checkNotNullParameter(r2, "gender");
            this.b.updateUserBotGender(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void m(String r2) {
            this.b.updateAvatarPromptForEnrich(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
        public final void n(BgImage r2) {
            Intrinsics.checkNotNullParameter(r2, "bgImage");
            this.b.updateBgImage(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
        public final void p(String r2) {
            this.b.updateOriginalBackgroundImgUri(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void k(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, ShareType.URL);
            Intrinsics.checkNotNullParameter(r3, "uri");
            this.b.updateIconUri(r2, r3);
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.BotCreateViewModel$create$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.BotCreateViewModel$create$1", f = "BotCreateViewModel.kt", i = {}, l = {416, 423}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BotCreateViewModel this$0;

        public C01991(BotCreateViewModel r1, Continuation<? super C01991> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01991(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r6);
        L22:
            MutableLiveData r2 = BotCreateViewModel.access$get_createResult$p(this.this$0);
            r2.postValue((ub8.b) r6);
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);
        L16:
            if (((Boolean) r6).booleanValue() == false) goto L19;
            BotCreateViewModel.access$get_mainModel$p(this.this$0).b(false);
            FLogger.a.e(BotCreateViewModel.TAG, "interceptCreateProcess by bgImageModel");
            return Unit.INSTANCE;
        L19:
            qu8.b.e("bot_create_complete_first_frame", "bot_create", true);
            qu8.b.e("bot_create/create", "bot_create_complete_first_frame", false);
            BotCreateViewModel r7 = this.this$0;
            BotCreateParam r3 = r7.getBotCreateParam();
            e10 r4 = e10.a;
            int r5 = e10.F();
            this.label = 2;
            r6 = BotCreateViewModel.access$requireCreateBot(r7, r3, 0, r5, this);
            if (r6 != r0) goto L22;
            return r0;
        L10:
            ResultKt.throwOnFailure(r6);
            if (this.this$0.getCanAddBgImage() == false) goto L19;
            com.larus.bot.impl.feature.edit.feature.bgimage.t r8 = BotCreateViewModel.access$get_bgImageModel(this.this$0);
            this.label = 1;
            r6 = r8.i(this);
            if (r6 != r0) goto L16;
            return r0;
        }
    }

    public static final class d implements com.larus.bot.impl.feature.edit.feature.bio.h {
        public final BotEditParam a;
        public final /* synthetic */ BotCreateViewModel b;

        @Override // com.larus.bot.impl.feature.edit.feature.bio.h
        public final boolean c() {
            return true;
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bio.h
        public final BotEditParam a() {
            return this.a;
        }

        public d(BotCreateViewModel r1) {
            this.b = r1;
            this.a = r1.getEditParam();
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bio.h
        public final void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "bio");
            this.b.updateBio(r2);
        }
    }

    public static final class e implements com.larus.bot.impl.feature.edit.feature.firstmet.o {
        public final BotEditParam a;
        public final /* synthetic */ BotCreateViewModel b;

        @Override // com.larus.bot.impl.feature.edit.feature.firstmet.o
        public final boolean d() {
            return true;
        }

        @Override // com.larus.bot.impl.feature.edit.feature.firstmet.o
        public final int getScene() {
            return 0;
        }

        @Override // com.larus.bot.impl.feature.edit.feature.firstmet.o
        public final BotEditParam a() {
            return this.a;
        }

        public e(BotCreateViewModel r1) {
            this.b = r1;
            this.a = r1.getEditParam();
        }

        @Override // com.larus.bot.impl.feature.edit.feature.firstmet.o
        public final void b(boolean r2) {
            this.b.updateSuggestSwitch(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.firstmet.o
        public final void c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "prologue");
            this.b.updatePrologue(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.firstmet.o
        public final void e(Triple<String, String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "suggests");
            this.b.updateSuggests(r2);
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.BotCreateViewModel$requireCreateBot$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.BotCreateViewModel", f = "BotCreateViewModel.kt", i = {0, 0, 0}, l = {433, 435}, m = "requireCreateBot", n = {"param", "curRetryCount", "maxRetryCount"}, s = {"L$0", "I$0", "I$1"})
    public static final class C02001 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BotCreateViewModel this$0;

        public C02001(BotCreateViewModel r1, Continuation<? super C02001> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return BotCreateViewModel.access$requireCreateBot(this.this$0, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.BotCreateViewModel$tryCreateBot$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.BotCreateViewModel$tryCreateBot$1", f = "BotCreateViewModel.kt", i = {}, l = {346}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BotCreateViewModel this$0;

        public C02011(BotCreateViewModel r1, Continuation<? super C02011> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02011(this.this$0, r3);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            MutableSharedFlow<e0> r5 = this.this$0.getUiEvent();
            e0.c r2 = e0.c.a;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ BgImageAbParam Mo() {
        return bgImageAbParam_delegate$lambda$0();
    }

    public static /* synthetic */ BotBgImageEditViewModel No(BotCreateViewModel r0) {
        return _bgImageModel_delegate$lambda$3(r0);
    }

    public static /* synthetic */ BotAvatarEditViewModel Oo(Application r0, BotCreateViewModel r1) {
        return _avatarModel_delegate$lambda$2(r0, r1);
    }

    public static /* synthetic */ BotBioEditViewModel Po(BotCreateViewModel r0) {
        return _bioModel_delegate$lambda$5(r0);
    }

    public static /* synthetic */ BotFirstMetEditViewModel Qo(BotCreateViewModel r0) {
        return _firstMetModel_delegate$lambda$4(r0);
    }

    public static /* synthetic */ BotAutoFillViewModel yo(BotCreateViewModel r0) {
        return _autoFillModel_delegate$lambda$6(r0);
    }

    private static final BgImageAbParam bgImageAbParam_delegate$lambda$0() {
        LaunchInfo r0 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r0 == null) goto L7;
        BgImageConfig r1 = r0.h();
        if (r1 == null) goto L7;
        return r1.a();
    L7:
        return null;
    }

    private final void checkCreateParam() {
        kotlinx.coroutines.flow.z0<Boolean> r0 = this._ready;
        int r1 = this.editParam.getName().length();
        boolean r2 = false;
        if (1 <= r1) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L10;
    L12:
        boolean r4 = false;
    L13:
        r0.setValue(Boolean.valueOf(r4));
        MutableLiveData<DescPolishBtnStatus> r5 = this._descPolishBtnStatus;
        if (this.editParam.getDescription().length() <= 0) goto L16;
        r2 = true;
    L16:
        if (r2 == true) goto L18;
    L22:
        DescPolishBtnStatus r6 = DescPolishBtnStatus.DISABLE;
    L23:
        r5.postValue(r6);
        return;
    L18:
        if ((!StringsKt.isBlank(this.editParam.getDescription())) == false) goto L22;
        if (get_autoFillModel().s().a() == true) goto L22;
        r6 = DescPolishBtnStatus.ENABLE;
        goto L23
    L10:
        if (get_autoFillModel().s().a() == true) goto L12;
        r4 = true;
        goto L13
    L5:
        if (r1 >= 41) goto L7;
        r3 = true;
        goto L8
    }

    private final BgImageAbParam getBgImageAbParam() {
        return (BgImageAbParam) this.bgImageAbParam$delegate.getValue();
    }

    private final wu8.f get_autoFillModel() {
        return (wu8.f) this._autoFillModel$delegate.getValue();
    }

    private final com.larus.bot.impl.feature.edit.feature.avatar.t get_avatarModel() {
        return (com.larus.bot.impl.feature.edit.feature.avatar.t) this._avatarModel$delegate.getValue();
    }

    private final com.larus.bot.impl.feature.edit.feature.bgimage.t get_bgImageModel() {
        return (com.larus.bot.impl.feature.edit.feature.bgimage.t) this._bgImageModel$delegate.getValue();
    }

    private final com.larus.bot.impl.feature.edit.feature.bio.j get_bioModel() {
        return (com.larus.bot.impl.feature.edit.feature.bio.j) this._bioModel$delegate.getValue();
    }

    private final com.larus.bot.impl.feature.edit.feature.firstmet.q get_firstMetModel() {
        return (com.larus.bot.impl.feature.edit.feature.firstmet.q) this._firstMetModel$delegate.getValue();
    }

    public final void botPolishDescUndo() {
        FLogger.a.d(TAG, "botPolishDescUndo, lastDesc = " + this.lastDesc);
        this._descPolishBtnStatus.postValue(DescPolishBtnStatus.ENABLE);
        this._descPolishStatus.postValue(DescPolishStatus.BEFORE_POLISH);
        updateDescription(this.lastDesc);
        getAutoFillViewModel().dispatchUIAction(com.larus.bot.impl.feature.edit.feature.autofill.a.d.a);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain().getImmediate(), null, new AnonymousClass1(this, null), 2, null);
    }

    public final int defaultPrivateStatus() {
        if (z2.a.x3().getShouldDefaultCreatePrivate() == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    public final BotCreateParam getBotCreateParam() {
        String r2 = this.editParam.getName();
        String r3 = this.editParam.getDescription();
        String r4 = this.editParam.getIconUri();
        int r5 = this.privateStatus;
        SpeakerVoice r1 = this.editParam.getVoice();
        if (r1 == null) goto L6;
        String r6 = r1.getId();
        if (r6 == null) goto L6;
    L7:
        String r7 = r6;
        SpeakerVoice r8 = this.editParam.getVoice();
        if (r8 == null) goto L13;
        String r9 = r8.getLanguageCode();
        if (r9 == null) goto L13;
    L12:
        String r10 = r9;
        SpeakerVoice r11 = this.editParam.getVoice();
        if (r11 == null) goto L22;
        boolean r12 = r11.isUgcVoice();
    L23:
        boolean r13 = this.editParam.getHasUsedAutoFill();
        Boolean r14 = this.editParam.getEnableWebSearch();
        Boolean r15 = this.editParam.getEnableGenPic();
        FirstMet r16 = get_firstMetModel().getFirstMetData();
        dv8.b r17 = this.botCreateTrace;
        List<String> r18 = r17.a.getLatestAutoFilledBotEnrichData().get(ContentType.NAME.getValue());
        if (r18 == null) goto L26;
        String r19 = (String) CollectionsKt.firstOrNull(r18);
    L28:
        if (Intrinsics.areEqual(r19, r17.a.getEditParam().getName()) == false) goto L45;
        List<String> r20 = r17.a.getLatestAutoFilledBotEnrichData().get(ContentType.DESC.getValue());
        if (r20 == null) goto L32;
        String r21 = (String) CollectionsKt.firstOrNull(r20);
    L34:
        if (Intrinsics.areEqual(r21, r17.a.getEditParam().getDescription()) == false) goto L45;
        if (r17.a.isFirstMetEditedAfterAutoGen() == true) goto L45;
        List<String> r22 = r17.a.getLatestAutoFilledBotEnrichData().get(ContentType.BIO.getValue());
        if (r22 == null) goto L40;
        String r23 = (String) CollectionsKt.firstOrNull(r22);
    L42:
        if (Intrinsics.areEqual(r23, r17.a.getEditParam().getBio()) == false) goto L45;
        boolean r110 = false;
    L46:
        Boolean r111 = Boolean.valueOf(r110);
        String r24 = this.botCreateTrace.f;
        BgImage r25 = this.editParam.getBgImage();
        if (r25 == null) goto L49;
        String r26 = r25.bgImgUri;
    L50:
        BgImage r27 = this.editParam.getBgImage();
        if (r27 == null) goto L53;
        BgImageInfo r28 = r27.bgImageInfo;
    L54:
        String r112 = this.editParam.getUserBotGenderStarlingKey();
        String r113 = this.editParam.getUserBotTypeStarlingKey();
        String r29 = this.editParam.getOriginalUserImgUri();
        String r210 = get_bioModel().R();
        String r30 = this.botCreateTrace.d();
        int r31 = this.createCount + 1;
        this.createCount = r31;
        boolean r32 = r12;
        String r114 = r26;
        BgImageInfo r115 = r28;
        return new BotCreateParam(r2, r3, r4, r5, r7, false, r10, r32, r13, r14, r15, r16, r111, r24, r114, r115, r112, r113, r29, r210, new CreationIdInfo(r30, Integer.valueOf(r31)));
    L53:
        r28 = null;
        goto L54
    L49:
        r26 = null;
        goto L50
    L40:
        r23 = null;
        goto L42
    L32:
        r21 = null;
    L45:
        r110 = true;
        goto L46
    L26:
        r19 = null;
        goto L28
    L22:
        r12 = false;
    L13:
        BotLanguage r33 = this.editParam.getLanguage();
        if (r33 == null) goto L16;
        r9 = r33.c();
    L17:
        if (r9 != null) goto L12;
        r9 = "";
        goto L12
    L16:
        r9 = null;
    L6:
        r6 = TriggerSendLoading.NO_LOADING;
        goto L7
    }

    public final String getPrivateStatusString() {
        int r0 = this.privateStatus;
        if (r0 != 1) goto L5;
        return "public";
    L5:
        if (r0 == 2) goto L7;
        return "not_seen";
    L7:
        return "private";
    }

    public final void refreshAvatar() {
        if (this.canAddBgImage == false) goto L5;
        get_bgImageModel().o(this.editParam.getIconUrl(), this.editParam.getBgImage());
        return;
    L5:
        get_avatarModel().o(this.editParam.getIconUrl(), null);
    }

    public final void requireBotPolishDesc() {
        FLogger.a.d(TAG, "requireBotPolishDesc");
        this.lastDesc = this.editParam.getDescription();
        get_autoFillModel().s().c = true;
        this.isPolishUndo = false;
        checkCreateParam();
        getAutoFillViewModel().dispatchUIAction(com.larus.bot.impl.feature.edit.feature.autofill.a.c.a);
    }

    public final void reset() {
        this.editParam.reset();
        this.privateStatus = defaultPrivateStatus();
        this.botCreateTrace.b.clear();
    }

    private final void tryCreateBot() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02011(this, null), 3, null);
    }

    public final boolean autoFillUseInternet() {
        return get_autoFillModel().o();
    }

    public final Job create() {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01991(this, null), 3, null);
    }

    public final com.larus.bot.impl.feature.edit.feature.autofill.j getAutoFillViewModel() {
        wu8.f r0 = get_autoFillModel();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.bot.impl.feature.edit.feature.autofill.IBotAutoFillViewModel");
        return (com.larus.bot.impl.feature.edit.feature.autofill.j) r0;
    }

    public final com.larus.bot.impl.feature.edit.feature.avatar.v getAvatarEditModel() {
        com.larus.bot.impl.feature.edit.feature.avatar.t r0 = get_avatarModel();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.bot.impl.feature.edit.feature.avatar.IBotAvatarEditViewModel");
        return (com.larus.bot.impl.feature.edit.feature.avatar.v) r0;
    }

    public final com.larus.bot.impl.feature.edit.feature.bgimage.u getBgImageEditViewModel() {
        com.larus.bot.impl.feature.edit.feature.bgimage.t r0 = get_bgImageModel();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.bot.impl.feature.edit.feature.bgimage.IBotBgImageEditViewModel");
        return (com.larus.bot.impl.feature.edit.feature.bgimage.u) r0;
    }

    public final com.larus.bot.impl.feature.edit.feature.bio.i getBioEditViewModel() {
        return get_bioModel();
    }

    public final FirstMet getFirstMetData() {
        return get_firstMetModel().getFirstMetData();
    }

    public final com.larus.bot.impl.feature.edit.feature.firstmet.p getFirstMetEditViewModel() {
        return get_firstMetModel();
    }

    public final wu8.d getLatestAutoFilledBotAvatarData() {
        return get_autoFillModel().r();
    }

    public final Map<String, List<String>> getLatestAutoFilledBotEnrichData() {
        return get_autoFillModel().i();
    }

    public final int getPolishCnt() {
        return get_autoFillModel().d();
    }

    public final boolean hasUsedAutoFill() {
        return get_autoFillModel().k();
    }

    public final boolean hasUsedPolishDesc() {
        return get_autoFillModel().q();
    }

    public final boolean inRequireBotAvatar() {
        return get_autoFillModel().s().a;
    }

    public final boolean inRequireBotEnrich() {
        return get_autoFillModel().s().b();
    }

    public final boolean interceptDoFinish() {
        if (get_autoFillModel().e() == false) goto L6;
        return true;
    L6:
        return false;
    }

    public final boolean isFirstMetEditedAfterAutoGen() {
        return get_firstMetModel().Fk();
    }

    public final void onBackPage() {
        get_firstMetModel().onBackPage();
    }

    public final void onCreateSuccess() {
        get_firstMetModel().onCreateSuccess();
    }

    public final boolean polishUseInternet() {
        return get_autoFillModel().p();
    }

    public final Bundle getArguments() {
        return this.arguments;
    }

    public final dv8.b getBotCreateTrace() {
        return this.botCreateTrace;
    }

    public final boolean getCanAddBgImage() {
        return this.canAddBgImage;
    }

    public final LiveData<ub8.b> getCreateResult() {
        return this._createResult;
    }

    public final LiveData<DescPolishBtnStatus> getDescPolishBtnStatus() {
        return this._descPolishBtnStatus;
    }

    public final LiveData<DescPolishStatus> getDescPolishStatus() {
        return this._descPolishStatus;
    }

    public final BotEditParam getEditParam() {
        return this.editParam;
    }

    public final com.larus.bot.impl.feature.edit.feature.main.c getMainEditViewModel() {
        return this.mainEditViewModel;
    }

    public final int getPrivateStatus() {
        return this.privateStatus;
    }

    public final kotlinx.coroutines.flow.i1<Boolean> getReady() {
        return this.ready;
    }

    public final MutableSharedFlow<e0> getUiEvent() {
        return this.uiEvent;
    }

    public final boolean isPolishUndo() {
        return this.isPolishUndo;
    }

    public BotCreateViewModel(final Application r63) {
        Intrinsics.checkNotNullParameter(r63, "application");
        super(r63);
        this.bgImageAbParam$delegate = LazyKt.lazy(new f0());
        if (z2.a.chatImmerseEnable() == false) goto L10;
        BgImageAbParam r2 = getBgImageAbParam();
        if (r2 == null) goto L7;
        boolean r3 = Intrinsics.areEqual(Boolean.TRUE, r2.b());
    L8:
        if (r3 == false) goto L10;
        boolean r4 = true;
    L11:
        this.canAddBgImage = r4;
        this._createResult = new MutableLiveData();
        this._descPolishBtnStatus = new MutableLiveData();
        this._descPolishStatus = new MutableLiveData();
        this.lastDesc = "";
        StateFlowImpl r5 = kotlinx.coroutines.flow.j1.a(Boolean.FALSE);
        this._ready = r5;
        this.ready = kotlinx.coroutines.flow.e.b(r5);
        this.editParam = new BotEditParam(null, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, 33554431, null);
        this.initParam = new BotEditParam(null, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, 33554431, null);
        Bundle r6 = new Bundle();
        this.arguments = r6;
        dv8.b r7 = new dv8.b(this);
        r7.b.putAll(r6);
        this.botCreateTrace = r7;
        this.privateStatus = defaultPrivateStatus();
        this.uiEvent = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        com.larus.bot.impl.feature.edit.feature.main.b r8 = new com.larus.bot.impl.feature.edit.feature.main.b(ViewModelKt.getViewModelScope(this));
        this._mainModel = r8;
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.larus.bot.impl.feature.edit.feature.main.IBotMainEditViewModel");
        this.mainEditViewModel = r8;
        this._avatarModel$delegate = LazyKt.lazy(new g0(r63, this));
        this._bgImageModel$delegate = LazyKt.lazy(new h0(this));
        this._firstMetModel$delegate = LazyKt.lazy(new i0(this));
        this._bioModel$delegate = LazyKt.lazy(new j0(this));
        this._autoFillModel$delegate = LazyKt.lazy(new k0(this));
        return;
    L7:
        r3 = false;
    L10:
        r4 = false;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.bot.impl.feature.edit.BotCreateViewModel$_autoFillModel$2$1] */
    private static final BotAutoFillViewModel _autoFillModel_delegate$lambda$6(final BotCreateViewModel r3) {
        return new BotAutoFillViewModel(ViewModelKt.getViewModelScope(r3), new BotCreateViewModel$_autoFillModel$2$1(r3));
    }

    private static final BotBgImageEditViewModel _bgImageModel_delegate$lambda$3(BotCreateViewModel r3) {
        return new BotBgImageEditViewModel(ViewModelKt.getViewModelScope(r3), new c(r3));
    }

    private static final BotBioEditViewModel _bioModel_delegate$lambda$5(BotCreateViewModel r3) {
        return new BotBioEditViewModel(ViewModelKt.getViewModelScope(r3), new d(r3));
    }

    private static final BotFirstMetEditViewModel _firstMetModel_delegate$lambda$4(BotCreateViewModel r3) {
        return new BotFirstMetEditViewModel(ViewModelKt.getViewModelScope(r3), new e(r3));
    }

    public static final /* synthetic */ void access$checkCreateParam(BotCreateViewModel r0) {
        r0.checkCreateParam();
    }

    public static final /* synthetic */ String access$getLastDesc$p(BotCreateViewModel r0) {
        return r0.lastDesc;
    }

    public static final /* synthetic */ wu8.f access$get_autoFillModel(BotCreateViewModel r0) {
        return r0.get_autoFillModel();
    }

    public static final /* synthetic */ com.larus.bot.impl.feature.edit.feature.avatar.t access$get_avatarModel(BotCreateViewModel r0) {
        return r0.get_avatarModel();
    }

    public static final /* synthetic */ com.larus.bot.impl.feature.edit.feature.bgimage.t access$get_bgImageModel(BotCreateViewModel r0) {
        return r0.get_bgImageModel();
    }

    public static final /* synthetic */ com.larus.bot.impl.feature.edit.feature.bio.j access$get_bioModel(BotCreateViewModel r0) {
        return r0.get_bioModel();
    }

    public static final /* synthetic */ MutableLiveData access$get_createResult$p(BotCreateViewModel r0) {
        return r0._createResult;
    }

    public static final /* synthetic */ MutableLiveData access$get_descPolishBtnStatus$p(BotCreateViewModel r0) {
        return r0._descPolishBtnStatus;
    }

    public static final /* synthetic */ MutableLiveData access$get_descPolishStatus$p(BotCreateViewModel r0) {
        return r0._descPolishStatus;
    }

    public static final /* synthetic */ com.larus.bot.impl.feature.edit.feature.firstmet.q access$get_firstMetModel(BotCreateViewModel r0) {
        return r0.get_firstMetModel();
    }

    public static final /* synthetic */ com.larus.bot.impl.feature.edit.feature.main.d access$get_mainModel$p(BotCreateViewModel r0) {
        return r0._mainModel;
    }

    public static final /* synthetic */ void access$tryCreateBot(BotCreateViewModel r0) {
        r0.tryCreateBot();
    }

    public final void refreshAvatarLoading(boolean r2) {
        if (this.canAddBgImage == false) goto L5;
        get_bgImageModel().d(r2);
        return;
    L5:
        get_avatarModel().d(r2);
    }

    public final void setPolishUndo(boolean r1) {
        this.isPolishUndo = r1;
    }

    public final void setPrivateStatus(int r1) {
        this.privateStatus = r1;
    }

    public final void updateAutoPlayState(boolean r2) {
        get_firstMetModel().updateAutoPlayState(r2);
    }

    public final void updateAvatarPrompt(String r2) {
        if (r2 == null) goto L4;
        this.editParam.setAvatarPrompt(r2);
    L4:
        this.editParam.setAvatarPromptForEnrich(null);
    }

    public final void updateAvatarPromptForEnrich(String r2) {
        this.editParam.setAvatarPromptForEnrich(r2);
        this.editParam.setAvatarPrompt("");
    }

    public final void updateBgImage(BgImage r2) {
        Intrinsics.checkNotNullParameter(r2, "bgImage");
        this.editParam.setBgImage(r2);
    }

    public final void updateBio(String r2) {
        Intrinsics.checkNotNullParameter(r2, "bio");
        this.editParam.setBio(r2);
        checkCreateParam();
    }

    public final void updateDescription(String r4) {
        Intrinsics.checkNotNullParameter(r4, "description");
        this.editParam.setDescription(r4);
        checkCreateParam();
        boolean r0 = false;
        this.isPolishUndo = false;
        if (r4.length() <= 0) goto L5;
        r0 = true;
    L5:
        if (r0 == true) goto L7;
    L9:
        this._descPolishBtnStatus.postValue(DescPolishBtnStatus.DISABLE);
        this._descPolishStatus.postValue(DescPolishStatus.BEFORE_POLISH);
        return;
    L7:
        if ((!StringsKt.isBlank(r4)) == false) goto L9;
        this._descPolishBtnStatus.postValue(DescPolishBtnStatus.ENABLE);
        this._descPolishStatus.postValue(DescPolishStatus.BEFORE_POLISH);
    }

    public final void updateGenPic(boolean r2) {
        this.editParam.setEnableGenPic(Boolean.valueOf(r2));
    }

    public final void updateLanguage(BotLanguage r2) {
        this.editParam.setLanguage(r2);
        checkCreateParam();
    }

    public final void updateName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        this.editParam.setName(r2);
        checkCreateParam();
    }

    public final void updateOriginalAvatarImgUri(String r2) {
        this.editParam.setOriginalAvatarImgUri(r2);
    }

    public final void updateOriginalBackgroundImgUri(String r2) {
        this.editParam.setOriginalBackgroundImgUri(r2);
    }

    public final void updateOriginalUserImgUri(String r2) {
        this.editParam.setOriginalUserImgUri(r2);
    }

    public final void updatePrologue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "prologue");
        this.editParam.setPrologue(r2);
        checkCreateParam();
    }

    public final void updateSuggestSwitch(boolean r2) {
        this.editParam.setSuggestSwitch(Boolean.valueOf(r2));
        checkCreateParam();
    }

    public final void updateSuggests(Triple<String, String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "suggests");
        this.editParam.setSuggests(r2);
        checkCreateParam();
    }

    public final void updateUsedAutoFill(boolean r2) {
        this.editParam.setHasUsedAutoFill(r2);
        checkCreateParam();
    }

    public final void updateUserBotGender(String r2) {
        Intrinsics.checkNotNullParameter(r2, "gender");
        this.editParam.setUserBotGenderStarlingKey(r2);
    }

    public final void updateUserBotType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.editParam.setUserBotTypeStarlingKey(r2);
    }

    public final void updateWebSearch(boolean r2) {
        this.editParam.setEnableWebSearch(Boolean.valueOf(r2));
    }

    private static final BotAvatarEditViewModel _avatarModel_delegate$lambda$2(Application r3, BotCreateViewModel r4) {
        return new BotAvatarEditViewModel(r3, ViewModelKt.getViewModelScope(r4), new b(r4));
    }

    public final boolean checkUserEdited(boolean r5, boolean r6) {
        if (this.editParam.getName().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        if (this.editParam.getDescription().length() <= 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
        return true;
    L13:
        if (this.editParam.getIconUri().length() <= 0) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == true) goto L18;
    L19:
        if (r5 == false) goto L21;
        boolean r7 = get_firstMetModel().y7();
    L22:
        if (r7 == true) goto L33;
        if (r6 == false) goto L25;
        boolean r8 = get_bioModel().Ol();
    L26:
        if (r8 == true) goto L34;
        return false;
    L34:
        return true;
    L25:
        r8 = false;
        goto L26
    L33:
        return true;
    L21:
        r7 = false;
        goto L22
    L18:
        if (Intrinsics.areEqual(this.editParam.getIconUri(), this.initParam.getIconUri()) == true) goto L19;
        return true;
    L15:
        r2 = false;
        goto L16
    L10:
        r1 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public final Object createBotConversation(String r14, Continuation<? super wc9.e> r15) {
        return IConversationRepoService.a.a(RepoDispatcherDelegate.b.f(), r14, 2, null, null, false, null, null, null, null, r15, 508);
    }

    public final void onBotInfoChanged(ContentType r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "editContent");
        get_autoFillModel().c(r2, r3);
    }

    public final void updateIconUri(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, ShareType.URL);
        Intrinsics.checkNotNullParameter(r3, "uri");
        BotEditParam r0 = this.editParam;
        r0.setIconUrl(r2);
        r0.setIconUri(r3);
        checkCreateParam();
    }

    public final void updateVoice(SpeakerVoice r2, boolean r3) {
        this.editParam.setVoice(r2);
        checkCreateParam();
        if (r3 == false) goto L6;
        get_firstMetModel().ej();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [ub8.b] */
    /* JADX WARN: Type inference failed for: r12v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.lang.Object] */
    private final Object requireCreateBot(BotCreateParam r9, int r10, int r11, Continuation<? super ub8.b> r12) {
        if ((r12 instanceof C02001) == false) goto L7;
        C02001 r0 = (C02001) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        ?? r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r13);
    L30:
        return r13;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r11 = r0.I$1;
        r10 = r0.I$0;
        r9 = (BotCreateParam) r0.L$0;
        ResultKt.throwOnFailure(r13);
        ?? r14 = r13;
    L19:
        r13 = (ub8.b) r14;
        uc9.t r4 = ((ub8.b) r13).a;
        if (r4 != null) goto L22;
    L24:
        boolean r5 = false;
    L25:
        if (r5 == true) goto L30;
        if (r10 >= r11) goto L30;
        r0.L$0 = null;
        r0.label = 2;
        r13 = requireCreateBot(r9, r10 + 1, r11, r0);
        if (r13 != r2) goto L30;
        return r2;
    L22:
        if (r4.a != true) goto L24;
        r5 = true;
        goto L25
    L16:
        ResultKt.throwOnFailure(r13);
        FLogger.a.d(TAG, "requireCreateBot, curRetryCount = " + r10 + ", maxRetryCount = " + r11);
        Lazy<UgcBotRepo> r15 = UgcBotRepo.d;
        UgcBotRepo r16 = UgcBotRepo.a.a();
        r0.L$0 = r9;
        r0.I$0 = r10;
        r0.I$1 = r11;
        r0.label = 1;
        r16.getClass();
        CompletableDeferred r6 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        com.larus.im.d.a().createBot(r9, new com.larus.bot.impl.repository.f(r6, r16));
        Object r17 = r6.await(r0);
        r14 = r17;
        if (r17 != r2) goto L19;
        return r2;
    L7:
        r0 = new C02001(this, r12);
        goto L8
    }

    public static final /* synthetic */ Object access$requireCreateBot(BotCreateViewModel r0, BotCreateParam r1, int r2, int r3, Continuation r4) {
        return r0.requireCreateBot(r1, r2, r3, r4);
    }

    public static /* synthetic */ void onBotInfoChanged$default(BotCreateViewModel r0, ContentType r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.onBotInfoChanged(r1, r2);
    }

    public static /* synthetic */ void updateVoice$default(BotCreateViewModel r0, SpeakerVoice r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.updateVoice(r1, r2);
    }

    public static /* synthetic */ Object requireCreateBot$default(BotCreateViewModel r1, BotCreateParam r2, int r3, int r4, Continuation r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        return r1.requireCreateBot(r2, r3, r4, r5);
    }
}
