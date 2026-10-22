package com.ss.android.lark.inline.ai.api.knowledgeai;

import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final ViewModelStoreOwner a;
    public final Function0<ulb.c> b;

    public b(PluginHost r2, com.bytedance.ee.bear.document.ai.knowledgeai.d r3, com.bytedance.ee.bear.document.ai.knowledgeai.c r4, com.bytedance.ee.bear.document.ai.knowledgeai.e r5, Function0 r6) {
        Intrinsics.checkNotNullParameter(r2, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(r3, "kvRepoAbility");
        Intrinsics.checkNotNullParameter(r4, "clipboardAbility");
        Intrinsics.checkNotNullParameter(r5, "docPermissionAbility");
        Intrinsics.checkNotNullParameter(r6, "htmlToDocxRecordProvider");
        this.a = r2;
        this.b = r6;
    }
}
