package com.obric.assistant.card.layout.viewholder;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.bmhome.chat.layout.widget.AtMostHeightRecyclerView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.databinding.ObricCardPhotoGridContainerBinding;
import com.obric.assistant.card.databinding.ObricCardPhotoGridItemBinding;
import com.obric.assistant.card.layout.adapter.AppEntityListAdapter;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder;
import com.obric.assistant.card.provider.PrivilegedUriProvider;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.enums.AssetTypeEnum;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u001d\u001e\u001fB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/obric/assistant/card/layout/viewholder/AlbumGridViewHolder;", "Lcom/obric/assistant/card/layout/viewholder/abs/AbsCardItemViewHolder;", "Lcom/obric/assistant/card/layout/bean/wrapper/PhotoEntityGridStyleWrapper;", "Lcom/obric/assistant/card/databinding/ObricCardPhotoGridContainerBinding;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "defaultPaddingStart", NameKeys.UnloadStrategy_No_Strategy, "defaultPaddingTop", "defaultPaddingEnd", "defaultPaddingBottom", "itemGap", "getItemGap", "()I", "itemGap$delegate", "Lkotlin/Lazy;", "onBind", NameKeys.UnloadStrategy_No_Strategy, "messageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "entity", "position", "isDeleted", NameKeys.UnloadStrategy_No_Strategy, "isRefreshed", "Companion", "MyAdapter", "MyViewHolder", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlbumGridViewHolder extends AbsCardItemViewHolder<mca.c, ObricCardPhotoGridContainerBinding> {
    public static final Companion p = null;
    public final AtMostHeightRecyclerView j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final Lazy o;

    public static final class Companion {
        public Companion() {
        }

        public static Uri b(PhotoEntity r2) {
            Intrinsics.checkNotNullParameter(r2, "photoEntity");
            if (r2.getAssetType() != AssetTypeEnum.VIDEO) goto L5;
            boolean r0 = true;
        L6:
            int r1 = PrivilegedUriProvider.b;
            return PrivilegedUriProvider.a.a(r2.getFile().getContentUrl(), r2.getPackageName(), r0, r0);
        L5:
            r0 = false;
            goto L6
        }

        public static ImageRequestBuilder a(ImageRequestBuilder r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "builder");
            return r1.setResizeOptions(new ResizeOptions(r2, r2)).setImageDecodeOptions(ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.RGB_565).build());
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0083 -> B:25:0x004d). Please report as a decompilation issue!!! */
        public final Object c(final int r12, List<PhotoEntity> r13, Continuation<? super Unit> r14) {
            if ((r14 instanceof AlbumGridViewHolder$Companion$prefetchThumbnails$1) == false) goto L7;
            AlbumGridViewHolder$Companion$prefetchThumbnails$1 r0 = (AlbumGridViewHolder$Companion$prefetchThumbnails$1) r14;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r15 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L20;
            if (r3 != 1) goto L19;
            r12 = r0.I$0;
            Iterator r16 = (Iterator) r0.L$0;
            ResultKt.throwOnFailure(r15);     // Catch: Exception -> L14 CancellationException -> L16
            r16 = r16;
        L26:
            if (r16.hasNext() == false) goto L34;
            PhotoEntity r17 = (PhotoEntity) r16.next();
            JobKt.ensureActive(r0.getContext());
            Companion r4 = AlbumGridViewHolder.p;
            String r5 = b(r17).toString();     // Catch: Exception -> L14 CancellationException -> L16
            Function1 r8 = new com.obric.assistant.card.layout.viewholder.b(r12);     // Catch: Exception -> L14 CancellationException -> L16
            r0.L$0 = r16;     // Catch: Exception -> L14 CancellationException -> L16
            r0.I$0 = r12;     // Catch: Exception -> L14 CancellationException -> L16
            r0.label = 1;     // Catch: Exception -> L14 CancellationException -> L16
            if (ImageLoaderKt.A(r5, "obric_chat.cards", null, null, r8, r0, 28) != r2) goto L26;
            return r2;
        L34:
            return Unit.INSTANCE;
        L16:
            e = move-exception;
            throw e;
        L14:
            e = move-exception;
            FLogger.a.w("AlbumGridViewHolder", "prefetch thumbnail failed: " + e.getMessage(), e);
            r16 = r16;
            goto L26
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L20:
            ResultKt.throwOnFailure(r15);
            if (r13.isEmpty() == true) goto L23;
            r16 = r13.iterator();
            goto L26
        L23:
            return Unit.INSTANCE;
        L7:
            r0 = new AlbumGridViewHolder$Companion$prefetchThumbnails$1(this, r14);
            goto L8
        }
    }

    public static final class a extends RecyclerView.Adapter<b> {
        public final AlbumGridViewHolder a;
        public final List<PhotoEntity> b;
        public int c;
        public int d;
        public float e;
        public AppEntityListAdapter.PageType f;
        public MessageExtraForViewHolder g;
        public final Lazy h;

        public final int getItemCount() {
            AppEntityListAdapter.PageType r0 = this.f;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("pageType");
            r0 = null;
        L6:
            if (r0 != AppEntityListAdapter.PageType.ChatPage) goto L10;
            return RangesKt.coerceAtMost(((ArrayList) this.b).size(), 6);
        L10:
            return ((ArrayList) this.b).size();
        }

        public a(AlbumGridViewHolder r10) {
            Intrinsics.checkNotNullParameter(r10, "parentViewHolder");
            this.a = r10;
            this.b = new ArrayList();
            this.c = 1;
            this.d = 1;
            this.g = new MessageExtraForViewHolder(false, false, null, null, null, null, null, 127);
            this.h = LazyKt.lazy(new e(this));
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r12, int r13) {
            final b r14 = (b) r12;
            Intrinsics.checkNotNullParameter(r14, "holder");
            PhotoEntity r0 = (PhotoEntity) ListProtector.get(this.b, r13);
            int r1 = this.c;
            if (r13 >= r1) goto L5;
            boolean r4 = true;
        L7:
            if ((r13 / r1) != (this.d - 1)) goto L9;
            boolean r5 = true;
        L11:
            if ((r13 % r1) != 0) goto L13;
            boolean r2 = true;
        L14:
            int r6 = getItemCount();
            int r7 = this.c;
            if (r6 >= r7) goto L17;
            int r8 = getItemCount() - 1;
        L19:
            if ((r13 % this.c) != r8) goto L21;
            boolean r9 = true;
        L22:
            if (r4 == false) goto L25;
            if (r2 == false) goto L25;
            boolean r10 = true;
        L26:
            if (r4 == false) goto L29;
            if (r9 == false) goto L29;
            boolean r11 = true;
        L30:
            if (r5 == false) goto L33;
            if (r2 == false) goto L33;
            boolean r3 = true;
        L34:
            if (r5 == false) goto L37;
            if (r9 == false) goto L37;
            boolean r15 = true;
        L38:
            r14.getClass();
            if (r3 == false) goto L42;
            if (r15 == false) goto L42;
            int r16 = 2131244345;
        L47:
            r14.a.e.setBackgroundResource(r16);
            if (r10 == false) goto L54;
            if (r11 == false) goto L54;
            if (r3 == false) goto L54;
            if (r15 == false) goto L54;
            r14.a.b.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(this.e));
            r14.a.b.setBackgroundResource(2131244325);
        L69:
            GenericDraweeHierarchy r17 = r14.a.b.getHierarchy();
            ScalingUtils.ScaleType r18 = ScalingUtils.ScaleType.CENTER;
            r17.setPlaceholderImage(2131244340, r18);
            r14.a.b.getHierarchy().setFailureImage(2131244340, r18);
            if (r0.getAssetType() != AssetTypeEnum.VIDEO) goto L72;
            boolean r19 = true;
        L73:
            Companion r20 = AlbumGridViewHolder.p;
            Uri r21 = Companion.b(r0);
            String r22 = r21.toString();
            if (Intrinsics.areEqual(r14.b, r22) == true) goto L76;
            r14.b = r22;
            ImageLoaderKt.x(r14.a.b, r21, "obric_chat.cards", null, new c(r14, this), 4);
        L76:
            ImageView r23 = r14.a.d;
            if (r19 == false) goto L79;
            int r24 = 0;
        L80:
            r23.setVisibility(r24);
            View r25 = r14.a.e;
            if (r19 == false) goto L83;
            int r26 = 0;
        L84:
            r25.setVisibility(r26);
            int r27 = ((ArrayList) this.b).size() - getItemCount();
            if (r13 != (getItemCount() - 1)) goto L87;
            boolean r28 = true;
        L88:
            if (r28 == false) goto L91;
            if (r27 <= 0) goto L91;
            r14.a.c.setVisibility(0);
            r14.a.c.setText(((RecyclerView.ViewHolder) r14).itemView.getContext().getString(2131912015, new Object[]{Integer.valueOf(r27)}));
            e1.d(r14.a.c, new d(this));
        L92:
            this.a.W3(((RecyclerView.ViewHolder) r14).itemView, this.b, r0, r13);
            return;
        L91:
            r14.a.c.setVisibility(8);
            r14.a.c.setOnClickListener(null);
            goto L92
        L87:
            r28 = false;
            goto L88
        L83:
            r26 = 8;
            goto L84
        L79:
            r24 = 8;
            goto L80
        L72:
            r19 = false;
        L54:
            if (r10 == false) goto L57;
            if (r3 == false) goto L57;
            GenericDraweeHierarchy r29 = r14.a.b.getHierarchy();
            float r30 = this.e;
            r29.setRoundingParams(RoundingParams.fromCornersRadii(r30, 0.0f, 0.0f, r30));
            r14.a.b.setBackgroundResource(2131244328);
        L57:
            if (r11 == false) goto L60;
            if (r15 == false) goto L60;
            GenericDraweeHierarchy r31 = r14.a.b.getHierarchy();
            float r32 = this.e;
            r31.setRoundingParams(RoundingParams.fromCornersRadii(0.0f, r32, r32, 0.0f));
            r14.a.b.setBackgroundResource(2131244330);
        L60:
            if (r10 == false) goto L62;
            r14.a.b.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(this.e, 0.0f, 0.0f, 0.0f));
            r14.a.b.setBackgroundResource(2131244331);
            goto L69
        L62:
            if (r11 == false) goto L64;
            r14.a.b.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(0.0f, this.e, 0.0f, 0.0f));
            r14.a.b.setBackgroundResource(2131244332);
            goto L69
        L64:
            if (r3 == false) goto L66;
            r14.a.b.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(0.0f, 0.0f, 0.0f, this.e));
            r14.a.b.setBackgroundResource(2131244326);
            goto L69
        L66:
            if (r15 == false) goto L68;
            r14.a.b.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(0.0f, 0.0f, this.e, 0.0f));
            r14.a.b.setBackgroundResource(2131244327);
            goto L69
        L68:
            r14.a.b.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(0.0f, 0.0f, 0.0f, 0.0f));
            r14.a.b.setBackgroundResource(2131244329);
        L42:
            if (r3 == false) goto L44;
            r16 = 2131244346;
            goto L47
        L44:
            if (r15 == false) goto L46;
            r16 = 2131244347;
            goto L47
        L46:
            r16 = 2131244344;
        L37:
            r15 = false;
        L33:
            r3 = false;
        L29:
            r11 = false;
        L25:
            r10 = false;
            goto L26
        L21:
            r9 = false;
            goto L22
        L17:
            r8 = r7 - 1;
            goto L19
        L13:
            r2 = false;
            goto L14
        L9:
            r5 = false;
            goto L11
        L5:
            r4 = false;
            goto L7
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "parent");
            this.e = r2.getContext().getResources().getDimension(2131167860);
            return new b(ObricCardPhotoGridItemBinding.a(LayoutInflater.from(r2.getContext()), r2));
        }
    }

    public static final class b extends RecyclerView.ViewHolder {
        public final ObricCardPhotoGridItemBinding a;
        public String b;

        public b(ObricCardPhotoGridItemBinding r2) {
            Intrinsics.checkNotNullParameter(r2, "viewBinding");
            super(r2.a);
            this.a = r2;
        }
    }

    static {
        p = new Companion();
    }

    public AlbumGridViewHolder(ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        AtMostHeightRecyclerView r7 = LayoutInflater.from(r6.getContext()).inflate(2131563971, r6, false);
        if (r7 == null) goto L7;
        super(new ObricCardPhotoGridContainerBinding(r7), false);
        AtMostHeightRecyclerView r8 = ((ObricCardPhotoGridContainerBinding) this.a).a;
        this.j = r8;
        this.k = r8.getPaddingStart();
        this.l = r8.getPaddingTop();
        this.m = r8.getPaddingEnd();
        this.n = r8.getPaddingBottom();
        this.o = LazyKt.lazy(new com.obric.assistant.card.layout.viewholder.a(this));
        r8.setAdapter(new a(this));
        r8.setLayoutManager(new GridLayoutManager(getContext(), 3, 1, false));
        r8.setHasFixedSize(true);
        r8.addItemDecoration(new AnonymousClass1(this));
        return;
    L7:
        throw new NullPointerException("rootView");
    }

    public static final int X3(AlbumGridViewHolder r0) {
        return ((Number) r0.o.getValue()).intValue();
    }

    @Override // com.obric.assistant.card.layout.viewholder.abs.AbsCardItemViewHolder
    public final void T3(MessageExtraForViewHolder r8, mca.c r9, int r10, boolean r11, boolean r12) {
        mca.c r13 = r9;
        Intrinsics.checkNotNullParameter(r8, "messageExtra");
        Intrinsics.checkNotNullParameter(r13, "entity");
        AppEntityListAdapter.PageType r14 = this.f;
        AppEntityListAdapter.PageType r15 = null;
        if (r14 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("pageType");
        r14 = null;
    L6:
        int r2 = 1;
        if (r14 != AppEntityListAdapter.PageType.ShowAllPage) goto L9;
        boolean r16 = true;
    L10:
        AtMostHeightRecyclerView r1 = this.j;
        if (r16 == false) goto L13;
        int r4 = 0;
    L14:
        if (r16 == false) goto L16;
        int r5 = 0;
    L17:
        if (r16 == false) goto L19;
        int r6 = 0;
    L20:
        if (r16 == false) goto L22;
        int r17 = 0;
    L23:
        r1.setPaddingRelative(r4, r5, r6, r17);
        RecyclerView.Adapter r18 = this.j.getAdapter();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.obric.assistant.card.layout.viewholder.AlbumGridViewHolder.MyAdapter");
        a r19 = (a) r18;
        Collection r20 = r13.a;
        AppEntityListAdapter.PageType r3 = this.f;
        if (r3 == null) goto L26;
        r15 = r3;
    L27:
        r19.getClass();
        Intrinsics.checkNotNullParameter(r20, "photoList");
        Intrinsics.checkNotNullParameter(r15, "pageType");
        Intrinsics.checkNotNullParameter(r8, "messageExtra");
        r19.f = r15;
        r19.g = r8;
        ((ArrayList) r19.b).clear();
        ((ArrayList) r19.b).addAll(r20);
        r19.c = 3;
        int r21 = r19.getItemCount() / 3;
        if ((r19.getItemCount() % 3) != 0) goto L30;
        r2 = 0;
    L30:
        r19.d = r21 + r2;
        r19.notifyDataSetChanged();
        return;
    L26:
        Intrinsics.throwUninitializedPropertyAccessException("pageType");
        goto L27
    L22:
        r17 = this.n;
        goto L23
    L19:
        r6 = this.m;
        goto L20
    L16:
        r5 = this.l;
        goto L17
    L13:
        r4 = this.k;
        goto L14
    L9:
        r16 = false;
        goto L10
    }
}
