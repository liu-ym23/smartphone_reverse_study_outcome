package com.ss.android.lark.officesdk.feed.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.feed.v1.FeedCursor;
import com.bytedance.lark.pb.feed.v1.GetDoubaoFeedListRequest;
import com.bytedance.lark.pb.feed.v1.GetDoubaoFeedListResponse;
import com.bytedance.lark.pb.office_sdk.im.OfficeSdkFeedType;
import com.bytedance.lark.pb.office_sdk.im.OfficeSdkUpdateLarkFeedRequest;
import com.bytedance.lark.pb.office_sdk.im.PairFeed;
import com.bytedance.lark.rustclient.api.c;
import com.bytedance.lark.rustclient.api.d;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.x;
import com.bytedance.lark.sdk.refactor.n;
import com.bytedance.lark.sdk.refactor.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@OfficeSDKUserScope
public final class FeedOfficeSdkServiceImpl implements qtb.a {
    public final String a;
    public final n b;
    public final l c;
    public final CoroutineScope d;

    public static final class a {
    }

    static {
    }

    @Override // qtb.a
    public final void v(List<String> r13) {
        Intrinsics.checkNotNullParameter(r13, "bizIdList");
        Long r0 = StringsKt.toLongOrNull(this.a);
        if (r0 == null) goto L5;
        long r6 = ULong.constructor-impl(r0.longValue());
    L6:
        AtomicLong r1 = p.a;
        String r2 = this.a;
        Intrinsics.checkNotNullParameter(r2, "userId");
        Long r3 = (Long) p.b.get(r2);
        if (r3 == null) goto L9;
        long r8 = ULong.constructor-impl(r3.longValue());
    L11:
        if (this.b.a(this.a) == null) goto L13;
        boolean r4 = true;
    L14:
        Log.i("FeedOfficeSdkServiceImpl", "notifyUpdateFeedData, uid=" + ULong.toString-impl(r6) + ", sdkSession=" + ULong.toString-impl(r8) + ", containerReady=" + r4 + ", bizId size=" + r13.size());
        if (r6 != 0) goto L17;
    L26:
        Log.e("FeedOfficeSdkServiceImpl", "notifyUpdateFeedData abort: uid/sdkSession is 0 or container not ready");
        return;
    L17:
        if (r8 == 0) goto L26;
        if (r4 == false) goto L26;
        OfficeSdkUpdateLarkFeedRequest.Builder r5 = new OfficeSdkUpdateLarkFeedRequest.Builder();
        List<String> r14 = r13;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r15 = r14.iterator();
    L22:
        if (r15.hasNext() == false) goto L24;
        r7.add(new PairFeed.Builder().biz_id((String) r15.next()).feed_type(OfficeSdkFeedType.DOUBAO_CUSTOM).build());
        goto L22
    L24:
        BuildersKt.launch$default(this.d, null, null, new FeedOfficeSdkServiceImpl$notifyUpdateFeedData$1(r6, r8, r5.feeds(r7).build().encode(), null), 3, null);
        return;
    L13:
        r4 = false;
        goto L14
    L9:
        r8 = 0;
        goto L11
    L5:
        r6 = 0;
        goto L6
    }

    @Override // qtb.a
    public final GetDoubaoFeedListResponse Ra(FeedCursor r21, int r22) {
        Long r2 = StringsKt.toLongOrNull(this.a);
        if (r2 == null) goto L5;
        long r5 = ULong.constructor-impl(r2.longValue());
    L6:
        Long r3 = this.b.a(this.a);
        if (r3 == null) goto L9;
        long r7 = ULong.constructor-impl(r3.longValue());
    L10:
        Log.i("FeedOfficeSdkServiceImpl", "getPagingDoubaoFeedList, uid=" + ULong.toString-impl(r5) + ", sdkSession=" + ULong.toString-impl(r7) + ", cursor.id=" + r21.id + ", cursor.rt=" + r21.rank_time + ", count=" + r22);
        Long r4 = null;
        if (r5 != 0) goto L13;
    L27:
        Log.e("FeedOfficeSdkServiceImpl", "getPagingDoubaoFeedList abort: uid or sdkSession is 0, container not ready");
        return null;
    L13:
        if (r7 == 0) goto L27;
        x r1 = this.c.h(new d(new GetDoubaoFeedListRequest.Builder().feed_cursor(r21).count(Boxing.boxInt(r22)), GetDoubaoFeedListResponse.ADAPTER, Command.GET_DOUBAO_FEED_LIST, null, null, null, null, 248)).execute();
        if ((r1 instanceof x) == false) goto L22;
        StringBuilder r6 = new StringBuilder("getPagingDoubaoFeedList success, next_cursor.id=");
        x r8 = r1;
        FeedCursor r9 = ((GetDoubaoFeedListResponse) r8.c).next_cursor;
        if (r9 == null) goto L20;
        r4 = r9.id;
    L20:
        r6.append(r4);
        r6.append(", size=");
        r6.append(((GetDoubaoFeedListResponse) r8.c).previews.size());
        Log.i("FeedOfficeSdkServiceImpl", r6.toString());
        return (GetDoubaoFeedListResponse) r8.c;
    L22:
        if ((r1 instanceof c) == false) goto L26;
        Log.e("FeedOfficeSdkServiceImpl", "getPagingDoubaoFeedList failed, error=" + ((c) r1).c.b);
        return null;
    L26:
        throw new NoWhenBranchMatchedException();
    L9:
        r7 = 0;
        goto L10
    L5:
        r5 = 0;
        goto L6
    }

    @Inject
    public FeedOfficeSdkServiceImpl(String r2, n r3, l r4) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "rustSdk");
        Intrinsics.checkNotNullParameter(r4, "rustClient");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }
}
