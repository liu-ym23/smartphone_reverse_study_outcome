package com.bytedance.android.live.ktv.common.tuningpanel.tuningmusiccontrol.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.k1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u001d\u0010\n\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\tR\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0018\u0010\u000eR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0007\u001a\u0004\b\u001b\u0010\u0012R\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u001e\u0010\tR\u001d\u0010\"\u001a\u0004\u0018\u00010\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0007\u001a\u0004\b!\u0010\u000eR\u001d\u0010'\u001a\u0004\u0018\u00010#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0007\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningmusiccontrol/view/TuningMusicControlContainer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "Landroid/view/View;", "b", "Lkotlin/Lazy;", "getDivider2", "()Landroid/view/View;", "divider2", "Landroid/widget/TextView;", "c", "getCurPlayTime", "()Landroid/widget/TextView;", "curPlayTime", "d", "getCutSongContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "cutSongContainer", "e", "getCutSongImg", "cutSongImg", "f", "getCutMusicTv", "cutMusicTv", "g", "getPauseRestartContainer", "pauseRestartContainer", "h", "getPauseRestartImg", "pauseRestartImg", "i", "getPauseRestartTv", "pauseRestartTv", "Landroid/widget/Button;", "j", "getGoKtvDialog", "()Landroid/widget/Button;", "goKtvDialog", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TuningMusicControlContainer extends ConstraintLayout implements LifecycleOwnerCompat {
    public static final /* synthetic */ int n = 0;
    public final ec0.a a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final LifecycleRegistry k;
    public final CompositeDisposable l;
    public final ac0.b m;

    public final TextView getCurPlayTime() {
        return (TextView) this.c.getValue();
    }

    public final TextView getCutMusicTv() {
        return (TextView) this.f.getValue();
    }

    public final ConstraintLayout getCutSongContainer() {
        return (ConstraintLayout) this.d.getValue();
    }

    public final View getCutSongImg() {
        return (View) this.e.getValue();
    }

    public final View getDivider2() {
        return (View) this.b.getValue();
    }

    public final Button getGoKtvDialog() {
        return (Button) this.j.getValue();
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public final ConstraintLayout getPauseRestartContainer() {
        return (ConstraintLayout) this.g.getValue();
    }

    public final View getPauseRestartImg() {
        return (View) this.h.getValue();
    }

    public final TextView getPauseRestartTv() {
        return (TextView) this.i.getValue();
    }

    public final void R5() {
        ec0.a r0 = this.a;
        long r1 = 0;
        if (r0 == null) goto L5;
        long r3 = r0.o();
    L6:
        SimpleDateFormat r2 = new SimpleDateFormat("mm:ss", Locale.US);
        ec0.a r5 = this.a;
        if (r5 == null) goto L9;
        r1 = r5.c();
    L9:
        String r6 = s1.C(2131918614, new Object[]{r2.format(Long.valueOf(r3)), r2.format(Long.valueOf(r1))});
        SpannableString r4 = new SpannableString(r6);
        r4.setSpan(new ForegroundColorSpan(KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.y)), 0, StringsKt.indexOf$default(r6, "/", 0, false, 6, null), 34);
        TextView r7 = getCurPlayTime();
        if (r7 == null) goto L13;
        r7.setText(r4);
        return;
    L13:
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public final void S5() {
        ec0.a r0 = this.a;
        if (r0 != null) goto L5;
    L12:
        TextView r1 = getPauseRestartTv();
        if (r1 == null) goto L15;
        r1.setText(s1.B(2131918605));
    L15:
        View r2 = getPauseRestartImg();
        if (r2 == null) goto L21;
        r2.setSelected(true);
        return;
    L21:
        return;
    L5:
        if (r0.a() != true) goto L12;
        TextView r3 = getPauseRestartTv();
        if (r3 == null) goto L9;
        r3.setText(s1.B(2131918606));
    L9:
        View r4 = getPauseRestartImg();
        if (r4 == null) goto L19;
        r4.setSelected(false);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        this.k.setCurrentState(Lifecycle.State.STARTED);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        this.k.setCurrentState(Lifecycle.State.DESTROYED);
        fc0.a r0 = this.m.h;
        if (r0 == null) goto L5;
        r0.onClear();
    L5:
        this.l.clear();
    }

    public Lifecycle getLifecycleCompat() {
        return this.k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TuningMusicControlContainer(ac0.b r7, Context r8) {
        Intrinsics.checkNotNullParameter(r7, "config");
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, null, 0);
        this.m = r7;
        ec0.a r0 = r7.l;
        this.a = r0;
        this.b = LazyKt.lazy(new TuningMusicControlContainer$divider2$2(this));
        this.c = LazyKt.lazy(new TuningMusicControlContainer$curPlayTime$2(this));
        this.d = LazyKt.lazy(new TuningMusicControlContainer$cutSongContainer$2(this));
        this.e = LazyKt.lazy(new TuningMusicControlContainer$cutSongImg$2(this));
        this.f = LazyKt.lazy(new TuningMusicControlContainer$cutMusicTv$2(this));
        this.g = LazyKt.lazy(new TuningMusicControlContainer$pauseRestartContainer$2(this));
        this.h = LazyKt.lazy(new TuningMusicControlContainer$pauseRestartImg$2(this));
        this.i = LazyKt.lazy(new TuningMusicControlContainer$pauseRestartTv$2(this));
        this.j = LazyKt.lazy(new TuningMusicControlContainer$goKtvDialog$2(this));
        LifecycleRegistry r2 = new LifecycleRegistry(this);
        this.k = r2;
        CompositeDisposable r3 = new CompositeDisposable();
        this.l = r3;
        r2.setCurrentState(Lifecycle.State.CREATED);
        LayoutInflater.from(r8).inflate(2131566539, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(s1.f(16.0f), s1.f(5.0f), s1.f(16.0f), s1.f(15.0f));
        fc0.a r9 = r7.h;
        if (r9 == null) goto L5;
        r9.a(this);
    L17:
        fc0.a r11 = r7.h;
        if (r11 == null) goto L20;
        r11.b(this);
        return;
    L20:
        if (r0 == null) goto L22;
        r0.k();
    L22:
        S5();
        if (r0 == null) goto L25;
        r0.p(this, new a(this));
    L25:
        ConstraintLayout r12 = getCutSongContainer();
        if (r12 == null) goto L28;
        r12.setOnClickListener(new b(this));
    L28:
        ConstraintLayout r13 = getPauseRestartContainer();
        if (r13 == null) goto L31;
        r13.setOnClickListener(new k1(new TuningMusicControlContainer$addObserver$3(this), TuningMusicControlContainer$addObserver$4.INSTANCE));
    L31:
        Button r14 = getGoKtvDialog();
        if (r14 == null) goto L34;
        r14.setOnClickListener(new c(this));
    L34:
        R5();
        if (r0 == null) goto L41;
        Disposable r15 = r0.n(new d(this));
        if (r15 == null) goto L42;
        RxUtilKt.c(r15, r3);
        return;
    L42:
        return;
    L41:
        return;
    L5:
        TextView r16 = getCurPlayTime();
        if (r16 == null) goto L8;
        r16.setTextColor(ColorProtector.parseColor("#B2B2B2"));
    L8:
        View r17 = getPauseRestartImg();
        if (r17 == null) goto L11;
        KtvOrderSongThemeManager.c(r17, KtvOrderSongThemeManager.z);
    L11:
        ConstraintLayout r18 = getCutSongContainer();
        if (r18 == null) goto L14;
        r18.setVisibility(0);
    L14:
        ConstraintLayout r19 = getPauseRestartContainer();
        if (r19 == null) goto L17;
        r19.setVisibility(0);
        goto L17
    }
}
