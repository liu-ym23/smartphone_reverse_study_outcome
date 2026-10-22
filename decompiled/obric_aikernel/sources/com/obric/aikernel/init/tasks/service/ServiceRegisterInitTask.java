package com.obric.aikernel.init.tasks.service;

import com.obric.aikernel.middleware.api.appcontext.ReceiverRegister;
import kotlin.jvm.internal.DefaultConstructorMarker;
import m3.d;

/* JADX INFO: loaded from: classes2.dex */
public final class ServiceRegisterInitTask extends d {

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

    public ServiceRegisterInitTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        ReceiverRegister.INSTANCE.init();
    }
}
