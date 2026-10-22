package com.ss.android.lark.coremdbiz.facade.codeblock;

import com.ss.android.lark.coremd.impl.parse.i;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import kotlin.jvm.internal.Intrinsics;
import v7b.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface a {
    public static final C0188a a = null;

    /* JADX INFO: renamed from: com.ss.android.lark.coremdbiz.facade.codeblock.a$a, reason: collision with other inner class name */
    public static final class C0188a implements a {
        public static final /* synthetic */ C0188a b = null;

        static {
            b = new C0188a();
        }

        public C0188a() {
        }

        @Override // com.ss.android.lark.coremdbiz.facade.codeblock.a
        public final CodeBlockV2ProcessParams a(g r3, final i r4) {
            Intrinsics.checkNotNullParameter(r3, "node");
            Intrinsics.checkNotNullParameter(r4, "context");
            int r5 = ((Number) LarkContextExtend.s.b(new ICodeBlockParamsProvider$Default$provide$maxWidth$1(r4))).intValue();
            return CodeBlockV2ProcessParams.b.d(CodeBlockV2ProcessParams.Companion, r5, 0, 6);
        }
    }

    static {
        a = C0188a.b;
    }

    CodeBlockV2ProcessParams a(g r1, i r2);
}
