package com.obric.memorydata.utils;

import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t\u001a0\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u00062\b\b\u0002\u0010\b\u001a\u00020\t\u001a(\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t\u001a(\u0010\u000f\u001a\u00020\u000e*\u00020\u000e2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u00062\b\b\u0002\u0010\b\u001a\u00020\t\u001a=\u0010\u0010\u001a\u00020\u000e*\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u0016\u001a6\u0010\u0017\u001a\u00020\u000e*\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\b\u001a\u00020\t\u001a,\u0010\u001b\u001a\u00020\u000e*\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\b\u001a\u00020\t\u001aE\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\u001c\u001a>\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\b\u001a\u00020\t\u001a8\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\b\u001a\u00020\t\u001a8\u0010\"\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u00142\b\b\u0002\u0010%\u001a\u00020!2\b\b\u0002\u0010\b\u001a\u00020\t\u001a4\u0010&\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\b\u001a\u00020\t\u001a0\u0010'\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020)0\u00062\b\b\u0002\u0010\b\u001a\u00020\t\u001a\\\u0010'\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u001e\u0010*\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00040+0\u00062\b\b\u0002\u0010-\u001a\u00020\u00142\b\b\u0002\u0010.\u001a\u00020\u001a2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\b\b\u0002\u0010\b\u001a\u00020\t\u001aP\u00101\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u00103\u001a\u00020\u001a2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\b\b\u0002\u0010\b\u001a\u00020\t\u001aT\u00104\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u0003060\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u00103\u001a\u00020\u001a2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\b\b\u0002\u0010\b\u001a\u00020\t\u001a0\u00107\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020,0\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0014\u001aD\u00108\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020,0\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u00109\u001a\u00020\u001a2\b\b\u0002\u0010:\u001a\u00020\u001a\u001a@\u0010;\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\u0018\u0010=\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010>\u001a>\u0010?\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010@\u001a\u00020\u00042\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00010B2\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00010B2\b\b\u0002\u0010\b\u001a\u00020\t\u001a,\u0010D\u001a\u00020\u0001*\u00020\u00022\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t\u001a*\u0010H\u001a\u00020\u0001*\u00020\u00022\u0006\u0010I\u001a\u00020\u00042\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00010B2\b\b\u0002\u0010\b\u001a\u00020\t\u001a\n\u0010K\u001a\u00020\u0001*\u00020\u0002\u001a0\u0010L\u001a\u00020\u0001*\u00020\u00022\u0006\u0010M\u001a\u00020\u00142\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020)0\u00062\b\b\u0002\u0010\b\u001a\u00020\t\u001a0\u0010N\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020,0\u00062\b\b\u0002\u0010\b\u001a\u00020\t\u001a0\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020,0\u00062\b\b\u0002\u0010P\u001a\u00020Q¨\u0006R"}, d2 = {"setStyledText", "", "Landroid/widget/TextView;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "styleMap", "", "Lcom/obric/memorydata/utils/TextStyle;", "placeholderConfig", "Lcom/obric/memorydata/utils/PlaceholderConfig;", "setMixedRichText", "styleConfigMap", "Lcom/obric/memorydata/utils/StyleConfig;", "applyStyles", "Landroid/text/SpannableStringBuilder;", "applyMixedStyles", "highlightKeywords", "keywords", "", "textColor", "", "highlightColor", "(Landroid/text/SpannableStringBuilder;Ljava/util/List;ILjava/lang/Integer;Lcom/obric/memorydata/utils/PlaceholderConfig;)Landroid/text/SpannableStringBuilder;", "emphasizeKeywords", TypedValues.Custom.S_COLOR, "bold", "", "strikethroughKeywords", "(Landroid/widget/TextView;Ljava/lang/String;Ljava/util/List;ILjava/lang/Integer;Lcom/obric/memorydata/utils/PlaceholderConfig;)V", "setTitleStyle", "titleKeyword", "titleColor", "titleSize", "", "setPriceStyle", "priceKeyword", "priceColor", "relativeSize", "setStrikethroughStyle", "setRichText", "linkMap", "Lcom/obric/memorydata/utils/LinkStyle;", "actions", "Lkotlin/Pair;", "Lcom/obric/memorydata/utils/ClickAction;", "defaultColor", "defaultUnderline", "callback", "Lcom/obric/memorydata/utils/OnClickCallback;", "setRichTextWithBrowserLinks", "links", "underline", "setRichTextWithActivityLinks", "activities", "Ljava/lang/Class;", "setHtmlStyleText", "setNaturalLanguageText", "wholeWordOnly", "caseSensitive", "setCodeStyleText", "variables", "onVariableClick", "Lkotlin/Function2;", "setTermsText", "termsText", "onTermsClick", "Lkotlin/Function0;", "onPrivacyClick", "setContactText", MemoryKeyInfoEntity.KEY_PHONE, NotificationCompat.CATEGORY_EMAIL, "website", "setVersionText", "currentVersion", "onCheckUpdate", "setUserAgreementText", "setMultiLanguageRichText", "textResId", "setThemedRichText", "setAdvancedRichText", "config", "Lcom/obric/memorydata/utils/RichTextConfig;", "utils_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class aq {
    public static final void a(TextView r20, String r21, List<String> r22, int r23, Integer r24, al r25) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r20, "<this>");
        Intrinsics.checkNotNullParameter(r21, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r3, "keywords");
        Intrinsics.checkNotNullParameter(r25, "placeholderConfig");
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        LinkedHashMap r5 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r4, 10)), 16));
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Object r7 = r6.next();
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
        r8.put(r7, new av(Integer.valueOf(r23), false, false, false, false, r24, null, null, 222, null));
        goto L4
    L6:
        a(r20, r21, (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin"), r25);
    }

    public static /* synthetic */ void a(TextView r6, String r7, List r8, int r9, Integer r10, al r11, int r12, Object r13) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 4) == 0) goto L5;
        r9 = -16776961;
    L5:
        int r3 = r9;
        if ((r12 & 8) == 0) goto L8;
        r10 = null;
    L8:
        Integer r4 = r10;
        if ((r12 & 16) == 0) goto L11;
        r11 = al.f13166a.a();
    L11:
        a(r6, r7, r2, r3, r4, r11);
    }

    public static final void a(TextView r2, String r3, Map<String, av> r4, al r5) {
        Map<String, av> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r6, "styleMap");
        Intrinsics.checkNotNullParameter(r5, "placeholderConfig");
        ap.f13173a.a(r2, r3, r6, r5);
    }
}
