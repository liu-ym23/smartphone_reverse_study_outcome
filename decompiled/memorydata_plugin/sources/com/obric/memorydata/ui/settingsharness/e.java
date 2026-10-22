package com.obric.memorydata.ui.settingsharness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/ui/settingsharness/SettingsCardPositionResolver;", "", "<init>", "()V", "resolve", "", "Lcom/obric/memorydata/ui/settingsharness/SettingsCardPosition;", "visibleRowCount", "", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f13036a = null;

    static {
        f13036a = new e();
    }

    private e() {
    }

    public final List<SettingsCardPosition> a(int r4) {
        int r3 = 0;
        if (r4 < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L21;
        ArrayList r2 = new ArrayList(r4);
    L8:
        if (r3 >= r4) goto L19;
        if (r4 != 1) goto L11;
        SettingsCardPosition r5 = SettingsCardPosition.SINGLE;
    L17:
        r2.add(r5);
        r3 = r3 + 1;
        goto L8
    L11:
        if (r3 != 0) goto L14;
        r5 = SettingsCardPosition.TOP;
        goto L17
    L14:
        if (r3 != (r4 - 1)) goto L16;
        r5 = SettingsCardPosition.BOTTOM;
        goto L17
    L16:
        r5 = SettingsCardPosition.MIDDLE;
        goto L17
    L19:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    L21:
        throw new IllegalArgumentException("visibleRowCount must not be negative".toString());
    L5:
        r1 = false;
        goto L6
    }
}
