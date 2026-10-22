package com.larus.avlink.gallery.thumbnail;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.avlink.impl.databinding.LarusFragmentGalleryDetailBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.mirabridge.api.pluginservice.IDoraPluginService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.thumbnail.GalleryThumbnailFragment$handleSyncButtonClick$2", f = "GalleryThumbnailFragment.kt", i = {}, l = {644}, m = "invokeSuspend", n = {}, s = {})
public final class GalleryThumbnailFragment$handleSyncButtonClick$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Long> $selectedUuids;
    int label;
    final /* synthetic */ GalleryThumbnailFragment this$0;

    public GalleryThumbnailFragment$handleSyncButtonClick$2(GalleryThumbnailFragment r1, List<Long> r2, Continuation<? super GalleryThumbnailFragment$handleSyncButtonClick$2> r3) {
        this.this$0 = r1;
        this.$selectedUuids = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new GalleryThumbnailFragment$handleSyncButtonClick$2(this.this$0, this.$selectedUuids, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_avlink_gallery_thumbnail_GalleryThumbnailFragment$handleSyncButtonClick$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(GalleryThumbnailFragment r1) {
        r1.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        if (((IDoraPluginService) r6) != null) goto L20;
        FLogger.a.e("GalleryThumbnailFragment", "Failed to load Dora plugin service");
        LarusFragmentGalleryDetailBinding r7 = this.this$0.d;
        if (r7 == null) goto L21;
        ConstraintLayout r8 = r7.a;
        if (r8 == null) goto L21;
        Context r9 = r8.getContext();
        if (r9 == null) goto L21;
        t19.s.a.g(r9, 2131903915, false);
    L21:
        int r10 = this.$selectedUuids.size();
        AtomicReference<com.larus.avlink.gallery.l.a> r2 = com.larus.avlink.gallery.l.a;
        List<Long> r3 = this.$selectedUuids;
        Intrinsics.checkNotNullParameter(r3, "selectedUuids");
        com.larus.avlink.gallery.l.a r4 = new com.larus.avlink.gallery.l.a(r10, r3);
        com.larus.avlink.gallery.l.a.set(r4);
        com.larus.avlink.gallery.l.b.postValue(r4);
        FLogger r5 = FLogger.a;
        r5.i("SyncRequestManager", "Set sync request: photoCnt=" + r10 + ", videoCnt=0, uuidCount=" + r3.size());
        r5.i("GalleryThumbnailFragment", "Exiting GalleryThumbnailFragment after storing sync request");
        INVOKEVIRTUAL_com_larus_avlink_gallery_thumbnail_GalleryThumbnailFragment$handleSyncButtonClick$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismiss(this.this$0);
        h0 r11 = this.this$0.r;
        if (r11 == null) goto L25;
        r11.ZA();
    L25:
        return Unit.INSTANCE;
    L20:
        FLogger.a.i("GalleryThumbnailFragment", "Plugin service loaded successfully, starting sync for " + this.$selectedUuids.size() + " thumbnails");
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        com.larus.avlink.gallery.plugin.g r12 = new com.larus.avlink.gallery.plugin.g();
        CoroutineDispatcher r13 = Dispatchers.getIO();
        GalleryThumbnailFragment$handleSyncButtonClick$2$pluginService$1 r14 = new GalleryThumbnailFragment$handleSyncButtonClick$2$pluginService$1(r12, null);
        this.label = 1;
        r6 = BuildersKt.withContext(r13, r14, this);
        if (r6 != r0) goto L12;
        return r0;
    }
}
