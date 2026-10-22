package com.obric.aikernel.phx.sdk;

import androidx.annotation.Keep;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface IAIKernelManager {
    public static final a Companion = null;
    public static final String PACKAGE_NAME_AIK = "com.obric.aikernel";
    public static final String PACKAGE_NAME_ASSIST = "com.larus.nova";
    public static final String SERVICE_NAME = "com.obric.aikernel.AIKernelService";
    public static final String TAG = "AIKernelManager";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f4812a = null;

        static {
            f4812a = new a();
        }

        private a() {
        }
    }

    public static final class b {
        public static /* synthetic */ Object a(IAIKernelManager r10, String r11, boolean r12, RequestParams r13, Continuation r14, int r15, Object r16) {
            if (r16 != null) goto L12;
            if ((r15 & 2) == 0) goto L7;
            r12 = false;
        L7:
            if ((r15 & 4) == 0) goto L10;
            r13 = new RequestParams(null, null, 3, null);
        L10:
            return r10.loadPackage(r11, r12, r13, r14);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadPackage");
        }
    }

    static {
        Companion = a.f4812a;
    }

    Object clearAIKernelData(RequestParams r10, Continuation<? super Unit> r11);

    /* JADX INFO: renamed from: getPackage-0E7RQCE */
    Object mo23getPackage0E7RQCE(String r10, RequestParams r11, Continuation<? super Result<PackageResource>> r12);

    Object loadPackage(String r10, boolean r11, RequestParams r12, Continuation<? super IBaseModel> r13);

    /* JADX INFO: renamed from: updatePackage-0E7RQCE */
    Object mo24updatePackage0E7RQCE(PackageResource r10, RequestParams r11, Continuation<? super Result<PackageResource>> r12);
}
