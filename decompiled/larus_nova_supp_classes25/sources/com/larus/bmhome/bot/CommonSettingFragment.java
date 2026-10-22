package com.larus.bmhome.bot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.auth.CocoSetting;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.bot.dialog.BotAvatarViewerCanChangeIconDialog;
import com.larus.bmhome.bot.dialog.BotAvatarViewerDialog;
import com.larus.bmhome.bot.share.ShareBotController;
import com.larus.bmhome.bot.share.ShareBotController$performShareBot$1;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.auth.PluginManager;
import com.larus.bmhome.chat.auth.PluginManagerDelegate;
import com.larus.bmhome.chat.auth.model.PluginItem;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.manager.ExpertSwitchManager;
import com.larus.bmhome.chat.model.api.DefaultActiveModeSettingValue;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuConfigV2;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuData;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuDataV2;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuItem;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchMenuConfig;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchMenuItem;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchMenuMode;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchModeConfig;
import com.larus.bmhome.chat.model.api.UserConfigActiveMode;
import com.larus.bmhome.chat.model.api.UserConfigActiveModeMenu;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.setting.UserSettingDelegate;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.common_ui.image.CustomPhotoViewerDialog;
import com.larus.bmhome.databinding.LarusPageChatSettingBinding;
import com.larus.bmhome.databinding.LarusPageChatSettingMainBotBinding;
import com.larus.bmhome.input.api.EnterKeyAction;
import com.larus.bmhome.input.api.EnterKeyBehaviorHostDelegate;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.view.AppInfoLayout;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemLongTextArrow;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextMenu;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.bmhome.view.item.ItemTextView;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.common.apphost.AppHost;
import com.larus.common_res.common_ui.databinding.LarusShareButtonCenterLayoutBinding;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.widget.TagTextView;
import com.larus.im.bean.bot.AudioPreview;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotMemoryConfig;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.ShareInfo;
import com.larus.im.bean.bot.ShowTagInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.internal.core.conversation.bot.BotServiceImpl;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IAudioSettingRuntimeProvider;
import com.larus.platform.api.IFlowSettingThemeConfigProvider;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.model.EditPos;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.model.UserConfigItem;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.platform.spi.IAIChatConversationService;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.FragmentExtKt;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.account.ObricAccountSPIServiceDelegate;
import com.obric.assistant.spi.task.ObricTaskSkillDelegate;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.json.JSONException;
import org.json.JSONObject;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000È\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\u008d\u0002\u0018\u0000 \u0095\u00032\u00020\u00012\u00020\u0002:\u0002\u0095\u0003B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u008a\u0001\u001a\u00030\u008b\u00012\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0016J\u0014\u0010\u008e\u0001\u001a\u00030\u008b\u00012\b\u0010\u008f\u0001\u001a\u00030\u008d\u0001H\u0016J\n\u0010\u0090\u0001\u001a\u00030\u008b\u0001H\u0002J.\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u00012\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0016J\t\u0010\u0097\u0001\u001a\u00020\u0006H\u0002J\n\u0010\u0098\u0001\u001a\u00030\u008b\u0001H\u0002J \u0010\u0099\u0001\u001a\u00030\u008b\u00012\b\u0010\u009a\u0001\u001a\u00030\u0092\u00012\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0016J\n\u0010\u009b\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010\u009c\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010\u009d\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010\u009e\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010\u009f\u0001\u001a\u00030\u008b\u0001H\u0016J\n\u0010 \u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010¢\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010£\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010¤\u0001\u001a\u00030\u008b\u0001H\u0016J\n\u0010¥\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010¦\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010§\u0001\u001a\u00030\u008b\u0001H\u0016J\u0011\u0010¨\u0001\u001a\u00030\u008b\u00012\u0007\u0010©\u0001\u001a\u00020\u0006J\u0013\u0010ª\u0001\u001a\u00030\u008b\u00012\u0007\u0010«\u0001\u001a\u00020!H\u0002J\u0012\u0010¬\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\f\u0010®\u0001\u001a\u0005\u0018\u00010¯\u0001H\u0002J\t\u0010°\u0001\u001a\u00020xH\u0002J\n\u0010±\u0001\u001a\u00030\u008b\u0001H\u0002J\t\u0010²\u0001\u001a\u00020!H\u0002J\u0014\u0010³\u0001\u001a\u00030\u008b\u00012\b\u0010´\u0001\u001a\u00030µ\u0001H\u0002J\u0012\u0010¶\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\n\u0010·\u0001\u001a\u00030\u008b\u0001H\u0002J\u0016\u0010¸\u0001\u001a\u00030\u008b\u00012\n\u0010¹\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0002J\u001f\u0010º\u0001\u001a\u00030\u008b\u00012\n\u0010¹\u0001\u001a\u0005\u0018\u00010\u0096\u00012\u0007\u0010»\u0001\u001a\u00020!H\u0002J\n\u0010¼\u0001\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010½\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\n\u0010¾\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010¿\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010À\u0001\u001a\u00030\u008b\u0001H\u0002J\f\u0010Á\u0001\u001a\u0005\u0018\u00010Â\u0001H\u0002J\u001d\u0010Ã\u0001\u001a\u0004\u0018\u00010\t2\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Â\u0001H\u0002¢\u0006\u0003\u0010Å\u0001J\u0017\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00062\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Â\u0001H\u0002J\u0017\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00062\n\u0010Ç\u0001\u001a\u0005\u0018\u00010È\u0001H\u0002J\u0015\u0010É\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010Ê\u0001\u001a\u00030Ë\u0001H\u0002J\n\u0010Ì\u0001\u001a\u00030\u008b\u0001H\u0002J\u001e\u0010Í\u0001\u001a\u00030\u008b\u00012\b\u0010Î\u0001\u001a\u00030\u0092\u00012\b\u0010Ê\u0001\u001a\u00030Ë\u0001H\u0002J\u0014\u0010Ï\u0001\u001a\u00030\u008b\u00012\b\u0010Ð\u0001\u001a\u00030Ñ\u0001H\u0002J\u0014\u0010Ò\u0001\u001a\u00030\u008b\u00012\b\u0010Ð\u0001\u001a\u00030Ñ\u0001H\u0002J\n\u0010Ó\u0001\u001a\u00030\u008b\u0001H\u0002J\u001f\u0010Ô\u0001\u001a\u00030\u008b\u00012\b\u0010Ç\u0001\u001a\u00030È\u00012\t\u0010Õ\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010Ö\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010×\u0001\u001a\u00030\u008b\u0001H\u0002J\u0014\u0010Ø\u0001\u001a\u00030\u008b\u00012\b\u0010Ù\u0001\u001a\u00030Ú\u0001H\u0002J\n\u0010Û\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010Ü\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010Ý\u0001\u001a\u00030\u008b\u0001H\u0002J\u0013\u0010Þ\u0001\u001a\u00020\u00062\b\u0010ß\u0001\u001a\u00030à\u0001H\u0002J\n\u0010á\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010â\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010ã\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010ä\u0001\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010å\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\f\u0010æ\u0001\u001a\u0005\u0018\u00010ç\u0001H\u0002J\n\u0010è\u0001\u001a\u00030\u008b\u0001H\u0002J\u0013\u0010é\u0001\u001a\u00020\u00062\b\u0010ê\u0001\u001a\u00030ë\u0001H\u0002J\u0012\u0010ì\u0001\u001a\u00020\u00062\u0007\u0010í\u0001\u001a\u000202H\u0002J\u0013\u0010î\u0001\u001a\u00020\u00062\b\u0010ï\u0001\u001a\u00030ð\u0001H\u0002J\n\u0010ñ\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010ò\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010ó\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010ô\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010õ\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010ö\u0001\u001a\u00030\u008b\u0001H\u0002J\f\u0010÷\u0001\u001a\u0005\u0018\u00010ø\u0001H\u0002J\n\u0010ù\u0001\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010ú\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\n\u0010û\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010ü\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010ý\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010þ\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010ÿ\u0001\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010\u0080\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0012\u0010\u0081\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u001e\u0010\u0082\u0002\u001a\u0005\u0018\u00010\u008b\u00012\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0083\u0002H\u0002¢\u0006\u0003\u0010\u0084\u0002J\t\u0010\u0085\u0002\u001a\u00020!H\u0002J\u000b\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u0006H\u0002J\t\u0010\u0087\u0002\u001a\u00020!H\u0002J\f\u0010\u0088\u0002\u001a\u0005\u0018\u00010ç\u0001H\u0002J\u0012\u0010\u0089\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0014\u0010\u008a\u0002\u001a\u00030\u008b\u00012\b\u0010\u008b\u0002\u001a\u00030\u008d\u0001H\u0016J\n\u0010\u008f\u0002\u001a\u00030\u008b\u0001H\u0002J\t\u0010\u0090\u0002\u001a\u00020!H\u0002J\u0012\u0010\u0091\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\n\u0010\u0092\u0002\u001a\u00030\u008b\u0001H\u0002J\n\u0010\u0093\u0002\u001a\u00030\u008b\u0001H\u0002J\u001e\u0010\u0094\u0002\u001a\u0005\u0018\u00010\u008b\u00012\n\u0010\u0095\u0002\u001a\u0005\u0018\u00010\u0096\u0002H\u0002¢\u0006\u0003\u0010\u0097\u0002J\u001d\u0010\u0098\u0002\u001a\u0004\u0018\u00010\t2\n\u0010\u0099\u0002\u001a\u0005\u0018\u00010\u009a\u0002H\u0002¢\u0006\u0003\u0010\u009b\u0002J\u0015\u0010\u009e\u0002\u001a\u00030\u008b\u00012\t\u0010\u009f\u0002\u001a\u0004\u0018\u00010\u0006H\u0002J-\u0010 \u0002\u001a\u00030\u008b\u00012\t\u0010\u009f\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010¡\u0002\u001a\u0004\u0018\u00010\u00062\u000b\b\u0002\u0010¢\u0002\u001a\u0004\u0018\u00010\u0006H\u0002J\u0014\u0010£\u0002\u001a\u00020\t2\t\u0010¤\u0002\u001a\u0004\u0018\u00010\u0006H\u0002J\t\u0010¥\u0002\u001a\u00020!H\u0002J\u0012\u0010¦\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0012\u0010§\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\f\u0010¨\u0002\u001a\u0005\u0018\u00010©\u0002H\u0002J\u0012\u0010ª\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0012\u0010«\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\t\u0010¬\u0002\u001a\u00020!H\u0002J\u0012\u0010\u00ad\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\t\u0010®\u0002\u001a\u00020!H\u0002J\u0014\u0010¯\u0002\u001a\u00030\u008b\u00012\b\u0010\u008b\u0002\u001a\u00030\u008d\u0001H\u0002J\u001b\u0010°\u0002\u001a\u0005\u0018\u00010\u008b\u00012\u0007\u0010±\u0002\u001a\u00020'H\u0002¢\u0006\u0003\u0010²\u0002J\u0012\u0010³\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0014\u0010´\u0002\u001a\u00030\u008b\u00012\b\u0010\u008b\u0002\u001a\u00030\u008d\u0001H\u0002J\u0018\u0010µ\u0002\u001a\u00030\u008b\u00012\f\b\u0002\u0010Ð\u0001\u001a\u0005\u0018\u00010¶\u0002H\u0002J\u0014\u0010·\u0002\u001a\u00030\u008b\u00012\b\u0010\u008b\u0002\u001a\u00030\u008d\u0001H\u0002J\n\u0010¸\u0002\u001a\u00030\u008b\u0001H\u0002J\u001d\u0010¹\u0002\u001a\u00030\u008b\u00012\u0011\u0010º\u0002\u001a\f\u0012\u0005\u0012\u00030¼\u0002\u0018\u00010»\u0002H\u0002J\u0014\u0010½\u0002\u001a\u00030\u008b\u00012\b\u0010\u008b\u0002\u001a\u00030\u008d\u0001H\u0002J\n\u0010¾\u0002\u001a\u00030\u008b\u0001H\u0002J\n\u0010¿\u0002\u001a\u00030\u008b\u0001H\u0002JH\u0010À\u0002\u001a\u00030\u008b\u00012\u0006\u0010&\u001a\u00020'2\u0007\u0010Á\u0002\u001a\u00020!2+\b\u0002\u0010Â\u0002\u001a$\u0012\u0016\u0012\u00140!¢\u0006\u000f\bÄ\u0002\u0012\n\bÅ\u0002\u0012\u0005\b\b(Æ\u0002\u0012\u0005\u0012\u00030\u008b\u0001\u0018\u00010Ã\u0002H\u0002J\u0012\u0010Ç\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\n\u0010È\u0002\u001a\u00030\u008b\u0001H\u0002J\u001c\u0010É\u0002\u001a\u00030Ê\u00022\u0006\u0010&\u001a\u00020'2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0012\u0010Ë\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0015\u0010Ì\u0002\u001a\u00030\u008b\u00012\t\u0010Å\u0002\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010Í\u0002\u001a\u0005\u0018\u00010\u008b\u00012\u0006\u0010&\u001a\u00020'H\u0002¢\u0006\u0003\u0010²\u0002J\n\u0010Î\u0002\u001a\u00030\u008b\u0001H\u0016J\u0013\u0010Ï\u0002\u001a\u00030\u008b\u00012\u0007\u0010Ð\u0002\u001a\u00020\u0006H\u0002J\f\u0010Ñ\u0002\u001a\u0005\u0018\u00010ç\u0001H\u0002J\u000b\u0010Ò\u0002\u001a\u0004\u0018\u00010\u000bH\u0002J\u000b\u0010Ó\u0002\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010Ô\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0012\u0010Õ\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0012\u0010Ö\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0012\u0010×\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0012\u0010Ø\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\n\u0010Ù\u0002\u001a\u00030\u008b\u0001H\u0002J\u001e\u0010Ú\u0002\u001a\u00030\u008b\u00012\u0007\u0010Û\u0002\u001a\u00020!2\t\b\u0002\u0010Ü\u0002\u001a\u00020\u0006H\u0002J\n\u0010Ý\u0002\u001a\u00030\u008b\u0001H\u0002J\n\u0010Þ\u0002\u001a\u00030\u008b\u0001H\u0002J\u0014\u0010ß\u0002\u001a\u00030\u008b\u00012\b\u0010\u009a\u0001\u001a\u00030ç\u0001H\u0002J\u0014\u0010à\u0002\u001a\u00030\u008b\u00012\b\u0010á\u0002\u001a\u00030â\u0002H\u0002J\n\u0010ã\u0002\u001a\u00030\u008b\u0001H\u0002J\u000b\u0010ä\u0002\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010å\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0012\u0010æ\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0013\u0010ç\u0002\u001a\u00030\u008b\u00012\u0007\u0010è\u0002\u001a\u00020\u0006H\u0002J\u0012\u0010é\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u001d\u0010ê\u0002\u001a\u0005\u0018\u00010\u008b\u00012\t\u0010ë\u0002\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0003\u0010ì\u0002J\u0012\u0010í\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0013\u0010î\u0002\u001a\u00030\u008b\u00012\u0007\u0010ï\u0002\u001a\u00020!H\u0002J\u000b\u0010ð\u0002\u001a\u0004\u0018\u00010\u0006H\u0002J\u000b\u0010ñ\u0002\u001a\u0004\u0018\u00010\u0006H\u0002J\u000b\u0010ò\u0002\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010ó\u0002\u001a\u00030\u008b\u0001H\u0002J\n\u0010ô\u0002\u001a\u00030\u008b\u0001H\u0002J\n\u0010õ\u0002\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010ö\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\n\u0010÷\u0002\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010ø\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0012\u0010ù\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\n\u0010ú\u0002\u001a\u00030\u008b\u0001H\u0002J\u000b\u0010û\u0002\u001a\u0004\u0018\u00010xH\u0002J\n\u0010ü\u0002\u001a\u00030\u008b\u0001H\u0002J\n\u0010ý\u0002\u001a\u00030\u008b\u0001H\u0002J\u0017\u0010þ\u0002\u001a\u00030\u008b\u0001*\u00020'2\u0007\u0010±\u0002\u001a\u00020'H\u0002J\u001b\u0010ÿ\u0002\u001a\u0004\u0018\u00010#2\u0007\u0010\u0080\u0003\u001a\u00020\u0006H\u0082@¢\u0006\u0003\u0010\u0081\u0003J>\u0010\u0082\u0003\u001a\u0004\u0018\u00010'2\u0007\u0010\u0080\u0003\u001a\u00020\u00062\t\b\u0002\u0010\u0083\u0003\u001a\u00020!2\t\b\u0002\u0010\u0084\u0003\u001a\u00020\u00062\u000b\b\u0002\u0010\u0085\u0003\u001a\u0004\u0018\u00010!H\u0082@¢\u0006\u0003\u0010\u0086\u0003J#\u0010\u0087\u0003\u001a\u00030\u008b\u00012\u0007\u0010\u0080\u0003\u001a\u00020\u00062\u0007\u0010\u0088\u0003\u001a\u00020\u0006H\u0082@¢\u0006\u0003\u0010\u0089\u0003J\u0013\u0010\u008a\u0003\u001a\u00030\u008b\u00012\u0007\u0010\u008b\u0003\u001a\u00020\u0006H\u0002J\t\u0010\u008c\u0003\u001a\u00020!H\u0002J\t\u0010\u008d\u0003\u001a\u00020\u0006H\u0016J\u0014\u0010\u008e\u0003\u001a\u00030\u008b\u00012\b\u0010\u008f\u0003\u001a\u00030\u0090\u0003H\u0016J\t\u0010\u0091\u0003\u001a\u00020!H\u0016J\n\u0010\u0092\u0003\u001a\u00030\u008b\u0001H\u0016J\t\u0010\u0093\u0003\u001a\u00020!H\u0002J\t\u0010\u0094\u0003\u001a\u00020!H\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0004\n\u0002\b\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0015\u001a\u0004\b<\u0010=R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u0015\u001a\u0004\bA\u0010BR\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001d\u0010J\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0015\u001a\u0004\bK\u0010LR\u001b\u0010N\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u0015\u001a\u0004\bN\u0010GR\u001b\u0010P\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\u0015\u001a\u0004\bQ\u0010GR\u001b\u0010S\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\u0015\u001a\u0004\bS\u0010GR\u001b\u0010U\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u0015\u001a\u0004\bW\u0010XR\u001b\u0010Z\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\u0015\u001a\u0004\b[\u0010GR\u001d\u0010]\u001a\u0004\u0018\u00010^8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010\u0015\u001a\u0004\b_\u0010`R\u001b\u0010b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010\u0015\u001a\u0004\bc\u0010LR\u000e\u0010e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010f\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010\u0015\u001a\u0004\bg\u0010LR\u001d\u0010i\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\u0015\u001a\u0004\bj\u0010LR\u001d\u0010l\u001a\u0004\u0018\u00010m8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010\u0015\u001a\u0004\bn\u0010oR\u000e\u0010q\u001a\u00020rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010s\u001a\u00020t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bu\u0010vR\u0010\u0010w\u001a\u0004\u0018\u00010xX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020{X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010|\u001a\r\u0012\t\u0012\u00070~¢\u0006\u0002\b\u007f0}8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0082\u0001\u0010\u0015\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0012\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0086\u0001\u001a\u00030\u0087\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010¡\u0001\u001a\u0004\u0018\u00010xX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u008c\u0002\u001a\u00030\u008d\u0002X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008e\u0002R\u000f\u0010\u009c\u0002\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009d\u0002\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0096\u0003"}, d2 = {"Lcom/larus/bmhome/bot/CommonSettingFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/bmhome/IResultInterface;", "<init>", "()V", "TAG", "", "TAG$1", "RESULT_CODE", "", "binding", "Lcom/larus/bmhome/setting/ICommonSettingBinding;", "multiAccountUiController", "Lcom/larus/platform/api/MultiAccountUiController;", "keyboardReturnBehaviorPopup", "Lcom/skydoves/balloon/Balloon;", "botSettingViewModel", "Lcom/larus/bmhome/bot/BotSettingViewModel;", "getBotSettingViewModel", "()Lcom/larus/bmhome/bot/BotSettingViewModel;", "botSettingViewModel$delegate", "Lkotlin/Lazy;", "appSettingModel", "Lcom/larus/bmhome/bot/AppSettingModel;", "getAppSettingModel", "()Lcom/larus/bmhome/bot/AppSettingModel;", "appSettingModel$delegate", "trace", "Lcom/larus/bmhome/bot/BotSettingTrace;", "cvsType", "conversationId", "conversationName", "isConversationLocal", "", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "conversationType", "Ljava/lang/Integer;", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "editPos", "Lcom/larus/platform/model/EditPos;", "prePage", "backPressCallback", "Landroidx/activity/OnBackPressedCallback;", "newConversationId", "autoSendMessage", "searchMobParam", "Lcom/larus/platform/model/SearchMobParam;", "searchStartTime", "", "isImmersiveBot", "isRefreshBot", "hasReportSearchBarShow", "hasRequestedMembershipEntry", "feedbackNavigationInProgress", "hasRequestedAppletDebuggerEntry", "isOpeningAppletDebugger", "continueCallConfig", "Lcom/larus/platform/model/audio/ContinueTalkV2Config;", "getContinueCallConfig", "()Lcom/larus/platform/model/audio/ContinueTalkV2Config;", "continueCallConfig$delegate", "shareBotController", "Lcom/larus/bmhome/bot/share/ShareBotController;", "getShareBotController", "()Lcom/larus/bmhome/bot/share/ShareBotController;", "shareBotController$delegate", "llmTextView", "Landroidx/appcompat/widget/AppCompatTextView;", "isAppSettingPage", "()Z", "setAppSettingPage", "(Z)V", "disclaimerUrlSetting", "getDisclaimerUrlSetting", "()Ljava/lang/String;", "disclaimerUrlSetting$delegate", "isSideBar", "isSideBar$delegate", "enterEditBgImageAb", "getEnterEditBgImageAb", "enterEditBgImageAb$delegate", "isShowLLMDisclaimerPoweredHint", "isShowLLMDisclaimerPoweredHint$delegate", "llmDisclaimerPageUrlConfig", "Lcom/larus/platform/model/LLMDisclaimerPageUrlConfig;", "getLlmDisclaimerPageUrlConfig", "()Lcom/larus/platform/model/LLMDisclaimerPageUrlConfig;", "llmDisclaimerPageUrlConfig$delegate", "showSettingPageDrive", "getShowSettingPageDrive", "showSettingPageDrive$delegate", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "localConversationId", "getLocalConversationId", "localConversationId$delegate", "botId", "fromActivityName", "getFromActivityName", "fromActivityName$delegate", "fromActivityModule", "getFromActivityModule", "fromActivityModule$delegate", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "getRecommendFrom", "()Lcom/larus/platform/model/RecommendFrom;", "recommendFrom$delegate", "listener", "Lcom/larus/im/service/OnBotChangedListener;", "model", "Lcom/larus/audio/IChatSpeakerSettingViewModel;", "getModel", "()Lcom/larus/audio/IChatSpeakerSettingViewModel;", "audioReadyJob", "Lkotlinx/coroutines/Job;", "isAudioReadyForVoiceSetting", "optionManager", "Lcom/larus/bmhome/chat/manager/settings/SettingOptionManager;", "shareBtnCenterViewStub", "Lcom/larus/common_ui/view/ViewStubManager;", "Lcom/larus/common_res/common_ui/databinding/LarusShareButtonCenterLayoutBinding;", "Lkotlin/jvm/internal/EnhancedNullability;", "getShareBtnCenterViewStub", "()Lcom/larus/common_ui/view/ViewStubManager;", "shareBtnCenterViewStub$delegate", "chatSettingContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "isRestoring", "settingOptionConfig", "Lcom/larus/platform/model/SettingOptionConfig;", "needDefaultReplyModeToast", "needDefaultActiveModeToast", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "attachComponent", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getPrePage", "notifyPrePage", "onViewCreated", "view", "updateFinalItems", "adaptItemsVisibilityAtTargetAppMode", "preloadDynamicIcons", "requestAppletDebuggerEntrance", "onResume", "setupDoraRedDotObserver", "updateDoraRedDotJob", "updateDoraRedDotInMainThread", "updateMemoryRedDot", "onPause", "reportSearchStayTime", "preloadVoiceList", "onDestroyView", "performBack", "leaveMethod", "toggleMessagePushClickEvent", "isChecked", "startMoreMenu", "()Lkotlin/Unit;", "setupUserInfo", "", "setupViews", "setUpSoundsGroup", "useNewSoundsGroup", "setRealtimeCallSwitch", "item", "Lcom/larus/bmhome/view/item/ItemTextToggle;", "setupGroupCells", "setupAppSettings", "hideEmptyItemGroup", "group", "filterInvalidItem", "shouldApplyOptionWhiteList", "reapplyHostAllowListIfNeeded", "setupAdvanced", "handleIndependentModel", "handleIndependentMode", "handleDefaultReplyModeMenu", "getValidDefaultReplyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "getDefaultReplyAgentMode", "replyOption", "(Lcom/larus/bmhome/actionbar/model/ReplyOption;)Ljava/lang/Integer;", "getDefaultReplyAnswerMode", "identity", "Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "handleDefaultReplyModeMenuV2", "menuDataV2", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuDataV2;", "showDefaultReplyModeNestedMenu", "showDefaultReplyModeNestedMenuV2", "anchorView", "handleDefaultReplyModeNestedMenuClick", "result", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuClickResult;", "handleDefaultReplyModeNestedMenuClickV2", "showDefaultReplyModeMenu", "showDefaultReplyModeToast", "selectedText", "setupKeyboardReturnBehavior", "setupStartupOpenNewChatSetting", "bindStartupOpenNewChatToggle", "currentSetting", "Lcom/larus/platform/model/UserConfigItem;", "setupOfficeTaskSettings", "setupCreationOutputSettings", "showKeyboardReturnBehaviorMenu", "getKeyboardReturnBehaviorText", "behavior", "Lcom/larus/bmhome/input/api/EnterKeyAction;", "setupAppSettingModel", "setupUseOnComputer", "setupThird", "setupDiscord", "setupVersion", "setupDoubaoWebsite", "Lcom/larus/bmhome/view/item/ItemTextArrow;", "setupDriveCapacity", "buildDriveCapacitySubText", "storageData", "Lcom/larus/platform/api/DriveUserStorageData;", "formatDriveCapacity", "bytes", "formatDriveCapacityNumber", "value", "Ljava/math/BigDecimal;", "setupFeedback", "setupAboutApp", "setupLogout", "setupMultiAccountSwitch", "setupPrimacyPermission", "setupArchivedConversations", "findMainActivity", "Landroid/app/Activity;", "setupNotifySettings", "setupLLMDisclaimerPoweredHintInNewStyle", "setupShortCut", "setUpHealthAgreement", "setupLLMDisclaimer", "setupLLMDisclaimerPoweredHint", "setupDisclaimerForApp", "setupPersonalCollect", "setupSanfangShare", "setupDisclaimer", "Landroid/widget/TextView;", "(Landroid/widget/TextView;)Lkotlin/Unit;", "isEnterPrise", "getOpenUrl", "isMainCvs", "setupFontAndTheme", "setupExpertMode", "onResult", "bundle", "appBackGroundListener", "com/larus/bmhome/bot/CommonSettingFragment$appBackGroundListener$1", "Lcom/larus/bmhome/bot/CommonSettingFragment$appBackGroundListener$1;", "setupBotEditSubTitleObserver", "shouldShowGetPro", "setupGetPro", "setupSubscriptionObserver", "setupMembershipEntry", "updateMembershipEntry", "config", "Lcom/larus/commercemembership/api/model/SubscriptionEntryConfig;", "(Lcom/larus/commercemembership/api/model/SubscriptionEntryConfig;)Lkotlin/Unit;", "resolveSubTitleColor", "colorCfg", "Lcom/larus/commercemembership/api/model/SettingsPageSubTitleColor;", "(Lcom/larus/commercemembership/api/model/SettingsPageSubTitleColor;)Ljava/lang/Integer;", "isMembershipEntryShowed", "isManagementEntryShowed", "mobMembershipShowGuidance", "clickUrl", "onShowSubsGuidanceEvent", "defaultEnterMethod", "itemId", "mapMembershipIconRes", "iconName", "isSectionRename", "setupSearch", "showTitleBarLeftImg", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "setupSupportedItems", "setupCommonConversation", "canModifyTts", "setupSubConversation", "canEditBgImage", "setupUpdateResult", "updateAvatar", "newBotInfo", "(Lcom/larus/im/bean/bot/BotModel;)Lkotlin/Unit;", "openBgImagePreviewPage", "setupSelectSpeakerResult", "updateSpeaker", "Lcom/larus/im/bean/bot/SpeakerVoice;", "setupSelectLanguageResult", "updateLanguage", "refreshBotTagView", "tagList", "", "Lcom/larus/im/bean/bot/ShowTagInfo;", "setupSelectModelResult", "updateModel", "setupSelectPrivateStatusResult", "tryInterceptMsgPushCheckListener", "changedCheckState", "originAction", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "shouldChangeState", "setupRenewSection", "setupRenewSectionUI", "buildCreatorName", "", "setupChatInfo", "refreshBotNameView", "iconEditItemLoad", "onLowMemory", "openBotAvatarPreviewDialog", "url", "setupReSubmit", "setupSubjectBotObserver", "setupResetBotSubjectObserver", "setupConversationName", "setupIconEdit", "setupBotEdit", "setupBotLanguage", "setupLtmSettings", "setupSwitchConfig", "setupDoraEntrance", "isTraceShow", "source", "updateSwitchConfig", "setupPlugin", "setupTtsSpeaker", "observeSaasAudioReady", "runtimeProvider", "Lcom/larus/platform/api/IAudioSettingRuntimeProvider;", "setupVoiceSettingModel", "setupVoiceCreate", "setupDataModel", "setupNickName", "setAutoSendMessageInChatPageIfNeeded", "firstMessage", "setupAccessPermission", "updateAccessPermission", "privateStatus", "(Ljava/lang/Integer;)Lkotlin/Unit;", "setupBotShare", "shareClickAction", "isSharable", "getCaseRecommendFrom", "getCaseTraceId", "getCaseRequestTraceId", "shareClickActionWhenEnabled", "shareClickActionWhenDisabled", "setupAccessPermissionObserver", "setupClearHistory", "clearHistory", "setupDeleteConversation", "setupDelete", "confirmDelete", "resetDefaultSetting", "deleteConversation", "tipOff", "updateBotInfo", "findConversationInfo", "cvsId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findBotInfo", "forceNew", "scene", "isAuto", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConversationName", "newName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshConversationId", "newId", "isCreator", "getCurrentPageName", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "autoLogEnterPage", "logEnterPage", "isImmersiveStyle", "mergeAllReferrerParams", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CommonSettingFragment extends TraceFragment implements com.larus.bmhome.y {
    public static final BigDecimal k1 = null;
    public static final BigDecimal p1 = null;
    public static final BigDecimal v1 = null;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public final Lazy G;
    public final Lazy H;
    public final hq9.m4 H0;
    public AppCompatTextView I;
    public boolean J;
    public final Lazy K;
    public final Lazy L;
    public boolean L0;
    public final Lazy M;
    public final Lazy N;
    public final Lazy O;
    public final Lazy P;
    public boolean P0;
    public final Lazy Q;
    public final Lazy R;
    public String S;
    public final Lazy T;
    public final Lazy U;
    public final Lazy V;
    public Job V0;
    public final CommonSettingFragment$listener$1 W;
    public Job X;
    public boolean Y;
    public final com.larus.bmhome.chat.manager.settings.p Z;
    public final b b1;
    public final String e;
    public final int f;
    public com.larus.bmhome.setting.c g;
    public boolean g1;
    public com.larus.platform.api.n4 h;
    public boolean h1;
    public Balloon i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy k0;
    public final com.larus.bmhome.bot.b l;
    public int m;
    public String n;
    public String o;
    public boolean p;
    public boolean p0;
    public wc9.e q;
    public Integer r;
    public BotModel s;
    public EditPos t;
    public String u;
    public FragmentExtKt.addOnBackPressed.callback.1 v;
    public final String w;
    public SearchMobParam x;
    public long y;
    public boolean z;

    public static final class a {
    }

    public static final class b implements f09.a.b {
        public final /* synthetic */ CommonSettingFragment a;

        public final void onAppForeground() {
        }

        public final void onAllActivityDestroyed() {
            this.a.N9("kill_app");
        }

        public final void onAppBackground() {
            this.a.N9("to_background");
        }

        public b(CommonSettingFragment r1) {
            this.a = r1;
        }
    }

    public static final class c implements com.larus.common_ui.dialog.p0 {
        public final /* synthetic */ CommonSettingFragment a;

        public final void confirm() {
            String r1 = this.a.n;
            BotModel r2 = null;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("conversationId");
            r1 = null;
        L5:
            CommonSettingFragment r3 = this.a;
            if (r1.length() != 0) goto L8;
            boolean r4 = true;
        L9:
            if (r4 == false) goto L11;
            r1 = r3.La0();
        L11:
            wc9.e r5 = this.a.q;
            if (r5 == null) goto L19;
            Integer r6 = r5.t;
            if (r6 == null) goto L19;
            if (r6.intValue() != 8) goto L19;
            boolean r7 = true;
        L20:
            this.a.Ja0().removeConversation(r1);
            Gson r8 = new Gson();
            CommonSettingFragment r9 = this.a;
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L26
            BotModel r11 = r9.s;     // Catch: Throwable -> L26
            if (r11 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("botInfo");     // Catch: Throwable -> L26
            r11 = null;
        L24:
            Object r12 = Result.constructor-impl((EditPos) r8.fromJson(r11.getEditPos(), EditPos.class));     // Catch: Throwable -> L26
        L29:
            if (Result.isFailure-impl(r12) == false) goto L31;
            r12 = null;
        L31:
            EditPos r13 = (EditPos) r12;
            if (r13 != null) goto L34;
            r13 = new EditPos(0);
        L34:
            int r14 = wi8.e.a;
            BotModel r15 = this.a.s;
            if (r15 != null) goto L37;
            Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        L38:
            String r0 = r2.getBotId();
            if (r0 != null) goto L41;
            r0 = "";
        L41:
            Integer r16 = this.a.r;
            Boolean r17 = Boolean.valueOf(r13.c());
            Intrinsics.checkNotNullParameter(r1, "cvsId");
            Intrinsics.checkNotNullParameter(r0, "botId");
            Pair[] r18 = new Pair[5];
            r18[0] = TuplesKt.to("conversation_id", r1);
            r18[1] = TuplesKt.to("bot_id", r0);
            r18[2] = TuplesKt.to("click_from", "chat_setting");
            if (r7 == false) goto L44;
            String r19 = "archived";
        L45:
            r18[3] = TuplesKt.to("chat_status", r19);
            if (r16 != null) goto L49;
        L51:
            if (r16 == null) goto L57;
            if (r16.intValue() != 3) goto L57;
            String r20 = "default_new";
        L60:
            r18[4] = TuplesKt.to("chat_type", r20);
            com.larus.platform.service.o.a.b("remove_chat", com.larus.utils.f.c(r18));
            return;
        L57:
            if (Intrinsics.areEqual(r17, Boolean.TRUE) == false) goto L59;
            r20 = "self_created";
            goto L60
        L59:
            r20 = "other_default";
            goto L60
        L49:
            if (r16.intValue() != 1) goto L51;
            r20 = "default";
            goto L60
        L44:
            r19 = "normal";
            goto L45
        L37:
            r2 = r15;
        L26:
            th = move-exception;
            Result.Companion r21 = Result.Companion;
            r12 = Result.constructor-impl(ResultKt.createFailure(th));
        L19:
            r7 = false;
            goto L20
        L8:
            r4 = false;
            goto L9
        }

        public c(CommonSettingFragment r1) {
            this.a = r1;
        }
    }

    public static final class d implements com.larus.common_ui.dialog.u {
        public d() {
        }

        public final void cancel() {
        }
    }

    public static final class e implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public e(Function1 r2) {
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

    /* JADX INFO: renamed from: com.larus.bmhome.bot.CommonSettingFragment$onResume$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$onResume$1", f = "CommonSettingFragment.kt", i = {}, l = {753}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
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
            IAIChatConversationService.Companion r5 = IAIChatConversationService.a;
            this.label = 1;
            if (r5.c(this) != r0) goto L12;
            return r0;
        }
    }

    public final boolean et() {
        return true;
    }

    static {
        k1 = BigDecimal.valueOf(1073741824);
        p1 = BigDecimal.valueOf(1099511627776L);
        v1 = new BigDecimal("0.01");
    }

    public final void Ba0() {
        IFlowSettingThemeConfigProvider r0 = (IFlowSettingThemeConfigProvider) ServiceManager.get().getService(IFlowSettingThemeConfigProvider.class);
        ItemTextArrow r1 = null;
        if (r0 == null) goto L9;
        com.larus.bmhome.setting.c r2 = this.g;
        if (r2 == null) goto L7;
        ItemTextArrow r3 = r2.X();
    L8:
        r0.b(r3, AdaptThemeFeatureKey.SETTING_ITEM_DOUBAO_EDIT);
        goto L9
    L7:
        r3 = null;
    L9:
        IFlowSettingThemeConfigProvider r4 = (IFlowSettingThemeConfigProvider) ServiceManager.get().getService(IFlowSettingThemeConfigProvider.class);
        if (r4 == null) goto L16;
        com.larus.bmhome.setting.c r5 = this.g;
        if (r5 == null) goto L14;
        ItemTextArrow r6 = r5.I();
    L15:
        r4.b(r6, AdaptThemeFeatureKey.SETTING_ITEM_FEEDBACK);
        goto L16
    L14:
        r6 = null;
    L16:
        IFlowSettingThemeConfigProvider r7 = (IFlowSettingThemeConfigProvider) ServiceManager.get().getService(IFlowSettingThemeConfigProvider.class);
        if (r7 == null) goto L23;
        com.larus.bmhome.setting.c r8 = this.g;
        if (r8 == null) goto L21;
        ItemTextArrow r9 = r8.A0();
    L22:
        r7.b(r9, AdaptThemeFeatureKey.SETTING_ITEM_ORDER);
        goto L23
    L21:
        r9 = null;
    L23:
        IFlowSettingThemeConfigProvider r10 = (IFlowSettingThemeConfigProvider) ServiceManager.get().getService(IFlowSettingThemeConfigProvider.class);
        if (r10 == null) goto L30;
        com.larus.bmhome.setting.c r11 = this.g;
        if (r11 == null) goto L28;
        ItemTextArrow r12 = r11.g1();
    L29:
        r10.b(r12, AdaptThemeFeatureKey.SETTING_ITEM_WALLET);
        goto L30
    L28:
        r12 = null;
    L30:
        IFlowSettingThemeConfigProvider r13 = (IFlowSettingThemeConfigProvider) ServiceManager.get().getService(IFlowSettingThemeConfigProvider.class);
        if (r13 == null) goto L37;
        com.larus.bmhome.setting.c r14 = this.g;
        if (r14 == null) goto L35;
        ItemTextArrow r15 = r14.i0();
    L36:
        r13.b(r15, AdaptThemeFeatureKey.SETTING_ITEM_MINOR);
        goto L37
    L35:
        r15 = null;
    L37:
        IFlowSettingThemeConfigProvider r16 = (IFlowSettingThemeConfigProvider) ServiceManager.get().getService(IFlowSettingThemeConfigProvider.class);
        if (r16 == null) goto L44;
        com.larus.bmhome.setting.c r17 = this.g;
        if (r17 == null) goto L42;
        r1 = r17.C();
    L42:
        r16.b(r1, AdaptThemeFeatureKey.SETTING_ITEM_DORA);
        return;
    }

    public final boolean Ca0() {
        if (((Boolean) this.M.getValue()).booleanValue() == false) goto L52;
        EditPos r2 = null;
        if (this.t != null) goto L21;
        Gson r0 = new Gson();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        BotModel r4 = this.s;     // Catch: Throwable -> L12
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");     // Catch: Throwable -> L12
        r4 = null;
    L10:
        Object r1 = Result.constructor-impl((EditPos) r0.fromJson(r4.getEditPos(), EditPos.class));     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r1) == false) goto L17;
        r1 = null;
    L17:
        EditPos r5 = (EditPos) r1;
        if (r5 != null) goto L20;
        r5 = new EditPos(0);
    L20:
        this.t = r5;
    L12:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
    L21:
        EditPos r7 = this.t;
        if (r7 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
        r7 = null;
    L25:
        if (r7.i() == true) goto L46;
        EditPos r8 = this.t;
        if (r8 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
        r8 = null;
    L30:
        if (r8.g() == true) goto L46;
        EditPos r9 = this.t;
        if (r9 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
        r9 = null;
    L35:
        if (r9.e() == true) goto L46;
        EditPos r10 = this.t;
        if (r10 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
    L41:
        if (r2.h() == true) goto L46;
        if (AuthModelDelegate.b.d() == true) goto L46;
        boolean r11 = false;
    L47:
        if (r11 == false) goto L53;
        return true;
    L53:
        return false;
    L39:
        r2 = r10;
    L46:
        r11 = true;
        goto L47
    L52:
        return false;
    }

    public final boolean Da0() {
        BotModel r0 = this.s;
        EditPos r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r0 = null;
    L5:
        SpeakerVoice r2 = r0.getVoiceType();
        EditPos r3 = this.t;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
    L10:
        return lq9.g0.a(r2, r1);
    L8:
        r1 = r3;
        goto L10
    }

    public final void Ea0() {
        BotModel r0 = this.s;
        String r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r0 = null;
    L6:
        if (ni8.a.b(r0) != (-10)) goto L13;
        BotSettingViewModel r2 = Ja0();
        String r3 = this.n;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
    L11:
        r2.removeConversation(r1);
        return;
    L10:
        r1 = r3;
        goto L11
    L13:
        if (isAdded() == true) goto L15;
        return;
    L15:
        if (getChildFragmentManager().isStateSaved() == true) goto L20;
        CommonDialog.a r4 = new CommonDialog.a();
        r4.i(getString(2131900768));
        r4.g(getString(2131900204));
        CommonDialog.a.f(r4, new c(this), getString(2131900203), false, 12);
        CommonDialog.a.e(r4, new d(), getString(2131900202), 4);
        U90(r4.a(), getChildFragmentManager());
        return;
    }

    public final AppSettingModel Ia0() {
        return (AppSettingModel) this.k.getValue();
    }

    public final BotSettingViewModel Ja0() {
        return (BotSettingViewModel) this.j.getValue();
    }

    public final String La0() {
        return (String) this.R.getValue();
    }

    public final String Ma0() {
        Integer r0 = this.r;
        if (r0 != null) goto L6;
    L8:
        return "bot_setting";
    L6:
        if (r0.intValue() != 3) goto L8;
        return "new_chat_setting";
    }

    public final RecommendFrom Na0() {
        return (RecommendFrom) this.V.getValue();
    }

    public final void Qa0() {
        com.larus.bmhome.setting.c r0 = this.g;
        if (r0 == null) goto L63;
        final ItemTextMenu r1 = r0.Y();
        if (r1 == null) goto L64;
        UserConfigActiveModeMenu r2 = Ia0().getDefaultActiveModeMenu();
        String r3 = null;
        if (r2 == null) goto L10;
        List<UserConfigActiveMode> r4 = r2.getModeList();
    L11:
        if (r4 != null) goto L13;
        r4 = CollectionsKt.emptyList();
    L13:
        List r5 = CollectionsKt.filterNotNull(r4);
        final ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L15:
        if (r7.hasNext() == false) goto L35;
        Object r8 = r7.next();
        UserConfigActiveMode r9 = (UserConfigActiveMode) r8;
        String r10 = r9.getModeId();
        boolean r11 = false;
        if (r10 != null) goto L19;
    L22:
        boolean r12 = true;
    L23:
        if (r12 == true) goto L33;
        String r13 = r9.getModelName();
        if (r13 != null) goto L27;
    L30:
        boolean r14 = true;
    L31:
        if (r14 == true) goto L33;
        r11 = true;
        goto L33
    L27:
        if (r13.length() == 0) goto L30;
        r14 = false;
    L33:
        if (r11 == false) goto L15;
        r6.add(r8);
        goto L15
    L19:
        if (r10.length() == 0) goto L22;
        r12 = false;
        goto L23
    L35:
        DefaultActiveModeSettingValue r15 = Ia0().getDefaultActiveModeSettingValue();
        if (r15 == null) goto L38;
        final String r16 = r15.getCurrentSelectMode();
    L40:
        if (r6.isEmpty() == false) goto L43;
        com.larus.utils.e1.o(r1);
        return;
    L43:
        Iterator r17 = r6.iterator();
    L45:
        if (r17.hasNext() == false) goto L49;
        Object r18 = r17.next();
        if (Intrinsics.areEqual(((UserConfigActiveMode) r18).getModeId(), r16) == false) goto L45;
    L50:
        UserConfigActiveMode r19 = (UserConfigActiveMode) r18;
        if (r19 == null) goto L53;
        r3 = r19.getModelName();
    L53:
        r1.setSubText(r3);
        com.larus.utils.e1.x(r1);
        r1.setOnClickListener(new s0(r1, this, r6, r16));
        return;
    L49:
        r18 = null;
        goto L50
    L38:
        r16 = null;
        goto L40
    L10:
        r4 = null;
        goto L11
    L64:
        return;
    }

    public final boolean S90() {
        if (this.J == true) goto L5;
        return true;
    L5:
        return !Va0();
    }

    public final boolean Ta0() {
        if (this.s != null) goto L7;
        return false;
    L7:
        return this.z;
    }

    public final boolean Ua0() {
        Integer r0 = this.r;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.equals(1);
    }

    public final boolean Va0() {
        return ((Boolean) this.L.getValue()).booleanValue();
    }

    public final void Xa0() {
        com.larus.bmhome.setting.c r0 = this.g;
        if (r0 == null) goto L29;
        BotModel r1 = this.s;
        BotModel r2 = null;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r1 = null;
    L7:
        BotIconImage r3 = r1.getIconImage();
        if (r3 == null) goto L10;
        String r4 = r3.getUri();
    L12:
        if (com.larus.utils.o0.d(r4) == false) goto L27;
        BotModel r5 = this.s;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r5 = null;
    L16:
        BotIconImage r6 = r5.getIconImage();
        if (r6 == null) goto L19;
        String r7 = r6.getOriginUrl();
    L21:
        if (com.larus.utils.o0.d(r7) == false) goto L27;
        com.larus.platform.service.m3 r8 = com.larus.platform.service.m3.a;
        Context r9 = r0.P0().getContext();
        BotModel r10 = this.s;
        if (r10 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L26:
        r8.d(r9, r2, this);
        goto L27
    L25:
        r2 = r10;
        goto L26
    L19:
        r7 = null;
    L27:
        Unit r11 = Unit.INSTANCE;
        return;
    L10:
        r4 = null;
        goto L12
    }

    public final void Za0() {
        if (com.larus.platform.service.z2.a.I2() == false) goto L13;
        p2a.i r0 = p2a.i.b;
        BotModel r1 = this.s;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r1 = null;
    L7:
        BotCreatorInfo r2 = r1.getBotCreatorInfo();
        if (r2 == null) goto L10;
        String r3 = r2.getId();
    L11:
        p2a.i.b.R(r3, "");
        goto L13
    L10:
        r3 = null;
    L13:
        if (this.A == false) goto L15;
        return;
    L15:
        final ArrayList r4 = new ArrayList();
        if (isAdded() == false) goto L18;
        p2a.s.b.F0().c(this).observe(getViewLifecycleOwner(), new e(new p1(r4)));
    L20:
        if (FeatureKitDelegate.b.l0().b() == false) goto L35;
        List r5 = p2a.i.b.D1();
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L23:
        if (r7.hasNext() == false) goto L34;
        SpeakerVoice r8 = (SpeakerVoice) r7.next();
        String r9 = r8.getStyleId();
        if (r9 != null) goto L27;
        r9 = "";
    L27:
        AudioPreview r10 = r8.getPreview();
        if (r10 == null) goto L30;
        String r11 = r10.getPreviewAudio();
    L31:
        if (r11 != null) goto L33;
        r11 = "";
    L33:
        r6.add(new p68.b(r11, r9));
        goto L23
    L30:
        r11 = null;
        goto L31
    L34:
        r4.addAll(r6);
    L35:
        AudioServiceDelegate.a.o0().j(r4);
        return;
    L18:
        FLogger.a.e(this.e, "preloadVoiceList failed!");
        goto L20
    }

    public final void ab0() {
        hq9.m4 r0 = this.H0;
        if (r0.a == true) goto L5;
        return;
    L5:
        List r1 = r0.b;
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        return;
    L14:
        tb0();
        return;
    L8:
        if (r1.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }

    public final boolean an() {
        BotModel r0 = this.s;
        String r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r0 = null;
    L5:
        BotCreatorInfo r2 = r0.getBotCreatorInfo();
        if (r2 == null) goto L8;
        r1 = r2.getId();
    L8:
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        String r3 = AccountService.a.getUserId();
        FLogger.a.d(this.e, "isCreator called: creatorId = " + r1 + ", userId = " + r3);
        return Intrinsics.areEqual(r1, r3);
    }

    public final void eb0() {
        final com.larus.bmhome.setting.c r0 = this.g;
        if (r0 == null) goto L318;
        ItemTextToggle r1 = r0.F0();
        if (r1 == null) goto L9;
        CustomSwitchCompat r2 = r1.getToggleView();
        if (r2 == null) goto L9;
        r2.setChecked(Ia0().isPromptEnabled());
    L9:
        ItemTextToggle r3 = r0.F0();
        if (r3 == null) goto L14;
        CustomSwitchCompat r4 = r3.getToggleView();
        if (r4 == null) goto L14;
        r4.setClickable(false);
    L14:
        ItemTextToggle r5 = r0.F0();
        if (r5 == null) goto L19;
        CustomSwitchCompat r6 = r5.getToggleView();
        if (r6 == null) goto L19;
        r6.setOnCheckedChangeListener(new p2(this));
    L19:
        FeatureKitDelegate r7 = FeatureKitDelegate.b;
        if (r7.i0().b() == true) goto L24;
        ItemTextToggle r8 = r0.F0();
        if (r8 == null) goto L24;
        r8.setVisibility(8);
    L24:
        ItemTextToggle r9 = r0.G0();
        if (r9 == null) goto L29;
        CustomSwitchCompat r10 = r9.getToggleView();
        if (r10 == null) goto L29;
        r10.setChecked(Ia0().isPromptStyleVertical());
    L29:
        ItemTextToggle r11 = r0.G0();
        if (r11 == null) goto L34;
        CustomSwitchCompat r12 = r11.getToggleView();
        if (r12 == null) goto L34;
        r12.setClickable(false);
    L34:
        ItemTextToggle r13 = r0.G0();
        if (r13 == null) goto L39;
        CustomSwitchCompat r14 = r13.getToggleView();
        if (r14 == null) goto L39;
        r14.setOnCheckedChangeListener(new q2(this));
    L39:
        com.larus.platform.service.s r15 = com.larus.platform.service.s.a;
        if (r15.c() == true) goto L44;
        ItemTextToggle r16 = r0.G0();
        if (r16 == null) goto L50;
        r16.setVisibility(8);
    L50:
        ItemTextToggle r17 = r0.I0();
        if (r17 == null) goto L55;
        CustomSwitchCompat r18 = r17.getToggleView();
        if (r18 == null) goto L55;
        r18.setChecked(Ia0().isStreamMode());
    L55:
        ItemTextToggle r19 = r0.I0();
        if (r19 == null) goto L60;
        CustomSwitchCompat r20 = r19.getToggleView();
        if (r20 == null) goto L60;
        r20.setClickable(false);
    L60:
        ItemTextToggle r21 = r0.I0();
        if (r21 == null) goto L66;
        CustomSwitchCompat r22 = r21.getToggleView();
        if (r22 == null) goto L66;
        r22.setOnCheckedChangeListener(new r2(this));
    L66:
        if (r15.c() == true) goto L70;
        ItemTextToggle r23 = r0.I0();
        if (r23 == null) goto L76;
        r23.setVisibility(8);
    L76:
        ItemTextToggle r24 = r0.J0();
        if (r24 == null) goto L79;
        r24.setVisibility(8);
    L79:
        ItemTextToggle r25 = r0.E0();
        if (r25 == null) goto L84;
        CustomSwitchCompat r26 = r25.getToggleView();
        if (r26 == null) goto L84;
        r26.setChecked(Ia0().isInterruptEnabled());
    L84:
        ItemTextToggle r27 = r0.E0();
        if (r27 == null) goto L89;
        CustomSwitchCompat r28 = r27.getToggleView();
        if (r28 == null) goto L89;
        r28.setClickable(false);
    L89:
        ItemTextToggle r29 = r0.E0();
        if (r29 == null) goto L95;
        CustomSwitchCompat r30 = r29.getToggleView();
        if (r30 == null) goto L95;
        r30.setOnCheckedChangeListener(new s2(this));
    L95:
        if (r15.c() == true) goto L99;
        ItemTextToggle r31 = r0.E0();
        if (r31 == null) goto L105;
        r31.setVisibility(8);
    L105:
        final boolean r32 = AppHost.a.isOversea();
        FeatureDetail r33 = r7.S();
        int r34 = UserSettingDelegate.b.S();
        ItemTextToggle r35 = r0.f1();
        if (r35 == null) goto L110;
        CustomSwitchCompat r36 = r35.getToggleView();
        if (r36 == null) goto L110;
        r36.setClickable(false);
    L110:
        ItemTextToggle r37 = r0.f1();
        boolean r38 = true;
        if (r37 == null) goto L127;
        CustomSwitchCompat r39 = r37.getToggleView();
        if (r39 == null) goto L127;
        if (r32 == true) goto L116;
        if (r34 != 1) goto L120;
    L119:
        boolean r40 = true;
    L121:
        if (r40 == true) goto L123;
    L125:
        boolean r41 = false;
    L126:
        r39.setChecked(r41);
        goto L127
    L123:
        if (r33.b() == false) goto L125;
        r41 = true;
    L120:
        r40 = false;
        goto L121
    L116:
        if (r34 != 2) goto L120;
    L127:
        ItemTextToggle r42 = r0.f1();
        if (r42 == null) goto L133;
        CustomSwitchCompat r43 = r42.getToggleView();
        if (r43 == null) goto L133;
        r43.setOnCheckedChangeListener(new t2(this, r32));
    L133:
        if (r7.S().b() == true) goto L137;
        ItemTextToggle r44 = r0.f1();
        if (r44 == null) goto L137;
        r44.setVisibility(8);
    L137:
        if (r32 == false) goto L139;
    L153:
        ItemTextToggle r45 = r0.M0();
        if (r45 == null) goto L156;
        r45.setVisibility(8);
    L156:
        DefaultReplyMenuItem r46 = null;
        if (r7.T().b() == false) goto L189;
        DefaultReplyMenuDataV2 r47 = Ia0().getDefaultActiveModelMenu();
        if (r47 == null) goto L165;
        DefaultReplyMenuConfigV2 r48 = r47.getMenuConfV2();
        if (r48 == null) goto L165;
        DefaultReplySwitchModeConfig r49 = r48.getModeList();
        if (r49 == null) goto L165;
        List<DefaultReplySwitchMenuMode> r50 = r49.getItemList();
    L166:
        List<DefaultReplySwitchMenuMode> r51 = r50;
        if (r51 != null) goto L169;
    L172:
        boolean r52 = true;
    L173:
        if (r52 == false) goto L179;
        com.larus.bmhome.setting.c r53 = this.g;
        if (r53 == null) goto L195;
        ItemTextArrow r54 = r53.Z();
        if (r54 == null) goto L195;
        com.larus.utils.e1.o(r54);
    L195:
        if (r7.W().b() == false) goto L201;
        Qa0();
        com.larus.bmhome.setting.c r55 = this.g;
        if (r55 == null) goto L257;
        ItemTextMenu r56 = r55.y();
        if (r56 == null) goto L257;
        com.larus.utils.e1.o(r56);
    L257:
        ItemTextToggle r57 = r0.H0();
        if (r57 == null) goto L262;
        CustomSwitchCompat r58 = r57.getToggleView();
        if (r58 == null) goto L262;
        r58.setChecked(Ia0().isHighlightEnabled());
    L262:
        ItemTextToggle r59 = r0.H0();
        if (r59 == null) goto L267;
        CustomSwitchCompat r60 = r59.getToggleView();
        if (r60 == null) goto L267;
        r60.setClickable(false);
    L267:
        ItemTextToggle r61 = r0.H0();
        if (r61 == null) goto L272;
        CustomSwitchCompat r62 = r61.getToggleView();
        if (r62 == null) goto L272;
        r62.setOnCheckedChangeListener(new w2(this));
    L272:
        FeatureKitDelegate r63 = FeatureKitDelegate.b;
        if (r63.s0().b() == true) goto L277;
        ItemTextToggle r64 = r0.H0();
        if (r64 == null) goto L277;
        r64.setVisibility(8);
    L277:
        com.larus.utils.e1.d(r0.W0(), new x2(this));
        if (com.larus.platform.service.s.a.c() == true) goto L282;
        ItemTextArrow r65 = r0.W0();
        if (r65 == null) goto L289;
        r65.setVisibility(8);
    L289:
        if (r63.A0().b() == false) goto L311;
        ViewGroup r66 = r0.e();
        if (r66 == null) goto L293;
        com.larus.utils.e1.x(r66);
    L293:
        ItemTextToggle r67 = r0.L0();
        if (r67 == null) goto L296;
        r67.setVisibility(0);
    L296:
        ItemTextToggle r68 = r0.L0();
        if (r68 == null) goto L301;
        CustomSwitchCompat r69 = r68.getToggleView();
        if (r69 == null) goto L301;
        r69.setChecked(Ia0().getRealtimeCallEnabled());
    L301:
        ItemTextToggle r70 = r0.L0();
        if (r70 == null) goto L306;
        CustomSwitchCompat r71 = r70.getToggleView();
        if (r71 == null) goto L306;
        r71.setClickable(false);
    L306:
        ItemTextToggle r72 = r0.L0();
        if (r72 == null) goto L319;
        CustomSwitchCompat r73 = r72.getToggleView();
        if (r73 == null) goto L320;
        r73.setOnCheckedChangeListener(new y2(this));
        Unit r74 = Unit.INSTANCE;
        return;
    L320:
        return;
    L319:
        return;
    L311:
        ItemTextToggle r75 = r0.L0();
        if (r75 == null) goto L322;
        r75.setVisibility(8);
        Unit r76 = Unit.INSTANCE;
        return;
    L322:
        return;
    L282:
        ViewGroup r77 = r0.e();
        if (r77 == null) goto L285;
        com.larus.utils.e1.x(r77);
    L285:
        ItemTextArrow r78 = r0.W0();
        if (r78 == null) goto L289;
        com.larus.utils.e1.x(r78);
        goto L289
    L201:
        com.larus.bmhome.setting.c r79 = this.g;
        if (r79 == null) goto L252;
        ItemTextMenu r80 = r79.y();
        if (r80 == null) goto L252;
        if (com.larus.platform.service.n0.a.b() == false) goto L209;
        r80.getTextView().setText(getString(2131907763));
    L209:
        gga.a r81 = ObricAccountSPIServiceDelegate.b.e();
        if (r7.d0().b() == false) goto L251;
        final DefaultReplyMenuDataV2 r82 = Ia0().getDefaultReplyMenuDataV2();
        if (r82 == null) goto L214;
        boolean r83 = Intrinsics.areEqual(r82.getUseMenuConfV2(), Boolean.TRUE);
    L215:
        if (r83 == false) goto L217;
        Pa0(r82);
        goto L252
    L217:
        DefaultReplyMenuData r84 = Ia0().getDefaultModelItemMenu();
        if (r84 != null) goto L220;
        com.larus.utils.e1.o(r80);
        goto L252
    L220:
        ModelItemIdentity r85 = Ia0().getDefaultModelItemKey();
        List<DefaultReplyMenuItem> r110 = r84.getItemList();
        if (r110 == null) goto L235;
        Iterator<T> r111 = r110.iterator();
    L224:
        if (r111.hasNext() == false) goto L232;
        Object r112 = r111.next();
        DefaultReplyMenuItem r113 = (DefaultReplyMenuItem) r112;
        if (r113 == null) goto L228;
        ModelItemIdentity r114 = r113.getIdentity();
    L230:
        if (Intrinsics.areEqual(r114, ModelItemIdentity.copy$default(r85, null, Integer.valueOf(r81.b(r85.getDeprecatedItemId())), 1, null)) == false) goto L224;
    L233:
        DefaultReplyMenuItem r115 = (DefaultReplyMenuItem) r112;
        if (r115 == null) goto L235;
    L241:
        String r86 = r115.getSelectedName();
        if (r86 != null) goto L244;
    L247:
        if (r38 == false) goto L249;
        String r87 = r115.getName();
    L250:
        r80.setSubText(r87);
        r80.setOnMenuClickListener(new p0(r82, this));
        com.larus.utils.e1.x(r80);
        goto L252
    L249:
        r87 = r115.getSelectedName();
        goto L250
    L244:
        if (r86.length() == 0) goto L247;
        r38 = false;
        goto L247
    L228:
        r114 = null;
        goto L230
    L232:
        r112 = null;
    L235:
        List<DefaultReplyMenuItem> r88 = r84.getItemList();
        if (r88 == null) goto L238;
        r46 = (DefaultReplyMenuItem) CollectionsKt.firstOrNull(r88);
    L238:
        if (r46 != null) goto L240;
        com.larus.utils.e1.o(r80);
        goto L252
    L240:
        r115 = r46;
        goto L241
    L214:
        r83 = false;
        goto L215
    L251:
        com.larus.utils.e1.o(r80);
    L252:
        com.larus.bmhome.setting.c r89 = this.g;
        if (r89 == null) goto L257;
        ItemTextArrow r90 = r89.Z();
        if (r90 == null) goto L257;
        com.larus.utils.e1.o(r90);
        goto L257
    L179:
        com.larus.bmhome.setting.c r91 = this.g;
        if (r91 == null) goto L184;
        ItemTextArrow r92 = r91.Z();
        if (r92 == null) goto L184;
        com.larus.utils.e1.x(r92);
    L184:
        com.larus.bmhome.setting.c r93 = this.g;
        if (r93 == null) goto L195;
        ItemTextArrow r94 = r93.Z();
        if (r94 == null) goto L195;
        com.larus.utils.e1.d(r94, new q0(this));
        goto L195
    L169:
        if (r51.isEmpty() == true) goto L172;
        r52 = false;
    L165:
        r50 = null;
        goto L166
    L189:
        com.larus.bmhome.setting.c r95 = this.g;
        if (r95 == null) goto L195;
        ItemTextMenu r96 = r95.Y();
        if (r96 == null) goto L195;
        com.larus.utils.e1.o(r96);
        goto L195
    L139:
        if (r7.n0().b() == false) goto L153;
        if (com.larus.platform.service.z2.a.q().o == false) goto L153;
        ItemTextToggle r97 = r0.M0();
        if (r97 == null) goto L148;
        CustomSwitchCompat r99 = r97.getToggleView();
        if (r99 == null) goto L148;
        r99.setChecked(Ia0().isRelatedVideoEnabled());
    L148:
        ItemTextToggle r100 = r0.M0();
        if (r100 == null) goto L156;
        CustomSwitchCompat r101 = r100.getToggleView();
        if (r101 == null) goto L156;
        r101.setOnCheckedChangeListener(new u2(this, r0));
        goto L156
    L99:
        ViewGroup r102 = r0.e();
        if (r102 == null) goto L102;
        com.larus.utils.e1.x(r102);
    L102:
        ItemTextToggle r103 = r0.E0();
        if (r103 == null) goto L105;
        com.larus.utils.e1.x(r103);
        goto L105
    L70:
        ViewGroup r104 = r0.e();
        if (r104 == null) goto L73;
        com.larus.utils.e1.x(r104);
    L73:
        ItemTextToggle r105 = r0.I0();
        if (r105 == null) goto L76;
        com.larus.utils.e1.x(r105);
        goto L76
    L44:
        ViewGroup r106 = r0.e();
        if (r106 == null) goto L47;
        com.larus.utils.e1.x(r106);
    L47:
        ItemTextToggle r107 = r0.G0();
        if (r107 == null) goto L50;
        com.larus.utils.e1.x(r107);
        goto L50
    }

    public final void ib0() {
        if (AccountService.a.isLogin().booleanValue() == true) goto L5;
    L20:
        com.larus.bmhome.setting.c r0 = this.g;
        if (r0 == null) goto L28;
        ItemTextArrow r1 = r0.E();
        if (r1 == null) goto L29;
        com.larus.utils.e1.o(r1);
        return;
    L29:
        return;
    L28:
        return;
    L5:
        if (((Boolean) this.P.getValue()).booleanValue() == false) goto L20;
        if (FlowDriveSdkService.a.u() == false) goto L20;
        com.larus.bmhome.setting.c r2 = this.g;
        if (r2 == null) goto L26;
        ItemTextArrow r3 = r2.E();
        if (r3 == null) goto L27;
        com.larus.utils.e1.o(r3.getArrowView());
        com.larus.utils.e1.x(r3);
        com.larus.bmhome.setting.c r4 = this.g;
        if (r4 == null) goto L18;
        ItemGroup r5 = r4.r0();
        if (r5 == null) goto L18;
        com.larus.utils.e1.x(r5);
    L18:
        com.larus.utils.e1.d(r3, new w1(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new CommonSettingFragment$setupDriveCapacity$1$2(this, r3, null), 2, null);
        return;
    L27:
        return;
    }

    public final Unit jb0() {
        com.larus.bmhome.setting.c r0 = this.g;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (this.m == 1) goto L7;
    L15:
        boolean r2 = false;
    L16:
        if (r2 == false) goto L36;
        com.larus.utils.e1.x(r0.L());
        ItemGroup r3 = r0.t0();
        if (r3 == null) goto L20;
        com.larus.utils.e1.x(r3);
    L20:
        String r5 = "";
        if (com.larus.platform.service.c2.a.a() == false) goto L29;
        r0.L().setText(getString(2131900849));
        ItemTextArrow r4 = r0.L();
        Context r6 = getContext();
        if (r6 == null) goto L28;
        String r7 = v19.j5.a(r6, 2131894310, 2131900850);
        if (r7 == null) goto L28;
        r5 = r7;
    L28:
        r4.Z5(r5, null);
        r0.L().setVisible(true);
    L35:
        com.larus.utils.e1.d(r0.t0(), new s1(this));
    L42:
        ab0();
        return Unit.INSTANCE;
    L29:
        ItemTextArrow r1 = r0.L();
        Context r8 = getContext();
        if (r8 == null) goto L34;
        String r9 = v19.j5.a(r8, 2131894310, 2131900853);
        if (r9 == null) goto L34;
        r5 = r9;
    L34:
        r1.setText(r5);
        goto L35
    L36:
        com.larus.utils.e1.o(r0.L());
        ItemGroup r10 = r0.t0();
        if (r10 == null) goto L39;
        com.larus.utils.e1.o(r10);
    L39:
        ItemGroup r11 = r0.R();
        if (r11 == null) goto L42;
        com.larus.utils.e1.o(r11);
        goto L42
    L7:
        if (AppHost.a.isOversea() == false) goto L15;
        if (AccountService.a.isLogin().booleanValue() == false) goto L15;
        if (com.larus.platform.service.z2.a.enableSubscription() == false) goto L13;
    L14:
        r2 = true;
        goto L16
    L13:
        if (com.larus.platform.service.c2.a.a() == false) goto L15;
        goto L14
    }

    public final String k() {
        if (this.J == false) goto L6;
        return "setting";
    L6:
        Integer r0 = this.r;
        if (r0 != null) goto L10;
    L12:
        return "bot_setting";
    L10:
        if (r0.intValue() != 3) goto L12;
        return "new_chat_setting";
    }

    public final void kb0() {
        com.larus.bmhome.setting.c r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (com.larus.platform.service.z2.a.enableRenameRenewSection() == false) goto L7;
        r0.N0().setImageSrc(2131241661);
        r0.N0().setText(getString(2131909274));
        return;
    L7:
        r0.N0().setImageSrc(2131241850);
        r0.N0().setText(getString(2131900882));
    }

    public final void lb0() {
        com.larus.bmhome.setting.c r0 = this.g;
        if (r0 == null) goto L40;
        ItemTextToggle r1 = r0.V0();
        if (r1 != null) goto L7;
        return;
    L7:
        if (com.larus.platform.service.z2.a.getBasicExperienceFeatureConfig().a == true) goto L9;
    L11:
        final UserConfigItem r2 = UserSettingDelegate.b.b(UserConfigKey.STARTUP_OPEN_NEW_CHAT);
        com.larus.bmhome.auth.e0 r3 = AuthModelDelegate.b.D();
        if (r3 == null) goto L14;
        String r4 = r3.V();
    L16:
        if (Intrinsics.areEqual(r4, "1") == false) goto L38;
        if (r2 == null) goto L38;
        if (AccountService.a.isLogin().booleanValue() == false) goto L38;
        if (com.larus.platform.service.x1.a.a() == true) goto L38;
        boolean r5 = com.larus.platform.service.n0.a.b();
        int r6 = 2131906653;
        if (AppHost.a.isOversea() == false) goto L30;
        Context r7 = requireContext();
        if (r5 == true) goto L29;
        r6 = 2131906651;
    L29:
        String r8 = v19.j5.a(r7, 2131894310, r6);
    L33:
        r1.setText(r8);
        com.larus.utils.e1.x(r1);
        com.larus.bmhome.setting.c r9 = this.g;
        if (r9 == null) goto L43;
        final ItemTextToggle r10 = r9.V0();
        if (r10 == null) goto L44;
        r10.getToggleView().setChecked(Intrinsics.areEqual(r2.c(), "1"));
        r10.getToggleView().setOnCheckedChangeListener(new v4(r10, r2, this, r10));
        return;
    L44:
        return;
    L43:
        return;
    L30:
        if (r5 == false) goto L32;
        r8 = getString(2131906653);
        Intrinsics.checkNotNull(r8);
        goto L33
    L32:
        r8 = getString(2131906651);
    L38:
        com.larus.utils.e1.o(r1);
        return;
    L14:
        r4 = null;
        goto L16
    L9:
        if (com.larus.platform.service.n0.a.b() == false) goto L11;
        com.larus.utils.e1.o(r1);
        return;
    }

    public final com.larus.bmhome.setting.c mb0() {
        com.larus.bmhome.setting.c r0 = this.g;
        String r1 = null;
        if (r0 == null) goto L50;
        if (this.Y == true) goto L9;
        ItemTextArrow r2 = r0.a1();
        if (r2 == null) goto L51;
        com.larus.utils.e1.o(r2);
        return r0;
    L51:
        return r0;
    L9:
        com.larus.platform.service.z2 r3 = com.larus.platform.service.z2.a;
        boolean r4 = false;
        if (r3.disableCommonSettingsVoiceCreate() == false) goto L15;
        ItemTextArrow r5 = r0.a1();
        if (r5 == null) goto L53;
        r5.setVisible(false);
        return r0;
    L53:
        return r0;
    L15:
        if (AppHost.a.isOversea() == false) goto L33;
        ItemTextArrow r6 = r0.a1();
        if (r6 == null) goto L46;
        EditPos r7 = this.t;
        if (r7 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
        r7 = null;
    L22:
        if (r7.j() == false) goto L32;
        p2a.a r8 = p2a.r.b.l2();
        BotModel r9 = this.s;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r9 = null;
    L26:
        SpeakerVoice r10 = r9.getVoiceType();
        if (r10 == null) goto L30;
        r1 = r10.getLanguageCode();
    L30:
        if (r8.b(r1) == false) goto L32;
        r4 = true;
    L32:
        r6.setVisible(r4);
    L46:
        ItemTextArrow r11 = r0.a1();
        if (r11 == null) goto L55;
        r11.setOnClickListener(new i1(this));
        return r0;
    L55:
        return r0;
    L33:
        ItemTextArrow r12 = r0.a1();
        if (r12 == null) goto L46;
        if (r3.D2() == true) goto L38;
    L45:
        r12.setVisible(r4);
        goto L46
    L38:
        if (Da0() == false) goto L45;
        if (r0.Z0().getVisibility() != 0) goto L42;
        boolean r13 = true;
    L43:
        if (r13 == false) goto L45;
        r4 = true;
        goto L45
    L42:
        r13 = false;
        goto L43
    L50:
        return null;
    }

    public final void onDestroyView() {
        Balloon r0 = this.i;
        if (r0 == null) goto L5;
        r0.h();
    L5:
        this.i = null;
        com.larus.platform.api.n4 r1 = this.h;
        if (r1 == null) goto L8;
        r1.release();
    L8:
        this.h = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        AppHost.a.a().c(this.b1);
        if (this.s == null) goto L17;
        BotServiceImpl r2 = com.larus.im.d.a();
        BotModel r3 = this.s;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r3 = null;
    L13:
        String r4 = r3.getBotId();
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        r2.unregisterBotChangeListener(r4, this.W);
    L17:
        t19.s.a.a();
        FragmentExtKt.addOnBackPressed.callback.1 r5 = this.v;
        if (r5 == null) goto L20;
        r5.remove();
    L20:
        s1a.a.g(this).m(com.larus.bmhome.setting.c.class);
        this.g = null;
    }

    public final void sb0() {
        Job r0 = this.V0;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.V0 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CommonSettingFragment$updateDoraRedDotInMainThread$1(this, null), 3, null);
    }

    public final void tb0() {
        ItemGroup[] r0 = new ItemGroup[11];
        com.larus.bmhome.setting.c r1 = this.g;
        ItemGroup r2 = null;
        if (r1 == null) goto L5;
        ItemGroup r3 = r1.m0();
    L6:
        boolean r4 = false;
        r0[0] = r3;
        com.larus.bmhome.setting.c r5 = this.g;
        if (r5 == null) goto L9;
        ItemGroup r6 = r5.n0();
    L10:
        r0[1] = r6;
        com.larus.bmhome.setting.c r7 = this.g;
        if (r7 == null) goto L13;
        ItemGroup r8 = r7.r0();
    L14:
        r0[2] = r8;
        com.larus.bmhome.setting.c r9 = this.g;
        if (r9 == null) goto L17;
        ItemGroup r10 = r9.g();
    L18:
        r0[3] = r10;
        com.larus.bmhome.setting.c r11 = this.g;
        if (r11 == null) goto L21;
        ItemGroup r12 = r11.o0();
    L22:
        r0[4] = r12;
        com.larus.bmhome.setting.c r13 = this.g;
        if (r13 == null) goto L25;
        ItemGroup r14 = r13.p0();
    L26:
        r0[5] = r14;
        com.larus.bmhome.setting.c r15 = this.g;
        if (r15 == null) goto L29;
        ItemGroup r16 = r15.t0();
    L30:
        r0[6] = r16;
        com.larus.bmhome.setting.c r17 = this.g;
        if (r17 == null) goto L33;
        ItemGroup r18 = r17.U0();
    L34:
        r0[7] = r18;
        com.larus.bmhome.setting.c r19 = this.g;
        if (r19 == null) goto L37;
        ItemGroup r20 = r19.h0();
    L38:
        r0[8] = r20;
        com.larus.bmhome.setting.c r21 = this.g;
        if (r21 == null) goto L41;
        ItemGroup r22 = r21.i();
    L42:
        r0[9] = r22;
        com.larus.bmhome.setting.c r23 = this.g;
        if (r23 == null) goto L45;
        ItemGroup r24 = r23.s0();
    L46:
        r0[10] = r24;
        List r25 = CollectionsKt.listOf(r0);
        hq9.m4 r26 = this.H0;
        List r27 = r26.b;
        if (r27 != null) goto L49;
    L56:
        r27 = null;
    L58:
        if (r27 == null) goto L86;
        ArrayDeque r28 = new ArrayDeque();
        com.larus.bmhome.setting.c r29 = this.g;
        if (r29 == null) goto L64;
        View r30 = r29.P0();
        if (r30 == null) goto L64;
        r28.add(r30);
    L64:
        boolean r31 = false;
    L66:
        if ((!r28.isEmpty()) == false) goto L82;
        if (r31 == true) goto L82;
        View r32 = (View) r28.removeFirst();
        Object r33 = r32.getTag(2131377174);
        if (r33 != null) goto L71;
    L73:
        boolean r34 = false;
    L74:
        if (r34 == true) goto L81;
        if ((r32 instanceof ViewGroup) == false) goto L81;
        Iterator r35 = ViewGroupKt.getChildren((ViewGroup) r32).iterator();
    L79:
        if (r35.hasNext() == false) goto L81;
        r28.add((View) r35.next());
    L81:
        r31 = r34;
        goto L66
    L71:
        if (CollectionsKt.contains(r27, r33) == false) goto L73;
        r34 = true;
    L82:
        if (r31 == true) goto L84;
        FLogger.a.e(this.e, "host option white list matched nothing, skip filter: " + r27);
    L84:
        if (r31 != true) goto L86;
        r4 = true;
    L86:
        Iterator r36 = r25.iterator();
    L88:
        if (r36.hasNext() == false) goto L112;
        ItemGroup r37 = (ItemGroup) r36.next();
        if (r4 == false) goto L88;
        List r38 = this.H0.b;
        if (r38 == null) goto L88;
        if (r37 == null) goto L88;
        Sequence r39 = ViewGroupKt.getChildren(r37);
        if (r39 == null) goto L88;
        Iterator r40 = r39.iterator();
    L100:
        if (r40.hasNext() == false) goto L88;
        View r41 = (View) r40.next();
        if (this.J == false) goto L106;
        if (r41.getId() == 2131366939) goto L100;
    L106:
        Object r42 = r41.getTag(2131377174);
        if (r42 == null) goto L111;
        if (CollectionsKt.contains(r38, r42) == false) goto L111;
        FLogger.a.i(this.e, r42 + " is in white list so can visible");
    L111:
        com.larus.utils.e1.o(r41);
        FLogger.a.i(this.e, r42 + " is not in white list so must gone");
        goto L100
    L112:
        if (r4 == false) goto L118;
        com.larus.bmhome.setting.c r43 = this.g;
        if (r43 == null) goto L118;
        ViewGroup r44 = r43.e();
        if (r44 == null) goto L118;
        com.larus.utils.e1.o(r44);
    L118:
        com.larus.bmhome.setting.c r45 = this.g;
        if (r45 == null) goto L123;
        ItemGroup r46 = r45.m0();
        if (r46 == null) goto L123;
        com.larus.utils.w0.e(r46, v19.i5.q());
    L123:
        com.larus.bmhome.setting.c r47 = this.g;
        if (r47 == null) goto L126;
        ItemGroup r48 = r47.m0();
    L127:
        Ra0(r48);
        com.larus.bmhome.setting.c r49 = this.g;
        if (r49 == null) goto L130;
        ItemGroup r50 = r49.n0();
    L131:
        Ra0(r50);
        com.larus.bmhome.setting.c r51 = this.g;
        if (r51 == null) goto L134;
        ItemGroup r52 = r51.q0();
    L135:
        Ra0(r52);
        com.larus.bmhome.setting.c r53 = this.g;
        if (r53 == null) goto L138;
        ItemGroup r54 = r53.r0();
    L139:
        Ra0(r54);
        com.larus.bmhome.setting.c r55 = this.g;
        if (r55 == null) goto L142;
        ItemGroup r56 = r55.g();
    L143:
        Ra0(r56);
        com.larus.bmhome.setting.c r57 = this.g;
        if (r57 == null) goto L146;
        ItemGroup r58 = r57.o0();
    L147:
        Ra0(r58);
        com.larus.bmhome.setting.c r59 = this.g;
        if (r59 == null) goto L150;
        ItemGroup r60 = r59.p0();
    L151:
        Ra0(r60);
        com.larus.bmhome.setting.c r61 = this.g;
        if (r61 == null) goto L154;
        ItemGroup r62 = r61.t0();
    L155:
        Ra0(r62);
        com.larus.bmhome.setting.c r63 = this.g;
        if (r63 == null) goto L158;
        ItemGroup r64 = r63.h0();
    L159:
        Ra0(r64);
        com.larus.bmhome.setting.c r65 = this.g;
        if (r65 == null) goto L162;
        ItemGroup r66 = r65.i();
    L163:
        Ra0(r66);
        if (r4 == false) goto L173;
        com.larus.bmhome.setting.c r67 = this.g;
        if (r67 == null) goto L168;
        ItemGroup r68 = r67.U0();
    L169:
        Ra0(r68);
        com.larus.bmhome.setting.c r69 = this.g;
        if (r69 == null) goto L172;
        r2 = r69.s0();
    L172:
        Ra0(r2);
        goto L173
    L168:
        r68 = null;
    L173:
        Ba0();
        return;
    L162:
        r66 = null;
        goto L163
    L158:
        r64 = null;
        goto L159
    L154:
        r62 = null;
        goto L155
    L150:
        r60 = null;
        goto L151
    L146:
        r58 = null;
        goto L147
    L142:
        r56 = null;
        goto L143
    L138:
        r54 = null;
        goto L139
    L134:
        r52 = null;
        goto L135
    L130:
        r50 = null;
        goto L131
    L126:
        r48 = null;
        goto L127
    L49:
        if (r26.a == true) goto L51;
    L53:
        boolean r70 = false;
    L54:
        if (r70 == false) goto L56;
    L51:
        if ((!r27.isEmpty()) == false) goto L53;
        r70 = true;
        goto L54
    L45:
        r24 = null;
        goto L46
    L41:
        r22 = null;
        goto L42
    L37:
        r20 = null;
        goto L38
    L33:
        r18 = null;
        goto L34
    L29:
        r16 = null;
        goto L30
    L25:
        r14 = null;
        goto L26
    L21:
        r12 = null;
        goto L22
    L17:
        r10 = null;
        goto L18
    L13:
        r8 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void ub0() {
        com.larus.bmhome.setting.c r0 = this.g;
        if (r0 == null) goto L51;
        p2a.i.b.Z();
        BotModel r1 = this.s;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r1 = null;
    L7:
        bb0(r1.getName());
        BotModel r2 = this.s;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r2 = null;
    L10:
        cb0(r2.getTagList());
        ItemTextArrow r3 = r0.b0();
        BotModel r4 = this.s;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r4 = null;
    L13:
        SpeakerVoice r5 = r4.getVoiceType();
        if (r5 == null) goto L16;
        String r6 = r5.getLanguage();
    L17:
        String r7 = "";
        if (r6 != null) goto L20;
        r6 = "";
    L20:
        int r8 = ItemTextArrow.k;
        r3.Z5(r6, null);
        BotModel r9 = this.s;
        if (r9 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r9 = null;
    L23:
        boolean r10 = true;
        if (r9.getMuted() != true) goto L26;
        r0.Z0().Z5(getString(2131908048), null);
        return;
    L26:
        BotModel r11 = this.s;
        if (r11 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r11 = null;
    L29:
        SpeakerVoice r12 = r11.getVoiceType();
        if (r12 == null) goto L32;
        String r13 = r12.getName();
    L33:
        if (r13 != null) goto L35;
    L38:
        if (r10 == false) goto L40;
        r7 = getString(2131908048);
    L49:
        Intrinsics.checkNotNull(r7);
        r0.Z0().Z5(r7, null);
        return;
    L40:
        BotModel r14 = this.s;
        if (r14 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r14 = null;
    L43:
        SpeakerVoice r15 = r14.getVoiceType();
        if (r15 == null) goto L49;
        String r16 = r15.getName();
        if (r16 == null) goto L49;
        r7 = r16;
        goto L49
    L35:
        if (r13.length() == 0) goto L38;
        r10 = false;
        goto L38
    L32:
        r13 = null;
        goto L33
    L16:
        r6 = null;
        goto L17
    }

    public final void wb0() {
        com.larus.bmhome.setting.c r0 = this.g;
        if (r0 == null) goto L17;
        ItemTextArrow r1 = r0.j0();
        if (r1 == null) goto L18;
        BotModel r2 = this.s;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r2 = null;
    L9:
        ModelItem r3 = r2.getModel();
        if (r3 == null) goto L12;
        String r4 = r3.getName();
    L13:
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        int r5 = ItemTextArrow.k;
        r1.Z5(r4, null);
        return;
    L12:
        r4 = null;
        goto L13
    L18:
        return;
    }

    public final void yb0() {
        final com.larus.bmhome.setting.c r5 = this.g;
        if (r5 == null) goto L16;
        LinearLayout r0 = r5.s();
        if (r0 == null) goto L14;
        FeatureKitDelegate r1 = FeatureKitDelegate.b;
        if (r1.b0().b() == false) goto L9;
    L12:
        int r2 = 0;
    L13:
        r0.setVisibility(r2);
        goto L14
    L9:
        if (r1.a0().b() == true) goto L12;
        r2 = 8;
    L14:
        FeatureKitDelegate r3 = FeatureKitDelegate.b;
        final boolean r4 = r3.b0().b();
        final boolean r6 = r3.a0().b();
        final Ref.ObjectRef r7 = new Ref.ObjectRef();
        Transformations.map(AuthModelDelegate.b.c(), new l1()).observe(getViewLifecycleOwner(), new e(new m1(r7, this, r4, r6, r5)));
        return;
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [com.larus.bmhome.bot.CommonSettingFragment$listener$1] */
    public CommonSettingFragment() {
        this.e = "ChatSettingFragment";
        this.f = 100;
        final Function0<Fragment> r0 = new CommonSettingFragment$special$$inlined$viewModels$default$1(this);
        this.j = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BotSettingViewModel.class), new CommonSettingFragment$special$$inlined$viewModels$default$2(r0), new CommonSettingFragment$special$$inlined$viewModels$default$3(r0, this));
        final Function0<Fragment> r1 = new CommonSettingFragment$special$$inlined$viewModels$default$4(this);
        this.k = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AppSettingModel.class), new CommonSettingFragment$special$$inlined$viewModels$default$5(r1), new CommonSettingFragment$special$$inlined$viewModels$default$6(r1, this));
        this.l = new com.larus.bmhome.bot.b();
        this.m = 2;
        this.u = "";
        this.w = "";
        this.G = LazyKt.lazy(new q());
        this.H = LazyKt.lazy(new g3(this));
        this.K = LazyKt.lazy(new r3());
        this.L = LazyKt.lazy(new c4(this));
        this.M = LazyKt.lazy(new n4());
        this.N = LazyKt.lazy(new y4());
        this.O = LazyKt.lazy(new b0());
        this.P = LazyKt.lazy(new m0());
        this.Q = LazyKt.lazy(new x0(this));
        this.R = LazyKt.lazy(new h1(this));
        this.S = "";
        this.T = LazyKt.lazy(new o1(this));
        this.U = LazyKt.lazy(new z1(this));
        this.V = LazyKt.lazy(new k2(this));
        this.W = new CommonSettingFragment$listener$1(this);
        this.Y = true;
        this.Z = new com.larus.bmhome.chat.manager.settings.p();
        this.k0 = LazyKt.lazy(new v2(this));
        this.p0 = true;
        this.H0 = com.larus.platform.service.z2.a.q();
        this.b1 = new b(this);
    }

    public final ReplyOption Oa0() {
        ReplyOption r0 = Ia0().getDefaultReplyOption();
        if (r0 == null) goto L5;
        Object r1 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
        return com.larus.bmhome.view.actionbar.custom.cache.e.a(r0);
    L5:
        return null;
    }

    public final void T90() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CommonSettingFragment$logEnterPage$1(this, null), 3, null);
    }

    public final void nb0() {
        if (isAdded() == true) goto L6;
        FLogger.a.e(this.e, "ChatSettingFragment is not added");
        return;
    L6:
        p2a.s r0 = p2a.s.b;
        r0.F0().b(this).observe(getViewLifecycleOwner(), new e(new x1(this)));
        com.larus.audio.w0 r1 = r0.F0();
        BotModel r2 = this.s;
        EditPos r3 = null;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r2 = null;
    L9:
        SpeakerVoice r4 = r2.getVoiceType();
        EditPos r5 = this.t;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
    L13:
        r1.a(this, r4, r3);
        return;
    L12:
        r3 = r5;
        goto L13
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        if (this.x != null) goto L5;
        return;
    L5:
        if (this.y == 0) goto L14;
        long r0 = SystemClock.elapsedRealtime() - this.y;
        BotModel r2 = this.s;
        if (r2 == null) goto L10;
        String r3 = r2.getBotId();
    L11:
        Long r4 = Long.valueOf(r0);
        tx9.i3.h(r3, null, r4, null, null, null, null, null, null, this, 2042);
        this.y = 0;
        return;
    L10:
        r3 = null;
        goto L11
    }

    public final void onResume() {
        super.onResume();
        if (this.x == null) goto L5;
        this.y = SystemClock.elapsedRealtime();
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(null), 3, null);
        boolean r1 = false;
        gb0(false, "onResume");
        sb0();
        jb0();
        com.larus.bmhome.setting.c r4 = this.g;
        if (r4 == null) goto L26;
        FragmentActivity r3 = getContext();
        if ((r3 instanceof FragmentActivity) == false) goto L10;
        FragmentActivity r7 = r3;
    L11:
        LifecycleOwner r6 = getViewLifecycleOwner();
        AppHost.Companion r5 = AppHost.a;
        if (r5.isOversea() == false) goto L14;
    L16:
        if (r7 != null) goto L18;
    L23:
        RelativeLayout r2 = r4.d1();
        if (r2 == null) goto L26;
        com.larus.utils.e1.o(r2);
        Unit r8 = Unit.INSTANCE;
        goto L26
    L18:
        if (r5.isPlugin() == true) goto L23;
        if (AccountService.a.isLogin().booleanValue() == false) goto L23;
        if (r1 == true) goto L23;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r6), null, null, new CommonSettingFragment$setupUserInfo$1$1(r4, this, r6, r7, null), 3, null);
        goto L26
    L14:
        if (com.larus.platform.service.x1.a.a() == false) goto L16;
        r1 = true;
        goto L16
    L10:
        r7 = null;
    L26:
        ib0();
        com.larus.bmhome.setting.c r9 = this.g;
        if (r9 == null) goto L44;
        ItemTextArrow r10 = r9.l0();
        if (r10 == null) goto L44;
        AccountService r11 = AccountService.a;
        if (r11.isLogin().booleanValue() == true) goto L34;
    L43:
        com.larus.utils.e1.o(r10);
        goto L44
    L34:
        if (com.larus.platform.service.z2.a.g1() == false) goto L43;
        if (com.larus.platform.service.x1.a.a() == true) goto L43;
        com.larus.utils.e1.x(r10);
        int r12 = r11.v();
        if (r12 <= 1) goto L41;
        String r13 = String.valueOf(r12);
    L42:
        r10.Z5(r13, null);
        com.larus.utils.e1.d(r10, new n1(this));
        goto L44
    L41:
        r13 = "";
    L44:
        ab0();
    }

    public final void onLowMemory() {
        super/*androidx.fragment.app.Fragment*/.onLowMemory();
    }

    public static String Ha0(long r5) {
        if (r5 > 0) goto L6;
        return "0 GB";
    L6:
        BigDecimal r0 = BigDecimal.valueOf(r5).divide(k1, 10, RoundingMode.DOWN);
        BigDecimal r1 = v1;
        if (r0.compareTo(r1) > 0) goto L11;
        return r1.stripTrailingZeros().toPlainString() + " GB";
    L11:
        if (r5 < 1099511627776L) goto L13;
        Pair r6 = TuplesKt.to(BigDecimal.valueOf(r5).divide(p1, 2, RoundingMode.DOWN), "TB");
    L14:
        BigDecimal r7 = (BigDecimal) r6.component1();
        String r8 = (String) r6.component2();
        StringBuilder r2 = new StringBuilder();
        Intrinsics.checkNotNull(r7);
        r2.append(r7.stripTrailingZeros().toPlainString());
        r2.append(' ');
        r2.append(r8);
        return r2.toString();
    L13:
        r6 = TuplesKt.to(r0.setScale(2, RoundingMode.DOWN), "GB");
        goto L14
    }

    public static void Ra0(ItemGroup r4) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L29;
        Iterator r3 = ViewGroupKt.getChildren(r4).iterator();
    L14:
        if (r3.hasNext() == false) goto L22;
        if (((View) r3.next()).getVisibility() != 0) goto L18;
        boolean r5 = true;
    L20:
        if ((!r5) == true) goto L14;
    L23:
        if (r0 == false) goto L30;
        com.larus.utils.e1.o(r4);
        return;
    L30:
        return;
    L18:
        r5 = false;
        goto L20
    L22:
        r0 = true;
        goto L23
    L29:
        return;
    L5:
        if (r4.getVisibility() != 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 != true) goto L10;
        r2 = true;
        goto L11
    L7:
        r6 = false;
        goto L8
    }

    public static void V90(com.larus.common_ui.dialog.l0 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static final void X90(CommonSettingFragment r5) {
        r5.getClass();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L45
        hq9.p1 r1 = com.larus.platform.service.z2.a.j2();     // Catch: Throwable -> L45
        Iterator r2 = r1.a.iterator();     // Catch: Throwable -> L45
    L5:
        if (r2.hasNext() == false) goto L38;
        if (Intrinsics.areEqual((String) r2.next(), r5.S) == false) goto L5;
        SpannableStringBuilder r3 = new SpannableStringBuilder(r1.b);     // Catch: Throwable -> L45
        r3.setSpan(new d5(r1, r5), 0, r1.b.length(), 33);     // Catch: Throwable -> L45
        com.larus.bmhome.setting.c r4 = r5.g;     // Catch: Throwable -> L45
        if (r4 == null) goto L13;
        TextView r6 = r4.V();     // Catch: Throwable -> L45
        if (r6 == null) goto L13;
        r6.setText(r3);     // Catch: Throwable -> L45
    L13:
        com.larus.bmhome.setting.c r7 = r5.g;     // Catch: Throwable -> L45
        if (r7 == null) goto L18;
        TextView r8 = r7.V();     // Catch: Throwable -> L45
        if (r8 == null) goto L18;
        r8.setMovementMethod(LinkMovementMethod.getInstance());     // Catch: Throwable -> L45
    L18:
        com.larus.bmhome.setting.c r9 = r5.g;     // Catch: Throwable -> L45
        if (r9 == null) goto L23;
        TextView r10 = r9.V();     // Catch: Throwable -> L45
        if (r10 == null) goto L23;
        r10.setHighlightColor(0);     // Catch: Throwable -> L45
    L23:
        com.larus.bmhome.setting.c r11 = r5.g;     // Catch: Throwable -> L45
        if (r11 == null) goto L28;
        TextView r12 = r11.V();     // Catch: Throwable -> L45
        if (r12 == null) goto L28;
        r12.setClickable(true);     // Catch: Throwable -> L45
    L28:
        com.larus.bmhome.setting.c r13 = r5.g;     // Catch: Throwable -> L45
        if (r13 == null) goto L33;
        TextView r14 = r13.V();     // Catch: Throwable -> L45
        if (r14 == null) goto L33;
        r14.setLongClickable(false);     // Catch: Throwable -> L45
    L33:
        com.larus.bmhome.setting.c r15 = r5.g;     // Catch: Throwable -> L45
        if (r15 == null) goto L52;
        TextView r16 = r15.V();     // Catch: Throwable -> L45
        if (r16 == null) goto L53;
        com.larus.utils.e1.x(r16);     // Catch: Throwable -> L45
        return;
    L53:
        return;
    L52:
        return;
    L38:
        com.larus.bmhome.setting.c r17 = r5.g;     // Catch: Throwable -> L45
        if (r17 == null) goto L43;
        TextView r18 = r17.V();     // Catch: Throwable -> L45
        if (r18 == null) goto L43;
        com.larus.utils.e1.o(r18);     // Catch: Throwable -> L45
    L43:
        Result.constructor-impl(r1);     // Catch: Throwable -> L45
        return;
    L45:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static final void Y90(CommonSettingFragment r2) {
        com.larus.bmhome.setting.c r0 = r2.g;
        if (r0 == null) goto L9;
        com.larus.utils.e1.x(r0.U0());
        ItemTextToggle r1 = r0.K0();
        if (com.larus.platform.service.z2.a.m3() == true) goto L7;
        FLogger.a.e(r2.e, "audio not enable");
        return;
    L7:
        boolean r3 = VoiceCallServiceDelegate.a.F();
        r1.getToggleView().setChecked(r3);
        r1.getToggleView().setOnCheckedChangeListener(new f4());
        return;
    }

    public static final void Z90(final CommonSettingFragment r2) {
        com.larus.bmhome.setting.c r0 = r2.g;
        if (r0 == null) goto L9;
        BotModel r1 = r2.s;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r1 = null;
    L7:
        r2.qb0(r1.getPrivateStatus());
        com.larus.utils.e1.d(r0.b(), new t3(r2));
        Unit r3 = Unit.INSTANCE;
        return;
    }

    public static final void aa0(final CommonSettingFragment r3) {
        if (r3.A == true) goto L7;
        r3.Ja0().getUpdateBotAccessPermission().observe(r3.getViewLifecycleOwner(), new e(new i4(r3)));
        return;
    }

    public static final void ba0(final CommonSettingFragment r7) {
        com.larus.bmhome.setting.c r0 = r7.g;
        if (r0 == null) goto L6;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r7), Dispatchers.getIO(), null, new CommonSettingFragment$setupBotEdit$1$1(r7, null), 2, null);
        r0.G().setOnClickListener(new w(r7));
        Unit r8 = Unit.INSTANCE;
        return;
    }

    public static final void ca0(final CommonSettingFragment r3) {
        if (r3.A == true) goto L7;
        r3.Ja0().getUpdateBotEditItemFromDBResult().observe(r3.getViewLifecycleOwner(), new e(new l3(r3)));
        return;
    }

    public static final void da0(final CommonSettingFragment r6) {
        com.larus.bmhome.setting.c r0 = r6.g;
        if (r0 == null) goto L53;
        ItemTextArrow r1 = r0.b0();
        boolean r3 = true;
        if (r6.J == false) goto L7;
    L16:
        boolean r2 = false;
    L17:
        if (r2 == false) goto L19;
        int r4 = 0;
    L20:
        r1.setVisibility(r4);
        IFlowSdkDepend r5 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r5 == null) goto L23;
        r5.i();
        com.larus.home.impl.sdk.u2.a.b();
    L23:
        r0.b0().setOnClickListener(new j2(r6));
        if (r0.b0().getText().length() > 0) goto L27;
        r3 = false;
    L27:
        String r7 = "";
        if (r3 == false) goto L41;
        CharSequence r8 = r0.b0().getText();
        BotModel r9 = r6.s;
        if (r9 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r9 = null;
    L32:
        SpeakerVoice r10 = r9.getVoiceType();
        if (r10 == null) goto L35;
        String r11 = r10.getLanguage();
    L36:
        if (r11 != null) goto L39;
        r11 = "";
    L39:
        if (Intrinsics.areEqual(r8, r11) == true) goto L41;
        p2a.i.b.Z();
        goto L41
    L35:
        r11 = null;
    L41:
        ItemTextArrow r12 = r0.b0();
        BotModel r13 = r6.s;
        if (r13 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r13 = null;
    L44:
        SpeakerVoice r14 = r13.getVoiceType();
        if (r14 == null) goto L47;
        String r15 = r14.getLanguage();
    L48:
        if (r15 == null) goto L51;
        r7 = r15;
    L51:
        int r16 = ItemTextArrow.k;
        r12.Z5(r7, null);
        Unit r17 = Unit.INSTANCE;
        return;
    L47:
        r15 = null;
        goto L48
    L19:
        r4 = 8;
        goto L20
    L7:
        if (com.larus.platform.service.z2.a.q().f == false) goto L16;
        com.larus.bmhome.chat.api.e0 r18 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r18 == null) goto L13;
        LaunchInfo r19 = r18.a;
        if (r19 == null) goto L13;
        boolean r20 = Intrinsics.areEqual(r19.N0(), Boolean.TRUE);
    L14:
        if (r20 == true) goto L16;
        r2 = true;
    L13:
        r20 = false;
        goto L14
    }

    public static final void ea0(final CommonSettingFragment r12) {
        com.larus.bmhome.setting.c r0 = r12.g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r12.Ua0() == false) goto L7;
    L62:
        Unit r13 = Unit.INSTANCE;
        return;
    L7:
        if (r12.J == true) goto L62;
        com.larus.platform.service.z2 r1 = com.larus.platform.service.z2.a;
        if (r1.q().g == false) goto L62;
        String r2 = null;
        if (r1.x3().getDisableBotShare() == false) goto L20;
        Integer r3 = r12.r;
        BotModel r4 = r12.s;
        if (r4 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r4 = null;
    L18:
        if (nq9.h.a(r3, r4.getBotType()) == true) goto L62;
    L20:
        BotModel r5 = r12.s;
        if (r5 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r5 = null;
    L23:
        ShareInfo r6 = r5.getShareInfo();
        boolean r7 = false;
        if (r6 == null) goto L26;
        boolean r8 = Intrinsics.areEqual(r6.isShowShareTab(), Boolean.TRUE);
    L27:
        if (r8 == false) goto L62;
        Integer r9 = r12.r;
        if (r9 != null) goto L32;
    L34:
        BotModel r10 = r12.s;
        if (r10 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r10 = null;
    L37:
        ShareInfo r11 = r10.getShareInfo();
        if (r11 == null) goto L40;
        String r14 = r11.getShareStatus();
    L41:
        final boolean r15 = Intrinsics.areEqual(r14, "shareable");
        if (r15 == false) goto L44;
        float r16 = 1.0f;
    L46:
        if (r12.Ja0().getShareBtnCenter() == false) goto L61;
        ((com.larus.common_ui.view.b0) r12.k0.getValue()).b();
        LarusShareButtonCenterLayoutBinding r17 = ((com.larus.common_ui.view.b0) r12.k0.getValue()).c;
        if (r17 == null) goto L52;
        FrameLayout r18 = r17.b;
        if (r18 == null) goto L52;
        com.larus.utils.e1.d(r18, new v3(r12, r15));
        r18.setAlpha(r16);
    L52:
        if (r7 == false) goto L61;
        LarusShareButtonCenterLayoutBinding r19 = ((com.larus.common_ui.view.b0) r12.k0.getValue()).c;
        if (r19 == null) goto L61;
        TextView r20 = r19.c;
        if (r20 == null) goto L61;
        Context r21 = r12.getContext();
        if (r21 == null) goto L60;
        r2 = r21.getString(2131900242);
    L60:
        r20.setText(r2);
    L61:
        NovaTitleBarEx.k6(r0.Y0(), v19.c.b(2130971664, r12.getContext(), 2131240964), r16, null, r12.getString(2131898834), new w3(r12, r15), 12);
        goto L62
    L44:
        r16 = 0.3f;
        goto L46
    L40:
        r14 = null;
        goto L41
    L32:
        if (r9.intValue() != 3) goto L34;
        r7 = true;
        goto L34
    L26:
        r8 = false;
        goto L27
    }

    public static final void fa0(final CommonSettingFragment r3) {
        if (r3.g != null) goto L5;
        return;
    L5:
        if (r3.A == true) goto L7;
        r3.Ja0().getChatHistoryClearSuccess().observe(r3.getViewLifecycleOwner(), new e(new x(r3)));
    L7:
        Unit r4 = Unit.INSTANCE;
    }

    public static final void ga0(final CommonSettingFragment r5) {
        final com.larus.bmhome.setting.c r0 = r5.g;
        if (r0 == null) goto L18;
        ItemTextArrow r1 = r0.F();
        if (r1 == null) goto L7;
        r1.setOnClickListener(new d2(r5));
    L7:
        ItemTextArrow r2 = r0.F();
        if (r2 == null) goto L14;
        String r3 = r5.o;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("conversationName");
        r3 = null;
    L12:
        int r4 = ItemTextArrow.k;
        r2.Z5(r3, null);
    L14:
        if (r5.A == true) goto L16;
        r5.Ja0().getUpdateCvsName().observe(r5.getViewLifecycleOwner(), new e(new e2(r5, r0)));
    L16:
        Unit r6 = Unit.INSTANCE;
        return;
    }

    public static final void ha0(final CommonSettingFragment r3) {
        com.larus.bmhome.setting.c r0 = r3.g;
        if (r0 == null) goto L20;
        ItemTextArrow r1 = r0.j0();
        if (r1 == null) goto L7;
        r1.setOnClickListener(new s3(r3));
    L7:
        ItemTextArrow r2 = r0.j0();
        if (r2 == null) goto L21;
        BotModel r4 = r3.s;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r4 = null;
    L12:
        ModelItem r5 = r4.getModel();
        if (r5 == null) goto L15;
        String r6 = r5.getName();
    L16:
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        int r7 = ItemTextArrow.k;
        r2.Z5(r6, null);
        Unit r8 = Unit.INSTANCE;
        return;
    L15:
        r6 = null;
        goto L16
    L21:
        return;
    }

    public static /* synthetic */ void hb0(CommonSettingFragment r2) {
        r2.gb0(true, "");
    }

    public static final void ia0(final CommonSettingFragment r3) {
        if (r3.g != null) goto L5;
        return;
    L5:
        if (r3.A == true) goto L7;
        r3.Ja0().getDeleteBot().observe(r3.getViewLifecycleOwner(), new e(new k4(r3)));
    L7:
        Unit r4 = Unit.INSTANCE;
    }

    public static final void ja0(final CommonSettingFragment r3) {
        com.larus.bmhome.setting.c r0 = r3.g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3.A == true) goto L10;
        ItemTextView r1 = r0.z();
        if (r1 == null) goto L9;
        r1.setOnClickListener(new l2(r3));
    L9:
        r3.Ja0().getRemoveConversation().observe(r3.getViewLifecycleOwner(), new e(new m2(r3)));
    L10:
        Unit r4 = Unit.INSTANCE;
    }

    public static final void ka0(CommonSettingFragment r7) {
        if (r7.getView() == null) goto L6;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r7.getViewLifecycleOwner()), null, null, new CommonSettingFragment$setupDoraRedDotObserver$1(r7, null), 3, null);
        return;
    }

    public static final void la0(final CommonSettingFragment r4) {
        com.larus.bmhome.setting.c r0 = r4.g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4.m != 1) goto L17;
        CoroutineScope r1 = ExpertSwitchManager.a;
        if (FeatureKitDelegate.b.h0().b() == false) goto L11;
        ItemGroup r2 = r0.P();
        if (r2 == null) goto L14;
        r2.setVisibility(0);
    L14:
        final ItemTextToggle r3 = r0.H();
        if (r3 == null) goto L22;
        r3.getToggleView().setChecked(ExpertSwitchManager.b.f0());
        r3.getToggleView().setClickable(false);
        r3.getToggleView().setOnCheckedChangeListener(new i2(r3, r4));
        Unit r5 = Unit.INSTANCE;
        return;
    L22:
        return;
    L11:
        ItemGroup r6 = r0.P();
        if (r6 == null) goto L14;
        r6.setVisibility(8);
        goto L14
    L17:
        ItemGroup r7 = r0.P();
        if (r7 == null) goto L24;
        r7.setVisibility(8);
        Unit r8 = Unit.INSTANCE;
        return;
    }

    public static final void ma0(CommonSettingFragment r3) {
        com.larus.bmhome.setting.c r4 = r3.g;
        if (r4 == null) goto L17;
        Iterator r5 = CollectionsKt.listOf(new ItemGroup[]{r4.M(), r4.N(), r4.O(), r4.P(), r4.Q(), r4.m0(), r4.U0(), r4.n0(), r4.r0(), r4.g(), r4.o0(), r4.p0(), r4.h0(), r4.i()}).iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        ItemGroup r0 = (ItemGroup) r5.next();
        if (r0 == null) goto L6;
        r0.c();
        goto L6
    L10:
        Unit r6 = Unit.INSTANCE;
        return;
    }

    public static final void na0(final CommonSettingFragment r8) {
        com.larus.bmhome.setting.c r0 = r8.g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.X().getVisibility() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
    L31:
        Unit r9 = Unit.INSTANCE;
        return;
    L11:
        if (r0.b1() == false) goto L30;
        AppHost.Companion r2 = AppHost.a;
        String r5 = "";
        if (r2.isOversea() == true) goto L22;
        ItemTextArrow r4 = r0.X();
        Context r6 = r8.getContext();
        if (r6 == null) goto L21;
        String r7 = r6.getString(2131909248);
        if (r7 == null) goto L21;
        String r3 = String.format(r7, Arrays.copyOf(new Object[]{r2.getAppStringName()}, 1));
        if (r3 == null) goto L21;
        r5 = r3;
    L21:
        r4.setText(r5);
        goto L30
    L22:
        ItemTextArrow r10 = r0.X();
        Context r11 = r8.getContext();
        if (r11 == null) goto L29;
        String r12 = r11.getString(2131909249);
        if (r12 == null) goto L29;
        String r13 = String.format(r12, Arrays.copyOf(new Object[]{r2.getAppStringName()}, 1));
        if (r13 == null) goto L29;
        r5 = r13;
    L29:
        r10.setText(r5);
    L30:
        com.larus.utils.e1.d(r0.X(), new n3(r8));
        goto L31
    L7:
        r1 = false;
        goto L8
    }

    public static final void oa0(final CommonSettingFragment r6) {
        com.larus.bmhome.setting.c r0 = r6.g;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L18;
        final com.larus.bmhome.setting.c r3 = r6.g;
        if (r3 != null) goto L12;
        return;
    L12:
        if (((Boolean) r6.N.getValue()).booleanValue() == true) goto L14;
    L17:
        Unit r7 = Unit.INSTANCE;
        return;
    L14:
        if (r6.I != null) goto L17;
        AppCompatTextView r4 = new AppCompatTextView(r3.P0().getContext());
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-1, v19.i5.f0());
        r5.bottomMargin = v19.i5.T();
        r5.topMargin = v19.i5.q();
        r4.setLayoutParams(r5);
        r4.setGravity(17);
        r4.setTextSize(14.0f);
        r4.setTextColor(ContextCompat.getColor(r4.getContext(), v19.c.b(2130972123, r4.getContext(), 2131103203)));
        r6.I = r4;
        r3.P0().post(new j3(r6, r3));
        goto L17
    L18:
        com.larus.bmhome.setting.c r8 = r6.g;
        TextView r9 = null;
        if (r8 == null) goto L23;
        TextView r10 = r8.c0();
        if (r10 == null) goto L23;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
    L25:
        if ((r11 instanceof LinearLayout.LayoutParams) == false) goto L27;
        LinearLayout.LayoutParams r12 = (LinearLayout.LayoutParams) r11;
    L28:
        com.larus.bmhome.setting.c r13 = r6.g;
        if (r13 == null) goto L38;
        TextView r14 = r13.V();
        if (r14 == null) goto L38;
        if (r14.getVisibility() != 0) goto L35;
        boolean r15 = true;
    L36:
        if (r15 != true) goto L38;
        r1 = true;
        goto L38
    L35:
        r15 = false;
    L38:
        if (r1 == false) goto L41;
        if (r12 == null) goto L43;
        r12.topMargin = c7.b(8);
    L43:
        com.larus.bmhome.setting.c r16 = r6.g;
        if (r16 == null) goto L49;
        TextView r17 = r16.c0();
        if (r17 == null) goto L49;
        r17.setLayoutParams(r12);
    L49:
        if (((Boolean) r6.N.getValue()).booleanValue() == false) goto L55;
        com.larus.bmhome.setting.c r18 = r6.g;
        if (r18 == null) goto L60;
        TextView r19 = r18.c0();
        if (r19 == null) goto L60;
        com.larus.utils.e1.x(r19);
    L60:
        com.larus.bmhome.setting.c r20 = r6.g;
        if (r20 == null) goto L63;
        r9 = r20.c0();
    L63:
        r6.fb0(r9);
        return;
    L55:
        com.larus.bmhome.setting.c r21 = r6.g;
        if (r21 == null) goto L60;
        TextView r22 = r21.c0();
        if (r22 == null) goto L60;
        com.larus.utils.e1.o(r22);
        goto L60
    L41:
        if (r12 == null) goto L43;
        r12.topMargin = c7.b(24);
        goto L43
    L27:
        r12 = null;
    L23:
        r11 = null;
        goto L25
    L5:
        if (r0.b1() != true) goto L7;
        r2 = true;
        goto L8
    }

    public static final void pa0(final CommonSettingFragment r5) {
        final com.larus.bmhome.setting.c r0 = r5.g;
        if (r0 == null) goto L28;
        BotModel r1 = r5.s;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r1 = null;
    L7:
        BotMemoryConfig r2 = r1.getBotMemoryConfig();
        if (r2 == null) goto L10;
        boolean r3 = Intrinsics.areEqual(r2.getEnableBotMemory(), Boolean.TRUE);
    L11:
        if (r3 == true) goto L13;
    L26:
        r0.e0().setVisibility(8);
        Unit r6 = Unit.INSTANCE;
        return;
    L13:
        if (r0.e0().getTag() != null) goto L26;
        if (AccountService.a.isLogin().booleanValue() == false) goto L26;
        BotModel r4 = r5.s;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r4 = null;
    L19:
        BotMemoryConfig r7 = r4.getBotMemoryConfig();
        if (r7 == null) goto L29;
        r0.e0().setVisible(true);
        com.larus.utils.e1.d(r0.e0(), new z(r5, r0));
        if (Intrinsics.areEqual(r7.getSwitchStatus(), Boolean.TRUE) == false) goto L24;
        r0.e0().Z5(r5.getString(2131909292), null);
    L25:
        Unit r8 = Unit.INSTANCE;
        return;
    L24:
        r0.e0().Z5(r5.getString(2131909291), null);
        goto L25
    L29:
        return;
    L10:
        r3 = false;
        goto L11
    }

    public static final void qa0(final CommonSettingFragment r3) {
        if (r3.isAdded() == true) goto L5;
    L24:
        FLogger.a.i(r3.e, "setupMembershipEntry skipped: fragment not ready");
        return;
    L5:
        if (r3.getView() == null) goto L24;
        ICommerceMembershipService.a.getClass();     // Catch: Exception -> L22
        ICommerceMembershipService r0 = ICommerceMembershipService.a.a();     // Catch: Exception -> L22
        if (r0 == null) goto L10;
        uz8.f r1 = r0.y();     // Catch: Exception -> L22
    L11:
        r3.vb0(r1);     // Catch: Exception -> L22
        if (r0 == null) goto L15;
        r0.c(LifecycleOwnerKt.getLifecycleScope(r3.getViewLifecycleOwner()), new v(r3));     // Catch: Exception -> L22
    L15:
        if (r3.C == true) goto L28;
        r3.C = true;     // Catch: Exception -> L22
        if (r0 == null) goto L19;
        r0.a("onSetupMembershipSettingEntry");     // Catch: Exception -> L22
    L19:
        if (r0 == null) goto L29;
        r0.g("SETTINGS");     // Catch: Exception -> L22
        return;
    L29:
        return;
    L28:
        return;
    L10:
        r1 = null;
    L22:
        e = move-exception;
        FLogger.a.e(r3.e, "setupMembershipEntry failed", e);
        com.larus.platform.service.g.a.ensureNotReachHere(e);
    }

    public static final void ra0(final CommonSettingFragment r7) {
        final com.larus.bmhome.setting.c r0 = r7.g;
        if (r0 == null) goto L46;
        FLogger r1 = FLogger.a;
        String r2 = r7.e;
        StringBuilder r3 = new StringBuilder("setupNickName callerName: ");
        BotModel r4 = r7.s;
        BotModel r5 = null;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r4 = null;
    L7:
        r3.append(r4.getCallerName());
        r3.append(" , setting -> ");
        BotModel r6 = r7.s;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r6 = null;
    L10:
        r3.append(r6.getCallerNameSetting());
        r1.d(r2, r3.toString());
        BotModel r8 = r7.s;
        if (r8 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r8 = null;
    L13:
        String r9 = r8.getCallerName();
        int r10 = 0;
        if (r9 != null) goto L16;
    L19:
        boolean r11 = true;
    L20:
        if (r11 == true) goto L27;
        ItemTextArrow r12 = r0.x0();
        if (r12 == null) goto L27;
        BotModel r13 = r7.s;
        if (r13 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r13 = null;
    L26:
        String r14 = String.valueOf(r13.getCallerName());
        int r15 = ItemTextArrow.k;
        r12.Z5(r14, null);
    L27:
        ItemTextArrow r16 = r0.x0();
        if (r16 == null) goto L30;
        r16.setImageSrc(2131242745);
    L30:
        ItemTextArrow r17 = r0.x0();
        if (r17 == null) goto L33;
        r17.setOnClickListener(new y3(r7, r0));
    L33:
        ItemTextArrow r18 = r0.x0();
        if (r18 == null) goto L44;
        BotModel r19 = r7.s;
        if (r19 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L40:
        if (Intrinsics.areEqual(r5.getCallerNameSetting(), Boolean.TRUE) == true) goto L43;
        r10 = 8;
    L43:
        r18.setVisibility(r10);
        goto L44
    L38:
        r5 = r19;
    L44:
        Unit r20 = Unit.INSTANCE;
        return;
    L16:
        if (r9.length() == 0) goto L19;
        r11 = false;
        goto L20
    }

    public static final void sa0(final CommonSettingFragment r4) {
        BotModel r0 = r4.s;
        if (r0 == null) goto L21;
        final String r1 = r0.getBotId();
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        com.larus.bmhome.setting.c r2 = r4.g;
        if (r2 == null) goto L22;
        final ItemTextArrow r3 = r2.D0();
        if (r3 == null) goto L23;
        PluginManagerDelegate r5 = PluginManagerDelegate.a;
        Intrinsics.checkNotNullParameter(r1, "botId");
        ConcurrentHashMap<String, PluginManager> r6 = PluginManager.d;
        CopyOnWriteArrayList<PluginItem> r7 = PluginManager.a.a(r1).a.d;
        if (r7 != null) goto L15;
    L18:
        boolean r8 = true;
    L19:
        r3.setVisible(!r8);
        com.larus.utils.e1.d(r3, new s4(r4, r1));
        PluginManagerDelegate.r(r1, true, null, new t4(r3));
        return;
    L15:
        if (r7.isEmpty() == true) goto L18;
        r8 = false;
        goto L19
    L23:
        return;
    L22:
        return;
    }

    public static final void ta0(final CommonSettingFragment r8) {
        com.larus.bmhome.setting.c r0 = r8.g;
        if (r0 == null) goto L37;
        Context r1 = r8.getContext();
        if (r1 == null) goto L38;
        final ItemTextArrow r2 = r0.O0();
        if (r2 == null) goto L39;
        BotModel r3 = r8.s;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r3 = null;
    L11:
        Integer r4 = r3.getBotStatus();
        if (r4 != null) goto L15;
    L16:
        BotModel r5 = r8.s;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r5 = null;
    L19:
        Integer r6 = r5.getBotStatus();
        if (r6 != null) goto L23;
    L33:
        ItemGroup r9 = r0.S();
        if (r9 == null) goto L41;
        r9.setVisibility(8);
        return;
    L41:
        return;
    L23:
        if (r6.intValue() != (-30)) goto L33;
    L24:
        BotModel r7 = r8.s;
        if (r7 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r7 = null;
    L28:
        if (r7.getBotMode() != 1) goto L33;
        ItemGroup r10 = r0.S();
        if (r10 == null) goto L32;
        r10.setVisibility(0);
    L32:
        r2.setVisible(true);
        r2.setTextColor(ContextCompat.getColor(r1, 2131102650));
        r2.getSubTextView().setVisibility(0);
        r2.Z5(r8.getString(2131908927), null);
        r2.getSubTextView().setTextColor(ContextCompat.getColor(r1, v19.c.b(2130972123, r1, 2131103203)));
        r2.getArrowView().setVisibility(8);
        com.larus.utils.e1.d(r2, new e4(r8, r2));
        return;
    L15:
        if (r4.intValue() == (-50)) goto L24;
    L39:
        return;
    L38:
        return;
    }

    public static final void ua0(final CommonSettingFragment r8) {
        com.larus.bmhome.setting.c r0 = r8.g;
        if (r0 == null) goto L39;
        final String r1 = r8.n;
        BotModel r2 = null;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r1 = null;
    L8:
        if (r1.length() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L14;
        r1 = r8.La0();
    L14:
        if (r8.m == 3) goto L34;
        Boolean r4 = Boolean.TRUE;
        BotModel r5 = r8.s;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r5 = null;
    L19:
        if (Intrinsics.areEqual(r4, r5.getShowMessagePush()) == false) goto L34;
        if (ic8.n.r(r8.q) == true) goto L34;
        ItemGroup r6 = r0.O();
        if (r6 == null) goto L25;
        com.larus.utils.e1.x(r6);
    L25:
        final ItemTextToggle r7 = r0.k0();
        if (r7 == null) goto L37;
        CustomSwitchCompat r9 = r7.getToggleView();
        BotModel r10 = r8.s;
        if (r10 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L31:
        r9.setChecked(Intrinsics.areEqual(r4, r2.getMessagePush()));
        r7.getToggleView().setOnCheckedChangeListener(new o4(r8, r1));
        final LifecycleOwner r11 = ViewTreeLifecycleOwner.get(r7.getToggleView());
        if (r11 == null) goto L37;
        r8.Ja0().getMessagePushLiveData().observe(r11, new e(new p4(r11, r7, r8)));
        goto L37
    L30:
        r2 = r10;
    L37:
        r8.kb0();
        com.larus.utils.e1.d(r0.N0(), new q4(r8, r1));
        Unit r12 = Unit.INSTANCE;
        return;
    L34:
        ItemGroup r13 = r0.O();
        if (r13 == null) goto L37;
        r13.setVisibility(8);
        goto L37
    L10:
        r3 = false;
        goto L11
    }

    public static final void va0(final CommonSettingFragment r3) {
        com.larus.bmhome.setting.c r0 = r3.g;
        if (r3.getView() == null) goto L5;
        LifecycleOwner r1 = r3.getViewLifecycleOwner();
    L6:
        if (r1 == null) goto L10;
        r3.Ja0().getResetBotInfo().observe(r1, new e(new x3(r3)));
        return;
    L10:
        return;
    L5:
        r1 = r3.getActivity();
        goto L6
    }

    public static final void wa0(final CommonSettingFragment r12) {
        com.larus.bmhome.setting.c r0 = r12.g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (com.larus.platform.service.z2.a.q3() == false) goto L23;
        ChatControlTrace r1 = ChatControlTrace.b;
        Integer r2 = Integer.valueOf(r12.m);
        BotModel r3 = r12.s;
        String r4 = null;
        if (r3 == null) goto L9;
        Integer r5 = r3.getBotType();
    L10:
        BotModel r6 = r12.s;
        if (r6 == null) goto L16;
        BotCreatorInfo r7 = r6.getBotCreatorInfo();
        if (r7 == null) goto L15;
        r4 = r7.getId();
    L15:
        boolean r8 = Intrinsics.areEqual(r4, AccountService.a.getUserId());
    L17:
        final String r9 = r1.g(r2, r5, r8);
        ItemGroup r10 = r0.T();
        if (r10 == null) goto L20;
        r10.setVisibility(0);
    L20:
        r0.S0().setVisibility(0);
        com.larus.utils.e1.d(r0.S0(), new n2(r12, r9));
        if (r12.B == true) goto L27;
        r12.B = true;
        tx9.i3.b(null, null, null, null, null, "chat", new JSONObject().put("bot_id", r12.S).put("function_type", "chat_search").put("show_method", "default").put("chat_type", r9), r12, 31);
    L27:
        Unit r13 = Unit.INSTANCE;
        return;
    L16:
        r8 = false;
        goto L17
    L9:
        r5 = null;
        goto L10
    L23:
        ItemGroup r14 = r0.T();
        if (r14 == null) goto L26;
        r14.setVisibility(8);
    L26:
        r0.S0().setVisibility(8);
        goto L27
    }

    public static final void xa0(final CommonSettingFragment r2) {
        String r0 = r2.n;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r0 = null;
    L6:
        if (com.larus.utils.o0.d(r0) == true) goto L8;
    L21:
        com.larus.bmhome.setting.c r3 = r2.g;
        if (r3 == null) goto L30;
        ItemGroup r4 = r3.U();
        if (r4 == null) goto L31;
        com.larus.utils.e1.o(r4);
        return;
    L31:
        return;
    L30:
        return;
    L8:
        if (r2.Ua0() == true) goto L21;
        if (Build.VERSION.SDK_INT < 26) goto L21;
        com.larus.bmhome.setting.c r1 = r2.g;
        if (r1 == null) goto L16;
        ItemGroup r5 = r1.U();
        if (r5 == null) goto L16;
        com.larus.utils.e1.x(r5);
    L16:
        com.larus.bmhome.setting.c r6 = r2.g;
        if (r6 == null) goto L27;
        ItemTextView r7 = r6.d();
        if (r7 == null) goto L28;
        com.larus.utils.e1.d(r7, new p3(r2));
        return;
    L28:
        return;
    }

    public static final void ya0(final CommonSettingFragment r3) {
        com.larus.bmhome.setting.c r0 = r3.g;
        if (r3.getView() == null) goto L5;
        LifecycleOwner r1 = r3.getViewLifecycleOwner();
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (r3.A == true) goto L12;
        r3.Ja0().getSubjectBotInfo().observe(r1, new e(new x4(r3)));
        return;
    L12:
        return;
    L5:
        r1 = r3.getActivity();
        goto L6
    }

    public static final void za0(final CommonSettingFragment r3) {
        r3.getClass();
        if (com.larus.platform.service.z2.a.enableSubscription() == false) goto L6;
        com.larus.platform.service.c2.a.e().observe(r3.getViewLifecycleOwner(), new e(new f2(r3)));
        return;
    }

    public final String Ka0(EnterKeyAction r2) {
        if (r2 != EnterKeyAction.NEWLINE) goto L5;
        int r3 = 2131909244;
    L6:
        Context r0 = getContext();
        if (r0 == null) goto L9;
        String r4 = r0.getString(r3);
    L10:
        if (r4 != null) goto L13;
        return "";
    L13:
        return r4;
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = 2131909246;
        goto L6
    }

    public final void N9(String r11) {
        Intrinsics.checkNotNullParameter(r11, "leaveMethod");
        int r2 = 1;
        boolean r3 = false;
        if (this.J == false) goto L13;
        if (Intrinsics.areEqual(r11, "system_back_button") == false) goto L7;
    L8:
        FragmentActivity r12 = getActivity();
        if (r12 == null) goto L97;
        r12.setResult(100, new Intent().putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("previous_page", k())})));
        return;
    L97:
        return;
    L7:
        if (Intrinsics.areEqual(r11, "click_back_button") == true) goto L8;
        return;
    L13:
        if (this.s != null) goto L15;
        return;
    L15:
        FragmentActivity r0 = getActivity();
        String r5 = null;
        if (r0 == null) goto L34;
        Intent r6 = new Intent();
        Pair[] r7 = new Pair[9];
        r7[0] = TuplesKt.to("argPreviousPage", this.u);
        r7[1] = TuplesKt.to("navigate_up_from", "bot_setting");
        r7[2] = TuplesKt.to("conversation_exit", Boolean.TRUE);
        r7[3] = TuplesKt.to("conversationId", this.w);
        BotModel r8 = this.s;
        if (r8 == null) goto L20;
        SpeakerVoice r9 = r8.getVoiceType();
    L21:
        r7[4] = TuplesKt.to("select_speaker_result", r9);
        BotModel r10 = this.s;
        if (r10 == null) goto L24;
        String r13 = r10.getCallerName();
    L25:
        r7[5] = TuplesKt.to("nick_name_update", r13);
        BotModel r14 = this.s;
        if (r14 == null) goto L28;
        ModelItem r15 = r14.getModel();
    L29:
        r7[6] = TuplesKt.to("select_model_result", r15);
        BotModel r16 = this.s;
        if (r16 == null) goto L32;
        boolean r17 = r16.getMuted();
    L33:
        r7[7] = TuplesKt.to("bot_is_mute", Boolean.valueOf(r17));
        r7[8] = TuplesKt.to("leave_method", r11);
        r0.setResult(100, r6.putExtras(com.larus.utils.f.c(r7)));
        goto L34
    L32:
        r17 = false;
        goto L33
    L28:
        r15 = null;
        goto L29
    L24:
        r13 = null;
        goto L25
    L20:
        r9 = null;
    L34:
        JSONObject r1 = new JSONObject();
        com.larus.bmhome.setting.c r4 = this.g;
        if (r4 == null) goto L43;
        ItemTextToggle r18 = r4.k0();
        if (r18 == null) goto L43;
        CustomSwitchCompat r19 = r18.getToggleView();
        if (r19 == null) goto L43;
        if (r19.isChecked() != true) goto L43;
    L44:
        r1.put("notify_push", r2);
        com.larus.bmhome.setting.c r20 = this.g;
        if (r20 == null) goto L51;
        ItemTextArrow r21 = r20.Z0();
        if (r21 == null) goto L51;
        TextView r22 = r21.getSubTextView();
        if (r22 == null) goto L51;
        CharSequence r23 = r22.getText();
    L52:
        r1.put("voice", r23);
        com.larus.bmhome.setting.c r24 = this.g;
        if (r24 == null) goto L59;
        ItemLongTextArrow r25 = r24.b();
        if (r25 == null) goto L59;
        TextView r26 = r25.getTextView();
        if (r26 == null) goto L59;
        CharSequence r27 = r26.getText();
    L60:
        r1.put("bot_status", r27);
        com.larus.bmhome.setting.c r28 = this.g;
        if (r28 == null) goto L67;
        ItemTextArrow r29 = r28.b0();
        if (r29 == null) goto L67;
        TextView r30 = r29.getSubTextView();
        if (r30 == null) goto L67;
        CharSequence r31 = r30.getText();
    L68:
        r1.put("language", r31);
        RecommendFrom r32 = Na0();
        if (r32 == null) goto L71;
        String r33 = r32.b;
    L72:
        r1.put("req_id", r33);
        r1.put("leave_method", r11);
        ChatControlTrace r110 = ChatControlTrace.b;
        Integer r34 = Integer.valueOf(this.m);
        BotModel r35 = this.s;
        if (r35 == null) goto L75;
        Integer r36 = r35.getBotType();
    L76:
        BotModel r37 = this.s;
        if (r37 == null) goto L83;
        BotCreatorInfo r38 = r37.getBotCreatorInfo();
        if (r38 == null) goto L81;
        String r39 = r38.getId();
    L82:
        r3 = Intrinsics.areEqual(r39, AccountService.a.getUserId());
        goto L83
    L81:
        r39 = null;
    L83:
        r1.put("chat_type", r110.g(r34, r36, r3));
        BotModel r111 = this.s;
        if (r111 == null) goto L86;
        r5 = r111.getBotId();
    L86:
        Intrinsics.checkNotNullParameter(r1, "params");
        if (r5 != null) goto L94;
    L92:
        TrackParams r112 = new TrackParams().merge(r1);
        by7.a r40 = new by7.a("leave_botsetting_page");
        r40.b = this;
        r40.a.merge(r112);
        r40.b();
        return;
    L94:
        r1.put("bot_id", r5);     // Catch: JSONException -> L90
    L90:
        e = move-exception;
        FLogger.a.e("LeaveEventHelper", "error in LeaveEventHelper leaveBotsettingPage " + e.getLocalizedMessage());
        goto L92
    L75:
        r36 = null;
        goto L76
    L71:
        r33 = null;
    L67:
        r31 = null;
    L59:
        r27 = null;
    L51:
        r23 = null;
    L43:
        r2 = 0;
        goto L44
    }

    public final String Pa0(final DefaultReplyMenuDataV2 r11) {
        com.larus.bmhome.setting.c r0 = this.g;
        String r1 = null;
        if (r0 == null) goto L95;
        ItemTextMenu r2 = r0.y();
        if (r2 == null) goto L95;
        ReplyOption r3 = Oa0();
        com.larus.bmhome.setting.c r4 = this.g;
        if (r4 == null) goto L95;
        ItemTextMenu r5 = r4.y();
        if (r5 == null) goto L95;
        final ImageView r6 = r5.getMenuArrowView();
        if (r6 == null) goto L95;
        if (r3 == null) goto L17;
        ModelItemIdentity r7 = r3.getModel();
        if (r7 == null) goto L17;
    L18:
        if (r3 == null) goto L21;
        String r8 = r3.getModeId();
        if (r8 == null) goto L21;
    L42:
        DefaultReplyMenuConfigV2 r9 = r11.getMenuConfV2();
        if (r9 == null) goto L47;
        DefaultReplySwitchModeConfig r10 = r9.getModeList();
        if (r10 == null) goto L47;
        List<DefaultReplySwitchMenuMode> r12 = r10.getItemList();
    L48:
        if (r12 != null) goto L50;
        r12 = CollectionsKt.emptyList();
    L50:
        boolean r13 = false;
        if (r8 == null) goto L65;
        Iterator<T> r14 = r12.iterator();
    L54:
        if (r14.hasNext() == false) goto L62;
        Object r15 = r14.next();
        DefaultReplySwitchMenuMode r16 = (DefaultReplySwitchMenuMode) r15;
        if (r16 == null) goto L58;
        String r17 = r16.getModeId();
    L60:
        if (Intrinsics.areEqual(r17, r8) == false) goto L54;
    L63:
        DefaultReplySwitchMenuMode r18 = (DefaultReplySwitchMenuMode) r15;
        if (r18 == null) goto L65;
    L83:
        if (r18 != null) goto L86;
        com.larus.utils.e1.o(r2);
        return null;
    L86:
        String r19 = r18.getSelectedName();
        if (r19 != null) goto L89;
    L90:
        r13 = true;
    L91:
        if (r13 == false) goto L93;
        r1 = r18.getName();
    L94:
        r2.setSubText(r1);
        r2.setOnMenuClickListener(new o0(this, r6, r11));
        com.larus.utils.e1.x(r2);
        goto L95
    L93:
        r1 = r18.getSelectedName();
        goto L94
    L89:
        if (r19.length() != 0) goto L91;
    L58:
        r17 = null;
        goto L60
    L62:
        r15 = null;
    L65:
        Iterator<T> r20 = r12.iterator();
    L67:
        if (r20.hasNext() == false) goto L81;
        Object r21 = r20.next();
        DefaultReplySwitchMenuMode r22 = (DefaultReplySwitchMenuMode) r21;
        if (r22 == null) goto L71;
        String r23 = r22.getModeId();
    L72:
        if (r23 != null) goto L74;
    L77:
        boolean r24 = true;
    L79:
        if ((!r24) == false) goto L67;
    L82:
        r18 = (DefaultReplySwitchMenuMode) r21;
        goto L83
    L74:
        if (r23.length() == 0) goto L77;
        r24 = false;
        goto L79
    L71:
        r23 = null;
        goto L72
    L81:
        r21 = null;
    L47:
        r12 = null;
    L21:
        DefaultReplyMenuConfigV2 r25 = r11.getMenuConfV2();
        if (r25 == null) goto L41;
        DefaultReplySwitchMenuConfig r26 = r25.getModelList();
        if (r26 == null) goto L41;
        List<DefaultReplySwitchMenuItem> r27 = r26.getItemList();
        if (r27 == null) goto L41;
        Iterator<T> r28 = r27.iterator();
    L29:
        if (r28.hasNext() == false) goto L37;
        Object r29 = r28.next();
        DefaultReplySwitchMenuItem r30 = (DefaultReplySwitchMenuItem) r29;
        if (r30 == null) goto L33;
        String r31 = r30.getModelItemKey();
    L35:
        if (Intrinsics.areEqual(r31, r7.getKey()) == false) goto L29;
    L38:
        DefaultReplySwitchMenuItem r32 = (DefaultReplySwitchMenuItem) r29;
        if (r32 == null) goto L41;
        r8 = r32.getDefaultMode();
        goto L42
    L33:
        r31 = null;
        goto L35
    L37:
        r29 = null;
    L41:
        r8 = null;
    L17:
        r7 = Ia0().getDefaultModelItemKey();
    L95:
        return r1;
    }

    public final Unit Sa0(BotModel r10) {
        com.larus.bmhome.setting.c r0 = this.g;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.X().getVisibility() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L36;
        if (r0.b1() == false) goto L30;
        LaunchInfo r3 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r3 == null) goto L27;
        List r4 = r3.s();
        if (r4 == null) goto L27;
        Iterator r5 = r4.iterator();
    L17:
        if (r5.hasNext() == false) goto L21;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(String.valueOf(((CocoSetting) r6).a()), r10.getBotIconMappedAppIcon()) == false) goto L17;
    L22:
        CocoSetting r7 = (CocoSetting) r6;
        if (r7 == null) goto L27;
        String r8 = r7.g();
        if (r8 == null) goto L27;
    L34:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new CommonSettingFragment$iconEditItemLoad$1$1(r8, r0, null), 2, null);
        goto L36
    L21:
        r6 = null;
    L27:
        BotIconImage r11 = r10.getIconImage();
        if (r11 == null) goto L33;
        r8 = r11.getOriginUrl();
    L33:
        r8 = null;
        goto L34
    L30:
        BotIconImage r12 = r10.getIconImage();
        if (r12 == null) goto L33;
        r8 = r12.getOriginUrl();
    L36:
        return Unit.INSTANCE;
    L7:
        r2 = false;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.bmhome.bot.y1] */
    public final void Ya0(String r11) {
        if (isAdded() == true) goto L5;
        return;
    L5:
        final FragmentActivity r2 = getActivity();
        if (r2 != null) goto L8;
        return;
    L8:
        boolean r1 = true;
        if (this.m == 1) goto L11;
    L15:
        r1 = false;
    L16:
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        if (r1 == false) goto L19;
        CustomPhotoViewerDialog r3 = new BotAvatarViewerCanChangeIconDialog(r2, r11, new y1(r0, this, r2));
    L20:
        r0.element = r3;
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L27;
        DialogLancet.handleBlockedDialogShow(r3);
        return;
    L27:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L24:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
        return;
    L19:
        r3 = new BotAvatarViewerDialog(r2, r11, false, true, "bot_setting", null, null);
        goto L20
    L11:
        if (AuthModelDelegate.b.z() == false) goto L15;
        if (com.larus.platform.service.i3.a.i() == true) goto L15;
        goto L15
    }

    public final void bb0(String r8) {
        com.larus.bmhome.setting.c r0 = this.g;
        if (r0 == null) goto L11;
        TextView r1 = r0.r();
        if (r1 == null) goto L12;
        if (r8 == null) goto L8;
        String r9 = StringsKt.replace$default(r8, "\n", "", false, 4, null);
    L9:
        r1.setText(r9);
        return;
    L8:
        r9 = null;
        goto L9
    L12:
        return;
    }

    public final void cb0(List<ShowTagInfo> r4) {
        if (r4 == null) goto L13;
        Iterator<T> r5 = r4.iterator();
    L5:
        if (r5.hasNext() == false) goto L13;
        ShowTagInfo r0 = (ShowTagInfo) r5.next();
        if (com.larus.utils.o0.d(r0.getNameToShow()) == false) goto L5;
        if (r0.getType() == 3) goto L14;
        if (r0.getType() != 2) goto L5;
    L14:
        if (r0 == null) goto L23;
        com.larus.bmhome.setting.c r6 = this.g;
        if (r6 == null) goto L36;
        TagTextView r7 = r6.t();
        if (r7 == null) goto L37;
        com.larus.utils.e1.x(r7);
        String r1 = r0.getNameToShow();
        if (r1 != null) goto L22;
        r1 = "";
    L22:
        r7.x(r1, vb8.a.d(Integer.valueOf(r0.getType())));
        return;
    L37:
        return;
    L36:
        return;
    L23:
        com.larus.bmhome.setting.c r8 = this.g;
        if (r8 == null) goto L39;
        TagTextView r9 = r8.t();
        if (r9 == null) goto L40;
        com.larus.utils.e1.o(r9);
        return;
    L40:
        return;
    L39:
        return;
    L13:
        r0 = null;
        goto L14
    }

    public final Integer db0(uz8.d r3) {
        Context r0 = getContext();
        if (r0 == null) goto L7;
        boolean r1 = v19.h.a;
        boolean r2 = true;
        if (v19.h.b(r0) != true) goto L7;
    L8:
        Object r4 = null;
        if (r2 == false) goto L12;
        if (r3 == null) goto L14;
        String r5 = r3.darkColor;
    L15:
        if (r5 == null) goto L28;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L18
        Object r7 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r5)));     // Catch: Throwable -> L18
    L21:
        if (Result.isFailure-impl(r7) == true) goto L25;
        r4 = r7;
    L25:
        return (Integer) r4;
    L18:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L28:
        return null;
    L14:
        r5 = null;
        goto L15
    L12:
        if (r3 == null) goto L14;
        r5 = r3.lightColor;
    L7:
        r2 = false;
        goto L8
    }

    public final void fb0(TextView r5) {
        if (this.g == null) goto L36;
        BotModel r0 = this.s;
        BotModel r1 = null;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r0 = null;
    L7:
        Integer r2 = r0.getBotType();
        boolean r3 = true;
        if (r2 != null) goto L11;
    L13:
        BotModel r4 = this.s;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L17:
        List r6 = r1.getTagList();
        if (r6 == null) goto L25;
        Iterator r7 = r6.iterator();
    L21:
        if (r7.hasNext() == false) goto L25;
        if (((ShowTagInfo) r7.next()).getType() != 2) goto L21;
    L26:
        if (r3 == false) goto L28;
        ((hq9.a2) this.O.getValue()).getClass();
    L29:
        if (r5 == null) goto L31;
        r5.setVisibility(8);
    L31:
        Unit r8 = Unit.INSTANCE;
        return;
    L28:
        ((hq9.a2) this.O.getValue()).getClass();
    L25:
        r3 = false;
        goto L26
    L16:
        r1 = r4;
        goto L17
    L11:
        if (r2.intValue() != 1) goto L13;
        ((hq9.a2) this.O.getValue()).getClass();
        goto L29
    }

    public final void fillTrackParams(TrackParams r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        com.larus.trace.tracknode.a.a.a(this, r4);
        if (this.J == false) goto L6;
        r4.put("encrypted_status", com.larus.platform.service.z2.a.u2());
        return;
    L6:
        SearchMobParam r0 = this.x;
        String r1 = null;
        if (r0 == null) goto L9;
        String r2 = r0.a;
    L10:
        r4.putIfNull("query", r2);
        SearchMobParam r3 = this.x;
        if (r3 == null) goto L13;
        String r5 = r3.b;
    L14:
        r4.putIfNull("query_id", r5);
        SearchMobParam r6 = this.x;
        if (r6 == null) goto L17;
        String r7 = r6.c;
    L18:
        r4.putIfNull("search_id", r7);
        SearchMobParam r8 = this.x;
        if (r8 == null) goto L21;
        String r9 = r8.d;
    L22:
        r4.putIfNull("search_request_id", r9);
        SearchMobParam r10 = this.x;
        if (r10 == null) goto L25;
        String r11 = r10.e;
    L26:
        r4.putIfNull("search_result_id", r11);
        SearchMobParam r12 = this.x;
        if (r12 == null) goto L29;
        r1 = r12.f;
    L29:
        r4.putIfNull("rank", r1);
        return;
    L25:
        r11 = null;
        goto L26
    L21:
        r9 = null;
        goto L22
    L17:
        r7 = null;
        goto L18
    L13:
        r5 = null;
        goto L14
    L9:
        r2 = null;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r10v2, types: [com.larus.bmhome.bot.share.ShareBotController$performShareBot$1] */
    public final void ob0(boolean r14) {
        String r0 = null;
        if (r14 == false) goto L134;
        com.larus.platform.service.z2 r15 = com.larus.platform.service.z2.a;
        if (r15.x3().getDisableBotShare() == false) goto L17;
        wc9.e r2 = this.q;
        if (r2 == null) goto L9;
        Integer r3 = r2.v;
    L10:
        BotModel r4 = this.s;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r4 = null;
    L14:
        if (nq9.h.a(r3, r4.getBotType()) == false) goto L17;
        return;
    L9:
        r3 = null;
    L17:
        if (an() == false) goto L27;
        BotModel r5 = this.s;
        if (r5 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r5 = null;
    L21:
        Integer r6 = r5.getPrivateStatus();
        if (r6 == null) goto L27;
        if (r6.intValue() != 2) goto L27;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CommonSettingFragment$shareClickActionWhenEnabled$1(this, null), 3, null);
    L27:
        final ShareBotController r7 = (ShareBotController) this.H.getValue();
        final wc9.e r8 = this.q;
        BotModel r9 = this.s;
        if (r9 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        final BotModel r10 = null;
    L31:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r10, "botModel");
        if (r8 != null) goto L34;
    L48:
        wc9.e r16 = this.q;
        boolean r11 = false;
        if (r16 == null) goto L56;
        Integer r17 = r16.v;
        if (r17 == null) goto L56;
        if (r17.intValue() != 3) goto L56;
        boolean r18 = true;
    L58:
        if (r18 == true) goto L107;
        com.larus.audio.p0 r19 = AudioServiceDelegate.a.getAudioConfig();
        BotModel r12 = this.s;
        if (r12 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r12 = null;
    L63:
        if (r19.n(r12) == false) goto L65;
        String r110 = "1";
    L66:
        ChatControlTrace r13 = ChatControlTrace.b;
        JSONObject r20 = r13.Xb(Na0());
        if (Na0() != null) goto L79;
        Bundle r21 = getArguments();
        if (r21 == null) goto L71;
        String r22 = r21.getString("argBotCaseFrom");
    L73:
        if (com.larus.utils.o0.d(r22) == false) goto L79;
        Bundle r23 = getArguments();
        if (r23 == null) goto L77;
        String r24 = r23.getString("argBotCaseFrom");
    L78:
        r20.put("recommend_from", r24);
        goto L79
    L77:
        r24 = null;
        goto L78
    L71:
        r22 = null;
    L79:
        BotModel r25 = this.s;
        if (r25 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r25 = null;
    L82:
        r20.put("bot_id", r25.getBotId());
        BotModel r26 = this.s;
        if (r26 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r26 = null;
    L85:
        r20.put("item_id", r26.getBotId());
        String r1 = this.n;
        if (r1 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r1 = null;
    L88:
        r20.put("conversation_id", r1);
        Integer r27 = Integer.valueOf(this.m);
        BotModel r28 = this.s;
        if (r28 == null) goto L91;
        Integer r29 = r28.getBotType();
    L92:
        BotModel r30 = this.s;
        if (r30 == null) goto L99;
        BotCreatorInfo r31 = r30.getBotCreatorInfo();
        if (r31 == null) goto L97;
        String r32 = r31.getId();
    L98:
        r11 = Intrinsics.areEqual(r32, AccountService.a.getUserId());
        goto L99
    L97:
        r32 = null;
    L99:
        r20.put("chat_type", r13.g(r27, r29, r11));
        r20.put("group_type", "private");
        r20.put("is_immersive_background", ve8.c.b(Ta0()));
        Bundle r33 = getArguments();
        if (r33 == null) goto L102;
        String r34 = r33.getString("create_sub_conv_case_id");
    L103:
        r20.put("user_case_item_id", r34);
        Bundle r35 = getArguments();
        if (r35 == null) goto L106;
        r0 = r35.getString("create_sub_conv_case_request_id");
    L106:
        r20.put("user_case_reco_request_id", r0);
        tx9.c0.B(r20, this, r110, 819199);
        return;
    L102:
        r34 = null;
        goto L103
    L91:
        r29 = null;
        goto L92
    L65:
        r110 = "0";
        goto L66
    L107:
        BotModel r111 = this.s;
        if (r111 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r111 = null;
    L110:
        String r112 = r111.getBotId();
        String r36 = this.n;
        if (r36 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r36 = null;
    L113:
        ChatControlTrace r37 = ChatControlTrace.b;
        Integer r38 = Integer.valueOf(this.m);
        BotModel r39 = this.s;
        if (r39 == null) goto L116;
        Integer r40 = r39.getBotType();
    L117:
        BotModel r41 = this.s;
        if (r41 == null) goto L123;
        BotCreatorInfo r42 = r41.getBotCreatorInfo();
        if (r42 == null) goto L122;
        r0 = r42.getId();
    L122:
        r11 = Intrinsics.areEqual(r0, AccountService.a.getUserId());
    L123:
        String r43 = r37.g(r38, r40, r11);
        String r44 = k();
        String r45 = Ma0();
        JSONObject r46 = new JSONObject();
        Intrinsics.checkNotNullParameter(r46, "params");
        if (r112 != null) goto L146;
    L128:
        if (r36 == null) goto L130;
        r46.put("conversation_id", r36);     // Catch: JSONException -> L126
    L130:
        r46.put("current_page", r44);     // Catch: JSONException -> L126
        r46.put("previous_page", r45);     // Catch: JSONException -> L126
        r46.put("chat_type", r43);     // Catch: JSONException -> L126
    L133:
        TrackParams r113 = new TrackParams().merge(r46);
        by7.a r47 = new by7.a("click_share_new_dialogue");
        r47.a.merge(r113);
        r47.b();
        return;
    L126:
        e = move-exception;
        FLogger.a.e("ClickEventHelper", "error in ClickEventHelper mobClickShareNewDialog " + e.getLocalizedMessage());
        goto L133
    L146:
        r46.put("bot_id", r112);     // Catch: JSONException -> L126
        goto L128
    L116:
        r40 = null;
    L56:
        r18 = false;
        goto L58
    L34:
        if (r7.d == null) goto L48;
        Integer r48 = r8.v;
        if (r48 == null) goto L44;
        if (r48.intValue() != 3) goto L44;
        ShareScene r114 = ShareScene.MESSAGES_LINK_SUB_CONV;
    L47:
        IShareService.a.b(ShareServiceDelegate.b, r7.d, r8, r10, r114, null, r7.b, new ShareBotController$performShareBot$1(r7, r8, r10), 16);
    L44:
        if (r15.getShareConfig().m() == false) goto L46;
        r114 = ShareScene.COMMON_BOT_WITH_SAVE;
        goto L47
    L46:
        r114 = ShareScene.COMMON_BOT;
        goto L47
    L30:
        r10 = r9;
        goto L31
    L134:
        String r115 = this.s;
        if (r115 != null) goto L137;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L138:
        Integer r116 = r0.getBotStatus();
        if (r116 != null) goto L142;
    L144:
        t19.s r117 = t19.s.a;
        Context r49 = getContext();
        String r50 = getString(2131900592);
        r117.getClass();
        t19.s.t(r49, r50);
        return;
    L142:
        if (r116.intValue() != (-20)) goto L144;
        t19.s r118 = t19.s.a;
        Context r51 = getContext();
        String r52 = getString(2131900191);
        r118.getClass();
        t19.s.t(r51, r52);
        return;
    L137:
        r0 = r115;
        goto L138
    }

    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        FLogger r0 = FLogger.a;
        r0.d(this.e, "Router arguments: " + this + ' ' + getArguments());
        boolean r2 = true;
        boolean r3 = false;
        if (this.J == true) goto L15;
        Bundle r1 = getArguments();
        if (r1 == null) goto L7;
        boolean r4 = r1.getBoolean("setting_is_app_page", false);
    L8:
        if (r4 == true) goto L15;
        if (r8 == null) goto L11;
        boolean r9 = r8.getBoolean("is_app_setting");
    L12:
        if (r9 == true) goto L15;
        boolean r10 = false;
    L16:
        this.J = r10;
        SearchMobParam r5 = null;
        String r6 = "";
        if (r10 == false) goto L75;
        AuthModelDelegate r11 = AuthModelDelegate.b;
        wc9.e r7 = (wc9.e) r11.y().getValue();
        if (r7 == null) goto L21;
        String r12 = r7.a;
    L22:
        if (r12 != null) goto L24;
        r12 = "";
    L24:
        this.n = r12;
        if (r12.length() != 0) goto L27;
        boolean r13 = true;
    L28:
        if (r13 == true) goto L30;
    L34:
        boolean r14 = false;
    L35:
        String r15 = this.n;
        if (r15 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r15 = null;
    L39:
        if (r15.length() != 0) goto L41;
        boolean r16 = true;
    L42:
        if (r16 == false) goto L48;
        if (r14 == true) goto L48;
        FragmentActivity r17 = getActivity();
        if (r17 == null) goto L104;
        r17.finish();
        return;
    L104:
        return;
    L48:
        this.m = 1;
        if (r14 == false) goto L66;
        com.larus.bmhome.auth.h0 r18 = r11.v();
        if (r18 != null) goto L53;
    L58:
        if (r5 == null) goto L61;
        r6 = r5;
    L61:
        String r19 = this.e;
        StringBuilder r20 = new StringBuilder("open side bar app settings without main conversation, botIdEmpty=");
        if (r6.length() == 0) goto L65;
        r2 = false;
    L65:
        r20.append(r2);
        r0.i(r19, r20.toString());
    L74:
        this.S = r6;
    L96:
        p2a.i.b.Z();
        FragmentAttachExtKt.b(this, ContainerFilter.CHAT_SETTING);     // Catch: Exception -> L99
        return;
    L99:
        e = move-exception;
        FLogger.a.e(this.e, "attachComponent chatCoreContainer error, " + e.getClass().getSimpleName() + ", " + e.getMessage());
        com.larus.platform.service.g.a.ensureNotReachHere(e, "attachComponent chatCoreContainer error");
        return;
    L53:
        if (Intrinsics.areEqual(r18.h(), AccountService.a.getSecUserId()) == true) goto L56;
        r18 = null;
    L56:
        if (r18 == null) goto L58;
        r5 = r18.b();
        goto L58
    L66:
        com.larus.bmhome.chat.api.e0 r21 = (com.larus.bmhome.chat.api.e0) r11.e().getValue();
        if (r21 == null) goto L71;
        LaunchInfo r22 = r21.a;
        if (r22 == null) goto L71;
        r5 = r22.W();
    L71:
        if (r5 == null) goto L74;
        r6 = r5;
        goto L74
    L41:
        r16 = false;
        goto L42
    L30:
        if (Va0() == false) goto L34;
        if (com.larus.platform.exp.o.a() == false) goto L34;
        r14 = true;
        goto L35
    L27:
        r13 = false;
        goto L28
    L21:
        r12 = null;
        goto L22
    L75:
        Bundle r23 = getArguments();
        if (r23 == null) goto L79;
        String r24 = r23.getString("setting_conversation_id", "");
        if (r24 == null) goto L79;
    L80:
        this.n = r24;
        Bundle r25 = getArguments();
        int r26 = 2;
        if (r25 == null) goto L83;
        r26 = r25.getInt("setting_bot_cvs_type", 2);
    L83:
        this.m = r26;
        Bundle r27 = getArguments();
        if (r27 == null) goto L86;
        r5 = r27.getParcelable("argSearchMobParam");
    L86:
        this.x = r5;
        Bundle r28 = getArguments();
        if (r28 == null) goto L89;
        r3 = r28.getBoolean("setting_is_immersive_bot", false);
    L89:
        this.z = r3;
        Bundle r29 = getArguments();
        if (r29 == null) goto L95;
        String r30 = r29.getString("setting_bot_id", "");
        if (r30 == null) goto L95;
        r6 = r30;
    L95:
        this.S = r6;
    L79:
        r24 = "";
        goto L80
    L11:
        r9 = false;
        goto L12
    L7:
        r4 = false;
    L15:
        r10 = true;
        goto L16
    }

    @Override // com.larus.bmhome.y
    public final void onResult(Bundle r77) {
        Intrinsics.checkNotNullParameter(r77, "bundle");
        if (this.s == null) goto L28;
        BotModel r2 = r77.getSerializable("select_language_result");
        if ((r2 instanceof BotModel) == false) goto L8;
        BotModel r3 = r2;
    L9:
        if (r3 == null) goto L28;
        if (this.s != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L14:
        BotModel r5 = this.s;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        BotModel r6 = null;
    L18:
        rb0(BotModel.copy$default(r6, null, r3.getName(), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, r3.getVoiceType(), null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -131075, Integer.MAX_VALUE, null));
        BotSettingViewModel r4 = Ja0();
        String r7 = this.n;
        if (r7 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r7 = null;
    L21:
        r4.requireUpdateConversationInfo(r7);
        BotSettingViewModel r8 = Ja0();
        BotModel r9 = this.s;
        if (r9 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r9 = null;
    L24:
        r8.updateAsrLanguage(r9, this.m);
        ub0();
        if (AppHost.a.isOversea() == false) goto L28;
        mb0();
        goto L28
    L17:
        r6 = r5;
        goto L18
    L8:
        r3 = null;
    L28:
        if (this.s == null) goto L44;
        ModelItem r10 = r77.getSerializable("select_model_result");
        if ((r10 instanceof ModelItem) == false) goto L33;
        ModelItem r11 = r10;
    L34:
        if (r11 == null) goto L44;
        if (this.s != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L39:
        BotModel r12 = this.s;
        if (r12 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r12 = null;
    L42:
        rb0(BotModel.copy$default(r12, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, r11, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -65537, Integer.MAX_VALUE, null));
        wb0();
        yb0();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CommonSettingFragment$setupSelectModelResult$1(this, r11, null), 3, null);
        goto L44
    L33:
        r11 = null;
    L44:
        if (this.s == null) goto L115;
        Serializable r13 = r77.getSerializable("bot_update_result");
        if ((r13 instanceof BotModel) == false) goto L49;
        final BotModel r14 = (BotModel) r13;
    L50:
        if (r14 == null) goto L115;
        if (this.s != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L55:
        rb0(r14);
        yb0();
        ub0();
        wb0();
        xb0(null);
        BotModel r15 = this.s;
        if (r15 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r15 = null;
    L58:
        qb0(r15.getPrivateStatus());
        if (AppHost.a.isOversea() == false) goto L61;
        mb0();
    L61:
        com.larus.bmhome.setting.c r16 = this.g;
        if (r16 == null) goto L66;
        ItemGroup r17 = r16.S();
        if (r17 == null) goto L66;
        r17.setVisibility(8);
    L66:
        com.larus.bmhome.setting.c r18 = this.g;
        if (r18 == null) goto L115;
        if (Ca0() == true) goto L71;
    L89:
        RoundAvatarImageView r19 = r18.k();
        if (r19 == null) goto L92;
        com.larus.utils.e1.x(r19);
    L92:
        View r20 = r18.l();
        if (r20 == null) goto L95;
        com.larus.utils.e1.o(r20);
    L95:
        RoundAvatarImageView r21 = r18.k();
        if (r21 == null) goto L104;
        BotIconImage r22 = r14.getIconImage();
        if (r22 == null) goto L100;
        String r23 = r22.getOriginUrl();
    L101:
        if (r23 != null) goto L103;
        r23 = "";
    L103:
        ImageLoaderKt.v(r21, r23, "bot_setting.avatar_upload", null, new u1());
        goto L104
    L100:
        r23 = null;
    L104:
        BotModel r24 = this.s;
        if (r24 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r24 = null;
    L107:
        bb0(r24.getName());
        BotModel r25 = this.s;
        if (r25 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r25 = null;
    L110:
        cb0(r25.getTagList());
        RoundAvatarImageView r26 = r18.k();
        if (r26 == null) goto L113;
        com.larus.utils.e1.d(r26, new v1(this, r14));
    L113:
        Sa0(r14);
        goto L115
    L71:
        if (r14.getBgImgOpen() == false) goto L89;
        if (com.larus.utils.o0.d(r14.getBgImgUrl()) == false) goto L89;
        RoundAvatarImageView r27 = r18.k();
        if (r27 == null) goto L77;
        com.larus.utils.e1.o(r27);
    L77:
        View r28 = r18.l();
        if (r28 == null) goto L80;
        com.larus.utils.e1.x(r28);
    L80:
        SimpleDraweeView r29 = r18.l();
        if ((r29 instanceof SimpleDraweeView) == false) goto L83;
        SimpleDraweeView r30 = r29;
    L84:
        if (r30 == null) goto L86;
        ImageLoaderKt.u(r30, r14.getBgImgUrl(), "chat_setting_update_avatar");
    L86:
        View r31 = r18.l();
        if (r31 == null) goto L113;
        com.larus.utils.e1.d(r31, new t1(this, r14));
        goto L113
    L83:
        r30 = null;
        goto L84
    L49:
        r14 = null;
    L115:
        if (this.s != null) goto L118;
        return;
    L118:
        if (com.larus.platform.service.z2.a.o3().a == false) goto L140;
        w2a.f r1 = w2a.h.a(r77);
        if (r1 == null) goto L165;
        BotModel r32 = this.s;
        if (r32 != null) goto L124;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r32 = null;
    L124:
        if (r32 == null) goto L128;
        SpeakerVoice r33 = r32.getVoiceType();
        if (r33 == null) goto L128;
        String r34 = r33.getId();
    L129:
        com.larus.bmhome.setting.c r35 = this.g;
        if (r35 == null) goto L134;
        ItemTextArrow r36 = r35.Z0();
        if (r36 == null) goto L134;
        r36.Y5();
    L134:
        com.larus.bmhome.setting.c r37 = this.g;
        if (r37 == null) goto L139;
        ItemTextArrow r38 = r37.Z0();
        if (r38 == null) goto L139;
        r38.c6();
    L139:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CommonSettingFragment$setupSelectSpeakerResult$1$1(r1, this, r34, null), 3, null);
        return;
    L128:
        r34 = null;
        goto L129
    L165:
        return;
    L140:
        SpeakerVoice r39 = r77.getSerializable("select_speaker_result");
        if ((r39 instanceof SpeakerVoice) == false) goto L143;
        SpeakerVoice r210 = r39;
    L144:
        if (r210 != null) goto L146;
        return;
    L146:
        if (Intrinsics.areEqual(r210.getId(), "none") == false) goto L156;
        if (this.s != null) goto L150;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L150:
        BotModel r40 = this.s;
        if (r40 != null) goto L153;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        BotModel r41 = null;
    L154:
        rb0(BotModel.copy$default(r41, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, r210, null, true, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -655361, Integer.MAX_VALUE, null));
    L163:
        xb0(null);
        return;
    L153:
        r41 = r40;
        goto L154
    L156:
        if (this.s != null) goto L158;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L158:
        BotModel r42 = this.s;
        if (r42 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        BotModel r43 = null;
    L162:
        rb0(BotModel.copy$default(r43, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, r210, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -655361, Integer.MAX_VALUE, null));
        goto L163
    L161:
        r43 = r42;
        goto L162
    L143:
        r210 = null;
        goto L144
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super/*androidx.fragment.app.Fragment*/.onSaveInstanceState(r3);
        r3.putBoolean("is_app_setting", this.J);
    }

    public final void qb0(Integer r4) {
        com.larus.bmhome.setting.c r0 = this.g;
        if (r0 == null) goto L38;
        if (r4 != null) goto L7;
    L14:
        if (r4 != null) goto L17;
    L24:
        if (r4 != null) goto L27;
    L34:
        ItemLongTextArrow r5 = r0.b();
        if (r5 == null) goto L45;
        r5.setVisibility(8);
        Unit r6 = Unit.INSTANCE;
        return;
    L45:
        return;
    L27:
        if (r4.intValue() != 2) goto L34;
        ItemLongTextArrow r7 = r0.b();
        if (r7 == null) goto L31;
        r7.setImageSrc(2131240934);
    L31:
        ItemLongTextArrow r8 = r0.b();
        if (r8 == null) goto L43;
        r8.setText(getString(2131908270));
        Unit r9 = Unit.INSTANCE;
        return;
    L43:
        return;
    L17:
        if (r4.intValue() != 3) goto L24;
        ItemLongTextArrow r10 = r0.b();
        if (r10 == null) goto L21;
        r10.setImageSrc(2131240936);
    L21:
        ItemLongTextArrow r11 = r0.b();
        if (r11 == null) goto L41;
        r11.setText(getString(2131910873));
        Unit r12 = Unit.INSTANCE;
        return;
    L41:
        return;
    L7:
        if (r4.intValue() != 1) goto L14;
        ItemLongTextArrow r13 = r0.b();
        if (r13 == null) goto L11;
        r13.setImageSrc(2131240935);
    L11:
        ItemLongTextArrow r14 = r0.b();
        if (r14 == null) goto L39;
        r14.setText(getString(2131908271));
        Unit r15 = Unit.INSTANCE;
        return;
    L39:
        return;
    }

    public final void rb0(BotModel r7) {
        this.s = r7;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CommonSettingFragment$updateBotInfo$1(r7, this, null), 3, null);
    }

    public final void vb0(uz8.f r11) {
        com.larus.bmhome.setting.c r0 = this.g;
        if (r0 == null) goto L157;
        boolean r1 = false;
        if (r11 == null) goto L11;
        uz8.h r3 = r11.settingsUpgradePage;
        if (r3 == null) goto L11;
        if (r3.isEnabled != true) goto L11;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L16;
        if (r11 == null) goto L18;
        final uz8.h r5 = r11.settingsUpgradePage;
    L19:
        FLogger r6 = FLogger.a;
        String r7 = this.e;
        StringBuilder r8 = new StringBuilder("updateMembershipEntry membership isEnabled: ");
        if (r5 == null) goto L22;
        Boolean r9 = Boolean.valueOf(r5.isEnabled);
    L23:
        r8.append(r9);
        r6.i(r7, r8.toString());
        if (r5 != null) goto L26;
    L28:
        boolean r10 = false;
    L29:
        String r12 = "";
        if (r10 == false) goto L61;
        final ItemTextArrow r13 = r0.g0();
        if (r13 == null) goto L64;
        String r14 = r5.title;
        if (r14 != null) goto L36;
        r14 = "";
    L36:
        r13.setText(r14);
        String r15 = r5.subTitle;
        if (r15 != null) goto L39;
        r15 = "";
    L39:
        r13.Z5(r15, db0(r5.subTitleColor));
        String r16 = r5.iconName;
        if (r16 != null) goto L42;
    L57:
        int r17 = 2131242043;
    L58:
        r13.setImageSrc(r17);
        com.larus.utils.e1.d(r13, new t0(r13, r5));
        ItemTextArrow r18 = r0.g0();
        if (r18 == null) goto L64;
        com.larus.utils.e1.x(r18);
        goto L64
    L42:
        switch(r16.hashCode()) {
            case -969653906: goto L54;
            case -969499785: goto L52;
            case 10281071: goto L49;
            case 579544016: goto L45;
            default: goto L57;
        };
    L52:
        r16.equals("icon_setting_membership_gray");
        goto L57
    L45:
        if (r16.equals("icon_setting_membership_purple") == false) goto L57;
        r17 = 2131242046;
        goto L58
    L49:
        if (r16.equals("icon_setting_membership_green") == false) goto L57;
        r17 = 2131242044;
        goto L58
    L54:
        if (r16.equals("icon_setting_membership_blue") == false) goto L57;
        r17 = 2131242042;
    L64:
        if (r11 == null) goto L66;
        final uz8.h r19 = r11.settingsManagementPage;
    L67:
        String r20 = this.e;
        StringBuilder r21 = new StringBuilder("updateMembershipEntry management isEnabled: ");
        if (r19 == null) goto L70;
        Boolean r22 = Boolean.valueOf(r19.isEnabled);
    L71:
        r21.append(r22);
        r6.i(r20, r21.toString());
        if (r19 != null) goto L74;
    L76:
        boolean r23 = false;
    L77:
        if (r23 == false) goto L90;
        final ItemTextArrow r24 = r0.f0();
        if (r24 == null) goto L93;
        String r25 = r19.title;
        if (r25 != null) goto L83;
        r25 = "";
    L83:
        r24.setText(r25);
        String r26 = r19.subTitle;
        if (r26 == null) goto L87;
        r12 = r26;
    L87:
        r24.Z5(r12, db0(r19.subTitleColor));
        com.larus.utils.e1.d(r24, new u0(r24, r19));
        ItemTextArrow r110 = r0.f0();
        if (r110 == null) goto L93;
        com.larus.utils.e1.x(r110);
    L93:
        ItemTextArrow r111 = r0.g0();
        if (r111 != null) goto L96;
    L101:
        boolean r112 = false;
    L102:
        if (r112 == true) goto L117;
        ItemTextArrow r113 = r0.f0();
        if (r113 != null) goto L106;
    L111:
        boolean r114 = false;
    L112:
        if (r114 == true) goto L117;
        ItemGroup r115 = r0.s0();
        if (r115 == null) goto L120;
        com.larus.utils.e1.o(r115);
    L120:
        ab0();
        if (isVisible() == false) goto L139;
        ItemTextArrow r116 = r0.g0();
        if (r116 != null) goto L125;
    L130:
        boolean r117 = false;
    L131:
        if (r117 == false) goto L139;
        if (r5 == null) goto L134;
        String r118 = r5.clickUrl;
    L136:
        if (this.g1 == true) goto L139;
        Wa0(r118, "setting", null);
        this.g1 = true;
        goto L139
    L134:
        r118 = null;
        goto L136
    L125:
        if (r116.getVisibility() != 0) goto L127;
        boolean r119 = true;
    L128:
        if (r119 != true) goto L130;
        r117 = true;
        goto L131
    L127:
        r119 = false;
    L139:
        if (isVisible() == false) goto L155;
        ItemTextArrow r120 = r0.f0();
        if (r120 != null) goto L143;
    L148:
        if (r1 == false) goto L155;
        if (this.h1 == true) goto L155;
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r121 = ICommerceMembershipService.a.a();
        if (r121 == null) goto L154;
        r121.r();
    L154:
        this.h1 = true;
        goto L155
    L143:
        if (r120.getVisibility() != 0) goto L145;
        boolean r122 = true;
    L146:
        if (r122 != true) goto L148;
        r1 = true;
        goto L148
    L145:
        r122 = false;
    L155:
        Unit r123 = Unit.INSTANCE;
        return;
    L106:
        if (r113.getVisibility() != 0) goto L108;
        boolean r124 = true;
    L109:
        if (r124 != true) goto L111;
        r114 = true;
        goto L112
    L108:
        r124 = false;
    L117:
        ItemGroup r125 = r0.s0();
        if (r125 == null) goto L120;
        com.larus.utils.e1.x(r125);
        goto L120
    L96:
        if (r111.getVisibility() != 0) goto L98;
        boolean r126 = true;
    L99:
        if (r126 != true) goto L101;
        r112 = true;
        goto L102
    L98:
        r126 = false;
        goto L99
    L90:
        ItemTextArrow r127 = r0.f0();
        if (r127 == null) goto L93;
        com.larus.utils.e1.o(r127);
        goto L93
    L74:
        if (r19.isEnabled != true) goto L76;
        r23 = true;
        goto L77
    L70:
        r22 = null;
        goto L71
    L66:
        r19 = null;
        goto L67
    L61:
        ItemTextArrow r27 = r0.g0();
        if (r27 == null) goto L64;
        com.larus.utils.e1.o(r27);
        goto L64
    L26:
        if (r5.isEnabled != true) goto L28;
        r10 = true;
        goto L29
    L22:
        r9 = null;
    L18:
        r5 = null;
        goto L19
    L16:
        if (r11 == null) goto L18;
        r5 = r11.settingsPage;
    L11:
        r4 = false;
        goto L13
    }

    public final void xb0(SpeakerVoice r10) {
        if (this.Y == true) goto L5;
        return;
    L5:
        BotModel r1 = null;
        if (r10 != null) goto L11;
        BotModel r11 = this.s;
        if (r11 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r11 = null;
    L10:
        r10 = r11.getVoiceType();
    L11:
        com.larus.audio.w0 r2 = p2a.s.b.F0();
        EditPos r3 = this.t;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
        r3 = null;
    L14:
        r2.a(this, r10, r3);
        com.larus.bmhome.setting.c r4 = this.g;
        if (r4 == null) goto L54;
        int r5 = xb8.a.a;
        Context r6 = getContext();
        ItemTextArrow r7 = r4.Z0();
        BotModel r8 = this.s;
        if (r8 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r8 = null;
    L19:
        boolean r9 = r8.getMuted();
        EditPos r12 = this.t;
        if (r12 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
        EditPos r13 = null;
    L23:
        xb8.a.b(r6, r7, r10, r9, r13, false);
        boolean r14 = false;
        if (r10 != null) goto L26;
    L28:
        boolean r15 = false;
    L29:
        if (r15 == true) goto L55;
        if (r10 != null) goto L32;
    L34:
        boolean r16 = false;
    L35:
        if (r16 == true) goto L56;
        if (r10 != null) goto L38;
    L40:
        if (r14 == true) goto L57;
        BotModel r17 = this.s;
        if (r17 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r17 = null;
    L45:
        if (r17.getMuted() == false) goto L58;
        BotModel r18 = this.s;
        if (r18 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L50:
        SpeakerVoice r19 = r1.getVoiceType();
        if (r19 == null) goto L59;
        r19.setId("0");
        return;
    L59:
        return;
    L49:
        r1 = r18;
        goto L50
    L58:
        return;
    L57:
        return;
    L38:
        if (r10.getStatus() != 3) goto L40;
        r14 = true;
        goto L40
    L56:
        return;
    L32:
        if (r10.getStatus() != 4) goto L34;
        r16 = true;
        goto L35
    L55:
        return;
    L26:
        if (r10.getConfStatus() != 2) goto L28;
        r15 = true;
        goto L29
    L22:
        r13 = r12;
        goto L23
    }

    public static final void Aa0(final CommonSettingFragment r9, ItemTextArrow r10) {
        Job r0 = r9.X;
        BotModel r2 = null;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        final IAudioSettingRuntimeProvider r1 = (IAudioSettingRuntimeProvider) ServiceManager.get().getService(IAudioSettingRuntimeProvider.class, false, false);
        if (r1 != null) goto L8;
        r9.Y = true;
        r9.nb0();
    L13:
        if (r9.g != null) goto L15;
        return;
    L15:
        if (com.larus.platform.service.z2.a.m3() == true) goto L17;
        com.larus.utils.e1.o(r10);
        return;
    L17:
        com.larus.utils.e1.x(r10);
        r9.xb0(null);
        if (r9.Y == false) goto L26;
        BotModel r3 = r9.s;
        if (r3 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L24:
        if (r2.getMuted() == true) goto L26;
        r9.Za0();
        goto L26
    L22:
        r2 = r3;
    L26:
        r10.setImageSrc(2131242860);
        r10.setOnClickListener(new r4(r1, r9));
        return;
    L8:
        boolean r4 = ((Boolean) r1.a().getValue()).booleanValue();
        r9.Y = r4;
        if (r4 == false) goto L11;
        r9.nb0();
    L11:
        r9.X = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r9.getViewLifecycleOwner()), null, null, new CommonSettingFragment$observeSaasAudioReady$1(r1, r9, null), 3, null);
        goto L13
    }

    public static void U90(CommonDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, null, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, null);
    }

    public final void gb0(final boolean r3, final String r4) {
        IFlowSettingThemeConfigProvider r0 = (IFlowSettingThemeConfigProvider) ServiceManager.get().getService(IFlowSettingThemeConfigProvider.class);
        if (r0 == null) goto L6;
        r0.a(new j1(this, r4, r3), new k1(this), AdaptThemeFeatureKey.SETTING_ITEM_DORA_BUSINESS_LOGIC);
        return;
    }

    /* JADX WARN: Type inference failed for: r7v17, types: [com.larus.bmhome.bot.m4] */
    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r13, r14);
        this.p0 = true;
        AppHost.Companion r0 = AppHost.a;
        r0.a().j(this.b1);
        com.larus.bmhome.setting.c r1 = this.g;
        if (r1 == null) goto L19;
        NovaTitleBarEx r10 = r1.Y0();
        if (Va0() == true) goto L7;
    L17:
        NovaTitleBarEx.b6(r10, v19.c.b(2130971749, r10.getContext(), 2131241477), false, null, getString(2131898805), new d4(this), 6);
    L18:
        Unit r2 = Unit.INSTANCE;
        goto L19
    L7:
        if (this.J == false) goto L17;
        ViewGroup.LayoutParams r3 = r10.getLayoutParams();
        if (r3 == null) goto L16;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        com.larus.utils.i0.a.getClass();
        r4.topMargin = com.larus.utils.i0.g();
        r10.setLayoutParams(r4);
        NovaTitleBarEx.b6(r10, v19.c.b(2130971852, r10.getContext(), 2131242079), false, null, null, new b4(this), 14);
        View r5 = r1.P0();
        Context r6 = r10.getContext();
        if ((r6 instanceof FragmentActivity) == false) goto L13;
        FragmentActivity r7 = (FragmentActivity) r6;
    L14:
        int r8 = com.larus.utils.u.b(r7);
        int r9 = r5.getPaddingStart();
        int r11 = r5.getPaddingTop();
        int r12 = r5.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r5.getClass().getSimpleName() + ",source:,start:" + r9 + ",top:" + r11 + ",end:" + r12 + ",bottom:" + r8);
        r5.setPaddingRelative(r9, r11, r12, r8);
        goto L18
    L13:
        r7 = null;
        goto L14
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        Ia0().getUserConfigsUpdatedLiveData().observe(getViewLifecycleOwner(), new e(new z2(this)));
        Ia0().updateUserConfigs();
        Ia0().getAnswerWithSuggestLiveData().observe(getViewLifecycleOwner(), new e(new a3(this)));
        Ia0().getAnswerWithVideoLiveData().observe(getViewLifecycleOwner(), new e(new b3(this)));
        Ia0().getHighlightEngineEnableLiveData().observe(getViewLifecycleOwner(), new e(new c3(this)));
        Ia0().getRelatedVideoEnableLiveData().observe(getViewLifecycleOwner(), new e(new d3(this)));
        FeatureKitDelegate r15 = FeatureKitDelegate.b;
        if (r15.T().b() == false) goto L23;
        Ia0().getDefaultActiveModeLiveData().observe(getViewLifecycleOwner(), new e(new e3(this)));
    L23:
        if (r15.W().b() == true) goto L25;
        Ia0().getDefaultReplyModeLiveData().observe(getViewLifecycleOwner(), new e(new f3(this)));
    L25:
        com.larus.bmhome.setting.c r16 = this.g;
        if (r16 == null) goto L30;
        final ItemTextArrow r17 = r16.J();
        if (r17 == null) goto L30;
        com.larus.utils.e1.x(r17);
        com.larus.utils.e1.d(r17, new h2(this, r17));
    L30:
        AccountService r18 = AccountService.a;
        if (r18.isLogin().booleanValue() == true) goto L33;
    L45:
        com.larus.bmhome.setting.c r19 = this.g;
        if (r19 == null) goto L50;
        ItemTextArrow r20 = r19.I();
        if (r20 == null) goto L50;
        com.larus.utils.e1.o(r20);
    L50:
        ib0();
        boolean r21 = false;
        if (r18.isLogin().booleanValue() == true) goto L53;
    L65:
        com.larus.bmhome.setting.c r22 = this.g;
        if (r22 == null) goto L70;
        ItemTextArrow r23 = r22.a();
        if (r23 == null) goto L70;
        com.larus.utils.e1.o(r23);
    L70:
        com.larus.bmhome.setting.c r24 = this.g;
        if (r24 == null) goto L92;
        ItemTextArrow r25 = r24.D();
        if (r25 == null) goto L92;
        if (r0.isOversea() == false) goto L77;
    L91:
        r25.setVisibility(8);
        goto L92
    L77:
        if (com.larus.platform.service.z2.a.enableOfficialWebsite() == false) goto L91;
        r25.setVisibility(0);
        String r26 = this.H0.q.e;
        if (r26 != null) goto L82;
    L89:
        String r27 = getString(2131909289);
    L90:
        r25.setText(r27);
        com.larus.utils.e1.d(r25, new l4());
        goto L92
    L82:
        if (Boolean.valueOf(!StringsKt.isBlank(r26)).booleanValue() == true) goto L85;
        r26 = null;
    L85:
        if (r26 == null) goto L89;
        r27 = r26 + getString(2131906794);
        if (r27 == null) goto L89;
    L92:
        com.larus.bmhome.setting.c r28 = this.g;
        if (r28 == null) goto L100;
        ItemTextArrow r29 = r28.v();
        if (r29 == null) goto L100;
        if (r18.isLogin().booleanValue() == true) goto L99;
        r29.setVisibility(8);
        goto L100
    L99:
        com.larus.utils.e1.d(r29, new o2(this));
    L100:
        com.larus.bmhome.setting.c r30 = this.g;
        if (r30 == null) goto L115;
        ItemTextMenu r31 = r30.a0();
        if (r31 == null) goto L115;
        if (com.larus.platform.service.z2.a.enableEnterKeyBehaviorSetting() == false) goto L107;
        int r32 = 0;
    L108:
        r31.setVisibility(r32);
        if (r31.getVisibility() != 0) goto L111;
        boolean r33 = true;
    L112:
        if (r33 == false) goto L115;
        r31.setSubText(Ka0(EnterKeyBehaviorHostDelegate.b.a()));
        r31.setOnMenuClickListener(new k3(this));
        goto L115
    L111:
        r33 = false;
        goto L112
    L107:
        r32 = 8;
    L115:
        lb0();
        com.larus.bmhome.setting.c r34 = this.g;
        if (r34 == null) goto L139;
        ItemTextArrow r35 = r34.z0();
        if (r35 == null) goto L139;
        if (com.larus.platform.service.p1.a.n() == true) goto L122;
    L128:
        boolean r36 = false;
    L129:
        if (r36 == false) goto L131;
        int r37 = 0;
    L132:
        r35.setVisibility(r37);
        if (r35.getVisibility() != 0) goto L135;
        boolean r38 = true;
    L136:
        if (r38 == false) goto L139;
        r35.setOnClickListener(new z3(this));
        goto L139
    L135:
        r38 = false;
        goto L136
    L131:
        r37 = 8;
        goto L132
    L122:
        if (r18.isLogin().booleanValue() == false) goto L128;
        if (r0.isOversea() == true) goto L128;
        if (com.larus.platform.service.x1.a.a() == true) goto L128;
        r36 = true;
    L139:
        com.larus.bmhome.setting.c r39 = this.g;
        if (r39 == null) goto L153;
        final ItemTextArrow r40 = r39.x();
        if (r40 == null) goto L153;
        if (r0.isOversea() == false) goto L146;
    L152:
        com.larus.utils.e1.o(r40);
        goto L153
    L146:
        if (r18.isLogin().booleanValue() == false) goto L152;
        com.larus.platform.service.z2 r41 = com.larus.platform.service.z2.a;
        if (r41.n2() == false) goto L150;
    L151:
        int r42 = com.larus.utils.j0.a;
        r40.setText(com.larus.utils.j0.e("aiCreation_uploadPermission_settings_outputs"));
        com.larus.utils.e1.d(r40, new m3(this, r40));
        com.larus.utils.e1.x(r40);
        goto L153
    L150:
        if (Intrinsics.areEqual(r41.watermarkRemovalConfig().a(), Boolean.TRUE) == false) goto L152;
    L153:
        com.larus.bmhome.setting.c r43 = this.g;
        if (r43 == null) goto L163;
        final ItemTextArrow r44 = r43.X0();
        if (r44 == null) goto L163;
        if (r18.isLogin().booleanValue() == true) goto L160;
    L162:
        com.larus.utils.e1.o(r44);
        goto L163
    L160:
        if (r15.c0().b() == false) goto L162;
        com.larus.utils.e1.x(r44);
        com.larus.utils.e1.d(r44, new a4(r44, this));
    L163:
        com.larus.bmhome.setting.c r45 = this.g;
        if (r45 == null) goto L189;
        ItemTextView r46 = r45.B();
        if (r46 == null) goto L189;
        com.larus.bmhome.chat.api.e0 r47 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r47 == null) goto L172;
        LaunchInfo r48 = r47.a;
        if (r48 == null) goto L172;
        final String r49 = r48.c0();
    L174:
        if (r18.isLogin().booleanValue() == false) goto L188;
        if (r49 != null) goto L177;
    L180:
        boolean r50 = true;
    L181:
        if (r50 == true) goto L188;
        if (r0.isOversea() == false) goto L188;
        if (com.larus.platform.service.x1.a.a() == true) goto L188;
        r46.setVisibility(0);
        r46.setOnClickListener(new y(r49, this));
        goto L189
    L177:
        if (StringsKt.isBlank(r49) == true) goto L180;
        r50 = false;
    L188:
        r46.setVisibility(8);
    L172:
        r49 = null;
    L189:
        com.larus.platform.service.z2 r51 = com.larus.platform.service.z2.a;
        if (r51.q().l == true) goto L196;
        com.larus.bmhome.setting.c r52 = this.g;
        if (r52 == null) goto L206;
        ItemTextView r53 = r52.d0();
        if (r53 == null) goto L206;
        com.larus.utils.e1.o(r53);
    L206:
        com.larus.bmhome.setting.c r54 = this.g;
        if (r54 == null) goto L211;
        View r55 = r54.P0();
        if (r55 == null) goto L211;
        View r56 = r55.findViewById(2131366939);
    L213:
        if (this.J == false) goto L215;
        com.larus.platform.service.u.a.c(this, r56, k(), this);
    L218:
        if (r51.q().m == true) goto L224;
        com.larus.bmhome.setting.c r57 = this.g;
        if (r57 == null) goto L246;
        ItemTextArrow r58 = r57.B0();
        if (r58 == null) goto L246;
        com.larus.utils.e1.o(r58);
    L246:
        final com.larus.bmhome.a0 r59 = com.larus.bmhome.b0.a(this);
        final FragmentActivity r60 = getActivity();
        if (r59 != null) goto L279;
        String r61 = com.larus.platform.service.w0.b();
        gd9.i r62 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r62);
        Iterator r63 = CollectionsKt.asReversed(r62.a().d()).iterator();
    L250:
        if (r63.hasNext() == false) goto L261;
        Object r64 = r63.next();
        Activity r65 = (Activity) r64;
        if (r65.isFinishing() == false) goto L254;
    L258:
        boolean r66 = false;
    L259:
        if (r66 == false) goto L250;
    L262:
        FragmentActivity r67 = (Activity) r64;
        if ((r67 instanceof FragmentActivity) == false) goto L265;
        FragmentActivity r68 = r67;
    L266:
        if (r68 == null) goto L278;
        FragmentManager r69 = r68.getSupportFragmentManager();
        if (r69 == null) goto L278;
        List r70 = r69.getFragments();
        if (r70 == null) goto L278;
        ArrayList r71 = new ArrayList();
        Iterator r72 = r70.iterator();
    L273:
        if (r72.hasNext() == false) goto L277;
        Object r73 = r72.next();
        if ((r73 instanceof com.larus.bmhome.a0) == false) goto L273;
        r71.add(r73);
        goto L273
    L277:
        final com.larus.bmhome.a0 r74 = (com.larus.bmhome.a0) CollectionsKt.firstOrNull(r71);
    L280:
        if (r74 != null) goto L282;
    L284:
        boolean r75 = false;
    L285:
        if (r75 == false) goto L296;
        com.larus.bmhome.setting.c r76 = this.g;
        if (r76 == null) goto L291;
        ItemTextArrow r77 = r76.h();
        if (r77 == null) goto L291;
        com.larus.utils.e1.d(r77, new j4(r74, this, r59, r60));
    L291:
        com.larus.bmhome.setting.c r78 = this.g;
        if (r78 == null) goto L301;
        ItemGroup r79 = r78.g();
        if (r79 == null) goto L301;
        com.larus.utils.e1.x(r79);
    L301:
        com.larus.bmhome.a0.z1.getClass();
        boolean r80 = com.larus.bmhome.a0.a.b;
        com.larus.platform.service.z2 r81 = com.larus.platform.service.z2.a;
        boolean r82 = r81.getECommerceSettingsConfig().getEnableOrderMessageNotificationSettings();
        LarkSocialExp.a.getClass();
        int r83 = hq9.l2.a;
        boolean r84 = LarkSocialExp.f();
        boolean r85 = r81.q().n;
        if (r80 == true) goto L307;
        if (r84 == false) goto L306;
        if (r85 == true) goto L307;
    L306:
        boolean r86 = false;
    L308:
        if (r86 == true) goto L312;
        if (r82 == true) goto L312;
        boolean r87 = false;
    L313:
        if (r87 == true) goto L319;
        com.larus.bmhome.setting.c r88 = this.g;
        if (r88 == null) goto L329;
        ItemTextArrow r89 = r88.y0();
        if (r89 == null) goto L329;
        com.larus.utils.e1.o(r89);
    L329:
        final com.larus.bmhome.setting.c r90 = this.g;
        if (r90 != null) goto L332;
    L342:
        com.larus.bmhome.setting.c r91 = this.g;
        if (r91 == null) goto L391;
        AppHost.Companion r92 = AppHost.a;
        if (r92.isOversea() == false) goto L350;
        TextView r93 = r91.A();
        if (r93 == null) goto L391;
        r93.setVisibility(8);
        goto L391
    L350:
        if (r81.V() == false) goto L361;
        TextView r94 = r91.A();
        if (r94 == null) goto L354;
        r94.setVisibility(0);
    L354:
        TextView r95 = r91.A();
        if (r95 == null) goto L357;
        r95.setText("《豆包 AI 使用须知》");
    L357:
        TextView r96 = r91.A();
        if (r96 == null) goto L360;
        r96.setTextColor(getResources().getColor(v19.c.b(2130972123, getContext(), 2131103203)));
    L360:
        com.larus.utils.e1.d(r91.A(), new b2(this));
        goto L391
    L361:
        String r97 = getString(2131909746);
        if (r97 != null) goto L364;
    L367:
        boolean r99 = true;
    L368:
        if (r99 == false) goto L372;
        TextView r100 = r91.A();
        if (r100 == null) goto L391;
        r100.setVisibility(8);
        goto L391
    L372:
        TextView r101 = r91.A();
        if (r101 == null) goto L375;
        r101.setVisibility(0);
    L375:
        TextView r102 = r91.A();
        if (r102 == null) goto L379;
        StringCompanionObject r110 = StringCompanionObject.INSTANCE;
        r102.setText(String.format(getString(2131909278), Arrays.copyOf(new Object[]{r97}, 1)));
    L379:
        if (r92.isOversea() == true) goto L384;
        TextView r103 = r91.A();
        if (r103 == null) goto L384;
        r103.setTextColor(getResources().getColor(v19.c.b(2130972123, getContext(), 2131103203)));
    L384:
        if (r81.Z1().length() != 0) goto L386;
        r21 = true;
    L386:
        if (r21 == false) goto L390;
        TextView r104 = r91.A();
        if (r104 == null) goto L390;
        r104.setVisibility(8);
    L390:
        com.larus.utils.e1.d(r91.A(), new c2(this));
        goto L391
    L364:
        if (r97.length() == 0) goto L367;
        r99 = false;
    L391:
        com.larus.bmhome.setting.c r105 = this.g;
        if (r105 != null) goto L394;
    L428:
        com.larus.bmhome.setting.c r106 = this.g;
        if (r106 != null) goto L431;
    L456:
        eb0();
        if (AccountService.a.isLogin().booleanValue() == true) goto L463;
        com.larus.bmhome.setting.c r107 = this.g;
        if (r107 == null) goto L463;
        ItemGroup r108 = r107.p0();
        if (r108 == null) goto L463;
        com.larus.utils.e1.o(r108);
    L463:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new CommonSettingFragment$setupViews$1(this, null), 2, null);
        JSONObject r109 = new JSONObject();
        Intrinsics.checkNotNullParameter(r109, "params");
        TrackParams r111 = new TrackParams().merge(r109);
        by7.a r112 = new by7.a("bot_setting_pv");
        r112.b = this;
        r112.a.merge(r111);
        r112.b();
        this.v = com.larus.utils.v.a(this, new q1(this));
        if (this.m == 1) goto L466;
    L468:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CommonSettingFragment$requestAppletDebuggerEntrance$1(this, null), 3, null);
        r13.post(new r1(this));
        tb0();
        return;
    L466:
        if (AuthModelDelegate.b.z() == false) goto L468;
        com.larus.platform.service.u.a.d();
        goto L468
    L431:
        if (AppHost.a.isOversea() == false) goto L433;
    L452:
        TextView r113 = r106.Q0();
        if (r113 == null) goto L455;
        r113.setVisibility(8);
    L455:
        Unit r114 = Unit.INSTANCE;
        goto L456
    L433:
        if (r81.V() == true) goto L452;
        TextView r115 = r106.Q0();
        if (r115 == null) goto L438;
        r115.setText("《" + getString(2131909320) + 12299);
    L438:
        TextView r116 = r106.Q0();
        if (r116 == null) goto L441;
        r116.setTextColor(getResources().getColor(v19.c.b(2130972123, getContext(), 2131103203)));
    L441:
        String r117 = r81.w1();
        if (com.larus.utils.o0.d(r117) == true) goto L445;
        r117 = null;
    L445:
        if (r117 == null) goto L449;
        TextView r118 = r106.Q0();
        if (r118 == null) goto L455;
        com.larus.utils.e1.d(r118, new h4(this));
        goto L455
    L449:
        TextView r119 = r106.Q0();
        if (r119 == null) goto L455;
        com.larus.utils.e1.o(r119);
        goto L455
    L394:
        if (AppHost.a.isOversea() == false) goto L396;
    L424:
        TextView r120 = r105.C0();
        if (r120 == null) goto L427;
        r120.setVisibility(8);
    L427:
        Unit r121 = Unit.INSTANCE;
        goto L428
    L396:
        if (r81.V() == true) goto L424;
        final String r122 = r81.F1();
        if (com.larus.utils.o0.d(r122) == false) goto L401;
        String r123 = r122;
    L402:
        if (r123 == null) goto L421;
        TextView r124 = r105.C0();
        if (r124 == null) goto L415;
        String r125 = r81.h();
        if (r125 != null) goto L408;
    L413:
        r125 = "《" + getString(2131908309) + 12299;
    L414:
        r124.setText(r125);
        goto L415
    L408:
        if (Boolean.valueOf(com.larus.utils.o0.d(r125)).booleanValue() == true) goto L411;
        r125 = null;
    L411:
        if (r125 == null) goto L413;
    L415:
        TextView r126 = r105.C0();
        if (r126 == null) goto L418;
        r126.setTextColor(getResources().getColor(v19.c.b(2130972123, getContext(), 2131103203)));
    L418:
        TextView r127 = r105.C0();
        if (r127 == null) goto L427;
        com.larus.utils.e1.d(r127, new o3(this, r122));
        goto L427
    L421:
        TextView r128 = r105.C0();
        if (r128 == null) goto L427;
        com.larus.utils.e1.o(r128);
        goto L427
    L401:
        r123 = null;
        goto L402
    L332:
        if (r81.q2() == false) goto L336;
        AppInfoLayout r129 = r90.f();
        if (r129 == null) goto L342;
        com.larus.utils.e1.o(r129);
        Unit r130 = Unit.INSTANCE;
        goto L342
    L336:
        AppInfoLayout r131 = r90.f();
        if (r131 == null) goto L339;
        com.larus.utils.e1.x(r131);
    L339:
        AppInfoLayout r132 = r90.f();
        if (r132 == null) goto L342;
        r132.setOnClickListener(new v19.b6(new m4(r90, this)));
        Unit r133 = Unit.INSTANCE;
        goto L342
    L319:
        com.larus.bmhome.setting.c r134 = this.g;
        if (r134 == null) goto L324;
        ItemTextArrow r135 = r134.y0();
        if (r135 == null) goto L324;
        com.larus.utils.e1.d(r135, new a2(this));
    L324:
        com.larus.bmhome.setting.c r136 = this.g;
        if (r136 == null) goto L329;
        ItemTextArrow r137 = r136.y0();
        if (r137 == null) goto L329;
        com.larus.utils.e1.x(r137);
    L312:
        r87 = true;
    L307:
        r86 = true;
        goto L308
    L296:
        com.larus.bmhome.setting.c r138 = this.g;
        if (r138 == null) goto L301;
        ItemGroup r139 = r138.g();
        if (r139 == null) goto L301;
        com.larus.utils.e1.o(r139);
        goto L301
    L282:
        if (r74.DK() != true) goto L284;
        r75 = true;
    L278:
        r74 = null;
        goto L280
    L265:
        r68 = null;
        goto L266
    L254:
        if (r65.isDestroyed() == true) goto L258;
        if (Intrinsics.areEqual(r65.getClass().getName(), r61) == false) goto L258;
        r66 = true;
        goto L259
    L261:
        r64 = null;
        goto L262
    L279:
        r74 = r59;
        goto L280
    L224:
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.f() == true) goto L227;
    L236:
        com.larus.bmhome.setting.c r140 = this.g;
        if (r140 == null) goto L241;
        ItemTextArrow r141 = r140.B0();
        if (r141 == null) goto L241;
        com.larus.utils.e1.d(r141, new g4(this));
    L241:
        com.larus.bmhome.setting.c r142 = this.g;
        if (r142 == null) goto L246;
        ItemTextArrow r143 = r142.B0();
        if (r143 == null) goto L246;
        com.larus.utils.e1.x(r143);
        goto L246
    L227:
        if (com.larus.bmhome.utils.d3.a.getInt("primacy_guide", 0) != 0) goto L229;
        boolean r144 = true;
    L230:
        if (r144 == false) goto L236;
        com.larus.bmhome.setting.c r145 = this.g;
        if (r145 == null) goto L236;
        ItemTextArrow r146 = r145.B0();
        if (r146 == null) goto L236;
        r146.i6(getString(2131909313));
        goto L236
    L229:
        r144 = false;
        goto L230
    L215:
        if (r56 == null) goto L218;
        com.larus.utils.e1.o(r56);
    L211:
        r56 = null;
        goto L213
    L196:
        com.larus.bmhome.setting.c r147 = this.g;
        if (r147 == null) goto L201;
        ItemTextView r148 = r147.d0();
        if (r148 == null) goto L201;
        r148.setOnClickListener(new d0(this));
    L201:
        com.larus.bmhome.setting.c r149 = this.g;
        if (r149 == null) goto L206;
        ItemTextView r150 = r149.d0();
        if (r150 == null) goto L206;
        com.larus.utils.e1.x(r150);
        goto L206
    L53:
        if (com.larus.platform.service.z2.a.q().j == false) goto L65;
        com.larus.bmhome.setting.c r151 = this.g;
        if (r151 == null) goto L60;
        final ItemTextArrow r152 = r151.a();
        if (r152 == null) goto L60;
        r152.setText(getString(2131909247, new Object[]{getString(2131894309)}));
        com.larus.utils.e1.d(r152, new u4(r152, this));
    L60:
        com.larus.bmhome.setting.c r153 = this.g;
        if (r153 == null) goto L70;
        ItemTextArrow r154 = r153.a();
        if (r154 == null) goto L70;
        com.larus.utils.e1.x(r154);
        goto L70
    L33:
        if (com.larus.platform.service.z2.a.q().i == false) goto L45;
        com.larus.bmhome.setting.c r155 = this.g;
        if (r155 == null) goto L40;
        ItemTextArrow r156 = r155.I();
        if (r156 == null) goto L40;
        r156.setOnClickListener(new w4(this));
    L40:
        com.larus.bmhome.setting.c r157 = this.g;
        if (r157 == null) goto L50;
        ItemTextArrow r158 = r157.I();
        if (r158 == null) goto L50;
        com.larus.utils.e1.x(r158);
        goto L50
    }

    public final void pb0(ModelItemIdentity r4, String r5) {
        if (this.L0 == true) goto L5;
        return;
    L5:
        this.L0 = false;
        if (Intrinsics.areEqual(r4, wa8.t0.a) == true) goto L8;
    L9:
        StringCompanionObject r6 = StringCompanionObject.INSTANCE;
        String r7 = getString(2131907845);
        Object[] r2 = new Object[1];
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        r2[0] = r5;
        String r8 = String.format(r7, Arrays.copyOf(r2, 1));
        t19.s r9 = t19.s.a;
        Context r0 = requireContext();
        r9.getClass();
        t19.s.p(r0, r8);
        return;
    L8:
        if (ObricTaskSkillDelegate.b.c(Oa0()) == true) goto L9;
    }

    public static final Object W90(CommonSettingFragment r7, String r8, Continuation r9) {
        r7.getClass();
        if ((r9 instanceof CommonSettingFragment$findConversationInfo$1) == false) goto L7;
        CommonSettingFragment$findConversationInfo$1 r0 = (CommonSettingFragment$findConversationInfo$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        CommonSettingFragment$findConversationInfo$1 r5 = r0;
        Object r10 = r5.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r5.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L17:
        wc9.e r4 = (wc9.e) r10;
        if (r4 == null) goto L20;
        FLogger.a.d(r7.e, "Found conversation info: " + r4);
        return r4;
    L20:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        RepoDispatcher.a.getClass();
        ConversationRepo r6 = RepoDispatcher.f;
        r5.label = 1;
        r10 = IConversationRepoService$a.c(r6, r8, false, null, r5, 6);
        if (r10 != r2) goto L17;
        return r2;
    L7:
        r0 = new CommonSettingFragment$findConversationInfo$1(r7, r9);
        goto L8
    }

    public static void Wa0(String r16, String r17, String r18) {
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r0 = ICommerceMembershipService.a.a();
        String r1 = null;
        if (r0 == null) goto L5;
        uz8.c r2 = r0.z(r16);
    L6:
        ICommerceMembershipService r3 = ICommerceMembershipService.a.a();
        if (r3 == null) goto L31;
        if (r2 == null) goto L10;
        String r4 = r2.a;
    L12:
        if (com.larus.utils.o0.d(r4) == false) goto L16;
        if (r2 == null) goto L15;
        String r5 = r2.a;
    L18:
        if (r2 == null) goto L20;
        String r6 = r2.b;
    L21:
        if (r2 == null) goto L23;
        String r7 = r2.c;
    L24:
        if (r2 == null) goto L26;
        String r8 = r2.d;
    L27:
        if (r2 == null) goto L29;
        r1 = r2.f;
    L29:
        ICommerceMembershipService.b.b(r3, r5, "settings", r6, r7, r8, r1, r18, null, null, null, null, null, 3968);
        return;
    L26:
        r8 = null;
        goto L27
    L23:
        r7 = null;
        goto L24
    L20:
        r6 = null;
        goto L21
    L15:
        r5 = null;
        goto L18
    L16:
        r5 = r17;
        goto L18
    L10:
        r4 = null;
        goto L12
    L31:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r95, ViewGroup r96, Bundle r97) {
        Intrinsics.checkNotNullParameter(r95, "inflater");
        boolean r6 = true;
        if (this.m != 1) goto L7;
        if (com.larus.platform.service.z2.a.enableMainBotNewSetting() == false) goto L7;
    L10:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r95, "inflater");
        int r3 = 2131365600;
        if (r6 == false) goto L249;
        boolean r7 = com.larus.platform.service.z2.a.configListReorder();
        if (r7 == false) goto L15;
        int r4 = 2131563022;
    L16:
        View r1 = r95.inflate(r4, r96, false);
        ItemTextArrow r19 = ViewBindings.findChildViewById(r1, 2131361948);
        if (r19 == null) goto L246;
        ItemTextView r20 = ViewBindings.findChildViewById(r1, 2131362022);
        if (r20 == null) goto L245;
        AppCompatTextView r21 = ViewBindings.findChildViewById(r1, 2131362026);
        if (r21 == null) goto L244;
        CardView r22 = ViewBindings.findChildViewById(r1, 2131362307);
        if (r22 == null) goto L243;
        AppInfoLayout r23 = ViewBindings.findChildViewById(r1, 2131363094);
        if (r23 != null) goto L27;
        r3 = 2131363094;
    L248:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r3)));
    L27:
        if (((LinearLayout) ViewBindings.findChildViewById(r1, 2131364480)) == null) goto L241;
        FrameLayout r24 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131365600);
        if (r24 == null) goto L248;
        if (ViewBindings.findChildViewById(r1, 2131366939) == null) goto L240;
        ItemTextArrow r25 = ViewBindings.findChildViewById(r1, 2131367488);
        if (r25 == null) goto L239;
        LinearLayout r26 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131367771);
        if (r26 == null) goto L238;
        ItemTextArrow r27 = ViewBindings.findChildViewById(r1, 2131368265);
        if (r27 == null) goto L237;
        ItemTextMenu r28 = ViewBindings.findChildViewById(r1, 2131368761);
        if (r28 == null) goto L236;
        TextView r29 = (TextView) ViewBindings.findChildViewById(r1, 2131369128);
        if (r29 == null) goto L235;
        ItemTextArrow r30 = ViewBindings.findChildViewById(r1, 2131369532);
        if (r30 == null) goto L234;
        ItemTextArrow r31 = ViewBindings.findChildViewById(r1, 2131370102);
        if (r31 == null) goto L233;
        ItemTextArrow r32 = ViewBindings.findChildViewById(r1, 2131370252);
        if (r32 == null) goto L232;
        ItemTextArrow r33 = ViewBindings.findChildViewById(r1, 2131371414);
        if (r33 == null) goto L231;
        ItemTextArrow r34 = ViewBindings.findChildViewById(r1, 2131373129);
        if (r34 == null) goto L230;
        ItemTextMenu r35 = ViewBindings.findChildViewById(r1, 2131373169);
        if (r35 == null) goto L229;
        ItemTextArrow r36 = ViewBindings.findChildViewById(r1, 2131373649);
        if (r36 == null) goto L228;
        ItemTextArrow r37 = ViewBindings.findChildViewById(r1, 2131374754);
        if (r37 == null) goto L227;
        ItemTextMenu r38 = ViewBindings.findChildViewById(r1, 2131375216);
        if (r38 == null) goto L226;
        ItemTextArrow r39 = ViewBindings.findChildViewById(r1, 2131375217);
        if (r39 == null) goto L225;
        ItemTextArrow r40 = ViewBindings.findChildViewById(r1, 2131375709);
        if (r40 == null) goto L224;
        ItemTextArrow r41 = ViewBindings.findChildViewById(r1, 2131375806);
        if (r41 == null) goto L223;
        ItemTextView r42 = ViewBindings.findChildViewById(r1, 2131376739);
        if (r42 == null) goto L222;
        ItemTextMenu r43 = ViewBindings.findChildViewById(r1, 2131376838);
        if (r43 == null) goto L221;
        ItemTextArrow r44 = ViewBindings.findChildViewById(r1, 2131377149);
        if (r44 == null) goto L220;
        ItemTextArrow r45 = ViewBindings.findChildViewById(r1, 2131379229);
        if (r45 == null) goto L219;
        ItemTextArrow r46 = ViewBindings.findChildViewById(r1, 2131379515);
        if (r46 == null) goto L218;
        ItemTextArrow r2 = ViewBindings.findChildViewById(r1, 2131379857);
        if (r2 == null) goto L217;
        FrameLayout r48 = (FrameLayout) ViewBindings.findChildViewById(r1, 2131380416);
        if (r48 == null) goto L216;
        ItemTextArrow r49 = ViewBindings.findChildViewById(r1, 2131380417);
        if (r49 == null) goto L215;
        ItemGroup r50 = ViewBindings.findChildViewById(r1, 2131380722);
        if (r50 == null) goto L214;
        ItemGroup r51 = ViewBindings.findChildViewById(r1, 2131380723);
        if (r51 == null) goto L213;
        ItemGroup r52 = ViewBindings.findChildViewById(r1, 2131380724);
        if (r52 == null) goto L212;
        ItemGroup r53 = ViewBindings.findChildViewById(r1, 2131380725);
        if (r53 == null) goto L211;
        ItemGroup r54 = ViewBindings.findChildViewById(r1, 2131380727);
        if (r54 == null) goto L210;
        ItemGroup r55 = ViewBindings.findChildViewById(r1, 2131380728);
        if (r55 == null) goto L209;
        ItemGroup r56 = ViewBindings.findChildViewById(r1, 2131380730);
        if (r56 == null) goto L208;
        ItemGroup r57 = ViewBindings.findChildViewById(r1, 2131380731);
        if (r57 == null) goto L207;
        ItemGroup r58 = ViewBindings.findChildViewById(r1, 2131380732);
        if (r58 == null) goto L206;
        AppCompatTextView r59 = ViewBindings.findChildViewById(r1, 2131380897);
        if (r59 == null) goto L205;
        AppCompatImageView r60 = ViewBindings.findChildViewById(r1, 2131380898);
        if (r60 == null) goto L204;
        ConstraintLayout r61 = ViewBindings.findChildViewById(r1, 2131380899);
        if (r61 == null) goto L203;
        ItemTextArrow r62 = ViewBindings.findChildViewById(r1, 2131381069);
        if (r62 == null) goto L202;
        ItemTextArrow r5 = ViewBindings.findChildViewById(r1, 2131381401);
        if (r5 == null) goto L201;
        ItemTextArrow r64 = ViewBindings.findChildViewById(r1, 2131381654);
        if (r64 == null) goto L200;
        TextView r65 = (TextView) ViewBindings.findChildViewById(r1, 2131382189);
        if (r65 == null) goto L199;
        ItemTextToggle r66 = ViewBindings.findChildViewById(r1, 2131382859);
        if (r66 == null) goto L198;
        ItemTextToggle r67 = ViewBindings.findChildViewById(r1, 2131382860);
        if (r67 == null) goto L197;
        ItemTextToggle r68 = ViewBindings.findChildViewById(r1, 2131382861);
        if (r68 == null) goto L196;
        ItemTextToggle r69 = ViewBindings.findChildViewById(r1, 2131382863);
        if (r69 == null) goto L195;
        ItemTextToggle r70 = ViewBindings.findChildViewById(r1, 2131382864);
        if (r70 == null) goto L194;
        ItemTextToggle r71 = ViewBindings.findChildViewById(r1, 2131382867);
        if (r71 == null) goto L193;
        ItemTextArrow r8 = ViewBindings.findChildViewById(r1, 2131383031);
        if (r8 == null) goto L192;
        ItemTextToggle r73 = ViewBindings.findChildViewById(r1, 2131383823);
        if (r73 == null) goto L191;
        ItemTextToggle r74 = ViewBindings.findChildViewById(r1, 2131383828);
        if (r74 == null) goto L190;
        ItemTextToggle r9 = ViewBindings.findChildViewById(r1, 2131384197);
        if (r9 == null) goto L189;
        ItemTextArrow r10 = ViewBindings.findChildViewById(r1, 2131384280);
        if (r10 == null) goto L188;
        TextView r77 = (TextView) ViewBindings.findChildViewById(r1, 2131385080);
        if (r77 == null) goto L187;
        NestedScrollView r78 = ViewBindings.findChildViewById(r1, 2131385238);
        if (r78 == null) goto L186;
        ItemTextArrow r11 = ViewBindings.findChildViewById(r1, 2131385589);
        if (r11 == null) goto L185;
        ItemGroup r80 = ViewBindings.findChildViewById(r1, 2131387006);
        if (r80 == null) goto L184;
        ItemTextToggle r12 = ViewBindings.findChildViewById(r1, 2131387248);
        if (r12 == null) goto L183;
        ItemTextArrow r82 = ViewBindings.findChildViewById(r1, 2131387696);
        if (r82 == null) goto L182;
        ItemTextArrow r83 = ViewBindings.findChildViewById(r1, 2131388571);
        if (r83 == null) goto L181;
        NovaTitleBarEx r84 = ViewBindings.findChildViewById(r1, 2131388772);
        if (r84 == null) goto L180;
        ItemTextArrow r13 = ViewBindings.findChildViewById(r1, 2131389952);
        if (r13 == null) goto L179;
        ItemTextArrow r14 = ViewBindings.findChildViewById(r1, 2131389953);
        if (r14 == null) goto L178;
        ItemTextArrow r87 = ViewBindings.findChildViewById(r1, 2131391977);
        if (r87 == null) goto L177;
        RoundAvatarImageView r88 = ViewBindings.findChildViewById(r1, 2131391990);
        if (r88 == null) goto L176;
        RelativeLayout r89 = (RelativeLayout) ViewBindings.findChildViewById(r1, 2131392014);
        if (r89 == null) goto L175;
        ItemTextArrow r90 = ViewBindings.findChildViewById(r1, 2131392022);
        if (r90 == null) goto L174;
        AppCompatTextView r91 = ViewBindings.findChildViewById(r1, 2131392049);
        if (r91 == null) goto L173;
        ItemTextToggle r92 = ViewBindings.findChildViewById(r1, 2131392377);
        if (r92 == null) goto L172;
        ItemTextArrow r93 = ViewBindings.findChildViewById(r1, 2131392996);
        if (r93 == null) goto L171;
        LarusPageChatSettingMainBotBinding r15 = new LarusPageChatSettingMainBotBinding((LinearLayout) r1, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r2, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r5, r64, r65, r66, r67, r68, r69, r70, r71, r8, r73, r74, r9, r10, r77, r78, r11, r80, r12, r82, r83, r84, r13, r14, r87, r88, r89, r90, r91, r92, r93);
        r2.setTag(2131377174, SettingsItemType.MEMBERSHIP);
        r13.setTag(2131377174, SettingsItemType.TTS_SPEAKER_ITEM);
        r14.setTag(2131377174, SettingsItemType.TTS_SPEAKER_ITEM);
        r10.setTag(2131377174, SettingsItemType.RENEW_SECTION);
        r11.setTag(2131377174, SettingsItemType.SEARCH_SECTION);
        r15.c.setTag(2131377174, SettingsItemType.SAAS_ACCOUNT_BIND);
        r15.k.setTag(2131377174, SettingsItemType.DEFAULT_REPLY_MODE);
        r15.u.setTag(2131377174, SettingsItemType.INDEPENDENT_REPLY_MODE);
        r15.v.setTag(2131377174, SettingsItemType.INDEPENDENT_REPLY_MODEL);
        r9.setTag(2131377174, SettingsItemType.RELATED_VIDEO);
        r15.o.setTag(2131377174, SettingsItemType.DRIVE_STORAGE);
        r8.setTag(2131377174, SettingsItemType.PRIVACY_PERMISSION);
        r15.n.setTag(2131377174, SettingsItemType.DOUBAO_WEBSITE);
        r15.b.setTag(2131377174, SettingsItemType.ABOUT_DOUBAO);
        r5.setTag(2131377174, SettingsItemType.OFFICE_TASK_SETTINGS);
        r15.r.setTag(2131377174, SettingsItemType.FORK_CONVERSATION);
        r15.w.setTag(2131377174, SettingsItemType.SAAS_ACCOUNT_BIND);
        r12.setTag(2131377174, SettingsItemType.STARTUP_OPEN_NEW_CHAT);
        com.larus.bmhome.setting.c r16 = new o(r15, r7);
    L356:
        this.g = r16;
        Ba0();
        com.larus.bmhome.setting.c r17 = this.g;
        if (r17 == null) goto L359;
        s1a.a.g(this).n(r17, com.larus.bmhome.setting.c.class);
    L359:
        s1a.a.g(this).n(new com.larus.bmhome.setting.k(this.J), com.larus.bmhome.setting.k.class);
        com.larus.bmhome.setting.c r18 = this.g;
        if (r18 == null) goto L364;
        View r47 = r18.P0();
        if (r47 == null) goto L364;
        r47.setTag(2131377847, this);
        return r47;
    L364:
        return null;
    L171:
        r3 = 2131392996;
        goto L248
    L172:
        r3 = 2131392377;
        goto L248
    L173:
        r3 = 2131392049;
        goto L248
    L174:
        r3 = 2131392022;
        goto L248
    L175:
        r3 = 2131392014;
        goto L248
    L176:
        r3 = 2131391990;
        goto L248
    L177:
        r3 = 2131391977;
        goto L248
    L178:
        r3 = 2131389953;
        goto L248
    L179:
        r3 = 2131389952;
        goto L248
    L180:
        r3 = 2131388772;
        goto L248
    L181:
        r3 = 2131388571;
        goto L248
    L182:
        r3 = 2131387696;
        goto L248
    L183:
        r3 = 2131387248;
        goto L248
    L184:
        r3 = 2131387006;
        goto L248
    L185:
        r3 = 2131385589;
        goto L248
    L186:
        r3 = 2131385238;
        goto L248
    L187:
        r3 = 2131385080;
        goto L248
    L188:
        r3 = 2131384280;
        goto L248
    L189:
        r3 = 2131384197;
        goto L248
    L190:
        r3 = 2131383828;
        goto L248
    L191:
        r3 = 2131383823;
        goto L248
    L192:
        r3 = 2131383031;
        goto L248
    L193:
        r3 = 2131382867;
        goto L248
    L194:
        r3 = 2131382864;
        goto L248
    L195:
        r3 = 2131382863;
        goto L248
    L196:
        r3 = 2131382861;
        goto L248
    L197:
        r3 = 2131382860;
        goto L248
    L198:
        r3 = 2131382859;
        goto L248
    L199:
        r3 = 2131382189;
        goto L248
    L200:
        r3 = 2131381654;
        goto L248
    L201:
        r3 = 2131381401;
        goto L248
    L202:
        r3 = 2131381069;
        goto L248
    L203:
        r3 = 2131380899;
        goto L248
    L204:
        r3 = 2131380898;
        goto L248
    L205:
        r3 = 2131380897;
        goto L248
    L206:
        r3 = 2131380732;
        goto L248
    L207:
        r3 = 2131380731;
        goto L248
    L208:
        r3 = 2131380730;
        goto L248
    L209:
        r3 = 2131380728;
        goto L248
    L210:
        r3 = 2131380727;
        goto L248
    L211:
        r3 = 2131380725;
        goto L248
    L212:
        r3 = 2131380724;
        goto L248
    L213:
        r3 = 2131380723;
        goto L248
    L214:
        r3 = 2131380722;
        goto L248
    L215:
        r3 = 2131380417;
        goto L248
    L216:
        r3 = 2131380416;
        goto L248
    L217:
        r3 = 2131379857;
        goto L248
    L218:
        r3 = 2131379515;
        goto L248
    L219:
        r3 = 2131379229;
        goto L248
    L220:
        r3 = 2131377149;
        goto L248
    L221:
        r3 = 2131376838;
        goto L248
    L222:
        r3 = 2131376739;
        goto L248
    L223:
        r3 = 2131375806;
        goto L248
    L224:
        r3 = 2131375709;
        goto L248
    L225:
        r3 = 2131375217;
        goto L248
    L226:
        r3 = 2131375216;
        goto L248
    L227:
        r3 = 2131374754;
        goto L248
    L228:
        r3 = 2131373649;
        goto L248
    L229:
        r3 = 2131373169;
        goto L248
    L230:
        r3 = 2131373129;
        goto L248
    L231:
        r3 = 2131371414;
        goto L248
    L232:
        r3 = 2131370252;
        goto L248
    L233:
        r3 = 2131370102;
        goto L248
    L234:
        r3 = 2131369532;
        goto L248
    L235:
        r3 = 2131369128;
        goto L248
    L236:
        r3 = 2131368761;
        goto L248
    L237:
        r3 = 2131368265;
        goto L248
    L238:
        r3 = 2131367771;
        goto L248
    L239:
        r3 = 2131367488;
        goto L248
    L240:
        r3 = 2131366939;
        goto L248
    L241:
        r3 = 2131364480;
        goto L248
    L243:
        r3 = 2131362307;
        goto L248
    L244:
        r3 = 2131362026;
        goto L248
    L245:
        r3 = 2131362022;
        goto L248
    L246:
        r3 = 2131361948;
        goto L248
    L15:
        r4 = 2131563021;
        goto L16
    L249:
        View r63 = r95.inflate(2131563020, r96, false);
        ItemLongTextArrow r110 = ViewBindings.findChildViewById(r63, 2131361973);
        if (r110 == null) goto L413;
        ItemTextView r210 = ViewBindings.findChildViewById(r63, 2131362265);
        if (r210 == null) goto L412;
        RoundAvatarImageView r211 = ViewBindings.findChildViewById(r63, 2131364354);
        if (r211 == null) goto L411;
        SimpleDraweeView r212 = ViewBindings.findChildViewById(r63, 2131364356);
        if (r212 == null) goto L410;
        TextView r213 = (TextView) ViewBindings.findChildViewById(r63, 2131364357);
        if (r213 == null) goto L409;
        TextView r214 = (TextView) ViewBindings.findChildViewById(r63, 2131364360);
        if (r214 == null) goto L408;
        LinearLayout r215 = (LinearLayout) ViewBindings.findChildViewById(r63, 2131364362);
        if (r215 != null) goto L264;
        r3 = 2131364362;
    L415:
        throw new NullPointerException("Missing required view with ID: ".concat(r63.getResources().getResourceName(r3)));
    L264:
        if (((TextView) ViewBindings.findChildViewById(r63, 2131364363)) == null) goto L406;
        LinearLayout r216 = (LinearLayout) ViewBindings.findChildViewById(r63, 2131364364);
        if (r216 != null) goto L268;
        r3 = 2131364364;
        goto L415
    L268:
        if (((TextView) ViewBindings.findChildViewById(r63, 2131364365)) == null) goto L404;
        LinearLayout r217 = (LinearLayout) ViewBindings.findChildViewById(r63, 2131364374);
        if (r217 == null) goto L403;
        TextView r218 = (TextView) ViewBindings.findChildViewById(r63, 2131364378);
        if (r218 == null) goto L402;
        LinearLayout r219 = (LinearLayout) ViewBindings.findChildViewById(r63, 2131364385);
        if (r219 == null) goto L401;
        TagTextView r310 = ViewBindings.findChildViewById(r63, 2131364386);
        if (r310 == null) goto L400;
        FrameLayout r311 = (FrameLayout) ViewBindings.findChildViewById(r63, 2131365600);
        if (r311 == null) goto L415;
        if (ViewBindings.findChildViewById(r63, 2131366939) == null) goto L399;
        LinearLayout r312 = (LinearLayout) ViewBindings.findChildViewById(r63, 2131367771);
        if (r312 == null) goto L398;
        ItemTextView r313 = ViewBindings.findChildViewById(r63, 2131368788);
        if (r313 != null) goto L286;
        r3 = 2131368788;
        goto L415
    L286:
        if (ViewBindings.findChildViewById(r63, 2131369532) == null) goto L396;
        ItemTextArrow r314 = ViewBindings.findChildViewById(r63, 2131371402);
        if (r314 == null) goto L395;
        ItemTextArrow r315 = ViewBindings.findChildViewById(r63, 2131371414);
        if (r315 == null) goto L394;
        ItemTextToggle r316 = ViewBindings.findChildViewById(r63, 2131371933);
        if (r316 == null) goto L393;
        ItemTextArrow r317 = ViewBindings.findChildViewById(r63, 2131373649);
        if (r317 == null) goto L392;
        ItemGroup r318 = ViewBindings.findChildViewById(r63, 2131373909);
        if (r318 == null) goto L391;
        ItemGroup r319 = ViewBindings.findChildViewById(r63, 2131373910);
        if (r319 == null) goto L390;
        ItemGroup r410 = ViewBindings.findChildViewById(r63, 2131373911);
        if (r410 == null) goto L389;
        ItemGroup r411 = ViewBindings.findChildViewById(r63, 2131373912);
        if (r411 == null) goto L388;
        ItemGroup r412 = ViewBindings.findChildViewById(r63, 2131373913);
        if (r412 != null) goto L306;
        r3 = 2131373913;
        goto L415
    L306:
        if (ViewBindings.findChildViewById(r63, 2131373953) == null) goto L386;
        ItemGroup r413 = ViewBindings.findChildViewById(r63, 2131373960);
        if (r413 == null) goto L385;
        ItemGroup r414 = ViewBindings.findChildViewById(r63, 2131374001);
        if (r414 == null) goto L384;
        ItemGroup r415 = ViewBindings.findChildViewById(r63, 2131374003);
        if (r415 == null) goto L383;
        ItemGroup r416 = ViewBindings.findChildViewById(r63, 2131374008);
        if (r416 == null) goto L382;
        TextView r417 = (TextView) ViewBindings.findChildViewById(r63, 2131374321);
        if (r417 == null) goto L381;
        AppCompatImageView r418 = ViewBindings.findChildViewById(r63, 2131374547);
        if (r418 == null) goto L380;
        ItemTextArrow r419 = ViewBindings.findChildViewById(r63, 2131374754);
        if (r419 == null) goto L379;
        ItemTextArrow r510 = ViewBindings.findChildViewById(r63, 2131377149);
        if (r510 == null) goto L378;
        TextView r511 = (TextView) ViewBindings.findChildViewById(r63, 2131378937);
        if (r511 == null) goto L377;
        ItemTextArrow r512 = ViewBindings.findChildViewById(r63, 2131379229);
        if (r512 == null) goto L376;
        ItemTextArrow r513 = ViewBindings.findChildViewById(r63, 2131380246);
        if (r513 == null) goto L375;
        ItemTextToggle r514 = ViewBindings.findChildViewById(r63, 2131380367);
        if (r514 == null) goto L374;
        ItemTextArrow r515 = ViewBindings.findChildViewById(r63, 2131380900);
        if (r515 == null) goto L373;
        ItemTextArrow r516 = ViewBindings.findChildViewById(r63, 2131382487);
        if (r516 == null) goto L372;
        ItemTextToggle r517 = ViewBindings.findChildViewById(r63, 2131383828);
        if (r517 == null) goto L371;
        r3 = 2131384280;
        ItemTextArrow r518 = ViewBindings.findChildViewById(r63, 2131384280);
        if (r518 == null) goto L415;
        ItemTextArrow r519 = ViewBindings.findChildViewById(r63, 2131384444);
        if (r519 == null) goto L370;
        ItemTextArrow r610 = ViewBindings.findChildViewById(r63, 2131385589);
        if (r610 == null) goto L369;
        ViewStub r611 = (ViewStub) ViewBindings.findChildViewById(r63, 2131386062);
        if (r611 == null) goto L368;
        ItemGroup r612 = ViewBindings.findChildViewById(r63, 2131387006);
        if (r612 == null) goto L367;
        r3 = 2131388772;
        NovaTitleBarEx r613 = ViewBindings.findChildViewById(r63, 2131388772);
        if (r613 == null) goto L415;
        ItemTextArrow r614 = ViewBindings.findChildViewById(r63, 2131389952);
        if (r614 == null) goto L366;
        r3 = 2131389953;
        ItemTextArrow r615 = ViewBindings.findChildViewById(r63, 2131389953);
        if (r615 == null) goto L415;
        r3 = 2131389961;
        ItemTextArrow r616 = ViewBindings.findChildViewById(r63, 2131389961);
        if (r616 == null) goto L415;
        r16 = new p(new LarusPageChatSettingBinding((LinearLayout) r63, r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616));
        goto L356
    L366:
        r3 = 2131389952;
        goto L415
    L367:
        r3 = 2131387006;
        goto L415
    L368:
        r3 = 2131386062;
        goto L415
    L369:
        r3 = 2131385589;
        goto L415
    L370:
        r3 = 2131384444;
        goto L415
    L371:
        r3 = 2131383828;
        goto L415
    L372:
        r3 = 2131382487;
        goto L415
    L373:
        r3 = 2131380900;
        goto L415
    L374:
        r3 = 2131380367;
        goto L415
    L375:
        r3 = 2131380246;
        goto L415
    L376:
        r3 = 2131379229;
        goto L415
    L377:
        r3 = 2131378937;
        goto L415
    L378:
        r3 = 2131377149;
        goto L415
    L379:
        r3 = 2131374754;
        goto L415
    L380:
        r3 = 2131374547;
        goto L415
    L381:
        r3 = 2131374321;
        goto L415
    L382:
        r3 = 2131374008;
        goto L415
    L383:
        r3 = 2131374003;
        goto L415
    L384:
        r3 = 2131374001;
        goto L415
    L385:
        r3 = 2131373960;
        goto L415
    L386:
        r3 = 2131373953;
        goto L415
    L388:
        r3 = 2131373912;
        goto L415
    L389:
        r3 = 2131373911;
        goto L415
    L390:
        r3 = 2131373910;
        goto L415
    L391:
        r3 = 2131373909;
        goto L415
    L392:
        r3 = 2131373649;
        goto L415
    L393:
        r3 = 2131371933;
        goto L415
    L394:
        r3 = 2131371414;
        goto L415
    L395:
        r3 = 2131371402;
        goto L415
    L396:
        r3 = 2131369532;
        goto L415
    L398:
        r3 = 2131367771;
        goto L415
    L399:
        r3 = 2131366939;
        goto L415
    L400:
        r3 = 2131364386;
        goto L415
    L401:
        r3 = 2131364385;
        goto L415
    L402:
        r3 = 2131364378;
        goto L415
    L403:
        r3 = 2131364374;
        goto L415
    L404:
        r3 = 2131364365;
        goto L415
    L406:
        r3 = 2131364363;
        goto L415
    L408:
        r3 = 2131364360;
        goto L415
    L409:
        r3 = 2131364357;
        goto L415
    L410:
        r3 = 2131364356;
        goto L415
    L411:
        r3 = 2131364354;
        goto L415
    L412:
        r3 = 2131362265;
        goto L415
    L413:
        r3 = 2131361973;
    L7:
        if (com.larus.platform.service.z2.a.q().c == true) goto L10;
        r6 = false;
        goto L10
    }

    public final Object Fa0(String r9, boolean r10, String r11, Continuation r12) {
        if ((r12 instanceof CommonSettingFragment$findBotInfo$1) == false) goto L7;
        CommonSettingFragment$findBotInfo$1 r0 = (CommonSettingFragment$findBotInfo$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        CommonSettingFragment$findBotInfo$1 r6 = r0;
        Object r13 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r13);
    L26:
        return r13;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r14 = r6.Z$0;
        IBotRepoService r15 = (IBotRepoService) r6.L$1;
        String r16 = (String) r6.L$0;
        ResultKt.throwOnFailure(r13);
        IBotRepoService r4 = r15;
        boolean r5 = r14;
        String r7 = r16;
    L20:
        String r17 = (String) CollectionsKt.firstOrNull((List) r13);
        if (r17 != null) goto L23;
        r17 = "";
    L23:
        FLogger.a.d(this.e, "Found bot info: ".concat(r17));
        r6.L$0 = null;
        r6.L$1 = null;
        r6.label = 2;
        r13 = IBotRepoService.b.a(r4, r17, r5, r7, false, r6, 8);
        if (r13 != r2) goto L26;
        return r2;
    L16:
        ResultKt.throwOnFailure(r13);
        RepoDispatcher.a.getClass();
        IBotRepoService r18 = RepoDispatcher.g;
        r6.L$0 = r11;
        r6.L$1 = r18;
        r6.Z$0 = r10;
        r6.label = 1;
        Object r19 = ic8.n.b(r9, r6);
        if (r19 != r2) goto L19;
        return r2;
    L19:
        r5 = r10;
        r7 = r11;
        r4 = r18;
        r13 = r19;
    L7:
        r0 = new CommonSettingFragment$findBotInfo$1(this, r12);
        goto L8
    }

    public static /* synthetic */ Object Ga0(CommonSettingFragment r1, String r2, boolean r3, Continuation r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        String r6 = "default";
    L10:
        return r1.Fa0(r2, r3, r6, r4);
    L8:
        r6 = null;
        goto L10
    }
}
