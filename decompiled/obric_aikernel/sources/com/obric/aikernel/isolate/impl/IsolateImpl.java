package com.obric.aikernel.isolate.impl;

import android.os.Bundle;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.isolate.api.IIsolateApi;
import com.obric.aikernel.utils.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class IsolateImpl implements IIsolateApi {
    private static final String DEBUG_CHECK_PKG_RES = "debug_check_pkg_res";
    private static final String DEBUG_DELETE_DEBUG_PKG = "debug_del_debug_pkg";
    private static final String DEBUG_KEY_MODE = "debug_mode_switch";
    private static final String DEBUG_KEY_RUN_ONLY_BIZ = "run_only_biz";
    private static final String DEBUG_KEY_TEST_PROVISION = "test_provision";
    public static final IsolateImpl INSTANCE = null;
    private static final Lazy cached_run_only_biz$delegate = null;
    private static final Lazy cached_test_provision_biz$delegate = null;

    public static final class a implements k7.a {
        a() {
        }

        @Override // k7.a
        public String a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "key");
            return com.obric.aikernel.isolate.impl.a.f4485a.a().a(r10);
        }

        @Override // k7.a
        public boolean b() {
            return com.obric.aikernel.isolate.impl.a.f4485a.a().getBoolean("keva_key_debug_test_memory_mode", false);
        }

        @Override // k7.a
        public boolean c() {
            return com.obric.aikernel.isolate.impl.a.f4485a.a().getBoolean(IsolateImpl.DEBUG_DELETE_DEBUG_PKG, true);
        }

        @Override // k7.a
        public boolean d() {
            return com.obric.aikernel.isolate.impl.a.f4485a.a().getBoolean(IsolateImpl.DEBUG_CHECK_PKG_RES, true);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.isolate.impl.IsolateImpl$isSysAikernelSwitchEnabled$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<String, String, String> {
        AnonymousClass1(Object r10) {
            super(2, r10, k.class, "getSystemProperty", "getSystemProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ String invoke(String r10, String r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "p0");
            return ((k) this.receiver).b(r10, r11);
        }
    }

    static {
        INSTANCE = new IsolateImpl();
        cached_run_only_biz$delegate = LazyKt.lazy(IsolateImpl$cached_run_only_biz$2.INSTANCE);
        cached_test_provision_biz$delegate = LazyKt.lazy(IsolateImpl$cached_test_provision_biz$2.INSTANCE);
    }

    private IsolateImpl() {
    }

    public static final /* synthetic */ String access$getSystemSysProperty(IsolateImpl r10, String r11, String r12) {
        return r10.getSystemSysProperty(r11, r12);
    }

    private final String getCached_run_only_biz() {
        return (String) cached_run_only_biz$delegate.getValue();
    }

    private final String getCached_test_provision_biz() {
        return (String) cached_test_provision_biz$delegate.getValue();
    }

    @JvmStatic
    public static final IsolateImpl getInst() {
        return INSTANCE;
    }

    private final String getSystemDebugProperty(String r10, String r11) {
        return k.f5601a.b("debug.aikernel." + r10, r11);
    }

    static /* synthetic */ String getSystemDebugProperty$default(IsolateImpl r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = null;
    L6:
        return r10.getSystemDebugProperty(r11, r12);
    }

    private final String getSystemSysProperty(String r10, String r11) {
        return k.f5601a.b("sys.aikernel." + r10, r11);
    }

    static /* synthetic */ String getSystemSysProperty$default(IsolateImpl r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = null;
    L6:
        return r10.getSystemSysProperty(r11, r12);
    }

    @Override // com.obric.aikernel.isolate.api.IIsolateApi
    public k7.a debugKV() {
        return new a();
    }

    @Override // com.obric.aikernel.isolate.api.IIsolateApi
    public boolean interceptByDebugMode(Bundle r10) {
        Intrinsics.checkNotNullParameter(r10, "args");
        String r11 = r10.getString(IdlKeys.Args_BizName, "");
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == true) goto L15;
        IIsolateApi r13 = k7.b.a();
        if (r13 == null) goto L15;
        Intrinsics.checkNotNullExpressionValue(r11, "biz");
        if (r13.isOnlyRunBizFromProp(r11) == true) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r11.length() == 0) goto L8;
        r12 = false;
        goto L9
    }

    @Override // com.obric.aikernel.isolate.api.IIsolateApi
    public boolean isOnlyRunBizFromProp(String r10) {
        Intrinsics.checkNotNullParameter(r10, "biz");
        String r11 = getCached_run_only_biz();
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L11;
        return true;
    L11:
        if (Intrinsics.areEqual(r11, "null") == false) goto L14;
        return true;
    L14:
        return StringsKt.split$default(r11, new String[]{","}, false, 0, 6, null).contains(r10);
    L5:
        if (r11.length() == 0) goto L8;
        r12 = false;
        goto L9
    }

    @Override // com.obric.aikernel.isolate.api.IIsolateApi
    public boolean isSysAikernelSwitchEnabled(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return b.a(r10, r11, new AnonymousClass1(k.f5601a));
    }

    @Override // com.obric.aikernel.isolate.api.IIsolateApi
    public boolean testProvisionBizFromProp(String r10) {
        Intrinsics.checkNotNullParameter(r10, "biz");
        String r11 = getCached_test_provision_biz();
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r11, "null") == false) goto L14;
        return false;
    L14:
        return StringsKt.split$default(r11, new String[]{","}, false, 0, 6, null).contains(r10);
    L5:
        if (r11.length() == 0) goto L8;
        r12 = false;
        goto L9
    }
}
