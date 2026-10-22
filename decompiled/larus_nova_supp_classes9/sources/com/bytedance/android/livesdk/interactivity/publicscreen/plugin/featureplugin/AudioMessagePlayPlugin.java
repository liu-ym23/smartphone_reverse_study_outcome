package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin;

import am2.x;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.message.r;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.PublicScreenContext;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.k;
import com.bytedance.android.livesdk.interactivity.api.l;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ShowArea;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.plugin.FeaturePluginType;
import com.bytedance.android.livesdk.interactivity.api.settings.config.s0;
import com.bytedance.android.livesdk.interactivity.api.textaudio.TextAudioManagerDummy;
import com.bytedance.android.livesdk.interactivity.textmessage.model.AudioChatTextMessage;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.j;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import u22.e;
import zg1.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002\n\u000fJ\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005R\u001a\u0010\u000e\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/plugin/featureplugin/AudioMessagePlayPlugin;", "Lcom/bytedance/android/livesdk/interactivity/api/k;", "Lt52/a$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lu22/e;", "e", BuildConfig.FLAVOR, "onEvent", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/plugin/FeaturePluginType;", "a", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/plugin/FeaturePluginType;", "getType", "()Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/plugin/FeaturePluginType;", "type", "b", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioMessagePlayPlugin implements k, t52.a.b, Observer<KVData> {
    public static final /* synthetic */ int i = 0;
    public final FeaturePluginType a;
    public final c b;
    public final boolean c;
    public final CompositeDisposable d;
    public boolean e;
    public t52.a f;
    public final PublicScreenContext g;
    public final DataCenter h;

    public static final class a {
    }

    public static final class b extends t52.a.C0282a {
        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "info");
            super(r2);
        }
    }

    public static final class c implements s42.b {
        public final /* synthetic */ AudioMessagePlayPlugin a;

        @Override // s42.b
        public final void f() {
        }

        @Override // s42.b
        public final void g() {
        }

        @Override // s42.b
        public final void h(f<?> r1) {
        }

        @Override // s42.b
        public final void m(f<?> r1) {
        }

        public c(AudioMessagePlayPlugin r1) {
            this.a = r1;
        }

        @Override // s42.b
        public final void a(t r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            Intrinsics.checkNotNullParameter(r2, "message");
        }

        @Override // s42.b
        public final void i(f<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            Intrinsics.checkNotNullParameter(r2, "message");
        }

        @Override // s42.b
        public final void j(f<?> r5, ShowArea r6) {
            Intrinsics.checkNotNullParameter(r5, "message");
            Intrinsics.checkNotNullParameter(r6, "showArea");
            if ((r5 instanceof AudioChatTextMessage) == true) goto L5;
            return;
        L5:
            if (r6 != ShowArea.Scroll) goto L44;
            f72.a.b("Receive Audio Message");
            AudioMessagePlayPlugin r7 = this.a;
            AudioChatTextMessage r8 = (AudioChatTextMessage) r5;
            if (r7.e == true) goto L49;
            t52.a r0 = r7.f;
            if (r0 == null) goto L15;
            if (r0.isPlaying() != true) goto L15;
            ALogger.i("AudioMessagePlayPlugin", "newAudioMessageReceived, audioManager.isPlaying() == true");
            return;
        L15:
            if (r7.c == false) goto L50;
            IRoom r1 = (IRoom) r7.h.get("data_room");
            if (r1 != null) goto L21;
            return;
        L21:
            if (r1.isThirdParty() == true) goto L52;
            DataCenter r2 = r7.h;
            Boolean r3 = Boolean.TRUE;
            if (((Boolean) r2.get("data_room_audio_comment_enable", r3)).booleanValue() == true) goto L26;
            return;
        L26:
            if (((Boolean) r7.h.get("data_room_audio_comment_auto_play", r3)).booleanValue() == false) goto L53;
            f72.a.b("Need Auto Play When Receive Message");
            t52.a r4 = r7.f;
            if (r4 != null) goto L31;
        L32:
            r r9 = r8.b;
            String r10 = null;
            if (r9 == null) goto L35;
            String r11 = r9.getAudioUrl();
        L37:
            if (TextUtils.isEmpty(r11) == true) goto L48;
            Application r13 = jc1.a.b();
            r r14 = r8.b;
            if (r14 == null) goto L41;
            r10 = r14.getAudioUrl();
        L41:
            r7.d(r13, r10);
            return;
        L48:
            return;
        L35:
            r11 = null;
            goto L37
        L31:
            if (r4.isPlaying() != true) goto L32;
            return;
        L53:
            return;
        L52:
            return;
        L50:
            return;
        L49:
            return;
        }
    }

    static {
    }

    @Override // v42.a
    public final void onLoad() {
    }

    @Override // v42.a
    public final void onUnload() {
    }

    public final void g() {
        f72.a.b("AudioMessagePresenter stopPlayAudio");
        ALogger.i("AudioMessagePlayPlugin", "stopPlayAudio");
        t52.a r0 = this.f;
        if (r0 == null) goto L6;
        r0.stopAudio();
        return;
    }

    @Override // v42.a
    public final void onDestroy() {
        this.g.removeMessageListener(this.b);
        this.d.clear();
        this.h.removeObserver(this);
        t52.a r0 = this.f;
        if (r0 == null) goto L6;
        r0.unregister(this);
        return;
    }

    @Override // v42.a
    public final void onInit() {
        this.h.observeForever("cmd_widget_loaded", this);
        this.g.addMessageListener(this.b);
        e(u22.d.class, new com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin.a(new AudioMessagePlayPlugin$registerEvents$1(this)));
        e(e.class, new com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin.a(new AudioMessagePlayPlugin$registerEvents$2(this)));
        e(s.class, new com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin.a(new AudioMessagePlayPlugin$registerEvents$3(this)));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.k, v42.a
    public FeaturePluginType getType() {
        return this.a;
    }

    @Override // t52.a.b
    public final void a(t52.a.C0282a r3) {
        Intrinsics.checkNotNullParameter(r3, "audioInfo");
        if ((r3 instanceof b) == false) goto L15;
        String r0 = r3.a;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L16;
        f72.a.b("AudioMessagePresenter Notify Audio Chat Play End");
        kc2.a r4 = kc2.d.a(((b) r3).a);
        r4.updateField = 2;
        r4.readStatus = 1;
        h(r4);
        return;
    L16:
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    }

    @Override // t52.a.b
    public final void b(final t52.a.C0282a r6) {
        Intrinsics.checkNotNullParameter(r6, "audioInfo");
        if ((r6 instanceof b) == false) goto L42;
        String r0 = r6.a;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L43;
        kc2.a r2 = kc2.d.a(((b) r6).a);
        r2.updateField = 2;
        r2.readStatus = 1;
        h(r2);
        if (this.e == false) goto L16;
        return;
    L16:
        t52.a r3 = this.f;
        if (r3 != null) goto L19;
    L21:
        l r4 = (l) this.g.getMessageLogicFacade().getValue();
        if (r4 == null) goto L24;
        int r7 = r4.z(new AudioMessagePlayPlugin$onPlayComplete$currentIndex$1(r6), new IntRange(-1, -1));
    L25:
        if (r7 != (-1)) goto L27;
        return;
    L27:
        l r5 = (l) this.g.getMessageLogicFacade().getValue();
        r r8 = null;
        if (r5 == null) goto L32;
        f<?> r9 = r5.t(AudioMessagePlayPlugin$onPlayComplete$nextAudioMessage$1.INSTANCE, new IntRange(r7, -1));
        if (r9 == null) goto L32;
        r r10 = r9.b;
    L34:
        if ((r10 instanceof r) == false) goto L37;
        r8 = r10;
    L37:
        r r11 = r8;
        if (r11 != null) goto L40;
        return;
    L40:
        f72.a.b("AudioMessagePresenter Auto Play Next Unread Message");
        d(jc1.a.b(), r11.getAudioUrl());
        return;
    L32:
        r10 = null;
        goto L34
    L24:
        r7 = -1;
        goto L25
    L19:
        if (r3.isPlaying() != true) goto L21;
        return;
    L43:
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    }

    @Override // t52.a.b
    public final void c(t52.a.C0282a r2) {
        Intrinsics.checkNotNullParameter(r2, "audioInfo");
        if ((r2 instanceof b) == false) goto L15;
        String r0 = r2.a;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L16;
        f72.a.b("AudioMessagePresenter Notify Audio Chat Play Start");
        kc2.a r3 = kc2.d.a(r2.a);
        r3.updateField = 2;
        r3.readStatus = 2;
        h(r3);
        return;
    L16:
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    }

    public final void h(final kc2.a r4) {
        l r0 = (l) this.g.getMessageLogicFacade().getValue();
        if (r0 == null) goto L5;
        f<?> r1 = r0.m(new AudioMessagePlayPlugin$tryUpdateAudioTextMessage$targetMsg$1(r4));
    L6:
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.interactivity.textmessage.utils.d.b(r4, r1);
        return;
    L9:
        l r2 = (l) this.g.getMessageLogicFacade().getValue();
        if (r2 == null) goto L13;
        r2.l(new AudioMessagePlayPlugin$tryUpdateAudioTextMessage$1(r4), new AudioMessagePlayPlugin$tryUpdateAudioTextMessage$2(r4));
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 == null) goto L29;
        String r7 = r6.getKey();
        if (r7.hashCode() == (-1836833765)) goto L8;
        return;
    L8:
        if (r7.equals("cmd_widget_loaded") == false) goto L30;
        IRoomContextService r8 = jc1.k.f(IRoomContextService.class);
        int r0 = t52.b.a;
        ViewModel r1 = null;
        if (r8 == null) goto L16;
        o r9 = IRoomContextService.a.a(r8, null, 0, 3);
        if (r9 == null) goto L16;
        j r10 = r9.L2();
        if (r10 == null) goto L16;
        ViewModel r11 = (ViewModel) r10.getValue();
    L18:
        if ((r11 instanceof t52.a) == false) goto L21;
        r1 = r11;
    L21:
        t52.a r2 = (t52.a) r1;
        if (r2 != null) goto L24;
        r2 = TextAudioManagerDummy.INSTANCE;
    L24:
        r2.register(this);
        if ((r2 instanceof TextAudioManagerDummy) == false) goto L27;
        s0 r13 = PublicScreenTraceMonitor.a;
        PublicScreenTraceMonitor.e("get dummy manager");
    L27:
        Unit r14 = Unit.INSTANCE;
        this.f = r2;
        ALogger.i("AudioMessagePlayPlugin", "widget loaded, audioManager is " + this.f);
        return;
    L16:
        r11 = null;
        goto L18
    L30:
        return;
    }

    public final void onEvent(e r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        g();
    }

    public AudioMessagePlayPlugin(PublicScreenContext r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.g = r3;
        this.h = r4;
        this.a = FeaturePluginType.AudioMessagePlay;
        this.b = new c(this);
        Boolean r5 = Boolean.FALSE;
        Object r1 = null;
        Object r6 = r4.get("data_is_anchor", null);
        if ((r6 instanceof Boolean) == false) goto L6;
        r1 = r6;
    L6:
        Boolean r2 = (Boolean) r1;
        if (r2 == null) goto L10;
        r5 = r2;
    L10:
        this.c = r5.booleanValue();
        this.d = new CompositeDisposable();
    }

    public final void d(Context r3, String r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r4 != null) goto L7;
        s0 r5 = PublicScreenTraceMonitor.a;
        PublicScreenTraceMonitor.e("audio url empty");
        return;
    L7:
        f72.a.b("AudioMessagePresenter playAudioUseUrl");
        t52.a r0 = this.f;
        if (r0 == null) goto L11;
        r0.playAudioByUrl(r3, new b(r4));
        return;
    }

    public final <T> void e(Class<T> r2, Consumer<T> r3) {
        com.bytedance.revenue.platform.api.core.rx.f.a(xs2.b.a().b(r2).subscribe(r3), this.d);
    }

    public final void f(long r4, String r6) {
        Boolean r0 = (Boolean) this.h.get("data_is_anchor", Boolean.FALSE);
        HashMap r1 = new HashMap();
        if (r0.booleanValue() == false) goto L5;
        String r2 = "anchor";
    L6:
        r1.put("user_type", r2);
        r1.put("duration", String.valueOf(r4));
        if (r6 != null) goto L9;
        r6 = BuildConfig.FLAVOR;
    L9:
        r1.put("prompt", r6);
        j0 r5 = j0.l();
        x r7 = new x();
        r7.b = "live_detail";
        r5.sendLog("livesdk_vocal_message_play", r1, new Object[]{r7, IRoom.class});
        return;
    L5:
        r2 = "audience";
        goto L6
    }
}
