package com.obric.memorydata.personalcontext.datausage.plugin.action.manager;

import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004J'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00018\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/IMemoryIntentExecutor;", com.tom_roush.pdfbox.pdmodel.a.d.i.m, "Lcom/obric/capabilitykit/common/intent/IntentParams;", "R", "", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", TrackerImpl.PARAMS, "questionId", "", "(Lcom/obric/capabilitykit/common/intent/IntentParams;Ljava/lang/Long;)Lcom/obric/capabilitykit/common/intent/IntentResult;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface d<P extends IntentParams, R> {
    IntentResult<R> a(P r1, Long r2);
}
