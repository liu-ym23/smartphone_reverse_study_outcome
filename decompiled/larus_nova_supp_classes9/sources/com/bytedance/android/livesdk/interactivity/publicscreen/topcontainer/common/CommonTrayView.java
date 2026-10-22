package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.live.base.model.message.n5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.CombinedTextRenderView;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.DisplayImageListView;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.DisplayTextView;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.o;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\"B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/common/CommonTrayView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/base/model/message/n5;", "msg", BuildConfig.FLAVOR, "setContent", "setBackground", "Lcom/bytedance/android/livesdk/utils/q4$b;", "k", "Lkotlin/Lazy;", "getComboAnim", "()Lcom/bytedance/android/livesdk/utils/q4$b;", "comboAnim", "Ljava/lang/Runnable;", "l", "getComboRunnable", "()Ljava/lang/Runnable;", "comboRunnable", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/common/a;", "m", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/common/a;", "getComboStats", "()Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/common/a;", "setComboStats", "(Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/common/a;)V", "comboStats", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonTrayView extends FrameLayout {
    public final ViewGroup a;
    public final CombinedTextRenderView b;
    public final View c;
    public final TextView d;
    public long e;
    public int f;
    public boolean g;
    public final List<Long> h;
    public final List<Long> i;
    public Function0<Unit> j;
    public final Lazy k;
    public final Lazy l;
    public com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.a m;
    public final CombinedTextRenderView.a n;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ CommonTrayView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ n5 c;

        public b(CommonTrayView r1, String r2, n5 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            ALogger.i("CommonTrayView", "handle schema " + this.b);
            IBaseLiveActionHandler r4 = k.f(IBaseLiveActionHandler.class);
            if (r4 == null) goto L5;
            r4.handle(this.a.getContext(), this.b);
        L5:
            int r5 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.b.a;
            n5 r6 = this.c;
            Intrinsics.checkNotNullParameter(r6, "msg");
            com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.b.a("livesdk_common_tray_click", r6);
        }
    }

    public static final class c implements o {
        public final /* synthetic */ n5 a;

        public c(n5 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.o
        public final void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "schema");
            ALogger.i("CommonTrayView", "handle schema " + r3);
            int r4 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.b.a;
            n5 r5 = this.a;
            Intrinsics.checkNotNullParameter(r5, "msg");
            com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.b.a("livesdk_common_tray_click", r5);
        }
    }

    public static final class d implements a3.b {
        public final /* synthetic */ n5 a;

        public final void onFail() {
            ALogger.e("CommonTrayView", "load background image failed. msgId=" + this.a.getMessageId());
        }

        public d(n5 r1) {
            this.a = r1;
        }

        public final void a(NinePatchDrawable r2) {
            Intrinsics.checkNotNullParameter(r2, "ninePatchDrawable");
            ALogger.i("CommonTrayView", "load background image success");
        }
    }

    static {
    }

    public CommonTrayView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommonTrayView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final q4.b getComboAnim() {
        return (q4.b) this.k.getValue();
    }

    private final Runnable getComboRunnable() {
        return (Runnable) this.l.getValue();
    }

    public final void e() {
        this.g = false;
        if (getComboAnim().b() == false) goto L5;
        getComboAnim().a();
    L5:
        removeCallbacks(getComboRunnable());
        this.c.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    public final com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.a getComboStats() {
        return this.m;
    }

    public static final /* synthetic */ q4.b a(CommonTrayView r0) {
        return r0.getComboAnim();
    }

    public static final /* synthetic */ Runnable b(CommonTrayView r0) {
        return r0.getComboRunnable();
    }

    private final void setBackground(n5 r6) {
        n5.a r2 = r6.getBackground();
        Drawable r3 = null;
        if (r2 == null) goto L5;
        py.k r4 = r2.backgroundImage;
    L6:
        n5.a r5 = r6.getBackground();
        if (r5 == null) goto L9;
        String r7 = r5.backgroundColor;
    L10:
        if (r4 == null) goto L12;
        this.b.setBackground(null);
        int r0 = a3.d;
        a3.a.a(this.b, r4, new d(r6), 0.0f);
        return;
    L12:
        Drawable r8 = this.b.getBackground();
        if ((r8 instanceof GradientDrawable) == false) goto L16;
        r3 = r8;
    L16:
        GradientDrawable r9 = (GradientDrawable) r3;
        if (r9 == null) goto L26;
        r9.setColor(Color.parseColor(r7));     // Catch: Exception -> L20
        ALogger.i("CommonTrayView", "use bg color " + r7);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        ALogger.e("CommonTrayView", "parse color " + r7 + " failed", e);
        return;
    L26:
        return;
    L9:
        r7 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    private final void setContent(n5 r3) {
        com.bytedance.android.live.base.model.message.d r4 = r3.getContent();
        if (r4 != null) goto L5;
        return;
    L5:
        this.b.a(r4, this.n);
    }

    public final void c(n5 r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        setContent(r4);
        setBackground(r4);
        com.bytedance.android.live.base.model.message.d r0 = r4.getContent();
        if (r0 == null) goto L7;
        m6 r1 = r0.c();
        if (r1 == null) goto L7;
        String r2 = r1.a();
    L8:
        if (r2 != null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == true) goto L16;
        this.a.setOnClickListener(new b(this, r2, r4));
        this.b.setOnSchemaHandleListener(new c(r4));
        return;
    L16:
        this.a.setOnClickListener(null);
        this.b.setOnSchemaHandleListener(null);
        return;
    L10:
        if (r2.length() == 0) goto L13;
        r3 = false;
    L7:
        r2 = null;
        goto L8
    }

    public final void setComboStats(com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common.a r1) {
        this.m = r1;
    }

    public final void d(n5.b r8, Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, "comboInfo");
        Intrinsics.checkNotNullParameter(r9, "onFinish");
        List r0 = r8.numList;
        List r1 = r8.durationList;
        List r2 = r0;
        if (r2 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L24;
        List r3 = r1;
        if (r3 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == true) goto L25;
        ALogger.i("CommonTrayView", "start combo");
        if (this.g == false) goto L22;
        e();
    L22:
        this.j = r9;
        this.e = r8.seqId;
        this.f = 0;
        ((ArrayList) this.h).clear();
        ((ArrayList) this.i).clear();
        ((ArrayList) this.h).addAll(r2);
        ((ArrayList) this.i).addAll(r3);
        this.d.setText(String.valueOf(((Number) ListProtector.get(r0, 0)).longValue()));
        this.c.setVisibility(0);
        this.g = true;
        post(getComboRunnable());
        return;
    L25:
        return;
    L13:
        if (r3.isEmpty() == true) goto L16;
        r6 = false;
        goto L17
    L24:
        return;
    L5:
        if (r2.isEmpty() == true) goto L8;
        r5 = false;
        goto L9
    }

    public CommonTrayView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        LayoutInflater.from(r3).inflate(2131567644, this);
        this.a = (ViewGroup) findViewById(2131367581);
        CombinedTextRenderView r6 = (CombinedTextRenderView) findViewById(2131367794);
        this.b = r6;
        r6.setGravity(16);
        this.c = findViewById(2131367231);
        TextView r7 = (TextView) findViewById(2131367247);
        this.d = (TextView) findViewById(2131367236);
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.k = LazyKt.lazy(new CommonTrayView$comboAnim$2(this));
        this.l = LazyKt.lazy(new CommonTrayView$comboRunnable$2(this));
        this.n = new CombinedTextRenderView.a(new DisplayTextView.a(UtilityKotlinExtentionsKt.h(14), true, true, 1662), new DisplayImageListView.a(UtilityKotlinExtentionsKt.i(22), UtilityKotlinExtentionsKt.i(22)));
    }

    public /* synthetic */ CommonTrayView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
