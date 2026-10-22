package com.bytedance.android.live.effect.beauty;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ BeautyModeSelectorAdapter a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ BeautyModeSelectorAdapter.BeautyModeItemView d;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.notifyDataSetChanged();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b(BeautyModeSelectorAdapter r1, String r2, String r3, BeautyModeSelectorAdapter.BeautyModeItemView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if ((!Intrinsics.areEqual(this.a.b, this.b)) == false) goto L6;
        List<String> r4 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().h().h(this.b, this.c);
        BeautyModeSelectorAdapter r5 = this.a;
        String r0 = this.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r5.b = r0;
        ((RecyclerView.ViewHolder) this.d).itemView.post(new a(this));
        return;
    }
}
