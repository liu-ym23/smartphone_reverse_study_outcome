package th;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.sdk.plugin.d;
import com.bytedance.android.ec.sdk.plugin.e;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final Resources f(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$pluginResources");
        return e(r1, true).getResources();
    }

    public static final int a(Context r1, int r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$color");
        return ContextCompat.getColor(e(r1, true), r10);
    }

    public static final Drawable b(Context r1, int r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$drawable");
        return ContextCompat.getDrawable(e(r1, true), r10);
    }

    public static final Context e(Context r1, boolean r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$pluginContext");
        if (e.a() == false) goto L18;
        if (r10 == false) goto L14;
        boolean r11 = ECServiceManager.a;
        Intrinsics.checkNotNullParameter(af.a.class, "clazz");
        Object r12 = ECServiceManager.b.get(af.a.class);
        if ((r12 instanceof Object) == true) goto L8;
        r12 = null;
    L8:
        af.a r13 = (af.a) r12;
        if (r13 != null) goto L11;
        boolean r14 = true;
    L12:
        if (r14 == false) goto L14;
        return r1;
    L11:
        r14 = r13.a(r1);
    L14:
        if ((r1 instanceof d) == false) goto L17;
        return r1;
    L17:
        return new d(r1);
    L18:
        return r1;
    }

    public static final String g(Context r1, int r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$string");
        if (r10 != 0) goto L6;
        return "";
    L6:
        return e(r1, true).getString(r10);
    }

    public static final String h(Context r1, int r10, Object... r11) {
        Intrinsics.checkNotNullParameter(r1, "$this$string");
        Intrinsics.checkNotNullParameter(r11, "formatArgs");
        return e(r1, true).getString(r10, Arrays.copyOf(r11, r11.length));
    }

    public static final View c(Context r1, int r10, ViewGroup r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r1, "$this$inflate");
        Context r13 = e(r1, true);
        return LayoutInflater.from(r13).inflate(r10, r11, r12);
    L5:
        e = move-exception;
        throw new Exception("Django ==> shopping plugin inflate fail: " + r13 + "， " + e, e);
    }

    public static /* synthetic */ View d(Context r0, int r1, ViewGroup r10, int r11) {
        if ((r11 & 2) == 0) goto L6;
        r10 = null;
    L6:
        return c(r0, r1, r10, false);
    }
}
