package com.larus.browsertakeover.transport;

import java.nio.ByteBuffer;
import java.nio.charset.CodingErrorAction;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.browsertakeover.transport.RtcBrowserTransport$Lease$startReaders$2", f = "RtcBrowserTransport.kt", i = {}, l = {296, 297}, m = "invokeSuspend", n = {}, s = {})
final class RtcBrowserTransport$Lease$startReaders$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RtcBrowserTransport.b this$0;
    final /* synthetic */ RtcBrowserTransport this$1;

    public RtcBrowserTransport$Lease$startReaders$2(RtcBrowserTransport.b r1, RtcBrowserTransport r2, Continuation<? super RtcBrowserTransport$Lease$startReaders$2> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RtcBrowserTransport$Lease$startReaders$2(this.this$0, this.this$1, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004d -> B:7:0x001a). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r22) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r3 = 2;
        int r4 = 1;
        if (r2 == 0) goto L11;
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L9;
        ChannelIterator r5 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r22);
        Object r6 = r22;
        RtcBrowserTransport$Lease$startReaders$2 r7 = this;
    L7:
        ChannelIterator r8 = r5;
        Object r9 = r0;
        if (((Boolean) r6).booleanValue() == false) goto L276;
        RtcBrowserTransport.d r10 = (RtcBrowserTransport.d) r8.next();
        RtcBrowserTransport r1 = r7.this$1;
        long r11 = r7.this$0.a;
        int r12 = RtcBrowserTransport.o;
        if (r1.l(r11) == false) goto L276;
        RtpCdpMessageCodec r13 = RtpCdpMessageCodec.a;
        byte[] r14 = r10.a;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "data");
        if (r14.length != 0) goto L26;
        boolean r15 = true;
    L27:
        if (r15 == false) goto L30;
        RtpCdpMessageCodec.a r16 = new RtpCdpMessageCodec.a.b(RtpCdpMessageCodec.Reason.EMPTY);
    L240:
        if ((r16 instanceof RtpCdpMessageCodec.a.C0070a) == false) goto L270;
        RtcBrowserTransport r17 = r7.this$1;
        RtcBrowserTransport.b r18 = r7.this$0;
        RtpCdpMessageCodec.a.C0070a r19 = (RtpCdpMessageCodec.a.C0070a) r16;
        Object r20 = r17.h;
        monitor-enter(r20);
        if (r17.l(r18.a) == true) goto L246;
    L264:
        monitor-exit(r20);
    L272:
        r0 = r9;
        r5 = r8;
        RtcBrowserTransport$Lease$startReaders$2 r21 = r7;
        r3 = 2;
        r4 = 1;
    L15:
        r21.L$0 = r5;
        r21.label = r3;
        r6 = r5.hasNext(r21);
        if (r6 != r0) goto L18;
        return r0;
    L18:
        r7 = r21;
        goto L7
    L246:
        if (r17.l == false) goto L264;
        BrowserTransport.a r23 = r17.m;     // Catch: Throwable -> L266
        if (r23 != null) goto L252;
        monitor-exit(r20);
        goto L272
    L252:
        long r110 = r18.m.incrementAndGet();     // Catch: Throwable -> L266
        if (r110 != 1) goto L255;
    L256:
        long r111 = r18.a;     // Catch: Throwable -> L266
        String r24 = "count=" + r110 + " codec=MJPEG bytes=" + r10.a.length + " rotation=" + r10.b + " sdkWidth=" + r10.c + " sdkHeight=" + r10.d + " framing=" + r19.b + " method=Page.screencastFrame";     // Catch: Throwable -> L266
        if (r110 == 1) goto L259;
        boolean r112 = true;
    L260:
        r17.n(r111, "rtp_frame_delivered", r24, r112);     // Catch: Throwable -> L266
    L261:
        r23.a(r19.a);     // Catch: Throwable -> L266
        Unit r25 = Unit.INSTANCE;     // Catch: Throwable -> L266
        monitor-exit(r20);
        goto L272
    L259:
        r112 = false;
        goto L260
    L255:
        if ((r110 % 30) != 0) goto L261;
    L266:
        th = move-exception;
        throw th;
    L270:
        if ((r16 instanceof RtpCdpMessageCodec.a.b) == false) goto L274;
        RtcBrowserTransport.d(r7.this$1, r7.this$0, ((RtpCdpMessageCodec.a.b) r16).a.name(), r10.a.length);
        goto L272
    L274:
        throw new NoWhenBranchMatchedException();
    L30:
        if (r14.length <= 6291456) goto L33;
        r16 = new RtpCdpMessageCodec.a.b(RtpCdpMessageCodec.Reason.TOO_LARGE);
        goto L240
    L33:
        byte r113 = 255;
        if (r14.length >= r3) goto L36;
    L40:
        boolean r114 = false;
    L41:
        if (r114 == true) goto L43;
        int r26 = 0;
    L179:
        int r27 = r14.length - r26;
        if (r114 == false) goto L182;
        int r28 = 2;
    L183:
        int r29 = r27 - r28;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L186
        Object r31 = Result.constructor-impl(Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(r14, r26, r29)).toString());     // Catch: Throwable -> L186
    L189:
        if (Result.isFailure-impl(r31) == false) goto L191;
        r31 = null;
    L191:
        String r32 = (String) r31;
        if (r32 != null) goto L194;
        r16 = new RtpCdpMessageCodec.a.b(RtpCdpMessageCodec.Reason.INVALID_UTF8);
        goto L240
    L194:
        JSONObject r33 = RtpCdpMessageCodec.b(r32);
        if (r33 != null) goto L197;
        r16 = new RtpCdpMessageCodec.a.b(RtpCdpMessageCodec.Reason.INVALID_JSON);
        goto L240
    L197:
        if (r114 == false) goto L199;
        String r34 = "mjpeg_json";
    L201:
        if (r33.has("version") == false) goto L203;
        Object r35 = r33.opt("version");
        if ((r35 instanceof Number) == true) goto L209;
    L238:
        r16 = new RtpCdpMessageCodec.a.b(RtpCdpMessageCodec.Reason.UNSUPPORTED_ENVELOPE);
        goto L240
    L209:
        if (((Number) r35).doubleValue() != 1.0d) goto L211;
        boolean r115 = true;
    L212:
        if (r115 == false) goto L238;
        if (Intrinsics.areEqual(r33.opt("direction"), "cdp_to_frontend") == false) goto L238;
        if (Intrinsics.areEqual(r33.opt("kind"), "event") == false) goto L238;
        if (Intrinsics.areEqual(r33.opt("method"), "Page.screencastFrame") == false) goto L238;
        if (r33.has("id") == true) goto L238;
        Object r36 = r33.opt("payload");
        if ((r36 instanceof JSONObject) == false) goto L226;
        JSONObject r116 = (JSONObject) r36;
    L229:
        if (r116 != null) goto L232;
        r16 = new RtpCdpMessageCodec.a.b(RtpCdpMessageCodec.Reason.INVALID_CDP_EVENT);
        goto L240
    L232:
        if (RtpCdpMessageCodec.a(r116) == true) goto L234;
    L237:
        r16 = new RtpCdpMessageCodec.a.b(RtpCdpMessageCodec.Reason.INVALID_CDP_EVENT);
        goto L240
    L234:
        if (Intrinsics.areEqual(r116.opt("method"), r33.opt("method")) == false) goto L237;
        r16 = new RtpCdpMessageCodec.a.C0070a(r116, r34.concat("_envelope_v1"));
        goto L240
    L226:
        if ((r36 instanceof String) == false) goto L228;
        r116 = RtpCdpMessageCodec.b((String) r36);
        goto L229
    L228:
        r116 = null;
        goto L229
    L211:
        r115 = false;
        goto L212
    L203:
        if (RtpCdpMessageCodec.a(r33) == false) goto L205;
        r16 = new RtpCdpMessageCodec.a.C0070a(r33, r34);
        goto L240
    L205:
        r16 = new RtpCdpMessageCodec.a.b(RtpCdpMessageCodec.Reason.INVALID_CDP_EVENT);
        goto L240
    L199:
        r34 = "raw_json";
    L186:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r31 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L189
    L182:
        r28 = 0;
        goto L183
    L43:
        if (r14.length < 6) goto L174;
        if ((r14[ArraysKt.getLastIndex(r14) - r4] & 255) != 255) goto L174;
        if ((r14[ArraysKt.getLastIndex(r14)] & 255) != 217) goto L174;
        int r38 = r14.length - r3;
        HashSet r39 = null;
        int r117 = 2;
        boolean r118 = false;
    L50:
        if (r117 >= r38) goto L174;
        int r119 = r117 + 4;
        if (r119 > r38) goto L174;
        if ((r14[r117] & r113) != r113) goto L174;
        int r120 = r14[r117 + 1] & r113;
        int r40 = ((r14[r117 + 2] & r113) * 256) + (r14[r117 + 3] & r113);
        if (r40 < 2) goto L174;
        if (r40 > ((r38 - r117) - 2)) goto L174;
        r117 = (r117 + r40) + 2;
        if (r120 != 192) goto L64;
        if (r118 == false) goto L174;
        if (r39 != null) goto L174;
        int r41 = r117 - r119;
        if (r41 >= 6) goto L129;
    L166:
        int r210 = r38;
    L169:
        HashSet r42 = null;
    L170:
        if (r42 == null) goto L174;
    L172:
        r39 = r42;
        r38 = r210;
        r113 = 255;
        goto L50
    L129:
        if ((r14[r119] & 255) != 8) goto L166;
        int r43 = ((r14[r119 + 1] & 255) * 256) + (r14[r119 + 2] & 255);
        int r44 = ((r14[r119 + 3] & 255) * 256) + (r14[r119 + 4] & 255);
        int r121 = r14[r119 + 5] & 255;
        if (r44 == 0) goto L166;
        if (r43 == 0) goto L166;
        if (1 > r121) goto L138;
        if (r121 >= 5) goto L138;
        boolean r45 = true;
    L139:
        if (r45 == false) goto L166;
        if (r41 != ((r121 * 3) + 6)) goto L166;
        r42 = new HashSet();
        int r46 = 0;
    L144:
        if (r46 >= r121) goto L165;
        int r122 = (r119 + 6) + (r46 * 3);
        RtpCdpMessageCodec r123 = RtpCdpMessageCodec.a;
        byte r47 = r14[r122 + 1];
        r123.getClass();
        int r48 = r47 & 255;
        r210 = r38;
        if (r42.add(Integer.valueOf(r14[r122] & 255)) == false) goto L169;
        int r49 = r48 >>> 4;
        if (1 > r49) goto L152;
        int r50 = 5;
        if (r49 >= 5) goto L153;
        boolean r51 = true;
    L154:
        if (r51 == false) goto L169;
        int r52 = r48 & 15;
        if (1 > r52) goto L159;
        if (r52 >= r50) goto L159;
        boolean r124 = true;
    L160:
        if (r124 == false) goto L169;
        if ((r14[r122 + 2] & 255) > 3) goto L169;
        r46 = r46 + 1;
        r38 = r210;
    L159:
        r124 = false;
    L153:
        r51 = false;
        goto L154
    L152:
        r50 = 5;
        goto L153
    L165:
        r210 = r38;
    L138:
        r45 = false;
        goto L139
    L64:
        if (r120 == 218) goto L86;
        if (r120 != 219) goto L174;
        if (r39 != null) goto L174;
        if (r119 >= r117) goto L82;
    L71:
        if (r119 >= r117) goto L80;
        int r53 = r119 + 1;
        int r125 = r14[r119] & 255;
        if ((r125 >>> 4) != 0) goto L82;
        if ((r125 & 15) > 3) goto L82;
        if ((r117 - r53) < 64) goto L82;
        r119 = r53 + 64;
        goto L71
    L80:
        if (r119 != r117) goto L82;
        boolean r54 = true;
    L83:
        if (r54 == false) goto L174;
        r210 = r38;
        r42 = r39;
        r118 = true;
    L82:
        r54 = false;
        goto L83
    L86:
        if (r39 == null) goto L174;
        if (r119 >= r117) goto L114;
        int r55 = r14[r119] & 255;
        if (r55 != r39.size()) goto L114;
        if ((r117 - r119) != ((r55 * 2) + 4)) goto L114;
        HashSet r126 = new HashSet();
        int r127 = 0;
    L96:
        if (r127 >= r55) goto L108;
        int r128 = (r119 + 1) + (r127 * 2);
        RtpCdpMessageCodec r129 = RtpCdpMessageCodec.a;
        byte r56 = r14[r128];
        r129.getClass();
        int r57 = r56 & 255;
        int r58 = r14[r128 + 1] & 255;
        if (r39.contains(Integer.valueOf(r57)) == false) goto L114;
        if (r126.add(Integer.valueOf(r57)) == false) goto L114;
        if ((r58 >>> 4) > 3) goto L114;
        if ((r58 & 15) > 3) goto L114;
        r127 = r127 + 1;
        goto L96
    L108:
        if ((r14[r117 - 3] & 255) != 0) goto L114;
        if ((r14[r117 - 2] & 255) != 63) goto L114;
        if ((r14[r117 - 1] & 255) != 0) goto L114;
        boolean r59 = true;
    L115:
        if (r59 == false) goto L174;
        Integer r60 = Integer.valueOf(r117);
        if (r60.intValue() >= r38) goto L120;
        boolean r61 = true;
    L121:
        if (r61 == false) goto L174;
    L175:
        if (r60 == null) goto L177;
        r26 = r60.intValue();
        goto L179
    L177:
        r16 = new RtpCdpMessageCodec.a.b(RtpCdpMessageCodec.Reason.INVALID_MJPEG_ENVELOPE);
        goto L240
    L120:
        r61 = false;
    L114:
        r59 = false;
    L174:
        r60 = null;
        goto L175
    L36:
        if ((r14[0] & 255) != 255) goto L40;
        if ((r14[r4] & 255) != 216) goto L40;
        r114 = true;
        goto L41
    L26:
        r15 = false;
    L276:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r22);
    L14:
        r5 = this.this$0.x.iterator();
        r21 = this;
        goto L15
    L11:
        ResultKt.throwOnFailure(r22);
        CompletableDeferred<Unit> r62 = this.this$0.y;
        this.label = 1;
        if (r62.await(this) != r0) goto L14;
        return r0;
    }
}
