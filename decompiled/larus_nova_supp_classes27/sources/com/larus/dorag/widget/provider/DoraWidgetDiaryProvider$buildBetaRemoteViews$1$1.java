package com.larus.dorag.widget.provider;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dorag.widget.provider.DoraWidgetDiaryProvider$buildBetaRemoteViews$1$1", f = "DoraWidgetDiaryProvider.kt", i = {}, l = {548, 551}, m = "invokeSuspend", n = {}, s = {})
final class DoraWidgetDiaryProvider$buildBetaRemoteViews$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $appWidgetId;
    final /* synthetic */ AppWidgetManager $appWidgetManager;
    final /* synthetic */ Context $context;
    final /* synthetic */ Pair<Integer, Integer> $coverSizeDp;
    final /* synthetic */ String $coverUrl;
    final /* synthetic */ DoraWidgetDiaryProvider $this_run;
    final /* synthetic */ RemoteViews $views;
    int label;

    /* JADX INFO: renamed from: com.larus.dorag.widget.provider.DoraWidgetDiaryProvider$buildBetaRemoteViews$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dorag.widget.provider.DoraWidgetDiaryProvider$buildBetaRemoteViews$1$1$1", f = "DoraWidgetDiaryProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $appWidgetId;
        final /* synthetic */ AppWidgetManager $appWidgetManager;
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ Context $context;
        final /* synthetic */ RemoteViews $views;
        int label;

        public AnonymousClass1(Bitmap r1, RemoteViews r2, int r3, AppWidgetManager r4, Context r5, Continuation<? super AnonymousClass1> r6) {
            this.$bitmap = r1;
            this.$views = r2;
            this.$appWidgetId = r3;
            this.$appWidgetManager = r4;
            this.$context = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.$bitmap, this.$views, this.$appWidgetId, this.$appWidgetManager, this.$context, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r4);
            Bitmap r5 = this.$bitmap;
            if (r5 == null) goto L7;
            this.$views.setImageViewBitmap(2131369009, r5);
        L8:
            int r6 = this.$appWidgetId;
            if (r6 == 0) goto L11;
            this.$appWidgetManager.updateAppWidget(r6, this.$views);
        L13:
            return Unit.INSTANCE;
        L11:
            int[] r7 = this.$appWidgetManager.getAppWidgetIds(new ComponentName(this.$context, DoraWidgetDiaryProvider.class));
            this.$appWidgetManager.updateAppWidget(r7, this.$views);
            goto L13
        L7:
            this.$views.setViewVisibility(2131369009, 8);
            goto L8
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DoraWidgetDiaryProvider$buildBetaRemoteViews$1$1(String r1, Pair<Integer, Integer> r2, DoraWidgetDiaryProvider r3, RemoteViews r4, int r5, AppWidgetManager r6, Context r7, Continuation<? super DoraWidgetDiaryProvider$buildBetaRemoteViews$1$1> r8) {
        this.$coverUrl = r1;
        this.$coverSizeDp = r2;
        this.$this_run = r3;
        this.$views = r4;
        this.$appWidgetId = r5;
        this.$appWidgetManager = r6;
        this.$context = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new DoraWidgetDiaryProvider$buildBetaRemoteViews$1$1(this.$coverUrl, this.$coverSizeDp, this.$this_run, this.$views, this.$appWidgetId, this.$appWidgetManager, this.$context, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L26
    L29:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L26
    L16:
        Bitmap r12 = (Bitmap) r11;     // Catch: Exception -> L26
        if (r12 == null) goto L19;
        Bitmap r13 = DoraWidgetDiaryProvider.a(this.$this_run, r12, this.$coverSizeDp);     // Catch: Exception -> L26
    L20:
        Bitmap r4 = r13;
        if (r4 == null) goto L23;
        DoraWidgetDiaryProvider$a.a r14 = DoraWidgetDiaryProvider.a;     // Catch: Exception -> L26
        DoraWidgetDiaryProvider.a = new DoraWidgetDiaryProvider$a.a(this.$coverUrl, this.$coverSizeDp, r4);     // Catch: Exception -> L26
    L23:
        MainCoroutineDispatcher r15 = Dispatchers.getMain();     // Catch: Exception -> L26
        AnonymousClass1 r2 = new AnonymousClass1(r4, this.$views, this.$appWidgetId, this.$appWidgetManager, this.$context, null);     // Catch: Exception -> L26
        this.label = 2;     // Catch: Exception -> L26
        if (BuildersKt.withContext(r15, r2, this) != r0) goto L29;
        return r0;
    L19:
        r13 = null;
        goto L20
    L12:
        ResultKt.throwOnFailure(r11);
        String r16 = this.$coverUrl;     // Catch: Exception -> L26
        this.label = 1;     // Catch: Exception -> L26
        r11 = ImageLoaderKt.k(r16, "DoraWidgetDiaryBetaCover", null, null, this, 60);     // Catch: Exception -> L26
        if (r11 != r0) goto L16;
        return r0;
    L26:
        e = move-exception;
        FLogger.a.e("DoraWidgetDiaryProvider", "Failed to load diary beta cover", e);
        goto L29
    }
}
