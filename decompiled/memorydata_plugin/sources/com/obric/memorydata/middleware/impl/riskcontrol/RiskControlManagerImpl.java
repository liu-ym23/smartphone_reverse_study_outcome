package com.obric.memorydata.middleware.impl.riskcontrol;

import android.content.Context;
import com.bytedance.securityguardkit.SecurityGuardKitManager;
import com.bytedance.securityguardkit.ai.ContentCategory;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bridge.ISecurityGuardAPI;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.riskcontrol.IRiskControlManager;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0000H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/middleware/impl/riskcontrol/RiskControlManagerImpl;", "Lcom/obric/memorydata/middleware/api/riskcontrol/IRiskControlManager;", "Lcom/obric/memorydata/middleware/api/bridge/ISecurityGuardAPI;", "<init>", "()V", "TAG", "", "getInst", "haveAppSearchSensitiveWordCategories", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "contentReviewByNLP", Params.CONTENT, "initSensitiveWordCategories", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RiskControlManagerImpl implements ISecurityGuardAPI, IRiskControlManager {
    public static final RiskControlManagerImpl INSTANCE = null;
    private static final String TAG = "RiskControlManagerImpl";

    static {
        RiskControlManagerImpl r0 = new RiskControlManagerImpl();
        INSTANCE = r0;
        r0.initSensitiveWordCategories();
    }

    private RiskControlManagerImpl() {
    }

    @JvmStatic
    public static final RiskControlManagerImpl getInst() {
        return INSTANCE;
    }

    private final void initSensitiveWordCategories() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "initSensitiveCategories start", false, 4, null);
        if (SecurityGuardKitManager.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).initSensitiveCategories(SetsKt.setOf(new String[]{"leader", "reactionary"})) == true) goto L5;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "initSensitiveCategories failed", null, 4, null);
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "initSensitiveCategories success", false, 4, null);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ISecurityGuardAPI
    public boolean contentReviewByNLP(String r11) {
        Intrinsics.checkNotNullParameter(r11, Params.CONTENT);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        Set<String> r1 = SecurityGuardKitManager.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).inferSensitiveContent(r11);
        if (r1 == null) goto L11;
        String r10 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")), String.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "contentReviewByNLP: " + r10, false, 4, null);
        if (r10 == null) goto L17;
        if (Intrinsics.areEqual(r10, ContentCategory.SECURITY.getCategoryName()) == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        return !haveAppSearchSensitiveWordCategories(r11);
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.memorydata.middleware.api.riskcontrol.IRiskControlManager
    public boolean haveAppSearchSensitiveWordCategories(String r10) {
        Intrinsics.checkNotNullParameter(r10, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == false) goto L8;
        return false;
    L8:
        Set<String> r11 = SecurityGuardKitManager.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).findSensitiveCategories(r10);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "haveAppSearchSensitiveWordCategories result:" + r11, false, 4, null);
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L11;
    L14:
        boolean r13 = true;
    L15:
        if (r13 == true) goto L27;
        Set r14 = SetsKt.setOf(new String[]{"leader", "reactionary"});
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L20;
    L22:
        Iterator r16 = r15.iterator();
    L24:
        if (r16.hasNext() == false) goto L27;
        if (r14.contains((String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin")) == false) goto L24;
        return true;
    L20:
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L22;
    L27:
        return false;
    L11:
        if (r12.isEmpty() == true) goto L14;
        r13 = false;
        goto L15
    L5:
        r9 = false;
        goto L6
    }
}
