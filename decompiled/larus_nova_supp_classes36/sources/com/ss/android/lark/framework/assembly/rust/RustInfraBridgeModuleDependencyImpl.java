package com.ss.android.lark.framework.assembly.rust;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.utils.LarkContext;
import dagger.hilt.EntryPoints;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(c3c.d.class)
public class RustInfraBridgeModuleDependencyImpl implements c3c.d {
    yzb.b userListApi;

    public class a implements c3c.d.a {
        public a() {
        }
    }

    public static /* synthetic */ String a() {
        return lambda$getTTWebviewDependency$0();
    }

    public c3c.d.a getPassportDependency() {
        return new a();
    }

    public c3c.d.c getTTWebviewDependency() {
        return new u();
    }

    public RustInfraBridgeModuleDependencyImpl() {
        this.userListApi = (yzb.b) e0c.k.a(LarkContext.getApplication(), yzb.b.class);
    }

    private static /* synthetic */ String lambda$getTTWebviewDependency$0() {
        ((c3c.e) EntryPoints.get(LarkContext.getApplication(), c3c.e.class)).c().getClass();
        return "";
    }
}
