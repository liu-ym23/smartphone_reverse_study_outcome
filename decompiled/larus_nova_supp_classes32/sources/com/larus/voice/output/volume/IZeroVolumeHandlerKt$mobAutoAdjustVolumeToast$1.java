package com.larus.voice.output.volume;

import by7.a;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.SoundsSource;
import com.larus.im.bean.message.Message;
import com.larus.utils.f1;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aiagent.assistant.idl.bean.MessageContentType;
import com.obric.aivoice.core.data.NameKeys;
import ic8.n;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice.output.volume.IZeroVolumeHandlerKt$mobAutoAdjustVolumeToast$1", f = "IZeroVolumeHandler.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1}, l = {MessageContentType.CONTENT_TYPE_MULTI_CONTENT, MessageContentType.CONTENT_TYPE_LYRICS_TO_SONG}, m = "invokeSuspend", n = {"conversationId", "messageId", "botId", "uniId", "currentPage", "conversationId", "uniId", "currentPage", "conversation"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3"})
final class IZeroVolumeHandlerKt$mobAutoAdjustVolumeToast$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c $context;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    public IZeroVolumeHandlerKt$mobAutoAdjustVolumeToast$1(c r1, Continuation<? super IZeroVolumeHandlerKt$mobAutoAdjustVolumeToast$1> r2) {
        this.$context = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new IZeroVolumeHandlerKt$mobAutoAdjustVolumeToast$1(this.$context, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r7 = true;
        String r8 = NameKeys.UnloadStrategy_No_Strategy;
        String r9 = null;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        e r1 = (e) this.L$3;
        String r3 = (String) this.L$2;
        String r6 = (String) this.L$1;
        String r10 = (String) this.L$0;
        ResultKt.throwOnFailure(r18);
        String r11 = r6;
        Object r12 = r18;
    L53:
        Message r13 = (Message) r12;
        if (r13 == null) goto L56;
        String r14 = r13.getSenderId();
    L57:
        if (r14 == null) goto L60;
        r8 = r14;
    L60:
        e r15 = r1;
        String r16 = r10;
        String r17 = r8;
    L61:
        String r4 = this.$context.c;
        int r19 = r4.hashCode();
        if (r19 == (-598194362)) goto L76;
        if (r19 == 2034236362) goto L72;
        if (r19 == 2045333017) goto L69;
    L78:
        String r5 = this.$context.c;
    L79:
        if (r15 == null) goto L81;
        r9 = n.f(r15);
    L81:
        JSONObject r20 = new JSONObject();
        Intrinsics.checkNotNullParameter(r20, LynxResourceModule.PARAMS_KEY);
        if (r5 != null) goto L100;
    L86:
        if (r9 == null) goto L88;
        r20.put("chat_type", r9);     // Catch: JSONException -> L84
    L88:
        if (r3 == null) goto L90;
        r20.put("current_page", r3);     // Catch: JSONException -> L84
    L90:
        if (r16 == null) goto L92;
        r20.put("conversation_id", r16);     // Catch: JSONException -> L84
    L92:
        if (r17 == null) goto L94;
        r20.put("bot_id", r17);     // Catch: JSONException -> L84
    L94:
        if (r11 == null) goto L98;
        r20.put("call_id", r11);     // Catch: JSONException -> L84
    L84:
        e = move-exception;
        FLogger.a.e("ZeroVolumeEventHelper", "error in ZeroVolumeEventHelper mobAutoAdjustVolumeToast " + e.getLocalizedMessage());
    L98:
        TrackParams r21 = new TrackParams().merge(r20);
        a r22 = new a("auto_adjust_volume_toast");
        r22.a.merge(r21);
        r22.b();
        return Unit.INSTANCE;
    L100:
        r20.put("reading_scene", r5);     // Catch: JSONException -> L84
        goto L86
    L69:
        if (r4.equals("plugin_music") == false) goto L78;
    L77:
        r5 = SoundsSource.FIRST_PART_MUSIC.getKeyStr();
        goto L79
    L72:
        if (r4.equals("plugin_audio") == false) goto L78;
        r5 = SoundsSource.NEWS.getKeyStr();
        goto L79
    L76:
        if (r4.equals("qq_music") == false) goto L78;
    L56:
        r14 = null;
        goto L57
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r3 = (String) this.L$4;
        r11 = (String) this.L$3;
        r17 = (String) this.L$2;
        String r110 = (String) this.L$1;
        r16 = (String) this.L$0;
        ResultKt.throwOnFailure(r18);
        Object r111 = r18;
    L44:
        r15 = (e) r111;
        if (r17.length() == 0) goto L48;
        r7 = false;
    L48:
        if (r7 == false) goto L61;
        this.L$0 = r16;
        this.L$1 = r11;
        this.L$2 = r3;
        this.L$3 = r15;
        this.L$4 = null;
        this.label = 2;
        r12 = f1.b(r110, this);
        if (r12 != r0) goto L52;
        return r0;
    L52:
        r10 = r16;
        r1 = r15;
        goto L53
    L10:
        ResultKt.throwOnFailure(r18);
        Map<String, String> r23 = this.$context.d;
        if (r23 == null) goto L13;
        String r24 = r23.get("conversation_id");
    L14:
        if (r24 != null) goto L16;
        r24 = NameKeys.UnloadStrategy_No_Strategy;
    L16:
        Map<String, String> r112 = this.$context.d;
        if (r112 == null) goto L19;
        String r113 = r112.get("message_id");
    L20:
        if (r113 != null) goto L22;
        r110 = NameKeys.UnloadStrategy_No_Strategy;
    L23:
        Map<String, String> r114 = this.$context.d;
        if (r114 == null) goto L26;
        String r115 = r114.get("bot_id");
    L27:
        if (r115 != null) goto L29;
        r17 = NameKeys.UnloadStrategy_No_Strategy;
    L30:
        Map<String, String> r116 = this.$context.d;
        if (r116 == null) goto L33;
        r11 = r116.get("uni_id");
    L34:
        if (r11 != null) goto L36;
        r11 = NameKeys.UnloadStrategy_No_Strategy;
    L36:
        Map<String, String> r117 = this.$context.d;
        if (r117 == null) goto L39;
        String r118 = r117.get("current_page");
    L40:
        this.L$0 = r24;
        this.L$1 = r110;
        this.L$2 = r17;
        this.L$3 = r11;
        this.L$4 = r118;
        this.label = 1;
        r111 = f1.a(r24, this);
        if (r111 != r0) goto L43;
        return r0;
    L43:
        String r119 = r118;
        r16 = r24;
        r3 = r119;
        goto L44
    L39:
        r118 = null;
        goto L40
    L33:
        r11 = null;
        goto L34
    L29:
        r17 = r115;
        goto L30
    L26:
        r115 = null;
        goto L27
    L22:
        r110 = r113;
        goto L23
    L19:
        r113 = null;
        goto L20
    L13:
        r24 = null;
        goto L14
    }
}
