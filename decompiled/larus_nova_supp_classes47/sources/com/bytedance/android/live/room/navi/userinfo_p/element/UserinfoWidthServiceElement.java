package com.bytedance.android.live.room.navi.userinfo_p.element;

import android.animation.Animator;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement;
import com.bytedance.android.live.room.navi.userinfo_p.utils.RoomUserInfoUtil;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/element/UserinfoWidthServiceElement;", "Lcom/bytedance/android/live/room/navi/userinfo_p/element/base/BaseElement;", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserinfoWidthServiceElement extends BaseElement {
    public final String d;
    public final int e;
    public int f;
    public final int g;
    public final TextPaint h;
    public final CompositeDisposable i;
    public Animator j;
    public final View k;

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void j() {
        super.j();
        this.i.clear();
        Animator r0 = this.j;
        if (r0 == null) goto L11;
        if (r0.isRunning() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L11;
        r0.cancel();
    L11:
        if (RoomUserInfoUtil.a(getDataCenter()) == false) goto L21;
        r r1 = z51.a.e(getDataCenter());
        if (r1 == null) goto L22;
        com.bytedance.live.datacontext.n r2 = r1.G();
        if (r2 == null) goto L17;
        r2.setValue(Boolean.FALSE);
    L17:
        com.bytedance.live.datacontext.n r3 = r1.A();
        if (r3 == null) goto L23;
        r3.setValue(null);
        return;
    L23:
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement
    public final void k() {
        super.k();
        boolean r3 = true;
        if (RoomUserInfoUtil.b(getDataCenter()) == false) goto L9;
        Lazy r0 = RoomUserInfoUtil.a;
        if (((Number) r0.getValue()).intValue() != 2) goto L7;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        String r2 = StringsKt.repeat("龟", ((Number) RoomUserInfoUtil.b.getValue()).intValue());
        this.f = MathKt.roundToInt(this.h.measureText(r2));
    L12:
        DataCenter r4 = getDataCenter();
        if (RoomUserInfoUtil.b(r4) == false) goto L19;
        Lazy r5 = RoomUserInfoUtil.a;
        if (((Number) r5.getValue()).intValue() != 2) goto L17;
    L18:
        boolean r6 = true;
    L20:
        if (r6 == false) goto L22;
    L25:
        boolean r7 = true;
    L26:
        if (r7 == false) goto L58;
        String r8 = this.c.getName();
        if (r8 != null) goto L30;
        int r9 = 0;
    L31:
        r r10 = z51.a.e(getDataCenter());
        if (RoomUserInfoUtil.a(getDataCenter()) == true) goto L34;
    L55:
        int r12 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r9, this.f), this.e);
        this.c.b().getMiddleVm().getUserNameLayoutMaxWidthPx().setValue(Integer.valueOf(r12));
        this.c.b().getMiddleVm().getUserNameLayoutCurWidthPx().setValue(Integer.valueOf(r12));
    L56:
        m(this.c.b().getMiddleVm().getDslLabelWidth().a(), new UserinfoWidthServiceElement$handleNicknameWidth$1(this));
        return;
    L34:
        if (r9 <= this.f) goto L55;
        if (r10 == null) goto L55;
        com.bytedance.live.datacontext.m r13 = r10.w();
        if (r13 == null) goto L55;
        if (((Boolean) r13.getValue()).booleanValue() == true) goto L55;
        int r14 = RangesKt.coerceAtMost(r9, this.g);
        com.bytedance.live.datacontext.n r15 = r10.G();
        if (r15 == null) goto L43;
        r15.setValue(Boolean.TRUE);
    L43:
        com.bytedance.live.datacontext.n r16 = r10.A();
        if (r16 == null) goto L46;
        r16.setValue(Float.valueOf(0.0f));
    L46:
        this.c.b().getMiddleVm().getUserNameLayoutMaxWidthPx().setValue(Integer.valueOf(r14));
        this.c.b().getMiddleVm().getUserNameLayoutCurWidthPx().setValue(Integer.valueOf(r14));
        this.i.clear();
        Long r17 = RoomUserInfoUtil.c;
        if (r17.longValue() >= 0) goto L50;
        r3 = false;
    L50:
        if (r3 == true) goto L53;
        r17 = null;
    L53:
        if (r17 == null) goto L56;
        RxUtilKt.c(RxUtilKt.h(Observable.timer(r17.longValue(), TimeUnit.MILLISECONDS)).subscribe(new o(this, r14)), this.i);
        goto L56
    L30:
        r9 = MathKt.roundToInt(this.h.measureText(r8));
        goto L31
    L58:
        return;
    L22:
        if (RoomUserInfoUtil.a(r4) == true) goto L25;
        r7 = false;
        goto L26
    L17:
        if (((Number) r5.getValue()).intValue() == 4) goto L18;
    L19:
        r6 = false;
        goto L20
    L7:
        if (((Number) r0.getValue()).intValue() == 4) goto L8;
    L9:
        r1 = false;
        goto L10
    }

    public UserinfoWidthServiceElement(m91.d r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "userInfoAbility");
        super(r2);
        this.k = r3;
        this.d = "UserinfoWidthServiceElement";
        this.e = UtilityKotlinExtentionsKt.i(66);
        this.f = UtilityKotlinExtentionsKt.i(78);
        this.g = UtilityKotlinExtentionsKt.i(137);
        if (r3 == null) goto L8;
        TextView r4 = (TextView) r3.findViewById(2131392049);
        if (r4 == null) goto L8;
        TextPaint r5 = r4.getPaint();
        if (r5 == null) goto L8;
    L9:
        this.h = r5;
        this.i = new CompositeDisposable();
        return;
    L8:
        r5 = new TextPaint();
        r5.setTextSize(12.0f);
        Unit r6 = Unit.INSTANCE;
        goto L9
    }
}
