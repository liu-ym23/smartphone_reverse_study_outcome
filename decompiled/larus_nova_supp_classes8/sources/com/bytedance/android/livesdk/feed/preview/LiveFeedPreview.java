package com.bytedance.android.livesdk.feed.preview;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.feed.openui.view.HSLargeLiveCardView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/feed/preview/LiveFeedPreview;", "Landroid/widget/FrameLayout;", "Lmw1/a;", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "f", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "getClient", "()Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "client", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "saasfeed_release"}, k = 1, mv = {1, 4, 3})
public final class LiveFeedPreview extends FrameLayout implements mw1.a {
    public static final /* synthetic */ int h = 0;
    public Room a;
    public boolean b;
    public mw1.f c;
    public qw1.e d;
    public boolean e;
    public final ILivePlayerClient f;
    public HashMap g;

    public LiveFeedPreview(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LiveFeedPreview(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final View b() {
        if (this.g != null) goto L5;
        this.g = new HashMap();
    L5:
        View r0 = (View) this.g.get(2131384276);
        if (r0 != null) goto L9;
        View r1 = findViewById(2131384276);
        this.g.put(2131384276, r1);
        return r1;
    L9:
        return r0;
    }

    @Override // mw1.a
    public final void startPreview() {
        this.b = true;
        this.f.bindRenderView(b());
        Room r1 = this.a;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("roomData");
    L6:
        if (r1.isMultiPullDataValid() == false) goto L21;
        LiveRequest.Builder r2 = new LiveRequest.Builder();
        Room r3 = this.a;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("roomData");
    L10:
        String r4 = r3.getMultiStreamData();
        String r5 = "";
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        LiveRequest.Builder r6 = r2.streamData(r4);
        Room r7 = this.a;
        if (r7 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("roomData");
    L16:
        String r8 = r7.getMultiStreamDefaultQualitySdkKey();
        if (r8 == null) goto L20;
        r5 = r8;
    L20:
        LiveRequest r0 = r6.resolution(r5).preview(true).mute(true).build();
        this.f.stream(r0, new AnonymousClass1(this));
    L28:
        Room r9 = this.a;
        if (r9 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("roomData");
    L32:
        if (this.b == true) goto L35;
        return;
    L35:
        if (this.d != null) goto L37;
        this.d = new qw1.e(r9.id, r9.getStreamId(), new f(this));
    L37:
        qw1.e r10 = this.d;
        if (r10 == null) goto L41;
        r10.a();
        return;
    L41:
        return;
    L21:
        LiveRequest r11 = new LiveRequest.Builder().preview(true).mute(true).build();
        Room r12 = this.a;
        if (r12 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("roomData");
    L24:
        r11.setLegacyPullUrl(r12.buildPullUrl());
        Room r13 = this.a;
        if (r13 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("roomData");
    L27:
        r11.setLegacySdkParams(r13.getSdkParams());
        this.f.stream(r11, new AnonymousClass2(this));
        goto L28
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.e = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e = false;
    }

    public final ILivePlayerClient getClient() {
        return this.f;
    }

    public final void e(Integer r5) {
        if (this.e == true) goto L5;
        return;
    L5:
        stopPreview(false);
        Room r0 = this.a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("roomData");
    L8:
        r0.setStatus(4);
        if (r5 == null) goto L15;
        int r6 = r5.intValue();
        Room r1 = this.a;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("roomData");
    L13:
        r1.setMosaicStatus(r6);
        return;
    }

    @Override // mw1.a
    public final void stopPreview(boolean r3) {
        this.b = false;
        qw1.e r1 = this.d;
        if (r1 == null) goto L5;
        r1.b();
    L5:
        this.d = null;
        mw1.f r2 = this.c;
        if (r2 == null) goto L8;
        r2.b(false);
    L8:
        if (r3 == false) goto L10;
        this.f.stopAndRelease(getContext());
        return;
    L10:
        this.f.stop();
    }

    public static final void c(LiveFeedPreview r4, LifecycleOwner r5) {
        ILivePlayerClient r0 = r4.f;
        IRoomEventHub r1 = r0.getEventHub();
        r1.getVideoSizeChanged().observe(r5, new b(r4, r5));
        r1.getFirstFrame().observe(r5, new c(r0, r4, r5));
        r1.getSeiUpdate().observe(r5, new d(r4, r5));
    }

    public LiveFeedPreview(Context r18, AttributeSet r19, int r20) {
        Intrinsics.checkNotNullParameter(r18, "context");
        super(r18, r19, r20);
        String.valueOf(0);
        this.f = is0.c.c().createClient(new LivePlayerConfig(LivePlayerScene.INSTANCE.getPREVIEW(), null, null, false, null, false, false, null, false, 0, false, 2046, null));
        View.inflate(getContext(), 2131567664, this);
    }

    public static final void d(LiveFeedPreview r5, int r6, int r7) {
        mw1.f r0 = r5.c;
        if (r0 == null) goto L5;
        r0.a(r6, r7);
    L5:
        if (r6 >= r7) goto L12;
        ViewGroup.LayoutParams r1 = r5.b().getLayoutParams();
        if (r1 == null) goto L10;
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        r2.leftMargin = 0;
        r2.rightMargin = 0;
        goto L12
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L12:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getId() != ThreadMethodProxy.currentThread().getId()) goto L14;
        r5.b().setVideoSize(r6, r7);
        return;
    L14:
        r5.b().post(new e(r5, r6, r7));
    }

    @Override // mw1.a
    public final void a(String r2, Room r3, HSLargeLiveCardView.e r4) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "roomData");
        this.a = r3;
        this.c = r4;
    }

    public /* synthetic */ LiveFeedPreview(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
