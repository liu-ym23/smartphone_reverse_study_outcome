package com.bytedance.android.ec.core.hybrid.prefetch;

import android.net.Uri;
import com.bytedance.android.ec.core.opt.ab.y;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch$startPrefetchWithMultipleConfig$job$1", f = "NativePrefetch.kt", i = {0, 0, 1, 1, 2, 2, 3, 3}, l = {174, 185, 193, 194}, m = "invokeSuspend", n = {"channel", "channelNum", "channel", "channelNum", "channel", "i", "channel", "i"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "I$0", "L$0", "I$0"})
final class NativePrefetch$startPrefetchWithMultipleConfig$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List $geckoTags;
    final /* synthetic */ JSONObject $requestConfig;
    final /* synthetic */ String $requestId;
    final /* synthetic */ Uri $uri;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ NativePrefetch this$0;

    public NativePrefetch$startPrefetchWithMultipleConfig$job$1(NativePrefetch r1, List r10, Uri r11, String r12, JSONObject r13, Continuation r14) {
        this.this$0 = r1;
        this.$geckoTags = r10;
        this.$uri = r11;
        this.$requestId = r12;
        this.$requestConfig = r13;
        super(2, r14);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        return new NativePrefetch$startPrefetchWithMultipleConfig$job$1(this.this$0, this.$geckoTags, this.$uri, this.$requestId, this.$requestConfig, r11);
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00a9 -> B:41:0x0135). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ed -> B:41:0x0135). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00f1 -> B:41:0x0135). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00f9 -> B:41:0x0135). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0103 -> B:41:0x0135). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0119 -> B:41:0x0135). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x012d -> B:40:0x0130). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x016d -> B:54:0x018d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0189 -> B:53:0x018b). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r22) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L14;
        if (r10 == 1) goto L13;
        if (r10 == 2) goto L12;
        if (r10 == 3) goto L11;
        if (r10 != 4) goto L10;
        int r11 = this.I$1;
        int r12 = this.I$0;
        JSONObject r13 = (JSONObject) this.L$1;
        Channel r14 = (Channel) this.L$0;
        ResultKt.throwOnFailure(r22);
        NativePrefetch$startPrefetchWithMultipleConfig$job$1 r15 = this;
    L53:
        Channel r16 = r14;
        int r17 = r12;
    L54:
        r17 = r17 + 1;
    L43:
        if (r17 >= r11) goto L56;
        r15.L$0 = r16;
        r15.L$1 = null;
        r15.L$2 = null;
        r15.L$3 = null;
        r15.L$4 = null;
        r15.I$0 = r17;
        r15.I$1 = r11;
        r15.label = 3;
        Object r18 = r16.receive(r15);
        if (r18 != r1) goto L47;
        return r1;
    L47:
        JSONObject r19 = (JSONObject) r18;
        if (r19 == null) goto L54;
        CoroutineDispatcher r20 = Dispatchers.getIO();
        NativePrefetch$startPrefetchWithMultipleConfig$job$1$invokeSuspend$$inlined$also$lambda$1 r110 = new NativePrefetch$startPrefetchWithMultipleConfig$job$1$invokeSuspend$$inlined$also$lambda$1(r19, null, r15);
        r15.L$0 = r16;
        r15.L$1 = r19;
        r15.I$0 = r17;
        r15.I$1 = r11;
        r15.label = 4;
        if (BuildersKt.withContext(r20, r110, r15) != r1) goto L52;
        return r1;
    L52:
        r12 = r17;
        r14 = r16;
        goto L53
    L56:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r11 = this.I$1;
        int r21 = this.I$0;
        Channel r23 = (Channel) this.L$0;
        ResultKt.throwOnFailure(r22);
        r15 = this;
        r16 = r23;
        r17 = r21;
        r18 = r22;
        goto L47
    L12:
        String r24 = (String) this.L$4;
        y.c r25 = (y.c) this.L$3;
        Iterator r26 = (Iterator) this.L$2;
        Ref.IntRef r27 = (Ref.IntRef) this.L$1;
        r16 = (Channel) this.L$0;
        ResultKt.throwOnFailure(r22);
        r15 = this;
    L40:
        r27.element++;
    L16:
        if (r26.hasNext() == false) goto L42;
        String r111 = (String) r26.next();
        if (Intrinsics.areEqual(r111, "default") == false) goto L26;
        NativePrefetch r112 = r15.this$0;
        p r113 = NativePrefetch.i;
        JSONObject r114 = r112.z(null);
        if (r114 == null) goto L22;
        NativePrefetch.e(r15.this$0, r114, r15.$uri, 2, r15.$requestId, r15.$requestConfig);
        goto L16
    L22:
        NativePrefetch r28 = r15.this$0;
        Uri r115 = r15.$uri;
        r15.L$0 = r16;
        r15.L$1 = r27;
        r15.L$2 = r26;
        r15.L$3 = null;
        r15.L$4 = null;
        r15.label = 1;
        if (NativePrefetch.d(r28, r115, r16, r15) != r1) goto L25;
        return r1;
    L25:
        r27.element++;
        goto L16
    L26:
        NativePrefetch r29 = r15.this$0;
        p r116 = NativePrefetch.i;
        y.b r30 = r29.o().get(r15.this$0.f);
        if (r30 == null) goto L16;
        Map<String, y.c> r31 = r30.j;
        if (r31 == null) goto L16;
        y.c r32 = r31.get(r111);
        if (r32 == null) goto L16;
        JSONObject r117 = r15.this$0.z(r32);
        if (r117 == null) goto L35;
        NativePrefetch.e(r15.this$0, r117, r15.$uri, 2, r15.$requestId, r15.$requestConfig);
        goto L16
    L35:
        String r118 = r32.b();
        if (r118 == null) goto L16;
        NativePrefetch r119 = r15.this$0;
        r15.L$0 = r16;
        r15.L$1 = r27;
        r15.L$2 = r26;
        r15.L$3 = r32;
        r15.L$4 = r118;
        r15.label = 2;
        if (r119.m(r118, r16, r15) != r1) goto L40;
        return r1;
    L42:
        ConcurrentHashMap<String, NativePrefetch> r33 = NativePrefetchUtil.a;
        NativePrefetchUtil.k("NativePrefetch", "send get gecko request end, channel num is " + r27.element);
        r11 = r27.element;
        r17 = 0;
        goto L43
    L13:
        r26 = (Iterator) this.L$2;
        r27 = (Ref.IntRef) this.L$1;
        r16 = (Channel) this.L$0;
        ResultKt.throwOnFailure(r22);
        r15 = this;
        r27.element++;
        goto L16
    L14:
        ResultKt.throwOnFailure(r22);
        Channel r34 = ChannelKt.Channel$default(0, 1, null);
        r27 = new Ref.IntRef();
        r27.element = 0;
        r15 = this;
        r16 = r34;
        r26 = this.$geckoTags.iterator();
        goto L16
    }
}
