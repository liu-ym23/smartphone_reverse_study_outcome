package com.larus.voice_setting.voice;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.SoundsSource;
import com.larus.audio.bean.GetMatchVoiceRequest;
import com.larus.audio.bean.VoiceListTabInfo;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureConfig;
import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.model.TabKey;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.FragmentExtKt;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.impl.databinding.LarusPageDoubleTtsSpeakerSettingBinding;
import com.larus.voice_setting.impl.databinding.LarusTtsSpeakerContentNewStyleBinding;
import com.larus.voice_setting.impl.databinding.LarusTtsSpeakerTitleNewStyleBinding;
import com.larus.voice_setting.voice.base.MyVoiceListFragment;
import com.larus.voice_setting.voice.base.RecommendVoiceListFragment;
import com.larus.voice_setting.voice.base.VoiceDisplayScene;
import com.larus.voice_setting.voice.base.multitab.MultiTabVoiceListFragment;
import com.larus.voice_setting.voice.editvoice.SpeakerVoiceEditModel;
import com.larus.voice_setting.voice.mix.SingleVoiceBar;
import com.larus.voice_setting.voice.mix.VoiceEditArea;
import com.larus.voice_setting.voice.mix.VoiceMixBar;
import com.larus.voice_setting.voice.mix.VoiceMixedView;
import com.larus.voice_setting.voice.mix.VoiceSingleView;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.xelement.webview.LynxUIWebView;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.i3;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0092\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ¶\u00012\u00020\u0001:\u0006µ\u0001¶\u0001·\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010_\u001a\u00020\rH\u0016J\b\u0010`\u001a\u00020\u000fH\u0016J&\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010f2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\u001c\u0010i\u001a\u0004\u0018\u00010b2\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010fH\u0002J\u0012\u0010j\u001a\u00020k2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\b\u0010l\u001a\u00020kH\u0002J\b\u0010m\u001a\u00020kH\u0002J\b\u0010n\u001a\u00020kH\u0002J\b\u0010o\u001a\u00020\u000fH\u0002J\b\u0010p\u001a\u00020\u000fH\u0002J\u0010\u0010q\u001a\u00020k2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010r\u001a\u00020k2\u0006\u0010s\u001a\u00020b2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\b\u0010t\u001a\u00020kH\u0002J\b\u0010u\u001a\u00020kH\u0002J\u000e\u0010v\u001a\b\u0012\u0004\u0012\u00020w0/H\u0002J\b\u0010x\u001a\u00020kH\u0002J\u0018\u0010y\u001a\u00020k2\u000e\u0010z\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/H\u0002J\u0012\u0010{\u001a\u00020\r2\b\u0010|\u001a\u0004\u0018\u00010\u000fH\u0002J*\u0010}\u001a\u00020\u00142\b\u0010|\u001a\u0004\u0018\u00010\u000f2\u0006\u0010~\u001a\u00020\u00142\u0006\u0010{\u001a\u00020\r2\u0006\u0010\u007f\u001a\u00020\u0014H\u0002J\t\u0010\u0080\u0001\u001a\u00020\u0014H\u0002J\u001a\u0010\u0081\u0001\u001a\u00020\u00142\u0007\u0010\u0082\u0001\u001a\u00020\u00142\u0006\u0010\u007f\u001a\u00020\u0014H\u0002J\u0014\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u000f2\u0007\u0010\u0082\u0001\u001a\u00020\u0014H\u0002J\u001d\u0010\u0084\u0001\u001a\u00020k2\u0007\u0010\u0085\u0001\u001a\u00020\r2\t\b\u0002\u0010\u0086\u0001\u001a\u00020\rH\u0002J\u0007\u0010\u0087\u0001\u001a\u00020kJ\t\u0010\u0088\u0001\u001a\u00020kH\u0002J\t\u0010\u0089\u0001\u001a\u00020kH\u0002J\t\u0010\u008a\u0001\u001a\u00020kH\u0016J\t\u0010\u008b\u0001\u001a\u00020kH\u0002J\t\u0010\u008c\u0001\u001a\u00020kH\u0002J\u0013\u0010\u008d\u0001\u001a\u00020k2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0002J7\u0010\u0090\u0001\u001a\u00020k2#\u0010\u0091\u0001\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015`\u00162\u0007\u0010\u0092\u0001\u001a\u00020AH\u0002J\u0013\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u000fH\u0002J\u0014\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u000f2\u0007\u0010\u0082\u0001\u001a\u00020\u0014H\u0002J\t\u0010\u0097\u0001\u001a\u00020\rH\u0002J\t\u0010\u0098\u0001\u001a\u00020kH\u0002J\u0011\u0010\u0099\u0001\u001a\u0004\u0018\u00010kH\u0002¢\u0006\u0003\u0010\u009a\u0001J\t\u0010\u009b\u0001\u001a\u00020kH\u0002J\t\u0010\u009c\u0001\u001a\u00020\rH\u0002J\t\u0010\u009d\u0001\u001a\u00020kH\u0002J\t\u0010\u009e\u0001\u001a\u00020\u000fH\u0002J\t\u0010\u009f\u0001\u001a\u00020kH\u0002J\u0011\u0010 \u0001\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010/H\u0002J\t\u0010¡\u0001\u001a\u00020kH\u0016J\u0014\u0010¢\u0001\u001a\u00020k2\t\b\u0002\u0010£\u0001\u001a\u00020\rH\u0002J\t\u0010¤\u0001\u001a\u00020kH\u0016J\t\u0010¥\u0001\u001a\u00020kH\u0002J\t\u0010¦\u0001\u001a\u00020kH\u0002J\u0012\u0010§\u0001\u001a\u00020k2\u0007\u0010¨\u0001\u001a\u00020\u000fH\u0002J\t\u0010©\u0001\u001a\u00020kH\u0002J&\u0010ª\u0001\u001a\u0004\u0018\u00010R2\u0007\u0010«\u0001\u001a\u00020\r2\u0007\u0010¬\u0001\u001a\u00020\r2\u0007\u0010\u00ad\u0001\u001a\u00020\rH\u0002J\t\u0010«\u0001\u001a\u00020\rH\u0002J\"\u0010®\u0001\u001a\u00020\r*\b\u0012\u0004\u0012\u00020w0/2\r\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00020w0/H\u0002J\u001a\u0010°\u0001\u001a\t\u0012\u0005\u0012\u00030±\u00010/*\b\u0012\u0004\u0012\u00020w0/H\u0002J\t\u0010²\u0001\u001a\u00020kH\u0002J\t\u0010³\u0001\u001a\u00020kH\u0016J\t\u0010´\u0001\u001a\u0004\u0018\u00010\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u000f02X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020G02X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010L\u001a\u00020M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u001e\u001a\u0004\bN\u0010OR\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010S\u001a\u00020T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\u001e\u001a\u0004\bU\u0010VR\u000e\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010Z\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u000e\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¸\u0001"}, d2 = {"Lcom/larus/voice_setting/voice/DoubleTabTtsSpeakerSettingFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "recommendRequest", "Lcom/larus/audio/bean/GetMatchVoiceRequest;", "binding", "Lcom/larus/voice_setting/impl/databinding/LarusPageDoubleTtsSpeakerSettingBinding;", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "backPressCallback", "Landroidx/activity/OnBackPressedCallback;", "uiMode", NameKeys.UnloadStrategy_No_Strategy, "languageCode", NameKeys.UnloadStrategy_No_Strategy, "showCreateVoiceBtn", "enterFrom", "fragments", "Ljava/util/HashMap;", NameKeys.UnloadStrategy_No_Strategy, "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/HashMap;", "initialVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "model", "Lcom/larus/voice_setting/voice/TtsSpeakerSettingViewModel;", "getModel", "()Lcom/larus/voice_setting/voice/TtsSpeakerSettingViewModel;", "model$delegate", "Lkotlin/Lazy;", "isMute", "nonVoice", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "languageName", "searchMobParam", "Lcom/larus/platform/model/SearchMobParam;", "searchStartTime", NameKeys.UnloadStrategy_No_Strategy, "createVoice", "multiTab", "landingTab", "leaveMethod", "curIndex", "stabletab", "tabList", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/audio/bean/VoiceListTabInfo;", "allTabKeyList", NameKeys.UnloadStrategy_No_Strategy, "firstPageSelected", "isRebuildingViewPager", "botId", "enterMethod", "isInMinorMode", "trackParams", "Lorg/json/JSONObject;", "trackParamsStr", "editVoiceContentUIBinder", "Lcom/larus/voice_setting/voice/editvoice/EditVoiceContentUIBinder;", "voiceIdBeforeChange", "currentViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "currentTabLayout", "Lcom/google/android/material/tabs/TabLayout;", "currentPageChangeCallback", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "currentTabSelectedListener", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "appBarOffsetChangedListeners", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "defaultExpandMixVoiceView", "conversationId", "disableVoiceCloneDialogAnimation", "isFromVoiceCloneScheme", "perfTracer", "Lcom/larus/voice_setting/voice/perf/VoiceSettingPerfTracer;", "getPerfTracer", "()Lcom/larus/voice_setting/voice/perf/VoiceSettingPerfTracer;", "perfTracer$delegate", "pendingExitToastConfig", "Lcom/larus/voice_setting/voice/DoubleTabTtsSpeakerSettingFragment$ExitToastConfig;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "ttsBackgroundPlayCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "enterMethodParam", "getEnterMethodParam", "()Ljava/lang/String;", "fpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "autoLogEnterPage", "getCurrentPageName", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "createBinding", "onCreate", NameKeys.UnloadStrategy_No_Strategy, "initArguments", "setupLanguageCode", "updateRecommendRequest", "resolveRealLanguageCode", "getSupportTTSLanguageCode", "initTabList", "onViewCreated", "view", "setupVoiceEditArea", "setupTtsBackgroundPlayToggle", "getInitVoiceList", "Lcom/larus/im/bean/bot/MixVoice;", "initObservers", "rebuildViewPager", "newTabList", "shouldApplyLandingTabAfterRefresh", "currentTabKey", "getRebuildTargetPosition", "currentPos", "itemCount", "getLandingTabPosition", "getSafePagerPosition", "position", "getRawTabKey", "setVoiceMute", "mute", "needShowToast", "onBack", "reportLeavePageEventFromCancel", "setupVoiceMute", "onDestroy", "setupViewPager", "showSingleVoiceToolBar", "initMixVoiceToolBar", "bindToExpand", "Lcom/google/android/material/appbar/AppBarLayout;", "addViewPagerFragment", "children", "tabLayout", "getTabView", "Landroid/widget/TextView;", EasyGoDbTable.Server.NAME, "getTabKey", "canShowMyVoiceTab", "setMuteWrapper", "setupCreateVoiceBtn", "()Lkotlin/Unit;", "setupTitle", "supportBackToPreviousPageWhenClickSave", "requestMixVoiceDetail", "getBotId", "showInvalidVoiceDialog", "getInvalidVoiceList", "onPause", "reportLeavePageEvent", "isCancelLeave", "onDestroyView", "clearViewReferences", "reportSearchStayTime", "showCreateVoiceDialogV2", "clickFrom", "performBack", "buildExitToastConfig", "hasOtherSoundChanges", "ttsBackgroundPlayDirty", "ttsBackgroundPlaySaveSuccess", "mixVoiceEquals", "other", "normalizeMixVoiceForCompare", "Lcom/larus/voice_setting/voice/DoubleTabTtsSpeakerSettingFragment$MixVoiceCompareItem;", "showPendingExitToastIfNeeded", "onResume", "getBotInfo", "ExitToastConfig", "Companion", "MixVoiceCompareItem", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubleTabTtsSpeakerSettingFragment extends TraceFragment {
    public static final List<String> Z = null;
    public int A;
    public List<VoiceListTabInfo> B;
    public final List<String> C;
    public boolean D;
    public boolean E;
    public String F;
    public String G;
    public final boolean H;
    public JSONObject I;
    public String J;
    public com.larus.voice_setting.voice.editvoice.j0 K;
    public ViewPager2 L;
    public TabLayout M;
    public DoubleTabTtsSpeakerSettingFragment$setupViewPager$1$pageChangeCallback$1 N;
    public f0 O;
    public final List<AppBarLayout.OnOffsetChangedListener> P;
    public boolean Q;
    public String R;
    public boolean S;
    public boolean T;
    public final Lazy U;
    public b V;
    public final Lazy W;
    public final w X;
    public final et3.c Y;
    public GetMatchVoiceRequest e;
    public LarusPageDoubleTtsSpeakerSettingBinding f;
    public BotModel g;
    public FragmentExtKt.addOnBackPressed.callback.1 h;
    public boolean i;
    public String j;
    public boolean k;
    public String l;
    public final HashMap<Integer, Fragment> m;
    public SpeakerVoice n;
    public final Lazy o;
    public boolean p;
    public SpeakerVoice q;
    public RecommendFrom r;
    public String s;
    public SearchMobParam t;
    public long u;
    public boolean v;
    public boolean w;
    public String x;
    public String y;
    public int z;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "ExitToastConfig(resId=" + this.a + ", success=" + this.b + ')';
        }

        public b(int r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c {
        public final String a;
        public final String b;
        public final String c;
        public final int d;
        public final boolean e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            int r8 = (((r6 + r1) * 31) + this.d) * 31;
            if (this.e == false) goto L17;
            int r9 = 1231;
        L19:
            return r8 + r9;
        L17:
            r9 = 1237;
            goto L19
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "MixVoiceCompareItem(voiceId=" + this.a + ", styleId=" + this.b + ", languageCode=" + this.c + ", percentage=" + this.d + ", isEnable=" + this.e + ')';
        }

        public c(String r1, String r2, String r3, int r4, boolean r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class d<T> implements Comparator {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            String r4 = ((c) r2).a;
            String r0 = NameKeys.UnloadStrategy_No_Strategy;
            if (r4 != null) goto L5;
            r4 = NameKeys.UnloadStrategy_No_Strategy;
        L5:
            String r5 = ((c) r3).a;
            if (r5 == null) goto L10;
            r0 = r5;
        L10:
            return ComparisonsKt.compareValues(r4, r0);
        }
    }

    public static final class e<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public e(d r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r0 = this.a.compare(r2, r3);
            if (r0 != 0) goto L14;
            String r4 = ((c) r2).b;
            String r1 = NameKeys.UnloadStrategy_No_Strategy;
            if (r4 != null) goto L8;
            r4 = NameKeys.UnloadStrategy_No_Strategy;
        L8:
            String r5 = ((c) r3).b;
            if (r5 == null) goto L13;
            r1 = r5;
        L13:
            return ComparisonsKt.compareValues(r4, r1);
        L14:
            return r0;
        }
    }

    public static final class f<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public f(e r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r0 = this.a.compare(r2, r3);
            if (r0 != 0) goto L14;
            String r4 = ((c) r2).c;
            String r1 = NameKeys.UnloadStrategy_No_Strategy;
            if (r4 != null) goto L8;
            r4 = NameKeys.UnloadStrategy_No_Strategy;
        L8:
            String r5 = ((c) r3).c;
            if (r5 == null) goto L13;
            r1 = r5;
        L13:
            return ComparisonsKt.compareValues(r4, r1);
        L14:
            return r0;
        }
    }

    public static final class g<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public g(f r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r0 = this.a.compare(r2, r3);
            if (r0 == 0) goto L6;
            return r0;
        L6:
            return ComparisonsKt.compareValues(Integer.valueOf(((c) r2).d), Integer.valueOf(((c) r3).d));
        }
    }

    public static final class h<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public h(g r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r0 = this.a.compare(r2, r3);
            if (r0 == 0) goto L6;
            return r0;
        L6:
            return ComparisonsKt.compareValues(Boolean.valueOf(((c) r2).e), Boolean.valueOf(((c) r3).e));
        }
    }

    public static final class i implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public i(Function1 r2) {
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

    public final boolean S90() {
        return false;
    }

    public final String k() {
        return "bot_voice_change";
    }

    static {
        Z = CollectionsKt.listOf(new String[]{"bot_image_setting", "bot_create_page", "bot_update"});
    }

    public final List<MixVoice> V90() {
        SpeakerVoice r0 = this.n;
        if (r0 != null) goto L8;
        BotModel r1 = this.g;
        if (r1 == null) goto L7;
        r0 = r1.getVoiceType();
        goto L8
    L7:
        r0 = null;
    L8:
        SpeakerVoice r2 = r0;
        if (r2 == null) goto L25;
        List r3 = r2.getMixVoiceList();
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == true) goto L19;
        ArrayList r5 = new ArrayList();
        List r6 = r2.getMixVoiceList();
        Intrinsics.checkNotNull(r6);
        r5.addAll(r6);
        return r5;
    L19:
        if (Intrinsics.areEqual(r2.getId(), "0") == true) goto L27;
        return CollectionsKt.listOf(new MixVoice(r2, 100, false, null, 12, null));
    L27:
        return CollectionsKt.emptyList();
    L13:
        if (r3.isEmpty() == true) goto L16;
        r4 = false;
        goto L17
    L25:
        return CollectionsKt.emptyList();
    }

    public final int W90() {
        BotModel r0 = this.g;
        if (r0 == null) goto L6;
        SpeakerVoice r1 = r0.getVoiceType();
        if (r1 == null) goto L6;
    L7:
        int r2 = 1;
        if (Intrinsics.areEqual(this.x, TabKey.MY.getTabKey()) == false) goto L13;
        if (r1 != null) goto L11;
    L12:
        boolean r3 = true;
    L15:
        if (this.v == false) goto L17;
    L21:
        boolean r4 = true;
    L23:
        if (r4 == false) goto L26;
        FLogger.a.i("DoubleTabTtsSpeakerSettingFragment", "[getLandingTabPosition]: landing to my tab, createVoice=" + this.v + ", setLandingMyTab=" + r3);
        return 0;
    L26:
        String r5 = this.x;
        if (r5 == null) goto L29;
        int r6 = ((ArrayList) this.C).indexOf(r5);
    L30:
        if (r6 != (-1)) goto L32;
        r6 = ((ArrayList) this.C).indexOf(TabKey.RECOMMEND.getTabKey());
    L32:
        if (r6 == (-1)) goto L35;
        r2 = r6;
    L35:
        FLogger.a.i("DoubleTabTtsSpeakerSettingFragment", "[getLandingTabPosition]: landingTab=" + this.x + ", resolvedPosition=" + r2 + ", tabKeys=" + this.C);
        return r2;
    L29:
        r6 = -1;
        goto L30
    L17:
        if (X90().isSingleUgcVoice(r1) == true) goto L21;
        if (r3 == true) goto L21;
        r4 = false;
        goto L23
    L11:
        if (Intrinsics.areEqual(r1.getId(), "0") == true) goto L12;
    L13:
        r3 = false;
    L6:
        r1 = this.n;
        goto L7
    }

    public final TtsSpeakerSettingViewModel X90() {
        return (TtsSpeakerSettingViewModel) this.o.getValue();
    }

    public final x2a.h Y90() {
        return (x2a.h) this.U.getValue();
    }

    public final String Z90() {
        com.larus.bmhome.chat.api.e0 r0 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L5;
        LaunchInfo r1 = r0.a;
    L6:
        String r2 = ea0();
        if (AppHost.a.isOversea() == false) goto L21;
        boolean r3 = false;
        if (r1 == null) goto L11;
        boolean r4 = Intrinsics.areEqual(r1.i0(), Boolean.TRUE);
    L12:
        if (r4 == false) goto L22;
        List r5 = r1.v0();
        if (r5 != null) goto L16;
    L18:
        if (r3 == true) goto L23;
        return "en";
    L23:
        return r2;
    L16:
        if (r5.contains(r2) != true) goto L18;
        r3 = true;
        goto L18
    L22:
        return r2;
    L11:
        r4 = false;
        goto L12
    L21:
        return r2;
    L5:
        r1 = null;
        goto L6
    }

    public final void fa0() {
        if (this.p == true) goto L23;
        boolean r0 = true;
        ga0(true, true);
        p2a.q.a().stopAudio();
        p2a.q.a().i();
        SpeakerVoiceEditModel r1 = X90().getSpeakerVoiceEditModel();
        int r2 = SpeakerVoiceEditModel.P;
        BotModel r3 = null;
        r1.q(null, false);
        if (this.i == true) goto L19;
        BotModel r4 = this.g;
        if (r4 != null) goto L9;
    L11:
        r0 = false;
    L12:
        if (r0 == false) goto L14;
        r3 = r4;
    L14:
        if (r3 == null) goto L24;
        TtsSpeakerSettingViewModel r5 = X90();
        SpeakerVoice r6 = this.q;
        if (r6 == null) goto L27;
        r5.updateVoice(r3, r6);
        return;
    L27:
        return;
    L24:
        return;
    L9:
        if (this.q == null) goto L11;
    L19:
        FragmentActivity r7 = getActivity();
        if (r7 == null) goto L26;
        r7.setResult(11, new Intent().putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("select_speaker_result", this.q)})));
        return;
    L26:
        return;
    }

    public final String getBotId() {
        BotModel r0 = this.g;
        if (r0 == null) goto L7;
        String r1 = r0.getBotId();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return this.F;
    }

    public final void ia0() {
        b r0 = this.V;
        if (r0 == null) goto L6;
        final b r2 = new b(r0.a, r0.b);
        this.V = null;
        ((Handler) this.W.getValue()).postDelayed(new t(r2), 300);
        return;
    }

    public final void onDestroyView() {
        DoubleTabTtsSpeakerSettingFragment$setupViewPager$1$pageChangeCallback$1 r0 = this.N;
        if (r0 == null) goto L7;
        ViewPager2 r1 = this.L;
        if (r1 == null) goto L7;
        r1.unregisterOnPageChangeCallback(r0);
    L7:
        this.N = null;
        ViewPager2 r2 = this.L;
        if (r2 == null) goto L10;
        r2.setAdapter(null);
    L10:
        this.L = null;
        f0 r3 = this.O;
        if (r3 == null) goto L15;
        TabLayout r4 = this.M;
        if (r4 == null) goto L15;
        r4.removeOnTabSelectedListener(r3);
    L15:
        this.O = null;
        TabLayout r5 = this.M;
        if (r5 == null) goto L18;
        r5.removeAllTabs();
    L18:
        this.M = null;
        LarusPageDoubleTtsSpeakerSettingBinding r6 = this.f;
        if (r6 == null) goto L27;
        LarusTtsSpeakerContentNewStyleBinding r7 = r6.c;
        if (r7 == null) goto L27;
        Iterator r8 = ((ArrayList) this.P).iterator();
    L24:
        if (r8.hasNext() == false) goto L26;
        AppBarLayout.OnOffsetChangedListener r9 = (AppBarLayout.OnOffsetChangedListener) r8.next();
        r7.b.removeOnOffsetChangedListener(r9);
        goto L24
    L26:
        r7.i.getToggleView().setOnCheckedChangeListener(null);
        r7.e.setVoiceRemoveListener(new a0());
        r7.e.setCollapseCallback(new b0());
    L27:
        ((ArrayList) this.P).clear();
        com.larus.voice_setting.voice.editvoice.j0 r10 = this.K;
        if (r10 == null) goto L67;
        com.larus.voice_setting.voice.editvoice.j0.b r11 = r10.g;
        if (r11 == null) goto L36;
        LarusTtsSpeakerContentNewStyleBinding r12 = r10.c;
        if (r12 == null) goto L36;
        AppBarLayout r13 = r12.b;
        if (r13 == null) goto L36;
        r13.removeOnOffsetChangedListener(r11);
    L36:
        r10.g = null;
        r10.e = null;
        LarusTtsSpeakerContentNewStyleBinding r14 = r10.c;
        if (r14 == null) goto L43;
        SingleVoiceBar r15 = r14.h;
        if (r15 == null) goto L43;
        VoiceSingleView r16 = r15.getVoiceSingleView();
        if (r16 == null) goto L43;
        r16.setListener(null);
    L43:
        LarusTtsSpeakerContentNewStyleBinding r17 = r10.c;
        if (r17 == null) goto L50;
        VoiceEditArea r18 = r17.k;
        if (r18 == null) goto L50;
        VoiceSingleView r19 = r18.getVoiceSingleView();
        if (r19 == null) goto L50;
        r19.setListener(null);
    L50:
        LarusTtsSpeakerContentNewStyleBinding r20 = r10.c;
        if (r20 == null) goto L57;
        VoiceEditArea r21 = r20.k;
        if (r21 == null) goto L57;
        VoiceMixedView r22 = r21.getVoiceMixView();
        if (r22 == null) goto L57;
        r22.setVoiceProportionCallback(new com.larus.voice_setting.voice.editvoice.a());
        r22.setRemoveCallback(new com.larus.voice_setting.voice.editvoice.w());
        r22.setVoiceAuditionCallback(new com.larus.voice_setting.voice.editvoice.c0());
        r22.setVoiceAuditionEndCallback(new com.larus.voice_setting.voice.editvoice.d0());
        r22.setCollapseCallback(new com.larus.voice_setting.voice.editvoice.e0());
        r22.setAudioObserverExtraParamsGetter(new com.larus.voice_setting.voice.editvoice.f0());
        Function0<Unit> r23 = new com.larus.voice_setting.voice.editvoice.g0();
        Intrinsics.checkNotNullParameter(r23, "callback");
        r22.m = r23;
    L57:
        LarusTtsSpeakerContentNewStyleBinding r24 = r10.c;
        if (r24 == null) goto L62;
        VoiceMixBar r25 = r24.e;
        if (r25 == null) goto L62;
        r25.setVoiceRemoveListener(new com.larus.voice_setting.voice.editvoice.h0());
        r25.setCollapseCallback(new com.larus.voice_setting.voice.editvoice.i0());
        Function0 r26 = new com.larus.voice_setting.voice.editvoice.b();
        Intrinsics.checkNotNullParameter(r26, "callback");
        com.larus.utils.e1.d(r25.e.d, new v2a.t(r25, r26));
    L62:
        LarusTtsSpeakerContentNewStyleBinding r27 = r10.c;
        if (r27 == null) goto L67;
        SingleVoiceBar r28 = r27.h;
        if (r28 == null) goto L67;
        Function0 r29 = new com.larus.voice_setting.voice.editvoice.l();
        Intrinsics.checkNotNullParameter(r29, "callback");
        com.larus.utils.e1.d(r28.a.b, new v2a.h(r29));
    L67:
        this.K = null;
        this.m.clear();
        ((ArrayList) this.C).clear();
        this.f = null;
        p2a.q.a().stopAudio();
        p2a.q.a().h();
        p2a.q.a().i();
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final void onPause() {
        Y90().d();
        if (this.t == null) goto L31;
        if (this.u == 0) goto L31;
        long r1 = SystemClock.elapsedRealtime() - this.u;
        BotModel r5 = this.g;
        String r6 = null;
        if (r5 == null) goto L10;
        String r7 = r5.getBotId();
    L11:
        String r8 = this.l;
        SearchMobParam r9 = this.t;
        if (r9 == null) goto L14;
        String r10 = r9.a;
    L15:
        if (r9 == null) goto L17;
        String r11 = r9.b;
    L18:
        if (r9 == null) goto L20;
        String r13 = r9.c;
    L21:
        if (r9 == null) goto L23;
        String r14 = r9.d;
    L24:
        if (r9 == null) goto L26;
        String r15 = r9.e;
    L27:
        if (r9 == null) goto L29;
        r6 = r9.f;
    L29:
        i3.h(r7, r8, Long.valueOf(r1), r10, r11, r6, r13, r14, r15, null, 3136);
        this.u = 0;
        goto L31
    L26:
        r15 = null;
        goto L27
    L23:
        r14 = null;
        goto L24
    L20:
        r13 = null;
        goto L21
    L17:
        r11 = null;
        goto L18
    L14:
        r10 = null;
        goto L15
    L10:
        r7 = null;
    L31:
        if (X90().getShowSelectedVoiceOnTop() == true) goto L33;
        da0(false);
    L33:
        v2a.g.c = -1;
        super/*androidx.fragment.app.Fragment*/.onPause();
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.voice_setting.voice.w] */
    public DoubleTabTtsSpeakerSettingFragment() {
        this.j = NameKeys.UnloadStrategy_No_Strategy;
        this.l = "other";
        this.m = new HashMap();
        final Function0<Fragment> r1 = new DoubleTabTtsSpeakerSettingFragment$special$$inlined$viewModels$default$1(this);
        this.o = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TtsSpeakerSettingViewModel.class), new DoubleTabTtsSpeakerSettingFragment$special$$inlined$viewModels$default$2(r1), new DoubleTabTtsSpeakerSettingFragment$special$$inlined$viewModels$default$3(r1, this));
        this.s = NameKeys.UnloadStrategy_No_Strategy;
        this.y = "slide";
        this.C = new ArrayList();
        boolean r2 = true;
        this.D = true;
        this.F = NameKeys.UnloadStrategy_No_Strategy;
        this.G = NameKeys.UnloadStrategy_No_Strategy;
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L7;
        r3.getAccountService();
        if (com.larus.home.impl.sdk.d.a.a() != true) goto L7;
    L8:
        this.H = r2;
        this.J = NameKeys.UnloadStrategy_No_Strategy;
        this.P = new ArrayList();
        this.U = LazyKt.lazy(LazyThreadSafetyMode.NONE, new com.larus.voice_setting.voice.c());
        this.W = LazyKt.lazy(new n());
        this.X = new w(this);
        this.Y = new et3.c("Pager_TtsSpeakerSetting", false, null);
        return;
    L7:
        r2 = false;
        goto L8
    }

    public final String ea0() {
        if (com.larus.voice_setting.voice.utils.l.a() == false) goto L8;
        if (AppHost.a.isOversea() == false) goto L8;
        String r0 = com.larus.utils.b0.a;
        AppLocaleUtils.a.getClass();
        return com.larus.utils.b0.c(AppLocaleUtils.c());
    L8:
        return this.j;
    }

    public final void onDestroy() {
        Y90().i();
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        FragmentExtKt.addOnBackPressed.callback.1 r0 = this.h;
        if (r0 == null) goto L5;
        r0.remove();
    L5:
        AudioServiceDelegate.a.O().d(SoundsSource.VOICE_TEST);
    }

    public final void onResume() {
        super.onResume();
        View r0 = getView();
        if (r0 == null) goto L6;
        Y90().e(r0);
    L6:
        if (this.t == null) goto L9;
        this.u = SystemClock.elapsedRealtime();
        return;
    }

    public static List ca0(List r9) {
        List r10 = r9;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L19;
        MixVoice r1 = (MixVoice) r11.next();
        SpeakerVoice r2 = r1.getVoiceItem();
        if (r2 == null) goto L8;
        String r4 = r2.getId();
    L9:
        SpeakerVoice r3 = r1.getVoiceItem();
        if (r3 == null) goto L12;
        String r5 = r3.getStyleId();
    L13:
        SpeakerVoice r6 = r1.getVoiceItem();
        if (r6 == null) goto L16;
        String r7 = r6.getLanguageCode();
    L17:
        r0.add(new c(r4, r5, r7, r1.getPercentage(), r1.isEnable()));
        goto L4
    L16:
        r7 = null;
        goto L17
    L12:
        r5 = null;
        goto L13
    L8:
        r4 = null;
        goto L9
    L19:
        return CollectionsKt.sortedWith(r0, new h(new g(new f(new e(new d())))));
    }

    public final String aa0(int r5) {
        if (r5 >= 0) goto L5;
        return null;
    L5:
        if (this.H == false) goto L19;
        if (r5 == 0) goto L34;
        List r1 = this.B;
        if (r1 != null) goto L11;
        r1 = new ArrayList();
    L11:
        int r6 = r5 - this.A;
        if (r6 >= 0) goto L14;
        return null;
    L14:
        if ((!r1.isEmpty()) == true) goto L16;
        return null;
    L16:
        if (r6 < r1.size()) goto L18;
        return null;
    L18:
        return ((VoiceListTabInfo) ListProtector.get(r1, r6)).b();
    L34:
        return "rec_tab";
    L19:
        if (r5 == 0) goto L32;
        if (r5 == 1) goto L43;
        List r2 = this.B;
        if (r2 != null) goto L24;
        r2 = new ArrayList();
    L24:
        int r7 = r5 - this.A;
        if (r7 >= 0) goto L27;
        return null;
    L27:
        if ((!r2.isEmpty()) == true) goto L29;
        return null;
    L29:
        if (r7 < r2.size()) goto L42;
        return null;
    L42:
        return ((VoiceListTabInfo) ListProtector.get(r2, r7)).b();
    L43:
        return "rec_tab";
    L32:
        return "my_tab";
    }

    public final TextView ba0(String r5) {
        ConstraintLayout r0 = LayoutInflater.from(getContext()).inflate(2131562975, null, false);
        if (((TextView) ViewBindings.findChildViewById(r0, 2131388041)) == null) goto L12;
        TextView r1 = (TextView) r0.findViewById(2131388041);
        r1.setText(r5);
        r1.setSingleLine();
        r1.setMaxLines(1);
        if (this.w == true) goto L7;
    L9:
        Intrinsics.checkNotNull(r1);
        return r1;
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        r1.setTextAppearance(2131954380);
        goto L9
    L12:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(2131388041)));
    }

    public final void da0(boolean r27) {
        String r2 = null;
        if (X90().getShowSelectedVoiceOnTop() == false) goto L73;
        String r18 = aa0(this.z);
        w2a.f r1 = X90().getSpeakerVoiceEditModel().g();
        List<MixVoice> r3 = r1.a;
        boolean r4 = false;
        if (r3 == null) goto L7;
        int r5 = r3.size();
    L9:
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        List<MixVoice> r6 = r1.a;
        if (r6 == null) goto L17;
        MixVoice r7 = (MixVoice) ListProtector.get(r6, 0);
        if (r7 == null) goto L17;
        SpeakerVoice r8 = r7.getVoiceItem();
    L19:
        if (r5 <= 1) goto L21;
        w2a.f r9 = r1;
    L23:
        if (r5 != 0) goto L25;
        String r10 = "0";
    L26:
        v2a.g r11 = v2a.g.a;
        String r12 = this.y;
        w2a.c r13 = X90().getSpeakerVoiceEditModel().q;
        int r14 = X90().getSpeakerVoiceEditModel().K.size();
        String r21 = getBotId();
        if (Intrinsics.areEqual(this.l, "bot_create_page") == false) goto L31;
        String r15 = "create";
    L29:
        String r17 = r15;
        if (r27 == true) goto L52;
        SpeakerVoiceEditModel r16 = X90().getSpeakerVoiceEditModel();
        if (r16.e == true) goto L39;
        SpeakerVoice r19 = SpeakerVoiceEditModel.i(r16.H);
        if (r19 == null) goto L44;
        String r110 = r19.getId();
    L45:
        SpeakerVoice r111 = (SpeakerVoice) r16.j.getValue();
        if (r111 == null) goto L48;
        String r112 = r111.getId();
    L50:
        if (Intrinsics.areEqual(r110, r112) == true) goto L52;
    L51:
        r4 = true;
        goto L52
    L48:
        r112 = null;
        goto L50
    L44:
        r110 = null;
        goto L45
    L39:
        if (Intrinsics.areEqual(SpeakerVoiceEditModel.l(r16.I), SpeakerVoiceEditModel.l(r16.n)) == false) goto L51;
    L52:
        SpeakerVoice r113 = X90().getSpeakerVoiceEditModel().H;
        if (r113 == null) goto L55;
        String r114 = r113.getId();
    L56:
        Integer r115 = Integer.valueOf(r14);
        Boolean r23 = Boolean.valueOf(r4);
        Intrinsics.checkNotNullParameter(r12, "method");
        Intrinsics.checkNotNullParameter(r10, "isBestMatch");
        long r24 = (System.currentTimeMillis() - v2a.g.e) / ((long) 1000);
        if (r9 == null) goto L62;
        String r116 = v2a.g.b;
        if (r13 == null) goto L61;
        r2 = r13.b();
    L61:
        String r20 = r2;
        com.larus.voice_setting.voice.base.g1 r22 = com.larus.voice_setting.voice.base.g1.a;
        tx9.q1.a(r115, r10, null, null, null, null, null, Long.valueOf(r24), r116, r12, null, "mixed voice", "1", r23, r17, r18, r114, r20, r21, 25724);
        return;
    L62:
        if (r8 != null) goto L65;
        return;
    L65:
        if (r8.getPrivateStatus() != 1) goto L67;
        String r25 = "1";
    L69:
        if (r8.isUgcVoice() == false) goto L71;
        String r26 = "self_create";
    L72:
        String r28 = r10;
        tx9.q1.a(r115, r28, r25, null, null, r8.getId(), r26, Long.valueOf(r24), v2a.g.b, r12, r8.getStyleId(), r8.getName(), "0", r23, r17, r18, r114, r8.getStyleId(), r21, 24600);
        return;
    L71:
        r26 = LynxUIWebView.DEFAULT;
        goto L72
    L67:
        r25 = "0";
        goto L69
    L55:
        r114 = null;
        goto L56
    L31:
        if (TextUtils.isEmpty(this.G) == true) goto L33;
        r15 = this.G;
        goto L29
    L33:
        r15 = "edit";
        goto L29
    L25:
        r10 = w2a.i.a(r1.a);
        goto L26
    L21:
        r9 = null;
    L17:
        r8 = null;
        goto L19
    L18:
        r8 = this.q;
        goto L19
    L7:
        r5 = 0;
        goto L9
    L73:
        String r29 = (SpeakerVoice) X90().getSpeakerVoiceEditModel().j.getValue();
        if (r29 != null) goto L83;
        BotModel r30 = this.g;
        if (r30 == null) goto L78;
        r2 = r30.getVoiceType();
    L78:
        if (r2 != null) goto L82;
        r29 = this.n;
        if (r29 != null) goto L83;
        r29 = this.q;
        goto L83
    L82:
        r29 = r2;
    L83:
        com.larus.voice_setting.voice.base.g1 r31 = com.larus.voice_setting.voice.base.g1.a;
        com.larus.voice_setting.voice.base.g1.f(r29, this.r, Integer.valueOf(X90().getSpeakerVoiceEditModel().K.size()));
    }

    public final void ha0(String r15) {
        String r0 = l2.a;
        FragmentManager r1 = getChildFragmentManager();
        Context r2 = getContext();
        if (r2 == null) goto L5;
        String r3 = r2.getString(2131911071);
    L6:
        String r4 = this.l;
        String r6 = Z90();
        boolean r8 = this.S;
        String r9 = this.G;
        boolean r10 = this.T;
        String r12 = this.J;
        l2.f(r1, r3, r4, null, null, r6, new s(this), r8, r9, r10, r15, r12, 24);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Y90().g();
        Y90().k("fragment_on_create", new c0(this));
    }

    public final void U90(HashMap<Integer, Fragment> r14, TabLayout r15) {
        boolean r4 = true;
        if (this.H == false) goto L5;
    L56:
        int r0 = 0;
    L57:
        Integer r6 = Integer.valueOf(r0);
        RecommendVoiceListFragment r7 = new RecommendVoiceListFragment();
        Bundle r8 = getArguments();
        if (r8 == null) goto L60;
        Object r9 = r8.clone();
    L62:
        if ((r9 instanceof Bundle) == false) goto L64;
        Bundle r10 = (Bundle) r9;
    L65:
        if (r10 != null) goto L67;
        r10 = new Bundle();
    L67:
        r7.setArguments(r10);
        Bundle r11 = r7.getArguments();
        if (r11 == null) goto L70;
        r11.putString("key_public_voice_scene", VoiceDisplayScene.TTS_LIST_RECOMMEND);
    L70:
        Bundle r12 = r7.getArguments();
        if (r12 == null) goto L73;
        r12.putParcelable("key_voice_recommend_param", this.e);
    L73:
        Bundle r13 = r7.getArguments();
        if (r13 == null) goto L76;
        r13.putString("key_language_code", this.j);
    L76:
        Bundle r16 = r7.getArguments();
        if (r16 == null) goto L79;
        r16.putString("key_tab_name", "rec_tab");
    L79:
        r14.put(r6, r7);
        ((ArrayList) this.C).add(TabKey.RECOMMEND.getTabKey());
        int r1 = r0 + 1;
        TextView r17 = ba0(getString(2131910365));
        TabLayout.Tab r18 = r15.newTab();
        r18.setCustomView(r17);
        r15.addTab(r18);
        this.A = r1;
        r15.setTabMode(0);
        List<VoiceListTabInfo> r19 = this.B;
        if (r19 != null) goto L82;
    L84:
        r4 = false;
    L85:
        if (r4 == true) goto L87;
        return;
    L87:
        if (this.w == false) goto L126;
        List<VoiceListTabInfo> r5 = this.B;
        if (r5 == null) goto L127;
        Iterator<T> r20 = r5.iterator();
    L92:
        if (r20.hasNext() == false) goto L128;
        Parcelable r21 = (VoiceListTabInfo) r20.next();
        String r22 = r21.b();
        if (r22 == null) goto L96;
        ((ArrayList) this.C).add(r22);
    L96:
        Integer r23 = Integer.valueOf(r1);
        MultiTabVoiceListFragment r24 = new MultiTabVoiceListFragment();
        Bundle r25 = getArguments();
        if (r25 == null) goto L99;
        Object r26 = r25.clone();
    L101:
        if ((r26 instanceof Bundle) == false) goto L103;
        Bundle r27 = (Bundle) r26;
    L104:
        if (r27 != null) goto L106;
        r27 = new Bundle();
    L106:
        r24.setArguments(r27);
        Bundle r28 = r24.getArguments();
        if (r28 == null) goto L109;
        r28.putString("key_public_voice_scene", VoiceDisplayScene.TTS_LIST_RECOMMEND);
    L109:
        Bundle r29 = r24.getArguments();
        if (r29 == null) goto L112;
        r29.putParcelable("key_voice_recommend_param", this.e);
    L112:
        Bundle r30 = r24.getArguments();
        if (r30 == null) goto L115;
        r30.putString("key_language_code", this.j);
    L115:
        Bundle r31 = r24.getArguments();
        if (r31 == null) goto L118;
        r31.putString("key_tab_name", r21.b());
    L118:
        Bundle r32 = r24.getArguments();
        if (r32 == null) goto L121;
        r32.putParcelable("key_voice_multi_tab", r21);
    L121:
        r14.put(r23, r24);
        r15.addTab(r15.newTab().setText(r21.c()));
        r1 = r1 + 1;
        goto L92
    L103:
        r27 = null;
        goto L104
    L99:
        r26 = null;
        goto L101
    L128:
        return;
    L127:
        return;
    L126:
        return;
    L82:
        if ((!r19.isEmpty()) != true) goto L84;
    L64:
        r10 = null;
        goto L65
    L60:
        r9 = null;
        goto L62
    L5:
        if (AppHost.a.isOversea() == false) goto L27;
        LaunchInfo r2 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r2 == null) goto L26;
        FeatureConfig r33 = r2.y0();
        if (r33 == null) goto L16;
        FeatureDetail r34 = r33.F0();
        if (r34 == null) goto L16;
        if (r34.b() != true) goto L16;
        boolean r35 = true;
    L17:
        if (r35 == false) goto L26;
        List r3 = r2.d();
        if (r3 != null) goto L21;
    L23:
        boolean r36 = false;
    L24:
        if (r36 == false) goto L26;
    L21:
        if (r3.contains(this.j) != true) goto L23;
        r36 = true;
    L16:
        r35 = false;
    L26:
        boolean r37 = false;
    L28:
        if (r37 == false) goto L56;
        MyVoiceListFragment r38 = new MyVoiceListFragment();
        Bundle r39 = getArguments();
        if (r39 == null) goto L32;
        Object r40 = r39.clone();
    L34:
        if ((r40 instanceof Bundle) == false) goto L36;
        Bundle r41 = (Bundle) r40;
    L37:
        if (r41 != null) goto L39;
        r41 = new Bundle();
    L39:
        r38.setArguments(r41);
        Bundle r42 = r38.getArguments();
        if (r42 == null) goto L42;
        r42.putString("key_my_voice_scene", VoiceDisplayScene.TTS_LIST_MINE);
    L42:
        Bundle r43 = r38.getArguments();
        if (r43 == null) goto L45;
        r43.putString("key_language_code", this.j);
    L45:
        Bundle r44 = r38.getArguments();
        if (r44 == null) goto L52;
        BotModel r45 = this.g;
        if (r45 == null) goto L50;
        String r46 = r45.getBotId();
    L51:
        r44.putString("key_voice_bot_id", r46);
        goto L52
    L50:
        r46 = null;
    L52:
        Bundle r47 = r38.getArguments();
        if (r47 == null) goto L55;
        r47.putString("key_tab_name", "my_tab");
    L55:
        r14.put(0, r38);
        ((ArrayList) this.C).add(TabKey.MY.getTabKey());
        TextView r48 = ba0(getString(2131901036));
        TabLayout.Tab r49 = r15.newTab();
        r49.setCustomView(r48);
        r15.addTab(r49);
        r0 = 1;
        goto L57
    L36:
        r41 = null;
        goto L37
    L32:
        r40 = null;
    L27:
        r37 = true;
        goto L28
    }

    public final void ga0(boolean r4, boolean r5) {
        Context r0 = null;
        if (r4 == false) goto L15;
        this.p = true;
        if (r5 == false) goto L7;
        t19.s.a.g(getContext(), 2131910772, false);
    L7:
        LarusPageDoubleTtsSpeakerSettingBinding r6 = this.f;
        if (r6 == null) goto L24;
        AppCompatImageView r7 = r6.h;
        if (r7 == null) goto L25;
        if (r6 == null) goto L14;
        if (r7 == null) goto L14;
        r0 = r7.getContext();
    L14:
        r7.setImageResource(v19.c.b(2130971896, r0, 2131242314));
        return;
    L25:
        return;
    L24:
        return;
    L15:
        this.p = false;
        LarusPageDoubleTtsSpeakerSettingBinding r8 = this.f;
        if (r8 == null) goto L27;
        AppCompatImageView r9 = r8.h;
        if (r9 == null) goto L28;
        if (r8 == null) goto L22;
        if (r9 == null) goto L22;
        r0 = r9.getContext();
    L22:
        r9.setImageResource(v19.c.b(2130971898, r0, 2131242327));
        return;
    L28:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v55, types: [androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback, com.larus.voice_setting.voice.DoubleTabTtsSpeakerSettingFragment$setupViewPager$1$pageChangeCallback$1] */
    public final void onViewCreated(View r63, Bundle r64) {
        Intrinsics.checkNotNullParameter(r63, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r63, r64);
        Y90().j(r63);
        LarusPageDoubleTtsSpeakerSettingBinding r0 = this.f;
        if (r0 == null) goto L16;
        if (X90().getShowSelectedVoiceOnTop() == false) goto L11;
        r0.j.setVisibility(8);
        LarusPageDoubleTtsSpeakerSettingBinding r1 = this.f;
        if (r1 == null) goto L16;
        LarusTtsSpeakerTitleNewStyleBinding r2 = r1.i;
        if (r2 == null) goto L16;
        r2.a.setVisibility(0);
        com.larus.utils.e1.d(r2.b, new p(this));
        com.larus.utils.e1.d(r2.c, new q(this));
        goto L16
    L11:
        r0.j.setVisibility(0);
        r0.i.a.setVisibility(8);
        com.larus.utils.e1.d(r0.b, new r(this));
        if (this.w == false) goto L14;
        r0.k.setVisibility(0);
        goto L16
    L14:
        r0.k.setVisibility(8);
    L16:
        if (X90().getShowSelectedVoiceOnTop() == false) goto L28;
        Context r3 = getContext();
        LifecycleOwner r4 = getViewLifecycleOwner();
        LarusPageDoubleTtsSpeakerSettingBinding r5 = this.f;
        if (r5 == null) goto L20;
        LarusTtsSpeakerContentNewStyleBinding r6 = r5.c;
    L21:
        com.larus.voice_setting.voice.editvoice.j0 r7 = new com.larus.voice_setting.voice.editvoice.j0(r3, r4, r6, X90().getSpeakerVoiceEditModel());
        this.K = r7;
        r7.a(by7.h.h(this));
        LarusPageDoubleTtsSpeakerSettingBinding r8 = this.f;
        if (r8 == null) goto L36;
        LarusTtsSpeakerContentNewStyleBinding r9 = r8.c;
        if (r9 == null) goto L36;
        CoordinatorLayout r10 = r9.a;
        if (r10 == null) goto L36;
        r10.setVisibility(0);
    L36:
        if (X90().getShowSelectedVoiceOnTop() == false) goto L50;
        X90().loadTtsBackgroundPlaySetting();
        LarusPageDoubleTtsSpeakerSettingBinding r11 = this.f;
        if (r11 == null) goto L50;
        LarusTtsSpeakerContentNewStyleBinding r12 = r11.c;
        if (r12 == null) goto L50;
        final ItemTextToggle r13 = r12.i;
        if (r13 == null) goto L50;
        if (X90().getShowTtsBackgroundPlayToggle() == false) goto L48;
        int r14 = 0;
    L49:
        r13.setVisibility(r14);
        r13.getToggleView().setOnCheckedChangeListener(this.X);
        X90().getTtsBackgroundPlayChecked().observe(getViewLifecycleOwner(), new i(new com.larus.voice_setting.voice.d(r13)));
        goto L50
    L48:
        r14 = 8;
    L50:
        LarusPageDoubleTtsSpeakerSettingBinding r15 = this.f;
        if (r15 == null) goto L67;
        SpeakerVoice r16 = this.n;
        if (r16 == null) goto L56;
        String r17 = r16.getId();
        if (r17 == null) goto L56;
    L63:
        if (Intrinsics.areEqual(r17, "0") == false) goto L65;
        ga0(true, false);
    L66:
        com.larus.utils.e1.d(r15.h, new o(this));
        goto L67
    L65:
        this.p = false;
    L56:
        BotModel r18 = this.g;
        if (r18 == null) goto L61;
        SpeakerVoice r19 = r18.getVoiceType();
        if (r19 == null) goto L61;
        r17 = r19.getId();
    L61:
        r17 = null;
    L67:
        LarusPageDoubleTtsSpeakerSettingBinding r20 = this.f;
        if (r20 == null) goto L140;
        final TabLayout r21 = r20.l;
        if (r21 == null) goto L140;
        ViewPager2 r22 = r20.n;
        if (r22 == null) goto L140;
        LarusTtsSpeakerContentNewStyleBinding r23 = r20.c;
        if (r23 == null) goto L140;
        if (X90().getShowSelectedVoiceOnTop() == false) goto L80;
    L83:
        r22.setVisibility(8);
        r22 = r23.g;
    L84:
        Intrinsics.checkNotNull(r22);
        this.L = r22;
        AppBarLayout r24 = r23.b;
        LarusPageDoubleTtsSpeakerSettingBinding r25 = this.f;
        if (r25 == null) goto L90;
        final LarusTtsSpeakerContentNewStyleBinding r26 = r25.c;
        if (r26 == null) goto L90;
        com.larus.utils.e1.d(r26.e, new com.larus.voice_setting.voice.f(r26, this));
        com.larus.utils.e1.x(r26.j);
        com.larus.utils.e1.q(r26.h);
        VoiceMixBar r27 = r26.e;
        r27.getClass();
        Intrinsics.checkNotNullParameter(r24, "bindToExpand");
        r27.d = r24;
        r24.addOnOffsetChangedListener(new v2a.v(r27));
        r26.e.setVoiceRemoveListener(new com.larus.voice_setting.voice.g(this));
        r26.e.setCollapseCallback(new com.larus.voice_setting.voice.h(this));
    L90:
        if (X90().getShowSelectedVoiceOnTop() == false) goto L113;
        r23.b.setVisibility(0);
        if (X90().isMultiVoiceMixMode() == false) goto L95;
        X90().getSpeakerVoiceEditModel().p(!this.Q);
        g0 r28 = new g0(this);
        r23.b.addOnOffsetChangedListener(r28);
        ((ArrayList) this.P).add(r28);
    L111:
        r21 = r23.f;
    L128:
        Intrinsics.checkNotNull(r21);
        this.M = r21;
        U90(this.m, r21);
        r22.setAdapter(new TtsSpeakerSettingAdapter(this, this.m));
        f0 r29 = new f0(r22, this);
        this.O = r29;
        r21.addOnTabSelectedListener(r29);
        ?? r30 = new DoubleTabTtsSpeakerSettingFragment$setupViewPager$1$pageChangeCallback$1(this, r21);
        this.N = r30;
        r22.registerOnPageChangeCallback(r30);
        int r31 = W90();
        RecyclerView.Adapter r32 = r22.getAdapter();
        if (r32 == null) goto L131;
        int r33 = r32.getItemCount();
    L132:
        if (r33 <= 0) goto L135;
        if (r31 < 0) goto L135;
        if (r31 < r33) goto L138;
        int r34 = r33 - 1;
    L139:
        FLogger.a.i("DoubleTabTtsSpeakerSettingFragment", "[setupViewPager]: initial landingTab=" + this.x + ", landingTabIndex=" + r31 + ", safeLandingTabIndex=" + r34 + ", tabKeys=" + this.C + ", itemCount=" + r33);
        r22.setCurrentItem(r34, false);
        goto L140
    L138:
        r34 = r31;
    L135:
        r34 = 0;
        goto L139
    L131:
        r33 = 0;
        goto L132
    L95:
        if (X90().getSelectVoiceMode() != 2) goto L107;
        LarusPageDoubleTtsSpeakerSettingBinding r35 = this.f;
        if (r35 == null) goto L106;
        final LarusTtsSpeakerContentNewStyleBinding r36 = r35.c;
        if (r36 == null) goto L106;
        CollapsingToolbarLayout.LayoutParams r37 = r36.d.getLayoutParams();
        Intrinsics.checkNotNull(r37, "null cannot be cast to non-null type com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams");
        CollapsingToolbarLayout.LayoutParams r38 = r37;
        r38.setMargins(0, 0, 0, i5.q());
        r36.d.setLayoutParams(r38);
        com.larus.utils.e1.x(r36.j);
        com.larus.utils.e1.x(r36.h);
        com.larus.utils.e1.q(r36.e);
        com.larus.utils.e1.o(r36.k);
        r36.b.setExpanded(false);
        X90().getSpeakerVoiceEditModel().p(true);
        SingleVoiceBar r39 = r36.h;
        View.OnClickListener r40 = new com.larus.voice_setting.voice.i(r36, this);
        r39.getClass();
        Intrinsics.checkNotNullParameter(r40, "expandClickListener");
        View r41 = r39.a.b.getExpandIconView();
        if (r41 == null) goto L103;
        com.larus.utils.e1.x(r41);
    L103:
        View r42 = r39.a.b.getExpandIconView();
        if (r42 == null) goto L106;
        com.larus.utils.e1.c(r42, r40);
    L106:
        h0 r43 = new h0(this, r23);
        r23.b.addOnOffsetChangedListener(r43);
        ((ArrayList) this.P).add(r43);
        goto L111
    L107:
        Toolbar r44 = r23.d;
        if (r44 == null) goto L110;
        com.larus.utils.e1.o(r44);
    L110:
        ViewGroup.LayoutParams r45 = r23.c.getLayoutParams();
        Intrinsics.checkNotNull(r45, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        ViewGroup.LayoutParams r46 = (AppBarLayout.LayoutParams) r45;
        r46.setScrollFlags(0);
        r23.c.setLayoutParams(r46);
        goto L111
    L113:
        if (this.w == false) goto L127;
        CoordinatorLayout r47 = r23.a;
        if (r47 == null) goto L117;
        r47.setVisibility(0);
    L117:
        AppBarLayout r48 = r23.b;
        if (r48 == null) goto L120;
        r48.setVisibility(0);
    L120:
        r23.c.setVisibility(8);
        AppBarLayout.LayoutParams r49 = r23.c.getLayoutParams();
        if ((r49 instanceof AppBarLayout.LayoutParams) == false) goto L123;
        AppBarLayout.LayoutParams r50 = r49;
    L124:
        if (r50 == null) goto L126;
        r50.setScrollFlags(0);
    L126:
        r21 = r23.f;
        goto L128
    L123:
        r50 = null;
        goto L124
    L127:
        r23.b.setVisibility(8);
        goto L128
    L80:
        if (this.w == true) goto L83;
        r23.g.setVisibility(8);
    L140:
        LarusPageDoubleTtsSpeakerSettingBinding r51 = this.f;
        if (r51 != null) goto L143;
    L156:
        X90().getDeleteSelectVoice().observe(getViewLifecycleOwner(), new i(new j(this)));
        X90().getSpeakerVoiceEditModel().j.observe(getViewLifecycleOwner(), new i(new k(this)));
        X90().getVoiceUpdate().observe(getViewLifecycleOwner(), new i(new l(this)));
        X90().getVoiceListTabInfo().observe(getViewLifecycleOwner(), new i(new m(this)));
        Bundle r52 = getArguments();
        if (r52 == null) goto L162;
        if (r52.getBoolean("key_create_voice", false) == false) goto L162;
        int r53 = y2a.a.a;
        JSONObject r54 = new JSONObject();
        r54.put("is_scheme", y2a.b.b(this.T));
        r54.put("enter_method", y2a.b.a(this.G));
        r54.put("click_from", "AutoShow");
        y2a.a.c(r54);
        com.larus.platform.service.i3.j(null, new y(this), new z(this), 1);
    L162:
        if (X90().getShowSelectedVoiceOnTop() == false) goto L211;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoubleTabTtsSpeakerSettingFragment$requestMixVoiceDetail$1(this, null), 3, null);
        Context r55 = getContext();
        if (r55 == null) goto L211;
        SpeakerVoice r56 = this.n;
        if (r56 != null) goto L172;
        BotModel r57 = this.g;
        if (r57 == null) goto L171;
        r56 = r57.getVoiceType();
        goto L172
    L171:
        r56 = null;
    L172:
        if (r56 != null) goto L174;
    L176:
        boolean r58 = false;
    L177:
        String r59 = NameKeys.UnloadStrategy_No_Strategy;
        if (r58 == true) goto L180;
        ArrayList r60 = null;
    L193:
        if (r60 == null) goto L211;
        if (r60.isEmpty() == true) goto L211;
        Iterator r61 = r60.iterator();
    L199:
        if (r61.hasNext() == false) goto L206;
        String r62 = (String) r61.next();
        if (r62.length() <= 0) goto L203;
        boolean r65 = true;
    L204:
        if (r65 == false) goto L199;
        r59 = r59 + '\"' + r62 + "\" ";
        goto L199
    L203:
        r65 = false;
        goto L204
    L206:
        CommonDialog.a r66 = new CommonDialog.a();
        r66.i(r59 + getString(2131907855));
        r66.g(getString(2131907849));
        CommonDialog.a.f(r66, new i0(), getString(2131910485), false, 12);
        r66.w = true;
        CommonDialog r67 = r66.b(ContextCompat.getColor(r55, v19.c.b(2130972123, r55, 2131103203)));
        FragmentManager r68 = getParentFragmentManager();
        LandscapeRestrictionOperation r69 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r67, null, r69);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r68, r67, r69) == true) goto L211;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L233
    L210:
        r67.show(r68, null);
        goto L211
    L180:
        r60 = new ArrayList();
        List r70 = r56.getMixVoiceList();
        if (r70 == null) goto L193;
        Iterator r71 = r70.iterator();
    L184:
        if (r71.hasNext() == false) goto L193;
        MixVoice r72 = (MixVoice) r71.next();
        if (r72.isEnable() == true) goto L184;
        SpeakerVoice r73 = r72.getVoiceItem();
        if (r73 == null) goto L184;
        String r74 = r73.getName();
        if (r74 != null) goto L192;
        r74 = NameKeys.UnloadStrategy_No_Strategy;
    L192:
        r60.add(r74);
        goto L184
    L174:
        if (r56.getConfStatus() != 2) goto L176;
        r58 = true;
    L211:
        String r75 = getBotId();
        if (Intrinsics.areEqual(this.l, "bot_create_page") == false) goto L216;
        String r76 = "create";
    L214:
        String r410 = r76;
        JSONObject r77 = this.I;
        if (r77 != null) goto L222;
        r77 = new JSONObject();
    L222:
        tx9.a1.c(r75, null, null, null, null, null, null, null, r410, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r77, this, null, null, null, null, null, null, null, -1027, -25165825, 7);
        int r78 = y2a.a.a;
        JSONObject r79 = new JSONObject();
        r79.put("enter_method", y2a.b.a(this.G));
        String r110 = getBotId();
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if (r110.length() <= 0) goto L225;
        boolean r111 = true;
    L226:
        if (r111 == true) goto L229;
        r110 = null;
    L229:
        if (r110 != null) goto L231;
        r110 = "unknown";
    L231:
        r79.put("bot_id", r110);
        r79.put("is_scheme", y2a.b.b(this.T));
        Intrinsics.checkNotNullParameter(r79, LynxResourceModule.PARAMS_KEY);
        com.larus.platform.service.g.a.monitorEventForSlardar("voice_settings_scheme_jump_show", r79, null, null);
        com.larus.platform.service.o.a.reportEvent("voice_settings_scheme_jump_show", r79);
        AudioServiceDelegate.a.J("DoubleTabTtsSpeakerSettingFragment");
        return;
    L225:
        r111 = false;
        goto L226
    L216:
        if (TextUtils.isEmpty(this.G) == true) goto L218;
        r76 = this.G;
        goto L214
    L218:
        r76 = "edit";
        goto L214
    L143:
        if (this.k == false) goto L155;
        r51.e.setVisibility(0);
        r51.f.setVisibility(0);
        String r80 = this.l;
        JSONObject r81 = this.I;
        if (r81 != null) goto L147;
        r81 = new JSONObject();
    L147:
        Intrinsics.checkNotNullParameter(r81, LynxResourceModule.PARAMS_KEY);
        r81.put("current_page", "bot_voice_change");     // Catch: JSONException -> L152
        if (r80 == null) goto L154;
        r81.put("previous_page", r80);     // Catch: JSONException -> L152
    L154:
        TrackParams r82 = new TrackParams().merge(r81);
        by7.a r83 = new by7.a("show_create_own_voice_button");
        r83.b = this;
        r83.a.merge(r82);
        r83.b();
        AppCompatTextView r84 = r51.g;
        com.larus.voice_setting.voice.utils.f r85 = com.larus.voice_setting.voice.utils.f.a;
        r84.setText(getString(2131907848));
        r51.g.setVisibility(0);
        com.larus.utils.e1.d(r51.e, new d0(this));
    L152:
        e = move-exception;
        FLogger.a.e("VoiceEventHelper", "error in VoiceEventHelper mobCreateOwnVoiceBtnShow " + e.getLocalizedMessage());
    L155:
        Unit r86 = Unit.INSTANCE;
        goto L156
    L20:
        r6 = null;
        goto L21
    L28:
        LarusPageDoubleTtsSpeakerSettingBinding r87 = this.f;
        if (r87 == null) goto L36;
        LarusTtsSpeakerContentNewStyleBinding r88 = r87.c;
        if (r88 == null) goto L36;
        CoordinatorLayout r89 = r88.a;
        if (r89 == null) goto L36;
        r89.setVisibility(8);
        goto L36
    }

    public final View onCreateView(final LayoutInflater r2, final ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return (View) Y90().k("fragment_create_view", new x(this, r2, r3));
    }
}
