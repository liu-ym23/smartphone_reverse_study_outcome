package com.ss.android.lark.player.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class RenderSurfaceView extends SurfaceView {
    public a a;

    public interface a {
    }

    public interface b {
    }

    public static final class c implements b {
        public final WeakReference<SurfaceHolder> a;

        public c(SurfaceHolder r2) {
            this.a = new WeakReference(r2);
        }
    }

    public class d implements SurfaceHolder.Callback {
        public final /* synthetic */ RenderSurfaceView a;

        public d(RenderSurfaceView r1) {
            this.a = r1;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder r3) {
            Log.d("RenderSurfaceView", "<---surfaceCreated---->");
            a r0 = this.a.a;
            if (r0 == null) goto L6;
            c r1 = new c(r3);
            VideoView r4 = ((VideoView.a) r0).a;
            r4.k = r1;
            VideoView.b(r4, r1);
            return;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder r3) {
            Log.d("RenderSurfaceView", "***surfaceDestroyed***");
            a r0 = this.a.a;
            if (r0 == null) goto L6;
            new WeakReference(r3);
            ((VideoView.a) r0).a.k = null;
            return;
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder r2, int r3, int r4, int r5) {
            Log.d("RenderSurfaceView", "surfaceChanged : width = " + r4 + " height = " + r5);
            a r6 = this.a.a;
            if (r6 == null) goto L6;
            new WeakReference(r2);
            r6.getClass();
            return;
        }
    }

    public a getRenderCallback() {
        return this.a;
    }

    public RenderSurfaceView(Context r2) {
        this(r2, null);
    }

    public void setRenderCallback(a r1) {
        this.a = r1;
    }

    public RenderSurfaceView(Context r1, AttributeSet r2) {
        super(r1, r2);
        getHolder().addCallback(new d(this));
    }
}
