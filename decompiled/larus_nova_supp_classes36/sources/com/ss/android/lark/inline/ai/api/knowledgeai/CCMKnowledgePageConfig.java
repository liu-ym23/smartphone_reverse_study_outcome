package com.ss.android.lark.inline.ai.api.knowledgeai;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CCMKnowledgePageConfig {
    public final Function0<String> a;
    public final Function0<Map<String, String>> b;

    public static final class Builder {
        public b a;
        public Function0<String> b;
        public Function0<? extends Map<String, String>> c;

        public Builder() {
            this.b = CCMKnowledgePageConfig$Builder$docTokenProvider$1.INSTANCE;
        }
    }

    public CCMKnowledgePageConfig(b r2, Function0 r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r2, "abilityDependencies");
        Intrinsics.checkNotNullParameter(r3, "docTokenProvider");
        this.a = r3;
        this.b = r4;
    }
}
