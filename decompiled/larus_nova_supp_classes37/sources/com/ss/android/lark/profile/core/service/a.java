package com.ss.android.lark.profile.core.service;

import com.larksuite.rucket.impl.serverimpl.annotation.ServerCall;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.pb.users.PatchUserMemoRequest;
import com.ss.android.lark.pb.users.PatchUserMemoResponse;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a {
    public static final C0106a a = null;

    /* JADX INFO: renamed from: com.ss.android.lark.profile.core.service.a$a, reason: collision with other inner class name */
    public static final class C0106a {
        public static final /* synthetic */ C0106a a = null;

        static {
            a = new C0106a();
        }

        public C0106a() {
        }

        public static a a() {
            return (a) ((com.ss.android.lark.profile.core.di.a) LazyKt.lazy(ProfileCoreServiceModel$profileNetClientGetter$2.INSTANCE).getValue()).Q4().create(a.class);
        }
    }

    static {
        a = C0106a.a;
    }

    @ServerCall(5036)
    RucketJob<PatchUserMemoResponse> saveAlias(PatchUserMemoRequest r1);
}
