package com.larus.platform.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/api/AuthScene;", "", "<init>", "(Ljava/lang/String;I)V", "LocalLife", "Luna", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum AuthScene extends Enum<AuthScene> {
    public static final AuthScene LocalLife = null;
    public static final AuthScene Luna = null;
    public static final /* synthetic */ AuthScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AuthScene> getEntries() {
        return b;
    }

    static {
        AuthScene r0 = new AuthScene("LocalLife", 0);
        LocalLife = r0;
        AuthScene r1 = new AuthScene("Luna", 1);
        Luna = r1;
        AuthScene[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static AuthScene[] values() {
        return (AuthScene[]) a.clone();
    }

    public static AuthScene valueOf(String r1) {
        return (AuthScene) r27.a.a(AuthScene.class, r1);
    }

    public AuthScene(String r1, int r2) {
        super(r1, r2);
    }
}
