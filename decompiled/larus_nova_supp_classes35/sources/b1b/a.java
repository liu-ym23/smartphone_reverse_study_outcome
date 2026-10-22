package b1b;

import android.webkit.WebView;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.LKAPIError;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleonv2.lkapi.biz.statistics.IBizStatistics$SendEventData;
import com.ss.android.lark.officesdk.utils.di.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends z0b.a {

    /* JADX INFO: renamed from: b1b.a$a, reason: collision with other inner class name */
    public static final class C0007a {
    }

    public final class b extends AbsChameleonHandler<IBizStatistics$SendEventData> {
        public long a;
        public long b;
        public long c;
        public long d;
        public long e;
        public final String f;

        public b() {
            this.f = LKAPIModules.Biz.Statistics.SendEvent.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.f;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(IBizStatistics$SendEventData r8, Callback r9) {
            IBizStatistics$SendEventData r10 = r8;
            Intrinsics.checkNotNullParameter(r10, "params");
            Intrinsics.checkNotNullParameter(r9, "callback");
            String r0 = r10.getEventType();
            long r1 = r10.getTimeStamp();
            IChameleonHandlerContext r3 = getContext();
            IChameleonHandlerContext r4 = null;
            if (r3 == null) goto L5;
            String r5 = r3.getSession();
        L6:
            j.e("LK_API_TAG_BizStatistics", "sendEvent eventType: " + r0 + ", timeStamp: " + r1 + ", session: " + r5);
            switch(r0.hashCode()) {
                case -1335757144: goto L37;
                case 22961241: goto L33;
                case 533049767: goto L29;
                case 1258430724: goto L25;
                case 1680455314: goto L14;
                case 1868695392: goto L10;
                default: goto L50;
            };
        L50:
            j.f("LK_API_TAG_BizStatistics", "unkown eventType");
        L51:
            r9.success(BuildConfig.FLAVOR);
            return;
        L10:
            if (r0.equals(ChameleonOpenTracker.EventType.PULL_DATA_END) == false) goto L50;
            this.c = r1;
            goto L51
        L14:
            if (r0.equals(ChameleonOpenTracker.EventType.RENDER_END) == false) goto L50;
            u1b.a.C0305a r2 = u1b.a.a(r5);
            if (r2 != null) goto L19;
            j.f("LK_API_TAG_BizStatistics", "sessionTracker is null");
            r9.error(new LKAPIError(-1, "sessionTracker is null"));
            return;
        L19:
            r2.c(ChameleonOpenTracker.Stage.PRELOAD, this.a);
            r2.d(ChameleonOpenTracker.Stage.PULLDATA, this.b);
            r2.c(ChameleonOpenTracker.Stage.PULLDATA, this.c);
            r2.d(ChameleonOpenTracker.Stage.RENDER, this.d);
            r2.d("preloadrender", this.a);
            r2.c("preloadrender", this.e);
            r2.c(ChameleonOpenTracker.Stage.RENDER, r1);
            Iterator<Map.Entry<String, String>> r11 = r10.getParams().entrySet().iterator();
        L21:
            if (r11.hasNext() == false) goto L23;
            Map.Entry<String, String> r6 = r11.next();
            r2.e.put(r6.getKey(), r6.getValue());
            goto L21
        L23:
            r2.a(ChameleonOpenTracker.OpenResult.SUCCESS, 0, r1);
            goto L51
        L25:
            if (r0.equals(ChameleonOpenTracker.EventType.RES_READY) == false) goto L50;
            this.a = r1;
            goto L51
        L29:
            if (r0.equals(ChameleonOpenTracker.EventType.PULL_DATA_START) == false) goto L50;
            this.b = r1;
            goto L51
        L33:
            if (r0.equals(ChameleonOpenTracker.EventType.RENDER_START) == false) goto L50;
            this.d = r1;
            goto L51
        L37:
            if (r0.equals("PRELOAD_RENDER_END") == false) goto L50;
            this.e = r1;
            IChameleonHandlerContext r12 = getContext();
            if (r12 == null) goto L42;
            WebView r13 = r12.getWebview();
        L44:
            if ((r13 instanceof IChameleonHandlerContext) == false) goto L46;
            r4 = (IChameleonHandlerContext) r13;
        L46:
            if (r4 == null) goto L51;
            IChameleonLoader r14 = r4.getWebviewLoader();
            if (r14 == null) goto L51;
            r14.onLoadSuccess();
            goto L51
        L42:
            r13 = null;
            goto L44
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> c() {
        return CollectionsKt.arrayListOf(new b[]{new b()});
    }

    public a() {
    }
}
