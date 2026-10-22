package com.obric.memorydata.memory.ui.automemory.create;

import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.dao.MemoryRuleDao;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryViewModel;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u0016\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/create/AutoMemoryCollectionRuleUtils;", "", "<init>", "()V", "TAG", "", "SOURCE_AI_PROACTIVE", "scope", "Lkotlinx/coroutines/CoroutineScope;", "createCollectionRule", "", "title", Params.CONTENT, "deleteCollectionRule", "", "ruleId", "updateCollectionRule", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10659a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f10660b = null;

    static {
        f10659a = new a();
        f10660b = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
    }

    private a() {
    }

    public final long a(String r29, String r30) {
        Intrinsics.checkNotNullParameter(r29, "title");
        Intrinsics.checkNotNullParameter(r30, Params.CONTENT);
        long r0 = MemoryRuleDao.DefaultImpls.insertMyCollection$default(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao(), StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r29, CharSequence.class, "com.obric.memorydata.plugin")).toString(), StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r30, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(g.f10670a.a(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null), AutoMemoryViewModel.SOURCE_AI_PROACTIVE, false, null, null, null, false, false, 0, 2032, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryCollectionRuleUtils", "createCollectionRule originRuleId:" + r0, false, 4, null);
        if (r0 <= 0) goto L5;
        AutoMemoryCollectionAiTaskQueue.f10615a.a(r0);
    L5:
        return r0;
    }

    public final boolean a(long r8) {
        if (MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().deleteById(r8) <= 0) goto L5;
        boolean r7 = true;
    L7:
        if (r7 == false) goto L9;
        i.a(f10660b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionRuleUtils$deleteCollectionRule$1(r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    L10:
        return r7;
    L9:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryCollectionRuleUtils", "deleteCollectionRule failed, ruleId:" + r8, null, 4, null);
        goto L10
    L5:
        r7 = false;
        goto L7
    }

    public final boolean a(long r11, String r13) {
        Intrinsics.checkNotNullParameter(r13, Params.CONTENT);
        if (MemoryRuleDao.DefaultImpls.updateMyCollection$default(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao(), r11, null, StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).toString(), null, false, 16, null) <= 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L8;
        AutoMemoryCollectionAiTaskQueue.f10615a.a(r11);
    L9:
        return r10;
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AutoMemoryCollectionRuleUtils", "updateCollectionRule failed, ruleId:" + r11, null, 4, null);
        goto L9
    L5:
        r10 = false;
        goto L6
    }
}
