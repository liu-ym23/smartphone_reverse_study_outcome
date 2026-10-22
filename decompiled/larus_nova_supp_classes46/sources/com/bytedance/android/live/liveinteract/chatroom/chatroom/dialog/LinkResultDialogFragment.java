package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.banner.BannerWidget;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.model.u1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/LinkResultDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkResultDialogFragment extends LiveDialogFragment {
    public static final String k = null;
    public static final a l = null;
    public Map<Integer, View> d;
    public final CompositeDisposable e;
    public long f;
    public long g;
    public long h;
    public String i;
    public BannerWidget.a j;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static LinkResultDialogFragment a(g1 r7, BannerWidget.a r8) {
            Intrinsics.checkNotNullParameter(r7, "leaveChannelRsp");
            String r0 = LinkResultDialogFragment.k;
            StringCompanionObject r1 = StringCompanionObject.INSTANCE;
            ALogger.d(r0, String.format("newInstance, leaveChannelRsp: %s", Arrays.copyOf(new Object[]{r7}, 1)));
            LinkResultDialogFragment r2 = new LinkResultDialogFragment();
            Bundle r3 = new Bundle();
            r3.putLong("KEY_LINK_DURATION", r7.getLink_duration());
            u1 r4 = r7.getUserInfoDuringLinkmic();
            long r5 = 0;
            if (r4 == null) goto L5;
            long r6 = r4.getAddFollowerCount();
        L6:
            r3.putLong("KEY_ADD_FOLLOWER_COUNT", r6);
            u1 r9 = r7.getUserInfoDuringLinkmic();
            if (r9 == null) goto L9;
            r5 = r9.getScoreBeyond();
        L9:
            r3.putLong("KEY_SCORE_BEYOND", r5);
            u1 r10 = r7.getUserInfoDuringLinkmic();
            if (r10 == null) goto L13;
            String r11 = r10.getFanTicket();
            if (r11 == null) goto L13;
        L14:
            r3.putString("KEY_FAN_TICKET", r11);
            r2.setArguments(r3);
            r2.j = r8;
            return r2;
        L13:
            r11 = "0";
            goto L14
        L5:
            r6 = 0;
            goto L6
        }
    }

    static {
        l = new a();
        k = "LinkResultDialogFragment";
    }

    public LinkResultDialogFragment() {
        this.d = new LinkedHashMap();
        this.e = new CompositeDisposable();
        this.i = "0";
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.e.clear();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        Dialog r6 = getDialog();
        if (r6 == null) goto L13;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L14;
        View r0 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L11:
        r0.setPadding(0, 0, 0, 0);
        r7.setLayout(-1, -1);
        r7.setGravity(80);
        r7.setBackgroundDrawable(new ColorDrawable(0));
        r7.setSoftInputMode(48);
        c1.b(r7, 0, 14);
        return;
    L14:
        return;
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        setStyle(1, 2131954719);
        Bundle r6 = getArguments();
        long r0 = 0;
        if (r6 == null) goto L5;
        long r2 = r6.getLong("KEY_LINK_DURATION", 0);
    L6:
        this.f = r2;
        Bundle r7 = getArguments();
        if (r7 == null) goto L9;
        long r3 = r7.getLong("KEY_ADD_FOLLOWER_COUNT", 0);
    L10:
        this.g = r3;
        Bundle r8 = getArguments();
        if (r8 == null) goto L13;
        r0 = r8.getLong("KEY_SCORE_BEYOND", 0);
    L13:
        this.h = r0;
        Bundle r9 = getArguments();
        if (r9 == null) goto L17;
        String r10 = r9.getString("KEY_FAN_TICKET", "0");
        if (r10 == null) goto L17;
    L18:
        this.i = r10;
        if (TextUtils.isEmpty(r10) == false) goto L22;
        this.i = "0";
        return;
    L22:
        return;
    L17:
        r10 = "0";
        goto L18
    L9:
        r3 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super.onViewCreated(r12, r13);
        WidgetManager r14 = WidgetManager.of(this, getView());
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L5;
        IRoom r1 = (IRoom) r0.getValue();
    L6:
        r14.load(2131372686, new BannerWidget(r1, 25, "chat_effect_feedback_panel", S90(2131391602), this.j));
        int r2 = 0;
        if (this.g <= 0) goto L9;
    L11:
        SpannableStringBuilder r15 = new SpannableStringBuilder();
        String r16 = s1.B(2131918737);
        String r5 = s1.B(2131918736);
        StringCompanionObject r6 = StringCompanionObject.INSTANCE;
        String r7 = String.format("%s%%", Arrays.copyOf(new Object[]{String.valueOf(this.h)}, 1));
        r15.append(r16).append(r7).append(r5);
        r15.setSpan(new ForegroundColorSpan(s1.h(2131107749)), r16.length(), r16.length() + r7.length(), 17);
        ((TextView) S90(2131391605)).setText(r15);
    L12:
        long r8 = 60;
        if (this.f >= r8) goto L15;
        ((TextView) S90(2131390876)).setText(String.valueOf(this.f));
        ((TextView) S90(2131390875)).setText(2131918732);
    L19:
        ((TextView) S90(2131390601)).setText(this.i);
        ((TextView) S90(2131390110)).setText(String.valueOf(this.g));
        ((TextView) S90(2131390608)).setOnClickListener(new q(this));
        RxUtilKt.c(xs2.b.a().b(hk0.b.class).subscribe(new o(this), p.a), this.e);
        return;
    L15:
        TextView r17 = (TextView) S90(2131390876);
        long r9 = this.f;
        long r10 = r9 / r8;
        if ((r9 % r8) <= 0) goto L18;
        r2 = 1;
    L18:
        r17.setText(String.valueOf(r10 + ((long) r2)));
        ((TextView) S90(2131390875)).setText(2131918731);
        goto L19
    L9:
        if (TextUtils.equals(this.i, "0") == false) goto L11;
        ((TextView) S90(2131391605)).setText(s1.B(2131918735));
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return LayoutInflater.from(getContext()).inflate(2131565588, r3, false);
    }
}
