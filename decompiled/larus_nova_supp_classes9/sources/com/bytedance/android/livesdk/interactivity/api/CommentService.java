package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import android.os.Bundle;
import androidx.core.util.Consumer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.model.v0;
import com.bytedance.android.livesdk.interactivity.api.comment.CommonInputParams;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AICloneConvItem;
import com.bytedance.android.livesdk.interactivity.comment.CommentWidget;
import com.bytedance.android.livesdk.interactivity.comment.MediaLandscapeCommentWidget;
import com.bytedance.android.livesdk.interactivity.comment.VSLandscapeCommentWidget;
import com.bytedance.android.livesdk.interactivity.comment.VSSpiltLandscapeCommentWidget;
import com.bytedance.android.livesdk.interactivity.comment.input.LiveCommonInputDialog;
import com.bytedance.android.livesdk.interactivity.comment.share.api.InteractivityShareApi;
import com.bytedance.android.livesdk.interactivity.service.model.ICommunityRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.socialbase.downloader.exception.BaseException;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class CommentService implements ICommentService {

    public class a implements IJsMethodsProvideService.IFactory {
        public a() {
        }

        public final Map<String, n56.c> buildMethods(WeakReference<Context> r2, n56.a r3) {
            HashMap r4 = new HashMap();
            r4.put("crossplatformComment", new com.bytedance.android.livesdk.interactivity.comment.js.a());
            return r4;
        }
    }

    public class b implements e72.b.InterfaceC0228b {
        public final /* synthetic */ ObservableEmitter a;

        public b(ObservableEmitter r1) {
            this.a = r1;
        }

        @Override // e72.b.InterfaceC0228b
        public final void onProgress(int r2) {
            this.a.onNext(Integer.valueOf((r2 * 90) / 100));
        }

        @Override // e72.b.InterfaceC0228b
        public final void onSuccess(List<Pair<String, String>> r1) {
            this.a.onComplete();
        }

        @Override // e72.b.InterfaceC0228b
        public final void a(List<Pair<String, String>> r2, BaseException r3) {
            if (r3 != null) goto L4;
            this.a.onError(new RuntimeException("download failed."));
            return;
        L4:
            this.a.onError(r3);
        }
    }

    public CommentService() {
    }

    public static /* synthetic */ void b(CommentService r0, List r1, ObservableEmitter r2) {
        r0.lambda$createDownloadTask$0(r1, r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public IJsMethodsProvideService.IFactory getCommentJsFactory() {
        return new a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public j70.h<d90.d> getHighlightRecordDescriptor() {
        return new com.bytedance.android.livesdk.interactivity.comment.record.view.f();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public Class<? extends LiveRecyclableWidget> getCommentWidgetClass() {
        return CommentWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public Class<? extends LiveRecyclableWidget> getMediaLandScapeCommentWidgetClass() {
        return MediaLandscapeCommentWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public Class<? extends LiveRecyclableWidget> getVSLandscapeCommentWidgetClass() {
        return VSLandscapeCommentWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public Class<? extends LiveRecyclableWidget> getVSSpiltLandscapeCommentWidgetClass() {
        return VSSpiltLandscapeCommentWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public t22.c createCommonInputDialog(CommonInputParams r4) {
        int r0 = LiveCommonInputDialog.p;
        Intrinsics.checkNotNullParameter(r4, "commonInputParams");
        LiveCommonInputDialog r1 = new LiveCommonInputDialog();
        Bundle r2 = new Bundle();
        r2.putParcelable("common_input_params", r4);
        Unit r5 = Unit.INSTANCE;
        r1.setArguments(r2);
        return r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public Observable<Integer> createDownloadTask(final List<Pair<String, String>> r2) {
        return Observable.create(new com.bytedance.android.livesdk.interactivity.api.a(this, r2));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public String getCacheFilePath(Context r1) {
        return e72.c.c(r1);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public Map<String, String> getLiveAnchorChooseButtonReportParam(String r2) {
        return ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).getLiveAnchorChooseButtonReportParam(r2);
    }

    private void lambda$createDownloadTask$0(List r3, ObservableEmitter r4) throws Exception {
        e72.b r0 = new e72.b(r3, new b(r4));
        if (r0.a == true) goto L7;
        r0.a = true;
        r0.a();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public Observable<Response<v0>> sendCommentChat(IRoom r13, String r14) {
        if (r13.castToOrNull(ICommunityRoom.class) != null) goto L5;
        String r8 = null;
    L7:
        return new g92.a(r13.getId(), r14, 0, r13.getRequestId(), r8, null, null).b(null, null, false);
    L5:
        r8 = ((ICommunityRoom) r13.castToOrNull(ICommunityRoom.class)).getLabels();
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public void startInteractivityShare(w22.a r6, Consumer<Boolean> r7) {
        int r0 = c72.c.a;
        Intrinsics.checkNotNullParameter(r6, "shareContent");
        IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
        if (r1 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.o r2 = IRoomContextService.a.a(r1, null, 0, 3);
        if (r2 == null) goto L13;
        com.bytedance.live.datacontext.m r3 = r2.getRoom();
        if (r3 == null) goto L14;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L15;
        long r5 = r4.getRoomId();
        com.bytedance.android.livesdk.interactivity.comment.share.model.b r8 = new com.bytedance.android.livesdk.interactivity.comment.share.model.b();
        r8.roomId = r5;
        r8.itemType = r6.b;
        r8.itemId = r6.a;
        r8.extra = r6.c;
        r8.schema = r6.d;
        InteractivityShareApi.a.getClass();
        ((InteractivityShareApi) com.bytedance.android.live.network.c.b().e(InteractivityShareApi.class)).shareItem(r8.a()).compose(RxUtil.rxSchedulerHelper()).subscribe(new c72.a(r5, r6, r7), new c72.b(r7));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public k22.b getAIEntranceManager(DataContext r3, DataCenter r4, List<AICloneConvItem> r5) {
        s62.a r0 = new s62.a(r3, r4);
        Intrinsics.checkNotNullParameter(r5, "list");
        r0.e = r5;
        StringBuilder r6 = new StringBuilder("aiCloneList:");
        List<AICloneConvItem> r7 = r0.e;
        if (r7 == null) goto L8;
        List<AICloneConvItem> r8 = r7;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r10 = r8.iterator();
    L6:
        if (r10.hasNext() == false) goto L9;
        r9.add(((AICloneConvItem) r10.next()).getConvItem());
    L9:
        r6.append(String.valueOf(r9));
        ALogger.i("AICloneTag", r6.toString());
        return r0;
    L8:
        r9 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public void inputActivityEmoji(long r3, String r5, Map<String, String> r6) {
        q r0 = q.a;
        com.bytedance.android.livesdk.interactivity.api.emoji.d r1 = null;
        h r2 = i.b(null, 3);
        if (r2 == null) goto L7;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.d> r4 = r2.getActivityEmojiManager();
        if (r4 == null) goto L7;
        r1 = (com.bytedance.android.livesdk.interactivity.api.emoji.d) r4.getValue();
    L7:
        if (r1 == null) goto L10;
        r1.inputActivityEmoji(r3, r5, r6);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public void inputFusionEmoji(long r1, @Nullable String r3, String r4, Map<String, String> r5) {
        com.bytedance.android.livesdk.interactivity.api.emoji.e r6 = q.d();
        if (r6 == null) goto L6;
        r6.e(r1, r3, r4);
        return;
    }
}
