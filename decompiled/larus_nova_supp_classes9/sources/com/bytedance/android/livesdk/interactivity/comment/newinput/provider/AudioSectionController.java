package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioComposePageViewPager;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioRecordBtnView;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioRecordViewV3;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioWaveViewV3;
import com.bytedance.common.utility.UIUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AudioSectionController extends com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j implements com.bytedance.android.livesdk.interactivity.comment.audio.c.b {
    public static final /* synthetic */ int o = 0;
    public AudioRecordBtnView c;
    public TextView d;
    public AudioRecordViewV3 e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public com.bytedance.android.livesdk.interactivity.comment.audio.c j;
    public final Lazy k;
    public final Lazy l;
    public final b m;
    public final AudioComposePageViewPager n;

    public static final class a {
    }

    public static final class b implements AudioRecordViewV3.c {
        public final /* synthetic */ AudioSectionController a;
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g b;

        @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioRecordViewV3.c
        public final void a() {
            q60.a r0 = q60.a.d;
            Map r3 = MapsKt.mapOf(new Pair("type", "count_finish"));
            com.bytedance.android.live.core.privacy.av.api.b.a.getClass();
            com.bytedance.android.live.core.privacy.av.api.b.a.a r4 = com.bytedance.android.live.core.privacy.av.api.b.a.a;
            com.bytedance.android.live.core.privacy.av.api.a r5 = new com.bytedance.android.live.core.privacy.av.api.a();
            r5.d();
            Unit r6 = Unit.INSTANCE;
            r0.c("community", "audio_comment", r3, r4, r5);
            AudioSectionController r1 = this.a;
            r1.i = true;
            r1.g = false;
            if (r1.f == false) goto L8;
            com.bytedance.android.livesdk.interactivity.comment.audio.c r2 = r1.j;
            if (r2 == null) goto L7;
            r2.stopRecordAudio(false, true);
        L7:
            UIUtils.setViewVisibility(this.a.e, 8);
        L12:
            AudioRecordBtnView r7 = this.a.c;
            if (r7 == null) goto L15;
            r7.a();
        L15:
            AudioRecordViewV3 r8 = this.a.e;
            if (r8 == null) goto L18;
            r8.b();
        L18:
            AudioComposePageViewPager r9 = this.a.n;
            if (r9 == null) goto L21;
            r9.setCanScroll(true);
        L21:
            TextView r10 = this.a.d;
            if (r10 == null) goto L24;
            UtilityKotlinExtentionsKt.w(r10);
        L24:
            this.b.M(false);
            this.b.N(false);
            this.b.L();
            UIUtils.setViewVisibility(this.a.e, 8);
            com.bytedance.android.live.core.utils.f2.b(2131915112, 0);
            return;
        L8:
            com.bytedance.android.livesdk.interactivity.comment.audio.c r11 = r1.j;
            if (r11 == null) goto L11;
            r11.stopRecordAudio(true, false);
        L11:
            UIUtils.setViewVisibility(this.a.e, 8);
            goto L12
        }

        public b(AudioSectionController r1, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.audio.c.b
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
    }

    public final Runnable g() {
        return (Runnable) this.l.getValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.audio.c.b
    public final void c(byte[] r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        short[] r1 = new short[r4.length / 2];
        ByteBuffer.wrap(r4).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(r1);
        AudioRecordViewV3 r5 = this.e;
        if (r5 == null) goto L6;
        Intrinsics.checkNotNullParameter(r1, "data");
        AudioWaveViewV3 r6 = r5.c;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r1, "data");
        r6.c = r1;
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.audio.c.b
    public final void f(String r2, long r3) {
        this.b.s0(r2, r3);
    }

    public AudioSectionController(View r2, final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r3, AudioComposePageViewPager r4) {
        Intrinsics.checkNotNullParameter(r2, "audioPanelView");
        Intrinsics.checkNotNullParameter(r3, "bridges");
        super(r2, r3);
        this.n = r4;
        this.k = LazyKt.lazy(new AudioSectionController$recordStartRunnable$2(this, r3));
        this.l = LazyKt.lazy(new AudioSectionController$recordCountDownRunnable$2(this));
        this.m = new b(this, r3);
    }
}
