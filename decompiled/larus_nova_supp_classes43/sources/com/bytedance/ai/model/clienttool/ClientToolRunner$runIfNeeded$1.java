package com.bytedance.ai.model.clienttool;

import androidx.collection.LruCache;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.LLMData;
import com.bytedance.ai.resource.AIManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.clienttool.ClientToolRunner$runIfNeeded$1", f = "ClientToolRunner.kt", i = {1}, l = {39, 51}, m = "invokeSuspend", n = {"messageId"}, s = {"L$0"})
final class ClientToolRunner$runIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ Function3<Integer, String, String, Boolean> $callback;
    final /* synthetic */ Function0<Unit> $fallback;
    final /* synthetic */ LLMData $llmData;
    final /* synthetic */ long $messageReceivedTime;
    Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ClientToolRunner$runIfNeeded$1(String r1, Function0<Unit> r10, LLMData r11, Function3<? super Integer, ? super String, ? super String, Boolean> r12, long r13, Continuation<? super ClientToolRunner$runIfNeeded$1> r14) {
        this.$appletId = r1;
        this.$fallback = r10;
        this.$llmData = r11;
        this.$callback = r12;
        this.$messageReceivedTime = r13;
        super(2, r14);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ClientToolRunner$runIfNeeded$1(this.$appletId, this.$fallback, this.$llmData, this.$callback, this.$messageReceivedTime, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        String r11 = "";
        boolean r12 = true;
        if (r10 == 0) goto L10;
        if (r10 == 1) goto L9;
        if (r10 != 2) goto L8;
        String r13 = (String) this.L$0;
        ResultKt.throwOnFailure(r18);
        Object r14 = r18;
        String r15 = r13;
    L28:
        ClientToolRuntime r16 = null;
        if ((r14 instanceof OnlineAppletApplication) == false) goto L31;
        OnlineAppletApplication r17 = (OnlineAppletApplication) r14;
    L33:
        if (r17 != null) goto L36;
        com.bytedance.ai.utils.g.a.i("ClientToolRunner", "fallback to legacy local plugin appletId=" + this.$appletId + " reason=application unavailable");
        this.$fallback.invoke();
        return Unit.INSTANCE;
    L36:
        Applet r19 = r17.j();
        String r20 = r19.Z;
        if (r20 == null) goto L39;
        String r21 = StringsKt.trim(r20).toString();
    L40:
        if (r21 == null) goto L44;
        r11 = r21;
    L44:
        if (r11.length() != 0) goto L46;
        boolean r22 = true;
    L47:
        if (r22 == false) goto L50;
        com.bytedance.ai.utils.g.a.i("ClientToolRunner", "fallback to legacy local plugin appletId=" + this.$appletId + " reason=entry missing");
        this.$fallback.invoke();
        return Unit.INSTANCE;
    L50:
        LruCache<Long, com.bytedance.ai.utils.j.a> r23 = com.bytedance.ai.utils.j.a;
        com.bytedance.ai.utils.j.a r24 = com.bytedance.ai.utils.j.b(StringsKt.toLongOrNull(r15));
        if (r24 == null) goto L53;
        r24.b(new Pair[]{TuplesKt.to("client_tool_execution_started", Boxing.boxInt(0))});
    L53:
        int r25 = ClientToolRuntime.q;
        Intrinsics.checkNotNullParameter(r11, "entry");
        if (StringsKt.isBlank(r11) == true) goto L101;
        if (StringsKt.startsWith$default(r11, '/', false, 2, null) == true) goto L101;
        if (StringsKt.endsWith$default(r11, ".template.js", false, 2, null) == false) goto L101;
        int r26 = 0;
    L61:
        if (r26 >= r11.length()) goto L77;
        char r27 = r11.charAt(r26);
        if (r27 != '\\') goto L65;
    L73:
        boolean r28 = true;
    L74:
        if (r28 == true) goto L75;
        r26 = r26 + 1;
        goto L61
    L75:
        boolean r29 = true;
    L78:
        if (r29 == true) goto L101;
        List r30 = StringsKt.split$default(r11, new char[]{'/'}, false, 0, 6, null);
        if ((r30 instanceof Collection) == true) goto L83;
    L85:
        Iterator r31 = r30.iterator();
    L87:
        if (r31.hasNext() == false) goto L99;
        String r32 = (String) r31.next();
        if (StringsKt.isBlank(r32) == false) goto L91;
    L96:
        boolean r110 = true;
    L97:
        if (r110 == false) goto L87;
    L91:
        if (Intrinsics.areEqual(r32, ".") == true) goto L96;
        if (Intrinsics.areEqual(r32, "..") == true) goto L96;
        r110 = false;
    L99:
        boolean r111 = true;
    L102:
        if (r111 == true) goto L106;
        ClientToolRunner.b(ClientToolRunner.a, r15, "invalid toolRuntimeEntry for applet " + this.$appletId + ": " + r11, this.$callback, "route", "invalid_entry");
        return Unit.INSTANCE;
    L106:
        if (r15.length() == 0) goto L109;
        r12 = false;
    L109:
        if (r12 == false) goto L112;
        ClientToolRunner.b(ClientToolRunner.a, r15, "Client Tool messageId is empty", this.$callback, "route", "invalid_message_id");
        return Unit.INSTANCE;
    L112:
        LinkedHashMap<String, ClientToolRuntime> r33 = ClientToolRunner.b;
        if (r33.size() < 5) goto L115;
    L140:
        ClientToolRunner.b(ClientToolRunner.a, r15, "client_tool_runtime_busy", this.$callback, "route", "runtime_busy");
        return Unit.INSTANCE;
    L115:
        if (r33.containsKey(r15) == true) goto L140;
        ClientToolRunner.a.getClass();
        Iterator r34 = CollectionsKt.asReversed(CollectionsKt.toList(ClientToolRunner.c.values())).iterator();
    L119:
        if (r34.hasNext() == false) goto L123;
        Object r35 = r34.next();
        if (Intrinsics.areEqual(((ClientToolRuntime) r35).d, r19.b) == false) goto L119;
    L124:
        ClientToolRuntime r36 = (ClientToolRuntime) r35;
        if (r36 == null) goto L128;
        ClientToolRunner.c.remove(r36.c);
        com.bytedance.ai.utils.g.a.i("ClientToolRunner", "reuse runtimeId=" + r36.c + " packageName=" + r36.d);
        r16 = r36;
    L128:
        if (r16 != null) goto L130;
        ClientToolRuntime r37 = ClientToolRunner.a(ClientToolRunner.a, r19);
    L131:
        LinkedHashMap<String, ClientToolRuntime> r38 = ClientToolRunner.b;
        r38.put(r15, r37);
        ClientToolRunner r39 = ClientToolRunner.a;
        boolean r40 = ClientToolRunner.c(r39, r37, r19, this.$llmData, this.$messageReceivedTime, this.$callback);
        if (r40 == true) goto L135;
        if (r16 == null) goto L135;
        com.bytedance.ai.utils.g.a.w("ClientToolRunner", "reuse rejected runtimeId=" + r37.c + "; create new runtime");
        r38.remove(r15);
        r37.b();
        r37 = ClientToolRunner.a(r39, r19);
        r38.put(r15, r37);
        r40 = ClientToolRunner.c(r39, r37, r19, this.$llmData, this.$messageReceivedTime, this.$callback);
    L135:
        if (r40 == true) goto L138;
        r38.remove(r15);
        r37.b();
        ClientToolRunner.b(r39, r15, "failed to start Client Tool Runtime", this.$callback, MessageIndication.STATUS_PREPARE, "runtime_start_rejected");
        return Unit.INSTANCE;
    L138:
        com.bytedance.ai.utils.g.a.i("ClientToolRunner", "start request runtimeId=" + r37.c + " appletId=" + this.$appletId + " messageId=" + r15 + " active=" + r38.size() + " idle=" + ClientToolRunner.c.size());
        return Unit.INSTANCE;
    L130:
        r37 = r16;
        goto L131
    L123:
        r35 = null;
        goto L124
    L83:
        if (r30.isEmpty() == false) goto L85;
    L65:
        if (r27 == '%') goto L73;
        if (r27 == '?') goto L73;
        if (r27 == '#') goto L73;
        if (r27 == 0) goto L73;
        r28 = false;
        goto L74
    L77:
        r29 = false;
    L101:
        r111 = false;
        goto L102
    L46:
        r22 = false;
        goto L47
    L39:
        r21 = null;
        goto L40
    L31:
        r17 = null;
        goto L33
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r18);
    L14:
        if (com.bytedance.ai.settings.b.c.a().booleanValue() == true) goto L18;
        com.bytedance.ai.utils.g.a.i("ClientToolRunner", "fallback to Local Plugin appletId=" + this.$appletId + " reason=toolRuntimeEntry disabled");
        this.$fallback.invoke();
        return Unit.INSTANCE;
    L18:
        if (AIManager.o.contains(this.$appletId) == false) goto L21;
        com.bytedance.ai.utils.g.a.i("ClientToolRunner", "fallback to Local Plugin appletId=" + this.$appletId + " reason=useApps disabled");
        this.$fallback.invoke();
        return Unit.INSTANCE;
    L21:
        String r41 = this.$llmData.getMsgId();
        if (r41 != null) goto L24;
        r41 = "";
    L24:
        AppletAppManagerService r42 = AppletAppManagerService.INSTANCE;
        String r43 = this.$appletId;
        this.L$0 = r41;
        this.label = 2;
        r14 = r42.d(r43, this);
        if (r14 != r1) goto L27;
        return r1;
    L27:
        r15 = r41;
        goto L28
    L10:
        ResultKt.throwOnFailure(r18);
        CompletableDeferred<Unit> r44 = f2.b.b;
        this.label = 1;
        if (r44.await(this) != r1) goto L14;
        return r1;
    }
}
