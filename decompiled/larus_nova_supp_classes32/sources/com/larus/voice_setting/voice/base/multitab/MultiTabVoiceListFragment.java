package com.larus.voice_setting.voice.base.multitab;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.audio.bean.GetMatchVoiceRequest;
import com.larus.audio.bean.VoiceListTabInfo;
import com.larus.bmhome.utils.LoadMoreManager;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.impl.databinding.LarusFragmentMineVoiceListBinding;
import com.larus.voice_setting.impl.databinding.LarusVoiceListErrorBinding;
import com.larus.voice_setting.voice.DoubleTabTtsSpeakerSettingFragment;
import com.larus.voice_setting.voice.Page;
import com.larus.voice_setting.voice.TtsSpeakerSettingViewModel;
import com.larus.voice_setting.voice.VoiceItemAdapter;
import com.larus.voice_setting.voice.base.VoiceDisplayScene;
import com.larus.voice_setting.voice.base.VoiceListFragment;
import com.larus.voice_setting.voice.o2;
import com.larus.voice_setting.voice.t2;
import com.larus.voice_setting.voice.u2;
import com.larus.voice_setting.voice.utils.k;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010$\u001a\u00020\u0019H\u0016J\b\u0010%\u001a\u00020\u0019H\u0002J\n\u0010&\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010'\u001a\u00020\u00192\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\b\u0010+\u001a\u00020\u0019H\u0016J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020*H\u0002J\b\u0010.\u001a\u00020\u0019H\u0002J\n\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001e\u00101\u001a\u00020\u00192\f\u00102\u001a\b\u0012\u0004\u0012\u0002030)2\u0006\u00104\u001a\u000205H\u0002J\u001a\u00106\u001a\u0002052\u0006\u00107\u001a\u0002032\b\u00108\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u00109\u001a\u00020\u0019H\u0002J\b\u0010:\u001a\u00020\u0019H\u0002J\u0010\u0010;\u001a\u00020\u00192\u0006\u0010<\u001a\u000205H\u0002J\b\u0010=\u001a\u00020\u0019H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/larus/voice_setting/voice/base/multitab/MultiTabVoiceListFragment;", "Lcom/larus/voice_setting/voice/base/VoiceListFragment;", "<init>", "()V", "binding", "Lcom/larus/voice_setting/impl/databinding/LarusFragmentMineVoiceListBinding;", "tag", NameKeys.UnloadStrategy_No_Strategy, "loadMoreManager", "Lcom/larus/bmhome/utils/LoadMoreManager;", "userId", "recommendRequest", "Lcom/larus/audio/bean/GetMatchVoiceRequest;", "createTimeStamp", NameKeys.UnloadStrategy_No_Strategy, "tabModel", "Lkotlin/Lazy;", "Lcom/larus/voice_setting/voice/base/multitab/MultiTabViewModel;", "tab", "Lcom/larus/audio/bean/VoiceListTabInfo;", "fpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreate", NameKeys.UnloadStrategy_No_Strategy, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "setupRecommendData", "getMultiTabKey", "initRecyclerView", "ugcVoiceList", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/voice_setting/voice/VoiceItem;", "onLeaveMineTab", "clickItem", "item", "initObservers", "getBotInfo", "Lcom/larus/im/bean/bot/BotModel;", "setupTtsSpeakers", "newUgcVoiceList", "Lcom/larus/im/bean/bot/SpeakerVoice;", "recommendV2", NameKeys.UnloadStrategy_No_Strategy, "voiceEnable", "voice", "botId", "initViewWithLoading", "recommendV2Observers", "showVoiceExceptionView", "isEmpty", "dismissVoiceExceptionView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiTabVoiceListFragment extends VoiceListFragment {
    public static final /* synthetic */ int F = 0;
    public LoadMoreManager A;
    public GetMatchVoiceRequest B;
    public final Lazy<MultiTabViewModel> C;
    public VoiceListTabInfo D;
    public final et3.c E;
    public LarusFragmentMineVoiceListBinding y;
    public final String z;

    public static final class a {
    }

    public static final class b implements u2 {
        public final /* synthetic */ MultiTabVoiceListFragment a;

        public b(MultiTabVoiceListFragment r1) {
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
            final MultiTabVoiceListFragment r8 = this.a;
            int r0 = MultiTabVoiceListFragment.F;
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
            f2a.c r11 = k.a.b("click voice item");
            r11.e(new h(r9, r8));
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

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(g r2) {
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

    @Override // com.larus.voice_setting.voice.base.VoiceListFragment
    public final String fa0() {
        VoiceListTabInfo r0 = this.D;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
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

    public MultiTabVoiceListFragment() {
        this.z = "MultiTabVoiceListFragment" + hashCode();
        this.C = FragmentViewModelLazyKt.createViewModelLazy$default(this, Reflection.getOrCreateKotlinClass(MultiTabViewModel.class), new com.larus.voice_setting.voice.base.multitab.c(this), null, 4, null);
        this.E = new et3.c("List_MultiTabVoice", false, null);
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
    public final void onDestroyView() {
        super.onDestroyView();
        LarusFragmentMineVoiceListBinding r0 = this.y;
        if (r0 == null) goto L7;
        RecyclerView r1 = r0.e;
        if (r1 == null) goto L7;
        r1.clearOnScrollListeners();
        r1.setAdapter(null);
    L7:
        this.A = null;
        this.y = null;
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment
    public final String tag() {
        return this.z;
    }

    @Override // com.larus.voice_setting.voice.base.VoiceListFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        SystemClock.uptimeMillis();
        Bundle r4 = getArguments();
        if (r4 == null) goto L6;
        r4.getString("public_voice_user_id", NameKeys.UnloadStrategy_No_Strategy);
        String r0 = r4.getString("key_public_voice_scene", VoiceDisplayScene.NONE);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.l = r0;
        this.B = r4.getParcelable("key_voice_recommend_param");
        this.D = r4.getParcelable("key_voice_multi_tab");
        this.s = r4.getString("key_enter_method");
        return;
    }

    public final void qa0(List<o2> r13) {
        LarusFragmentMineVoiceListBinding r0 = this.y;
        if (r0 == null) goto L18;
        RecyclerView r1 = r0.e;
        if (r1 == null) goto L19;
        r1.setLayoutManager(new LinearLayoutManager(r1.getContext()));
        Page r5 = Page.MULTI_TAB;
        VoiceListTabInfo r2 = this.D;
        if (r2 == null) goto L10;
        String r3 = r2.b();
        if (r3 == null) goto L10;
    L11:
        VoiceItemAdapter r4 = new VoiceItemAdapter(r13, new t2(false, false, r5, r3, ((TtsSpeakerSettingViewModel) this.o.getValue()).getVoiceCanEdit(), ((TtsSpeakerSettingViewModel) this.o.getValue()).getSelectVoiceMode(), new d(this), 3));
        r4.c = new b(this);
        r1.setAdapter(r4);
        RecyclerView.Adapter r14 = r1.getAdapter();
        if (r14 == null) goto L16;
        LoadMoreManager r6 = this.A;
        if (r6 == null) goto L16;
        r6.d(r1, r14);
    L16:
        r1.setItemViewCacheSize(20);
        r1.addOnScrollListener(new MultiTabVoiceListFragment$initRecyclerView$1$4(this));
        y6.d(r1, new e(this), null, null, new f(this), 12);
        return;
    L10:
        r3 = NameKeys.UnloadStrategy_No_Strategy;
        goto L11
    L19:
        return;
    }

    public final void sa0(boolean r5) {
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

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.voice_setting.voice.base.multitab.g] */
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        FLogger.a.i(this.z, "[onViewCreated]");
        super.onViewCreated(r4, r5);
        if (this.C.isInitialized() == true) goto L21;
        Context r6 = getContext();
        if (r6 == null) goto L7;
        this.A = new LoadMoreManager(r6, new com.larus.voice_setting.voice.base.multitab.a(this), null);
    L7:
        MultiTabViewModel r7 = (MultiTabViewModel) this.C.getValue();
        GetMatchVoiceRequest r8 = this.B;
        String r0 = NameKeys.UnloadStrategy_No_Strategy;
        if (r8 == null) goto L11;
        String r1 = r8.d;
        if (r1 == null) goto L11;
    L12:
        if (r8 == null) goto L17;
        String r9 = r8.f;
        if (r9 == null) goto L17;
        r0 = r9;
    L17:
        VoiceListTabInfo r10 = this.D;
        if (r10 != null) goto L20;
        r10 = new VoiceListTabInfo(0);
    L20:
        r7.setupViewModel(r1, r0, r10);
        ra0();
        ((MultiTabViewModel) this.C.getValue()).queryTabVoiceList(getViewLifecycleOwner());
    L11:
        r1 = NameKeys.UnloadStrategy_No_Strategy;
    L21:
        ((MultiTabViewModel) this.C.getValue()).getTabVoiceLiveData().observe(getViewLifecycleOwner(), new c(new g(this)));
        TtsSpeakerSettingViewModel r11 = (TtsSpeakerSettingViewModel) this.o.getValue();
        ja0();
        LarusFragmentMineVoiceListBinding r12 = this.y;
        if (r12 == null) goto L29;
        LarusVoiceListErrorBinding r13 = r12.c;
        if (r13 == null) goto L30;
        ConstraintLayout r14 = r13.b;
        if (r14 == null) goto L31;
        e1.d(r14, new com.larus.voice_setting.voice.base.multitab.b(this));
        return;
    L31:
        return;
    L30:
        return;
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        FLogger.a.i(this.z, "[onCreateView] scene: " + this.l + ", language:" + this.j);
        LarusFragmentMineVoiceListBinding r7 = LarusFragmentMineVoiceListBinding.a(r4, r5);
        this.y = r7;
        return r7.a;
    }
}
