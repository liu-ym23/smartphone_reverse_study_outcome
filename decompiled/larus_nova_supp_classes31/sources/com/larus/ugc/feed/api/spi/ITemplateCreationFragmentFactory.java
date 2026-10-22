package com.larus.ugc.feed.api.spi;

import com.larus.ugc.feed.impl.template.TemplateCreationFragment;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import zp9.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/larus/ugc/feed/api/spi/ITemplateCreationFragmentFactory;", "", "create", "Landroidx/fragment/app/Fragment;", "interceptor", "Lcom/larus/platform/api/creation/ICreationFeedActionInterceptor;", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface ITemplateCreationFragmentFactory {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        a = a.a;
    }

    TemplateCreationFragment a(m r1);
}
