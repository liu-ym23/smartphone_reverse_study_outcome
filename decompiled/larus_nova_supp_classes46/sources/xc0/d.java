package xc0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    public static void a(String r5, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        List<k> r0 = r6.getResources();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.size() != 0) goto L10;
        return;
    L10:
        Iterator<k> r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L15;
        k r2 = r1.next();
        r2.getUrls();
        ArrayList r3 = new ArrayList();
        r3.add("file://" + r5 + r2.getUri());
        Unit r4 = Unit.INSTANCE;
        r2.setUrls(r3);
        goto L12
    L15:
        if (r6.getSoundUrl() == null) goto L19;
        r6.setSoundUrl("file://" + r5 + r6.getSoundUrl());
        return;
    }
}
