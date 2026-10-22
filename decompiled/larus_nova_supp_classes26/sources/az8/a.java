package az8;

import com.larus.bmhome.utils.c4;
import com.larus.gallery.api.GalleryType;
import com.larus.gallery.api.t;
import com.larus.platform.service.o;
import java.util.HashSet;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nr9.g;
import org.json.JSONObject;
import tx9.a4;
import uo8.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends ab9.b<ty8.b> {
    public final HashSet<Integer> n;

    /* JADX INFO: renamed from: az8.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0002a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GalleryType.values().length];
            r0[GalleryType.Image.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[GalleryType.Video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final JSONObject y() {
        ty8.b r0 = (ty8.b) ((t) this).d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f;
    }

    public final c4 z() {
        ty8.b r0 = (ty8.b) ((t) this).d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g;
    }

    public a() {
        this.n = new HashSet();
    }

    public final void A(int r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "enterMethod");
        Intrinsics.checkNotNullParameter(r15, "slideStatus");
        ty8.b r16 = (ty8.b) ((t) this).d;
        JSONObject r0 = null;
        String r1 = null;
        r1 = null;
        if (r16 == null) goto L5;
        GalleryType r17 = r16.e;
    L6:
        if (r17 != null) goto L8;
        int r18 = -1;
    L10:
        if (r18 == 1) goto L56;
        if (r18 != 2) goto L70;
        ty8.b r19 = (ty8.b) ((t) this).d;
        if (r19 == null) goto L19;
        g r110 = r19.c;
        if (r110 == null) goto L19;
        String r2 = r110.a;
    L20:
        if (r19 == null) goto L24;
        c4 r111 = r19.g;
        if (r111 == null) goto L24;
        String r3 = r111.b;
    L25:
        if (r19 == null) goto L29;
        c4 r112 = r19.g;
        if (r112 == null) goto L29;
        String r4 = r112.a;
    L30:
        if (r19 == null) goto L34;
        c4 r113 = r19.g;
        if (r113 == null) goto L34;
        String r5 = r113.c;
    L35:
        if (r19 == null) goto L39;
        c4 r114 = r19.g;
        if (r114 == null) goto L39;
        String r6 = r114.g;
    L40:
        if (r19 == null) goto L44;
        c4 r115 = r19.g;
        if (r115 == null) goto L44;
        String r7 = r115.j;
    L45:
        if (r19 == null) goto L49;
        c4 r116 = r19.g;
        if (r116 == null) goto L49;
        Integer r8 = r116.i;
    L50:
        if (r19 == null) goto L54;
        c4 r117 = r19.g;
        if (r117 == null) goto L54;
        r1 = r117.h;
    L54:
        a4.h(r2, r3, r4, r14, r5, r6, r7, r8, r1, "user", 3072);
        return;
    L49:
        r8 = null;
    L44:
        r7 = null;
    L39:
        r6 = null;
    L34:
        r5 = null;
    L29:
        r4 = null;
    L24:
        r3 = null;
    L19:
        r2 = null;
        goto L20
    L70:
        return;
    L56:
        if (this.n.contains(Integer.valueOf(r13)) == true) goto L64;
        o r118 = o.a;
        ty8.b r9 = (ty8.b) ((t) this).d;
        if (r9 == null) goto L62;
        JSONObject r10 = r9.f;
        if (r10 == null) goto L62;
        r10.put("enter_method", r14);
        Unit r119 = Unit.INSTANCE;
    L63:
        r118.reportEvent("enter_picture_detail", r10);
        this.n.add(Integer.valueOf(r13));
    L62:
        r10 = null;
    L64:
        l.a r120 = l.a;
        ty8.b r121 = (ty8.b) ((t) this).d;
        if (r121 == null) goto L67;
        r0 = r121.f;
    L67:
        l.b(r13, r0);
        return;
    L8:
        r18 = C0002a.a[r17.ordinal()];
        goto L10
    L5:
        r17 = null;
        goto L6
    }
}
