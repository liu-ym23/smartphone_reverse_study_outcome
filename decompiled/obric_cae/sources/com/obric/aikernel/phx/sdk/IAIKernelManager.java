package com.obric.aikernel.phx.sdk;

import androidx.annotation.Keep;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import ta.d;
import xd.e;
import xd.j;

/* JADX INFO: loaded from: classes.dex */
@Keep
public interface IAIKernelManager {
    public static final a Companion = null;
    public static final String PACKAGE_NAME_AIK = "com.obric.aikernel";
    public static final String PACKAGE_NAME_ASSIST = "com.larus.nova";
    public static final String SERVICE_NAME = "com.obric.aikernel.AIKernelService";
    public static final String TAG = "AIKernelManager";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f5237a = null;

        static {
            f5237a = new a();
        }
    }

    public static final class b {
        public static /* synthetic */ Object a(IAIKernelManager r8, String r10, RequestParams r11, d.b r12) {
            return r8.loadPackage(r10, false, r11, r12);
        }
    }

    static {
        Companion = a.f5237a;
    }

    Object clearAIKernelData(RequestParams r8, ae.d<? super j> r10);

    /* JADX INFO: renamed from: getPackage-0E7RQCE */
    Object mo9getPackage0E7RQCE(String r8, RequestParams r10, ae.d<? super e<PackageResource>> r11);

    Object loadPackage(String r8, boolean r10, RequestParams r11, ae.d<? super IBaseModel> r12);

    /* JADX INFO: renamed from: updatePackage-0E7RQCE */
    Object mo10updatePackage0E7RQCE(PackageResource r8, RequestParams r10, ae.d<? super e<PackageResource>> r11);
}
