package q;

import com.airbnb.lottie.model.content.ShapeStroke$LineCapType;
import com.airbnb.lottie.model.content.ShapeStroke$LineJoinType;
import com.airbnb.lottie.w;
import java.util.ArrayList;
import k.t;

/* JADX INFO: loaded from: classes.dex */
public final class o implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p.b f21438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f21439c;
    public final p.a d;
    public final p.a e;
    public final p.b f;
    public final ShapeStroke$LineCapType g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ShapeStroke$LineJoinType f21440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f21441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f21442j;

    public o(String r5, p.b r10, ArrayList r11, p.a r12, p.a r13, p.b r14, ShapeStroke$LineCapType r15, ShapeStroke$LineJoinType r16, float r17, boolean r18) {
        this.f21437a = r5;
        this.f21438b = r10;
        this.f21439c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f21440h = r16;
        this.f21441i = r17;
        this.f21442j = r18;
    }

    @Override // q.b
    public final k.c a(w r5, r.c r10) {
        return new t(r5, r10, this);
    }
}
