package com.ss.android.lark.picker.doubao.utils;

import com.bytedance.lark.pb.basic.v1.Doc;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.config.condition.DocType;
import com.ss.android.lark.picker.config.condition.DocTypes;
import com.ss.android.lark.picker.doubao.entity.DoubaoPickerEntity;
import com.ss.android.lark.picker.doubao.entity.condition.DoubaoDocCondition;
import com.ss.android.lark.picker.doubao.entity.condition.DoubaoDocType;
import com.ss.android.lark.picker.doubao.entity.condition.DoubaoDocTypes;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0014J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/picker/doubao/utils/DoubaoPickerUtils;", "", "<init>", "()V", "TAG", "", "mapPbDocTypeToCcmDocumentTypeValue", "", "docType", "Lcom/bytedance/lark/pb/basic/v1/Doc$Type;", "(Lcom/bytedance/lark/pb/basic/v1/Doc$Type;)Ljava/lang/Integer;", "toDoubaoEntity", "Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerEntity;", "info", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "mapCcmDocumentTypeValueToPbDocType", "fileType", "fromDoubaoEntity", "entity", "mapDocCondition", "Lcom/ss/android/lark/picker/config/condition/DocTypes;", "docCondition", "Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocCondition;", "mapDocTypesToRecentObjTypeList", "", "docTypes", "mapDocTypes", "Lcom/ss/android/lark/picker/doubao/entity/condition/DoubaoDocTypes;", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoPickerUtils {
    public static final DoubaoPickerUtils INSTANCE = null;
    public static final String TAG = "DoubaoPickerUtils";

    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;

        static {
            int[] r0 = new int[Doc.Type.values().length];
            r0[Doc.Type.FOLDER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L45
        L92:
            r0[Doc.Type.DOC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L46
        L102:
            r0[Doc.Type.SHEET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L47
        L108:
            r0[Doc.Type.BITABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L48
        L110:
            r0[Doc.Type.MINDNOTE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L49
        L122:
            r0[Doc.Type.FILE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L50
        L130:
            r0[Doc.Type.WIKI.ordinal()] = 7;     // Catch: NoSuchFieldError -> L51
        L84:
            r0[Doc.Type.DOCX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L52
        L94:
            r0[Doc.Type.SHORTCUT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L53
        L96:
            r0[Doc.Type.SLIDES.ordinal()] = 10;     // Catch: NoSuchFieldError -> L54
        L22:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[DocType.values().length];
            r1[DocType.BITABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L55
        L120:
            r1[DocType.MINDNOTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L56
        L126:
            r1[DocType.DOCX.ordinal()] = 3;     // Catch: NoSuchFieldError -> L57
        L74:
            r1[DocType.FILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L58
        L80:
            r1[DocType.SHEET.ordinal()] = 5;     // Catch: NoSuchFieldError -> L59
        L88:
            r1[DocType.SLIDES.ordinal()] = 6;     // Catch: NoSuchFieldError -> L60
        L98:
            r1[DocType.SLIDE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L61
        L104:
            r1[DocType.DOC.ordinal()] = 8;     // Catch: NoSuchFieldError -> L62
        L112:
            r1[DocType.FOLDER.ordinal()] = 9;     // Catch: NoSuchFieldError -> L63
        L118:
            r1[DocType.WIKI.ordinal()] = 10;     // Catch: NoSuchFieldError -> L64
        L33:
            $EnumSwitchMapping$1 = r1;
            int[] r2 = new int[DoubaoDocType.values().length];
            r2[DoubaoDocType.DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L65
        L82:
            r2[DoubaoDocType.FOLDER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L66
        L90:
            r2[DoubaoDocType.WIKI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L67
        L100:
            r2[DoubaoDocType.BITABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L68
        L106:
            r2[DoubaoDocType.MINDNOTE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L69
        L116:
            r2[DoubaoDocType.DOCX.ordinal()] = 6;     // Catch: NoSuchFieldError -> L70
        L124:
            r2[DoubaoDocType.FILE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L71
        L128:
            r2[DoubaoDocType.SLIDES.ordinal()] = 8;     // Catch: NoSuchFieldError -> L72
        L76:
            r2[DoubaoDocType.SHEET.ordinal()] = 9;     // Catch: NoSuchFieldError -> L73
        L43:
            $EnumSwitchMapping$2 = r2;
        }
    }

    static {
        INSTANCE = new DoubaoPickerUtils();
    }

    private DoubaoPickerUtils() {
    }

    private final Doc.Type mapCcmDocumentTypeValueToPbDocType(int r2) {
        if (r2 == 0) goto L32;
        if (r2 == 8) goto L42;
        if (r2 == 16) goto L41;
        if (r2 == 22) goto L40;
        if (r2 == 25) goto L39;
        if (r2 == 30) goto L38;
        if (r2 == 2) goto L37;
        if (r2 == 3) goto L36;
        if (r2 == 11) goto L35;
        if (r2 == 12) goto L34;
        return null;
    L34:
        return Doc.Type.FILE;
    L35:
        return Doc.Type.MINDNOTE;
    L36:
        return Doc.Type.SHEET;
    L37:
        return Doc.Type.DOC;
    L38:
        return Doc.Type.SLIDES;
    L39:
        return Doc.Type.SHORTCUT;
    L40:
        return Doc.Type.DOCX;
    L41:
        return Doc.Type.WIKI;
    L42:
        return Doc.Type.BITABLE;
    L32:
        return Doc.Type.FOLDER;
    }

    private final DocTypes mapDocTypes(DoubaoDocTypes r4) {
        if (Intrinsics.areEqual(r4, DoubaoDocTypes.NONE.INSTANCE) == false) goto L6;
        return DocTypes.NONE.INSTANCE;
    L6:
        if (Intrinsics.areEqual(r4, DoubaoDocTypes.ALL.INSTANCE) == false) goto L9;
        return DocTypes.ALL.INSTANCE;
    L9:
        if ((r4 instanceof DoubaoDocTypes.NEW) == false) goto L30;
        Set<DoubaoDocType> r5 = ((DoubaoDocTypes.NEW) r4).getTypes();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L28;
        DoubaoDocType r1 = (DoubaoDocType) r6.next();
        switch(WhenMappings.$EnumSwitchMapping$2[r1.ordinal()]) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            default: goto L16;
        };
    L17:
        DocType r2 = DocType.SHEET;
    L26:
        r0.add(r2);
        goto L12
    L18:
        r2 = DocType.SLIDES;
        goto L26
    L19:
        r2 = DocType.FILE;
        goto L26
    L20:
        r2 = DocType.DOCX;
        goto L26
    L21:
        r2 = DocType.MINDNOTE;
        goto L26
    L22:
        r2 = DocType.BITABLE;
        goto L26
    L23:
        r2 = DocType.WIKI;
        goto L26
    L24:
        r2 = DocType.FOLDER;
        goto L26
    L25:
        r2 = DocType.DOC;
        goto L26
    L16:
        throw new NoWhenBranchMatchedException();
    L28:
        return new DocTypes.NEW(CollectionsKt.toSet(r0));
    L30:
        throw new NoWhenBranchMatchedException();
    }

    private final Integer mapPbDocTypeToCcmDocumentTypeValue(Doc.Type r2) {
        if (r2 != null) goto L4;
        int r3 = -1;
    L5:
        switch(r3) {
            case 1: goto L17;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            default: goto L6;
        };
    L6:
        return null;
    L19:
        return 30;
    L20:
        return 25;
    L21:
        return 22;
    L22:
        return 16;
    L23:
        return 12;
    L24:
        return 11;
    L25:
        return 8;
    L26:
        return 3;
    L27:
        return 2;
    L17:
        return 0;
    L4:
        r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        goto L5
    }

    public final SearchBaseInfo fromDoubaoEntity(DoubaoPickerEntity r5) {
        Intrinsics.checkNotNullParameter(r5, "entity");
        Log.i(TAG, "fromDoubaoEntity: fileToken=" + r5.getFileToken() + ", fileType=" + r5.getFileType());
        Doc.Type r0 = mapCcmDocumentTypeValueToPbDocType(r5.getFileType());
        if (r0 != null) goto L5;
        r0 = Doc.Type.UNKNOWN;
    L5:
        SearchSpaceInfo r1 = new SearchSpaceInfo();
        r1.setDocType(r0);
        r1.setTitle(r5.getFileName());
        r1.setToken(r5.getFileToken());
        r1.setDocUrl(r5.getFileURL());
        r1.setLastOpenTime(r5.getOpenTime());
        r1.setUpdateTime(r5.getEditTime());
        r1.setIconInfo(r5.getIconInfo());
        r1.setBitableBizType(r5.getBitableBizType());
        r1.setId(r5.getFileToken());
        if (r5.getFileType() != 16) goto L9;
        SearchWikiInfo r2 = new SearchWikiInfo();
        r2.setUrl(r5.getFileURL());
        r2.setToken(r5.getFileToken());
        r2.setSpaceInfo(r1);
        return r2;
    L9:
        return r1;
    }

    public final DocTypes mapDocCondition(DoubaoDocCondition r2) {
        Intrinsics.checkNotNullParameter(r2, "docCondition");
        if ((r2 instanceof DoubaoDocTypes) == false) goto L7;
        return mapDocTypes((DoubaoDocTypes) r2);
    L7:
        throw new NoWhenBranchMatchedException();
    }

    public final List<Integer> mapDocTypesToRecentObjTypeList(DocTypes r5) {
        Intrinsics.checkNotNullParameter(r5, "docTypes");
        if (Intrinsics.areEqual(r5, DocTypes.ALL.INSTANCE) == false) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r5, DocTypes.NONE.INSTANCE) == false) goto L9;
        return CollectionsKt.emptyList();
    L9:
        if ((r5 instanceof DocTypes.NEW) == false) goto L33;
        Set<DocType> r6 = r5.getTypes();
        ArrayList r0 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L27;
        switch(WhenMappings.$EnumSwitchMapping$1[((DocType) r7.next()).ordinal()]) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L16;
            default: goto L15;
        };
    L15:
        Integer r2 = null;
    L25:
        if (r2 == null) goto L12;
        r0.add(r2);
        goto L12
    L16:
        r2 = 16;
        goto L25
    L17:
        r2 = 0;
        goto L25
    L18:
        r2 = 2;
        goto L25
    L19:
        r2 = 30;
        goto L25
    L20:
        r2 = 3;
        goto L25
    L21:
        r2 = 12;
        goto L25
    L22:
        r2 = 22;
        goto L25
    L23:
        r2 = 11;
        goto L25
    L24:
        r2 = 8;
        goto L25
    L27:
        List<Integer> r8 = CollectionsKt.distinct(r0);
        if (r8.isEmpty() == false) goto L31;
        return null;
    L31:
        return r8;
    L33:
        throw new NoWhenBranchMatchedException();
    }

    public final DoubaoPickerEntity toDoubaoEntity(SearchBaseInfo r7) {
        Intrinsics.checkNotNullParameter(r7, "info");
        Log.i(TAG, r7.getId());
        if ((r7 instanceof SearchSpaceInfo) == false) goto L10;
        SearchSpaceInfo r8 = (SearchSpaceInfo) r7;
        Integer r0 = mapPbDocTypeToCcmDocumentTypeValue(r8.getDocType());
        if (r0 == null) goto L7;
        int r1 = r0.intValue();
    L8:
        DoubaoPickerEntity r2 = new DoubaoPickerEntity();
        r2.setFileType(r1);
        r2.setFileName(r8.getTitle());
        r2.setFileToken(r8.getToken());
        r2.setFileURL(r8.getDocUrl());
        r2.setOpenTime(r8.getLastOpenTime());
        r2.setEditTime(r8.getUpdateTime());
        r2.setIconInfo(r8.getIconInfo());
        r2.setBitableBizType(r8.getBitableBizType());
        r2.setOwner(Intrinsics.areEqual(PickerBaseModuleDependency.getDependency().getLoginUserId(), r8.getOwnerId()));
        return r2;
    L7:
        r1 = r8.getDocType().getValue();
        goto L8
    L10:
        if ((r7 instanceof SearchWikiInfo) == false) goto L37;
        SearchWikiInfo r9 = (SearchWikiInfo) r7;
        SearchSpaceInfo r3 = r9.getSpaceInfo();
        if (r3 == null) goto L15;
        String r4 = r3.getTitle();
        if (r4 == null) goto L15;
    L16:
        String r5 = "";
        if (r4 != null) goto L19;
        r4 = "";
    L19:
        if (r3 == null) goto L22;
        String r6 = r3.getDocUrl();
        if (r6 == null) goto L22;
    L23:
        if (r6 != null) goto L25;
        r6 = "";
    L25:
        String r10 = r3.getId();
        if (r10 != null) goto L28;
        r10 = r9.getId();
    L28:
        if (r10 == null) goto L31;
        r5 = r10;
    L31:
        String r11 = r3.getIconInfo();
        Integer r12 = mapPbDocTypeToCcmDocumentTypeValue(r3.getDocType());
        if (r12 == null) goto L34;
        int r13 = r12.intValue();
    L35:
        DoubaoPickerEntity r14 = new DoubaoPickerEntity();
        r14.setFileType(r13);
        r14.setFileName(r4);
        r14.setFileToken(r5);
        r14.setFileURL(r6);
        r14.setOpenTime(r3.getLastOpenTime());
        r14.setEditTime(r3.getUpdateTime());
        r14.setIconInfo(r11);
        r14.setBitableBizType(r3.getBitableBizType());
        r14.setOwner(Intrinsics.areEqual(PickerBaseModuleDependency.getDependency().getLoginUserId(), r3.getOwnerId()));
        return r14;
    L34:
        r13 = r3.getDocType().getValue();
    L22:
        r6 = r9.getUrl();
    L15:
        r4 = r9.getTitle();
        goto L16
    L37:
        return new DoubaoPickerEntity();
    }
}
