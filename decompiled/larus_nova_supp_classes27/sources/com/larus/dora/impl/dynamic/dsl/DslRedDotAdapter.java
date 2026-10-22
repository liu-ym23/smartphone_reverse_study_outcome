package com.larus.dora.impl.dynamic.dsl;

import com.bytedance.dora.device.DoraDevice;
import com.larus.account.base.api.ILoginService;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.ota.b;
import com.larus.dora.impl.util.b0;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import g49.d;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DslRedDotAdapter {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/dora/impl/dynamic/dsl/DslRedDotAdapter$RedDotType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FIRMWARE_UPGRADE", "SIMUL_INTERPRET", "LAB_ENTRY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RedDotType extends Enum<RedDotType> {
        public static final RedDotType FIRMWARE_UPGRADE = null;
        public static final RedDotType LAB_ENTRY = null;
        public static final RedDotType SIMUL_INTERPRET = null;
        public static final /* synthetic */ RedDotType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<RedDotType> getEntries() {
            return b;
        }

        static {
            RedDotType r0 = new RedDotType("FIRMWARE_UPGRADE", 0, "firmware_upgrade");
            FIRMWARE_UPGRADE = r0;
            RedDotType r1 = new RedDotType("SIMUL_INTERPRET", 1, "simul_interpret");
            SIMUL_INTERPRET = r1;
            RedDotType r2 = new RedDotType("LAB_ENTRY", 2, "lab_function_entry");
            LAB_ENTRY = r2;
            RedDotType[] r4 = {r0, r1, r2};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
        }

        public static RedDotType[] values() {
            return (RedDotType[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static RedDotType valueOf(String r1) {
            return (RedDotType) r27.a.a(RedDotType.class, r1);
        }

        public RedDotType(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
    }

    public static boolean a(String r4, DoraDevice r5) {
        if (Intrinsics.areEqual(r4, RedDotType.FIRMWARE_UPGRADE.getValue()) == false) goto L12;
        if (r5 != null) goto L6;
        return false;
    L6:
        b r6 = b.a;
        String r7 = b.a(r5);
        d.d("RedDotAdapter", "isShowRedDot[FIRMWARE_UPGRADE] ver  : " + r7 + " , softVersion : " + r5.softVersion);
        if (r7.length() > 0) goto L27;
        return false;
    L27:
        return true;
    L12:
        if (Intrinsics.areEqual(r4, RedDotType.SIMUL_INTERPRET.getValue()) == false) goto L18;
        IDoraService r8 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r8 == null) goto L16;
        r8.e();
    L16:
        return false;
    L18:
        if (Intrinsics.areEqual(r4, RedDotType.LAB_ENTRY.getValue()) == false) goto L26;
        String r9 = ILoginService.a.getAccountInfo().c;
        if (o0.d(r9) == false) goto L24;
        b0.a.getClass();
        if (b0.q(r9) == false) goto L24;
        return true;
    L24:
        return false;
    L26:
        return false;
    }
}
