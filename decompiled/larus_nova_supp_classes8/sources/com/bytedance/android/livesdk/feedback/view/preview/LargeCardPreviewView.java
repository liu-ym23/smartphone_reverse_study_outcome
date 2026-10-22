package com.bytedance.android.livesdk.feedback.view.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feedback.RoomCardStruct;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.player.api.ILivePlayerControl;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdkapi.ResolutionManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.player.LivePlayerStreamTypeUtils;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/view/preview/LargeCardPreviewView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/feedback/view/preview/b;", "Landroid/view/View;", "getView", "Lcom/bytedance/android/live/base/model/feedback/RoomCardStruct;", "getRoomInfo", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LargeCardPreviewView extends FrameLayout implements com.bytedance.android.livesdk.feedback.view.preview.b {
    public final TextView a;
    public final TextView b;
    public final HSImageView c;
    public final HSImageView d;
    public final LivePlayerView e;
    public ILivePlayerClient f;
    public RoomCardStruct g;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            this.a.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationStart(r2, r3);
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            this.a.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationStart(r2, r3);
        }
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.b
    public View getView() {
        return this;
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.b
    public final void startPreview() {
        RoomCardStruct r0 = this.g;
        Room r1 = null;
        if (r0 == null) goto L5;
        Room r2 = r0.room;
    L6:
        ILivePlayerClient r3 = this.f;
        if (r3 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
        r1 = r2;
    L15:
        if (r1 == null) goto L25;
        this.f = this.e.getClient();     // Catch: Exception -> L20
        this.e.updateIdentifier(r1.getIdStr());     // Catch: Exception -> L20
        LiveRequest r5 = new LiveRequest.Builder().streamData(r1.getMultiStreamData()).resolution(ResolutionManager.INSTANCE.getMultiStreamDefaultQualitySdkKey(r1, true, true)).streamType(LivePlayerStreamTypeUtils.INSTANCE.mapLiveModeToStreamType(r1.getStreamType())).preview(true).mute(true).build();     // Catch: Exception -> L20
        ILivePlayerClient r6 = this.f;     // Catch: Exception -> L20
        if (r6 == null) goto L26;
        r6.stream(r5, new LargeCardPreviewView$innerPlay$1(this));     // Catch: Exception -> L20
        return;
    L26:
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        return;
    L25:
        return;
    L9:
        if (r3.isPlaying() != true) goto L12;
        r4 = false;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.b
    public final void stopPreview() {
        ILivePlayerControl r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isPlaying() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L12;
        r0.stop();
        this.c.setVisibility(0);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ILivePlayerClient r0 = this.f;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.b
    public RoomCardStruct getRoomInfo() {
        return this.g;
    }

    public /* synthetic */ LargeCardPreviewView(Context r3) {
        this(r3, null, 0);
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.b
    public final void a(Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onFinish");
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.0f});
        r0.setDuration(200);
        r0.addListener(new a(r4));
        r0.start();
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.b
    public final void b(Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r8, "onFinish");
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this, "scaleX", new float[]{0.9f, 1.0f});
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this, "scaleY", new float[]{0.9f, 1.0f});
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.7f, 1.0f});
        AnimatorSet r4 = new AnimatorSet();
        r4.setDuration(300);
        r4.addListener(new b(r8));
        r4.playTogether(new Animator[]{r3, r1, r2});
        r4.start();
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.b
    public final void c(RoomCardStruct r6) {
        Intrinsics.checkNotNullParameter(r6, "room");
        this.g = r6;
        HSImageView r0 = this.c;
        Room r1 = r6.room;
        if (r1 == null) goto L5;
        py.k r2 = r1.getCover();
    L6:
        ImageLoader.bindImage(r0, r2);
        HSImageView r3 = this.d;
        Room r7 = r6.room;
        if (r7 == null) goto L9;
        py.k r8 = r7.getCover();
    L10:
        ImageLoader.bindImage(r3, r8, new l3(5, 1.0f, null));
        TextView r9 = this.b;
        RoomCardStruct r4 = this.g;
        String r5 = "";
        if (r4 == null) goto L15;
        String r10 = r4.title;
        if (r10 == null) goto L15;
    L16:
        r9.setText(r10);
        TextView r11 = this.a;
        RoomCardStruct r12 = this.g;
        if (r12 == null) goto L21;
        String r13 = r12.subTitle;
        if (r13 == null) goto L21;
        r5 = r13;
    L21:
        r11.setText(r5);
        return;
    L15:
        r10 = "";
        goto L16
    L9:
        r8 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public LargeCardPreviewView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        FrameLayout.inflate(r2, 2131567668, this);
        this.b = (TextView) findViewById(2131388772);
        this.a = (TextView) findViewById(2131387553);
        this.c = findViewById(2131382914);
        this.e = findViewById(2131372220);
        this.d = findViewById(2131372269);
    }
}
