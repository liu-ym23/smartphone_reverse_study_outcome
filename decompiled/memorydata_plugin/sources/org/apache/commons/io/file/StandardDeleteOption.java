package org.apache.commons.io.file;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum StandardDeleteOption extends Enum<StandardDeleteOption> implements DeleteOption {
    private static final /* synthetic */ StandardDeleteOption[] $VALUES = null;
    public static final StandardDeleteOption OVERRIDE_READ_ONLY = null;

    static {
        StandardDeleteOption r0 = new StandardDeleteOption("OVERRIDE_READ_ONLY", 0);
        OVERRIDE_READ_ONLY = r0;
        $VALUES = new StandardDeleteOption[]{r0};
    }

    private StandardDeleteOption(String r1, int r2) {
        super(r1, r2);
    }

    public static boolean overrideReadOnly(DeleteOption[] r5) {
        if (IOUtils.length(r5) != 0) goto L5;
        return false;
    L5:
        int r0 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L12;
        if (r5[r2] == OVERRIDE_READ_ONLY) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static StandardDeleteOption valueOf(String r2) {
        return (StandardDeleteOption) ZeusTransformUtils.preCheckCast(Enum.valueOf(StandardDeleteOption.class, r2), StandardDeleteOption.class, "com.obric.memorydata.plugin");
    }

    public static StandardDeleteOption[] values() {
        return (StandardDeleteOption[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StandardDeleteOption[].class, "com.obric.memorydata.plugin");
    }
}
