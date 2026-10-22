package ac8;

import com.larus.bmhome.actionbar.model.AgentMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final boolean a(int r4, int r5, int r6, boolean r7) {
        Integer r8 = Integer.valueOf(r4);
        int r0 = r8.intValue();
        if (r0 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L11;
        r8 = null;
    L11:
        if (r8 == null) goto L14;
        r6 = r8.intValue();
    L14:
        if (r5 != AgentMode.CHAT.getValue()) goto L20;
        if ((r6 & 1) == 0) goto L18;
    L17:
        return true;
    L18:
        return false;
    L20:
        if (r5 == AgentMode.MOA.getValue()) goto L22;
        return r7;
    L22:
        if ((r6 & 2) == 0) goto L18;
    L5:
        if (r0 >= 4) goto L7;
        r1 = true;
        goto L8
    }
}
