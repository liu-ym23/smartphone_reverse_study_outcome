package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.landscape.LandscapePhoneInfoShowUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import zg1.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapePositionSizeControllerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapePositionSizeControllerWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public Room a;
    public boolean b;
    public final View c;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LandscapePositionSizeControllerWidget a;

        public b(LandscapePositionSizeControllerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r12) {
            i1 r13 = (i1) r12;
            LandscapePositionSizeControllerWidget r0 = this.a;
            boolean r1 = r0.b;
            Room r2 = r0.a;
            if (r2 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("room");
        L6:
            if (com.bytedance.android.livesdk.utils.landscape.e.b(r1, r2) == false) goto L48;
            ViewGroup.LayoutParams r6 = null;
            if (r13.b == true) goto L23;
            UIUtils.updateLayout(r0.c.findViewById(2131387103), s1.j(2131168866), -1);
            View r14 = r0.c.findViewById(2131387102);
            if (r14 == null) goto L12;
            ViewGroup.LayoutParams r3 = r14.getLayoutParams();
        L14:
            if ((r3 instanceof LinearLayout.LayoutParams) == false) goto L17;
            r6 = r3;
        L17:
            LinearLayout.LayoutParams r7 = (LinearLayout.LayoutParams) r6;
            if (r7 == null) goto L20;
            r7.height = 0;
            r7.weight = 1.0f;
            r14.setLayoutParams(r7);
        L20:
            View r15 = r0.c.findViewById(2131387100);
            if (r15 == null) goto L49;
            UtilityKotlinExtentionsKt.w(r15);
            return;
        L49:
            return;
        L12:
            r3 = null;
            goto L14
        L23:
            int r4 = s1.w() - (r13.a + s1.f(48.0f));
            Pair r16 = (Pair) ((Widget) r0).dataCenter.get("data_video_size_pair", new Pair(0, 0));
            if (((Number) r16.getFirst()).intValue() > 0) goto L26;
        L32:
            UIUtils.updateLayout(r0.c.findViewById(2131387103), s1.f(498.0f), -1);
        L33:
            View r17 = r0.c.findViewById(2131387102);
            if (r17 == null) goto L36;
            ViewGroup.LayoutParams r5 = r17.getLayoutParams();
        L38:
            if ((r5 instanceof LinearLayout.LayoutParams) == false) goto L41;
            r6 = r5;
        L41:
            LinearLayout.LayoutParams r8 = (LinearLayout.LayoutParams) r6;
            if (r8 == null) goto L44;
            r8.height = r4 - UtilityKotlinExtentionsKt.i(24);
            r8.weight = 0.0f;
            r17.setLayoutParams(r8);
        L44:
            View r18 = r0.c.findViewById(2131387100);
            if (r18 == null) goto L51;
            UtilityKotlinExtentionsKt.t(r18);
            return;
        L51:
            return;
        L36:
            r5 = null;
            goto L38
        L26:
            if (((Number) r16.getSecond()).intValue() <= 0) goto L32;
            int r9 = s1.y() - ((int) (r4 * (((Number) r16.getFirst()).intValue() / ((Number) r16.getSecond()).intValue())));
            if (DigHoleScreenUtil.isNeedStatusBarAdapt(((Widget) r0).context, false, false) == false) goto L31;
            r9 = r9 - s1.A();
        L31:
            UIUtils.updateLayout(r0.c.findViewById(2131387103), r9, -1);
            goto L33
        }
    }

    static {
    }

    public final String getSpm() {
        return "a100.a100.a274";
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L6;
        r0.removeObserver(this);
        return;
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
    }

    public LandscapePositionSizeControllerWidget(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        this.c = r2;
    }

    public final void onChanged(Object r2) {
        KVData r3 = (KVData) r2;
        if (isViewValid() == false) goto L7;
        if (r3 == null) goto L8;
        r3.getKey();
        return;
    L8:
        return;
    }

    public final void onLoad(Object[] r4) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L37;
        Room r6 = (Room) r5.get("data_room");
        if (r6 == null) goto L38;
        this.a = r6;
        DataCenter r7 = ((Widget) this).dataCenter;
        boolean r0 = false;
        if (r7 == null) goto L12;
        Boolean r8 = (Boolean) r7.get("data_is_anchor");
        if (r8 == null) goto L12;
        boolean r9 = r8.booleanValue();
    L13:
        this.b = r9;
        if (r9 == true) goto L31;
        Room r10 = this.a;
        if (r10 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L19:
        if (r10.isMediaRoom() == true) goto L27;
        Room r11 = this.a;
        if (r11 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L24:
        if (r11.isMergeVSRoom() == true) goto L27;
        boolean r12 = false;
    L29:
        if (LandscapePhoneInfoShowUtils.a(Boolean.valueOf(r12)) == false) goto L31;
        r0 = true;
    L27:
        r12 = true;
    L31:
        View r13 = this.c.findViewById(2131378727);
        if (r0 == false) goto L34;
        int r1 = 65;
    L35:
        UIUtils.updateLayoutMargin(r13, -3, UtilityKotlinExtentionsKt.i(r1), -3, -3);
        b r2 = new b(this);
        ((ObservableSubscribeProxy) xs2.b.a().b(i1.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r2);
        return;
    L34:
        r1 = 53;
    L12:
        r9 = false;
        goto L13
    L38:
        return;
    }
}
