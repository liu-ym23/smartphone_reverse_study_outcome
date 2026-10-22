package com.bytedance.android.live.openplatform.impl.minigameanchor.cast;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.broadcast.api.model.OpenPlatformMgInfoModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.live.datacontext.n;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends AlertDialog {
    public static final int f = 0;
    public static final int g = 0;
    public LinearLayout a;
    public HSImageView b;
    public TextView c;
    public final OpenPlatformContext d;
    public int e;

    public static final class a {
    }

    public final class b implements View.OnTouchListener {
        public int a;
        public int b;
        public final /* synthetic */ h c;

        public b(h r1) {
            this.c = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r4, MotionEvent r5) {
            if (r5 == null) goto L31;
            if (r4 == null) goto L31;
            int r6 = r5.getAction();
            if (r6 != 0) goto L9;
            this.a = (int) r5.getRawX();
            this.b = (int) r5.getRawY();
            r5.getRawX();
            r5.getRawY();
            return true;
        L9:
            if (r6 == 2) goto L11;
            return false;
        L11:
            int r7 = (int) r5.getRawX();
            int r8 = (int) r5.getRawY();
            int r0 = r7 - this.a;
            int r2 = r8 - this.b;
            this.a = r7;
            this.b = r8;
            Window r9 = this.c.getWindow();
            if (r9 == null) goto L16;
            WindowManager.LayoutParams r10 = r9.getAttributes();
            if (r10 == null) goto L16;
            r10.x += r0;
            r10.y += r2;
        L16:
            Window r11 = this.c.getWindow();
            if (r11 == null) goto L23;
            Window r12 = this.c.getWindow();
            if (r12 == null) goto L21;
            WindowManager.LayoutParams r13 = r12.getAttributes();
        L22:
            r11.setAttributes(r13);
            goto L23
        L21:
            r13 = null;
        L23:
            h r14 = this.c;
            if (DialogLancet.shouldBlockDialogShow(r14) == false) goto L33;
            DialogLancet.handleBlockedDialogShow(r14);
        L28:
            return true;
        L33:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
        L27:
            DialogLancet.beforeDialogShow(r14);
            r14.show();
            DialogLancet.afterDialogShow(r14);
        L31:
            return false;
        }
    }

    static {
        f = (int) s1.e(10.0f);
        g = (int) s1.e(178.0f);
    }

    @Override // android.app.Dialog
    public final void show() {
        Window r0 = getWindow();
        if (r0 == null) goto L12;
        View r1 = r0.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L9:
        if (r1 == null) goto L12;
        r1.setPadding(0, 0, 0, 0);
    L12:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L18;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L18:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L15:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        setContentView(2131567568);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        Window r0 = getWindow();
        if (r0 == null) goto L5;
        r0.setBackgroundDrawableResource(R.color.transparent);
    L5:
        Window r1 = getWindow();
        if (r1 == null) goto L8;
        r1.clearFlags(2);
    L8:
        Window r2 = getWindow();
        if (r2 == null) goto L11;
        r2.addFlags(8);
    L11:
        Window r3 = getWindow();
        if (r3 == null) goto L16;
        WindowManager.LayoutParams r5 = r3.getAttributes();
        if (r5 == null) goto L16;
        r5.width = (int) s1.e(108.0f);
    L16:
        Window r6 = getWindow();
        if (r6 == null) goto L21;
        WindowManager.LayoutParams r7 = r6.getAttributes();
        if (r7 == null) goto L21;
        r7.height = (int) s1.e(30.0f);
    L21:
        Window r8 = getWindow();
        if (r8 == null) goto L26;
        WindowManager.LayoutParams r9 = r8.getAttributes();
        if (r9 == null) goto L26;
        r9.x = f;
    L26:
        Window r10 = getWindow();
        if (r10 == null) goto L31;
        WindowManager.LayoutParams r11 = r10.getAttributes();
        if (r11 == null) goto L31;
        r11.y = g;
    L31:
        Window r12 = getWindow();
        if (r12 == null) goto L35;
        r12.setType(1);
    L35:
        if (this.e != 0) goto L37;
        this.e = 8388659;
    L37:
        Window r13 = getWindow();
        if (r13 == null) goto L40;
        r13.setGravity(this.e);
    L40:
        this.a = (LinearLayout) findViewById(2131384833);
        this.b = findViewById(2131365264);
        this.c = (TextView) findViewById(2131365274);
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r14 = AnchorMiniGameDataContext.a.a();
        if (r14 == null) goto L47;
        n<OpenPlatformMgInfoModel> r15 = r14.getOpenPlatformMg();
        if (r15 == null) goto L47;
        OpenPlatformMgInfoModel r16 = (OpenPlatformMgInfoModel) r15.getValue();
        if (r16 == null) goto L47;
        String r17 = r16.getAppIcon();
    L49:
        if (r17 == null) goto L54;
        HSImageView r18 = this.b;
        if (r18 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("castIconIV");
    L53:
        ImageLoader.bindImage(r18, r17);
    L54:
        LinearLayout r19 = this.a;
        if (r19 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("rootLL");
    L57:
        r19.setOnTouchListener(new b(this));
        HSImageView r20 = this.b;
        if (r20 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("castIconIV");
    L60:
        r20.setClickable(false);
        TextView r21 = this.c;
        if (r21 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("castTipsTV");
    L63:
        r21.setOnClickListener(new i(this));
        return;
    L47:
        r17 = null;
        goto L49
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        return super.onTouchEvent(r2);
    }

    public h(Context r2, OpenPlatformContext r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "miniGameContext");
        super(r2);
        this.d = r3;
        this.e = 51;
    }
}
