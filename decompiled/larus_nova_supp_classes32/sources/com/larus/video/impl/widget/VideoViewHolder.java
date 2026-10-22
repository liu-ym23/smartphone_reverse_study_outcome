package com.larus.video.impl.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.network.http.AsyncThrowable;
import com.larus.platform.api.IVideoController;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.video.impl.TikTokVideoViewHolder;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.ttvideoengine.TTVideoEngine;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\u0004\b\u0016\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0001QB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u00108\u001a\u000205H\u0002J\b\u00109\u001a\u000205H\u0002J\b\u0010:\u001a\u000205H\u0002J\b\u0010;\u001a\u000205H\u0002J`\u0010<\u001a\u0002052\b\u0010=\u001a\u0004\u0018\u00010\u00102\u0006\u0010>\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142:\b\u0002\u0010?\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(>\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(4\u0012\u0004\u0012\u000205\u0018\u000100H\u0016J\b\u0010@\u001a\u000205H\u0016J\b\u0010A\u001a\u000205H\u0016J\b\u0010B\u001a\u000205H\u0002J\b\u0010C\u001a\u000205H\u0002J\b\u0010D\u001a\u000205H\u0002J\b\u0010E\u001a\u000205H\u0002J\b\u0010F\u001a\u000205H\u0014J\u0006\u0010G\u001a\u000205J\u0006\u0010H\u001a\u000205J\u0010\u0010I\u001a\u0002052\b\u0010=\u001a\u0004\u0018\u00010\u0010J\b\u0010J\u001a\u000205H\u0014J\b\u0010K\u001a\u000205H\u0014J\u0010\u0010L\u001a\u0002052\u0006\u0010M\u001a\u00020NH\u0016J\u0006\u0010O\u001a\u000205J\u0006\u0010P\u001a\u000205R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010/\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(4\u0012\u0004\u0012\u000205\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/larus/video/impl/widget/VideoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/video/impl/ActionDataSyncListener;", "itemView", "Landroid/view/View;", "mCommonVideoModel", "Lcom/larus/flow/video/bean/CommonVideoModel;", "videoController", "Lcom/larus/platform/api/IVideoController;", "<init>", "(Landroid/view/View;Lcom/larus/flow/video/bean/CommonVideoModel;Lcom/larus/platform/api/IVideoController;)V", "getMCommonVideoModel", "()Lcom/larus/flow/video/bean/CommonVideoModel;", "getVideoController", "()Lcom/larus/platform/api/IVideoController;", "mMediaEntity", "Lcom/larus/platform/uimodel/MediaEntity;", "mPosition", NameKeys.UnloadStrategy_No_Strategy, "itemListener", "Lcom/larus/video/impl/ITikTokItemListener;", "mIsLoadingDataFinished", NameKeys.UnloadStrategy_No_Strategy, "mNeedRetry", "mBottomBarHeight", "mVideoView", "Lcom/larus/video/impl/widget/VideoView;", "getMVideoView", "()Lcom/larus/video/impl/widget/VideoView;", "mVideoView$delegate", "Lkotlin/Lazy;", "mProgressView", "Landroid/widget/SeekBar;", "getMProgressView", "()Landroid/widget/SeekBar;", "mProgressView$delegate", "mLoadMoreIndicator", "mSyncFromLayout", "mSyncFromIconView", "Landroid/widget/ImageView;", "mVideoInfoView", "mVideoAccountView", "Landroid/widget/TextView;", "mVideoDescView", "mBottomStatusContentView", "mLoadStatusView", "mLoadTextView", "mOnItemDataUpdate", "Lkotlin/Function2;", "Lkotlin/ParameterName;", EasyGoDbTable.Server.NAME, "positionFrom", "positionTo", NameKeys.UnloadStrategy_No_Strategy, "mMediaDataCallback", "Lcom/larus/flow/video/bean/CommonVideoModel$MediaDataCallback;", "showSlipToSeeMore", "showLoadMore", "hideLodeMore", "showNoMore", "onBind", "entity", "position", "onItemDataUpdate", "onAttached", "onDetached", "initView", "initItemView", "initVideoView", "bindEvent", "bindVideoEvent", "onUnselected", "onSelected", "onUpdate", "playVideo", "stopVideo", "onActionDataChange", "id", NameKeys.UnloadStrategy_No_Strategy, "refreshBottomStatus", "loadMoreData", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class VideoViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int r = 0;
    public final CommonVideoModel a;
    public final IVideoController b;
    public MediaEntity c;
    public l2a.e d;
    public boolean e;
    public final Lazy f;
    public final Lazy g;
    public final View h;
    public final View i;
    public final View j;
    public final TextView k;
    public final TextView l;
    public final View m;
    public final ImageView n;
    public final TextView o;
    public Function2<? super Integer, ? super Integer, Unit> p;
    public final b q;

    public static final class a {
    }

    public static final class b implements CommonVideoModel.b {
        public final /* synthetic */ VideoViewHolder a;

        public b(VideoViewHolder r1) {
            this.a = r1;
        }

        public final void a(MediaEntityContainer r4) {
            VideoViewHolder r5 = this.a;
            r5.e = true;
            r5.getClass();
            this.a.U3();
            VideoViewHolder r6 = this.a;
            Function2<? super Integer, ? super Integer, Unit> r0 = r6.p;
            if (r0 == null) goto L6;
            CommonVideoModel r1 = r6.a;
            Intrinsics.checkNotNull(r1);
            MediaEntityContainer r2 = r1.getLoadMoreContainer();
            Intrinsics.checkNotNull(r2);
            ArrayList r3 = r2.mediaList();
            Intrinsics.checkNotNull(r3);
            Integer r7 = Integer.valueOf(r3.size() - r6.a.getOffset());
            MediaEntityContainer r8 = r6.a.getLoadMoreContainer();
            Intrinsics.checkNotNull(r8);
            ArrayList r9 = r8.mediaList();
            Intrinsics.checkNotNull(r9);
            r0.invoke(r7, Integer.valueOf(r9.size()));
            return;
        }

        public final void b(AsyncThrowable r2) {
            VideoViewHolder r3 = this.a;
            int r0 = VideoViewHolder.r;
            r3.getClass();
            this.a.U3();
        }
    }

    static {
    }

    public void D() {
    }

    public void W3() {
    }

    public final VideoView T3() {
        return (VideoView) this.f.getValue();
    }

    public final void U3() {
        e1.q(this.m);
        e1.o(this.h);
    }

    public VideoViewHolder(final View r2, CommonVideoModel r3, IVideoController r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.e = true;
        this.f = LazyKt.lazy(new w(r2));
        this.g = LazyKt.lazy(new x(r2));
        this.h = r2.findViewById(2131378952);
        this.i = r2.findViewById(2131387958);
        ImageView r5 = (ImageView) r2.findViewById(2131387957);
        this.j = r2.findViewById(2131392310);
        this.k = (TextView) r2.findViewById(2131392248);
        this.l = (TextView) r2.findViewById(2131392293);
        this.m = r2.findViewById(2131364548);
        this.n = (ImageView) r2.findViewById(2131387302);
        this.o = (TextView) r2.findViewById(2131378965);
        this.q = new b(this);
    }

    public final void V3(MediaEntity r9, int r10, l2a.e r11, l2a.q r12) {
        this.d = r11;
        this.p = r12;
        this.c = r9;
        CommonVideoModel r13 = this.a;
        boolean r0 = true;
        if (r13 == null) goto L29;
        ArrayList r1 = r13.getItems();
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L29;
        ArrayList r14 = r13.getItems();
        if (r14 == null) goto L15;
        int r15 = r14.size();
    L17:
        if (r10 >= (r15 - 1)) goto L29;
        ArrayList r16 = this.a.getItems();
        Intrinsics.checkNotNull(r16);
        MediaEntity r17 = (MediaEntity) ListProtector.get(r16, r10 + 1);
        if (r17 == null) goto L23;
        String r18 = r17.getMedia_cover_image();
        if (r18 == null) goto L23;
        FLogger.a.d("VideoViewHolder", "Preload image ");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new VideoViewHolder$onBind$1$1$1(r18, null), 3, null);
    L23:
        IVideoController r19 = this.b;
        if (r19 == null) goto L29;
        if (r17 == null) goto L27;
        String r3 = r17.getVideo_model();
    L28:
        r19.f(r3, new b0(r17, (TikTokVideoViewHolder) this));
        goto L29
    L27:
        r3 = null;
        goto L28
    L15:
        r15 = 0;
        goto L17
    L7:
        if (r1.isEmpty() == true) goto L10;
        r2 = false;
    L29:
        AppHost.Companion r20 = AppHost.a;
        int r110 = com.larus.utils.i.d(r20.getApplication());
        int r4 = i5.B();
        MediaEntity r5 = this.c;
        if (r5 == null) goto L42;
        Integer r6 = r5.getMedia_width();
        if (r6 != null) goto L35;
    L36:
        Integer r7 = r5.getMedia_height();
        if (r7 != null) goto L40;
    L41:
        r110 = com.larus.utils.i.d(r20.getApplication());
        Integer r8 = r5.getMedia_height();
        Intrinsics.checkNotNull(r8);
        r4 = (r8.intValue() * com.larus.utils.i.c(r20.getApplication())) / r110;
        goto L42
    L40:
        if (r7.intValue() == 0) goto L42;
    L35:
        if (r6.intValue() != 0) goto L36;
    L42:
        VideoView r21 = T3();
        if (r21 == null) goto L47;
        if (r110 == 0) goto L47;
        if (r4 == 0) goto L47;
        r21.i = r110 / r4;
    L47:
        TextView r22 = this.l;
        MediaEntity r111 = this.c;
        if (r111 == null) goto L50;
        String r112 = r111.getMedia_des();
    L51:
        r22.setText(r112);
        TextView r23 = this.k;
        MediaEntity r113 = this.c;
        if (r113 == null) goto L54;
        String r114 = r113.getMedia_account_name();
    L55:
        r23.setText(r114);
        VideoView r24 = T3();
        if (r24 == null) goto L58;
        r24.setAllowGesture(true);
    L58:
        VideoView r25 = T3();
        if (r25 == null) goto L61;
        r25.setPlayButtonVisible(8);
    L61:
        VideoView r26 = T3();
        if (r26 == null) goto L64;
        final TikTokVideoViewHolder r27 = (TikTokVideoViewHolder) this;
        Function1<? super Integer, Unit> r28 = new y(r27);
        Intrinsics.checkNotNullParameter(r28, "block");
        r26.b = r28;
    L64:
        VideoView r29 = T3();
        if (r29 == null) goto L67;
        final TikTokVideoViewHolder r30 = (TikTokVideoViewHolder) this;
        Function1<? super Integer, Unit> r31 = new z(r30);
        Intrinsics.checkNotNullParameter(r31, "block");
        r29.a = r31;
    L67:
        MediaEntity r32 = this.c;
        if (r32 == null) goto L70;
        String r33 = r32.getVideo_model();
    L71:
        if (r33 != null) goto L73;
    L76:
        float r34 = 0.0f;
        if (r0 == true) goto L101;
        VideoView r35 = T3();
        if (r35 == null) goto L119;
        IVideoController r36 = this.b;
        if ((r36 instanceof com.larus.video.impl.sdk.o) == false) goto L83;
        com.larus.video.impl.sdk.o r37 = (com.larus.video.impl.sdk.o) r36;
    L84:
        if (r37 == null) goto L86;
        TTVideoEngine r38 = r37.d;
    L87:
        MediaEntity r39 = this.c;
        boolean r40 = VideoView.G;
        Intrinsics.checkNotNullParameter(this, "videoViewHolder");
        r35.p = r39;
        r35.q = this;
        r35.h = 0.0f;
        r35.d.setVisibility(0);
        r35.e.setVisibility(8);
        if (r36 == null) goto L90;
        r35.s = r36;
    L90:
        if (r38 == null) goto L92;
        r35.t = r38;
    L92:
        if (r39 == null) goto L119;
        Integer r115 = r39.getMedia_height();
        if (r115 != null) goto L97;
    L99:
        Integer r41 = r39.getMedia_width();
        Intrinsics.checkNotNull(r41);
        float r42 = r41.intValue();
        Integer r116 = r39.getMedia_height();
        Intrinsics.checkNotNull(r116);
        r34 = r42 / r116.intValue();
    L100:
        r35.i = r34;
        r35.j = new VideoView.f(null);
        r35.n = String.valueOf(r39.getMedia_cover_image());
        r35.l = r39.getMedia_cover_image();
        r35.e();
        goto L119
    L97:
        if (r115.intValue() != 0) goto L99;
    L86:
        r38 = null;
        goto L87
    L83:
        r37 = null;
    L119:
        SeekBar r43 = (SeekBar) this.g.getValue();
        if (r43 == null) goto L122;
        r43.setOnSeekBarChangeListener(new a0((TikTokVideoViewHolder) this));
    L122:
        final TikTokVideoViewHolder r117 = (TikTokVideoViewHolder) this;
        e1.d(this.m, new v(r117));
        return;
    L101:
        VideoView r44 = T3();
        if (r44 == null) goto L119;
        IVideoController r45 = this.b;
        if ((r45 instanceof com.larus.video.impl.sdk.o) == false) goto L106;
        com.larus.video.impl.sdk.o r46 = (com.larus.video.impl.sdk.o) r45;
    L107:
        if (r46 == null) goto L109;
        TTVideoEngine r47 = r46.d;
    L110:
        MediaEntity r48 = this.c;
        boolean r49 = VideoView.G;
        Intrinsics.checkNotNullParameter(this, "videoViewHolder");
        r44.p = r48;
        r44.q = this;
        r44.h = 0.0f;
        r44.d.setVisibility(0);
        r44.e.setVisibility(8);
        if (r45 == null) goto L113;
        r44.s = r45;
    L113:
        if (r47 == null) goto L115;
        r44.t = r47;
    L115:
        if (r48 == null) goto L119;
        Integer r118 = r48.getMedia_width();     // Catch: Throwable -> L124
        Intrinsics.checkNotNull(r118);     // Catch: Throwable -> L124
        float r119 = r118.intValue();     // Catch: Throwable -> L124
        Integer r120 = r48.getMedia_height();     // Catch: Throwable -> L124
        Intrinsics.checkNotNull(r120);     // Catch: Throwable -> L124
        r34 = r119 / r120.intValue();
    L118:
        r44.i = r34;
        r44.j = new VideoView.f(null);
        r44.m = r48.getMedia_url();
        r44.n = String.valueOf(r48.getMedia_cover_image());
        r44.l = r48.getMedia_cover_image();
        r44.e();
        goto L119
    L109:
        r47 = null;
        goto L110
    L106:
        r46 = null;
        goto L107
    L73:
        if (r33.length() == 0) goto L76;
        r0 = false;
        goto L76
    L70:
        r33 = null;
        goto L71
    L54:
        r114 = null;
        goto L55
    L50:
        r112 = null;
        goto L51
    }
}
