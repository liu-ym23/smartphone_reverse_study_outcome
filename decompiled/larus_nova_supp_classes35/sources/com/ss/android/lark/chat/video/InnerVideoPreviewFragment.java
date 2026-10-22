package com.ss.android.lark.chat.video;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV1;
import com.ss.android.lark.chat.preview.entity.component.property.VideoProperty;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.player.player.s;
import com.ss.android.lark.player.player.v;
import com.ss.android.lark.player.widget.VideoView;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001SB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J&\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010(2\b\u0010<\u001a\u0004\u0018\u00010=H\u0017J\u0010\u0010C\u001a\u00020;2\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020\"H\u0016J\b\u0010G\u001a\u00020;H\u0016J\b\u0010H\u001a\u00020;H\u0016J\b\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020;2\u0006\u0010L\u001a\u00020\"H\u0002J\b\u0010M\u001a\u00020;H\u0002J\u0010\u0010N\u001a\u00020;2\u0006\u0010O\u001a\u00020PH\u0016J\b\u0010Q\u001a\u00020;H\u0016J\b\u0010R\u001a\u00020;H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u000e\u00103\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006T"}, d2 = {"Lcom/ss/android/lark/chat/video/InnerVideoPreviewFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/lark/chat/video/SharedElementListener;", "Lcom/ss/android/lark/chat/video/BackListener;", "<init>", "()V", "mVideoOriginUrl", BuildConfig.FLAVOR, "getMVideoOriginUrl", "()Ljava/lang/String;", "setMVideoOriginUrl", "(Ljava/lang/String;)V", "mVideoCover", "Lcom/ss/android/lark/image/entity/Image;", "getMVideoCover", "()Lcom/ss/android/lark/image/entity/Image;", "setMVideoCover", "(Lcom/ss/android/lark/image/entity/Image;)V", "mVideoPlayUrl", "listener", "Lcom/ss/android/lark/chat/video/OnFragmentInteractListener;", "mVideoView", "Lcom/ss/android/lark/player/widget/VideoView;", "getMVideoView", "()Lcom/ss/android/lark/player/widget/VideoView;", "setMVideoView", "(Lcom/ss/android/lark/player/widget/VideoView;)V", "mControllerCover", "Lcom/ss/android/lark/chat/video/PreviewControllerCover;", "getMControllerCover", "()Lcom/ss/android/lark/chat/video/PreviewControllerCover;", "setMControllerCover", "(Lcom/ss/android/lark/chat/video/PreviewControllerCover;)V", "mInflated", BuildConfig.FLAVOR, "getMInflated", "()Z", "setMInflated", "(Z)V", "mRootView", "Landroid/view/ViewGroup;", "getMRootView", "()Landroid/view/ViewGroup;", "setMRootView", "(Landroid/view/ViewGroup;)V", "mAnimationCoverIV", "Landroid/widget/ImageView;", "getMAnimationCoverIV", "()Landroid/widget/ImageView;", "setMAnimationCoverIV", "(Landroid/widget/ImageView;)V", "isPortrait", "site", "Lcom/ss/android/lark/chat/preview/entity/component/property/VideoProperty$Site;", "getSite", "()Lcom/ss/android/lark/chat/preview/entity/component/property/VideoProperty$Site;", "setSite", "(Lcom/ss/android/lark/chat/preview/entity/component/property/VideoProperty$Site;)V", "onCreate", BuildConfig.FLAVOR, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onBackPressed", "onSharedElementEnd", "onPause", "setupCovers", "Lcom/ss/android/lark/player/cover/ReceiverGroup;", "playVideo", "useNet", "playInner", "onAttach", "context", "Landroid/content/Context;", "onDestroyView", "onDetach", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InnerVideoPreviewFragment extends Fragment implements p, com.ss.android.lark.chat.video.a {
    public static final /* synthetic */ int o = 0;
    public String d;
    public Image e;
    public String f;
    public g g;
    public VideoView h;
    public h i;
    public boolean j;
    public ViewGroup k;
    public ImageView l;
    public boolean m;
    public VideoProperty.Site n;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ InnerVideoPreviewFragment a;

        public b(InnerVideoPreviewFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VideoView r0 = this.a.h;     // Catch: Throwable -> L17
            if (r0 == null) goto L5;
            r0.i();     // Catch: Throwable -> L17
        L5:
            InnerVideoPreviewFragment r1 = this.a;     // Catch: Throwable -> L17
            ViewGroup r2 = r1.k;     // Catch: Throwable -> L17
            if (r2 == null) goto L8;
            r2.removeView(r1.h);     // Catch: Throwable -> L17
        L8:
            InnerVideoPreviewFragment r3 = this.a;     // Catch: Throwable -> L17
            if (r3.m == false) goto L13;
            FragmentActivity r4 = r3.getActivity();     // Catch: Throwable -> L17
            if (r4 == null) goto L20;
            r4.finishAfterTransition();     // Catch: Throwable -> L17
            return;
        L20:
            return;
        L13:
            FragmentActivity r5 = r3.getActivity();     // Catch: Throwable -> L17
            if (r5 == null) goto L24;
            r5.finish();     // Catch: Throwable -> L17
            return;
        L24:
            return;
        L17:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L25;
            throw th;
        }
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ InnerVideoPreviewFragment a;

        public c(InnerVideoPreviewFragment r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            InnerVideoPreviewFragment r0 = this.a;
            if (r0.j == true) goto L12;
            VideoView r1 = r0.h;
            if (r1 == null) goto L7;
            r1.setVisibility(8);
        L7:
            g r2 = this.a.g;
            if (r2 == null) goto L10;
            r2.j();
        L10:
            this.a.j = true;
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.video.a
    public final boolean onBackPressed() {
        ImageView r0 = this.l;
        if (r0 == null) goto L5;
        ViewParent r1 = r0.getParent();
    L6:
        if (r1 != null) goto L10;
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(-1, -1);
        ViewGroup r3 = this.k;
        if (r3 == null) goto L10;
        r3.addView(this.l, r2);
    L10:
        UICallbackExecutor.post(new b(this));
        return true;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.video.p
    public final void tD() {
        if (this.h == null) goto L12;
        ViewGroup r0 = this.k;
        if (r0 == null) goto L7;
        r0.removeView(this.l);
    L7:
        VideoView r1 = this.h;
        if (r1 == null) goto L10;
        r1.setVisibility(0);
    L10:
        S90(false);
        return;
    }

    public InnerVideoPreviewFragment() {
        this.m = true;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        VideoView r0 = this.h;
        if (r0 == null) goto L5;
        r0.i();
    L5:
        this.h = null;
    }

    public final void onDetach() {
        super.onDetach();
        this.g = null;
    }

    public final void onPause() {
        super.onPause();
        VideoView r0 = this.h;
        if (r0 == null) goto L19;
        v r1 = r0.a;
        boolean r3 = false;
        if (r1.f() == false) goto L16;
        s r2 = r1.a;
        if (r2.b() == true) goto L9;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == false) goto L16;
        r3 = true;
        goto L16
    L9:
        if (((com.ss.android.lark.player.player.b) r2).a == (-1)) goto L13;
        if (r2.g.getPlaybackState() != 1) goto L13;
        r4 = true;
    L16:
        if (r3 == false) goto L20;
        r0.f();
        return;
    L20:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.ss.android.lark.chat.video.InnerVideoPreviewFragment$playVideo$1] */
    public final void S90(boolean r5) {
        VideoProperty.Site r0 = this.n;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        String r2 = null;
        if (r1 == false) goto L19;
        String r6 = this.d;
        if (r6 == null) goto L13;
        r2 = r6;
    L14:
        this.f = r2;
        VideoView r7 = this.h;
        if (r7 == null) goto L25;
        UICallbackExecutor.execute(new com.ss.android.lark.chat.video.b(this, r7));
        return;
    L25:
        return;
    L13:
        Intrinsics.throwUninitializedPropertyAccessException("mVideoOriginUrl");
        goto L14
    L19:
        ChatAppContainerV1 r3 = ChatAppContainerV1.a;
        m6b.n r4 = (m6b.n) e0c.k.a(LarkContext.getApplication(), m6b.n.class);
        String r8 = this.d;
        if (r8 == null) goto L22;
        r2 = r8;
    L23:
        r4.Z2(r2, r5, new InnerVideoPreviewFragment$playVideo$1(this));
        return;
    L22:
        Intrinsics.throwUninitializedPropertyAccessException("mVideoOriginUrl");
        goto L23
    L5:
        if (r0.getValue() != 0) goto L7;
        r1 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.onAttach(r2);
        if ((r2 instanceof g) == false) goto L6;
        this.g = (g) r2;
        return;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        boolean r0 = true;
        if (r2.orientation == 1) goto L6;
        r0 = false;
    L6:
        this.m = r0;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L11;
        this.n = (VideoProperty.Site) r4.getSerializable("video_site");
        String r0 = r4.getString("video_origin_url");
        this.e = r4.getSerializable("video_cover");
        if (r0 == null) goto L7;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.d = r0;
        return;
    L7:
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L13;
        r5.finishAfterTransition();
        return;
    L13:
        return;
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        FrameLayout r7 = new FrameLayout(r4.getContext());
        this.k = r7;
        r7.setTransitionName("show_video_share_element");
        FragmentActivity r8 = getActivity();
        if (r8 == null) goto L21;
        if (r8.isFinishing() == true) goto L7;
        v0c.s r9 = new v0c.s();
        h r10 = new h(getActivity(), this.e);
        this.i = r10;
        r10.v = new com.ss.android.lark.chat.video.c(this);
        r10.w = new d(this);
        n r11 = new n(getActivity());
        r11.f = new e(this);
        r11.g = new f(this);
        o r0 = new o(getActivity());
        r9.e("controller", this.i);
        r9.e(Keys.API_RETURN_KEY_ERROR, r11);
        r9.e("loading", r0);
        this.h = new VideoView(r4.getContext());
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-1, -1);
        VideoView r1 = this.h;
        if (r1 == null) goto L21;
        ViewGroup r2 = this.k;
        if (r2 == null) goto L13;
        r2.addView(r1, r12);
    L13:
        ImageView r3 = new ImageView(r4.getContext());
        this.l = r3;
        r3.setBackgroundColor(-16777216);
        ViewGroup r13 = this.k;
        if (r13 == null) goto L16;
        r13.addView(this.l, r12);
    L16:
        Image r14 = this.e;
        if (r14 == null) goto L19;
        EncryptImage r15 = new EncryptImage(r14);
        ImageLoader.with(getContext()).load(r15).error(2131231112).into(this.l);
    L19:
        r1.setReceiverGroup(r9);
        r1.getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
        goto L21
    L7:
        return this.k;
    L21:
        return this.k;
    }
}
