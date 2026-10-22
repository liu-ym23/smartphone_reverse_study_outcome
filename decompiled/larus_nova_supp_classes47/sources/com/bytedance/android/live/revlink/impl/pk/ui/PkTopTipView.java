package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.link.model.ITopTip;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0018B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u001b\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0010\u0010\u0014B#\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0010\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/PkTopTipView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdk/link/model/ITopTip;", "topTip", "", "setData", "", "b", "Z", "getPkAvailable", "()Z", "setPkAvailable", "(Z)V", "pkAvailable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkTopTipView extends ConstraintLayout {
    public Map<Integer, View> a;
    public boolean b;
    public boolean c;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ PkTopTipView a;

        public b(PkTopTipView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((TextView) this.a._$_findCachedViewById(2131391645)).setFocusable(true);     // Catch: Throwable -> L4
            ((TextView) this.a._$_findCachedViewById(2131391645)).setFocusableInTouchMode(true);     // Catch: Throwable -> L4
            ((TextView) this.a._$_findCachedViewById(2131391645)).requestFocus();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PkTopTipView a;
        public final /* synthetic */ ITopTip b;

        public c(PkTopTipView r1, ITopTip r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            PkTopTipView r5 = this.a;
            r5.c = true;
            r5._$_findCachedViewById(2131384838).setVisibility(8);
            ITopTip r6 = this.b;
            Integer r0 = null;
            if (r6 != null) goto L5;
        L7:
            HashMap r7 = new HashMap();
            ITopTip r1 = this.b;
            if (r1 == null) goto L10;
            r0 = Integer.valueOf(r1.getTopTipType());
        L10:
            r7.put("content", String.valueOf(r0));
            r7.put("action_type", "click");
            mz0.n r2 = new mz0.n();
            Map<String, String> r3 = r2.a;
            Intrinsics.checkNotNullParameter(r3, "map");
            Intrinsics.checkNotNullParameter(r7, "map");
            r3.putAll(r7);
            mz0.m r8 = new mz0.m();
            r8.b(LogCommon.ROOM);
            List<Object> r9 = r2.b;
            ArrayList r10 = (ArrayList) r9;
            r10.addAll(r8.a);
            cy0.e.a.getClass();
            cy0.j r12 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r13);
            ((mz0.i) ((f80.a) r13)).w3("livesdk_pk_invite_yellow_bar", r2.a, r2.b);
            return;
        L5:
            if (r6.getTopTipType() != ITopTip.TopTipType.TopTipTeamTask.ordinal()) goto L7;
            l51.a.i0.setValue(null, l51.a.a[70], Boolean.TRUE);
            goto L7
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5() {
        LayoutInflater.from(getContext()).inflate(2131567809, this, true);
        a1.k(_$_findCachedViewById(2131384838), 0);
    }

    public final boolean getPkAvailable() {
        return this.b;
    }

    public PkTopTipView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new LinkedHashMap();
        R5();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View _$_findCachedViewById(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void setData(ITopTip r18) {
        if (r18 == null) goto L8;
        py.k r3 = r18.getTopImg();
        if (r3 == null) goto L8;
        _$_findCachedViewById(2131376699).setVisibility(0);
        ImageLoader.bindImage(_$_findCachedViewById(2131376699), r3);
    L8:
        if (r18 == null) goto L10;
        String r4 = r18.getTopContent();
    L11:
        ((TextView) _$_findCachedViewById(2131391645)).setText(r4);
        ((TextView) _$_findCachedViewById(2131391645)).setFocusable(false);
        ((TextView) _$_findCachedViewById(2131391645)).setFocusableInTouchMode(false);
        ((TextView) _$_findCachedViewById(2131391645)).postDelayed(new b(this), 2000);
        if (r18 == null) goto L17;
        if (r18.getTopTipType() != ITopTip.TopTipType.TopTipPunish.ordinal()) goto L17;
        ((TextView) _$_findCachedViewById(2131391645)).setTextColor(s1.h(2131108053));
        _$_findCachedViewById(2131376681).setImageResource(2131251341);
        ((TextView) _$_findCachedViewById(2131391645)).setVisibility(0);
        _$_findCachedViewById(2131376681).setVisibility(0);
        _$_findCachedViewById(2131384838).setBackgroundColor(ColorProtector.parseColor("#1FFFBC1F"));
        _$_findCachedViewById(2131384838).setVisibility(0);
        a1.k(_$_findCachedViewById(2131384838), UtilityKotlinExtentionsKt.i(38));
        HashMap r2 = new HashMap();
        r2.put("action_type", "show");
        r2.put("content", String.valueOf(r18.getTopTipType()));
        mz0.n r5 = new mz0.n();
        Map<String, String> r6 = r5.a;
        Intrinsics.checkNotNullParameter(r6, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
        r6.putAll(r2);
        mz0.m r7 = new mz0.m();
        r7.b(LogCommon.ROOM);
        ((ArrayList) r5.b).addAll(r7.a);
        cy0.e.a.getClass();
        cy0.j r8 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r9);
        ((mz0.i) ((f80.a) r9)).w3("livesdk_pk_invite_yellow_bar", r5.a, r5.b);
    L34:
        _$_findCachedViewById(2131376681).setOnClickListener(new c(this, r18));
        return;
    L17:
        if (r18 != null) goto L19;
    L23:
        if (r18 != null) goto L25;
    L33:
        _$_findCachedViewById(2131384838).setVisibility(8);
        goto L34
    L25:
        if (r18.getTopTipType() != ITopTip.TopTipType.TopTipsPeakGuide.ordinal()) goto L33;
        if (this.c == true) goto L33;
        ((TextView) _$_findCachedViewById(2131391645)).setTextColor(s1.h(2131108052));
        _$_findCachedViewById(2131376681).setImageResource(2131251340);
        ((TextView) _$_findCachedViewById(2131391645)).setVisibility(0);
        _$_findCachedViewById(2131376681).setVisibility(0);
        _$_findCachedViewById(2131384838).setVisibility(0);
        a1.k(_$_findCachedViewById(2131384838), UtilityKotlinExtentionsKt.i(38));
        HashMap r10 = new HashMap();
        if (this.b == false) goto L31;
        String r12 = "pk_available";
    L32:
        r10.put("remind_type", r12);
        r10.put("content", String.valueOf(r18.getTopTipType()));
        mz0.n r13 = new mz0.n();
        Map<String, String> r14 = r13.a;
        Intrinsics.checkNotNullParameter(r14, "map");
        Intrinsics.checkNotNullParameter(r10, "map");
        r14.putAll(r10);
        mz0.m r15 = new mz0.m();
        r15.b(LogCommon.ROOM);
        ((ArrayList) r13.b).addAll(r15.a);
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r17);
        ((mz0.i) ((f80.a) r17)).w3("livesdk_yellow_bar_show", r13.a, r13.b);
        goto L34
    L31:
        r12 = "pk_not_available";
        goto L32
    L19:
        if (r18.getTopTipType() != ITopTip.TopTipType.TopTipTeamTask.ordinal()) goto L23;
        if (((Boolean) l51.a.i0.getValue(null, l51.a.a[70])).booleanValue() == true) goto L23;
        ((TextView) _$_findCachedViewById(2131391645)).setTextColor(s1.h(2131108052));
        _$_findCachedViewById(2131376681).setImageResource(2131251340);
        ((TextView) _$_findCachedViewById(2131391645)).setVisibility(0);
        _$_findCachedViewById(2131376681).setVisibility(0);
        _$_findCachedViewById(2131384838).setVisibility(0);
        a1.k(_$_findCachedViewById(2131384838), UtilityKotlinExtentionsKt.i(38));
        HashMap r19 = new HashMap();
        r19.put("action_type", "show");
        r19.put("content", String.valueOf(r18.getTopTipType()));
        mz0.n r20 = new mz0.n();
        Map<String, String> r22 = r20.a;
        Intrinsics.checkNotNullParameter(r22, "map");
        Intrinsics.checkNotNullParameter(r19, "map");
        r22.putAll(r19);
        mz0.m r23 = new mz0.m();
        r23.b(LogCommon.ROOM);
        ((ArrayList) r20.b).addAll(r23.a);
        cy0.e.a.getClass();
        cy0.j r24 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r25 = com.bytedance.android.scope.m.b(r24).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r25);
        ((mz0.i) ((f80.a) r25)).w3("livesdk_pk_invite_yellow_bar", r20.a, r20.b);
        goto L34
    L10:
        r4 = null;
        goto L11
    }

    public final void setPkAvailable(boolean r1) {
        this.b = r1;
    }

    public PkTopTipView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new LinkedHashMap();
        R5();
    }

    public PkTopTipView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        R5();
    }
}
