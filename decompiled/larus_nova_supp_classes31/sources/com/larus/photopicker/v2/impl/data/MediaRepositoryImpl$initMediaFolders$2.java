package com.larus.photopicker.v2.impl.data;

import com.larus.photopicker.v2.impl.e0;
import com.larus.photopicker.v2.impl.model.MediaTab;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import pp9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/photopicker/v2/impl/data/model/MediaFolder;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.photopicker.v2.impl.data.MediaRepositoryImpl$initMediaFolders$2", f = "MediaRepositoryImpl.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
public final class MediaRepositoryImpl$initMediaFolders$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends mp9.b>>, Object> {
    final /* synthetic */ List<MediaTab> $allTabs;
    Object L$0;
    int label;
    final /* synthetic */ MediaRepositoryImpl this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public MediaRepositoryImpl$initMediaFolders$2(MediaRepositoryImpl r1, List<? extends MediaTab> r2, Continuation<? super MediaRepositoryImpl$initMediaFolders$2> r3) {
        this.this$0 = r1;
        this.$allTabs = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MediaRepositoryImpl$initMediaFolders$2(this.this$0, this.$allTabs, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<mp9.b>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r2 = null;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        MediaRepositoryImpl r3 = (MediaRepositoryImpl) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L24
    L15:
        List r13 = (List) r12;     // Catch: Throwable -> L24
        Iterator r4 = r13.iterator();     // Catch: Throwable -> L24
    L17:
        if (r4.hasNext() == false) goto L22;
        mp9.b r5 = (mp9.b) r4.next();     // Catch: Throwable -> L24
        Iterator<Map.Entry<MediaTab, List<mp9.c>>> r6 = r5.f.entrySet().iterator();     // Catch: Throwable -> L24
    L20:
        if (r6.hasNext() == false) goto L17;
        Map.Entry<MediaTab, List<mp9.c>> r7 = r6.next();     // Catch: Throwable -> L24
        r3.f.b(r5.a, r7.getKey(), r7.getValue());     // Catch: Throwable -> L24
        goto L20
    L22:
        r3.g.postValue(r13);     // Catch: Throwable -> L24
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r14) == false) goto L29;
        Object r8 = null;
    L30:
        List r9 = (List) r8;
        if (r9 != null) goto L34;
        r9 = CollectionsKt.emptyList();
    L34:
        if (Result.isSuccess-impl(r14) == false) goto L37;
        Lazy r15 = i.a;
        JSONObject r16 = new JSONObject();
        MediaRepositoryImpl r10 = this.this$0;
        int r11 = r10.e + 1;
        r10.e = r11;
        r16.put("notify_times", r11);
        r16.put("album_size", r9.size());
        r16.put("data_type", "media");
        r16.put("is_success", 1);
        i.b(r16);
    L51:
        return r9;
    L37:
        if (Result.isFailure-impl(r14) == false) goto L51;
        Throwable r17 = Result.exceptionOrNull-impl(r14);
        if (r17 == null) goto L42;
        String r18 = r17.getMessage();
        if (r18 == null) goto L42;
    L47:
        Lazy r19 = i.a;
        JSONObject r20 = new JSONObject();
        MediaRepositoryImpl r21 = this.this$0;
        int r110 = r21.e + 1;
        r21.e = r110;
        r20.put("notify_times", r110);
        r20.put("error_msg", r18);
        r20.put("data_type", "media");
        r20.put("is_success", 0);
        i.b(r20);
        int r22 = e0.a;
        String r23 = this.this$0.c;
        StringBuilder r24 = new StringBuilder("initMediaFolders: An error occurred，");
        if (r17 == null) goto L50;
        r2 = ExceptionsKt.stackTraceToString(r17);
    L50:
        r24.append(r2);
        e0.c(r23, r24.toString());
    L42:
        if (r17 == null) goto L44;
        r18 = r17.getClass().getSimpleName();
    L45:
        if (r18 != null) goto L47;
        r18 = "unknown error";
        goto L47
    L44:
        r18 = null;
        goto L45
    L29:
        r8 = r14;
        goto L30
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r12);
        MediaRepositoryImpl r111 = this.this$0;
        List<MediaTab> r25 = this.$allTabs;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L24
        e r27 = r111.a;     // Catch: Throwable -> L24
        mp9.a r28 = new mp9.a(null, (MediaTab) CollectionsKt.first(r25));     // Catch: Throwable -> L24
        this.L$0 = r111;     // Catch: Throwable -> L24
        this.label = 1;     // Catch: Throwable -> L24
        Object r29 = r27.b(r25, r28, this);     // Catch: Throwable -> L24
        if (r29 != r0) goto L14;
        return r0;
    L14:
        r3 = r111;
        r12 = r29;
    L24:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    }
}
