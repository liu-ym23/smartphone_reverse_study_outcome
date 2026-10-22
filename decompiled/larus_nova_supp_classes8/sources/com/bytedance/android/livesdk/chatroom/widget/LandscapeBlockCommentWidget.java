package com.bytedance.android.livesdk.chatroom.widget;

import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControl;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.e3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.LandscapeBlockComment, type = PlayerViewControl.Type.BOTTOM)
@LiveVisibilityControl(key = LiveVisibilityControl.KEY.LandscapeBlockComment, type = LiveVisibilityControl.Type.BOTTOM)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/LandscapeBlockCommentWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeBlockCommentWidget extends RoomRecyclableWidget {
    public static final a b = null;
    public LottieAnimationView a;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.widget.LandscapeBlockCommentWidget$a$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC0089a implements View.OnClickListener {
            public final /* synthetic */ LottieAnimationView a;

            public ViewOnClickListenerC0089a(LottieAnimationView r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r7) {
                boolean r8 = !((Boolean) l42.a.g.getValue()).booleanValue();
                a r1 = LandscapeBlockCommentWidget.b;
                LottieAnimationView r2 = this.a;
                r1.getClass();
                a.a(r2, r8, true);
                com.bytedance.android.livesdk.log.g r3 = com.bytedance.android.livesdk.log.u.l();
                Pair[] r4 = new Pair[2];
                r4[0] = TuplesKt.to("room_orientation", "1");
                if (r8 == false) goto L5;
                String r9 = "close";
            L6:
                r4[1] = TuplesKt.to("mute_barrage_type", r9);
                Map r10 = MapsKt.mapOf(r4);
                am2.x r5 = new am2.x();
                r5.a = "live";
                r5.e = "click";
                r5.b = "live_detail";
                r3.sendLog("livesdk_landscape_mute_gift_barrage_click", r10, new Object[]{Room.class, r5});
                return;
            L5:
                r9 = "open";
                goto L6
            }
        }

        public a() {
        }

        public static void b(LottieAnimationView r4) {
            Intrinsics.checkNotNullParameter(r4, "ivLandscapeBlock");
            r4.setOnClickListener(new ViewOnClickListenerC0089a(r4));
            a(r4, ((Boolean) l42.a.g.getValue()).booleanValue(), false);
            HashMap r5 = new HashMap();
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_landscape_mute_gift_barrage_show", r5, new Object[]{new am2.x(), IRoom.class});
        }

        public static void a(LottieAnimationView r2, boolean r3, boolean r4) {
            if (r3 == false) goto L5;
            r2.setImageResource(2131252184);
            r3.c(r2, com.bytedance.android.live.core.utils.s1.B(2131914449), true);
        L6:
            if (r4 == false) goto L11;
            if (r3 == false) goto L9;
            r2.setAnimation("spilt_public_screen/barrage_media_off.json");
        L10:
            r2.playAnimation();
            goto L11
        L9:
            r2.setAnimation("spilt_public_screen/barrage_media_on.json");
        L11:
            com.bytedance.android.livesdk.sharedpref.e r5 = l42.a.g;
            Boolean r6 = Boolean.valueOf(r3);
            r5.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r5, r6);
            xs2.b.a().post(new e3(r3, "interaction_fragment", 2));
            return;
        L5:
            r2.setImageResource(2131252185);
            r3.c(r2, com.bytedance.android.live.core.utils.s1.B(2131914450), true);
            goto L6
        }
    }

    public final int getLayoutId() {
        return 2131568003;
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
    }

    static {
        b = new a();
    }

    public LandscapeBlockCommentWidget() {
    }

    public final void onLoad(Object[] r3) {
        this.a = ((Widget) this).contentView.findViewById(2131376340);
        if (isScreenLandscape() == false) goto L27;
        RoomContext r4 = getDataContext();
        if (r4 == null) goto L11;
        com.bytedance.live.datacontext.i r5 = r4.isAnchor();
        if (r5 == null) goto L11;
        boolean r1 = true;
        if (((Boolean) r5.getValue()).booleanValue() != true) goto L11;
    L12:
        RoomContext r6 = getDataContext();
        if (r6 == null) goto L17;
        com.bytedance.live.datacontext.m r7 = r6.getRoom();
        if (r7 == null) goto L17;
        Room r8 = (Room) r7.getValue();
    L19:
        if (com.bytedance.android.livesdk.utils.landscape.e.b(r1, r8) == false) goto L27;
        LottieAnimationView r9 = this.a;
        if (r9 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("ivLandscapeBlock");
    L23:
        UtilityKotlinExtentionsKt.w(r9);
        a r10 = b;
        LottieAnimationView r2 = this.a;
        if (r2 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("ivLandscapeBlock");
    L26:
        r10.getClass();
        a.b(r2);
        return;
    L17:
        r8 = null;
    L11:
        r1 = false;
    L27:
        LottieAnimationView r11 = this.a;
        if (r11 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("ivLandscapeBlock");
    L30:
        UtilityKotlinExtentionsKt.t(r11);
    }
}
