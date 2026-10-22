package com.obric.memorydata.personalcontext.search.a;

import com.obric.memorydata.database.entity.jg;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/userprofile/MemoryProfileSearch;", "", "<init>", "()V", "TAG", "", "appPkgName2SupportedProfileKey", "", "", "searchUserProfileMemory", "callPkg", "profileKey", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12276a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, List<String>> f12277b = null;

    static {
        f12276a = new a();
        f12277b = MapsKt.mapOf(TuplesKt.to("com.obric.smartnotification", CollectionsKt.listOf("high_priority_notification")));
    }

    private a() {
    }

    public final String a(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "callPkg");
        Intrinsics.checkNotNullParameter(r12, "profileKey");
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r10 = true;
    L7:
        if (r10 == false) goto L11;
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r7 = null;
        int r8 = 4;
        Object r9 = null;
        String r5 = "MemoryProfileSearch";
        String r6 = "empty profileKey";
    L9:
        IRunLog.a.a(r4, r5, r6, r7, r8, r9);
        return null;
    L11:
        List r13 = (List) ZeusTransformUtils.preCheckCast(f12277b.get(r11), List.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L14;
    L16:
        r1 = false;
    L17:
        if (r1 == true) goto L19;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r6 = "not support profileKey " + r12 + " for app " + r11;
        r7 = null;
        r8 = 4;
        r9 = null;
        r5 = "MemoryProfileSearch";
        goto L9
    L19:
        jg r14 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileMemoryDao().queryOneRecordBy(r12);
        if (r14 != null) goto L22;
        return null;
    L22:
        return r14.b();
    L14:
        if (r13.contains(r12) != true) goto L16;
    L5:
        r10 = false;
        goto L7
    }
}
