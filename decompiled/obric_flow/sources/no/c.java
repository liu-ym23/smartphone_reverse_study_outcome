package no;

import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.lynx.tasm.behavior.LynxContext;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends IterativeBoxBlurPostProcessor {
    public c(int r5, LynxContext r10) {
        super(r5);
        new WeakReference(r10);
    }
}
