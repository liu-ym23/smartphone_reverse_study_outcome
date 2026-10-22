package mx8;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.bmhome.share.panel.ShareType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final String a;
    public final float b;
    public final float c;
    public final Paint d;
    public final Paint e;
    public final float f;
    public final float g;

    public e(Context r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, ShareType.TEXT);
        this.a = r6;
        float r0 = r5.getResources().getDimension(2131167539);
        this.b = r0;
        float r1 = r5.getResources().getDimension(2131167541);
        this.c = r5.getResources().getDimension(2131167540);
        Paint r2 = new Paint();
        r2.setTextSize(r5.getResources().getDimension(2131167542));
        r2.setTypeface(Typeface.DEFAULT_BOLD);
        r2.setColor(-1);
        this.d = r2;
        Paint r7 = new Paint();
        r7.setColor(ColorProtector.parseColor("#88191919"));
        this.e = r7;
        float r8 = r2.measureText(r6);
        this.f = r8;
        this.g = Math.max(r0, r8 + (2 * r1));
    }
}
