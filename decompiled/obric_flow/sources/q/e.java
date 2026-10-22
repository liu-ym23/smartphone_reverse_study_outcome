package q;

import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke$LineCapType;
import com.airbnb.lottie.model.content.ShapeStroke$LineJoinType;
import com.airbnb.lottie.w;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GradientType f21401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p.a f21402c;
    public final p.a d;
    public final p.a e;
    public final p.a f;
    public final p.b g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ShapeStroke$LineCapType f21403h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ShapeStroke$LineJoinType f21404i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f21405j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f21406k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final p.b f21407l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f21408m;

    public e(String r5, GradientType r10, p.a r11, p.a r12, p.a r13, p.a r14, p.b r15, ShapeStroke$LineCapType r16, ShapeStroke$LineJoinType r17, float r18, ArrayList r19, p.b r110, boolean r111) {
        this.f21400a = r5;
        this.f21401b = r10;
        this.f21402c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f21403h = r16;
        this.f21404i = r17;
        this.f21405j = r18;
        this.f21406k = r19;
        this.f21407l = r110;
        this.f21408m = r111;
    }

    @Override // q.b
    public final k.c a(w r5, r.c r10) {
        return new k.i(r5, r10, this);
    }
}
