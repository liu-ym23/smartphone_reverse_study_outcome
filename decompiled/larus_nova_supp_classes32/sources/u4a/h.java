package u4a;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapReferenceDataSubscriber;
import com.lynx.animax.util.AnimaXLog;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h extends BaseBitmapReferenceDataSubscriber {
    public final /* synthetic */ i.a a;
    public final /* synthetic */ DataSource b;

    public final void onFailureImpl(DataSource r4) {
        if (r4.getFailureCause() == null) goto L5;
        String r0 = "Fresco failed to load bitmap.reason: " + r4.getFailureCause().getMessage();
    L6:
        ((g) this.a).a(null, r0);
        r4.close();
        return;
    L5:
        r0 = "Fresco failed to load bitmap.";
        goto L6
    }

    public final void onNewResultImpl(CloseableReference<Bitmap> r7) {
        if (r7 == null) goto L5;
        Bitmap r1 = (Bitmap) r7.get();
    L6:
        if (r1 == null) goto L24;
        boolean r4 = true;
        if (((r1.getWidth() * r1.getHeight()) * 4) != r1.getByteCount()) goto L10;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        ((g) this.a).a(new f(r7), NameKeys.UnloadStrategy_No_Strategy);
    L25:
        this.b.close();
        return;
    L14:
        AnimaXLog.b("FrescoUtil", "Fresco returned a bitmap with an invalid format. Attempting to convert it to ARGB_8888.");
        Bitmap r8 = r1.copy(Bitmap.Config.ARGB_8888, false);
        if (r8 != null) goto L18;
    L20:
        r4 = false;
    L21:
        if (r4 == false) goto L23;
        ((g) this.a).a(new q(r8), NameKeys.UnloadStrategy_No_Strategy);
        goto L25
    L23:
        ((g) this.a).a(null, "Fresco returned unknown bitmap format which cannot be converted to RGBA8888.");
        goto L25
    L18:
        if (((r8.getWidth() * r8.getHeight()) * 4) != r8.getByteCount()) goto L20;
    L10:
        r2 = false;
        goto L12
    L24:
        ((g) this.a).a(null, "Fresco returned a null bitmap on success.");
        goto L25
    L5:
        r1 = null;
        goto L6
    }

    public h(g r1, DataSource r2) {
        this.a = r1;
        this.b = r2;
    }
}
