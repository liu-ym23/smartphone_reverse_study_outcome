package s40;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPlatformComponentsData;
import com.bytedance.android.livesdkapi.depend.model.live.RoomTitle;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraType;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSTitleIcon;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import nm1.m;
import pm1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends o40.a {
    public BaseTitleViewModel a;

    @Override // o40.a
    public final void a() {
    }

    @Override // o40.a
    public final void c() {
    }

    @Override // o40.a
    public final void d() {
    }

    public a() {
    }

    @Override // o40.a
    public final void e(ViewModel r2) {
        if ((r2 instanceof BaseTitleViewModel) == false) goto L6;
        this.a = (BaseTitleViewModel) r2;
        return;
    }

    public static boolean f(Room r1, DataCenter r2) {
        if (r2 != null) goto L4;
    L15:
        return false;
    L4:
        if (z.m(r2, true) != true) goto L15;
        if (r1 == null) goto L15;
        RoomPlatformComponentsData r3 = r1.roomPlatformComponentsData;
        if (r3 == null) goto L15;
        RoomTitle r4 = r3.getRoomTitle();
        if (r4 == null) goto L15;
        VSTitleIcon r5 = r4.getLeftIcon();
        if (r5 == null) goto L15;
        if (r5.isAvailable() != true) goto L15;
        return true;
    }

    @Override // o40.a
    public final void b(Room r11, DataCenter r12) {
        BaseTitleViewModel r0 = this.a;
        if (r0 == null) goto L19;
        if (r11 == null) goto L17;
        RoomPlatformComponentsData r3 = r11.roomPlatformComponentsData;
        if (r3 == null) goto L17;
        RoomTitle r4 = r3.getRoomTitle();
        if (r4 == null) goto L17;
        String r5 = r4.getIntroduction();
        if (r5 == null) goto L17;
        if (r5.length() != 0) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == true) goto L17;
        boolean r7 = true;
    L18:
        r0.isTitleIconShow(r7);
        goto L19
    L14:
        r6 = false;
    L17:
        r7 = false;
    L19:
        BaseTitleViewModel r1 = this.a;
        String r8 = null;
        if (r1 == null) goto L29;
        if (r11 == null) goto L27;
        RoomPlatformComponentsData r9 = r11.roomPlatformComponentsData;
        if (r9 == null) goto L27;
        RoomTitle r13 = r9.getRoomTitle();
        if (r13 == null) goto L27;
        VSTitleIcon r14 = r13.getLeftIcon();
    L28:
        r1.leftTitleIcon(r14);
    L27:
        r14 = null;
    L29:
        String r15 = "  |  ";
        String r16 = "";
        if (f(r11, r12) == false) goto L56;
        BaseTitleViewModel r2 = this.a;
        if (r2 == null) goto L34;
        r2.isPrefixImgShow(f(r11, r12));
    L34:
        BaseTitleViewModel r17 = this.a;
        if (r17 == null) goto L117;
        if (r11 == null) goto L42;
        RoomPlatformComponentsData r18 = r11.roomPlatformComponentsData;
        if (r18 == null) goto L42;
        RoomTitle r19 = r18.getRoomTitle();
        if (r19 == null) goto L42;
        String r21 = r19.getLeftPeriod();
    L44:
        if (TextUtils.isEmpty(r21) == true) goto L55;
        StringBuilder r22 = new StringBuilder("  |  ");
        if (r11 == null) goto L53;
        RoomPlatformComponentsData r23 = r11.roomPlatformComponentsData;
        if (r23 == null) goto L53;
        RoomTitle r24 = r23.getRoomTitle();
        if (r24 == null) goto L53;
        String r25 = r24.getLeftPeriod();
    L54:
        r22.append(r25);
        r15 = r22.toString();
    L53:
        r25 = null;
    L55:
        r17.desText(r15);
    L42:
        r21 = null;
    L117:
        if (r12 == null) goto L135;
        m r26 = f.l();
        if (r26 == null) goto L135;
        VSCameraInfo r27 = r26.K(r12);
        if (r27 == null) goto L135;
        if (r27.cameraType != VSCameraType.CAMERA_TYPE_MATCH.getValue()) goto L135;
        m r28 = f.l();
        if (r28 == null) goto L130;
        VSCameraInfo r110 = r28.K(r12);
        if (r110 == null) goto L130;
        String r111 = r110.title;
        if (r111 == null) goto L130;
    L145:
        BaseTitleViewModel r112 = this.a;
        if (r112 == null) goto L149;
        r112.titleText(r111);
        return;
    L149:
        return;
    L130:
        if (r11 == null) goto L134;
        EpisodeExtraInfo r113 = r11.getEpisodeExtra2();
        if (r113 == null) goto L134;
        r8 = r113.getTitle();
    L134:
        r111 = String.valueOf(r8);
        ALogger.d("Title", "currentTitle is " + r111 + " current cameratype is CAMERA_TYPE_MATCH");
    L135:
        if (r11 == null) goto L144;
        RoomPlatformComponentsData r114 = r11.roomPlatformComponentsData;
        if (r114 == null) goto L144;
        RoomTitle r115 = r114.getRoomTitle();
        if (r115 == null) goto L144;
        String r116 = r115.getTitle();
        if (r116 == null) goto L144;
        r16 = r116;
    L144:
        ALogger.d("Title", "currentTitle is " + r16 + " current cameratype is not CAMERA_TYPE_MATCH");
        r111 = r16;
        goto L145
    L56:
        if (r11 == null) goto L63;
        RoomPlatformComponentsData r29 = r11.roomPlatformComponentsData;
        if (r29 == null) goto L63;
        RoomTitle r31 = r29.getRoomTitle();
        if (r31 == null) goto L63;
        if (r31.getLeftTag() != RoomTitle.RoomTitleTag.RoomTitleTagVSLive.getType()) goto L63;
    L70:
        RoomPlatformComponentsData r32 = r11.roomPlatformComponentsData;
        if (r32 == null) goto L77;
        RoomTitle r33 = r32.getRoomTitle();
        if (r33 == null) goto L77;
        if (r33.getLeftTag() != RoomTitle.RoomTitleTag.RoomTitleTagVSLive.getType()) goto L77;
        String r34 = "直播";
    L88:
        BaseTitleViewModel r35 = this.a;
        if (r35 == null) goto L93;
        LiveData<Boolean> r36 = r35.isTvStatusShow();
        if (r36 == null) goto L93;
        Boolean r37 = (Boolean) r36.getValue();
    L95:
        if (Intrinsics.areEqual(r37, Boolean.TRUE) == false) goto L97;
        r15 = "";
    L97:
        BaseTitleViewModel r38 = this.a;
        if (r38 == null) goto L117;
        RoomPlatformComponentsData r39 = r11.roomPlatformComponentsData;
        if (r39 == null) goto L104;
        RoomTitle r41 = r39.getRoomTitle();
        if (r41 == null) goto L104;
        String r42 = r41.getLeftPeriod();
    L106:
        if (TextUtils.isEmpty(r42) == false) goto L108;
        String r43 = r34.concat(r15);
    L115:
        r38.desText(r43);
        goto L117
    L108:
        StringBuilder r44 = new StringBuilder();
        r44.append(r34);
        r44.append(r15);
        RoomPlatformComponentsData r45 = r11.roomPlatformComponentsData;
        if (r45 == null) goto L113;
        RoomTitle r46 = r45.getRoomTitle();
        if (r46 == null) goto L113;
        String r47 = r46.getLeftPeriod();
    L114:
        r44.append(r47);
        r43 = r44.toString();
    L113:
        r47 = null;
    L104:
        r42 = null;
    L93:
        r37 = null;
    L77:
        if (r12 != null) goto L79;
    L84:
        BaseTitleViewModel r48 = this.a;
        if (r48 == null) goto L87;
        r48.isTvStatusShow(true);
    L87:
        r34 = "";
        goto L88
    L79:
        if (z.m(r12, true) == true) goto L84;
        BaseTitleViewModel r49 = this.a;
        if (r49 == null) goto L83;
        r49.isTvStatusShow(false);
    L83:
        r34 = "首播";
    L63:
        if (r11 == null) goto L117;
        RoomPlatformComponentsData r51 = r11.roomPlatformComponentsData;
        if (r51 == null) goto L117;
        RoomTitle r52 = r51.getRoomTitle();
        if (r52 == null) goto L117;
        if (r52.getLeftTag() != RoomTitle.RoomTitleTag.RoomTitleTagVSPremiere.getType()) goto L117;
        goto L70
    }
}
