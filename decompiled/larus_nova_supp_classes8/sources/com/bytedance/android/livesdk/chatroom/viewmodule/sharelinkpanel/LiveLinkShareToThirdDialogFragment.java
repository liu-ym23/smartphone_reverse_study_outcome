package com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel;

import am2.x;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.livehostapi.business.depend.share.ICommonLiveSharePackage;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/sharelinkpanel/LiveLinkShareToThirdDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLinkShareToThirdDialogFragment extends LiveDialogFragment {
    public static final /* synthetic */ int n = 0;
    public ICommonLiveSharePackage d;
    public View e;
    public ImageView f;
    public View g;
    public RecyclerView h;
    public final CopiedLinkToThirdAppAdapter i;
    public ViewGroup j;
    public View k;
    public boolean l;
    public Disposable m;

    public static final class a {
    }

    static {
    }

    public LiveLinkShareToThirdDialogFragment() {
        this.i = new CopiedLinkToThirdAppAdapter();
        ILiveShareService r0 = jc1.k.f(ILiveShareService.class);
        if (r0 == null) goto L5;
        boolean r1 = r0.canBeFoundByShare();
    L6:
        this.l = r1;
        return;
    L5:
        r1 = true;
        goto L6
    }

    public static View S90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void U90(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super.onDismiss(r2);
        ILiveShareService r3 = jc1.k.f(ILiveShareService.class);
        if (r3 != null) goto L5;
    L10:
        Disposable r4 = this.m;
        if (r4 == null) goto L14;
        r4.dispose();
        return;
    L14:
        return;
    L5:
        if (r3.canBeFoundByShare() == this.l) goto L10;
        ILiveShareService r5 = jc1.k.f(ILiveShareService.class);
        if (r5 == null) goto L10;
        r5.changeCanBeFoundByShare(this.l);
        goto L10
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        Intrinsics.checkNotNullParameter(r5, LiveEndPageData.TAG_WINDOW);
        r5.clearFlags(67108864);
        r5.addFlags(Integer.MIN_VALUE);
        int r0 = S90(r5).getSystemUiVisibility();
        S90(r5).setSystemUiVisibility(r0 | 1280);
        r5.setStatusBarColor(0);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (isVertical() == false) goto L5;
        int r3 = 2131954579;
    L6:
        setStyle(1, r3);
        return;
    L5:
        r3 = 2131954852;
        goto L6
    }

    public final void onDismiss(DialogInterface r2) {
        U90(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public static final void T90(LiveLinkShareToThirdDialogFragment r3, String r4) {
        r3.getClass();
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("element_name", r4);
        r5.put("enter_from", "more_function");
        r5.put("event_page", "live_detail");
        r5.put("module_name", "share_panel");
        u.l().sendLog("livesdk_share_panel_element_click", r5, new Object[]{x.class, Room.class});
    }

    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        this.k = r11.findViewById(2131384840);
        r11.post(new j(this));
        View r13 = r11.findViewById(2131386100);
        this.e = r13;
        if (r13 == null) goto L5;
        r13.setOnClickListener(new k(this));
    L5:
        this.f = (ImageView) r11.findViewById(2131386104);
        View r14 = r11.findViewById(2131386103);
        this.g = r14;
        if (r14 == null) goto L8;
        r14.setOnClickListener(new g(this));
    L8:
        ImageView r15 = this.f;
        if (r15 == null) goto L11;
        r15.setSelected(this.l);
    L11:
        RecyclerView r16 = r11.findViewById(2131386106);
        this.h = r16;
        if (r16 == null) goto L14;
        r16.setLayoutManager(new LinearLayoutManager(r11.getContext(), 0, false));
    L14:
        RecyclerView r17 = this.h;
        if (r17 == null) goto L17;
        r17.setAdapter(this.i);
    L17:
        this.i.b = new LiveLinkShareToThirdDialogFragment$initRecyclerView$1(this);
        RecyclerView r18 = this.h;
        if (r18 == null) goto L20;
        r18.addItemDecoration(new LiveLinkShareToThirdDialogFragment$initRecyclerView$2());
    L20:
        Context r19 = getContext();
        if (r19 != null) goto L24;
        r19 = jc1.a.b();
    L24:
        if (r19 != null) goto L26;
        List r110 = CollectionsKt.emptyList();
    L36:
        List r3 = r110;
        if ((!r3.isEmpty()) == false) goto L39;
        CopiedLinkToThirdAppAdapter r4 = this.i;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r110, "list");
        r4.a = new ArrayList(r3);
        this.i.notifyDataSetChanged();
    L39:
        this.j = (ViewGroup) r11.findViewById(2131386102);
        FragmentActivity r5 = getActivity();
        ViewGroup r6 = this.j;
        Dialog r111 = getDialog();
        if (r5 == null) goto L58;
        if (r6 == null) goto L58;
        if (r111 == null) goto L58;
        ILiveShareService r7 = jc1.k.f(ILiveShareService.class);
        if (r7 == null) goto L46;
        Disposable r112 = r7.initVSPoster(r5, r6, r111, this, this.d, new h(this));
    L47:
        if (r112 == null) goto L58;
        this.m = r112;
        ViewGroup r113 = this.j;
        if (r113 == null) goto L51;
        UtilityKotlinExtentionsKt.w(r113);
    L51:
        View r114 = this.k;
        if (r114 == null) goto L54;
        a1.k(r114, -1);
    L54:
        View r115 = r111.findViewById(2131389519);
        if (r115 == null) goto L57;
        a1.k(r115, -1);
    L57:
        setBottomSheetSlideProcessor(i.a);
        goto L58
    L46:
        r112 = null;
    L58:
        LinkedHashMap r116 = new LinkedHashMap();
        r116.put("enter_from", "more_function");
        r116.put("event_page", "live_detail");
        r116.put("module_name", "share_panel");
        u.l().sendLog("livesdk_share_panel_module_show", r116, new Object[]{x.class, Room.class});
        return;
    L26:
        List r8 = CollectionsKt.listOf(new l[]{new c(), new d(), new com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel.a(), new b(), new e()});
        ArrayList r9 = new ArrayList();
        Iterator r10 = r8.iterator();
    L28:
        if (r10.hasNext() == false) goto L32;
        Object r20 = r10.next();
        if (((l) r20).a(r19) == false) goto L28;
        r9.add(r20);
        goto L28
    L32:
        List r21 = CollectionsKt.toMutableList(r9);
        if (r21.isEmpty() == false) goto L35;
        f r22 = new f();
        Intrinsics.checkNotNullParameter(r19, "context");
        r21.add(r22);
    L35:
        r110 = r21;
        goto L36
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131567452, r3, false);
    }
}
