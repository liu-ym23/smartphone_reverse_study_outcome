package gx9;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.bean.PromptContent;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    static {
    }

    public static boolean a(PromptContent r10, PromptContent r11) {
        Intrinsics.checkNotNullParameter(r10, "first");
        Intrinsics.checkNotNullParameter(r11, "second");
        if (r10 != r11) goto L6;
        return true;
    L6:
        if (r10.isNoDisappear() == r11.isNoDisappear()) goto L8;
    L74:
        return false;
    L8:
        if (r10.getSuggestActionCardCnt() != r11.getSuggestActionCardCnt()) goto L74;
        if (Intrinsics.areEqual(r10.getOnboardingDisplayStyle(), r11.getOnboardingDisplayStyle()) == false) goto L74;
        if (Intrinsics.areEqual(r10.getSugType(), r11.getSugType()) == false) goto L74;
        if (Intrinsics.areEqual(r10.getBusinessExt(), r11.getBusinessExt()) == false) goto L74;
        if (Intrinsics.areEqual(r10.getWcbRenderStatus(), r11.getWcbRenderStatus()) == false) goto L74;
        if (Intrinsics.areEqual(r10.getWcbTitle(), r11.getWcbTitle()) == false) goto L74;
        if (Intrinsics.areEqual(r10.getWcbTitleStyle(), r11.getWcbTitleStyle()) == false) goto L74;
        if (Intrinsics.areEqual(r10.getSuggest(), r11.getSuggest()) == false) goto L74;
        List r1 = r10.getSuggestV2();
        List r2 = r11.getSuggestV2();
        if (r1 == r2) goto L68;
        if (r1 == null) goto L69;
        if (r2 == null) goto L69;
        if (r1.size() != r2.size()) goto L69;
        int r4 = r1.size();
        int r5 = 0;
    L32:
        if (r5 >= r4) goto L68;
        PromptContent.SuggestV2 r6 = (PromptContent.SuggestV2) ListProtector.get(r1, r5);
        PromptContent.SuggestV2 r7 = (PromptContent.SuggestV2) ListProtector.get(r2, r5);
        if (r6 == r7) goto L63;
        if (r6 == null) goto L64;
        if (r7 == null) goto L64;
        if (Intrinsics.areEqual(r6.getSuggestType(), r7.getSuggestType()) == false) goto L64;
        if (Intrinsics.areEqual(r6.getContent(), r7.getContent()) == false) goto L64;
        if (Intrinsics.areEqual(r6.getIconUrl(), r7.getIconUrl()) == false) goto L64;
        if (Intrinsics.areEqual(r6.getDarkIconUrl(), r7.getDarkIconUrl()) == false) goto L64;
        if (Intrinsics.areEqual(r6.getIconUri(), r7.getIconUri()) == false) goto L64;
        if (Intrinsics.areEqual(r6.getFontColorLight(), r7.getFontColorLight()) == false) goto L64;
        if (Intrinsics.areEqual(r6.getFontColorDark(), r7.getFontColorDark()) == false) goto L64;
        if (Intrinsics.areEqual(r6.getStrokeColorLight(), r7.getStrokeColorLight()) == false) goto L64;
        if (Intrinsics.areEqual(r6.getStrokeColorDark(), r7.getStrokeColorDark()) == false) goto L64;
        if (Intrinsics.areEqual(r6.getClickUrl(), r7.getClickUrl()) == false) goto L64;
        if (Intrinsics.areEqual(r6.getBotId(), r7.getBotId()) == false) goto L64;
        if (Intrinsics.areEqual(r6.getExtra(), r7.getExtra()) == true) goto L63;
    L64:
        boolean r8 = false;
    L65:
        if (r8 == false) goto L69;
        r5 = r5 + 1;
    L63:
        r8 = true;
    L69:
        boolean r3 = false;
    L70:
        if (r3 == false) goto L74;
        if (b(r10.getSuggestItems(), r11.getSuggestItems()) == false) goto L74;
        return true;
    L68:
        r3 = true;
        goto L70
    }

    public static boolean b(List r8, List r9) {
        if (r8 != r9) goto L6;
        return true;
    L6:
        if (r8 == null) goto L87;
        if (r9 == null) goto L87;
        if (r8.size() != r9.size()) goto L87;
        int r2 = r8.size();
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L86;
        PromptContent.SuggestItem r4 = (PromptContent.SuggestItem) ListProtector.get(r8, r3);
        PromptContent.SuggestItem r5 = (PromptContent.SuggestItem) ListProtector.get(r9, r3);
        if (r4 == r5) goto L81;
        if (r4 == null) goto L82;
        if (r5 == null) goto L82;
        if (Intrinsics.areEqual(r4.getSuggest(), r5.getSuggest()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getBgColor(), r5.getBgColor()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getDarkBgColor(), r5.getDarkBgColor()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getFontColorLight(), r5.getFontColorLight()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getFontColorDark(), r5.getFontColorDark()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getStrokeColorLight(), r5.getStrokeColorLight()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getStrokeColorDark(), r5.getStrokeColorDark()) == false) goto L82;
        if (Intrinsics.areEqual(r4.isHighlightPush(), r5.isHighlightPush()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getItemId(), r5.getItemId()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getItemType(), r5.getItemType()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getSendingContent(), r5.getSendingContent()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getSchema(), r5.getSchema()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getIconUrl(), r5.getIconUrl()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getDarkIconUrl(), r5.getDarkIconUrl()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getLightUrlItem(), r5.getLightUrlItem()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getDarkUrlItem(), r5.getDarkUrlItem()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getFrontLightUrlItem(), r5.getFrontLightUrlItem()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getFrontDarkUrlItem(), r5.getFrontDarkUrlItem()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getExpireTime(), r5.getExpireTime()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getWcbItem(), r5.getWcbItem()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getExtra(), r5.getExtra()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getQueryPassExtra(), r5.getQueryPassExtra()) == false) goto L82;
        if (r4.isRichText() != r5.isRichText()) goto L82;
        if (Intrinsics.areEqual(r4.getCandidateType(), r5.getCandidateType()) == false) goto L82;
        if (Intrinsics.areEqual(r4.isContinueAsk(), r5.isContinueAsk()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getTextIcon(), r5.getTextIcon()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getPosition(), r5.getPosition()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getDisplayRichTextContent(), r5.getDisplayRichTextContent()) == false) goto L82;
        if (Intrinsics.areEqual(r4.getSendRichTextContent(), r5.getSendRichTextContent()) == false) goto L82;
        if (b(r4.getChildCandidates(), r5.getChildCandidates()) == false) goto L82;
        if (Intrinsics.areEqual(r4.isCategoryCandidate(), r5.isCategoryCandidate()) == true) goto L81;
    L82:
        boolean r6 = false;
    L83:
        if (r6 == false) goto L84;
        r3 = r3 + 1;
        goto L12
    L84:
        return false;
    L81:
        r6 = true;
        goto L83
    L86:
        return true;
    L87:
        return false;
    }
}
