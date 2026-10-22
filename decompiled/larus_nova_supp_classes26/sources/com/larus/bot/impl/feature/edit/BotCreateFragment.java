package com.larus.bot.impl.feature.edit;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.router.SmartRouter;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.audio.bean.GetMatchVoiceRequest;
import com.larus.audio.bean.RecommendScene;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.view.item.ItemLongTextArrow;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bot.impl.bean.ContentType;
import com.larus.bot.impl.databinding.LarusLayoutBotBioEditBinding;
import com.larus.bot.impl.databinding.LarusLayoutBotEditAvatarBinding;
import com.larus.bot.impl.databinding.LarusLayoutBotEditBgImageBinding;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;
import com.larus.bot.impl.feature.edit.feature.autofill.BotAutoFillUIBinder;
import com.larus.bot.impl.feature.edit.feature.avatar.BotAvatarEditView;
import com.larus.bot.impl.feature.edit.feature.bgimage.BotBgImageEditView;
import com.larus.bot.impl.feature.edit.view.BotEditScrollView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import com.larus.settings.value.e10;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.FragmentExtKt;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Job;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000°\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 «\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002«\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u00100\u001a\u0004\u0018\u000101H\u0016J\n\u0010U\u001a\u0004\u0018\u00010VH\u0016J\n\u0010W\u001a\u0004\u0018\u00010XH\u0016J\b\u0010G\u001a\u00020HH\u0016J\u0010\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020HH\u0016J\b\u0010E\u001a\u00020FH\u0016J\u0010\u0010\\\u001a\u00020Z2\u0006\u0010[\u001a\u00020FH\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010]\u001a\u00020\u0011H\u0016J\u0012\u0010^\u001a\u00020Z2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J&\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010f2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\b\u0010g\u001a\u00020ZH\u0002J\u001a\u0010h\u001a\u00020Z2\u0006\u0010i\u001a\u00020b2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0010\u0010j\u001a\u00020Z2\u0006\u0010k\u001a\u00020\u001aH\u0002J\b\u0010l\u001a\u00020ZH\u0002J\b\u0010m\u001a\u00020ZH\u0002J\u0018\u0010n\u001a\u00020Z2\u0006\u0010c\u001a\u00020d2\u0006\u0010o\u001a\u00020pH\u0002J\b\u0010q\u001a\u00020rH\u0002J\b\u0010s\u001a\u00020ZH\u0002J\u001e\u0010t\u001a\u00020Z2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020v2\u0006\u0010x\u001a\u00020`J\u0010\u0010y\u001a\u00020Z2\u0006\u0010x\u001a\u00020`H\u0002J\u0010\u0010z\u001a\u00020Z2\u0006\u0010x\u001a\u00020`H\u0002J\b\u0010{\u001a\u00020ZH\u0002J\u0010\u0010|\u001a\u00020Z2\u0006\u0010}\u001a\u00020~H\u0002J\u001b\u0010\u007f\u001a\u00020Z2\u0007\u0010\u0080\u0001\u001a\u00020\u001a2\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0002J\u0012\u0010\u0083\u0001\u001a\u00020Z2\u0007\u0010\u0084\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u0085\u0001\u001a\u00020\u001aH\u0016J\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010ZH\u0002¢\u0006\u0003\u0010\u0087\u0001J\t\u0010\u0088\u0001\u001a\u00020ZH\u0016J\t\u0010\u0089\u0001\u001a\u00020ZH\u0002J\t\u0010\u008a\u0001\u001a\u00020ZH\u0002J\t\u0010\u008b\u0001\u001a\u00020ZH\u0002J\t\u0010\u008c\u0001\u001a\u00020ZH\u0002J\t\u0010\u008d\u0001\u001a\u00020ZH\u0002J\t\u0010\u008e\u0001\u001a\u00020ZH\u0002J\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010ZH\u0002¢\u0006\u0003\u0010\u0087\u0001J\u0011\u0010\u0090\u0001\u001a\u0004\u0018\u00010ZH\u0002¢\u0006\u0003\u0010\u0087\u0001J\u0011\u0010\u0091\u0001\u001a\u0004\u0018\u00010ZH\u0002¢\u0006\u0003\u0010\u0087\u0001J\u0011\u0010\u0092\u0001\u001a\u0004\u0018\u00010ZH\u0002¢\u0006\u0003\u0010\u0087\u0001J\t\u0010\u0093\u0001\u001a\u00020ZH\u0002J\t\u0010\u0094\u0001\u001a\u00020ZH\u0002J\u0011\u0010\u0095\u0001\u001a\u0004\u0018\u00010ZH\u0002¢\u0006\u0003\u0010\u0087\u0001J\u0011\u0010\u0096\u0001\u001a\u0004\u0018\u00010ZH\u0002¢\u0006\u0003\u0010\u0087\u0001J\t\u0010\u0097\u0001\u001a\u00020ZH\u0016J\t\u0010\u0098\u0001\u001a\u00020ZH\u0016J>\u0010\u0099\u0001\u001a\u00020Z*\u00030\u009a\u00012\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u00012\u0007\u0010\u009d\u0001\u001a\u00020\u00112\u0007\u0010\u009e\u0001\u001a\u00020v2\u0007\u0010\u009f\u0001\u001a\u00020v2\u0007\u0010 \u0001\u001a\u00020vH\u0002JV\u0010¡\u0001\u001a\u00020Z*\u00030¢\u00012\u0007\u0010£\u0001\u001a\u00020\u00112=\u0010¤\u0001\u001a8\u0012\u0016\u0012\u00140\u0011¢\u0006\u000f\b¦\u0001\u0012\n\b§\u0001\u0012\u0005\b\b(£\u0001\u0012\u0015\u0012\u00130`¢\u0006\u000e\b¦\u0001\u0012\t\b§\u0001\u0012\u0004\b\b(x\u0012\u0004\u0012\u00020Z0¥\u0001H\u0002J\t\u0010¨\u0001\u001a\u00020\u0011H\u0016J\t\u0010©\u0001\u001a\u00020\u001aH\u0016J\t\u0010ª\u0001\u001a\u00020ZH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001b\u0010#\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\r\u001a\u0004\b$\u0010\"R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010@\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\r\u001a\u0004\bA\u0010BR\u000e\u0010D\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010I\u001a\r\u0012\t\u0012\u00070K¢\u0006\u0002\bL0J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\r\u001a\u0004\bM\u0010NR\u001b\u0010P\u001a\u00020Q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\r\u001a\u0004\bR\u0010S¨\u0006¬\u0001"}, d2 = {"Lcom/larus/bot/impl/feature/edit/BotCreateFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "Lcom/larus/bot/impl/feature/ability/IBotCreateAbility;", "<init>", "()V", "binding", "Lcom/larus/bot/impl/databinding/LarusPageBotEditBinding;", "createViewModel", "Lcom/larus/bot/impl/feature/edit/BotCreateViewModel;", "getCreateViewModel", "()Lcom/larus/bot/impl/feature/edit/BotCreateViewModel;", "createViewModel$delegate", "Lkotlin/Lazy;", "launchInfo", "Lcom/larus/bmhome/auth/LaunchInfo;", "enterFrom", "", "enterMethod", "nameLoadingAnimation", "Landroid/animation/ObjectAnimator;", "descLoadingAnimation1", "descLoadingAnimation2", "backPressCallback", "Landroidx/activity/OnBackPressedCallback;", "isLoadingDialogShow", "", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "voiceLanguageCode", "getVoiceLanguageCode", "()Ljava/lang/String;", "mutedVoiceName", "getMutedVoiceName", "mutedVoiceName$delegate", "updateConfig", "Lcom/larus/bot/impl/feature/edit/config/BotUpdateConfig;", "languageList", "", "Lcom/larus/bmhome/bot/bean/BotLanguage;", "initLanguage", "selectedLanguage", "voiceList", "Lcom/larus/im/bean/bot/SpeakerVoice;", "selectedVoice", "imeManager", "Lcom/larus/bmhome/utils/ImeManager;", "avatarEditView", "Lcom/larus/bot/impl/feature/edit/feature/avatar/IBotAvatarEditView;", "firstMetEditView", "Lcom/larus/bot/impl/feature/edit/feature/firstmet/BotFirstMetEditView;", "bioEditView", "Lcom/larus/bot/impl/feature/edit/feature/bio/BotBioEditView;", "voiceItem", "Lcom/larus/bmhome/view/item/ItemTextArrow;", "languageItem", "permissionItem", "Lcom/larus/bmhome/view/item/ItemLongTextArrow;", "ignoreCreateVoiceResult", "settingRepo", "Lcom/larus/bmhome/chat/model/repo/ISettingRepoService;", "canAddBgImage", "getCanAddBgImage", "()Z", "canAddBgImage$delegate", "enableAdvance", "lastPolishEnable", "Lcom/larus/bot/impl/feature/edit/DescPolishBtnStatus;", "lastPolishStatus", "Lcom/larus/bot/impl/feature/edit/DescPolishStatus;", "autoFillBtnViewStub", "Lcom/larus/common_ui/view/ViewStubManager;", "Lcom/larus/bot/impl/databinding/LarusLayoutAutoFillBtnBinding;", "Lkotlin/jvm/internal/EnhancedNullability;", "getAutoFillBtnViewStub", "()Lcom/larus/common_ui/view/ViewStubManager;", "autoFillBtnViewStub$delegate", "ugcVoiceService", "Lcom/larus/voice_setting/IUgcVoiceService;", "getUgcVoiceService", "()Lcom/larus/voice_setting/IUgcVoiceService;", "ugcVoiceService$delegate", "botMainEditViewModel", "Lcom/larus/bot/impl/feature/edit/feature/main/IBotMainEditViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "updateLastPolishStatus", "", "status", "updateLastPolishEnable", "getCurrentPage", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "attachComponent", "onViewCreated", "view", "setupAdvanceSetting", "advanceMode", "bindObservers", "addAutoFillBtnView", "addAvatarView", "avatarContainer", "Landroid/widget/FrameLayout;", "getMatchVoiceRequest", "Lcom/larus/audio/bean/GetMatchVoiceRequest;", "setupResultListener", "onResult", "requestCode", "", "resultCode", "bundle", "updateLanguageResult", "updateSpeakerResult", "updateSpeakerName", "refreshAutoFilledData", "itemData", "Lcom/larus/bot/impl/feature/edit/feature/autofill/model/AutoFillItemData;", "refreshAutoFillGeneratingStatus", "isGenerating", "type", "Lcom/larus/bot/impl/bean/ContentType;", "refreshAutoFilledVoice", "voiceId", "isEdited", "setupAvatar", "()Lkotlin/Unit;", "onStop", "showNameLoading", "hideNameLoading", "showDescLoading", "hideDescLoading", "showVoiceItemLoading", "hideVoiceItemLoading", "setupFirstMetEdit", "setupBioEdit", "setupLanguage", "setupVoice", "setupVoiceFromBotMaker", "openVoiceChoosePage", "setupAccessPermission", "updateAccessPermission", "onDestroyView", "onDestroy", "showAutoGenDescWithAnim", "Landroid/widget/EditText;", "context", "Landroid/content/Context;", ShareType.TEXT, "horizontalMargin", "minHeight", "maxHeight", "setFragmentResultListener", "Landroidx/fragment/app/Fragment;", "requestKey", "listener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getCurrentPageName", "autoLogEnterPage", "logEnterPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotCreateFragment extends TraceFragment implements ru8.e, ru8.a {
    public static final /* synthetic */ int J = 0;
    public ItemLongTextArrow A;
    public boolean B;
    public final ISettingRepoService C;
    public final Lazy D;
    public final boolean E;
    public DescPolishBtnStatus F;
    public DescPolishStatus G;
    public final Lazy H;
    public final Lazy I;
    public LarusPageBotEditBinding e;
    public final Lazy f;
    public String g;
    public String h;
    public ObjectAnimator i;
    public ObjectAnimator j;
    public ObjectAnimator k;
    public FragmentExtKt.addOnBackPressed.callback.1 l;
    public boolean m;
    public final Lazy n;
    public final Lazy o;
    public vu8.a p;
    public List<BotLanguage> q;
    public BotLanguage r;
    public BotLanguage s;
    public List<SpeakerVoice> t;
    public SpeakerVoice u;
    public com.larus.bmhome.utils.x1 v;
    public com.larus.bot.impl.feature.edit.feature.avatar.u w;
    public com.larus.bot.impl.feature.edit.feature.firstmet.h x;
    public ItemTextArrow y;
    public ItemTextArrow z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ContentType.values().length];
            r0[ContentType.NAME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ContentType.DESC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ContentType.VOICE_ID.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ BotCreateFragment b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r1) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r7) {
            this.a.removeOnAttachStateChangeListener(this);
            WindowInsetsCompat r8 = ViewCompat.getRootWindowInsets(r7);
            if (r8 == null) goto L35;
            Insets r9 = r8.getInsets(WindowInsetsCompat.Type.navigationBars());
            if (r9 == null) goto L36;
            LarusPageBotEditBinding r0 = this.b.e;
            ViewGroup.MarginLayoutParams r1 = null;
            if (r0 == null) goto L21;
            BotEditScrollView r2 = r0.J;
            if (r2 == null) goto L21;
            ViewGroup.LayoutParams r3 = r2.getLayoutParams();
            if (r3 == null) goto L20;
            if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
            ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        L16:
            if (r4 == null) goto L18;
            r4.bottomMargin = r9.bottom;
        L18:
            r2.setLayoutParams(r3);
            goto L21
        L15:
            r4 = null;
            goto L16
        L20:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        L21:
            LarusPageBotEditBinding r5 = this.b.e;
            if (r5 == null) goto L37;
            ConstraintLayout r6 = r5.h;
            if (r6 == null) goto L38;
            ViewGroup.LayoutParams r10 = r6.getLayoutParams();
            if (r10 == null) goto L34;
            if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L30;
            r1 = (ViewGroup.MarginLayoutParams) r10;
        L30:
            if (r1 == null) goto L32;
            r1.bottomMargin = r9.bottom;
        L32:
            r6.setLayoutParams(r10);
            return;
        L34:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        L38:
            return;
        L37:
            return;
        L36:
            return;
        }

        public c(ConstraintLayout r1, BotCreateFragment r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    @Override // ru8.a
    public final String getCurrentPage() {
        return "bot_create_page";
    }

    public final String k() {
        return "bot_create_page";
    }

    public final void T90() {
        boolean r1 = false;
        if ("bot_create_page".length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 != true) goto L8;
        r1 = true;
    L8:
        if (r1 == false) goto L11;
        String r20 = V90().getBotCreateTrace().c();
        tx9.a1.c(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "bot_create_page", V90().getBotCreateTrace().o(), null, null, null, r20, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, this, null, null, null, null, null, null, null, 2145910783, -16777217, 7);
        return;
    L11:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean U90() {
        return ((Boolean) this.D.getValue()).booleanValue();
    }

    public final BotCreateViewModel V90() {
        return (BotCreateViewModel) this.f.getValue();
    }

    public final GetMatchVoiceRequest W90() {
        GetMatchVoiceRequest r10 = new GetMatchVoiceRequest(null, null, null, null, 0, null, RecommendScene.BOT_CREATE, 63);
        String r0 = V90().getEditParam().getName();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r10.a = r0;
        String r1 = V90().getEditParam().getDescription();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r10.b = r1;
        SpeakerVoice r2 = this.u;
        String r3 = "";
        if (r2 == null) goto L6;
        String r4 = r2.getId();
        if (r4 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r10.c = r4;
        String r5 = V90().getEditParam().getBotId();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r10.d = r5;
        r10.e = V90().getEditParam().getModelType();
        SpeakerVoice r6 = this.u;
        if (r6 == null) goto L13;
        String r7 = r6.getLanguageCode();
        if (r7 == null) goto L13;
    L12:
        r3 = r7;
    L18:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r10.f = r3;
        return r10;
    L13:
        BotLanguage r8 = this.r;
        if (r8 == null) goto L16;
        r7 = r8.c();
    L17:
        if (r7 != null) goto L12;
    L16:
        r7 = null;
    L6:
        r4 = "";
        goto L7
    }

    public final String X90() {
        SpeakerVoice r0 = this.u;
        if (r0 == null) goto L6;
        String r1 = r0.getLanguageCode();
        if (r1 == null) goto L6;
        return r1;
    L6:
        BotLanguage r2 = this.r;
        if (r2 == null) goto L9;
        String r3 = r2.c();
    L10:
        if (r3 != null) goto L14;
        return "";
    L14:
        return r3;
    L9:
        r3 = null;
        goto L10
    }

    public final void Y90() {
        FLogger.a.i("BotCreateFragment", "hideVoiceItemLoading");
        ItemTextArrow r0 = this.y;
        if (r0 == null) goto L6;
        r0.V5();
        return;
    }

    public final void ba0() {
        ItemLongTextArrow r0 = this.A;
        if (r0 == null) goto L16;
        int r1 = V90().getPrivateStatus();
        if (r1 != 1) goto L7;
        r0.setImageSrc(2131240935);
        r0.setText(getString(2131908271));
    L14:
        Unit r2 = Unit.INSTANCE;
        return;
    L7:
        if (r1 != 2) goto L9;
        r0.setImageSrc(2131240934);
        r0.setText(getString(2131908270));
        goto L14
    L9:
        if (r1 != 3) goto L14;
        r0.setImageSrc(2131240936);
        r0.setText(getString(2131910873));
        goto L14
    }

    public final void ca0() {
        IAIChatService.a.g7(getContext(), this.y, this.u, false);
        BotCreateViewModel r0 = V90();
        ContentType r1 = ContentType.VOICE_ID;
        SpeakerVoice r2 = V90().getEditParam().getVoice();
        if (r2 == null) goto L6;
        String r3 = r2.getId();
        if (r3 == null) goto L6;
    L7:
        r0.onBotInfoChanged(r1, !Intrinsics.areEqual(r3, TriggerSendLoading.NO_LOADING));
        return;
    L6:
        r3 = TriggerSendLoading.NO_LOADING;
        goto L7
    }

    public final void onDestroy() {
        FragmentExtKt.addOnBackPressed.callback.1 r0 = this.l;
        if (r0 == null) goto L5;
        r0.remove();
    L5:
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public final void onStop() {
        if (z2.a.o3().a(X90()) == true) goto L5;
    L23:
        super/*androidx.fragment.app.Fragment*/.onStop();
        return;
    L5:
        if (this.C.q() == false) goto L23;
        SpeakerVoice r0 = this.u;
        if (r0 == null) goto L9;
        String r1 = r0.getName();
    L10:
        if (r1 != null) goto L12;
    L15:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L23;
        ItemTextArrow r3 = this.y;
        if (r3 == null) goto L20;
        r3.U5();
    L20:
        ItemTextArrow r4 = this.y;
        if (r4 == null) goto L23;
        String r5 = (String) this.o.getValue();
        int r6 = ItemTextArrow.k;
        r4.Z5(r5, null);
        goto L23
    L12:
        if (r1.length() == 0) goto L15;
        r2 = false;
        goto L16
    L9:
        r1 = null;
        goto L10
    }

    @Override // ru8.e
    public final com.larus.common_ui.dialog.l0 uL() {
        return (com.larus.common_ui.dialog.l0) this.n.getValue();
    }

    public BotCreateFragment() {
        final Function0<Fragment> r0 = new BotCreateFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BotCreateViewModel.class), new BotCreateFragment$special$$inlined$viewModels$default$2(r0), new BotCreateFragment$special$$inlined$viewModels$default$3(r0, this));
        this.g = "";
        this.h = "";
        this.n = LazyKt.lazy(new w(this));
        this.o = LazyKt.lazy(new x(this));
        this.C = RepoDispatcherDelegate.b.c();
        this.D = LazyKt.lazy(new y(this));
        e10 r1 = e10.a;
        this.E = e10.D().enableAdvance;
        this.F = DescPolishBtnStatus.DISABLE;
        this.G = DescPolishStatus.BEFORE_POLISH;
        this.H = LazyKt.lazy(new z(this));
        this.I = LazyKt.lazy(new a0());
    }

    public final void Z90() {
        com.bytedance.router.i r0 = SmartRouter.buildRoute(getContext(), "//flow/single_tts_speaker_setting");
        Pair[] r1 = new Pair[6];
        r1[0] = TuplesKt.to("key_ui_mode", Boolean.TRUE);
        BotLanguage r2 = this.s;
        if (r2 == null) goto L5;
        String r3 = r2.c();
    L6:
        r1[1] = TuplesKt.to("key_language_code", r3);
        r1[2] = TuplesKt.to("key_initial_voice", this.u);
        r1[3] = TuplesKt.to("enter_from", "bot_create_page");
        r1[4] = TuplesKt.to("key_enter_method", "bot_create_page");
        r1[5] = TuplesKt.to("key_voice_recommend_param", W90());
        Bundle r4 = com.larus.utils.f.c(r1);
        by7.h.k(r4, this);
        r0.c.putExtras(r4);
        r0.c.addFlags(536870912);
        r0.d = 2130772401;
        r0.e = 2130772399;
        r0.e(100);
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // ru8.a
    public final BotCreateViewModel a1() {
        return V90();
    }

    @Override // ru8.a
    public final boolean na() {
        boolean r0 = V90().checkUserEdited(true, true);
        SpeakerVoice r2 = this.u;
        if (r2 == null) goto L5;
        String r3 = r2.getId();
    L7:
        if (Intrinsics.areEqual(r3, TriggerSendLoading.NO_LOADING) == false) goto L9;
    L11:
        boolean r4 = false;
    L12:
        boolean r5 = !Intrinsics.areEqual(this.s, this.r);
        if (V90().getPrivateStatus() == V90().defaultPrivateStatus()) goto L15;
        boolean r6 = true;
    L16:
        FLogger.a.i("BotCreateFragment", "isUserEdited=" + r0 + ", isSelectedVoice=" + r4 + ", isSelectedLanguage=" + r5 + ", isSelectedPrivateStatus=" + r6);
        if (r0 == true) goto L24;
        if (r4 == true) goto L25;
        if (r5 == true) goto L26;
        if (r6 == true) goto L27;
        return false;
    L27:
        return true;
    L26:
        return true;
    L25:
        return true;
    L24:
        return true;
    L15:
        r6 = false;
        goto L16
    L9:
        if (this.u == null) goto L11;
        r4 = true;
        goto L12
    L5:
        r3 = null;
        goto L7
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.e = null;
    }

    @Override // ru8.e
    public final LifecycleOwner s4() {
        return getViewLifecycleOwner();
    }

    @Override // ru8.e
    public final com.larus.bot.impl.feature.edit.feature.main.c uk() {
        return V90().getMainEditViewModel();
    }

    @Override // ru8.e
    public final DescPolishBtnStatus Gy() {
        return this.F;
    }

    @Override // ru8.a
    public final String Wc() {
        return this.h;
    }

    @Override // ru8.e
    public final LarusPageBotEditBinding e() {
        return this.e;
    }

    @Override // ru8.e
    public final DescPolishStatus en() {
        return this.G;
    }

    @Override // ru8.a
    public final boolean ge() {
        return this.m;
    }

    @Override // ru8.e
    public final com.larus.bmhome.utils.x1 jZ() {
        return this.v;
    }

    @Override // ru8.a
    public final String n6() {
        return this.g;
    }

    @Override // ru8.e
    public final void I90(DescPolishBtnStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "status");
        this.F = r2;
    }

    public final void aa0(String r13) {
        List<SpeakerVoice> r0 = this.t;
        boolean r1 = true;
        String r3 = null;
        if (r0 == null) goto L21;
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L19;
        Object r4 = r2.next();
        SpeakerVoice r5 = (SpeakerVoice) r4;
        if (Intrinsics.areEqual(r5.getId(), r13) == false) goto L16;
        BotLanguage r6 = this.s;
        if (r6 == null) goto L12;
        String r7 = r6.c();
    L14:
        if (Intrinsics.areEqual(r7, r5.getLanguageCode()) == false) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L6;
    L20:
        SpeakerVoice r9 = (SpeakerVoice) r4;
    L22:
        String r10 = "";
        if (r9 == null) goto L31;
        FLogger.a.i("BotCreateFragment", "ai gen voiceId=" + r13 + ", name=" + r9.getName() + ", matched launch voiceList");
        this.u = r9;
        BotCreateViewModel.updateVoice$default(V90(), r9, false, 2, null);
        ItemTextArrow r14 = this.y;
        if (r14 == null) goto L67;
        String r11 = r9.getName();
        if (r11 == null) goto L30;
        r10 = r11;
    L30:
        int r12 = ItemTextArrow.k;
        r14.Z5(r10, null);
    L67:
        V90().onBotInfoChanged(ContentType.VOICE_ID, false);
        p2a.a r15 = IAIChatService.a.u7();
        if (r15 == null) goto L74;
        p2a.p r16 = r15.c();
        if (r16 == null) goto L74;
        if (r16.a != true) goto L74;
    L75:
        if (r1 == false) goto L90;
        p2a.f r17 = (p2a.f) this.I.getValue();
        if (r17 == null) goto L91;
        r17.d1(p2a.l.a(W90()), false);
        return;
    L91:
        return;
    L90:
        return;
    L74:
        r1 = false;
        goto L75
    L31:
        List<SpeakerVoice> r18 = this.t;
        if (r18 == null) goto L50;
        Iterator<T> r19 = r18.iterator();
    L35:
        if (r19.hasNext() == false) goto L48;
        Object r20 = r19.next();
        SpeakerVoice r21 = (SpeakerVoice) r20;
        if (Intrinsics.areEqual(r21.getId(), TriggerSendLoading.NO_LOADING) == true) goto L45;
        BotLanguage r110 = this.s;
        if (r110 == null) goto L41;
        String r111 = r110.c();
    L43:
        if (Intrinsics.areEqual(r111, r21.getLanguageCode()) == false) goto L45;
        boolean r22 = true;
    L46:
        if (r22 == false) goto L35;
    L49:
        SpeakerVoice r23 = (SpeakerVoice) r20;
    L51:
        BotCreateViewModel.updateVoice$default(V90(), r23, false, 2, null);
        ItemTextArrow r24 = this.y;
        if (r24 == null) goto L59;
        if (r23 == null) goto L58;
        String r25 = r23.getName();
        if (r25 == null) goto L58;
        r10 = r25;
    L58:
        int r26 = ItemTextArrow.k;
        r24.Z5(r10, null);
    L59:
        this.u = r23;
        FLogger r27 = FLogger.a;
        StringBuilder r28 = new StringBuilder("ai gen voiceId=");
        r28.append(r13);
        r28.append(", not matched launch voiceList, result name=");
        if (r23 == null) goto L62;
        String r112 = r23.getName();
    L63:
        r28.append(r112);
        r28.append(", id=");
        if (r23 == null) goto L66;
        r3 = r23.getId();
    L66:
        r28.append(r3);
        r27.w("BotCreateFragment", r28.toString());
        goto L67
    L62:
        r112 = null;
        goto L63
    L41:
        r111 = null;
    L45:
        r22 = false;
        goto L46
    L48:
        r20 = null;
        goto L49
    L50:
        r23 = null;
        goto L51
    L12:
        r7 = null;
    L16:
        r8 = false;
        goto L17
    L19:
        r4 = null;
        goto L20
    L21:
        r9 = null;
        goto L22
    }

    @Override // ru8.e
    public final void fO(DescPolishStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "status");
        this.G = r2;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        com.larus.bmhome.chat.api.e0 r5 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r5 == null) goto L5;
        LaunchInfo r6 = r5.a;
    L7:
        if (r6 != null) goto L11;
        FLogger.a.w("BotCreateFragment", "argLaunchInfo is null");
        ru8.d r7 = (ru8.d) s1a.a.g(this).getAbility(ru8.d.class);
        if (r7 == null) goto L26;
        r7.bb();
    L26:
        this.l = com.larus.utils.v.a(this, new l(this));
        p2a.f r8 = (p2a.f) this.I.getValue();
        if (r8 == null) goto L29;
        r8.Z();
    L29:
        FLogger.a.d("BotCreateFragment", "attachComponent");
        s1a.a.g(this).c(this, ru8.e.class);
        s1a.a.g(this).c(this, ru8.a.class);
        k1a.b.a(this, new i(this));
        return;
    L11:
        Bundle r9 = getArguments();
        String r1 = "";
        if (r9 == null) goto L15;
        String r10 = r9.getString("enter_from", "");
        if (r10 == null) goto L15;
    L16:
        this.g = r10;
        Bundle r11 = getArguments();
        if (r11 == null) goto L22;
        String r12 = r11.getString("enter_method", "");
        if (r12 == null) goto L22;
        r1 = r12;
    L22:
        this.h = r1;
        Bundle r13 = getArguments();
        if (r13 == null) goto L25;
        V90().getArguments().putAll(r13);
        V90().getBotCreateTrace().b.putAll(r13);
    L25:
        FLogger.a.i("BotCreateFragment", "enterFrom=" + this.g + ", enterMethod=" + this.h);
    L15:
        r10 = "";
        goto L16
    L5:
        r6 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r14v10, types: [android.view.View, com.larus.bmhome.view.item.ItemTextArrow] */
    /* JADX WARN: Type inference failed for: r14v11, types: [android.view.View, com.larus.bmhome.view.item.ItemTextArrow] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r14, r15);
        FLogger.a.i("BotCreateFragment", "enable auto fill: " + z2.a.createBotAutoFillEnable());
        boolean r16 = this.E;
        final LarusPageBotEditBinding r17 = this.e;
        if (r17 == null) goto L7;
        if (r16 == false) goto L6;
        com.larus.utils.e1.x(r17.s);
        com.larus.utils.e1.x(r17.e);
        r17.e.setOnClickListener(new h(this, r17));
        com.larus.utils.e1.o(r17.d);
        com.larus.utils.e1.o(r17.v);
        com.larus.utils.e1.o(r17.t);
        com.larus.utils.e1.o(r17.b);
        this.y = r17.w;
        this.z = r17.u;
        this.A = r17.c;
        goto L7
    L6:
        com.larus.utils.e1.o(r17.s);
        com.larus.utils.e1.o(r17.e);
        this.y = r17.v;
        this.z = r17.t;
        this.A = r17.b;
    L7:
        final Function2 r18 = new com.larus.bot.impl.feature.edit.c(this);
        getParentFragmentManager().setFragmentResultListener("access_permission_request", this, new m(r18));
        final Function2 r19 = new d(this);
        getParentFragmentManager().setFragmentResultListener("public_permission_result_request", this, new m(r19));
        if (this.e == null) goto L12;
        com.larus.bot.impl.feature.edit.feature.avatar.u r110 = this.w;
        if (r110 == null) goto L12;
        r110.a(null);
        Unit r111 = Unit.INSTANCE;
    L12:
        LarusPageBotEditBinding r112 = this.e;
        if (r112 == null) goto L15;
        com.larus.bot.impl.feature.edit.feature.firstmet.h r7 = new com.larus.bot.impl.feature.edit.feature.firstmet.h(this, r112.q, V90().getFirstMetEditViewModel(), V90().getBotCreateTrace(), new b0(this));
        this.x = r7;
        r7.a();
        Unit r113 = Unit.INSTANCE;
    L15:
        LarusPageBotEditBinding r114 = this.e;
        if (r114 == null) goto L18;
        LarusLayoutBotBioEditBinding r115 = r114.g;
        com.larus.bot.impl.feature.edit.feature.bio.i r2 = V90().getBioEditViewModel();
        V90().getBotCreateTrace();
        new com.larus.bot.impl.feature.edit.feature.bio.f(this, r115, r2).a();
        Unit r116 = Unit.INSTANCE;
    L18:
        final ?? r117 = this.z;
        boolean r3 = true;
        String r4 = "";
        if (r117 == 0) goto L99;
        AuthModelDelegate r5 = AuthModelDelegate.b;
        com.larus.bmhome.chat.api.e0 r6 = (com.larus.bmhome.chat.api.e0) r5.e().getValue();
        if (r6 == null) goto L25;
        LaunchInfo r8 = r6.a;
        if (r8 == null) goto L25;
        boolean r9 = Intrinsics.areEqual(r8.N0(), Boolean.TRUE);
    L27:
        if ((!r9) == false) goto L29;
        int r10 = 0;
    L30:
        r117.setVisibility(r10);
        com.larus.bmhome.chat.api.e0 r11 = (com.larus.bmhome.chat.api.e0) r5.e().getValue();
        if (r11 == null) goto L40;
        LaunchInfo r12 = r11.a;
        if (r12 == null) goto L40;
        List r13 = r12.j();
        if (r13 == null) goto L40;
        List r20 = r13;
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r22 = r20.iterator();
    L38:
        if (r22.hasNext() == false) goto L41;
        com.larus.im.bean.bot.BotLanguage r23 = (com.larus.im.bean.bot.BotLanguage) r22.next();
        r21.add(new BotLanguage(r23.getLanguageCode(), r23.getLanguage(), r23.getLanguageLocal()));
    L41:
        this.q = r21;
        BotLanguage r24 = this.s;
        if (r24 == null) goto L44;
    L92:
        this.s = r24;
        if (r24 == null) goto L98;
        String r25 = r24.b();
        if (r25 != null) goto L97;
        r25 = "";
    L97:
        int r26 = ItemTextArrow.k;
        r117.Z5(r25, null);
    L98:
        V90().updateLanguage(this.s);
        V90().onBotInfoChanged(ContentType.LANGUAGE, false);
        com.larus.utils.e1.d(r117, new com.larus.bot.impl.feature.edit.b(this, r117));
        Unit r118 = Unit.INSTANCE;
        goto L99
    L44:
        if (AppHost.a.isOversea() == false) goto L74;
        List<BotLanguage> r27 = this.q;
        if (r27 == null) goto L56;
        Iterator<T> r28 = r27.iterator();
    L49:
        if (r28.hasNext() == false) goto L53;
        Object r29 = r28.next();
        String r30 = ((BotLanguage) r29).c();
        AppLocaleUtils.a.getClass();
        if (Intrinsics.areEqual(r30, AppLocaleUtils.c().getLanguage()) == false) goto L49;
    L54:
        BotLanguage r31 = (BotLanguage) r29;
        if (r31 == null) goto L56;
    L72:
        r24 = r31;
    L73:
        this.r = r24;
        goto L92
    L53:
        r29 = null;
    L56:
        List<BotLanguage> r32 = this.q;
        if (r32 == null) goto L66;
        Iterator<T> r33 = r32.iterator();
    L60:
        if (r33.hasNext() == false) goto L64;
        Object r34 = r33.next();
        if (Intrinsics.areEqual(((BotLanguage) r34).c(), "en") == false) goto L60;
    L65:
        r31 = (BotLanguage) r34;
    L67:
        if (r31 != null) goto L72;
        List<BotLanguage> r35 = this.q;
        if (r35 == null) goto L71;
        r24 = (BotLanguage) CollectionsKt.firstOrNull(r35);
        goto L73
    L71:
        r24 = null;
        goto L73
    L64:
        r34 = null;
        goto L65
    L66:
        r31 = null;
        goto L67
    L74:
        List<BotLanguage> r36 = this.q;
        if (r36 == null) goto L87;
        Iterator<T> r37 = r36.iterator();
    L78:
        if (r37.hasNext() == false) goto L82;
        Object r38 = r37.next();
        if (Intrinsics.areEqual(((BotLanguage) r38).c(), "zh") == false) goto L78;
    L83:
        BotLanguage r39 = (BotLanguage) r38;
        if (r39 == null) goto L87;
        r24 = r39;
    L91:
        this.r = r24;
        goto L92
    L82:
        r38 = null;
    L87:
        List<BotLanguage> r40 = this.q;
        if (r40 == null) goto L90;
        r24 = (BotLanguage) CollectionsKt.firstOrNull(r40);
        goto L91
    L90:
        r24 = null;
    L40:
        r21 = null;
        goto L41
    L29:
        r10 = 8;
    L25:
        r9 = false;
    L99:
        ?? r119 = this.y;
        if (r119 == 0) goto L255;
        z2 r41 = z2.a;
        if (r41.m3() == false) goto L254;
        r119.setVisibility(0);
        if (FeatureKitDelegate.b.w0().b() == false) goto L109;
        AudioUserConfig r42 = (AudioUserConfig) AudioServiceDelegate.a.p().getValue();
        if (r42 == null) goto L114;
        List<SpeakerVoice> r43 = r42.getNewVoiceList();
    L115:
        this.t = r43;
        List<SpeakerVoice> r44 = r43;
        if (r44 != null) goto L118;
    L121:
        boolean r45 = true;
    L122:
        if (r45 == false) goto L124;
        AudioServiceDelegate.a.J("BotCreateFragment");
    L124:
        SpeakerVoice r46 = this.u;
        if (r46 == null) goto L127;
        String r47 = r46.getName();
    L128:
        if (r47 != null) goto L130;
    L133:
        boolean r48 = true;
    L134:
        if (r48 == true) goto L136;
        SpeakerVoice r49 = this.u;
        if (r49 == null) goto L150;
        String r50 = r49.getName();
        if (r50 == null) goto L150;
    L151:
        int r51 = ItemTextArrow.k;
        r119.Z5(r50, null);
    L152:
        Bundle r52 = getArguments();
        if (r52 == null) goto L155;
        String r53 = r52.getString("bot_create_info");
    L157:
        if (com.larus.utils.o0.d(r53) == false) goto L253;
        Bundle r54 = getArguments();
        if (r54 == null) goto L162;
        final String r55 = r54.getString("bot_create_msg_id");
        if (r55 == null) goto L162;
    L164:
        if (com.larus.utils.o0.d(r55) == false) goto L253;
        FLogger.a.i("BotCreateFragment", "showVoiceItemLoading");
        ItemTextArrow r56 = this.y;
        if (r56 == null) goto L168;
        r56.c6();
    L168:
        com.larus.bot.impl.feature.botmaker.k r57 = com.larus.bot.impl.feature.botmaker.k.a;
        if (r55.length() != 0) goto L171;
        boolean r58 = true;
    L172:
        if (r58 == true) goto L177;
        Map<String, Job> r59 = com.larus.bot.impl.feature.botmaker.k.g;
        if (r59.containsKey(r55) == false) goto L177;
        Job r60 = (Job) ((LinkedHashMap) r59).get(r55);
    L178:
        if (r60 != null) goto L180;
    L183:
        Intrinsics.checkNotNullParameter(r55, "msgId");
        String r61 = (String) ((LinkedHashMap) com.larus.bot.impl.feature.botmaker.k.k).get(r55);
        if (com.larus.utils.o0.d(r61) == false) goto L252;
        Y90();
        List<SpeakerVoice> r62 = this.t;
        if (r62 == null) goto L204;
        Iterator<T> r63 = r62.iterator();
    L189:
        if (r63.hasNext() == false) goto L202;
        Object r64 = r63.next();
        SpeakerVoice r65 = (SpeakerVoice) r64;
        if (Intrinsics.areEqual(r65.getId(), r61) == false) goto L199;
        BotLanguage r66 = this.s;
        if (r66 == null) goto L195;
        String r67 = r66.c();
    L197:
        if (Intrinsics.areEqual(r67, r65.getLanguageCode()) == false) goto L199;
        boolean r68 = true;
    L200:
        if (r68 == false) goto L189;
    L203:
        SpeakerVoice r69 = (SpeakerVoice) r64;
    L206:
        if (r69 == null) goto L214;
        FLogger.a.i("BotCreateFragment", "ai gen voiceId=" + r61 + ", name=" + r69.getName() + ", matched launch voiceList");
        this.u = r69;
        BotCreateViewModel.updateVoice$default(V90(), r69, false, 2, null);
        ItemTextArrow r0 = this.y;
        if (r0 == null) goto L251;
        String r70 = r69.getName();
        if (r70 == null) goto L213;
        r4 = r70;
    L213:
        int r71 = ItemTextArrow.k;
        r0.Z5(r4, null);
    L251:
        V90().onBotInfoChanged(ContentType.VOICE_ID, false);
        goto L253
    L214:
        List<SpeakerVoice> r72 = this.t;
        if (r72 == null) goto L233;
        Iterator<T> r73 = r72.iterator();
    L218:
        if (r73.hasNext() == false) goto L231;
        Object r74 = r73.next();
        SpeakerVoice r120 = (SpeakerVoice) r74;
        if (Intrinsics.areEqual(r120.getId(), TriggerSendLoading.NO_LOADING) == true) goto L228;
        BotLanguage r121 = this.s;
        if (r121 == null) goto L224;
        String r122 = r121.c();
    L226:
        if (Intrinsics.areEqual(r122, r120.getLanguageCode()) == false) goto L228;
        boolean r123 = true;
    L229:
        if (r123 == false) goto L218;
    L232:
        SpeakerVoice r75 = (SpeakerVoice) r74;
    L234:
        BotCreateViewModel.updateVoice$default(V90(), r75, false, 2, null);
        ItemTextArrow r76 = this.y;
        if (r76 == null) goto L242;
        if (r75 == null) goto L241;
        String r77 = r75.getName();
        if (r77 == null) goto L241;
        r4 = r77;
    L241:
        int r78 = ItemTextArrow.k;
        r76.Z5(r4, null);
    L242:
        this.u = r75;
        FLogger r79 = FLogger.a;
        StringBuilder r80 = new StringBuilder("ai gen voiceId=");
        r80.append(r61);
        r80.append(", not matched launch voiceList, result name=");
        if (r75 == null) goto L245;
        String r81 = r75.getName();
    L246:
        r80.append(r81);
        r80.append(", id=");
        if (r75 == null) goto L249;
        String r82 = r75.getId();
    L250:
        r80.append(r82);
        r79.w("BotCreateFragment", r80.toString());
        goto L251
    L249:
        r82 = null;
        goto L250
    L245:
        r81 = null;
        goto L246
    L224:
        r122 = null;
    L228:
        r123 = false;
        goto L229
    L231:
        r74 = null;
        goto L232
    L233:
        r75 = null;
        goto L234
    L195:
        r67 = null;
    L199:
        r68 = false;
        goto L200
    L202:
        r64 = null;
        goto L203
    L204:
        r69 = null;
        goto L206
    L252:
        Y90();
        goto L253
    L180:
        if (r60.isCompleted() == true) goto L183;
        r60.invokeOnCompletion(new k(r55, this));
    L177:
        r60 = null;
        goto L178
    L171:
        r58 = false;
    L162:
        r55 = "";
    L253:
        com.larus.utils.e1.d(r119, new g(this));
        goto L254
    L155:
        r53 = null;
    L150:
        r50 = (String) this.o.getValue();
        goto L151
    L136:
        if (this.C.q() == true) goto L145;
        lq9.f0 r83 = r41.o3();
        int r84 = r83.b(X90());
        if (r83.a == true) goto L140;
    L142:
        boolean r85 = false;
    L143:
        if (r85 == false) goto L145;
        r119.i6(getString(2131907856));
        goto L152
    L140:
        if (r84 != 3) goto L142;
        r85 = true;
    L145:
        String r86 = (String) this.o.getValue();
        int r87 = ItemTextArrow.k;
        r119.Z5(r86, null);
        goto L152
    L130:
        if (r47.length() == 0) goto L133;
        r48 = false;
        goto L134
    L127:
        r47 = null;
        goto L128
    L118:
        if (r44.isEmpty() == true) goto L121;
        r45 = false;
    L114:
        r43 = null;
        goto L115
    L109:
        com.larus.bmhome.chat.api.e0 r88 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r88 == null) goto L114;
        LaunchInfo r89 = r88.a;
        if (r89 == null) goto L114;
        r43 = r89.T0();
    L254:
        Unit r124 = Unit.INSTANCE;
    L255:
        ConstraintLayout r125 = this.A;
        if (r125 != null) goto L258;
    L262:
        com.larus.bot.impl.common.util.e.a(V90().getUiEvent(), LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), new BotCreateFragment$bindObservers$1(this, null));
        LarusPageBotEditBinding r126 = this.e;
        if (r126 == null) goto L340;
        ConstraintLayout r127 = r126.a;
        if (r127 == null) goto L341;
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L269;
        int r90 = com.larus.utils.u.c(r1);
    L270:
        r127.setPaddingRelative(r127.getPaddingStart(), r90, r127.getPaddingEnd(), r127.getPaddingBottom());
        if (r127.isAttachedToWindow() == false) goto L306;
        WindowInsetsCompat r91 = ViewCompat.getRootWindowInsets(r127);
        if (r91 == null) goto L307;
        Insets r92 = r91.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r92 == null) goto L307;
        LarusPageBotEditBinding r93 = this.e;
        if (r93 == null) goto L291;
        BotEditScrollView r94 = r93.J;
        if (r94 == null) goto L291;
        ViewGroup.LayoutParams r95 = r94.getLayoutParams();
        if (r95 == null) goto L290;
        if ((r95 instanceof ViewGroup.MarginLayoutParams) == false) goto L285;
        ViewGroup.MarginLayoutParams r96 = (ViewGroup.MarginLayoutParams) r95;
    L286:
        if (r96 == null) goto L288;
        r96.bottomMargin = r92.bottom;
    L288:
        r94.setLayoutParams(r95);
        goto L291
    L285:
        r96 = null;
        goto L286
    L290:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L291:
        LarusPageBotEditBinding r97 = this.e;
        if (r97 == null) goto L307;
        ConstraintLayout r98 = r97.h;
        if (r98 == null) goto L307;
        ViewGroup.LayoutParams r99 = r98.getLayoutParams();
        if (r99 == null) goto L305;
        if ((r99 instanceof ViewGroup.MarginLayoutParams) == false) goto L300;
        ViewGroup.MarginLayoutParams r100 = (ViewGroup.MarginLayoutParams) r99;
    L301:
        if (r100 == null) goto L303;
        r100.bottomMargin = r92.bottom;
    L303:
        r98.setLayoutParams(r99);
        goto L307
    L300:
        r100 = null;
        goto L301
    L305:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L307:
        p2a.a r101 = IAIChatService.a.u7();
        if (r101 == null) goto L314;
        p2a.p r102 = r101.c();
        if (r102 == null) goto L314;
        if (r102.a != true) goto L314;
    L315:
        if (r3 == false) goto L317;
    L318:
        ViewExtKt.n(r127, new com.larus.bot.impl.feature.edit.a(this), null, null, 6);
        return;
    L317:
        if (U90() == true) goto L318;
        return;
    L314:
        r3 = false;
        goto L315
    L306:
        r127.addOnAttachStateChangeListener(new c(r127, this));
        goto L307
    L269:
        r90 = 0;
        goto L270
    L341:
        return;
    L340:
        return;
    L258:
        if (z2.a.x3().getHideCreatePermissionEntry() == false) goto L260;
        r125.setVisibility(8);
    L261:
        Unit r128 = Unit.INSTANCE;
        goto L262
    L260:
        r125.setVisibility(0);
        ba0();
        com.larus.utils.e1.d(r125, new c0(this));
        goto L261
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        LarusPageBotEditBinding r6 = LarusPageBotEditBinding.a(r9, r10);
        this.e = r6;
        FrameLayout r1 = r6.f;
        if (U90() == false) goto L5;
        LarusLayoutBotEditBgImageBinding r0 = LarusLayoutBotEditBgImageBinding.a(r9, r1);
        this.w = new BotBgImageEditView(this, r0, V90().getBgImageEditViewModel(), V90().getBotCreateTrace());
        r1.addView(r0.a);
    L8:
        BotAutoFillUIBinder r7 = new BotAutoFillUIBinder(this, (com.larus.common_ui.view.b0) this.H.getValue(), V90().getAutoFillViewModel(), V90().getBotCreateTrace(), U90());
        if (z2.a.createBotAutoFillEnable() == false) goto L11;
        r7.b();
    L12:
        this.v = new com.larus.bmhome.utils.x1(r6.z);
        LarusPageBotEditBinding r2 = this.e;
        if (r2 == null) goto L15;
        ConstraintLayout r3 = r2.a;
    L16:
        qu8.b.a(r3, "bot_create_first_frame");
        LarusPageBotEditBinding r4 = this.e;
        if (r4 == null) goto L24;
        ConstraintLayout r5 = r4.a;
        if (r5 == null) goto L25;
        r5.setTag(2131377847, this);
        return r5;
    L25:
        return null;
    L24:
        return null;
    L15:
        r3 = null;
        goto L16
    L11:
        r7.a();
        goto L12
    L5:
        ViewGroup.LayoutParams r8 = r1.getLayoutParams();
        if (r8 == null) goto L23;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r8;
        r12.height = c7.b(120);
        r12.width = c7.b(120);
        r12.topMargin = c7.b(12);
        r1.setLayoutParams(r12);
        this.w = new BotAvatarEditView(this, LarusLayoutBotEditAvatarBinding.a(r9, r1), V90().getAvatarEditModel(), V90().getBotCreateTrace(), this.v);
        goto L8
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
