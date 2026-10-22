package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.SwitchResolutionDialogConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y6 extends Dialog implements com.bytedance.android.live.matchroom.b {
    public LandscapeVideoQualityAdapter a;
    public final float b;
    public final float c;
    public final SwitchResolutionDialogConfig d;
    public final int e;
    public final Room f;
    public final DataCenter g;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        MatchRoomLandScapeAnimUtil.E.j("LandscapeSwitchVideoQualityDialog");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.g, 0, 2);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r1 = r0.getLandscapeVideoQualityDialogShow();
        if (r1 == null) goto L7;
        r1.setValue(Boolean.FALSE);
    L7:
        Handler r2 = DialogLancet.resolveDialogHandler(this);
        if (r2 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(this);
    L22:
        com.bytedance.android.livesdk.f.d().f();
        return;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r3 == null) goto L21;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L10:
        if (Looper.myLooper() == r2.getLooper()) goto L12;
        r2.post(DialogLancet.createDismissRunnable(this));
        goto L22
    }

    public final int getActualContentWidth() {
        return (int) UtilityKotlinExtentionsKt.h(this.b);
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        com.bytedance.android.livesdk.f.d().a();
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.g, 0, 2);
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.m r1 = r0.getLandscapeVideoQualityDialogShow();
        if (r1 == null) goto L12;
        r1.setValue(Boolean.TRUE);
    L12:
        boolean r2 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.x("LandscapeSwitchVideoQualityDialog", this, -1);
        int r3 = AudienceVideoResolutionManager.a;
        AudienceVideoResolutionManager.r(AudienceVideoResolutionManager.c, "dialog_show");
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r9) {
        super.onCreate(r9);
        View r10 = LayoutInflater.from(getContext()).inflate(this.e, null);
        setContentView(r10);
        Window r0 = getWindow();
        if (r0 == null) goto L8;
        r0.setDimAmount(0.0f);
        r0.setLayout((int) UIUtils.dip2Px(r0.getContext(), this.c), -1);
        r0.setGravity(8388613);
        if (PadConfigUtils.c() == true) goto L8;
        com.bytedance.android.livesdk.t8.d(r0);
    L8:
        if (MatchRoomLandScapeAnimUtil.a == false) goto L10;
        r10.setBackgroundResource(0);
    L11:
        Context r3 = getContext();
        Room r4 = this.f;
        DataCenter r5 = this.g;
        LiveCoreSDKData.Quality r1 = AudienceVideoResolutionManager.c();
        if (r1 == null) goto L14;
        r1.getName();
    L14:
        this.a = new LandscapeVideoQualityAdapter(r3, r4, r5, new LandscapeSwitchVideoQualityDialog$initView$1(this), new LandscapeSwitchVideoQualityDialog$initView$2(this));
        View r11 = findViewById(2131383524);
        r11.setVisibility(0);
        com.bytedance.android.livesdk.r3.c(r11, "关闭", true);
        r11.setOnClickListener(new z6(this));
        findViewById(2131384995).setBackground(com.bytedance.android.live.core.utils.s1.m(2131249572));
        RecyclerView r2 = findViewById(2131384995);
        LandscapeVideoQualityAdapter r6 = this.a;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L17:
        r2.setAdapter(r6);
        findViewById(2131384995).setLayoutManager(new LinearLayoutManager(getContext()));
        findViewById(2131384995).addItemDecoration(new LandscapeSwitchVideoQualityDialog$initView$4(this));
        if (this.d.landscapeDialogUseNewStyle() == true) goto L26;
        LandscapeVideoQualityAdapter r7 = this.a;
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L23:
        if (r7.getItemCount() <= 5) goto L27;
        UIUtils.updateLayoutMargin(findViewById(2131384995), -3, (int) UtilityKotlinExtentionsKt.h(20.0f), -3, (int) UtilityKotlinExtentionsKt.h(20.0f));
        return;
    L27:
        return;
    L26:
        return;
    L10:
        r10.setBackgroundResource(2131250044);
        goto L11
    }

    public y6(Context r2, Room r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "room");
        super(r2, 2131954584);
        this.f = r3;
        this.g = r4;
        if (r4 == null) goto L7;
        Boolean r5 = (Boolean) r4.get("data_is_portrait", Boolean.TRUE);
        if (r5 == null) goto L7;
        r5.booleanValue();
    L7:
        this.b = 244.0f;
        this.c = 600.0f;
        SwitchResolutionDialogConfig r6 = (SwitchResolutionDialogConfig) com.bytedance.android.livesdk.f3.a.getValue();
        this.d = r6;
        if (r6.landscapeDialogUseNewStyle() == false) goto L10;
        int r7 = 2131565780;
    L11:
        this.e = r7;
        return;
    L10:
        r7 = 2131565779;
        goto L11
    }
}
