package com.bytedance.android.livesdk.interactivity.pin.container.v2;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.interactivity.api.highlight.container.HighlightPsId;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import j70.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends PinContainerHighlightProcessor {
    public final String t;
    public final C0187a u;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.pin.container.v2.a$a, reason: collision with other inner class name */
    public static final class C0187a implements o {
        public final /* synthetic */ a a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.pin.container.v2.a$a$a, reason: collision with other inner class name */
        public static final class C0188a implements w70.a<h70.b> {
            public final /* synthetic */ C0187a a;

            public C0188a(C0187a r1) {
                this.a = r1;
            }

            public final Widget a(h70.b r2) {
                Intrinsics.checkNotNullParameter(r2, "layerContext");
                return new PSPinWidget(this.a.a);
            }
        }

        public final /* synthetic */ Object[] a() {
            return null;
        }

        public final Class<? extends Widget> c() {
            return null;
        }

        public final ViewGroup e(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return null;
        }

        public final boolean f() {
            return false;
        }

        public final /* synthetic */ boolean g() {
            return true;
        }

        public final boolean h() {
            return true;
        }

        public final boolean i() {
            return true;
        }

        public final w70.a<? extends h70.b> j() {
            return new C0188a(this);
        }

        public C0187a(a r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.pin.container.v2.PinContainerHighlightProcessor
    public final List<g42.f> u() {
        return CollectionsKt.mutableListOf(new com.bytedance.android.livesdk.interactivity.pin.business.comment.i[]{new com.bytedance.android.livesdk.interactivity.pin.business.comment.i()});
    }

    public a() {
        this.t = HighlightPsId.PSHighlightPin.getKey();
        this.u = new C0187a(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.pin.container.v2.PinContainerHighlightProcessor, p32.a, p32.d
    public final String getId() {
        return this.t;
    }

    @Override // com.bytedance.android.livesdk.interactivity.pin.container.v2.PinContainerHighlightProcessor, p32.e
    public final o q() {
        return this.u;
    }

    @Override // com.bytedance.android.livesdk.interactivity.pin.container.v2.PinContainerHighlightProcessor
    public final void s(g42.f r5, HighlightItem r6) {
        Intrinsics.checkNotNullParameter(r5, "processor");
        Intrinsics.checkNotNullParameter(r6, "item");
        long r0 = System.currentTimeMillis();
        com.bytedance.android.livesdk.wrds.syncdata.highlight.b r2 = r5.q(r6);
        if (r2 != null) goto L5;
    L10:
        String r7 = r5.c(r6);
        this.i.put(r7, new PinContainerHighlightProcessor.a(r6, r0));
        o32.a.a("addReviewingItem key=" + r7);
        t(r6);
        this.j.put(r7, r6);
        Map<String, HighlightItem> r8 = this.j;
        ArrayList r1 = new ArrayList(r8.size());
        Iterator r9 = ((LinkedHashMap) r8).entrySet().iterator();
    L12:
        if (r9.hasNext() == false) goto L14;
        r1.add((HighlightItem) ((Map.Entry) r9.next()).getValue());
        goto L12
    L14:
        List<HighlightItem> r10 = CollectionsKt.toMutableList(r1);
        if (r10.size() < 2) goto L17;
        r10.remove(r6);
        ListProtector.add(r10, 0, r6);
    L17:
        A(r10);
        return;
    L5:
        if ((r2 instanceof com.bytedance.android.livesdk.wrds.syncdata.highlight.a) == true) goto L7;
        r2 = null;
    L7:
        com.bytedance.android.livesdk.wrds.syncdata.highlight.a r3 = (com.bytedance.android.livesdk.wrds.syncdata.highlight.a) r2;
        if (r3 == null) goto L10;
        r3.setReviewing(true);
        r3.setReviewingTime(r0);
        goto L10
    }
}
