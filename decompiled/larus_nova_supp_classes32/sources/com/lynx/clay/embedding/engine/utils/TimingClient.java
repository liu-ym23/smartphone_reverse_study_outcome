package com.lynx.clay.embedding.engine.utils;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface TimingClient {
    public static final String CLAY_FIRST_PRESENT_END = "clay_first_present_end";
    public static final String CLAY_FIRST_RASTER_END = "clay_first_raster_end";

    void onTimingSetup(HashMap<String, Long> r1);

    void onTimingUpdate(HashMap<String, Long> r1, String r2);
}
