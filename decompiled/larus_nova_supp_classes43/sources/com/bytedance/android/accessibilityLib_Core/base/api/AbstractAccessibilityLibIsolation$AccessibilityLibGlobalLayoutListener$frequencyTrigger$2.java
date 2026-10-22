package com.bytedance.android.accessibilityLib_Core.base.api;

import com.byted.cast.sink.api.ServerInfo;
import com.bytedance.android.accessibilityLib_Core.tool.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/tool/d;", "invoke", "()Lcom/bytedance/android/accessibilityLib_Core/tool/d;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class AbstractAccessibilityLibIsolation$AccessibilityLibGlobalLayoutListener$frequencyTrigger$2 extends Lambda implements Function0<d> {
    public static final AbstractAccessibilityLibIsolation$AccessibilityLibGlobalLayoutListener$frequencyTrigger$2 INSTANCE = null;

    static {
        INSTANCE = new AbstractAccessibilityLibIsolation$AccessibilityLibGlobalLayoutListener$frequencyTrigger$2();
    }

    public AbstractAccessibilityLibIsolation$AccessibilityLibGlobalLayoutListener$frequencyTrigger$2() {
        super(0);
    }

    public final d invoke() {
        return new d(ServerInfo.ERROR_PORT_FAILED, 2);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m55invoke() {
        return invoke();
    }
}
