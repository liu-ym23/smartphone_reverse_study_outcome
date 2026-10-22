package com.obric.memorydata.utils;

import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/utils/DataMask;", "", "<init>", "()V", "maskIfNeeded", "", Params.CONTENT, "mask", "maskLongContent", "maskShortContent", "maskMediumContent", "maskChinese", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f13259a = null;

    static {
        f13259a = new q();
    }

    private q() {
    }

    private final String d(String r5) {
        String r0 = StringsKt.take(r5, 2);
        String r4 = StringsKt.takeLast(r5, 2);
        return r0 + StringsKt.repeat((CharSequence) ZeusTransformUtils.preCheckCast("*", CharSequence.class, "com.obric.memorydata.plugin"), r5.length() - 4) + r4;
    }

    private final String e(String r5) {
        return StringsKt.take(r5, 1) + StringsKt.repeat((CharSequence) ZeusTransformUtils.preCheckCast("*", CharSequence.class, "com.obric.memorydata.plugin"), r5.length() - 1);
    }

    private final String f(String r5) {
        String r0 = StringsKt.take(r5, 1);
        String r4 = StringsKt.takeLast(r5, 1);
        return r0 + StringsKt.repeat((CharSequence) ZeusTransformUtils.preCheckCast("*", CharSequence.class, "com.obric.memorydata.plugin"), r5.length() - 2) + r4;
    }

    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
        if (AppContext.INSTANCE.isDebug() == false) goto L6;
        return r2;
    L6:
        return b(r2);
    }

    public final String b(String r3) {
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        int r0 = r3.length();
        if (r0 > 0) goto L7;
        return "";
    L7:
        if (r0 <= 6) goto L10;
        return d(r3);
    L10:
        if (r0 > 3) goto L13;
        return e(r3);
    L13:
        return f(r3);
    }

    public final String c(String r2) {
        Intrinsics.checkNotNullParameter(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        return new Regex("\\p{IsHan}+").replace(r1, "***");
    }
}
