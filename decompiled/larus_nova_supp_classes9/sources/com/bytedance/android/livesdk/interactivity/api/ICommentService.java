package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import androidx.core.util.Consumer;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.model.v0;
import com.bytedance.android.livesdk.interactivity.api.comment.CommonInputParams;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AICloneConvItem;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.CommentService")
public interface ICommentService extends IService {
    t22.c createCommonInputDialog(CommonInputParams r1);

    Observable<Integer> createDownloadTask(List<Pair<String, String>> r1);

    k22.b getAIEntranceManager(DataContext r1, DataCenter r2, List<AICloneConvItem> r3);

    String getCacheFilePath(Context r1);

    IJsMethodsProvideService.IFactory getCommentJsFactory();

    Class<? extends LiveRecyclableWidget> getCommentWidgetClass();

    j70.h<d90.d> getHighlightRecordDescriptor();

    Map<String, String> getLiveAnchorChooseButtonReportParam(String r1);

    Class<? extends LiveRecyclableWidget> getMediaLandScapeCommentWidgetClass();

    Class<? extends LiveRecyclableWidget> getVSLandscapeCommentWidgetClass();

    Class<? extends LiveRecyclableWidget> getVSSpiltLandscapeCommentWidgetClass();

    void inputActivityEmoji(long r1, String r3, Map<String, String> r4);

    void inputFusionEmoji(long r1, String r3, String r4, Map<String, String> r5);

    Observable<Response<v0>> sendCommentChat(IRoom r1, String r2);

    void startInteractivityShare(w22.a r1, Consumer<Boolean> r2);
}
