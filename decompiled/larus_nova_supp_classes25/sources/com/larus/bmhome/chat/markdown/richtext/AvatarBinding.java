package com.larus.bmhome.chat.markdown.richtext;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.TextView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class AvatarBinding implements View.OnAttachStateChangeListener {
    public final TextView a;
    public final List<d> b;
    public final List<Job> c;

    public final void a() {
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Job.DefaultImpls.cancel$default((Job) r0.next(), null, 1, null);
        goto L4
    L6:
        ((ArrayList) this.c).clear();
    }

    public final void b() {
        a();
        LifecycleOwner r0 = ViewTreeLifecycleOwner.get(this.a);
        if (r0 == null) goto L28;
        LifecycleCoroutineScope r1 = LifecycleOwnerKt.getLifecycleScope(r0);
        if (r1 == null) goto L41;
        List<d> r2 = this.b;
        LinkedHashMap r3 = new LinkedHashMap();
        Iterator<T> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L14;
        Object r5 = r4.next();
        p r6 = ((d) r5).b;
        Object r7 = r3.get(r6);
        if (r7 != null) goto L13;
        r7 = new ArrayList();
        r3.put(r6, r7);
    L13:
        ((List) r7).add(r5);
        goto L9
    L14:
        Iterator r8 = r3.entrySet().iterator();
    L16:
        if (r8.hasNext() == false) goto L42;
        Map.Entry r9 = (Map.Entry) r8.next();
        p r10 = (p) r9.getKey();
        List r12 = (List) r9.getValue();
        r10.getClass();
        MessageReferenceIconStore r11 = MessageReferenceIconStore.a;
        String r13 = MessageReferenceIconStore.a(r10.a, r10.b, r10.c);
        if (r13 == null) goto L16;
        MessageReferenceIconStore r14 = MessageReferenceIconStore.a;
        Intrinsics.checkNotNullParameter(r13, "cacheKey");
        Bitmap r15 = MessageReferenceIconStore.e(r13);
        if (r15 != null) goto L22;
        List<Job> r16 = this.c;
        ArrayList r17 = (ArrayList) r16;
        r17.add(BuildersKt.launch$default(r1, null, null, new AvatarBinding$load$2$2(this, r10, r13, r12, null), 3, null));
        goto L16
    L22:
        Iterator r18 = r12.iterator();
    L24:
        if (r18.hasNext() == false) goto L26;
        d r19 = (d) r18.next();
        r19.getClass();
        Intrinsics.checkNotNullParameter(r13, "cacheKey");
        Intrinsics.checkNotNullParameter(r15, "bitmap");
        r19.e = r13;
        RoundedBitmapDrawable r20 = RoundedBitmapDrawableFactory.create(r19.a, r15);
        r20.setCircular(true);
        r19.f = r20;
        goto L24
    L26:
        this.a.invalidate();
        goto L16
    L42:
        return;
    L41:
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        b();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        a();
    }

    public AvatarBinding(TextView r2, List<d> r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "spans");
        this.a = r2;
        this.b = r3;
        this.c = new ArrayList();
    }
}
