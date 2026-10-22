package com.obric.memorydata.memory.ui.automemory;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryCollectionCardFormatter;", "", "<init>", "()V", "formatMyTaskSubtitle", "", "memoryCount", "", "newMemoryCount", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10614a = null;

    static {
        f10614a = new c();
    }

    private c() {
    }

    public final String a(long r5, long r7) {
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r7 <= 0) goto L5;
        String r6 = r4.getString(ZeusTransformUtils.mapRes(R.string.memory_task_new_memory_count, TypedValues.Custom.S_STRING, "memory_task_new_memory_count"), new Object[]{Long.valueOf(r7)});
    L6:
        Intrinsics.checkNotNull(r6);
        return r6;
    L5:
        r6 = r4.getString(ZeusTransformUtils.mapRes(R.string.memory_task_memory_count, TypedValues.Custom.S_STRING, "memory_task_memory_count"), new Object[]{Long.valueOf(r5)});
        goto L6
    }
}
