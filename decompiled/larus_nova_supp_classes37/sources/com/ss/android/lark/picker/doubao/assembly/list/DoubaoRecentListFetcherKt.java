package com.ss.android.lark.picker.doubao.assembly.list;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.ss.android.lark.picker.base.PickerRecentSpaceInfo;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a%\u0010\u000b\u001a\u00020\f2\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000f0\u000e\"\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"toSearchBaseInfoOrNull", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lcom/bytedance/ee/bear/list/dto/Document;", "toSpaceInfo", "Lcom/ss/android/lark/search/dto/info/SearchSpaceInfo;", "toWikiInfo", "Lcom/ss/android/lark/search/dto/info/SearchWikiInfo;", "mapDocumentTypeToPbDocType", "Lcom/bytedance/lark/pb/basic/v1/Doc$Type;", "typeValue", "", "parseTimeSec", "", "candidates", "", "", "([Ljava/lang/String;)J", "picker-doubao-assembly_release"}, k = 2, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoRecentListFetcherKt {
    public static final /* synthetic */ SearchBaseInfo access$toSearchBaseInfoOrNull(Document r0) {
        return toSearchBaseInfoOrNull(r0);
    }

    private static final Doc.Type mapDocumentTypeToPbDocType(int r1) {
        if (r1 == 0) goto L35;
        if (r1 == 8) goto L46;
        if (r1 == 16) goto L45;
        if (r1 == 22) goto L44;
        if (r1 == 25) goto L43;
        if (r1 == 30) goto L42;
        if (r1 == 111) goto L41;
        if (r1 == 2) goto L40;
        if (r1 == 3) goto L39;
        if (r1 == 11) goto L38;
        if (r1 == 12) goto L37;
        return Doc.Type.UNKNOWN;
    L37:
        return Doc.Type.FILE;
    L38:
        return Doc.Type.MINDNOTE;
    L39:
        return Doc.Type.SHEET;
    L40:
        return Doc.Type.DOC;
    L41:
        return Doc.Type.WIKI;
    L42:
        return Doc.Type.SLIDES;
    L43:
        return Doc.Type.SHORTCUT;
    L44:
        return Doc.Type.DOCX;
    L45:
        return Doc.Type.WIKI;
    L46:
        return Doc.Type.BITABLE;
    L35:
        return Doc.Type.FOLDER;
    }

    private static final long parseTimeSec(String... r5) {
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L20;
        String r3 = r5[r2];
        if (r3 == null) goto L7;
        String r4 = StringsKt.trim(r3).toString();
    L8:
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        if (r4.length() != 0) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == true) goto L19;
        Long r7 = StringsKt.toLongOrNull(r4);
        if (r7 == null) goto L19;
        return r7.longValue();
    L19:
        r2 = r2 + 1;
        goto L3
    L13:
        r6 = false;
        goto L14
    L7:
        r4 = null;
        goto L8
    L20:
        return 0;
    }

    private static final SearchBaseInfo toSearchBaseInfoOrNull(Document r2) {
        int r0 = r2.getType();
        if (r0 == 16) goto L8;
        if (r0 == 111) goto L8;
        return toSpaceInfo(r2);
    L8:
        return toWikiInfo(r2);
    }

    private static final SearchSpaceInfo toSpaceInfo(Document r9) {
        int r0 = r9.getType();
        String r1 = r9.c;
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r3 = r9.d;
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        String r4 = r9.p;
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        String r5 = r9.a;
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        String r6 = r9.F2;
        if (r6 == null) goto L18;
        r2 = r6;
    L18:
        long r7 = parseTimeSec(new String[]{r9.l});
        PickerRecentSpaceInfo r10 = new PickerRecentSpaceInfo();
        r10.originalDocType = r0;
        if (StringsKt.isBlank(r1) == false) goto L21;
        r1 = r3;
    L21:
        r10.setId(r1);
        r10.setTitle(r5);
        r10.setFileType(String.valueOf(r0));
        r10.setDocType(mapDocumentTypeToPbDocType(r0));
        r10.setDocUrl(r4);
        r10.setToken(r3);
        r10.setIconInfo(r2);
        r10.setIsShareFolder(r10.getIsShareFolder());
        r10.setUpdateTime(r7);
        r10.setLastOpenTime(r7);
        return r10;
    }

    private static final SearchWikiInfo toWikiInfo(Document r12) {
        String r0 = r12.c;
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = r12.d;
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        String r3 = r12.p;
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        String r4 = r12.a;
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        String r5 = r12.F2;
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        String r6 = r12.G1;
        if (r6 == null) goto L21;
        r1 = r6;
    L21:
        long r7 = parseTimeSec(new String[]{r12.l});
        int r8 = r12.y1;
        if (r8 > 0) goto L25;
        r8 = r12.getType();
    L25:
        SearchWikiInfo r9 = new SearchWikiInfo();
        if (StringsKt.isBlank(r0) == true) goto L28;
        String r10 = r0;
    L32:
        r9.setId(r10);
        r9.setTitle(r4);
        r9.setUrl(r3);
        r9.setToken(r0);
        PickerRecentSpaceInfo r11 = new PickerRecentSpaceInfo();
        r11.originalDocType = r8;
        r11.originalRealType = r12.y1;
        if (StringsKt.isBlank(r1) == true) goto L35;
        r2 = r1;
    L38:
        r11.setId(r2);
        r11.setTitle(r4);
        r11.setFileType(String.valueOf(r8));
        r11.setDocType(mapDocumentTypeToPbDocType(r8));
        r11.setDocUrl(r3);
        if (StringsKt.isBlank(r1) == true) goto L42;
        r0 = r1;
    L42:
        r11.setToken(r0);
        r11.setIconInfo(r5);
        r11.setIsShareFolder(Boolean.valueOf(r12.P1));
        r11.setUpdateTime(r7);
        r9.setSpaceInfo(r11);
        return r9;
    L35:
        if (StringsKt.isBlank(r2) == false) goto L38;
        r2 = r3;
        goto L38
    L28:
        if (StringsKt.isBlank(r2) == false) goto L30;
        r10 = r3;
        goto L32
    L30:
        r10 = r2;
        goto L32
    }
}
