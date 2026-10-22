package com.larus.bot.impl.feature.edit;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.common.utility.NetworkUtils;
import com.google.gson.Gson;
import com.larus.bmhome.auth.BgImageAbParam;
import com.larus.bmhome.auth.BgImageConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.bot.impl.bean.BotEditParam;
import com.larus.bot.impl.bean.BotPolishDescResp;
import com.larus.bot.impl.bean.ContentSource;
import com.larus.bot.impl.bean.ContentType;
import com.larus.bot.impl.bean.EnrichBotData;
import com.larus.bot.impl.feature.edit.feature.autofill.model.BotEnrichParam;
import com.larus.bot.impl.feature.edit.feature.avatar.BotAvatarEditViewModel;
import com.larus.bot.impl.feature.edit.feature.bgimage.BotBgImageEditViewModel;
import com.larus.bot.impl.feature.edit.feature.bio.BotBioEditViewModel;
import com.larus.bot.impl.feature.edit.feature.firstmet.BotFirstMetEditViewModel;
import com.larus.bot.impl.repository.UgcBotRepo;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotSwitchConfInfo;
import com.larus.im.bean.bot.BotUpdateType;
import com.larus.im.bean.bot.CreationIdInfo;
import com.larus.im.bean.bot.FirstMet;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.network.http.AsyncThrowable;
import com.larus.platform.model.EditPos;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 Ì\u00012\u00020\u0001:\u0002Ì\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u00109\u001a\u00020\u0014J\u0006\u0010:\u001a\u00020\u0010J\u0006\u0010;\u001a\u00020\u0016J\u0010\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010@J\u0012\u0010\u0084\u0001\u001a\u00030\u0082\u00012\b\u0010A\u001a\u0004\u0018\u00010BJ\u001c\u0010\u0085\u0001\u001a\u00020B2\b\u0010A\u001a\u0004\u0018\u00010B2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010BJ\u0011\u0010\u0087\u0001\u001a\u00020\u00102\b\u0010A\u001a\u0004\u0018\u00010BJ\u000f\u0010\u0088\u0001\u001a\u00020\u00102\u0006\u0010A\u001a\u00020BJ#\u0010\u0089\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00140\u008a\u0001j\t\u0012\u0004\u0012\u00020\u0014`\u008b\u00012\b\u0010A\u001a\u0004\u0018\u00010BJ\u0010\u0010\b\u001a\u00030\u0082\u0001H\u0086@¢\u0006\u0003\u0010\u008c\u0001J\b\u0010\u008d\u0001\u001a\u00030\u0082\u0001J\n\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0002J/\u0010\u0090\u0001\u001a\u00020\u00142\u0012\u0010\u0091\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0092\u00012\u0010\u0010\u0093\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0092\u0001H\u0002J$\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u00012\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u00012\n\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0002J\n\u0010\u0098\u0001\u001a\u00030\u0095\u0001H\u0002J\f\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0002J\n\u0010\u009a\u0001\u001a\u00030\u0095\u0001H\u0002J\n\u0010\u009b\u0001\u001a\u00030\u0095\u0001H\u0002J\f\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0002J\f\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0002J\f\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0002J\f\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0002J\n\u0010 \u0001\u001a\u00030\u0095\u0001H\u0002J\b\u0010¡\u0001\u001a\u00030\u0082\u0001J\u001a\u0010¢\u0001\u001a\u00030\u0082\u00012\u0007\u0010£\u0001\u001a\u00020\u00142\u0007\u0010¤\u0001\u001a\u00020\u0014J\u0011\u0010¥\u0001\u001a\u00030\u0082\u00012\u0007\u0010¦\u0001\u001a\u00020\u0014J\u001d\u0010§\u0001\u001a\u00030\u0082\u00012\b\u0010¨\u0001\u001a\u00030©\u00012\t\b\u0002\u0010ª\u0001\u001a\u00020\u0010J\u0011\u0010«\u0001\u001a\u00030\u0082\u00012\u0007\u0010¬\u0001\u001a\u00020\u0014J\u0013\u0010\u00ad\u0001\u001a\u00030\u0082\u00012\t\u0010®\u0001\u001a\u0004\u0018\u00010\u0014J\u0013\u0010¯\u0001\u001a\u00030\u0082\u00012\t\u0010°\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010±\u0001\u001a\u00030\u0082\u00012\b\u0010²\u0001\u001a\u00030³\u0001J\u0013\u0010´\u0001\u001a\u00030\u0082\u00012\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u0014J\u0013\u0010¶\u0001\u001a\u00030\u0082\u00012\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u0014J\u0013\u0010·\u0001\u001a\u00030\u0082\u00012\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u0014J\u0019\u0010¸\u0001\u001a\u00030\u0082\u00012\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u0010¢\u0006\u0003\u0010º\u0001J\u0019\u0010»\u0001\u001a\u00030\u0082\u00012\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u0010¢\u0006\u0003\u0010º\u0001J\u0012\u0010¼\u0001\u001a\u00030\u0082\u00012\b\u0010½\u0001\u001a\u00030¾\u0001J\u0012\u0010¿\u0001\u001a\u00030\u0082\u00012\b\u0010À\u0001\u001a\u00030Á\u0001J\u0011\u0010Â\u0001\u001a\u00030\u0082\u00012\u0007\u0010Ã\u0001\u001a\u00020\u0014J\u0011\u0010Ä\u0001\u001a\u00030\u0082\u00012\u0007\u0010Å\u0001\u001a\u00020\u0014J$\u0010Æ\u0001\u001a\u00030\u0082\u00012\u001a\u0010Ç\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140È\u0001J\u0011\u0010É\u0001\u001a\u00030\u0082\u00012\u0007\u0010Ê\u0001\u001a\u00020\u0010J\n\u0010Ë\u0001\u001a\u00030\u0082\u0001H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0011\u0010\fR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\"8F¢\u0006\u0006\u001a\u0004\b(\u0010$R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\"8F¢\u0006\u0006\u001a\u0004\b,\u0010$R\u000e\u0010-\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u000e\u001a\u0004\b/\u0010\fR\u000e\u00101\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0013\u0010<\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b=\u0010>R\u000e\u0010?\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0016\u0010G\u001a\u0004\u0018\u00010H8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u001d\u0010K\u001a\u0004\u0018\u00010L8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u000e\u001a\u0004\bM\u0010NR\u0011\u0010P\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bQ\u00106R\u0011\u0010R\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bS\u00106R\u000e\u0010T\u001a\u00020UX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010V\u001a\u00020W¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0011\u0010Z\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b[\u0010>R\u000e\u0010\\\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010]\u001a\u00020^8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010\u000e\u001a\u0004\b_\u0010`R\u0011\u0010b\u001a\u00020c8F¢\u0006\u0006\u001a\u0004\bd\u0010eR\u001b\u0010f\u001a\u00020g8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bj\u0010\u000e\u001a\u0004\bh\u0010iR\u0011\u0010k\u001a\u00020l8F¢\u0006\u0006\u001a\u0004\bm\u0010nR\u001b\u0010o\u001a\u00020p8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bs\u0010\u000e\u001a\u0004\bq\u0010rR\u001b\u0010t\u001a\u00020u8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u0010\u000e\u001a\u0004\bv\u0010wR\u0011\u0010y\u001a\u00020z8F¢\u0006\u0006\u001a\u0004\b{\u0010|R\u0012\u0010}\u001a\u00020~8F¢\u0006\u0007\u001a\u0005\b\u007f\u0010\u0080\u0001¨\u0006Í\u0001"}, d2 = {"Lcom/larus/bot/impl/feature/edit/BotUpdateViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "botRepo", "Lcom/larus/bot/impl/repository/UgcBotRepo;", "update", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/bmhome/bot/bean/BotInfoUpdateResult;", "getUpdate", "()Landroidx/lifecycle/MutableLiveData;", "update$delegate", "Lkotlin/Lazy;", "ready", "", "getReady", "ready$delegate", "conversationId", "", "privateStatus", "", "getPrivateStatus", "()Ljava/lang/Integer;", "setPrivateStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "originPrivateStatus", "getOriginPrivateStatus", "setOriginPrivateStatus", "_descPolishBtnStatus", "Lcom/larus/bot/impl/feature/edit/DescPolishBtnStatus;", "descPolishBtnStatus", "Landroidx/lifecycle/LiveData;", "getDescPolishBtnStatus", "()Landroidx/lifecycle/LiveData;", "_descPolishStatus", "Lcom/larus/bot/impl/feature/edit/DescPolishStatus;", "descPolishStatus", "getDescPolishStatus", "_descPolishResult", "Lcom/larus/bot/impl/bean/BotPolishDescUpdateResp;", "descPolishResult", "getDescPolishResult", "isDescGenerating", "descGenerating", "getDescGenerating", "descGenerating$delegate", "lastDesc", "polishCnt", "isPolishUndo", "polishUseInternet", "getPolishUseInternet", "()Z", "setPolishUseInternet", "(Z)V", "getPrivateStatusString", "hasUsedPolishDesc", "getPolishCnt", "polishStatus", "getPolishStatus", "()Ljava/lang/String;", "editParam", "Lcom/larus/bot/impl/bean/BotEditParam;", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "getBotInfo", "()Lcom/larus/im/bean/bot/BotModel;", "setBotInfo", "(Lcom/larus/im/bean/bot/BotModel;)V", "editPos", "Lcom/larus/platform/model/EditPos;", "getEditPos", "()Lcom/larus/platform/model/EditPos;", "bgImageAbParam", "Lcom/larus/bmhome/auth/BgImageAbParam;", "getBgImageAbParam", "()Lcom/larus/bmhome/auth/BgImageAbParam;", "bgImageAbParam$delegate", "canAddBgImage", "getCanAddBgImage", "canGuideImage", "getCanGuideImage", "_mainModel", "Lcom/larus/bot/impl/feature/edit/feature/main/IBotMainModel;", "mainEditViewModel", "Lcom/larus/bot/impl/feature/edit/feature/main/IBotMainEditViewModel;", "getMainEditViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/main/IBotMainEditViewModel;", "draftId", "getDraftId", "polishCreationClickCount", "_avatarModel", "Lcom/larus/bot/impl/feature/edit/feature/avatar/IAvatarModel;", "get_avatarModel", "()Lcom/larus/bot/impl/feature/edit/feature/avatar/IAvatarModel;", "_avatarModel$delegate", "avatarEditModel", "Lcom/larus/bot/impl/feature/edit/feature/avatar/IBotAvatarEditViewModel;", "getAvatarEditModel", "()Lcom/larus/bot/impl/feature/edit/feature/avatar/IBotAvatarEditViewModel;", "_bgImageModel", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/IBgImageModel;", "get_bgImageModel", "()Lcom/larus/bot/impl/feature/edit/feature/bgimage/IBgImageModel;", "_bgImageModel$delegate", "bgImageEditViewModel", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/IBotBgImageEditViewModel;", "getBgImageEditViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/bgimage/IBotBgImageEditViewModel;", "_firstMetEditSubViewModel", "Lcom/larus/bot/impl/feature/edit/feature/firstmet/IFirstMetModel;", "get_firstMetEditSubViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/firstmet/IFirstMetModel;", "_firstMetEditSubViewModel$delegate", "_bioEditSubViewModel", "Lcom/larus/bot/impl/feature/edit/feature/bio/IBioModel;", "get_bioEditSubViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/bio/IBioModel;", "_bioEditSubViewModel$delegate", "firstMetEditViewModel", "Lcom/larus/bot/impl/feature/edit/feature/firstmet/IFirstMetEditViewModel;", "getFirstMetEditViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/firstmet/IFirstMetEditViewModel;", "bioEditViewModel", "Lcom/larus/bot/impl/feature/edit/feature/bio/IBioEditViewModel;", "getBioEditViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/bio/IBioEditViewModel;", "initConversationId", "", "getEditParam", "initEditParam", "updateResult", "respBotInfo", "checkUserEdited", "hasEditBgImage", "checkUserEditArea", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireBotPolishDesc", "getBotEnrichRequestParam", "Lcom/larus/bot/impl/feature/edit/feature/autofill/model/BotEnrichParam;", "getCommonContentSourceRequestData", "lastAiGenInfo", "", "curEditInfo", "mergeHeadAndBgImgEnrichRequestData", "Lcom/larus/bot/impl/bean/EnrichBotData;", "headImgData", "bgImgData", "getHeadImgEnrichRequestData", "getBgImgEnrichRequestData", "getNameEnrichRequestData", "getDescEnrichRequestData", "getPrologueEnrichRequestData", "getBioEnrichRequestData", "getSuggestEnrichRequestData", "getVoiceIdEnrichRequestData", "getLanguageEnrichRequestData", "botPolishDescUndo", "updateIconUri", "iconUrl", "iconUri", "updateName", "name", "updateVoice", "voice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "fromActivityResult", "updateDescription", "description", "updateAvatarPrompt", "avatarPrompt", "updateAvatarPromptForEnrich", "prompt", "updateBgImage", "bgImage", "Lcom/larus/im/bean/bot/BgImage;", "updateOriginalUserImgUri", "uri", "updateOriginalImgUri", "updateOriginBackgroundImgUri", "updateEnableWebSearch", "enable", "(Ljava/lang/Boolean;)V", "updateEnableGenPic", "updateModelType", "type", "", "updateModel", "model", "Lcom/larus/im/bean/bot/ModelItem;", "updatePrologue", "prologue", "updateBio", "bio", "updateSuggests", "suggests", "Lkotlin/Triple;", "updateSuggestSwitch", ItemStyle.ITEM_STYLE_SWITCH, "checkCreateParam", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotUpdateViewModel extends AndroidViewModel {
    public static final a Companion = null;
    private static final String TAG = "BotUpdateViewModel";
    private final Lazy _avatarModel$delegate;
    private final Lazy _bgImageModel$delegate;
    private final Lazy _bioEditSubViewModel$delegate;
    private final MutableLiveData<DescPolishBtnStatus> _descPolishBtnStatus;
    private final MutableLiveData<pu8.a> _descPolishResult;
    private final MutableLiveData<DescPolishStatus> _descPolishStatus;
    private final Lazy _firstMetEditSubViewModel$delegate;
    private final com.larus.bot.impl.feature.edit.feature.main.d _mainModel;
    private final Lazy bgImageAbParam$delegate;
    private BotModel botInfo;
    private final UgcBotRepo botRepo;
    private final boolean canAddBgImage;
    private final boolean canGuideImage;
    private String conversationId;
    private final Lazy descGenerating$delegate;
    private final String draftId;
    private BotEditParam editParam;
    private boolean isDescGenerating;
    private boolean isPolishUndo;
    private String lastDesc;
    private final com.larus.bot.impl.feature.edit.feature.main.c mainEditViewModel;
    private Integer originPrivateStatus;
    private int polishCnt;
    private int polishCreationClickCount;
    private boolean polishUseInternet;
    private Integer privateStatus;
    private final Lazy ready$delegate;
    private final Lazy update$delegate;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.larus.bot.impl.feature.edit.feature.avatar.s {
        public final /* synthetic */ BotUpdateViewModel a;

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void c(boolean r1) {
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final int getScene() {
            return 1;
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final BotEditParam a() {
            return BotUpdateViewModel.access$getEditParam$p(this.a);
        }

        public b(BotUpdateViewModel r1) {
            this.a = r1;
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void b(boolean r2) {
            BotUpdateViewModel.access$get_mainModel$p(this.a).b(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void h(String r2) {
            this.a.updateAvatarPrompt(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void m(String r2) {
            this.a.updateAvatarPromptForEnrich(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void k(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, ShareType.URL);
            Intrinsics.checkNotNullParameter(r3, "uri");
            this.a.updateIconUri(r2, r3);
        }
    }

    public static final class c implements com.larus.bot.impl.feature.edit.feature.bgimage.s {
        public final /* synthetic */ BotUpdateViewModel a;

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void c(boolean r1) {
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final int getScene() {
            return 1;
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final BotEditParam a() {
            return BotUpdateViewModel.access$getEditParam$p(this.a);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
        public final Map<String, List<String>> g() {
            return MapsKt.emptyMap();
        }

        public c(BotUpdateViewModel r1) {
            this.a = r1;
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void b(boolean r2) {
            BotUpdateViewModel.access$get_mainModel$p(this.a).b(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
        public final void e(String r2) {
            Intrinsics.checkNotNullParameter(r2, "type");
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
        public final void f(String r2) {
            this.a.updateOriginalImgUri(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void h(String r2) {
            this.a.updateAvatarPrompt(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
        public final void j(String r2) {
            this.a.updateOriginalUserImgUri(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
        public final void l(String r2) {
            Intrinsics.checkNotNullParameter(r2, "gender");
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void m(String r2) {
            this.a.updateAvatarPromptForEnrich(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
        public final void n(BgImage r2) {
            Intrinsics.checkNotNullParameter(r2, "bgImage");
            this.a.updateBgImage(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
        public final void p(String r2) {
            this.a.updateOriginBackgroundImgUri(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
        public final void k(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, ShareType.URL);
            Intrinsics.checkNotNullParameter(r3, "uri");
            this.a.updateIconUri(r2, r3);
        }
    }

    public static final class d implements com.larus.bot.impl.feature.edit.feature.bio.h {
        public final /* synthetic */ BotUpdateViewModel a;

        @Override // com.larus.bot.impl.feature.edit.feature.bio.h
        public final BotEditParam a() {
            return BotUpdateViewModel.access$getEditParam$p(this.a);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bio.h
        public final boolean c() {
            EditPos r0 = BotUpdateViewModel.access$getEditPos(this.a);
            if (r0 == null) goto L5;
            boolean r1 = Intrinsics.areEqual(r0.a(), Boolean.TRUE);
        L6:
            FLogger.a.i(BotUpdateViewModel.TAG, "canEditBio: " + r1);
            return r1;
        L5:
            r1 = false;
            goto L6
        }

        public d(BotUpdateViewModel r1) {
            this.a = r1;
        }

        @Override // com.larus.bot.impl.feature.edit.feature.bio.h
        public final void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "bio");
            this.a.updateBio(r2);
        }
    }

    public static final class e implements com.larus.bot.impl.feature.edit.feature.firstmet.o {
        public final /* synthetic */ BotUpdateViewModel a;

        @Override // com.larus.bot.impl.feature.edit.feature.firstmet.o
        public final int getScene() {
            return 1;
        }

        @Override // com.larus.bot.impl.feature.edit.feature.firstmet.o
        public final BotEditParam a() {
            return BotUpdateViewModel.access$getEditParam$p(this.a);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.firstmet.o
        public final boolean d() {
            EditPos r0 = BotUpdateViewModel.access$getEditPos(this.a);
            if (r0 == null) goto L5;
            boolean r1 = Intrinsics.areEqual(r0.d(), Boolean.TRUE);
        L6:
            FLogger.a.i(BotUpdateViewModel.TAG, "firstMetEditable: " + r1);
            return r1;
        L5:
            r1 = false;
            goto L6
        }

        public e(BotUpdateViewModel r1) {
            this.a = r1;
        }

        @Override // com.larus.bot.impl.feature.edit.feature.firstmet.o
        public final void b(boolean r2) {
            this.a.updateSuggestSwitch(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.firstmet.o
        public final void c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "prologue");
            this.a.updatePrologue(r2);
        }

        @Override // com.larus.bot.impl.feature.edit.feature.firstmet.o
        public final void e(Triple<String, String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "suggests");
            this.a.updateSuggests(r2);
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.BotUpdateViewModel$requireBotPolishDesc$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.BotUpdateViewModel$requireBotPolishDesc$1", f = "BotUpdateViewModel.kt", i = {}, l = {431}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BotUpdateViewModel this$0;

        public AnonymousClass1(BotUpdateViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r4 = false;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L15:
            final com.larus.network.http.y r11 = (com.larus.network.http.a) r10;
            if ((r11 instanceof com.larus.network.http.y) == false) goto L27;
            FLogger r2 = FLogger.a;
            StringBuilder r3 = new StringBuilder("requireBotPolishDesc success, desc = ");
            com.larus.network.http.y r5 = r11;
            BotPolishDescResp r6 = (BotPolishDescResp) ((com.larus.network.http.a) r5).b;
            if (r6 == null) goto L20;
            String r7 = r6.getDesc();
        L21:
            r3.append(r7);
            r2.d(BotUpdateViewModel.TAG, r3.toString());
            BotUpdateViewModel.access$setPolishCnt$p(this.this$0, BotUpdateViewModel.access$getPolishCnt$p(this.this$0) + 1);
            BotUpdateViewModel r8 = this.this$0;
            BotPolishDescResp r9 = (BotPolishDescResp) ((com.larus.network.http.a) r5).b;
            if (r9 == null) goto L26;
            Boolean r12 = r9.getUseInternet();
            if (r12 == null) goto L26;
            r4 = r12.booleanValue();
        L26:
            r8.setPolishUseInternet(r4);
            BotUpdateViewModel.access$get_descPolishResult$p(this.this$0).postValue(new pu8.a(null, (BotPolishDescResp) ((com.larus.network.http.a) r5).b, 1));
            SoftReference r13 = com.larus.utils.y.a;
            final BotUpdateViewModel r14 = this.this$0;
            Runnable r15 = new i2(r11, r14);
            Intrinsics.checkNotNullParameter(r15, "action");
            com.larus.utils.y.d(r15, 100);
        L39:
            return Unit.INSTANCE;
        L20:
            r7 = null;
            goto L21
        L27:
            BotUpdateViewModel.access$setDescGenerating$p(this.this$0, false);
            this.this$0.getDescGenerating().postValue(Boxing.boxBoolean(BotUpdateViewModel.access$isDescGenerating$p(this.this$0)));
            BotUpdateViewModel.access$checkCreateParam(this.this$0);
            BotUpdateViewModel.access$get_descPolishBtnStatus$p(this.this$0).postValue(DescPolishBtnStatus.ENABLE);
            BotUpdateViewModel.access$get_descPolishStatus$p(this.this$0).postValue(DescPolishStatus.BEFORE_POLISH);
            if ((r11 instanceof com.larus.network.http.f) == false) goto L30;
            com.larus.network.http.f r16 = (com.larus.network.http.f) r11;
        L31:
            if (r16 == null) goto L36;
            AsyncThrowable r17 = r16.d;
            if (r17 == null) goto L36;
            String r18 = r17.getMessage();
            if (r18 == null) goto L36;
        L37:
            FLogger.a.d(BotUpdateViewModel.TAG, "requireBotPolishDesc fail, msg = " + r18);
            BotUpdateViewModel.access$get_descPolishResult$p(this.this$0).postValue(new pu8.a(r18, null, 2));
        L36:
            int r19 = com.larus.utils.j0.a;
            r18 = com.larus.utils.j0.d(2131908080);
            goto L37
        L30:
            r16 = null;
            goto L31
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L12;
            FLogger.a.d(BotUpdateViewModel.TAG, "requireBotPolishDesc, network not available");
            BotUpdateViewModel.access$setDescGenerating$p(this.this$0, false);
            this.this$0.getDescGenerating().postValue(Boxing.boxBoolean(BotUpdateViewModel.access$isDescGenerating$p(this.this$0)));
            MutableLiveData r110 = BotUpdateViewModel.access$get_descPolishResult$p(this.this$0);
            int r20 = com.larus.utils.j0.a;
            r110.postValue(new pu8.a(com.larus.utils.j0.d(2131908080), null, 2));
            BotUpdateViewModel.access$checkCreateParam(this.this$0);
            return Unit.INSTANCE;
        L12:
            FLogger.a.d(BotUpdateViewModel.TAG, "requireBotPolishDesc, start");
            BotUpdateViewModel.access$get_descPolishBtnStatus$p(this.this$0).postValue(DescPolishBtnStatus.DISABLE);
            BotUpdateViewModel.access$get_descPolishStatus$p(this.this$0).postValue(DescPolishStatus.IN_POLISH);
            UgcBotRepo r111 = BotUpdateViewModel.access$getBotRepo$p(this.this$0);
            BotEnrichParam r21 = BotUpdateViewModel.access$getBotEnrichRequestParam(this.this$0);
            String r22 = BotUpdateViewModel.access$getEditParam$p(this.this$0).getBotId();
            this.label = 1;
            r111.getClass();
            r10 = UgcBotRepo.g(r21, r22, this);
            if (r10 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.BotUpdateViewModel$update$4, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.BotUpdateViewModel", f = "BotUpdateViewModel.kt", i = {}, l = {374, 381}, m = "update", n = {}, s = {})
    public static final class AnonymousClass4 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BotUpdateViewModel this$0;

        public AnonymousClass4(BotUpdateViewModel r1, Continuation<? super AnonymousClass4> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.update(this);
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ MutableLiveData Mo() {
        return update_delegate$lambda$0();
    }

    public static /* synthetic */ void No(BotUpdateViewModel r0) {
        botPolishDescUndo$lambda$15(r0);
    }

    public static /* synthetic */ BotBgImageEditViewModel Oo(BotUpdateViewModel r0) {
        return _bgImageModel_delegate$lambda$7(r0);
    }

    public static /* synthetic */ BotAvatarEditViewModel Po(Application r0, BotUpdateViewModel r1) {
        return _avatarModel_delegate$lambda$6(r0, r1);
    }

    public static /* synthetic */ BotFirstMetEditViewModel Qo(BotUpdateViewModel r0) {
        return _firstMetEditSubViewModel_delegate$lambda$8(r0);
    }

    public static /* synthetic */ MutableLiveData So() {
        return ready_delegate$lambda$1();
    }

    public static /* synthetic */ BotBioEditViewModel To(BotUpdateViewModel r0) {
        return _bioEditSubViewModel_delegate$lambda$9(r0);
    }

    public static /* synthetic */ MutableLiveData Wo() {
        return descGenerating_delegate$lambda$2();
    }

    public static /* synthetic */ void Yo(BotUpdateViewModel r0) {
        checkCreateParam$lambda$17(r0);
    }

    public static /* synthetic */ BgImageAbParam yo() {
        return bgImageAbParam_delegate$lambda$5();
    }

    private static final BgImageAbParam bgImageAbParam_delegate$lambda$5() {
        LaunchInfo r0 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r0 == null) goto L7;
        BgImageConfig r1 = r0.h();
        if (r1 == null) goto L7;
        return r1.a();
    L7:
        return null;
    }

    private final void checkCreateParam() {
        com.larus.utils.t0.e(new g2(this));
    }

    private static final MutableLiveData descGenerating_delegate$lambda$2() {
        return new MutableLiveData();
    }

    private final EnrichBotData getBgImgEnrichRequestData() {
        String r1 = null;
        if (this.canAddBgImage == false) goto L20;
        BgImage r2 = this.editParam.getBgImage();
        if (r2 == null) goto L10;
        BgImageInfo r3 = r2.bgImageInfo;
        if (r3 == null) goto L10;
        String r4 = r3.bgImagePromptForEnrich;
    L11:
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        String r5 = getCommonContentSourceRequestData(null, CollectionsKt.listOf(r4));
        String r6 = ContentType.BG_IMG_PROMPT.getValue();
        BgImage r7 = this.editParam.getBgImage();
        if (r7 == null) goto L19;
        BgImageInfo r8 = r7.bgImageInfo;
        if (r8 == null) goto L19;
        r1 = r8.bgImagePromptForEnrich;
    L19:
        return new EnrichBotData(r5, null, r6, CollectionsKt.listOf(r1), null, 18, null);
    L10:
        r4 = null;
        goto L11
    L20:
        return null;
    }

    private final BotEnrichParam getBotEnrichRequestParam() {
        List r10 = CollectionsKt.listOfNotNull(new EnrichBotData[]{mergeHeadAndBgImgEnrichRequestData(getHeadImgEnrichRequestData(), getBgImgEnrichRequestData()), getNameEnrichRequestData(), getDescEnrichRequestData(), getPrologueEnrichRequestData(), getBioEnrichRequestData(), getSuggestEnrichRequestData(), getVoiceIdEnrichRequestData(), getLanguageEnrichRequestData()});
        String r1 = this.draftId;
        int r3 = this.polishCreationClickCount + 1;
        this.polishCreationClickCount = r3;
        return new BotEnrichParam(null, null, null, null, null, r10, new CreationIdInfo(r1, Integer.valueOf(r3)), 31, null);
    }

    private final EnrichBotData getDescEnrichRequestData() {
        return new EnrichBotData(getCommonContentSourceRequestData(null, CollectionsKt.listOf(this.editParam.getName())), null, ContentType.DESC.getValue(), CollectionsKt.listOf(this.editParam.getDescription()), null, 18, null);
    }

    private final EditPos getEditPos() {
        BotModel r0 = this.botInfo;
        Object r1 = null;
        if (r0 == null) goto L18;
        String r2 = r0.getEditPos();
        if (r2 == null) goto L19;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        Object r4 = Result.constructor-impl((EditPos) new Gson().fromJson(r2, EditPos.class));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r4) == true) goto L15;
        r1 = r4;
    L15:
        return (EditPos) r1;
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L19:
        return null;
    L18:
        return null;
    }

    private final EnrichBotData getHeadImgEnrichRequestData() {
        String r0 = this.editParam.getAvatarPrompt();
        boolean r2 = true;
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        String r4 = "";
        if (r1 == false) goto L11;
        r0 = this.editParam.getAvatarPromptForEnrich();
        if (r0 != null) goto L11;
        r0 = "";
    L11:
        String r6 = getCommonContentSourceRequestData(null, CollectionsKt.listOf(r0));
        String r8 = ContentType.HEAD_IMG_PROMPT.getValue();
        String r3 = this.editParam.getAvatarPrompt();
        if (r3.length() == 0) goto L15;
        r2 = false;
    L15:
        if (r2 == false) goto L22;
        String r5 = this.editParam.getAvatarPromptForEnrich();
        if (r5 == null) goto L20;
        r4 = r5;
    L20:
        r3 = r4;
    L22:
        return new EnrichBotData(r6, null, r8, CollectionsKt.listOf(r3), null, 18, null);
    L5:
        r1 = false;
        goto L6
    }

    private final EnrichBotData getLanguageEnrichRequestData() {
        BotLanguage r0 = this.editParam.getLanguage();
        if (r0 == null) goto L5;
        String r1 = r0.c();
    L6:
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        List<String> r6 = CollectionsKt.listOf(r1);
        return new EnrichBotData(getCommonContentSourceRequestData(null, r6), null, ContentType.LANGUAGE.getValue(), r6, null, 18, null);
    L5:
        r1 = null;
        goto L6
    }

    private final EnrichBotData getNameEnrichRequestData() {
        return new EnrichBotData(getCommonContentSourceRequestData(null, CollectionsKt.listOf(this.editParam.getName())), null, ContentType.NAME.getValue(), CollectionsKt.listOf(this.editParam.getName()), null, 18, null);
    }

    private final EnrichBotData getVoiceIdEnrichRequestData() {
        String r1 = null;
        if (z2.a.m3() == false) goto L18;
        SpeakerVoice r0 = this.editParam.getVoice();
        if (r0 == null) goto L7;
        r1 = r0.getId();
    L7:
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        if (StringsKt.isBlank(r1) == false) goto L12;
    L15:
        ContentSource r2 = ContentSource.NOT_ENTERED;
    L17:
        return new EnrichBotData(r2.getValue(), null, ContentType.VOICE_ID.getValue(), CollectionsKt.listOf(r1), null, 18, null);
    L12:
        if (Intrinsics.areEqual(r1, TriggerSendLoading.NO_LOADING) == true) goto L15;
        r2 = ContentSource.USER_INPUT;
        goto L17
    L18:
        return null;
    }

    private final com.larus.bot.impl.feature.edit.feature.avatar.t get_avatarModel() {
        return (com.larus.bot.impl.feature.edit.feature.avatar.t) this._avatarModel$delegate.getValue();
    }

    private final com.larus.bot.impl.feature.edit.feature.bgimage.t get_bgImageModel() {
        return (com.larus.bot.impl.feature.edit.feature.bgimage.t) this._bgImageModel$delegate.getValue();
    }

    private final com.larus.bot.impl.feature.edit.feature.bio.j get_bioEditSubViewModel() {
        return (com.larus.bot.impl.feature.edit.feature.bio.j) this._bioEditSubViewModel$delegate.getValue();
    }

    private final com.larus.bot.impl.feature.edit.feature.firstmet.q get_firstMetEditSubViewModel() {
        return (com.larus.bot.impl.feature.edit.feature.firstmet.q) this._firstMetEditSubViewModel$delegate.getValue();
    }

    private static final MutableLiveData ready_delegate$lambda$1() {
        return new MutableLiveData();
    }

    private static final MutableLiveData update_delegate$lambda$0() {
        return new MutableLiveData();
    }

    public final void botPolishDescUndo() {
        FLogger.a.d(TAG, "botPolishDescUndo, lastDesc = " + this.lastDesc);
        this._descPolishBtnStatus.postValue(DescPolishBtnStatus.ENABLE);
        this._descPolishStatus.postValue(DescPolishStatus.BEFORE_POLISH);
        this._descPolishResult.postValue(new pu8.a(null, new BotPolishDescResp(this.lastDesc, null, 2, null), 1));
        SoftReference r0 = com.larus.utils.y.a;
        Runnable r1 = new h2(this);
        Intrinsics.checkNotNullParameter(r1, "action");
        com.larus.utils.y.d(r1, 100);
    }

    public final BgImageAbParam getBgImageAbParam() {
        return (BgImageAbParam) this.bgImageAbParam$delegate.getValue();
    }

    public final MutableLiveData<Boolean> getDescGenerating() {
        return (MutableLiveData) this.descGenerating$delegate.getValue();
    }

    public final String getPrivateStatusString() {
        Integer r0 = this.privateStatus;
        if (r0 != null) goto L6;
    L8:
        if (r0 != null) goto L11;
    L13:
        return "not_seen";
    L11:
        if (r0.intValue() != 2) goto L13;
        return "private";
    L6:
        if (r0.intValue() != 1) goto L8;
        return "public";
    }

    public final MutableLiveData<Boolean> getReady() {
        return (MutableLiveData) this.ready$delegate.getValue();
    }

    public final MutableLiveData<ub8.b> getUpdate() {
        return (MutableLiveData) this.update$delegate.getValue();
    }

    public final boolean hasUsedPolishDesc() {
        if (this.polishCnt <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void requireBotPolishDesc() {
        if (z2.a.x3().getDisableBotDescPolish() == false) goto L5;
        return;
    L5:
        FLogger.a.d(TAG, "requireBotPolishDesc");
        this.lastDesc = this.editParam.getDescription();
        this.isDescGenerating = true;
        this.isPolishUndo = false;
        getDescGenerating().postValue(Boolean.valueOf(this.isDescGenerating));
        checkCreateParam();
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    private final EnrichBotData getBioEnrichRequestData() {
        if (((com.larus.bot.impl.feature.edit.feature.bio.c) getBioEditViewModel().getUiState().getValue()).a == false) goto L6;
        List<String> r6 = CollectionsKt.listOf(this.editParam.getBio());
        return new EnrichBotData(getCommonContentSourceRequestData(null, r6), null, ContentType.BIO.getValue(), r6, null, 18, null);
    L6:
        return null;
    }

    private final EnrichBotData getPrologueEnrichRequestData() {
        if (((com.larus.bot.impl.feature.edit.feature.firstmet.n) getFirstMetEditViewModel().getUiState().getValue()).a == false) goto L9;
        String r0 = this.editParam.getPrologue();
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        List<String> r6 = CollectionsKt.listOf(r0);
        return new EnrichBotData(getCommonContentSourceRequestData(null, r6), null, ContentType.PROLOGUE.getValue(), r6, null, 18, null);
    L9:
        return null;
    }

    private final EnrichBotData getSuggestEnrichRequestData() {
        List<String> r1 = null;
        if (((com.larus.bot.impl.feature.edit.feature.firstmet.n) getFirstMetEditViewModel().getUiState().getValue()).d == false) goto L13;
        Triple<String, String, String> r2 = this.editParam.getSuggests();
        if (r2 == null) goto L7;
        List<String> r3 = com.larus.bot.impl.feature.edit.feature.firstmet.k.c(r2);
    L8:
        String r4 = getCommonContentSourceRequestData(null, r3);
        String r5 = ContentType.SUGGEST.getValue();
        Triple<String, String, String> r6 = this.editParam.getSuggests();
        if (r6 == null) goto L12;
        r1 = com.larus.bot.impl.feature.edit.feature.firstmet.k.c(r6);
    L12:
        return new EnrichBotData(r4, null, r5, r1, null, 18, null);
    L7:
        r3 = null;
        goto L8
    L13:
        return null;
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
        return get_bioEditSubViewModel();
    }

    public final com.larus.bot.impl.feature.edit.feature.firstmet.p getFirstMetEditViewModel() {
        return get_firstMetEditSubViewModel();
    }

    public final String getPolishStatus() {
        if (hasUsedPolishDesc() == true) goto L5;
        return null;
    L5:
        if (this.isPolishUndo == false) goto L7;
        return TriggerSendLoading.NO_LOADING;
    L7:
        return "1";
    }

    public final BotModel getBotInfo() {
        return this.botInfo;
    }

    public final boolean getCanAddBgImage() {
        return this.canAddBgImage;
    }

    public final boolean getCanGuideImage() {
        return this.canGuideImage;
    }

    public final LiveData<DescPolishBtnStatus> getDescPolishBtnStatus() {
        return this._descPolishBtnStatus;
    }

    public final LiveData<pu8.a> getDescPolishResult() {
        return this._descPolishResult;
    }

    public final LiveData<DescPolishStatus> getDescPolishStatus() {
        return this._descPolishStatus;
    }

    public final String getDraftId() {
        return this.draftId;
    }

    public final BotEditParam getEditParam() {
        return this.editParam;
    }

    public final com.larus.bot.impl.feature.edit.feature.main.c getMainEditViewModel() {
        return this.mainEditViewModel;
    }

    public final Integer getOriginPrivateStatus() {
        return this.originPrivateStatus;
    }

    public final int getPolishCnt() {
        return this.polishCnt;
    }

    public final boolean getPolishUseInternet() {
        return this.polishUseInternet;
    }

    public final Integer getPrivateStatus() {
        return this.privateStatus;
    }

    public BotUpdateViewModel(final Application r35) {
        Intrinsics.checkNotNullParameter(r35, "application");
        super(r35);
        Lazy<UgcBotRepo> r2 = UgcBotRepo.d;
        this.botRepo = UgcBotRepo.a.a();
        this.update$delegate = LazyKt.lazy(new y1());
        this.ready$delegate = LazyKt.lazy(new z1());
        this.conversationId = "";
        boolean r3 = true;
        this.privateStatus = 1;
        this._descPolishBtnStatus = new MutableLiveData();
        this._descPolishStatus = new MutableLiveData();
        this._descPolishResult = new MutableLiveData();
        this.descGenerating$delegate = LazyKt.lazy(new a2());
        this.lastDesc = "";
        this.editParam = new BotEditParam(null, null, null, null, null, null, 0, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, 33554431, null);
        this.bgImageAbParam$delegate = LazyKt.lazy(new b2());
        z2 r4 = z2.a;
        if (r4.chatImmerseEnable() == false) goto L10;
        BgImageAbParam r5 = getBgImageAbParam();
        if (r5 == null) goto L7;
        boolean r6 = Intrinsics.areEqual(Boolean.TRUE, r5.b());
    L8:
        if (r6 == false) goto L10;
        boolean r7 = true;
    L11:
        this.canAddBgImage = r7;
        if (r4.chatImmerseEnable() == false) goto L19;
        BgImageAbParam r8 = getBgImageAbParam();
        if (r8 == null) goto L16;
        boolean r9 = Intrinsics.areEqual(Boolean.TRUE, r8.d());
    L17:
        if (r9 == false) goto L19;
    L20:
        this.canGuideImage = r3;
        com.larus.bot.impl.feature.edit.feature.main.b r10 = new com.larus.bot.impl.feature.edit.feature.main.b(ViewModelKt.getViewModelScope(this));
        this._mainModel = r10;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.larus.bot.impl.feature.edit.feature.main.IBotMainEditViewModel");
        this.mainEditViewModel = r10;
        int r11 = dv8.b.g;
        this.draftId = dv8.b.a.a();
        this._avatarModel$delegate = LazyKt.lazy(new c2(r35, this));
        this._bgImageModel$delegate = LazyKt.lazy(new d2(this));
        this._firstMetEditSubViewModel$delegate = LazyKt.lazy(new e2(this));
        this._bioEditSubViewModel$delegate = LazyKt.lazy(new f2(this));
        return;
    L16:
        r9 = false;
    L19:
        r3 = false;
        goto L20
    L7:
        r6 = false;
    L10:
        r7 = false;
        goto L11
    }

    private static final BotBgImageEditViewModel _bgImageModel_delegate$lambda$7(BotUpdateViewModel r3) {
        return new BotBgImageEditViewModel(ViewModelKt.getViewModelScope(r3), new c(r3));
    }

    private static final BotBioEditViewModel _bioEditSubViewModel_delegate$lambda$9(BotUpdateViewModel r3) {
        return new BotBioEditViewModel(ViewModelKt.getViewModelScope(r3), new d(r3));
    }

    private static final BotFirstMetEditViewModel _firstMetEditSubViewModel_delegate$lambda$8(BotUpdateViewModel r3) {
        return new BotFirstMetEditViewModel(ViewModelKt.getViewModelScope(r3), new e(r3));
    }

    public static final /* synthetic */ void access$checkCreateParam(BotUpdateViewModel r0) {
        r0.checkCreateParam();
    }

    public static final /* synthetic */ BotEnrichParam access$getBotEnrichRequestParam(BotUpdateViewModel r0) {
        return r0.getBotEnrichRequestParam();
    }

    public static final /* synthetic */ UgcBotRepo access$getBotRepo$p(BotUpdateViewModel r0) {
        return r0.botRepo;
    }

    public static final /* synthetic */ BotEditParam access$getEditParam$p(BotUpdateViewModel r0) {
        return r0.editParam;
    }

    public static final /* synthetic */ EditPos access$getEditPos(BotUpdateViewModel r0) {
        return r0.getEditPos();
    }

    public static final /* synthetic */ int access$getPolishCnt$p(BotUpdateViewModel r0) {
        return r0.polishCnt;
    }

    public static final /* synthetic */ MutableLiveData access$get_descPolishBtnStatus$p(BotUpdateViewModel r0) {
        return r0._descPolishBtnStatus;
    }

    public static final /* synthetic */ MutableLiveData access$get_descPolishResult$p(BotUpdateViewModel r0) {
        return r0._descPolishResult;
    }

    public static final /* synthetic */ MutableLiveData access$get_descPolishStatus$p(BotUpdateViewModel r0) {
        return r0._descPolishStatus;
    }

    public static final /* synthetic */ com.larus.bot.impl.feature.edit.feature.main.d access$get_mainModel$p(BotUpdateViewModel r0) {
        return r0._mainModel;
    }

    public static final /* synthetic */ boolean access$isDescGenerating$p(BotUpdateViewModel r0) {
        return r0.isDescGenerating;
    }

    private static final void botPolishDescUndo$lambda$15(BotUpdateViewModel r1) {
        r1.isPolishUndo = true;
    }

    private static final void checkCreateParam$lambda$17(BotUpdateViewModel r5) {
        MutableLiveData<Boolean> r0 = r5.getReady();
        boolean r3 = true;
        IntRange r1 = new IntRange(1, 40);
        BotEditParam r2 = r5.editParam;
        if (r2 == null) goto L7;
        String r4 = r2.getName();
        if (r4 == null) goto L7;
        Integer r6 = Integer.valueOf(r4.length());
    L9:
        if (r6 != null) goto L11;
    L13:
        boolean r7 = false;
    L14:
        if (r7 == true) goto L16;
    L18:
        boolean r8 = false;
    L19:
        r0.setValue(Boolean.valueOf(r8));
        MutableLiveData<DescPolishBtnStatus> r9 = r5._descPolishBtnStatus;
        if (r5.editParam.getDescription().length() > 0) goto L23;
        r3 = false;
    L23:
        if (r3 == true) goto L25;
    L27:
        DescPolishBtnStatus r10 = DescPolishBtnStatus.DISABLE;
    L28:
        r9.postValue(r10);
        return;
    L25:
        if (r5.isDescGenerating == true) goto L27;
        r10 = DescPolishBtnStatus.ENABLE;
        goto L28
    L16:
        if (r5.isDescGenerating == true) goto L18;
        r8 = true;
        goto L19
    L11:
        if (r1.contains(r6.intValue()) == false) goto L13;
        r7 = true;
    L7:
        r6 = null;
        goto L9
    }

    public final ArrayList<String> checkUserEditArea(BotModel r5) {
        if (r5 == null) goto L4;
        ArrayList<String> r0 = new ArrayList();
        BotIconImage r1 = r5.getIconImage();
        ModelItem r2 = null;
        if (r1 == null) goto L8;
        String r3 = r1.getOriginUrl();
    L9:
        BotEditParam r4 = this.editParam;
        if (r4 == null) goto L12;
        String r6 = r4.getIconUrl();
    L14:
        if (Intrinsics.areEqual(r3, r6) == false) goto L25;
        BotIconImage r7 = r5.getIconImage();
        if (r7 == null) goto L18;
        String r8 = r7.getUri();
    L19:
        BotEditParam r9 = this.editParam;
        if (r9 == null) goto L22;
        String r10 = r9.getIconUri();
    L24:
        if (Intrinsics.areEqual(r8, r10) == false) goto L25;
    L26:
        String r11 = r5.getName();
        BotEditParam r12 = this.editParam;
        if (r12 == null) goto L29;
        String r13 = r12.getName();
    L31:
        if (Intrinsics.areEqual(r11, r13) == true) goto L33;
        r0.add("name");
    L33:
        String r14 = r5.getDescriptionForHuman();
        BotEditParam r15 = this.editParam;
        if (r15 == null) goto L36;
        String r16 = r15.getDescription();
    L38:
        if (Intrinsics.areEqual(r14, r16) == true) goto L40;
        r0.add("description");
    L40:
        BotSwitchConfInfo r17 = r5.getSwitchConfInfo();
        if (r17 == null) goto L43;
        Boolean r18 = r17.getEnableWebSearch();
    L44:
        BotEditParam r19 = this.editParam;
        if (r19 == null) goto L47;
        Boolean r20 = r19.getEnableWebSearch();
    L49:
        if (Intrinsics.areEqual(r18, r20) == true) goto L51;
        r0.add("enable_web_search");
    L51:
        BotSwitchConfInfo r21 = r5.getSwitchConfInfo();
        if (r21 == null) goto L54;
        Boolean r22 = r21.getEnablePicGen();
    L55:
        BotEditParam r23 = this.editParam;
        if (r23 == null) goto L58;
        Boolean r24 = r23.getEnableGenPic();
    L60:
        if (Intrinsics.areEqual(r22, r24) == true) goto L63;
        r0.add("enable_gen_pic");
    L63:
        if (Intrinsics.areEqual(r5.getPrivateStatus(), this.privateStatus) == true) goto L65;
        r0.add("private_status");
    L65:
        ModelItem r25 = r5.getModel();
        BotEditParam r26 = this.editParam;
        if (r26 == null) goto L69;
        r2 = r26.getModelItem();
    L69:
        if (Intrinsics.areEqual(r25, r2) == true) goto L71;
        r0.add("model");
    L71:
        return r0;
    L58:
        r24 = null;
        goto L60
    L54:
        r22 = null;
        goto L55
    L47:
        r20 = null;
        goto L49
    L43:
        r18 = null;
        goto L44
    L36:
        r16 = null;
        goto L38
    L29:
        r13 = null;
        goto L31
    L22:
        r10 = null;
        goto L24
    L18:
        r8 = null;
    L25:
        r0.add("profile_pic");
        goto L26
    L12:
        r6 = null;
        goto L14
    L8:
        r3 = null;
        goto L9
    L4:
        return new ArrayList();
    }

    public final boolean checkUserEdited(BotModel r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this.editParam != null) goto L8;
        return false;
    L8:
        String r1 = r5.getName();
        BotEditParam r2 = this.editParam;
        ModelItem r3 = null;
        if (r2 == null) goto L11;
        String r4 = r2.getName();
    L13:
        if (Intrinsics.areEqual(r1, r4) == false) goto L97;
        String r6 = r5.getDescriptionForHuman();
        BotEditParam r7 = this.editParam;
        if (r7 == null) goto L17;
        String r8 = r7.getDescription();
    L19:
        if (Intrinsics.areEqual(r6, r8) == false) goto L97;
        BotIconImage r9 = r5.getIconImage();
        if (r9 == null) goto L23;
        String r10 = r9.getOriginUrl();
    L24:
        BotEditParam r11 = this.editParam;
        if (r11 == null) goto L27;
        String r12 = r11.getIconUrl();
    L29:
        if (Intrinsics.areEqual(r10, r12) == false) goto L97;
        BotIconImage r13 = r5.getIconImage();
        if (r13 == null) goto L33;
        String r14 = r13.getUri();
    L34:
        BotEditParam r15 = this.editParam;
        if (r15 == null) goto L37;
        String r16 = r15.getIconUri();
    L39:
        if (Intrinsics.areEqual(r14, r16) == false) goto L97;
        SpeakerVoice r17 = r5.getVoiceType();
        if (r17 == null) goto L43;
        String r18 = r17.getId();
    L44:
        BotEditParam r19 = this.editParam;
        if (r19 == null) goto L49;
        SpeakerVoice r20 = r19.getVoice();
        if (r20 == null) goto L49;
        String r21 = r20.getId();
    L51:
        if (Intrinsics.areEqual(r18, r21) == false) goto L97;
        SpeakerVoice r22 = r5.getVoiceType();
        if (r22 == null) goto L55;
        String r23 = r22.getLanguageCode();
    L56:
        BotEditParam r24 = this.editParam;
        if (r24 == null) goto L61;
        SpeakerVoice r25 = r24.getVoice();
        if (r25 == null) goto L61;
        String r26 = r25.getLanguageCode();
    L63:
        if (Intrinsics.areEqual(r23, r26) == false) goto L97;
        BotSwitchConfInfo r27 = r5.getSwitchConfInfo();
        if (r27 == null) goto L67;
        Boolean r28 = r27.getEnableWebSearch();
    L68:
        BotEditParam r29 = this.editParam;
        if (r29 == null) goto L71;
        Boolean r30 = r29.getEnableWebSearch();
    L73:
        if (Intrinsics.areEqual(r28, r30) == false) goto L97;
        BotSwitchConfInfo r31 = r5.getSwitchConfInfo();
        if (r31 == null) goto L77;
        Boolean r32 = r31.getEnablePicGen();
    L78:
        BotEditParam r33 = this.editParam;
        if (r33 == null) goto L81;
        Boolean r34 = r33.getEnableGenPic();
    L83:
        if (Intrinsics.areEqual(r32, r34) == false) goto L97;
        if (Intrinsics.areEqual(r5.getPrivateStatus(), this.privateStatus) == false) goto L97;
        ModelItem r35 = r5.getModel();
        BotEditParam r36 = this.editParam;
        if (r36 == null) goto L90;
        r3 = r36.getModelItem();
    L90:
        if (Intrinsics.areEqual(r35, r3) == false) goto L97;
        if (get_firstMetEditSubViewModel().y7() == true) goto L97;
        if (get_bioEditSubViewModel().Ol() == true) goto L97;
        if (hasEditBgImage(r5) == true) goto L97;
        return false;
    L81:
        r34 = null;
        goto L83
    L77:
        r32 = null;
        goto L78
    L71:
        r30 = null;
        goto L73
    L67:
        r28 = null;
    L61:
        r26 = null;
        goto L63
    L55:
        r23 = null;
    L49:
        r21 = null;
        goto L51
    L43:
        r18 = null;
        goto L44
    L37:
        r16 = null;
        goto L39
    L33:
        r14 = null;
        goto L34
    L27:
        r12 = null;
        goto L29
    L23:
        r10 = null;
        goto L24
    L17:
        r8 = null;
    L97:
        return true;
    L11:
        r4 = null;
        goto L13
    }

    public final boolean hasEditBgImage(BotModel r4) {
        Intrinsics.checkNotNullParameter(r4, "botInfo");
        if (this.canAddBgImage == false) goto L25;
        String r0 = r4.getBgImgUri();
        BgImage r2 = this.editParam.getBgImage();
        if (r2 == null) goto L7;
        String r3 = r2.bgImgUri;
    L9:
        if (Intrinsics.areEqual(r0, r3) == false) goto L23;
        BgImageInfo r5 = r4.getBgImgInfo();
        if (r5 == null) goto L15;
        Boolean r6 = r5.getBgImgOpen();
        if (r6 == null) goto L15;
        boolean r7 = r6.booleanValue();
    L16:
        Boolean r8 = Boolean.valueOf(r7);
        BgImage r1 = this.editParam.getBgImage();
        if (r1 == null) goto L20;
        Boolean r9 = r1.getBgImgOpen();
        if (r9 == null) goto L20;
    L22:
        if (Intrinsics.areEqual(r8, r9) == false) goto L23;
        return false;
    L20:
        r9 = Boolean.TRUE;
    L15:
        r7 = true;
    L23:
        return true;
    L7:
        r3 = null;
        goto L9
    L25:
        return false;
    }

    public final void initConversationId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        this.conversationId = r2;
    }

    public final void initEditParam(BotModel r51) {
        if (r51 != null) goto L5;
        return;
    L5:
        String r1 = r51.getBotId();
        if (r1 != null) goto L8;
        String r4 = "";
    L9:
        String r2 = r51.getName();
        if (r2 != null) goto L12;
        String r5 = "";
    L13:
        String r3 = r51.getDescriptionForHuman();
        if (r3 != null) goto L16;
        String r6 = "";
    L17:
        BotIconImage r7 = r51.getIconImage();
        if (r7 == null) goto L20;
        String r8 = r7.getOriginUrl();
    L21:
        if (r8 != null) goto L23;
        String r9 = "";
    L24:
        BotIconImage r10 = r51.getIconImage();
        if (r10 == null) goto L27;
        String r11 = r10.getUri();
    L28:
        if (r11 != null) goto L30;
        String r12 = "";
    L31:
        String r13 = r51.getIconPrompt();
        if (r13 != null) goto L34;
        String r14 = "";
    L35:
        ModelItem r15 = r51.getModel();
        if (r15 == null) goto L38;
        long r16 = r15.getModelType();
    L39:
        SpeakerVoice r17 = r51.getVoiceType();
        if (r17 != null) goto L42;
        r17 = new SpeakerVoice(null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, false, 0, 0, null, null, false, null, 0, null, 0, 0, 0.0f, 0.0f, null, false, null, null, Integer.MAX_VALUE, null);
    L42:
        SpeakerVoice r18 = r17;
        BotSwitchConfInfo r19 = r51.getSwitchConfInfo();
        if (r19 == null) goto L45;
        Boolean r110 = r19.getEnablePicGen();
    L46:
        BotSwitchConfInfo r20 = r51.getSwitchConfInfo();
        if (r20 == null) goto L49;
        Boolean r111 = r20.getEnableWebSearch();
    L50:
        ModelItem r112 = r51.getModel();
        boolean r21 = r51.getMuted();
        FirstMet r22 = r51.getFirstMet();
        if (r22 == null) goto L53;
        String r23 = r22.getPrologue();
    L54:
        FirstMet r24 = r51.getFirstMet();
        if (r24 == null) goto L57;
        Boolean r25 = r24.getSuggestSwitch();
    L58:
        FirstMet r26 = r51.getFirstMet();
        if (r26 == null) goto L63;
        List r27 = r26.getSuggests();
        if (r27 == null) goto L63;
        Triple<String, String, String> r28 = com.larus.bot.impl.feature.edit.feature.firstmet.k.d(r27);
    L65:
        if (this.canAddBgImage == false) goto L67;
        BgImage r29 = new BgImage(r51.getBgImgUri(), r51.getBgImgUrl(), r51.getBgImgColor(), r51.getBgImgInfo());
    L68:
        String r210 = r51.getUserBotGender();
        String r211 = r51.getUserBotType();
        BotIconImage r30 = r51.getIconImage();
        if (r30 == null) goto L71;
        String r31 = r30.getOriginUrl();
    L72:
        if (r31 != null) goto L74;
        String r212 = "";
    L75:
        String r32 = r51.getBgImgUrl();
        if (r32 != null) goto L78;
        String r213 = r2;
    L79:
        String r33 = r51.getBioEdit();
        if (r33 != null) goto L82;
        String r34 = r2;
    L83:
        this.editParam = new BotEditParam(r4, r5, r6, r34, r9, r12, r16, r18, null, r14, null, false, r111, r110, r112, Boolean.valueOf(r21), r23, r25, r28, r29, r211, r210, null, r212, r213, 4197632, null);
        Integer r35 = r51.getPrivateStatus();
        this.privateStatus = r35;
        this.originPrivateStatus = r35;
        return;
    L82:
        r34 = r33;
        goto L83
    L78:
        r213 = r32;
        goto L79
    L74:
        r212 = r31;
        goto L75
    L71:
        r31 = null;
        goto L72
    L67:
        r29 = null;
    L63:
        r28 = null;
        goto L65
    L57:
        r25 = null;
        goto L58
    L53:
        r23 = null;
        goto L54
    L49:
        r111 = null;
        goto L50
    L45:
        r110 = null;
        goto L46
    L38:
        r16 = 0;
        goto L39
    L34:
        r14 = r13;
        goto L35
    L30:
        r12 = r11;
        goto L31
    L27:
        r11 = null;
        goto L28
    L23:
        r9 = r8;
        goto L24
    L20:
        r8 = null;
        goto L21
    L16:
        r6 = r3;
        goto L17
    L12:
        r5 = r2;
        goto L13
    L8:
        r4 = r1;
        goto L9
    }

    public final void setBotInfo(BotModel r1) {
        this.botInfo = r1;
    }

    public final void setOriginPrivateStatus(Integer r1) {
        this.originPrivateStatus = r1;
    }

    public final void setPolishUseInternet(boolean r1) {
        this.polishUseInternet = r1;
    }

    public final void setPrivateStatus(Integer r1) {
        this.privateStatus = r1;
    }

    public final Object update(Continuation<? super Unit> r39) {
        if ((r39 instanceof AnonymousClass4) == false) goto L7;
        AnonymousClass4 r2 = (AnonymousClass4) r39;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r7 = false;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r1);
    L110:
        MutableLiveData<ub8.b> r6 = getUpdate();
        r6.postValue((ub8.b) r1);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r1);
    L22:
        if (((Boolean) r1).booleanValue() == false) goto L25;
        this._mainModel.b(false);
        FLogger.a.e(TAG, "interceptCreateProcess by bgImageModel");
        return Unit.INSTANCE;
    L25:
        UgcBotRepo r8 = this.botRepo;
        BotEditParam r9 = this.editParam;
        if (r9 == null) goto L31;
        String r10 = r9.getBotId();
        if (r10 == null) goto L31;
        String r11 = r10;
    L32:
        BotEditParam r12 = this.editParam;
        if (r12 == null) goto L38;
        String r13 = r12.getName();
        if (r13 == null) goto L38;
        String r14 = r13;
    L39:
        BotEditParam r15 = this.editParam;
        if (r15 == null) goto L45;
        String r16 = r15.getDescription();
        if (r16 == null) goto L45;
        String r17 = r16;
    L46:
        BotEditParam r18 = this.editParam;
        if (r18 == null) goto L52;
        String r19 = r18.getIconUri();
        if (r19 == null) goto L52;
        String r110 = r19;
    L53:
        BotEditParam r20 = this.editParam;
        if (r20 == null) goto L56;
        long r21 = r20.getModelType();
    L57:
        long r111 = r21;
        BotEditParam r22 = this.editParam;
        if (r22 == null) goto L62;
        SpeakerVoice r23 = r22.getVoice();
        if (r23 == null) goto L62;
        String r24 = r23.getId();
    L63:
        if (r24 != null) goto L65;
        String r25 = "";
    L66:
        BotEditParam r26 = this.editParam;
        if (r26 == null) goto L71;
        SpeakerVoice r27 = r26.getVoice();
        if (r27 == null) goto L71;
        String r28 = r27.getLanguageCode();
    L72:
        if (r28 != null) goto L74;
        r28 = "";
    L74:
        BotEditParam r29 = this.editParam;
        if (r29 == null) goto L79;
        SpeakerVoice r30 = r29.getVoice();
        if (r30 == null) goto L79;
        r7 = r30.isUgcVoice();
    L79:
        BotEditParam r31 = this.editParam;
        if (r31 == null) goto L82;
        Boolean r210 = r31.getEnableWebSearch();
    L83:
        BotEditParam r32 = this.editParam;
        if (r32 == null) goto L86;
        Boolean r211 = r32.getEnableGenPic();
    L87:
        BotUpdateType r33 = BotUpdateType.OTHERS;
        if (Intrinsics.areEqual(this.privateStatus, this.originPrivateStatus) == true) goto L90;
        Integer r112 = this.privateStatus;
    L91:
        BotEditParam r34 = this.editParam;
        if (r34 == null) goto L94;
        ModelItem r212 = r34.getModelItem();
    L95:
        BotEditParam r35 = this.editParam;
        if (r35 == null) goto L98;
        Boolean r113 = r35.getMuted();
    L99:
        FirstMet r213 = get_firstMetEditSubViewModel().getFirstMetData();
        BgImage r36 = this.editParam.getBgImage();
        if (r36 == null) goto L102;
        String r214 = r36.bgImgUri;
    L103:
        BgImage r37 = this.editParam.getBgImage();
        if (r37 == null) goto L106;
        BgImageInfo r215 = r37.bgImageInfo;
    L107:
        String r38 = this.editParam.getOriginalUserImgUri();
        String r310 = get_bioEditSubViewModel().R();
        boolean r114 = hasUsedPolishDesc();
        boolean r311 = hasUsedPolishDesc();
        String r115 = r28;
        uc9.s r40 = new uc9.s(r33, r11, r14, r17, r110, Boxing.boxLong(r111), r115, null, r112, r113, r25, null, null, Boxing.boxBoolean(r7), r210, r211, r212, r213, r214, r215, r38, r310, null, null, Boxing.boxBoolean(r114), Boxing.boxBoolean(r311), 12589184);
        r2.label = 2;
        r8.getClass();
        CompletableDeferred r41 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        com.larus.im.d.a().updateBot(r40, new com.larus.bot.impl.repository.g(r41));
        r1 = r41.await(r2);
        if (r1 != r4) goto L110;
        return r4;
    L106:
        r215 = null;
        goto L107
    L102:
        r214 = null;
        goto L103
    L98:
        r113 = null;
        goto L99
    L94:
        r212 = null;
        goto L95
    L90:
        r112 = null;
        goto L91
    L86:
        r211 = null;
        goto L87
    L82:
        r210 = null;
    L71:
        r28 = null;
        goto L72
    L65:
        r25 = r24;
    L62:
        r24 = null;
        goto L63
    L56:
        r21 = 0;
    L52:
        r110 = "";
    L45:
        r17 = "";
    L38:
        r14 = "";
    L31:
        r11 = "";
        goto L32
    L16:
        ResultKt.throwOnFailure(r1);
        if (this.canAddBgImage == false) goto L25;
        com.larus.bot.impl.feature.edit.feature.bgimage.t r42 = get_bgImageModel();
        r2.label = 1;
        r1 = r42.i(r2);
        if (r1 != r4) goto L22;
        return r4;
    L7:
        r2 = new AnonymousClass4(this, r39);
        goto L8
    }

    public final void updateAvatarPrompt(String r2) {
        if (r2 == null) goto L7;
        BotEditParam r0 = this.editParam;
        if (r0 == null) goto L8;
        r0.setAvatarPrompt(r2);
        return;
    L8:
        return;
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
    }

    public final void updateDescription(String r3) {
        Intrinsics.checkNotNullParameter(r3, "description");
        BotEditParam r0 = this.editParam;
        if (r0 == null) goto L5;
        r0.setDescription(r3);
    L5:
        checkCreateParam();
        if (r3.length() <= 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == true) goto L11;
    L17:
        this._descPolishBtnStatus.postValue(DescPolishBtnStatus.DISABLE);
        MutableLiveData<DescPolishStatus> r5 = this._descPolishStatus;
        if (this.isDescGenerating == false) goto L20;
        DescPolishStatus r1 = DescPolishStatus.IN_POLISH;
    L21:
        r5.postValue(r1);
    L22:
        this.isPolishUndo = false;
        return;
    L20:
        r1 = DescPolishStatus.BEFORE_POLISH;
        goto L21
    L11:
        if (this.isDescGenerating == true) goto L17;
        this._descPolishBtnStatus.postValue(DescPolishBtnStatus.ENABLE);
        MutableLiveData<DescPolishStatus> r6 = this._descPolishStatus;
        if (this.isDescGenerating == false) goto L15;
        DescPolishStatus r2 = DescPolishStatus.IN_POLISH;
    L16:
        r6.postValue(r2);
        goto L22
    L15:
        r2 = DescPolishStatus.BEFORE_POLISH;
        goto L16
    L8:
        r4 = false;
        goto L9
    }

    public final void updateEnableGenPic(Boolean r2) {
        BotEditParam r0 = this.editParam;
        if (r0 == null) goto L6;
        r0.setEnableGenPic(r2);
        return;
    }

    public final void updateEnableWebSearch(Boolean r2) {
        BotEditParam r0 = this.editParam;
        if (r0 == null) goto L6;
        r0.setEnableWebSearch(r2);
        return;
    }

    public final void updateModel(ModelItem r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        BotEditParam r0 = this.editParam;
        if (r0 == null) goto L6;
        r0.setModelItem(r2);
        return;
    }

    public final void updateModelType(long r2) {
        BotEditParam r0 = this.editParam;
        if (r0 == null) goto L6;
        r0.setModelType(r2);
        return;
    }

    public final void updateName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        BotEditParam r0 = this.editParam;
        if (r0 == null) goto L5;
        r0.setName(r2);
    L5:
        checkCreateParam();
    }

    public final void updateOriginBackgroundImgUri(String r2) {
        this.editParam.setOriginalBackgroundImgUri(r2);
    }

    public final void updateOriginalImgUri(String r2) {
        this.editParam.setOriginalAvatarImgUri(r2);
    }

    public final void updateOriginalUserImgUri(String r2) {
        this.editParam.setOriginalUserImgUri(r2);
    }

    public final void updatePrologue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "prologue");
        this.editParam.setPrologue(r2);
    }

    public final void updateSuggestSwitch(boolean r2) {
        this.editParam.setSuggestSwitch(Boolean.valueOf(r2));
    }

    public final void updateSuggests(Triple<String, String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "suggests");
        this.editParam.setSuggests(r2);
    }

    private static final BotAvatarEditViewModel _avatarModel_delegate$lambda$6(Application r3, BotUpdateViewModel r4) {
        return new BotAvatarEditViewModel(r3, ViewModelKt.getViewModelScope(r4), new b(r4));
    }

    public static final /* synthetic */ void access$setDescGenerating$p(BotUpdateViewModel r0, boolean r1) {
        r0.isDescGenerating = r1;
    }

    public static final /* synthetic */ void access$setPolishCnt$p(BotUpdateViewModel r0, int r1) {
        r0.polishCnt = r1;
    }

    private final String getCommonContentSourceRequestData(List<String> r3, List<String> r4) {
        Integer r0 = null;
        if (r4 == null) goto L5;
        String r1 = (String) CollectionsKt.firstOrNull(r4);
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        ContentSource r5 = ContentSource.NOT_ENTERED;
    L30:
        return r5.getValue();
    L14:
        if (r3 == null) goto L16;
        Integer r6 = Integer.valueOf(r3.size());
    L17:
        if (r4 == null) goto L20;
        r0 = Integer.valueOf(r4.size());
    L20:
        if (Intrinsics.areEqual(r6, r0) == false) goto L28;
        if (r3 != null) goto L23;
        r3 = CollectionsKt.emptyList();
    L23:
        if (r4 != null) goto L26;
        r4 = CollectionsKt.emptyList();
    L26:
        if (r3.containsAll(r4) == false) goto L28;
        r5 = ContentSource.MODEL_GENERATED;
    L28:
        r5 = ContentSource.USER_INPUT;
        goto L30
    L16:
        r6 = null;
        goto L17
    L8:
        if (StringsKt.isBlank(r1) == true) goto L11;
        r2 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    private final EnrichBotData mergeHeadAndBgImgEnrichRequestData(EnrichBotData r4, EnrichBotData r5) {
        if (r5 == null) goto L5;
        String r1 = r5.contentSource;
    L7:
        if (Intrinsics.areEqual(r1, ContentSource.USER_INPUT.getValue()) == false) goto L16;
        List<String> r2 = r5.content;
        if (r2 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L16;
    L17:
        r4 = r5;
    L18:
        if (r4 == null) goto L21;
        r4.contentType = ContentType.BG_IMG_PROMPT.getValue();
        return r4;
    L21:
        return null;
    L11:
        if (r2.isEmpty() == true) goto L14;
        r3 = false;
    L16:
        if (r4 != null) goto L18;
    L5:
        r1 = null;
        goto L7
    }

    public final void updateIconUri(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "iconUrl");
        Intrinsics.checkNotNullParameter(r3, "iconUri");
        BotEditParam r0 = this.editParam;
        if (r0 == null) goto L5;
        r0.setIconUrl(r2);
    L5:
        BotEditParam r4 = this.editParam;
        if (r4 == null) goto L8;
        r4.setIconUri(r3);
    L8:
        checkCreateParam();
    }

    public final BotModel updateResult(BotModel r71, BotModel r72) {
        if (r71 == null) goto L5;
        BotEditParam r1 = this.editParam;
        if (r1 == null) goto L9;
        if (r1 == null) goto L42;
        String r3 = r1.getName();
        String r15 = r1.getDescription();
        BotIconImage r18 = new BotIconImage(r1.getIconUri(), null, r1.getIconUrl(), null, null, 26, null);
        SpeakerVoice r20 = r1.getVoice();
        String r39 = r1.getAvatarPrompt();
        BotSwitchConfInfo r4 = new BotSwitchConfInfo(r1.getEnableWebSearch(), r1.getEnableGenPic());
        Integer r14 = this.privateStatus;
        ModelItem r19 = r1.getModelItem();
        Boolean r2 = r1.getMuted();
        if (r2 == null) goto L14;
        boolean r22 = r2.booleanValue();
    L15:
        String r5 = null;
        if (r72 == null) goto L18;
        FirstMet r46 = r72.getFirstMet();
    L19:
        if (r72 == null) goto L21;
        String r36 = r72.getBgImgUrl();
    L22:
        if (r72 == null) goto L24;
        String r49 = r72.getBgImgUri();
    L25:
        if (r72 == null) goto L27;
        String r37 = r72.getBgImgColor();
    L28:
        if (r72 == null) goto L30;
        BgImageInfo r50 = r72.getBgImgInfo();
    L31:
        if (r72 == null) goto L33;
        String r51 = r72.getUserBotGender();
    L34:
        if (r72 == null) goto L36;
        String r52 = r72.getUserBotType();
    L37:
        if (r72 == null) goto L40;
        r5 = r72.getBioEdit();
    L40:
        return BotModel.copy$default(r71, null, r3, r18, 0, null, null, null, null, null, null, null, null, r15, null, null, r14, r19, r20, null, r22, null, null, null, r5, null, null, null, null, null, null, null, null, 0, r36, r37, null, r39, r4, null, null, null, null, false, r46, null, null, r49, r50, r51, r52, null, null, null, null, null, null, null, null, null, null, null, null, null, -9146375, 2147235785, null);
    L36:
        r52 = null;
        goto L37
    L33:
        r51 = null;
        goto L34
    L30:
        r50 = null;
        goto L31
    L27:
        r37 = null;
        goto L28
    L24:
        r49 = null;
        goto L25
    L21:
        r36 = null;
        goto L22
    L18:
        r46 = null;
        goto L19
    L14:
        r22 = false;
        goto L15
    L42:
        return new BotModel("", null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
    L9:
        return new BotModel("", null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
    L5:
        return new BotModel("", null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
    }

    public final void updateVoice(SpeakerVoice r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "voice");
        BotEditParam r0 = this.editParam;
        if (r0 == null) goto L5;
        r0.setVoice(r2);
    L5:
        checkCreateParam();
        if (r3 == false) goto L9;
        get_firstMetEditSubViewModel().ej();
        return;
    }

    public static /* synthetic */ void updateVoice$default(BotUpdateViewModel r0, SpeakerVoice r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.updateVoice(r1, r2);
    }
}
