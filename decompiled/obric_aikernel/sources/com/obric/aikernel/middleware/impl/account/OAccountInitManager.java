package com.obric.aikernel.middleware.impl.account;

import a9.d;
import androidx.core.app.NotificationCompat;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.obric.aikernel.middleware.api.account.IOAccountManager;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.impl.network.AppNetConfigImpl;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import com.obric.matrix.platform.sdk.ones.account.i;
import java.util.ArrayList;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class OAccountInitManager implements IOAccountManager {
    public static final OAccountInitManager INSTANCE = null;
    private static final String TAG = null;

    public static final class a implements a9.a {
        public a() {
        }

        @Override // a9.a
        public ArrayList<String> addTokenHost() {
            return CollectionsKt.arrayListOf(new String[]{"oceancloudapi.com", "os.oceancloudapi.com", "os-boe.bytedance.net", AppNetConfigImpl.INSTANCE.getBaseUrl()});
        }
    }

    public static final class b implements z8.a {
        b() {
        }

        @Override // z8.a
        public String a() {
            return String.valueOf(AppContext.INSTANCE.getAid());
        }

        @Override // z8.a
        public String b() {
            return AppContext.INSTANCE.getVersionName();
        }

        @Override // z8.a
        public void c(String r10, String r11, Throwable r12) {
            Intrinsics.checkNotNullParameter(r10, "tag");
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
            AIKLog r13 = AIKLog.INSTANCE;
            StringBuilder r14 = new StringBuilder();
            r14.append(r11);
            if (r12 == null) goto L5;
            String r15 = ExceptionsKt.stackTraceToString(r12);
        L6:
            r14.append(r15);
            r13.d(r10, r14.toString());
            return;
        L5:
            r15 = null;
            goto L6
        }

        @Override // z8.a
        public void d(String r10, String r11, Throwable r12) {
            Intrinsics.checkNotNullParameter(r10, "tag");
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
            AIKLog r13 = AIKLog.INSTANCE;
            StringBuilder r14 = new StringBuilder();
            r14.append(r11);
            if (r12 == null) goto L5;
            String r15 = ExceptionsKt.stackTraceToString(r12);
        L6:
            r14.append(r15);
            r13.e(r10, r14.toString());
            return;
        L5:
            r15 = null;
            goto L6
        }

        @Override // z8.a
        public boolean e() {
            return false;
        }

        @Override // z8.a
        public String f() {
            return AppContext.INSTANCE.getServerDeviceId();
        }
    }

    public static final class c implements d {
        c() {
        }

        @Override // a9.d
        public void a(String r10, String r11, Throwable r12) {
            Intrinsics.checkNotNullParameter(r10, "tag");
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
            AIKLog r13 = AIKLog.INSTANCE;
            StringBuilder r14 = new StringBuilder();
            r14.append(r11);
            if (r12 == null) goto L5;
            String r15 = ExceptionsKt.stackTraceToString(r12);
        L6:
            r14.append(r15);
            r13.d(r10, r14.toString());
            return;
        L5:
            r15 = null;
            goto L6
        }

        @Override // a9.d
        public void b(String r10, String r11, Throwable r12) {
            Intrinsics.checkNotNullParameter(r10, "tag");
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
            AIKLog r13 = AIKLog.INSTANCE;
            StringBuilder r14 = new StringBuilder();
            r14.append(r11);
            if (r12 == null) goto L5;
            String r15 = ExceptionsKt.stackTraceToString(r12);
        L6:
            r14.append(r15);
            r13.i(r10, r14.toString());
            return;
        L5:
            r15 = null;
            goto L6
        }

        @Override // a9.d
        public void e(String r10, String r11, Throwable r12) {
            Intrinsics.checkNotNullParameter(r10, "tag");
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
            AIKLog r13 = AIKLog.INSTANCE;
            StringBuilder r14 = new StringBuilder();
            r14.append(r11);
            if (r12 == null) goto L5;
            String r15 = ExceptionsKt.stackTraceToString(r12);
        L6:
            r14.append(r15);
            r13.e(r10, r14.toString());
            return;
        L5:
            r15 = null;
            goto L6
        }

        @Override // a9.d
        public void w(String r10, String r11, Throwable r12) {
            Intrinsics.checkNotNullParameter(r10, "tag");
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
            AIKLog r13 = AIKLog.INSTANCE;
            StringBuilder r14 = new StringBuilder();
            r14.append(r11);
            if (r12 == null) goto L5;
            String r15 = ExceptionsKt.stackTraceToString(r12);
        L6:
            r14.append(r15);
            r13.w(r10, r14.toString());
            return;
        L5:
            r15 = null;
            goto L6
        }
    }

    static {
        OAccountInitManager r10 = new OAccountInitManager();
        INSTANCE = r10;
        TAG = r10.getClass().getSimpleName();
    }

    private OAccountInitManager() {
    }

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }

    @JvmStatic
    public static final OAccountInitManager getInst() {
        return INSTANCE;
    }

    @Override // com.obric.aikernel.middleware.api.account.IOAccountManager
    public ArrayList<String> addTokenHost() {
        if (OAccountHelper.f4551a.h() == false) goto L6;
        return OAccount.f5801a.e().addTokenHost();
    L6:
        return new ArrayList();
    }

    @Override // com.obric.aikernel.middleware.api.account.IOAccountManager
    public void init() {
        z8.c r10 = z8.c.f13804a;
        AppContext r11 = AppContext.INSTANCE;
        r10.f(r11.getApplication(), new b());
        r10.c(AIKLog.INSTANCE.isDebug());
        OAccountHelper.f4551a.f(r11.getApplication(), new c(), new a());
        RetrofitUtils.a(new com.obric.aikernel.middleware.impl.account.a());
    }

    @Override // com.obric.aikernel.middleware.api.account.IOAccountManager
    public Map<String, String> xttTokenMap() {
        return i.f5848c.j();
    }
}
