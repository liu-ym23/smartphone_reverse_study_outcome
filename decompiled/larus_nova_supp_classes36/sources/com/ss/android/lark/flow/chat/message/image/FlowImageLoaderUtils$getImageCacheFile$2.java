package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryImageType;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.widget.photo.preview.utils.PhotoItemImageType;
import com.ss.android.lark.widget.photo.preview.utils.PhotoUtilsNew;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowImageLoaderUtils$getImageCacheFile$2", f = "FlowImageLoaderUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowImageLoaderUtils$getImageCacheFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ PhotoItem $photoItem;
    final /* synthetic */ GalleryImageType $type;
    int label;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GalleryImageType.values().length];
            r0[GalleryImageType.Thumbnail.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[GalleryImageType.Middle.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[GalleryImageType.Origin.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class b implements com.ss.android.lark.widget.photo.preview.utils.b {
        public b() {
        }

        public final File a(IRequestCreator r2, com.ss.android.lark.image.entity.b r3) {
            Intrinsics.checkNotNullParameter(r2, "requestCreator");
            Intrinsics.checkNotNullParameter(r3, "imageKey");
            f r4 = f.a;
            return f.d(r3);
        }
    }

    public FlowImageLoaderUtils$getImageCacheFile$2(Context r1, GalleryImageType r2, PhotoItem r3, Continuation<? super FlowImageLoaderUtils$getImageCacheFile$2> r4) {
        this.$context = r1;
        this.$type = r2;
        this.$photoItem = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FlowImageLoaderUtils$getImageCacheFile$2(this.$context, this.$type, this.$photoItem, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super File> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r8);
        IRequestCreator r2 = ImageLoader.with(this.$context);
        GalleryImageType r9 = this.$type;
        int r10 = a.a[r9.ordinal()];
        boolean r6 = true;
        if (r10 != 1) goto L7;
        PhotoItemImageType r11 = PhotoItemImageType.Thumbnail;
    L15:
        PhotoUtilsNew r0 = PhotoUtilsNew.a;
        Context r1 = this.$context;
        PhotoItem r3 = this.$photoItem;
        File r12 = r0.d(r1, r2, r3, r11, new b());
        if (r12 != null) goto L18;
    L20:
        r6 = false;
    L21:
        if (r6 == true) goto L27;
        return null;
    L27:
        return r12;
    L18:
        if (r12.exists() != true) goto L20;
    L7:
        if (r10 != 2) goto L9;
        r11 = PhotoItemImageType.Middle;
        goto L15
    L9:
        if (r10 != 3) goto L12;
        r11 = PhotoItemImageType.Origin;
        goto L15
    L12:
        throw new NoWhenBranchMatchedException();
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
