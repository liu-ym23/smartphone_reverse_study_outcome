package nlb;

import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageDecoder;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends rlb.a<rlb.c> {
    public final /* synthetic */ g c;
    public final /* synthetic */ boolean d;

    @Override // rlb.a, rlb.b
    public final Object make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        this.b = c.a(this.c);
        rlb.c r0 = (rlb.c) super.make();
        if ((r0 instanceof MSkiaImageDecoder) == false) goto L5;
        boolean r2 = this.d;
        ((MSkiaImageDecoder) r0).mIsSecret = r2;
    L5:
        return r0;
    }

    public a(Class r1, g r2, boolean r3) {
        this.c = r2;
        this.d = r3;
        super(r1);
    }
}
