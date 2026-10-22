package com.larus.ugc.feed.impl.viewholder;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.util.Range;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.widget.CommonAuthorInfoLayout;
import com.larus.community.api.ICommunityService;
import com.larus.media.focus.CardContextState;
import com.larus.platform.api.creation.CreationFeedType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.VideoUserContent;
import com.larus.platform.service.z2;
import com.larus.ugc.feed.api.model.AuthorInfoKmp;
import com.larus.ugc.feed.api.model.CreationDynamicInfoKmp;
import com.larus.ugc.feed.api.model.CreationPublishExtraKmp;
import com.larus.ugc.feed.api.model.ImageInfoKmp;
import com.larus.ugc.feed.api.model.ImageKmp;
import com.larus.ugc.feed.api.model.ResourceKmp;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ugc.feed.api.model.UserCreationRefContentKmp;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.larus.utils.w0;
import com.tencent.open.log.TraceLevel;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 C2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001CB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J`\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010\u0019\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0007J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001a\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020%2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010)\u001a\u00020\u0018H\u0016J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020+H\u0016J\u0018\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u00182\b\u00103\u001a\u0004\u0018\u000104J\u0006\u00105\u001a\u00020\u0018J\u0006\u00106\u001a\u00020\u0018J\u0006\u00107\u001a\u00020\u0018J\u0010\u00108\u001a\u00020\u00182\u0006\u0010.\u001a\u00020/H\u0016J\b\u00109\u001a\u00020:H\u0016J\b\u0010?\u001a\u00020\u0018H\u0002J\b\u0010@\u001a\u00020\u0018H\u0002J\u0014\u0010A\u001a\u0004\u0018\u00010:2\b\u0010B\u001a\u0004\u0018\u00010\u001cH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/larus/ugc/feed/impl/viewholder/CreationVideoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/platform/api/creation/ICreationFeedViewHolder;", "Lcom/larus/media/focus/OIDisplayListener;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "downloadIcon", "Lcom/larus/bmhome/bigimg/download/CommonDownLoadLayout;", "waterMarkIcon", "Landroid/widget/ImageView;", "lifeCycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "focusHelper", "Lcom/larus/ugc/feed/impl/component/focus/CreationFeedRVFocusHelper;", "videoView", "Lcom/larus/common_ui/video/VideoPlayView;", "iconTemplate", "textView", "Landroid/widget/TextView;", "authorInfoLayout", "Lcom/larus/common_ui/widget/CommonAuthorInfoLayout;", "resetTemplateIcon", "", "creationFeedType", "", "creation", "Lcom/larus/ugc/feed/api/model/UserCreationKmp;", "bindData", "position", "itemWidth", "creationClickCallBack", "Lcom/larus/ugc/feed/impl/adapter/ICreationClickCallBack;", "initParams", "Lcom/larus/platform/api/creation/CreationFeedInitParams;", "platform", "Lcom/larus/platform/api/creation/UserCreation;", "handleIconTemplate", "handleDownLoadIcon", "platformCreation", "onViewRecycled", "getVisiblePercentThrottle", "", "getInvisiblePercentThrottle", "onCardDisplay", "contextState", "Lcom/larus/media/focus/CardContextState;", "cardCallback", "Lcom/larus/media/focus/OICardActionCallback;", "bindVideoController", "videoController", "Lcom/larus/platform/api/IVideoController;", "startVideo", "stopVideo", "stopVideoIfPlaying", "onCardGone", "getDisplayItemKey", "", "job", "Lkotlinx/coroutines/Job;", "prefetchSuccess", "", "prefetchRefImageIfNeed", "cancelPrefetchRefImage", "getRefImageUrl", "userCreation", "Companion", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationVideoViewHolder extends RecyclerView.ViewHolder implements zp9.q, nk9.d {
    public static final /* synthetic */ int l = 0;
    public final CommonDownLoadLayout a;
    public final ImageView b;
    public LifecycleCoroutineScope c;
    public q0a.c d;
    public final VideoPlayView e;
    public final View f;
    public final TextView g;
    public final CommonAuthorInfoLayout h;
    public UserCreationKmp i;
    public Job j;
    public boolean k;

    public static final class a {
    }

    public static final class b extends BaseControllerListener<Object> {
        public final /* synthetic */ CreationVideoViewHolder a;

        public b(CreationVideoViewHolder r1) {
            this.a = r1;
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            super.onFinalImageSet(r1, r2, r3);
            boolean r4 = m0.a;
            if (m0.a == false) goto L6;
            e1.x(this.a.b);
            return;
        }
    }

    static {
    }

    public final float C0() {
        return 0.99f;
    }

    public final float E2() {
        return 1.0f;
    }

    public final float F2() {
        return 0.0f;
    }

    public final float X1() {
        return 0.0f;
    }

    public final float h2() {
        return 1.0f;
    }

    public final float h3() {
        return 1.0f;
    }

    public final View I0() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.ViewHolder");
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public final String S0() {
        UserCreationKmp r0 = this.i;
        if (r0 == null) goto L6;
        String r1 = r0.getCreationId();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    @Override // zp9.q
    public final void onViewRecycled() {
        this.a.onDestroy();
    }

    public CreationVideoViewHolder(View r4) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4);
        this.a = r4.findViewById(2131370173);
        this.b = (ImageView) r4.findViewById(2131393017);
        VideoPlayView r0 = r4.findViewById(2131375887);
        boolean r1 = m0.a;
        if (m0.a == false) goto L5;
        r0.K();
    L5:
        this.e = r0;
        View r2 = r4.findViewById(2131374752);
        ICommunityService.Companion r3 = ICommunityService.a;
        if (r3.f1().e() != 0) goto L8;
        r2.setBackgroundResource(2131239556);
    L9:
        this.f = r2;
        TextView r5 = (TextView) r4.findViewById(2131369264);
        if (r3.f1().e() != 0) goto L12;
        r5.setTextColor(ContextCompat.getColor(r4.getContext(), 2131106521));
    L13:
        this.g = r5;
        this.h = r4.findViewById(2131377437);
        w0.e(r4, i5.Y());
        return;
    L12:
        r5.setTextColor(ContextCompat.getColor(r4.getContext(), 2131103292));
        goto L13
    L8:
        r2.setBackgroundResource(2131239557);
        goto L9
    }

    public final void A0(CardContextState r3) {
        Intrinsics.checkNotNullParameter(r3, "contextState");
        Intrinsics.checkNotNullParameter(r3, "contextState");
        q0a.c r4 = this.d;
        if (r4 == null) goto L6;
        Intrinsics.checkNotNullParameter(this, "card");
        q0a.f r5 = r4.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(this, "card");
        r5.b.remove(new WeakReference(this));
        CollectionsKt.removeAll(r5.b, new q0a.d(this));
        com.larus.utils.y.c(new j0(this));
        return;
    }

    public static final String T3(CreationVideoViewHolder r5, UserCreationKmp r6) {
        r5.getClass();
        String r7 = null;
        if (r6 == null) goto L76;
        UserCreationRefContentKmp r0 = r6.getRefContent();
        if (r0 == null) goto L22;
        List<ResourceKmp> r1 = r0.getRefResources();
        if (r1 == null) goto L22;
        Iterator<T> r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L20;
        Object r3 = r2.next();
        ResourceKmp r4 = (ResourceKmp) r3;
        if (r4 == null) goto L17;
        boolean r8 = true;
        if (r4.getResourceType() != 1) goto L17;
    L18:
        if (r8 == false) goto L11;
    L21:
        ResourceKmp r9 = (ResourceKmp) r3;
    L23:
        CreationPublishExtraKmp r10 = r6.getPublishExtra();
        if (r10 == null) goto L26;
        boolean r11 = Intrinsics.areEqual(r10.getPublicRefImage(), Boolean.FALSE);
    L28:
        if (r11 == false) goto L49;
        if (r9 == null) goto L38;
        ImageInfoKmp r12 = r9.getImageInfo();
        if (r12 == null) goto L38;
        ImageKmp r13 = r12.getImageOrigin();
        if (r13 == null) goto L38;
        String r14 = r13.getUrl();
        if (r14 == null) goto L38;
    L67:
        return r14;
    L38:
        UserCreationRefContentKmp r15 = r6.getRefContent();
        if (r15 == null) goto L47;
        List<ImageInfoKmp> r16 = r15.getRefImages();
        if (r16 == null) goto L47;
        ImageInfoKmp r17 = (ImageInfoKmp) CollectionsKt.getOrNull(r16, 0);
        if (r17 == null) goto L47;
        ImageKmp r18 = r17.getImageOrigin();
        if (r18 == null) goto L47;
        r7 = r18.getUrl();
    L47:
        if (r7 == null) goto L74;
        return r7;
    L74:
        return "";
    L49:
        if (r9 == null) goto L56;
        ImageInfoKmp r19 = r9.getImageInfo();
        if (r19 == null) goto L56;
        ImageKmp r20 = r19.getImagePre();
        if (r20 == null) goto L56;
        r14 = r20.getUrl();
        if (r14 != null) goto L67;
    L56:
        UserCreationRefContentKmp r21 = r6.getRefContent();
        if (r21 == null) goto L65;
        List<ImageInfoKmp> r22 = r21.getRefImages();
        if (r22 == null) goto L65;
        ImageInfoKmp r23 = (ImageInfoKmp) CollectionsKt.getOrNull(r22, 0);
        if (r23 == null) goto L65;
        ImageKmp r24 = r23.getImagePre();
        if (r24 == null) goto L65;
        r7 = r24.getUrl();
    L65:
        if (r7 == null) goto L74;
        return r7;
    L26:
        r11 = false;
    L17:
        r8 = false;
        goto L18
    L20:
        r3 = null;
    L22:
        r9 = null;
        goto L23
    L76:
        return null;
    }

    public final void A3(CardContextState r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "contextState");
    }

    public final void F3(CardContextState r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "contextState");
    }

    public final void c2(CardContextState r3, go2.g r4) {
        Intrinsics.checkNotNullParameter(r3, "contextState");
        Intrinsics.checkNotNullParameter(r4, "cardCallback");
        Intrinsics.checkNotNullParameter(r3, "contextState");
        Intrinsics.checkNotNullParameter(r4, "cardCallback");
        q0a.c r5 = this.d;
        if (r5 == null) goto L6;
        Intrinsics.checkNotNullParameter(this, "card");
        q0a.f r6 = r5.b;
        r6.getClass();
        Intrinsics.checkNotNullParameter(this, "card");
        CollectionsKt.removeAll(r6.b, new q0a.e(this));
        r6.b.add(new WeakReference(this));
        return;
    }

    public final void q2(CardContextState r2, Range<Float> r3) {
        Intrinsics.checkNotNullParameter(r2, "contextState");
        Intrinsics.checkNotNullParameter(r3, "range");
    }

    public final void U3(final int r25, UserCreationKmp r26, int r27, final p0a.k r28, LifecycleCoroutineScope r29, @CreationFeedType int r30, zp9.f r31, q0a.c r32, UserCreation r33) {
        if (r26 != null) goto L5;
        return;
    L5:
        this.i = r26;
        this.c = r29;
        this.d = r32;
        if (r30 == 1) goto L8;
    L10:
        if (r30 == 1) goto L13;
        if (r30 == 2) goto L13;
        e1.x(this.f);
        e1.o(this.a);
    L14:
        if (r33 != null) goto L16;
        final UserCreation r6 = com.larus.ugc.feed.impl.mapper.c.d(r26);
    L18:
        if (this.a.getVisibility() != 0) goto L20;
        boolean r10 = true;
    L21:
        if (r10 == false) goto L29;
        if (r29 == null) goto L29;
        UserCreationContent r11 = r6.e;
        if (r11 == null) goto L29;
        VideoUserContent r12 = r11.e;
        if (r12 == null) goto L29;
        this.a.S5(r29, new com.larus.bmhome.bigimg.download.d.c(os8.c.d(r12)));
    L29:
        z2 r5 = z2.a;
        if (r5.getCreationMakeSameConfigV2().b() == false) goto L33;
        e1.o(this.f);
    L70:
        UserCreationContent r13 = r6.e;
        if (r13 == null) goto L75;
        VideoUserContent r14 = r13.e;
        if (r14 == null) goto L75;
        nr9.g r15 = os8.c.d(r14);
    L76:
        e1.o(this.b);
        AuthorInfoKmp r16 = r26.getAuthorInfo();
        if (r15 == null) goto L81;
        nr9.f r17 = r15.g;
        if (r17 == null) goto L81;
        Integer r18 = r17.d;
    L82:
        if (r15 == null) goto L86;
        nr9.f r19 = r15.g;
        if (r19 == null) goto L86;
        Integer r110 = r19.e;
    L87:
        boolean r111 = m0.a;
        int r112 = m0.b(r110, r18, r27, "CreationVideoViewHolder" + r25);
        if (m0.a == false) goto L102;
        float r3 = r27;
        if ((r3 / r112) <= 1.3f) goto L96;
        ImageView r113 = this.b;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L94;
        r114.width = (int) (r3 / 6.0f);
    L95:
        r113.setLayoutParams(r114);
    L101:
        this.b.setImageResource(2131240171);
        e1.q(this.b);
        goto L102
    L94:
        r114 = null;
        goto L95
    L96:
        ImageView r115 = this.b;
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        if (r116 == null) goto L99;
        r116.width = (int) (r3 / 5.0f);
    L100:
        r115.setLayoutParams(r116);
        goto L101
    L99:
        r116 = null;
    L102:
        VideoPlayView r4 = this.e;
        r4.setBackgroundColor(ContextCompat.getColor(r4.getContext(), v19.c.b(2130972086, r4.getContext(), 2131103159)));
        r4.setBanInnerDismiss(true);
        r4.setIgnoreClick(true);
        r4.setEnableCreationPreviewCoverLoadOpt(true);
        r4.E();
        r4.setIsMuted(true);
        if (r15 == null) goto L105;
        String r117 = r15.b;
    L106:
        if (r15 == null) goto L108;
        String r118 = r15.h;
    L109:
        VideoPlayView.e(r4, null, r117, r118, null, null, null, 56);
        if (r15 == null) goto L114;
        nr9.f r8 = r15.g;
        if (r8 == null) goto L114;
        String r119 = r8.a;
    L115:
        if (r15 == null) goto L119;
        nr9.f r9 = r15.g;
        if (r9 == null) goto L119;
        String r120 = r9.b;
    L120:
        if (r15 == null) goto L124;
        nr9.f r20 = r15.g;
        if (r20 == null) goto L124;
        String r121 = r20.c;
    L125:
        if (r15 == null) goto L129;
        nr9.f r21 = r15.g;
        if (r21 == null) goto L129;
        Integer r122 = r21.d;
    L130:
        if (r15 == null) goto L134;
        nr9.f r22 = r15.g;
        if (r22 == null) goto L134;
        Integer r123 = r22.e;
    L135:
        if (r15 == null) goto L139;
        nr9.f r23 = r15.g;
        if (r23 == null) goto L139;
        Bitmap r24 = r23.f;
    L140:
        VideoPlayView.p(r4, r119, r120, r121, r122, r123, r24, new b(this), null, 128);
        VideoPlayView r7 = this.e;
        ViewGroup.LayoutParams r34 = r7.getLayoutParams();
        if (r34 == null) goto L143;
        r34.height = r112;
    L144:
        r7.setLayoutParams(r34);
        if (r31 == null) goto L164;
        boolean r35 = r31.p;
        Long r2 = r26.getUsageCount();
        if (r2 == null) goto L149;
        long r36 = r2.longValue();
    L150:
        CommonAuthorInfoLayout r37 = this.h;
        if (r35 == false) goto L153;
        int r38 = 0;
    L154:
        r37.setVisibility(r38);
        CommonAuthorInfoLayout r39 = this.h;
        if (r16 == null) goto L157;
        String r40 = r16.getAvatarUrl();
    L158:
        r39.a(r40, m0.a());
        CommonAuthorInfoLayout r41 = this.h;
        if (r16 == null) goto L162;
        String r42 = r16.getName();
        if (r42 == null) goto L162;
    L163:
        r41.setAuthorName(r42);
        this.h.setUseCount(r36);
        e1.d(this.h, new b0(r28, r25));
        this.h.setOnLongClickListener(new c0(r28, this, r25));
        VideoPlayView r43 = this.e;
        StringCompanionObject r44 = StringCompanionObject.INSTANCE;
        int r45 = com.larus.utils.j0.a;
        r43.setContentDescription(String.format(com.larus.utils.j0.d(2131898798), Arrays.copyOf(new Object[]{this.h.getAuthorName(), this.h.getUseCount()}, 2)));
    L165:
        ((RecyclerView.ViewHolder) this).itemView.setClickable(true);
        e1.d(this.e, new d0(r28, r25));
        e1.d(this.f, new e0(r28, r25));
        e1.d(this.a, new f0(r28, r6));
        this.e.setOnLongClickListener(new g0(r28, this, r25));
        if (this.k == true) goto L187;
        Job r1 = this.j;
        if (r1 == null) goto L171;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L171:
        this.j = null;
        List r46 = CollectionsKt.listOf(new Integer[]{7, 9});
        UserCreationKmp r47 = this.i;
        if (r47 == null) goto L174;
        Integer r48 = Integer.valueOf(r47.getUserCreationType());
    L176:
        if (CollectionsKt.contains(r46, r48) == true) goto L178;
        return;
    L178:
        if (r5.getCreationMakeSameConfig().b() == false) goto L186;
        LifecycleCoroutineScope r49 = this.c;
        if (r49 == null) goto L182;
        Job r124 = BuildersKt.launch$default(r49, Dispatchers.getIO(), null, new CreationVideoViewHolder$prefetchRefImageIfNeed$1(this, null), 2, null);
    L183:
        this.j = r124;
        return;
    L182:
        r124 = null;
        goto L183
    L186:
        return;
    L174:
        r48 = null;
        goto L176
    L187:
        return;
    L162:
        r42 = "";
        goto L163
    L157:
        r40 = null;
        goto L158
    L153:
        r38 = 8;
        goto L154
    L149:
        r36 = 0;
        goto L150
    L164:
        e1.o(this.h);
        goto L165
    L143:
        r34 = null;
    L139:
        r24 = null;
    L134:
        r123 = null;
    L129:
        r122 = null;
    L124:
        r121 = null;
    L119:
        r120 = null;
    L114:
        r119 = null;
        goto L115
    L108:
        r118 = null;
        goto L109
    L105:
        r117 = null;
    L86:
        r110 = null;
    L81:
        r18 = null;
    L75:
        r15 = null;
        goto L76
    L33:
        if (this.f.getVisibility() != 0) goto L35;
        boolean r125 = true;
    L36:
        if (r125 == false) goto L70;
        CreationDynamicInfoKmp r126 = r26.getDynamicInfo();
        int r127 = -1;
        if (r126 == null) goto L43;
        Integer r128 = r126.getPromptStartPos();
        if (r128 == null) goto L43;
        int r129 = r128.intValue();
    L44:
        if (r129 < 0) goto L58;
        CreationDynamicInfoKmp r130 = r26.getDynamicInfo();
        if (r130 == null) goto L50;
        Integer r131 = r130.getPromptEndPos();
        if (r131 == null) goto L50;
        r127 = r131.intValue();
    L50:
        CreationDynamicInfoKmp r132 = r26.getDynamicInfo();
        if (r132 == null) goto L55;
        Integer r133 = r132.getPromptStartPos();
        if (r133 == null) goto L55;
        int r134 = r133.intValue();
    L56:
        if (r127 < r134) goto L58;
        this.g.setText(2131901253);
    L55:
        r134 = 0;
    L58:
        CreationDynamicInfoKmp r135 = r26.getDynamicInfo();
        if (r135 == null) goto L61;
        String r136 = r135.getActionButtonName();
    L63:
        if (o0.d(r136) == false) goto L69;
        TextView r137 = this.g;
        CreationDynamicInfoKmp r138 = r26.getDynamicInfo();
        if (r138 == null) goto L67;
        String r139 = r138.getActionButtonName();
    L68:
        r137.setText(r139);
        goto L70
    L67:
        r139 = null;
        goto L68
    L69:
        this.g.setText(2131901659);
        goto L70
    L61:
        r136 = null;
    L43:
        r129 = -1;
        goto L44
    L35:
        r125 = false;
        goto L36
    L20:
        r10 = false;
        goto L21
    L16:
        r6 = r33;
    L13:
        e1.o(this.a);
        e1.o(this.f);
        goto L14
    L8:
        if (com.larus.bmhome.utils.u.b() == false) goto L10;
        e1.x(this.a);
        this.a.setDownloadIcon(2131240150);
        e1.o(this.f);
        goto L14
    }
}
