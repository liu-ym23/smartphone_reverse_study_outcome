package com.lynx.tasm.service.security;

import com.lynx.tasm.service.IServiceProvider;
import j8a.b;
import java.nio.ByteBuffer;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface ILynxSecurityService extends IServiceProvider {

    /* JADX INFO: renamed from: com.lynx.tasm.service.security.ILynxSecurityService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Class $default$getServiceClass(ILynxSecurityService r0) {
            return ILynxSecurityService.class;
        }
    }

    public static final enum LynxTasmType extends Enum<LynxTasmType> {
        public static final LynxTasmType TYPE_DYNAMIC_COMPONENT = null;
        public static final LynxTasmType TYPE_TEMPLATE = null;
        public static final /* synthetic */ LynxTasmType[] a = null;

        static {
            LynxTasmType r0 = new LynxTasmType("TYPE_TEMPLATE", 0);
            TYPE_TEMPLATE = r0;
            LynxTasmType r1 = new LynxTasmType("TYPE_DYNAMIC_COMPONENT", 1);
            TYPE_DYNAMIC_COMPONENT = r1;
            a = new LynxTasmType[]{r0, r1};
        }

        public static LynxTasmType[] values() {
            return (LynxTasmType[]) a.clone();
        }

        public static LynxTasmType valueOf(String r1) {
            return (LynxTasmType) a.a(LynxTasmType.class, r1);
        }

        public LynxTasmType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    Class<? extends IServiceProvider> getServiceClass();

    b verifyTASM(j8a.a r1, byte[] r2, ByteBuffer r3, String r4, LynxTasmType r5);
}
