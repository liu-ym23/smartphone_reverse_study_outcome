package com.larus.voice_setting.voice.base;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.RecommendFrom;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.TtsSpeakerSettingViewModel;
import com.larus.voice_setting.voice.UgcVoiceLoader;
import com.larus.voice_setting.voice.VoiceItemAdapter;
import com.larus.voice_setting.voice.dialog.v2.viewmodel.UgcVoiceCreateSharedViewModel;
import com.larus.voice_setting.voice.editvoice.SpeakerVoiceEditModel;
import com.larus.voice_setting.voice.o2;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.xelement.webview.LynxUIWebView;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u000e\u0010E\u001a\u00020B2\u0006\u0010F\u001a\u00020\u0017J\u0014\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050HH\u0002J\b\u0010I\u001a\u00020\u000bH\u0002J\u0006\u0010J\u001a\u00020BJ\n\u0010K\u001a\u0004\u0018\u00010LH&J\u0006\u0010M\u001a\u00020\u000bJ\u000e\u0010N\u001a\u00020O2\u0006\u0010F\u001a\u00020\u0017J\u000e\u0010P\u001a\u00020O2\u0006\u0010F\u001a\u00020\u0017J\u0010\u0010Q\u001a\u00020B2\b\u0010R\u001a\u0004\u0018\u00010\u0017J\u0018\u0010S\u001a\u00020B2\u0006\u0010T\u001a\u00020\u00172\b\b\u0002\u0010U\u001a\u00020\u000bJ$\u0010V\u001a\u00020\u000b2\b\u0010F\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010W\u001a\u00020\u000b2\b\b\u0002\u0010X\u001a\u00020\u000bJ\u0012\u0010Y\u001a\u00020\u00052\b\u0010F\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010Z\u001a\u00020\u000b2\b\u0010F\u001a\u0004\u0018\u00010\u0017J\b\u0010[\u001a\u0004\u0018\u00010\\J\b\u0010]\u001a\u00020BH\u0016J\u0006\u0010^\u001a\u00020\u000bJ\n\u0010_\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010`\u001a\u00020BH\u0016J\u0006\u0010a\u001a\u00020\u000bJ\b\u0010b\u001a\u00020BH\u0002J\u000e\u0010c\u001a\u00020d*\u0004\u0018\u00010:H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\tR\u001c\u00100\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\tR\u001c\u00103\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0007\"\u0004\b5\u0010\tR\u001a\u00106\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0007\"\u0004\b8\u0010\tR\u001c\u00109\u001a\u0004\u0018\u00010:X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000f¨\u0006e"}, d2 = {"Lcom/larus/voice_setting/voice/base/VoiceListFragment;", "Lcom/larus/voice_setting/voice/base/ProfileInfoBaseFragment;", "<init>", "()V", "languageCode", NameKeys.UnloadStrategy_No_Strategy, "getLanguageCode", "()Ljava/lang/String;", "setLanguageCode", "(Ljava/lang/String;)V", "uiMode", NameKeys.UnloadStrategy_No_Strategy, "getUiMode", "()Z", "setUiMode", "(Z)V", "scene", "getScene", "setScene", "enterFrom", "getEnterFrom", "setEnterFrom", "initialVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "getInitialVoice", "()Lcom/larus/im/bean/bot/SpeakerVoice;", "setInitialVoice", "(Lcom/larus/im/bean/bot/SpeakerVoice;)V", "model", "Lkotlin/Lazy;", "Lcom/larus/voice_setting/voice/TtsSpeakerSettingViewModel;", "getModel", "()Lkotlin/Lazy;", "ugcVoiceSharedViewModel", "Lcom/larus/voice_setting/voice/dialog/v2/viewmodel/UgcVoiceCreateSharedViewModel;", "getUgcVoiceSharedViewModel", "()Lcom/larus/voice_setting/voice/dialog/v2/viewmodel/UgcVoiceCreateSharedViewModel;", "ugcVoiceSharedViewModel$delegate", "Lkotlin/Lazy;", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "getRecommendFrom", "()Lcom/larus/platform/model/RecommendFrom;", "setRecommendFrom", "(Lcom/larus/platform/model/RecommendFrom;)V", "tabName", "getTabName", "setTabName", "enterMethod", "getEnterMethod", "setEnterMethod", "conversationId", "getConversationId", "setConversationId", "trackParamsStr", "getTrackParamsStr", "setTrackParamsStr", "trackParams", "Lorg/json/JSONObject;", "getTrackParams", "()Lorg/json/JSONObject;", "setTrackParams", "(Lorg/json/JSONObject;)V", "isFromVoiceCloneScheme", "setFromVoiceCloneScheme", "onCreate", NameKeys.UnloadStrategy_No_Strategy, "savedInstanceState", "Landroid/os/Bundle;", "executeClick", "voice", "getGlobalAudioObserverExtraParams", NameKeys.UnloadStrategy_No_Strategy, "canVoicePlayLottie", "initTtsSelectObservers", "getBotInfo", "Lcom/larus/im/bean/bot/BotModel;", "isVoiceCanEdit", "getSelectedState", NameKeys.UnloadStrategy_No_Strategy, "getAddState", "updateVoicePlayStatus", "clickVoice", "updateSelectedVoice", "speakerVoice", "setResult", "addMixVoice", "isClick", "byReset", "getNonMixableToastContent", "removeMixVoice", "getVoiceListAdapter", "Lcom/larus/voice_setting/voice/VoiceItemAdapter;", "onResume", "isTtsList", "getMultiTabKey", "onPause", "isMainBot", "releaseAudio", "toTrackParamsJsonObject", "Lkotlinx/serialization/json/JsonObject;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class VoiceListFragment extends ProfileInfoBaseFragment {
    public static final /* synthetic */ int x = 0;
    public String j;
    public boolean k;
    public String l;
    public String m;
    public SpeakerVoice n;
    public final Lazy<TtsSpeakerSettingViewModel> o;
    public final Lazy p;
    public RecommendFrom q;
    public String r;
    public String s;
    public String t;
    public String u;
    public JSONObject v;
    public boolean w;

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

    public abstract BotModel B0();

    public String fa0() {
        return null;
    }

    public final Map<String, String> ea0() {
        LinkedHashMap r0 = new LinkedHashMap();
        BotModel r1 = B0();
        if (r1 == null) goto L5;
        String r2 = r1.getBotId();
    L6:
        String r3 = NameKeys.UnloadStrategy_No_Strategy;
        if (r2 != null) goto L9;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        r0.put("bot_id", r2);
        String r4 = this.t;
        if (r4 == null) goto L13;
        r3 = r4;
    L13:
        r0.put("conversation_id", r3);
        r0.put("current_page", "bot_voice_change");
        return r0;
    L5:
        r2 = null;
        goto L6
    }

    public final UgcVoiceCreateSharedViewModel ha0() {
        return (UgcVoiceCreateSharedViewModel) this.p.getValue();
    }

    public final void ja0() {
        ((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().m.observe(getViewLifecycleOwner(), new a(new i1(this)));
        ((TtsSpeakerSettingViewModel) this.o.getValue()).getVoiceUpdate().observe(getViewLifecycleOwner(), new a(new j1(this)));
        ((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().j.observe(getViewLifecycleOwner(), new a(new k1(this)));
        if (la0() == false) goto L6;
        ((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().p.observe(getViewLifecycleOwner(), new a(new l1(this)));
        ((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().s.observe(getViewLifecycleOwner(), new a(new m1(this)));
        return;
    }

    public final boolean ka0() {
        if (Intrinsics.areEqual(this.l, VoiceDisplayScene.TTS_LIST_MINE) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(this.l, VoiceDisplayScene.TTS_LIST_RECOMMEND) == true) goto L8;
        return false;
    }

    public VoiceListFragment() {
        this.j = NameKeys.UnloadStrategy_No_Strategy;
        this.l = VoiceDisplayScene.NONE;
        this.m = NameKeys.UnloadStrategy_No_Strategy;
        this.o = FragmentViewModelLazyKt.createViewModelLazy$default(this, Reflection.getOrCreateKotlinClass(TtsSpeakerSettingViewModel.class), new h1(this), null, 4, null);
        this.p = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(UgcVoiceCreateSharedViewModel.class), new VoiceListFragment$special$$inlined$activityViewModels$default$1(this), new VoiceListFragment$special$$inlined$activityViewModels$default$2(this));
        this.u = NameKeys.UnloadStrategy_No_Strategy;
    }

    public final boolean Da() {
        BotModel r0 = B0();
        if (r0 == null) goto L10;
        Integer r1 = r0.getBotType();
        if (r1 == null) goto L10;
        if (r1.intValue() != 1) goto L10;
        return true;
    L10:
        return false;
    }

    public final boolean ba0() {
        if (la0() == false) goto L7;
        if (((TtsSpeakerSettingViewModel) this.o.getValue()).isMultiVoiceMixMode() == false) goto L7;
    L8:
        return true;
    L7:
        if (ka0() == false) goto L8;
        return false;
    }

    public final VoiceItemAdapter ia0() {
        RecyclerView r0 = getRecyclerView();
        if (r0 == null) goto L5;
        RecyclerView.Adapter r1 = r0.getAdapter();
    L7:
        if ((r1 instanceof ConcatAdapter) == false) goto L9;
        ConcatAdapter r2 = (ConcatAdapter) r1;
    L10:
        if (r2 == null) goto L29;
        List r3 = r2.getAdapters();
        if (r3 == null) goto L29;
        Iterator r4 = r3.iterator();
    L15:
        if (r4.hasNext() == false) goto L29;
        ConcatAdapter r5 = (RecyclerView.Adapter) r4.next();
        if ((r5 instanceof ConcatAdapter) == false) goto L26;
        Iterator r6 = r5.getAdapters().iterator();
    L20:
        if (r6.hasNext() == false) goto L26;
        RecyclerView.Adapter r7 = (RecyclerView.Adapter) r6.next();
        if ((r7 instanceof VoiceItemAdapter) == false) goto L20;
        return (VoiceItemAdapter) r7;
    L26:
        if ((r5 instanceof VoiceItemAdapter) == false) goto L15;
        return (VoiceItemAdapter) r5;
    L29:
        return null;
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public final boolean la0() {
        if (ka0() == true) goto L7;
        return false;
    L7:
        return ((TtsSpeakerSettingViewModel) this.o.getValue()).getVoiceCanEdit();
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment
    public final void onPause() {
        if (ka0() == true) goto L8;
        p2a.q.a().stopAudio();
        p2a.q.a().i();
        if (ObricTtsControlDelegate.b.e() == false) goto L8;
        GlobalAudioObserver.a.c("trail_listening", GlobalAudioStateEnum.STOPPED, ea0());
    L8:
        if (ba0() == false) goto L10;
        oa0(null);
    L10:
        super.onPause();
    }

    @Override // com.larus.voice_setting.voice.base.ProfileInfoBaseFragment
    public void onResume() {
        super.onResume();
        if (ka0() == false) goto L8;
        SpeakerVoice r0 = (SpeakerVoice) ((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().j.getValue();
        if (r0 == null) goto L9;
        na0(r0, false);
        return;
    L9:
        return;
    }

    public final void ca0(SpeakerVoice r30) {
        Intrinsics.checkNotNullParameter(r30, "voice");
        ((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().J = this.r;
        int r3 = 0;
        if (((TtsSpeakerSettingViewModel) this.o.getValue()).isMultiVoiceMixMode() == true) goto L33;
        SpeakerVoiceEditModel r0 = ((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel();
        String r4 = r30.getId();
        if (r4 != null) goto L7;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        VoiceItemAdapter r5 = ia0();
        if (r5 == null) goto L24;
        List<o2> r6 = r5.a;
        if (r6 == null) goto L24;
        Iterator<o2> r7 = r6.iterator();
        int r8 = 0;
    L13:
        if (r7.hasNext() == false) goto L22;
        SpeakerVoice r11 = r7.next().a;
        if (r11 == null) goto L17;
        String r12 = r11.getId();
    L19:
        if (Intrinsics.areEqual(r12, r30.getId()) == true) goto L23;
        r8 = r8 + 1;
    L23:
        Integer r9 = Integer.valueOf(r8);
    L25:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "voiceId");
        if (r4.length() <= 0) goto L28;
        boolean r10 = true;
    L29:
        if (r10 == false) goto L31;
        r0.K.add(r4);
    L31:
        r0.L = r9;
        goto L33
    L28:
        r10 = false;
        goto L29
    L17:
        r12 = null;
        goto L19
    L22:
        r8 = -1;
    L24:
        r9 = null;
    L33:
        if (ba0() == false) goto L35;
        String r28 = "voice";
        oa0(r30);
        if (ka0() == false) goto L105;
        SpeakerVoice r13 = r30;
        ((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().t(r13, "from_tts", 0);
        v2a.g r1 = v2a.g.a;
        v2a.g.b(((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().g(), this.r, r13, by7.h.h(this));
    L107:
        if (((TtsSpeakerSettingViewModel) this.o.getValue()).getShowSelectedVoiceOnTop() == true) goto L109;
    L111:
        int r2 = 1;
        String r14 = null;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new VoiceListFragment$executeClick$2(r13, this, null), 3, null);
        if (((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().n.size() <= 1) goto L114;
        return;
    L114:
        Z90(r13, true, true);
    L115:
        g1 r15 = g1.a;
        String r16 = this.r;
        String r17 = this.s;
        by7.e r18 = by7.h.h(this);
        if (Intrinsics.areEqual(this.m, "bot_create_page") == false) goto L118;
        String r19 = "create";
    L119:
        SpeakerVoiceEditModel r20 = ((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel();
        if (r20 == null) goto L122;
        r14 = r20.c;
    L122:
        UgcVoiceLoader r21 = UgcVoiceLoader.a;
        Boolean r22 = Boolean.valueOf(UgcVoiceLoader.h(r30.getId()));
        if (r30.getPrivateStatus() != r2) goto L125;
        String r23 = "1";
    L126:
        String r24 = r30.getId();
        if (r30.isUgcVoice() == false) goto L129;
        String r110 = "self_create";
    L130:
        String r111 = r30.getStyleId();
        String r112 = r30.getName();
        JSONObject r113 = new JSONObject();
        r113.put("speaker_id", r30.getStyleId());
        Intrinsics.checkNotNullParameter(r113, LynxResourceModule.PARAMS_KEY);
        if (r16 != null) goto L158;
    L133:
        r113.put("is_public", r23);     // Catch: JSONException -> L149
        if (r24 == null) goto L136;
        r113.put("voice_id", r24);     // Catch: JSONException -> L149
    L136:
        r113.put("voice_type", r110);     // Catch: JSONException -> L149
        if (r17 == null) goto L139;
        r113.put("enter_method", r17);     // Catch: JSONException -> L149
    L139:
        r113.put("scene", r19);     // Catch: JSONException -> L149
        if (r111 == null) goto L142;
        r113.put("to_tts_speaker", r111);     // Catch: JSONException -> L149
    L142:
        if (r112 == null) goto L144;
        r113.put("speaker_name", r112);     // Catch: JSONException -> L149
    L144:
        if (r14 == null) goto L146;
        r113.put("bot_id", r14);     // Catch: JSONException -> L149
    L146:
        if (r22 == null) goto L151;
        r113.put("is_best_match", r22.booleanValue() ? 1 : 0);     // Catch: JSONException -> L149
    L149:
        e = move-exception;
        FLogger.a.e("VoiceEventHelper", "error in VoiceEventHelper voiceCellClick " + e.getLocalizedMessage());
    L151:
        TrackParams r25 = new TrackParams().merge(r113);
        by7.a r26 = new by7.a("voice_cell_click");
        if (r18 == null) goto L154;
        r26.b = r18;
    L154:
        r26.a.merge(r25);
        r26.b();
        return;
    L158:
        r113.put("click_from", r16);     // Catch: JSONException -> L149
        goto L133
    L129:
        r110 = LynxUIWebView.DEFAULT;
        goto L130
    L125:
        r23 = "0";
        goto L126
    L118:
        r19 = "edit";
        goto L119
    L109:
        if (((TtsSpeakerSettingViewModel) this.o.getValue()).isMultiVoiceMixMode() == true) goto L111;
        SpeakerVoiceEditModel r27 = ((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel();
        r27.getClass();
        Intrinsics.checkNotNullParameter(r13, r28);
        r2 = 1;
        r27.q(r13, true);
        v2a.g r29 = v2a.g.a;
        v2a.g.b(((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().g(), this.r, r13, by7.h.h(this));
        r14 = null;
    L105:
        r13 = r30;
        goto L107
    L35:
        if (this.k == false) goto L37;
        na0(r30, true);
        r28 = "voice";
        r13 = r30;
        goto L107
    L37:
        VoiceItemAdapter r31 = ia0();
        if (r31 == null) goto L40;
        List<o2> r32 = r31.a;
    L41:
        if (r32 == null) goto L55;
        Iterator<o2> r33 = r32.iterator();
        int r34 = 0;
    L44:
        if (r33.hasNext() == false) goto L53;
        SpeakerVoice r35 = r33.next().a;
        if (r35 == null) goto L48;
        String r36 = r35.getId();
    L50:
        if (Intrinsics.areEqual(r36, r30.getId()) == true) goto L54;
        r34 = r34 + 1;
    L54:
        Integer r37 = Integer.valueOf(r34);
    L56:
        if (r37 != null) goto L58;
    L65:
        TtsSpeakerSettingViewModel r38 = (TtsSpeakerSettingViewModel) this.o.getValue();
        BotModel r39 = B0();
        if (r39 != null) goto L68;
        return;
    L68:
        r38.updateVoice(r39, r30);
        if (Intrinsics.areEqual(this.l, VoiceDisplayScene.TTS_LIST_MINE) == false) goto L71;
        String r40 = "my_tab";
    L73:
        if (com.larus.utils.o0.d(fa0()) == false) goto L75;
        r40 = fa0();
    L75:
        String r114 = r40;
        g1 r41 = g1.a;
        BotModel r42 = B0();
        if (r42 == null) goto L78;
        String r43 = r42.getBotId();
    L79:
        String r44 = this.m;
        RecommendFrom r45 = this.q;
        if (r45 == null) goto L82;
        String r115 = r45.a;
    L83:
        if (r45 == null) goto L85;
        String r116 = r45.b;
    L86:
        String r210 = String.valueOf(r3);
        String r46 = this.s;
        String r117 = this.r;
        JSONObject r47 = this.v;
        if (r47 == null) goto L100;
        String r48 = r47.toString();
        if (r48 == null) goto L100;
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L93
        Object r50 = Result.constructor-impl(ouc.k.n(ouc.a.d.e(r48)));     // Catch: Throwable -> L93
    L96:
        if (Result.exceptionOrNull-impl(r50) == null) goto L99;
        r50 = new ouc.d0(MapsKt.emptyMap());
    L99:
        ouc.d0 r51 = (ouc.d0) r50;
    L101:
        r28 = "voice";
        p2a.d.a.a(r41, r30, r43, false, r44, r44, r114, r115, r116, null, null, null, null, null, null, r210, r46, r117, null, null, null, r51, 1867264);
    L93:
        th = move-exception;
        Result.Companion r52 = Result.Companion;
        r50 = Result.constructor-impl(ResultKt.createFailure(th));
    L100:
        r51 = new ouc.d0(MapsKt.emptyMap());
        goto L101
    L85:
        r116 = null;
        goto L86
    L82:
        r115 = null;
        goto L83
    L78:
        r43 = null;
        goto L79
    L71:
        r40 = "rec_tab";
        goto L73
    L58:
        if (r37.intValue() == (-1)) goto L65;
        r3 = r37.intValue() + 1;
        o2 r53 = (o2) CollectionsKt.getOrNull(r32, r37.intValue());
        if (r53 == null) goto L62;
        r53.b = 20;
    L62:
        VoiceItemAdapter r54 = ia0();
        if (r54 == null) goto L65;
        r54.notifyItemChanged(r37.intValue());
        goto L65
    L48:
        r36 = null;
        goto L50
    L53:
        r34 = -1;
        goto L54
    L55:
        r37 = null;
        goto L56
    L40:
        r32 = null;
        goto L41
    }

    public final int da0(SpeakerVoice r5) {
        Intrinsics.checkNotNullParameter(r5, "voice");
        Iterator<T> r0 = ((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().n.iterator();
    L3:
        Object r2 = null;
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        SpeakerVoice r3 = ((MixVoice) r1).getVoiceItem();
        if (r3 == null) goto L9;
        r2 = r3.getId();
    L9:
        if (Intrinsics.areEqual(r2, r5.getId()) == false) goto L3;
        r2 = r1;
    L11:
        if (r2 == null) goto L13;
        return 70;
    L13:
        return 60;
    }

    public final int ga0(SpeakerVoice r8) {
        Intrinsics.checkNotNullParameter(r8, "voice");
        int r1 = 10;
        if (la0() == true) goto L5;
    L7:
        BotModel r0 = B0();
        if (r0 == null) goto L12;
        boolean r3 = true;
        if (r0.getMuted() != true) goto L12;
    L14:
        if (r3 == true) goto L16;
        SpeakerVoice r4 = (SpeakerVoice) ((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().j.getValue();
        String r5 = null;
        if (r4 != null) goto L26;
        r4 = this.n;
        if (r4 != null) goto L26;
        BotModel r6 = B0();
        if (r6 == null) goto L25;
        r4 = r6.getVoiceType();
        goto L26
    L25:
        r4 = null;
    L26:
        if (r4 != null) goto L28;
    L35:
        if (r1 != 30) goto L37;
        SpeakerVoiceEditModel r2 = ((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel();
        int r7 = SpeakerVoiceEditModel.P;
        r2.q(r8, false);
    L37:
        return r1;
    L28:
        if (Intrinsics.areEqual(r4.getId(), r8.getId()) == true) goto L34;
        ((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().getClass();
        SpeakerVoice r9 = SpeakerVoiceEditModel.i(r4);
        if (r9 == null) goto L33;
        r5 = r9.getId();
    L33:
        if (Intrinsics.areEqual(r5, r8.getId()) == false) goto L35;
    L34:
        r1 = 30;
        goto L35
    L16:
        if (Intrinsics.areEqual(r8.getId(), "0") == false) goto L35;
    L12:
        r3 = false;
        goto L14
    L5:
        if (((TtsSpeakerSettingViewModel) this.o.getValue()).isMultiVoiceMixMode() == false) goto L7;
        return 10;
    }

    public final boolean ma0(SpeakerVoice r3) {
        return ((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().n(r3, "from_tts");
    }

    public final void oa0(SpeakerVoice r8) {
        VoiceItemAdapter r0 = ia0();
        if (r0 == null) goto L41;
        List<o2> r1 = r0.a;
        if (r1 == null) goto L43;
        Iterator<T> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        o2 r3 = (o2) r2.next();
        if (r3.d != 1) goto L9;
        r3.d = 2;
        goto L9
    L13:
        if (r8 == null) goto L30;
        Iterator<o2> r4 = r1.iterator();
        int r5 = 0;
    L16:
        if (r4.hasNext() == false) goto L25;
        SpeakerVoice r6 = r4.next().a;
        if (r6 == null) goto L20;
        String r7 = r6.getId();
    L22:
        if (Intrinsics.areEqual(r7, r8.getId()) == true) goto L26;
        r5 = r5 + 1;
    L26:
        if (r5 == (-1)) goto L30;
        o2 r9 = (o2) CollectionsKt.getOrNull(r1, r5);
        if (r9 == null) goto L30;
        r9.d = 1;
        goto L30
    L20:
        r7 = null;
        goto L22
    L25:
        r5 = -1;
    L30:
        VoiceItemAdapter r10 = ia0();
        if (r10 == null) goto L42;
        r10.notifyDataSetChanged();
        return;
    L42:
        return;
    L43:
        return;
    }

    public void onCreate(Bundle r6) {
        super.onCreate(r6);
        Bundle r7 = getArguments();
        if (r7 == null) goto L28;
        this.j = r7.getString("key_language_code", NameKeys.UnloadStrategy_No_Strategy);
        this.k = r7.getBoolean("key_ui_mode", false);
        SpeakerVoice r0 = r7.getSerializable("key_initial_voice");
        Object r4 = null;
        if ((r0 instanceof SpeakerVoice) == false) goto L7;
        SpeakerVoice r1 = r0;
    L8:
        this.n = r1;
        this.m = r7.getString("enter_from", "other");
        this.q = r7.getParcelable("key_tts_voice_recommend_from");
        this.r = r7.getString("key_tab_name");
        this.t = r7.getString("conversation_id", NameKeys.UnloadStrategy_No_Strategy);
        String r2 = r7.getString("track_params", NameKeys.UnloadStrategy_No_Strategy);
        if (r2 == null) goto L24;
        this.u = r2;
        if (r2.length() <= 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L24;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L17
        Object r8 = Result.constructor-impl(new JSONObject(this.u));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r8) == true) goto L23;
        r4 = r8;
    L23:
        this.v = (JSONObject) r4;
    L17:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L13:
        r3 = false;
    L24:
        this.w = r7.getBoolean("key_from_voice_clone_scheme", false);
        return;
    L7:
        r1 = null;
        goto L8
    }

    public final void na0(SpeakerVoice r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "speakerVoice");
        VoiceItemAdapter r0 = ia0();
        if (r0 == null) goto L46;
        List<o2> r1 = r0.a;
        if (r1 == null) goto L49;
        SpeakerVoiceEditModel r2 = ((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel();
        Object r3 = null;
        if (Intrinsics.areEqual(r8.getId(), "0") == false) goto L10;
        SpeakerVoice r4 = null;
    L11:
        int r5 = SpeakerVoiceEditModel.P;
        r2.q(r4, false);
        List<o2> r6 = r1;
        Iterator<T> r7 = r6.iterator();
    L13:
        if (r7.hasNext() == false) goto L17;
        o2 r10 = (o2) r7.next();
        if (r10.b != 30) goto L13;
        r10.b = 10;
        goto L13
    L17:
        Iterator<T> r11 = r6.iterator();
    L19:
        if (r11.hasNext() == false) goto L27;
        Object r12 = r11.next();
        SpeakerVoice r13 = ((o2) r12).a;
        if (r13 == null) goto L23;
        String r14 = r13.getId();
    L25:
        if (Intrinsics.areEqual(r14, r8.getId()) == false) goto L19;
        r3 = r12;
        goto L27
    L23:
        r14 = null;
    L27:
        o2 r15 = (o2) r3;
        if (r15 == null) goto L30;
        r15.b = 30;
    L30:
        VoiceItemAdapter r16 = ia0();
        if (r16 == null) goto L33;
        r16.notifyDataSetChanged();
    L33:
        if (r9 == false) goto L47;
        FragmentActivity r17 = getActivity();
        if (r17 == null) goto L48;
        r17.setResult(11, new Intent().putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("select_speaker_result", r8)})));
        return;
    L48:
        return;
    L47:
        return;
    L10:
        r4 = r8;
        goto L11
    L49:
        return;
    }

    public static /* synthetic */ boolean aa0(VoiceListFragment r1, SpeakerVoice r2, int r3) {
        if ((r3 & 2) == 0) goto L5;
        boolean r4 = true;
    L7:
        return r1.Z90(r2, r4, false);
    L5:
        r4 = false;
        goto L7
    }

    public final boolean Z90(final SpeakerVoice r9, boolean r10, boolean r11) {
        SpeakerVoice r0 = null;
        if (r11 == true) goto L10;
        if (r9 == null) goto L10;
        if (((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().n.size() != 0) goto L10;
        f2a.c r12 = com.larus.voice_setting.voice.utils.k.a.b("click add voice but current voice list is empty");
        r12.e(new n1(r9, this));
        r12.c.b = CollectionsKt.listOf("VoicePlay");
        f2a.c.c(r12, null, 15);
        ca0(r9);
        return false;
    L10:
        if (((TtsSpeakerSettingViewModel) this.o.getValue()).canAddMixVoice(r9) == true) goto L55;
        if (r11 == true) goto L55;
        if (r10 == false) goto L53;
        Object r13 = NameKeys.UnloadStrategy_No_Strategy;
        MixVoice r14 = (MixVoice) CollectionsKt.getOrNull(((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().n, 0);
        if (r14 == null) goto L16;
        r0 = r14.getVoiceItem();
    L16:
        boolean r15 = true;
        if (r0 != null) goto L19;
    L21:
        boolean r2 = false;
    L22:
        if (r2 == false) goto L26;
        String r16 = r0.getExtra();
        if (r16 == null) goto L34;
    L35:
        String r17 = getString(2131907860);
        if (com.larus.utils.o0.d(r16) == true) goto L95;
    L51:
        String r4 = r17;
    L52:
        t19.s.j(t19.s.a, getContext(), r4, null, false, 28);
        goto L53
    L95:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L42
        String r18 = new JSONObject(r16).optString("toast_fail_text", NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L42
        if (r18 != null) goto L40;
        r18 = NameKeys.UnloadStrategy_No_Strategy;
    L40:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L42
    L45:
        if (Result.isFailure-impl(r19) == true) goto L48;
        r13 = r19;
    L48:
        String r110 = (String) r13;
        if (com.larus.utils.o0.d(r110) == false) goto L51;
        r4 = r110;
    L42:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
    L34:
        r16 = "{}";
        goto L35
    L26:
        if (r9 != null) goto L28;
    L30:
        r15 = false;
    L31:
        if (r15 == false) goto L34;
        r16 = r9.getExtra();
        if (r16 != null) goto L35;
    L28:
        if (r9.getAllowMix() == true) goto L30;
    L19:
        if (r0.getAllowMix() == true) goto L21;
        r2 = true;
    L53:
        return false;
    L55:
        if (((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().n.size() < 3) goto L61;
        if (r11 == true) goto L61;
        if (r10 == false) goto L60;
        t19.s.a.g(getContext(), 2131907859, false);
    L60:
        return false;
    L61:
        VoiceItemAdapter r111 = ia0();
        if (r111 == null) goto L79;
        List<o2> r112 = r111.a;
        if (r112 == null) goto L79;
        Iterator<o2> r113 = r112.iterator();
        int r5 = 0;
    L67:
        if (r113.hasNext() == false) goto L79;
        SpeakerVoice r6 = r113.next().a;
        if (r6 == null) goto L71;
        String r7 = r6.getId();
    L72:
        if (r9 == null) goto L74;
        String r8 = r9.getId();
    L76:
        if (Intrinsics.areEqual(r7, r8) == true) goto L81;
        r5 = r5 + 1;
    L81:
        if (((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().n.size() <= 0) goto L94;
        if (r11 == true) goto L94;
        if (r5 == (-1)) goto L94;
        RecyclerView r114 = getRecyclerView();
        if (r114 == null) goto L87;
        SpeakerVoice r115 = r114.getLayoutManager();
    L89:
        if ((r115 instanceof LinearLayoutManager) == false) goto L91;
        r0 = (LinearLayoutManager) r115;
    L91:
        if (r0 == null) goto L94;
        r0.scrollToPositionWithOffset(r5, 0);
        goto L94
    L87:
        r115 = null;
    L94:
        return ((TtsSpeakerSettingViewModel) this.o.getValue()).getSpeakerVoiceEditModel().c(r9, this.r, r11, r5);
    L74:
        r8 = null;
        goto L76
    L71:
        r7 = null;
    L79:
        r5 = -1;
        goto L81
    }
}
