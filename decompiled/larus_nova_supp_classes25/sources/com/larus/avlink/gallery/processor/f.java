package com.larus.avlink.gallery.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public final List<Job> a;
    public boolean b;

    public f() {
        this.a = Collections.synchronizedList(new ArrayList());
    }
}
