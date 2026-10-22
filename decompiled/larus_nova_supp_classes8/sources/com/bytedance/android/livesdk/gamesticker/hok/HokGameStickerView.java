package com.bytedance.android.livesdk.gamesticker.hok;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.model.c3;
import com.bytedance.android.livesdk.gamesticker.hok.anim.TaskState;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u001d¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameStickerView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameRoleView;", "a", "Lkotlin/Lazy;", "getRoleView", "()Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameRoleView;", "roleView", "b", "getSecondRoleView", "secondRoleView", "Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameMoneyView;", "c", "getMoneyView", "()Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameMoneyView;", "moneyView", "Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameWinView;", "d", "getWinView", "()Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameWinView;", "winView", "Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameEquipView;", "e", "getEquipView", "()Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameEquipView;", "equipView", "Landroid/view/View;", "f", "getStickerBgView", "()Landroid/view/View;", "stickerBgView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HokGameStickerView extends FrameLayout {
    public static final /* synthetic */ int i = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public int g;
    public final com.bytedance.android.livesdk.gamesticker.hok.anim.e h;

    public static final class a implements com.bytedance.android.livesdk.gamesticker.hok.anim.d {
        public final /* synthetic */ HokGameStickerView a;

        public a(HokGameStickerView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.d
        public final void a(com.bytedance.android.livesdk.gamesticker.hok.anim.a r3) {
            Intrinsics.checkNotNullParameter(r3, "task");
            HokGameStickerView r0 = this.a;
            r3.e();
            int r4 = HokGameStickerView.i;
            r0.getClass();
            this.a.g();
        }

        @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.d
        public final void b(com.bytedance.android.livesdk.gamesticker.hok.anim.a r3) {
            Intrinsics.checkNotNullParameter(r3, "task");
            HokGameStickerView r0 = this.a;
            r3.e();
            int r4 = HokGameStickerView.i;
            r0.getClass();
        }
    }

    public static final class b implements com.bytedance.android.livesdk.gamesticker.hok.anim.g {
        public final /* synthetic */ HokGameStickerView a;

        @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.g
        public final HokGameRoleView a() {
            return HokGameStickerView.d(this.a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.g
        public final HokGameMoneyView b() {
            return HokGameStickerView.b(this.a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.g
        public final HokGameWinView c() {
            return HokGameStickerView.e(this.a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.g
        public final HokGameRoleView d() {
            return HokGameStickerView.c(this.a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.g
        public final HokGameEquipView e() {
            return HokGameStickerView.a(this.a);
        }

        @Override // com.bytedance.android.livesdk.gamesticker.hok.anim.g
        public final float getHeight() {
            if (this.a.getHeight() == 0) goto L8;
            int r0 = this.a.getHeight();
        L6:
            return r0;
        L8:
            if (this.a.getMeasuredHeight() == 0) goto L10;
            r0 = this.a.getMeasuredHeight();
            goto L6
        L10:
            r0 = s1.f(28.0f);
            goto L6
        }

        public b(HokGameStickerView r1) {
            this.a = r1;
        }
    }

    public HokGameStickerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HokGameStickerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final HokGameEquipView getEquipView() {
        return (HokGameEquipView) this.e.getValue();
    }

    private final HokGameMoneyView getMoneyView() {
        return (HokGameMoneyView) this.c.getValue();
    }

    private final HokGameRoleView getRoleView() {
        return (HokGameRoleView) this.a.getValue();
    }

    private final HokGameRoleView getSecondRoleView() {
        return (HokGameRoleView) this.b.getValue();
    }

    private final View getStickerBgView() {
        return (View) this.f.getValue();
    }

    private final HokGameWinView getWinView() {
        return (HokGameWinView) this.d.getValue();
    }

    public final void g() {
        if (this.h.a.isEmpty() == true) goto L5;
        com.bytedance.android.livesdk.gamesticker.hok.anim.a r0 = this.h.a.peek();
        if (r0 != null) goto L9;
        return;
    L9:
        TaskState r1 = r0.a;
        r0.e();
        Objects.toString(r0.a);
        if (r1 != TaskState.CREATE) goto L13;
        r0.d();
        return;
    L13:
        if (r1 != TaskState.END) goto L17;
        com.bytedance.android.livesdk.gamesticker.hok.anim.e r2 = this.h;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "task");
        r0.b = null;
        r0.c = null;
        r2.a.remove(r0);
        g();
        return;
    L17:
        return;
    }

    public final void i() {
        com.bytedance.android.livesdk.gamesticker.hok.anim.e r0 = this.h;
        Iterator<com.bytedance.android.livesdk.gamesticker.hok.anim.a> r1 = r0.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        com.bytedance.android.livesdk.gamesticker.hok.anim.a r2 = r1.next();
        r2.b = null;
        r2.c = null;
        r2.a();
        goto L4
    L6:
        r0.a.clear();
        getRoleView().setRoleInfo(null);
        getSecondRoleView().setRoleInfo(null);
        getWinView().setLiveInfo(null);
        getMoneyView().setMoneyCount(null);
        getEquipView().setEquipState(null);
    }

    public static final /* synthetic */ HokGameEquipView a(HokGameStickerView r0) {
        return r0.getEquipView();
    }

    public static final /* synthetic */ HokGameMoneyView b(HokGameStickerView r0) {
        return r0.getMoneyView();
    }

    public static final /* synthetic */ HokGameRoleView c(HokGameStickerView r0) {
        return r0.getRoleView();
    }

    public static final /* synthetic */ HokGameRoleView d(HokGameStickerView r0) {
        return r0.getSecondRoleView();
    }

    public static final /* synthetic */ HokGameWinView e(HokGameStickerView r0) {
        return r0.getWinView();
    }

    public final void f(c3 r2) {
        if (Intrinsics.areEqual(r2.g(), Boolean.TRUE) == false) goto L5;
        setVisibility(0);
        return;
    L5:
        setVisibility(4);
    }

    public final void h(int r3) {
        if (PadConfigUtils.c() == false) goto L6;
        return;
    L6:
        if (this.g == r3) goto L8;
    L10:
        View r0 = getStickerBgView();
        if (r3 != 0) goto L13;
        Drawable r1 = s1.m(2131249230);
    L14:
        r0.setBackground(r1);
        this.g = r3;
        return;
    L13:
        r1 = s1.m(2131249229);
        goto L14
    L8:
        if (getStickerBgView().getBackground() == null) goto L10;
    }

    public HokGameStickerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new HokGameStickerView$roleView$2(this));
        this.b = LazyKt.lazy(new HokGameStickerView$secondRoleView$2(this));
        this.c = LazyKt.lazy(new HokGameStickerView$moneyView$2(this));
        this.d = LazyKt.lazy(new HokGameStickerView$winView$2(this));
        this.e = LazyKt.lazy(new HokGameStickerView$equipView$2(this));
        this.f = LazyKt.lazy(new HokGameStickerView$stickerBgView$2(this));
        b r5 = new b(this);
        this.h = new com.bytedance.android.livesdk.gamesticker.hok.anim.e(new a(this), r5);
        LayoutInflater.from(r2).inflate(2131566101, this);
        getRoleView().setRoleInfo(null);
        getSecondRoleView().setRoleInfo(null);
        getWinView().setLiveInfo(null);
        getMoneyView().setMoneyCount(null);
        getEquipView().setEquipState(null);
    }

    public /* synthetic */ HokGameStickerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
