package com.bytedance.android.livesdk.drawer;

import am2.x;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.BaseDialogFragment;
import com.bytedance.android.live.ui.CenterScrollLayoutManager;
import com.bytedance.android.live.ui.FadingEdgeRecyclerview;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.viewmodel.DrawCleanScreenViewModel;
import com.bytedance.android.livesdk.viewmodel.MergeDrawerViewModel;
import com.bytedance.android.livesdk.viewmodel.h;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.VerticalTypeInfo;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ut1.j;
import ut1.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/LiveMergeDrawerDialog;", "Lcom/bytedance/android/live/core/widget/BaseDialogFragment;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMergeDrawerDialog extends BaseDialogFragment {
    public static final /* synthetic */ int n = 0;
    public View d;
    public DataCenter e;
    public FadingEdgeRecyclerview f;
    public LiveMergeDrawerAdapter g;
    public TextView h;
    public ImageView i;
    public Room j;
    public MergeDrawerViewModel k;
    public DrawCleanScreenViewModel l;
    public final float m;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ LiveMergeDrawerDialog a;

        public b(LiveMergeDrawerDialog r1) {
            this.a = r1;
        }

        public final void onChanged(Object r12) {
            h r13 = (h) r12;
            LiveMergeDrawerAdapter r0 = this.a.g;
            if (r0 == null) goto L87;
            Integer r1 = null;
            if (r13 == null) goto L7;
            List r2 = r13.a;
        L8:
            if (r13 == null) goto L10;
            Integer r3 = Integer.valueOf(r13.b);
        L11:
            if (r13 == null) goto L13;
            Boolean r14 = Boolean.valueOf(r13.c);
        L14:
            if (r2 == null) goto L92;
            if (r3 == null) goto L88;
            r3.intValue();
            if (((ArrayList) r0.a).size() < r2.size()) goto L21;
            return;
        L21:
            if (Intrinsics.areEqual(r14, Boolean.TRUE) == true) goto L27;
            List<Room> r4 = r0.a;
            if (r4 == null) goto L26;
            r1 = Integer.valueOf(((ArrayList) r4).size());
        L26:
            if (r1.intValue() == 0) goto L27;
        L28:
            ArrayList r5 = new ArrayList();
            r5.addAll(r2);
            long r6 = ((Room) ListProtector.get(r5, 0)).getRoomId();
            MergeDrawerViewModel r7 = r0.h;
            if (r7 == null) goto L38;
            Room r8 = r7.getFirstEnterRoom();
            if (r8 == null) goto L38;
            if (r6 != r8.getRoomId()) goto L38;
            Room r9 = r0.h.getFirstEnterRoom();
            if (r9 != null) goto L37;
            r9 = (Room) ListProtector.get(r5, 0);
        L37:
            ListProtector.set(r5, 0, r9);
        L38:
            int r10 = ((ArrayList) r0.a).size();
            if (((ArrayList) r0.a).size() == 0) goto L54;
            List<Room> r11 = r0.a;
            if (((Room) ListProtector.get(r11, ((ArrayList) r11).size() - 1)).id != ((Room) ListProtector.get(r5, ((ArrayList) r0.a).size() - 1)).id) goto L54;
            List r15 = r5.subList(((ArrayList) r0.a).size(), r5.size());
            ArrayList r16 = new ArrayList();
            Iterator<T> r17 = r15.iterator();
        L44:
            if (r17.hasNext() == false) goto L49;
            T r18 = r17.next();
            if (((Room) r18).withAggregateColumn == false) goto L44;
            r16.add(r18);
            goto L44
        L49:
            if (CollectionUtils.isEmpty(r16) == true) goto L64;
            MergeDrawerViewModel r19 = r0.h;
            if (r19 == null) goto L53;
            r19.setPulling(false);
        L53:
            ((ArrayList) r0.a).addAll(r16);
            r0.notifyItemRangeInserted(r10, ((ArrayList) r0.a).size() - r10);
        L64:
            Boolean r20 = Boolean.TRUE;
            if (Intrinsics.areEqual(r14, r20) == false) goto L70;
            if (r3.intValue() == 0) goto L70;
            i0.c().postDelayed(new p(r0, r3), 50);
        L70:
            if (r0.g.findLastVisibleItemPosition() < (r0.getItemCount() - 3)) goto L89;
            MergeDrawerViewModel r110 = r0.h;
            if (r110 != null) goto L74;
            return;
        L74:
            if (r110.isMergePull() != true) goto L91;
            r0.h.getLoadMore().setValue(r20);
            r0.h.setPulling(true);
            return;
        L91:
            return;
        L89:
            return;
        L54:
            ((ArrayList) r0.a).clear();
            MergeDrawerViewModel r21 = r0.h;
            if (r21 == null) goto L57;
            r21.setPulling(false);
        L57:
            ALogger.i("LiveMergeDrawerAdapter", "updateData&notifyDataSetChanged()");
            List<Room> r22 = r0.a;
            ArrayList r23 = new ArrayList();
            Iterator r24 = r5.iterator();
        L59:
            if (r24.hasNext() == false) goto L63;
            Object r25 = r24.next();
            if (((Room) r25).withAggregateColumn == false) goto L59;
            r23.add(r25);
            goto L59
        L63:
            ((ArrayList) r22).addAll(r23);
            r0.notifyDataSetChanged();
        L27:
            r0.b = r3.intValue();
            goto L28
        L88:
            return;
        L92:
            return;
        L13:
            r14 = null;
            goto L14
        L10:
            r3 = null;
            goto L11
        L7:
            r2 = null;
            goto L8
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LiveMergeDrawerDialog a;

        public c(LiveMergeDrawerDialog r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveMergeDrawerDialog r0 = this.a;     // Catch: Throwable -> L10
            LiveMergeDrawerAdapter r1 = r0.g;     // Catch: Throwable -> L10
            if (r1 == null) goto L13;
            FadingEdgeRecyclerview r2 = r0.f;     // Catch: Throwable -> L10
            if (r2 == null) goto L7;
            int r3 = r2.getHeight();     // Catch: Throwable -> L10
        L8:
            r1.e = r3;     // Catch: Throwable -> L10
            return;
        L7:
            r3 = 0;
            goto L8
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ LiveMergeDrawerDialog a;

        public d(LiveMergeDrawerDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            this.a.dismiss();     // Catch: Exception -> L5
        L9:
            LiveMergeDrawerDialog r6 = this.a;
            int r0 = LiveMergeDrawerDialog.n;
            r6.getClass();
            FragmentActivity r7 = this.a.getActivity();
            Bundle r1 = new Bundle();
            r1.putBoolean("drawer_feed", true);
            r1.putString("pull_type", "button");
            Unit r2 = Unit.INSTANCE;
            j.g(r7, true, r1, this.a.e, 16);
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r8 = DialogFragmentLancet.sLastShowStack;
            if (r8 == null) goto L9;
            com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }
    }

    static {
    }

    public LiveMergeDrawerDialog() {
        this.m = 112.0f;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        MergeDrawerViewModel r0 = this.k;
        if (r0 == null) goto L5;
        r0.setClick(false);
    L5:
        MergeDrawerViewModel r1 = this.k;
        if (r1 == null) goto L8;
        r1.setDialogOpen(false);
    L8:
        DrawCleanScreenViewModel r2 = this.l;
        if (r2 == null) goto L11;
        r2.clearCleanMode();
    L11:
        LiveMergeDrawerAdapter r3 = this.g;
        if (r3 == null) goto L15;
        ((ArrayList) r3.a).clear();
        r3.f.clearOnScrollListeners();
        return;
    }

    public final void onActivityCreated(Bundle r6) {
        super/*androidx.fragment.app.DialogFragment*/.onActivityCreated(r6);
        Dialog r7 = getDialog();
        WindowManager.LayoutParams r0 = null;
        if (r7 == null) goto L5;
        Window r8 = r7.getWindow();
    L6:
        if (r8 == null) goto L14;
        View r1 = r8.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L12;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L12;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L12:
        if (r1 == null) goto L14;
        r1.setPadding(0, 0, 0, 0);
    L14:
        if (r8 == null) goto L16;
        r0 = r8.getAttributes();
    L16:
        if (r0 == null) goto L18;
        r0.width = s1.f(this.m);
    L18:
        if (r0 == null) goto L20;
        r0.height = -1;
    L20:
        if (r0 == null) goto L22;
        r0.gravity = 5;
    L22:
        if (r8 == null) goto L25;
        r8.setAttributes(r0);
        return;
    L25:
        return;
    L5:
        r8 = null;
        goto L6
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        setStyle(0, 2131954721);
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, this.e, 0, 2);
        if (r6 == null) goto L7;
        m r7 = r6.getRoom();
        if (r7 == null) goto L7;
        Room r8 = (Room) r7.getValue();
    L8:
        this.j = r8;
        FragmentActivity r9 = getActivity();
        if (r9 == null) goto L16;
        this.k = ViewModelProviders.of(r9).get(MergeDrawerViewModel.class);
        this.l = ViewModelProviders.of(r9).get(DrawCleanScreenViewModel.class);
        MergeDrawerViewModel r0 = this.k;
        if (r0 == null) goto L17;
        MutableLiveData r1 = r0.getUpdataRoom();
        if (r1 == null) goto L18;
        r1.observe(r9, new b(this));
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L7:
        r8 = null;
        goto L8
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        View r12 = this.d;
        String r13 = null;
        if (r12 == null) goto L5;
        FadingEdgeRecyclerview r14 = (FadingEdgeRecyclerview) r12.findViewById(2131379947);
    L6:
        this.f = r14;
        View r15 = this.d;
        if (r15 == null) goto L9;
        TextView r16 = (TextView) r15.findViewById(2131379940);
    L10:
        this.h = r16;
        View r17 = this.d;
        if (r17 == null) goto L13;
        ImageView r18 = (ImageView) r17.findViewById(2131379939);
    L14:
        this.i = r18;
        Context r19 = getContext();
        if (r19 == null) goto L22;
        FadingEdgeRecyclerview r1 = this.f;
        if (r1 == null) goto L22;
        CenterScrollLayoutManager r2 = new CenterScrollLayoutManager(r19);
        r2.setOrientation(1);
        this.g = new LiveMergeDrawerAdapter(r1, r2, this.k);
        Unit r110 = Unit.INSTANCE;
        r1.setLayoutManager(r2);
        r1.setAdapter(this.g);
        r1.setHasFixedSize(true);
        if (r1.a != null) goto L21;
        r1.a = new kn2.m(new ln2.c(r1));
        r1.setOnTouchListener(null);
    L21:
        r1.post(new c(this));
    L22:
        final LiveMergeDrawerAdapter r111 = this.g;
        if (r111 == null) goto L25;
        r111.f.addOnScrollListener(new LiveMergeDrawerAdapter$setOnScrollListener$1(r111));
    L25:
        MergeDrawerViewModel r112 = this.k;
        if (r112 == null) goto L30;
        MutableLiveData r113 = r112.getLoadMore();
        if (r113 == null) goto L30;
        r113.setValue(Boolean.FALSE);
    L30:
        MergeDrawerViewModel r114 = this.k;
        if (r114 == null) goto L33;
        r114.setDialogOpen(true);
    L33:
        int r115 = gs1.a.a;
        DataCenter r116 = this.e;
        if (r116 == null) goto L36;
        String r117 = a0.p(r116);
    L37:
        com.bytedance.android.livesdk.clearscreen.h r118 = gs1.a.a(r117);
        if (r118 == null) goto L40;
        DrawCleanScreenViewModel.a r3 = DrawCleanScreenViewModel.Companion;
        DrawCleanScreenViewModel r4 = this.l;
        r3.getClass();
        r118.b(new DrawCleanScreenViewModel.b(r4));
    L40:
        DrawCleanScreenViewModel r119 = this.l;
        if (r119 == null) goto L43;
        r119.enterCleanMode();
    L43:
        o r120 = u.l().c(x.class);
        String r5 = "";
        if (r120 == null) goto L49;
        Map r6 = r120.getMap();
        if (r6 == null) goto L49;
        String r7 = (String) r6.get("enter_from_merge");
        if (r7 == null) goto L49;
    L51:
        if (r120 == null) goto L56;
        Map r121 = r120.getMap();
        if (r121 == null) goto L56;
        String r122 = (String) r121.get("enter_method");
        if (r122 == null) goto L56;
    L57:
        g r8 = u.l();
        HashMap r9 = new HashMap();
        Room r20 = this.j;
        if (r20 == null) goto L63;
        User r21 = r20.getOwner();
        if (r21 == null) goto L63;
        String r22 = r21.getIdString();
        if (r22 == null) goto L63;
    L64:
        r9.put("anchor_id", r22);
        MergeDrawerViewModel r23 = this.k;
        if (r23 != null) goto L67;
    L69:
        Room r24 = this.j;
        if (r24 == null) goto L73;
        String r25 = r24.getIdStr();
        if (r25 == null) goto L73;
    L74:
        r9.put("room_id", r25);
        r9.put("enter_from_merge", r7);
        r9.put("enter_method", r122);
        MergeDrawerViewModel r123 = this.k;
        if (r123 != null) goto L77;
    L79:
        String r124 = "pull";
    L80:
        r9.put("action_type", r124);
        Room r125 = this.j;
        if (r125 == null) goto L85;
        String r126 = r125.getRequestId();
        if (r126 == null) goto L85;
        r5 = r126;
    L85:
        r9.put("request_id", r5);
        Room r127 = this.j;
        if (r127 == null) goto L89;
        String r128 = r127.getLog_pb();
        if (r128 == null) goto L89;
    L90:
        r9.put("log_pb", r128);
        Unit r129 = Unit.INSTANCE;
        r8.sendLog("livesdk_aggregate_bar_click", r9, new Object[0]);
        TextView r0 = this.h;
        if (r0 == null) goto L98;
        Room r26 = this.j;
        if (r26 == null) goto L97;
        VerticalTypeInfo r27 = r26.mVerticalTypeInfo;
        if (r27 == null) goto L97;
        r13 = r27.name;
    L97:
        r0.setText(r13);
    L98:
        ALogger.i("ClearScreenManager", "addClearAssistant LiveMergeDrawerDialog #onViewCreated方法 100");
        ImageView r130 = this.i;
        if (r130 == null) goto L101;
        r130.setVisibility(0);
    L101:
        ImageView r131 = this.i;
        if (r131 == null) goto L105;
        r131.setOnClickListener(new d(this));
        return;
    L105:
        return;
    L89:
        r128 = r9.toString();
        goto L90
    L77:
        if (r123.isClick() != true) goto L79;
        r124 = "click";
    L73:
        r25 = "";
        goto L74
    L67:
        if (r23.isSimilarRoom() != true) goto L69;
        r9.put("entrance", "similar_live");
    L63:
        r22 = "";
    L56:
        r122 = "";
    L49:
        r7 = "";
        goto L51
    L36:
        r117 = null;
        goto L37
    L13:
        r18 = null;
        goto L14
    L9:
        r16 = null;
        goto L10
    L5:
        r14 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131565640, r3, false);
        this.d = r5;
        return r5;
    }
}
