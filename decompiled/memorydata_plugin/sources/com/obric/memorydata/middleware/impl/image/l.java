package com.obric.memorydata.middleware.impl.image;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.island.gr.IslandSession;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/middleware/impl/image/ImageXUploadHandle;", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "complete", "Lkotlin/Function1;", "Lcom/obric/memorydata/middleware/impl/image/ImageXFileUploadResult;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, IslandSession.REOPEN_VALUE_CLOSE, "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface l {
    void a();

    void a(Function1<? super d, Unit> r1);

    void b();
}
