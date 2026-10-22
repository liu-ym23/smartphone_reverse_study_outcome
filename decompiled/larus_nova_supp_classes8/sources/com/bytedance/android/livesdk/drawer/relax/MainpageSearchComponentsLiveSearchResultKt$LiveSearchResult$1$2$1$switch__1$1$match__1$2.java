package com.bytedance.android.livesdk.drawer.relax;

import com.relax.relaxframework.ElementAttribute;
import com.relax.relaxframework.LinearCrossGravity;
import com.relax.relaxframework.RelaxFrameworkKt;
import com.relax.relaxframework.RxTextImpl;
import com.relax.relaxframework.a8;
import com.relax.relaxframework.f6;
import com.relax.relaxframework.j5;
import com.relax.relaxframework.p6;
import com.relax.relaxframework.v5;
import com.relax.relaxframework.z2;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/ArrayList;", "Lcom/relax/relaxframework/j5;", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke", "()Ljava/util/ArrayList;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
public final class MainpageSearchComponentsLiveSearchResultKt$LiveSearchResult$1$2$1$switch__1$1$match__1$2 extends Lambda implements Function0<ArrayList<j5>> {
    final /* synthetic */ MainpageSearchComponentsLiveSearchResultKt$LiveSearchResult$1$2$1$switch__1$1 this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.relax.MainpageSearchComponentsLiveSearchResultKt$LiveSearchResult$1$2$1$switch__1$1$match__1$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/ArrayList;", "Lcom/relax/relaxframework/j5;", "Lcom/bytedance/rts/foundation/RTSArray;", "invoke", "()Ljava/util/ArrayList;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<ArrayList<j5>> {
        final /* synthetic */ MainpageSearchComponentsLiveSearchResultKt$LiveSearchResult$1$2$1$switch__1$1$match__1$2 this$0;

        public AnonymousClass1(MainpageSearchComponentsLiveSearchResultKt$LiveSearchResult$1$2$1$switch__1$1$match__1$2 r1) {
            this.this$0 = r1;
            super(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return m1072invoke();
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final ArrayList<j5> m1072invoke() {
            j5 r0 = (v5) RelaxFrameworkKt.P.invoke();
            int r3 = z2.a;
            r0.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().r0(RelaxFrameworkKt.b0(240)).O(RelaxFrameworkKt.b0(160)).X(RelaxFrameworkKt.Z(25))}));
            r0.q0(ElementAttribute.Src, new C02741(this));
            Function2 r2 = RelaxFrameworkKt.z;
            j5 r4 = RelaxFrameworkKt.z(r2, new a8(null), new MainpageSearchComponentsLiveSearchResultKt$LiveSearchResult$1$2$1$switch__1$1$match__1$2$1$switch__2$1(this));
            j5 r6 = (RxTextImpl) RelaxFrameworkKt.T.invoke();
            r6.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().X(RelaxFrameworkKt.b0(20)), z2.a.f().e(2164260863L).j(RelaxFrameworkKt.b0(15))}));
            r6.x0(this.this$0.this$0.this$0.this$0.$subTitle);
            ArrayList<j5> r1 = com.bytedance.rts.foundation.j.k(new j5[]{r0, r4, r6, RelaxFrameworkKt.z(r2, new a8(null), new MainpageSearchComponentsLiveSearchResultKt$LiveSearchResult$1$2$1$switch__1$1$match__1$2$1$switch__3$1(this)), RelaxFrameworkKt.z(r2, new a8(null), new MainpageSearchComponentsLiveSearchResultKt$LiveSearchResult$1$2$1$switch__1$1$match__1$2$1$switch__4$1(this))});
            if (r1 == null) goto L6;
            return r1;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.RTSArray<com.relax.relaxframework.RxElement> /* = java.util.ArrayList<com.relax.relaxframework.RxElement> */");
        }
    }

    public MainpageSearchComponentsLiveSearchResultKt$LiveSearchResult$1$2$1$switch__1$1$match__1$2(MainpageSearchComponentsLiveSearchResultKt$LiveSearchResult$1$2$1$switch__1$1 r1) {
        this.this$0 = r1;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1071invoke();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final ArrayList<j5> m1071invoke() {
        f6 r0 = (f6) RelaxFrameworkKt.C.invoke();
        int r3 = z2.a;
        r0.r0(com.bytedance.rts.foundation.j.k(new p6[]{z2.a.g().r0(RelaxFrameworkKt.Z(100)).O(RelaxFrameworkKt.Z(100))}));
        r0.k0(ElementAttribute.LinearCrossGravity, LinearCrossGravity.Center.getValue());
        r0.R(new AnonymousClass1(this));
        ArrayList<j5> r1 = com.bytedance.rts.foundation.j.k(new f6[]{r0});
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.rts.foundation.RTSArray<com.relax.relaxframework.RxElement> /* = java.util.ArrayList<com.relax.relaxframework.RxElement> */");
    }
}
