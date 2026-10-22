package com.larus.voice_setting.voice.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.utils.LoadMoreManager;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.impl.databinding.LarusFragmentMineVoiceListBinding;
import com.larus.voice_setting.impl.databinding.LarusMyVoiceListEmptyBinding;
import com.larus.voice_setting.impl.databinding.LarusVoiceListErrorBinding;
import com.larus.voice_setting.voice.DoubleTabTtsSpeakerSettingFragment;
import com.larus.voice_setting.voice.TtsSpeakerSettingViewModel;
import com.larus.voice_setting.voice.UgcVoiceLoader;
import com.larus.voice_setting.voice.VoiceCreateAdapter;
import com.larus.voice_setting.voice.VoiceItemAdapter;
import com.larus.voice_setting.voice.o2;
import com.larus.voice_setting.voice.t2;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.i2;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\"\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010+\u001a\u00020\u001bH\u0016J\u001a\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020&2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0018\u0010.\u001a\u00020\u001b2\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\b\u00102\u001a\u00020\u001bH\u0002J\b\u00103\u001a\u00020\u001bH\u0002J\u0012\u00104\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u00106\u001a\u00020\u0007H\u0002J\u0010\u00107\u001a\u00020\u001b2\b\b\u0002\u00108\u001a\u00020\u0007J\u0010\u00109\u001a\u00020\u001b2\u0006\u0010:\u001a\u000201H\u0002J$\u0010;\u001a\u00020\u001b2\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u0001002\b\b\u0002\u0010=\u001a\u00020\u000eH\u0002J\u0010\u0010>\u001a\u00020\u001b2\u0006\u0010:\u001a\u000201H\u0002J\u0018\u0010?\u001a\u00020\u001b2\u0006\u0010@\u001a\u0002012\u0006\u0010-\u001a\u00020&H\u0002J\u0018\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020&H\u0002J\u0012\u0010D\u001a\u00020\u001b2\b\u00105\u001a\u0004\u0018\u00010\u0007H\u0002J \u0010E\u001a\u00020\u001b2\f\u0010F\u001a\b\u0012\u0004\u0012\u000201002\b\b\u0002\u0010=\u001a\u00020\u000eH\u0002J\u0010\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\u000eH\u0002J\b\u0010I\u001a\u00020\u001bH\u0002J\u0012\u0010J\u001a\u00020\u001b2\b\u0010K\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010L\u001a\u00020\u000eH\u0002J\"\u0010M\u001a\u00020\u001b2\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u00072\b\u0010P\u001a\u0004\u0018\u00010QH\u0002J\n\u0010R\u001a\u0004\u0018\u00010SH\u0016J\b\u0010T\u001a\u00020\u001bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006U"}, d2 = {"Lcom/larus/voice_setting/voice/base/MyVoiceListFragment;", "Lcom/larus/voice_setting/voice/base/VoiceListFragment;", "<init>", "()V", "binding", "Lcom/larus/voice_setting/impl/databinding/LarusFragmentMineVoiceListBinding;", "currentPage", NameKeys.UnloadStrategy_No_Strategy, "tag", "latestCloneVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "loadMoreManager", "Lcom/larus/bmhome/utils/LoadMoreManager;", "isPublic", NameKeys.UnloadStrategy_No_Strategy, "isRecommend", "searchMobParam", "Lcom/larus/platform/model/SearchMobParam;", "botId", "voiceCanCreate", "getVoiceCanCreate", "()Z", "voiceCanCreate$delegate", "Lkotlin/Lazy;", "addCopyMyVoiceItem", "onStartUpload", "Lkotlin/Function0;", NameKeys.UnloadStrategy_No_Strategy, "getOnStartUpload", "()Lkotlin/jvm/functions/Function0;", "setOnStartUpload", "(Lkotlin/jvm/functions/Function0;)V", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLeaveMineTab", "onViewCreated", "view", "initRecyclerView", "ugcVoiceList", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/voice_setting/voice/VoiceItem;", "initUgcVoiceObservers", "initUgcVoicePublicObservers", "updateBotVoice", "voiceId", "getVoiceLanguageCodeForCreateVoice", "createVoice", "from", "updateVoice", "item", "setupTtsSpeakers", "newUgcVoiceList", "isFromInit", "clickItem", "startMenu", "voiceItem", "needShowUp", "anchorView", "contentView", "removeVoice", "checkNeedShowEmptyStatus", "list", "showVoiceExceptionView", "isEmpty", "dismissVoiceExceptionView", "changeVoiceInfo", "voice", "recommendOrMultiTab", "showUploadingView", "localVoiceId", "voiceName", "icon", "Lcom/larus/im/bean/bot/IconItem;", "getBotInfo", "Lcom/larus/im/bean/bot/BotModel;", "onResume", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyVoiceListFragment extends VoiceListFragment {
    public static final /* synthetic */ int K = 0;
    public final String A;
    public SpeakerVoice B;
    public LoadMoreManager C;
    public final boolean D;
    public final boolean E;
    public SearchMobParam F;
    public String G;
    public final Lazy H;
    public boolean I;
    public final m J;
    public LarusFragmentMineVoiceListBinding y;
    public final String z;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MainTabFragmentAction.values().length];
            r0[MainTabFragmentAction.CREATE_VOICE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public static final class b implements LoadMoreManager.b {
        public final /* synthetic */ MyVoiceListFragment a;

        public b(MyVoiceListFragment r1) {
            this.a = r1;
        }

        public final View a(FrameLayout r4) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            return LayoutInflater.from(this.a.getContext()).inflate(2131561886, r4, false);
        }

        public final View b(FrameLayout r4) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            return LayoutInflater.from(this.a.getContext()).inflate(2131561886, r4, false);
        }

        public final View c(FrameLayout r4) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            if (this.a.ka0() == false) goto L8;
            if (this.a.ta0() == false) goto L8;
            return LayoutInflater.from(this.a.getContext()).inflate(2131562596, r4, false);
        L8:
            return LayoutInflater.from(this.a.getContext()).inflate(2131562580, r4, false);
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(Function1 r2) {
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

    public static final class d<T> implements Comparator {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r5, T r6) {
            SpeakerVoice r7 = ((o2) r6).a;
            long r0 = 0;
            if (r7 == null) goto L5;
            long r2 = r7.getCreateTime();
        L6:
            Long r8 = Long.valueOf(r2);
            SpeakerVoice r9 = ((o2) r5).a;
            if (r9 == null) goto L10;
            r0 = r9.getCreateTime();
        L10:
            return ComparisonsKt.compareValues(r8, Long.valueOf(r0));
        L5:
            r2 = 0;
            goto L6
        }
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

    public final void sa0() {
        LarusFragmentMineVoiceListBinding r0 = this.y;
        if (r0 == null) goto L6;
        r0.d.setVisibility(8);
        r0.e.setVisibility(0);
        return;
    }

    public final boolean ta0() {
        return ((Boolean) this.H.getValue()).booleanValue();
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.larus.voice_setting.voice.base.m] */
    public MyVoiceListFragment() {
        this.z = "bot_list_profile";
        this.A = "MineVoiceListFragment" + hashCode();
        this.D = z2.a.I2();
        this.E = com.larus.voice_setting.voice.utils.f.a.c().a;
        this.H = LazyKt.lazy(new com.larus.voice_setting.voice.base.b(this));
        this.J = new m();
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

    @Override // com.larus.voice_setting.voice.base.VoiceListFragment, com.larus.voice_setting.voice.base.ProfileInfoBaseFragment
    public final void onResume() {
        super.onResume();
        if (ka0() == true) goto L6;
        i2.b(VoiceDisplayScene.MY_INFO, "create_own_voice_button", "own_voice", null, null, null, null, null, null, 2040);
        return;
    }

    public final String ua0() {
        if (ka0() == false) goto L6;
        return this.j;
    L6:
        if (AppHost.a.isOversea() == false) goto L8;
        AppLocaleUtils.a.getClass();
        String r0 = AppLocaleUtils.c().getLanguage();
        Intrinsics.checkNotNull(r0);
        return r0;
    L8:
        return "zh";
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment
    public final String tag() {
        return this.A;
    }

    @Override // com.larus.voice_setting.voice.base.VoiceListFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        FLogger.a.i(this.A, "[onCreate] isPublic:" + this.D + "  isRecommend:" + this.E);
        Bundle r5 = getArguments();
        String r0 = VoiceDisplayScene.NONE;
        if (r5 == null) goto L8;
        String r6 = r5.getString("key_my_voice_scene", VoiceDisplayScene.NONE);
        if (r6 == null) goto L8;
        r0 = r6;
    L8:
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.l = r0;
        Bundle r7 = getArguments();
        String r1 = null;
        if (r7 == null) goto L11;
        SearchMobParam r8 = (SearchMobParam) r7.getParcelable("argSearchMobParam");
    L12:
        this.F = r8;
        Bundle r9 = getArguments();
        if (r9 == null) goto L15;
        String r10 = r9.getString("key_voice_bot_id");
    L16:
        this.G = r10;
        Bundle r11 = getArguments();
        if (r11 == null) goto L19;
        boolean r12 = r11.getBoolean("add_copy_my_voice_item");
    L20:
        this.I = r12;
        Bundle r13 = getArguments();
        if (r13 == null) goto L23;
        r1 = r13.getString("key_enter_method");
    L23:
        this.s = r1;
        Context r14 = getContext();
        if (r14 != null) goto L26;
        return;
    L26:
        this.C = new LoadMoreManager(r14, new x(this), new b(this));
        return;
    L19:
        r12 = this.I;
        goto L20
    L15:
        r10 = null;
        goto L16
    L11:
        r8 = null;
        goto L12
    }

    public final void pa0(SpeakerVoice r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        VoiceItemAdapter r0 = ia0();
        if (r0 == null) goto L35;
        List<o2> r1 = r0.a;
        if (r1 == null) goto L36;
        List<o2> r2 = CollectionsKt.toMutableList(r1);
        if (r2 == null) goto L38;
        Iterator<o2> r3 = r2.iterator();
        int r4 = 0;
    L13:
        if (r3.hasNext() == false) goto L22;
        SpeakerVoice r5 = r3.next().a;
        if (r5 == null) goto L17;
        String r6 = r5.getId();
    L19:
        if (Intrinsics.areEqual(r6, r8.getId()) == true) goto L23;
        r4 = r4 + 1;
    L23:
        o2 r7 = (o2) CollectionsKt.getOrNull(r2, r4);
        if (r7 != null) goto L26;
        return;
    L26:
        FLogger.a.i(this.A, "[changeVoiceInfo] index:" + r4 + ", voice:" + r8);
        ListProtector.set(r2, r4, o2.a(r7, r8));
        VoiceItemAdapter r9 = ia0();
        if (r9 == null) goto L29;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r9.a = r2;
    L29:
        VoiceItemAdapter r10 = ia0();
        if (r10 == null) goto L37;
        r10.notifyItemChanged(r4);
        return;
    L37:
        return;
    L17:
        r6 = null;
        goto L19
    L22:
        r4 = -1;
        goto L23
    L38:
        return;
    L36:
        return;
    }

    public final void ra0(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "from");
        int r0 = y2a.a.a;
        JSONObject r1 = new JSONObject();
        r1.put("is_scheme", y2a.b.b(this.w));
        r1.put("enter_method", y2a.b.a(this.s));
        r1.put("click_from", "ClickBlankPage");
        y2a.a.c(r1);
        i3.j(null, new e0(this), new f0(this, r4), 1);
    }

    public final void va0(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        VoiceItemAdapter r0 = ia0();
        if (r0 == null) goto L51;
        List<o2> r1 = r0.a;
        if (r1 == null) goto L52;
        List<o2> r2 = CollectionsKt.toMutableList(r1);
        if (r2 == null) goto L54;
        Iterator<o2> r3 = r2.iterator();
        int r4 = 0;
    L12:
        String r6 = null;
        if (r3.hasNext() == false) goto L22;
        SpeakerVoice r5 = r3.next().a;
        if (r5 == null) goto L17;
        String r7 = r5.getId();
    L19:
        if (Intrinsics.areEqual(r7, r10) == true) goto L23;
        r4 = r4 + 1;
    L23:
        FLogger.a.i(this.A, "[removeVoice] list:" + r2 + ", index:" + r4);
        if (r4 == (-1)) goto L53;
        SpeakerVoice r8 = (SpeakerVoice) ((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().j.getValue();
        if (r8 == null) goto L29;
        r6 = r8.getId();
    L29:
        if (Intrinsics.areEqual(r10, r6) == true) goto L31;
    L41:
        ListProtector.remove(r2, r4);
        VoiceItemAdapter r11 = ia0();
        if (r11 == null) goto L44;
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r11.a = r2;
    L44:
        VoiceItemAdapter r12 = ia0();
        if (r12 == null) goto L47;
        r12.notifyDataSetChanged();
    L47:
        qa0(r2, false);
        return;
    L31:
        if (this.E == true) goto L35;
        if (com.larus.voice_setting.voice.utils.f.a.g() == true) goto L35;
    L37:
        boolean r13 = false;
    L38:
        if (r13 == false) goto L40;
        ((TtsSpeakerSettingViewModel) this.o.getValue()).deleteSelectVoice();
        goto L41
    L40:
        ((TtsSpeakerSettingViewModel) this.o.getValue()).isFallBackToSystemVoice().postValue(Boolean.TRUE);
    L35:
        if (ka0() == false) goto L37;
        r13 = true;
        goto L38
    L53:
        return;
    L17:
        r7 = null;
        goto L19
    L22:
        r4 = -1;
        goto L23
    L54:
        return;
    L52:
        return;
    }

    public final void xa0(boolean r6) {
        LarusFragmentMineVoiceListBinding r0 = this.y;
        if (r0 == null) goto L19;
        r0.d.setVisibility(0);
        RecyclerView r1 = r0.e;
        if (this.I == true) goto L7;
    L9:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L13;
        int r4 = 0;
    L14:
        r1.setVisibility(r4);
        if (r6 == false) goto L17;
        r0.b.a.setVisibility(0);
        r0.c.a.setVisibility(8);
        return;
    L17:
        r0.b.a.setVisibility(8);
        r0.c.a.setVisibility(0);
        return;
    L13:
        r4 = 8;
        goto L14
    L7:
        if (ta0() == false) goto L9;
        r3 = true;
        goto L11
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        FLogger.a.i(this.A, "[onViewCreated]");
        super.onViewCreated(r4, r5);
        com.larus.voice_setting.voice.base.a r6 = null;
        wa0(null, true);
        if (this.D == false) goto L5;
        UgcVoiceLoader.z.observe(getViewLifecycleOwner(), new c(new f(this)));
        UgcVoiceLoader.x.observe(getViewLifecycleOwner(), new c(new g(this)));
        UgcVoiceLoader.r.observe(getViewLifecycleOwner(), new c(new h(this)));
        UgcVoiceLoader.v.observe(getViewLifecycleOwner(), new c(new i(this)));
        UgcVoiceLoader.B.observe(getViewLifecycleOwner(), new c(new j(this)));
        UgcVoiceLoader.j.observe(getViewLifecycleOwner(), new c(new k(this)));
        UgcVoiceLoader.D.observe(getViewLifecycleOwner(), new c(new l(this)));
    L10:
        UgcVoiceLoader r7 = UgcVoiceLoader.a;
        UgcVoiceLoader.o(this.j);
        if (ka0() == false) goto L28;
        ja0();
        if (ta0() == false) goto L21;
        LarusFragmentMineVoiceListBinding r8 = this.y;
        if (r8 == null) goto L21;
        LarusMyVoiceListEmptyBinding r9 = r8.b;
        if (r9 == null) goto L21;
        ConstraintLayout r10 = r9.b;
        if (r10 == null) goto L21;
        com.larus.utils.e1.d(r10, new b0(this));
    L21:
        LarusFragmentMineVoiceListBinding r11 = this.y;
        if (r11 == null) goto L36;
        LarusVoiceListErrorBinding r12 = r11.c;
        if (r12 == null) goto L37;
        ConstraintLayout r13 = r12.b;
        if (r13 == null) goto L38;
        com.larus.utils.e1.d(r13, new c0(this));
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L28:
        X90();
        Fragment r14 = getParentFragment();
        if ((r14 instanceof com.larus.voice_setting.voice.base.a) == false) goto L31;
        r6 = (com.larus.voice_setting.voice.base.a) r14;
    L31:
        if (r6 == null) goto L40;
        MutableLiveData<MainTabFragmentAction> r15 = r6.kI();
        if (r15 == null) goto L41;
        r15.observe(getViewLifecycleOwner(), new c(new d0(this)));
        return;
    L41:
        return;
    L40:
        return;
    L5:
        UgcVoiceLoader.p.observe(getViewLifecycleOwner(), new c(new n(this)));
        UgcVoiceLoader.v.observe(getViewLifecycleOwner(), new c(new o(this)));
        UgcVoiceLoader.r.observe(getViewLifecycleOwner(), new c(new p(this)));
        UgcVoiceLoader.t.observe(getViewLifecycleOwner(), new c(new q(this)));
        UgcVoiceLoader.j.observe(getViewLifecycleOwner(), new c(new r(this)));
        if (ka0() == false) goto L10;
        if (ta0() == false) goto L10;
        UgcVoiceLoader.D.observe(getViewLifecycleOwner(), new c(new s(this)));
        goto L10
    }

    public final void qa0(List<o2> r3, boolean r4) {
        LarusFragmentMineVoiceListBinding r0 = this.y;
        if (r0 != null) goto L5;
        return;
    L5:
        if (ka0() == true) goto L7;
    L14:
        sa0();
        return;
    L7:
        if (r3.isEmpty() == false) goto L14;
        if (r4 == true) goto L14;
        if (ta0() == false) goto L12;
        r0.b.d.setText(getString(2131897497));
    L13:
        xa0(true);
        return;
    L12:
        r0.b.d.setText(getString(2131900304));
        r0.b.c.setImageResource(2131243101);
        goto L13
    }

    public final void wa0(List<SpeakerVoice> r17, boolean r18) {
        if (r17 != null) goto L5;
        UgcVoiceLoader r1 = UgcVoiceLoader.a;
        List<SpeakerVoice> r2 = CollectionsKt.toList(UgcVoiceLoader.e);
    L6:
        List<SpeakerVoice> r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L15;
        SpeakerVoice r6 = (SpeakerVoice) r5.next();
        if (ka0() == false) goto L12;
        int r7 = ga0(r6);
    L13:
        r4.add(new o2(r6, r7, 1, da0(r6), 0, 40, 0));
        goto L8
    L12:
        r7 = 10;
        goto L13
    L15:
        if (this.D == false) goto L17;
        List r8 = CollectionsKt.emptyList();
    L22:
        List<o2> r9 = CollectionsKt.sortedWith(CollectionsKt.plus(r4, r8), new d());
        FLogger.a.i(this.A, "[setupTtsSpeakers] success:" + r4 + ", list:" + r9);
        LarusFragmentMineVoiceListBinding r10 = this.y;
        ConcatAdapter r11 = null;
        if (r10 == null) goto L27;
        RecyclerView r12 = r10.e;
        if (r12 == null) goto L27;
        RecyclerView.Adapter r13 = r12.getAdapter();
    L28:
        if (r13 == null) goto L35;
        VoiceItemAdapter r14 = ia0();
        if (r14 == null) goto L32;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r14.a = r9;
    L32:
        VoiceItemAdapter r15 = ia0();
        if (r15 == null) goto L65;
        r15.notifyDataSetChanged();
    L65:
        qa0(r9, r18);
        return;
    L35:
        LarusFragmentMineVoiceListBinding r16 = this.y;
        if (r16 == null) goto L65;
        RecyclerView r19 = r16.e;
        if (r19 == null) goto L65;
        r19.setLayoutManager(new LinearLayoutManager(r19.getContext()));
        VoiceItemAdapter r20 = new VoiceItemAdapter(r9, new t2(ka0(), false, null, null, la0(), ((TtsSpeakerSettingViewModel) this.o.getValue()).getSelectVoiceMode(), new g0(this), 14));
        r20.c = new i0(this);
        r19.addItemDecoration(new MyVoiceListFragment$initRecyclerView$1$1());
        if (this.D == false) goto L42;
    L47:
        LoadMoreManager r21 = this.C;
        if (r21 == null) goto L50;
        ConcatAdapter r22 = r21.d(r19, r20);
    L52:
        if ((r22 instanceof ConcatAdapter) == false) goto L54;
        r11 = r22;
    L54:
        if (r11 != null) goto L56;
    L64:
        r19.setItemViewCacheSize(20);
        y6.d(r19, new com.larus.voice_setting.voice.base.d(this), null, null, new e(this), 13);
        goto L65
    L56:
        if (ka0() == true) goto L62;
        if (AppHost.a.isOversea() == true) goto L60;
    L63:
        VoiceCreateAdapter r23 = new VoiceCreateAdapter(new t2(ka0(), this.I, null, null, false, 0, new h0(this), 60));
        r23.b = new com.larus.voice_setting.voice.base.c(this);
        Unit r24 = Unit.INSTANCE;
        r11.addAdapter(0, r23);
        goto L64
    L60:
        if (com.larus.voice_setting.voice.utils.f.a.a() == true) goto L63;
    L62:
        if (this.I == false) goto L64;
    L50:
        r22 = null;
        goto L52
    L42:
        if (ka0() == true) goto L44;
    L46:
        r11 = new ConcatAdapter(new RecyclerView.Adapter[]{r20});
        r19.setAdapter(r11);
        goto L54
    L44:
        if (ta0() == false) goto L46;
    L27:
        r13 = null;
        goto L28
    L17:
        UgcVoiceLoader r25 = UgcVoiceLoader.a;
        List r26 = CollectionsKt.toList(UgcVoiceLoader.f);
        ArrayList r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));
        Iterator r28 = r26.iterator();
    L19:
        if (r28.hasNext() == false) goto L21;
        r27.add(new o2((SpeakerVoice) r28.next(), 10, 3, 0, 0, 56, 0));
        goto L19
    L21:
        r8 = r27;
        goto L22
    L5:
        r2 = r17;
        goto L6
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        FLogger.a.i(this.A, "[onCreateView]");
        LarusFragmentMineVoiceListBinding r6 = LarusFragmentMineVoiceListBinding.a(r3, r4);
        this.y = r6;
        return r6.a;
    }
}
