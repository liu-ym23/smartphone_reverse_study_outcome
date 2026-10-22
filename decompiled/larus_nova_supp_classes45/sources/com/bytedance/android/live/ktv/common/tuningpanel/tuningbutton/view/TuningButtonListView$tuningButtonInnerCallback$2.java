package com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/bytedance/android/live/ktv/common/tuningpanel/tuningbutton/view/TuningButtonListView$tuningButtonInnerCallback$2$1", "invoke", "()Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningbutton/view/TuningButtonListView$tuningButtonInnerCallback$2$1;"}, k = 3, mv = {1, 5, 1})
public final class TuningButtonListView$tuningButtonInnerCallback$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ TuningButtonListView this$0;

    /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view.TuningButtonListView$tuningButtonInnerCallback$2$1, reason: invalid class name */
    public static final class AnonymousClass1 implements bc0.a {
        public final /* synthetic */ TuningButtonListView$tuningButtonInnerCallback$2 a;

        @Override // bc0.a
        public final boolean a() {
            bc0.b r0 = this.a.this$0.g.f;
            if (r0 == null) goto L5;
            int r1 = r0.c();
        L7:
            if (r1 > 1) goto L11;
            return false;
        L11:
            return true;
        L5:
            r1 = 2;
            goto L7
        }

        public AnonymousClass1(TuningButtonListView$tuningButtonInnerCallback$2 r1) {
            this.a = r1;
        }

        @Override // bc0.a
        public final void b(final ac0.a r5, final boolean r6) {
            if (r5 != null) goto L4;
            return;
        L4:
            TuningButtonListView r0 = this.a.this$0;
            bc0.b r1 = r0.g.f;
            if (r1 == null) goto L7;
            r1.e(TuningButtonListView.t(r0), r5, r6);
            return;
        L7:
            TuningButtonListView.t(r0).m2(new TuningButtonListView$tuningButtonInnerCallback$2$1$onButtonChecked$$inlined$run$lambda$1(this, r6, r5), r5.getType(), false);
            zb0.a r2 = this.a.this$0.g.e;
            if (r2 == null) goto L12;
            r2.d(r5, r6);
            return;
        }
    }

    public TuningButtonListView$tuningButtonInnerCallback$2(TuningButtonListView r1) {
        this.this$0 = r1;
        super(0);
    }

    public final AnonymousClass1 invoke() {
        return new AnonymousClass1(this);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1124invoke() {
        return invoke();
    }
}
