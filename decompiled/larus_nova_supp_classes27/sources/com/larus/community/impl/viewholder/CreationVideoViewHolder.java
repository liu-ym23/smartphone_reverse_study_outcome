package com.larus.community.impl.viewholder;

import android.os.SystemClock;
import android.util.Range;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.common_ui.widget.CommonAuthorInfoLayout;
import com.larus.community.api.ICommunityService;
import com.larus.media.focus.CardContextState;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.CreationPublishExtra;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.api.creation.VideoContentFromChat;
import com.larus.platform.api.creation.VideoUserContent;
import com.larus.utils.logger.FLogger;
import com.larus.utils.w0;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tx9.a4;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Q2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001QB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018H\u0002J^\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010+\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010#\u001a\u00020\u00182\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u00100\u001a\u0004\u0018\u00010\u0011H\u0007J\u0010\u00101\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0002J\u001a\u00102\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u00103\u001a\u00020\u00132\b\b\u0001\u0010#\u001a\u00020\u0018H\u0002J\b\u00104\u001a\u00020\"H\u0016J\b\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u000206H\u0016J\u0018\u00108\u001a\u00020\"2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020\"2\b\u0010>\u001a\u0004\u0018\u00010?J\u0006\u0010@\u001a\u00020\"J\u0006\u0010A\u001a\u00020\"J\u0006\u0010B\u001a\u00020\"J\b\u0010C\u001a\u00020\"H\u0002J\b\u0010D\u001a\u00020\"H\u0002J\b\u0010E\u001a\u00020\"H\u0002J\b\u0010F\u001a\u00020\"H\u0002J\u0010\u0010G\u001a\u00020\"2\u0006\u00109\u001a\u00020:H\u0016J\b\u0010H\u001a\u00020IH\u0016J\b\u0010M\u001a\u00020\"H\u0002J\b\u0010N\u001a\u00020\"H\u0002J\u0014\u0010O\u001a\u0004\u0018\u00010I2\b\u0010P\u001a\u0004\u0018\u00010%H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/larus/community/impl/viewholder/CreationVideoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/platform/api/creation/ICreationFeedViewHolder;", "Lcom/larus/media/focus/OIDisplayListener;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "downloadIcon", "Lcom/larus/bmhome/bigimg/download/CommonDownLoadLayout;", "waterMarkIcon", "Landroid/widget/ImageView;", "lifeCycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "focusHelper", "Lcom/larus/community/impl/component/focus/CreationFeedRVFocusHelper;", "creationFeedVideoReportHelper", "Lcom/larus/community/impl/tracker/CreationFeedVideoReportHelper;", "playSessionActive", "", "segmentStartTs", "", "accumulatedDuration", "playCompleteCount", "", "hasReportedThisSession", "videoView", "Lcom/larus/common_ui/video/VideoPlayView;", "iconTemplate", "textView", "Landroid/widget/TextView;", "authorInfoLayout", "Lcom/larus/common_ui/widget/CommonAuthorInfoLayout;", "resetTemplateIcon", "", "creationFeedType", "creation", "Lcom/larus/platform/api/creation/UserCreation;", "creationFeedTrackParams", "Lcom/larus/platform/api/creation/CreationFeedTrackParams;", "useProfileSelfNoWatermarkCover", "bindData", "position", "itemWidth", "creationClickCallBack", "Lcom/larus/community/impl/adapter/ICreationClickCallBack;", "initParams", "Lcom/larus/platform/api/creation/CreationFeedInitParams;", "feedVideoReportHelper", "handleIconTemplate", "handleDownLoadIcon", "shouldUseProfileSelfNoWatermark", "onViewRecycled", "getVisiblePercentThrottle", "", "getInvisiblePercentThrottle", "onCardDisplay", "contextState", "Lcom/larus/media/focus/CardContextState;", "cardCallback", "Lcom/larus/media/focus/OICardActionCallback;", "bindVideoController", "videoController", "Lcom/larus/platform/api/IVideoController;", "startVideo", "stopVideo", "stopVideoIfPlaying", "stopVideoInner", "resetPlaySessionIfNeeded", "reportPlayTimeIfNeeded", "reportAiVideoPlay", "onCardGone", "getDisplayItemKey", "", "job", "Lkotlinx/coroutines/Job;", "prefetchSuccess", "prefetchRefImageIfNeed", "cancelPrefetchRefImage", "getRefImageUrl", "userCreation", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationVideoViewHolder extends RecyclerView.ViewHolder implements zp9.q, nk9.d {
    public static final /* synthetic */ int r = 0;
    public final CommonDownLoadLayout a;
    public final ImageView b;
    public i29.c c;
    public p29.b d;
    public boolean e;
    public long f;
    public long g;
    public int h;
    public boolean i;
    public final VideoPlayView j;
    public final View k;
    public final TextView l;
    public final CommonAuthorInfoLayout m;
    public UserCreation n;
    public zp9.g o;
    public boolean p;
    public boolean q;

    public static final class a {
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
        UserCreation r0 = this.n;
        if (r0 == null) goto L6;
        String r1 = r0.a;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final void U3() {
        if (this.e == true) goto L5;
        return;
    L5:
        if (this.i == true) goto L75;
        this.g += SystemClock.elapsedRealtime() - this.f;
        UserCreation r1 = this.n;
        if (r1 != null) goto L10;
        return;
    L10:
        zp9.g r2 = this.o;
        UserCreationContent r3 = r1.e;
        if (r3 == null) goto L15;
        VideoUserContent r4 = r3.e;
        if (r4 == null) goto L15;
        nr9.g r5 = os8.c.d(r4);
    L16:
        if (r5 == null) goto L18;
        String r7 = r5.a;
    L19:
        p29.b r6 = this.d;
        if (r6 == null) goto L72;
        if (r2 == null) goto L24;
        String r8 = r2.c;
        if (r8 == null) goto L24;
    L28:
        Boolean r9 = Boolean.TRUE;
        if (r2 == null) goto L31;
        String r10 = r2.h;
    L32:
        Long r11 = Long.valueOf(this.g);
        if (this.h <= 0) goto L35;
        boolean r12 = true;
    L36:
        Boolean r13 = Boolean.valueOf(r12);
        if (r2 == null) goto L39;
        String r14 = r2.a;
    L40:
        UserCreationContent r15 = r1.e;
        if (r15 == null) goto L45;
        VideoContentFromChat r16 = r15.f;
        if (r16 == null) goto L45;
        String r17 = r16.a;
    L46:
        if (r5 == null) goto L48;
        String r18 = r5.b;
    L49:
        Boolean r20 = Boolean.valueOf(a4.a(r18));
        Boolean r21 = Boolean.valueOf(a4.b(AppHost.a.getApplication(), Boolean.valueOf(this.j.s)));
        UserCreationTrackParams r110 = r1.n;
        if (r110 == null) goto L52;
        String r22 = r110.d;
    L53:
        if (r110 == null) goto L55;
        String r111 = r110.e;
    L56:
        if (r2 == null) goto L58;
        String r112 = r2.i;
    L59:
        if (r2 == null) goto L64;
        String r113 = r2.j;
        if (r113 == null) goto L64;
        String r23 = r113;
    L67:
        String r24 = zp9.d.b(r1);
        String r25 = zp9.d.c(r1);
        String r26 = zp9.d.d(r1);
        String r27 = r1.a;
        String r114 = r1.i;
        UserCreationTrackParams r28 = r1.n;
        if (r28 == null) goto L70;
        String r210 = r28.a;
    L71:
        p29.b.b(r6, r7, r8, r9, r10, r11, r13, r14, r17, r20, r21, r22, r111, r112, r23, r24, r25, r26, r27, r114, r210);
        goto L72
    L70:
        r210 = null;
    L64:
        if (r2 == null) goto L66;
        r23 = r2.b;
        goto L67
    L66:
        r23 = null;
        goto L67
    L58:
        r112 = null;
        goto L59
    L55:
        r111 = null;
        goto L56
    L52:
        r22 = null;
        goto L53
    L48:
        r18 = null;
    L45:
        r17 = null;
        goto L46
    L39:
        r14 = null;
        goto L40
    L35:
        r12 = false;
        goto L36
    L31:
        r10 = null;
    L24:
        UserCreationTrackParams r30 = r1.n;
        if (r30 == null) goto L27;
        r8 = r30.g;
        goto L28
    L27:
        r8 = null;
    L72:
        this.i = true;
        this.e = false;
        FLogger.a.i("CreationVideoViewHolder", "playCompleteCount: " + this.h);
        return;
    L18:
        r7 = null;
    L15:
        r5 = null;
        goto L16
    }

    public final void onViewRecycled() {
        U3();
        this.a.onDestroy();
    }

    public CreationVideoViewHolder(View r4) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4);
        this.a = r4.findViewById(2131370173);
        this.b = (ImageView) r4.findViewById(2131393017);
        VideoPlayView r0 = (VideoPlayView) r4.findViewById(2131375887);
        boolean r1 = r0.a;
        if (r0.a == false) goto L5;
        r0.K();
    L5:
        this.j = r0;
        View r2 = r4.findViewById(2131374752);
        ICommunityService.Companion r3 = ICommunityService.a;
        if (r3.f1().e() != 0) goto L8;
        r2.setBackgroundResource(2131239556);
    L9:
        this.k = r2;
        TextView r5 = (TextView) r4.findViewById(2131369264);
        if (r3.f1().e() != 0) goto L12;
        r5.setTextColor(ContextCompat.getColor(r4.getContext(), 2131103298));
    L13:
        this.l = r5;
        this.m = (CommonAuthorInfoLayout) r4.findViewById(2131377437);
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
        i29.c r4 = this.c;
        if (r4 == null) goto L6;
        Intrinsics.checkNotNullParameter(this, "card");
        i29.f r5 = r4.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(this, "card");
        r5.d.remove(new WeakReference(this));
        CollectionsKt.removeAll(r5.d, new i29.e(this));
        com.larus.utils.y.c(new m0(this));
        return;
    }

    public static final String T3(CreationVideoViewHolder r3, UserCreation r4) {
        r3.getClass();
        String r5 = null;
        if (r4 == null) goto L32;
        CreationPublishExtra r0 = r4.p;
        if (r0 == null) goto L8;
        boolean r1 = Intrinsics.areEqual(r0.b, Boolean.FALSE);
    L9:
        if (r1 == false) goto L19;
        UserCreationRefContent r6 = r4.o;
        if (r6 == null) goto L28;
        List r7 = r6.a();
        if (r7 == null) goto L28;
        ImageInfo r8 = (ImageInfo) CollectionsKt.getOrNull(r7, 0);
        if (r8 == null) goto L28;
        Image r9 = r8.h;
        if (r9 == null) goto L28;
        r5 = r9.a;
    L28:
        if (r5 != null) goto L31;
        return "";
    L31:
        return r5;
    L19:
        UserCreationRefContent r10 = r4.o;
        if (r10 == null) goto L28;
        List r11 = r10.a();
        if (r11 == null) goto L28;
        ImageInfo r12 = (ImageInfo) CollectionsKt.getOrNull(r11, 0);
        if (r12 == null) goto L28;
        Image r13 = r12.c;
        if (r13 == null) goto L28;
        r5 = r13.a;
        goto L28
    L8:
        r1 = false;
        goto L9
    L32:
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
        i29.c r5 = this.c;
        if (r5 == null) goto L6;
        Intrinsics.checkNotNullParameter(this, "card");
        i29.f r6 = r5.b;
        r6.getClass();
        Intrinsics.checkNotNullParameter(this, "card");
        CollectionsKt.removeAll(r6.d, new i29.d(this));
        r6.d.add(new WeakReference(this));
        return;
    }

    public final void q2(CardContextState r2, Range<Float> r3) {
        Intrinsics.checkNotNullParameter(r2, "contextState");
        Intrinsics.checkNotNullParameter(r3, "range");
    }
}
