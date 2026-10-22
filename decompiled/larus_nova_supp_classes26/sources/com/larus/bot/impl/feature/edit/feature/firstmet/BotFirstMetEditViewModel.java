package com.larus.bot.impl.feature.edit.feature.firstmet;

import androidx.lifecycle.Lifecycle;
import com.google.gson.Gson;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bot.impl.bean.BotEditParam;
import com.larus.im.bean.bot.FirstMet;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.service.AccountService;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class BotFirstMetEditViewModel implements q, o {
    public static final /* synthetic */ int r = 0;
    public final /* synthetic */ o a;
    public final CoroutineScope b;
    public final StateFlowImpl c;
    public final b1 d;
    public final MutableSharedFlow<m> e;
    public final a1 f;
    public final MutableSharedFlow<Unit> g;
    public final MutableSharedFlow<m> h;
    public boolean i;
    public boolean j;
    public boolean k;
    public String l;
    public Triple<String, String, String> m;
    public String n;
    public Boolean o;
    public Triple<String, String, String> p;
    public boolean q;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            r0[Lifecycle.Event.ON_STOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[Lifecycle.Event.ON_RESUME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L6:
            a = r0;
            int[] r1 = new int[PlayStateEnum.values().length];
            r1[PlayStateEnum.PLAY_STATE_STOPPED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L33:
            r1[PlayStateEnum.PLAY_STATE_PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L27:
            r1[PlayStateEnum.PLAY_STATE_PREPARE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L29:
            r1[PlayStateEnum.PLAY_STATE_PLAYING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L21:
            r1[PlayStateEnum.PLAY_STATE_FAIL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L12:
            b = r1;
        }
    }

    static {
    }

    @Override // com.larus.bot.impl.feature.edit.feature.firstmet.o
    public final BotEditParam a() {
        return this.a.a();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.firstmet.o
    public final void b(boolean r2) {
        this.a.b(r2);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.firstmet.o
    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "prologue");
        this.a.c(r2);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.firstmet.o
    public final boolean d() {
        return this.a.d();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.firstmet.o
    public final void e(Triple<String, String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "suggests");
        this.a.e(r2);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.firstmet.o
    public final int getScene() {
        return this.a.getScene();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.firstmet.q
    public final void onBackPage() {
        h(this, false, 1, false, null, false, false, 251);
        i(m.e.a);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.firstmet.q
    public final void onCreateSuccess() {
        this.q = true;
    }

    @Override // com.larus.bot.impl.feature.edit.feature.firstmet.q
    public final boolean Fk() {
        if (((n) this.d.getValue()).a == true) goto L5;
        return false;
    L5:
        if (this.l == null) goto L17;
        String r0 = a().getPrologue();
        String r2 = "";
        if (r0 != null) goto L9;
        r0 = "";
    L9:
        String r1 = StringsKt.trim(r0).toString();
        String r3 = this.l;
        if (r3 == null) goto L14;
        r2 = r3;
    L14:
        if (Intrinsics.areEqual(r1, StringsKt.trim(r2).toString()) == true) goto L17;
        return true;
    L17:
        if (((n) this.d.getValue()).d == false) goto L29;
        Triple<String, String, String> r4 = this.m;
        if (r4 != null) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(StringsKt.trim((String) r4.getFirst()).toString(), StringsKt.trim((String) k.b(a().getSuggests()).getFirst()).toString()) == true) goto L23;
    L26:
        return true;
    L23:
        if (Intrinsics.areEqual(StringsKt.trim((String) k.b(this.m).getSecond()).toString(), StringsKt.trim((String) k.b(a().getSuggests()).getSecond()).toString()) == false) goto L26;
        if (Intrinsics.areEqual(StringsKt.trim((String) k.b(this.m).getThird()).toString(), StringsKt.trim((String) k.b(a().getSuggests()).getThird()).toString()) == false) goto L26;
        return false;
    L29:
        return false;
    }

    @Override // com.larus.bot.impl.feature.edit.feature.firstmet.q
    public final void ej() {
        if (this.i == true) goto L5;
        return;
    L5:
        if (f() == false) goto L7;
    L9:
        this.i = false;
        return;
    L7:
        if (g() == false) goto L9;
        h(this, false, 2, false, null, false, false, 251);
        BuildersKt.launch$default(this.b, null, null, new BotFirstMetEditViewModel$autoPlayTts$1(this, null), 3, null);
        goto L9
    }

    @Override // com.larus.bot.impl.feature.edit.feature.firstmet.q
    public final FirstMet getFirstMetData() {
        String r1 = a().getPrologue();
        Integer r2 = null;
        if (r1 == null) goto L5;
        String r3 = StringsKt.trim(r1).toString();
    L6:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        Boolean r4 = a().getSuggestSwitch();
        if (r4 == null) goto L11;
        boolean r5 = r4.booleanValue();
    L12:
        Boolean r6 = Boolean.valueOf(r5);
        Triple<String, String, String> r7 = a().getSuggests();
        if (r7 == null) goto L15;
        List<String> r8 = k.c(r7);
    L16:
        if (r8 != null) goto L18;
        r8 = CollectionsKt.emptyList();
    L18:
        FirstMet r0 = new FirstMet(r3, r6, r8);
        FLogger r9 = FLogger.a;
        StringBuilder r10 = new StringBuilder("getFirstMetData-\nprologue: ");
        String r11 = r0.getPrologue();
        if (r11 == null) goto L21;
        Integer r12 = Integer.valueOf(r11.length());
    L22:
        r10.append(r12);
        r10.append("\nsuggests: ");
        List r13 = r0.getSuggests();
        if (r13 == null) goto L25;
        r2 = Integer.valueOf(r13.size());
    L25:
        r10.append(r2);
        r9.i("BotFirstMetEditViewModel", r10.toString());
        return r0;
    L21:
        r12 = null;
        goto L22
    L15:
        r8 = null;
        goto L16
    L11:
        r5 = true;
        goto L12
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.bot.impl.feature.edit.feature.firstmet.q
    public final boolean y7() {
        String r0 = this.n;
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = a().getPrologue();
        if (r2 == null) goto L10;
        r1 = r2;
    L10:
        if (Intrinsics.areEqual(r0, r1) == true) goto L12;
    L17:
        return true;
    L12:
        if (Intrinsics.areEqual(this.o, a().getSuggestSwitch()) == false) goto L17;
        if (Intrinsics.areEqual(k.b(this.p), k.b(a().getSuggests())) == false) goto L17;
        return false;
    }

    public final boolean f() {
        String r0 = a().getPrologue();
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        return false;
    }

    public final boolean g() {
        SpeakerVoice r0 = a().getVoice();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getId();
    L7:
        if (o0.d(r2) == false) goto L14;
        SpeakerVoice r3 = a().getVoice();
        if (r3 == null) goto L12;
        r1 = r3.getId();
    L12:
        if (Intrinsics.areEqual(r1, TriggerSendLoading.NO_LOADING) == true) goto L14;
        return true;
    L14:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    @Override // uu8.b
    public final d1<m> getUiEvent() {
        return this.f;
    }

    @Override // uu8.b
    public final i1<n> getUiState() {
        return this.d;
    }

    @Override // com.larus.bot.impl.feature.edit.feature.firstmet.q
    public final void F9(String r4) {
        if (((n) this.d.getValue()).a == true) goto L5;
        return;
    L5:
        if (this.j == false) goto L19;
        this.l = r4;
        if (r4 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
        FLogger.a.e("BotFirstMetEditViewModel", "generated empty prologue");
    L16:
        this.j = false;
        return;
    L15:
        c(r4);
        i(new m.b(r4, true));
        goto L16
    L9:
        if (StringsKt.isBlank(r4) == true) goto L12;
        r2 = false;
        goto L13
    }

    @Override // com.larus.bot.impl.feature.edit.feature.firstmet.q
    public final void Ma(List<String> r10) {
        if (((n) this.d.getValue()).a == true) goto L5;
        return;
    L5:
        if (this.k == true) goto L7;
        return;
    L7:
        if (((n) this.d.getValue()).d == false) goto L12;
        Triple<String, String, String> r5 = k.d(r10);
        this.m = r5;
        if (k.a(r5) == false) goto L11;
        FLogger.a.e("BotFirstMetEditViewModel", "generated empty suggests");
        goto L12
    L11:
        e(r5);
        h(this, false, 0, false, r5, false, false, 223);
    L12:
        this.k = false;
    }

    @Override // uu8.b
    public final void dispatchUIAction(l r18) {
        l r0 = r18;
        Intrinsics.checkNotNullParameter(r0, "action");
        boolean r4 = true;
        if ((r0 instanceof l.d) == false) goto L22;
        PlayStateEnum r1 = ((l.d) r0).a;
        if (r1 != null) goto L7;
        int r2 = -1;
    L8:
        if (r2 == (-1)) goto L150;
        if (r2 == 1) goto L21;
        if (r2 == 2) goto L21;
        if (r2 != 3) goto L13;
        h(this, false, 2, false, null, false, false, 251);
        return;
    L13:
        if (r2 != 4) goto L15;
        h(this, false, 3, false, null, false, false, 251);
        return;
    L15:
        if (r2 != 5) goto L18;
        h(this, false, 1, false, null, false, false, 251);
        i(new m.c());
        return;
    L18:
        throw new NoWhenBranchMatchedException();
    L21:
        h(this, false, 1, false, null, false, false, 251);
        return;
    L150:
        return;
    L7:
        r2 = b.b[r1.ordinal()];
        goto L8
    L22:
        Triple<String, String, String> r10 = null;
        if (Intrinsics.areEqual(r0, l.a.a) == false) goto L35;
        int r3 = ((n) this.d.getValue()).c;
        if (r3 == 1) goto L31;
        if (r3 == 2) goto L29;
        if (r3 == 3) goto L29;
        Unit r5 = Unit.INSTANCE;
        return;
    L29:
        h(this, false, 1, false, null, false, false, 251);
        BuildersKt.launch$default(this.b, null, null, new BotFirstMetEditViewModel$onClickTts$1(this, null), 3, null);
        return;
    L31:
        if (g() == false) goto L33;
        h(this, false, 2, false, null, false, false, 251);
        BuildersKt.launch$default(this.b, null, null, new BotFirstMetEditViewModel$onClickTts$2(this, null), 3, null);
        return;
    L33:
        BuildersKt.launch$default(this.b, Dispatchers.getMain().getImmediate(), null, new BotFirstMetEditViewModel$onClickTts$3(this, null), 2, null);
        return;
    L35:
        if ((r0 instanceof l.e) == false) goto L48;
        c(((l.e) r0).a);
        if (((n) this.d.getValue()).b == true) goto L40;
        return;
    L40:
        if (f() == false) goto L45;
        if (((n) this.d.getValue()).c != 1) goto L45;
        h(this, false, 0, false, null, false, false, 251);
        return;
    L45:
        if (((n) this.d.getValue()).c != 0) goto L160;
        h(this, false, 1, false, null, false, false, 251);
        return;
    L160:
        return;
    L48:
        if ((r0 instanceof l.g) == false) goto L51;
        h(this, ((l.g) r0).a, 0, false, null, false, false, 253);
        return;
    L51:
        if ((r0 instanceof l.c) == false) goto L61;
        int r6 = b.a[((l.c) r0).a.ordinal()];
        if (r6 == 1) goto L58;
        if (r6 != 2) goto L172;
        this.q = false;
        return;
    L172:
        return;
    L58:
        if (this.q == true) goto L164;
        BuildersKt.launch$default(this.b, null, null, new BotFirstMetEditViewModel$onLifecycleChange$1(this, null), 3, null);
        return;
    L164:
        return;
    L61:
        if ((r0 instanceof l.f) == false) goto L67;
        l.f r7 = (l.f) r0;
        Boolean r8 = r7.a;
        Triple<String, String, String> r9 = r7.b;
        if (r8 == null) goto L65;
        boolean r11 = r8.booleanValue();
        b(r11);
        h(this, false, 0, r11, null, false, false, 239);
    L65:
        if (r9 == null) goto L166;
        e(r9);
        h(this, false, 0, false, r9, false, false, 223);
        return;
    L166:
        return;
    L67:
        String r12 = "";
        if (Intrinsics.areEqual(r0, l.h.a) == false) goto L86;
        if (((n) this.d.getValue()).a == false) goto L168;
        String r13 = a().getPrologue();
        if (r13 == null) goto L75;
        r12 = r13;
    L75:
        i(new m.b(r12, false));
        if (((n) this.d.getValue()).d == false) goto L169;
        Boolean r14 = a().getSuggestSwitch();
        if (r14 == null) goto L80;
        boolean r15 = r14.booleanValue();
    L81:
        boolean r16 = r15;
        Triple<String, String, String> r17 = a().getSuggests();
        if (r17 != null) goto L84;
        r17 = ((n) this.d.getValue()).f;
    L84:
        h(this, false, 0, r16, r17, false, false, 207);
        return;
    L80:
        r15 = ((n) this.d.getValue()).e;
        goto L81
    L169:
        return;
    L168:
        return;
    L86:
        if ((r0 instanceof l.b) == false) goto L147;
        l.b r19 = (l.b) r0;
        tu8.a.a.getClass();
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L93
        String r21 = tu8.a.b.getString("key_create_bot_first_met", null);     // Catch: Throwable -> L93
        if (r21 == null) goto L92;
        FirstMet r22 = (FirstMet) new Gson().fromJson(r21, FirstMet.class);     // Catch: Throwable -> L93
    L98:
        if (r22 == null) goto L128;
        if (AccountService.a.isLogin().booleanValue() == false) goto L128;
        String r23 = a().getPrologue();
        if (r23 != null) goto L104;
    L107:
        if (r4 == false) goto L128;
        if (k.a(a().getSuggests()) == false) goto L128;
        if (getScene() != 0) goto L128;
        if (((n) this.d.getValue()).a == false) goto L120;
        String r24 = r22.getPrologue();
        if (r24 == null) goto L118;
        r12 = r24;
    L118:
        c(r12);
    L120:
        if (((n) this.d.getValue()).d == false) goto L126;
        Boolean r25 = r22.getSuggestSwitch();
        if (r25 == null) goto L124;
        boolean r26 = r25.booleanValue();
    L125:
        b(r26);
        e(k.d(r22.getSuggests()));
        goto L126
    L124:
        r26 = ((n) this.d.getValue()).e;
    L126:
        tu8.a.a.getClass();
        Result.box-impl(tu8.a.a(null));
    L141:
        this.n = a().getPrologue();
        this.o = a().getSuggestSwitch();
        Triple<String, String, String> r27 = a().getSuggests();
        if (r27 == null) goto L144;
        r10 = Triple.copy$default(r27, null, null, null, 7, null);
    L144:
        this.p = r10;
        return;
    L104:
        if (StringsKt.isBlank(r23) == true) goto L107;
        r4 = false;
    L128:
        if (((n) this.d.getValue()).a == false) goto L135;
        String r28 = a().getPrologue();
        if (r28 == null) goto L133;
        r12 = r28;
    L133:
        c(r12);
    L135:
        if (((n) this.d.getValue()).d == false) goto L141;
        Boolean r29 = a().getSuggestSwitch();
        if (r29 == null) goto L139;
        boolean r30 = r29.booleanValue();
    L140:
        b(r30);
        e(k.b(a().getSuggests()));
        goto L141
    L139:
        r30 = ((n) this.d.getValue()).e;
        goto L140
    L92:
        r22 = null;
    L93:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        Object r32 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r32) == false) goto L97;
        r32 = null;
    L97:
        r22 = (FirstMet) r32;
        goto L98
    L147:
        throw new NoWhenBranchMatchedException();
    }

    public final void i(m r7) {
        BuildersKt.launch$default(this.b, null, null, new BotFirstMetEditViewModel$sendUIEvent$1(this, r7, null), 3, null);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.firstmet.q
    public final void kl(boolean r11) {
        if (((n) this.d.getValue()).a == false) goto L8;
        if (r11 == false) goto L6;
        this.j = true;
        h(this, false, 0, false, null, true, false, 191);
        i(new m.b("", false));
        return;
    L6:
        h(this, false, 0, false, null, false, false, 191);
        return;
    }

    @Override // com.larus.bot.impl.feature.edit.feature.firstmet.q
    public final void updateAutoPlayState(boolean r1) {
        this.i = r1;
    }

    @Override // com.larus.bot.impl.feature.edit.feature.firstmet.q
    public final void vn(boolean r13) {
        if (((n) this.d.getValue()).a == true) goto L5;
        return;
    L5:
        if (((n) this.d.getValue()).d == false) goto L11;
        if (r13 == false) goto L8;
        this.k = true;
        h(this, false, 0, false, null, false, true, 127);
        h(this, false, 0, false, new Triple("", "", ""), false, false, 223);
        return;
    L8:
        h(this, false, 0, false, null, false, false, 127);
        return;
    }

    public BotFirstMetEditViewModel(CoroutineScope r14, o r15) {
        Intrinsics.checkNotNullParameter(r14, "scope");
        Intrinsics.checkNotNullParameter(r15, "dependency");
        this.a = r15;
        this.b = r14;
        e10 r0 = e10.a;
        if (e10.E().prologueEditable == true) goto L7;
        if (e10.D().prologueEditable == true) goto L7;
    L9:
        boolean r2 = false;
    L11:
        if (e10.E().suggestsEditable == false) goto L13;
    L16:
        boolean r5 = true;
    L17:
        Boolean r1 = a().getSuggestSwitch();
        if (r1 == null) goto L21;
        boolean r6 = r1.booleanValue();
    L29:
        StateFlowImpl r16 = j1.a(new n(r2, false, 0, r5, r6, k.b(a().getSuggests()), false, false));
        this.c = r16;
        this.d = kotlinx.coroutines.flow.e.b(r16);
        MutableSharedFlow<m> r3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.e = r3;
        this.f = kotlinx.coroutines.flow.e.a(r3);
        this.g = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.h = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        BuildersKt.launch$default(r14, null, null, new BotFirstMetEditViewModel$bindObservers$1(this, null), 3, null);
        BuildersKt.launch$default(r14, null, null, new BotFirstMetEditViewModel$bindObservers$2(this, null), 3, null);
        return;
    L21:
        if (getScene() == 0) goto L23;
    L28:
        r6 = true;
        goto L29
    L23:
        if (e10.E().defaultSuggestSwitch == true) goto L28;
        if (e10.D().defaultSuggestSwitch == true) goto L28;
        r6 = false;
        goto L29
    L13:
        if (e10.D().suggestsEditable == true) goto L16;
        r5 = false;
    L7:
        if (d() == false) goto L9;
        r2 = true;
        goto L11
    }

    public static void h(BotFirstMetEditViewModel r13, boolean r14, int r15, boolean r16, Triple r17, boolean r18, boolean r19, int r20) {
        if ((r20 & 1) == 0) goto L5;
        boolean r5 = ((n) r13.d.getValue()).a;
    L7:
        if ((r20 & 2) == 0) goto L9;
        boolean r6 = ((n) r13.d.getValue()).b;
    L11:
        if ((r20 & 4) == 0) goto L13;
        int r2 = ((n) r13.d.getValue()).c;
    L15:
        if ((r20 & 8) == 0) goto L17;
        boolean r8 = ((n) r13.d.getValue()).d;
    L19:
        if ((r20 & 16) == 0) goto L21;
        boolean r9 = ((n) r13.d.getValue()).e;
    L23:
        if ((r20 & 32) == 0) goto L25;
        Triple r10 = ((n) r13.d.getValue()).f;
    L27:
        if ((r20 & 64) == 0) goto L29;
        boolean r11 = ((n) r13.d.getValue()).g;
    L31:
        if ((r20 & 128) == 0) goto L33;
        boolean r12 = ((n) r13.d.getValue()).h;
    L35:
        if (r2 == 1) goto L37;
    L39:
        int r7 = r2;
    L40:
        r13.c.setValue(new n(r5, r6, r7, r8, r9, r10, r11, r12));
        return;
    L37:
        if (r13.f() == false) goto L39;
        r7 = 0;
        goto L40
    L33:
        r12 = r19;
        goto L35
    L29:
        r11 = r18;
        goto L31
    L25:
        r10 = r17;
        goto L27
    L21:
        r9 = r16;
        goto L23
    L17:
        r8 = false;
        goto L19
    L13:
        r2 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r5 = false;
        goto L7
    }
}
