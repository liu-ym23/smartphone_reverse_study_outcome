package com.larus.community.impl.viewholder;

import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.Image;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationFeedType;
import com.larus.platform.api.creation.CreationPublishExtra;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016JJ\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0001\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016Ju\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u000f2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010\u000f2\b\u0010%\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010'R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/community/impl/viewholder/CreationImageToImageViewHolder;", "Lcom/larus/community/impl/viewholder/CreationImageViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getImageInfo", "Lcom/larus/platform/api/ImageInfo;", "creation", "Lcom/larus/platform/api/creation/UserCreation;", "referenceView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "bindData", "", "position", "", "itemWidth", "creationClickCallBack", "Lcom/larus/community/impl/adapter/ICreationClickCallBack;", "lifeCycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "creationFeedType", "initParams", "Lcom/larus/platform/api/creation/CreationFeedInitParams;", "buildReferenceImageDebugLog", "", "stage", "isPrivate", "", "feedRefResize", "resizeOptions", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "targetWidth", "refImageWidth", "", "refImageHeight", "finalWidth", "finalHeight", "error", "(Ljava/lang/String;Lcom/larus/platform/api/creation/UserCreation;ZZLcom/facebook/imagepipeline/common/ResizeOptions;ILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/String;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationImageToImageViewHolder extends CreationImageViewHolder {
    public static final /* synthetic */ int j = 0;
    public SimpleDraweeView i;

    public static final class a extends BaseControllerListener<ImageInfo> {
        public final /* synthetic */ CreationImageToImageViewHolder a;
        public final /* synthetic */ UserCreation b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ com.larus.platform.model.chat.n d;
        public final /* synthetic */ ResizeOptions e;
        public final /* synthetic */ int f;
        public final /* synthetic */ Image g;

        public final void onFailure(String r13, Throwable r14) {
            super.onFailure(r13, r14);
            boolean r15 = m29.a.a;
            CreationImageToImageViewHolder r0 = this.a;
            UserCreation r2 = this.b;
            boolean r3 = this.c;
            boolean r4 = this.d.f;
            ResizeOptions r5 = this.e;
            int r6 = this.f;
            Image r16 = this.g;
            if (r16 == null) goto L5;
            Long r17 = Long.valueOf(r16.c);
        L6:
            Image r8 = this.g;
            if (r8 == null) goto L9;
            Long r9 = Long.valueOf(r8.d);
        L11:
            if (r14 == null) goto L13;
            String r11 = r14.getMessage();
        L14:
            int r18 = CreationImageToImageViewHolder.j;
            m29.a.c("CreationImageToImageViewHolder", r0.X3("failure", r2, r3, r4, r5, r6, r17, r9, null, null, r11));
            return;
        L13:
            r11 = null;
            goto L14
        L9:
            r9 = null;
            goto L11
        L5:
            r17 = null;
            goto L6
        }

        public final void onSubmit(String r12, Object r13) {
            super.onSubmit(r12, r13);
            boolean r14 = m29.a.a;
            CreationImageToImageViewHolder r0 = this.a;
            UserCreation r2 = this.b;
            boolean r3 = this.c;
            boolean r4 = this.d.f;
            ResizeOptions r5 = this.e;
            int r6 = this.f;
            Image r15 = this.g;
            if (r15 == null) goto L5;
            Long r7 = Long.valueOf(r15.c);
        L6:
            Image r16 = this.g;
            if (r16 == null) goto L9;
            Long r8 = Long.valueOf(r16.d);
        L10:
            m29.a.c("CreationImageToImageViewHolder", CreationImageToImageViewHolder.Y3(r0, "submit", r2, r3, r4, r5, r6, r7, r8, null, null));
            return;
        L9:
            r8 = null;
            goto L10
        L5:
            r7 = null;
            goto L6
        }

        public final void onFinalImageSet(String r12, Object r13, Animatable r14) {
            ImageInfo r15 = (ImageInfo) r13;
            super.onFinalImageSet(r12, r15, r14);
            boolean r16 = m29.a.a;
            CreationImageToImageViewHolder r0 = this.a;
            UserCreation r2 = this.b;
            boolean r3 = this.c;
            boolean r4 = this.d.f;
            ResizeOptions r5 = this.e;
            int r6 = this.f;
            Image r17 = this.g;
            if (r17 == null) goto L5;
            Long r7 = Long.valueOf(r17.c);
        L6:
            Image r18 = this.g;
            if (r18 == null) goto L9;
            Long r8 = Long.valueOf(r18.d);
        L10:
            if (r15 == null) goto L12;
            Integer r9 = Integer.valueOf(r15.getWidth());
        L13:
            if (r15 == null) goto L15;
            Integer r10 = Integer.valueOf(r15.getHeight());
        L16:
            m29.a.c("CreationImageToImageViewHolder", CreationImageToImageViewHolder.Y3(r0, "final", r2, r3, r4, r5, r6, r7, r8, r9, r10));
            return;
        L15:
            r10 = null;
            goto L16
        L12:
            r9 = null;
            goto L13
        L9:
            r8 = null;
            goto L10
        L5:
            r7 = null;
            goto L6
        }

        public a(CreationImageToImageViewHolder r1, UserCreation r2, boolean r3, com.larus.platform.model.chat.n r4, ResizeOptions r5, int r6, Image r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    public CreationImageToImageViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    @Override // com.larus.community.impl.viewholder.CreationImageViewHolder
    public final com.larus.platform.api.ImageInfo V3(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "creation");
        UserCreationContent r3 = r2.e;
        if (r3 == null) goto L7;
        UserCreationImage r4 = r3.a;
        if (r4 == null) goto L7;
        return r4.a;
    L7:
        return null;
    }

    @Override // com.larus.community.impl.viewholder.CreationImageViewHolder
    public final void U3(int r16, final UserCreation r17, int r18, g29.i r110, LifecycleCoroutineScope r20, @CreationFeedType int r21, zp9.f r22) {
        boolean r0 = m29.a.a;
        StringBuilder r1 = new StringBuilder("bindData, creationId:");
        String r2 = null;
        if (r17 == null) goto L5;
        String r3 = r17.a;
    L6:
        r1.append(r3);
        m29.a.c("CreationImageToImageViewHolder", r1.toString());
        m29.a.a("CreationImageToImageViewHolder", new j(r17));
        super.U3(r16, r17, r18, r110, r20, r21, r22);
        if (r17 == null) goto L11;
        CreationPublishExtra r4 = r17.p;
        if (r4 == null) goto L11;
        Boolean r5 = r4.b;
    L13:
        if (r5 == null) goto L26;
        CreationPublishExtra r6 = r17.p;
        if (r6 == null) goto L17;
        boolean r7 = Intrinsics.areEqual(r6.b, Boolean.FALSE);
    L18:
        if (r7 == false) goto L26;
        AuthorInfo r8 = r17.g;
        if (r8 == null) goto L22;
        String r9 = r8.b;
    L24:
        if (Intrinsics.areEqual(r9, AccountService.a.getUserId()) == true) goto L26;
        boolean r10 = true;
    L27:
        if (r10 == true) goto L38;
        if (r17 == null) goto L48;
        UserCreationRefContent r11 = r17.o;
        if (r11 == null) goto L48;
        List r12 = r11.a();
        if (r12 == null) goto L48;
        com.larus.platform.api.ImageInfo r13 = (com.larus.platform.api.ImageInfo) CollectionsKt.getOrNull(r12, 0);
        if (r13 == null) goto L48;
        Image r14 = r13.c;
        if (r14 == null) goto L48;
        String r15 = r14.a;
    L49:
        if (r15 != null) goto L51;
    L92:
        StringBuilder r23 = new StringBuilder("creationId:");
        if (r17 == null) goto L95;
        r2 = r17.a;
    L95:
        r23.append(r2);
        r23.append(", has no refContent");
        m29.a.c("CreationImageToImageViewHolder", r23.toString());
        SimpleDraweeView r24 = this.i;
        if (r24 == null) goto L100;
        e1.o(r24);
        return;
    L100:
        return;
    L51:
        if (r15.length() <= 0) goto L53;
        boolean r25 = true;
    L54:
        if (r25 == false) goto L56;
        final String r111 = r15;
    L57:
        if (r111 == null) goto L92;
        final int r26 = r18 / 4;
        if (r17 == null) goto L65;
        UserCreationRefContent r27 = r17.o;
        if (r27 == null) goto L65;
        List r28 = r27.a();
        if (r28 == null) goto L65;
        com.larus.platform.api.ImageInfo r30 = (com.larus.platform.api.ImageInfo) CollectionsKt.getOrNull(r28, 0);
    L66:
        if (r10 == false) goto L69;
        if (r30 == null) goto L72;
        Image r31 = r30.h;
    L71:
        final Image r32 = r31;
    L73:
        final com.larus.platform.model.chat.n r112 = z2.a.getCreationPreviewPerformanceOptConfig();
        if (r112.f == false) goto L77;
        if (r26 <= 1) goto L77;
        ResizeOptions r33 = new ResizeOptions(r26, r26);
    L79:
        if (this.i != null) goto L88;
        SimpleDraweeView r34 = LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()).inflate(2131561970, null, false);
        if (r34 == null) goto L87;
        this.i = r34;
        ConstraintLayout r35 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131375718);
        View r36 = this.i;
        if (r36 == null) goto L85;
        ConstraintLayout.LayoutParams r113 = new ConstraintLayout.LayoutParams(r26, r26);
        r113.topToTop = 0;
        r113.endToEnd = 0;
        r113.setMarginEnd(i5.h());
        ((ViewGroup.MarginLayoutParams) r113).topMargin = i5.h();
        Unit r37 = Unit.INSTANCE;
        r35.addView(r36, r113);
    L85:
        m29.a.c("CreationImageToImageViewHolder", "add leftTopView");
        goto L88
    L87:
        throw new NullPointerException("rootView");
    L88:
        m29.a.a("CreationImageToImageViewHolder", new k(r111, r17));
        SimpleDraweeView r38 = this.i;
        if (r38 == null) goto L91;
        e1.x(r38);
    L91:
        final ResizeOptions r40 = r33;
        final boolean r41 = r10;
        ImageLoaderKt.y(this.i, r111, "CreationImageToImageViewHolder", new l(r40, this, r17, r41, r112, r26, r32), 4);
        return;
    L77:
        r33 = null;
    L72:
        r32 = null;
        goto L73
    L69:
        if (r30 == null) goto L72;
        r31 = r30.c;
    L65:
        r30 = null;
        goto L66
    L56:
        r111 = null;
        goto L57
    L53:
        r25 = false;
    L48:
        r15 = null;
        goto L49
    L38:
        if (r17 == null) goto L48;
        UserCreationRefContent r42 = r17.o;
        if (r42 == null) goto L48;
        List r43 = r42.a();
        if (r43 == null) goto L48;
        com.larus.platform.api.ImageInfo r44 = (com.larus.platform.api.ImageInfo) CollectionsKt.getOrNull(r43, 0);
        if (r44 == null) goto L48;
        Image r45 = r44.h;
        if (r45 == null) goto L48;
        r15 = r45.a;
        goto L49
    L22:
        r9 = null;
        goto L24
    L17:
        r7 = false;
    L26:
        r10 = false;
    L11:
        r5 = null;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public static /* synthetic */ String Y3(CreationImageToImageViewHolder r12, String r13, UserCreation r14, boolean r15, boolean r16, ResizeOptions r17, int r18, Long r110, Long r20, Integer r21, Integer r22) {
        return r12.X3(r13, r14, r15, r16, r17, r18, r110, r20, r21, r22, null);
    }

    public final String X3(String r3, UserCreation r4, boolean r5, boolean r6, ResizeOptions r7, int r8, Long r9, Long r10, Integer r11, Integer r12, String r13) {
        StringBuilder r0 = new StringBuilder("[feed_ref_image_");
        r0.append(r3);
        r0.append("] creationId:");
        Integer r14 = null;
        if (r4 == null) goto L5;
        String r15 = r4.a;
    L6:
        r0.append(r15);
        r0.append(", isPrivate:");
        r0.append(r5);
        r0.append(", feedRefResize:");
        r0.append(r6);
        r0.append(", target:");
        r0.append(r8);
        r0.append('x');
        r0.append(r8);
        r0.append(", resize:");
        if (r7 == null) goto L9;
        Integer r16 = Integer.valueOf(r7.width);
    L10:
        r0.append(r16);
        r0.append('x');
        if (r7 == null) goto L13;
        Integer r17 = Integer.valueOf(r7.height);
    L14:
        r0.append(r17);
        r0.append(", view:");
        SimpleDraweeView r18 = this.i;
        if (r18 == null) goto L17;
        Integer r20 = Integer.valueOf(r18.getWidth());
    L18:
        r0.append(r20);
        r0.append('x');
        SimpleDraweeView r21 = this.i;
        if (r21 == null) goto L21;
        r14 = Integer.valueOf(r21.getHeight());
    L21:
        r0.append(r14);
        r0.append(", source:");
        r0.append(r9);
        r0.append('x');
        r0.append(r10);
        r0.append(", final:");
        r0.append(r11);
        r0.append('x');
        r0.append(r12);
        r0.append(", error:");
        r0.append(r13);
        return r0.toString();
    L17:
        r20 = null;
        goto L18
    L13:
        r17 = null;
        goto L14
    L9:
        r16 = null;
        goto L10
    L5:
        r15 = null;
        goto L6
    }
}
