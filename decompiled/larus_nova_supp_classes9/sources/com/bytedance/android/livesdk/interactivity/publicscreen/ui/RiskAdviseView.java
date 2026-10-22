package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.interactivity.api.entity.RiskAdviseSyncData;
import com.bytedance.android.livesdk.interactivity.api.entity.RiskAdviseSyncModel;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/ui/RiskAdviseView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", BuildConfig.FLAVOR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "d", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskAdviseView extends FrameLayout {
    public static final /* synthetic */ int j = 0;
    public final TextView a;
    public Disposable b;
    public final d c;
    public final PriorityQueue<com.bytedance.android.livesdk.interactivity.api.entity.j> d;
    public final b e;
    public final c f;
    public boolean g;
    public boolean h;
    public DataCenter i;

    public static final class a<T> implements Comparator {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r4, Object r5) {
            return (((com.bytedance.android.livesdk.interactivity.api.entity.j) r4).getPriority() > ((com.bytedance.android.livesdk.interactivity.api.entity.j) r5).getPriority() ? 1 : (((com.bytedance.android.livesdk.interactivity.api.entity.j) r4).getPriority() == ((com.bytedance.android.livesdk.interactivity.api.entity.j) r5).getPriority() ? 0 : -1));
        }
    }

    public static final class b implements vlc.l {
        public final /* synthetic */ RiskAdviseView a;

        public b(RiskAdviseView r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r2) {
            if ((r2 instanceof com.bytedance.android.livesdk.interactivity.api.entity.j) == true) goto L5;
            r2 = null;
        L5:
            com.bytedance.android.livesdk.interactivity.api.entity.j r3 = (com.bytedance.android.livesdk.interactivity.api.entity.j) r2;
            if (r3 == null) goto L9;
            this.a.d.add(r3);
            this.a.b();
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ RiskAdviseView a;

        public c(RiskAdviseView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RiskAdviseView r0 = this.a;     // Catch: Throwable -> L4
            int r1 = RiskAdviseView.j;     // Catch: Throwable -> L4
            r0.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d extends com.bytedance.android.livesdk.interactivity.common.utils.b {
        public d() {
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ RiskAdviseView a;

        public e(RiskAdviseView r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            RiskAdviseSyncData r4 = (RiskAdviseSyncData) r3;
            RiskAdviseView r0 = this.a;
            r0.h = true;
            if (r0.g == true) goto L7;
            r0.d(r4);
            return;
        }
    }

    public static final class f implements qb2.e {
        public final /* synthetic */ RiskAdviseView a;
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.entity.j b;

        @Override // qb2.e
        public final void a(ak6.g r2) {
            Intrinsics.checkNotNullParameter(r2, "rendResult");
            Intrinsics.checkNotNullParameter(r2, "rendResult");
        }

        @Override // qb2.e
        public final void b(ak6.g r5) {
            Intrinsics.checkNotNullParameter(r5, "rendResult");
            if (qb2.d.b(r5) == false) goto L5;
            boolean r0 = TextMessageTracer.a;
            TextMessageTracer.A("platform advise image load fail");
            RiskAdviseView r1 = this.a;
            int r2 = RiskAdviseView.j;
            r1.b();
        L5:
            SpannableString r6 = r5.a;
            boolean r3 = TextMessageTracer.a;
            TextMessageTracer.A("show platform advise");
            this.a.a.setText(r6);
            d r7 = this.a.c;
            final Map<String, String> r4 = this.b.n();
            r7.getClass();
            com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_safety_warning_show", new RiskAdviseView$AppLogger$sendPlatformAdviseShow$1(r4));
            RiskAdviseView r8 = this.a;
            r8.getClass();
            UtilityKotlinExtentionsKt.w(r8);
            if (this.b.getDuration() <= 0) goto L9;
            RiskAdviseView r9 = this.a;
            r9.postDelayed(r9.f, this.b.getDuration());
            return;
        }

        public f(RiskAdviseView r1, com.bytedance.android.livesdk.interactivity.api.entity.j r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class g implements qb2.e {
        public final /* synthetic */ RiskAdviseView a;

        public g(RiskAdviseView r1) {
            this.a = r1;
        }

        @Override // qb2.e
        public final void a(ak6.g r2) {
            Intrinsics.checkNotNullParameter(r2, "rendResult");
            Intrinsics.checkNotNullParameter(r2, "rendResult");
        }

        @Override // qb2.e
        public final void b(ak6.g r3) {
            Intrinsics.checkNotNullParameter(r3, "rendResult");
            if (qb2.d.b(r3) == false) goto L5;
            boolean r0 = TextMessageTracer.a;
            TextMessageTracer.A("risk advise image load fail");
        L5:
            SpannableString r4 = r3.a;
            boolean r1 = TextMessageTracer.a;
            TextMessageTracer.A("show risk advise");
            this.a.a.setText(r4);
            RiskAdviseView r2 = this.a;
            if (r2.h == false) goto L8;
            d r5 = r2.c;
            final String r6 = r4.toString();
            r5.getClass();
            Intrinsics.checkNotNullParameter(r6, "content");
            com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_risk_remind_message_show", new RiskAdviseView$AppLogger$sendRiskAdviseShow$1(r6));
            this.a.h = false;
        L8:
            RiskAdviseView r7 = this.a;
            r7.getClass();
            UtilityKotlinExtentionsKt.w(r7);
        }
    }

    public RiskAdviseView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RiskAdviseView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void b() {
        if (this.d.isEmpty() == false) goto L5;
        this.g = false;
        c();
        return;
    L5:
        com.bytedance.android.livesdk.interactivity.api.entity.j r0 = this.d.poll();
        if (r0 != null) goto L9;
        b();
        return;
    L9:
        q r2 = q.a;
        RiskAdviseSyncModel r3 = q.j(this.i);
        a5 r4 = null;
        if (r3 == null) goto L14;
        dc2.c<RiskAdviseSyncData> r5 = r3.getRiskAdviseSyncData();
        if (r5 == null) goto L14;
        RiskAdviseSyncData r6 = r5.c();
    L16:
        if (r0.getPriority() >= RiskAdviseSyncData.PRIORITY) goto L22;
        if (r6 == null) goto L19;
        r4 = r6.adviseText;
    L19:
        if (r4 == null) goto L22;
        this.g = false;
        this.d.clear();
        c();
        return;
    L22:
        Text r1 = r0.l();
        if (r1 == null) goto L25;
        this.g = true;
        qb2.c.a(r1, new f(this, r0));
        return;
    L25:
        b();
        Unit r7 = Unit.INSTANCE;
        return;
    L14:
        r6 = null;
        goto L16
    }

    public final void c() {
        q r0 = q.a;
        RiskAdviseSyncModel r1 = q.j(this.i);
        if (r1 == null) goto L9;
        dc2.c<RiskAdviseSyncData> r2 = r1.getRiskAdviseSyncData();
        if (r2 == null) goto L9;
        RiskAdviseSyncData r3 = r2.c();
        if (r3 == null) goto L9;
        d(r3);
        return;
    L9:
        UtilityKotlinExtentionsKt.t(this);
    }

    public final void d(RiskAdviseSyncData r2) {
        a5 r3 = r2.adviseText;
        if (r3 != null) goto L5;
        boolean r4 = TextMessageTracer.a;
        TextMessageTracer.A("hide risk advise");
        this.h = false;
        UtilityKotlinExtentionsKt.t(this);
        return;
    L5:
        qb2.c.a(r3, new g(this));
    }

    public final void a(DataCenter r4, IRoom r5) {
        UtilityKotlinExtentionsKt.t(this);
        this.i = r4;
        q r0 = q.a;
        RiskAdviseSyncModel r1 = q.j(r4);
        if (r1 == null) goto L9;
        dc2.c<RiskAdviseSyncData> r2 = r1.getRiskAdviseSyncData();
        if (r2 == null) goto L9;
        Observable<RiskAdviseSyncData> r3 = r2.d;
        if (r3 == null) goto L9;
        Disposable r6 = r3.subscribe(new e(this));
    L10:
        this.b = r6;
        IRoomContextService r7 = jc1.k.f(IRoomContextService.class);
        if (r7 == null) goto L21;
        if (r5 == null) goto L14;
        long r8 = r5.getRoomId();
    L15:
        com.bytedance.android.livesdk.chatroom.o r9 = r7.getRoomDataContext(r4, r8);
        if (r9 == null) goto L22;
        com.bytedance.live.datacontext.j r10 = r9.getMessageManager();
        if (r10 == null) goto L23;
        r10.c(new RiskAdviseView$load$2(this));
        return;
    L23:
        return;
    L22:
        return;
    L14:
        r8 = 0;
        goto L15
    L21:
        return;
    L9:
        r6 = null;
        goto L10
    }

    public RiskAdviseView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = new d();
        FrameLayout.inflate(r2, 2131566771, this);
        this.a = (TextView) findViewById(2131391318);
        this.d = new PriorityQueue(10, a.a);
        this.e = new b(this);
        this.f = new c(this);
    }

    public /* synthetic */ RiskAdviseView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
