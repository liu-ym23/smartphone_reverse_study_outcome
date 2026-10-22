package com.larus.voice_setting.voice;

import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.larus.audio.bean.GetMatchVoiceRequest;
import com.larus.audio.bean.RecommendScene;
import com.larus.im.bean.bot.IconItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.z2;
import com.larus.utils.livedata.NonStickyLiveData;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.bean.CacheStatus;
import com.lynx.jsbridge.LynxResourceModule;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class UgcVoiceLoader {
    public static final NonStickyLiveData<com.larus.network.http.a<SpeakerVoice>> A = null;
    public static final NonStickyLiveData B = null;
    public static final MutableLiveData<Integer> C = null;
    public static final MutableLiveData D = null;
    public static final List<SpeakerVoice> E = null;
    public static final CopyOnWriteArrayList<p2a.e> F = null;
    public static final UgcVoiceLoader a = null;
    public static int b;
    public static int c;
    public static final Gson d = null;
    public static final List<SpeakerVoice> e = null;
    public static final List<SpeakerVoice> f = null;
    public static final List<SpeakerVoice> g = null;
    public static final List<SpeakerVoice> h = null;
    public static final NonStickyLiveData<r2a.i> i = null;
    public static final NonStickyLiveData j = null;
    public static final NonStickyLiveData<r2a.e> k = null;
    public static final NonStickyLiveData<r2a.e> l = null;
    public static volatile CacheStatus m;
    public static volatile RecommendScene n;
    public static final NonStickyLiveData<r2a.c> o = null;
    public static final NonStickyLiveData p = null;
    public static final NonStickyLiveData<com.larus.network.http.a<r2a.d>> q = null;
    public static final NonStickyLiveData r = null;
    public static final NonStickyLiveData<com.larus.network.http.a<SpeakerVoice>> s = null;
    public static final NonStickyLiveData t = null;
    public static final NonStickyLiveData<r2a.b> u = null;
    public static final NonStickyLiveData v = null;
    public static final NonStickyLiveData<r2a.a> w = null;
    public static final NonStickyLiveData x = null;
    public static final NonStickyLiveData<r2a.c> y = null;
    public static final NonStickyLiveData z = null;

    public UgcVoiceLoader() {
    }

    static {
        a = new UgcVoiceLoader();
        b = 1;
        c = 1;
        d = new Gson();
        e = new ArrayList();
        f = new ArrayList();
        g = new CopyOnWriteArrayList();
        h = new CopyOnWriteArrayList();
        NonStickyLiveData<r2a.i> r0 = new NonStickyLiveData();
        i = r0;
        j = r0;
        NonStickyLiveData<r2a.e> r1 = new NonStickyLiveData();
        k = r1;
        l = r1;
        m = CacheStatus.EMPTY;
        n = RecommendScene.NULL;
        NonStickyLiveData<r2a.c> r2 = new NonStickyLiveData();
        o = r2;
        p = r2;
        NonStickyLiveData<com.larus.network.http.a<r2a.d>> r3 = new NonStickyLiveData();
        q = r3;
        r = r3;
        NonStickyLiveData<com.larus.network.http.a<SpeakerVoice>> r4 = new NonStickyLiveData();
        s = r4;
        t = r4;
        NonStickyLiveData<r2a.b> r5 = new NonStickyLiveData();
        u = r5;
        v = r5;
        NonStickyLiveData<r2a.a> r6 = new NonStickyLiveData();
        w = r6;
        x = r6;
        NonStickyLiveData<r2a.c> r7 = new NonStickyLiveData();
        y = r7;
        z = r7;
        NonStickyLiveData<com.larus.network.http.a<SpeakerVoice>> r8 = new NonStickyLiveData();
        A = r8;
        B = r8;
        MutableLiveData<Integer> r9 = new MutableLiveData();
        C = r9;
        D = r9;
        E = new CopyOnWriteArrayList();
        F = new CopyOnWriteArrayList();
    }

    public static void p() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new UgcVoiceLoader$requestUgcVoiceAuthorized$1(null), 3, null);
    }

    public static void u() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new UgcVoiceLoader$updateFailedVoiceKeva$1(null), 2, null);
    }

    public static final void a(String r3) {
        Iterator r0 = ((ArrayList) e).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        SpeakerVoice r1 = (SpeakerVoice) r0.next();
        if (r1 == null) goto L4;
        if (Intrinsics.areEqual(r1.getId(), r3) == false) goto L4;
        r0.remove();
        goto L4
    L10:
        Iterator r2 = ((ArrayList) f).iterator();
        boolean r4 = false;
    L12:
        if (r2.hasNext() == false) goto L18;
        SpeakerVoice r5 = (SpeakerVoice) r2.next();
        if (r5 == null) goto L12;
        if (Intrinsics.areEqual(r5.getId(), r3) == false) goto L12;
        r2.remove();
        r4 = true;
        goto L12
    L18:
        if (r4 == false) goto L35;
        u();
        return;
    }

    public static void f(SpeakerVoice r4) {
        Intrinsics.checkNotNullParameter(r4, "voice");
        Iterator r0 = ((ArrayList) f).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((SpeakerVoice) r1).getId(), r4.getId()) == false) goto L4;
    L10:
        if (((SpeakerVoice) r1) != null) goto L16;
        ((ArrayList) f).add(r4);
        u();
        return;
    L16:
        return;
    L8:
        r1 = null;
        goto L10
    }

    public static boolean h(String r6) {
        r2a.e r0 = (r2a.e) l.getValue();
        if (r0 == null) goto L5;
        List<SpeakerVoice> r1 = r0.a;
    L6:
        List<SpeakerVoice> r2 = r1;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        return false;
    L15:
        Iterator<T> r4 = r1.iterator();
        int r5 = 0;
    L17:
        if (r4.hasNext() == false) goto L29;
        Object r7 = r4.next();
        int r8 = r5 + 1;
        if (r5 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        SpeakerVoice r9 = (SpeakerVoice) r7;
        if (Intrinsics.areEqual(r6, r9.getId()) == true) goto L24;
        if (r5 == 9) goto L27;
        r5 = r8;
        goto L17
    L27:
        return false;
    L24:
        return r9.getBestMatch();
    L29:
        return false;
    L9:
        if (r2.isEmpty() == true) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public static void k(String r7) {
        Intrinsics.checkNotNullParameter(r7, "languageCode");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new UgcVoiceLoader$queryMoreVoice$1(r7, null), 2, null);
    }

    public static void o(String r7) {
        Intrinsics.checkNotNullParameter(r7, "languageCode");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new UgcVoiceLoader$requestMyUgcVoiceList$1(r7, null), 2, null);
    }

    public static void t(SpeakerVoice r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Iterator r0 = ((CopyOnWriteArrayList) E).iterator();
        int r1 = 0;
    L6:
        if (r0.hasNext() == false) goto L11;
        SpeakerVoice r2 = (SpeakerVoice) r0.next();
        if (Intrinsics.areEqual(r5.getId(), r2.getId()) == true) goto L12;
        r1 = r1 + 1;
    L12:
        if (r1 == (-1)) goto L17;
        ListProtector.set(E, r1, r5);
        return;
    L17:
        return;
    L11:
        r1 = -1;
        goto L12
    }

    public static final void b(String r4, String r5) {
        Iterator r0 = ((ArrayList) e).iterator();
    L3:
        SpeakerVoice r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((SpeakerVoice) r1).getId(), r4) == false) goto L3;
    L9:
        SpeakerVoice r3 = (SpeakerVoice) r1;
        if (r3 == null) goto L12;
        r3.setName(r5);
    L12:
        Iterator r6 = ((ArrayList) f).iterator();
    L14:
        if (r6.hasNext() == false) goto L18;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((SpeakerVoice) r7).getId(), r4) == false) goto L14;
    L19:
        SpeakerVoice r8 = (SpeakerVoice) r7;
        if (r8 == null) goto L22;
        r8.setName(r5);
        r2 = r8;
    L22:
        if (r2 == null) goto L31;
        u();
        return;
    L31:
        return;
    L18:
        r7 = null;
        goto L19
    L8:
        r1 = null;
        goto L9
    }

    public static void g(String r2, SpeakerVoice r3) {
        boolean r1 = false;
        ListProtector.add(e, 0, r3);
        Iterator r4 = ((ArrayList) f).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(((SpeakerVoice) r4.next()).getId(), r2) == false) goto L4;
        r4.remove();
        r1 = true;
        goto L4
    L8:
        if (r1 == false) goto L16;
        u();
        return;
    }

    public static void i(GetMatchVoiceRequest r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "param");
        Ref.LongRef r2 = new Ref.LongRef();
        r2.element = SystemClock.uptimeMillis();
        m = CacheStatus.EMPTY;
        n = RecommendScene.NULL;
        c = 1;
        k.setValue(null);
        m = CacheStatus.LOADING;
        n = r10.g;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new UgcVoiceLoader$preLoadRecommendVoiceListV2$1(r10, r2, false, r11, null), 2, null);
    }

    public static void j(GetMatchVoiceRequest r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "param");
        Ref.LongRef r0 = new Ref.LongRef();
        r0.element = SystemClock.uptimeMillis();
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new UgcVoiceLoader$queryMoreRecommendVoiceV2$1(r9, r0, r10, null), 2, null);
    }

    public static final Object d(int r12, String r13, Continuation r14) {
        JSONObject r3 = new JSONObject();
        if (z2.a.I2() == false) goto L5;
        r3.put("page_index", r12);
        r3.put("page_size", 20);
        r3.put("language_code", r13);
    L5:
        Unit r15 = Unit.INSTANCE;
        return HttpExtKt.k("Social", r2a.g.class, "/alice/user_voice/list", r3, null, null, false, null, null, null, r14, 1008);
    }

    public static final Object c(UgcVoiceLoader r15, GetMatchVoiceRequest r16, int r17, Continuation r18) {
        r15.getClass();
        if ((r18 instanceof UgcVoiceLoader$queryBestMatchVoiceList$1) == false) goto L7;
        UgcVoiceLoader$queryBestMatchVoiceList$1 r2 = (UgcVoiceLoader$queryBestMatchVoiceList$1) r18;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        UgcVoiceLoader$queryBestMatchVoiceList$1 r13 = r2;
        Object r1 = r13.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r13.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L18:
        return (com.larus.network.http.a) r1;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        JSONObject r6 = new JSONObject();
        r6.put("page_index", r17);
        r6.put("page_size", 20);
        r6.put("recommend_type", 2);
        r6.put("language_code", r16.f);
        r6.put("bot_name", r16.a);
        r6.put("bot_desc", r16.b);
        r6.put("bot_id", r16.d);
        r6.put("bot_model_type", r16.e);
        Unit r0 = Unit.INSTANCE;
        r13.label = 1;
        r1 = HttpExtKt.k("Social", r2a.g.class, "/alice/user_voice/recommend", r6, null, null, false, null, null, null, r13, 1008);
        if (r1 != r4) goto L18;
        return r4;
    L7:
        r2 = new UgcVoiceLoader$queryBestMatchVoiceList$1(r15, r18);
        goto L8
    }

    public static void n(String r10, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "voiceName");
        Intrinsics.checkNotNullParameter(r12, "localVoiceId");
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new UgcVoiceLoader$requestCreateUgcVoiceV2$1(r12, r10, r11, r13, null), 3, null);
    }

    public static void q(String r10, String r11, String r12, boolean r13) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new UgcVoiceLoader$requestUpdateVoiceV2$1(r10, r11, r12, r13, null), 3, null);
    }

    public final Object l(String r17, String r18, String r19, Continuation<? super Unit> r20) {
        String r0 = r19;
        if ((r20 instanceof UgcVoiceLoader$requestCloneUgcVoiceV2$1) == false) goto L7;
        UgcVoiceLoader$requestCloneUgcVoiceV2$1 r2 = (UgcVoiceLoader$requestCloneUgcVoiceV2$1) r20;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        UgcVoiceLoader$requestCloneUgcVoiceV2$1 r14 = r2;
        Object r1 = r14.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r14.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        r0 = (String) r14.L$0;
        ResultKt.throwOnFailure(r1);
    L17:
        w.postValue(new r2a.a((com.larus.network.http.a) r1, r0));
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        JSONObject r7 = new JSONObject();
        r7.put("tos_key", r18);
        r7.put("lang_code", r17);
        r7.put("local_voice_id", r0);
        Unit r8 = Unit.INSTANCE;
        r14.L$0 = r0;
        r14.label = 1;
        r1 = HttpExtKt.k("Social", SpeakerVoice.class, "/alice/user_voice/clone", r7, null, null, false, null, null, null, r14, 1008);
        if (r1 != r4) goto L17;
        return r4;
    L7:
        r2 = new UgcVoiceLoader$requestCloneUgcVoiceV2$1(this, r20);
        goto L8
    }

    public static /* synthetic */ void s(String r10, String r11, String r12, String r13, String r14, IconItem r15, String r16, String r17, boolean r18) {
        r(r10, r11, r12, r13, r14, r15, false, r16, r17, r18);
    }

    public static Job r(String r16, String r17, String r18, String r19, String r20, IconItem r21, boolean r22, String r23, String r24, boolean r25) {
        Intrinsics.checkNotNullParameter(r16, "languageCode");
        Intrinsics.checkNotNullParameter(r17, "filePath");
        Intrinsics.checkNotNullParameter(r18, "freeTalkContent");
        Intrinsics.checkNotNullParameter(r24, "enterMethod");
        return BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new UgcVoiceLoader$requestUploadVoice$1(r17, r19, r18, r16, r20, r21, r22, r23, r24, r25, null), 3, null);
    }

    public final Object m(final String r26, final String r27, final String r28, final String r29, final IconItem r30, boolean r31, final String r32, final String r33, boolean r34, Continuation<? super Unit> r35) {
        final String r8 = r28;
        final String r9 = r32;
        if ((r35 instanceof UgcVoiceLoader$requestCreateUgcVoice$1) == false) goto L7;
        UgcVoiceLoader$requestCreateUgcVoice$1 r1 = (UgcVoiceLoader$requestCreateUgcVoice$1) r35;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        UgcVoiceLoader$requestCreateUgcVoice$1 r15 = r1;
        Object r0 = r15.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r15.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        boolean r4 = r15.Z$0;
        String r5 = (String) r15.L$1;
        String r6 = (String) r15.L$0;
        ResultKt.throwOnFailure(r0);
        boolean r7 = r4;
        r9 = r5;
        r8 = r6;
        String r10 = "enter_method";
        boolean r11 = true;
        int r12 = 15;
        Object r13 = r0;
        String r16 = null;
    L25:
        final com.larus.network.http.y r17 = (com.larus.network.http.a) r13;
        if ((r17 instanceof com.larus.network.http.y) == false) goto L32;
        SpeakerVoice r18 = (SpeakerVoice) ((com.larus.network.http.a) r17).b;
        if (r18 == null) goto L30;
        g(r8, r18);
    L30:
        f2a.c r19 = com.larus.voice_setting.voice.utils.k.a.b("request voice create success");
        r19.e(new x1(r9, r8));
        r19.c.b = CollectionsKt.listOf("VoiceCreate");
        f2a.c.c(r19, r16, r12);
    L34:
        o.postValue(new r2a.c(r17, r8, r11));
        return Unit.INSTANCE;
    L32:
        if ((r17 instanceof com.larus.network.http.f) == false) goto L34;
        FLogger r20 = FLogger.a;
        StringBuilder r21 = new StringBuilder("[requestCreateUgcVoice] fail, error=");
        com.larus.network.http.f r110 = (com.larus.network.http.f) r17;
        r21.append(r110.d);
        r21.append(", localVoiceId=");
        r21.append(r8);
        r20.e("UgcVoiceLoader", r21.toString(), r110.d);
        int r22 = y2a.a.a;
        JSONObject r23 = new JSONObject();
        r23.put("is_scheme", y2a.b.b(r7));
        r23.put(r10, y2a.b.a(r9));
        r23.put("result", "Fail");
        r23.put("reason", "CreateUGCVoiceRequestFailed");
        JSONObject r24 = new JSONObject();
        r24.put(LynxResourceModule.CODE_KEY, r110.d.getCode());
        r24.put("message", r110.d.getMessage());
        Unit r25 = Unit.INSTANCE;
        r23.put("reason_detail", r24.toString());
        y2a.a.a(r23);
        f2a.c r36 = com.larus.voice_setting.voice.utils.k.a.b("request voice create failed");
        r36.e(new y1(r17, r9, r8));
        r36.c.b = CollectionsKt.listOf("VoiceCreate");
        f2a.c.c(r36, r16, r12);
        goto L34
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        f2a.c r37 = com.larus.voice_setting.voice.utils.k.a.b("request voice create");
        r37.e(new w1(r29, r27, r26, r33, r30, r32, r28));
        r37.c.b = CollectionsKt.listOf("VoiceCreate");
        r16 = null;
        f2a.c.c(r37, null, 15);
        JSONObject r38 = new JSONObject();
        r38.put(EasyGoDbTable.Server.NAME, r29);
        r38.put("tos_key", r27);
        r38.put("bot_lang", r26);
        if (r30 == null) goto L18;
        String r39 = r30.getUri();
        if (r39 == null) goto L18;
    L19:
        r38.put("icon", r39);
        if (r31 == false) goto L22;
        r38.put("need_delete_id", r8);
    L22:
        r10 = "enter_method";
        r38.put(r10, r9);
        r38.put("preview_text", r33);
        Unit r40 = Unit.INSTANCE;
        r15.L$0 = r8;
        r15.L$1 = r9;
        r7 = r34;
        r15.Z$0 = r7;
        r11 = true;
        r15.label = 1;
        r12 = 15;
        r13 = HttpExtKt.k("Social", SpeakerVoice.class, "/alice/user_voice/create", r38, null, null, false, null, null, null, r15, 1008);
        if (r13 != r14) goto L25;
        return r14;
    L18:
        r39 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        r1 = new UgcVoiceLoader$requestCreateUgcVoice$1(this, r35);
        goto L8
    }

    public static final Object e(UgcVoiceLoader r29, final String r30, final String r31, final String r32, final String r33, String r34, IconItem r35, boolean r36, String r37, final String r38, boolean r39, Continuation r40) {
        String r6 = r30;
        String r7 = r31;
        String r8 = r32;
        final String r9 = r38;
        r29.getClass();
        if ((r40 instanceof UgcVoiceLoader$requestCheckUgcVoice$1) == false) goto L7;
        UgcVoiceLoader$requestCheckUgcVoice$1 r1 = (UgcVoiceLoader$requestCheckUgcVoice$1) r40;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        UgcVoiceLoader$requestCheckUgcVoice$1 r15 = r1;
        Object r0 = r15.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r15.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 == 3) goto L16;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r4 = (String) r15.L$0;
        ResultKt.throwOnFailure(r0);
    L39:
        tx9.e0.a(r4, Boxing.boxLong(1));
    L44:
        return Unit.INSTANCE;
    L17:
        boolean r5 = r15.Z$1;
        boolean r10 = r15.Z$0;
        String r11 = (String) r15.L$7;
        String r12 = (String) r15.L$6;
        IconItem r13 = (IconItem) r15.L$5;
        String r16 = (String) r15.L$4;
        String r17 = (String) r15.L$3;
        String r18 = (String) r15.L$2;
        String r19 = (String) r15.L$1;
        String r110 = (String) r15.L$0;
        ResultKt.throwOnFailure(r0);
        boolean r111 = r5;
        String r112 = r12;
        IconItem r20 = r13;
        r6 = r110;
        Object r21 = r14;
        UgcVoiceLoader$requestCheckUgcVoice$1 r23 = r15;
        Object r113 = r0;
        String r22 = "enter_method";
        String r24 = r16;
        r7 = r19;
        r9 = r11;
        final String r25 = r17;
        r8 = r18;
    L22:
        final com.larus.network.http.y r114 = (com.larus.network.http.a) r113;
        String r310 = r7;
        Object r115 = r21;
        String r116 = r6;
        String r117 = r8;
        boolean r311 = r10;
        if ((r114 instanceof com.larus.network.http.y) == false) goto L41;
        final com.larus.network.http.y r118 = r114;
        Long r119 = r118.g;
        if (r119 != null) goto L28;
    L29:
        int r26 = y2a.a.a;
        JSONObject r27 = new JSONObject();
        r27.put("is_scheme", y2a.b.b(r111));
        r27.put(r22, y2a.b.a(r9));
        r27.put("result", "Fail");
        r27.put("reason", "CheckUGCVoiceRequestFailed");
        JSONObject r28 = new JSONObject();
        r28.put(LynxResourceModule.CODE_KEY, r118.g);
        Unit r41 = Unit.INSTANCE;
        r27.put("reason_detail", r28.toString());
        y2a.a.a(r27);
        f2a.c r42 = com.larus.voice_setting.voice.utils.k.a.b("request voice check success, but code is not 0");
        r42.e(new a2(r118, r9, r25));
        r42.c.b = CollectionsKt.listOf("VoiceCreate");
        f2a.c.c(r42, null, 15);
        u.postValue(new r2a.b(0));
        tx9.e0.a(r112, Boxing.boxLong(0));
        goto L44
    L28:
        if (r119.longValue() != 0) goto L29;
        f2a.c r43 = com.larus.voice_setting.voice.utils.k.a.b("request voice check success");
        r43.e(new b2(r9, r25));
        r43.c.b = CollectionsKt.listOf("VoiceCreate");
        f2a.c.c(r43, null, 15);
        u.postValue(new r2a.b(0, r25, r24, r20, r311));
        boolean r44 = z2.a.I2();
        UgcVoiceLoader r45 = a;
        if (r44 == false) goto L35;
        UgcVoiceLoader$requestCheckUgcVoice$1 r46 = r23;
        r46.L$0 = r112;
        r46.L$1 = null;
        r46.L$2 = null;
        r46.L$3 = null;
        r46.L$4 = null;
        r46.L$5 = null;
        r46.L$6 = null;
        r46.L$7 = null;
        r46.label = 2;
        Object r47 = r115;
        if (r45.l(r117, r116, r25, r46) == r47) goto L45;
    L38:
        r4 = r112;
    L45:
        return r47;
    L35:
        r47 = r115;
        UgcVoiceLoader$requestCheckUgcVoice$1 r48 = r23;
        r48.L$0 = r112;
        r48.L$1 = null;
        r48.L$2 = null;
        r48.L$3 = null;
        r48.L$4 = null;
        r48.L$5 = null;
        r48.L$6 = null;
        r48.L$7 = null;
        r48.label = 3;
        if (r45.m(r117, r116, r25, r24, r20, r311, r9, r310, r111, r48) != r47) goto L38;
    L41:
        if ((r114 instanceof com.larus.network.http.f) == false) goto L44;
        int r49 = y2a.a.a;
        JSONObject r50 = new JSONObject();
        r50.put("is_scheme", y2a.b.b(r111));
        r50.put(r22, y2a.b.a(r9));
        r50.put("result", "Fail");
        r50.put("reason", "CheckUGCVoiceRequestFailed");
        JSONObject r51 = new JSONObject();
        com.larus.network.http.f r52 = (com.larus.network.http.f) r114;
        r51.put(LynxResourceModule.CODE_KEY, r52.d.getCode());
        r51.put("message", r52.d.getMessage());
        Unit r53 = Unit.INSTANCE;
        r50.put("reason_detail", r51.toString());
        y2a.a.a(r50);
        FLogger.a.e("UgcVoiceLoader", "[requestCheckUgcVoice] fail, error=" + r52.d + ", localVoiceId=" + r25, r52.d);
        f2a.c r54 = com.larus.voice_setting.voice.utils.k.a.b("request voice check failed");
        r54.e(new c2(r114, r9, r25));
        r54.c.b = CollectionsKt.listOf("VoiceCreate");
        f2a.c.c(r54, null, 15);
        u.postValue(new r2a.b(0));
        tx9.e0.a(r112, Boxing.boxLong(0));
        goto L44
    L18:
        ResultKt.throwOnFailure(r0);
        f2a.c r120 = com.larus.voice_setting.voice.utils.k.a.b("request voice check");
        r120.e(new z1(r30, r31, r32, r38, r33));
        r120.c.b = CollectionsKt.listOf("VoiceCreate");
        f2a.c.c(r120, null, 15);
        JSONObject r121 = new JSONObject();
        r121.put("tos_key", r6);
        r121.put("preview_text", r7);
        r121.put("voice_lang", r8);
        r121.put("enter_method", r9);
        Unit r55 = Unit.INSTANCE;
        r15.L$0 = r6;
        r15.L$1 = r7;
        r15.L$2 = r8;
        r25 = r33;
        r15.L$3 = r25;
        r24 = r34;
        r15.L$4 = r24;
        r20 = r35;
        r15.L$5 = r20;
        r15.L$6 = r37;
        r15.L$7 = r9;
        r15.Z$0 = r36;
        r15.Z$1 = r39;
        r15.label = 1;
        r21 = r14;
        r22 = "enter_method";
        r23 = r15;
        Object r122 = HttpExtKt.k("Social", Object.class, "/alice/user_voice/voice_check", r121, null, null, false, null, null, null, r23, 1008);
        if (r122 != r21) goto L21;
        r47 = r21;
        goto L45
    L21:
        r111 = r39;
        r113 = r122;
        r112 = r37;
        r10 = r36;
    L7:
        r1 = new UgcVoiceLoader$requestCheckUgcVoice$1(r29, r40);
        goto L8
    }
}
