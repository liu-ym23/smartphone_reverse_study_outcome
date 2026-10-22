package com.bytedance.bpea.entry.api.content.provider;

import android.database.Cursor;
import android.os.Bundle;
import android.os.CancellationSignal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface c {
    Cursor query(String[] r1, Bundle r2, CancellationSignal r3);

    Cursor query(String[] r1, String r2, String[] r3, String r4);

    Cursor query(String[] r1, String r2, String[] r3, String r4, CancellationSignal r5);
}
