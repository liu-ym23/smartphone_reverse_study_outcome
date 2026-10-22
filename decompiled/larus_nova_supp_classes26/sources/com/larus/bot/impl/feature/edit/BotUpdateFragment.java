package com.larus.bot.impl.feature.edit;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.StaticLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.IAudioService;
import com.larus.audio.bean.GetMatchVoiceRequest;
import com.larus.audio.bean.RecommendScene;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemLongTextArrow;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bot.impl.bean.BotEditParam;
import com.larus.bot.impl.databinding.LarusLayoutBotEditAvatarBinding;
import com.larus.bot.impl.databinding.LarusLayoutBotEditBgImageBinding;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;
import com.larus.bot.impl.feature.edit.feature.avatar.BotAvatarEditView;
import com.larus.bot.impl.feature.edit.feature.bgimage.BotBgImageEditView;
import com.larus.bot.impl.feature.edit.feature.bgimage.newuserguide.BgImageNewUserGuideActivity;
import com.larus.bot.impl.feature.edit.feature.language.LanguageItemViewModel;
import com.larus.bot.impl.feature.edit.feature.speakervoice.SpeakerVoiceItemViewModel;
import com.larus.bot.impl.feature.edit.view.BotEditScrollView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.im.bean.bot.AudioPreview;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotSwitchConfInfo;
import com.larus.im.bean.bot.FirstMet;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.EditPos;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatAudioService;
import com.larus.platform.spi.IAIChatService;
import com.larus.settings.value.e10;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;
import v19.c7;
import v19.e7;
import v19.o5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u009e\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u009e\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\n\u0010?\u001a\u0004\u0018\u00010@H\u0016J\n\u0010D\u001a\u0004\u0018\u00010EH\u0016J\n\u0010^\u001a\u0004\u0018\u00010_H\u0016J\n\u0010`\u001a\u0004\u0018\u00010aH\u0016J\b\u0010W\u001a\u00020XH\u0016J\u0010\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020XH\u0016J\b\u0010U\u001a\u00020VH\u0016J\u0010\u0010e\u001a\u00020c2\u0006\u0010d\u001a\u00020VH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010:\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010S\u001a\u00020#H\u0016J\u0012\u0010f\u001a\u00020c2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\b\u0010i\u001a\u00020#H\u0016J&\u0010j\u001a\u0004\u0018\u00010k2\u0006\u0010l\u001a\u00020m2\b\u0010n\u001a\u0004\u0018\u00010o2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\b\u0010p\u001a\u00020cH\u0002J\u001a\u0010q\u001a\u00020c2\u0006\u0010r\u001a\u00020k2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\b\u0010s\u001a\u00020cH\u0002J\b\u0010t\u001a\u00020cH\u0002J\u0010\u0010u\u001a\u00020c2\u0006\u0010v\u001a\u00020#H\u0002J\u0018\u0010w\u001a\u00020c2\u0006\u0010l\u001a\u00020m2\u0006\u0010x\u001a\u00020yH\u0002J\u000f\u0010z\u001a\u0004\u0018\u00010cH\u0002¢\u0006\u0002\u0010{J\u0010\u0010|\u001a\u00020c2\u0006\u0010}\u001a\u00020hH\u0002J\u000f\u0010~\u001a\u0004\u0018\u00010cH\u0002¢\u0006\u0002\u0010{J\b\u0010\u007f\u001a\u00020cH\u0002J\t\u0010\u0080\u0001\u001a\u00020cH\u0002J\t\u0010\u0081\u0001\u001a\u00020#H\u0002J\t\u0010\u0082\u0001\u001a\u00020cH\u0002J\t\u0010\u0083\u0001\u001a\u00020cH\u0002J\u0010\u0010\u0084\u0001\u001a\u0004\u0018\u00010cH\u0002¢\u0006\u0002\u0010{J\t\u0010\u0085\u0001\u001a\u00020#H\u0016J\u001c\u0010\u0086\u0001\u001a\u0004\u0018\u00010c2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0003\u0010\u0088\u0001J!\u0010\u0089\u0001\u001a\u00020c2\u0007\u0010\u008a\u0001\u001a\u00020\u00072\u0007\u0010\u008b\u0001\u001a\u00020\u00072\u0006\u0010}\u001a\u00020hJ\u0011\u0010\u008c\u0001\u001a\u00020c2\u0006\u0010}\u001a\u00020hH\u0002J\u0011\u0010\u008d\u0001\u001a\u00020c2\u0006\u0010}\u001a\u00020hH\u0002J\u0014\u0010\u008e\u0001\u001a\u00020c2\t\b\u0002\u0010\u008f\u0001\u001a\u00020#H\u0002J\u0010\u0010\u0090\u0001\u001a\u0004\u0018\u00010cH\u0002¢\u0006\u0002\u0010{J\t\u0010\u0091\u0001\u001a\u00020cH\u0002J\f\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0002J\t\u0010\u0094\u0001\u001a\u00020cH\u0002J\t\u0010\u0095\u0001\u001a\u00020cH\u0002J\u0010\u0010\u0096\u0001\u001a\u0004\u0018\u00010cH\u0002¢\u0006\u0002\u0010{J\u0010\u0010\u0097\u0001\u001a\u0004\u0018\u00010cH\u0002¢\u0006\u0002\u0010{J\u0010\u0010\u0098\u0001\u001a\u0004\u0018\u00010cH\u0002¢\u0006\u0002\u0010{J\u0010\u0010\u0099\u0001\u001a\u0004\u0018\u00010cH\u0002¢\u0006\u0002\u0010{J\n\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0002J\t\u0010\u009c\u0001\u001a\u00020cH\u0016J\t\u0010\u009d\u0001\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0011\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0011\u001a\u0004\b2\u00103R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0011\u001a\u0004\b7\u00108R\u0016\u0010:\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010.R\u0016\u0010<\u001a\u0004\u0018\u00010#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u001d\u0010?\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u0011\u001a\u0004\bA\u0010BR\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010H\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\u0011\u001a\u0004\bI\u0010JR\u001b\u0010L\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\u0011\u001a\u0004\bM\u0010JR\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020VX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020XX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010Y\u001a\u00020Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\u0011\u001a\u0004\b[\u0010\\¨\u0006\u009f\u0001"}, d2 = {"Lcom/larus/bot/impl/feature/edit/BotUpdateFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/bot/impl/feature/ability/IBotEditAbility;", "Lcom/larus/bot/impl/feature/ability/IBotUpdateAbility;", "<init>", "()V", "RESULT_CODE", "", "binding", "Lcom/larus/bot/impl/databinding/LarusPageBotEditBinding;", "trace", "Lcom/larus/bmhome/setting/IBotSettingTrace;", "updateViewModel", "Lcom/larus/bot/impl/feature/edit/BotUpdateViewModel;", "getUpdateViewModel", "()Lcom/larus/bot/impl/feature/edit/BotUpdateViewModel;", "updateViewModel$delegate", "Lkotlin/Lazy;", "conversationId", "", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "editPos", "Lcom/larus/platform/model/EditPos;", "languageList", "", "Lcom/larus/bmhome/bot/bean/BotLanguage;", "updateConfig", "Lcom/larus/bot/impl/feature/edit/config/BotUpdateConfig;", "selectedLanguage", "selectedVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "selectedModel", "Lcom/larus/im/bean/bot/ModelItem;", "switchSearchEnable", "", "switchGenEnable", "enableAdvance", "visibleVoiceItem", "Lcom/larus/bmhome/view/item/ItemTextArrow;", "visibleLanguageItem", "visibleModelItem", "visiblePermissionItem", "Lcom/larus/bmhome/view/item/ItemLongTextArrow;", "mutedVoiceName", "getMutedVoiceName", "()Ljava/lang/String;", "mutedVoiceName$delegate", "languageItemViewModel", "Lcom/larus/bot/impl/feature/edit/feature/language/LanguageItemViewModel;", "getLanguageItemViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/language/LanguageItemViewModel;", "languageItemViewModel$delegate", "speakerVoiceItemViewModel", "Lcom/larus/bot/impl/feature/edit/feature/speakervoice/SpeakerVoiceItemViewModel;", "getSpeakerVoiceItemViewModel", "()Lcom/larus/bot/impl/feature/edit/feature/speakervoice/SpeakerVoiceItemViewModel;", "speakerVoiceItemViewModel$delegate", "previousPage", "getPreviousPage", "needShowImageGuide", "getNeedShowImageGuide", "()Ljava/lang/Boolean;", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "imeManager", "Lcom/larus/bmhome/utils/ImeManager;", "avatarEditView", "Lcom/larus/bot/impl/feature/edit/feature/avatar/IBotAvatarEditView;", "canAddBgImage", "getCanAddBgImage", "()Z", "canAddBgImage$delegate", "canShowNewUserGuide", "getCanShowNewUserGuide", "canShowNewUserGuide$delegate", "firstMetEditView", "Lcom/larus/bot/impl/feature/edit/feature/firstmet/BotFirstMetEditView;", "bioEditView", "Lcom/larus/bot/impl/feature/edit/feature/bio/BotBioEditView;", "isGuidance", "hasUserClickComplete", "lastPolishEnable", "Lcom/larus/bot/impl/feature/edit/DescPolishBtnStatus;", "lastPolishStatus", "Lcom/larus/bot/impl/feature/edit/DescPolishStatus;", "ugcVoiceService", "Lcom/larus/voice_setting/IUgcVoiceService;", "getUgcVoiceService", "()Lcom/larus/voice_setting/IUgcVoiceService;", "ugcVoiceService$delegate", "botMainEditViewModel", "Lcom/larus/bot/impl/feature/edit/feature/main/IBotMainEditViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "updateLastPolishStatus", "", "status", "updateLastPolishEnable", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "autoLogEnterPage", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "attachComponent", "onViewCreated", "view", "setupPaddingListener", "mobEnterPage", "setupAdvanceSetting", "advanceMode", "addAvatarView", "avatarContainer", "Landroid/widget/FrameLayout;", "setupDataModel", "()Lkotlin/Unit;", "setupSelectModelResult", "bundle", "adjustDescEditHeight", "setupSelectPrivateStatusResult", "setupSwitchConfig", "canModifyTts", "setupTtsSpeaker", "openVoiceChoosePage", "setupAccessPermission", "isCreator", "updateAccessPermission", "privateStatus", "(Ljava/lang/Integer;)Lkotlin/Unit;", "onResult", "requestCode", "resultCode", "updateLanguageResult", "updateSpeakerResult", "updateSpeakerItem", "isFromInit", "setupBotLanguage", "preloadVoiceList", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "backPage", "showExitUpdatedDialog", "setupAvatar", "setupDescriptionEdit", "setupFirstMetEdit", "setupBioEdit", "getMatchVoiceRequest", "Lcom/larus/audio/bean/GetMatchVoiceRequest;", "onDestroyView", "getCurrentPageName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotUpdateFragment extends TraceFragment implements ru8.e, ru8.f {
    public static final /* synthetic */ int K = 0;
    public final Lazy A;
    public com.larus.bmhome.utils.x1 B;
    public com.larus.bot.impl.feature.edit.feature.avatar.u C;
    public final Lazy D;
    public final Lazy E;
    public boolean F;
    public boolean G;
    public DescPolishBtnStatus H;
    public DescPolishStatus I;
    public final Lazy J;
    public final int e;
    public LarusPageBotEditBinding f;
    public final com.larus.bmhome.setting.b g;
    public final Lazy h;
    public String i;
    public BotModel j;
    public EditPos k;
    public List<BotLanguage> l;
    public vu8.a m;
    public BotLanguage n;
    public SpeakerVoice o;
    public ModelItem p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public ItemTextArrow t;
    public ItemTextArrow u;
    public ItemTextArrow v;
    public ItemLongTextArrow w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(Function1 r2) {
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

    public static final class c implements com.larus.common_ui.dialog.p0 {
        public final /* synthetic */ BotUpdateFragment a;

        public final void confirm() {
            this.a.g.e();
            FragmentActivity r0 = this.a.getActivity();
            if (r0 == null) goto L6;
            r0.finish();
            return;
        }

        public c(BotUpdateFragment r1) {
            this.a = r1;
        }
    }

    public static final class d implements com.larus.common_ui.dialog.u {
        public d() {
        }

        public final void cancel() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.BotUpdateFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.BotUpdateFragment$onViewCreated$1", f = "BotUpdateFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BotUpdateFragment this$0;

        public AnonymousClass1(BotUpdateFragment r1, Continuation<? super AnonymousClass1> r2) {
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

        /* JADX WARN: Type inference failed for: r0v13, types: [android.view.ViewGroup, com.larus.bmhome.view.item.ItemTextArrow] */
        /* JADX WARN: Type inference failed for: r0v19, types: [android.view.View, android.view.ViewGroup, com.larus.bmhome.view.item.ItemTextArrow, com.larus.bmhome.view.item.ItemTextView] */
        /* JADX WARN: Type inference failed for: r0v8, types: [android.view.View, android.view.ViewGroup, com.larus.bmhome.view.item.ItemTextArrow] */
        /* JADX WARN: Type inference failed for: r4v22, types: [com.larus.bot.impl.feature.edit.l0, java.lang.Object, kotlin.jvm.functions.Function1] */
        /* JADX WARN: Type inference failed for: r6v4, types: [android.view.ViewGroup, com.larus.bmhome.view.NovaTitleBarEx] */
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
        public final Object invokeSuspend(Object r14) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L273;
            ResultKt.throwOnFailure(r14);
            BotUpdateFragment r15 = this.this$0;
            BotModel r0 = r15.j;
            int r2 = 0;
            if (r0 == null) goto L18;
            Gson r3 = new Gson();
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L9
            Object r5 = Result.constructor-impl((EditPos) r3.fromJson(r0.getEditPos(), EditPos.class));     // Catch: Throwable -> L9
        L12:
            if (Result.isFailure-impl(r5) == false) goto L14;
            r5 = null;
        L14:
            EditPos r6 = (EditPos) r5;
            if (r6 != null) goto L17;
            r6 = new EditPos(0);
        L17:
            r15.k = r6;
            r15.X90().initConversationId(r15.i);
            r15.X90().initEditParam(r0);
        L9:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            r5 = Result.constructor-impl(ResultKt.createFailure(th));
        L18:
            BotUpdateFragment r16 = this.this$0;
            boolean r1 = r16.s;
            LarusPageBotEditBinding r8 = r16.f;
            if (r8 == null) goto L23;
            if (r1 == false) goto L22;
            com.larus.utils.e1.x(r8.s);
            com.larus.utils.e1.x(r8.d);
            com.larus.utils.e1.o(r8.v);
            com.larus.utils.e1.o(r8.t);
            com.larus.utils.e1.o(r8.b);
            com.larus.utils.e1.o(r8.x);
            r16.t = r8.w;
            r16.u = r8.u;
            r16.w = r8.c;
            r16.v = r8.y;
            goto L23
        L22:
            com.larus.utils.e1.o(r8.s);
            com.larus.utils.e1.o(r8.e);
            com.larus.utils.e1.x(r8.d);
            r16.t = r8.v;
            r16.u = r8.t;
            r16.w = r8.b;
            r16.v = r8.x;
        L23:
            final BotUpdateFragment r17 = this.this$0;
            LarusPageBotEditBinding r9 = r17.f;
            if (r9 == null) goto L34;
            final ConstraintLayout r10 = r9.a;
            Intrinsics.checkNotNull(r10);
            ?? r11 = new l0(r10);
            Intrinsics.checkNotNullParameter(r10, "<this>");
            Intrinsics.checkNotNullParameter(r11, "callback");
            WindowInsetsCompat r12 = ViewCompat.getRootWindowInsets(r10);
            if (r12 == null) goto L30;
            Insets r13 = r12.getInsets(WindowInsetsCompat.Type.statusBars());
            if (r13 == null) goto L30;
            r11.invoke(r13);
        L30:
            ViewCompat.setOnApplyWindowInsetsListener(r10, new e7(r10, r11));
            ?? r18 = r9.K;
            NovaTitleBarEx.Y5(r18, r18.getContext().getString(2131900245), null, null, 6);
            if (r17.V90() == false) goto L33;
            NovaTitleBarEx.b6(r18, 2131243589, false, null, null, new w0(r17), 14);
            goto L34
        L33:
            r18.c6(r17.requireContext().getString(2131905450), null, new h1(r17));
            NovaTitleBarEx.o6(r18, r18.getContext().getString(2131905454), new p1(r17));
            r18.setRightTextEnable(false);
        L34:
            BotUpdateFragment r19 = this.this$0;
            if (r19.f == null) goto L39;
            com.larus.bot.impl.feature.edit.feature.avatar.u r20 = r19.C;
            if (r20 == null) goto L39;
            r20.a(r19.k);
            Unit r110 = Unit.INSTANCE;
        L39:
            BotUpdateFragment.U90(this.this$0);
            final BotUpdateFragment r111 = this.this$0;
            final LarusPageBotEditBinding r21 = r111.f;
            if (r21 == null) goto L50;
            new com.larus.bot.impl.feature.edit.feature.firstmet.h(r111, r21.q, r111.X90().getFirstMetEditViewModel(), null, new g1(r111)).a();
            e10 r22 = e10.a;
            if (e10.B0() == false) goto L49;
            Context r23 = r111.getContext();
            if (r23 == null) goto L48;
            Resources r24 = r23.getResources();
            if (r24 == null) goto L48;
            r21.q.b.setTextColor(r24.getColor(2131103140));
            r21.q.b.setHintTextColor(r24.getColor(2131103140));
            r21.q.e.setTextColor(r24.getColor(2131103140));
            r21.q.f.setTextColor(r24.getColor(2131103140));
        L48:
            r21.q.f.setEnabled(false);
            r21.q.b.setKeyListener(null);
            r21.q.b.setOnClickListener(new i1(r111));
            r21.q.b.setOnLongClickListener(new j1(r21, r111));
        L49:
            Unit r112 = Unit.INSTANCE;
        L50:
            final BotUpdateFragment r113 = this.this$0;
            final LarusPageBotEditBinding r25 = r113.f;
            if (r25 == null) goto L61;
            new com.larus.bot.impl.feature.edit.feature.bio.f(r113, r25.g, r113.X90().getBioEditViewModel()).a();
            e10 r26 = e10.a;
            if (e10.B0() == false) goto L60;
            Context r27 = r113.getContext();
            if (r27 == null) goto L59;
            Resources r28 = r27.getResources();
            if (r28 == null) goto L59;
            r25.g.b.setTextColor(r28.getColor(2131103140));
            r25.g.b.setHintTextColor(r28.getColor(2131103140));
            r25.g.d.setTextColor(r28.getColor(2131103140));
        L59:
            r25.g.b.setKeyListener(null);
            r25.g.b.setOnClickListener(new u1(r113));
            r25.g.b.setOnLongClickListener(new v1(r25, r113));
        L60:
            Unit r114 = Unit.INSTANCE;
        L61:
            BotUpdateFragment.U90(this.this$0);
            final BotUpdateFragment r115 = this.this$0;
            final ?? r29 = r115.u;
            String r30 = "";
            if (r29 == 0) goto L160;
            AuthModelDelegate r31 = AuthModelDelegate.b;
            com.larus.bmhome.chat.api.e0 r32 = (com.larus.bmhome.chat.api.e0) r31.e().getValue();
            if (r32 == null) goto L68;
            LaunchInfo r33 = r32.a;
            if (r33 == null) goto L68;
            boolean r34 = Intrinsics.areEqual(r33.N0(), Boolean.TRUE);
        L70:
            if ((!r34) == false) goto L72;
            int r35 = 0;
        L73:
            r29.setVisibility(r35);
            ((LanguageItemViewModel) r115.y.getValue()).getLanguageItemStyle().observe(r115.getViewLifecycleOwner(), new b(new q0(r29)));
            LanguageItemViewModel r36 = (LanguageItemViewModel) r115.y.getValue();
            BotModel r37 = r115.j;
            if (r37 == null) goto L76;
            SpeakerVoice r38 = r37.getVoiceType();
        L77:
            r36.refreshLanguageItemStyle(r38, r115.k);
            com.larus.bmhome.chat.api.e0 r39 = (com.larus.bmhome.chat.api.e0) r31.e().getValue();
            if (r39 == null) goto L87;
            LaunchInfo r40 = r39.a;
            if (r40 == null) goto L87;
            List r41 = r40.j();
            if (r41 == null) goto L87;
            List r42 = r41;
            ArrayList r43 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r42, 10));
            Iterator r44 = r42.iterator();
        L85:
            if (r44.hasNext() == false) goto L88;
            com.larus.im.bean.bot.BotLanguage r45 = (com.larus.im.bean.bot.BotLanguage) r44.next();
            r43.add(new BotLanguage(r45.getLanguageCode(), r45.getLanguage(), r45.getLanguageLocal()));
        L88:
            r115.l = r43;
            if (r43 == null) goto L104;
            ListIterator r46 = r43.listIterator(r43.size());
        L92:
            if (r46.hasPrevious() == false) goto L102;
            Object r47 = r46.previous();
            String r48 = ((BotLanguage) r47).c();
            BotModel r116 = r115.j;
            if (r116 == null) goto L98;
            SpeakerVoice r117 = r116.getVoiceType();
            if (r117 == null) goto L98;
            String r118 = r117.getLanguageCode();
        L100:
            if (Intrinsics.areEqual(r48, r118) == false) goto L92;
        L103:
            BotLanguage r49 = (BotLanguage) r47;
        L105:
            r115.n = r49;
            if (r49 == null) goto L108;
        L151:
            r115.n = r49;
            r29.setOnClickListener(new r0(r29, r115));
            BotModel r119 = r115.j;
            if (r119 == null) goto L156;
            SpeakerVoice r120 = r119.getVoiceType();
            if (r120 == null) goto L156;
            String r121 = r120.getLanguage();
        L157:
            if (r121 != null) goto L159;
            r121 = "";
        L159:
            int r50 = ItemTextArrow.k;
            r29.Z5(r121, null);
            Unit r122 = Unit.INSTANCE;
        L156:
            r121 = null;
            goto L157
        L108:
            if (AppHost.a.isOversea() == false) goto L135;
            List<BotLanguage> r51 = r115.l;
            if (r51 == null) goto L120;
            Iterator<T> r52 = r51.iterator();
        L113:
            if (r52.hasNext() == false) goto L117;
            Object r53 = r52.next();
            String r54 = ((BotLanguage) r53).c();
            AppLocaleUtils.a.getClass();
            if (Intrinsics.areEqual(r54, AppLocaleUtils.c().getLanguage()) == false) goto L113;
        L118:
            r49 = (BotLanguage) r53;
            if (r49 != null) goto L151;
        L117:
            r53 = null;
        L120:
            List<BotLanguage> r55 = r115.l;
            if (r55 == null) goto L130;
            Iterator<T> r56 = r55.iterator();
        L124:
            if (r56.hasNext() == false) goto L128;
            Object r57 = r56.next();
            if (Intrinsics.areEqual(((BotLanguage) r57).c(), "en") == false) goto L124;
        L129:
            r49 = (BotLanguage) r57;
        L131:
            if (r49 != null) goto L151;
            List<BotLanguage> r58 = r115.l;
            if (r58 == null) goto L150;
            BotLanguage r59 = (BotLanguage) ListProtector.get(r58, 0);
        L149:
            r49 = r59;
        L150:
            r49 = null;
            goto L151
        L128:
            r57 = null;
            goto L129
        L130:
            r49 = null;
            goto L131
        L135:
            List<BotLanguage> r60 = r115.l;
            if (r60 == null) goto L146;
            Iterator<T> r61 = r60.iterator();
        L139:
            if (r61.hasNext() == false) goto L143;
            Object r62 = r61.next();
            if (Intrinsics.areEqual(((BotLanguage) r62).c(), "zh") == false) goto L139;
        L144:
            r49 = (BotLanguage) r62;
            if (r49 != null) goto L151;
        L143:
            r62 = null;
        L146:
            List<BotLanguage> r63 = r115.l;
            if (r63 == null) goto L150;
            r59 = (BotLanguage) ListProtector.get(r63, 0);
        L98:
            r118 = null;
            goto L100
        L102:
            r47 = null;
            goto L103
        L104:
            r49 = null;
        L87:
            r43 = null;
            goto L88
        L76:
            r38 = null;
            goto L77
        L72:
            r35 = 8;
        L68:
            r34 = false;
        L160:
            final BotUpdateFragment r123 = this.this$0;
            r123.getClass();
            if (z2.a.m3() == false) goto L204;
            final ?? r64 = r123.t;
            if (r64 == 0) goto L204;
            r64.setVisibility(0);
            IAIChatAudioService.Companion r65 = IAIChatAudioService.a;
            BotModel r66 = r123.j;
            if (r66 == null) goto L168;
            SpeakerVoice r67 = r66.getVoiceType();
        L169:
            r64.setStyle(r65.m(r67, r123.k) ? 1 : 0);
            BotModel r68 = r123.j;
            if (r68 != null) goto L172;
        L174:
            boolean r69 = false;
        L175:
            if (r69 == false) goto L199;
            final ArrayList r70 = new ArrayList();
            ((SpeakerVoiceItemViewModel) r123.z.getValue()).getTtsSpeakerGroups().observe(r123.getViewLifecycleOwner(), new b(new k1(r70)));
            if (FeatureKitDelegate.b.l0().b() == false) goto L196;
            p2a.f r71 = (p2a.f) r123.J.getValue();
            if (r71 == null) goto L196;
            List r72 = r71.D1();
            if (r72 == null) goto L196;
            List r73 = r72;
            ArrayList r74 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r73, 10));
            Iterator r75 = r73.iterator();
        L184:
            if (r75.hasNext() == false) goto L195;
            SpeakerVoice r76 = (SpeakerVoice) r75.next();
            String r124 = r76.getStyleId();
            if (r124 != null) goto L188;
            r124 = "";
        L188:
            AudioPreview r77 = r76.getPreview();
            if (r77 == null) goto L191;
            String r78 = r77.getPreviewAudio();
        L192:
            if (r78 != null) goto L194;
            r78 = "";
        L194:
            r74.add(new p68.b(r78, r124));
            goto L184
        L191:
            r78 = null;
            goto L192
        L195:
            r70.addAll(r74);
        L196:
            IAudioService r79 = (IAudioService) ServiceManager.get().getService(IAudioService.class);
            if (r79 == null) goto L199;
            r79.j(r70);
        L199:
            BotModel r80 = r123.j;
            if (r80 == null) goto L202;
            SpeakerVoice r81 = r80.getVoiceType();
        L203:
            r123.o = r81;
            r123.ba0(true);
            r64.setImageSrc(2131242860);
            r64.setOnClickListener(new q1(r64, r123));
            goto L204
        L202:
            r81 = null;
            goto L203
        L172:
            if (r68.getMuted() != true) goto L174;
            r69 = true;
            goto L175
        L168:
            r67 = null;
        L204:
            final BotUpdateFragment r125 = this.this$0;
            LarusPageBotEditBinding r82 = r125.f;
            if (r82 == null) goto L235;
            FLogger r83 = FLogger.a;
            StringBuilder r84 = new StringBuilder();
            r84.append(r125.q);
            r84.append(' ');
            r84.append(r125.r);
            r84.append(' ');
            r84.append(r125.an());
            r83.i("BotUpdateFragment", r84.toString());
            if (r125.q == true) goto L209;
        L219:
            r82.L.setVisibility(8);
        L220:
            r82.L.getToggleView().setOnCheckedChangeListener(new s0(r125));
            if (r125.r == true) goto L223;
        L233:
            r82.r.setVisibility(8);
        L234:
            r82.r.getToggleView().setOnCheckedChangeListener(new t0(r125));
            goto L235
        L223:
            if (r125.an() == false) goto L233;
            r82.r.setVisibility(0);
            CustomSwitchCompat r85 = r82.r.getToggleView();
            BotModel r86 = r125.j;
            if (r86 == null) goto L231;
            BotSwitchConfInfo r87 = r86.getSwitchConfInfo();
            if (r87 == null) goto L231;
            Boolean r88 = r87.getEnablePicGen();
            if (r88 == null) goto L231;
            boolean r89 = r88.booleanValue();
        L232:
            r85.setChecked(r89);
        L231:
            r89 = false;
            goto L232
        L209:
            if (r125.an() == false) goto L219;
            r82.L.setVisibility(0);
            CustomSwitchCompat r90 = r82.L.getToggleView();
            BotModel r91 = r125.j;
            if (r91 == null) goto L217;
            BotSwitchConfInfo r92 = r91.getSwitchConfInfo();
            if (r92 == null) goto L217;
            Boolean r93 = r92.getEnableWebSearch();
            if (r93 == null) goto L217;
            boolean r94 = r93.booleanValue();
        L218:
            r90.setChecked(r94);
        L217:
            r94 = false;
        L235:
            final BotUpdateFragment r126 = this.this$0;
            ConstraintLayout r95 = r126.w;
            if (r95 != null) goto L238;
        L250:
            final BotUpdateFragment r127 = this.this$0;
            final ?? r96 = r127.v;
            if (r96 == 0) goto L266;
            AuthModelDelegate r97 = AuthModelDelegate.b;
            r96.setVisible(r97.d());
            BotModel r98 = r127.j;
            if (r98 == null) goto L255;
            ModelItem r99 = r98.getModel();
        L256:
            r127.p = r99;
            r96.setOnClickListener(new r1(r96, r127));
            Transformations.map(r97.c(), new s1()).observe(r127.getViewLifecycleOwner(), new b(new t1(r127)));
            BotModel r128 = r127.j;
            if (r128 == null) goto L261;
            ModelItem r129 = r128.getModel();
            if (r129 == null) goto L261;
            String r130 = r129.getName();
        L262:
            if (r130 == null) goto L265;
            r30 = r130;
        L265:
            r96.Z5(r30, null);
            Unit r131 = Unit.INSTANCE;
        L261:
            r130 = null;
            goto L262
        L255:
            r99 = null;
        L266:
            final BotUpdateFragment r132 = this.this$0;
            if (r132.j == null) goto L271;
            o5.b(r132, "access_permission_request", new o0(r132));
            o5.b(r132, "public_permission_result_request", new p0(r132));
        L271:
            return Unit.INSTANCE;
        L238:
            if (r126.j != null) goto L241;
        L249:
            Unit r133 = Unit.INSTANCE;
            goto L250
        L241:
            if (r126.an() == true) goto L244;
            r2 = 8;
        L244:
            r95.setVisibility(r2);
            BotModel r100 = r126.j;
            if (r100 == null) goto L247;
            Integer r101 = r100.getPrivateStatus();
        L248:
            r126.aa0(r101);
            com.larus.utils.e1.d(r95, new n0(r126));
            goto L249
        L247:
            r101 = null;
            goto L248
        L273:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "bot_update";
    }

    public final boolean V90() {
        return ((Boolean) this.D.getValue()).booleanValue();
    }

    public final GetMatchVoiceRequest W90() {
        GetMatchVoiceRequest r10 = new GetMatchVoiceRequest(null, null, null, null, 0, null, RecommendScene.BOT_UPDATE, 63);
        BotEditParam r0 = X90().getEditParam();
        String r1 = "";
        if (r0 == null) goto L6;
        String r2 = r0.getName();
        if (r2 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r10.a = r2;
        BotEditParam r3 = X90().getEditParam();
        if (r3 == null) goto L11;
        String r4 = r3.getDescription();
        if (r4 == null) goto L11;
    L12:
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r10.b = r4;
        SpeakerVoice r5 = this.o;
        if (r5 == null) goto L16;
        String r6 = r5.getId();
        if (r6 == null) goto L16;
    L17:
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r10.c = r6;
        BotEditParam r7 = X90().getEditParam();
        if (r7 == null) goto L21;
        String r8 = r7.getBotId();
        if (r8 == null) goto L21;
    L22:
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r10.d = r8;
        BotEditParam r9 = X90().getEditParam();
        if (r9 == null) goto L25;
        long r11 = r9.getModelType();
    L26:
        r10.e = r11;
        SpeakerVoice r12 = this.o;
        if (r12 == null) goto L32;
        String r13 = r12.getLanguageCode();
        if (r13 == null) goto L32;
        r1 = r13;
    L32:
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r10.f = r1;
        return r10;
    L25:
        r11 = 0;
    L21:
        r8 = "";
    L16:
        r6 = "";
    L11:
        r4 = "";
    L6:
        r2 = "";
        goto L7
    }

    public final BotUpdateViewModel X90() {
        return (BotUpdateViewModel) this.h.getValue();
    }

    public final void Z90() {
        CommonDialog.a r0 = new CommonDialog.a();
        r0.i(getString(2131905453));
        CommonDialog.a.f(r0, new c(this), getString(2131899260), false, 12);
        CommonDialog.a.e(r0, new d(), getString(2131899259), 4);
        CommonDialog r1 = r0.c();
        FragmentManager r2 = getChildFragmentManager();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, null, r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r1, r3) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r1.show(r2, null);
        return;
    }

    @Override // ru8.f
    public final boolean an() {
        BotModel r0 = this.j;
        if (r0 == null) goto L7;
        BotCreatorInfo r1 = r0.getBotCreatorInfo();
        if (r1 == null) goto L7;
        String r2 = r1.getId();
    L8:
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        String r3 = AccountService.a.getUserId();
        FLogger.a.i("BotUpdateFragment", "isCreator called: creatorId = " + r2 + ", userId = " + r3);
        return Intrinsics.areEqual(r2, r3);
    L7:
        r2 = null;
        goto L8
    }

    @Override // ru8.e
    public final com.larus.common_ui.dialog.l0 uL() {
        return (com.larus.common_ui.dialog.l0) this.A.getValue();
    }

    public BotUpdateFragment() {
        this.e = 200;
        this.g = IAIChatService.a.k8();
        final Function0<Fragment> r0 = new BotUpdateFragment$special$$inlined$viewModels$default$1(this);
        this.h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BotUpdateViewModel.class), new BotUpdateFragment$special$$inlined$viewModels$default$2(r0), new BotUpdateFragment$special$$inlined$viewModels$default$3(r0, this));
        this.i = "";
        FeatureKitDelegate r1 = FeatureKitDelegate.b;
        this.q = r1.b0().b();
        this.r = r1.a0().b();
        e10 r2 = e10.a;
        this.s = e10.D().enableAdvance;
        this.x = LazyKt.lazy(new b1(this));
        final Function0<Fragment> r3 = new BotUpdateFragment$special$$inlined$viewModels$default$4(this);
        this.y = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(LanguageItemViewModel.class), new BotUpdateFragment$special$$inlined$viewModels$default$5(r3), new BotUpdateFragment$special$$inlined$viewModels$default$6(r3, this));
        final Function0<Fragment> r4 = new BotUpdateFragment$special$$inlined$viewModels$default$7(this);
        this.z = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SpeakerVoiceItemViewModel.class), new BotUpdateFragment$special$$inlined$viewModels$default$8(r4), new BotUpdateFragment$special$$inlined$viewModels$default$9(r4, this));
        this.A = LazyKt.lazy(new c1(this));
        this.D = LazyKt.lazy(new d1(this));
        this.E = LazyKt.lazy(new e1(this));
        this.H = DescPolishBtnStatus.DISABLE;
        this.I = DescPolishStatus.BEFORE_POLISH;
        this.J = LazyKt.lazy(new f1());
    }

    @Override // ru8.f
    public final String Y8() {
        return b();
    }

    public final void Y90() {
        com.bytedance.router.i r0 = SmartRouter.buildRoute(getContext(), "//flow/single_tts_speaker_setting");
        Pair[] r1 = new Pair[9];
        BotLanguage r2 = this.n;
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.c();
    L6:
        r1[0] = TuplesKt.to("key_language_code", r4);
        r1[1] = TuplesKt.to("key_initial_voice", this.o);
        BotLanguage r5 = this.n;
        if (r5 == null) goto L9;
        String r6 = r5.b();
    L10:
        r1[2] = TuplesKt.to("key_language_name", r6);
        r1[3] = TuplesKt.to("enter_from", "bot_setting");
        r1[4] = TuplesKt.to("key_ui_mode", Boolean.TRUE);
        r1[5] = TuplesKt.to("key_voice_recommend_param", W90());
        r1[6] = TuplesKt.to("key_enter_method", "bot_update");
        BotModel r7 = this.j;
        if (r7 == null) goto L13;
        r3 = r7.getBotId();
    L13:
        r1[7] = TuplesKt.to("key_tts_bot_id", r3);
        r1[8] = TuplesKt.to("select_speaker_argument", this.j);
        Bundle r8 = com.larus.utils.f.c(r1);
        by7.h.k(r8, this);
        r8.putString(MusicAppletPage.KEY_CONVERSATION_ID, this.i);
        r0.c.putExtras(r8);
        r0.c.addFlags(536870912);
        r0.d = 2130772401;
        r0.e = 2130772399;
        r0.e(this.e);
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final String b() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L14;
        String r1 = r0.getString("previous_page");
        if (r1 != null) goto L7;
        return null;
    L7:
        if (r1.length() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        return null;
    L13:
        return r1;
    L9:
        r2 = false;
        goto L10
    L14:
        return null;
    }

    @Override // ru8.f
    public final BotUpdateViewModel c50() {
        return X90();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.f = null;
    }

    @Override // ru8.e
    public final LifecycleOwner s4() {
        return getViewLifecycleOwner();
    }

    @Override // ru8.e
    public final com.larus.bot.impl.feature.edit.feature.main.c uk() {
        return X90().getMainEditViewModel();
    }

    @Override // ru8.f
    public final BotModel FH() {
        return this.j;
    }

    @Override // ru8.e
    public final DescPolishBtnStatus Gy() {
        return this.H;
    }

    @Override // ru8.f
    public final EditPos Ph() {
        return this.k;
    }

    @Override // ru8.f
    public final com.larus.bmhome.setting.b U9() {
        return this.g;
    }

    @Override // ru8.e
    public final LarusPageBotEditBinding e() {
        return this.f;
    }

    @Override // ru8.e
    public final DescPolishStatus en() {
        return this.I;
    }

    @Override // ru8.e
    public final com.larus.bmhome.utils.x1 jZ() {
        return this.B;
    }

    @Override // ru8.f
    public final boolean lC() {
        return this.F;
    }

    public static final void U90(final BotUpdateFragment r8) {
        LarusPageBotEditBinding r0 = r8.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 28) goto L11;
        Context r1 = r8.getContext();
        if (r1 == null) goto L11;
        int r2 = com.larus.utils.i.d(r1) - c7.b(64);
        String r3 = r1.getResources().getString(2131901106);
        StaticLayout r4 = com.larus.bot.impl.common.util.j.b(r0.o, r3 + '\n' + r3 + '\n' + r3 + '\n' + r3, r2);
        StaticLayout r5 = com.larus.bot.impl.common.util.j.b(r0.o, r3 + '\n' + r3 + '\n' + r3 + '\n' + r3 + '\n' + r3 + '\n' + r3 + '\n' + r3 + '\n' + r3, r2);
        r0.o.setMinHeight(r4.getHeight());
        r0.o.setMaxHeight(r5.getHeight());
    L11:
        Unit r6 = Unit.INSTANCE;
        AppCompatEditText r7 = r0.o;
        EditPos r9 = r8.k;
        if (r9 == null) goto L14;
        boolean r10 = r9.e();
    L15:
        r7.setEnabled(r10);
        AppCompatEditText r11 = r0.o;
        if (r11.isEnabled() == true) goto L18;
        float r12 = 0.3f;
    L19:
        r11.setAlpha(r12);
        final Context r13 = r8.getContext();
        if (r13 == null) goto L22;
        r0.o.setFilters(new InputFilter[]{new com.larus.bot.impl.common.util.c(r13.getResources().getInteger(2131427365), new v0(r13))});
    L22:
        AppCompatEditText r14 = r0.o;
        BotModel r15 = r8.j;
        if (r15 == null) goto L25;
        String r16 = r15.getDescriptionForHuman();
    L26:
        r14.setText(r16);
        r0.o.addTextChangedListener(new w1(r8));
        com.larus.bot.impl.common.util.j.a(r0.o);
        e10 r17 = e10.a;
        if (e10.B0() == false) goto L36;
        Context r18 = r8.getContext();
        if (r18 == null) goto L33;
        Resources r19 = r18.getResources();
        if (r19 == null) goto L33;
        r0.o.setTextColor(r19.getColor(2131103140));
        r0.o.setHintTextColor(r19.getColor(2131103140));
        r0.n.setTextColor(r19.getColor(2131103140));
    L33:
        r0.o.setKeyListener(null);
        r0.l.setEnabled(false);
        r0.o.setOnClickListener(new x0(r8));
        r0.o.setOnLongClickListener(new y0(r8));
        return;
    L36:
        return;
    L25:
        r16 = null;
        goto L26
    L18:
        r12 = 1.0f;
        goto L19
    L14:
        r10 = false;
        goto L15
    }

    @Override // ru8.e
    public final void I90(DescPolishBtnStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "status");
        this.H = r2;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.larus.bmhome.view.item.ItemLongTextArrow] */
    public final void aa0(Integer r4) {
        ?? r0 = this.w;
        if (r0 == 0) goto L22;
        if (r4 != null) goto L7;
    L9:
        if (r4 != null) goto L12;
    L14:
        if (r4 != null) goto L17;
    L19:
        r0.setVisibility(8);
    L20:
        Unit r5 = Unit.INSTANCE;
        return;
    L17:
        if (r4.intValue() != 2) goto L19;
        r0.setImageSrc(2131240934);
        r0.setText(getString(2131908270));
        goto L20
    L12:
        if (r4.intValue() != 3) goto L14;
        r0.setImageSrc(2131240936);
        r0.setText(getString(2131910873));
        goto L20
    L7:
        if (r4.intValue() != 1) goto L9;
        r0.setImageSrc(2131240935);
        r0.setText(getString(2131908271));
        goto L20
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.ViewGroup, com.larus.bmhome.view.item.ItemTextArrow] */
    public final void ba0(boolean r9) {
        SpeakerVoice r0 = this.o;
        if (r0 != null) goto L8;
        BotModel r1 = this.j;
        if (r1 == null) goto L7;
        r0 = r1.getVoiceType();
        goto L8
    L7:
        r0 = null;
    L8:
        SpeakerVoice r4 = r0;
        ((LanguageItemViewModel) this.y.getValue()).refreshLanguageItemStyle(r4, this.k);
        ?? r3 = this.t;
        if (r3 == 0) goto L16;
        IAIChatService.Companion r2 = IAIChatService.a;
        Context r5 = r3.getContext();
        BotModel r6 = this.j;
        if (r6 == null) goto L13;
        boolean r7 = r6.getMuted();
    L14:
        r2.z7(r5, r3, r4, r7, this.k, !r9);
        return;
    L13:
        r7 = false;
        goto L14
    }

    @Override // ru8.e
    public final void fO(DescPolishStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "status");
        this.I = r2;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        if (getArguments() == null) goto L42;
        this.i = requireArguments().getString("bot_update_conversation_argument", "");
        if (getArguments() != null) goto L9;
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L42;
        r5.finish();
        goto L42
    L9:
        Bundle r6 = getArguments();
        String r0 = null;
        if (r6 == null) goto L12;
        Serializable r7 = r6.getSerializable("bot_update_bot_argument");
    L14:
        if ((r7 instanceof BotModel) == false) goto L16;
        BotModel r8 = (BotModel) r7;
    L17:
        this.j = r8;
        if (r8 != null) goto L22;
        FragmentActivity r9 = getActivity();
        if (r9 == null) goto L22;
        r9.finish();
    L22:
        X90().setBotInfo(this.j);
        if (V90() == false) goto L42;
        if (((Boolean) this.E.getValue()).booleanValue() == false) goto L42;
        Boolean r10 = Boolean.TRUE;
        Bundle r1 = getArguments();
        if (r1 == null) goto L29;
        Boolean r2 = Boolean.valueOf(r1.getBoolean("show_image_guide"));
    L31:
        if (Intrinsics.areEqual(r10, r2) == false) goto L42;
        BotModel r11 = this.j;
        if (r11 == null) goto L35;
        r0 = r11.getBgImgUri();
    L35:
        if (r0 != null) goto L42;
        tu8.a.a.getClass();
        if (tu8.a.b.getBoolean("has_entered_bg_image_new_user_guide", false) == true) goto L42;
        Context r12 = getContext();
        if (r12 == null) goto L41;
        int r3 = BgImageNewUserGuideActivity.h;
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(this, "trackNode");
        com.bytedance.router.i r13 = SmartRouter.buildRoute(r12, "//flow/bot_create_bg_image_new_user_guide");
        Bundle r14 = BundleKt.bundleOf();
        by7.h.k(r14, this);
        r13.c.putExtras(r14);
        r13.d = 2130772400;
        r13.e = 2130772399;
        r13.e(789);
    L41:
        this.F = true;
        goto L42
    L29:
        r2 = null;
        goto L31
    L16:
        r8 = null;
        goto L17
    L12:
        r7 = null;
    L42:
        p2a.f r15 = (p2a.f) this.J.getValue();
        if (r15 == null) goto L45;
        r15.Z();
    L45:
        FLogger.a.d("BotUpdateFragment", "attachComponent");
        s1a.a.g(this).c(this, ru8.e.class);
        s1a.a.g(this).c(this, ru8.f.class);
        k1a.b.a(this, new m0(this));
    }

    public final void onViewCreated(View r17, Bundle r18) {
        Intrinsics.checkNotNullParameter(r17, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r17, r18);
        String r0 = null;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        LarusPageBotEditBinding r2 = this.f;
        boolean r3 = true;
        int r4 = 0;
        if (r2 == null) goto L59;
        ConstraintLayout r5 = r2.a;
        if (r5 == null) goto L59;
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L9;
        int r7 = com.larus.utils.u.c(r6);
    L10:
        r5.setPaddingRelative(r5.getPaddingStart(), r7, r5.getPaddingEnd(), r5.getPaddingBottom());
        if (r5.isAttachedToWindow() == false) goto L46;
        WindowInsetsCompat r8 = ViewCompat.getRootWindowInsets(r5);
        if (r8 == null) goto L47;
        Insets r9 = r8.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r9 == null) goto L47;
        LarusPageBotEditBinding r10 = this.f;
        if (r10 == null) goto L31;
        BotEditScrollView r11 = r10.J;
        if (r11 == null) goto L31;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L30;
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
    L26:
        if (r13 == null) goto L28;
        r13.bottomMargin = r9.bottom;
    L28:
        r11.setLayoutParams(r12);
        goto L31
    L25:
        r13 = null;
        goto L26
    L30:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L31:
        LarusPageBotEditBinding r14 = this.f;
        if (r14 == null) goto L47;
        ConstraintLayout r15 = r14.h;
        if (r15 == null) goto L47;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L45;
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == false) goto L40;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r16;
    L41:
        if (r19 == null) goto L43;
        r19.bottomMargin = r9.bottom;
    L43:
        r15.setLayoutParams(r16);
        goto L47
    L40:
        r19 = null;
        goto L41
    L45:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L47:
        p2a.a r20 = IAIChatService.a.u7();
        if (r20 == null) goto L54;
        p2a.p r21 = r20.c();
        if (r21 == null) goto L54;
        if (r21.a != true) goto L54;
        boolean r22 = true;
    L55:
        if (r22 == false) goto L57;
    L58:
        ViewExtKt.n(r5, new u0(this), null, null, 6);
        goto L59
    L57:
        if (V90() == false) goto L59;
    L54:
        r22 = false;
        goto L55
    L46:
        r5.addOnAttachStateChangeListener(new x1(r5, this));
        goto L47
    L9:
        r7 = 0;
    L59:
        String r23 = X90().getDraftId();
        String r24 = b();
        String r25 = "bot_setting";
        if (r24 != null) goto L63;
        r24 = "bot_setting";
    L63:
        if (Intrinsics.areEqual(b(), "notify") == false) goto L71;
        Boolean r26 = Boolean.TRUE;
        Bundle r27 = getArguments();
        if (r27 == null) goto L67;
        Boolean r28 = Boolean.valueOf(r27.getBoolean("show_image_guide"));
    L69:
        if (Intrinsics.areEqual(r26, r28) == false) goto L71;
        r25 = "new_guidance_to_edit_notification";
        goto L71
    L67:
        r28 = null;
    L71:
        BotModel r29 = X90().getBotInfo();
        String r30 = "ai_generate";
        if (r29 == null) goto L95;
        BotIconImage r110 = r29.getIconImage();
        if (r110 == null) goto L76;
        String r111 = r110.getUri();
    L77:
        if (r111 != null) goto L79;
    L82:
        boolean r112 = true;
    L83:
        if (r112 == true) goto L95;
        BgImageInfo r113 = r29.getBgImgInfo();
        if (r113 == null) goto L88;
        boolean r114 = Intrinsics.areEqual(r113.getAiGenBgImg(), Boolean.TRUE);
    L89:
        if (r114 == false) goto L91;
    L94:
        String r31 = "ai_generate";
    L96:
        BotModel r115 = X90().getBotInfo();
        String r116 = "no_image";
        if (r115 == null) goto L115;
        String r117 = r115.getBgImgUri();
        if (r117 != null) goto L101;
    L104:
        boolean r118 = true;
    L105:
        if (r118 == false) goto L107;
        r30 = "no_image";
    L114:
        r116 = r30;
        goto L115
    L107:
        BgImageInfo r119 = r115.getBgImgInfo();
        if (r119 == null) goto L110;
        boolean r120 = Intrinsics.areEqual(r119.getAiGenBgImg(), Boolean.TRUE);
    L111:
        if (r120 == true) goto L114;
        r30 = "uploaded";
        goto L114
    L110:
        r120 = false;
        goto L111
    L101:
        if (StringsKt.isBlank(r117) == true) goto L104;
        r118 = false;
    L115:
        BotModel r32 = X90().getBotInfo();
        if (r32 == null) goto L122;
        BgImageInfo r33 = r32.getBgImgInfo();
        if (r33 == null) goto L122;
        Boolean r34 = r33.getBgImgOpen();
        if (r34 == null) goto L122;
        boolean r35 = r34.booleanValue();
    L123:
        BotModel r36 = X90().getBotInfo();
        if (r36 == null) goto L126;
        String r37 = r36.getBotId();
    L127:
        BotModel r121 = X90().getBotInfo();
        if (r121 == null) goto L132;
        SpeakerVoice r122 = r121.getVoiceType();
        if (r122 == null) goto L132;
        String r123 = r122.getId();
    L133:
        BotModel r124 = X90().getBotInfo();
        if (r124 == null) goto L136;
        SpeakerVoice r125 = r124.getVoiceType();
    L137:
        String r126 = dv8.c.b(r125);
        BotModel r127 = X90().getBotInfo();
        if (r127 == null) goto L142;
        FirstMet r128 = r127.getFirstMet();
        if (r128 == null) goto L142;
        String r129 = r128.getPrologue();
    L143:
        boolean r130 = com.larus.utils.o0.d(r129);
        BotModel r131 = X90().getBotInfo();
        if (r131 == null) goto L150;
        FirstMet r132 = r131.getFirstMet();
        if (r132 == null) goto L150;
        List r133 = r132.getSuggests();
        if (r133 == null) goto L150;
        r4 = r133.size();
    L150:
        BotModel r134 = X90().getBotInfo();
        if (r134 == null) goto L157;
        FirstMet r135 = r134.getFirstMet();
        if (r135 == null) goto L157;
        Boolean r136 = r135.getSuggestSwitch();
        if (r136 == null) goto L157;
        r3 = r136.booleanValue();
    L157:
        BotModel r137 = X90().getBotInfo();
        if (r137 == null) goto L160;
        r0 = r137.getBioEdit();
    L160:
        boolean r1 = com.larus.utils.o0.d(r0);
        Boolean r138 = Boolean.FALSE;
        Boolean r139 = Boolean.valueOf(r130);
        Integer r38 = Integer.valueOf(r4);
        Boolean r39 = Boolean.valueOf(r3);
        Boolean r40 = Boolean.valueOf(r35);
        Boolean r41 = Boolean.valueOf(r1);
        JSONObject r42 = new JSONObject();
        Intrinsics.checkNotNullParameter(r42, "params");
        if (r37 != null) goto L206;
    L163:
        r42.put("current_page", "bot_description_modify_page");     // Catch: JSONException -> L202
        r42.put("previous_page", r24);     // Catch: JSONException -> L202
        if (r23 == null) goto L166;
        r42.put("draft_id", r23);     // Catch: JSONException -> L202
    L166:
        String r43 = "1";
        if (r41 != null) goto L169;
    L173:
        r42.put("edit_way", r25);     // Catch: JSONException -> L202
        if (r138 == null) goto L176;
        r42.put("if_auto_filled", TriggerSendLoading.NO_LOADING);     // Catch: JSONException -> L202
    L176:
        if (r139 != null) goto L178;
    L182:
        if (r38 == null) goto L184;
        r42.put("sp_cnt", r38.intValue());     // Catch: JSONException -> L202
    L184:
        if (r39 != null) goto L186;
    L190:
        r42.put("profile_photo_type", r31);     // Catch: JSONException -> L202
        r42.put("image_type", r116);     // Catch: JSONException -> L202
        if (r40 != null) goto L193;
    L197:
        if (r123 == null) goto L199;
        r42.put("voice_id", r123);     // Catch: JSONException -> L202
    L199:
        if (r126 == null) goto L204;
        r42.put("voice_type", r126);     // Catch: JSONException -> L202
    L202:
        e = move-exception;
        FLogger.a.e("BotCreateEventHelper", "error in BotCreateEventHelper bot_description_modify_enter " + e.getLocalizedMessage());
    L204:
        TrackParams r44 = new TrackParams().merge(r42);
        by7.a r45 = new by7.a("bot_description_modify_enter");
        r45.a.merge(r44);
        r45.b();
        return;
    L193:
        if (r40.booleanValue() == true) goto L196;
        r43 = TriggerSendLoading.NO_LOADING;
    L196:
        r42.put("background_status", r43);     // Catch: JSONException -> L202
        goto L197
    L186:
        if (r39.booleanValue() == false) goto L188;
        Object r46 = "1";
    L189:
        r42.put("sp_status", r46);     // Catch: JSONException -> L202
        goto L190
    L188:
        r46 = TriggerSendLoading.NO_LOADING;
        goto L189
    L178:
        if (r139.booleanValue() == false) goto L180;
        Object r47 = "1";
    L181:
        r42.put("if_has_onboarding", r47);     // Catch: JSONException -> L202
        goto L182
    L180:
        r47 = TriggerSendLoading.NO_LOADING;
        goto L181
    L169:
        if (r41.booleanValue() == false) goto L171;
        Object r48 = "1";
    L172:
        r42.put("if_has_bio", r48);     // Catch: JSONException -> L202
        goto L173
    L171:
        r48 = TriggerSendLoading.NO_LOADING;
        goto L172
    L206:
        r42.put("bot_id", r37);     // Catch: JSONException -> L202
    L142:
        r129 = null;
        goto L143
    L136:
        r125 = null;
    L132:
        r123 = null;
        goto L133
    L126:
        r37 = null;
    L122:
        r35 = false;
        goto L123
    L91:
        if (com.larus.utils.o0.d(r29.getIconPrompt()) == true) goto L94;
        r31 = "uploaded";
        goto L96
    L88:
        r114 = false;
        goto L89
    L79:
        if (StringsKt.isBlank(r111) == true) goto L82;
        r112 = false;
        goto L83
    L76:
        r111 = null;
    L95:
        r31 = "default";
        goto L96
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        LarusPageBotEditBinding r12 = LarusPageBotEditBinding.a(r9, r10);
        this.B = new com.larus.bmhome.utils.x1(r12.o);
        FrameLayout r13 = r12.f;
        if (V90() == false) goto L5;
        LarusLayoutBotEditBgImageBinding r14 = LarusLayoutBotEditBgImageBinding.a(r9, r13);
        this.C = new BotBgImageEditView(this, r14, X90().getBgImageEditViewModel(), null);
        r13.addView(r14.a);
    L8:
        this.f = r12;
        return r12.a;
    L5:
        ViewGroup.LayoutParams r0 = r13.getLayoutParams();
        if (r0 == null) goto L11;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        r1.height = c7.b(120);
        r1.width = c7.b(120);
        r1.topMargin = c7.b(12);
        r13.setLayoutParams(r1);
        this.C = new BotAvatarEditView(this, LarusLayoutBotEditAvatarBinding.a(r9, r13), X90().getAvatarEditModel(), null, this.B);
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
