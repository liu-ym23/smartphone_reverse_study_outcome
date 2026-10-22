package com.bytedance.android.livesdk.interactivity.barrage.setting.vs;

import a62.d;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.settings.config.a1;
import com.bytedance.android.livesdk.interactivity.barrage.setting.InterceptConstraintLayout;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/setting/vs/BarrageSettingBlockWidget;", "Lcom/bytedance/android/livesdk/interactivity/barrage/setting/vs/AbsBarrageSettingWidget;", "Landroid/view/View$OnClickListener;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BarrageSettingBlockWidget extends AbsBarrageSettingWidget implements View.OnClickListener {
    public ImageView c;
    public TextView d;
    public View e;
    public ImageView f;

    public static final class a implements Runnable {
        public final /* synthetic */ BarrageSettingBlockWidget a;

        public a(BarrageSettingBlockWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BarrageSettingBlockWidget r0 = this.a;     // Catch: Throwable -> L12
            TextView r1 = r0.d;     // Catch: Throwable -> L12
            if (r1 == null) goto L5;
            r1.setOnClickListener(r0);     // Catch: Throwable -> L12
        L5:
            ImageView r2 = r0.c;     // Catch: Throwable -> L12
            if (r2 == null) goto L8;
            r2.setOnClickListener(r0);     // Catch: Throwable -> L12
        L8:
            BarrageSettingBlockWidget r3 = this.a;     // Catch: Throwable -> L12
            ImageView r4 = r3.c;     // Catch: Throwable -> L12
            if (r4 == null) goto L15;
            r4.setSelected(r3.a.isGiftOpen());     // Catch: Throwable -> L12
            return;
        L15:
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public final int getLayoutId() {
        return 2131566812;
    }

    public final void onUnload() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ImageView r3 = this.c;
        if (r3 != null) goto L5;
        return;
    L5:
        r3.setSelected(!r3.isSelected());
        this.a.setGiftOpen(r3.isSelected());
        this.b.X50(this.a);
        wq();
    }

    public final void onInit(Object[] r1) {
        this.c = (ImageView) findViewById(2131378244);
        this.d = (TextView) findViewById(2131389473);
        this.e = findViewById(2131378239);
        this.f = (ImageView) findViewById(2131378238);
        TextView r2 = (TextView) findViewById(2131378240);
    }

    public final void onLoad(Object[] r6) {
        ViewGroup r7 = ((Widget) this).containerView;
        if (r7 == null) goto L5;
        r7.post(new a(this));
    L5:
        IRoomContextService r8 = k.f(IRoomContextService.class);
        if (r8 == null) goto L8;
        o r9 = IRoomContextService.a.a(r8, ((Widget) this).dataCenter, 0, 2);
    L9:
        if (r9 == null) goto L11;
        Boolean r10 = r9.isVSRoom();
    L13:
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == false) goto L17;
        int r11 = a1.a;
        if (a1.a.a().d() == false) goto L17;
        boolean r13 = true;
    L18:
        if (r13 == false) goto L25;
        View r14 = this.e;
        if (r14 == null) goto L22;
        UtilityKotlinExtentionsKt.w(r14);
    L22:
        View r15 = this.e;
        if (r15 == null) goto L31;
        r15.setOnClickListener(new d(this));
    L31:
        ImageView r16 = this.f;
        if (r16 == null) goto L35;
        r16.setSelected(this.a.isCarnivalBarrageOpen());
        return;
    L35:
        return;
    L25:
        View r17 = this.e;
        if (r17 == null) goto L28;
        UtilityKotlinExtentionsKt.t(r17);
    L28:
        View r18 = this.e;
        if (r18 == null) goto L31;
        r18.setOnClickListener(null);
    L17:
        r13 = false;
        goto L18
    L11:
        r10 = null;
        goto L13
    L8:
        r9 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.barrage.setting.vs.AbsBarrageSettingWidget
    public final void xq(BarrageSetting r2) {
        Intrinsics.checkNotNullParameter(r2, "barrageSetting");
        Intrinsics.checkNotNullParameter(r2, "barrageSetting");
        this.a = r2;
        ImageView r0 = this.c;
        if (r0 == null) goto L5;
        r0.setSelected(r2.isGiftOpen());
    L5:
        ImageView r3 = this.f;
        if (r3 == null) goto L9;
        r3.setSelected(this.a.isCarnivalBarrageOpen());
        return;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewGroup, com.bytedance.android.livesdk.interactivity.barrage.setting.InterceptConstraintLayout] */
    @Override // com.bytedance.android.livesdk.interactivity.barrage.setting.vs.AbsBarrageSettingWidget
    public final void yq(boolean r3) {
        Object r0 = ((Widget) this).contentView;
        if ((r0 instanceof InterceptConstraintLayout) == true) goto L5;
        r0 = null;
    L5:
        ?? r1 = (InterceptConstraintLayout) r0;
        if (r1 == 0) goto L13;
        r1.setmIsIntercept(r3);
        if (r3 == false) goto L10;
        float r4 = 0.5f;
    L11:
        r1.setAlpha(r4);
        return;
    L10:
        r4 = 1.0f;
        goto L11
    }

    public BarrageSettingBlockWidget(BarrageSetting r2, AbsBarrageSettingWidget.a r3) {
        Intrinsics.checkNotNullParameter(r2, "barrageSetting");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2, r3);
    }
}
