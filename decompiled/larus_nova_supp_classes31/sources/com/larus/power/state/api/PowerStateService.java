package com.larus.power.state.api;

import android.content.Context;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import wr9.g;
import wr9.h;
import wr9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/larus/power/state/api/PowerStateService;", "Lcom/larus/power/state/api/PowerStateProvider;", "initialize", "", "context", "Landroid/content/Context;", "openSession", "Lcom/larus/power/state/api/PowerStateSession;", "config", "Lcom/larus/power/state/api/PowerStateMonitorConfig;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface PowerStateService extends h {
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

    i a(g r1);

    void initialize(Context r1);
}
