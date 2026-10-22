package com.larus.avlink.gallery.thumbnail;

import android.os.Handler;
import android.os.Looper;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.avlink.gallery.model.ThumbnailMetadata;
import com.larus.avlink.gallery.viewmodel.ThumbnailViewModel;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.thumbnail.GalleryThumbnailFragment$performDelete$1", f = "GalleryThumbnailFragment.kt", i = {0, 0, 0, 0}, l = {780}, m = "invokeSuspend", n = {"batchDeleteItems", "batchSize", "totalBatches", "batchIndex"}, s = {"L$0", "I$0", "I$1", "I$2"})
final class GalleryThumbnailFragment$performDelete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.common_ui.dialog.l0 $commonLoadDialog;
    final /* synthetic */ List<ThumbnailMetadata> $selectedItems;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    int label;
    final /* synthetic */ GalleryThumbnailFragment this$0;

    public GalleryThumbnailFragment$performDelete$1(com.larus.common_ui.dialog.l0 r1, List<ThumbnailMetadata> r2, GalleryThumbnailFragment r3, Continuation<? super GalleryThumbnailFragment$performDelete$1> r4) {
        this.$commonLoadDialog = r1;
        this.$selectedItems = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new GalleryThumbnailFragment$performDelete$1(this.$commonLoadDialog, this.$selectedItems, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_avlink_gallery_thumbnail_GalleryThumbnailFragment$performDelete$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(com.larus.common_ui.dialog.l0 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void INVOKEVIRTUAL_com_larus_avlink_gallery_thumbnail_GalleryThumbnailFragment$performDelete$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(com.larus.common_ui.dialog.l0 r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x011e -> B:62:0x0121). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r17) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        if (r3 == 0) goto L10;
        if (r3 != 1) goto L9;
        int r0 = this.I$2;
        int r4 = this.I$1;
        int r6 = this.I$0;
        List<ThumbnailMetadata> r7 = (List) this.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L44 Exception -> L46
        Object r10 = r17;
        String r8 = "GalleryThumbnailFragment";
        List<ThumbnailMetadata> r9 = r7;
        GalleryThumbnailFragment$performDelete$1 r11 = this;
    L62:
    L36:
        e = e;
    L48:
        FLogger r5 = FLogger.a;     // Catch: Throwable -> L42
        r5.e(r8, "Error deleting thumbnails: " + e.getMessage(), e);     // Catch: Throwable -> L42
        ConstraintLayout r1 = r11.this$0.h;     // Catch: Throwable -> L42
        if (r1 == null) goto L51;
        r1.setEnabled(true);     // Catch: Throwable -> L42
    L51:
        r5.d("GalleryThumbnailFragment", "Delete button restored");     // Catch: Throwable -> L42
        com.larus.common_ui.dialog.l0 r12 = r11.$commonLoadDialog;
        if (r12 == null) goto L56;
    L54:
        INVOKEVIRTUAL_com_larus_avlink_gallery_thumbnail_GalleryThumbnailFragment$performDelete$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r12);
    L56:
        return Unit.INSTANCE;
    L30:
        if (Intrinsics.areEqual((Boolean) r10, Boxing.boxBoolean(true)) == false) goto L34;
        FLogger.a.i(r8, "deleteAlbum batch " + (r0 + 1) + " result: success");     // Catch: Exception -> L36 Throwable -> L42
        ThumbnailViewModel r13 = r11.this$0.e;     // Catch: Exception -> L36 Throwable -> L42
        if (r13 == null) goto L35;
        r13.deleteSelected(r9);     // Catch: Exception -> L36 Throwable -> L42
    L35:
        r0 = r0 + 1;     // Catch: Exception -> L36 Throwable -> L42
    L15:
        if (r0 >= r4) goto L38;
        int r14 = r0 * r6;
        int r15 = r0 + 1;
        r9 = r11.$selectedItems.subList(r14, Math.min(r15 * r6, r11.$selectedItems.size()));     // Catch: Exception -> L36 Throwable -> L42
        FLogger.a.i(r8, "Deleting batch " + r15 + '/' + r4 + ": " + r9.size() + " items");     // Catch: Exception -> L36 Throwable -> L42
        List<ThumbnailMetadata> r16 = r9;     // Catch: Exception -> L36 Throwable -> L42
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));     // Catch: Exception -> L36 Throwable -> L42
        Iterator<T> r19 = r16.iterator();     // Catch: Exception -> L36 Throwable -> L42
    L19:
        if (r19.hasNext() == false) goto L21;
        r18.add(Boxing.boxLong(((ThumbnailMetadata) r19.next()).getImageUuid()));     // Catch: Exception -> L36 Throwable -> L42
        goto L19
    L21:
        long[] r110 = CollectionsKt.toLongArray(r18);     // Catch: Exception -> L36 Throwable -> L42
        List<ThumbnailMetadata> r111 = r9;     // Catch: Exception -> L36 Throwable -> L42
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));     // Catch: Exception -> L36 Throwable -> L42
        Iterator<T> r113 = r111.iterator();     // Catch: Exception -> L36 Throwable -> L42
    L23:
        if (r113.hasNext() == false) goto L25;
        r112.add(Boxing.boxLong(((ThumbnailMetadata) r113.next()).getCreateTime()));     // Catch: Exception -> L36 Throwable -> L42
        goto L23
    L25:
        long[] r114 = CollectionsKt.toLongArray(r112);     // Catch: Exception -> L36 Throwable -> L42
        CoroutineDispatcher r115 = Dispatchers.getIO();     // Catch: Exception -> L36 Throwable -> L42
        GalleryThumbnailFragment$performDelete$1$result$1 r116 = new GalleryThumbnailFragment$performDelete$1$result$1(r110, r114, null);     // Catch: Exception -> L36 Throwable -> L42
        r11.L$0 = r9;     // Catch: Exception -> L36 Throwable -> L42
        r11.I$0 = r6;     // Catch: Exception -> L36 Throwable -> L42
        r11.I$1 = r4;     // Catch: Exception -> L36 Throwable -> L42
        r11.I$2 = r0;     // Catch: Exception -> L36 Throwable -> L42
        r11.label = 1;     // Catch: Exception -> L36 Throwable -> L42
        r10 = BuildersKt.withContext(r115, r116, r11);     // Catch: Exception -> L36 Throwable -> L42
        if (r10 != r2) goto L62;
        return r2;
    L38:
        FLogger.a.i(r8, "All batches deleted successfully, now deleting local thumbnails");     // Catch: Exception -> L36 Throwable -> L42
        r12 = r11.$commonLoadDialog;
        if (r12 == null) goto L56;
    L34:
        FLogger.a.i(r8, "deleteAlbum batch " + (r0 + 1) + " result: failed");     // Catch: Exception -> L36 Throwable -> L42
        goto L35
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r17);
        com.larus.common_ui.dialog.l0 r20 = this.$commonLoadDialog;
        if (r20 == null) goto L13;
        INVOKEVIRTUAL_com_larus_avlink_gallery_thumbnail_GalleryThumbnailFragment$performDelete$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r20);
    L13:
        FLogger.a.i("GalleryThumbnailFragment", "Starting delete for " + this.$selectedItems.size() + " thumbnails from album");     // Catch: Throwable -> L44 Exception -> L46
        r4 = ((this.$selectedItems.size() + 30) - 1) / 30;     // Catch: Throwable -> L44 Exception -> L46
        r11 = this;
        r8 = "GalleryThumbnailFragment";
        r0 = 0;
        r6 = 30;
    L42:
        th = th;
    L57:
        com.larus.common_ui.dialog.l0 r21 = this.$commonLoadDialog;
        if (r21 == null) goto L60;
        INVOKEVIRTUAL_com_larus_avlink_gallery_thumbnail_GalleryThumbnailFragment$performDelete$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r21);
    L60:
        throw th;
    L46:
        e = e;
        r11 = this;
        r8 = "GalleryThumbnailFragment";
    L44:
        th = th;
        goto L57
    }
}
