package com.bytedance.bpea.entry.api.camera;

import android.hardware.Camera;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.bytedance.bpea.entry.api.camera.a$a, reason: collision with other inner class name */
    public static final class C0369a {
        @JvmStatic
        public static Camera b(TokenCert r3) throws BPEAException {
            return (Camera) BaseAuthEntry.a.a(b.a(r3, "camera_open1", 100100), Camera1Entry$Companion$open$1.INSTANCE);
        }

        @JvmStatic
        public static Camera a(final int r3, TokenCert r4) throws BPEAException {
            return (Camera) BaseAuthEntry.a.a(b.a(r4, "camera_open1", 100100), new Camera1Entry$Companion$open$2(r3));
        }

        @JvmStatic
        public static void c(final Camera r3, TokenCert r4) throws BPEAException {
            BaseAuthEntry.a.a(b.a(r4, "camera_close1", 100101), new Camera1Entry$Companion$release$1(r3));
        }
    }

    static {
    }
}
