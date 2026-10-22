package com.ss.android.lark.im.base;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class ImBaseBizModule {
    public static final Lazy<ImBaseBizModule> c = null;

    @Inject
    public c a;

    @Inject
    public com.ss.android.lark.im.base.b b;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/im/base/ImBaseBizModule$ImBaseBizModuleEntryPoint;", "", "getImBaseBizModule", "Lcom/ss/android/lark/im/base/ImBaseBizModule;", "im-biz-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public interface b {
        ImBaseBizModule a();
    }

    @Inject
    public ImBaseBizModule() {
    }

    static {
        c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ImBaseBizModule$Companion$instance$2.INSTANCE);
    }
}
