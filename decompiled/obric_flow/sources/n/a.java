package n;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import java.util.HashMap;
import u.b;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final Object d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f20185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f20187c;

    static {
        d = new Object();
    }

    public a(Drawable.Callback r5, String r10, HashMap r11) {
        this.f20186b = r10;
        if (TextUtils.isEmpty(r10) == true) goto L8;
        if (r10.charAt(r10.length() - 1) == '/') goto L8;
        this.f20186b = r10.concat("/");
    L8:
        if ((r5 instanceof View) == true) goto L11;
        b.b("LottieDrawable must be inside of a view for images to work.");
        this.f20187c = new HashMap();
        this.f20185a = null;
        return;
    L11:
        this.f20185a = ((View) r5).getContext();
        this.f20187c = r11;
    }
}
