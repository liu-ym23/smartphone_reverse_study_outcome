package com.larus.doc.impl.video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.bigimg.i1;
import com.larus.doc.biz.impl.databinding.LarusDocVideoPlayLayoutBinding;
import com.larus.doc.impl.video.widget.VideoPlayControlView;
import com.larus.doc.impl.video.widget.VideoPlayView;
import com.larus.platform.api.IVideoController;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.video.api.VideoService;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\"H\u0016J\b\u0010'\u001a\u00020\"H\u0002J\b\u0010(\u001a\u00020\"H\u0002J\b\u0010)\u001a\u00020\"H\u0002J\b\u0010*\u001a\u00020\"H\u0002J\b\u0010+\u001a\u00020\"H\u0002J\b\u0010,\u001a\u00020\"H\u0002J\b\u0010-\u001a\u00020\"H\u0002J0\u0010.\u001a\u0004\u0018\u00010\u00152\u0006\u0010/\u001a\u0002002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u00103J\b\u00104\u001a\u00020\u0015H\u0002J\"\u00105\u001a\u0004\u0018\u0001062\u0006\u0010/\u001a\u0002002\u0006\u00107\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u0015H\u0002J\b\u00108\u001a\u00020\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/larus/doc/impl/video/VideoDetailFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "draging", "", "latestDragSeekTime", "", "downloading", "getDownloading", "()Z", "setDownloading", "(Z)V", "isPlaying", "videoPlayControl", "Lcom/larus/doc/impl/video/widget/VideoPlayControlView;", "getVideoPlayControl", "()Lcom/larus/doc/impl/video/widget/VideoPlayControlView;", "videoPlayControl$delegate", "Lkotlin/Lazy;", "url", "", "fileSuffix", "binding", "Lcom/larus/doc/biz/impl/databinding/LarusDocVideoPlayLayoutBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onPause", "onDestroy", "initExitAndShareView", "initRetryView", "initClickListener", "initVideoView", "initSeekbar", "download", "realDownload", "saveVideoFile", "context", "Landroid/content/Context;", "resultPath", "suffix", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSavePath", "saveVideoToAlbumBeforeQ", "Landroid/net/Uri;", "videoFile", "share", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoDetailFragment extends Fragment {
    public static final /* synthetic */ int l = 0;
    public boolean d;
    public long e;
    public boolean f;
    public boolean g;
    public final Lazy h;
    public String i;
    public String j;
    public LarusDocVideoPlayLayoutBinding k;

    public static final class a {
    }

    static {
    }

    public final VideoPlayControlView S90() {
        return (VideoPlayControlView) this.h.getValue();
    }

    public VideoDetailFragment() {
        this.h = LazyKt.lazy(new c(this));
        this.i = "";
        this.j = "";
    }

    public final void T90() {
        S90().I4(true);
        FLogger.a.e("Music Edit Error", "no permission");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new VideoDetailFragment$realDownload$1(this, i1.b() + "/doc_attachment_video/", null), 2, null);
    }

    public final void onDestroy() {
        super.onDestroy();
        LarusDocVideoPlayLayoutBinding r0 = this.k;
        if (r0 == null) goto L16;
        VideoPlayView r1 = r0.f;
        if (r1 == null) goto L17;
        FLogger.a.i("VideoPlayView", "[stop]");
        r1.m = false;
        ArrayList<Runnable> r2 = r1.p;
        if (r2 == null) goto L9;
        r2.clear();
    L9:
        r1.o = false;
        r1.removeCallbacks(r1.s);
        r1.n.removeCallbacksAndMessages(null);
        r1.s = null;
        IVideoController r3 = r1.l;
        if (r3 == null) goto L12;
        r3.l();
    L12:
        IVideoController r4 = r1.l;
        if (r4 == null) goto L18;
        r4.stop();
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void onPause() {
        super.onPause();
        if (VideoService.a.f("doc_video", null).d() != IVideoController.PlayType.PLAY) goto L5;
        boolean r0 = true;
    L6:
        this.g = r0;
        LarusDocVideoPlayLayoutBinding r1 = this.k;
        if (r1 == null) goto L12;
        VideoPlayView r2 = r1.f;
        if (r2 == null) goto L13;
        r2.e(false);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void onResume() {
        super.onResume();
        if (this.g == false) goto L11;
        LarusDocVideoPlayLayoutBinding r0 = this.k;
        if (r0 == null) goto L9;
        VideoPlayView r1 = r0.f;
        if (r1 == null) goto L9;
        r1.f(false);
    L9:
        this.g = false;
        return;
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        LarusDocVideoPlayLayoutBinding r9 = this.k;
        if (r9 == null) goto L7;
        FrameLayout r10 = r9.c;
        if (r10 == null) goto L7;
        i0.a.getClass();
        int r11 = i0.e() + i5.h();
        int r0 = r10.getPaddingStart();
        int r1 = r10.getPaddingTop();
        int r2 = r10.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r10.getClass().getSimpleName() + ",source:,start:" + r0 + ",top:" + r1 + ",end:" + r2 + ",bottom:" + r11);
        r10.setPaddingRelative(r0, r1, r2, r11);
    L7:
        LarusDocVideoPlayLayoutBinding r12 = this.k;
        if (r12 == null) goto L16;
        VideoPlayView r13 = r12.f;
        if (r13 == null) goto L17;
        IVideoController r14 = VideoService.a.f("doc", null);
        r14.y(false, "");
        r14.i(7);
        String r3 = this.i;
        FLogger.a.i("VideoPlayView", "[bindVideoWithViewModel] url:" + r3);
        r13.h = 0.0f;
        r13.e.setVisibility(8);
        r13.l = r14;
        r13.a = r3;
        r14.setLooping(true);
        IVideoController r15 = r13.l;
        if (r15 == null) goto L14;
        r15.setDirectURL(r3);
    L14:
        r13.g();
        return;
    L17:
        return;
    }

    /* JADX WARN: Type inference failed for: r9v14, types: [com.larus.doc.impl.video.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v15, types: [com.larus.doc.impl.video.e, java.lang.Object] */
    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ConstraintLayout r11 = r8.inflate(2131562139, r9, false);
        int r12 = 2131363762;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r11, 2131363762);
        if (r2 == null) goto L69;
        r12 = 2131364161;
        if (((ImageView) ViewBindings.findChildViewById(r11, 2131364161)) == null) goto L69;
        r12 = 2131364437;
        FrameLayout r13 = (FrameLayout) ViewBindings.findChildViewById(r11, 2131364437);
        if (r13 == null) goto L69;
        r12 = 2131384472;
        RelativeLayout r4 = (RelativeLayout) ViewBindings.findChildViewById(r11, 2131384472);
        if (r4 == null) goto L69;
        r12 = 2131386047;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r11, 2131386047);
        if (r5 == null) goto L69;
        r12 = 2131392404;
        VideoPlayView r6 = (VideoPlayView) ViewBindings.findChildViewById(r11, 2131392404);
        if (r6 == null) goto L69;
        this.k = new LarusDocVideoPlayLayoutBinding(r11, r2, r13, r4, r5, r6);
        r13.addView(S90(), new FrameLayout.LayoutParams(-1, -2, 80));
        Bundle r14 = getArguments();
        String r15 = "";
        if (r14 == null) goto L18;
        String r16 = r14.getString("video_url");
        if (r16 == null) goto L18;
    L19:
        this.i = r16;
        Bundle r17 = getArguments();
        if (r17 == null) goto L25;
        String r18 = r17.getString("file_suffix");
        if (r18 == null) goto L25;
        r15 = r18;
    L25:
        this.j = r15;
        LarusDocVideoPlayLayoutBinding r20 = this.k;
        if (r20 == null) goto L34;
        ImageView r21 = r20.b;
        if (r21 == null) goto L34;
        ViewGroup.LayoutParams r110 = r21.getLayoutParams();
        if (r110 == null) goto L33;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        i0.a.getClass();
        r111.topMargin = i0.g();
        r21.setLayoutParams(r111);
        goto L34
    L33:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L34:
        LarusDocVideoPlayLayoutBinding r22 = this.k;
        if (r22 == null) goto L39;
        ImageView r23 = r22.b;
        if (r23 == null) goto L39;
        e1.d(r23, new i(this));
    L39:
        LarusDocVideoPlayLayoutBinding r24 = this.k;
        if (r24 == null) goto L48;
        ImageView r25 = r24.e;
        if (r25 == null) goto L48;
        ViewGroup.LayoutParams r112 = r25.getLayoutParams();
        if (r112 == null) goto L47;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r112;
        i0.a.getClass();
        r113.topMargin = i0.g();
        r25.setLayoutParams(r113);
        goto L48
    L47:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L48:
        LarusDocVideoPlayLayoutBinding r26 = this.k;
        if (r26 == null) goto L53;
        ImageView r27 = r26.e;
        if (r27 == null) goto L53;
        e1.d(r27, new j(this));
    L53:
        LarusDocVideoPlayLayoutBinding r28 = this.k;
        if (r28 == null) goto L58;
        RelativeLayout r30 = r28.d;
        if (r30 == null) goto L58;
        r30.setOnClickListener(new d(this));
    L58:
        LarusDocVideoPlayLayoutBinding r31 = this.k;
        if (r31 == null) goto L63;
        VideoPlayView r32 = r31.f;
        if (r32 == null) goto L63;
        r32.setPlayButtonVisible(8);
        Function1<? super Integer, Unit> r33 = new f(this);
        Intrinsics.checkNotNullParameter(r33, "block");
        r32.b = r33;
        r32.c = new g(this);
        r32.setDismissCallback(new h(this));
    L63:
        VideoPlayControlView r34 = S90();
        ?? r35 = new com.larus.doc.impl.video.a(this);
        r34.getClass();
        Intrinsics.checkNotNullParameter(r35, "config");
        r35.invoke(r34.a.c);
        VideoPlayControlView r36 = S90();
        final ?? r37 = new e(this);
        r36.getClass();
        Intrinsics.checkNotNullParameter(r37, "onClick");
        e1.d(r36.a.b, new com.larus.doc.impl.video.widget.k(r37));
        LarusDocVideoPlayLayoutBinding r38 = this.k;
        if (r38 != null) goto L70;
        return null;
    L70:
        return r38.a;
    L18:
        r16 = "";
    L69:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
