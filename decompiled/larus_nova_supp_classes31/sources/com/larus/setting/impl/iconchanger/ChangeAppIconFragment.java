package com.larus.setting.impl.iconchanger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.common.utility.NetworkUtils;
import com.google.gson.Gson;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.bmhome.auth.CocoSetting;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.bot.BotSettingViewModel;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.home.api.main.AppIconsType;
import com.larus.home.api.main.HomeService;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.EditPos;
import com.larus.platform.service.z2;
import com.larus.setting.impl.databinding.LarusPageChangeAppIconBinding;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import lq9.g0;
import org.json.JSONException;
import org.json.JSONObject;
import tx9.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 x2\u00020\u0001:\u0001xB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020 H\u0002J\b\u00108\u001a\u000206H\u0003J\b\u00109\u001a\u000206H\u0002J\b\u0010:\u001a\u000206H\u0003J\b\u0010;\u001a\u000206H\u0003J\u0012\u0010<\u001a\u0002062\b\u0010=\u001a\u0004\u0018\u00010\u001aH\u0003J!\u0010>\u001a\u0002062\b\u0010?\u001a\u0004\u0018\u00010\t2\b\u0010@\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010AJ\u0014\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0CH\u0002J\b\u0010D\u001a\u000206H\u0002J\b\u0010E\u001a\u000206H\u0002J\u0012\u0010F\u001a\u0002062\b\b\u0002\u0010G\u001a\u00020 H\u0002J$\u0010H\u001a\u0002062\b\u0010I\u001a\u0004\u0018\u00010\u001a2\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010KH\u0002J\"\u0010L\u001a\u0002062\u0006\u0010I\u001a\u00020\u001a2\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010KH\u0002J\u000e\u0010M\u001a\u0002062\u0006\u0010N\u001a\u000204J\u001a\u0010O\u001a\u0002062\u0006\u0010P\u001a\u00020.2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0010\u0010Q\u001a\u0002062\u0006\u0010N\u001a\u000204H\u0002J\u0014\u0010R\u001a\u0002062\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u000eH\u0002J\u0016\u0010T\u001a\u000206*\u00020\u00172\b\u0010U\u001a\u0004\u0018\u00010\u0017H\u0002JW\u0010V\u001a\u0002062M\u0010J\u001aI\u0012\u0013\u0012\u00110 ¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(Z\u0012\u0013\u0012\u00110\t¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b([\u0012\u0013\u0012\u00110\t¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(\\\u0012\u0004\u0012\u000206\u0018\u00010WH\u0002J\b\u0010]\u001a\u000206H\u0002J\b\u0010^\u001a\u000206H\u0002J\b\u0010_\u001a\u000206H\u0002J,\u0010b\u001a\u0004\u0018\u00010\u00172\u0006\u0010c\u001a\u00020\f2\b\b\u0002\u0010d\u001a\u00020 2\b\b\u0002\u0010e\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010fJ\b\u0010g\u001a\u000206H\u0002J\u0012\u0010h\u001a\u0002062\b\u0010i\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010j\u001a\u000206H\u0016J\b\u0010k\u001a\u000206H\u0002J\u0014\u0010l\u001a\u00020m*\u0004\u0018\u00010\u00172\u0006\u0010e\u001a\u00020nJ\b\u0010o\u001a\u00020 H\u0016J\b\u0010p\u001a\u000206H\u0016J\b\u0010q\u001a\u00020\fH\u0016J\n\u0010r\u001a\u0004\u0018\u00010\fH\u0016J\u0014\u0010s\u001a\u0004\u0018\u00010\f2\b\u0010t\u001a\u0004\u0018\u00010uH\u0002J\n\u0010v\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010w\u001a\u000206H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b*\u0010+R\u000e\u0010`\u001a\u00020aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006y"}, d2 = {"Lcom/larus/setting/impl/iconchanger/ChangeAppIconFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/setting/impl/databinding/LarusPageChangeAppIconBinding;", "changeAppIconAdapter", "Lcom/larus/setting/impl/iconchanger/ChangeAppIconAdapter;", "selectedAppIconId", "", "currentUseAppIconId", "selectVoiceId", "", "currentShowVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "cvsType", "RESULT_CODE", "localConversationId", "conversationId", "enterMethod", "pendingDeeplinkSchema", "previousPage", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "supportChangeAppIconDataList", "", "Lcom/larus/setting/impl/iconchanger/ChangeAppIconData;", "registerListenerBotId", "currentLanguageCode", "lowPriorityRenderVoiceJob", "Lkotlinx/coroutines/Job;", "haveUserChangeIcon", "", "haveUserGotoVoiceChangePage", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "Lkotlin/Lazy;", "botSettingViewModel", "Lcom/larus/bmhome/bot/BotSettingViewModel;", "getBotSettingViewModel", "()Lcom/larus/bmhome/bot/BotSettingViewModel;", "botSettingViewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "", "supportShowCurrentVoice", "reRequestAudioInfo", "requestPGCVoiceList", "renderAppIconsList", "refreshCurrentSelectAppIconId", "processClickChangeAppIcon", "changeAppData", "notifySelectItemChange", "lastSelectAppIconId", "currentSelectAppIconId", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getGlobalAudioObserverExtraParams", "", "renderPageEnterFromRegister", "renderPageEnterFromOther", "finishPage", "needResult", "processChangeIcon", "selectChangeAppIconData", "callback", "Lkotlin/Function0;", "changeAppIcon", "onResult", "bundle", "onViewCreated", "view", "setupSelectSpeakerResult", "updateSpeaker", "result", "updateBotInfo", "newBotInfo", "calculateItemHeight", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "needAdjust", "itemHeight", "itemSpace", "parseParams", "renderVoiceGroup", "initCurrentAppIconId", "listener", "Lcom/larus/im/service/OnBotChangedListener;", "findBotInfo", "cvsId", "forceNew", "scene", "(Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerRefreshVoiceItem", "renderSelectItem", "voice", "onDestroyView", "gotoVoiceSelectPage", "getMatchVoiceRequest", "Lcom/larus/audio/bean/GetMatchVoiceRequest;", "Lcom/larus/audio/bean/RecommendScene;", "autoLogEnterPage", "logEnterPage", "getCurrentPageName", "getPageName", "convertToClickFrom", "appIconsType", "Lcom/larus/home/api/main/AppIconsType;", "findSelectedChangeAppIconData", "scrollToSelectIconPosition", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ChangeAppIconFragment extends TraceFragment {
    public static final /* synthetic */ int B = 0;
    public final ChangeAppIconFragment$listener$1 A;
    public LarusPageChangeAppIconBinding e;
    public ChangeAppIconAdapter f;
    public int g;
    public int h;
    public String i;
    public SpeakerVoice j;
    public final int k;
    public final int l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public BotModel r;
    public List<com.larus.setting.impl.iconchanger.b> s;
    public String t;
    public String u;
    public Job v;
    public boolean w;
    public boolean x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(d r2) {
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

    static {
    }

    public final boolean S90() {
        return false;
    }

    public final void T90() {
    }

    public final String getPageName() {
        return "bot_image_setting";
    }

    public final String k() {
        return "bot_image_setting";
    }

    public final com.larus.setting.impl.iconchanger.b X90() {
        List<com.larus.setting.impl.iconchanger.b> r0 = this.s;
        if (r0 == null) goto L13;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L21;
        com.larus.setting.impl.iconchanger.b r2 = (com.larus.setting.impl.iconchanger.b) r1.next();
        Integer r3 = r2.g;
        int r4 = this.g;
        if (r3 == null) goto L6;
        if (r3.intValue() != r4) goto L6;
        return r2;
    L21:
        return null;
    L13:
        return null;
    }

    public final void aa0() {
        LinkedHashSet r0 = new LinkedHashSet();
        List<com.larus.setting.impl.iconchanger.b> r1 = this.s;
        if (r1 == null) goto L9;
        Iterator<T> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L9;
        r0.add(((com.larus.setting.impl.iconchanger.b) r2.next()).g);
    L9:
        if (r0.contains(Integer.valueOf(this.h)) == true) goto L11;
        int r3 = AppIconsType.DEFAULT.getAppIconId();
        this.h = r3;
        this.g = r3;
    L11:
        List<com.larus.setting.impl.iconchanger.b> r4 = this.s;
        if (r4 == null) goto L25;
        List<com.larus.setting.impl.iconchanger.b> r5 = r4;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L15:
        if (r7.hasNext() == false) goto L24;
        com.larus.setting.impl.iconchanger.b r8 = (com.larus.setting.impl.iconchanger.b) r7.next();
        int r9 = this.g;
        Integer r10 = r8.g;
        if (r10 != null) goto L20;
    L22:
        boolean r11 = false;
    L23:
        r6.add(com.larus.setting.impl.iconchanger.b.a(r8, false, 0, r11, null, 507));
        goto L15
    L20:
        if (r9 != r10.intValue()) goto L22;
        r11 = true;
        goto L23
    L24:
        List<com.larus.setting.impl.iconchanger.b> r12 = CollectionsKt.toMutableList(r6);
    L26:
        this.s = r12;
        ChangeAppIconAdapter r13 = this.f;
        if (r13 == null) goto L29;
        r13.b = r12;
    L29:
        if (r13 == null) goto L36;
        r13.notifyDataSetChanged();
        return;
    L36:
        return;
    L25:
        r12 = null;
        goto L26
    }

    public final void ca0() {
        List<com.larus.setting.impl.iconchanger.b> r0 = this.s;
        int r1 = -1;
        if (r0 == null) goto L17;
        Iterator<T> r2 = r0.iterator();
        int r3 = 0;
    L6:
        if (r2.hasNext() == false) goto L17;
        Object r4 = r2.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        Integer r6 = ((com.larus.setting.impl.iconchanger.b) r4).g;
        int r7 = this.g;
        if (r6 == null) goto L16;
        if (r6.intValue() != r7) goto L16;
        r1 = r3;
    L16:
        r3 = r5;
    L17:
        if (r1 < 0) goto L28;
        LarusPageChangeAppIconBinding r8 = this.e;
        if (r8 == null) goto L29;
        RecyclerView r9 = r8.b;
        if (r9 == null) goto L30;
        r9.scrollToPosition(r1);
        return;
    L30:
        return;
    L29:
        return;
    }

    public final boolean da0() {
        if (Intrinsics.areEqual(this.o, "registration_process") == false) goto L5;
        return false;
    L5:
        if (this.m.length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
    L14:
        return true;
    L10:
        if (this.n.length() != 0) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L14;
        return false;
    L12:
        r1 = false;
        goto L13
    L7:
        r0 = false;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.setting.impl.iconchanger.ChangeAppIconFragment$listener$1] */
    public ChangeAppIconFragment() {
        this.g = -1;
        this.h = -1;
        this.k = 1;
        this.l = 100;
        this.m = "";
        this.n = "";
        this.o = "";
        this.t = "";
        this.u = "zh";
        this.y = LazyKt.lazy(new l(this));
        final Function0<Fragment> r0 = new ChangeAppIconFragment$special$$inlined$viewModels$default$1(this);
        this.z = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BotSettingViewModel.class), new ChangeAppIconFragment$special$$inlined$viewModels$default$2(r0), new ChangeAppIconFragment$special$$inlined$viewModels$default$3(r0, this));
        this.A = new ChangeAppIconFragment$listener$1(this);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        com.larus.im.d.a().unregisterBotChangeListener(this.t, this.A);
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        et9.e.a().stopAudio();
        et9.e.a().i();
    }

    public static final Map U90(ChangeAppIconFragment r3) {
        r3.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        BotModel r1 = r3.r;
        if (r1 == null) goto L5;
        String r2 = r1.getBotId();
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r0.put("bot_id", r2);
        r0.put("conversation_id", r3.n);
        r0.put("current_page", "bot_image_setting");
        return r0;
    L5:
        r2 = null;
        goto L6
    }

    public final void Y90(boolean r5) {
        if (r5 == false) goto L6;
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L6;
        r6.setResult(100, new Intent().putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("conversation_exit", Boolean.TRUE)})));
    L6:
        Context r7 = getContext();
        if ((r7 instanceof Activity) == false) goto L9;
        Activity r8 = (Activity) r7;
    L10:
        if (r8 == null) goto L13;
        r8.finish();
        return;
    L13:
        return;
    L9:
        r8 = null;
        goto L10
    }

    public final void ba0(SpeakerVoice r2) {
        LarusPageChangeAppIconBinding r0 = this.e;
        if (r0 == null) goto L7;
        ItemTextArrow r1 = r0.i;
        if (r1 == null) goto L7;
        r1.V5();
    L7:
        if (r2 == null) goto L9;
        String r3 = r2.getId();
    L10:
        this.i = r3;
        this.j = r2;
        if (da0() == true) goto L13;
        return;
    L13:
        if (r2 == null) goto L22;
        String r4 = r2.getName();
        if (r4 == null) goto L23;
        LarusPageChangeAppIconBinding r5 = this.e;
        if (r5 == null) goto L24;
        ItemTextArrow r6 = r5.i;
        if (r6 == null) goto L25;
        r6.setText(r4);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final void ea0(SpeakerVoice r12) {
        Object r0 = null;
        if (r12 != null) goto L8;
        BotModel r13 = this.r;
        if (r13 == null) goto L7;
        r12 = r13.getVoiceType();
        goto L8
    L7:
        r12 = null;
    L8:
        BotModel r1 = this.r;
        boolean r2 = false;
        if (r1 == null) goto L11;
        boolean r3 = r1.getMuted();
    L12:
        Gson r4 = new Gson();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L19
        BotModel r6 = this.r;     // Catch: Throwable -> L19
        if (r6 == null) goto L16;
        String r7 = r6.getEditPos();     // Catch: Throwable -> L19
    L17:
        Object r8 = Result.constructor-impl((EditPos) r4.fromJson(r7, EditPos.class));     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r8) == true) goto L25;
        r0 = r8;
    L25:
        EditPos r9 = (EditPos) r0;
        if (r9 != null) goto L28;
        r9 = new EditPos(0);
    L28:
        LarusPageChangeAppIconBinding r10 = this.e;
        if (r10 == null) goto L100;
        int r11 = x.a;
        Context r14 = getContext();
        ItemTextArrow r15 = r10.i;
        if (r14 == null) goto L68;
        if (r15 == null) goto L68;
        if (r12 != null) goto L37;
    L39:
        boolean r16 = false;
    L41:
        if (r16 == true) goto L64;
        if (g0.b(r12) == false) goto L52;
        if (r12 != null) goto L46;
    L48:
        boolean r17 = false;
    L49:
        if (r17 == false) goto L52;
        r15.b6(r14.getString(2131910777), Integer.valueOf(ContextCompat.getColor(r14, 2131102650)));
        r15.setStyle(0);
        goto L68
    L46:
        if (r12.getStatus() != 4) goto L48;
        r17 = true;
    L52:
        if (g0.b(r12) == false) goto L60;
        if (r12 != null) goto L55;
    L57:
        boolean r18 = false;
    L58:
        if (r18 == false) goto L60;
        r15.b6(r14.getString(2131908207), Integer.valueOf(ContextCompat.getColor(r14, 2131102650)));
        goto L68
    L55:
        if (r12.getStatus() != 3) goto L57;
        r18 = true;
    L60:
        if (r3 == true) goto L68;
        if (r12 == null) goto L68;
        r12.getName();
        goto L68
    L64:
        if (g0.b(r12) == false) goto L66;
    L67:
        r15.b6(r14.getString(2131907855), Integer.valueOf(ContextCompat.getColor(r14, 2131102650)));
        goto L68
    L66:
        if (g0.a(r12, r9) == false) goto L68;
    L37:
        if (r12.getConfStatus() != 2) goto L39;
        r16 = true;
    L68:
        if (r12 != null) goto L70;
    L72:
        boolean r19 = false;
    L73:
        if (r19 == true) goto L101;
        if (r12 != null) goto L76;
    L78:
        boolean r20 = false;
    L79:
        if (r20 == true) goto L102;
        if (r12 != null) goto L82;
    L84:
        boolean r110 = false;
    L85:
        if (r110 == true) goto L103;
        BotModel r111 = this.r;
        if (r111 != null) goto L89;
    L91:
        if (r2 == false) goto L104;
        BotModel r112 = this.r;
        if (r112 == null) goto L105;
        SpeakerVoice r113 = r112.getVoiceType();
        if (r113 == null) goto L106;
        r113.setId("0");
        return;
    L106:
        return;
    L105:
        return;
    L104:
        return;
    L89:
        if (r111.getMuted() != true) goto L91;
        r2 = true;
        goto L91
    L103:
        return;
    L82:
        if (r12.getStatus() != 3) goto L84;
        r110 = true;
        goto L85
    L102:
        return;
    L76:
        if (r12.getStatus() != 4) goto L78;
        r20 = true;
        goto L79
    L101:
        return;
    L70:
        if (r12.getConfStatus() != 2) goto L72;
        r19 = true;
        goto L73
    L100:
        return;
    L16:
        r7 = null;
    L19:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L11:
        r3 = false;
        goto L12
    }

    public final void V90(com.larus.setting.impl.iconchanger.b r7, Function0<Unit> r8) {
        AppIconsType.a r0 = AppIconsType.Companion;
        Integer r1 = r7.g;
        r0.getClass();
        AppIconsType r2 = AppIconsType.a.a(r1);
        String r3 = this.o;
        String r4 = HomeService.a.q(r2);
        SpeakerVoice r5 = this.j;
        if (r5 == null) goto L5;
        String r6 = r5.getId();
    L6:
        JSONObject r9 = new JSONObject();
        Intrinsics.checkNotNullParameter(r9, "params");
        if (r3 != null) goto L19;
    L11:
        if (r4 == null) goto L13;
        r9.put("click_from", r4);     // Catch: JSONException -> L9
    L13:
        if (r6 == null) goto L17;
        r9.put("voice_id", r6);     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        FLogger.a.e("ChangeEventHelper", "error in ChangeEventHelper click_subscription_entrance " + e.getLocalizedMessage());
    L17:
        TrackParams r10 = new TrackParams().merge(r9);
        by7.a r11 = new by7.a("change_doubao_image");
        r11.b = this;
        r11.a.merge(r10);
        r11.b();
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new ChangeAppIconFragment$changeAppIcon$1(this, r7, r8, null));
        return;
    L19:
        r9.put("enter_method", r3);     // Catch: JSONException -> L9
        goto L11
    L5:
        r6 = null;
        goto L6
    }

    public final void Z90(final com.larus.setting.impl.iconchanger.b r8, final Function0<Unit> r9) {
        if (NetworkUtils.isNetworkAvailable(getContext()) == true) goto L6;
        t19.s.j(t19.s.a, getContext(), getString(2131907879), null, false, 28);
        return;
    L6:
        WeakReference<CommonDialog> r0 = ChangeAppIconManager.a;
        if (Build.VERSION.SDK_INT < 29) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L18;
        FragmentActivity r2 = getActivity();
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L14;
        String r4 = r3.getString(2131900722, new Object[]{AppHost.a.getAppStringName()});
    L15:
        if (r4 != null) goto L17;
        r4 = "";
    L17:
        ChangeAppIconManager.g(r2, r4, r8.i.e(), null, new f(this, r8, r9));
        return;
    L14:
        r4 = null;
        goto L15
    L18:
        V90(r8, r9);
        return;
    L9:
        r1 = false;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [com.larus.setting.impl.iconchanger.j] */
    /* JADX WARN: Type inference failed for: r2v13, types: [com.larus.setting.impl.iconchanger.i] */
    /* JADX WARN: Type inference failed for: r8v17, types: [com.larus.setting.impl.iconchanger.d] */
    public final void onViewCreated(View r56, Bundle r57) {
        Intrinsics.checkNotNullParameter(r56, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r56, r57);
        Bundle r0 = getArguments();
        if (r0 == null) goto L6;
        String r1 = r0.getString("setting_conversation_id", "");
        if (r1 == null) goto L6;
    L7:
        this.n = r1;
        Bundle r2 = getArguments();
        if (r2 == null) goto L11;
        String r3 = r2.getString("setting_local_conversation_id", "");
        if (r3 == null) goto L11;
    L12:
        this.m = r3;
        AuthModelDelegate r4 = AuthModelDelegate.b;
        wc9.e r5 = (wc9.e) r4.y().getValue();
        if (r5 == null) goto L15;
        String r6 = r5.a;
    L16:
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        boolean r7 = false;
        if (this.n.length() != 0) goto L21;
        boolean r8 = true;
    L23:
        if (r8 == true) goto L25;
    L35:
        Bundle r9 = getArguments();
        if (r9 == null) goto L39;
        String r10 = r9.getString("enter_method", "");
        if (r10 == null) goto L39;
    L40:
        this.o = r10;
        Bundle r11 = getArguments();
        if (r11 == null) goto L43;
        String r12 = r11.getString("pending_deeplink_schema");
    L44:
        this.p = r12;
        Bundle r13 = getArguments();
        if (r13 == null) goto L47;
        String r14 = r13.getString("previous_page", "");
    L48:
        this.q = r14;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new ChangeAppIconFragment$registerRefreshVoiceItem$1(this, null), 2, null);
        final ChangeAppIconAdapter r15 = new ChangeAppIconAdapter(new i(this));
        LarusPageChangeAppIconBinding r16 = this.e;
        if (r16 == null) goto L53;
        RecyclerView r17 = r16.b;
        if (r17 == null) goto L53;
        LinearLayoutManager r18 = new LinearLayoutManager(getContext());
        r18.setOrientation(1);
        r17.setLayoutManager(r18);
    L53:
        FeatureKitDelegate r19 = FeatureKitDelegate.b;
        if (r19.w0().b() == false) goto L69;
        AudioServiceDelegate r20 = AudioServiceDelegate.a;
        AudioUserConfig r21 = (AudioUserConfig) r20.p().getValue();
        if (r21 == null) goto L59;
        List r22 = r21.getNewVoiceList();
    L60:
        List r23 = r22;
        if (r23 != null) goto L63;
    L66:
        boolean r24 = true;
    L67:
        if (r24 == false) goto L69;
        r20.J("ChangeAppIconFragment");
        Transformations.distinctUntilChanged(Transformations.map(r20.p(), new o())).observe(getViewLifecycleOwner(), new b(new d(this)));
        goto L69
    L63:
        if (r23.isEmpty() == true) goto L66;
        r24 = false;
        goto L67
    L59:
        r22 = null;
    L69:
        LarusPageChangeAppIconBinding r25 = this.e;
        if (r25 == null) goto L74;
        RecyclerView r26 = r25.b;
        if (r26 == null) goto L74;
        r26.setItemAnimator(null);
    L74:
        this.f = r15;
        this.s = new ArrayList();
        LinkedHashMap r27 = new LinkedHashMap();
        if (r19.w0().b() == false) goto L79;
        AudioUserConfig r28 = (AudioUserConfig) AudioServiceDelegate.a.p().getValue();
        if (r28 == null) goto L84;
        List r29 = r28.getNewVoiceList();
    L85:
        if (r29 == null) goto L90;
        List r30 = r29;
        ArrayList r31 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r30, 10));
        Iterator r32 = r30.iterator();
    L88:
        if (r32.hasNext() == false) goto L90;
        SpeakerVoice r33 = (SpeakerVoice) r32.next();
        r31.add((SpeakerVoice) r27.put(r33.getId(), r33));
    L90:
        e0 r34 = (e0) AuthModelDelegate.b.e().getValue();
        if (r34 == null) goto L116;
        LaunchInfo r35 = r34.a;
        if (r35 == null) goto L116;
        List r36 = r35.s();
        if (r36 == null) goto L116;
        Iterator r37 = r36.iterator();
    L98:
        if (r37.hasNext() == false) goto L116;
        CocoSetting r210 = (CocoSetting) r37.next();
        Integer r211 = r210.a();
        boolean r38 = HomeService.a.s().containsKey(r210.a());
        LinkedHashMap r39 = new LinkedHashMap();
        Map r40 = r210.i();
        if (r40 == null) goto L105;
        Iterator r41 = r40.entrySet().iterator();
    L103:
        if (r41.hasNext() == false) goto L105;
        Map.Entry r42 = (Map.Entry) r41.next();
        r39.put(r42.getKey(), r27.get(r42.getValue()));
    L105:
        if (r38 == false) goto L98;
        List<com.larus.setting.impl.iconchanger.b> r43 = this.s;
        if (r43 == null) goto L98;
        int r44 = this.g;
        if (r211 != null) goto L112;
    L114:
        boolean r110 = false;
    L115:
        r43.add(new com.larus.setting.impl.iconchanger.b(false, 0, r110, ChangeAppIconManager.a(), r210.i(), r39, r211, -1, r210));
        goto L98
    L112:
        if (r211.intValue() != r44) goto L114;
        r110 = true;
    L116:
        final ?? r45 = new j(this, r15);
        LarusPageChangeAppIconBinding r46 = this.e;
        if (r46 == null) goto L122;
        final RecyclerView r47 = r46.b;
        if (r47 == null) goto L122;
        r47.post(new n(this, r47, r45));
    L122:
        if (Intrinsics.areEqual(this.o, "registration_process") == false) goto L124;
        int r48 = AppIconsType.DEFAULT.getAppIconId();
        this.h = r48;
        this.u = "zh";
        this.g = r48;
        aa0();
        ca0();
    L126:
        if (da0() == true) goto L128;
    L146:
        LarusPageChangeAppIconBinding r49 = this.e;
        if (r49 == null) goto L152;
        ItemGroup r50 = r49.h;
        if (r50 == null) goto L152;
        e1.o(r50);
    L152:
        if (Intrinsics.areEqual(this.o, "registration_process") == false) goto L208;
        WeakReference<CommonDialog> r51 = ChangeAppIconManager.a;
        if (Build.VERSION.SDK_INT < 29) goto L156;
        boolean r52 = true;
    L157:
        if (r52 == false) goto L163;
        LarusPageChangeAppIconBinding r53 = this.e;
        if (r53 == null) goto L168;
        TextView r54 = r53.g;
        if (r54 == null) goto L168;
        e1.x(r54);
    L168:
        LarusPageChangeAppIconBinding r55 = this.e;
        if (r55 == null) goto L173;
        ImageView r58 = r55.c;
        if (r58 == null) goto L173;
        e1.o(r58);
    L173:
        LarusPageChangeAppIconBinding r59 = this.e;
        if (r59 == null) goto L178;
        RoundFrameLayout r60 = r59.f;
        if (r60 == null) goto L178;
        e1.x(r60);
    L178:
        LarusPageChangeAppIconBinding r61 = this.e;
        if (r61 == null) goto L183;
        ItemGroup r62 = r61.h;
        if (r62 == null) goto L183;
        e1.o(r62);
    L183:
        LarusPageChangeAppIconBinding r63 = this.e;
        if (r63 == null) goto L188;
        TextView r64 = r63.e;
        if (r64 == null) goto L188;
        r64.setText(getString(2131908753));
    L188:
        LarusPageChangeAppIconBinding r65 = this.e;
        if (r65 == null) goto L193;
        TextView r66 = r65.d;
        if (r66 == null) goto L193;
        r66.setTextSize(24.0f);
    L193:
        LarusPageChangeAppIconBinding r67 = this.e;
        if (r67 == null) goto L198;
        TextView r68 = r67.d;
        if (r68 == null) goto L198;
        r68.setText(getString(2131900719, new Object[]{AppHost.a.getAppStringName()}));
    L198:
        LarusPageChangeAppIconBinding r69 = this.e;
        if (r69 == null) goto L203;
        TextView r70 = r69.g;
        if (r70 == null) goto L203;
        r70.setText(getString(2131900717));
    L203:
        LarusPageChangeAppIconBinding r71 = this.e;
        if (r71 == null) goto L248;
        RoundFrameLayout r72 = r71.f;
        if (r72 == null) goto L248;
        e1.d(r72, new c(this));
    L248:
        String r73 = this.q;
        if (r73 != null) goto L251;
    L252:
        r7 = true;
    L253:
        if (r7 == false) goto L255;
        a1.c(null, null, null, null, null, "bot_image_setting", null, null, this.o, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, this, null, null, null, null, null, null, null, -1153, -16777217, 7);
        return;
    L255:
        a1.c(null, null, null, null, null, "bot_image_setting", null, null, this.o, null, null, null, null, null, null, null, this.q, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, this, null, null, null, null, null, null, null, -1049729, -16777217, 7);
        return;
    L251:
        if (r73.length() != 0) goto L253;
    L163:
        LarusPageChangeAppIconBinding r74 = this.e;
        if (r74 == null) goto L168;
        TextView r75 = r74.g;
        if (r75 == null) goto L168;
        e1.o(r75);
        goto L168
    L156:
        r52 = false;
        goto L157
    L208:
        LarusPageChangeAppIconBinding r76 = this.e;
        if (r76 == null) goto L213;
        ImageView r77 = r76.c;
        if (r77 == null) goto L213;
        e1.x(r77);
    L213:
        LarusPageChangeAppIconBinding r78 = this.e;
        if (r78 == null) goto L218;
        RoundFrameLayout r79 = r78.f;
        if (r79 == null) goto L218;
        e1.x(r79);
    L218:
        LarusPageChangeAppIconBinding r80 = this.e;
        if (r80 == null) goto L223;
        TextView r81 = r80.e;
        if (r81 == null) goto L223;
        r81.setText(getString(2131900715));
    L223:
        LarusPageChangeAppIconBinding r82 = this.e;
        if (r82 == null) goto L228;
        TextView r83 = r82.d;
        if (r83 == null) goto L228;
        r83.setText(getString(2131900723));
    L228:
        LarusPageChangeAppIconBinding r84 = this.e;
        if (r84 == null) goto L233;
        TextView r85 = r84.d;
        if (r85 == null) goto L233;
        r85.setTextSize(17.0f);
    L233:
        LarusPageChangeAppIconBinding r86 = this.e;
        if (r86 == null) goto L238;
        TextView r87 = r86.g;
        if (r87 == null) goto L238;
        e1.o(r87);
    L238:
        LarusPageChangeAppIconBinding r88 = this.e;
        if (r88 == null) goto L243;
        RoundFrameLayout r89 = r88.f;
        if (r89 == null) goto L243;
        e1.d(r89, new g(this));
    L243:
        LarusPageChangeAppIconBinding r90 = this.e;
        if (r90 == null) goto L248;
        ImageView r91 = r90.c;
        if (r91 == null) goto L248;
        e1.d(r91, new h(this));
        goto L248
    L128:
        if (z2.a.m3() == false) goto L146;
        LarusPageChangeAppIconBinding r92 = this.e;
        if (r92 == null) goto L134;
        ItemGroup r93 = r92.h;
        if (r93 == null) goto L134;
        e1.x(r93);
    L134:
        LarusPageChangeAppIconBinding r94 = this.e;
        if (r94 == null) goto L141;
        ItemTextArrow r95 = r94.i;
        if (r95 == null) goto L141;
        TextView r96 = r95.getSubTextView();
        if (r96 == null) goto L141;
        r96.setText(getString(2131900714));
    L141:
        LarusPageChangeAppIconBinding r97 = this.e;
        if (r97 == null) goto L152;
        ItemGroup r98 = r97.h;
        if (r98 == null) goto L152;
        e1.d(r98, new k(this));
        goto L152
    L124:
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new ChangeAppIconFragment$initCurrentAppIconId$1(this, null));
    L84:
        r29 = null;
        goto L85
    L79:
        e0 r99 = (e0) r4.e().getValue();
        if (r99 == null) goto L84;
        LaunchInfo r100 = r99.a;
        if (r100 == null) goto L84;
        r29 = r100.T0();
        goto L85
    L47:
        r14 = null;
        goto L48
    L43:
        r12 = null;
    L39:
        r10 = "";
        goto L40
    L25:
        if (this.m.length() != 0) goto L27;
        boolean r101 = true;
    L28:
        if (r101 == false) goto L35;
        if (r6.length() <= 0) goto L32;
        boolean r102 = true;
    L33:
        if (r102 == false) goto L35;
        FLogger.a.i("ChangeAppIconFragment", "set conversationId with defaultMainBotCvsId: ".concat(r6));
        this.n = r6;
        goto L35
    L32:
        r102 = false;
        goto L33
    L27:
        r101 = false;
        goto L28
    L21:
        r8 = false;
        goto L23
    L15:
        r6 = null;
    L11:
        r3 = "";
    L6:
        r1 = "";
        goto L7
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        ConstraintLayout r14 = r11.inflate(2131563007, r12, false);
        int r15 = 2131363093;
        RecyclerView r2 = ViewBindings.findChildViewById(r14, 2131363093);
        if (r2 == null) goto L24;
        r15 = 2131363766;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r14, 2131363766);
        if (r3 == null) goto L24;
        r15 = 2131364507;
        if (ViewBindings.findChildViewById(r14, 2131364507) == null) goto L24;
        ConstraintLayout r16 = r14;
        int r17 = 2131379424;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r14, 2131379424);
        if (r4 == null) goto L26;
        r17 = 2131387203;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r14, 2131387203);
        if (r5 == null) goto L26;
        r17 = 2131387242;
        RoundFrameLayout r6 = ViewBindings.findChildViewById(r14, 2131387242);
        if (r6 == null) goto L26;
        r17 = 2131387517;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r14, 2131387517);
        if (r7 == null) goto L26;
        r17 = 2131389236;
        if (ViewBindings.findChildViewById(r14, 2131389236) == null) goto L26;
        r17 = 2131392723;
        ItemGroup r8 = ViewBindings.findChildViewById(r14, 2131392723);
        if (r8 == null) goto L26;
        r17 = 2131392642;
        ItemTextArrow r9 = ViewBindings.findChildViewById(r14, 2131392642);
        if (r9 == null) goto L26;
        this.e = new LarusPageChangeAppIconBinding(r16, r2, r3, r4, r5, r6, r7, r8, r9);
        return r16;
    L26:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r17)));
    L24:
        r17 = r15;
        goto L26
    }

    public final Object W90(String r9, boolean r10, String r11, Continuation<? super BotModel> r12) {
        if ((r12 instanceof ChangeAppIconFragment$findBotInfo$1) == false) goto L7;
        ChangeAppIconFragment$findBotInfo$1 r0 = (ChangeAppIconFragment$findBotInfo$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        ChangeAppIconFragment$findBotInfo$1 r6 = r0;
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
        FLogger.a.i("ChangeAppIconFragment", "Found bot info: ".concat(r17));
        r6.L$0 = null;
        r6.L$1 = null;
        r6.label = 2;
        r13 = IBotRepoService.b.a(r4, r17, r5, r7, false, r6, 24);
        if (r13 != r2) goto L26;
        return r2;
    L16:
        ResultKt.throwOnFailure(r13);
        IBotRepoService r18 = zh8.a.e;
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
        r0 = new ChangeAppIconFragment$findBotInfo$1(this, r12);
        goto L8
    }
}
