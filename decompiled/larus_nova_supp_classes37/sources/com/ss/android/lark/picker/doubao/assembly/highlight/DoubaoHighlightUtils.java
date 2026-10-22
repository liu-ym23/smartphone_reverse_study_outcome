package com.ss.android.lark.picker.doubao.assembly.highlight;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.view.span.VerticalAlignImageSpan;
import com.ss.android.lark.search.dto.info.TagContent;
import com.ss.android.lark.utils.UIHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import rz7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\b\b\u0001\u0010!\u001a\u00020\u0015H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/ss/android/lark/picker/doubao/assembly/highlight/DoubaoHighlightUtils;", "", "<init>", "()V", "HIGHLIGHT_TAG", "", "STYLE_TAG", "BOLD_TAG", "HIGHLIGHT_BOLD_TAG", "DOC_ICON_TAG", "INLINE_ICON_TAG", "DOC_ICON_TYPE", "COLOR", "GREY", "DEFAULT_COLOR", "INLINE_ICON_TYPE", "INLINE_UD_TYPE", "INSERT_SPACE_PRE", "INSERT_SPACE_AFT", "COLOR_MAP", "", "", "getCOLOR_MAP", "()Ljava/util/Map;", "addSearchHighLightedTagInternal", "", "builder", "Landroid/text/SpannableStringBuilder;", "textView", "Landroid/widget/TextView;", "tagList", "", "Lcom/ss/android/lark/search/dto/info/TagContent;", "highLightColor", "picker-doubao-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoHighlightUtils {
    private static final String BOLD_TAG = "b";
    private static final String COLOR = "color";
    private static final Map<String, Integer> COLOR_MAP = null;
    private static final String DEFAULT_COLOR = "grey";
    private static final String DOC_ICON_TAG = "di";
    private static final String DOC_ICON_TYPE = "type";
    private static final String GREY = "grey";
    private static final String HIGHLIGHT_BOLD_TAG = "hb";
    private static final String HIGHLIGHT_TAG = "h";
    private static final String INLINE_ICON_TAG = "pi";
    private static final String INLINE_ICON_TYPE = "icon";
    private static final String INLINE_UD_TYPE = "ud";
    private static final String INSERT_SPACE_AFT = " ";
    private static final String INSERT_SPACE_PRE = " ";
    public static final DoubaoHighlightUtils INSTANCE = null;
    private static final String STYLE_TAG = "asl-style";

    private DoubaoHighlightUtils() {
    }

    static {
        INSTANCE = new DoubaoHighlightUtils();
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("grey", 2131106620);
        COLOR_MAP = r0;
    }

    public final Map<String, Integer> getCOLOR_MAP() {
        return COLOR_MAP;
    }

    @JvmStatic
    public static final void addSearchHighLightedTagInternal(final SpannableStringBuilder r19, final TextView r20, List<TagContent> r21, int r22) {
        Intrinsics.checkNotNullParameter(r19, "builder");
        Intrinsics.checkNotNullParameter(r20, "textView");
        if (r21 == null) goto L70;
        Iterator<T> r10 = r21.iterator();
    L6:
        if (r10.hasNext() == false) goto L70;
        TagContent r0 = (TagContent) r10.next();
        final int r4 = r0.getContent().getStart() + 0;
        if (r4 >= r19.length()) goto L6;
        if ((r0.getContent().getContent().length() + r4) > r19.length()) goto L6;
        final int r5 = r4 + r0.getContent().getContent().length();
        String r1 = r0.getTag();
        int r3 = r1.hashCode();
        boolean r6 = true;
        if (r3 != 98) goto L15;
        if (r1.equals(BOLD_TAG) == false) goto L6;
        r19.setSpan(new StyleSpan(1), r4, r5, 33);
        r19.setSpan(new ForegroundColorSpan(UIHelper.getColor(2131106607)), r4, r5, 33);
        goto L6
    L15:
        if (r3 != 104) goto L17;
        if (r1.equals(HIGHLIGHT_TAG) == false) goto L6;
        r19.setSpan(new ForegroundColorSpan(r22), r4, r5, 33);
        goto L6
    L17:
        if (r3 != 3205) goto L19;
        r1.equals(DOC_ICON_TAG);
        goto L6
    L19:
        if (r3 != 3322) goto L21;
        if (r1.equals(HIGHLIGHT_BOLD_TAG) == false) goto L6;
        r19.setSpan(new ForegroundColorSpan(r22), r4, r5, 33);
        r19.setSpan(new StyleSpan(1), r4, r5, 33);
        goto L6
    L21:
        if (r3 != 3577) goto L23;
        if (r1.equals(INLINE_ICON_TAG) == false) goto L6;
        String r2 = (String) r0.getAttributeMap().get(INLINE_UD_TYPE);
        if (r2 != null) goto L39;
        r2 = "";
    L39:
        String r7 = (String) r0.getAttributeMap().get("icon");
        if (r7 != null) goto L42;
        String r15 = "";
    L43:
        final int r11 = (int) r20.getTextSize();
        final int r8 = r20.getCurrentTextColor();
        if (r2.length() <= 0) goto L46;
        boolean r9 = true;
    L48:
        if (r9 == true) goto L49;
        if (r15.length() > 0) goto L54;
        r6 = false;
    L54:
        if (r6 == true) goto L55;
        Drawable r12 = UDIconUtils.getIconDrawable(r20.getContext(), 2131255013);
        r12.setTint(r8);
        r12.setBounds(0, 0, r11, r11);
        r19.setSpan(new VerticalAlignImageSpan(r12), r4 + 1, r5 - 1, 33);
        goto L6
    L55:
        a.a.getEncryptIconLoader().a(r20.getContext(), r15, r11, r11, new DoubaoHighlightUtils$addSearchHighLightedTagInternal$1$1(r8, r11, r19, r4, r5, r20));
        goto L6
    L49:
        Drawable r13 = UDIconUtils.getIconDrawable(r20.getContext(), 2131255013);
        r13.setTint(r8);
        r13.setBounds(0, 0, r11, r11);
        r19.setSpan(new VerticalAlignImageSpan(r13), r4 + 1, r5 - 1, 33);
        goto L6
    L46:
        r9 = false;
        goto L48
    L42:
        r15 = r7;
        goto L43
    L23:
        if (r3 != 2089511070) goto L6;
        if (r1.equals(STYLE_TAG) == false) goto L6;
        Integer r14 = COLOR_MAP.get(r0.getAttributeMap().get(COLOR));
        if (r14 == null) goto L31;
        int r16 = r14.intValue();
    L32:
        r19.setSpan(new ForegroundColorSpan(UIHelper.getColor(r16)), r4, r5, 33);
        goto L6
    L31:
        r16 = 2131106610;
    L70:
        r20.setText(r19);
    }
}
