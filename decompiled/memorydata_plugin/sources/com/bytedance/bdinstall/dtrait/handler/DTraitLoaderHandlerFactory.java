package com.bytedance.bdinstall.dtrait.handler;

import android.content.Context;
import com.bytedance.bdinstall.dtrait.constant.DTraitEnum;
import com.bytedance.bdinstall.dtrait.extra_finger.ExtraLoaderConfigHandler;
import com.bytedance.bdinstall.dtrait.handler.abs.AbsLoaderHandler;
import com.bytedance.bdinstall.dtrait.manager.DTraitCacheManager;
import com.bytedance.bdinstall.dtrait.manager.DTraitNativeManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class DTraitLoaderHandlerFactory {

    /* JADX INFO: renamed from: com.bytedance.bdinstall.dtrait.handler.DTraitLoaderHandlerFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bdinstall$dtrait$constant$DTraitEnum = null;

        static {
            int[] r0 = new int[DTraitEnum.values().length];
            $SwitchMap$com$bytedance$bdinstall$dtrait$constant$DTraitEnum = r0;
            r0[DTraitEnum.COLLECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$bytedance$bdinstall$dtrait$constant$DTraitEnum[DTraitEnum.FACTOR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public DTraitLoaderHandlerFactory() {
    }

    public static AbsLoaderHandler createLoaderHandler(DTraitEnum r6, Context r7, ExtraLoaderConfigHandler r8, DTraitCacheManager r9, DTraitNativeManager r10, boolean r11) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        int r12 = AnonymousClass1.$SwitchMap$com$bytedance$bdinstall$dtrait$constant$DTraitEnum[r6.ordinal()];
        if (r12 == 1) goto L11;
        if (r12 == 2) goto L9;
        return null;
    L9:
        return new DTraitFactorHandlerImpl(r1, r8, r9, r10, r11);
    L11:
        return new DTraitCollectHandlerImpl(r1, r8, r9, r10, r11);
    }
}
