package com.larus.avlink.gallery;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.bigimg.t1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.viewholder.LifeViewHolder;
import com.larus.common_ui.photoviewer.transition.TransitionViewHolder;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.home.impl.sdk.s;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IVideoController;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001b*\u0001#\b\u0007\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0003GHIB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010%\u001a\u00020&2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\nH\u0016J\u0012\u0010+\u001a\u00020&2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0002J\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020&H\u0002J\b\u00101\u001a\u00020&H\u0002J\b\u00102\u001a\u00020&H\u0002J\b\u00103\u001a\u00020\nH\u0002J\"\u00104\u001a\u00020&2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00105\u001a\u00020\u001a2\b\u00106\u001a\u0004\u0018\u00010(H\u0002J\u0010\u00107\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J)\u00108\u001a\u00020\u001a2\u0006\u00109\u001a\u00020(2\b\u0010:\u001a\u0004\u0018\u00010/2\b\u0010;\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0002\u0010<J\u0010\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020/H\u0002J\b\u0010?\u001a\u00020&H\u0002J!\u0010@\u001a\u00020&2\b\u0010:\u001a\u0004\u0018\u00010/2\b\u0010;\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0002\u0010AJ\b\u0010B\u001a\u00020&H\u0002J\b\u0010C\u001a\u00020&H\u0002J\b\u0010D\u001a\u00020&H\u0016J\b\u0010E\u001a\u00020&H\u0016J\b\u0010F\u001a\u00020&H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$¨\u0006J"}, d2 = {"Lcom/larus/avlink/gallery/VideoVH;", "Lcom/larus/bmhome/viewholder/LifeViewHolder;", "Lcom/larus/bmhome/viewholder/ITransitionHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "currentState", "Lcom/larus/avlink/gallery/VideoVH$PlayState;", "isSelected", "", "isAttached", "draging", "latestDragSeekTime", "", "videoContent", "Lcom/larus/platform/model/video/VideoPlayData;", "videoView", "Lcom/larus/avlink/gallery/DoraGalleryVideoPlayView;", "videoPlayControl", "Lcom/larus/bmhome/video/view/IVideoPlayControl;", "mediaInfo", "Lcom/larus/bmhome/bigimg/ImagePreviewDownloadUrl;", "mediaItem", "Lcom/larus/bmhome/bigimg/MediaItem;", "resolvedDisplaySize", "Lcom/larus/avlink/gallery/VideoVH$VideoDisplaySize;", "prepareDataJob", "Lkotlinx/coroutines/Job;", "hasSetupCompletionListener", "videoEngine", "Lcom/larus/platform/api/IVideoController;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleObserver", "com/larus/avlink/gallery/VideoVH$lifecycleObserver$1", "Lcom/larus/avlink/gallery/VideoVH$lifecycleObserver$1;", "bindMediaData", "", "orNull", "", "updateSelectionState", "selected", "prepareVideoData", "evaluatePlaybackState", "startPlayback", "getMediaPlayerType", "", "stopPlayback", "pausePlayback", "resumePlayback", "isCurrentlyPlaying", "updateVideoContent", "displaySize", "coverPath", "createPlaceholderVideoContent", "resolveVideoDisplaySize", "videoPath", "fallbackWidth", "fallbackHeight", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/avlink/gallery/VideoVH$VideoDisplaySize;", "shouldSwapVideoSize", "rotation", "applyVideoCover", "syncResolvedVideoDisplaySize", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "initVideoPlayControlAsync", "initSeekbar", "onFullyAttach", "onFullyDetach", "onDismiss", "VideoDisplaySize", "Companion", "PlayState", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class VideoVH extends LifeViewHolder {
    public static final /* synthetic */ int y = 0;
    public PlayState k;
    public boolean l;
    public boolean m;
    public long n;
    public nr9.g o;
    public final DoraGalleryVideoPlayView p;
    public qs8.a q;
    public n1 r;
    public t1 s;
    public c t;
    public Job u;
    public IVideoController v;
    public final LifecycleOwner w;
    public final VideoVH$lifecycleObserver$1 x;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/avlink/gallery/VideoVH$PlayState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "DATA_PREPARING", "DATA_READY", "SHOULD_PLAY", "PLAYING", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum PlayState extends Enum<PlayState> {
        public static final PlayState DATA_PREPARING = null;
        public static final PlayState DATA_READY = null;
        public static final PlayState IDLE = null;
        public static final PlayState PLAYING = null;
        public static final PlayState SHOULD_PLAY = null;
        public static final /* synthetic */ PlayState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PlayState> getEntries() {
            return b;
        }

        static {
            PlayState r0 = new PlayState("IDLE", 0);
            IDLE = r0;
            PlayState r1 = new PlayState("DATA_PREPARING", 1);
            DATA_PREPARING = r1;
            PlayState r3 = new PlayState("DATA_READY", 2);
            DATA_READY = r3;
            PlayState r5 = new PlayState("SHOULD_PLAY", 3);
            SHOULD_PLAY = r5;
            PlayState r7 = new PlayState("PLAYING", 4);
            PLAYING = r7;
            PlayState[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
        }

        public static PlayState[] values() {
            return (PlayState[]) a.clone();
        }

        public static PlayState valueOf(String r1) {
            return (PlayState) r27.a.a(PlayState.class, r1);
        }

        public PlayState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements l19.f {
        public final /* synthetic */ VideoVH a;

        public a(VideoVH r1) {
            this.a = r1;
        }

        public final void onTransitionBegin(int r3) {
            if (r3 != 0) goto L5;
            this.a.p.setRelayoutSuppressedDuringTransition(true);
            VideoVH r4 = this.a;
            r4.p.S(((TransitionViewHolder) r4).a.getWidth(), ((TransitionViewHolder) this.a).a.getHeight());
            return;
        }

        public final void onTransitionEnd(int r3) {
            if (r3 != 0) goto L5;
            VideoVH r4 = this.a;
            r4.p.S(((TransitionViewHolder) r4).a.getWidth(), ((TransitionViewHolder) this.a).a.getHeight());
            this.a.p.setRelayoutSuppressedDuringTransition(false);
            return;
        }

        public final void onTransitionChanged(int r2, float r3) {
            if (r2 != 0) goto L5;
            VideoVH r4 = this.a;
            r4.p.S(((TransitionViewHolder) r4).a.getWidth(), ((TransitionViewHolder) this.a).a.getHeight());
            return;
        }
    }

    public static final class b {
    }

    public static final class c {
        public final Integer a;
        public final Integer b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Integer r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "VideoDisplaySize(width=" + this.a + ", height=" + this.b + ')';
        }

        public c(Integer r1, Integer r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final void V3() {
        FLogger r0 = FLogger.a;
        r0.i("VideoVH", "video stop by dismiss, position=" + getBindingAdapterPosition());
        Job r1 = this.u;
        boolean r3 = true;
        if (r1 == null) goto L5;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L5:
        this.k = PlayState.IDLE;
        this.l = false;
        this.p.N();
        StringBuilder r4 = new StringBuilder("Release video engine : ");
        IVideoController r5 = this.v;
        if (r5 == null) goto L8;
        int r6 = r5.hashCode();
    L9:
        r4.append(r6);
        r0.i("VideoVH", r4.toString());
        IVideoController r2 = this.v;
        if (r2 != null) goto L12;
    L14:
        r3 = false;
    L15:
        if (r3 == false) goto L19;
        IVideoController r7 = this.v;
        if (r7 == null) goto L19;
        r7.release();
    L19:
        LifecycleOwner r8 = this.w;
        if (r8 == null) goto L25;
        Lifecycle r9 = r8.getLifecycle();
        if (r9 == null) goto L26;
        r9.removeObserver(this.x);
        return;
    L26:
        return;
    L25:
        return;
    L12:
        if (r2.isReleased() == true) goto L14;
    L8:
        r6 = 0;
        goto L9
    }

    public final void W3() {
        FLogger.a.d("VideoVH", "onFullyDetach: currentState=" + this.k + ", position=" + getBindingAdapterPosition());
        if (this.k != PlayState.PLAYING) goto L6;
        VideoPlayView.z(this.p, 0, 2);
        return;
    }

    public final void b4() {
        c r1 = this.t;
        int r2 = 0;
        Bitmap r3 = null;
        if (r1 == null) goto L7;
        Integer r4 = r1.a;
        if (r4 == null) goto L7;
    L12:
        int r5 = r4.intValue();
    L14:
        c r6 = this.t;
        if (r6 == null) goto L19;
        Integer r7 = r6.b;
        if (r7 == null) goto L19;
    L24:
        r2 = r7.intValue();
    L25:
        Integer r8 = Integer.valueOf(r5);
        Integer r9 = Integer.valueOf(r2);
        c r10 = this.t;
        if (r10 == null) goto L31;
        Integer r11 = r10.a;
        if (r11 == null) goto L31;
        r8 = r11;
    L31:
        if (r10 == null) goto L36;
        Integer r12 = r10.b;
        if (r12 == null) goto L36;
        r9 = r12;
    L36:
        if (r8 == null) goto L58;
        if (r9 == null) goto L58;
        if (r8.intValue() <= 0) goto L58;
        if (r9.intValue() <= 0) goto L58;
        VideoPlayView r13 = this.p;
        int r14 = r8.intValue();
        int r15 = r9.intValue();
        r13.getClass();
        if (r14 <= 0) goto L58;
        if (r15 <= 0) goto L58;
        if (r14 == 0) goto L50;
        if (r15 == 0) goto L50;
        r13.l = r14 / r15;
    L50:
        com.larus.common_ui.video.b r16 = r13.getDisplayMode();
        if (r16 == null) goto L54;
        r16.a = r14;
        r16.b = r15;
        r16.a();
    L54:
        if (r13.getWidth() <= 0) goto L58;
        if (r13.getHeight() <= 0) goto L58;
        r13.m();
    L58:
        DoraGalleryVideoPlayView r17 = this.p;
        nr9.f r18 = this.o.g;
        if (r18 == null) goto L61;
        String r19 = r18.a;
    L62:
        if (r18 == null) goto L64;
        String r20 = r18.b;
    L65:
        if (r18 == null) goto L67;
        String r110 = r18.c;
    L68:
        Integer r111 = Integer.valueOf(r2);
        Integer r112 = Integer.valueOf(r5);
        nr9.f r21 = this.o.g;
        if (r21 == null) goto L71;
        r3 = r21.f;
    L71:
        VideoPlayView.p(r17, r19, r20, r110, r111, r112, r3, null, null, 192);
        return;
    L67:
        r110 = null;
        goto L68
    L64:
        r20 = null;
        goto L65
    L61:
        r19 = null;
    L19:
        nr9.f r22 = this.o.g;
        if (r22 == null) goto L22;
        r7 = r22.d;
    L23:
        if (r7 == null) goto L25;
    L22:
        r7 = null;
    L7:
        nr9.f r23 = this.o.g;
        if (r23 == null) goto L10;
        r4 = r23.e;
    L11:
        if (r4 != null) goto L12;
        r5 = 0;
        goto L14
    L10:
        r4 = null;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r1v26, types: [android.widget.FrameLayout, com.larus.avlink.gallery.DoraGalleryVideoPlayView, com.larus.common_ui.video.VideoPlayView] */
    public final void d4() {
        FLogger r0 = FLogger.a;
        r0.d("VideoVH", "evaluatePlaybackState: selected=" + this.l + ", state=" + this.k + ", attached=false, position=" + getBindingAdapterPosition());
        boolean r1 = this.l;
        boolean r3 = false;
        if (r1 == false) goto L54;
        PlayState r5 = this.k;
        if (r5 != PlayState.DATA_READY) goto L54;
        PlayState r6 = PlayState.PLAYING;
        if (r5 != r6) goto L9;
        boolean r7 = true;
    L10:
        if (r7 == true) goto L54;
        if (r5 != r6) goto L14;
        r0.w("VideoVH", "Already playing, skipping start");
        return;
    L14:
        if (this.r != null) goto L16;
        r0.w("VideoVH", "MediaInfo is null, cannot start playback");
        return;
    L16:
        r0.i("VideoVH", "Starting playback for position: " + getBindingAdapterPosition());
        this.k = r6;
        n1 r2 = this.r;
        if (r2 == null) goto L72;
        String r4 = r2.c;
        if (r4 == null) goto L24;
        String r8 = StringsKt.removePrefix(r4, "file://");
        if (r8 == null) goto L24;
        String r9 = r8;
    L25:
        r0.i("VideoVH", "bindVideoWithViewModel with path: ".concat(r9));
        ps8.a r10 = IAIChatUgcAIGCService.a.L();
        IFlowSdkDepend r11 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r11 == null) goto L32;
        s r12 = r11.s0();
        if (r12 == null) goto L32;
        if (r12.J() != true) goto L32;
        boolean r13 = true;
    L33:
        if (r13 == false) goto L35;
        int r14 = 2;
    L36:
        this.v = r10.c("VideoVH", Integer.valueOf(r14), "");
        StringBuilder r15 = new StringBuilder("bindVideoWithViewModel new videoEngine: ");
        IVideoController r16 = this.v;
        if (r16 == null) goto L39;
        int r17 = r16.hashCode();
    L40:
        r15.append(r17);
        r0.i("VideoVH", r15.toString());
        VideoPlayView.e(this.p, this.v, null, r9, null, null, null, 58);
        b4();
        final ?? r18 = this.p;
        r18.setOnLongClickListener(new m(this));
        r18.w(new n(this, r18));
        r0.i("VideoVH", "Calling videoView.start() for position: " + getBindingAdapterPosition());
        r18.M();
        r0.i("VideoVH", "videoView.start() completed, isPlaying=" + r18.r() + ", position: " + getBindingAdapterPosition());
        qs8.a r19 = this.q;
        if (r19 == null) goto L43;
        r19.h3();
    L43:
        qs8.a r20 = this.q;
        if (r20 == null) goto L51;
        t1 r21 = this.s;
        if (r21 != null) goto L48;
    L50:
        r20.setProgressViewVisibility(r3);
        goto L51
    L48:
        if (r21.d() != true) goto L50;
        r3 = true;
    L51:
        qs8.a r22 = this.q;
        if (r22 == null) goto L73;
        r22.z1(new o(this));
        return;
    L73:
        return;
    L39:
        r17 = 0;
        goto L40
    L35:
        r14 = 0;
    L32:
        r13 = false;
    L24:
        r9 = "";
        goto L25
    L72:
        return;
    L9:
        r7 = false;
    L54:
        if (r1 == true) goto L56;
    L58:
        if (r1 == true) goto L60;
    L61:
        if (r1 == false) goto L63;
        return;
    L63:
        if (this.k != PlayState.PLAYING) goto L65;
        r3 = true;
    L65:
        if (r3 == false) goto L78;
        r0.i("VideoVH", "Stopping playback for position: " + getBindingAdapterPosition() + ", calling videoView.stop()");
        this.k = PlayState.DATA_READY;
        this.p.N();
        r0.i("VideoVH", "videoView.stop() completed for position: " + getBindingAdapterPosition());
        qs8.a r23 = this.q;
        if (r23 == null) goto L79;
        r23.J1(0.0f, true);
        return;
    L79:
        return;
    L78:
        return;
    L60:
        if (this.k != PlayState.SHOULD_PLAY) goto L61;
        return;
    L56:
        if (this.k != PlayState.DATA_PREPARING) goto L58;
        this.k = PlayState.SHOULD_PLAY;
        r0.i("VideoVH", "Marked for playback, waiting for data preparation");
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [android.widget.FrameLayout, com.larus.avlink.gallery.DoraGalleryVideoPlayView, com.larus.common_ui.video.VideoPlayView] */
    public VideoVH(View r14) {
        Intrinsics.checkNotNullParameter(r14, "itemView");
        super(r14);
        this.k = PlayState.IDLE;
        this.o = new nr9.g(null, null, null, null, null, null, null, null, null, null, 1023);
        ?? r0 = (DoraGalleryVideoPlayView) r14.findViewById(2131392404);
        if (((VideoPlayView) r0).a != null) goto L10;
        FLogger.a.i("VideoPlayView", "init displayMode DISPLAY_MODE_ASPECT_FIT");
        com.larus.common_ui.video.b r1 = new com.larus.common_ui.video.b();
        ((VideoPlayView) r0).a = r1;
        r1.d = r0;
        r1.a();
        com.larus.common_ui.video.b r2 = ((VideoPlayView) r0).a;
        if (r2 == null) goto L7;
        r2.c = 3;
        r2.a();
    L7:
        com.larus.common_ui.video.b r3 = ((VideoPlayView) r0).a;
        if (r3 == null) goto L10;
        r3.e = ((VideoPlayView) r0).f;
        r3.a();
    L10:
        this.p = r0;
        LifecycleOwner r15 = r14.getContext();
        if ((r15 instanceof LifecycleOwner) == false) goto L13;
        LifecycleOwner r16 = r15;
    L14:
        this.w = r16;
        LifecycleObserver r4 = new VideoVH$lifecycleObserver$1(this);
        this.x = r4;
        if (r16 == null) goto L19;
        Lifecycle r17 = r16.getLifecycle();
        if (r17 == null) goto L19;
        r17.addObserver(r4);
    L19:
        T3().c(new a(this));
        return;
    L13:
        r16 = null;
        goto L14
    }

    public final void Y3(boolean r4) {
        FLogger.a.i("VideoVH", "updateSelectionState: " + r4 + ", currentState: " + this.k + ", position: " + getBindingAdapterPosition());
        this.l = r4;
        d4();
    }

    public static String c4(MediaMetadataRetriever r18, int r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19)};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100023);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(100023, "android/media/MediaMetadataRetriever", "extractMetadata", r18, r1, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r18.extractMetadata(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public final void U3(n1 r19, String r20) {
        Intrinsics.checkNotNullParameter(r19, "mediaInfo");
        super.U3(r19, r20);
        FLogger r2 = FLogger.a;
        r2.i("VideoVH", "bindMediaData: position=" + getBindingAdapterPosition() + ", transitioning to DATA_PREPARING");
        Job r3 = this.u;
        if (r3 == null) goto L5;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L5:
        this.k = PlayState.DATA_PREPARING;
        ((LifeViewHolder) this).g.invoke(Integer.valueOf(getBindingAdapterPosition()));
        this.r = r19;
        yt8.p r4 = r19.b;
        this.s = r4;
        this.t = null;
        if ((r4 instanceof yt8.p) == false) goto L8;
        yt8.p r5 = r4;
    L10:
        if (r5 == null) goto L12;
        Integer r9 = Integer.valueOf(r5.m);
    L13:
        if (r5 == null) goto L15;
        Integer r10 = Integer.valueOf(r5.l);
    L16:
        nr9.f r13 = new nr9.f(null, null, null, r9, r10, null, 39);
        String r6 = r19.c;
        if (r6 == null) goto L20;
        String r7 = StringsKt.removePrefix(r6, "file://");
        if (r7 == null) goto L20;
    L21:
        String r14 = r7;
        if (r5 == null) goto L24;
        Double r11 = Double.valueOf(r5.k);
    L25:
        this.o = new nr9.g(null, null, null, null, r11, null, r13, r14, null, null, 815);
        DoraGalleryVideoPlayView r8 = this.p;
        ImageLoaderKt.b(r8.getMCoverView());
        ImageLoaderKt.e(r8.getMCoverView());
        r8.getMCoverView().setImageDrawable(null);
        r8.getMCoverView().setVisibility(8);
        if (this.q != null) goto L36;
        qs8.a r12 = IAIChatUgcAIGCService.a.B0(((RecyclerView.ViewHolder) this).itemView.getContext());
        this.q = r12;
        if (r12 == null) goto L36;
        View r15 = r12.asView();
        if (r15 == null) goto L36;
        FrameLayout r16 = (FrameLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131364437);
        if (r16 == null) goto L34;
        i0.a.getClass();
        int r17 = i0.e() + i5.h();
        int r18 = r16.getPaddingStart();
        int r21 = r16.getPaddingTop();
        int r22 = r16.getPaddingEnd();
        r2.i("updatePaddingRelative", "view:" + r16.getClass().getSimpleName() + ",source:,start:" + r18 + ",top:" + r21 + ",end:" + r22 + ",bottom:" + r17);
        r16.setPaddingRelative(r18, r21, r22, r17);
    L34:
        if (r16 == null) goto L36;
        r16.addView(r15, new FrameLayout.LayoutParams(-1, -2, 80));
    L36:
        this.u = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new VideoVH$prepareVideoData$1(r19, this, null), 3, null);
        return;
    L24:
        r11 = null;
    L20:
        r7 = "";
        goto L21
    L15:
        r10 = null;
        goto L16
    L12:
        r9 = null;
        goto L13
    L8:
        r5 = null;
        goto L10
    }

    public static final c Z3(VideoVH r4, String r5, Integer r6, Integer r7) {
        r4.getClass();
        if (StringsKt.isBlank(r5) == true) goto L54;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L43
        MediaMetadataRetriever r9 = new MediaMetadataRetriever();     // Catch: Throwable -> L43
        r9.setDataSource(r5);     // Catch: Throwable -> L40
        String r10 = c4(r9, 24);     // Catch: Throwable -> L40
        boolean r0 = false;
        if (r10 == null) goto L11;
        Integer r11 = StringsKt.toIntOrNull(r10);     // Catch: Throwable -> L40
        if (r11 == null) goto L11;
        int r12 = r11.intValue();     // Catch: Throwable -> L40
    L12:
        String r1 = c4(r9, 18);     // Catch: Throwable -> L40
        Integer r2 = null;
        if (r1 == null) goto L15;
        Integer r3 = StringsKt.toIntOrNull(r1);     // Catch: Throwable -> L40
    L16:
        String r13 = c4(r9, 19);     // Catch: Throwable -> L40
        if (r13 == null) goto L19;
        r2 = StringsKt.toIntOrNull(r13);     // Catch: Throwable -> L40
    L19:
        int r14 = ((r12 % 360) + 360) % 360;     // Catch: Throwable -> L40
        if (r14 != 90) goto L22;
    L23:
        r0 = true;
    L25:
        if (r0 == false) goto L29;
        if (r2 == null) goto L30;
        Integer r15 = r2;
    L32:
        if (r0 == false) goto L35;
        if (r3 == null) goto L36;
    L38:
        c r16 = new c(r15, r3);     // Catch: Throwable -> L40
        r9.release();     // Catch: Throwable -> L43
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L43
    L45:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L50;
        FLogger.a.w("VideoVH", "Failed to resolve video display size: " + r18.getMessage());
        r17 = new c(r6, r7);
    L50:
        return (c) r17;
    L36:
        r3 = r7;
        goto L38
    L35:
        if (r2 == null) goto L36;
        r3 = r2;
    L30:
        r15 = r6;
        goto L32
    L29:
        if (r3 == null) goto L30;
        r15 = r3;
        goto L32
    L22:
        if (r14 != 270) goto L25;
    L15:
        r3 = null;
    L11:
        r12 = 0;
    L40:
        th = move-exception;
        r9.release();     // Catch: Throwable -> L43
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    L54:
        return new c(r6, r7);
    }

    public static final void a4(VideoVH r18, n1 r19, c r20, String r21) {
        r18.getClass();
        yt8.p r3 = r19.b;
        Double r5 = null;
        if ((r3 instanceof yt8.p) == false) goto L5;
        yt8.p r4 = r3;
    L6:
        String r0 = r19.c;
        if (r0 == null) goto L10;
        String r1 = StringsKt.removePrefix(r0, "file://");
        if (r1 == null) goto L10;
    L11:
        String r14 = r1;
        if (r21 == null) goto L14;
        String r9 = "file://".concat(r21);
    L15:
        nr9.f r2 = new nr9.f(null, null, r9, r20.b, r20.a, null, 35);
        if (r4 == null) goto L18;
        r5 = Double.valueOf(r4.k);
    L18:
        r18.o = new nr9.g(null, null, null, null, r5, null, r2, r14, null, null, 815);
        return;
    L14:
        r9 = null;
    L10:
        r1 = "";
        goto L11
    L5:
        r4 = null;
        goto L6
    }
}
