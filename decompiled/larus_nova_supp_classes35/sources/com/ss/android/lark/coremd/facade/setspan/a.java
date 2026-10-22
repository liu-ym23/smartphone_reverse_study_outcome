package com.ss.android.lark.coremd.facade.setspan;

import com.ss.android.lark.coremd.base.parse.q;
import com.ss.android.lark.coremd.facade.bizext.IMThemeExtend;
import com.ss.android.lark.coremd.facade.bizext.props.IMImageExtend;
import com.ss.android.lark.coremd.facade.bizext.theme.IMImageThemeData;
import com.ss.android.lark.coremd.impl.parse.i;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import v7b.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements q<l> {
    public static final /* synthetic */ int b = 0;
    public final HashMap<String, String> a;

    /* JADX INFO: renamed from: com.ss.android.lark.coremd.facade.setspan.a$a, reason: collision with other inner class name */
    public static final class C0185a {
    }

    static {
    }

    public a() {
        this.a = new HashMap();
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final i r3) {
        Intrinsics.checkNotNullParameter(r3, "parseContext");
        final IMImageThemeData r0 = (IMImageThemeData) IMThemeExtend.s.b(new IMImageSpanProducer$produceSpanImpl$themeData$1(r3));
        return com.ss.android.lark.coremd.ext.i.a(IMImageExtend.class, new IMImageSpanProducer$produceSpanImpl$1(this, r3, r0));
    }
}
