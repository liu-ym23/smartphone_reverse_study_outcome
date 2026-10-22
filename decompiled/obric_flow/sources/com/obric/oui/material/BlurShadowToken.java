package com.obric.oui.material;

import androidx.annotation.Keep;
import androidx.room.jarjarred.org.antlr.v4.gui.TestRig;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.shadow.ShadowToken;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR'\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/material/BlurShadowToken;", "", "<init>", "()V", "", "name", "Lcom/obric/oui/material/a;", "parse", "(Ljava/lang/String;)Lcom/obric/oui/material/a;", "", "tokens$delegate", "Lkotlin/Lazy;", "getTokens", "()Ljava/util/Map;", TestRig.LEXER_START_RULE_NAME, "Blur_Shadow_Thin", "Lcom/obric/oui/material/a;", "Blur_Shadow_Regular", "Blur_Shadow_Thin_On_Image", "Blur_Shadow_Regular_On_Image", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BlurShadowToken {

    @JvmField
    public static final a Blur_Shadow_Regular = null;

    @JvmField
    public static final a Blur_Shadow_Regular_On_Image = null;

    @JvmField
    public static final a Blur_Shadow_Thin = null;

    @JvmField
    public static final a Blur_Shadow_Thin_On_Image = null;
    public static final BlurShadowToken INSTANCE = null;
    private static final Lazy tokens$delegate = null;

    static {
        INSTANCE = new BlurShadowToken();
        tokens$delegate = LazyKt.lazy(BlurShadowToken$tokens$2.INSTANCE);
        Blur_Shadow_Thin = new a(BlurToken.Blur_Thin, ShadowToken.Shadow_2);
        float r5 = BlurToken.Blur_Regular;
        es.a[] r10 = ShadowToken.Shadow_3;
        Blur_Shadow_Regular = new a(r5, r10);
        Blur_Shadow_Thin_On_Image = new a(r5, r10);
        Blur_Shadow_Regular_On_Image = new a(BlurToken.Blur_Thick, ShadowToken.Shadow_Thick);
    }

    private BlurShadowToken() {
    }

    private final Map<String, a> getTokens() {
        return (Map) tokens$delegate.getValue();
    }

    @JvmStatic
    public static final a parse(String r5) {
        Map<String, a> r10 = INSTANCE.getTokens();
        Intrinsics.checkNotNullParameter(r10, TestRig.LEXER_START_RULE_NAME);
        a r11 = null;
        if (r5 != null) goto L5;
    L4:
        String r12 = null;
    L9:
        if (r12 == null) goto L15;
        if (r12.length() == 0) goto L15;
        r11 = r10.get(r12);
    L15:
        return r11;
    L5:
        String r13 = r5.toLowerCase(Locale.ROOT);
        if (r13 == null) goto L4;
        r12 = StringsKt.trim(r13).toString();
        goto L9
    }
}
