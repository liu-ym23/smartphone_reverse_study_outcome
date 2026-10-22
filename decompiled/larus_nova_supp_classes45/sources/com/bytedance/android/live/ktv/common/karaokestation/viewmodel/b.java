package com.bytedance.android.live.ktv.common.karaokestation.viewmodel;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.karaokestation.model.UpdateTabType;
import com.bytedance.android.live.ktv.common.karaokestation.model.d;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.MultiLinkSettingHelper;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface b {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(b r17, long r18, int r21, String r22, int r23, long r24, long r25, boolean r27, String r28, Function1 r29, int r31) {
            if ((r31 & 16) == 0) goto L5;
            long r11 = 0;
        L7:
            if ((r31 & 32) == 0) goto L9;
            long r12 = 0;
        L11:
            if ((r31 & 64) == 0) goto L13;
            boolean r14 = false;
        L15:
            if ((r31 & 128) == 0) goto L17;
            String r15 = null;
        L19:
            if ((r31 & 256) == 0) goto L21;
            Function1 r16 = null;
        L22:
            r17.syncSecondLevelTabList(r18, r21, r22, r23, r11, r12, r14, r15, r16);
            return;
        L21:
            r16 = r29;
            goto L22
        L17:
            r15 = r28;
            goto L19
        L13:
            r14 = r27;
            goto L15
        L9:
            r12 = r25;
            goto L11
        L5:
            r11 = r24;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void b(b r15, long r16, boolean r18, int r19, int r21, y r22, long r23, long r24, String r26, Function1 r27, int r28) {
            if ((r28 & 4) == 0) goto L5;
            int r6 = ((t61) MultiLinkSettingHelper.a.getValue()).L6();
        L7:
            if ((r28 & 32) == 0) goto L9;
            long r9 = 0;
        L11:
            if ((r28 & 64) == 0) goto L13;
            long r11 = 0;
        L15:
            if ((r28 & 128) == 0) goto L17;
            String r13 = null;
        L19:
            if ((r28 & 256) == 0) goto L21;
            Function1 r14 = null;
        L22:
            r15.syncSecondLevelTabSongList(r16, r18, r6, r21, r22, r9, r11, r13, r14);
            return;
        L21:
            r14 = r27;
            goto L22
        L17:
            r13 = r26;
            goto L19
        L13:
            r11 = r24;
            goto L15
        L9:
            r9 = r23;
            goto L11
        L5:
            r6 = r19;
            goto L7
        }
    }

    void addFavorite(MusicPanel r1, ic0.a r2);

    void addSong(Context r1, MusicPanel r2, RecyclerView.ViewHolder r3);

    void clearData();

    void delFavorite(MusicPanel r1, ic0.a r2);

    int getCurTabMode();

    d getFirstLevelTabDataByTopValue(int r1);

    y getSecondLevelTabDataByParams(int r1, String r2);

    List<y> getSecondLevelTabDataList(int r1);

    Pair<Integer, UpdateTabType> getSelectedFirstLevelTabValue();

    y getSelectedSecondLevelTabData(int r1);

    void observeSelectedFirstLevelTabValueChange(LifecycleOwner r1, Observer<Pair<Integer, UpdateTabType>> r2);

    void observeSongListDataChange(LifecycleOwner r1, Observer<y> r2);

    void observeTabListDataChange(LifecycleOwner r1, Observer<Pair<d, List<y>>> r2);

    void observeTabListStateChange(LifecycleOwner r1, Observer<List<y>> r2);

    void syncSecondLevelTabList(long r1, int r3, String r4, int r5, long r6, long r8, boolean r11, String r12, Function1<? super Boolean, Unit> r13);

    void syncSecondLevelTabSongList(long r1, boolean r3, int r4, int r5, y r6, long r7, long r9, String r11, Function1<? super Boolean, Unit> r12);

    void updateSecondLevelTabListState(y r1);

    void updateSecondLevelTabListState(y r1, boolean r2);

    void updateSelectFirstLevelTabValue(int r1, UpdateTabType r2);

    void updateSongListData(y r1);

    void updateTabListData(d r1);
}
