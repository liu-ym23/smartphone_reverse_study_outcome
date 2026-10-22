package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.adapter.AudiencePortraitSettingAdapter;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item.DiggItem;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item.IndependentTaskItem;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item.PermissionGrantedItem;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item.PublicScreenConfigItem;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item.SmallWindowItem;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g;
import com.bytedance.android.livesdk.interactivity.api.settings.config.x;
import com.bytedance.android.livesdk.utils.b1;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/settingpanel/ui/AudienceWebcastSettingDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "DivideItemDecoration", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceWebcastSettingDialog extends CommonStandardBottomDialog {
    public List<np1.b> B;
    public Pair<? extends np1.c, ? extends Disposable> C;
    public np1.c D;
    public RecyclerView E;
    public DataCenter F;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/settingpanel/ui/AudienceWebcastSettingDialog$DivideItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DivideItemDecoration extends RecyclerView.ItemDecoration {
        public final Paint a;
        public final float b;
        public final float c;

        public DivideItemDecoration() {
            Paint r0 = new Paint(5);
            if (g.b() == false) goto L5;
            int r1 = 336992291;
        L6:
            r0.setColor(r1);
            r0.setStyle(Paint.Style.FILL);
            Unit r2 = Unit.INSTANCE;
            this.a = r0;
            this.b = UtilityKotlinExtentionsKt.h(16);
            this.c = UtilityKotlinExtentionsKt.h(0.5f);
            return;
        L5:
            r1 = 352321535;
            goto L6
        }

        public final void onDraw(Canvas r9, RecyclerView r10, RecyclerView.State r11) {
            Intrinsics.checkNotNullParameter(r9, "c");
            Intrinsics.checkNotNullParameter(r10, "parent");
            Intrinsics.checkNotNullParameter(r11, "state");
            super.onDraw(r9, r10, r11);
            int r12 = r10.getChildCount();
            int r0 = 0;
        L3:
            if (r0 >= r12) goto L8;
            View r1 = r10.getChildAt(r0);
            if (r10.getChildAdapterPosition(r1) == 0) goto L7;
            float r4 = r1.getTop();
            r9.drawLine(this.b, r4, r10.getMeasuredWidth() - this.b, r4 + this.c, this.a);
        L7:
            r0 = r0 + 1;
            goto L3
        }
    }

    public final int getLayoutId() {
        return 2131565806;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        Pair<? extends np1.c, ? extends Disposable> r1 = this.C;
        if (r1 == null) goto L28;
        Disposable r2 = (Disposable) r1.getSecond();
        if (r2 == null) goto L29;
        r2.dispose();
        return;
    L29:
        return;
    L28:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r3 == null) goto L16;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public AudienceWebcastSettingDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, false);
        this.B = new ArrayList();
    }

    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        int r8 = b1.a;
        Function0<Unit> r9 = new AudienceWebcastSettingDialog$initDialogUI$1(this);
        Intrinsics.checkNotNullParameter(this, "dialog");
        Intrinsics.checkNotNullParameter(r9, "keepCurSetting");
        if (((Boolean) SettingUtil.getValue("key_ttlive_sdk_setting", "live_panel_standardized", Boolean.TYPE, Boolean.FALSE)).booleanValue() == false) goto L5;
        N0();
    L6:
        b1.b(true, new AudienceWebcastSettingDialog$initDialogUI$2(this));
        Pair<? extends np1.c, ? extends Disposable> r10 = com.bytedance.live.datacontext.d.a(new AudienceWebcastSettingDialog$initData$1(this));
        this.C = r10;
        if (r10 == null) goto L54;
        np1.c r11 = (np1.c) r10.getFirst();
        if (r11 == null) goto L54;
        this.D = r11;
        List<np1.b> r2 = this.B;
        np1.b r12 = SmallWindowItem.a(r11);
        if (r12 == null) goto L14;
        r2.add(r12);
    L14:
        List<np1.b> r13 = this.B;
        int r3 = IndependentTaskItem.a;
        np1.c r4 = this.D;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L17:
        np1.b r5 = IndependentTaskItem.a(r4);
        if (r5 == null) goto L20;
        r13.add(r5);
    L20:
        List<np1.b> r14 = this.B;
        int r6 = DiggItem.a;
        np1.c r15 = this.D;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L23:
        np1.b r16 = DiggItem.a(r15);
        if (r16 == null) goto L26;
        r14.add(r16);
    L26:
        List<np1.b> r17 = this.B;
        np1.c r18 = this.D;
        if (r18 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L29:
        PermissionGrantedItem r19 = new PermissionGrantedItem(r18);
        r19.a = true;
        r19.b = new qk1.a();
        r19.e.getCd().add(Disposables.fromAction(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item.a(r19)));
        Unit r20 = Unit.INSTANCE;
        np1.c r21 = this.D;
        if (r21 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L32:
        np1.b r22 = r19.a(r21);
        if (r22 == null) goto L35;
        r17.add(r22);
    L35:
        List<np1.b> r23 = this.B;
        x r24 = PublicScreenConfigItem.a;
        np1.c r25 = this.D;
        if (r25 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L38:
        np1.b r26 = PublicScreenConfigItem.a(r25);
        if (r26 == null) goto L41;
        r23.add(r26);
    L41:
        List<np1.b> r27 = this.B;
        ArrayList r28 = new ArrayList();
        Iterator<T> r29 = r27.iterator();
    L43:
        if (r29.hasNext() == false) goto L53;
        Object r30 = r29.next();
        np1.b r31 = (np1.b) r30;
        if ((r31 instanceof np1.g) == true) goto L47;
    L50:
        boolean r32 = true;
    L51:
        if (r32 == false) goto L43;
        r28.add(r30);
        goto L43
    L47:
        if (((ArrayList) ((np1.g) r31).d).isEmpty() == false) goto L50;
        r32 = false;
        goto L51
    L53:
        this.B = CollectionsKt.toMutableList(r28);
    L54:
        this.E = findViewById(2131384071);
        AudiencePortraitSettingAdapter r33 = new AudiencePortraitSettingAdapter(this.B, false);
        RecyclerView r0 = this.E;
        if (r0 == null) goto L57;
        r0.setAdapter(r33);
    L57:
        RecyclerView r34 = this.E;
        if (r34 == null) goto L66;
        r34.addItemDecoration(new DivideItemDecoration());
        return;
    L66:
        return;
    L5:
        r9.invoke();
        goto L6
    }
}
