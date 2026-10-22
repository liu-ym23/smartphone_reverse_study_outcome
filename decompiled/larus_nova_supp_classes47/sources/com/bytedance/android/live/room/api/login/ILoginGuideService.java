package com.bytedance.android.live.room.api.login;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.ies.sdk.widgets.DataCenter;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import q61.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.login.LoginGuideService")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \n2\u00020\u0001:\u0001\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0014\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/room/api/login/ILoginGuideService;", "Lcom/bytedance/android/live/base/IService;", "Lq61/b;", "entrance", "", "intercept", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lq61/a;", "createAutoLoginGuideLauncher", "Companion", "a", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILoginGuideService extends IService {
    public static final a Companion = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.room.api.login.ILoginGuideService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            a r0 = ILoginGuideService.Companion;
        }

        @JvmStatic
        public static ILoginGuideService ins() {
            ILoginGuideService.Companion.getClass();
            return a.a();
        }
    }

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        @JvmStatic
        public static ILoginGuideService a() {
            return (ILoginGuideService) k.f(ILoginGuideService.class);
        }
    }

    static {
        Companion = a.a;
    }

    q61.a createAutoLoginGuideLauncher(DataCenter r1);

    boolean intercept(b r1);
}
