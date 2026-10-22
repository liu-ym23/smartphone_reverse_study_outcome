package com.bytedance.android.livesdk.chatroom.vs_host;

import aj1.f;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.livesdk.chatroom.end.LiveEndFragment;
import com.bytedance.android.livesdk.chatroom.end.b;
import com.bytedance.android.livesdkapi.depend.chat.OnBackPressedListener;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_host/VSEndDelegateFragment;", "Lcom/bytedance/android/livesdk/chatroom/end/LiveEndFragment;", "Lcom/bytedance/android/livesdkapi/depend/chat/OnBackPressedListener;", "Lcom/bytedance/android/livesdk/chatroom/end/b;", "<init>", "()V", "a", "vs-host_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSEndDelegateFragment extends LiveEndFragment implements OnBackPressedListener, b {
    public im1.a d;

    public static final class a {
    }

    static {
    }

    public final void T30(int r1) {
    }

    public final View W5() {
        im1.a r0 = this.d;
        if (r0 == null) goto L7;
        View r1 = r0.W5();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new View(getContext());
    }

    public final void a9() {
        im1.a r0 = this.d;
        if (r0 == null) goto L6;
        r0.a9();
        return;
    }

    public final boolean ca() {
        im1.a r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.ca() != true) goto L7;
        return true;
    }

    public final Room getCurRoom() {
        im1.a r0 = this.d;
        IRoom r1 = null;
        if (r0 == null) goto L5;
        IRoom r2 = r0.getCurRoom();
    L7:
        if ((r2 instanceof Room) == false) goto L10;
        r1 = r2;
    L10:
        Room r3 = (Room) r1;
        if (r3 == null) goto L13;
        return r3;
    L13:
        return new Room();
    L5:
        r2 = null;
        goto L7
    }

    public final boolean onBackPressed() {
        im1.a r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.onBackPressed() != true) goto L7;
        return true;
    }

    public final void onHideFragment() {
        im1.a r0 = this.d;
        if (r0 == null) goto L6;
        r0.onHideFragment();
        return;
    }

    public final void onShowFragment() {
        im1.a r0 = this.d;
        if (r0 == null) goto L6;
        r0.onHideFragment();
        return;
    }

    public VSEndDelegateFragment() {
    }

    public final void onActivityCreated(Bundle r5) {
        super/*androidx.fragment.app.Fragment*/.onActivityCreated(r5);
        im1.a r6 = this.d;
        if (r6 == null) goto L17;
        Fragment r7 = r6.self();
        if (r7 == null) goto L18;
        Bundle r0 = getArguments();
        if (r0 == null) goto L11;
        Bundle r1 = r7.getArguments();
        if (r1 == null) goto L11;
        r1.putAll(r0);
    L11:
        FragmentTransaction r2 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r7, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "VSEndFragment", 2131382432) == true) goto L15;
        r2 = r2.add(2131382432, r7, "VSEndFragment");
    L15:
        r2.commitNowAllowingStateLoss();
        return;
    L18:
        return;
    }

    public final void setDataCenter(DataCenter r2) {
        im1.a r0 = this.d;
        if (r0 == null) goto L6;
        r0.setDataCenter(r2);
        return;
    }

    public final void z3(boolean r2) {
        im1.a r0 = this.d;
        if (r0 == null) goto L6;
        r0.z3(r2);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131566082, r3, false);
    }

    public final void sw(Room r1, f r2, String r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r1, "room");
        im1.a r5 = this.d;
        if (r5 == null) goto L6;
        r5.hv(r1, r2, r4);
        return;
    }
}
