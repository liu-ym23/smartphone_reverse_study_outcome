package com.larus.bmhome.tts;

import androidx.fragment.app.Fragment;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.audio.AudioServiceDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.tts.ITtsReaderInterceptor;
import com.larus.tts.TtsInterceptResult;
import com.larus.tts.TtsScene;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import f2a.c;
import f2a.d;
import f2a.f;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ry8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/tts/OnboardingTtsInterceptor;", "Lcom/larus/tts/ITtsReaderInterceptor;", "<init>", "()V", "logger", "Lcom/larus/utils/logger/FlowFormatLogger;", "priority", "", "canHandle", "", "message", "Lcom/larus/im/bean/message/Message;", "scene", "Lcom/larus/tts/TtsScene;", "intercept", "Lcom/larus/tts/TtsInterceptResult;", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OnboardingTtsInterceptor implements ITtsReaderInterceptor {
    public final d a;

    public static final class a {
    }

    static {
    }

    public final int priority() {
        return 10;
    }

    public OnboardingTtsInterceptor() {
        this.a = new d("Chat", "OnboardingTtsInterceptor");
    }

    public final boolean a(Message r2, TtsScene r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "scene");
        if (r3 != TtsScene.Auto_OnBoarding) goto L5;
        return true;
    L5:
        return false;
    }

    public final TtsInterceptResult b(Message r13, TtsScene r14) {
        Intrinsics.checkNotNullParameter(r13, "message");
        Intrinsics.checkNotNullParameter(r14, "scene");
        if (com.larus.bmhome.chat.bean.d.G0(r13) == false) goto L5;
    L20:
        boolean r15 = false;
    L21:
        String r9 = "";
        if (r15 == true) goto L30;
        c r16 = this.a.a("[TTS][NOT_TTS_ANSWER_OR_NOT] startTTS, tts can not Answer");
        r16.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r8 = new Pair[4];
        f r10 = f.i;
        String r11 = r13.getMessageId();
        if (r11 == null) goto L27;
        r9 = r11;
    L27:
        r8[0] = TuplesKt.to(r10, r9);
        r8[1] = TuplesKt.to(f.g, Integer.valueOf(r13.getContentType()));
        r8[2] = TuplesKt.to(new f("is_block_msg"), String.valueOf(com.larus.bmhome.chat.bean.d.k(r13)));
        r8[3] = TuplesKt.to(new f("tts_enable"), String.valueOf(com.larus.bmhome.chat.bean.d.Q(r13)));
        r16.d(MapsKt.mapOf(r8));
        c.c(r16, null, 15);
        return TtsInterceptResult.Deny;
    L30:
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L37;
        c r17 = this.a.a("[TTS][NO_INTERNET_NO_CACHE] startTTS, tts can not Answer");
        r17.c.b = CollectionsKt.listOf("TtsPlay");
        Pair[] r12 = new Pair[4];
        f r18 = f.i;
        String r19 = r13.getMessageId();
        if (r19 == null) goto L35;
        r9 = r19;
    L35:
        r12[0] = TuplesKt.to(r18, r9);
        r12[1] = TuplesKt.to(f.g, Integer.valueOf(r13.getContentType()));
        r12[2] = TuplesKt.to(new f("is_block_msg"), String.valueOf(com.larus.bmhome.chat.bean.d.k(r13)));
        r12[3] = TuplesKt.to(new f("tts_enable"), String.valueOf(com.larus.bmhome.chat.bean.d.Q(r13)));
        r17.d(MapsKt.mapOf(r12));
        c.c(r17, null, 15);
        return TtsInterceptResult.Deny;
    L37:
        AudioServiceDelegate r110 = AudioServiceDelegate.a;
        if (r110.q0() == false) goto L46;
        c r111 = this.a.a("[TTS][AUTO_PLAY_HARD_DOWNGRADE] startTTS isAutoPlayHardDowngrade");
        r111.c.b = CollectionsKt.listOf("TtsPlay");
        f r0 = f.i;
        String r112 = r13.getMessageId();
        if (r112 == null) goto L43;
        r9 = r112;
    L43:
        r111.d(MapsKt.mapOf(TuplesKt.to(r0, r9)));
        c.c(r111, null, 15);
        return TtsInterceptResult.Deny;
    L46:
        if (r110.D() == false) goto L54;
        c r113 = this.a.a("[TTS][AUTO_PLAY_SOFT_DOWNGRADE] startTTS isAutoPlaySoftDowngrade");
        r113.c.b = CollectionsKt.listOf("TtsPlay");
        f r1 = f.i;
        String r114 = r13.getMessageId();
        if (r114 == null) goto L51;
        r9 = r114;
    L51:
        r113.d(MapsKt.mapOf(TuplesKt.to(r1, r9)));
        c.c(r113, null, 15);
        return TtsInterceptResult.Deny;
    L54:
        return TtsInterceptResult.Pass;
    L5:
        if (r13.getContentType() == 1) goto L9;
        if (r13.getContentType() != 9999) goto L20;
    L9:
        if (com.larus.bmhome.chat.bean.d.Q(r13) == false) goto L20;
        IFlowSdkDepend r115 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r115 == null) goto L17;
        r115.P();
        Fragment r116 = ChatServiceImpl.a.f();
        if (r116 == null) goto L17;
        b r117 = s1a.a.g(r116).getAbility(b.class);
        if (r117 == null) goto L17;
        boolean r118 = Intrinsics.areEqual(r117.L9(), Boolean.TRUE);
    L18:
        if (r118 == false) goto L20;
        r15 = true;
    L17:
        r118 = false;
        goto L18
    }
}
