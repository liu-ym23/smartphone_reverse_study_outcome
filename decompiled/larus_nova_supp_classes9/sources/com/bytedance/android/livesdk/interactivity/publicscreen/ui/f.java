package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.text.Spannable;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.y;
import com.bytedance.live.richcontent.ResourceInfo;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements SingleOnSubscribe {
    public final /* synthetic */ List a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.service.textrender.core.p b;

    public static final class a implements qb2.e {
        public final /* synthetic */ List a;
        public final /* synthetic */ AtomicInteger b;
        public final /* synthetic */ SingleEmitter c;

        @Override // qb2.e
        public final void a(ak6.g r2) {
            Intrinsics.checkNotNullParameter(r2, "rendResult");
            Intrinsics.checkNotNullParameter(r2, "rendResult");
        }

        @Override // qb2.e
        public final void b(ak6.g r4) {
            Intrinsics.checkNotNullParameter(r4, "rendResult");
            List<ResourceInfo> r0 = qb2.d.a(r4);
            if (r0 == null) goto L8;
            Iterator<T> r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L8;
            ALogger.e("AnchorPublicScreenConfigDialog", ((ResourceInfo) r1.next()).a.toString());
        L8:
            this.a.add(r4.a);
            if (this.b.decrementAndGet() != 0) goto L13;
            this.c.onSuccess(this.a);
            return;
        }

        public a(List r1, AtomicInteger r2, SingleEmitter r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public f(List r1, y r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(SingleEmitter<List<Spannable>> r9) {
        Intrinsics.checkNotNullParameter(r9, "emitter");
        CopyOnWriteArrayList r0 = new CopyOnWriteArrayList();
        AtomicInteger r1 = new AtomicInteger(this.a.size());
        qb2.g r2 = new qb2.g(true, this.b.getScale(), 1);
        Iterator<T> r3 = this.a.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        qb2.c.b((tb2.d) r3.next(), new a(r0, r1, r9), new qb2.f(this.b, r2), 24);
        goto L4
    }
}
