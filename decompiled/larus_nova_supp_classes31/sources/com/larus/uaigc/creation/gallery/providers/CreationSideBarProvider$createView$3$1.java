package com.larus.uaigc.creation.gallery.providers;

import com.larus.im.bean.message.Message;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.tencent.open.log.TraceLevel;
import java.util.List;
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
import kotlin.jvm.functions.Function5;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationSideBarProvider$createView$3$1", f = "CreationSideBarProvider.kt", i = {0}, l = {66, 74}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class CreationSideBarProvider$createView$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ nr9.g $videoPlayData;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreationSideBarProvider this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.creation.gallery.providers.CreationSideBarProvider$createView$3$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationSideBarProvider$createView$3$1$1", f = "CreationSideBarProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UserCreationFromIM $creation;
        final /* synthetic */ UserCreationRefContent $creationRefContent;
        final /* synthetic */ nr9.g $videoPlayData;
        int label;
        final /* synthetic */ CreationSideBarProvider this$0;

        public AnonymousClass1(CreationSideBarProvider r1, nr9.g r2, UserCreationFromIM r3, UserCreationRefContent r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$videoPlayData = r2;
            this.$creation = r3;
            this.$creationRefContent = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$videoPlayData, this.$creation, this.$creationRefContent, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L33;
            ResultKt.throwOnFailure(r8);
            Function5 r0 = this.this$0.f.f.f;
            if (r0 == null) goto L31;
            nr9.g r1 = this.$videoPlayData;
            UserCreationFromIM r9 = this.$creation;
            Message r2 = null;
            if (r9 == null) goto L9;
            String r10 = r9.getPrompt();
        L10:
            UserCreationRefContent r3 = this.$creationRefContent;
            if (r3 == null) goto L19;
            List<ImageInfo> r4 = r3.a();
            if (r4 == null) goto L19;
            ImageInfo r5 = (ImageInfo) CollectionsKt.firstOrNull(r4);
            if (r5 == null) goto L19;
            Image r6 = r5.c;
            if (r6 == null) goto L19;
            String r7 = r6.a;
        L20:
            Object r11 = ((com.larus.gallery.api.t) this.this$0).d;
            sz9.b r12 = (sz9.b) r11;
            if (r12 == null) goto L25;
            zo8.e r13 = r12.d;
            if (r13 == null) goto L25;
            String r14 = r13.k;
        L26:
            sz9.b r15 = (sz9.b) r11;
            if (r15 == null) goto L29;
            r2 = r15.a;
        L29:
            r0.invoke(r1, r10, r7, r14, r2);
        L25:
            r14 = null;
        L19:
            r7 = null;
            goto L20
        L9:
            r10 = null;
        L31:
            return Unit.INSTANCE;
        L33:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CreationSideBarProvider$createView$3$1(CreationSideBarProvider r1, nr9.g r2, Continuation<? super CreationSideBarProvider$createView$3$1> r3) {
        this.this$0 = r1;
        this.$videoPlayData = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        CreationSideBarProvider$createView$3$1 r0 = new CreationSideBarProvider$createView$3$1(this.this$0, this.$videoPlayData, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L45:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
    L23:
        UserCreationFromIM r8 = (UserCreationFromIM) r12;
        if (r8 == null) goto L40;
        String r13 = r8.getRefContent();
        if (r13 == null) goto L40;
        if ((!StringsKt.isBlank(r13)) == true) goto L31;
        r13 = null;
    L31:
        if (r13 == null) goto L40;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L34
        Object r14 = Result.constructor-impl((UserCreationRefContent) xt7.d.b.c(UserCreationRefContent.Companion.serializer(), r13));     // Catch: Throwable -> L34
    L37:
        if (Result.isFailure-impl(r14) == false) goto L39;
        r14 = null;
    L39:
        UserCreationRefContent r9 = (UserCreationRefContent) r14;
    L41:
        MainCoroutineDispatcher r15 = Dispatchers.getMain();
        AnonymousClass1 r4 = new AnonymousClass1(this.this$0, this.$videoPlayData, r8, r9, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(r15, r4, this) != r0) goto L45;
        return r0;
    L34:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L40:
        r9 = null;
        goto L41
    L10:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        CreationGalleryUtil r6 = CreationGalleryUtil.a;
        sz9.b r7 = (sz9.b) ((com.larus.gallery.api.t) this.this$0).d;
        if (r7 == null) goto L15;
        Message r10 = r7.a;
        if (r10 == null) goto L15;
        String r11 = r10.getMessageId();
    L16:
        sz9.b r17 = (sz9.b) ((com.larus.gallery.api.t) this.this$0).d;
        if (r17 == null) goto L19;
        String r18 = sz9.d.a(r17);
    L20:
        this.L$0 = r16;
        this.label = 1;
        r12 = r6.e(r11, r18, this);
        if (r12 != r0) goto L23;
        return r0;
    L19:
        r18 = null;
    L15:
        r11 = null;
        goto L16
    }
}
