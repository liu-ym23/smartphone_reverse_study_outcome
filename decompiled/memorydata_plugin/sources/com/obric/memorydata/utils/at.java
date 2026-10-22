package com.obric.memorydata.utils;

import android.content.Context;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001\u001a\f\u0010\b\u001a\u00020\u0005*\u0004\u0018\u00010\u0001\u001a\f\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\u0001\u001a\f\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u0001\u001a(\u0010\u000b\u001a\u00020\f*\u0004\u0018\u00010\u00012\u0014\b\u0004\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000eH\u0086\bø\u0001\u0000\u001a\f\u0010\u000f\u001a\u00020\u0003*\u0004\u0018\u00010\u0001\u001a\f\u0010\u0010\u001a\u00020\u0001*\u0004\u0018\u00010\u0001\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0001\u001a\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2 = {"getStringFromResources", "", OaidModel.KEY_ID, "", "matchesWildcard", "", "", "wildcard", "isNotNullOrEmpty", "base64", "base64Decode", "runWhenNotEmpty", "", "block", "Lkotlin/Function1;", "getCodePointCount", "analysis", "getWordPercent", "", "takeIfNotEmpty", "utils_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class at {
    public static final String a(int r3) {
        String r4 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getString(r3);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
        return r4;
    }

    public static final boolean a(CharSequence r7, String r8) {
        CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r8, "wildcard");
        return new Regex(StringsKt.replace$default(r8, "*", ".+", false, 4, null)).matches(r9);
    }

    public static final boolean a(String r2) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        return !r4;
    L5:
        if (r3.length() == 0) goto L8;
        r4 = false;
        goto L10
    }
}
