package rl8;

import com.larus.gallery.api.GalleryType;
import com.larus.gallery.api.t;
import com.larus.platform.service.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d extends ab9.b<ty8.b> {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GalleryType.values().length];
            r0[GalleryType.Image.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public final JSONObject y() {
        ty8.b r0 = (ty8.b) ((t) this).d;
        if (r0 == null) goto L7;
        JSONObject r1 = r0.f;
        if (r1 == null) goto L7;
        return new JSONObject(r1.toString());
    L7:
        return null;
    }

    public d() {
    }

    public final void A(int r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "enterMethod");
        Intrinsics.checkNotNullParameter(r6, "slideStatus");
        ty8.b r7 = (ty8.b) ((t) this).d;
        JSONObject r0 = null;
        if (r7 == null) goto L5;
        GalleryType r8 = r7.e;
    L6:
        if (r8 != null) goto L8;
        int r9 = -1;
    L10:
        if (r9 != 1) goto L22;
        ty8.b r10 = (ty8.b) ((t) this).d;
        if (r10 == null) goto L16;
        JSONObject r11 = r10.f;
        if (r11 == null) goto L16;
        JSONObject r2 = new JSONObject(r11.toString());
    L17:
        o r12 = o.a;
        if (r2 == null) goto L20;
        r2.put("enter_method", r5);
        r2.put("position", r4 + 1);
        Unit r13 = Unit.INSTANCE;
        r0 = r2;
    L20:
        r12.reportEvent("enter_picture_detail", r0);
        return;
    L16:
        r2 = null;
        goto L17
    L22:
        return;
    L8:
        r9 = a.a[r8.ordinal()];
        goto L10
    L5:
        r8 = null;
        goto L6
    }
}
