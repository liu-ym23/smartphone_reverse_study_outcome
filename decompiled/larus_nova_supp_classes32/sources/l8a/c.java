package l8a;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c extends IterativeBoxBlurPostProcessor {
    public final WeakReference<LynxContext> a;

    public class a implements Runnable {
        public final /* synthetic */ c a;

        @Override // java.lang.Runnable
        public final void run() {
            WeakReference<LynxContext> r0 = this.a.a;     // Catch: Throwable -> L8
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.get() == null) goto L15;
            LynxError r1 = new LynxError(220301, "blur-radius/drop-shadow is not supported in this app and it will crash in lower versions", "Please remove blur-radius/drop-shadow props in image/filter-image.", "error", -3);     // Catch: Throwable -> L8
            this.a.a.get().handleLynxError(r1);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public a(c r1) {
            this.a = r1;
        }
    }

    public final void process(Bitmap r1) {
        super.process(r1);     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        UIThreadUtils.runOnUiThread(new a(this));
    }

    public c(int r1, LynxContext r2) {
        super(r1);
        this.a = new WeakReference(r2);
    }
}
