package com.larus.settings.tutor;

import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public static final List<VoiceConfig> a = null;
    public static final List<VoiceConfig> b = null;

    static {
        a = CollectionsKt.listOf(new VoiceConfig[]{a(-3.0d, false), a(-2.5d, false), a(-2.0d, false), a(-1.5d, false), a(-1.0d, false), a(-0.5d, false), a(0.0d, true), a(0.5d, false), a(1.0d, false), a(1.5d, false), a(2.0d, false), a(2.5d, false), a(3.0d, false)});
        b = CollectionsKt.listOf(new VoiceConfig[]{a(0.7d, false), a(0.75d, false), a(0.8d, false), a(0.85d, false), a(0.9d, false), a(0.95d, false), a(1.0d, true), a(1.05d, false), a(1.1d, false), a(1.15d, false), a(1.2d, false), a(1.25d, false), a(1.3d, false), a(1.35d, false), a(1.4d, false), a(1.45d, false), a(1.5d, false)});
    }

    public static final VoiceConfig a(double r1, boolean r3) {
        return new VoiceConfig(Double.valueOf(r1), Boolean.valueOf(r3));
    }
}
