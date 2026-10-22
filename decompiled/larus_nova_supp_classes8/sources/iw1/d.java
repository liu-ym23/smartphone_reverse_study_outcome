package iw1;

import android.os.Bundle;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.android.livesdkapi.feed.NeedScrollList;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends ILiveRoomListProvider implements NeedScrollList {
    public final List<Bundle> a;
    public final List<Room> b;

    public final void alterSpecificItem(int r1, FeedItem r2) {
    }

    public final void loadMore(int r1) {
    }

    public final String providerType() {
        return "FixedRoomListProvider";
    }

    public final void updatePos(long r1) {
    }

    public final int size() {
        return ((ArrayList) this.a).size();
    }

    public final void release() {
        super.release();
        ((ArrayList) this.a).clear();
        ((ArrayList) this.b).clear();
    }

    public final List<Room> getRoomList() {
        return this.b;
    }

    public d(List<Room> r3) {
        ArrayList r0 = new ArrayList();
        this.a = r0;
        ArrayList r1 = new ArrayList();
        this.b = r1;
        r0.clear();
        r1.clear();
        if (Lists.isEmpty(r3) == true) goto L9;
        r1.addAll(r3);
        Iterator r4 = ((ArrayList) r3).iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        Room r2 = (Room) r4.next();
        List<Bundle> r5 = this.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(ArgumentsBuilder.buildRoomArgs(r2));
        goto L7
    L11:
        return;
    }

    public final Bundle getRoomArgs(int r2) {
        return (Bundle) ListProtector.get(this.a, r2);
    }

    public final int indexOf(Bundle r2) {
        return ((ArrayList) this.a).indexOf(r2);
    }

    public final void removeRoom(long r5) {
        int r0 = 0;
    L4:
        if (r0 >= ((ArrayList) this.a).size()) goto L12;
        if (((Room) ListProtector.get(this.b, r0)).getId() == r5) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        ListProtector.remove(this.a, r0);
        ListProtector.remove(this.b, r0);
        dispatchChange();
        return;
    }
}
