package com.obric.assistant;

import android.os.Build;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.settings.config.ObricMmtVideoHardwareConfig;
import com.obric.assistant.spi.audio.IObricMmtVideoSettingsService;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/ObricMmtVideoSettingsServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricMmtVideoSettingsService;", "<init>", "()V", "getMmtVideoPreferHardwareAcceleration", NameKeys.UnloadStrategy_No_Strategy, "()Ljava/lang/Boolean;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMmtVideoSettingsServiceImpl implements IObricMmtVideoSettingsService {
    public ObricMmtVideoSettingsServiceImpl() {
    }

    public final Boolean a() {
        if (ObricFeatureServiceDelegate.b.c() == true) goto L5;
        return null;
    L5:
        ObricMmtVideoHardwareConfig r0 = t1.a.getMmtVideoHardwareConfig();
        if (r0 != null) goto L9;
        return null;
    L9:
        if (r0.getEnable() == true) goto L11;
        return null;
    L11:
        List r1 = r0.getDeviceBlacklist();
        if (r1 != null) goto L14;
        return null;
    L14:
        String r2 = Build.MODEL;
        if (r2 == null) goto L17;
        String r3 = StringsKt.trim(r2).toString();
    L18:
        if (r3 != null) goto L20;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L20:
        boolean r4 = false;
        if (r3.length() != 0) goto L23;
        boolean r5 = true;
    L24:
        if (r5 == false) goto L26;
    L52:
        return null;
    L26:
        if (StringsKt.equals(r3, "unknown", true) == true) goto L52;
        String r6 = r3.toLowerCase(Locale.ROOT);
        List r7 = r1;
        if ((r7 instanceof Collection) == true) goto L31;
    L33:
        Iterator r8 = r7.iterator();
    L35:
        if (r8.hasNext() == false) goto L50;
        String r9 = (String) r8.next();
        if (r9 != null) goto L39;
    L42:
        boolean r10 = true;
    L43:
        if (r10 == false) goto L45;
    L47:
        boolean r11 = false;
    L48:
        if (r11 == false) goto L35;
        r4 = true;
        goto L50
    L45:
        if (Intrinsics.areEqual(StringsKt.trim(r9).toString().toLowerCase(Locale.ROOT), r6) == false) goto L47;
        r11 = true;
        goto L48
    L39:
        if (StringsKt.isBlank(r9) == true) goto L42;
        r10 = false;
    L50:
        FLogger r12 = FLogger.a;
        StringBuilder r13 = new StringBuilder("deviceModel=");
        r13.append(r3);
        r13.append(", isBlacklisted=");
        r13.append(r4);
        r13.append(", preferHardwareAcceleration=");
        r13.append(!r4);
        r12.i("ObricMmtVideoSettings", r13.toString());
        return Boolean.valueOf(!r4);
    L31:
        if (r7.isEmpty() == false) goto L33;
    L23:
        r5 = false;
        goto L24
    L17:
        r3 = null;
        goto L18
    }
}
