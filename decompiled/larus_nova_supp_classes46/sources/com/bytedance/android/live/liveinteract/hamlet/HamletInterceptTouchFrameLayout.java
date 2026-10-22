package com.bytedance.android.live.liveinteract.hamlet;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.config.uz;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.HamletAvatarMockConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.gson.JsonObject;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fB\u001d\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/liveinteract/hamlet/HamletInterceptTouchFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "setDataCenter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class HamletInterceptTouchFrameLayout extends FrameLayout {
    public long a;
    public final List<com.bytedance.android.live.liveinteract.hamlet.a> b;
    public final CompositeDisposable c;
    public DataCenter d;
    public final Paint e;
    public final Paint f;
    public final boolean g;

    public static final class a {
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.e.setColor(ColorProtector.parseColor("#33ff0000"));
        this.e.setStyle(Paint.Style.FILL);
        this.f.setColor(-16777216);
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setStrokeWidth(com.bytedance.android.anniex.utils.j.a(2));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c.dispose();
    }

    public HamletInterceptTouchFrameLayout(Context r2) {
        this(r2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.dispatchDraw(r4);
        if (this.g == false) goto L10;
        Iterator<T> r0 = this.b.iterator();
    L6:
        if (r0.hasNext() == false) goto L16;
        RectF r1 = ((com.bytedance.android.live.liveinteract.hamlet.a) r0.next()).b;
        if (r1 == null) goto L6;
        r4.drawRect(r1, this.e);
        r4.drawRect(r1, this.f);
        goto L6
    L16:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r9) {
        if (r9 == null) goto L4;
        ((ArrayList) this.b).clear();
        HamletAvatarContext.a r1 = HamletAvatarContext.Companion;
        HamletAvatarContext r2 = r1.getContext();
        if (r2 == null) goto L44;
        com.bytedance.live.datacontext.n<List<com.bytedance.android.live.liveinteract.hamlet.model.k>> r3 = r2.getHamletAvatarUserInfos();
        if (r3 == null) goto L44;
        List r4 = (List) r3.getValue();
        if (r4 == null) goto L44;
        HamletAvatarContext r5 = r1.getContext();
        if (r5 == null) goto L19;
        com.bytedance.live.datacontext.j<gd0.g> r6 = r5.getHamletAvatarService();
        if (r6 == null) goto L19;
        gd0.g r7 = (gd0.g) r6.getValue();
        if (r7 == null) goto L19;
        int r8 = r7.W3();
    L74:
        ALogger.e("HamletAvatar", "TouchAvatar, updateRectList, currentCameraIndex=" + r8 + ", sei=" + GsonHelper.get().toJson(r4));     // Catch: Exception -> L22
    L23:
        if (r8 < 0) goto L44;
        if (r8 >= r4.size()) goto L44;
        Iterator r0 = r4.iterator();
    L27:
        List<com.bytedance.android.live.liveinteract.hamlet.model.q> r10 = null;
        if (r0.hasNext() == false) goto L35;
        Object r11 = r0.next();
        if (((com.bytedance.android.live.liveinteract.hamlet.model.k) r11).a() != r8) goto L32;
        boolean r12 = true;
    L33:
        if (r12 == false) goto L27;
    L36:
        com.bytedance.android.live.liveinteract.hamlet.model.k r13 = (com.bytedance.android.live.liveinteract.hamlet.model.k) r11;
        if (r13 == null) goto L39;
        r10 = r13.b();
    L39:
        if (r10 == null) goto L44;
        Iterator<T> r14 = r10.iterator();
    L42:
        if (r14.hasNext() == false) goto L44;
        com.bytedance.android.live.liveinteract.hamlet.model.q r15 = (com.bytedance.android.live.liveinteract.hamlet.model.q) r14.next();
        RectF r16 = new RectF();
        r16.left = getWidth() * r15.d();
        r16.top = getHeight() * r15.e();
        r16.right = r16.left + (getWidth() * r15.c());
        r16.bottom = r16.top + (getHeight() * r15.a());
        com.bytedance.android.live.liveinteract.hamlet.a r17 = new com.bytedance.android.live.liveinteract.hamlet.a();
        r17.b = r16;
        r17.a = r15.b();
        ((ArrayList) this.b).add(r17);
        goto L42
    L32:
        r12 = false;
        goto L33
    L35:
        r11 = null;
    L19:
        r8 = -1;
    L44:
        Integer r18 = Integer.valueOf(r9.getAction());
        if (r18 != null) goto L48;
    L70:
        if (r18 == null) goto L73;
        r18.intValue();
    L73:
        return false;
    L48:
        if (r18.intValue() != 0) goto L70;
        if (this.a != 0) goto L52;
    L53:
        Iterator r19 = ((ArrayList) this.b).iterator();
    L55:
        if (r19.hasNext() == false) goto L69;
        com.bytedance.android.live.liveinteract.hamlet.a r20 = (com.bytedance.android.live.liveinteract.hamlet.a) r19.next();
        float r21 = r9.getX();
        float r22 = r9.getY();
        RectF r23 = r20.b;
        if (r23 == null) goto L59;
        boolean r24 = r23.contains(r21, r22);
    L60:
        if (r24 == false) goto L55;
        ALogger.e("HamletAvatar", "TouchAvatar, responseAvatarTouchIfNeed, ex=" + r9.getX() + ", ey=" + r9.getY() + ", uid=" + r20.a + ", Rect=" + r20.b);
        DataCenter r25 = this.d;
        if (r25 == null) goto L64;
        r25.put("data_hamlet_avatar_layout_animate", r20.a);
    L64:
        boolean r26 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.j(je0.d.h(), 0, 6) == false) goto L69;
        String r27 = r20.a;
        JsonObject r28 = new JsonObject();
        r28.addProperty("type", "click");
        r28.addProperty("userID", r27);
        ih0.b r29 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(this.d);
        if (r29 == null) goto L69;
        r29.Dk("avatar", "avatar_event", r28, false);
        goto L69
    L59:
        r24 = false;
    L69:
        this.a = System.currentTimeMillis();
        goto L73
    L52:
        if ((System.currentTimeMillis() - this.a) <= 300) goto L73;
    L4:
        return super.dispatchTouchEvent(r9);
    }

    public final void setDataCenter(DataCenter r1) {
        this.d = r1;
    }

    public HamletInterceptTouchFrameLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = new ArrayList();
        this.c = new CompositeDisposable();
        this.e = new Paint();
        this.f = new Paint();
        boolean r4 = ff0.c.a;
        boolean r5 = ((HamletAvatarMockConfig) uz.a.getValue()).getNeedDrawAvatarRect();
        this.g = r5;
        if (r5 == false) goto L6;
        setWillNotDraw(false);
        return;
    }
}
