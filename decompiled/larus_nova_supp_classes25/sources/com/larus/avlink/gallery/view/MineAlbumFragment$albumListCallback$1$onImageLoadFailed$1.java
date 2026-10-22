package com.larus.avlink.gallery.view;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.gallery.executor.MediaSyncExecutor;
import com.larus.avlink.gallery.storage.GalleryStoragePolicyManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.view.MineAlbumFragment$albumListCallback$1$onImageLoadFailed$1", f = "MineAlbumFragment.kt", i = {}, l = {307}, m = "invokeSuspend", n = {}, s = {})
final class MineAlbumFragment$albumListCallback$1$onImageLoadFailed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $bindingAdapterPosition;
    final /* synthetic */ com.larus.bmhome.bigimg.t1 $item;
    int label;
    final /* synthetic */ MineAlbumFragment.e this$0;
    final /* synthetic */ MineAlbumFragment this$1;

    /* JADX INFO: renamed from: com.larus.avlink.gallery.view.MineAlbumFragment$albumListCallback$1$onImageLoadFailed$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.view.MineAlbumFragment$albumListCallback$1$onImageLoadFailed$1$1", f = "MineAlbumFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $bindingAdapterPosition;
        int label;
        final /* synthetic */ MineAlbumFragment this$0;

        public AnonymousClass1(MineAlbumFragment r1, int r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$bindingAdapterPosition = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$bindingAdapterPosition, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.avlink.gallery.view.q1, kotlin.jvm.functions.Function0] */
        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L17;
            ResultKt.throwOnFailure(r4);
            final MineAlbumFragment r5 = this.this$0;
            AlbumListAdapter r0 = r5.m;
            if (r0 == null) goto L14;
            int r1 = this.$bindingAdapterPosition;
            ?? r2 = new q1(r5);
            if (r1 >= 0) goto L9;
        L12:
            r2.invoke();
        L18:
            return Unit.INSTANCE;
        L9:
            if (r1 >= r0.c.size()) goto L12;
            List<com.larus.bmhome.bigimg.t1> r6 = r0.y2();
            ListProtector.remove(r6, r1);
            r0.c = r6;
            r0.submitList(r6, new e(r2));
            goto L18
        L14:
            return null;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MineAlbumFragment$albumListCallback$1$onImageLoadFailed$1(com.larus.bmhome.bigimg.t1 r1, MineAlbumFragment.e r2, MineAlbumFragment r3, int r4, Continuation<? super MineAlbumFragment$albumListCallback$1$onImageLoadFailed$1> r5) {
        this.$item = r1;
        this.this$0 = r2;
        this.this$1 = r3;
        this.$bindingAdapterPosition = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MineAlbumFragment$albumListCallback$1$onImageLoadFailed$1(this.$item, this.this$0, this.this$1, this.$bindingAdapterPosition, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = this.label;
        if (r6 == 0) goto L9;
        if (r6 != 1) goto L8;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L40
    L43:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);
        PolarisFileWrapper r14 = new PolarisFileWrapper(this.$item.getPath());     // Catch: Exception -> L40
        GalleryStoragePolicyManager r7 = GalleryStoragePolicyManager.a;     // Catch: Exception -> L40
        String r9 = this.$item.getPath();     // Catch: Exception -> L40
        r7.getClass();     // Catch: Exception -> L40
        boolean r8 = false;
        if (r9 != null) goto L13;
    L16:
        boolean r10 = true;
    L18:
        if (r10 == false) goto L20;
        boolean r11 = false;
    L21:
        if (r11 == false) goto L25;
        FLogger.a.i("MineAlbumFragment", "Skip deleting retained source after image load failed: " + this.$item.getPath());     // Catch: Exception -> L40
        return Unit.INSTANCE;
    L25:
        if (r14.exists() == true) goto L27;
    L35:
        FLogger.a.e("MineAlbumFragment", "Failed to delete file: " + this.$item.getPath());     // Catch: Exception -> L40
    L36:
        if (r8 == false) goto L43;
        MainCoroutineDispatcher r15 = Dispatchers.getMain();     // Catch: Exception -> L40
        AnonymousClass1 r0 = new AnonymousClass1(this.this$1, this.$bindingAdapterPosition, null);     // Catch: Exception -> L40
        this.label = 1;     // Catch: Exception -> L40
        if (BuildersKt.withContext(r15, r0, this) != r5) goto L43;
        return r5;
    L27:
        if (r14.delete() == false) goto L35;
        FLogger r16 = FLogger.a;     // Catch: Exception -> L40
        r16.i("MineAlbumFragment", "Successfully deleted corrupted file: " + this.$item.getPath());     // Catch: Exception -> L40
        MineAlbumFragment.e r2 = this.this$0;     // Catch: Exception -> L40
        String r3 = this.$item.getPath();     // Catch: Exception -> L40
        r2.getClass();     // Catch: Exception -> L40
        String r4 = (String) BuildersKt.runBlocking$default(null, new MineAlbumFragment$albumListCallback$1$extractMediaIdFromFilePath$1(r3, null), 1, null);     // Catch: Exception -> L40
        if (r4 != null) goto L45;
    L34:
        r8 = true;
        goto L36
    L45:
        MediaSyncExecutor r12 = MediaSyncExecutor.a;     // Catch: Exception -> L32
        MediaSyncExecutor.d(new String[]{r4});     // Catch: Exception -> L32
        r16.i("MineAlbumFragment", "Deleted from album: ".concat(r4));     // Catch: Exception -> L32
    L32:
        e = move-exception;
        FLogger.a.w("MineAlbumFragment", "Failed to delete from album: " + e.getMessage());     // Catch: Exception -> L40
        goto L34
    L20:
        r11 = GalleryStoragePolicyManager.p(new PolarisFileWrapper(r9), null);     // Catch: Exception -> L40
        goto L21
    L13:
        if (StringsKt.isBlank(r9) == true) goto L16;
        r10 = false;
    L40:
        e = move-exception;
        FLogger.a.e("MineAlbumFragment", "Error handling failed image deletion: " + e.getMessage(), e);
        goto L43
    }
}
