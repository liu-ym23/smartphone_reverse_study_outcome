package com.obric.assistant.authenticationsession;

import com.obric.assistant.AuthenticationType;
import com.obric.assistant.DoraAuthTrustType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public /* synthetic */ class DoraAuthTrustServiceImpl$a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[DoraAuthTrustType.values().length];
        r0[DoraAuthTrustType.ALWAYS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
    L29:
        r0[DoraAuthTrustType.VOICE_PRINT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
    L39:
        r0[DoraAuthTrustType.SYSTEM_AUTHENTICATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
    L31:
        r0[DoraAuthTrustType.NOT_ALLOWED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
    L10:
        a = r0;
        int[] r1 = new int[AuthenticationType.values().length];
        r1[AuthenticationType.VoicePrint.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
    L35:
        r1[AuthenticationType.Biometric.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
    L25:
        r1[AuthenticationType.UnLocked.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
    L33:
        r1[AuthenticationType.INVALID.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
    L15:
        b = r1;
    }
}
