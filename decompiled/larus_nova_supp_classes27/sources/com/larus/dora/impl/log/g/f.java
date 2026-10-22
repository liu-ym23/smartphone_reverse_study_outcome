package com.larus.dora.impl.log.g;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.dora.impl.util.t0;
import java.io.File;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f extends t0 {
    public f() {
    }

    public final void onDoraLinkStateChanged(DoraDevice r10, int r11, int r12) {
        super.onDoraLinkStateChanged(r10, r11, r12);
        g49.d.d("DoraGLogManager", "onDoraLinkStateChanged device " + r10 + ", prevState " + r11 + ", state " + r12);
        if (r10 != null) goto L6;
        return;
    L6:
        if (r12 == 0) goto L12;
        if (r12 == 1) goto L12;
        if (r12 == 3) goto L12;
        return;
    L12:
        if (r12 != 0) goto L26;
        DoraGLogManager r13 = DoraGLogManager.a;
        long r1 = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(7);
        File[] r14 = new PolarisFileWrapper(r13.o()).listFiles();
        if (r14 == null) goto L26;
        int r3 = r14.length;
        int r4 = 0;
    L16:
        if (r4 >= r3) goto L26;
        File r5 = r14[r4];
        if (r5.isFile() == false) goto L25;
        if (r5.lastModified() >= r1) goto L25;
        if (r5.delete() == false) goto L24;
        g49.d.d("DoraGLogManager", "delete log file " + r5.getAbsolutePath() + " success");
        goto L25
    L24:
        g49.d.b("DoraGLogManager", "delete log file " + r5.getAbsolutePath() + " failed");
    L25:
        r4 = r4 + 1;
    L26:
        DoraGLogManager.a.v(false);
        DoraGLogManager.b = 0;
        ScheduledFuture<?> r15 = DoraGLogManager.m;
        if (r15 == null) goto L35;
        r15.cancel(true);
        return;
    }
}
