package ew1;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.CameraMatchInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.MainCameraMatchInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import nm1.v;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final IVSCameraInfo a(Room r8, long r9) {
        k r0 = null;
        if (r8 != null) goto L5;
        return null;
    L5:
        EpisodeExtraInfo r1 = r8.getEpisodeComponentData();
        if (r1 == null) goto L88;
        long r4 = 0;
        if (r1.getDefaultCameraId() != r9) goto L10;
    L43:
        VSCameraInfo r10 = new VSCameraInfo();
        EpisodeExtraInfo r11 = r8.getEpisodeComponentData();
        if (r11 == null) goto L46;
        long r2 = r11.getDefaultCameraId();
    L47:
        r10.cameraId = r2;
        r10.cameraIdStr = String.valueOf(r2);
        EpisodeExtraInfo r12 = r8.getEpisodeComponentData();
        if (r12 == null) goto L51;
        String r13 = r12.getMainCameraTitle();
        if (r13 == null) goto L51;
    L55:
        r10.title = r13;
        EpisodeExtraInfo r14 = r8.getEpisodeComponentData();
        if (r14 == null) goto L61;
        k r15 = r14.getMainCameraCover();
        if (r15 == null) goto L61;
        r0 = r15;
    L64:
        r10.cover = r0;
        r10.verticalCover = r8.getCover();
        r10.streamUrl = r8.getStreamUrl();
        r10.style = v.b(r8);
        EpisodeExtraInfo r16 = r8.getEpisodeComponentData();
        if (r16 == null) goto L67;
        long r3 = r16.getGroupId();
    L68:
        r10.groupId = r3;
        CameraMatchInfo r17 = new CameraMatchInfo();
        EpisodeExtraInfo r5 = r8.getEpisodeComponentData();
        if (r5 == null) goto L73;
        MainCameraMatchInfo r6 = r5.getMainCameraMatchInfo();
        if (r6 == null) goto L73;
        long r7 = r6.getMatchId();
    L74:
        r17.setMatchId(r7);
        EpisodeExtraInfo r18 = r8.getEpisodeComponentData();
        if (r18 == null) goto L79;
        MainCameraMatchInfo r19 = r18.getMainCameraMatchInfo();
        if (r19 == null) goto L79;
        r4 = r19.getContentId();
    L79:
        r17.setContentId(r4);
        EpisodeExtraInfo r20 = r8.getEpisodeComponentData();
        if (r20 == null) goto L85;
        MainCameraMatchInfo r21 = r20.getMainCameraMatchInfo();
        if (r21 == null) goto L85;
        List r22 = r21.getEventId();
        if (r22 == null) goto L85;
    L86:
        r17.setEventId(r22);
        Unit r23 = Unit.INSTANCE;
        r10.cameraMatchInfo = r17;
        return r10;
    L85:
        r22 = CollectionsKt.emptyList();
    L73:
        r7 = 0;
        goto L74
    L67:
        r3 = 0;
    L61:
        EpisodeExtraInfo r110 = r8.getEpisodeComponentData();
        if (r110 == null) goto L64;
        r0 = r110.getCover();
    L51:
        EpisodeExtraInfo r111 = r8.getEpisodeComponentData();
        if (r111 == null) goto L54;
        r13 = r111.getTitle();
        goto L55
    L54:
        r13 = null;
        goto L55
    L46:
        r2 = 0;
        goto L47
    L10:
        if (r9 == 0) goto L43;
        List r24 = r1.getCameraInfos();
        if (r24 == null) goto L94;
        Iterator r25 = r24.iterator();
    L16:
        if (r25.hasNext() == false) goto L23;
        Object r26 = r25.next();
        if (((IVSCameraInfo) r26).getCameraId() != r9) goto L20;
        boolean r27 = true;
    L21:
        if (r27 == false) goto L16;
    L24:
        IVSCameraInfo r28 = (IVSCameraInfo) r26;
        if (r28 != null) goto L27;
        return null;
    L27:
        if (r28.getCameraMatchInfo() != null) goto L42;
        CameraMatchInfo r29 = new CameraMatchInfo();
        MainCameraMatchInfo r30 = r1.getMainCameraMatchInfo();
        if (r30 == null) goto L31;
        long r31 = r30.getContentId();
    L32:
        r29.setContentId(r31);
        MainCameraMatchInfo r32 = r1.getMainCameraMatchInfo();
        if (r32 == null) goto L35;
        r4 = r32.getMatchId();
    L35:
        r29.setMatchId(r4);
        MainCameraMatchInfo r33 = r1.getMainCameraMatchInfo();
        if (r33 == null) goto L39;
        List r34 = r33.getEventId();
        if (r34 == null) goto L39;
    L40:
        r29.setEventId(r34);
        Unit r35 = Unit.INSTANCE;
        r28.setCameraMatchInfo(r29);
    L39:
        r34 = CollectionsKt.emptyList();
        goto L40
    L31:
        r31 = 0;
    L42:
        return r28;
    L20:
        r27 = false;
        goto L21
    L23:
        r26 = null;
        goto L24
    L94:
        return null;
    L88:
        return null;
    }
}
