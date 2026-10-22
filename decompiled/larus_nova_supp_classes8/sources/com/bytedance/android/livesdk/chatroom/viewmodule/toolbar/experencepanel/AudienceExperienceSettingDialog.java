package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import com.bytedance.android.live.room.api.playopt.base.LivePlayOptUtils;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.adapter.AudiencePortraitSettingAdapter;
import com.bytedance.android.livesdk.config.e0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.k4;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/experencepanel/AudienceExperienceSettingDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "a", "DivideItemDecoration", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceExperienceSettingDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int M = 0;
    public List<np1.b> B;
    public AudiencePortraitSettingAdapter<? extends np1.b> C;
    public Pair<? extends np1.c, ? extends Disposable> D;
    public np1.c E;
    public final Lazy F;
    public final Lazy G;
    public LinearLayout H;
    public RecyclerView I;
    public DataCenter J;
    public View K;
    public TextView L;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/experencepanel/AudienceExperienceSettingDialog$DivideItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DivideItemDecoration extends RecyclerView.ItemDecoration {
        public final Paint a;
        public final float b;
        public final float c;
        public final List<np1.b> d;

        public DivideItemDecoration(List<np1.b> r2) {
            Intrinsics.checkNotNullParameter(r2, "models");
            this.d = r2;
            Paint r3 = new Paint(5);
            r3.setColor(336992291);
            r3.setStyle(Paint.Style.FILL);
            Unit r0 = Unit.INSTANCE;
            this.a = r3;
            this.b = UtilityKotlinExtentionsKt.h(16);
            this.c = UtilityKotlinExtentionsKt.h(0.5f);
        }

        public final void onDraw(Canvas r9, RecyclerView r10, RecyclerView.State r11) {
            Intrinsics.checkNotNullParameter(r9, "c");
            Intrinsics.checkNotNullParameter(r10, "parent");
            Intrinsics.checkNotNullParameter(r11, "state");
            super.onDraw(r9, r10, r11);
            Lazy r12 = LivePlayOptUtils.a;
            if (TopSpeedModeUtils.a() == true) goto L17;
            int r13 = r10.getChildCount();
            int r0 = 0;
        L5:
            if (r0 >= r13) goto L22;
            View r1 = r10.getChildAt(r0);
            int r2 = r10.getChildAdapterPosition(r1);
            if (r2 == 0) goto L16;
            Object r3 = ListProtector.get(this.d, r2);
            if ((r3 instanceof np1.g) == true) goto L11;
            r3 = null;
        L11:
            np1.g r4 = (np1.g) r3;
            if (r4 != null) goto L14;
        L15:
            float r5 = r1.getTop();
            r9.drawLine(this.b, r5, r10.getMeasuredWidth() - this.b, r5 + this.c, this.a);
            goto L16
        L14:
            if (r4.e != true) goto L15;
        L16:
            r0 = r0 + 1;
            goto L5
        L22:
            return;
        }

        public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            super.getItemOffsets(r2, r3, r4, r5);
            Lazy r6 = LivePlayOptUtils.a;
            if (TopSpeedModeUtils.a() == false) goto L6;
            r2.bottom = UtilityKotlinExtentionsKt.i(8);
            return;
        }
    }

    public static final class a {
        @JvmStatic
        public static void a(Context r3, DataCenter r4) {
            if (r3 != null) goto L4;
            return;
        L4:
            if (r4 != null) goto L6;
            return;
        L6:
            Activity r0 = k4.b(r3);
            if (r0 != null) goto L9;
        L11:
            if (r0 != null) goto L13;
        L15:
            AudienceExperienceSettingDialog r1 = new AudienceExperienceSettingDialog(r3);
            r1.J = r4;
            if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L22;
            DialogLancet.handleBlockedDialogShow(r1);
            return;
        L22:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
        L19:
            DialogLancet.beforeDialogShow(r1);
            r1.show();
            DialogLancet.afterDialogShow(r1);
            return;
        L13:
            if (r0.isDestroyed() != true) goto L15;
            return;
        L9:
            if (r0.isFinishing() != true) goto L11;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565459;
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
        g r1 = (g) this.F.getValue();
        if (r1 == null) goto L20;
        r1.a.clear();
    L20:
        h r2 = (h) this.G.getValue();
        if (r2 == null) goto L23;
        r2.b.clear();
    L23:
        Pair<? extends np1.c, ? extends Disposable> r3 = this.D;
        if (r3 == null) goto L34;
        Disposable r4 = (Disposable) r3.getSecond();
        if (r4 == null) goto L35;
        r4.dispose();
        return;
    L35:
        return;
    L34:
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r5 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r5 == null) goto L16;
        com.bytedance.crash.d.d(r5, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public AudienceExperienceSettingDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, false);
        this.B = new ArrayList();
        this.F = LazyKt.lazy(AudienceExperienceSettingDialog$fluencyPlayItem$2.INSTANCE);
        this.G = LazyKt.lazy(AudienceExperienceSettingDialog$topSpeedModeItem$2.INSTANCE);
    }

    public final void onCreate(Bundle r11) {
        super.onCreate(r11);
        N0();
        TextView r0 = (TextView) findViewById(2131390084);
        if (r0 == null) goto L7;
        TextPaint r1 = r0.getPaint();
        if (r1 == null) goto L7;
        r1.setFakeBoldText(true);
    L7:
        this.H = (LinearLayout) findViewById(2131382444);
        this.K = findViewById(2131392092);
        this.L = (TextView) findViewById(2131390084);
        Pair<? extends np1.c, ? extends Disposable> r12 = com.bytedance.live.datacontext.d.a(new AudienceExperienceSettingDialog$initData$1(this));
        this.D = r12;
        if (r12 == null) goto L129;
        np1.c r13 = (np1.c) r12.getFirst();
        if (r13 == null) goto L129;
        this.E = r13;
        TextView r14 = this.L;
        np1.b r2 = null;
        if (r14 == null) goto L15;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
    L17:
        if ((r15 instanceof LinearLayout.LayoutParams) == true) goto L19;
        r15 = null;
    L19:
        LinearLayout.LayoutParams r16 = (LinearLayout.LayoutParams) r15;
        if (TopSpeedModeUtils.a() == false) goto L47;
        View r3 = this.K;
        if (r3 == null) goto L24;
        r3.setVisibility(8);
    L24:
        LinearLayout r4 = this.H;
        if (r4 == null) goto L27;
        r4.setBackgroundResource(2131249738);
    L27:
        List<np1.b> r5 = this.B;
        final h r6 = (h) this.G.getValue();
        final np1.c r7 = this.E;
        if (r7 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L30:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "panelContext");
        Intrinsics.checkNotNullParameter(r7, "panelContext");
        DataCenter r8 = r7.getDataCenter();
        if (r8 != null) goto L33;
    L39:
        boolean r9 = false;
    L40:
        if (r9 == true) goto L42;
        np1.b r10 = null;
    L43:
        if (r10 == null) goto L45;
        r5.add(r10);
    L45:
        if (r16 == null) goto L91;
        r16.setMargins(0, UtilityKotlinExtentionsKt.i(12), 0, UtilityKotlinExtentionsKt.i(22));
    L91:
        List<np1.b> r17 = this.B;
        final np1.c r18 = this.E;
        if (r18 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L94:
        Intrinsics.checkNotNullParameter(r18, "panelContext");
        int r19 = d.a;
        Intrinsics.checkNotNullParameter(r18, "panelContext");
        DataCenter r20 = r18.getDataCenter();
        if (r20 != null) goto L97;
    L101:
        boolean r21 = false;
    L102:
        if (r21 == true) goto L104;
        np1.b r22 = null;
    L105:
        if (r22 == null) goto L107;
        r17.add(r22);
    L107:
        List<np1.b> r110 = this.B;
        final c r23 = new c();
        final np1.c r24 = this.E;
        if (r24 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L110:
        Intrinsics.checkNotNullParameter(r24, "panelContext");
        Intrinsics.checkNotNullParameter(r24, "panelContext");
        if (((e0) j40.h.a.getValue()).getEnable() == false) goto L114;
        np1.b.a r25 = np1.b.a;
        Function0<np1.g> r26 = new CleanGiftCacheItem$provide$1(r24);
        Function1<np1.g, Unit> r27 = new CleanGiftCacheItem$provide$2(r23);
        r25.getClass();
        r2 = np1.b.a.a(r26, r27);
    L114:
        if (r2 == null) goto L116;
        r110.add(r2);
    L116:
        List<np1.b> r111 = this.B;
        ArrayList r28 = new ArrayList();
        Iterator<T> r112 = r111.iterator();
    L118:
        if (r112.hasNext() == false) goto L128;
        Object r29 = r112.next();
        np1.b r30 = (np1.b) r29;
        if ((r30 instanceof np1.g) == true) goto L122;
    L125:
        boolean r31 = true;
    L126:
        if (r31 == false) goto L118;
        r28.add(r29);
        goto L118
    L122:
        if (((ArrayList) ((np1.g) r30).d).isEmpty() == false) goto L125;
        r31 = false;
        goto L126
    L128:
        this.B = CollectionsKt.toMutableList(r28);
        goto L129
    L104:
        np1.b.a r32 = np1.b.a;
        Function0<np1.g> r33 = new NetworkOptItem$provide$1(r18);
        Function1<np1.g, Unit> r34 = new NetworkOptItem$provide$2(r18);
        r32.getClass();
        r22 = np1.b.a.a(r33, r34);
        goto L105
    L97:
        if (z.e(r20, false) == true) goto L101;
        if (z.m(r20, true) == false) goto L101;
        r21 = true;
        goto L102
    L42:
        np1.b.a r35 = np1.b.a;
        Function0<np1.g> r36 = new TopSpeedModeItem$provide$1(r7);
        Function1<np1.g, Unit> r37 = new TopSpeedModeItem$provide$2(r6);
        r35.getClass();
        r10 = np1.b.a.a(r36, r37);
        goto L43
    L33:
        if (z.e(r8, false) == true) goto L39;
        if (z.m(r8, true) == false) goto L39;
        if (TopSpeedModeUtils.a() == false) goto L39;
        r9 = true;
        goto L40
    L47:
        View r38 = this.K;
        if (r38 == null) goto L50;
        r38.setVisibility(0);
    L50:
        if (r16 == null) goto L52;
        r16.setMargins(0, 12, 0, 0);
    L52:
        LinearLayout r113 = this.H;
        if (r113 == null) goto L56;
        r113.setBackgroundColor(KtvUtilsKt.f(2131107299));
    L56:
        if (PlatformExpUtils.b() == false) goto L75;
        List<np1.b> r114 = this.B;
        final g r39 = (g) this.F.getValue();
        final np1.c r40 = this.E;
        if (r40 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L60:
        r39.getClass();
        Intrinsics.checkNotNullParameter(r40, "panelContext");
        Intrinsics.checkNotNullParameter(r40, "panelContext");
        DataCenter r41 = r40.getDataCenter();
        if (r41 != null) goto L63;
    L69:
        boolean r42 = false;
    L70:
        if (r42 == true) goto L72;
        np1.b r43 = null;
    L73:
        if (r43 == null) goto L91;
        r114.add(r43);
        goto L91
    L72:
        np1.b.a r44 = np1.b.a;
        Function0<np1.g> r45 = new FluencyPlayItem$provide$1(r40);
        Function1<np1.g, Unit> r46 = new FluencyPlayItem$provide$2(r39, r40);
        r44.getClass();
        r43 = np1.b.a.a(r45, r46);
        goto L73
    L63:
        if (z.e(r41, false) == true) goto L69;
        if (z.m(r41, true) == false) goto L69;
        if (PlatformExpUtils.b() == false) goto L69;
        r42 = true;
        goto L70
    L75:
        List<np1.b> r115 = this.B;
        int r47 = d.a;
        final np1.c r48 = this.E;
        if (r48 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("panelContext");
    L78:
        Intrinsics.checkNotNullParameter(r48, "panelContext");
        Intrinsics.checkNotNullParameter(r48, "panelContext");
        DataCenter r49 = r48.getDataCenter();
        if (r49 != null) goto L81;
    L85:
        boolean r50 = false;
    L86:
        if (r50 == true) goto L88;
        np1.b r51 = null;
    L89:
        if (r51 == null) goto L91;
        r115.add(r51);
        goto L91
    L88:
        np1.b.a r52 = np1.b.a;
        Function0<np1.g> r53 = new DegradeItem$provide$1(r48);
        DegradeItem$provide$2 r54 = new DegradeItem$provide$2(r48);
        r52.getClass();
        r51 = np1.b.a.a(r53, r54);
        goto L89
    L81:
        if (z.e(r49, false) == true) goto L85;
        if (z.m(r49, true) == false) goto L85;
        r50 = true;
        goto L86
    L15:
        r15 = null;
    L129:
        this.I = findViewById(2131384071);
        AudiencePortraitSettingAdapter<? extends np1.b> r116 = new AudiencePortraitSettingAdapter(this.B, TopSpeedModeUtils.a());
        this.C = r116;
        RecyclerView r55 = this.I;
        if (r55 == null) goto L132;
        r55.setAdapter(r116);
    L132:
        RecyclerView r117 = this.I;
        if (r117 == null) goto L135;
        r117.addItemDecoration(new DivideItemDecoration(this.B));
    L135:
        int r118 = com.bytedance.android.live.room.api.playopt.topspeed.log.a.a;
        LinkedHashMap r119 = new LinkedHashMap();
        r119.put("capability_status", TopSpeedModeUtils.c());
        if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.c.a).booleanValue() == false) goto L138;
        String r56 = "on";
    L139:
        r119.put("topspeed_mode_on_off", r56);
        j0.l().sendLog("livesdk_experienceopt_page_show", r119, new Object[]{x.class, Room.class});
        return;
    L138:
        r56 = "off";
        goto L139
    }
}
