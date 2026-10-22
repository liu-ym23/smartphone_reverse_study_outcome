package com.bytedance.android.livesdk.dsl.recyclerview;

import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.n0;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yt1.k;
import yt1.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/dsl/recyclerview/SingleDSLViewHolder;", "Lcom/bytedance/android/livesdk/dsl/recyclerview/BaseDSLViewHolder;", "dslservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleDSLViewHolder extends BaseDSLViewHolder {
    public final PropertyOwner<Integer> b;
    public final CompositeDisposable c;
    public final k d;
    public final c e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ SingleDSLViewHolder a;
        public final /* synthetic */ b b;
        public final /* synthetic */ boolean c;

        public a(SingleDSLViewHolder r1, b r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            if (((Integer) r4).intValue() <= 0) goto L22;
            ALogger.d("Live_Slice", "bindDSLItem " + this.b.d + " update:" + this.c);
            k r5 = this.a.d;
            if (r5 == null) goto L7;
            r5.a(new i(this));
        L7:
            k r6 = this.a.d;
            if (r6 == null) goto L17;
            b r0 = this.b;
            if (r0.c != null) goto L15;
            int r1 = com.bytedance.android.livesdk.dsl.util.c.a;
            HashMap<String, Object> r2 = com.bytedance.android.livesdk.dsl.util.c.g(r0.f);
            r0.c = r2;
            HashMap<String, Object> r3 = r0.e;
            if (r3 == null) goto L15;
            if (r2 == null) goto L15;
            r2.putAll(r3);
        L15:
            r6.c(null, r0.c, 0);
        L17:
            if (this.c == true) goto L23;
            k r7 = this.a.d;
            if (r7 == null) goto L24;
            r7.b(au1.a.c.b, true);
            return;
        L24:
            return;
        L23:
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.dsl.recyclerview.BaseDSLViewHolder
    public final void V3() {
        this.c.clear();
    }

    @Override // com.bytedance.android.livesdk.dsl.recyclerview.BaseDSLViewHolder
    public final c T3() {
        return this.e;
    }

    public SingleDSLViewHolder(o r8, c r9) {
        FrameLayout r6 = new FrameLayout(r9.getActivity());
        r6.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        Intrinsics.checkNotNullParameter(r8, "templateData");
        Intrinsics.checkNotNullParameter(r9, "dslRVContext");
        Intrinsics.checkNotNullParameter(r6, "slcView");
        super(r6);
        this.e = r9;
        this.b = new PropertyOwner(0);
        this.c = new CompositeDisposable();
        k r0 = r9.e.d(r8, "", r6, null, new h(this));
        this.d = r0;
        if (((Boolean) n0.a.getValue()).booleanValue() == false) goto L6;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r0, "comp");
        r9.c.add(r0);
    L6:
        yt1.e r10 = r8.a;
        if (r10 == null) goto L18;
        int r11 = (int) r10.a;
        if (r11 < 0) goto L12;
        r11 = UtilityKotlinExtentionsKt.i(r11);
    L12:
        a1.k(r6, r11);
        int r12 = (int) r10.b;
        if (r12 < 0) goto L16;
        r12 = UtilityKotlinExtentionsKt.i(r12);
    L16:
        a1.p(r6, r12);
        return;
    }

    @Override // com.bytedance.android.livesdk.dsl.recyclerview.BaseDSLViewHolder
    public final void U3(b r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "item");
        RxUtilKt.c(com.bytedance.android.live.core.arch.mvvm.f.b(this.b).subscribe(new a(this, r3, r4)), this.c);
    }
}
