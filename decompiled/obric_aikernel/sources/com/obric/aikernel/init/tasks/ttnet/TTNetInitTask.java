package com.obric.aikernel.init.tasks.ttnet;

import com.obric.aikernel.middleware.api.ttnet.TTNetInitHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import m3.d;

/* JADX INFO: loaded from: classes2.dex */
public final class TTNetInitTask extends d {

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    public TTNetInitTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        new TTNetInitHelper().initTTNet();
    }
}
