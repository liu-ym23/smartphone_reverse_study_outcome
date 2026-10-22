package com.obric.aikernel.init.tasks.bdtracker;

import com.obric.aikernel.middleware.api.bdtracker.BdTrackerInit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import m3.d;

/* JADX INFO: loaded from: classes2.dex */
public final class BdTrackerInitTask extends d {

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

    public BdTrackerInitTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        new BdTrackerInit().init();
    }
}
