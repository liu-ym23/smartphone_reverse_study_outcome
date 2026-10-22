package com.bytedance.android.livesdk.feedback.view.preview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feedback.RoomCardStruct;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.player.api.ILivePlayerControl;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdkapi.ResolutionManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.player.LivePlayerStreamTypeUtils;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n extends FrameLayout implements c {
    public final ViewGroup a;
    public final ViewGroup b;
    public final HSImageView c;
    public final FeedbackLikeView d;
    public final LivePlayerView e;
    public ILivePlayerClient f;
    public final RoomCardStruct g;
    public final h h;

    public static final class a {
    }

    static {
    }

    public View getView() {
        return this;
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.c
    public final void startPreview() {
        Room r0 = this.g.room;
        if (r0 == null) goto L24;
        ILivePlayerClient r1 = this.f;
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L14;
        r0 = null;
    L14:
        if (r0 == null) goto L25;
        this.f = this.e.getClient();     // Catch: Exception -> L19
        this.e.updateIdentifier(r0.getIdStr());     // Catch: Exception -> L19
        LiveRequest r3 = new LiveRequest.Builder().streamData(r0.getMultiStreamData()).resolution(ResolutionManager.INSTANCE.getMultiStreamDefaultQualitySdkKey(r0, true, true)).streamType(LivePlayerStreamTypeUtils.INSTANCE.mapLiveModeToStreamType(r0.getStreamType())).preview(true).mute(true).build();     // Catch: Exception -> L19
        ILivePlayerClient r4 = this.f;     // Catch: Exception -> L19
        if (r4 == null) goto L26;
        r4.stream(r3, new SmallPreviewItemView$innerPlay$1(this));     // Catch: Exception -> L19
        return;
    L26:
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L25:
        return;
    L7:
        if (r1.isPlaying() != true) goto L10;
        r2 = false;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.c
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
        HSImageView r1 = this.c;
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r1, "alpha", new float[]{0.0f, 1.0f});
        r2.setDuration(200);
        r2.addListener(new o(r1));
        r2.start();
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

    public final h getListener() {
        return this.h;
    }

    public final RoomCardStruct getRoomCardStruct() {
        return this.g;
    }

    public n(Context r11, RoomCardStruct r12, h r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "roomCardStruct");
        ViewGroup.LayoutParams r0 = null;
        super(r11, null, 0);
        this.g = r12;
        this.h = r13;
        FrameLayout.inflate(r11, 2131567670, this);
        ViewGroup r14 = (ViewGroup) findViewById(2131384840);
        this.a = r14;
        ViewGroup r15 = (ViewGroup) findViewById(2131367862);
        this.b = r15;
        TextView r1 = (TextView) findViewById(2131388772);
        TextView r2 = (TextView) findViewById(2131387553);
        HSImageView r3 = findViewById(2131382914);
        this.c = r3;
        HSImageView r4 = findViewById(2131372269);
        LivePlayerView r5 = findViewById(2131372220);
        this.e = r5;
        FeedbackLikeView r6 = (FeedbackLikeView) findViewById(2131377881);
        this.d = r6;
        r5.setScaleType(2);
        Room r7 = r12.room;
        if (r7 == null) goto L5;
        py.k r8 = r7.getCover();
    L6:
        ImageLoader.bindImage(r3, r8);
        Room r9 = r12.room;
        if (r9 == null) goto L9;
        py.k r10 = r9.getCover();
    L10:
        ImageLoader.bindImage(r4, r10, new l3(5, 1.0f, null));
        String r16 = r12.title;
        String r17 = "";
        if (r16 != null) goto L14;
        r16 = "";
    L14:
        r1.setText(r16);
        String r18 = r12.subTitle;
        if (r18 == null) goto L17;
        r17 = r18;
    L17:
        r2.setText(r17);
        r15.setOnClickListener(new l(this));
        boolean r19 = r12.isLike();
        r6.c = r19;
        View r110 = r6.a;
        if (r19 == false) goto L20;
        Drawable r111 = s1.m(2131250999);
    L21:
        r110.setBackground(r111);
        r6.setLikeClickListener(new m(this));
        Pair<Float, Float> r112 = com.bytedance.android.livesdk.feedback.c.a(0.7609756f, UtilityKotlinExtentionsKt.h(236), UtilityKotlinExtentionsKt.h(48));
        if (r14 == null) goto L24;
        r0 = r14.getLayoutParams();
    L24:
        if (r0 == null) goto L29;
        r0.width = ((int) ((Number) r112.getFirst()).floatValue()) / 2;
        r0.height = ((int) ((Number) r112.getSecond()).floatValue()) / 2;
        if (r14 == null) goto L30;
        r14.setLayoutParams(r0);
        return;
    L30:
        return;
    L29:
        return;
    L20:
        r111 = s1.m(2131251001);
        goto L21
    L9:
        r10 = null;
        goto L10
    L5:
        r8 = null;
        goto L6
    }
}
