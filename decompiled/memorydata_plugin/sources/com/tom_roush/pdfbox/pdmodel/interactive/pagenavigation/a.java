package com.tom_roush.pdfbox.pdmodel.interactive.pagenavigation;

import androidx.exifinterface.media.ExifInterface;
import com.tom_roush.pdfbox.a.b;
import com.tom_roush.pdfbox.a.d;
import com.tom_roush.pdfbox.a.i;
import com.tom_roush.pdfbox.pdmodel.common.c;
import com.tom_roush.pdfbox.pdmodel.common.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f16295a;

    public a() {
        d r0 = new d();
        this.f16295a = r0;
        r0.a("Type", "Bead");
        a(this);
        b(this);
    }

    public a(d r1) {
        this.f16295a = r1;
    }

    public d a() {
        return this.f16295a;
    }

    public final void a(a r2) {
        this.f16295a.a("N", r2);
    }

    public h b() {
        com.tom_roush.pdfbox.a.a r2 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(this.f16295a.a(i.gG), com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return new h(r2);
    }

    public final void b(a r2) {
        this.f16295a.a(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, r2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ b e() {
        return a();
    }
}
