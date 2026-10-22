package com.larus.share.service;

import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/share/service/ShareShortUrlCreateResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.service.ShareShortUrlCreateHelper$createShortUrl$2", f = "ShareShortUrlCreateHelper.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
public final class ShareShortUrlCreateHelper$createShortUrl$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super j>, Object> {
    final /* synthetic */ long $actualTimeoutMs;
    final /* synthetic */ boolean $fallbackToLongUrl;
    final /* synthetic */ String $longUrl;
    final /* synthetic */ JSONObject $shareRecord;
    int label;

    /* JADX INFO: renamed from: com.larus.share.service.ShareShortUrlCreateHelper$createShortUrl$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/share/service/ShareShortUrlCreateResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.share.service.ShareShortUrlCreateHelper$createShortUrl$2$1", f = "ShareShortUrlCreateHelper.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super j>, Object> {
        final /* synthetic */ boolean $fallbackToLongUrl;
        final /* synthetic */ String $longUrl;
        final /* synthetic */ JSONObject $shareRecord;
        int label;

        public AnonymousClass1(String r1, boolean r2, JSONObject r3, Continuation<? super AnonymousClass1> r4) {
            this.$longUrl = r1;
            this.$fallbackToLongUrl = r2;
            this.$shareRecord = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$longUrl, this.$fallbackToLongUrl, this.$shareRecord, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super j> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            y r7 = (com.larus.network.http.a) r6;
            if ((r7 instanceof y) == false) goto L27;
            ShareShortUrlCreateResponse r8 = (ShareShortUrlCreateResponse) ((com.larus.network.http.a) r7).b;
            if (r8 == null) goto L22;
            List<String> r9 = r8.getShortUrls();
            if (r9 == null) goto L22;
            String r10 = (String) CollectionsKt.firstOrNull(r9);
            if (r10 == null) goto L22;
            if ((!StringsKt.isBlank(r10)) == false) goto L22;
        L23:
            if (r10 == null) goto L32;
            Object r2 = new j.b(r10);
        L33:
            return r2;
        L32:
            return new j.a("short url is empty", null, 5);
        L22:
            r10 = null;
            goto L23
        L27:
            if ((r7 instanceof com.larus.network.http.f) == false) goto L31;
            FLogger r3 = FLogger.a;
            StringBuilder r4 = new StringBuilder("create short url failed, code=");
            com.larus.network.http.f r11 = (com.larus.network.http.f) r7;
            r4.append(r11.d.getCode());
            r4.append(", msg=");
            r4.append(r11.d.getMessage());
            r3.w("ShareShortUrlCreateHelper", r4.toString());
            r2 = new j.a(Boxing.boxLong(r11.d.getCode()), r11.d.getMessage(), r11.d);
            goto L33
        L31:
            return new j.a("short url request is incomplete", null, 5);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ShareShortUrlCreateServiceDelegate r12 = ShareShortUrlCreateServiceDelegate.b;
            List<String> r5 = CollectionsKt.listOf(this.$longUrl);
            boolean r13 = this.$fallbackToLongUrl;
            JSONObject r14 = this.$shareRecord;
            this.label = 1;
            r6 = r12.a(r5, r13, r14, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    public ShareShortUrlCreateHelper$createShortUrl$2(long r1, String r3, boolean r4, JSONObject r5, Continuation<? super ShareShortUrlCreateHelper$createShortUrl$2> r6) {
        this.$actualTimeoutMs = r1;
        this.$longUrl = r3;
        this.$fallbackToLongUrl = r4;
        this.$shareRecord = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ShareShortUrlCreateHelper$createShortUrl$2(this.$actualTimeoutMs, this.$longUrl, this.$fallbackToLongUrl, this.$shareRecord, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super j> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        return r9;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        long r3 = this.$actualTimeoutMs;
        AnonymousClass1 r10 = new AnonymousClass1(this.$longUrl, this.$fallbackToLongUrl, this.$shareRecord, null);
        this.label = 1;
        r9 = TimeoutKt.b(r3, r10, this);
        if (r9 != r0) goto L11;
        return r0;
    }
}
