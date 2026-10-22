package com.bytedance.ai.process.resource;

import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.c0;
import java.util.Map;
import java.util.concurrent.Executors;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e1 f2457a = null;

    static {
        f2457a = new e1(Executors.newSingleThreadExecutor());
    }

    public static Object a(String r10, String r11, AIPackage.AIPackageType r12, Map r13, Continuation r14) {
        AIManagerRemoteProxy$loadAIPackageFromServer$2 r15 = new AIManagerRemoteProxy$loadAIPackageFromServer$2(r10, r11, r12, r13, null);
        return BuildersKt.withContext(f2457a, r15, r14);
    }

    public static void b(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, Constant.APPID);
        BuildersKt.launch$default(h0.a(f2457a), null, null, new AIManagerRemoteProxy$markInUseFromClient$1(r10, r11, null), 3, null);
    }

    public static void c(String r10, String r11, c0 r12) {
        Intrinsics.checkNotNullParameter(r11, "url");
        Intrinsics.checkNotNullParameter(r12, "callback");
        BuildersKt.launch$default(h0.a(f2457a), null, null, new AIManagerRemoteProxy$getAIResourceFileDescriptor$1(r12, r10, r11, null), 3, null);
    }

    public static void d(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, Constant.APPID);
        BuildersKt.launch$default(h0.a(f2457a), null, null, new AIManagerRemoteProxy$onMarkOutOfUseFromClient$1(r10, r11, null), 3, null);
    }
}
