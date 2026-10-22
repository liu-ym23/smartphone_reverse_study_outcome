package qz0;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.scope.o;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import vh6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements pz0.a, o {
    public b() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // pz0.a
    public final void showPromptToast(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        ToastUtil.b(r2, 0);
    }

    @Override // pz0.a
    public final void showIconToast(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "text");
        Intrinsics.checkNotNullParameter(r5, "status");
        HashMap r2 = new HashMap();
        r2.put("status", r5);
        r2.put("text", r4);
        c.b(wh6.a.class).centerIconToast(s1.getContext(), r2);
    }

    @Override // pz0.a
    public final void showImageToast(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "text");
        Intrinsics.checkNotNullParameter(r6, "image");
        List r7 = new Regex(",").split(r6, 0);     // Catch: Exception -> L20
        if (r7.isEmpty() == true) goto L14;
        ListIterator r1 = r7.listIterator(r7.size());     // Catch: Exception -> L20
    L7:
        if (r1.hasPrevious() == false) goto L14;
        if (((String) r1.previous()).length() != 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L7;
        List r8 = CollectionsKt.take(r7, r1.nextIndex() + 1);     // Catch: Exception -> L20
    L15:
        Object[] r9 = r8.toArray(new String[0]);     // Catch: Exception -> L20
        if (r9 == null) goto L19;
        byte[] r10 = Base64.decode(((String[]) r9)[1], 0);     // Catch: Exception -> L20
        Bitmap r12 = BitmapFactory.decodeByteArray(r10, 0, r10.length);     // Catch: Exception -> L20
    L22:
        String r0 = rm3.c.a;
        rm3.c.c(s1.getContext(), r5, new BitmapDrawable(r12));
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L20
    L11:
        r3 = false;
    L14:
        r8 = CollectionsKt.emptyList();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        r12 = null;
        goto L22
    }
}
