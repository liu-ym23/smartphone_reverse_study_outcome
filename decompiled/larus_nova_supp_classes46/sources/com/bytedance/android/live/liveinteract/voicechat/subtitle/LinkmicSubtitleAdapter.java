package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/subtitle/LinkmicSubtitleAdapter;", "Lcom/bytedance/android/live/liveinteract/voicechat/subtitle/AbstractLinkmicSubtitleAdapter;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicSubtitleAdapter extends AbstractLinkmicSubtitleAdapter {
    public final CopyOnWriteArrayList<nj0.g> a;
    public final Handler b;
    public final IRoom c;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LinkmicSubtitleAdapter a;
        public final /* synthetic */ h0 b;
        public final /* synthetic */ h0 c;
        public final /* synthetic */ int d;

        public b(LinkmicSubtitleAdapter r1, h0 r2, h0 r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.y2(this.b, this.c, this.d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LinkmicSubtitleAdapter a;
        public final /* synthetic */ h0 b;
        public final /* synthetic */ h0 c;
        public final /* synthetic */ nj0.g d;

        public c(LinkmicSubtitleAdapter r1, h0 r2, h0 r3, nj0.g r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.z2(this.b, this.c, this.d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public LinkmicSubtitleAdapter(IRoom r2) {
        this.c = r2;
        this.a = new CopyOnWriteArrayList();
        this.b = new Handler(Looper.getMainLooper());
    }

    public final int getItemViewType(int r4) {
        if (r4 != 0) goto L6;
    L9:
        return 1;
    L6:
        if ((!Intrinsics.areEqual(this.a.get(r4).b, this.a.get(r4 - 1).b)) == false) goto L9;
        return 2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        if ((r3 instanceof LinkmicSubtitleViewHolder) == false) goto L10;
        nj0.g r5 = this.a.get(r4);
        ((LinkmicSubtitleViewHolder) r3).getClass();
        Intrinsics.checkNotNullParameter(r5, "subtitleItem");
        IBaseUser r6 = r5.a;
        if (r6 == null) goto L8;
        r6.getRemarkNameOrRealNickName();
    L8:
        throw null;
    L10:
        if ((r3 instanceof LinkmicSubtitleViewHolderV2) == false) goto L13;
        LinkmicSubtitleViewHolderV2 r7 = (LinkmicSubtitleViewHolderV2) r3;
        nj0.g r8 = this.a.get(r4);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "subtitleItem");
        r7.a.setText(r8.c);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r4, "parent");
        ALogger.d("hjl-test", "viewType=" + r5);
        if (r5 != 2) goto L6;
        return new LinkmicSubtitleViewHolderV2(LayoutInflater.from(r4.getContext()).inflate(2131566320, r4, false));
    L6:
        return new LinkmicSubtitleViewHolderV2(LayoutInflater.from(r4.getContext()).inflate(2131566319, r4, false));
    }

    public final void y2(h0<Boolean> r4, h0<Boolean> r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "isNameScrolling");
        Intrinsics.checkNotNullParameter(r5, "isSubtitleScrolling");
        Boolean r0 = Boolean.FALSE;
        if (Intrinsics.areEqual(r4.a(r0), r0) == true) goto L5;
    L7:
        this.b.removeCallbacksAndMessages(null);
        this.b.postDelayed(new b(this, r4, r5, r6), 100);
        return;
    L5:
        if (Intrinsics.areEqual(r5.a(r0), r0) == false) goto L7;
        this.b.removeCallbacksAndMessages(null);
        notifyItemChanged(r6);
    }

    public final void z2(h0<Boolean> r4, h0<Boolean> r5, nj0.g r6) {
        Intrinsics.checkNotNullParameter(r4, "isNameScrolling");
        Intrinsics.checkNotNullParameter(r5, "isSubtitleScrolling");
        Intrinsics.checkNotNullParameter(r6, "subtitleItem");
        Boolean r0 = Boolean.FALSE;
        if (Intrinsics.areEqual(r4.a(r0), r0) == true) goto L5;
    L7:
        this.b.removeCallbacksAndMessages(null);
        this.b.postDelayed(new c(this, r4, r5, r6), 100);
        return;
    L5:
        if (Intrinsics.areEqual(r5.a(r0), r0) == false) goto L7;
        this.b.removeCallbacksAndMessages(null);
        this.a.add(r6);
        notifyItemInserted(this.a.size() - 1);
    }
}
