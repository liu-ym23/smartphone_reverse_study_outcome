package com.obric.common.oea.style.scene.alpha.alphaplayer.player;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/AbsPlayer;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "completionListener", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnCompletionListener;", "getCompletionListener", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnCompletionListener;", "setCompletionListener", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnCompletionListener;)V", "errorListener", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnErrorListener;", "getErrorListener", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnErrorListener;", "setErrorListener", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnErrorListener;)V", "firstFrameListener", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnFirstFrameListener;", "getFirstFrameListener", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnFirstFrameListener;", "setFirstFrameListener", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnFirstFrameListener;)V", "preparedListener", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnPreparedListener;", "getPreparedListener", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnPreparedListener;", "setPreparedListener", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnPreparedListener;)V", "setOnCompletionListener", "", "setOnErrorListener", "setOnFirstFrameListener", "setOnPreparedListener", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c.a f7793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c.d f7794b;
    private c.b c;
    private c.InterfaceC0380c d;

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ a(Context r2, int r3, DefaultConstructorMarker r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = (Context) ZeusTransformUtils.preCheckCast(null, Context.class, "com.obric.memorydata.plugin");
    L5:
        this(r5);
    }

    public final c.a a() {
        return this.f7793a;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void a(c.a r3) {
        c.a r4 = (c.a) ZeusTransformUtils.wrapperContextForParams(r3, c.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "completionListener");
        this.f7793a = r4;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void a(c.b r3) {
        c.b r4 = (c.b) ZeusTransformUtils.wrapperContextForParams(r3, c.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "errorListener");
        this.c = r4;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void a(c.InterfaceC0380c r3) {
        c.InterfaceC0380c r4 = (c.InterfaceC0380c) ZeusTransformUtils.wrapperContextForParams(r3, c.InterfaceC0380c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "firstFrameListener");
        this.d = r4;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.c
    public void a(c.d r3) {
        c.d r4 = (c.d) ZeusTransformUtils.wrapperContextForParams(r3, c.d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "preparedListener");
        this.f7794b = r4;
    }

    public final c.d b() {
        return this.f7794b;
    }

    public final c.b c() {
        return this.c;
    }

    public final c.InterfaceC0380c d() {
        return this.d;
    }
}
