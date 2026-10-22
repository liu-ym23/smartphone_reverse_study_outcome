package com.obric.memorydata.migration.sdk;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationAddonPath;", "", "<init>", "()V", "dirName", "", OaidModel.KEY_ID, "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f11962a = null;

    static {
        f11962a = new l();
    }

    private l() {
    }

    public final String a(String r4) {
        Intrinsics.checkNotNullParameter(r4, OaidModel.KEY_ID);
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString(), CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r1 = "addon";
        if (StringsKt.isBlank(r3) == false) goto L5;
        r3 = "addon";
    L5:
        String r5 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        Locale r6 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r6, "ROOT");
        String r7 = r5.toLowerCase(r6);
        Intrinsics.checkNotNullExpressionValue(r7, "toLowerCase(...)");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.take(new Regex("[^a-z0-9._-]").replace(r8, "_"), 64), CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r9) == true) goto L10;
        r1 = r9;
    L10:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
    }
}
