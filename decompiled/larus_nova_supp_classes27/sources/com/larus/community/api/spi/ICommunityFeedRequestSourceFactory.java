package com.larus.community.api.spi;

import android.os.Bundle;
import com.larus.community.impl.applet.s;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import e29.c;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/larus/community/api/spi/ICommunityFeedRequestSourceFactory;", "", "create", "Lcom/larus/community/api/spi/CommunityFeedRequestSource;", "arguments", "Landroid/os/Bundle;", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICommunityFeedRequestSourceFactory {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static c a(Bundle r2) {
            ICommunityFeedRequestSourceFactory r0 = (ICommunityFeedRequestSourceFactory) ServiceManager.get().getService(ICommunityFeedRequestSourceFactory.class);
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.a(r2);
        }
    }

    static {
        a = a.a;
    }

    s a(Bundle r1);
}
