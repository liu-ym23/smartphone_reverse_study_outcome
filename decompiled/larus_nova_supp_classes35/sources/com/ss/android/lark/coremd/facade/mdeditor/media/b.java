package com.ss.android.lark.coremd.facade.mdeditor.media;

import android.text.SpannableStringBuilder;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.facade.bizext.props.IMMediaExtend;
import com.ss.android.lark.keyboard.edittext2.base.c;
import com.ss.android.lark.keyboard.edittext2.edittors.e;
import com.tencent.qqmusic.third.api.contract.Keys;
import hob.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends e {
    public final void U(final SpannableStringBuilder r4, final g r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, Keys.API_RETURN_KEY_DATA);
        final String r0 = UIUtils.getString(c.a.a(this).getContext(), 2131891923);
        IMMediaExtend.q.b(new IMMediaMarkdownEditor$onInsert$1(r0, r5, this, r4));
    }

    public final /* bridge */ /* synthetic */ void S(SpannableStringBuilder r1, Object r2, int r3) {
        U(r1, (g) r2);
    }
}
