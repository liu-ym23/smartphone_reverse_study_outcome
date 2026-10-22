package com.obric.assistant.chat.internal;

import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.lynx.jsbridge.LynxResourceModule;
import com.mammon.speechaudiosdk.jni.enums.SpeechNativePropertyId;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.ObricScreenshotUploadConfig;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.t1;
import com.obric.assistant.upload.IObricUploadService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;
import vea.n;
import wc9.e;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class SingleImageWithTextHandler implements oha.a {
    public static final /* synthetic */ int k = 0;
    public final String a;
    public final e b;
    public final String c;
    public final String d;
    public final String e;
    public final Map<String, String> f;
    public final IIMCallback<List<Message>> g;
    public final CoroutineScope h;
    public String i;
    public String j;

    public static final class a {
    }

    public static final class b implements IIMCallback<List<? extends Message>> {
        public final /* synthetic */ SingleImageWithTextHandler a;
        public final /* synthetic */ String b;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r10) {
            Intrinsics.checkNotNullParameter(r10, "error");
            FLogger.a.i("SingleImageWithTextHandler", "send called, sendFileAndText onFailure callback");
            IIMCallback<List<Message>> r0 = this.a.g;
            if (r0 == null) goto L5;
            r0.onFailure(r10);
        L5:
            CoroutineScope r1 = com.obric.assistant.chat.api.f.a;
            String r2 = this.a.a;
            String r3 = String.valueOf(r10.getCode());
            String r11 = r10.getTips();
            long r4 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r2, "identifier");
            Object r5 = com.obric.assistant.chat.api.f.b;
            monitor-enter(r5);
            com.obric.assistant.chat.api.f.c(r4);     // Catch: Throwable -> L37
            com.obric.assistant.chat.api.f.a r6 = (com.obric.assistant.chat.api.f.a) ((LinkedHashMap) com.obric.assistant.chat.api.f.g).get(r2);     // Catch: Throwable -> L37
            if (r6 != null) goto L11;
            monitor-exit(r5);
            return;
        L11:
            boolean r7 = false;
            if (r3 != null) goto L14;
        L17:
            boolean r8 = true;
        L19:
            if ((!r8) == true) goto L22;
            r3 = null;
        L22:
            if (r3 != null) goto L24;
            r3 = "send_failed";
        L24:
            if (r11 != null) goto L26;
        L27:
            r7 = true;
        L29:
            if ((!r7) == true) goto L32;
            r11 = null;
        L32:
            if (r11 != null) goto L34;
            r11 = "send second query failed";
        L34:
            com.obric.assistant.chat.api.f.l(r6, r4, r3, r11);     // Catch: Throwable -> L37
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L37
            monitor-exit(r5);
            return;
        L26:
            if (StringsKt.isBlank(r11) == false) goto L29;
        L14:
            if (StringsKt.isBlank(r3) == true) goto L17;
            r8 = false;
        L37:
            th = move-exception;
            throw th;
        }

        public final void onSuccess(Object r11) {
            List r12 = (List) r11;
            Intrinsics.checkNotNullParameter(r12, "result");
            FLogger.a.i("SingleImageWithTextHandler", "send called, sendFileAndText onSuccess callback");
            IIMCallback<List<Message>> r0 = this.a.g;
            if (r0 == null) goto L5;
            r0.onSuccess(r12);
        L5:
            CoroutineScope r1 = com.obric.assistant.chat.api.f.a;
            String r2 = this.a.a;
            String r3 = this.b;
            Iterator r4 = r12.iterator();
        L6:
            String r5 = null;
            if (r4.hasNext() == false) goto L11;
            Object r6 = r4.next();
            if (Intrinsics.areEqual(((Message) r6).getLocalMessageId(), r3) == false) goto L6;
        L12:
            Message r7 = (Message) r6;
            if (r7 != null) goto L15;
            r7 = (Message) CollectionsKt.lastOrNull(r12);
        L15:
            long r8 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r2, "identifier");
            Object r13 = com.obric.assistant.chat.api.f.b;
            monitor-enter(r13);
            CoroutineScope r9 = com.obric.assistant.chat.api.f.a;     // Catch: Throwable -> L64
            com.obric.assistant.chat.api.f.c(r8);     // Catch: Throwable -> L64
            com.obric.assistant.chat.api.f.a r10 = (com.obric.assistant.chat.api.f.a) ((LinkedHashMap) com.obric.assistant.chat.api.f.g).get(r2);     // Catch: Throwable -> L64
            if (r10 != null) goto L22;
            monitor-exit(r13);
            return;
        L22:
            if (r7 == null) goto L32;
            String r14 = com.obric.assistant.chat.api.f.p(r7);     // Catch: Throwable -> L64
            if (StringsKt.isBlank(r14) == true) goto L26;
            boolean r15 = true;
        L28:
            if (Boolean.valueOf(r15).booleanValue() == false) goto L30;
            r5 = r14;
        L30:
            if (r5 == null) goto L32;
        L35:
            Intrinsics.checkNotNullParameter(r5, "<set-?>");     // Catch: Throwable -> L64
            r10.j = r5;     // Catch: Throwable -> L64
            r10.k = r8;     // Catch: Throwable -> L64
            if (r3 != null) goto L38;
        L41:
            boolean r16 = true;
        L42:
            if (r16 == true) goto L45;
            com.obric.assistant.chat.api.f.h.put(r3, r10);     // Catch: Throwable -> L64
        L45:
            if (r7 == null) goto L62;
            List r17 = com.obric.assistant.chat.api.f.o(r7);     // Catch: Throwable -> L64
            if (r17 == null) goto L62;
            Iterator r18 = r17.iterator();     // Catch: Throwable -> L64
        L50:
            if (r18.hasNext() == false) goto L61;
            String r19 = (String) r18.next();     // Catch: Throwable -> L64
            CoroutineScope r20 = com.obric.assistant.chat.api.f.a;     // Catch: Throwable -> L64
            if (r19 != null) goto L54;
        L57:
            boolean r21 = true;
        L58:
            if (r21 == true) goto L50;
            com.obric.assistant.chat.api.f.h.put(r19, r10);     // Catch: Throwable -> L64
            goto L50
        L54:
            if (StringsKt.isBlank(r19) == true) goto L57;
            r21 = false;
            goto L58
        L61:
            Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L64
        L62:
            monitor-exit(r13);
            return;
        L38:
            if (StringsKt.isBlank(r3) == true) goto L41;
            r16 = false;
            goto L42
        L26:
            r15 = false;
        L32:
            if (r3 != null) goto L34;
            r5 = NameKeys.UnloadStrategy_No_Strategy;
            goto L35
        L34:
            r5 = r3;
        L64:
            th = move-exception;
            throw th;
        L11:
            r6 = null;
            goto L12
        }

        public b(SingleImageWithTextHandler r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final void onResult(boolean r1, String r2, String r3, String r4, String r5) {
    }

    public final Map<String, String> f() {
        if (o0.d(this.c) == false) goto L5;
        this.f.put("collection_id", UUID.randomUUID().toString());
    L5:
        String r0 = this.f.get("o_session");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
        if (r0 != null) goto L9;
    L13:
        r0 = "{}";
    L14:
        Object r1 = Result.constructor-impl(new JSONObject(r0));     // Catch: Throwable -> L16
    L19:
        if (Result.exceptionOrNull-impl(r1) == null) goto L22;
        r1 = new JSONObject();
    L22:
        JSONObject r3 = (JSONObject) r1;
        r3.put("img_resave", "1");
        this.f.put("o_session", r3.toString());
        return this.f;
    L9:
        if ((!StringsKt.isBlank(r0)) == true) goto L12;
        r0 = null;
    L12:
        if (r0 != null) goto L14;
    L16:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    public final void a(UplinkFileEntity r4) {
        Intrinsics.checkNotNullParameter(r4, "entity");
        Intrinsics.checkNotNullParameter(r4, "entity");
        FLogger.a.i("SingleImageWithTextHandler", "onProgressChanged: called, entity = " + r4);
        update(r4, null);
    }

    public final void d(UplinkFileEntity r4) {
        Intrinsics.checkNotNullParameter(r4, "entity");
        Intrinsics.checkNotNullParameter(r4, "entity");
        FLogger.a.i("SingleImageWithTextHandler", "onPrepare: called, entity = " + r4);
        e(r4);
    }

    public final void e(final UplinkFileEntity r33) {
        Intrinsics.checkNotNullParameter(r33, "entity");
        NestedFileContent r2 = new NestedFileContent(CollectionsKt.mutableListOf(new UplinkFileEntity[]{r33}), null, false, null, 14, null);
        FLogger.a.i("SingleImageWithTextHandler", "addLocal: called, content = " + r2);
        int r3 = wf9.b.a;
        this.i = com.flow.kmp.common.util.i.a();
        String r14 = com.flow.kmp.common.util.i.a();
        this.j = r14;
        final String r13 = this.i;
        if (r13 != null) goto L5;
        return;
    L5:
        if (r14 != null) goto L7;
        return;
    L7:
        ArrayList r12 = new ArrayList();
        Map<String, String> r22 = f();
        r12.add(new ai8.f(r2, r13, null, null, r22, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("send_loading", "1")}), false, null, null, null, 972));
        if (this.c.length() <= 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        r12.add(new ai8.h(this.c, r14, null, null, r22, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("send_loading", "1"), TuplesKt.to("is_mock_text", "1")}), false, false, null, null, 972));
    L13:
        RepoDispatcherDelegate.b.e().getSender().g(this.b.a, r12, new h(r13, r33));
        return;
    L10:
        r4 = false;
        goto L11
    }

    public final void h(UplinkFileEntity r21) {
        Intrinsics.checkNotNullParameter(r21, "entity");
        String r2 = this.i;
        if (r2 != null) goto L5;
        int r3 = wf9.b.a;
        r2 = com.flow.kmp.common.util.i.a();
    L5:
        String r5 = r2;
        String r4 = this.j;
        if (r4 != null) goto L8;
        int r6 = wf9.b.a;
        r4 = com.flow.kmp.common.util.i.a();
    L8:
        ArrayList r15 = new ArrayList();
        Map<String, String> r16 = f();
        r15.add(new ai8.f(new NestedFileContent(CollectionsKt.mutableListOf(new UplinkFileEntity[]{r21}), null, false, null, 14, null), r5, null, null, r16, null, false, null, null, null, SpeechNativePropertyId.SPEECH_PROPERTY_VOICE_ASSISTANT_SET_LOUDNESS_PARAM));
        if (this.c.length() <= 0) goto L11;
        boolean r14 = true;
    L12:
        if (r14 == false) goto L14;
        ArrayList r7 = r15;
        r7.add(new ai8.h(this.c, r4, null, null, r16, null, false, false, null, null, SpeechNativePropertyId.SPEECH_PROPERTY_VOICE_ASSISTANT_SET_LOUDNESS_PARAM));
    L15:
        u1 r8 = RepoDispatcherDelegate.b.e().getSender();
        e r9 = this.b;
        u1.a.e(r8, r9, r9.a, this.d, r7, this.e, new b(this, r4), false, false, null, 448);
        return;
    L14:
        r7 = r15;
        goto L15
    L11:
        r14 = false;
        goto L12
    }

    public final Object g(UplinkFileEntity r22, Continuation<? super Boolean> r23) {
        if ((r23 instanceof SingleImageWithTextHandler$restoreImage$1) == false) goto L7;
        SingleImageWithTextHandler$restoreImage$1 r2 = (SingleImageWithTextHandler$restoreImage$1) r23;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r6 = false;
        String r8 = null;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        long r7 = r2.J$0;
        ResultKt.throwOnFailure(r1);
    L35:
        n r9 = (n) r1;
        long r10 = r7;
    L37:
        FLogger.a.i("SingleImageWithTextHandler", "restoreImage: called, restoreResult = " + r9 + ", costTime = " + (System.currentTimeMillis() - r10));
        if (r9 != null) goto L40;
    L42:
        if (r9 == null) goto L44;
        List r11 = r9.b;
    L45:
        if (r11 != null) goto L47;
        r11 = CollectionsKt.emptyList();
    L47:
        List r12 = CollectionsKt.filterNotNull(r11);
        if (r9 == null) goto L52;
        Integer r13 = r9.c;
        if (r13 == null) goto L52;
        String r14 = r13.toString();
    L53:
        CoroutineScope r15 = com.obric.assistant.chat.api.f.a;
        String r16 = this.a;
        if (r6 == false) goto L56;
        String r17 = null;
    L59:
        if (r6 == true) goto L74;
        StringBuilder r18 = new StringBuilder();
        if (r9 == null) goto L69;
        String r19 = r9.d;
        if (r19 == null) goto L69;
        if (Boxing.boxBoolean(!StringsKt.isBlank(r19)).booleanValue() == false) goto L68;
        r8 = r19;
    L68:
        if (r8 == null) goto L69;
    L70:
        r18.append(r8);
        if ((!r12.isEmpty()) == false) goto L73;
        r18.append(", failUris=");
        r18.append(CollectionsKt.joinToString$default(r12, ",", null, null, 3, null, null, 54, null));
    L73:
        Unit r20 = Unit.INSTANCE;
        r8 = r18.toString();
    L69:
        r8 = "restore image failed";
    L74:
        com.obric.assistant.chat.api.f.e(r16, r6, r17, r8, 0, 16);
        return Boxing.boxBoolean(r6);
    L56:
        if (r14 != null) goto L58;
        r14 = "restore_failed";
    L58:
        r17 = r14;
    L52:
        r14 = null;
        goto L53
    L44:
        r11 = null;
        goto L45
    L40:
        if (r9.a != true) goto L42;
        r6 = true;
        goto L42
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        ObricScreenshotUploadConfig r21 = t1.a.getObricScreenshotUploadConfig();
        if (r21.getUseTempBucket() == true) goto L17;
    L76:
        long r110 = System.currentTimeMillis();
        CoroutineScope r24 = com.obric.assistant.chat.api.f.a;
        com.obric.assistant.chat.api.f.f(this.a, r110);
        com.obric.assistant.chat.api.f.e(this.a, true, null, null, r110, 12);
        FLogger.a.i("SingleImageWithTextHandler", "restoreImage: skip by config, useTempBucket=" + r21.getUseTempBucket() + ", restoreImageByClient=" + r21.getRestoreImageByClient());
        return Boxing.boxBoolean(true);
    L17:
        if (r21.getRestoreImageByClient() == false) goto L76;
        String r25 = l1.h(r22);
        if (r25 != null) goto L22;
    L25:
        boolean r26 = true;
    L26:
        if (r26 == false) goto L29;
        FLogger.a.i("SingleImageWithTextHandler", "restoreImage: key is null or blank, entity = " + r22);
        CoroutineScope r27 = com.obric.assistant.chat.api.f.a;
        com.obric.assistant.chat.api.f.e(this.a, false, "restore_key_empty", "restore image key is empty", 0, 16);
        return Boxing.boxBoolean(false);
    L29:
        r10 = System.currentTimeMillis();
        CoroutineScope r28 = com.obric.assistant.chat.api.f.a;
        com.obric.assistant.chat.api.f.f(this.a, r10);
        IObricNetworkService r29 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r29 == null) goto L36;
        List r30 = CollectionsKt.listOf(r25);
        r2.J$0 = r10;
        r2.label = 1;
        r1 = r29.n(r30, r2);
        if (r1 != r4) goto L34;
        return r4;
    L34:
        r7 = r10;
        goto L35
    L36:
        r9 = null;
        goto L37
    L22:
        if (StringsKt.isBlank(r25) == true) goto L25;
        r26 = false;
    L7:
        r2 = new SingleImageWithTextHandler$restoreImage$1(this, r23);
        goto L8
    }

    public final void update(UplinkFileEntity r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "entity");
        String r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        NestedFileCacheManagerService.b.l(r0, r10);
        u1.a.g(RepoDispatcherDelegate.b.e().getSender(), this.b.a, r0, new NestedFileContent(CollectionsKt.mutableListOf(new UplinkFileEntity[]{r10}), null, false, null, 14, null), new j(r11));
    }

    public final void b(UplinkFileEntity r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "entity");
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.CODE_KEY);
        Intrinsics.checkNotNullParameter(r6, "msg");
        Intrinsics.checkNotNullParameter(r4, "entity");
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.CODE_KEY);
        Intrinsics.checkNotNullParameter(r6, "msg");
        FLogger.a.i("SingleImageWithTextHandler", "onFailed: called, entity = " + r4 + ", msg = " + r6);
        update(r4, null);
        IObricUploadService.a.getClass();
        IObricUploadService r7 = IObricUploadService.a.a();
        if (r7 == null) goto L6;
        r7.c(this.a);
        return;
    }

    public final void c(UplinkFileEntity r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "entity");
        Intrinsics.checkNotNullParameter(r8, "entity");
        FLogger.a.i("SingleImageWithTextHandler", "onSuccess: called, entity = " + r8 + ", tosKey = " + r9 + ", resId = " + r10);
        BuildersKt.launch$default(this.h, null, null, new SingleImageWithTextHandler$onSuccess$1(this, r8, null), 3, null);
    }

    public SingleImageWithTextHandler(String r2, e r3, String r4, String r5, String r6, Map<String, String> r7, IIMCallback<List<Message>> r8) {
        Intrinsics.checkNotNullParameter(r2, "identifier");
        Intrinsics.checkNotNullParameter(r3, "conversation");
        Intrinsics.checkNotNullParameter(r4, "text");
        Intrinsics.checkNotNullParameter(r5, "textScene");
        Intrinsics.checkNotNullParameter(r6, "fromScene");
        Intrinsics.checkNotNullParameter(r7, "ext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }
}
