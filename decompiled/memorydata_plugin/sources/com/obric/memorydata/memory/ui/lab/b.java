package com.obric.memorydata.memory.ui.lab;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0015\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/memory/ui/lab/AILabPermissionUiStateMapper;", "", "<init>", "()V", "buttonState", "Lcom/obric/memorydata/memory/ui/lab/AILabPermissionButtonState;", "status", "", "applyRequestStatus", "(I)Ljava/lang/Integer;", "stopRequestStatus", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10976a = null;

    static {
        f10976a = new b();
    }

    private b() {
    }

    public final a a(int r5) {
        if (r5 == 0) goto L21;
        if (r5 == 1) goto L27;
        if (r5 == 2) goto L26;
        if (r5 == 3) goto L25;
        if (r5 == 4) goto L24;
        if (r5 == 5) goto L23;
        return new a(ZeusTransformUtils.mapRes(R.string.ailab_settings_approval, TypedValues.Custom.S_STRING, "ailab_settings_approval"), true);
    L23:
        return new a(ZeusTransformUtils.mapRes(R.string.ailab_settings_approval, TypedValues.Custom.S_STRING, "ailab_settings_approval"), true);
    L24:
        return new a(ZeusTransformUtils.mapRes(R.string.ailab_settings_unavailable, TypedValues.Custom.S_STRING, "ailab_settings_unavailable"), false);
    L25:
        return new a(ZeusTransformUtils.mapRes(R.string.ailab_settings_approval, TypedValues.Custom.S_STRING, "ailab_settings_approval"), true);
    L26:
        return new a(ZeusTransformUtils.mapRes(R.string.ailab_settings_approval_done, TypedValues.Custom.S_STRING, "ailab_settings_approval_done"), true);
    L27:
        return new a(ZeusTransformUtils.mapRes(R.string.ailab_settings_approval_inprogress, TypedValues.Custom.S_STRING, "ailab_settings_approval_inprogress"), false);
    L21:
        return new a(ZeusTransformUtils.mapRes(R.string.ailab_settings_approval, TypedValues.Custom.S_STRING, "ailab_settings_approval"), true);
    }

    public final Integer b(int r1) {
        if (r1 == 0) goto L9;
        if (r1 == 3) goto L9;
        if (r1 == 5) goto L9;
        return null;
    L9:
        return 0;
    }

    public final Integer c(int r1) {
        if (r1 == 2) goto L7;
        return null;
    L7:
        return 2;
    }
}
