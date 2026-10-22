package com.larus.ugc.feed.impl.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.creation.CreationFeedType;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.ugc.feed.api.model.AuthorInfoKmp;
import com.larus.ugc.feed.api.model.CreationPublishExtraKmp;
import com.larus.ugc.feed.api.model.ImageInfoKmp;
import com.larus.ugc.feed.api.model.ImageKmp;
import com.larus.ugc.feed.api.model.ResourceKmp;
import com.larus.ugc.feed.api.model.UserCreationContentKmp;
import com.larus.ugc.feed.api.model.UserCreationImageKmp;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ugc.feed.api.model.UserCreationRefContentKmp;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016JJ\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0001\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/ugc/feed/impl/viewholder/CreationImageToImageViewHolder;", "Lcom/larus/ugc/feed/impl/viewholder/CreationImageViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getImageInfo", "Lcom/larus/ugc/feed/api/model/ImageInfoKmp;", "creation", "Lcom/larus/ugc/feed/api/model/UserCreationKmp;", "referenceView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "bindData", "", "position", "", "itemWidth", "creationClickCallBack", "Lcom/larus/ugc/feed/impl/adapter/ICreationClickCallBack;", "lifeCycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "creationFeedType", "initParams", "Lcom/larus/platform/api/creation/CreationFeedInitParams;", "getRefImageUrl", "", "isPrivate", "", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationImageToImageViewHolder extends CreationImageViewHolder {
    public static final /* synthetic */ int j = 0;
    public SimpleDraweeView i;

    public CreationImageToImageViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    @Override // com.larus.ugc.feed.impl.viewholder.CreationImageViewHolder
    public final ImageInfoKmp U3(UserCreationKmp r2) {
        Intrinsics.checkNotNullParameter(r2, "creation");
        UserCreationContentKmp r3 = r2.getContent();
        if (r3 == null) goto L7;
        UserCreationImageKmp r4 = r3.getImageContent();
        if (r4 == null) goto L7;
        return r4.getImageInfo();
    L7:
        return null;
    }

    @Override // com.larus.ugc.feed.impl.viewholder.CreationImageViewHolder
    public final void T3(int r4, final UserCreationKmp r5, int r6, p0a.k r7, LifecycleCoroutineScope r8, @CreationFeedType int r9, zp9.f r10) {
        boolean r0 = w0a.a.a;
        StringBuilder r1 = new StringBuilder("bindData, creationId:");
        String r2 = null;
        if (r5 == null) goto L5;
        String r3 = r5.getCreationId();
    L6:
        r1.append(r3);
        w0a.a.c("CreationImageToImageViewHolder", r1.toString());
        w0a.a.a("CreationImageToImageViewHolder", new i(r5));
        super.T3(r4, r5, r6, r7, r8, r9, r10);
        if (r5 == null) goto L11;
        CreationPublishExtraKmp r11 = r5.getPublishExtra();
        if (r11 == null) goto L11;
        Boolean r12 = r11.getPublicRefImage();
    L13:
        if (r12 == null) goto L26;
        CreationPublishExtraKmp r13 = r5.getPublishExtra();
        if (r13 == null) goto L17;
        boolean r14 = Intrinsics.areEqual(r13.getPublicRefImage(), Boolean.FALSE);
    L18:
        if (r14 == false) goto L26;
        AuthorInfoKmp r15 = r5.getAuthorInfo();
        if (r15 == null) goto L22;
        String r16 = r15.getUid();
    L24:
        if (Intrinsics.areEqual(r16, AccountService.a.getUserId()) == true) goto L26;
        boolean r17 = true;
    L27:
        if (r5 == null) goto L69;
        UserCreationRefContentKmp r18 = r5.getRefContent();
        if (r18 == null) goto L49;
        List<ResourceKmp> r19 = r18.getRefResources();
        if (r19 == null) goto L49;
        Iterator<T> r20 = r19.iterator();
    L34:
        if (r20.hasNext() == false) goto L43;
        Object r110 = r20.next();
        ResourceKmp r21 = (ResourceKmp) r110;
        if (r21 != null) goto L38;
    L40:
        boolean r22 = false;
    L41:
        if (r22 == false) goto L34;
    L44:
        ResourceKmp r111 = (ResourceKmp) r110;
        if (r111 == null) goto L49;
        ImageInfoKmp r23 = r111.getImageInfo();
        if (r23 == null) goto L49;
    L55:
        if (r17 == false) goto L60;
        if (r23 == null) goto L69;
        ImageKmp r24 = r23.getImageOrigin();
        if (r24 == null) goto L69;
        final String r25 = r24.getUrl();
    L70:
        if (r25 != null) goto L72;
    L98:
        boolean r26 = w0a.a.a;
        StringBuilder r27 = new StringBuilder("creationId:");
        if (r5 == null) goto L101;
        r2 = r5.getCreationId();
    L101:
        r27.append(r2);
        r27.append(", has no refContent");
        w0a.a.c("CreationImageToImageViewHolder", r27.toString());
        SimpleDraweeView r28 = this.i;
        if (r28 == null) goto L111;
        e1.o(r28);
        return;
    L111:
        return;
    L72:
        if (r25.length() <= 0) goto L74;
        boolean r29 = true;
    L75:
        if (r29 == true) goto L78;
        r25 = null;
    L78:
        if (r25 == null) goto L98;
        int r30 = r6 / 4;
        if (z2.a.getCreationPreviewPerformanceOptConfig().f == false) goto L83;
        if (r30 <= 1) goto L83;
        final ResizeOptions r31 = new ResizeOptions(r30, r30);
    L85:
        if (this.i != null) goto L94;
        SimpleDraweeView r112 = LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()).inflate(2131561971, null, false);
        if (r112 == null) goto L93;
        this.i = r112;
        ConstraintLayout r113 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131375718);
        View r32 = this.i;
        if (r32 == null) goto L91;
        ConstraintLayout.LayoutParams r33 = new ConstraintLayout.LayoutParams(r30, r30);
        r33.topToTop = 0;
        r33.endToEnd = 0;
        r33.setMarginEnd(i5.h());
        ((ViewGroup.MarginLayoutParams) r33).topMargin = i5.h();
        Unit r34 = Unit.INSTANCE;
        r113.addView(r32, r33);
    L91:
        w0a.a.c("CreationImageToImageViewHolder", "add leftTopView");
        goto L94
    L93:
        throw new NullPointerException("rootView");
    L94:
        w0a.a.a("CreationImageToImageViewHolder", new j(r25, r5));
        SimpleDraweeView r35 = this.i;
        if (r35 == null) goto L97;
        e1.x(r35);
    L97:
        ImageLoaderKt.y(this.i, r25, "CreationImageToImageViewHolder", new k(r31), 4);
        return;
    L83:
        r31 = null;
        goto L85
    L74:
        r29 = false;
        goto L75
    L60:
        if (r23 == null) goto L65;
        ImageKmp r36 = r23.getImagePre();
        if (r36 == null) goto L65;
        r25 = r36.getUrl();
        if (r25 != null) goto L70;
    L65:
        if (r23 == null) goto L69;
        ImageKmp r37 = r23.getImageOrigin();
        if (r37 == null) goto L69;
        r25 = r37.getUrl();
        goto L70
    L38:
        if (r21.getResourceType() != 1) goto L40;
        r22 = true;
        goto L41
    L43:
        r110 = null;
    L49:
        UserCreationRefContentKmp r38 = r5.getRefContent();
        if (r38 == null) goto L54;
        List<ImageInfoKmp> r39 = r38.getRefImages();
        if (r39 == null) goto L54;
        r23 = (ImageInfoKmp) CollectionsKt.firstOrNull(r39);
    L54:
        r23 = null;
    L69:
        r25 = null;
        goto L70
    L22:
        r16 = null;
        goto L24
    L17:
        r14 = false;
    L26:
        r17 = false;
    L11:
        r12 = null;
        goto L13
    L5:
        r3 = null;
        goto L6
    }
}
