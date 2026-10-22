package c2;

import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f1112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1113c;
    public final String d;

    public c(String r5) {
        this.f1111a = 0;
        Intrinsics.checkNotNullParameter(r5, "url");
        this.f1113c = r5;
        this.f1112b = new HashMap();
        this.d = "UTF-8";
    }

    public String a() {
        HashMap r5 = this.f1112b;
        boolean r10 = r5.isEmpty();
        String r11 = this.f1113c;
        if (r10 == false) goto L5;
        return r11;
    L5:
        StringBuilder r12 = new StringBuilder();
        Set r13 = r5.keySet();
        String r14 = "";
        if (r13.isEmpty() == true) goto L22;
        Iterator r15 = r13.iterator();
    L10:
        if (r15.hasNext() == false) goto L20;
        String r16 = (String) r15.next();
        String r17 = this.d;
        String r18 = com.lynx.tasm.utils.b.i(r16, r17);
        String r19 = (String) r5.get(r16);
        if (r19 == null) goto L15;
        String r20 = com.lynx.tasm.utils.b.i(r19, r17);
        if (r20 == null) goto L15;
    L17:
        if (r12.length() <= 0) goto L19;
        r12.append("&");
    L19:
        r12.append(r18);
        r12.append("=");
        r12.append(r20);
    L15:
        r20 = "";
        goto L17
    L20:
        r14 = r12.toString();
    L22:
        if (r11.length() != 0) goto L25;
        return r14;
    L25:
        if (StringsKt.q(r11, '?', 0, 6) < 0) goto L29;
        return androidx.constraintlayout.motion.widget.a.m(r11, Typography.amp, r14);
    L29:
        return androidx.constraintlayout.motion.widget.a.m(r11, '?', r14);
    }

    public String toString() {
        switch(this.f1111a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return super.toString();
    L7:
        return a();
    }

    public c(String r5, File r10) {
        this.f1111a = 1;
        this.f1112b = new HashMap();
        if (TextUtils.isEmpty(r5) == true) goto L7;
        this.f1113c = r5;
        this.d = new File(r10, r5).getAbsolutePath();
        return;
    L7:
        throw new RuntimeException("access key is empty");
    }
}
