package com.larus.voice_setting.voice.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.utils.LoadMoreManager;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.impl.databinding.LarusFragmentPublicVoiceListBinding;
import com.larus.voice_setting.impl.databinding.LarusOtherProfileVoiceListEmptyBinding;
import com.larus.voice_setting.voice.DoubleTabTtsSpeakerSettingFragment;
import com.larus.voice_setting.voice.TtsSpeakerSettingViewModel;
import com.larus.voice_setting.voice.VoiceItemAdapter;
import com.larus.voice_setting.voice.o2;
import com.larus.voice_setting.voice.t2;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u001a\u001a\u00020\u000f2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u000fH\u0002J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020\u000f2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u001cH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/voice_setting/voice/base/PublicVoiceListFragment;", "Lcom/larus/voice_setting/voice/base/VoiceListFragment;", "<init>", "()V", "binding", "Lcom/larus/voice_setting/impl/databinding/LarusFragmentPublicVoiceListBinding;", "currentPage", NameKeys.UnloadStrategy_No_Strategy, "tag", "loadMoreManager", "Lcom/larus/bmhome/utils/LoadMoreManager;", "userId", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreate", NameKeys.UnloadStrategy_No_Strategy, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initRecyclerView", "ugcVoiceList", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/voice_setting/voice/VoiceItem;", "onLeaveMineTab", "clickItem", "item", "initObservers", "getBotInfo", "Lcom/larus/im/bean/bot/BotModel;", "setupTtsSpeakers", "newUgcVoiceList", "Lcom/larus/im/bean/bot/SpeakerVoice;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PublicVoiceListFragment extends VoiceListFragment {
    public static final /* synthetic */ int C = 0;
    public LoadMoreManager A;
    public String B;
    public LarusFragmentPublicVoiceListBinding y;
    public final String z;

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(Function1 r2) {
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

    public static final class b<T> implements Comparator {
        public b() {
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
        LarusFragmentPublicVoiceListBinding r0 = this.y;
        if (r0 == null) goto L8;
        RecyclerView r1 = r0.c;
        if (r1 == null) goto L9;
        y6.i(r1);
        return;
    L9:
        return;
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment
    public final RecyclerView getRecyclerView() {
        LarusFragmentPublicVoiceListBinding r0 = this.y;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    public PublicVoiceListFragment() {
        this.z = "PublicVoiceListFragment" + hashCode();
        this.B = NameKeys.UnloadStrategy_No_Strategy;
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
        Bundle r5 = getArguments();
        if (r5 == null) goto L5;
        this.B = r5.getString("public_voice_user_id", NameKeys.UnloadStrategy_No_Strategy);
        String r6 = r5.getString("key_public_voice_scene", VoiceDisplayScene.NONE);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        this.l = r6;
    L5:
        Context r7 = getContext();
        if (r7 != null) goto L8;
        return;
    L8:
        this.A = new LoadMoreManager(r7, new k0(this), null);
        ((TtsSpeakerSettingViewModel) this.o.getValue()).requestPublicVoiceList(false, this.B, this.j);
    }

    public final void pa0(List<SpeakerVoice> r14) {
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
        if (r14 != null) goto L9;
        r14 = ((TtsSpeakerSettingViewModel) this.o.getValue()).getPreloadOtherVoiceList();
    L9:
        List<SpeakerVoice> r15 = r14;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator<T> r16 = r15.iterator();
    L11:
        if (r16.hasNext() == false) goto L13;
        r6.add(new o2((SpeakerVoice) r16.next(), 10, 1, 0, 0, 56, 0));
        goto L11
    L13:
        List<o2> r17 = CollectionsKt.sortedWith(r6, new b());
        FLogger.a.i(this.z, "[setupTtsSpeakers] voiceList:" + r17);
        if (r17.isEmpty() == false) goto L27;
        LarusFragmentPublicVoiceListBinding r18 = this.y;
        if (r18 == null) goto L22;
        LarusOtherProfileVoiceListEmptyBinding r19 = r18.b;
        if (r19 == null) goto L22;
        ConstraintLayout r110 = r19.a;
        if (r110 == null) goto L22;
        r110.setVisibility(0);
    L22:
        LarusFragmentPublicVoiceListBinding r111 = this.y;
        if (r111 == null) goto L63;
        RecyclerView r112 = r111.c;
        if (r112 == null) goto L64;
        r112.setVisibility(8);
        return;
    L64:
        return;
    L63:
        return;
    L27:
        LarusFragmentPublicVoiceListBinding r7 = this.y;
        if (r7 == null) goto L34;
        LarusOtherProfileVoiceListEmptyBinding r8 = r7.b;
        if (r8 == null) goto L34;
        ConstraintLayout r9 = r8.a;
        if (r9 == null) goto L34;
        r9.setVisibility(8);
    L34:
        LarusFragmentPublicVoiceListBinding r10 = this.y;
        if (r10 == null) goto L39;
        RecyclerView r11 = r10.c;
        if (r11 == null) goto L39;
        r11.setVisibility(0);
    L39:
        LarusFragmentPublicVoiceListBinding r12 = this.y;
        if (r12 == null) goto L44;
        RecyclerView r13 = r12.c;
        if (r13 == null) goto L44;
        r4 = r13.getAdapter();
    L44:
        if (r4 == null) goto L51;
        VoiceItemAdapter r20 = ia0();
        if (r20 == null) goto L48;
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r20.a = r17;
    L48:
        VoiceItemAdapter r113 = ia0();
        if (r113 == null) goto L66;
        r113.notifyDataSetChanged();
        return;
    L66:
        return;
    L51:
        LarusFragmentPublicVoiceListBinding r21 = this.y;
        if (r21 == null) goto L68;
        RecyclerView r22 = r21.c;
        if (r22 == null) goto L69;
        r22.setLayoutManager(new LinearLayoutManager(r22.getContext()));
        VoiceItemAdapter r23 = new VoiceItemAdapter(r17, new t2(false, false, null, null, false, 0, new l0(this), 62));
        r23.c = new q0(this);
        r22.setAdapter(r23);
        RecyclerView.Adapter r114 = r22.getAdapter();
        if (r114 == null) goto L60;
        LoadMoreManager r24 = this.A;
        if (r24 == null) goto L60;
        r24.d(r22, r114);
    L60:
        r22.setItemViewCacheSize(20);
        y6.d(r22, new m0(this), null, null, new n0(this), 13);
        return;
    L69:
        return;
    L68:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        FLogger.a.i(this.z, "[onViewCreated]");
        super.onViewCreated(r4, r5);
        pa0(null);
        X90();
        TtsSpeakerSettingViewModel r6 = (TtsSpeakerSettingViewModel) this.o.getValue();
        r6.getPublicVoiceLiveData().observe(getViewLifecycleOwner(), new a(new o0(this)));
        r6.getLoadMoreState().observe(getViewLifecycleOwner(), new a(new p0(this)));
        ((TtsSpeakerSettingViewModel) this.o.getValue()).requestPublicVoiceList(false, this.B, this.j);
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        FLogger.a.i(this.z, "[onCreateView] scene: " + this.l + ", language:" + this.j);
        ConstraintLayout r7 = r4.inflate(2131562427, r5, false);
        int r8 = 2131392713;
        ConstraintLayout r9 = ViewBindings.findChildViewById(r7, 2131392713);
        if (r9 == null) goto L15;
        ConstraintLayout r10 = r9;
        int r1 = 2131383228;
        if (ViewBindings.findChildViewById(r9, 2131383228) == null) goto L13;
        r1 = 2131383236;
        if (ViewBindings.findChildViewById(r9, 2131383236) == null) goto L13;
        LarusOtherProfileVoiceListEmptyBinding r11 = new LarusOtherProfileVoiceListEmptyBinding(r10);
        r8 = 2131392751;
        RecyclerView r2 = ViewBindings.findChildViewById(r7, 2131392751);
        if (r2 == null) goto L15;
        ConstraintLayout r12 = r7;
        this.y = new LarusFragmentPublicVoiceListBinding(r12, r11, r2);
        return r12;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r1)));
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r8)));
    }
}
