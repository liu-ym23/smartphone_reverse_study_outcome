package com.bytedance.android.livesdk.feed.drawerfeed.utils;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSConfigDrawer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/utils/FeedItemDiffChecker;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "<init>", "()V", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedItemDiffChecker extends DiffUtil.ItemCallback<FeedItem> {
    public FeedItemDiffChecker() {
    }

    public final boolean areContentsTheSame(Object r7, Object r8) {
        FeedItem r9 = (FeedItem) r7;
        FeedItem r10 = (FeedItem) r8;
        Intrinsics.checkNotNullParameter(r9, "oldItem");
        Intrinsics.checkNotNullParameter(r10, "newItem");
        if (r9.type == r10.type) goto L5;
        return false;
    L5:
        if (r9.cameraType == r10.cameraType) goto L7;
        return false;
    L7:
        if (r9.getRoom().id != r10.getRoom().id) goto L113;
        int r0 = r9.cameraType;
        k r3 = null;
        if (r0 != 1) goto L11;
        EpisodeExtraInfo r1 = r9.getRoom().getEpisodeComponentData();
        if (r1 == null) goto L134;
        ImageModel r2 = r1.getMainCameraCover();
        if (r2 == null) goto L135;
        ImageModel r4 = r2;
        EpisodeExtraInfo r5 = r10.getRoom().getEpisodeComponentData();
        if (r5 == null) goto L82;
        k r6 = r5.getMainCameraCover();
    L84:
        if (r4.equals(r6) != true) goto L136;
        EpisodeExtraInfo r11 = r9.getRoom().getEpisodeComponentData();
        if (r11 == null) goto L137;
        String r12 = r11.getMainCameraTitle();
        if (r12 == null) goto L138;
        EpisodeExtraInfo r13 = r10.getRoom().getEpisodeComponentData();
        if (r13 == null) goto L92;
        String r14 = r13.getMainCameraTitle();
    L94:
        if (r12.equals(r14) != true) goto L139;
        Room r15 = r9.getRoom();
        if (r15 == null) goto L140;
        EpisodeExtraInfo r16 = r15.getEpisodeExtra2();
        if (r16 == null) goto L141;
        VSConfigDrawer r17 = r16.getVsConfigDrawer();
        if (r17 == null) goto L142;
        ImageModel r18 = r17.drawerLabel;
        if (r18 == null) goto L143;
        ImageModel r19 = r18;
        EpisodeExtraInfo r20 = r10.getRoom().getEpisodeExtra2();
        if (r20 == null) goto L109;
        VSConfigDrawer r21 = r20.getVsConfigDrawer();
        if (r21 == null) goto L109;
        r3 = r21.drawerLabel;
    L109:
        if (r19.equals(r3) != true) goto L144;
    L20:
        return true;
    L144:
        return false;
    L143:
        return false;
    L142:
        return false;
    L141:
        return false;
    L140:
        return false;
    L139:
        return false;
    L92:
        r14 = null;
        goto L94
    L138:
        return false;
    L137:
        return false;
    L136:
        return false;
    L82:
        r6 = null;
        goto L84
    L135:
        return false;
    L134:
        return false;
    L11:
        if (r0 == 2) goto L21;
        String r22 = r9.getRoom().getTitle();
        if (r22 != null) goto L15;
        return false;
    L15:
        if (r22.equals(r10.getRoom().getTitle()) != true) goto L115;
        ImageModel r23 = r9.getRoom().getCover();
        if (r23 != null) goto L19;
        return false;
    L19:
        if (r23.equals(r10.getRoom().getCover()) == true) goto L20;
        return false;
    L115:
        return false;
    L21:
        EpisodeExtraInfo r24 = r9.getRoom().getEpisodeComponentData();
        if (r24 == null) goto L119;
        List r25 = r24.getCameraInfos();
        if (r25 == null) goto L120;
        IVSCameraInfo r26 = (IVSCameraInfo) CollectionsKt.firstOrNull(r25);
        if (r26 == null) goto L121;
        String r27 = r26.getTitle();
        if (r27 == null) goto L122;
        EpisodeExtraInfo r28 = r10.getRoom().getEpisodeComponentData();
        if (r28 == null) goto L36;
        List r29 = r28.getCameraInfos();
        if (r29 == null) goto L36;
        IVSCameraInfo r30 = (IVSCameraInfo) CollectionsKt.firstOrNull(r29);
        if (r30 == null) goto L36;
        String r31 = r30.getTitle();
    L38:
        if (r27.equals(r31) != true) goto L123;
        EpisodeExtraInfo r32 = r9.getRoom().getEpisodeComponentData();
        if (r32 == null) goto L124;
        List r33 = r32.getCameraInfos();
        if (r33 == null) goto L125;
        IVSCameraInfo r34 = (IVSCameraInfo) CollectionsKt.firstOrNull(r33);
        if (r34 == null) goto L126;
        ImageModel r35 = r34.getCover();
        if (r35 == null) goto L127;
        ImageModel r36 = r35;
        EpisodeExtraInfo r37 = r10.getRoom().getEpisodeComponentData();
        if (r37 == null) goto L54;
        List r38 = r37.getCameraInfos();
        if (r38 == null) goto L54;
        IVSCameraInfo r39 = (IVSCameraInfo) CollectionsKt.firstOrNull(r38);
        if (r39 == null) goto L54;
        k r40 = r39.getCover();
    L56:
        if (r36.equals(r40) != true) goto L128;
        EpisodeExtraInfo r41 = r9.getRoom().getEpisodeComponentData();
        if (r41 == null) goto L129;
        List r42 = r41.getCameraInfos();
        if (r42 == null) goto L130;
        IVSCameraInfo r43 = (IVSCameraInfo) CollectionsKt.firstOrNull(r42);
        if (r43 == null) goto L131;
        ImageModel r44 = r43.getLabel();
        if (r44 == null) goto L132;
        ImageModel r45 = r44;
        EpisodeExtraInfo r46 = r10.getRoom().getEpisodeComponentData();
        if (r46 == null) goto L73;
        List r47 = r46.getCameraInfos();
        if (r47 == null) goto L73;
        IVSCameraInfo r48 = (IVSCameraInfo) CollectionsKt.firstOrNull(r47);
        if (r48 == null) goto L73;
        r3 = r48.getLabel();
    L73:
        if (r45.equals(r3) == true) goto L20;
        return false;
    L132:
        return false;
    L131:
        return false;
    L130:
        return false;
    L129:
        return false;
    L128:
        return false;
    L54:
        r40 = null;
        goto L56
    L127:
        return false;
    L126:
        return false;
    L125:
        return false;
    L124:
        return false;
    L123:
        return false;
    L36:
        r31 = null;
        goto L38
    L122:
        return false;
    L121:
        return false;
    L120:
        return false;
    L119:
        return false;
    L113:
        return false;
    }

    public final boolean areItemsTheSame(Object r6, Object r7) {
        FeedItem r8 = (FeedItem) r6;
        FeedItem r9 = (FeedItem) r7;
        Intrinsics.checkNotNullParameter(r8, "oldItem");
        Intrinsics.checkNotNullParameter(r9, "newItem");
        if (r8.type == r9.type) goto L5;
    L29:
        return false;
    L5:
        if (r8.cameraType != r9.cameraType) goto L29;
        if (r8.getRoom().id != r9.getRoom().id) goto L29;
        int r0 = r8.cameraType;
        if (r0 != 1) goto L11;
        return true;
    L11:
        if (r0 != 2) goto L33;
        EpisodeExtraInfo r10 = r8.getRoom().getEpisodeComponentData();
        Long r1 = null;
        if (r10 == null) goto L20;
        List r11 = r10.getCameraInfos();
        if (r11 == null) goto L20;
        IVSCameraInfo r12 = (IVSCameraInfo) CollectionsKt.firstOrNull(r11);
        if (r12 == null) goto L20;
        Long r13 = Long.valueOf(r12.getCameraId());
    L21:
        EpisodeExtraInfo r14 = r9.getRoom().getEpisodeComponentData();
        if (r14 == null) goto L32;
        List r15 = r14.getCameraInfos();
        if (r15 == null) goto L32;
        IVSCameraInfo r16 = (IVSCameraInfo) CollectionsKt.firstOrNull(r15);
        if (r16 == null) goto L32;
        r1 = Long.valueOf(r16.getCameraId());
    L32:
        return Intrinsics.areEqual(r13, r1);
    L20:
        r13 = null;
        goto L21
    L33:
        return true;
    }
}
