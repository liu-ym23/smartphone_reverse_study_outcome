package com.bytedance.ai.debugscene;

import com.bytedance.ai.debug.NativeDebugPanelType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b0 {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[NativeDebugPanelType.values().length];
            r0[NativeDebugPanelType.DEBUG_PANEL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[NativeDebugPanelType.AGENT_TRACE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }
}
