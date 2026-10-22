package com.larus.bmhome.rc;

import com.bytedance.keva.Keva;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public static final g a = null;
    public static final Keva b = null;

    public static final class a {
        public final FlowResourceScene a;
        public final FlowResourceType b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "CacheTokenKey(scene=" + this.a + ", type=" + this.b + ')';
        }

        public final FlowResourceType getType() {
            return this.b;
        }

        public a(FlowResourceScene r2, FlowResourceType r3) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            Intrinsics.checkNotNullParameter(r3, "type");
            this.a = r2;
            this.b = r3;
        }
    }

    public g() {
    }

    static {
        a = new g();
        b = Keva.getRepo("resource_center_upload_keva", 0);
    }

    public static String a(a r4) {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L7;
        r0.getAccountService();
        boolean r1 = true;
        if (com.larus.home.impl.sdk.d.a.a() != true) goto L7;
    L8:
        if (r1 == false) goto L10;
        String r2 = "_minor";
    L11:
        StringBuilder r3 = new StringBuilder("upload_token_data_");
        FlowResourceScene.a r5 = FlowResourceScene.Companion;
        FlowResourceScene r6 = r4.a;
        r5.getClass();
        r3.append(FlowResourceScene.a.b(r6));
        r3.append('_');
        r3.append(r4.getType().getValue());
        r3.append(r2);
        return r3.toString();
    L10:
        r2 = "";
    L7:
        r1 = false;
        goto L8
    }

    public static void b(a r3) {
        Intrinsics.checkNotNullParameter(r3, "cacheKey");
        if (d(r3) == false) goto L6;
        FLogger.a.i("ResourceCenterUploadTokenCache", "clear cache token");
        b.storeString(a(r3), "");
        return;
    }

    public static void c(boolean r3) {
        o r0 = o.a;
        JSONObject r1 = new JSONObject();
        if (r3 == false) goto L5;
        String r4 = "1";
    L6:
        r1.put("cached", r4);
        r1.put("resource_center_enabled", true);
        Unit r5 = Unit.INSTANCE;
        r0.reportEvent("uploader_token_used", r1);
        return;
    L5:
        r4 = TriggerSendLoading.NO_LOADING;
        goto L6
    }

    public static boolean d(a r2) {
        if (r2.a != FlowResourceScene.Unknown) goto L5;
    L7:
        return false;
    L5:
        if (r2.getType() == FlowResourceType.Unknown) goto L7;
        return true;
    }
}
