package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntry;
import com.ss.android.lark.export.entity.preview.ColorIcon;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.export.entity.preview.UnifiedHeaderInfo;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.span.KeyIconUrlInfo;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import com.ss.android.lark.widget.span.RichUrlInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import com.ss.android.lark.widget.span.UrlInfo;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UserStatusParseUrlPreViewUtils {
    public static final /* synthetic */ int a = 0;

    public interface a {
        void a(List<String> r1);
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final Long d;

        public b(String r2, String r3, String r4, Long r5) {
            Intrinsics.checkNotNullParameter(r2, "description");
            Intrinsics.checkNotNullParameter(r3, "userId");
            Intrinsics.checkNotNullParameter(r4, "sourceTextMD5");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }

    public static UrlInfo a(UrlInlinePreviewEntity r7) {
        UrlInfo r0 = new UrlInfo();
        if (r7.getUdIcon() == null) goto L5;
        UDIcon r1 = r7.getUdIcon();
        RichUrlInfo r2 = new RichUrlInfo();
        d(r1, r2, r7);
        return r2;
    L5:
        String r3 = r7.getNetIconKey();
        boolean r4 = false;
        if (r3 != null) goto L8;
    L11:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L23;
        String r6 = r7.getTitle();
        if (r6 != null) goto L17;
    L20:
        boolean r8 = true;
    L21:
        if (r8 == true) goto L23;
        KeyIconUrlInfo r9 = new KeyIconUrlInfo();
        r9.iconKey = r7.getNetIconKey();
        r9.placeHolderRes = 2131255013;
        ((SpanInfo) r9).text = "$" + r7.getTitle() + " ";
        r9.isUrlPreview = true;
        return r9;
    L17:
        if (r6.length() == 0) goto L20;
        r8 = false;
    L23:
        String r10 = r7.getTitle();
        if (r10 != null) goto L26;
    L27:
        r4 = true;
    L28:
        if (r4 == true) goto L30;
        RichUrlInfo r11 = new RichUrlInfo();
        r11.mLocalImageResId = 2131255013;
        r11.mDisplayTitle = r7.getTitle();
        ((SpanInfo) r11).text = "$" + r7.getTitle() + " ";
        return r11;
    L30:
        Log.i("[URLPreview]UserStatusParseUtils", "title is null");
        Url r12 = r7.getUrl();
        String r13 = null;
        if (r12 == null) goto L33;
        String r14 = r12.getUrl();
    L34:
        r0.content = r14;
        Url r15 = r7.getUrl();
        if (r15 == null) goto L37;
        r13 = r15.getUrl();
    L37:
        ((SpanInfo) r0).text = r13;
        return r0;
    L33:
        r14 = null;
        goto L34
    L26:
        if (r10.length() != 0) goto L28;
    L8:
        if (r3.length() == 0) goto L11;
        r5 = false;
        goto L13
    }

    @JvmStatic
    public static final void b(a2b.f r9, Collection<b> r10, a r11) {
        Intrinsics.checkNotNullParameter(r9, "previewService");
        Intrinsics.checkNotNullParameter(r10, "signUrlPreviewParamsList");
        Intrinsics.checkNotNullParameter(r11, "callback");
        ArrayList r0 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r1 = r12.next();
        if (StringsKt.contains$default(((b) r1).a, "http", false, 2, null) == false) goto L4;
        r0.add(r1);
        goto L4
    L9:
        if (r0.isEmpty() == false) goto L11;
        return;
    L11:
        final WeakReference r13 = new WeakReference(r11);
        LinkedHashMap r14 = new LinkedHashMap();
        Iterator r2 = r0.iterator();
    L13:
        if (r2.hasNext() == false) goto L26;
        Object r3 = r2.next();
        Long r4 = ((b) r3).d;
        if (r4 == null) goto L17;
        long r5 = r4.longValue();
    L19:
        if (r5 <= 0) goto L21;
        UrlPreViewEntries.UrlPreViewSourceType r6 = UrlPreViewEntries.UrlPreViewSourceType.PRIVATE_DESCRIPTION;
    L22:
        Object r7 = r14.get(r6);
        if (r7 != null) goto L25;
        r7 = new ArrayList();
        r14.put(r6, r7);
    L25:
        ((List) r7).add(r3);
        goto L13
    L21:
        r6 = UrlPreViewEntries.UrlPreViewSourceType.PERSONAL_SIG;
        goto L22
    L17:
        r5 = 0;
        goto L19
    L26:
        Iterator r15 = r14.entrySet().iterator();
    L28:
        if (r15.hasNext() == false) goto L42;
        Map.Entry r8 = (Map.Entry) r15.next();
        UrlPreViewEntries.UrlPreViewSourceType r16 = (UrlPreViewEntries.UrlPreViewSourceType) r8.getKey();
        final List r17 = (List) r8.getValue();
        List r18 = r17;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r20 = r18.iterator();
    L31:
        if (r20.hasNext() == false) goto L33;
        r19.add(((b) r20.next()).b);
        goto L31
    L33:
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r22 = r18.iterator();
    L35:
        if (r22.hasNext() == false) goto L37;
        r21.add(((b) r22.next()).c);
        goto L35
    L37:
        SyncDataStrategy r23 = SyncDataStrategy.TRY_LOCAL;
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r25 = r18.iterator();
    L39:
        if (r25.hasNext() == false) goto L41;
        r24.add(((b) r25.next()).d);
        goto L39
    L41:
        r9.r4(r19, r21, r23, r16, r24, new UIGetDataCallback(new UserStatusParseUrlPreViewUtils$handleBatchSignUrlRequest$1$4(r13, r17)));
        goto L28
    }

    public static void d(UDIcon r2, RichUrlInfo r3, UrlInlinePreviewEntity r4) {
        String r0 = null;
        if (r2 == null) goto L5;
        String r1 = r2.getUnicode();
    L6:
        if (r1 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L22;
        int r6 = edb.a.a;
        if (r2 == null) goto L16;
        String r7 = r2.getKey();
    L17:
        r3.mLocalImageResId = edb.a.a(r7);
        if (r2 == null) goto L25;
        ThemeColor r8 = r2.getThemeColor();
        if (r8 == null) goto L25;
        r3.iconColor = com.ss.android.lark.export.entity.preview.a.a(r8, UIHelper.getContext(), null);
    L25:
        r3.mDisplayTitle = r4.getTitle();
        ((SpanInfo) r3).text = "$" + r4.getTitle() + " ";
        return;
    L16:
        r7 = null;
        goto L17
    L22:
        if (r2 == null) goto L24;
        r0 = r2.getUnicode();
    L24:
        r3.unicode = r0;
        goto L25
    L8:
        if (r1.length() == 0) goto L11;
        r5 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public static Map c(List r45, Collection r46, ChatHitPointExtraParams.UrlAnalysisScene r47, ChatHitPointExtraParams.DataSource r48) {
        Intrinsics.checkNotNullParameter(r45, Keys.API_RETURN_KEY_DATA);
        Intrinsics.checkNotNullParameter(r46, "signUrlPreviewParamsList");
        HashMap r2 = new HashMap(r45.size());
        Iterator r0 = r45.iterator();
    L4:
        if (r0.hasNext() == false) goto L149;
        UrlPreViewEntries r3 = (UrlPreViewEntries) r0.next();
        String r4 = r3.getSourceId();
        boolean r6 = true;
        if (r4 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L14;
    L13:
        Iterator r16 = r0;
    L148:
        r0 = r16;
        goto L4
    L14:
        String r7 = r3.getSourceId();
        if (r7 == null) goto L13;
        Iterator r8 = r46.iterator();
    L19:
        if (r8.hasNext() == false) goto L40;
        Object r9 = r8.next();
        b r10 = (b) r9;
        if (Intrinsics.areEqual(r10.b, r7) == true) goto L23;
    L37:
        boolean r11 = false;
    L38:
        if (r11 == false) goto L19;
    L41:
        b r13 = (b) r9;
        if (r13 == null) goto L13;
        String r14 = r13.a;
        if (r14.length() != 0) goto L47;
        boolean r12 = true;
    L48:
        if (r12 == true) goto L13;
        ArrayList r15 = new ArrayList();
        Iterator<T> r17 = r3.getEntryList().iterator();
    L51:
        if (r17.hasNext() == false) goto L143;
        UrlPreViewEntry r18 = (UrlPreViewEntry) r17.next();
        Charset r19 = Charsets.UTF_8;
        byte[] r110 = r14.getBytes(r19);
        if (r18.getPreviewEntity() == null) goto L141;
        UrlInlinePreviewEntity r111 = r18.getPreviewEntity();
        Intrinsics.checkNotNull(r111);
        if (r111.getUseColorIcon() == false) goto L85;
        UnifiedHeaderInfo r112 = r111.getHeaderInfo();
        if (r112 == null) goto L59;
        ColorIcon r113 = r112.getIcon();
    L60:
        if (r113 == null) goto L84;
        UnifiedHeaderInfo r114 = r111.getHeaderInfo();
        if (r114 == null) goto L64;
        ColorIcon r115 = r114.getIcon();
    L65:
        if (r115 != null) goto L68;
        UrlInfo r20 = null;
    L82:
        if (r20 != null) goto L86;
        r20 = new UrlInfo();
    L86:
        Url r1 = r111.getUrl();
        if (r1 == null) goto L89;
        String r21 = r1.getAndroidUrl();
    L90:
        if (r21 != null) goto L92;
    L95:
        boolean r22 = true;
    L96:
        if (r22 == false) goto L100;
        Url r23 = r111.getUrl();
        if (r23 == null) goto L103;
        String r24 = r23.getUrl();
    L104:
        r20.href = r24;
        if (r18.getOffset() > 0) goto L107;
        ((SpanInfo) r20).start = 0;
    L113:
        if (r18.getOffset() < r110.length) goto L116;
        Log.i("[URLPreview]UserStatusParseUtils", "offset >= signByte.size,previewId: " + r18.getPreviewId() + ",signByte.size:" + r110.length);
        int r25 = r110.length - 1;
    L120:
        if ((r18.getOffset() + r18.getLength()) <= r110.length) goto L122;
        Log.i("[URLPreview]UserStatusParseUtils", "offset + length > signByte.size ,previewId:" + r18.getPreviewId());
        int r26 = r110.length;
    L123:
        int r27 = ((SpanInfo) r20).start + new String(ArraysKt.copyOfRange(r110, r25, r26), r19).length();
        ((SpanInfo) r20).end = r27;
        if (r27 <= r14.length()) goto L126;
        ((SpanInfo) r20).end = r14.length();
        Log.i("[URLPreview]UserStatusParseUtils", "urlInfo.end > description.length,previewId:" + r18.getPreviewId() + ",des.length:" + r14.length());
    L126:
        String r28 = r14.substring(((SpanInfo) r20).start, ((SpanInfo) r20).end);
        String r29 = r20.href;
        if (r29 != null) goto L129;
    L132:
        boolean r30 = true;
    L133:
        if (r30 == false) goto L135;
        r20.href = r28;
    L135:
        ((SpanInfo) r20).type = 1;
        r15.add(r20);
        Long r31 = o1.a(r7);
        if (r31 == null) goto L142;
        if (r47 == null) goto L142;
        if (o1.a(r18.getPreviewId() + r47.getValue()) != null) goto L142;
        com.ss.android.lark.chatwindow.view.preview.i.e(r47, r18.getPreviewId(), r20.href, r48, r31.longValue());
    L142:
        r0 = r0;
        r6 = true;
        goto L51
    L129:
        if (r29.length() == 0) goto L132;
        r30 = false;
        goto L133
    L122:
        r26 = r18.getOffset() + r18.getLength();
        goto L123
    L116:
        if (r18.getOffset() <= 0) goto L118;
        r25 = r18.getOffset();
        goto L120
    L118:
        Log.i("[URLPreview]UserStatusParseUtils", "offset <= 0, previewId:" + r18.getPreviewId());
        r25 = 0;
        goto L120
    L107:
        if (r18.getOffset() <= r110.length) goto L109;
        int r32 = r110.length;
    L110:
        ((SpanInfo) r20).start = new String(ArraysKt.copyOfRange(r110, 0, r32), r19).length();
        goto L113
    L109:
        r32 = r18.getOffset();
    L103:
        r24 = null;
        goto L104
    L100:
        Url r33 = r111.getUrl();
        if (r33 == null) goto L103;
        r24 = r33.getAndroidUrl();
        goto L104
    L92:
        if (r21.length() == 0) goto L95;
        r22 = false;
        goto L96
    L89:
        r21 = null;
        goto L90
    L68:
        if (r115.getUdIcon() == null) goto L71;
        r20 = new RichUrlInfo();
        d(r115.getUdIcon(), r20, r111);
        ((RichUrlInfo) r20).isColorIcon = r6;
        goto L82
    L71:
        r20 = new KeyIconUrlInfo();
        ((KeyIconUrlInfo) r20).isColorIcon = r6;
        if (r115.getImageSet() == null) goto L78;
        ImageSet r34 = r115.getImageSet();
        if (r34 == null) goto L76;
        String r35 = r34.getKey();
    L77:
        ((KeyIconUrlInfo) r20).iconKey = r35;
    L79:
        ((KeyIconUrlInfo) r20).placeHolderRes = 2131255013;
        ((SpanInfo) r20).text = "$" + r111.getTitle() + " ";
        ((KeyIconUrlInfo) r20).isUrlPreview = true;
        ThemeColor r36 = r115.getThemeColor();
        if (r36 == null) goto L82;
        ((KeyIconUrlInfo) r20).iconColor = com.ss.android.lark.export.entity.preview.a.a(r36, UIHelper.getContext(), null);
        goto L82
    L76:
        r35 = null;
        goto L77
    L78:
        ((KeyIconUrlInfo) r20).iconKey = r115.getFaviconUrl();
        goto L79
    L64:
        r115 = null;
        goto L65
    L84:
        r0 = r0;
        r20 = a(r111);
        goto L86
    L59:
        r113 = null;
        goto L60
    L85:
        r0 = r0;
        r20 = a(r111);
        goto L86
    L141:
        r0 = r0;
        goto L142
    L143:
        r16 = r0;
        Pattern r37 = com.ss.android.lark.widget.span.g0.d;
        com.ss.android.lark.widget.span.g0 r38 = com.ss.android.lark.widget.span.g0.a.a;
        r38.getClass();
        if (TextUtils.isEmpty(r14) == false) goto L146;
        RecogniseSpansResult r39 = null;
    L147:
        h6b.g r40 = h6b.g.b;
        UrlPreViewEntries.UrlPreViewSourceType r41 = r3.getSourceType();
        String r42 = r13.c;
        Long r116 = r3.getPrivateDescriptionId();
        r40.getClass();
        h6b.g.c(r7, r41, r42, "[URLPreview] Removed Old Sign", r14, r116);
        com.ss.android.lark.widget.span.f0.a.a.b(k6b.c.a(r7, r14, r3.getPrivateDescriptionId()), r39);
        h6b.g.c(r7, r3.getSourceType(), r13.c, "[URLPreview] parse result Sign", r14, r3.getPrivateDescriptionId());
        r2.put(r7, r39);
        goto L148
    L146:
        ArrayList r43 = new ArrayList();
        com.ss.android.lark.widget.span.g0.a(r43, r15);
        List r44 = com.ss.android.lark.widget.span.g0.e(r14, r43);
        com.ss.android.lark.widget.span.g0.a(r43, r44);
        List r49 = com.ss.android.lark.widget.span.g0.h(r14, null, r43);
        com.ss.android.lark.widget.span.g0.a(r43, r49);
        ((ArrayList) r49).addAll(r15);
        List r50 = r38.f(r14, r43);
        com.ss.android.lark.widget.span.g0.a(r43, r50);
        new ArrayList();
        new ArrayList();
        new ArrayList();
        r39 = new RecogniseSpansResult(r49, r44, r50, new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        goto L147
    L47:
        r12 = false;
        goto L48
    L23:
        if (Intrinsics.areEqual(r10.c, r3.getSourceTextMD5()) == false) goto L37;
        Long r117 = r10.d;
        if (r117 == null) goto L27;
        long r118 = r117.longValue();
    L28:
        Long r119 = r3.getPrivateDescriptionId();
        if (r119 != null) goto L32;
        r119 = 0L;
    L32:
        if ((r119 instanceof Long) == false) goto L37;
        if (r118 != r119.longValue()) goto L37;
        r11 = true;
        goto L38
    L27:
        r118 = 0;
        goto L28
    L40:
        r9 = null;
        goto L41
    L8:
        if (r4.length() == 0) goto L11;
        r5 = false;
        goto L12
    L149:
        return r2;
    }
}
