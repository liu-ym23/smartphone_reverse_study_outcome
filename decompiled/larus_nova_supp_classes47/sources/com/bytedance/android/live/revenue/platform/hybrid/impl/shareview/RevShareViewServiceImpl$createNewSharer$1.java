package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import android.content.Context;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.LoadFailCode;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.ShareViewLoadError;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevShareViewServiceImpl$createNewSharer$1<T> implements SingleOnSubscribe {
    public final /* synthetic */ RevShareViewServiceImpl a;
    public final /* synthetic */ Context b;

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.hybrid.impl.shareview.RevShareViewServiceImpl$createNewSharer$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lyy0/b;", "", "invoke", "(Lyy0/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final class AnonymousClass1 extends Lambda implements Function1<yy0.b, Unit> {
        final /* synthetic */ Ref.ObjectRef $card;
        final /* synthetic */ SingleEmitter $emitter;
        final /* synthetic */ RevShareViewServiceImpl$createNewSharer$1 this$0;

        public AnonymousClass1(RevShareViewServiceImpl$createNewSharer$1 r1, Ref.ObjectRef r2, SingleEmitter r3) {
            this.this$0 = r1;
            this.$card = r2;
            this.$emitter = r3;
            super(1);
        }

        public final void invoke(yy0.b r3) {
            Intrinsics.checkNotNullParameter(r3, "$receiver");
            Iterator<T> r0 = this.this$0.a.c.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r3.f((com.lynx.tasm.behavior.a) r0.next());
            goto L4
        L6:
            r3.d(new AnonymousClass2(this));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yy0.b) r1);
            return Unit.INSTANCE;
        }
    }

    public RevShareViewServiceImpl$createNewSharer$1(RevShareViewServiceImpl r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(SingleEmitter<com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c> r8) {
        Intrinsics.checkNotNullParameter(r8, "emitter");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = null;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r2 = this.a.f.q8(this.b, UriProtector.parse((String) com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.d.getValue(null, com.bytedance.android.live.revenue.platform.hybrid.api.shareview.b.a[2])), new AnonymousClass1(this, r0, r8));
        r0.element = r2;
        if (r2 != null) goto L6;
        r8.onError(new ShareViewLoadError(LoadFailCode.SharerCreateFailed, "annie return null"));
        return;
    L6:
        xy0.a<?> r9 = r2.w();
        Iterator r1 = ((ArrayList) this.a.d).iterator();
    L8:
        if (r1.hasNext() == false) goto L15;
        com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e r3 = (com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e) r1.next();
        if ((r3 instanceof com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e.a) == true) goto L11;
        if ((r3 instanceof com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e.b) == false) goto L8;
        String r4 = r3.a;
        com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e.b r5 = (com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e.b) r3;
        r9.registerMethod(r4, null);
        goto L8
    L11:
        r9.registerMethod(r3.a, ((com.bytedance.android.live.revenue.platform.hybrid.api.shareview.e.a) r3).b);
        goto L8
    L15:
        r9.load();
    }
}
