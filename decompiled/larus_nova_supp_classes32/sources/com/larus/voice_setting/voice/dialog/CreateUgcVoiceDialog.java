package com.larus.voice_setting.voice.dialog;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.asr.view.ChatSpeaker;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.media.MediaLevel;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.MixPriority;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.SearchMobParam;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.e1;
import com.larus.voice_setting.impl.databinding.LarusDialogCreateUgcVoiceBinding;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import tx9.i3;
import tx9.w2;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 Y2\u00020\u0001:\u0002YZB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00100\u001a\u000201H\u0016J\u0012\u00102\u001a\u00020\u001f2\b\u00103\u001a\u0004\u0018\u000104H\u0016J&\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u001a\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u0002062\b\u00103\u001a\u0004\u0018\u000104H\u0017J\b\u0010=\u001a\u00020\u001fH\u0016J\b\u0010>\u001a\u00020\u001fH\u0016J\b\u0010?\u001a\u00020\u001fH\u0002J\b\u0010@\u001a\u00020\u001fH\u0002J\b\u0010A\u001a\u00020\u001fH\u0002J\u000f\u0010B\u001a\u0004\u0018\u00010\u001fH\u0003¢\u0006\u0002\u0010CJ\b\u0010D\u001a\u00020\u001fH\u0002J\b\u0010E\u001a\u00020\u001fH\u0002J\u0012\u0010F\u001a\u00020\u001f2\b\u0010G\u001a\u0004\u0018\u00010HH\u0002J\b\u0010I\u001a\u00020\u001fH\u0002J\b\u0010J\u001a\u00020\u001fH\u0016J$\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010<\u001a\u0002062\u0006\u0010L\u001a\u00020MH\u0002J\b\u0010N\u001a\u00020\u001fH\u0002J\u000e\u0010O\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020%J(\u0010Q\u001a\u00020\u001f2\u0006\u0010R\u001a\u00020\u00172\u0006\u0010S\u001a\u00020\u00052\u0006\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020\u0017H\u0002J\u000e\u0010V\u001a\u00020\u001f2\u0006\u0010P\u001a\u00020%J\u000e\u0010W\u001a\u00020\u001f2\u0006\u0010X\u001a\u00020'R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000RL\u0010\u001a\u001a4\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/larus/voice_setting/voice/dialog/CreateUgcVoiceDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "touchDownTime", NameKeys.UnloadStrategy_No_Strategy, "binding", "Lcom/larus/voice_setting/impl/databinding/LarusDialogCreateUgcVoiceBinding;", "voiceCheckFile", "Ljava/io/File;", "getVoiceCheckFile", "()Ljava/io/File;", "voiceCheckFile$delegate", "Lkotlin/Lazy;", "voiceRecordFile", "getVoiceRecordFile", "voiceRecordFile$delegate", "globalActionXY", "Lkotlin/Pair;", NameKeys.UnloadStrategy_No_Strategy, "countDownTimer", "Landroid/os/CountDownTimer;", "freeTalkContent", NameKeys.UnloadStrategy_No_Strategy, "title", "enterFrom", "voiceCheckSuccess", "Lkotlin/Function2;", "Lkotlin/ParameterName;", EasyGoDbTable.Server.NAME, "filePath", NameKeys.UnloadStrategy_No_Strategy, "getVoiceCheckSuccess", "()Lkotlin/jvm/functions/Function2;", "setVoiceCheckSuccess", "(Lkotlin/jvm/functions/Function2;)V", "currentStatus", "Lcom/larus/voice_setting/voice/dialog/CreateUgcVoiceDialog$PageStatus;", "isVoiceGRANTED", NameKeys.UnloadStrategy_No_Strategy, "language", "searchMobParam", "Lcom/larus/platform/model/SearchMobParam;", "botId", "searchStartTime", "recordApplicant", "Lcom/larus/media/model/MediaRequestApplicant;", "playApplicant", "getTheme", NameKeys.UnloadStrategy_No_Strategy, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onPause", "reportSearchStayTime", "initVoiceCheckModel", "initFreeTalk", "initUI", "()Lkotlin/Unit;", "releaseVui", "startRecord", "checkResult", "res", "Lcom/larus/audio/quality/AudioCheckerResult;", "countDownRecordTime", "onDestroy", "getGlobalActionXY", "event", "Landroid/view/MotionEvent;", "trackPressCreateOwnVoice", "traceDialogShowStatus", "status", "traceDialogClickStatus", "clickFrom", "clickPosition", "pageStatus", "previousPage", "updateTitle", "updateSpeakerText", "isShow", "Companion", "PageStatus", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateUgcVoiceDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int u = 0;
    public long d;
    public LarusDialogCreateUgcVoiceBinding e;
    public final Lazy f;
    public final Lazy g;
    public Pair<Float, Float> h;
    public String i;
    public String j;
    public String k;
    public Function2<? super String, ? super String, Unit> l;
    public PageStatus m;
    public boolean n;
    public String o;
    public SearchMobParam p;
    public String q;
    public long r;
    public final com.larus.media.model.a s;
    public final com.larus.media.model.a t;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/voice_setting/voice/dialog/CreateUgcVoiceDialog$PageStatus;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NORMAL_STATUS", "RECODING_STATUS", "VERIFY_STATUS", "FAIL_STATUS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public CreateUgcVoiceDialog() {
        this.f = LazyKt.lazy(new g(this));
        this.g = LazyKt.lazy(new h(this));
        Float r2 = Float.valueOf(0.0f);
        this.h = new Pair(r2, r2);
        this.i = NameKeys.UnloadStrategy_No_Strategy;
        this.m = PageStatus.NORMAL_STATUS;
        this.o = NameKeys.UnloadStrategy_No_Strategy;
        int r12 = MediaLevel.RECORD_LOW.getValue();
        this.s = new com.larus.media.model.a(null, "UGC_VOICE", false, 0, 1, false, MixPriority.DEFAULT.getValue(), false, false, r12, false, new d(), 1453);
        int r25 = MediaLevel.PLAY_BIG_HIGH.getValue();
        this.t = new com.larus.media.model.a(null, "UGC_VOICE", false, 0, 2, false, MixPriority.MIX_NORMAL.getValue(), false, false, r25, false, new c(), 1453);
    }

    public final void S90() {
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
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CreateUgcVoiceDialog$releaseVui$1(null), 3, null);
        return;
    L16:
        return;
    L12:
        r3 = false;
        goto L13
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
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
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (this.p == null) goto L6;
        this.r = SystemClock.elapsedRealtime();
        return;
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public final void T90(PageStatus r4) {
        Intrinsics.checkNotNullParameter(r4, "status");
        this.m = r4;
        w2.b(r4.getValue(), this.k, null, null, 28);
    }

    public final void U90(boolean r5) {
        LarusDialogCreateUgcVoiceBinding r0 = this.e;
        int r1 = 0;
        if (r0 == null) goto L10;
        TextView r2 = r0.e;
        if (r2 == null) goto L10;
        if (r5 == false) goto L8;
        int r3 = 0;
    L9:
        r2.setVisibility(r3);
        goto L10
    L8:
        r3 = 4;
    L10:
        LarusDialogCreateUgcVoiceBinding r4 = this.e;
        if (r4 == null) goto L19;
        View r6 = r4.f;
        if (r6 == null) goto L20;
        if (r5 == true) goto L17;
        r1 = 4;
    L17:
        r6.setVisibility(r1);
        return;
    L20:
        return;
    }

    public final void V90(PageStatus r3) {
        Intrinsics.checkNotNullParameter(r3, "status");
        LarusDialogCreateUgcVoiceBinding r0 = this.e;
        if (r0 == null) goto L22;
        TextView r1 = r0.c;
        if (r1 == null) goto L23;
        int r4 = b.a[r3.ordinal()];
        if (r4 != 1) goto L9;
        String r5 = r1.getContext().getString(2131911071);
    L20:
        r1.setText(r5);
        return;
    L9:
        if (r4 != 2) goto L11;
        r5 = r1.getContext().getString(2131911102);
        goto L20
    L11:
        if (r4 != 3) goto L13;
        r5 = r1.getContext().getString(2131911059);
        goto L20
    L13:
        if (r4 != 4) goto L16;
        r5 = r1.getContext().getString(2131911058);
        goto L20
    L16:
        throw new NoWhenBranchMatchedException();
    L23:
        return;
    }

    public final void onCreate(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
        Bundle r4 = getArguments();
        String r0 = null;
        if (r4 == null) goto L5;
        String r5 = r4.getString("key_title");
    L6:
        this.j = r5;
        Bundle r6 = getArguments();
        if (r6 == null) goto L9;
        String r7 = r6.getString("create_enter_from");
    L10:
        this.k = r7;
        Bundle r8 = getArguments();
        if (r8 == null) goto L14;
        String r9 = r8.getString("key_language");
        if (r9 == null) goto L14;
    L15:
        this.o = r9;
        Bundle r10 = getArguments();
        if (r10 == null) goto L18;
        SearchMobParam r11 = (SearchMobParam) r10.getParcelable("argSearchMobParam");
    L19:
        this.p = r11;
        Bundle r12 = getArguments();
        if (r12 == null) goto L22;
        r0 = r12.getString("argBotId");
    L22:
        this.q = r0;
        return;
    L18:
        r11 = null;
    L14:
        AppLocaleUtils.a.getClass();
        r9 = AppLocaleUtils.c().getLanguage();
        goto L15
    L9:
        r7 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        BottomSheetDialog r12 = getDialog();
        if ((r12 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r13 = r12;
    L6:
        if (r13 == null) goto L8;
        View r14 = r13.findViewById(2131368870);
    L9:
        int r15 = com.larus.utils.m0.a;
        int r16 = com.larus.utils.m0.a(getContext());
        com.larus.utils.i0.a.getClass();
        int r17 = ((r16 - com.larus.utils.i0.g()) - com.larus.utils.i0.e()) - i5.c0();
        if (r14 == null) goto L13;
        ViewGroup.LayoutParams r1 = r14.getLayoutParams();
        r1.height = r17;
        r14.setLayoutParams(r1);
        BottomSheetBehavior r2 = BottomSheetBehavior.from(r14);
        r14.setBackgroundResource(R.color.transparent);
        r2.setState(3);
        r2.setPeekHeight(r17);
    L13:
        if (FeatureKitDelegate.b.w0().b() == false) goto L17;
        AudioUserConfig r18 = (AudioUserConfig) AudioServiceDelegate.a.p().getValue();
        if (r18 == null) goto L22;
        Map r19 = r18.getVoiceTalkList();
    L23:
        com.larus.bmhome.chat.api.e0 r110 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r110 == null) goto L26;
        LaunchInfo r111 = r110.a;
    L27:
        boolean r3 = false;
        if (AppHost.a.isOversea() == false) goto L41;
        if (r111 == null) goto L31;
        boolean r4 = Intrinsics.areEqual(r111.i0(), Boolean.TRUE);
    L32:
        if (r4 == false) goto L41;
        List r112 = r111.v0();
        if (r112 != null) goto L36;
    L38:
        boolean r113 = false;
    L39:
        if (r113 == true) goto L41;
        String r114 = "en";
    L42:
        String r5 = NameKeys.UnloadStrategy_No_Strategy;
        if (r19 == null) goto L60;
        List r115 = (List) r19.get(r114);
        if (r115 == null) goto L60;
        if ((!r115.isEmpty()) == false) goto L55;
        String r116 = (String) ListProtector.get(r115, new SecureRandom().nextInt(r115.size()));
        if (r116.length() != 0) goto L51;
        r3 = true;
    L51:
        if (r3 == false) goto L59;
        Context r117 = getContext();
        if (r117 == null) goto L58;
        r116 = r117.getString(2131911072);
    L58:
        r116 = null;
    L59:
        if (r116 == null) goto L60;
    L66:
        this.i = r116;
        Context r118 = getContext();
        if (r118 != null) goto L70;
    L72:
        final LarusDialogCreateUgcVoiceBinding r119 = this.e;
        if (r119 == null) goto L89;
        r119.d.setText(this.i);
        e1.d(r119.b, new com.larus.voice_setting.voice.dialog.a(this));
        r119.g.z = true;
        LarusDialogCreateUgcVoiceBinding r6 = this.e;
        if (r6 == null) goto L88;
        TextView r7 = r6.c;
        if (r7 == null) goto L88;
        String r8 = this.j;
        if (r8 == null) goto L81;
    L80:
        r5 = r8;
    L87:
        r7.setText(r5);
        goto L88
    L81:
        Context r9 = getContext();
        if (r9 == null) goto L84;
        r8 = r9.getString(2131911071);
    L85:
        if (r8 == null) goto L87;
    L84:
        r8 = null;
    L88:
        r119.e.setOnTouchListener(new com.larus.voice_setting.voice.dialog.d(this, r119));
        ChatSpeaker r20 = r119.g;
        Function0 r21 = new e(this, r119);
        r20.getClass();
        Intrinsics.checkNotNullParameter(r21, "callback");
        r20.e = r21;
        ChatSpeaker r22 = r119.g;
        Function2 r23 = new f(r119, this);
        r22.getClass();
        Intrinsics.checkNotNullParameter(r23, "callback");
        r22.f = r23;
        Unit r120 = Unit.INSTANCE;
    L89:
        String r121 = this.j;
        Context r24 = getContext();
        if (r24 == null) goto L92;
        String r122 = r24.getString(2131911071);
    L94:
        if (Intrinsics.areEqual(r121, r122) == false) goto L97;
        w2.b(PageStatus.NORMAL_STATUS.getValue(), this.k, null, null, 28);
        return;
    L97:
        return;
    L92:
        r122 = null;
        goto L94
    L70:
        if (((File) this.f.getValue()).exists() == true) goto L72;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CreateUgcVoiceDialog$initVoiceCheckModel$1(r118, this, null), 3, null);
        goto L72
    L55:
        Context r123 = getContext();
        if (r123 == null) goto L58;
        r116 = r123.getString(2131911072);
    L60:
        Context r124 = getContext();
        if (r124 == null) goto L63;
        r116 = r124.getString(2131911072);
    L64:
        if (r116 != null) goto L66;
        r116 = NameKeys.UnloadStrategy_No_Strategy;
        goto L66
    L63:
        r116 = null;
        goto L64
    L36:
        if (r112.contains(this.o) != true) goto L38;
        r113 = true;
        goto L39
    L31:
        r4 = false;
    L41:
        r114 = this.o;
        goto L42
    L26:
        r111 = null;
    L22:
        r19 = null;
        goto L23
    L17:
        com.larus.bmhome.chat.api.e0 r125 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r125 == null) goto L22;
        LaunchInfo r126 = r125.a;
        if (r126 == null) goto L22;
        r19 = r126.G1();
        goto L23
    L8:
        r14 = null;
        goto L9
    L5:
        r13 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusDialogCreateUgcVoiceBinding r4 = LarusDialogCreateUgcVoiceBinding.a(r1, r2);
        this.e = r4;
        return r4.a;
    }
}
