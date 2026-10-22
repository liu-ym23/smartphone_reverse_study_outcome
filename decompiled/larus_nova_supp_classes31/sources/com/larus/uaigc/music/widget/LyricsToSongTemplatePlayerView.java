package com.larus.uaigc.music.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility;
import com.larus.bmhome.chat.e4;
import com.larus.bmhome.music.player.VideoEngineMusicPlayerViewImpl;
import com.larus.bmhome.music.player.a;
import com.larus.bmhome.music.player.j;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.CircleProgressBar;
import com.larus.home.impl.sdk.i;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kr8.o;
import xz9.b;
import xz9.c;
import xz9.d;
import xz9.e;
import xz9.f;
import xz9.g;
import xz9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000*\u0001C\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020'J\u000e\u0010)\u001a\u00020'2\u0006\u0010\"\u001a\u00020!J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\tH\u0002J:\u00101\u001a\u00020'2\b\u00102\u001a\u0004\u0018\u00010\u00182\u0006\u00103\u001a\u00020\t2\b\b\u0002\u00104\u001a\u00020.2\n\b\u0002\u00105\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100J\u0006\u00106\u001a\u00020'J\b\u00107\u001a\u00020'H\u0016J\b\u00108\u001a\u00020'H\u0016J\b\u00109\u001a\u00020'H\u0016J\b\u0010:\u001a\u00020'H\u0016J\b\u0010;\u001a\u00020'H\u0016J\b\u0010<\u001a\u00020'H\u0016J\b\u0010=\u001a\u00020'H\u0016J\b\u0010>\u001a\u00020'H\u0016J\b\u0010@\u001a\u00020'H\u0014J\b\u0010A\u001a\u00020'H\u0014J\n\u0010E\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010F\u001a\u00020\u001bH\u0016J\u0018\u0010G\u001a\u00020'2\u0006\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020!H\u0016J\b\u0010J\u001a\u00020'H\u0016J\b\u0010K\u001a\u00020'H\u0016J\u0006\u0010L\u001a\u00020\tJ\b\u0010M\u001a\u00020'H\u0002J\n\u0010N\u001a\u0004\u0018\u00010OH\u0002R\u0014\u0010\f\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010D¨\u0006P"}, d2 = {"Lcom/larus/uaigc/music/widget/LyricsToSongTemplatePlayerView;", "Landroid/widget/FrameLayout;", "Lcom/larus/bmhome/music/player/BoxMusicPlayer$PlayerView;", "Lcom/larus/bmhome/creative/api/IMusicPlayerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewContext", "getViewContext", "()Landroid/content/Context;", "mProgressBar", "Lcom/larus/common_ui/widget/CircleProgressBar;", "mLoadingView", "Lcom/lynx/lottieadapter/LottieAdapterView;", "mPlayIcon", "Landroid/widget/ImageView;", "mPauseIcon", "showingProgress", "mMusicContent", "Lcom/larus/im/bean/message/block/MusicCreationContent;", "mIndex", "scope", "Lkotlinx/coroutines/CoroutineScope;", "mPlayer", "Lcom/larus/bmhome/music/player/BoxMusicPlayer;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "destroyed", "", "useFragmentLifecycleOwner", "autoPauseWhenSwitchTab", "getAutoPauseWhenSwitchTab", "()Z", "createSmall", "", "createMedium", "setUseFragmentLifecycleOwner", "create", "Landroid/view/View;", "layout", "mCurrentPage", "", "musicAppletMobContext", "Lcom/larus/bmhome/music/mob/MusicAppletMobContext;", "bindData", "musicCreationContent", "index", "currentPage", "showFrom", "rebind", "showReadyState", "showPlayingState", "hideLoadingView", "showLoadingView", "hidePlayIcon", "showPlayIcon", "hideProgressBarView", "showProgressBarView", "attached", "onAttachedToWindow", "onDetachedFromWindow", "lifecycleObserver", "com/larus/uaigc/music/widget/LyricsToSongTemplatePlayerView$lifecycleObserver$1", "Lcom/larus/uaigc/music/widget/LyricsToSongTemplatePlayerView$lifecycleObserver$1;", "resolveLifecycleOwner", "getScope", "setProgress", "progress", "smooth", "forceStop", "destroy", "getViewProgress", "showMusicLoadingState", "getCurBottomTabFrag", "Landroidx/fragment/app/Fragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class LyricsToSongTemplatePlayerView extends FrameLayout implements a.a, bp8.a {
    public static final /* synthetic */ int p = 0;
    public final Context a;
    public CircleProgressBar b;
    public ImageView c;
    public ImageView d;
    public MusicCreationContent e;
    public int f;
    public final GlobalScope g;
    public VideoEngineMusicPlayerViewImpl h;
    public LifecycleOwner i;
    public boolean j;
    public boolean k;
    public String l;
    public o m;
    public boolean n;
    public final LyricsToSongTemplatePlayerView$lifecycleObserver$1 o;

    public LyricsToSongTemplatePlayerView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LyricsToSongTemplatePlayerView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void Pe(float r1, boolean r2) {
    }

    private final boolean getAutoPauseWhenSwitchTab() {
        if ((AppHost.a.a().getCurrentActivity() instanceof e4) == false) goto L5;
    L8:
        return true;
    L5:
        if ((getCurBottomTabFrag() instanceof IChatDoubleTabAbility) == true) goto L8;
        return false;
    }

    private final Fragment getCurBottomTabFrag() {
        if (z2.a.enableChatWithTab() == true) goto L5;
        return null;
    L5:
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L9;
        r0.f0();
        return i.a.a();
    L9:
        return null;
    }

    public final void Lf() {
        CircleProgressBar r0 = this.b;
        if (r0 == null) goto L6;
        r0.post(new h(this));
        return;
    }

    public final void Lr() {
        ImageView r0 = this.c;
        if (r0 == null) goto L6;
        r0.post(new xz9.a(this));
        return;
    }

    public final void OK() {
        ImageView r0 = this.c;
        if (r0 == null) goto L6;
        r0.post(new b(this));
        return;
    }

    public final void UY() {
        CircleProgressBar r0 = this.b;
        if (r0 == null) goto L6;
        r0.post(new e(this));
        return;
    }

    public final void a() {
        VideoEngineMusicPlayerViewImpl r0 = this.h;
        if (r0 == null) goto L5;
        r0.k(true);
    L5:
        VideoEngineMusicPlayerViewImpl r1 = this.h;
        if (r1 == null) goto L9;
        r1.onPaused();
        return;
    }

    public final void destroy() {
        if (this.j == false) goto L5;
        return;
    L5:
        this.j = true;
        LifecycleOwner r0 = this.i;
        if (r0 == null) goto L10;
        Lifecycle r1 = r0.getLifecycle();
        if (r1 == null) goto L10;
        r1.removeObserver(this.o);
    L10:
        this.i = null;
        this.n = false;
        VideoEngineMusicPlayerViewImpl r2 = this.h;
        if (r2 == null) goto L13;
        r2.onDetachedFromWindow();
    L13:
        VideoEngineMusicPlayerViewImpl r3 = this.h;
        if (r3 == null) goto L17;
        r3.onDestroyed();
        return;
    }

    public final LifecycleOwner e() {
        if (this.k == false) goto L5;
    L8:
        Intrinsics.checkNotNullParameter(this, "<this>");
        return FragmentManager.findFragment(this).getViewLifecycleOwner();
    L5:
        if (getAutoPauseWhenSwitchTab() == true) goto L8;
        Intrinsics.checkNotNullParameter(this, "<this>");
        return FragmentManager.findFragment(this).getActivity();
    }

    public final int getViewProgress() {
        CircleProgressBar r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getProgress();
    }

    public final void hideLoadingView() {
        CircleProgressBar r0 = this.b;
        if (r0 == null) goto L6;
        r0.post(new f(this));
        return;
    }

    public final void d() {
        View r0 = LayoutInflater.from(getContext()).inflate(2131562978, this);
        com.larus.bmhome.music.player.f r1 = com.larus.bmhome.music.player.f.a;
        Intrinsics.checkNotNullParameter(this, "parent");
        this.h = new VideoEngineMusicPlayerViewImpl(this, null);
        Intrinsics.checkNotNull(r0);
        this.b = r0.findViewById(2131383297);
        LottieAdapterView r2 = r0.findViewById(2131379091);
        this.c = (ImageView) r0.findViewById(2131382435);
        this.d = (ImageView) r0.findViewById(2131381978);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.j = false;
        VideoEngineMusicPlayerViewImpl r0 = this.h;
        if (r0 == null) goto L6;
        r0.onAttachedToWindow();
    L6:
        if (this.n == true) goto L14;
        LifecycleOwner r1 = e();
        if (r1 == null) goto L12;
        Lifecycle r2 = r1.getLifecycle();
        if (r2 == null) goto L12;
        r2.addObserver(this.o);
    L12:
        this.i = r1;
        this.n = true;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VideoEngineMusicPlayerViewImpl r0 = this.h;
        if (r0 == null) goto L6;
        r0.onDetachedFromWindow();
        return;
    }

    public final void showLoadingView() {
        OK();
        CircleProgressBar r0 = this.b;
        if (r0 == null) goto L6;
        r0.post(new d(this));
        return;
    }

    public final void F6() {
        a.a.a.b();
    }

    public final void FK() {
        Lr();
    }

    public final void f20() {
        OK();
    }

    public CoroutineScope getScope() {
        return this.g;
    }

    public Context getViewContext() {
        return this.a;
    }

    public static final /* synthetic */ boolean b(LyricsToSongTemplatePlayerView r0) {
        return r0.getAutoPauseWhenSwitchTab();
    }

    public final void GP(Map<String, String> r1) {
        a.a.a.d(r1);
    }

    public final void Ij(Map<String, String> r1) {
        a.a.a.c(r1);
    }

    public final void eb(Map<String, String> r1) {
        a.a.a.a(r1);
    }

    public final void setUseFragmentLifecycleOwner(boolean r2) {
        if (this.k != r2) goto L5;
        return;
    L5:
        this.k = r2;
        if (this.n == false) goto L18;
        LifecycleOwner r3 = this.i;
        if (r3 == null) goto L12;
        Lifecycle r4 = r3.getLifecycle();
        if (r4 == null) goto L12;
        r4.removeObserver(this.o);
    L12:
        LifecycleOwner r5 = e();
        this.i = r5;
        if (r5 == null) goto L19;
        Lifecycle r6 = r5.getLifecycle();
        if (r6 == null) goto L20;
        r6.addObserver(this.o);
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void mP(final int r2, boolean r3) {
        CircleProgressBar r4 = this.b;
        if (r4 == null) goto L6;
        r4.post(new g(this, r2));
        return;
    }

    public final void r30(String r1, Map<String, String> r2) {
        a.a.a.e(r1, r2);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.uaigc.music.widget.LyricsToSongTemplatePlayerView$lifecycleObserver$1] */
    public LyricsToSongTemplatePlayerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = r2;
        this.g = GlobalScope.INSTANCE;
        this.l = "";
        this.o = new LyricsToSongTemplatePlayerView$lifecycleObserver$1(this);
    }

    public /* synthetic */ LyricsToSongTemplatePlayerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static void c(final LyricsToSongTemplatePlayerView r34, MusicCreationContent r35, int r36, String r37, String r38, o r39, int r40) {
        if ((r40 & 4) == 0) goto L5;
        String r3 = "chat";
    L7:
        if ((r40 & 8) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r40 & 16) == 0) goto L13;
        o r15 = null;
    L14:
        r34.getClass();
        Intrinsics.checkNotNullParameter(r3, "currentPage");
        r34.j = false;
        r34.e = r35;
        r34.f = r36;
        r34.l = r3;
        r34.m = r15;
        if (r35 == null) goto L46;
        if (r4 != null) goto L18;
        String r8 = "";
    L19:
        GlobalScope r13 = r34.g;
        if (r15 == null) goto L22;
        Lazy r5 = com.larus.bmhome.music.player.i.a;
        Context r6 = r34.getContext();
        Intrinsics.checkNotNullParameter(r6, "context");
        String r18 = "music_applet:" + r6;
    L23:
        String r12 = r35.getVid();
        String r7 = r35.getVideoModel();
        if (r7 != null) goto L26;
        String r11 = "";
    L27:
        if (r36 == 0) goto L29;
    L31:
        boolean r2 = false;
    L32:
        LruCache r9 = ko8.a.a;
        String r22 = ko8.a.e(ko8.a.e);
        String r10 = r35.getTitle();
        if (r10 != null) goto L35;
        String r23 = "";
    L36:
        String r14 = r35.getChunkUrl();
        if (r14 != null) goto L39;
        String r24 = "";
    L40:
        boolean r16 = r2;
        o r17 = r15;
        String r20 = r3;
        j r19 = new j(null, null, null, r8, "", -1, r11, r12, r16, false, r13, 0, r18, r17, r20, false, r22, r23, r24, r35 instanceof bq8.a, false, r35.getPlayList(), false, false, null, "music_gen", 30411271);
        VideoEngineMusicPlayerViewImpl r21 = r34.h;
        if (r21 == null) goto L44;
        r21.d(r19);
    L44:
        if (com.larus.bmhome.music.protocol.a.a(r35) == false) goto L50;
        e1.d(r34, new c(r34));
        return;
    L50:
        return;
    L39:
        r24 = r14;
        goto L40
    L35:
        r23 = r10;
        goto L36
    L29:
        if (Intrinsics.areEqual(r35.getPlayList().getItemId(), "0") == false) goto L31;
        r2 = true;
        goto L32
    L26:
        r11 = r7;
        goto L27
    L22:
        r18 = null;
        goto L23
    L18:
        r8 = r4;
        goto L19
    L46:
        ImageView r1 = r34.c;
        if (r1 == null) goto L52;
        r1.post(new xz9.i(r34));
        return;
    L52:
        return;
    L13:
        r15 = r39;
        goto L14
    L9:
        r4 = r38;
        goto L11
    L5:
        r3 = r37;
        goto L7
    }
}
