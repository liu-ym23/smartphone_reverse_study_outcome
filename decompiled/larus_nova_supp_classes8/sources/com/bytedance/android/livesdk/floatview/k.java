package com.bytedance.android.livesdk.floatview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k extends Dialog {
    public FrameLayout a;
    public View b;
    public View c;

    public final void a() {
        FrameLayout r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        ILivePlayerClient r1 = LivePlatformPlayerManager.f();
        if (r1 == null) goto L24;
        IRenderView r2 = r1.getRenderView();
        if (r2 == null) goto L25;
        Bitmap r3 = r2.getBitmap();
        if (r3 == null) goto L16;
        ImageView r4 = new ImageView(getContext());
        r4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r4.setBackground(new BitmapDrawable(getContext().getResources(), r3));
        FrameLayout r5 = this.a;
        if (r5 == null) goto L16;
        r5.addView(r4);
    L16:
        View r6 = r2.getSelfView();
        this.b = r6;
        if (r6 == null) goto L26;
        ViewParent r7 = r6.getParent();
        if ((r7 instanceof ViewGroup) == false) goto L27;
        ((ViewGroup) r7).removeView(this.b);
        FrameLayout r8 = this.a;
        if (r8 == null) goto L28;
        r8.addView(this.b);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L5:
        if (r0.getChildCount() <= 0) goto L7;
        this.a.removeAllViews();
        goto L7
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Room r0 = jc1.k.f(IRoomService.class).getCurrentRoom();
        if (r0 != null) goto L10;
    L12:
        this.c.setVisibility(8);
        return;
    L10:
        if (r0.getStreamType() != LiveMode.AUDIO) goto L12;
        this.c.setVisibility(0);
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public k(Context r2) {
        super(r2, 2131954759);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setContentView(2131565687);
        getWindow().setFlags(1024, 1024);
        this.a = (FrameLayout) findViewById(2131382334);
        this.c = findViewById(2131382332);
        getWindow().setDimAmount(0.0f);
    }
}
