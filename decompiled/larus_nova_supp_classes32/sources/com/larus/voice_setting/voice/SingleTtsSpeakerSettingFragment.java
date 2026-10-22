package com.larus.voice_setting.voice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureConfig;
import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.AudioPreview;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.FragmentExtKt;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.impl.databinding.LarusPageTtsSpeakerSettingBinding;
import com.larus.voice_setting.voice.dialog.UgcVoiceAuthorizeDialog;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.skydoves.balloon.Balloon;
import java.util.ArrayList;
import java.util.Comparator;
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
import org.json.JSONObject;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000¹\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b*\u00012\u0018\u0000 u2\u00020\u0001:\u0001uB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u000205H\u0002J&\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u001c\u0010?\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u001a\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020:2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u0010B\u001a\u000205H\u0016J\b\u0010C\u001a\u000205H\u0016J\b\u0010D\u001a\u000205H\u0002J\b\u0010E\u001a\u000205H\u0016J\b\u0010F\u001a\u000205H\u0016J\n\u0010G\u001a\u0004\u0018\u00010HH\u0002J\b\u0010I\u001a\u000205H\u0002J\b\u0010J\u001a\u000205H\u0002J\b\u0010K\u001a\u00020\u0013H\u0002J\b\u0010L\u001a\u000205H\u0002J\u001a\u0010M\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\u00182\b\u0010O\u001a\u0004\u0018\u00010\u0015H\u0002J!\u0010P\u001a\u0004\u0018\u0001052\u0010\b\u0002\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010RH\u0002¢\u0006\u0002\u0010SJ\b\u0010T\u001a\u00020UH\u0002J\b\u0010V\u001a\u00020\u0015H\u0002J4\u0010W\u001a\u0002052\b\b\u0002\u0010X\u001a\u00020\u00132\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010Z\u001a\u00020\u0013H\u0002J\u0012\u0010[\u001a\u0002052\b\u0010\\\u001a\u0004\u0018\u00010UH\u0002J\u0010\u0010]\u001a\u00020^2\u0006\u0010N\u001a\u00020\u0018H\u0002J\u0012\u0010_\u001a\u0002052\b\u0010N\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010`\u001a\u0002052\b\u0010a\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010b\u001a\u000205H\u0002J\u000f\u0010c\u001a\u0004\u0018\u000105H\u0002¢\u0006\u0002\u0010dJ\b\u0010e\u001a\u000205H\u0002J\b\u0010f\u001a\u000205H\u0002J\"\u0010g\u001a\u0002052\u0006\u0010h\u001a\u00020\u00152\u0006\u0010i\u001a\u00020\u00152\b\u0010j\u001a\u0004\u0018\u00010kH\u0002J\u0018\u0010l\u001a\u0002052\u0006\u0010m\u001a\u00020U2\u0006\u0010A\u001a\u00020:H\u0002J\u0019\u0010n\u001a\u0004\u0018\u0001052\b\u0010o\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010pJ\u0019\u0010q\u001a\u0004\u0018\u0001052\b\u0010a\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010rJ\b\u0010s\u001a\u00020\u0015H\u0016J\b\u0010t\u001a\u00020\u0013H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b%\u0010&R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\r\u001a\u0004\b.\u0010/R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103¨\u0006v"}, d2 = {"Lcom/larus/voice_setting/voice/SingleTtsSpeakerSettingFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/voice_setting/impl/databinding/LarusPageTtsSpeakerSettingBinding;", "adapter", "Lcom/larus/voice_setting/voice/VoiceItemAdapter;", "model", "Lcom/larus/voice_setting/voice/TtsSpeakerSettingViewModel;", "getModel", "()Lcom/larus/voice_setting/voice/TtsSpeakerSettingViewModel;", "model$delegate", "Lkotlin/Lazy;", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "backPressCallback", "Landroidx/activity/OnBackPressedCallback;", "uiMode", NameKeys.UnloadStrategy_No_Strategy, "languageCode", NameKeys.UnloadStrategy_No_Strategy, "languageName", "initialVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "showCreateVoiceBtn", "enterFrom", "searchMobParam", "Lcom/larus/platform/model/SearchMobParam;", "searchStartTime", NameKeys.UnloadStrategy_No_Strategy, "voiceAuthorizeKey", "getVoiceAuthorizeKey", "()Ljava/lang/String;", "voiceAuthorizeKey$delegate", "keva", "Lcom/bytedance/keva/Keva;", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "selectedVoice", "enterMethod", "perfTracer", "Lcom/larus/voice_setting/voice/perf/VoiceSettingPerfTracer;", "getPerfTracer", "()Lcom/larus/voice_setting/voice/perf/VoiceSettingPerfTracer;", "perfTracer$delegate", "itemDecoration", "com/larus/voice_setting/voice/SingleTtsSpeakerSettingFragment$itemDecoration$1", "Lcom/larus/voice_setting/voice/SingleTtsSpeakerSettingFragment$itemDecoration$1;", "onCreate", NameKeys.UnloadStrategy_No_Strategy, "savedInstanceState", "Landroid/os/Bundle;", "initArguments", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "createBinding", "onViewCreated", "view", "onResume", "onPause", "reportSearchStayTime", "onDestroyView", "onDestroy", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "performBack", "initObservations", "useAudioConfigSource", "requestUgcVoice", "voiceEnable", "voice", "botId", "setupTtsSpeakers", "newUgcVoiceList", NameKeys.UnloadStrategy_No_Strategy, "(Ljava/util/List;)Lkotlin/Unit;", "getCopySelfVoiceItem", "Lcom/larus/voice_setting/voice/VoiceItem;", "resolveCloneLanguageCode", "showCreateVoiceDialogWithParam", "isRecordAgain", "title", "needReplace", "clickItem", "item", "getInitialSelectedState", NameKeys.UnloadStrategy_No_Strategy, "changeVoiceInfo", "updateBotVoice", "voiceId", "fallbackToFirstSystemVoice", "setupCreateVoiceBtn", "()Lkotlin/Unit;", "createUgcVoice", "refreshBotCreateBtnIsEnable", "showUploadingView", "localVoiceId", "voiceName", "icon", "Lcom/larus/im/bean/bot/IconItem;", "startMenu", "voiceItem", "updateSelectedVoice", "speakerVoice", "(Lcom/larus/im/bean/bot/SpeakerVoice;)Lkotlin/Unit;", "removeVoice", "(Ljava/lang/String;)Lkotlin/Unit;", "getCurrentPageName", "autoLogEnterPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SingleTtsSpeakerSettingFragment extends TraceFragment {
    public static final /* synthetic */ int y = 0;
    public LarusPageTtsSpeakerSettingBinding e;
    public VoiceItemAdapter f;
    public final Lazy g;
    public BotModel h;
    public FragmentExtKt.addOnBackPressed.callback.1 i;
    public boolean j;
    public String k;
    public String l;
    public SpeakerVoice m;
    public boolean n;
    public String o;
    public SearchMobParam p;
    public long q;
    public final Lazy r;
    public final Lazy s;
    public RecommendFrom t;
    public SpeakerVoice u;
    public String v;
    public final Lazy w;
    public final SingleTtsSpeakerSettingFragment$itemDecoration$1 x;

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

    public static final class c implements u2 {
        public final /* synthetic */ SingleTtsSpeakerSettingFragment a;

        @Override // com.larus.voice_setting.voice.u2
        public final boolean a(o2 r1) {
            return false;
        }

        @Override // com.larus.voice_setting.voice.u2
        public final boolean d(o2 r1) {
            return false;
        }

        public c(SingleTtsSpeakerSettingFragment r1) {
            this.a = r1;
        }

        @Override // com.larus.voice_setting.voice.u2
        public final void b(o2 r33, View r34) {
            Intrinsics.checkNotNullParameter(r34, "itemView");
            int r4 = 0;
            if (r33 != null) goto L5;
        L7:
            boolean r5 = false;
        L8:
            String r6 = null;
            if (r5 == false) goto L11;
            SingleTtsSpeakerSettingFragment r1 = this.a;
            int r2 = SingleTtsSpeakerSettingFragment.y;
            r1.getClass();
            i3.j(null, null, new v0(r1), 3);
            return;
        L11:
            SingleTtsSpeakerSettingFragment r7 = this.a;
            int r8 = SingleTtsSpeakerSettingFragment.y;
            r7.getClass();
            if (r33 == null) goto L116;
            SpeakerVoice r9 = r33.a;
            if (r9 != null) goto L17;
            return;
        L17:
            if (r9.getStatus() != 3) goto L23;
            FLogger.a.i("SingleTtsSpeakerSettingFragment", "voice recreate: " + r9 + " for recall");
            Context r3 = r7.getContext();
            if (r3 == null) goto L21;
            r6 = r3.getString(2131911118);
        L21:
            r7.Y90(true, r6, r9, true);
            return;
        L23:
            if (r33.a.getStatus() != 4) goto L25;
            t19.s r10 = t19.s.a;
            Context r11 = r7.getContext();
            r10.getClass();
            t19.s.b(r11, 2131911107, false);
            return;
        L25:
            int r12 = r33.c;
            if (r12 != 3) goto L31;
            FLogger.a.i("SingleTtsSpeakerSettingFragment", "voice recreate: " + r9 + " for upload fail");
            Context r13 = r7.getContext();
            if (r13 == null) goto L30;
            r6 = r13.getString(2131911118);
        L30:
            SingleTtsSpeakerSettingFragment.Z90(r7, true, r6, r9, 8);
            return;
        L31:
            if (r12 == 2) goto L121;
            VoiceItemAdapter r14 = r7.f;
            if (r14 == null) goto L48;
            List<o2> r15 = r14.a;
            if (r15 == null) goto L48;
            Iterator<T> r16 = r15.iterator();
        L39:
            if (r16.hasNext() == false) goto L46;
            Object r17 = r16.next();
            if (((o2) r17).b != 20) goto L43;
            boolean r18 = true;
        L44:
            if (r18 == false) goto L39;
        L47:
            o2 r19 = (o2) r17;
        L49:
            if (r19 != null) goto L122;
            FLogger.a.i("SingleTtsSpeakerSettingFragment", "voice clicked: " + r9);
            if (r7.j == false) goto L54;
            r7.aa0(r9);
        L87:
            com.larus.voice_setting.voice.base.g1 r20 = com.larus.voice_setting.voice.base.g1.a;
            BotModel r21 = r7.h;
            if (r21 == null) goto L90;
            String r110 = r21.getBotId();
        L91:
            String r111 = r7.o;
            RecommendFrom r22 = r7.t;
            if (r22 == null) goto L94;
            String r112 = r22.a;
        L95:
            String r23 = r7.v;
            if (r22 == null) goto L98;
            String r113 = r22.b;
        L99:
            p2a.d.a.a(r20, r9, r110, false, r111, r111, "rec_tab", r112, r113, null, null, null, null, null, null, null, r23, null, null, null, null, null, 4128256);
            p2a.q.a().stopAudio();
            com.larus.audio.s0 r24 = p2a.q.a();
            String r114 = r9.getStyleId();
            AudioPreview r25 = r9.getPreview();
            if (r25 == null) goto L102;
            String r115 = r25.getPreviewAudio();
        L103:
            AudioPreview r26 = r9.getPreview();
            if (r26 == null) goto L106;
            r6 = r26.getMd5();
        L106:
            com.larus.audio.s0.a.a(r24, r114, r115, r6, null, r9.getId(), r9.getName(), 8);
            return;
        L102:
            r115 = null;
            goto L103
        L98:
            r113 = null;
            goto L99
        L94:
            r112 = null;
            goto L95
        L90:
            r110 = null;
            goto L91
        L54:
            VoiceItemAdapter r27 = r7.f;
            if (r27 == null) goto L57;
            List<o2> r28 = r27.a;
        L59:
            if (r28 == null) goto L73;
            Iterator<o2> r29 = r28.iterator();
        L62:
            if (r29.hasNext() == false) goto L71;
            SpeakerVoice r30 = r29.next().a;
            if (r30 == null) goto L66;
            String r31 = r30.getId();
        L68:
            if (Intrinsics.areEqual(r31, r9.getId()) == true) goto L72;
            r4 = r4 + 1;
        L72:
            Integer r32 = Integer.valueOf(r4);
        L74:
            if (r32 == null) goto L84;
            if (r32.intValue() == (-1)) goto L84;
            o2 r35 = (o2) CollectionsKt.getOrNull(r28, r32.intValue());
            if (r35 == null) goto L80;
            r35.b = 20;
        L80:
            VoiceItemAdapter r36 = r7.f;
            if (r36 == null) goto L84;
            r36.notifyItemChanged(r32.intValue());
        L84:
            if (r7.h == null) goto L123;
            r7.V90().updateVoice(r7.h, r9);
            goto L87
        L123:
            return;
        L66:
            r31 = null;
            goto L68
        L71:
            r4 = -1;
            goto L72
        L73:
            r32 = null;
            goto L74
        L57:
            r28 = null;
            goto L59
        L122:
            return;
        L43:
            r18 = false;
            goto L44
        L46:
            r17 = null;
        L48:
            r19 = null;
            goto L49
        L121:
            return;
        L116:
            return;
        L5:
            if (r33.f != 2) goto L7;
            r5 = true;
            goto L8
        }

        @Override // com.larus.voice_setting.voice.u2
        public final void c(final o2 r94, final View r95) {
            Intrinsics.checkNotNullParameter(r95, "itemView");
            if (r94 != null) goto L5;
            return;
        L5:
            final SingleTtsSpeakerSettingFragment r2 = this.a;
            int r3 = SingleTtsSpeakerSettingFragment.y;
            r2.getClass();
            View r11 = CreateMenu.f(new CreateMenu(r2.requireContext()), CollectionsKt.listOf(new com.larus.bmhome.view.screenmenu.l0[]{new com.larus.bmhome.view.screenmenu.l0(2131911105, 2131911105, null, null, null, Integer.valueOf(v19.c.b(2130972079, r2.getContext(), 2131103136)), null, Integer.valueOf(v19.c.b(2130971821, r2.getContext(), 2131241952)), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127), new com.larus.bmhome.view.screenmenu.l0(2131901607, 2131901607, null, null, null, 2131102650, null, 2131241933, null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -164, 127)}), 0, false, null, null, null, null, new z0(r2, r94, r95), 510);
            Balloon r1 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.a, r95, r11, false, null, null, null, null, 124);
            ViewGroup.LayoutParams r4 = r11.getLayoutParams();
            if ((r4 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
            ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        L9:
            if (r5 == null) goto L12;
            r5.rightMargin = (-i5.Q()) + i5.r0();
        L12:
            r1.x(r95, r95.getMeasuredWidth() - i5.r0(), -i5.Q());
            com.larus.voice_setting.voice.base.g1 r6 = com.larus.voice_setting.voice.base.g1.a;
            String r7 = this.a.o;
            Intrinsics.checkNotNullParameter(r7, "enterFrom");
            com.larus.platform.service.o r8 = com.larus.platform.service.o.a;
            JSONObject r9 = new JSONObject();
            r9.put("enter_from", r7);
            Unit r10 = Unit.INSTANCE;
            r8.reportEvent("click_voice_setting", r9);
            return;
        L8:
            r5 = null;
            goto L9
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

    static {
    }

    public final boolean S90() {
        return false;
    }

    public final String k() {
        return "bot_voice_change";
    }

    public final TtsSpeakerSettingViewModel V90() {
        return (TtsSpeakerSettingViewModel) this.g.getValue();
    }

    public final x2a.h W90() {
        return (x2a.h) this.w.getValue();
    }

    public final void onPause() {
        W90().d();
        super/*androidx.fragment.app.Fragment*/.onPause();
        com.larus.voice_setting.voice.base.g1 r1 = com.larus.voice_setting.voice.base.g1.a;
        com.larus.voice_setting.voice.base.g1.f(this.u, this.t, Integer.valueOf(V90().getSpeakerVoiceEditModel().K.size()));
        p2a.q.a().stopAudio();
        p2a.q.a().i();
        if (this.p != null) goto L5;
        return;
    L5:
        if (this.q == 0) goto L32;
        long r2 = SystemClock.elapsedRealtime() - this.q;
        BotModel r5 = this.h;
        String r6 = null;
        if (r5 == null) goto L10;
        String r7 = r5.getBotId();
    L11:
        String r8 = this.o;
        SearchMobParam r9 = this.p;
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
        tx9.i3.h(r7, r8, Long.valueOf(r2), r10, r11, r6, r13, r14, r15, null, 3136);
        this.q = 0;
        return;
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
        goto L11
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.larus.voice_setting.voice.SingleTtsSpeakerSettingFragment$itemDecoration$1] */
    public SingleTtsSpeakerSettingFragment() {
        final Function0<Fragment> r0 = new SingleTtsSpeakerSettingFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TtsSpeakerSettingViewModel.class), new SingleTtsSpeakerSettingFragment$special$$inlined$viewModels$default$2(r0), new SingleTtsSpeakerSettingFragment$special$$inlined$viewModels$default$3(r0, this));
        this.k = "zh";
        this.l = NameKeys.UnloadStrategy_No_Strategy;
        this.o = "other";
        this.r = LazyKt.lazy(new o0());
        this.s = LazyKt.lazy(new p0());
        this.w = LazyKt.lazy(LazyThreadSafetyMode.NONE, new q0());
        this.x = new SingleTtsSpeakerSettingFragment$itemDecoration$1(this);
    }

    public final void onDestroy() {
        W90().i();
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        FragmentExtKt.addOnBackPressed.callback.1 r0 = this.i;
        if (r0 == null) goto L6;
        r0.remove();
        return;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        p2a.q.a().stopAudio();
        p2a.q.a().i();
        this.e = null;
    }

    public final void onResume() {
        super.onResume();
        View r0 = getView();
        if (r0 == null) goto L6;
        W90().e(r0);
    L6:
        if (this.p == null) goto L9;
        this.q = SystemClock.elapsedRealtime();
        return;
    }

    public final int U90(SpeakerVoice r6) {
        BotModel r0 = this.h;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        int r2 = 10;
        if (r1 == true) goto L10;
        SpeakerVoice r3 = this.m;
        String r4 = null;
        if (r3 == null) goto L15;
        String r5 = r3.getId();
    L17:
        if (Intrinsics.areEqual(r5, r6.getId()) == true) goto L11;
        BotModel r7 = this.h;
        if (r7 == null) goto L25;
        SpeakerVoice r8 = r7.getVoiceType();
        if (r8 == null) goto L25;
        r4 = r8.getId();
    L25:
        if (Intrinsics.areEqual(r4, r6.getId()) == true) goto L11;
    L27:
        if (r2 != 30) goto L29;
        this.u = r6;
    L29:
        return r2;
    L11:
        r2 = 30;
        goto L27
    L15:
        r5 = null;
        goto L17
    L10:
        if (Intrinsics.areEqual(r6.getId(), "0") == false) goto L27;
    L5:
        if (r0.getMuted() != true) goto L7;
        r1 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v22, types: [java.util.ArrayList] */
    public final Unit X90(List<SpeakerVoice> r45) {
        final LarusPageTtsSpeakerSettingBinding r1 = this.e;
        if (r1 == null) goto L152;
        Context r3 = getContext();
        if (r3 == null) goto L133;
        if (this.n == false) goto L33;
        if (r45 != null) goto L11;
        UgcVoiceLoader r4 = UgcVoiceLoader.a;
        List<SpeakerVoice> r5 = CollectionsKt.toList(UgcVoiceLoader.e);
    L12:
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L14:
        if (r7.hasNext() == false) goto L18;
        Object r8 = r7.next();
        if (Intrinsics.areEqual(((SpeakerVoice) r8).getLanguageCode(), this.k) == false) goto L14;
        r6.add(r8);
        goto L14
    L18:
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r10 = r6.iterator();
    L20:
        if (r10.hasNext() == false) goto L22;
        SpeakerVoice r11 = (SpeakerVoice) r10.next();
        r9.add(new o2(r11, U90(r11), 1, 0, 0, 56, 0));
        goto L20
    L22:
        UgcVoiceLoader r12 = UgcVoiceLoader.a;
        List r13 = CollectionsKt.toList(UgcVoiceLoader.f);
        ArrayList r14 = new ArrayList();
        Iterator r15 = r13.iterator();
    L24:
        if (r15.hasNext() == false) goto L28;
        Object r16 = r15.next();
        if (Intrinsics.areEqual(((SpeakerVoice) r16).getLanguageCode(), this.k) == false) goto L24;
        r14.add(r16);
        goto L24
    L28:
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r18 = r14.iterator();
    L30:
        if (r18.hasNext() == false) goto L32;
        r17.add(new o2((SpeakerVoice) r18.next(), 10, 3, 0, 0, 56, 0));
        goto L30
    L32:
        List r19 = CollectionsKt.sortedWith(CollectionsKt.plus(r9, r17), new d());
    L34:
        boolean r20 = true;
        if (FeatureKitDelegate.b.w0().b() == false) goto L37;
    L40:
        boolean r21 = true;
    L41:
        if (r21 == false) goto L45;
        AudioUserConfig r22 = (AudioUserConfig) AudioServiceDelegate.a.p().getValue();
        if (r22 == null) goto L50;
        List r23 = r22.getNewVoiceList();
    L51:
        if (r23 == null) goto L125;
        ArrayList r24 = new ArrayList();
        Iterator r25 = r23.iterator();
    L54:
        if (r25.hasNext() == false) goto L99;
        Object r110 = r25.next();
        SpeakerVoice r111 = (SpeakerVoice) r110;
        if (Intrinsics.areEqual(r111.getLanguageCode(), this.k) == false) goto L96;
        BotModel r112 = this.h;
        if (r112 == null) goto L60;
        String r113 = r112.getBotId();
    L61:
        com.larus.bmhome.chat.api.e0 r114 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r114 == null) goto L72;
        LaunchInfo r115 = r114.a;
        if (r115 == null) goto L72;
        FeatureConfig r116 = r115.y0();
        if (r116 == null) goto L72;
        FeatureDetail r117 = r116.I();
        if (r117 == null) goto L72;
        if (r117.b() != true) goto L72;
        boolean r118 = true;
    L73:
        if (r118 == false) goto L93;
        if (r113 != null) goto L83;
        List r119 = r111.getExclusiveBotIds();
        if (r119 != null) goto L78;
    L81:
        boolean r120 = true;
    L82:
        if (r120 == true) goto L93;
    L78:
        if (r119.isEmpty() == true) goto L81;
        r120 = false;
    L83:
        if (r113 == null) goto L92;
        List r121 = r111.getExclusiveBotIds();
        if (r121 != null) goto L87;
    L89:
        boolean r122 = false;
    L90:
        if (r122 == true) goto L92;
    L87:
        if (r121.contains(Long.valueOf(CastLongProtector.parseLong(r113))) == true) goto L89;
        r122 = true;
    L92:
        boolean r123 = false;
    L94:
        if (r123 == false) goto L96;
        boolean r124 = true;
    L97:
        if (r124 == false) goto L54;
        r24.add(r110);
    L93:
        r123 = true;
    L72:
        r118 = false;
        goto L73
    L60:
        r113 = null;
    L96:
        r124 = false;
        goto L97
    L99:
        List r2 = CollectionsKt.toMutableList(r24);
        if (r2 == null) goto L125;
        if (this.j == true) goto L113;
        BotModel r26 = this.h;
        if (r26 == null) goto L111;
        Integer r27 = r26.getBotType();
        if (r27 == null) goto L111;
        if (r27.intValue() != 1) goto L111;
    L112:
        if (r20 == false) goto L113;
    L121:
        List r28 = r2;
        ?? r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
        Iterator r30 = r28.iterator();
    L123:
        if (r30.hasNext() == false) goto L126;
        SpeakerVoice r31 = (SpeakerVoice) r30.next();
        r29.add(new o2(r31, U90(r31), 1, 0, 0, 56, 0));
    L126:
        List<o2> r32 = CollectionsKt.plus(r19, (Iterable) r29);
        VoiceItemAdapter r33 = this.f;
        if (r33 == null) goto L131;
        Intrinsics.checkNotNullParameter(r32, "<set-?>");
        r33.a = r32;
        VoiceItemAdapter r34 = this.f;
        if (r34 == null) goto L133;
        r34.notifyDataSetChanged();
        goto L133
    L131:
        r1.g.setLayoutManager(new LinearLayoutManager(r3));
        VoiceItemAdapter r35 = new VoiceItemAdapter(r32, new t2(false, false, null, null, false, 0, null, 125));
        r35.c = new c(this);
        this.f = r35;
        r1.g.setAdapter(r35);
        r1.g.addItemDecoration(this.x);
        y6.d(r1.g, new r0(r1), null, null, new s0(r1, this), 13);
    L111:
        r20 = false;
    L113:
        String r36 = this.k;
        BotModel r37 = this.h;
        if (r37 == null) goto L119;
        SpeakerVoice r38 = r37.getVoiceType();
        if (r38 == null) goto L119;
        String r39 = r38.getLanguage();
        if (r39 == null) goto L119;
    L120:
        ListProtector.add(r2, 0, new SpeakerVoice("0", null, null, null, null, r39, null, null, r36, null, null, null, 0, 0, false, 0, 0, null, null, false, null, 0, null, 0, 0, 0.0f, 0.0f, null, false, null, null, 2147483358, null));
    L119:
        r39 = this.l;
    L125:
        r29 = CollectionsKt.emptyList();
    L50:
        r23 = null;
        goto L51
    L45:
        com.larus.bmhome.chat.api.e0 r40 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r40 == null) goto L50;
        LaunchInfo r41 = r40.a;
        if (r41 == null) goto L50;
        r23 = r41.T0();
        goto L51
    L37:
        if (z2.a.a1() == true) goto L40;
        r21 = false;
        goto L41
    L11:
        r5 = r45;
        goto L12
    L33:
        r19 = CollectionsKt.emptyList();
    L133:
        return Unit.INSTANCE;
    L152:
        return null;
    }

    public final void aa0(SpeakerVoice r7) {
        if (this.e == null) goto L66;
        VoiceItemAdapter r0 = this.f;
        if (r0 == null) goto L56;
        List<o2> r1 = r0.a;
        if (r1 == null) goto L56;
        this.u = r7;
        List<o2> r2 = r1;
        Iterator<T> r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L15;
        o2 r4 = (o2) r3.next();
        if (r4.b != 30) goto L11;
        r4.b = 10;
        goto L11
    L15:
        Iterator<T> r5 = r2.iterator();
    L16:
        Object r6 = null;
        if (r5.hasNext() == false) goto L27;
        Object r8 = r5.next();
        SpeakerVoice r9 = ((o2) r8).a;
        if (r9 == null) goto L21;
        String r10 = r9.getId();
    L22:
        if (r7 == null) goto L25;
        r6 = r7.getId();
    L25:
        if (Intrinsics.areEqual(r10, r6) == false) goto L16;
        r6 = r8;
        goto L27
    L21:
        r10 = null;
    L27:
        o2 r11 = (o2) r6;
        if (r11 == null) goto L30;
        r11.b = 30;
    L30:
        VoiceItemAdapter r12 = this.f;
        if (r12 == null) goto L33;
        r12.notifyDataSetChanged();
    L33:
        FragmentActivity r13 = getActivity();
        boolean r14 = true;
        if (r13 == null) goto L37;
        r13.setResult(11, new Intent().putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("select_speaker_result", r7)})));
    L37:
        if (this.u != null) goto L40;
        r14 = false;
    L40:
        LarusPageTtsSpeakerSettingBinding r15 = this.e;
        if (r15 == null) goto L45;
        TextView r16 = r15.b;
        if (r16 == null) goto L45;
        r16.setEnabled(r14);
    L45:
        if (r14 == false) goto L51;
        LarusPageTtsSpeakerSettingBinding r17 = this.e;
        if (r17 == null) goto L56;
        TextView r18 = r17.b;
        if (r18 == null) goto L56;
        r18.setAlpha(1.0f);
        goto L56
    L51:
        LarusPageTtsSpeakerSettingBinding r19 = this.e;
        if (r19 == null) goto L56;
        TextView r20 = r19.b;
        if (r20 == null) goto L56;
        r20.setAlpha(0.3f);
    L56:
        Unit r21 = Unit.INSTANCE;
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        W90().g();
        W90().k("fragment_on_create", new t0(this));
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        W90().j(r8);
        LarusPageTtsSpeakerSettingBinding r10 = this.e;
        if (r10 == null) goto L5;
        NovaTitleBarEx r0 = r10.h;
        NovaTitleBarEx.Y5(r0, getString(2131900243), null, null, 6);
        NovaTitleBarEx.b6(r0, v19.c.b(2130971749, r0.getContext(), 2131241477), false, null, null, new n0(this), 14);
    L5:
        X90(null);
        LarusPageTtsSpeakerSettingBinding r11 = this.e;
        if (r11 != null) goto L8;
    L11:
        z2 r12 = z2.a;
        if (r12.a1() == false) goto L14;
        AudioServiceDelegate.a.p().observe(getViewLifecycleOwner(), new b(new m0(this)));
    L14:
        V90().getVoiceUpdate().observe(getViewLifecycleOwner(), new b(new x0(this)));
        UgcVoiceLoader.p.observe(getViewLifecycleOwner(), new b(new a1(this)));
        UgcVoiceLoader.v.observe(getViewLifecycleOwner(), new b(new b1(this)));
        UgcVoiceLoader.r.observe(getViewLifecycleOwner(), new b(new c1(this)));
        UgcVoiceLoader.t.observe(getViewLifecycleOwner(), new b(new d1(this)));
        UgcVoiceLoader.j.observe(getViewLifecycleOwner(), new b(new e1(this)));
        if (FeatureKitDelegate.b.w0().b() == false) goto L17;
    L20:
        boolean r1 = true;
    L21:
        if (r1 == false) goto L24;
        AudioServiceDelegate.a.p().observe(getViewLifecycleOwner(), new b(new f1(this)));
    L24:
        if (r12.a1() == false) goto L27;
        AudioServiceDelegate.a.v0();
    L27:
        if (this.n == false) goto L29;
        UgcVoiceLoader r13 = UgcVoiceLoader.a;
        UgcVoiceLoader.o(NameKeys.UnloadStrategy_No_Strategy);
    L29:
        Bundle r14 = getArguments();
        if (r14 != null) goto L32;
        return;
    L32:
        if (r14.getBoolean("key_create_voice", false) == false) goto L36;
        Z90(this, false, null, null, 15);
        return;
    L36:
        return;
    L17:
        if (r12.a1() == true) goto L20;
        r1 = false;
        goto L21
    L8:
        if (this.n == false) goto L10;
        r11.d.setVisibility(0);
        r11.e.setVisibility(0);
        AppCompatTextView r2 = r11.f;
        com.larus.voice_setting.voice.utils.f r3 = com.larus.voice_setting.voice.utils.f.a;
        r2.setText(getString(2131907848));
        r11.f.setVisibility(0);
        com.larus.utils.e1.d(r11.d, new h1(this));
    L10:
        Unit r15 = Unit.INSTANCE;
        goto L11
    }

    public final View onCreateView(final LayoutInflater r2, final ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return (View) W90().k("fragment_create_view", new g1(this, r2, r3));
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.voice_setting.voice.u0, java.lang.Object, kotlin.jvm.functions.Function2] */
    public final void Y90(final boolean r17, String r18, final SpeakerVoice r19, final boolean r20) {
        final Context r3 = getContext();
        if (r3 != null) goto L5;
        return;
    L5:
        String r0 = l2.a;
        final FragmentManager r15 = getParentFragmentManager();
        if (r17 == false) goto L8;
        final String r9 = r18;
    L12:
        final String r10 = this.o;
        final SearchMobParam r11 = this.p;
        BotModel r1 = this.h;
        if (r1 == null) goto L15;
        final String r12 = r1.getBotId();
    L17:
        if (com.larus.voice_setting.voice.utils.l.a() == true) goto L19;
    L21:
        String r2 = this.k;
    L22:
        final String r13 = r2;
        final ?? r8 = new u0(r17, r19, r3, this, r20);
        Intrinsics.checkNotNullParameter(r15, "fragmentManager");
        Intrinsics.checkNotNullParameter(r10, "enterFrom");
        Intrinsics.checkNotNullParameter(r13, "language");
        Intrinsics.checkNotNullParameter(r8, "voiceCheckSuccess");
        if (AudioServiceDelegate.a.getAudioConfig().o("voice_clone", "clone_button", true) == false) goto L26;
        return;
    L26:
        if (l2.d() == false) goto L28;
        l2.e(r15, r9, r10, r11, r12, r13, r8);
        return;
    L28:
        UgcVoiceAuthorizeDialog r4 = new UgcVoiceAuthorizeDialog();
        r4.setArguments(com.larus.utils.f.c(new Pair[]{TuplesKt.to("authorize_enter_from", r10)}));
        Function0<Unit> r5 = new i2(r15, r9, r10, r11, r12, r13, r8);
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r4.e = r5;
        LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, null, r6);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r15, r4, r6) == true) goto L39;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L34
    L32:
        r4.show(r15, null);
        return;
    L39:
        return;
    L19:
        if (AppHost.a.isOversea() == false) goto L21;
        AppLocaleUtils.a.getClass();
        r2 = AppLocaleUtils.c().getLanguage();
        Intrinsics.checkNotNull(r2);
        goto L22
    L15:
        r12 = null;
        goto L17
    L8:
        Context r7 = getContext();
        if (r7 == null) goto L11;
        r9 = r7.getString(2131911071);
        goto L12
    L11:
        r9 = null;
        goto L12
    }

    public static /* synthetic */ void Z90(SingleTtsSpeakerSettingFragment r3, boolean r4, String r5, SpeakerVoice r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r4 = false;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if ((r7 & 4) == 0) goto L11;
        r6 = null;
    L11:
        r3.Y90(r4, r5, r6, false);
    }
}
