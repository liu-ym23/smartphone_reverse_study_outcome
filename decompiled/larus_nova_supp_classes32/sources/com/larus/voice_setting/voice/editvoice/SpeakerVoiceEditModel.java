package com.larus.voice_setting.voice.editvoice;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.bot.AudioPreview;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.z2;
import com.larus.utils.livedata.NonStickyLiveData;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.base.VoiceDisplayScene;
import com.larus.voice_setting.voice.mix.res.VoiceAuditState;
import com.lynx.tasm.LynxTemplateRender;
import com.obric.aivoice.core.data.NameKeys;
import hq9.d5;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Function;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class SpeakerVoiceEditModel {
    public static final /* synthetic */ int P = 0;
    public final MutableSharedFlow A;
    public final MutableLiveData<b1> B;
    public final MutableLiveData C;
    public final MutableLiveData<Boolean> D;
    public final MutableLiveData E;
    public final MediatorLiveData<v2a.f> F;
    public final MediatorLiveData<v2a.f> G;
    public SpeakerVoice H;
    public ArrayList<MixVoice> I;
    public String J;
    public final CopyOnWriteArraySet<String> K;
    public Integer L;
    public boolean M;
    public Job N;
    public String O;
    public final CoroutineScope a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public boolean f;
    public int g;
    public boolean h;
    public final NonStickyLiveData<SpeakerVoice> i;
    public final NonStickyLiveData j;
    public final List<MixVoice> k;
    public final MutableLiveData<Integer> l;
    public final MutableLiveData m;
    public final ArrayList<MixVoice> n;
    public final NonStickyLiveData<w2a.b> o;
    public final NonStickyLiveData p;
    public w2a.c q;
    public final NonStickyLiveData<w2a.d> r;
    public final NonStickyLiveData s;
    public final NonStickyLiveData<w2a.a> t;
    public final NonStickyLiveData u;
    public final NonStickyLiveData<Boolean> v;
    public final NonStickyLiveData w;
    public final MutableLiveData<Integer> x;
    public final MutableLiveData y;
    public final MutableSharedFlow<a1> z;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final int d;
        public final boolean e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
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
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            int r8 = (((r6 + r1) * 31) + this.d) * 31;
            if (this.e == false) goto L17;
            int r9 = 1231;
        L19:
            return r8 + r9;
        L17:
            r9 = 1237;
            goto L19
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "MixVoiceCompareItem(voiceId=" + this.a + ", styleId=" + this.b + ", languageCode=" + this.c + ", percentage=" + this.d + ", isEnable=" + this.e + ')';
        }

        public b(String r1, String r2, String r3, int r4, boolean r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            String r4 = ((b) r2).a;
            String r0 = NameKeys.UnloadStrategy_No_Strategy;
            if (r4 != null) goto L5;
            r4 = NameKeys.UnloadStrategy_No_Strategy;
        L5:
            String r5 = ((b) r3).a;
            if (r5 == null) goto L10;
            r0 = r5;
        L10:
            return ComparisonsKt.compareValues(r4, r0);
        }
    }

    public static final class d<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public d(c r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r0 = this.a.compare(r2, r3);
            if (r0 != 0) goto L14;
            String r4 = ((b) r2).b;
            String r1 = NameKeys.UnloadStrategy_No_Strategy;
            if (r4 != null) goto L8;
            r4 = NameKeys.UnloadStrategy_No_Strategy;
        L8:
            String r5 = ((b) r3).b;
            if (r5 == null) goto L13;
            r1 = r5;
        L13:
            return ComparisonsKt.compareValues(r4, r1);
        L14:
            return r0;
        }
    }

    public static final class e<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public e(d r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r0 = this.a.compare(r2, r3);
            if (r0 != 0) goto L14;
            String r4 = ((b) r2).c;
            String r1 = NameKeys.UnloadStrategy_No_Strategy;
            if (r4 != null) goto L8;
            r4 = NameKeys.UnloadStrategy_No_Strategy;
        L8:
            String r5 = ((b) r3).c;
            if (r5 == null) goto L13;
            r1 = r5;
        L13:
            return ComparisonsKt.compareValues(r4, r1);
        L14:
            return r0;
        }
    }

    public static final class f<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public f(e r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r0 = this.a.compare(r2, r3);
            if (r0 == 0) goto L6;
            return r0;
        L6:
            return ComparisonsKt.compareValues(Integer.valueOf(((b) r2).d), Integer.valueOf(((b) r3).d));
        }
    }

    public static final class g<T> implements Comparator {
        public final /* synthetic */ Comparator a;

        public g(f r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r0 = this.a.compare(r2, r3);
            if (r0 == 0) goto L6;
            return r0;
        L6:
            return ComparisonsKt.compareValues(Boolean.valueOf(((b) r2).e), Boolean.valueOf(((b) r3).e));
        }
    }

    public static final class h implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public h(Function1 r2) {
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

    public final List<MixVoice> f() {
        if (this.e == true) goto L5;
        NonStickyLiveData r0 = this.j;
        if (r0 == null) goto L14;
        SpeakerVoice r2 = (SpeakerVoice) r0.getValue();
        if (r2 == null) goto L14;
        return CollectionsKt.listOf(new MixVoice(r2, 0, false, null, 14, null));
    L14:
        return CollectionsKt.emptyList();
    L5:
        return this.n;
    }

    public final w2a.f g() {
        List<MixVoice> r1 = f();
        float r4 = 10;
        float r5 = h() * r4;
        float r6 = k() * r4;
        w2a.c r0 = this.q;
        if (r0 == null) goto L5;
        String r7 = r0.b();
    L6:
        w2a.c r2 = this.q;
        if (r2 == null) goto L9;
        String r8 = r2.c();
    L11:
        return new w2a.f(r1, 0, 0, r5, r6, r7, r8, this.J, this.L, this.O, 6);
    L9:
        r8 = null;
        goto L11
    L5:
        r7 = null;
        goto L6
    }

    public final float h() {
        b1 r0 = (b1) this.C.getValue();
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.b();
    }

    public final SpeakerVoice j() {
        if (this.e == false) goto L10;
        if (this.n.size() != 1) goto L10;
        MixVoice r0 = (MixVoice) CollectionsKt.getOrNull(this.n, 0);
        if (r0 != null) goto L14;
    L12:
        return null;
    L14:
        return r0.getVoiceItem();
    L10:
        if (this.e == true) goto L12;
        return (SpeakerVoice) this.j.getValue();
    }

    public final float k() {
        b1 r0 = (b1) this.C.getValue();
        if (r0 != null) goto L7;
        return 1.0f;
    L7:
        return r0.c();
    }

    public final void r() {
        com.larus.utils.t0.e(new l0(this));
    }

    public SpeakerVoiceEditModel(CoroutineScope r7) {
        Intrinsics.checkNotNullParameter(r7, "viewModelScope");
        this.a = r7;
        this.b = NameKeys.UnloadStrategy_No_Strategy;
        this.c = NameKeys.UnloadStrategy_No_Strategy;
        this.d = NameKeys.UnloadStrategy_No_Strategy;
        NonStickyLiveData<SpeakerVoice> r0 = new NonStickyLiveData(0);
        this.i = r0;
        this.j = r0;
        this.k = new ArrayList();
        MutableLiveData<Integer> r1 = new MutableLiveData();
        this.l = r1;
        this.m = r1;
        this.n = new ArrayList();
        NonStickyLiveData<w2a.b> r2 = new NonStickyLiveData();
        this.o = r2;
        this.p = r2;
        NonStickyLiveData<w2a.d> r3 = new NonStickyLiveData();
        this.r = r3;
        this.s = r3;
        NonStickyLiveData<w2a.a> r4 = new NonStickyLiveData();
        this.t = r4;
        this.u = r4;
        NonStickyLiveData<Boolean> r5 = new NonStickyLiveData();
        this.v = r5;
        this.w = r5;
        MutableLiveData<Integer> r6 = new MutableLiveData(3);
        this.x = r6;
        this.y = r6;
        MutableSharedFlow<a1> r8 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.z = r8;
        this.A = r8;
        MutableLiveData<b1> r9 = new MutableLiveData(new b1(0));
        this.B = r9;
        this.C = r9;
        MutableLiveData<Boolean> r10 = new MutableLiveData(null);
        this.D = r10;
        this.E = r10;
        MediatorLiveData<v2a.f> r11 = new MediatorLiveData();
        this.F = r11;
        this.G = r11;
        this.I = new ArrayList();
        this.K = new CopyOnWriteArraySet();
        this.O = NameKeys.UnloadStrategy_No_Strategy;
        r11.addSource(r2, new h(new s0(this)));
        r11.addSource(r5, new h(new t0(this)));
    }

    public static final Map b(SpeakerVoiceEditModel r3) {
        r3.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("current_page", "bot_voice_change");
        r0.put("conversation_id", r3.d);
        r0.put("bot_id", r3.c);
        return r0;
    }

    public static SpeakerVoice i(SpeakerVoice r6) {
        if (r6 != null) goto L6;
        return null;
    L6:
        if (r6.getConfStatus() != 2) goto L9;
        FLogger.a.i("SpeakerVoiceEditModel", "getSingleSelectVoice confStatus is invalid so return null");
        return null;
    L9:
        List r1 = r6.getMixVoiceList();
        if (r1 != null) goto L12;
    L15:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L18;
        return r6;
    L18:
        List r3 = r6.getMixVoiceList();
        if (r3 != null) goto L21;
    L28:
        return r6;
    L21:
        if (r3.size() == 1) goto L23;
        r3.size();
        goto L28
    L23:
        if (((MixVoice) ListProtector.get(r3, 0)).isEnable() == true) goto L29;
        FLogger.a.i("SpeakerVoiceEditModel", "getSingleSelectVoice it[0].isEnable false so return null");
        return null;
    L29:
        return ((MixVoice) ListProtector.get(r3, 0)).getVoiceItem();
    L12:
        if (r1.isEmpty() == true) goto L15;
        r2 = false;
        goto L16
    }

    public static List l(List r9) {
        List r10 = r9;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L19;
        MixVoice r1 = (MixVoice) r11.next();
        SpeakerVoice r2 = r1.getVoiceItem();
        if (r2 == null) goto L8;
        String r4 = r2.getId();
    L9:
        SpeakerVoice r3 = r1.getVoiceItem();
        if (r3 == null) goto L12;
        String r5 = r3.getStyleId();
    L13:
        SpeakerVoice r6 = r1.getVoiceItem();
        if (r6 == null) goto L16;
        String r7 = r6.getLanguageCode();
    L17:
        r0.add(new b(r4, r5, r7, r1.getPercentage(), r1.isEnable()));
        goto L4
    L16:
        r7 = null;
        goto L17
    L12:
        r5 = null;
        goto L13
    L8:
        r4 = null;
        goto L9
    L19:
        return CollectionsKt.sortedWith(r0, new g(new f(new e(new d(new c())))));
    }

    public final void e(String r15) {
        v2a.g.a.f();
        ArrayList r5 = new ArrayList(this.n);
        b1 r6 = (b1) this.C.getValue();
        this.n.clear();
        this.o.postValue(new w2a.b("clear", new MixVoice(null, 0, false, null, 15, null), r15, r5, r6, this.n));
        com.larus.utils.t0.e(new q0(this));
        r();
    }

    public final void o(String r10) {
        d5 r0 = z2.a.getVoiceSettingConvenienceConfig();
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.c());
    L6:
        FLogger.a.i("SpeakerVoiceEditModel", "[tryStopCurrentAndPlayNewVoice]: caller = " + r10 + ", enableAutoPlay = " + r1);
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L13;
        Job r2 = this.N;
        if (r2 == null) goto L11;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L11:
        this.N = BuildersKt.launch$default(this.a, null, null, new SpeakerVoiceEditModel$tryStopCurrentAndPlayNewVoice$1(this, r10, null), 3, null);
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void p(final boolean r3) {
        if (Intrinsics.areEqual(this.D.getValue(), Boolean.valueOf(r3)) == true) goto L6;
        com.larus.utils.t0.e(new u0(this, r3));
        return;
    }

    public final void s(SpeakerVoice r22) {
        Intrinsics.checkNotNullParameter("from_tts", "from");
        FLogger.a.i("SpeakerVoiceEditModel", "[updateVoice] current:" + this.n + ", voice:" + r22 + ", from:from_tts");
        if ((!this.n.isEmpty()) == false) goto L21;
        Iterator<MixVoice> r1 = this.n.iterator();
        int r2 = 0;
    L6:
        if (r1.hasNext() == false) goto L15;
        SpeakerVoice r5 = r1.next().getVoiceItem();
        if (r5 == null) goto L10;
        String r6 = r5.getId();
    L12:
        if (Intrinsics.areEqual(r6, r22.getId()) == true) goto L13;
        r2 = r2 + 1;
        goto L6
    L13:
        int r12 = r2;
    L16:
        if (r12 == (-1)) goto L22;
        int r3 = ((MixVoice) ListProtector.get(this.n, r12)).getPercentage();
        ArrayList r13 = new ArrayList(this.n);
        b1 r14 = (b1) this.C.getValue();
        ListProtector.set(this.n, r12, new MixVoice(r22, r3, false, null, 12, null));
        this.o.postValue(new w2a.b(LynxTemplateRender.RENDER_PHASE_UPDATE, new MixVoice(r22, r3, false, null, 12, null), "from_tts", r12, r13, r14, this.n));
        r();
        return;
    L22:
        return;
    L10:
        r6 = null;
        goto L12
    L15:
        r12 = -1;
        goto L16
    }

    public final boolean n(SpeakerVoice r17, String r18) {
        Intrinsics.checkNotNullParameter(r18, "from");
        if (r17 != null) goto L5;
        return false;
    L5:
        FLogger.a.i("SpeakerVoiceEditModel", "[removeVoice] current:" + this.n + ", voice:" + r17 + ", from:" + r18 + "  voiceSelectedMixMode:" + this.e);
        if (this.e == true) goto L8;
        SpeakerVoice r3 = (SpeakerVoice) this.j.getValue();
        if (r3 == null) goto L30;
        String r4 = r3.getId();
    L32:
        if (Intrinsics.areEqual(r4, r17.getId()) == false) goto L34;
        q(null, false);
    L34:
        return false;
    L30:
        r4 = null;
        goto L32
    L8:
        if ((!this.n.isEmpty()) == false) goto L34;
        Iterator<MixVoice> r5 = this.n.iterator();
        int r6 = 0;
    L11:
        if (r5.hasNext() == false) goto L20;
        SpeakerVoice r7 = r5.next().getVoiceItem();
        if (r7 == null) goto L15;
        String r8 = r7.getId();
    L17:
        if (Intrinsics.areEqual(r8, r17.getId()) == true) goto L18;
        r6 = r6 + 1;
        goto L11
    L18:
        int r10 = r6;
    L21:
        if (r10 == (-1)) goto L34;
        v2a.g.a.f();
        ArrayList r11 = new ArrayList(this.n);
        b1 r12 = (b1) this.C.getValue();
        ListProtector.remove(this.n, r10);
        this.o.postValue(new w2a.b("remove", new MixVoice(r17, 0, false, null, 14, null), r18, r10, r11, r12, this.n));
        if (this.n.isEmpty() == false) goto L25;
        com.larus.utils.t0.e(new q0(this));
    L25:
        r();
        return true;
    L15:
        r8 = null;
        goto L17
    L20:
        r10 = -1;
        goto L21
    }

    public final void q(SpeakerVoice r9, boolean r10) {
        String r0 = null;
        if (r9 == null) goto L5;
        String r1 = r9.getId();
    L7:
        if (Intrinsics.areEqual(r1, "0") == true) goto L15;
        if (r9 == null) goto L10;
        String r2 = r9.getId();
    L12:
        if (Intrinsics.areEqual(r2, VoiceDisplayScene.NONE) == true) goto L15;
        SpeakerVoice r3 = r9;
    L16:
        this.i.postValue(r3);
        if (r10 == false) goto L46;
        com.larus.utils.t0.e(new q0(this));
        if (r3 == null) goto L23;
        AudioPreview r11 = r3.getPreview();
        if (r11 == null) goto L23;
        String r12 = r11.getPreviewAudio();
    L25:
        if (com.larus.utils.o0.d(r12) == true) goto L27;
        return;
    L27:
        if (r3 == null) goto L29;
        String r4 = r3.getStyleId();
    L30:
        if (r3 == null) goto L34;
        AudioPreview r5 = r3.getPreview();
        if (r5 == null) goto L34;
        String r6 = r5.getPreviewText();
    L35:
        if (r3 == null) goto L39;
        AudioPreview r7 = r3.getPreview();
        if (r7 == null) goto L39;
        String r8 = r7.getPreviewAudio();
    L40:
        if (r3 == null) goto L44;
        AudioPreview r13 = r3.getPreview();
        if (r13 == null) goto L44;
        r0 = r13.getMd5();
    L44:
        w2a.c r14 = new w2a.c(r4, r6, r8, r0, 16);
        this.q = r14;
        m(true, r9, r14);
        return;
    L39:
        r8 = null;
    L34:
        r6 = null;
        goto L35
    L29:
        r4 = null;
    L23:
        r12 = null;
        goto L25
    L46:
        return;
    L10:
        r2 = null;
    L15:
        r3 = null;
        goto L16
    L5:
        r1 = null;
        goto L7
    }

    public static final Object a(SpeakerVoiceEditModel r16, List r17, Continuation r18) {
        r16.getClass();
        if ((r18 instanceof SpeakerVoiceEditModel$generatePreviewVoice$1) == false) goto L7;
        Continuation<? super w2a.c> r3 = (SpeakerVoiceEditModel$generatePreviewVoice$1) r18;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Continuation<? super w2a.c> r5 = r3;
        Object r2 = r5.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r5.label;
        String r8 = null;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        ResultKt.throwOnFailure(r2);
    L43:
        w2a.c r9 = (w2a.c) r2;
        if (r9 == null) goto L47;
        r9.e(true);
    L49:
        return r9;
    L47:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        if (r17.isEmpty() == true) goto L47;
        if (Intrinsics.areEqual(l(r16.k), l(r17)) == false) goto L22;
        r9 = r16.q;
        if (r9 != null) goto L49;
    L22:
        ((ArrayList) r16.k).clear();
        Iterator r10 = r17.iterator();
    L24:
        if (r10.hasNext() == false) goto L27;
        MixVoice r11 = (MixVoice) r10.next();
        ((ArrayList) r16.k).add(MixVoice.copy$default(r11, null, 0, false, null, 15, null));
        goto L24
    L27:
        if (r17.size() != 1) goto L40;
        SpeakerVoice r1 = ((MixVoice) ListProtector.get(r17, 0)).getVoiceItem();
        if (r1 == null) goto L47;
        String r12 = r1.getStyleId();
        AudioPreview r13 = r1.getPreview();
        if (r13 == null) goto L34;
        r8 = r13.getPreviewAudio();
    L34:
        String r14 = r8;
        AudioPreview r15 = r1.getPreview();
        if (r15 == null) goto L38;
        String r19 = r15.getMd5();
        if (r19 == null) goto L38;
    L39:
        w2a.c r20 = new w2a.c(r12, null, r14, r19, 18);
        r20.e(false);
        return r20;
    L38:
        r19 = NameKeys.UnloadStrategy_No_Strategy;
        goto L39
    L40:
        ArrayList r21 = new ArrayList();
        r21.addAll(r17);
        float r22 = 10;
        float r23 = r16.h() * r22;
        float r24 = r22 * r16.k();
        String r25 = r16.b;
        r5.label = 1;
        r2 = r16.d(r21, r23, r24, r25, r5);
        if (r2 != r6) goto L43;
        return r6;
    L7:
        r3 = new SpeakerVoiceEditModel$generatePreviewVoice$1(r16, r18);
        goto L8
    }

    public final void m(final boolean r13, final SpeakerVoice r14, w2a.c r15) {
        p2a.q.a().stopAudio();
        p68.e r8 = new SpeakerVoiceEditModel$playVoice$playListener$1(this, r14, r13);
        boolean r2 = true;
        if (r13 == true) goto L5;
    L31:
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("playVoice play ugc voice, voiceId = ");
        if (r14 == null) goto L34;
        String r5 = r14.getId();
    L35:
        r4.append(r5);
        r4.append(", pitchF64 = ");
        r4.append(h());
        r4.append(", speechRateF64 = ");
        r4.append(k());
        r3.i("SpeakerVoiceEditModel", r4.toString());
        com.larus.audio.s0 r1 = p2a.q.a();
        String r6 = r15.b();
        String r7 = r15.c();
        String r16 = r15.a();
        float r9 = h();
        float r10 = k();
        String r11 = this.c;
        if (r11.length() == 0) goto L39;
        r2 = false;
    L39:
        if (r2 == false) goto L41;
        r11 = "0";
    L41:
        r1.k(r6, r7, r16, r9, r10, r11, r8);
        if (this.e == false) goto L51;
        if (r13 == true) goto L46;
        r14 = null;
    L46:
        t(r14, "from_play_button", 0);
        return;
    L51:
        return;
    L34:
        r5 = null;
        goto L35
    L5:
        if (h() != 0.0f) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L31;
        if (k() != 1.0f) goto L12;
        boolean r17 = true;
    L13:
        if (r17 == false) goto L31;
        FLogger r18 = FLogger.a;
        StringBuilder r19 = new StringBuilder("playVoice play origin voice, voiceId = ");
        if (r14 == null) goto L17;
        String r20 = r14.getId();
    L18:
        r19.append(r20);
        r18.i("SpeakerVoiceEditModel", r19.toString());
        if (r14 == null) goto L48;
        com.larus.audio.s0 r21 = p2a.q.a();
        String r22 = r14.getStyleId();
        AudioPreview r110 = r14.getPreview();
        if (r110 == null) goto L23;
        String r23 = r110.getPreviewAudio();
    L24:
        AudioPreview r111 = r14.getPreview();
        if (r111 == null) goto L27;
        String r24 = r111.getMd5();
    L28:
        r21.l(r22, r23, r24, r8, r14.getId(), r14.getName());
        if (this.e == false) goto L49;
        t(r14, "from_play_button", 0);
        return;
    L49:
        return;
    L27:
        r24 = null;
        goto L28
    L23:
        r23 = null;
        goto L24
    L48:
        return;
    L17:
        r20 = null;
        goto L18
    L12:
        r17 = false;
        goto L13
    L7:
        r12 = false;
        goto L8
    }

    public final void t(SpeakerVoice r3, String r4, @VoiceAuditState int r5) {
        Intrinsics.checkNotNullParameter(r4, "from");
        this.r.postValue(new w2a.d(r3, r4, r5));
    }

    public final boolean c(SpeakerVoice r17, String r18, boolean r19, int r20) {
        Intrinsics.checkNotNullParameter("from_tts", "from");
        boolean r10 = false;
        if (r17 != null) goto L5;
        return false;
    L5:
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("[addVoice] current:");
        MixVoice r3 = (MixVoice) CollectionsKt.firstOrNull(this.n);
        if (r3 == null) goto L10;
        SpeakerVoice r4 = r3.getVoiceItem();
        if (r4 == null) goto L10;
        String r5 = r4.getId();
    L11:
        r2.append(r5);
        r2.append(", voice:");
        r2.append(r17);
        r2.append(", from:from_tts");
        r1.i("SpeakerVoiceEditModel", r2.toString());
        ArrayList r12 = new ArrayList(this.n);
        b1 r13 = (b1) this.C.getValue();
        if (r19 == false) goto L15;
        this.n.clear();
    L15:
        if (this.n.size() >= 3) goto L49;
        Iterator<MixVoice> r6 = this.n.iterator();
        int r7 = 0;
    L18:
        if (r6.hasNext() == false) goto L27;
        SpeakerVoice r8 = r6.next().getVoiceItem();
        if (r8 == null) goto L22;
        String r9 = r8.getId();
    L24:
        if (Intrinsics.areEqual(r9, r17.getId()) == true) goto L28;
        r7 = r7 + 1;
    L28:
        if (r7 == (-1)) goto L30;
        return false;
    L30:
        v2a.g.a.f();
        MixVoice r14 = new MixVoice(r17, 100, false, r18, 4, null);
        this.n.add(r14);
        if (r19 == false) goto L33;
        BuildersKt.launch$default(this.a, null, null, new SpeakerVoiceEditModel$addVoice$1(this, null), 3, null);
    L33:
        NonStickyLiveData<w2a.b> r11 = this.o;
        if (r19 == false) goto L36;
        String r15 = "reset";
    L37:
        r11.postValue(new w2a.b(r15, r14, "from_tts", r12, r13, this.n));
        r();
        this.J = r18;
        String r16 = r17.getId();
        if (r16 == null) goto L45;
        Integer r21 = Integer.valueOf(r20);
        Intrinsics.checkNotNullParameter(r16, "voiceId");
        if (r16.length() <= 0) goto L42;
        r10 = true;
    L42:
        if (r10 == false) goto L44;
        this.K.add(r16);
    L44:
        this.L = r21;
    L45:
        return true;
    L36:
        r15 = "add";
        goto L37
    L22:
        r9 = null;
        goto L24
    L27:
        r7 = -1;
        goto L28
    L49:
        return false;
    L10:
        r5 = null;
        goto L11
    }

    public final Object d(final List<MixVoice> r22, final float r23, final float r24, final String r25, Continuation<? super w2a.c> r26) {
        if ((r26 instanceof SpeakerVoiceEditModel$createPreviewVoice$1) == false) goto L7;
        SpeakerVoiceEditModel$createPreviewVoice$1 r5 = (SpeakerVoiceEditModel$createPreviewVoice$1) r26;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r5.label;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        float r0 = r5.F$1;
        float r1 = r5.F$0;
        String r2 = (String) r5.L$1;
        List<MixVoice> r3 = (List) r5.L$0;
        ResultKt.throwOnFailure(r4);
        final float r9 = r0;
        final float r8 = r1;
        final String r10 = r2;
        final List<MixVoice> r11 = r3;
    L36:
        com.larus.network.http.y r12 = (com.larus.network.http.a) r4;
        if ((r12 instanceof com.larus.network.http.y) == false) goto L40;
        f2a.c r13 = com.larus.voice_setting.voice.utils.k.a.b("request conf_preview_create success");
        r13.e(new n0(r8, r9, r10, r11));
        r13.c.b = CollectionsKt.listOf("VoicePlay");
        f2a.c.c(r13, null, 15);
        return (w2a.c) ((com.larus.network.http.a) r12).b;
    L40:
        if ((r12 instanceof com.larus.network.http.f) == false) goto L42;
        com.larus.network.http.f r14 = (com.larus.network.http.f) r12;
    L43:
        if (r14 == null) goto L45;
        f2a.c r16 = com.larus.voice_setting.voice.utils.k.a.a("request conf_preview_create failed");
        final com.larus.network.http.f r17 = r14;
        r16.e(new o0(r8, r9, r10, r11, r17));
        r16.c.b = CollectionsKt.listOf("VoicePlay");
        Object r18 = null;
        f2a.c.c(r16, null, 15);
        FLogger.a.e("SpeakerVoiceEditModel", "createPreviewVoice failed", r14.d);
    L47:
        return r18;
    L45:
        r18 = null;
        goto L47
    L42:
        r14 = null;
        goto L43
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        f2a.c r19 = com.larus.voice_setting.voice.utils.k.a.b("request conf_preview_create");
        r19.e(new m0(r23, r24, r25, r22));
        r19.c.b = CollectionsKt.listOf("VoicePlay");
        f2a.c.c(r19, null, 15);
        JSONObject r110 = new JSONObject();
        r110.put("pitch_f64", Boxing.boxFloat(r23));
        r110.put("speech_rate_f64", Boxing.boxFloat(r24));
        r110.put("bot_language", r25);
        JSONArray r111 = new JSONArray();
        if (r22 == null) goto L32;
        Iterator<T> r112 = r22.iterator();
    L18:
        if (r112.hasNext() == false) goto L32;
        MixVoice r113 = (MixVoice) r112.next();
        JSONObject r114 = new JSONObject();
        SpeakerVoice r115 = r113.getVoiceItem();
        if (r115 == null) goto L25;
        String r116 = r115.getId();
        if (r116 == null) goto L25;
        String r117 = r116;
    L26:
        r114.put("voice_id", r117);
        SpeakerVoice r20 = r113.getVoiceItem();
        if (r20 == null) goto L30;
        String r21 = r20.getStyleId();
        if (r21 == null) goto L30;
    L31:
        r114.put("style_id", r21);
        r114.put("percentage", r113.getPercentage());
        r111.put(r114);
    L30:
        r21 = NameKeys.UnloadStrategy_No_Strategy;
    L25:
        r117 = NameKeys.UnloadStrategy_No_Strategy;
    L32:
        r110.put("voice_list", r111);
        Unit r27 = Unit.INSTANCE;
        r5.L$0 = r22;
        r5.L$1 = r25;
        r5.F$0 = r23;
        r5.F$1 = r24;
        r5.label = 1;
        Object r28 = HttpExtKt.k("Social", w2a.c.class, "/alice/audio/conf_preview_create", r110, null, null, false, null, null, null, r5, 1008);
        if (r28 != r15) goto L35;
        return r15;
    L35:
        r11 = r22;
        r8 = r23;
        r9 = r24;
        r10 = r25;
        r4 = r28;
    L7:
        r5 = new SpeakerVoiceEditModel$createPreviewVoice$1(this, r26);
        goto L8
    }
}
