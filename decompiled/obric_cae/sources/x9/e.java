package x9;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;

/* JADX INFO: loaded from: classes.dex */
public final class e extends android.support.v4.media.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f13760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TextPaint f13761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ android.support.v4.media.a f13762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d f13763f;

    public e(d r8, Context r10, TextPaint r11, android.support.v4.media.a r12) {
        this.f13763f = r8;
        this.f13760c = r10;
        this.f13761d = r11;
        this.f13762e = r12;
    }

    @Override // android.support.v4.media.a
    public final void q(int r8) {
        this.f13762e.q(r8);
    }

    @Override // android.support.v4.media.a
    public final void r(Typeface r8, boolean r10) {
        TextPaint r11 = this.f13761d;
        this.f13763f.g(this.f13760c, r11, r8);
        this.f13762e.r(r8, r10);
    }
}
