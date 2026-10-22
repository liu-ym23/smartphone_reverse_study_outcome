package com.obric.aikernel.tob.api;

import android.content.Context;
import android.content.Intent;
import com.bytedance.news.common.service.manager.IService;
import com.obric.aikernel.sdk.config.RequestParams;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public interface IToBStrategyManager extends IService {
    public static final a Companion = null;
    public static final int REQUEST_HANDLED = 2;
    public static final int REQUEST_PASSED = 0;
    public static final int REQUEST_REJECTED = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f5572a = null;

        static {
            f5572a = new a();
        }

        private a() {
        }
    }

    static {
        Companion = a.f5572a;
    }

    void amendMemoryDataExtraInfo(JSONArray r10);

    void handleAIKServiceOnBind(Context r10, Intent r11);

    int injectRequest(RequestParams r10);
}
