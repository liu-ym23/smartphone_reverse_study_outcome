package com.bytedance.android.live.room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.network.response.EnterRoomInfoResult;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.EnterRoomExtra;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.message.model.kj;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import hh1.v0;
import hh1.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface h extends gs0.d {
    public static final String I0 = null;

    public interface a {
        void a();
    }

    public static abstract class b {
        public b() {
        }

        public abstract void a(kj r1);

        public abstract void b(int r1);
    }

    void C60();

    void Cp(v0 r1);

    void Cz(nz.r r1);

    void D2(boolean r1);

    void DS();

    void F30(Room r1, EnterRoomExtra r2, w r3);

    void I5();

    View IP();

    void Oz(PadOrientation r1);

    void P7(Room r1, w r2);

    void R40(w0 r1);

    void R5();

    void RJ(Runnable r1);

    void Sb(View.OnTouchListener r1);

    void T4(Room r1, w r2);

    boolean V9();

    void VX(DataCenter r1, b r2, EnterRoomExtra r3);

    void b0(String r1);

    void bW(Room r1, EnterRoomExtra r2, Runnable r3);

    void cU(a r1);

    void cx(DialogInterface.OnKeyListener r1);

    void eR(LiveMode r1);

    View ff();

    boolean g1();

    FragmentManager getChildFragmentManager();

    boolean interceptCloseRoom(Runnable r1, boolean r2);

    boolean isAdded();

    boolean isScreenPortrait();

    void lO(com.bytedance.android.live.pushstream.d r1);

    void n9(Room r1, w r2);

    void ns();

    boolean o5();

    void onActivityResult(int r1, int r2, Intent r3);

    void onOuterPageScrollStateChanged(int r1);

    void onPageScrollStateChanged(int r1);

    boolean pX();

    Fragment self();

    void setArguments(Bundle r1);

    void setDataContext(RoomContext r1);

    void setNestedOutside(boolean r1);

    void show(FragmentManager r1, String r2);

    void stopInteractionLoad();

    void yv();

    void zA(EnterRoomInfoResult r1);

    static {
        String r0 = LiveCommonConstants.IInteractionFragment_TAG;
        I0 = "AbsInteractionFragment";
    }
}
