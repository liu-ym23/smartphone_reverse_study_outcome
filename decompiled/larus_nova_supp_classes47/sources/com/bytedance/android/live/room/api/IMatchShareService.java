package com.bytedance.android.live.room.api;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.vs.model.MatchShareParam;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.MatchShareService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J6\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0007H&J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&Jp\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\"\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bH&JF\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0003H&J0\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007H&J0\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u00032\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070+2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H&J0\u0010.\u001a\u00020\r2&\u0010/\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH&J\u001c\u00100\u001a\u00020\r2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000701H&J\u0010\u00102\u001a\u00020\r2\u0006\u00103\u001a\u000204H&J\u0012\u00105\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u00106\u001a\u00020\rH&J\b\u00107\u001a\u00020\rH&J\u0018\u00108\u001a\u00020\r2\u0006\u00103\u001a\u0002042\u0006\u00109\u001a\u000204H&J\u001c\u0010:\u001a\u00020\r2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000701H&J\u001c\u0010;\u001a\u00020\r2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000701H&J\u0010\u0010<\u001a\u00020\r2\u0006\u00103\u001a\u000204H&J\u0012\u0010=\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u001c\u0010>\u001a\u00020\r2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000701H&J\b\u0010?\u001a\u00020\rH&J\u0010\u0010@\u001a\u00020\r2\u0006\u00103\u001a\u000204H&J\u0014\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00070BH\u0016J \u0010C\u001a\u00020\r2\u0006\u0010#\u001a\u00020D2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010E\u001a\u00020FH&¨\u0006G"}, d2 = {"Lcom/bytedance/android/live/room/api/IMatchShareService;", "Lcom/bytedance/android/live/base/IService;", "allowQuickRecordShare", "", "allowQuickShotShare", "generateShareLogParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "enterFromMerge", "launchMatchShare", "", "context", "Landroid/content/Context;", "isLandscape", "shareParam", "Lcom/bytedance/android/livesdk/vs/model/MatchShareParam;", "launchMatchShareByCollectionId", "enterFrom", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "episode", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/Episode;", "collectionId", "episodeId", "contentType", "logParam", "launchMatchShareByRoomId", "index", "", "preloadCollectionJson", "roomId", "launchMatchTicketShare", "activity", "Landroid/app/Activity;", "showPushPanel", "ticketGenerate", "extraParams", "launchVsMultiPosterShare", "addRoomInfo", "sharePosterList", "", "logExtra", "logReflowExtra", "logMatchSharePublishPageShow", "params", "logQuickRecordAudioOpen", "", "logQuickRecordBtnClick", "clickTime", "", "logQuickRecordBtnShow", "logQuickRecordFinish", "logQuickRecordShareDialogClick", "logQuickRecordShareDialogShow", "recordDuration", "logQuickRecordTaskFinish", "logQuickRecordTaskFinish201", "logQuickShotBtnClick", "logQuickShotBtnShow", "logQuickShotFinish", "logQuickShotShareDialogClick", "logQuickShotShareDialogShow", "openPushGuideDialogForSaas", "Lkotlin/Pair;", "showShareDialog", "Landroidx/fragment/app/FragmentActivity;", "collectionItem", "Lcom/bytedance/android/livesdkapi/depend/model/match/CollectionItem;", "experience-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMatchShareService extends IService {
    boolean allowQuickRecordShare();

    boolean allowQuickShotShare();

    HashMap<String, String> generateShareLogParams(DataCenter r1, String r2);

    void launchMatchShare(Context r1, boolean r2, MatchShareParam r3);

    void launchMatchShareByCollectionId(Context r1, String r2, Room r3, Episode r4, boolean r5, String r6, String r7, String r8, HashMap<String, String> r9);

    void launchMatchShareByRoomId(Context r1, String r2, int r3, String r4, String r5, String r6, boolean r7);

    void launchMatchTicketShare(Activity r1, boolean r2, String r3, String r4, String r5);

    void launchVsMultiPosterShare(boolean r1, List<String> r2, String r3, String r4);

    void logMatchSharePublishPageShow(HashMap<String, String> r1);

    void logQuickRecordAudioOpen(Map<String, String> r1);

    void logQuickRecordBtnClick(long r1);

    void logQuickRecordBtnShow(DataCenter r1);

    void logQuickRecordFinish();

    void logQuickRecordShareDialogClick();

    void logQuickRecordShareDialogShow(long r1, long r3);

    void logQuickRecordTaskFinish(Map<String, String> r1);

    void logQuickRecordTaskFinish201(Map<String, String> r1);

    void logQuickShotBtnClick(long r1);

    void logQuickShotBtnShow(DataCenter r1);

    void logQuickShotFinish(Map<String, String> r1);

    void logQuickShotShareDialogClick();

    void logQuickShotShareDialogShow(long r1);

    Pair<Integer, String> openPushGuideDialogForSaas();

    void showShareDialog(FragmentActivity r1, MatchShareParam r2, CollectionItem r3);
}
