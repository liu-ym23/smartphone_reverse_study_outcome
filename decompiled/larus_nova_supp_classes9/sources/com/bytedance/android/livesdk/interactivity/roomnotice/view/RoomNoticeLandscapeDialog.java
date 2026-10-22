package com.bytedance.android.livesdk.interactivity.roomnotice.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.roomnotice.api.RoomNoticeApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import fm3.e;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/roomnotice/view/RoomNoticeLandscapeDialog;", "Lcom/bytedance/android/livesdk/interactivity/roomnotice/view/RoomNoticeBaseDialog;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomNoticeLandscapeDialog extends RoomNoticeBaseDialog {
    public static final /* synthetic */ int h = 0;
    public Map<Integer, View> g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ RoomNoticeLandscapeDialog a;
        public final /* synthetic */ String b;

        public b(RoomNoticeLandscapeDialog r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Response r4 = (Response) r3;
            f2.c("已提交, 审核通过将展示公告", 0);
            Map r5 = (Map) com.bytedance.android.livesdk.sharedpref.b.G.getValue();
            Room r0 = this.a.e;
            Intrinsics.checkNotNull(r0);
            r5.put(Long.valueOf(r0.id), this.b);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            ApiServerException r3 = (Throwable) r2;
            if ((r3 instanceof ApiServerException) == false) goto L6;
            f2.c(r3.getPrompt(), 0);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeBaseDialog
    public final void S90() {
        this.g.clear();
    }

    @Override // com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeBaseDialog
    public final String U90() {
        if (this.e != null) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        long r2 = ((Number) RoomNoticeBaseDialog.f.getFirst()).longValue();
        Room r0 = this.e;
        Intrinsics.checkNotNull(r0);
        if (r2 == r0.id) goto L13;
        Map r1 = (Map) com.bytedance.android.livesdk.sharedpref.b.G.getValue();
        Room r3 = this.e;
        Intrinsics.checkNotNull(r3);
        String r4 = (String) r1.get(Long.valueOf(r3.id));
        if (r4 != null) goto L12;
        return BuildConfig.FLAVOR;
    L12:
        return r4;
    L13:
        return (String) RoomNoticeBaseDialog.f.getSecond();
    }

    public RoomNoticeLandscapeDialog() {
        this.g = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeBaseDialog
    public final void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    @Override // com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeBaseDialog
    public final View T90(int r3) {
        if (this.g != null) goto L5;
        this.g = new LinkedHashMap();
    L5:
        View r0 = this.g.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.g.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeBaseDialog
    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        r5.addFlags(1024);
        r5.getAttributes().gravity = 8388693;
        r5.setLayout((int) e.a(r5.getContext(), 410), -2);
        r5.getAttributes().softInputMode = 16;
        return;
    L9:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r8, (TextView) T90(2131381017)) == false) goto L13;
        dismiss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r9 = DialogFragmentLancet.sLastShowStack;
        if (r9 == null) goto L42;
        d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L42:
        return;
    L13:
        if (Intrinsics.areEqual(r8, (TextView) T90(2131381024)) == false) goto L44;
        String r10 = ((EditText) T90(2131381021)).getText().toString();
        Room r0 = this.e;
        if (r0 == null) goto L38;
        Intrinsics.checkNotNull(r0);
        if (r0.id == 0) goto L38;
        if (r10.length() <= 0) goto L21;
        boolean r1 = true;
    L22:
        if (r1 == false) goto L38;
        Room r2 = this.e;
        Intrinsics.checkNotNull(r2);
        ya2.b.b(r2.getOwnerUserIdString(), "live_more");
        Map r3 = (Map) com.bytedance.android.livesdk.sharedpref.b.G.getValue();
        Room r4 = this.e;
        Intrinsics.checkNotNull(r4);
        String r5 = (String) r3.get(Long.valueOf(r4.id));
        if (r5 != null) goto L26;
        r5 = BuildConfig.FLAVOR;
    L26:
        RoomNoticeApi r6 = (RoomNoticeApi) com.bytedance.android.live.network.c.b().e(RoomNoticeApi.class);
        Room r7 = this.e;
        Intrinsics.checkNotNull(r7);
        Observable r11 = r6.notice(r7.id, r10, r5).compose(RxUtil.rxSchedulerHelper());
        if (r11 == null) goto L38;
        ObservableSubscribeProxy r13 = (ObservableSubscribeProxy) r11.as(AutoDispose.bind(getActivity()));
        if (r13 == null) goto L38;
        r13.subscribe(new b(this, r10), c.a);
        goto L38
    L21:
        r1 = false;
    L38:
        dismiss();     // Catch: Exception -> L33
        return;
    L33:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r14 = DialogFragmentLancet.sLastShowStack;
        if (r14 == null) goto L45;
        d.d(r14, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L45:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeBaseDialog
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ((TextView) T90(2131381024)).setText("提交");
        ((LinearLayout) T90(2131381019)).setBackgroundResource(2131248934);
    }

    @Override // com.bytedance.android.livesdk.interactivity.roomnotice.view.RoomNoticeBaseDialog
    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        View r7 = super.onCreateView(r4, r5, r6);
        if (r7 == null) goto L5;
        r7.setPadding(r7.getPaddingLeft(), r7.getPaddingTop(), (int) e.a(s1.getContext(), 34.0f), (int) e.a(s1.getContext(), 20.0f));
    L5:
        return r7;
    }
}
