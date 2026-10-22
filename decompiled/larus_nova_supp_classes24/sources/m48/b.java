package m48;

import androidx.fragment.app.Fragment;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import k54.c;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import pr9.d;
import pr9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements h {
    public final d54.a a;

    public static final class a {
    }

    /* JADX INFO: renamed from: m48.b$b, reason: collision with other inner class name */
    public static final class C0116b implements c {
        public final /* synthetic */ d a;
        public final /* synthetic */ pr9.b b;
        public final /* synthetic */ b c;

        /* JADX INFO: renamed from: m48.b$b$a */
        public static final class a implements b54.a {
            public final /* synthetic */ d a;

            public final void onRefreshFinish() {
                d r0 = this.a;
                if (r0 == null) goto L6;
                r0.onRefreshFinish();
                return;
            }

            public final void onRefreshStartManually() {
                d r0 = this.a;
                if (r0 == null) goto L6;
                r0.onRefreshStartManually();
                return;
            }

            public final void onReleaseAndRefresh() {
                d r0 = this.a;
                if (r0 == null) goto L6;
                r0.onReleaseAndRefresh();
                return;
            }

            public final void onReleaseAndScrollBack() {
                d r0 = this.a;
                if (r0 == null) goto L6;
                r0.onReleaseAndScrollBack();
                return;
            }

            public a(d r1) {
                this.a = r1;
            }

            public final void onOverScroll(float r1, float r2) {
                d r3 = this.a;
                if (r3 == null) goto L6;
                r3.g();
                return;
            }
        }

        public final void g(String r2) {
            Intrinsics.checkNotNullParameter(r2, "aid");
        }

        public final b54.a a() {
            return new a(this.a);
        }

        public final void onLoadSuccess() {
            this.b.onLoadSuccess();
        }

        public final void j(k54.b r6) {
            Intrinsics.checkNotNullParameter(r6, "event");
            pr9.b r0 = this.b;
            this.c.getClass();
            if ((r6 instanceof k54.b.c) == false) goto L6;
            CustomFeedPlayerEvent.FirstFrame r1 = new CustomFeedPlayerEvent.FirstFrame(r6.a, r6.b);
        L44:
            r0.b(r1);
            return;
        L6:
            if ((r6 instanceof k54.b.h) == false) goto L9;
            r1 = new CustomFeedPlayerEvent.StartPlay(r6.a, r6.b);
            goto L44
        L9:
            if ((r6 instanceof k54.b.i) == false) goto L11;
            r1 = new CustomFeedPlayerEvent.StopPlay(r6.a, r6.b);
            goto L44
        L11:
            int r2 = 0;
            Integer r4 = null;
            if ((r6 instanceof k54.b.d) == false) goto L24;
            Map r3 = r6.c;
            if (r3 == null) goto L16;
            Object r5 = r3.get("reason");
        L18:
            if ((r5 instanceof Integer) == false) goto L20;
            r4 = (Integer) r5;
        L20:
            if (r4 == null) goto L22;
            r2 = r4.intValue();
        L22:
            r1 = new CustomFeedPlayerEvent.PausePlay(r6.a, r6.b, r2);
            goto L44
        L16:
            r5 = null;
            goto L18
        L24:
            if ((r6 instanceof k54.b.g) == false) goto L36;
            Map r7 = r6.c;
            if (r7 == null) goto L28;
            Object r8 = r7.get("reason");
        L30:
            if ((r8 instanceof Integer) == false) goto L32;
            r4 = (Integer) r8;
        L32:
            if (r4 == null) goto L34;
            r2 = r4.intValue();
        L34:
            r1 = new CustomFeedPlayerEvent.ResumePlay(r6.a, r6.b, r2);
            goto L44
        L28:
            r8 = null;
            goto L30
        L36:
            if ((r6 instanceof k54.b.b) == false) goto L39;
            r1 = new CustomFeedPlayerEvent.CompletePlay(r6.a, r6.b);
            goto L44
        L39:
            if ((r6 instanceof k54.b.f) == false) goto L42;
            r1 = new CustomFeedPlayerEvent.RestartPlay(r6.a, r6.b);
            goto L44
        L42:
            if ((r6 instanceof k54.b.e) == false) goto L47;
            r1 = new CustomFeedPlayerEvent.PlayError(r6.a, r6.b);
            goto L44
        L47:
            throw new NoWhenBranchMatchedException();
        }

        public final void onLoadError(String r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            this.b.onLoadError(r2);
        }

        public C0116b(d r1, pr9.b r2, b r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void e(boolean r3, String r4, k54.a r5) {
            Intrinsics.checkNotNullParameter(r4, "aid");
            Intrinsics.checkNotNullParameter(r5, "feedItemInfo");
            FLogger.a.d("CustomIRecFeedFragment", "notifyFeedChange: ");
            this.b.c(r3, r4);
        }
    }

    static {
    }

    public final void N7() {
        this.a.N7();
    }

    public final void V5() {
        this.a.V5();
    }

    public final Fragment f() {
        return this.a.f();
    }

    public final boolean onBackPressed() {
        Boolean r0 = this.a.onBackPressed();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public b(d54.a r2) {
        Intrinsics.checkNotNullParameter(r2, "iRecFeedFragment");
        this.a = r2;
    }

    public final void xQ(pr9.b r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        d r0 = r4.a();
        this.a.RF(new C0116b(r0, r4, this));
    }
}
