package com.obric.aikernel.model_decrypt.api;

import com.bytedance.news.common.service.manager.IService;
import com.obric.aikernel.model_decrypt.api.callback.IKeyInfoDistribute;
import com.obric.aikernel.model_decrypt.api.callback.IModelInfoProvider;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes2.dex */
public interface IDecryptFeature extends IService {

    public static final class DefaultImpls {
        public static /* synthetic */ Object decrypt$default(IDecryptFeature r10, String r11, String r12, boolean r13, String r14, Continuation r15, int r16, Object r17) {
            if (r17 != null) goto L12;
            if ((r16 & 4) == 0) goto L6;
            r13 = false;
        L6:
            boolean r18 = r13;
            if ((r16 & 8) == 0) goto L10;
            r14 = null;
        L10:
            return r10.decrypt(r11, r12, r18, r14, r15);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrypt");
        }

        public static /* synthetic */ boolean decrypt$default(IDecryptFeature r10, String r11, ByteBuffer r12, boolean r13, int r14, Object r15) {
            if (r15 != null) goto L9;
            if ((r14 & 4) == 0) goto L7;
            r13 = false;
        L7:
            return r10.decrypt(r11, r12, r13);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrypt");
        }

        /* JADX INFO: renamed from: simpleRequestKeyInfo-BWLJW6A, reason: not valid java name */
        public static Object m20simpleRequestKeyInfoBWLJW6A(IDecryptFeature r10, String r11, String r12, String r13, Continuation<? super Result<? extends Set<IKeyInfoDistribute.KeyInfoItem>>> r14) {
            if ((r14 instanceof IDecryptFeature$simpleRequestKeyInfo$1) == false) goto L7;
            IDecryptFeature$simpleRequestKeyInfo$1 r15 = (IDecryptFeature$simpleRequestKeyInfo$1) r14;
            int r16 = r15.label;
            if ((r16 & Integer.MIN_VALUE) == 0) goto L7;
            r15.label = r16 - Integer.MIN_VALUE;
        L8:
            Object r17 = r15.result;
            Object r18 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r19 = r15.label;
            if (r19 == 0) goto L14;
            if (r19 != 1) goto L13;
            ResultKt.throwOnFailure(r17);
            return ((Result) r17).m41unboximpl();
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r17);
            Set<String> r20 = SetsKt.setOf(r13);
            r15.label = 1;
            Object r21 = r10.mo19simpleRequestKeyInfoBWLJW6A(r11, r12, r20, r15);
            if (r21 != r18) goto L18;
            return r18;
        L18:
            return r21;
        L7:
            r15 = new IDecryptFeature$simpleRequestKeyInfo$1(r14);
            goto L8
        }
    }

    String dataDecrypt(String r10);

    byte[] dataDecrypt(byte[] r10);

    String dataEncrypt(String r10);

    byte[] dataEncrypt(byte[] r10);

    Object decrypt(String r10, String r11, boolean r12, String r13, Continuation<? super Boolean> r14);

    boolean decrypt(String r10, ByteBuffer r11, boolean r12);

    long getDecryptFileSize(String r10);

    void init(IModelInfoProvider r10, IKeyInfoDistribute r11);

    boolean isEnable();

    Object reEncryptKeyInfo(File r10, Continuation<? super Boolean> r11);

    Object requestKeyInfo(List<String> r10, Continuation<? super Unit> r11);

    /* JADX INFO: renamed from: simpleRequestKeyInfo-BWLJW6A, reason: not valid java name */
    Object mo18simpleRequestKeyInfoBWLJW6A(String r10, String r11, String r12, Continuation<? super Result<? extends Set<IKeyInfoDistribute.KeyInfoItem>>> r13);

    /* JADX INFO: renamed from: simpleRequestKeyInfo-BWLJW6A, reason: not valid java name */
    Object mo19simpleRequestKeyInfoBWLJW6A(String r10, String r11, Set<String> r12, Continuation<? super Result<? extends Set<IKeyInfoDistribute.KeyInfoItem>>> r13);
}
