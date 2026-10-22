package lm;

import android.graphics.Bitmap;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.lynx.base.log.LynxLog;
import com.lynx.component.svg.UISvg;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends BaseBitmapDataSubscriber {
    public final /* synthetic */ AbstractDataSource d;
    public final /* synthetic */ String e;
    public final /* synthetic */ d f;
    public final /* synthetic */ i4.a g;

    public c(i4.a r5, AbstractDataSource r10, String r11, d r12) {
        this.g = r5;
        this.d = r10;
        this.e = r11;
        this.f = r12;
    }

    @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
    public final void a(Bitmap r5) {
        AbstractDataSource r10 = this.d;
        if (r10.f() == false) goto L11;
        if (r5 == null) goto L12;
        LynxLog.b(1, "UISVG Bitmap", "has come");
        Bitmap r11 = Bitmap.createBitmap(r5);
        i4.a r12 = this.g;
        HashMap r13 = (HashMap) r12.d;
        String r14 = this.e;
        r13.put(r14, r11);
        r10.close();
        WeakReference r15 = (WeakReference) r12.f17502b;
        if (r15 == null) goto L13;
        UISvg r16 = (UISvg) r15.get();
        if (r16 == null) goto L14;
        LynxLog.b(2, "lynx_UISvg", "fetch bitmap the image url is :" + r14 + " ui-svg hashCode:" + r16.hashCode());
        r16.o();
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void d(DataSource r5) {
        this.f.mo1706a();
        if (r5 == null) goto L6;
        r5.close();
        return;
    }
}
