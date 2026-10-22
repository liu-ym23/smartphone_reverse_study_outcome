package com.larus.bmhome.music.widget;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.OnBackPressedDispatcher;
import androidx.collection.LruCache;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.DiffUtil;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.music.databinding.LarusMusicDetailPagerLayoutBinding;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.common_res.common_ui.databinding.LarusFragmentCommonSlideBinding;
import com.larus.common_ui.fragment.CommonSlideDialogFragment;
import com.larus.common_ui.view.CommonSlideRootContainer;
import com.larus.common_ui.view.DotsIndicator;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002aj\u0018\u0000  \u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004 \u0001¡\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010c\u001a\u00020\nH\u0016J\u0006\u0010d\u001a\u00020+J\u0006\u0010e\u001a\u00020$J\u0010\u0010f\u001a\u00020+2\u0006\u0010g\u001a\u00020hH\u0016J\r\u0010i\u001a\u00020jH\u0002¢\u0006\u0002\u0010kJ \u0010l\u001a\u00020+2\u0006\u0010m\u001a\u00020\n2\u0006\u0010n\u001a\u00020\r2\u0006\u0010o\u001a\u00020\rH\u0002J\n\u0010p\u001a\u0004\u0018\u00010\u0010H\u0002J\n\u0010q\u001a\u0004\u0018\u00010\u0010H\u0002J\n\u0010r\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010s\u001a\u00020\r2\b\u0010t\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010u\u001a\u00020+H\u0002J\u0012\u0010s\u001a\u00020\r2\b\u0010v\u001a\u0004\u0018\u00010\rH\u0002J\u001e\u0010w\u001a\u00020+2\u0006\u0010x\u001a\u00020\r2\u0006\u0010y\u001a\u00020\r2\u0006\u0010z\u001a\u00020\nJ\u000e\u0010{\u001a\u00020+2\u0006\u0010y\u001a\u00020\rJ\u001e\u0010|\u001a\u00020+2\u0006\u0010y\u001a\u00020\r2\u0006\u0010x\u001a\u00020\r2\u0006\u0010z\u001a\u00020\nJ\u0012\u0010}\u001a\u00020+2\b\u0010~\u001a\u0004\u0018\u00010YH\u0016J+\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u00012\b\u0010~\u001a\u0004\u0018\u00010YH\u0016J\u000b\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0002H\u0016J\u0013\u0010\u0086\u0001\u001a\u00020+2\b\u0010~\u001a\u0004\u0018\u00010YH\u0016J\u0014\u0010\u0087\u0001\u001a\u00020+2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020+2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0012J\u0013\u0010\u008a\u0001\u001a\u00020\n2\b\u0010t\u001a\u0004\u0018\u00010\u0018H\u0002J\u0013\u0010\u008a\u0001\u001a\u00020\n2\b\u0010v\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u008b\u0001\u001a\u00020\r2\u0007\u0010\u008c\u0001\u001a\u00020\nJ\u001d\u0010\u008d\u0001\u001a\u00020+2\b\u0010\u008e\u0001\u001a\u00030\u0080\u00012\b\u0010~\u001a\u0004\u0018\u00010YH\u0016J\t\u0010\u008f\u0001\u001a\u00020+H\u0016J\t\u0010\u0090\u0001\u001a\u00020+H\u0016J\t\u0010\u0091\u0001\u001a\u00020+H\u0016J\u0007\u0010\u0092\u0001\u001a\u00020+J\u0007\u0010\u0093\u0001\u001a\u00020$J\t\u0010\u0094\u0001\u001a\u00020$H\u0002J\t\u0010\u0095\u0001\u001a\u00020+H\u0002J\t\u0010\u0096\u0001\u001a\u00020+H\u0002J\t\u0010\u0097\u0001\u001a\u00020+H\u0002J\t\u0010\u0098\u0001\u001a\u00020+H\u0002J\t\u0010\u0099\u0001\u001a\u00020$H\u0002J\t\u0010\u009a\u0001\u001a\u00020+H\u0002J\t\u0010\u009b\u0001\u001a\u00020+H\u0002J\"\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u000b\b\u0002\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u00182\u000b\b\u0002\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u001eR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R(\u00106\u001a\u0010\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020+\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010=\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010-\"\u0004\b?\u0010/R\"\u0010@\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010-\"\u0004\bB\u0010/R\"\u0010C\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010-\"\u0004\bE\u0010/R\u001a\u0010F\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010H\"\u0004\bR\u0010JR\u001a\u0010S\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010H\"\u0004\bU\u0010JR\u001a\u0010V\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010&\"\u0004\bW\u0010(R\u001c\u0010X\u001a\u0004\u0018\u00010YX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u000e\u0010^\u001a\u00020_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u00020aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010b¨\u0006¢\u0001"}, d2 = {"Lcom/larus/bmhome/music/widget/MusicDetailPagerFragment;", "Lcom/larus/common_ui/fragment/CommonSlideDialogFragment;", "Lcom/larus/bmhome/music/databinding/LarusMusicDetailPagerLayoutBinding;", "Lcom/larus/bmhome/music/widget/LyricsToSongCardView$IMessageChangeListener;", "<init>", "()V", "binding", "pagerAdapter", "Lcom/larus/bmhome/music/widget/MusicDetailPagerFragment$MusicDetailPagerAdapter;", "currentPosition", "", "creationStatus", "", "", "Lkotlin/Pair;", "fragmentMap", "Lcom/larus/bmhome/music/widget/MusicPlayerDetailFragment;", "bindSongToLyricsMessage", "Lcom/larus/im/bean/message/Message;", "getBindSongToLyricsMessage", "()Lcom/larus/im/bean/message/Message;", "setBindSongToLyricsMessage", "(Lcom/larus/im/bean/message/Message;)V", "initState", "Lcom/larus/im/bean/message/block/MusicCreationContent;", "getInitState", "()Lcom/larus/im/bean/message/block/MusicCreationContent;", "setInitState", "(Lcom/larus/im/bean/message/block/MusicCreationContent;)V", "initMusicPlayerDataState", "Lcom/larus/bmhome/music/player/MusicPlayerData;", "getInitMusicPlayerDataState", "()Lcom/larus/bmhome/music/player/MusicPlayerData;", "setInitMusicPlayerDataState", "(Lcom/larus/bmhome/music/player/MusicPlayerData;)V", "outPullingFinished", "", "getOutPullingFinished", "()Z", "setOutPullingFinished", "(Z)V", "selfDismissed", "Lkotlin/Function0;", "", "getSelfDismissed", "()Lkotlin/jvm/functions/Function0;", "setSelfDismissed", "(Lkotlin/jvm/functions/Function0;)V", "bindShareContainer", "Landroid/widget/FrameLayout;", "getBindShareContainer", "()Landroid/widget/FrameLayout;", "setBindShareContainer", "(Landroid/widget/FrameLayout;)V", "useTemplateCallback", "Lkotlin/Function1;", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "getUseTemplateCallback", "()Lkotlin/jvm/functions/Function1;", "setUseTemplateCallback", "(Lkotlin/jvm/functions/Function1;)V", "onAppletBackgroundPlaybackHandoff", "getOnAppletBackgroundPlaybackHandoff", "setOnAppletBackgroundPlaybackHandoff", "musicAppletNavigateBack", "getMusicAppletNavigateBack", "setMusicAppletNavigateBack", "musicAppletCanNavigateBack", "getMusicAppletCanNavigateBack", "setMusicAppletCanNavigateBack", "musicAppletShareIconResId", "getMusicAppletShareIconResId", "()I", "setMusicAppletShareIconResId", "(I)V", "enterFrom", "getEnterFrom", "()Ljava/lang/String;", "setEnterFrom", "(Ljava/lang/String;)V", "initProgress", "getInitProgress", "setInitProgress", "slideDirection", "getSlideDirection", "setSlideDirection", "isMusicAppletDetail", "setMusicAppletDetail", "musicAppletLaunchArguments", "Landroid/os/Bundle;", "getMusicAppletLaunchArguments", "()Landroid/os/Bundle;", "setMusicAppletLaunchArguments", "(Landroid/os/Bundle;)V", "musicAppletDetailEnterTime", "", "appletLifecycleCallback", "com/larus/bmhome/music/widget/MusicDetailPagerFragment$appletLifecycleCallback$1", "Lcom/larus/bmhome/music/widget/MusicDetailPagerFragment$appletLifecycleCallback$1;", "getFeedDirection", "tryUpdateReadyPlaylist", "canResumeMusicAppletPlayback", "dispatchContainerEvent", "event", "Lcom/larus/common_ui/fragment/CommonSlideDialogFragment$ContainerEvent;", "onPageChangeCallback", "com/larus/bmhome/music/widget/MusicDetailPagerFragment$onPageChangeCallback$1", "()Lcom/larus/bmhome/music/widget/MusicDetailPagerFragment$onPageChangeCallback$1;", "reportEnterMusicDetail", "pos", "enterMethod", "slideStatus", "getPreFragment", "getCurrentFragment", "getNextFragment", "getCurrentCreationId", "state", "pauseCurrentPlayerForAppletBackground", "itemId", "updateCreationPrivacy", "creationId", "taskId", "privacy", "deleteCreation", "addCreation", "onCreate", "savedInstanceState", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViewBinding", "initView", "onMessageChange", "message", "updateCreationStatus", "getCurrentButtonStatus", "getCurrentStatus", "pagerPos", "onViewCreated", "view", "onResume", "onDestroyView", "onDestroy", "applyMusicAppletDetailStyle", "navigateBackInMusicApplet", "fallbackNavigateBackByActivity", "applyMusicAppletBackButtonStyle", "applyMusicAppletShareButtonStyle", "applyMusicAppletChromeStaticMargin", "updateMusicAppletBackButtonVisibility", "canNavigateBackInMusicApplet", "reportMusicAppletDetailPageEnter", "reportMusicAppletDetailPageExit", "buildMusicAppletMobContext", "Lcom/larus/bmhome/music/mob/MusicAppletMobContext;", "musicContent", "playerData", "Companion", "MusicDetailPagerAdapter", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicDetailPagerFragment extends CommonSlideDialogFragment<LarusMusicDetailPagerLayoutBinding> implements LyricsToSongCardView.b {
    public static final /* synthetic */ int F = 0;
    public int A;
    public boolean B;
    public Bundle C;
    public long D;
    public final b E;
    public LarusMusicDetailPagerLayoutBinding i;
    public MusicDetailPagerAdapter j;
    public int k;
    public Map<String, Pair<String, Integer>> l;
    public final Map<String, MusicPlayerDetailFragment> m;
    public Message n;
    public MusicCreationContent o;
    public com.larus.bmhome.music.player.j p;
    public boolean q;
    public Function0<Unit> r;
    public FrameLayout s;
    public Function1<? super bq8.a, Unit> t;
    public Function0<Boolean> u;
    public Function0<Boolean> v;
    public Function0<Boolean> w;
    public int x;
    public String y;
    public int z;

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 12\u00020\u0001:\u0003012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0012J\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0012J\u0006\u0010\u001f\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u001bJ\u001a\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u0012H\u0002J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0018H\u0002J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u0018H\u0002J4\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010*\u001a\u00020\u00182\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\tH\u0002J\u0010\u0010/\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u00063"}, d2 = {"Lcom/larus/bmhome/music/widget/MusicDetailPagerFragment$MusicDetailPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "playerAbility", "Lcom/larus/bmhome/music/widget/MusicDetailPagerFragment$MusicDetailPagerAdapter$PlayerAbilityProvider;", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/larus/bmhome/music/widget/MusicDetailPagerFragment$MusicDetailPagerAdapter$PlayerAbilityProvider;)V", "firstInit", "", "realList", "", "Lcom/larus/bmhome/music/bean/MusicContent;", "getRealList", "()Ljava/util/List;", "setRealList", "(Ljava/util/List;)V", "value", "", "initPosition", "getInitPosition", "()I", "getItemCount", "getCurrentCreation", "Lcom/larus/im/bean/message/block/MusicCreationContent;", "pos", "updateClickStatus", "", "clickFromPrevious", "clickFromNext", "position", "tryUpdateReadyPlaylist", "updateReadyPlaylist", "addNodesAfter", "node", "count", "addNodesBefore", "getMusicContentByCreationContent", "content", "buildNewMusicPlayState", "Lcom/larus/bmhome/music/player/MusicPlayerData;", "previousState", "musicContentState", "musicMessage", "Lcom/larus/im/bean/message/Message;", "next", "previous", "createFragment", "DiffCallback", "Companion", "PlayerAbilityProvider", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MusicDetailPagerAdapter extends FragmentStateAdapter {
        public final Fragment a;
        public boolean b;
        public final List<jr8.a> c;
        public int d;

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/music/widget/MusicDetailPagerFragment$MusicDetailPagerAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/bmhome/music/bean/MusicContent;", "newItems", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class DiffCallback extends DiffUtil.Callback {
            public final List<jr8.a> a;
            public final List<jr8.a> b;

            public final boolean areContentsTheSame(int r1, int r2) {
                if (r1 != r2) goto L4;
                return true;
            L4:
                return false;
            }

            public final boolean areItemsTheSame(int r1, int r2) {
                if (r1 != r2) goto L4;
                return true;
            L4:
                return false;
            }

            public final int getNewListSize() {
                return this.b.size();
            }

            public final int getOldListSize() {
                return this.a.size();
            }

            public DiffCallback(List<jr8.a> r2, List<jr8.a> r3) {
                Intrinsics.checkNotNullParameter(r2, "oldItems");
                Intrinsics.checkNotNullParameter(r3, "newItems");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class a {
        }

        static {
        }

        public final void B2() {
            FLogger r0 = FLogger.a;
            r0.d("TemplateImagePagerFragment", "[tryUpdateReadyPlaylist]");
            ArrayList r2 = new ArrayList();
            r2.addAll(this.c);
            jr8.a r3 = (jr8.a) CollectionsKt.lastOrNull(this.c);
            if (r3 == null) goto L11;
            MusicCreationContent r4 = r3.b;
            if (r4 == null) goto L11;
            ad9.b r5 = r4.getPlayList();
            if (r5 == null) goto L11;
            if (r5.getHasNext() == true) goto L11;
            boolean r6 = true;
        L12:
            if (r6 == false) goto L15;
            r0.d("TemplateImagePagerFragment", "[tryUpdateReadyPlaylist] ignore");
            return;
        L15:
            jr8.a r7 = (jr8.a) CollectionsKt.lastOrNull(this.c);
            if (r7 == null) goto L28;
            MusicCreationContent r8 = r7.b;
            if (r8 == null) goto L29;
            y2(this, r8);
            r0.d("TemplateImagePagerFragment", "[tryUpdateReadyPlaylist] trigger updateReadyPlaylist");
            DiffUtil.calculateDiff(new DiffCallback(r2, this.c)).dispatchUpdatesTo(this);     // Catch: Exception -> L23
            return;
        L23:
            e = move-exception;
            FLogger.a.e("TemplateImagePagerFragment", "diffResult.dispatchUpdatesTo error e=" + e.getMessage());
            return;
        L29:
            return;
        L28:
            return;
        L11:
            r6 = false;
            goto L12
        }

        public final int getItemCount() {
            return ((ArrayList) this.c).size();
        }

        public final jr8.a A2(MusicCreationContent r36) {
            MusicDetailPagerFragment r2 = this.a;
            boolean r3 = r2 instanceof MusicDetailPagerFragment;
            kr8.o r4 = null;
            if (r3 == false) goto L5;
            MusicDetailPagerFragment r5 = r2;
        L6:
            if (r5 == null) goto L8;
            com.larus.bmhome.music.player.j r6 = r5.p;
        L9:
            if (r3 == false) goto L11;
            MusicDetailPagerFragment r7 = r2;
        L12:
            if (r7 == null) goto L14;
            Message r32 = r7.n;
        L16:
            if (r32 == null) goto L21;
            String r8 = r32.getMessageId();
            if (r8 == null) goto L21;
            String r9 = r8;
        L22:
            if (r32 == null) goto L27;
            String r10 = r32.getConversationId();
            if (r10 == null) goto L27;
            String r11 = r10;
        L28:
            if (r6 == null) goto L33;
            String r12 = r6.d();
            if (r12 == null) goto L33;
            String r13 = r12;
        L34:
            if (r6 == null) goto L39;
            String r14 = r6.k();
            if (r14 == null) goto L39;
            String r15 = r14;
        L40:
            Fragment r16 = this.a;
            if (r16 == null) goto L43;
            CoroutineScope r17 = LifecycleOwnerKt.getLifecycleScope(r16);
        L44:
            if (r6 == null) goto L46;
            String r20 = r6.c;
        L47:
            String r18 = r36.getVid();
            String r19 = r36.getVideoModel();
            if (r19 != null) goto L50;
            String r110 = "";
        L51:
            LruCache<String, wc9.e> r21 = ko8.a.a;
            String r24 = ko8.a.e(ko8.a.e);
            String r22 = r36.getTitle();
            if (r22 != null) goto L54;
            String r25 = "";
        L55:
            String r23 = r36.getChunkUrl();
            if (r23 != null) goto L58;
            String r26 = "";
        L59:
            ad9.b r29 = r36.getPlayList();
            boolean r27 = r36 instanceof bq8.a;
            MusicDetailPagerFragment r28 = this.a;
            boolean r30 = r28 instanceof MusicDetailPagerFragment;
            if (r30 == false) goto L62;
            MusicDetailPagerFragment r111 = r28;
        L63:
            if (r111 == null) goto L67;
            boolean r112 = true;
            if (r111.B != true) goto L67;
        L68:
            if (r112 == false) goto L75;
            if (r30 == false) goto L71;
            MusicDetailPagerFragment r31 = r28;
        L72:
            if (r31 == null) goto L75;
            r4 = r31.oa0(r36, r6);
            goto L75
        L71:
            r31 = null;
        L75:
            return new jr8.a(new com.larus.bmhome.music.player.j(r9, r11, r13, r15, "", -1, r110, r18, true, true, r17, 30, r20, r4, "chat", true, r24, r25, r26, r27, false, r29, false, false, r32, null, 34603008), r36);
        L67:
            r112 = false;
            goto L68
        L62:
            r111 = null;
            goto L63
        L58:
            r26 = r23;
            goto L59
        L54:
            r25 = r22;
            goto L55
        L50:
            r110 = r19;
            goto L51
        L46:
            r20 = null;
            goto L47
        L43:
            r17 = null;
        L39:
            r15 = "";
        L33:
            r13 = "";
        L27:
            r11 = "";
        L21:
            r9 = "";
            goto L22
        L14:
            r32 = null;
            goto L16
        L11:
            r7 = null;
            goto L12
        L8:
            r6 = null;
            goto L9
        L5:
            r5 = null;
            goto L6
        }

        public final Fragment createFragment(int r34) {
            jr8.a r2 = (jr8.a) ListProtector.get(this.c, r34);
            MusicDetailPagerFragment r3 = this.a;
            MusicCreationContent r14 = null;
            if ((r3 instanceof MusicDetailPagerFragment) == false) goto L5;
            MusicDetailPagerFragment r4 = r3;
        L6:
            if (r4 == null) goto L8;
            Message r5 = r4.n;
        L9:
            if (r2 == null) goto L13;
            com.larus.bmhome.music.player.j r15 = r2.a;
            if (r15 == null) goto L13;
            com.larus.bmhome.music.player.j r6 = com.larus.bmhome.music.player.j.a(r15, null, null, false, false, null, 0, null, "music_detail", true, null, null, null, false, false, null, 67059711);
        L14:
            if (r2 == null) goto L16;
            MusicCreationContent r7 = r2.b;
        L17:
            int r16 = 0;
            if (this.d == r34) goto L20;
        L27:
            int r8 = 0;
        L28:
            MusicDetailPagerFragment r1 = this.a;
            if ((r1 instanceof MusicDetailPagerFragment) == false) goto L31;
            MusicDetailPagerFragment r9 = r1;
        L32:
            if (r9 == null) goto L34;
            boolean r10 = r9.q;
        L35:
            MusicDetailPagerFragment r11 = this.a;
            if ((r11 instanceof MusicDetailPagerFragment) == false) goto L38;
            MusicDetailPagerFragment r12 = r11;
        L39:
            if (r12 == null) goto L41;
            FrameLayout r13 = r12.s;
        L42:
            WeakReference r17 = new WeakReference(r13);
            MusicDetailPagerFragment r18 = this.a;
            boolean r19 = r18 instanceof MusicDetailPagerFragment;
            if (r19 == false) goto L45;
            MusicDetailPagerFragment r110 = r18;
        L46:
            if (r110 == null) goto L48;
            Function1<? super bq8.a, Unit> r111 = r110.t;
        L49:
            if (r19 == true) goto L51;
        L51:
            if (r19 == false) goto L53;
            MusicDetailPagerFragment r112 = r18;
        L54:
            if (r112 == null) goto L56;
            boolean r113 = r112.B;
        L57:
            if (r19 == false) goto L59;
            MusicDetailPagerFragment r20 = r18;
        L60:
            if (r20 == null) goto L62;
            int r114 = r20.A;
        L63:
            MusicPlayerDetailFragment r115 = new MusicPlayerDetailFragment(r5, r6, r7, r8, r10, r17, r111, r113, r114);
            MusicDetailPagerFragment r21 = this.a;
            if ((r21 instanceof MusicDetailPagerFragment) == false) goto L66;
            MusicDetailPagerFragment r22 = r21;
        L67:
            if (r22 == null) goto L72;
            if (r2 == null) goto L70;
            MusicCreationContent r23 = r2.b;
        L71:
            int r24 = MusicDetailPagerFragment.F;
            r16 = r22.ra0(a.b(r23));
            goto L72
        L70:
            r23 = null;
        L72:
            r115.D = r16;
            MusicDetailPagerFragment r25 = this.a;
            if ((r25 instanceof MusicDetailPagerFragment) == false) goto L75;
            MusicDetailPagerFragment r26 = r25;
        L76:
            if (r26 == null) goto L81;
            if (r2 == null) goto L79;
            MusicCreationContent r27 = r2.b;
        L80:
            int r28 = MusicDetailPagerFragment.F;
            String r29 = r26.sa0(a.b(r27));
        L82:
            Intrinsics.checkNotNullParameter(r29, "<set-?>");
            r115.E = r29;
            MusicDetailPagerFragment r30 = this.a;
            if ((r30 instanceof MusicDetailPagerFragment) == false) goto L85;
            MusicDetailPagerFragment r31 = r30;
        L86:
            if (r31 == null) goto L93;
            Map<String, MusicPlayerDetailFragment> r32 = r31.m;
            if (r32 == null) goto L93;
            int r33 = MusicDetailPagerFragment.F;
            if (r2 == null) goto L92;
            r14 = r2.b;
        L92:
            MusicPlayerDetailFragment r35 = r32.put(a.b(r14), r115);
        L93:
            return r115;
        L85:
            r31 = null;
            goto L86
        L79:
            r27 = null;
            goto L80
        L81:
            r29 = "";
            goto L82
        L75:
            r26 = null;
            goto L76
        L66:
            r22 = null;
            goto L67
        L62:
            r114 = 0;
            goto L63
        L59:
            r20 = null;
            goto L60
        L56:
            r113 = false;
            goto L57
        L53:
            r112 = null;
            goto L54
        L48:
            r111 = null;
            goto L49
        L45:
            r110 = null;
            goto L46
        L41:
            r13 = null;
            goto L42
        L38:
            r12 = null;
            goto L39
        L34:
            r10 = false;
            goto L35
        L31:
            r9 = null;
            goto L32
        L20:
            if (this.b == false) goto L27;
            this.b = false;
            MusicDetailPagerFragment r36 = this.a;
            if ((r36 instanceof MusicDetailPagerFragment) == false) goto L24;
            MusicDetailPagerFragment r37 = r36;
        L25:
            if (r37 == null) goto L27;
            r8 = r37.z;
            goto L28
        L24:
            r37 = null;
            goto L25
        L16:
            r7 = null;
        L13:
            r6 = null;
            goto L14
        L8:
            r5 = null;
            goto L9
        L5:
            r4 = null;
            goto L6
        }

        public final MusicCreationContent z2(int r2) {
            if (r2 >= 0) goto L4;
            return null;
        L4:
            if (r2 < ((ArrayList) this.c).size()) goto L7;
            return null;
        L7:
            return ((jr8.a) ListProtector.get(this.c, r2)).b;
        }

        public MusicDetailPagerAdapter(Fragment r6, c r7) {
            Intrinsics.checkNotNullParameter(r6, "fragment");
            Intrinsics.checkNotNullParameter(r7, "playerAbility");
            super(r6);
            this.a = r6;
            this.b = true;
            ArrayList r8 = new ArrayList();
            this.c = r8;
            FLogger r0 = FLogger.a;
            r0.d("TemplateImagePagerFragment", "[updateReadyPlaylist]");
            ArrayList r2 = new ArrayList();
            r2.addAll(r8);
            r8.clear();
            MusicCreationContent r9 = r7.a.o;
            if (r9 == null) goto L16;
            r0.d("TemplateImagePagerFragment", "[addNodesBefore]");
            MusicCreationContent r10 = r9;
        L7:
            if (r10.getPlayList().getHasPrevious() == false) goto L11;
            FLogger r1 = FLogger.a;
            r1.d("TemplateImagePagerFragment", "[addNodesBefore while]");
            r10 = r10.getPlayList().d();
            if (r10 == null) goto L11;
            r1.d("TemplateImagePagerFragment", "[addNodesBefore while] take list " + r10.getPlayList().a() + " item " + r10.getPlayList().getItemId());
            ListProtector.add(this.c, 0, A2(r10));
        L11:
            this.d = ((ArrayList) this.c).size();
            ((ArrayList) this.c).add(A2(r9));
            y2(this, r9);
            DiffUtil.calculateDiff(new DiffCallback(r2, this.c)).dispatchUpdatesTo(this);     // Catch: Exception -> L14
        L14:
            e = move-exception;
            FLogger.a.e("TemplateImagePagerFragment", "diffResult.dispatchUpdatesTo error e=" + e.getMessage());
        L16:
            FLogger.a.i("TemplateImagePagerFragment", "[PlaylistViewPagerAdapter init]");
        }

        public static void y2(MusicDetailPagerAdapter r5, MusicCreationContent r6) {
            r5.getClass();
            FLogger.a.d("TemplateImagePagerFragment", "[addNodesAfter]");
            int r0 = 0;
        L4:
            if (r6.getPlayList().getHasNext() == false) goto L15;
            if (r0 >= Integer.MAX_VALUE) goto L20;
            FLogger r1 = FLogger.a;
            r1.d("TemplateImagePagerFragment", "[addNodesAfter while]");
            r6 = r6.getPlayList().getNext();
            if (r6 == null) goto L21;
            if (com.larus.utils.o0.d(r6.getVideoModel()) == true) goto L13;
            r6 = null;
        L13:
            if (r6 == null) goto L22;
            ((ArrayList) r5.c).add(r5.A2(r6));
            r0 = r0 + 1;
            r1.i("TemplateImagePagerFragment", "[addNodesAfter] add [" + r6.getVid() + "] addedCount=" + r0);
            goto L4
        L22:
            return;
        L21:
            return;
        L20:
            return;
        }

        public final void C2(boolean r2, boolean r3, int r4) {
            if (r4 >= 0) goto L4;
            return;
        L4:
            if (r4 >= ((ArrayList) this.c).size()) goto L9;
            com.larus.bmhome.music.player.j r5 = ((jr8.a) ListProtector.get(this.c, r4)).a;
            r5.i = r2;
            r5.h = r3;
            return;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: com.larus.bmhome.music.widget.MusicDetailPagerFragment$a$a, reason: collision with other inner class name */
        public static final class C0029a<T> implements Comparator {
            public C0029a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T r1, T r2) {
                return ComparisonsKt.compareValues((String) r1, (String) r2);
            }
        }

        public static Map a(String r7) {
            Intrinsics.checkNotNullParameter(r7, "creationStatusInfo");
            LinkedHashMap r0 = new LinkedHashMap();
            JSONObject r1 = new JSONObject(r7);     // Catch: Exception -> L16
            ArrayList r8 = new ArrayList();     // Catch: Exception -> L16
            Iterator<String> r2 = r1.keys();     // Catch: Exception -> L16
        L5:
            if (r2.hasNext() == false) goto L8;
            r8.add(r2.next());     // Catch: Exception -> L16
            goto L5
        L8:
            if (r8.size() <= 1) goto L10;
            CollectionsKt.sortWith(r8, new C0029a());     // Catch: Exception -> L16
        L10:
            Iterator r9 = r8.iterator();     // Catch: Exception -> L16
        L11:
            if (r9.hasNext() == false) goto L15;
            String r3 = (String) r9.next();     // Catch: Exception -> L16
            JSONObject r4 = new JSONObject(r1.optString(r3));     // Catch: Exception -> L16
            r0.put(r3, new Pair(r4.optString("creation_id"), Integer.valueOf(r4.optInt("private_status"))));     // Catch: Exception -> L16
            goto L11
        L15:
            return r0;
        L16:
            e = move-exception;
            FLogger.a.e("MusicPlayerDetailFragment", "There have something wrong when parse!!!e=" + e.getMessage());
            return r0;
        }

        public static String b(MusicCreationContent r2) {
            if (r2 == null) goto L6;
            boolean r1 = true;
            if (r2.isBlock() != true) goto L6;
        L7:
            if (r1 == false) goto L12;
            String r3 = r2.getUniqueTaskId();
            if (r3 != null) goto L26;
            return "";
        L26:
            return r3;
        L12:
            if (r2 == null) goto L16;
            ad9.b r0 = r2.getPlayList();
            if (r0 == null) goto L16;
            String r4 = r0.getItemId();
        L18:
            if (com.larus.utils.o0.d(r4) == false) goto L24;
            if (r2 == null) goto L24;
            ad9.b r5 = r2.getPlayList();
            if (r5 == null) goto L24;
            String r6 = r5.getItemId();
            if (r6 == null) goto L24;
            return r6;
        L24:
            return TriggerSendLoading.NO_LOADING;
        L16:
            r4 = null;
        L6:
            r1 = false;
            goto L7
        }
    }

    public static final class b implements ir8.c.a {
        public final /* synthetic */ MusicDetailPagerFragment a;

        @Override // ir8.c.a
        public final void a() {
            Intrinsics.checkNotNullParameter(MusicAppletPage.APP_ID, "appId");
            if (this.a.B == true) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(MusicAppletPage.APP_ID, MusicAppletPage.APP_ID) == true) goto L8;
            return;
        L8:
            if (ir8.c.a(this) == false) goto L10;
            this.a.xa0();
        L10:
            MusicDetailPagerFragment r0 = this.a;
            r0.getClass();
            FLogger r1 = FLogger.a;
            r1.i("TemplateImagePagerFragment", "pause current player for applet background");
            MusicPlayerDetailFragment r3 = r0.ta0();
            Function0<Boolean> r2 = r0.u;
            if (r2 != null) goto L13;
        L15:
            boolean r4 = false;
        L16:
            if (r4 == false) goto L24;
            if (r3 != null) goto L19;
        L23:
            r1.i("TemplateImagePagerFragment", "applet background playback handoff consumed");
            return;
        L19:
            if (r3.t == true) goto L23;
            if (r3.k == false) goto L23;
            r3.m.c();
            goto L23
        L24:
            if (r3 != null) goto L26;
            return;
        L26:
            if (r3.t == true) goto L34;
            r1.i("MusicPlayerDetailFragment", "pause for applet background");
            r3.m.k(true);
            return;
        L34:
            return;
        L13:
            if (((Boolean) r2.invoke()).booleanValue() != true) goto L15;
            r4 = true;
            goto L16
        }

        public b(MusicDetailPagerFragment r1) {
            this.a = r1;
        }
    }

    public static final class c {
        public final /* synthetic */ MusicDetailPagerFragment a;

        public c(MusicDetailPagerFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void ma0() {
        LarusFragmentCommonSlideBinding r0 = ((CommonSlideDialogFragment) this).d;
        if (r0 == null) goto L11;
        ImageView r1 = r0.b;
        if (r1 == null) goto L12;
        r1.setImageResource(2131241608);
        r1.setBackgroundResource(2131239328);
        r1.setPadding(i5.v0(), i5.v0(), i5.v0(), i5.v0());
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L10;
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
        r3.width = i5.W();
        r3.height = i5.W();
        r3.setMarginStart(i5.h());
        com.larus.utils.i0.a.getClass();
        r3.topMargin = com.larus.utils.i0.g() + i5.Y();
        r1.setLayoutParams(r3);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L12:
        return;
    }

    public final void na0() {
        if (this.B == true) goto L5;
        return;
    L5:
        LarusFragmentCommonSlideBinding r0 = ((CommonSlideDialogFragment) this).d;
        int r1 = 8;
        if (r0 == null) goto L10;
        ImageView r2 = r0.f;
        if (r2 == null) goto L10;
        r2.setVisibility(8);
    L10:
        ma0();
        Integer r3 = Integer.valueOf(this.x);
        boolean r4 = true;
        if (r3.intValue() == 0) goto L13;
        boolean r5 = true;
    L14:
        View r6 = null;
        if (r5 == true) goto L19;
        r3 = null;
    L19:
        if (r3 == null) goto L29;
        int r7 = r3.intValue();
        LarusFragmentCommonSlideBinding r8 = ((CommonSlideDialogFragment) this).d;
        if (r8 == null) goto L29;
        ImageView r9 = r8.g;
        if (r9 == null) goto L29;
        r9.setImageResource(r7);
        r9.setBackgroundResource(2131239328);
        r9.setPadding(i5.v0(), i5.v0(), i5.v0(), i5.v0());
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if (r10 == null) goto L28;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
        r11.width = i5.W();
        r11.height = i5.W();
        com.larus.utils.i0.a.getClass();
        r11.topMargin = com.larus.utils.i0.g() + i5.Y();
        r9.setLayoutParams(r11);
        goto L29
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L29:
        LarusFragmentCommonSlideBinding r12 = ((CommonSlideDialogFragment) this).d;
        if (r12 == null) goto L34;
        ImageView r13 = r12.g;
        if (r13 == null) goto L34;
        ViewParent r14 = r13.getParent();
    L36:
        if ((r14 instanceof View) == false) goto L38;
        r6 = (View) r14;
    L38:
        if (r6 == null) goto L44;
        ViewGroup.LayoutParams r15 = r6.getLayoutParams();
        if (r15 == null) goto L43;
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        r16.setMarginEnd(((Number) i5.E0.getValue()).intValue());
        r6.setLayoutParams(r16);
        goto L44
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L44:
        LarusFragmentCommonSlideBinding r17 = ((CommonSlideDialogFragment) this).d;
        if (r17 == null) goto L49;
        ImageView r18 = r17.b;
        if (r18 == null) goto L49;
        com.larus.utils.e1.d(r18, new o0(this));
    L49:
        LarusFragmentCommonSlideBinding r19 = ((CommonSlideDialogFragment) this).d;
        if (r19 == null) goto L54;
        CommonSlideRootContainer r20 = r19.e;
        if (r20 == null) goto L54;
        r20.setDismissCallback(new p0(this));
    L54:
        Function0<Boolean> r21 = this.w;
        if (r21 != null) goto L57;
    L59:
        r4 = false;
    L60:
        LarusFragmentCommonSlideBinding r22 = ((CommonSlideDialogFragment) this).d;
        if (r22 == null) goto L67;
        ImageView r23 = r22.b;
        if (r23 == null) goto L67;
        if (r4 == false) goto L66;
        r1 = 0;
    L66:
        r23.setVisibility(r1);
    L67:
        if (r4 == false) goto L70;
        ma0();
        return;
    L70:
        return;
    L57:
        if (((Boolean) r21.invoke()).booleanValue() != true) goto L59;
    L34:
        r14 = null;
        goto L36
    L13:
        r5 = false;
        goto L14
    }

    public final void onDestroy() {
        CopyOnWriteArraySet<ir8.c.a> r0 = ir8.c.a;
        ir8.c.c(this.E);
        super.onDestroy();
        com.larus.bmhome.music.player.b.a.getClass();
        com.larus.bmhome.music.player.b.a.g = true;
        com.larus.bmhome.music.player.b.a.h = false;
        com.larus.bmhome.music.player.b.a.i = true;
        this.r.invoke();
    }

    public final MusicPlayerDetailFragment ta0() {
        LarusMusicDetailPagerLayoutBinding r2 = this.i;     // Catch: Exception -> L20
        if (r2 == null) goto L25;
        ViewPager2 r3 = r2.c;     // Catch: Exception -> L20
        if (r3 == null) goto L26;
        int r4 = r3.getCurrentItem();     // Catch: Exception -> L20
        MusicDetailPagerAdapter r5 = this.j;     // Catch: Exception -> L20
        if (r5 == null) goto L10;
        long r6 = r5.getItemId(r4);     // Catch: Exception -> L20
    L11:
        FragmentManager r7 = getChildFragmentManager();     // Catch: Exception -> L20
        if (r7 == null) goto L14;
        Fragment r0 = r7.findFragmentByTag("f" + r6);     // Catch: Exception -> L20
    L16:
        if ((r0 instanceof MusicPlayerDetailFragment) == false) goto L27;
        return (MusicPlayerDetailFragment) r0;
    L27:
        return null;
    L14:
        r0 = null;
        goto L16
    L10:
        r6 = 0;
        goto L11
    L26:
        return null;
    L25:
        return null;
    L20:
        e = move-exception;
        FLogger.a.e("TemplateImagePagerFragment", "getCurrentFragment error e=" + e.getMessage());
        return null;
    }

    public final void ua0() {
        Function0<Boolean> r0 = this.w;
        boolean r1 = true;
        int r2 = 0;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L26;
        Function0<Boolean> r4 = this.w;
        if (r4 != null) goto L12;
    L14:
        r1 = false;
    L15:
        LarusFragmentCommonSlideBinding r5 = ((CommonSlideDialogFragment) this).d;
        if (r5 == null) goto L23;
        ImageView r6 = r5.b;
        if (r6 == null) goto L23;
        if (r1 == true) goto L22;
        r2 = 8;
    L22:
        r6.setVisibility(r2);
    L23:
        if (r1 == false) goto L33;
        ma0();
        return;
    L33:
        return;
    L12:
        if (((Boolean) r4.invoke()).booleanValue() != true) goto L14;
    L26:
        Function0<Boolean> r7 = this.v;
        if (r7 == null) goto L29;
        boolean r8 = ((Boolean) r7.invoke()).booleanValue();
    L30:
        if (r8 == true) goto L34;
        qa0();
        return;
    L34:
        return;
    L29:
        r8 = qa0();
        goto L30
    L5:
        if (((Boolean) r0.invoke()).booleanValue() != true) goto L7;
        r3 = true;
        goto L8
    }

    public final void wa0() {
        if (this.B == true) goto L5;
        return;
    L5:
        this.D = SystemClock.elapsedRealtime();
        kr8.n r0 = kr8.n.a;
        kr8.o r1 = pa0(this);
        Intrinsics.checkNotNullParameter(r1, "context");
        kr8.n.g("music_app_page_enter", kr8.n.j(r1, r1.a));
    }

    public final void xa0() {
        if (this.B == true) goto L5;
        return;
    L5:
        long r0 = this.D;
        if (r0 > 0) goto L8;
        return;
    L8:
        this.D = 0;
        kr8.n r2 = kr8.n.a;
        kr8.o r3 = pa0(this);
        long r4 = SystemClock.elapsedRealtime() - r0;
        Intrinsics.checkNotNullParameter(r3, "context");
        JSONObject r1 = kr8.n.j(r3, r3.a);
        r1.put("duration", r4);
        Unit r5 = Unit.INSTANCE;
        kr8.n.g("music_app_page_exit", r1);
    }

    public MusicDetailPagerFragment() {
        this.m = new LinkedHashMap();
        this.r = new m0();
        this.A = 1;
        this.E = new b(this);
    }

    public final ViewBinding ea0() {
        ConstraintLayout r0 = getLayoutInflater().inflate(2131562980, null, false);
        int r1 = 2131370087;
        DotsIndicator r2 = ViewBindings.findChildViewById(r0, 2131370087);
        if (r2 == null) goto L9;
        r1 = 2131380510;
        ViewPager2 r3 = ViewBindings.findChildViewById(r0, 2131380510);
        if (r3 == null) goto L9;
        LarusMusicDetailPagerLayoutBinding r4 = new LarusMusicDetailPagerLayoutBinding(r0, r2, r3);
        this.i = r4;
        return r4;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }

    public final void onDestroyView() {
        xa0();
        super.onDestroyView();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (this.B == false) goto L10;
        CopyOnWriteArraySet<ir8.c.a> r0 = ir8.c.a;
        if (ir8.c.a(this.E) == true) goto L7;
        return;
    L7:
        if (this.D > 0) goto L12;
        wa0();
        return;
    L12:
        return;
    }

    public final boolean qa0() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L17;
        OnBackPressedDispatcher r1 = r0.getOnBackPressedDispatcher();
        if (r1 == null) goto L21;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        r1.onBackPressed();     // Catch: Throwable -> L9
        Object r3 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L9
    L11:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L16;
        FLogger.a.e("TemplateImagePagerFragment", "fallback navigate back by activity failed", r4);
        r3 = Boolean.FALSE;
    L16:
        return ((Boolean) r3).booleanValue();
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L21:
        return false;
    L17:
        return false;
    }

    public final int aa0() {
        return this.A;
    }

    public static /* synthetic */ kr8.o pa0(MusicDetailPagerFragment r2) {
        MusicDetailPagerAdapter r0 = r2.j;
        if (r0 == null) goto L6;
        MusicCreationContent r1 = r0.z2(r2.k);
        if (r1 == null) goto L6;
    L8:
        return r2.oa0(r1, r2.p);
    L6:
        r1 = r2.o;
        goto L8
    }

    public final void Y90(CommonSlideDialogFragment.b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        MusicPlayerDetailFragment r1 = null;
        if ((r3 instanceof CommonSlideDialogFragment.b.b) == false) goto L10;
        MusicPlayerDetailFragment r4 = ta0();
        if ((r4 instanceof g19.a) == false) goto L7;
        r1 = r4;
    L7:
        if (r1 == null) goto L17;
        r1.o1();
        return;
    L17:
        return;
    L10:
        if ((r3 instanceof CommonSlideDialogFragment.b.e) == false) goto L19;
        MusicPlayerDetailFragment r5 = ta0();
        if ((r5 instanceof g19.a) == false) goto L14;
        r1 = r5;
    L14:
        if (r1 == null) goto L20;
        r1.d70();
        return;
    L20:
        return;
    }

    public final void da0(Bundle r11) {
        super.da0(r11);
        LarusMusicDetailPagerLayoutBinding r12 = this.i;
        if (r12 == null) goto L48;
        ViewPager2 r13 = r12.c;
        if (r13 == null) goto L48;
        MusicDetailPagerAdapter r1 = new MusicDetailPagerAdapter(this, new c(this));
        this.j = r1;
        this.k = r1.d;
        r13.setAdapter(r1);
        Dialog r2 = getDialog();
        if (r2 == null) goto L11;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L11;
        r3.setBackgroundDrawable(new ColorDrawable(0));
    L11:
        Dialog r4 = getDialog();
        if (r4 == null) goto L16;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L16;
        WindowManager.LayoutParams r6 = r5.getAttributes();
    L17:
        if (r6 == null) goto L19;
        r6.gravity = 7;
    L19:
        r13.setOffscreenPageLimit(-1);
        r13.setOrientation(this.A);
        r13.setVisibility(8);
        r13.post(new q0(this));
        if (this.t != null) goto L42;
        LarusMusicDetailPagerLayoutBinding r14 = this.i;
        if (r14 == null) goto L48;
        DotsIndicator r15 = r14.b;
        if (r15 == null) goto L48;
        MusicDetailPagerAdapter r7 = this.j;
        if (r7 == null) goto L28;
        int r8 = r7.getItemCount();
    L29:
        int r9 = this.k;
        if (r8 <= 1) goto L48;
        int r10 = 0;
    L33:
        if (r10 >= r8) goto L39;
        View r16 = LayoutInflater.from(r15.getContext()).inflate(2131562317, r15, false);
        ImageView r17 = (ImageView) r16.findViewById(2131370082);
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r19 = (FrameLayout.LayoutParams) r18;
        r16.setLayoutDirection(0);
        int r20 = r15.b;
        r19.height = r20;
        r19.width = r20;
        int r21 = r15.c;
        r19.setMargins(r21, 0, r21, 0);
        LinearLayout r22 = r15.a;
        if (r22 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
        r22 = null;
    L37:
        r22.addView(r16);
        List r23 = r15.d;
        Intrinsics.checkNotNull(r17);
        ((ArrayList) r23).add(r17);
        r10 = r10 + 1;
        goto L33
    L39:
        if (r9 < ((ArrayList) r15.d).size()) goto L41;
        r9 = ((ArrayList) r15.d).size() - 1;
    L41:
        r15.a(r9);
        goto L48
    L28:
        r8 = 0;
        goto L29
    L42:
        LarusMusicDetailPagerLayoutBinding r110 = this.i;
        if (r110 == null) goto L48;
        DotsIndicator r111 = r110.b;
        if (r111 == null) goto L48;
        com.larus.utils.e1.q(r111);
    L16:
        r6 = null;
    L48:
        if ((this.o instanceof bq8.a) == false) goto L50;
        W90();
        return;
    L50:
        LarusFragmentCommonSlideBinding r112 = ((CommonSlideDialogFragment) this).d;
        if (r112 == null) goto L60;
        ImageView r113 = r112.f;
        if (r113 == null) goto L61;
        r113.setVisibility(0);
        return;
    L61:
        return;
    }

    @Override // com.larus.bmhome.music.widget.LyricsToSongCardView.b
    public final void mK(Message r7) {
        if (r7 == null) goto L17;
        this.n = r7;
        Map r0 = r7.getExt();
        if (r0 == null) goto L8;
        String r1 = (String) r0.get("user_creation");
        if (r1 == null) goto L8;
    L9:
        this.l = a.a(r1);
        Iterator r2 = ((LinkedHashMap) this.m).entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L21;
        Map.Entry r3 = (Map.Entry) r2.next();
        MusicPlayerDetailFragment r4 = (MusicPlayerDetailFragment) r3.getValue();
        int r5 = ra0((String) r3.getKey());
        String r6 = sa0((String) r3.getKey());
        r4.getClass();
        Intrinsics.checkNotNullParameter(r6, "creationId");
        r4.D = r5;
        r4.J = r5;
        r4.E = r6;
        r4.fa0(r5);
        MusicPlayerDetailFragment r8 = (MusicPlayerDetailFragment) r3.getValue();
        boolean r9 = true;
        if (com.larus.bmhome.chat.bean.d.j0(r7) == true) goto L16;
        r9 = false;
    L16:
        r8.Z90(r9);
        goto L11
    L21:
        return;
    L8:
        r1 = "";
        goto L9
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (this.B == false) goto L5;
        CopyOnWriteArraySet<ir8.c.a> r3 = ir8.c.a;
        b r4 = this.E;
        Intrinsics.checkNotNullParameter(r4, "callback");
        ir8.c.a.add(r4);
    L5:
        Message r5 = this.n;
        if (r5 == null) goto L8;
        Map r6 = r5.getExt();
    L9:
        if (r6 == null) goto L12;
        String r7 = (String) r6.get("user_creation");
        if (r7 == null) goto L12;
    L13:
        this.l = a.a(r7);
        return;
    L12:
        r7 = "";
        goto L13
    L8:
        r6 = null;
        goto L9
    }

    public final int ra0(String r5) {
        Message r0 = this.n;
        Pair<String, Integer> r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getMessageId();
    L7:
        if (r2 != null) goto L9;
    L32:
        return 0;
    L9:
        if (this.t != null) goto L32;
        if (r5 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == true) goto L32;
        Map<String, Pair<String, Integer>> r4 = this.l;
        if (r4 == null) goto L22;
        r1 = r4.get(r5);
    L22:
        if (r1 != null) goto L24;
        return 1;
    L24:
        int r6 = ((Number) r1.getSecond()).intValue();
        if (r6 != 1) goto L27;
        return 3;
    L27:
        if (r6 == 2) goto L29;
        return 0;
    L29:
        return 2;
    L13:
        if (r5.length() == 0) goto L16;
        r3 = false;
        goto L17
    L5:
        r2 = null;
        goto L7
    }

    public final String sa0(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return "";
    L11:
        Map<String, Pair<String, Integer>> r1 = this.l;
        if (r1 == null) goto L20;
        Pair<String, Integer> r4 = r1.get(r3);
        if (r4 == null) goto L21;
        String r5 = (String) r4.getFirst();
        if (r5 != null) goto L19;
        return "";
    L19:
        return r5;
    L21:
        return "";
    L20:
        return "";
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L9
    }

    public final kr8.o oa0(MusicCreationContent r9, com.larus.bmhome.music.player.j r10) {
        kr8.n r0 = kr8.n.a;
        return kr8.n.a(this.C, r10, r9, this.n, null, null, 48);
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L5;
        r4.setOnShowListener(new n0(this));
    L5:
        LarusMusicDetailPagerLayoutBinding r5 = this.i;
        if (r5 == null) goto L15;
        DotsIndicator r6 = r5.b;
        if (r6 == null) goto L15;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L13;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        com.larus.utils.i0.a.getClass();
        r8.topMargin = com.larus.utils.i0.g();
        r6.setLayoutParams(r8);
        goto L15
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L15:
        if (this.B == false) goto L18;
        na0();
        CopyOnWriteArraySet<ir8.c.a> r9 = ir8.c.a;
        ir8.c.b(this.E);
        wa0();
        return;
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        com.larus.bmhome.music.player.b.a r0 = com.larus.bmhome.music.player.b.a;
        r0.getClass();
        com.larus.bmhome.music.player.b.a.g = false;
        r0.getClass();
        com.larus.bmhome.music.player.b.a.h = true;
        r0.getClass();
        com.larus.bmhome.music.player.b.a.i = false;
        return super.onCreateView(r4, r5, r6);
    }

    public final void va0(int r6, String r7, String r8) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("enter_method", r7);
        if (com.larus.utils.o0.d(r8) == false) goto L5;
        r1.put("slide_status", r8);
    L5:
        MusicDetailPagerAdapter r9 = this.j;
        MusicCreationContent r10 = null;
        if (r9 == null) goto L8;
        MusicCreationContent r11 = r9.z2(r6);
    L10:
        if ((r11 instanceof bq8.a) == false) goto L12;
        String r12 = "template_detail";
    L13:
        r1.put("enter_from", r12);
        com.larus.bmhome.music.player.j r13 = this.p;
        if (r13 == null) goto L16;
        String r14 = r13.e();
    L17:
        r1.put("chat_type", r14);
        Message r15 = this.n;
        if (r15 == null) goto L20;
        String r16 = r15.getSenderId();
    L22:
        if (com.larus.utils.o0.d(r16) == false) goto L26;
        Message r17 = this.n;
        if (r17 == null) goto L29;
        String r18 = r17.getSenderId();
    L30:
        r1.put("bot_id", r18);
        MusicDetailPagerAdapter r19 = this.j;
        if (r19 == null) goto L33;
        MusicCreationContent r20 = r19.z2(r6);
    L34:
        boolean r21 = r20 instanceof bq8.a;
        String r2 = TriggerSendLoading.NO_LOADING;
        if (r21 == true) goto L47;
        Map<String, Pair<String, Integer>> r22 = this.l;
        if (r22 == null) goto L43;
        MusicDetailPagerAdapter r4 = this.j;
        if (r4 == null) goto L41;
        MusicCreationContent r5 = r4.z2(r6);
    L42:
        Pair r23 = (Pair) ((LinkedHashMap) r22).get(a.b(r5));
    L44:
        if (r23 != null) goto L47;
        Object r24 = TriggerSendLoading.NO_LOADING;
    L48:
        r1.put("is_template", r24);
        MusicDetailPagerAdapter r25 = this.j;
        if (r25 == null) goto L51;
        MusicCreationContent r26 = r25.z2(r6);
    L53:
        if ((r26 instanceof bq8.a) == true) goto L64;
        Map<String, Pair<String, Integer>> r27 = this.l;
        if (r27 == null) goto L61;
        MusicDetailPagerAdapter r28 = this.j;
        if (r28 == null) goto L59;
        MusicCreationContent r29 = r28.z2(r6);
    L60:
        Pair r30 = (Pair) ((LinkedHashMap) r27).get(a.b(r29));
    L62:
        if (r30 == null) goto L64;
        Object r31 = "1";
    L65:
        r1.put("is_creation", r31);
        MusicDetailPagerAdapter r32 = this.j;
        if (r32 == null) goto L68;
        r10 = r32.z2(r6);
    L68:
        int r33 = ra0(a.b(r10));
        if (r33 != 1) goto L71;
        r2 = "-1";
    L77:
        r1.put("creation_public_status", r2);
        Unit r34 = Unit.INSTANCE;
        r0.reportEvent("enter_music_detail", r1);
        return;
    L71:
        if (r33 == 2) goto L77;
        if (r33 == 3) goto L75;
        r2 = "";
        goto L77
    L75:
        r2 = "1";
        goto L77
    L59:
        r29 = null;
        goto L60
    L61:
        r30 = null;
    L64:
        r31 = TriggerSendLoading.NO_LOADING;
        goto L65
    L51:
        r26 = null;
        goto L53
    L41:
        r5 = null;
        goto L42
    L43:
        r23 = null;
    L47:
        r24 = "1";
        goto L48
    L33:
        r20 = null;
    L29:
        r18 = null;
        goto L30
    L26:
        com.larus.bmhome.music.player.j r35 = this.p;
        if (r35 == null) goto L29;
        r18 = r35.d();
        goto L30
    L20:
        r16 = null;
        goto L22
    L16:
        r14 = null;
        goto L17
    L12:
        r12 = "chat";
        goto L13
    L8:
        r11 = null;
        goto L10
    }
}
