package com.larus.doc.impl.audio;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.IFlowTtsClientService;
import com.larus.audio.asr.a0;
import com.larus.audio.asr.b0;
import com.larus.bmhome.utils.a4;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.TouchInterceptingView;
import com.larus.doc.sdk.api.IDocSdkBaseService;
import com.larus.doc.sdk.api.VoiceInputFrom;
import com.larus.platform.service.i2;
import com.larus.platform.spi.IAIChatAudioService;
import com.larus.ui.arch.component.external.api.Component;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import f39.c;
import f39.d;
import f39.e;
import f39.f;
import f39.g;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import n39.r;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u001a\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u00072\b\b\u0001\u0010%\u001a\u00020\u000bH\u0016J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0013H\u0002J\u0010\u0010(\u001a\u00020!2\u0006\u0010%\u001a\u00020\u000bH\u0002J\b\u0010)\u001a\u00020!H\u0016J\u0010\u0010*\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0013H\u0002J\b\u0010+\u001a\u00020!H\u0002J\b\u0010,\u001a\u00020!H\u0002J\u0010\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u000bH\u0002J\u0010\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u0019H\u0002J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0019H\u0002J\b\u00104\u001a\u00020!H\u0002J\b\u00105\u001a\u00020!H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/larus/doc/impl/audio/DocAudioComponent;", "Lcom/larus/ui/arch/component/external/api/Component;", "Lcom/larus/doc/impl/audio/IDocAudioAbility;", "<init>", "()V", "_inputStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "inputStatus", "Lkotlinx/coroutines/flow/StateFlow;", "taskId", "", "sdkService", "Lcom/larus/doc/sdk/api/IDocSdkBaseService;", "getSdkService", "()Lcom/larus/doc/sdk/api/IDocSdkBaseService;", "sdkService$delegate", "Lkotlin/Lazy;", "lastVoiceInputChangeTimeMs", "", "interceptorView", "Lcom/larus/common_ui/view/TouchInterceptingView;", "windowManager", "Landroid/view/WindowManager;", "validKeyboardHeight", "", "createDocByClickVoiceInput", "hasEnableVoiceByCreate", "startTimeStamp", "voiceInputDuration", "startFrom", "getVoiceInputStatus", "notifyDocLoadSuccess", "", "onAttach", "enableVoiceInput", "enable", "from", "startAsr", "startTime", "stopAsr", "onFragmentViewDestroyed", "realStartAsr", "notifySdkAsrStop", "addImeInterceptView", "stopTts", "reason", "attachToWindow", "height", "getLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "h", "removeImeInterceptView", "onStop", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocAudioComponent extends Component implements g {
    public static final /* synthetic */ int x = 0;
    public final StateFlowImpl l;
    public final StateFlowImpl m;
    public String n;
    public final Lazy o;
    public long p;
    public TouchInterceptingView q;
    public WindowManager r;
    public boolean s;
    public boolean t;
    public long u;
    public long v;
    public String w;

    public static final class a {
    }

    public static final class b implements a0 {
        public final /* synthetic */ DocAudioComponent a;

        public b(DocAudioComponent r1) {
            this.a = r1;
        }

        public final void a(b0 r7) {
            FLogger.a.i("DocAudioComponent", "[onStream] data:" + r7);
            DocAudioComponent r0 = this.a;
            int r1 = DocAudioComponent.x;
            IDocSdkBaseService r2 = (IDocSdkBaseService) r0.o.getValue();
            if (r2 == null) goto L15;
            r r3 = r2.getVoiceInputService();
            if (r3 == null) goto L15;
            String r4 = r7.a;
            String r5 = "";
            if (r4 != null) goto L9;
            r4 = "";
        L9:
            String r6 = r7.b;
            if (r6 == null) goto L13;
            r5 = r6;
        L13:
            r3.displayAsrText(new Pair(r4, r5));
        L15:
            if (Intrinsics.areEqual(r7.c, Boolean.FALSE) == false) goto L25;
            IDocSdkBaseService r8 = (IDocSdkBaseService) r0.o.getValue();
            if (r8 == null) goto L22;
            r r9 = r8.getVoiceInputService();
            if (r9 == null) goto L22;
            r9.stopVoiceInput(new f(r0));
        L22:
            if (((Boolean) r0.l.getValue()).booleanValue() == false) goto L26;
            r0.Qe(false, VoiceInputFrom.SERVER_INTERRUPT);
            return;
        L26:
            return;
        }
    }

    static {
    }

    public final void A2() {
        FLogger.a.i("DocAudioComponent", "onFragmentViewDestroyed");
        N2("onFragmentViewDestroyed");
        this.p = 0;
        this.s = false;
        this.t = false;
        IAIChatAudioService.a.a();
    }

    public final void L2() {
        TouchInterceptingView r0 = this.q;
        Unit r1 = null;
        if (r0 == null) goto L5;
        ViewParent r2 = r0.getParent();
    L6:
        if (r2 != null) goto L19;
        return;
    L19:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        WindowManager r4 = this.r;     // Catch: Throwable -> L13
        if (r4 == null) goto L11;
        r4.removeViewImmediate(this.q);     // Catch: Throwable -> L13
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Object r5 = Result.constructor-impl(r1);     // Catch: Throwable -> L13
    L15:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L21;
        FLogger.a.e("DocAudioComponent", "removeWindowView failed throwable=" + r6 + ", message=" + r6.getMessage());
        return;
    L21:
        return;
    L13:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    @Override // f39.g
    public final void notifyDocLoadSuccess() {
        if (this.s == true) goto L5;
        return;
    L5:
        if (this.t == true) goto L9;
        Qe(true, VoiceInputFrom.NEW_DOC);
        this.t = true;
        return;
    }

    public final void onStop() {
        FLogger.a.i("DocAudioComponent", "onStop");
        IAIChatAudioService.a.a(IAIChatAudioService.a, null, null, 31);
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, g.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        boolean r1 = false;
        if (r0 == null) goto L5;
        r1 = r0.getBoolean("key_create_new_doc_by_voice", false);
    L5:
        this.s = r1;
        FLogger.a.i("DocAudioComponent", "[onAttach] isFromClickVoice:" + this.s);
    }

    public DocAudioComponent() {
        StateFlowImpl r0 = j1.a(Boolean.FALSE);
        this.l = r0;
        this.m = r0;
        this.n = "";
        this.o = LazyKt.lazy(new f39.a());
        this.w = "unknown";
    }

    @Override // f39.g
    public final StateFlowImpl getVoiceInputStatus() {
        return this.m;
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [f39.c] */
    public final void F2(final long r6) {
        this.n = "doc_" + UUID.randomUUID();
        this.l.setValue(Boolean.TRUE);
        FLogger.a.i("DocAudioComponent", "real start taskId:" + this.n + " from:" + this.w);
        IAIChatAudioService.a.a(IAIChatAudioService.a, new c(this), new b(this), 7);
        IDocSdkBaseService r0 = (IDocSdkBaseService) this.o.getValue();
        if (r0 == null) goto L7;
        r r1 = r0.getVoiceInputService();
        if (r1 == null) goto L7;
        r1.startVoiceInput(new d(r6, this));
    L7:
        IDocSdkBaseService r7 = (IDocSdkBaseService) this.o.getValue();
        if (r7 == null) goto L10;
        int r8 = r7.getBottomWindowHeight(s1a.a.getActivity(this));
    L11:
        if (r8 == 0) goto L40;
        Unit r2 = null;
        if (this.q != null) goto L20;
        Object r3 = s1a.a.getActivity(this).getSystemService("window");
        if ((r3 instanceof WindowManager) == false) goto L18;
        WindowManager r4 = (WindowManager) r3;
    L19:
        this.r = r4;
        TouchInterceptingView r5 = new TouchInterceptingView(getContext(), null, 6, 0);
        r5.setEventHandler(new e(this));
        this.q = r5;
        goto L20
    L18:
        r4 = null;
    L20:
        TouchInterceptingView r9 = this.q;
        if (r9 == null) goto L23;
        ViewParent r10 = r9.getParent();
    L24:
        if (r10 == null) goto L37;
        L2();
    L37:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L31
        WindowManager r12 = this.r;     // Catch: Throwable -> L31
        if (r12 == null) goto L29;
        View r13 = this.q;     // Catch: Throwable -> L31
        WindowManager.LayoutParams r14 = new WindowManager.LayoutParams();     // Catch: Throwable -> L31
        r14.type = 2;     // Catch: Throwable -> L31
        r14.flags = 552;     // Catch: Throwable -> L31
        r14.format = -2;     // Catch: Throwable -> L31
        r14.gravity = 8388691;     // Catch: Throwable -> L31
        r14.width = -1;     // Catch: Throwable -> L31
        r14.height = r8;     // Catch: Throwable -> L31
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r13, r14);     // Catch: Throwable -> L31
        r12.addView(r13, r14);     // Catch: Throwable -> L31
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L31
    L29:
        Object r15 = Result.constructor-impl(r2);     // Catch: Throwable -> L31
    L33:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L39;
        FLogger.a.e("DocAudioComponent", "addWindowView failed throwable=" + r16 + ", message=" + r16.getMessage());
        return;
    L39:
        return;
    L31:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L23:
        r10 = null;
        goto L24
    L40:
        return;
    L10:
        r8 = 0;
        goto L11
    }

    public final void N2(String r7) {
        FLogger.a.i("DocAudioComponent", "stopAsr " + r7 + " taskId:" + this.n + " start:" + this.u);
        this.l.setValue(Boolean.FALSE);
        int r8 = p0.a;
        String r9 = p0.a(this.n);
        if (r9 != null) goto L5;
    L8:
        this.n = "";
        L2();
        this.u = 0;
        return;
    L5:
        if (this.u == 0) goto L7;
        this.v = System.currentTimeMillis() - this.u;
    L7:
        IAIChatAudioService.a.o(r9, true);
        goto L8
    }

    @Override // f39.g
    public final void Qe(boolean r10, @VoiceInputFrom String r11) {
        Intrinsics.checkNotNullParameter(r11, "from");
        FLogger r0 = FLogger.a;
        r0.i("DocAudioComponent", "enableVoiceInput, enable:" + r10 + ", from:" + r11);
        long r3 = SystemClock.elapsedRealtime();
        if ((r3 - this.p) >= 100) goto L7;
        r0.i("DocAudioComponent", "enableVoiceInput Current time: " + r3 + ", Last change time: " + this.p);
        return;
    L7:
        if (((Boolean) this.l.getValue()).booleanValue() != r10) goto L10;
        r0.i("DocAudioComponent", "enableVoiceInput Requested voice state (" + r10 + ") is same as current. Ignoring.");
        return;
    L10:
        this.p = r3;
        if (r10 == false) goto L60;
        this.w = r11;
        String r12 = m39.a.a;
        boolean r13 = this.s;
        Intrinsics.checkNotNullParameter(r11, "enterFrom");
        switch(r11.hashCode()) {
            case -438349707: goto L26;
            case 1495286259: goto L23;
            case 1845530137: goto L19;
            case 1852186250: goto L16;
            default: goto L29;
        };
    L29:
        String r1 = "";
    L30:
        m39.a.d = r1;
        int r14 = !Intrinsics.areEqual(r11, VoiceInputFrom.TOOL_BAR_LONG_PRESS) ? 1 : 0;
        String r2 = m39.a.a;
        String r4 = m39.a.b;
        Integer r5 = m39.a.c;
        if (r13 == false) goto L33;
        String r15 = "ai_doc_list";
    L34:
        String r6 = m39.a.d;
        Integer r7 = 1;
        Integer r16 = Integer.valueOf(r14);
        JSONObject r8 = new JSONObject();
        Intrinsics.checkNotNullParameter(r8, "params");
        if (r7 != null) goto L62;
    L39:
        if (r6 == null) goto L41;
        r8.put("click_from", r6);     // Catch: JSONException -> L37
    L41:
        if (r16 == null) goto L43;
        r8.put("is_handsfree_speak", r16.intValue());     // Catch: JSONException -> L37
    L43:
        if (r2 == null) goto L45;
        r8.put("page_token", r2);     // Catch: JSONException -> L37
    L45:
        if (r4 == null) goto L47;
        r8.put("artifact_meta_id", r4);     // Catch: JSONException -> L37
    L47:
        if (r5 == null) goto L49;
        r8.put("resource_type", r5.intValue());     // Catch: JSONException -> L37
    L49:
        r8.put("current_page", r15);     // Catch: JSONException -> L37
    L52:
        TrackParams r17 = new TrackParams().merge(r8);
        by7.a r18 = new by7.a("start_speak_input_click");
        r18.a.merge(r17);
        r18.b();
        final long r110 = System.currentTimeMillis();
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().n(false);
        IFlowTtsClientService.a.a().f("DocAudioComponent_startAsr");
        List r9 = CollectionsKt.mutableListOf(new String[]{"android.permission.RECORD_AUDIO"});
        AppHost.Companion r20 = AppHost.a;
        if (ContextCompat.checkSelfPermission(r20.getApplication(), "android.permission.RECORD_AUDIO") != 0) goto L55;
        F2(r110);
        return;
    L55:
        i2 r21 = i2.b;
        FragmentActivity r22 = r20.a().getCurrentActivity();
        if ((r22 instanceof FragmentActivity) == false) goto L58;
        FragmentActivity r23 = r22;
    L59:
        r21.a(r23, r9, new f39.b(this, r110));
        return;
    L58:
        r23 = null;
    L37:
        e = move-exception;
        FLogger.a.e("DocumentEventHelper", "error in DocumentEventHelper mobStartSpeakInputClick: " + e.getLocalizedMessage());
        goto L52
    L62:
        r8.put("is_ai_doc", r7.intValue());     // Catch: JSONException -> L37
        goto L39
    L33:
        r15 = "ai_doc_detail";
        goto L34
    L16:
        if (r11.equals(VoiceInputFrom.ACTION_BAR) == false) goto L29;
    L21:
        r1 = "action_bar_handsfree_button";
        goto L30
    L19:
        if (r11.equals(VoiceInputFrom.NEW_DOC) == true) goto L21;
    L23:
        if (r11.equals(VoiceInputFrom.TOOL_BAR_LONG_PRESS) == false) goto L29;
    L28:
        r1 = "tool_bar_handsfree_button";
        goto L30
    L26:
        if (r11.equals(VoiceInputFrom.TOOL_BAR_CLICK) == true) goto L28;
    L60:
        a4.a.getClass();
        a4.a(a4.b);
        N2(r11);
    }
}
