package com.ss.android.lark.feed.shared.data;

import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UpdateRecord {
    public long a;
    public List<UIFeedCard> b;
    public boolean c;
    public boolean d;
    public String e;
    public List<ICache$Operation> f;
    public FeedFolder g;
    public FeedFolder h;
    public Map<FeedFolder, UpdateRecord> i;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FeedPacketType {
        public static final int DONE = 1;
        public static final int FILTER = 3;
        public static final int HEADER = 2;
        public static final int INBOX = 0;
    }

    public UpdateRecord() {
        this.d = false;
    }

    public final void a(List<UIFeedCard> r3) {
        ArrayList r0 = new ArrayList();
        Iterator<UIFeedCard> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        UIFeedCard r1 = r4.next();
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        this.b = r0;
    }
}
