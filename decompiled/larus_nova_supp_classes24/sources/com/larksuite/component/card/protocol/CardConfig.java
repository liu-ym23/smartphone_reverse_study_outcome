package com.larksuite.component.card.protocol;

import android.content.Context;
import com.larksuite.component.card.settings.LynxCardCommonConfig;
import com.larksuite.component.card.settings.LynxCardFallbackStyleConfig;
import com.larksuite.component.card.settings.LynxMsgCardTimeFormatConfig;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.utils.ICUUtils;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.utils.UIHelper;
import ez7.a;
import ez7.b;
import ez7.c;
import idb.f;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J8\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/larksuite/component/card/protocol/CardConfig;", "Ljava/io/Serializable;", "maxWidth", "", "settings", "Lcom/larksuite/component/card/protocol/data/SettingsInfo;", "fg", "Lcom/larksuite/component/card/protocol/data/FgInfo;", "i18nText", "Lcom/larksuite/component/card/protocol/data/I18nText;", "<init>", "(Ljava/lang/Integer;Lcom/larksuite/component/card/protocol/data/SettingsInfo;Lcom/larksuite/component/card/protocol/data/FgInfo;Lcom/larksuite/component/card/protocol/data/I18nText;)V", "getMaxWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSettings", "()Lcom/larksuite/component/card/protocol/data/SettingsInfo;", "getFg", "()Lcom/larksuite/component/card/protocol/data/FgInfo;", "getI18nText", "()Lcom/larksuite/component/card/protocol/data/I18nText;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Lcom/larksuite/component/card/protocol/data/SettingsInfo;Lcom/larksuite/component/card/protocol/data/FgInfo;Lcom/larksuite/component/card/protocol/data/I18nText;)Lcom/larksuite/component/card/protocol/CardConfig;", "equals", "", "other", "", "hashCode", "toString", "", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardConfig implements Serializable {
    private final a fg;
    private final b i18nText;
    private final Integer maxWidth;
    private final c settings;

    public CardConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CardConfig copy$default(CardConfig r0, Integer r1, c r2, a r3, b r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.maxWidth;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.settings;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.fg;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.i18nText;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Integer component1() {
        return this.maxWidth;
    }

    public final c component2() {
        return this.settings;
    }

    public final a component3() {
        return this.fg;
    }

    public final b component4() {
        return this.i18nText;
    }

    public final CardConfig copy(Integer r2, c r3, a r4, b r5) {
        Intrinsics.checkNotNullParameter(r3, "settings");
        Intrinsics.checkNotNullParameter(r4, "fg");
        Intrinsics.checkNotNullParameter(r5, "i18nText");
        return new CardConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CardConfig) == true) goto L8;
        return false;
    L8:
        CardConfig r6 = (CardConfig) r5;
        if (Intrinsics.areEqual(this.maxWidth, r6.maxWidth) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.settings, r6.settings) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fg, r6.fg) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.i18nText, r6.i18nText) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.maxWidth;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((((r1 * 31) + this.settings.hashCode()) * 31) + this.fg.hashCode()) * 31) + this.i18nText.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "CardConfig(maxWidth=" + this.maxWidth + ", settings=" + this.settings + ", fg=" + this.fg + ", i18nText=" + this.i18nText + ')';
    }

    public final a getFg() {
        return this.fg;
    }

    public final b getI18nText() {
        return this.i18nText;
    }

    public final Integer getMaxWidth() {
        return this.maxWidth;
    }

    public final c getSettings() {
        return this.settings;
    }

    public CardConfig(Integer r2, c r3, a r4, b r5) {
        Intrinsics.checkNotNullParameter(r3, "settings");
        Intrinsics.checkNotNullParameter(r4, "fg");
        Intrinsics.checkNotNullParameter(r5, "i18nText");
        this.maxWidth = r2;
        this.settings = r3;
        this.fg = r4;
        this.i18nText = r5;
    }

    public CardConfig(Integer r4, c r5, a r6, b r7, int r8, DefaultConstructorMarker r9) {
        if ((r8 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        int r10 = c.d;
        LynxCardFallbackStyleConfig r11 = (LynxCardFallbackStyleConfig) SettingManager.getInstance().get(LynxCardFallbackStyleConfig.class);
        LynxCardCommonConfig r12 = (LynxCardCommonConfig) SettingManager.getInstance().get(LynxCardCommonConfig.class);
        r5 = new c((LynxMsgCardTimeFormatConfig) SettingManager.getInstance().get(LynxMsgCardTimeFormatConfig.class), r11, r12);
    L9:
        if ((r8 & 4) == 0) goto L16;
        int r13 = a.b;
        Set r14 = SetsKt.setOf(new String[]{"universalcard.chart_offscreen_preview.enable", "universalcard.selectmenu.use.overlay", "universalcard.audio.enable", "universalcard.video.enable"});
        HashMap r15 = new HashMap();
        Iterator r16 = r14.iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        String r0 = (String) r16.next();
        r15.put(r0, Boolean.valueOf(f.a().isEnable(r0)));
        goto L12
    L14:
        r6 = new a(r15);
    L16:
        if ((r8 & 8) == 0) goto L18;
        int r17 = b.b;
        Context r19 = ty7.a.a().getContext();
        HashMap r20 = new HashMap();
        r20.put("translationText", r19.getString(2131890436));
        r20.put("imageTagText", r19.getString(2131891845));
        r20.put("cancelText", r19.getString(2131891541));
        r20.put("confirmText", r19.getString(2131891623));
        r20.put("textLengthError", r19.getString(2131892379));
        r20.put("inputPlaceholder", r19.getString(2131892377));
        r20.put("requiredErrorText", r19.getString(2131892378));
        r20.put("chartTagText", r19.getString(2131891483));
        r20.put("chartLoadError", r19.getString(2131891484));
        r20.put("tableTagText", r19.getString(2131892761));
        r20.put("codeBlockTagText", r19.getString(2131892386));
        r20.put("tableEmptyText", r19.getString(2131892760));
        r20.put("tableDetailShowText", r19.getString(2131892397));
        r20.put("unknownUserText", r19.getString(2131890317));
        r20.put("tableDetailHideText", r19.getString(2131892395));
        String r21 = UIHelper.getString(2131890318);
        ICUUtils.FormatArgsBuilder r1 = new ICUUtils.FormatArgsBuilder();
        r1.b("APP_DISPLAY_NAME", UIHelper.getAppName());
        r20.put("cardFallbackText", ICUUtils.icuFormat(r21, r1.a));
        r20.put("tableViewMore", r19.getString(2131890325));
        r20.put("selectPlaceholder", r19.getString(2131891991));
        String r22 = r19.getString(2131890320);
        ICUUtils.FormatArgsBuilder r2 = new ICUUtils.FormatArgsBuilder();
        r2.b("reloadBtn", "");
        r20.put("errorDefault", ICUUtils.icuFormat(r22, r2.a));
        r20.put("errorRetry", r19.getString(2131890323));
        r20.put("loading", r19.getString(2131890321));
        r20.put("searchPlaceholder", r19.getString(2131891983));
        r20.put("searchNoResult", r19.getString(2131891978));
        r20.put("audioTagText", r19.getString(2131892967));
        r7 = new b(r20);
    L18:
        this(r4, r5, r6, r7);
    }
}
