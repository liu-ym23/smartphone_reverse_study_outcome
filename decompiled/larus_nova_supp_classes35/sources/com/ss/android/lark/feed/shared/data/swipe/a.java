package com.ss.android.lark.feed.shared.data.swipe;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.feed.v1.FeedSlideActionSetting;
import com.bytedance.lark.pb.feed.v1.GetFeedActionSettingRequest;
import com.bytedance.lark.pb.feed.v1.GetFeedActionSettingResponse;
import com.bytedance.lark.rustclient.api.d;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.ThreadUtils;
import com.larksuite.framework.utils.p;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.log.Log;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final Map<FeedSlideActionSetting.FeedSlideActionType, List<FeedActionType>> f = null;
    public static final List<FeedSlideActionSetting.FeedSlideActionType> g = null;
    public static final List<FeedActionType> h = null;
    public final l a;
    public final MutableLiveData<FeedSlideActionSetting> b;
    public final List<FeedActionType> c;
    public final List<FeedActionType> d;
    public final CompositeDisposable e;

    /* JADX INFO: renamed from: com.ss.android.lark.feed.shared.data.swipe.a$a, reason: collision with other inner class name */
    public static final class C0202a {
        public C0202a() {
        }

        public static List a(List r3) {
            Intrinsics.checkNotNullParameter(r3, "slideActionList");
            ArrayList r0 = new ArrayList();
            Iterator r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L10;
            FeedSlideActionSetting.FeedSlideActionType r1 = (FeedSlideActionSetting.FeedSlideActionType) r4.next();
            if (r1 == null) goto L4;
            Map<FeedSlideActionSetting.FeedSlideActionType, List<FeedActionType>> r2 = a.f;
            List<FeedActionType> r5 = a.f.get(r1);
            if (r5 == null) goto L4;
            r0.addAll(r5);
            goto L4
        L10:
            return r0;
        }
    }

    static {
        new C0202a();
        FeedSlideActionSetting.FeedSlideActionType r2 = FeedSlideActionSetting.FeedSlideActionType.SHORTCUT;
        FeedSlideActionSetting.FeedSlideActionType r3 = FeedSlideActionSetting.FeedSlideActionType.FLAG;
        FeedSlideActionSetting.FeedSlideActionType r5 = FeedSlideActionSetting.FeedSlideActionType.FEED_GROUP;
        FeedSlideActionSetting.FeedSlideActionType r7 = FeedSlideActionSetting.FeedSlideActionType.MUTE;
        FeedSlideActionSetting.FeedSlideActionType r9 = FeedSlideActionSetting.FeedSlideActionType.DONE;
        FeedSlideActionSetting.FeedSlideActionType r11 = FeedSlideActionSetting.FeedSlideActionType.MARK_OR_CLEAR_UNREAD;
        f = MapsKt.mapOf(new Pair[]{TuplesKt.to(r2, CollectionsKt.listOf(FeedActionType.TOPPING)), TuplesKt.to(r3, CollectionsKt.listOf(FeedActionType.FLAG_MARK)), TuplesKt.to(r5, CollectionsKt.listOf(FeedActionType.ADD_FEED_TAG)), TuplesKt.to(r7, CollectionsKt.listOf(FeedActionType.NO_DISTURB)), TuplesKt.to(r9, CollectionsKt.listOf(FeedActionType.DONE)), TuplesKt.to(r11, CollectionsKt.listOf(new FeedActionType[]{FeedActionType.MARK_UNREAD, FeedActionType.CLEAR_UNREAD}))});
        List<FeedSlideActionSetting.FeedSlideActionType> r0 = CollectionsKt.listOf(new FeedSlideActionSetting.FeedSlideActionType[]{r3, r2, r11, r5, r7, r9});
        g = r0;
        h = C0202a.a(p.a(r0));
    }

    public a() {
        this.a = null;
        FeedSlideActionSetting.Builder r1 = new FeedSlideActionSetting.Builder();
        Boolean r2 = Boolean.FALSE;
        this.b = new MutableLiveData(r1.left_slide_action_on(r2).right_slide_action_on(r2).left_slide_action(CollectionsKt.emptyList()).right_slide_action(CollectionsKt.emptyList()).build());
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new CompositeDisposable();
        Log.i("SwipeActionSettingStore", "listenPush rustClient is empty");
    }

    public static final void a(final a r12, final int r13) {
        r12.getClass();
        Log.i("SwipeActionSettingStore", "fetchFromLocal retryCount:" + r13);
        if (r13 < 1) goto L5;
        Log.w("SwipeActionSettingStore", "fetchFromLocal retry return.");
        return;
    L5:
        l r0 = r12.a;
        if (r0 == null) goto L10;
        SyncDataStrategy r1 = SyncDataStrategy.LOCAL;
        final IGetDataCallback<FeedSlideActionSetting> r2 = new SwipeActionSettingStore$fetchFromLocal$1(r12, r13);
        GetFeedActionSettingRequest.Builder r4 = new GetFeedActionSettingRequest.Builder().sync_data_strategy(r1);
        Intrinsics.checkNotNull(r4);
        r12.e.add(t.a(r0.h(new d(r4, GetFeedActionSettingResponse.ADAPTER, Command.GET_FEED_ACTION_SETTING, null, null, null, null, 248)).a().map(b.a), new SwipeActionSettingStore$getFeedActionSetting$2(r2), new SwipeActionSettingStore$getFeedActionSetting$3(r2), SwipeActionSettingStore$getFeedActionSetting$4.INSTANCE));
        return;
    }

    public static final void b(a r1, FeedSlideActionSetting r2) {
        r1.getClass();
        if (r2 != null) goto L5;
        Log.e("SwipeActionSettingStore", "onChange return for null.");
        return;
    L5:
        ThreadUtils.runOnUIThread(new c(r1, r2));
    }
}
