package com.larus.voice_setting.voice.base;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.audio.bean.GetMatchVoiceRequest;
import com.larus.audio.bean.RecommendScene;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureConfig;
import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.utils.LoadMoreManager;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.impl.databinding.LarusFragmentMineVoiceListBinding;
import com.larus.voice_setting.impl.databinding.LarusVoiceListErrorBinding;
import com.larus.voice_setting.voice.DoubleTabTtsSpeakerSettingFragment;
import com.larus.voice_setting.voice.Page;
import com.larus.voice_setting.voice.TtsSpeakerSettingViewModel;
import com.larus.voice_setting.voice.UgcVoiceLoader;
import com.larus.voice_setting.voice.VoiceCreateAdapter;
import com.larus.voice_setting.voice.VoiceItemAdapter;
import com.larus.voice_setting.voice.bean.CacheStatus;
import com.larus.voice_setting.voice.o2;
import com.larus.voice_setting.voice.t2;
import com.larus.voice_setting.voice.u2;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.RiskPreferenceSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 J2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010+\u001a\u00020\u0017H\u0002J\b\u0010,\u001a\u00020\u0017H\u0002J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0.H\u0002J\u0018\u00101\u001a\u00020\u00172\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020403H\u0002J\b\u00105\u001a\u00020\u0017H\u0016J\u0010\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u000204H\u0002J\b\u00108\u001a\u00020\u0017H\u0002J\n\u00109\u001a\u0004\u0018\u00010:H\u0016J\u001e\u0010;\u001a\u00020\u00172\f\u0010<\u001a\b\u0012\u0004\u0012\u00020/032\u0006\u0010=\u001a\u00020\u001dH\u0002J\u001a\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020/2\b\u0010@\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010A\u001a\u00020\u0017H\u0002J\u0010\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u001dH\u0002J\u0010\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\u001dH\u0002J\b\u0010F\u001a\u00020\u0017H\u0002J\u000e\u0010G\u001a\u00020H*\u0004\u0018\u00010IH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/larus/voice_setting/voice/base/RecommendVoiceListFragment;", "Lcom/larus/voice_setting/voice/base/VoiceListFragment;", "<init>", "()V", "lastItemCount", NameKeys.UnloadStrategy_No_Strategy, "binding", "Lcom/larus/voice_setting/impl/databinding/LarusFragmentMineVoiceListBinding;", "tag", NameKeys.UnloadStrategy_No_Strategy, "loadMoreManager", "Lcom/larus/bmhome/utils/LoadMoreManager;", "userId", "recommendVoice", "Lcom/larus/voice_setting/VoiceRecommendConfig;", "recommendRequest", "Lcom/larus/audio/bean/GetMatchVoiceRequest;", "createTimeStamp", NameKeys.UnloadStrategy_No_Strategy, "fpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "startCreateVoice", "Lkotlin/Function0;", NameKeys.UnloadStrategy_No_Strategy, "getStartCreateVoice", "()Lkotlin/jvm/functions/Function0;", "setStartCreateVoice", "(Lkotlin/jvm/functions/Function0;)V", "addCopyMyVoiceItem", NameKeys.UnloadStrategy_No_Strategy, "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupRecommendData", "trackRecommendVoiceTime", "sortVoiceList", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/im/bean/bot/SpeakerVoice;", "speakerVoices", "initRecyclerView", "ugcVoiceList", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/voice_setting/voice/VoiceItem;", "onLeaveMineTab", "clickItem", "item", "initObservers", "getBotInfo", "Lcom/larus/im/bean/bot/BotModel;", "setupTtsSpeakers", "newUgcVoiceList", "recommendV2", "voiceEnable", "voice", "botId", "initViewWithLoading", "recommendV2Observers", "reportTime", "showVoiceExceptionView", "isEmpty", "dismissVoiceExceptionView", "toTrackParamsJsonObject", "Lkotlinx/serialization/json/JsonObject;", "Lorg/json/JSONObject;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecommendVoiceListFragment extends VoiceListFragment {
    public static final /* synthetic */ int I = 0;
    public LoadMoreManager A;
    public String B;
    public final p2a.p C;
    public GetMatchVoiceRequest D;
    public long E;
    public final et3.c F;
    public final a1 G;
    public boolean H;
    public LarusFragmentMineVoiceListBinding y;
    public final String z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CacheStatus.values().length];
            r0[CacheStatus.EMPTY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CacheStatus.LOADING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CacheStatus.CACHED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements u2 {
        public final /* synthetic */ RecommendVoiceListFragment a;

        public c(RecommendVoiceListFragment r1) {
            this.a = r1;
        }

        @Override // com.larus.voice_setting.voice.u2
        public final boolean a(o2 r2) {
            if (r2 != null) goto L6;
            return false;
        L6:
            return this.a.ma0(r2.a);
        }

        @Override // com.larus.voice_setting.voice.u2
        public final boolean d(o2 r3) {
            return VoiceListFragment.aa0(this.a, r3.a, 6);
        }

        @Override // com.larus.voice_setting.voice.u2
        public final void b(o2 r6, View r7) {
            Intrinsics.checkNotNullParameter(r7, "itemView");
            if (r6 != null) goto L5;
            return;
        L5:
            final RecommendVoiceListFragment r8 = this.a;
            int r0 = RecommendVoiceListFragment.I;
            r8.getClass();
            final SpeakerVoice r9 = r6.a;
            if (r9 == null) goto L34;
            VoiceItemAdapter r1 = r8.ia0();
            if (r1 == null) goto L23;
            List<o2> r2 = r1.a;
            if (r2 == null) goto L23;
            Iterator<T> r3 = r2.iterator();
        L14:
            if (r3.hasNext() == false) goto L21;
            Object r4 = r3.next();
            if (((o2) r4).b != 20) goto L18;
            boolean r5 = true;
        L19:
            if (r5 == false) goto L14;
        L22:
            o2 r10 = (o2) r4;
        L24:
            if (r10 == null) goto L26;
            FLogger.a.i(r8.z, "[clickItem] selecting other item, voice: " + r9);
            return;
        L26:
            FLogger.a.i(r8.z, "voice clicked: " + r9);
            f2a.c r11 = com.larus.voice_setting.voice.utils.k.a.b("click voice item");
            r11.e(new v0(r9, r8));
            r11.c.b = CollectionsKt.listOf("VoicePlay");
            f2a.c.c(r11, null, 15);
            r8.ca0(r9);
            return;
        L18:
            r5 = false;
            goto L19
        L21:
            r4 = null;
        L23:
            r10 = null;
            goto L24
        }

        @Override // com.larus.voice_setting.voice.u2
        public final void c(o2 r1, View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
        }
    }

    public static final class d implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public d(Function1 r2) {
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

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment
    public final void T90() {
        LarusFragmentMineVoiceListBinding r0 = this.y;
        if (r0 == null) goto L8;
        RecyclerView r1 = r0.e;
        if (r1 == null) goto L9;
        y6.i(r1);
        return;
    L9:
        return;
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment
    public final RecyclerView getRecyclerView() {
        LarusFragmentMineVoiceListBinding r0 = this.y;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    public final void pa0() {
        LarusFragmentMineVoiceListBinding r0 = this.y;
        if (r0 == null) goto L6;
        r0.d.setVisibility(8);
        r0.e.setVisibility(0);
        return;
    }

    public final void ra0() {
        if (this.y == null) goto L5;
        pa0();
    L5:
        ArrayList r0 = new ArrayList();
        int r1 = 1;
    L7:
        if (r1 >= 21) goto L9;
        r0.add(new o2(null, 0, 0, 0, 1, 31, 0));
        r1 = r1 + 1;
        goto L7
    L9:
        LarusFragmentMineVoiceListBinding r2 = this.y;
        if (r2 == null) goto L14;
        RecyclerView r3 = r2.e;
        if (r3 == null) goto L14;
        RecyclerView.Adapter r4 = r3.getAdapter();
    L15:
        if (r4 == null) goto L22;
        VoiceItemAdapter r5 = ia0();
        if (r5 == null) goto L19;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r5.a = r0;
    L19:
        VoiceItemAdapter r6 = ia0();
        if (r6 == null) goto L23;
        r6.notifyDataSetChanged();
    L23:
        LoadMoreManager r7 = this.A;
        if (r7 == null) goto L28;
        r7.a();
        return;
    L28:
        return;
    L22:
        qa0(r0);
    L14:
        r4 = null;
        goto L15
    }

    public final void va0() {
        if (this.E != 0) goto L5;
        return;
    L5:
        long r0 = SystemClock.uptimeMillis() - this.E;
        this.E = 0;
        g1 r2 = g1.a;
        String r3 = this.m;
        boolean r4 = Da();
        Intrinsics.checkNotNullParameter(r3, "enterFrom");
        Intrinsics.checkNotNullParameter(RiskPreferenceSettings.SMART_BALANCE, "recommendType");
        com.larus.platform.service.o r5 = com.larus.platform.service.o.a;
        JSONObject r6 = new JSONObject();
        r6.put("enter_from", r3);
        r6.put("time", r0);
        r6.put("recommend_type", RiskPreferenceSettings.SMART_BALANCE);
        r6.put("is_main_bot", r4 ? 1 : 0);
        Unit r1 = Unit.INSTANCE;
        r5.reportEvent("recommend_voice_tti", r6);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.voice_setting.voice.base.a1] */
    public RecommendVoiceListFragment() {
        this.z = "PublicVoiceListFragment" + hashCode();
        this.B = NameKeys.UnloadStrategy_No_Strategy;
        this.C = com.larus.voice_setting.voice.utils.f.a.c();
        this.F = new et3.c("List_RecommendVoice", false, null);
        this.G = new a1();
    }

    @Override // com.larus.voice_setting.voice.base.VoiceListFragment
    public final BotModel B0() {
        DoubleTabTtsSpeakerSettingFragment r0 = getParentFragment();
        if ((r0 instanceof DoubleTabTtsSpeakerSettingFragment) == false) goto L5;
        DoubleTabTtsSpeakerSettingFragment r1 = r0;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.g;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment
    public final String tag() {
        return this.z;
    }

    @Override // com.larus.voice_setting.voice.base.VoiceListFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        this.E = SystemClock.uptimeMillis();
        Bundle r5 = getArguments();
        if (r5 == null) goto L5;
        this.B = r5.getString("public_voice_user_id", NameKeys.UnloadStrategy_No_Strategy);
        String r0 = r5.getString("key_public_voice_scene", VoiceDisplayScene.NONE);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.l = r0;
        this.D = r5.getParcelable("key_voice_recommend_param");
        this.H = r5.getBoolean("add_copy_my_voice_item");
        this.s = r5.getString("key_enter_method");
    L5:
        Context r6 = getContext();
        if (r6 != null) goto L9;
        return;
    L9:
        if (this.C.a == false) goto L11;
        this.A = new LoadMoreManager(r6, new b1(this), null);
        return;
    L11:
        this.A = new LoadMoreManager(r6, new c1(this), null);
        ((TtsSpeakerSettingViewModel) this.o.getValue()).requestPublicVoiceList(true, this.B, this.j);
    }

    public final void qa0(List<o2> r14) {
        LarusFragmentMineVoiceListBinding r0 = this.y;
        if (r0 == null) goto L24;
        RecyclerView r1 = r0.e;
        if (r1 == null) goto L25;
        r1.setLayoutManager(new LinearLayoutManager(r1.getContext()));
        if (this.C.a == false) goto L9;
        Page r2 = Page.VOICE_RECOMMEND_TAB;
    L10:
        VoiceItemAdapter r3 = new VoiceItemAdapter(r14, new t2(false, false, r2, "rec_tab", ((TtsSpeakerSettingViewModel) this.o.getValue()).getVoiceCanEdit(), ((TtsSpeakerSettingViewModel) this.o.getValue()).getSelectVoiceMode(), new d1(this), 3));
        r3.c = new c(this);
        this.F.e(r1);
        if (this.H == false) goto L17;
        RecyclerView.Adapter[] r4 = new RecyclerView.Adapter[1];
        LoadMoreManager r5 = this.A;
        if (r5 == null) goto L15;
        ConcatAdapter r6 = r5.d(r1, r3);
    L16:
        r4[0] = r6;
        ConcatAdapter r15 = new ConcatAdapter(r4);
        r1.setAdapter(r15);
        VoiceCreateAdapter r7 = new VoiceCreateAdapter(new t2(ka0(), true, null, null, false, 0, new e1(this), 60));
        r7.b = new f1(this);
        Unit r8 = Unit.INSTANCE;
        r15.addAdapter(0, r7);
    L22:
        r1.setItemViewCacheSize(20);
        y6.d(r1, new s0(this), null, null, new t0(this), 12);
        return;
    L15:
        r6 = null;
        goto L16
    L17:
        r1.setAdapter(r3);
        RecyclerView.Adapter r16 = r1.getAdapter();
        if (r16 == null) goto L22;
        LoadMoreManager r9 = this.A;
        if (r9 == null) goto L22;
        r9.d(r1, r16);
        goto L22
    L9:
        r2 = Page.UGC_RECOMMEND_TAB;
        goto L10
    L25:
        return;
    }

    public final void sa0(final boolean r4) {
        UgcVoiceLoader r0 = UgcVoiceLoader.a;
        UgcVoiceLoader.l.observe(getViewLifecycleOwner(), new d(new u0(this, r4)));
    }

    public final void ua0(boolean r5) {
        LarusFragmentMineVoiceListBinding r0 = this.y;
        if (r0 == null) goto L9;
        r0.d.setVisibility(0);
        r0.e.setVisibility(8);
        if (r5 == false) goto L7;
        r0.b.a.setVisibility(0);
        r0.c.a.setVisibility(8);
        return;
    L7:
        r0.b.a.setVisibility(8);
        r0.c.a.setVisibility(0);
        return;
    }

    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        FLogger.a.i(this.z, "[onViewCreated]");
        super.onViewCreated(r14, r15);
        if (this.C.a == false) goto L66;
        GetMatchVoiceRequest r16 = this.D;
        Integer r0 = null;
        if (r16 == null) goto L7;
        RecommendScene r1 = r16.g;
    L9:
        if (r1 == null) goto L16;
        if (r16 == null) goto L12;
        RecommendScene r17 = r16.g;
    L13:
        UgcVoiceLoader r2 = UgcVoiceLoader.a;
        if (r17 != UgcVoiceLoader.n) goto L16;
        CacheStatus r18 = UgcVoiceLoader.m;
    L17:
        g1 r3 = g1.a;
        String r4 = this.m;
        int r5 = r18.getLog();
        Intrinsics.checkNotNullParameter(r4, "enterFrom");
        com.larus.platform.service.o r6 = com.larus.platform.service.o.a;
        JSONObject r7 = new JSONObject();
        r7.put("enter_from", r4);
        r7.put("is_hit", r5);
        Unit r8 = Unit.INSTANCE;
        r6.reportEvent("hit_preload_recommend_voice", r7);
        int r19 = b.a[r18.ordinal()];
        if (r19 != 1) goto L20;
        ra0();
        UgcVoiceLoader r110 = UgcVoiceLoader.a;
        GetMatchVoiceRequest r111 = this.D;
        if (r111 != null) goto L65;
        r111 = new GetMatchVoiceRequest(null, null, null, null, 0, null, null, 127);
    L65:
        UgcVoiceLoader.i(r111, Da());
        sa0(true);
    L67:
        TtsSpeakerSettingViewModel r112 = (TtsSpeakerSettingViewModel) this.o.getValue();
        ja0();
        LarusFragmentMineVoiceListBinding r113 = this.y;
        if (r113 == null) goto L74;
        LarusVoiceListErrorBinding r114 = r113.c;
        if (r114 == null) goto L74;
        ConstraintLayout r115 = r114.b;
        if (r115 == null) goto L74;
        com.larus.utils.e1.d(r115, new r0(this));
    L74:
        r112.isFallBackToSystemVoice().observe(getViewLifecycleOwner(), new d(new x0(this)));
        if (this.C.a == true) goto L77;
        r112.getPublicVoiceLiveData().observe(getViewLifecycleOwner(), new d(new y0(this)));
    L77:
        r112.getLoadMoreState().observe(getViewLifecycleOwner(), new d(new z0(this)));
        return;
    L20:
        if (r19 != 2) goto L22;
        ra0();
        sa0(true);
        goto L67
    L22:
        if (r19 != 3) goto L60;
        UgcVoiceLoader r116 = UgcVoiceLoader.a;
        r2a.e r117 = (r2a.e) UgcVoiceLoader.l.getValue();
        if (r117 == null) goto L27;
        List<SpeakerVoice> r9 = r117.a;
        if (r9 == null) goto L27;
    L29:
        if (r9.isEmpty() == false) goto L34;
        ra0();
        GetMatchVoiceRequest r118 = this.D;
        if (r118 != null) goto L33;
        r118 = new GetMatchVoiceRequest(null, null, null, null, 0, null, null, 127);
    L33:
        UgcVoiceLoader.i(r118, Da());
        sa0(true);
        goto L67
    L34:
        va0();
        ta0(r9, true);
        if (r117 == null) goto L37;
        r0 = r117.b;
    L37:
        if (r0 != null) goto L40;
    L44:
        if (r0 != null) goto L47;
    L51:
        if (r0 != null) goto L54;
    L58:
        sa0(false);
        goto L67
    L54:
        if (r0.intValue() != 1) goto L58;
        LoadMoreManager r119 = this.A;
        if (r119 == null) goto L58;
        r119.b();
        goto L58
    L47:
        if (r0.intValue() != 2) goto L51;
        LoadMoreManager r120 = this.A;
        if (r120 == null) goto L58;
        r120.a();
        goto L58
    L40:
        if (r0.intValue() != 0) goto L44;
        LoadMoreManager r121 = this.A;
        if (r121 == null) goto L58;
        r121.c();
    L27:
        r9 = new ArrayList();
        goto L29
    L60:
        throw new NoWhenBranchMatchedException();
    L12:
        r17 = null;
    L16:
        UgcVoiceLoader r122 = UgcVoiceLoader.a;
        r18 = CacheStatus.EMPTY;
        UgcVoiceLoader.m = r18;
        UgcVoiceLoader.n = RecommendScene.NULL;
        UgcVoiceLoader.c = 1;
        UgcVoiceLoader.k.setValue(null);
        goto L17
    L7:
        r1 = null;
        goto L9
    L66:
        ta0(((TtsSpeakerSettingViewModel) this.o.getValue()).getPreloadRecommendVoiceList(), false);
        goto L67
    }

    public final void ta0(List<SpeakerVoice> r14, boolean r15) {
        FLogger r0 = FLogger.a;
        String r1 = this.z;
        StringBuilder r2 = new StringBuilder("[setupTtsSpeakers] select:");
        r2.append(((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().j);
        r2.append(", init:");
        r2.append(this.n);
        r2.append(", bot:");
        BotModel r3 = B0();
        RecyclerView.Adapter r4 = null;
        if (r3 == null) goto L5;
        SpeakerVoice r5 = r3.getVoiceType();
    L6:
        r2.append(r5);
        r0.i(r1, r2.toString());
        ArrayList r6 = new ArrayList();
        Iterator<T> r16 = r14.iterator();
    L8:
        if (r16.hasNext() == false) goto L54;
        Object r7 = r16.next();
        SpeakerVoice r8 = (SpeakerVoice) r7;
        boolean r9 = false;
        if (Intrinsics.areEqual(r8.getLanguageCode(), this.j) == false) goto L12;
    L13:
        BotModel r10 = B0();
        if (r10 == null) goto L16;
        String r11 = r10.getBotId();
    L17:
        com.larus.bmhome.chat.api.e0 r12 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r12 == null) goto L28;
        LaunchInfo r13 = r12.a;
        if (r13 == null) goto L28;
        FeatureConfig r17 = r13.y0();
        if (r17 == null) goto L28;
        FeatureDetail r18 = r17.I();
        if (r18 == null) goto L28;
        if (r18.b() != true) goto L28;
        boolean r19 = true;
    L29:
        if (r19 == false) goto L49;
        if (r11 != null) goto L39;
        List r20 = r8.getExclusiveBotIds();
        if (r20 != null) goto L34;
    L37:
        boolean r21 = true;
    L38:
        if (r21 == true) goto L49;
    L34:
        if (r20.isEmpty() == true) goto L37;
        r21 = false;
    L39:
        if (r11 == null) goto L48;
        List r22 = r8.getExclusiveBotIds();
        if (r22 != null) goto L43;
    L45:
        boolean r23 = false;
    L46:
        if (r23 == true) goto L48;
    L43:
        if (r22.contains(Long.valueOf(CastLongProtector.parseLong(r11))) == true) goto L45;
        r23 = true;
    L48:
        boolean r24 = false;
    L50:
        if (r24 == false) goto L52;
        r9 = true;
    L52:
        if (r9 == false) goto L8;
        r6.add(r7);
    L49:
        r24 = true;
    L28:
        r19 = false;
        goto L29
    L16:
        r11 = null;
        goto L17
    L12:
        if (com.larus.voice_setting.voice.utils.l.a() == false) goto L52;
    L54:
        List r110 = CollectionsKt.toMutableList(r6);
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r111 = r110.iterator();
    L56:
        if (r111.hasNext() == false) goto L58;
        SpeakerVoice r26 = (SpeakerVoice) r111.next();
        r25.add(new o2(r26, ga0(r26), 1, da0(r26), 0, 40, 0));
        goto L56
    L58:
        FLogger.a.i(this.z, "[setupTtsSpeakers] voiceList:" + r25);
        if (r15 == true) goto L61;
    L67:
        pa0();
        LarusFragmentMineVoiceListBinding r112 = this.y;
        if (r112 == null) goto L72;
        RecyclerView r113 = r112.e;
        if (r113 == null) goto L72;
        r4 = r113.getAdapter();
    L72:
        if (r4 == null) goto L79;
        VoiceItemAdapter r114 = ia0();
        if (r114 == null) goto L76;
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r114.a = r25;
    L76:
        VoiceItemAdapter r115 = ia0();
        if (r115 == null) goto L90;
        r115.notifyDataSetChanged();
        return;
    L90:
        return;
    L79:
        qa0(r25);
        return;
    L61:
        if (r25.isEmpty() == false) goto L67;
        LarusFragmentMineVoiceListBinding r116 = this.y;
        if (r116 == null) goto L87;
        RecyclerView r117 = r116.e;
        if (r117 == null) goto L88;
        r117.setVisibility(8);
        return;
    L88:
        return;
    L87:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        FLogger.a.i(this.z, "[onCreateView] scene: " + this.l + ", language:" + this.j);
        LarusFragmentMineVoiceListBinding r7 = LarusFragmentMineVoiceListBinding.a(r4, r5);
        this.y = r7;
        return r7.a;
    }
}
