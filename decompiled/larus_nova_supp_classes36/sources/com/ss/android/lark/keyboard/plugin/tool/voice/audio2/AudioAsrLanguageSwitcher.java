package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.f0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.audio.recorder.AudioRecordSettings;
import com.ss.android.lark.audio.voiceinput.t;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceHitPoint;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.IconWithTitleItemId;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.ItemType;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.SendType;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.SwitchActionItemId;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.VoiceMoreActionAdapter;
import com.ss.android.lark.keyboard.plugin.tool.voice.utils.AudioChooseLanguageDialogAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.recognition.GetSpeechConfigRequest;
import com.ss.android.lark.pb.recognition.PutSpeechConfigRequest;
import com.ss.android.lark.pb.recognition.PutSpeechConfigResponse;
import com.ss.android.lark.pb.recognition.SpeechLang;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import rob.j;
import rob.k;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class AudioAsrLanguageSwitcher {
    public static int i;
    public final Lazy a;
    public final List<String> b;
    public final List<String> c;
    public final List<b> d;
    public String e;
    public String f;
    public final Lazy g;
    public UDDialog h;

    public static final class a {
        public static String a() {
            String r0 = com.ss.android.lark.im.base.a.a().getString("user_audio_2_text_locale_server_key", null);
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L12;
            return "un_auto";
        L12:
            return r0;
        L5:
            if (r0.length() == 0) goto L8;
            r1 = false;
            goto L9
        }
    }

    public interface b {
        void a(j r1);

        void b(rob.e r1);

        void c(String r1, String r2, boolean r3);

        void d(SendType r1);
    }

    public static final class c {
        public String a;
        public List<SpeechLang> b;
        public final List<String> c;
        public final List<String> d;
        public final Boolean e;

        public c() {
            this(null, null, null, null, null, 31);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            List<SpeechLang> r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            List<String> r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            List<String> r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            Boolean r13 = this.e;
            if (r13 == null) goto L23;
            r1 = r13.hashCode();
        L23:
            return r12 + r1;
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "SpeechConfig(chosenLangKey=" + this.a + ", supportLanguageList=" + this.b + ", defaultLangKeyList=" + this.c + ", defaultLangNameList=" + this.d + ", enableFormat=" + this.e + ')';
        }

        public c(String r3, List r4, List r5, List r6, Boolean r7, int r8) {
            if ((r8 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r8 & 2) == 0) goto L9;
            r4 = null;
        L9:
            if ((r8 & 4) == 0) goto L12;
            r5 = null;
        L12:
            if ((r8 & 8) == 0) goto L15;
            r6 = null;
        L15:
            if ((r8 & 16) == 0) goto L17;
            r7 = null;
        L17:
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
        }
    }

    public static final class d<T> implements SdkSender.IParser {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object parse(byte[] r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            PutSpeechConfigResponse.ADAPTER.decode(r2);
            return Boolean.TRUE;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ AudioAsrLanguageSwitcher a;

        public e(AudioAsrLanguageSwitcher r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.b();
        }
    }

    public static final class f implements rob.d {
        public final /* synthetic */ AudioAsrLanguageSwitcher a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[SendType.values().length];
                r0[SendType.VoiceWithAsr.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[SendType.OnlyText.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public f(AudioAsrLanguageSwitcher r1) {
            this.a = r1;
        }

        @Override // rob.d
        public final void a(rob.e r3) {
            Intrinsics.checkNotNullParameter(r3, "item");
            Iterator<T> r0 = this.a.d.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((b) r0.next()).b(r3);
            goto L4
        L6:
            this.a.b();
        }

        @Override // rob.d
        public final void b(SendType r4) {
            Intrinsics.checkNotNullParameter(r4, "sendType");
            int r0 = a.a[r4.ordinal()];
            if (r0 != 1) goto L5;
            t.b().putBoolean("key_support_voice_with_asr", true);
        L10:
            Iterator r1 = ((ArrayList) this.a.d).iterator();
        L12:
            if (r1.hasNext() == false) goto L14;
            ((b) r1.next()).d(r4);
            goto L12
        L14:
            this.a.b();
            return;
        L5:
            if (r0 != 2) goto L8;
            t.b().putBoolean("key_support_voice_with_asr", false);
            goto L10
        L8:
            throw new NoWhenBranchMatchedException();
        }

        @Override // rob.d
        public final void c(j r5) {
            Intrinsics.checkNotNullParameter(r5, "item");
            if (r5.d != SwitchActionItemId.PolishVoiceInput) goto L8;
            boolean r0 = !r5.c;
            Map<String, Integer> r2 = com.ss.android.lark.keyboard.plugin.tool.voice.utils.b.a;
            if (KeyboardVoiceFGUtils.a("im.messenger.voice_input_polish", null) == false) goto L8;
            LarkKVStorage.q(com.ss.android.lark.im.base.a.a, true).putBoolean("user_voice_input_polish_enabled_local_key", r0);
        L8:
            Iterator r1 = ((ArrayList) this.a.d).iterator();
        L10:
            if (r1.hasNext() == false) goto L12;
            ((b) r1.next()).a(r5);
            goto L10
        }

        @Override // rob.d
        public final void d(rob.b r4) {
            Intrinsics.checkNotNullParameter(r4, "curChoseAsrItem");
            List<SpeechLang> r0 = this.a.c().b;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L19;
            int r2 = r4.a;
            if (r2 == 0) goto L18;
            if (r2 != 1) goto L14;
            com.ss.android.lark.keyboard.plugin.tool.voice.utils.b.c("zh_ch");
            goto L19
        L14:
            if (r2 != 2) goto L19;
            com.ss.android.lark.keyboard.plugin.tool.voice.utils.b.c("en_us");
            goto L19
        L18:
            com.ss.android.lark.keyboard.plugin.tool.voice.utils.b.c("un_auto");
        L19:
            String r3 = r4.b;
            if (r3 == null) goto L26;
            String r5 = r4.c;
            if (r5 == null) goto L26;
            String r6 = r4.d;
            if (r6 == null) goto L26;
            AudioAsrLanguageSwitcher.a(this.a, r3, r5, r6);
            return;
        L26:
            Log.e("AudioAsrLanguageSwitcher", "invalid params chosenLanguageKey:" + r4.b + ", languageKey:" + r4.c + ", languageName:" + r4.d);
            return;
        L5:
            if (r0.isEmpty() == true) goto L8;
            r1 = false;
            goto L9
        }
    }

    public static final class g implements AudioChooseLanguageDialogAdapter.a {
        public final /* synthetic */ AudioAsrLanguageSwitcher a;

        public g(AudioAsrLanguageSwitcher r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.utils.AudioChooseLanguageDialogAdapter.a
        public final void j4(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "beforeLang");
            Intrinsics.checkNotNullParameter(r3, "newLangKey");
            Intrinsics.checkNotNullParameter(r4, "newLangName");
            AudioAsrLanguageSwitcher.a(this.a, r2, r3, r4);
        }
    }

    static {
        i = 1;
    }

    public final void b() {
        UDDialog r0 = this.h;
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
    L21:
        this.h = null;
    }

    public final c c() {
        return (c) this.g.getValue();
    }

    public final void d() {
        final IGetDataCallback<c> r0 = new AudioAsrLanguageSwitcher$pullSpeechConfig$1(this);
        GetSpeechConfigRequest.Builder r1 = new GetSpeechConfigRequest.Builder();
        SdkSender.sendPassThroughRequest(Command.GET_SPEECH_CONFIG, r1, new AudioAsrLanguageSwitcher$getSpeechConfig$1(r0), com.ss.android.lark.keyboard.plugin.tool.voice.audio2.a.a);
    }

    public AudioAsrLanguageSwitcher(final Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Lazy r5 = LazyKt.lazy(new AudioAsrLanguageSwitcher$defaultAsrLangName$2(r4));
        this.a = r5;
        this.b = CollectionsKt.listOf(new String[]{"un_auto", "zh_ch", "en_us"});
        this.c = CollectionsKt.listOf(new String[]{(String) r5.getValue(), UIHelper.getString(2131890345), UIHelper.getString(2131890346)});
        this.d = new ArrayList();
        this.e = a.a();
        String r0 = com.ss.android.lark.im.base.a.a().getString("user_audio_2_text_locale_server_name", null);
        if (r0 != null) goto L5;
        r0 = (String) r5.getValue();
    L5:
        this.f = r0;
        this.g = LazyKt.lazy(new AudioAsrLanguageSwitcher$mConfig$2(this));
        d();
    }

    public final void g(String r3) {
        this.e = r3;
        c().a = r3;
        com.ss.android.lark.im.base.a.a().putString("user_audio_2_text_locale_server_key", r3);
    }

    public final void h(String r3) {
        this.f = r3;
        com.ss.android.lark.im.base.a.a().putString("user_audio_2_text_locale_server_name", r3);
    }

    public static /* synthetic */ void f(AudioAsrLanguageSwitcher r2, String r3) {
        AudioAsrLanguageSwitcher$putSpeechConfig$1 r0 = AudioAsrLanguageSwitcher$putSpeechConfig$1.INSTANCE;
        AudioAsrLanguageSwitcher$putSpeechConfig$2 r1 = AudioAsrLanguageSwitcher$putSpeechConfig$2.INSTANCE;
        r2.getClass();
        e(r3, null, r0, r1);
    }

    public static final void a(AudioAsrLanguageSwitcher r4, String r5, String r6, String r7) {
        if (Intrinsics.areEqual(r4.e, r6) == false) goto L8;
        if (Intrinsics.areEqual(r4.f, r7) == false) goto L8;
        Log.i("AudioAsrLanguageSwitcher", "showSwitchLanguageDialog / User select the current option again");
        return;
    L8:
        if (StringUtils.isEmpty(r6) == true) goto L14;
        Log.i("AudioAsrLanguageSwitcher", "showSwitchLanguageDialog / User switch language, name = " + r7);
        r4.g(r6);
        r4.h(r7);
        f(r4, r4.e);
        Iterator r8 = ((ArrayList) r4.d).iterator();
    L11:
        if (r8.hasNext() == false) goto L13;
        ((b) r8.next()).c(r4.f, r4.e, false);
        goto L11
    L13:
        int r9 = KeyboardVoiceHitPoint.a;
        Intrinsics.checkNotNullParameter(r5, "beforeLang");
        Intrinsics.checkNotNullParameter(r6, "newLang");
        Log.i("KeyboardVoiceHitPoint", "sendSwitchLanguageEventNew / beforeLang = " + r5 + ", newLang = " + r6);
        Statistics.sendEvent("im_voice_switch_languae_click", s5c.d.b.b(z5c.h.c.a(r5), r.c3.a(r6)).toJson());
        r4.b();
        return;
    L14:
        Log.w("AudioAsrLanguageSwitcher", "showSwitchLanguageDialog / User select key is empty");
    }

    public static void e(String r3, Boolean r4, final Function0 r5, final Function0 r6) {
        if (f0.a(r3) == false) goto L5;
        return;
    L5:
        PutSpeechConfigRequest.Builder r0 = new PutSpeechConfigRequest.Builder();
        int r1 = i;
        i = r1 + 1;
        r0.request_no(String.valueOf(r1)).manual_conf_lang(r3.toLowerCase(Locale.ROOT));
        if (r4 == null) goto L8;
        r0.enable_format(Boolean.valueOf(r4.booleanValue()));
    L8:
        r0.build();
        SdkSender.sendPassThroughRequest(Command.PUT_SPEECH_CONFIG, r0, new AudioAsrLanguageSwitcher$putSpeechConfig$4(r5, r6), d.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.util.List] */
    public final void i(Context r20, boolean r21, boolean r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r20, "context");
        View r2 = LayoutInflater.from(r20).inflate(2131563272, null);
        RecyclerView r3 = r2.findViewById(2131384972);
        r2.findViewById(2131376031).setOnClickListener(new e(this));
        LinearLayoutManager r5 = new LinearLayoutManager(r20, 1, false);
        c r8 = c();
        List<SpeechLang> r9 = r8.b;
        if (r9 != null) goto L5;
        r9 = new ArrayList();
    L5:
        r8.b = r9;
        String r10 = r8.a;
        if (r10 != null) goto L8;
        r10 = "";
    L8:
        r8.a = r10;
        if (r21 == false) goto L67;
        r2.findViewById(2131391606).setText(y9c.d.h(2131890965));
        com.ss.android.lark.storage.kv.repo.a r11 = t.b();
        if (r11.contains("key_support_voice_with_asr") == false) goto L13;
        boolean r12 = r11.getBoolean("key_support_voice_with_asr", false);
    L17:
        VoiceMoreActionAdapter r13 = new VoiceMoreActionAdapter();
        if (r22 == false) goto L22;
        r13.y2(new rob.c(y9c.d.h(2131890981)));
        r13.y2(new rob.h(new rob.i(SendType.OnlyText, y9c.d.h(2131890980), !r12)));
        r13.y2(new rob.h(new rob.i(SendType.VoiceWithAsr, y9c.d.h(2131890979), r12)));
        if (KeyboardVoiceFGUtils.a("im.messenger.voice_submit_feedback", null) == false) goto L22;
        r13.y2(new rob.g(ItemType.Divider, new Object()));
    L22:
        r13.y2(new rob.c(y9c.d.h(2131890975)));
        List<SpeechLang> r14 = c().b;
        List<String> r15 = c().c;
        List<String> r16 = c().d;
        String r17 = c().a;
        if (r17 != null) goto L25;
        r17 = "un_auto";
    L25:
        ?? r18 = new ArrayList();
        if (r14 == null) goto L31;
        Iterator r19 = r14.iterator();
        int r110 = 0;
    L29:
        if (r19.hasNext() == false) goto L33;
        SpeechLang r7 = (SpeechLang) r19.next();
        r18.add(new rob.a(new rob.b(r110, r17, r7.mlangCode, r7.mlangName)));
        r19 = r19;
        r110 = r110 + 1;
    L33:
        if ((!r18.isEmpty()) == true) goto L42;
        if (r15 == null) goto L41;
        if (r16 == null) goto L41;
        int r4 = Math.min(r15.size(), r16.size());
        int r6 = 0;
    L39:
        if (r6 >= r4) goto L42;
        r18.add(new rob.a(new rob.b(r110, r17, (String) ListProtector.get(r15, r6), (String) ListProtector.get(r16, r6))));
        r6 = r6 + 1;
        r4 = r4;
        r15 = r15;
        r110 = r110 + 1;
    L41:
        r18 = CollectionsKt.emptyList();
    L42:
        Iterator r24 = ((Iterable) r18).iterator();
    L44:
        if (r24.hasNext() == false) goto L46;
        r13.y2((rob.a) r24.next());
        goto L44
    L46:
        KeyboardVoiceFGUtils r25 = KeyboardVoiceFGUtils.a;
        boolean r26 = true;
        if (AudioRecordSettings.d().getAudioNewCanRevert() != 1) goto L49;
        boolean r27 = true;
    L50:
        if (r27 == false) goto L53;
        if (r23 == false) goto L53;
    L55:
        if (KeyboardVoiceFGUtils.a("im.messenger.voice_submit_feedback", null) == true) goto L57;
        if (r26 == true) goto L57;
    L59:
        if (KeyboardVoiceFGUtils.a("im.messenger.voice_input_polish", null) == false) goto L62;
        r13.y2(new k(new j(y9c.d.h(2131891436), com.ss.android.lark.keyboard.plugin.tool.voice.utils.b.b(), SwitchActionItemId.PolishVoiceInput)));
        r13.y2(new rob.g(ItemType.Divider, new Object()));
    L62:
        if (KeyboardVoiceFGUtils.a("im.messenger.voice_submit_feedback", null) == false) goto L64;
        r13.y2(new rob.f(new rob.e(2131254352, y9c.d.h(2131891439), IconWithTitleItemId.SubmitFeedback)));
    L64:
        if (r26 == false) goto L66;
        r13.y2(new rob.f(new rob.e(2131255872, y9c.d.h(2131891314), IconWithTitleItemId.RollBackAudio)));
    L66:
        f r28 = new f(this);
        Intrinsics.checkNotNullParameter(r28, "listener");
        r13.b = r28;
        RecyclerView.Adapter r29 = r13;
    L68:
        r3.setAdapter(r29);
        r3.setLayoutManager(r5);
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget.a r30 = new com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget.a(r20);
        r30.a = r2;
        UDDialog r1 = new UDActionPanelBuilder(r20).controller(r30).marginInDp(0).build();
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L76;
        DialogLancet.handleBlockedDialogShow(r1);
    L73:
        this.h = r1;
        return;
    L76:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L75
    L72:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    L57:
        r13.y2(new rob.g(ItemType.Divider, new Object()));
    L53:
        r26 = false;
        goto L55
    L49:
        r27 = false;
        goto L50
    L31:
        r110 = 0;
        goto L33
    L13:
        KeyboardVoiceFGUtils r31 = KeyboardVoiceFGUtils.a;
        if (AudioRecordSettings.d().getAudioUpdateRecordText() != 1) goto L16;
        r12 = true;
        goto L17
    L16:
        r12 = false;
        goto L17
    L67:
        AudioChooseLanguageDialogAdapter r32 = new AudioChooseLanguageDialogAdapter(c().b, c().c, c().d, c().a);
        g r33 = new g(this);
        Intrinsics.checkNotNullParameter(r33, "l");
        r32.e = r33;
        r29 = r32;
        goto L68
    }
}
