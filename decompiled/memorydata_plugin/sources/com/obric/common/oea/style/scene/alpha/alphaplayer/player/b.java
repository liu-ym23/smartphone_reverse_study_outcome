package com.obric.common.oea.style.scene.alpha.alphaplayer.player;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.Surface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\u0017H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006'"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/DefaultSystemPlayer;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/AbsPlayer;", "()V", "dataPath", "", "getDataPath", "()Ljava/lang/String;", "setDataPath", "(Ljava/lang/String;)V", "mediaPlayer", "Landroid/media/MediaPlayer;", "getMediaPlayer", "()Landroid/media/MediaPlayer;", "setMediaPlayer", "(Landroid/media/MediaPlayer;)V", "retriever", "Landroid/media/MediaMetadataRetriever;", "getRetriever", "()Landroid/media/MediaMetadataRetriever;", "getPlayerType", "getVideoInfo", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/VideoInfo;", "initMediaPlayer", "", "pause", "prepareAsync", "release", "reset", "setDataSource", "setLooping", "looping", "", "setScreenOnWhilePlaying", "onWhilePlaying", "setSurface", "surface", "Landroid/view/Surface;", CommonConsts.APM_INNER_EVENT_COST_START, "stop", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class b extends com.obric.common.oea.style.scene.alpha.alphaplayer.player.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaPlayer f7795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7796b;
    private final MediaMetadataRetriever c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "mediaPlayer", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "onCompletion"}, k = 3, mv = {1, 4, 3})
    static final class a implements MediaPlayer.OnCompletionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f7797a;

        a(b r1) {
            this.f7797a = r1;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer r1) {
            com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.a r0 = this.f7797a.a();
            if (r0 == null) goto L6;
            r0.a();
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.common.oea.style.scene.alpha.alphaplayer.player.b$b, reason: collision with other inner class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "mediaPlayer", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"}, k = 3, mv = {1, 4, 3})
    static final class C0379b implements MediaPlayer.OnPreparedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f7798a;

        C0379b(b r1) {
            this.f7798a = r1;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer r1) {
            com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.d r0 = this.f7798a.b();
            if (r0 == null) goto L6;
            r0.a();
            return;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "mp", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "what", "", WsConstants.KEY_EXTRA, "onError"}, k = 3, mv = {1, 4, 3})
    static final class c implements MediaPlayer.OnErrorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f7799a;

        c(b r1) {
            this.f7799a = r1;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer r1, int r2, int r3) {
            com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.b r0 = this.f7799a.c();
            if (r0 == null) goto L7;
            r0.a(r2, r3, "");
            return false;
        L7:
            return false;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "mp", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "what", "", WsConstants.KEY_EXTRA, "onInfo"}, k = 3, mv = {1, 4, 3})
    static final class d implements MediaPlayer.OnInfoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f7800a;

        d(b r1) {
            this.f7800a = r1;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer r1, int r2, int r3) {
            if (r2 != 3) goto L9;
            com.obric.common.oea.style.scene.alpha.alphaplayer.player.c.InterfaceC0380c r0 = this.f7800a.d();
            if (r0 == null) goto L10;
            r0.a();
            return false;
        L10:
            return false;
        L9:
            return false;
        }
    }

    public b() {
        super(null, 1, null);
        this.c = new MediaMetadataRetriever();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void a(Surface r2) {
        Intrinsics.checkNotNullParameter(r2, "surface");
        MediaPlayer r1 = this.f7795a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r1.setSurface(r2);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "dataPath");
        this.f7796b = r2;
        MediaPlayer r1 = this.f7795a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r1.setDataSource(r2);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void a(boolean r2) {
        MediaPlayer r1 = this.f7795a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r1.setLooping(r2);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void b(boolean r2) {
        MediaPlayer r1 = this.f7795a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r1.setScreenOnWhilePlaying(r2);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void e() {
        MediaPlayer r0 = new MediaPlayer();
        this.f7795a = r0;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r0.setOnCompletionListener((MediaPlayer.OnCompletionListener) ZeusTransformUtils.preCheckCast(new a(this), MediaPlayer.OnCompletionListener.class, "com.obric.memorydata.plugin"));
        MediaPlayer r1 = this.f7795a;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L8:
        r1.setOnPreparedListener((MediaPlayer.OnPreparedListener) ZeusTransformUtils.preCheckCast(new C0379b(this), MediaPlayer.OnPreparedListener.class, "com.obric.memorydata.plugin"));
        MediaPlayer r2 = this.f7795a;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L11:
        r2.setOnErrorListener((MediaPlayer.OnErrorListener) ZeusTransformUtils.preCheckCast(new c(this), MediaPlayer.OnErrorListener.class, "com.obric.memorydata.plugin"));
        MediaPlayer r3 = this.f7795a;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L14:
        r3.setOnInfoListener((MediaPlayer.OnInfoListener) ZeusTransformUtils.preCheckCast(new d(this), MediaPlayer.OnInfoListener.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void f() {
        MediaPlayer r1 = this.f7795a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r1.prepareAsync();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void g() {
        MediaPlayer r1 = this.f7795a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r1.start();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void h() {
        MediaPlayer r1 = this.f7795a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r1.pause();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void i() {
        MediaPlayer r1 = this.f7795a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r1.stop();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void j() {
        MediaPlayer r0 = this.f7795a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r0.reset();
        this.f7796b = "";
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void k() {
        MediaPlayer r0 = this.f7795a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r0.release();
        this.f7796b = "";
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public com.obric.common.oea.style.scene.alpha.alphaplayer.model.c l() {
        String r0 = this.f7796b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dataPath");
    L6:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L19;
        MediaMetadataRetriever r1 = this.c;
        String r2 = this.f7796b;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("dataPath");
    L10:
        r1.setDataSource(r2);
        String r3 = this.c.extractMetadata(18);
        String r4 = this.c.extractMetadata(19);
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L17;
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L17;
        String r5 = this.c.extractMetadata(18);
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNullExpressionValue(r5, "retriever.extractMetadat…TADATA_KEY_VIDEO_WIDTH)!!");
        int r6 = Integer.parseInt(r5);
        String r7 = this.c.extractMetadata(19);
        Intrinsics.checkNotNull(r7);
        Intrinsics.checkNotNullExpressionValue(r7, "retriever.extractMetadat…ADATA_KEY_VIDEO_HEIGHT)!!");
        return new com.obric.common.oea.style.scene.alpha.alphaplayer.model.c(r6, Integer.parseInt(r7));
    L17:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new Exception("DefaultSystemPlayer get metadata failure!"), Throwable.class, "com.obric.memorydata.plugin"));
    L19:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new Exception("dataPath is null, please set setDataSource firstly!"), Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public String m() {
        return "DefaultSystemPlayer";
    }
}
