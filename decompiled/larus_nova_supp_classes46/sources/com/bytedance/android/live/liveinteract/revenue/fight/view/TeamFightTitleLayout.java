package com.bytedance.android.live.liveinteract.revenue.fight.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.voicechat.fight.view.FightTitleTextView;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.view.NoPaddingTextView;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import jc1.k;
import je0.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\bB'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/fight/view/TeamFightTitleLayout;", "Landroid/widget/LinearLayout;", "", "timeStamp", "", "setFightingState", "setPenalState", "", "a", "Z", "isStartMode", "()Z", "setStartMode", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TeamFightTitleLayout extends LinearLayout {
    public boolean a;
    public boolean b;
    public final ViewGroup c;
    public final FightTitleTextView d;
    public final NoPaddingTextView e;
    public final View f;
    public final HSImageView g;
    public Disposable h;

    public static final class a {
    }

    static {
    }

    public TeamFightTitleLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TeamFightTitleLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        if (this.b == false) goto L10;
        UtilityKotlinExtentionsKt.t(this.c);
        UtilityKotlinExtentionsKt.t(this.d);
        UtilityKotlinExtentionsKt.t(this.e);
        UtilityKotlinExtentionsKt.w(this.f);
        UtilityKotlinExtentionsKt.w(this.g);
        View r0 = this.f;
        int r2 = s1.f(72.0f);
        String r3 = this.d.getText().toString();
        TextPaint r4 = new TextPaint();
        r4.setTextSize(s1.e(11.0f));
        float r5 = r4.measureText(r3);
        float r6 = this.d.getPaint().measureText(r3);
        if (r6 > r5) goto L7;
    L9:
        UIUtils.updateLayout(r0, r2, -3);
        this.g.setBackgroundResource(2131248603);
        return;
    L7:
        if (r5 <= 0) goto L9;
        r2 = (int) (r2 * (r6 / r5));
        goto L9
    L10:
        UtilityKotlinExtentionsKt.t(this.f);
        UtilityKotlinExtentionsKt.t(this.g);
        UtilityKotlinExtentionsKt.t(this.e);
        UtilityKotlinExtentionsKt.w(this.d);
        UtilityKotlinExtentionsKt.w(this.c);
        this.d.setText(s1.B(2131922804));
        this.c.setBackgroundResource(2131253108);
        UIUtils.updateLayout(this.c, s1.f(68.0f), -3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((!Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE)) == false) goto L16;
        Disposable r0 = this.h;
        if (r0 == null) goto L7;
        r0.dispose();
    L7:
        Disposable r1 = k.n(IMiddlewareUserService.class).user().u().observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this));
        Disposable r2 = this.h;
        if (r2 == null) goto L10;
        r2.dispose();
    L10:
        this.h = r1;
        if (com.bytedance.android.live.liveinteract.utils.e.b() == false) goto L16;
        if (TeamFightContext.Companion.d() == false) goto L16;
        this.b = true;
    L16:
        if (TeamFightContext.Companion.d() == false) goto L19;
        a();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r0 = this.h;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void b(long r3) {
        UIUtils.setViewVisibility(this.e, 0);
        this.e.setText(p6.d(r3));
    }

    public final void setFightingState(long r5) {
        this.a = false;
        this.c.setAlpha(1.0f);
        UtilityKotlinExtentionsKt.t(this.f);
        UtilityKotlinExtentionsKt.t(this.g);
        UtilityKotlinExtentionsKt.w(this.d);
        this.d.setPkTitle(s1.B(2131922767));
        this.d.setTextSize(2, 12.0f);
        a1.m(this.d, s1.f(2.0f));
        UtilityKotlinExtentionsKt.w(this.c);
        this.c.setAlpha(1.0f);
        this.c.setBackgroundResource(2131253108);
        UIUtils.updateLayout(this.c, -2, -3);
        if (this.b == false) goto L5;
        UtilityKotlinExtentionsKt.t(this.f);
        UtilityKotlinExtentionsKt.t(this.g);
    L5:
        b(r5);
    }

    public final void setPenalState(long r5) {
        this.a = false;
        this.c.setAlpha(1.0f);
        UtilityKotlinExtentionsKt.t(this.f);
        UtilityKotlinExtentionsKt.t(this.g);
        UtilityKotlinExtentionsKt.w(this.c);
        this.c.setAlpha(1.0f);
        this.c.setBackgroundResource(2131253108);
        UtilityKotlinExtentionsKt.w(this.d);
        FightTitleTextView r0 = this.d;
        int r1 = h.a;
        Map r2 = (Map) ((Map) vm2.d.K1.getValue(null, vm2.d.a[138(0x8a, float:1.93E-43)])).get(String.valueOf(7));
        if (r2 == null) goto L6;
        String r3 = (String) r2.get(String.valueOf(4));
        if (r3 == null) goto L6;
    L7:
        r0.setPkTitle(r3);
        a1.m(this.d, s1.f(2.0f));
        if (this.b == false) goto L10;
        UtilityKotlinExtentionsKt.t(this.f);
        UtilityKotlinExtentionsKt.t(this.g);
    L10:
        b(r5);
        return;
    L6:
        r3 = s1.B(2131919353);
        goto L7
    }

    public final void setStartMode(boolean r1) {
        this.a = r1;
    }

    public TeamFightTitleLayout(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        setClipChildren(false);
        LayoutInflater.from(r4).inflate(2131567494, this, true);
        setOrientation(0);
        this.f = findViewById(2131388906);
        this.c = (ViewGroup) findViewById(2131388847);
        AppCompatTextView r7 = (FightTitleTextView) findViewById(2131390611);
        this.d = r7;
        NoPaddingTextView r8 = findViewById(2131391589);
        this.e = r8;
        this.g = findViewById(2131388907);
        r7.setTypeface(Typeface.DEFAULT);
        r7.getPaint().setFakeBoldText(true);
        r7.setGradient(false);
        r7.setTextSize(2, 12.0f);
        ck0.c r0 = new ck0.c();
        ck0.a r1 = new ck0.a(getContext());
        r7.getClass();
        Intrinsics.checkNotNullParameter(r0, "textStyle");
        Intrinsics.checkNotNullParameter(r1, "numStyle");
        r7.f = r0;
        r7.g = r1;
        r8.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/clarity_mono_bold.otf"));
        r8.setPadding(0, 0, 0, s1.f(1.0f));
    }

    public /* synthetic */ TeamFightTitleLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
