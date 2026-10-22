package com.ss.android.lark.compose.chatsetting.main.ui.sections.doubao;

import com.larksuite.framework.utils.ICUUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class DoubaoSettingsSectionKt$DoubaoSettingsSection$1$1 extends FunctionReferenceImpl implements Function2<String, String, String> {
    public static final DoubaoSettingsSectionKt$DoubaoSettingsSection$1$1 INSTANCE = null;

    static {
        INSTANCE = new DoubaoSettingsSectionKt$DoubaoSettingsSection$1$1();
    }

    public DoubaoSettingsSectionKt$DoubaoSettingsSection$1$1() {
        super(2, DoubaoSettingsSectionKt.class, "formatBrandedText", "formatBrandedText(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", 1);
    }

    public final String invoke(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        Intrinsics.checkNotNullParameter(r4, "p1");
        ICUUtils.FormatArgsBuilder r0 = new ICUUtils.FormatArgsBuilder();
        r0.b("brandName", r4);
        return ICUUtils.icuFormat(r3, r0.a);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((String) r1, (String) r2);
    }
}
