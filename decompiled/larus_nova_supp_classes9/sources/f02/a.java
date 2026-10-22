package f02;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c12.m;
import c12.t;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.debug.AssetsInfoAdapter;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends FrameLayout {
    public static a f;
    public static boolean g;
    public static final C0229a h = null;
    public AssetsInfoAdapter a;
    public IAssetsManager b;
    public TextView c;
    public m d;
    public Handler e;

    /* JADX INFO: renamed from: f02.a$a, reason: collision with other inner class name */
    public static final class C0229a {
        public C0229a() {
        }
    }

    public static final class b extends Handler {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r9) {
            Intrinsics.checkNotNullParameter(r9, "msg");
            super.handleMessage(r9);
            AssetsInfoAdapter r10 = this.a.getAdapter();
            Integer r0 = null;
            if (r10 == null) goto L10;
            LiveData<List<Pair<e, Boolean>>> r1 = this.a.getMAssetsManager().h0();
            if (r1 == null) goto L7;
            List<? extends Pair<? extends e, Boolean>> r2 = (List) r1.getValue();
        L8:
            r10.y2(r2);
            goto L10
        L7:
            r2 = null;
        L10:
            if (this.a.getProducer() != null) goto L14;
            fd6.b<String> r11 = t.d;
            if ((r11 instanceof m) == false) goto L14;
            this.a.setProducer((m) r11);
        L14:
            TextView r13 = this.a.getMCount();
            StringBuilder r3 = new StringBuilder("共:");
            AssetsInfoAdapter r4 = this.a.getAdapter();
            if (r4 == null) goto L17;
            String r5 = r4.c;
        L18:
            r3.append(r5);
            r3.append("\n速(MB/s)：");
            StringCompanionObject r6 = StringCompanionObject.INSTANCE;
            Object[] r7 = new Object[1];
            m r8 = this.a.getProducer();
            if (r8 == null) goto L21;
            Double r14 = Double.valueOf(r8.f);
        L22:
            r7[0] = r14;
            r3.append(String.format("%.2f", Arrays.copyOf(r7, 1)));
            r3.append(" 均速： ");
            Object[] r15 = new Object[1];
            m r16 = this.a.getProducer();
            if (r16 == null) goto L25;
            Double r17 = Double.valueOf(r16.d / r16.e);
        L26:
            r15[0] = r17;
            r3.append(String.format("%.2f", Arrays.copyOf(r15, 1)));
            r3.append("| ");
            m r18 = this.a.getProducer();
            if (r18 == null) goto L29;
            r0 = Integer.valueOf(r18.e);
        L29:
            r3.append(r0);
            r3.append(' ');
            r13.setText(r3.toString());
            sendEmptyMessageDelayed(0, 2000);
            return;
        L25:
            r17 = null;
            goto L26
        L21:
            r14 = null;
            goto L22
        L17:
            r5 = null;
            goto L18
        }
    }

    static {
        h = new C0229a();
    }

    public final IAssetsManager getMAssetsManager() {
        IAssetsManager r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mAssetsManager");
    L5:
        return r0;
    }

    public final TextView getMCount() {
        TextView r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCount");
    L5:
        return r0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.e.sendEmptyMessageDelayed(0, 2000);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e.removeCallbacksAndMessages(null);
    }

    public final AssetsInfoAdapter getAdapter() {
        return this.a;
    }

    public final Handler getMHandler() {
        return this.e;
    }

    public final m getProducer() {
        return this.d;
    }

    public a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.e = new b(this);
        View r5 = LayoutInflater.from(r4).inflate(2131565163, this, true);
        Intrinsics.checkNotNullParameter(r5, "view");
        RecyclerView r0 = r5.findViewById(2131363264);
        Context r2 = getContext();
        Intrinsics.checkNotNull(r2);
        this.a = new AssetsInfoAdapter(r2);
        r0.setLayoutManager(new LinearLayoutManager(getContext()));
        r0.setAdapter(this.a);
        this.c = (TextView) r5.findViewById(2131363263);
        ((Button) r5.findViewById(2131366981)).setOnClickListener(new f02.b(r5));
        this.b = (AssetsService) f.a(AssetsService.class);
        ((Button) r5.findViewById(2131366934)).setOnClickListener(new c(this));
        AssetsInfoAdapter r6 = this.a;
        List<? extends Pair<? extends e, Boolean>> r1 = null;
        if (r6 == null) goto L12;
        IAssetsManager r3 = this.b;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mAssetsManager");
    L7:
        LiveData<List<Pair<e, Boolean>>> r7 = r3.h0();
        if (r7 == null) goto L10;
        List<? extends Pair<? extends e, Boolean>> r8 = (List) r7.getValue();
    L11:
        r6.y2(r8);
        goto L12
    L10:
        r8 = null;
    L12:
        AssetsInfoAdapter r9 = this.a;
        if (r9 == null) goto L21;
        IAssetsManager r10 = this.b;
        if (r10 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mAssetsManager");
    L17:
        LiveData<List<Pair<e, Boolean>>> r11 = r10.h0();
        if (r11 == null) goto L20;
        r1 = (List) r11.getValue();
    L20:
        r9.y2(r1);
    L21:
        IAssetsManager r13 = this.b;
        if (r13 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mAssetsManager");
    L24:
        LiveData<List<Pair<e, Boolean>>> r14 = r13.h0();
        if (r14 == null) goto L27;
        r14.observeForever(new d(this));
    L27:
        this.e.sendEmptyMessageDelayed(0, 2000);
    }

    public final void setAdapter(AssetsInfoAdapter r1) {
        this.a = r1;
    }

    public final void setMAssetsManager(IAssetsManager r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setMCount(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setMHandler(Handler r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void setProducer(m r1) {
        this.d = r1;
    }
}
