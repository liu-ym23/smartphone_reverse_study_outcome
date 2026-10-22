package com.larus.voice_setting.voice.dialog.v2;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.asr.view.ChatSpeaker;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.common.apphost.AppHost;
import com.larus.media.MediaLevel;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MixPriority;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.service.z2;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.impl.databinding.LarusDialogCreateUgcVoiceBinding;
import com.larus.voice_setting.voice.dialog.v2.viewmodel.UgcVoiceCreateSharedViewModel;
import com.larus.voice_setting.voice.dialog.v2.viewmodel.UgcVoiceViewModel;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import tx9.i3;
import tx9.w2;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 _2\u00020\u0001:\u0002_`B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u000205H\u0002J&\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u001a\u0010?\u001a\u0002052\u0006\u0010@\u001a\u00020:2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u0010A\u001a\u000205H\u0016J\b\u0010B\u001a\u000205H\u0016J\b\u0010C\u001a\u000205H\u0002J\b\u0010D\u001a\u000205H\u0002J\b\u0010E\u001a\u000205H\u0002J\u000f\u0010F\u001a\u0004\u0018\u000105H\u0003¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u000205H\u0002J\b\u0010I\u001a\u000205H\u0002J\u0012\u0010J\u001a\u0002052\b\u0010K\u001a\u0004\u0018\u00010LH\u0002J\b\u0010M\u001a\u000205H\u0002J\b\u0010N\u001a\u000205H\u0016J$\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010@\u001a\u00020:2\u0006\u0010P\u001a\u00020QH\u0002J\u001c\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010@\u001a\u00020:H\u0002J\b\u0010S\u001a\u000205H\u0002J\u0010\u0010T\u001a\u0002052\u0006\u0010U\u001a\u00020VH\u0002J(\u0010W\u001a\u0002052\u0006\u0010X\u001a\u00020\u00172\u0006\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020V2\u0006\u0010[\u001a\u00020\u0017H\u0002J\u000e\u0010\\\u001a\u0002052\u0006\u0010U\u001a\u00020VJ\u000e\u0010]\u001a\u0002052\u0006\u0010^\u001a\u00020\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\r\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\r\u001a\u0004\b/\u00100R\u000e\u00102\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/larus/voice_setting/voice/dialog/v2/UgcVoiceCreateFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "touchDownTime", NameKeys.UnloadStrategy_No_Strategy, "binding", "Lcom/larus/voice_setting/impl/databinding/LarusDialogCreateUgcVoiceBinding;", "voiceCheckFile", "Ljava/io/File;", "getVoiceCheckFile", "()Ljava/io/File;", "voiceCheckFile$delegate", "Lkotlin/Lazy;", "voiceRecordFile", "getVoiceRecordFile", "voiceRecordFile$delegate", "globalActionXY", "Lkotlin/Pair;", NameKeys.UnloadStrategy_No_Strategy, "countDownTimer", "Landroid/os/CountDownTimer;", "freeTalkContent", NameKeys.UnloadStrategy_No_Strategy, "title", "enterFrom", "enterMethod", "logTraceId", "isVoiceGRANTED", NameKeys.UnloadStrategy_No_Strategy, "language", "searchMobParam", "Lcom/larus/platform/model/SearchMobParam;", "botId", "searchStartTime", "trackParams", "Lorg/json/JSONObject;", "recordApplicant", "Lcom/larus/media/model/MediaRequestApplicant;", "playApplicant", "viewModel", "Lcom/larus/voice_setting/voice/dialog/v2/viewmodel/UgcVoiceViewModel;", "getViewModel", "()Lcom/larus/voice_setting/voice/dialog/v2/viewmodel/UgcVoiceViewModel;", "viewModel$delegate", "ugcVoiceSharedViewModel", "Lcom/larus/voice_setting/voice/dialog/v2/viewmodel/UgcVoiceCreateSharedViewModel;", "getUgcVoiceSharedViewModel", "()Lcom/larus/voice_setting/voice/dialog/v2/viewmodel/UgcVoiceCreateSharedViewModel;", "ugcVoiceSharedViewModel$delegate", "hasCancel", "isFromVoiceCloneScheme", "onCreate", NameKeys.UnloadStrategy_No_Strategy, "savedInstanceState", "Landroid/os/Bundle;", "initParams", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onPause", "reportSearchStayTime", "initVoiceCheckModel", "initFreeTalk", "initUI", "()Lkotlin/Unit;", "releaseVui", "startRecord", "checkResult", "res", "Lcom/larus/audio/quality/AudioCheckerResult;", "countDownRecordTime", "onDestroy", "getGlobalActionXY", "event", "Landroid/view/MotionEvent;", "getDeltaXY", "trackPressCreateOwnVoice", "traceDialogShowStatus", "status", "Lcom/larus/voice_setting/voice/dialog/v2/UgcVoiceCreateFragment$PageStatus;", "traceDialogClickStatus", "clickFrom", "clickPosition", "pageStatus", "previousPage", "updateTitle", "updateSpeakerText", "isShow", "Companion", "PageStatus", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UgcVoiceCreateFragment extends Fragment {
    public static final /* synthetic */ int z = 0;
    public long d;
    public LarusDialogCreateUgcVoiceBinding e;
    public final Lazy f;
    public final Lazy g;
    public Pair<Float, Float> h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public boolean n;
    public String o;
    public SearchMobParam p;
    public String q;
    public long r;
    public JSONObject s;
    public final com.larus.media.model.a t;
    public final com.larus.media.model.a u;
    public final Lazy v;
    public final Lazy w;
    public boolean x;
    public boolean y;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/voice_setting/voice/dialog/v2/UgcVoiceCreateFragment$PageStatus;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NORMAL_STATUS", "RECODING_STATUS", "VERIFY_STATUS", "FAIL_STATUS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PageStatus extends Enum<PageStatus> {
        public static final PageStatus FAIL_STATUS = null;
        public static final PageStatus NORMAL_STATUS = null;
        public static final PageStatus RECODING_STATUS = null;
        public static final PageStatus VERIFY_STATUS = null;
        public static final /* synthetic */ PageStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<PageStatus> getEntries() {
            return b;
        }

        static {
            PageStatus r0 = new PageStatus("NORMAL_STATUS", 0, "normal");
            NORMAL_STATUS = r0;
            PageStatus r1 = new PageStatus("RECODING_STATUS", 1, "recording");
            RECODING_STATUS = r1;
            PageStatus r2 = new PageStatus("VERIFY_STATUS", 2, "verify");
            VERIFY_STATUS = r2;
            PageStatus r4 = new PageStatus("FAIL_STATUS", 3, "fail");
            FAIL_STATUS = r4;
            PageStatus[] r6 = {r0, r1, r2, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
        }

        public static PageStatus[] values() {
            return (PageStatus[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static PageStatus valueOf(String r1) {
            return (PageStatus) r27.a.a(PageStatus.class, r1);
        }

        public PageStatus(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PageStatus.values().length];
            r0[PageStatus.NORMAL_STATUS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[PageStatus.RECODING_STATUS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[PageStatus.VERIFY_STATUS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[PageStatus.FAIL_STATUS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c implements com.larus.media.v {
        public c() {
        }

        public final boolean b(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            return true;
        }

        public final void e(lk9.g r1) {
            com.larus.media.v.a.d(r1);
        }

        public final void f(MediaResourceManager.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void a(lk9.g r1, float r2) {
            com.larus.media.v.a.f(r1, r2);
        }

        public final void d(lk9.g r1, lk9.g r2) {
            com.larus.media.v.a.c(r1, r2);
        }

        public final void g(lk9.g r1, float r2) {
            com.larus.media.v.a.g(r1, r2);
        }

        public final void i(lk9.g r1, lk9.g r2) {
            com.larus.media.v.a.e(r1, r2);
        }

        public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
            return com.larus.media.v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(lk9.g r1, lk9.g r2, int r3) {
            return com.larus.media.v.a.b(r1, r2);
        }
    }

    public static final class d implements com.larus.media.v {
        public d() {
        }

        public final boolean b(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            return true;
        }

        public final void e(lk9.g r1) {
            com.larus.media.v.a.d(r1);
        }

        public final void f(MediaResourceManager.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void a(lk9.g r1, float r2) {
            com.larus.media.v.a.f(r1, r2);
        }

        public final void d(lk9.g r1, lk9.g r2) {
            com.larus.media.v.a.c(r1, r2);
        }

        public final void g(lk9.g r1, float r2) {
            com.larus.media.v.a.g(r1, r2);
        }

        public final void i(lk9.g r1, lk9.g r2) {
            com.larus.media.v.a.e(r1, r2);
        }

        public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
            return com.larus.media.v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(lk9.g r1, lk9.g r2, int r3) {
            return com.larus.media.v.a.b(r1, r2);
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

    static {
    }

    public UgcVoiceCreateFragment() {
        this.f = LazyKt.lazy(new o(this));
        this.g = LazyKt.lazy(new p(this));
        Float r2 = Float.valueOf(0.0f);
        this.h = new Pair(r2, r2);
        this.i = NameKeys.UnloadStrategy_No_Strategy;
        this.l = NameKeys.UnloadStrategy_No_Strategy;
        this.m = NameKeys.UnloadStrategy_No_Strategy;
        this.o = NameKeys.UnloadStrategy_No_Strategy;
        int r12 = MediaLevel.RECORD_LOW.getValue();
        this.t = new com.larus.media.model.a(null, "UGC_VOICE", false, 0, 1, false, MixPriority.DEFAULT.getValue(), false, false, r12, false, new d(), 1453);
        int r25 = MediaLevel.PLAY_BIG_HIGH.getValue();
        this.u = new com.larus.media.model.a(null, "UGC_VOICE", false, 0, 2, false, MixPriority.MIX_NORMAL.getValue(), false, false, r25, false, new c(), 1453);
        final Function0 r1 = new q(this);
        this.v = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(UgcVoiceViewModel.class), new UgcVoiceCreateFragment$special$$inlined$viewModels$default$1(r1), new UgcVoiceCreateFragment$special$$inlined$viewModels$default$2(r1, this));
        this.w = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(UgcVoiceCreateSharedViewModel.class), new UgcVoiceCreateFragment$special$$inlined$activityViewModels$default$1(this), new UgcVoiceCreateFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public final UgcVoiceCreateSharedViewModel S90() {
        return (UgcVoiceCreateSharedViewModel) this.w.getValue();
    }

    public final void T90() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L12;
        com.larus.home.impl.sdk.s r1 = r0.s0();
        if (r1 == null) goto L12;
        Integer r2 = r1.l();
        if (r2 == null) goto L12;
        if (r2.intValue() != 2) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L16;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UgcVoiceCreateFragment$releaseVui$1(null), 3, null);
        return;
    L16:
        return;
    L12:
        r3 = false;
        goto L13
    }

    public final void onPause() {
        super.onPause();
        if (this.p != null) goto L5;
        return;
    L5:
        if (this.r == 0) goto L29;
        long r0 = SystemClock.elapsedRealtime() - this.r;
        String r4 = this.q;
        String r5 = this.k;
        SearchMobParam r6 = this.p;
        if (r6 == null) goto L10;
        String r8 = r6.a;
    L11:
        if (r6 == null) goto L13;
        String r9 = r6.b;
    L14:
        if (r6 == null) goto L16;
        String r10 = r6.c;
    L17:
        if (r6 == null) goto L19;
        String r11 = r6.d;
    L20:
        if (r6 == null) goto L22;
        String r12 = r6.e;
    L23:
        if (r6 == null) goto L25;
        String r13 = r6.f;
    L26:
        i3.h(r4, r5, Long.valueOf(r0), r8, r9, r13, r10, r11, r12, null, 3136);
        this.r = 0;
        return;
    L25:
        r13 = null;
        goto L26
    L22:
        r12 = null;
        goto L23
    L19:
        r11 = null;
        goto L20
    L16:
        r10 = null;
        goto L17
    L13:
        r9 = null;
        goto L14
    L10:
        r8 = null;
        goto L11
    }

    public final void onResume() {
        super.onResume();
        if (this.p == null) goto L6;
        this.r = SystemClock.elapsedRealtime();
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
    }

    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        Bundle r8 = getArguments();
        String r2 = NameKeys.UnloadStrategy_No_Strategy;
        if (r8 == null) goto L27;
        this.j = r8.getString("key_title");
        this.k = r8.getString("create_enter_from");
        String r3 = r8.getString("key_language");
        if (r3 != null) goto L7;
        AppLocaleUtils.a.getClass();
        r3 = AppLocaleUtils.c().getLanguage();
    L7:
        this.o = r3;
        this.p = r8.getParcelable("argSearchMobParam");
        this.q = r8.getString("argBotId");
        String r4 = r8.getString("key_enter_method", NameKeys.UnloadStrategy_No_Strategy);
        if (r4 != null) goto L10;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L10:
        this.l = r4;
        String r5 = r8.getString("key_log_trace_id", NameKeys.UnloadStrategy_No_Strategy);
        if (r5 != null) goto L13;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        this.m = r5;
        String r6 = r8.getString("track_params", NameKeys.UnloadStrategy_No_Strategy);
        if (r6 != null) goto L39;
    L26:
        this.y = r8.getBoolean("key_from_voice_clone_scheme", false);
        goto L27
    L39:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L23
        if (r6.length() <= 0) goto L18;
        boolean r10 = true;
    L19:
        if (r10 == false) goto L21;
        this.s = new JSONObject(r6);     // Catch: Throwable -> L23
    L21:
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Result.box-impl(r11);
        goto L26
    L18:
        r10 = false;
    L23:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L27:
        f2a.c r13 = com.larus.voice_setting.voice.utils.k.a.b("onCreate");
        r13.c.d = "UgcVoiceCreateFragment.onCreate";
        LinkedHashMap r14 = new LinkedHashMap();
        f2a.f r15 = new f2a.f("enter_from");
        String r16 = this.k;
        if (r16 != null) goto L30;
        r16 = NameKeys.UnloadStrategy_No_Strategy;
    L30:
        r14.put(r15, r16);
        f2a.f r17 = f2a.f.e;
        String r18 = this.q;
        if (r18 != null) goto L33;
        r18 = NameKeys.UnloadStrategy_No_Strategy;
    L33:
        r14.put(r17, r18);
        r14.put(new f2a.f("language"), this.o);
        f2a.f r19 = new f2a.f("title");
        String r20 = this.j;
        if (r20 == null) goto L37;
        r2 = r20;
    L37:
        r14.put(r19, r2);
        r13.d(r14);
        List r0 = CollectionsKt.listOf(new String[]{this.m, "VoiceCreate"});
        f2a.g r1 = r13.c;
        r1.b = r0;
        r1.e = this.l;
        f2a.c.c(r13, null, 15);
    }

    public final void onViewCreated(View r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super.onViewCreated(r13, r14);
        FLogger r15 = FLogger.a;
        r15.i("CreateUgcVoiceDialog", "[initFreeTalk] start");
        t2a.c.a.getClass();
        t2a.c.a();
        s2a.a r16 = t2a.c.d;
        String r1 = null;
        if (r16 == null) goto L15;
        Map<String, List<String>> r17 = r16.b();
        if (r17 == null) goto L15;
        Map r18 = new LinkedHashMap(MapsKt.mapCapacity(r17.size()));
        Iterator<T> r19 = r17.entrySet().iterator();
    L8:
        if (r19.hasNext() == false) goto L19;
        Map.Entry r2 = (Map.Entry) r19.next();
        Object r3 = r2.getKey();
        List r4 = (List) r2.getValue();
        if (r4 == null) goto L13;
        List r5 = CollectionsKt.filterNotNull(r4);
        if (r5 == null) goto L13;
    L14:
        r18.put(r3, r5);
    L13:
        r5 = CollectionsKt.emptyList();
    L19:
        e0 r110 = (e0) AuthModelDelegate.b.e().getValue();
        if (r110 == null) goto L22;
        LaunchInfo r111 = r110.a;
    L24:
        if (AppHost.a.isOversea() == false) goto L37;
        if (r111 == null) goto L27;
        boolean r6 = Intrinsics.areEqual(r111.i0(), Boolean.TRUE);
    L28:
        if (r6 == false) goto L37;
        List r112 = r111.v0();
        if (r112 != null) goto L32;
    L34:
        boolean r113 = false;
    L35:
        if (r113 == true) goto L37;
        String r114 = "en";
    L38:
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("[initFreeTalk] list size: ");
        if (r18 == null) goto L41;
        Integer r9 = Integer.valueOf(r18.size());
    L42:
        r8.append(r9);
        r8.append(", language: ");
        r8.append(this.o);
        r8.append(", realLanguage: ");
        r8.append(r114);
        r7.i("CreateUgcVoiceDialog", r8.toString());
        String r10 = NameKeys.UnloadStrategy_No_Strategy;
        if (r18 == null) goto L61;
        List r115 = (List) r18.get(r114);
        if (r115 == null) goto L61;
        if ((!r115.isEmpty()) == false) goto L56;
        r7.i("CreateUgcVoiceDialog", "[initFreeTalk] use language(" + r114 + ") list with size: " + r115.size());
        String r116 = (String) ListProtector.get(r115, new SecureRandom().nextInt(r115.size()));
        if (r116.length() != 0) goto L51;
        boolean r117 = true;
    L52:
        if (r117 == false) goto L60;
        Context r118 = getContext();
        if (r118 == null) goto L59;
        r116 = r118.getString(2131911072);
    L59:
        r116 = null;
    L60:
        if (r116 == null) goto L61;
    L67:
        this.i = r116;
        Context r119 = getContext();
        if (r119 != null) goto L71;
    L73:
        final LarusDialogCreateUgcVoiceBinding r120 = this.e;
        if (r120 == null) goto L105;
        r120.d.setText(this.i);
        e1.d(r120.b, new r(this));
        r120.g.z = true;
        if (z2.a.S1().getEnableNewStyle() == false) goto L90;
        r120.g.r7(false, null);
        r120.g.setAudioVisualizerBottomMargin(i5.Z());
        r120.g.setPadding(0, 0, 0, 0);
        ChatSpeaker r0 = r120.g;
        ViewGroup.LayoutParams r11 = r0.getLayoutParams();
        if (r11 == null) goto L89;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        r12.bottomMargin = 0;
        r0.setLayoutParams(r12);
        ConstraintSet r20 = new ConstraintSet();
        LarusDialogCreateUgcVoiceBinding r21 = this.e;
        if (r21 == null) goto L82;
        ConstraintLayout r22 = r21.a;
    L83:
        r20.clone(r22);
        r20.clear(2131368220, 4);
        r20.connect(2131368220, 4, 0, 4);
        LarusDialogCreateUgcVoiceBinding r23 = this.e;
        if (r23 == null) goto L86;
        ConstraintLayout r24 = r23.a;
    L87:
        r20.applyTo(r24);
        goto L90
    L86:
        r24 = null;
        goto L87
    L82:
        r22 = null;
        goto L83
    L89:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L90:
        LarusDialogCreateUgcVoiceBinding r25 = this.e;
        if (r25 == null) goto L104;
        TextView r26 = r25.c;
        if (r26 == null) goto L104;
        String r27 = this.j;
        if (r27 == null) goto L97;
    L96:
        r10 = r27;
    L103:
        r26.setText(r10);
        goto L104
    L97:
        Context r28 = getContext();
        if (r28 == null) goto L100;
        r27 = r28.getString(2131911071);
    L101:
        if (r27 == null) goto L103;
    L100:
        r27 = null;
    L104:
        r120.e.setOnTouchListener(new s(this, r120));
        ChatSpeaker r29 = r120.g;
        Function0 r30 = new t(this, r120);
        r29.getClass();
        Intrinsics.checkNotNullParameter(r30, "callback");
        r29.e = r30;
        ChatSpeaker r31 = r120.g;
        Function2 r32 = new u(this, r120);
        r31.getClass();
        Intrinsics.checkNotNullParameter(r32, "callback");
        r31.f = r32;
        Unit r121 = Unit.INSTANCE;
    L105:
        String r122 = this.j;
        Context r33 = getContext();
        if (r33 == null) goto L109;
        r1 = r33.getString(2131911071);
    L109:
        if (Intrinsics.areEqual(r122, r1) == false) goto L114;
        String r123 = PageStatus.NORMAL_STATUS.getValue();
        String r124 = this.k;
        String r34 = this.l;
        JSONObject r35 = this.s;
        if (r35 != null) goto L113;
        r35 = new JSONObject();
    L113:
        w2.b(r123, r124, r34, r35, 16);
    L114:
        S90().getUgcVoiceCreatePageStatus().observe(getViewLifecycleOwner(), new e(new com.larus.voice_setting.voice.dialog.v2.e(this)));
        S90().getUgcVoiceCreateSpeakerTextVisibility().observe(getViewLifecycleOwner(), new e(new m(this)));
        S90().getCloseUgcVoiceCreateDialog().observe(getViewLifecycleOwner(), new e(new n(this)));
        return;
    L71:
        if (((File) this.f.getValue()).exists() == true) goto L73;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new UgcVoiceCreateFragment$initVoiceCheckModel$1(r119, this, null), 3, null);
        goto L73
    L51:
        r117 = false;
        goto L52
    L56:
        r7.i("CreateUgcVoiceDialog", "[initFreeTalk] language(" + r114 + ") list is empty");
        Context r125 = getContext();
        if (r125 == null) goto L59;
        r116 = r125.getString(2131911072);
    L61:
        Context r126 = getContext();
        if (r126 == null) goto L64;
        r116 = r126.getString(2131911072);
    L65:
        if (r116 != null) goto L67;
        r116 = NameKeys.UnloadStrategy_No_Strategy;
        goto L67
    L64:
        r116 = null;
        goto L65
    L41:
        r9 = null;
        goto L42
    L32:
        if (r112.contains(this.o) != true) goto L34;
        r113 = true;
        goto L35
    L27:
        r6 = false;
    L37:
        r114 = this.o;
        goto L38
    L22:
        r111 = null;
    L15:
        r15.i("VoiceMaterialRepo", "[getVoiceMaterial]: get from audio config");
        AudioUserConfig r127 = (AudioUserConfig) AudioServiceDelegate.a.p().getValue();
        if (r127 == null) goto L18;
        r18 = r127.getVoiceTalkList();
        goto L19
    L18:
        r18 = null;
        goto L19
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusDialogCreateUgcVoiceBinding r4 = LarusDialogCreateUgcVoiceBinding.a(r1, r2);
        this.e = r4;
        return r4.a;
    }

    public final void U90(String r8, long r9, PageStatus r11, String r12) {
        Long r1 = Long.valueOf(r9);
        String r2 = r11.getValue();
        String r4 = this.l;
        JSONObject r10 = this.s;
        if (r10 != null) goto L5;
        r10 = new JSONObject();
    L5:
        w2.a(r8, r1, r2, r12, r4, r10, 64);
    }
}
