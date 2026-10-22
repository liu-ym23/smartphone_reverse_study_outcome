package com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown;

import com.ss.android.lark.widget.span.SpanInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final String a;
    public final List<RichTextInlineTagData> b;
    public int c;
    public final HashMap<Integer, C0053a> d;
    public final HashMap<Integer, Integer> e;
    public final StringBuilder f;
    public List<SpanInfo> g;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a$a, reason: collision with other inner class name */
    public static final class C0053a {
        public final char a;
        public boolean b;
        public boolean c;

        public C0053a(char r1) {
            this.a = r1;
            this.b = true;
        }
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sourceText");
        this.a = r2;
        this.b = new ArrayList();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new StringBuilder();
        this.g = new ArrayList();
    }
}
