package com.larus.chat.gallery.impl.providers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.chat.gallery.impl.preview.l;
import com.larus.gallery.api.t;
import com.larus.platform.service.o;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i<T> extends t<T> {
    public static final /* synthetic */ int n = 0;
    public final Function1<T, f> f;
    public View g;
    public TextView h;
    public f i;
    public com.larus.chat.gallery.api.h j;
    public Job k;
    public String l;
    public String m;

    public static final class a {
    }

    static {
    }

    public final boolean m() {
        return false;
    }

    public final boolean n() {
        return false;
    }

    public final void A() {
        View r0 = this.g;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        this.m = null;
    }

    public final void v() {
        Job r0 = this.k;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.k = null;
        this.l = null;
        View r1 = this.g;
        if (r1 == null) goto L8;
        r1.setOnClickListener(null);
    L8:
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.m = null;
    }

    public i(l r2) {
        Intrinsics.checkNotNullParameter(r2, "selector");
        this.f = r2;
    }

    public final View p(ViewGroup r4) {
        View r5 = LayoutInflater.from(getContext()).inflate(2131562446, r4, false);
        r5.setVisibility(8);
        r5.setOnClickListener(new g(this));
        this.g = r5;
        this.h = (TextView) r5.findViewById(2131372553);
        return r5;
    }

    public final void y(com.larus.chat.gallery.api.h r5) {
        this.j = r5;
        String r0 = r5.b;
        String r1 = null;
        if (r0 != null) goto L5;
    L7:
        r0 = null;
    L8:
        String r2 = r5.c;
        if (r2 != null) goto L11;
    L13:
        r2 = null;
    L15:
        if (r5.a == false) goto L37;
        if (r0 == null) goto L37;
        if (r2 == null) goto L37;
        TextView r6 = this.h;
        if (r6 == null) goto L22;
        r6.setText(r0);
    L22:
        View r7 = this.g;
        if (r7 == null) goto L25;
        r7.setVisibility(0);
    L25:
        f r8 = this.i;
        if (r8 == null) goto L28;
        String r3 = r8.a;
    L30:
        if (Intrinsics.areEqual(r3, this.m) == true) goto L39;
        if (r8 == null) goto L33;
        o.a.reportEvent("ecom_icon_show", z(r8, r0));
    L33:
        if (r8 == null) goto L35;
        r1 = r8.a;
    L35:
        this.m = r1;
        return;
    L39:
        return;
    L28:
        r3 = null;
    L37:
        A();
        return;
    L11:
        if ((!StringsKt.isBlank(r2)) == false) goto L13;
    L5:
        if ((!StringsKt.isBlank(r0)) == false) goto L7;
        goto L7
    }

    public static JSONObject z(f r3, String r4) {
        JSONObject r0 = new JSONObject();
        String r1 = r3.b;
        if (r1 == null) goto L5;
        r0.put(MusicAppletPage.KEY_MESSAGE_ID, r1);
    L5:
        String r2 = r3.c;
        if (r2 == null) goto L8;
        r0.put("enter_method", r2);
    L8:
        r0.put("icon_type", "find_same_product");
        r0.put("icon_text", r4);
        String r5 = r3.d;
        if (r5 == null) goto L11;
        r0.put("bot_id", r5);
    L11:
        return r0;
    }

    public final void w(T r8, int r9) {
        ((t) this).d = r8;
        f r10 = (f) this.f.invoke(r8);
        this.i = r10;
        if (r10 == null) goto L5;
        String r11 = r10.a;
    L6:
        boolean r1 = false;
        if (Intrinsics.areEqual(this.l, r11) == false) goto L16;
        Job r0 = this.k;
        if (r0 != null) goto L11;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L16;
        return;
    L11:
        if (r0.isActive() != true) goto L13;
        r2 = true;
    L16:
        Job r3 = this.k;
        if (r3 == null) goto L19;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L19:
        this.k = null;
        this.l = null;
        this.j = null;
        if (r11 != null) goto L22;
    L23:
        r1 = true;
    L24:
        if (r1 == false) goto L26;
        A();
        return;
    L26:
        ConcurrentHashMap<String, com.larus.chat.gallery.api.h> r4 = e.a;
        Intrinsics.checkNotNullParameter(r11, "imageUri");
        com.larus.chat.gallery.api.h r5 = e.a.get(r11);
        if (r5 == null) goto L29;
        y(r5);
        return;
    L29:
        A();
        this.l = r11;
        this.k = BuildersKt.launch$default(r(), null, null, new FindSimilarProvider$applyVisibility$2(this, r11, null), 3, null);
        return;
    L22:
        if (r11.length() != 0) goto L24;
    L5:
        r11 = null;
        goto L6
    }
}
