package r4;

import ai.j0;
import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f21672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f21673c;
    public float d;
    public int e;
    public int f;

    @Override // r4.a
    public final String d() {
        return "id";
    }

    @Override // r4.a
    public final void e(HashMap r10, q4.c r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "dataManager");
        this.f21673c = a.b("x", r10);
        this.d = a.b("y", r10);
        this.e = a.c("w", r10);
        this.f = a.c("h", r10);
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter("id", STGroup.DICT_KEY);
        ArrayList r12 = new ArrayList();
        Object r13 = r10.get("id");
        if (r13 == null) goto L17;
        List r14 = (List) r13;
        int r5 = r14.size();
        int r15 = 0;
        int r16 = 0;
    L5:
        if (r16 >= r5) goto L11;
        Object r17 = r14.get(r16);
        if (r17 == null) goto L10;
        r16 = j0.d((int) ((Double) r17).doubleValue(), r12, r16, 1);
        goto L5
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
    L11:
        int[] r18 = CollectionsKt.toIntArray(r12);
        int r19 = r18.length / 4;
        int[] r20 = new int[r19];
    L12:
        if (r15 >= r19) goto L14;
        int r21 = r15 * 4;
        r20[r15] = Color.argb(r18[r21 + 3], r18[r21], r18[r21 + 1], r18[r21 + 2]);
        r15 = r15 + 1;
        goto L12
    L14:
        this.f21672b = Bitmap.createBitmap(r20, this.e, this.f, Bitmap.Config.ARGB_8888);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
    }

    @Override // r4.a
    public final void f(q4.b r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Bitmap r10 = this.f21672b;
        if (r10 == null) goto L6;
        r5.a().drawBitmap(r10, this.f21673c, this.d, r5.f21477b);
        return;
    }
}
