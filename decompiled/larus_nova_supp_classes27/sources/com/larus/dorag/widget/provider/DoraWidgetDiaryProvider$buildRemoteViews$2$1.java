package com.larus.dorag.widget.provider;

import android.appwidget.AppWidgetManager;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.larus.dorag.widget.provider.DoraWidgetDiaryProvider$buildRemoteViews$2$1", f = "DoraWidgetDiaryProvider.kt", i = {}, l = {418, 420}, m = "invokeSuspend", n = {}, s = {})
final class DoraWidgetDiaryProvider$buildRemoteViews$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int[] $appWidgetIds;
    final /* synthetic */ AppWidgetManager $appWidgetManager;
    final /* synthetic */ String $emotionUrl;
    final /* synthetic */ RemoteViews $views;
    int label;

    /* JADX INFO: renamed from: com.larus.dorag.widget.provider.DoraWidgetDiaryProvider$buildRemoteViews$2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dorag.widget.provider.DoraWidgetDiaryProvider$buildRemoteViews$2$1$1", f = "DoraWidgetDiaryProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int[] $appWidgetIds;
        final /* synthetic */ AppWidgetManager $appWidgetManager;
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ RemoteViews $views;
        int label;

        public AnonymousClass1(RemoteViews r1, Bitmap r2, AppWidgetManager r3, int[] r4, Continuation<? super AnonymousClass1> r5) {
            this.$views = r1;
            this.$bitmap = r2;
            this.$appWidgetManager = r3;
            this.$appWidgetIds = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$views, this.$bitmap, this.$appWidgetManager, this.$appWidgetIds, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            this.$views.setImageViewBitmap(2131369038, this.$bitmap);
            this.$appWidgetManager.updateAppWidget(this.$appWidgetIds, this.$views);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DoraWidgetDiaryProvider$buildRemoteViews$2$1(String r1, RemoteViews r2, AppWidgetManager r3, int[] r4, Continuation<? super DoraWidgetDiaryProvider$buildRemoteViews$2$1> r5) {
        this.$emotionUrl = r1;
        this.$views = r2;
        this.$appWidgetManager = r3;
        this.$appWidgetIds = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraWidgetDiaryProvider$buildRemoteViews$2$1(this.$emotionUrl, this.$views, this.$appWidgetManager, this.$appWidgetIds, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L21
    L24:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L21
    L16:
        Bitmap r5 = (Bitmap) r10;     // Catch: Exception -> L21
        if (r5 == null) goto L24;
        MainCoroutineDispatcher r11 = Dispatchers.getMain();     // Catch: Exception -> L21
        AnonymousClass1 r2 = new AnonymousClass1(this.$views, r5, this.$appWidgetManager, this.$appWidgetIds, null);     // Catch: Exception -> L21
        this.label = 2;     // Catch: Exception -> L21
        if (BuildersKt.withContext(r11, r2, this) != r0) goto L24;
        return r0;
    L12:
        ResultKt.throwOnFailure(r10);
        String r12 = this.$emotionUrl;     // Catch: Exception -> L21
        this.label = 1;     // Catch: Exception -> L21
        r10 = ImageLoaderKt.k(r12, "DoraWidgetDiaryEmotion", null, null, this, 60);     // Catch: Exception -> L21
        if (r10 != r0) goto L16;
        return r0;
    L21:
        e = move-exception;
        FLogger.a.e("DoraWidgetDiaryProvider", "Failed to load emotion icon", e);
        goto L24
    }
}
