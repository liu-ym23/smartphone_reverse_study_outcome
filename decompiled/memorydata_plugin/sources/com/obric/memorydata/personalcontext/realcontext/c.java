package com.obric.memorydata.personalcontext.realcontext;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.ak;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/personalcontext/realcontext/RCStateSearchExecutor;", "", "<init>", "()V", "TAG", "", "defaultAIProactiveStateList", "", "searchAIProactiveState", "featureNameList", ObricMemoryConstants.KEY_PACKAGE_NAME, "hasFineLocationPermission", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12262a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f12263b = null;

    static {
        f12262a = new c();
        f12263b = CollectionsKt.listOf(new String[]{"LOCATION", "LOCATION_TYPE", "HOME_LOCATIONS", "COMPANY_LOCATIONS", "MOVEMENT_TYPE"});
    }

    private c() {
    }

    public static final /* synthetic */ List a() {
        return f12263b;
    }

    private final boolean a(String r11) {
        boolean r10 = ak.f13164a.g(r11).contains("android.permission.ACCESS_FINE_LOCATION");
        if (r10 == true) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RCStateSearchExecutor", r11 + " searchAIProactiveState, privacy not agree", false, 4, null);
    L5:
        if (r10 == true) goto L7;
    L11:
        return r10;
    L7:
        if (Intrinsics.areEqual(r11, AppInfo.OAuto.getPackageName()) == false) goto L11;
        r10 = ak.f13164a.g(AppInfo.OAssistant.getPackageName()).contains("android.permission.ACCESS_FINE_LOCATION");
        if (r10 == true) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RCStateSearchExecutor", AppInfo.OAssistant.getPackageName() + " searchAIProactiveState, privacy not agree", false, 4, null);
        goto L11
    }

    public final String a(List<String> r4, String r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r8 == true) goto L11;
    L13:
        return "";
    L11:
        if (a(r5) == false) goto L13;
        JSONObject r3 = new JSONObject();
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new RCStateSearchExecutor$searchAIProactiveState$1(r3, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        String r9 = r3.toString();
        Intrinsics.checkNotNull(r9);
        return r9;
    L5:
        if (r7.isEmpty() == true) goto L8;
        r8 = false;
        goto L9
    }
}
