package com.larus.bmhome.bigimg;

import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.PublisherTrackParams;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u1 {
    public u1() {
    }

    public static void a(PublisherCreation r4, PublisherTrackParams r5) {
        if (r4 != null) goto L6;
        FLogger.a.e("PublishHelper", "publisherCreation is null");
        return;
    L6:
        FLogger.a.i("PublishHelper", "gotoPublisher: type:" + r4.getCreationType());
        com.larus.platform.service.e0.a.a1(r4, r5);
    }
}
