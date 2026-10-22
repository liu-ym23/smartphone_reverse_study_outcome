package com.bytedance.android.debug;

import android.widget.FrameLayout;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l {
    public FrameLayout a;
    public ITextureViewPlayerController b;
    public final b c;
    public a d;

    public interface a {
        void a();

        void b();

        void onEnd();

        void onStart();

        void onStop();
    }

    public static final class b implements IPlayerActionListener {
        public final /* synthetic */ l a;

        public final /* synthetic */ void onFirstFrame() {
            IPlayerActionListener.-CC.$default$onFirstFrame(this);
        }

        public final /* synthetic */ void onReportPlayMetrics(Map r1) {
            IPlayerActionListener.-CC.$default$onReportPlayMetrics(this, r1);
        }

        public final void onEnd() {
            a r0 = this.a.d;
            if (r0 == null) goto L6;
            r0.onEnd();
            return;
        }

        public final void onStart() {
            a r0 = this.a.d;
            if (r0 == null) goto L6;
            r0.onStart();
            return;
        }

        public final void onStop() {
            a r0 = this.a.d;
            if (r0 == null) goto L6;
            r0.onStop();
            return;
        }

        public b(l r1) {
            this.a = r1;
        }

        public final void onFileLoaded(int r1, int r10) {
            a r11 = this.a.d;
            if (r11 == null) goto L6;
            r11.a();
            return;
        }

        public final void updateTextEffectPosition(float r1, float r10, float r11, float r12) {
            a r13 = this.a.d;
            if (r13 == null) goto L6;
            r13.b();
            return;
        }
    }

    public l() {
        this.c = new b(this);
    }
}
