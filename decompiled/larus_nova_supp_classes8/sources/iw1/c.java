package iw1;

import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.log.g;
import com.bytedance.android.live.core.paging.Listing;
import com.bytedance.android.livesdk.feed.ItemRepository;
import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.repository.FeedRepository;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.android.livesdkapi.feed.IPullable;
import com.bytedance.android.livesdkapi.feed.IPullableForSaas;
import com.bytedance.android.livesdkapi.feed.NeedScrollList;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends ILiveRoomListProvider implements NeedScrollList, IPullable<Integer> {
    public final ItemRepository<FeedItem> a;
    public final List<Bundle> b;
    public final List<Room> c;
    public IPullable.IPullCallback d;
    public PagedList<FeedItem> e;
    public final a f;
    public final iw1.a g;
    public final b h;

    public class a extends PagedList.Callback {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final void onChanged(int r1, int r2) {
            this.a.n();
            this.a.dispatchChange();
        }

        public final void onInserted(int r1, int r2) {
            this.a.n();
            this.a.dispatchChange();
        }

        public final void onRemoved(int r1, int r2) {
            this.a.n();
            this.a.dispatchChange();
        }
    }

    public final String providerType() {
        return "FeedRoomListProvider";
    }

    public final /* synthetic */ void pullToRefresh(IPullable.IPullCallback r1) {
        IPullableForSaas.-CC.$default$pullToRefresh(this, r1);
    }

    public final void n() {
        this.b.clear();
        this.c.clear();
        ItemRepository<FeedItem> r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (Lists.isEmpty(r0.getFeedItems()) == true) goto L22;
        Iterator r1 = this.a.getFeedItems().iterator();
    L8:
        if (r1.hasNext() == false) goto L23;
        FeedItem r2 = (FeedItem) r1.next();
        if ((r2.getItem() instanceof Room) == false) goto L8;
        Bundle r3 = ArgumentsBuilder.buildRoomArgs(r2.getItem());
        if (r2.isPseudoLiving == false) goto L15;
        r3.putBoolean("live.intent.extra.IS_PSEUDO_LIVING", true);
    L15:
        this.b.add(r3);
        this.c.add((Room) r2.getItem());
        goto L8
    L23:
        return;
    }

    public final void release() {
        ItemRepository<FeedItem> r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        PagedList<FeedItem> r1 = this.e;
        if (r1 == null) goto L10;
        r1.removeWeakCallback(this.f);
        this.e = null;
    L10:
        ((ArrayList) this.b).clear();
        ((ArrayList) this.c).clear();
        return;
    L5:
        if (r0.pc() == 0) goto L7;
        this.a.pc().getPageList().removeObserver(this.g);
        this.a.pc().getRefreshStat().removeObserver(this.h);
        this.a.pc().setReqFrom(null, null);
        goto L7
    }

    public final int size() {
        return ((ArrayList) this.b).size();
    }

    public final List<Room> getRoomList() {
        return this.c;
    }

    public final Bundle getRoomArgs(int r2) {
        return (Bundle) ListProtector.get(this.b, r2);
    }

    public final int indexOf(Bundle r7) {
        long r0 = r7.getLong("live.intent.extra.ROOM_ID", -1);
        int r8 = 0;
    L4:
        if (r8 >= ((ArrayList) this.b).size()) goto L9;
        if (((Bundle) ListProtector.get(this.b, r8)).getLong("live.intent.extra.ROOM_ID", 0) == r0) goto L7;
        r8 = r8 + 1;
        goto L4
    L7:
        return r8;
    L9:
        return -1;
    }

    public final void loadMore(int r4) {
        ItemRepository<FeedItem> r0 = this.a;
        if (r0 == null) goto L24;
        Listing<T> r1 = r0.pc();
        if (r1 == 0) goto L25;
        Boolean r2 = (Boolean) r1.hasMore().getValue();
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.booleanValue() == false) goto L27;
        r1.setReqFrom(null, "detail_loadmore");
        if (this.a.pc() != 0) goto L13;
        return;
    L13:
        if (this.a.pc().getPageList().getValue() != null) goto L15;
        return;
    L15:
        if (((PagedList) this.a.pc().getPageList().getValue()).isEmpty() == true) goto L30;
        PagedList r3 = (PagedList) this.a.pc().getPageList().getValue();
        PagedList<FeedItem> r5 = this.e;
        if (r5 != null) goto L19;
    L21:
        int r6 = r4 + 6;
    L22:
        r3.loadAround(r6);
        return;
    L19:
        if (r5.size() <= 0) goto L21;
        r6 = this.e.size() - 1;
        goto L22
    L30:
        return;
    L27:
        return;
    L25:
        return;
    }

    public final void removeRoom(long r2) {
        ItemRepository<FeedItem> r0 = this.a;
        if (r0 == null) goto L6;
        r0.Gf(String.valueOf(r2));
        return;
    }

    public final void updatePos(long r2) {
        ItemRepository<FeedItem> r0 = this.a;
        if (r0 == null) goto L16;
        FeedItem r3 = r0.getFeedItem(String.valueOf(r2));
        if (r3 != null) goto L7;
        return;
    L7:
        int r4 = this.a.getFeedItems().indexOf(r3);
        if (r4 >= 0) goto L10;
        return;
    L10:
        b0.o().getClass();
        g.c("ttlive_new_feed", "FeedRoomListProvider#updatePos");
        ItemRepository<FeedItem> r5 = this.a;
        if ((r5 instanceof FeedRepository) == true) goto L13;
        return;
    L13:
        if (((FeedRepository) r5).query().b == null) goto L18;
        ((FeedRepository) this.a).query().b.a.setValue(Integer.valueOf(r4));
        return;
    L18:
        return;
    }

    public c(FeedDataKey r3, f r4) {
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.e = null;
        this.f = new a(this);
        Observer r0 = new iw1.a(this);
        this.g = r0;
        Observer r1 = new b(this);
        this.h = r1;
        ItemRepository<FeedItem> r5 = r4.d(r3);
        this.a = r5;
        n();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.pc() == 0) goto L9;
        r5.pc().getPageList().observeForever(r0);
        r5.pc().getRefreshStat().observeForever(r1);
        return;
    }

    public final void alterSpecificItem(int r3, FeedItem r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r3 >= ((ArrayList) this.b).size()) goto L13;
        if (r3 < 0) goto L14;
        long r0 = getRoomArgs(r3).getLong("live.intent.extra.ROOM_ID");
        FeedItem r5 = this.a.getFeedItem(String.valueOf(r0));
        if (r5 != null) goto L10;
        return;
    L10:
        int r1 = this.a.pc().indexOf(r5);
        r5.banners = r4.banners;
        r5.setRoomFrom(r4);
        r5.setItem(r4.getItem());
        r5.logPb = r4.logPb;
        r5.object = r4.object;
        r5.repeatDisable = r4.repeatDisable;
        r5.resId = r4.resId;
        r5.searchId = r4.searchId;
        r5.tags = r4.tags;
        r5.searchReqId = r4.searchReqId;
        r5.type = r4.type;
        this.a.pc().updateAdapterItem(r1);
        return;
    L14:
        return;
    }

    public final void pullToRefresh(IPullable.IPullCallback<Integer> r2, IPullable.IPullCheck r3) {
        ItemRepository<FeedItem> r4 = this.a;
        if (r4 == null) goto L8;
        Listing<T> r5 = r4.pc();
        if (r5 == 0) goto L9;
        this.d = r2;
        r5.setReqFrom("detail_pull_refresh", null);
        r5.refresh();
        return;
    L9:
        return;
    }
}
