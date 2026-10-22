package com.obric.aikernel.middleware.api.traker;

import com.bytedance.news.common.service.manager.IService;
import org.json.JSONObject;
import u7.b;

/* JADX INFO: loaded from: classes2.dex */
public interface ITrackerApi extends IService {
    public static final String CALLER_PKG = "caller_pkg";
    public static final a Companion = null;
    public static final String TAG = "TrackerEvent";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f4550a = null;

        static {
            f4550a = new a();
        }

        private a() {
        }
    }

    static {
        Companion = a.f4550a;
    }

    void flush();

    void monitorEvent(String r10, JSONObject r11, JSONObject r12, JSONObject r13);

    void onEvent(String r10, JSONObject r11);

    void registerIntercept(b r10, boolean r11);
}
