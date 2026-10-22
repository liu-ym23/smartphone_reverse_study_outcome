package com.larus.photopicker.v2.impl;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentGalleryBinding;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaListBinding;
import com.larus.photopicker.v2.impl.databinding.LarusFragmentMediaSelectorBinding;
import com.larus.photopicker.v2.impl.ui.MediaListAdapterV2;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.photopicker.v2.impl.MediaGalleryFragment$refreshMediaDataAndSelectNewItem$1$1$1", f = "MediaGalleryFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MediaGalleryFragment$refreshMediaDataAndSelectNewItem$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ mp9.c $newPhotoItem;
    int label;
    final /* synthetic */ MediaGalleryFragment this$0;

    public MediaGalleryFragment$refreshMediaDataAndSelectNewItem$1$1$1(MediaGalleryFragment r1, mp9.c r2, Continuation<? super MediaGalleryFragment$refreshMediaDataAndSelectNewItem$1$1$1> r3) {
        this.this$0 = r1;
        this.$newPhotoItem = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MediaGalleryFragment$refreshMediaDataAndSelectNewItem$1$1$1(this.this$0, this.$newPhotoItem, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L49;
        ResultKt.throwOnFailure(r7);
        MediaGalleryFragment r8 = this.this$0;
        int r0 = MediaGalleryFragment.n;
        if (r8.Y90().insertMediaItemAndSelect(this.$newPhotoItem) == false) goto L47;
        MediaGalleryFragment r9 = this.this$0;
        if (r9.isAdded() == true) goto L9;
    L45:
        e0.d("MediaGalleryFragment", "scrollToTop skipped: fragment is not available");
        goto L47
    L9:
        if (r9.getView() == null) goto L45;
        FragmentManager r1 = r9.getChildFragmentManager();
        LarusFragmentGalleryBinding r10 = r9.g;
        MediaListAdapterV2 r2 = null;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L14:
        Fragment r11 = r1.findFragmentById(r10.g.getId());
        if ((r11 instanceof MediaSelectorFragment) == false) goto L17;
        MediaSelectorFragment r12 = (MediaSelectorFragment) r11;
    L18:
        if (r12 == null) goto L47;
        LarusFragmentMediaSelectorBinding r3 = r12.f;
        if (r3 == null) goto L47;
        int r4 = r3.g.getCurrentItem();
        Fragment r13 = r12.getChildFragmentManager().findFragmentByTag("f" + r4);
        if ((r13 instanceof MediaSelectorListFragment) == false) goto L25;
        MediaSelectorListFragment r14 = (MediaSelectorListFragment) r13;
    L26:
        if (r14 == null) goto L47;
        LarusFragmentMediaListBinding r5 = r14.f;
        if (r5 == null) goto L47;
        if (r14.g == null) goto L47;
        GridLayoutManager r6 = r5.c.getLayoutManager();
        if ((r6 instanceof GridLayoutManager) == false) goto L40;
        GridLayoutManager r15 = r6;
        MediaListAdapterV2 r16 = r14.g;
        if (r16 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("myAdapter");
    L39:
        r15.scrollToPositionWithOffset(r2.z2(0), 0);
        goto L47
    L38:
        r2 = r16;
        goto L39
    L40:
        RecyclerView r17 = r5.c;
        MediaListAdapterV2 r18 = r14.g;
        if (r18 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("myAdapter");
    L44:
        r17.scrollToPosition(r2.z2(0));
        goto L47
    L43:
        r2 = r18;
        goto L44
    L25:
        r14 = null;
        goto L26
    L17:
        r12 = null;
    L47:
        return Unit.INSTANCE;
    L49:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
