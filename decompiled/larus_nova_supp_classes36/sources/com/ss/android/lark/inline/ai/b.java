package com.ss.android.lark.inline.ai;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements com.ss.android.lark.inline.ai.api.knowledgeai.c {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.c
    public final void a() {
        Log.e("OfficeSdkKnowledgeAISdkStub", "getKnowledgePageFlow returns no-op flow in OfficeSDK");
        c r0 = c.a;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.c
    public final Fragment b() {
        Log.e("OfficeSdkKnowledgeAISdkStub", "createKnowledgePage is no-op in OfficeSDK");
        return new Fragment();
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.c
    public final void onActivityResult() {
        Log.e("OfficeSdkKnowledgeAISdkStub", "onActivityResult is no-op in OfficeSDK");
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.c
    public final void c(Function1<? super com.ss.android.lark.inline.ai.api.knowledgeai.a, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "configBlock");
        Log.e("OfficeSdkKnowledgeAISdkStub", "showKeyboardPage is no-op in OfficeSDK");
    }
}
