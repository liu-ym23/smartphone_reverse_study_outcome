package com.lynx.tasm.service.security;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.service.IServiceProvider;
import java.nio.ByteBuffer;
import lo.a;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface ILynxSecurityService extends IServiceProvider {

    public static final enum LynxTasmType extends Enum<LynxTasmType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LynxTasmType f10958a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final LynxTasmType f10959b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ LynxTasmType[] f10960c = null;

        static {
            LynxTasmType r5 = new LynxTasmType("TYPE_TEMPLATE", 0);
            f10958a = r5;
            LynxTasmType r10 = new LynxTasmType("TYPE_DYNAMIC_COMPONENT", 1);
            f10959b = r10;
            f10960c = new LynxTasmType[]{r5, r10};
        }

        public LynxTasmType(String r5, int r10) {
            super(r5, r10);
        }

        public static LynxTasmType valueOf(String r5) {
            return (LynxTasmType) Enum.valueOf(LynxTasmType.class, r5);
        }

        public static LynxTasmType[] values() {
            return (LynxTasmType[]) f10960c.clone();
        }
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    @NonNull
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxSecurityService.class;
    }

    a verifyTASM(LynxView r5, byte[] r10, ByteBuffer r11, String r12, LynxTasmType r13);
}
