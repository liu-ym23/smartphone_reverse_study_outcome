package com.ss.android.lark.integrator.ccm.dependency.di;

import androidx.fragment.app.FragmentActivity;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class d1 implements sk5.b {
    public final b a;

    public static final class a {
    }

    public static final class b implements sk5.c {
        public b() {
        }

        public final boolean f(String r1) {
            return true;
        }

        public final boolean isDebugMode() {
            return false;
        }

        public final void b() {
            tt5.a.h("OfficeOnBoarding", "clearNativePreferenceCache ignored for office host");
        }

        public final Flowable<sk5.a> e() {
            return Flowable.empty();
        }

        public final Map<String, Boolean> h() {
            return Collections.emptyMap();
        }

        public final void c(String r3) {
            tt5.a.h("OfficeOnBoarding", "setMissionFinished ignored for office host, missionId=" + r3);
        }

        public final void d(com.bytedance.ee.bear.document.onboarding.b r3) {
            StringBuilder r0 = new StringBuilder("dismiss ignored for office host, mission=");
            if (r3 == null) goto L5;
            String r4 = r3.getId();
        L6:
            r0.append(r4);
            tt5.a.h("OfficeOnBoarding", r0.toString());
            return;
        L5:
            r4 = null;
            goto L6
        }

        public final void i(List<String> r3) {
            tt5.a.h("OfficeOnBoarding", "setMissionFinished(list) ignored for office host, size=" + Integer.valueOf(((ArrayList) r3).size()));
        }

        public final void a(tk5.d r2, com.bytedance.ee.bear.document.onboarding.c r3) {
            StringBuilder r4 = new StringBuilder("post(ui) ignored for office host, mission=");
            if (r2 == null) goto L5;
            String r5 = r2.getId();
        L6:
            r4.append(r5);
            tt5.a.h("OfficeOnBoarding", r4.toString());
            return;
        L5:
            r5 = null;
            goto L6
        }

        public final void g(tk5.d<vk5.a> r2, FragmentActivity r3) {
            StringBuilder r4 = new StringBuilder("post(activity) ignored for office host, mission=");
            if (r2 == null) goto L5;
            String r5 = r2.getId();
        L6:
            r4.append(r5);
            tt5.a.h("OfficeOnBoarding", r4.toString());
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
    }

    public final void a() {
        tt5.a.h("OfficeOnBoarding", "onDocInit ignored for office host");
    }

    @Inject
    public d1() {
        this.a = new b();
    }

    public final sk5.c b() {
        return this.a;
    }

    public final void init(Map r3) {
        StringBuilder r0 = new StringBuilder("init ignored for office host, colorStyleSize=");
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.size());
    L6:
        r0.append(r4);
        tt5.a.h("OfficeOnBoarding", r0.toString());
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void c(String r2, String r3) {
        tt5.a.h("OfficeOnBoarding", "changeUserAccount ignored for office host, uid=" + r3);
    }
}
