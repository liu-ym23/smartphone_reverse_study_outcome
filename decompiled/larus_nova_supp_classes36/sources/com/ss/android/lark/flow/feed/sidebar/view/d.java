package com.ss.android.lark.flow.feed.sidebar.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.feed.shared.page.binder2.o;
import com.ss.android.lark.flow.feed.component.title.FlowTitleView;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements Runnable {
    public final /* synthetic */ ueb.a a;
    public final /* synthetic */ FeedSidebarCommonViewHolder b;
    public final /* synthetic */ UIFeedCard c;
    public final /* synthetic */ LinkedHashMap<FeedActionType, aeb.c> d;
    public final /* synthetic */ aeb.a e;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ ueb.a a;

        public a(ueb.a r1, FeedSidebarCommonViewHolder r2) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            zeb.a r3 = this.a.z();
            if (r3 == null) goto L5;
            r3.b();
            return;
        L5:
            com.ss.android.lark.flow.feed.utils.b.e("FeedSidebarCommonViewHolder", "FeedDataListener is null!");
        }
    }

    public d(ueb.a r1, FeedSidebarCommonViewHolder r2, UIFeedCard r3, LinkedHashMap<FeedActionType, aeb.c> r4, aeb.a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        zeb.a r0 = this.a.z();
        ViewGroup r1 = null;
        if (r0 == null) goto L5;
        Boolean r2 = Boolean.valueOf(r0.a());
    L7:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L70;
        FeedSidebarCommonViewHolder r3 = this.b;
        UIFeedCard r4 = this.c;
        ueb.a r5 = this.a;
        LinkedHashMap<FeedActionType, aeb.c> r6 = this.d;
        aeb.a r7 = this.e;
        FlowTitleView r9 = r3.g;
        if (r9 == null) goto L76;
        r9.setTitleFadeMaskVisible(false);
    L76:
        o r8 = FeedSidebarCommonViewHolder.s;     // Catch: Throwable -> L66
        if (r8 == null) goto L16;
        UDDialog r10 = r8.a(r3.c, r4, r5, r6, r7, 0);     // Catch: Throwable -> L66
    L17:
        if (r9 == null) goto L19;
        r9.setTitleFadeMaskVisible(true);
    L19:
        r3.h = r10;
        UDDialog r11 = this.b.h;
        if (r11 != null) goto L22;
    L26:
        FeedSidebarCommonViewHolder r12 = this.b;
        UDDialog r13 = r12.h;
        if (r13 != null) goto L30;
    L63:
        this.b.W3(this.c);
        FeedSidebarCommonViewHolder r14 = this.b;
        UDDialog r15 = r14.h;
        if (r15 == null) goto L78;
        r15.setOnDismissListener(new a(this.a, r14));
        return;
    L78:
        return;
    L30:
        if (Build.VERSION.SDK_INT < 31) goto L63;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L58
        Context r17 = ((RecyclerView.ViewHolder) r12).itemView.getContext();     // Catch: Throwable -> L58
        if ((r17 instanceof Activity) == false) goto L35;
        Activity r18 = (Activity) r17;     // Catch: Throwable -> L58
    L36:
        if (r18 == null) goto L56;
        Window r19 = r18.getWindow();     // Catch: Throwable -> L58
        if (r19 == null) goto L41;
        View r20 = FeedSidebarCommonViewHolder.T3(r19);     // Catch: Throwable -> L58
    L43:
        if ((r20 instanceof ViewGroup) == false) goto L45;
        r1 = (ViewGroup) r20;     // Catch: Throwable -> L58
    L45:
        if (r1 == null) goto L56;
        int r21 = r1.getWidth();     // Catch: Throwable -> L58
        int r22 = r1.getHeight();     // Catch: Throwable -> L58
        if (r21 <= 0) goto L56;
        if (r22 <= 0) goto L56;
        Bitmap r23 = Bitmap.createBitmap(r21, r22, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L58
        r1.draw(new Canvas(r23));     // Catch: Throwable -> L58
        ImageView r24 = new ImageView(r18);     // Catch: Throwable -> L58
        r24.setScaleType(ImageView.ScaleType.FIT_XY);     // Catch: Throwable -> L58
        r24.setImageBitmap(r23);     // Catch: Throwable -> L58
        r24.setForeground(new ColorDrawable(ContextCompat.getColor(r24.getContext(), 2131101997)));     // Catch: Throwable -> L58
        r24.setRenderEffect(RenderEffect.createBlurEffect(48.0f, 48.0f, Shader.TileMode.CLAMP));     // Catch: Throwable -> L58
        r1.addView(r24, new FrameLayout.LayoutParams(-1, -1));     // Catch: Throwable -> L58
        b r25 = new b(r12, r24, r23);     // Catch: Throwable -> L58
        Window r26 = r13.getWindow();     // Catch: Throwable -> L58
        if (r26 == null) goto L56;
        View r27 = FeedSidebarCommonViewHolder.T3(r26);     // Catch: Throwable -> L58
        if (r27 == null) goto L56;
        r27.addOnAttachStateChangeListener(new com.ss.android.lark.flow.feed.sidebar.view.a(r25));     // Catch: Throwable -> L58
        goto L56
    L41:
        r20 = null;
    L56:
        Object r28 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L58
    L60:
        Throwable r29 = Result.exceptionOrNull-impl(r28);
        if (r29 == null) goto L63;
        com.ss.android.lark.flow.feed.utils.b.e("FeedSidebarCommonViewHolder", "applySidebarLongClickBlur failed: " + r29.getMessage());
        goto L63
    L35:
        r18 = null;
    L58:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L60
    L22:
        if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L72;
        DialogLancet.handleBlockedDialogShow(r11);
        goto L26
    L72:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L71
    L25:
        DialogLancet.beforeDialogShow(r11);
        r11.show();
        DialogLancet.afterDialogShow(r11);
        goto L26
    L16:
        r10 = null;
    L66:
        th = move-exception;
        if (r9 == null) goto L69;
        r9.setTitleFadeMaskVisible(true);
    L69:
        throw th;
    L70:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
