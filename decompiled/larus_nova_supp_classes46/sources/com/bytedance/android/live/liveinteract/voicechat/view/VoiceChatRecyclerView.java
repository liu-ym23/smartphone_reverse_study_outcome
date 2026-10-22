package com.bytedance.android.live.liveinteract.voicechat.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkMicRecyclerView;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import li0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR#\u0010\u0010\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001b\u0010\u0013\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\fR\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/view/VoiceChatRecyclerView;", "Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/LinkMicRecyclerView;", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "getRedTeamBg", "()Landroid/graphics/drawable/Drawable;", "redTeamBg", "Landroid/graphics/Rect;", "g", "getRedTeamRect", "()Landroid/graphics/Rect;", "redTeamRect", "h", "getBlueTeamBg", "blueTeamBg", "i", "getBlueTeamRect", "blueTeamRect", "Lcom/bytedance/android/live/liveinteract/voicechat/view/VoiceChatTeamFightItemDecoration;", "j", "getTeamFightDecoration", "()Lcom/bytedance/android/live/liveinteract/voicechat/view/VoiceChatTeamFightItemDecoration;", "teamFightDecoration", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VoiceChatRecyclerView extends LinkMicRecyclerView {
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final int k;
    public boolean l;
    public boolean m;

    private final Drawable getBlueTeamBg() {
        return (Drawable) this.h.getValue();
    }

    private final Rect getBlueTeamRect() {
        return (Rect) this.i.getValue();
    }

    private final Drawable getRedTeamBg() {
        return (Drawable) this.f.getValue();
    }

    private final Rect getRedTeamRect() {
        return (Rect) this.g.getValue();
    }

    private final VoiceChatTeamFightItemDecoration getTeamFightDecoration() {
        return (VoiceChatTeamFightItemDecoration) this.j.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t() {
        this.l = false;
        this.m = false;
        removeItemDecoration(getTeamFightDecoration());
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "c");
        if (this.l == true) goto L5;
    L24:
        super.onDraw(r4);
        return;
    L5:
        if (d.e() == true) goto L24;
        Rect r0 = getRedTeamRect();
        r0.right = (getWidth() / 2) - (this.k / 2);
        Rect r1 = getRedTeamRect();
        r1.bottom = getHeight();
        if (this.m == false) goto L9;
        Rect r2 = getRedTeamRect();
        r2.top = (getHeight() * 95) / 285;
    L9:
        Drawable r3 = getRedTeamBg();
        if (r3 == null) goto L12;
        r3.setBounds(getRedTeamRect());
    L12:
        Drawable r5 = getRedTeamBg();
        if (r5 == null) goto L15;
        r5.draw(r4);
    L15:
        Rect r6 = getBlueTeamRect();
        r6.left = (getWidth() / 2) + (this.k / 2);
        Rect r7 = getBlueTeamRect();
        r7.right = getWidth();
        Rect r8 = getBlueTeamRect();
        r8.bottom = getHeight();
        if (this.m == false) goto L18;
        Rect r9 = getBlueTeamRect();
        r9.top = (getHeight() * 95) / 285;
    L18:
        Drawable r10 = getBlueTeamBg();
        if (r10 == null) goto L21;
        r10.setBounds(getBlueTeamRect());
    L21:
        Drawable r11 = getBlueTeamBg();
        if (r11 == null) goto L24;
        r11.draw(r4);
        goto L24
    }

    public VoiceChatRecyclerView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public VoiceChatRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.f = InfraKotlinExtsKt.mainThreadLazy(VoiceChatRecyclerView$redTeamBg$2.INSTANCE);
        this.g = InfraKotlinExtsKt.mainThreadLazy(new VoiceChatRecyclerView$redTeamRect$2(this));
        this.h = InfraKotlinExtsKt.mainThreadLazy(VoiceChatRecyclerView$blueTeamBg$2.INSTANCE);
        this.i = InfraKotlinExtsKt.mainThreadLazy(new VoiceChatRecyclerView$blueTeamRect$2(this));
        this.j = InfraKotlinExtsKt.mainThreadLazy(VoiceChatRecyclerView$teamFightDecoration$2.INSTANCE);
        this.k = s1.f(1.0f);
    }
}
